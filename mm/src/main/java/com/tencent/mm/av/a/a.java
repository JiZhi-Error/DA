package com.tencent.mm.av.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.b;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.b.h;
import com.tencent.mm.av.a.c.d;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    private static a jaI = null;
    private b jaF;
    private b jaG;
    private final k jaH = new h();

    public static synchronized a bdb() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(130346);
            if (jaI == null) {
                jaI = new a(MMApplicationContext.getContext());
            }
            aVar = jaI;
            AppMethodBeat.o(130346);
        }
        return aVar;
    }

    public a(Context context) {
        AppMethodBeat.i(130347);
        a(b.db(context));
        AppMethodBeat.o(130347);
    }

    public a(b bVar) {
        AppMethodBeat.i(130348);
        a(bVar);
        AppMethodBeat.o(130348);
    }

    private synchronized void a(b bVar) {
        AppMethodBeat.i(130349);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("[cpan] image loader configuration is null.");
            AppMethodBeat.o(130349);
            throw illegalArgumentException;
        } else if (this.jaG == null) {
            this.jaF = new b(bVar);
            this.jaG = bVar;
            AppMethodBeat.o(130349);
        } else {
            Log.w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
            AppMethodBeat.o(130349);
        }
    }

    public final void loadImage(String str, ImageView imageView) {
        AppMethodBeat.i(130350);
        b(str, imageView, null, null, null);
        AppMethodBeat.o(130350);
    }

    public final void a(String str, ImageView imageView, com.tencent.mm.av.a.c.h hVar) {
        AppMethodBeat.i(130351);
        b(str, imageView, null, null, hVar);
        AppMethodBeat.o(130351);
    }

    public final void a(String str, ImageView imageView, c cVar, com.tencent.mm.av.a.c.h hVar) {
        AppMethodBeat.i(130352);
        b(str, imageView, cVar, null, hVar);
        AppMethodBeat.o(130352);
    }

    public final void a(String str, ImageView imageView, c cVar, k kVar, com.tencent.mm.av.a.c.h hVar) {
        AppMethodBeat.i(130353);
        b(str, imageView, cVar, kVar, hVar);
        AppMethodBeat.o(130353);
    }

    public final void a(String str, ImageView imageView, c cVar) {
        AppMethodBeat.i(130354);
        b(str, imageView, cVar, null, null);
        AppMethodBeat.o(130354);
    }

    public final void a(String str, ImageView imageView, c cVar, k kVar) {
        AppMethodBeat.i(130355);
        b(str, imageView, cVar, kVar, null);
        AppMethodBeat.o(130355);
    }

    private void b(String str, ImageView imageView, c cVar, k kVar, com.tencent.mm.av.a.c.h hVar) {
        c cVar2;
        k kVar2;
        AppMethodBeat.i(130356);
        if (cVar == null) {
            cVar2 = this.jaG.jaR;
        } else {
            cVar2 = cVar;
        }
        if (kVar == null) {
            kVar2 = this.jaH;
        } else {
            kVar2 = kVar;
        }
        c cVar3 = new c(imageView, str);
        a(imageView, cVar2);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
            b(imageView, cVar2);
            this.jaF.a(cVar3);
            kVar2.a(str, imageView, null, cVar2.jbE);
            AppMethodBeat.o(130356);
            return;
        }
        com.tencent.mm.av.a.f.b bVar = new com.tencent.mm.av.a.f.b(str, cVar3, a(cVar2), cVar2, kVar2, this.jaF, hVar);
        String Pc = bVar.Pc(str);
        Bitmap OQ = this.jaF.OQ(Pc);
        if (OQ == null || OQ.isRecycled()) {
            if (imageView != null) {
                b(imageView, cVar2);
            }
            if ((bVar.jaR.jbg || !this.jaF.YY()) && this.jaF.a(cVar3, str)) {
                this.jaF.a(bVar);
                this.jaF.a(bVar, cVar2.jbe);
            }
            AppMethodBeat.o(130356);
            return;
        }
        Log.d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", Pc);
        if (cVar2.jbl) {
            OQ = BitmapUtil.fastblur(OQ, cVar2.jbm);
        }
        if (imageView != null) {
            imageView.setImageBitmap(OQ);
        }
        bVar.AC(0);
        if (hVar != null) {
            hVar.b(str, imageView, new com.tencent.mm.av.a.d.b(OQ));
        }
        this.jaF.a(cVar3);
        AppMethodBeat.o(130356);
    }

    public final void a(String str, ImageView imageView) {
        AppMethodBeat.i(130357);
        this.jaF.a(new c(imageView, str));
        AppMethodBeat.o(130357);
    }

    public final void onScrollStateChanged(int i2) {
        AppMethodBeat.i(130358);
        Log.d("MicroMsg.imageloader.ImageLoader", "[cpan] on scroll state changed :%d", Integer.valueOf(i2));
        if (i2 == 0 || i2 == 1) {
            Log.d("MicroMsg.imageloader.ImageLoader", "[cpan] resume");
            this.jaF.jaK.resume();
            AppMethodBeat.o(130358);
            return;
        }
        Log.d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
        this.jaF.jaK.pause();
        AppMethodBeat.o(130358);
    }

    public final void detach() {
        AppMethodBeat.i(130359);
        if (this.jaF != null) {
            this.jaF.aHn();
        }
        AppMethodBeat.o(130359);
    }

    public final Bitmap OQ(String str) {
        AppMethodBeat.i(130360);
        if (this.jaF != null) {
            Bitmap OQ = this.jaF.OQ(str);
            AppMethodBeat.o(130360);
            return OQ;
        }
        AppMethodBeat.o(130360);
        return null;
    }

    public final void OR(String str) {
        AppMethodBeat.i(212679);
        if (this.jaF != null) {
            b bVar = this.jaF;
            if (bVar.jaJ != null) {
                bVar.jaJ.jaS.remove(str);
            }
        }
        AppMethodBeat.o(212679);
    }

    public final void h(String str, Bitmap bitmap) {
        AppMethodBeat.i(130361);
        if (this.jaF != null) {
            b bVar = this.jaF;
            if (bVar.jaJ != null) {
                bVar.jaJ.jaS.put(str, bitmap);
            }
        }
        AppMethodBeat.o(130361);
    }

    private void a(ImageView imageView, c cVar) {
        AppMethodBeat.i(130362);
        if (imageView == null || cVar == null) {
            Log.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default background view or options is null.");
            AppMethodBeat.o(130362);
        } else if (!cVar.bdh()) {
            imageView.setBackgroundDrawable(null);
            AppMethodBeat.o(130362);
        } else if (cVar.jbt == 0) {
            imageView.setBackgroundDrawable(cVar.h(this.jaG.aKy));
            AppMethodBeat.o(130362);
        } else {
            imageView.setBackgroundResource(cVar.jbt);
            AppMethodBeat.o(130362);
        }
    }

    private void b(ImageView imageView, c cVar) {
        AppMethodBeat.i(130363);
        if (imageView == null || cVar == null) {
            Log.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
            AppMethodBeat.o(130363);
        } else if (!cVar.bdg()) {
            if (cVar.hZF) {
                imageView.setImageDrawable(null);
            }
            AppMethodBeat.o(130363);
        } else if (cVar.jbq == 0) {
            imageView.setImageDrawable(cVar.g(this.jaG.aKy));
            AppMethodBeat.o(130363);
        } else {
            imageView.setImageResource(cVar.jbq);
            AppMethodBeat.o(130363);
        }
    }

    public final void a(String str, c cVar, d dVar) {
        AppMethodBeat.i(130365);
        this.jaF.a(new com.tencent.mm.av.a.f.a(str, cVar, this.jaF, dVar));
        AppMethodBeat.o(130365);
    }

    private static MMHandler a(c cVar) {
        AppMethodBeat.i(130364);
        MMHandler mMHandler = cVar.handler;
        if (mMHandler == null || Looper.myLooper() == Looper.getMainLooper()) {
            mMHandler = new MMHandler();
        }
        AppMethodBeat.o(130364);
        return mMHandler;
    }
}
