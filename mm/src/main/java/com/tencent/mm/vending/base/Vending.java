package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.base.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Vending<_Struct, _Index, _Change> implements com.tencent.mm.vending.e.a {
    private static final int MESSAGE_DO_DESTROY = 2;
    private static final int MESSAGE_NOTIFY_DATA_LOADED = 1;
    private static final int MESSAGE_PREPARE_VENDING_DATA = 1;
    private static final int SYNC_MESSAGE_APPLY_CHANGE = 1;
    private static final int SYNC_MESSAGE_CLEAR_RESOLVED_ONLY = 3;
    private static final int SYNC_MESSAGE_PREPARE_DATA_DEGRADE = 2;
    private static final String TAG = "Vending";
    private g<_Index, i<_Struct, _Index>> mArray;
    private byte[] mArrayDataLock;
    private AtomicBoolean mCallDestroyed;
    private volatile com.tencent.mm.vending.b.c mDataChangedCallback;
    private volatile com.tencent.mm.vending.b.c mDataResolvedCallback;
    private c<_Index> mDeadlock;
    private boolean mFreezeDataChange;
    private boolean mHasPendingDataChange;
    private f mLoader;
    private byte[] mPendingDataChangeLock;
    private boolean mResolveFromVending;
    private Handler mSubscriberHandler;
    private Looper mSubscriberLooper;
    HashSet<Vending<_Struct, _Index, _Change>.h> mVendingDeferring;
    private Handler mVendingHandler;
    private Looper mVendingLooper;
    private c mVendingSync;

    /* access modifiers changed from: package-private */
    public interface b {
        void hdr();
    }

    public interface d {
        void fjn();
    }

    public interface e<_Index> {
        void eh(_Index _index);
    }

    /* access modifiers changed from: protected */
    public abstract void applyChangeSynchronized(_Change _change);

    /* access modifiers changed from: protected */
    public abstract void destroyAsynchronous();

    /* access modifiers changed from: protected */
    public abstract _Change prepareVendingDataAsynchronous();

    /* access modifiers changed from: protected */
    public abstract _Struct resolveAsynchronous(_Index _index);

    /* access modifiers changed from: package-private */
    public static final class a<T> {
        volatile T object;

        private a() {
            AppMethodBeat.i(74964);
            AppMethodBeat.o(74964);
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c<_Index> {
        a<_Index> QZl;
        i QZm;

        private c() {
            AppMethodBeat.i(177472);
            this.QZl = new a<>((byte) 0);
            AppMethodBeat.o(177472);
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final void reset() {
            this.QZl.object = null;
            this.QZm = null;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class i<_Struct, _Index> {
        boolean QYW = false;
        _Index QZw;
        _Struct QZx;
        boolean QZy = false;
        boolean QZz = false;
        boolean avb = false;
        boolean hsY = false;
        byte[] mLock = new byte[0];

        i() {
            AppMethodBeat.i(177474);
            AppMethodBeat.o(177474);
        }
    }

    /* access modifiers changed from: package-private */
    public f<_Index> getLoader() {
        return this.mLoader;
    }

    public com.tencent.mm.vending.b.b<d> addVendingDataChangedCallback(d dVar) {
        return this.mDataChangedCallback.add(dVar);
    }

    public void removeVendingDataChangedCallback(d dVar) {
        this.mDataChangedCallback.remove(dVar);
    }

    public com.tencent.mm.vending.b.b<e> addVendingDataResolvedCallback(e eVar) {
        return this.mDataResolvedCallback.add(eVar);
    }

    public void removeVendingDataResolvedCallback(e eVar) {
        this.mDataResolvedCallback.remove(eVar);
    }

    public Vending() {
        this(Looper.getMainLooper());
    }

    public Vending(Looper looper) {
        this.mCallDestroyed = new AtomicBoolean(false);
        this.mArrayDataLock = new byte[0];
        this.mPendingDataChangeLock = new byte[0];
        this.mHasPendingDataChange = false;
        this.mFreezeDataChange = false;
        this.mDeadlock = new c<>((byte) 0);
        this.mDataChangedCallback = new com.tencent.mm.vending.b.c<d>(com.tencent.mm.vending.h.d.UI) {
            /* class com.tencent.mm.vending.base.Vending.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.vending.j.a] */
            @Override // com.tencent.mm.vending.b.c
            public final /* synthetic */ void a(d dVar, com.tencent.mm.vending.j.a aVar) {
                AppMethodBeat.i(74962);
                dVar.fjn();
                AppMethodBeat.o(74962);
            }
        };
        this.mDataResolvedCallback = new com.tencent.mm.vending.b.c<e>(com.tencent.mm.vending.h.d.UI) {
            /* class com.tencent.mm.vending.base.Vending.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.vending.j.a] */
            /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: com.tencent.mm.vending.base.Vending$e */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mm.vending.b.c
            public final /* synthetic */ void a(e eVar, com.tencent.mm.vending.j.a aVar) {
                AppMethodBeat.i(74951);
                eVar.eh(aVar.get(0));
                AppMethodBeat.o(74951);
            }
        };
        this.mArray = new g<>();
        this.mVendingDeferring = new HashSet<>();
        this.mResolveFromVending = false;
        this.mSubscriberLooper = looper;
        this.mVendingLooper = com.tencent.mm.vending.i.b.hdL().RaP.getLooper();
        this.mArray.QZv = new b() {
            /* class com.tencent.mm.vending.base.Vending.AnonymousClass3 */

            @Override // com.tencent.mm.vending.base.Vending.b
            public final void hdr() {
                AppMethodBeat.i(177471);
                com.tencent.mm.vending.f.a.i(Vending.TAG, "SafeSparseArray fusing.", new Object[0]);
                Vending.this.deadlock();
                AppMethodBeat.o(177471);
            }
        };
        this.mVendingSync = new c(this.mSubscriberLooper, this.mVendingLooper);
        this.mVendingSync.QZD = new c.a() {
            /* class com.tencent.mm.vending.base.Vending.AnonymousClass4 */

            @Override // com.tencent.mm.vending.base.c.a
            public final void hds() {
                AppMethodBeat.i(74956);
                com.tencent.mm.vending.f.a.i(Vending.TAG, "%s beforeSynchronize", Vending.this);
                Vending.this.mLoader.hdu();
                AppMethodBeat.o(74956);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.tencent.mm.vending.base.Vending */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mm.vending.base.c.a
            public final void synchronizing(int i2, Object obj) {
                AppMethodBeat.i(74957);
                com.tencent.mm.vending.f.a.i(Vending.TAG, "%s synchronizing", Vending.this);
                Vending.this.mVendingDeferring.clear();
                Vending.this.mLoader.hdu();
                Vending.this.mSubscriberHandler.removeCallbacksAndMessages(null);
                if (i2 == 2) {
                    obj = Vending.this.prepareVendingDataAsynchronous();
                }
                if (i2 == 2 || i2 == 1) {
                    Vending.this.applyChangeSynchronized(obj);
                }
                Vending.this.synchronizing(i2, obj);
                Vending.this.mArray.clear();
                AppMethodBeat.o(74957);
            }

            @Override // com.tencent.mm.vending.base.c.a
            public final void hdt() {
                AppMethodBeat.i(74958);
                com.tencent.mm.vending.f.a.i(Vending.TAG, "%s afterSynchronize", Vending.this);
                if (Vending.this.mDataChangedCallback != null) {
                    Vending.this.mDataChangedCallback.invoke();
                }
                AppMethodBeat.o(74958);
            }
        };
        this.mSubscriberHandler = new Handler(this.mSubscriberLooper) {
            /* class com.tencent.mm.vending.base.Vending.AnonymousClass5 */

            public final void handleMessage(Message message) {
                AppMethodBeat.i(74963);
                switch (message.what) {
                    case 1:
                        i iVar = (i) message.obj;
                        Vending.this.onDataResolved(iVar.QZw, iVar.QZx);
                        break;
                }
                AppMethodBeat.o(74963);
            }
        };
        this.mVendingHandler = new Handler(this.mVendingLooper) {
            /* class com.tencent.mm.vending.base.Vending.AnonymousClass6 */

            public final void handleMessage(Message message) {
                AppMethodBeat.i(74955);
                switch (message.what) {
                    case 1:
                        Vending.this.callPrepareVendingData();
                        AppMethodBeat.o(74955);
                        return;
                    case 2:
                        Vending.this.destroyAsynchronous();
                        break;
                }
                AppMethodBeat.o(74955);
            }
        };
        this.mLoader = new f(this.mVendingLooper, new f.a<_Index>() {
            /* class com.tencent.mm.vending.base.Vending.AnonymousClass7 */

            @Override // com.tencent.mm.vending.base.Vending.f.a
            public final void ei(_Index _index) {
                AppMethodBeat.i(74965);
                i<_Struct, _Index> lock = Vending.this.getLock(_index);
                boolean loadFromVending = Vending.this.loadFromVending(lock, _index);
                if (lock.QYW) {
                    com.tencent.mm.vending.f.a.d(Vending.TAG, "This lock is defer to return %s %s", lock, _index);
                    AppMethodBeat.o(74965);
                } else if (loadFromVending) {
                    AppMethodBeat.o(74965);
                } else {
                    Vending.this.notifyDataLoadedIfNeed(lock);
                    AppMethodBeat.o(74965);
                }
            }

            @Override // com.tencent.mm.vending.base.Vending.f.a
            public final void cancel() {
                AppMethodBeat.i(74966);
                Vending.this.loaderClear();
                Vending.this.deadlock();
                AppMethodBeat.o(74966);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void synchronizing(int i2, Object obj) {
    }

    /* access modifiers changed from: protected */
    public i<_Struct, _Index> getLock(_Index _index) {
        i<_Struct, _Index> iVar;
        synchronized (this.mArrayDataLock) {
            iVar = this.mArray.get(_index);
            if (iVar == null) {
                iVar = new i<>();
                this.mArray.put(_index, iVar);
            }
        }
        return iVar;
    }

    /* access modifiers changed from: protected */
    public i<_Struct, _Index> peekLock(_Index _index) {
        i<_Struct, _Index> iVar;
        synchronized (this.mArrayDataLock) {
            iVar = this.mArray.get(_index);
        }
        return iVar;
    }

    public class h {
        private _Index QZw;

        h(_Index _index) {
            this.QZw = _index;
        }
    }

    /* access modifiers changed from: protected */
    public Vending<_Struct, _Index, _Change>.h defer(_Index _index) {
        looperCheckForVending();
        if (!this.mResolveFromVending) {
            com.tencent.mm.vending.f.a.w(TAG, "Please call defer in resolveAsynchronous()", new Object[0]);
            return null;
        }
        getLock(_index).QYW = true;
        Vending<_Struct, _Index, _Change>.h hVar = new h(_index);
        this.mVendingDeferring.add(hVar);
        return hVar;
    }

    /* access modifiers changed from: private */
    public void deferResolved(Vending<_Struct, _Index, _Change>.h hVar, _Index _index, _Struct _struct) {
        if (this.mVendingDeferring.contains(hVar)) {
            i<_Struct, _Index> lock = getLock(_index);
            synchronized (lock.mLock) {
                lock.QYW = false;
                lockResolved(lock, _index, _struct);
            }
            notifyDataLoadedIfNeed(lock);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, _Struct] */
    public <T> T peek(_Index _index) {
        i<_Struct, _Index> peekLock;
        if (!this.mCallDestroyed.get() && !invalidIndex(_index) && (peekLock = peekLock(_index)) != null && !peekLock.avb) {
            return peekLock.QZx;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
    public <T> T get(_Index _index) {
        return getSync(_index);
    }

    private _Struct getSync(_Index _index) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != this.mSubscriberLooper && myLooper != this.mVendingLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        } else if (this.mCallDestroyed.get()) {
            return null;
        } else {
            i<_Struct, _Index> lock = getLock(_index);
            if (invalidIndex(_index)) {
                return lock.QZx;
            }
            if (myLooper == this.mSubscriberLooper) {
                return forSubscriberSync(lock, _index).QZx;
            }
            loadFromVending(lock, _index);
            return lock.QZx;
        }
    }

    private void lockResolved(i<_Struct, _Index> iVar, _Index _index, _Struct _struct) {
        iVar.QZx = _struct;
        iVar.QZw = _index;
        iVar.avb = false;
        iVar.QZy = false;
        iVar.hsY = true;
        if (this.mDeadlock.QZm == iVar) {
            iVar.QZz = true;
        }
        iVar.mLock.notify();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean loadFromVending(i<_Struct, _Index> iVar, _Index _index) {
        synchronized (iVar.mLock) {
            if (iVar.hsY && !iVar.avb && !iVar.QZy) {
                return true;
            }
            this.mResolveFromVending = true;
            _Struct resolveAsynchronous = resolveAsynchronous(_index);
            this.mResolveFromVending = false;
            if (iVar.QYW) {
                return false;
            }
            lockResolved(iVar, _index, resolveAsynchronous);
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: _Index */
    /* JADX WARN: Multi-variable type inference failed */
    private i<_Struct, _Index> forSubscriberSync(i<_Struct, _Index> iVar, _Index _index) {
        if (!com.tencent.mm.vending.i.b.hdL().RaP.isAlive()) {
            com.tencent.mm.vending.f.a.e(TAG, "Vending thread is not running!", new Object[0]);
        } else {
            synchronized (iVar.mLock) {
                boolean requestIndex = requestIndex(iVar, _index);
                if (!iVar.hsY || iVar.avb) {
                    if (requestIndex) {
                        this.mDeadlock.QZl.object = _index;
                        this.mDeadlock.QZm = iVar;
                        com.tencent.mm.vending.f.a.i(TAG, "%s waiting %s", this, _index);
                        long nanoTime = System.nanoTime();
                        try {
                            iVar.mLock.wait();
                        } catch (InterruptedException e2) {
                        }
                        com.tencent.mm.vending.f.a.i(TAG, "%s waiting duration %s", this, Long.valueOf(System.nanoTime() - nanoTime));
                        this.mDeadlock.reset();
                    }
                }
            }
        }
        return iVar;
    }

    /* access modifiers changed from: protected */
    public boolean invalidIndex(_Index _index) {
        return false;
    }

    private _Struct getAsync(_Index _index) {
        if (invalidIndex(_index)) {
            return null;
        }
        i<_Struct, _Index> lock = getLock(_index);
        if (!requestIndex(lock, _index) || lock.avb) {
            return null;
        }
        return lock.QZx;
    }

    public void request(_Index _index) {
        refillImpl(_index, false);
    }

    public void requestConsistent(_Index _index) {
        refillImpl(_index, true);
    }

    private void refillImpl(_Index _index, boolean z) {
        looperCheckBoth();
        if (!this.mCallDestroyed.get()) {
            i<_Struct, _Index> lock = getLock(_index);
            synchronized (lock.mLock) {
                if (lock.hsY) {
                    if (z) {
                        lock.avb = true;
                    } else {
                        lock.QZy = true;
                    }
                }
            }
            getAsync(_index);
        }
    }

    public void resolvedClear() {
        looperCheckBoth();
        if (!this.mCallDestroyed.get()) {
            this.mVendingSync.t(3, null);
        }
    }

    public void notifyVendingDataChange() {
        notifyVendingDataChange(false);
    }

    public void notifyVendingDataChangeSynchronize() {
        notifyVendingDataChange(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        if (android.os.Looper.myLooper() != r3.mVendingLooper) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        callPrepareVendingData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0049, code lost:
        r3.mVendingHandler.removeMessages(1);
        r3.mVendingHandler.sendMessage(r3.mVendingHandler.obtainMessage(1));
        r3.mVendingHandler.post(new com.tencent.mm.vending.base.Vending.AnonymousClass8(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void notifyVendingDataChange(boolean r4) {
        /*
            r3 = this;
            r2 = 1
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.mCallDestroyed
            boolean r0 = r0.get()
            if (r0 == 0) goto L_0x000a
        L_0x0009:
            return
        L_0x000a:
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = r3.mSubscriberLooper
            if (r0 == r1) goto L_0x0023
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = r3.mVendingLooper
            if (r0 == r1) goto L_0x0023
            java.lang.IllegalAccessError r0 = new java.lang.IllegalAccessError
            java.lang.String r1 = "Call from wrong thread"
            r0.<init>(r1)
            throw r0
        L_0x0023:
            if (r4 == 0) goto L_0x002d
            com.tencent.mm.vending.base.c r0 = r3.mVendingSync
            r1 = 2
            r2 = 0
            r0.t(r1, r2)
            goto L_0x0009
        L_0x002d:
            byte[] r1 = r3.mPendingDataChangeLock
            monitor-enter(r1)
            boolean r0 = r3.mFreezeDataChange     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x003c
            r0 = 1
            r3.mHasPendingDataChange = r0     // Catch:{ all -> 0x0039 }
            monitor-exit(r1)     // Catch:{ all -> 0x0039 }
            goto L_0x0009
        L_0x0039:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0039 }
            throw r0
        L_0x003c:
            monitor-exit(r1)
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = r3.mVendingLooper
            if (r0 != r1) goto L_0x0049
            r3.callPrepareVendingData()
            goto L_0x0009
        L_0x0049:
            android.os.Handler r0 = r3.mVendingHandler
            r0.removeMessages(r2)
            android.os.Handler r0 = r3.mVendingHandler
            android.os.Handler r1 = r3.mVendingHandler
            android.os.Message r1 = r1.obtainMessage(r2)
            r0.sendMessage(r1)
            android.os.Handler r0 = r3.mVendingHandler
            com.tencent.mm.vending.base.Vending$8 r1 = new com.tencent.mm.vending.base.Vending$8
            r1.<init>()
            r0.post(r1)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vending.base.Vending.notifyVendingDataChange(boolean):void");
    }

    public void freezeDataChange() {
        if (!this.mCallDestroyed.get()) {
            synchronized (this.mPendingDataChangeLock) {
                this.mFreezeDataChange = true;
            }
        }
    }

    public void unfreezeDataChange() {
        if (!this.mCallDestroyed.get()) {
            synchronized (this.mPendingDataChangeLock) {
                this.mFreezeDataChange = false;
                if (this.mHasPendingDataChange) {
                    notifyVendingDataChange();
                    this.mHasPendingDataChange = false;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void loaderClear() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void deadlock() {
        if (this.mDeadlock.QZl.object != null) {
            com.tencent.mm.vending.f.a.e(TAG, "Catch deadlock! Tell Carl! .. " + ((Object) this.mDeadlock.QZl.object), new Object[0]);
            if (this.mDeadlock.QZm != null) {
                synchronized (this.mDeadlock.QZm.mLock) {
                    this.mDeadlock.QZm.mLock.notify();
                }
                this.mDeadlock.reset();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void requestIndexImpl(i<_Struct, _Index> iVar, _Index _index) {
    }

    private boolean requestIndex(i<_Struct, _Index> iVar, _Index _index) {
        if (invalidIndex(_index)) {
            return false;
        }
        if (this.mCallDestroyed.get()) {
            com.tencent.mm.vending.f.a.e(TAG, "Vending.destroyed() has called.", new Object[0]);
            return false;
        }
        f fVar = this.mLoader;
        if (!fVar.kQW.get()) {
            synchronized (fVar.QZp) {
                fVar.QZn.put(_index, f.b.PENDING);
            }
            fVar.mVendingHandler.sendMessageAtFrontOfQueue(fVar.mVendingHandler.obtainMessage(0, _index));
        }
        requestIndexImpl(iVar, _index);
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void callPrepareVendingData() {
        if (!this.mCallDestroyed.get()) {
            com.tencent.mm.vending.f.a.i(TAG, "Vending.callPrepareVendingData()", new Object[0]);
            this.mVendingSync.t(1, prepareVendingDataAsynchronous());
        }
    }

    public Looper getLooper() {
        return this.mVendingLooper;
    }

    @Override // com.tencent.mm.vending.e.a
    public final void dead() {
        looperCheckBoth();
        com.tencent.mm.vending.f.a.i(TAG, "Vending.destroy()", new Object[0]);
        this.mCallDestroyed.set(true);
        this.mVendingHandler.removeCallbacksAndMessages(null);
        this.mSubscriberHandler.removeCallbacksAndMessages(null);
        this.mLoader.kQW.set(true);
        this.mLoader.hdu();
        this.mVendingHandler.sendMessage(this.mVendingHandler.obtainMessage(2));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onDataResolved(_Index _index, _Struct _struct) {
        if (!this.mCallDestroyed.get() && this.mDataResolvedCallback != null) {
            this.mDataResolvedCallback.invoke(com.tencent.mm.vending.g.g.eo(_index));
        }
    }

    /* access modifiers changed from: protected */
    public void looperCheckForVending() {
        if (Looper.myLooper() != this.mVendingLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    /* access modifiers changed from: protected */
    public void looperCheckForSubscriber() {
        if (Looper.myLooper() != this.mSubscriberLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    /* access modifiers changed from: protected */
    public void looperCheckBoth() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != this.mSubscriberLooper && myLooper != this.mVendingLooper) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    /* access modifiers changed from: package-private */
    public static class g<K, V> extends HashMap<K, V> {
        b QZv = null;

        g() {
        }

        public final void clear() {
            AppMethodBeat.i(177473);
            super.clear();
            if (this.QZv != null) {
                this.QZv.hdr();
            }
            AppMethodBeat.o(177473);
        }
    }

    public static final class f<_Index> {
        HashMap<_Index, b> QZn = new HashMap<>();
        a<_Index> QZo = null;
        byte[] QZp = new byte[0];
        AtomicBoolean kQW = new AtomicBoolean(false);
        Handler mVendingHandler;

        /* access modifiers changed from: protected */
        public interface a<_Index> {
            void cancel();

            void ei(_Index _index);
        }

        public enum b {
            NIL,
            PENDING,
            FILLED;

            public static b valueOf(String str) {
                AppMethodBeat.i(74953);
                b bVar = (b) Enum.valueOf(b.class, str);
                AppMethodBeat.o(74953);
                return bVar;
            }

            static {
                AppMethodBeat.i(74954);
                AppMethodBeat.o(74954);
            }
        }

        protected f(Looper looper, a<_Index> aVar) {
            AppMethodBeat.i(74947);
            this.QZo = aVar;
            this.mVendingHandler = new Handler(looper) {
                /* class com.tencent.mm.vending.base.Vending.f.AnonymousClass1 */

                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.tencent.mm.vending.base.Vending$f$a<_Index> */
                /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.util.HashMap<_Index, com.tencent.mm.vending.base.Vending$f$b> */
                /* JADX WARN: Multi-variable type inference failed */
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(74961);
                    if (f.this.kQW.get()) {
                        f.this.QZo.cancel();
                        AppMethodBeat.o(74961);
                        return;
                    }
                    Object obj = message.obj;
                    f.this.QZo.ei(obj);
                    synchronized (f.this.QZp) {
                        try {
                            f.this.QZn.put(obj, b.FILLED);
                        } finally {
                            AppMethodBeat.o(74961);
                        }
                    }
                }
            };
            AppMethodBeat.o(74947);
        }

        /* access modifiers changed from: protected */
        public final void hdu() {
            AppMethodBeat.i(74948);
            this.mVendingHandler.removeCallbacksAndMessages(null);
            com.tencent.mm.vending.f.a.i("Vending.Loader", "clear()", new Object[0]);
            synchronized (this.QZp) {
                try {
                    this.QZn.clear();
                } catch (Throwable th) {
                    AppMethodBeat.o(74948);
                    throw th;
                }
            }
            this.QZo.cancel();
            AppMethodBeat.o(74948);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void notifyDataLoadedIfNeed(i<_Struct, _Index> iVar) {
        if (iVar.QZz) {
            iVar.QZz = false;
        } else {
            this.mSubscriberHandler.sendMessage(this.mSubscriberHandler.obtainMessage(1, iVar));
        }
    }
}
