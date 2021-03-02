package com.tencent.mm.svg;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* access modifiers changed from: package-private */
public final class a<T> {
    private HashMap<Looper, LinkedList<T>> Oui = new HashMap<>();
    private Queue<T> Ouj = new ArrayDeque();

    a() {
        AppMethodBeat.i(148680);
        AppMethodBeat.o(148680);
    }

    /* access modifiers changed from: protected */
    public final synchronized T gFM() {
        T t;
        AppMethodBeat.i(148681);
        t = null;
        if (this.Ouj.size() != 0) {
            t = this.Ouj.poll();
        }
        AppMethodBeat.o(148681);
        return t;
    }

    /* access modifiers changed from: protected */
    public final synchronized void a(Looper looper, T t) {
        LinkedList<T> linkedList;
        AppMethodBeat.i(148682);
        if (!this.Oui.containsKey(looper)) {
            linkedList = new LinkedList<>();
            this.Oui.put(looper, linkedList);
        } else {
            linkedList = this.Oui.get(looper);
        }
        if (linkedList.size() < 20) {
            linkedList.add(t);
        }
        AppMethodBeat.o(148682);
    }

    /* access modifiers changed from: protected */
    public final synchronized void g(Looper looper) {
        AppMethodBeat.i(148683);
        if (this.Oui.containsKey(looper)) {
            LinkedList<T> remove = this.Oui.remove(looper);
            if (this.Ouj.size() < 40) {
                this.Ouj.addAll(remove);
            }
        }
        AppMethodBeat.o(148683);
    }
}
