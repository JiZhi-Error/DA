package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.network.f;
import com.tencent.mm.network.i;
import com.tencent.mm.network.j;
import com.tencent.mm.network.k;
import com.tencent.mm.network.n;
import com.tencent.mm.network.q;
import com.tencent.mm.network.t;
import com.tencent.mm.network.u;
import com.tencent.mm.protocal.ab;
import java.util.ArrayList;
import java.util.List;

public interface h extends IInterface {
    void MH(String str);

    void MI(String str);

    void MJ(String str);

    int a(t tVar, n nVar);

    int a(String str, boolean z, List<String> list);

    int a(boolean z, List<String> list);

    void a(int i2, String str, int i3, boolean z);

    void a(b bVar);

    void a(i iVar);

    void a(j jVar);

    void a(q qVar);

    void a(u uVar);

    void a(ab abVar);

    void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i2, int i3, String str3, String str4);

    boolean aYT();

    void aZj();

    void aZk();

    String[] aZl();

    void addHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    void bK(String str, String str2);

    f bjw();

    void bjx();

    k bjy();

    void cancel(int i2);

    void d(String str, long j2, String str2);

    void d(String str, String str2, String str3, String str4);

    void fA(boolean z);

    void fB(boolean z);

    void forceUseV6(boolean z);

    void fy(boolean z);

    void fz(boolean z);

    int getHostByName(String str, List<String> list);

    String[] getIPsString(boolean z);

    String getIspId();

    String getNetworkServerIp();

    int i(int i2, byte[] bArr);

    void keepSignalling();

    void reportFailIp(String str);

    void reportV6Status(boolean z);

    void reset();

    void setDebugHost(String str);

    void setHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    void setNewDnsDebugHost(String str, String str2);

    void setSignallingStrategy(long j2, long j3);

    void stopSignalling();

    void switchProcessActiveState(boolean z);

    public static abstract class a extends Binder implements h {
        public a() {
            attachInterface(this, "com.tencent.mm.network.IDispatcher_AIDL");
        }

        public static h n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.network.IDispatcher_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof h)) {
                return new C0487a(iBinder);
            }
            return (h) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            j jVar = null;
            n aVar = null;
            IBinder iBinder = null;
            ab aVar2 = null;
            b aVar3 = null;
            IBinder iBinder2 = null;
            q aVar4 = null;
            u aVar5 = null;
            i aVar6 = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            int i4 = 0;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    t q = t.a.q(parcel.readStrongBinder());
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.network.IOnGYNetEnd_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof n)) {
                            aVar = new n.a.C0492a(readStrongBinder);
                        } else {
                            aVar = (n) queryLocalInterface;
                        }
                    }
                    int a2 = a(q, aVar);
                    parcel2.writeNoException();
                    parcel2.writeInt(a2);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    cancel(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    f bjw = bjw();
                    parcel2.writeNoException();
                    if (bjw != null) {
                        iBinder = bjw.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    reset();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    IBinder readStrongBinder2 = parcel.readStrongBinder();
                    if (readStrongBinder2 != null) {
                        IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                        if (queryLocalInterface2 == null || !(queryLocalInterface2 instanceof ab)) {
                            aVar2 = new ab.a.C2036a(readStrongBinder2);
                        } else {
                            aVar2 = (ab) queryLocalInterface2;
                        }
                    }
                    a(aVar2);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z2 = true;
                    }
                    a(z2, parcel.readString(), parcel.readString(), parcel.createIntArray(), parcel.createIntArray(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z3 = true;
                    }
                    String[] iPsString = getIPsString(z3);
                    parcel2.writeNoException();
                    parcel2.writeStringArray(iPsString);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    String networkServerIp = getNetworkServerIp();
                    parcel2.writeNoException();
                    parcel2.writeString(networkServerIp);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z4 = true;
                    }
                    fy(z4);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    d(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    setNewDnsDebugHost(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    bjx();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    boolean aYT = aYT();
                    parcel2.writeNoException();
                    if (aYT) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    IBinder readStrongBinder3 = parcel.readStrongBinder();
                    if (readStrongBinder3 != null) {
                        IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
                        if (queryLocalInterface3 == null || !(queryLocalInterface3 instanceof b)) {
                            aVar3 = new b.a.C0485a(readStrongBinder3);
                        } else {
                            aVar3 = (b) queryLocalInterface3;
                        }
                    }
                    a(aVar3);
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    MH(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    k bjy = bjy();
                    parcel2.writeNoException();
                    if (bjy != null) {
                        iBinder2 = bjy.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder2);
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    String readString = parcel.readString();
                    ArrayList arrayList = new ArrayList();
                    int hostByName = getHostByName(readString, arrayList);
                    parcel2.writeNoException();
                    parcel2.writeInt(hostByName);
                    parcel2.writeStringList(arrayList);
                    return true;
                case 18:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z5 = true;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int a3 = a(z5, arrayList2);
                    parcel2.writeNoException();
                    parcel2.writeInt(a3);
                    parcel2.writeStringList(arrayList2);
                    return true;
                case 19:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z6 = true;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    int a4 = a(readString2, z6, arrayList3);
                    parcel2.writeNoException();
                    parcel2.writeInt(a4);
                    parcel2.writeStringList(arrayList3);
                    return true;
                case 20:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    reportFailIp(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    setHostInfo(parcel.createStringArray(), parcel.createStringArray(), parcel.createIntArray());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    addHostInfo(parcel.createStringArray(), parcel.createStringArray(), parcel.createIntArray());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    int readInt = parcel.readInt();
                    String readString3 = parcel.readString();
                    int readInt2 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z7 = true;
                    }
                    a(readInt, readString3, readInt2, z7);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    d(parcel.readString(), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    aZj();
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    String ispId = getIspId();
                    parcel2.writeNoException();
                    parcel2.writeString(ispId);
                    return true;
                case 27:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    int i5 = i(parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(i5);
                    return true;
                case 28:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    setSignallingStrategy(parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    keepSignalling();
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    stopSignalling();
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    IBinder readStrongBinder4 = parcel.readStrongBinder();
                    if (readStrongBinder4 != null) {
                        IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.tencent.mm.network.IOnReportKV_AIDL");
                        if (queryLocalInterface4 == null || !(queryLocalInterface4 instanceof q)) {
                            aVar4 = new q.a.C0494a(readStrongBinder4);
                        } else {
                            aVar4 = (q) queryLocalInterface4;
                        }
                    }
                    a(aVar4);
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    IBinder readStrongBinder5 = parcel.readStrongBinder();
                    if (readStrongBinder5 != null) {
                        IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.tencent.mm.network.IWorkerCallback_AIDL");
                        if (queryLocalInterface5 == null || !(queryLocalInterface5 instanceof u)) {
                            aVar5 = new u.a.C0496a(readStrongBinder5);
                        } else {
                            aVar5 = (u) queryLocalInterface5;
                        }
                    }
                    a(aVar5);
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    IBinder readStrongBinder6 = parcel.readStrongBinder();
                    if (readStrongBinder6 != null) {
                        IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.tencent.mm.network.IIpxxCallback_AIDL");
                        if (queryLocalInterface6 == null || !(queryLocalInterface6 instanceof i)) {
                            aVar6 = new i.a.C0488a(readStrongBinder6);
                        } else {
                            aVar6 = (i) queryLocalInterface6;
                        }
                    }
                    a(aVar6);
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    MI(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z8 = true;
                    }
                    fz(z8);
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z9 = true;
                    }
                    fA(z9);
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z10 = true;
                    }
                    fB(z10);
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    aZk();
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    IBinder readStrongBinder7 = parcel.readStrongBinder();
                    if (readStrongBinder7 != null) {
                        IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
                        if (queryLocalInterface7 == null || !(queryLocalInterface7 instanceof j)) {
                            jVar = new j.a.C0489a(readStrongBinder7);
                        } else {
                            jVar = (j) queryLocalInterface7;
                        }
                    }
                    a(jVar);
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    MJ(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z11 = true;
                    }
                    reportV6Status(z11);
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z12 = true;
                    }
                    forceUseV6(z12);
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    switchProcessActiveState(z);
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    setDebugHost(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    bK(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 46:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    String[] aZl = aZl();
                    parcel2.writeNoException();
                    parcel2.writeStringArray(aZl);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IDispatcher_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.network.h$a$a  reason: collision with other inner class name */
        public static class C0487a implements h {
            public static h jDR;
            private IBinder mRemote;

            C0487a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.network.h
            public final int a(t tVar, n nVar) {
                IBinder iBinder = null;
                AppMethodBeat.i(132698);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(tVar != null ? tVar.asBinder() : null);
                    if (nVar != null) {
                        iBinder = nVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && a.bjz() != null) {
                        return a.bjz().a(tVar, nVar);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132698);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132698);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void cancel(int i2) {
                AppMethodBeat.i(132699);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132699);
                        return;
                    }
                    a.bjz().cancel(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132699);
                }
            }

            @Override // com.tencent.mm.network.h
            public final f bjw() {
                AppMethodBeat.i(132700);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && a.bjz() != null) {
                        return a.bjz().bjw();
                    }
                    obtain2.readException();
                    f m = f.a.m(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132700);
                    return m;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132700);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void reset() {
                AppMethodBeat.i(132701);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132701);
                        return;
                    }
                    a.bjz().reset();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132701);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void a(ab abVar) {
                AppMethodBeat.i(132702);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132702);
                        return;
                    }
                    a.bjz().a(abVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132702);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i2, int i3, String str3, String str4) {
                AppMethodBeat.i(132703);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeIntArray(iArr);
                    obtain.writeIntArray(iArr2);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132703);
                        return;
                    }
                    a.bjz().a(z, str, str2, iArr, iArr2, i2, i3, str3, str4);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132703);
                }
            }

            @Override // com.tencent.mm.network.h
            public final String[] getIPsString(boolean z) {
                int i2 = 0;
                AppMethodBeat.i(132704);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && a.bjz() != null) {
                        return a.bjz().getIPsString(z);
                    }
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132704);
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132704);
                }
            }

            @Override // com.tencent.mm.network.h
            public final String getNetworkServerIp() {
                AppMethodBeat.i(132705);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && a.bjz() != null) {
                        return a.bjz().getNetworkServerIp();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132705);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132705);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void fy(boolean z) {
                int i2 = 0;
                AppMethodBeat.i(132706);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132706);
                        return;
                    }
                    a.bjz().fy(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132706);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void d(String str, String str2, String str3, String str4) {
                AppMethodBeat.i(132707);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132707);
                        return;
                    }
                    a.bjz().d(str, str2, str3, str4);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132707);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void setNewDnsDebugHost(String str, String str2) {
                AppMethodBeat.i(132708);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132708);
                        return;
                    }
                    a.bjz().setNewDnsDebugHost(str, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132708);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void bjx() {
                AppMethodBeat.i(132709);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (this.mRemote.transact(12, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132709);
                        return;
                    }
                    a.bjz().bjx();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132709);
                }
            }

            @Override // com.tencent.mm.network.h
            public final boolean aYT() {
                boolean z = false;
                AppMethodBeat.i(132710);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (this.mRemote.transact(13, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132710);
                    } else {
                        z = a.bjz().aYT();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132710);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void a(b bVar) {
                AppMethodBeat.i(132711);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.mRemote.transact(14, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132711);
                        return;
                    }
                    a.bjz().a(bVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132711);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void MH(String str) {
                AppMethodBeat.i(132712);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(15, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132712);
                        return;
                    }
                    a.bjz().MH(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132712);
                }
            }

            @Override // com.tencent.mm.network.h
            public final k bjy() {
                AppMethodBeat.i(132713);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && a.bjz() != null) {
                        return a.bjz().bjy();
                    }
                    obtain2.readException();
                    k o = k.a.o(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132713);
                    return o;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132713);
                }
            }

            @Override // com.tencent.mm.network.h
            public final int getHostByName(String str, List<String> list) {
                AppMethodBeat.i(132714);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && a.bjz() != null) {
                        return a.bjz().getHostByName(str, list);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readStringList(list);
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132714);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132714);
                }
            }

            @Override // com.tencent.mm.network.h
            public final int a(boolean z, List<String> list) {
                int i2 = 0;
                AppMethodBeat.i(132715);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(18, obtain, obtain2, 0) && a.bjz() != null) {
                        return a.bjz().a(z, list);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readStringList(list);
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132715);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132715);
                }
            }

            @Override // com.tencent.mm.network.h
            public final int a(String str, boolean z, List<String> list) {
                int i2 = 0;
                AppMethodBeat.i(132716);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(19, obtain, obtain2, 0) && a.bjz() != null) {
                        return a.bjz().a(str, z, list);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readStringList(list);
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132716);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132716);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void reportFailIp(String str) {
                AppMethodBeat.i(132717);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(20, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132717);
                        return;
                    }
                    a.bjz().reportFailIp(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132717);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void setHostInfo(String[] strArr, String[] strArr2, int[] iArr) {
                AppMethodBeat.i(132718);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStringArray(strArr);
                    obtain.writeStringArray(strArr2);
                    obtain.writeIntArray(iArr);
                    if (this.mRemote.transact(21, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132718);
                        return;
                    }
                    a.bjz().setHostInfo(strArr, strArr2, iArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132718);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void addHostInfo(String[] strArr, String[] strArr2, int[] iArr) {
                AppMethodBeat.i(132719);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStringArray(strArr);
                    obtain.writeStringArray(strArr2);
                    obtain.writeIntArray(iArr);
                    if (this.mRemote.transact(22, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132719);
                        return;
                    }
                    a.bjz().addHostInfo(strArr, strArr2, iArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132719);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void a(int i2, String str, int i3, boolean z) {
                int i4 = 0;
                AppMethodBeat.i(132720);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    if (this.mRemote.transact(23, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132720);
                        return;
                    }
                    a.bjz().a(i2, str, i3, z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132720);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void d(String str, long j2, String str2) {
                AppMethodBeat.i(132721);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    obtain.writeLong(j2);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(24, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132721);
                        return;
                    }
                    a.bjz().d(str, j2, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132721);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void aZj() {
                AppMethodBeat.i(132722);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (this.mRemote.transact(25, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132722);
                        return;
                    }
                    a.bjz().aZj();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132722);
                }
            }

            @Override // com.tencent.mm.network.h
            public final String getIspId() {
                AppMethodBeat.i(132723);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (!this.mRemote.transact(26, obtain, obtain2, 0) && a.bjz() != null) {
                        return a.bjz().getIspId();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132723);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132723);
                }
            }

            @Override // com.tencent.mm.network.h
            public final int i(int i2, byte[] bArr) {
                AppMethodBeat.i(132724);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeByteArray(bArr);
                    if (!this.mRemote.transact(27, obtain, obtain2, 0) && a.bjz() != null) {
                        return a.bjz().i(i2, bArr);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132724);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132724);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void setSignallingStrategy(long j2, long j3) {
                AppMethodBeat.i(132725);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeLong(j2);
                    obtain.writeLong(j3);
                    if (this.mRemote.transact(28, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132725);
                        return;
                    }
                    a.bjz().setSignallingStrategy(j2, j3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132725);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void keepSignalling() {
                AppMethodBeat.i(132726);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (this.mRemote.transact(29, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132726);
                        return;
                    }
                    a.bjz().keepSignalling();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132726);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void stopSignalling() {
                AppMethodBeat.i(132727);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (this.mRemote.transact(30, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132727);
                        return;
                    }
                    a.bjz().stopSignalling();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132727);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void a(q qVar) {
                AppMethodBeat.i(132728);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(qVar != null ? qVar.asBinder() : null);
                    if (this.mRemote.transact(31, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132728);
                        return;
                    }
                    a.bjz().a(qVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132728);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void a(u uVar) {
                AppMethodBeat.i(132729);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(uVar != null ? uVar.asBinder() : null);
                    if (this.mRemote.transact(32, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132729);
                        return;
                    }
                    a.bjz().a(uVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132729);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void a(i iVar) {
                AppMethodBeat.i(132730);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    if (this.mRemote.transact(33, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132730);
                        return;
                    }
                    a.bjz().a(iVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132730);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void MI(String str) {
                AppMethodBeat.i(132731);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(34, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132731);
                        return;
                    }
                    a.bjz().MI(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132731);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void fz(boolean z) {
                int i2 = 0;
                AppMethodBeat.i(132732);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(35, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132732);
                        return;
                    }
                    a.bjz().fz(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132732);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void fA(boolean z) {
                int i2 = 0;
                AppMethodBeat.i(132733);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(36, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132733);
                        return;
                    }
                    a.bjz().fA(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132733);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void fB(boolean z) {
                int i2 = 0;
                AppMethodBeat.i(132734);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(37, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132734);
                        return;
                    }
                    a.bjz().fB(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132734);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void aZk() {
                AppMethodBeat.i(132735);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (this.mRemote.transact(38, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132735);
                        return;
                    }
                    a.bjz().aZk();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132735);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void a(j jVar) {
                AppMethodBeat.i(132736);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    if (this.mRemote.transact(39, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132736);
                        return;
                    }
                    a.bjz().a(jVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132736);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void MJ(String str) {
                AppMethodBeat.i(132737);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(40, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132737);
                        return;
                    }
                    a.bjz().MJ(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132737);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void reportV6Status(boolean z) {
                int i2 = 0;
                AppMethodBeat.i(176845);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(41, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(176845);
                        return;
                    }
                    a.bjz().reportV6Status(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(176845);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void forceUseV6(boolean z) {
                int i2 = 0;
                AppMethodBeat.i(176846);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(42, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(176846);
                        return;
                    }
                    a.bjz().forceUseV6(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(176846);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void switchProcessActiveState(boolean z) {
                int i2 = 0;
                AppMethodBeat.i(197093);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(43, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(197093);
                        return;
                    }
                    a.bjz().switchProcessActiveState(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197093);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void setDebugHost(String str) {
                AppMethodBeat.i(197094);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(44, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(197094);
                        return;
                    }
                    a.bjz().setDebugHost(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197094);
                }
            }

            @Override // com.tencent.mm.network.h
            public final void bK(String str, String str2) {
                AppMethodBeat.i(197095);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(45, obtain, obtain2, 0) || a.bjz() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(197095);
                        return;
                    }
                    a.bjz().bK(str, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197095);
                }
            }

            @Override // com.tencent.mm.network.h
            public final String[] aZl() {
                AppMethodBeat.i(197096);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (!this.mRemote.transact(46, obtain, obtain2, 0) && a.bjz() != null) {
                        return a.bjz().aZl();
                    }
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197096);
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197096);
                }
            }
        }

        public static h bjz() {
            return C0487a.jDR;
        }
    }
}
