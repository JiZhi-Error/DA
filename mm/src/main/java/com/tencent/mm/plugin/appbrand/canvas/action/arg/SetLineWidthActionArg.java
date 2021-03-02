package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import java.util.Objects;
import org.json.JSONObject;

public class SetLineWidthActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetLineWidthActionArg> CREATOR = new Parcelable.Creator<SetLineWidthActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineWidthActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetLineWidthActionArg[] newArray(int i2) {
            return new SetLineWidthActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetLineWidthActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145210);
            SetLineWidthActionArg setLineWidthActionArg = new SetLineWidthActionArg(parcel);
            AppMethodBeat.o(145210);
            return setLineWidthActionArg;
        }
    };
    public float kZO;

    public SetLineWidthActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public SetLineWidthActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145211);
        super.i(parcel);
        this.kZO = parcel.readFloat();
        AppMethodBeat.o(145211);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145212);
        super.parse(jSONObject);
        this.kZO = g.f(jSONObject.optJSONArray("data"), 0);
        AppMethodBeat.o(145212);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145213);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.kZO);
        AppMethodBeat.o(145213);
    }

    static {
        AppMethodBeat.i(145216);
        AppMethodBeat.o(145216);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145214);
        if (this == obj) {
            AppMethodBeat.o(145214);
            return true;
        } else if (!(obj instanceof SetLineWidthActionArg)) {
            AppMethodBeat.o(145214);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145214);
            return false;
        } else if (Float.compare(((SetLineWidthActionArg) obj).kZO, this.kZO) == 0) {
            AppMethodBeat.o(145214);
            return true;
        } else {
            AppMethodBeat.o(145214);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145215);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.kZO));
        AppMethodBeat.o(145215);
        return hash;
    }
}
