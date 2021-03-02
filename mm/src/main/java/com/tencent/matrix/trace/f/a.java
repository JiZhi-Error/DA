package com.tencent.matrix.trace.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.g.c;
import com.tencent.matrix.trace.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.g.a;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.tav.coremedia.TimeUtil;
import java.lang.Thread;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends f {
    private final com.tencent.matrix.trace.a.b daC;
    private Handler dbY;
    private Handler dbZ;
    private volatile RunnableC0236a dca = new RunnableC0236a();
    private volatile b dcb = new b();
    private boolean dcc;

    public a(com.tencent.matrix.trace.a.b bVar) {
        this.daC = bVar;
        this.dcc = bVar.daN;
    }

    @Override // com.tencent.matrix.trace.f.f
    public final void onAlive() {
        super.onAlive();
        if (this.dcc) {
            com.tencent.matrix.trace.core.b.Tw().a(this);
            this.dbY = new Handler(com.tencent.matrix.g.b.TQ().getLooper());
            this.dbZ = new Handler(com.tencent.matrix.g.b.TQ().getLooper());
        }
    }

    @Override // com.tencent.matrix.trace.f.f
    public final void onDead() {
        super.onDead();
        if (this.dcc) {
            com.tencent.matrix.trace.core.b.Tw().b(this);
            if (this.dca != null) {
                this.dca.dcd.release();
            }
            this.dbY.removeCallbacksAndMessages(null);
            this.dbZ.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.matrix.trace.e.c
    public final void d(long j2, long j3, long j4) {
        super.d(j2, j3, j4);
        this.dca.dcd = AppMethodBeat.getInstance().maskIndex("AnrTracer#dispatchBegin");
        this.dca.dbl = j4;
        if (this.daC.daO) {
            c.v("Matrix.AnrTracer", "* [dispatchBegin] token:%s index:%s", Long.valueOf(j4), Integer.valueOf(this.dca.dcd.index));
        }
        long nanoTime = (System.nanoTime() - j4) / TimeUtil.SECOND_TO_US;
        this.dbY.postDelayed(this.dca, 5000 - nanoTime);
        this.dbZ.postDelayed(this.dcb, 2000 - nanoTime);
    }

    @Override // com.tencent.matrix.trace.e.c
    public final void a(long j2, long j3, long j4, long j5, long j6, boolean z) {
        super.a(j2, j3, j4, j5, j6, z);
        if (this.daC.daO) {
            long j7 = (j4 - j2) / TimeUtil.SECOND_TO_US;
            c.v("Matrix.AnrTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s", Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j5 - j3), com.tencent.matrix.trace.g.b.q(j5 - j3, j7));
        }
        if (this.dca != null) {
            this.dca.dcd.release();
            this.dbY.removeCallbacks(this.dca);
        }
        if (this.dcb != null) {
            this.dbZ.removeCallbacks(this.dcb);
        }
    }

    class b implements Runnable {
        b() {
        }

        public final void run() {
            String visibleScene = AppMethodBeat.getVisibleScene();
            boolean z = com.tencent.matrix.a.INSTANCE.cPB;
            try {
                com.tencent.matrix.trace.a aVar = (com.tencent.matrix.trace.a) com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class);
                if (aVar != null) {
                    StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                    JSONObject a2 = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.RG().application);
                    a2.put("detail", a.EnumC0233a.LAG);
                    a2.put("scene", visibleScene);
                    a2.put("threadStack", com.tencent.matrix.trace.g.b.a(stackTrace));
                    a2.put("isProcessForeground", z);
                    com.tencent.matrix.report.c cVar = new com.tencent.matrix.report.c();
                    cVar.tag = "Trace_EvilMethod";
                    cVar.cWe = a2;
                    aVar.onDetectIssue(cVar);
                    c.e("Matrix.AnrTracer", "happens lag : %s ", a2.toString());
                }
            } catch (JSONException e2) {
                c.e("Matrix.AnrTracer", "[JSONException error: %s", e2);
            }
        }
    }

    /* renamed from: com.tencent.matrix.trace.f.a$a  reason: collision with other inner class name */
    class RunnableC0236a implements Runnable {
        long dbl;
        AppMethodBeat.a dcd;

        public RunnableC0236a() {
        }

        public final void run() {
            long uptimeMillis = SystemClock.uptimeMillis();
            boolean z = com.tencent.matrix.a.INSTANCE.cPB;
            int[] ix = com.tencent.matrix.trace.g.b.ix(Process.myPid());
            long[] copyData = AppMethodBeat.getInstance().copyData(this.dcd);
            this.dcd.release();
            String visibleScene = AppMethodBeat.getVisibleScene();
            long[] jArr = {com.tencent.matrix.g.a.getDalvikHeap(), com.tencent.matrix.g.a.getNativeHeap(), com.tencent.matrix.g.a.TN()};
            Thread.State state = Looper.getMainLooper().getThread().getState();
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            String a2 = com.tencent.matrix.trace.g.b.a(stackTrace, "|*\t\t", 12);
            com.tencent.matrix.trace.core.b Tw = com.tencent.matrix.trace.core.b.Tw();
            long u = Tw.u(0, this.dbl);
            long u2 = Tw.u(1, this.dbl);
            long u3 = Tw.u(2, this.dbl);
            LinkedList linkedList = new LinkedList();
            if (copyData.length > 0) {
                com.tencent.matrix.trace.g.a.a(copyData, linkedList, true, uptimeMillis);
                com.tencent.matrix.trace.g.a.a(linkedList, new a.AbstractC0238a() {
                    /* class com.tencent.matrix.trace.f.a.RunnableC0236a.AnonymousClass1 */

                    @Override // com.tencent.matrix.trace.g.a.AbstractC0238a
                    public final boolean b(long j2, int i2) {
                        return j2 < ((long) (i2 * 5));
                    }

                    @Override // com.tencent.matrix.trace.g.a.AbstractC0238a
                    public final void d(List<com.tencent.matrix.trace.d.a> list, int i2) {
                        c.w("Matrix.AnrTracer", "[fallback] size:%s targetSize:%s stack:%s", Integer.valueOf(i2), 30, list);
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
            long max = Math.max(5000L, com.tencent.matrix.trace.g.a.a(linkedList, sb, sb2));
            String b2 = com.tencent.matrix.trace.g.a.b(linkedList, max);
            Object[] objArr = new Object[3];
            long size = (long) linkedList.size();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(String.format("-\n>>>>>>>>>>>>>>>>>>>>>>> maybe happens ANR(%s ms)! <<<<<<<<<<<<<<<<<<<<<<<\n", Long.valueOf(max)));
            sb3.append("|* [Status]\n");
            sb3.append("|*\t\tScene: ").append(visibleScene).append("\n");
            sb3.append("|*\t\tForeground: ").append(z).append("\n");
            sb3.append("|*\t\tPriority: ").append(ix[0]).append("\tNice: ").append(ix[1]).append("\n");
            sb3.append("|*\t\tis64BitRuntime: ").append(com.tencent.matrix.g.a.is64BitRuntime()).append("\n");
            sb3.append("|* [Memory]\n");
            sb3.append("|*\t\tDalvikHeap: ").append(jArr[0]).append("kb\n");
            sb3.append("|*\t\tNativeHeap: ").append(jArr[1]).append("kb\n");
            sb3.append("|*\t\tVmSize: ").append(jArr[2]).append("kb\n");
            sb3.append("|* [doFrame]\n");
            sb3.append("|*\t\tinputCost:animationCost:traversalCost\n");
            sb3.append("|*\t\t").append(u).append(":").append(u2).append(":").append(u3).append("\n");
            sb3.append("|* [Thread]\n");
            sb3.append(String.format("|*\t\tStack(%s): ", state)).append(a2);
            sb3.append("|* [Trace]\n");
            if (size > 0) {
                sb3.append("|*\t\tStackKey: ").append(b2).append("\n");
                sb3.append(sb2.toString());
            } else {
                sb3.append(String.format("AppMethodBeat is close[%s].", Boolean.valueOf(AppMethodBeat.getInstance().isAlive()))).append("\n");
            }
            sb3.append("=========================================================================");
            objArr[0] = sb3.toString();
            objArr[1] = Long.valueOf(this.dbl / TimeUtil.SECOND_TO_US);
            objArr[2] = Long.valueOf(uptimeMillis);
            c.w("Matrix.AnrTracer", "%s \npostTime:%s curTime:%s", objArr);
            if (max >= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME) {
                c.w("Matrix.AnrTracer", "The checked anr task was not executed on time. The possible reason is that the current process has a low priority. just pass this report", new Object[0]);
                return;
            }
            try {
                com.tencent.matrix.trace.a aVar = (com.tencent.matrix.trace.a) com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class);
                if (aVar != null) {
                    JSONObject a3 = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.RG().application);
                    a3.put("detail", a.EnumC0233a.ANR);
                    a3.put("cost", max);
                    a3.put("stackKey", b2);
                    a3.put("scene", visibleScene);
                    a3.put(SharePluginInfo.ISSUE_KEY_STACK, sb.toString());
                    a3.put("threadStack", com.tencent.matrix.trace.g.b.a(stackTrace));
                    a3.put("processPriority", ix[0]);
                    a3.put("processNice", ix[1]);
                    a3.put("isProcessForeground", z);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("dalvik_heap", jArr[0]);
                    jSONObject.put("native_heap", jArr[1]);
                    jSONObject.put("vm_size", jArr[2]);
                    a3.put("memory", jSONObject);
                    com.tencent.matrix.report.c cVar = new com.tencent.matrix.report.c();
                    cVar.key = new StringBuilder().append(this.dbl).toString();
                    cVar.tag = "Trace_EvilMethod";
                    cVar.cWe = a3;
                    aVar.onDetectIssue(cVar);
                }
            } catch (JSONException e2) {
                c.e("Matrix.AnrTracer", "[JSONException error: %s", e2);
            }
        }
    }
}
