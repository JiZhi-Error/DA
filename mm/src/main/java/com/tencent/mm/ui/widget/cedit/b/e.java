package com.tencent.mm.ui.widget.cedit.b;

import android.text.Layout;
import android.text.Spannable;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;

public class e extends b implements d {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public boolean a(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206101);
        boolean b2 = b(customTextView, 1);
        AppMethodBeat.o(206101);
        return b2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public boolean b(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206102);
        boolean c2 = c(customTextView, 1);
        AppMethodBeat.o(206102);
        return c2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public boolean c(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206103);
        boolean d2 = d(customTextView, 1);
        AppMethodBeat.o(206103);
        return d2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public boolean d(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206104);
        boolean e2 = e(customTextView, 1);
        AppMethodBeat.o(206104);
        return e2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean k(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206111);
        boolean g2 = g(customTextView, spannable);
        AppMethodBeat.o(206111);
        return g2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean l(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206112);
        boolean h2 = h(customTextView, spannable);
        AppMethodBeat.o(206112);
        return h2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.b.b, com.tencent.mm.ui.widget.cedit.b.d
    public boolean a(CustomTextView customTextView, Spannable spannable, MotionEvent motionEvent) {
        AppMethodBeat.i(206113);
        boolean a2 = f.a(customTextView, spannable, motionEvent);
        AppMethodBeat.o(206113);
        return a2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.b.b, com.tencent.mm.ui.widget.cedit.b.d
    public void a(CustomTextView customTextView, Spannable spannable, int i2) {
        AppMethodBeat.i(206114);
        Layout layout = customTextView.getLayout();
        if (!(layout == null || (i2 & 2) == 0)) {
            customTextView.scrollTo(customTextView.getScrollX(), layout.getLineTop(0));
        }
        if (!(layout == null || (i2 & 1) == 0)) {
            customTextView.scrollTo(customTextView.getScrollX(), layout.getLineTop((layout.getLineCount() - 1) + 1) - (customTextView.getHeight() - (customTextView.getTotalPaddingTop() + customTextView.getTotalPaddingBottom())));
        }
        AppMethodBeat.o(206114);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean e(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206105);
        Layout layout = customTextView.getLayout();
        int lineForVertical = layout.getLineForVertical(customTextView.getScrollY() - b.h(customTextView));
        if (lineForVertical >= 0) {
            f.a(customTextView, layout, customTextView.getScrollX(), layout.getLineTop(lineForVertical));
            AppMethodBeat.o(206105);
            return true;
        }
        AppMethodBeat.o(206105);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean f(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206106);
        Layout layout = customTextView.getLayout();
        int h2 = b.h(customTextView);
        int lineForVertical = layout.getLineForVertical(customTextView.getScrollY() + h2 + h2);
        if (lineForVertical <= layout.getLineCount() - 1) {
            f.a(customTextView, layout, customTextView.getScrollX(), layout.getLineTop(lineForVertical + 1) - h2);
            AppMethodBeat.o(206106);
            return true;
        }
        AppMethodBeat.o(206106);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean g(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206107);
        Layout layout = customTextView.getLayout();
        if (b.e(customTextView) >= 0) {
            f.a(customTextView, layout, customTextView.getScrollX(), layout.getLineTop(0));
            AppMethodBeat.o(206107);
            return true;
        }
        AppMethodBeat.o(206107);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean h(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206108);
        Layout layout = customTextView.getLayout();
        int lineCount = layout.getLineCount();
        if (b.f(customTextView) <= lineCount - 1) {
            f.a(customTextView, layout, customTextView.getScrollX(), layout.getLineTop(lineCount) - b.h(customTextView));
            AppMethodBeat.o(206108);
            return true;
        }
        AppMethodBeat.o(206108);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean i(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206109);
        int j2 = b.j(customTextView);
        if (customTextView.getScrollX() > j2) {
            customTextView.scrollTo(j2, customTextView.getScrollY());
            AppMethodBeat.o(206109);
            return true;
        }
        AppMethodBeat.o(206109);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.b.b
    public final boolean j(CustomTextView customTextView, Spannable spannable) {
        AppMethodBeat.i(206110);
        int k = b.k(customTextView) - b.g(customTextView);
        if (customTextView.getScrollX() < k) {
            customTextView.scrollTo(k, customTextView.getScrollY());
            AppMethodBeat.o(206110);
            return true;
        }
        AppMethodBeat.o(206110);
        return false;
    }
}
