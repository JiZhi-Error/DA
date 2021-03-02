package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class c extends f {
    public String ivO;
    public String ivP;
    public String ivQ;
    public String ivR;
    public String ivS;
    public String ivT;
    public String ivU;
    public String ivV;
    public String ivW;
    public String ivX;
    public String ivY;
    public String ivZ;
    public String iwa;
    public g iwb;
    public int subType;

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(20230);
        c cVar = new c();
        AppMethodBeat.o(20230);
        return cVar;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(20231);
        if (bVar.type == 2001) {
            this.iwb = new g();
            this.iwb.a(map, bVar);
            this.ivO = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.locallogoicon"));
            this.ivP = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.localbubbleicon"));
            this.ivQ = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.effectresource"));
            Log.i("MicroMsg.AppContentC2cMsgPiece", "locallogoicon: %s, localbubbleicon: %s, effectResource: %s", this.ivO, this.ivP, this.ivQ);
            this.ivR = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.corpname"));
            if (!Util.isNullOrNil(this.iwb.iwl)) {
                this.ivS = this.iwb.iwl;
            } else {
                this.ivS = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.senderc2cshowsourceurl"));
            }
            if (!Util.isNullOrNil(this.iwb.iwm)) {
                this.ivT = this.iwb.iwm;
            } else {
                this.ivT = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.senderc2cshowsourcemd5"));
            }
            if (!Util.isNullOrNil(this.iwb.iwn)) {
                this.ivU = this.iwb.iwn;
            } else {
                this.ivU = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourceurl"));
            }
            if (!Util.isNullOrNil(this.iwb.iwo)) {
                this.ivV = this.iwb.iwo;
            } else {
                this.ivV = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourcemd5"));
            }
            if (!Util.isNullOrNil(this.iwb.iwp)) {
                this.ivW = this.iwb.iwp;
            } else {
                this.ivW = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.recshowsourceurl"));
            }
            if (!Util.isNullOrNil(this.iwb.iwq)) {
                this.ivX = this.iwb.iwq;
            } else {
                this.ivX = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.recshowsourcemd5"));
            }
            if (!Util.isNullOrNil(this.iwb.iwr)) {
                this.ivY = this.iwb.iwr;
            } else {
                this.ivY = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.detailshowsourceurl"));
            }
            if (!Util.isNullOrNil(this.iwb.iws)) {
                this.ivZ = this.iwb.iws;
            } else {
                this.ivZ = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.detailshowsourcemd5"));
            }
            this.subType = Util.getInt(map.get(".msg.appmsg.wcpayinfo.subtype"), 0);
            this.iwa = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.exclusive_recv_username"));
        }
        AppMethodBeat.o(20231);
    }
}
