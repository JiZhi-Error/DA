package com.tencent.mm.plugin.patmsg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.util.e;
import java.util.Iterator;
import java.util.Map;

public class a extends f {
    public czg ARl = new czg();

    public a() {
        AppMethodBeat.i(206962);
        AppMethodBeat.o(206962);
    }

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(206963);
        a aVar = new a();
        aVar.ARl = this.ARl;
        AppMethodBeat.o(206963);
        return aVar;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
        AppMethodBeat.i(206964);
        czg czg = this.ARl;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<patMsg>");
        sb2.append("<chatUser>").append(czg.gnh).append("</chatUser>");
        sb2.append("<records>");
        sb2.append("<recordNum>").append(czg.yVw.size()).append("</recordNum>");
        Iterator<czh> it = czg.yVw.iterator();
        while (it.hasNext()) {
            czh next = it.next();
            sb2.append("<record>");
            sb2.append("<fromUser>").append(next.dRL).append("</fromUser>");
            sb2.append("<pattedUser>").append(next.MEA).append("</pattedUser>");
            sb2.append("<template>").append(XmlParser.getCDataWrapper(next.iBd)).append("</template>");
            if (next instanceof e.a) {
                sb2.append("<templete>").append(XmlParser.getCDataWrapper(((e.a) next).QYI)).append("</templete>");
            }
            sb2.append("<createTime>").append(next.createTime).append("</createTime>");
            sb2.append("<readStatus>").append(next.MEB).append("</readStatus>");
            sb2.append("<svrId>").append(next.oNJ).append("</svrId>");
            sb2.append("<showModifyTip>").append(next.MEC).append("</showModifyTip>");
            sb2.append("</record>");
        }
        sb2.append("</records>");
        sb2.append("</patMsg>");
        sb.append(sb2.toString());
        AppMethodBeat.o(206964);
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(206965);
        this.ARl = e.Y(".msg.appmsg", map);
        AppMethodBeat.o(206965);
    }
}
