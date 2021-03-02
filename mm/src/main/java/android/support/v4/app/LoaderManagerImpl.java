package android.support.v4.app;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStore;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.p;
import android.support.v4.content.c;
import android.support.v4.e.e;
import android.support.v4.e.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* access modifiers changed from: package-private */
public final class LoaderManagerImpl extends p {
    static boolean DEBUG = false;
    private final LifecycleOwner GW;
    private final LoaderViewModel GX;

    public static class a<D> extends MutableLiveData<D> implements c.b<D> {
        private LifecycleOwner GW;
        final Bundle GY = null;
        final c<D> GZ;
        b<D> Ha;
        c<D> Hb;
        final int mId = 0;

        a(int i2, Bundle bundle, c<D> cVar) {
            this.GZ = cVar;
            this.Hb = null;
            this.GZ.registerListener(0, this);
        }

        @Override // android.arch.lifecycle.LiveData
        public final void onActive() {
            if (LoaderManagerImpl.DEBUG) {
                new StringBuilder("  Starting: ").append(this);
            }
            this.GZ.startLoading();
        }

        @Override // android.arch.lifecycle.LiveData
        public final void Z() {
            if (LoaderManagerImpl.DEBUG) {
                new StringBuilder("  Stopping: ").append(this);
            }
            this.GZ.stopLoading();
        }

        /* access modifiers changed from: package-private */
        public final c<D> a(LifecycleOwner lifecycleOwner, p.a<D> aVar) {
            b<D> bVar = new b<>(this.GZ, aVar);
            observe(lifecycleOwner, bVar);
            if (this.Ha != null) {
                removeObserver(this.Ha);
            }
            this.GW = lifecycleOwner;
            this.Ha = bVar;
            return this.GZ;
        }

        /* access modifiers changed from: package-private */
        public final void eq() {
            LifecycleOwner lifecycleOwner = this.GW;
            b<D> bVar = this.Ha;
            if (lifecycleOwner != null && bVar != null) {
                super.removeObserver(bVar);
                observe(lifecycleOwner, bVar);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: android.arch.lifecycle.Observer<? super D> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.arch.lifecycle.LiveData
        public final void removeObserver(Observer<? super D> observer) {
            super.removeObserver(observer);
            this.GW = null;
            this.Ha = null;
        }

        @Override // android.support.v4.content.c.b
        public final void m(D d2) {
            if (LoaderManagerImpl.DEBUG) {
                new StringBuilder("onLoadComplete: ").append(this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d2);
                return;
            }
            boolean z = LoaderManagerImpl.DEBUG;
            postValue(d2);
        }

        @Override // android.arch.lifecycle.LiveData, android.arch.lifecycle.MutableLiveData
        public final void setValue(D d2) {
            super.setValue(d2);
            if (this.Hb != null) {
                this.Hb.reset();
                this.Hb = null;
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.mId);
            sb.append(" : ");
            e.a(this.GZ, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* access modifiers changed from: package-private */
    public static class b<D> implements Observer<D> {
        final c<D> GZ;
        final p.a<D> Hc;
        boolean Hd = false;

        b(c<D> cVar, p.a<D> aVar) {
            this.GZ = cVar;
            this.Hc = aVar;
        }

        @Override // android.arch.lifecycle.Observer
        public final void onChanged(D d2) {
            if (LoaderManagerImpl.DEBUG) {
                new StringBuilder("  onLoadFinished in ").append(this.GZ).append(": ").append(this.GZ.dataToString(d2));
            }
            this.Hc.onLoadFinished(this.GZ, d2);
            this.Hd = true;
        }

        public final String toString() {
            return this.Hc.toString();
        }
    }

    /* access modifiers changed from: package-private */
    public static class LoaderViewModel extends ViewModel {
        private static final ViewModelProvider.Factory He = new ViewModelProvider.Factory() {
            /* class android.support.v4.app.LoaderManagerImpl.LoaderViewModel.AnonymousClass1 */

            @Override // android.arch.lifecycle.ViewModelProvider.Factory
            public final <T extends ViewModel> T create(Class<T> cls) {
                return new LoaderViewModel();
            }
        };
        o<a> Hf = new o<>();
        boolean Hg = false;

        LoaderViewModel() {
        }

        static LoaderViewModel a(ViewModelStore viewModelStore) {
            return (LoaderViewModel) new ViewModelProvider(viewModelStore, He).get(LoaderViewModel.class);
        }

        @Override // android.arch.lifecycle.ViewModel
        public void onCleared() {
            super.onCleared();
            int size = this.Hf.size();
            for (int i2 = 0; i2 < size; i2++) {
                a valueAt = this.Hf.valueAt(i2);
                if (LoaderManagerImpl.DEBUG) {
                    new StringBuilder("  Destroying: ").append(valueAt);
                }
                valueAt.GZ.cancelLoad();
                valueAt.GZ.abandon();
                b<D> bVar = valueAt.Ha;
                if (bVar != null) {
                    valueAt.removeObserver(bVar);
                    if (bVar.Hd) {
                        if (LoaderManagerImpl.DEBUG) {
                            new StringBuilder("  Resetting: ").append(bVar.GZ);
                        }
                        bVar.Hc.onLoaderReset(bVar.GZ);
                    }
                }
                valueAt.GZ.unregisterListener(valueAt);
                valueAt.GZ.reset();
            }
            this.Hf.clear();
        }
    }

    LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.GW = lifecycleOwner;
        this.GX = LoaderViewModel.a(viewModelStore);
    }

    /* JADX INFO: finally extract failed */
    private <D> c<D> b(p.a<D> aVar) {
        try {
            this.GX.Hg = true;
            c<D> onCreateLoader = aVar.onCreateLoader(0, null);
            if (onCreateLoader == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            } else if (!onCreateLoader.getClass().isMemberClass() || Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                a aVar2 = new a(0, null, onCreateLoader);
                if (DEBUG) {
                    new StringBuilder("  Created new loader ").append(aVar2);
                }
                this.GX.Hf.put(0, aVar2);
                this.GX.Hg = false;
                return aVar2.a(this.GW, aVar);
            } else {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: ".concat(String.valueOf(onCreateLoader)));
            }
        } catch (Throwable th) {
            this.GX.Hg = false;
            throw th;
        }
    }

    @Override // android.support.v4.app.p
    public final <D> c<D> a(p.a<D> aVar) {
        if (this.GX.Hg) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        } else {
            a aVar2 = this.GX.Hf.get(0, null);
            if (DEBUG) {
                new StringBuilder("initLoader in ").append(this).append(": args=").append((Object) null);
            }
            if (aVar2 == null) {
                return b(aVar);
            }
            if (DEBUG) {
                new StringBuilder("  Re-using existing loader ").append(aVar2);
            }
            return aVar2.a(this.GW, aVar);
        }
    }

    @Override // android.support.v4.app.p
    public final void eq() {
        LoaderViewModel loaderViewModel = this.GX;
        int size = loaderViewModel.Hf.size();
        for (int i2 = 0; i2 < size; i2++) {
            loaderViewModel.Hf.valueAt(i2).eq();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        e.a(this.GW, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // android.support.v4.app.p
    @Deprecated
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        LoaderViewModel loaderViewModel = this.GX;
        if (loaderViewModel.Hf.size() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < loaderViewModel.Hf.size(); i2++) {
                a valueAt = loaderViewModel.Hf.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(loaderViewModel.Hf.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                printWriter.print(str2);
                printWriter.print("mId=");
                printWriter.print(valueAt.mId);
                printWriter.print(" mArgs=");
                printWriter.println(valueAt.GY);
                printWriter.print(str2);
                printWriter.print("mLoader=");
                printWriter.println(valueAt.GZ);
                valueAt.GZ.dump(str2 + "  ", fileDescriptor, printWriter, strArr);
                if (valueAt.Ha != null) {
                    printWriter.print(str2);
                    printWriter.print("mCallbacks=");
                    printWriter.println(valueAt.Ha);
                    b<D> bVar = valueAt.Ha;
                    printWriter.print(str2 + "  ");
                    printWriter.print("mDeliveredData=");
                    printWriter.println(bVar.Hd);
                }
                printWriter.print(str2);
                printWriter.print("mData=");
                printWriter.println(valueAt.GZ.dataToString((D) valueAt.getValue()));
                printWriter.print(str2);
                printWriter.print("mStarted=");
                printWriter.println(valueAt.hasActiveObservers());
            }
        }
    }
}
