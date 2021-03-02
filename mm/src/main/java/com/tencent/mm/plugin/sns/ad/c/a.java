package com.tencent.mm.plugin.sns.ad.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.i;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a extends i.b {
    private String adExtInfo;
    private String dRS;
    private String finderLiveNoticeId;
    private String finderUsername;
    private int result;
    private int source;
    private String uxInfo;

    public final void c(String str, String str2, String str3, String str4, String str5, int i2, int i3) {
        AppMethodBeat.i(201859);
        this.dRS = Util.nullAsNil(str);
        this.uxInfo = Util.nullAsNil(str2);
        this.adExtInfo = Util.nullAsNil(str3);
        this.finderUsername = Util.nullAsNil(str4);
        this.finderLiveNoticeId = Util.nullAsNil(str5);
        this.result = i2;
        this.source = i3;
        AppMethodBeat.o(201859);
    }

    @Override // com.tencent.mm.plugin.sns.ad.i.i.a
    public final String eWH() {
        return "sns_ad_finder_live_notice_reserve";
    }

    @Override // com.tencent.mm.plugin.sns.ad.i.i.b
    public final void bn(JSONObject jSONObject) {
        AppMethodBeat.i(201860);
        try {
            jSONObject.putOpt("snsid", this.dRS);
            jSONObject.putOpt("uxinfo", this.uxInfo);
            jSONObject.putOpt("adExtInfo", this.adExtInfo);
            AppMethodBeat.o(201860);
        } catch (Throwable th) {
            AppMethodBeat.o(201860);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ad.i.i.b
    public final void bo(JSONObject jSONObject) {
        AppMethodBeat.i(201861);
        try {
            jSONObject.putOpt("finderUsername", this.finderUsername);
            jSONObject.putOpt("finderLiveNoticeId", this.finderLiveNoticeId);
            jSONObject.putOpt("result", Integer.valueOf(this.result));
            jSONObject.putOpt("source", Integer.valueOf(this.source));
            AppMethodBeat.o(201861);
        } catch (Throwable th) {
            AppMethodBeat.o(201861);
        }
    }
}
