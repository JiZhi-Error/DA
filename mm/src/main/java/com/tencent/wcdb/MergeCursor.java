package com.tencent.wcdb;

import android.database.ContentObserver;
import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MergeCursor extends AbstractCursor {
    private Cursor mCursor;
    private Cursor[] mCursors;
    private DataSetObserver mObserver = new DataSetObserver() {
        /* class com.tencent.wcdb.MergeCursor.AnonymousClass1 */

        public void onChanged() {
            MergeCursor.this.mPos = -1;
        }

        public void onInvalidated() {
            MergeCursor.this.mPos = -1;
        }
    };

    public MergeCursor(Cursor[] cursorArr) {
        AppMethodBeat.i(2872);
        this.mCursors = cursorArr;
        this.mCursor = cursorArr[0];
        for (int i2 = 0; i2 < this.mCursors.length; i2++) {
            if (this.mCursors[i2] != null) {
                this.mCursors[i2].registerDataSetObserver(this.mObserver);
            }
        }
        AppMethodBeat.o(2872);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public int getCount() {
        AppMethodBeat.i(2873);
        int length = this.mCursors.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.mCursors[i3] != null) {
                i2 += this.mCursors[i3].getCount();
            }
        }
        AppMethodBeat.o(2873);
        return i2;
    }

    @Override // com.tencent.wcdb.CrossProcessCursor, com.tencent.wcdb.AbstractCursor
    public boolean onMove(int i2, int i3) {
        AppMethodBeat.i(2874);
        this.mCursor = null;
        int length = this.mCursors.length;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            if (this.mCursors[i4] != null) {
                if (i3 < this.mCursors[i4].getCount() + i5) {
                    this.mCursor = this.mCursors[i4];
                    break;
                }
                i5 += this.mCursors[i4].getCount();
            }
            i4++;
        }
        if (this.mCursor != null) {
            boolean moveToPosition = this.mCursor.moveToPosition(i3 - i5);
            AppMethodBeat.o(2874);
            return moveToPosition;
        }
        AppMethodBeat.o(2874);
        return false;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public String getString(int i2) {
        AppMethodBeat.i(2875);
        String string = this.mCursor.getString(i2);
        AppMethodBeat.o(2875);
        return string;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public short getShort(int i2) {
        AppMethodBeat.i(2876);
        short s = this.mCursor.getShort(i2);
        AppMethodBeat.o(2876);
        return s;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public int getInt(int i2) {
        AppMethodBeat.i(2877);
        int i3 = this.mCursor.getInt(i2);
        AppMethodBeat.o(2877);
        return i3;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public long getLong(int i2) {
        AppMethodBeat.i(2878);
        long j2 = this.mCursor.getLong(i2);
        AppMethodBeat.o(2878);
        return j2;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public float getFloat(int i2) {
        AppMethodBeat.i(2879);
        float f2 = this.mCursor.getFloat(i2);
        AppMethodBeat.o(2879);
        return f2;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public double getDouble(int i2) {
        AppMethodBeat.i(2880);
        double d2 = this.mCursor.getDouble(i2);
        AppMethodBeat.o(2880);
        return d2;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public int getType(int i2) {
        AppMethodBeat.i(2881);
        int type = this.mCursor.getType(i2);
        AppMethodBeat.o(2881);
        return type;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public boolean isNull(int i2) {
        AppMethodBeat.i(2882);
        boolean isNull = this.mCursor.isNull(i2);
        AppMethodBeat.o(2882);
        return isNull;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public byte[] getBlob(int i2) {
        AppMethodBeat.i(2883);
        byte[] blob = this.mCursor.getBlob(i2);
        AppMethodBeat.o(2883);
        return blob;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public String[] getColumnNames() {
        AppMethodBeat.i(2884);
        if (this.mCursor != null) {
            String[] columnNames = this.mCursor.getColumnNames();
            AppMethodBeat.o(2884);
            return columnNames;
        }
        String[] strArr = new String[0];
        AppMethodBeat.o(2884);
        return strArr;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public void deactivate() {
        AppMethodBeat.i(2885);
        int length = this.mCursors.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.mCursors[i2] != null) {
                this.mCursors[i2].deactivate();
            }
        }
        super.deactivate();
        AppMethodBeat.o(2885);
    }

    @Override // java.io.Closeable, com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(2886);
        int length = this.mCursors.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.mCursors[i2] != null) {
                this.mCursors[i2].close();
            }
        }
        super.close();
        AppMethodBeat.o(2886);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.i(2887);
        int length = this.mCursors.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.mCursors[i2] != null) {
                this.mCursors[i2].registerContentObserver(contentObserver);
            }
        }
        AppMethodBeat.o(2887);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.i(2888);
        int length = this.mCursors.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.mCursors[i2] != null) {
                this.mCursors[i2].unregisterContentObserver(contentObserver);
            }
        }
        AppMethodBeat.o(2888);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(2889);
        int length = this.mCursors.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.mCursors[i2] != null) {
                this.mCursors[i2].registerDataSetObserver(dataSetObserver);
            }
        }
        AppMethodBeat.o(2889);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(2890);
        int length = this.mCursors.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.mCursors[i2] != null) {
                this.mCursors[i2].unregisterDataSetObserver(dataSetObserver);
            }
        }
        AppMethodBeat.o(2890);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public boolean requery() {
        AppMethodBeat.i(2891);
        int length = this.mCursors.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.mCursors[i2] != null && !this.mCursors[i2].requery()) {
                AppMethodBeat.o(2891);
                return false;
            }
        }
        AppMethodBeat.o(2891);
        return true;
    }
}
