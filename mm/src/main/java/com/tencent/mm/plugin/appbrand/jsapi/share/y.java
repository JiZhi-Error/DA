package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.luggage.game.page.d;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.a.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class y {
    static void a(ac acVar, String str, Bitmap bitmap) {
        AppMethodBeat.i(226990);
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    final long currentTimeMillis = System.currentTimeMillis();
                    BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.JPEG, str, true);
                    Log.i("MicroMsg.ShareHelper", "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)", acVar.getAppId(), Integer.valueOf(acVar.hashCode()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    final Bundle bundle = new Bundle();
                    bundle.putString("delay_load_img_path", "file://".concat(String.valueOf(str)));
                    new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.share.y.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(226988);
                            Log.i("MicroMsg.ShareHelper", "notifyToRefreshImg(cost : %s)", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 2);
                            h.a(MainProcessIPCService.dkO, bundle, a.class, null);
                            AppMethodBeat.o(226988);
                        }
                    }.run();
                }
            } catch (Exception e2) {
                Log.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", e2);
                if (bitmap != null && !bitmap.isRecycled()) {
                    Log.i("MicroMsg.ShareHelper", "bitmap recycle %s", bitmap);
                    bitmap.recycle();
                    AppMethodBeat.o(226990);
                    return;
                }
            } catch (Throwable th) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    Log.i("MicroMsg.ShareHelper", "bitmap recycle %s", bitmap);
                    bitmap.recycle();
                }
                AppMethodBeat.o(226990);
                throw th;
            }
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            Log.i("MicroMsg.ShareHelper", "bitmap recycle %s", bitmap);
            bitmap.recycle();
            AppMethodBeat.o(226990);
            return;
        }
        AppMethodBeat.o(226990);
    }

    public static String a(final c cVar, String str, boolean z) {
        String str2 = null;
        AppMethodBeat.i(46812);
        if (cVar == null) {
            AppMethodBeat.o(46812);
            return null;
        }
        String appId = cVar.getAppId();
        if (Util.isNullOrNil(str)) {
            if (!z) {
                AppMethodBeat.o(46812);
                return null;
            }
            cVar.NV();
            if (cVar.getFileSystem() == null) {
                Log.e("MicroMsg.ShareHelper", "tryToGetLocalFilePath NULL fs with appId(%s)", cVar.getAppId());
                AppMethodBeat.o(46812);
                return null;
            }
            o Wa = cVar.getFileSystem().Wa("share_" + System.nanoTime());
            if (Wa == null) {
                AppMethodBeat.o(46812);
                return null;
            }
            final String z2 = aa.z(Wa.her());
            if (cVar.S(d.class) != null) {
                a(cVar, z2, cVar.bRB());
                AppMethodBeat.o(46812);
                return z2;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 1);
            h.a(MainProcessIPCService.dkO, bundle, a.class, null);
            cVar.NT().a(com.tencent.mm.vending.h.d.HEAVY_WORK, new d.b<Bitmap>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.share.y.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.g.d.b
                public final /* synthetic */ void bz(Bitmap bitmap) {
                    AppMethodBeat.i(226989);
                    y.a(cVar, z2, bitmap);
                    AppMethodBeat.o(226989);
                }
            });
            String concat = "delayLoadFile://".concat(String.valueOf(z2));
            AppMethodBeat.o(46812);
            return concat;
        } else if (str.startsWith("wxfile://")) {
            o VY = cVar.getFileSystem().VY(str);
            if (VY != null && VY.exists()) {
                str2 = "file://" + aa.z(VY.her());
            }
            AppMethodBeat.o(46812);
            return str2;
        } else if (str.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || str.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
            AppMethodBeat.o(46812);
            return null;
        } else {
            String genMediaFilePath = AppBrandLocalMediaObjectManager.genMediaFilePath(appId, "share_" + System.nanoTime());
            Bitmap k = z.k(cVar.NP(), str);
            if (k == null || k.isRecycled()) {
                AppMethodBeat.o(46812);
                return null;
            }
            try {
                BitmapUtil.saveBitmapToImage(k, 100, Bitmap.CompressFormat.PNG, genMediaFilePath, true);
                if (k != null && !k.isRecycled()) {
                    Log.i("MicroMsg.ShareHelper", "bitmap recycle %s", k);
                    k.recycle();
                }
            } catch (IOException e2) {
                Log.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", e2);
                if (k != null && !k.isRecycled()) {
                    Log.i("MicroMsg.ShareHelper", "bitmap recycle %s", k);
                    k.recycle();
                }
            } catch (Throwable th) {
                if (k != null && !k.isRecycled()) {
                    Log.i("MicroMsg.ShareHelper", "bitmap recycle %s", k);
                    k.recycle();
                }
                AppMethodBeat.o(46812);
                throw th;
            }
            String concat2 = "file://".concat(String.valueOf(genMediaFilePath));
            AppMethodBeat.o(46812);
            return concat2;
        }
    }

    public static boolean aaK(String str) {
        AppMethodBeat.i(46813);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(46813);
            return true;
        }
        AppMethodBeat.o(46813);
        return false;
    }

    public static String aaL(String str) {
        AppMethodBeat.i(46814);
        if (str == null) {
            AppMethodBeat.o(46814);
            return null;
        } else if (str.startsWith("file://")) {
            String replace = str.replace("file://", "");
            AppMethodBeat.o(46814);
            return replace;
        } else if (str.startsWith("delayLoadFile://")) {
            String replace2 = str.replace("delayLoadFile://", "");
            AppMethodBeat.o(46814);
            return replace2;
        } else {
            AppMethodBeat.o(46814);
            return str;
        }
    }

    public static StringBuilder bN(String str, int i2) {
        AppMethodBeat.i(180275);
        int Wp = ((a) g.af(a.class)).Wp(str);
        StringBuilder sb = new StringBuilder("1_");
        sb.append(str);
        sb.append("_");
        sb.append(MD5Util.getMD5String(p.getString(Wp)));
        sb.append("_");
        sb.append(Util.nowSecond());
        sb.append("_");
        sb.append(i2);
        AppMethodBeat.o(180275);
        return sb;
    }

    public static void a(String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9, String str10, int i4, String str11, int i5, int i6, String str12) {
        String str13;
        String str14;
        int i7;
        int i8;
        AppMethodBeat.i(226991);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ShareHelper", "appId is Null!");
            AppMethodBeat.o(226991);
            return;
        }
        String str15 = "";
        try {
            str15 = q.encode(Util.nullAsNil(str6), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            Log.e("MicroMsg.ShareHelper", "encode share page path error!");
        }
        String str16 = "";
        try {
            str16 = q.encode(Util.nullAsNil(str7), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e3) {
            Log.e("MicroMsg.ShareHelper", "encode current page path error!");
        }
        try {
            str13 = q.encode(Util.nullAsNil(str10), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e4) {
            Log.e("MicroMsg.ShareHelper", "encode current html url error!");
            str13 = "";
        }
        try {
            str14 = q.encode(Util.nullAsNil(str11), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e5) {
            Log.e("MicroMsg.ShareHelper", "encode thumb Icon url error!");
            str14 = "";
        }
        try {
            str5 = q.encode(Util.nullAsNil(str5), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e6) {
            Log.e("MicroMsg.ShareHelper", "encode shareTitle error!");
        }
        int i9 = i4 + 1000;
        String str17 = "";
        try {
            str17 = q.encode(Util.nullAsNil(str12), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            if (str17.length() >= 1024) {
                str17 = str17.substring(0, 1024);
            }
        } catch (UnsupportedEncodingException e7) {
            Log.e("MicroMsg.ShareHelper", "encode messageExtraData error!");
        }
        z aaM = aa.aaM(str9);
        if (aaM == null) {
            i7 = 0;
        } else {
            i7 = aaM.msM;
        }
        if (aaM == null) {
            i8 = 0;
        } else {
            i8 = aaM.msQ;
        }
        Log.d("MicroMsg.ShareHelper", "stev report(%s), appId %s, scene %s, sceneNote %s, sessionId %s, currentPath %s, currentTitle %s,shareTitle %s, sharePath %s, shareActionId %s, destinationUserCount %s, toUsername %s, htmlUrl %s, appServiceType %s, thumbIconUrl %s, appVersion %d , destinationType %d, messageExtraData %s,shareActionType:%d, shareSourceType:%d", 14077, str, Integer.valueOf(i2), str2, str3, str7, str8, str5, str6, str9, Integer.valueOf(i3), str4, str13, Integer.valueOf(i9), str14, Integer.valueOf(i5), Integer.valueOf(i6), str12, Integer.valueOf(i7), Integer.valueOf(i8));
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14077, str, Integer.valueOf(i2), str2, str3, str16, str8, str5, str15, str9, "", Integer.valueOf(i3), str4, str13, Integer.valueOf(i9), str14, Integer.valueOf(i5), Integer.valueOf(i6), str17, Integer.valueOf(i7), Integer.valueOf(i8));
        AppMethodBeat.o(226991);
    }
}
