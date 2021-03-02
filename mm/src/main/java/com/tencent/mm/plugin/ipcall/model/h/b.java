package com.tencent.mm.plugin.ipcall.model.h;

import android.database.Cursor;
import android.provider.ContactsContract;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class b {
    public static final String gAH = new String(Character.toChars(91));
    private static HashMap<String, c> ysD = new HashMap<>();

    static {
        AppMethodBeat.i(25535);
        AppMethodBeat.o(25535);
    }

    public static ArrayList<c> eaV() {
        AppMethodBeat.i(25531);
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<c> arrayList = new ArrayList<>();
        if (!com.tencent.mm.pluginsdk.permission.b.n(MMApplicationContext.getContext(), "android.permission.READ_CONTACTS")) {
            Log.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
            AppMethodBeat.o(25531);
            return arrayList;
        }
        Cursor query = MMApplicationContext.getContext().getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"contact_id", SlookAirButtonFrequentContactAdapter.DISPLAY_NAME, "data1"}, "mimetype='vnd.android.cursor.item/phone_v2'", null, null);
        HashMap<String, c> hashMap = new HashMap<>();
        Log.d("MicroMsg.IPCallAddressBookInfoExtracter", "query FromSystemPhoneBook, time: " + (System.currentTimeMillis() - currentTimeMillis));
        if (query == null) {
            AppMethodBeat.o(25531);
            return arrayList;
        }
        try {
            Log.d("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook, count: %d", Integer.valueOf(query.getCount()));
            if (query.moveToFirst()) {
                int columnIndex = query.getColumnIndex("contact_id");
                int columnIndex2 = query.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                int columnIndex3 = query.getColumnIndex("data1");
                while (!query.isAfterLast()) {
                    c a2 = a(query, columnIndex, columnIndex2, columnIndex3);
                    if (a2 != null && a2.ysE != null && a2.ysE.size() > 0 && !Util.isNullOrNil(a2.field_contactId)) {
                        if (hashMap.containsKey(a2.field_contactId)) {
                            c cVar = hashMap.get(a2.field_contactId);
                            if (a2.ysE.size() > 0 && !cVar.ysE.contains(a2.ysE.get(0))) {
                                cVar.ysE.add(a2.ysE.get(0));
                            }
                        } else {
                            hashMap.put(a2.field_contactId, a2);
                        }
                    }
                    query.moveToNext();
                }
            }
            query.close();
        } catch (Exception e2) {
            Log.e("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook error: %s, class: %s", e2.getMessage(), e2.getClass().getSimpleName());
            query.close();
        } catch (Throwable th) {
            query.close();
            AppMethodBeat.o(25531);
            throw th;
        }
        arrayList.addAll(hashMap.values());
        ysD = hashMap;
        Log.d("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook, result size: %d, used %dms", Integer.valueOf(arrayList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(25531);
        return arrayList;
    }

    public static HashMap<String, c> eaW() {
        return ysD;
    }

    public static HashMap<String, c> eaX() {
        AppMethodBeat.i(25532);
        eaV();
        HashMap<String, c> hashMap = ysD;
        AppMethodBeat.o(25532);
        return hashMap;
    }

    public static ArrayList<String> aBU(String str) {
        AppMethodBeat.i(25533);
        ArrayList<String> arrayList = new ArrayList<>();
        if (!com.tencent.mm.pluginsdk.permission.b.n(MMApplicationContext.getContext(), "android.permission.READ_CONTACTS")) {
            Log.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
            AppMethodBeat.o(25533);
            return arrayList;
        }
        Cursor query = MMApplicationContext.getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
        if (query == null) {
            AppMethodBeat.o(25533);
            return arrayList;
        }
        try {
            if (query.moveToFirst()) {
                while (!query.isAfterLast()) {
                    arrayList.add(query.getString(query.getColumnIndex("data1")));
                    query.moveToNext();
                }
            }
            query.close();
        } catch (Exception e2) {
            Log.e("MicroMsg.IPCallAddressBookInfoExtracter", "extractAddressItemFromCursor, error: %s, class: %s", e2.getMessage(), e2.getClass().getSimpleName());
            query.close();
        } catch (Throwable th) {
            query.close();
            AppMethodBeat.o(25533);
            throw th;
        }
        AppMethodBeat.o(25533);
        return arrayList;
    }

    private static c a(Cursor cursor, int i2, int i3, int i4) {
        String str;
        String str2 = null;
        AppMethodBeat.i(25534);
        if (!com.tencent.mm.pluginsdk.permission.b.n(MMApplicationContext.getContext(), "android.permission.READ_CONTACTS")) {
            Log.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
            AppMethodBeat.o(25534);
            return null;
        }
        c cVar = new c();
        cVar.ysE = new ArrayList<>();
        String string = cursor.getString(i2);
        String string2 = cursor.getString(i3);
        String string3 = cursor.getString(i4);
        cVar.field_contactId = string;
        cVar.field_systemAddressBookUsername = string2;
        if (!Util.isNullOrNil(string3) && !cVar.ysE.contains(string3)) {
            cVar.ysE.add(string3);
        }
        if (Util.isNullOrNil(cVar.field_systemAddressBookUsername) && cVar.ysE.size() > 0) {
            cVar.field_systemAddressBookUsername = cVar.ysE.get(0);
        }
        Iterator<String> it = cVar.ysE.iterator();
        String str3 = null;
        while (true) {
            if (!it.hasNext()) {
                str = str3;
                break;
            }
            str = a.aCs(it.next());
            if (Util.isNullOrNil(str)) {
                str = str3;
            } else if (!str.endsWith("@stranger")) {
                break;
            }
            str3 = str;
        }
        if (!Util.isNullOrNil(str)) {
            cVar.field_wechatUsername = str;
        }
        if (!Util.isNullOrNil(cVar.field_systemAddressBookUsername)) {
            try {
                str2 = f.Sh(cVar.field_systemAddressBookUsername);
            } catch (Exception e2) {
                Log.d("MicroMsg.IPCallAddressBookInfoExtracter", "getFullSpell error: %s, class: %s", e2.getMessage(), e2.getClass().getSimpleName());
            }
            if (Util.isNullOrNil(str2)) {
                cVar.field_sortKey = "";
            } else if (!Character.isLetter(str2.charAt(0))) {
                cVar.field_sortKey = gAH + str2.toUpperCase();
            } else {
                cVar.field_sortKey = str2.toUpperCase();
            }
        } else {
            cVar.field_sortKey = "";
        }
        AppMethodBeat.o(25534);
        return cVar;
    }
}
