package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.cgi.cu;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$checkMegaVideoDetail$2", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class FinderMsgContract$MsgViewCallback$checkMegaVideoDetail$2 implements i {
    final /* synthetic */ ao tEZ;
    final /* synthetic */ FinderMsgContract.MsgViewCallback uYD;

    FinderMsgContract$MsgViewCallback$checkMegaVideoDetail$2(FinderMsgContract.MsgViewCallback msgViewCallback, ao aoVar) {
        this.uYD = msgViewCallback;
        this.tEZ = aoVar;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4;
        cns cns;
        String str2;
        f aYI;
        cns cns2;
        AppMethodBeat.i(249889);
        g.azz().b(4195, this);
        if (qVar == null || !qVar.isCanceled()) {
            if (qVar instanceof cu) {
                long j2 = ((cu) qVar).twJ;
                cu j3 = FinderMsgContract.MsgViewCallback.j(this.uYD);
                if (j3 == null) {
                    AppMethodBeat.o(249889);
                    return;
                } else if (j2 == j3.twJ) {
                    FinderMsgContract.MsgViewCallback.k(this.uYD);
                    if (i2 == 0 && i3 == 0) {
                        Log.i(FinderMsgContract.MsgViewCallback.c(this.uYD), "get mega video detail success, id = " + ((cu) qVar).twJ);
                        ayj cZr = ((cu) qVar).cZr();
                        y yVar = y.vXH;
                        if (y.LC(this.uYD.uYz.scene)) {
                            i4 = 7;
                        } else {
                            i4 = 5;
                        }
                        cng cng = cZr.LIA;
                        if (cng == null || (cns = cng.MtI) == null) {
                            AppMethodBeat.o(249889);
                            return;
                        }
                        long j4 = cns.hFK;
                        FinderMsgContract.MsgViewCallback msgViewCallback = this.uYD;
                        cng cng2 = cZr.LIA;
                        if (cng2 == null || (cns2 = cng2.MtI) == null) {
                            str2 = null;
                        } else {
                            str2 = cns2.objectNonceId;
                        }
                        int i5 = FinderMsgContract.MsgViewCallback.b(this.uYD).scene;
                        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                        FinderReporterUIC fH = FinderReporterUIC.a.fH(FinderMsgContract.MsgViewCallback.d(this.uYD));
                        FinderMsgContract.MsgViewCallback.a(msgViewCallback, new af(j4, str2, i4, i5, "", true, null, null, 0, null, false, false, null, fH != null ? fH.dIx() : null, 0, 24512));
                        af f2 = FinderMsgContract.MsgViewCallback.f(this.uYD);
                        if (f2 == null || (aYI = f2.aYI()) == null) {
                            AppMethodBeat.o(249889);
                            return;
                        }
                        aYI.b(new FinderMsgContract$MsgViewCallback$checkMegaVideoDetail$2$onSceneEnd$$inlined$let$lambda$1(this, cZr, i4));
                        AppMethodBeat.o(249889);
                        return;
                    }
                    FinderMsgContract.MsgViewCallback.a(this.uYD, i3);
                }
            }
            AppMethodBeat.o(249889);
            return;
        }
        Log.i(FinderMsgContract.MsgViewCallback.c(this.uYD), "get mega video detail is canceled");
        AppMethodBeat.o(249889);
    }
}
