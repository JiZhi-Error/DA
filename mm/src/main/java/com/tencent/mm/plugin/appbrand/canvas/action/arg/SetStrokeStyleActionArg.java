package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.h;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetStrokeStyleActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetStrokeStyleActionArg> CREATOR = new Parcelable.Creator<SetStrokeStyleActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetStrokeStyleActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetStrokeStyleActionArg[] newArray(int i2) {
            return new SetStrokeStyleActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetStrokeStyleActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145231);
            SetStrokeStyleActionArg setStrokeStyleActionArg = new SetStrokeStyleActionArg(parcel);
            AppMethodBeat.o(145231);
            return setStrokeStyleActionArg;
        }
    };
    public RealSetStrokeStyleActionArg kZQ;

    public SetStrokeStyleActionArg() {
    }

    public SetStrokeStyleActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void reset() {
        AppMethodBeat.i(145232);
        super.reset();
        h.bzs().a(this.kZQ);
        this.kZQ = null;
        AppMethodBeat.o(145232);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(145233);
        if (this.kZQ == null) {
            AppMethodBeat.o(145233);
            return false;
        }
        boolean a2 = this.kZQ.a(dVar, canvas);
        AppMethodBeat.o(145233);
        return a2;
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145234);
        super.i(parcel);
        this.kZQ = (RealSetStrokeStyleActionArg) parcel.readParcelable(SetStrokeStyleActionArg.class.getClassLoader());
        AppMethodBeat.o(145234);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145235);
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.kZQ, i2);
        AppMethodBeat.o(145235);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145236);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray.length() < 2) {
            AppMethodBeat.o(145236);
            return;
        }
        this.kZQ = (RealSetStrokeStyleActionArg) h.bzs().WC(optJSONArray.optString(0));
        this.kZQ.f(optJSONArray);
        AppMethodBeat.o(145236);
    }

    static {
        AppMethodBeat.i(145239);
        AppMethodBeat.o(145239);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145237);
        if (this == obj) {
            AppMethodBeat.o(145237);
            return true;
        } else if (!(obj instanceof SetStrokeStyleActionArg)) {
            AppMethodBeat.o(145237);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145237);
            return false;
        } else {
            boolean equals = Objects.equals(this.kZQ, ((SetStrokeStyleActionArg) obj).kZQ);
            AppMethodBeat.o(145237);
            return equals;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145238);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), this.kZQ);
        AppMethodBeat.o(145238);
        return hash;
    }
}
