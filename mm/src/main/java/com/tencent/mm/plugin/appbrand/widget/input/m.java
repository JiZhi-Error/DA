package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m extends PasswordTransformationMethod {
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        AppMethodBeat.i(131503);
        a aVar = new a(charSequence);
        AppMethodBeat.o(131503);
        return aVar;
    }

    static final class a implements CharSequence {
        private CharSequence oti;

        a(CharSequence charSequence) {
            this.oti = charSequence;
        }

        public final int length() {
            AppMethodBeat.i(131501);
            int length = this.oti.length();
            AppMethodBeat.o(131501);
            return length;
        }

        public final char charAt(int i2) {
            return 9679;
        }

        public final CharSequence subSequence(int i2, int i3) {
            AppMethodBeat.i(131502);
            CharSequence subSequence = this.oti.subSequence(i2, i3);
            AppMethodBeat.o(131502);
            return subSequence;
        }
    }
}
