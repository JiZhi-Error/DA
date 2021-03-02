package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ax extends MAutoStorage<au> implements g.a {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(au.info, "ContactLabel")};
    public HashMap<Integer, ArrayList<String>> OoA;
    private HashMap<String, int[]> Ooz;
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean delete(au auVar, String[] strArr) {
        AppMethodBeat.i(32875);
        boolean a2 = a(true, auVar, strArr);
        AppMethodBeat.o(32875);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(au auVar) {
        AppMethodBeat.i(32876);
        boolean a2 = a(true, auVar);
        AppMethodBeat.o(32876);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(au auVar) {
        AppMethodBeat.i(32873);
        au auVar2 = auVar;
        boolean replace = super.replace(auVar2);
        if (replace) {
            doNotify(a("replace", auVar2));
        }
        aHn();
        AppMethodBeat.o(32873);
        return replace;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(au auVar, String[] strArr) {
        AppMethodBeat.i(32874);
        boolean b2 = b(true, auVar, strArr);
        AppMethodBeat.o(32874);
        return b2;
    }

    static {
        AppMethodBeat.i(32877);
        AppMethodBeat.o(32877);
    }

    public enum a {
        EQUAL,
        NOEQUAL,
        NOEXISTS;

        public static a valueOf(String str) {
            AppMethodBeat.i(32844);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(32844);
            return aVar;
        }

        static {
            AppMethodBeat.i(32845);
            AppMethodBeat.o(32845);
        }
    }

    public ax(ISQLiteDatabase iSQLiteDatabase) {
        this(iSQLiteDatabase, au.info, "ContactLabel");
    }

    private ax(ISQLiteDatabase iSQLiteDatabase, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str) {
        super(iSQLiteDatabase, mAutoDBInfo, str, null);
        AppMethodBeat.i(32846);
        this.Ooz = null;
        this.OoA = null;
        this.db = iSQLiteDatabase;
        iSQLiteDatabase.execSQL("ContactLabel", "CREATE INDEX IF NOT EXISTS  contact_label_createtime_index ON ContactLabel ( createTime )");
        AppMethodBeat.o(32846);
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    public final ArrayList<String> gBU() {
        ArrayList<String> arrayList = null;
        AppMethodBeat.i(32847);
        long nowMilliSecond = Util.nowMilliSecond();
        Cursor query = this.db.query("ContactLabel", new String[]{"labelName"}, null, null, null, null, "createTime ASC ", 2);
        if (query == null) {
            AppMethodBeat.o(32847);
        } else {
            arrayList = new ArrayList<>();
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            query.close();
            Log.i("MicroMsg.Label.ContactLabelStorage", "getAllLabel time:%s count:%s stack:%s", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), Integer.valueOf(arrayList.size()), Util.getStack());
            AppMethodBeat.o(32847);
        }
        return arrayList;
    }

    public final ArrayList<au> gBV() {
        ArrayList<au> arrayList = null;
        AppMethodBeat.i(32848);
        long nowMilliSecond = Util.nowMilliSecond();
        Cursor rawQuery = this.db.rawQuery("select * from ContactLabel order by createTime ASC ", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(32848);
        } else {
            arrayList = new ArrayList<>();
            while (rawQuery.moveToNext()) {
                au auVar = new au();
                auVar.convertFrom(rawQuery);
                arrayList.add(auVar);
            }
            rawQuery.close();
            Log.i("MicroMsg.Label.ContactLabelStorage", "getAllContactLable time:%s count:%s stack:%s", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), Integer.valueOf(arrayList.size()), Util.getStack());
            AppMethodBeat.o(32848);
        }
        return arrayList;
    }

    public final void aHn() {
        AppMethodBeat.i(32849);
        Log.v("MicroMsg.Label.ContactLabelStorage", "cleanCache %s", Util.getStack());
        this.Ooz = null;
        this.OoA = null;
        AppMethodBeat.o(32849);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 129
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    public final void gBW() {
        /*
        // Method dump skipped, instructions count: 244
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ax.gBW():void");
    }

    public final ArrayList<String> bjA(String str) {
        int i2 = -1;
        AppMethodBeat.i(32851);
        long nowMilliSecond = Util.nowMilliSecond();
        int i3 = Util.getInt(str, -1);
        if (i3 == -1) {
            Log.e("MicroMsg.Label.ContactLabelStorage", "getUserNameListById  failed id:%s", str);
            AppMethodBeat.o(32851);
            return null;
        }
        gBW();
        ArrayList<String> arrayList = this.OoA.get(Integer.valueOf(i3));
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(Util.milliSecondsToNow(nowMilliSecond));
        objArr[1] = str;
        if (arrayList != null) {
            i2 = arrayList.size();
        }
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Util.getStack();
        Log.i("MicroMsg.Label.ContactLabelStorage", "getUserNameListById time:%s id:%s count:%s stack:%s", objArr);
        AppMethodBeat.o(32851);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<java.lang.String> J(java.lang.String r10, java.util.List<java.lang.String> r11) {
        /*
        // Method dump skipped, instructions count: 217
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ax.J(java.lang.String, java.util.List):java.util.ArrayList");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<java.lang.String> X(java.lang.String[] r10) {
        /*
        // Method dump skipped, instructions count: 229
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ax.X(java.lang.String[]):java.util.ArrayList");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<java.lang.String> bi(java.util.ArrayList<java.lang.String> r10) {
        /*
        // Method dump skipped, instructions count: 246
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ax.bi(java.util.ArrayList):java.util.ArrayList");
    }

    private boolean a(boolean z, au auVar) {
        AppMethodBeat.i(32855);
        boolean insert = super.insert(auVar);
        if (insert && z) {
            doNotify(a("insert", auVar));
        }
        AppMethodBeat.o(32855);
        return insert;
    }

    public final boolean gC(String str) {
        int i2;
        AppMethodBeat.i(32856);
        Log.i("MicroMsg.Label.ContactLabelStorage", "cpan[delete] labelID:%s", String.valueOf(str));
        Log.d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", "labelID =? ");
        try {
            i2 = this.db.delete("ContactLabel", "labelID =? ", new String[]{str});
        } catch (Exception e2) {
            Log.w("MicroMsg.Label.ContactLabelStorage", "cpan[delete] exception %s", e2.toString());
            i2 = -1;
        }
        if (i2 > 0) {
            AppMethodBeat.o(32856);
            return true;
        }
        AppMethodBeat.o(32856);
        return false;
    }

    private boolean a(boolean z, au auVar, String... strArr) {
        AppMethodBeat.i(32857);
        boolean delete = super.delete(auVar, strArr);
        if (delete && z) {
            doNotify(a("delete", auVar));
            gBX();
        }
        aHn();
        AppMethodBeat.o(32857);
        return delete;
    }

    public final boolean a(au auVar, String... strArr) {
        AppMethodBeat.i(32858);
        boolean a2 = a(true, auVar, strArr);
        AppMethodBeat.o(32858);
        return a2;
    }

    public final boolean b(boolean z, au auVar, String... strArr) {
        AppMethodBeat.i(32859);
        boolean update = super.update(auVar, strArr);
        if (update && z) {
            doNotify(a("update", auVar));
        }
        aHn();
        AppMethodBeat.o(32859);
        return update;
    }

    public final boolean iF(List<au> list) {
        long j2;
        AppMethodBeat.i(32860);
        if (list.size() <= 0) {
            Log.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertAddLabel] list is null.");
            AppMethodBeat.o(32860);
        } else {
            h hVar = null;
            if (this.db instanceof h) {
                h hVar2 = (h) this.db;
                j2 = hVar2.beginTransaction(Thread.currentThread().getId());
                Log.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", Long.valueOf(j2));
                hVar = hVar2;
            } else {
                j2 = -1;
            }
            int size = list.size();
            new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                String c2 = c(list.get(i2));
                if (!Util.isNullOrNil(c2)) {
                    gC(c2);
                }
            }
            if (hVar != null) {
                hVar.endTransaction(j2);
                Log.i("MicroMsg.Label.ContactLabelStorage", "end deleteLocalLabel transaction");
            }
            aHn();
            AppMethodBeat.o(32860);
        }
        return false;
    }

    public final boolean iG(List<au> list) {
        long j2;
        AppMethodBeat.i(32861);
        if (list.size() <= 0) {
            Log.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] list is null.");
            AppMethodBeat.o(32861);
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            h hVar = null;
            if (this.db instanceof h) {
                h hVar2 = (h) this.db;
                j2 = hVar2.beginTransaction(Thread.currentThread().getId());
                Log.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", Long.valueOf(j2));
                hVar = hVar2;
            } else {
                j2 = -1;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                au auVar = list.get(i2);
                if (auVar != null) {
                    switch (b(auVar)) {
                        case EQUAL:
                            break;
                        case NOEQUAL:
                            b(false, auVar, "labelID");
                            arrayList2.add(auVar);
                            continue;
                        case NOEXISTS:
                            auVar.field_createTime = System.currentTimeMillis();
                            a(false, auVar);
                            arrayList.add(auVar);
                            continue;
                        default:
                            Log.w("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] unknow result.");
                            continue;
                    }
                }
            }
            if (hVar != null) {
                hVar.endTransaction(j2);
                Log.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
            }
            if (arrayList.size() > 0) {
                doNotify(K("insert", arrayList));
            }
            if (arrayList2.size() > 0) {
                doNotify(K("update", arrayList2));
            }
            aHn();
            AppMethodBeat.o(32861);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String aCG(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 137
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ax.aCG(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String aCH(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 137
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ax.aCH(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.au bjB(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ax.bjB(java.lang.String):com.tencent.mm.storage.au");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.au bjC(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ax.bjC(java.lang.String):com.tencent.mm.storage.au");
    }

    private a b(au auVar) {
        AppMethodBeat.i(32866);
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.db.rawQuery("select * from ContactLabel where labelID=?", new String[]{new StringBuilder().append(auVar.field_labelID).toString()}, 2);
            if (rawQuery == null || !rawQuery.moveToFirst()) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                a aVar = a.NOEXISTS;
                AppMethodBeat.o(32866);
                return aVar;
            }
            if (auVar.field_labelName.equalsIgnoreCase(Util.nullAs(rawQuery.getString(rawQuery.getColumnIndex("labelName")), ""))) {
                a aVar2 = a.EQUAL;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(32866);
                return aVar2;
            }
            a aVar3 = a.NOEQUAL;
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.o(32866);
            return aVar3;
        } catch (Exception e2) {
            Log.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", e2.toString());
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(32866);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String c(com.tencent.mm.storage.au r12) {
        /*
        // Method dump skipped, instructions count: 187
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ax.c(com.tencent.mm.storage.au):java.lang.String");
    }

    private static String a(String str, au auVar) {
        AppMethodBeat.i(32868);
        if (auVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(auVar);
            String K = K(str, arrayList);
            AppMethodBeat.o(32868);
            return K;
        }
        AppMethodBeat.o(32868);
        return null;
    }

    private static String K(String str, List<au> list) {
        AppMethodBeat.i(32869);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" ");
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(32869);
            return null;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            au auVar = list.get(i2);
            if (auVar != null) {
                sb.append(auVar.field_labelID);
                if (i2 < size - 1) {
                    sb.append(" ");
                }
            }
        }
        Log.i("MicroMsg.Label.ContactLabelStorage", "cpan[genNotifyString] event:%s", sb.toString());
        String sb2 = sb.toString();
        AppMethodBeat.o(32869);
        return sb2;
    }

    private static void gBX() {
        AppMethodBeat.i(32870);
        Log.i("MicroMsg.Label.ContactLabelStorage", "cpan[publishUpdateSearchIndexEvent]");
        yr yrVar = new yr();
        yrVar.eeW.gY = 3000;
        EventCenter.instance.publish(yrVar);
        AppMethodBeat.o(32870);
    }

    public final boolean iH(List<au> list) {
        long j2;
        AppMethodBeat.i(32871);
        if (list == null || list.size() <= 0) {
            Log.w("MicroMsg.Label.ContactLabelStorage", "cpan[deleteList] list is null.");
            AppMethodBeat.o(32871);
            return false;
        }
        h hVar = null;
        if (this.db instanceof h) {
            h hVar2 = (h) this.db;
            j2 = hVar2.beginTransaction(Thread.currentThread().getId());
            Log.i("MicroMsg.Label.ContactLabelStorage", "begin deleteList in a transaction, ticket = %d", Long.valueOf(j2));
            hVar = hVar2;
        } else {
            j2 = -1;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(false, list.get(i2), "labelID");
        }
        if (hVar != null) {
            hVar.endTransaction(j2);
            Log.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
        }
        doNotify(K("delete", list));
        gBX();
        AppMethodBeat.o(32871);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<com.tencent.mm.storage.au> iI(java.util.List<com.tencent.mm.storage.au> r10) {
        /*
        // Method dump skipped, instructions count: 243
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ax.iI(java.util.List):java.util.ArrayList");
    }
}
