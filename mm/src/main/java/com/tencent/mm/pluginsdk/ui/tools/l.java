package com.tencent.mm.pluginsdk.ui.tools;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

public final class l {
    public static InputFilter[] KvQ = {new InputFilter.LengthFilter(50)};

    static {
        AppMethodBeat.i(141184);
        AppMethodBeat.o(141184);
    }

    public static class a implements TextWatcher {
        public MMEditText.b KvR = null;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(141183);
            if (this.KvR != null) {
                this.KvR.boS();
            }
            AppMethodBeat.o(141183);
        }
    }
}
