package com.tencent.mm.ui.widget.cedit.api;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.edit.CustomEditText;
import java.util.Iterator;
import java.util.LinkedList;

public class PasterEditTextCompact extends CustomEditText {
    private boolean QFZ = false;
    private int QGa = 0;
    private int QGb = 0;
    private CharSequence QGc = "";
    private CharSequence QGd = "";
    private int QGe = 0;
    private LinkedList<TextWatcher> QGf = new LinkedList<>();
    private LinkedList<Object> QGg = new LinkedList<>();
    private Context context;

    public PasterEditTextCompact(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(205540);
        this.context = context2;
        init();
        AppMethodBeat.o(205540);
    }

    public PasterEditTextCompact(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(205541);
        init();
        AppMethodBeat.o(205541);
    }

    public int getPasterLen() {
        return this.QGe;
    }

    public CharSequence getPasterContent() {
        return this.QGd;
    }

    private void init() {
        AppMethodBeat.i(205542);
        super.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.ui.widget.cedit.api.PasterEditTextCompact.AnonymousClass1 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(205537);
                Iterator it = PasterEditTextCompact.this.QGf.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).beforeTextChanged(charSequence, i2, i3, i4);
                }
                AppMethodBeat.o(205537);
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(205538);
                PasterEditTextCompact.this.QGa = i2;
                PasterEditTextCompact.this.QGb = i4;
                PasterEditTextCompact.this.QGc = charSequence.subSequence(i2, i2 + i4);
                Iterator it = PasterEditTextCompact.this.QGf.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).onTextChanged(charSequence, i2, i3, i4);
                }
                AppMethodBeat.o(205538);
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(205539);
                if (PasterEditTextCompact.this.QFZ || PasterEditTextCompact.this.QGe > 20) {
                    PasterEditTextCompact.this.QFZ = false;
                    PasterEditTextCompact.this.QGe = PasterEditTextCompact.this.QGb;
                    PasterEditTextCompact.this.QGd = PasterEditTextCompact.this.QGc;
                    Iterator it = PasterEditTextCompact.this.QGg.iterator();
                    while (it.hasNext()) {
                        it.next();
                        CharSequence unused = PasterEditTextCompact.this.QGc;
                        int unused2 = PasterEditTextCompact.this.QGa;
                        int unused3 = PasterEditTextCompact.this.QGb;
                    }
                }
                Iterator it2 = PasterEditTextCompact.this.QGf.iterator();
                while (it2.hasNext()) {
                    ((TextWatcher) it2.next()).afterTextChanged(editable);
                }
                AppMethodBeat.o(205539);
            }
        });
        AppMethodBeat.o(205542);
    }

    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public void addTextChangedListener(TextWatcher textWatcher) {
        AppMethodBeat.i(205543);
        this.QGf.add(textWatcher);
        AppMethodBeat.o(205543);
    }

    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public void removeTextChangedListener(TextWatcher textWatcher) {
        AppMethodBeat.i(205544);
        this.QGf.remove(textWatcher);
        AppMethodBeat.o(205544);
    }

    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public boolean onTextContextMenuItem(int i2) {
        AppMethodBeat.i(205545);
        if (i2 == 16908322) {
            this.QFZ = true;
        }
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i2);
        AppMethodBeat.o(205545);
        return onTextContextMenuItem;
    }
}
