package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.fhb;
import com.tencent.mm.protocal.protobuf.fhc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0002J4\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveSetSockPuppetAttr;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSetSockPuppetAttrResponse;", "nickname", "", "url", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveSetSockPuppetAttr$CallBack;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveSetSockPuppetAttr$CallBack;)V", "TAG", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLiveSetSockPuppetAttrRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class da extends an<fhc> {
    private final String TAG = "Finder.CgiFinderLiveSetSockPuppetAttr";
    private a UHI;
    private fhb UHJ;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveSetSockPuppetAttr$CallBack;", "", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSetSockPuppetAttrResponse;", "plugin-finder_release"})
    public interface a {
        void a(fhc fhc);

        void cZ(int i2, String str);
    }

    public da(String str, String str2, a aVar) {
        Integer num;
        p.h(str, "nickname");
        p.h(str2, "url");
        AppMethodBeat.i(260177);
        this.UHI = aVar;
        this.UHJ = new fhb();
        this.UHJ.nickname = str;
        this.UHJ.qFV = str2;
        fhb fhb = this.UHJ;
        am amVar = am.tuw;
        fhb.LBM = am.cXY();
        d.a aVar2 = new d.a();
        aVar2.c(this.UHJ);
        fhc fhc = new fhc();
        fhc.setBaseResponse(new BaseResponse());
        fhc.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(fhc);
        aVar2.MB("/cgi-bin/micromsg-bin/finderlivesetsockpuppetattr");
        aVar2.sG(6816);
        c(aVar2.aXF());
        String str3 = this.TAG;
        StringBuilder append = new StringBuilder("init nickname:").append(this.UHJ.nickname).append(",url:").append(this.UHJ.qFV).append(",live_identity:");
        aov aov = this.UHJ.LBM;
        if (aov != null) {
            num = Integer.valueOf(aov.Viq);
        } else {
            num = null;
        }
        Log.i(str3, append.append(num).toString());
        AppMethodBeat.o(260177);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, fhc fhc, q qVar) {
        AppMethodBeat.i(260176);
        fhc fhc2 = fhc;
        p.h(fhc2, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        if (i2 == 0 && i3 == 0) {
            a aVar = this.UHI;
            if (aVar != null) {
                aVar.a(fhc2);
                AppMethodBeat.o(260176);
                return;
            }
            AppMethodBeat.o(260176);
            return;
        }
        a aVar2 = this.UHI;
        if (aVar2 != null) {
            aVar2.cZ(i3, str);
            AppMethodBeat.o(260176);
            return;
        }
        AppMethodBeat.o(260176);
    }
}
