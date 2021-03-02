package com.tencent.mm.av.a.f;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c implements Runnable {
    private Bitmap bitmap;
    private b jbK;
    private com.tencent.mm.av.a.c jbM;
    private String key;
    private String url;

    public c(String str, com.tencent.mm.av.a.c cVar, Bitmap bitmap2, b bVar, String str2) {
        this.url = str;
        this.jbM = cVar;
        this.bitmap = bitmap2;
        this.jbK = bVar;
        this.key = str2;
    }

    public final void run() {
        ImageView imageView;
        AppMethodBeat.i(130441);
        if (Util.isNullOrNil(this.url) || this.jbM == null || this.bitmap == null || this.bitmap.isRecycled() || this.jbK == null) {
            Log.w("MicroMsg.imageloader.ImageShowTask", "[cpan] run something is null.");
            AppMethodBeat.o(130441);
            return;
        }
        if (this.url.equals(this.jbK.jaM.get(Integer.valueOf(this.jbM.iaH)))) {
            com.tencent.mm.av.a.c cVar = this.jbM;
            Bitmap bitmap2 = this.bitmap;
            if (!(Looper.myLooper() != Looper.getMainLooper() || cVar.iaF == null || (imageView = cVar.iaF.get()) == null)) {
                imageView.setImageBitmap(bitmap2);
            }
            this.jbK.a(this.jbM);
            AppMethodBeat.o(130441);
            return;
        }
        Log.w("MicroMsg.imageloader.ImageShowTask", "[cpan] url is not equals view url.");
        AppMethodBeat.o(130441);
    }
}
