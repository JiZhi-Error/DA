package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Map;

public final class cf extends MAutoStorage<ce> {
    public static volatile boolean Orv = false;
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(ce.info, "NotifyMessageRecord")};
    public ISQLiteDatabaseEx kOg;

    static {
        AppMethodBeat.i(232429);
        AppMethodBeat.o(232429);
    }

    public cf(ISQLiteDatabaseEx iSQLiteDatabaseEx) {
        this(iSQLiteDatabaseEx, ce.info, "NotifyMessageRecord");
    }

    private cf(ISQLiteDatabaseEx iSQLiteDatabaseEx, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str) {
        super(iSQLiteDatabaseEx, mAutoDBInfo, str, null);
        this.kOg = iSQLiteDatabaseEx;
    }

    public static boolean gEg() {
        return Orv;
    }

    public final boolean e(ca caVar, String str) {
        AppMethodBeat.i(232419);
        ce ceVar = new ce();
        ceVar.field_msgId = caVar.field_msgId;
        ceVar.field_talker = caVar.field_talker;
        ceVar.field_createTime = caVar.field_createTime;
        ceVar.field_digest = str;
        boolean insert = super.insert(ceVar);
        AppMethodBeat.o(232419);
        return insert;
    }

    public final boolean bb(ca caVar) {
        AppMethodBeat.i(232420);
        ce ceVar = new ce();
        ceVar.field_msgId = caVar.field_msgId;
        boolean delete = super.delete(ceVar, new String[0]);
        AppMethodBeat.o(232420);
        return delete;
    }

    public final boolean f(ca caVar, String str) {
        AppMethodBeat.i(232421);
        ce ceVar = new ce();
        ceVar.field_msgId = caVar.field_msgId;
        ceVar.field_talker = caVar.field_talker;
        ceVar.field_createTime = caVar.field_createTime;
        ceVar.field_digest = str;
        boolean update = super.update(ceVar, new String[0]);
        AppMethodBeat.o(232421);
        return update;
    }

    public final int gEh() {
        Cursor cursor = null;
        int i2 = 0;
        AppMethodBeat.i(232422);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT COUNT(*) FROM message WHERE talker = '").append(Util.escapeSqlValue("notifymessage")).append("'");
            cursor = this.kOg.rawQuery(sb.toString(), null);
            cursor.moveToFirst();
            if (cursor.moveToLast()) {
                i2 = cursor.getInt(0);
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[getNotifyMessageCount] exception %s", e2.toString());
        }
        if (cursor != null) {
            cursor.close();
        }
        AppMethodBeat.o(232422);
        return i2;
    }

    public final int gEi() {
        Cursor cursor = null;
        int i2 = 0;
        AppMethodBeat.i(232423);
        try {
            cursor = this.kOg.rawQuery("SELECT COUNT(*) FROM NotifyMessageRecord", null);
            cursor.moveToFirst();
            if (cursor.moveToLast()) {
                i2 = cursor.getInt(0);
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[getNotifyMessageRecordCount] exception %s", e2.toString());
        }
        if (cursor != null) {
            cursor.close();
        }
        AppMethodBeat.o(232423);
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean gEj() {
        /*
        // Method dump skipped, instructions count: 212
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.cf.gEj():boolean");
    }

    public final Cursor gEk() {
        AppMethodBeat.i(232425);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT talker,msgId,MAX(createTime) AS createTime").append(",digest FROM NotifyMessageRecord WHERE talker IS NOT NULL AND LENGTH(talker").append(") > 0 GROUP BY talker ORDER BY createTime DESC");
            Cursor rawQuery = this.kOg.rawQuery(sb.toString(), null);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                AppMethodBeat.o(232425);
                return rawQuery;
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[getNotifyMsgConversationCursor] exception %s", e2.toString());
        }
        AppMethodBeat.o(232425);
        return null;
    }

    public final Cursor J(String str, int i2, long j2) {
        AppMethodBeat.i(232426);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ( SELECT * FROM message AS MESSAGE INNER JOIN NotifyMessageRecord AS NOTIFY_RECORD").append(" ON MESSAGE.msgId = NOTIFY_RECORD.msgId").append(" WHERE NOTIFY_RECORD.talker = '").append(Util.escapeSqlValue(str)).append("'").append(j2 > 0 ? " AND createTime > ".concat(String.valueOf(j2)) : "").append(" ORDER BY MESSAGE.createTime DESC LIMIT ").append(i2).append(") ORDER BY createTime ASC");
            Cursor rawQuery = this.kOg.rawQuery(sb.toString(), null);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                AppMethodBeat.o(232426);
                return rawQuery;
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.NotifyMessageRecordStorage", "dz[getCursor] exception %s", e2.toString());
        }
        AppMethodBeat.o(232426);
        return null;
    }

    public static String bd(ca caVar) {
        AppMethodBeat.i(232428);
        String b2 = h.b(caVar, new PString(), new PString(), new PInt(), false);
        AppMethodBeat.o(232428);
        return b2;
    }

    public static String bc(ca caVar) {
        String str = null;
        AppMethodBeat.i(232427);
        Map<String, String> parseXml = XmlParser.parseXml(caVar.field_content, "msg", null);
        if (parseXml != null) {
            str = Util.nullAsNil(parseXml.get(".msg.fromusername"));
        } else {
            Log.i("MicroMsg.NotifyMessageRecordStorage", "not template message, can't find username field from content");
        }
        AppMethodBeat.o(232427);
        return str;
    }
}
