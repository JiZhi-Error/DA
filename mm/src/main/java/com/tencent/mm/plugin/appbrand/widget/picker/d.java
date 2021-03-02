package com.tencent.mm.plugin.appbrand.widget.picker;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;

final class d {
    static void a(NumberPicker numberPicker) {
        AppMethodBeat.i(138086);
        if (numberPicker == null) {
            AppMethodBeat.o(138086);
            return;
        }
        try {
            EditText editText = (EditText) new c(numberPicker, "mInputText", null).get();
            if (editText != null) {
                editText.setEditableFactory(new Editable.Factory() {
                    /* class com.tencent.mm.plugin.appbrand.widget.picker.d.AnonymousClass1 */

                    public final Editable newEditable(CharSequence charSequence) {
                        AppMethodBeat.i(138085);
                        AnonymousClass1 r0 = new SpannableStringBuilder(charSequence) {
                            /* class com.tencent.mm.plugin.appbrand.widget.picker.d.AnonymousClass1.AnonymousClass1 */

                            public final void setSpan(Object obj, int i2, int i3, int i4) {
                                AppMethodBeat.i(138084);
                                try {
                                    super.setSpan(obj, i2, i3, i4);
                                    AppMethodBeat.o(138084);
                                } catch (Exception e2) {
                                    AppMethodBeat.o(138084);
                                }
                            }
                        };
                        AppMethodBeat.o(138085);
                        return r0;
                    }
                });
            }
            AppMethodBeat.o(138086);
        } catch (Exception e2) {
            AppMethodBeat.o(138086);
        }
    }
}
