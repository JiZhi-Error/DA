package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.protocal.protobuf.ux;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.LinkedList;

public final class w extends q implements m {
    private i callback;
    private byte[] jcK;
    private int pUh = 0;
    private final d rr;

    public w(int i2) {
        AppMethodBeat.i(112824);
        Log.d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", 1);
        d.a aVar = new d.a();
        aVar.iLN = new ux();
        aVar.iLO = new uy();
        aVar.uri = "/cgi-bin/micromsg-bin/cardsync";
        aVar.funcId = 1047;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        chh chh = new chh();
        chh.pVT = (String) g.aAh().azQ().get(ar.a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, (Object) null);
        chh.latitude = (double) am.ctW().gmu;
        chh.longitude = (double) am.ctW().gmv;
        ux uxVar = (ux) this.rr.iLK.iLR;
        uxVar.Leu = 1;
        uxVar.Lew = chh;
        uxVar.Lex = i2;
        this.pUh = i2;
        AppMethodBeat.o(112824);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1047;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(112825);
        this.callback = iVar;
        ux uxVar = (ux) this.rr.iLK.iLR;
        this.jcK = Util.decodeHexString(Util.nullAsNil((String) g.aAh().azQ().get(282880, (Object) null)));
        if (this.jcK == null || this.jcK.length == 0) {
            Log.e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
        }
        uxVar.Lev = z.aC(this.jcK);
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.jcK == null ? 0 : this.jcK.length);
        Log.i("MicroMsg.NetSceneCardSync", "doScene, keyBuf.length = %d", objArr);
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112825);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        int i5;
        AppMethodBeat.i(112826);
        Log.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            uy uyVar = (uy) this.rr.iLL.iLR;
            if (uyVar.Lez == 1) {
                Log.i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
            }
            this.jcK = z.a(uyVar.Lev, new byte[0]);
            LinkedList<abn> linkedList = uyVar.Ley == null ? null : uyVar.Ley.oTA;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(linkedList == null ? 0 : linkedList.size());
            objArr[1] = Integer.valueOf(this.jcK == null ? 0 : this.jcK.length);
            objArr[2] = Integer.valueOf(uyVar.KZh);
            Log.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d", objArr);
            if (linkedList == null || linkedList.size() <= 0) {
                Log.i("MicroMsg.NetSceneCardSync", "cmdList == null or size is 0");
                b ctP = am.ctP();
                Log.i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", Boolean.TRUE);
                synchronized (ctP.lock) {
                    try {
                        ctP.pendingList.addAll(ctP.pQE);
                        ctP.pQE.clear();
                    } catch (Throwable th) {
                        AppMethodBeat.o(112826);
                        throw th;
                    }
                }
                ctP.ctd();
            } else {
                int i6 = 0;
                for (abn abn : linkedList) {
                    if (!a(abn)) {
                        i5 = i6 + 1;
                    } else {
                        i5 = i6;
                    }
                    i6 = i5;
                }
                Log.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", Integer.valueOf(i6));
                am.ctP().ctd();
            }
            g.aAh().azQ().set(282880, Util.encodeHexString(this.jcK));
            if (uyVar.KZh > 0) {
                Log.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", Integer.valueOf(uyVar.KZh));
                int doScene = doScene(dispatcher(), this.callback);
                if (doScene <= 0) {
                    Log.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, doScene again fail, ret = %d", Integer.valueOf(doScene));
                    this.callback.onSceneEnd(3, -1, str, this);
                }
                AppMethodBeat.o(112826);
                return;
            }
            this.callback.onSceneEnd(0, 0, str, this);
            AppMethodBeat.o(112826);
            return;
        }
        Log.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, card sync fail, errType = %d, errCode = %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112826);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static boolean a(abn abn) {
        AppMethodBeat.i(112827);
        if (abn == null) {
            Log.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
            AppMethodBeat.o(112827);
            return false;
        }
        byte[] a2 = z.a(abn.Lmt);
        if (a2 == null || a2.length == 0) {
            Log.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
            AppMethodBeat.o(112827);
            return false;
        }
        Log.d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", Integer.valueOf(a2.length), Integer.valueOf(abn.Lms));
        try {
            switch (abn.Lms) {
                case 1:
                    vb vbVar = (vb) new vb().parseFrom(a2);
                    Log.i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", Integer.valueOf(vbVar.oTW));
                    switch (vbVar.oTW) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                            am.ctP().a(vbVar);
                            break;
                        case 6:
                            break;
                        default:
                            Log.e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", Integer.valueOf(vbVar.Lfo));
                            AppMethodBeat.o(112827);
                            return false;
                    }
                    AppMethodBeat.o(112827);
                    return true;
                default:
                    Log.w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", Integer.valueOf(abn.Lms));
                    AppMethodBeat.o(112827);
                    return false;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", e2.getMessage());
            AppMethodBeat.o(112827);
            return false;
        }
    }
}
