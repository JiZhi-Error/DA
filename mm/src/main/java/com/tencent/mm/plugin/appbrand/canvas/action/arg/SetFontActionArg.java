package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetFontActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetFontActionArg> CREATOR = new Parcelable.Creator<SetFontActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetFontActionArg[] newArray(int i2) {
            return new SetFontActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetFontActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145140);
            SetFontActionArg setFontActionArg = new SetFontActionArg(parcel);
            AppMethodBeat.o(145140);
            return setFontActionArg;
        }
    };
    public String name;
    public float size;

    public SetFontActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public SetFontActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145141);
        super.i(parcel);
        this.name = parcel.readString();
        this.size = parcel.readFloat();
        AppMethodBeat.o(145141);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145142);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray.length() < 2) {
            AppMethodBeat.o(145142);
            return;
        }
        this.name = optJSONArray.optString(0);
        this.size = g.f(optJSONArray, 1);
        AppMethodBeat.o(145142);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145143);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.name);
        parcel.writeFloat(this.size);
        AppMethodBeat.o(145143);
    }

    static {
        AppMethodBeat.i(145146);
        AppMethodBeat.o(145146);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145144);
        if (this == obj) {
            AppMethodBeat.o(145144);
            return true;
        } else if (!(obj instanceof SetFontActionArg)) {
            AppMethodBeat.o(145144);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145144);
            return false;
        } else {
            SetFontActionArg setFontActionArg = (SetFontActionArg) obj;
            if (Float.compare(setFontActionArg.size, this.size) != 0 || !Objects.equals(this.name, setFontActionArg.name)) {
                AppMethodBeat.o(145144);
                return false;
            }
            AppMethodBeat.o(145144);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145145);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), this.name, Float.valueOf(this.size));
        AppMethodBeat.o(145145);
        return hash;
    }
}
