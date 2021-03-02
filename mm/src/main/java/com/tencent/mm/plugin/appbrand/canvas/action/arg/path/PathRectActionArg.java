package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import org.json.JSONArray;
import org.json.JSONObject;

public class PathRectActionArg extends BasePathActionArg {
    public static final Parcelable.Creator<PathRectActionArg> CREATOR = new Parcelable.Creator<PathRectActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathRectActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PathRectActionArg[] newArray(int i2) {
            return new PathRectActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PathRectActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145311);
            PathRectActionArg pathRectActionArg = new PathRectActionArg(parcel);
            AppMethodBeat.o(145311);
            return pathRectActionArg;
        }
    };
    public float height;
    public float width;
    public float x;
    public float y;

    public PathRectActionArg(Parcel parcel) {
        super(parcel);
    }

    public PathRectActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145312);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.f(optJSONArray, 0);
        this.y = g.f(optJSONArray, 1);
        this.width = g.f(optJSONArray, 2);
        this.height = g.f(optJSONArray, 3);
        AppMethodBeat.o(145312);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg, com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145313);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        AppMethodBeat.o(145313);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145314);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.width = parcel.readFloat();
        this.height = parcel.readFloat();
        AppMethodBeat.o(145314);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145315);
        if (!super.equals(obj)) {
            AppMethodBeat.o(145315);
            return false;
        } else if (obj instanceof PathRectActionArg) {
            PathRectActionArg pathRectActionArg = (PathRectActionArg) obj;
            if (pathRectActionArg.x == this.x && pathRectActionArg.y == this.y && pathRectActionArg.width == this.width && pathRectActionArg.height == this.height) {
                AppMethodBeat.o(145315);
                return true;
            }
            AppMethodBeat.o(145315);
            return false;
        } else {
            AppMethodBeat.o(145315);
            return false;
        }
    }

    static {
        AppMethodBeat.i(145316);
        AppMethodBeat.o(145316);
    }
}
