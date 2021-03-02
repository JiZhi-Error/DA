package com.tencent.mm.storagebase.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCursorDriver;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteProgram;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class f extends AbstractCursor implements d {
    public static final SQLiteDatabase.CursorFactory FACTORY = new SQLiteDatabase.CursorFactory() {
        /* class com.tencent.mm.storagebase.a.f.AnonymousClass2 */

        @Override // com.tencent.wcdb.database.SQLiteDatabase.CursorFactory
        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram) {
            AppMethodBeat.i(133477);
            f fVar = new f(sQLiteCursorDriver, str, (h) sQLiteProgram);
            AppMethodBeat.o(133477);
            return fVar;
        }

        @Override // com.tencent.wcdb.database.SQLiteDatabase.CursorFactory
        public final SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
            AppMethodBeat.i(133478);
            h hVar = new h(sQLiteDatabase, str, cancellationSignal);
            AppMethodBeat.o(133478);
            return hVar;
        }
    };
    private final h OtX;
    private final Throwable OtY;
    public a OtZ;
    private boolean Oua;
    private b<a> Oub;
    c Ouc;
    private boolean Oud;
    private Map<String, Integer> mColumnNameMap;
    private final String[] mColumns;
    private int mCount = -1;
    private final SQLiteCursorDriver mDriver;
    private final String mEditTable;
    private int pageSize = 3000;

    public interface a {
        ArrayList<a> bo(ArrayList<Object> arrayList);

        a gFJ();
    }

    public f(SQLiteCursorDriver sQLiteCursorDriver, String str, h hVar) {
        AppMethodBeat.i(133479);
        if (hVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("query object cannot be null");
            AppMethodBeat.o(133479);
            throw illegalArgumentException;
        }
        this.OtY = null;
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mColumnNameMap = null;
        this.OtX = hVar;
        this.mColumns = hVar.getColumnNames();
        this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
        AppMethodBeat.o(133479);
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final void akA(int i2) {
        if (i2 <= 15000 && i2 >= 2000) {
            this.pageSize = i2;
        }
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final void AO(boolean z) {
        this.Oua = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    @Override // com.tencent.wcdb.CrossProcessCursor, com.tencent.wcdb.AbstractCursor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onMove(int r7, int r8) {
        /*
            r6 = this;
            r5 = 133480(0x20968, float:1.87045E-40)
            r1 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            boolean r0 = r6.Oua
            if (r0 == 0) goto L_0x0025
            com.tencent.mm.storagebase.a.b<com.tencent.mm.storagebase.a.a> r0 = r6.Oub
            if (r0 == 0) goto L_0x0017
            com.tencent.mm.storagebase.a.b<com.tencent.mm.storagebase.a.a> r0 = r6.Oub
            boolean r0 = r0.akB(r8)
            if (r0 != 0) goto L_0x0021
        L_0x0017:
            int r0 = r6.pageSize
            int r0 = r8 / r0
            int r2 = r6.pageSize
            int r0 = r0 * r2
            r6.akC(r0)
        L_0x0021:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return r1
        L_0x0025:
            com.tencent.mm.storagebase.a.c r0 = r6.Ouc
            if (r0 != 0) goto L_0x002c
            r6.gFK()
        L_0x002c:
            com.tencent.mm.storagebase.a.c r0 = r6.Ouc
            int r2 = r0.OtQ
            int r2 = r8 / r2
            android.util.SparseArray<java.lang.Object[]> r3 = r0.OtP
            int r3 = r3.indexOfKey(r2)
            if (r3 < 0) goto L_0x0060
            int r3 = r0.OtQ
            int r3 = r8 % r3
            int r4 = r0.columnCount
            int r3 = r3 * r4
            android.util.SparseArray<java.lang.Object[]> r0 = r0.OtP
            java.lang.Object r0 = r0.get(r2)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r0 = r0[r3]
            if (r0 == 0) goto L_0x0060
            r0 = r1
        L_0x004e:
            if (r0 != 0) goto L_0x005a
            int r0 = r6.pageSize
            int r0 = r8 / r0
            int r2 = r6.pageSize
            int r0 = r0 * r2
            r6.akC(r0)
        L_0x005a:
            com.tencent.mm.storagebase.a.c r0 = r6.Ouc
            r0.moveToPosition(r8)
            goto L_0x0021
        L_0x0060:
            r0 = 0
            goto L_0x004e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storagebase.a.f.onMove(int, int):boolean");
    }

    private void gFK() {
        AppMethodBeat.i(133481);
        if (this.Ouc == null) {
            this.Ouc = new c(this.mColumns, (byte) 0);
        }
        AppMethodBeat.o(133481);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final int getCount() {
        AppMethodBeat.i(133482);
        if (this.mCount == -1) {
            this.mCount = akC(0);
            if (this.Oub != null) {
                this.Oud = this.mCount != -1 && this.mCount == this.Oub.OtK.size();
            }
        }
        if (!this.Oua || !this.Oud) {
            int i2 = this.mCount;
            AppMethodBeat.o(133482);
            return i2;
        } else if (this.Oub == null) {
            AppMethodBeat.o(133482);
            return 0;
        } else {
            int size = this.Oub.OtK.size();
            AppMethodBeat.o(133482);
            return size;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor
    public final void checkPosition() {
        AppMethodBeat.i(133483);
        super.checkPosition();
        AppMethodBeat.o(133483);
    }

    private int akC(int i2) {
        AppMethodBeat.i(133484);
        if (this.Oua) {
            if (this.Oub == null) {
                this.Oub = new b<a>() {
                    /* class com.tencent.mm.storagebase.a.f.AnonymousClass1 */

                    @Override // com.tencent.mm.storagebase.a.b
                    public final a gFJ() {
                        AppMethodBeat.i(133475);
                        f fVar = f.this;
                        if (fVar.OtZ != null) {
                            a gFJ = fVar.OtZ.gFJ();
                            AppMethodBeat.o(133475);
                            return gFJ;
                        }
                        AppMethodBeat.o(133475);
                        return null;
                    }

                    @Override // com.tencent.mm.storagebase.a.b
                    public final ArrayList<a> bo(ArrayList<Object> arrayList) {
                        AppMethodBeat.i(133476);
                        f fVar = f.this;
                        if (fVar.OtZ != null) {
                            ArrayList<a> bo = fVar.OtZ.bo(arrayList);
                            AppMethodBeat.o(133476);
                            return bo;
                        }
                        AppMethodBeat.o(133476);
                        return null;
                    }
                };
            }
            this.Oub.mStartPos = i2;
            int a2 = this.OtX.a(this.Oub, i2, this.pageSize);
            AppMethodBeat.o(133484);
            return a2;
        }
        gFK();
        int a3 = this.OtX.a(this.Ouc, i2, this.pageSize);
        AppMethodBeat.o(133484);
        return a3;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final int getColumnIndex(String str) {
        AppMethodBeat.i(133485);
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            HashMap hashMap = new HashMap(length, 1.0f);
            for (int i2 = 0; i2 < length; i2++) {
                hashMap.put(strArr[i2], Integer.valueOf(i2));
            }
            this.mColumnNameMap = hashMap;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            Log.e("WCDB.SQLiteNewCursor", "requesting column name with table name -- ".concat(String.valueOf(str)), new Exception());
            str = str.substring(lastIndexOf + 1);
        }
        Integer num = this.mColumnNameMap.get(str);
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(133485);
            return intValue;
        }
        AppMethodBeat.o(133485);
        return -1;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final String[] getColumnNames() {
        return this.mColumns;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void deactivate() {
        AppMethodBeat.i(133486);
        super.deactivate();
        this.mDriver.cursorDeactivated();
        AppMethodBeat.o(133486);
    }

    @Override // java.io.Closeable, com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(133487);
        super.close();
        synchronized (this) {
            try {
                this.OtX.close();
                this.mDriver.cursorClosed();
            } finally {
                AppMethodBeat.o(133487);
            }
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final boolean requery() {
        boolean z = false;
        AppMethodBeat.i(133488);
        if (isClosed()) {
            AppMethodBeat.o(133488);
        } else {
            synchronized (this) {
                try {
                    if (this.OtX.getDatabase().isOpen()) {
                        if (this.Oub != null) {
                            this.Oub.clearData();
                        }
                        this.mPos = -1;
                        this.mCount = -1;
                        this.mDriver.cursorRequeried(this);
                        try {
                            z = super.requery();
                            AppMethodBeat.o(133488);
                        } catch (IllegalStateException e2) {
                            Log.w("WCDB.SQLiteNewCursor", "requery() failed " + e2.getMessage(), e2);
                            AppMethodBeat.o(133488);
                        }
                    }
                } finally {
                    AppMethodBeat.o(133488);
                }
            }
        }
        return z;
    }

    @Override // com.tencent.wcdb.AbstractCursor, java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(133489);
        try {
            if (this.Oub != null) {
                close();
            }
        } finally {
            super.finalize();
            AppMethodBeat.o(133489);
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final String getString(int i2) {
        AppMethodBeat.i(133490);
        if (!this.Oua) {
            String string = this.Ouc.getString(i2);
            AppMethodBeat.o(133490);
            return string;
        }
        AppMethodBeat.o(133490);
        return null;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final short getShort(int i2) {
        AppMethodBeat.i(133491);
        if (!this.Oua) {
            short s = this.Ouc.getShort(i2);
            AppMethodBeat.o(133491);
            return s;
        }
        AppMethodBeat.o(133491);
        return 0;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final int getInt(int i2) {
        AppMethodBeat.i(133492);
        if (!this.Oua) {
            int i3 = this.Ouc.getInt(i2);
            AppMethodBeat.o(133492);
            return i3;
        }
        AppMethodBeat.o(133492);
        return 0;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final long getLong(int i2) {
        AppMethodBeat.i(133493);
        if (!this.Oua) {
            long j2 = this.Ouc.getLong(i2);
            AppMethodBeat.o(133493);
            return j2;
        }
        AppMethodBeat.o(133493);
        return 0;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final float getFloat(int i2) {
        AppMethodBeat.i(133494);
        if (!this.Oua) {
            float f2 = this.Ouc.getFloat(i2);
            AppMethodBeat.o(133494);
            return f2;
        }
        AppMethodBeat.o(133494);
        return 0.0f;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final double getDouble(int i2) {
        AppMethodBeat.i(133495);
        if (!this.Oua) {
            double d2 = this.Ouc.getDouble(i2);
            AppMethodBeat.o(133495);
            return d2;
        }
        AppMethodBeat.o(133495);
        return 0.0d;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final boolean isNull(int i2) {
        AppMethodBeat.i(133496);
        if (!this.Oua) {
            boolean isNull = this.Ouc.isNull(i2);
            AppMethodBeat.o(133496);
            return isNull;
        }
        AppMethodBeat.o(133496);
        return false;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final byte[] getBlob(int i2) {
        AppMethodBeat.i(133497);
        if (!this.Oua) {
            byte[] blob = this.Ouc.getBlob(i2);
            AppMethodBeat.o(133497);
            return blob;
        }
        AppMethodBeat.o(133497);
        return null;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final a akz(int i2) {
        T t = null;
        AppMethodBeat.i(133498);
        if (this.Oub != null) {
            b<a> bVar = this.Oub;
            if (bVar.akB(i2)) {
                Object obj = bVar.OtK.get(i2);
                t = bVar.OtM.get(obj);
                if (t == null) {
                    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.CursorDataWindow", "get data null %s", obj);
                    if (bVar.OtN.size() != 0) {
                        ArrayList<a> bo = bVar.bo(bVar.OtN);
                        if (bo != null) {
                            for (int i3 = 0; i3 < bo.size(); i3++) {
                                a aVar = bo.get(i3);
                                if (aVar != null) {
                                    bVar.b(aVar.getKey(), aVar);
                                } else {
                                    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.CursorDataWindow", "newcursor obj is null");
                                }
                            }
                        }
                        bVar.OtN.clear();
                    }
                    t = bVar.OtM.get(obj);
                    if (t == null) {
                        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.CursorDataWindow", "newcursor error obj : " + obj + "pos:" + i2);
                    }
                }
            } else {
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.CursorDataWindow", "newcursor cursor getItem error: pos " + i2 + " loaded num :" + bVar.OtK.size());
            }
            AppMethodBeat.o(133498);
        } else {
            AppMethodBeat.o(133498);
        }
        return t;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final boolean a(Object obj, a aVar) {
        AppMethodBeat.i(133499);
        if (!this.Oua || this.Oub == null) {
            if (!this.Oua) {
                c cVar = this.Ouc;
                cVar.mPos = 0;
                cVar.OtP.clear();
            }
            AppMethodBeat.o(133499);
        } else {
            if (!this.Oud && (obj instanceof Object[]) && this.Oub.ed(obj)) {
                this.mCount -= ((Object[]) obj).length;
                this.pageSize -= ((Object[]) obj).length;
            }
            b<a> bVar = this.Oub;
            if (aVar != null) {
                com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.CursorDataWindow", "newcursor cursor update Memory key : " + obj + "values : " + aVar);
                bVar.b(obj, aVar);
            } else if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                for (Object obj2 : objArr) {
                    bVar.OtM.remove(obj2);
                }
                bVar.E(objArr);
            } else {
                if (bVar.OtN == null) {
                    bVar.OtN = new ArrayList<>();
                }
                if (!bVar.OtN.contains(obj)) {
                    bVar.OtN.add(obj);
                    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.CursorDataWindow", "newcursor cursor clearData : ".concat(String.valueOf(obj)));
                }
                bVar.OtM.remove(obj);
            }
            AppMethodBeat.o(133499);
        }
        return false;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final boolean gFx() {
        return this.Oud;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final boolean aky(int i2) {
        if (!this.Oua) {
            return false;
        }
        b<a> bVar = this.Oub;
        if (i2 > 50) {
            return false;
        }
        if (bVar.OtL < 10) {
            return true;
        }
        return ((double) i2) / ((double) bVar.OtL) < 0.1d;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final boolean ed(Object obj) {
        AppMethodBeat.i(133500);
        if (!this.Oua) {
            AppMethodBeat.o(133500);
            return false;
        } else if (this.Oub == null) {
            AppMethodBeat.o(133500);
            return false;
        } else {
            boolean ed = this.Oub.ed(obj);
            AppMethodBeat.o(133500);
            return ed;
        }
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final a ee(Object obj) {
        AppMethodBeat.i(133501);
        if (!this.Oua) {
            Log.e("WCDB.SQLiteNewCursor", "newcursor getItemByKey error ".concat(String.valueOf(obj)));
            AppMethodBeat.o(133501);
            return null;
        } else if (this.Oub == null) {
            Log.e("WCDB.SQLiteNewCursor", "newcursor error getItemByKey window is null");
            AppMethodBeat.o(133501);
            return null;
        } else {
            b<a> bVar = this.Oub;
            if (bVar.OtM == null) {
                AppMethodBeat.o(133501);
                return null;
            }
            T t = bVar.OtM.get(obj);
            AppMethodBeat.o(133501);
            return t;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void registerContentObserver(ContentObserver contentObserver) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void unregisterContentObserver(ContentObserver contentObserver) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final void a(a aVar) {
        this.OtZ = aVar;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final SparseArray<Object>[] gFv() {
        if (!this.Oua) {
            return null;
        }
        return new SparseArray[]{this.Oub.OtK};
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final HashMap gFw() {
        return this.Oub.OtM;
    }

    static {
        AppMethodBeat.i(133502);
        AppMethodBeat.o(133502);
    }
}
