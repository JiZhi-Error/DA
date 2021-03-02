package com.tencent.mm.plugin.remittance.ui;

import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements View.OnTouchListener {
    private RunnableC1659a Cqq;

    public static a eNB() {
        AppMethodBeat.i(67915);
        a aVar = new a();
        AppMethodBeat.o(67915);
        return aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(67916);
        if (this.Cqq == null) {
            this.Cqq = new RunnableC1659a(view);
        }
        TextView textView = (TextView) view;
        textView.setMovementMethod(null);
        Spannable newSpannable = Spannable.Factory.getInstance().newSpannable(textView.getText());
        int action = motionEvent.getAction();
        if (action == 0 || action == 1) {
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x + textView.getScrollX();
            int scrollY = y + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) newSpannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (clickableSpanArr.length != 0) {
                if (action == 0) {
                    view.postDelayed(this.Cqq, (long) ViewConfiguration.getLongPressTimeout());
                } else {
                    view.removeCallbacks(this.Cqq);
                    clickableSpanArr[0].onClick(textView);
                }
                AppMethodBeat.o(67916);
                return true;
            }
        } else if (action == 3) {
            view.removeCallbacks(this.Cqq);
        }
        AppMethodBeat.o(67916);
        return false;
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.a$a  reason: collision with other inner class name */
    static class RunnableC1659a implements Runnable {
        private View view;

        RunnableC1659a(View view2) {
            this.view = view2;
        }

        public final void run() {
            AppMethodBeat.i(67914);
            View view2 = this.view;
            boolean performLongClick = view2.performLongClick();
            while (!performLongClick) {
                View view3 = (View) view2.getParent();
                if (view3 == null) {
                    break;
                }
                performLongClick = view3.performLongClick();
                view2 = view3;
            }
            AppMethodBeat.o(67914);
        }
    }
}
