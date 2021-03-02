package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class aj extends f {
    public String IEA;
    public String IEB;
    public long IEC;
    public String IED;
    public String IEE;
    public String IEF;
    public String IEG;
    public String IEH;
    public String IEI;
    public String IEJ;
    public long IEK;
    public String IEL;
    public String IEy;
    public String IEz;
    public String eby;
    public String msN;
    public String rCq;
    public String source;
    public String thumbUrl;
    public String xDQ;

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
        AppMethodBeat.i(117706);
        sb.append("<websearch>");
        if (!Util.isNullOrNil(this.IEy)) {
            sb.append("<relevant_vid>");
            sb.append(k.b.HE(this.IEy));
            sb.append("</relevant_vid>");
        }
        if (!Util.isNullOrNil(this.IEz)) {
            sb.append("<relevant_expand>");
            sb.append(k.b.HE(this.IEz));
            sb.append("</relevant_expand>");
        }
        if (!Util.isNullOrNil(this.IEz)) {
            sb.append("<relevant_expand>");
            sb.append(k.b.HE(this.IEz));
            sb.append("</relevant_expand>");
        }
        if (!Util.isNullOrNil(this.IEA)) {
            sb.append("<relevant_pre_searchid>");
            sb.append(k.b.HE(this.IEA));
            sb.append("</relevant_pre_searchid>");
        }
        if (!Util.isNullOrNil(this.IEB)) {
            sb.append("<relevant_shared_openid>");
            sb.append(k.b.HE(this.IEB));
            sb.append("</relevant_shared_openid>");
        }
        if (this.IEC >= 0) {
            sb.append("<rec_category>");
            sb.append(this.IEC);
            sb.append("</rec_category>");
        }
        if (!Util.isNullOrNil(this.rCq)) {
            sb.append("<shareUrl>");
            sb.append(k.b.HE(this.rCq));
            sb.append("</shareUrl>");
        }
        if (!Util.isNullOrNil(this.msN)) {
            sb.append("<shareTitle>");
            sb.append(k.b.HE(this.msN));
            sb.append("</shareTitle>");
        }
        if (!Util.isNullOrNil(this.xDQ)) {
            sb.append("<shareDesc>");
            sb.append(k.b.HE(this.xDQ));
            sb.append("</shareDesc>");
        }
        if (!Util.isNullOrNil(this.IED)) {
            sb.append("<shareImgUrl>");
            sb.append(k.b.HE(this.IED));
            sb.append("</shareImgUrl>");
        }
        if (!Util.isNullOrNil(this.IEE)) {
            sb.append("<shareString>");
            sb.append(k.b.HE(this.IEE));
            sb.append("</shareString>");
        }
        if (!Util.isNullOrNil(this.IEF)) {
            sb.append("<shareStringUrl>");
            sb.append(k.b.HE(this.IEF));
            sb.append("</shareStringUrl>");
        }
        if (!Util.isNullOrNil(this.source)) {
            sb.append("<source>");
            sb.append(k.b.HE(this.source));
            sb.append("</source>");
        }
        if (!Util.isNullOrNil(this.eby)) {
            sb.append("<sourceUrl>");
            sb.append(k.b.HE(this.eby));
            sb.append("</sourceUrl>");
        }
        if (!Util.isNullOrNil(this.IEG)) {
            sb.append("<strPlayCount>");
            sb.append(k.b.HE(this.IEG));
            sb.append("</strPlayCount>");
        }
        if (!Util.isNullOrNil(this.IEH)) {
            sb.append("<titleUrl>");
            sb.append(k.b.HE(this.IEH));
            sb.append("</titleUrl>");
        }
        if (!Util.isNullOrNil(this.IEI)) {
            sb.append("<extReqParams>");
            sb.append(k.b.HE(this.IEI));
            sb.append("</extReqParams>");
        }
        if (!Util.isNullOrNil(this.IEJ)) {
            sb.append("<tagList>");
            sb.append(k.b.HE(this.IEJ));
            sb.append("</tagList>");
        }
        if (this.IEK >= 0) {
            sb.append("<channelId>");
            sb.append(this.IEK);
            sb.append("</channelId>");
        }
        if (!Util.isNullOrNil(this.thumbUrl)) {
            sb.append("<thumbUrl>");
            sb.append(k.b.HE(this.thumbUrl));
            sb.append("</thumbUrl>");
        }
        if (!Util.isNullOrNil(this.IEL)) {
            sb.append("<shareTag>");
            sb.append(k.b.HE(this.IEL));
            sb.append("</shareTag>");
        }
        sb.append("</websearch>");
        AppMethodBeat.o(117706);
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(117707);
        this.IEy = map.get(".msg.appmsg.websearch.relevant_vid");
        this.IEz = map.get(".msg.appmsg.websearch.relevant_expand");
        this.IEA = map.get(".msg.appmsg.websearch.relevant_pre_searchid");
        this.IEB = map.get(".msg.appmsg.websearch.relevant_shared_openid");
        this.IEC = (long) Util.getInt(map.get(".msg.appmsg.websearch.rec_category"), -1);
        this.rCq = map.get(".msg.appmsg.websearch.shareUrl");
        this.msN = map.get(".msg.appmsg.websearch.shareTitle");
        this.xDQ = map.get(".msg.appmsg.websearch.shareDesc");
        this.IED = map.get(".msg.appmsg.websearch.shareImgUrl");
        this.IEE = map.get(".msg.appmsg.websearch.shareString");
        this.IEF = map.get(".msg.appmsg.websearch.shareStringUrl");
        this.source = map.get(".msg.appmsg.websearch.source");
        this.eby = map.get(".msg.appmsg.websearch.sourceUrl");
        this.IEG = map.get(".msg.appmsg.websearch.strPlayCount");
        this.IEH = map.get(".msg.appmsg.websearch.titleUrl");
        this.IEI = map.get(".msg.appmsg.websearch.extReqParams");
        this.IEJ = map.get(".msg.appmsg.websearch.tagList");
        this.IEK = Util.getLong(map.get(".msg.appmsg.websearch.channelId"), -1);
        this.thumbUrl = map.get(".msg.appmsg.websearch.thumbUrl");
        this.IEL = map.get(".msg.appmsg.websearch.shareTag");
        AppMethodBeat.o(117707);
    }

    @Override // com.tencent.mm.ag.f
    public final /* synthetic */ f aHj() {
        AppMethodBeat.i(117708);
        aj ajVar = new aj();
        ajVar.IEy = this.IEy;
        ajVar.IEz = this.IEz;
        ajVar.IEA = this.IEA;
        ajVar.IEB = this.IEB;
        ajVar.IEC = this.IEC;
        ajVar.rCq = this.rCq;
        ajVar.msN = this.msN;
        ajVar.xDQ = this.xDQ;
        ajVar.IED = this.IED;
        ajVar.IEE = this.IEE;
        ajVar.IEF = this.IEF;
        ajVar.source = this.source;
        ajVar.eby = this.eby;
        ajVar.IEG = this.IEG;
        ajVar.IEH = this.IEH;
        ajVar.IEI = this.IEI;
        ajVar.IEJ = this.IEJ;
        ajVar.IEK = this.IEK;
        ajVar.thumbUrl = this.thumbUrl;
        ajVar.IEL = this.IEL;
        AppMethodBeat.o(117708);
        return ajVar;
    }
}
