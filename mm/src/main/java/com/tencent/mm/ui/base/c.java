package com.tencent.mm.ui.base;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LineBackgroundSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.textview.b;
import com.tencent.neattextview.textview.layout.a;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class c implements LineBackgroundSpan {
    private View ONY;
    private final int color;
    private int end;
    private Rect rect = new Rect();
    private int start;

    public c(View view, int i2, int i3, int i4) {
        AppMethodBeat.i(159148);
        this.ONY = view;
        this.color = i2;
        this.start = i3;
        this.end = i4;
        AppMethodBeat.o(159148);
    }

    public final void setPosition(int i2, int i3) {
        this.start = i2;
        this.end = i3;
    }

    public final void drawBackground(Canvas canvas, Paint paint, int i2, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, int i9) {
        float f2;
        Layout layout;
        AppMethodBeat.i(159149);
        if (this.end < i7) {
            AppMethodBeat.o(159149);
        } else if (this.start > i8) {
            AppMethodBeat.o(159149);
        } else {
            int color2 = paint.getColor();
            int aQ = b.aQ(this.ONY, this.start);
            int aQ2 = b.aQ(this.ONY, this.end);
            if (aQ <= i9 && i9 <= aQ2) {
                if (aQ == i9) {
                    f2 = b.aR(this.ONY, this.start);
                } else {
                    View view = this.ONY;
                    if (view instanceof NeatTextView) {
                        a layout2 = ((NeatTextView) view).getLayout();
                        if (layout2 != null) {
                            f2 = layout2.getPrimaryHorizontal(layout2.getLineStart(i9));
                        }
                    } else if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
                        f2 = layout.getLineLeft(i9);
                    }
                    f2 = 0.0f;
                }
                i2 = (int) f2;
                if (aQ2 == i9) {
                    i3 = (int) b.aR(this.ONY, this.end);
                } else {
                    i3 = ((int) b.aU(this.ONY, i9)) + i2;
                }
            }
            int descent = (int) (((float) i5) + paint.descent());
            this.rect.left = i2;
            if (this.start == i7) {
                Rect rect2 = this.rect;
                rect2.left -= 4;
            }
            this.rect.right = i3;
            if (this.end == i3) {
                this.rect.right += 4;
            }
            this.rect.top = i4;
            this.rect.bottom = descent;
            paint.setColor(this.color);
            canvas.drawRect(this.rect, paint);
            paint.setColor(color2);
            AppMethodBeat.o(159149);
        }
    }
}
