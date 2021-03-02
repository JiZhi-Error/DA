package com.tencent.mm.loader.e.b;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.a.d;
import com.tencent.mm.sdk.platformtools.Log;

public class c extends f<ImageView> {
    boolean iao = true;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.loader.e.b.g] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.loader.e.b.d, com.tencent.mm.loader.e.b.f
    public /* bridge */ /* synthetic */ boolean a(Bitmap bitmap, g gVar) {
        return a(bitmap, (g<?>) gVar);
    }

    public c(g<ImageView> gVar) {
        super(gVar);
    }

    public c(g<ImageView> gVar, boolean z) {
        super(gVar);
        this.iao = z;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.loader.e.b.f
    public boolean a(Bitmap bitmap, g<?> gVar) {
        final ImageView imageView = (ImageView) gVar.getView();
        final Object value = gVar.iaG.value();
        if (imageView != null) {
            imageView.setImageMatrix(null);
            if (value instanceof d) {
                imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    /* class com.tencent.mm.loader.e.b.c.AnonymousClass1 */

                    public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                        Matrix D = ((d) value).D((float) view.getWidth(), (float) view.getHeight());
                        if (D != null) {
                            imageView.setScaleType(ImageView.ScaleType.MATRIX);
                            imageView.setImageMatrix(D);
                        }
                        imageView.removeOnLayoutChangeListener(this);
                    }
                });
            }
            imageView.setImageBitmap(bitmap);
            return true;
        }
        Log.e("MicroMsg.Loader.ImageViewShowTarget", "[onResourceReadyUI]  imageView is null");
        return true;
    }

    @Override // com.tencent.mm.loader.e.b.d, com.tencent.mm.loader.e.b.f
    public final void a(g<?> gVar, f<?, ?> fVar) {
        boolean z;
        if (gVar == null) {
            Log.w("MicroMsg.Loader.ImageViewShowTarget", "[ViewShowTarget] should show default view or options is null.");
            return;
        }
        ImageView imageView = (ImageView) gVar.getView();
        if (imageView != null && this.iao) {
            if (fVar.hYp > 0 || fVar.hYr != null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                imageView.setImageBitmap(null);
            } else if (fVar.hYp == 0) {
                imageView.setImageDrawable(fVar.hYr);
            } else {
                imageView.setImageResource(fVar.hYp);
            }
        }
    }

    @Override // com.tencent.mm.loader.e.b.d
    public final int aJV() {
        return this.ias.iaH;
    }
}
