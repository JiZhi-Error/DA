package com.tencent.mm.plugin.gallery.picker.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.o;
import kotlin.x;

public final class b {
    public static final a xkW = new a((byte) 0);
    private a<String, f> xkS;
    private a<String, f> xkT;
    public a<String, f> xkU;
    private final com.tencent.f.b xkV = new com.tencent.f.b("MediaTailor", 3, 3, new LinkedBlockingQueue(), g.xlj);

    static {
        AppMethodBeat.i(164890);
        AppMethodBeat.o(164890);
    }

    public b(C1388b bVar) {
        p.h(bVar, "config");
        AppMethodBeat.i(164889);
        this.xkS = new e(bVar);
        this.xkT = new c(bVar);
        this.xkU = new c(bVar);
        AppMethodBeat.o(164889);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static Bitmap a(InputStream inputStream, int i2, int i3, boolean z, boolean z2) {
            int i4;
            int i5;
            float min;
            Bitmap bitmap;
            AppMethodBeat.i(164869);
            p.h(inputStream, "inputStream");
            if (i2 > i3) {
                i4 = i2;
                i5 = i3;
            } else {
                i4 = i3;
                i5 = i2;
            }
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(inputStream, false);
            if (imageOptions.outWidth <= imageOptions.outHeight) {
                float f2 = (1.0f * ((float) i5)) / ((float) imageOptions.outWidth);
                float f3 = (1.0f * ((float) i4)) / ((float) imageOptions.outHeight);
                if (f2 <= f3) {
                    f3 = f2;
                }
                min = Math.min(1.0f, f3);
            } else {
                float f4 = (1.0f * ((float) i5)) / ((float) imageOptions.outHeight);
                float f5 = (1.0f * ((float) i4)) / ((float) imageOptions.outWidth);
                if (f4 <= f5) {
                    f5 = f4;
                }
                min = Math.min(1.0f, f5);
            }
            inputStream.reset();
            Bitmap decodeStream = BitmapUtil.decodeStream(inputStream, 0.0f, (int) (((float) imageOptions.outWidth) * min), (int) (((float) imageOptions.outHeight) * min));
            if (z) {
                inputStream.reset();
                Exif fromStream = Exif.fromStream(inputStream);
                p.g(fromStream, "Exif.fromStream(inputStream)");
                int orientationInDegree = fromStream.getOrientationInDegree();
                Log.i("MediaTailor", "read exif rotate degree %d", Integer.valueOf(orientationInDegree));
                decodeStream = BitmapUtil.rotate(decodeStream, ((float) orientationInDegree) * 1.0f);
            }
            if (z2) {
                inputStream.close();
            }
            Log.i("MediaTailor", "[decodeBitmap] [" + imageOptions.outWidth + ':' + imageOptions.outHeight + "]->[" + (decodeStream != null ? Integer.valueOf(decodeStream.getWidth()) : null) + ':' + (decodeStream != null ? Integer.valueOf(decodeStream.getHeight()) : null) + "] scale=" + min + " limit[" + i5 + ':' + i4 + "] decode bitmap done!");
            if (decodeStream == null) {
                bitmap = BitmapUtil.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                Log.e("MediaTailor", "bitmap is null. " + Util.getStack());
            } else {
                bitmap = decodeStream;
            }
            p.g(bitmap, "bitmap");
            AppMethodBeat.o(164869);
            return bitmap;
        }
    }

    public final void a(a<String, f> aVar) {
        AppMethodBeat.i(164887);
        p.h(aVar, "<set-?>");
        this.xkT = aVar;
        AppMethodBeat.o(164887);
    }

    /* access modifiers changed from: package-private */
    public static final class g implements com.tencent.f.e {
        public static final g xlj = new g();

        static {
            AppMethodBeat.i(164886);
            AppMethodBeat.o(164886);
        }

        g() {
        }

        @Override // com.tencent.f.e
        public final void a(Runnable runnable, com.tencent.f.b bVar) {
        }
    }

    public static /* synthetic */ void a(b bVar, String str, int i2, Matrix matrix, Rect rect, Rect rect2, Rect rect3, int i3, m mVar) {
        d dVar;
        AppMethodBeat.i(257774);
        p.h(str, "input");
        p.h(matrix, "matrix");
        p.h(rect, "clipRect");
        p.h(rect2, "contentRect");
        p.h(rect3, "viewRect");
        p.h(mVar, "callback");
        if (i2 == 1) {
            dVar = new d(bVar, bVar.xkS, i3, mVar);
        } else {
            dVar = new d(bVar, bVar.xkT, i3, mVar);
        }
        p.h(rect, "<set-?>");
        dVar.xlb = rect;
        p.h(rect3, "<set-?>");
        dVar.viewRect = rect3;
        p.h(rect2, "<set-?>");
        dVar.rwL = rect2;
        p.h(str, "<set-?>");
        dVar.aWy = str;
        p.h(matrix, "<set-?>");
        dVar.gT = matrix;
        dVar.mediaType = i2;
        bVar.xkV.execute(dVar);
        AppMethodBeat.o(257774);
    }

    public final void destroy() {
        AppMethodBeat.i(257775);
        this.xkV.shutdownNow();
        AppMethodBeat.o(257775);
    }

    public final class d implements Runnable {
        public String aWy;
        public Matrix gT;
        private final m<Boolean, f, x> gWp;
        int mediaType;
        public Rect rwL;
        private final int token;
        public Rect viewRect;
        public Rect xlb;
        f xlc = new f(0);
        private final a<String, f> xld;
        final /* synthetic */ b xle;

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.g.a.m<? super java.lang.Boolean, ? super com.tencent.mm.plugin.gallery.picker.b.b$f, kotlin.x> */
        /* JADX WARN: Multi-variable type inference failed */
        public d(b bVar, a<String, f> aVar, int i2, m<? super Boolean, ? super f, x> mVar) {
            p.h(aVar, "generate");
            p.h(mVar, "callback");
            this.xle = bVar;
            AppMethodBeat.i(164881);
            this.xld = aVar;
            this.token = i2;
            this.gWp = mVar;
            AppMethodBeat.o(164881);
        }

        public final void run() {
            AppMethodBeat.i(164880);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                a<String, f> aVar = this.xld;
                String str = this.aWy;
                if (str == null) {
                    p.btv("input");
                }
                int i2 = this.mediaType;
                Matrix matrix = this.gT;
                if (matrix == null) {
                    p.btv("matrix");
                }
                Rect rect = this.xlb;
                if (rect == null) {
                    p.btv("clipRect");
                }
                Rect rect2 = this.rwL;
                if (rect2 == null) {
                    p.btv("contentRect");
                }
                Rect rect3 = this.viewRect;
                if (rect3 == null) {
                    p.btv("viewRect");
                }
                this.xlc = aVar.a(str, i2, matrix, rect, rect2, rect3);
                Log.i("MediaTailor", "generate image cost: " + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception e2) {
                this.xlc.ret = -1;
                Log.printErrStackTrace("MediaTailor", e2, "", new Object[0]);
            } catch (Error e3) {
                this.xlc.ret = -1;
                Log.printErrStackTrace("MediaTailor", e3, "", new Object[0]);
            } finally {
                this.xlc.token = this.token;
                com.tencent.mm.ac.d.h(new a(this));
                AppMethodBeat.o(164880);
            }
        }

        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ d xlf;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar) {
                super(0);
                this.xlf = dVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                boolean z;
                AppMethodBeat.i(164874);
                m mVar = this.xlf.gWp;
                if (this.xlf.xlc.ret == 0) {
                    z = true;
                } else {
                    z = false;
                }
                mVar.invoke(Boolean.valueOf(z), this.xlf.xlc);
                x xVar = x.SXb;
                AppMethodBeat.o(164874);
                return xVar;
            }
        }
    }

    public static class f {
        int quality;
        public int ret;
        public String thumbPath = "";
        public int token;
        public String xli = "";

        public f(int i2) {
            this.ret = i2;
        }

        public final void ayV(String str) {
            AppMethodBeat.i(164884);
            p.h(str, "<set-?>");
            this.xli = str;
            AppMethodBeat.o(164884);
        }

        public final void HA(String str) {
            AppMethodBeat.i(164885);
            p.h(str, "<set-?>");
            this.thumbPath = str;
            AppMethodBeat.o(164885);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.picker.b.b$b */
    public static final class C1388b {
        public String filePath;
        public String filename;
        int iTf = 480;
        public int maxHeight = ((int) MMApplicationContext.getResources().getDimension(R.dimen.a8d));
        public int maxWidth = this.maxHeight;
        public String xkX = "";
        public int xkY = 80;
        public int xkZ;
        boolean xla;

        public C1388b() {
            AppMethodBeat.i(164871);
            AppMethodBeat.o(164871);
        }

        public final void ayU(String str) {
            AppMethodBeat.i(164870);
            p.h(str, "value");
            if (n.aS(str) != '/') {
                str = str + '/';
            }
            this.xkX = str;
            AppMethodBeat.o(164870);
        }
    }

    public static final class c implements a<String, f> {
        private final C1388b wez;

        public c(C1388b bVar) {
            p.h(bVar, "config");
            AppMethodBeat.i(164873);
            this.wez = bVar;
            AppMethodBeat.o(164873);
        }

        @Override // com.tencent.mm.plugin.gallery.picker.b.a
        public final /* synthetic */ f a(String str, int i2, Matrix matrix, Rect rect, Rect rect2, Rect rect3) {
            AppMethodBeat.i(257769);
            p.h(str, "input");
            p.h(matrix, "matrix");
            p.h(rect, "clipRect");
            p.h(rect2, "contentRect");
            p.h(rect3, "viewRect");
            f fVar = new f(-1);
            AppMethodBeat.o(257769);
            return fVar;
        }
    }

    public static final class e implements a<String, f> {
        private final C1388b wez;
        private int xlg;
        private int xlh;

        public e(C1388b bVar) {
            p.h(bVar, "config");
            AppMethodBeat.i(164883);
            this.wez = bVar;
            AppMethodBeat.o(164883);
        }

        @Override // com.tencent.mm.plugin.gallery.picker.b.a
        public final /* bridge */ /* synthetic */ f a(String str, int i2, Matrix matrix, Rect rect, Rect rect2, Rect rect3) {
            AppMethodBeat.i(257771);
            f a2 = a(str, matrix, rect, rect2, rect3);
            AppMethodBeat.o(257771);
            return a2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:48:0x023d, code lost:
            if (r2 == null) goto L_0x023f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.tencent.mm.plugin.gallery.picker.b.b.f a(java.lang.String r15, android.graphics.Matrix r16, android.graphics.Rect r17, android.graphics.Rect r18, android.graphics.Rect r19) {
            /*
            // Method dump skipped, instructions count: 827
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.picker.b.b.e.a(java.lang.String, android.graphics.Matrix, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):com.tencent.mm.plugin.gallery.picker.b.b$f");
        }

        private static Point a(float f2, float f3, int i2, int i3, float f4) {
            AppMethodBeat.i(257772);
            float f5 = f2 - (((float) i2) / 2.0f);
            float f6 = f3 - (((float) i3) / 2.0f);
            double sin = Math.sin(((double) (f4 / 180.0f)) * 3.141592653589793d);
            double cos = Math.cos(((double) (f4 / 180.0f)) * 3.141592653589793d);
            o oVar = new o(Float.valueOf((float) ((((double) f5) * cos) - (((double) f6) * sin))), Float.valueOf((float) ((((double) f6) * cos) + (sin * ((double) f5)))));
            if (f4 % 180.0f != 0.0f) {
                Point point = new Point(kotlin.h.a.cR(oVar.first.floatValue() + (((float) i3) / 2.0f)), kotlin.h.a.cR(oVar.second.floatValue() + (((float) i2) / 2.0f)));
                AppMethodBeat.o(257772);
                return point;
            }
            Point point2 = new Point(kotlin.h.a.cR(oVar.first.floatValue() + (((float) i2) / 2.0f)), kotlin.h.a.cR(oVar.second.floatValue() + (((float) i3) / 2.0f)));
            AppMethodBeat.o(257772);
            return point2;
        }

        private final Bitmap a(String str, Matrix matrix, Rect rect, Rect rect2) {
            int height;
            int width;
            int i2;
            AppMethodBeat.i(257773);
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            try {
                String k = s.k(str, false);
                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(k, false);
                Exif fromFile = Exif.fromFile(k);
                p.g(fromFile, "Exif.fromFile(vfsPath)");
                float orientationInDegree = (float) fromFile.getOrientationInDegree();
                float round = (float) Math.round(Math.atan2((double) fArr[1], (double) fArr[0]) * 57.29577951308232d);
                float f2 = round - orientationInDegree;
                if (f2 % 180.0f != 0.0f) {
                    p.g(newInstance, "regionDecoder");
                    height = newInstance.getWidth();
                    width = newInstance.getHeight();
                } else {
                    p.g(newInstance, "regionDecoder");
                    height = newInstance.getHeight();
                    width = newInstance.getWidth();
                }
                float height2 = (1.0f * ((float) height)) / ((float) rect2.height());
                float width2 = (1.0f * ((float) (rect.left - rect2.left))) / ((float) rect2.width());
                float f3 = width2 * 1.0f * ((float) width);
                float height3 = ((1.0f * ((float) (rect.top - rect2.top))) / ((float) rect2.height())) * 1.0f * ((float) height);
                float width3 = (((float) rect.width()) * height2) + f3;
                float height4 = (height2 * ((float) rect.height())) + height3;
                Point a2 = a(f3, height3, width, height, f2);
                Point a3 = a(width3, height4, width, height, f2);
                Rect rect3 = new Rect(Math.min(a2.x, a3.x), Math.min(a2.y, a3.y), Math.max(a2.x, a3.x), Math.max(a2.y, a3.y));
                this.xlg = rect3.width();
                this.xlh = rect3.height();
                Rect k2 = k(newInstance.getWidth(), newInstance.getHeight(), rect3);
                BitmapFactory.Options options = new BitmapFactory.Options();
                float max = Math.max(((float) ((int) (width3 - f3))) / ((float) this.wez.maxWidth), ((float) ((int) (height4 - height3))) / ((float) this.wez.maxHeight));
                if (max > 1.0f) {
                    i2 = (int) max;
                } else {
                    i2 = 1;
                }
                options.inSampleSize = i2;
                Bitmap decodeRegion = newInstance.decodeRegion(k2, options);
                if (decodeRegion != null) {
                    float height5 = ((float) decodeRegion.getHeight()) / ((float) decodeRegion.getWidth());
                    float f4 = ((float) this.wez.maxHeight) / ((float) this.wez.maxWidth);
                    if (height5 >= f4 && decodeRegion.getHeight() > this.wez.maxHeight) {
                        decodeRegion = Bitmap.createScaledBitmap(decodeRegion, kotlin.h.a.cR(((float) this.wez.maxHeight) / height5), this.wez.maxHeight, false);
                    } else if (height5 <= f4 && decodeRegion.getWidth() > this.wez.maxWidth) {
                        decodeRegion = Bitmap.createScaledBitmap(decodeRegion, this.wez.maxWidth, kotlin.h.a.cR(height5 * ((float) this.wez.maxWidth)), false);
                    }
                    if (decodeRegion != null) {
                        if (orientationInDegree - round != 0.0f) {
                            decodeRegion = BitmapUtil.rotate(decodeRegion, orientationInDegree - round);
                        }
                        newInstance.recycle();
                        AppMethodBeat.o(257773);
                        return decodeRegion;
                    }
                }
                decodeRegion = null;
                newInstance.recycle();
                AppMethodBeat.o(257773);
                return decodeRegion;
            } catch (IOException e2) {
                Log.i("MediaTailor", e2.getMessage());
                float[] fArr2 = new float[9];
                matrix.getValues(fArr2);
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = true;
                BitmapUtil.decodeFile(str, options2);
                matrix.getValues(fArr2);
                float round2 = (float) Math.round(Math.atan2((double) fArr2[1], (double) fArr2[0]) * 57.29577951308232d);
                Exif fromFile2 = Exif.fromFile(str);
                p.g(fromFile2, "Exif.fromFile(input)");
                float orientationInDegree2 = (float) fromFile2.getOrientationInDegree();
                if (orientationInDegree2 % 180.0f != 0.0f) {
                    int i3 = options2.outHeight;
                    options2.outHeight = options2.outWidth;
                    options2.outWidth = i3;
                }
                a aVar = b.xkW;
                int i4 = this.wez.maxWidth;
                int i5 = this.wez.maxHeight;
                p.h(str, "inputPath");
                InputStream openRead = s.openRead(str);
                p.g(openRead, "VFSFileOp.openRead(inputPath)");
                Bitmap a4 = a.a(openRead, i4, i5, false, true);
                Log.i("MediaTailor", "rawRotate=" + orientationInDegree2 + " cropRotation=" + round2 + " clipRect=" + rect);
                if (orientationInDegree2 - round2 != 0.0f) {
                    a4 = BitmapUtil.rotate(a4, orientationInDegree2 - round2);
                    p.g(a4, "BitmapUtil.rotate(source…rawRotate - cropRotation)");
                }
                float height6 = (1.0f * ((float) a4.getHeight())) / ((float) rect2.height());
                float width4 = (1.0f * ((float) (rect.left - rect2.left))) / ((float) rect2.width());
                float height7 = (1.0f * ((float) (rect.top - rect2.top))) / ((float) rect2.height());
                float width5 = width4 * 1.0f * ((float) a4.getWidth());
                float height8 = height7 * 1.0f * ((float) a4.getHeight());
                Rect k3 = k(a4.getWidth(), a4.getHeight(), new Rect(kotlin.h.a.cR(width5), kotlin.h.a.cR(height8), kotlin.h.a.cR((((float) rect.width()) * height6) + width5), kotlin.h.a.cR((((float) rect.height()) * height6) + height8)));
                Log.i("MediaTailor", "clipScale=" + height6 + " clipRect=[" + k3 + " -> " + rect + "] raw=[" + options2.outWidth + ':' + options2.outHeight + "] source=[" + a4.getWidth() + ':' + a4.getHeight() + "] rotate=" + (orientationInDegree2 - round2));
                Bitmap createBitmap = Bitmap.createBitmap(a4, k3.left, k3.top, k3.width(), k3.height());
                AppMethodBeat.o(257773);
                return createBitmap;
            }
        }

        private static Rect k(int i2, int i3, Rect rect) {
            if (rect.left < 0) {
                rect.left = 0;
            }
            if (rect.top < 0) {
                rect.top = 0;
            }
            if (rect.bottom < 0) {
                rect.bottom = 0;
            }
            if (rect.right < 0) {
                rect.right = 0;
            }
            if (rect.bottom > i3) {
                rect.bottom = i3;
            }
            if (rect.right > i2) {
                rect.right = i2;
            }
            return rect;
        }
    }
}
