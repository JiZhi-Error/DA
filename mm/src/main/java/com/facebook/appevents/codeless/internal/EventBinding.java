package com.facebook.appevents.codeless.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class EventBinding {
    private final String activityName;
    private final String appVersion;
    private final String componentId;
    private final String eventName;
    private final MappingMethod method;
    private final List<ParameterComponent> parameters;
    private final List<PathComponent> path;
    private final String pathType;
    private final ActionType type;

    public EventBinding(String str, MappingMethod mappingMethod, ActionType actionType, String str2, List<PathComponent> list, List<ParameterComponent> list2, String str3, String str4, String str5) {
        this.eventName = str;
        this.method = mappingMethod;
        this.type = actionType;
        this.appVersion = str2;
        this.path = list;
        this.parameters = list2;
        this.componentId = str3;
        this.pathType = str4;
        this.activityName = str5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0013 A[Catch:{ JSONException -> 0x0023 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.facebook.appevents.codeless.internal.EventBinding> parseArray(org.json.JSONArray r5) {
        /*
            r4 = 17533(0x447d, float:2.4569E-41)
            r1 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            if (r5 == 0) goto L_0x0021
            int r0 = r5.length()     // Catch:{ JSONException -> 0x0023 }
        L_0x0011:
            if (r1 >= r0) goto L_0x0024
            org.json.JSONObject r3 = r5.getJSONObject(r1)     // Catch:{ JSONException -> 0x0023 }
            com.facebook.appevents.codeless.internal.EventBinding r3 = getInstanceFromJson(r3)     // Catch:{ JSONException -> 0x0023 }
            r2.add(r3)     // Catch:{ JSONException -> 0x0023 }
            int r1 = r1 + 1
            goto L_0x0011
        L_0x0021:
            r0 = r1
            goto L_0x0011
        L_0x0023:
            r0 = move-exception
        L_0x0024:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.EventBinding.parseArray(org.json.JSONArray):java.util.List");
    }

    public static EventBinding getInstanceFromJson(JSONObject jSONObject) {
        AppMethodBeat.i(17534);
        String string = jSONObject.getString("event_name");
        MappingMethod valueOf = MappingMethod.valueOf(jSONObject.getString(FirebaseAnalytics.b.METHOD).toUpperCase());
        ActionType valueOf2 = ActionType.valueOf(jSONObject.getString("event_type").toUpperCase());
        String string2 = jSONObject.getString("app_version");
        JSONArray jSONArray = jSONObject.getJSONArray("path");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(new PathComponent(jSONArray.getJSONObject(i2)));
        }
        String optString = jSONObject.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE);
        JSONArray optJSONArray = jSONObject.optJSONArray("parameters");
        ArrayList arrayList2 = new ArrayList();
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList2.add(new ParameterComponent(optJSONArray.getJSONObject(i3)));
            }
        }
        EventBinding eventBinding = new EventBinding(string, valueOf, valueOf2, string2, arrayList, arrayList2, jSONObject.optString("component_id"), optString, jSONObject.optString("activity_name"));
        AppMethodBeat.o(17534);
        return eventBinding;
    }

    public List<PathComponent> getViewPath() {
        AppMethodBeat.i(17535);
        List<PathComponent> unmodifiableList = Collections.unmodifiableList(this.path);
        AppMethodBeat.o(17535);
        return unmodifiableList;
    }

    public List<ParameterComponent> getViewParameters() {
        AppMethodBeat.i(17536);
        List<ParameterComponent> unmodifiableList = Collections.unmodifiableList(this.parameters);
        AppMethodBeat.o(17536);
        return unmodifiableList;
    }

    public String getEventName() {
        return this.eventName;
    }

    public ActionType getType() {
        return this.type;
    }

    public MappingMethod getMethod() {
        return this.method;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getComponentId() {
        return this.componentId;
    }

    public String getPathType() {
        return this.pathType;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public enum MappingMethod {
        MANUAL,
        INFERENCE;

        public static MappingMethod valueOf(String str) {
            AppMethodBeat.i(17531);
            MappingMethod mappingMethod = (MappingMethod) Enum.valueOf(MappingMethod.class, str);
            AppMethodBeat.o(17531);
            return mappingMethod;
        }

        static {
            AppMethodBeat.i(17532);
            AppMethodBeat.o(17532);
        }
    }

    public enum ActionType {
        CLICK,
        SELECTED,
        TEXT_CHANGED;

        public static ActionType valueOf(String str) {
            AppMethodBeat.i(17528);
            ActionType actionType = (ActionType) Enum.valueOf(ActionType.class, str);
            AppMethodBeat.o(17528);
            return actionType;
        }

        static {
            AppMethodBeat.i(17529);
            AppMethodBeat.o(17529);
        }
    }
}
