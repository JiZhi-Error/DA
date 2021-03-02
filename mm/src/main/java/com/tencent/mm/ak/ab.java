package com.tencent.mm.ak;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public final class ab {
    public static <T extends dpc> c.a<T> e(d dVar) {
        AppMethodBeat.i(182920);
        if (dVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cant use NULL rr");
            AppMethodBeat.o(182920);
            throw illegalArgumentException;
        }
        t azA = aa.iNn == null ? null : aa.iNn.azA();
        if (azA == null) {
            Log.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
            AppMethodBeat.o(182920);
            return null;
        } else if (MMHandlerThread.isMainThread()) {
            IllegalAccessError illegalAccessError = new IllegalAccessError("Cant call this function in main thread");
            AppMethodBeat.o(182920);
            throw illegalAccessError;
        } else if (azA.iMx.getLooper().getThread().getId() == Thread.currentThread().getId()) {
            IllegalAccessError illegalAccessError2 = new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
            AppMethodBeat.o(182920);
            throw illegalAccessError2;
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            aa.a(dVar, new aa.a() {
                /* class com.tencent.mm.ak.ab.AnonymousClass1 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, d dVar, q qVar) {
                    AppMethodBeat.i(132497);
                    atomicReference.set(c.a.a(i2, i3, str, (dpc) dVar.iLL.iLR, qVar, null));
                    countDownLatch.countDown();
                    AppMethodBeat.o(132497);
                    return 0;
                }
            });
            new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.ak.ab.AnonymousClass2 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(132498);
                    atomicReference.set(new a());
                    countDownLatch.countDown();
                    AppMethodBeat.o(132498);
                    return false;
                }
            }, false).startTimer(20000);
            try {
                countDownLatch.await();
                c.a<T> aVar = (c.a) atomicReference.get();
                AppMethodBeat.o(182920);
                return aVar;
            } catch (InterruptedException e2) {
                Log.printErrStackTrace("MicroMsg.SynchronousCgiCall", e2, "latch await exp ", new Object[0]);
                AppMethodBeat.o(182920);
                return null;
            }
        }
    }

    public static <T extends dpc> c.a<T> a(c<T> cVar) {
        AppMethodBeat.i(182921);
        if (cVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cant use NULL cgi instance");
            AppMethodBeat.o(182921);
            throw illegalArgumentException;
        }
        t azA = aa.iNn == null ? null : aa.iNn.azA();
        if (azA == null) {
            Log.e("MicroMsg.SynchronousCgiCall", "NetSceneQueue not ready, just return NULL");
            AppMethodBeat.o(182921);
            return null;
        } else if (MMHandlerThread.isMainThread()) {
            IllegalAccessError illegalAccessError = new IllegalAccessError("Cant call this function in main thread");
            AppMethodBeat.o(182921);
            throw illegalAccessError;
        } else if (azA.iMx.getLooper().getThread().getId() == Thread.currentThread().getId()) {
            IllegalAccessError illegalAccessError2 = new IllegalAccessError("Cant call this function in NetSceneQueue's worker thread!!!");
            AppMethodBeat.o(182921);
            throw illegalAccessError2;
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            cVar.aYI().b(new com.tencent.mm.vending.c.a<Void, c.a<T>>() {
                /* class com.tencent.mm.ak.ab.AnonymousClass3 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Void call(Object obj) {
                    AppMethodBeat.i(132499);
                    atomicReference.set((c.a) obj);
                    countDownLatch.countDown();
                    Void r0 = QZL;
                    AppMethodBeat.o(132499);
                    return r0;
                }
            });
            try {
                countDownLatch.await();
                c.a<T> aVar = (c.a) atomicReference.get();
                AppMethodBeat.o(182921);
                return aVar;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SynchronousCgiCall", e2, "semaphore await exp ", new Object[0]);
                AppMethodBeat.o(182921);
                return null;
            }
        }
    }

    public static class a<T extends dpc> extends c.a<T> {
        public a() {
            this.errType = 3;
            this.errCode = -13;
        }
    }
}
