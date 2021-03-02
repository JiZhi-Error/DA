package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import org.json.JSONArray;
import org.json.JSONObject;

public class PathLineToActionArg extends BasePathActionArg {
    public static final Parcelable.Creator<PathLineToActionArg> CREATOR = new Parcelable.Creator<PathLineToActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathLineToActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PathLineToActionArg[] newArray(int i2) {
            return new PathLineToActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PathLineToActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145293);
            PathLineToActionArg pathLineToActionArg = new PathLineToActionArg(parcel);
            AppMethodBeat.o(145293);
            return pathLineToActionArg;
        }
    };
    public float x;
    public float y;

    public PathLineToActionArg(Parcel parcel) {
        super(parcel);
    }

    public PathLineToActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145294);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.f(optJSONArray, 0);
        this.y = g.f(optJSONArray, 1);
        AppMethodBeat.o(145294);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg, com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145295);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        AppMethodBeat.o(145295);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145296);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        AppMethodBeat.o(145296);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145297);
        if (!super.equals(obj)) {
            AppMethodBeat.o(145297);
            return false;
        } else if (obj instanceof PathLineToActionArg) {
            PathLineToActionArg pathLineToActionArg = (PathLineToActionArg) obj;
            if (pathLineToActionArg.x == this.x && pathLineToActionArg.y == this.y) {
                AppMethodBeat.o(145297);
                return true;
            }
            AppMethodBeat.o(145297);
            return false;
        } else {
            AppMethodBeat.o(145297);
            return false;
        }
    }

    static {
        AppMethodBeat.i(145298);
        AppMethodBeat.o(145298);
    }
}
