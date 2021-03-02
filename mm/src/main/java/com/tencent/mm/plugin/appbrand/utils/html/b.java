package com.tencent.mm.plugin.appbrand.utils.html;

import android.text.Editable;
import android.text.Html;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.html.c;
import org.xml.sax.XMLReader;

public final class b implements Html.TagHandler {
    c.a ohX;
    private boolean ohY;

    public b(c.a aVar, boolean z) {
        this.ohX = aVar;
        this.ohY = z;
    }

    public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        CustomURLSpan customURLSpan;
        AppMethodBeat.i(147729);
        if ("a".equalsIgnoreCase(str)) {
            if (z) {
                int length = editable.length();
                editable.setSpan(new CustomURLSpan("", this.ohX, this.ohY), length, length, 17);
                AppMethodBeat.o(147729);
                return;
            }
            int length2 = editable.length();
            Object[] spans = editable.getSpans(0, editable.length(), CustomURLSpan.class);
            if (spans.length != 0) {
                int length3 = spans.length;
                while (true) {
                    if (length3 <= 0) {
                        break;
                    } else if (editable.getSpanFlags(spans[length3 - 1]) == 17) {
                        customURLSpan = spans[length3 - 1];
                        break;
                    } else {
                        length3--;
                    }
                }
            }
            customURLSpan = null;
            CustomURLSpan customURLSpan2 = customURLSpan;
            int spanStart = editable.getSpanStart(customURLSpan2);
            String charSequence = editable.subSequence(spanStart, length2).toString();
            editable.removeSpan(customURLSpan2);
            if (spanStart != length2) {
                editable.setSpan(new CustomURLSpan(charSequence, this.ohX, this.ohY), spanStart, length2, 33);
            }
        }
        AppMethodBeat.o(147729);
    }
}
