package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.g.b.a.nl;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView;
import com.tencent.mm.plugin.appbrand.game.e.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.JsApiTriggerBackgroundFetch;
import com.tencent.mm.plugin.appbrand.jsapi.p.d;
import com.tencent.mm.plugin.appbrand.jsapi.pay.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;

public final class b {
    private static volatile int lpY = 0;
    private static volatile boolean sInitialized = false;

    public static void initialize() {
        AppMethodBeat.i(121602);
        a.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.widget.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(121571);
                com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = a.C0356a.hnM;
                c Fu = com.tencent.mm.ipcinvoker.wx_extension.a.a.Fu("100284");
                if (Fu == null) {
                    Log.i("MicroMsg.WidgetDrawableViewFactory", "widget canvas mode ABTest item is null.");
                    AppMethodBeat.o(121571);
                } else if (!Fu.isValid()) {
                    b.wt(0);
                    AppMethodBeat.o(121571);
                } else {
                    try {
                        b.wt(Util.getInt(Fu.gzz().get("mode"), 0));
                        Log.i("MicroMsg.WidgetDrawableViewFactory", "current canvas mode is : %d", Integer.valueOf(b.lpY));
                        AppMethodBeat.o(121571);
                    } catch (Exception e2) {
                        Log.w("MicroMsg.WidgetDrawableViewFactory", "parse widget canvas mode error : %s", android.util.Log.getStackTraceString(e2));
                        AppMethodBeat.o(121571);
                    }
                }
            }
        });
        AppMethodBeat.o(121602);
    }

    public static void wt(int i2) {
        lpY = i2;
        sInitialized = true;
    }

    public static int bCu() {
        return lpY;
    }

    public static View cU(Context context) {
        AppMethodBeat.i(121603);
        if (!sInitialized) {
            initialize();
        }
        Log.d("MicroMsg.WidgetDrawableViewFactory", "inflate(mode : %d)", Integer.valueOf(lpY));
        switch (lpY) {
            case 1:
                final MTextureView mTextureView = new MTextureView(context);
                mTextureView.getDrawContext().kZr = com.tencent.mm.plugin.appbrand.dynamic.b.b.bBX();
                mTextureView.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a() {
                    /* class com.tencent.mm.plugin.appbrand.dynamic.widget.b.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void Ba(long j2) {
                        AppMethodBeat.i(121572);
                        com.tencent.mm.plugin.appbrand.widget.g.a.J(k.CTRL_INDEX, j2);
                        AppMethodBeat.o(121572);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void Bb(long j2) {
                        AppMethodBeat.i(121573);
                        com.tencent.mm.plugin.appbrand.widget.g.a.K(683, j2);
                        AppMethodBeat.o(121573);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void d(long j2, long j3, int i2) {
                        AppMethodBeat.i(121574);
                        com.tencent.mm.plugin.appbrand.widget.g.a.d(1, j2, j3, i2);
                        AppMethodBeat.o(121574);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void aH(float f2) {
                        AppMethodBeat.i(121575);
                        b.b((long) f2, 2, mTextureView.getTraceId());
                        AppMethodBeat.o(121575);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void aI(float f2) {
                        AppMethodBeat.i(121576);
                        b.b((long) f2, 3, mTextureView.getTraceId());
                        AppMethodBeat.o(121576);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void bzw() {
                        AppMethodBeat.i(121577);
                        u.Ls(mTextureView.getTraceId());
                        AppMethodBeat.o(121577);
                    }
                });
                AppMethodBeat.o(121603);
                return mTextureView;
            case 2:
                final MSurfaceView mSurfaceView = new MSurfaceView(context);
                mSurfaceView.getDrawContext().kZr = com.tencent.mm.plugin.appbrand.dynamic.b.b.bBX();
                mSurfaceView.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a() {
                    /* class com.tencent.mm.plugin.appbrand.dynamic.widget.b.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void Ba(long j2) {
                        AppMethodBeat.i(121578);
                        com.tencent.mm.plugin.appbrand.widget.g.a.J(com.tencent.mm.plugin.appbrand.game.e.a.a.CTRL_INDEX, j2);
                        AppMethodBeat.o(121578);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void Bb(long j2) {
                        AppMethodBeat.i(121579);
                        com.tencent.mm.plugin.appbrand.widget.g.a.K(f.CTRL_INDEX, j2);
                        AppMethodBeat.o(121579);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void d(long j2, long j3, int i2) {
                        AppMethodBeat.i(121580);
                        com.tencent.mm.plugin.appbrand.widget.g.a.d(2, j2, j3, i2);
                        AppMethodBeat.o(121580);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void aH(float f2) {
                        AppMethodBeat.i(121581);
                        b.b((long) f2, 2, mSurfaceView.getTraceId());
                        AppMethodBeat.o(121581);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void aI(float f2) {
                        AppMethodBeat.i(121582);
                        b.b((long) f2, 3, mSurfaceView.getTraceId());
                        AppMethodBeat.o(121582);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void bzw() {
                        AppMethodBeat.i(121583);
                        if (TextUtils.isEmpty(mSurfaceView.getTraceId())) {
                            u.i("MicroMsg.WidgetDrawableViewFactory", "traceId is null return", new Object[0]);
                            AppMethodBeat.o(121583);
                            return;
                        }
                        u.Ls(mSurfaceView.getTraceId());
                        AppMethodBeat.o(121583);
                    }
                });
                AppMethodBeat.o(121603);
                return mSurfaceView;
            case 3:
                final MCanvasView mCanvasView = new MCanvasView(context);
                mCanvasView.getDrawContext().kZr = com.tencent.mm.plugin.appbrand.dynamic.b.b.bBX();
                mCanvasView.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a() {
                    /* class com.tencent.mm.plugin.appbrand.dynamic.widget.b.AnonymousClass4 */

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void Ba(long j2) {
                        AppMethodBeat.i(121584);
                        com.tencent.mm.plugin.appbrand.widget.g.a.J(JsApiTriggerBackgroundFetch.CTRL_INDEX, j2);
                        AppMethodBeat.o(121584);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void Bb(long j2) {
                        AppMethodBeat.i(121585);
                        com.tencent.mm.plugin.appbrand.widget.g.a.K(d.CTRL_INDEX, j2);
                        AppMethodBeat.o(121585);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void d(long j2, long j3, int i2) {
                        AppMethodBeat.i(121586);
                        com.tencent.mm.plugin.appbrand.widget.g.a.d(3, j2, j3, i2);
                        AppMethodBeat.o(121586);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void aH(float f2) {
                        AppMethodBeat.i(121587);
                        b.b((long) f2, 2, mCanvasView.getTraceId());
                        AppMethodBeat.o(121587);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void aI(float f2) {
                        AppMethodBeat.i(121588);
                        b.b((long) f2, 3, mCanvasView.getTraceId());
                        AppMethodBeat.o(121588);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void bzw() {
                        AppMethodBeat.i(121589);
                        u.Ls(mCanvasView.getTraceId());
                        AppMethodBeat.o(121589);
                    }
                });
                AppMethodBeat.o(121603);
                return mCanvasView;
            case 4:
                final MDrawableView mDrawableView = new MDrawableView(context);
                mDrawableView.getDrawContext().kZr = com.tencent.mm.plugin.appbrand.dynamic.b.b.bBX();
                mDrawableView.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a() {
                    /* class com.tencent.mm.plugin.appbrand.dynamic.widget.b.AnonymousClass5 */

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void Ba(long j2) {
                        AppMethodBeat.i(121590);
                        com.tencent.mm.plugin.appbrand.widget.g.a.J(com.tencent.mm.plugin.appbrand.game.e.a.a.CTRL_INDEX, j2);
                        AppMethodBeat.o(121590);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void Bb(long j2) {
                        AppMethodBeat.i(121591);
                        com.tencent.mm.plugin.appbrand.widget.g.a.K(f.CTRL_INDEX, j2);
                        AppMethodBeat.o(121591);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void d(long j2, long j3, int i2) {
                        AppMethodBeat.i(121592);
                        com.tencent.mm.plugin.appbrand.widget.g.a.d(4, j2, j3, i2);
                        AppMethodBeat.o(121592);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void aH(float f2) {
                        AppMethodBeat.i(121593);
                        b.b((long) f2, 2, mDrawableView.getTraceId());
                        AppMethodBeat.o(121593);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void aI(float f2) {
                        AppMethodBeat.i(121594);
                        b.b((long) f2, 3, mDrawableView.getTraceId());
                        AppMethodBeat.o(121594);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void bzw() {
                        AppMethodBeat.i(121595);
                        u.Ls(mDrawableView.getTraceId());
                        AppMethodBeat.o(121595);
                    }
                });
                AppMethodBeat.o(121603);
                return mDrawableView;
            default:
                final MHardwareAccelerateDrawableView mHardwareAccelerateDrawableView = new MHardwareAccelerateDrawableView(context);
                mHardwareAccelerateDrawableView.getDrawContext().kZr = com.tencent.mm.plugin.appbrand.dynamic.b.b.bBX();
                mHardwareAccelerateDrawableView.setDrawActionReportable(new com.tencent.mm.plugin.appbrand.canvas.c.a() {
                    /* class com.tencent.mm.plugin.appbrand.dynamic.widget.b.AnonymousClass6 */

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void Ba(long j2) {
                        AppMethodBeat.i(121596);
                        com.tencent.mm.plugin.appbrand.widget.g.a.J(com.tencent.mm.plugin.appbrand.game.e.a.a.CTRL_INDEX, j2);
                        AppMethodBeat.o(121596);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void Bb(long j2) {
                        AppMethodBeat.i(121597);
                        com.tencent.mm.plugin.appbrand.widget.g.a.K(f.CTRL_INDEX, j2);
                        AppMethodBeat.o(121597);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void d(long j2, long j3, int i2) {
                        AppMethodBeat.i(121598);
                        com.tencent.mm.plugin.appbrand.widget.g.a.d(0, j2, j3, i2);
                        AppMethodBeat.o(121598);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void aH(float f2) {
                        AppMethodBeat.i(121599);
                        b.b((long) f2, 2, mHardwareAccelerateDrawableView.getTraceId());
                        AppMethodBeat.o(121599);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void aI(float f2) {
                        AppMethodBeat.i(121600);
                        b.b((long) f2, 3, mHardwareAccelerateDrawableView.getTraceId());
                        AppMethodBeat.o(121600);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.canvas.c.a
                    public final void bzw() {
                        AppMethodBeat.i(121601);
                        u.Ls(mHardwareAccelerateDrawableView.getTraceId());
                        AppMethodBeat.o(121601);
                    }
                });
                AppMethodBeat.o(121603);
                return mHardwareAccelerateDrawableView;
        }
    }

    public static String bCv() {
        switch (lpY) {
            case 1:
                return "MTextureView";
            case 2:
                return "MSurfaceView";
            case 3:
                return "MCanvasView";
            case 4:
                return "MDrawableView";
            default:
                return "MHADrawableView";
        }
    }

    static /* synthetic */ void b(long j2, int i2, String str) {
        AppMethodBeat.i(121604);
        nl nlVar = new nl();
        nlVar.ejW = (long) i2;
        nlVar.eMp = j2;
        nlVar.fgF = (long) u.Lw(str);
        nlVar.AA(u.Lv(str)).bfK();
        AppMethodBeat.o(121604);
    }
}
