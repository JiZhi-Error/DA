package com.tencent.mm.sdk.storage;

import android.os.Looper;
import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class MStorage implements IStorage {
    private final MStorageEvent<IOnStorageChange, MStorageEventData> defaults = new MStorageEvent<IOnStorageChange, MStorageEventData>() {
        /* class com.tencent.mm.sdk.storage.MStorage.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public /* bridge */ /* synthetic */ void processEvent(IOnStorageChange iOnStorageChange, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(158083);
            processEvent(iOnStorageChange, mStorageEventData);
            AppMethodBeat.o(158083);
        }

        /* access modifiers changed from: protected */
        public void processEvent(IOnStorageChange iOnStorageChange, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(230534);
            MStorage.this.processEvent(iOnStorageChange, mStorageEventData);
            AppMethodBeat.o(230534);
        }
    };
    private final MStorageEvent<IOnStorageLoaded, String> loadedListener = new MStorageEvent<IOnStorageLoaded, String>() {
        /* class com.tencent.mm.sdk.storage.MStorage.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public /* bridge */ /* synthetic */ void processEvent(IOnStorageLoaded iOnStorageLoaded, String str) {
            AppMethodBeat.i(158084);
            processEvent(iOnStorageLoaded, str);
            AppMethodBeat.o(158084);
        }

        /* access modifiers changed from: protected */
        public void processEvent(IOnStorageLoaded iOnStorageLoaded, String str) {
            AppMethodBeat.i(230535);
            MStorage.this.processLoaded(iOnStorageLoaded, str);
            AppMethodBeat.o(230535);
        }
    };

    public interface IOnStorageChange {
        void onNotifyChange(String str, MStorageEventData mStorageEventData);
    }

    public interface IOnStorageLoaded {
        void onNotifyLoaded();
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void lock() {
        this.defaults.lock();
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public int lockCount() {
        return this.defaults.lockCount();
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void unlock() {
        this.defaults.unlock();
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void add(IOnStorageChange iOnStorageChange) {
        this.defaults.add(iOnStorageChange, Looper.getMainLooper());
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void add(IOnStorageChange iOnStorageChange, Looper looper) {
        this.defaults.add(iOnStorageChange, looper);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void add(a aVar, IOnStorageChange iOnStorageChange) {
        this.defaults.add(iOnStorageChange, aVar);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void add(String str, IOnStorageChange iOnStorageChange) {
        this.defaults.add(iOnStorageChange, a.bqt(str));
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void addLoadedListener(IOnStorageLoaded iOnStorageLoaded) {
        this.loadedListener.add(iOnStorageLoaded, Looper.getMainLooper());
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void remove(IOnStorageChange iOnStorageChange) {
        this.defaults.remove(iOnStorageChange);
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void removeLoadedListener(IOnStorageLoaded iOnStorageLoaded) {
        this.loadedListener.remove(iOnStorageLoaded);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void processEvent(IOnStorageChange iOnStorageChange, MStorageEventData mStorageEventData) {
        iOnStorageChange.onNotifyChange(mStorageEventData.event, mStorageEventData);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void processLoaded(IOnStorageLoaded iOnStorageLoaded, String str) {
        iOnStorageLoaded.onNotifyLoaded();
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void doNotify() {
        this.defaults.event(new MStorageEventData("*"));
        this.defaults.doNotify();
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void doNotify(String str) {
        this.defaults.event(new MStorageEventData(str));
        this.defaults.doNotify();
    }

    @Override // com.tencent.mm.sdk.storage.IStorage
    public void doNotify(String str, int i2, Object obj) {
        MStorageEventData mStorageEventData = new MStorageEventData();
        mStorageEventData.event = str;
        mStorageEventData.eventId = i2;
        mStorageEventData.obj = obj;
        mStorageEventData.stg = this;
        this.defaults.event(mStorageEventData);
        this.defaults.doNotify();
    }
}
