package com.tencent.mm.b;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class b {
    static MMHandler dgG;
    o dgD;
    private ReentrantLock dgE = new ReentrantLock();
    private Condition dgF = this.dgE.newCondition();

    public b(final String str) {
        synchronized (b.class) {
            if (dgG == null) {
                dgG = new MMHandler("I/O Worker");
            }
        }
        o oVar = new o(str);
        if (oVar.exists()) {
            this.dgD = oVar;
            return;
        }
        Log.i("MicroMsg.ConcurrentFileBuilder", "create new file %s", str);
        dgG.post(new Runnable() {
            /* class com.tencent.mm.b.b.AnonymousClass1 */

            public final void run() {
                o oVar = new o(str);
                if (!oVar.exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    o heq = new o(str).heq();
                    if (!heq.exists() && (!heq.mkdirs() || !heq.isDirectory())) {
                        Log.e("MicroMsg.ConcurrentFileBuilder", "mkParentDir mkdir error. %s", str);
                    }
                    Log.i("MicroMsg.ConcurrentFileBuilder", "make dir last %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    long currentTimeMillis2 = System.currentTimeMillis();
                    try {
                        oVar.createNewFile();
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", e2, "", new Object[0]);
                        Log.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", e2, "createNewFile", new Object[0]);
                    }
                    Log.i("MicroMsg.ConcurrentFileBuilder", "make file last %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                }
                b.this.dgE.lock();
                try {
                    b.this.dgD = oVar;
                    b.this.dgF.signal();
                    Log.i("MicroMsg.ConcurrentFileBuilder", "notify file prepared %s", oVar.hes());
                } finally {
                    b.this.dgE.unlock();
                }
            }
        });
    }

    public final o Ur() {
        this.dgE.lock();
        while (this.dgD == null) {
            try {
                Log.i("MicroMsg.ConcurrentFileBuilder", "getFile await");
                this.dgF.await();
            } catch (Exception e2) {
            } finally {
                this.dgE.unlock();
            }
        }
        return this.dgD;
    }
}
