package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetStrokeStyleActionNormalArg extends RealSetStrokeStyleActionArg {
    public static final Parcelable.Creator<RealSetStrokeStyleActionNormalArg> CREATOR = new Parcelable.Creator<RealSetStrokeStyleActionNormalArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionNormalArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RealSetStrokeStyleActionNormalArg[] newArray(int i2) {
            return new RealSetStrokeStyleActionNormalArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RealSetStrokeStyleActionNormalArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145092);
            RealSetStrokeStyleActionNormalArg realSetStrokeStyleActionNormalArg = new RealSetStrokeStyleActionNormalArg(parcel);
            AppMethodBeat.o(145092);
            return realSetStrokeStyleActionNormalArg;
        }
    };
    public int color;

    public RealSetStrokeStyleActionNormalArg() {
    }

    public RealSetStrokeStyleActionNormalArg(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145094);
        super.i(parcel);
        this.color = parcel.readInt();
        AppMethodBeat.o(145094);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145095);
        if (this == obj) {
            AppMethodBeat.o(145095);
            return true;
        } else if (!(obj instanceof RealSetStrokeStyleActionNormalArg)) {
            AppMethodBeat.o(145095);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145095);
            return false;
        } else if (this.color == ((RealSetStrokeStyleActionNormalArg) obj).color) {
            AppMethodBeat.o(145095);
            return true;
        } else {
            AppMethodBeat.o(145095);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145096);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Integer.valueOf(this.color));
        AppMethodBeat.o(145096);
        return hash;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145097);
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.color);
        AppMethodBeat.o(145097);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionArg
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionArg
    public final void f(JSONArray jSONArray) {
        AppMethodBeat.i(145098);
        super.f(jSONArray);
        JSONArray optJSONArray = jSONArray.optJSONArray(1);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            AppMethodBeat.o(145098);
            return;
        }
        this.color = g.r(optJSONArray);
        AppMethodBeat.o(145098);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145099);
        super.parse(jSONObject);
        AppMethodBeat.o(145099);
    }

    static {
        AppMethodBeat.i(145100);
        AppMethodBeat.o(145100);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(145093);
        dVar.kZl.setColor(this.color);
        AppMethodBeat.o(145093);
        return true;
    }
}
