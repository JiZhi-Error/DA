package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.f.h;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Set;

public final class c extends FrameLayout {
    private final Set<Runnable> noL = new HashSet();
    private final com.tencent.mm.plugin.appbrand.w.a olb;
    private b olc = new b();

    public interface a {
        float[] bOp();
    }

    public c(Context context) {
        super(context);
        AppMethodBeat.i(135389);
        setWillNotDraw(false);
        this.olb = (com.tencent.mm.plugin.appbrand.w.a) e.O(com.tencent.mm.plugin.appbrand.w.a.class);
        AppMethodBeat.o(135389);
    }

    public final void setRoundCornerProvider(a aVar) {
        this.olc.ole = aVar;
    }

    /* access modifiers changed from: protected */
    public final void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(135390);
        if (willNotDraw()) {
            AppMethodBeat.o(135390);
            return;
        }
        try {
            super.dispatchDraw(canvas);
            AppMethodBeat.o(135390);
        } catch (Exception e2) {
            Log.printErrStackTrace("Luggage.WXA.AppBrandRuntimeFrameLayout", e2, "", new Object[0]);
            if (e2 instanceof NullPointerException) {
                this.olb.idkeyStat(1088, 0, 1, false);
            } else {
                this.olb.idkeyStat(1088, 1, 1, false);
            }
            AppMethodBeat.o(135390);
            throw e2;
        }
    }

    public final void af(final Runnable runnable) {
        AppMethodBeat.i(135391);
        if (runnable == null) {
            AppMethodBeat.o(135391);
        } else if (!ag.LB()) {
            h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.c.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(135388);
                    c.this.af(runnable);
                    AppMethodBeat.o(135388);
                }
            });
            AppMethodBeat.o(135391);
        } else if (getAnimation() == null) {
            runnable.run();
            AppMethodBeat.o(135391);
        } else {
            this.noL.add(runnable);
            AppMethodBeat.o(135391);
        }
    }

    /* access modifiers changed from: protected */
    public final void onAnimationEnd() {
        AppMethodBeat.i(135392);
        super.onAnimationEnd();
        for (Runnable runnable : this.noL) {
            runnable.run();
        }
        this.noL.clear();
        AppMethodBeat.o(135392);
    }

    public final void onViewRemoved(View view) {
        AppMethodBeat.i(135393);
        super.onViewRemoved(view);
        Log.i("Luggage.WXA.AppBrandRuntimeFrameLayout", "onViewRemoved %s", view);
        AppMethodBeat.o(135393);
    }

    public final void removeAllViews() {
        AppMethodBeat.i(135394);
        Log.d("Luggage.WXA.AppBrandRuntimeFrameLayout", "removeAllViews stack = %s", android.util.Log.getStackTraceString(new Throwable()));
        super.removeAllViews();
        AppMethodBeat.o(135394);
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.widget.FrameLayout
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        AppMethodBeat.i(219613);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        AppMethodBeat.o(219613);
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(219614);
        b bVar = this.olc;
        if (bVar.ole != null) {
            float[] bOp = bVar.ole.bOp();
            bVar.rect.setEmpty();
            c.this.getGlobalVisibleRect(bVar.rect);
            RectF rectF = new RectF(0.0f, 0.0f, (float) (bVar.rect.right - bVar.rect.left), (float) (bVar.rect.bottom - bVar.rect.top));
            bVar.olf.setEmpty();
            bVar.olf.left = 0.0f;
            bVar.olf.top = 0.0f;
            bVar.olf.right = (float) (bVar.rect.right - bVar.rect.left);
            bVar.olf.bottom = (float) (bVar.rect.bottom - bVar.rect.top);
            bVar.lR.rewind();
            bVar.lR.addRoundRect(rectF, bOp, Path.Direction.CW);
            bVar.lR.close();
            canvas.clipPath(bVar.lR);
        }
        super.onDraw(canvas);
        AppMethodBeat.o(219614);
    }

    class b {
        Path lR = new Path();
        public a ole = null;
        RectF olf = new RectF();
        Rect rect = new Rect();

        public b() {
            AppMethodBeat.i(219612);
            AppMethodBeat.o(219612);
        }
    }
}
