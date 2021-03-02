package com.tencent.mm.plugin.story.i;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.story.f.d;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.x;

public final class k extends MAutoStorage<j> {
    private static String EmE;
    private static String EmG;
    private static String Emu = (" order by " + TABLE + ".createTime desc");
    private static String FwA;
    private static String FwB;
    public static final a FwC = new a((byte) 0);
    private static final String Fww = Fww;
    private static String Fwx = (" order by " + TABLE + ".favoriteTime asc");
    private static final String Fwy = Fwy;
    private static String Fwz;
    private static final String[] INDEX_CREATE;
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(j.info, TABLE)};
    public static final String TABLE = TABLE;
    public static final String TAG = TAG;
    private String EmB;
    private final ArrayList<Integer> EmK;
    private String Emz;
    private ISQLiteDatabase Fwj;
    private final String Fwt = " (storyID != 0 ) ";
    private final ArrayList<Integer> Fwu;
    private final List<String> Fwv;
    public final ISQLiteDatabase db;
    private final ArrayList<Integer> vDL;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, j.info, TABLE, INDEX_CREATE);
        p.h(iSQLiteDatabase, "vdb");
        j.a aVar = j.Fws;
        AppMethodBeat.i(119589);
        this.Fwj = iSQLiteDatabase;
        a.d dVar = a.d.FvM;
        a.d dVar2 = a.d.FvM;
        a.d dVar3 = a.d.FvM;
        List asList = Arrays.asList(Integer.valueOf(a.d.frm()), Integer.valueOf(a.d.frn()), Integer.valueOf(a.d.fro()));
        p.g(asList, "Arrays.asList(ConstantsS…lag.LOCAL_FLAG_STATE_MIX)");
        this.vDL = a.eu(asList);
        a.C1768a aVar2 = a.FvD;
        a.C1768a aVar3 = a.FvD;
        a.C1768a aVar4 = a.FvD;
        List asList2 = Arrays.asList(Integer.valueOf(a.FuJ), Integer.valueOf(a.FuK), Integer.valueOf(a.FuL));
        p.g(asList2, "Arrays.asList(ConstantsS…ORY_SOURCE_ALBUM_HISTORY)");
        this.EmK = a.eu(asList2);
        a.C1768a aVar5 = a.FvD;
        a.C1768a aVar6 = a.FvD;
        List asList3 = Arrays.asList(Integer.valueOf(a.Fvt), Integer.valueOf(a.Fvu));
        p.g(asList3, "Arrays.asList(ConstantsS…STORY_ITEM_FAVORITE_FLAG)");
        this.Fwu = a.eu(asList3);
        this.db = this.Fwj;
        this.Fwv = Collections.synchronizedList(new ArrayList());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.vDL.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            int intValue = next.intValue();
            a.d dVar4 = a.d.FvM;
            if ((intValue & a.d.frm()) != 0) {
                int intValue2 = next.intValue();
                a.d dVar5 = a.d.FvM;
                if ((intValue2 & a.d.frn()) == 0) {
                    arrayList.add(next);
                }
            }
        }
        this.Emz = a.k(arrayList, "localFlag");
        arrayList.clear();
        Iterator<Integer> it2 = this.EmK.iterator();
        while (it2.hasNext()) {
            Integer next2 = it2.next();
            int intValue3 = next2.intValue();
            a.C1768a aVar7 = a.FvD;
            if ((intValue3 & a.FuJ) != 0) {
                arrayList.add(next2);
            }
        }
        EmE = a.k(arrayList, "sourceType");
        arrayList.clear();
        Iterator<Integer> it3 = this.EmK.iterator();
        while (it3.hasNext()) {
            Integer next3 = it3.next();
            int intValue4 = next3.intValue();
            a.C1768a aVar8 = a.FvD;
            if ((intValue4 & a.FuK) != 0) {
                arrayList.add(next3);
            }
        }
        EmG = a.k(arrayList, "sourceType");
        arrayList.clear();
        Iterator<Integer> it4 = this.vDL.iterator();
        while (it4.hasNext()) {
            Integer next4 = it4.next();
            int intValue5 = next4.intValue();
            a.d dVar6 = a.d.FvM;
            if ((intValue5 & a.d.frn()) != 0) {
                arrayList.add(next4);
            }
        }
        this.EmB = a.k(arrayList, "localFlag");
        arrayList.clear();
        Iterator<Integer> it5 = this.EmK.iterator();
        while (it5.hasNext()) {
            Integer next5 = it5.next();
            int intValue6 = next5.intValue();
            a.C1768a aVar9 = a.FvD;
            if ((intValue6 & a.FuL) != 0) {
                arrayList.add(next5);
            }
        }
        FwA = a.k(arrayList, "sourceType");
        arrayList.clear();
        Iterator<Integer> it6 = this.Fwu.iterator();
        while (it6.hasNext()) {
            Integer next6 = it6.next();
            int intValue7 = next6.intValue();
            a.C1768a aVar10 = a.FvD;
            if ((intValue7 & a.Fvt) != 0) {
                arrayList.add(next6);
            }
        }
        Fwz = a.b(arrayList, "itemStoryFlag", true);
        arrayList.clear();
        Iterator<Integer> it7 = this.Fwu.iterator();
        while (it7.hasNext()) {
            Integer next7 = it7.next();
            int intValue8 = next7.intValue();
            a.C1768a aVar11 = a.FvD;
            if ((intValue8 & a.Fvu) != 0) {
                arrayList.add(next7);
            }
        }
        FwB = a.k(arrayList, "itemStoryFlag");
        AppMethodBeat.o(119589);
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(long j2, j jVar) {
        AppMethodBeat.i(119558);
        boolean e2 = e(jVar);
        AppMethodBeat.o(119558);
        return e2;
    }

    public final void aSz(String str) {
        AppMethodBeat.i(119554);
        p.h(str, ch.COL_LOCALID);
        this.Fwv.add(str);
        AppMethodBeat.o(119554);
    }

    public final boolean aSA(String str) {
        boolean z;
        AppMethodBeat.i(119555);
        p.h(str, ch.COL_LOCALID);
        List<String> list = this.Fwv;
        p.g(list, "delList");
        List<String> list2 = list;
        synchronized (list2) {
            try {
                Iterator<T> it = list2.iterator();
                z = false;
                while (it.hasNext()) {
                    if (p.j(it.next(), str)) {
                        Log.i(TAG, "wo wo wo ".concat(String.valueOf(str)));
                        z = true;
                    }
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(119555);
            }
        }
        return z;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String k(List<Integer> list, String str) {
            AppMethodBeat.i(119551);
            p.h(list, "data");
            p.h(str, "col");
            String b2 = b(list, str, false);
            AppMethodBeat.o(119551);
            return b2;
        }

        public static String b(List<Integer> list, String str, boolean z) {
            AppMethodBeat.i(119552);
            p.h(list, "data");
            p.h(str, "col");
            StringBuilder sb = new StringBuilder("(");
            if (z) {
                sb.append(str + " not in (");
            } else {
                sb.append(str + " in (");
            }
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next().intValue());
                if (it.hasNext()) {
                    sb.append(",");
                }
            }
            sb.append(")");
            sb.append(")");
            String sb2 = sb.toString();
            p.g(sb2, "sb.toString()");
            AppMethodBeat.o(119552);
            return sb2;
        }

        public static ArrayList<Integer> eu(List<Integer> list) {
            AppMethodBeat.i(119553);
            p.h(list, "data");
            ArrayList arrayList = new ArrayList(list);
            HashSet hashSet = new HashSet();
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    int intValue = ((Integer) it2.next()).intValue();
                    p.g(num, "i");
                    arrayList3.add(Integer.valueOf(intValue | num.intValue()));
                }
                hashSet.addAll(new HashSet(arrayList3));
                hashSet.add(num);
            }
            hashSet.add(0);
            arrayList2.addAll(hashSet);
            AppMethodBeat.o(119553);
            return arrayList2;
        }
    }

    static {
        AppMethodBeat.i(119590);
        StringBuilder sb = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
        j.a aVar = j.Fws;
        StringBuilder sb2 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
        j.a aVar2 = j.Fws;
        StringBuilder sb3 = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
        j.a aVar3 = j.Fws;
        INDEX_CREATE = new String[]{sb.append(j.TABLEINDEXUSERNAME).append(" ON ").append(TABLE).append(" ( storyID )").toString(), sb2.append(j.Fwq).append(" ON ").append(TABLE).append(" (userName,storyID, createTime)").toString(), sb3.append(j.Fwr).append(" ON ").append(TABLE).append(" (userName, createTime)").toString()};
        j.a aVar4 = j.Fws;
        AppMethodBeat.o(119590);
    }

    private long o(String str, long j2, int i2) {
        AppMethodBeat.i(119556);
        p.h(str, "baseSql");
        if (j2 != 0) {
            str = str + " AND " + TABLE + ".storyID < '" + j2 + '\'';
        }
        String str2 = str + Emu + " limit " + i2;
        Log.d(TAG, "getMinIdByLimit sql=".concat(String.valueOf(str2)));
        Cursor rawQuery = this.db.rawQuery(str2, null);
        if (rawQuery.moveToLast()) {
            j jVar = new j();
            p.g(rawQuery, "cu");
            jVar.convertFrom(rawQuery);
            rawQuery.close();
            long j3 = jVar.field_storyID;
            AppMethodBeat.o(119556);
            return j3;
        }
        rawQuery.close();
        AppMethodBeat.o(119556);
        return 0;
    }

    public final boolean e(j jVar) {
        AppMethodBeat.i(119557);
        p.h(jVar, "storyInfo");
        boolean replace = replace(jVar);
        AppMethodBeat.o(119557);
        return replace;
    }

    public final int f(j jVar) {
        AppMethodBeat.i(119559);
        p.h(jVar, "storyInfo");
        Log.d(TAG, "storyInfo Insert");
        int insert = (int) this.db.insert(TABLE, "", jVar.convertTo());
        Log.d(TAG, "StoryInfo Insert result ".concat(String.valueOf(insert)));
        AppMethodBeat.o(119559);
        return insert;
    }

    public final j Kx(long j2) {
        AppMethodBeat.i(119560);
        j jVar = new j();
        Cursor rawQuery = this.db.rawQuery("select *,rowid from MMStoryInfo  where " + TABLE + ".storyID=" + j2 + " limit 1", null, 2);
        if (rawQuery.moveToFirst()) {
            p.g(rawQuery, "cu");
            jVar.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(119560);
            return jVar;
        }
        rawQuery.close();
        AppMethodBeat.o(119560);
        return null;
    }

    public final j frP() {
        AppMethodBeat.i(119561);
        int aWB = cl.aWB();
        i.a aVar = i.Fmb;
        int i2 = aWB - i.FlY;
        j jVar = new j();
        StringBuilder append = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(this.Emz).append(" and createTime > ").append(i2).append(" order by ").append(TABLE).append('.');
        j.a aVar2 = j.Fws;
        String sb = append.append(j.COL_ROWID).append(" asc limit 1").toString();
        Cursor rawQuery = this.db.rawQuery(sb, null, 2);
        Log.d(TAG, "getLastUpload ".concat(String.valueOf(sb)));
        if (!rawQuery.moveToFirst()) {
            rawQuery.close();
            AppMethodBeat.o(119561);
            return null;
        }
        p.g(rawQuery, "cr");
        jVar.convertFrom(rawQuery);
        rawQuery.close();
        AppMethodBeat.o(119561);
        return jVar;
    }

    public final int a(int i2, j jVar) {
        AppMethodBeat.i(119562);
        p.h(jVar, "storyinfo");
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        if (j.b.foc().aSA(new StringBuilder().append(i2).append('_').append(jVar.field_createTime).toString())) {
            AppMethodBeat.o(119562);
            return -1;
        }
        ContentValues convertTo = jVar.convertTo();
        convertTo.remove("rowid");
        ISQLiteDatabase iSQLiteDatabase = this.db;
        String str = TABLE;
        StringBuilder sb = new StringBuilder();
        j.a aVar = j.Fws;
        int update = iSQLiteDatabase.update(str, convertTo, sb.append(j.COL_ROWID).append("=?").toString(), new String[]{String.valueOf(i2)});
        AppMethodBeat.o(119562);
        return update;
    }

    public final j aba(int i2) {
        AppMethodBeat.i(119563);
        j jVar = new j();
        StringBuilder append = new StringBuilder("select *,rowid from MMStoryInfo  where ").append(TABLE).append('.');
        j.a aVar = j.Fws;
        Cursor rawQuery = this.db.rawQuery(append.append(j.COL_ROWID).append('=').append(i2).toString(), null, 2);
        if (rawQuery.moveToFirst()) {
            p.g(rawQuery, "cu");
            jVar.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(119563);
            return jVar;
        }
        rawQuery.close();
        AppMethodBeat.o(119563);
        return null;
    }

    private j Ky(long j2) {
        AppMethodBeat.i(119564);
        if (j2 >= 0) {
            j aba = aba((int) j2);
            AppMethodBeat.o(119564);
            return aba;
        }
        j KA = KA(j2);
        AppMethodBeat.o(119564);
        return KA;
    }

    private static String cn(String str, boolean z) {
        AppMethodBeat.i(119565);
        if (z) {
            String str2 = " WHERE " + EmE;
            AppMethodBeat.o(119565);
            return str2;
        }
        String str3 = " WHERE " + TABLE + ".userName='" + Util.escapeSqlValue(str) + "' AND " + EmG;
        AppMethodBeat.o(119565);
        return str3;
    }

    private static String abb(int i2) {
        AppMethodBeat.i(119566);
        String str = TABLE + ".createTime>" + i2;
        AppMethodBeat.o(119566);
        return str;
    }

    private static String cv(String str, boolean z) {
        AppMethodBeat.i(119567);
        String str2 = "select *,rowid from MMStoryInfo " + cn(str, z);
        AppMethodBeat.o(119567);
        return str2;
    }

    public final long c(long j2, int i2, String str, boolean z) {
        AppMethodBeat.i(119568);
        p.h(str, ch.COL_USERNAME);
        long o = o(cv(str, z), j2, i2);
        AppMethodBeat.o(119568);
        return o;
    }

    public final List<j> cw(String str, boolean z) {
        AppMethodBeat.i(119569);
        p.h(str, "userName");
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery(("select *,rowid from MMStoryInfo " + cn(str, z)) + (z ? Emu : " AND " + Fwy + Emu), null, 2);
        while (rawQuery.moveToNext()) {
            j jVar = new j();
            p.g(rawQuery, "cu");
            jVar.convertFrom(rawQuery);
            arrayList.add(jVar);
        }
        rawQuery.close();
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(119569);
        return arrayList2;
    }

    public static /* synthetic */ List a(k kVar, String str, long j2) {
        AppMethodBeat.i(119570);
        p.h(str, ch.COL_USERNAME);
        ArrayList arrayList = new ArrayList();
        String str2 = "select *,rowid from MMStoryInfo  WHERE " + FwA;
        if (j2 < 0) {
            str2 = str2 + " AND storyID >= " + j2;
        }
        String str3 = str2 + Emu;
        Log.d(TAG, "getAlbumStoryAfterByStoryId ".concat(String.valueOf(str3)));
        Cursor rawQuery = kVar.db.rawQuery(str3, null, 2);
        while (rawQuery.moveToNext()) {
            j jVar = new j();
            p.g(rawQuery, "cu");
            jVar.convertFrom(rawQuery);
            arrayList.add(jVar);
        }
        rawQuery.close();
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(119570);
        return arrayList2;
    }

    public static /* synthetic */ List a(k kVar, String str, boolean z, int i2) {
        AppMethodBeat.i(119573);
        List<j> a2 = kVar.a(str, z, i2, false);
        AppMethodBeat.o(119573);
        return a2;
    }

    public final List<j> a(String str, boolean z, int i2, boolean z2) {
        AppMethodBeat.i(119572);
        p.h(str, "userName");
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery((("select *,rowid from MMStoryInfo " + cn(str, z) + ' ') + " AND " + abb(i2)) + (z ? Emu : " AND " + Fwy + " AND " + Fwz + ' ' + Emu), null, 2);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                j jVar = new j();
                jVar.convertFrom(rawQuery);
                arrayList.add(jVar);
            }
            rawQuery.close();
        }
        if (z) {
            d dVar = d.FlN;
            d.aaG(arrayList.size());
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (!((j) obj).frJ()) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            AppMethodBeat.o(119572);
            return arrayList3;
        }
        ArrayList arrayList4 = arrayList;
        AppMethodBeat.o(119572);
        return arrayList4;
    }

    public final List<j> j(String str, boolean z, int i2) {
        AppMethodBeat.i(119574);
        p.h(str, "userName");
        ArrayList arrayList = new ArrayList();
        for (Object obj : a(this, str, z, i2)) {
            if (((j) obj).frG().NeD == 0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(119574);
        return arrayList2;
    }

    public final boolean Zs(int i2) {
        AppMethodBeat.i(119575);
        ISQLiteDatabase iSQLiteDatabase = this.db;
        String str = TABLE;
        StringBuilder sb = new StringBuilder();
        j.a aVar = j.Fws;
        if (iSQLiteDatabase.delete(str, sb.append(j.COL_ROWID).append("=?").toString(), new String[]{String.valueOf(i2)}) > 0) {
            AppMethodBeat.o(119575);
            return true;
        }
        AppMethodBeat.o(119575);
        return false;
    }

    public final boolean Kz(long j2) {
        AppMethodBeat.i(119576);
        if (this.db.delete(TABLE, "storyID=?", new String[]{String.valueOf(j2)}) > 0) {
            AppMethodBeat.o(119576);
            return true;
        }
        AppMethodBeat.o(119576);
        return false;
    }

    public final boolean M(long j2, String str) {
        AppMethodBeat.i(119577);
        p.h(str, ch.COL_USERNAME);
        boolean Kz = Kz(j2);
        j jVar = new j();
        jVar.field_userName = str;
        jVar.field_storyID = j2;
        doNotify("notify_story_info_delete", 1, jVar);
        AppMethodBeat.o(119577);
        return Kz;
    }

    public final j KA(long j2) {
        AppMethodBeat.i(119578);
        j jVar = new j();
        Cursor rawQuery = this.db.rawQuery("select *,rowid from MMStoryInfo  WHERE " + TABLE + ".storyID=" + j2, null, 2);
        if (rawQuery.moveToFirst()) {
            p.g(rawQuery, "cu");
            jVar.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(119578);
            return jVar;
        }
        rawQuery.close();
        AppMethodBeat.o(119578);
        return null;
    }

    public final void eIQ() {
        AppMethodBeat.i(119579);
        Log.i(TAG, "dropTable ".concat(String.valueOf(this.db.delete(TABLE, null, null))));
        AppMethodBeat.o(119579);
    }

    public final List<j> fN(String str, int i2) {
        AppMethodBeat.i(119580);
        p.h(str, "userName");
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery((("select *,rowid from MMStoryInfo " + cn(str, true)) + " AND createTime BETWEEN " + i2 + " AND " + ((LocalCache.TIME_DAY + i2) - 1)) + Emu, null, 2);
        while (rawQuery.moveToNext()) {
            j jVar = new j();
            p.g(rawQuery, "cu");
            jVar.convertFrom(rawQuery);
            arrayList.add(jVar);
        }
        rawQuery.close();
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(119580);
        return arrayList2;
    }

    public final long ab(long j2, int i2) {
        AppMethodBeat.i(119581);
        long o = o("select *,rowid from MMStoryInfo  WHERE " + FwA, j2, i2);
        AppMethodBeat.o(119581);
        return o;
    }

    public final long a(long j2, String str, boolean z, int i2) {
        AppMethodBeat.i(119582);
        p.h(str, ch.COL_USERNAME);
        long o = o("select *,rowid from MMStoryInfo  " + cn(str, z) + " AND " + FwB, j2, i2);
        AppMethodBeat.o(119582);
        return o;
    }

    public final j cx(String str, boolean z) {
        AppMethodBeat.i(119583);
        p.h(str, "userName");
        j jVar = new j();
        Cursor rawQuery = this.db.rawQuery((("select *,rowid from MMStoryInfo " + cn(str, z)) + (z ? Emu : " AND " + Fwy + Emu)) + " limit 1", null, 2);
        if (rawQuery.moveToFirst()) {
            p.g(rawQuery, "cu");
            jVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(119583);
        return jVar;
    }

    public final int KB(long j2) {
        AppMethodBeat.i(119584);
        j Ky = Ky(j2);
        if (Ky != null) {
            int i2 = Ky.field_readCount;
            AppMethodBeat.o(119584);
            return i2;
        }
        AppMethodBeat.o(119584);
        return 0;
    }

    public final ArrayList<j> cy(String str, boolean z) {
        AppMethodBeat.i(119586);
        p.h(str, ch.COL_USERNAME);
        ArrayList<j> arrayList = new ArrayList<>();
        if (str.length() > 0) {
            String str2 = "select *,rowid from MMStoryInfo  " + cn(str, z) + " AND " + FwB + ' ' + Emu;
            Log.d(TAG, "getFavStoryByUsername sql:".concat(String.valueOf(str2)));
            Cursor rawQuery = this.db.rawQuery(str2, null, 2);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    j jVar = new j();
                    jVar.convertFrom(rawQuery);
                    arrayList.add(jVar);
                }
                rawQuery.close();
            }
        }
        AppMethodBeat.o(119586);
        return arrayList;
    }

    public static /* synthetic */ List a(k kVar, String str, boolean z, long j2) {
        AppMethodBeat.i(119588);
        List<j> a2 = kVar.a(str, z, j2, 0);
        AppMethodBeat.o(119588);
        return a2;
    }

    public final List<j> a(String str, boolean z, long j2, int i2) {
        AppMethodBeat.i(119587);
        p.h(str, ch.COL_USERNAME);
        ArrayList arrayList = new ArrayList();
        if (str.length() > 0) {
            String str2 = "select *,rowid from MMStoryInfo  " + cn(str, z) + " AND " + FwB + ' ';
            if (j2 < 0) {
                str2 = str2 + " AND storyID >= " + j2;
            }
            String str3 = str2 + Emu;
            if (i2 > 0) {
                str3 = str3 + " limit " + i2;
            }
            Log.d(TAG, "getFavStoryByUsername sql:".concat(String.valueOf(str3)));
            Cursor rawQuery = this.db.rawQuery(str3, null, 2);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    j jVar = new j();
                    jVar.convertFrom(rawQuery);
                    arrayList.add(jVar);
                }
                rawQuery.close();
            }
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(119587);
        return arrayList2;
    }

    public static /* synthetic */ List a(k kVar, long j2) {
        AppMethodBeat.i(119571);
        ArrayList arrayList = new ArrayList();
        String str = "select *,rowid from MMStoryInfo  WHERE " + EmE;
        if (j2 < 0) {
            str = str + " AND storyID >= " + j2;
        }
        String str2 = str + Emu;
        Log.d(TAG, "getStoryAfterByStoryId ".concat(String.valueOf(str2)));
        Cursor rawQuery = kVar.db.rawQuery(str2, null, 2);
        while (rawQuery.moveToNext()) {
            j jVar = new j();
            p.g(rawQuery, "cu");
            jVar.convertFrom(rawQuery);
            arrayList.add(jVar);
        }
        rawQuery.close();
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(119571);
        return arrayList2;
    }

    public static /* synthetic */ int b(k kVar, long j2) {
        AppMethodBeat.i(119585);
        j Ky = kVar.Ky(j2);
        if (Ky != null) {
            Ky.field_readCount++;
            int update = kVar.db.update(TABLE, Ky.convertTo(), "storyID=?", new String[]{String.valueOf(j2)});
            AppMethodBeat.o(119585);
            return update;
        }
        AppMethodBeat.o(119585);
        return -1;
    }
}
