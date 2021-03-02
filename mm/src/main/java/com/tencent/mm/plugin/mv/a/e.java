package com.tencent.mm.plugin.mv.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.csp;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 j2\u00020\u0001:\u0001jB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001e\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\f\"\u0004\b0\u0010\u000eR\u001e\u00101\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b2\u0010$\"\u0004\b3\u0010&R\u001c\u00104\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u000eR\u001a\u00107\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\u001c\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010H\"\u0004\bM\u0010JR\u001c\u0010N\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010=\"\u0004\bP\u0010?R \u0010Q\u001a\b\u0012\u0004\u0012\u00020;0RX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR \u0010W\u001a\b\u0012\u0004\u0012\u00020;0RX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010T\"\u0004\bY\u0010VR\u001a\u0010Z\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0014\"\u0004\b\\\u0010\u0016R\u001c\u0010]\u001a\u0004\u0018\u00010^X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010c\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010H\"\u0004\be\u0010JR \u0010f\u001a\b\u0012\u0004\u0012\u00020g0RX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010T\"\u0004\bi\u0010V¨\u0006k"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MusicMv;", "", "()V", "commentCount", "", "getCommentCount", "()I", "setCommentCount", "(I)V", "coverUrl", "", "getCoverUrl", "()Ljava/lang/String;", "setCoverUrl", "(Ljava/lang/String;)V", "forwardCount", "getForwardCount", "setForwardCount", "isDelete", "", "()Z", "setDelete", "(Z)V", "isFullScreen", "setFullScreen", "isLike", "setLike", "likeCount", "getLikeCount", "setLikeCount", "localCoverPath", "getLocalCoverPath", "setLocalCoverPath", ch.COL_LOCALID, "", "getLocalId", "()Ljava/lang/Long;", "setLocalId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mvMakerInfo", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getMvMakerInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setMvMakerInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "mvMakerNickName", "getMvMakerNickName", "setMvMakerNickName", "mvObjectId", "getMvObjectId", "setMvObjectId", "mvObjectNonceId", "getMvObjectNonceId", "setMvObjectNonceId", "mvPostStatus", "getMvPostStatus", "setMvPostStatus", "normalMvObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getNormalMvObj", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setNormalMvObj", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "originalInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVOriginalInfo;", "getOriginalInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVOriginalInfo;", "setOriginalInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVOriginalInfo;)V", "pauseTimes", "getPauseTimes", "()J", "setPauseTimes", "(J)V", "playMvTime", "getPlayMvTime", "setPlayMvTime", "postSuccessMvObj", "getPostSuccessMvObj", "setPostSuccessMvObj", "postSuccessRefObjList", "Ljava/util/LinkedList;", "getPostSuccessRefObjList", "()Ljava/util/LinkedList;", "setPostSuccessRefObjList", "(Ljava/util/LinkedList;)V", "refVideoList", "getRefVideoList", "setRefVideoList", "showQQMusic", "getShowQQMusic", "setShowQQMusic", "snapshotCover", "Landroid/graphics/Bitmap;", "getSnapshotCover", "()Landroid/graphics/Bitmap;", "setSnapshotCover", "(Landroid/graphics/Bitmap;)V", "startMvTimeStamp", "getStartMvTimeStamp", "setStartMvTimeStamp", "trackDataList", "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "getTrackDataList", "setTrackDataList", "Companion", "plugin-mv_release"})
public final class e {
    public static final a ApR = new a((byte) 0);
    public Long ApB;
    public Bitmap ApC;
    public String ApD;
    public Long ApE;
    public String ApF;
    public String ApG = "";
    public LinkedList<axz> ApH = new LinkedList<>();
    public axx ApI;
    public FinderContact ApJ;
    public boolean ApK;
    public LinkedList<FinderObject> ApL = new LinkedList<>();
    public int ApM = 1;
    public FinderObject ApN;
    public boolean ApO;
    public FinderObject ApP;
    public LinkedList<FinderObject> ApQ = new LinkedList<>();
    public long UZk;
    public long UZl;
    public long UZm;
    public int commentCount;
    public String coverUrl;
    public int forwardCount;
    public int likeCount;
    public boolean onr;
    public boolean tav;

    static {
        AppMethodBeat.i(256787);
        AppMethodBeat.o(256787);
    }

    public e() {
        AppMethodBeat.i(256786);
        AppMethodBeat.o(256786);
    }

    public final void aIm(String str) {
        AppMethodBeat.i(256784);
        p.h(str, "<set-?>");
        this.ApG = str;
        AppMethodBeat.o(256784);
    }

    public final void bf(LinkedList<FinderObject> linkedList) {
        AppMethodBeat.i(256785);
        p.h(linkedList, "<set-?>");
        this.ApL = linkedList;
        AppMethodBeat.o(256785);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MusicMv$Companion;", "", "()V", "MODE_COMMENT_MAX", "", "MODE_COMMENT_MIN", "copyToNew", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "mv", "newMv", "createFromMusicMvData", "data", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "deleteMv", "", "fillMvByFinderObject", "obj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMvObj", "musicMv", "hasMv", "", "resetMv", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(FinderObject finderObject, e eVar) {
            String str;
            boolean z;
            axw axw;
            FinderObjectDesc finderObjectDesc;
            LinkedList<FinderMedia> linkedList;
            FinderMedia finderMedia;
            AppMethodBeat.i(256780);
            p.h(finderObject, "obj");
            p.h(eVar, "mv");
            eVar.ApE = Long.valueOf(finderObject.id);
            eVar.ApF = finderObject.objectNonceId;
            FinderContact finderContact = finderObject.contact;
            if (finderContact == null || (str = finderContact.nickname) == null) {
                str = "";
            }
            eVar.aIm(str);
            eVar.ApJ = finderObject.contact;
            String str2 = eVar.coverUrl;
            if (!(!(str2 == null || str2.length() == 0) || (finderObjectDesc = finderObject.objectDesc) == null || (linkedList = finderObjectDesc.media) == null || (finderMedia = (FinderMedia) j.kt(linkedList)) == null)) {
                eVar.coverUrl = finderMedia.thumbUrl + finderMedia.thumb_url_token;
            }
            FinderObjectDesc finderObjectDesc2 = finderObject.objectDesc;
            if (!(finderObjectDesc2 == null || (axw = finderObjectDesc2.mvInfo) == null)) {
                eVar.ApI = axw.ApI;
                LinkedList<axz> linkedList2 = axw.LId;
                p.g(linkedList2, "mvInfo.orderedTrackList");
                p.h(linkedList2, "<set-?>");
                eVar.ApH = linkedList2;
            }
            eVar.likeCount = finderObject.likeCount;
            eVar.forwardCount = finderObject.forwardCount;
            eVar.commentCount = finderObject.commentCount;
            if (finderObject.likeFlag != 0) {
                z = true;
            } else {
                z = false;
            }
            eVar.ApK = z;
            eVar.ApN = finderObject;
            AppMethodBeat.o(256780);
        }

        public static e b(csp csp) {
            String str;
            axx axx;
            FinderObjectDesc finderObjectDesc;
            axw axw;
            FinderObjectDesc finderObjectDesc2;
            axw axw2;
            LinkedList<axz> linkedList;
            FinderContact finderContact;
            FinderContact finderContact2 = null;
            AppMethodBeat.i(256781);
            p.h(csp, "data");
            e eVar = new e();
            eVar.ApB = Long.valueOf(csp.localId);
            eVar.ApD = csp.MxF;
            FinderObject finderObject = csp.MxE;
            if (finderObject == null || (finderContact = finderObject.contact) == null || (str = finderContact.nickname) == null) {
                str = "";
            }
            eVar.aIm(str);
            LinkedList<FinderObject> linkedList2 = csp.LDi;
            p.g(linkedList2, "data.refObjectList");
            eVar.bf(linkedList2);
            FinderObject finderObject2 = csp.MxE;
            if (!(finderObject2 == null || (finderObjectDesc2 = finderObject2.objectDesc) == null || (axw2 = finderObjectDesc2.mvInfo) == null || (linkedList = axw2.LId) == null)) {
                eVar.ApH.addAll(linkedList);
            }
            FinderObject finderObject3 = csp.MxE;
            if (finderObject3 == null || (finderObjectDesc = finderObject3.objectDesc) == null || (axw = finderObjectDesc.mvInfo) == null) {
                axx = null;
            } else {
                axx = axw.ApI;
            }
            eVar.ApI = axx;
            FinderObject finderObject4 = csp.MxE;
            if (finderObject4 != null) {
                finderContact2 = finderObject4.contact;
            }
            eVar.ApJ = finderContact2;
            eVar.ApN = csp.MxE;
            AppMethodBeat.o(256781);
            return eVar;
        }

        public static boolean b(e eVar) {
            AppMethodBeat.i(256783);
            p.h(eVar, "musicMv");
            if (a(eVar) != null) {
                AppMethodBeat.o(256783);
                return true;
            }
            AppMethodBeat.o(256783);
            return false;
        }

        public static void e(e eVar) {
            AppMethodBeat.i(259167);
            p.h(eVar, "mv");
            eVar.tav = true;
            eVar.ApJ = null;
            eVar.ApI = null;
            for (T t : eVar.ApH) {
                t.LIm = "";
                t.refObjectId = 0;
                t.LIn = 0;
                t.Vjw = 0;
            }
            eVar.likeCount = 0;
            eVar.forwardCount = 0;
            eVar.commentCount = 0;
            eVar.ApK = false;
            eVar.ApN = null;
            eVar.ApP = null;
            eVar.ApQ.clear();
            eVar.onr = false;
            AppMethodBeat.o(259167);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
            if (r0 == null) goto L_0x0020;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.tencent.mm.protocal.protobuf.FinderObject a(com.tencent.mm.plugin.mv.a.e r10) {
            /*
                r8 = 0
                r2 = 1
                r3 = 0
                r1 = 0
                r6 = 256782(0x3eb0e, float:3.59828E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                java.lang.String r0 = "musicMv"
                kotlin.g.b.p.h(r10, r0)
                com.tencent.mm.protocal.protobuf.FinderObject r0 = r10.ApN
                if (r0 == 0) goto L_0x0020
                long r4 = r0.id
                int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x0031
                r4 = r2
            L_0x001c:
                if (r4 == 0) goto L_0x0033
            L_0x001e:
                if (r0 != 0) goto L_0x003c
            L_0x0020:
                com.tencent.mm.protocal.protobuf.FinderObject r0 = r10.ApP
                if (r0 == 0) goto L_0x003b
                long r4 = r0.id
                int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x0035
            L_0x002a:
                if (r2 == 0) goto L_0x0037
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                r1 = r0
            L_0x0030:
                return r1
            L_0x0031:
                r4 = r3
                goto L_0x001c
            L_0x0033:
                r0 = r1
                goto L_0x001e
            L_0x0035:
                r2 = r3
                goto L_0x002a
            L_0x0037:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                goto L_0x0030
            L_0x003b:
                r0 = r1
            L_0x003c:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                r1 = r0
                goto L_0x0030
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.a.e.a.a(com.tencent.mm.plugin.mv.a.e):com.tencent.mm.protocal.protobuf.FinderObject");
        }
    }
}
