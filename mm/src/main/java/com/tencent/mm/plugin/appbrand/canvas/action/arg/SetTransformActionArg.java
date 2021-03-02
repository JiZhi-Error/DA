package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SetTransformActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetTransformActionArg> CREATOR = new Parcelable.Creator<SetTransformActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTransformActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetTransformActionArg[] newArray(int i2) {
            return new SetTransformActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetTransformActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145254);
            SetTransformActionArg setTransformActionArg = new SetTransformActionArg(parcel);
            AppMethodBeat.o(145254);
            return setTransformActionArg;
        }
    };
    public float kZS;
    public float kZT;
    public float scaleX;
    public float scaleY;
    public float translateX;
    public float translateY;

    public SetTransformActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public SetTransformActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145255);
        super.i(parcel);
        this.scaleX = parcel.readFloat();
        this.kZS = parcel.readFloat();
        this.kZT = parcel.readFloat();
        this.scaleY = parcel.readFloat();
        this.translateX = parcel.readFloat();
        this.translateY = parcel.readFloat();
        AppMethodBeat.o(145255);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145256);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        try {
            this.scaleX = (float) optJSONArray.getDouble(0);
            this.kZS = (float) optJSONArray.getDouble(1);
            this.kZT = (float) optJSONArray.getDouble(2);
            this.scaleY = (float) optJSONArray.getDouble(3);
            this.translateX = g.e(optJSONArray, 4);
            this.translateY = g.e(optJSONArray, 5);
            AppMethodBeat.o(145256);
        } catch (JSONException e2) {
            Log.printErrStackTrace("SetTransformActionArg", e2, "", new Object[0]);
            AppMethodBeat.o(145256);
        }
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145257);
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.scaleY);
        parcel.writeFloat(this.kZS);
        parcel.writeFloat(this.kZT);
        parcel.writeFloat(this.scaleY);
        parcel.writeFloat(this.translateX);
        parcel.writeFloat(this.translateY);
        AppMethodBeat.o(145257);
    }

    static {
        AppMethodBeat.i(145260);
        AppMethodBeat.o(145260);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145258);
        if (this == obj) {
            AppMethodBeat.o(145258);
            return true;
        } else if (!(obj instanceof SetTransformActionArg)) {
            AppMethodBeat.o(145258);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145258);
            return false;
        } else {
            SetTransformActionArg setTransformActionArg = (SetTransformActionArg) obj;
            if (Float.compare(setTransformActionArg.scaleX, this.scaleX) == 0 && Float.compare(setTransformActionArg.kZS, this.kZS) == 0 && Float.compare(setTransformActionArg.kZT, this.kZT) == 0 && Float.compare(setTransformActionArg.scaleY, this.scaleY) == 0 && Float.compare(setTransformActionArg.translateX, this.translateX) == 0 && Float.compare(setTransformActionArg.translateY, this.translateY) == 0) {
                AppMethodBeat.o(145258);
                return true;
            }
            AppMethodBeat.o(145258);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145259);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.scaleX), Float.valueOf(this.kZS), Float.valueOf(this.kZT), Float.valueOf(this.scaleY), Float.valueOf(this.translateX), Float.valueOf(this.translateY));
        AppMethodBeat.o(145259);
        return hash;
    }
}
