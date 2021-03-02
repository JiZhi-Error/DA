package com.tencent.matrix.a.b.a;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f extends a {
    private final LongSparseArray<com.tencent.matrix.trace.core.a> cTl;

    public interface a {
        void a(Thread thread, List<c> list);
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void Sf() {
        super.Sf();
        synchronized (this.cTl) {
            for (int i2 = 0; i2 < this.cTl.size(); i2++) {
                this.cTl.valueAt(i2).onRelease();
            }
            this.cTl.clear();
        }
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void onForeground(boolean z) {
        Looper looper;
        super.onForeground(z);
        if (this.cSq.Sd()) {
            for (Thread thread : Thread.getAllStackTraces().keySet()) {
                if ((thread instanceof HandlerThread) && (looper = ((HandlerThread) thread).getLooper()) != null) {
                    if (!z) {
                        synchronized (this.cTl) {
                            if (this.cTl.get(thread.getId()) == null) {
                                this.cTl.put(thread.getId(), new com.tencent.matrix.trace.core.a(looper));
                            }
                        }
                    } else {
                        LinkedList<c> a2 = a(thread);
                        if (!a2.isEmpty()) {
                            this.cSq.a(thread, a2);
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.matrix.a.b.a.g
    public final int Sg() {
        return 0;
    }

    private LinkedList<c> a(Thread thread) {
        com.tencent.matrix.trace.core.a aVar;
        synchronized (this.cTl) {
            aVar = this.cTl.get(thread.getId());
            if (aVar != null) {
                this.cTl.remove(thread.getId());
            }
        }
        LinkedList<c> linkedList = new LinkedList<>();
        if (aVar != null) {
            Iterator<a.AbstractC0235a> it = aVar.listeners.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a.AbstractC0235a next = it.next();
                if (next instanceof b) {
                    HashMap<String, c> hashMap = ((b) next).map;
                    linkedList.addAll(hashMap.values());
                    hashMap.clear();
                    Collections.sort(linkedList, new Comparator<c>() {
                        /* class com.tencent.matrix.a.b.a.f.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                        @Override // java.util.Comparator
                        public final /* bridge */ /* synthetic */ int compare(c cVar, c cVar2) {
                            return Integer.compare(cVar2.count, cVar.count);
                        }
                    });
                    break;
                }
            }
            aVar.onRelease();
        }
        return linkedList;
    }

    /* access modifiers changed from: package-private */
    public class b extends a.AbstractC0235a {
        final /* synthetic */ f cTm;
        HashMap<String, c> map;

        @Override // com.tencent.matrix.trace.core.a.AbstractC0235a
        public final boolean isValid() {
            return !this.cTm.cSq.cSh;
        }

        @Override // com.tencent.matrix.trace.core.a.AbstractC0235a
        public final void er(String str) {
            if (!this.cTm.cSq.cSh) {
                super.er(str);
                int indexOf = str.indexOf("to ") + 3;
                int lastIndexOf = str.lastIndexOf(64);
                if (lastIndexOf < 0) {
                    lastIndexOf = str.lastIndexOf(58);
                }
                int max = Math.max(lastIndexOf - 60, indexOf);
                Thread.currentThread();
                String substring = str.substring(max);
                c cVar = this.map.get(substring);
                if (cVar == null) {
                    cVar = new c();
                    this.map.put(substring, cVar);
                }
                cVar.cTn = substring;
                if (cVar.cTo == null) {
                    cVar.cTo = new long[1000];
                }
                cVar.cTo[cVar.count % 1000] = System.currentTimeMillis();
                cVar.count++;
            }
        }
    }

    public static class c {
        String cTn;
        long[] cTo;
        int count;

        public final String toString() {
            return this.cTn + "=" + this.count;
        }

        public final int hashCode() {
            return this.cTn.hashCode();
        }

        public final boolean equals(Object obj) {
            if (this.cTn != null && (obj instanceof String)) {
                return this.cTn.equals(obj);
            }
            return false;
        }
    }
}
