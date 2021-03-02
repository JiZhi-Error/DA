package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFillStyleActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;

public final class q implements d {
    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final BaseDrawActionArg bzj() {
        AppMethodBeat.i(144914);
        SetFillStyleActionArg setFillStyleActionArg = new SetFillStyleActionArg();
        AppMethodBeat.o(144914);
        return setFillStyleActionArg;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final String getMethod() {
        return "setFillStyle";
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        BitmapShader bitmapShader;
        AppMethodBeat.i(144915);
        if (jSONArray.length() < 2) {
            AppMethodBeat.o(144915);
            return false;
        }
        String optString = jSONArray.optString(0);
        a aVar = dVar.kZm;
        if ("linear".equalsIgnoreCase(optString)) {
            if (jSONArray.length() < 3) {
                AppMethodBeat.o(144915);
                return false;
            }
            JSONArray optJSONArray = jSONArray.optJSONArray(1);
            if (optJSONArray == null || optJSONArray.length() < 4) {
                AppMethodBeat.o(144915);
                return false;
            }
            float f2 = g.f(optJSONArray, 0);
            float f3 = g.f(optJSONArray, 1);
            float f4 = g.f(optJSONArray, 2);
            float f5 = g.f(optJSONArray, 3);
            JSONArray optJSONArray2 = jSONArray.optJSONArray(2);
            if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                AppMethodBeat.o(144915);
                return false;
            }
            int[] iArr = new int[optJSONArray2.length()];
            float[] fArr = new float[optJSONArray2.length()];
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                JSONArray optJSONArray3 = optJSONArray2.optJSONArray(i2);
                if (optJSONArray3.length() >= 2) {
                    fArr[i2] = (float) optJSONArray3.optDouble(0);
                    iArr[i2] = g.r(optJSONArray3.optJSONArray(1));
                }
            }
            aVar.setShader(new LinearGradient(f2, f3, f4, f5, iArr, fArr, Shader.TileMode.CLAMP));
        } else if ("radial".equalsIgnoreCase(optString)) {
            if (jSONArray.length() < 3) {
                AppMethodBeat.o(144915);
                return false;
            }
            JSONArray optJSONArray4 = jSONArray.optJSONArray(1);
            if (optJSONArray4 == null || optJSONArray4.length() < 3) {
                AppMethodBeat.o(144915);
                return false;
            }
            float f6 = g.f(optJSONArray4, 0);
            float f7 = g.f(optJSONArray4, 1);
            float f8 = g.f(optJSONArray4, 2);
            if (f8 <= 0.0f) {
                Log.i("MicroMsg.Canvas.SetFillStyleAction", "setFillStyle(radial) failed, sr(%s) <= 0.", Float.valueOf(f8));
                AppMethodBeat.o(144915);
                return false;
            }
            JSONArray optJSONArray5 = jSONArray.optJSONArray(2);
            int[] iArr2 = new int[optJSONArray5.length()];
            float[] fArr2 = new float[optJSONArray5.length()];
            for (int i3 = 0; i3 < optJSONArray5.length(); i3++) {
                JSONArray optJSONArray6 = optJSONArray5.optJSONArray(i3);
                if (optJSONArray6.length() >= 2) {
                    fArr2[i3] = (float) optJSONArray6.optDouble(0);
                    iArr2[i3] = g.r(optJSONArray6.optJSONArray(1));
                }
            }
            aVar.setShader(new RadialGradient(f6, f7, f8, iArr2, fArr2, Shader.TileMode.CLAMP));
        } else if ("normal".equalsIgnoreCase(optString)) {
            JSONArray optJSONArray7 = jSONArray.optJSONArray(1);
            if (optJSONArray7 == null || optJSONArray7.length() < 4) {
                AppMethodBeat.o(144915);
                return false;
            }
            aVar.setShader(null);
            aVar.setColor(g.r(optJSONArray7));
        } else if ("pattern".equalsIgnoreCase(optString)) {
            String optString2 = jSONArray.optString(1);
            String optString3 = jSONArray.optString(2);
            if (Util.isNullOrNil(optString2)) {
                Log.w("MicroMsg.Canvas.SetFillStyleAction", "setFillStyle failed, type is pattern but image path is null or nil.");
                AppMethodBeat.o(144915);
                return false;
            }
            Bitmap a2 = dVar.kZr.a(dVar, optString2);
            if (a2 != null && !a2.isRecycled()) {
                int zD = g.zD(a2.getWidth());
                int zD2 = g.zD(a2.getHeight());
                char c2 = 65535;
                switch (optString3.hashCode()) {
                    case -934531685:
                        if (optString3.equals("repeat")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -724648153:
                        if (optString3.equals("no-repeat")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -436782906:
                        if (optString3.equals("repeat-x")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -436782905:
                        if (optString3.equals("repeat-y")) {
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
        }
        AppMethodBeat.o(144915);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.action.d
    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(144916);
        SetFillStyleActionArg setFillStyleActionArg = (SetFillStyleActionArg) drawActionArg;
        if (setFillStyleActionArg == null) {
            AppMethodBeat.o(144916);
            return false;
        }
        boolean a2 = setFillStyleActionArg.a(dVar, canvas);
        AppMethodBeat.o(144916);
        return a2;
    }
}
