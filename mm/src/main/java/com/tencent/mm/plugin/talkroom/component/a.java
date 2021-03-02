package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.talkroom.component.b;
import com.tencent.mm.plugin.talkroom.component.c;
import com.tencent.mm.plugin.talkroom.component.d;
import com.tencent.mm.plugin.talkroom.component.e;

public interface a extends IInterface {
    int Close();

    int SetCurrentMicId(int i2);

    int a(b bVar, int i2, int i3, int i4, long j2, int[] iArr, int[] iArr2, int i5, String[] strArr);

    e a(c cVar);

    byte[] e(int[] iArr, String str);

    int ftD();

    d ftE();

    int uninitLive();

    /* renamed from: com.tencent.mm.plugin.talkroom.component.a$a  reason: collision with other inner class name */
    public static abstract class AbstractBinderC1793a extends Binder implements a {
        public AbstractBinderC1793a() {
            attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
        }

        public static a D(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C1794a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            c aVar;
            int[] iArr;
            b aVar2;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    int ftD = ftD();
                    parcel2.writeNoException();
                    parcel2.writeInt(ftD);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    int uninitLive = uninitLive();
                    parcel2.writeNoException();
                    parcel2.writeInt(uninitLive);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder == null) {
                        aVar2 = null;
                    } else {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                            aVar2 = new b.a.C1795a(readStrongBinder);
                        } else {
                            aVar2 = (b) queryLocalInterface;
                        }
                    }
                    int a2 = a(aVar2, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.createIntArray(), parcel.createIntArray(), parcel.readInt(), parcel.createStringArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(a2);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    int SetCurrentMicId = SetCurrentMicId(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(SetCurrentMicId);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    int Close = Close();
                    parcel2.writeNoException();
                    parcel2.writeInt(Close);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    int readInt = parcel.readInt();
                    if (readInt < 0) {
                        iArr = null;
                    } else {
                        iArr = new int[readInt];
                    }
                    byte[] e2 = e(iArr, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(e2);
                    parcel2.writeIntArray(iArr);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    IBinder readStrongBinder2 = parcel.readStrongBinder();
                    if (readStrongBinder2 == null) {
                        aVar = null;
                    } else {
                        IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
                        if (queryLocalInterface2 == null || !(queryLocalInterface2 instanceof c)) {
                            aVar = new c.a.C1796a(readStrongBinder2);
                        } else {
                            aVar = (c) queryLocalInterface2;
                        }
                    }
                    e a3 = a(aVar);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a3 != null ? a3.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    d ftE = ftE();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(ftE != null ? ftE.asBinder() : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.talkroom.component.a$a$a  reason: collision with other inner class name */
        public static class C1794a implements a {
            public static a FOT;
            private IBinder mRemote;

            C1794a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.talkroom.component.a
            public final int ftD() {
                AppMethodBeat.i(29373);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && AbstractBinderC1793a.ftF() != null) {
                        return AbstractBinderC1793a.ftF().ftD();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29373);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29373);
                }
            }

            @Override // com.tencent.mm.plugin.talkroom.component.a
            public final int uninitLive() {
                AppMethodBeat.i(29374);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && AbstractBinderC1793a.ftF() != null) {
                        return AbstractBinderC1793a.ftF().uninitLive();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29374);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29374);
                }
            }

            @Override // com.tencent.mm.plugin.talkroom.component.a
            public final int a(b bVar, int i2, int i3, int i4, long j2, int[] iArr, int[] iArr2, int i5, String[] strArr) {
                AppMethodBeat.i(29375);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeLong(j2);
                    obtain.writeIntArray(iArr);
                    obtain.writeIntArray(iArr2);
                    obtain.writeInt(i5);
                    obtain.writeStringArray(strArr);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && AbstractBinderC1793a.ftF() != null) {
                        return AbstractBinderC1793a.ftF().a(bVar, i2, i3, i4, j2, iArr, iArr2, i5, strArr);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29375);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29375);
                }
            }

            @Override // com.tencent.mm.plugin.talkroom.component.a
            public final int SetCurrentMicId(int i2) {
                AppMethodBeat.i(29376);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && AbstractBinderC1793a.ftF() != null) {
                        return AbstractBinderC1793a.ftF().SetCurrentMicId(i2);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29376);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29376);
                }
            }

            @Override // com.tencent.mm.plugin.talkroom.component.a
            public final int Close() {
                AppMethodBeat.i(29377);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && AbstractBinderC1793a.ftF() != null) {
                        return AbstractBinderC1793a.ftF().Close();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29377);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29377);
                }
            }

            @Override // com.tencent.mm.plugin.talkroom.component.a
            public final byte[] e(int[] iArr, String str) {
                AppMethodBeat.i(29378);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    if (iArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(iArr.length);
                    }
                    obtain.writeString(str);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && AbstractBinderC1793a.ftF() != null) {
                        return AbstractBinderC1793a.ftF().e(iArr, str);
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.readIntArray(iArr);
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29378);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29378);
                }
            }

            @Override // com.tencent.mm.plugin.talkroom.component.a
            public final e a(c cVar) {
                AppMethodBeat.i(29379);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && AbstractBinderC1793a.ftF() != null) {
                        return AbstractBinderC1793a.ftF().a(cVar);
                    }
                    obtain2.readException();
                    e F = e.a.F(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29379);
                    return F;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29379);
                }
            }

            @Override // com.tencent.mm.plugin.talkroom.component.a
            public final d ftE() {
                AppMethodBeat.i(29380);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && AbstractBinderC1793a.ftF() != null) {
                        return AbstractBinderC1793a.ftF().ftE();
                    }
                    obtain2.readException();
                    d E = d.a.E(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29380);
                    return E;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29380);
                }
            }
        }

        public static a ftF() {
            return C1794a.FOT;
        }
    }
}
