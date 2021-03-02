package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import java.util.Objects;
import org.json.JSONObject;

public class SetFontSizeActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetFontSizeActionArg> CREATOR = new Parcelable.Creator<SetFontSizeActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontSizeActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetFontSizeActionArg[] newArray(int i2) {
            return new SetFontSizeActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetFontSizeActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145154);
            SetFontSizeActionArg setFontSizeActionArg = new SetFontSizeActionArg(parcel);
            AppMethodBeat.o(145154);
            return setFontSizeActionArg;
        }
    };
    public int size;

    public SetFontSizeActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public SetFontSizeActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145155);
        super.i(parcel);
        this.size = parcel.readInt();
        AppMethodBeat.o(145155);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145156);
        super.parse(jSONObject);
        this.size = g.c(jSONObject.optJSONArray("data"), 0);
        AppMethodBeat.o(145156);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145157);
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.size);
        AppMethodBeat.o(145157);
    }

    static {
        AppMethodBeat.i(145160);
        AppMethodBeat.o(145160);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145158);
        if (this == obj) {
            AppMethodBeat.o(145158);
            return true;
        } else if (!(obj instanceof SetFontSizeActionArg)) {
            AppMethodBeat.o(145158);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145158);
            return false;
        } else if (this.size == ((SetFontSizeActionArg) obj).size) {
            AppMethodBeat.o(145158);
            return true;
        } else {
            AppMethodBeat.o(145158);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145159);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Integer.valueOf(this.size));
        AppMethodBeat.o(145159);
        return hash;
    }
}
