package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.h.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public abstract class p extends e {
    protected boolean lxO = false;

    public final String Zf(String str) {
        return h(str, null);
    }

    public final String n(String str, Map<String, ? extends Object> map) {
        Map<String, ? extends Object> hashMap;
        if ("cancel".equals(str)) {
            str = "fail cancel";
        }
        if (!str.startsWith("fail") && !str.startsWith("ok")) {
            String format = String.format(Locale.ENGLISH, "api[%s] assert, argument [reason] must start with special prefix", getName());
            if (this.lxO) {
                throw new IllegalArgumentException(format);
            }
            Log.e("MicroMsg.AppBrandJsApi", format);
        }
        if (map instanceof HashMap) {
            hashMap = map;
        } else {
            hashMap = new HashMap<>();
        }
        if (map != null && map.containsKey("errMsg")) {
            String str2 = "api " + getName() + ": Cant put errMsg in res!!!";
            if (this.lxO) {
                throw new IllegalArgumentException(str2);
            }
            Log.e("MicroMsg.AppBrandJsApi", str2);
        }
        hashMap.put("errMsg", getName() + ":" + str);
        e.m(hashMap);
        return new JSONObject(hashMap).toString();
    }

    public final String h(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject.has("errMsg")) {
            String str2 = "api " + getName() + ": Cant put errMsg in res!!!";
            if (this.lxO) {
                throw new IllegalArgumentException(str2);
            }
            Log.e("MicroMsg.AppBrandJsApi", str2);
        }
        try {
            jSONObject.put("errMsg", getName() + ":" + str);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandJsApi", "makeReturnJson with JSONObject, put errMsg, e=%s", e2);
        }
        return jSONObject.toString();
    }

    public final String a(f fVar, String str, Map<String, ? extends Object> map) {
        return x.a(fVar.getJsRuntime(), map, (x.a) fVar.av(x.a.class)) == x.b.FAIL_SIZE_EXCEED_LIMIT ? h("fail:convert native buffer parameter fail. native buffer exceed size limit.", null) : n(str, map);
    }

    public ByteBuffer a(String str, k kVar, int i2) {
        return kVar.N(i2, false);
    }

    public boolean bEi() {
        return false;
    }

    public static class a {
        public final String errMsg;
        public final Map<String, Object> values = new HashMap();

        public a(String str, Object... objArr) {
            AppMethodBeat.i(140640);
            if (objArr == null || objArr.length <= 0) {
                this.errMsg = str;
                AppMethodBeat.o(140640);
                return;
            }
            this.errMsg = String.format(str, objArr);
            AppMethodBeat.o(140640);
        }

        public a o(String str, Object obj) {
            AppMethodBeat.i(140641);
            this.values.put(str, obj);
            AppMethodBeat.o(140641);
            return this;
        }

        public a I(Map<String, Object> map) {
            AppMethodBeat.i(140642);
            if (map != null) {
                this.values.putAll(map);
            }
            AppMethodBeat.o(140642);
            return this;
        }
    }
}
