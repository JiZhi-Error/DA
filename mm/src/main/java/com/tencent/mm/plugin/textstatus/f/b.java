package com.tencent.mm.plugin.textstatus.f;

import android.util.Base64;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.c;
import com.tencent.mm.plugin.textstatus.g.d;
import com.tencent.mm.plugin.textstatus.g.g;
import com.tencent.mm.plugin.textstatus.g.v;
import com.tencent.mm.plugin.textstatus.g.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J<\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/NetSceneModTextStatus;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "postInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getPostInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/textstatus/proto/ModTextStatusReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/ModTextStatusResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/ModTextStatusResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/ModTextStatusResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class b extends q implements m {
    public static final a FYR = new a((byte) 0);
    private c FYO;
    private d FYP;
    private final v FYQ;
    private i callback;
    private final com.tencent.mm.ak.d iUB;

    static {
        AppMethodBeat.i(216178);
        AppMethodBeat.o(216178);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/NetSceneModTextStatus$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private /* synthetic */ b() {
        this(null);
    }

    public b(v vVar) {
        byte[] bArr;
        LinkedList<String> linkedList;
        Long l;
        g gVar;
        g gVar2;
        String str = null;
        AppMethodBeat.i(216177);
        this.FYQ = vVar;
        d.a aVar = new d.a();
        aVar.sG(getType());
        aVar.MB("/cgi-bin/micromsg-bin/modtextstatus");
        aVar.c(new c());
        aVar.d(new com.tencent.mm.plugin.textstatus.g.d());
        com.tencent.mm.ak.d aXF = aVar.aXF();
        p.g(aXF, "commReqRespBuilder.buildInstance()");
        this.iUB = aXF;
        com.tencent.mm.bw.a aYJ = this.iUB.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.ModTextStatusReq");
            AppMethodBeat.o(216177);
            throw tVar;
        }
        this.FYO = (c) aYJ;
        c cVar = this.FYO;
        v vVar2 = this.FYQ;
        if (vVar2 == null || (gVar2 = vVar2.GaU) == null) {
            bArr = null;
        } else {
            bArr = gVar2.toByteArray();
        }
        byte[] encode = Base64.encode(bArr, 2);
        p.g(encode, "Base64.encode(postInfo?.…eArray(), Base64.NO_WRAP)");
        Charset charset = StandardCharsets.UTF_8;
        p.g(charset, "StandardCharsets.UTF_8");
        cVar.Gaq = new String(encode, charset);
        c cVar2 = this.FYO;
        v vVar3 = this.FYQ;
        if (vVar3 != null) {
            linkedList = vVar3.GaV;
        } else {
            linkedList = null;
        }
        cVar2.Gar = linkedList;
        StringBuilder sb = new StringBuilder("rowId:");
        v vVar4 = this.FYQ;
        if (vVar4 != null) {
            l = Long.valueOf(vVar4.Gba);
        } else {
            l = null;
        }
        StringBuilder append = sb.append(l).append(" text:");
        v vVar5 = this.FYQ;
        if (!(vVar5 == null || (gVar = vVar5.GaU) == null)) {
            str = gVar.description;
        }
        Log.i("MicroMsg.TxtStatus.NetSceneModeTextStatus", append.append(Util.secPrint(str)).toString());
        AppMethodBeat.o(216177);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 5293;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(216175);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(216175);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        String str2;
        AppMethodBeat.i(216176);
        p.h(sVar, "rr");
        Log.i("MicroMsg.TxtStatus.NetSceneModeTextStatus", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.bw.a aYK = this.iUB.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.ModTextStatusResp");
                AppMethodBeat.o(216176);
                throw tVar;
            }
            this.FYP = (com.tencent.mm.plugin.textstatus.g.d) aYK;
            com.tencent.mm.plugin.textstatus.g.d dVar = this.FYP;
            if (dVar != null) {
                String str3 = dVar.Gas;
                String str4 = dVar.Gaq;
                String str5 = str3;
                if (!(str5 == null || str5.length() == 0)) {
                    String str6 = str4;
                    if (!(str6 == null || str6.length() == 0)) {
                        g gVar = new g();
                        gVar.parseFrom(Base64.decode(dVar.Gaq, 0));
                        com.tencent.mm.plugin.textstatus.f.h.c cVar = com.tencent.mm.plugin.textstatus.f.h.c.FZX;
                        v fwe = com.tencent.mm.plugin.textstatus.f.h.c.fwe();
                        if (fwe != null) {
                            e aAh = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh, "MMKernel.storage()");
                            h dataDB = aAh.getDataDB();
                            Thread currentThread = Thread.currentThread();
                            p.g(currentThread, "Thread.currentThread()");
                            long beginTransaction = dataDB.beginTransaction(currentThread.getId());
                            Boolean bool = null;
                            v vVar = this.FYQ;
                            if (vVar != null) {
                                f fVar = f.FXJ;
                                bool = Boolean.valueOf(f.fvM().delete(vVar.Gba));
                            } else {
                                Log.e("MicroMsg.TxtStatus.NetSceneModeTextStatus", "postInfo is null?");
                            }
                            f fVar2 = f.FXJ;
                            String ceA = com.tencent.mm.plugin.auth.a.a.ceA();
                            p.g(ceA, "Account.username()");
                            long a2 = f.a(ceA, str3, gVar, 4);
                            e aAh2 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh2, "MMKernel.storage()");
                            aAh2.getDataDB().endTransaction(beginTransaction);
                            com.tencent.mm.plugin.textstatus.f.h.c cVar2 = com.tencent.mm.plugin.textstatus.f.h.c.FZX;
                            com.tencent.mm.plugin.textstatus.f.h.c.fwf();
                            com.tencent.mm.plugin.textstatus.k.a aVar = com.tencent.mm.plugin.textstatus.k.a.VeA;
                            String str7 = fwe.VdX;
                            String str8 = dVar.Gas;
                            w wVar = gVar.Gau;
                            if (wVar == null || (str2 = wVar.GaI) == null) {
                                str2 = "";
                            }
                            com.tencent.mm.plugin.textstatus.k.a.a(str7, (Long) 1L, str8, str2);
                            Log.i("MicroMsg.TxtStatus.NetSceneModeTextStatus", "onSceneEnd mod statusId:" + dVar.Gas + ", expireTime:" + gVar.pRN + " result:" + bool + " rowId:" + a2);
                        } else {
                            Log.w("MicroMsg.TxtStatus.NetSceneModeTextStatus", "onSceneEnd mod statusId:" + dVar.Gas + ", this is deleted");
                        }
                    }
                }
            }
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(216176);
            return;
        }
        AppMethodBeat.o(216176);
    }
}
