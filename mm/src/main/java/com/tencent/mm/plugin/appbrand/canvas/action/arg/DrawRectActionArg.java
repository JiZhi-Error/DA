package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawRectActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<DrawRectActionArg> CREATOR = new Parcelable.Creator<DrawRectActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawRectActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrawRectActionArg[] newArray(int i2) {
            return new DrawRectActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrawRectActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145022);
            DrawRectActionArg drawRectActionArg = new DrawRectActionArg(parcel);
            AppMethodBeat.o(145022);
            return drawRectActionArg;
        }
    };
    public float height;
    public float width;
    public float x;
    public float y;

    public DrawRectActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public DrawRectActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145023);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.width = parcel.readFloat();
        this.height = parcel.readFloat();
        AppMethodBeat.o(145023);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145024);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        AppMethodBeat.o(145024);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145025);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.f(optJSONArray, 0);
        this.y = g.f(optJSONArray, 1);
        this.width = g.f(optJSONArray, 2);
        this.height = g.f(optJSONArray, 3);
        AppMethodBeat.o(145025);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145026);
        if (this == obj) {
            AppMethodBeat.o(145026);
            return true;
        } else if (!(obj instanceof DrawRectActionArg)) {
            AppMethodBeat.o(145026);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145026);
            return false;
        } else {
            DrawRectActionArg drawRectActionArg = (DrawRectActionArg) obj;
            if (Float.compare(drawRectActionArg.x, this.x) == 0 && Float.compare(drawRectActionArg.y, this.y) == 0 && Float.compare(drawRectActionArg.width, this.width) == 0 && Float.compare(drawRectActionArg.height, this.height) == 0) {
                AppMethodBeat.o(145026);
                return true;
            }
            AppMethodBeat.o(145026);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145027);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height));
        AppMethodBeat.o(145027);
        return hash;
    }

    static {
        AppMethodBeat.i(145028);
        AppMethodBeat.o(145028);
    }
}
