package com.tencent.mm.plugin.sns.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

public final class e {
    public static byte[] cd(byte[] bArr) {
        AppMethodBeat.i(97701);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        Bitmap copy = decodeByteArray.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(copy);
        canvas.drawColor(-1);
        canvas.drawBitmap(decodeByteArray, 0.0f, 0.0f, (Paint) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(97701);
        return byteArray;
    }
}
