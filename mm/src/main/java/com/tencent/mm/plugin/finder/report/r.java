package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006\u000e\u000f\u0010\u0011\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderStat;", "", "()V", "TAG", "", "getLongVideoId", "", "id", "idkeyStat", "", "key", "value", "isLongVideo", "", "FolderCapacityStat", "LongVideoStat", "PostMediaProcessStat", "PostStat", "SyncCropVideoStat", "VideoInvalidStat", "plugin-finder_release"})
public final class r {
    private static final String TAG = TAG;
    public static final r vgF = new r();

    static {
        AppMethodBeat.i(166636);
        AppMethodBeat.o(166636);
    }

    private r() {
    }

    private static long Fi(long j2) {
        return j2 == 1253 ? 1523 : 0;
    }

    public static void idkeyStat(long j2, long j3, long j4, boolean z) {
        AppMethodBeat.i(250793);
        h.INSTANCE.n(j2, j3, j4);
        if (z && Fi(j2) > 0) {
            h.INSTANCE.n(Fi(j2), j3, j4);
        }
        AppMethodBeat.o(250793);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010%\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010&\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010'\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010(\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderStat$PostMediaProcessStat;", "", "()V", "id_remux", "", "key_postTotalCost", "key_postTotalCostCount", "key_postUploadCost", "key_postUploadCostCount", "key_progress_exception", "key_remuxCost", "key_remuxCount", "key_remuxFailed", "key_remuxSize", "key_remux_file_error", "key_remux_skip", "key_videoDuration", "key_zipCost", "key_zipCount", "key_zipFailed", "key_zipSize", "reportPostTotalCost", "", "cost", "isLongVideo", "", "reportPostUploadCost", "reportRemuxCost", "reportRemuxCount", "reportRemuxFailed", "reportRemuxOutputFileError", "reportRemuxProgressException", "reportRemuxSize", "size", "reportSkipRemuxCount", "reportVideoDuration", "durationMs", "reportZipCost", "reportZipCount", "reportZipFailed", "reportZipSize", "plugin-finder_release"})
    public static final class c {
        private static final long vgK = vgK;
        private static final long vgL = 0;
        private static final long vgM = 1;
        private static final long vgN = 2;
        private static final long vgO = 3;
        private static final long vgP = 4;
        private static final long vgQ = vgQ;
        private static final long vgR = vgR;
        private static final long vgS = 7;
        private static final long vgT = 8;
        private static final long vgU = vgU;
        private static final long vgV = vgV;
        private static final long vgW = vgW;
        private static final long vgX = vgX;
        private static final long vgY = vgY;
        private static final long vgZ = 11;
        private static final long vha = vha;
        public static final c vhb = new c();

        static {
            AppMethodBeat.i(166620);
            AppMethodBeat.o(166620);
        }

        private c() {
        }

        public static void nT(boolean z) {
            AppMethodBeat.i(250758);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vgL, 1, z);
            AppMethodBeat.o(250758);
        }

        public static void u(long j2, boolean z) {
            AppMethodBeat.i(250759);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vgM, j2, z);
            AppMethodBeat.o(250759);
        }

        public static void nU(boolean z) {
            AppMethodBeat.i(250760);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vgN, 1, z);
            AppMethodBeat.o(250760);
        }

        public static void v(long j2, boolean z) {
            AppMethodBeat.i(250761);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vgO, j2, z);
            AppMethodBeat.o(250761);
        }

        public static void nV(boolean z) {
            AppMethodBeat.i(250762);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vgU, 1, z);
            AppMethodBeat.o(250762);
        }

        public static void nW(boolean z) {
            AppMethodBeat.i(250763);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vgV, 1, z);
            AppMethodBeat.o(250763);
        }

        public static void nX(boolean z) {
            AppMethodBeat.i(250764);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vgW, 1, z);
            AppMethodBeat.o(250764);
        }

        public static void nY(boolean z) {
            AppMethodBeat.i(250765);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vgP, 1, z);
            AppMethodBeat.o(250765);
        }

        public static void w(long j2, boolean z) {
            AppMethodBeat.i(250766);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vgQ, j2, z);
            AppMethodBeat.o(250766);
        }

        public static void nZ(boolean z) {
            AppMethodBeat.i(250767);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vgR, 1, z);
            AppMethodBeat.o(250767);
        }

        public static void x(long j2, boolean z) {
            AppMethodBeat.i(250768);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vgS, j2, z);
            AppMethodBeat.o(250768);
        }

        public static void Fm(long j2) {
            AppMethodBeat.i(250769);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vgT, j2, false);
            AppMethodBeat.o(250769);
        }

        public static void y(long j2, boolean z) {
            AppMethodBeat.i(250770);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vgZ, 1, z);
            r rVar2 = r.vgF;
            r.idkeyStat(vgK, vha, j2, z);
            AppMethodBeat.o(250770);
        }

        public static void z(long j2, boolean z) {
            AppMethodBeat.i(250771);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vgX, 1, z);
            r rVar2 = r.vgF;
            r.idkeyStat(vgK, vgY, j2, z);
            AppMethodBeat.o(250771);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010#\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010%\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010'\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010(\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010*\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010+\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010,\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010-\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010.\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010/\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u00100\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u00101\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderStat$PostStat;", "", "()V", "id_remux", "", "key_postCount", "key_postFailed1", "key_postFailed2", "key_postFailed3", "key_postFailed4", "key_postFailedCount", "key_postFailedDelete", "key_postFailedDeleteLongVideo", "key_postMediaProcCount", "key_postMediaProcFailedCount", "key_postNetSceneCount", "key_postNetSceneFailedCount", "key_postNetSceneSafeFailedCount", "key_postTryCount", "key_postTryFailedCount", "key_postUploadCount", "key_postUploadFailedCount", "key_postingDelete", "key_postingDeleteLongVideo", "key_repost", "key_repostLongVideo", "reportPostCount", "", "isLongVideo", "", "reportPostFailedCount", "reportPostFailedDeleteCount", "reportPostFailedDeleteLongVideoCount", "reportPostFailedStage1", "reportPostFailedStage2", "reportPostFailedStage3", "reportPostFailedStage4", "reportPostMediaProcCount", "reportPostMediaProcFailedCount", "reportPostNetSceneCount", "reportPostNetSceneFailedCount", "reportPostNetSceneSafeFailedCount", "reportPostTryCount", "reportPostTryFailedCount", "reportPostUploadCount", "reportPostUploadFailedCount", "reportPostingDeleteCount", "reportPostingDeleteLongVideoCount", "reportRepostCount", "reportRepostLongVideoCount", "plugin-finder_release"})
    public static final class d {
        private static final long vgK = vgK;
        private static final long vhc = 15;
        private static final long vhd = 16;
        private static final long vhe = vhe;
        private static final long vhf = vhf;
        private static final long vhg = vhg;
        private static final long vhh = vhh;
        private static final long vhi = vhi;
        private static final long vhj = vhj;
        private static final long vhk = vhk;
        private static final long vhl = vhl;
        private static final long vhm = vhm;
        private static final long vhn = vhn;
        private static final long vho = vho;
        private static final long vhp = vhp;
        private static final long vhq = vhq;
        private static final long vhr = vhr;
        private static final long vhs = vhs;
        private static final long vht = vht;
        private static final long vhu = 51;
        private static final long vhv = vhv;
        private static final long vhw = vhw;
        public static final d vhx = new d();

        static {
            AppMethodBeat.i(166632);
            AppMethodBeat.o(166632);
        }

        private d() {
        }

        public static void oa(boolean z) {
            AppMethodBeat.i(250772);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhc, 1, z);
            AppMethodBeat.o(250772);
        }

        public static void ob(boolean z) {
            AppMethodBeat.i(250773);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhd, 1, z);
            AppMethodBeat.o(250773);
        }

        public static void oc(boolean z) {
            AppMethodBeat.i(250774);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhe, 1, z);
            AppMethodBeat.o(250774);
        }

        public static void od(boolean z) {
            AppMethodBeat.i(250775);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhf, 1, z);
            AppMethodBeat.o(250775);
        }

        public static void oe(boolean z) {
            AppMethodBeat.i(250776);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhg, 1, z);
            AppMethodBeat.o(250776);
        }

        public static void of(boolean z) {
            AppMethodBeat.i(250777);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhh, 1, z);
            AppMethodBeat.o(250777);
        }

        public static void og(boolean z) {
            AppMethodBeat.i(250778);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhi, 1, z);
            AppMethodBeat.o(250778);
        }

        public static void oh(boolean z) {
            AppMethodBeat.i(250779);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhj, 1, z);
            AppMethodBeat.o(250779);
        }

        public static void oi(boolean z) {
            AppMethodBeat.i(250780);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhk, 1, z);
            AppMethodBeat.o(250780);
        }

        public static void oj(boolean z) {
            AppMethodBeat.i(250781);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhl, 1, z);
            AppMethodBeat.o(250781);
        }

        public static void ok(boolean z) {
            AppMethodBeat.i(250782);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhm, 1, z);
            AppMethodBeat.o(250782);
        }

        public static void ol(boolean z) {
            AppMethodBeat.i(250783);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhn, 1, z);
            AppMethodBeat.o(250783);
        }

        public static void om(boolean z) {
            AppMethodBeat.i(250784);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vho, 1, z);
            AppMethodBeat.o(250784);
        }

        public static void on(boolean z) {
            AppMethodBeat.i(250785);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhp, 1, z);
            AppMethodBeat.o(250785);
        }

        public static void oo(boolean z) {
            AppMethodBeat.i(250786);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhq, 1, z);
            AppMethodBeat.o(250786);
        }

        public static void op(boolean z) {
            AppMethodBeat.i(250787);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhr, 1, z);
            AppMethodBeat.o(250787);
        }

        public static void oq(boolean z) {
            AppMethodBeat.i(250788);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhs, 1, z);
            AppMethodBeat.o(250788);
        }

        public static void or(boolean z) {
            AppMethodBeat.i(250789);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vht, 1, z);
            AppMethodBeat.o(250789);
        }

        public static void dow() {
            AppMethodBeat.i(250790);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhu, 1, true);
            AppMethodBeat.o(250790);
        }

        public static void dox() {
            AppMethodBeat.i(250791);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhv, 1, true);
            AppMethodBeat.o(250791);
        }

        public static void doy() {
            AppMethodBeat.i(250792);
            r rVar = r.vgF;
            r.idkeyStat(vgK, vhw, 1, true);
            AppMethodBeat.o(250792);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J:\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderStat$SyncCropVideoStat;", "", "()V", "id_syncCrop", "", "key_syncCropCost", "key_syncCropCount", "logId", "", "reportSyncCrop", "", "cost", "reportSyncCropKv", "originMediaInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "targetMediaInfo", "originFileSize", "targetFileSize", "ret", "plugin-finder_release"})
    public static final class e {
        private static final int hhs = hhs;
        private static final long vhA = vhA;
        public static final e vhB = new e();
        private static final long vhy = vhy;
        private static final long vhz = vhz;

        static {
            AppMethodBeat.i(166635);
            AppMethodBeat.o(166635);
        }

        private e() {
        }

        public static void Fn(long j2) {
            AppMethodBeat.i(166633);
            h.INSTANCE.n(vhy, vhz, 1);
            h.INSTANCE.n(vhy, vhA, j2);
            AppMethodBeat.o(166633);
        }

        public static void a(com.tencent.mm.plugin.sight.base.a aVar, com.tencent.mm.plugin.sight.base.a aVar2, int i2, int i3, long j2, int i4) {
            String str;
            AppMethodBeat.i(166634);
            if (aVar != null) {
                String sb = new StringBuilder().append(aVar.getVideoDuration()).append(',').append(aVar.width).append(',').append(aVar.height).append(',').append(i2).append(',').append(aVar.videoBitrate).append(',').toString();
                if (aVar2 == null) {
                    str = sb + "0,0,0,0,0,";
                } else {
                    str = sb + aVar2.getVideoDuration() + ',' + aVar2.width + ',' + aVar2.height + ',' + i3 + ',' + aVar2.videoBitrate;
                }
                String str2 = str + j2 + ',' + i4;
                r rVar = r.vgF;
                Log.i(r.TAG, "report 19063: ".concat(String.valueOf(str2)));
                h.INSTANCE.kvStat(hhs, str2);
            }
            AppMethodBeat.o(166634);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderStat$FolderCapacityStat;", "", "()V", "id_folder", "", "logId", "", "reportCapacity", "", "folderSizeMap", "", "", "reportNormalFolderClearCost", "costTime", "reportNormalFolderMarkCost", "reportPostFolderClearCost", "plugin-finder_release"})
    public static final class a {
        private static final int hhs = hhs;
        private static final long vgG = vgG;
        public static final a vgH = new a();

        static {
            AppMethodBeat.i(166608);
            AppMethodBeat.o(166608);
        }

        private a() {
        }

        public static void ai(Map<String, Long> map) {
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            long j7;
            long j8;
            long j9;
            long j10 = 0;
            AppMethodBeat.i(166604);
            p.h(map, "folderSizeMap");
            StringBuilder sb = new StringBuilder();
            Long l = map.get("finderAccPath");
            StringBuilder append = sb.append(l != null ? l.longValue() : 0).append(',');
            Long l2 = map.get("finderPostPath");
            if (l2 != null) {
                j2 = l2.longValue();
            } else {
                j2 = 0;
            }
            StringBuilder append2 = append.append(j2).append(',');
            Long l3 = map.get("finderImgPath");
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = 0;
            }
            StringBuilder append3 = append2.append(j3).append(',');
            Long l4 = map.get("finderVideoPath");
            if (l4 != null) {
                j4 = l4.longValue();
            } else {
                j4 = 0;
            }
            StringBuilder append4 = append3.append(j4).append(',');
            Long l5 = map.get("finderAvatarPath");
            if (l5 != null) {
                j5 = l5.longValue();
            } else {
                j5 = 0;
            }
            StringBuilder append5 = append4.append(j5).append(',');
            Long l6 = map.get("finderCoverImagePath");
            if (l6 != null) {
                j6 = l6.longValue();
            } else {
                j6 = 0;
            }
            StringBuilder append6 = append5.append(j6).append(',');
            Long l7 = map.get("finderTmpPath");
            if (l7 != null) {
                j7 = l7.longValue();
            } else {
                j7 = 0;
            }
            StringBuilder append7 = append6.append(j7).append(',');
            Long l8 = map.get("finderCapturePath");
            if (l8 != null) {
                j8 = l8.longValue();
            } else {
                j8 = 0;
            }
            StringBuilder append8 = append7.append(j8).append(',');
            Long l9 = map.get("finderPostMediaDir");
            if (l9 != null) {
                j9 = l9.longValue();
            } else {
                j9 = 0;
            }
            StringBuilder append9 = append8.append(j9).append(',');
            Long l10 = map.get("finderPostMediaTmpDir");
            if (l10 != null) {
                j10 = l10.longValue();
            }
            String sb2 = append9.append(j10).toString();
            r rVar = r.vgF;
            Log.i(r.TAG, "report 18896: ".concat(String.valueOf(sb2)));
            h.INSTANCE.kvStat(hhs, sb2);
            AppMethodBeat.o(166604);
        }

        public static void Fj(long j2) {
            AppMethodBeat.i(166605);
            h.INSTANCE.n(vgG, 1, 1);
            h.INSTANCE.n(vgG, 2, j2);
            r rVar = r.vgF;
            Log.d(r.TAG, "reportNormalFolderClearCost " + vgG + ", key:1,2, costTime:" + j2);
            AppMethodBeat.o(166605);
        }

        public static void Fk(long j2) {
            AppMethodBeat.i(166606);
            h.INSTANCE.n(vgG, 3, 1);
            h.INSTANCE.n(vgG, 4, j2);
            r rVar = r.vgF;
            Log.d(r.TAG, "reportNormalFolderMarkCost " + vgG + ", key:3,4, costTime:" + j2);
            AppMethodBeat.o(166606);
        }

        public static void Fl(long j2) {
            AppMethodBeat.i(166607);
            h.INSTANCE.n(vgG, 5, 1);
            h.INSTANCE.n(vgG, 6, j2);
            r rVar = r.vgF;
            Log.d(r.TAG, "reportNormalFolderClearCost " + vgG + ", key:5,6, costTime:" + j2);
            AppMethodBeat.o(166607);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderStat$VideoInvalidStat;", "", "()V", "idkeyId", "", "kvLogId", "", "reportVideo", "", "videoMime", "", "audioMime", "path", "plugin-finder_release"})
    public static final class f {
        private static final int vhC = vhC;
        private static final long vhD = vhD;
        public static final f vhE = new f();

        static {
            AppMethodBeat.i(178399);
            AppMethodBeat.o(178399);
        }

        private f() {
        }

        public static void ai(String str, String str2, String str3) {
            AppMethodBeat.i(178398);
            h hVar = h.INSTANCE;
            int i2 = vhC;
            Object[] objArr = new Object[3];
            if (str == null) {
                str = "";
            }
            objArr[0] = str;
            if (str2 == null) {
                str2 = "";
            }
            objArr[1] = str2;
            if (str3 == null) {
                str3 = "";
            }
            objArr[2] = str3;
            hVar.a(i2, objArr);
            h.INSTANCE.n(vhD, 33, 1);
            AppMethodBeat.o(178398);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderStat$LongVideoStat;", "", "()V", "id", "", "key_fileSize", "reportFileSizeOutOfRange", "", "plugin-finder_release"})
    public static final class b {
        private static final long id = id;
        private static final long vgI = vgI;
        public static final b vgJ = new b();

        static {
            AppMethodBeat.i(250757);
            AppMethodBeat.o(250757);
        }

        private b() {
        }

        public static void dov() {
            AppMethodBeat.i(250756);
            h.INSTANCE.n(id, vgI, 1);
            AppMethodBeat.o(250756);
        }
    }
}
