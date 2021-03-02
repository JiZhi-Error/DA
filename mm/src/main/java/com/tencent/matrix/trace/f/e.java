package com.tencent.matrix.trace.f;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.c.a.a;
import com.tencent.matrix.g.c;
import com.tencent.matrix.trace.a.b;
import com.tencent.matrix.trace.b.a;
import com.tencent.matrix.trace.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.g.a;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends f implements Application.ActivityLifecycleCallbacks, a.b, com.tencent.matrix.trace.e.a {
    private boolean daR;
    private final b daS;
    private long dcX = 0;
    private long dcY = 0;
    private int dcZ;
    private boolean dda;
    private boolean ddb;
    private boolean ddc;
    private Set<String> ddd;
    private long dde;
    private long ddf;
    private long ddg = 0;
    private HashMap<String, Long> ddh = new HashMap<>();
    private boolean ddi = true;

    public e(b bVar) {
        int i2;
        int i3 = 10000;
        this.daS = bVar;
        this.ddc = bVar.daM;
        if (bVar.daQ == null) {
            bVar.daQ = new HashSet();
            if (bVar.cVx != null) {
                String str = bVar.cVx.get(a.EnumC0131a.clicfg_matrix_trace_care_scene_set.name(), bVar.daP);
                if (str != null) {
                    bVar.daP = str;
                }
                if (bVar.daP != null) {
                    bVar.daQ.addAll(Arrays.asList(bVar.daP.split(";")));
                }
            } else if (bVar.daP != null) {
                bVar.daQ.addAll(Arrays.asList(bVar.daP.split(";")));
            }
        }
        this.ddd = bVar.daQ;
        this.dde = (long) (bVar.cVx != null ? bVar.cVx.get(a.EnumC0131a.clicfg_matrix_trace_app_start_up_threshold.name(), 10000) : i3);
        if (bVar.cVx == null) {
            i2 = 4000;
        } else {
            i2 = bVar.cVx.get(a.EnumC0131a.clicfg_matrix_trace_warm_app_start_up_threshold.name(), 4000);
        }
        this.ddf = (long) i2;
        this.daR = bVar.daR;
        com.tencent.matrix.trace.c.a.a(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.matrix.trace.f.f
    public final void onAlive() {
        super.onAlive();
        c.i("Matrix.StartupTracer", "[onAlive] isStartupEnable:%s", Boolean.valueOf(this.ddc));
        if (this.ddc) {
            AppMethodBeat.getInstance().addListener(this);
            com.tencent.matrix.b.RG().application.registerActivityLifecycleCallbacks(this);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.matrix.trace.f.f
    public final void onDead() {
        super.onDead();
        if (this.ddc) {
            AppMethodBeat.getInstance().removeListener(this);
            com.tencent.matrix.b.RG().application.unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // com.tencent.matrix.trace.c.a.b
    public final void TC() {
        if (!this.daR) {
            long Ty = com.tencent.matrix.trace.c.a.Ty();
            c.i("Matrix.StartupTracer", "onApplicationCreateEnd, applicationCost:%d", Long.valueOf(Ty));
            a(Ty, 0, Ty, false);
        }
    }

    @Override // com.tencent.matrix.trace.e.a
    public final void n(Activity activity) {
        boolean z;
        Long l;
        if (com.tencent.matrix.trace.c.a.dbE != Integer.MIN_VALUE) {
            String name = activity.getClass().getName();
            if (this.dcY == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                boolean TA = com.tencent.matrix.trace.c.a.TA();
                c.i("Matrix.StartupTracer", "#ColdStartup# activity:%s, splashActivities:%s, empty:%b, isCreatedByLaunchActivity:%b, hasShowSplashActivity:%b, firstScreenCost:%d, now:%d, application_create_begin_time:%d, app_cost:%d", name, this.ddd, Boolean.valueOf(this.ddd.isEmpty()), Boolean.valueOf(TA), Boolean.valueOf(this.ddb), Long.valueOf(this.dcX), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(com.tencent.matrix.trace.c.a.Tz()), Long.valueOf(com.tencent.matrix.trace.c.a.Ty()));
                String str = name + "@" + activity.hashCode();
                Long l2 = this.ddh.get(str);
                if (l2 == null) {
                    l = 0L;
                } else {
                    l = l2;
                }
                this.ddh.put(str, Long.valueOf(SystemClock.uptimeMillis() - l.longValue()));
                if (this.dcX == 0) {
                    this.dcX = SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.Tz();
                }
                if (this.ddb) {
                    this.dcY = SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.Tz();
                } else if (this.ddd.contains(name)) {
                    this.ddb = true;
                } else if (this.ddd.isEmpty()) {
                    if (TA) {
                        this.dcY = this.dcX;
                    } else {
                        this.dcX = 0;
                        this.dcY = com.tencent.matrix.trace.c.a.Ty();
                    }
                } else if (TA) {
                    this.dcY = this.dcX;
                } else {
                    this.dcX = 0;
                    this.dcY = com.tencent.matrix.trace.c.a.Ty();
                }
                if (this.dcY > 0) {
                    Long l3 = this.ddh.get(str);
                    if (l3 == null || l3.longValue() < 30000) {
                        a(com.tencent.matrix.trace.c.a.Ty(), this.dcX, this.dcY, false);
                        return;
                    }
                    c.e("Matrix.StartupTracer", "%s cost too much time[%s] between activity create and onActivityFocused, just throw it.(createTime:%s) ", str, Long.valueOf(SystemClock.uptimeMillis() - l.longValue()), l);
                }
            } else if (this.dda) {
                this.dda = false;
                long uptimeMillis = SystemClock.uptimeMillis() - this.ddg;
                c.i("Matrix.StartupTracer", "#WarmStartup# activity:%s, warmCost:%d, now:%d, lastCreateActivity:%d", name, Long.valueOf(uptimeMillis), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(this.ddg));
                if (uptimeMillis > 0) {
                    a(0, 0, uptimeMillis, true);
                }
            }
        }
    }

    private void a(long j2, long j3, long j4, boolean z) {
        c.i("Matrix.StartupTracer", "[report] applicationCost:%s firstScreenCost:%s allCost:%s isWarmStartUp:%s, createScene:%d", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), Integer.valueOf(com.tencent.matrix.trace.c.a.dbE));
        long[] jArr = new long[0];
        if (!z && j4 >= this.dde) {
            jArr = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.dbD);
            com.tencent.matrix.trace.c.a.dbD.release();
        } else if (z && j4 >= this.ddf) {
            jArr = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.dbC);
            com.tencent.matrix.trace.c.a.dbC.release();
        }
        com.tencent.matrix.g.b.TQ().post(new a(jArr, j2, j3, j4, z, com.tencent.matrix.trace.c.a.dbE));
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        long[] data;
        long dcX;
        boolean dda;
        long ddj;
        long ddk;
        int scene;

        a(long[] jArr, long j2, long j3, long j4, boolean z, int i2) {
            this.data = jArr;
            this.scene = i2;
            this.ddj = j2;
            this.dcX = j3;
            this.ddk = j4;
            this.dda = z;
        }

        public final void run() {
            LinkedList linkedList = new LinkedList();
            if (this.data.length > 0) {
                com.tencent.matrix.trace.g.a.a(this.data, linkedList, false, -1);
                com.tencent.matrix.trace.g.a.a(linkedList, new a.AbstractC0238a() {
                    /* class com.tencent.matrix.trace.f.e.a.AnonymousClass1 */

                    @Override // com.tencent.matrix.trace.g.a.AbstractC0238a
                    public final boolean b(long j2, int i2) {
                        return j2 < ((long) (i2 * 5));
                    }

                    @Override // com.tencent.matrix.trace.g.a.AbstractC0238a
                    public final void d(List<com.tencent.matrix.trace.d.a> list, int i2) {
                        c.w("Matrix.StartupTracer", "[fallback] size:%s targetSize:%s stack:%s", Integer.valueOf(i2), 30, list);
                        ListIterator<com.tencent.matrix.trace.d.a> listIterator = list.listIterator(Math.min(i2, 30));
                        while (listIterator.hasNext()) {
                            listIterator.next();
                            listIterator.remove();
                        }
                    }
                });
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            long max = Math.max(this.ddk, com.tencent.matrix.trace.g.a.a(linkedList, sb, sb2));
            String b2 = com.tencent.matrix.trace.g.a.b(linkedList, max);
            if ((this.ddk > e.this.dde && !this.dda) || (this.ddk > e.this.ddf && this.dda)) {
                c.w("Matrix.StartupTracer", "stackKey:%s \n%s", b2, sb2.toString());
            }
            long j2 = this.ddj;
            long j3 = this.dcX;
            boolean z = this.dda;
            int i2 = this.scene;
            com.tencent.matrix.trace.a aVar = (com.tencent.matrix.trace.a) com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class);
            if (aVar != null) {
                try {
                    JSONObject a2 = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.RG().application);
                    a2.put("application_create", j2);
                    a2.put("application_create_scene", i2);
                    a2.put("first_activity_create", j3);
                    a2.put("startup_duration", max);
                    a2.put("is_warm_start_up", z);
                    com.tencent.matrix.report.c cVar = new com.tencent.matrix.report.c();
                    cVar.tag = "Trace_StartUp";
                    cVar.cWe = a2;
                    aVar.onDetectIssue(cVar);
                } catch (JSONException e2) {
                    c.e("Matrix.StartupTracer", "[JSONException for StartUpReportTask error: %s", e2);
                }
                if ((max > e.this.dde && !z) || (max > e.this.ddf && z)) {
                    try {
                        JSONObject a3 = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.RG().application);
                        a3.put("detail", a.EnumC0233a.STARTUP);
                        a3.put("cost", max);
                        a3.put(SharePluginInfo.ISSUE_KEY_STACK, sb.toString());
                        a3.put("stackKey", b2);
                        a3.put("subType", z ? 2 : 1);
                        com.tencent.matrix.report.c cVar2 = new com.tencent.matrix.report.c();
                        cVar2.tag = "Trace_EvilMethod";
                        cVar2.cWe = a3;
                        aVar.onDetectIssue(cVar2);
                    } catch (JSONException e3) {
                        c.e("Matrix.StartupTracer", "[JSONException error: %s", e3);
                    }
                }
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        c.i("Matrix.StartupTracer", "activeActivityCount:%d, coldCost:%d", Integer.valueOf(this.dcZ), Long.valueOf(this.dcY));
        if (this.dcZ == 0 && this.dcY > 0) {
            this.ddg = SystemClock.uptimeMillis();
            c.i("Matrix.StartupTracer", "lastCreateActivity:%d, activity:%s", Long.valueOf(this.ddg), activity.getClass().getName());
            this.dda = true;
        }
        this.dcZ++;
        if (this.ddi) {
            this.ddh.put(activity.getClass().getName() + "@" + activity.hashCode(), Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        c.i("Matrix.StartupTracer", "activeActivityCount:%d", Integer.valueOf(this.dcZ));
        this.dcZ--;
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // com.tencent.matrix.trace.f.f, com.tencent.matrix.b.c
    public final void onForeground(boolean z) {
        super.onForeground(z);
        if (!z) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Field declaredField = cls.getDeclaredField("sCurrentActivityThread");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(cls);
                Field declaredField2 = cls.getDeclaredField("mH");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                Field declaredField3 = obj2.getClass().getSuperclass().getDeclaredField("mCallback");
                declaredField3.setAccessible(true);
                c.i("Matrix.StartupTracer", "callback %s", (Handler.Callback) declaredField3.get(obj2));
            } catch (Exception e2) {
            }
        }
    }
}
