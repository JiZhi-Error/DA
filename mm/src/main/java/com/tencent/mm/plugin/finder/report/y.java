package com.tencent.mm.plugin.finder.report;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.c;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b4\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u00108\u001a\u000209J\b\u0010:\u001a\u000209H\u0002J\u000e\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020=J\b\u0010>\u001a\u000209H\u0002J\u0006\u0010?\u001a\u000209J\u0006\u0010@\u001a\u000209J\b\u0010A\u001a\u000209H\u0002J\u0006\u0010B\u001a\u000209J\u000e\u0010C\u001a\u0002092\u0006\u0010<\u001a\u00020=J\u000e\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020\u0004J\b\u0010F\u001a\u000209H\u0002J\u0006\u0010G\u001a\u000209J\u0006\u0010H\u001a\u000209J\u000e\u0010I\u001a\u0002092\u0006\u0010E\u001a\u00020\u0004J\u001a\u0010J\u001a\u0002092\u0006\u0010K\u001a\u00020\u00042\b\b\u0002\u0010L\u001a\u00020\u0004H\u0002J\u0006\u0010M\u001a\u000209J\u0006\u0010N\u001a\u000209J\u001e\u0010O\u001a\u0002092\u0016\u0010P\u001a\u0012\u0012\u0004\u0012\u00020R0Qj\b\u0012\u0004\u0012\u00020R`SJ\u0006\u0010T\u001a\u000209J\u0010\u0010U\u001a\u0002092\u0006\u0010V\u001a\u00020\u0004H\u0002J\u0006\u0010W\u001a\u000209J\u0006\u0010X\u001a\u000209J\u0010\u0010Y\u001a\u0002092\u0006\u0010E\u001a\u00020\u0004H\u0002J\u0006\u0010Z\u001a\u000209J\u0006\u0010[\u001a\u000209J\u0006\u0010\\\u001a\u000209J\u0006\u0010]\u001a\u000209J\u0010\u0010^\u001a\u0002092\u0006\u0010E\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006_"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/IDKey1371;", "", "()V", "CAPTURE_PHOTO", "", "CAPTURE_PHOTO_BACK", "CAPTURE_PHOTO_FRONT", "CAPTURE_PHOTO_WITH_BEAUTY", "ID", "SINGLE_VIDEO_BACK", "SINGLE_VIDEO_BEAUTY", "SINGLE_VIDEO_FRONT", "SINGLE_VIDEO_LENGTH_0_5", "SINGLE_VIDEO_LENGTH_10_15", "SINGLE_VIDEO_LENGTH_15_20", "SINGLE_VIDEO_LENGTH_20_30", "SINGLE_VIDEO_LENGTH_30_40", "SINGLE_VIDEO_LENGTH_40_50", "SINGLE_VIDEO_LENGTH_50_60", "SINGLE_VIDEO_LENGTH_5_10", "SINGLE_VIDEO_LENGTH_TOTAL", "SINGLE_VIDEO_NOT_ENOUGH", "SINGLE_VIDEO_SUCCESS", "SINGLE_VIDEO_TIME", "SUBVIDEO_AUTO_FINISH", "SUBVIDEO_CLICK_FINISH", "SUBVIDEO_NUM_0_3", "SUBVIDEO_NUM_10_15", "SUBVIDEO_NUM_15_20", "SUBVIDEO_NUM_3_6", "SUBVIDEO_NUM_6_10", "SUBVIDEO_PREPARE_DELETE", "SUBVIDEO_PRERARE_EXIT", "SUBVIDEO_SINGLE_LENGTH_0_5", "SUBVIDEO_SINGLE_LENGTH_10_15", "SUBVIDEO_SINGLE_LENGTH_15_20", "SUBVIDEO_SINGLE_LENGTH_20_30", "SUBVIDEO_SINGLE_LENGTH_30_40", "SUBVIDEO_SINGLE_LENGTH_40_50", "SUBVIDEO_SINGLE_LENGTH_50_60", "SUBVIDEO_SINGLE_LENGTH_5_10", "SUBVIDEO_SURE_DELETE", "SUBVIDEO_SURE_EXIT", "SUBVIDEO_TIME", "SUBVIDEO_TIME_NOT_ENOUGH", "SUBVIDEO_TIME_SUCCESS", "SUBVIDEO_TIME_TOTAL_DURATION", "SUBVIDEO_TOTAL_LENGTH_0_5", "SUBVIDEO_TOTAL_LENGTH_10_15", "SUBVIDEO_TOTAL_LENGTH_15_20", "SUBVIDEO_TOTAL_LENGTH_20_30", "SUBVIDEO_TOTAL_LENGTH_30_40", "SUBVIDEO_TOTAL_LENGTH_40_50", "SUBVIDEO_TOTAL_LENGTH_50_60", "SUBVIDEO_TOTAL_LENGTH_5_10", "SUBVIDEO_TOTAL_NUM", "capturePhoto", "", "capturePhotoBack", "capturePhotoCamera", "isBack", "", "capturePhotoFront", "capturePhotoWithBeauty", "captureSingleVideo", "captureSingleVideoBack", "captureSingleVideoBeauty", "captureSingleVideoCamera", "captureSingleVideoDuration", "durationMs", "captureSingleVideoFront", "captureSingleVideoNotEnough", "captureSingleVideoSuccess", "captureSingleVideoTotal", "report", "key", "value", "subVideoAutoFinish", "subVideoClickFinish", "subVideoDuration", "fileList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "subVideoNotEnough", "subVideoNum", "num", "subVideoPrepareDelete", "subVideoPrepareExit", "subVideoSingleTime", "subVideoSuccess", "subVideoSureDelete", "subVideoSureExit", "subVideoTime", "subVideoTotalTime", "plugin-finder_release"})
public final class y {
    public static final y vih = new y();

    static {
        AppMethodBeat.i(250824);
        AppMethodBeat.o(250824);
    }

    private y() {
    }

    public static void os(boolean z) {
        AppMethodBeat.i(250818);
        if (z) {
            Q(202, 1);
            AppMethodBeat.o(250818);
            return;
        }
        Q(201, 1);
        AppMethodBeat.o(250818);
    }

    public static void ot(boolean z) {
        AppMethodBeat.i(250819);
        if (z) {
            Q(214, 1);
            AppMethodBeat.o(250819);
            return;
        }
        Q(213, 1);
        AppMethodBeat.o(250819);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ ArrayList vii;

        a(ArrayList arrayList) {
            this.vii = arrayList;
        }

        public final void run() {
            AppMethodBeat.i(250817);
            long j2 = 0;
            for (String str : this.vii) {
                c cVar = c.xsz;
                com.tencent.mm.plugin.sight.base.a awl = c.awl(str);
                long j3 = ((long) awl.videoDuration) + j2;
                y yVar = y.vih;
                y.Fq((long) awl.videoDuration);
                j2 = j3;
            }
            y yVar2 = y.vih;
            y.Fr(j2);
            y yVar3 = y.vih;
            y.Fs((long) this.vii.size());
            AppMethodBeat.o(250817);
        }
    }

    public static void ah(ArrayList<String> arrayList) {
        AppMethodBeat.i(250821);
        p.h(arrayList, "fileList");
        h.RTc.aX(new a(arrayList));
        AppMethodBeat.o(250821);
    }

    public static /* synthetic */ void Fp(long j2) {
        AppMethodBeat.i(250823);
        Q(j2, 1);
        AppMethodBeat.o(250823);
    }

    public static void Q(long j2, long j3) {
        AppMethodBeat.i(250822);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1371, j2, j3, false);
        AppMethodBeat.o(250822);
    }

    public static void Fo(long j2) {
        AppMethodBeat.i(250820);
        Q(218, j2);
        if (j2 < 5000) {
            Q(220, 1);
            AppMethodBeat.o(250820);
        } else if (j2 < 10000) {
            Q(221, 1);
            AppMethodBeat.o(250820);
        } else if (j2 < 15000) {
            Q(222, 1);
            AppMethodBeat.o(250820);
        } else if (j2 < 20000) {
            Q(223, 1);
            AppMethodBeat.o(250820);
        } else if (j2 < 30000) {
            Q(224, 1);
            AppMethodBeat.o(250820);
        } else if (j2 < 40000) {
            Q(225, 1);
            AppMethodBeat.o(250820);
        } else if (j2 < 50000) {
            Q(226, 1);
            AppMethodBeat.o(250820);
        } else {
            Q(227, 1);
            AppMethodBeat.o(250820);
        }
    }

    public static final /* synthetic */ void Fq(long j2) {
        AppMethodBeat.i(250825);
        if (j2 < 5000) {
            Q(234, 1);
            AppMethodBeat.o(250825);
        } else if (j2 < 10000) {
            Q(235, 1);
            AppMethodBeat.o(250825);
        } else if (j2 < 15000) {
            Q(236, 1);
            AppMethodBeat.o(250825);
        } else if (j2 < 20000) {
            Q(237, 1);
            AppMethodBeat.o(250825);
        } else if (j2 < 30000) {
            Q(238, 1);
            AppMethodBeat.o(250825);
        } else if (j2 < 40000) {
            Q(239, 1);
            AppMethodBeat.o(250825);
        } else if (j2 < 50000) {
            Q(240, 1);
            AppMethodBeat.o(250825);
        } else {
            if (j2 < Util.MILLSECONDS_OF_MINUTE) {
                Q(241, 1);
            }
            AppMethodBeat.o(250825);
        }
    }

    public static final /* synthetic */ void Fr(long j2) {
        AppMethodBeat.i(250826);
        Q(231, j2);
        if (j2 < 5000) {
            Q(242, 1);
            AppMethodBeat.o(250826);
        } else if (j2 < 10000) {
            Q(243, 1);
            AppMethodBeat.o(250826);
        } else if (j2 < 15000) {
            Q(244, 1);
            AppMethodBeat.o(250826);
        } else if (j2 < 20000) {
            Q(245, 1);
            AppMethodBeat.o(250826);
        } else if (j2 < 30000) {
            Q(246, 1);
            AppMethodBeat.o(250826);
        } else if (j2 < 40000) {
            Q(247, 1);
            AppMethodBeat.o(250826);
        } else if (j2 < 50000) {
            Q(248, 1);
            AppMethodBeat.o(250826);
        } else {
            if (j2 < Util.MILLSECONDS_OF_MINUTE) {
                Q(249, 1);
            }
            AppMethodBeat.o(250826);
        }
    }

    public static final /* synthetic */ void Fs(long j2) {
        AppMethodBeat.i(250827);
        Q(250, j2);
        if (j2 <= 3) {
            Q(251, 1);
            AppMethodBeat.o(250827);
        } else if (j2 <= 6) {
            Q(252, 1);
            AppMethodBeat.o(250827);
        } else if (j2 <= 10) {
            Q(253, 1);
            AppMethodBeat.o(250827);
        } else if (j2 <= 15) {
            Q(254, 1);
            AppMethodBeat.o(250827);
        } else {
            if (j2 <= 20) {
                Q(255, 1);
            }
            AppMethodBeat.o(250827);
        }
    }
}
