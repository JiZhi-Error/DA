package com.tencent.mm.plugin.normsg;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;

public final class NormsgDataProvider extends ContentProvider {
    public static final String AUTHORITY = WeChatAuthorities.AUTHORITIES_PLUGIN_NORMSG_NMDATA();
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    static {
        AppMethodBeat.i(148937);
        AppMethodBeat.o(148937);
    }

    public final boolean onCreate() {
        AppMethodBeat.i(187545);
        d.a(b.INSTANCE);
        AppMethodBeat.o(187545);
        return true;
    }

    public static String G(Context context, String str) {
        AppMethodBeat.i(148934);
        Bundle call = context.getContentResolver().call(CONTENT_URI, "m0", str, (Bundle) null);
        if (call != null) {
            String string = call.getString("result", "");
            AppMethodBeat.o(148934);
            return string;
        }
        AppMethodBeat.o(148934);
        return "";
    }

    public static boolean dn(Context context) {
        AppMethodBeat.i(187546);
        Bundle call = context.getContentResolver().call(CONTENT_URI, "m1", (String) null, (Bundle) null);
        if (call != null) {
            boolean z = call.getBoolean("result", false);
            AppMethodBeat.o(187546);
            return z;
        }
        AppMethodBeat.o(187546);
        return false;
    }

    private String aIH(String str) {
        AppMethodBeat.i(148935);
        try {
            PackageManager packageManager = getContext().getPackageManager();
            String charSequence = packageManager.getApplicationInfo(str, 0).loadLabel(packageManager).toString();
            AppMethodBeat.o(148935);
            return charSequence;
        } catch (Throwable th) {
            AppMethodBeat.o(148935);
            return "";
        }
    }

    private static boolean exE() {
        AppMethodBeat.i(187547);
        try {
            boolean exN = d.INSTANCE.exN();
            AppMethodBeat.o(187547);
            return exN;
        } catch (Throwable th) {
            AppMethodBeat.o(187547);
            return false;
        }
    }

    public final Bundle call(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(148936);
        Log.i("MicroMsg.NormsgDP", "invoke method: %s, with arg: %s, extras: %s", str, str2, bundle);
        if ("m0".equals(str)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("result", aIH(str2));
            AppMethodBeat.o(148936);
            return bundle2;
        } else if ("m1".equals(str)) {
            Bundle bundle3 = new Bundle();
            bundle3.putBoolean("result", exE());
            AppMethodBeat.o(148936);
            return bundle3;
        } else {
            Log.w("MicroMsg.NormsgDP", "unknown method: %s", str);
            AppMethodBeat.o(148936);
            return null;
        }
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
}
