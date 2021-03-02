package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetFillStyleActionLinearArg extends RealSetFillStyleActionArg {
    public static final Parcelable.Creator<RealSetFillStyleActionLinearArg> CREATOR = new Parcelable.Creator<RealSetFillStyleActionLinearArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionLinearArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RealSetFillStyleActionLinearArg[] newArray(int i2) {
            return new RealSetFillStyleActionLinearArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RealSetFillStyleActionLinearArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145045);
            RealSetFillStyleActionLinearArg realSetFillStyleActionLinearArg = new RealSetFillStyleActionLinearArg(parcel);
            AppMethodBeat.o(145045);
            return realSetFillStyleActionLinearArg;
        }
    };
    public float kZA;
    public float kZB;
    public float kZC;
    public float kZD;
    public int[] kZE;
    public float[] kZF;

    public RealSetFillStyleActionLinearArg() {
    }

    public RealSetFillStyleActionLinearArg(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(145046);
        if (this.kZE == null || this.kZF == null) {
            AppMethodBeat.o(145046);
            return false;
        }
        dVar.kZm.setShader(new LinearGradient(this.kZA, this.kZB, this.kZC, this.kZD, this.kZE, this.kZF, Shader.TileMode.CLAMP));
        AppMethodBeat.o(145046);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145047);
        super.i(parcel);
        this.kZA = parcel.readFloat();
        this.kZB = parcel.readFloat();
        this.kZC = parcel.readFloat();
        this.kZD = parcel.readFloat();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.kZE = new int[readInt];
            parcel.readIntArray(this.kZE);
        }
        int readInt2 = parcel.readInt();
        if (readInt2 > 0) {
            this.kZF = new float[readInt2];
            parcel.readFloatArray(this.kZF);
        }
        AppMethodBeat.o(145047);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145048);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.kZA);
        parcel.writeFloat(this.kZB);
        parcel.writeFloat(this.kZC);
        parcel.writeFloat(this.kZD);
        if (this.kZE != null) {
            parcel.writeInt(this.kZE.length);
            parcel.writeIntArray(this.kZE);
        } else {
            parcel.writeInt(0);
        }
        if (this.kZF != null) {
            parcel.writeInt(this.kZF.length);
            parcel.writeFloatArray(this.kZF);
            AppMethodBeat.o(145048);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.o(145048);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionArg
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145049);
        if (this == obj) {
            AppMethodBeat.o(145049);
            return true;
        } else if (!(obj instanceof RealSetFillStyleActionLinearArg)) {
            AppMethodBeat.o(145049);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145049);
            return false;
        } else {
            RealSetFillStyleActionLinearArg realSetFillStyleActionLinearArg = (RealSetFillStyleActionLinearArg) obj;
            if (Float.compare(realSetFillStyleActionLinearArg.kZA, this.kZA) == 0 && Float.compare(realSetFillStyleActionLinearArg.kZB, this.kZB) == 0 && Float.compare(realSetFillStyleActionLinearArg.kZC, this.kZC) == 0 && Float.compare(realSetFillStyleActionLinearArg.kZD, this.kZD) == 0 && Arrays.equals(this.kZE, realSetFillStyleActionLinearArg.kZE) && Arrays.equals(this.kZF, realSetFillStyleActionLinearArg.kZF)) {
                AppMethodBeat.o(145049);
                return true;
            }
            AppMethodBeat.o(145049);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145050);
        int hash = (((Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.kZA), Float.valueOf(this.kZB), Float.valueOf(this.kZC), Float.valueOf(this.kZD)) * 31) + Arrays.hashCode(this.kZE)) * 31) + Arrays.hashCode(this.kZF);
        AppMethodBeat.o(145050);
        return hash;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionArg
    public final void f(JSONArray jSONArray) {
        AppMethodBeat.i(145051);
        super.f(jSONArray);
        if (jSONArray.length() < 3) {
            AppMethodBeat.o(145051);
            return;
        }
        JSONArray optJSONArray = jSONArray.optJSONArray(1);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            AppMethodBeat.o(145051);
            return;
        }
        this.kZA = g.f(optJSONArray, 0);
        this.kZB = g.f(optJSONArray, 1);
        this.kZC = g.f(optJSONArray, 2);
        this.kZD = g.f(optJSONArray, 3);
        JSONArray optJSONArray2 = jSONArray.optJSONArray(2);
        if (optJSONArray2 == null || optJSONArray2.length() == 0) {
            AppMethodBeat.o(145051);
            return;
        }
        this.kZE = new int[optJSONArray2.length()];
        this.kZF = new float[optJSONArray2.length()];
        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
            JSONArray optJSONArray3 = optJSONArray2.optJSONArray(i2);
            if (optJSONArray3.length() >= 2) {
                this.kZF[i2] = (float) optJSONArray3.optDouble(0);
                this.kZE[i2] = g.r(optJSONArray3.optJSONArray(1));
            }
        }
        AppMethodBeat.o(145051);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145052);
        super.parse(jSONObject);
        AppMethodBeat.o(145052);
    }

    static {
        AppMethodBeat.i(145053);
        AppMethodBeat.o(145053);
    }
}
