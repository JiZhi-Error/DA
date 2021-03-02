package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.beg;
import com.tencent.mm.protocal.protobuf.beh;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J4\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderUtils;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderUtilsResp;", "type", "", "url", "", "(ILjava/lang/String;)V", "TAG", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderUtilsReq;", "getType", "()I", "getUrl", "()Ljava/lang/String;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class ad extends an<beh> {
    private final String TAG;
    private beg tud;
    private final int type = 1;
    private final String url;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ad(String str) {
        super(null);
        p.h(str, "url");
        AppMethodBeat.i(242296);
        this.url = str;
        this.TAG = "Finder.CgiFinderUtils";
        this.tud = new beg();
        beg beg = this.tud;
        am amVar = am.tuw;
        beg.LAI = am.a(this.ttO);
        this.tud.username = z.aUg();
        this.tud.type = this.type;
        this.tud.url = this.url;
        d.a aVar = new d.a();
        aVar.c(this.tud);
        beh beh = new beh();
        beh.setBaseResponse(new BaseResponse());
        beh.getBaseResponse().ErrMsg = new dqi();
        aVar.d(beh);
        aVar.MB("/cgi-bin/micromsg-bin/finderutils");
        aVar.sG(4046);
        c(aVar.aXF());
        Log.i(this.TAG, "init type:" + this.type + ", url:" + this.url);
        AppMethodBeat.o(242296);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, beh beh, q qVar) {
        AppMethodBeat.i(242295);
        p.h(beh, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread() + ' ');
        AppMethodBeat.o(242295);
    }
}
