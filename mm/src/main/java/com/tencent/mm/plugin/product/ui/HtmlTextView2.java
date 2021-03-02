package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;

public class HtmlTextView2 extends MMWebView {
    private ac Ban = new ac() {
        /* class com.tencent.mm.plugin.product.ui.HtmlTextView2.AnonymousClass2 */

        @Override // com.tencent.xweb.ac
        public final boolean a(WebView webView, String str) {
            AppMethodBeat.i(66928);
            Log.d(APMidasPayAPI.ENV_TEST, str);
            AppMethodBeat.o(66928);
            return true;
        }
    };

    public HtmlTextView2(Context context, AttributeSet attributeSet, int i2) {
        super(MMApplicationContext.getContext(), attributeSet, i2);
        AppMethodBeat.i(66929);
        initView();
        AppMethodBeat.o(66929);
    }

    public HtmlTextView2(Context context, AttributeSet attributeSet) {
        super(MMApplicationContext.getContext(), attributeSet);
        AppMethodBeat.i(66930);
        initView();
        AppMethodBeat.o(66930);
    }

    private void initView() {
        AppMethodBeat.i(66931);
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.product.ui.HtmlTextView2.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(66927);
                if (motionEvent.getAction() == 2) {
                    AppMethodBeat.o(66927);
                    return true;
                }
                AppMethodBeat.o(66927);
                return false;
            }
        });
        setVerticalScrollBarEnabled(false);
        getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        getSettings().setDefaultTextEncodingName(ProtocolPackage.ServerEncoding);
        AppMethodBeat.o(66931);
    }

    public void setText(String str) {
        AppMethodBeat.i(66932);
        setWebViewClient(null);
        loadData(str, "text/html", ProtocolPackage.ServerEncoding);
        setWebViewClient(this.Ban);
        AppMethodBeat.o(66932);
    }
}
