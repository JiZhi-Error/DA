package com.bumptech.glide.load.d.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.g.f;
import com.bumptech.glide.g.j;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.a.g;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class h {
    public static final com.bumptech.glide.load.h<b> aLc = com.bumptech.glide.load.h.c("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", b.aEO);
    @Deprecated
    public static final com.bumptech.glide.load.h<g> aLd = g.aKY;
    public static final com.bumptech.glide.load.h<Boolean> aLe = com.bumptech.glide.load.h.c("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);
    public static final com.bumptech.glide.load.h<Boolean> aLf = com.bumptech.glide.load.h.c("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", Boolean.FALSE);
    private static final Set<String> aLg = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
    static final a aLh = new a() {
        /* class com.bumptech.glide.load.d.a.h.AnonymousClass1 */

        @Override // com.bumptech.glide.load.d.a.h.a
        public final void pD() {
        }

        @Override // com.bumptech.glide.load.d.a.h.a
        public final void a(e eVar, Bitmap bitmap) {
        }
    };
    private static final Set<ImageHeaderParser.ImageType> aLi = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final Queue<BitmapFactory.Options> aLj = k.ds(0);
    private final e aCj;
    private final com.bumptech.glide.load.b.a.b aFo;
    private final List<ImageHeaderParser> aFx;
    private final DisplayMetrics aJm;
    private final l aLk = l.pE();

    public interface a {
        void a(e eVar, Bitmap bitmap);

        void pD();
    }

    static {
        AppMethodBeat.i(77400);
        AppMethodBeat.o(77400);
    }

    public h(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, e eVar, com.bumptech.glide.load.b.a.b bVar) {
        AppMethodBeat.i(77392);
        this.aFx = list;
        this.aJm = (DisplayMetrics) j.checkNotNull(displayMetrics, "Argument must not be null");
        this.aCj = (e) j.checkNotNull(eVar, "Argument must not be null");
        this.aFo = (com.bumptech.glide.load.b.a.b) j.checkNotNull(bVar, "Argument must not be null");
        AppMethodBeat.o(77392);
    }

    public final v<Bitmap> a(InputStream inputStream, int i2, int i3, i iVar, a aVar) {
        boolean z;
        boolean z2;
        int i4;
        boolean z3;
        boolean z4;
        boolean contains;
        int round;
        int i5;
        boolean z5;
        float f2;
        int min;
        int i6;
        int floor;
        int floor2;
        AppMethodBeat.i(77393);
        j.checkArgument(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.aFo.a(65536, byte[].class);
        BitmapFactory.Options pC = pC();
        pC.inTempStorage = bArr;
        b bVar = (b) iVar.a(aLc);
        g gVar = (g) iVar.a(g.aKY);
        boolean booleanValue = ((Boolean) iVar.a(aLe)).booleanValue();
        if (iVar.a(aLf) == null || !((Boolean) iVar.a(aLf)).booleanValue()) {
            z = false;
        } else {
            z = true;
        }
        try {
            long qt = f.qt();
            int[] a2 = a(inputStream, pC, aVar, this.aCj);
            int i7 = a2[0];
            int i8 = a2[1];
            String str = pC.outMimeType;
            if (i7 == -1 || i8 == -1) {
                z2 = false;
            } else {
                z2 = z;
            }
            int b2 = com.bumptech.glide.load.f.b(this.aFx, inputStream, this.aFo);
            int dn = q.dn(b2);
            boolean z6 = q.m2do(b2);
            int i9 = i2 == Integer.MIN_VALUE ? i7 : i2;
            if (i3 == Integer.MIN_VALUE) {
                i4 = i8;
            } else {
                i4 = i3;
            }
            ImageHeaderParser.ImageType a3 = com.bumptech.glide.load.f.a(this.aFx, inputStream, this.aFo);
            e eVar = this.aCj;
            if (i7 > 0 && i8 > 0) {
                if (dn == 90 || dn == 270) {
                    f2 = gVar.l(i8, i7, i9, i4);
                } else {
                    f2 = gVar.l(i7, i8, i9, i4);
                }
                if (f2 <= 0.0f) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot scale with factor: " + f2 + " from: " + gVar + ", source: [" + i7 + "x" + i8 + "], target: [" + i9 + "x" + i4 + "]");
                    AppMethodBeat.o(77393);
                    throw illegalArgumentException;
                }
                g.EnumC0074g pB = gVar.pB();
                if (pB == null) {
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Cannot round with null rounding");
                    AppMethodBeat.o(77393);
                    throw illegalArgumentException2;
                }
                int i10 = i7 / ((int) (((double) (((float) i7) * f2)) + 0.5d));
                int i11 = i8 / ((int) (((double) (((float) i8) * f2)) + 0.5d));
                if (pB == g.EnumC0074g.MEMORY) {
                    min = Math.max(i10, i11);
                } else {
                    min = Math.min(i10, i11);
                }
                if (Build.VERSION.SDK_INT > 23 || !aLg.contains(pC.outMimeType)) {
                    int max = Math.max(1, Integer.highestOneBit(min));
                    if (pB != g.EnumC0074g.MEMORY || ((float) max) >= 1.0f / f2) {
                        i6 = max;
                    } else {
                        i6 = max << 1;
                    }
                } else {
                    i6 = 1;
                }
                pC.inSampleSize = i6;
                if (a3 == ImageHeaderParser.ImageType.JPEG) {
                    int min2 = Math.min(i6, 8);
                    floor = (int) Math.ceil((double) (((float) i7) / ((float) min2)));
                    floor2 = (int) Math.ceil((double) (((float) i8) / ((float) min2)));
                    int i12 = i6 / 8;
                    if (i12 > 0) {
                        floor /= i12;
                        floor2 /= i12;
                    }
                } else if (a3 == ImageHeaderParser.ImageType.PNG || a3 == ImageHeaderParser.ImageType.PNG_A) {
                    floor = (int) Math.floor((double) (((float) i7) / ((float) i6)));
                    floor2 = (int) Math.floor((double) (((float) i8) / ((float) i6)));
                } else if (a3 == ImageHeaderParser.ImageType.WEBP || a3 == ImageHeaderParser.ImageType.WEBP_A) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        floor = Math.round(((float) i7) / ((float) i6));
                        floor2 = Math.round(((float) i8) / ((float) i6));
                    } else {
                        floor = (int) Math.floor((double) (((float) i7) / ((float) i6)));
                        floor2 = (int) Math.floor((double) (((float) i8) / ((float) i6)));
                    }
                } else if (i7 % i6 == 0 && i8 % i6 == 0) {
                    floor = i7 / i6;
                    floor2 = i8 / i6;
                } else {
                    int[] a4 = a(inputStream, pC, aVar, eVar);
                    floor = a4[0];
                    floor2 = a4[1];
                }
                double l = (double) gVar.l(floor, floor2, i9, i4);
                if (Build.VERSION.SDK_INT >= 19) {
                    int c2 = c(l);
                    int i13 = (int) ((((double) c2) * l) + 0.5d);
                    pC.inTargetDensity = (int) ((((double) i13) * (l / ((double) (((float) i13) / ((float) c2))))) + 0.5d);
                    pC.inDensity = c(l);
                }
                if (a(pC)) {
                    pC.inScaled = true;
                } else {
                    pC.inTargetDensity = 0;
                    pC.inDensity = 0;
                }
                if (Log.isLoggable("Downsampler", 2)) {
                    new StringBuilder("Calculate scaling, source: [").append(i7).append("x").append(i8).append("], target: [").append(i9).append("x").append(i4).append("], power of two scaled: [").append(floor).append("x").append(floor2).append("], exact scale factor: ").append(f2).append(", power of 2 sample size: ").append(i6).append(", adjusted scale factor: ").append(l).append(", target density: ").append(pC.inTargetDensity).append(", density: ").append(pC.inDensity);
                }
            } else if (Log.isLoggable("Downsampler", 3)) {
                new StringBuilder("Unable to determine dimensions for: ").append(a3).append(" with target [").append(i9).append("x").append(i4).append("]");
            }
            l lVar = this.aLk;
            if (!z2 || Build.VERSION.SDK_INT < 26 || z6) {
                z3 = false;
            } else {
                z3 = i9 >= 128 && i4 >= 128 && lVar.pF();
                if (z3) {
                    pC.inPreferredConfig = Bitmap.Config.HARDWARE;
                    pC.inMutable = false;
                }
            }
            if (!z3) {
                if (bVar == b.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
                    pC.inPreferredConfig = Bitmap.Config.ARGB_8888;
                } else {
                    try {
                        z5 = com.bumptech.glide.load.f.a(this.aFx, inputStream, this.aFo).hasAlpha();
                    } catch (IOException e2) {
                        if (Log.isLoggable("Downsampler", 3)) {
                            new StringBuilder("Cannot determine whether the image has alpha or not from header, format ").append(bVar);
                        }
                        z5 = false;
                    }
                    pC.inPreferredConfig = z5 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                    if (pC.inPreferredConfig == Bitmap.Config.RGB_565) {
                        pC.inDither = true;
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 19) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (pC.inSampleSize == 1 || z4) {
                if (Build.VERSION.SDK_INT >= 19) {
                    contains = true;
                } else {
                    contains = aLi.contains(a3);
                }
                if (contains) {
                    if (i7 < 0 || i8 < 0 || !booleanValue || !z4) {
                        float f3 = a(pC) ? ((float) pC.inTargetDensity) / ((float) pC.inDensity) : 1.0f;
                        int i14 = pC.inSampleSize;
                        round = Math.round(((float) ((int) Math.ceil((double) (((float) i7) / ((float) i14))))) * f3);
                        int round2 = Math.round(((float) ((int) Math.ceil((double) (((float) i8) / ((float) i14))))) * f3);
                        if (Log.isLoggable("Downsampler", 2)) {
                            new StringBuilder("Calculated target [").append(round).append("x").append(round2).append("] for source [").append(i7).append("x").append(i8).append("], sampleSize: ").append(i14).append(", targetDensity: ").append(pC.inTargetDensity).append(", density: ").append(pC.inDensity).append(", density multiplier: ").append(f3);
                        }
                        i5 = round2;
                    } else {
                        i5 = i4;
                        round = i9;
                    }
                    if (round > 0 && i5 > 0) {
                        e eVar2 = this.aCj;
                        Bitmap.Config config = null;
                        if (Build.VERSION.SDK_INT >= 26) {
                            if (pC.inPreferredConfig != Bitmap.Config.HARDWARE) {
                                config = pC.outConfig;
                            }
                        }
                        if (config == null) {
                            config = pC.inPreferredConfig;
                        }
                        pC.inBitmap = eVar2.g(round, i5, config);
                    }
                }
            }
            Bitmap b3 = b(inputStream, pC, aVar, this.aCj);
            aVar.a(this.aCj, b3);
            if (Log.isLoggable("Downsampler", 2)) {
                new StringBuilder("Decoded ").append(j(b3)).append(" from [").append(i7).append("x").append(i8).append("] ").append(str).append(" with inBitmap ").append(j(pC.inBitmap)).append(" for [").append(i2).append("x").append(i3).append("], sample size: ").append(pC.inSampleSize).append(", density: ").append(pC.inDensity).append(", target density: ").append(pC.inTargetDensity).append(", thread: ").append(Thread.currentThread().getName()).append(", duration: ").append(f.p(qt));
            }
            Bitmap bitmap = null;
            if (b3 != null) {
                b3.setDensity(this.aJm.densityDpi);
                bitmap = q.a(this.aCj, b3, b2);
                if (!b3.equals(bitmap)) {
                    this.aCj.g(b3);
                }
            }
            return d.a(bitmap, this.aCj);
        } finally {
            b(pC);
            this.aFo.put(bArr);
            AppMethodBeat.o(77393);
        }
    }

    private static int c(double d2) {
        AppMethodBeat.i(77394);
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        int round = (int) Math.round(2.147483647E9d * d2);
        AppMethodBeat.o(77394);
        return round;
    }

    private static int[] a(InputStream inputStream, BitmapFactory.Options options, a aVar, e eVar) {
        AppMethodBeat.i(77395);
        options.inJustDecodeBounds = true;
        b(inputStream, options, aVar, eVar);
        options.inJustDecodeBounds = false;
        int[] iArr = {options.outWidth, options.outHeight};
        AppMethodBeat.o(77395);
        return iArr;
    }

    private static Bitmap b(InputStream inputStream, BitmapFactory.Options options, a aVar, e eVar) {
        Bitmap b2;
        AppMethodBeat.i(77396);
        if (options.inJustDecodeBounds) {
            inputStream.mark(10485760);
        } else {
            aVar.pD();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        String str = options.outMimeType;
        q.pI().lock();
        try {
            b2 = BitmapFactory.decodeStream(inputStream, null, options);
            q.pI().unlock();
            if (options.inJustDecodeBounds) {
                inputStream.reset();
            }
            AppMethodBeat.o(77396);
        } catch (IllegalArgumentException e2) {
            IOException iOException = new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + j(options.inBitmap), e2);
            Log.isLoggable("Downsampler", 3);
            if (options.inBitmap != null) {
                try {
                    inputStream.reset();
                    eVar.g(options.inBitmap);
                    options.inBitmap = null;
                    b2 = b(inputStream, options, aVar, eVar);
                    q.pI().unlock();
                    AppMethodBeat.o(77396);
                } catch (IOException e3) {
                    AppMethodBeat.o(77396);
                    throw iOException;
                }
            } else {
                AppMethodBeat.o(77396);
                throw iOException;
            }
        } catch (Throwable th) {
            q.pI().unlock();
            AppMethodBeat.o(77396);
            throw th;
        }
        return b2;
    }

    private static boolean a(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    @TargetApi(19)
    private static String j(Bitmap bitmap) {
        AppMethodBeat.i(77397);
        if (bitmap == null) {
            AppMethodBeat.o(77397);
            return null;
        }
        String str = "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (Build.VERSION.SDK_INT >= 19 ? " (" + bitmap.getAllocationByteCount() + ")" : "");
        AppMethodBeat.o(77397);
        return str;
    }

    private static synchronized BitmapFactory.Options pC() {
        BitmapFactory.Options poll;
        synchronized (h.class) {
            AppMethodBeat.i(77398);
            synchronized (aLj) {
                try {
                    poll = aLj.poll();
                } finally {
                    AppMethodBeat.o(77398);
                }
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                c(poll);
            }
        }
        return poll;
    }

    private static void b(BitmapFactory.Options options) {
        AppMethodBeat.i(77399);
        c(options);
        synchronized (aLj) {
            try {
                aLj.offer(options);
            } finally {
                AppMethodBeat.o(77399);
            }
        }
    }

    private static void c(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
