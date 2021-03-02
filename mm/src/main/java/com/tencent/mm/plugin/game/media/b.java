package com.tencent.mm.plugin.game.media;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public long createTime;
    public String taskId;
    public int xAl;
    public JSONArray xAm;
    public String xAn;
    public int xAo;

    public b(String str, int i2, String str2, String str3, long j2, int i3) {
        AppMethodBeat.i(40943);
        this.taskId = str;
        this.xAl = i2;
        try {
            this.xAm = c.aAM(str2);
        } catch (Exception e2) {
        }
        this.xAn = str3;
        this.createTime = j2;
        this.xAo = i3;
        AppMethodBeat.o(40943);
    }

    public final JSONObject toJson() {
        AppMethodBeat.i(40944);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ShareConstants.RESULT_POST_ID, this.taskId);
            jSONObject.put("state", this.xAl);
            jSONObject.put("localIds", this.xAm);
            jSONObject.put("extra", this.xAn);
            jSONObject.put("createTime", this.createTime);
            jSONObject.put("mixState", this.xAo);
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(40944);
        return jSONObject;
    }
}
