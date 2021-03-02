package com.tencent.mm.plugin.appbrand.canvas.action.arg.path;

import android.os.Parcel;
import com.tencent.mm.plugin.appbrand.ac.g;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class PathActionArg extends BasePathActionArg {
    public float kZU;
    public boolean kZV;
    public float mj;
    public float radius;
    public float x;
    public float y;

    public PathActionArg(Parcel parcel) {
        super(parcel);
    }

    public PathActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.f(optJSONArray, 0);
        this.y = g.f(optJSONArray, 1);
        this.radius = g.f(optJSONArray, 2);
        this.mj = (float) optJSONArray.optDouble(3);
        this.kZU = (float) optJSONArray.optDouble(4);
        this.kZV = optJSONArray.optBoolean(5);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg, com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.radius);
        parcel.writeFloat(this.mj);
        parcel.writeFloat(this.kZU);
        parcel.writeInt(this.kZV ? 1 : 0);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        boolean z = true;
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.radius = parcel.readFloat();
        this.mj = parcel.readFloat();
        this.kZU = parcel.readFloat();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.kZV = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof PathActionArg)) {
            return false;
        }
        PathActionArg pathActionArg = (PathActionArg) obj;
        if (pathActionArg.x == this.x && pathActionArg.y == this.y && pathActionArg.radius == this.radius && pathActionArg.mj == this.mj && pathActionArg.kZV == this.kZV) {
            return true;
        }
        return false;
    }
}
