package com.tencent.mm.platformtools;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h {
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0341  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0395  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0158 A[SYNTHETIC, Splitter:B:51:0x0158] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x020c A[SYNTHETIC, Splitter:B:85:0x020c] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x025e  */
    @android.annotation.TargetApi(14)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getPhoneNum(android.content.Context r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 943
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.h.getPhoneNum(android.content.Context, java.lang.String):java.lang.String");
    }

    private static String H(Context context, String str) {
        Exception e2;
        String str2;
        String str3 = null;
        AppMethodBeat.i(127687);
        Log.i("MicroMsg.ContactsUtil", "Get contactId by email, email = %s", str);
        if (context == null) {
            Log.e("MicroMsg.ContactsUtil", "context is null.");
            AppMethodBeat.o(127687);
            return null;
        } else if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.ContactsUtil", "email is null.");
            AppMethodBeat.o(127687);
            return null;
        } else {
            try {
                Cursor query = context.getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, new String[]{"contact_id", "data1"}, "data1=?", new String[]{str}, null);
                if (query != null) {
                    if (query.moveToFirst()) {
                        while (true) {
                            try {
                                str3 = query.getString(query.getColumnIndex("contact_id"));
                                if (Util.isNullOrNil(str3)) {
                                    if (!query.moveToNext()) {
                                        str2 = str3;
                                        break;
                                    }
                                } else {
                                    Log.i("MicroMsg.ContactsUtil", "Have got contactId ,contactId is [%s]", str3);
                                    str2 = str3;
                                    break;
                                }
                            } catch (Exception e3) {
                                e2 = e3;
                                str2 = str3;
                                Log.printErrStackTrace("MicroMsg.ContactsUtil", e2, "getContactIdByEmail error", new Object[0]);
                                AppMethodBeat.o(127687);
                                return str2;
                            }
                        }
                    } else {
                        str2 = null;
                    }
                    try {
                        query.close();
                    } catch (Exception e4) {
                        e2 = e4;
                        Log.printErrStackTrace("MicroMsg.ContactsUtil", e2, "getContactIdByEmail error", new Object[0]);
                        AppMethodBeat.o(127687);
                        return str2;
                    }
                } else {
                    str2 = null;
                }
            } catch (Exception e5) {
                e2 = e5;
                str2 = null;
                Log.printErrStackTrace("MicroMsg.ContactsUtil", e2, "getContactIdByEmail error", new Object[0]);
                AppMethodBeat.o(127687);
                return str2;
            }
            AppMethodBeat.o(127687);
            return str2;
        }
    }
}
