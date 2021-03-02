package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 $2\u00020\u0001:\u0002$%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\u001dH\u0002R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006&"}, hxF = {"Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout;", "Lcom/tencent/mm/ui/widget/cropview/TouchEventLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "borderView", "Landroid/view/View;", "getBorderView", "()Landroid/view/View;", "setBorderView", "(Landroid/view/View;)V", "isHasBorder", "", "()Z", "setHasBorder", "(Z)V", "onBorderVisibilityCallback", "Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout$OnBorderVisibilityCallback;", "getOnBorderVisibilityCallback", "()Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout$OnBorderVisibilityCallback;", "setOnBorderVisibilityCallback", "(Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout$OnBorderVisibilityCallback;)V", "dismissBorder", "", "onDown", "e", "Landroid/view/MotionEvent;", e.b.NAME, "e1", "showBorder", "Companion", "OnBorderVisibilityCallback", "libmmui_release"})
public abstract class BaseCropLayout extends TouchEventLayout {
    public static final a QLW = new a((byte) 0);
    private boolean QLT = true;
    private View QLU;
    private b QLV;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout$OnBorderVisibilityCallback;", "", "onDismiss", "", "onShow", "libmmui_release"})
    public interface b {
        void onDismiss();

        void onShow();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseCropLayout(Context context) {
        super(context);
        p.h(context, "context");
        setOnTouchListener(this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseCropLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        setOnTouchListener(this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseCropLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        setOnTouchListener(this);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/ui/widget/cropview/BaseCropLayout$Companion;", "", "()V", "BORDER_DELAY", "", "BORDER_DURATION", "libmmui_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void setHasBorder(boolean z) {
        this.QLT = z;
    }

    public final View getBorderView() {
        return this.QLU;
    }

    public final void setBorderView(View view) {
        this.QLU = view;
    }

    public final b getOnBorderVisibilityCallback() {
        return this.QLV;
    }

    public final void setOnBorderVisibilityCallback(b bVar) {
        this.QLV = bVar;
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public void ad(MotionEvent motionEvent) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator startDelay;
        p.h(motionEvent, "e1");
        if (this.QLT && this.QLT) {
            b bVar = this.QLV;
            if (bVar != null) {
                bVar.onDismiss();
            }
            View view = this.QLU;
            if (view != null) {
                view.setAlpha(1.0f);
            }
            View view2 = this.QLU;
            if (view2 != null && (animate = view2.animate()) != null && (alpha = animate.alpha(0.0f)) != null && (duration = alpha.setDuration(300)) != null && (startDelay = duration.setStartDelay(1000)) != null) {
                startDelay.start();
            }
        }
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public boolean onDown(MotionEvent motionEvent) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator startDelay;
        if (this.QLT && this.QLT) {
            b bVar = this.QLV;
            if (bVar != null) {
                bVar.onShow();
            }
            View view = this.QLU;
            if (!(view == null || (animate = view.animate()) == null || (alpha = animate.alpha(1.0f)) == null || (duration = alpha.setDuration(300)) == null || (startDelay = duration.setStartDelay(0)) == null)) {
                startDelay.start();
            }
        }
        return super.onDown(motionEvent);
    }
}
