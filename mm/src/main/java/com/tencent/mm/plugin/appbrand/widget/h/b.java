package com.tencent.mm.plugin.appbrand.widget.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a;

public final class b extends a {
    public b(Drawable drawable) {
        super(drawable, 1);
    }

    @Override // com.tencent.mm.ui.widget.a
    public final void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        AppMethodBeat.i(50022);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        super.draw(canvas, charSequence, i2, i3, f2, i4, i5, i6, paint);
        AppMethodBeat.o(50022);
    }
}
