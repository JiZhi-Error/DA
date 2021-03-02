package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawTextActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<DrawTextActionArg> CREATOR = new Parcelable.Creator<DrawTextActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawTextActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrawTextActionArg[] newArray(int i2) {
            return new DrawTextActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrawTextActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145029);
            DrawTextActionArg drawTextActionArg = new DrawTextActionArg(parcel);
            AppMethodBeat.o(145029);
            return drawTextActionArg;
        }
    };
    public float maxWidth;
    public String text;
    public float x;
    public float y;

    public DrawTextActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public DrawTextActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145030);
        super.i(parcel);
        this.text = parcel.readString();
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.maxWidth = parcel.readFloat();
        AppMethodBeat.o(145030);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145031);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.text = optJSONArray.optString(0);
        this.x = g.f(optJSONArray, 1);
        this.y = g.f(optJSONArray, 2);
        this.maxWidth = g.f(optJSONArray, 3);
        AppMethodBeat.o(145031);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145032);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.text);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.maxWidth);
        AppMethodBeat.o(145032);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145033);
        if (this == obj) {
            AppMethodBeat.o(145033);
            return true;
        } else if (!(obj instanceof DrawTextActionArg)) {
            AppMethodBeat.o(145033);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145033);
            return false;
        } else {
            DrawTextActionArg drawTextActionArg = (DrawTextActionArg) obj;
            if (Float.compare(drawTextActionArg.x, this.x) == 0 && Float.compare(drawTextActionArg.y, this.y) == 0 && Float.compare(drawTextActionArg.maxWidth, this.maxWidth) == 0 && Objects.equals(this.text, drawTextActionArg.text)) {
                AppMethodBeat.o(145033);
                return true;
            }
            AppMethodBeat.o(145033);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145034);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), this.text, Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.maxWidth));
        AppMethodBeat.o(145034);
        return hash;
    }

    static {
        AppMethodBeat.i(145035);
        AppMethodBeat.o(145035);
    }
}
