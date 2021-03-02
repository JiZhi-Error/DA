package com.tencent.matrix.a.b.a;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.a.b.a.g;
import com.tencent.matrix.a.c.e;
import com.tencent.matrix.g.d;
import com.tencent.mm.loader.BuildConfig;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e extends a {

    public interface a {
        void ce(int i2, int i3);
    }

    @Override // com.tencent.matrix.a.b.a.g
    public final int Sg() {
        return Integer.MAX_VALUE;
    }

    public static class c {
        long cTi;
        public long cTj;
        List<a> cTk = Collections.emptyList();
        String name;
        int pid;
        long time;

        c() {
        }

        public final String toString() {
            return "process:" + this.name + "(" + this.pid + ") thread size:" + this.cTk.size();
        }

        public static class a {
            public long cTj;
            public String name;
            public int pid;
            public int tid;

            static List<a> in(int i2) {
                File file = new File("/proc/" + i2 + "/task/");
                if (!file.isDirectory()) {
                    return Collections.emptyList();
                }
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return Collections.emptyList();
                }
                ArrayList arrayList = new ArrayList(listFiles.length);
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        try {
                            a aVar = new a();
                            aVar.pid = i2;
                            aVar.tid = Integer.parseInt(file2.getName());
                            arrayList.add(aVar);
                        } catch (Exception e2) {
                        }
                    }
                }
                return arrayList;
            }

            private a() {
            }

            public final String toString() {
                return "thread:" + this.name + "(" + this.tid + ") " + this.cTj;
            }
        }
    }

    public static class b extends g.a<b> {
        public g.a.c.b<Long> cTd;
        public g.a.c.C0216c<a> cTe;
        public String name;
        public int pid;

        /* synthetic */ b(byte b2) {
            this();
        }

        public static b a(c cVar, boolean z, a aVar) {
            ArrayList arrayList;
            long j2;
            b bVar = new b();
            bVar.pid = cVar.pid;
            bVar.name = cVar.name;
            long j3 = 0;
            if (z) {
                try {
                    e.a io2 = com.tencent.matrix.a.c.e.io(cVar.pid);
                    if (io2 != null) {
                        cVar.name = io2.cUd;
                        cVar.cTj = io2.Sr();
                        j3 = cVar.cTj;
                    } else {
                        throw new IOException("parse fail: " + com.tencent.matrix.a.c.c.eu("/proc/" + cVar.pid + "/stat"));
                    }
                } catch (IOException e2) {
                    com.tencent.matrix.g.c.printErrStackTrace("Matrix.battery.JiffiesMonitorFeature", e2, "parseProcJiffies fail", new Object[0]);
                    bVar.cTq = false;
                    if (aVar != null) {
                        aVar.ce(cVar.pid, 0);
                    }
                    z = false;
                }
            }
            List emptyList = Collections.emptyList();
            if (cVar.cTk.size() > 0) {
                ArrayList arrayList2 = new ArrayList(cVar.cTk.size());
                j2 = j3;
                for (c.a aVar2 : cVar.cTk) {
                    a a2 = a.a(aVar2);
                    if (a2 != null) {
                        arrayList2.add(a2);
                        if (!z) {
                            j2 = ((Long) a2.cTz).longValue() + j2;
                        }
                    } else {
                        bVar.cTq = false;
                        if (aVar != null) {
                            aVar.ce(aVar2.pid, aVar2.tid);
                        }
                    }
                }
                arrayList = arrayList2;
            } else {
                arrayList = emptyList;
                j2 = j3;
            }
            bVar.cTd = g.a.c.b.b(Long.valueOf(j2));
            bVar.cTe = g.a.c.C0216c.J(arrayList);
            return bVar;
        }

        private b() {
        }

        public static class a extends g.a.c.b<Long> {
            public boolean cTh;
            public String name;
            public int tid;

            /* Return type fixed from 'java.lang.Number' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Number] */
            @Override // com.tencent.matrix.a.b.a.g.a.c.b
            public final /* synthetic */ Long a(Long l) {
                return Long.valueOf(((Long) this.cTz).longValue() - l.longValue());
            }

            public a(Long l) {
                super(l);
            }

            public static a a(c.a aVar) {
                try {
                    e.a cf = com.tencent.matrix.a.c.e.cf(aVar.pid, aVar.tid);
                    if (cf != null) {
                        aVar.name = cf.cUd;
                        aVar.cTj = cf.Sr();
                        a aVar2 = new a(Long.valueOf(aVar.cTj));
                        aVar2.name = aVar.name;
                        aVar2.tid = aVar.tid;
                        aVar2.cTh = true;
                        return aVar2;
                    }
                    throw new IOException("parse fail: " + com.tencent.matrix.a.c.c.eu("/proc/" + aVar.pid + "/task/" + aVar.tid + "/stat"));
                } catch (IOException e2) {
                    com.tencent.matrix.g.c.printErrStackTrace("Matrix.battery.JiffiesMonitorFeature", e2, "parseThreadJiffies fail", new Object[0]);
                    return null;
                }
            }
        }
    }

    public final b Sm() {
        c cVar = new c();
        cVar.pid = Process.myPid();
        cVar.name = com.tencent.matrix.b.isInstalled() ? d.getProcessName(com.tencent.matrix.b.RG().application) : BuildConfig.KINDA_DEFAULT;
        cVar.cTk = c.a.in(cVar.pid);
        cVar.cTi = SystemClock.uptimeMillis();
        cVar.time = System.currentTimeMillis();
        return b.a(cVar, this.cSq.cSe.cRW, this.cSq);
    }
}
