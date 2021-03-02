package com.tencent.mm.plugin.finder.extension.reddot;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.br;
import com.tencent.mm.g.c.co;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Arrays;
import java.util.LinkedList;
import kotlin.f.b;
import kotlin.g.b.p;
import kotlin.x;

public final class c extends MAutoStorage<k> {
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(k.info, "FinderRedDotInfo")};
    public static final a tJp = new a((byte) 0);
    final ISQLiteDatabase db;

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean delete(k kVar, boolean z, String[] strArr) {
        AppMethodBeat.i(178144);
        k kVar2 = kVar;
        p.h(strArr, "keys");
        Log.i("Finder.RedDotCtrInfoStorage", "[delete] item=" + (kVar2 != null ? kVar2.field_tipsId : null) + " isNotify=" + z);
        boolean delete = super.delete(kVar2, z, (String[]) Arrays.copyOf(strArr, strArr.length));
        AppMethodBeat.o(178144);
        return delete;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage
    public final /* synthetic */ boolean replace(k kVar, boolean z) {
        AppMethodBeat.i(178145);
        boolean a2 = a(kVar, z);
        AppMethodBeat.o(178145);
        return a2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, k.info, "FinderRedDotInfo", co.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        k.a aVar = k.tLn;
        AppMethodBeat.i(178146);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(178146);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(178147);
        k.a aVar = k.tLn;
        AppMethodBeat.o(178147);
    }

    public final LinkedList<k> daw() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(243507);
        long currentTimeMillis = System.currentTimeMillis();
        LinkedList<k> linkedList = new LinkedList<>();
        Cursor all = getAll();
        if (all != null) {
            Cursor cursor = all;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst()) {
                    do {
                        try {
                            k kVar = new k();
                            kVar.convertFrom(cursor2);
                            linkedList.add(kVar);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("Finder.RedDotCtrInfoStorage", e2, "", new Object[0]);
                        }
                    } while (cursor2.moveToNext());
                }
                x xVar = x.SXb;
                b.a(cursor, null);
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                b.a(cursor, th2);
                AppMethodBeat.o(243507);
                throw th;
            }
        }
        Log.i("Finder.RedDotCtrInfoStorage", "[queryAll] COST=" + (System.currentTimeMillis() - currentTimeMillis) + LocaleUtil.MALAY);
        AppMethodBeat.o(243507);
        return linkedList;
    }

    private boolean a(k kVar, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(243508);
        if (kVar == null) {
            Log.i("Finder.RedDotCtrInfoStorage", "[replace] failure!");
            AppMethodBeat.o(243508);
            return false;
        }
        String str = kVar.field_tipsId;
        p.g(str, "item.field_tipsId");
        p.h(str, "id");
        Cursor rawQuery = this.db.rawQuery("select * from FinderRedDotInfo  where tipsId = '" + str + "' ", null);
        p.g(rawQuery, "cursor");
        boolean z3 = rawQuery.getCount() > 0;
        rawQuery.close();
        if (z3) {
            try {
                p.h(kVar, "item");
                if (this.db.update(getTableName(), kVar.convertTo(), "tipsId = ?", new String[]{kVar.field_tipsId}) <= 0) {
                    z2 = false;
                }
                if (z2 && z) {
                    doNotify("update");
                }
                Log.i("Finder.RedDotCtrInfoStorage", "[update] ret=" + z2 + " item=" + kVar.field_tipsId + " isNotify=" + z);
            } catch (Exception e2) {
                Log.printErrStackTrace("Finder.RedDotCtrInfoStorage", e2, "tipsId=" + kVar.field_tipsId + " type=" + kVar.field_ctrType, new Object[0]);
                br brVar = new br();
                brVar.jX("1");
                brVar.ew(10003);
                brVar.bfK();
                z2 = false;
            }
        } else {
            z2 = insertNotify(kVar, z);
        }
        Log.i("Finder.RedDotCtrInfoStorage", "[replace] ret=" + z2 + " isExist=" + z3 + " item=" + kVar.field_tipsId + " isNotify=" + z);
        AppMethodBeat.o(243508);
        return z2;
    }
}
