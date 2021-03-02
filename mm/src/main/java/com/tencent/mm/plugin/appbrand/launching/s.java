package com.tencent.mm.plugin.appbrand.launching;

import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.storage.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Locale;

public final class s {
    private static final Uri CONTENT_URI = Uri.parse("content://" + a.AUTHORITY + "/DevPkgLaunchExtInfo");
    private static final s mTB = new s();

    static {
        AppMethodBeat.i(146066);
        AppMethodBeat.o(146066);
    }

    public static s bNx() {
        return mTB;
    }

    public static String bU(String str, int i2) {
        r rVar = null;
        AppMethodBeat.i(146065);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(146065);
            return null;
        }
        Cursor query = MMApplicationContext.getContext().getContentResolver().query(CONTENT_URI, null, String.format(Locale.US, "%s=? And %s=?", "appId", "versionType"), new String[]{str, String.valueOf(i2)}, null, null);
        if (query == null) {
            AppMethodBeat.o(146065);
            return null;
        }
        if (!query.isClosed() && query.moveToFirst()) {
            rVar = new r();
            rVar.convertFrom(query);
        }
        query.close();
        if (rVar != null) {
            String str2 = rVar.field_extJson;
            AppMethodBeat.o(146065);
            return str2;
        }
        AppMethodBeat.o(146065);
        return "";
    }
}
