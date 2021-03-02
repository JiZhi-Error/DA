package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\fH\u0007J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH\u0007J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\fH\u0007J\b\u0010\u0012\u001a\u00020\bH\u0007J\b\u0010\u0013\u001a\u00020\bH\u0007J\b\u0010\u0014\u001a\u00020\bH\u0007J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH\u0007J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH\u0007J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\fH\u0007J\b\u0010\u0019\u001a\u00020\bH\u0007J\b\u0010\u001a\u001a\u00020\bH\u0007J\b\u0010\u001b\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/live/core/report/LiveVisitorPerformanceIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markVisitorGaussAnchorAvatarCost", "", "cost", "markVisitorLinkVideoPreviewHeight", "height", "", "markVisitorLinkVideoPreviewWidth", "width", "markVisitorLinkVideoRendererCostPerFrame", "markVisitorLinkVideoRendererFps", "fpsValue", "markVisitorLinkVideoRendererFpsHigh", "markVisitorLinkVideoRendererFpsLow", "markVisitorLinkVideoRendererFpsMiddle", "markVisitorMaxiViewCost", "markVisitorMiniViewCost", "markVisitorRenderAnchorCostPerFrame", "markVisitorRendererAnchorFps", "markVisitorRendererAnchorFpsHigh", "markVisitorRendererAnchorFpsLow", "markVisitorRendererAnchorFpsMiddle", "plugin-core_release"})
public final class c {
    public static final c hEK = new c();

    static {
        AppMethodBeat.i(196730);
        AppMethodBeat.o(196730);
    }

    private c() {
    }

    public static final void aEO() {
        AppMethodBeat.i(196715);
        Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsLow");
        h.INSTANCE.n(1383, 0, 1);
        AppMethodBeat.o(196715);
    }

    public static final void aEP() {
        AppMethodBeat.i(196716);
        Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsMiddle");
        h.INSTANCE.n(1383, 1, 1);
        AppMethodBeat.o(196716);
    }

    public static final void aEQ() {
        AppMethodBeat.i(196717);
        Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsHigh");
        h.INSTANCE.n(1383, 2, 1);
        AppMethodBeat.o(196717);
    }

    public static final void qF(int i2) {
        AppMethodBeat.i(196718);
        Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFps value is ".concat(String.valueOf(i2)));
        h.INSTANCE.b(1383, 3, 4, i2, false);
        AppMethodBeat.o(196718);
    }

    public static final void zw(long j2) {
        AppMethodBeat.i(196719);
        Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRenderAnchorCostPerFrame is ".concat(String.valueOf(j2)));
        h.INSTANCE.b(1383, 6, 7, (int) j2, false);
        AppMethodBeat.o(196719);
    }

    public static final void zx(long j2) {
        AppMethodBeat.i(196720);
        Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorGaussAnchorAvatarCost is ".concat(String.valueOf(j2)));
        h.INSTANCE.b(1383, 9, 10, (int) j2, false);
        AppMethodBeat.o(196720);
    }

    public static final void qG(int i2) {
        AppMethodBeat.i(196721);
        Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoPreviewWidth is ".concat(String.valueOf(i2)));
        h.INSTANCE.b(1383, 12, 13, i2, false);
        AppMethodBeat.o(196721);
    }

    public static final void qH(int i2) {
        AppMethodBeat.i(196722);
        Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoPreviewHeight is ".concat(String.valueOf(i2)));
        h.INSTANCE.b(1383, 15, 16, i2, false);
        AppMethodBeat.o(196722);
    }

    public static final void qI(int i2) {
        AppMethodBeat.i(196723);
        Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorMaxiViewCost is ".concat(String.valueOf(i2)));
        h.INSTANCE.b(1383, 18, 19, i2, false);
        AppMethodBeat.o(196723);
    }

    public static final void qJ(int i2) {
        AppMethodBeat.i(196724);
        Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorMiniViewCost is ".concat(String.valueOf(i2)));
        h.INSTANCE.b(1383, 21, 22, i2, false);
        AppMethodBeat.o(196724);
    }

    public static final void qK(int i2) {
        AppMethodBeat.i(196725);
        Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererCostPerFrame is ".concat(String.valueOf(i2)));
        h.INSTANCE.b(1383, 24, 25, i2, false);
        AppMethodBeat.o(196725);
    }

    public static final void qL(int i2) {
        AppMethodBeat.i(196726);
        Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFps is ".concat(String.valueOf(i2)));
        h.INSTANCE.b(1383, 27, 28, i2, false);
        AppMethodBeat.o(196726);
    }

    public static final void aER() {
        AppMethodBeat.i(196727);
        Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsLow");
        h.INSTANCE.n(1383, 30, 1);
        AppMethodBeat.o(196727);
    }

    public static final void aES() {
        AppMethodBeat.i(196728);
        Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsMiddle");
        h.INSTANCE.n(1383, 31, 1);
        AppMethodBeat.o(196728);
    }

    public static final void aET() {
        AppMethodBeat.i(196729);
        Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsHigh");
        h.INSTANCE.n(1383, 32, 1);
        AppMethodBeat.o(196729);
    }
}
