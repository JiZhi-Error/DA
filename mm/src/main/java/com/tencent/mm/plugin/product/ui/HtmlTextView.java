package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.net.URL;
import org.xml.sax.XMLReader;

public class HtmlTextView extends TextView {
    Html.ImageGetter Bai = new Html.ImageGetter() {
        /* class com.tencent.mm.plugin.product.ui.HtmlTextView.AnonymousClass2 */

        public final Drawable getDrawable(String str) {
            AppMethodBeat.i(66918);
            try {
                Drawable createFromStream = Drawable.createFromStream(new URL(str).openStream(), "");
                if (createFromStream != null) {
                    createFromStream.setBounds(0, 0, createFromStream.getIntrinsicWidth(), createFromStream.getIntrinsicHeight());
                }
                AppMethodBeat.o(66918);
                return createFromStream;
            } catch (Exception e2) {
                AppMethodBeat.o(66918);
                return null;
            }
        }
    };
    Html.TagHandler Baj = new Html.TagHandler() {
        /* class com.tencent.mm.plugin.product.ui.HtmlTextView.AnonymousClass3 */

        public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
            AppMethodBeat.i(66919);
            if (str.equalsIgnoreCase("strike") || str.equals("s")) {
                int length = editable.length();
                if (z) {
                    editable.setSpan(new StrikethroughSpan(), length, length, 17);
                    AppMethodBeat.o(66919);
                    return;
                }
                Object a2 = a(editable, StrikethroughSpan.class);
                int spanStart = editable.getSpanStart(a2);
                editable.removeSpan(a2);
                if (spanStart != length) {
                    editable.setSpan(new StrikethroughSpan(), spanStart, length, 33);
                }
            }
            AppMethodBeat.o(66919);
        }

        private static Object a(Editable editable, Class cls) {
            AppMethodBeat.i(66920);
            Object[] spans = editable.getSpans(0, editable.length(), cls);
            if (spans.length == 0) {
                AppMethodBeat.o(66920);
                return null;
            }
            for (int length = spans.length; length > 0; length--) {
                if (editable.getSpanFlags(spans[length - 1]) == 17) {
                    Object obj = spans[length - 1];
                    AppMethodBeat.o(66920);
                    return obj;
                }
            }
            AppMethodBeat.o(66920);
            return null;
        }
    };

    static /* synthetic */ void a(HtmlTextView htmlTextView, CharSequence charSequence, TextView.BufferType bufferType) {
        AppMethodBeat.i(66925);
        super.setText(charSequence, bufferType);
        AppMethodBeat.o(66925);
    }

    public HtmlTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(66921);
        AppMethodBeat.o(66921);
    }

    public HtmlTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(66922);
        AppMethodBeat.o(66922);
    }

    public void setText(final String str) {
        AppMethodBeat.i(66923);
        g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread() {
            /* class com.tencent.mm.plugin.product.ui.HtmlTextView.AnonymousClass1 */
            private volatile Spanned Bak;

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean doInBackground() {
                AppMethodBeat.i(66915);
                this.Bak = HtmlTextView.a(HtmlTextView.this, str);
                AppMethodBeat.o(66915);
                return true;
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean onPostExecute() {
                AppMethodBeat.i(66916);
                HtmlTextView.a(HtmlTextView.this, this.Bak, TextView.BufferType.SPANNABLE);
                HtmlTextView.this.setMovementMethod(LinkMovementMethod.getInstance());
                AppMethodBeat.o(66916);
                return true;
            }

            public final String toString() {
                AppMethodBeat.i(66917);
                String str = super.toString() + "|setText";
                AppMethodBeat.o(66917);
                return str;
            }
        });
        AppMethodBeat.o(66923);
    }

    static /* synthetic */ Spanned a(HtmlTextView htmlTextView, String str) {
        AppMethodBeat.i(66924);
        Spanned fromHtml = Html.fromHtml(str, null, htmlTextView.Baj);
        AppMethodBeat.o(66924);
        return fromHtml;
    }
}
