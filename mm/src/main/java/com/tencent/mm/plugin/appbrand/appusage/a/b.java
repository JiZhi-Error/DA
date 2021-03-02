package com.tencent.mm.plugin.appbrand.appusage.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dko;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.LinkedList;

public class b extends MAutoStorage<a> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(a.info, "AppBrandRecommendCard")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(44668);
        AppMethodBeat.o(44668);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "AppBrandRecommendCard", null);
        this.db = iSQLiteDatabase;
    }

    public final void byC() {
        AppMethodBeat.i(44665);
        this.db.execSQL("AppBrandRecommendCard", "delete from AppBrandRecommendCard");
        AppMethodBeat.o(44665);
    }

    public final void u(LinkedList<dko> linkedList) {
        AppMethodBeat.i(44666);
        Log.i("MicroMsg.Recommend.AppBrandRecommendCardStorage", "addRecommendWxaList()");
        LinkedList linkedList2 = new LinkedList();
        linkedList2.addAll(linkedList);
        Iterator it = linkedList2.iterator();
        while (it.hasNext()) {
            dko dko = (dko) it.next();
            a aVar = new a();
            aVar.field_appId = dko.gTT;
            aVar.field_recommendCard = dko;
            insert(aVar);
        }
        AppMethodBeat.o(44666);
    }

    public final LinkedList<dko> byD() {
        LinkedList<dko> linkedList = null;
        AppMethodBeat.i(44667);
        Cursor rawQuery = this.db.rawQuery("select * from AppBrandRecommendCard LIMIT 100", null);
        if (rawQuery == null) {
            AppMethodBeat.o(44667);
        } else {
            Log.i("MicroMsg.Recommend.AppBrandRecommendCardStorage", "getRecommendWxaList()");
            linkedList = new LinkedList<>();
            while (rawQuery.moveToNext()) {
                a aVar = new a();
                aVar.convertFrom(rawQuery);
                linkedList.add(aVar.field_recommendCard);
            }
            rawQuery.close();
            AppMethodBeat.o(44667);
        }
        return linkedList;
    }
}
