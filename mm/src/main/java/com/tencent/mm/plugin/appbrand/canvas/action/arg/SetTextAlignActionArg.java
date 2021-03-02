package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SetTextAlignActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetTextAlignActionArg> CREATOR = new Parcelable.Creator<SetTextAlignActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextAlignActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetTextAlignActionArg[] newArray(int i2) {
            return new SetTextAlignActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetTextAlignActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145240);
            SetTextAlignActionArg setTextAlignActionArg = new SetTextAlignActionArg(parcel);
            AppMethodBeat.o(145240);
            return setTextAlignActionArg;
        }
    };
    public String kZR;

    public SetTextAlignActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public SetTextAlignActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145241);
        super.i(parcel);
        this.kZR = parcel.readString();
        AppMethodBeat.o(145241);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145242);
        super.parse(jSONObject);
        this.kZR = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.o(145242);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145243);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.kZR);
        AppMethodBeat.o(145243);
    }

    static {
        AppMethodBeat.i(145246);
        AppMethodBeat.o(145246);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145244);
        if (this == obj) {
            AppMethodBeat.o(145244);
            return true;
        } else if (!(obj instanceof SetTextAlignActionArg)) {
            AppMethodBeat.o(145244);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145244);
            return false;
        } else {
            boolean equals = Objects.equals(this.kZR, ((SetTextAlignActionArg) obj).kZR);
            AppMethodBeat.o(145244);
            return equals;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145245);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), this.kZR);
        AppMethodBeat.o(145245);
        return hash;
    }
}
