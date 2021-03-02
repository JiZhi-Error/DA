package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.plugin.appbrand.canvas.c.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MDrawableView extends View implements a {
    private final b laI = new b(this);
    private final Set<View.OnAttachStateChangeListener> laJ = new LinkedHashSet();

    public MDrawableView(Context context) {
        super(context);
        AppMethodBeat.i(145420);
        setLayerType(1, null);
        AppMethodBeat.o(145420);
    }

    public MDrawableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(145421);
        setLayerType(1, null);
        AppMethodBeat.o(145421);
    }

    public MDrawableView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(145422);
        setLayerType(1, null);
        AppMethodBeat.o(145422);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(145423);
        o(canvas);
        AppMethodBeat.o(145423);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void bzg() {
        AppMethodBeat.i(145424);
        postInvalidate();
        AppMethodBeat.o(145424);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void U(Runnable runnable) {
        AppMethodBeat.i(145425);
        post(runnable);
        AppMethodBeat.o(145425);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public d getDrawContext() {
        AppMethodBeat.i(145426);
        d drawContext = this.laI.getDrawContext();
        AppMethodBeat.o(145426);
        return drawContext;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public void setDrawActionReportable(a aVar) {
        AppMethodBeat.i(145427);
        this.laI.setDrawActionReportable(aVar);
        AppMethodBeat.o(145427);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public void setTraceId(String str) {
        AppMethodBeat.i(145428);
        this.laI.setTraceId(str);
        AppMethodBeat.o(145428);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public String getTraceId() {
        AppMethodBeat.i(145429);
        String traceId = this.laI.getTraceId();
        AppMethodBeat.o(145429);
        return traceId;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final boolean o(Canvas canvas) {
        AppMethodBeat.i(145430);
        boolean o = this.laI.o(canvas);
        AppMethodBeat.o(145430);
        return o;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void a(JSONArray jSONArray, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145431);
        this.laI.a(jSONArray, aVar);
        AppMethodBeat.o(145431);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void b(JSONArray jSONArray, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145432);
        this.laI.b(jSONArray, aVar);
        AppMethodBeat.o(145432);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void a(DrawCanvasArg drawCanvasArg, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145433);
        this.laI.a(drawCanvasArg, aVar);
        AppMethodBeat.o(145433);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void b(DrawCanvasArg drawCanvasArg, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145434);
        this.laI.b(drawCanvasArg, aVar);
        AppMethodBeat.o(145434);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void bzh() {
        AppMethodBeat.i(145435);
        this.laI.bzh();
        AppMethodBeat.o(145435);
    }

    public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(145436);
        if (this.laJ.contains(onAttachStateChangeListener)) {
            AppMethodBeat.o(145436);
            return;
        }
        this.laJ.add(onAttachStateChangeListener);
        super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(145436);
    }

    public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(145437);
        this.laJ.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(145437);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.b
    public final void onResume() {
        AppMethodBeat.i(145438);
        this.laI.onResume();
        AppMethodBeat.o(145438);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.b
    public final boolean isPaused() {
        return this.laI.mPause;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.g
    public String getSessionId() {
        AppMethodBeat.i(145439);
        String sessionId = this.laI.getSessionId();
        AppMethodBeat.o(145439);
        return sessionId;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.g
    public void setSessionId(String str) {
        AppMethodBeat.i(145440);
        this.laI.setSessionId(str);
        AppMethodBeat.o(145440);
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.d
    public void setStartTime(long j2) {
        AppMethodBeat.i(145441);
        this.laI.setStartTime(j2);
        AppMethodBeat.o(145441);
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.d
    public final void bzi() {
        AppMethodBeat.i(145442);
        this.laI.bzi();
        AppMethodBeat.o(145442);
    }
}
