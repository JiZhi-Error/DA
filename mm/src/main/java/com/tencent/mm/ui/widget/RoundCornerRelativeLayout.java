package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.ae.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J0\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0014J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eJ&\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerRadius", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout$CornerRadius;", "path", "Landroid/graphics/Path;", "draw", "", "canvas", "Landroid/graphics/Canvas;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onLayout", "changed", "", "left", "top", "right", "bottom", "resetPath", "setRadius", "radius", "", "topLeft", "topRight", "bottomLeft", "bottomRight", "CornerRadius", "libmmui_release"})
public final class RoundCornerRelativeLayout extends RelativeLayout {
    private a QEU;
    private Path lR = new Path();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(204891);
        c(context, attributeSet, 0);
        AppMethodBeat.o(204891);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(204892);
        c(context, attributeSet, i2);
        AppMethodBeat.o(204892);
    }

    private final void c(Context context, AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(204885);
        float dimension = context.obtainStyledAttributes(attributeSet, a.C0244a.RoundedCornerFrameLayout, i2, 0).getDimension(0, 0.0f);
        this.QEU = new a(dimension, dimension, dimension, dimension);
        setWillNotDraw(false);
        AppMethodBeat.o(204885);
    }

    public final void setRadius(float f2) {
        AppMethodBeat.i(204886);
        s(f2, f2, f2, f2);
        AppMethodBeat.o(204886);
    }

    public final void s(float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(204887);
        a aVar = this.QEU;
        if (aVar == null) {
            p.hyc();
        }
        aVar.QEV = f2;
        a aVar2 = this.QEU;
        if (aVar2 == null) {
            p.hyc();
        }
        aVar2.QEW = f3;
        a aVar3 = this.QEU;
        if (aVar3 == null) {
            p.hyc();
        }
        aVar3.QEX = f4;
        a aVar4 = this.QEU;
        if (aVar4 == null) {
            p.hyc();
        }
        aVar4.QEY = f5;
        gZg();
        postInvalidate();
        AppMethodBeat.o(204887);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(204888);
        super.onLayout(z, i2, i3, i4, i5);
        gZg();
        AppMethodBeat.o(204888);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(204889);
        p.h(canvas, "canvas");
        if (this.lR.isEmpty()) {
            gZg();
        }
        int save = canvas.save();
        canvas.clipPath(this.lR);
        super.draw(canvas);
        canvas.restoreToCount(save);
        AppMethodBeat.o(204889);
    }

    private final void gZg() {
        a aVar;
        AppMethodBeat.i(204890);
        if (getWidth() <= 0 || getHeight() <= 0 || (aVar = this.QEU) == null) {
            AppMethodBeat.o(204890);
            return;
        }
        this.lR.reset();
        this.lR.addRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), new float[]{aVar.QEV, aVar.QEV, aVar.QEW, aVar.QEW, aVar.QEY, aVar.QEY, aVar.QEX, aVar.QEX}, Path.Direction.CCW);
        this.lR.close();
        AppMethodBeat.o(204890);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout$CornerRadius;", "", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "(FFFF)V", "getBottomLeft", "()F", "setBottomLeft", "(F)V", "getBottomRight", "setBottomRight", "getTopLeft", "setTopLeft", "getTopRight", "setTopRight", "libmmui_release"})
    public static final class a {
        float QEV;
        float QEW;
        float QEX;
        float QEY;

        public a(float f2, float f3, float f4, float f5) {
            this.QEV = f2;
            this.QEW = f3;
            this.QEX = f4;
            this.QEY = f5;
        }
    }
}
