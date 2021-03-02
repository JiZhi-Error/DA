package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SetFontFamilyActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetFontFamilyActionArg> CREATOR = new Parcelable.Creator<SetFontFamilyActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontFamilyActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetFontFamilyActionArg[] newArray(int i2) {
            return new SetFontFamilyActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetFontFamilyActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145147);
            SetFontFamilyActionArg setFontFamilyActionArg = new SetFontFamilyActionArg(parcel);
            AppMethodBeat.o(145147);
            return setFontFamilyActionArg;
        }
    };
    public String fontFamily;

    public SetFontFamilyActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public SetFontFamilyActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145148);
        super.i(parcel);
        this.fontFamily = parcel.readString();
        AppMethodBeat.o(145148);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145149);
        super.parse(jSONObject);
        this.fontFamily = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.o(145149);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145150);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.fontFamily);
        AppMethodBeat.o(145150);
    }

    static {
        AppMethodBeat.i(145153);
        AppMethodBeat.o(145153);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145151);
        if (this == obj) {
            AppMethodBeat.o(145151);
            return true;
        } else if (!(obj instanceof SetFontFamilyActionArg)) {
            AppMethodBeat.o(145151);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145151);
            return false;
        } else {
            boolean equals = Objects.equals(this.fontFamily, ((SetFontFamilyActionArg) obj).fontFamily);
            AppMethodBeat.o(145151);
            return equals;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145152);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), this.fontFamily);
        AppMethodBeat.o(145152);
        return hash;
    }
}
