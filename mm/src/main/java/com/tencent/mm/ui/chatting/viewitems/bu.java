package com.tencent.mm.ui.chatting.viewitems;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.span.a;

final class bu extends LinkMovementMethod {
    private a PQT;

    public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        AppMethodBeat.i(37562);
        if (motionEvent.getAction() == 0) {
            this.PQT = a(textView, spannable, motionEvent);
            if (this.PQT != null) {
                this.PQT.setIsPressed(true);
                Selection.setSelection(spannable, spannable.getSpanStart(this.PQT), spannable.getSpanEnd(this.PQT));
            }
        } else if (motionEvent.getAction() == 2) {
            a a2 = a(textView, spannable, motionEvent);
            if (!(this.PQT == null || a2 == this.PQT)) {
                this.PQT.setIsPressed(false);
                this.PQT = null;
                Selection.removeSelection(spannable);
            }
        } else {
            if (this.PQT != null) {
                this.PQT.setIsPressed(false);
                super.onTouchEvent(textView, spannable, motionEvent);
            }
            this.PQT = null;
            Selection.removeSelection(spannable);
        }
        AppMethodBeat.o(37562);
        return true;
    }

    private static a a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        a aVar;
        AppMethodBeat.i(37563);
        int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
        int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
        int scrollX = x + textView.getScrollX();
        int scrollY = y + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
        a[] aVarArr = (a[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, a.class);
        if (aVarArr.length > 0) {
            aVar = aVarArr[0];
        } else {
            aVar = null;
        }
        AppMethodBeat.o(37563);
        return aVar;
    }
}
