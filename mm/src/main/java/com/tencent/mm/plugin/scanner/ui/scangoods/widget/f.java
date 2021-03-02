package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.ae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.j.c;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/RandomScanDotsAnimationController;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/BaseScanDotsAnimationController;", "context", "Landroid/content/Context;", "scanDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;)V", "animationTimer", "Ljava/util/Timer;", "scanPointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "generateRandomPoints", "startAnimation", "", "stopAnimation", "Companion", "plugin-scan_release"})
public final class f extends a {
    public static final a CPv = new a((byte) 0);
    private Timer CPt;
    private ae CPu = new ae();

    static {
        AppMethodBeat.i(52260);
        AppMethodBeat.o(52260);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/RandomScanDotsAnimationController$Companion;", "", "()V", "DOTS_CENTER_X_MAX_FACTOR", "", "DOTS_CENTER_X_MIN_FACTOR", "DOTS_CENTER_Y_MAX_FACTOR", "DOTS_CENTER_Y_MIN_FACTOR", "GROUP_DOTS_MAX_COUNT", "", "GROUP_DOTS_MIN_COUNT", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Context context, d dVar) {
        super(context, dVar);
        p.h(context, "context");
        p.h(dVar, "scanDotsView");
        AppMethodBeat.i(52259);
        ae aeVar = this.CPu;
        ScanPoint[] scanPointArr = new ScanPoint[10];
        for (int i2 = 0; i2 < 10; i2++) {
            scanPointArr[i2] = new ScanPoint();
        }
        aeVar.points = scanPointArr;
        AppMethodBeat.o(52259);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/scanner/ui/scangoods/widget/RandomScanDotsAnimationController$startAnimation$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"})
    public static final class b extends TimerTask {
        final /* synthetic */ f CPw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(f fVar) {
            this.CPw = fVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ b CPx;

            a(b bVar) {
                this.CPx = bVar;
            }

            public final void run() {
                AppMethodBeat.i(52255);
                this.CPx.CPw.b(f.a(this.CPx.CPw));
                AppMethodBeat.o(52255);
            }
        }

        public final void run() {
            AppMethodBeat.i(52256);
            MMHandlerThread.postToMainThread(new a(this));
            AppMethodBeat.o(52256);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.a, com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
    public final void startAnimation() {
        AppMethodBeat.i(52257);
        this.CPt = new Timer();
        Timer timer = this.CPt;
        if (timer != null) {
            timer.scheduleAtFixedRate(new b(this), 0, 350);
            AppMethodBeat.o(52257);
            return;
        }
        AppMethodBeat.o(52257);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.a, com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
    public final void stopAnimation() {
        AppMethodBeat.i(52258);
        Timer timer = this.CPt;
        if (timer != null) {
            timer.cancel();
        }
        super.stopAnimation();
        AppMethodBeat.o(52258);
    }

    public static final /* synthetic */ ae a(f fVar) {
        int i2;
        AppMethodBeat.i(52261);
        fVar.CPu.pointCount = c.SYP.nextInt(3, 7);
        double d2 = 0.1d * ((double) fVar.gRD);
        double d3 = 0.2d * ((double) fVar.gRE);
        double d4 = 0.9d * ((double) fVar.gRD);
        double d5 = 0.8d * ((double) fVar.gRE);
        Log.d("MicroMsg.RandomScanDotsAnimationController", "alvinluo randomCenter centerCount: %d, startY: %s, endY: %s", Integer.valueOf(fVar.CPu.pointCount), Double.valueOf(d3), Double.valueOf(d5));
        ScanPoint[] scanPointArr = fVar.CPu.points;
        if (scanPointArr == null) {
            p.hyc();
        }
        ScanPoint[] scanPointArr2 = fVar.CPu.points;
        if (scanPointArr2 != null) {
            i2 = scanPointArr2.length;
        } else {
            i2 = 0;
        }
        int min = Math.min(i2, fVar.CPu.pointCount);
        for (int i3 = 0; i3 < min; i3++) {
            ScanPoint scanPoint = (ScanPoint) e.f(scanPointArr, i3);
            if (scanPoint != null) {
                scanPoint.setXFactor((float) ((c.SYP.nextDouble(0.0d, 1.0d) * (d4 - d2)) + d2));
                scanPoint.setYFactor((float) ((c.SYP.nextDouble(0.0d, 1.0d) * (d5 - d3)) + d3));
                Log.d("MicroMsg.RandomScanDotsAnimationController", "alvinluo randomCenter i: %d, %f, %f", Integer.valueOf(i3), Float.valueOf(scanPoint.getX()), Float.valueOf(scanPoint.getY()));
            }
        }
        ae aeVar = fVar.CPu;
        AppMethodBeat.o(52261);
        return aeVar;
    }
}
