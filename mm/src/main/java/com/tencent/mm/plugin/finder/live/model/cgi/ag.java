package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.fgo;
import com.tencent.mm.protocal.protobuf.fgp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eBI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0016\u001a\u00020\u0017H\u0002J4\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0011\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMicContactResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "usernameList", "Ljava/util/LinkedList;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", "(JJLjava/lang/String;[BILjava/util/LinkedList;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMicContactRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class ag extends k<fgp> {
    private final String TAG = "Finder.CgiFinderLiveBatchGetMicContact";
    private fgo UKS = new fgo();
    private final a UKT;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMicContactResponse;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, fgp fgp);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ag(long j2, long j3, String str, byte[] bArr, LinkedList<String> linkedList, a aVar) {
        super((byte) 0);
        p.h(linkedList, "usernameList");
        AppMethodBeat.i(260514);
        this.UKT = aVar;
        this.UKS.hyH = j2;
        fgo fgo = this.UKS;
        am amVar = am.tuw;
        fgo.LBM = am.cXY();
        this.UKS.object_id = j3;
        this.UKS.object_nonce_id = str;
        this.UKS.LFp = b.cD(bArr);
        this.UKS.LAt = z.aUg();
        this.UKS.scene = 1;
        this.UKS.ViY = linkedList;
        d.a aVar2 = new d.a();
        aVar2.c(this.UKS);
        fgp fgp = new fgp();
        fgp.setBaseResponse(new BaseResponse());
        fgp.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(fgp);
        aVar2.MB("/cgi-bin/micromsg-bin/finderlivebatchgetmiccontact");
        aVar2.sG(4224);
        c(aVar2.aXF());
        AppMethodBeat.o(260514);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(260513);
        fgp fgp = (fgp) dpc;
        p.h(fgp, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        a aVar = this.UKT;
        if (aVar != null) {
            aVar.a(i2, i3, fgp);
            AppMethodBeat.o(260513);
            return;
        }
        AppMethodBeat.o(260513);
    }
}
