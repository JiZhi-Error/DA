package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public class EllipsizeTextView extends TextView {
    private String OOd;
    private int OOe;
    private int OOf;
    private a OOg;
    private CharSequence OOh;
    private long OOi = -1;

    public interface a {
        CharSequence a(TextView textView, CharSequence charSequence, String str, int i2, int i3);
    }

    public EllipsizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EllipsizeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public final void a(CharSequence charSequence, String str, int i2, int i3) {
        AppMethodBeat.i(141626);
        this.OOd = str;
        this.OOe = i2;
        this.OOf = i3;
        this.OOh = charSequence;
        setText(((Object) this.OOh) + "  " + str);
        AppMethodBeat.o(141626);
    }

    public void setLayoutCallback(a aVar) {
        this.OOg = aVar;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(141627);
        super.onLayout(z, i2, i3, i4, i5);
        if (getMeasuredWidth() > 0 && !Util.isNullOrNil(this.OOd) && this.OOg != null && getText() != null && getText().length() > 0) {
            CharSequence a2 = this.OOg.a(this, this.OOh, this.OOd, this.OOe, this.OOf);
            this.OOd = null;
            setText(a2, TextView.BufferType.SPANNABLE);
            requestLayout();
        }
        AppMethodBeat.o(141627);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        AppMethodBeat.i(141628);
        super.setText(charSequence, bufferType);
        AppMethodBeat.o(141628);
    }
}
