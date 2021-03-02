package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ICancelToken extends IInterface {

    public static abstract class Stub extends zzb implements ICancelToken {

        public static class Proxy extends zza implements ICancelToken {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.ICancelToken");
            }

            @Override // com.google.android.gms.common.internal.ICancelToken
            public void cancel() {
                AppMethodBeat.i(4689);
                transactOneway(2, obtainAndWriteInterfaceToken());
                AppMethodBeat.o(4689);
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.ICancelToken");
        }

        public static ICancelToken asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
            return queryLocalInterface instanceof ICancelToken ? (ICancelToken) queryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.stable.zzb
        public boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 != 2) {
                return false;
            }
            cancel();
            return true;
        }
    }

    void cancel();
}
