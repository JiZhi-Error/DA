package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.l;

public final class ad implements IWebViewDatabase {
    public static IWebViewDatabase hta() {
        AppMethodBeat.i(219054);
        IWebViewDatabase webViewDatabase = l.g(WebView.getCurWebType()).getWebViewDatabase();
        AppMethodBeat.o(219054);
        return webViewDatabase;
    }

    @Override // com.tencent.xweb.internal.IWebViewDatabase
    public final void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(219055);
        hta().setHttpAuthUsernamePassword(str, str2, str3, str4);
        AppMethodBeat.o(219055);
    }

    @Override // com.tencent.xweb.internal.IWebViewDatabase
    public final String[] getHttpAuthUsernamePassword(String str, String str2) {
        AppMethodBeat.i(219056);
        String[] httpAuthUsernamePassword = hta().getHttpAuthUsernamePassword(str, str2);
        AppMethodBeat.o(219056);
        return httpAuthUsernamePassword;
    }
}
