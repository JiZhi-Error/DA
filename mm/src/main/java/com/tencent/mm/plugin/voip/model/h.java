package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.protocal.protobuf.dtu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class h extends q implements m {
    private static final Set<Long> GTU = new HashSet();
    private static final List<Object> jcO = new ArrayList();
    private i callback;
    private final List<ca> jcP = new LinkedList();
    private long msgId;
    private d rr;

    static {
        AppMethodBeat.i(114860);
        AppMethodBeat.o(114860);
    }

    public h(String str, String str2, int i2) {
        AppMethodBeat.i(114853);
        Log.d("MicroMsg.NetSceneSendMsg", "dktext :" + Util.getStack());
        if (!Util.isNullOrNil(str)) {
            ca caVar = new ca();
            caVar.setStatus(1);
            caVar.Cy(str);
            caVar.setCreateTime(bp.Kw(str));
            caVar.nv(1);
            caVar.setContent(str2);
            caVar.setType(i2);
            this.msgId = ((l) g.af(l.class)).eiy().aC(caVar);
            Assert.assertTrue(this.msgId != -1);
            Log.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.msgId);
        }
        AppMethodBeat.o(114853);
    }

    public h() {
        AppMethodBeat.i(114854);
        Log.d("MicroMsg.NetSceneSendMsg", "dktext :" + Util.getStack());
        Log.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
        AppMethodBeat.o(114854);
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 10;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        AppMethodBeat.i(114855);
        if (this.jcP.size() > 0) {
            q.b bVar = q.b.EOk;
            AppMethodBeat.o(114855);
            return bVar;
        }
        q.b bVar2 = q.b.EFailed;
        AppMethodBeat.o(114855);
        return bVar2;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(114856);
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.iLN = new dtt();
        aVar.iLO = new dtu();
        aVar.uri = "/cgi-bin/micromsg-bin/newsendmsg";
        aVar.funcId = 522;
        aVar.iLP = TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS;
        aVar.respCmdId = 1000000237;
        this.rr = aVar.aXF();
        dtt dtt = (dtt) this.rr.iLK.iLR;
        List<ca> eiL = ((l) g.af(l.class)).eiy().eiL();
        if (eiL == null || eiL.size() == 0) {
            Log.i("MicroMsg.NetSceneSendMsg", "no sending message");
            AppMethodBeat.o(114856);
            return -2;
        }
        this.jcP.clear();
        for (int i2 = 0; i2 < eiL.size(); i2++) {
            ca caVar = eiL.get(i2);
            if (caVar.field_isSend == 1) {
                cot cot = new cot();
                cot.KHm = new dqi().bhy(caVar.field_talker);
                cot.CreateTime = (int) (caVar.field_createTime / 1000);
                cot.oUv = caVar.getType();
                cot.iAc = caVar.field_content;
                cot.MuU = x.x(z.aTY(), caVar.field_createTime).hashCode();
                cot.KHq = br.aVW();
                if (((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(caVar.field_talker)) {
                    cot.LbN = ((l) g.af(l.class)).aSN().bjT(caVar.field_talker);
                }
                dtt.oTA.add(cot);
                dtt.oTz = dtt.oTA.size();
                this.jcP.add(caVar);
            }
        }
        int dispatch = dispatch(gVar, this.rr, this);
        if (dispatch < 0) {
            bdK();
        }
        AppMethodBeat.o(114856);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 522;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(114857);
        Log.i("MicroMsg.NetSceneSendMsg", "onGYNetEnd errtype:" + i3 + " errcode:" + i4);
        dtu dtu = (dtu) this.rr.iLL.iLR;
        if (dtu != null && (i3 == 4 || (i3 == 0 && i4 == 0))) {
            ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(dtu.LbO);
        }
        if (i3 == 0 && i4 == 0) {
            LinkedList<cou> linkedList = dtu.oTA;
            if (this.jcP.size() == linkedList.size()) {
                int i5 = 0;
                while (i5 < linkedList.size()) {
                    cou cou = linkedList.get(i5);
                    if (cou.Ret != 0) {
                        Log.e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + cou.Ret);
                        tC(i5);
                        this.callback.onSceneEnd(4, cou.Ret, str, this);
                        AppMethodBeat.o(114857);
                        return;
                    }
                    long j2 = this.jcP.get(i5).field_msgId;
                    Log.i("MicroMsg.NetSceneSendMsg", "msg local id = " + j2 + ", SvrId = " + cou.Brn + " sent successfully!");
                    ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
                    Hb.yF(cou.Brn);
                    Hb.setStatus(2);
                    ((l) g.af(l.class)).eiy().a(j2, Hb);
                    i5++;
                }
                Log.i("MicroMsg.NetSceneSendMsg", "total " + i5 + " msgs sent successfully");
            }
            int doScene = doScene(dispatcher(), this.callback);
            if (doScene == -2) {
                this.callback.onSceneEnd(0, 0, str, this);
                AppMethodBeat.o(114857);
                return;
            }
            if (doScene < 0) {
                this.callback.onSceneEnd(3, -1, str, this);
            }
            AppMethodBeat.o(114857);
            return;
        }
        bdK();
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(114857);
    }

    private void bdK() {
        AppMethodBeat.i(114858);
        for (int i2 = 0; i2 < this.jcP.size(); i2++) {
            tC(i2);
        }
        AppMethodBeat.o(114858);
    }

    private void tC(int i2) {
        AppMethodBeat.i(114859);
        ca caVar = this.jcP.get(i2);
        caVar.setStatus(5);
        ((l) g.af(l.class)).eiy().a(caVar.field_msgId, caVar);
        Iterator<Object> it = jcO.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(114859);
    }
}
