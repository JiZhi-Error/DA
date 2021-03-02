package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b {
    public Runnable Soo;
    public Handler mMainHandler = new Handler(Looper.getMainLooper());
    WeakReference<com.tencent.toybrick.b.b> vjo;

    public b(com.tencent.toybrick.b.b bVar) {
        AppMethodBeat.i(159970);
        this.vjo = new WeakReference<>(bVar);
        AppMethodBeat.o(159970);
    }

    /* renamed from: com.tencent.toybrick.e.b$b  reason: collision with other inner class name */
    class RunnableC2222b implements Runnable {
        boolean Soi;
        private LinkedList<g> Sot;
        private ArrayList<g> Sou;

        public RunnableC2222b(boolean z, LinkedList<g> linkedList, ArrayList<g> arrayList) {
            AppMethodBeat.i(159967);
            this.Soi = z;
            this.Sot = new LinkedList<>(linkedList);
            this.Sou = new ArrayList<>(arrayList);
            AppMethodBeat.o(159967);
        }

        public final void run() {
            AppMethodBeat.i(159968);
            ArrayList<g> arrayList = new ArrayList<>();
            HashMap<g, Integer> hashMap = new HashMap<>();
            a(arrayList, hashMap);
            c.b a2 = c.a(new com.tencent.toybrick.a.a(this.Sou, arrayList), true);
            final a aVar = new a(b.this, (byte) 0);
            aVar.Sos = hashMap;
            aVar.Soq = a2;
            aVar.Sor = arrayList;
            b.this.mMainHandler.post(new Runnable() {
                /* class com.tencent.toybrick.e.b.RunnableC2222b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(159966);
                    com.tencent.toybrick.b.b bVar = b.this.vjo.get();
                    if (bVar != null) {
                        bVar.Sng = aVar.Sor;
                        bVar.Sni = aVar.Sos;
                        aVar.Soq.a(bVar);
                    }
                    AppMethodBeat.o(159966);
                }
            });
            AppMethodBeat.o(159968);
        }

        private void a(List<g> list, HashMap<g, Integer> hashMap) {
            AppMethodBeat.i(159969);
            list.clear();
            Iterator<g> it = this.Sot.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (next.isVisible) {
                    list.add(next);
                }
                hashMap.put(next, Integer.valueOf(hashMap.size()));
            }
            Collections.sort(list);
            if (this.Soi) {
                g gVar = null;
                Iterator<g> it2 = list.iterator();
                int i2 = 0;
                while (it2.hasNext()) {
                    gVar = it2.next();
                    if (gVar.hpJ() == g.b.HINT) {
                        gVar.SnX = false;
                        if (gVar != null) {
                            gVar.SnX = false;
                        }
                    }
                    if (i2 == list.size() - 1) {
                        gVar.SnX = false;
                    }
                    i2++;
                }
            }
            AppMethodBeat.o(159969);
        }
    }

    class a {
        public c.b Soq;
        public ArrayList<g> Sor;
        public HashMap<g, Integer> Sos;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }
    }
}
