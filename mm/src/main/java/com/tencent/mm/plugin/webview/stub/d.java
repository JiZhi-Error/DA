package com.tencent.mm.plugin.webview.stub;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface d extends IInterface {
    Bundle getData();

    int getErrCode();

    String getErrMsg();

    int getErrType();

    int getType();

    public static abstract class a extends Binder implements d {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                    int type = getType();
                    parcel2.writeNoException();
                    parcel2.writeInt(type);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                    int errType = getErrType();
                    parcel2.writeNoException();
                    parcel2.writeInt(errType);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                    int errCode = getErrCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(errCode);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                    String errMsg = getErrMsg();
                    parcel2.writeNoException();
                    parcel2.writeString(errMsg);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                    Bundle data = getData();
                    parcel2.writeNoException();
                    if (data != null) {
                        parcel2.writeInt(1);
                        data.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.webview.stub.d$a$a  reason: collision with other inner class name */
        public static class C1971a implements d {
            public static d Jdb;
            private IBinder mRemote;

            C1971a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.webview.stub.d
            public final int getType() {
                AppMethodBeat.i(79252);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && a.gdV() != null) {
                        return a.gdV().getType();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79252);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79252);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.d
            public final int getErrType() {
                AppMethodBeat.i(79253);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && a.gdV() != null) {
                        return a.gdV().getErrType();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79253);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79253);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.d
            public final int getErrCode() {
                AppMethodBeat.i(79254);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && a.gdV() != null) {
                        return a.gdV().getErrCode();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79254);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79254);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.d
            public final String getErrMsg() {
                AppMethodBeat.i(79255);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && a.gdV() != null) {
                        return a.gdV().getErrMsg();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79255);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79255);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.d
            public final Bundle getData() {
                Bundle bundle;
                AppMethodBeat.i(79256);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || a.gdV() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                        } else {
                            bundle = null;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79256);
                    } else {
                        bundle = a.gdV().getData();
                    }
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79256);
                }
            }
        }

        public static d gdV() {
            return C1971a.Jdb;
        }
    }
}
