package com.tencent.qbar.a;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.qbar.a;
import java.util.List;

public final class a {
    private static List<a.C2180a> a(Bitmap bitmap, int[] iArr) {
        AppMethodBeat.i(91184);
        com.tencent.scanlib.b.a aVar = new com.tencent.scanlib.b.a("MicroMsg.ScanImageUtil");
        aVar.a(1, com.tencent.scanlib.a.lb(MMApplicationContext.getContext()));
        if (aVar.hasInited()) {
            aVar.T(iArr);
        }
        List<a.C2180a> list = null;
        if (bitmap != null) {
            String.format("%s,%s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
            int[] iArr2 = new int[(bitmap.getWidth() * bitmap.getHeight())];
            bitmap.getPixels(iArr2, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            List<a.C2180a> a2 = aVar.a(iArr2, new Point(bitmap.getWidth(), bitmap.getHeight()));
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(a2 == null ? 0 : a2.size());
            String.format("get %d decode results", objArr);
            for (a.C2180a aVar2 : a2) {
                new StringBuilder("result ").append(aVar2.typeName).append(",").append(aVar2.data);
            }
            list = a2;
        }
        aVar.release();
        AppMethodBeat.o(91184);
        return list;
    }

    public static a.C2180a b(Bitmap bitmap, int[] iArr) {
        AppMethodBeat.i(91185);
        List<a.C2180a> a2 = a(bitmap, iArr);
        if (a2 == null || a2.size() <= 0) {
            AppMethodBeat.o(91185);
            return null;
        }
        a.C2180a aVar = a2.get(0);
        AppMethodBeat.o(91185);
        return aVar;
    }
}
