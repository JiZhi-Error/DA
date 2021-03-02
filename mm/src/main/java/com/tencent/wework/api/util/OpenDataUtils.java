package com.tencent.wework.api.util;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class OpenDataUtils {
    public static long c(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.i(199016);
        try {
            Uri build = new Uri.Builder().scheme("content").authority(str2 + ".wwapi").appendPath("bundle").appendQueryParameter("pakage", str).build();
            ContentValues contentValues = new ContentValues();
            Parcel obtain = Parcel.obtain();
            bundle.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            contentValues.put("data", marshall);
            return ContentUris.parseId(context.getContentResolver().insert(build, contentValues));
        } catch (Throwable th) {
            return -1;
        } finally {
            AppMethodBeat.o(199016);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x006b A[SYNTHETIC, Splitter:B:13:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0070 A[SYNTHETIC, Splitter:B:16:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008d A[SYNTHETIC, Splitter:B:30:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0092 A[SYNTHETIC, Splitter:B:33:0x0092] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String aa(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 182
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wework.api.util.OpenDataUtils.aa(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }
}
