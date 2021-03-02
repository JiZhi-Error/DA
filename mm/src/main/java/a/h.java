package a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class h<TResult> {
    public static final ExecutorService aBM = b.nC();
    public static final Executor aBN = b.nD();
    public static final Executor aBO = a.nB();
    private static volatile a aBP;
    private static h<?> aBU = new h<>((Object) null);
    private static h<Boolean> aBV = new h<>(Boolean.TRUE);
    private static h<Boolean> aBW = new h<>(Boolean.FALSE);
    private static h<?> aBX = new h<>((byte) 0);
    private boolean aBQ;
    private boolean aBR;
    private j aBS;
    private List<f<TResult, Void>> aBT = new ArrayList();
    private boolean cancelled;
    private Exception error;
    private final Object lock = new Object();
    private TResult result;

    public interface a {
    }

    static /* synthetic */ void b(i iVar, f fVar, h hVar, Executor executor, c cVar) {
        AppMethodBeat.i(53003);
        a(iVar, fVar, hVar, executor, cVar);
        AppMethodBeat.o(53003);
    }

    static {
        AppMethodBeat.i(53004);
        AppMethodBeat.o(53004);
    }

    public static a nG() {
        return aBP;
    }

    h() {
        AppMethodBeat.i(52991);
        AppMethodBeat.o(52991);
    }

    private h(TResult tresult) {
        AppMethodBeat.i(52992);
        trySetResult(tresult);
        AppMethodBeat.o(52992);
    }

    private h(byte b2) {
        AppMethodBeat.i(52993);
        nJ();
        AppMethodBeat.o(52993);
    }

    private boolean isCompleted() {
        boolean z;
        synchronized (this.lock) {
            z = this.aBQ;
        }
        return z;
    }

    public final boolean nH() {
        boolean z;
        AppMethodBeat.i(52994);
        synchronized (this.lock) {
            try {
                z = getError() != null;
            } finally {
                AppMethodBeat.o(52994);
            }
        }
        return z;
    }

    public final TResult getResult() {
        TResult tresult;
        synchronized (this.lock) {
            tresult = this.result;
        }
        return tresult;
    }

    public final Exception getError() {
        Exception exc;
        synchronized (this.lock) {
            if (this.error != null) {
                this.aBR = true;
                if (this.aBS != null) {
                    this.aBS.aCe = null;
                    this.aBS = null;
                }
            }
            exc = this.error;
        }
        return exc;
    }

    public static <TResult> h<TResult> a(Callable<TResult> callable) {
        AppMethodBeat.i(52995);
        h<TResult> a2 = a(callable, aBM);
        AppMethodBeat.o(52995);
        return a2;
    }

    private static <TResult> h<TResult> a(final Callable<TResult> callable, Executor executor) {
        AppMethodBeat.i(52996);
        final i iVar = new i();
        try {
            executor.execute(new Runnable() {
                /* class a.h.AnonymousClass3 */
                final /* synthetic */ c aCb = null;

                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: a.i */
                /* JADX WARN: Multi-variable type inference failed */
                public final void run() {
                    AppMethodBeat.i(52990);
                    if (this.aCb == null || !this.aCb.aBH.isCancellationRequested()) {
                        try {
                            iVar.setResult(callable.call());
                            AppMethodBeat.o(52990);
                        } catch (CancellationException e2) {
                            iVar.nK();
                            AppMethodBeat.o(52990);
                        } catch (Exception e3) {
                            iVar.c(e3);
                            AppMethodBeat.o(52990);
                        }
                    } else {
                        iVar.nK();
                        AppMethodBeat.o(52990);
                    }
                }
            });
        } catch (Exception e2) {
            iVar.c(new g(e2));
        }
        h<TResult> hVar = iVar.aCe;
        AppMethodBeat.o(52996);
        return hVar;
    }

    public static <TResult> h<TResult> b(Callable<TResult> callable) {
        AppMethodBeat.i(240220);
        h<TResult> a2 = a(callable, aBN);
        AppMethodBeat.o(240220);
        return a2;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: a.h<TResult>, a.h<TContinuationResult> */
    public final <TContinuationResult> h<TContinuationResult> a(final f<TResult, TContinuationResult> fVar, final Executor executor) {
        boolean isCompleted;
        AppMethodBeat.i(52997);
        final i iVar = new i();
        synchronized (this.lock) {
            try {
                isCompleted = isCompleted();
                if (!isCompleted) {
                    this.aBT.add(new f<TResult, Void>() {
                        /* class a.h.AnonymousClass1 */
                        final /* synthetic */ c aCb = null;

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // a.f
                        public final /* synthetic */ Void a(h hVar) {
                            AppMethodBeat.i(52988);
                            h.b(iVar, fVar, hVar, executor, this.aCb);
                            AppMethodBeat.o(52988);
                            return null;
                        }
                    });
                }
            } catch (Throwable th) {
                AppMethodBeat.o(52997);
                throw th;
            }
        }
        if (isCompleted) {
            a(iVar, fVar, this, executor, null);
        }
        h hVar = (h<TResult>) iVar.aCe;
        AppMethodBeat.o(52997);
        return hVar;
    }

    private static <TContinuationResult, TResult> void a(final i<TContinuationResult> iVar, final f<TResult, TContinuationResult> fVar, final h<TResult> hVar, Executor executor, final c cVar) {
        AppMethodBeat.i(52998);
        try {
            executor.execute(new Runnable() {
                /* class a.h.AnonymousClass2 */

                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: a.i */
                /* JADX WARN: Multi-variable type inference failed */
                public final void run() {
                    AppMethodBeat.i(52989);
                    if (cVar == null || !cVar.aBH.isCancellationRequested()) {
                        try {
                            iVar.setResult(fVar.a(hVar));
                            AppMethodBeat.o(52989);
                        } catch (CancellationException e2) {
                            iVar.nK();
                            AppMethodBeat.o(52989);
                        } catch (Exception e3) {
                            iVar.c(e3);
                            AppMethodBeat.o(52989);
                        }
                    } else {
                        iVar.nK();
                        AppMethodBeat.o(52989);
                    }
                }
            });
            AppMethodBeat.o(52998);
        } catch (Exception e2) {
            iVar.c(new g(e2));
            AppMethodBeat.o(52998);
        }
    }

    private void nI() {
        AppMethodBeat.i(52999);
        synchronized (this.lock) {
            try {
                for (f<TResult, Void> fVar : this.aBT) {
                    try {
                        fVar.a(this);
                    } catch (RuntimeException e2) {
                        AppMethodBeat.o(52999);
                        throw e2;
                    } catch (Exception e3) {
                        RuntimeException runtimeException = new RuntimeException(e3);
                        AppMethodBeat.o(52999);
                        throw runtimeException;
                    }
                }
                this.aBT = null;
            } finally {
                AppMethodBeat.o(52999);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean nJ() {
        boolean z = true;
        AppMethodBeat.i(53000);
        synchronized (this.lock) {
            try {
                if (this.aBQ) {
                    z = false;
                } else {
                    this.aBQ = true;
                    this.cancelled = true;
                    this.lock.notifyAll();
                    nI();
                    AppMethodBeat.o(53000);
                }
            } finally {
                AppMethodBeat.o(53000);
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final boolean trySetResult(TResult tresult) {
        boolean z = true;
        AppMethodBeat.i(53001);
        synchronized (this.lock) {
            try {
                if (this.aBQ) {
                    z = false;
                } else {
                    this.aBQ = true;
                    this.result = tresult;
                    this.lock.notifyAll();
                    nI();
                    AppMethodBeat.o(53001);
                }
            } finally {
                AppMethodBeat.o(53001);
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(Exception exc) {
        AppMethodBeat.i(53002);
        synchronized (this.lock) {
            try {
                if (this.aBQ) {
                    return false;
                }
                this.aBQ = true;
                this.error = exc;
                this.aBR = false;
                this.lock.notifyAll();
                nI();
                if (!this.aBR && aBP != null) {
                    this.aBS = new j(this);
                }
                AppMethodBeat.o(53002);
                return true;
            } finally {
                AppMethodBeat.o(53002);
            }
        }
    }
}
