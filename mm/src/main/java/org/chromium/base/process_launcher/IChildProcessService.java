package org.chromium.base.process_launcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import org.chromium.base.process_launcher.ICallbackInt;

public interface IChildProcessService extends IInterface {
    boolean bindToCaller();

    void crashIntentionallyForTesting();

    void invokeMiscMethod(String str, Bundle bundle);

    void setupConnection(Bundle bundle, ICallbackInt iCallbackInt, List<IBinder> list);

    public static abstract class Stub extends Binder implements IChildProcessService {
        private static final String DESCRIPTOR = "org.chromium.base.process_launcher.IChildProcessService";
        static final int TRANSACTION_bindToCaller = 1;
        static final int TRANSACTION_crashIntentionallyForTesting = 3;
        static final int TRANSACTION_invokeMiscMethod = 4;
        static final int TRANSACTION_setupConnection = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IChildProcessService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IChildProcessService)) {
                return new Proxy(iBinder);
            }
            return (IChildProcessService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            Bundle bundle = null;
            switch (i2) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean bindToCaller = bindToCaller();
                    parcel2.writeNoException();
                    parcel2.writeInt(bindToCaller ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    setupConnection(bundle, ICallbackInt.Stub.asInterface(parcel.readStrongBinder()), parcel.createBinderArrayList());
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    crashIntentionallyForTesting();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
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

        static class Proxy implements IChildProcessService {
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

            @Override // org.chromium.base.process_launcher.IChildProcessService
            public boolean bindToCaller() {
                boolean z = true;
                AppMethodBeat.i(53742);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(53742);
                }
            }

            @Override // org.chromium.base.process_launcher.IChildProcessService
            public void setupConnection(Bundle bundle, ICallbackInt iCallbackInt, List<IBinder> list) {
                IBinder iBinder = null;
                AppMethodBeat.i(53743);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iCallbackInt != null) {
                        iBinder = iCallbackInt.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeBinderList(list);
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                    AppMethodBeat.o(53743);
                }
            }

            @Override // org.chromium.base.process_launcher.IChildProcessService
            public void crashIntentionallyForTesting() {
                AppMethodBeat.i(53744);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                    AppMethodBeat.o(53744);
                }
            }

            @Override // org.chromium.base.process_launcher.IChildProcessService
            public void invokeMiscMethod(String str, Bundle bundle) {
                AppMethodBeat.i(53745);
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
                    this.mRemote.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                    AppMethodBeat.o(53745);
                }
            }
        }
    }
}
