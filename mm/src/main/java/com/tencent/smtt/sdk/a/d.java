package com.tencent.smtt.sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private int f1966a;

    /* renamed from: b  reason: collision with root package name */
    private long f1967b;

    /* renamed from: c  reason: collision with root package name */
    private List<b> f1968c;

    private d() {
    }

    public static d a(String str) {
        d dVar;
        AppMethodBeat.i(188294);
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                dVar = new d();
                try {
                    dVar.f1966a = jSONObject.optInt("ret_code", -1);
                    dVar.f1967b = jSONObject.optLong("next_req_interval", 1000);
                    JSONArray optJSONArray = jSONObject.optJSONArray("cmds");
                    if (optJSONArray != null) {
                        dVar.f1968c = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            b a2 = b.a(optJSONArray.optJSONObject(i2));
                            if (a2 != null) {
                                dVar.f1968c.add(a2);
                            }
                        }
                    }
                } catch (JSONException e2) {
                }
            } catch (JSONException e3) {
                dVar = null;
            }
        } else {
            dVar = null;
        }
        AppMethodBeat.o(188294);
        return dVar;
    }

    public int a() {
        return this.f1966a;
    }

    public long b() {
        return this.f1967b;
    }

    public List<b> c() {
        return this.f1968c;
    }
}
