package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/sticker/StickerTransform;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "trans0", "", "getTrans0", "()[D", "setTrans0", "([D)V", "trans1", "getTrans1", "setTrans1", "trans2", "getTrans2", "setTrans2", "trans3", "getTrans3", "setTrans3", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "isEmpty", "", "toJson", "plugin-sticker_release"})
public final class g extends a {
    public double[] NNA = new double[0];
    public double[] NNB = new double[0];
    public double[] NNC = new double[0];
    public double[] NNz = new double[0];

    public g() {
        AppMethodBeat.i(105911);
        AppMethodBeat.o(105911);
    }

    @Override // com.tencent.mm.sticker.a
    public final a au(JSONObject jSONObject) {
        AppMethodBeat.i(105909);
        p.h(jSONObject, "jsonObj");
        JSONArray optJSONArray = jSONObject.optJSONArray("trans_0");
        this.NNz = optJSONArray != null ? b.W(optJSONArray) : this.NNz;
        JSONArray optJSONArray2 = jSONObject.optJSONArray("trans_1");
        this.NNA = optJSONArray2 != null ? b.W(optJSONArray2) : this.NNA;
        JSONArray optJSONArray3 = jSONObject.optJSONArray("trans_2");
        this.NNB = optJSONArray3 != null ? b.W(optJSONArray3) : this.NNB;
        JSONArray optJSONArray4 = jSONObject.optJSONArray("trans_3");
        this.NNC = optJSONArray4 != null ? b.W(optJSONArray4) : this.NNC;
        a au = super.au(jSONObject);
        AppMethodBeat.o(105909);
        return au;
    }

    @Override // com.tencent.mm.sticker.a
    public final JSONObject toJson() {
        AppMethodBeat.i(105910);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("trans_0", b.c(this.NNz));
        jSONObject.put("trans_1", b.c(this.NNA));
        jSONObject.put("trans_2", b.c(this.NNB));
        jSONObject.put("trans_3", b.c(this.NNC));
        AppMethodBeat.o(105910);
        return jSONObject;
    }
}
