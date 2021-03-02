package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;

public class ReportFragment extends Fragment {

    /* renamed from: do  reason: not valid java name */
    ActivityInitializationListener f0do;

    /* access modifiers changed from: package-private */
    public interface ActivityInitializationListener {
        void onCreate();

        void onResume();

        void onStart();
    }

    public static void injectIfNeededIn(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    static ReportFragment b(Activity activity) {
        return (ReportFragment) activity.getFragmentManager().findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ActivityInitializationListener activityInitializationListener = this.f0do;
        if (activityInitializationListener != null) {
            activityInitializationListener.onCreate();
        }
        a(Lifecycle.Event.ON_CREATE);
    }

    public void onStart() {
        super.onStart();
        ActivityInitializationListener activityInitializationListener = this.f0do;
        if (activityInitializationListener != null) {
            activityInitializationListener.onStart();
        }
        a(Lifecycle.Event.ON_START);
    }

    public void onResume() {
        super.onResume();
        ActivityInitializationListener activityInitializationListener = this.f0do;
        if (activityInitializationListener != null) {
            activityInitializationListener.onResume();
        }
        a(Lifecycle.Event.ON_RESUME);
    }

    public void onPause() {
        super.onPause();
        a(Lifecycle.Event.ON_PAUSE);
    }

    public void onStop() {
        super.onStop();
        a(Lifecycle.Event.ON_STOP);
    }

    public void onDestroy() {
        super.onDestroy();
        a(Lifecycle.Event.ON_DESTROY);
        this.f0do = null;
    }

    private void a(Lifecycle.Event event) {
        Activity activity = getActivity();
        if (activity instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner) activity).getLifecycle().handleLifecycleEvent(event);
        } else if (activity instanceof LifecycleOwner) {
            Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
            if (lifecycle instanceof LifecycleRegistry) {
                ((LifecycleRegistry) lifecycle).handleLifecycleEvent(event);
            }
        }
    }
}
