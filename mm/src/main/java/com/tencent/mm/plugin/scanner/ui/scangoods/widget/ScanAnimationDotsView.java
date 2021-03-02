package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.scanner.model.ae;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0014J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016J\b\u0010%\u001a\u00020\u0012H\u0016R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanAnimationDotsView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationType", "controller", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/IScanDotsAnimationController;", "viewHeight", "viewWidth", "addAnimationDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshView", "release", "setDuration", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "show", "visible", "", "startAnimation", "stopAnimation", "Companion", "plugin-scan_release"})
public final class ScanAnimationDotsView extends View implements d {
    public static final a CPJ = new a((byte) 0);
    private int CIp;
    private e CPI;
    private int gRD;
    private int gRE;

    static {
        AppMethodBeat.i(52285);
        AppMethodBeat.o(52285);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsView$Companion;", "", "()V", "DEFAULT_SIZE_ANIMATION_DURATION", "", "DOTS_ANIMATION_PERIOD_IN_MS", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanAnimationDotsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(52283);
        AppMethodBeat.o(52283);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanAnimationDotsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(52284);
        this.CIp = 1;
        this.CPI = i.a(this.CIp, context, this);
        AppMethodBeat.o(52284);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(52275);
        super.onDraw(canvas);
        e eVar = this.CPI;
        if (eVar != null) {
            eVar.draw(canvas);
            AppMethodBeat.o(52275);
            return;
        }
        AppMethodBeat.o(52275);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(52276);
        super.onMeasure(i2, i3);
        if (!(this.gRD == getMeasuredWidth() && this.gRE == getMeasuredHeight())) {
            this.gRD = getMeasuredWidth();
            this.gRE = getMeasuredHeight();
            e eVar = this.CPI;
            if (eVar != null) {
                eVar.ih(this.gRD, this.gRE);
                AppMethodBeat.o(52276);
                return;
            }
        }
        AppMethodBeat.o(52276);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
    public final void setDuration(long j2) {
        AppMethodBeat.i(52277);
        e eVar = this.CPI;
        if (eVar != null) {
            eVar.setDuration(j2);
            AppMethodBeat.o(52277);
            return;
        }
        AppMethodBeat.o(52277);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
    public final void refreshView() {
        AppMethodBeat.i(52278);
        e eVar = this.CPI;
        if (eVar != null) {
            eVar.refreshView();
        }
        invalidate();
        AppMethodBeat.o(52278);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
    public final void startAnimation() {
        AppMethodBeat.i(52279);
        Log.v("MicroMsg.ScanAnimationDotsView", "alvinluo startAnimation type: %d", Integer.valueOf(this.CIp));
        e eVar = this.CPI;
        if (eVar != null) {
            eVar.startAnimation();
            AppMethodBeat.o(52279);
            return;
        }
        AppMethodBeat.o(52279);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
    public final void b(ae aeVar) {
        AppMethodBeat.i(52280);
        p.h(aeVar, "pointsResult");
        Log.v("MicroMsg.ScanAnimationDotsView", "alvinluo addAnimationDots size: %d", Integer.valueOf(aeVar.pointCount));
        e eVar = this.CPI;
        if (eVar != null) {
            eVar.b(aeVar);
            AppMethodBeat.o(52280);
            return;
        }
        AppMethodBeat.o(52280);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
    public final void stopAnimation() {
        AppMethodBeat.i(52281);
        Log.v("MicroMsg.ScanAnimationDotsView", "alvinluo stopAnimation");
        e eVar = this.CPI;
        if (eVar != null) {
            eVar.stopAnimation();
            AppMethodBeat.o(52281);
            return;
        }
        AppMethodBeat.o(52281);
    }

    @Override // com.tencent.mm.plugin.scanner.ui.scangoods.widget.d
    public final void release() {
        AppMethodBeat.i(52282);
        e eVar = this.CPI;
        if (eVar != null) {
            eVar.release();
            AppMethodBeat.o(52282);
            return;
        }
        AppMethodBeat.o(52282);
    }
}
