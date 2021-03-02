package com.tencent.mm.plugin.finder.storage;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.c.im;
import com.tencent.mm.plugin.finder.storage.aq;
import com.tencent.mm.protocal.protobuf.fgu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;

public final class ar extends MAutoStorage<aq> {
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(aq.info, "FinderLiveLuckyMoneyInfo")};
    public static final a UUM = new a((byte) 0);
    public final ISQLiteDatabase db;
    public final ConcurrentHashMap<Long, Set<String>> tVA = new ConcurrentHashMap<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ar(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, aq.info, "FinderLiveLuckyMoneyInfo", im.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        aq.a aVar = aq.UUL;
        AppMethodBeat.i(261386);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(261386);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(261387);
        aq.a aVar = aq.UUL;
        AppMethodBeat.o(261387);
    }

    public final boolean a(long j2, Set<String> set) {
        aq aqVar;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(261384);
        Log.i("Finder.FinderLiveLuckyMoneyStorage", "saveCacheInternal: liveId:".concat(String.valueOf(j2)));
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM FinderLiveLuckyMoneyInfo where FinderLiveLuckyMoneyInfo.liveId=" + d.zs(j2), null, 2);
        if (rawQuery.moveToNext()) {
            aqVar = new aq();
            aqVar.convertFrom(rawQuery);
            z = false;
        } else {
            aqVar = new aq();
            aqVar.field_liveId = d.zs(j2);
            aqVar.field_luckyMoneyData = new fgu().toByteArray();
            Log.i("Finder.FinderLiveLuckyMoneyStorage", "create new luckyMoneyInfo:".concat(String.valueOf(aqVar)));
            z = true;
        }
        fgu fgu = new fgu();
        try {
            fgu.parseFrom(aqVar.field_luckyMoneyData);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
        }
        fgu.Vjj.addAll(set);
        aqVar.field_luckyMoneyData = fgu.toByteArray();
        rawQuery.close();
        if (z) {
            if (this.db.insert("FinderLiveLuckyMoneyInfo", "liveId", aqVar.convertTo()) <= 0) {
                z2 = false;
            }
        } else {
            z2 = replace(aqVar);
        }
        Log.i("Finder.FinderLiveLuckyMoneyStorage", "saveCache result:".concat(String.valueOf(z2)));
        AppMethodBeat.o(261384);
        return z2;
    }

    public final void U(long j2, String str) {
        AppMethodBeat.i(261385);
        Log.i("Finder.FinderLiveLuckyMoneyStorage", "updateCache liveId:" + j2 + " sendId:" + str);
        if (str != null) {
            Set<String> set = this.tVA.get(Long.valueOf(j2));
            if (set != null) {
                set.add(str);
                AppMethodBeat.o(261385);
                return;
            }
            AppMethodBeat.o(261385);
            return;
        }
        AppMethodBeat.o(261385);
    }
}
