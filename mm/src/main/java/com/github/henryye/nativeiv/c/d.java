package com.github.henryye.nativeiv.c;

import android.graphics.BitmapFactory;
import com.github.henryye.nativeiv.a.b;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private static final Map<String, c> bbu;

    static {
        AppMethodBeat.i(127398);
        HashMap hashMap = new HashMap(6);
        bbu = hashMap;
        hashMap.put("image/jpeg", c.JPG);
        bbu.put("image/gif", c.GIF);
        bbu.put("image/png", c.PNG);
        bbu.put("image/x-ms-bmp", c.BMP);
        bbu.put("image/bmp", c.BMP);
        bbu.put("image/webp", c.WEBP);
        AppMethodBeat.o(127398);
    }

    public static com.github.henryye.nativeiv.bitmap.d k(InputStream inputStream) {
        AppMethodBeat.i(127397);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream l = e.l(inputStream);
        l.mark(TPMediaCodecProfileLevel.HEVCHighTierLevel61);
        BitmapFactory.decodeStream(l, null, options);
        c cVar = bbu.get(options.outMimeType);
        if (cVar == null) {
            cVar = c.UNKNOWN;
        }
        try {
            l.reset();
        } catch (IOException e2) {
            b.printStackTrace("Ni.FormatUtil", e2, "hy: the given stream is markable, but still reset error. should not forward", new Object[0]);
            cVar = c.UNKNOWN;
        }
        com.github.henryye.nativeiv.bitmap.d dVar = new com.github.henryye.nativeiv.bitmap.d();
        dVar.bbo = cVar;
        dVar.height = (long) options.outHeight;
        dVar.width = (long) options.outWidth;
        AppMethodBeat.o(127397);
        return dVar;
    }
}
