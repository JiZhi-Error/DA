package com.tencent.wcdb;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.support.Log;

public final class BulkCursorToCursorAdaptor extends AbstractWindowedCursor {
    private static final String TAG = "BulkCursor";
    private IBulkCursor mBulkCursor;
    private String[] mColumns;
    private int mCount;
    private AbstractCursor.SelfContentObserver mObserverBridge = new AbstractCursor.SelfContentObserver(this);
    private boolean mWantsAllOnMoveCalls;

    public BulkCursorToCursorAdaptor() {
        AppMethodBeat.i(2655);
        AppMethodBeat.o(2655);
    }

    public final void initialize(BulkCursorDescriptor bulkCursorDescriptor) {
        AppMethodBeat.i(2656);
        this.mBulkCursor = bulkCursorDescriptor.cursor;
        this.mColumns = bulkCursorDescriptor.columnNames;
        this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
        this.mWantsAllOnMoveCalls = bulkCursorDescriptor.wantsAllOnMoveCalls;
        this.mCount = bulkCursorDescriptor.count;
        if (bulkCursorDescriptor.window != null) {
            setWindow(bulkCursorDescriptor.window);
        }
        AppMethodBeat.o(2656);
    }

    public final IContentObserver getObserver() {
        AppMethodBeat.i(2657);
        try {
            IContentObserver iContentObserver = (IContentObserver) this.mObserverBridge.getClass().getMethod("getContentObserver", new Class[0]).invoke(this.mObserverBridge, new Object[0]);
            AppMethodBeat.o(2657);
            return iContentObserver;
        } catch (Exception e2) {
            AppMethodBeat.o(2657);
            return null;
        }
    }

    private void throwIfCursorIsClosed() {
        AppMethodBeat.i(2658);
        if (this.mBulkCursor == null) {
            StaleDataException staleDataException = new StaleDataException("Attempted to access a cursor after it has been closed.");
            AppMethodBeat.o(2658);
            throw staleDataException;
        }
        AppMethodBeat.o(2658);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final int getCount() {
        AppMethodBeat.i(2659);
        throwIfCursorIsClosed();
        int i2 = this.mCount;
        AppMethodBeat.o(2659);
        return i2;
    }

    @Override // com.tencent.wcdb.CrossProcessCursor, com.tencent.wcdb.AbstractCursor
    public final boolean onMove(int i2, int i3) {
        AppMethodBeat.i(2660);
        throwIfCursorIsClosed();
        try {
            if (this.mWindow == null || i3 < this.mWindow.getStartPosition() || i3 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
                setWindow(this.mBulkCursor.getWindow(i3));
            } else if (this.mWantsAllOnMoveCalls) {
                this.mBulkCursor.onMove(i3);
            }
            if (this.mWindow == null) {
                AppMethodBeat.o(2660);
                return false;
            }
            AppMethodBeat.o(2660);
            return true;
        } catch (RemoteException e2) {
            Log.e(TAG, "Unable to get window because the remote process is dead");
            AppMethodBeat.o(2660);
            return false;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final void deactivate() {
        AppMethodBeat.i(2661);
        super.deactivate();
        if (this.mBulkCursor != null) {
            try {
                this.mBulkCursor.deactivate();
                AppMethodBeat.o(2661);
                return;
            } catch (RemoteException e2) {
                Log.w(TAG, "Remote process exception when deactivating");
            }
        }
        AppMethodBeat.o(2661);
    }

    @Override // java.io.Closeable, com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(2662);
        super.close();
        if (this.mBulkCursor != null) {
            try {
                this.mBulkCursor.close();
            } catch (RemoteException e2) {
                Log.w(TAG, "Remote process exception when closing");
            } finally {
                this.mBulkCursor = null;
                AppMethodBeat.o(2662);
            }
        } else {
            AppMethodBeat.o(2662);
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final boolean requery() {
        AppMethodBeat.i(2663);
        throwIfCursorIsClosed();
        try {
            this.mCount = this.mBulkCursor.requery(getObserver());
            if (this.mCount != -1) {
                this.mPos = -1;
                closeWindow();
                super.requery();
                AppMethodBeat.o(2663);
                return true;
            }
            deactivate();
            AppMethodBeat.o(2663);
            return false;
        } catch (Exception e2) {
            Log.e(TAG, "Unable to requery because the remote process exception " + e2.getMessage());
            deactivate();
            AppMethodBeat.o(2663);
            return false;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final String[] getColumnNames() {
        AppMethodBeat.i(2664);
        throwIfCursorIsClosed();
        String[] strArr = this.mColumns;
        AppMethodBeat.o(2664);
        return strArr;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final Bundle getExtras() {
        AppMethodBeat.i(2665);
        throwIfCursorIsClosed();
        try {
            Bundle extras = this.mBulkCursor.getExtras();
            AppMethodBeat.o(2665);
            return extras;
        } catch (RemoteException e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(2665);
            throw runtimeException;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public final Bundle respond(Bundle bundle) {
        AppMethodBeat.i(2666);
        throwIfCursorIsClosed();
        try {
            Bundle respond = this.mBulkCursor.respond(bundle);
            AppMethodBeat.o(2666);
            return respond;
        } catch (RemoteException e2) {
            Log.w(TAG, "respond() threw RemoteException, returning an empty bundle.", e2);
            Bundle bundle2 = Bundle.EMPTY;
            AppMethodBeat.o(2666);
            return bundle2;
        }
    }

    @Override // com.tencent.wcdb.AbstractWindowedCursor, com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
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
}
