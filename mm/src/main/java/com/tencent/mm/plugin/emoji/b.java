package com.tencent.mm.plugin.emoji;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.f;
import com.tencent.mm.ce.g;
import com.tencent.mm.plugin.emoji.b.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b implements a {
    @Override // com.tencent.mm.plugin.emoji.b.a
    public final SpannableString a(Context context, CharSequence charSequence, float f2) {
        AppMethodBeat.i(104526);
        SpannableString a2 = g.gxZ().a(context, charSequence, f2);
        AppMethodBeat.o(104526);
        return a2;
    }

    @Override // com.tencent.mm.plugin.emoji.b.a
    public final SpannableString b(Context context, CharSequence charSequence, float f2) {
        AppMethodBeat.i(104527);
        SpannableString b2 = l.b(context, charSequence, f2);
        AppMethodBeat.o(104527);
        return b2;
    }

    @Override // com.tencent.mm.plugin.emoji.b.a
    public final String fN(String str, String str2) {
        f.a big;
        AppMethodBeat.i(104528);
        g.gxZ();
        f gxT = f.gxT();
        MMApplicationContext.getContext();
        int i2 = 0;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if ((charAt == '/' || charAt == '[') && (big = gxT.big(str.substring(i2))) != null) {
                sb.append(str2);
                i2 += big.text.length();
            } else {
                sb.append(charAt);
                i2++;
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(104528);
        return sb2;
    }

    @Override // com.tencent.mm.plugin.emoji.b.a
    public final boolean M(CharSequence charSequence) {
        AppMethodBeat.i(104529);
        boolean M = g.gxZ().M(charSequence);
        AppMethodBeat.o(104529);
        return M;
    }

    @Override // com.tencent.mm.plugin.emoji.b.a
    public final boolean N(CharSequence charSequence) {
        AppMethodBeat.i(104530);
        boolean N = g.gxZ().N(charSequence);
        AppMethodBeat.o(104530);
        return N;
    }

    @Override // com.tencent.mm.plugin.emoji.b.a
    public final String alW(String str) {
        AppMethodBeat.i(104531);
        com.tencent.mm.ce.b.gxI();
        String alW = com.tencent.mm.ce.b.alW(str);
        AppMethodBeat.o(104531);
        return alW;
    }
}
