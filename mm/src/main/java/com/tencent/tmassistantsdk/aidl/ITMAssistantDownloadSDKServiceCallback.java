package com.tencent.tmassistantsdk.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ITMAssistantDownloadSDKServiceCallback extends IInterface {
    void OnDownloadSDKServiceTaskProgressChanged(String str, String str2, long j2, long j3);

    void OnDownloadSDKServiceTaskStateChanged(String str, String str2, int i2, int i3, String str3, boolean z, boolean z2);

    public static class Default implements ITMAssistantDownloadSDKServiceCallback {
        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback
        public void OnDownloadSDKServiceTaskStateChanged(String str, String str2, int i2, int i3, String str3, boolean z, boolean z2) {
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback
        public void OnDownloadSDKServiceTaskProgressChanged(String str, String str2, long j2, long j3) {
        }

        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ITMAssistantDownloadSDKServiceCallback {
        private static final String DESCRIPTOR = "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback";
        static final int TRANSACTION_OnDownloadSDKServiceTaskProgressChanged = 2;
        static final int TRANSACTION_OnDownloadSDKServiceTaskStateChanged = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITMAssistantDownloadSDKServiceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITMAssistantDownloadSDKServiceCallback)) {
                return new Proxy(iBinder);
            }
            return (ITMAssistantDownloadSDKServiceCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            boolean z;
            boolean z2;
            switch (i2) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    int readInt = parcel.readInt();
                    int readInt2 = parcel.readInt();
                    String readString3 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (parcel.readInt() != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    OnDownloadSDKServiceTaskStateChanged(readString, readString2, readInt, readInt2, readString3, z, z2);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    OnDownloadSDKServiceTaskProgressChanged(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        public static class Proxy implements ITMAssistantDownloadSDKServiceCallback {
            public static ITMAssistantDownloadSDKServiceCallback sDefaultImpl;
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

            @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback
            public void OnDownloadSDKServiceTaskStateChanged(String str, String str2, int i2, int i3, String str3, boolean z, boolean z2) {
                AppMethodBeat.i(101840);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str3);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(101840);
                        return;
                    }
                    Stub.getDefaultImpl().OnDownloadSDKServiceTaskStateChanged(str, str2, i2, i3, str3, z, z2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101840);
                }
            }

            @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback
            public void OnDownloadSDKServiceTaskProgressChanged(String str, String str2, long j2, long j3) {
                AppMethodBeat.i(101841);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j2);
                    obtain.writeLong(j3);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(101841);
                        return;
                    }
                    Stub.getDefaultImpl().OnDownloadSDKServiceTaskProgressChanged(str, str2, j2, j3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101841);
                }
            }
        }

        public static boolean setDefaultImpl(ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback) {
            if (Proxy.sDefaultImpl != null || iTMAssistantDownloadSDKServiceCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iTMAssistantDownloadSDKServiceCallback;
            return true;
        }

        public static ITMAssistantDownloadSDKServiceCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
