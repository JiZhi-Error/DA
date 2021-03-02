package com.tencent.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface b extends IInterface {
    void onActionResult(byte[] bArr);

    public static abstract class a extends Binder implements b {
        private static final String DESCRIPTOR = "com.tencent.assistant.sdk.SDKActionCallback";
        static final int TRANSACTION_onActionResult = 1;

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static b asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0130a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    onActionResult(parcel.createByteArray());
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* renamed from: com.tencent.a.a.a.b$a$a  reason: collision with other inner class name */
        static class C0130a implements b {
            private IBinder mRemote;

            C0130a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.a.a.a.b
            public final void onActionResult(byte[] bArr) {
                AppMethodBeat.i(101839);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                    AppMethodBeat.o(101839);
                }
            }
        }
    }
}
