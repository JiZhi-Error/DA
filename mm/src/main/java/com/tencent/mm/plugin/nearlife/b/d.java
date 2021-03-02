package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bpd;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public final class d extends q implements m {
    public static Vector<String> AAS = new Vector<>();
    public String AAT;
    public String AAU;
    public List<b> AAV;
    public boolean AAW;
    private i callback;
    public int dJY;
    public String hes;
    final com.tencent.mm.ak.d rr;
    public int yFK;

    static {
        AppMethodBeat.i(26558);
        AppMethodBeat.o(26558);
    }

    public static boolean Tt(int i2) {
        AppMethodBeat.i(26551);
        String valueOf = String.valueOf(i2);
        if (AAS.contains(valueOf)) {
            AppMethodBeat.o(26551);
            return false;
        }
        AAS.add(valueOf);
        AppMethodBeat.o(26551);
        return true;
    }

    public static boolean Tu(int i2) {
        AppMethodBeat.i(26552);
        AAS.remove(String.valueOf(i2));
        AppMethodBeat.o(26552);
        return true;
    }

    public static void clear() {
        AppMethodBeat.i(26553);
        AAS.clear();
        AppMethodBeat.o(26553);
    }

    public d(int i2, int i3, float f2, float f3, int i4, int i5, String str, String str2, SKBuiltinBuffer_t sKBuiltinBuffer_t, String str3, int i6, boolean z, boolean z2) {
        AppMethodBeat.i(26554);
        this.dJY = 0;
        this.AAT = "";
        this.AAU = "";
        this.hes = "";
        this.AAT = str3;
        if (!(i2 == 0 || i2 == 1)) {
            Log.e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :".concat(String.valueOf(i2)));
        }
        this.dJY = i2;
        d.a aVar = new d.a();
        aVar.iLN = new bpd();
        aVar.iLO = new bpe();
        aVar.uri = "/cgi-bin/micromsg-bin/getlbslifelist";
        aVar.funcId = 603;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bpd bpd = (bpd) this.rr.iLK.iLR;
        chk chk = new chk();
        chk.LuV = str2;
        chk.LuW = i5;
        chk.LbD = f3;
        chk.LbC = f2;
        chk.LuU = str;
        chk.LuT = i4;
        bpd.LpL = chk;
        bpd.LPT = str3;
        bpd.Scene = i3;
        bpd.LXn = i6;
        if (sKBuiltinBuffer_t == null) {
            bpd.LXm = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        } else {
            bpd.LXm = sKBuiltinBuffer_t;
        }
        bpd.KMz = i2;
        bpd.LXo = z2 ? 1 : 0;
        this.AAW = z;
        Log.d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + i2 + " lon:" + f2 + " lat:" + f3 + " pre:" + i4 + " gpsSource:" + i5 + " mac" + str + " cell:" + str2 + " scene: " + i3 + " entryTime: " + i6);
        Log.d("MicroMsg.NetSceneGetLbsLifeList", "isLoadMore: %s, buf: %s", Boolean.valueOf(z), Integer.valueOf(bpd.LXm.getILen()));
        AppMethodBeat.o(26554);
    }

    public d(chk chk) {
        AppMethodBeat.i(163197);
        this.dJY = 0;
        this.AAT = "";
        this.AAU = "";
        this.hes = "";
        this.dJY = 0;
        d.a aVar = new d.a();
        aVar.iLN = new bpd();
        aVar.iLO = new bpe();
        aVar.uri = "/cgi-bin/micromsg-bin/getlbslifelist";
        aVar.funcId = 603;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bpd bpd = (bpd) this.rr.iLK.iLR;
        bpd.LpL = chk;
        bpd.LPT = this.AAT;
        bpd.Scene = 6;
        bpd.LXm = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        bpd.KMz = 0;
        AppMethodBeat.o(163197);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(26555);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(26555);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 603;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(26556);
        Log.d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
        bpe bpe = (bpe) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        this.hes = bpe.KZj;
        this.yFK = bpe.LXw;
        Log.d("MicroMsg.NetSceneGetLbsLifeList", "resp " + bpe.LXt + "searchId " + this.hes);
        boolean z = i4 == 0 || i4 == 101;
        if (i3 == 0 || z) {
            Log.d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", Integer.valueOf(bpe.KZh), Integer.valueOf(bpe.LXt), Integer.valueOf(bpe.LXr), bpe.LXv);
            this.AAU = Util.nullAs(bpe.LXv, "");
            this.AAV = new ArrayList();
            Iterator<chj> it = bpe.LXu.iterator();
            while (it.hasNext()) {
                this.AAV.add(new b(bpe.KZj, it.next()));
            }
            if (bpe.LXt > 0) {
                chj chj = bpe.LXu.get(0);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(" Bid " + chj.AAG);
                stringBuffer.append(" title " + chj.Title);
                stringBuffer.append(" link " + chj.AAN);
                stringBuffer.append(" price " + chj.AAH);
                stringBuffer.append(" rate " + chj.AAM);
                stringBuffer.append(" type " + chj.oUv);
                stringBuffer.append(" desc : ");
                Iterator<dqi> it2 = chj.AAL.iterator();
                while (it2.hasNext()) {
                    stringBuffer.append(it2.next().MTo + "-");
                }
                Log.d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", stringBuffer.toString());
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(26556);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(26556);
    }

    public final SKBuiltinBuffer_t ewY() {
        AppMethodBeat.i(26557);
        SKBuiltinBuffer_t sKBuiltinBuffer_t = ((bpe) this.rr.iLL.iLR).LXm;
        if (sKBuiltinBuffer_t == null) {
            SKBuiltinBuffer_t buffer = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
            AppMethodBeat.o(26557);
            return buffer;
        }
        AppMethodBeat.o(26557);
        return sKBuiltinBuffer_t;
    }

    public final int cYA() {
        return ((bpe) this.rr.iLL.iLR).KZh;
    }
}
