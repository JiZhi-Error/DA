package com.tencent.mm.plugin.sns.lucky.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class a {
    public static n kd(String str, String str2) {
        AppMethodBeat.i(95174);
        int argb = Color.argb(51, 255, 255, 255);
        n aOo = r.aOo(str);
        if (aOo == null) {
            Log.e("MicroMsg.BlurHelper", "returnBitmap error1 ");
            AppMethodBeat.o(95174);
            return null;
        }
        n a2 = a(aOo.aSa(), str2, argb, 55);
        AppMethodBeat.o(95174);
        return a2;
    }

    public static n a(Bitmap bitmap, String str, int i2, int i3) {
        AppMethodBeat.i(95175);
        n H = n.H(BitmapUtil.fastblur(bitmap, i3));
        if (H == null) {
            Log.e("MicroMsg.BlurHelper", "returnBitmap error2 ");
        }
        if (H != null) {
            new Canvas(H.aSa()).drawColor(i2);
        }
        try {
            BitmapUtil.saveBitmapToImage(H.aSa(), 70, Bitmap.CompressFormat.JPEG, str, false);
        } catch (IOException e2) {
            Log.e("MicroMsg.BlurHelper", "error for exception " + e2.getMessage());
            Log.printErrStackTrace("MicroMsg.BlurHelper", e2, "", new Object[0]);
        }
        Log.i("MicroMsg.BlurHelper", "blur done bitmap  ".concat(String.valueOf(H)));
        AppMethodBeat.o(95175);
        return H;
    }
}
