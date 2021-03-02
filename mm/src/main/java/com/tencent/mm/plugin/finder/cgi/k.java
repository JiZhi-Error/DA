package com.tencent.mm.plugin.finder.cgi;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.upload.action.f;
import com.tencent.mm.plugin.finder.utils.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J4\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFollow;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFollowResponse;", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class k extends an<arg> {
    private final String TAG = "Finder.CgiFinderFollow";
    private final f tsY;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, arg arg, q qVar) {
        AppMethodBeat.i(242221);
        p.h(arg, "resp");
        Log.i(this.TAG, "onCgiBack " + i2 + ", " + i3 + ", " + str);
        AppMethodBeat.o(242221);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(f fVar) {
        super(fVar.ttO);
        boolean z;
        int i2;
        Integer num;
        Integer num2 = null;
        int i3 = 0;
        p.h(fVar, NativeProtocol.WEB_DIALOG_ACTION);
        AppMethodBeat.i(242222);
        this.tsY = fVar;
        arf arf = new arf();
        arf.LCo = this.tsY.dNc;
        arf.opType = this.tsY.opType;
        arf.refObjectId = this.tsY.feedId;
        am amVar = am.tuw;
        arf.uli = am.a(this.ttO);
        aov aov = arf.uli;
        if (aov != null) {
            bbn bbn = this.ttO;
            aov.scene = (bbn != null ? Integer.valueOf(bbn.tyh) : null).intValue();
        }
        c cVar = c.vVc;
        bbn bbn2 = this.ttO;
        if (bbn2 == null || bbn2.tyh != 0) {
            z = true;
        } else {
            z = false;
        }
        f.a.a(cVar, "NetSceneFinderFollow_fromCommentScene_0", z, false, AnonymousClass1.tsZ, 12);
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        long j2 = this.tsY.feedId;
        aov aov2 = arf.uli;
        if (aov2 != null) {
            i2 = aov2.scene;
        } else {
            i2 = 0;
        }
        arf.sessionBuffer = com.tencent.mm.plugin.finder.report.k.G(j2, i2);
        bbn bbn3 = this.ttO;
        arf.vkj = bbn3 != null ? bbn3.wyY : i3;
        d.a aVar = new d.a();
        aVar.c(arf);
        arg arg = new arg();
        arg.setBaseResponse(new BaseResponse());
        arg.getBaseResponse().ErrMsg = new dqi();
        aVar.d(arg);
        aVar.MB("/cgi-bin/micromsg-bin/finderfollow");
        aVar.sG(3867);
        c(aVar.aXF());
        String str = this.TAG;
        StringBuilder append = new StringBuilder("CgiFinderFollow init, ").append(this.tsY.dNc).append(" opType ").append(this.tsY.opType).append(" scene ");
        bbn bbn4 = this.ttO;
        if (bbn4 != null) {
            num = Integer.valueOf(bbn4.tyh);
        } else {
            num = null;
        }
        StringBuilder append2 = append.append(num).append(" feedId ").append(this.tsY.feedId).append(" enterType");
        bbn bbn5 = this.ttO;
        Log.i(str, append2.append(bbn5 != null ? Integer.valueOf(bbn5.wyY) : num2).toString());
        AppMethodBeat.o(242222);
    }
}
