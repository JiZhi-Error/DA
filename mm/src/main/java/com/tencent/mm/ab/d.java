package com.tencent.mm.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements c {
    private JSONObject hpx;

    public d() {
        AppMethodBeat.i(158463);
        this.hpx = new JSONObject();
        AppMethodBeat.o(158463);
    }

    public d(Map map) {
        AppMethodBeat.i(158464);
        this.hpx = new JSONObject(map);
        AppMethodBeat.o(158464);
    }

    public d(String str) {
        AppMethodBeat.i(158465);
        try {
            this.hpx = new JSONObject(str);
            AppMethodBeat.o(158465);
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158465);
            throw gVar;
        }
    }

    d(JSONObject jSONObject) {
        AppMethodBeat.i(158466);
        Assert.assertNotNull(jSONObject);
        this.hpx = jSONObject;
        AppMethodBeat.o(158466);
    }

    @Override // com.tencent.mm.ab.c
    public final int length() {
        AppMethodBeat.i(158467);
        int length = this.hpx.length();
        AppMethodBeat.o(158467);
        return length;
    }

    @Override // com.tencent.mm.ab.c
    public final c v(String str, boolean z) {
        AppMethodBeat.i(158468);
        try {
            this.hpx.put(str, z);
            AppMethodBeat.o(158468);
            return this;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158468);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final c b(String str, double d2) {
        AppMethodBeat.i(158469);
        try {
            this.hpx.put(str, d2);
            AppMethodBeat.o(158469);
            return this;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158469);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final c T(String str, int i2) {
        AppMethodBeat.i(158470);
        try {
            this.hpx.put(str, i2);
            AppMethodBeat.o(158470);
            return this;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158470);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final c u(String str, long j2) {
        AppMethodBeat.i(158471);
        try {
            this.hpx.put(str, j2);
            AppMethodBeat.o(158471);
            return this;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158471);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final c f(String str, Object obj) {
        AppMethodBeat.i(158472);
        try {
            if (obj instanceof d) {
                this.hpx.put(str, ((d) obj).hpx);
            } else {
                this.hpx.put(str, obj);
            }
            AppMethodBeat.o(158472);
            return this;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158472);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final c g(String str, Object obj) {
        AppMethodBeat.i(158473);
        try {
            if (obj instanceof d) {
                this.hpx.putOpt(str, ((d) obj).hpx);
            } else {
                this.hpx.putOpt(str, obj);
            }
            AppMethodBeat.o(158473);
            return this;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158473);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final String Fz(String str) {
        AppMethodBeat.i(158474);
        if (str == null) {
            g gVar = new g("Names must be non-null");
            AppMethodBeat.o(158474);
            throw gVar;
        }
        AppMethodBeat.o(158474);
        return str;
    }

    @Override // com.tencent.mm.ab.c
    public final Object remove(String str) {
        AppMethodBeat.i(158475);
        Object remove = this.hpx.remove(str);
        AppMethodBeat.o(158475);
        return remove;
    }

    @Override // com.tencent.mm.ab.c
    public final boolean isNull(String str) {
        AppMethodBeat.i(158476);
        boolean isNull = this.hpx.isNull(str);
        AppMethodBeat.o(158476);
        return isNull;
    }

    @Override // com.tencent.mm.ab.c
    public final boolean has(String str) {
        AppMethodBeat.i(158477);
        boolean has = this.hpx.has(str);
        AppMethodBeat.o(158477);
        return has;
    }

    @Override // com.tencent.mm.ab.c
    public final Object get(String str) {
        AppMethodBeat.i(158478);
        try {
            Object obj = this.hpx.get(str);
            if (obj instanceof JSONObject) {
                d dVar = new d((JSONObject) obj);
                AppMethodBeat.o(158478);
                return dVar;
            } else if (obj instanceof JSONArray) {
                b bVar = new b((JSONArray) obj);
                AppMethodBeat.o(158478);
                return bVar;
            } else {
                AppMethodBeat.o(158478);
                return obj;
            }
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158478);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final Object opt(String str) {
        AppMethodBeat.i(158479);
        try {
            Object obj = this.hpx.get(str);
            if (obj instanceof JSONObject) {
                d dVar = new d((JSONObject) obj);
                AppMethodBeat.o(158479);
                return dVar;
            } else if (obj instanceof JSONArray) {
                b bVar = new b((JSONArray) obj);
                AppMethodBeat.o(158479);
                return bVar;
            } else {
                AppMethodBeat.o(158479);
                return obj;
            }
        } catch (JSONException e2) {
            AppMethodBeat.o(158479);
            return null;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final boolean getBoolean(String str) {
        AppMethodBeat.i(158480);
        try {
            boolean z = this.hpx.getBoolean(str);
            AppMethodBeat.o(158480);
            return z;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158480);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final boolean optBoolean(String str, boolean z) {
        AppMethodBeat.i(158481);
        boolean optBoolean = this.hpx.optBoolean(str, z);
        AppMethodBeat.o(158481);
        return optBoolean;
    }

    @Override // com.tencent.mm.ab.c
    public final double getDouble(String str) {
        AppMethodBeat.i(158482);
        try {
            double d2 = this.hpx.getDouble(str);
            AppMethodBeat.o(158482);
            return d2;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158482);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final double optDouble(String str, double d2) {
        AppMethodBeat.i(158483);
        double optDouble = this.hpx.optDouble(str, d2);
        AppMethodBeat.o(158483);
        return optDouble;
    }

    @Override // com.tencent.mm.ab.c
    public final int getInt(String str) {
        AppMethodBeat.i(158484);
        try {
            int i2 = this.hpx.getInt(str);
            AppMethodBeat.o(158484);
            return i2;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158484);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final int optInt(String str, int i2) {
        AppMethodBeat.i(158485);
        int optInt = this.hpx.optInt(str, i2);
        AppMethodBeat.o(158485);
        return optInt;
    }

    @Override // com.tencent.mm.ab.c
    public final long getLong(String str) {
        AppMethodBeat.i(158486);
        try {
            long j2 = this.hpx.getLong(str);
            AppMethodBeat.o(158486);
            return j2;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158486);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final long optLong(String str, long j2) {
        AppMethodBeat.i(158487);
        long optLong = this.hpx.optLong(str, j2);
        AppMethodBeat.o(158487);
        return optLong;
    }

    @Override // com.tencent.mm.ab.c
    public final String getString(String str) {
        AppMethodBeat.i(158488);
        try {
            String string = this.hpx.getString(str);
            AppMethodBeat.o(158488);
            return string;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158488);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final String optString(String str) {
        AppMethodBeat.i(158489);
        String optString = this.hpx.optString(str);
        AppMethodBeat.o(158489);
        return optString;
    }

    @Override // com.tencent.mm.ab.c
    public final String optString(String str, String str2) {
        AppMethodBeat.i(158490);
        String optString = this.hpx.optString(str, str2);
        AppMethodBeat.o(158490);
        return optString;
    }

    @Override // com.tencent.mm.ab.c
    public final a FA(String str) {
        AppMethodBeat.i(158491);
        try {
            JSONArray jSONArray = this.hpx.getJSONArray(str);
            if (jSONArray == null) {
                AppMethodBeat.o(158491);
                return null;
            }
            b bVar = new b(jSONArray);
            AppMethodBeat.o(158491);
            return bVar;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158491);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final a FB(String str) {
        AppMethodBeat.i(158492);
        JSONArray optJSONArray = this.hpx.optJSONArray(str);
        if (optJSONArray == null) {
            AppMethodBeat.o(158492);
            return null;
        }
        b bVar = new b(optJSONArray);
        AppMethodBeat.o(158492);
        return bVar;
    }

    @Override // com.tencent.mm.ab.c
    public final c FC(String str) {
        AppMethodBeat.i(158493);
        try {
            JSONObject jSONObject = this.hpx.getJSONObject(str);
            if (jSONObject == null) {
                AppMethodBeat.o(158493);
                return null;
            }
            d dVar = new d(jSONObject);
            AppMethodBeat.o(158493);
            return dVar;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158493);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.c
    public final c FD(String str) {
        AppMethodBeat.i(158494);
        JSONObject optJSONObject = this.hpx.optJSONObject(str);
        if (optJSONObject == null) {
            AppMethodBeat.o(158494);
            return null;
        }
        d dVar = new d(optJSONObject);
        AppMethodBeat.o(158494);
        return dVar;
    }

    @Override // com.tencent.mm.ab.c
    public final Iterator<String> keys() {
        AppMethodBeat.i(158495);
        Iterator<String> keys = this.hpx.keys();
        AppMethodBeat.o(158495);
        return keys;
    }

    public final String toString() {
        AppMethodBeat.i(158496);
        String jSONObject = this.hpx.toString();
        AppMethodBeat.o(158496);
        return jSONObject;
    }
}
