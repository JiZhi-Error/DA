package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.avt;
import com.tencent.mm.protocal.protobuf.avu;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J4\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\r\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveGetContact;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetContactResponse;", "liveId", "", "objectId", "finderUserName", "", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveGetContact$CallBack;", "(JJLjava/lang/String;ILcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveGetContact$CallBack;)V", "TAG", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetContactRequest;", "resp", "getResp", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class u extends an<avu> {
    private final String TAG = "Finder.CgiFinderLiveGetContact";
    private avt ttx = new avt();
    private avu tty;
    private a ttz;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveGetContact$CallBack;", "", "onFinish", "", "success", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "plugin-finder_release"})
    public interface a {
        void a(boolean z, avn avn);
    }

    public u(long j2, long j3, String str, a aVar) {
        p.h(str, "finderUserName");
        p.h(aVar, "callback");
        AppMethodBeat.i(260175);
        this.ttz = aVar;
        this.ttx.liveId = j2;
        this.ttx.hFK = j3;
        this.ttx.username = str;
        avt avt = this.ttx;
        am amVar = am.tuw;
        avt.LAI = am.cXY();
        this.ttx.scene = 0;
        d.a aVar2 = new d.a();
        aVar2.c(this.ttx);
        avu avu = new avu();
        avu.setBaseResponse(new BaseResponse());
        avu.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(avu);
        aVar2.MB("/cgi-bin/micromsg-bin/finderlivegetcontact");
        aVar2.sG(6678);
        c(aVar2.aXF());
        Log.i(this.TAG, "init " + this.ttx.liveId + ',' + this.ttx.username + ',' + this.ttx.scene);
        AppMethodBeat.o(260175);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, avu avu, q qVar) {
        AppMethodBeat.i(242244);
        avu avu2 = avu;
        p.h(avu2, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        this.tty = avu2;
        if (i2 == 0 && i3 == 0) {
            this.ttz.a(true, avu2.uBm);
            AppMethodBeat.o(242244);
            return;
        }
        this.ttz.a(false, avu2.uBm);
        AppMethodBeat.o(242244);
    }
}
