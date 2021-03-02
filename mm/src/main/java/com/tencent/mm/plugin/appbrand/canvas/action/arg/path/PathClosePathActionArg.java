package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class PathClosePathActionArg extends BasePathActionArg {
    public static final Parcelable.Creator<PathClosePathActionArg> CREATOR = new Parcelable.Creator<PathClosePathActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathClosePathActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PathClosePathActionArg[] newArray(int i2) {
            return new PathClosePathActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PathClosePathActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145290);
            PathClosePathActionArg pathClosePathActionArg = new PathClosePathActionArg(parcel);
            AppMethodBeat.o(145290);
            return pathClosePathActionArg;
        }
    };

    public PathClosePathActionArg(Parcel parcel) {
        super(parcel);
    }

    public PathClosePathActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145291);
        super.parse(jSONObject);
        AppMethodBeat.o(145291);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg
    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(145292);
        AppMethodBeat.o(145292);
    }
}
