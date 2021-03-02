package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import org.json.JSONArray;
import org.json.JSONObject;

public class PathMoveToActionArg extends BasePathActionArg {
    public static final Parcelable.Creator<PathMoveToActionArg> CREATOR = new Parcelable.Creator<PathMoveToActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathMoveToActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PathMoveToActionArg[] newArray(int i2) {
            return new PathMoveToActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PathMoveToActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145299);
            PathMoveToActionArg pathMoveToActionArg = new PathMoveToActionArg(parcel);
            AppMethodBeat.o(145299);
            return pathMoveToActionArg;
        }
    };
    public float x;
    public float y;

    public PathMoveToActionArg() {
    }

    public PathMoveToActionArg(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145300);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.f(optJSONArray, 0);
        this.y = g.f(optJSONArray, 1);
        AppMethodBeat.o(145300);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg, com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145301);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        AppMethodBeat.o(145301);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145302);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        AppMethodBeat.o(145302);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145303);
        if (!super.equals(obj)) {
            AppMethodBeat.o(145303);
            return false;
        } else if (obj instanceof PathMoveToActionArg) {
            PathMoveToActionArg pathMoveToActionArg = (PathMoveToActionArg) obj;
            if (pathMoveToActionArg.x == this.x && pathMoveToActionArg.y == this.y) {
                AppMethodBeat.o(145303);
                return true;
            }
            AppMethodBeat.o(145303);
            return false;
        } else {
            AppMethodBeat.o(145303);
            return false;
        }
    }

    static {
        AppMethodBeat.i(145304);
        AppMethodBeat.o(145304);
    }
}
