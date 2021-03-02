package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;

public class RealSetStrokeStyleActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<RealSetStrokeStyleActionArg> CREATOR = new Parcelable.Creator<RealSetStrokeStyleActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RealSetStrokeStyleActionArg[] newArray(int i2) {
            return new RealSetStrokeStyleActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RealSetStrokeStyleActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145081);
            RealSetStrokeStyleActionArg realSetStrokeStyleActionArg = new RealSetStrokeStyleActionArg(parcel);
            AppMethodBeat.o(145081);
            return realSetStrokeStyleActionArg;
        }
    };

    public RealSetStrokeStyleActionArg() {
    }

    public RealSetStrokeStyleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public int describeContents() {
        return 0;
    }

    public void f(JSONArray jSONArray) {
    }

    static {
        AppMethodBeat.i(145082);
        AppMethodBeat.o(145082);
    }
}
