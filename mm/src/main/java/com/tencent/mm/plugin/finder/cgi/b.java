package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.apj;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B1\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ4\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiDeleteFinderComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentResponse;", "commentId", "", "feedId", "objectNonceId", "", "scene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JJLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class b extends an<apk> {
    public static final a tsG = new a((byte) 0);
    private long commentId;
    private long feedId;

    static {
        AppMethodBeat.i(165160);
        AppMethodBeat.o(165160);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, apk apk, q qVar) {
        AppMethodBeat.i(242198);
        apk apk2 = apk;
        p.h(apk2, "resp");
        Log.i("MicroMsg.Finder.CgiDeleteFinderComment", "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " resp=" + apk2 + " thread=" + Thread.currentThread() + " commentId=" + this.commentId);
        if (i2 == 0 && i3 == 0) {
            e.a aVar = e.vFX;
            FinderItem Fy = e.a.Fy(this.feedId);
            if (Fy != null) {
                Fy.setCommentCount(Fy.getCommentCount() - 1);
                hv hvVar = new hv();
                hvVar.dMr.feedId = Fy.field_id;
                hvVar.dMr.dMt = Fy.getCommentCount();
                LinkedList<FinderCommentInfo> linkedList = apk2.LBt;
                if (linkedList != null && linkedList.size() > 0) {
                    Fy.getCommentList().clear();
                    Fy.getCommentList().addAll(linkedList);
                    hv.a aVar2 = hvVar.dMr;
                    azt azt = new azt();
                    azt.commentList = Fy.getCommentList();
                    aVar2.dMs = azt;
                }
                EventCenter.instance.publish(hvVar);
                y yVar = y.vXH;
                y.a(Fy.getCommentList(), Fy.getId(), this.commentId, "");
                e.a aVar3 = e.vFX;
                e.a.n(Fy);
                hn hnVar = new hn();
                hnVar.dLW.id = Fy.field_id;
                EventCenter.instance.publish(hnVar);
                AppMethodBeat.o(242198);
                return;
            }
        }
        AppMethodBeat.o(242198);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiDeleteFinderComment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(long j2, long j3, String str, int i2, bbn bbn) {
        super(bbn);
        p.h(str, "objectNonceId");
        AppMethodBeat.i(242199);
        apj apj = new apj();
        d.a aVar = new d.a();
        aVar.c(apj);
        apk apk = new apk();
        apk.setBaseResponse(new BaseResponse());
        aVar.d(apk);
        aVar.sH(2000);
        aVar.MB("/cgi-bin/micromsg-bin/findercomment");
        aVar.sG(3906);
        c(aVar.aXF());
        Log.i("MicroMsg.Finder.CgiDeleteFinderComment", "CgiReplyFinderComment init");
        this.commentId = j2;
        this.feedId = j3;
        Log.i("MicroMsg.Finder.CgiDeleteFinderComment", "[CgiDeleteFinderComment] commentId=" + j2 + ')');
        apj apj2 = new apj();
        apj2.commentId = j2;
        apj2.opType = 1;
        apj2.hFK = j3;
        apj2.objectNonceId = str;
        apj2.scene = i2;
        am amVar = am.tuw;
        apj2.uli = am.a(bbn);
        k kVar = k.vfA;
        apj2.sessionBuffer = k.G(j3, bbn != null ? bbn.tCE : 0);
        d.a aVar2 = new d.a();
        aVar2.c(apj2);
        apk apk2 = new apk();
        apk2.setBaseResponse(new BaseResponse());
        aVar2.d(apk2);
        aVar2.sH(2000);
        aVar2.MB("/cgi-bin/micromsg-bin/findercomment");
        aVar2.sG(3906);
        c(aVar2.aXF());
        Log.i("MicroMsg.Finder.CgiDeleteFinderComment", "CgiReplyFinderComment init");
        AppMethodBeat.o(242199);
    }
}
