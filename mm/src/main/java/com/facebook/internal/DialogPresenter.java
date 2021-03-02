package com.facebook.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DialogPresenter {

    public interface ParameterProvider {
        Bundle getLegacyParameters();

        Bundle getParameters();
    }

    public static void setupAppCallForCannotShowError(AppCall appCall) {
        AppMethodBeat.i(7639);
        setupAppCallForValidationError(appCall, new FacebookException("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
        AppMethodBeat.o(7639);
    }

    public static void setupAppCallForValidationError(AppCall appCall, FacebookException facebookException) {
        AppMethodBeat.i(7640);
        setupAppCallForErrorResult(appCall, facebookException);
        AppMethodBeat.o(7640);
    }

    public static void present(AppCall appCall, Activity activity) {
        AppMethodBeat.i(7641);
        activity.startActivityForResult(appCall.getRequestIntent(), appCall.getRequestCode());
        appCall.setPending();
        AppMethodBeat.o(7641);
    }

    public static void present(AppCall appCall, FragmentWrapper fragmentWrapper) {
        AppMethodBeat.i(7642);
        fragmentWrapper.startActivityForResult(appCall.getRequestIntent(), appCall.getRequestCode());
        appCall.setPending();
        AppMethodBeat.o(7642);
    }

    public static boolean canPresentNativeDialogWithFeature(DialogFeature dialogFeature) {
        AppMethodBeat.i(7643);
        if (getProtocolVersionForNativeDialog(dialogFeature).getProtocolVersion() != -1) {
            AppMethodBeat.o(7643);
            return true;
        }
        AppMethodBeat.o(7643);
        return false;
    }

    public static boolean canPresentWebFallbackDialogWithFeature(DialogFeature dialogFeature) {
        AppMethodBeat.i(7644);
        if (getDialogWebFallbackUri(dialogFeature) != null) {
            AppMethodBeat.o(7644);
            return true;
        }
        AppMethodBeat.o(7644);
        return false;
    }

    public static void setupAppCallForErrorResult(AppCall appCall, FacebookException facebookException) {
        AppMethodBeat.i(7645);
        if (facebookException == null) {
            AppMethodBeat.o(7645);
            return;
        }
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(FacebookActivity.PASS_THROUGH_CANCEL_ACTION);
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), null, NativeProtocol.getLatestKnownVersion(), NativeProtocol.createBundleForException(facebookException));
        appCall.setRequestIntent(intent);
        AppMethodBeat.o(7645);
    }

    public static void setupAppCallForWebDialog(AppCall appCall, String str, Bundle bundle) {
        AppMethodBeat.i(7646);
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        Bundle bundle2 = new Bundle();
        bundle2.putString(NativeProtocol.WEB_DIALOG_ACTION, str);
        bundle2.putBundle(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
        Intent intent = new Intent();
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), str, NativeProtocol.getLatestKnownVersion(), bundle2);
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(FacebookDialogFragment.TAG);
        appCall.setRequestIntent(intent);
        AppMethodBeat.o(7646);
    }

    public static void setupAppCallForWebFallbackDialog(AppCall appCall, Bundle bundle, DialogFeature dialogFeature) {
        Uri buildUri;
        AppMethodBeat.i(7647);
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        String name = dialogFeature.name();
        Uri dialogWebFallbackUri = getDialogWebFallbackUri(dialogFeature);
        if (dialogWebFallbackUri == null) {
            FacebookException facebookException = new FacebookException("Unable to fetch the Url for the DialogFeature : '" + name + "'");
            AppMethodBeat.o(7647);
            throw facebookException;
        }
        Bundle queryParamsForPlatformActivityIntentWebFallback = ServerProtocol.getQueryParamsForPlatformActivityIntentWebFallback(appCall.getCallId().toString(), NativeProtocol.getLatestKnownVersion(), bundle);
        if (queryParamsForPlatformActivityIntentWebFallback == null) {
            FacebookException facebookException2 = new FacebookException("Unable to fetch the app's key-hash");
            AppMethodBeat.o(7647);
            throw facebookException2;
        }
        if (dialogWebFallbackUri.isRelative()) {
            buildUri = Utility.buildUri(ServerProtocol.getDialogAuthority(), dialogWebFallbackUri.toString(), queryParamsForPlatformActivityIntentWebFallback);
        } else {
            buildUri = Utility.buildUri(dialogWebFallbackUri.getAuthority(), dialogWebFallbackUri.getPath(), queryParamsForPlatformActivityIntentWebFallback);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("url", buildUri.toString());
        bundle2.putBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, true);
        Intent intent = new Intent();
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), dialogFeature.getAction(), NativeProtocol.getLatestKnownVersion(), bundle2);
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(FacebookDialogFragment.TAG);
        appCall.setRequestIntent(intent);
        AppMethodBeat.o(7647);
    }

    public static void setupAppCallForNativeDialog(AppCall appCall, ParameterProvider parameterProvider, DialogFeature dialogFeature) {
        Bundle legacyParameters;
        AppMethodBeat.i(7648);
        Context applicationContext = FacebookSdk.getApplicationContext();
        String action = dialogFeature.getAction();
        NativeProtocol.ProtocolVersionQueryResult protocolVersionForNativeDialog = getProtocolVersionForNativeDialog(dialogFeature);
        int protocolVersion = protocolVersionForNativeDialog.getProtocolVersion();
        if (protocolVersion == -1) {
            FacebookException facebookException = new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
            AppMethodBeat.o(7648);
            throw facebookException;
        }
        if (NativeProtocol.isVersionCompatibleWithBucketedIntent(protocolVersion)) {
            legacyParameters = parameterProvider.getParameters();
        } else {
            legacyParameters = parameterProvider.getLegacyParameters();
        }
        if (legacyParameters == null) {
            legacyParameters = new Bundle();
        }
        Intent createPlatformActivityIntent = NativeProtocol.createPlatformActivityIntent(applicationContext, appCall.getCallId().toString(), action, protocolVersionForNativeDialog, legacyParameters);
        if (createPlatformActivityIntent == null) {
            FacebookException facebookException2 = new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
            AppMethodBeat.o(7648);
            throw facebookException2;
        }
        appCall.setRequestIntent(createPlatformActivityIntent);
        AppMethodBeat.o(7648);
    }

    private static Uri getDialogWebFallbackUri(DialogFeature dialogFeature) {
        AppMethodBeat.i(7649);
        String name = dialogFeature.name();
        FetchedAppSettings.DialogFeatureConfig dialogFeatureConfig = FetchedAppSettings.getDialogFeatureConfig(FacebookSdk.getApplicationId(), dialogFeature.getAction(), name);
        Uri uri = null;
        if (dialogFeatureConfig != null) {
            uri = dialogFeatureConfig.getFallbackUrl();
        }
        AppMethodBeat.o(7649);
        return uri;
    }

    public static NativeProtocol.ProtocolVersionQueryResult getProtocolVersionForNativeDialog(DialogFeature dialogFeature) {
        AppMethodBeat.i(7650);
        String applicationId = FacebookSdk.getApplicationId();
        String action = dialogFeature.getAction();
        NativeProtocol.ProtocolVersionQueryResult latestAvailableProtocolVersionForAction = NativeProtocol.getLatestAvailableProtocolVersionForAction(action, getVersionSpecForFeature(applicationId, action, dialogFeature));
        AppMethodBeat.o(7650);
        return latestAvailableProtocolVersionForAction;
    }

    private static int[] getVersionSpecForFeature(String str, String str2, DialogFeature dialogFeature) {
        AppMethodBeat.i(7651);
        FetchedAppSettings.DialogFeatureConfig dialogFeatureConfig = FetchedAppSettings.getDialogFeatureConfig(str, str2, dialogFeature.name());
        if (dialogFeatureConfig != null) {
            int[] versionSpec = dialogFeatureConfig.getVersionSpec();
            AppMethodBeat.o(7651);
            return versionSpec;
        }
        int[] iArr = {dialogFeature.getMinVersion()};
        AppMethodBeat.o(7651);
        return iArr;
    }

    public static void logDialogActivity(Context context, String str, String str2) {
        AppMethodBeat.i(7652);
        AppEventsLogger newLogger = AppEventsLogger.newLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME, str2);
        newLogger.logSdkEvent(str, null, bundle);
        AppMethodBeat.o(7652);
    }
}
