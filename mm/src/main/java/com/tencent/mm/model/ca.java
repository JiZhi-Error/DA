package com.tencent.mm.model;

import android.database.Cursor;
import android.database.MergeCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ca {
    private ISQLiteDatabase db;
    private bv iFD;

    public ca(ISQLiteDatabase iSQLiteDatabase, bv bvVar) {
        this.db = iSQLiteDatabase;
        this.iFD = bvVar;
    }

    public final Cursor a(String str, String str2, List<String> list, boolean z) {
        AppMethodBeat.i(20385);
        Cursor a2 = a(str, str2, list, z, 1, null);
        AppMethodBeat.o(20385);
        return a2;
    }

    public final Cursor a(String str, String str2, List<String> list, List<String> list2) {
        AppMethodBeat.i(20386);
        Cursor a2 = a(str, str2, list, true, 2, list2);
        AppMethodBeat.o(20386);
        return a2;
    }

    public final Cursor b(String str, String str2, List<String> list, List<String> list2) {
        AppMethodBeat.i(20387);
        Cursor a2 = a(str, str2, list, true, 2, list2);
        AppMethodBeat.o(20387);
        return a2;
    }

    public final Cursor a(String str, String str2, List<String> list, boolean z, int i2, List<String> list2) {
        Cursor cursor;
        AppMethodBeat.i(20388);
        String str3 = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact ";
        if (i2 == 2) {
            str3 = "select 2, *,rowid from rcontact ";
        }
        String str4 = str3 + this.iFD.f(str2, null, list) + this.iFD.bjR(str) + this.iFD.aZD();
        Log.v("Micro.SimpleSearchConversationModel", str4);
        Cursor rawQuery = this.db.rawQuery(str4, null);
        if (z) {
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(rawQuery.getColumnIndex(ch.COL_USERNAME));
                if (!ab.Eq(string)) {
                    arrayList.add(string);
                } else {
                    arrayList2.add(string);
                }
            }
            if (!(list2 == null || list2.size() == 0)) {
                arrayList.addAll(list2);
            }
            if (arrayList.size() != 0) {
                cursor = new MergeCursor(new Cursor[]{rawQuery, a(str, arrayList, arrayList2, null, list)});
                AppMethodBeat.o(20388);
                return cursor;
            }
        }
        cursor = rawQuery;
        AppMethodBeat.o(20388);
        return cursor;
    }

    public final Cursor a(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, List<String> list) {
        AppMethodBeat.i(20389);
        String str2 = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + this.iFD.f("@all.contact.android", "", list) + a(str, arrayList, arrayList2, arrayList3) + this.iFD.aZD();
        Log.v("Micro.SimpleSearchConversationModel", "roomsSql ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.db.rawQuery(str2, null);
        AppMethodBeat.o(20389);
        return rawQuery;
    }

    private static String a(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        AppMethodBeat.i(20390);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" and (username in (");
        stringBuffer.append("select chatroomname from chatroom where ");
        if (!(arrayList2 == null || arrayList2.size() == 0)) {
            Iterator<String> it = arrayList2.iterator();
            while (it.hasNext()) {
                stringBuffer.append("chatroomname != '" + it.next() + "' and ");
            }
        }
        stringBuffer.append("(memberlist like '%" + str + "%'");
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            stringBuffer.append(" or memberlist like '%" + it2.next() + "%'");
        }
        if (!(arrayList3 == null || arrayList3.size() == 0)) {
            Iterator<String> it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                stringBuffer.append(" or chatroomname = '" + it3.next() + "'");
            }
        }
        stringBuffer.append(")))");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(20390);
        return stringBuffer2;
    }
}
