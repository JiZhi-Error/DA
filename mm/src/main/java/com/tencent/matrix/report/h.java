package com.tencent.matrix.report;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.matrix.e;
import com.tencent.matrix.mrs.core.MatrixUploadIssue;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.strategy.MatrixStrategyNotifyBroadcast;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class h extends com.tencent.matrix.e.a {
    private Long cWo;
    private String cWp;
    private volatile boolean cWq;
    private Long cWr;
    private f cWs = new f();
    private final ConcurrentHashMap<c, Object> cWt = new ConcurrentHashMap<>();
    public b cWu;
    private final ConcurrentLinkedQueue<d> cWv = new ConcurrentLinkedQueue<>();
    public final ConcurrentLinkedDeque<d> cWw = new ConcurrentLinkedDeque<>();
    private final Context context;
    public volatile boolean isInit = false;

    public interface b {
        boolean c(c cVar);
    }

    public interface c {
        void a(d dVar);
    }

    public final void a(c cVar) {
        this.cWt.put(cVar, new Object());
    }

    public final String toString() {
        return "clientVersion=" + this.cWo + " revision=" + this.cWp + " isDebug=" + this.cWq + " publishType" + this.cWr;
    }

    public h(Context context2, Long l, String str, Boolean bool, Long l2) {
        super(context2);
        this.context = context2;
        this.cWo = l;
        this.cWp = str;
        this.cWq = bool.booleanValue();
        this.cWr = l2;
        if (MMApplicationContext.isMainProcess()) {
            try {
                MrsLogic.init(l.longValue(), str, bool.booleanValue(), l2.longValue());
            } catch (Throwable th) {
                com.tencent.matrix.g.c.printErrStackTrace("MicroMsg.MatrixReporter", th, "", new Object[0]);
                MrsLogic.init(l.longValue(), str, bool.booleanValue(), l2.longValue());
            }
        } else {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("strategyNotify");
            intentFilter.addAction("statusNotify");
            e.addAction(intentFilter);
            MatrixStrategyNotifyBroadcast matrixStrategyNotifyBroadcast = new MatrixStrategyNotifyBroadcast();
            try {
                context2.registerReceiver(matrixStrategyNotifyBroadcast, intentFilter, MatrixStrategyNotifyBroadcast.dag, null);
            } catch (Throwable th2) {
                context2.unregisterReceiver(matrixStrategyNotifyBroadcast);
                context2.registerReceiver(matrixStrategyNotifyBroadcast, intentFilter, MatrixStrategyNotifyBroadcast.dag, null);
            }
        }
    }

    @Override // com.tencent.matrix.e.c, com.tencent.matrix.e.a
    public final void a(c cVar) {
        d d2 = d.d(cVar);
        if (d2.cWf instanceof com.tencent.matrix.trace.a) {
            this.cWw.addFirst(d2);
            if (this.cWw.size() >= 30) {
                this.cWw.removeLast();
            }
        }
        try {
            if (this.cWu == null || !this.cWu.c(d2)) {
                for (c cVar2 : this.cWt.keySet()) {
                    cVar2.a(d2);
                }
                String str = d2.filePath;
                try {
                    if (MMApplicationContext.isMainProcess()) {
                        a(d2, str);
                        return;
                    }
                    Intent intent = new Intent(this.context, MatrixReportBroadcast.class);
                    intent.putExtra("tag", d2.tag);
                    intent.putExtra("key", d2.key);
                    intent.putExtra("type", d2.type);
                    intent.putExtra("value", d2.cWe.toString());
                    intent.putExtra("filePath", str);
                    com.tencent.matrix.g.c.i("MicroMsg.MatrixReporter", "Matrix report with broadcast tag:%s", d2.tag);
                    this.context.sendBroadcast(intent);
                } catch (Throwable th) {
                    com.tencent.matrix.g.c.e("MicroMsg.MatrixReporter", "Matrix report occur error:".concat(String.valueOf(th)), new Object[0]);
                }
            } else {
                Log.w("MicroMsg.MatrixReporter", "[reportJson] pass this report! tag=%s", d2.tag);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MatrixReporter", e2, "", new Object[0]);
        }
    }

    public final void a(c cVar, String str) {
        if (this.isInit || !MMApplicationContext.isMainProcess()) {
            if (!this.cWv.isEmpty()) {
                Iterator<d> it = this.cWv.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    com.tencent.matrix.g.c.i("MicroMsg.MatrixReporter", "Matrix report pending list! tag:%s, key:%s, data:%s", next.tag, next.cWe, Integer.valueOf(com.tencent.mm.protocal.d.KyO));
                    MrsLogic.collectData(next.tag, next.cWe.toString().getBytes());
                    if (!TextUtils.isEmpty(str)) {
                        a(next, new o(next.filePath));
                    }
                }
                this.cWv.clear();
            }
            com.tencent.matrix.g.c.i("MicroMsg.MatrixReporter", "Matrix reportLocal tag:%s, key:%s, data:%s", cVar.tag, cVar.cWe, Integer.valueOf(com.tencent.mm.protocal.d.KyO));
            MrsLogic.collectData(cVar.tag, cVar.cWe.toString().getBytes());
            this.cWs.g(cVar.tag, cVar.cWe);
            if (!TextUtils.isEmpty(str)) {
                a(cVar, new o(str));
                return;
            }
            return;
        }
        com.tencent.matrix.g.c.w("MicroMsg.MatrixReporter", "MatrixReportBroadcast, matrix report is not init, wait to report plugin:%s", cVar.tag);
        d d2 = d.d(cVar);
        d2.filePath = str;
        this.cWv.add(d2);
    }

    private static void a(c cVar, o oVar) {
        if (cVar != null) {
            try {
                if (oVar.exists()) {
                    MatrixUploadIssue matrixUploadIssue = new MatrixUploadIssue();
                    matrixUploadIssue.setTag(cVar.tag);
                    matrixUploadIssue.setCanSplitSlice(true);
                    matrixUploadIssue.setDataType(1);
                    matrixUploadIssue.setNeedDeleteFileAfterSucc(true);
                    matrixUploadIssue.setType(cVar.type);
                    matrixUploadIssue.setDesKey(cVar.key);
                    matrixUploadIssue.setFilePath(aa.z(oVar.her()));
                    MrsLogic.uploadMatrixIssue(matrixUploadIssue);
                    return;
                }
            } catch (Throwable th) {
                com.tencent.matrix.g.c.e("MicroMsg.MatrixReporter", "Matrix report occur error:".concat(String.valueOf(th)), new Object[0]);
                return;
            }
        }
        com.tencent.matrix.g.c.e("MicroMsg.MatrixReporter", "Matrix report, tag %s or file %s is null, just return", cVar, oVar);
    }

    public static class a {
        public Long cWo;
        public String cWp;
        public Long cWr;
        public Boolean cWx;
        public final Context context;

        public a(Context context2) {
            if (context2 == null) {
                throw new RuntimeException("matrix report init, context is null");
            }
            this.context = context2;
        }
    }

    public static final class d extends c {
        public String filePath;

        public static d d(c cVar) {
            d dVar = new d();
            dVar.cWe = cVar.cWe;
            dVar.tag = cVar.tag;
            dVar.cWf = cVar.cWf;
            dVar.key = cVar.key;
            dVar.type = cVar.type;
            return dVar;
        }
    }
}
