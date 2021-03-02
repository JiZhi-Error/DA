package com.tencent.mm.ui.widget.edittext;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public class PasterEditText extends EditText {
    private boolean QFZ = false;
    private int QGa = 0;
    private int QGb = 0;
    private CharSequence QGc = "";
    private CharSequence QGd = "";
    private int QGe = 0;
    private LinkedList<TextWatcher> QGf = new LinkedList<>();
    private LinkedList<Object> QGg = new LinkedList<>();
    private Context context;

    public PasterEditText(Context context2) {
        super(context2);
        AppMethodBeat.i(168813);
        this.context = context2;
        init();
        AppMethodBeat.o(168813);
    }

    public PasterEditText(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(159400);
        this.context = context2;
        init();
        AppMethodBeat.o(159400);
    }

    public PasterEditText(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(159401);
        init();
        AppMethodBeat.o(159401);
    }

    public int getPasterLen() {
        return this.QGe;
    }

    public CharSequence getPasterContent() {
        return this.QGd;
    }

    private void init() {
        AppMethodBeat.i(159402);
        super.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.ui.widget.edittext.PasterEditText.AnonymousClass1 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(198295);
                Iterator it = PasterEditText.this.QGf.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).beforeTextChanged(charSequence, i2, i3, i4);
                }
                AppMethodBeat.o(198295);
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(198296);
                PasterEditText.this.QGa = i2;
                PasterEditText.this.QGb = i4;
                PasterEditText.this.QGc = charSequence.subSequence(i2, i2 + i4);
                Iterator it = PasterEditText.this.QGf.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).onTextChanged(charSequence, i2, i3, i4);
                }
                AppMethodBeat.o(198296);
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(198297);
                if (PasterEditText.this.QFZ || PasterEditText.this.QGe > 20) {
                    PasterEditText.this.QFZ = false;
                    PasterEditText.this.QGe = PasterEditText.this.QGb;
                    PasterEditText.this.QGd = PasterEditText.this.QGc;
                    Iterator it = PasterEditText.this.QGg.iterator();
                    while (it.hasNext()) {
                        it.next();
                        CharSequence unused = PasterEditText.this.QGc;
                        int unused2 = PasterEditText.this.QGa;
                        int unused3 = PasterEditText.this.QGb;
                    }
                }
                Iterator it2 = PasterEditText.this.QGf.iterator();
                while (it2.hasNext()) {
                    ((TextWatcher) it2.next()).afterTextChanged(editable);
                }
                AppMethodBeat.o(198297);
            }
        });
        AppMethodBeat.o(159402);
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        AppMethodBeat.i(198298);
        this.QGf.add(textWatcher);
        AppMethodBeat.o(198298);
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        AppMethodBeat.i(198299);
        this.QGf.remove(textWatcher);
        AppMethodBeat.o(198299);
    }

    public boolean onTextContextMenuItem(int i2) {
        AppMethodBeat.i(159403);
        if (i2 == 16908322) {
            this.QFZ = true;
        }
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i2);
        AppMethodBeat.o(159403);
        return onTextContextMenuItem;
    }
}
