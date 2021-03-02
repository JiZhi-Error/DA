package com.tencent.mm.plugin.game.luggage.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class a extends f {
    public String desc;
    public String iconUrl;
    public String jumpUrl;
    public String nickName;
    public String xxN;

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(186928);
        a aVar = new a();
        aVar.iconUrl = this.iconUrl;
        aVar.nickName = this.nickName;
        aVar.desc = this.desc;
        aVar.xxN = this.xxN;
        aVar.jumpUrl = this.jumpUrl;
        AppMethodBeat.o(186928);
        return aVar;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
        AppMethodBeat.i(186929);
        sb.append("<gamecenter><namecard><iconUrl>").append(Util.escapeStringForXml(this.iconUrl)).append("</iconUrl><name>").append(Util.escapeStringForXml(this.nickName)).append("</name><desc>").append(Util.escapeStringForXml(this.desc)).append("</desc><tail>").append(Util.escapeStringForXml(this.xxN)).append("</tail><jumpUrl>").append(Util.escapeStringForXml(this.jumpUrl)).append("</jumpUrl></namecard></gamecenter>");
        AppMethodBeat.o(186929);
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(186930);
        if (map.get(".msg.appmsg.gamecenter.namecard") != null) {
            this.iconUrl = map.get(".msg.appmsg.gamecenter.namecard.iconUrl");
            this.nickName = map.get(".msg.appmsg.gamecenter.namecard.name");
            this.desc = map.get(".msg.appmsg.gamecenter.namecard.desc");
            this.xxN = map.get(".msg.appmsg.gamecenter.namecard.tail");
            this.jumpUrl = map.get(".msg.appmsg.gamecenter.namecard.jumpUrl");
        }
        AppMethodBeat.o(186930);
    }
}
