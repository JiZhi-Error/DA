package com.tencent.mm.plugin.expt.hellhound.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l;
import com.tencent.mm.plugin.expt.hellhound.b.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.cfi;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J>\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0012\u0010#\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010%H\u0002R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/model/NetSceneGetHell;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "scene", "", "rversion", "", "buildTag", "(ILjava/lang/String;Ljava/lang/String;)V", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "fillLocalIdList", "", "localIdInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ConfigId;", "getType", "noteGetHellTime", "currSvrTime", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateConfigTime", "currSvrSecond", "intervalSecond", "updateHell", "resp", "Lcom/tencent/mm/protocal/protobuf/GetHellResponse;", "Companion", "plugin-expt_release"})
public final class b extends q implements m {
    public static final a sJK = new a((byte) 0);
    private i heq;
    private final String sJI;
    private final String sJJ;
    private final int scene;

    static {
        AppMethodBeat.i(221163);
        AppMethodBeat.o(221163);
    }

    public b(int i2, String str, String str2) {
        p.h(str, "rversion");
        p.h(str2, "buildTag");
        AppMethodBeat.i(221162);
        this.scene = i2;
        this.sJI = str;
        this.sJJ = str2;
        AppMethodBeat.o(221162);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/model/NetSceneGetHell$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1021;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        ArrayList arrayList;
        AppMethodBeat.i(221158);
        this.heq = iVar;
        d.a aVar = new d.a();
        aVar.c(new boi());
        aVar.d(new boj());
        aVar.MB("/cgi-bin/mmfddataappsvr/getsessionconfig");
        aVar.sG(1021);
        aVar.sI(0);
        aVar.sJ(0);
        d aXF = aVar.aXF();
        p.g(aXF, "rr");
        com.tencent.mm.bw.a aYJ = aXF.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetHellRequest");
            AppMethodBeat.o(221158);
            throw tVar;
        }
        boi boi = (boi) aYJ;
        boi.scene = this.scene;
        e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_GET_HELL_LAST_TIME_SEC_INT, (Object) 0);
        if (obj == null) {
            t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(221158);
            throw tVar2;
        }
        boi.LWx = ((Integer) obj).intValue();
        boi.version = com.tencent.mm.loader.j.a.CLIENT_VERSION;
        boi.sJI = this.sJI;
        boi.sJJ = this.sJJ;
        LinkedList<ade> linkedList = boi.LWy;
        p.g(linkedList, "req.localIdInfos");
        b.a aVar2 = com.tencent.mm.plugin.expt.hellhound.b.a.b.sJM;
        boj cRe = b.a.cRe();
        if (cRe == null) {
            arrayList = null;
        } else if (cRe.LWB.isEmpty()) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            Iterator<cfi> it = cRe.LWB.iterator();
            while (it.hasNext()) {
                ade ade = it.next().Mlu;
                p.g(ade, "jsonPackage.idInfo");
                arrayList.add(ade);
            }
        }
        if (arrayList != null) {
            linkedList.addAll(arrayList);
        }
        Log.i("HABBYGE-MALI.NetSceneGetHell", "NetSceneGetHell, req: scene=" + boi.scene + '\n' + "lastGetSvrSecond=" + boi.LWx + '\n' + "version=" + boi.version + '\n' + "rversion=" + boi.sJI + '\n' + "buildTag=" + boi.sJJ + '\n' + "localIds=" + boi.LWy.size());
        Iterator<ade> it2 = boi.LWy.iterator();
        while (it2.hasNext()) {
            ade next = it2.next();
            Log.i("HABBYGE-MALI.NetSceneGetHell", "NetSceneGetHell, req: localId=" + next.id + ", " + next.timestamp);
        }
        l.a aVar3 = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.sIR;
        l.a.Bt(119);
        int dispatch = dispatch(gVar, aXF, this);
        AppMethodBeat.o(221158);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(221159);
        Log.i("HABBYGE-MALI.NetSceneGetHell", "onGYNetEnd, errType[" + i3 + "] erroCode[" + i4 + "] errMsg[" + str + ']');
        if (i3 != 0 || i4 != 0) {
            l.a aVar = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.sIR;
            l.a.Bt(120);
            Log.w("HABBYGE-MALI.NetSceneGetHell", "onGYNetEnd, get hell error");
            Hu((int) Util.nowSecond());
        } else if (sVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
            AppMethodBeat.o(221159);
            throw tVar;
        } else {
            com.tencent.mm.bw.a aYK = ((d) sVar).aYK();
            if (aYK == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetHellResponse");
                AppMethodBeat.o(221159);
                throw tVar2;
            }
            b((boj) aYK);
        }
        i iVar = this.heq;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(221159);
            return;
        }
        AppMethodBeat.o(221159);
    }

    private final void b(boj boj) {
        Integer num;
        dqi dqi = null;
        AppMethodBeat.i(221160);
        if (boj == null) {
            AppMethodBeat.o(221160);
        } else if (boj.getBaseResponse() == null) {
            Log.i("HABBYGE-MALI.NetSceneGetHell", "updateHell: baseResponse is NULL!!");
            l.a aVar = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.sIR;
            l.a.Bt(121);
            AppMethodBeat.o(221160);
        } else {
            BaseResponse baseResponse = boj.getBaseResponse();
            if (baseResponse == null || baseResponse.Ret != 0) {
                StringBuilder sb = new StringBuilder("updateHell, baseResp: [");
                BaseResponse baseResponse2 = boj.getBaseResponse();
                if (baseResponse2 != null) {
                    num = Integer.valueOf(baseResponse2.Ret);
                } else {
                    num = null;
                }
                StringBuilder append = sb.append(num).append("] [");
                BaseResponse baseResponse3 = boj.getBaseResponse();
                if (baseResponse3 != null) {
                    dqi = baseResponse3.ErrMsg;
                }
                Log.w("HABBYGE-MALI.NetSceneGetHell", append.append(dqi).append(']').toString());
                l.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.sIR;
                l.a.Bt(120);
                AppMethodBeat.o(221160);
                return;
            }
            Log.i("HABBYGE-MALI.NetSceneGetHell", "updateHell, resp:\nreq.rversion=" + this.sJI + '\n' + "req.buildTag=" + this.sJJ + '\n' + "currSvrSecond=" + boj.LWz + '\n' + "intervalSecond=" + boj.LWA + '\n' + "jsonPackages=" + boj.LWB.size());
            Iterator<cfi> it = boj.LWB.iterator();
            while (it.hasNext()) {
                Log.i("HABBYGE-MALI.NetSceneGetHell", "updateHell, resp: jsonPackage=" + it.next().Mlu.id);
            }
            int i2 = boj.LWz;
            int i3 = boj.LWA;
            Log.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime");
            Hu(i2);
            e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_GET_HELL_INTERVAL_SEC_INT, Integer.valueOf(i3));
            c.cNJ().m(801, boj);
            AppMethodBeat.o(221160);
        }
    }

    private static void Hu(int i2) {
        AppMethodBeat.i(221161);
        int nowSecond = (int) Util.nowSecond();
        if (nowSecond > i2) {
            Log.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime yes");
            e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_GET_HELL_LAST_TIME_SEC_INT, Integer.valueOf(nowSecond));
            AppMethodBeat.o(221161);
            return;
        }
        Log.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime no");
        e aAh2 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_GET_HELL_LAST_TIME_SEC_INT, Integer.valueOf(i2));
        AppMethodBeat.o(221161);
    }
}
