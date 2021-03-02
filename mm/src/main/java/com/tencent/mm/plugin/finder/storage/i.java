package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderExptUtil;", "", "()V", "TAG", "", "fillExptFlag", "", "finderBaseReq", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "showFinderEntry", "", "EXPT_FLAG", "plugin-finder_release"})
public final class i {
    public static final i vDq = new i();

    static {
        AppMethodBeat.i(251723);
        AppMethodBeat.o(251723);
    }

    private i() {
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderExptUtil$EXPT_FLAG;", "", "()V", "FINDER_COMMENT_EXPOSE", "", "getFINDER_COMMENT_EXPOSE", "()I", "FriendCommentExpand", "getFriendCommentExpand", "HAS_FINDER_ENTRANCE", "getHAS_FINDER_ENTRANCE", "MMFinderBaseReqExptFlag_AllFullScreen", "getMMFinderBaseReqExptFlag_AllFullScreen", "MMFinderBaseReqExptFlag_FollowFullScreen", "getMMFinderBaseReqExptFlag_FollowFullScreen", "MMFinderBaseReqExptFlag_FriendFullScreen", "getMMFinderBaseReqExptFlag_FriendFullScreen", "MMFinderBaseReqExptFlag_IsFullScreen", "getMMFinderBaseReqExptFlag_IsFullScreen", "MMFinderBaseReqExptFlag_RelatedFullScreen", "getMMFinderBaseReqExptFlag_RelatedFullScreen", "REAL_NAME_LIKE", "getREAL_NAME_LIKE", "plugin-finder_release"})
    public static final class a {
        public static final a vDA = new a();
        private static final int vDr = 1;
        private static final int vDs = 2;
        private static final int vDt = 4;
        private static final int vDu = 8;
        private static final int vDv = 16;
        private static final int vDw = 32;
        private static final int vDx = 64;
        private static final int vDy = 128;
        private static final int vDz = 256;

        static {
            AppMethodBeat.i(251721);
            AppMethodBeat.o(251721);
        }

        private a() {
        }

        public static int dxr() {
            return vDr;
        }

        public static int dxs() {
            return vDs;
        }

        public static int dxt() {
            return vDt;
        }

        public static int dxu() {
            return vDu;
        }

        public static int dxv() {
            return vDv;
        }

        public static int dxw() {
            return vDw;
        }

        public static int dxx() {
            return vDx;
        }

        public static int dxy() {
            return vDy;
        }

        public static int dxz() {
            return vDz;
        }
    }

    public static void a(aov aov) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(251722);
        p.h(aov, "finderBaseReq");
        aov.LAS = 0;
        c cVar = c.vCb;
        if (c.dsp().value().intValue() == 1) {
            int i2 = aov.LAS;
            a aVar = a.vDA;
            aov.LAS = i2 | a.dxr();
        }
        boolean z3 = ((b) g.af(b.class)).a(b.a.clicfg_finder_entry, 0) != 0;
        com.tencent.mm.plugin.finder.spam.a aVar2 = com.tencent.mm.plugin.finder.spam.a.vwk;
        int avn = com.tencent.mm.plugin.finder.spam.a.avn("entrance");
        if (avn == 2) {
            Log.i("Finder.ExptUtil", "showFinderEntry ".concat(String.valueOf(avn)));
            z3 = false;
        }
        c cVar2 = c.vCb;
        if (c.drq() != 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("Finder.ExptUtil", "showFinder %s %s", Boolean.valueOf(z3), Boolean.valueOf(z));
        if (z3 || z) {
            z2 = true;
        }
        if (z2) {
            int i3 = aov.LAS;
            a aVar3 = a.vDA;
            aov.LAS = i3 | a.dxs();
        }
        c cVar3 = c.vCb;
        if (c.dux().value().intValue() == 1) {
            int i4 = aov.LAS;
            a aVar4 = a.vDA;
            aov.LAS = i4 | a.dxt();
        }
        c cVar4 = c.vCb;
        if (c.duF().value().intValue() == 1) {
            int i5 = aov.LAS;
            a aVar5 = a.vDA;
            aov.LAS = i5 | a.dxu();
        }
        y yVar = y.vXH;
        if (y.isAnyEnableFullScreenEnjoy()) {
            int i6 = aov.LAS;
            a aVar6 = a.vDA;
            aov.LAS = i6 | a.dxv();
        }
        c cVar5 = c.vCb;
        if (c.dwu().value().intValue() == 1) {
            int i7 = aov.LAS;
            a aVar7 = a.vDA;
            aov.LAS = i7 | a.dxw();
        }
        c cVar6 = c.vCb;
        if (c.dwt().value().intValue() == 1) {
            int i8 = aov.LAS;
            a aVar8 = a.vDA;
            aov.LAS = i8 | a.dxx();
        }
        c cVar7 = c.vCb;
        if (c.dww().value().intValue() == 1) {
            int i9 = aov.LAS;
            a aVar9 = a.vDA;
            aov.LAS = i9 | a.dxy();
        }
        y yVar2 = y.vXH;
        if (y.isAllEnableFullScreenEnjoy()) {
            int i10 = aov.LAS;
            a aVar10 = a.vDA;
            aov.LAS = i10 | a.dxz();
        }
        Log.i("Finder.ExptUtil", "[fillExptFlag] exptFlag=" + aov.LAS);
        AppMethodBeat.o(251722);
    }
}
