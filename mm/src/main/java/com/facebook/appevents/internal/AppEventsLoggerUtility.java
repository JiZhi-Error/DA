package com.facebook.appevents.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AppEventsLoggerUtility {
    private static final Map<GraphAPIActivityType, String> API_ACTIVITY_TYPE_TO_STRING = new HashMap<GraphAPIActivityType, String>() {
        /* class com.facebook.appevents.internal.AppEventsLoggerUtility.AnonymousClass1 */

        {
            AppMethodBeat.i(17601);
            put(GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL");
            put(GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS");
            AppMethodBeat.o(17601);
        }
    };

    public enum GraphAPIActivityType {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS;

        public static GraphAPIActivityType valueOf(String str) {
            AppMethodBeat.i(17603);
            GraphAPIActivityType graphAPIActivityType = (GraphAPIActivityType) Enum.valueOf(GraphAPIActivityType.class, str);
            AppMethodBeat.o(17603);
            return graphAPIActivityType;
        }

        static {
            AppMethodBeat.i(17604);
            AppMethodBeat.o(17604);
        }
    }

    static {
        AppMethodBeat.i(17606);
        AppMethodBeat.o(17606);
    }

    public static JSONObject getJSONObjectForGraphAPICall(GraphAPIActivityType graphAPIActivityType, AttributionIdentifiers attributionIdentifiers, String str, boolean z, Context context) {
        AppMethodBeat.i(17605);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", API_ACTIVITY_TYPE_TO_STRING.get(graphAPIActivityType));
        String userID = AppEventsLogger.getUserID();
        if (userID != null) {
            jSONObject.put("app_user_id", userID);
        }
        String userData = AppEventsLogger.getUserData();
        if (userData != null) {
            jSONObject.put("ud", userData);
        }
        Utility.setAppEventAttributionParameters(jSONObject, attributionIdentifiers, str, z);
        try {
            Utility.setAppEventExtendedDeviceInfoParameters(jSONObject, context);
        } catch (Exception e2) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e2.toString());
        }
        jSONObject.put("application_package_name", context.getPackageName());
        AppMethodBeat.o(17605);
        return jSONObject;
    }
}
