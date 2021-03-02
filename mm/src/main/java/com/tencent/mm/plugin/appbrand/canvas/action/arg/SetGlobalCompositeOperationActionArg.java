package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SetGlobalCompositeOperationActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetGlobalCompositeOperationActionArg> CREATOR = new Parcelable.Creator<SetGlobalCompositeOperationActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetGlobalCompositeOperationActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetGlobalCompositeOperationActionArg[] newArray(int i2) {
            return new SetGlobalCompositeOperationActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetGlobalCompositeOperationActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145182);
            SetGlobalCompositeOperationActionArg setGlobalCompositeOperationActionArg = new SetGlobalCompositeOperationActionArg(parcel);
            AppMethodBeat.o(145182);
            return setGlobalCompositeOperationActionArg;
        }
    };
    public String type;

    public SetGlobalCompositeOperationActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public SetGlobalCompositeOperationActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145183);
        super.i(parcel);
        this.type = parcel.readString();
        AppMethodBeat.o(145183);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145184);
        super.parse(jSONObject);
        this.type = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.o(145184);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145185);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.type);
        AppMethodBeat.o(145185);
    }

    static {
        AppMethodBeat.i(145188);
        AppMethodBeat.o(145188);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145186);
        if (this == obj) {
            AppMethodBeat.o(145186);
            return true;
        } else if (!(obj instanceof SetGlobalCompositeOperationActionArg)) {
            AppMethodBeat.o(145186);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145186);
            return false;
        } else {
            boolean equals = Objects.equals(this.type, ((SetGlobalCompositeOperationActionArg) obj).type);
            AppMethodBeat.o(145186);
            return equals;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145187);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), this.type);
        AppMethodBeat.o(145187);
        return hash;
    }
}
