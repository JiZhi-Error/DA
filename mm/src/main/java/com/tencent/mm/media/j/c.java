package com.tencent.mm.media.j;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.media.j.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ\b\u0010\u0016\u001a\u00020\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/media/render/MixRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "textureCropRect", "Landroid/graphics/Rect;", "calcBlurBgTextureCoord", "", "calcCenterLocation", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getTextureCropRect", "render", "bitmap", "Landroid/graphics/Bitmap;", "blurBgBitmap", "setBlendBitmap", "setBlurBgBitmap", "setTextureCropRect", "rect", "plugin-mediaeditor_release"})
public class c extends a {
    private final String TAG;
    public Rect ijA;

    public /* synthetic */ c(int i2, int i3, int i4, int i5, int i6) {
        this(i2, i3, i4, i5, 1, i6);
    }

    public c(int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i2, i3, i4, i5, i6, i7);
        this.TAG = "MicroMsg.MixRenderer";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.media.j.a
    public a aEC() {
        AppMethodBeat.i(93838);
        b bVar = new b(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
        bVar.ijA = this.ijA;
        b bVar2 = bVar;
        AppMethodBeat.o(93838);
        return bVar2;
    }

    public final void a(Bitmap bitmap, Bitmap bitmap2) {
        AppMethodBeat.i(93844);
        if (bitmap != null) {
            E(bitmap);
        }
        if (bitmap2 != null) {
            F(bitmap2);
            aMO();
            aMP();
        }
        aED();
        AppMethodBeat.o(93844);
    }

    @Override // com.tencent.mm.media.j.a
    public final void aED() {
        int i2;
        AppMethodBeat.i(93839);
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
        d dVar = this.ijq;
        if (dVar != null) {
            i2 = dVar.igv;
        } else {
            i2 = -1;
        }
        input(i2);
        super.aED();
        AppMethodBeat.o(93839);
    }

    private final void E(Bitmap bitmap) {
        AppMethodBeat.i(93840);
        if (this.ijo instanceof b) {
            a aVar = this.ijo;
            if (aVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
                AppMethodBeat.o(93840);
                throw tVar;
            }
            b.a((b) aVar, bitmap);
            AppMethodBeat.o(93840);
            return;
        }
        Log.e(this.TAG, "setBlendBitmap data don't match textureRender ");
        AppMethodBeat.o(93840);
    }

    private final void F(Bitmap bitmap) {
        AppMethodBeat.i(93841);
        if (this.ijo instanceof b) {
            a aVar = this.ijo;
            if (aVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
                AppMethodBeat.o(93841);
                throw tVar;
            }
            p.h(bitmap, "bitmap");
            ((b) aVar).ikc = bitmap;
            AppMethodBeat.o(93841);
            return;
        }
        Log.e(this.TAG, "setBlurBgBitmap data don't match textureRender ");
        AppMethodBeat.o(93841);
    }

    private final void aMO() {
        float f2;
        float f3;
        float f4;
        float f5;
        AppMethodBeat.i(93842);
        if (this.ijo instanceof b) {
            float f6 = ((float) this.hEp) / ((float) this.hDn);
            float f7 = ((float) this.hEq) / ((float) this.hDo);
            if (f7 < f6) {
                float f8 = f7 * ((float) this.hDn);
                f2 = (float) this.hEq;
                float f9 = (((float) this.hEp) - f8) / 2.0f;
                f5 = f9 + f8;
                f4 = f9;
                f3 = 0.0f;
            } else {
                float f10 = f6 * ((float) this.hDo);
                f2 = ((((float) this.hEq) - f10) / 2.0f) + f10;
                f3 = (((float) this.hEq) - f10) / 2.0f;
                f4 = 0.0f;
                f5 = (float) this.hEp;
            }
            Log.i(this.TAG, "calcCenterLocation drawWidth:" + this.hEp + " drawHeight:" + this.hEq + " textureWidth:" + this.hDn + " textureHeight:" + this.hDo + " top:" + f2 + " bottom:" + f3 + " left:" + f4 + " right:" + f5);
            a aVar = this.ijo;
            if (aVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
                AppMethodBeat.o(93842);
                throw tVar;
            }
            b bVar = (b) aVar;
            bVar.ike[0] = f2;
            bVar.ike[1] = f3;
            bVar.ike[2] = f4;
            bVar.ike[3] = f5;
            AppMethodBeat.o(93842);
            return;
        }
        Log.e(this.TAG, "calcCenterLocation data don't match textureRender ");
        AppMethodBeat.o(93842);
    }

    private final void aMP() {
        AppMethodBeat.i(93843);
        if (this.ijo instanceof b) {
            float f2 = ((float) this.hEp) / ((float) this.hDn);
            float f3 = ((float) this.hEq) / ((float) this.hDo);
            float[] fArr = new float[8];
            if (f2 < f3) {
                float f4 = f2 * ((float) this.hDo);
                float f5 = (((float) this.hEq) - f4) / f4;
                float f6 = (f5 / 2.0f) + 1.0f;
                float f7 = 0.0f - (f5 / 2.0f);
                fArr[0] = 0.0f;
                fArr[1] = f6;
                fArr[2] = 1.0f;
                fArr[3] = f6;
                fArr[4] = 0.0f;
                fArr[5] = f7;
                fArr[6] = 1.0f;
                fArr[7] = f7;
                Log.i(this.TAG, "calcBlurBgTextureCoord :[0.0, " + f6 + " \n 1.0, " + f6 + " \n 0.0, " + f7 + " \n 1.0, " + f7 + ']');
            } else {
                float f8 = ((float) this.hDn) * f3;
                float f9 = (((float) this.hEp) - f8) / f8;
                float f10 = 0.0f - (f9 / 2.0f);
                float f11 = (f9 / 2.0f) + 1.0f;
                fArr[0] = f10;
                fArr[1] = 1.0f;
                fArr[2] = f11;
                fArr[3] = 1.0f;
                fArr[4] = f10;
                fArr[5] = 0.0f;
                fArr[6] = f11;
                fArr[7] = 0.0f;
            }
            a aVar = this.ijo;
            if (aVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
                AppMethodBeat.o(93843);
                throw tVar;
            }
            b bVar = (b) aVar;
            p.h(fArr, "blurBgCoord");
            bVar.ikv.position(0);
            bVar.ikv.put(fArr);
            bVar.ikv.position(0);
            AppMethodBeat.o(93843);
            return;
        }
        Log.e(this.TAG, "calcBlurBgTextureCoord data don't match textureRender ");
        AppMethodBeat.o(93843);
    }

    @Override // com.tencent.mm.media.j.a
    public final d aEE() {
        a aVar = this.ijo;
        if (aVar != null) {
            return aVar.ijD;
        }
        return null;
    }
}
