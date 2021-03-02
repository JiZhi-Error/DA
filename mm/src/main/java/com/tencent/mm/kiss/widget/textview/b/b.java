package com.tencent.mm.kiss.widget.textview.b;

import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a;

public final class b {
    private static b hvb;
    private static Object hvc = new NoCopySpan.Concrete();

    public static boolean a(View view, Layout layout, Spannable spannable, MotionEvent motionEvent) {
        AppMethodBeat.i(141140);
        int action = motionEvent.getAction();
        if (!(view instanceof a)) {
            AppMethodBeat.o(141140);
            return false;
        }
        a aVar = (a) view;
        if (action == 1 || action == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (x < aVar.getHorizontalDrawOffset() || x > layout.getWidth() + aVar.getHorizontalDrawOffset()) {
                AppMethodBeat.o(141140);
                return false;
            } else if (y < aVar.getVerticalDrawOffset() || y > layout.getHeight() + aVar.getVerticalDrawOffset()) {
                AppMethodBeat.o(141140);
                return false;
            } else {
                int horizontalDrawOffset = x - aVar.getHorizontalDrawOffset();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((y - aVar.getVerticalDrawOffset()) + aVar.getScrollY()), (float) (horizontalDrawOffset + aVar.getScrollX()));
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr.length == 0) {
                    Selection.removeSelection(spannable);
                } else if (action == 1) {
                    AppMethodBeat.o(141140);
                    return true;
                } else {
                    Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                    AppMethodBeat.o(141140);
                    return true;
                }
            }
        }
        AppMethodBeat.o(141140);
        return false;
    }

    public static void a(Spannable spannable) {
        AppMethodBeat.i(141141);
        Selection.removeSelection(spannable);
        spannable.removeSpan(hvc);
        AppMethodBeat.o(141141);
    }

    public static b aBv() {
        AppMethodBeat.i(141142);
        if (hvb == null) {
            hvb = new b();
        }
        b bVar = hvb;
        AppMethodBeat.o(141142);
        return bVar;
    }

    static {
        AppMethodBeat.i(141143);
        AppMethodBeat.o(141143);
    }
}
