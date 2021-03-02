package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SetFontWeightArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetFontWeightArg> CREATOR = new Parcelable.Creator<SetFontWeightArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontWeightArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetFontWeightArg[] newArray(int i2) {
            return new SetFontWeightArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetFontWeightArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145168);
            SetFontWeightArg setFontWeightArg = new SetFontWeightArg(parcel);
            AppMethodBeat.o(145168);
            return setFontWeightArg;
        }
    };
    public String cNw;

    public SetFontWeightArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public SetFontWeightArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145169);
        super.i(parcel);
        this.cNw = parcel.readString();
        AppMethodBeat.o(145169);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145170);
        super.parse(jSONObject);
        this.cNw = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.o(145170);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145171);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.cNw);
        AppMethodBeat.o(145171);
    }

    static {
        AppMethodBeat.i(145174);
        AppMethodBeat.o(145174);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145172);
        if (this == obj) {
            AppMethodBeat.o(145172);
            return true;
        } else if (!(obj instanceof SetFontWeightArg)) {
            AppMethodBeat.o(145172);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145172);
            return false;
        } else {
            boolean equals = Objects.equals(this.cNw, ((SetFontWeightArg) obj).cNw);
            AppMethodBeat.o(145172);
            return equals;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145173);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), this.cNw);
        AppMethodBeat.o(145173);
        return hash;
    }
}
