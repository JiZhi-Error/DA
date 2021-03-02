package com.tencent.mm.plugin.multitask.animation.swipeahead;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitask.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 /2\u00020\u0001:\u0002/0B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u001e\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0014J\u0006\u0010%\u001a\u00020\u001dJ\u0006\u0010&\u001a\u00020\u001dJ\u0006\u0010'\u001a\u00020\u001dJ\u0006\u0010(\u001a\u00020\u001dJ\u0006\u0010)\u001a\u00020\u001dJ\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u000eJ\u0010\u0010,\u001a\u00020\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001e\u0010-\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\b\u0010.\u001a\u00020\u001dH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationHandler", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorViewAnimationHandler;", "backgroundImageView", "Landroid/widget/ImageView;", "hasReachFloatBallCountLimit", "", "indicatorImageView", "indicatorTextView", "Landroid/widget/TextView;", "orientationChangedListener", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView$OnOrientationChangedListener;", "vibrator", "Landroid/os/Vibrator;", "zoomInAnimator", "Landroid/animation/Animator;", "zoomOutAnimator", "createZoomInAnimation", "Landroid/animation/AnimatorSet;", "createZoomOutAnimation", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", "withAnimation", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDragEnd", "onDragEnter", "onDragExit", "onDragStart", "onFloatBallInfoCountChanged", "onHitChange", "isHit", "setOnOrientationChangedListener", "show", "vibrate", "Companion", "OnOrientationChangedListener", "plugin-multitask_release"})
public final class FloatMultiTaskIndicatorView extends FrameLayout {
    public static final a Aaq = new a((byte) 0);
    private c Aao;
    private b Aap;
    Vibrator paT;
    ImageView pcg;
    ImageView pch;
    private TextView pci;
    Animator pck;
    Animator pcl;
    boolean pcn;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView$OnOrientationChangedListener;", "", "onOrientationChanged", "", "isLandscape", "", "plugin-multitask_release"})
    public interface b {
        void jY(boolean z);
    }

    static {
        AppMethodBeat.i(200453);
        AppMethodBeat.o(200453);
    }

    public FloatMultiTaskIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, (byte) 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatMultiTaskIndicatorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        if (context == null) {
            p.hyc();
        }
        AppMethodBeat.i(200451);
        View.inflate(context, R.layout.ayv, this);
        this.pcg = (ImageView) findViewById(R.id.y2);
        this.pch = (ImageView) findViewById(R.id.dxv);
        this.pci = (TextView) findViewById(R.id.dxw);
        Object systemService = context != null ? context.getSystemService("vibrator") : null;
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.os.Vibrator");
            AppMethodBeat.o(200451);
            throw tVar;
        }
        this.paT = (Vibrator) systemService;
        this.Aao = new c(this);
        float f2 = f.oYQ;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.pcg, "scaleX", f2, 1.0f);
        p.g(ofFloat, "scaleX");
        ofFloat.setDuration(200L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.pcg, "scaleY", f2, 1.0f);
        p.g(ofFloat2, "scaleY");
        ofFloat2.setDuration(200L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.pck = animatorSet;
        float f3 = f.oYQ;
        AnimatorSet animatorSet2 = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.pcg, "scaleX", 1.0f, f3);
        p.g(ofFloat3, "scaleX");
        ofFloat3.setDuration(200L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.pcg, "scaleY", 1.0f, f3);
        p.g(ofFloat4, "scaleY");
        ofFloat4.setDuration(200L);
        animatorSet2.playTogether(ofFloat3, ofFloat4);
        this.pcl = animatorSet2;
        AppMethodBeat.o(200451);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FloatMultiTaskIndicatorView(Context context, AttributeSet attributeSet, int i2, byte b2) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, 0);
        AppMethodBeat.i(200452);
        AppMethodBeat.o(200452);
    }

    /* access modifiers changed from: protected */
    public final void onConfigurationChanged(Configuration configuration) {
        b bVar;
        AppMethodBeat.i(200449);
        p.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (this.Aap == null || (bVar = this.Aap) == null) {
            AppMethodBeat.o(200449);
            return;
        }
        bVar.jY(configuration.orientation == 2);
        AppMethodBeat.o(200449);
    }

    public final void eqI() {
        AppMethodBeat.i(200450);
        Log.i("MicroMsg.FloatMultiTaskIndicatorView", "onFloatBallInfoCountChanged");
        this.pcn = false;
        TextView textView = this.pci;
        if (textView != null) {
            textView.setText(R.string.bx1);
        }
        TextView textView2 = this.pci;
        if (textView2 != null) {
            textView2.setTextColor(android.support.v4.content.b.n(getContext(), R.color.rc));
        }
        ImageView imageView = this.pcg;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.et);
        }
        ImageView imageView2 = this.pch;
        if (imageView2 != null) {
            imageView2.setImageDrawable(com.tencent.mm.svg.a.a.h(getResources(), R.raw.multitask_indicator_icon));
            AppMethodBeat.o(200450);
            return;
        }
        AppMethodBeat.o(200450);
    }

    public final void setOnOrientationChangedListener(b bVar) {
        this.Aap = bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView$Companion;", "", "()V", "TAG", "", "plugin-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
