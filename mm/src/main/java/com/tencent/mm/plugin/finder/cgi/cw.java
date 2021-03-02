package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.a;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.apj;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J>\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "unsentComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "localObj", "getLocalObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderCommentRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cw extends ax implements m {
    private static final String TAG = TAG;
    public static final a twO = new a((byte) 0);
    private i callback;
    private d rr;
    private final apj twM = new apj();
    private final an twN;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public cw(an anVar, bbn bbn) {
        super(bbn);
        long j2;
        p.h(anVar, "unsentComment");
        AppMethodBeat.i(242568);
        this.twN = anVar;
        d.a aVar = new d.a();
        aVar.c(this.twM);
        apk apk = new apk();
        apk.setBaseResponse(new BaseResponse());
        aVar.d(apk);
        aVar.sH(CommonUtils.MAX_TIMEOUT_MS);
        aVar.MB("/cgi-bin/micromsg-bin/findercomment");
        aVar.sG(getType());
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        this.twM.username = z.aUg();
        apj apj = this.twM;
        c cVar = c.vCb;
        if (c.drg()) {
            j2 = 0;
        } else {
            j2 = this.twN.field_feedId;
        }
        apj.hFK = j2;
        this.twM.objectNonceId = this.twN.getObjectNonceId();
        this.twM.LBr = this.twN.dyf();
        this.twM.content = this.twN.getContent();
        this.twM.replyCommentId = this.twN.dyb().replyCommentId;
        this.twM.clientId = this.twN.dyg();
        this.twM.scene = this.twN.field_scene;
        this.twM.tuf = this.twN.field_actionInfo.tuf;
        this.twM.opType = 0;
        apj apj2 = this.twM;
        am amVar = am.tuw;
        apj2.uli = am.a(bbn);
        apj apj3 = this.twM;
        k kVar = k.vfA;
        long j3 = this.twN.field_feedId;
        aov aov = this.twM.uli;
        apj3.sessionBuffer = k.G(j3, aov != null ? aov.scene : 0);
        this.twM.tCE = this.twN.field_actionInfo.LAo;
        String str = TAG;
        StringBuilder append = new StringBuilder("CgiReplyFinderComment init, localId:").append(this.twN.field_localCommentId).append(", clientId:").append(this.twN.dyg()).append(", feedId:").append(this.twN.field_feedId).append(" commentScene:");
        aov aov2 = this.twM.uli;
        Log.i(str, append.append(aov2 != null ? Integer.valueOf(aov2.scene) : null).toString());
        AppMethodBeat.o(242568);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(165295);
        AppMethodBeat.o(165295);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3906;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(165292);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(165292);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242567);
        Log.i(TAG, "errType %d, errCode %d, errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            e.INSTANCE.idkeyStat(1279, 15, 1, false);
            com.tencent.mm.bw.a aYK = this.rr.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCommentResponse");
                AppMethodBeat.o(242567);
                throw tVar;
            }
            apk apk = (apk) aYK;
            this.twN.FC(cl.aWy() / 1000);
            this.twN.dyb().commentId = apk.LBs;
            LinkedList<FinderCommentInfo> linkedList = apk.LBt;
            if (!Util.isNullOrNil(linkedList)) {
                e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                FinderItem Fy = e.a.Fy(this.twN.field_feedId);
                if (Fy != null) {
                    Log.i(TAG, "add CommentCount on " + Fy.getFeedObject().hashCode() + ", " + Fy.getId() + ", " + Fy.getCommentCount());
                    Fy.getCommentList().clear();
                    Fy.getCommentList().addAll(linkedList);
                    hv hvVar = new hv();
                    hvVar.dMr.feedId = Fy.field_id;
                    hv.a aVar2 = hvVar.dMr;
                    azt azt = new azt();
                    azt.commentList = Fy.getCommentList();
                    aVar2.dMs = azt;
                    EventCenter.instance.publish(hvVar);
                    Log.i(TAG, "update expose commentList, add");
                    e.a aVar3 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                    e.a.n(Fy);
                    hn hnVar = new hn();
                    hnVar.dLW.id = Fy.field_id;
                    hnVar.dLW.type = 2;
                    EventCenter.instance.publish(hnVar);
                }
            }
            this.twN.field_state = 2;
        } else {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 16, 1, false);
            this.twN.field_state = 1;
        }
        com.tencent.mm.plugin.finder.spam.a aVar4 = com.tencent.mm.plugin.finder.spam.a.vwk;
        com.tencent.mm.plugin.finder.spam.a.v(i3, i4, str);
        com.tencent.mm.plugin.finder.spam.a aVar5 = com.tencent.mm.plugin.finder.spam.a.vwk;
        com.tencent.mm.plugin.finder.spam.a.w(i3, i4, MMApplicationContext.getContext().getString(R.string.cjh));
        com.tencent.mm.plugin.finder.spam.a aVar6 = com.tencent.mm.plugin.finder.spam.a.vwk;
        com.tencent.mm.plugin.finder.spam.a.x(i3, i4, MMApplicationContext.getContext().getString(R.string.cjg));
        ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderActionStorage();
        long j2 = this.twN.field_feedId;
        long j3 = this.twN.dyb().commentId;
        long j4 = this.twN.field_localCommentId;
        a.C1279a aVar7 = com.tencent.mm.plugin.finder.storage.a.vwq;
        com.tencent.mm.plugin.finder.storage.a.a(j2, j3, j4, com.tencent.mm.plugin.finder.storage.a.vwo, this.twN);
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242567);
    }
}
