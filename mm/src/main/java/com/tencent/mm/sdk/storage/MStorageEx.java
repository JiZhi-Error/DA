package com.tencent.mm.sdk.storage;

import android.os.Looper;
import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class MStorageEx implements IStorageEx {
    public static final int EVENT_CREATE = 1;
    public static final int EVENT_DELETE = 5;
    public static final int EVENT_DROP = 6;
    public static final int EVENT_INSERT = 2;
    public static final int EVENT_QUERY = 7;
    public static final int EVENT_REPLACE = 4;
    public static final int EVENT_UPDATE = 3;
    private final MStorageEvent<IOnStorageChange, Event> defaults = new MStorageEvent<IOnStorageChange, Event>() {
        /* class com.tencent.mm.sdk.storage.MStorageEx.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public /* bridge */ /* synthetic */ void processEvent(IOnStorageChange iOnStorageChange, Event event) {
            AppMethodBeat.i(158087);
            processEvent(iOnStorageChange, event);
            AppMethodBeat.o(158087);
        }

        /* access modifiers changed from: protected */
        public void processEvent(IOnStorageChange iOnStorageChange, Event event) {
            AppMethodBeat.i(230536);
            if (!MStorageEx.this.shouldProcessEvent()) {
                AppMethodBeat.o(230536);
                return;
            }
            MStorageEx.this.processEvent(iOnStorageChange, event);
            AppMethodBeat.o(230536);
        }
    };

    public interface IOnStorageChange {
        void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj);
    }

    /* access modifiers changed from: protected */
    public abstract boolean shouldProcessEvent();

    /* access modifiers changed from: package-private */
    public class Event {
        int event;
        MStorageEx mstorage;
        Object obj;

        Event(int i2, MStorageEx mStorageEx, Object obj2) {
            this.event = i2;
            this.obj = obj2;
            this.mstorage = mStorageEx;
        }
    }

    @Override // com.tencent.mm.sdk.storage.IStorageEx
    public void add(IOnStorageChange iOnStorageChange) {
        if (iOnStorageChange != null) {
            this.defaults.add(iOnStorageChange, Looper.getMainLooper());
        }
    }

    @Override // com.tencent.mm.sdk.storage.IStorageEx
    public void add(IOnStorageChange iOnStorageChange, Looper looper) {
        if (iOnStorageChange != null) {
            this.defaults.add(iOnStorageChange, looper);
        }
    }

    @Override // com.tencent.mm.sdk.storage.IStorageEx
    public void add(IOnStorageChange iOnStorageChange, a aVar) {
        if (iOnStorageChange != null) {
            this.defaults.add(iOnStorageChange, aVar);
        }
    }

    @Override // com.tencent.mm.sdk.storage.IStorageEx
    public void remove(IOnStorageChange iOnStorageChange) {
        if (iOnStorageChange != null) {
            this.defaults.remove(iOnStorageChange);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void processEvent(IOnStorageChange iOnStorageChange, Event event) {
        iOnStorageChange.onNotifyChange(event.event, event.mstorage, event.obj);
    }

    @Override // com.tencent.mm.sdk.storage.IStorageEx
    public void doNotify(int i2, MStorageEx mStorageEx, Object obj) {
        this.defaults.event(new Event(i2, mStorageEx, obj));
        this.defaults.doNotify();
    }
}
