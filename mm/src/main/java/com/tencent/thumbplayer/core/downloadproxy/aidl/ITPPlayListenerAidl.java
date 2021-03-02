package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

public interface ITPPlayListenerAidl extends IInterface {
    long getAdvRemainTime();

    String getContentType(int i2, String str);

    int getCurrentPlayClipNo();

    long getCurrentPosition();

    String getDataFilePath(int i2, String str);

    long getDataTotalSize(int i2, String str);

    String getPlayInfo(String str);

    long getPlayerBufferLength();

    void onDownloadCdnUrlExpired(Map map);

    void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4);

    void onDownloadCdnUrlUpdate(String str);

    void onDownloadError(int i2, int i3, String str);

    void onDownloadFinish();

    void onDownloadProgressUpdate(int i2, int i3, long j2, long j3, String str);

    void onDownloadProtocolUpdate(String str, String str2);

    void onDownloadStatusUpdate(int i2);

    int onPlayCallback(int i2, List list);

    int onReadData(int i2, String str, long j2, long j3);

    int onStartReadData(int i2, String str, long j2, long j3);

    int onStopReadData(int i2, String str, int i3);

    public static abstract class Stub extends Binder implements ITPPlayListenerAidl {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl";
        static final int TRANSACTION_getAdvRemainTime = 13;
        static final int TRANSACTION_getContentType = 20;
        static final int TRANSACTION_getCurrentPlayClipNo = 12;
        static final int TRANSACTION_getCurrentPosition = 11;
        static final int TRANSACTION_getDataFilePath = 19;
        static final int TRANSACTION_getDataTotalSize = 18;
        static final int TRANSACTION_getPlayInfo = 14;
        static final int TRANSACTION_getPlayerBufferLength = 10;
        static final int TRANSACTION_onDownloadCdnUrlExpired = 7;
        static final int TRANSACTION_onDownloadCdnUrlInfoUpdate = 6;
        static final int TRANSACTION_onDownloadCdnUrlUpdate = 5;
        static final int TRANSACTION_onDownloadError = 3;
        static final int TRANSACTION_onDownloadFinish = 2;
        static final int TRANSACTION_onDownloadProgressUpdate = 1;
        static final int TRANSACTION_onDownloadProtocolUpdate = 9;
        static final int TRANSACTION_onDownloadStatusUpdate = 8;
        static final int TRANSACTION_onPlayCallback = 4;
        static final int TRANSACTION_onReadData = 16;
        static final int TRANSACTION_onStartReadData = 15;
        static final int TRANSACTION_onStopReadData = 17;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITPPlayListenerAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITPPlayListenerAidl)) {
                return new Proxy(iBinder);
            }
            return (ITPPlayListenerAidl) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadProgressUpdate(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadFinish();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadError(parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    int onPlayCallback = onPlayCallback(parcel.readInt(), parcel.readArrayList(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeInt(onPlayCallback);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadCdnUrlUpdate(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadCdnUrlInfoUpdate(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadCdnUrlExpired(parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadStatusUpdate(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadProtocolUpdate(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    long playerBufferLength = getPlayerBufferLength();
                    parcel2.writeNoException();
                    parcel2.writeLong(playerBufferLength);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    long currentPosition = getCurrentPosition();
                    parcel2.writeNoException();
                    parcel2.writeLong(currentPosition);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    int currentPlayClipNo = getCurrentPlayClipNo();
                    parcel2.writeNoException();
                    parcel2.writeInt(currentPlayClipNo);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    long advRemainTime = getAdvRemainTime();
                    parcel2.writeNoException();
                    parcel2.writeLong(advRemainTime);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    String playInfo = getPlayInfo(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(playInfo);
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    int onStartReadData = onStartReadData(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(onStartReadData);
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    int onReadData = onReadData(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(onReadData);
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    int onStopReadData = onStopReadData(parcel.readInt(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(onStopReadData);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    long dataTotalSize = getDataTotalSize(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeLong(dataTotalSize);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    String dataFilePath = getDataFilePath(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(dataFilePath);
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    String contentType = getContentType(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(contentType);
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        static class Proxy implements ITPPlayListenerAidl {
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

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadProgressUpdate(int i2, int i3, long j2, long j3, String str) {
                AppMethodBeat.i(209848);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j2);
                    obtain.writeLong(j3);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209848);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadFinish() {
                AppMethodBeat.i(209849);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209849);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadError(int i2, int i3, String str) {
                AppMethodBeat.i(209850);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209850);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public int onPlayCallback(int i2, List list) {
                AppMethodBeat.i(209851);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeList(list);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209851);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadCdnUrlUpdate(String str) {
                AppMethodBeat.i(209852);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209852);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
                AppMethodBeat.i(209853);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209853);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadCdnUrlExpired(Map map) {
                AppMethodBeat.i(209854);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeMap(map);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209854);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadStatusUpdate(int i2) {
                AppMethodBeat.i(209855);
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
                    AppMethodBeat.o(209855);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadProtocolUpdate(String str, String str2) {
                AppMethodBeat.i(209856);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209856);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public long getPlayerBufferLength() {
                AppMethodBeat.i(209857);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209857);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public long getCurrentPosition() {
                AppMethodBeat.i(209858);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209858);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public int getCurrentPlayClipNo() {
                AppMethodBeat.i(209859);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209859);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public long getAdvRemainTime() {
                AppMethodBeat.i(209860);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209860);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public String getPlayInfo(String str) {
                AppMethodBeat.i(209861);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209861);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public int onStartReadData(int i2, String str, long j2, long j3) {
                AppMethodBeat.i(209862);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeLong(j2);
                    obtain.writeLong(j3);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209862);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public int onReadData(int i2, String str, long j2, long j3) {
                AppMethodBeat.i(209863);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeLong(j2);
                    obtain.writeLong(j3);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209863);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public int onStopReadData(int i2, String str, int i3) {
                AppMethodBeat.i(209864);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209864);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public long getDataTotalSize(int i2, String str) {
                AppMethodBeat.i(209865);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209865);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public String getDataFilePath(int i2, String str) {
                AppMethodBeat.i(209866);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209866);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public String getContentType(int i2, String str) {
                AppMethodBeat.i(209867);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(209867);
                }
            }
        }
    }
}
