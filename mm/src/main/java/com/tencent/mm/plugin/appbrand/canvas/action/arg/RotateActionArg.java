package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class RotateActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<RotateActionArg> CREATOR = new Parcelable.Creator<RotateActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.RotateActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RotateActionArg[] newArray(int i2) {
            return new RotateActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RotateActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145110);
            RotateActionArg rotateActionArg = new RotateActionArg(parcel);
            AppMethodBeat.o(145110);
            return rotateActionArg;
        }
    };
    public float degrees;

    public RotateActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public RotateActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145111);
        super.i(parcel);
        this.degrees = parcel.readFloat();
        AppMethodBeat.o(145111);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145112);
        super.parse(jSONObject);
        this.degrees = (float) jSONObject.optJSONArray("data").optDouble(0);
        AppMethodBeat.o(145112);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145113);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.degrees);
        AppMethodBeat.o(145113);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145114);
        if (this == obj) {
            AppMethodBeat.o(145114);
            return true;
        } else if (!(obj instanceof RotateActionArg)) {
            AppMethodBeat.o(145114);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145114);
            return false;
        } else if (Float.compare(((RotateActionArg) obj).degrees, this.degrees) == 0) {
            AppMethodBeat.o(145114);
            return true;
        } else {
            AppMethodBeat.o(145114);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145115);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.degrees));
        AppMethodBeat.o(145115);
        return hash;
    }

    static {
        AppMethodBeat.i(145116);
        AppMethodBeat.o(145116);
    }
}
