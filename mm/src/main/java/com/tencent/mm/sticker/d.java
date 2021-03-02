package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0013\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006("}, hxF = {"Lcom/tencent/mm/sticker/StickerElement;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "active", "", "getActive", "()I", "setActive", "(I)V", "adjust", "", "getAdjust", "()Z", "setAdjust", "(Z)V", "len", "getLen", "setLen", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "pendantType", "getPendantType", "setPendantType", "pos", "", "getPos", "()[D", "setPos", "([D)V", "segment", "getSegment", "setSegment", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-sticker_release"})
public final class d extends a {
    public int NMN = -1;
    public int NMO = -1;
    int NMP;
    private boolean NMQ;
    public double[] NMR = new double[0];
    public int len;
    private String name = "";

    public d() {
        AppMethodBeat.i(105892);
        AppMethodBeat.o(105892);
    }

    public final void setName(String str) {
        AppMethodBeat.i(105889);
        p.h(str, "<set-?>");
        this.name = str;
        AppMethodBeat.o(105889);
    }

    @Override // com.tencent.mm.sticker.a
    public final a au(JSONObject jSONObject) {
        AppMethodBeat.i(105890);
        p.h(jSONObject, "jsonObj");
        this.len = jSONObject.optInt("len");
        this.NMN = jSONObject.optInt("active", this.NMN);
        this.NMO = jSONObject.optInt("segtype", this.NMO);
        this.NMP = jSONObject.optInt("pendant_type", this.NMP);
        this.NMQ = jSONObject.optBoolean("adjust", this.NMQ);
        JSONArray optJSONArray = jSONObject.optJSONArray("pos");
        this.NMR = optJSONArray != null ? b.W(optJSONArray) : this.NMR;
        a au = super.au(jSONObject);
        AppMethodBeat.o(105890);
        return au;
    }

    @Override // com.tencent.mm.sticker.a
    public final JSONObject toJson() {
        boolean z = false;
        AppMethodBeat.i(105891);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("len", this.len);
        jSONObject.put("active", this.NMN);
        if (this.NMO >= 0 || this.NMP == 2) {
            jSONObject.put("segtype", 0);
        }
        if (!(this.NMR.length == 0)) {
            z = true;
        }
        if (z) {
            jSONObject.put("pos", b.c(this.NMR));
        }
        if (this.NMP == 1 || this.NMP == 2) {
            jSONObject.put("adjust", true);
        }
        AppMethodBeat.o(105891);
        return jSONObject;
    }
}
