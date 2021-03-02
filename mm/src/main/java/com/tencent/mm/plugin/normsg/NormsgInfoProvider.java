package com.tencent.mm.plugin.normsg;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;

public final class NormsgInfoProvider extends ContentProvider {
    public static final String AUTHORITY = WeChatAuthorities.AUTHORITIES_PLUGIN_NORMSG_NMINFO();
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    static {
        AppMethodBeat.i(187552);
        AppMethodBeat.o(187552);
    }

    public final boolean onCreate() {
        AppMethodBeat.i(187548);
        d.a(b.INSTANCE);
        AppMethodBeat.o(187548);
        return true;
    }

    private boolean aII(String str) {
        AppMethodBeat.i(187549);
        try {
            String callingPackage = getCallingPackage();
            Log.i("MicroMsg.NormsgIP", "isReqFrom " + callingPackage + "; expectPkg " + str);
            if (callingPackage == null || !callingPackage.equals(str)) {
                AppMethodBeat.o(187549);
                return false;
            }
            AppMethodBeat.o(187549);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.NormsgIP", "isReqFrom error:" + e2.toString());
            AppMethodBeat.o(187549);
            return false;
        }
    }

    public final Bundle call(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(187551);
        Log.i("MicroMsg.NormsgIP", "invoke: %s, with arg: %s", str, str2);
        if ("m0".equals(str)) {
            Bundle exF = exF();
            AppMethodBeat.o(187551);
            return exF;
        }
        Log.w("MicroMsg.NormsgIP", "unknown method: %s", str);
        AppMethodBeat.o(187551);
        return null;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public final String getType(Uri uri) {
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Bundle exF() {
        String str;
        AppMethodBeat.i(187550);
        if (!aII(b.INSTANCE.aIJ(".!\"f=/%' (3n,-!51;.)"))) {
            AppMethodBeat.o(187550);
            return null;
        }
        try {
            String exP = d.INSTANCE.exP();
            if (exP == null) {
                str = "";
            } else {
                str = exP;
            }
            Bundle bundle = new Bundle();
            bundle.putString("STR_RESULT", str);
            AppMethodBeat.o(187550);
            return bundle;
        } catch (Throwable th) {
            AppMethodBeat.o(187550);
            return null;
        }
    }
}
