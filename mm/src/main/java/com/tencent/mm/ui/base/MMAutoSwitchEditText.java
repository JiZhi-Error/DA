package com.tencent.mm.ui.base;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class MMAutoSwitchEditText extends EditText {
    a OPB = new a(this);

    public interface b {
        void alv(int i2);
    }

    public interface c {
        void alw(int i2);
    }

    public interface d {
        void cCU();
    }

    public MMAutoSwitchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141864);
        addTextChangedListener(this.OPB);
        setOnKeyListener(this.OPB);
        AppMethodBeat.o(141864);
    }

    public static class a implements TextWatcher, View.OnKeyListener {
        c OPC;
        b OPD;
        d OPE;
        int OPF = 4;
        private EditText mEditText;
        int mIndex = 0;
        private String mText;

        public a(EditText editText) {
            this.mEditText = editText;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(141862);
            this.mText = editable.toString();
            String str = "";
            if (this.OPE != null) {
                this.OPE.cCU();
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.mText.length() && (i3 = i3 + 1) <= this.OPF) {
                i2++;
                str = str + this.mText.charAt(i2);
            }
            if (i3 > this.OPF) {
                this.mEditText.setText(str);
                this.mEditText.setSelection(str.length());
            }
            if (i3 >= this.OPF && this.OPC != null) {
                this.OPC.alw(this.mIndex);
            }
            AppMethodBeat.o(141862);
        }

        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            AppMethodBeat.i(141863);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            bVar.pH(i2);
            bVar.bm(keyEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMAutoSwitchEditText$AutoSwitchEditTextWatcher", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
            if (i2 == 67 && this.mEditText.getText().toString().trim().length() == 0 && this.OPD != null) {
                this.OPD.alv(this.mIndex);
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/base/MMAutoSwitchEditText$AutoSwitchEditTextWatcher", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(141863);
            return false;
        }
    }
}
