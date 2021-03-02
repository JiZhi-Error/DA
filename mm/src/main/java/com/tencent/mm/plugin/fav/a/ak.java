package com.tencent.mm.plugin.fav.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedList;

public final class ak extends q implements m {
    i callback = null;
    private int dML = 1;
    final d rr;
    private a tbv = new a();
    long tbw = -1;
    public boolean tbx = false;

    public ak() {
        AppMethodBeat.i(103476);
        Log.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync");
        d.a aVar = new d.a();
        aVar.iLN = new ani();
        aVar.iLO = new anj();
        aVar.uri = "/cgi-bin/micromsg-bin/favsync";
        aVar.funcId = 400;
        aVar.iLP = 195;
        aVar.respCmdId = 1000000195;
        aVar.iLQ = false;
        this.rr = aVar.aXF();
        AppMethodBeat.o(103476);
    }

    public ak(int i2) {
        AppMethodBeat.i(103477);
        Log.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync %d", Integer.valueOf(i2));
        d.a aVar = new d.a();
        aVar.iLN = new ani();
        aVar.iLO = new anj();
        aVar.uri = "/cgi-bin/micromsg-bin/favsync";
        aVar.funcId = 400;
        aVar.iLP = 195;
        aVar.respCmdId = 1000000195;
        aVar.iLQ = false;
        this.rr = aVar.aXF();
        this.dML = i2;
        AppMethodBeat.o(103477);
    }

    @Override // com.tencent.mm.ak.q
    public final boolean uniqueInNetsceneQueue() {
        return true;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(103478);
        this.callback = iVar;
        ani ani = (ani) this.rr.iLK.iLR;
        ani.Leu = this.dML;
        byte[] cUN = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavConfigStorage().cUN();
        if (this.dML == 2) {
            cUN = new byte[0];
        }
        ani.Lev = z.aC(cUN);
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(103478);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(103479);
        Log.i("MicroMsg.Fav.NetSceneFavSync", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (((af) com.tencent.mm.kernel.g.ah(af.class)).getSendService().big()) {
            Log.w("MicroMsg.Fav.NetSceneFavSync", "sending item, skip sync onGYNetEnd");
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(103479);
        } else if (i3 == 0 && i4 == 0) {
            anj anj = (anj) ((d) sVar).iLL.iLR;
            LinkedList<abn> linkedList = anj.Ley.oTA;
            if (linkedList == null || linkedList.size() <= 0) {
                if (anj.Lev.getBuffer() != null) {
                    byte[] l = ad.l(((ani) ((d) sVar).iLK.iLR).Lev.getBuffer().toByteArray(), anj.Lev.getBuffer().toByteArray());
                    if (l != null && l.length > 0) {
                        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavConfigStorage().bE(l);
                    }
                } else {
                    Log.e("MicroMsg.Fav.NetSceneFavSync", "merge key should not be null");
                }
                com.tencent.mm.kernel.g.aAh().azQ().set(8217, (Object) 1);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(103479);
                return;
            }
            Log.i("MicroMsg.Fav.NetSceneFavSync", "cmdList size:" + linkedList.size());
            if (this.dML != 2) {
                a aVar = this.tbv;
                aVar.sKS = linkedList;
                if (aVar.sKS != null && aVar.sKS.size() > 0) {
                    com.tencent.mm.kernel.g.azz().a(new al(), 0);
                }
                aVar.tby.sendEmptyMessage(0);
                AppMethodBeat.o(103479);
                return;
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(103479);
        } else {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(103479);
        }
    }

    class a {
        LinkedList<abn> sKS;
        MMHandler tby = new MMHandler("MicroMsg.Fav.NetSceneFavSync") {
            /* class com.tencent.mm.plugin.fav.a.ak.a.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(103474);
                if (a.this.sKS == null || a.this.sKS.isEmpty()) {
                    ak akVar = ak.this;
                    ani ani = (ani) akVar.rr.iLK.iLR;
                    anj anj = (anj) akVar.rr.iLL.iLR;
                    byte[] l = ad.l(ani.Lev.getBuffer().toByteArray(), anj.Lev.getBuffer().toByteArray());
                    if (l != null && l.length > 0) {
                        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavConfigStorage().bE(l);
                    }
                    ani.Lev = z.aC(l);
                    if ((ani.Leu & anj.KZh) == 0) {
                        Log.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, minUpdateTime:%d", Long.valueOf(akVar.tbw));
                        com.tencent.mm.kernel.g.aAh().azQ().set(8217, (Object) 1);
                        if (akVar.tbw > 0) {
                            LinkedList<Integer> B = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().B(akVar.tbw, -1);
                            if (B.size() > 0) {
                                akVar.tbx = true;
                                Log.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, start batch get list size:%d", Integer.valueOf(B.size()));
                                if (!com.tencent.mm.kernel.g.azz().a(new ai(B), 0)) {
                                    Log.w("MicroMsg.Fav.NetSceneFavSync", "do scene BatchGetFav fail");
                                    ai.cVc();
                                }
                            }
                        }
                        akVar.callback.onSceneEnd(0, 0, "", akVar);
                        AppMethodBeat.o(103474);
                        return;
                    }
                    Log.i("MicroMsg.Fav.NetSceneFavSync", "continue flag:%d", Integer.valueOf(anj.KZh));
                    akVar.doScene(akVar.dispatcher(), akVar.callback);
                    AppMethodBeat.o(103474);
                    return;
                }
                abn first = a.this.sKS.getFirst();
                Log.d("MicroMsg.Fav.NetSceneFavSync", "cmdId = " + first.Lms);
                a.this.sKS.removeFirst();
                switch (first.Lms) {
                    case 200:
                        byte[] a2 = z.a(first.Lmt);
                        if (a2 != null) {
                            ak akVar2 = ak.this;
                            try {
                                Object[] objArr = new Object[1];
                                objArr[0] = Integer.valueOf(a2 != null ? a2.length : 0);
                                Log.i("MicroMsg.Fav.NetSceneFavSync", "processAddItem bufSize=%d", objArr);
                                cy cyVar = (cy) new cy().parseFrom(a2);
                                if (cyVar == null) {
                                    Log.e("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem favitem null");
                                } else {
                                    Log.i("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem id:%d, flag:%d, updateSeq:%d, updateTime:%d", Integer.valueOf(cyVar.KGZ), Integer.valueOf(cyVar.KHa), Integer.valueOf(cyVar.KHc), Integer.valueOf(cyVar.KHb));
                                    if ((cyVar.KHa & 1) != 0) {
                                        b.a(((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ((long) cyVar.KGZ), false, (Runnable) null);
                                    } else {
                                        if (akVar2.tbw < 0 || ((long) cyVar.KHb) < akVar2.tbw) {
                                            akVar2.tbw = (long) cyVar.KHb;
                                        }
                                        g DZ = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ((long) cyVar.KGZ);
                                        boolean z = false;
                                        if (DZ == null) {
                                            DZ = new g();
                                            DZ.field_updateTime = ((long) cyVar.KHb) * 1000;
                                            z = true;
                                        }
                                        DZ.field_id = cyVar.KGZ;
                                        DZ.field_updateSeq = cyVar.KHc;
                                        if (DZ.field_localSeq == cyVar.KHc) {
                                            DZ.field_updateTime = ((long) cyVar.KHb) * 1000;
                                        }
                                        DZ.field_flag = cyVar.KHa;
                                        DZ.field_type = cyVar.oUv;
                                        if (z) {
                                            DZ.field_localId = System.currentTimeMillis();
                                            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().z(DZ);
                                        } else {
                                            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(DZ, ch.COL_LOCALID);
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.Fav.NetSceneFavSync", e2, "", new Object[0]);
                            }
                            sendEmptyMessage(0);
                            break;
                        } else {
                            Log.e("MicroMsg.Fav.NetSceneFavSync", "docmd: no protobuf found.");
                            sendEmptyMessage(0);
                            AppMethodBeat.o(103474);
                            return;
                        }
                }
                AppMethodBeat.o(103474);
            }
        };

        a() {
            AppMethodBeat.i(103475);
            AppMethodBeat.o(103475);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 50;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 400;
    }
}
