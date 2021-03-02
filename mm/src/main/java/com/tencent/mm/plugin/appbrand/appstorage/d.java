package com.tencent.mm.plugin.appbrand.appstorage;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.x;

public class d extends MAutoStorage<c> implements p {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "AppBrandKVData"), "DROP TABLE IF EXISTS AppBrandStorageKVData;"};
    private ISQLiteDatabase kLX;
    private b<String, String> kRJ = new b<String, String>() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.d.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(String str) {
            AppMethodBeat.i(169485);
            c cVar = new c();
            cVar.field_key = str;
            if (!d.a(d.this, cVar, new String[0])) {
                AppMethodBeat.o(169485);
                return null;
            }
            String str2 = cVar.field_data;
            AppMethodBeat.o(169485);
            return str2;
        }
    };
    private m<String, String, x> kRK = new m<String, String, x>() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.d.AnonymousClass3 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(String str, String str2) {
            AppMethodBeat.i(169486);
            c cVar = new c();
            cVar.field_key = str;
            cVar.field_data = str2;
            d.b(d.this, cVar);
            AppMethodBeat.o(169486);
            return null;
        }
    };

    static /* synthetic */ int a(d dVar, int i2, String str, int i3) {
        AppMethodBeat.i(169489);
        int h2 = dVar.h(i2, str, i3);
        AppMethodBeat.o(169489);
        return h2;
    }

    static /* synthetic */ boolean a(d dVar, IAutoDBItem iAutoDBItem) {
        AppMethodBeat.i(169487);
        boolean replace = super.replace(iAutoDBItem);
        AppMethodBeat.o(169487);
        return replace;
    }

    static /* synthetic */ boolean a(d dVar, IAutoDBItem iAutoDBItem, String[] strArr) {
        AppMethodBeat.i(169490);
        boolean z = super.get(iAutoDBItem, strArr);
        AppMethodBeat.o(169490);
        return z;
    }

    static /* synthetic */ boolean b(d dVar, IAutoDBItem iAutoDBItem) {
        AppMethodBeat.i(169491);
        boolean replace = super.replace(iAutoDBItem);
        AppMethodBeat.o(169491);
        return replace;
    }

    static {
        AppMethodBeat.i(146951);
        AppMethodBeat.o(146951);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "AppBrandKVData", null);
        AppMethodBeat.i(146935);
        this.kLX = iSQLiteDatabase;
        AppMethodBeat.o(146935);
    }

    public final Object[] l(int i2, String str, String str2) {
        AppMethodBeat.i(146936);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Object[] objArr = {p.a.MISSING_PARAMS};
            AppMethodBeat.o(146936);
            return objArr;
        }
        c cVar = new c();
        cVar.field_key = t.c(i2, str, str2, "__");
        try {
            if (super.get(cVar, new String[0])) {
                Object[] objArr2 = {p.a.NONE, cVar.field_data, cVar.field_dataType};
                AppMethodBeat.o(146936);
                return objArr2;
            }
            Object[] objArr3 = t.kSW;
            AppMethodBeat.o(146936);
            return objArr3;
        } catch (SQLiteException e2) {
            if (Util.nullAsNil(e2.getMessage()).contains("no such table")) {
                Log.e("AppBrandKVStorage", "get storageId[%d] appId[%s] key[%s], no such table, return RET_GET_NO_SUCH_KEY", Integer.valueOf(i2), str, str2);
                Object[] objArr4 = t.kSW;
                AppMethodBeat.o(146936);
                return objArr4;
            } else if (e2.getClass().getName().endsWith("CursorWindowAllocationException")) {
                Object[] objArr5 = {p.a.MEMORY_ISSUE};
                AppMethodBeat.o(146936);
                return objArr5;
            } else {
                AppMethodBeat.o(146936);
                throw e2;
            }
        }
    }

    public final p.a c(final int i2, final String str, String str2, String str3, String str4) {
        boolean z;
        AppMethodBeat.i(146937);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            p.a aVar = p.a.MISSING_PARAMS;
            AppMethodBeat.o(146937);
            return aVar;
        }
        String c2 = t.c(i2, str, str2, "__");
        int VM = VM(c2);
        int cF = t.cF(str2, str3);
        final int i3 = cF - VM;
        if (aa(i2, str) + i3 >= t.ab(i2, str)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            p.a aVar2 = p.a.QUOTA_REACHED;
            AppMethodBeat.o(146937);
            return aVar2;
        }
        final c cVar = new c();
        cVar.field_key = c2;
        cVar.field_data = str3;
        cVar.field_dataType = str4;
        cVar.field_size = cF;
        AnonymousClass1 r1 = new a<p.a>() {
            /* class com.tencent.mm.plugin.appbrand.appstorage.d.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ p.a invoke() {
                AppMethodBeat.i(169484);
                if (d.a(d.this, cVar)) {
                    d.a(d.this, str, i2);
                    d.a(d.this, i2, str, i3);
                    p.a aVar = p.a.NONE;
                    AppMethodBeat.o(169484);
                    return aVar;
                }
                p.a aVar2 = p.a.UNKNOWN;
                AppMethodBeat.o(169484);
                return aVar2;
            }
        };
        try {
            p.a aVar3 = (p.a) r1.invoke();
            AppMethodBeat.o(146937);
            return aVar3;
        } catch (SQLiteException e2) {
            if (Util.nullAsNil(e2.getMessage()).contains("no such table")) {
                Log.e("AppBrandKVStorage", "set storageId[%d] appId[%s] key[%s], get exception[%s] try create table", Integer.valueOf(i2), str, str2, e2);
                try {
                    IAutoDBItem.MAutoDBInfo mAutoDBInfo = c.info;
                    ISQLiteDatabase iSQLiteDatabase = this.kLX;
                    String tableName = getTableName();
                    for (String str5 : getUpdateSQLs(mAutoDBInfo, getTableName(), iSQLiteDatabase)) {
                        if (!iSQLiteDatabase.execSQL(tableName, str5)) {
                            Log.e("AppBrandKVStorage", "updateColumnSQLs table failed %s, sql %s", tableName, str5);
                        }
                    }
                    p.a aVar4 = (p.a) r1.invoke();
                    AppMethodBeat.o(146937);
                    return aVar4;
                } catch (SQLiteException e3) {
                    String format = String.format(Locale.ENGLISH, "set storageId[%d] appId[%s] key[%s], get exception[%s] after retry", Integer.valueOf(i2), str, str2, e2);
                    Log.e("AppBrandKVStorage", format);
                    SQLiteException sQLiteException = new SQLiteException(format, e3);
                    AppMethodBeat.o(146937);
                    throw sQLiteException;
                }
            } else {
                AppMethodBeat.o(146937);
                throw e2;
            }
        }
    }

    public final p.a m(int i2, String str, String str2) {
        AppMethodBeat.i(146938);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            p.a aVar = p.a.MISSING_PARAMS;
            AppMethodBeat.o(146938);
            return aVar;
        }
        String c2 = t.c(i2, str, str2, "__");
        int h2 = h(i2, str, -VM(c2));
        c cVar = new c();
        cVar.field_key = c2;
        super.delete(cVar, new String[0]);
        if (h2 <= 0) {
            be(str, i2);
        }
        p.a aVar2 = p.a.NONE;
        AppMethodBeat.o(146938);
        return aVar2;
    }

    public final void Y(int i2, String str) {
        String str2;
        AppMethodBeat.i(146939);
        if (i2 == 0) {
            str2 = str + "__";
        } else {
            str2 = i2 + "__" + str + "__";
        }
        be(str, i2);
        this.kLX.delete("AppBrandKVData", String.format("%s like ? escape ? OR %s=?", "key", "key"), new String[]{str2.replace("_", "\\_") + "%", "\\", t.n(i2, str, "@@@TOTAL@DATA@SIZE@@@")});
        AppMethodBeat.o(146939);
    }

    public final void VJ(String str) {
        AppMethodBeat.i(146940);
        for (int i2 = 0; i2 <= 2; i2++) {
            Y(i2, str);
        }
        AppMethodBeat.o(146940);
    }

    public final int[] VK(String str) {
        AppMethodBeat.i(146941);
        int[] a2 = t.a(str, this.kRJ, this.kRK);
        AppMethodBeat.o(146941);
        return a2;
    }

    private void be(String str, int i2) {
        AppMethodBeat.i(146942);
        t.b(str, i2, this.kRJ, this.kRK);
        AppMethodBeat.o(146942);
    }

    public final Object[] Z(int i2, String str) {
        String str2;
        AppMethodBeat.i(146943);
        if (i2 == 0) {
            str2 = str + "__";
        } else {
            str2 = i2 + "__" + str + "__";
        }
        Cursor query = this.kLX.query("AppBrandKVData", new String[]{"key"}, "key like ? escape ?", new String[]{str2.replace("_", "\\_") + "%", "\\"}, null, null, null, 2);
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            arrayList.add(query.getString(0).replace(str2, ""));
        }
        query.close();
        Object[] objArr = {arrayList, Integer.valueOf(aa(i2, str)), Integer.valueOf(t.ab(i2, str))};
        AppMethodBeat.o(146943);
        return objArr;
    }

    private int aa(int i2, String str) {
        AppMethodBeat.i(146944);
        c cVar = new c();
        cVar.field_key = t.n(i2, str, "@@@TOTAL@DATA@SIZE@@@");
        if (super.get(cVar, new String[0])) {
            int i3 = Util.getInt(cVar.field_data, 0);
            AppMethodBeat.o(146944);
            return i3;
        }
        AppMethodBeat.o(146944);
        return 0;
    }

    public final int VL(String str) {
        AppMethodBeat.i(146945);
        int[] VK = VK(str);
        int length = VK.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            i2++;
            i3 = aa(VK[i2], str) + i3;
        }
        AppMethodBeat.o(146945);
        return i3;
    }

    private void g(int i2, String str, int i3) {
        AppMethodBeat.i(146946);
        c cVar = new c();
        cVar.field_key = t.n(i2, str, "@@@TOTAL@DATA@SIZE@@@");
        cVar.field_data = String.valueOf(i3);
        super.replace(cVar);
        AppMethodBeat.o(146946);
    }

    private int h(int i2, String str, int i3) {
        AppMethodBeat.i(146947);
        int max = Math.max(0, aa(i2, str) + i3);
        g(i2, str, max);
        AppMethodBeat.o(146947);
        return max;
    }

    private int VM(String str) {
        AppMethodBeat.i(146948);
        Cursor query = this.kLX.query("AppBrandKVData", new String[]{"size"}, "key = ?", new String[]{str}, null, null, null, 2);
        if (query.moveToFirst()) {
            int i2 = query.getInt(0);
            query.close();
            AppMethodBeat.o(146948);
            return i2;
        }
        query.close();
        AppMethodBeat.o(146948);
        return 0;
    }

    static /* synthetic */ void a(d dVar, String str, int i2) {
        AppMethodBeat.i(169488);
        t.a(str, i2, dVar.kRJ, dVar.kRK);
        AppMethodBeat.o(169488);
    }
}
