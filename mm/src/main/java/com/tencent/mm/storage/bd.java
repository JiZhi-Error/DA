package com.tencent.mm.storage;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDoneException;

public final class bd extends MStorage implements c {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS DeletedConversationInfo ( userName TEXT  PRIMARY KEY , lastSeq LONG  , reserved1 INT  , reserved2 LONG  , reserved3 TEXT  ) ", "CREATE INDEX IF NOT EXISTS createTimeIndex  ON DeletedConversationInfo ( reserved2 )"};
    private final f<String, Long> gAU = new com.tencent.mm.memory.a.c(50);
    private h iFy;

    public bd(h hVar) {
        AppMethodBeat.i(117141);
        this.iFy = hVar;
        AppMethodBeat.o(117141);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.c
    public final boolean aG(String str, long j2) {
        AppMethodBeat.i(117142);
        if (str == null) {
            AppMethodBeat.o(117142);
            return false;
        }
        SQLiteDatabase gFH = this.iFy.gFH();
        try {
            gFH.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("lastSeq", Long.valueOf(j2));
            if (!(gFH.update("DeletedConversationInfo", contentValues, "userName=?", new String[]{str}) > 0)) {
                contentValues.put("userName", str);
                contentValues.put("lastSeq", Long.valueOf(j2));
                contentValues.put("reserved2", (Integer) 0);
                gFH.replace("DeletedConversationInfo", "userName", contentValues);
            }
            gFH.setTransactionSuccessful();
            if (gFH.inTransaction()) {
                gFH.endTransaction();
            }
            doNotify(str);
            AppMethodBeat.o(117142);
            return true;
        } catch (IllegalStateException e2) {
            Log.printErrStackTrace("MicroMsg.DeletedConversationInfoStorage", e2, "replaceLastSeq failed", new Object[0]);
            if (gFH.inTransaction()) {
                gFH.endTransaction();
            }
            AppMethodBeat.o(117142);
            return false;
        } catch (Throwable th) {
            if (gFH.inTransaction()) {
                gFH.endTransaction();
            }
            AppMethodBeat.o(117142);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.c
    public final long aEj(String str) {
        AppMethodBeat.i(117143);
        if (str == null) {
            AppMethodBeat.o(117143);
            return 0;
        }
        long p = p("SELECT max(lastSeq) FROM DeletedConversationInfo WHERE userName=? OR userName=''", new String[]{str});
        AppMethodBeat.o(117143);
        return p;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.c
    public final boolean aH(String str, long j2) {
        AppMethodBeat.i(117144);
        SQLiteDatabase gFH = this.iFy.gFH();
        try {
            gFH.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("reserved2", Long.valueOf(j2));
            if (!(gFH.update("DeletedConversationInfo", contentValues, "userName=?", new String[]{str}) > 0)) {
                contentValues.put("userName", str);
                contentValues.put("lastSeq", (Integer) 0);
                contentValues.put("reserved2", Long.valueOf(j2));
                gFH.replace("DeletedConversationInfo", "userName", contentValues);
            }
            gFH.setTransactionSuccessful();
            if (str == null || !str.isEmpty()) {
                this.gAU.put(str, Long.valueOf(j2));
            } else {
                this.gAU.clear();
            }
            if (gFH.isOpen() && gFH.inTransaction()) {
                gFH.endTransaction();
            }
            doNotify(str);
            AppMethodBeat.o(117144);
            return true;
        } catch (IllegalStateException e2) {
            Log.printErrStackTrace("MicroMsg.DeletedConversationInfoStorage", e2, "replaceCreateTime failed", new Object[0]);
            if (gFH.isOpen() && gFH.inTransaction()) {
                gFH.endTransaction();
            }
            AppMethodBeat.o(117144);
            return false;
        } catch (Throwable th) {
            if (gFH.isOpen() && gFH.inTransaction()) {
                gFH.endTransaction();
            }
            AppMethodBeat.o(117144);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0056  */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.Long> eiB() {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.bd.eiB():java.util.Map");
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.c
    public final long aEk(String str) {
        AppMethodBeat.i(117146);
        if (str == null) {
            AppMethodBeat.o(117146);
            return 0;
        }
        Long l = this.gAU.get(str);
        if (l != null) {
            long longValue = l.longValue();
            AppMethodBeat.o(117146);
            return longValue;
        }
        long p = p("SELECT max(reserved2) FROM DeletedConversationInfo WHERE userName=? OR userName=''", new String[]{str});
        this.gAU.put(str, Long.valueOf(p));
        AppMethodBeat.o(117146);
        return p;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.c
    public final boolean eiC() {
        AppMethodBeat.i(177111);
        if (p("SELECT reserved2 FROM DeletedConversationInfo WHERE reserved2 > 0 LIMIT 1", null) > 0) {
            AppMethodBeat.o(177111);
            return true;
        }
        AppMethodBeat.o(177111);
        return false;
    }

    private long p(String str, String[] strArr) {
        long j2 = 0;
        AppMethodBeat.i(177112);
        try {
            j2 = DatabaseUtils.longForQuery(this.iFy.gFH(), str, strArr);
            AppMethodBeat.o(177112);
        } catch (SQLiteDoneException e2) {
            AppMethodBeat.o(177112);
        } catch (IllegalStateException e3) {
            Log.printErrStackTrace("MicroMsg.DeletedConversationInfoStorage", e3, "longForQuery failed", new Object[0]);
            AppMethodBeat.o(177112);
        }
        return j2;
    }
}
