package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;

public abstract class RemoteCreator<T> {
    private final String zzabo;
    private T zzabp;

    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    protected RemoteCreator(String str) {
        this.zzabo = str;
    }

    /* access modifiers changed from: protected */
    public abstract T getRemoteCreator(IBinder iBinder);

    /* access modifiers changed from: protected */
    public final T getRemoteCreatorInstance(Context context) {
        if (this.zzabp == null) {
            Preconditions.checkNotNull(context);
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext == null) {
                throw new RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.zzabp = getRemoteCreator((IBinder) remoteContext.getClassLoader().loadClass(this.zzabo).newInstance());
            } catch (ClassNotFoundException e2) {
                throw new RemoteCreatorException("Could not load creator class.", e2);
            } catch (InstantiationException e3) {
                throw new RemoteCreatorException("Could not instantiate creator.", e3);
            } catch (IllegalAccessException e4) {
                throw new RemoteCreatorException("Could not access creator.", e4);
            }
        }
        return this.zzabp;
    }
}
