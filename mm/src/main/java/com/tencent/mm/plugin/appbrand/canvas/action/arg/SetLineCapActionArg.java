package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SetLineCapActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetLineCapActionArg> CREATOR = new Parcelable.Creator<SetLineCapActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineCapActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetLineCapActionArg[] newArray(int i2) {
            return new SetLineCapActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetLineCapActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145189);
            SetLineCapActionArg setLineCapActionArg = new SetLineCapActionArg(parcel);
            AppMethodBeat.o(145189);
            return setLineCapActionArg;
        }
    };
    public String kZK;

    public SetLineCapActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public SetLineCapActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145190);
        super.i(parcel);
        this.kZK = parcel.readString();
        AppMethodBeat.o(145190);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145191);
        super.parse(jSONObject);
        this.kZK = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.o(145191);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145192);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.kZK);
        AppMethodBeat.o(145192);
    }

    static {
        AppMethodBeat.i(145195);
        AppMethodBeat.o(145195);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145193);
        if (this == obj) {
            AppMethodBeat.o(145193);
            return true;
        } else if (!(obj instanceof SetLineCapActionArg)) {
            AppMethodBeat.o(145193);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145193);
            return false;
        } else {
            boolean equals = Objects.equals(this.kZK, ((SetLineCapActionArg) obj).kZK);
            AppMethodBeat.o(145193);
            return equals;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145194);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), this.kZK);
        AppMethodBeat.o(145194);
        return hash;
    }
}
