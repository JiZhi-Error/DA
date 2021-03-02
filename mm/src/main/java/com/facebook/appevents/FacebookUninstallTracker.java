package com.facebook.appevents;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookUninstallTracker {
    private static final String PLATFORM = "android";
    private static final String SUCCESS = "success";
    private static final String TAG = FacebookUninstallTracker.class.getCanonicalName();
    private static final String UPLOADED_TOKEN_STORE = "com.facebook.appevents.FacebookUninstallTracker.UPLOADED_TOKEN";
    private static final SharedPreferences uploadedTokenSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(UPLOADED_TOKEN_STORE, 0);

    static /* synthetic */ GraphRequest access$000(String str, String str2) {
        AppMethodBeat.i(17438);
        GraphRequest buildPushDeviceTokenRequest = buildPushDeviceTokenRequest(str, str2);
        AppMethodBeat.o(17438);
        return buildPushDeviceTokenRequest;
    }

    static {
        AppMethodBeat.i(17439);
        AppMethodBeat.o(17439);
    }

    public static void updateDeviceToken(String str) {
        AppMethodBeat.i(17435);
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery == null) {
            AppMethodBeat.o(17435);
            return;
        }
        boolean trackUninstallEnabled = appSettingsWithoutQuery.getTrackUninstallEnabled();
        String string = uploadedTokenSharedPrefs.getString("uploaded_token", null);
        boolean z = uploadedTokenSharedPrefs.getBoolean("pre_track_uninstall_enabled", false);
        if (!trackUninstallEnabled || (z && str.equals(string))) {
            if (!trackUninstallEnabled && z) {
                uploadedTokenSharedPrefs.edit().putBoolean("pre_track_uninstall_enabled", false).apply();
            }
            AppMethodBeat.o(17435);
            return;
        }
        sendToServer(str);
        AppMethodBeat.o(17435);
    }

    private static void sendToServer(final String str) {
        AppMethodBeat.i(17436);
        FacebookSdk.getExecutor().execute(new Runnable() {
            /* class com.facebook.appevents.FacebookUninstallTracker.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(17434);
                GraphRequest access$000 = FacebookUninstallTracker.access$000(FacebookSdk.getApplicationId(), str);
                if (access$000 != null) {
                    GraphResponse executeAndWait = access$000.executeAndWait();
                    try {
                        JSONObject jSONObject = executeAndWait.getJSONObject();
                        if (jSONObject != null) {
                            if (!jSONObject.has("success") || !jSONObject.getString("success").equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                                String unused = FacebookUninstallTracker.TAG;
                                new StringBuilder("Error sending device token to Facebook: ").append(executeAndWait.getError());
                            } else {
                                FacebookUninstallTracker.uploadedTokenSharedPrefs.edit().putString("uploaded_token", str).putBoolean("pre_track_uninstall_enabled", true).apply();
                                AppMethodBeat.o(17434);
                                return;
                            }
                        }
                        AppMethodBeat.o(17434);
                        return;
                    } catch (JSONException e2) {
                        String unused2 = FacebookUninstallTracker.TAG;
                    }
                }
                AppMethodBeat.o(17434);
            }
        });
        AppMethodBeat.o(17436);
    }

    private static GraphRequest buildPushDeviceTokenRequest(String str, String str2) {
        AppMethodBeat.i(17437);
        GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format(Locale.US, "%s/app_push_device_token", str), null, null);
        newPostRequest.setSkipClientToken(true);
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
        if (attributionIdentifiers == null) {
            AppMethodBeat.o(17437);
            return null;
        }
        String androidAdvertiserId = attributionIdentifiers.getAndroidAdvertiserId();
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString(TPDownloadProxyEnum.USER_DEVICE_ID, androidAdvertiserId);
        parameters.putString("device_token", str2);
        parameters.putString(TPDownloadProxyEnum.USER_PLATFORM, "android");
        newPostRequest.setParameters(parameters);
        AppMethodBeat.o(17437);
        return newPostRequest;
    }
}
