package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class m implements h {
    int KeA;
    int KeU;
    int KeV;
    private float[] KeW;
    a KeX;
    Runnable KeY;
    long requestEnd;
    long requestStart;
    int scene;

    public interface a {
        void onFinish();

        void onStart();
    }

    public m() {
        this((byte) 0);
    }

    public m(byte b2) {
        this.scene = 0;
        this.KeA = 0;
        this.requestStart = 0;
        this.requestEnd = 0;
        this.scene = 0;
        this.KeU = 0;
        this.KeV = 0;
        this.KeX = null;
        this.KeW = null;
    }

    public m(int i2, int i3, int i4, float[] fArr, a aVar) {
        this.scene = 0;
        this.KeA = 0;
        this.requestStart = 0;
        this.requestEnd = 0;
        this.scene = i2;
        this.KeU = i3;
        this.KeV = i4;
        this.KeX = aVar;
        this.KeW = fArr;
    }

    public m(int i2, int i3, int i4, boolean z, boolean z2, float f2, a aVar) {
        AppMethodBeat.i(124378);
        this.scene = 0;
        this.KeA = 0;
        this.requestStart = 0;
        this.requestEnd = 0;
        this.scene = i2;
        this.KeU = i3;
        this.KeV = i4;
        this.KeX = aVar;
        if (z || z2) {
            if (this.KeW == null) {
                this.KeW = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
            }
            if (z) {
                float[] fArr = this.KeW;
                this.KeW[1] = f2;
                fArr[0] = f2;
            }
            if (z2) {
                float[] fArr2 = this.KeW;
                this.KeW[3] = f2;
                fArr2[2] = f2;
                AppMethodBeat.o(124378);
                return;
            }
        } else {
            this.KeW = null;
        }
        AppMethodBeat.o(124378);
    }

    public final void aG(Runnable runnable) {
        this.KeY = runnable;
    }

    @Override // com.tencent.mm.av.a.c.h
    public final Bitmap a(String str, View view, b bVar) {
        AppMethodBeat.i(124380);
        if (this.KeW == null) {
            AppMethodBeat.o(124380);
            return null;
        } else if (bVar == null || bVar.bitmap == null || bVar.bitmap.isRecycled()) {
            Log.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap bitmap is null");
            AppMethodBeat.o(124380);
            return null;
        } else if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap url is null");
            AppMethodBeat.o(124380);
            return null;
        } else {
            try {
                if ((view instanceof ImageView) && this.KeY != null && this.KeU == -1 && this.KeV == -1) {
                    final ImageView imageView = (ImageView) view;
                    this.KeU = imageView.getMeasuredWidth();
                    this.KeV = imageView.getMeasuredHeight();
                    if (this.KeU <= 0 || this.KeV <= 0) {
                        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                            /* class com.tencent.mm.pluginsdk.ui.applet.m.AnonymousClass1 */

                            public final void onGlobalLayout() {
                                AppMethodBeat.i(124376);
                                imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                m.this.KeU = imageView.getMeasuredWidth();
                                m.this.KeV = imageView.getMeasuredHeight();
                                Log.d("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap image delay layout:%d,%d", Integer.valueOf(m.this.KeU), Integer.valueOf(m.this.KeV));
                                m.this.KeY.run();
                                AppMethodBeat.o(124376);
                            }
                        });
                        bVar.jbI = true;
                        bVar.jbJ = true;
                        AppMethodBeat.o(124380);
                        return null;
                    }
                }
                Bitmap centerCropBitmap = BitmapUtil.getCenterCropBitmap(bVar.bitmap, this.KeU, this.KeV, true);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(centerCropBitmap, this.KeU, this.KeV, true);
                if (!(createScaledBitmap == centerCropBitmap || centerCropBitmap == null || centerCropBitmap.isRecycled())) {
                    Log.i("MicroMsg.ChattingBizImageDownloadListener", "bitmap recycle %s", centerCropBitmap.toString());
                    centerCropBitmap.recycle();
                }
                Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(createScaledBitmap, true, this.KeW, true);
                if (createScaledBitmap != null && !createScaledBitmap.isRecycled()) {
                    Log.i("MicroMsg.ChattingBizImageDownloadListener", "bitmap recycle %s", createScaledBitmap.toString());
                    createScaledBitmap.recycle();
                }
                AppMethodBeat.o(124380);
                return roundedCornerBitmap;
            } catch (OutOfMemoryError e2) {
                Log.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap OutOfMemoryError %s", e2.getMessage());
                AppMethodBeat.o(124380);
                return null;
            }
        }
    }

    @Override // com.tencent.mm.av.a.c.h
    public final void b(String str, View view, final b bVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(124381);
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = bVar.contentType;
        objArr[2] = Integer.valueOf(this.scene);
        if (bVar.bitmap == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[3] = Boolean.valueOf(z);
        Log.d("MicroMsg.ChattingBizImageDownloadListener", "onImageLoadFinish, url:%s, contentType: %s, scene: %d, bitmap == null: %b", objArr);
        if (this.KeX != null && bVar.bitmap != null && !bVar.bitmap.isRecycled()) {
            AnonymousClass2 r0 = new Runnable() {
                /* class com.tencent.mm.pluginsdk.ui.applet.m.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(124377);
                    m.this.requestEnd = System.currentTimeMillis();
                    if (m.this.KeX != null) {
                        m.this.KeX.onFinish();
                    }
                    g gVar = g.Kev;
                    if (g.aif(m.this.scene) && bVar.from == 2) {
                        f fVar = f.Ket;
                        f.b(m.this.KeA, true, m.this.requestEnd - m.this.requestStart);
                        f fVar2 = f.Ket;
                        f.by(m.this.KeA, true);
                    }
                    AppMethodBeat.o(124377);
                }
            };
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                r0.run();
            } else {
                MMHandlerThread.postToMainThread(r0);
            }
        } else if (bVar.bitmap == null || bVar.bitmap.isRecycled()) {
            this.requestEnd = System.currentTimeMillis();
            g gVar = g.Kev;
            if (g.aif(this.scene) && bVar.from == 2) {
                f fVar = f.Ket;
                f.b(this.KeA, false, this.requestEnd - this.requestStart);
                f fVar2 = f.Ket;
                f.by(this.KeA, false);
            }
        }
        if (bVar.from != 2) {
            AppMethodBeat.o(124381);
            return;
        }
        g gVar2 = g.Kev;
        if (g.mA(str, bVar.contentType)) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i2 = bVar.status;
        Log.d("MicroMsg.ChattingBizImageDownloadListener", "onImageLoadFinish, isDownloadWebp: %b, status: %d", Boolean.valueOf(z2), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                if (z2) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(86, 13, 1, false);
                    AppMethodBeat.o(124381);
                    return;
                }
                break;
            case 1:
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(86, 2, 1, false);
                if (z2) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(86, 15, 1, false);
                    AppMethodBeat.o(124381);
                    return;
                }
                break;
            case 3:
                if (z2) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(86, 14, 1, false);
                    break;
                }
                break;
        }
        AppMethodBeat.o(124381);
    }

    @Override // com.tencent.mm.av.a.c.h
    public final void b(String str, View view) {
        AppMethodBeat.i(124379);
        if (this.KeX != null) {
            this.KeX.onStart();
        }
        g gVar = g.Kev;
        if (g.beI(str)) {
            this.KeA = 1;
        } else {
            g gVar2 = g.Kev;
            if (g.beJ(str)) {
                this.KeA = 2;
            } else {
                this.KeA = 0;
            }
        }
        this.requestStart = System.currentTimeMillis();
        Log.d("MicroMsg.ChattingBizImageDownloadListener", "alvinluo onImageLoadStart requestImageType: %d, url: %s", Integer.valueOf(this.KeA), str);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(86, 0, 1, false);
        AppMethodBeat.o(124379);
    }
}
