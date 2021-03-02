package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawImageActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<DrawImageActionArg> CREATOR = new Parcelable.Creator<DrawImageActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawImageActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrawImageActionArg[] newArray(int i2) {
            return new DrawImageActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrawImageActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145015);
            DrawImageActionArg drawImageActionArg = new DrawImageActionArg(parcel);
            AppMethodBeat.o(145015);
            return drawImageActionArg;
        }
    };
    public int aWX;
    public int aWY;
    public float height;
    public int kZx;
    public int kZy;
    public int kZz;
    public String url;
    public float width;
    public float x;
    public float y;

    public DrawImageActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    public DrawImageActionArg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145016);
        super.i(parcel);
        this.kZx = parcel.readInt();
        this.url = parcel.readString();
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.width = parcel.readFloat();
        this.height = parcel.readFloat();
        this.kZy = parcel.readInt();
        this.kZz = parcel.readInt();
        this.aWX = parcel.readInt();
        this.aWY = parcel.readInt();
        AppMethodBeat.o(145016);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145017);
        super.parse(jSONObject);
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            this.kZx = optJSONArray.length();
            this.url = optJSONArray.optString(0);
            this.x = g.f(optJSONArray, 1);
            this.y = g.f(optJSONArray, 2);
            this.width = g.f(optJSONArray, 3);
            this.height = g.f(optJSONArray, 4);
            this.kZy = optJSONArray.optInt(5);
            this.kZz = optJSONArray.optInt(6);
            this.aWX = optJSONArray.optInt(7);
            this.aWY = optJSONArray.optInt(8);
            AppMethodBeat.o(145017);
        } catch (Exception e2) {
            Log.printErrStackTrace("DrawImageActionArg", e2, "", new Object[0]);
            AppMethodBeat.o(145017);
        }
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145018);
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.kZx);
        parcel.writeString(this.url);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        parcel.writeInt(this.kZy);
        parcel.writeInt(this.kZz);
        parcel.writeInt(this.aWX);
        parcel.writeInt(this.aWY);
        AppMethodBeat.o(145018);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145019);
        if (this == obj) {
            AppMethodBeat.o(145019);
            return true;
        } else if (!(obj instanceof DrawImageActionArg)) {
            AppMethodBeat.o(145019);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145019);
            return false;
        } else {
            DrawImageActionArg drawImageActionArg = (DrawImageActionArg) obj;
            if (this.kZx == drawImageActionArg.kZx && Float.compare(drawImageActionArg.x, this.x) == 0 && Float.compare(drawImageActionArg.y, this.y) == 0 && Float.compare(drawImageActionArg.width, this.width) == 0 && Float.compare(drawImageActionArg.height, this.height) == 0 && this.kZy == drawImageActionArg.kZy && this.kZz == drawImageActionArg.kZz && this.aWX == drawImageActionArg.aWX && this.aWY == drawImageActionArg.aWY && Objects.equals(this.url, drawImageActionArg.url)) {
                AppMethodBeat.o(145019);
                return true;
            }
            AppMethodBeat.o(145019);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145020);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Integer.valueOf(this.kZx), this.url, Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height), Integer.valueOf(this.kZy), Integer.valueOf(this.kZz), Integer.valueOf(this.aWX), Integer.valueOf(this.aWY));
        AppMethodBeat.o(145020);
        return hash;
    }

    static {
        AppMethodBeat.i(145021);
        AppMethodBeat.o(145021);
    }
}
