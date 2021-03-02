package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.b;
import android.support.v4.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

public enum a {
    ;
    
    private static volatile WeakReference<Bitmap> iIF;

    public static a valueOf(String str) {
        AppMethodBeat.i(121063);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(121063);
        return aVar;
    }

    public static Drawable aXX() {
        Bitmap bitmap;
        AppMethodBeat.i(121064);
        if (iIF == null || (bitmap = iIF.get()) == null || bitmap.isRecycled()) {
            iIF = new WeakReference<>(com.tencent.mm.compatible.f.a.decodeResource(MMApplicationContext.getResources(), R.raw.miniprogram_default_avatar));
        }
        b a2 = d.a(MMApplicationContext.getResources(), iIF.get());
        a2.eD();
        AppMethodBeat.o(121064);
        return a2;
    }
}
