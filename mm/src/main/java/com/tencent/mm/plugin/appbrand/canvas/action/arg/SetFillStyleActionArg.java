package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.g;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetFillStyleActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetFillStyleActionArg> CREATOR = new Parcelable.Creator<SetFillStyleActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFillStyleActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetFillStyleActionArg[] newArray(int i2) {
            return new SetFillStyleActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetFillStyleActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145131);
            SetFillStyleActionArg setFillStyleActionArg = new SetFillStyleActionArg(parcel);
            AppMethodBeat.o(145131);
            return setFillStyleActionArg;
        }
    };
    public RealSetFillStyleActionArg kZJ;

    public SetFillStyleActionArg() {
    }

    public SetFillStyleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void reset() {
        AppMethodBeat.i(145132);
        super.reset();
        g.bzr().a(this.kZJ);
        this.kZJ = null;
        AppMethodBeat.o(145132);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(145133);
        if (this.kZJ == null) {
            AppMethodBeat.o(145133);
            return false;
        }
        boolean a2 = this.kZJ.a(dVar, canvas);
        AppMethodBeat.o(145133);
        return a2;
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145134);
        super.i(parcel);
        this.kZJ = (RealSetFillStyleActionArg) parcel.readParcelable(SetFillStyleActionArg.class.getClassLoader());
        AppMethodBeat.o(145134);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145135);
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.kZJ, i2);
        AppMethodBeat.o(145135);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145136);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray.length() < 2) {
            AppMethodBeat.o(145136);
            return;
        }
        this.kZJ = (RealSetFillStyleActionArg) g.bzr().WC(optJSONArray.optString(0));
        this.kZJ.f(optJSONArray);
        AppMethodBeat.o(145136);
    }

    static {
        AppMethodBeat.i(145139);
        AppMethodBeat.o(145139);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145137);
        if (this == obj) {
            AppMethodBeat.o(145137);
            return true;
        } else if (!(obj instanceof SetFillStyleActionArg)) {
            AppMethodBeat.o(145137);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145137);
            return false;
        } else {
            boolean equals = Objects.equals(this.kZJ, ((SetFillStyleActionArg) obj).kZJ);
            AppMethodBeat.o(145137);
            return equals;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145138);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), this.kZJ);
        AppMethodBeat.o(145138);
        return hash;
    }
}
