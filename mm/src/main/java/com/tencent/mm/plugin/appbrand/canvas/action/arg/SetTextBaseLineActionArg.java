package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SetTextBaseLineActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetTextBaseLineActionArg> CREATOR = new Parcelable.Creator<SetTextBaseLineActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextBaseLineActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetTextBaseLineActionArg[] newArray(int i2) {
            return new SetTextBaseLineActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetTextBaseLineActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145247);
            SetTextBaseLineActionArg setTextBaseLineActionArg = new SetTextBaseLineActionArg(parcel);
            AppMethodBeat.o(145247);
            return setTextBaseLineActionArg;
        }
    };
    public String kZR;

    public SetTextBaseLineActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public SetTextBaseLineActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145248);
        super.i(parcel);
        this.kZR = parcel.readString();
        AppMethodBeat.o(145248);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145249);
        super.parse(jSONObject);
        this.kZR = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.o(145249);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145250);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.kZR);
        AppMethodBeat.o(145250);
    }

    static {
        AppMethodBeat.i(145253);
        AppMethodBeat.o(145253);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145251);
        if (this == obj) {
            AppMethodBeat.o(145251);
            return true;
        } else if (!(obj instanceof SetTextBaseLineActionArg)) {
            AppMethodBeat.o(145251);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145251);
            return false;
        } else {
            boolean equals = Objects.equals(this.kZR, ((SetTextBaseLineActionArg) obj).kZR);
            AppMethodBeat.o(145251);
            return equals;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145252);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), this.kZR);
        AppMethodBeat.o(145252);
        return hash;
    }
}
