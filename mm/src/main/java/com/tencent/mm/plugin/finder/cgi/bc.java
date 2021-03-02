package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.storage.logic.e;
import com.tencent.mm.plugin.finder.storage.logic.f;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u001c\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J>\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollowVerify;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "scene", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getMention", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bc extends ax {
    private static final String TAG = TAG;
    public static final a tvg = new a((byte) 0);
    private i callback;
    private final int opType = 1;
    private d rr;
    private final int scene;
    private final ao tvf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bc(ao aoVar, bbn bbn, int i2) {
        super(bbn);
        p.h(aoVar, "mention");
        p.h(bbn, "contextObj");
        AppMethodBeat.i(242376);
        this.tvf = aoVar;
        this.scene = i2;
        d.a aVar = new d.a();
        aVar.sG(getType());
        arj arj = new arj();
        arj.LCX = this.tvf.field_followId;
        arj.dYx = this.opType;
        am amVar = am.tuw;
        arj.LAI = am.a(bbn);
        aVar.c(arj);
        arg arg = new arg();
        arg.setBaseResponse(new BaseResponse());
        aVar.d(arg);
        aVar.MB("/cgi-bin/micromsg-bin/finderfollowverify");
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(TAG, "init id:" + this.tvf.field_id + ", " + arj.LCX + " opType " + this.opType);
        AppMethodBeat.o(242376);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollowVerify$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(242377);
        AppMethodBeat.o(242377);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6618;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242374);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242374);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242375);
        Log.i(TAG, "id:" + this.tvf.field_id + ", errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            this.tvf.field_extFlag |= 4;
            e.a aVar = e.vGT;
            Log.i(TAG, "succ, id:" + this.tvf.field_id + ", modify extFlag:" + this.tvf.field_extFlag + ", updateDb ret:" + e.a.a(this.tvf, this.scene));
        } else {
            if (i4 == -4042) {
                this.tvf.field_followExpireTime = 0;
                e.a aVar2 = e.vGT;
                Log.i(TAG, "failed expire, id:" + this.tvf.field_id + ", modify extFlag:" + this.tvf.field_extFlag + ", updateDb ret:" + e.a.a(this.tvf, this.scene));
            } else if (i4 == -4043) {
                this.tvf.field_extFlag |= 8;
                e.a aVar3 = e.vGT;
                Log.i(TAG, "failed revoke, id:" + this.tvf.field_id + ", modify extFlag:" + this.tvf.field_extFlag + ", updateDb ret:" + e.a.a(this.tvf, this.scene));
            }
            f fVar = f.vGV;
            f.FW(this.tvf.field_id);
            hz hzVar = new hz();
            hzVar.dMB.id = this.tvf.field_id;
            EventCenter.instance.publish(hzVar);
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(242375);
            return;
        }
        AppMethodBeat.o(242375);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.ax
    public final b cXS() {
        return b.Enable;
    }
}
