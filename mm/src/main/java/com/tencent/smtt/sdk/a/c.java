package com.tencent.smtt.sdk.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f1958a;

    /* renamed from: b  reason: collision with root package name */
    private String f1959b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f1960c;

    /* renamed from: d  reason: collision with root package name */
    private String f1961d;

    /* renamed from: e  reason: collision with root package name */
    private String f1962e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f1963f;

    /* renamed from: g  reason: collision with root package name */
    private Integer f1964g;

    /* renamed from: h  reason: collision with root package name */
    private List<Integer> f1965h;

    public String a() {
        AppMethodBeat.i(188272);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f1958a)) {
                jSONObject2.put("PP", this.f1958a);
            }
            if (!TextUtils.isEmpty(this.f1959b)) {
                jSONObject2.put("PPVN", this.f1959b);
            }
            if (this.f1960c != null) {
                jSONObject2.put("ADRV", this.f1960c);
            }
            if (!TextUtils.isEmpty(this.f1961d)) {
                jSONObject2.put("MODEL", this.f1961d);
            }
            if (!TextUtils.isEmpty(this.f1962e)) {
                jSONObject2.put("NAME", this.f1962e);
            }
            if (this.f1963f != null) {
                jSONObject2.put("SDKVC", this.f1963f);
            }
            if (this.f1964g != null) {
                jSONObject2.put("COMPVC", this.f1964g);
            }
            jSONObject.put("terminal_params", jSONObject2);
            if (this.f1965h != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < this.f1965h.size(); i2++) {
                    jSONArray.put(this.f1965h.get(i2));
                }
                jSONObject.put("ids", jSONArray);
            }
        } catch (JSONException e2) {
        }
        String jSONObject3 = jSONObject.toString();
        AppMethodBeat.o(188272);
        return jSONObject3;
    }

    public void a(String str) {
        this.f1958a = str;
    }

    public void b(String str) {
        this.f1959b = str;
    }

    public void a(Integer num) {
        this.f1960c = num;
    }

    public void c(String str) {
        this.f1961d = str;
    }

    public void a(List<Integer> list) {
        this.f1965h = list;
    }
}
