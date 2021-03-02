package com.tencent.mm.plugin.appbrand.utils.html;

import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {

    public interface a {
        void YF(String str);
    }

    private static CharSequence a(CharSequence charSequence, a aVar, boolean z) {
        AppMethodBeat.i(147730);
        if (charSequence instanceof Spannable) {
            Spannable spannable = (Spannable) charSequence;
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, charSequence.length(), URLSpan.class);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            for (URLSpan uRLSpan : uRLSpanArr) {
                spannableStringBuilder.removeSpan(uRLSpan);
                spannableStringBuilder.setSpan(new CustomURLSpan(uRLSpan.getURL(), aVar, z), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 34);
            }
            AppMethodBeat.o(147730);
            return spannableStringBuilder;
        }
        AppMethodBeat.o(147730);
        return charSequence;
    }

    public static CharSequence a(String str, boolean z, a aVar) {
        AppMethodBeat.i(147731);
        CharSequence a2 = a(Html.fromHtml(str, new a(), new b(aVar, z)), aVar, z);
        AppMethodBeat.o(147731);
        return a2;
    }
}
