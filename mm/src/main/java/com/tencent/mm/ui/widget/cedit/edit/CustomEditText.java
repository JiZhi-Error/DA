package com.tencent.mm.ui.widget.cedit.edit;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.cedit.b.a;
import com.tencent.mm.ui.widget.cedit.b.d;

public class CustomEditText extends CustomTextView {
    public CustomEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, R.style.nx);
    }

    public CustomEditText(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    private CustomEditText(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public boolean getFreezesText() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public boolean getDefaultEditable() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public d getDefaultMovementMethod() {
        AppMethodBeat.i(205546);
        d haX = a.haX();
        AppMethodBeat.o(205546);
        return haX;
    }

    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public Editable getText() {
        AppMethodBeat.i(205547);
        CharSequence text = super.getText();
        if (text == null) {
            AppMethodBeat.o(205547);
            return null;
        } else if (text instanceof Editable) {
            Editable editable = (Editable) super.getText();
            AppMethodBeat.o(205547);
            return editable;
        } else {
            super.setText(text, TextView.BufferType.EDITABLE);
            Editable editable2 = (Editable) super.getText();
            AppMethodBeat.o(205547);
            return editable2;
        }
    }

    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        AppMethodBeat.i(205548);
        super.setText(charSequence, TextView.BufferType.EDITABLE);
        AppMethodBeat.o(205548);
    }

    public void setSelection(int i2) {
        AppMethodBeat.i(205549);
        Selection.setSelection(getText(), i2);
        AppMethodBeat.o(205549);
    }

    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        AppMethodBeat.i(205550);
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("EditText cannot use the ellipsize mode TextUtils.TruncateAt.MARQUEE");
            AppMethodBeat.o(205550);
            throw illegalArgumentException;
        }
        super.setEllipsize(truncateAt);
        AppMethodBeat.o(205550);
    }

    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public CharSequence getAccessibilityClassName() {
        AppMethodBeat.i(205551);
        String name = CustomEditText.class.getName();
        AppMethodBeat.o(205551);
        return name;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public final boolean jw() {
        return false;
    }
}
