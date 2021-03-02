package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.plugin.appbrand.canvas.c.a;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MSurfaceView extends SurfaceView implements SurfaceHolder.Callback, a {
    private final b laI = new b(this);
    private final Set<View.OnAttachStateChangeListener> laJ = new LinkedHashSet();
    private SurfaceHolder laL;
    private MMHandler laM;
    private Runnable laN = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(145468);
            if (MSurfaceView.this.mDestroyed) {
                AppMethodBeat.o(145468);
                return;
            }
            Canvas lockCanvas = MSurfaceView.this.laL.lockCanvas();
            if (lockCanvas == null) {
                AppMethodBeat.o(145468);
                return;
            }
            lockCanvas.drawColor(-1);
            MSurfaceView.this.o(lockCanvas);
            MSurfaceView.this.laL.unlockCanvasAndPost(lockCanvas);
            AppMethodBeat.o(145468);
        }
    };
    private volatile boolean mDestroyed;

    public MSurfaceView(Context context) {
        super(context);
        AppMethodBeat.i(145470);
        init();
        AppMethodBeat.o(145470);
    }

    public MSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(145471);
        init();
        AppMethodBeat.o(145471);
    }

    public MSurfaceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(145472);
        init();
        AppMethodBeat.o(145472);
    }

    private void init() {
        AppMethodBeat.i(145473);
        this.laL = getHolder();
        this.laL.addCallback(this);
        this.laL.setFormat(-3);
        Paint paint = new Paint();
        paint.setColor(-1);
        this.laI.getDrawContext().kZq = paint;
        AppMethodBeat.o(145473);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(145474);
        Log.i("MicroMsg.MSurfaceView", "surfaceCreated(%s)", Integer.valueOf(hashCode()));
        this.mDestroyed = false;
        if (this.laM == null) {
            HandlerThread hz = d.hz("MSurfaceView#Rending-Thread", -19);
            hz.start();
            this.laM = new MMHandler(hz.getLooper());
        }
        AppMethodBeat.o(145474);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        AppMethodBeat.i(145475);
        Log.i("MicroMsg.MSurfaceView", "surfaceChanged(%s)", Integer.valueOf(hashCode()));
        AppMethodBeat.o(145475);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(145476);
        Log.i("MicroMsg.MSurfaceView", "surfaceDestroyed(%s)", Integer.valueOf(hashCode()));
        this.mDestroyed = true;
        this.laM.getLooper().quit();
        this.laM = null;
        AppMethodBeat.o(145476);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public void setTraceId(String str) {
        AppMethodBeat.i(145477);
        this.laI.setTraceId(str);
        AppMethodBeat.o(145477);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public String getTraceId() {
        AppMethodBeat.i(145478);
        String traceId = this.laI.getTraceId();
        AppMethodBeat.o(145478);
        return traceId;
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(145479);
        Log.i("MicroMsg.MSurfaceView", "draw(%s)", Integer.valueOf(hashCode()));
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.draw(canvas);
        AppMethodBeat.o(145479);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void bzg() {
        AppMethodBeat.i(145480);
        U(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(145469);
                if (MSurfaceView.this.mDestroyed) {
                    AppMethodBeat.o(145469);
                    return;
                }
                Canvas lockCanvas = MSurfaceView.this.laL.lockCanvas();
                if (lockCanvas == null) {
                    AppMethodBeat.o(145469);
                    return;
                }
                lockCanvas.drawColor(-1);
                MSurfaceView.this.o(lockCanvas);
                MSurfaceView.this.laL.unlockCanvasAndPost(lockCanvas);
                AppMethodBeat.o(145469);
            }
        });
        AppMethodBeat.o(145480);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void U(Runnable runnable) {
        AppMethodBeat.i(145481);
        if (this.laM == null) {
            AppMethodBeat.o(145481);
            return;
        }
        this.laM.post(runnable);
        AppMethodBeat.o(145481);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public com.tencent.mm.plugin.appbrand.canvas.d getDrawContext() {
        AppMethodBeat.i(145482);
        com.tencent.mm.plugin.appbrand.canvas.d drawContext = this.laI.getDrawContext();
        AppMethodBeat.o(145482);
        return drawContext;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public void setDrawActionReportable(a aVar) {
        AppMethodBeat.i(145483);
        this.laI.setDrawActionReportable(aVar);
        AppMethodBeat.o(145483);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final boolean o(Canvas canvas) {
        AppMethodBeat.i(145484);
        boolean o = this.laI.o(canvas);
        AppMethodBeat.o(145484);
        return o;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void a(JSONArray jSONArray, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145485);
        this.laI.a(jSONArray, aVar);
        AppMethodBeat.o(145485);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void b(JSONArray jSONArray, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145486);
        this.laI.b(jSONArray, aVar);
        AppMethodBeat.o(145486);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void a(DrawCanvasArg drawCanvasArg, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145487);
        this.laI.a(drawCanvasArg, aVar);
        AppMethodBeat.o(145487);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void b(DrawCanvasArg drawCanvasArg, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145488);
        this.laI.b(drawCanvasArg, aVar);
        AppMethodBeat.o(145488);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void bzh() {
        AppMethodBeat.i(145489);
        this.laI.bzh();
        AppMethodBeat.o(145489);
    }

    public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(145490);
        if (this.laJ.contains(onAttachStateChangeListener)) {
            AppMethodBeat.o(145490);
            return;
        }
        this.laJ.add(onAttachStateChangeListener);
        super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(145490);
    }

    public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(145491);
        this.laJ.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(145491);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.b
    public final void onResume() {
        AppMethodBeat.i(145492);
        this.laI.onResume();
        AppMethodBeat.o(145492);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.b
    public final boolean isPaused() {
        return this.laI.mPause;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.g
    public String getSessionId() {
        AppMethodBeat.i(145493);
        String sessionId = this.laI.getSessionId();
        AppMethodBeat.o(145493);
        return sessionId;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.g
    public void setSessionId(String str) {
        AppMethodBeat.i(145494);
        this.laI.setSessionId(str);
        AppMethodBeat.o(145494);
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.d
    public void setStartTime(long j2) {
        AppMethodBeat.i(145495);
        this.laI.setStartTime(j2);
        AppMethodBeat.o(145495);
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.d
    public final void bzi() {
        AppMethodBeat.i(145496);
        this.laI.bzi();
        AppMethodBeat.o(145496);
    }
}
