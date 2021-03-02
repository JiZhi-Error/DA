package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetFillStyleActionNormalArg extends RealSetFillStyleActionArg {
    public static final Parcelable.Creator<RealSetFillStyleActionNormalArg> CREATOR = new Parcelable.Creator<RealSetFillStyleActionNormalArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionNormalArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RealSetFillStyleActionNormalArg[] newArray(int i2) {
            return new RealSetFillStyleActionNormalArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RealSetFillStyleActionNormalArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145054);
            RealSetFillStyleActionNormalArg realSetFillStyleActionNormalArg = new RealSetFillStyleActionNormalArg(parcel);
            AppMethodBeat.o(145054);
            return realSetFillStyleActionNormalArg;
        }
    };
    public int color;

    public RealSetFillStyleActionNormalArg() {
    }

    public RealSetFillStyleActionNormalArg(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145056);
        super.i(parcel);
        this.color = parcel.readInt();
        AppMethodBeat.o(145056);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145057);
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.color);
        AppMethodBeat.o(145057);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionArg
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionArg
    public final void f(JSONArray jSONArray) {
        AppMethodBeat.i(145058);
        super.f(jSONArray);
        JSONArray optJSONArray = jSONArray.optJSONArray(1);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            AppMethodBeat.o(145058);
            return;
        }
        this.color = g.r(optJSONArray);
        AppMethodBeat.o(145058);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145059);
        if (this == obj) {
            AppMethodBeat.o(145059);
            return true;
        } else if (!(obj instanceof RealSetFillStyleActionNormalArg)) {
            AppMethodBeat.o(145059);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145059);
            return false;
        } else if (this.color == ((RealSetFillStyleActionNormalArg) obj).color) {
            AppMethodBeat.o(145059);
            return true;
        } else {
            AppMethodBeat.o(145059);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145060);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Integer.valueOf(this.color));
        AppMethodBeat.o(145060);
        return hash;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145061);
        super.parse(jSONObject);
        AppMethodBeat.o(145061);
    }

    static {
        AppMethodBeat.i(145062);
        AppMethodBeat.o(145062);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(145055);
        a aVar = dVar.kZm;
        aVar.setShader(null);
        aVar.setColor(this.color);
        AppMethodBeat.o(145055);
        return true;
    }
}
