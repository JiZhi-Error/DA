package com.tencent.xweb.xwalk;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.xweb.internal.IWebViewDatabase;
import org.xwalk.core.XWalkEnvironment;

public final class t implements IWebViewDatabase {
    b SHR = b.db(XWalkEnvironment.getApplicationContext(), "xweb_http_auth.db");

    public t() {
        AppMethodBeat.i(207329);
        AppMethodBeat.o(207329);
    }

    @Override // com.tencent.xweb.internal.IWebViewDatabase
    public final void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(207330);
        b bVar = this.SHR;
        if (str == null || str2 == null || !bVar.huL()) {
            AppMethodBeat.o(207330);
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("host", str);
        contentValues.put("realm", str2);
        contentValues.put(ch.COL_USERNAME, str3);
        contentValues.put("password", str4);
        bVar.mDatabase.insert("httpauth", "host", contentValues);
        AppMethodBeat.o(207330);
    }

    @Override // com.tencent.xweb.internal.IWebViewDatabase
    public final String[] getHttpAuthUsernamePassword(String str, String str2) {
        AppMethodBeat.i(207331);
        String[] httpAuthUsernamePassword = this.SHR.getHttpAuthUsernamePassword(str, str2);
        AppMethodBeat.o(207331);
        return httpAuthUsernamePassword;
    }
}
