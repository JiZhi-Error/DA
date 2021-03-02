package com.tencent.mm.pluginsdk;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b {
    public static boolean bcT(String str) {
        AppMethodBeat.i(151607);
        if (str.length() <= 0) {
            AppMethodBeat.o(151607);
            return false;
        }
        AppMethodBeat.o(151607);
        return true;
    }

    public static String Ts(String str) {
        String trim;
        AppMethodBeat.i(151608);
        String trim2 = str.trim();
        boolean startsWith = trim2.startsWith("+");
        if (startsWith && trim2.length() > 1) {
            trim2 = trim2.substring(1, trim2.length());
        }
        Matcher matcher = Pattern.compile("[^0-9]").matcher(trim2);
        if (startsWith) {
            trim = "+" + matcher.replaceAll("").trim();
        } else {
            trim = matcher.replaceAll("").trim();
        }
        AppMethodBeat.o(151608);
        return trim;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f7, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AddressBookUtil", r0, "getContactsInfo2:", new java.lang.Object[0]);
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0183, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0188, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0189, code lost:
        r3 = r7;
        r0 = null;
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x018d, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x018e, code lost:
        r3 = r7;
        r0 = r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0183 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:9:0x003f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] i(android.content.Context r12, android.net.Uri r13) {
        /*
        // Method dump skipped, instructions count: 407
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.b.i(android.content.Context, android.net.Uri):java.lang.String[]");
    }

    public static List<String[]> ii(Context context) {
        Cursor cursor;
        AppMethodBeat.i(151610);
        LinkedList linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        if (!com.tencent.mm.pluginsdk.permission.b.k(context, "android.permission.READ_CONTACTS", false)) {
            Log.e("MicroMsg.AddressBookUtil", "no contact permission");
            AppMethodBeat.o(151610);
            return linkedList;
        }
        try {
            cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        } catch (Exception e2) {
            Log.e("MicroMsg.AddressBookUtil", "getMobileInfo: exception occured [%s]", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.AddressBookUtil", e2, "", new Object[0]);
            cursor = null;
        }
        if (cursor == null) {
            Log.e("MicroMsg.AddressBookUtil", "getMobileInfo: mobile is null");
            AppMethodBeat.o(151610);
            return linkedList;
        }
        try {
            if (cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                cursor.close();
                AppMethodBeat.o(151610);
                return linkedList;
            }
            do {
                linkedList.add(new String[]{cursor.getString(cursor.getColumnIndex("contact_id")), cursor.getString(cursor.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME)), cursor.getString(cursor.getColumnIndex("data1")), cursor.getString(cursor.getColumnIndex("raw_contact_id")), String.valueOf(Long.valueOf(cursor.getLong(cursor.getColumnIndex("photo_id"))))});
            } while (cursor.moveToNext());
            cursor.close();
            AppMethodBeat.o(151610);
            return linkedList;
        } catch (Exception e3) {
            Log.e("MicroMsg.AddressBookUtil", "getMobileInfo: exception2 occured [%s]", e3.getMessage());
            Log.printErrStackTrace("MicroMsg.AddressBookUtil", e3, "", new Object[0]);
            cursor.close();
        } catch (Throwable th) {
            cursor.close();
            AppMethodBeat.o(151610);
            throw th;
        }
    }

    public static List<String[]> dO(Context context) {
        Cursor query;
        AppMethodBeat.i(151611);
        LinkedList linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        if (!com.tencent.mm.pluginsdk.permission.b.k(context, "android.permission.READ_CONTACTS", false)) {
            Log.e("MicroMsg.AddressBookUtil", "no contact permission");
            AppMethodBeat.o(151611);
            return linkedList;
        }
        try {
            query = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, "sort_key_alt");
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AddressBookUtil", e2, "", new Object[0]);
            Log.e("MicroMsg.AddressBookUtil", "exception in getMoblieOrderInfo(), [%s]", e2.getMessage());
            query = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        }
        if (query == null) {
            Log.e("MicroMsg.AddressBookUtil", "getMobileInfo: mobile is null");
            AppMethodBeat.o(151611);
            return linkedList;
        }
        try {
            if (query.getCount() <= 0 || !query.moveToFirst()) {
                query.close();
                AppMethodBeat.o(151611);
                return linkedList;
            }
            do {
                String string = query.getString(query.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME));
                linkedList.add(new String[]{query.getString(query.getColumnIndex("contact_id")), string, query.getString(query.getColumnIndex("data1")), query.getString(query.getColumnIndex("raw_contact_id"))});
            } while (query.moveToNext());
            query.close();
            AppMethodBeat.o(151611);
            return linkedList;
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.AddressBookUtil", e3, "", new Object[0]);
            Log.e("MicroMsg.AddressBookUtil", "exception in getMoblieOrderInfo()2, [%s]", e3.getMessage());
            query.close();
        } catch (Throwable th) {
            query.close();
            AppMethodBeat.o(151611);
            throw th;
        }
    }

    public static List<String[]> ij(Context context) {
        AppMethodBeat.i(151612);
        LinkedList linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        if (!com.tencent.mm.pluginsdk.permission.b.k(context, "android.permission.READ_CONTACTS", false)) {
            Log.e("MicroMsg.AddressBookUtil", "no contact permission");
            AppMethodBeat.o(151612);
            return linkedList;
        }
        try {
            Cursor query = contentResolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, null, null, null);
            if (query == null) {
                AppMethodBeat.o(151612);
                return linkedList;
            }
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(query.getColumnIndex("data1"));
                    linkedList.add(new String[]{query.getString(query.getColumnIndex("contact_id")), query.getString(query.getColumnIndex("data4")), string, query.getString(query.getColumnIndex("raw_contact_id")), query.getString(query.getColumnIndex("photo_id"))});
                } while (query.moveToNext());
            }
            query.close();
            AppMethodBeat.o(151612);
            return linkedList;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AddressBookUtil", e2, "getEmailInfo", new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> ik(android.content.Context r9) {
        /*
        // Method dump skipped, instructions count: 161
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.b.ik(android.content.Context):java.util.List");
    }

    public static String k(String str, Context context) {
        Cursor cursor;
        String str2;
        AppMethodBeat.i(151614);
        if (!com.tencent.mm.pluginsdk.permission.b.k(context, "android.permission.READ_CONTACTS", false)) {
            Log.e("MicroMsg.AddressBookUtil", "no contact permission");
            AppMethodBeat.o(151614);
            return "";
        }
        try {
            cursor = context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{SlookAirButtonFrequentContactAdapter.DISPLAY_NAME}, "_id = ?", new String[]{str}, null);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AddressBookUtil", e2, "getContactNameById:", new Object[0]);
            cursor = null;
        }
        if (cursor == null) {
            AppMethodBeat.o(151614);
            return "";
        }
        if (cursor.moveToFirst()) {
            str2 = cursor.getString(0);
        } else {
            str2 = "";
        }
        cursor.close();
        AppMethodBeat.o(151614);
        return str2;
    }

    public static Uri glF() {
        try {
            return ContactsContract.Contacts.CONTENT_URI;
        } catch (Exception e2) {
            return null;
        }
    }

    public static Bitmap a(String str, Context context, boolean z) {
        AppMethodBeat.i(151615);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(151615);
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            InputStream openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, Util.safeParseLong(str)), z);
            if (openContactPhotoInputStream == null) {
                AppMethodBeat.o(151615);
                return null;
            }
            Bitmap decodeStream = BitmapUtil.decodeStream(openContactPhotoInputStream);
            if (decodeStream != null) {
                decodeStream = BitmapUtil.getRoundedCornerBitmap(decodeStream, true, 4.0f);
            }
            AppMethodBeat.o(151615);
            return decodeStream;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AddressBookUtil", e2, "getAvatar, contactId:%s", str);
            AppMethodBeat.o(151615);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0125  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.lang.String r11, android.content.Context r12, byte[] r13) {
        /*
        // Method dump skipped, instructions count: 310
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.b.b(java.lang.String, android.content.Context, byte[]):boolean");
    }
}
