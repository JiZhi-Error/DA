package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\f\u001a\u00020\bH\u0007J\b\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\bH\u0007J\b\u0010\u000f\u001a\u00020\bH\u0007J\b\u0010\u0010\u001a\u00020\bH\u0007J\b\u0010\u0011\u001a\u00020\bH\u0007J\b\u0010\u0012\u001a\u00020\bH\u0007J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\nH\u0007J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\nH\u0007J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/live/core/report/LiveAnchorPerformanceIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markAnchorMaxiViewCost", "", "cost", "", "markAnchorMiniViewCost", "markAnchorNetStatusBad", "markAnchorNetStatusDisable", "markAnchorNetStatusGood", "markAnchorNetStatusNormal", "markAnchorRendererFpsHigh", "markAnchorRendererFpsLow", "markAnchorRendererFpsMiddle", "markAnchorRendererFpsValue", "fpsValue", "markAnchorRendererPerFrameCost", "markAnchorRendererPreviewHeight", "height", "markAnchorRendererPreviewWidth", "width", "plugin-core_release"})
public final class a {
    public static final a hEG = new a();

    static {
        AppMethodBeat.i(196712);
        AppMethodBeat.o(196712);
    }

    private a() {
    }

    public static final void aEH() {
        AppMethodBeat.i(196699);
        Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsLow");
        h.INSTANCE.n(1384, 0, 1);
        AppMethodBeat.o(196699);
    }

    public static final void aEI() {
        AppMethodBeat.i(196700);
        Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsMiddle");
        h.INSTANCE.n(1384, 1, 1);
        AppMethodBeat.o(196700);
    }

    public static final void aEJ() {
        AppMethodBeat.i(196701);
        Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsHigh");
        h.INSTANCE.n(1384, 2, 1);
        AppMethodBeat.o(196701);
    }

    public static final void aEK() {
        AppMethodBeat.i(196702);
        Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusGood");
        h.INSTANCE.n(1384, 3, 1);
        AppMethodBeat.o(196702);
    }

    public static final void aEL() {
        AppMethodBeat.i(196703);
        Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusNormal");
        h.INSTANCE.n(1384, 4, 1);
        AppMethodBeat.o(196703);
    }

    public static final void aEM() {
        AppMethodBeat.i(196704);
        Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusBad");
        h.INSTANCE.n(1384, 5, 1);
        AppMethodBeat.o(196704);
    }

    public static final void aEN() {
        AppMethodBeat.i(196705);
        Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusDisable");
        h.INSTANCE.n(1384, 6, 1);
        AppMethodBeat.o(196705);
    }

    public static final void qz(int i2) {
        AppMethodBeat.i(196706);
        Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorMaxiViewCost is ".concat(String.valueOf(i2)));
        h.INSTANCE.b(1384, 7, 8, i2, false);
        AppMethodBeat.o(196706);
    }

    public static final void qA(int i2) {
        AppMethodBeat.i(196707);
        Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorMiniViewCost is ".concat(String.valueOf(i2)));
        h.INSTANCE.b(1384, 10, 11, i2, false);
        AppMethodBeat.o(196707);
    }

    public static final void qB(int i2) {
        AppMethodBeat.i(196708);
        Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPerFrameCost is ".concat(String.valueOf(i2)));
        h.INSTANCE.b(1384, 13, 14, i2, false);
        AppMethodBeat.o(196708);
    }

    public static final void qC(int i2) {
        AppMethodBeat.i(196709);
        Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsValue is ".concat(String.valueOf(i2)));
        h.INSTANCE.b(1384, 16, 17, i2, false);
        AppMethodBeat.o(196709);
    }

    public static final void qD(int i2) {
        AppMethodBeat.i(196710);
        Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPreviewHeight is ".concat(String.valueOf(i2)));
        h.INSTANCE.b(1384, 19, 20, i2, false);
        AppMethodBeat.o(196710);
    }

    public static final void qE(int i2) {
        AppMethodBeat.i(196711);
        Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPreviewHeight is ".concat(String.valueOf(i2)));
        h.INSTANCE.b(1384, 22, 23, i2, false);
        AppMethodBeat.o(196711);
    }
}
