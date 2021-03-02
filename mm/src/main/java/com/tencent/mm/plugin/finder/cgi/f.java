package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aow;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.azz;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J4\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u000b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderBatchGetObjectAsyncLoadInfoRequest;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "objectIds", "", "Lkotlin/Pair;", "", "", "scene", "", "(Ljava/util/List;I)V", "TAG", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class f extends an<aox> {
    private final String TAG;
    private aow tsN;

    public /* synthetic */ f(List list) {
        this(list, 0);
    }

    public f(List<o<Long, String>> list, int i2) {
        p.h(list, "objectIds");
        AppMethodBeat.i(242208);
        this.TAG = "Finder.CgiFinderBatchGetObjectAsyncLoadInfoRequest";
        this.tsN = new aow();
        aow aow = this.tsN;
        am amVar = am.tuw;
        aow.LAI = am.cXY();
        LinkedList<azz> linkedList = new LinkedList<>();
        for (T t : list) {
            azz azz = new azz();
            azz.object_id = t.first.longValue();
            azz.object_nonce_id = t.second;
            linkedList.add(azz);
        }
        Log.i(this.TAG, "init idList " + linkedList.size() + " objectIds: " + list.size());
        this.tsN.LAU = linkedList;
        this.tsN.scene = i2;
        d.a aVar = new d.a();
        aVar.c(this.tsN);
        aox aox = new aox();
        aox.setBaseResponse(new BaseResponse());
        aox.getBaseResponse().ErrMsg = new dqi();
        aVar.d(aox);
        aVar.MB("/cgi-bin/micromsg-bin/finderbatchgetobjectasyncloadinfo");
        aVar.sG(6499);
        c(aVar.aXF());
        Log.i(this.TAG, APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        AppMethodBeat.o(242208);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, aox aox, q qVar) {
        AppMethodBeat.i(242207);
        p.h(aox, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        AppMethodBeat.o(242207);
    }
}
