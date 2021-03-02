package com.tencent.matrix.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Printer;
import com.tencent.matrix.b.c;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class b {
    public static boolean cWq = false;
    private static volatile HandlerThread deU;
    private static volatile Handler deV;
    private static volatile Handler deW = new Handler(Looper.getMainLooper());
    private static HashSet<HandlerThread> deX = new HashSet<>();

    public static Handler TO() {
        return deW;
    }

    public static HandlerThread TP() {
        HandlerThread handlerThread;
        synchronized (b.class) {
            if (deU == null) {
                HandlerThread handlerThread2 = new HandlerThread("default_matrix_thread");
                deU = handlerThread2;
                handlerThread2.start();
                deV = new Handler(deU.getLooper());
                deU.getLooper().setMessageLogging(cWq ? new a() : null);
                c.w("Matrix.HandlerThread", "create default handler thread, we should use these thread normal, isDebug:%s", Boolean.valueOf(cWq));
            }
            handlerThread = deU;
        }
        return handlerThread;
    }

    public static Handler TQ() {
        if (deV == null) {
            TP();
        }
        return deV;
    }

    public static HandlerThread eS(String str) {
        Iterator<HandlerThread> it = deX.iterator();
        while (it.hasNext()) {
            if (!it.next().isAlive()) {
                it.remove();
                c.w("Matrix.HandlerThread", "warning: remove dead handler thread with name %s", str);
            }
        }
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.setPriority(3);
        handlerThread.start();
        deX.add(handlerThread);
        c.w("Matrix.HandlerThread", "warning: create new handler thread with name %s, alive thread size:%d", str, Integer.valueOf(deX.size()));
        return handlerThread;
    }

    /* access modifiers changed from: package-private */
    public static final class a implements Printer, c {
        private boolean cQp;
        private ConcurrentHashMap<String, C0224a> deY = new ConcurrentHashMap<>();

        a() {
            com.tencent.matrix.a.INSTANCE.a(this);
            this.cQp = com.tencent.matrix.a.INSTANCE.cPB;
        }

        public final void println(String str) {
            if (!this.cQp && str.charAt(0) == '>') {
                int indexOf = str.indexOf("} ");
                int indexOf2 = str.indexOf("@", indexOf);
                if (indexOf >= 0 && indexOf2 >= 0) {
                    String substring = str.substring(indexOf, indexOf2);
                    C0224a aVar = this.deY.get(substring);
                    if (aVar == null) {
                        aVar = new C0224a();
                        aVar.key = substring;
                        this.deY.put(substring, aVar);
                    }
                    aVar.count++;
                }
            }
        }

        @Override // com.tencent.matrix.b.c
        public final void onForeground(boolean z) {
            this.cQp = z;
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                LinkedList linkedList = new LinkedList();
                for (C0224a aVar : this.deY.values()) {
                    if (aVar.count > 1) {
                        linkedList.add(aVar);
                    }
                }
                Collections.sort(linkedList, new Comparator<C0224a>() {
                    /* class com.tencent.matrix.g.b.a.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* bridge */ /* synthetic */ int compare(C0224a aVar, C0224a aVar2) {
                        return aVar2.count - aVar.count;
                    }
                });
                this.deY.clear();
                if (!linkedList.isEmpty()) {
                    c.i("Matrix.HandlerThread", "matrix default thread has exec in background! %s cost:%s", linkedList, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return;
                }
                return;
            }
            this.deY.clear();
        }

        /* renamed from: com.tencent.matrix.g.b$a$a  reason: collision with other inner class name */
        class C0224a {
            int count;
            String key;

            C0224a() {
            }

            public final String toString() {
                return this.key + ":" + this.count;
            }
        }
    }
}
