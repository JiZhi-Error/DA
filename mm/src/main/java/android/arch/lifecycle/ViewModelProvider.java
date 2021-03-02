package android.arch.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

public class ViewModelProvider {
    private final Factory dx;
    private final ViewModelStore mViewModelStore;

    public interface Factory {
        <T extends ViewModel> T create(Class<T> cls);
    }

    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner, Factory factory) {
        this(viewModelStoreOwner.getViewModelStore(), factory);
    }

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory) {
        this.dx = factory;
        this.mViewModelStore = viewModelStore;
    }

    public <T extends ViewModel> T get(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) get("android.arch.lifecycle.ViewModelProvider.DefaultKey:".concat(String.valueOf(canonicalName)), cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends ViewModel> T get(String str, Class<T> cls) {
        T t = (T) this.mViewModelStore.mMap.get(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.dx.create(cls);
        this.mViewModelStore.a(str, t2);
        return t2;
    }

    public static class NewInstanceFactory implements Factory {
        @Override // android.arch.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e3);
            }
        }
    }

    public static class AndroidViewModelFactory extends NewInstanceFactory {
        private static AndroidViewModelFactory dy;
        private Application ca;

        public static AndroidViewModelFactory getInstance(Application application) {
            if (dy == null) {
                dy = new AndroidViewModelFactory(application);
            }
            return dy;
        }

        public AndroidViewModelFactory(Application application) {
            this.ca = application;
        }

        @Override // android.arch.lifecycle.ViewModelProvider.Factory, android.arch.lifecycle.ViewModelProvider.NewInstanceFactory
        public <T extends ViewModel> T create(Class<T> cls) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return (T) super.create(cls);
            }
            try {
                return cls.getConstructor(Application.class).newInstance(this.ca);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e5);
            }
        }
    }
}
