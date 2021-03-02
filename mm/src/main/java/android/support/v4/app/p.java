package android.support.v4.app;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.os.Bundle;
import android.support.v4.content.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class p {

    public interface a<D> {
        c<D> onCreateLoader(int i2, Bundle bundle);

        void onLoadFinished(c<D> cVar, D d2);

        void onLoaderReset(c<D> cVar);
    }

    public abstract <D> c<D> a(a<D> aVar);

    @Deprecated
    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void eq();

    public static <T extends LifecycleOwner & ViewModelStoreOwner> p d(T t) {
        return new LoaderManagerImpl(t, t.getViewModelStore());
    }
}
