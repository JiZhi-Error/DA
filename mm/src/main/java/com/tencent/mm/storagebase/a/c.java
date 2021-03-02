package com.tencent.mm.storagebase.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.CursorIndexOutOfBoundsException;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;

public final class c extends AbstractCursor {
    SparseArray<Object[]> OtP;
    public int OtQ;
    int OtR;
    final int columnCount;
    private final String[] columnNames;

    private c(String[] strArr) {
        AppMethodBeat.i(133434);
        this.OtQ = 3000;
        this.columnNames = strArr;
        this.columnCount = strArr.length;
        this.OtP = new SparseArray<>();
        AppMethodBeat.o(133434);
    }

    public c(String[] strArr, byte b2) {
        this(strArr);
    }

    private Object get(int i2) {
        AppMethodBeat.i(133435);
        if (i2 < 0 || i2 >= this.columnCount) {
            CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException("Requested column: " + i2 + ", # of columns: " + this.columnCount);
            AppMethodBeat.o(133435);
            throw cursorIndexOutOfBoundsException;
        } else if (this.mPos < 0) {
            CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException2 = new CursorIndexOutOfBoundsException("Before first row.");
            AppMethodBeat.o(133435);
            throw cursorIndexOutOfBoundsException2;
        } else if (this.mPos >= this.OtR) {
            CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException3 = new CursorIndexOutOfBoundsException("After last row.");
            AppMethodBeat.o(133435);
            throw cursorIndexOutOfBoundsException3;
        } else {
            Object obj = this.OtP.get(this.mPos / this.OtQ)[((this.mPos % this.OtQ) * this.columnCount) + i2];
            AppMethodBeat.o(133435);
            return obj;
        }
    }

    public class a {
        Object[] OtS;
        final int endIndex;
        int index;

        a(int i2, int i3, Object[] objArr) {
            this.index = i2;
            this.endIndex = i3;
            this.OtS = objArr;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final int getCount() {
        return this.OtR;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final String[] getColumnNames() {
        return this.columnNames;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final String getString(int i2) {
        AppMethodBeat.i(133436);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(133436);
            return null;
        }
        String obj2 = obj.toString();
        AppMethodBeat.o(133436);
        return obj2;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final short getShort(int i2) {
        AppMethodBeat.i(133437);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(133437);
            return 0;
        } else if (obj instanceof Number) {
            short shortValue = ((Number) obj).shortValue();
            AppMethodBeat.o(133437);
            return shortValue;
        } else {
            short parseShort = Short.parseShort(obj.toString());
            AppMethodBeat.o(133437);
            return parseShort;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final int getInt(int i2) {
        AppMethodBeat.i(133438);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(133438);
            return 0;
        } else if (obj instanceof Number) {
            int intValue = ((Number) obj).intValue();
            AppMethodBeat.o(133438);
            return intValue;
        } else {
            int parseInt = Integer.parseInt(obj.toString());
            AppMethodBeat.o(133438);
            return parseInt;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final long getLong(int i2) {
        AppMethodBeat.i(133439);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(133439);
            return 0;
        } else if (obj instanceof Number) {
            long longValue = ((Number) obj).longValue();
            AppMethodBeat.o(133439);
            return longValue;
        } else {
            long parseLong = Long.parseLong(obj.toString());
            AppMethodBeat.o(133439);
            return parseLong;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final float getFloat(int i2) {
        AppMethodBeat.i(133440);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(133440);
            return 0.0f;
        } else if (obj instanceof Number) {
            float floatValue = ((Number) obj).floatValue();
            AppMethodBeat.o(133440);
            return floatValue;
        } else {
            float parseFloat = Float.parseFloat(obj.toString());
            AppMethodBeat.o(133440);
            return parseFloat;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final double getDouble(int i2) {
        AppMethodBeat.i(133441);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(133441);
            return 0.0d;
        } else if (obj instanceof Number) {
            double doubleValue = ((Number) obj).doubleValue();
            AppMethodBeat.o(133441);
            return doubleValue;
        } else {
            double parseDouble = Double.parseDouble(obj.toString());
            AppMethodBeat.o(133441);
            return parseDouble;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final boolean isNull(int i2) {
        AppMethodBeat.i(133442);
        if (get(i2) == null) {
            AppMethodBeat.o(133442);
            return true;
        }
        AppMethodBeat.o(133442);
        return false;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final byte[] getBlob(int i2) {
        AppMethodBeat.i(133443);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(133443);
            return null;
        }
        byte[] bArr = (byte[]) obj;
        AppMethodBeat.o(133443);
        return bArr;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void registerContentObserver(ContentObserver contentObserver) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void unregisterContentObserver(ContentObserver contentObserver) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }
}
