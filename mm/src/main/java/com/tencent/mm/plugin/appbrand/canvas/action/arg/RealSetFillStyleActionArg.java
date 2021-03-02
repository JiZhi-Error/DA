package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;

public class RealSetFillStyleActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<RealSetFillStyleActionArg> CREATOR = new Parcelable.Creator<RealSetFillStyleActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RealSetFillStyleActionArg[] newArray(int i2) {
            return new RealSetFillStyleActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RealSetFillStyleActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145043);
            RealSetFillStyleActionArg realSetFillStyleActionArg = new RealSetFillStyleActionArg(parcel);
            AppMethodBeat.o(145043);
            return realSetFillStyleActionArg;
        }
    };

    public RealSetFillStyleActionArg() {
    }

    public RealSetFillStyleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public int describeContents() {
        return 0;
    }

    public void f(JSONArray jSONArray) {
    }

    static {
        AppMethodBeat.i(145044);
        AppMethodBeat.o(145044);
    }
}
