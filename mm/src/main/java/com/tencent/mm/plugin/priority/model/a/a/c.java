package com.tencent.mm.plugin.priority.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c {
    public b AXQ;
    private SQLiteStatement AYA;
    private SQLiteStatement AYx;
    SQLiteStatement AYy;
    SQLiteStatement AYz;

    public c(b bVar) {
        AppMethodBeat.i(87823);
        this.AXQ = bVar;
        if (this.AXQ.ag(49, 0) != 5) {
            if (this.AXQ.ayi("C2CChatUsage")) {
                this.AXQ.aKd("C2CChatUsage");
            }
            this.AXQ.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, date INTEGER, chattype INTEGER DEFAULT 0, opencount INTEGER DEFAULT 0, sendmsgcount INTEGER DEFAULT 0, staytime INTEGER DEFAULT 0, consumemsgcount INTEGER DEFAULT 0, PRIMARY KEY(chat, date));", "C2CChatUsage"));
            this.AXQ.ah(49, 5);
        } else {
            Log.i("MicroMsg.Priority.C2CChatUsageStorage", "Exist Table %s Count %d", "C2CChatUsage", Integer.valueOf(this.AXQ.aKc("C2CChatUsage")));
        }
        this.AYx = this.AXQ.compileStatement(String.format("INSERT OR IGNORE INTO %s (chat, date, chattype) VALUES (?,?,?)", "C2CChatUsage"));
        this.AYy = this.AXQ.compileStatement(String.format("UPDATE %s SET opencount = opencount + 1, staytime = staytime + ? WHERE chat = ? AND date = ?", "C2CChatUsage"));
        this.AYz = this.AXQ.compileStatement(String.format("UPDATE %s SET sendmsgcount = sendmsgcount + 1 WHERE chat = ? AND date = ?", "C2CChatUsage"));
        this.AYA = this.AXQ.compileStatement(String.format("UPDATE %s SET consumemsgcount = consumemsgcount + 1 WHERE chat = ? AND date = ?", "C2CChatUsage"));
        AppMethodBeat.o(87823);
    }

    public final boolean K(String str, long j2, long j3) {
        AppMethodBeat.i(87824);
        this.AYx.bindString(1, str);
        this.AYx.bindLong(2, j2);
        this.AYx.bindLong(3, j3);
        if (this.AYx.executeInsert() >= 0) {
            AppMethodBeat.o(87824);
            return true;
        }
        AppMethodBeat.o(87824);
        return false;
    }
}
