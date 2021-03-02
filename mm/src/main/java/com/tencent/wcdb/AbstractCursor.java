package com.tencent.wcdb;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCursor implements CrossProcessCursor {
    private static final String TAG = "Cursor";
    protected boolean mClosed;
    private final ContentObservable mContentObservable = new ContentObservable();
    protected ContentResolver mContentResolver;
    @Deprecated
    protected Long mCurrentRowID = null;
    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    private Bundle mExtras = Bundle.EMPTY;
    private Uri mNotifyUri;
    public int mPos = -1;
    @Deprecated
    protected int mRowIdColumnIndex = -1;
    private ContentObserver mSelfObserver;
    private final Object mSelfObserverLock = new Object();
    private boolean mSelfObserverRegistered;
    @Deprecated
    protected HashMap<Long, Map<String, Object>> mUpdatedRows = new HashMap<>();

    @Override // com.tencent.wcdb.Cursor
    public abstract String[] getColumnNames();

    @Override // com.tencent.wcdb.Cursor
    public abstract int getCount();

    @Override // com.tencent.wcdb.Cursor
    public abstract double getDouble(int i2);

    @Override // com.tencent.wcdb.Cursor
    public abstract float getFloat(int i2);

    @Override // com.tencent.wcdb.Cursor
    public abstract int getInt(int i2);

    @Override // com.tencent.wcdb.Cursor
    public abstract long getLong(int i2);

    @Override // com.tencent.wcdb.Cursor
    public abstract short getShort(int i2);

    @Override // com.tencent.wcdb.Cursor
    public abstract String getString(int i2);

    @Override // com.tencent.wcdb.Cursor
    public abstract boolean isNull(int i2);

    @Override // com.tencent.wcdb.Cursor
    public int getType(int i2) {
        return 3;
    }

    @Override // com.tencent.wcdb.Cursor
    public byte[] getBlob(int i2) {
        throw new UnsupportedOperationException("getBlob is not supported");
    }

    @Override // com.tencent.wcdb.CrossProcessCursor
    public CursorWindow getWindow() {
        return null;
    }

    @Override // com.tencent.wcdb.Cursor
    public int getColumnCount() {
        return getColumnNames().length;
    }

    @Override // com.tencent.wcdb.Cursor
    public void deactivate() {
        onDeactivateOrClose();
    }

    /* access modifiers changed from: protected */
    public void onDeactivateOrClose() {
        if (this.mSelfObserver != null) {
            this.mContentResolver.unregisterContentObserver(this.mSelfObserver);
            this.mSelfObserverRegistered = false;
        }
        this.mDataSetObservable.notifyInvalidated();
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean requery() {
        if (this.mSelfObserver != null && !this.mSelfObserverRegistered) {
            this.mContentResolver.registerContentObserver(this.mNotifyUri, true, this.mSelfObserver);
            this.mSelfObserverRegistered = true;
        }
        this.mDataSetObservable.notifyChanged();
        return true;
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean isClosed() {
        return this.mClosed;
    }

    @Override // java.io.Closeable, com.tencent.wcdb.Cursor, java.lang.AutoCloseable
    public void close() {
        this.mClosed = true;
        this.mContentObservable.unregisterAll();
        onDeactivateOrClose();
    }

    @Override // com.tencent.wcdb.CrossProcessCursor
    public boolean onMove(int i2, int i3) {
        return true;
    }

    @Override // com.tencent.wcdb.Cursor
    public void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
        String string = getString(i2);
        if (string != null) {
            char[] cArr = charArrayBuffer.data;
            if (cArr == null || cArr.length < string.length()) {
                charArrayBuffer.data = string.toCharArray();
            } else {
                string.getChars(0, string.length(), cArr, 0);
            }
            charArrayBuffer.sizeCopied = string.length();
            return;
        }
        charArrayBuffer.sizeCopied = 0;
    }

    @Override // com.tencent.wcdb.Cursor
    public final int getPosition() {
        return this.mPos;
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean moveToPosition(int i2) {
        int count = getCount();
        if (i2 >= count) {
            this.mPos = count;
            return false;
        } else if (i2 < 0) {
            this.mPos = -1;
            return false;
        } else if (i2 == this.mPos) {
            return true;
        } else {
            boolean onMove = onMove(this.mPos, i2);
            if (!onMove) {
                this.mPos = -1;
                return onMove;
            }
            this.mPos = i2;
            if (this.mRowIdColumnIndex == -1) {
                return onMove;
            }
            this.mCurrentRowID = Long.valueOf(getLong(this.mRowIdColumnIndex));
            return onMove;
        }
    }

    @Override // com.tencent.wcdb.CrossProcessCursor
    public void fillWindow(int i2, CursorWindow cursorWindow) {
        DatabaseUtils.cursorFillWindow(this, i2, cursorWindow);
    }

    @Override // com.tencent.wcdb.Cursor
    public final boolean move(int i2) {
        return moveToPosition(this.mPos + i2);
    }

    @Override // com.tencent.wcdb.Cursor
    public final boolean moveToFirst() {
        return moveToPosition(0);
    }

    @Override // com.tencent.wcdb.Cursor
    public final boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    @Override // com.tencent.wcdb.Cursor
    public final boolean moveToNext() {
        return moveToPosition(this.mPos + 1);
    }

    @Override // com.tencent.wcdb.Cursor
    public final boolean moveToPrevious() {
        return moveToPosition(this.mPos - 1);
    }

    @Override // com.tencent.wcdb.Cursor
    public final boolean isFirst() {
        return this.mPos == 0 && getCount() != 0;
    }

    @Override // com.tencent.wcdb.Cursor
    public final boolean isLast() {
        int count = getCount();
        return this.mPos == count + -1 && count != 0;
    }

    @Override // com.tencent.wcdb.Cursor
    public final boolean isBeforeFirst() {
        if (getCount() == 0 || this.mPos == -1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.wcdb.Cursor
    public final boolean isAfterLast() {
        if (getCount() == 0 || this.mPos == getCount()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.wcdb.Cursor
    public int getColumnIndex(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            Exception exc = new Exception();
            Log.e(TAG, "requesting column name with table name -- ".concat(String.valueOf(str)), exc);
            str = str.substring(lastIndexOf + 1);
        }
        String[] columnNames = getColumnNames();
        int length = columnNames.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (columnNames[i2].equalsIgnoreCase(str)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public int getColumnIndexOrThrow(String str) {
        int columnIndex = getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist");
    }

    @Override // com.tencent.wcdb.Cursor
    public String getColumnName(int i2) {
        return getColumnNames()[i2];
    }

    @Override // com.tencent.wcdb.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        this.mContentObservable.registerObserver(contentObserver);
    }

    @Override // com.tencent.wcdb.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        if (!this.mClosed) {
            this.mContentObservable.unregisterObserver(contentObserver);
        }
    }

    @Override // com.tencent.wcdb.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.registerObserver(dataSetObserver);
    }

    @Override // com.tencent.wcdb.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.unregisterObserver(dataSetObserver);
    }

    /* access modifiers changed from: protected */
    public void onChange(boolean z) {
        synchronized (this.mSelfObserverLock) {
            this.mContentObservable.dispatchChange(z);
            if (this.mNotifyUri != null && z) {
                this.mContentResolver.notifyChange(this.mNotifyUri, this.mSelfObserver);
            }
        }
    }

    @Override // com.tencent.wcdb.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        synchronized (this.mSelfObserverLock) {
            this.mNotifyUri = uri;
            this.mContentResolver = contentResolver;
            if (this.mSelfObserver != null) {
                this.mContentResolver.unregisterContentObserver(this.mSelfObserver);
            }
            this.mSelfObserver = new SelfContentObserver(this);
            this.mContentResolver.registerContentObserver(this.mNotifyUri, true, this.mSelfObserver);
            this.mSelfObserverRegistered = true;
        }
    }

    public Uri getNotificationUri() {
        return this.mNotifyUri;
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    public void setExtras(Bundle bundle) {
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        this.mExtras = bundle;
    }

    @Override // com.tencent.wcdb.Cursor
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.tencent.wcdb.Cursor
    public Bundle respond(Bundle bundle) {
        return Bundle.EMPTY;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean isFieldUpdated(int i2) {
        return false;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Object getUpdatedField(int i2) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void checkPosition() {
        if (-1 == this.mPos || getCount() == this.mPos) {
            throw new CursorIndexOutOfBoundsException(this.mPos, getCount());
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        if (this.mSelfObserver != null && this.mSelfObserverRegistered) {
            this.mContentResolver.unregisterContentObserver(this.mSelfObserver);
        }
        try {
            if (!this.mClosed) {
                close();
            }
        } catch (Exception e2) {
        }
    }

    protected static class SelfContentObserver extends ContentObserver {
        WeakReference<AbstractCursor> mCursor;

        public SelfContentObserver(AbstractCursor abstractCursor) {
            super(null);
            AppMethodBeat.i(2639);
            this.mCursor = new WeakReference<>(abstractCursor);
            AppMethodBeat.o(2639);
        }

        public boolean deliverSelfNotifications() {
            return false;
        }

        public void onChange(boolean z) {
            AppMethodBeat.i(2640);
            AbstractCursor abstractCursor = this.mCursor.get();
            if (abstractCursor != null) {
                abstractCursor.onChange(false);
            }
            AppMethodBeat.o(2640);
        }
    }
}
