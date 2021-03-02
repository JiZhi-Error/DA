package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b¢\u0006\u0002\u0010\u0019J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'H\u0002J\b\u0010*\u001a\u00020\u001dH\u0016J4\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010\u00062\u0006\u00100\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u000101H\u0016R\u0011\u0010\u0013\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0014\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u000e\u0010\u0011\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "feedId", "", "objectNonceId", "", "enterScene", "", "scene", "feedUsername", "needObject", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "rootComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "refCommentId", ch.COL_USERNAME, "down", "justUpdateObjectStatus", "encryptedObjectId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "pullScene", "(JLjava/lang/String;IILjava/lang/String;ZLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;JLjava/lang/String;ZZLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "getDown", "()Z", "enableReportVal", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "getEnterScene", "()I", "getFeedUsername", "()Ljava/lang/String;", "getJustUpdateObjectStatus", "getPullScene", "rootCommentId", "getScene", "filterDuplicate", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "svrComment", "isEnableReport", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class af extends an<ars> {
    public static final a tun = new a((byte) 0);
    private final int enterScene;
    private final long feedId;
    private final String objectNonceId;
    private final int scene;
    private b ttH;
    private long tuf;
    private final String tug;
    private boolean tuh;
    private an tui;
    private final long tuj;
    private final boolean tuk;
    private final boolean tul;
    private final int tum;
    private String username;

    static {
        AppMethodBeat.i(165180);
        AppMethodBeat.o(165180);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, ars ars, q qVar) {
        AppMethodBeat.i(242299);
        ars ars2 = ars;
        p.h(ars2, "resp");
        Log.i("Finder.CgiGetFinderFeedComment", "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " resp=" + ars2 + " thread=" + Thread.currentThread());
        if (i2 >= 4) {
            this.ttH = b.Default;
        }
        if (i2 == 0 && i3 == 0) {
            if (this.tuh) {
                Log.i("Finder.CgiGetFinderFeedComment", "need fetch object");
                FinderObject finderObject = ars2.feedObject;
                if (finderObject != null) {
                    p.g(finderObject, LocaleUtil.ITALIAN);
                    d(finderObject);
                }
            }
            LinkedList<FinderCommentInfo> linkedList = ars2.LDe;
            p.g(linkedList, "resp.commentInfo");
            ars2.LDe = ae(linkedList);
            an anVar = this.tui;
            if (anVar != null) {
                anVar.dyb().lastBuffer = ars2.lastBuffer;
                if (this.tuk) {
                    anVar.dyb().continueFlag = ars2.LDf;
                } else {
                    anVar.dyb().upContinueFlag = ars2.upContinueFlag;
                }
            }
            Log.i("Finder.CgiGetFinderFeedComment", "[onCgiBack] feedId=" + this.feedId + "  size=" + ars2.LDe.size() + " commentCount=" + ars2.commentCount);
        }
        AppMethodBeat.o(242299);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ af(long r21, java.lang.String r23, int r24, int r25, java.lang.String r26, boolean r27, com.tencent.mm.bw.b r28, com.tencent.mm.plugin.finder.storage.an r29, long r30, java.lang.String r32, boolean r33, boolean r34, java.lang.String r35, com.tencent.mm.protocal.protobuf.bbn r36, int r37, int r38) {
        /*
        // Method dump skipped, instructions count: 123
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.cgi.af.<init>(long, java.lang.String, int, int, java.lang.String, boolean, com.tencent.mm.bw.b, com.tencent.mm.plugin.finder.storage.an, long, java.lang.String, boolean, boolean, java.lang.String, com.tencent.mm.protocal.protobuf.bbn, int, int):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0227  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private af(long r11, java.lang.String r13, int r14, int r15, java.lang.String r16, boolean r17, com.tencent.mm.bw.b r18, com.tencent.mm.plugin.finder.storage.an r19, long r20, java.lang.String r22, boolean r23, boolean r24, java.lang.String r25, com.tencent.mm.protocal.protobuf.bbn r26, int r27) {
        /*
        // Method dump skipped, instructions count: 553
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.cgi.af.<init>(long, java.lang.String, int, int, java.lang.String, boolean, com.tencent.mm.bw.b, com.tencent.mm.plugin.finder.storage.an, long, java.lang.String, boolean, boolean, java.lang.String, com.tencent.mm.protocal.protobuf.bbn, int):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment$Companion;", "", "()V", "getIdScene", "", "scene", "commentScene", "feedUsername", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
    public final b cXS() {
        return this.ttH;
    }

    private static LinkedList<FinderCommentInfo> ae(LinkedList<FinderCommentInfo> linkedList) {
        T t;
        boolean z;
        AppMethodBeat.i(165177);
        LinkedList<FinderCommentInfo> linkedList2 = new LinkedList<>();
        for (T t2 : linkedList) {
            Iterator<T> it = linkedList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (t.commentId == t2.commentId) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            if (t == null) {
                linkedList2.add(t2);
            } else {
                Log.w("Finder.CgiGetFinderFeedComment", "filterDuplicate " + t2.commentId + " content " + t2.content + " username " + t2.username);
            }
        }
        AppMethodBeat.o(165177);
        return linkedList2;
    }
}
