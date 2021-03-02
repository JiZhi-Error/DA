package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;

public class BasePathActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<BasePathActionArg> CREATOR = new Parcelable.Creator<BasePathActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BasePathActionArg[] newArray(int i2) {
            return new BasePathActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BasePathActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145268);
            BasePathActionArg basePathActionArg = new BasePathActionArg(parcel);
            AppMethodBeat.o(145268);
            return basePathActionArg;
        }
    };

    public BasePathActionArg() {
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145269);
        super.writeToParcel(parcel, i2);
        AppMethodBeat.o(145269);
    }

    protected BasePathActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    static {
        AppMethodBeat.i(145270);
        AppMethodBeat.o(145270);
    }
}
