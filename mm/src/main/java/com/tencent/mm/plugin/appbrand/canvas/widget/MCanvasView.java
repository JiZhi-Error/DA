package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MCanvasView extends View implements a {
    public final b laI = new b(this);
    private final Set<View.OnAttachStateChangeListener> laJ = new LinkedHashSet();
    private Bitmap mBitmap;

    public MCanvasView(Context context) {
        super(context);
        AppMethodBeat.i(145395);
        init();
        AppMethodBeat.o(145395);
    }

    public MCanvasView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(145396);
        init();
        AppMethodBeat.o(145396);
    }

    public MCanvasView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(145397);
        init();
        AppMethodBeat.o(145397);
    }

    private void init() {
        AppMethodBeat.i(161173);
        Log.v("MicroMsg.MCanvasView", "init %s", Integer.valueOf(hashCode()));
        AppMethodBeat.o(161173);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(161174);
        super.onDetachedFromWindow();
        bzx();
        AppMethodBeat.o(161174);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(145398);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            AppMethodBeat.o(145398);
            return;
        }
        if (this.mBitmap == null || this.mBitmap.isRecycled() || this.mBitmap.getWidth() != measuredWidth || this.mBitmap.getHeight() != measuredHeight) {
            bzx();
            try {
                this.mBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                Log.v("MicroMsg.MCanvasView", "create a new bitmap(id : %s, w : %s, h : %s)", Integer.valueOf(hashCode()), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
            } catch (OutOfMemoryError e2) {
                Log.e("MicroMsg.MCanvasView", "onDraw oom w:%d h:%d", Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
                this.mBitmap = null;
            }
        }
        if (this.mBitmap == null) {
            Log.d("MicroMsg.MCanvasView", "bitmap is null.");
            AppMethodBeat.o(145398);
            return;
        }
        this.mBitmap.eraseColor(0);
        f fVar = new f(this.mBitmap);
        o(fVar);
        try {
            canvas.drawBitmap(fVar.mBitmap, 0.0f, 0.0f, (Paint) null);
            AppMethodBeat.o(145398);
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.MCanvasView", e3, "", new Object[0]);
            o(canvas);
            AppMethodBeat.o(145398);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(145399);
        super.onSizeChanged(i2, i3, i4, i5);
        bzx();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            try {
                this.mBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                Log.v("MicroMsg.MCanvasView", "onSizeChanged, create a new bitmap(id : %s, w : %s, h : %s)", Integer.valueOf(hashCode()), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
            } catch (OutOfMemoryError e2) {
                Log.e("MicroMsg.MCanvasView", "onSizeChanged oom w:%d h:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                this.mBitmap = null;
                AppMethodBeat.o(145399);
                return;
            }
        }
        AppMethodBeat.o(145399);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final boolean o(Canvas canvas) {
        AppMethodBeat.i(145400);
        boolean o = this.laI.o(canvas);
        AppMethodBeat.o(145400);
        return o;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void bzg() {
        AppMethodBeat.i(145401);
        if (!u.az(this)) {
            post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(145394);
                    ViewParent parent = MCanvasView.this.getParent();
                    do {
                        ((View) parent).forceLayout();
                        parent = parent.getParent();
                    } while (parent instanceof View);
                    if (parent != null) {
                        parent.requestLayout();
                        MCanvasView.this.invalidate();
                    }
                    AppMethodBeat.o(145394);
                }
            });
            AppMethodBeat.o(145401);
            return;
        }
        postInvalidate();
        AppMethodBeat.o(145401);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void a(JSONArray jSONArray, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145402);
        this.laI.a(jSONArray, aVar);
        AppMethodBeat.o(145402);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void b(JSONArray jSONArray, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145403);
        this.laI.b(jSONArray, aVar);
        AppMethodBeat.o(145403);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void a(DrawCanvasArg drawCanvasArg, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145404);
        this.laI.a(drawCanvasArg, aVar);
        AppMethodBeat.o(145404);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void b(DrawCanvasArg drawCanvasArg, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145405);
        this.laI.b(drawCanvasArg, aVar);
        AppMethodBeat.o(145405);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void bzh() {
        AppMethodBeat.i(145406);
        this.laI.bzh();
        AppMethodBeat.o(145406);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void U(Runnable runnable) {
        AppMethodBeat.i(145407);
        post(runnable);
        AppMethodBeat.o(145407);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public d getDrawContext() {
        AppMethodBeat.i(145408);
        d drawContext = this.laI.getDrawContext();
        AppMethodBeat.o(145408);
        return drawContext;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a aVar) {
        AppMethodBeat.i(145409);
        this.laI.setDrawActionReportable(aVar);
        AppMethodBeat.o(145409);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public void setTraceId(String str) {
        AppMethodBeat.i(145410);
        this.laI.setTraceId(str);
        AppMethodBeat.o(145410);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public String getTraceId() {
        AppMethodBeat.i(145411);
        String traceId = this.laI.getTraceId();
        AppMethodBeat.o(145411);
        return traceId;
    }

    public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(145412);
        if (this.laJ.contains(onAttachStateChangeListener)) {
            AppMethodBeat.o(145412);
            return;
        }
        this.laJ.add(onAttachStateChangeListener);
        super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(145412);
    }

    public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(145413);
        this.laJ.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(145413);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.b
    public final void onResume() {
        AppMethodBeat.i(145414);
        Log.v("MicroMsg.MCanvasView", "onResume :%s", Integer.valueOf(hashCode()));
        this.laI.onResume();
        AppMethodBeat.o(145414);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.b
    public final boolean isPaused() {
        return this.laI.mPause;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.g
    public String getSessionId() {
        AppMethodBeat.i(145415);
        String sessionId = this.laI.getSessionId();
        AppMethodBeat.o(145415);
        return sessionId;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.g
    public void setSessionId(String str) {
        AppMethodBeat.i(145416);
        this.laI.setSessionId(str);
        AppMethodBeat.o(145416);
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.d
    public void setStartTime(long j2) {
        AppMethodBeat.i(145417);
        this.laI.setStartTime(j2);
        AppMethodBeat.o(145417);
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.d
    public final void bzi() {
        AppMethodBeat.i(145418);
        this.laI.bzi();
        AppMethodBeat.o(145418);
    }

    public final void bzx() {
        AppMethodBeat.i(161175);
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            Log.i("MicroMsg.MCanvasView", "bitmap recycle %s %s", Integer.valueOf(hashCode()), this.mBitmap);
            this.mBitmap.recycle();
        }
        AppMethodBeat.o(161175);
    }
}
