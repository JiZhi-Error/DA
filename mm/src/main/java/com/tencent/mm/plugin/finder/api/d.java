package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class d extends f {
    public String dCw;
    public String desc;
    public int scene;
    public String title;
    public String tsr;

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(168705);
        d dVar = new d();
        dVar.title = this.title;
        dVar.desc = this.desc;
        dVar.tsr = this.tsr;
        dVar.dCw = this.dCw;
        dVar.scene = this.scene;
        AppMethodBeat.o(168705);
        return dVar;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, com.tencent.mm.i.d dVar, int i2, int i3) {
        AppMethodBeat.i(168706);
        sb.append("<finderEndorsement>");
        if (!Util.isNullOrNil(this.title)) {
            sb.append("<username>");
            sb.append(k.b.HE(this.title));
            sb.append("</username>");
        }
        if (!Util.isNullOrNil(this.desc)) {
            sb.append("<nickname>");
            sb.append(k.b.HE(this.desc));
            sb.append("</nickname>");
        }
        if (!Util.isNullOrNil(this.tsr)) {
            sb.append("<relativePath>");
            sb.append(k.b.HE(this.tsr));
            sb.append("</relativePath>");
        }
        if (!Util.isNullOrNil(this.dCw)) {
            sb.append("<sceneNote>");
            sb.append(k.b.HE(this.dCw));
            sb.append("</sceneNote>");
        }
        sb.append("<scene>");
        sb.append(k.b.HE(String.valueOf(this.scene)));
        sb.append("</scene>");
        sb.append("</finderEndorsement>");
        AppMethodBeat.o(168706);
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(168707);
        this.title = map.get(".msg.appmsg.finderEndorsement.username");
        this.desc = map.get(".msg.appmsg.finderEndorsement.nickname");
        this.tsr = map.get(".msg.appmsg.finderEndorsement.relativePath");
        this.dCw = map.get(".msg.appmsg.finderEndorsement.sceneNote");
        this.scene = Util.getInt(map.get(".msg.appmsg.finderEndorsement.scene"), 0);
        AppMethodBeat.o(168707);
    }
}
