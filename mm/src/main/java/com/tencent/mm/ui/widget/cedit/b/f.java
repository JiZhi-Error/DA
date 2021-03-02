package com.tencent.mm.ui.widget.cedit.b;

import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;

public final class f {
    public static void a(CustomTextView customTextView, Layout layout, int i2, int i3) {
        int i4;
        int max;
        int i5 = 0;
        AppMethodBeat.i(206115);
        int width = customTextView.getWidth() - (customTextView.getTotalPaddingLeft() + customTextView.getTotalPaddingRight());
        int lineForVertical = layout.getLineForVertical(i3);
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(lineForVertical);
        boolean z = layout.getParagraphDirection(lineForVertical) > 0;
        if (customTextView.getHorizontallyScrolling()) {
            int lineForVertical2 = layout.getLineForVertical((customTextView.getHeight() + i3) - (customTextView.getTotalPaddingTop() + customTextView.getTotalPaddingBottom()));
            int i6 = Integer.MAX_VALUE;
            i4 = 0;
            while (lineForVertical <= lineForVertical2) {
                i6 = (int) Math.min((float) i6, layout.getLineLeft(lineForVertical));
                i4 = (int) Math.max((float) i4, layout.getLineRight(lineForVertical));
                lineForVertical++;
            }
            i5 = i6;
        } else {
            i4 = width;
        }
        int i7 = i4 - i5;
        if (i7 >= width) {
            max = Math.max(Math.min(i2, i4 - width), i5);
        } else if (paragraphAlignment == Layout.Alignment.ALIGN_CENTER) {
            max = i5 - ((width - i7) / 2);
        } else if ((!z || paragraphAlignment != Layout.Alignment.ALIGN_OPPOSITE) && (z || paragraphAlignment != Layout.Alignment.ALIGN_NORMAL)) {
            max = i5;
        } else {
            Log.i("Touch", "scrollto may err");
            max = i5 - (width - i7);
        }
        customTextView.scrollTo(max, i3);
        AppMethodBeat.o(206115);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean a(CustomTextView customTextView, Spannable spannable, MotionEvent motionEvent) {
        float x;
        float y;
        Object[] objArr;
        AppMethodBeat.i(206116);
        switch (motionEvent.getActionMasked()) {
            case 0:
                for (Object obj : (a[]) spannable.getSpans(0, spannable.length(), a.class)) {
                    spannable.removeSpan(obj);
                }
                spannable.setSpan(new a(motionEvent.getX(), motionEvent.getY(), customTextView.getScrollX(), customTextView.getScrollY()), 0, 0, 17);
                AppMethodBeat.o(206116);
                return true;
            case 1:
                Object[] objArr2 = (a[]) spannable.getSpans(0, spannable.length(), a.class);
                for (a aVar : objArr2) {
                    spannable.removeSpan(aVar);
                }
                if (objArr2.length <= 0 || !objArr2[0].ovs) {
                    AppMethodBeat.o(206116);
                    return false;
                }
                AppMethodBeat.o(206116);
                return true;
            case 2:
                a[] aVarArr = (a[]) spannable.getSpans(0, spannable.length(), a.class);
                if (aVarArr.length > 0) {
                    if (!aVarArr[0].ovr) {
                        int scaledTouchSlop = ViewConfiguration.get(customTextView.getContext()).getScaledTouchSlop();
                        if (Math.abs(motionEvent.getX() - aVarArr[0].mX) >= ((float) scaledTouchSlop) || Math.abs(motionEvent.getY() - aVarArr[0].mY) >= ((float) scaledTouchSlop)) {
                            aVarArr[0].ovr = true;
                        }
                    }
                    if (aVarArr[0].ovr) {
                        aVarArr[0].ovs = true;
                        if (((motionEvent.getMetaState() & 1) == 0 && MetaKeyKeyListener.getMetaState(spannable, 1) != 1 && MetaKeyKeyListener.getMetaState(spannable, 2048) == 0) ? false : true) {
                            x = motionEvent.getX() - aVarArr[0].mX;
                            y = motionEvent.getY() - aVarArr[0].mY;
                        } else {
                            x = aVarArr[0].mX - motionEvent.getX();
                            y = aVarArr[0].mY - motionEvent.getY();
                        }
                        aVarArr[0].mX = motionEvent.getX();
                        aVarArr[0].mY = motionEvent.getY();
                        int scrollX = customTextView.getScrollX() + ((int) x);
                        int scrollY = ((int) y) + customTextView.getScrollY();
                        int totalPaddingTop = customTextView.getTotalPaddingTop() + customTextView.getTotalPaddingBottom();
                        Layout layout = customTextView.getLayout();
                        int max = Math.max(Math.min(scrollY, layout.getHeight() - (customTextView.getHeight() - totalPaddingTop)), 0);
                        int scrollX2 = customTextView.getScrollX();
                        int scrollY2 = customTextView.getScrollY();
                        a(customTextView, layout, scrollX, max);
                        if (!(scrollX2 == customTextView.getScrollX() && scrollY2 == customTextView.getScrollY())) {
                            customTextView.cancelLongPress();
                        }
                        AppMethodBeat.o(206116);
                        return true;
                    }
                }
                break;
        }
        AppMethodBeat.o(206116);
        return false;
    }

    static class a implements NoCopySpan {
        public float mX;
        public float mY;
        public int ovp;
        public int ovq;
        public boolean ovr;
        public boolean ovs;

        public a(float f2, float f3, int i2, int i3) {
            this.mX = f2;
            this.mY = f3;
            this.ovp = i2;
            this.ovq = i3;
        }
    }
}
