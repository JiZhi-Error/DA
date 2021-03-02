package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class o {
    private static Map<String, f.a> tgi = new HashMap();
    private static com.tencent.mm.b.f<String, Bitmap> tgj = new b(10, o.class);
    private static com.tencent.mm.b.f<String, Bitmap> tgk = new b(20, o.class);
    public Context context;
    public h tgf;
    public HashMap<String, String[]> tgg = new HashMap<>();
    private HashMap<String, String[]> tgh = new HashMap<>();

    static /* synthetic */ void c(g gVar, aml aml, boolean z) {
        AppMethodBeat.i(106991);
        b(gVar, aml, z);
        AppMethodBeat.o(106991);
    }

    static {
        AppMethodBeat.i(106992);
        AppMethodBeat.o(106992);
    }

    public o(Context context2, int i2) {
        AppMethodBeat.i(106974);
        this.context = context2;
        this.tgf = new h(i2 <= 0 ? 24 : i2);
        AppMethodBeat.o(106974);
    }

    public final Context getContext() {
        return this.context;
    }

    private void cWc() {
        AppMethodBeat.i(106975);
        h hVar = this.tgf;
        synchronized (hVar.lock) {
            try {
                Log.d("MicroMsg.ImageEngine", "do clear mark");
                hVar.Kvt.clear();
                hVar.Kvu.clear();
                hVar.Kvt = new HashMap<>();
                hVar.Kvu = new HashMap<>();
            } finally {
                AppMethodBeat.o(106975);
            }
        }
    }

    public final void destory() {
        AppMethodBeat.i(106976);
        cWc();
        this.tgg.clear();
        this.tgh.clear();
        this.tgf.destroy();
        this.context = null;
        this.tgg = null;
        this.tgh = null;
        this.tgf = null;
        AppMethodBeat.o(106976);
    }

    private static boolean c(amt amt) {
        AppMethodBeat.i(106978);
        if (amt == null || amt.iwc != 5 || !((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld()) {
            AppMethodBeat.o(106978);
            return false;
        }
        AppMethodBeat.o(106978);
        return true;
    }

    public final void a(ImageView imageView, aml aml, g gVar, int i2, int i3, int i4) {
        String str;
        String str2;
        String str3 = null;
        AppMethodBeat.i(106979);
        if (imageView == null) {
            AppMethodBeat.o(106979);
        } else if (!e.apn()) {
            imageView.setImageResource(R.drawable.bjn);
            AppMethodBeat.o(106979);
        } else if (gVar == null) {
            AppMethodBeat.o(106979);
        } else {
            switch (gVar.field_type) {
                case 4:
                case 16:
                    if (aml != null) {
                        a(imageView, aml, gVar, aml.dFN, i2, i3, i4);
                        AppMethodBeat.o(106979);
                        return;
                    }
                    break;
                case 5:
                    boolean c2 = c(gVar.field_favProto.IXu);
                    Log.v("MicroMsg.FavoriteImageLogic", "alvinluo attachThumb isBizNativeVideo: %b", Boolean.valueOf(c2));
                    anq anq = gVar.field_favProto.LwS;
                    if (aml == null) {
                        if (anq != null) {
                            h hVar = this.tgf;
                            if (c2) {
                                str2 = com.tencent.mm.api.b.u(anq.thumbUrl, 4);
                            } else {
                                str2 = anq.thumbUrl;
                            }
                            hVar.a(imageView, null, str2, i2, i3, i4);
                        }
                        AppMethodBeat.o(106979);
                        return;
                    }
                    if (anq != null) {
                        str3 = anq.thumbUrl;
                    }
                    if (Util.isNullOrNil(str3)) {
                        str = aml.dFN;
                    } else {
                        str = str3;
                    }
                    if (c2) {
                        str = com.tencent.mm.api.b.u(str, 4);
                    }
                    a(imageView, aml, gVar, str, i2, i3, i4);
                    AppMethodBeat.o(106979);
                    return;
                case 6:
                case 8:
                case 9:
                case 12:
                case 13:
                case 14:
                case 17:
                case 18:
                case 19:
                case 20:
                default:
                    Log.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", Integer.valueOf(gVar.field_type));
                    AppMethodBeat.o(106979);
                    return;
                case 7:
                case 21:
                    if (aml != null) {
                        String a2 = a(imageView, aml, gVar, aml.dFN, i2, i3, i4);
                        if (!(aml.Lwh == null || aml.Lwh.Lxs == null)) {
                            aml.Lwh.Lxs.jfz = a2;
                        }
                        AppMethodBeat.o(106979);
                        return;
                    }
                    break;
                case 10:
                    ana ana = gVar.field_favProto.LwU;
                    if (ana != null) {
                        this.tgf.a(imageView, null, ana.thumbUrl, i2, i3, i4);
                        AppMethodBeat.o(106979);
                        return;
                    }
                    break;
                case 11:
                    ana ana2 = gVar.field_favProto.LwU;
                    if (ana2 != null) {
                        this.tgf.a(imageView, null, ana2.thumbUrl, i2, i3, i4);
                        AppMethodBeat.o(106979);
                        return;
                    }
                    break;
                case 15:
                    ank ank = gVar.field_favProto.LwW;
                    if (ank != null) {
                        this.tgf.a(imageView, null, ank.thumbUrl, i2, i3, i4);
                        AppMethodBeat.o(106979);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(106979);
        }
    }

    public final void b(ImageView imageView, aml aml, g gVar, int i2, int i3, int i4) {
        boolean z;
        String str;
        String str2;
        AppMethodBeat.i(106980);
        if (imageView == null) {
            AppMethodBeat.o(106980);
        } else if (!e.apn()) {
            imageView.setImageResource(R.drawable.bjn);
            AppMethodBeat.o(106980);
        } else if (gVar == null || aml == null) {
            imageView.setImageDrawable(a.l(this.context, i2));
            AppMethodBeat.o(106980);
        } else {
            switch (aml.dataType) {
                case 4:
                case 15:
                    a(imageView, aml, gVar, aml.dFN, i2, i3, i4);
                    AppMethodBeat.o(106980);
                    return;
                case 5:
                    anq anq = null;
                    if (aml.Lwh != null) {
                        anq = aml.Lwh.LwS;
                        z = c(aml.Lwh.IXu);
                    } else {
                        Log.w("MicroMsg.FavoriteImageLogic", "webpage: get data proto item null, dataid[%s], infoid[%d, %d]", aml.dLl, Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id));
                        z = false;
                    }
                    if (anq == null) {
                        str = null;
                    } else {
                        str = anq.thumbUrl;
                    }
                    if (Util.isNullOrNil(str)) {
                        str2 = aml.dFN;
                    } else {
                        str2 = str;
                    }
                    if (z) {
                        str2 = com.tencent.mm.api.b.u(str2, 4);
                    }
                    a(imageView, aml, gVar, str2, i2, i3, i4);
                    AppMethodBeat.o(106980);
                    return;
                case 7:
                case 29:
                    a(imageView, aml, gVar, aml.dFN, i2, i3, i4);
                    AppMethodBeat.o(106980);
                    return;
                case 10:
                    if (aml.Lwh == null) {
                        Log.w("MicroMsg.FavoriteImageLogic", "good: get data proto item null, dataid[%s], infoid[%d, %d]", aml.dLl, Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id));
                        AppMethodBeat.o(106980);
                        return;
                    }
                    ana ana = aml.Lwh.LwU;
                    if (ana != null) {
                        this.tgf.a(imageView, null, ana.thumbUrl, i2, i3, i4);
                        AppMethodBeat.o(106980);
                        return;
                    }
                    break;
                case 11:
                    if (aml.Lwh == null) {
                        Log.w("MicroMsg.FavoriteImageLogic", "product: get data proto item null, dataid[%s], infoid[%d, %d]", aml.dLl, Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id));
                        AppMethodBeat.o(106980);
                        return;
                    }
                    ana ana2 = aml.Lwh.LwU;
                    if (ana2 != null) {
                        this.tgf.a(imageView, null, ana2.thumbUrl, i2, i3, i4);
                        AppMethodBeat.o(106980);
                        return;
                    }
                    break;
                case 14:
                    if (aml.Lwh == null) {
                        Log.w("MicroMsg.FavoriteImageLogic", "tv: get data proto item null, dataid[%s], infoid[%d, %d]", aml.dLl, Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id));
                        AppMethodBeat.o(106980);
                        return;
                    }
                    ank ank = aml.Lwh.LwW;
                    if (ank != null) {
                        this.tgf.a(imageView, null, ank.thumbUrl, i2, i3, i4);
                        AppMethodBeat.o(106980);
                        return;
                    }
                    break;
                case 19:
                    if (aml.Lwh == null) {
                        Log.w("MicroMsg.FavoriteImageLogic", "app brand: get data proto item null, dataid[%s], infoid[%d, %d]", aml.dLl, Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id));
                        AppMethodBeat.o(106980);
                        return;
                    }
                    amj amj = aml.Lwh.Lxf;
                    if (amj != null) {
                        this.tgf.a(imageView, null, amj.iconUrl, i2, i3, i4);
                        AppMethodBeat.o(106980);
                        return;
                    }
                    break;
                case 22:
                    if (aml.Lwh == null || aml.Lwh.Lxk == null || Util.isNullOrNil(aml.Lwh.Lxk.mediaList) || Util.isNullOrNil(aml.Lwh.Lxk.mediaList.getFirst().thumbUrl)) {
                        imageView.setImageDrawable(ar.m(imageView.getContext(), R.raw.icons_outlined_finder_icon, imageView.getContext().getResources().getColor(R.color.Orange)));
                        AppMethodBeat.o(106980);
                        return;
                    }
                    this.tgf.a(imageView, null, aml.Lwh.Lxk.mediaList.getFirst().thumbUrl, i2, i3, i4);
                    AppMethodBeat.o(106980);
                    return;
                default:
                    Log.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", Integer.valueOf(gVar.field_type));
                    AppMethodBeat.o(106980);
                    return;
            }
            AppMethodBeat.o(106980);
        }
    }

    private static Bitmap a(aml aml, boolean z, boolean z2) {
        String d2;
        AppMethodBeat.i(106981);
        if (z) {
            d2 = com.tencent.mm.plugin.fav.a.b.a(aml);
        } else {
            d2 = com.tencent.mm.plugin.fav.a.b.d(aml);
        }
        if (!s.YS(d2)) {
            Log.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
            AppMethodBeat.o(106981);
            return null;
        }
        Bitmap bd = e.bd(d2, z2);
        AppMethodBeat.o(106981);
        return bd;
    }

    public static Bitmap b(final aml aml, final g gVar, int i2) {
        Bitmap bitmap;
        int i3;
        int i4;
        AppMethodBeat.i(106982);
        if (!e.apn()) {
            Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjn);
            AppMethodBeat.o(106982);
            return decodeResource;
        } else if (aml.dLl == null) {
            AppMethodBeat.o(106982);
            return null;
        } else {
            String d2 = com.tencent.mm.plugin.fav.a.b.d(aml);
            if (!s.YS(d2)) {
                Log.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
                bitmap = null;
            } else {
                bitmap = tgj.get(d2);
                if (bitmap != null) {
                    Log.d("MicroMsg.FavoriteImageLogic", "get bm from cache %s", d2);
                } else {
                    Log.d("MicroMsg.FavoriteImageLogic", "get from cache fail, try to decode from file");
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    Bitmap decodeFile = MMBitmapFactory.decodeFile(d2, options);
                    if (decodeFile != null) {
                        Log.i("MicroMsg.FavoriteImageLogic", "bitmap recycle %s", decodeFile);
                        decodeFile.recycle();
                    }
                    int i5 = options.outWidth;
                    int i6 = options.outHeight;
                    Log.d("MicroMsg.FavoriteImageLogic", "width: %s, height: %s", Integer.valueOf(i5), Integer.valueOf(i6));
                    if (i5 > i2) {
                        i6 = (options.outHeight * i2) / options.outWidth;
                    } else {
                        i2 = i5;
                    }
                    int max = Math.max(1, i2);
                    int max2 = Math.max(1, i6);
                    Log.w("MicroMsg.FavoriteImageLogic", "fit long picture, beg %d*%d, after %d*%d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(max), Integer.valueOf(max2));
                    int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(d2);
                    if (exifOrientation == 90 || exifOrientation == 270) {
                        i4 = max;
                        i3 = max2;
                    } else {
                        i4 = max2;
                        i3 = max;
                    }
                    Bitmap extractThumbNail = BitmapUtil.extractThumbNail(d2, i4, i3, false);
                    if (extractThumbNail == null) {
                        Log.e("MicroMsg.FavoriteImageLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(d2)));
                        bitmap = null;
                    } else {
                        bitmap = BitmapUtil.rotate(extractThumbNail, (float) exifOrientation);
                        tgj.put(d2, bitmap);
                    }
                }
            }
            if (bitmap == null) {
                final String d3 = com.tencent.mm.plugin.fav.a.b.d(aml);
                com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.o.AnonymousClass3 */
                    final /* synthetic */ boolean tgm = false;

                    public final void run() {
                        AppMethodBeat.i(106964);
                        if (this.tgm || o.gi(d3)) {
                            com.tencent.mm.plugin.fav.a.b.a(gVar, aml, this.tgm);
                        }
                        AppMethodBeat.o(106964);
                    }

                    public final String toString() {
                        AppMethodBeat.i(106965);
                        String str = super.toString() + "|getBigImg";
                        AppMethodBeat.o(106965);
                        return str;
                    }
                });
            }
            AppMethodBeat.o(106982);
            return bitmap;
        }
    }

    public static Bitmap l(aml aml) {
        AppMethodBeat.i(106983);
        if (!e.apn()) {
            Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjn);
            AppMethodBeat.o(106983);
            return decodeResource;
        } else if (aml.dLl == null) {
            AppMethodBeat.o(106983);
            return null;
        } else {
            Bitmap a2 = a(aml, false, true);
            AppMethodBeat.o(106983);
            return a2;
        }
    }

    public static Bitmap a(final aml aml, final g gVar, final boolean z) {
        AppMethodBeat.i(106984);
        if (!e.apn()) {
            Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjn);
            AppMethodBeat.o(106984);
            return decodeResource;
        } else if (aml.dLl == null) {
            AppMethodBeat.o(106984);
            return null;
        } else {
            Bitmap a2 = a(aml, false, false);
            if (a2 == null) {
                final String d2 = com.tencent.mm.plugin.fav.a.b.d(aml);
                com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.o.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(106966);
                        if (z || o.gi(d2)) {
                            com.tencent.mm.plugin.fav.a.b.a(gVar, aml, z);
                        }
                        AppMethodBeat.o(106966);
                    }

                    public final String toString() {
                        AppMethodBeat.i(106967);
                        String str = super.toString() + "|getBigImg";
                        AppMethodBeat.o(106967);
                        return str;
                    }
                });
            }
            AppMethodBeat.o(106984);
            return a2;
        }
    }

    public static Bitmap a(final aml aml, final g gVar) {
        AppMethodBeat.i(106985);
        if (!e.apn()) {
            Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjn);
            AppMethodBeat.o(106985);
            return decodeResource;
        } else if (com.tencent.mm.plugin.fav.a.b.arI(aml.dLl) == null) {
            AppMethodBeat.o(106985);
            return null;
        } else {
            Bitmap a2 = a(aml, true, false);
            if (a2 == null) {
                final String a3 = com.tencent.mm.plugin.fav.a.b.a(aml);
                com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.o.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(106968);
                        if (o.gi(a3)) {
                            com.tencent.mm.plugin.fav.a.b.a(gVar, aml);
                        }
                        AppMethodBeat.o(106968);
                    }

                    public final String toString() {
                        AppMethodBeat.i(106969);
                        String str = super.toString() + "|getThumb";
                        AppMethodBeat.o(106969);
                        return str;
                    }
                });
            }
            AppMethodBeat.o(106985);
            return a2;
        }
    }

    public static Bitmap c(String str, int i2, int i3, boolean z) {
        int i4;
        int i5;
        AppMethodBeat.i(106986);
        boolean z2 = false;
        if (!s.YS(str)) {
            Log.w("MicroMsg.FavoriteImageLogic", "file not exist");
            AppMethodBeat.o(106986);
            return null;
        }
        Bitmap bitmap = tgk.get(str);
        if (bitmap != null || z) {
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bitmap != null);
            Log.d("MicroMsg.FavoriteImageLogic", "return bm path %s, bm %s", objArr);
            AppMethodBeat.o(106986);
            return bitmap;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapUtil.decodeFile(str, options);
            int i6 = options.outWidth;
            int i7 = options.outHeight;
            int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(str);
            if (exifOrientation == 90 || exifOrientation == 270) {
                z2 = true;
                i5 = i6;
                i4 = i7;
            } else {
                i5 = i7;
                i4 = i6;
            }
            options.inSampleSize = 1;
            while (i5 / options.inSampleSize > i3 && i4 / options.inSampleSize > i2) {
                options.inSampleSize++;
            }
            int i8 = (i4 * i3) / i2;
            Log.d("MicroMsg.FavoriteImageLogic", "decode top region width: %d, height: %d, scaleheight: %d, rotate: %b", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i8), Boolean.valueOf(z2));
            if (i8 <= 0 || i5 <= i8) {
                options.inJustDecodeBounds = false;
                bitmap = BitmapUtil.decodeFile(str, options);
            } else {
                Rect rect = new Rect();
                rect.top = 0;
                rect.left = 0;
                if (z2) {
                    rect.right = i8;
                    rect.bottom = i4;
                } else {
                    rect.right = i4;
                    rect.bottom = i8;
                }
                str = q.k(str, false);
                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(str, true);
                options.inJustDecodeBounds = false;
                bitmap = newInstance.decodeRegion(rect, options);
            }
            if (bitmap != null && z2) {
                bitmap = BitmapUtil.rotate(bitmap, (float) exifOrientation);
            }
            if (bitmap != null) {
                Log.d("MicroMsg.FavoriteImageLogic", "width %d, height %d, tw %d, th %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i2), Integer.valueOf(i3));
                tgk.put(str, bitmap);
            } else {
                Log.w("MicroMsg.FavoriteImageLogic", "decode bm fail!");
            }
        } catch (IOException e2) {
            Log.e("MicroMsg.FavoriteImageLogic", e2.getMessage());
        }
        AppMethodBeat.o(106986);
        return bitmap;
    }

    public static void a(final ImageView imageView, int i2, final aml aml, final g gVar, final boolean z, final int i3, final int i4) {
        AppMethodBeat.i(235322);
        if (!e.apn()) {
            imageView.setImageBitmap(BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjn));
        }
        if (aml.dLl == null) {
            imageView.setImageResource(i2);
        }
        Bitmap a2 = a(aml, gVar);
        final String d2 = com.tencent.mm.plugin.fav.a.b.d(aml);
        if (s.YS(d2)) {
            a2 = c(d2, i3, i4, true);
        }
        if (a2 == null) {
            imageView.setImageResource(i2);
            imageView.setTag(d2);
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.o.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(106971);
                    final Bitmap c2 = o.c(d2, i3, i4, false);
                    if (c2 == null) {
                        o.c(gVar, aml, z);
                        AppMethodBeat.o(106971);
                        return;
                    }
                    String str = (String) imageView.getTag();
                    if (str != null && str.equals(d2)) {
                        com.tencent.mm.kernel.g.aAk();
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.fav.ui.o.AnonymousClass6.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(106970);
                                imageView.setImageBitmap(c2);
                                AppMethodBeat.o(106970);
                            }
                        });
                    }
                    AppMethodBeat.o(106971);
                }
            });
            AppMethodBeat.o(235322);
            return;
        }
        imageView.setImageBitmap(a2);
        AppMethodBeat.o(235322);
    }

    private static void b(final g gVar, final aml aml, final boolean z) {
        AppMethodBeat.i(106988);
        final String d2 = com.tencent.mm.plugin.fav.a.b.d(aml);
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.o.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(106972);
                if (z || o.gi(d2)) {
                    com.tencent.mm.plugin.fav.a.b.a(gVar, aml, z);
                }
                AppMethodBeat.o(106972);
            }

            public final String toString() {
                AppMethodBeat.i(106973);
                String str = super.toString() + "|reDownload";
                AppMethodBeat.o(106973);
                return str;
            }
        });
        AppMethodBeat.o(106988);
    }

    public static void b(g gVar, aml aml) {
        AppMethodBeat.i(106989);
        b(gVar, aml, true);
        AppMethodBeat.o(106989);
    }

    public final String a(ImageView imageView, final aml aml, final g gVar, String str, int i2, int i3, int i4) {
        AppMethodBeat.i(235321);
        String arI = com.tencent.mm.plugin.fav.a.b.arI(aml.dLl);
        String[] strArr = null;
        if (aml.dLl != null) {
            String[] strArr2 = this.tgh.get(arI);
            if (strArr2 == null) {
                strArr = new String[]{com.tencent.mm.plugin.fav.a.b.a(aml)};
                this.tgh.put(arI, strArr);
            } else {
                strArr = strArr2;
            }
        }
        this.tgf.a(imageView, strArr, str, i2, i3, i4);
        if (strArr == null || strArr.length <= 0) {
            AppMethodBeat.o(235321);
            return null;
        }
        final String str2 = strArr[0];
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.o.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(106960);
                if (o.gi(str2)) {
                    com.tencent.mm.plugin.fav.a.b.a(gVar, aml);
                }
                AppMethodBeat.o(106960);
            }

            public final String toString() {
                AppMethodBeat.i(106961);
                String str = super.toString() + "|mAttachThumb";
                AppMethodBeat.o(106961);
                return str;
            }
        });
        String str3 = strArr[0];
        AppMethodBeat.o(235321);
        return str3;
    }

    static /* synthetic */ boolean gi(String str) {
        AppMethodBeat.i(106990);
        if (!new com.tencent.mm.vfs.o(str).exists()) {
            f.a aVar = tgi.get(str);
            if (aVar == null) {
                tgi.put(str, new f.a());
                AppMethodBeat.o(106990);
                return true;
            } else if (aVar.apr() > 30000) {
                Log.v("MicroMsg.FavoriteImageLogic", "error diff time");
                aVar.gLm = SystemClock.elapsedRealtime();
                AppMethodBeat.o(106990);
                return true;
            }
        }
        AppMethodBeat.o(106990);
        return false;
    }
}
