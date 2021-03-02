package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FetchedAppGateKeepersManager {
    private static final String APPLICATION_DEVICE_ID = "device_id";
    private static final String APPLICATION_FIELDS = "fields";
    private static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";
    private static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";
    private static final String APPLICATION_GRAPH_DATA = "data";
    private static final String APPLICATION_PLATFORM = "platform";
    private static final String APPLICATION_SDK_VERSION = "sdk_version";
    public static final String APP_EVENTS_IF_AUTO_LOG_SUBS = "app_events_if_auto_log_subs";
    private static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";
    private static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";
    private static final String APP_PLATFORM = "android";
    private static final String TAG = FetchedAppGateKeepersManager.class.getCanonicalName();
    private static final Map<String, JSONObject> fetchedAppGateKeepers = new ConcurrentHashMap();

    static /* synthetic */ void access$000(String str, JSONObject jSONObject) {
        AppMethodBeat.i(17734);
        parseAppGateKeepersFromJSON(str, jSONObject);
        AppMethodBeat.o(17734);
    }

    static /* synthetic */ JSONObject access$100(String str) {
        AppMethodBeat.i(17735);
        JSONObject appGateKeepersQueryResponse = getAppGateKeepersQueryResponse(str);
        AppMethodBeat.o(17735);
        return appGateKeepersQueryResponse;
    }

    static {
        AppMethodBeat.i(17736);
        AppMethodBeat.o(17736);
    }

    public static synchronized void loadAppGateKeepersAsync() {
        synchronized (FetchedAppGateKeepersManager.class) {
            AppMethodBeat.i(17730);
            final Context applicationContext = FacebookSdk.getApplicationContext();
            final String applicationId = FacebookSdk.getApplicationId();
            final String format = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, applicationId);
            FacebookSdk.getExecutor().execute(new Runnable() {
                /* class com.facebook.internal.FetchedAppGateKeepersManager.AnonymousClass1 */

                public final void run() {
                    JSONObject jSONObject;
                    AppMethodBeat.i(17729);
                    SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(FetchedAppGateKeepersManager.APP_GATEKEEPERS_PREFS_STORE, 0);
                    String string = sharedPreferences.getString(format, null);
                    if (!Utility.isNullOrEmpty(string)) {
                        try {
                            jSONObject = new JSONObject(string);
                        } catch (JSONException e2) {
                            Utility.logd("FacebookSDK", e2);
                            jSONObject = null;
                        }
                        if (jSONObject != null) {
                            FetchedAppGateKeepersManager.access$000(applicationId, jSONObject);
                        }
                    }
                    JSONObject access$100 = FetchedAppGateKeepersManager.access$100(applicationId);
                    if (access$100 != null) {
                        FetchedAppGateKeepersManager.access$000(applicationId, access$100);
                        sharedPreferences.edit().putString(format, access$100.toString()).apply();
                    }
                    AppMethodBeat.o(17729);
                }
            });
            AppMethodBeat.o(17730);
        }
    }

    public static boolean getGateKeeperForKey(String str, String str2, boolean z) {
        AppMethodBeat.i(17731);
        if (str2 == null || !fetchedAppGateKeepers.containsKey(str2)) {
            AppMethodBeat.o(17731);
            return z;
        }
        boolean optBoolean = fetchedAppGateKeepers.get(str2).optBoolean(str, z);
        AppMethodBeat.o(17731);
        return optBoolean;
    }

    private static JSONObject getAppGateKeepersQueryResponse(String str) {
        AppMethodBeat.i(17732);
        Bundle bundle = new Bundle();
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
        String str2 = "";
        if (!(attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null)) {
            str2 = attributionIdentifiers.getAndroidAdvertiserId();
        }
        String sdkVersion = FacebookSdk.getSdkVersion();
        bundle.putString("platform", "android");
        bundle.putString("device_id", str2);
        bundle.putString(APPLICATION_SDK_VERSION, sdkVersion);
        bundle.putString("fields", APPLICATION_GATEKEEPER_FIELD);
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, String.format("%s/%s", str, APPLICATION_GATEKEEPER_EDGE), null);
        newGraphPathRequest.setSkipClientToken(true);
        newGraphPathRequest.setParameters(bundle);
        JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
        AppMethodBeat.o(17732);
        return jSONObject;
    }

    private static void parseAppGateKeepersFromJSON(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        AppMethodBeat.i(17733);
        if (fetchedAppGateKeepers.containsKey(str)) {
            jSONObject2 = fetchedAppGateKeepers.get(str);
        } else {
            jSONObject2 = new JSONObject();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        JSONObject jSONObject3 = null;
        if (optJSONArray != null) {
            jSONObject3 = optJSONArray.optJSONObject(0);
        }
        if (!(jSONObject3 == null || jSONObject3.optJSONArray(APPLICATION_GATEKEEPER_FIELD) == null)) {
            JSONArray optJSONArray2 = jSONObject3.optJSONArray(APPLICATION_GATEKEEPER_FIELD);
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                try {
                    JSONObject jSONObject4 = optJSONArray2.getJSONObject(i2);
                    jSONObject2.put(jSONObject4.getString("key"), jSONObject4.getBoolean("value"));
                } catch (JSONException e2) {
                    Utility.logd("FacebookSDK", e2);
                }
            }
        }
        fetchedAppGateKeepers.put(str, jSONObject2);
        AppMethodBeat.o(17733);
    }
}
