package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class ScaleActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<ScaleActionArg> CREATOR = new Parcelable.Creator<ScaleActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.ScaleActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ScaleActionArg[] newArray(int i2) {
            return new ScaleActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ScaleActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145117);
            ScaleActionArg scaleActionArg = new ScaleActionArg(parcel);
            AppMethodBeat.o(145117);
            return scaleActionArg;
        }
    };
    public float kZA;
    public float kZB;

    public ScaleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public ScaleActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145118);
        super.i(parcel);
        this.kZA = parcel.readFloat();
        this.kZB = parcel.readFloat();
        AppMethodBeat.o(145118);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145119);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.kZA = (float) optJSONArray.optDouble(0);
        this.kZB = (float) optJSONArray.optDouble(1);
        AppMethodBeat.o(145119);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145120);
        if (this == obj) {
            AppMethodBeat.o(145120);
            return true;
        } else if (!(obj instanceof ScaleActionArg)) {
            AppMethodBeat.o(145120);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145120);
            return false;
        } else {
            ScaleActionArg scaleActionArg = (ScaleActionArg) obj;
            if (Float.compare(scaleActionArg.kZA, this.kZA) == 0 && Float.compare(scaleActionArg.kZB, this.kZB) == 0) {
                AppMethodBeat.o(145120);
                return true;
            }
            AppMethodBeat.o(145120);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145121);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.kZA), Float.valueOf(this.kZB));
        AppMethodBeat.o(145121);
        return hash;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145122);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.kZA);
        parcel.writeFloat(this.kZB);
        AppMethodBeat.o(145122);
    }

    static {
        AppMethodBeat.i(145123);
        AppMethodBeat.o(145123);
    }
}
