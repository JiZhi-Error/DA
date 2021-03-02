package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SetLineJoinActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetLineJoinActionArg> CREATOR = new Parcelable.Creator<SetLineJoinActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineJoinActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetLineJoinActionArg[] newArray(int i2) {
            return new SetLineJoinActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetLineJoinActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145203);
            SetLineJoinActionArg setLineJoinActionArg = new SetLineJoinActionArg(parcel);
            AppMethodBeat.o(145203);
            return setLineJoinActionArg;
        }
    };
    public String kZN;

    public SetLineJoinActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public SetLineJoinActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145204);
        super.i(parcel);
        this.kZN = parcel.readString();
        AppMethodBeat.o(145204);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145205);
        super.parse(jSONObject);
        this.kZN = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.o(145205);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145206);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.kZN);
        AppMethodBeat.o(145206);
    }

    static {
        AppMethodBeat.i(145209);
        AppMethodBeat.o(145209);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145207);
        if (this == obj) {
            AppMethodBeat.o(145207);
            return true;
        } else if (!(obj instanceof SetLineJoinActionArg)) {
            AppMethodBeat.o(145207);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145207);
            return false;
        } else {
            boolean equals = Objects.equals(this.kZN, ((SetLineJoinActionArg) obj).kZN);
            AppMethodBeat.o(145207);
            return equals;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145208);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), this.kZN);
        AppMethodBeat.o(145208);
        return hash;
    }
}
