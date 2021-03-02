package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.fgq;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0002J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveClearAliasRole;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClearAliasRoleResponse;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveClearAliasRole$CallBack;", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveClearAliasRole$CallBack;)V", "TAG", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLiveClearAliasRoleRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class cz extends an<fgr> {
    private final String TAG = "Finder.CgiFinderLiveClearAliasRole";
    private a UHG;
    private fgq UHH;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveClearAliasRole$CallBack;", "", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClearAliasRoleResponse;", "plugin-finder_release"})
    public interface a {
        void a(fgr fgr);

        void awK(int i2);
    }

    public cz(a aVar) {
        Integer num;
        AppMethodBeat.i(260174);
        this.UHG = aVar;
        this.UHH = new fgq();
        fgq fgq = this.UHH;
        am amVar = am.tuw;
        fgq.LBM = am.cXY();
        d.a aVar2 = new d.a();
        aVar2.c(this.UHH);
        fgr fgr = new fgr();
        fgr.setBaseResponse(new BaseResponse());
        fgr.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(fgr);
        aVar2.MB("/cgi-bin/micromsg-bin/finderliveclearaliasrole");
        aVar2.sG(4020);
        c(aVar2.aXF());
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("init live_identity:");
        aov aov = this.UHH.LBM;
        if (aov != null) {
            num = Integer.valueOf(aov.Viq);
        } else {
            num = null;
        }
        Log.i(str, sb.append(num).toString());
        AppMethodBeat.o(260174);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, fgr fgr, q qVar) {
        AppMethodBeat.i(260173);
        fgr fgr2 = fgr;
        p.h(fgr2, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        if (i2 == 0 && i3 == 0) {
            a aVar = this.UHG;
            if (aVar != null) {
                aVar.a(fgr2);
                AppMethodBeat.o(260173);
                return;
            }
            AppMethodBeat.o(260173);
            return;
        }
        a aVar2 = this.UHG;
        if (aVar2 != null) {
            aVar2.awK(i3);
            AppMethodBeat.o(260173);
            return;
        }
        AppMethodBeat.o(260173);
    }
}
