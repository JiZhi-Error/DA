package com.tencent.mm.plugin.ext.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J>\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/ext/net/NetSceneGetUserAuth;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "appid", "", AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, "signature", "mIOnNetSceneEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "mCallback", "<set-?>", "Lcom/tencent/mm/protocal/protobuf/GetUserAuthResp;", "resp", "getResp", "()Lcom/tencent/mm/protocal/protobuf/GetUserAuthResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "app_release"})
public final class a extends q implements m {
    private final String dNI;
    private i heq;
    private final String packageName;
    public bww sME;
    private final i sMF;
    private final String signature;

    public a(String str, String str2, String str3, i iVar) {
        p.h(str, "appid");
        p.h(str2, AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        p.h(str3, "signature");
        AppMethodBeat.i(39602);
        this.dNI = str;
        this.packageName = str2;
        this.signature = str3;
        this.sMF = iVar;
        AppMethodBeat.o(39602);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(39600);
        i iVar = this.sMF;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
        }
        i iVar2 = this.heq;
        if (iVar2 != null) {
            iVar2.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(39600);
            return;
        }
        AppMethodBeat.o(39600);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2711;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(39601);
        this.heq = iVar;
        d.a aVar = new d.a();
        bwv bwv = new bwv();
        bwv.dNI = this.dNI;
        bwv.qGp = this.packageName;
        bwv.signature = this.signature;
        aVar.c(bwv);
        this.sME = new bww();
        aVar.d(this.sME);
        aVar.MB("/cgi-bin/mmbiz-bin/getuserauth");
        aVar.sG(getType());
        aVar.sI(0);
        aVar.sJ(0);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        int dispatch = dispatch(gVar, aXF, this);
        AppMethodBeat.o(39601);
        return dispatch;
    }
}
