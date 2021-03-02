package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class FillRectActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<FillRectActionArg> CREATOR = new Parcelable.Creator<FillRectActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.FillRectActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FillRectActionArg[] newArray(int i2) {
            return new FillRectActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FillRectActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145036);
            FillRectActionArg fillRectActionArg = new FillRectActionArg(parcel);
            AppMethodBeat.o(145036);
            return fillRectActionArg;
        }
    };
    public float height;
    public float width;
    public float x;
    public float y;

    public FillRectActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public FillRectActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145037);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.width = parcel.readFloat();
        this.height = parcel.readFloat();
        AppMethodBeat.o(145037);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145038);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        AppMethodBeat.o(145038);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145039);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.f(optJSONArray, 0);
        this.y = g.f(optJSONArray, 1);
        this.width = g.f(optJSONArray, 2);
        this.height = g.f(optJSONArray, 3);
        AppMethodBeat.o(145039);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145040);
        if (this == obj) {
            AppMethodBeat.o(145040);
            return true;
        } else if (!(obj instanceof FillRectActionArg)) {
            AppMethodBeat.o(145040);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145040);
            return false;
        } else {
            FillRectActionArg fillRectActionArg = (FillRectActionArg) obj;
            if (Float.compare(fillRectActionArg.x, this.x) == 0 && Float.compare(fillRectActionArg.y, this.y) == 0 && Float.compare(fillRectActionArg.width, this.width) == 0 && Float.compare(fillRectActionArg.height, this.height) == 0) {
                AppMethodBeat.o(145040);
                return true;
            }
            AppMethodBeat.o(145040);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145041);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height));
        AppMethodBeat.o(145041);
        return hash;
    }

    static {
        AppMethodBeat.i(145042);
        AppMethodBeat.o(145042);
    }
}
