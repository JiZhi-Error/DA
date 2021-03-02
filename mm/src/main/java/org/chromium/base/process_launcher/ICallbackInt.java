package org.chromium.base.process_launcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ICallbackInt extends IInterface {
    void call(int i2);

    void invokeMiscMethod(String str, Bundle bundle);

    public static abstract class Stub extends Binder implements ICallbackInt {
        private static final String DESCRIPTOR = "org.chromium.base.process_launcher.ICallbackInt";
        static final int TRANSACTION_call = 1;
        static final int TRANSACTION_invokeMiscMethod = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICallbackInt asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ICallbackInt)) {
                return new Proxy(iBinder);
            }
            return (ICallbackInt) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            Bundle bundle;
            switch (i2) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    call(parcel.readInt());
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    invokeMiscMethod(readString, bundle);
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        static class Proxy implements ICallbackInt {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // org.chromium.base.process_launcher.ICallbackInt
            public void call(int i2) {
                AppMethodBeat.i(53740);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                    AppMethodBeat.o(53740);
                }
            }

            @Override // org.chromium.base.process_launcher.ICallbackInt
            public void invokeMiscMethod(String str, Bundle bundle) {
                AppMethodBeat.i(53741);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                    AppMethodBeat.o(53741);
                }
            }
        }
    }
}
