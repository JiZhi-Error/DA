package com.tencent.mm.storage;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00152\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0002J\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/storage/BizAdInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/storage/BizAdInfo;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "totalCount", "", "getTotalCount", "()I", "deleteById", "", "id", "", "deleteTooOldData", "getTodayAdCardCount", "getTodayStartTime", "", "insertOrUpdate", "", "info", "Companion", "plugin-biz_release"})
public final class q extends MAutoStorage<p> {
    private static final String[] INDEX_CREATE = {"CREATE  INDEX IF NOT EXISTS biz_exposeTime_index ON BizAdInfo ( exposeTime ) "};
    public static final a NOP = new a((byte) 0);
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(p.info, "BizAdInfo")};
    final h iFy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(h hVar) {
        super(hVar, p.info, "BizAdInfo", INDEX_CREATE);
        p.h(hVar, UserDataStore.DATE_OF_BIRTH);
        AppMethodBeat.i(212476);
        this.iFy = hVar;
        AppMethodBeat.o(212476);
    }

    public final boolean a(p pVar) {
        AppMethodBeat.i(212474);
        p.h(pVar, "info");
        if (get(pVar, new String[0])) {
            Log.i("MicroMsg.BizAdInfoStorage", "insertOrUpdate exist");
            AppMethodBeat.o(212474);
            return false;
        }
        boolean insertNotify = super.insertNotify(pVar, false);
        Log.i("MicroMsg.BizAdInfoStorage", "insertOrUpdate ret=".concat(String.valueOf(insertNotify)));
        d.i(new b(this));
        AppMethodBeat.o(212474);
        return insertNotify;
    }

    public final void biF(String str) {
        AppMethodBeat.i(212475);
        p pVar = new p();
        pVar.field_aId = str;
        super.delete(pVar, false, "aId");
        AppMethodBeat.o(212475);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00070\u00070\u00068\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/storage/BizAdInfoStorage$Companion;", "", "()V", "DELETE_DATA_COUNT", "", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "MAX_DATA_COLUMN", "SQL_CREATE", "kotlin.jvm.PlatformType", "TABLE", "TAG", "plugin-biz_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(212477);
        AppMethodBeat.o(212477);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ q NOQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(q qVar) {
            super(0);
            this.NOQ = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(212473);
            q.a(this.NOQ);
            x xVar = x.SXb;
            AppMethodBeat.o(212473);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(q qVar) {
        int i2;
        AppMethodBeat.i(212478);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = qVar.iFy.rawQuery("SELECT count(*) FROM BizAdInfo", null);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        } else {
            i2 = 0;
        }
        rawQuery.close();
        if (i2 > 100) {
            ae aeVar = ae.SYK;
            String format = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", Arrays.copyOf(new Object[]{"BizAdInfo", "aId", "aId", "BizAdInfo", "exposeTime", 50}, 6));
            p.g(format, "java.lang.String.format(format, *args)");
            qVar.iFy.execSQL("BizAdInfo", format);
            Log.i("MicroMsg.BizAdInfoStorage", "deleteTooOldData delete cost: %d, count: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i2));
        }
        AppMethodBeat.o(212478);
    }
}
