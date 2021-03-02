package com.tencent.mm.storagebase.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storagebase.a.f;
import com.tencent.wcdb.AbstractCursor;
import java.util.HashMap;

public final class e extends AbstractCursor implements d {
    private d OtU;
    public d[] OtV;
    private DataSetObserver mObserver = new DataSetObserver() {
        /* class com.tencent.mm.storagebase.a.e.AnonymousClass1 */

        public final void onChanged() {
            AppMethodBeat.i(133444);
            e.this.mPos = -1;
            AppMethodBeat.o(133444);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(133445);
            e.this.mPos = -1;
            AppMethodBeat.o(133445);
        }
    };

    public e(d[] dVarArr) {
        AppMethodBeat.i(133446);
        this.OtV = dVarArr;
        this.OtU = dVarArr[0];
        for (int i2 = 0; i2 < this.OtV.length; i2++) {
            if (this.OtV[i2] != null) {
                this.OtV[i2].registerDataSetObserver(this.mObserver);
            }
        }
        AppMethodBeat.o(133446);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final int getCount() {
        AppMethodBeat.i(133447);
        int length = this.OtV.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.OtV[i3] != null) {
                i2 += this.OtV[i3].getCount();
            }
        }
        AppMethodBeat.o(133447);
        return i2;
    }

    @Override // com.tencent.wcdb.CrossProcessCursor, com.tencent.wcdb.AbstractCursor
    public final boolean onMove(int i2, int i3) {
        AppMethodBeat.i(133448);
        this.OtU = null;
        int length = this.OtV.length;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            if (this.OtV[i4] != null) {
                if (i3 < this.OtV[i4].getCount() + i5) {
                    this.OtU = this.OtV[i4];
                    break;
                }
                i5 += this.OtV[i4].getCount();
            }
            i4++;
        }
        if (this.OtU != null) {
            boolean moveToPosition = this.OtU.moveToPosition(i3 - i5);
            AppMethodBeat.o(133448);
            return moveToPosition;
        }
        AppMethodBeat.o(133448);
        return false;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final String getString(int i2) {
        AppMethodBeat.i(133449);
        String string = this.OtU.getString(i2);
        AppMethodBeat.o(133449);
        return string;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final short getShort(int i2) {
        AppMethodBeat.i(133450);
        short s = this.OtU.getShort(i2);
        AppMethodBeat.o(133450);
        return s;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final int getInt(int i2) {
        AppMethodBeat.i(133451);
        int i3 = this.OtU.getInt(i2);
        AppMethodBeat.o(133451);
        return i3;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final long getLong(int i2) {
        AppMethodBeat.i(133452);
        long j2 = this.OtU.getLong(i2);
        AppMethodBeat.o(133452);
        return j2;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final float getFloat(int i2) {
        AppMethodBeat.i(133453);
        float f2 = this.OtU.getFloat(i2);
        AppMethodBeat.o(133453);
        return f2;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final double getDouble(int i2) {
        AppMethodBeat.i(133454);
        double d2 = this.OtU.getDouble(i2);
        AppMethodBeat.o(133454);
        return d2;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final boolean isNull(int i2) {
        AppMethodBeat.i(133455);
        boolean isNull = this.OtU.isNull(i2);
        AppMethodBeat.o(133455);
        return isNull;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final byte[] getBlob(int i2) {
        AppMethodBeat.i(133456);
        byte[] blob = this.OtU.getBlob(i2);
        AppMethodBeat.o(133456);
        return blob;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final String[] getColumnNames() {
        AppMethodBeat.i(133457);
        if (this.OtU != null) {
            String[] columnNames = this.OtU.getColumnNames();
            AppMethodBeat.o(133457);
            return columnNames;
        }
        String[] strArr = new String[0];
        AppMethodBeat.o(133457);
        return strArr;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void deactivate() {
        AppMethodBeat.i(133458);
        int length = this.OtV.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.OtV[i2] != null) {
                this.OtV[i2].deactivate();
            }
        }
        super.deactivate();
        AppMethodBeat.o(133458);
    }

    @Override // java.io.Closeable, com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(133459);
        int length = this.OtV.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.OtV[i2] != null) {
                this.OtV[i2].close();
            }
        }
        super.close();
        AppMethodBeat.o(133459);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void registerContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.i(133460);
        int length = this.OtV.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.OtV[i2] != null) {
                this.OtV[i2].registerContentObserver(contentObserver);
            }
        }
        AppMethodBeat.o(133460);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void unregisterContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.i(133461);
        int length = this.OtV.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.OtV[i2] != null) {
                this.OtV[i2].unregisterContentObserver(contentObserver);
            }
        }
        AppMethodBeat.o(133461);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(133462);
        int length = this.OtV.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.OtV[i2] != null) {
                this.OtV[i2].registerDataSetObserver(dataSetObserver);
            }
        }
        AppMethodBeat.o(133462);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(133463);
        int length = this.OtV.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.OtV[i2] != null) {
                this.OtV[i2].unregisterDataSetObserver(dataSetObserver);
            }
        }
        AppMethodBeat.o(133463);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final boolean requery() {
        AppMethodBeat.i(133464);
        int length = this.OtV.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.OtV[i2] != null && !this.OtV[i2].requery()) {
                AppMethodBeat.o(133464);
                return false;
            }
        }
        AppMethodBeat.o(133464);
        return true;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final void a(f.a aVar) {
        AppMethodBeat.i(133465);
        int length = this.OtV.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.OtV[i2] != null) {
                this.OtV[i2].a(aVar);
            }
        }
        AppMethodBeat.o(133465);
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final void AO(boolean z) {
        AppMethodBeat.i(133466);
        int length = this.OtV.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.OtV[i2] != null) {
                this.OtV[i2].AO(z);
            }
        }
        AppMethodBeat.o(133466);
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final boolean gFx() {
        AppMethodBeat.i(133467);
        int length = this.OtV.length;
        boolean z = true;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.OtV[i2] != null && !this.OtV[i2].gFx()) {
                z = false;
            }
        }
        AppMethodBeat.o(133467);
        return z;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final a akz(int i2) {
        AppMethodBeat.i(133468);
        int length = this.OtV.length;
        for (int i3 = 0; i3 < length; i3++) {
            int count = this.OtV[i3].getCount();
            if (i2 < count) {
                a akz = this.OtV[i3].akz(i2);
                AppMethodBeat.o(133468);
                return akz;
            }
            i2 -= count;
        }
        AppMethodBeat.o(133468);
        return null;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final boolean a(Object obj, a aVar) {
        AppMethodBeat.i(133469);
        int length = this.OtV.length;
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.OtV[i2] != null && this.OtV[i2].a(obj, aVar)) {
                z = true;
            }
        }
        AppMethodBeat.o(133469);
        return z;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final SparseArray<Object>[] gFv() {
        AppMethodBeat.i(133470);
        int length = this.OtV.length;
        SparseArray<Object>[] sparseArrayArr = new SparseArray[length];
        for (int i2 = 0; i2 < length; i2++) {
            SparseArray<Object>[] gFv = this.OtV[i2].gFv();
            sparseArrayArr[i2] = gFv != null ? gFv[0] : null;
        }
        AppMethodBeat.o(133470);
        return sparseArrayArr;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final HashMap gFw() {
        return null;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final boolean aky(int i2) {
        AppMethodBeat.i(133471);
        int length = this.OtV.length;
        boolean z = true;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.OtV[i3] != null && !this.OtV[i3].aky(i2)) {
                z = false;
            }
        }
        AppMethodBeat.o(133471);
        return z;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final boolean ed(Object obj) {
        AppMethodBeat.i(133472);
        int length = this.OtV.length;
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.OtV[i2] != null && this.OtV[i2].ed(obj)) {
                z = true;
            }
        }
        AppMethodBeat.o(133472);
        return z;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final a ee(Object obj) {
        AppMethodBeat.i(133473);
        a ee = this.OtU.ee(obj);
        AppMethodBeat.o(133473);
        return ee;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final void akA(int i2) {
        AppMethodBeat.i(133474);
        int length = this.OtV.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.OtV[i3] != null) {
                this.OtV[i3].akA(i2);
            }
        }
        AppMethodBeat.o(133474);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
    }
}
