package com.tencent.mm.z;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.a;

public final class b implements Cloneable {
    private static Paint hog;
    private float dhh = 1.0f;
    public int mColor;
    private float mStrokeWidth = ((float) a.ao(5.0f));
    private Path xT;

    static {
        AppMethodBeat.i(9248);
        Paint paint = new Paint();
        hog = paint;
        paint.setAntiAlias(true);
        hog.setStyle(Paint.Style.STROKE);
        hog.setStrokeCap(Paint.Cap.ROUND);
        AppMethodBeat.o(9248);
    }

    public b(Path path, float f2, int i2) {
        AppMethodBeat.i(9246);
        this.xT = path;
        this.dhh = f2;
        this.mColor = i2;
        AppMethodBeat.o(9246);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(9247);
        hog.setColor(this.mColor);
        hog.setStrokeWidth(this.mStrokeWidth * this.dhh);
        if (!this.xT.isEmpty()) {
            canvas.drawPath(this.xT, hog);
        }
        AppMethodBeat.o(9247);
    }
}
