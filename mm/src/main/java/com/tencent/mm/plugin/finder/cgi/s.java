package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bcd;
import com.tencent.mm.protocal.protobuf.bce;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J4\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u000e\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveAnchorStatus;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderSetAnchorStatusResponse;", "liveId", "", "objectId", "status", "", "finderUserName", "", "liveStatus", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveAnchorStatus$CallBack;", "(JJILjava/lang/String;ILcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveAnchorStatus$CallBack;)V", "TAG", "anchorStatus", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderSetAnchorStatusRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class s extends an<bce> {
    private final String TAG;
    private a tts;
    private bcd ttt;
    private int ttu;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveAnchorStatus$CallBack;", "", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "plugin-finder_release"})
    public interface a {
        void b(int i2, int i3, String str, int i4);

        void onSuccess(int i2);
    }

    public s(long j2, long j3, int i2, String str, int i3, a aVar) {
        p.h(str, "finderUserName");
        AppMethodBeat.i(242241);
        this.TAG = "Finder.CgiFinderLiveAnchorStatus";
        this.tts = aVar;
        this.ttt = new bcd();
        this.ttu = i2;
        this.ttt.liveId = j2;
        this.ttt.hFK = j3;
        this.ttt.finderUsername = str;
        bcd bcd = this.ttt;
        am amVar = am.tuw;
        bcd.LAI = am.cXY();
        this.ttt.liveStatus = i3;
        ciq ciq = new ciq();
        ciq.MnE = (long) i2;
        ciq.MnD = cl.aWz();
        this.ttt.LGq = b.cD(ciq.toByteArray());
        d.a aVar2 = new d.a();
        aVar2.c(this.ttt);
        bce bce = new bce();
        bce.setBaseResponse(new BaseResponse());
        bce.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(bce);
        aVar2.MB("/cgi-bin/micromsg-bin/findersetanchorstatus");
        aVar2.sG(6443);
        c(aVar2.aXF());
        Log.i(this.TAG, "init " + this.ttt.liveId + ',' + this.ttt.finderUsername + ',' + this.ttu);
        AppMethodBeat.o(242241);
    }

    public /* synthetic */ s(long j2, long j3, int i2, String str, a aVar) {
        this(j2, j3, i2, str, 0, aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, bce bce, q qVar) {
        AppMethodBeat.i(242240);
        p.h(bce, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        if (i2 == 0 && i3 == 0) {
            a aVar = this.tts;
            if (aVar != null) {
                aVar.onSuccess(this.ttu);
                AppMethodBeat.o(242240);
                return;
            }
            AppMethodBeat.o(242240);
            return;
        }
        a aVar2 = this.tts;
        if (aVar2 != null) {
            aVar2.b(i2, i3, str, this.ttu);
            AppMethodBeat.o(242240);
            return;
        }
        AppMethodBeat.o(242240);
    }
}
