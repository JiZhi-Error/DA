package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0012\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "Landroid/graphics/drawable/Drawable;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "basicScale", "", "framePadding", "frameRect", "frameStroke", "paint", "Landroid/graphics/Paint;", "getResources", "()Landroid/content/res/Resources;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "plugin-recordvideo_release"})
public final class a extends Drawable {
    private final Resources aKy;
    private final Paint paint = new Paint();
    private float rqZ = 2.0f;
    private final float rra;
    private final float rrb;
    private final float rrc;

    public a(Resources resources) {
        p.h(resources, "resources");
        AppMethodBeat.i(237952);
        this.aKy = resources;
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(this.aKy.getDimension(R.dimen.a1e));
        this.paint.setStyle(Paint.Style.FILL);
        this.rra = this.aKy.getDimension(R.dimen.a1e);
        this.rrb = this.aKy.getDimension(R.dimen.a1c);
        this.rrc = this.aKy.getDimension(R.dimen.a1d);
        AppMethodBeat.o(237952);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(237951);
        p.h(canvas, "canvas");
        float f2 = ((float) getBounds().left) - (this.rrb / this.rqZ);
        float f3 = ((float) getBounds().top) - (this.rrb / this.rqZ);
        float f4 = ((float) getBounds().right) + (this.rrb / this.rqZ);
        float f5 = ((float) getBounds().bottom) + (this.rrb / this.rqZ);
        this.paint.setStrokeWidth(this.rra / this.rqZ);
        this.paint.setAntiAlias(true);
        canvas.drawLines(new float[]{f2, f3, f4, f3, f4, f3, f4, f5, f4, f5, f2, f5, f2, f5, f2, f3}, this.paint);
        AppMethodBeat.o(237951);
    }

    public final void setAlpha(int i2) {
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
