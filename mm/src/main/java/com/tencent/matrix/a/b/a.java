package com.tencent.matrix.a.b;

import android.content.ComponentName;
import android.os.HandlerThread;
import android.os.Process;
import android.util.LongSparseArray;
import com.tencent.matrix.a.b.a.b;
import com.tencent.matrix.a.b.a.c;
import com.tencent.matrix.a.b.a.d;
import com.tencent.matrix.a.b.a.e;
import com.tencent.matrix.a.b.a.f;
import com.tencent.matrix.a.b.a.g;
import com.tencent.matrix.a.b.a.i;
import com.tencent.matrix.a.b.c;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public interface a extends c.a, e.a, f.a, i.b, c.AbstractC0217c {

    /* renamed from: com.tencent.matrix.a.b.a$a  reason: collision with other inner class name */
    public static class C0204a implements a {
        i.c cRA = null;
        d.b cRB = null;
        d.a cRC = null;
        b.c cRD = null;
        public c cRw;
        private final C0205a cRx = new C0205a();
        private final LongSparseArray<List<f.c>> cRy = new LongSparseArray<>();
        private e.b cRz = null;

        @Override // com.tencent.matrix.a.b.c.AbstractC0217c
        public void Sa() {
            e eVar = (e) this.cRw.aa(e.class);
            if (eVar != null) {
                this.cRz = eVar.Sm();
            }
            i iVar = (i) this.cRw.aa(i.class);
            if (iVar != null) {
                this.cRA = iVar.cTH.So();
            }
            if (((d) this.cRw.aa(d.class)) != null) {
                this.cRB = d.Sl();
                this.cRC = d.aX(c.getContext());
            }
            b bVar = (b) this.cRw.aa(b.class);
            if (bVar != null) {
                this.cRD = bVar.cSr.Sh();
            }
        }

        @Override // com.tencent.matrix.a.b.c.AbstractC0217c
        public void cz(boolean z) {
            String str;
            C0205a aVar = this.cRx;
            aVar.sb.delete(0, aVar.sb.length());
            this.cRx.sb.append("****************************************** PowerTest *****************************************\n");
            e eVar = (e) this.cRw.aa(e.class);
            if (!(eVar == null || this.cRz == null)) {
                e.b Sm = eVar.Sm();
                e.b.AnonymousClass1 r2 = new g.a.AbstractC0209a<e.b>(this.cRz, Sm) {
                    /* class com.tencent.matrix.a.b.a.e.b.AnonymousClass1 */

                    /* Return type fixed from 'com.tencent.matrix.a.b.a.g$a' to match base method */
                    /* access modifiers changed from: protected */
                    @Override // com.tencent.matrix.a.b.a.g.a.AbstractC0209a
                    public final /* synthetic */ b Si() {
                        boolean z;
                        b bVar = new b((byte) 0);
                        bVar.pid = ((b) this.cTs).pid;
                        bVar.name = ((b) this.cTs).name;
                        bVar.cTd = g.a.b.C0211b.a(((b) this.cTr).cTd, ((b) this.cTs).cTd);
                        bVar.cTe = g.a.c.C0216c.Sn();
                        if (((b) this.cTs).cTe.list.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            for (ITEM item : ((b) this.cTs).cTe.list) {
                                long longValue = ((Long) item.cTz).longValue();
                                Iterator<ITEM> it = ((b) this.cTr).cTe.list.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z = true;
                                        break;
                                    }
                                    a aVar = (a) it.next();
                                    if (aVar.name.equals(item.name) && aVar.tid == item.tid) {
                                        longValue = ((Long) g.a.b.C0211b.a(aVar, item).cTz).longValue();
                                        z = false;
                                        break;
                                    }
                                }
                                if (longValue > 0) {
                                    a aVar2 = new a(Long.valueOf(longValue));
                                    aVar2.tid = item.tid;
                                    aVar2.name = item.name;
                                    aVar2.cTh = z;
                                    arrayList.add(aVar2);
                                }
                            }
                            if (arrayList.size() > 0) {
                                Collections.sort(arrayList, new Comparator<a>() {
                                    /* class com.tencent.matrix.a.b.a.e.b.AnonymousClass1.AnonymousClass1 */

                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                                    @Override // java.util.Comparator
                                    public final /* synthetic */ int compare(a aVar, a aVar2) {
                                        long longValue = ((Long) aVar.cTz).longValue() - ((Long) aVar2.cTz).longValue();
                                        if (longValue == 0) {
                                            return 0;
                                        }
                                        if (longValue > 0) {
                                            return -1;
                                        }
                                        return 1;
                                    }
                                });
                                bVar.cTe = g.a.c.C0216c.J(arrayList);
                            }
                        }
                        return bVar;
                    }
                };
                a(r2);
                long longValue = ((Long) ((e.b) r2.cTt).cTd.cTz).longValue() / Math.max(1L, r2.cTu / Util.MILLSECONDS_OF_MINUTE);
                this.cRx.aO("| ").aO("pid=").aO(Integer.valueOf(Process.myPid())).Sc().Sc().aO("fg=").aO(Boolean.valueOf(z)).Sc().Sc().aO("during(min)=").aO(Long.valueOf(r2.cTu / Util.MILLSECONDS_OF_MINUTE)).Sc().Sc().aO("diff(jiffies)=").aO(((e.b) r2.cTt).cTd.cTz).Sc().Sc().aO("avg(jiffies/min)=").aO(Long.valueOf(longValue)).sb.append("\n");
                this.cRx.el("jiffies(" + ((e.b) r2.cTt).cTe.list.size() + ")");
                for (ITEM item : ((e.b) r2.cTt).cTe.list.subList(0, Math.min(((e.b) r2.cTt).cTe.list.size(), 8))) {
                    this.cRx.aO("|   -> (").aO(item.cTh ? "+" : "~").aO(")").aO(item.name).aO("(").aO(Integer.valueOf(item.tid)).aO(")\t").aO(item.cTz).aO("\tjiffies").aO("\n");
                    List<f.c> list = this.cRy.get((long) item.tid);
                    if (list != null && !list.isEmpty()) {
                        for (f.c cVar : list.subList(0, Math.min(3, list.size()))) {
                            this.cRx.aO("|\t\t").aO(cVar).aO("\n");
                        }
                    }
                }
                this.cRx.aO("|\t\t......\n");
                if (longValue > 1000 || !r2.isValid()) {
                    C0205a aO = this.cRx.aO("|  ").aO(longValue > 1000 ? " #overHeat" : "");
                    if (!r2.isValid()) {
                        str = " #invalid";
                    } else {
                        str = "";
                    }
                    aO.aO(str).aO("\n");
                }
            }
            Sb();
            this.cRx.sb.append("**********************************************************************************************");
            try {
                com.tencent.matrix.g.c.i("Matrix.battery.BatteryPrinter", "\t\n" + this.cRx.sb.toString(), new Object[0]);
            } catch (Throwable th) {
                com.tencent.matrix.g.c.printErrStackTrace("Matrix.battery.BatteryPrinter", th, "log format error", new Object[0]);
            }
            synchronized (this.cRy) {
                this.cRy.clear();
            }
        }

        @Override // com.tencent.matrix.a.b.a.f.a
        public final void a(Thread thread, List<f.c> list) {
            if (thread instanceof HandlerThread) {
                synchronized (this.cRy) {
                    this.cRy.put((long) ((HandlerThread) thread).getThreadId(), list);
                }
            }
        }

        @Override // com.tencent.matrix.a.b.a.i.b
        public void a(int i2, i.d.b bVar) {
        }

        @Override // com.tencent.matrix.a.b.a.i.b
        public void a(i.d.b bVar, long j2) {
        }

        @Override // com.tencent.matrix.a.b.a.e.a
        public void ce(int i2, int i3) {
        }

        @Override // com.tencent.matrix.a.b.a.c.a
        public void a(boolean z, int i2, int i3, ComponentName componentName, long j2) {
        }

        /* access modifiers changed from: protected */
        public void Sb() {
            final i iVar = (i) this.cRw.aa(i.class);
            if (!(iVar == null || this.cRA == null)) {
                a("wake_lock", new android.support.v4.e.c<C0205a>() {
                    /* class com.tencent.matrix.a.b.a.C0204a.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.support.v4.e.c
                    public final /* synthetic */ void accept(C0205a aVar) {
                        C0205a aVar2 = aVar;
                        i.c So = iVar.cTH.So();
                        i.c.AnonymousClass1 r2 = new g.a.AbstractC0209a<i.c>(C0204a.this.cRA, So) {
                            /* class com.tencent.matrix.a.b.a.i.c.AnonymousClass1 */

                            /* Return type fixed from 'com.tencent.matrix.a.b.a.g$a' to match base method */
                            /* access modifiers changed from: protected */
                            @Override // com.tencent.matrix.a.b.a.g.a.AbstractC0209a
                            public final /* synthetic */ c Si() {
                                c cVar = new c();
                                cVar.cTL = g.a.b.C0211b.a(((c) this.cTr).cTL, ((c) this.cTs).cTL);
                                cVar.cTM = g.a.b.C0211b.a(((c) this.cTr).cTM, ((c) this.cTs).cTM);
                                cVar.cTN = g.a.b.c.a(((c) this.cTr).cTN, ((c) this.cTs).cTN);
                                return cVar;
                            }
                        };
                        C0204a.this.b(r2);
                        aVar2.en("during");
                        aVar2.em(r2.cTu + "(mls)\t" + (r2.cTu / Util.MILLSECONDS_OF_MINUTE) + "(min)");
                        aVar2.J("inc_lock_count", String.valueOf(((i.c) r2.cTt).cTM));
                        aVar2.J("inc_time_total", String.valueOf(((i.c) r2.cTt).cTL));
                        aVar2.en("locking");
                        for (ITEM item : ((i.c) r2.cTs).cTN.list) {
                            if (!item.value.isFinished()) {
                                aVar2.em(item.value.toString());
                            }
                        }
                    }
                });
            }
            final b bVar = (b) this.cRw.aa(b.class);
            if (!(bVar == null || this.cRD == null)) {
                a("alarm", new android.support.v4.e.c<C0205a>() {
                    /* class com.tencent.matrix.a.b.a.C0204a.AnonymousClass2 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.support.v4.e.c
                    public final /* synthetic */ void accept(C0205a aVar) {
                        C0205a aVar2 = aVar;
                        b.c Sh = bVar.cSr.Sh();
                        b.c.AnonymousClass1 r2 = new g.a.AbstractC0209a<b.c>(C0204a.this.cRD, Sh) {
                            /* class com.tencent.matrix.a.b.a.b.c.AnonymousClass1 */

                            /* Return type fixed from 'com.tencent.matrix.a.b.a.g$a' to match base method */
                            /* access modifiers changed from: protected */
                            @Override // com.tencent.matrix.a.b.a.g.a.AbstractC0209a
                            public final /* synthetic */ c Si() {
                                c cVar = new c();
                                cVar.cSz = g.a.b.C0211b.a(((c) this.cTr).cSz, ((c) this.cTs).cSz);
                                cVar.cSA = g.a.b.C0211b.a(((c) this.cTr).cSA, ((c) this.cTs).cSA);
                                cVar.cSB = g.a.b.C0211b.a(((c) this.cTr).cSB, ((c) this.cTs).cSB);
                                cVar.cSC = g.a.b.C0211b.a(((c) this.cTr).cSC, ((c) this.cTs).cSC);
                                cVar.cSD = g.a.b.c.a(((c) this.cTr).cSD, ((c) this.cTs).cSD);
                                return cVar;
                            }
                        };
                        C0204a.this.c(r2);
                        aVar2.en("during");
                        aVar2.em(r2.cTu + "(mls)\t" + (r2.cTu / Util.MILLSECONDS_OF_MINUTE) + "(min)");
                        aVar2.J("inc_alarm_count", String.valueOf(((b.c) r2.cTt).cSz.cTz));
                        aVar2.J("inc_trace_count", String.valueOf(((b.c) r2.cTt).cSA.cTz));
                        aVar2.J("inc_dupli_group", String.valueOf(((b.c) r2.cTt).cSB.cTz));
                        aVar2.J("inc_dupli_count", String.valueOf(((b.c) r2.cTt).cSC.cTz));
                    }
                });
            }
            final d dVar = (d) this.cRw.aa(d.class);
            if (dVar != null) {
                a("dev_stat", new android.support.v4.e.c<C0205a>() {
                    /* class com.tencent.matrix.a.b.a.C0204a.AnonymousClass3 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.support.v4.e.c
                    public final /* synthetic */ void accept(C0205a aVar) {
                        C0205a aVar2 = aVar;
                        if (C0204a.this.cRB != null) {
                            d.b Sl = d.Sl();
                            d.b.AnonymousClass1 r2 = new g.a.AbstractC0209a<d.b>(C0204a.this.cRB, Sl) {
                                /* class com.tencent.matrix.a.b.a.d.b.AnonymousClass1 */

                                /* Return type fixed from 'com.tencent.matrix.a.b.a.g$a' to match base method */
                                /* access modifiers changed from: protected */
                                @Override // com.tencent.matrix.a.b.a.g.a.AbstractC0209a
                                public final /* synthetic */ b Si() {
                                    b bVar = new b();
                                    bVar.cSU = g.a.b.c.a(((b) this.cTr).cSU, ((b) this.cTs).cSU);
                                    return bVar;
                                }
                            };
                            aVar2.en("during");
                            aVar2.em(r2.cTu + "(mls)\t" + (r2.cTu / Util.MILLSECONDS_OF_MINUTE) + "(min)");
                            aVar2.en("cpufreq");
                            aVar2.J("inc", Arrays.toString(((d.b) r2.cTt).cSU.list.toArray()));
                            aVar2.J("cur", Arrays.toString(((d.b) r2.cTs).cSU.list.toArray()));
                        }
                        if (C0204a.this.cRC != null) {
                            d.a aX = d.aX(com.tencent.matrix.b.RG().application);
                            d.a.AnonymousClass1 r22 = new g.a.AbstractC0209a<d.a>(C0204a.this.cRC, aX) {
                                /* class com.tencent.matrix.a.b.a.d.a.AnonymousClass1 */

                                /* Return type fixed from 'com.tencent.matrix.a.b.a.g$a' to match base method */
                                /* access modifiers changed from: protected */
                                @Override // com.tencent.matrix.a.b.a.g.a.AbstractC0209a
                                public final /* synthetic */ a Si() {
                                    a aVar = new a();
                                    aVar.cSS = g.a.b.C0211b.a(((a) this.cTr).cSS, ((a) this.cTs).cSS);
                                    return aVar;
                                }
                            };
                            C0204a.this.d(r22);
                            aVar2.en("during");
                            aVar2.em(r22.cTu + "(mls)\t" + (r22.cTu / Util.MILLSECONDS_OF_MINUTE) + "(min)");
                            aVar2.en("battery_temperature");
                            aVar2.J("inc", String.valueOf(((d.a) r22.cTt).cSS.cTz));
                            aVar2.J("cur", String.valueOf(((d.a) r22.cTs).cSS.cTz));
                        }
                    }
                });
            }
            final com.tencent.matrix.a.b.a.c cVar = (com.tencent.matrix.a.b.a.c) this.cRw.aa(com.tencent.matrix.a.b.a.c.class);
            if (cVar != null) {
                a("app_stat", new android.support.v4.e.c<C0205a>() {
                    /* class com.tencent.matrix.a.b.a.C0204a.AnonymousClass4 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.support.v4.e.c
                    public final /* synthetic */ void accept(C0205a aVar) {
                        C0205a aVar2 = aVar;
                        c.b bb = cVar.bb(0);
                        aVar2.en("uptime");
                        aVar2.em((((Long) bb.cSM.cTz).longValue() / Util.MILLSECONDS_OF_MINUTE) + "(min)");
                        aVar2.en("ratio");
                        aVar2.J("fg", String.valueOf(bb.cSN.cTz));
                        aVar2.J("bg", String.valueOf(bb.cSO.cTz));
                        aVar2.J("fgSrv", String.valueOf(bb.cSP.cTz));
                    }
                });
            }
        }

        /* access modifiers changed from: protected */
        public final void a(String str, android.support.v4.e.c<C0205a> cVar) {
            this.cRx.el(str);
            cVar.accept(this.cRx);
        }

        /* access modifiers changed from: protected */
        public void a(g.a.AbstractC0209a<e.b> aVar) {
        }

        /* access modifiers changed from: protected */
        public void b(g.a.AbstractC0209a<i.c> aVar) {
        }

        /* access modifiers changed from: protected */
        public void c(g.a.AbstractC0209a<b.c> aVar) {
        }

        /* access modifiers changed from: protected */
        public void d(g.a.AbstractC0209a<d.a> aVar) {
        }

        /* renamed from: com.tencent.matrix.a.b.a$a$a  reason: collision with other inner class name */
        public static class C0205a {
            final StringBuilder sb = new StringBuilder("\t\n");

            public final C0205a aO(Object obj) {
                this.sb.append(obj);
                return this;
            }

            public final C0205a Sc() {
                this.sb.append("\t");
                return this;
            }

            public final C0205a el(String str) {
                this.sb.append("+ --------------------------------------------------------------------------------------------\n");
                this.sb.append("| ").append(str).append(" :\n");
                return this;
            }

            public final C0205a em(String str) {
                this.sb.append("|   -> ").append(str).append("\n");
                return this;
            }

            public final C0205a J(String str, String str2) {
                this.sb.append("|   -> ").append(str).append("\t= ").append(str2).append("\n");
                return this;
            }

            public final C0205a en(String str) {
                this.sb.append("|   <").append(str).append(">\n");
                return this;
            }

            public final String toString() {
                return this.sb.toString();
            }
        }
    }
}
