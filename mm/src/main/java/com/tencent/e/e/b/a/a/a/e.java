package com.tencent.e.e.b.a.a.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.e.e.b.a.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e extends d {
    @Override // com.tencent.e.e.b.a.a.d
    public final boolean ef(Context context) {
        AppMethodBeat.i(224044);
        boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(cR(context, "supported"));
        AppMethodBeat.o(224044);
        return equals;
    }

    private static String cR(Context context, String str) {
        Cursor cursor;
        String str2;
        AppMethodBeat.i(224045);
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{str}, null);
        } catch (Throwable th) {
            cursor = null;
        }
        if (cursor == null) {
            AppMethodBeat.o(224045);
            return "";
        }
        if (cursor.moveToNext()) {
            try {
                str2 = cursor.getString(cursor.getColumnIndex("value"));
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th2) {
                    }
                }
            } catch (Throwable th3) {
            }
            AppMethodBeat.o(224045);
            return str2;
        }
        str2 = "";
        AppMethodBeat.o(224045);
        return str2;
        AppMethodBeat.o(224045);
        throw th;
    }
}
