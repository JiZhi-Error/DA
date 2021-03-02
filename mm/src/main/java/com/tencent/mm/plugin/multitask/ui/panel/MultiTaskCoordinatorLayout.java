package com.tencent.mm.plugin.multitask.ui.panel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.ui.at;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J0\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0014J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\tH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskCoordinatorLayout;", "Landroid/support/design/widget/CoordinatorLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerBitmap", "Landroid/graphics/Bitmap;", "cornorRadius", "paint", "Landroid/graphics/Paint;", "pathPaint", "rect", "Landroid/graphics/RectF;", "createCornerBitmap", "width", "height", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "l", "t", "r", "b", "setMode", "mode", "Companion", "ui-multitask_release"})
public final class MultiTaskCoordinatorLayout extends CoordinatorLayout {
    private static final int Afe = 0;
    private static final int Aff = 1;
    public static final a Afg = new a((byte) 0);
    private static final int MODE_DEFAULT = -1;
    private static int mMode = MODE_DEFAULT;
    private Paint Afb = new Paint(1);
    private int Afc = at.fromDPToPix(getContext(), 8);
    private Bitmap Afd;
    private final RectF cuN = new RectF();
    private Paint paint = new Paint(1);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTaskCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(236592);
        this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        setWillNotDraw(false);
        AppMethodBeat.o(236592);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTaskCoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(236593);
        this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        setWillNotDraw(false);
        AppMethodBeat.o(236593);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskCoordinatorLayout$Companion;", "", "()V", "MODE_DEFAULT", "", "getMODE_DEFAULT", "()I", "MODE_ONE", "getMODE_ONE", "MODE_TWO", "getMODE_TWO", "mMode", "getMMode", "setMMode", "(I)V", "ui-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(236594);
        AppMethodBeat.o(236594);
    }

    @Override // android.support.design.widget.CoordinatorLayout
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(236589);
        super.onLayout(z, i2, i3, i4, i5);
        this.Afd = null;
        AppMethodBeat.o(236589);
    }

    public final void setMode(int i2) {
        AppMethodBeat.i(236590);
        if (mMode == i2) {
            AppMethodBeat.o(236590);
            return;
        }
        mMode = i2;
        if (this.Afd != null) {
            this.Afd = null;
            postInvalidate();
        }
        AppMethodBeat.o(236590);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(236591);
        p.h(canvas, "canvas");
        if (canvas.getWidth() <= 0 || canvas.getHeight() <= 0) {
            AppMethodBeat.o(236591);
            return;
        }
        int saveLayer = canvas.saveLayer(new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight()), null, 31);
        super.draw(canvas);
        if (this.Afd == null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ALPHA_8);
            Canvas canvas2 = new Canvas(createBitmap);
            Path path = new Path();
            this.cuN.set(0.0f, ((float) this.Afc) * 2.0f, (float) width, (float) height);
            path.addRect(this.cuN, Path.Direction.CCW);
            if (mMode == Afe) {
                Path path2 = new Path();
                MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
                int i2 = MultiTaskUIC.Agc;
                float f2 = ((float) (width - i2)) / 2.0f;
                this.cuN.set(f2, 0.0f, ((float) i2) + f2, ((float) this.Afc) * 4.0f);
                path2.addRoundRect(this.cuN, (float) this.Afc, (float) this.Afc, Path.Direction.CCW);
                path.op(path2, Path.Op.UNION);
            } else if (mMode == Aff) {
                MultiTaskUIC.a aVar2 = MultiTaskUIC.Ago;
                float f3 = ((float) MultiTaskUIC.AfX) + 0.0f;
                MultiTaskUIC.a aVar3 = MultiTaskUIC.Ago;
                float f4 = ((float) MultiTaskUIC.Aga) + 0.0f;
                Path path3 = new Path();
                this.cuN.set((((float) width) - f3) - f4, 0.0f, ((float) width) - f3, ((float) this.Afc) * 4.0f);
                path3.addRoundRect(this.cuN, (float) this.Afc, (float) this.Afc, Path.Direction.CCW);
                path.op(path3, Path.Op.UNION);
                MultiTaskUIC.a aVar4 = MultiTaskUIC.Ago;
                float f5 = ((float) MultiTaskUIC.AfX) + 0.0f;
                this.cuN.set(f5, 0.0f, f4 + f5, ((float) this.Afc) * 4.0f);
                Path path4 = new Path();
                path4.addRoundRect(this.cuN, (float) this.Afc, (float) this.Afc, Path.Direction.CW);
                path.op(path4, Path.Op.UNION);
            }
            path.setFillType(Path.FillType.WINDING);
            canvas2.drawPath(path, this.Afb);
            p.g(createBitmap, "bitmap");
            this.Afd = createBitmap;
        }
        Bitmap bitmap = this.Afd;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.paint);
        }
        canvas.restoreToCount(saveLayer);
        AppMethodBeat.o(236591);
    }
}
