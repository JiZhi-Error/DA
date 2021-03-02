package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.fav.a.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class d extends MAutoStorage<g> implements x {
    private static final String tcv = ("xml,edittime,ext,favProto" + ",flag,fromUser,id,itemStatus" + ",localId,localSeq,realChatName,sourceCreateTime" + ",sourceId,sourceType,toUser,type" + ",updateSeq,updateTime,tagProto,sessionId" + ",datatotalsize,rowid");
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(g gVar) {
        AppMethodBeat.i(101718);
        boolean z = z(gVar);
        AppMethodBeat.o(101718);
        return z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(g gVar, String[] strArr) {
        AppMethodBeat.i(101717);
        boolean a2 = a(gVar, strArr);
        AppMethodBeat.o(101717);
        return a2;
    }

    static {
        AppMethodBeat.i(101719);
        AppMethodBeat.o(101719);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, g.info, "FavItemInfo", null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final ISQLiteDatabase cUP() {
        return this.db;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final g DY(long j2) {
        AppMethodBeat.i(101691);
        if (this.db == null) {
            Log.e("MicroMsg.Fav.FavItemInfoStorage", "getBtLocalId, but db is null, return");
            AppMethodBeat.o(101691);
            return null;
        }
        Cursor query = this.db.query("FavItemInfo", null, "localId=?", new String[]{String.valueOf(j2)}, null, null, null, 2);
        if (query.moveToFirst()) {
            g gVar = new g();
            try {
                gVar.convertFrom(query);
                query.close();
                AppMethodBeat.o(101691);
                return gVar;
            } catch (Exception e2) {
                Log.e("MicroMsg.Fav.FavItemInfoStorage", "getByLocalId convertFrom(cu) cause IlleagalStateException, return null");
                query.close();
                AppMethodBeat.o(101691);
                return null;
            }
        } else {
            Log.w("MicroMsg.Fav.FavItemInfoStorage", "klem getByLocalId:%d, no data", Long.valueOf(j2));
            query.close();
            AppMethodBeat.o(101691);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final g DZ(long j2) {
        AppMethodBeat.i(101692);
        Cursor rawQuery = this.db.rawQuery("Select * from FavItemInfo where id = ".concat(String.valueOf(j2)), null);
        if (rawQuery.getCount() != 0) {
            g gVar = new g();
            rawQuery.moveToFirst();
            try {
                gVar.convertFrom(rawQuery);
                rawQuery.close();
                AppMethodBeat.o(101692);
                return gVar;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Fav.FavItemInfoStorage", e2, "", new Object[0]);
                Log.e("MicroMsg.Fav.FavItemInfoStorage", "getByFavId(%d),info.convertFrom error", Long.valueOf(j2));
                rawQuery.close();
                AppMethodBeat.o(101692);
                return null;
            }
        } else {
            Log.w("MicroMsg.Fav.FavItemInfoStorage", "klem getByFavId:%d, no data", Long.valueOf(j2));
            rawQuery.close();
            AppMethodBeat.o(101692);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final int cUQ() {
        AppMethodBeat.i(101693);
        Cursor rawQuery = rawQuery("select count(*) from FavItemInfo where type = 2", new String[0]);
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            int i2 = rawQuery.getInt(0);
            rawQuery.close();
            AppMethodBeat.o(101693);
            return i2;
        }
        AppMethodBeat.o(101693);
        return 0;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final g asb(String str) {
        AppMethodBeat.i(101694);
        Cursor query = this.db.query("FavItemInfo", null, "sourceId=?", new String[]{String.valueOf(str)}, null, null, null, 2);
        if (query.moveToFirst()) {
            g gVar = new g();
            gVar.convertFrom(query);
            query.close();
            AppMethodBeat.o(101694);
            return gVar;
        }
        Log.w("MicroMsg.Fav.FavItemInfoStorage", "klem getBySourceId:%s, no data", str);
        query.close();
        AppMethodBeat.o(101694);
        return null;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final boolean z(g gVar) {
        AppMethodBeat.i(101695);
        Assert.assertTrue(gVar.field_localId > 0);
        if (gVar.field_favProto.Lya != null) {
            anh anh = gVar.field_favProto.Lya;
            if (anh.sourceType <= 0) {
                Log.w("MicroMsg.Fav.FavItemInfoStorage", "insert::favid %d favlocalid %d type %d, sourceTypeError %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_type), Integer.valueOf(anh.sourceType));
                anh.ajm(1);
            } else {
                anh.ajm(anh.sourceType);
            }
        }
        b.a(gVar);
        boolean insertNotify = insertNotify(gVar, false);
        if (insertNotify) {
            doNotify(new StringBuilder().append(gVar.field_localId).toString(), 2, Long.valueOf(gVar.field_localId));
        }
        AppMethodBeat.o(101695);
        return insertNotify;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final boolean a(g gVar, String... strArr) {
        AppMethodBeat.i(101696);
        if (gVar.field_favProto.Lya != null) {
            anh anh = gVar.field_favProto.Lya;
            if (anh.sourceType <= 0) {
                Log.w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_type), Integer.valueOf(anh.sourceType));
                anh.ajm(1);
            } else {
                anh.ajm(anh.sourceType);
            }
        }
        b.a(gVar);
        boolean updateNotify = super.updateNotify(gVar, false, strArr);
        if (updateNotify) {
            doNotify(new StringBuilder().append(gVar.field_localId).toString(), 3, Long.valueOf(gVar.field_localId));
        }
        Log.d("MicroMsg.Fav.FavItemInfoStorage", "update result[%B]", Boolean.valueOf(updateNotify));
        AppMethodBeat.o(101696);
        return updateNotify;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final boolean z(long j2, int i2) {
        AppMethodBeat.i(101697);
        String concat = "select count(updateTime) from FavItemInfo where updateTime < ".concat(String.valueOf(j2));
        if (i2 != -1) {
            concat = concat + " and type = " + i2;
        }
        Cursor rawQuery = this.db.rawQuery(concat, null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(101697);
            return true;
        }
        rawQuery.moveToFirst();
        if (rawQuery.getInt(0) == 0) {
            rawQuery.close();
            AppMethodBeat.o(101697);
            return true;
        }
        rawQuery.close();
        AppMethodBeat.o(101697);
        return false;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final long A(long j2, int i2) {
        long j3;
        AppMethodBeat.i(101698);
        if (this.db == null) {
            Log.e("MicroMsg.Fav.FavItemInfoStorage", "getNextUpdateTime, but db is null, return");
            AppMethodBeat.o(101698);
            return 0;
        } else if (j2 == 0) {
            String str = "select updateTime from FavItemInfo where itemStatus > 0";
            if (i2 != -1) {
                str = str + " and type = " + i2;
            }
            Cursor rawQuery = this.db.rawQuery(str + " order by updateTime desc limit 20", null);
            if (rawQuery == null) {
                AppMethodBeat.o(101698);
                return 0;
            } else if (rawQuery.getCount() == 0) {
                rawQuery.close();
                AppMethodBeat.o(101698);
                return 0;
            } else {
                rawQuery.moveToLast();
                long j4 = rawQuery.getLong(0);
                rawQuery.close();
                AppMethodBeat.o(101698);
                return j4;
            }
        } else {
            String concat = "select updateTime from FavItemInfo where updateTime < ".concat(String.valueOf(j2));
            if (i2 != -1) {
                concat = concat + " and type = " + i2;
            }
            Cursor rawQuery2 = this.db.rawQuery((concat + " and itemStatus > 0") + " order by updateTime desc limit 20", null);
            if (rawQuery2 == null || rawQuery2.getCount() <= 0) {
                j3 = j2;
            } else {
                rawQuery2.moveToLast();
                j3 = rawQuery2.getLong(0);
            }
            if (rawQuery2 != null) {
                rawQuery2.close();
            }
            AppMethodBeat.o(101698);
            return j3;
        }
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final List<g> a(int i2, Set<Integer> set, w wVar) {
        String str;
        AppMethodBeat.i(101699);
        if (set == null || !set.contains(Integer.valueOf(i2))) {
            ArrayList arrayList = new ArrayList();
            String str2 = "select " + tcv + " from FavItemInfo where itemStatus > 0";
            if (i2 != -1) {
                str = str2 + " and type = " + i2;
            } else if (set != null) {
                Iterator<Integer> it = set.iterator();
                while (true) {
                    str = str2;
                    if (!it.hasNext()) {
                        break;
                    }
                    str2 = str + " and type != " + it.next().intValue();
                }
            } else {
                str = str2;
            }
            Cursor rawQuery = this.db.rawQuery(str + " order by updateTime desc limit 20", null, 2);
            if (rawQuery == null) {
                AppMethodBeat.o(101699);
                return arrayList;
            }
            while (rawQuery.moveToNext()) {
                g gVar = new g();
                gVar.convertFrom(rawQuery);
                if (wVar == null || !wVar.u(gVar)) {
                    arrayList.add(gVar);
                } else {
                    Log.w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", Integer.valueOf(gVar.field_id), Integer.valueOf(gVar.field_type));
                }
            }
            rawQuery.close();
            AppMethodBeat.o(101699);
            return arrayList;
        }
        Log.w("MicroMsg.Fav.FavItemInfoStorage", "getFirstPageList::block set contains target type, error, do return null");
        AppMethodBeat.o(101699);
        return null;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final LinkedList<Integer> B(long j2, int i2) {
        AppMethodBeat.i(101700);
        LinkedList<Integer> linkedList = new LinkedList<>();
        String concat = "select id from FavItemInfo where updateTime >= ".concat(String.valueOf(j2));
        if (i2 != -1) {
            concat = concat + " and type = " + i2;
        }
        Cursor rawQuery = this.db.rawQuery((concat + " and updateSeq > localSeq") + " order by updateTime desc", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(101700);
            return linkedList;
        }
        while (rawQuery.moveToNext()) {
            linkedList.add(Integer.valueOf(rawQuery.getInt(0)));
        }
        rawQuery.close();
        AppMethodBeat.o(101700);
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final long C(long j2, int i2) {
        AppMethodBeat.i(101701);
        if (this.db == null) {
            Log.e("MicroMsg.Fav.FavItemInfoStorage", "getMinBatchGetUpdateTime, but db is null, return");
            AppMethodBeat.o(101701);
            return 0;
        } else if (j2 == 0) {
            String str = "select updateTime from (select * from FavItemInfo";
            if (i2 != -1) {
                str = str + " where type = " + i2;
            }
            Cursor rawQuery = this.db.rawQuery((str + " order by updateTime desc limit 20") + ") where updateSeq > localSeq", null);
            if (rawQuery == null) {
                AppMethodBeat.o(101701);
                return 0;
            } else if (rawQuery.getCount() == 0) {
                rawQuery.close();
                AppMethodBeat.o(101701);
                return 0;
            } else {
                rawQuery.moveToLast();
                long j3 = rawQuery.getLong(0);
                rawQuery.close();
                AppMethodBeat.o(101701);
                return j3;
            }
        } else {
            String concat = "select updateTime from (select * from FavItemInfo where updateTime < ".concat(String.valueOf(j2));
            if (i2 != -1) {
                concat = concat + " and type = " + i2;
            }
            Cursor rawQuery2 = this.db.rawQuery((concat + " order by updateTime desc ") + ") where updateSeq > localSeq", null);
            if (rawQuery2 == null) {
                AppMethodBeat.o(101701);
                return 0;
            } else if (rawQuery2.getCount() == 0) {
                rawQuery2.close();
                AppMethodBeat.o(101701);
                return 0;
            } else {
                rawQuery2.moveToLast();
                long j4 = rawQuery2.getLong(0);
                rawQuery2.close();
                AppMethodBeat.o(101701);
                return j4;
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 133
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    @Override // com.tencent.mm.plugin.fav.a.x
    public final java.util.List<com.tencent.mm.plugin.fav.a.g> b(long r8, int r10, java.util.Set<java.lang.Integer> r11, com.tencent.mm.plugin.fav.a.w r12) {
        /*
        // Method dump skipped, instructions count: 245
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.b.f.d.b(long, int, java.util.Set, com.tencent.mm.plugin.fav.a.w):java.util.List");
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final List<g> fT(int i2, int i3) {
        AppMethodBeat.i(198781);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery((((("SELECT " + tcv + " FROM FavItemInfo WHERE itemStatus > 0") + " AND (type = 8") + " OR type = 14") + " OR type = 18)") + " ORDER BY updateTime DESC LIMIT " + i2 + " , " + i3, null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(198781);
        } else {
            while (rawQuery.moveToNext()) {
                g gVar = new g();
                gVar.convertFrom(rawQuery);
                arrayList.add(gVar);
            }
            rawQuery.close();
            AppMethodBeat.o(198781);
        }
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final List<g> cUR() {
        LinkedList linkedList = null;
        AppMethodBeat.i(101703);
        Cursor rawQuery = this.db.rawQuery("select " + tcv + " from FavItemInfo where itemStatus=3", null);
        if (rawQuery == null) {
            AppMethodBeat.o(101703);
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.o(101703);
        } else {
            linkedList = new LinkedList();
            while (rawQuery.moveToNext()) {
                g gVar = new g();
                gVar.convertFrom(rawQuery);
                linkedList.add(gVar);
            }
            rawQuery.close();
            AppMethodBeat.o(101703);
        }
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final List<g> cUS() {
        LinkedList linkedList = null;
        AppMethodBeat.i(101704);
        Cursor rawQuery = this.db.rawQuery("select " + tcv + " from FavItemInfo where itemStatus=1", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(101704);
        } else {
            if (rawQuery.moveToFirst()) {
                linkedList = new LinkedList();
                do {
                    g gVar = new g();
                    gVar.convertFrom(rawQuery);
                    linkedList.add(gVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            AppMethodBeat.o(101704);
        }
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final void af(int i2, long j2) {
        AppMethodBeat.i(101705);
        Log.d("MicroMsg.Fav.FavItemInfoStorage", "setStatus status:%d,localId:%d", Integer.valueOf(i2), Long.valueOf(j2));
        this.db.execSQL("FavItemInfo", "update FavItemInfo set itemStatus = " + i2 + " where localId = " + j2);
        doNotify(String.valueOf(j2));
        AppMethodBeat.o(101705);
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final void A(g gVar) {
        AppMethodBeat.i(101706);
        String str = "delete from FavItemInfo where localId = " + gVar.field_localId;
        Log.i("MicroMsg.Fav.FavItemInfoStorage", "delete sql: ".concat(String.valueOf(str)));
        this.db.execSQL("FavItemInfo", str);
        doNotify(new StringBuilder().append(gVar.field_localId).toString(), 5, Long.valueOf(gVar.field_localId));
        AppMethodBeat.o(101706);
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final List<g> cUT() {
        ArrayList arrayList = null;
        AppMethodBeat.i(101707);
        Cursor rawQuery = this.db.rawQuery("select " + tcv + " from FavItemInfo where (itemStatus=9 or itemStatus" + "=12)", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(101707);
        } else {
            if (rawQuery.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.convertFrom(rawQuery);
                    arrayList.add(gVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            AppMethodBeat.o(101707);
        }
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final List<g> cUU() {
        ArrayList arrayList = null;
        AppMethodBeat.i(101708);
        Cursor rawQuery = this.db.rawQuery("select " + tcv + " from FavItemInfo where itemStatus=17", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(101708);
        } else {
            if (rawQuery.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.convertFrom(rawQuery);
                    arrayList.add(gVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            AppMethodBeat.o(101708);
        }
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final List<g> cUV() {
        ArrayList arrayList = null;
        AppMethodBeat.i(101709);
        Cursor rawQuery = this.db.rawQuery("select " + tcv + " from FavItemInfo where itemStatus=3 or itemStatus" + "=6 or itemStatus=11 or itemStatus" + "=14 or itemStatus=16 or itemStatus" + "=18", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(101709);
        } else {
            if (rawQuery.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.convertFrom(rawQuery);
                    arrayList.add(gVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            AppMethodBeat.o(101709);
        }
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final ArrayList<g> a(List<Long> list, List<g> list2, Set<Integer> set, w wVar) {
        ArrayList<g> arrayList;
        g gVar;
        AppMethodBeat.i(101710);
        if (list == null || list.size() == 0 || list.size() > 20) {
            AppMethodBeat.o(101710);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select ").append(tcv).append(" from FavItemInfo where ");
        if (set != null && set.size() > 0) {
            stringBuffer.append("( 1=1");
            for (Integer num : set) {
                stringBuffer.append(" and type != ").append(num);
            }
            stringBuffer.append(") and ");
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 == 0) {
                stringBuffer.append("( ");
            }
            if (i2 == size - 1) {
                stringBuffer.append("localId = ").append(list.get(i2)).append(" )");
            } else {
                stringBuffer.append("localId = ").append(list.get(i2)).append(" or ");
            }
        }
        stringBuffer.append(" order by updateTime desc");
        String stringBuffer2 = stringBuffer.toString();
        Log.d("MicroMsg.Fav.FavItemInfoStorage", "get list by id list sql %s", stringBuffer2);
        Cursor rawQuery = this.db.rawQuery(stringBuffer2, null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(101710);
            return null;
        }
        if (rawQuery.moveToFirst()) {
            ArrayList<g> arrayList2 = new ArrayList<>();
            do {
                if (list2 == null || list2.isEmpty()) {
                    gVar = new g();
                } else {
                    gVar = list2.remove(0);
                }
                gVar.convertFrom(rawQuery);
                if (wVar == null || !wVar.u(gVar)) {
                    arrayList2.add(gVar);
                } else {
                    Log.w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", Integer.valueOf(gVar.field_id), Integer.valueOf(gVar.field_type));
                }
            } while (rawQuery.moveToNext());
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        rawQuery.close();
        AppMethodBeat.o(101710);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final boolean b(g gVar, String... strArr) {
        AppMethodBeat.i(101711);
        if (gVar.field_favProto.Lya != null) {
            anh anh = gVar.field_favProto.Lya;
            if (anh.sourceType <= 0) {
                Log.w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_type), Integer.valueOf(anh.sourceType));
                anh.ajm(1);
            } else {
                anh.ajm(anh.sourceType);
            }
        }
        boolean updateNotify = super.updateNotify(gVar, false, strArr);
        AppMethodBeat.o(101711);
        return updateNotify;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final List<g> cUW() {
        ArrayList arrayList = null;
        AppMethodBeat.i(101712);
        Cursor rawQuery = this.db.rawQuery("select " + tcv + " from FavItemInfo where flag =  -1 and itemStatus = 0 ", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(101712);
        } else {
            if (rawQuery.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.convertFrom(rawQuery);
                    arrayList.add(gVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            AppMethodBeat.o(101712);
        }
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final List<Long> cUX() {
        AppMethodBeat.i(101713);
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        String str = "";
        int[] iArr = a.sZP;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            str = str + iArr[i2] + ",";
        }
        if (str.endsWith(",")) {
            str = str.substring(0, str.length() - 1);
        }
        String str2 = ("select localId from FavItemInfo where " + " itemStatus in (" + str + ")") + " and datatotalsize > 0 ";
        String str3 = "";
        int[] iArr2 = a.sZO;
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            str3 = str3 + iArr2[i3] + ",";
        }
        if (str3.endsWith(",")) {
            str3 = str3.substring(0, str3.length() - 1);
        }
        Cursor rawQuery = this.db.rawQuery((str2 + " and type in (" + str3 + ")") + " order by datatotalsize desc", null);
        if (rawQuery == null) {
            AppMethodBeat.o(101713);
            return arrayList;
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.o(101713);
            return arrayList;
        } else {
            while (rawQuery.moveToNext()) {
                arrayList.add(Long.valueOf(rawQuery.getLong(0)));
            }
            rawQuery.close();
            Log.i("MicroMsg.Fav.FavItemInfoStorage", "getCleanList cu.getCount() = %d,used %dms", Integer.valueOf(arrayList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(101713);
            return arrayList;
        }
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final void cUY() {
        long j2;
        AppMethodBeat.i(101714);
        Log.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength");
        String str = "select " + tcv + " from FavItemInfo where ";
        String str2 = "";
        int[] iArr = a.sZP;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            str2 = str2 + iArr[i2] + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        String str3 = str + "itemStatus in (" + str2 + ")";
        String str4 = "";
        int[] iArr2 = a.sZO;
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            str4 = str4 + iArr2[i3] + ",";
        }
        if (str4.endsWith(",")) {
            str4 = str4.substring(0, str4.length() - 1);
        }
        Cursor rawQuery = this.db.rawQuery(str3 + " and type in (" + str4 + ")", null);
        if (rawQuery == null) {
            Log.e("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu = null");
            AppMethodBeat.o(101714);
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            Log.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = 0");
            AppMethodBeat.o(101714);
        } else {
            Log.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = " + rawQuery.getCount());
            long beginTransaction = this.db instanceof h ? ((h) this.db).beginTransaction(Thread.currentThread().getId()) : 0;
            while (rawQuery.moveToNext()) {
                g gVar = new g();
                gVar.convertFrom(rawQuery);
                if (HY(gVar.field_itemStatus)) {
                    if (gVar.field_favProto != null) {
                        Iterator<aml> it = gVar.field_favProto.ppH.iterator();
                        j2 = 0;
                        while (it.hasNext()) {
                            j2 = it.next().LvI + j2;
                        }
                    } else {
                        j2 = 0;
                    }
                    gVar.field_datatotalsize = j2;
                    a(gVar, ch.COL_LOCALID);
                }
            }
            if (this.db instanceof h) {
                ((h) this.db).endTransaction(beginTransaction);
            }
            rawQuery.close();
            Log.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength end");
            AppMethodBeat.o(101714);
        }
    }

    private static boolean HY(int i2) {
        for (int i3 : a.sZP) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final List<Long> cUZ() {
        AppMethodBeat.i(101715);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery("select localId from FavItemInfo" + " order by updateTime desc", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(101715);
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.o(101715);
        } else {
            while (rawQuery.moveToNext()) {
                arrayList.add(Long.valueOf(rawQuery.getLong(0)));
            }
            rawQuery.close();
            AppMethodBeat.o(101715);
        }
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.fav.a.x
    public final int HX(int i2) {
        AppMethodBeat.i(101716);
        try {
            Cursor rawQuery = this.db.rawQuery("select count(*) from FavItemInfo where id>".concat(String.valueOf(i2)), null, 2);
            if (rawQuery == null) {
                AppMethodBeat.o(101716);
                return -1;
            } else if (rawQuery.getCount() == 0) {
                rawQuery.close();
                AppMethodBeat.o(101716);
                return -1;
            } else {
                rawQuery.moveToNext();
                int i3 = rawQuery.getInt(0);
                rawQuery.close();
                AppMethodBeat.o(101716);
                return i3;
            }
        } catch (Throwable th) {
            Log.w("MicroMsg.Fav.FavItemInfoStorage", "getFavHomePosition failed with throwable: " + th.getMessage());
            AppMethodBeat.o(101716);
            return -1;
        }
    }
}
