package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetFillStyleActionPatternArg extends RealSetFillStyleActionArg {
    public static final Parcelable.Creator<RealSetFillStyleActionPatternArg> CREATOR = new Parcelable.Creator<RealSetFillStyleActionPatternArg>() {
        /* class com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionPatternArg.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RealSetFillStyleActionPatternArg[] newArray(int i2) {
            return new RealSetFillStyleActionPatternArg[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RealSetFillStyleActionPatternArg createFromParcel(Parcel parcel) {
            AppMethodBeat.i(145063);
            RealSetFillStyleActionPatternArg realSetFillStyleActionPatternArg = new RealSetFillStyleActionPatternArg(parcel);
            AppMethodBeat.o(145063);
            return realSetFillStyleActionPatternArg;
        }
    };
    public String kZG;
    public String path;

    public RealSetFillStyleActionPatternArg() {
    }

    public RealSetFillStyleActionPatternArg(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final boolean a(d dVar, Canvas canvas) {
        BitmapShader bitmapShader;
        AppMethodBeat.i(145064);
        if (Util.isNullOrNil(this.path)) {
            AppMethodBeat.o(145064);
            return false;
        }
        a aVar = dVar.kZm;
        Bitmap a2 = dVar.kZr.a(dVar, this.path);
        if (a2 != null && !a2.isRecycled()) {
            String str = this.kZG;
            int zD = g.zD(a2.getWidth());
            int zD2 = g.zD(a2.getHeight());
            char c2 = 65535;
            switch (str.hashCode()) {
                case -934531685:
                    if (str.equals("repeat")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -724648153:
                    if (str.equals("no-repeat")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -436782906:
                    if (str.equals("repeat-x")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -436782905:
                    if (str.equals("repeat-y")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a2, zD, zD2, false);
                    Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                    bitmapShader = new BitmapShader(createScaledBitmap, tileMode, tileMode);
                    break;
                case 1:
                    Bitmap createBitmap = Bitmap.createBitmap(zD, zD2 + 1, Bitmap.Config.ARGB_8888);
                    new Canvas(createBitmap).drawBitmap(a2, new Rect(0, 0, a2.getWidth(), a2.getHeight()), new RectF(0.0f, 0.0f, (float) zD, (float) zD2), (Paint) null);
                    bitmapShader = new BitmapShader(createBitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
                    break;
                case 2:
                    Bitmap createBitmap2 = Bitmap.createBitmap(zD + 1, zD2, Bitmap.Config.ARGB_8888);
                    new Canvas(createBitmap2).drawBitmap(a2, new Rect(0, 0, a2.getWidth(), a2.getHeight()), new RectF(0.0f, 0.0f, (float) zD, (float) zD2), (Paint) null);
                    bitmapShader = new BitmapShader(createBitmap2, Shader.TileMode.CLAMP, Shader.TileMode.REPEAT);
                    break;
                case 3:
                    Bitmap createBitmap3 = Bitmap.createBitmap(zD + 1, zD2 + 1, Bitmap.Config.ARGB_8888);
                    new Canvas(createBitmap3).drawBitmap(a2, new Rect(0, 0, a2.getWidth(), a2.getHeight()), new RectF(0.0f, 0.0f, (float) zD, (float) zD2), (Paint) null);
                    Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
                    bitmapShader = new BitmapShader(createBitmap3, tileMode2, tileMode2);
                    break;
                default:
                    bitmapShader = null;
                    break;
            }
            aVar.setShader(bitmapShader);
        }
        AppMethodBeat.o(145064);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public boolean equals(Object obj) {
        AppMethodBeat.i(145065);
        if (this == obj) {
            AppMethodBeat.o(145065);
            return true;
        } else if (!(obj instanceof RealSetFillStyleActionPatternArg)) {
            AppMethodBeat.o(145065);
            return false;
        } else if (!super.equals(obj)) {
            AppMethodBeat.o(145065);
            return false;
        } else {
            RealSetFillStyleActionPatternArg realSetFillStyleActionPatternArg = (RealSetFillStyleActionPatternArg) obj;
            if (!Objects.equals(this.path, realSetFillStyleActionPatternArg.path) || !Objects.equals(this.kZG, realSetFillStyleActionPatternArg.kZG)) {
                AppMethodBeat.o(145065);
                return false;
            }
            AppMethodBeat.o(145065);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public int hashCode() {
        AppMethodBeat.i(145066);
        int hash = Objects.hash(Integer.valueOf(super.hashCode()), this.path, this.kZG);
        AppMethodBeat.o(145066);
        return hash;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void i(Parcel parcel) {
        AppMethodBeat.i(145067);
        super.i(parcel);
        this.path = parcel.readString();
        this.kZG = parcel.readString();
        AppMethodBeat.o(145067);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(145068);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.path);
        parcel.writeString(this.kZG);
        AppMethodBeat.o(145068);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionArg
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionArg
    public final void f(JSONArray jSONArray) {
        AppMethodBeat.i(145069);
        super.f(jSONArray);
        this.path = jSONArray.optString(1);
        this.kZG = jSONArray.optString(2);
        AppMethodBeat.o(145069);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
    public final void parse(JSONObject jSONObject) {
        AppMethodBeat.i(145070);
        super.parse(jSONObject);
        AppMethodBeat.o(145070);
    }

    static {
        AppMethodBeat.i(145071);
        AppMethodBeat.o(145071);
    }
}
