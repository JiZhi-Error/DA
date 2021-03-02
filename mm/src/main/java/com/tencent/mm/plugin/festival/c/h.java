package com.tencent.mm.plugin.festival.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J&\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\b¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/festival/util/FestivalStorageUtils;", "", "()V", "TAG", "", "compileStatement", "Lcom/tencent/wcdb/database/SQLiteStatement;", "Lcom/tencent/mm/storagebase/SqliteDB;", SharePluginInfo.ISSUE_KEY_SQL, "runInTransaction", "T", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "block", "Lkotlin/Function0;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "plugin-festival_release"})
public final class h {
    public static final h UGH = new h();

    static {
        AppMethodBeat.i(263496);
        AppMethodBeat.o(263496);
    }

    private h() {
    }

    public static SQLiteStatement b(com.tencent.mm.storagebase.h hVar, String str) {
        SQLiteStatement sQLiteStatement = null;
        AppMethodBeat.i(263495);
        p.h(hVar, "$this$compileStatement");
        p.h(str, SharePluginInfo.ISSUE_KEY_SQL);
        try {
            sQLiteStatement = hVar.gFH().compileStatement(str);
        } catch (SQLiteException e2) {
            Log.e("MicroMsg.FestivalStorageUtils", "compileStatement with sql:" + str + ", get exception:" + e2);
        } catch (IllegalStateException e3) {
            Log.e("MicroMsg.FestivalStorageUtils", "compileStatement with sql:" + str + ", get exception:" + e3);
        }
        AppMethodBeat.o(263495);
        return sQLiteStatement;
    }
}
