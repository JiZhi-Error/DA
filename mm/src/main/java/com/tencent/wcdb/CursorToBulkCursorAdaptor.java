package com.tencent.wcdb;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CursorToBulkCursorAdaptor extends BulkCursorNative implements IBinder.DeathRecipient {
    private static final String TAG = "Cursor";
    private CrossProcessCursor mCursor;
    private CursorWindow mFilledWindow;
    private final Object mLock = new Object();
    private ContentObserverProxy mObserver;
    private final String mProviderName;

    /* access modifiers changed from: package-private */
    public static final class ContentObserverProxy extends ContentObserver {
        protected IContentObserver mRemote;

        public ContentObserverProxy(IContentObserver iContentObserver, IBinder.DeathRecipient deathRecipient) {
            super(null);
            AppMethodBeat.i(2684);
            this.mRemote = iContentObserver;
            try {
                iContentObserver.asBinder().linkToDeath(deathRecipient, 0);
                AppMethodBeat.o(2684);
            } catch (RemoteException e2) {
                AppMethodBeat.o(2684);
            }
        }

        public final boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient) {
            AppMethodBeat.i(2685);
            boolean unlinkToDeath = this.mRemote.asBinder().unlinkToDeath(deathRecipient, 0);
            AppMethodBeat.o(2685);
            return unlinkToDeath;
        }

        public final boolean deliverSelfNotifications() {
            return false;
        }

        public final void onChange(boolean z, Uri uri) {
            AppMethodBeat.i(2686);
            try {
                this.mRemote.onChange(z, uri);
                AppMethodBeat.o(2686);
            } catch (RemoteException e2) {
                AppMethodBeat.o(2686);
            }
        }
    }

    public CursorToBulkCursorAdaptor(Cursor cursor, IContentObserver iContentObserver, String str) {
        AppMethodBeat.i(2687);
        if (cursor instanceof CrossProcessCursor) {
            this.mCursor = (CrossProcessCursor) cursor;
        } else {
            this.mCursor = new CrossProcessCursorWrapper(cursor);
        }
        this.mProviderName = str;
        synchronized (this.mLock) {
            try {
                createAndRegisterObserverProxyLocked(iContentObserver);
            } finally {
                AppMethodBeat.o(2687);
            }
        }
    }

    private void closeFilledWindowLocked() {
        AppMethodBeat.i(2688);
        if (this.mFilledWindow != null) {
            this.mFilledWindow.close();
            this.mFilledWindow = null;
        }
        AppMethodBeat.o(2688);
    }

    private void disposeLocked() {
        AppMethodBeat.i(2689);
        if (this.mCursor != null) {
            unregisterObserverProxyLocked();
            this.mCursor.close();
            this.mCursor = null;
        }
        closeFilledWindowLocked();
        AppMethodBeat.o(2689);
    }

    private void throwIfCursorIsClosed() {
        AppMethodBeat.i(2690);
        if (this.mCursor == null) {
            StaleDataException staleDataException = new StaleDataException("Attempted to access a cursor after it has been closed.");
            AppMethodBeat.o(2690);
            throw staleDataException;
        }
        AppMethodBeat.o(2690);
    }

    public final void binderDied() {
        AppMethodBeat.i(2691);
        synchronized (this.mLock) {
            try {
                disposeLocked();
            } finally {
                AppMethodBeat.o(2691);
            }
        }
    }

    public final BulkCursorDescriptor getBulkCursorDescriptor() {
        BulkCursorDescriptor bulkCursorDescriptor;
        AppMethodBeat.i(2692);
        synchronized (this.mLock) {
            try {
                throwIfCursorIsClosed();
                bulkCursorDescriptor = new BulkCursorDescriptor();
                bulkCursorDescriptor.cursor = this;
                bulkCursorDescriptor.columnNames = this.mCursor.getColumnNames();
                bulkCursorDescriptor.wantsAllOnMoveCalls = this.mCursor.getWantsAllOnMoveCalls();
                bulkCursorDescriptor.count = this.mCursor.getCount();
                bulkCursorDescriptor.window = this.mCursor.getWindow();
                if (bulkCursorDescriptor.window != null) {
                    bulkCursorDescriptor.window.acquireReference();
                }
            } finally {
                AppMethodBeat.o(2692);
            }
        }
        return bulkCursorDescriptor;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public final CursorWindow getWindow(int i2) {
        CursorWindow window;
        AppMethodBeat.i(2693);
        synchronized (this.mLock) {
            try {
                throwIfCursorIsClosed();
                if (!this.mCursor.moveToPosition(i2)) {
                    closeFilledWindowLocked();
                    window = null;
                } else {
                    window = this.mCursor.getWindow();
                    if (window != null) {
                        closeFilledWindowLocked();
                    } else {
                        window = this.mFilledWindow;
                        if (window == null) {
                            this.mFilledWindow = new CursorWindow(this.mProviderName);
                            window = this.mFilledWindow;
                        } else if (i2 < window.getStartPosition() || i2 >= window.getStartPosition() + window.getNumRows()) {
                            window.clear();
                        }
                        this.mCursor.fillWindow(i2, window);
                    }
                    if (window != null) {
                        window.acquireReference();
                    }
                    AppMethodBeat.o(2693);
                }
            } finally {
                AppMethodBeat.o(2693);
            }
        }
        return window;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public final void onMove(int i2) {
        AppMethodBeat.i(2694);
        synchronized (this.mLock) {
            try {
                throwIfCursorIsClosed();
                this.mCursor.onMove(this.mCursor.getPosition(), i2);
            } finally {
                AppMethodBeat.o(2694);
            }
        }
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public final void deactivate() {
        AppMethodBeat.i(2695);
        synchronized (this.mLock) {
            try {
                if (this.mCursor != null) {
                    unregisterObserverProxyLocked();
                    this.mCursor.deactivate();
                }
                closeFilledWindowLocked();
            } finally {
                AppMethodBeat.o(2695);
            }
        }
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public final void close() {
        AppMethodBeat.i(2696);
        synchronized (this.mLock) {
            try {
                disposeLocked();
            } finally {
                AppMethodBeat.o(2696);
            }
        }
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public final int requery(IContentObserver iContentObserver) {
        int count;
        AppMethodBeat.i(2697);
        synchronized (this.mLock) {
            try {
                throwIfCursorIsClosed();
                closeFilledWindowLocked();
                try {
                    if (!this.mCursor.requery()) {
                        count = -1;
                    } else {
                        unregisterObserverProxyLocked();
                        createAndRegisterObserverProxyLocked(iContentObserver);
                        count = this.mCursor.getCount();
                        AppMethodBeat.o(2697);
                    }
                } catch (IllegalStateException e2) {
                    IllegalStateException illegalStateException = new IllegalStateException(this.mProviderName + " Requery misuse db, mCursor isClosed:" + this.mCursor.isClosed(), e2);
                    AppMethodBeat.o(2697);
                    throw illegalStateException;
                }
            } finally {
                AppMethodBeat.o(2697);
            }
        }
        return count;
    }

    private void createAndRegisterObserverProxyLocked(IContentObserver iContentObserver) {
        AppMethodBeat.i(2698);
        if (this.mObserver != null) {
            IllegalStateException illegalStateException = new IllegalStateException("an observer is already registered");
            AppMethodBeat.o(2698);
            throw illegalStateException;
        }
        this.mObserver = new ContentObserverProxy(iContentObserver, this);
        this.mCursor.registerContentObserver(this.mObserver);
        AppMethodBeat.o(2698);
    }

    private void unregisterObserverProxyLocked() {
        AppMethodBeat.i(2699);
        if (this.mObserver != null) {
            this.mCursor.unregisterContentObserver(this.mObserver);
            this.mObserver.unlinkToDeath(this);
            this.mObserver = null;
        }
        AppMethodBeat.o(2699);
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public final Bundle getExtras() {
        Bundle extras;
        AppMethodBeat.i(2700);
        synchronized (this.mLock) {
            try {
                throwIfCursorIsClosed();
                extras = this.mCursor.getExtras();
            } finally {
                AppMethodBeat.o(2700);
            }
        }
        return extras;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public final Bundle respond(Bundle bundle) {
        Bundle respond;
        AppMethodBeat.i(2701);
        synchronized (this.mLock) {
            try {
                throwIfCursorIsClosed();
                respond = this.mCursor.respond(bundle);
            } finally {
                AppMethodBeat.o(2701);
            }
        }
        return respond;
    }
}
