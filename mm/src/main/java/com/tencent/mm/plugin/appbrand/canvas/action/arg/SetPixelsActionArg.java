package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SetPixelsActionArg extends BaseDrawActionArg {
    public static final Parcelable.Creator<SetPixelsActionArg> CREATOR = new Parcelable.Creator<SetPixelsActionArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.SetPixelsActionArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SetPixelsActionArg[] newArray(int i2) {
            return new SetPixelsActionArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SetPixelsActionArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145217);
            SetPixelsActionArg setPixelsActionArg = new SetPixelsActionArg(parcel);
            AppMethodBeat.o(145217);
            return setPixelsActionArg;
        }
    };
    public Bitmap bitmap = null;
    public int height;
    public int width;
    public int x;
    public int y;

    public SetPixelsActionArg() {
    }

    public SetPixelsActionArg(Parcel parcel) {
        super(parcel, (byte) 0);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145218);
        if (this == obj) {
            AppMethodBeat.o(145218);
            return true;
        } else if (!(obj instanceof SetPixelsActionArg)) {
            AppMethodBeat.o(145218);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145218);
            return false;
        } else {
            SetPixelsActionArg setPixelsActionArg = (SetPixelsActionArg) obj;
            if (this.x == setPixelsActionArg.x && this.y == setPixelsActionArg.y && this.width == setPixelsActionArg.width && this.height == setPixelsActionArg.height && Objects.equals(this.bitmap, setPixelsActionArg.bitmap)) {
                AppMethodBeat.o(145218);
                return true;
            }
            AppMethodBeat.o(145218);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145219);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.width), Integer.valueOf(this.height), this.bitmap);
        AppMethodBeat.o(145219);
        return hash;
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145220);
        super.i(parcel);
        this.x = parcel.readInt();
        this.y = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.bitmap = (Bitmap) parcel.readParcelable(SetPixelsActionArg.class.getClassLoader());
        AppMethodBeat.o(145220);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145221);
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.x);
        parcel.writeInt(this.y);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeParcelable(this.bitmap, i2);
        AppMethodBeat.o(145221);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145222);
        super.parse(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        this.x = g.c(optJSONArray, 0);
        this.y = g.c(optJSONArray, 1);
        this.width = g.c(optJSONArray, 2);
        this.height = g.c(optJSONArray, 3);
        try {
            this.bitmap = (Bitmap) optJSONArray.get(4);
            AppMethodBeat.o(145222);
        } catch (JSONException e2) {
            Log.printErrStackTrace("SetPixelsActionArg", e2, "", new Object[0]);
            AppMethodBeat.o(145222);
        }
    }

    static {
        AppMethodBeat.i(145223);
        AppMethodBeat.o(145223);
    }
}
