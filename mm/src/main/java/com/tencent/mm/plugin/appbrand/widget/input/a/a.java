package com.tencent.mm.plugin.appbrand.widget.input.a;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.a.b;
import com.tencent.mm.pointers.PInt;

public final class a {
    private static final b owG = new b() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.a.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.widget.input.a.b
        public final b.a ys(int i2) {
            return null;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.a.b
        public final SpannableString a(Context context, CharSequence charSequence, float f2) {
            AppMethodBeat.i(177121);
            if (charSequence == null) {
                AppMethodBeat.o(177121);
                return null;
            }
            SpannableString spannableString = new SpannableString(charSequence);
            AppMethodBeat.o(177121);
            return spannableString;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.a.b
        public final Spannable a(Spannable spannable, int i2, PInt pInt, Spannable.Factory factory) {
            return spannable;
        }
    };

    public static b cce() {
        AppMethodBeat.i(136676);
        b bVar = (b) e.M(b.class);
        if (bVar == null) {
            b bVar2 = owG;
            AppMethodBeat.o(136676);
            return bVar2;
        }
        AppMethodBeat.o(136676);
        return bVar;
    }

    static {
        AppMethodBeat.i(136677);
        AppMethodBeat.o(136677);
    }
}
