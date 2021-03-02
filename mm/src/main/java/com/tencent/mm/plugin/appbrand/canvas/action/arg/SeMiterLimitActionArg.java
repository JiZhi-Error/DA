package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SeMiterLimitActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SeMiterLimitActionArg> CREATOR = new Parcelable.Creator<SeMiterLimitActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SeMiterLimitActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SeMiterLimitActionArg[] newArray(int i2) {
            return new SeMiterLimitActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SeMiterLimitActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145124);
            SeMiterLimitActionArg seMiterLimitActionArg = new SeMiterLimitActionArg(parcel);
            AppMethodBeat.o(145124);
            return seMiterLimitActionArg;
        }
    };
    public float kZI;

    public SeMiterLimitActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public SeMiterLimitActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145125);
        super.i(parcel);
        this.kZI = parcel.readFloat();
        AppMethodBeat.o(145125);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145126);
        super.parse(jSONObject);
        this.kZI = (float) jSONObject.optJSONArray("data").optDouble(0);
        AppMethodBeat.o(145126);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145127);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.kZI);
        AppMethodBeat.o(145127);
    }

    static {
        AppMethodBeat.i(145130);
        AppMethodBeat.o(145130);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145128);
        if (this == obj) {
            AppMethodBeat.o(145128);
            return true;
        } else if (!(obj instanceof SeMiterLimitActionArg)) {
            AppMethodBeat.o(145128);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145128);
            return false;
        } else if (Float.compare(((SeMiterLimitActionArg) obj).kZI, this.kZI) == 0) {
            AppMethodBeat.o(145128);
            return true;
        } else {
            AppMethodBeat.o(145128);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145129);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.kZI));
        AppMethodBeat.o(145129);
        return hash;
    }
}
