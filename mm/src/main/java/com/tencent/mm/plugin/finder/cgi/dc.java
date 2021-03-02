package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J4\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderUserPage;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderUserPageResponse;", ch.COL_USERNAME, "", "enterType", "", "(Ljava/lang/String;I)V", "TAG", "getEnterType", "()I", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderUserPageRequest;", "getUsername", "()Ljava/lang/String;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class dc extends an<FinderUserPageResponse> {
    private final String TAG = "Finder.CgiFinderUserPage";
    private beb UHN = new beb();
    private final String username;
    private final int vkj = 17;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public dc(String str) {
        super(null);
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(260183);
        this.username = str;
        this.UHN.username = this.username;
        this.UHN.vkj = this.vkj;
        this.UHN.firstPageMD5 = "";
        this.UHN.LAt = z.aUg();
        beb beb = this.UHN;
        am amVar = am.tuw;
        beb.uli = am.a((bbn) null);
        aov aov = this.UHN.uli;
        if (aov != null) {
            aov.scene = 0;
        }
        beb beb2 = this.UHN;
        am amVar2 = am.tuw;
        beb2.LAv = am.cXZ();
        d.a aVar = new d.a();
        aVar.c(this.UHN);
        FinderUserPageResponse finderUserPageResponse = new FinderUserPageResponse();
        finderUserPageResponse.setBaseResponse(new BaseResponse());
        finderUserPageResponse.getBaseResponse().ErrMsg = new dqi();
        aVar.d(finderUserPageResponse);
        aVar.MB("/cgi-bin/micromsg-bin/finderuserpage");
        aVar.sG(3736);
        c(aVar.aXF());
        Log.i(this.TAG, "init username:" + this.username + ", enterType:" + this.vkj);
        AppMethodBeat.o(260183);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, FinderUserPageResponse finderUserPageResponse, q qVar) {
        AppMethodBeat.i(260182);
        p.h(finderUserPageResponse, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread() + ' ');
        AppMethodBeat.o(260182);
    }
}
