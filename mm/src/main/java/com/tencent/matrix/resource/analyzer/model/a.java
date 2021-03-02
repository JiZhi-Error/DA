package com.tencent.matrix.resource.analyzer.model;

import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends b {
    public final boolean cWT;
    public final boolean cWU = false;
    public final h cWV;
    public final Throwable cWW;
    public final long cWX;
    public final String mClassName;

    public static a bf(long j2) {
        return new a(false, null, null, null, j2);
    }

    public static a a(String str, h hVar, long j2) {
        return new a(true, str, hVar, null, j2);
    }

    public static a a(Throwable th, long j2) {
        return new a(false, null, null, th, j2);
    }

    private a(boolean z, String str, h hVar, Throwable th, long j2) {
        this.cWT = z;
        this.mClassName = str;
        this.cWV = hVar;
        this.cWW = th;
        this.cWX = j2;
    }

    public final void q(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        if (this.cWV != null) {
            for (j jVar : this.cWV.elements) {
                jSONArray.put(jVar.toString());
            }
        }
        jSONObject.put("leakFound", this.cWT).put("excludedLeak", this.cWU).put("className", this.mClassName).put("failure", String.valueOf(this.cWW)).put("analysisDurationMs", this.cWX).put("referenceChain", jSONArray);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Leak Reference:");
        if (this.cWV != null) {
            for (j jVar : this.cWV.elements) {
                sb.append(jVar.toString()).append(";");
            }
        }
        return sb.toString();
    }
}
