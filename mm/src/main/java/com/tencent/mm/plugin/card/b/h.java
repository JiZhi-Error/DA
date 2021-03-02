package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.b.p;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class h {
    public int ixX;
    public String ixY;
    public String ixZ;
    public String iya;
    public String iyb;
    public String iyc;
    public String iyd;
    public String iye;
    public int ver;

    public static h d(k.b bVar) {
        AppMethodBeat.i(93329);
        Map<String, String> map = bVar.izF;
        h hVar = new h();
        hVar.ixY = Util.nullAs(map.get(".msg.appmsg.giftcard_info.order_id"), "");
        hVar.ixX = p.fd(map.get(".msg.appmsg.giftcard_info.biz_uin"));
        hVar.ixZ = Util.nullAs(map.get(".msg.appmsg.giftcard_info.app_name"), "");
        hVar.iya = Util.nullAs(map.get(".msg.appmsg.giftcard_info.recv_digest"), "");
        hVar.iyb = Util.nullAs(map.get(".msg.appmsg.giftcard_info.send_digest"), "");
        hVar.iyc = Util.nullAs(map.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
        hVar.iyd = Util.nullAs(map.get(".msg.appmsg.giftcard_info.title_color"), "");
        hVar.iye = Util.nullAs(map.get(".msg.appmsg.giftcard_info.des_color"), "");
        hVar.ver = p.fd(map.get(".msg.appmsg.giftcard_info.ver"));
        AppMethodBeat.o(93329);
        return hVar;
    }
}
