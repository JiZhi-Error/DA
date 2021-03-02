package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetShadowActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetShadowActionArg> CREATOR = new Parcelable.Creator<SetShadowActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetShadowActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetShadowActionArg[] newArray(int i2) {
            return new SetShadowActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetShadowActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145224);
            SetShadowActionArg setShadowActionArg = new SetShadowActionArg(parcel);
            AppMethodBeat.o(145224);
            return setShadowActionArg;
        }
    };
    public int color;
    public float kZP;
    public float x;
    public float y;

    public SetShadowActionArg() {
    }

    public SetShadowActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145225);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.kZP = parcel.readFloat();
        this.color = parcel.readInt();
        AppMethodBeat.o(145225);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145226);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.kZP);
        parcel.writeInt(this.color);
        AppMethodBeat.o(145226);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145227);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        optJSONArray.length();
        this.x = g.f(optJSONArray, 0);
        this.y = g.f(optJSONArray, 1);
        this.kZP = g.f(optJSONArray, 2);
        JSONArray optJSONArray2 = optJSONArray.optJSONArray(3);
        if (optJSONArray2 == null || optJSONArray2.length() < 4) {
            AppMethodBeat.o(145227);
            return;
        }
        this.color = g.r(optJSONArray2);
        AppMethodBeat.o(145227);
    }

    static {
        AppMethodBeat.i(145230);
        AppMethodBeat.o(145230);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145228);
        if (this == obj) {
            AppMethodBeat.o(145228);
            return true;
        } else if (!(obj instanceof SetShadowActionArg)) {
            AppMethodBeat.o(145228);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145228);
            return false;
        } else {
            SetShadowActionArg setShadowActionArg = (SetShadowActionArg) obj;
            if (Float.compare(setShadowActionArg.x, this.x) == 0 && Float.compare(setShadowActionArg.y, this.y) == 0 && Float.compare(setShadowActionArg.kZP, this.kZP) == 0 && this.color == setShadowActionArg.color) {
                AppMethodBeat.o(145228);
                return true;
            }
            AppMethodBeat.o(145228);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145229);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.kZP), Integer.valueOf(this.color));
        AppMethodBeat.o(145229);
        return hash;
    }
}
