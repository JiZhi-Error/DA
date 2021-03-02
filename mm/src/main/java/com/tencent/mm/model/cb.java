package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class cb {
    private ISQLiteDatabase db;
    private bw iFE;

    public cb(ISQLiteDatabase iSQLiteDatabase, bw bwVar) {
        this.db = iSQLiteDatabase;
        this.iFE = bwVar;
    }

    private String KF(String str) {
        String str2;
        AppMethodBeat.i(20392);
        ArrayList arrayList = new ArrayList();
        String str3 = "select username from rcontact where (username like '%" + str + "%' or nickname like '%" + str + "%' or alias like '%" + str + "%' or pyInitial like '%" + str + "%' or quanPin like '%" + str + "%' or conRemark like '%" + str + "%' )and username not like '%@%' and type & " + c.aru() + "=0 ";
        Cursor rawQuery = this.db.rawQuery(str3, null, 2);
        Log.v("Micro.SimpleSearchConversationModel", "contactsql %s", str3);
        while (rawQuery.moveToNext()) {
            String string = rawQuery.getString(rawQuery.getColumnIndex(ch.COL_USERNAME));
            if (!string.endsWith("@chatroom")) {
                arrayList.add(string);
            }
        }
        rawQuery.close();
        if (arrayList.size() != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" ( rconversation.username in ( select chatroomname from " + "chatroom where ");
            stringBuffer.append("memberlist like '%" + str + "%'");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                stringBuffer.append(" or memberlist like '%" + ((String) it.next()) + "%'");
            }
            stringBuffer.append("))");
            str2 = "" + stringBuffer.toString() + " or ";
        } else {
            str2 = "";
        }
        String str4 = " and ( rconversation.username like '%" + str + "%' or " + str2 + "rconversation.content like '%" + str + "%' or rcontact.nickname like '%" + str + "%' or rcontact.alias like '%" + str + "%' or rcontact.pyInitial like '%" + str + "%' or rcontact.quanPin like '%" + str + "%' or rcontact.conRemark like '%" + str + "%'  ) ";
        AppMethodBeat.o(20392);
        return str4;
    }

    public final Cursor a(String str, List<String> list, String str2) {
        AppMethodBeat.i(20391);
        String str3 = " ";
        if (str2 != null && str2.length() > 0) {
            str3 = " and rconversation.username = rcontact." + "username ";
        }
        String str4 = "select 1,unReadCount, status, " + "isSend, conversationTime, rconversation.username, " + "content, rconversation.msgType, rconversation." + "flag, rcontact.nickname from rconversation," + "rcontact" + " " + " where rconversation.username = rcontact.username" + str3 + Util.nullAsNil(str);
        String str5 = "";
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                str5 = str5 + " and rconversation.username != '" + it.next() + "'";
            }
            str5 = str5;
        }
        String str6 = str4 + str5;
        if (str2 != null && str2.length() > 0) {
            str6 = str6 + KF(str2);
        }
        String str7 = ((str6 + " order by ") + "rconversation.username like '%@chatroom' asc, ") + "flag desc, conversationTime desc";
        Log.v("Micro.SimpleSearchConversationModel", "convsql %s", str7);
        Cursor rawQuery = this.db.rawQuery(str7, null);
        AppMethodBeat.o(20391);
        return rawQuery;
    }
}
