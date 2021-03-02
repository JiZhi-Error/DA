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

public class MHardwareAccelerateDrawableView extends View implements a {
    private final b laI = new b(this);
    private final Set<View.OnAttachStateChangeListener> laJ = new LinkedHashSet();

    public MHardwareAccelerateDrawableView(Context context) {
        super(context);
        AppMethodBeat.i(145444);
        setLayerType(2, null);
        AppMethodBeat.o(145444);
    }

    public MHardwareAccelerateDrawableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(145445);
        setLayerType(2, null);
        AppMethodBeat.o(145445);
    }

    public MHardwareAccelerateDrawableView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(145446);
        setLayerType(2, null);
        AppMethodBeat.o(145446);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(145447);
        o(canvas);
        AppMethodBeat.o(145447);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public void setTraceId(String str) {
        AppMethodBeat.i(145448);
        this.laI.setTraceId(str);
        AppMethodBeat.o(145448);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public String getTraceId() {
        AppMethodBeat.i(145449);
        String traceId = this.laI.getTraceId();
        AppMethodBeat.o(145449);
        return traceId;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void bzg() {
        AppMethodBeat.i(145450);
        postInvalidate();
        AppMethodBeat.o(145450);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void U(Runnable runnable) {
        AppMethodBeat.i(145451);
        this.laI.U(runnable);
        AppMethodBeat.o(145451);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public d getDrawContext() {
        AppMethodBeat.i(145452);
        d drawContext = this.laI.getDrawContext();
        AppMethodBeat.o(145452);
        return drawContext;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public void setDrawActionReportable(a aVar) {
        AppMethodBeat.i(145453);
        this.laI.setDrawActionReportable(aVar);
        AppMethodBeat.o(145453);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final boolean o(Canvas canvas) {
        AppMethodBeat.i(145454);
        boolean o = this.laI.o(canvas);
        AppMethodBeat.o(145454);
        return o;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void a(JSONArray jSONArray, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145455);
        this.laI.a(jSONArray, aVar);
        AppMethodBeat.o(145455);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void b(JSONArray jSONArray, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145456);
        this.laI.b(jSONArray, aVar);
        AppMethodBeat.o(145456);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void a(DrawCanvasArg drawCanvasArg, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145457);
        this.laI.a(drawCanvasArg, aVar);
        AppMethodBeat.o(145457);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void b(DrawCanvasArg drawCanvasArg, a.AbstractC0561a aVar) {
        AppMethodBeat.i(145458);
        this.laI.b(drawCanvasArg, aVar);
        AppMethodBeat.o(145458);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void bzh() {
        AppMethodBeat.i(145459);
        this.laI.bzh();
        AppMethodBeat.o(145459);
    }

    public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(145460);
        if (this.laJ.contains(onAttachStateChangeListener)) {
            AppMethodBeat.o(145460);
            return;
        }
        this.laJ.add(onAttachStateChangeListener);
        super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(145460);
    }

    public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(145461);
        this.laJ.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(145461);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.b
    public final void onResume() {
        AppMethodBeat.i(145462);
        this.laI.onResume();
        AppMethodBeat.o(145462);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.b
    public final boolean isPaused() {
        return this.laI.mPause;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.g
    public String getSessionId() {
        AppMethodBeat.i(145463);
        String sessionId = this.laI.getSessionId();
        AppMethodBeat.o(145463);
        return sessionId;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.g
    public void setSessionId(String str) {
        AppMethodBeat.i(145464);
        this.laI.setSessionId(str);
        AppMethodBeat.o(145464);
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.d
    public void setStartTime(long j2) {
        AppMethodBeat.i(145465);
        this.laI.setStartTime(j2);
        AppMethodBeat.o(145465);
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.d
    public final void bzi() {
        AppMethodBeat.i(145466);
        this.laI.bzi();
        AppMethodBeat.o(145466);
    }
}
