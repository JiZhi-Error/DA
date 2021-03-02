package com.tencent.wcdb;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class MatrixCursor extends AbstractCursor {
    private final int columnCount;
    private final String[] columnNames;
    private Object[] data;
    private int rowCount;

    public MatrixCursor(String[] strArr, int i2) {
        AppMethodBeat.i(2856);
        this.rowCount = 0;
        this.columnNames = strArr;
        this.columnCount = strArr.length;
        this.data = new Object[(this.columnCount * (i2 <= 0 ? 1 : i2))];
        AppMethodBeat.o(2856);
    }

    public MatrixCursor(String[] strArr) {
        this(strArr, 16);
    }

    private Object get(int i2) {
        AppMethodBeat.i(2857);
        if (i2 < 0 || i2 >= this.columnCount) {
            CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException("Requested column: " + i2 + ", # of columns: " + this.columnCount);
            AppMethodBeat.o(2857);
            throw cursorIndexOutOfBoundsException;
        } else if (this.mPos < 0) {
            CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException2 = new CursorIndexOutOfBoundsException("Before first row.");
            AppMethodBeat.o(2857);
            throw cursorIndexOutOfBoundsException2;
        } else if (this.mPos >= this.rowCount) {
            CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException3 = new CursorIndexOutOfBoundsException("After last row.");
            AppMethodBeat.o(2857);
            throw cursorIndexOutOfBoundsException3;
        } else {
            Object obj = this.data[(this.mPos * this.columnCount) + i2];
            AppMethodBeat.o(2857);
            return obj;
        }
    }

    public RowBuilder newRow() {
        AppMethodBeat.i(2858);
        this.rowCount++;
        int i2 = this.rowCount * this.columnCount;
        ensureCapacity(i2);
        RowBuilder rowBuilder = new RowBuilder(i2 - this.columnCount, i2);
        AppMethodBeat.o(2858);
        return rowBuilder;
    }

    public void addRow(Object[] objArr) {
        AppMethodBeat.i(2859);
        if (objArr.length != this.columnCount) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.length = " + objArr.length);
            AppMethodBeat.o(2859);
            throw illegalArgumentException;
        }
        int i2 = this.rowCount;
        this.rowCount = i2 + 1;
        int i3 = i2 * this.columnCount;
        ensureCapacity(this.columnCount + i3);
        System.arraycopy(objArr, 0, this.data, i3, this.columnCount);
        AppMethodBeat.o(2859);
    }

    public void addRow(Iterable<?> iterable) {
        AppMethodBeat.i(2860);
        int i2 = this.rowCount * this.columnCount;
        int i3 = i2 + this.columnCount;
        ensureCapacity(i3);
        if (iterable instanceof ArrayList) {
            addRow((ArrayList) iterable, i2);
            AppMethodBeat.o(2860);
            return;
        }
        Object[] objArr = this.data;
        for (Object obj : iterable) {
            if (i2 == i3) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("columnValues.size() > columnNames.length");
                AppMethodBeat.o(2860);
                throw illegalArgumentException;
            }
            objArr[i2] = obj;
            i2++;
        }
        if (i2 != i3) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("columnValues.size() < columnNames.length");
            AppMethodBeat.o(2860);
            throw illegalArgumentException2;
        }
        this.rowCount++;
        AppMethodBeat.o(2860);
    }

    private void addRow(ArrayList<?> arrayList, int i2) {
        AppMethodBeat.i(2861);
        int size = arrayList.size();
        if (size != this.columnCount) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.size() = " + size);
            AppMethodBeat.o(2861);
            throw illegalArgumentException;
        }
        this.rowCount++;
        Object[] objArr = this.data;
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i2 + i3] = arrayList.get(i3);
        }
        AppMethodBeat.o(2861);
    }

    private void ensureCapacity(int i2) {
        AppMethodBeat.i(2862);
        if (i2 > this.data.length) {
            Object[] objArr = this.data;
            int length = this.data.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.data = new Object[i2];
            System.arraycopy(objArr, 0, this.data, 0, objArr.length);
        }
        AppMethodBeat.o(2862);
    }

    public class RowBuilder {
        private final int endIndex;
        private int index;

        RowBuilder(int i2, int i3) {
            this.index = i2;
            this.endIndex = i3;
        }

        public RowBuilder add(Object obj) {
            AppMethodBeat.i(2855);
            if (this.index == this.endIndex) {
                CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException("No more columns left.");
                AppMethodBeat.o(2855);
                throw cursorIndexOutOfBoundsException;
            }
            Object[] objArr = MatrixCursor.this.data;
            int i2 = this.index;
            this.index = i2 + 1;
            objArr[i2] = obj;
            AppMethodBeat.o(2855);
            return this;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public int getCount() {
        return this.rowCount;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public String[] getColumnNames() {
        return this.columnNames;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public String getString(int i2) {
        AppMethodBeat.i(2863);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(2863);
            return null;
        }
        String obj2 = obj.toString();
        AppMethodBeat.o(2863);
        return obj2;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public short getShort(int i2) {
        AppMethodBeat.i(2864);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(2864);
            return 0;
        } else if (obj instanceof Number) {
            short shortValue = ((Number) obj).shortValue();
            AppMethodBeat.o(2864);
            return shortValue;
        } else {
            short parseShort = Short.parseShort(obj.toString());
            AppMethodBeat.o(2864);
            return parseShort;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public int getInt(int i2) {
        AppMethodBeat.i(2865);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(2865);
            return 0;
        } else if (obj instanceof Number) {
            int intValue = ((Number) obj).intValue();
            AppMethodBeat.o(2865);
            return intValue;
        } else {
            int parseInt = Integer.parseInt(obj.toString());
            AppMethodBeat.o(2865);
            return parseInt;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public long getLong(int i2) {
        AppMethodBeat.i(2866);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(2866);
            return 0;
        } else if (obj instanceof Number) {
            long longValue = ((Number) obj).longValue();
            AppMethodBeat.o(2866);
            return longValue;
        } else {
            long parseLong = Long.parseLong(obj.toString());
            AppMethodBeat.o(2866);
            return parseLong;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public float getFloat(int i2) {
        AppMethodBeat.i(2867);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(2867);
            return 0.0f;
        } else if (obj instanceof Number) {
            float floatValue = ((Number) obj).floatValue();
            AppMethodBeat.o(2867);
            return floatValue;
        } else {
            float parseFloat = Float.parseFloat(obj.toString());
            AppMethodBeat.o(2867);
            return parseFloat;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public double getDouble(int i2) {
        AppMethodBeat.i(2868);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(2868);
            return 0.0d;
        } else if (obj instanceof Number) {
            double doubleValue = ((Number) obj).doubleValue();
            AppMethodBeat.o(2868);
            return doubleValue;
        } else {
            double parseDouble = Double.parseDouble(obj.toString());
            AppMethodBeat.o(2868);
            return parseDouble;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public byte[] getBlob(int i2) {
        AppMethodBeat.i(2869);
        byte[] bArr = (byte[]) get(i2);
        AppMethodBeat.o(2869);
        return bArr;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public int getType(int i2) {
        AppMethodBeat.i(2870);
        int typeOfObject = DatabaseUtils.getTypeOfObject(get(i2));
        AppMethodBeat.o(2870);
        return typeOfObject;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public boolean isNull(int i2) {
        AppMethodBeat.i(2871);
        if (get(i2) == null) {
            AppMethodBeat.o(2871);
            return true;
        }
        AppMethodBeat.o(2871);
        return false;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }
}
