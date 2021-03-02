package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.spam.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.cof;
import com.tencent.mm.protocal.protobuf.cog;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0010J4\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiMegaVideoPost;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoPostResponse;", ClientInfoTable.Columns.CLIENTID, "", "megaVideoDesc", "Lcom/tencent/mm/protocal/protobuf/MegaVideoDesc;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/MegaVideoDesc;)V", "TAG", "getClientId", "()Ljava/lang/String;", "getMegaVideoDesc", "()Lcom/tencent/mm/protocal/protobuf/MegaVideoDesc;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/MegaVideoPostRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class ak extends c<cog> {
    private final String TAG = "Finder.CgiMegaVideoPost";
    private final String clientId;
    private cof tut;
    private final cnl tuu;

    public ak(String str, cnl cnl) {
        p.h(str, ClientInfoTable.Columns.CLIENTID);
        p.h(cnl, "megaVideoDesc");
        AppMethodBeat.i(242317);
        this.clientId = str;
        this.tuu = cnl;
        cof cof = new cof();
        cof.username = z.aUg();
        cof.clientId = this.clientId;
        cof.MtG = this.tuu;
        ap apVar = ap.tuF;
        cof.MtV = ap.cYc();
        this.tut = cof;
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder("init CgiMegaVideoPost: videoPlayLen = ");
        LinkedList<cod> linkedList = this.tuu.media;
        p.g(linkedList, "megaVideoDesc.media");
        cod cod = (cod) j.kt(linkedList);
        StringBuilder append = sb.append(cod != null ? cod.Mur : 0).append(", videoPlayLenMs = ");
        LinkedList<cod> linkedList2 = this.tuu.media;
        p.g(linkedList2, "megaVideoDesc.media");
        cod cod2 = (cod) j.kt(linkedList2);
        Log.i(str2, append.append(cod2 != null ? cod2.Mus : 0).toString());
        Log.i(this.TAG, "CgiMegaVideoPost clientId:" + this.clientId);
        d.a aVar = new d.a();
        aVar.c(this.tut);
        cog cog = new cog();
        cog.setBaseResponse(new BaseResponse());
        cog.getBaseResponse().ErrMsg = new dqi();
        aVar.d(cog);
        aVar.MB("/cgi-bin/micromsg-bin/megavideopost");
        aVar.sG(4079);
        c(aVar.aXF());
        AppMethodBeat.o(242317);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, cog cog, q qVar) {
        AppMethodBeat.i(242316);
        cog cog2 = cog;
        p.h(cog2, "resp");
        super.a(i2, i3, str, cog2, qVar);
        Log.i(this.TAG, "onCgiBack errType:" + i2 + ", errCode:" + i3 + ", errMsg:" + str);
        a aVar = a.vwk;
        a.v(i2, i3, str);
        AppMethodBeat.o(242316);
    }
}
