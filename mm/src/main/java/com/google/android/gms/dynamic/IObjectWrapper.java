package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface IObjectWrapper extends IInterface {

    public static abstract class Stub extends zzb implements IObjectWrapper {

        public static class Proxy extends zza implements IObjectWrapper {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public Stub() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static IObjectWrapper asInterface(IBinder iBinder) {
            AppMethodBeat.i(5416);
            if (iBinder == null) {
                AppMethodBeat.o(5416);
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof IObjectWrapper) {
                IObjectWrapper iObjectWrapper = (IObjectWrapper) queryLocalInterface;
                AppMethodBeat.o(5416);
                return iObjectWrapper;
            }
            Proxy proxy = new Proxy(iBinder);
            AppMethodBeat.o(5416);
            return proxy;
        }
    }
}
