package com.tencent.mm.ui.widget.cedit.b;

import android.os.Build;
import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.textclassifier.TextLinks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;

public final class c extends e {
    private static c QLM;
    private static Object hvc = new NoCopySpan.Concrete();
    private String TAG = "cmEdit.LinkMovementMethod";

    @Override // com.tencent.mm.ui.widget.cedit.b.b, com.tencent.mm.ui.widget.cedit.b.d
    public final boolean canSelectArbitrarily() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean a(CustomTextView customTextView, Spannable spannable, int i2, int i3, KeyEvent keyEvent) {
        AppMethodBeat.i(206090);
        switch (i2) {
            case 23:
            case 66:
                if (KeyEvent.metaStateHasNoModifiers(i3) && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0 && a(1, customTextView, spannable)) {
                    AppMethodBeat.o(206090);
                    return true;
                }
        }
        boolean a2 = super.a(customTextView, spannable, i2, i3, keyEvent);
        AppMethodBeat.o(206090);
        return a2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.e, com.tencent.mm.ui.widget.cedit.b.b
    public final boolean c(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206091);
        if (a(2, customTextView, spannable)) {
            AppMethodBeat.o(206091);
            return true;
        }
        boolean c2 = super.c(customTextView, spannable);
        AppMethodBeat.o(206091);
        return c2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.e, com.tencent.mm.ui.widget.cedit.b.b
    public final boolean d(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206092);
        if (a(3, customTextView, spannable)) {
            AppMethodBeat.o(206092);
            return true;
        }
        boolean d2 = super.d(customTextView, spannable);
        AppMethodBeat.o(206092);
        return d2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.e, com.tencent.mm.ui.widget.cedit.b.b
    public final boolean a(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206093);
        if (a(2, customTextView, spannable)) {
            AppMethodBeat.o(206093);
            return true;
        }
        boolean a2 = super.a(customTextView, spannable);
        AppMethodBeat.o(206093);
        return a2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.e, com.tencent.mm.ui.widget.cedit.b.b
    public final boolean b(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206094);
        if (a(3, customTextView, spannable)) {
            AppMethodBeat.o(206094);
            return true;
        }
        boolean b2 = super.b(customTextView, spannable);
        AppMethodBeat.o(206094);
        return b2;
    }

    private static boolean a(int i2, CustomTextView customTextView, Spannable spannable) {
        int i3;
        int i4;
        int i5 = -1;
        AppMethodBeat.i(206095);
        Layout layout = customTextView.getLayout();
        int totalPaddingTop = customTextView.getTotalPaddingTop() + customTextView.getTotalPaddingBottom();
        int scrollY = customTextView.getScrollY();
        int lineForVertical = layout.getLineForVertical(scrollY);
        int lineForVertical2 = layout.getLineForVertical((customTextView.getHeight() + scrollY) - totalPaddingTop);
        int lineStart = layout.getLineStart(lineForVertical);
        int lineEnd = layout.getLineEnd(lineForVertical2);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(lineStart, lineEnd, ClickableSpan.class);
        int selectionStart = Selection.getSelectionStart(spannable);
        int selectionEnd = Selection.getSelectionEnd(spannable);
        int min = Math.min(selectionStart, selectionEnd);
        int max = Math.max(selectionStart, selectionEnd);
        if (min < 0 && spannable.getSpanStart(hvc) >= 0) {
            int length = spannable.length();
            min = length;
            max = length;
        }
        if (min > lineEnd) {
            min = Integer.MAX_VALUE;
            max = Integer.MAX_VALUE;
        }
        if (max < lineStart) {
            i3 = -1;
            i4 = -1;
        } else {
            i3 = min;
            i4 = max;
        }
        switch (i2) {
            case 1:
                if (i3 != i4) {
                    ClickableSpan[] clickableSpanArr2 = (ClickableSpan[]) spannable.getSpans(i3, i4, ClickableSpan.class);
                    if (clickableSpanArr2.length == 1) {
                        ClickableSpan clickableSpan = clickableSpanArr2[0];
                        if (Build.VERSION.SDK_INT >= 28) {
                            if (clickableSpan instanceof TextLinks.TextLinkSpan) {
                                clickableSpan.onClick(customTextView);
                                break;
                            } else {
                                clickableSpan.onClick(customTextView);
                                break;
                            }
                        }
                    } else {
                        AppMethodBeat.o(206095);
                        return false;
                    }
                } else {
                    AppMethodBeat.o(206095);
                    return false;
                }
                break;
            case 2:
                int i6 = 0;
                int i7 = -1;
                while (true) {
                    int i8 = i5;
                    if (i6 < clickableSpanArr.length) {
                        int spanEnd = spannable.getSpanEnd(clickableSpanArr[i6]);
                        if ((spanEnd < i4 || i3 == i4) && spanEnd > i7) {
                            i8 = spannable.getSpanStart(clickableSpanArr[i6]);
                            i7 = spanEnd;
                        }
                        i5 = i8;
                        i6++;
                    } else if (i8 >= 0) {
                        Selection.setSelection(spannable, i7, i8);
                        AppMethodBeat.o(206095);
                        return true;
                    }
                }
                break;
            case 3:
                int i9 = Integer.MAX_VALUE;
                int i10 = Integer.MAX_VALUE;
                for (int i11 = 0; i11 < clickableSpanArr.length; i11++) {
                    int spanStart = spannable.getSpanStart(clickableSpanArr[i11]);
                    if ((spanStart > i3 || i3 == i4) && spanStart < i10) {
                        i9 = spannable.getSpanEnd(clickableSpanArr[i11]);
                        i10 = spanStart;
                    }
                }
                if (i9 < Integer.MAX_VALUE) {
                    Selection.setSelection(spannable, i10, i9);
                    AppMethodBeat.o(206095);
                    return true;
                }
                break;
        }
        AppMethodBeat.o(206095);
        return false;
    }

    @Override // com.tencent.mm.ui.widget.cedit.b.e, com.tencent.mm.ui.widget.cedit.b.b, com.tencent.mm.ui.widget.cedit.b.d
    public final boolean a(CustomTextView customTextView, Spannable spannable, MotionEvent motionEvent) {
        AppMethodBeat.i(206096);
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int x = ((int) motionEvent.getX()) - customTextView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - customTextView.getTotalPaddingTop();
            int scrollX = x + customTextView.getScrollX();
            int scrollY = y + customTextView.getScrollY();
            Layout layout = customTextView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (clickableSpanArr.length != 0) {
                ClickableSpan clickableSpan = clickableSpanArr[0];
                if (action == 1) {
                    if (Build.VERSION.SDK_INT >= 28) {
                        clickableSpan.onClick(customTextView);
                    }
                } else if (action == 0) {
                    if (customTextView.getContext().getApplicationInfo().targetSdkVersion >= 28) {
                        customTextView.aoA(200);
                    }
                    Selection.setSelection(spannable, spannable.getSpanStart(clickableSpan), spannable.getSpanEnd(clickableSpan));
                }
                AppMethodBeat.o(206096);
                return true;
            }
            Selection.removeSelection(spannable);
        }
        boolean a2 = super.a(customTextView, spannable, motionEvent);
        AppMethodBeat.o(206096);
        return a2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.b.b, com.tencent.mm.ui.widget.cedit.b.d
    public final void j(Spannable spannable) {
        AppMethodBeat.i(206097);
        Selection.removeSelection(spannable);
        spannable.removeSpan(hvc);
        AppMethodBeat.o(206097);
    }

    @Override // com.tencent.mm.ui.widget.cedit.b.e, com.tencent.mm.ui.widget.cedit.b.b, com.tencent.mm.ui.widget.cedit.b.d
    public final void a(CustomTextView customTextView, Spannable spannable, int i2) {
        AppMethodBeat.i(206098);
        Selection.removeSelection(spannable);
        if ((i2 & 1) != 0) {
            spannable.setSpan(hvc, 0, 0, 34);
            AppMethodBeat.o(206098);
            return;
        }
        spannable.removeSpan(hvc);
        AppMethodBeat.o(206098);
    }

    public static d haX() {
        AppMethodBeat.i(206099);
        if (QLM == null) {
            QLM = new c();
        }
        c cVar = QLM;
        AppMethodBeat.o(206099);
        return cVar;
    }

    static {
        AppMethodBeat.i(206100);
        AppMethodBeat.o(206100);
    }
}
