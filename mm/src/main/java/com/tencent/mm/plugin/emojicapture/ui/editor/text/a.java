package com.tencent.mm.plugin.emojicapture.ui.editor.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.ui.editor.text.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J@\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/DefaultTextDrawer;", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "()V", "text", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "switchFont", "fontName", "", "plugin-emojicapture_release"})
public final class a implements c {
    private CharSequence text;

    @Override // com.tencent.mm.plugin.emojicapture.ui.editor.text.c
    public final void setText(CharSequence charSequence) {
        AppMethodBeat.i(807);
        p.h(charSequence, "text");
        this.text = charSequence;
        AppMethodBeat.o(807);
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.editor.text.c
    public final void refresh() {
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.editor.text.c
    public final void anr(String str) {
        AppMethodBeat.i(808);
        p.h(str, "fontName");
        AppMethodBeat.o(808);
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.editor.text.c
    public final void a(Canvas canvas, int i2, int i3, float f2, float f3, Paint paint, boolean z) {
        AppMethodBeat.i(809);
        p.h(canvas, "canvas");
        p.h(paint, "paint");
        if (this.text == null) {
            AppMethodBeat.o(809);
            return;
        }
        CharSequence charSequence = this.text;
        if (charSequence == null) {
            p.hyc();
        }
        canvas.drawText(charSequence, i2, i3, f2, f3, paint);
        if (z) {
            canvas.drawText(c.a.cJS(), paint.measureText(this.text, i2, i3) + f2, f3, paint);
        }
        AppMethodBeat.o(809);
    }
}
