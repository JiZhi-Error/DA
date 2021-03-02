package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl;
import java.util.Map;

public interface ITPDownloadProxyAidl extends IInterface {
    String getClipPlayUrl(int i2, int i3, int i4);

    String getPlayErrorCodeStr(int i2);

    String getPlayUrl(int i2, int i3);

    int init(String str);

    int pauseDownload(int i2);

    void pushEvent(int i2);

    int resumeDownload(int i2);

    boolean setClipInfo(int i2, int i3, String str, TPDownloadParamAidl tPDownloadParamAidl);

    void setMaxStorageSizeMB(long j2);

    void setPlayState(int i2, int i3);

    void setUserData(Map map);

    int startClipPlay(String str, int i2, ITPPlayListenerAidl iTPPlayListenerAidl);

    int startPlay(String str, TPDownloadParamAidl tPDownloadParamAidl, ITPPlayListenerAidl iTPPlayListenerAidl);

    int startPreload(String str, TPDownloadParamAidl tPDownloadParamAidl, ITPPreLoadListenerAidl iTPPreLoadListenerAidl);

    void stopPlay(int i2);

    void stopPreload(int i2);

    public static abstract class Stub extends Binder implements ITPDownloadProxyAidl {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl";
        static final int TRANSACTION_getClipPlayUrl = 6;
        static final int TRANSACTION_getPlayErrorCodeStr = 7;
        static final int TRANSACTION_getPlayUrl = 5;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_pauseDownload = 9;
        static final int TRANSACTION_pushEvent = 14;
        static final int TRANSACTION_resumeDownload = 10;
        static final int TRANSACTION_setClipInfo = 4;
        static final int TRANSACTION_setMaxStorageSizeMB = 16;
        static final int TRANSACTION_setPlayState = 15;
        static final int TRANSACTION_setUserData = 13;
        static final int TRANSACTION_startClipPlay = 3;
        static final int TRANSACTION_startPlay = 2;
        static final int TRANSACTION_startPreload = 11;
        static final int TRANSACTION_stopPlay = 8;
        static final int TRANSACTION_stopPreload = 12;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITPDownloadProxyAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITPDownloadProxyAidl)) {
                return new Proxy(iBinder);
            }
            return (ITPDownloadProxyAidl) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            TPDownloadParamAidl tPDownloadParamAidl = null;
            switch (i2) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    int init = init(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        tPDownloadParamAidl = TPDownloadParamAidl.CREATOR.createFromParcel(parcel);
                    }
                    int startPlay = startPlay(readString, tPDownloadParamAidl, ITPPlayListenerAidl.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(startPlay);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    int startClipPlay = startClipPlay(parcel.readString(), parcel.readInt(), ITPPlayListenerAidl.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(startClipPlay);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    int readInt = parcel.readInt();
                    int readInt2 = parcel.readInt();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        tPDownloadParamAidl = TPDownloadParamAidl.CREATOR.createFromParcel(parcel);
                    }
                    boolean clipInfo = setClipInfo(readInt, readInt2, readString2, tPDownloadParamAidl);
                    parcel2.writeNoException();
                    parcel2.writeInt(clipInfo ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    String playUrl = getPlayUrl(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(playUrl);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    String clipPlayUrl = getClipPlayUrl(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(clipPlayUrl);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    String playErrorCodeStr = getPlayErrorCodeStr(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(playErrorCodeStr);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    stopPlay(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    int pauseDownload = pauseDownload(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(pauseDownload);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    int resumeDownload = resumeDownload(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(resumeDownload);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    String readString3 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        tPDownloadParamAidl = TPDownloadParamAidl.CREATOR.createFromParcel(parcel);
                    }
                    int startPreload = startPreload(readString3, tPDownloadParamAidl, ITPPreLoadListenerAidl.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(startPreload);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    stopPreload(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    setUserData(parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    pushEvent(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    setPlayState(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMaxStorageSizeMB(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        static class Proxy implements ITPDownloadProxyAidl {
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

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public int init(String str) {
                AppMethodBeat.i(209832);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209832);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public int startPlay(String str, TPDownloadParamAidl tPDownloadParamAidl, ITPPlayListenerAidl iTPPlayListenerAidl) {
                AppMethodBeat.i(209833);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (tPDownloadParamAidl != null) {
                        obtain.writeInt(1);
                        tPDownloadParamAidl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTPPlayListenerAidl != null ? iTPPlayListenerAidl.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209833);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public int startClipPlay(String str, int i2, ITPPlayListenerAidl iTPPlayListenerAidl) {
                AppMethodBeat.i(209834);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iTPPlayListenerAidl != null ? iTPPlayListenerAidl.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209834);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public boolean setClipInfo(int i2, int i3, String str, TPDownloadParamAidl tPDownloadParamAidl) {
                boolean z = true;
                AppMethodBeat.i(209835);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (tPDownloadParamAidl != null) {
                        obtain.writeInt(1);
                        tPDownloadParamAidl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209835);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public String getPlayUrl(int i2, int i3) {
                AppMethodBeat.i(209836);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209836);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public String getClipPlayUrl(int i2, int i3, int i4) {
                AppMethodBeat.i(209837);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209837);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public String getPlayErrorCodeStr(int i2) {
                AppMethodBeat.i(209838);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209838);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public void stopPlay(int i2) {
                AppMethodBeat.i(209839);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209839);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public int pauseDownload(int i2) {
                AppMethodBeat.i(209840);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209840);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public int resumeDownload(int i2) {
                AppMethodBeat.i(209841);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209841);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public int startPreload(String str, TPDownloadParamAidl tPDownloadParamAidl, ITPPreLoadListenerAidl iTPPreLoadListenerAidl) {
                AppMethodBeat.i(209842);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (tPDownloadParamAidl != null) {
                        obtain.writeInt(1);
                        tPDownloadParamAidl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTPPreLoadListenerAidl != null ? iTPPreLoadListenerAidl.asBinder() : null);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209842);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public void stopPreload(int i2) {
                AppMethodBeat.i(209843);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209843);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public void setUserData(Map map) {
                AppMethodBeat.i(209844);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeMap(map);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209844);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public void pushEvent(int i2) {
                AppMethodBeat.i(209845);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209845);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public void setPlayState(int i2, int i3) {
                AppMethodBeat.i(209846);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209846);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public void setMaxStorageSizeMB(long j2) {
                AppMethodBeat.i(209847);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j2);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209847);
                }
            }
        }
    }
}
