package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.protocal.protobuf.ayt;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001 B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J8\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH\u0016J(\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH\u0016J(\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyBlackList;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "cmdBufItem", "getCmdId", "", "handleUpdateResult", "", "retCode", "modifyCommentBlackList", "commentId", "", "feedId", "feedNonceId", "isBlack", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyFansBlackList", "fansId", "modifyLiveBlackList", ch.COL_USERNAME, "Companion", "plugin-finder_release"})
public final class g extends k<ayt> implements i, t {
    private static final int txJ = 1;
    private static final int txK = 2;
    public static final a txL = new a((byte) 0);
    private final String TAG = "Finder.FinderModifyBlackListService";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ b di(ayt ayt) {
        AppMethodBeat.i(165296);
        ayt ayt2 = ayt;
        p.h(ayt2, "cmdBufItem");
        b cD = b.cD(ayt2.toByteArray());
        AppMethodBeat.o(165296);
        return cD;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ void n(ayt ayt, int i2) {
        AppMethodBeat.i(165300);
        p.h(ayt, "cmdBufItem");
        AppMethodBeat.o(165300);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final int getCmdId() {
        AppMethodBeat.i(165297);
        bx.a aVar = bx.tvW;
        int i2 = bx.tvM;
        AppMethodBeat.o(165297);
        return i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService$Companion;", "", "()V", "ModBlackListOpAdd", "", "getModBlackListOpAdd", "()I", "ModBlackListOpDel", "getModBlackListOpDel", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(165301);
        AppMethodBeat.o(165301);
    }

    @Override // com.tencent.mm.plugin.i.a.t
    public final void b(String str, boolean z, ai<ayt> aiVar) {
        AppMethodBeat.i(165298);
        p.h(str, "fansId");
        ayt ayt = new ayt();
        ayt.dMj = str;
        if (z) {
            ayt.opType = txJ;
        } else {
            ayt.opType = txK;
        }
        a(ayt, aiVar, false);
        AppMethodBeat.o(165298);
    }

    @Override // com.tencent.mm.plugin.i.a.t
    public final void a(long j2, long j3, String str, ai<ayt> aiVar) {
        AppMethodBeat.i(165299);
        p.h(str, "feedNonceId");
        ayt ayt = new ayt();
        ayt.tuj = j2;
        ayt.refObjectId = j3;
        ayt.refObjectNonceId = str;
        ayt.opType = txJ;
        a(ayt, aiVar, false);
        AppMethodBeat.o(165299);
    }

    @Override // com.tencent.mm.plugin.i.a.t
    public final void b(String str, ai<ayt> aiVar) {
        AppMethodBeat.i(242660);
        p.h(str, ch.COL_USERNAME);
        ayt ayt = new ayt();
        ayt.username = str;
        ayt.opType = txJ;
        a(ayt, aiVar, false);
        AppMethodBeat.o(242660);
    }
}
