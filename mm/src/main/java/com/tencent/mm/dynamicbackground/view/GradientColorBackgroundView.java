package com.tencent.mm.dynamicbackground.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.dynamicbackground.a.a;
import com.tencent.mm.dynamicbackground.a.c;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 11}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0016\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tJ\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\tR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backGradient", "Landroid/graphics/LinearGradient;", "beginColor", "endColor", "mColorHelper", "Lcom/tencent/mm/dynamicbackground/util/DynamicBackgroundColorHelper;", "mConfigChanged", "", "mLastUpdateColorTime", "", "needUpdateColor", "paint", "Landroid/graphics/Paint;", "updateMode", "buildGradient", "", "needInvalidate", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onDraw", "canvas", "Landroid/graphics/Canvas;", "setColor", "colorStart", "colorEnd", "setUpdateMode", "Companion", "dynamicbg_release"})
public final class GradientColorBackgroundView extends View {
    public static final a gTc = new a((byte) 0);
    private int beginColor = -5778734;
    private int endColor = -14072734;
    private LinearGradient gSX;
    private boolean gSY;
    private com.tencent.mm.dynamicbackground.a.a gSZ = new com.tencent.mm.dynamicbackground.a.a();
    private long gTa = -1;
    private boolean gTb = true;
    private Paint paint = new Paint();
    private int updateMode;

    static {
        AppMethodBeat.i(103125);
        AppMethodBeat.o(103125);
    }

    @l(hxD = {1, 1, 11}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/dynamicbackground/view/GradientColorBackgroundView$Companion;", "", "()V", "TAG", "", "UPDATE_COLOR_MIN_TWEENS_IN_MS", "", "UPDATE_MODE_ANDROID", "UPDATE_MODE_NATIVE", "dynamicbg_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GradientColorBackgroundView(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(230550);
        init();
        AppMethodBeat.o(230550);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GradientColorBackgroundView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attributeSet");
        AppMethodBeat.i(103123);
        init();
        AppMethodBeat.o(103123);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GradientColorBackgroundView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attributeSet");
        AppMethodBeat.i(103124);
        init();
        AppMethodBeat.o(103124);
    }

    @l(hxD = {1, 1, 11}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ GradientColorBackgroundView gTd;
        final /* synthetic */ int gTe;
        final /* synthetic */ int gTf;

        b(GradientColorBackgroundView gradientColorBackgroundView, int i2, int i3) {
            this.gTd = gradientColorBackgroundView;
            this.gTe = i2;
            this.gTf = i3;
        }

        public final void run() {
            AppMethodBeat.i(230547);
            this.gTd.beginColor = this.gTe;
            this.gTd.endColor = this.gTf;
            this.gTd.gTb = true;
            AppMethodBeat.o(230547);
        }
    }

    public final void setColor(int i2, int i3) {
        AppMethodBeat.i(230548);
        post(new b(this, i2, i3));
        AppMethodBeat.o(230548);
    }

    private final void init() {
        AppMethodBeat.i(103119);
        this.updateMode = 1;
        if (this.gSY) {
            this.gSZ.atO();
            a.c cVar = com.tencent.mm.dynamicbackground.a.a.gRm;
            this.beginColor = a.c.j(this.gSZ.gRk.gRr);
            a.c cVar2 = com.tencent.mm.dynamicbackground.a.a.gRm;
            this.endColor = a.c.j(this.gSZ.gRk.gRs);
            AppMethodBeat.o(103119);
            return;
        }
        Context context = getContext();
        p.g(context, "context");
        this.beginColor = context.getResources().getColor(R.color.mi);
        Context context2 = getContext();
        p.g(context2, "context");
        this.endColor = context2.getResources().getColor(R.color.mh);
        AppMethodBeat.o(103119);
    }

    public final void setUpdateMode(int i2) {
        AppMethodBeat.i(103120);
        c.i("MicroMsg.GradientColorBackgroundView", "alvinluo setUpdateMode: %d", Integer.valueOf(i2));
        if (this.updateMode != i2) {
            this.updateMode = i2;
            this.gTa = -1;
            if (this.gSY) {
                this.gSX = null;
                AppMethodBeat.o(103120);
                return;
            }
            dL(true);
        }
        AppMethodBeat.o(103120);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(103121);
        super.onDraw(canvas);
        if (this.updateMode == 1) {
            if (this.gSY && (this.gTa == -1 || System.currentTimeMillis() - this.gTa >= Util.MILLSECONDS_OF_MINUTE)) {
                this.gTa = System.currentTimeMillis();
                this.gSZ.atO();
                a.c cVar = com.tencent.mm.dynamicbackground.a.a.gRm;
                this.beginColor = a.c.j(this.gSZ.gRk.gRr);
                a.c cVar2 = com.tencent.mm.dynamicbackground.a.a.gRm;
                this.endColor = a.c.j(this.gSZ.gRk.gRs);
                dL(false);
            } else if (!this.gSY && this.gTb) {
                dL(true);
            }
        } else if (this.gTb) {
            dL(true);
        }
        if (canvas != null) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.paint);
            AppMethodBeat.o(103121);
            return;
        }
        AppMethodBeat.o(103121);
    }

    private final void dL(boolean z) {
        AppMethodBeat.i(230549);
        this.gSX = new LinearGradient(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.beginColor, this.endColor, Shader.TileMode.CLAMP);
        this.paint.setShader(this.gSX);
        if (z) {
            invalidate();
        }
        this.gTb = false;
        AppMethodBeat.o(230549);
    }
}
