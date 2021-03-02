package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class g {
    public static final int POP_BACK_STACK_INCLUSIVE = 1;

    public interface a {
    }

    public interface c {
        void onBackStackChanged();
    }

    public abstract void addOnBackStackChangedListener(c cVar);

    public abstract k beginTransaction();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean executePendingTransactions();

    public abstract Fragment findFragmentById(int i2);

    public abstract Fragment findFragmentByTag(String str);

    public abstract a getBackStackEntryAt(int i2);

    public abstract int getBackStackEntryCount();

    public abstract Fragment getFragment(Bundle bundle, String str);

    public abstract List<Fragment> getFragments();

    public abstract Fragment getPrimaryNavigationFragment();

    public abstract boolean isDestroyed();

    public abstract boolean isStateSaved();

    public abstract void popBackStack();

    public abstract void popBackStack(int i2, int i3);

    public abstract void popBackStack(String str, int i2);

    public abstract boolean popBackStackImmediate();

    public abstract boolean popBackStackImmediate(int i2, int i3);

    public abstract boolean popBackStackImmediate(String str, int i2);

    public abstract void putFragment(Bundle bundle, String str, Fragment fragment);

    public abstract void registerFragmentLifecycleCallbacks(b bVar, boolean z);

    public abstract void removeOnBackStackChangedListener(c cVar);

    public abstract Fragment.SavedState saveFragmentInstanceState(Fragment fragment);

    public abstract void unregisterFragmentLifecycleCallbacks(b bVar);

    @Deprecated
    public k openTransaction() {
        return beginTransaction();
    }

    public static void enableDebugLogging(boolean z) {
        FragmentManagerImpl.DEBUG = z;
    }

    public static abstract class b {
        public void onFragmentPreAttached(g gVar, Fragment fragment, Context context) {
        }

        public void onFragmentAttached(g gVar, Fragment fragment, Context context) {
        }

        public void onFragmentPreCreated(g gVar, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentCreated(g gVar, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentActivityCreated(g gVar, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentViewCreated(g gVar, Fragment fragment, View view, Bundle bundle) {
        }

        public void onFragmentStarted(g gVar, Fragment fragment) {
        }

        public void onFragmentResumed(g gVar, Fragment fragment) {
        }

        public void onFragmentPaused(g gVar, Fragment fragment) {
        }

        public void onFragmentStopped(g gVar, Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(g gVar, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentViewDestroyed(g gVar, Fragment fragment) {
        }

        public void onFragmentDestroyed(g gVar, Fragment fragment) {
        }

        public void onFragmentDetached(g gVar, Fragment fragment) {
        }
    }
}
