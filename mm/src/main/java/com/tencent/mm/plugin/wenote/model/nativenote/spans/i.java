package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;

public final class i extends ArrowKeyMovementMethod {
    private static i JIW;

    public static i gka() {
        AppMethodBeat.i(30637);
        if (JIW == null) {
            JIW = new i();
        }
        i iVar = JIW;
        AppMethodBeat.o(30637);
        return iVar;
    }

    public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        AppMethodBeat.i(30638);
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = textView.getScrollX() + x;
            int scrollY = textView.getScrollY() + y;
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            k[] kVarArr = (k[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal + 1, k.class);
            if (scrollX < b.cDE() && kVarArr.length != 0) {
                if (action == 0) {
                    kVarArr[0].a(textView, spannable, motionEvent, kVarArr[0]);
                }
                AppMethodBeat.o(30638);
                return false;
            }
        }
        AppMethodBeat.o(30638);
        return false;
    }
}
