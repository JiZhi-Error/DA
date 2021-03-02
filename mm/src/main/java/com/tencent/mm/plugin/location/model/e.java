package com.tencent.mm.plugin.location.model;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public final class e {
    public static PackageInfo bg(Context context, String str) {
        PackageInfo packageInfo = null;
        AppMethodBeat.i(55683);
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 1);
            AppMethodBeat.o(55683);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.MapUtil", e2, "", new Object[0]);
            AppMethodBeat.o(55683);
        } catch (ActivityNotFoundException e3) {
            Log.printErrStackTrace("MicroMsg.MapUtil", e3, "", new Object[0]);
            AppMethodBeat.o(55683);
        }
        return packageInfo;
    }

    public static String a(LocationInfo locationInfo) {
        AppMethodBeat.i(55684);
        if (locationInfo.dWi == null) {
            locationInfo.dWi = "";
        }
        String str = "<msg><location x=\"" + locationInfo.yFu + "\" y=\"" + locationInfo.yFv + "\" scale=\"" + locationInfo.yFw + "\" label=\"" + Util.escapeStringForXml(locationInfo.yFx) + "\" poiname=\"" + Util.escapeStringForXml(locationInfo.dWi) + "\" maptype=\"0\" /></msg>";
        AppMethodBeat.o(55684);
        return str;
    }

    public static String b(String str, String str2, View view) {
        OutputStream outputStream;
        AppMethodBeat.i(55685);
        Log.d("MicroMsg.MapUtil", "w h " + view.getWidth() + " " + ((view.getHeight() / 2) + 20));
        String str3 = str + str2 + ".png";
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), (int) (((double) view.getHeight()) * 0.7d), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        try {
            Log.d("MicroMsg.MapUtil", "saveMyBitmap ".concat(String.valueOf(str2)));
            o oVar = new o(str + str2 + ".png");
            oVar.createNewFile();
            try {
                outputStream = s.ap(oVar);
            } catch (FileNotFoundException e2) {
                Log.printErrStackTrace("MicroMsg.MapUtil", e2, "", new Object[0]);
                outputStream = null;
            }
            Log.d("MicroMsg.MapUtil", "h " + createBitmap.getHeight() + " w:" + createBitmap.getWidth() + " ");
            createBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e3) {
                    Log.printErrStackTrace("MicroMsg.MapUtil", e3, "", new Object[0]);
                }
            }
            Log.i("MicroMsg.MapUtil", "bitmap recycle %s", createBitmap.toString());
            createBitmap.recycle();
            AppMethodBeat.o(55685);
            return str3;
        } catch (IOException e4) {
            Log.printErrStackTrace("MicroMsg.MapUtil", e4, "", new Object[0]);
            AppMethodBeat.o(55685);
            return null;
        }
    }

    public static boolean j(double d2, double d3) {
        AppMethodBeat.i(55686);
        if (Math.abs(d3) > 180.0d || Math.abs(d2) > 90.0d) {
            AppMethodBeat.o(55686);
            return false;
        }
        AppMethodBeat.o(55686);
        return true;
    }

    public static double[] b(double[] dArr) {
        boolean z;
        AppMethodBeat.i(55687);
        double d2 = dArr[0];
        double d3 = dArr[1];
        if (d2 < 72.004d || d2 > 137.8347d || d3 < 0.8293d || d3 > 55.8271d) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            double[] dArr2 = {d2, d3};
            AppMethodBeat.o(55687);
            return dArr2;
        }
        double d4 = d2 - 105.0d;
        double d5 = d3 - 35.0d;
        double sqrt = -100.0d + (2.0d * d4) + (3.0d * d5) + (0.2d * d5 * d5) + (0.1d * d4 * d5) + (0.2d * Math.sqrt(Math.abs(d4))) + ((((20.0d * Math.sin((6.0d * d4) * 3.141592653589793d)) + (20.0d * Math.sin((2.0d * d4) * 3.141592653589793d))) * 2.0d) / 3.0d) + ((((20.0d * Math.sin(3.141592653589793d * d5)) + (40.0d * Math.sin((d5 / 3.0d) * 3.141592653589793d))) * 2.0d) / 3.0d) + ((((160.0d * Math.sin((d5 / 12.0d) * 3.141592653589793d)) + (320.0d * Math.sin((3.141592653589793d * d5) / 30.0d))) * 2.0d) / 3.0d);
        double sin = ((((Math.sin((d4 / 30.0d) * 3.141592653589793d) * 300.0d) + (150.0d * Math.sin((d4 / 12.0d) * 3.141592653589793d))) * 2.0d) / 3.0d) + (d5 * 0.1d * d4) + 300.0d + d4 + (2.0d * d5) + (0.1d * d4 * d4) + (0.1d * Math.sqrt(Math.abs(d4))) + ((((20.0d * Math.sin((6.0d * d4) * 3.141592653589793d)) + (20.0d * Math.sin((2.0d * d4) * 3.141592653589793d))) * 2.0d) / 3.0d) + ((((20.0d * Math.sin(3.141592653589793d * d4)) + (40.0d * Math.sin((d4 / 3.0d) * 3.141592653589793d))) * 2.0d) / 3.0d);
        double d6 = (d3 / 180.0d) * 3.141592653589793d;
        double sin2 = Math.sin(d6);
        double d7 = 1.0d - (sin2 * (0.006693421622965943d * sin2));
        double sqrt2 = Math.sqrt(d7);
        double cos = (sin * 180.0d) / ((Math.cos(d6) * (6378245.0d / sqrt2)) * 3.141592653589793d);
        double d8 = d3 + ((sqrt * 180.0d) / ((6335552.717000426d / (d7 * sqrt2)) * 3.141592653589793d));
        double[] dArr3 = {(d2 * 2.0d) - (d2 + cos), (2.0d * d3) - d8};
        AppMethodBeat.o(55687);
        return dArr3;
    }
}
