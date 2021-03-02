package com.tencent.mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.protocal.protobuf.ys;
import java.util.Locale;

public final class AppRuntimeApiPermissionBundle implements Parcelable, m {
    public static final Parcelable.Creator<AppRuntimeApiPermissionBundle> CREATOR = new Parcelable.Creator<AppRuntimeApiPermissionBundle>() {
        /* class com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppRuntimeApiPermissionBundle[] newArray(int i2) {
            return new AppRuntimeApiPermissionBundle[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppRuntimeApiPermissionBundle createFromParcel(Parcel parcel) {
            AppMethodBeat.i(147634);
            AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle = new AppRuntimeApiPermissionBundle(parcel, (byte) 0);
            AppMethodBeat.o(147634);
            return appRuntimeApiPermissionBundle;
        }
    };
    public final byte[] nxk;
    public final byte[] nxl;
    final byte[] nxm;

    /* synthetic */ AppRuntimeApiPermissionBundle(Parcel parcel, byte b2) {
        this(parcel);
    }

    public AppRuntimeApiPermissionBundle(ys ysVar) {
        AppMethodBeat.i(147635);
        this.nxk = ysVar.LjS.zy;
        this.nxl = ysVar.LjT.get(0).zy;
        this.nxm = ysVar.LjT.get(1).zy;
        AppMethodBeat.o(147635);
    }

    public final String toString() {
        AppMethodBeat.i(147636);
        String format = String.format(Locale.US, "PermissionBundle[%d][%d][%d]", Integer.valueOf(this.nxk.length), Integer.valueOf(this.nxl.length), Integer.valueOf(this.nxm.length));
        AppMethodBeat.o(147636);
        return format;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(147637);
        parcel.writeByteArray(this.nxk);
        parcel.writeByteArray(this.nxl);
        parcel.writeByteArray(this.nxm);
        AppMethodBeat.o(147637);
    }

    private AppRuntimeApiPermissionBundle(Parcel parcel) {
        AppMethodBeat.i(147638);
        this.nxk = parcel.createByteArray();
        this.nxl = parcel.createByteArray();
        this.nxm = parcel.createByteArray();
        AppMethodBeat.o(147638);
    }

    static {
        AppMethodBeat.i(147639);
        AppMethodBeat.o(147639);
    }
}
