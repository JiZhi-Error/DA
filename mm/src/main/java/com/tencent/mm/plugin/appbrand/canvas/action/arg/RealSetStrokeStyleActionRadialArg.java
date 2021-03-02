package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.RadialGradient;
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

public class RealSetStrokeStyleActionRadialArg extends RealSetStrokeStyleActionArg {
    public static final Parcelable.Creator<RealSetStrokeStyleActionRadialArg> CREATOR = new Parcelable.Creator<RealSetStrokeStyleActionRadialArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionRadialArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RealSetStrokeStyleActionRadialArg[] newArray(int i2) {
            return new RealSetStrokeStyleActionRadialArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RealSetStrokeStyleActionRadialArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145101);
            RealSetStrokeStyleActionRadialArg realSetStrokeStyleActionRadialArg = new RealSetStrokeStyleActionRadialArg(parcel);
            AppMethodBeat.o(145101);
            return realSetStrokeStyleActionRadialArg;
        }
    };
    public float kZA;
    public float kZB;
    public int[] kZE;
    public float[] kZF;
    public float kZH;

    public RealSetStrokeStyleActionRadialArg() {
    }

    public RealSetStrokeStyleActionRadialArg(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final boolean a(d dVar, Canvas canvas) {
        AppMethodBeat.i(145102);
        if (this.kZE == null || this.kZF == null) {
            AppMethodBeat.o(145102);
            return false;
        }
        dVar.kZl.setShader(new RadialGradient(this.kZA, this.kZB, this.kZH, this.kZE, this.kZF, Shader.TileMode.CLAMP));
        AppMethodBeat.o(145102);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145103);
        if (this == obj) {
            AppMethodBeat.o(145103);
            return true;
        } else if (!(obj instanceof RealSetStrokeStyleActionRadialArg)) {
            AppMethodBeat.o(145103);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145103);
            return false;
        } else {
            RealSetStrokeStyleActionRadialArg realSetStrokeStyleActionRadialArg = (RealSetStrokeStyleActionRadialArg) obj;
            if (Float.compare(realSetStrokeStyleActionRadialArg.kZA, this.kZA) == 0 && Float.compare(realSetStrokeStyleActionRadialArg.kZB, this.kZB) == 0 && Float.compare(realSetStrokeStyleActionRadialArg.kZH, this.kZH) == 0 && Arrays.equals(this.kZE, realSetStrokeStyleActionRadialArg.kZE) && Arrays.equals(this.kZF, realSetStrokeStyleActionRadialArg.kZF)) {
                AppMethodBeat.o(145103);
                return true;
            }
            AppMethodBeat.o(145103);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145104);
        int hash = (((Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.kZA), Float.valueOf(this.kZB), Float.valueOf(this.kZH)) * 31) + Arrays.hashCode(this.kZE)) * 31) + Arrays.hashCode(this.kZF);
        AppMethodBeat.o(145104);
        return hash;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145105);
        super.i(parcel);
        this.kZA = parcel.readFloat();
        this.kZB = parcel.readFloat();
        this.kZH = parcel.readFloat();
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
        AppMethodBeat.o(145105);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145106);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.kZA);
        parcel.writeFloat(this.kZB);
        parcel.writeFloat(this.kZH);
        if (this.kZE != null) {
            parcel.writeInt(this.kZE.length);
            parcel.writeIntArray(this.kZE);
        } else {
            parcel.writeInt(0);
        }
        if (this.kZF != null) {
            parcel.writeInt(this.kZF.length);
            parcel.writeFloatArray(this.kZF);
            AppMethodBeat.o(145106);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.o(145106);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionArg
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionArg
    public final void f(JSONArray jSONArray) {
        AppMethodBeat.i(145107);
        super.f(jSONArray);
        if (jSONArray.length() < 3) {
            AppMethodBeat.o(145107);
            return;
        }
        JSONArray optJSONArray = jSONArray.optJSONArray(1);
        if (optJSONArray == null || optJSONArray.length() < 3) {
            AppMethodBeat.o(145107);
            return;
        }
        this.kZA = g.f(optJSONArray, 1);
        this.kZB = g.f(optJSONArray, 2);
        this.kZH = g.f(optJSONArray, 3);
        JSONArray optJSONArray2 = jSONArray.optJSONArray(2);
        this.kZE = new int[optJSONArray2.length()];
        this.kZF = new float[optJSONArray2.length()];
        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
            JSONArray optJSONArray3 = optJSONArray2.optJSONArray(i2);
            if (optJSONArray3.length() >= 2) {
                this.kZF[i2] = (float) optJSONArray3.optDouble(0);
                this.kZE[i2] = g.r(optJSONArray3.optJSONArray(1));
            }
        }
        AppMethodBeat.o(145107);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145108);
        super.parse(jSONObject);
        AppMethodBeat.o(145108);
    }

    static {
        AppMethodBeat.i(145109);
        AppMethodBeat.o(145109);
    }
}
