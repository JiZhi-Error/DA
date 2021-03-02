package com.tencent.mm.live.b.c;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;

public final class c extends MAutoStorage<b> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(b.info, "LiveTipsBar")};
    public static Pair<String, Long> hLd;
    private static c hLe;
    public ISQLiteDatabase db;
    public a hLf;

    public interface a {
        void Ha(String str);
    }

    static {
        AppMethodBeat.i(224112);
        AppMethodBeat.o(224112);
    }

    private c(h hVar) {
        super(hVar, b.info, "LiveTipsBar", null);
        AppMethodBeat.i(224102);
        this.db = hVar;
        long currentTimeMillis = System.currentTimeMillis();
        long beginTransaction = hVar.beginTransaction(Thread.currentThread().getId());
        long currentTimeMillis2 = System.currentTimeMillis();
        Log.d("MicroMsg.LiveTipsBarStorage", "executeInitSQL:%s", "CREATE INDEX IF NOT EXISTS HostRoom ON LiveTipsBar ( hostRoomId )");
        hVar.execSQL("LiveTipsBar", "CREATE INDEX IF NOT EXISTS HostRoom ON LiveTipsBar ( hostRoomId )");
        Log.d("MicroMsg.LiveTipsBarStorage", "build new index last time[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        hVar.endTransaction(beginTransaction);
        Log.i("MicroMsg.LiveTipsBarStorage", "executeInitSQL last time[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(224102);
    }

    public static c getLiveTipsBarStorage() {
        AppMethodBeat.i(224103);
        g.aAi();
        g.aAf().azk();
        if (hLe == null) {
            hLe = new c(g.aAh().hqK);
        }
        c cVar = hLe;
        AppMethodBeat.o(224103);
        return cVar;
    }

    public final LinkedList<b> GX(String str) {
        String str2;
        AppMethodBeat.i(224104);
        LinkedList<b> linkedList = new LinkedList<>();
        if (hLd == null || !((String) hLd.first).equals(str)) {
            str2 = "SELECT * FROM LiveTipsBar WHERE hostRoomId = '" + str + "' ORDER BY timeStamp";
        } else {
            str2 = "SELECT * FROM LiveTipsBar WHERE hostRoomId = '" + str + "' AND liveId != '" + hLd.second + "' ORDER BY timeStamp";
        }
        Log.d("MicroMsg.LiveTipsBarStorage", "getTipsBarDataByHostRoomId:%s", str2);
        Cursor rawQuery = this.db.rawQuery(str2, null);
        if (rawQuery == null) {
            Log.e("MicroMsg.LiveTipsBarStorage", "getTipsBarDataByHostRoomId failed, hostRoomId:%s", str);
            AppMethodBeat.o(224104);
            return linkedList;
        }
        while (rawQuery.moveToNext()) {
            b bVar = new b();
            bVar.convertFrom(rawQuery);
            linkedList.add(bVar);
        }
        rawQuery.close();
        AppMethodBeat.o(224104);
        return linkedList;
    }

    public final boolean a(b bVar) {
        AppMethodBeat.i(224105);
        boolean insert = insert(bVar);
        if (this.hLf != null) {
            this.hLf.Ha(bVar.field_hostRoomId);
        }
        AppMethodBeat.o(224105);
        return insert;
    }

    public final boolean a(LinkedList<b> linkedList, String str) {
        AppMethodBeat.i(224106);
        boolean z = true;
        Iterator<b> it = linkedList.iterator();
        while (it.hasNext()) {
            if (!insert(it.next())) {
                z = false;
            } else {
                z = z;
            }
        }
        if (this.hLf != null) {
            this.hLf.Ha(str);
        }
        AppMethodBeat.o(224106);
        return z;
    }

    public final void zF(long j2) {
        String str;
        String str2;
        AppMethodBeat.i(224107);
        String str3 = "SELECT * FROM LiveTipsBar WHERE liveId = '" + j2 + "'";
        Log.d("MicroMsg.LiveTipsBarStorage", "deleteByLiveId, liveId:%d, sql:%s", Long.valueOf(j2), str3);
        Cursor rawQuery = this.db.rawQuery(str3, null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                b bVar = new b();
                bVar.convertFrom(rawQuery);
                str2 = bVar.field_hostRoomId;
            } else {
                str2 = null;
            }
            rawQuery.close();
            str = str2;
        } else {
            str = null;
        }
        int delete = this.db.delete("LiveTipsBar", "liveId= ? ", new String[]{String.valueOf(j2)});
        if (hLd != null && ((Long) hLd.second).longValue() == j2) {
            hLd = null;
        }
        if (delete < 0) {
            Log.e("MicroMsg.LiveTipsBarStorage", "deleteByLiveId failed, result:%d", Integer.valueOf(delete));
        } else {
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(j2);
            objArr[1] = str == null ? "" : str;
            objArr[2] = Boolean.valueOf(this.hLf == null);
            Log.i("MicroMsg.LiveTipsBarStorage", "deleteByLiveId success, liveId:%d, hostRoomId:%s, liveTipsBarNotify null:%b", objArr);
        }
        if (!(str == null || this.hLf == null)) {
            this.hLf.Ha(str);
        }
        AppMethodBeat.o(224107);
    }

    public final void w(String str, long j2) {
        AppMethodBeat.i(224108);
        Log.i("MicroMsg.LiveTipsBarStorage", "setVisitingLive, liveId:%d", Long.valueOf(j2));
        hLd = new Pair<>(str, Long.valueOf(j2));
        if (this.hLf != null) {
            this.hLf.Ha(str);
        }
        AppMethodBeat.o(224108);
    }

    public final void GY(String str) {
        AppMethodBeat.i(224109);
        Log.i("MicroMsg.LiveTipsBarStorage", "resetVisitingLive");
        if (hLd != null && ((String) hLd.first).equals(str)) {
            hLd = null;
        }
        if (this.hLf != null) {
            this.hLf.Ha(str);
        }
        AppMethodBeat.o(224109);
    }

    public final void GZ(String str) {
        AppMethodBeat.i(224110);
        if (hLd != null && ((String) hLd.first).equals(str)) {
            hLd = null;
        }
        int delete = this.db.delete("LiveTipsBar", "hostRoomId= ? ", new String[]{str});
        if (delete < 0) {
            Log.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%d", str, Integer.valueOf(delete));
            AppMethodBeat.o(224110);
            return;
        }
        Log.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%d", str, Integer.valueOf(delete));
        AppMethodBeat.o(224110);
    }

    public final boolean aHo() {
        AppMethodBeat.i(224111);
        boolean execSQL = this.db.execSQL("LiveTipsBar", "delete from LiveTipsBar");
        Log.i("MicroMsg.LiveTipsBarStorage", "deleteAllData, result:%b", Boolean.valueOf(execSQL));
        AppMethodBeat.o(224111);
        return execSQL;
    }
}
