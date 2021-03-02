package org.chromium.content.common;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.chromium.base.UnguessableToken;

public interface IGpuProcessCallback extends IInterface {
    void forwardSurfaceForSurfaceRequest(UnguessableToken unguessableToken, Surface surface);

    SurfaceWrapper getViewSurface(int i2);

    void invokeMiscMethod(String str, Bundle bundle);

    public static abstract class Stub extends Binder implements IGpuProcessCallback {
        private static final String DESCRIPTOR = "org.chromium.content.common.IGpuProcessCallback";
        static final int TRANSACTION_forwardSurfaceForSurfaceRequest = 1;
        static final int TRANSACTION_getViewSurface = 2;
        static final int TRANSACTION_invokeMiscMethod = 3;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGpuProcessCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IGpuProcessCallback)) {
                return new Proxy(iBinder);
            }
            return (IGpuProcessCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            Bundle bundle;
            UnguessableToken unguessableToken;
            Surface surface;
            switch (i2) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        unguessableToken = UnguessableToken.CREATOR.createFromParcel(parcel);
                    } else {
                        unguessableToken = null;
                    }
                    if (parcel.readInt() != 0) {
                        surface = (Surface) Surface.CREATOR.createFromParcel(parcel);
                    } else {
                        surface = null;
                    }
                    forwardSurfaceForSurfaceRequest(unguessableToken, surface);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    SurfaceWrapper viewSurface = getViewSurface(parcel.readInt());
                    parcel2.writeNoException();
                    if (viewSurface != null) {
                        parcel2.writeInt(1);
                        viewSurface.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 3:
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

        /* access modifiers changed from: package-private */
        public static class Proxy implements IGpuProcessCallback {
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

            @Override // org.chromium.content.common.IGpuProcessCallback
            public void forwardSurfaceForSurfaceRequest(UnguessableToken unguessableToken, Surface surface) {
                AppMethodBeat.i(53752);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (unguessableToken != null) {
                        obtain.writeInt(1);
                        unguessableToken.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                    AppMethodBeat.o(53752);
                }
            }

            @Override // org.chromium.content.common.IGpuProcessCallback
            public SurfaceWrapper getViewSurface(int i2) {
                SurfaceWrapper surfaceWrapper;
                AppMethodBeat.i(53753);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        surfaceWrapper = SurfaceWrapper.CREATOR.createFromParcel(obtain2);
                    } else {
                        surfaceWrapper = null;
                    }
                    return surfaceWrapper;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(53753);
                }
            }

            @Override // org.chromium.content.common.IGpuProcessCallback
            public void invokeMiscMethod(String str, Bundle bundle) {
                AppMethodBeat.i(53754);
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
                    this.mRemote.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                    AppMethodBeat.o(53754);
                }
            }
        }
    }
}
