package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aqz;
import com.tencent.mm.protocal.protobuf.ara;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012J4\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFileDump;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFileDumpResponse;", ClientInfoTable.Columns.CLIENTID, "", "remoteUrl", "appId", "paramsJson", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "TAG", "getAppId", "()Ljava/lang/String;", "getClientId", "getParamsJson", "getRemoteUrl", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderFileDumpRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class j extends c<ara> {
    private final String TAG = "Finder.CgiFinderFileDump";
    private final String appId;
    private final String clientId;
    private aqz tsV;
    private final String tsW;
    private final String tsX;

    public j(String str, String str2, String str3, String str4) {
        p.h(str, ClientInfoTable.Columns.CLIENTID);
        p.h(str2, "remoteUrl");
        p.h(str3, "appId");
        p.h(str4, "paramsJson");
        AppMethodBeat.i(242218);
        this.clientId = str;
        this.tsW = str2;
        this.appId = str3;
        this.tsX = str4;
        aqz aqz = new aqz();
        aqz.username = z.aUg();
        aqz.clientId = this.clientId;
        aqz.url = this.tsW;
        aqz.LCL = this.appId;
        aqz.LCM = this.tsX;
        this.tsV = aqz;
        Log.i(this.TAG, "CgiFinderFileDump clientId:" + this.clientId);
        d.a aVar = new d.a();
        aVar.c(this.tsV);
        ara ara = new ara();
        ara.setBaseResponse(new BaseResponse());
        ara.getBaseResponse().ErrMsg = new dqi();
        aVar.d(ara);
        aVar.MB("/cgi-bin/micromsg-bin/finderfiledump");
        aVar.sG(4659);
        c(aVar.aXF());
        AppMethodBeat.o(242218);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, ara ara, q qVar) {
        AppMethodBeat.i(242217);
        ara ara2 = ara;
        p.h(ara2, "resp");
        super.a(i2, i3, str, ara2, qVar);
        Log.i(this.TAG, "onCgiBack errType:" + i2 + ", errCode:" + i3 + ", errMsg:" + str);
        AppMethodBeat.o(242217);
    }
}
