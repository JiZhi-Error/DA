package com.github.henryye.nativeiv;

import android.text.TextUtils;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.github.henryye.nativeiv.b.b;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.c;
import com.github.henryye.nativeiv.bitmap.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class a implements IImageDecodeService.a {
    private volatile boolean aMn = false;
    private b baq = new b();
    private BitmapType bar;
    private IImageDecodeService.b bas;
    private int mMaxHeight = 2048;
    private int mMaxWidth = 2048;

    public a() {
        AppMethodBeat.i(219790);
        b bVar = this.baq;
        bVar.bat.put(BitmapType.Native, new com.github.henryye.nativeiv.comm.a());
        AppMethodBeat.o(219790);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService.a
    public final void destroy() {
        AppMethodBeat.i(219791);
        this.aMn = true;
        b bVar = this.baq;
        for (int i2 = 0; i2 < bVar.bau.size(); i2++) {
            b.b(bVar.bau.get(bVar.bau.keyAt(i2)));
        }
        b.b(bVar.bat);
        AppMethodBeat.o(219791);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService.a
    public final boolean isDestroyed() {
        return this.aMn;
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService.a
    public final IBitmap a(String str, Object obj, b bVar, ImageDecodeConfig imageDecodeConfig) {
        IBitmap iBitmap;
        boolean z;
        long j2;
        boolean z2;
        IBitmap iBitmap2;
        AppMethodBeat.i(219792);
        com.github.henryye.nativeiv.api.a aVar = new com.github.henryye.nativeiv.api.a();
        int i2 = this.mMaxWidth;
        aVar.mMaxHeight = this.mMaxHeight;
        aVar.mMaxWidth = i2;
        aVar.mPath = str;
        aVar.baO = bVar.sS();
        try {
            b.a a2 = bVar.a(obj, imageDecodeConfig);
            if (a2.inputStream == null || !TextUtils.isEmpty(a2.errorMsg)) {
                aVar.baP = a2.errorMsg;
                this.bas.a(str, IImageDecodeService.b.a.NOT_EXIST, aVar);
                AppMethodBeat.o(219792);
                return null;
            }
            InputStream inputStream = a2.inputStream;
            c a3 = a(this.baq, aVar);
            a3.bar = this.bar;
            a3.bay = this.bas;
            d h2 = a3.h(inputStream);
            if (h2 == null) {
                this.bas.a(str, IImageDecodeService.b.a.PRE_DECODE_ERROR, aVar);
                AppMethodBeat.o(219792);
                return null;
            } else if (h2.bbo == c.UNKNOWN) {
                this.bas.a(str, IImageDecodeService.b.a.UNSUPPORTED_IMG_FORMAT, aVar);
                AppMethodBeat.o(219792);
                return null;
            } else {
                c cVar = h2.bbo;
                if (inputStream != null) {
                    if (a3.bar != null) {
                        b bVar2 = a3.baA;
                        int hashCode = a3.hashCode();
                        BitmapType bitmapType = a3.bar;
                        Map<BitmapType, com.github.henryye.nativeiv.bitmap.b> map = bVar2.bau.get(hashCode);
                        if (map != null && map.get(bitmapType) != null) {
                            iBitmap2 = map.get(bitmapType).sP();
                        } else if (bVar2.bat.get(bitmapType) != null) {
                            iBitmap2 = bVar2.bat.get(bitmapType).sP();
                        } else {
                            iBitmap2 = null;
                        }
                        a3.bax = iBitmap2;
                    } else {
                        b bVar3 = a3.baA;
                        Map<BitmapType, com.github.henryye.nativeiv.bitmap.b> map2 = bVar3.bau.get(a3.hashCode());
                        if (map2 != null) {
                            iBitmap = b.a(cVar, map2);
                        } else {
                            iBitmap = null;
                        }
                        if (iBitmap == null) {
                            iBitmap = b.a(cVar, bVar3.bat);
                        }
                        a3.bax = iBitmap;
                    }
                    boolean z3 = false;
                    try {
                        a3.bax.decodeInputStream(inputStream, imageDecodeConfig, cVar);
                        if (a3.bax.provide() != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z = z2;
                    } catch (IOException e2) {
                        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", e2, "hy: decodeInputStream", new Object[0]);
                        a3.bay.a(str, IImageDecodeService.b.a.IO_ERROR, a3.baz);
                        a3.bax.recycle();
                        z3 = true;
                        z = false;
                    } catch (OutOfMemoryError e3) {
                        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", e3, "hy: decodeInputStream", new Object[0]);
                        a3.bay.a(str, IImageDecodeService.b.a.OUT_OF_MEMORY, a3.baz);
                        a3.bax.recycle();
                        z3 = true;
                        z = false;
                    } catch (Throwable th) {
                        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", th, "hy: decode image exception", new Object[0]);
                        a3.bay.a(str, IImageDecodeService.b.a.NATIVE_DECODE_ERROR, a3.baz);
                        a3.bax.recycle();
                        z = false;
                    }
                    if (z3) {
                        com.github.henryye.nativeiv.c.b.b(inputStream);
                    } else {
                        try {
                            j2 = (long) inputStream.available();
                        } catch (IOException | IllegalStateException e4) {
                            com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", e4, "hy: get stream len failed!", new Object[0]);
                            j2 = 0;
                        }
                        if (!z && a3.bax.getType() == BitmapType.Native) {
                            com.github.henryye.nativeiv.a.b.i("Ni.BitmapWrapper", "hy: decode switch to legacy mode!", new Object[0]);
                            a3.bax = a3.baA.bat.get(BitmapType.Legacy).sP();
                            try {
                                a3.bax.decodeInputStream(inputStream, imageDecodeConfig, cVar);
                            } catch (IOException e5) {
                                com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", e5, "hy: IOException when use legacy", new Object[0]);
                                a3.bay.a(str, IImageDecodeService.b.a.IO_ERROR, a3.baz);
                            } catch (OutOfMemoryError e6) {
                                com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", e6, "hy: decodeInputStream", new Object[0]);
                                a3.bay.a(str, IImageDecodeService.b.a.OUT_OF_MEMORY, a3.baz);
                            } catch (Throwable th2) {
                                com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", th2, "hy: decode image exception", new Object[0]);
                                a3.bay.a(str, IImageDecodeService.b.a.NATIVE_DECODE_ERROR, a3.baz);
                            }
                        }
                        a3.baz.baM = j2;
                        a3.baz.baN = a3.bax.getDecodeTime();
                        a3.bay.a(str, IImageDecodeService.b.a.OK, a3.baz);
                        if (a3.bax.getType() == BitmapType.Legacy) {
                            a3.bay.a(str, IImageDecodeService.b.a.LEGACY_MODE, a3.baz);
                        }
                        if (a3.bax.provide() == null) {
                            a3.bax.recycle();
                            a3.bax = null;
                        }
                        com.github.henryye.nativeiv.c.b.b(inputStream);
                    }
                }
                if (h2.width > ((long) this.mMaxWidth) || h2.height > ((long) this.mMaxHeight)) {
                    this.bas.a(str, IImageDecodeService.b.a.HUGE_SIZE, aVar);
                    a3.bax.recycle();
                    AppMethodBeat.o(219792);
                    return null;
                }
                IBitmap iBitmap3 = a3.bax;
                AppMethodBeat.o(219792);
                return iBitmap3;
            }
        } catch (Exception e7) {
            this.bas.a(str, IImageDecodeService.b.a.THROW_EXCEPTION, aVar);
            com.github.henryye.nativeiv.a.b.e("DefaultBitmapDecoder", "ImageDecoder(%s) decode path[%s] error %s", bVar, obj.toString(), e7.toString());
            AppMethodBeat.o(219792);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public c a(b bVar, com.github.henryye.nativeiv.api.a aVar) {
        AppMethodBeat.i(219793);
        c cVar = new c(bVar, aVar);
        AppMethodBeat.o(219793);
        return cVar;
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService.a
    public final void aW(int i2, int i3) {
        this.mMaxWidth = i2;
        this.mMaxHeight = i3;
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService.a
    public final void a(IImageDecodeService.b bVar) {
        this.bas = bVar;
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService.a
    public final void forceSetUseType(BitmapType bitmapType) {
        this.bar = bitmapType;
    }
}
