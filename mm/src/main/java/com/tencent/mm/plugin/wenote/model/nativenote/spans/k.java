package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

public class k implements LeadingMarginSpan, f<Boolean>, g<Boolean> {
    public boolean qTE = false;
    public boolean qTF = false;
    private WeakReference<Drawable> qTG;
    private int qTd;
    public boolean qTe;
    public boolean qTj = false;
    public boolean qTk = false;

    /* Return type fixed from 'com.tencent.mm.plugin.wenote.model.nativenote.spans.f' to match base method */
    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.f
    public final /* synthetic */ f<Boolean> gjZ() {
        AppMethodBeat.i(30645);
        k gkb = gkb();
        AppMethodBeat.o(30645);
        return gkb;
    }

    public k(boolean z, int i2, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        AppMethodBeat.i(30641);
        this.qTd = i2;
        if (z2 && z4 && !z3) {
            z5 = true;
        }
        this.qTe = z5;
        this.qTF = z;
        this.qTj = z3;
        this.qTk = z4;
        this.qTE = z2;
        AppMethodBeat.o(30641);
    }

    public int getLeadingMargin(boolean z) {
        if (this.qTe) {
            return 0;
        }
        return this.qTd;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i2, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, boolean z, Layout layout) {
        AppMethodBeat.i(30642);
        Spanned spanned = (Spanned) charSequence;
        if (!this.qTe && spanned.getSpanStart(this) == i7) {
            WeakReference<Drawable> weakReference = this.qTG;
            Drawable drawable = null;
            if (weakReference != null) {
                drawable = weakReference.get();
            }
            if (drawable == null) {
                if (this.qTF) {
                    drawable = b.l(MMApplicationContext.getContext(), R.drawable.cj2);
                } else {
                    drawable = b.l(MMApplicationContext.getContext(), R.drawable.cj3);
                }
                this.qTG = new WeakReference<>(drawable);
            }
            if (drawable == null) {
                AppMethodBeat.o(30642);
                return;
            }
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            canvas.save();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.translate(0.0f, (float) (((fontMetricsInt.ascent + ((fontMetricsInt.descent + i5) + i5)) / 2) - (drawable.getBounds().bottom / 2)));
            drawable.draw(canvas);
            canvas.restore();
        }
        AppMethodBeat.o(30642);
    }

    private k gkb() {
        AppMethodBeat.i(30643);
        k kVar = new k(this.qTF, this.qTd, this.qTE, this.qTj, this.qTk);
        AppMethodBeat.o(30643);
        return kVar;
    }

    public final void a(TextView textView, Spannable spannable, MotionEvent motionEvent, k kVar) {
        boolean z;
        c ahp;
        AppMethodBeat.i(30644);
        if (motionEvent.getX() > ((float) this.qTd)) {
            Log.e("MicroMsg.NoteTodoSpan", "x > mGapWidth");
            AppMethodBeat.o(30644);
            return;
        }
        int spanStart = spannable.getSpanStart(kVar);
        int spanEnd = spannable.getSpanEnd(kVar);
        Object[] objArr = new Object[1];
        objArr[0] = this.qTF ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        Log.i("MicroMsg.NoteTodoSpan", "current mIsTodoCheck: %s", objArr);
        spannable.removeSpan(this);
        if (!this.qTF) {
            z = true;
        } else {
            z = false;
        }
        this.qTF = z;
        spannable.setSpan(gkb(), spanStart, spanEnd, 33);
        WXRTEditText wXRTEditText = (WXRTEditText) textView;
        if (wXRTEditText.getEditTextType() == 0 && (ahp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(wXRTEditText.getRecyclerItemPosition())) != null && ahp.getType() == 1) {
            ((i) ahp).content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(spannable);
        }
        AppMethodBeat.o(30644);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.g
    public final /* bridge */ /* synthetic */ Boolean getValue() {
        return Boolean.TRUE;
    }
}
