package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import org.json.JSONArray;
import org.json.JSONObject;

public class PathBezierCurveToActionArg extends BasePathActionArg {
    public static final Parcelable.Creator<PathBezierCurveToActionArg> CREATOR = new Parcelable.Creator<PathBezierCurveToActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathBezierCurveToActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PathBezierCurveToActionArg[] newArray(int i2) {
            return new PathBezierCurveToActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PathBezierCurveToActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145284);
            PathBezierCurveToActionArg pathBezierCurveToActionArg = new PathBezierCurveToActionArg(parcel);
            AppMethodBeat.o(145284);
            return pathBezierCurveToActionArg;
        }
    };
    public float x1;
    public float x2;
    public float x3;
    public float y1;
    public float y2;
    public float y3;

    public PathBezierCurveToActionArg(Parcel parcel) {
        super(parcel);
    }

    public PathBezierCurveToActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145285);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x1 = g.f(optJSONArray, 0);
        this.y1 = g.f(optJSONArray, 1);
        this.x2 = g.f(optJSONArray, 2);
        this.y2 = g.f(optJSONArray, 3);
        this.x3 = g.f(optJSONArray, 4);
        this.y3 = g.f(optJSONArray, 5);
        AppMethodBeat.o(145285);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg, com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145286);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.x1);
        parcel.writeFloat(this.y1);
        parcel.writeFloat(this.x2);
        parcel.writeFloat(this.y2);
        parcel.writeFloat(this.x2);
        parcel.writeFloat(this.y2);
        AppMethodBeat.o(145286);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145287);
        super.i(parcel);
        this.x1 = parcel.readFloat();
        this.y1 = parcel.readFloat();
        this.x2 = parcel.readFloat();
        this.y2 = parcel.readFloat();
        this.x3 = parcel.readFloat();
        this.y3 = parcel.readFloat();
        AppMethodBeat.o(145287);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145288);
        if (!super.equals(obj)) {
            AppMethodBeat.o(145288);
            return false;
        } else if (obj instanceof PathBezierCurveToActionArg) {
            PathBezierCurveToActionArg pathBezierCurveToActionArg = (PathBezierCurveToActionArg) obj;
            if (pathBezierCurveToActionArg.x1 == this.x1 && pathBezierCurveToActionArg.y1 == this.y1 && pathBezierCurveToActionArg.x2 == this.x2 && pathBezierCurveToActionArg.y2 == this.y2 && pathBezierCurveToActionArg.x3 == this.x3 && pathBezierCurveToActionArg.y3 == this.y3) {
                AppMethodBeat.o(145288);
                return true;
            }
            AppMethodBeat.o(145288);
            return false;
        } else {
            AppMethodBeat.o(145288);
            return false;
        }
    }

    static {
        AppMethodBeat.i(145289);
        AppMethodBeat.o(145289);
    }
}
