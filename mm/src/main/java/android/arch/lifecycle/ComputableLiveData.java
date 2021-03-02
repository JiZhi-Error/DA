package android.arch.lifecycle;

import android.arch.a.a.a;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ComputableLiveData<T> {
    private final LiveData<T> ci;
    private AtomicBoolean cj;
    private AtomicBoolean ck;
    final Runnable cl;
    final Runnable cm;
    private final Executor mExecutor;

    /* access modifiers changed from: protected */
    public abstract T compute();

    public ComputableLiveData() {
        this(a.U());
    }

    public ComputableLiveData(Executor executor) {
        this.cj = new AtomicBoolean(true);
        this.ck = new AtomicBoolean(false);
        this.cl = new Runnable() {
            /* class android.arch.lifecycle.ComputableLiveData.AnonymousClass2 */

            /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: android.arch.lifecycle.LiveData */
            /* JADX WARN: Multi-variable type inference failed */
            public void run() {
                boolean z;
                do {
                    if (ComputableLiveData.this.ck.compareAndSet(false, true)) {
                        Object obj = null;
                        z = false;
                        while (ComputableLiveData.this.cj.compareAndSet(true, false)) {
                            try {
                                obj = ComputableLiveData.this.compute();
                                z = true;
                            } finally {
                                ComputableLiveData.this.ck.set(false);
                            }
                        }
                        if (z) {
                            ComputableLiveData.this.ci.postValue(obj);
                        }
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return;
                    }
                } while (ComputableLiveData.this.cj.get());
            }
        };
        this.cm = new Runnable() {
            /* class android.arch.lifecycle.ComputableLiveData.AnonymousClass3 */

            public void run() {
                boolean hasActiveObservers = ComputableLiveData.this.ci.hasActiveObservers();
                if (ComputableLiveData.this.cj.compareAndSet(false, true) && hasActiveObservers) {
                    ComputableLiveData.this.mExecutor.execute(ComputableLiveData.this.cl);
                }
            }
        };
        this.mExecutor = executor;
        this.ci = new LiveData<T>() {
            /* class android.arch.lifecycle.ComputableLiveData.AnonymousClass1 */

            /* access modifiers changed from: protected */
            @Override // android.arch.lifecycle.LiveData
            public final void onActive() {
                ComputableLiveData.this.mExecutor.execute(ComputableLiveData.this.cl);
            }
        };
    }

    public LiveData<T> getLiveData() {
        return this.ci;
    }

    public void invalidate() {
        a S = a.S();
        Runnable runnable = this.cm;
        if (S.isMainThread()) {
            runnable.run();
        } else {
            S.postToMainThread(runnable);
        }
    }
}
