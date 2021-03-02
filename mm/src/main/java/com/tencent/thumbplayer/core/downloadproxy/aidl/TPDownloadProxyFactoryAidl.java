package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl;

public interface TPDownloadProxyFactoryAidl extends IInterface {
    String getNativeVersion();

    ITPDownloadProxyAidl getTPDownloadProxy(int i2);

    boolean isReadyForDownload();

    boolean isReadyForPlay();

    public static abstract class Stub extends Binder implements TPDownloadProxyFactoryAidl {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl";
        static final int TRANSACTION_getNativeVersion = 4;
        static final int TRANSACTION_getTPDownloadProxy = 1;
        static final int TRANSACTION_isReadyForDownload = 3;
        static final int TRANSACTION_isReadyForPlay = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static TPDownloadProxyFactoryAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof TPDownloadProxyFactoryAidl)) {
                return new Proxy(iBinder);
            }
            return (TPDownloadProxyFactoryAidl) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            int i4 = 0;
            switch (i2) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    ITPDownloadProxyAidl tPDownloadProxy = getTPDownloadProxy(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(tPDownloadProxy != null ? tPDownloadProxy.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isReadyForPlay = isReadyForPlay();
                    parcel2.writeNoException();
                    if (isReadyForPlay) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isReadyForDownload = isReadyForDownload();
                    parcel2.writeNoException();
                    if (isReadyForDownload) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    String nativeVersion = getNativeVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(nativeVersion);
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        static class Proxy implements TPDownloadProxyFactoryAidl {
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

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
            public ITPDownloadProxyAidl getTPDownloadProxy(int i2) {
                AppMethodBeat.i(209877);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return ITPDownloadProxyAidl.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209877);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
            public boolean isReadyForPlay() {
                boolean z = false;
                AppMethodBeat.i(209878);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209878);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
            public boolean isReadyForDownload() {
                boolean z = false;
                AppMethodBeat.i(209879);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209879);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
            public String getNativeVersion() {
                AppMethodBeat.i(209880);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209880);
                }
            }
        }
    }
}
