package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J4\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetSvrExptConfig;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetSvrExptConfigResponse;", "exptIds", "", "", "(Ljava/util/List;)V", "TAG", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderGetSvrExptConfigRequest;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class o extends an<atr> {
    private final String TAG = "Finder.CgiFinderGetSvrExptConfig";
    private atq tti = new atq();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(List<Integer> list) {
        super(null);
        p.h(list, "exptIds");
        AppMethodBeat.i(242232);
        atq atq = this.tti;
        am amVar = am.tuw;
        atq.LBM = am.a(this.ttO);
        this.tti.LEB.addAll(list);
        d.a aVar = new d.a();
        aVar.c(this.tti);
        atr atr = new atr();
        atr.setBaseResponse(new BaseResponse());
        atr.getBaseResponse().ErrMsg = new dqi();
        aVar.d(atr);
        aVar.MB("/cgi-bin/micromsg-bin/findergetsvrexptconfig");
        aVar.sG(5864);
        c(aVar.aXF());
        Log.i(this.TAG, APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        AppMethodBeat.o(242232);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, atr atr, q qVar) {
        AppMethodBeat.i(242231);
        p.h(atr, "resp");
        Log.i(this.TAG, "[onCgiEnd] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread() + ' ');
        AppMethodBeat.o(242231);
    }
}
