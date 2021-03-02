package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.k.a.a.c;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.ListIterator;

public final class ak extends MStorageEx implements b {
    private static final String[] NRG = {"CREATE INDEX IF NOT EXISTS  ChatroomMsgSeqTalkerIndex ON ChatroomMsgSeq ( username )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(aj.info, "ChatroomMsgSeq")};
    private h iFy;

    static {
        AppMethodBeat.i(116965);
        AppMethodBeat.o(116965);
    }

    public ak(h hVar) {
        AppMethodBeat.i(116942);
        this.iFy = hVar;
        hVar.execSQL("ChatroomMsgSeq", NRG[0]);
        AppMethodBeat.o(116942);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final long a(aj ajVar) {
        AppMethodBeat.i(116943);
        long a2 = a(ajVar, false);
        AppMethodBeat.o(116943);
        return a2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final long a(aj ajVar, boolean z) {
        AppMethodBeat.i(116944);
        if (ajVar == null) {
            AppMethodBeat.o(116944);
            return -1;
        }
        long a2 = this.iFy.a("ChatroomMsgSeq", ch.COL_USERNAME, ajVar.convertTo());
        if (a2 >= 0) {
            b.a aVar = new b.a();
            aVar.id = 4;
            aVar.username = ajVar.field_username;
            aVar.zqi = z;
            doNotify(4, this, aVar);
        }
        AppMethodBeat.o(116944);
        return a2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final long b(aj ajVar) {
        AppMethodBeat.i(116945);
        if (ajVar == null) {
            AppMethodBeat.o(116945);
            return -1;
        }
        ContentValues convertTo = ajVar.convertTo();
        long update = (long) this.iFy.update("ChatroomMsgSeq", convertTo, "username = ?", new String[]{ajVar.field_username});
        AppMethodBeat.o(116945);
        return update;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final long aDZ(String str) {
        AppMethodBeat.i(116946);
        long delete = (long) this.iFy.delete("ChatroomMsgSeq", "username = ?", new String[]{str});
        AppMethodBeat.o(116946);
        return delete;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final boolean eiA() {
        AppMethodBeat.i(116947);
        long delete = (long) this.iFy.delete("ChatroomMsgSeq", "", null);
        Log.w("MicroMsg.ChatroomMsgSeqStorage", "[deleteTable] result:" + delete + " table:ChatroomMsgSeq");
        if (delete >= 0) {
            AppMethodBeat.o(116947);
            return true;
        }
        AppMethodBeat.o(116947);
        return false;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final long aEa(String str) {
        AppMethodBeat.i(116948);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(116948);
            return -1;
        }
        Cursor rawQuery = this.iFy.rawQuery("select lastPushSeq from ChatroomMsgSeq where username = \"" + Util.escapeSqlValue(String.valueOf(str)) + "\"", null, 2);
        if (rawQuery == null) {
            Log.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(116948);
            return -2;
        } else if (rawQuery.moveToFirst()) {
            long j2 = rawQuery.getLong(0);
            rawQuery.close();
            AppMethodBeat.o(116948);
            return j2;
        } else {
            rawQuery.close();
            AppMethodBeat.o(116948);
            return -3;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final long aEc(String str) {
        AppMethodBeat.i(116949);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(116949);
            return -1;
        }
        Cursor rawQuery = this.iFy.rawQuery("select lastPushCreateTime from ChatroomMsgSeq where username = \"" + Util.escapeSqlValue(String.valueOf(str)) + "\"", null, 2);
        if (rawQuery == null) {
            Log.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(116949);
            return -2;
        } else if (rawQuery.moveToFirst()) {
            long j2 = rawQuery.getLong(0);
            rawQuery.close();
            AppMethodBeat.o(116949);
            return j2;
        } else {
            rawQuery.close();
            AppMethodBeat.o(116949);
            return -3;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final long aEb(String str) {
        AppMethodBeat.i(116950);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(116950);
            return -1;
        }
        Cursor rawQuery = this.iFy.rawQuery("select lastLocalSeq from ChatroomMsgSeq where username = \"" + Util.escapeSqlValue(String.valueOf(str)) + "\"", null, 2);
        if (rawQuery == null) {
            Log.i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(116950);
            return -2;
        } else if (rawQuery.moveToFirst()) {
            long j2 = rawQuery.getLong(0);
            rawQuery.close();
            AppMethodBeat.o(116950);
            return j2;
        } else {
            rawQuery.close();
            AppMethodBeat.o(116950);
            return -3;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final long aEd(String str) {
        AppMethodBeat.i(116951);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(116951);
            return -1;
        }
        Cursor rawQuery = this.iFy.rawQuery("select lastLocalCreateTime from ChatroomMsgSeq where username = \"" + Util.escapeSqlValue(String.valueOf(str)) + "\"", null, 2);
        if (rawQuery == null) {
            Log.i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(116951);
            return -2;
        } else if (rawQuery.moveToFirst()) {
            long j2 = rawQuery.getLong(0);
            rawQuery.close();
            AppMethodBeat.o(116951);
            return j2;
        } else {
            rawQuery.close();
            AppMethodBeat.o(116951);
            return -3;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final boolean aB(String str, long j2) {
        AppMethodBeat.i(116952);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(116952);
            return false;
        }
        boolean execSQL = this.iFy.execSQL("ChatroomMsgSeq", "update ChatroomMsgSeq set lastPushSeq =  " + j2 + " where username = \"" + Util.escapeSqlValue(str) + "\"");
        if (execSQL) {
            b.a aVar = new b.a();
            aVar.id = 4;
            aVar.username = str;
            doNotify(2, this, aVar);
        }
        AppMethodBeat.o(116952);
        return execSQL;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final boolean aC(String str, long j2) {
        AppMethodBeat.i(116953);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(116953);
            return false;
        }
        boolean execSQL = this.iFy.execSQL("ChatroomMsgSeq", "update ChatroomMsgSeq set lastLocalCreateTime =  " + j2 + " where username = \"" + Util.escapeSqlValue(str) + "\"");
        AppMethodBeat.o(116953);
        return execSQL;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final boolean aD(String str, long j2) {
        AppMethodBeat.i(116954);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(116954);
            return false;
        }
        boolean execSQL = this.iFy.execSQL("ChatroomMsgSeq", "update ChatroomMsgSeq set lastPushCreateTime =  " + j2 + " where username = \"" + Util.escapeSqlValue(str) + "\"");
        AppMethodBeat.o(116954);
        return execSQL;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final boolean aE(String str, long j2) {
        AppMethodBeat.i(116955);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(116955);
            return false;
        }
        boolean execSQL = this.iFy.execSQL("ChatroomMsgSeq", "update ChatroomMsgSeq set lastLocalSeq =  " + j2 + " where username = \"" + Util.escapeSqlValue(str) + "\"");
        AppMethodBeat.o(116955);
        return execSQL;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final d aEe(String str) {
        AppMethodBeat.i(116956);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed username is null!");
            d dVar = new d();
            AppMethodBeat.o(116956);
            return dVar;
        }
        Cursor rawQuery = this.iFy.rawQuery("select seqBlockInfo from ChatroomMsgSeq where username = \"" + Util.escapeSqlValue(String.valueOf(str)) + "\"", null, 2);
        if (rawQuery == null) {
            Log.e("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed ".concat(String.valueOf(str)));
            d dVar2 = new d();
            AppMethodBeat.o(116956);
            return dVar2;
        } else if (rawQuery.moveToFirst()) {
            byte[] blob = rawQuery.getBlob(0);
            if (Util.isNullOrNil(blob)) {
                rawQuery.close();
                d dVar3 = new d();
                AppMethodBeat.o(116956);
                return dVar3;
            }
            d dVar4 = new d();
            try {
                dVar4.parseFrom(blob);
            } catch (Exception e2) {
            }
            rawQuery.close();
            AppMethodBeat.o(116956);
            return dVar4;
        } else {
            rawQuery.close();
            d dVar5 = new d();
            AppMethodBeat.o(116956);
            return dVar5;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final boolean a(String str, d dVar) {
        AppMethodBeat.i(116957);
        if (str == null || str.length() <= 0) {
            Log.e("MicroMsg.ChatroomMsgSeqStorage", "updateSeqBlockInfo failed");
            AppMethodBeat.o(116957);
            return false;
        }
        byte[] bArr = new byte[0];
        try {
            bArr = dVar.toByteArray();
        } catch (Exception e2) {
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("seqBlockInfo", bArr);
        if (this.iFy.update("ChatroomMsgSeq", contentValues, "username = ?", new String[]{Util.escapeSqlValue(str)}) > 0) {
            AppMethodBeat.o(116957);
            return true;
        }
        AppMethodBeat.o(116957);
        return false;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final boolean aEf(String str) {
        AppMethodBeat.i(116958);
        Cursor rawQuery = this.iFy.rawQuery("select count(*) from ChatroomMsgSeq where username = \"" + Util.escapeSqlValue(String.valueOf(str)) + "\"", null, 2);
        if (rawQuery == null) {
            Log.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(116958);
            return false;
        } else if (rawQuery.moveToFirst()) {
            long j2 = rawQuery.getLong(0);
            rawQuery.close();
            if (j2 > 0) {
                AppMethodBeat.o(116958);
                return true;
            }
            AppMethodBeat.o(116958);
            return false;
        } else {
            rawQuery.close();
            AppMethodBeat.o(116958);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final c aEg(String str) {
        AppMethodBeat.i(116959);
        d aEe = aEe(str);
        if (aEe.gCC.size() <= 0) {
            AppMethodBeat.o(116959);
            return null;
        }
        c last = aEe.gCC.getLast();
        AppMethodBeat.o(116959);
        return last;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final c e(String str, long j2, boolean z) {
        AppMethodBeat.i(116960);
        d aEe = aEe(str);
        if (aEe.gCC.size() <= 0) {
            AppMethodBeat.o(116960);
            return null;
        }
        Iterator<c> it = aEe.gCC.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z) {
                if (next.gCB > j2) {
                    AppMethodBeat.o(116960);
                    return next;
                }
            } else if (next.gCA > j2) {
                AppMethodBeat.o(116960);
                return next;
            }
        }
        AppMethodBeat.o(116960);
        return null;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final c aF(String str, long j2) {
        AppMethodBeat.i(116961);
        d aEe = aEe(str);
        if (aEe.gCC.size() <= 0) {
            AppMethodBeat.o(116961);
            return null;
        }
        ListIterator<c> listIterator = aEe.gCC.listIterator(aEe.gCC.size());
        while (listIterator.hasPrevious()) {
            c previous = listIterator.previous();
            if (previous.gCA < j2) {
                AppMethodBeat.o(116961);
                return previous;
            }
        }
        AppMethodBeat.o(116961);
        return null;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final aj aEh(String str) {
        AppMethodBeat.i(116962);
        Log.i("MicroMsg.ChatroomMsgSeqStorage", "[getChatroomMsgSeq] username:%s", str);
        aj ajVar = new aj();
        Cursor rawQuery = this.iFy.rawQuery("select * from ChatroomMsgSeq where username = \"" + Util.escapeSqlValue(String.valueOf(str)) + "\"", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(116962);
        } else {
            if (rawQuery.moveToFirst()) {
                ajVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(116962);
        }
        return ajVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final StringBuilder aEi(String str) {
        AppMethodBeat.i(116963);
        StringBuilder sb = new StringBuilder();
        d dVar = aEh(str).field_seqBlockInfo;
        if (dVar == null) {
            AppMethodBeat.o(116963);
            return sb;
        }
        for (c cVar : dVar.gCC) {
            sb.append("[").append(cVar.gCy).append(":").append(cVar.gCz).append("][").append(cVar.gCA).append(":").append(cVar.gCB).append("] | ");
        }
        AppMethodBeat.o(116963);
        return sb;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.b
    public final int A(String str, long j2, long j3) {
        int i2 = 0;
        AppMethodBeat.i(116964);
        d dVar = aEh(str).field_seqBlockInfo;
        if (dVar == null) {
            Log.i("MicroMsg.ChatroomMsgSeqStorage", "[getBlockCount] seqBlockInfo is null!");
            AppMethodBeat.o(116964);
            return 0;
        }
        Iterator<c> it = dVar.gCC.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                c next = it.next();
                if (j2 <= next.gCA && next.gCB <= j3) {
                    i3++;
                }
                i2 = i3;
            } else {
                AppMethodBeat.o(116964);
                return i3;
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx
    public final boolean shouldProcessEvent() {
        return true;
    }
}
