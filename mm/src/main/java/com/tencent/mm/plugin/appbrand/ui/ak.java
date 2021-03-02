package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.b;
import android.support.v4.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

public final class ak {
    private static volatile WeakReference<Bitmap> iIF;

    public static Drawable bXP() {
        Bitmap bitmap;
        AppMethodBeat.i(177515);
        if (iIF == null || (bitmap = iIF.get()) == null || bitmap.isRecycled()) {
            iIF = new WeakReference<>(BitmapFactory.decodeResource(MMApplicationContext.getResources(), R.drawable.cg_));
        }
        b a2 = d.a(MMApplicationContext.getResources(), iIF.get());
        a2.eD();
        AppMethodBeat.o(177515);
        return a2;
    }
}
