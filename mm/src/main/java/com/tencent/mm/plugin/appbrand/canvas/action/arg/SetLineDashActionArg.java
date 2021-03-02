package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SetLineDashActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetLineDashActionArg> CREATOR = new Parcelable.Creator<SetLineDashActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineDashActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetLineDashActionArg[] newArray(int i2) {
            return new SetLineDashActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetLineDashActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145196);
            SetLineDashActionArg setLineDashActionArg = new SetLineDashActionArg(parcel);
            AppMethodBeat.o(145196);
            return setLineDashActionArg;
        }
    };
    public float[] kZL = null;
    public float kZM = Float.MIN_VALUE;

    public SetLineDashActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public SetLineDashActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145197);
        super.i(parcel);
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.kZL = new float[readInt];
            parcel.readFloatArray(this.kZL);
        }
        this.kZM = parcel.readFloat();
        AppMethodBeat.o(145197);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145198);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray.length() < 2) {
            AppMethodBeat.o(145198);
            return;
        }
        try {
            JSONArray jSONArray = optJSONArray.getJSONArray(0);
            if (jSONArray == null) {
                AppMethodBeat.o(145198);
                return;
            }
            this.kZL = new float[jSONArray.length()];
            for (int i2 = 0; i2 < this.kZL.length; i2++) {
                this.kZL[i2] = g.f(jSONArray, i2);
            }
            this.kZM = g.f(optJSONArray, 1);
            AppMethodBeat.o(145198);
        } catch (JSONException e2) {
            AppMethodBeat.o(145198);
        }
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145199);
        super.writeToParcel(parcel, i2);
        if (this.kZL != null) {
            parcel.writeInt(this.kZL.length);
            parcel.writeFloatArray(this.kZL);
        }
        parcel.writeFloat(this.kZM);
        AppMethodBeat.o(145199);
    }

    static {
        AppMethodBeat.i(145202);
        AppMethodBeat.o(145202);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145200);
        if (this == obj) {
            AppMethodBeat.o(145200);
            return true;
        } else if (!(obj instanceof SetLineDashActionArg)) {
            AppMethodBeat.o(145200);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145200);
            return false;
        } else {
            SetLineDashActionArg setLineDashActionArg = (SetLineDashActionArg) obj;
            if (Float.compare(setLineDashActionArg.kZM, this.kZM) != 0 || !Arrays.equals(this.kZL, setLineDashActionArg.kZL)) {
                AppMethodBeat.o(145200);
                return false;
            }
            AppMethodBeat.o(145200);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145201);
        int hash = (Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.kZM)) * 31) + Arrays.hashCode(this.kZL);
        AppMethodBeat.o(145201);
        return hash;
    }
}
