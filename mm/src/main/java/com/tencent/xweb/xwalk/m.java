package com.tencent.xweb.xwalk;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;

public class m extends XWalkUIClient {
    public m(XWalkView xWalkView) {
        super(xWalkView);
    }

    public final void a(XWalkView xWalkView, String str) {
        AppMethodBeat.i(154451);
        super.onPageLoadStarted(xWalkView, str);
        AppMethodBeat.o(154451);
    }

    public final void huJ() {
        AppMethodBeat.i(154452);
        super.onHideCustomView();
        AppMethodBeat.o(154452);
    }

    public final void a(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.i(154453);
        super.onShowCustomView(view, customViewCallback);
        AppMethodBeat.o(154453);
    }

    public final boolean a(XWalkView xWalkView, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.i(154454);
        boolean onJsPrompt = super.onJsPrompt(xWalkView, str, str2, str3, xWalkJavascriptResult);
        AppMethodBeat.o(154454);
        return onJsPrompt;
    }

    public final boolean a(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.i(154455);
        boolean onJsConfirm = super.onJsConfirm(xWalkView, str, str2, xWalkJavascriptResult);
        AppMethodBeat.o(154455);
        return onJsConfirm;
    }

    public final boolean b(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.i(154456);
        boolean onJsAlert = super.onJsAlert(xWalkView, str, str2, xWalkJavascriptResult);
        AppMethodBeat.o(154456);
        return onJsAlert;
    }
}
