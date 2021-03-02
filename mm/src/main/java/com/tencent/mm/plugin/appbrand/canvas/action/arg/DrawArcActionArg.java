package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawArcActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<DrawArcActionArg> CREATOR = new Parcelable.Creator<DrawArcActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawArcActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrawArcActionArg[] newArray(int i2) {
            return new DrawArcActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrawArcActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145008);
            DrawArcActionArg drawArcActionArg = new DrawArcActionArg(parcel);
            AppMethodBeat.o(145008);
            return drawArcActionArg;
        }
    };
    public float mj;
    public float mk;
    public float radius;
    public float x;
    public float y;

    public DrawArcActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public DrawArcActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145009);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.radius = parcel.readFloat();
        this.mj = parcel.readFloat();
        this.mk = parcel.readFloat();
        AppMethodBeat.o(145009);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145010);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.f(optJSONArray, 0);
        this.y = g.f(optJSONArray, 1);
        this.radius = g.f(optJSONArray, 2);
        this.mj = (float) optJSONArray.optDouble(3);
        this.mk = (float) optJSONArray.optDouble(4);
        AppMethodBeat.o(145010);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145011);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.radius);
        parcel.writeFloat(this.mj);
        parcel.writeFloat(this.mk);
        AppMethodBeat.o(145011);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145012);
        if (this == obj) {
            AppMethodBeat.o(145012);
            return true;
        } else if (!(obj instanceof DrawArcActionArg)) {
            AppMethodBeat.o(145012);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145012);
            return false;
        } else {
            DrawArcActionArg drawArcActionArg = (DrawArcActionArg) obj;
            if (Float.compare(drawArcActionArg.x, this.x) == 0 && Float.compare(drawArcActionArg.y, this.y) == 0 && Float.compare(drawArcActionArg.radius, this.radius) == 0 && Float.compare(drawArcActionArg.mj, this.mj) == 0 && Float.compare(drawArcActionArg.mk, this.mk) == 0) {
                AppMethodBeat.o(145012);
                return true;
            }
            AppMethodBeat.o(145012);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145013);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.radius), Float.valueOf(this.mj), Float.valueOf(this.mk));
        AppMethodBeat.o(145013);
        return hash;
    }

    static {
        AppMethodBeat.i(145014);
        AppMethodBeat.o(145014);
    }
}
