package com.tencent.mm.plugin.sns.ad.timeline.feedback.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.i;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a implements i.a {
    public String DyA;
    public String DyB;
    public long Dyz;
    public int mScene;

    private JSONObject eXR() {
        AppMethodBeat.i(202180);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("snsid", String.valueOf(this.Dyz));
            jSONObject.put("uxinfo", Util.nullAs(this.DyA, ""));
            jSONObject.put("scene", this.mScene);
            jSONObject.put("adExtInfo", Util.nullAs(this.DyB, ""));
        } catch (Throwable th) {
        }
        AppMethodBeat.o(202180);
        return jSONObject;
    }

    @Override // com.tencent.mm.plugin.sns.ad.i.i.a
    public final String eWH() {
        return "timeline_ad_feedback_click_positive_btn";
    }

    @Override // com.tencent.mm.plugin.sns.ad.i.i.a
    public final String getContent() {
        AppMethodBeat.i(202181);
        String jSONObject = eXR().toString();
        AppMethodBeat.o(202181);
        return jSONObject;
    }
}
