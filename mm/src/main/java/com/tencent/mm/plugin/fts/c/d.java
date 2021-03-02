package com.tencent.mm.plugin.fts.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d implements i {
    private boolean aMn;
    private boolean dbG;
    public h wUt;
    public SQLiteStatement wUv;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(i iVar) {
        return 0;
    }

    public d() {
        AppMethodBeat.i(52808);
        Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create %s", "FTS5SOSHistoryStorage");
        AppMethodBeat.o(52808);
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final void create() {
        boolean z;
        AppMethodBeat.i(52809);
        Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnCreate %s | isCreated =%b", "FTS5SOSHistoryStorage", Boolean.valueOf(this.dbG));
        if (!this.dbG) {
            if (!((n) g.ah(n.class)).isFTSContextReady()) {
                Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Fail!");
                z = false;
            } else {
                this.wUt = ((n) g.ah(n.class)).getFTSIndexDB();
                Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Success!");
                if (!this.wUt.ayi(dOt()) || !this.wUt.gD(-109, 2)) {
                    Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Not Exist, Need To Create");
                    String format = String.format("DROP TABLE IF EXISTS %s;", dOu());
                    String format2 = String.format("DROP TABLE IF EXISTS %s;", dOt());
                    this.wUt.execSQL(format);
                    this.wUt.execSQL(format2);
                    this.wUt.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (key TEXT PRIMARY KEY, timestamp INTEGER, content TEXT);", dOt()));
                    this.wUt.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_timestamp ON %s(timestamp);", dOt()));
                    this.wUt.W(-109, 2);
                } else {
                    Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Exist, Not Need To Create");
                }
                this.wUv = this.wUt.compileStatement(String.format("INSERT OR REPLACE INTO %s (key, timestamp, content) VALUES (?, ?, ?);", dOt()));
                z = true;
            }
            if (z) {
                Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetCreated");
                this.dbG = true;
            }
        }
        AppMethodBeat.o(52809);
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final void destroy() {
        AppMethodBeat.i(52810);
        Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", "FTS5SOSHistoryStorage", Boolean.valueOf(this.aMn), Boolean.valueOf(this.dbG));
        if (!this.aMn && this.dbG) {
            this.wUv.close();
            Log.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetDestroyed");
            this.aMn = true;
        }
        AppMethodBeat.o(52810);
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final String getName() {
        return "FTS5SOSHistoryStorage";
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final int getType() {
        return 1024;
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final int getPriority() {
        return 1024;
    }

    public static String dOt() {
        return "FTS5MetaSOSHistory";
    }

    public static String dOu() {
        return "FTS5IndexSOSHistory";
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final String dX(String str, int i2) {
        return null;
    }
}
