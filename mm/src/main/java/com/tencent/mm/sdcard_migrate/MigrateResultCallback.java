package com.tencent.mm.sdcard_migrate;

import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdcard_migrate.d;
import com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException;

public abstract class MigrateResultCallback extends d.a implements Parcelable {
    public static final Parcelable.Creator<MigrateResultCallback> CREATOR = new Parcelable.Creator<MigrateResultCallback>() {
        /* class com.tencent.mm.sdcard_migrate.MigrateResultCallback.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MigrateResultCallback[] newArray(int i2) {
            return new MigrateResultCallback[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MigrateResultCallback createFromParcel(Parcel parcel) {
            AppMethodBeat.i(204646);
            MigrateResultCallback migrateResultCallback = (MigrateResultCallback) d.a.M(parcel.readStrongBinder());
            AppMethodBeat.o(204646);
            return migrateResultCallback;
        }
    };
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* access modifiers changed from: protected */
    public abstract void a(int i2, ExtStorageMigrateException extStorageMigrateException);

    /* access modifiers changed from: protected */
    public abstract void ajC(int i2);

    /* access modifiers changed from: protected */
    public abstract void ajD(int i2);

    /* access modifiers changed from: protected */
    public abstract void gwH();

    /* access modifiers changed from: protected */
    public abstract void gwI();

    /* access modifiers changed from: protected */
    public abstract void kI(int i2, int i3);

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongBinder(asBinder());
    }

    @Override // com.tencent.mm.sdcard_migrate.d
    public final void ajH(final int i2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ajC(i2);
        } else {
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.sdcard_migrate.MigrateResultCallback.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(204647);
                    MigrateResultCallback.this.ajC(i2);
                    AppMethodBeat.o(204647);
                }
            });
        }
    }

    @Override // com.tencent.mm.sdcard_migrate.d
    public final void mN(final String str, final String str2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            gwH();
        } else {
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.sdcard_migrate.MigrateResultCallback.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(204648);
                    MigrateResultCallback.this.gwH();
                    AppMethodBeat.o(204648);
                }
            });
        }
    }

    @Override // com.tencent.mm.sdcard_migrate.d
    public final void ajI(final int i2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ajD(i2);
        } else {
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.sdcard_migrate.MigrateResultCallback.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(204649);
                    MigrateResultCallback.this.ajD(i2);
                    AppMethodBeat.o(204649);
                }
            });
        }
    }

    @Override // com.tencent.mm.sdcard_migrate.d
    public final void b(final int i2, final ExtStorageMigrateException extStorageMigrateException) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a(i2, extStorageMigrateException);
        } else {
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.sdcard_migrate.MigrateResultCallback.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(204650);
                    MigrateResultCallback.this.a(i2, extStorageMigrateException);
                    AppMethodBeat.o(204650);
                }
            });
        }
    }

    @Override // com.tencent.mm.sdcard_migrate.d
    public final void gxi() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            gwI();
        } else {
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.sdcard_migrate.MigrateResultCallback.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(204651);
                    MigrateResultCallback.this.gwI();
                    AppMethodBeat.o(204651);
                }
            });
        }
    }

    @Override // com.tencent.mm.sdcard_migrate.d
    public final void kJ(final int i2, final int i3) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            kI(i2, i3);
        } else {
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.sdcard_migrate.MigrateResultCallback.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(204652);
                    MigrateResultCallback.this.kI(i2, i3);
                    AppMethodBeat.o(204652);
                }
            });
        }
    }
}
