package com.tencent.magicbrush.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.a.a.h;
import com.a.a.k;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.LegacyBitmap;
import com.github.henryye.nativeiv.b;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.d;
import com.github.henryye.nativeiv.c;
import com.tencent.magicbrush.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/magicbrush/image/BitmapDecoderMagicBrushExtension;", "Lcom/github/henryye/nativeiv/BitmapDecoder;", "()V", "TAG", "", "createBitmapWrapper", "Lcom/github/henryye/nativeiv/BitmapWrapper;", "mgr", "Lcom/github/henryye/nativeiv/BitmapDecoderFactoryMgr;", "decodeInfo", "Lcom/github/henryye/nativeiv/api/DecodeInfo;", "lib-magicbrush-nano_release"})
public final class a extends com.github.henryye.nativeiv.a {
    final String TAG = "MB.BitmapDecoderMagicBrushExtension";

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, hxF = {"com/tencent/magicbrush/image/BitmapDecoderMagicBrushExtension$createBitmapWrapper$1", "Lcom/github/henryye/nativeiv/BitmapWrapper;", "getPreferredSizeByConfig", "Lkotlin/Pair;", "", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "providePictureInfo", "Lcom/github/henryye/nativeiv/bitmap/PictureInfo;", "ins", "Ljava/io/InputStream;", "lib-magicbrush-nano_release"})
    /* renamed from: com.tencent.magicbrush.b.a$a  reason: collision with other inner class name */
    public static final class C0194a extends c {
        final /* synthetic */ a cOi;
        final /* synthetic */ b cOj;
        final /* synthetic */ com.github.henryye.nativeiv.api.a cOk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0194a(a aVar, b bVar, com.github.henryye.nativeiv.api.a aVar2, b bVar2, com.github.henryye.nativeiv.api.a aVar3) {
            super(bVar2, aVar3);
            this.cOi = aVar;
            this.cOj = bVar;
            this.cOk = aVar2;
        }

        @Override // com.github.henryye.nativeiv.c
        public final d i(InputStream inputStream) {
            AppMethodBeat.i(206865);
            p.h(inputStream, "ins");
            d i2 = super.i(inputStream);
            if (i2.bbo == com.github.henryye.nativeiv.bitmap.c.UNKNOWN) {
                com.github.henryye.nativeiv.a.b.w(this.cOi.TAG, "hy: unknown type. judge svg", new Object[0]);
                try {
                    h f2 = h.f(inputStream);
                    if (f2 != null) {
                        i2.bbo = com.github.henryye.nativeiv.bitmap.c.CUSTOM;
                        forceSetUseType(BitmapType.Legacy);
                        a(new C0195a(this, f2));
                    }
                } catch (k e2) {
                    com.github.henryye.nativeiv.a.b.printStackTrace(this.cOi.TAG, e2, "hy: not svg image. return as failed", new Object[0]);
                    i2.bbo = com.github.henryye.nativeiv.bitmap.c.UNKNOWN;
                }
            }
            p.g(i2, "info");
            AppMethodBeat.o(206865);
            return i2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016¨\u0006\u0010"}, hxF = {"com/tencent/magicbrush/image/BitmapDecoderMagicBrushExtension$createBitmapWrapper$1$providePictureInfo$1", "Lcom/github/henryye/nativeiv/bitmap/IBitmapFactory;", "Landroid/graphics/Bitmap;", "accept", "", "is", "Ljava/io/InputStream;", "config", "Landroid/graphics/Bitmap$Config;", "format", "Lcom/github/henryye/nativeiv/bitmap/PictureFormat;", "acceptRegion", "destroy", "", "produceBitmap", "Lcom/github/henryye/nativeiv/bitmap/IBitmap;", "lib-magicbrush-nano_release"})
        /* renamed from: com.tencent.magicbrush.b.a$a$a  reason: collision with other inner class name */
        public static final class C0195a implements com.github.henryye.nativeiv.bitmap.b<Bitmap> {
            final /* synthetic */ C0194a cOl;
            final /* synthetic */ h cOm;

            C0195a(C0194a aVar, h hVar) {
                this.cOl = aVar;
                this.cOm = hVar;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\n"}, hxF = {"com/tencent/magicbrush/image/BitmapDecoderMagicBrushExtension$createBitmapWrapper$1$providePictureInfo$1$produceBitmap$1", "Lcom/github/henryye/nativeiv/LegacyBitmap;", "decodeInputStreamImp", "Landroid/graphics/Bitmap;", "ins", "Ljava/io/InputStream;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "format", "Lcom/github/henryye/nativeiv/bitmap/PictureFormat;", "lib-magicbrush-nano_release"})
            /* renamed from: com.tencent.magicbrush.b.a$a$a$a  reason: collision with other inner class name */
            public static final class C0196a extends LegacyBitmap {
                final /* synthetic */ C0195a cOn;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                C0196a(C0195a aVar) {
                    this.cOn = aVar;
                }

                @Override // com.github.henryye.nativeiv.LegacyBitmap
                public final Bitmap a(InputStream inputStream, ImageDecodeConfig imageDecodeConfig, com.github.henryye.nativeiv.bitmap.c cVar) {
                    int i2;
                    AppMethodBeat.i(206863);
                    int qM = (int) this.cOn.cOm.qM();
                    int qN = (int) this.cOn.cOm.qN();
                    if (cVar != com.github.henryye.nativeiv.bitmap.c.CUSTOM || qM <= 0 || qM <= 0) {
                        Bitmap a2 = super.a(inputStream, imageDecodeConfig, cVar);
                        p.g(a2, "super.decodeInputStreamImp(ins, config, format)");
                        AppMethodBeat.o(206863);
                        return a2;
                    }
                    if (imageDecodeConfig != null) {
                        o a3 = C0194a.a(this.cOn.cOl, imageDecodeConfig);
                        if (a3.first.intValue() > 0 && a3.second.intValue() > 0) {
                            int intValue = a3.first.intValue();
                            i2 = a3.second.intValue();
                            qM = intValue;
                            Bitmap createBitmap = Bitmap.createBitmap(qM, i2, Bitmap.Config.ARGB_8888);
                            new Canvas(createBitmap).drawPicture(this.cOn.cOm.qL(), new RectF(0.0f, 0.0f, (float) qM, (float) i2));
                            p.g(createBitmap, "bitmap");
                            AppMethodBeat.o(206863);
                            return createBitmap;
                        }
                    }
                    i2 = qN;
                    Bitmap createBitmap2 = Bitmap.createBitmap(qM, i2, Bitmap.Config.ARGB_8888);
                    new Canvas(createBitmap2).drawPicture(this.cOn.cOm.qL(), new RectF(0.0f, 0.0f, (float) qM, (float) i2));
                    p.g(createBitmap2, "bitmap");
                    AppMethodBeat.o(206863);
                    return createBitmap2;
                }
            }

            @Override // com.github.henryye.nativeiv.bitmap.b
            public final IBitmap<Bitmap> sP() {
                AppMethodBeat.i(206864);
                C0196a aVar = new C0196a(this);
                AppMethodBeat.o(206864);
                return aVar;
            }

            @Override // com.github.henryye.nativeiv.bitmap.b
            public final boolean a(com.github.henryye.nativeiv.bitmap.c cVar) {
                return true;
            }

            @Override // com.github.henryye.nativeiv.bitmap.b
            public final void destroy() {
            }
        }

        public static final /* synthetic */ o a(C0194a aVar, ImageDecodeConfig imageDecodeConfig) {
            int i2;
            int i3;
            AppMethodBeat.i(206866);
            c.C0193c.d(aVar.cOi.TAG, "hy: image config width %d, height %d, scale %f", Integer.valueOf(imageDecodeConfig.mPreferredWidth), Integer.valueOf(imageDecodeConfig.mPreferredHeight), Double.valueOf(imageDecodeConfig.mPreferredScale));
            if (imageDecodeConfig.mPreferredWidth > 0 && imageDecodeConfig.mPreferredHeight > 0) {
                int i4 = imageDecodeConfig.mPreferredWidth;
                i2 = imageDecodeConfig.mPreferredHeight;
                i3 = i4;
            } else if (imageDecodeConfig.mPreferredScale > 0.0d) {
                int i5 = (int) (imageDecodeConfig.mPreferredScale * 0.0d);
                i2 = (int) (imageDecodeConfig.mPreferredScale * 0.0d);
                i3 = i5;
            } else {
                i2 = 0;
                i3 = 0;
            }
            o oVar = new o(Integer.valueOf(i3), Integer.valueOf(i2));
            AppMethodBeat.o(206866);
            return oVar;
        }
    }

    @Override // com.github.henryye.nativeiv.a
    public final com.github.henryye.nativeiv.c a(b bVar, com.github.henryye.nativeiv.api.a aVar) {
        AppMethodBeat.i(206867);
        p.h(bVar, "mgr");
        p.h(aVar, "decodeInfo");
        C0194a aVar2 = new C0194a(this, bVar, aVar, bVar, aVar);
        AppMethodBeat.o(206867);
        return aVar2;
    }
}
