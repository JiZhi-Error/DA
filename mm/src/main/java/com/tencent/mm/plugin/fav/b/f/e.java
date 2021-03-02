package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e extends MAutoStorage<j> implements aa {
    private ISQLiteDatabase db;

    @Override // com.tencent.mm.plugin.fav.a.aa
    public final /* synthetic */ boolean a(j jVar) {
        AppMethodBeat.i(101727);
        boolean insert = super.insert(jVar);
        AppMethodBeat.o(101727);
        return insert;
    }

    @Override // com.tencent.mm.plugin.fav.a.aa
    public final /* synthetic */ boolean a(j jVar, String[] strArr) {
        AppMethodBeat.i(101726);
        boolean update = super.update(jVar, strArr);
        AppMethodBeat.o(101726);
        return update;
    }

    public e(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, j.info, "FavSearchInfo", null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.plugin.fav.a.aa
    public final ArrayList<Long> b(List<String> list, List<String> list2, List<Integer> list3) {
        AppMethodBeat.i(101720);
        ArrayList<Long> arrayList = new ArrayList<>();
        String str = " 1=1 ";
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                str = str + " and content like '%" + it.next() + "%'";
            }
            str = str;
        }
        if (list2 != null && !list2.isEmpty()) {
            Iterator<String> it2 = list2.iterator();
            while (it2.hasNext()) {
                str = str + " and tagContent like '%" + it2.next() + "%'";
            }
            str = str;
        }
        String str2 = "select localId from FavSearchInfo" + " where " + str;
        List<Integer> dF = dF(list3);
        List<Integer> dG = dG(list3);
        if (!Util.isNullOrNil(dF) || !Util.isNullOrNil(dG)) {
            String str3 = str2 + " and (";
            if (!Util.isNullOrNil(dF)) {
                str3 = str3 + "type = " + dF.get(0);
                int i2 = 1;
                while (i2 < dF.size()) {
                    int intValue = dF.get(i2).intValue();
                    i2++;
                    str3 = str3 + " or type = " + intValue;
                }
            }
            if (!Util.isNullOrNil(dG)) {
                if (!Util.isNullOrNil(dF)) {
                    str3 = str3 + " or ";
                }
                str3 = str3 + "subtype & " + j.HV(dG.get(0).intValue()) + " != 0";
                int i3 = 1;
                while (i3 < dG.size()) {
                    int intValue2 = dG.get(i3).intValue();
                    i3++;
                    str3 = str3 + " or subtype & " + j.HV(intValue2) + " != 0";
                }
            }
            str2 = str3 + ")";
        }
        String str4 = str2 + " order by time desc";
        Log.d("MicroMsg.FavSearchStorage", "search id sql {%s}", str4);
        Cursor rawQuery = this.db.rawQuery(str4, null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(101720);
            return arrayList;
        }
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        AppMethodBeat.o(101720);
        return arrayList;
    }

    private static List<Integer> dF(List<Integer> list) {
        AppMethodBeat.i(101721);
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(101721);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : list) {
            switch (num.intValue()) {
                case 1:
                    arrayList.add(1);
                    break;
                case 2:
                    arrayList.add(2);
                    break;
                case 3:
                    arrayList.add(3);
                    break;
                case 4:
                    arrayList.add(4);
                    break;
                case 5:
                    arrayList.add(5);
                    arrayList.add(20);
                    break;
                case 6:
                    arrayList.add(6);
                    break;
                case 7:
                    arrayList.add(7);
                    arrayList.add(21);
                    break;
                case 8:
                    arrayList.add(8);
                    break;
                case 9:
                    arrayList.add(9);
                    break;
                case 10:
                    arrayList.add(10);
                    break;
                case 11:
                    arrayList.add(11);
                    break;
                case 12:
                    arrayList.add(12);
                    break;
                case 13:
                    arrayList.add(13);
                    break;
                case 14:
                    arrayList.add(15);
                    break;
                case 15:
                    arrayList.add(16);
                    break;
                case 16:
                    arrayList.add(17);
                    break;
                case 17:
                    arrayList.add(14);
                    break;
                case 18:
                    arrayList.add(18);
                    break;
                case 19:
                    arrayList.add(19);
                    break;
                case 21:
                    arrayList.add(2);
                    arrayList.add(4);
                    break;
            }
        }
        AppMethodBeat.o(101721);
        return arrayList;
    }

    private static List<Integer> dG(List<Integer> list) {
        AppMethodBeat.i(101722);
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(101722);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : list) {
            switch (num.intValue()) {
                case 1:
                    arrayList.add(1);
                    break;
                case 2:
                    arrayList.add(2);
                    break;
                case 3:
                    arrayList.add(3);
                    break;
                case 4:
                    arrayList.add(4);
                    break;
                case 5:
                    arrayList.add(5);
                    arrayList.add(22);
                    break;
                case 6:
                    arrayList.add(6);
                    break;
                case 7:
                    arrayList.add(7);
                    arrayList.add(29);
                    break;
                case 8:
                    arrayList.add(8);
                    break;
                case 9:
                    arrayList.add(9);
                    break;
                case 10:
                    arrayList.add(10);
                    break;
                case 11:
                    arrayList.add(11);
                    break;
                case 12:
                    arrayList.add(12);
                    break;
                case 13:
                    arrayList.add(13);
                    break;
                case 14:
                    arrayList.add(14);
                    break;
                case 15:
                    arrayList.add(15);
                    break;
                case 16:
                    arrayList.add(16);
                    break;
                case 17:
                    arrayList.add(17);
                    break;
                case 19:
                    arrayList.add(19);
                    break;
                case 21:
                    arrayList.add(2);
                    arrayList.add(4);
                    break;
            }
        }
        AppMethodBeat.o(101722);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.fav.a.aa
    public final boolean asc(String str) {
        int i2;
        AppMethodBeat.i(101723);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(101723);
            return false;
        }
        String str2 = "select count(localId) from FavSearchInfo where tagContent like '%" + str + "%'";
        Log.d("MicroMsg.FavSearchStorage", "is tag exist sql {%s}", str2);
        Cursor rawQuery = this.db.rawQuery(str2, null, 2);
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            i2 = 0;
        } else {
            i2 = rawQuery.getInt(0);
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        if (i2 > 0) {
            AppMethodBeat.o(101723);
            return true;
        }
        AppMethodBeat.o(101723);
        return false;
    }

    @Override // com.tencent.mm.plugin.fav.a.aa
    public final void Ea(long j2) {
        AppMethodBeat.i(101724);
        this.db.execSQL("FavSearchInfo", "delete from FavSearchInfo where localId = ".concat(String.valueOf(j2)));
        AppMethodBeat.o(101724);
    }

    @Override // com.tencent.mm.plugin.fav.a.aa
    public final j Eb(long j2) {
        j jVar = null;
        AppMethodBeat.i(101725);
        Cursor rawQuery = this.db.rawQuery("select * from FavSearchInfo where localId = ".concat(String.valueOf(j2)), null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(101725);
        } else {
            if (rawQuery.moveToFirst()) {
                jVar = new j();
                jVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(101725);
        }
        return jVar;
    }
}
