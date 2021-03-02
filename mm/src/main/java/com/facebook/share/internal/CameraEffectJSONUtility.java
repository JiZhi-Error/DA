package com.facebook.share.internal;

import com.facebook.share.model.CameraEffectArguments;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class CameraEffectJSONUtility {
    private static final Map<Class<?>, Setter> SETTERS;

    public interface Setter {
        void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj);

        void setOnJSON(JSONObject jSONObject, String str, Object obj);
    }

    static {
        AppMethodBeat.i(7976);
        HashMap hashMap = new HashMap();
        SETTERS = hashMap;
        hashMap.put(String.class, new Setter() {
            /* class com.facebook.share.internal.CameraEffectJSONUtility.AnonymousClass1 */

            @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
            public final void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) {
                AppMethodBeat.i(7968);
                builder.putArgument(str, (String) obj);
                AppMethodBeat.o(7968);
            }

            @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
                AppMethodBeat.i(7969);
                jSONObject.put(str, obj);
                AppMethodBeat.o(7969);
            }
        });
        SETTERS.put(String[].class, new Setter() {
            /* class com.facebook.share.internal.CameraEffectJSONUtility.AnonymousClass2 */

            @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
            public final void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) {
                AppMethodBeat.i(7970);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected type from JSON");
                AppMethodBeat.o(7970);
                throw illegalArgumentException;
            }

            @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
                AppMethodBeat.i(7971);
                JSONArray jSONArray = new JSONArray();
                for (String str2 : (String[]) obj) {
                    jSONArray.put(str2);
                }
                jSONObject.put(str, jSONArray);
                AppMethodBeat.o(7971);
            }
        });
        SETTERS.put(JSONArray.class, new Setter() {
            /* class com.facebook.share.internal.CameraEffectJSONUtility.AnonymousClass3 */

            @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
            public final void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) {
                AppMethodBeat.i(7972);
                JSONArray jSONArray = (JSONArray) obj;
                String[] strArr = new String[jSONArray.length()];
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    Object obj2 = jSONArray.get(i2);
                    if (obj2 instanceof String) {
                        strArr[i2] = (String) obj2;
                    } else {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
                        AppMethodBeat.o(7972);
                        throw illegalArgumentException;
                    }
                }
                builder.putArgument(str, strArr);
                AppMethodBeat.o(7972);
            }

            @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
                AppMethodBeat.i(7973);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("JSONArray's are not supported in bundles.");
                AppMethodBeat.o(7973);
                throw illegalArgumentException;
            }
        });
        AppMethodBeat.o(7976);
    }

    public static JSONObject convertToJSON(CameraEffectArguments cameraEffectArguments) {
        AppMethodBeat.i(7974);
        if (cameraEffectArguments == null) {
            AppMethodBeat.o(7974);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : cameraEffectArguments.keySet()) {
            Object obj = cameraEffectArguments.get(str);
            if (obj != null) {
                Setter setter = SETTERS.get(obj.getClass());
                if (setter == null) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    AppMethodBeat.o(7974);
                    throw illegalArgumentException;
                }
                setter.setOnJSON(jSONObject, str, obj);
            }
        }
        AppMethodBeat.o(7974);
        return jSONObject;
    }

    public static CameraEffectArguments convertToCameraEffectArguments(JSONObject jSONObject) {
        AppMethodBeat.i(7975);
        if (jSONObject == null) {
            AppMethodBeat.o(7975);
            return null;
        }
        CameraEffectArguments.Builder builder = new CameraEffectArguments.Builder();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (!(obj == null || obj == JSONObject.NULL)) {
                Setter setter = SETTERS.get(obj.getClass());
                if (setter == null) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    AppMethodBeat.o(7975);
                    throw illegalArgumentException;
                }
                setter.setOnArgumentsBuilder(builder, next, obj);
            }
        }
        CameraEffectArguments build = builder.build();
        AppMethodBeat.o(7975);
        return build;
    }
}
