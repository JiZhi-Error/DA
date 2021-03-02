package com.tencent.mm.x;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.mm.x.b;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u00018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004J0\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u000200J(\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020*2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0002J\u000e\u00103\u001a\u0002042\u0006\u0010,\u001a\u00020\u0006J\u000e\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020*J\u0006\u00107\u001a\u00020$R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00069"}, hxF = {"Lcom/tencent/mm/glrender/BitmapFilter;", "", "()V", "TAG", "", "TYPE_ORIGIN", "", "TYPE_STYLE1", "TYPE_STYLE2", "TYPE_STYLE3", "TYPE_STYLE4", "TYPE_STYLE5", "TYPE_STYLE6", "TYPE_STYLE7", "TYPE_STYLE8", "filterRender", "Lcom/tencent/mm/glrender/FilterRender;", "getFilterRender", "()Lcom/tencent/mm/glrender/FilterRender;", "setFilterRender", "(Lcom/tencent/mm/glrender/FilterRender;)V", "localRoot", "getLocalRoot", "()Ljava/lang/String;", "started", "", "getStarted", "()Z", "setStarted", "(Z)V", "typeList", "", "Lcom/tencent/mm/glrender/BitmapFilter$FilterInfo;", "getTypeList", "()Ljava/util/List;", "copyAssets", "", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "filterBitmap", "Landroid/graphics/Bitmap;", "preBitmap", "type", "targetWidth", "targetHeight", "colorWeight", "", "filterToTargetSizeByMatrix", "inputBitmap", "getMatrix", "", "start", "bitmap", "stop", "FilterInfo", "plugin-photoedit-sdk_release"})
public final class a {
    private static final String hiv = (com.tencent.mm.loader.j.b.aKC() + "photoedit");
    private static final List<C2173a> hiw;
    private static b hix;
    public static final a hiy = new a();
    private static boolean started;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/Bitmap;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Bitmap, x> {
        final /* synthetic */ z.f hiA;
        final /* synthetic */ Object hiz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Object obj, z.f fVar) {
            super(1);
            this.hiz = obj;
            this.hiA = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Bitmap bitmap) {
            AppMethodBeat.i(163151);
            T t = (T) bitmap;
            p.h(t, LocaleUtil.ITALIAN);
            synchronized (this.hiz) {
                try {
                    this.hiA.SYG = t;
                    this.hiz.notifyAll();
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(163151);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(163151);
            return xVar2;
        }
    }

    static {
        AppMethodBeat.i(163157);
        String string = MMApplicationContext.getContext().getString(R.string.fmd);
        p.g(string, "MMApplicationContext.get…photo_filter_name_origin)");
        String string2 = MMApplicationContext.getContext().getString(R.string.fm6);
        p.g(string2, "MMApplicationContext.get…ring.photo_filter_name_0)");
        String string3 = MMApplicationContext.getContext().getString(R.string.fm7);
        p.g(string3, "MMApplicationContext.get…ring.photo_filter_name_1)");
        String string4 = MMApplicationContext.getContext().getString(R.string.fm8);
        p.g(string4, "MMApplicationContext.get…ring.photo_filter_name_2)");
        String string5 = MMApplicationContext.getContext().getString(R.string.fm9);
        p.g(string5, "MMApplicationContext.get…ring.photo_filter_name_3)");
        String string6 = MMApplicationContext.getContext().getString(R.string.fm_);
        p.g(string6, "MMApplicationContext.get…ring.photo_filter_name_4)");
        String string7 = MMApplicationContext.getContext().getString(R.string.fma);
        p.g(string7, "MMApplicationContext.get…ring.photo_filter_name_5)");
        String string8 = MMApplicationContext.getContext().getString(R.string.fmb);
        p.g(string8, "MMApplicationContext.get…ring.photo_filter_name_6)");
        String string9 = MMApplicationContext.getContext().getString(R.string.fmc);
        p.g(string9, "MMApplicationContext.get…ring.photo_filter_name_7)");
        hiw = j.listOf((Object[]) new C2173a[]{new C2173a(0, string, ""), new C2173a(1, string2, hiv + "/filter_source_0.png"), new C2173a(2, string3, hiv + "/filter_source_1.png"), new C2173a(3, string4, hiv + "/filter_source_2.png"), new C2173a(4, string5, hiv + "/filter_source_3.png"), new C2173a(5, string6, hiv + "/filter_source_4.png"), new C2173a(6, string7, hiv + "/filter_source_5.png"), new C2173a(7, string8, hiv + "/filter_source_6.png"), new C2173a(8, string9, hiv + "/filter_source_7.png")});
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        AssetManager assets = context.getAssets();
        p.g(assets, "MMApplicationContext.getContext().assets");
        a(assets, "photofilters", hiv);
        AppMethodBeat.o(163157);
    }

    private a() {
    }

    public static List<C2173a> axh() {
        return hiw;
    }

    public static void A(Bitmap bitmap) {
        AppMethodBeat.i(163152);
        p.h(bitmap, "bitmap");
        if (!started) {
            b bVar = new b();
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            p.h(bitmap, "originBitmap");
            p.h(context, "context");
            bVar.hiE = bitmap;
            bVar.hiI = bitmap.getWidth();
            bVar.hiJ = bitmap.getHeight();
            bVar.handler.post(new b.RunnableC2174b(bVar));
            hix = bVar;
        }
        started = true;
        AppMethodBeat.o(163152);
    }

    public static void stop() {
        AppMethodBeat.i(163153);
        b bVar = hix;
        if (bVar != null) {
            bVar.handler.removeCallbacksAndMessages(null);
            Handler handler = bVar.callbackHandler;
            if (handler == null) {
                p.btv("callbackHandler");
            }
            handler.removeCallbacksAndMessages(null);
            bVar.handler.post(new b.c(bVar));
        }
        started = false;
        AppMethodBeat.o(163153);
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3, int i4, float f2) {
        T t;
        String str;
        boolean z;
        AppMethodBeat.i(163154);
        p.h(bitmap, "preBitmap");
        if (!started) {
            A(bitmap);
        }
        if (hix != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<T> it = hiw.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                if (next.type == i2) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    t = next;
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                str = t2.fileName;
            } else {
                str = null;
            }
            if (Util.isNullOrNil(str)) {
                if (i2 != 0) {
                    Log.e("MicroMsg.BitmapFilter", "lut file not exist:".concat(String.valueOf(str)));
                }
                b bVar = hix;
                if (bVar == null) {
                    p.hyc();
                }
                Bitmap axk = bVar.axk();
                if (axk == null) {
                    p.hyc();
                }
                Bitmap a2 = a(axk, i3, i4, i2);
                AppMethodBeat.o(163154);
                return a2;
            }
            Object obj = new Object();
            z.f fVar = new z.f();
            fVar.SYG = null;
            b bVar2 = hix;
            if (bVar2 == null) {
                p.hyc();
            }
            if (str == null) {
                p.hyc();
            }
            b bVar3 = new b(obj, fVar);
            p.h(str, "lutFilePath");
            p.h(bVar3, "callback");
            bVar2.handler.post(new b.a(bVar2, bVar3, str, f2));
            synchronized (obj) {
                try {
                    if (fVar.SYG == null) {
                        obj.wait();
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(163154);
                }
            }
            T t3 = fVar.SYG;
            if (t3 == null) {
                p.hyc();
            }
            if (i3 == t3.getWidth() && i4 == t3.getHeight()) {
                StringBuilder append = new StringBuilder("filterBitmap cost ").append(System.currentTimeMillis() - currentTimeMillis).append("ms, bitmap width:");
                b bVar4 = hix;
                if (bVar4 == null) {
                    p.hyc();
                }
                Bitmap axk2 = bVar4.axk();
                StringBuilder append2 = append.append((axk2 != null ? Integer.valueOf(axk2.getWidth()) : null).intValue()).append(", height:");
                b bVar5 = hix;
                if (bVar5 == null) {
                    p.hyc();
                }
                Bitmap axk3 = bVar5.axk();
                Log.i("MicroMsg.BitmapFilter", append2.append((axk3 != null ? Integer.valueOf(axk3.getHeight()) : null).intValue()).toString());
                T t4 = fVar.SYG;
                if (t4 == null) {
                    p.hyc();
                }
                return t4;
            }
            Bitmap a3 = a(t3, i3, i4, 0);
            StringBuilder append3 = new StringBuilder("filterBitmap cost ").append(System.currentTimeMillis() - currentTimeMillis).append("ms, bitmap width:");
            b bVar6 = hix;
            if (bVar6 == null) {
                p.hyc();
            }
            Bitmap axk4 = bVar6.axk();
            StringBuilder append4 = append3.append((axk4 != null ? Integer.valueOf(axk4.getWidth()) : null).intValue()).append(", height:");
            b bVar7 = hix;
            if (bVar7 == null) {
                p.hyc();
            }
            Bitmap axk5 = bVar7.axk();
            Log.i("MicroMsg.BitmapFilter", append4.append((axk5 != null ? Integer.valueOf(axk5.getHeight()) : null).intValue()).append(", targetWidth:").append(i3).append(", targetHeight:").append(i4).toString());
            AppMethodBeat.o(163154);
            return a3;
        }
        Log.w("MicroMsg.BitmapFilter", "filter render is null");
        Bitmap createBitmap = Bitmap.createBitmap(i3, i4, bitmap.getConfig());
        p.g(createBitmap, "Bitmap.createBitmap(targ…Height, preBitmap.config)");
        AppMethodBeat.o(163154);
        return createBitmap;
    }

    private static Bitmap a(Bitmap bitmap, int i2, int i3, int i4) {
        AppMethodBeat.i(163155);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(py(i4));
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, i2, i3), paint);
        p.g(createBitmap, "retBitmap");
        AppMethodBeat.o(163155);
        return createBitmap;
    }

    private static float[] py(int i2) {
        switch (i2) {
            case 0:
                return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
            case 1:
                return new float[]{2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
            case 2:
                return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
            case 3:
                return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
            case 4:
                return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 100.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
            case 5:
                return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 100.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
            default:
                return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        }
    }

    private static void a(AssetManager assetManager, String str, String str2) {
        Throwable th;
        Throwable th2;
        Throwable th3;
        Throwable th4 = null;
        AppMethodBeat.i(163156);
        p.h(assetManager, "assets");
        p.h(str, "assetsPath");
        p.h(str2, "localPath");
        try {
            String[] list = assetManager.list(str);
            if (list == null) {
                AppMethodBeat.o(163156);
                return;
            }
            p.g(list, "assets.list(assetsPath) ?: return");
            if (list.length == 0) {
                InputStream open = assetManager.open(str);
                try {
                    InputStream inputStream = open;
                    OutputStream LM = s.LM(str2);
                    try {
                        OutputStream outputStream = LM;
                        p.g(inputStream, "input");
                        p.g(outputStream, "output");
                        kotlin.f.a.e(inputStream, outputStream);
                        kotlin.f.b.a(LM, null);
                        kotlin.f.b.a(open, null);
                        AppMethodBeat.o(163156);
                    } catch (Throwable th5) {
                        th2 = th5;
                        th3 = th;
                        kotlin.f.b.a(LM, th3);
                        AppMethodBeat.o(163156);
                        throw th2;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    th4 = th;
                    kotlin.f.b.a(open, th4);
                    AppMethodBeat.o(163156);
                    throw th;
                }
            } else {
                s.boN(str2);
                for (String str3 : list) {
                    a(assetManager, str + '/' + str3, str2 + '/' + str3);
                }
                AppMethodBeat.o(163156);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BitmapFilter", e2, "copyAssets", new Object[0]);
            AppMethodBeat.o(163156);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/glrender/BitmapFilter$FilterInfo;", "", "type", "", "name", "", DownloadInfo.FILENAME, "(ILjava/lang/String;Ljava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "getName", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-photoedit-sdk_release"})
    /* renamed from: com.tencent.mm.x.a$a  reason: collision with other inner class name */
    public static final class C2173a {
        final String fileName;
        public final String name;
        public final int type;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
            if (kotlin.g.b.p.j(r3.fileName, r4.fileName) != false) goto L_0x0028;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 163150(0x27d4e, float:2.28622E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0028
                boolean r0 = r4 instanceof com.tencent.mm.x.a.C2173a
                if (r0 == 0) goto L_0x002d
                com.tencent.mm.x.a$a r4 = (com.tencent.mm.x.a.C2173a) r4
                int r0 = r3.type
                int r1 = r4.type
                if (r0 != r1) goto L_0x002d
                java.lang.String r0 = r3.name
                java.lang.String r1 = r4.name
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
                java.lang.String r0 = r3.fileName
                java.lang.String r1 = r4.fileName
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
            L_0x0028:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x002c:
                return r0
            L_0x002d:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x002c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.x.a.C2173a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(163149);
            int i3 = this.type * 31;
            String str = this.name;
            int hashCode = ((str != null ? str.hashCode() : 0) + i3) * 31;
            String str2 = this.fileName;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i4 = hashCode + i2;
            AppMethodBeat.o(163149);
            return i4;
        }

        public final String toString() {
            AppMethodBeat.i(163148);
            String str = "FilterInfo(type=" + this.type + ", name=" + this.name + ", fileName=" + this.fileName + ")";
            AppMethodBeat.o(163148);
            return str;
        }

        public C2173a(int i2, String str, String str2) {
            p.h(str, "name");
            p.h(str2, DownloadInfo.FILENAME);
            AppMethodBeat.i(163147);
            this.type = i2;
            this.name = str;
            this.fileName = str2;
            AppMethodBeat.o(163147);
        }
    }
}
