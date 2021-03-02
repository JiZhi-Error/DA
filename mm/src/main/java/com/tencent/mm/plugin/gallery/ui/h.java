package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.d;
import com.tencent.mm.plugin.gallery.model.d;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class h extends Drawable {
    private static final Paint iuG;
    private ImageView cIN;
    private Bitmap mBitmap;
    private String mFilePath;
    private int mPosition;
    private int mediaType;
    private String xhV;
    private long xhW;
    private long xhY;
    private s.e xhZ;
    public a xsp;
    private Rect xsq = new Rect();
    private boolean xsr = false;
    private boolean xss = false;
    private boolean xst = false;

    public interface a {
        void dSs();
    }

    static {
        AppMethodBeat.i(111733);
        Paint paint = new Paint();
        iuG = paint;
        paint.setAntiAlias(true);
        iuG.setFilterBitmap(true);
        AppMethodBeat.o(111733);
    }

    private h(ImageView imageView) {
        AppMethodBeat.i(111722);
        this.cIN = imageView;
        this.mFilePath = "";
        this.xhV = "";
        AppMethodBeat.o(111722);
    }

    private void b(int i2, String str, String str2, long j2) {
        String eVar;
        AppMethodBeat.i(111723);
        if (Util.isNullOrNil(str)) {
            str = str2;
        }
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ThumbDrawable", "filepath is null or nil");
            AppMethodBeat.o(111723);
            return;
        }
        if (!this.mFilePath.equals(str) || this.mBitmap == null || this.mBitmap.isRecycled() || this.xsr || this.xss || this.xst) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.xsr);
            if (this.xhZ == null) {
                eVar = "";
            } else {
                eVar = this.xhZ.toString();
            }
            objArr[1] = eVar;
            Log.d("MicroMsg.ThumbDrawable", "setMediaFeature, crop area: %s %s.", objArr);
            if (this.xsr) {
                this.xsr = false;
            }
            Log.d("MicroMsg.ThumbDrawable", "setMediaFeature, path equal? [%s] isPositionUpdate? [%s] isDateModified? [%s] mModifyDate [%s].", Boolean.valueOf(this.mFilePath.equals(str)), Boolean.valueOf(this.xss), Boolean.valueOf(this.xst), Long.valueOf(this.xhY));
            if (this.xss) {
                this.xss = false;
            }
            if (this.xst) {
                this.xst = false;
            }
            this.mFilePath = str;
            this.xhV = str2;
            this.xhW = j2;
            this.mediaType = i2;
            this.mBitmap = e.dQJ().a(this.mFilePath, this.xhV, this.xhZ, this.xhY);
            Object[] objArr2 = new Object[4];
            objArr2[0] = str;
            objArr2[1] = Boolean.valueOf(this.mBitmap == null);
            objArr2[2] = this.mBitmap != null ? Boolean.valueOf(this.mBitmap.isRecycled()) : "";
            objArr2[3] = this;
            Log.d("MicroMsg.ThumbDrawable", "pennqin, set bitmap 1, filePath:[%s] mBitmap is null:[%s], mBitmap.isRecycled():[%s], this: %s.", objArr2);
            if (this.mBitmap == null || this.mBitmap.isRecycled()) {
                String a2 = d.a(this.mFilePath, this.xhZ, this.mPosition);
                Log.d("MicroMsg.ThumbDrawable", "traceGetLis, create & add listener 1: %s.", a2);
                e.dQJ().a(new c(this.cIN, a2));
                this.mBitmap = e.dQJ().a(this.mFilePath, i2, str2, j2, this.xhZ, this.mPosition, this.xhY);
                Object[] objArr3 = new Object[4];
                objArr3[0] = this.mFilePath;
                objArr3[1] = Boolean.valueOf(this.mBitmap == null);
                objArr3[2] = this.mBitmap != null ? Boolean.valueOf(this.mBitmap.isRecycled()) : "";
                objArr3[3] = this;
                Log.d("MicroMsg.ThumbDrawable", "pennqin, set bitmap 2, filePath:[%s] mBitmap is null:[%s], mBitmap.isRecycled():[%s], this: %s.", objArr3);
            } else {
                Object[] objArr4 = new Object[4];
                objArr4[0] = this.mFilePath;
                objArr4[1] = Boolean.valueOf(this.mBitmap == null);
                objArr4[2] = this.mBitmap != null ? Boolean.valueOf(this.mBitmap.isRecycled()) : "";
                objArr4[3] = this;
                Log.d("MicroMsg.ThumbDrawable", "pennqin, set bitmap 1 ok!!! filePath:[%s] mBitmap is null:[%s], mBitmap.isRecycled():[%s], this: %s.", objArr4);
            }
            if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
                this.cIN.invalidate();
                AppMethodBeat.o(111723);
                return;
            }
        } else {
            Object[] objArr5 = new Object[2];
            objArr5[0] = this.mFilePath;
            objArr5[1] = this.mBitmap != null ? Boolean.valueOf(this.mBitmap.isRecycled()) : "bitmap is null.";
            Log.d("MicroMsg.ThumbDrawable", "setMediaFeature filePath:[%s], mBitmap.isRecycled():[%s].", objArr5);
        }
        AppMethodBeat.o(111723);
    }

    public final int getIntrinsicWidth() {
        return 400;
    }

    public final int getIntrinsicHeight() {
        return 400;
    }

    public final void setBounds(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(111724);
        Log.d("MicroMsg.ThumbDrawable", "setBoundsLTRB:%d %d - %d %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        super.setBounds(i2, i3, i4, i5);
        AppMethodBeat.o(111724);
    }

    public final void setBounds(Rect rect) {
        AppMethodBeat.i(111725);
        Log.d("MicroMsg.ThumbDrawable", "setBoundsRECT:%s", rect.toString());
        super.setBounds(rect);
        AppMethodBeat.o(111725);
    }

    /* access modifiers changed from: package-private */
    public static final class c implements d.b {
        final WeakReference<ImageView> xsv;
        final String xsw;

        c(ImageView imageView, String str) {
            AppMethodBeat.i(111716);
            this.xsv = new WeakReference<>(imageView);
            this.xsw = str;
            AppMethodBeat.o(111716);
        }

        @Override // com.tencent.mm.plugin.gallery.model.d.b
        public final void ayR(String str) {
            AppMethodBeat.i(111717);
            Log.d("MicroMsg.ThumbDrawable", "onImageGet fileKey: %s.", str);
            Drawable dSu = dSu();
            if (dSu instanceof h) {
                h hVar = (h) dSu;
                if (com.tencent.mm.plugin.gallery.a.d.a(hVar.mFilePath, hVar.xhZ, hVar.mPosition).equals(str)) {
                    Log.d("MicroMsg.ThumbDrawable", "match!!! start invalidate, fileKey: %s. ", str);
                    ImageView imageView = this.xsv.get();
                    if (imageView != null) {
                        imageView.post(new b(imageView));
                    }
                }
                AppMethodBeat.o(111717);
                return;
            }
            Log.w("MicroMsg.ThumbDrawable", "drawable [%s] in ownerRef [%s] is not a ThumbDrawable, ignore.", dSu, this.xsv);
            AppMethodBeat.o(111717);
        }

        @Override // com.tencent.mm.plugin.gallery.model.d.b
        public final String dQG() {
            return this.xsw;
        }

        public final int hashCode() {
            AppMethodBeat.i(111718);
            Drawable dSu = dSu();
            if (dSu != null) {
                int hashCode = dSu.hashCode();
                AppMethodBeat.o(111718);
                return hashCode;
            }
            int hashCode2 = super.hashCode();
            AppMethodBeat.o(111718);
            return hashCode2;
        }

        public final boolean equals(Object obj) {
            Drawable drawable;
            AppMethodBeat.i(111719);
            if (obj == null) {
                AppMethodBeat.o(111719);
                return false;
            }
            Drawable dSu = dSu();
            if (obj instanceof c) {
                drawable = ((c) obj).dSu();
            } else if (obj instanceof h) {
                drawable = (Drawable) obj;
            } else {
                AppMethodBeat.o(111719);
                return false;
            }
            if (dSu == null || drawable == null) {
                AppMethodBeat.o(111719);
                return false;
            }
            boolean equals = dSu.equals(drawable);
            AppMethodBeat.o(111719);
            return equals;
        }

        private Drawable dSu() {
            AppMethodBeat.i(111720);
            ImageView imageView = this.xsv.get();
            if (imageView != null) {
                Drawable drawable = imageView.getDrawable();
                AppMethodBeat.o(111720);
                return drawable;
            }
            AppMethodBeat.o(111720);
            return null;
        }

        public final String toString() {
            AppMethodBeat.i(111721);
            String str = "decodeTaskKey:" + this.xsw + " ownerRef:" + this.xsv;
            AppMethodBeat.o(111721);
            return str;
        }
    }

    static final class b implements Runnable {
        final WeakReference<ImageView> xsu;

        b(ImageView imageView) {
            AppMethodBeat.i(111714);
            this.xsu = new WeakReference<>(imageView);
            AppMethodBeat.o(111714);
        }

        public final void run() {
            Drawable drawable;
            AppMethodBeat.i(111715);
            ImageView imageView = this.xsu.get();
            if (imageView == null) {
                drawable = null;
            } else {
                drawable = imageView.getDrawable();
            }
            if (!(drawable instanceof h)) {
                Log.w("MicroMsg.ThumbDrawable", "[tomys] ownerView is null or not a ThumbDrawable, ignore this task.");
                AppMethodBeat.o(111715);
                return;
            }
            h hVar = (h) drawable;
            Log.d("MicroMsg.ThumbDrawable", "invalidateSelf, mFilePath: %s.", hVar.mFilePath);
            com.tencent.mm.plugin.gallery.model.c dQJ = e.dQJ();
            String str = hVar.mFilePath;
            String str2 = hVar.xhV;
            long unused = hVar.xhW;
            hVar.mBitmap = dQJ.a(str, str2, hVar.xhZ, hVar.xhY);
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(hVar.mBitmap == null);
            objArr[1] = hVar.mFilePath;
            Log.d("MicroMsg.ThumbDrawable", "pennqin, set bitmap 3, bitmap is null %s filepath: %s.", objArr);
            if (hVar.mBitmap == null || hVar.mBitmap.isRecycled()) {
                String a2 = com.tencent.mm.plugin.gallery.a.d.a(hVar.mFilePath, hVar.xhZ, hVar.mPosition);
                Log.d("MicroMsg.ThumbDrawable", "traceGetLis, create & add listener 2: %s.", a2);
                e.dQJ().a(new c(hVar.cIN, a2));
                e.dQJ().a(hVar.mFilePath, hVar.mediaType, hVar.xhV, hVar.xhW, hVar.xhZ, hVar.mPosition, hVar.xhY);
                Log.d("MicroMsg.ThumbDrawable", "invalidateSelf! mBitmap is invalid! path:%s.", hVar.mFilePath);
            }
            hVar.invalidateSelf();
            AppMethodBeat.o(111715);
        }
    }

    public static void a(ImageView imageView, int i2, String str, String str2, long j2, long j3) {
        AppMethodBeat.i(179476);
        a(imageView, i2, str, str2, j2, -1, null, null, j3);
        AppMethodBeat.o(179476);
    }

    public static void a(ImageView imageView, int i2, String str, String str2, long j2, int i3, long j3) {
        AppMethodBeat.i(179477);
        a(imageView, i2, str, str2, j2, i3, null, null, j3);
        AppMethodBeat.o(179477);
    }

    public static void a(ImageView imageView, int i2, String str, String str2, long j2, a aVar, long j3) {
        AppMethodBeat.i(179478);
        a(imageView, i2, str, str2, j2, -1, aVar, null, j3);
        AppMethodBeat.o(179478);
    }

    public static void a(ImageView imageView, int i2, String str, String str2, long j2, s.e eVar) {
        AppMethodBeat.i(111730);
        a(imageView, i2, str, str2, j2, -1, null, eVar, 0);
        AppMethodBeat.o(111730);
    }

    private static void a(ImageView imageView, int i2, String str, String str2, long j2, int i3, a aVar, s.e eVar, long j3) {
        h hVar;
        AppMethodBeat.i(179479);
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof h) {
            hVar = (h) drawable;
        } else {
            hVar = new h(imageView);
        }
        hVar.a(eVar);
        hVar.NW(i3);
        hVar.GG(j3);
        hVar.xsp = aVar;
        hVar.b(i2, str, str2, j2);
        imageView.setImageDrawable(hVar);
        AppMethodBeat.o(179479);
    }

    public final void setAlpha(int i2) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return 0;
    }

    private void a(s.e eVar) {
        AppMethodBeat.i(111732);
        if (eVar == null) {
            this.xhZ = null;
            this.xsr = false;
            AppMethodBeat.o(111732);
            return;
        }
        if (!eVar.equals(this.xhZ)) {
            this.xsr = true;
            this.xhZ = eVar;
        }
        AppMethodBeat.o(111732);
    }

    private void NW(int i2) {
        if (this.mPosition != i2) {
            this.xss = true;
            this.mPosition = i2;
        }
    }

    private void GG(long j2) {
        if (this.xhY != j2) {
            this.xst = true;
            this.xhY = j2;
        }
    }

    public final void draw(Canvas canvas) {
        String str;
        String str2;
        Object[] objArr;
        Object[] objArr2;
        char c2;
        Object obj;
        boolean z;
        AppMethodBeat.i(111726);
        if (this.mBitmap == null || this.mBitmap.isRecycled()) {
            Object[] objArr3 = new Object[1];
            objArr3[0] = Boolean.valueOf(this.mBitmap == null);
            Log.d("MicroMsg.ThumbDrawable", "[duanyi] get bitmap is null: %s.", objArr3);
            String a2 = com.tencent.mm.plugin.gallery.a.d.a(this.mFilePath, this.xhZ, this.mPosition);
            Log.d("MicroMsg.ThumbDrawable", "traceGetLis, create & add listener 3: %s.", a2);
            e.dQJ().a(new c(this.cIN, a2));
            this.mBitmap = e.dQJ().a(this.mFilePath, this.mediaType, this.xhV, this.xhW, this.xhZ, this.mPosition, this.xhY);
            str = "MicroMsg.ThumbDrawable";
            str2 = "pennqin, set bitmap 4, filePath:[%s] mBitmap is null:[%s], mBitmap.isRecycled():[%s], this: %s.";
            Object[] objArr4 = new Object[4];
            objArr4[0] = this.mFilePath;
            if (this.mBitmap == null) {
                z = true;
            } else {
                z = false;
            }
            objArr4[1] = Boolean.valueOf(z);
            objArr4[2] = this.mBitmap != null ? Boolean.valueOf(this.mBitmap.isRecycled()) : "";
            c2 = 3;
            obj = this;
            objArr2 = objArr4;
            objArr = objArr4;
        } else {
            str = "MicroMsg.ThumbDrawable";
            str2 = "[duanyi test] get bitmap ok: %s crop area id: %s.";
            Object[] objArr5 = new Object[2];
            objArr5[0] = this.mFilePath;
            if (this.xhZ != null) {
                obj = this.xhZ.id;
                c2 = 1;
                objArr2 = objArr5;
                objArr = objArr5;
            } else {
                obj = "";
                c2 = 1;
                objArr2 = objArr5;
                objArr = objArr5;
            }
        }
        objArr2[c2] = obj;
        Log.d(str, str2, objArr);
        if (this.mBitmap == null || this.mBitmap.isRecycled()) {
            Log.d("MicroMsg.ThumbDrawable", "pennqin, get bitmap 4 fail!!! %s.", this.mFilePath);
            AppMethodBeat.o(111726);
            return;
        }
        if (this.xsp != null) {
            this.xsp.dSs();
            this.xsp = null;
        }
        Bitmap bitmap = this.mBitmap;
        Rect rect = this.xsq;
        if (bitmap.getWidth() > bitmap.getHeight()) {
            rect.top = 0;
            rect.bottom = bitmap.getHeight();
            rect.left = (bitmap.getWidth() - bitmap.getHeight()) >> 1;
            rect.right = bitmap.getHeight() + rect.left;
        } else {
            rect.left = 0;
            rect.right = bitmap.getWidth();
            rect.top = (bitmap.getHeight() - bitmap.getWidth()) >> 1;
            rect.bottom = bitmap.getWidth() + rect.top;
        }
        canvas.drawBitmap(this.mBitmap, this.xsq, getBounds(), iuG);
        Log.d("MicroMsg.ThumbDrawable", "bounds:%s", getBounds().toString());
        AppMethodBeat.o(111726);
    }
}
