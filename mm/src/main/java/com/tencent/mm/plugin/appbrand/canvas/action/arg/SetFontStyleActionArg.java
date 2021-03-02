package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONObject;

public class SetFontStyleActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetFontStyleActionArg> CREATOR = new Parcelable.Creator<SetFontStyleActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontStyleActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetFontStyleActionArg[] newArray(int i2) {
            return new SetFontStyleActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetFontStyleActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145161);
            SetFontStyleActionArg setFontStyleActionArg = new SetFontStyleActionArg(parcel);
            AppMethodBeat.o(145161);
            return setFontStyleActionArg;
        }
    };
    public String fontStyle;

    public SetFontStyleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public SetFontStyleActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145162);
        super.i(parcel);
        this.fontStyle = parcel.readString();
        AppMethodBeat.o(145162);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145163);
        super.parse(jSONObject);
        this.fontStyle = jSONObject.optJSONArray("data").optString(0);
        AppMethodBeat.o(145163);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145164);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.fontStyle);
        AppMethodBeat.o(145164);
    }

    static {
        AppMethodBeat.i(145167);
        AppMethodBeat.o(145167);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145165);
        if (this == obj) {
            AppMethodBeat.o(145165);
            return true;
        } else if (!(obj instanceof SetFontStyleActionArg)) {
            AppMethodBeat.o(145165);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145165);
            return false;
        } else {
            boolean equals = Objects.equals(this.fontStyle, ((SetFontStyleActionArg) obj).fontStyle);
            AppMethodBeat.o(145165);
            return equals;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145166);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), this.fontStyle);
        AppMethodBeat.o(145166);
        return hash;
    }
}
