package android.arch.a.a;

import java.util.concurrent.Executor;

public class a extends c {
    private static volatile a bJ;
    private static final Executor bM = new Executor() {
        /* class android.arch.a.a.a.AnonymousClass1 */

        public final void execute(Runnable runnable) {
            a.S().postToMainThread(runnable);
        }
    };
    private static final Executor bN = new Executor() {
        /* class android.arch.a.a.a.AnonymousClass2 */

        public final void execute(Runnable runnable) {
            a.S().e(runnable);
        }
    };
    public c bK = this.bL;
    private c bL = new b();

    private a() {
    }

    public static a S() {
        if (bJ != null) {
            return bJ;
        }
        synchronized (a.class) {
            if (bJ == null) {
                bJ = new a();
            }
        }
        return bJ;
    }

    @Override // android.arch.a.a.c
    public final void e(Runnable runnable) {
        this.bK.e(runnable);
    }

    @Override // android.arch.a.a.c
    public final void postToMainThread(Runnable runnable) {
        this.bK.postToMainThread(runnable);
    }

    public static Executor T() {
        return bM;
    }

    public static Executor U() {
        return bN;
    }

    @Override // android.arch.a.a.c
    public final boolean isMainThread() {
        return this.bK.isMainThread();
    }
}
