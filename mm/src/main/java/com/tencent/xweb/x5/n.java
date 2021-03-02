package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.internal.IWebViewDatabase;
import org.xwalk.core.XWalkEnvironment;

public final class n implements IWebViewDatabase {
    @Override // com.tencent.xweb.internal.IWebViewDatabase
    public final void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(207237);
        new WebView(XWalkEnvironment.getApplicationContext()).setHttpAuthUsernamePassword(str, str2, str3, str4);
        AppMethodBeat.o(207237);
    }

    @Override // com.tencent.xweb.internal.IWebViewDatabase
    public final String[] getHttpAuthUsernamePassword(String str, String str2) {
        AppMethodBeat.i(207238);
        String[] httpAuthUsernamePassword = new WebView(XWalkEnvironment.getApplicationContext()).getHttpAuthUsernamePassword(str, str2);
        AppMethodBeat.o(207238);
        return httpAuthUsernamePassword;
    }
}
