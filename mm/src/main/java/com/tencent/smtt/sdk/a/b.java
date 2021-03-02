package com.tencent.smtt.sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f1954a;

    /* renamed from: b  reason: collision with root package name */
    private int f1955b;

    /* renamed from: c  reason: collision with root package name */
    private String f1956c;

    /* renamed from: d  reason: collision with root package name */
    private long f1957d;

    private b() {
    }

    public int a() {
        return this.f1954a;
    }

    public int b() {
        return this.f1955b;
    }

    public String c() {
        return this.f1956c;
    }

    public long d() {
        return this.f1957d;
    }

    public static b a(JSONObject jSONObject) {
        AppMethodBeat.i(188268);
        b bVar = null;
        if (jSONObject != null) {
            bVar = new b();
            bVar.f1954a = jSONObject.optInt("id", -1);
            bVar.f1955b = jSONObject.optInt("cmd_id", -1);
            bVar.f1956c = jSONObject.optString("ext_params", "");
            bVar.f1957d = 1000 * jSONObject.optLong("expiration", 0);
        }
        AppMethodBeat.o(188268);
        return bVar;
    }

    public String toString() {
        AppMethodBeat.i(188269);
        String str = "[id=" + this.f1954a + ", cmd=" + this.f1955b + ", extra='" + this.f1956c + '\'' + ", expiration=" + a.a(this.f1957d) + ']';
        AppMethodBeat.o(188269);
        return str;
    }

    public boolean e() {
        AppMethodBeat.i(188270);
        if (System.currentTimeMillis() > this.f1957d) {
            AppMethodBeat.o(188270);
            return true;
        }
        AppMethodBeat.o(188270);
        return false;
    }
}
