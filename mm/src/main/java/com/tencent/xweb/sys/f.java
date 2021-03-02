package com.tencent.xweb.sys;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ad;
import com.tencent.xweb.internal.IWebViewDatabase;

public final class f implements IWebViewDatabase {
    @Override // com.tencent.xweb.internal.IWebViewDatabase
    public final void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(207187);
        ad.hta().setHttpAuthUsernamePassword(str, str2, str3, str4);
        AppMethodBeat.o(207187);
    }

    @Override // com.tencent.xweb.internal.IWebViewDatabase
    public final String[] getHttpAuthUsernamePassword(String str, String str2) {
        AppMethodBeat.i(207188);
        String[] httpAuthUsernamePassword = ad.hta().getHttpAuthUsernamePassword(str, str2);
        AppMethodBeat.o(207188);
        return httpAuthUsernamePassword;
    }
}
