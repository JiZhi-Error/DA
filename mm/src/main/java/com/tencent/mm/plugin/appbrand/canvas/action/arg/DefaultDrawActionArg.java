package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DefaultDrawActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<DefaultDrawActionArg> CREATOR = new Parcelable.Creator<DefaultDrawActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.DefaultDrawActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DefaultDrawActionArg[] newArray(int i2) {
            return new DefaultDrawActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DefaultDrawActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(144999);
            DefaultDrawActionArg defaultDrawActionArg = new DefaultDrawActionArg(parcel);
            AppMethodBeat.o(144999);
            return defaultDrawActionArg;
        }
    };

    public DefaultDrawActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public DefaultDrawActionArg() {
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(145000);
        AppMethodBeat.o(145000);
    }
}
