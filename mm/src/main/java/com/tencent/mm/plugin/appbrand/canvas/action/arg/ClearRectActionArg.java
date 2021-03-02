package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class ClearRectActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<ClearRectActionArg> CREATOR = new Parcelable.Creator<ClearRectActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.ClearRectActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ClearRectActionArg[] newArray(int i2) {
            return new ClearRectActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ClearRectActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(144992);
            ClearRectActionArg clearRectActionArg = new ClearRectActionArg(parcel);
            AppMethodBeat.o(144992);
            return clearRectActionArg;
        }
    };
    public float height;
    public float width;
    public float x;
    public float y;

    public ClearRectActionArg() {
    }

    public ClearRectActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(144993);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.width = parcel.readFloat();
        this.height = parcel.readFloat();
        AppMethodBeat.o(144993);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(144994);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        AppMethodBeat.o(144994);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(144995);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.f(optJSONArray, 0);
        this.y = g.f(optJSONArray, 1);
        this.width = g.f(optJSONArray, 2);
        this.height = g.f(optJSONArray, 3);
        AppMethodBeat.o(144995);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(144996);
        if (this == obj) {
            AppMethodBeat.o(144996);
            return true;
        } else if (!(obj instanceof ClearRectActionArg)) {
            AppMethodBeat.o(144996);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(144996);
            return false;
        } else {
            ClearRectActionArg clearRectActionArg = (ClearRectActionArg) obj;
            if (Float.compare(clearRectActionArg.x, this.x) == 0 && Float.compare(clearRectActionArg.y, this.y) == 0 && Float.compare(clearRectActionArg.width, this.width) == 0 && Float.compare(clearRectActionArg.height, this.height) == 0) {
                AppMethodBeat.o(144996);
                return true;
            }
            AppMethodBeat.o(144996);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(144997);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height));
        AppMethodBeat.o(144997);
        return hash;
    }

    static {
        AppMethodBeat.i(144998);
        AppMethodBeat.o(144998);
    }
}
