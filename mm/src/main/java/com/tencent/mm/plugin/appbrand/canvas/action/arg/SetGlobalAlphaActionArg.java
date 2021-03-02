package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import java.util.Objects;
import org.json.JSONObject;

public class SetGlobalAlphaActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetGlobalAlphaActionArg> CREATOR = new Parcelable.Creator<SetGlobalAlphaActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetGlobalAlphaActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetGlobalAlphaActionArg[] newArray(int i2) {
            return new SetGlobalAlphaActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetGlobalAlphaActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145175);
            SetGlobalAlphaActionArg setGlobalAlphaActionArg = new SetGlobalAlphaActionArg(parcel);
            AppMethodBeat.o(145175);
            return setGlobalAlphaActionArg;
        }
    };
    public int alpha;

    public SetGlobalAlphaActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public SetGlobalAlphaActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145176);
        super.i(parcel);
        this.alpha = parcel.readInt();
        AppMethodBeat.o(145176);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145177);
        super.parse(jSONObject);
        this.alpha = g.c(jSONObject.optJSONArray("data"), 0);
        AppMethodBeat.o(145177);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145178);
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.alpha);
        AppMethodBeat.o(145178);
    }

    static {
        AppMethodBeat.i(145181);
        AppMethodBeat.o(145181);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145179);
        if (this == obj) {
            AppMethodBeat.o(145179);
            return true;
        } else if (!(obj instanceof SetGlobalAlphaActionArg)) {
            AppMethodBeat.o(145179);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145179);
            return false;
        } else if (this.alpha == ((SetGlobalAlphaActionArg) obj).alpha) {
            AppMethodBeat.o(145179);
            return true;
        } else {
            AppMethodBeat.o(145179);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145180);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Integer.valueOf(this.alpha));
        AppMethodBeat.o(145180);
        return hash;
    }
}
