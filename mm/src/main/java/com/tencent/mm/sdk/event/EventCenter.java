package com.tencent.mm.sdk.event;

import android.os.Looper;
import com.tencent.f.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.b.a;
import com.tencent.mm.vending.b.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.d;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import junit.framework.Assert;

public final class EventCenter {
    private static final String TAG = "MicroMsg.EventCenter";
    public static EventCenter instance = new EventCenter();
    private final HashMap<Integer, LinkedList<IListener>> listenersMap = new HashMap<>();
    private final HashMap<Integer, WxEventsCallbacks> mCallbacksMap = new HashMap<>();
    private SilenceNoLooperScheduler mSilenceNoLooperScheduler = new SilenceNoLooperScheduler();

    public static class SilenceNoLooperScheduler extends d {
        @Override // com.tencent.mm.vending.h.d
        public void arrange(Runnable runnable) {
            AppMethodBeat.i(125183);
            runnable.run();
            AppMethodBeat.o(125183);
        }

        @Override // com.tencent.mm.vending.h.d
        public void arrangeInterval(Runnable runnable, long j2) {
            AppMethodBeat.i(125184);
            runnable.run();
            AppMethodBeat.o(125184);
        }

        @Override // com.tencent.mm.vending.h.d
        public String getType() {
            AppMethodBeat.i(125185);
            String thread = Thread.currentThread().toString();
            AppMethodBeat.o(125185);
            return thread;
        }

        @Override // com.tencent.mm.vending.h.d
        public void cancel() {
        }
    }

    /* access modifiers changed from: package-private */
    public class WxEventsCallbacks extends a<IListener> {
        public /* bridge */ /* synthetic */ b add(Object obj) {
            AppMethodBeat.i(200833);
            b<IListener> add = add((IListener) obj);
            AppMethodBeat.o(200833);
            return add;
        }

        public /* bridge */ /* synthetic */ void remove(Object obj) {
            AppMethodBeat.i(200832);
            remove((IListener) obj);
            AppMethodBeat.o(200832);
        }

        public WxEventsCallbacks() {
            super(EventCenter.this.mSilenceNoLooperScheduler);
            AppMethodBeat.i(125187);
            AppMethodBeat.o(125187);
        }

        public void invoke(com.tencent.mm.vending.j.a aVar) {
            AppMethodBeat.i(125188);
            LinkedList<b> queue = getQueue();
            IEvent iEvent = (IEvent) aVar.get(0);
            if (iEvent == null) {
                Log.e(EventCenter.TAG, "event is null! fatal!");
                AppMethodBeat.o(125188);
                return;
            }
            if (iEvent.getOrder()) {
                Collections.sort(queue, new Comparator<b>() {
                    /* class com.tencent.mm.sdk.event.EventCenter.WxEventsCallbacks.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public /* bridge */ /* synthetic */ int compare(b bVar, b bVar2) {
                        AppMethodBeat.i(125186);
                        int compare = compare(bVar, bVar2);
                        AppMethodBeat.o(125186);
                        return compare;
                    }

                    public int compare(b bVar, b bVar2) {
                        AppMethodBeat.i(200831);
                        int priority = bVar2.QZG.getPriority() - bVar.QZG.getPriority();
                        AppMethodBeat.o(200831);
                        return priority;
                    }
                });
            }
            b[] bVarArr = new b[queue.size()];
            queue.toArray(bVarArr);
            int length = bVarArr.length;
            int i2 = 0;
            while (i2 < length && (!bVarArr[i2].QZG.callback(iEvent) || !iEvent.getOrder())) {
                i2++;
            }
            if (iEvent.callback != null) {
                iEvent.callback.run();
            }
            AppMethodBeat.o(125188);
        }

        public b<IListener> add(IListener iListener) {
            AppMethodBeat.i(125189);
            b<IListener> add = add(new b(iListener, this));
            AppMethodBeat.o(125189);
            return add;
        }

        public void remove(IListener iListener) {
            AppMethodBeat.i(125190);
            remove(new b(iListener, this));
            AppMethodBeat.o(125190);
        }
    }

    static {
        AppMethodBeat.i(125201);
        AppMethodBeat.o(125201);
    }

    private EventCenter() {
        AppMethodBeat.i(125191);
        AppMethodBeat.o(125191);
    }

    public final b<IListener> add(IListener iListener) {
        b<IListener> add;
        AppMethodBeat.i(125192);
        synchronized (this) {
            try {
                Assert.assertNotNull("EventPoolImpl.add", iListener);
                Log.v(TAG, "addListener %s(%d)", iListener, Integer.valueOf(iListener.__getEventID()));
                WxEventsCallbacks wxEventsCallbacks = this.mCallbacksMap.get(Integer.valueOf(iListener.__getEventID()));
                if (wxEventsCallbacks == null) {
                    HashMap<Integer, WxEventsCallbacks> hashMap = this.mCallbacksMap;
                    Integer valueOf = Integer.valueOf(iListener.__getEventID());
                    wxEventsCallbacks = new WxEventsCallbacks();
                    hashMap.put(valueOf, wxEventsCallbacks);
                }
                add = wxEventsCallbacks.add(iListener);
            } finally {
                AppMethodBeat.o(125192);
            }
        }
        return add;
    }

    @Deprecated
    public final boolean addListener(IListener iListener) {
        AppMethodBeat.i(125193);
        synchronized (this) {
            try {
                Assert.assertNotNull("EventPoolImpl.add", iListener);
                Log.v(TAG, "addListener %s(%d)", iListener, Integer.valueOf(iListener.__getEventID()));
                LinkedList<IListener> linkedList = this.listenersMap.get(Integer.valueOf(iListener.__getEventID()));
                if (linkedList == null) {
                    HashMap<Integer, LinkedList<IListener>> hashMap = this.listenersMap;
                    Integer valueOf = Integer.valueOf(iListener.__getEventID());
                    linkedList = new LinkedList<>();
                    hashMap.put(valueOf, linkedList);
                }
                if (linkedList.contains(iListener)) {
                    return true;
                }
                ListenerInstanceMonitor.markInstanceRegistered(iListener);
                boolean add = linkedList.add(iListener);
                AppMethodBeat.o(125193);
                return add;
            } finally {
                AppMethodBeat.o(125193);
            }
        }
    }

    @Deprecated
    public final boolean removeListener(IListener iListener) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(125194);
        synchronized (this) {
            try {
                Assert.assertNotNull("EventPoolImpl.remove", iListener);
                Log.v(TAG, "removeListener %s(%d)", iListener, Integer.valueOf(iListener.__getEventID()));
                LinkedList<IListener> linkedList = this.listenersMap.get(Integer.valueOf(iListener.__getEventID()));
                if (linkedList != null) {
                    z2 = linkedList.remove(iListener);
                }
                WxEventsCallbacks wxEventsCallbacks = this.mCallbacksMap.get(Integer.valueOf(iListener.__getEventID()));
                if (wxEventsCallbacks != null) {
                    wxEventsCallbacks.remove(iListener);
                    z = true;
                } else {
                    z = z2;
                }
                ListenerInstanceMonitor.markInstanceUnregistered(iListener);
            } finally {
                AppMethodBeat.o(125194);
            }
        }
        return z;
    }

    public final boolean publish(IEvent iEvent) {
        WxEventsCallbacks wxEventsCallbacks;
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.i(125195);
        Assert.assertNotNull("EventPoolImpl.publish", iEvent);
        Log.v(TAG, "publish %s(%d)", iEvent, Integer.valueOf(iEvent.__getEventID()));
        LinkedList<IListener> linkedList = null;
        synchronized (this) {
            try {
                int __getEventID = iEvent.__getEventID();
                LinkedList<IListener> linkedList2 = this.listenersMap.get(Integer.valueOf(__getEventID));
                if (linkedList2 != null) {
                    linkedList = new LinkedList<>(linkedList2);
                    z = true;
                }
                wxEventsCallbacks = this.mCallbacksMap.get(Integer.valueOf(__getEventID));
                if (wxEventsCallbacks == null) {
                    z2 = z;
                }
                if (!z2) {
                    Log.w(TAG, "No listener for this event %s(%d), Stack: %s.", iEvent, Integer.valueOf(__getEventID), "");
                }
            } finally {
                AppMethodBeat.o(125195);
            }
        }
        if (linkedList != null) {
            trigger(linkedList, iEvent);
        }
        if (wxEventsCallbacks != null) {
            wxEventsCallbacks.invoke(g.eo(iEvent));
        }
        return z2;
    }

    public final void asyncPublish(final IEvent iEvent, Looper looper) {
        AppMethodBeat.i(125196);
        Assert.assertNotNull("EventPoolImpl.asyncPublish event", iEvent);
        Assert.assertNotNull("EventPoolImpl.asyncPublish looper", looper);
        Log.v(TAG, "publish %s(%d)", iEvent, Integer.valueOf(iEvent.__getEventID()));
        new MMHandler(looper).post(new Runnable() {
            /* class com.tencent.mm.sdk.event.EventCenter.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(125179);
                EventCenter.instance.publish(iEvent);
                AppMethodBeat.o(125179);
            }
        });
        AppMethodBeat.o(125196);
    }

    public final void asyncPublish(final IEvent iEvent, Executor executor) {
        AppMethodBeat.i(125197);
        Assert.assertNotNull("EventPoolImpl.asyncPublish event", iEvent);
        Assert.assertNotNull("EventPoolImpl.asyncPublish executor", executor);
        Log.v(TAG, "publish %s(%d)", iEvent, Integer.valueOf(iEvent.__getEventID()));
        executor.execute(new h() {
            /* class com.tencent.mm.sdk.event.EventCenter.AnonymousClass2 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public String getKey() {
                AppMethodBeat.i(125180);
                String name = iEvent.getClass().getName();
                AppMethodBeat.o(125180);
                return name;
            }

            public void run() {
                AppMethodBeat.i(125181);
                EventCenter.instance.publish(iEvent);
                AppMethodBeat.o(125181);
            }
        });
        AppMethodBeat.o(125197);
    }

    public final synchronized boolean hasListener(Class<? extends IEvent> cls) {
        boolean z;
        AppMethodBeat.i(125198);
        Assert.assertNotNull("EventPoolImpl.hasListener", cls);
        LinkedList<IListener> linkedList = this.listenersMap.get(Integer.valueOf(cls.getName().hashCode()));
        if (linkedList == null || linkedList.size() <= 0) {
            WxEventsCallbacks wxEventsCallbacks = this.mCallbacksMap.get(Integer.valueOf(cls.getName().hashCode()));
            if (wxEventsCallbacks == null || wxEventsCallbacks.size() <= 0) {
                z = false;
                AppMethodBeat.o(125198);
            } else {
                AppMethodBeat.o(125198);
                z = true;
            }
        } else {
            AppMethodBeat.o(125198);
            z = true;
        }
        return z;
    }

    public final synchronized boolean hadListened(IListener iListener) {
        boolean z;
        AppMethodBeat.i(125199);
        Assert.assertNotNull("EventPoolImpl.hadListened", iListener);
        LinkedList<IListener> linkedList = this.listenersMap.get(Integer.valueOf(iListener.__getEventID()));
        if (linkedList == null || linkedList.isEmpty() || !linkedList.contains(iListener)) {
            WxEventsCallbacks wxEventsCallbacks = this.mCallbacksMap.get(Integer.valueOf(iListener.__getEventID()));
            if (wxEventsCallbacks == null || wxEventsCallbacks.size() <= 0 || !wxEventsCallbacks.contains(iListener)) {
                z = false;
                AppMethodBeat.o(125199);
            } else {
                AppMethodBeat.o(125199);
                z = true;
            }
        } else {
            AppMethodBeat.o(125199);
            z = true;
        }
        return z;
    }

    private void trigger(LinkedList<IListener> linkedList, IEvent iEvent) {
        AppMethodBeat.i(125200);
        if (iEvent.getOrder()) {
            Collections.sort(linkedList, new Comparator<IListener>() {
                /* class com.tencent.mm.sdk.event.EventCenter.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public /* bridge */ /* synthetic */ int compare(IListener iListener, IListener iListener2) {
                    AppMethodBeat.i(125182);
                    int compare = compare(iListener, iListener2);
                    AppMethodBeat.o(125182);
                    return compare;
                }

                public int compare(IListener iListener, IListener iListener2) {
                    AppMethodBeat.i(200830);
                    int priority = iListener2.getPriority() - iListener.getPriority();
                    AppMethodBeat.o(200830);
                    return priority;
                }
            });
        }
        IListener[] iListenerArr = new IListener[linkedList.size()];
        linkedList.toArray(iListenerArr);
        int length = iListenerArr.length;
        int i2 = 0;
        while (i2 < length && (!iListenerArr[i2].callback(iEvent) || !iEvent.getOrder())) {
            i2++;
        }
        if (iEvent.callback != null) {
            iEvent.callback.run();
        }
        AppMethodBeat.o(125200);
    }
}
