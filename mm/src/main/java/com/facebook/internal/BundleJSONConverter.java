package com.facebook.internal;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class BundleJSONConverter {
    private static final Map<Class<?>, Setter> SETTERS;

    public interface Setter {
        void setOnBundle(Bundle bundle, String str, Object obj);

        void setOnJSON(JSONObject jSONObject, String str, Object obj);
    }

    static {
        AppMethodBeat.i(17702);
        HashMap hashMap = new HashMap();
        SETTERS = hashMap;
        hashMap.put(Boolean.class, new Setter() {
            /* class com.facebook.internal.BundleJSONConverter.AnonymousClass1 */

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public final void setOnBundle(Bundle bundle, String str, Object obj) {
                AppMethodBeat.i(17686);
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                AppMethodBeat.o(17686);
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
                AppMethodBeat.i(17687);
                jSONObject.put(str, obj);
                AppMethodBeat.o(17687);
            }
        });
        SETTERS.put(Integer.class, new Setter() {
            /* class com.facebook.internal.BundleJSONConverter.AnonymousClass2 */

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public final void setOnBundle(Bundle bundle, String str, Object obj) {
                AppMethodBeat.i(17688);
                bundle.putInt(str, ((Integer) obj).intValue());
                AppMethodBeat.o(17688);
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
                AppMethodBeat.i(17689);
                jSONObject.put(str, obj);
                AppMethodBeat.o(17689);
            }
        });
        SETTERS.put(Long.class, new Setter() {
            /* class com.facebook.internal.BundleJSONConverter.AnonymousClass3 */

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public final void setOnBundle(Bundle bundle, String str, Object obj) {
                AppMethodBeat.i(17690);
                bundle.putLong(str, ((Long) obj).longValue());
                AppMethodBeat.o(17690);
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
                AppMethodBeat.i(17691);
                jSONObject.put(str, obj);
                AppMethodBeat.o(17691);
            }
        });
        SETTERS.put(Double.class, new Setter() {
            /* class com.facebook.internal.BundleJSONConverter.AnonymousClass4 */

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public final void setOnBundle(Bundle bundle, String str, Object obj) {
                AppMethodBeat.i(17692);
                bundle.putDouble(str, ((Double) obj).doubleValue());
                AppMethodBeat.o(17692);
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
                AppMethodBeat.i(17693);
                jSONObject.put(str, obj);
                AppMethodBeat.o(17693);
            }
        });
        SETTERS.put(String.class, new Setter() {
            /* class com.facebook.internal.BundleJSONConverter.AnonymousClass5 */

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public final void setOnBundle(Bundle bundle, String str, Object obj) {
                AppMethodBeat.i(17694);
                bundle.putString(str, (String) obj);
                AppMethodBeat.o(17694);
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
                AppMethodBeat.i(17695);
                jSONObject.put(str, obj);
                AppMethodBeat.o(17695);
            }
        });
        SETTERS.put(String[].class, new Setter() {
            /* class com.facebook.internal.BundleJSONConverter.AnonymousClass6 */

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public final void setOnBundle(Bundle bundle, String str, Object obj) {
                AppMethodBeat.i(17696);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected type from JSON");
                AppMethodBeat.o(17696);
                throw illegalArgumentException;
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
                AppMethodBeat.i(17697);
                JSONArray jSONArray = new JSONArray();
                for (String str2 : (String[]) obj) {
                    jSONArray.put(str2);
                }
                jSONObject.put(str, jSONArray);
                AppMethodBeat.o(17697);
            }
        });
        SETTERS.put(JSONArray.class, new Setter() {
            /* class com.facebook.internal.BundleJSONConverter.AnonymousClass7 */

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public final void setOnBundle(Bundle bundle, String str, Object obj) {
                AppMethodBeat.i(17698);
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList<String> arrayList = new ArrayList<>();
                if (jSONArray.length() == 0) {
                    bundle.putStringArrayList(str, arrayList);
                    AppMethodBeat.o(17698);
                    return;
                }
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    Object obj2 = jSONArray.get(i2);
                    if (obj2 instanceof String) {
                        arrayList.add((String) obj2);
                    } else {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
                        AppMethodBeat.o(17698);
                        throw illegalArgumentException;
                    }
                }
                bundle.putStringArrayList(str, arrayList);
                AppMethodBeat.o(17698);
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
                AppMethodBeat.i(17699);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("JSONArray's are not supported in bundles.");
                AppMethodBeat.o(17699);
                throw illegalArgumentException;
            }
        });
        AppMethodBeat.o(17702);
    }

    public static JSONObject convertToJSON(Bundle bundle) {
        AppMethodBeat.i(17700);
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str2 : (List) obj) {
                        jSONArray.put(str2);
                    }
                    jSONObject.put(str, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(str, convertToJSON((Bundle) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter == null) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported type: " + obj.getClass());
                        AppMethodBeat.o(17700);
                        throw illegalArgumentException;
                    }
                    setter.setOnJSON(jSONObject, str, obj);
                }
            }
        }
        AppMethodBeat.o(17700);
        return jSONObject;
    }

    public static Bundle convertToBundle(JSONObject jSONObject) {
        AppMethodBeat.i(17701);
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (!(obj == null || obj == JSONObject.NULL)) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(next, convertToBundle((JSONObject) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter == null) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported type: " + obj.getClass());
                        AppMethodBeat.o(17701);
                        throw illegalArgumentException;
                    }
                    setter.setOnBundle(bundle, next, obj);
                }
            }
        }
        AppMethodBeat.o(17701);
        return bundle;
    }
}
