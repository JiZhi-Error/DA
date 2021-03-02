package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* access modifiers changed from: package-private */
public class LifecycleDispatcher {
    private static AtomicBoolean cy = new AtomicBoolean(false);

    LifecycleDispatcher() {
    }

    static void init(Context context) {
        if (!cy.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
        }
    }

    static class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        private final FragmentCallback cz = new FragmentCallback();

        DispatcherActivityCallback() {
        }

        @Override // android.arch.lifecycle.EmptyActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof FragmentActivity) {
                ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.cz, true);
            }
            ReportFragment.injectIfNeededIn(activity);
        }

        @Override // android.arch.lifecycle.EmptyActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (activity instanceof FragmentActivity) {
                LifecycleDispatcher.a((FragmentActivity) activity, Lifecycle.State.CREATED);
            }
        }

        @Override // android.arch.lifecycle.EmptyActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            if (activity instanceof FragmentActivity) {
                LifecycleDispatcher.a((FragmentActivity) activity, Lifecycle.State.CREATED);
            }
        }
    }

    public static class DestructionReportFragment extends Fragment {
        @Override // android.support.v4.app.Fragment
        public void onPause() {
            super.onPause();
            a(Lifecycle.Event.ON_PAUSE);
        }

        @Override // android.support.v4.app.Fragment
        public void onStop() {
            super.onStop();
            a(Lifecycle.Event.ON_STOP);
        }

        @Override // android.support.v4.app.Fragment
        public void onDestroy() {
            super.onDestroy();
            a(Lifecycle.Event.ON_DESTROY);
        }

        private void a(Lifecycle.Event event) {
            LifecycleDispatcher.a(getParentFragment(), event);
        }
    }

    private static void a(g gVar, Lifecycle.State state) {
        List<Fragment> fragments = gVar.getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null) {
                    a(fragment, state);
                    if (fragment.isAdded()) {
                        a(fragment.getChildFragmentManager(), state);
                    }
                }
            }
        }
    }

    private static void a(Object obj, Lifecycle.State state) {
        if (obj instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner) obj).getLifecycle().markState(state);
        }
    }

    static class FragmentCallback extends g.b {
        FragmentCallback() {
        }

        @Override // android.support.v4.app.g.b
        public void onFragmentCreated(g gVar, Fragment fragment, Bundle bundle) {
            LifecycleDispatcher.a(fragment, Lifecycle.Event.ON_CREATE);
            if ((fragment instanceof LifecycleRegistryOwner) && fragment.getChildFragmentManager().findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragment.getChildFragmentManager().beginTransaction().a(new DestructionReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            }
        }

        @Override // android.support.v4.app.g.b
        public void onFragmentStarted(g gVar, Fragment fragment) {
            LifecycleDispatcher.a(fragment, Lifecycle.Event.ON_START);
        }

        @Override // android.support.v4.app.g.b
        public void onFragmentResumed(g gVar, Fragment fragment) {
            LifecycleDispatcher.a(fragment, Lifecycle.Event.ON_RESUME);
        }
    }

    static /* synthetic */ void a(FragmentActivity fragmentActivity, Lifecycle.State state) {
        a((Object) fragmentActivity, state);
        a(fragmentActivity.getSupportFragmentManager(), state);
    }

    static /* synthetic */ void a(Fragment fragment, Lifecycle.Event event) {
        if (fragment instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner) fragment).getLifecycle().handleLifecycleEvent(event);
        }
    }
}
