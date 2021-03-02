package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Build;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.blur.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u0000 02\u00020\u0001:\u0003012B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J&\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u001f\u001a\u00020\u0015J\u0016\u0010 \u001a\b\u0018\u00010!R\u00020\u00002\u0006\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020\u0015J\u0006\u0010%\u001a\u00020\u0015J\u0014\u0010&\u001a\u00020\u00152\n\u0010'\u001a\u00060\rR\u00020\u0000H\u0002J\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010)\u001a\u00020\u0015J\u0014\u0010*\u001a\u0004\u0018\u00010\u00172\b\u0010+\u001a\u0004\u0018\u00010\u0017H\u0002J\u001e\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u001dR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u00060\rR\u00020\u00000\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;", "", "()V", "encoderX264Encoder", "", "getEncoderX264Encoder", "()Z", "setEncoderX264Encoder", "(Z)V", "mFadeImageShader", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/FadeImageShader;", "playItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayItem;", "renderScriptBlur", "Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "getRenderScriptBlur", "()Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "setRenderScriptBlur", "(Lcom/tencent/mm/ui/blur/RenderScriptBlur;)V", "addBitmap", "", "bm", "Landroid/graphics/Bitmap;", "bmBg", "addImage", "path", "", "mWidth", "", "mHeight", "clearImages", "createPlayAction", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayAction;", "ts", "", "destroyRS", "initInGLThread", "loadImage", "playItem", "readPictureDegree", "resetTexId", "resizeBitmap", "bitmap", "start", "curTs", "viewPortWidth", "viewPortHeight", "Companion", "PlayAction", "PlayItem", "plugin-recordvideo_release"})
public final class g {
    private static final float[] BLQ = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] BLR = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private static final long BLS = BLS;
    private static final long BLT = BLT;
    private static final long BLU = ((BLT / 2) + BLS);
    private static final long BLV = (BLT + BLS);
    private static final long BLW = BLW;
    public static final a BLX = new a((byte) 0);
    private static final String TAG = TAG;
    private final ArrayList<c> BLM = new ArrayList<>();
    final b BLN = new b();
    e BLO;
    boolean BLP;

    public g() {
        AppMethodBeat.i(75314);
        AppMethodBeat.o(75314);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$Companion;", "", "()V", "FirstShowTime", "", "NormalAnimUnitTime", "NormalShowTime", "NormalTotalTime", "ScaleMatrix", "", "SingleImageAnimTime", "TAG", "", "ViewMatrix", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(75315);
        AppMethodBeat.o(75315);
    }

    public final void a(String str, e eVar) {
        AppMethodBeat.i(75306);
        p.h(str, "path");
        p.h(eVar, "renderScriptBlur");
        Log.i(TAG, "addImage");
        c cVar = new c();
        p.h(str, "<set-?>");
        cVar.path = str;
        this.BLM.add(cVar);
        AppMethodBeat.o(75306);
    }

    public final synchronized void eJm() {
        AppMethodBeat.i(75307);
        Log.i(TAG, "clearImages");
        this.BLM.clear();
        AppMethodBeat.o(75307);
    }

    public final synchronized void eJn() {
        AppMethodBeat.i(75308);
        ArrayList<c> arrayList = this.BLM;
        if (arrayList != null) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                next.cKI = 0;
                next.BMg = 0;
            }
            AppMethodBeat.o(75308);
        } else {
            AppMethodBeat.o(75308);
        }
    }

    public final void eJo() {
        AppMethodBeat.i(75309);
        try {
            e eVar = this.BLO;
            if (eVar != null) {
                eVar.destroy();
            }
            this.BLO = null;
            AppMethodBeat.o(75309);
        } catch (Exception e2) {
            this.BLO = null;
            AppMethodBeat.o(75309);
        }
    }

    private static int aLm(String str) {
        int i2;
        AppMethodBeat.i(75310);
        p.h(str, "path");
        try {
            i2 = BackwardSupportUtil.ExifHelper.getExifOrientation(str);
        } catch (IOException e2) {
            Log.printErrStackTrace(TAG, e2, "readPictureDegree", new Object[0]);
            i2 = 0;
        }
        AppMethodBeat.o(75310);
        return i2;
    }

    private static Bitmap am(Bitmap bitmap) {
        AppMethodBeat.i(75313);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(75313);
            return null;
        }
        if (bitmap.getWidth() % 2 == 1) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth() + 1, bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            if (createBitmap == null) {
                p.hyc();
            }
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            bitmap = createBitmap;
        }
        AppMethodBeat.o(75313);
        return bitmap;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayItem;", "", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;)V", "bm", "Landroid/graphics/Bitmap;", "getBm", "()Landroid/graphics/Bitmap;", "setBm", "(Landroid/graphics/Bitmap;)V", "bmBg", "getBmBg", "setBmBg", "bmHeight", "", "getBmHeight", "()I", "setBmHeight", "(I)V", "bmWidth", "getBmWidth", "setBmWidth", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "texBgId", "getTexBgId", "setTexBgId", "texId", "getTexId", "setTexId", "plugin-recordvideo_release"})
    public final class c {
        Bitmap BMd;
        int BMe;
        int BMf;
        int BMg;
        int cKI;
        Bitmap iKs;
        String path = "";

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayAction;", "", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;)V", "bgAlpha", "", "getBgAlpha", "()F", "setBgAlpha", "(F)V", "bgMvpMatrix", "", "getBgMvpMatrix", "()[F", "setBgMvpMatrix", "([F)V", "fgAlpha", "getFgAlpha", "setFgAlpha", "fgMvpMatrix", "getFgMvpMatrix", "setFgMvpMatrix", FirebaseAnalytics.b.INDEX, "", "getIndex", "()I", "setIndex", "(I)V", "plugin-recordvideo_release"})
    public final class b {
        float BLY = 1.0f;
        float BLZ;
        float[] BMa = new float[16];
        float[] BMb = new float[16];
        int index = -1;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            AppMethodBeat.i(75305);
            AppMethodBeat.o(75305);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void n(long r14, int r16, int r17) {
        /*
        // Method dump skipped, instructions count: 598
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.background.b.g.n(long, int, int):void");
    }

    private final void a(c cVar) {
        Bitmap bitmap;
        AppMethodBeat.i(75312);
        if (cVar.iKs == null || cVar.BMd == null) {
            com.tencent.mm.ac.c cVar2 = new com.tencent.mm.ac.c("addImage");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(cVar.path, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            options.inSampleSize = BitmapUtil.calculateInSampleSize(i2, i3, com.tencent.mm.plugin.recordvideo.b.e.BNm.getMaxSize(), com.tencent.mm.plugin.recordvideo.b.e.BNm.getMaxSize());
            options.inJustDecodeBounds = false;
            if (Build.VERSION.SDK_INT > 26 && (p.j(options.outColorSpace, ColorSpace.get(ColorSpace.Named.DCI_P3)) || p.j(options.outColorSpace, ColorSpace.get(ColorSpace.Named.DISPLAY_P3)))) {
                options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
            Bitmap am = am(MMBitmapFactory.decodeFile(cVar.path, options));
            Log.i(TAG, "resizeBitmap first ".concat(String.valueOf(cVar2)));
            long currentTimeMillis = System.currentTimeMillis();
            options.inSampleSize = BitmapUtil.calculateInSampleSize(i2, i3, com.tencent.mm.plugin.recordvideo.b.e.BNm.getMaxSize() / 2, com.tencent.mm.plugin.recordvideo.b.e.BNm.getMaxSize() / 2);
            Bitmap am2 = am(MMBitmapFactory.decodeFile(cVar.path, options));
            try {
                if (this.BLO == null) {
                    this.BLO = new e(MMApplicationContext.getContext());
                }
                e eVar = this.BLO;
                if (eVar == null) {
                    p.hyc();
                }
                Bitmap b2 = eVar.b(am2, 4.0f);
                p.g(b2, "renderScriptBlur!!.blur(tmpBg, 4f)");
                bitmap = b2;
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "rsblur exception", new Object[0]);
                Log.i(TAG, "rsblur exception, path:%s", cVar.path);
                if (Log.getLogLevel() > 0) {
                    Toast.makeText(MMApplicationContext.getContext(), "RenderScript Exception", 0).show();
                }
                Point eJv = com.tencent.mm.plugin.recordvideo.b.e.BNm.eJv();
                Bitmap createColorBitmap = BitmapUtil.createColorBitmap(Color.parseColor("#ff000000"), eJv.x, eJv.y);
                p.g(createColorBitmap, "BitmapUtil.createColorBi…0000\"), point.x, point.y)");
                bitmap = createColorBitmap;
            }
            Log.i(TAG, "fastblur cost:%s, sampleSize:%s, width:%s, height:%s resizeBitmap second ".concat(String.valueOf(cVar2)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(options.inSampleSize), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
            if (am != null) {
                int aLm = aLm(cVar.path);
                if (aLm != 0) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate((float) aLm);
                    Bitmap createBitmap = Bitmap.createBitmap(am, 0, 0, am.getWidth(), am.getHeight(), matrix, true);
                    Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                    cVar.iKs = createBitmap;
                    Bitmap bitmap2 = cVar.iKs;
                    if (bitmap2 == null) {
                        p.hyc();
                    }
                    cVar.BMe = bitmap2.getWidth();
                    Bitmap bitmap3 = cVar.iKs;
                    if (bitmap3 == null) {
                        p.hyc();
                    }
                    cVar.BMf = bitmap3.getHeight();
                    cVar.BMd = createBitmap2;
                    AppMethodBeat.o(75312);
                    return;
                }
                cVar.iKs = am;
                cVar.BMd = bitmap;
                Bitmap bitmap4 = cVar.iKs;
                if (bitmap4 == null) {
                    p.hyc();
                }
                cVar.BMe = bitmap4.getWidth();
                Bitmap bitmap5 = cVar.iKs;
                if (bitmap5 == null) {
                    p.hyc();
                }
                cVar.BMf = bitmap5.getHeight();
            }
        }
        AppMethodBeat.o(75312);
    }
}
