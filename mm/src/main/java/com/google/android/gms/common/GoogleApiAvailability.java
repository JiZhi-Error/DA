package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.s;
import android.util.TypedValue;
import android.widget.ProgressBar;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.GooglePlayServicesUpdatedReceiver;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zzbt;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.internal.ConnectionErrorMessages;
import com.google.android.gms.common.internal.DialogRedirect;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class GoogleApiAvailability extends GoogleApiAvailabilityLight {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final Object mLock = new Object();
    private static final GoogleApiAvailability zzas = new GoogleApiAvailability();
    private String zzat;

    /* access modifiers changed from: package-private */
    @SuppressLint({"HandlerLeak"})
    public class zza extends Handler {
        private final Context zzau;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public zza(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            AppMethodBeat.i(10907);
            this.zzau = context.getApplicationContext();
            AppMethodBeat.o(10907);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(10908);
            switch (message.what) {
                case 1:
                    int isGooglePlayServicesAvailable = GoogleApiAvailability.this.isGooglePlayServicesAvailable(this.zzau);
                    if (GoogleApiAvailability.this.isUserResolvableError(isGooglePlayServicesAvailable)) {
                        GoogleApiAvailability.this.showErrorNotification(this.zzau, isGooglePlayServicesAvailable);
                        AppMethodBeat.o(10908);
                        return;
                    }
                    break;
                default:
                    new StringBuilder(50).append("Don't know how to handle this message: ").append(message.what);
                    break;
            }
            AppMethodBeat.o(10908);
        }
    }

    static {
        AppMethodBeat.i(10942);
        AppMethodBeat.o(10942);
    }

    GoogleApiAvailability() {
    }

    public static GoogleApiAvailability getInstance() {
        return zzas;
    }

    static Dialog zza(Context context, int i2, DialogRedirect dialogRedirect, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        AppMethodBeat.i(10937);
        if (i2 == 0) {
            AppMethodBeat.o(10937);
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(ConnectionErrorMessages.getErrorMessage(context, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String errorDialogButtonMessage = ConnectionErrorMessages.getErrorDialogButtonMessage(context, i2);
        if (errorDialogButtonMessage != null) {
            builder.setPositiveButton(errorDialogButtonMessage, dialogRedirect);
        }
        String errorTitle = ConnectionErrorMessages.getErrorTitle(context, i2);
        if (errorTitle != null) {
            builder.setTitle(errorTitle);
        }
        AlertDialog create = builder.create();
        AppMethodBeat.o(10937);
        return create;
    }

    @TargetApi(26)
    private final String zza(Context context, NotificationManager notificationManager) {
        AppMethodBeat.i(10940);
        Preconditions.checkState(PlatformVersion.isAtLeastO());
        String zzb = zzb();
        if (zzb == null) {
            zzb = "com.google.android.gms.availability";
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(zzb);
            String defaultNotificationChannelName = ConnectionErrorMessages.getDefaultNotificationChannelName(context);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(new NotificationChannel(zzb, defaultNotificationChannelName, 4));
            } else if (!defaultNotificationChannelName.equals(notificationChannel.getName())) {
                notificationChannel.setName(defaultNotificationChannelName);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        AppMethodBeat.o(10940);
        return zzb;
    }

    static void zza(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(10938);
        if (activity instanceof FragmentActivity) {
            SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
            AppMethodBeat.o(10938);
            return;
        }
        ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        AppMethodBeat.o(10938);
    }

    private final String zzb() {
        String str;
        synchronized (mLock) {
            str = this.zzat;
        }
        return str;
    }

    public Task<Void> checkApiAvailability(GoogleApi<?> googleApi, GoogleApi<?>... googleApiArr) {
        AppMethodBeat.i(10921);
        Task<TContinuationResult> continueWith = checkApiAvailabilityAndPackages(googleApi, googleApiArr).continueWith(new zza(this));
        AppMethodBeat.o(10921);
        return continueWith;
    }

    public Task<Map<zzh<?>, String>> checkApiAvailabilityAndPackages(GoogleApi<?> googleApi, GoogleApi<?>... googleApiArr) {
        AppMethodBeat.i(10922);
        Preconditions.checkNotNull(googleApi, "Requested API must not be null.");
        for (GoogleApi<?> googleApi2 : googleApiArr) {
            Preconditions.checkNotNull(googleApi2, "Requested API must not be null.");
        }
        ArrayList arrayList = new ArrayList(googleApiArr.length + 1);
        arrayList.add(googleApi);
        arrayList.addAll(Arrays.asList(googleApiArr));
        Task<Map<zzh<?>, String>> zza2 = GoogleApiManager.zzbf().zza(arrayList);
        AppMethodBeat.o(10922);
        return zza2;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public int getApkVersion(Context context) {
        AppMethodBeat.i(10933);
        int apkVersion = super.getApkVersion(context);
        AppMethodBeat.o(10933);
        return apkVersion;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public int getClientVersion(Context context) {
        AppMethodBeat.i(10932);
        int clientVersion = super.getClientVersion(context);
        AppMethodBeat.o(10932);
        return clientVersion;
    }

    public Dialog getErrorDialog(Activity activity, int i2, int i3) {
        AppMethodBeat.i(10910);
        Dialog errorDialog = getErrorDialog(activity, i2, i3, null);
        AppMethodBeat.o(10910);
        return errorDialog;
    }

    public Dialog getErrorDialog(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(10911);
        Dialog zza2 = zza(activity, i2, DialogRedirect.getInstance(activity, getErrorResolutionIntent(activity, i2, "d"), i3), onCancelListener);
        AppMethodBeat.o(10911);
        return zza2;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @Deprecated
    public Intent getErrorResolutionIntent(int i2) {
        AppMethodBeat.i(10927);
        Intent errorResolutionIntent = super.getErrorResolutionIntent(i2);
        AppMethodBeat.o(10927);
        return errorResolutionIntent;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public Intent getErrorResolutionIntent(Context context, int i2, String str) {
        AppMethodBeat.i(10928);
        Intent errorResolutionIntent = super.getErrorResolutionIntent(context, i2, str);
        AppMethodBeat.o(10928);
        return errorResolutionIntent;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public PendingIntent getErrorResolutionPendingIntent(Context context, int i2, int i3) {
        AppMethodBeat.i(10929);
        PendingIntent errorResolutionPendingIntent = super.getErrorResolutionPendingIntent(context, i2, i3);
        AppMethodBeat.o(10929);
        return errorResolutionPendingIntent;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public PendingIntent getErrorResolutionPendingIntent(Context context, int i2, int i3, String str) {
        AppMethodBeat.i(10931);
        PendingIntent errorResolutionPendingIntent = super.getErrorResolutionPendingIntent(context, i2, i3, str);
        AppMethodBeat.o(10931);
        return errorResolutionPendingIntent;
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, ConnectionResult connectionResult) {
        AppMethodBeat.i(10930);
        if (connectionResult.hasResolution()) {
            PendingIntent resolution = connectionResult.getResolution();
            AppMethodBeat.o(10930);
            return resolution;
        }
        PendingIntent errorResolutionPendingIntent = getErrorResolutionPendingIntent(context, connectionResult.getErrorCode(), 0);
        AppMethodBeat.o(10930);
        return errorResolutionPendingIntent;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final String getErrorString(int i2) {
        AppMethodBeat.i(10936);
        String errorString = super.getErrorString(i2);
        AppMethodBeat.o(10936);
        return errorString;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public int isGooglePlayServicesAvailable(Context context) {
        AppMethodBeat.i(10924);
        int isGooglePlayServicesAvailable = super.isGooglePlayServicesAvailable(context);
        AppMethodBeat.o(10924);
        return isGooglePlayServicesAvailable;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public int isGooglePlayServicesAvailable(Context context, int i2) {
        AppMethodBeat.i(10925);
        int isGooglePlayServicesAvailable = super.isGooglePlayServicesAvailable(context, i2);
        AppMethodBeat.o(10925);
        return isGooglePlayServicesAvailable;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public boolean isPlayServicesPossiblyUpdating(Context context, int i2) {
        AppMethodBeat.i(10934);
        boolean isPlayServicesPossiblyUpdating = super.isPlayServicesPossiblyUpdating(context, i2);
        AppMethodBeat.o(10934);
        return isPlayServicesPossiblyUpdating;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public boolean isPlayStorePossiblyUpdating(Context context, int i2) {
        AppMethodBeat.i(10935);
        boolean isPlayStorePossiblyUpdating = super.isPlayStorePossiblyUpdating(context, i2);
        AppMethodBeat.o(10935);
        return isPlayStorePossiblyUpdating;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final boolean isUserResolvableError(int i2) {
        AppMethodBeat.i(10926);
        boolean isUserResolvableError = super.isUserResolvableError(i2);
        AppMethodBeat.o(10926);
        return isUserResolvableError;
    }

    public Task<Void> makeGooglePlayServicesAvailable(Activity activity) {
        AppMethodBeat.i(10909);
        Preconditions.checkMainThread("makeGooglePlayServicesAvailable must be called from the main thread");
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable == 0) {
            Task<Void> forResult = Tasks.forResult(null);
            AppMethodBeat.o(10909);
            return forResult;
        }
        zzbt zzd = zzbt.zzd(activity);
        zzd.zzb(new ConnectionResult(isGooglePlayServicesAvailable, null), 0);
        Task<Void> task = zzd.getTask();
        AppMethodBeat.o(10909);
        return task;
    }

    public GooglePlayServicesUpdatedReceiver registerCallbackOnUpdate(Context context, GooglePlayServicesUpdatedReceiver.Callback callback) {
        AppMethodBeat.i(10920);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        GooglePlayServicesUpdatedReceiver googlePlayServicesUpdatedReceiver = new GooglePlayServicesUpdatedReceiver(callback);
        context.registerReceiver(googlePlayServicesUpdatedReceiver, intentFilter);
        googlePlayServicesUpdatedReceiver.zzc(context);
        if (!isUninstalledAppPossiblyUpdating(context, "com.google.android.gms")) {
            callback.zzv();
            googlePlayServicesUpdatedReceiver.unregister();
            AppMethodBeat.o(10920);
            return null;
        }
        AppMethodBeat.o(10920);
        return googlePlayServicesUpdatedReceiver;
    }

    @TargetApi(26)
    public void setDefaultNotificationChannelId(Context context, String str) {
        AppMethodBeat.i(10923);
        if (PlatformVersion.isAtLeastO()) {
            Preconditions.checkNotNull(((NotificationManager) context.getSystemService("notification")).getNotificationChannel(str));
        }
        synchronized (mLock) {
            try {
                this.zzat = str;
            } finally {
                AppMethodBeat.o(10923);
            }
        }
    }

    public boolean showErrorDialogFragment(Activity activity, int i2, int i3) {
        AppMethodBeat.i(10912);
        boolean showErrorDialogFragment = showErrorDialogFragment(activity, i2, i3, null);
        AppMethodBeat.o(10912);
        return showErrorDialogFragment;
    }

    public boolean showErrorDialogFragment(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(10914);
        Dialog errorDialog = getErrorDialog(activity, i2, i3, onCancelListener);
        if (errorDialog == null) {
            AppMethodBeat.o(10914);
            return false;
        }
        zza(activity, errorDialog, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        AppMethodBeat.o(10914);
        return true;
    }

    public boolean showErrorDialogFragment(Activity activity, LifecycleFragment lifecycleFragment, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(10913);
        Dialog zza2 = zza(activity, i2, DialogRedirect.getInstance(lifecycleFragment, getErrorResolutionIntent(activity, i2, "d"), i3), onCancelListener);
        if (zza2 == null) {
            AppMethodBeat.o(10913);
            return false;
        }
        zza(activity, zza2, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        AppMethodBeat.o(10913);
        return true;
    }

    public void showErrorNotification(Context context, int i2) {
        AppMethodBeat.i(10915);
        showErrorNotification(context, i2, null);
        AppMethodBeat.o(10915);
    }

    public void showErrorNotification(Context context, int i2, String str) {
        AppMethodBeat.i(10916);
        zza(context, i2, str, getErrorResolutionPendingIntent(context, i2, 0, "n"));
        AppMethodBeat.o(10916);
    }

    public void showErrorNotification(Context context, ConnectionResult connectionResult) {
        AppMethodBeat.i(10917);
        zza(context, connectionResult.getErrorCode(), (String) null, getErrorResolutionPendingIntent(context, connectionResult));
        AppMethodBeat.o(10917);
    }

    public Dialog showUpdatingDialog(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(10919);
        ProgressBar progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(ConnectionErrorMessages.getErrorMessage(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        zza(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        AppMethodBeat.o(10919);
        return create;
    }

    public boolean showWrappedErrorNotification(Context context, ConnectionResult connectionResult, int i2) {
        AppMethodBeat.i(10918);
        PendingIntent errorResolutionPendingIntent = getErrorResolutionPendingIntent(context, connectionResult);
        if (errorResolutionPendingIntent != null) {
            zza(context, connectionResult.getErrorCode(), (String) null, GoogleApiActivity.zza(context, errorResolutionPendingIntent, i2));
            AppMethodBeat.o(10918);
            return true;
        }
        AppMethodBeat.o(10918);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(Context context) {
        AppMethodBeat.i(10941);
        new zza(context).sendEmptyMessageDelayed(1, 120000);
        AppMethodBeat.o(10941);
    }

    @TargetApi(20)
    private final void zza(Context context, int i2, String str, PendingIntent pendingIntent) {
        Notification build;
        int i3;
        AppMethodBeat.i(10939);
        if (i2 == 18) {
            zza(context);
            AppMethodBeat.o(10939);
        } else if (pendingIntent == null) {
            AppMethodBeat.o(10939);
        } else {
            String errorNotificationTitle = ConnectionErrorMessages.getErrorNotificationTitle(context, i2);
            String errorNotificationMessage = ConnectionErrorMessages.getErrorNotificationMessage(context, i2);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (DeviceProperties.isWearable(context)) {
                Preconditions.checkState(PlatformVersion.isAtLeastKitKatWatch());
                Notification.Builder style = new Notification.Builder(context).setSmallIcon(context.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(errorNotificationTitle).setStyle(new Notification.BigTextStyle().bigText(errorNotificationMessage));
                if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                    style.addAction(R.drawable.bc5, resources.getString(R.string.common_open_on_phone), pendingIntent);
                } else {
                    style.setContentIntent(pendingIntent);
                }
                if (PlatformVersion.isAtLeastO() && PlatformVersion.isAtLeastO()) {
                    style.setChannelId(zza(context, notificationManager));
                }
                build = style.build();
            } else {
                s.c E = new s.c(context).as(17301642).i(resources.getString(R.string.common_google_play_services_notification_ticker)).i(System.currentTimeMillis()).E(true);
                E.Hv = pendingIntent;
                s.c g2 = E.f(errorNotificationTitle).g(errorNotificationMessage);
                g2.HM = true;
                s.c a2 = g2.a(new s.b().e(errorNotificationMessage));
                if (PlatformVersion.isAtLeastO() && PlatformVersion.isAtLeastO()) {
                    a2.mChannelId = zza(context, notificationManager);
                }
                build = a2.build();
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    i3 = 10436;
                    GooglePlayServicesUtilLight.zzbt.set(false);
                    break;
                default:
                    i3 = 39789;
                    break;
            }
            if (str == null) {
                notificationManager.notify(i3, build);
                AppMethodBeat.o(10939);
                return;
            }
            notificationManager.notify(str, i3, build);
            AppMethodBeat.o(10939);
        }
    }
}
