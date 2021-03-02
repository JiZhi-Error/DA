package com.tencent.mm.plugin.editor.model.nativenote.a;

import android.text.Html;
import android.text.Spanned;
import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import java.util.regex.Pattern;

public final class a {
    private static String TAG = "MicroMsg.ConvertHtmlToSpanned";
    private static f<String, Spanned> qPZ = new c(30);
    public static Spanned qQa = null;

    static {
        AppMethodBeat.i(181693);
        AppMethodBeat.o(181693);
    }

    public static Spanned alS(String str) {
        AppMethodBeat.i(181691);
        if (str == null) {
            str = "";
        }
        String replaceAll = Pattern.compile("\n", 2).matcher(str).replaceAll("<br/>");
        Spanned fromHtml = fromHtml(replaceAll);
        qPZ.put(replaceAll, fromHtml);
        AppMethodBeat.o(181691);
        return fromHtml;
    }

    private static Spanned fromHtml(String str) {
        Spanned spanned;
        AppMethodBeat.i(181692);
        if (!str.startsWith("<html>")) {
            str = "<html>".concat(String.valueOf(str));
        }
        if (!str.endsWith("</html>")) {
            str = str + "</html>";
        }
        try {
            qQa = null;
            spanned = Html.fromHtml(str, null, new c());
        } catch (Throwable th) {
            if (qQa != null) {
                spanned = qQa;
            } else {
                spanned = null;
            }
        }
        if (spanned == null) {
            AppMethodBeat.o(181692);
            return null;
        }
        int length = spanned.toString().length();
        if (length <= 1 || !spanned.toString().endsWith("\n")) {
            AppMethodBeat.o(181692);
            return spanned;
        } else if (spanned.getSpans(length, length, ParagraphStyle.class).length > 0) {
            Spanned spanned2 = (Spanned) spanned.subSequence(0, length - 1);
            AppMethodBeat.o(181692);
            return spanned2;
        } else {
            AppMethodBeat.o(181692);
            return spanned;
        }
    }
}
