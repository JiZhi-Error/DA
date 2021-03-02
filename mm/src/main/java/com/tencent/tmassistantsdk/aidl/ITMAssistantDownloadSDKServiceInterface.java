package com.tencent.tmassistantsdk.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import java.util.Map;

public interface ITMAssistantDownloadSDKServiceInterface extends IInterface {
    void cancelDownloadTask(String str, String str2);

    TMAssistantDownloadTaskInfo getDownloadTaskInfo(String str, String str2);

    int getServiceVersion();

    boolean isAllDownloadFinished();

    void pauseDownloadTask(String str, String str2);

    void registerDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback);

    void setServiceSetingIsDownloadWifiOnly(boolean z);

    void setServiceSetingIsTaskAutoResume(boolean z);

    void setServiceSetingMaxTaskNum(int i2);

    int startDownloadTask(String str, String str2, String str3, long j2, int i2, String str4, String str5, Map map);

    void unregisterDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback);

    public static class Default implements ITMAssistantDownloadSDKServiceInterface {
        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public int getServiceVersion() {
            return 0;
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public void setServiceSetingIsTaskAutoResume(boolean z) {
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public void setServiceSetingIsDownloadWifiOnly(boolean z) {
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public void setServiceSetingMaxTaskNum(int i2) {
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public boolean isAllDownloadFinished() {
            return false;
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String str, String str2) {
            return null;
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public int startDownloadTask(String str, String str2, String str3, long j2, int i2, String str4, String str5, Map map) {
            return 0;
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public void pauseDownloadTask(String str, String str2) {
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public void cancelDownloadTask(String str, String str2) {
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public void registerDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback) {
        }

        @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
        public void unregisterDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback) {
        }

        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ITMAssistantDownloadSDKServiceInterface {
        private static final String DESCRIPTOR = "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface";
        static final int TRANSACTION_cancelDownloadTask = 9;
        static final int TRANSACTION_getDownloadTaskInfo = 6;
        static final int TRANSACTION_getServiceVersion = 1;
        static final int TRANSACTION_isAllDownloadFinished = 5;
        static final int TRANSACTION_pauseDownloadTask = 8;
        static final int TRANSACTION_registerDownloadTaskCallback = 10;
        static final int TRANSACTION_setServiceSetingIsDownloadWifiOnly = 3;
        static final int TRANSACTION_setServiceSetingIsTaskAutoResume = 2;
        static final int TRANSACTION_setServiceSetingMaxTaskNum = 4;
        static final int TRANSACTION_startDownloadTask = 7;
        static final int TRANSACTION_unregisterDownloadTaskCallback = 11;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITMAssistantDownloadSDKServiceInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITMAssistantDownloadSDKServiceInterface)) {
                return new Proxy(iBinder);
            }
            return (ITMAssistantDownloadSDKServiceInterface) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            int i4 = 0;
            boolean z = false;
            boolean z2 = false;
            switch (i2) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    int serviceVersion = getServiceVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(serviceVersion);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setServiceSetingIsTaskAutoResume(z);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        z2 = true;
                    }
                    setServiceSetingIsDownloadWifiOnly(z2);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    setServiceSetingMaxTaskNum(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isAllDownloadFinished = isAllDownloadFinished();
                    parcel2.writeNoException();
                    if (isAllDownloadFinished) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    TMAssistantDownloadTaskInfo downloadTaskInfo = getDownloadTaskInfo(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (downloadTaskInfo != null) {
                        parcel2.writeInt(1);
                        downloadTaskInfo.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    int startDownloadTask = startDownloadTask(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeInt(startDownloadTask);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    pauseDownloadTask(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    cancelDownloadTask(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerDownloadTaskCallback(parcel.readString(), ITMAssistantDownloadSDKServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterDownloadTaskCallback(parcel.readString(), ITMAssistantDownloadSDKServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
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
        public static class Proxy implements ITMAssistantDownloadSDKServiceInterface {
            public static ITMAssistantDownloadSDKServiceInterface sDefaultImpl;
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

            @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
            public int getServiceVersion() {
                AppMethodBeat.i(101842);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getServiceVersion();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101842);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101842);
                }
            }

            @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
            public void setServiceSetingIsTaskAutoResume(boolean z) {
                int i2 = 0;
                AppMethodBeat.i(101843);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(101843);
                        return;
                    }
                    Stub.getDefaultImpl().setServiceSetingIsTaskAutoResume(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101843);
                }
            }

            @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
            public void setServiceSetingIsDownloadWifiOnly(boolean z) {
                int i2 = 0;
                AppMethodBeat.i(101844);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(101844);
                        return;
                    }
                    Stub.getDefaultImpl().setServiceSetingIsDownloadWifiOnly(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101844);
                }
            }

            @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
            public void setServiceSetingMaxTaskNum(int i2) {
                AppMethodBeat.i(101845);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(101845);
                        return;
                    }
                    Stub.getDefaultImpl().setServiceSetingMaxTaskNum(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101845);
                }
            }

            @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
            public boolean isAllDownloadFinished() {
                boolean z = false;
                AppMethodBeat.i(101846);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(101846);
                    } else {
                        z = Stub.getDefaultImpl().isAllDownloadFinished();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101846);
                }
            }

            @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
            public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String str, String str2) {
                TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo;
                AppMethodBeat.i(101847);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            tMAssistantDownloadTaskInfo = TMAssistantDownloadTaskInfo.CREATOR.createFromParcel(obtain2);
                        } else {
                            tMAssistantDownloadTaskInfo = null;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(101847);
                    } else {
                        tMAssistantDownloadTaskInfo = Stub.getDefaultImpl().getDownloadTaskInfo(str, str2);
                    }
                    return tMAssistantDownloadTaskInfo;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101847);
                }
            }

            @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
            public int startDownloadTask(String str, String str2, String str3, long j2, int i2, String str4, String str5, Map map) {
                AppMethodBeat.i(101848);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeLong(j2);
                    obtain.writeInt(i2);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    obtain.writeMap(map);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().startDownloadTask(str, str2, str3, j2, i2, str4, str5, map);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101848);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101848);
                }
            }

            @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
            public void pauseDownloadTask(String str, String str2) {
                AppMethodBeat.i(101849);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(101849);
                        return;
                    }
                    Stub.getDefaultImpl().pauseDownloadTask(str, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101849);
                }
            }

            @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
            public void cancelDownloadTask(String str, String str2) {
                AppMethodBeat.i(101850);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(101850);
                        return;
                    }
                    Stub.getDefaultImpl().cancelDownloadTask(str, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101850);
                }
            }

            @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
            public void registerDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback) {
                AppMethodBeat.i(101851);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iTMAssistantDownloadSDKServiceCallback != null ? iTMAssistantDownloadSDKServiceCallback.asBinder() : null);
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(101851);
                        return;
                    }
                    Stub.getDefaultImpl().registerDownloadTaskCallback(str, iTMAssistantDownloadSDKServiceCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101851);
                }
            }

            @Override // com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
            public void unregisterDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback) {
                AppMethodBeat.i(101852);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iTMAssistantDownloadSDKServiceCallback != null ? iTMAssistantDownloadSDKServiceCallback.asBinder() : null);
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(101852);
                        return;
                    }
                    Stub.getDefaultImpl().unregisterDownloadTaskCallback(str, iTMAssistantDownloadSDKServiceCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101852);
                }
            }
        }

        public static boolean setDefaultImpl(ITMAssistantDownloadSDKServiceInterface iTMAssistantDownloadSDKServiceInterface) {
            if (Proxy.sDefaultImpl != null || iTMAssistantDownloadSDKServiceInterface == null) {
                return false;
            }
            Proxy.sDefaultImpl = iTMAssistantDownloadSDKServiceInterface;
            return true;
        }

        public static ITMAssistantDownloadSDKServiceInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
