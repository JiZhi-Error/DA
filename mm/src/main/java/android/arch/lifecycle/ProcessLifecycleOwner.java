package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ReportFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

public class ProcessLifecycleOwner implements LifecycleOwner {
    private static final ProcessLifecycleOwner dk = new ProcessLifecycleOwner();
    int dc = 0;
    int dd = 0;
    boolean de = true;
    boolean dg = true;
    final LifecycleRegistry dh = new LifecycleRegistry(this);
    Runnable di = new Runnable() {
        /* class android.arch.lifecycle.ProcessLifecycleOwner.AnonymousClass1 */

        public void run() {
            ProcessLifecycleOwner.a(ProcessLifecycleOwner.this);
            ProcessLifecycleOwner.this.an();
        }
    };
    private ReportFragment.ActivityInitializationListener dj = new ReportFragment.ActivityInitializationListener() {
        /* class android.arch.lifecycle.ProcessLifecycleOwner.AnonymousClass2 */

        @Override // android.arch.lifecycle.ReportFragment.ActivityInitializationListener
        public void onCreate() {
        }

        @Override // android.arch.lifecycle.ReportFragment.ActivityInitializationListener
        public void onStart() {
            ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.this;
            processLifecycleOwner.dc++;
            if (processLifecycleOwner.dc == 1 && processLifecycleOwner.dg) {
                processLifecycleOwner.dh.handleLifecycleEvent(Lifecycle.Event.ON_START);
                processLifecycleOwner.dg = false;
            }
        }

        @Override // android.arch.lifecycle.ReportFragment.ActivityInitializationListener
        public void onResume() {
            ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.this;
            processLifecycleOwner.dd++;
            if (processLifecycleOwner.dd != 1) {
                return;
            }
            if (processLifecycleOwner.de) {
                processLifecycleOwner.dh.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                processLifecycleOwner.de = false;
                return;
            }
            processLifecycleOwner.mHandler.removeCallbacks(processLifecycleOwner.di);
        }
    };
    Handler mHandler;

    public static LifecycleOwner get() {
        return dk;
    }

    static void init(Context context) {
        ProcessLifecycleOwner processLifecycleOwner = dk;
        processLifecycleOwner.mHandler = new Handler();
        processLifecycleOwner.dh.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() {
            /* class android.arch.lifecycle.ProcessLifecycleOwner.AnonymousClass3 */

            @Override // android.arch.lifecycle.EmptyActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ReportFragment.b(activity).f0do = ProcessLifecycleOwner.this.dj;
            }

            @Override // android.arch.lifecycle.EmptyActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.this;
                processLifecycleOwner.dd--;
                if (processLifecycleOwner.dd == 0) {
                    processLifecycleOwner.mHandler.postDelayed(processLifecycleOwner.di, 700);
                }
            }

            @Override // android.arch.lifecycle.EmptyActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.this;
                processLifecycleOwner.dc--;
                processLifecycleOwner.an();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void an() {
        if (this.dc == 0 && this.de) {
            this.dh.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            this.dg = true;
        }
    }

    private ProcessLifecycleOwner() {
    }

    @Override // android.arch.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.dh;
    }

    static /* synthetic */ void a(ProcessLifecycleOwner processLifecycleOwner) {
        if (processLifecycleOwner.dd == 0) {
            processLifecycleOwner.de = true;
            processLifecycleOwner.dh.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
    }
}
