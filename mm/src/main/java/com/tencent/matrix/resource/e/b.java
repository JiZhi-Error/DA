package com.tencent.matrix.resource.e;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Debug;
import android.os.HandlerThread;
import android.support.v4.app.s;
import com.tencent.c.a.a;
import com.tencent.matrix.b.c;
import com.tencent.matrix.resource.CanaryWorkerService;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.analyzer.model.f;
import com.tencent.matrix.resource.b.a;
import com.tencent.matrix.resource.e.c;
import com.tencent.matrix.resource.e.e;
import com.tencent.mm.R;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends com.tencent.matrix.report.b implements c {
    final a.b cYD;
    Intent cYF;
    public final com.tencent.matrix.resource.b cZD;
    public final e cZE;
    final int cZF;
    private final long cZG;
    private final long cZH;
    private final d cZI;
    public final c cZJ;
    final c.a cZK;
    final ConcurrentLinkedQueue<DestroyedActivityInfo> cZL;
    public AbstractC0231b cZM;
    public final Application.ActivityLifecycleCallbacks cZN;
    public final e.a cZO;

    public static class a {
    }

    /* renamed from: com.tencent.matrix.resource.e.b$b  reason: collision with other inner class name */
    public interface AbstractC0231b {
        boolean G(String str, String str2);

        boolean H(String str, String str2);
    }

    public b(Application application, com.tencent.matrix.resource.b bVar) {
        this(application, bVar, new a());
    }

    private b(Application application, com.tencent.matrix.resource.b bVar, a aVar) {
        super(application, bVar.getTag(), bVar);
        this.cZM = null;
        this.cZN = new a() {
            /* class com.tencent.matrix.resource.e.b.AnonymousClass1 */

            @Override // com.tencent.matrix.resource.e.a
            public final void onActivityDestroyed(Activity activity) {
                b bVar = b.this;
                String name = activity.getClass().getName();
                if (bVar.cZD.cWP.cYE || bVar.cYD == a.b.SILENCE_DUMP || !bVar.eC(name)) {
                    UUID randomUUID = UUID.randomUUID();
                    StringBuilder sb = new StringBuilder();
                    sb.append("MATRIX_RESCANARY_REFKEY_").append(name).append('_').append(Long.toHexString(randomUUID.getMostSignificantBits())).append(Long.toHexString(randomUUID.getLeastSignificantBits()));
                    bVar.cZL.add(new DestroyedActivityInfo(sb.toString(), activity, name));
                    return;
                }
                com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity leak with name %s had published, just ignore", name);
            }
        };
        this.cZO = new e.a() {
            /* class com.tencent.matrix.resource.e.b.AnonymousClass2 */

            @Override // com.tencent.matrix.resource.e.e.a
            public final e.a.EnumC0232a Th() {
                if (b.this.cZL.isEmpty()) {
                    com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "DestroyedActivityInfo isEmpty!", new Object[0]);
                    return e.a.EnumC0232a.RETRY;
                } else if (!Debug.isDebuggerConnected() || b.this.cZD.cWP.cYE) {
                    WeakReference weakReference = new WeakReference(new Object());
                    com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "triggering gc...", new Object[0]);
                    Runtime.getRuntime().gc();
                    Runtime.getRuntime().runFinalization();
                    com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "gc was triggered.", new Object[0]);
                    if (weakReference.get() != null) {
                        com.tencent.matrix.g.c.d("Matrix.ActivityRefWatcher", "system ignore our gc request, wait for next detection.", new Object[0]);
                        return e.a.EnumC0232a.RETRY;
                    }
                    Iterator<DestroyedActivityInfo> it = b.this.cZL.iterator();
                    while (it.hasNext()) {
                        DestroyedActivityInfo next = it.next();
                        if (!b.this.cZD.cWP.cYE && b.this.eC(next.mActivityName) && b.this.cYD != a.b.SILENCE_DUMP) {
                            com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "activity with key [%s] was already published.", next.mActivityName);
                            it.remove();
                        } else if (next.mActivityRef.get() == null) {
                            com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "activity with key [%s] was already recycled.", next.mKey);
                            it.remove();
                        } else {
                            next.mDetectedCount++;
                            if (next.mDetectedCount >= b.this.cZF || b.this.cZD.cWP.cYE) {
                                com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity with key [%s] was suspected to be a leaked instance. mode[%s]", next.mKey, b.this.cYD);
                                if (b.this.cYD == a.b.SILENCE_DUMP) {
                                    if (!b.this.eC(next.mActivityName)) {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put(EnvConsts.ACTIVITY_MANAGER_SRVNAME, next.mActivityName);
                                        } catch (JSONException e2) {
                                            com.tencent.matrix.g.c.printErrStackTrace("Matrix.ActivityRefWatcher", e2, "unexpected exception.", new Object[0]);
                                        }
                                        b.this.eB(next.mActivityName);
                                        b.this.cZD.onDetectIssue(new com.tencent.matrix.report.c(jSONObject));
                                    }
                                    if (b.this.cZM != null && b.this.cZM.G(next.mActivityName, next.mKey)) {
                                        com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity [%s] with key [%s] has been dumped. stop polling", next.mActivityName, next.mKey);
                                        it.remove();
                                    }
                                } else if (b.this.cYD == a.b.AUTO_DUMP) {
                                    File Ti = b.this.cZJ.Ti();
                                    if (Ti != null) {
                                        b.this.eB(next.mActivityName);
                                        b.this.cZK.a(new f(Ti, next.mKey, next.mActivityName));
                                        it.remove();
                                    } else {
                                        com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "heap dump for further analyzing activity with key [%s] was failed, just ignore.", next.mKey);
                                        it.remove();
                                    }
                                } else if (b.this.cYD == a.b.MANUAL_DUMP) {
                                    NotificationManager notificationManager = (NotificationManager) b.this.context.getSystemService("notification");
                                    String string = b.this.context.getString(R.string.g5_);
                                    String str = next.mActivityName;
                                    b.this.cYF.putExtra(EnvConsts.ACTIVITY_MANAGER_SRVNAME, next.mActivityName);
                                    b.this.cYF.putExtra("ref_key", next.mKey);
                                    PendingIntent activity = PendingIntent.getActivity(b.this.context, 0, b.this.cYF, 134217728);
                                    s.c f2 = new s.c(b.this.context).f(str);
                                    f2.Hv = activity;
                                    s.c g2 = f2.g(string);
                                    Context context = b.this.context;
                                    g2.as(R.drawable.a80).i(System.currentTimeMillis());
                                    if (Build.VERSION.SDK_INT >= 26) {
                                        String string2 = context.getString(R.string.wx);
                                        NotificationManager notificationManager2 = (NotificationManager) context.getSystemService("notification");
                                        if (notificationManager2.getNotificationChannel(string2) == null) {
                                            notificationManager2.createNotificationChannel(new NotificationChannel(string2, string2, 3));
                                        }
                                        g2.mChannelId = string2;
                                    }
                                    notificationManager.notify(272, g2.build());
                                    it.remove();
                                    b.this.eB(next.mActivityName);
                                    com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "show notification for notify activity leak. %s", next.mActivityName);
                                } else {
                                    com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "lightweight mode, just report leaked activity name.", new Object[0]);
                                    b.this.eB(next.mActivityName);
                                    JSONObject jSONObject2 = new JSONObject();
                                    try {
                                        jSONObject2.put(EnvConsts.ACTIVITY_MANAGER_SRVNAME, next.mActivityName);
                                    } catch (JSONException e3) {
                                        com.tencent.matrix.g.c.printErrStackTrace("Matrix.ActivityRefWatcher", e3, "unexpected exception.", new Object[0]);
                                    }
                                    b.this.cZD.onDetectIssue(new com.tencent.matrix.report.c(jSONObject2));
                                    if (b.this.cZM != null) {
                                        b.this.cZM.H(next.mActivityName, next.mKey);
                                    }
                                }
                            } else {
                                com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity with key [%s] should be recycled but actually still \nexists in %s times, wait for next detection to confirm.", next.mKey, Integer.valueOf(next.mDetectedCount));
                            }
                        }
                    }
                    return e.a.EnumC0232a.RETRY;
                } else {
                    com.tencent.matrix.g.c.w("Matrix.ActivityRefWatcher", "debugger is connected, to avoid fake result, detection was delayed.", new Object[0]);
                    return e.a.EnumC0232a.RETRY;
                }
            }
        };
        this.cZD = bVar;
        com.tencent.matrix.resource.b.a aVar2 = bVar.cWP;
        HandlerThread TP = com.tencent.matrix.g.b.TP();
        this.cYD = aVar2.cYD;
        this.cZG = aVar2.cQF.get(a.EnumC0131a.clicfg_matrix_resource_detect_interval_millis_bg.name(), com.tencent.matrix.resource.b.a.cYB);
        this.cZH = aVar2.Tb();
        this.cYF = aVar2.cYF;
        this.cZE = new e(aVar2.Tb(), TP);
        this.cZF = aVar2.cQF.get(a.EnumC0131a.clicfg_matrix_resource_max_detect_times.name(), 10);
        this.cZI = new d(application);
        this.cZJ = new c(application, this.cZI);
        this.cZK = new c.a(application) {
            /* class com.tencent.matrix.resource.e.b.a.AnonymousClass1 */
            final /* synthetic */ Context val$context;

            {
                this.val$context = r2;
            }

            @Override // com.tencent.matrix.resource.e.c.a
            public final void a(f fVar) {
                CanaryWorkerService.a(this.val$context, fVar);
            }
        };
        this.cZL = new ConcurrentLinkedQueue<>();
    }

    @Override // com.tencent.matrix.b.c
    public final void onForeground(boolean z) {
        if (z) {
            com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "we are in foreground, modify scan time[%sms].", Long.valueOf(this.cZH));
            this.cZE.Tm();
            this.cZE.cZY = this.cZH;
            this.cZE.a(this.cZO, 0);
            return;
        }
        com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "we are in background, modify scan time[%sms].", Long.valueOf(this.cZG));
        this.cZE.cZY = this.cZG;
    }

    public final void Tf() {
        Application application = this.cZD.getApplication();
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this.cZN);
            com.tencent.matrix.a.INSTANCE.b(this);
            Tg();
        }
    }

    private void Tg() {
        this.cZE.Tm();
        this.cZL.clear();
    }
}
