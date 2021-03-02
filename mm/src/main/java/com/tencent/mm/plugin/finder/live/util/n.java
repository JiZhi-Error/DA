package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.util.p;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.a.j;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\u0004H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\u0004H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\u0012\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\u0004H\u0016J\n\u0010%\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\u0004H\u0016J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u000eH\u0016J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\tH\u0016J\b\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/GiftQueueImpl;", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "()V", "TAG", "", "incrementMsgId", "Ljava/util/concurrent/atomic/AtomicLong;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "lock", "", "observerSet", "", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftAddingObserver;", "addAll", "", "collection", "", "clear", "", "getNextGiftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "hasNext", "notifyGiftAdding", "giftType", "offer", "giftShowInfo", "peek", "peekByComboId", "comboId", "peekByTargetUserName", "targetUserName", "peekNonPrecious", "poll", "pollByComboId", "pollByTargetUserName", "pollNonPrecious", "registerObserver", "observer", "remove", "size", "", "unregisterObserver", "Companion", "plugin-finder_release"})
public final class n implements p {
    private static final int MAX_SIZE = c.dwa().value().intValue();
    private static final int uwQ = c.dwb().value().intValue();
    public static final a uwR = new a((byte) 0);
    private final String TAG = ("Finder.GiftQueueImpl@" + hashCode());
    private LinkedList<p.b> gCs = new LinkedList<>();
    private final Object lock = new byte[0];
    private final Set<p.a> uwO = new CopyOnWriteArraySet();
    private AtomicLong uwP = new AtomicLong(1);

    public n() {
        AppMethodBeat.i(247279);
        Log.i(this.TAG, "MAX_SIZE:" + MAX_SIZE + ",COMBOID_LIVE_TIME:" + uwQ);
        AppMethodBeat.o(247279);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/GiftQueueImpl$Companion;", "", "()V", "COMBOID_LIVE_TIME", "", "getCOMBOID_LIVE_TIME", "()I", "MAX_SIZE", "getMAX_SIZE", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(247280);
        c cVar = c.vCb;
        c cVar2 = c.vCb;
        AppMethodBeat.o(247280);
    }

    @Override // com.tencent.mm.plugin.finder.live.util.p
    public final boolean hasNext() {
        boolean z;
        AppMethodBeat.i(247266);
        synchronized (this.lock) {
            try {
                z = !this.gCs.isEmpty();
            } finally {
                AppMethodBeat.o(247266);
            }
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.finder.live.util.p
    public final p.c dii() {
        p.c cVar;
        AppMethodBeat.i(247267);
        synchronized (this.lock) {
            try {
                p.b peekFirst = this.gCs.peekFirst();
                if (peekFirst != null) {
                    cVar = peekFirst.uwS;
                } else {
                    cVar = null;
                }
            } finally {
                AppMethodBeat.o(247267);
            }
        }
        return cVar;
    }

    @Override // com.tencent.mm.plugin.finder.live.util.p
    public final p.b dik() {
        p.b pollFirst;
        AppMethodBeat.i(247269);
        synchronized (this.lock) {
            try {
                pollFirst = this.gCs.pollFirst();
            } finally {
                AppMethodBeat.o(247269);
            }
        }
        return pollFirst;
    }

    @Override // com.tencent.mm.plugin.finder.live.util.p
    public final p.b bxJ(String str) {
        T t;
        T t2;
        boolean z;
        AppMethodBeat.i(260758);
        kotlin.g.b.p.h(str, "targetUserName");
        synchronized (this.lock) {
            try {
                Iterator<T> it = this.gCs.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    T t3 = next;
                    if (t3.uwW || !str.equals(t3.UMe)) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        t = next;
                        break;
                    }
                }
                t2 = t;
            } finally {
                AppMethodBeat.o(260758);
            }
        }
        return t2;
    }

    @Override // com.tencent.mm.plugin.finder.live.util.p
    public final p.b bxK(String str) {
        T t;
        T t2;
        AppMethodBeat.i(260759);
        kotlin.g.b.p.h(str, "targetUserName");
        synchronized (this.lock) {
            try {
                Iterator<T> it = this.gCs.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    if (str.equals(next.UMe)) {
                        t = next;
                        break;
                    }
                }
                t2 = t;
            } finally {
                AppMethodBeat.o(260759);
            }
        }
        return t2;
    }

    private p.b bxL(String str) {
        T t;
        T t2;
        AppMethodBeat.i(260760);
        kotlin.g.b.p.h(str, "comboId");
        synchronized (this.lock) {
            try {
                Iterator<T> it = this.gCs.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    if (str.equals(next.upR)) {
                        t = next;
                        break;
                    }
                }
                t2 = t;
            } finally {
                AppMethodBeat.o(260760);
            }
        }
        return t2;
    }

    @Override // com.tencent.mm.plugin.finder.live.util.p
    public final p.b bxM(String str) {
        p.b bxL;
        AppMethodBeat.i(260761);
        kotlin.g.b.p.h(str, "comboId");
        synchronized (this.lock) {
            try {
                bxL = bxL(str);
                if (bxL != null) {
                    this.gCs.remove(bxL);
                }
            } finally {
                AppMethodBeat.o(260761);
            }
        }
        return bxL;
    }

    public final boolean a(p.b bVar) {
        AppMethodBeat.i(247271);
        if (bVar == null) {
            AppMethodBeat.o(247271);
            return false;
        }
        synchronized (this.lock) {
            try {
                Log.i(this.TAG, "offer: incrementMsgId = " + this.uwP + ", size = " + this.gCs.size());
                if (this.gCs.size() >= MAX_SIZE && MAX_SIZE > 0) {
                    Log.i(this.TAG, "offer: oversize, drop:" + j.N(this.gCs, (this.gCs.size() - MAX_SIZE) + 1));
                    this.gCs = new LinkedList<>(j.b(this.gCs, MAX_SIZE - 1));
                }
                bVar.uwT = this.uwP.getAndIncrement();
                this.gCs.offerLast(bVar);
                j.sort(this.gCs);
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(247271);
                throw th;
            }
        }
        p.c dii = dii();
        if (dii != null) {
            b(dii);
        }
        AppMethodBeat.o(247271);
        return true;
    }

    public final boolean addAll(Collection<p.b> collection) {
        List<p.b> p;
        AppMethodBeat.i(247272);
        if (collection == null || collection.isEmpty()) {
            AppMethodBeat.o(247272);
            return false;
        }
        synchronized (this.lock) {
            try {
                Log.i(this.TAG, "addAll: incrementMsgId = " + this.uwP + ", size = " + this.gCs.size() + ", observerSetSize:" + this.uwO.size());
                if (collection.size() > MAX_SIZE) {
                    Log.i(this.TAG, "addAll: oversize, drop origin collection:" + j.N(j.p(collection), collection.size() - MAX_SIZE));
                    p = j.b(collection, MAX_SIZE);
                } else {
                    p = j.p(collection);
                }
                if (this.gCs.size() + p.size() > MAX_SIZE) {
                    Log.i(this.TAG, "offer: oversize, drop list:" + j.N(this.gCs, (this.gCs.size() + p.size()) - MAX_SIZE));
                    this.gCs = new LinkedList<>(j.M(this.gCs, (this.gCs.size() + p.size()) - MAX_SIZE));
                }
                for (p.b bVar : p) {
                    bVar.uwT = this.uwP.getAndIncrement();
                }
                this.gCs.addAll(p);
                j.sort(this.gCs);
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(247272);
            }
        }
        p.c dii = dii();
        if (dii != null) {
            b(dii);
        }
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.live.util.p
    public final boolean b(p.b bVar) {
        boolean remove;
        AppMethodBeat.i(247273);
        kotlin.g.b.p.h(bVar, "giftShowInfo");
        synchronized (this.lock) {
            try {
                remove = this.gCs.remove(bVar);
            } finally {
                AppMethodBeat.o(247273);
            }
        }
        return remove;
    }

    public final void clear() {
        AppMethodBeat.i(247274);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("clear observer ");
        y yVar = y.vXH;
        Log.i(str, sb.append(y.dCM() ? Util.getStack().toString() : "").toString());
        synchronized (this.lock) {
            try {
                this.gCs.clear();
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(247274);
                throw th;
            }
        }
        this.uwO.clear();
        AppMethodBeat.o(247274);
    }

    @Override // com.tencent.mm.plugin.finder.live.util.p
    public final int size() {
        int size;
        AppMethodBeat.i(247275);
        synchronized (this.lock) {
            try {
                size = this.gCs.size();
            } finally {
                AppMethodBeat.o(247275);
            }
        }
        return size;
    }

    @Override // com.tencent.mm.plugin.finder.live.util.p
    public final void a(p.a aVar) {
        AppMethodBeat.i(247276);
        kotlin.g.b.p.h(aVar, "observer");
        String str = this.TAG;
        StringBuilder append = new StringBuilder("registerObserver ").append(aVar).append("  ").append(this.uwO.size()).append(' ');
        y yVar = y.vXH;
        Log.i(str, append.append(y.dCN()).toString());
        this.uwO.add(aVar);
        AppMethodBeat.o(247276);
    }

    @Override // com.tencent.mm.plugin.finder.live.util.p
    public final void b(p.a aVar) {
        AppMethodBeat.i(247277);
        kotlin.g.b.p.h(aVar, "observer");
        String str = this.TAG;
        StringBuilder append = new StringBuilder("unregisterObserver ").append(aVar).append("  ").append(this.uwO.size()).append(' ');
        y yVar = y.vXH;
        Log.i(str, append.append(y.dCN()).toString());
        this.uwO.remove(aVar);
        AppMethodBeat.o(247277);
    }

    private final void b(p.c cVar) {
        AppMethodBeat.i(247278);
        Iterator<T> it = this.uwO.iterator();
        while (it.hasNext()) {
            it.next().a(cVar);
        }
        AppMethodBeat.o(247278);
    }
}
