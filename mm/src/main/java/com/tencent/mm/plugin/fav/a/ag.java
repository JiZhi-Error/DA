package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aax;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.protocal.protobuf.da;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ag extends q implements m {
    private i callback = null;
    private final d rr;
    public g tbk;

    public ag(g gVar) {
        AppMethodBeat.i(103456);
        Log.i("MicroMsg.Fav.NetSceneAddFav", "NetSceneAddFavItem %s", Long.valueOf(gVar.field_localId));
        d.a aVar = new d.a();
        aVar.iLN = new cz();
        aVar.iLO = new da();
        aVar.uri = "/cgi-bin/micromsg-bin/addfavitem";
        aVar.funcId = 401;
        aVar.iLP = 193;
        aVar.respCmdId = 1000000193;
        this.rr = aVar.aXF();
        this.tbk = gVar;
        AppMethodBeat.o(103456);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(103457);
        cz czVar = (cz) this.rr.iLK.iLR;
        czVar.izX = x.x(this.tbk.field_xml, System.currentTimeMillis());
        czVar.oUv = this.tbk.field_type;
        czVar.KHd = this.tbk.field_sourceType;
        this.tbk.field_xml = g.t(this.tbk);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(this.tbk, ch.COL_LOCALID);
        czVar.KHf = this.tbk.field_xml;
        czVar.KHe = this.tbk.field_sourceId;
        this.tbk.arR("MicroMsg.Fav.NetSceneAddFav");
        this.callback = iVar;
        Log.i("MicroMsg.Fav.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", this.tbk.field_sourceId, Long.valueOf(this.tbk.field_localId), Integer.valueOf(this.tbk.field_id));
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(103457);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(103458);
        Log.i("MicroMsg.Fav.NetSceneAddFav", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if ((i3 == 0 && i4 == 0) || i4 == -400) {
            da daVar = (da) ((d) sVar).iLL.iLR;
            Log.i("MicroMsg.Fav.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", Integer.valueOf(daVar.KGZ), Long.valueOf(this.tbk.field_localId), Integer.valueOf(this.tbk.field_itemStatus), Integer.valueOf(daVar.KHc));
            this.tbk.field_id = daVar.KGZ;
            this.tbk.field_localSeq = daVar.KHc;
            if (this.tbk.field_itemStatus == 12) {
                Log.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd wait server upload sent");
                this.tbk.field_itemStatus = 13;
            }
            if (this.tbk.field_itemStatus == 9) {
                Log.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd item done");
                this.tbk.field_itemStatus = 10;
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().DV(this.tbk.field_localId);
                h.INSTANCE.a(10659, 0, Integer.valueOf(this.tbk.field_type), 0, Long.valueOf(b.b(this.tbk)), Long.valueOf(h.DR(this.tbk.field_localId)));
            }
            g DZ = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ((long) daVar.KGZ);
            if (DZ != null) {
                this.tbk.field_updateSeq = DZ.field_updateSeq;
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().A(DZ);
                Log.i("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", Integer.valueOf(DZ.field_id));
            }
            ad.b JW = ad.aVe().JW(this.tbk.field_sessionId);
            if (!Util.isNullOrNil(this.tbk.field_sessionId) && this.tbk.field_type == 5 && JW != null) {
                aax aax = new aax();
                aax.ehN.ehO = JW.getString("prePublishId", "");
                if (!(this.tbk.field_favProto == null || this.tbk.field_favProto.Lya == null)) {
                    aax.ehN.url = this.tbk.field_favProto.Lya.link;
                }
                if (!(!Util.isNullOrNil(aax.ehN.url) || this.tbk.field_favProto == null || this.tbk.field_favProto.LwS == null || this.tbk.field_favProto.LwS.LyC == null)) {
                    aax.ehN.url = this.tbk.field_favProto.LwS.LyC;
                }
                if (Util.isNullOrNil(aax.ehN.url)) {
                    aax.ehN.url = JW.getString("url", "");
                }
                aax.ehN.ehQ = JW.getString("preUsername", "");
                aax.ehN.ehR = JW.getString("preChatName", "");
                aax.ehN.ehS = JW.getInt("preMsgIndex", 0);
                aax.ehN.ehW = JW.getInt("sendAppMsgScene", 0);
                aax.ehN.ehX = JW.getInt("getA8KeyScene", 0);
                aax.ehN.ehY = JW.getString("referUrl", null);
                aax.ehN.ehZ = JW.getString("adExtStr", null);
                aax.ehN.ehT = "";
                aax.ehN.ehU = "";
                aax.ehN.ehV = 0;
                aax.ehN.ehP = "fav_" + z.aTY() + "_" + this.tbk.field_id;
                EventCenter.instance.publish(aax);
            }
            this.tbk.field_sessionId = null;
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(this.tbk, ch.COL_LOCALID);
            b.DH(daVar.KHg);
        }
        if (i3 == 4 && i4 == -401) {
            Log.i("MicroMsg.Fav.NetSceneAddFav", "fav fail, full size");
            if (this.tbk.cUA()) {
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(16, this.tbk.field_localId);
            } else {
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(6, this.tbk.field_localId);
            }
        }
        b.d(this.tbk);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(103458);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 401;
    }
}
