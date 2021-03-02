package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ(\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006!"}, hxF = {"Lcom/tencent/mm/ui/widget/cropview/DragExitCropLayout;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "beginDragExitScale", "", "bgView", "Landroid/view/View;", "getBgView", "()Landroid/view/View;", "setBgView", "(Landroid/view/View;)V", "isBeginDragExit", "", "isEnableDragExit", "()Z", "setEnableDragExit", "(Z)V", "onScroll", "e1", "Landroid/view/MotionEvent;", "e2", "distanceX", "distanceY", e.b.NAME, "", "libmmui_release"})
public class DragExitCropLayout extends CropLayout {
    private boolean QMV;
    private boolean QMW;
    private float QMX = 1.0f;
    private View cBH;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DragExitCropLayout(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(164450);
        AppMethodBeat.o(164450);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DragExitCropLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(164451);
        AppMethodBeat.o(164451);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DragExitCropLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(164452);
        AppMethodBeat.o(164452);
    }

    public final void setEnableDragExit(boolean z) {
        this.QMV = z;
    }

    public final View getBgView() {
        return this.cBH;
    }

    public final void setBgView(View view) {
        this.cBH = view;
    }

    @Override // com.tencent.mm.ui.widget.cropview.CropLayout, com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(164448);
        p.h(motionEvent, "e1");
        p.h(motionEvent2, "e2");
        if (this.QMV && !this.QMl && !hbd() && motionEvent.getPointerCount() == 1 && motionEvent2.getPointerCount() == 1 && (this.QMW || f3 < 0.0f)) {
            if (!this.QMW) {
                this.QMX = getContentViewScale()[0];
            }
            this.QMW = true;
            float exactCenterY = (getContentRect().exactCenterY() - getVisibilityRect().centerY()) / (getVisibilityRect().height() / 2.0f);
            t(((1.0f - (0.6f * exactCenterY)) * this.QMX) / getContentViewScale()[0], getContentRect().exactCenterX(), getContentRect().exactCenterY());
            View view = this.cBH;
            if (view != null) {
                view.setAlpha(1.0f - exactCenterY);
            }
        }
        boolean onScroll = super.onScroll(motionEvent, motionEvent2, f2, f3);
        AppMethodBeat.o(164448);
        return onScroll;
    }

    @Override // com.tencent.mm.ui.widget.cropview.CropLayout, com.tencent.mm.ui.widget.cropview.BaseCropLayout, com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public final void ad(MotionEvent motionEvent) {
        View view;
        ViewPropertyAnimator animate;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator alpha;
        AppMethodBeat.i(164449);
        p.h(motionEvent, "e1");
        super.ad(motionEvent);
        if (!(!this.QMW || (view = this.cBH) == null || (animate = view.animate()) == null || (duration = animate.setDuration(200)) == null || (alpha = duration.alpha(1.0f)) == null)) {
            alpha.start();
        }
        this.QMW = false;
        AppMethodBeat.o(164449);
    }
}
