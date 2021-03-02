package com.tencent.mm.ce;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Util;

public final class g implements f {
    private static g NLp;
    private int NLo = 300;

    private g() {
    }

    public static g gxZ() {
        AppMethodBeat.i(104946);
        if (NLp == null) {
            NLp = new g();
        }
        g gVar = NLp;
        AppMethodBeat.o(104946);
        return gVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.f
    public final SpannableString b(Context context, CharSequence charSequence, int i2) {
        AppMethodBeat.i(199816);
        if (charSequence == null || Util.isNullOrNil(charSequence.toString())) {
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.o(199816);
            return spannableString;
        }
        SpannableString m = m(charSequence, i2);
        AppMethodBeat.o(199816);
        return m;
    }

    public final SpannableString a(Context context, CharSequence charSequence, float f2) {
        AppMethodBeat.i(199817);
        if (charSequence == null || Util.isNullOrNil(charSequence.toString())) {
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.o(199817);
            return spannableString;
        }
        SpannableString b2 = b(context, charSequence, (int) f2);
        AppMethodBeat.o(199817);
        return b2;
    }

    private SpannableString m(CharSequence charSequence, int i2) {
        SpannableString spannableString;
        AppMethodBeat.i(104949);
        if (charSequence == null || Util.isNullOrNil(charSequence.toString())) {
            SpannableString spannableString2 = new SpannableString("");
            AppMethodBeat.o(104949);
            return spannableString2;
        }
        if (charSequence instanceof SpannableString) {
            spannableString = (SpannableString) charSequence;
        } else {
            spannableString = new SpannableString(charSequence);
        }
        PInt pInt = new PInt();
        pInt.value = this.NLo;
        SpannableString b2 = f.gxT().b(b.gxI().a(spannableString, i2, pInt), i2, pInt.value);
        AppMethodBeat.o(104949);
        return b2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.f
    public final boolean N(CharSequence charSequence) {
        AppMethodBeat.i(104950);
        boolean bif = f.gxT().bif(charSequence.toString());
        AppMethodBeat.o(104950);
        return bif;
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.f
    public final boolean M(CharSequence charSequence) {
        AppMethodBeat.i(104951);
        b.gxI();
        boolean bia = b.bia(charSequence.toString());
        AppMethodBeat.o(104951);
        return bia;
    }
}
