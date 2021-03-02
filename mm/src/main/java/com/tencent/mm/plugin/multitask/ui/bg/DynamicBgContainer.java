package com.tencent.mm.plugin.multitask.ui.bg;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitask.ui.bg.a;
import com.tencent.mm.plugin.taskbar.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 -2\u00020\u0001:\u0001-B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020$J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0007H\u0016J\u0006\u0010)\u001a\u00020\u001eJ\u0006\u0010*\u001a\u00020$J\u0006\u0010+\u001a\u00020$J\u0006\u0010,\u001a\u00020$R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomGradientBgView", "Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "getBottomGradientBgView", "()Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "<set-?>", "Lcom/tencent/mm/plugin/multitask/ui/bg/MultiTaskViewBgParticleColorConfig;", "colorConfig", "getColorConfig", "()Lcom/tencent/mm/plugin/multitask/ui/bg/MultiTaskViewBgParticleColorConfig;", "dynamicBgSurfaceView", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;", "getDynamicBgSurfaceView", "()Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;", "setDynamicBgSurfaceView", "(Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;)V", "value", "gradientBgView", "getGradientBgView", "setGradientBgView", "(Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;)V", "released", "", "getReleased", "()Z", "setReleased", "(Z)V", "activeDynamicBg", "", "release", "removeDynamicBg", "setVisibility", "visibility", "shouldFixStatusBar", "stopDynamicBg", "tryFixStatusBar", "updateBgColorConfig", "Companion", "plugin-multitask_release"})
public final class DynamicBgContainer extends FrameLayout {
    public static final a AdD = new a((byte) 0);
    private a AdA;
    private GradientColorBackgroundView AdB;
    private final GradientColorBackgroundView AdC;
    private DynamicBackgroundGLSurfaceView Adz;
    private boolean released;

    static {
        AppMethodBeat.i(200778);
        AppMethodBeat.o(200778);
    }

    public DynamicBgContainer(Context context) {
        this(context, null, 6, (byte) 0);
    }

    public DynamicBgContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, (byte) 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private /* synthetic */ DynamicBgContainer(Context context, AttributeSet attributeSet, int i2, byte b2) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, 0);
        AppMethodBeat.i(200777);
        AppMethodBeat.o(200777);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicBgContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(200776);
        a.C1523a aVar = a.AdG;
        this.AdA = a.C1523a.erA();
        Context context2 = getContext();
        p.g(context2, "getContext()");
        this.AdC = new GradientColorBackgroundView(context2);
        addView(this.AdC, 0, new FrameLayout.LayoutParams(-1, -1));
        c cVar = (c) g.af(c.class);
        if (cVar != null) {
            cVar.fuu();
            AppMethodBeat.o(200776);
            return;
        }
        AppMethodBeat.o(200776);
    }

    public final boolean getReleased() {
        return this.released;
    }

    public final void setReleased(boolean z) {
        this.released = z;
    }

    public final DynamicBackgroundGLSurfaceView getDynamicBgSurfaceView() {
        return this.Adz;
    }

    public final void setDynamicBgSurfaceView(DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView) {
        this.Adz = dynamicBackgroundGLSurfaceView;
    }

    public final a getColorConfig() {
        return this.AdA;
    }

    public final GradientColorBackgroundView getGradientBgView() {
        return this.AdB;
    }

    public final void setGradientBgView(GradientColorBackgroundView gradientColorBackgroundView) {
        AppMethodBeat.i(200769);
        this.AdB = gradientColorBackgroundView;
        erx();
        AppMethodBeat.o(200769);
    }

    public final GradientColorBackgroundView getBottomGradientBgView() {
        return this.AdC;
    }

    public final void erv() {
        AppMethodBeat.i(200770);
        if (!erw()) {
            AppMethodBeat.o(200770);
            return;
        }
        setVisibility(4);
        GradientColorBackgroundView gradientColorBackgroundView = this.AdB;
        if (gradientColorBackgroundView != null) {
            gradientColorBackgroundView.setVisibility(4);
            AppMethodBeat.o(200770);
            return;
        }
        AppMethodBeat.o(200770);
    }

    public static boolean erw() {
        AppMethodBeat.i(200771);
        if (Build.VERSION.SDK_INT >= 23 && !com.tencent.mm.compatible.util.g.isMIUIV8()) {
            AppMethodBeat.o(200771);
            return false;
        } else if (Build.VERSION.SDK_INT >= 21) {
            AppMethodBeat.o(200771);
            return true;
        } else {
            AppMethodBeat.o(200771);
            return false;
        }
    }

    public final void erx() {
        AppMethodBeat.i(200772);
        a.C1523a aVar = a.AdG;
        this.AdA = a.C1523a.erA();
        DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView = this.Adz;
        if (dynamicBackgroundGLSurfaceView != null) {
            dynamicBackgroundGLSurfaceView.setColor(this.AdA.gRQ, this.AdA.gRR, this.AdA.gRS, this.AdA.gRT, this.AdA.gRU);
        }
        GradientColorBackgroundView gradientColorBackgroundView = this.AdB;
        if (gradientColorBackgroundView != null) {
            gradientColorBackgroundView.setColor(this.AdA.gRT, this.AdA.gRU);
        }
        GradientColorBackgroundView gradientColorBackgroundView2 = this.AdB;
        if (gradientColorBackgroundView2 != null) {
            gradientColorBackgroundView2.setUpdateMode(1);
        }
        this.AdC.setColor(this.AdA.gRT, this.AdA.gRU);
        this.AdC.setUpdateMode(1);
        AppMethodBeat.o(200772);
    }

    public final void setVisibility(int i2) {
        AppMethodBeat.i(200773);
        super.setVisibility(i2);
        Log.i("MicroMsg.DynamicBgContainer", "virbg: set visibility ".concat(String.valueOf(i2)));
        AppMethodBeat.o(200773);
    }

    private void hWp() {
        AppMethodBeat.i(259534);
        if (this.Adz != null) {
            Log.i("MicroMsg.DynamicBgContainer", "removed");
            removeView(this.Adz);
            this.Adz = null;
        }
        AppMethodBeat.o(259534);
    }

    public final void ery() {
        AppMethodBeat.i(200774);
        GradientColorBackgroundView gradientColorBackgroundView = this.AdB;
        if (gradientColorBackgroundView != null) {
            gradientColorBackgroundView.setVisibility(0);
        }
        GradientColorBackgroundView gradientColorBackgroundView2 = this.AdB;
        if (gradientColorBackgroundView2 != null) {
            gradientColorBackgroundView2.setAlpha(1.0f);
        }
        DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView = this.Adz;
        if (dynamicBackgroundGLSurfaceView != null) {
            Log.i("MicroMsg.DynamicBgContainer", "stop dynamicBg");
            dynamicBackgroundGLSurfaceView.onPause();
            dynamicBackgroundGLSurfaceView.setVisibility(8);
            AppMethodBeat.o(200774);
            return;
        }
        AppMethodBeat.o(200774);
    }

    public final void erz() {
        AppMethodBeat.i(200775);
        if (this.released) {
            AppMethodBeat.o(200775);
            return;
        }
        setVisibility(0);
        GradientColorBackgroundView gradientColorBackgroundView = this.AdB;
        if (gradientColorBackgroundView != null) {
            gradientColorBackgroundView.setVisibility(0);
        }
        GradientColorBackgroundView gradientColorBackgroundView2 = this.AdB;
        if (gradientColorBackgroundView2 != null) {
            gradientColorBackgroundView2.setAlpha(1.0f);
        }
        if (this.Adz != null) {
            Log.i("MicroMsg.DynamicBgContainer", "re activeDynamicBg");
            DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView = this.Adz;
            if (dynamicBackgroundGLSurfaceView != null) {
                GradientColorBackgroundView gradientColorBackgroundView3 = this.AdB;
                if (gradientColorBackgroundView3 == null) {
                    p.hyc();
                }
                dynamicBackgroundGLSurfaceView.setGradientBackgroundView(gradientColorBackgroundView3);
            }
            DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView2 = this.Adz;
            if (dynamicBackgroundGLSurfaceView2 != null) {
                dynamicBackgroundGLSurfaceView2.setShowGradientView(false);
            }
            DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView3 = this.Adz;
            if (dynamicBackgroundGLSurfaceView3 != null) {
                dynamicBackgroundGLSurfaceView3.setVisibility(0);
            }
            DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView4 = this.Adz;
            if (dynamicBackgroundGLSurfaceView4 != null) {
                dynamicBackgroundGLSurfaceView4.onResume();
                AppMethodBeat.o(200775);
                return;
            }
            AppMethodBeat.o(200775);
            return;
        }
        c cVar = (c) g.af(c.class);
        if (cVar == null) {
            Log.e("MicroMsg.DynamicBgContainer", "addDynamicBackgroundView service is null");
            AppMethodBeat.o(200775);
            return;
        }
        if (cVar.fuv()) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.Adz = (DynamicBackgroundGLSurfaceView) cVar.ho(getContext());
            DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView5 = this.Adz;
            DynamicBgContainer dynamicBgContainer = (DynamicBgContainer) (dynamicBackgroundGLSurfaceView5 != null ? dynamicBackgroundGLSurfaceView5.getParent() : null);
            if (dynamicBgContainer != null) {
                dynamicBgContainer.hWp();
            }
            addView(this.Adz, layoutParams);
            DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView6 = this.Adz;
            if (dynamicBackgroundGLSurfaceView6 != null) {
                GradientColorBackgroundView gradientColorBackgroundView4 = this.AdB;
                if (gradientColorBackgroundView4 == null) {
                    p.hyc();
                }
                dynamicBackgroundGLSurfaceView6.setGradientBackgroundView(gradientColorBackgroundView4);
            }
            DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView7 = this.Adz;
            if (dynamicBackgroundGLSurfaceView7 != null) {
                dynamicBackgroundGLSurfaceView7.setShowGradientView(false);
            }
            DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView8 = this.Adz;
            if (dynamicBackgroundGLSurfaceView8 != null) {
                dynamicBackgroundGLSurfaceView8.setVisibility(0);
            }
            DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView9 = this.Adz;
            if (dynamicBackgroundGLSurfaceView9 != null) {
                dynamicBackgroundGLSurfaceView9.onResume();
            }
            Log.i("MicroMsg.DynamicBgContainer", "virbg: added");
        }
        AppMethodBeat.o(200775);
    }

    public final void release() {
        AppMethodBeat.i(259535);
        Log.i("MicroMsg.DynamicBgContainer", "release");
        this.released = true;
        hWp();
        AppMethodBeat.o(259535);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/bg/DynamicBgContainer$Companion;", "", "()V", "TAG", "", "plugin-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
