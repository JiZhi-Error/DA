package com.tencent.matrix.resource.e;

import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.resource.analyzer.model.f;
import com.tencent.mm.R;
import java.io.File;
import java.util.concurrent.TimeUnit;

public final class c {
    private final d cZI;
    final Context mContext;
    private final Handler mMainHandler;

    public interface a {
        void a(f fVar);
    }

    public c(Context context, d dVar) {
        this(context, dVar, new Handler(Looper.getMainLooper()));
    }

    private c(Context context, d dVar, Handler handler) {
        this.mContext = context;
        this.cZI = dVar;
        this.mMainHandler = handler;
    }

    public final File Ti() {
        File Tj = this.cZI.Tj();
        if (Tj == null) {
            com.tencent.matrix.g.c.w("Matrix.AndroidHeapDumper", "hprof file is null.", new Object[0]);
            return null;
        }
        File parentFile = Tj.getParentFile();
        if (parentFile == null) {
            com.tencent.matrix.g.c.w("Matrix.AndroidHeapDumper", "hprof file path: %s does not indicate a full path.", Tj.getAbsolutePath());
            return null;
        } else if (!parentFile.canWrite()) {
            com.tencent.matrix.g.c.w("Matrix.AndroidHeapDumper", "hprof file path: %s cannot be written.", Tj.getAbsolutePath());
            return null;
        } else {
            final com.tencent.matrix.resource.d.a.a aVar = new com.tencent.matrix.resource.d.a.a();
            this.mMainHandler.post(new Runnable() {
                /* class com.tencent.matrix.resource.e.c.AnonymousClass1 */

                public final void run() {
                    final Toast toast = new Toast(c.this.mContext);
                    toast.setDuration(1);
                    toast.setGravity(16, 0, 0);
                    toast.setView(LayoutInflater.from(c.this.mContext).inflate(R.layout.bn7, (ViewGroup) null));
                    toast.show();
                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                        /* class com.tencent.matrix.resource.e.c.AnonymousClass1.AnonymousClass1 */

                        public final boolean queueIdle() {
                            com.tencent.matrix.resource.d.a.a aVar = aVar;
                            aVar.cZB.set(toast);
                            aVar.cZC.countDown();
                            return false;
                        }
                    });
                }
            });
            if (!aVar.a(TimeUnit.SECONDS)) {
                com.tencent.matrix.g.c.w("Matrix.AndroidHeapDumper", "give up dumping heap, waiting for toast too long.", new Object[0]);
                return null;
            }
            try {
                Debug.dumpHprofData(Tj.getAbsolutePath());
                if (aVar.cZC.getCount() > 0) {
                    throw new IllegalStateException("Call wait() and check its result");
                }
                final T t = aVar.cZB.get();
                this.mMainHandler.post(new Runnable() {
                    /* class com.tencent.matrix.resource.e.c.AnonymousClass2 */

                    public final void run() {
                        t.cancel();
                    }
                });
                return Tj;
            } catch (Exception e2) {
                com.tencent.matrix.g.c.printErrStackTrace("Matrix.AndroidHeapDumper", e2, "failed to dump heap into file: %s.", Tj.getAbsolutePath());
                return null;
            }
        }
    }
}
