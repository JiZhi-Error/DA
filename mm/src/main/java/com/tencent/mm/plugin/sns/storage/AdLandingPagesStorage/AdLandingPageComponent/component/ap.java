package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.d;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.net.URI;
import java.util.List;

public final class ap {
    private static Typeface Ehi = null;

    public static Bitmap getBitmap(String str) {
        AppMethodBeat.i(96819);
        String str2 = (b.aKJ() + "/sns_ad_landingpages") + FilePathGenerator.ANDROID_DIR_SEP + ("adId" + "_image_" + MD5Util.getMD5String(str));
        if (s.YS(str2)) {
            Bitmap decodeFile = BackwardSupportUtil.BitmapFactory.decodeFile(str2, 1.0f);
            AppMethodBeat.o(96819);
            return decodeFile;
        }
        AppMethodBeat.o(96819);
        return null;
    }

    public static int bU(float f2) {
        int i2 = (int) f2;
        if (((double) (f2 - ((float) i2))) > 0.001d) {
            return i2 + 1;
        }
        return i2;
    }

    public static int[] ha(Context context) {
        int width;
        int height;
        AppMethodBeat.i(96820);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 13) {
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            width = point.x;
            height = point.y;
        } else {
            width = defaultDisplay.getWidth();
            height = defaultDisplay.getHeight();
        }
        int[] iArr = {width, height};
        AppMethodBeat.o(96820);
        return iArr;
    }

    public static void aK(Activity activity) {
        AppMethodBeat.i(96821);
        boolean aQ = ao.aQ(activity);
        Log.i("LandingPageUtil", "setFullScreen, hasCut=".concat(String.valueOf(aQ)));
        int i2 = 514;
        if (!aQ) {
            i2 = 1542;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            i2 |= 4096;
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(i2);
        AppMethodBeat.o(96821);
    }

    public static void aL(Activity activity) {
        AppMethodBeat.i(203115);
        Log.i("LandingPageUtil", "setFullScreen");
        int i2 = 1542;
        if (Build.VERSION.SDK_INT >= 19) {
            i2 = 5638;
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(i2);
        AppMethodBeat.o(203115);
    }

    public static void h(String str, Context context) {
        AppMethodBeat.i(96822);
        d.W(context).b(new Intent(str));
        AppMethodBeat.o(96822);
    }

    public static void hb(Context context) {
        AppMethodBeat.i(96823);
        h("com.tencent.mm.adlanding.set_uioption", context);
        AppMethodBeat.o(96823);
    }

    public static String n(String str, String... strArr) {
        AppMethodBeat.i(96824);
        try {
            URI uri = new URI(str);
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2).append("&");
            }
            if (sb.length() > 1) {
                StringBuilder deleteCharAt = sb.deleteCharAt(sb.length() - 1);
                String query = uri.getQuery();
                str = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), query == null ? deleteCharAt.toString() : query + "&" + deleteCharAt.toString(), uri.getFragment()).toString();
                AppMethodBeat.o(96824);
                return str;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("LandingPageUtil", e2, "", new Object[0]);
        }
        AppMethodBeat.o(96824);
        return str;
    }

    public static Typeface hc(Context context) {
        AppMethodBeat.i(96825);
        if (Ehi == null) {
            Ehi = Typeface.createFromAsset(context.getAssets(), "fonts/WeChatNum.ttf");
        }
        Typeface typeface = Ehi;
        AppMethodBeat.o(96825);
        return typeface;
    }

    public static boolean aQb(String str) {
        AppMethodBeat.i(96826);
        if (str == null || str.length() < 102400) {
            AppMethodBeat.o(96826);
            return false;
        }
        AppMethodBeat.o(96826);
        return true;
    }

    public static String aQc(String str) {
        AppMethodBeat.i(96827);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(96827);
            return "";
        }
        o oVar = new o(b.aKC().replace("/data/user/0", "/data/data"), "tmpLargeCanvasDir");
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        try {
            byte[] bytes = str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            String z = aa.z(new o(oVar, new StringBuilder().append(System.currentTimeMillis()).toString()).her());
            if (s.f(z, bytes, bytes.length) == 0) {
                AppMethodBeat.o(96827);
                return z;
            }
        } catch (Exception e2) {
            Log.e("LandingPageUtil", "writeTempCanvasXmlToLocal fail");
        }
        AppMethodBeat.o(96827);
        return "";
    }

    public static String aQd(String str) {
        AppMethodBeat.i(96828);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(96828);
            return "";
        }
        try {
            o oVar = new o(str);
            if (!oVar.exists()) {
                AppMethodBeat.o(96828);
                return "";
            }
            String boY = s.boY(str);
            oVar.delete();
            AppMethodBeat.o(96828);
            return boY;
        } catch (Exception e2) {
            Log.e("LandingPageUtil", "readTempCanvasXmlFromLocalAndDeleteIt fail");
            AppMethodBeat.o(96828);
            return "";
        }
    }

    public static List<ResolveInfo> queryIntentActivities(Context context, Intent intent) {
        AppMethodBeat.i(203116);
        try {
            List<ResolveInfo> queryIntentActivities = Util.queryIntentActivities(context, intent);
            AppMethodBeat.o(203116);
            return queryIntentActivities;
        } catch (Throwable th) {
            Log.e("LandingPageUtil", "queryIntentActivities fail");
            AppMethodBeat.o(203116);
            return null;
        }
    }

    public static boolean a(final Context context, final String str, String str2, final Intent intent, final String str3, final al alVar, final int i2) {
        String str4;
        AppMethodBeat.i(203117);
        if (context == null || (TextUtils.isEmpty(str) && intent == null)) {
            AppMethodBeat.o(203117);
            return false;
        }
        if (intent != null) {
            a.post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(203110);
                    List<ResolveInfo> queryIntentActivities = ap.queryIntentActivities(context, intent);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        h.a(context, intent, str3, i2, new al() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.pluginsdk.model.app.al
                            public final void v(boolean z, boolean z2) {
                                AppMethodBeat.i(203109);
                                if (!z) {
                                    ap.hb(context);
                                }
                                if (alVar != null) {
                                    alVar.v(z, z2);
                                }
                                AppMethodBeat.o(203109);
                            }
                        }, (Bundle) null);
                    }
                    AppMethodBeat.o(203110);
                }
            });
        } else if (!TextUtils.isEmpty(str2)) {
            final Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str2));
            intent2.addFlags(268435456);
            List<ResolveInfo> queryIntentActivities = queryIntentActivities(context, intent2);
            if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                if (!TextUtils.isEmpty(intent2.getPackage()) || queryIntentActivities.size() != 1) {
                    str4 = intent2.getPackage();
                } else {
                    str4 = h.b(queryIntentActivities.get(0));
                }
                if (!Util.nullAsNil(MMApplicationContext.getPackageName()).equals(str4)) {
                    a.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(203112);
                            h.a(context, intent2, str3, i2, new al() {
                                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap.AnonymousClass2.AnonymousClass1 */

                                @Override // com.tencent.mm.pluginsdk.model.app.al
                                public final void v(boolean z, boolean z2) {
                                    AppMethodBeat.i(203111);
                                    if (!z) {
                                        ap.hb(context);
                                    }
                                    if (alVar != null) {
                                        alVar.v(z, z2);
                                    }
                                    AppMethodBeat.o(203111);
                                }
                            }, (Bundle) null);
                            AppMethodBeat.o(203112);
                        }
                    });
                }
            }
        } else {
            a.post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(203114);
                    h.a(context, context.getPackageManager().getLaunchIntentForPackage(str), str3, i2, new al() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap.AnonymousClass3.AnonymousClass1 */

                        @Override // com.tencent.mm.pluginsdk.model.app.al
                        public final void v(boolean z, boolean z2) {
                            AppMethodBeat.i(203113);
                            if (!z) {
                                ap.hb(context);
                            }
                            if (alVar != null) {
                                alVar.v(z, z2);
                            }
                            AppMethodBeat.o(203113);
                        }
                    }, (Bundle) null);
                    AppMethodBeat.o(203114);
                }
            });
        }
        AppMethodBeat.o(203117);
        return true;
    }
}
