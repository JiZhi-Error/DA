package com.tencent.matrix.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;
import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends com.tencent.matrix.e.b {
    private static long[] dan = new long[0];
    private static int dao = 0;
    private RunnableC0222a dal;
    private List<List<d>> dam;
    private long dap;
    private long daq;
    private long dar;
    private int das;
    private final b dat;
    private Handler handler;
    private long lastReportTime;

    public interface b {
        boolean b(e eVar);
    }

    /* access modifiers changed from: package-private */
    public interface c {
        void a(e eVar);
    }

    @Override // com.tencent.matrix.e.b
    public void start() {
        super.start();
        com.tencent.matrix.g.c.i("Matrix.ThreadMonitor", "start!", new Object[0]);
        dan = new long[6666];
        dao = 6666;
        AppMethodBeat.sMethodEnterListener = new AppMethodBeat.b() {
            /* class com.tencent.matrix.f.a.AnonymousClass1 */

            @Override // com.tencent.matrix.trace.core.AppMethodBeat.b
            public final void t(int i2, long j2) {
                if (j2 < ((long) a.dao) && a.dan[(int) j2] == 0) {
                    a.dan[(int) j2] = (((long) Process.myTid()) << 32) | ((long) i2);
                }
            }
        };
        com.tencent.matrix.g.b.TO().post(new Runnable() {
            /* class com.tencent.matrix.f.a.AnonymousClass2 */

            public final void run() {
                a.this.handler.post(a.this.dal);
            }
        });
    }

    @Override // com.tencent.matrix.e.b
    public void stop() {
        super.stop();
        com.tencent.matrix.g.c.i("Matrix.ThreadMonitor", "stop!", new Object[0]);
        this.handler.removeCallbacks(this.dal);
        AppMethodBeat.sMethodEnterListener = null;
        dan = new long[0];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.matrix.f.a$a  reason: collision with other inner class name */
    public class RunnableC0222a implements Runnable {
        final /* synthetic */ a dau;
        private final long daw;

        public final void run() {
            long j2;
            int processThreadCount = a.getProcessThreadCount();
            com.tencent.matrix.g.c.i("Matrix.ThreadMonitor", "[DumpThreadJiffiesTask] run...[%s] limit:%s", Integer.valueOf(processThreadCount), Integer.valueOf(this.dau.das));
            if (this.dau.das < processThreadCount) {
                final LongSparseArray a2 = a.a(this.dau.dat);
                List<e> a3 = a.a(new c() {
                    /* class com.tencent.matrix.f.a.RunnableC0222a.AnonymousClass1 */

                    @Override // com.tencent.matrix.f.a.c
                    public final void a(e eVar) {
                        e eVar2 = (e) a2.get(eVar.tid);
                        if (eVar2 != null) {
                            if (eVar.tid == RunnableC0222a.this.daw) {
                                eVar.name = "main";
                            } else {
                                eVar.name = eVar2.name.replaceAll("-?[0-9]\\d*", "?") + "J";
                            }
                            eVar.daz = eVar2.daz;
                            eVar.day = eVar2.day;
                            eVar.daA = eVar2.daA;
                            eVar.daB = true;
                            return;
                        }
                        eVar.name = eVar.name.replaceAll("-?[0-9]\\d*", "?");
                    }
                }, new b() {
                    /* class com.tencent.matrix.f.a.RunnableC0222a.AnonymousClass2 */

                    @Override // com.tencent.matrix.f.a.b
                    public final boolean b(e eVar) {
                        return RunnableC0222a.this.dau.dat.b(eVar);
                    }
                });
                HashMap hashMap = new HashMap();
                for (e eVar : a3) {
                    d dVar = (d) hashMap.get(eVar.name);
                    if (dVar == null) {
                        dVar = new d(eVar.name);
                        hashMap.put(eVar.name, dVar);
                    }
                    dVar.list.add(eVar);
                }
                LinkedList linkedList = new LinkedList(hashMap.values());
                Collections.sort(linkedList, new Comparator<d>() {
                    /* class com.tencent.matrix.f.a.RunnableC0222a.AnonymousClass3 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* synthetic */ int compare(d dVar, d dVar2) {
                        return Long.compare((long) dVar2.getSize(), (long) dVar.getSize());
                    }
                });
                long uptimeMillis = SystemClock.uptimeMillis();
                if (!this.dau.isForeground() || uptimeMillis - this.dau.lastReportTime <= this.dau.dar) {
                    if (this.dau.dam.size() >= 10) {
                        this.dau.dam.remove(0);
                    }
                    this.dau.dam.add(linkedList);
                } else {
                    for (List list : this.dau.dam) {
                        a.a(this.dau, list);
                    }
                    this.dau.lastReportTime = uptimeMillis;
                    this.dau.dam.clear();
                }
                Handler handler = this.dau.handler;
                if (com.tencent.matrix.a.INSTANCE.cPB) {
                    j2 = this.dau.dap;
                } else {
                    j2 = this.dau.daq;
                }
                handler.postDelayed(this, j2);
            }
        }
    }

    @Override // com.tencent.matrix.e.b, com.tencent.matrix.b.c
    public void onForeground(boolean z) {
        super.onForeground(z);
        this.handler.removeCallbacksAndMessages(null);
        if (this.dal == null) {
            return;
        }
        if (z) {
            this.handler.postDelayed(this.dal, this.dap);
        } else {
            this.handler.postDelayed(this.dal, this.daq);
        }
    }

    public static int getProcessThreadCount() {
        try {
            String[] split = getStringFromFile(String.format("/proc/%s/status", Integer.valueOf(Process.myPid()))).trim().split("\n");
            for (String str : split) {
                if (str.startsWith("Threads")) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(str);
                    if (matcher.find()) {
                        return Integer.parseInt(matcher.group());
                    }
                }
            }
            com.tencent.matrix.g.c.w("Matrix.ThreadMonitor", "[getProcessThreadCount] Wrong!", split[24]);
            return Integer.parseInt(split[24].trim());
        } catch (Exception e2) {
            return 0;
        }
    }

    public static List<d> To() {
        final LongSparseArray<e> a2 = a((b) null);
        List<e> a3 = a(new c() {
            /* class com.tencent.matrix.f.a.AnonymousClass3 */

            @Override // com.tencent.matrix.f.a.c
            public final void a(e eVar) {
                e eVar2 = (e) a2.get(eVar.tid);
                if (eVar2 != null) {
                    eVar.name = eVar2.name.replaceAll("-?[0-9]\\d*", "?") + "J";
                    eVar.daz = eVar2.daz;
                    eVar.day = eVar2.day;
                    eVar.daA = eVar2.daA;
                    eVar.daB = true;
                    return;
                }
                eVar.name = eVar.name.replaceAll("-?[0-9]\\d*", "?");
            }
        }, new b() {
            /* class com.tencent.matrix.f.a.AnonymousClass4 */

            @Override // com.tencent.matrix.f.a.b
            public final boolean b(e eVar) {
                return false;
            }
        });
        HashMap hashMap = new HashMap();
        for (e eVar : a3) {
            d dVar = (d) hashMap.get(eVar.name);
            if (dVar == null) {
                dVar = new d(eVar.name);
                hashMap.put(eVar.name, dVar);
            }
            dVar.list.add(eVar);
        }
        LinkedList linkedList = new LinkedList(hashMap.values());
        Collections.sort(linkedList, new Comparator<d>() {
            /* class com.tencent.matrix.f.a.AnonymousClass5 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(d dVar, d dVar2) {
                return Long.compare((long) dVar2.getSize(), (long) dVar.getSize());
            }
        });
        return linkedList;
    }

    /* access modifiers changed from: private */
    public static LongSparseArray<e> a(b bVar) {
        LongSparseArray<e> longSparseArray = new LongSparseArray<>();
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            e eVar = new e();
            eVar.name = thread.getName();
            if ((bVar == null || !bVar.b(eVar)) && (thread instanceof HandlerThread)) {
                eVar.tid = (long) ((HandlerThread) thread).getThreadId();
                longSparseArray.put(eVar.tid, eVar);
                eVar.day = true;
            }
        }
        return longSparseArray;
    }

    /* access modifiers changed from: private */
    public static List<e> a(c cVar, b bVar) {
        LinkedList linkedList = new LinkedList();
        String format = String.format("/proc/%s/task/", Integer.valueOf(Process.myPid()));
        File file = new File(format);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    String stringFromFile = getStringFromFile(format + listFiles[i2].getName() + "/stat");
                    if (stringFromFile != null) {
                        String[] split = stringFromFile.replaceAll("\n", "").split(" ");
                        e eVar = new e();
                        eVar.tid = Long.parseLong(split[0]);
                        eVar.name = split[1].replace("(", "").replace(")", "");
                        eVar.state = split[2].replace("'", "");
                        if (bVar != null && !bVar.b(eVar)) {
                            linkedList.add(eVar);
                            if (cVar != null) {
                                cVar.a(eVar);
                            }
                        }
                    }
                } catch (Exception e2) {
                    com.tencent.matrix.g.c.e("Matrix.ThreadMonitor", com.tencent.matrix.g.d.g(e2), new Object[0]);
                }
            }
        }
        return linkedList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String convertStreamToString(java.io.InputStream r5) {
        /*
            r2 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0032 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0032 }
            java.lang.String r4 = "UTF-8"
            r3.<init>(r5, r4)     // Catch:{ all -> 0x0032 }
            r1.<init>(r3)     // Catch:{ all -> 0x0032 }
        L_0x0013:
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0023 }
            if (r2 == 0) goto L_0x002a
            java.lang.StringBuilder r2 = r0.append(r2)     // Catch:{ all -> 0x0023 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0023 }
            goto L_0x0013
        L_0x0023:
            r0 = move-exception
        L_0x0024:
            if (r1 == 0) goto L_0x0029
            r1.close()
        L_0x0029:
            throw r0
        L_0x002a:
            r1.close()
            java.lang.String r0 = r0.toString()
            return r0
        L_0x0032:
            r0 = move-exception
            r1 = r2
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.f.a.convertStreamToString(java.io.InputStream):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getStringFromFile(java.lang.String r3) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            r2 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0013 }
            r1.<init>(r0)     // Catch:{ all -> 0x0013 }
            java.lang.String r0 = convertStreamToString(r1)     // Catch:{ all -> 0x001b }
            r1.close()
            return r0
        L_0x0013:
            r0 = move-exception
            r1 = r2
        L_0x0015:
            if (r1 == 0) goto L_0x001a
            r1.close()
        L_0x001a:
            throw r0
        L_0x001b:
            r0 = move-exception
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.f.a.getStringFromFile(java.lang.String):java.lang.String");
    }

    public static class e {
        String daA;
        boolean daB;
        boolean day;
        int daz;
        String name;
        String state;
        long tid;

        public final boolean equals(Object obj) {
            if (!(obj instanceof e) || this.tid != ((e) obj).tid) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (int) this.tid;
        }

        public final String toString() {
            return String.format("name=%s tid=%s state=%s isHandlerThread=%s isJavaThread=%s", this.name, Long.valueOf(this.tid), this.state, Boolean.valueOf(this.day), Boolean.valueOf(this.daB));
        }
    }

    public static class d {
        List<e> list = new LinkedList();
        public String name;

        d(String str) {
            this.name = str;
        }

        public final int getSize() {
            return this.list.size();
        }

        public final boolean Tr() {
            if (this.list.size() > 0) {
                return this.list.get(0).daB;
            }
            return false;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof e) {
                return this.name.equals(((e) obj).name);
            }
            return false;
        }

        public final int hashCode() {
            return this.name.hashCode();
        }

        public final String toString() {
            return this.name + "=" + getSize();
        }
    }

    static /* synthetic */ void a(a aVar, List list) {
        if (!list.isEmpty()) {
            com.tencent.matrix.report.c cVar = new com.tencent.matrix.report.c();
            cVar.tag = "Thread";
            JSONObject jSONObject = new JSONObject();
            cVar.cWe = jSONObject;
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject.put("thread_group_count", list.size());
                jSONObject.put("thread_group_list", jSONArray);
                Iterator it = list.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONArray.put(jSONObject2);
                    jSONObject2.put("thread_group_name", dVar.name);
                    jSONObject2.put("count", dVar.getSize());
                    JSONArray jSONArray2 = new JSONArray();
                    jSONObject2.put("list", jSONArray2);
                    for (e eVar : dVar.list) {
                        i2++;
                        JSONObject jSONObject3 = new JSONObject();
                        jSONArray2.put(jSONObject3);
                        jSONObject3.put("tid", eVar.tid);
                        jSONObject3.put("state", eVar.state);
                        jSONObject3.put(SharePluginInfo.ISSUE_KEY_STACK, eVar.daz);
                        jSONObject3.put("isHandlerThread", eVar.day);
                        jSONObject3.put("target", eVar.daA);
                    }
                }
                jSONObject.put("thread_count", i2);
            } catch (JSONException e2) {
                com.tencent.matrix.g.c.e("Matrix.ThreadMonitor", com.tencent.matrix.g.d.g(e2), new Object[0]);
            }
            aVar.onDetectIssue(cVar);
        }
    }
}
