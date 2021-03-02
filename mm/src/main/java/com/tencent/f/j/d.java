package com.tencent.f.j;

import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d implements Handler.Callback {
    Handler RVa = com.tencent.f.e.d.a("SerialQueueLeader", this);
    final AbstractC0139d RVb;
    HashSet<e> RVc = new HashSet<>();
    LinkedList<e> RVd = new LinkedList<>();
    final LinkedList<c> RVe = new LinkedList<>();
    c[] RVf;
    AtomicBoolean isQuit = new AtomicBoolean(false);
    boolean isRunning = false;

    public interface a {
        boolean d(e eVar);
    }

    public interface b {
        boolean c(e eVar);
    }

    public interface c extends MessageQueue.IdleHandler {
    }

    /* renamed from: com.tencent.f.j.d$d  reason: collision with other inner class name */
    public interface AbstractC0139d {
        void a(e eVar);
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(183465);
        if (message.what == 1) {
            synchronized (this) {
                try {
                    if (this.RVc.remove(message.obj)) {
                        a(0, (e) message.obj);
                        return true;
                    }
                } finally {
                    AppMethodBeat.o(183465);
                }
            }
        }
        AppMethodBeat.o(183465);
        return false;
    }

    d(AbstractC0139d dVar) {
        AppMethodBeat.i(183466);
        this.RVb = dVar;
        AppMethodBeat.o(183466);
    }

    public final void a(long j2, e eVar) {
        AppMethodBeat.i(183467);
        synchronized (this) {
            try {
                if (!this.isQuit.get()) {
                    if (eVar == null) {
                        AppMethodBeat.o(183467);
                    } else if (eVar.isCancelled()) {
                        AppMethodBeat.o(183467);
                    } else if (j2 > 0) {
                        Message obtainMessage = this.RVa.obtainMessage();
                        obtainMessage.obj = eVar;
                        obtainMessage.what = 1;
                        synchronized (this) {
                            try {
                                this.RVc.add(eVar);
                                this.RVa.sendMessageAtTime(obtainMessage, SystemClock.uptimeMillis() + j2);
                            } catch (Throwable th) {
                                AppMethodBeat.o(183467);
                                throw th;
                            }
                        }
                        AppMethodBeat.o(183467);
                    } else {
                        boolean isEmpty = this.RVd.isEmpty();
                        if (!isEmpty || this.isRunning) {
                            if (isEmpty || j2 == Long.MIN_VALUE) {
                                this.RVd.addFirst(eVar);
                            } else {
                                this.RVd.addLast(eVar);
                            }
                            AppMethodBeat.o(183467);
                            return;
                        }
                        this.isRunning = true;
                        ((AbstractC0139d) Objects.requireNonNull(this.RVb)).a(eVar);
                        AppMethodBeat.o(183467);
                    }
                }
            } finally {
                AppMethodBeat.o(183467);
            }
        }
    }

    public final int size() {
        AppMethodBeat.i(183468);
        int size = this.RVd.size() + this.RVc.size();
        AppMethodBeat.o(183468);
        return size;
    }

    public final boolean isRunning() {
        return this.isRunning;
    }

    public final void clear() {
        AppMethodBeat.i(183469);
        synchronized (this) {
            try {
                this.RVa.removeMessages(1);
                Iterator<e> it = this.RVd.iterator();
                while (it.hasNext()) {
                    e next = it.next();
                    if (!next.isCancelled()) {
                        next.cancel(false);
                    }
                }
                this.RVd.clear();
                Iterator<e> it2 = this.RVc.iterator();
                while (it2.hasNext()) {
                    e next2 = it2.next();
                    if (!next2.isCancelled()) {
                        next2.cancel(false);
                    }
                }
                this.RVc.clear();
            } finally {
                AppMethodBeat.o(183469);
            }
        }
    }

    public final List<String> hmI() {
        AppMethodBeat.i(183470);
        LinkedList linkedList = new LinkedList();
        Iterator<e> it = hmJ().iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().getKey());
        }
        AppMethodBeat.o(183470);
        return linkedList;
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar) {
        AppMethodBeat.i(183471);
        Objects.requireNonNull(bVar);
        synchronized (this) {
            try {
                Iterator<e> it = this.RVc.iterator();
                while (it.hasNext()) {
                    e next = it.next();
                    if (bVar.c(next)) {
                        this.RVa.removeMessages(1, next);
                        if (!next.isCancelled()) {
                            next.cancel(false);
                        }
                        it.remove();
                    }
                }
                Iterator<e> it2 = this.RVd.iterator();
                while (it2.hasNext()) {
                    e next2 = it2.next();
                    if (bVar.c(next2)) {
                        if (!next2.isCancelled()) {
                            next2.cancel(false);
                        }
                        it2.remove();
                    }
                }
            } finally {
                AppMethodBeat.o(183471);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(a aVar) {
        AppMethodBeat.i(183472);
        synchronized (this) {
            try {
                Iterator<e> it = this.RVc.iterator();
                while (it.hasNext()) {
                    if (aVar.d(it.next())) {
                        return true;
                    }
                }
                Iterator<e> it2 = this.RVd.iterator();
                while (it2.hasNext()) {
                    if (aVar.d(it2.next())) {
                        AppMethodBeat.o(183472);
                        return true;
                    }
                }
                AppMethodBeat.o(183472);
                return false;
            } finally {
                AppMethodBeat.o(183472);
            }
        }
    }

    public final boolean quit() {
        AppMethodBeat.i(183473);
        if (this.isQuit.compareAndSet(false, true)) {
            synchronized (this) {
                try {
                    clear();
                    this.isRunning = false;
                } finally {
                    AppMethodBeat.o(183473);
                }
            }
            return true;
        }
        AppMethodBeat.o(183473);
        return false;
    }

    private LinkedList<e> hmJ() {
        LinkedList<e> linkedList;
        AppMethodBeat.i(183474);
        synchronized (this) {
            try {
                linkedList = new LinkedList<>(this.RVd);
                linkedList.addAll(this.RVc);
            } finally {
                AppMethodBeat.o(183474);
            }
        }
        return linkedList;
    }
}
