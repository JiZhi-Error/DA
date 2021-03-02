package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class TranslateActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<TranslateActionArg> CREATOR = new Parcelable.Creator<TranslateActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.TranslateActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TranslateActionArg[] newArray(int i2) {
            return new TranslateActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TranslateActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145261);
            TranslateActionArg translateActionArg = new TranslateActionArg(parcel);
            AppMethodBeat.o(145261);
            return translateActionArg;
        }
    };
    public float x;
    public float y;

    public TranslateActionArg() {
    }

    public TranslateActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final boolean bzk() {
        return this.x == 0.0f && this.y == 0.0f;
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145262);
        super.i(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        AppMethodBeat.o(145262);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145263);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        AppMethodBeat.o(145263);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145264);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.f(optJSONArray, 0);
        this.y = g.f(optJSONArray, 1);
        AppMethodBeat.o(145264);
    }

    static {
        AppMethodBeat.i(145267);
        AppMethodBeat.o(145267);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145265);
        if (this == obj) {
            AppMethodBeat.o(145265);
            return true;
        } else if (!(obj instanceof TranslateActionArg)) {
            AppMethodBeat.o(145265);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145265);
            return false;
        } else {
            TranslateActionArg translateActionArg = (TranslateActionArg) obj;
            if (Float.compare(translateActionArg.x, this.x) == 0 && Float.compare(translateActionArg.y, this.y) == 0) {
                AppMethodBeat.o(145265);
                return true;
            }
            AppMethodBeat.o(145265);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145266);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y));
        AppMethodBeat.o(145266);
        return hash;
    }
}
