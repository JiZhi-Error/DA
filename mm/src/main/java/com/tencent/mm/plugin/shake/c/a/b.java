package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.c.c.a;
import com.tencent.mm.protocal.protobuf.bpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;

public final class b extends q implements m {
    public e Dhq;
    private i callback;
    private final d rr;

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1251;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(28183);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(28183);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(28184);
        Log.i("MicroMsg.NetSceneGetLbsCard", "onGYNetEnd, getType = " + getType() + " errType = " + i3 + " errCode = " + i4);
        if (i3 == 0 && i4 == 0) {
            bpc bpc = (bpc) this.rr.iLL.iLR;
            if (bpc != null) {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (!bpc.LXf) {
                    Log.e("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is false, no card , don't handle");
                } else if (bpc.LXj <= currentTimeMillis) {
                    Log.e("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + bpc.LXj + " is <= currentTime:" + currentTimeMillis + " , don't handle");
                } else if (TextUtils.isEmpty(bpc.pRX)) {
                    Log.e("MicroMsg.NetSceneGetLbsCard", "getlbscard card_tp_id is empty , don't handle");
                } else {
                    Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is true");
                    if (bpc.LXg) {
                        Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is true");
                    } else {
                        Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is false");
                    }
                    this.Dhq = new e();
                    this.Dhq.pTI = 1;
                    this.Dhq.pRX = bpc.pRX;
                    this.Dhq.eaP = bpc.eaP;
                    this.Dhq.title = bpc.title;
                    this.Dhq.pRY = bpc.pRY;
                    this.Dhq.pRZ = bpc.pRZ;
                    this.Dhq.gTG = bpc.gTG;
                    this.Dhq.iwv = bpc.iwv;
                    this.Dhq.ixw = bpc.ixw;
                    this.Dhq.Dhr = 0;
                    this.Dhq.Dhu = bpc.Dhu;
                    this.Dhq.Dhv = bpc.Dhv;
                    this.Dhq.Dhw = bpc.Dhw;
                    this.Dhq.Dhx = bpc.Dhx;
                    this.Dhq.Dhy = "";
                    this.Dhq.pSb = bpc.pSb;
                    this.Dhq.Dhz = bpc.Dhz;
                    this.Dhq.DhA = bpc.DhA;
                    com.tencent.mm.plugin.shake.b.m.eUs().Dht = this.Dhq.Dhy;
                    Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + bpc.LXj + " is <= currentTime:" + currentTimeMillis);
                    Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard activity_type: " + bpc.LXl);
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(currentTimeMillis));
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(bpc.LXj));
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, bpc.HHX);
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, bpc.LXk);
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, Integer.valueOf(bpc.LXl));
                    String eUJ = a.eUJ();
                    Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard msg reddotid is " + bpc.LXh);
                    Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre reddotid is ".concat(String.valueOf(eUJ)));
                    if (TextUtils.isEmpty(bpc.LXh)) {
                        Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard resp.red_dot_id is empty");
                    }
                    if (TextUtils.isEmpty(eUJ)) {
                        Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre_red_dot_id is empty, resp.red_dot_id is not empty");
                        com.tencent.mm.y.c.axV().B(262155, true);
                        bg.aVF();
                        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_ID_STRING_SYNC, bpc.LXh);
                        bg.aVF();
                        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_DESC_STRING_SYNC, bpc.LXi);
                    } else if (!eUJ.equals(bpc.LXh)) {
                        Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard redDotId and msg.reddotid is not empty, but no equals");
                        com.tencent.mm.y.c.axV().B(262155, true);
                        bg.aVF();
                        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_ID_STRING_SYNC, bpc.LXh);
                        bg.aVF();
                        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_DESC_STRING_SYNC, bpc.LXi);
                    } else if (eUJ.equals(bpc.LXh)) {
                        Log.i("MicroMsg.NetSceneGetLbsCard", "redDotId equals msg.reddotid");
                    }
                    h.INSTANCE.kvStat(11721, bpc.pRX);
                }
            } else {
                Log.e("MicroMsg.NetSceneGetLbsCard", "getlbscard resp is null");
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(28184);
    }
}
