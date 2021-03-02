package com.facebook.login;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int CHALLENGE_LENGTH = 20;
    private static final String[] CHROME_PACKAGES = {"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};
    public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new Parcelable.Creator() {
        /* class com.facebook.login.CustomTabLoginMethodHandler.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final CustomTabLoginMethodHandler createFromParcel(Parcel parcel) {
            AppMethodBeat.i(7719);
            CustomTabLoginMethodHandler customTabLoginMethodHandler = new CustomTabLoginMethodHandler(parcel);
            AppMethodBeat.o(7719);
            return customTabLoginMethodHandler;
        }

        @Override // android.os.Parcelable.Creator
        public final CustomTabLoginMethodHandler[] newArray(int i2) {
            return new CustomTabLoginMethodHandler[i2];
        }
    };
    private static final String CUSTOM_TABS_SERVICE_ACTION = "android.support.customtabs.action.CustomTabsService";
    private static final int CUSTOM_TAB_REQUEST_CODE = 1;
    private String currentPackage;
    private String expectedChallenge;

    static {
        AppMethodBeat.i(7734);
        AppMethodBeat.o(7734);
    }

    CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        AppMethodBeat.i(7722);
        this.expectedChallenge = Utility.generateRandomString(20);
        AppMethodBeat.o(7722);
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public String getNameForLogging() {
        return "custom_tab";
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.WebLoginMethodHandler
    public AccessTokenSource getTokenSource() {
        return AccessTokenSource.CHROME_CUSTOM_TAB;
    }

    /* access modifiers changed from: protected */
    @Override // com.facebook.login.WebLoginMethodHandler
    public String getSSODevice() {
        return "chrome_custom_tab";
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public boolean tryAuthorize(LoginClient.Request request) {
        AppMethodBeat.i(7723);
        if (!isCustomTabsAllowed()) {
            AppMethodBeat.o(7723);
            return false;
        }
        Bundle addExtraParameters = addExtraParameters(getParameters(request), request);
        Intent intent = new Intent(this.loginClient.getActivity(), CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, addExtraParameters);
        intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, getChromePackage());
        this.loginClient.getFragment().startActivityForResult(intent, 1);
        AppMethodBeat.o(7723);
        return true;
    }

    private boolean isCustomTabsAllowed() {
        AppMethodBeat.i(7724);
        if (!isCustomTabsEnabled() || getChromePackage() == null || !isCustomTabsCompatibleWithAutofill() || !Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext())) {
            AppMethodBeat.o(7724);
            return false;
        }
        AppMethodBeat.o(7724);
        return true;
    }

    private boolean isCustomTabsEnabled() {
        AppMethodBeat.i(7725);
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(Utility.getMetadataApplicationId(this.loginClient.getActivity()));
        if (appSettingsWithoutQuery == null || !appSettingsWithoutQuery.getCustomTabsEnabled()) {
            AppMethodBeat.o(7725);
            return false;
        }
        AppMethodBeat.o(7725);
        return true;
    }

    private String getChromePackage() {
        AppMethodBeat.i(7726);
        if (this.currentPackage != null) {
            String str = this.currentPackage;
            AppMethodBeat.o(7726);
            return str;
        }
        FragmentActivity activity = this.loginClient.getActivity();
        List<ResolveInfo> queryIntentServices = activity.getPackageManager().queryIntentServices(new Intent(CUSTOM_TABS_SERVICE_ACTION), 0);
        if (queryIntentServices != null) {
            HashSet hashSet = new HashSet(Arrays.asList(CHROME_PACKAGES));
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null && hashSet.contains(serviceInfo.packageName)) {
                    this.currentPackage = serviceInfo.packageName;
                    String str2 = this.currentPackage;
                    AppMethodBeat.o(7726);
                    return str2;
                }
            }
        }
        AppMethodBeat.o(7726);
        return null;
    }

    private boolean isCustomTabsCompatibleWithAutofill() {
        AppMethodBeat.i(7727);
        if (!Utility.isAutofillAvailable(this.loginClient.getActivity())) {
            AppMethodBeat.o(7727);
            return true;
        }
        AppMethodBeat.o(7727);
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public boolean onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(7728);
        if (i2 != 1) {
            boolean onActivityResult = super.onActivityResult(i2, i3, intent);
            AppMethodBeat.o(7728);
            return onActivityResult;
        }
        LoginClient.Request pendingRequest = this.loginClient.getPendingRequest();
        if (i3 == -1) {
            onCustomTabComplete(intent.getStringExtra(CustomTabMainActivity.EXTRA_URL), pendingRequest);
            AppMethodBeat.o(7728);
            return true;
        }
        super.onComplete(pendingRequest, null, new FacebookOperationCanceledException());
        AppMethodBeat.o(7728);
        return false;
    }

    private void onCustomTabComplete(String str, LoginClient.Request request) {
        int i2;
        AppMethodBeat.i(7729);
        if (str != null && str.startsWith(CustomTabMainActivity.getRedirectUrl())) {
            Uri parse = Uri.parse(str);
            Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
            parseUrlQueryString.putAll(Utility.parseUrlQueryString(parse.getFragment()));
            if (!validateChallengeParam(parseUrlQueryString)) {
                super.onComplete(request, null, new FacebookException("Invalid state parameter"));
                AppMethodBeat.o(7729);
                return;
            }
            String string = parseUrlQueryString.getString("error");
            if (string == null) {
                string = parseUrlQueryString.getString(NativeProtocol.BRIDGE_ARG_ERROR_TYPE);
            }
            String string2 = parseUrlQueryString.getString("error_msg");
            if (string2 == null) {
                string2 = parseUrlQueryString.getString(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE);
            }
            if (string2 == null) {
                string2 = parseUrlQueryString.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
            }
            String string3 = parseUrlQueryString.getString("error_code");
            if (!Utility.isNullOrEmpty(string3)) {
                try {
                    i2 = Integer.parseInt(string3);
                } catch (NumberFormatException e2) {
                    i2 = -1;
                }
            } else {
                i2 = -1;
            }
            if (Utility.isNullOrEmpty(string) && Utility.isNullOrEmpty(string2) && i2 == -1) {
                super.onComplete(request, parseUrlQueryString, null);
                AppMethodBeat.o(7729);
                return;
            } else if (string != null && (string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) {
                super.onComplete(request, null, new FacebookOperationCanceledException());
                AppMethodBeat.o(7729);
                return;
            } else if (i2 == API_EC_DIALOG_CANCEL) {
                super.onComplete(request, null, new FacebookOperationCanceledException());
                AppMethodBeat.o(7729);
                return;
            } else {
                super.onComplete(request, null, new FacebookServiceException(new FacebookRequestError(i2, string, string2), string2));
            }
        }
        AppMethodBeat.o(7729);
    }

    /* access modifiers changed from: protected */
    @Override // com.facebook.login.LoginMethodHandler
    public void putChallengeParam(JSONObject jSONObject) {
        AppMethodBeat.i(7730);
        jSONObject.put("7_challenge", this.expectedChallenge);
        AppMethodBeat.o(7730);
    }

    private boolean validateChallengeParam(Bundle bundle) {
        AppMethodBeat.i(7731);
        try {
            String string = bundle.getString("state");
            if (string == null) {
                AppMethodBeat.o(7731);
                return false;
            }
            boolean equals = new JSONObject(string).getString("7_challenge").equals(this.expectedChallenge);
            AppMethodBeat.o(7731);
            return equals;
        } catch (JSONException e2) {
            AppMethodBeat.o(7731);
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    CustomTabLoginMethodHandler(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(7732);
        this.expectedChallenge = parcel.readString();
        AppMethodBeat.o(7732);
    }

    @Override // com.facebook.login.LoginMethodHandler
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(7733);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.expectedChallenge);
        AppMethodBeat.o(7733);
    }
}
