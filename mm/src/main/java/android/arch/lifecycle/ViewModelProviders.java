package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class ViewModelProviders {
    private static Application c(Activity activity) {
        Application application = activity.getApplication();
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    public static ViewModelProvider of(Fragment fragment) {
        return of(fragment, (ViewModelProvider.Factory) null);
    }

    public static ViewModelProvider of(FragmentActivity fragmentActivity) {
        return of(fragmentActivity, (ViewModelProvider.Factory) null);
    }

    public static ViewModelProvider of(FragmentActivity fragmentActivity, ViewModelProvider.Factory factory) {
        Application c2 = c(fragmentActivity);
        if (factory == null) {
            factory = ViewModelProvider.AndroidViewModelFactory.getInstance(c2);
        }
        return new ViewModelProvider(ViewModelStores.of(fragmentActivity), factory);
    }

    @Deprecated
    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {
        @Deprecated
        public DefaultFactory(Application application) {
            super(application);
        }
    }

    public static ViewModelProvider of(Fragment fragment, ViewModelProvider.Factory factory) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
        }
        Application c2 = c(activity);
        if (factory == null) {
            factory = ViewModelProvider.AndroidViewModelFactory.getInstance(c2);
        }
        return new ViewModelProvider(ViewModelStores.of(fragment), factory);
    }
}
