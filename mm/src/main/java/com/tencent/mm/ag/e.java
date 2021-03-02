package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class e extends f {
    public int duration = -1;
    public int iwc = -1;
    public int iwd = -1;
    public int iwe = 0;
    public int iwf = 0;
    public int iwg = 0;
    public boolean iwh = false;
    public y iwi;
    public int iwj = 0;
    public String vid = "";
    public int videoHeight = -1;
    public int videoWidth = -1;

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(123934);
        if (this.iwc != -1 || this.iwh || this.iwj == 1) {
            e eVar = new e();
            eVar.iwc = this.iwc;
            eVar.iwd = this.iwd;
            eVar.duration = this.duration;
            eVar.videoWidth = this.videoWidth;
            eVar.videoHeight = this.videoHeight;
            eVar.iwe = this.iwe;
            eVar.vid = this.vid;
            eVar.iwg = this.iwg;
            eVar.iwh = this.iwh;
            eVar.iwi = this.iwi;
            eVar.iwf = this.iwf;
            eVar.iwj = this.iwj;
            AppMethodBeat.o(123934);
            return eVar;
        }
        AppMethodBeat.o(123934);
        return null;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
        AppMethodBeat.i(123935);
        if (this.iwc != -1 || this.iwj == 1) {
            if (!Util.isNullOrNil(this.vid)) {
                this.iwe = 1;
            }
            sb.append("<mmreadershare><itemshowtype>").append(this.iwc).append("</itemshowtype><ispaysubscribe>").append(this.iwf).append("</ispaysubscribe>");
            if (this.iwj == 1) {
                sb.append("<showsourceinfo>").append(this.iwj).append("</showsourceinfo>");
            }
            if (this.iwc == 5) {
                sb.append("<pubtime>").append(this.iwd).append("</pubtime><duration>").append(this.duration).append("</duration><width>").append(this.videoWidth).append("</width><height>").append(this.videoHeight).append("</height><nativepage>").append(this.iwe).append("</nativepage><funcflag>").append(this.iwg).append("</funcflag><vid>").append(Util.escapeStringForXml(this.vid)).append("</vid>");
            }
            sb.append("</mmreadershare>");
        }
        if (this.iwh && this.iwi != null) {
            sb.append("<mmbrandmpvideo><vid>").append(Util.escapeStringForXml(this.iwi.KOf)).append("</vid><videourl>").append(Util.escapeStringForXml(this.iwi.videoUrl)).append("</videourl><mpurl>").append(Util.escapeStringForXml(this.iwi.KOe)).append("</mpurl><thumbwidth>").append(this.iwi.width).append("</thumbwidth><thumbheight>").append(this.iwi.height).append("</thumbheight><duration>").append(this.iwi.videoDuration).append("</duration>");
            sb.append("</mmbrandmpvideo>");
        }
        AppMethodBeat.o(123935);
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(123936);
        this.iwf = Util.getInt(map.get(".msg.appmsg.mmreadershare.ispaysubscribe"), 0);
        this.iwc = Util.getInt(map.get(".msg.appmsg.mmreadershare.itemshowtype"), -1);
        this.iwj = Util.getInt(map.get(".msg.appmsg.mmreadershare.showsourceinfo"), 0);
        if (this.iwc == 5) {
            this.iwd = Util.getInt(map.get(".msg.appmsg.mmreadershare.pubtime"), 0);
            this.duration = Util.getInt(map.get(".msg.appmsg.mmreadershare.duration"), 0);
            this.videoWidth = Util.getInt(map.get(".msg.appmsg.mmreadershare.width"), 0);
            this.videoHeight = Util.getInt(map.get(".msg.appmsg.mmreadershare.height"), 0);
            this.iwe = Util.getInt(map.get(".msg.appmsg.mmreadershare.nativepage"), 0);
            this.iwg = Util.getInt(map.get(".msg.appmsg.mmreadershare.funcflag"), 0);
            this.vid = map.get(".msg.appmsg.mmreadershare.vid");
        }
        if (!Util.isNullOrNil(map.get(".msg.appmsg.mmbrandmpvideo.mpurl")) && !Util.isNullOrNil(map.get(".msg.appmsg.mmbrandmpvideo.videourl"))) {
            this.iwh = true;
            this.iwi = new y();
            this.iwi.KOf = map.get(".msg.appmsg.mmbrandmpvideo.vid");
            this.iwi.videoUrl = map.get(".msg.appmsg.mmbrandmpvideo.videourl");
            this.iwi.KOe = map.get(".msg.appmsg.mmbrandmpvideo.mpurl");
            this.iwi.iAo = map.get(".msg.appmsg.thumburl");
            this.iwi.title = map.get(".msg.appmsg.title");
            this.iwi.url = map.get(".msg.appmsg.url");
            this.iwi.dHc = map.get(".msg.appmsg.sourceusername");
            this.iwi.iAg = map.get(".msg.appmsg.sourcedisplayname");
            this.iwi.videoDuration = (int) Util.getFloat(map.get(".msg.appmsg.mmbrandmpvideo.duration"), 0.0f);
            this.iwi.width = (int) Util.getFloat(map.get(".msg.appmsg.mmbrandmpvideo.thumbwidth"), 0.0f);
            this.iwi.height = (int) Util.getFloat(map.get(".msg.appmsg.mmbrandmpvideo.thumbheight"), 0.0f);
        }
        AppMethodBeat.o(123936);
    }
}
