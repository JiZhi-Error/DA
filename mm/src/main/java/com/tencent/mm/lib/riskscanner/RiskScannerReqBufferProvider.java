package com.tencent.mm.lib.riskscanner;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.e.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;

public class RiskScannerReqBufferProvider extends ContentProvider {
    public static final String AUTHORITY = WeChatAuthorities.AUTHORITIES_LIB_RISHSCANNER_RISKSCANNERREQBUFFERPROVIDER();
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    static {
        AppMethodBeat.i(138303);
        AppMethodBeat.o(138303);
    }

    public boolean onCreate() {
        AppMethodBeat.i(138300);
        Log.i("MicroMsg.RiskScannerReqBufferProvider", "onCreate called.");
        AppMethodBeat.o(138300);
        return true;
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(138301);
        Bundle[] bundleArr = {null};
        if ("prepareReqBuffer".equals(str)) {
            Log.i("MicroMsg.RiskScannerReqBufferProvider", "invoke method: %s, with arg: %s, extras: %s", str, str2, bundle);
            Bundle cM = cM(getContext());
            AppMethodBeat.o(138301);
            return cM;
        }
        Log.w("MicroMsg.RiskScannerReqBufferProvider", "unknown method: %s", str);
        Bundle bundle2 = bundleArr[0];
        AppMethodBeat.o(138301);
        return bundle2;
    }

    private Bundle cM(Context context) {
        AppMethodBeat.i(138302);
        final Bundle[] bundleArr = {null};
        try {
            a.aBA();
            c.a(context, new c.a() {
                /* class com.tencent.mm.lib.riskscanner.RiskScannerReqBufferProvider.AnonymousClass1 */

                @Override // com.tencent.e.a.c.a
                public final void g(int i2, byte[] bArr) {
                    AppMethodBeat.i(138299);
                    a.qn(i2);
                    Bundle[] bundleArr = bundleArr;
                    Bundle bundle = new Bundle();
                    bundleArr[0] = bundle;
                    if (i2 == 0 && bArr != null) {
                        bundle.putInt("errCode", i2);
                        bundle.putByteArray("reqBufferBase64", bArr);
                    }
                    AppMethodBeat.o(138299);
                }
            });
        } catch (Throwable th) {
            a.f(th);
        }
        Bundle bundle = bundleArr[0];
        AppMethodBeat.o(138302);
        return bundle;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
