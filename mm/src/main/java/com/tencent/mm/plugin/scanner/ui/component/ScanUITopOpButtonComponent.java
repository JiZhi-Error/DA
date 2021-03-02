package com.tencent.mm.plugin.scanner.ui.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!J\u000e\u0010$\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010(R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/component/ScanUITopOpButtonComponent;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttonContainer", "Landroid/view/View;", "cancelButton", "Landroid/widget/TextView;", "closeButton", "Landroid/widget/ImageView;", "moreButton", "animateAlpha", "", "view", "show", "", "animateCancelButton", "animateCloseButton", "animateMoreButton", "animateSelf", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onBackPressed", "listenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "setOnCancelClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setOnCloseClickListener", "setOnMoreClickListener", "setShowMoreButton", "switchCloseView", "showCancelButton", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "Companion", "plugin-scan_release"})
public final class ScanUITopOpButtonComponent extends RelativeLayout {
    public static final a CPi = new a((byte) 0);
    private View CPe;
    ImageView CPf;
    public TextView CPg;
    private ImageView CPh;

    static {
        AppMethodBeat.i(240589);
        AppMethodBeat.o(240589);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/component/ScanUITopOpButtonComponent$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ TextView a(ScanUITopOpButtonComponent scanUITopOpButtonComponent) {
        AppMethodBeat.i(240590);
        TextView textView = scanUITopOpButtonComponent.CPg;
        if (textView == null) {
            p.btv("cancelButton");
        }
        AppMethodBeat.o(240590);
        return textView;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanUITopOpButtonComponent(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(240587);
        AppMethodBeat.o(240587);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanUITopOpButtonComponent(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(240588);
        View inflate = LayoutInflater.from(context).inflate(R.layout.az8, this);
        View findViewById = inflate.findViewById(R.id.isp);
        p.g(findViewById, "view.findViewById(R.id.top_button_container)");
        this.CPe = findViewById;
        View findViewById2 = inflate.findViewById(R.id.b47);
        p.g(findViewById2, "view.findViewById(R.id.close_button)");
        this.CPf = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.aic);
        p.g(findViewById3, "view.findViewById(R.id.cancel_button)");
        this.CPg = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.fjz);
        p.g(findViewById4, "view.findViewById(R.id.more_button)");
        this.CPh = (ImageView) findViewById4;
        AppMethodBeat.o(240588);
    }

    public final void setOnCloseClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(240579);
        p.h(onClickListener, "onClickListener");
        ImageView imageView = this.CPf;
        if (imageView == null) {
            p.btv("closeButton");
        }
        imageView.setOnClickListener(onClickListener);
        AppMethodBeat.o(240579);
    }

    public final void setOnCancelClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(240580);
        p.h(onClickListener, "onClickListener");
        TextView textView = this.CPg;
        if (textView == null) {
            p.btv("cancelButton");
        }
        textView.setOnClickListener(onClickListener);
        AppMethodBeat.o(240580);
    }

    public final void setOnMoreClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(240581);
        p.h(onClickListener, "onClickListener");
        ImageView imageView = this.CPh;
        if (imageView == null) {
            p.btv("moreButton");
        }
        imageView.setOnClickListener(onClickListener);
        AppMethodBeat.o(240581);
    }

    public final void setShowMoreButton(boolean z) {
        AppMethodBeat.i(240582);
        ImageView imageView = this.CPh;
        if (imageView == null) {
            p.btv("moreButton");
        }
        imageView.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(240582);
    }

    public final void tZ(boolean z) {
        AppMethodBeat.i(240583);
        ImageView imageView = this.CPh;
        if (imageView == null) {
            p.btv("moreButton");
        }
        m.a(imageView, z, null);
        AppMethodBeat.o(240583);
    }

    public final void ua(boolean z) {
        AppMethodBeat.i(240584);
        m.a(this, z, null);
        AppMethodBeat.o(240584);
    }

    public final void b(boolean z, Animator.AnimatorListener animatorListener) {
        AppMethodBeat.i(240585);
        Log.v("MicroMsg.ScanUITopButtonComponent", "alvinluo switchCloseView showCancelButton: %b", Boolean.valueOf(z));
        if (z) {
            ImageView imageView = this.CPf;
            if (imageView == null) {
                p.btv("closeButton");
            }
            m.a(imageView, false, new b(this, animatorListener));
            AppMethodBeat.o(240585);
            return;
        }
        TextView textView = this.CPg;
        if (textView == null) {
            p.btv("cancelButton");
        }
        m.a(textView, false, new c(this, animatorListener));
        AppMethodBeat.o(240585);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/scanner/ui/component/ScanUITopOpButtonComponent$switchCloseView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-scan_release"})
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ ScanUITopOpButtonComponent CPj;
        final /* synthetic */ Animator.AnimatorListener CPk;

        b(ScanUITopOpButtonComponent scanUITopOpButtonComponent, Animator.AnimatorListener animatorListener) {
            this.CPj = scanUITopOpButtonComponent;
            this.CPk = animatorListener;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(240577);
            p.h(animator, "animation");
            ScanUITopOpButtonComponent.a(this.CPj).setAlpha(0.0f);
            TextView textView = this.CPj.CPg;
            if (textView == null) {
                p.btv("cancelButton");
            }
            ScanUITopOpButtonComponent.eR(textView);
            Animator.AnimatorListener animatorListener = this.CPk;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
                AppMethodBeat.o(240577);
                return;
            }
            AppMethodBeat.o(240577);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/scanner/ui/component/ScanUITopOpButtonComponent$switchCloseView$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-scan_release"})
    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ ScanUITopOpButtonComponent CPj;
        final /* synthetic */ Animator.AnimatorListener CPk;

        c(ScanUITopOpButtonComponent scanUITopOpButtonComponent, Animator.AnimatorListener animatorListener) {
            this.CPj = scanUITopOpButtonComponent;
            this.CPk = animatorListener;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(240578);
            p.h(animator, "animation");
            ImageView imageView = this.CPj.CPf;
            if (imageView == null) {
                p.btv("closeButton");
            }
            ScanUITopOpButtonComponent.eR(imageView);
            Animator.AnimatorListener animatorListener = this.CPk;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
                AppMethodBeat.o(240578);
                return;
            }
            AppMethodBeat.o(240578);
        }
    }

    static void eR(View view) {
        AppMethodBeat.i(240586);
        m.a(view, true, null);
        AppMethodBeat.o(240586);
    }
}
