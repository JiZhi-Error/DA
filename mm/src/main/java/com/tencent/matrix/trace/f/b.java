package com.tencent.matrix.trace.f;

import android.os.Process;
import com.tencent.c.a.a;
import com.tencent.matrix.g.c;
import com.tencent.matrix.trace.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.g.a;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends f {
    private final com.tencent.matrix.trace.a.b daS;
    private AppMethodBeat.a dcg;
    private long[] dch = new long[3];
    public long dci;
    private boolean dcj;

    public b(com.tencent.matrix.trace.a.b bVar) {
        int i2 = 700;
        this.daS = bVar;
        this.dci = (long) (bVar.cVx != null ? bVar.cVx.get(a.EnumC0131a.clicfg_matrix_trace_evil_method_threshold.name(), 700) : i2);
        this.dcj = bVar.daL;
    }

    @Override // com.tencent.matrix.trace.f.f
    public final void onAlive() {
        super.onAlive();
        if (this.dcj) {
            com.tencent.matrix.trace.core.b.Tw().a(this);
        }
    }

    @Override // com.tencent.matrix.trace.f.f
    public final void onDead() {
        super.onDead();
        if (this.dcj) {
            com.tencent.matrix.trace.core.b.Tw().b(this);
        }
    }

    @Override // com.tencent.matrix.trace.e.c
    public final void d(long j2, long j3, long j4) {
        super.d(j2, j3, j4);
        this.dcg = AppMethodBeat.getInstance().maskIndex("EvilMethodTracer#dispatchBegin");
    }

    @Override // com.tencent.matrix.trace.e.c
    public final void a(String str, long j2, long j3, boolean z, long j4, long j5, long j6, long j7) {
        this.dch[0] = j5;
        this.dch[1] = j6;
        this.dch[2] = j7;
    }

    @Override // com.tencent.matrix.trace.e.c
    public final void a(long j2, long j3, long j4, long j5, long j6, boolean z) {
        long j7;
        super.a(j2, j3, j4, j5, j6, z);
        if (this.daS.daO) {
            j7 = System.currentTimeMillis();
        } else {
            j7 = 0;
        }
        long j8 = (j4 - j2) / TimeUtil.SECOND_TO_US;
        try {
            if (j8 >= this.dci) {
                long[] copyData = AppMethodBeat.getInstance().copyData(this.dcg);
                long[] jArr = new long[3];
                System.arraycopy(this.dch, 0, jArr, 0, 3);
                com.tencent.matrix.g.b.TQ().post(new a(com.tencent.matrix.a.INSTANCE.cPB, AppMethodBeat.getVisibleScene(), copyData, jArr, j5 - j3, j8, j4 / TimeUtil.SECOND_TO_US));
            }
            this.dcg.release();
            if (this.daS.daO) {
                c.v("Matrix.EvilMethodTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s innerCost:%s", Long.valueOf(j6), Long.valueOf(j8), Long.valueOf(j5 - j3), com.tencent.matrix.trace.g.b.q(j5 - j3, j8), Long.valueOf(System.currentTimeMillis() - j7));
            }
        } catch (Throwable th) {
            this.dcg.release();
            if (this.daS.daO) {
                c.v("Matrix.EvilMethodTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s innerCost:%s", Long.valueOf(j6), Long.valueOf(j8), Long.valueOf(j5 - j3), com.tencent.matrix.trace.g.b.q(j5 - j3, j8), Long.valueOf(System.currentTimeMillis() - j7));
            }
            throw th;
        }
    }

    class a implements Runnable {
        long cCv;
        boolean cQp;
        long[] data;
        long[] dbx;
        long dck;
        long dcl;
        String scene;

        a(boolean z, String str, long[] jArr, long[] jArr2, long j2, long j3, long j4) {
            this.cQp = z;
            this.scene = str;
            this.cCv = j3;
            this.dck = j2;
            this.data = jArr;
            this.dbx = jArr2;
            this.dcl = j4;
        }

        public final void run() {
            int[] ix = com.tencent.matrix.trace.g.b.ix(Process.myPid());
            String q = com.tencent.matrix.trace.g.b.q(this.dck, this.cCv);
            LinkedList linkedList = new LinkedList();
            if (this.data.length > 0) {
                com.tencent.matrix.trace.g.a.a(this.data, linkedList, true, this.dcl);
                com.tencent.matrix.trace.g.a.a(linkedList, new a.AbstractC0238a() {
                    /* class com.tencent.matrix.trace.f.b.a.AnonymousClass1 */

                    @Override // com.tencent.matrix.trace.g.a.AbstractC0238a
                    public final boolean b(long j2, int i2) {
                        return j2 < ((long) (i2 * 5));
                    }

                    @Override // com.tencent.matrix.trace.g.a.AbstractC0238a
                    public final void d(List<com.tencent.matrix.trace.d.a> list, int i2) {
                        c.w("Matrix.EvilMethodTracer", "[fallback] size:%s targetSize:%s stack:%s", Integer.valueOf(i2), 30, list);
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
            long max = Math.max(this.cCv, com.tencent.matrix.trace.g.a.a(linkedList, sb, sb2));
            String b2 = com.tencent.matrix.trace.g.a.b(linkedList, max);
            Object[] objArr = new Object[1];
            String str = this.scene;
            boolean z = this.cQp;
            long size = (long) linkedList.size();
            long j2 = this.dbx[0];
            long j3 = this.dbx[1];
            long j4 = this.dbx[2];
            long j5 = this.cCv;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(String.format("-\n>>>>>>>>>>>>>>>>>>>>> maybe happens Jankiness!(%sms) <<<<<<<<<<<<<<<<<<<<<\n", Long.valueOf(j5)));
            sb3.append("|* [Status]\n");
            sb3.append("|*\t\tScene: ").append(str).append("\n");
            sb3.append("|*\t\tForeground: ").append(z).append("\n");
            sb3.append("|*\t\tPriority: ").append(ix[0]).append("\tNice: ").append(ix[1]).append("\n");
            sb3.append("|*\t\tis64BitRuntime: ").append(com.tencent.matrix.g.a.is64BitRuntime()).append("\n");
            sb3.append("|*\t\tCPU: ").append(q).append("\n");
            sb3.append("|* [doFrame]\n");
            sb3.append("|*\t\tinputCost:animationCost:traversalCost\n");
            sb3.append("|*\t\t").append(j2).append(":").append(j3).append(":").append(j4).append("\n");
            if (size > 0) {
                sb3.append("|*\t\tStackKey: ").append(b2).append("\n");
                sb3.append(sb2.toString());
            } else {
                sb3.append(String.format("AppMethodBeat is close[%s].", Boolean.valueOf(AppMethodBeat.getInstance().isAlive()))).append("\n");
            }
            sb3.append("=========================================================================");
            objArr[0] = sb3.toString();
            c.w("Matrix.EvilMethodTracer", "%s", objArr);
            try {
                com.tencent.matrix.trace.a aVar = (com.tencent.matrix.trace.a) com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class);
                if (aVar != null) {
                    JSONObject a2 = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.RG().application);
                    a2.put("detail", a.EnumC0233a.NORMAL);
                    a2.put("cost", max);
                    a2.put("usage", q);
                    a2.put("scene", this.scene);
                    a2.put(SharePluginInfo.ISSUE_KEY_STACK, sb.toString());
                    a2.put("stackKey", b2);
                    com.tencent.matrix.report.c cVar = new com.tencent.matrix.report.c();
                    cVar.tag = "Trace_EvilMethod";
                    cVar.cWe = a2;
                    aVar.onDetectIssue(cVar);
                }
            } catch (JSONException e2) {
                c.e("Matrix.EvilMethodTracer", "[JSONException error: %s", e2);
            }
        }
    }
}
