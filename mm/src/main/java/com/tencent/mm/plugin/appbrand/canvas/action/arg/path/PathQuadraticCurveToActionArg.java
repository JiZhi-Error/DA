package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import org.json.JSONArray;
import org.json.JSONObject;

public class PathQuadraticCurveToActionArg extends BasePathActionArg {
    public static final Parcelable.Creator<PathQuadraticCurveToActionArg> CREATOR = new Parcelable.Creator<PathQuadraticCurveToActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathQuadraticCurveToActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PathQuadraticCurveToActionArg[] newArray(int i2) {
            return new PathQuadraticCurveToActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PathQuadraticCurveToActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145305);
            PathQuadraticCurveToActionArg pathQuadraticCurveToActionArg = new PathQuadraticCurveToActionArg(parcel);
            AppMethodBeat.o(145305);
            return pathQuadraticCurveToActionArg;
        }
    };
    public float x1;
    public float x2;
    public float y1;
    public float y2;

    public PathQuadraticCurveToActionArg(Parcel parcel) {
        super(parcel);
    }

    public PathQuadraticCurveToActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145306);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x1 = g.f(optJSONArray, 0);
        this.y1 = g.f(optJSONArray, 1);
        this.x2 = g.f(optJSONArray, 2);
        this.y2 = g.f(optJSONArray, 3);
        AppMethodBeat.o(145306);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg, com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145307);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.x1);
        parcel.writeFloat(this.y1);
        parcel.writeFloat(this.x2);
        parcel.writeFloat(this.y2);
        AppMethodBeat.o(145307);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145308);
        super.i(parcel);
        this.x1 = parcel.readFloat();
        this.y1 = parcel.readFloat();
        this.x2 = parcel.readFloat();
        this.y2 = parcel.readFloat();
        AppMethodBeat.o(145308);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145309);
        if (!super.equals(obj)) {
            AppMethodBeat.o(145309);
            return false;
        } else if (obj instanceof PathQuadraticCurveToActionArg) {
            PathQuadraticCurveToActionArg pathQuadraticCurveToActionArg = (PathQuadraticCurveToActionArg) obj;
            if (pathQuadraticCurveToActionArg.x1 == this.x1 && pathQuadraticCurveToActionArg.y1 == this.y1 && pathQuadraticCurveToActionArg.x2 == this.x2 && pathQuadraticCurveToActionArg.y2 == this.y2) {
                AppMethodBeat.o(145309);
                return true;
            }
            AppMethodBeat.o(145309);
            return false;
        } else {
            AppMethodBeat.o(145309);
            return false;
        }
    }

    static {
        AppMethodBeat.i(145310);
        AppMethodBeat.o(145310);
    }
}
