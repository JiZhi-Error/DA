package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$checkMegaVideoDetail$2$onSceneEnd$1$1"})
final class FinderMsgContract$MsgViewCallback$checkMegaVideoDetail$2$onSceneEnd$$inlined$let$lambda$1<_Ret, _Var> implements a<_Ret, _Var> {
    final /* synthetic */ int tBZ;
    final /* synthetic */ FinderMsgContract$MsgViewCallback$checkMegaVideoDetail$2 uYE;
    final /* synthetic */ ayj uYF;

    FinderMsgContract$MsgViewCallback$checkMegaVideoDetail$2$onSceneEnd$$inlined$let$lambda$1(FinderMsgContract$MsgViewCallback$checkMegaVideoDetail$2 finderMsgContract$MsgViewCallback$checkMegaVideoDetail$2, ayj ayj, int i2) {
        this.uYE = finderMsgContract$MsgViewCallback$checkMegaVideoDetail$2;
        this.uYF = ayj;
        this.tBZ = i2;
    }

    @Override // com.tencent.mm.vending.c.a
    public final /* synthetic */ Object call(Object obj) {
        String str;
        AppMethodBeat.i(249888);
        c.a aVar = (c.a) obj;
        if (aVar == null) {
            Log.i(this.uYE.uYD.TAG, "result == null id " + this.uYE.tEZ.field_id + " content " + Util.secPrint(this.uYE.tEZ.field_content));
        } else {
            if (!(aVar.errType == 0 && aVar.errCode == 0)) {
                y yVar = y.vXH;
                if (!y.gp(aVar.errType, aVar.errCode)) {
                    FinderMsgContract.MsgViewCallback.a(this.uYE.uYD, aVar.errCode);
                }
            }
            FinderObject finderObject = ((ars) aVar.iLC).feedObject;
            if (finderObject != null) {
                e.a aVar2 = e.vFX;
                p.g(finderObject, "this");
                e.a.j(finderObject);
                Intent intent = new Intent();
                bm bmVar = new bm(finderObject);
                intent.putExtra("KEY_CACHE_OBJECT_ID", bmVar.lT());
                cng cng = bmVar.tuP;
                if (cng == null || (str = cng.LOd) == null) {
                    str = "";
                }
                intent.putExtra("KEY_CACHE_OBJECT_NONCE_ID", str);
                intent.putExtra("KEY_ROUTER_UI", 0);
                FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                FinderReporterUIC.a.a(this.uYE.uYD.gte, intent, 0, 0, false, 124);
                com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.ag(this.uYE.uYD.gte, intent);
            }
        }
        x xVar = x.SXb;
        AppMethodBeat.o(249888);
        return xVar;
    }
}
