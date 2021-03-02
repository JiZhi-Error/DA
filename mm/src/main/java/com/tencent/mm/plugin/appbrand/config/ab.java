package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.luggage.wxa.storage.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class ab {
    private static final Uri URI = Uri.parse("content://" + a.AUTHORITY + "/WxaAttributesTable");
    private static final ab lhl = new ab();

    static {
        AppMethodBeat.i(146063);
        AppMethodBeat.o(146063);
    }

    public static ab bAu() {
        return lhl;
    }

    public static WxaAttributes e(String str, String... strArr) {
        AppMethodBeat.i(229823);
        long currentTicks = Util.currentTicks();
        WxaAttributes f2 = f(String.format("%s=?", "appId"), new String[]{str});
        Log.i("Luggage.WxaAttrsContentResolver", "queryWithAppId appId:%s, cost:%dms, columns:%s", str, Long.valueOf(Util.currentTicks() - currentTicks), Arrays.toString(strArr));
        AppMethodBeat.o(229823);
        return f2;
    }

    public static boolean a(lm lmVar) {
        AppMethodBeat.i(182791);
        if (lmVar == null) {
            AppMethodBeat.o(182791);
            return false;
        }
        try {
            byte[] byteArray = lmVar.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("CONTENT_KEY_BATCH_SYNC_PROTO", byteArray);
            MMApplicationContext.getContext().getContentResolver().insert(URI, contentValues);
            AppMethodBeat.o(182791);
            return true;
        } catch (Exception e2) {
            Log.e("Luggage.WxaAttrsContentResolver", "batchUpdateWithProto insert failed");
            AppMethodBeat.o(182791);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.tencent.mm.plugin.appbrand.config.WxaAttributes> a(java.util.List<java.lang.String> r14, java.lang.String... r15) {
        /*
        // Method dump skipped, instructions count: 217
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.config.ab.a(java.util.List, java.lang.String[]):java.util.List");
    }

    public static WxaAttributes f(String str, String[] strArr) {
        WxaAttributes wxaAttributes = null;
        AppMethodBeat.i(146062);
        Cursor query = MMApplicationContext.getContext().getContentResolver().query(URI, null, str, strArr, null);
        if (query == null) {
            AppMethodBeat.o(146062);
        } else {
            if (!query.isClosed() && query.moveToFirst()) {
                wxaAttributes = new WxaAttributes();
                wxaAttributes.convertFrom(query);
            }
            query.close();
            AppMethodBeat.o(146062);
        }
        return wxaAttributes;
    }
}
