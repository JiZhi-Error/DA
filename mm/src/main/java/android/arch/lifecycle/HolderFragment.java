package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import java.util.HashMap;
import java.util.Map;

public class HolderFragment extends Fragment implements ViewModelStoreOwner {
    public static final String HOLDER_TAG = "android.arch.lifecycle.state.StateProviderHolderFragment";
    private static final HolderFragmentManager cq = new HolderFragmentManager();
    private ViewModelStore mViewModelStore = new ViewModelStore();

    public HolderFragment() {
        setRetainInstance(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HolderFragmentManager holderFragmentManager = cq;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            holderFragmentManager.ct.remove(parentFragment);
            parentFragment.getFragmentManager().unregisterFragmentLifecycleCallbacks(holderFragmentManager.cw);
            return;
        }
        holderFragmentManager.cs.remove(getActivity());
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mViewModelStore.clear();
    }

    @Override // android.support.v4.app.Fragment, android.arch.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        return this.mViewModelStore;
    }

    public static HolderFragment holderFragmentFor(FragmentActivity fragmentActivity) {
        HolderFragmentManager holderFragmentManager = cq;
        g supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        HolderFragment a2 = HolderFragmentManager.a(supportFragmentManager);
        if (a2 != null) {
            return a2;
        }
        HolderFragment holderFragment = holderFragmentManager.cs.get(fragmentActivity);
        if (holderFragment != null) {
            return holderFragment;
        }
        if (!holderFragmentManager.cv) {
            holderFragmentManager.cv = true;
            fragmentActivity.getApplication().registerActivityLifecycleCallbacks(holderFragmentManager.cu);
        }
        HolderFragment b2 = HolderFragmentManager.b(supportFragmentManager);
        holderFragmentManager.cs.put(fragmentActivity, b2);
        return b2;
    }

    public static HolderFragment holderFragmentFor(Fragment fragment) {
        HolderFragmentManager holderFragmentManager = cq;
        g childFragmentManager = fragment.getChildFragmentManager();
        HolderFragment a2 = HolderFragmentManager.a(childFragmentManager);
        if (a2 != null) {
            return a2;
        }
        HolderFragment holderFragment = holderFragmentManager.ct.get(fragment);
        if (holderFragment != null) {
            return holderFragment;
        }
        fragment.getFragmentManager().registerFragmentLifecycleCallbacks(holderFragmentManager.cw, false);
        HolderFragment b2 = HolderFragmentManager.b(childFragmentManager);
        holderFragmentManager.ct.put(fragment, b2);
        return b2;
    }

    static class HolderFragmentManager {
        Map<Activity, HolderFragment> cs = new HashMap();
        Map<Fragment, HolderFragment> ct = new HashMap();
        Application.ActivityLifecycleCallbacks cu = new EmptyActivityLifecycleCallbacks() {
            /* class android.arch.lifecycle.HolderFragment.HolderFragmentManager.AnonymousClass1 */

            @Override // android.arch.lifecycle.EmptyActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (((HolderFragment) HolderFragmentManager.this.cs.remove(activity)) != null) {
                    new StringBuilder("Failed to save a ViewModel for ").append(activity);
                }
            }
        };
        boolean cv = false;
        g.b cw = new g.b() {
            /* class android.arch.lifecycle.HolderFragment.HolderFragmentManager.AnonymousClass2 */

            @Override // android.support.v4.app.g.b
            public void onFragmentDestroyed(g gVar, Fragment fragment) {
                super.onFragmentDestroyed(gVar, fragment);
                if (((HolderFragment) HolderFragmentManager.this.ct.remove(fragment)) != null) {
                    new StringBuilder("Failed to save a ViewModel for ").append(fragment);
                }
            }
        };

        HolderFragmentManager() {
        }

        static HolderFragment a(g gVar) {
            if (gVar.isDestroyed()) {
                throw new IllegalStateException("Can't access ViewModels from onDestroy");
            }
            Fragment findFragmentByTag = gVar.findFragmentByTag(HolderFragment.HOLDER_TAG);
            if (findFragmentByTag == null || (findFragmentByTag instanceof HolderFragment)) {
                return (HolderFragment) findFragmentByTag;
            }
            throw new IllegalStateException("Unexpected fragment instance was returned by HOLDER_TAG");
        }

        static HolderFragment b(g gVar) {
            HolderFragment holderFragment = new HolderFragment();
            gVar.beginTransaction().a(holderFragment, HolderFragment.HOLDER_TAG).commitAllowingStateLoss();
            return holderFragment;
        }
    }
}
