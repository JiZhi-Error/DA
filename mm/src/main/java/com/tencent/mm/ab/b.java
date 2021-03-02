package com.tencent.mm.ab;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements a {
    private JSONArray hpw;

    public b() {
        AppMethodBeat.i(158424);
        this.hpw = new JSONArray();
        AppMethodBeat.o(158424);
    }

    public b(String str) {
        AppMethodBeat.i(158425);
        try {
            this.hpw = new JSONArray(str);
            AppMethodBeat.o(158425);
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158425);
            throw gVar;
        }
    }

    b(JSONArray jSONArray) {
        AppMethodBeat.i(158426);
        Assert.assertNotNull(jSONArray);
        this.hpw = jSONArray;
        AppMethodBeat.o(158426);
    }

    @Override // com.tencent.mm.ab.a
    public final int length() {
        AppMethodBeat.i(158427);
        int length = this.hpw.length();
        AppMethodBeat.o(158427);
        return length;
    }

    @Override // com.tencent.mm.ab.a
    public final a ep(boolean z) {
        AppMethodBeat.i(158428);
        this.hpw.put(z);
        AppMethodBeat.o(158428);
        return this;
    }

    @Override // com.tencent.mm.ab.a
    public final a k(double d2) {
        AppMethodBeat.i(158429);
        try {
            this.hpw.put(d2);
            AppMethodBeat.o(158429);
            return this;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158429);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final a pQ(int i2) {
        AppMethodBeat.i(158430);
        this.hpw.put(i2);
        AppMethodBeat.o(158430);
        return this;
    }

    @Override // com.tencent.mm.ab.a
    public final a zp(long j2) {
        AppMethodBeat.i(158431);
        this.hpw.put(j2);
        AppMethodBeat.o(158431);
        return this;
    }

    @Override // com.tencent.mm.ab.a
    public final a bu(Object obj) {
        AppMethodBeat.i(158432);
        this.hpw.put(obj);
        AppMethodBeat.o(158432);
        return this;
    }

    @Override // com.tencent.mm.ab.a
    public final a C(int i2, boolean z) {
        AppMethodBeat.i(158433);
        try {
            this.hpw.put(i2, z);
            AppMethodBeat.o(158433);
            return this;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158433);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final a c(int i2, double d2) {
        AppMethodBeat.i(158434);
        try {
            this.hpw.put(i2, d2);
            AppMethodBeat.o(158434);
            return this;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158434);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final a cS(int i2, int i3) {
        AppMethodBeat.i(158435);
        try {
            this.hpw.put(i2, i3);
            AppMethodBeat.o(158435);
            return this;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158435);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final a v(int i2, long j2) {
        AppMethodBeat.i(158436);
        try {
            this.hpw.put(i2, j2);
            AppMethodBeat.o(158436);
            return this;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158436);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final a g(int i2, Object obj) {
        AppMethodBeat.i(158437);
        try {
            this.hpw.put(i2, obj);
            AppMethodBeat.o(158437);
            return this;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158437);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final boolean isNull(int i2) {
        AppMethodBeat.i(158438);
        boolean isNull = this.hpw.isNull(i2);
        AppMethodBeat.o(158438);
        return isNull;
    }

    @Override // com.tencent.mm.ab.a
    public final Object get(int i2) {
        AppMethodBeat.i(158439);
        try {
            Object obj = this.hpw.get(i2);
            if (obj instanceof JSONObject) {
                d dVar = new d((JSONObject) obj);
                AppMethodBeat.o(158439);
                return dVar;
            } else if (obj instanceof JSONArray) {
                b bVar = new b((JSONArray) obj);
                AppMethodBeat.o(158439);
                return bVar;
            } else {
                AppMethodBeat.o(158439);
                return obj;
            }
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158439);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final Object opt(int i2) {
        AppMethodBeat.i(158440);
        Object opt = this.hpw.opt(i2);
        if (opt instanceof JSONObject) {
            d dVar = new d((JSONObject) opt);
            AppMethodBeat.o(158440);
            return dVar;
        } else if (opt instanceof JSONArray) {
            b bVar = new b((JSONArray) opt);
            AppMethodBeat.o(158440);
            return bVar;
        } else {
            AppMethodBeat.o(158440);
            return opt;
        }
    }

    @Override // com.tencent.mm.ab.a
    @TargetApi(19)
    public final Object remove(int i2) {
        AppMethodBeat.i(158441);
        Object remove = this.hpw.remove(i2);
        if (remove instanceof JSONObject) {
            d dVar = new d((JSONObject) remove);
            AppMethodBeat.o(158441);
            return dVar;
        } else if (remove instanceof JSONArray) {
            b bVar = new b((JSONArray) remove);
            AppMethodBeat.o(158441);
            return bVar;
        } else {
            AppMethodBeat.o(158441);
            return remove;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final boolean getBoolean(int i2) {
        AppMethodBeat.i(158442);
        try {
            boolean z = this.hpw.getBoolean(i2);
            AppMethodBeat.o(158442);
            return z;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158442);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final boolean optBoolean(int i2) {
        AppMethodBeat.i(158443);
        boolean optBoolean = this.hpw.optBoolean(i2);
        AppMethodBeat.o(158443);
        return optBoolean;
    }

    @Override // com.tencent.mm.ab.a
    public final boolean optBoolean(int i2, boolean z) {
        AppMethodBeat.i(158444);
        boolean optBoolean = this.hpw.optBoolean(i2, z);
        AppMethodBeat.o(158444);
        return optBoolean;
    }

    @Override // com.tencent.mm.ab.a
    public final double getDouble(int i2) {
        AppMethodBeat.i(158445);
        try {
            double d2 = this.hpw.getDouble(i2);
            AppMethodBeat.o(158445);
            return d2;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158445);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final double optDouble(int i2) {
        AppMethodBeat.i(158446);
        double optDouble = this.hpw.optDouble(i2);
        AppMethodBeat.o(158446);
        return optDouble;
    }

    @Override // com.tencent.mm.ab.a
    public final double optDouble(int i2, double d2) {
        AppMethodBeat.i(158447);
        double optDouble = this.hpw.optDouble(i2, d2);
        AppMethodBeat.o(158447);
        return optDouble;
    }

    @Override // com.tencent.mm.ab.a
    public final int getInt(int i2) {
        AppMethodBeat.i(158448);
        try {
            int i3 = this.hpw.getInt(i2);
            AppMethodBeat.o(158448);
            return i3;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158448);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final int optInt(int i2) {
        AppMethodBeat.i(158449);
        int optInt = this.hpw.optInt(i2);
        AppMethodBeat.o(158449);
        return optInt;
    }

    @Override // com.tencent.mm.ab.a
    public final int optInt(int i2, int i3) {
        AppMethodBeat.i(158450);
        int optInt = this.hpw.optInt(i2, i3);
        AppMethodBeat.o(158450);
        return optInt;
    }

    @Override // com.tencent.mm.ab.a
    public final long getLong(int i2) {
        AppMethodBeat.i(158451);
        try {
            long j2 = this.hpw.getLong(i2);
            AppMethodBeat.o(158451);
            return j2;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158451);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final long optLong(int i2) {
        AppMethodBeat.i(158452);
        long optLong = this.hpw.optLong(i2);
        AppMethodBeat.o(158452);
        return optLong;
    }

    @Override // com.tencent.mm.ab.a
    public final long optLong(int i2, long j2) {
        AppMethodBeat.i(158453);
        long optLong = this.hpw.optLong(i2, j2);
        AppMethodBeat.o(158453);
        return optLong;
    }

    @Override // com.tencent.mm.ab.a
    public final String getString(int i2) {
        AppMethodBeat.i(158454);
        try {
            String string = this.hpw.getString(i2);
            AppMethodBeat.o(158454);
            return string;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158454);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final String optString(int i2) {
        AppMethodBeat.i(158455);
        String optString = this.hpw.optString(i2);
        AppMethodBeat.o(158455);
        return optString;
    }

    @Override // com.tencent.mm.ab.a
    public final String optString(int i2, String str) {
        AppMethodBeat.i(158456);
        String optString = this.hpw.optString(i2, str);
        AppMethodBeat.o(158456);
        return optString;
    }

    @Override // com.tencent.mm.ab.a
    public final a pR(int i2) {
        AppMethodBeat.i(158457);
        try {
            JSONArray jSONArray = this.hpw.getJSONArray(i2);
            if (jSONArray == null) {
                AppMethodBeat.o(158457);
                return null;
            }
            b bVar = new b(jSONArray);
            AppMethodBeat.o(158457);
            return bVar;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158457);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final a pS(int i2) {
        AppMethodBeat.i(158458);
        JSONArray optJSONArray = this.hpw.optJSONArray(i2);
        if (optJSONArray == null) {
            AppMethodBeat.o(158458);
            return null;
        }
        b bVar = new b(optJSONArray);
        AppMethodBeat.o(158458);
        return bVar;
    }

    @Override // com.tencent.mm.ab.a
    public final c pT(int i2) {
        AppMethodBeat.i(158459);
        try {
            JSONObject jSONObject = this.hpw.getJSONObject(i2);
            if (jSONObject == null) {
                AppMethodBeat.o(158459);
                return null;
            }
            d dVar = new d(jSONObject);
            AppMethodBeat.o(158459);
            return dVar;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158459);
            throw gVar;
        }
    }

    @Override // com.tencent.mm.ab.a
    public final c pU(int i2) {
        AppMethodBeat.i(158460);
        JSONObject optJSONObject = this.hpw.optJSONObject(i2);
        if (optJSONObject == null) {
            AppMethodBeat.o(158460);
            return null;
        }
        d dVar = new d(optJSONObject);
        AppMethodBeat.o(158460);
        return dVar;
    }

    @Override // com.tencent.mm.ab.a
    public final String toString() {
        AppMethodBeat.i(158461);
        String jSONArray = this.hpw.toString();
        AppMethodBeat.o(158461);
        return jSONArray;
    }

    @Override // com.tencent.mm.ab.a
    public final String toString(int i2) {
        AppMethodBeat.i(158462);
        try {
            String jSONArray = this.hpw.toString(i2);
            AppMethodBeat.o(158462);
            return jSONArray;
        } catch (JSONException e2) {
            g gVar = new g(e2);
            AppMethodBeat.o(158462);
            throw gVar;
        }
    }
}
