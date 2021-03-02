package com.facebook.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceAuthDialog extends DialogFragment {
    private static final String DEVICE_LOGIN_ENDPOINT = "device/login";
    private static final String DEVICE_LOGIN_STATUS_ENDPOINT = "device/login_status";
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED = 1349173;
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING = 1349174;
    private static final int LOGIN_ERROR_SUBCODE_CODE_EXPIRED = 1349152;
    private static final int LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING = 1349172;
    private static final String REQUEST_STATE_KEY = "request_state";
    private AtomicBoolean completed = new AtomicBoolean();
    private TextView confirmationCode;
    private volatile GraphRequestAsyncTask currentGraphRequestPoll;
    private volatile RequestState currentRequestState;
    private DeviceAuthMethodHandler deviceAuthMethodHandler;
    private Dialog dialog;
    private TextView instructions;
    private boolean isBeingDestroyed = false;
    private boolean isRetry = false;
    private LoginClient.Request mRequest = null;
    private View progressBar;
    private volatile ScheduledFuture scheduledPoll;

    public DeviceAuthDialog() {
        AppMethodBeat.i(7750);
        AppMethodBeat.o(7750);
    }

    static /* synthetic */ void access$100(DeviceAuthDialog deviceAuthDialog, RequestState requestState) {
        AppMethodBeat.i(7767);
        deviceAuthDialog.setCurrentRequestState(requestState);
        AppMethodBeat.o(7767);
    }

    static /* synthetic */ void access$1100(DeviceAuthDialog deviceAuthDialog, String str, Utility.PermissionsPair permissionsPair, String str2, String str3, Date date, Date date2) {
        AppMethodBeat.i(7772);
        deviceAuthDialog.presentConfirmation(str, permissionsPair, str2, str3, date, date2);
        AppMethodBeat.o(7772);
    }

    static /* synthetic */ void access$200(DeviceAuthDialog deviceAuthDialog) {
        AppMethodBeat.i(7768);
        deviceAuthDialog.poll();
        AppMethodBeat.o(7768);
    }

    static /* synthetic */ void access$400(DeviceAuthDialog deviceAuthDialog) {
        AppMethodBeat.i(7769);
        deviceAuthDialog.schedulePoll();
        AppMethodBeat.o(7769);
    }

    static /* synthetic */ void access$700(DeviceAuthDialog deviceAuthDialog, String str, Long l, Long l2) {
        AppMethodBeat.i(7770);
        deviceAuthDialog.onSuccess(str, l, l2);
        AppMethodBeat.o(7770);
    }

    static /* synthetic */ void access$900(DeviceAuthDialog deviceAuthDialog, String str, Utility.PermissionsPair permissionsPair, String str2, Date date, Date date2) {
        AppMethodBeat.i(7771);
        deviceAuthDialog.completeLogin(str, permissionsPair, str2, date, date2);
        AppMethodBeat.o(7771);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        AppMethodBeat.i(7751);
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.deviceAuthMethodHandler = (DeviceAuthMethodHandler) ((LoginFragment) ((FacebookActivity) getActivity()).getCurrentFragment()).getLoginClient().getCurrentHandler();
        if (!(bundle == null || (requestState = (RequestState) bundle.getParcelable(REQUEST_STATE_KEY)) == null)) {
            setCurrentRequestState(requestState);
        }
        AppMethodBeat.o(7751);
        return onCreateView;
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AppMethodBeat.i(7752);
        this.dialog = new Dialog(getActivity(), R.style.a5d);
        this.dialog.setContentView(initializeContentView(DeviceRequestsHelper.isAvailable() && !this.isRetry));
        Dialog dialog2 = this.dialog;
        AppMethodBeat.o(7752);
        return dialog2;
    }

    @Override // android.support.v4.app.DialogFragment
    public void onDismiss(DialogInterface dialogInterface) {
        AppMethodBeat.i(7753);
        super.onDismiss(dialogInterface);
        if (!this.isBeingDestroyed) {
            onCancel();
        }
        AppMethodBeat.o(7753);
    }

    @Override // android.support.v4.app.Fragment, android.support.v4.app.DialogFragment
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(7754);
        super.onSaveInstanceState(bundle);
        if (this.currentRequestState != null) {
            bundle.putParcelable(REQUEST_STATE_KEY, this.currentRequestState);
        }
        AppMethodBeat.o(7754);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        AppMethodBeat.i(7755);
        this.isBeingDestroyed = true;
        this.completed.set(true);
        super.onDestroy();
        if (this.currentGraphRequestPoll != null) {
            this.currentGraphRequestPoll.cancel(true);
        }
        if (this.scheduledPoll != null) {
            this.scheduledPoll.cancel(true);
        }
        AppMethodBeat.o(7755);
    }

    public void startLogin(LoginClient.Request request) {
        AppMethodBeat.i(7756);
        this.mRequest = request;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request.getPermissions()));
        String deviceRedirectUriString = request.getDeviceRedirectUriString();
        if (deviceRedirectUriString != null) {
            bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, deviceRedirectUriString);
        }
        String deviceAuthTargetUserId = request.getDeviceAuthTargetUserId();
        if (deviceAuthTargetUserId != null) {
            bundle.putString(DeviceRequestsHelper.DEVICE_TARGET_USER_ID, deviceAuthTargetUserId);
        }
        bundle.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
        bundle.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, DeviceRequestsHelper.getDeviceInfo());
        new GraphRequest(null, DEVICE_LOGIN_ENDPOINT, bundle, HttpMethod.POST, new GraphRequest.Callback() {
            /* class com.facebook.login.DeviceAuthDialog.AnonymousClass1 */

            @Override // com.facebook.GraphRequest.Callback
            public void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(7735);
                if (DeviceAuthDialog.this.isBeingDestroyed) {
                    AppMethodBeat.o(7735);
                } else if (graphResponse.getError() != null) {
                    DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                    AppMethodBeat.o(7735);
                } else {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    RequestState requestState = new RequestState();
                    try {
                        requestState.setUserCode(jSONObject.getString("user_code"));
                        requestState.setRequestCode(jSONObject.getString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE));
                        requestState.setInterval(jSONObject.getLong("interval"));
                        DeviceAuthDialog.access$100(DeviceAuthDialog.this, requestState);
                        AppMethodBeat.o(7735);
                    } catch (JSONException e2) {
                        DeviceAuthDialog.this.onError(new FacebookException(e2));
                        AppMethodBeat.o(7735);
                    }
                }
            }
        }).executeAsync();
        AppMethodBeat.o(7756);
    }

    private void setCurrentRequestState(RequestState requestState) {
        AppMethodBeat.i(7757);
        this.currentRequestState = requestState;
        this.confirmationCode.setText(requestState.getUserCode());
        this.instructions.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, new BitmapDrawable(getResources(), DeviceRequestsHelper.generateQRCode(requestState.getAuthorizationUri())), (Drawable) null, (Drawable) null);
        this.confirmationCode.setVisibility(0);
        this.progressBar.setVisibility(8);
        if (!this.isRetry && DeviceRequestsHelper.startAdvertisementService(requestState.getUserCode())) {
            AppEventsLogger.newLogger(getContext()).logSdkEvent(AnalyticsEvents.EVENT_SMART_LOGIN_SERVICE, null, null);
        }
        if (requestState.withinLastRefreshWindow()) {
            schedulePoll();
            AppMethodBeat.o(7757);
            return;
        }
        poll();
        AppMethodBeat.o(7757);
    }

    /* access modifiers changed from: protected */
    public View initializeContentView(boolean z) {
        AppMethodBeat.i(7758);
        View inflate = getActivity().getLayoutInflater().inflate(getLayoutResId(z), (ViewGroup) null);
        this.progressBar = inflate.findViewById(R.id.gl_);
        this.confirmationCode = (TextView) inflate.findViewById(R.id.b_o);
        ((Button) inflate.findViewById(R.id.aic)).setOnClickListener(new View.OnClickListener() {
            /* class com.facebook.login.DeviceAuthDialog.AnonymousClass2 */

            public void onClick(View view) {
                AppMethodBeat.i(7736);
                DeviceAuthDialog.this.onCancel();
                AppMethodBeat.o(7736);
            }
        });
        this.instructions = (TextView) inflate.findViewById(R.id.b85);
        this.instructions.setText(Html.fromHtml(getString(R.string.b7y)));
        AppMethodBeat.o(7758);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResId(boolean z) {
        return z ? R.layout.vi : R.layout.vg;
    }

    private void poll() {
        AppMethodBeat.i(7759);
        this.currentRequestState.setLastPoll(new Date().getTime());
        this.currentGraphRequestPoll = getPollRequest().executeAsync();
        AppMethodBeat.o(7759);
    }

    private void schedulePoll() {
        AppMethodBeat.i(7760);
        this.scheduledPoll = DeviceAuthMethodHandler.getBackgroundExecutor().schedule(new Runnable() {
            /* class com.facebook.login.DeviceAuthDialog.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(7737);
                DeviceAuthDialog.access$200(DeviceAuthDialog.this);
                AppMethodBeat.o(7737);
            }
        }, this.currentRequestState.getInterval(), TimeUnit.SECONDS);
        AppMethodBeat.o(7760);
    }

    private GraphRequest getPollRequest() {
        AppMethodBeat.i(7761);
        Bundle bundle = new Bundle();
        bundle.putString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, this.currentRequestState.getRequestCode());
        GraphRequest graphRequest = new GraphRequest(null, DEVICE_LOGIN_STATUS_ENDPOINT, bundle, HttpMethod.POST, new GraphRequest.Callback() {
            /* class com.facebook.login.DeviceAuthDialog.AnonymousClass4 */

            @Override // com.facebook.GraphRequest.Callback
            public void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(7738);
                if (DeviceAuthDialog.this.completed.get()) {
                    AppMethodBeat.o(7738);
                    return;
                }
                FacebookRequestError error = graphResponse.getError();
                if (error != null) {
                    switch (error.getSubErrorCode()) {
                        case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_CODE_EXPIRED /*{ENCODED_INT: 1349152}*/:
                            if (DeviceAuthDialog.this.currentRequestState != null) {
                                DeviceRequestsHelper.cleanUpAdvertisementService(DeviceAuthDialog.this.currentRequestState.getUserCode());
                            }
                            if (DeviceAuthDialog.this.mRequest != null) {
                                DeviceAuthDialog.this.startLogin(DeviceAuthDialog.this.mRequest);
                                AppMethodBeat.o(7738);
                                return;
                            }
                            DeviceAuthDialog.this.onCancel();
                            AppMethodBeat.o(7738);
                            return;
                        case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING /*{ENCODED_INT: 1349172}*/:
                        case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING /*{ENCODED_INT: 1349174}*/:
                            DeviceAuthDialog.access$400(DeviceAuthDialog.this);
                            AppMethodBeat.o(7738);
                            return;
                        case DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED /*{ENCODED_INT: 1349173}*/:
                            DeviceAuthDialog.this.onCancel();
                            AppMethodBeat.o(7738);
                            return;
                        default:
                            DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                            AppMethodBeat.o(7738);
                            return;
                    }
                } else {
                    try {
                        JSONObject jSONObject = graphResponse.getJSONObject();
                        DeviceAuthDialog.access$700(DeviceAuthDialog.this, jSONObject.getString("access_token"), Long.valueOf(jSONObject.getLong(AccessToken.EXPIRES_IN_KEY)), Long.valueOf(jSONObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
                        AppMethodBeat.o(7738);
                    } catch (JSONException e2) {
                        DeviceAuthDialog.this.onError(new FacebookException(e2));
                        AppMethodBeat.o(7738);
                    }
                }
            }
        });
        AppMethodBeat.o(7761);
        return graphRequest;
    }

    private void presentConfirmation(final String str, final Utility.PermissionsPair permissionsPair, final String str2, String str3, final Date date, final Date date2) {
        AppMethodBeat.i(7762);
        String string = getResources().getString(R.string.b8i);
        String string2 = getResources().getString(R.string.b8h);
        String string3 = getResources().getString(R.string.b8g);
        String format = String.format(string2, str3);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(string).setCancelable(true).setNegativeButton(format, new DialogInterface.OnClickListener() {
            /* class com.facebook.login.DeviceAuthDialog.AnonymousClass6 */

            public void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(7740);
                DeviceAuthDialog.access$900(DeviceAuthDialog.this, str, permissionsPair, str2, date, date2);
                AppMethodBeat.o(7740);
            }
        }).setPositiveButton(string3, new DialogInterface.OnClickListener() {
            /* class com.facebook.login.DeviceAuthDialog.AnonymousClass5 */

            public void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(7739);
                DeviceAuthDialog.this.dialog.setContentView(DeviceAuthDialog.this.initializeContentView(false));
                DeviceAuthDialog.this.startLogin(DeviceAuthDialog.this.mRequest);
                AppMethodBeat.o(7739);
            }
        });
        builder.create().show();
        AppMethodBeat.o(7762);
    }

    private void onSuccess(final String str, Long l, Long l2) {
        AppMethodBeat.i(7763);
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,permissions,name");
        final Date date = l.longValue() != 0 ? new Date(new Date().getTime() + (l.longValue() * 1000)) : null;
        final Date date2 = (l2.longValue() == 0 || l2 == null) ? null : new Date(l2.longValue() * 1000);
        new GraphRequest(new AccessToken(str, FacebookSdk.getApplicationId(), AppEventsConstants.EVENT_PARAM_VALUE_NO, null, null, null, date, null, date2), "me", bundle, HttpMethod.GET, new GraphRequest.Callback() {
            /* class com.facebook.login.DeviceAuthDialog.AnonymousClass7 */

            @Override // com.facebook.GraphRequest.Callback
            public void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(7741);
                if (DeviceAuthDialog.this.completed.get()) {
                    AppMethodBeat.o(7741);
                } else if (graphResponse.getError() != null) {
                    DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                    AppMethodBeat.o(7741);
                } else {
                    try {
                        JSONObject jSONObject = graphResponse.getJSONObject();
                        String string = jSONObject.getString("id");
                        Utility.PermissionsPair handlePermissionResponse = Utility.handlePermissionResponse(jSONObject);
                        String string2 = jSONObject.getString("name");
                        DeviceRequestsHelper.cleanUpAdvertisementService(DeviceAuthDialog.this.currentRequestState.getUserCode());
                        if (!FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.RequireConfirm) || DeviceAuthDialog.this.isRetry) {
                            DeviceAuthDialog.access$900(DeviceAuthDialog.this, string, handlePermissionResponse, str, date, date2);
                            AppMethodBeat.o(7741);
                            return;
                        }
                        DeviceAuthDialog.this.isRetry = true;
                        DeviceAuthDialog.access$1100(DeviceAuthDialog.this, string, handlePermissionResponse, str, string2, date, date2);
                        AppMethodBeat.o(7741);
                    } catch (JSONException e2) {
                        DeviceAuthDialog.this.onError(new FacebookException(e2));
                        AppMethodBeat.o(7741);
                    }
                }
            }
        }).executeAsync();
        AppMethodBeat.o(7763);
    }

    private void completeLogin(String str, Utility.PermissionsPair permissionsPair, String str2, Date date, Date date2) {
        AppMethodBeat.i(7764);
        this.deviceAuthMethodHandler.onSuccess(str2, FacebookSdk.getApplicationId(), str, permissionsPair.getGrantedPermissions(), permissionsPair.getDeclinedPermissions(), AccessTokenSource.DEVICE_AUTH, date, null, date2);
        this.dialog.dismiss();
        AppMethodBeat.o(7764);
    }

    /* access modifiers changed from: protected */
    public void onError(FacebookException facebookException) {
        AppMethodBeat.i(7765);
        if (!this.completed.compareAndSet(false, true)) {
            AppMethodBeat.o(7765);
            return;
        }
        if (this.currentRequestState != null) {
            DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
        }
        this.deviceAuthMethodHandler.onError(facebookException);
        this.dialog.dismiss();
        AppMethodBeat.o(7765);
    }

    /* access modifiers changed from: protected */
    public void onCancel() {
        AppMethodBeat.i(7766);
        if (!this.completed.compareAndSet(false, true)) {
            AppMethodBeat.o(7766);
            return;
        }
        if (this.currentRequestState != null) {
            DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
        }
        if (this.deviceAuthMethodHandler != null) {
            this.deviceAuthMethodHandler.onCancel();
        }
        this.dialog.dismiss();
        AppMethodBeat.o(7766);
    }

    /* access modifiers changed from: package-private */
    public static class RequestState implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new Parcelable.Creator<RequestState>() {
            /* class com.facebook.login.DeviceAuthDialog.RequestState.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public final RequestState createFromParcel(Parcel parcel) {
                AppMethodBeat.i(7742);
                RequestState requestState = new RequestState(parcel);
                AppMethodBeat.o(7742);
                return requestState;
            }

            @Override // android.os.Parcelable.Creator
            public final RequestState[] newArray(int i2) {
                return new RequestState[i2];
            }
        };
        private String authorizationUri;
        private long interval;
        private long lastPoll;
        private String requestCode;
        private String userCode;

        RequestState() {
        }

        public String getAuthorizationUri() {
            return this.authorizationUri;
        }

        public String getUserCode() {
            return this.userCode;
        }

        public void setUserCode(String str) {
            AppMethodBeat.i(7745);
            this.userCode = str;
            this.authorizationUri = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", str);
            AppMethodBeat.o(7745);
        }

        public String getRequestCode() {
            return this.requestCode;
        }

        public void setRequestCode(String str) {
            this.requestCode = str;
        }

        public long getInterval() {
            return this.interval;
        }

        public void setInterval(long j2) {
            this.interval = j2;
        }

        public void setLastPoll(long j2) {
            this.lastPoll = j2;
        }

        protected RequestState(Parcel parcel) {
            AppMethodBeat.i(7746);
            this.authorizationUri = parcel.readString();
            this.userCode = parcel.readString();
            this.requestCode = parcel.readString();
            this.interval = parcel.readLong();
            this.lastPoll = parcel.readLong();
            AppMethodBeat.o(7746);
        }

        public boolean withinLastRefreshWindow() {
            AppMethodBeat.i(7747);
            if (this.lastPoll == 0) {
                AppMethodBeat.o(7747);
                return false;
            } else if ((new Date().getTime() - this.lastPoll) - (this.interval * 1000) < 0) {
                AppMethodBeat.o(7747);
                return true;
            } else {
                AppMethodBeat.o(7747);
                return false;
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(7748);
            parcel.writeString(this.authorizationUri);
            parcel.writeString(this.userCode);
            parcel.writeString(this.requestCode);
            parcel.writeLong(this.interval);
            parcel.writeLong(this.lastPoll);
            AppMethodBeat.o(7748);
        }

        static {
            AppMethodBeat.i(7749);
            AppMethodBeat.o(7749);
        }
    }
}
