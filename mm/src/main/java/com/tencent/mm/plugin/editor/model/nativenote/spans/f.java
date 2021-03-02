package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f extends ArrowKeyMovementMethod {
    private static f qTf;

    public static f cEv() {
        AppMethodBeat.i(181935);
        if (qTf == null) {
            qTf = new f();
        }
        f fVar = qTf;
        AppMethodBeat.o(181935);
        return fVar;
    }

    public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        AppMethodBeat.i(181936);
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = textView.getScrollX() + x;
            int scrollY = textView.getScrollY() + y;
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            s[] sVarArr = (s[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal + 1, s.class);
            if (scrollX < com.tencent.mm.plugin.editor.model.nativenote.manager.f.cDE() && sVarArr.length != 0) {
                if (action == 0) {
                    sVarArr[0].a(textView, spannable, motionEvent, sVarArr[0]);
                }
                AppMethodBeat.o(181936);
                return false;
            }
        }
        AppMethodBeat.o(181936);
        return false;
    }
}
