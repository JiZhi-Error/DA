package com.tencent.mm.pluginsdk.model.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.LinkedHashMap;

public final class q {
    public static String e(Context context, String str, String str2) {
        AppMethodBeat.i(151761);
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            Log.e("MicroMsg.AppUtil", "buildSourceUrl fail, invalid arguments");
            AppMethodBeat.o(151761);
            return null;
        }
        String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), context);
        if (loadApplicationLanguage == null || loadApplicationLanguage.length() == 0) {
            loadApplicationLanguage = LocaleUtil.CHINA;
        } else if (loadApplicationLanguage.equals(LocaleUtil.ENGLISH)) {
            loadApplicationLanguage = "en_US";
        }
        String string = context.getString(R.string.fj0, str, Integer.valueOf(d.KyO), loadApplicationLanguage, d.ics, str2);
        AppMethodBeat.o(151761);
        return string;
    }

    public static String R(Context context, String str, String str2) {
        AppMethodBeat.i(151762);
        if (str == null || str.length() == 0 || str2.length() == 0) {
            Log.e("MicroMsg.AppUtil", "buildUnistallUrl fail, invalid arguments");
            AppMethodBeat.o(151762);
            return null;
        }
        String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), context);
        if (loadApplicationLanguage == null || loadApplicationLanguage.length() == 0) {
            loadApplicationLanguage = LocaleUtil.CHINA;
        } else if (loadApplicationLanguage.equals(LocaleUtil.ENGLISH)) {
            loadApplicationLanguage = "en_US";
        }
        String string = context.getString(R.string.fj1, str, Integer.valueOf(d.KyO), loadApplicationLanguage, d.ics, str2, 0);
        AppMethodBeat.o(151762);
        return string;
    }

    private static boolean isMpUrl(String str) {
        AppMethodBeat.i(223765);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(223765);
            return false;
        } else if (str.startsWith(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + FilePathGenerator.ANDROID_DIR_SEP) || str.startsWith(HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e20) + FilePathGenerator.ANDROID_DIR_SEP)) {
            AppMethodBeat.o(223765);
            return true;
        } else {
            AppMethodBeat.o(223765);
            return false;
        }
    }

    public static String R(String str, String str2) {
        String str3;
        String[] split;
        String str4;
        String str5;
        AppMethodBeat.i(151763);
        boolean z = ((b) g.af(b.class)).a(b.a.clicfg_webview_append_url_params, 0) == 1;
        boolean isMpUrl = isMpUrl(str);
        if (!z && !isMpUrl) {
            Log.i("MicroMsg.AppUtil", "buildRedirectUrl appendParams false");
            AppMethodBeat.o(151763);
            return str;
        } else if (str == null || str.length() == 0) {
            Log.e("MicroMsg.AppUtil", "buildRedirectUrl fail, invalid arguments");
            AppMethodBeat.o(151763);
            return null;
        } else {
            String trim = str.trim();
            int indexOf = trim.indexOf("#");
            if (indexOf >= 0) {
                String substring = trim.substring(indexOf);
                trim = trim.substring(0, indexOf);
                str3 = substring;
            } else {
                str3 = "";
            }
            int indexOf2 = trim.indexOf("?");
            String str6 = "";
            if (indexOf2 >= 0) {
                str6 = trim.substring(indexOf2 + 1);
                trim = trim.substring(0, indexOf2);
            }
            Log.v("MicroMsg.AppUtil", "buildRedirectUrl, sharpStr = %s, paramStr = %s, srcUrl = %s", str3, str6, trim);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (!Util.isNullOrNil(str6) && (split = str6.split("&")) != null && split.length > 0) {
                for (String str7 : split) {
                    if (!Util.isNullOrNil(str7)) {
                        int indexOf3 = str7.indexOf("=");
                        Log.v("MicroMsg.AppUtil", "buildRedirectUrl, equalIdx = %d", Integer.valueOf(indexOf3));
                        if (indexOf3 >= 0) {
                            str5 = str7.substring(0, indexOf3 + 1);
                            str4 = str7.substring(indexOf3 + 1);
                        } else {
                            str4 = "";
                            str5 = str7;
                        }
                        linkedHashMap.put(str5, str4);
                    }
                }
            }
            if (str2 == null) {
                str2 = "";
            }
            linkedHashMap.put("from=", str2);
            Log.v("MicroMsg.AppUtil", "buildRedirectUrl, pMap size = %d", Integer.valueOf(linkedHashMap.size()));
            StringBuilder sb = new StringBuilder();
            for (String str8 : linkedHashMap.keySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(str8);
                sb.append((String) linkedHashMap.get(str8));
            }
            String str9 = trim + "?" + sb.toString();
            if (!Util.isNullOrNil(str3)) {
                str9 = str9 + str3;
            }
            Log.v("MicroMsg.AppUtil", "buildRedirectUrl, ret url = %s", str9);
            AppMethodBeat.o(151763);
            return str9;
        }
    }

    public static String ch(Context context, String str) {
        AppMethodBeat.i(151765);
        Signature[] cj = cj(context, str);
        if (cj == null || cj.length == 0) {
            Log.e("MicroMsg.AppUtil", "signs is null");
            AppMethodBeat.o(151765);
            return null;
        }
        String bdM = r.bdM(com.tencent.mm.b.g.getMessageDigest(cj[0].toByteArray()));
        AppMethodBeat.o(151765);
        return bdM;
    }

    public static String ci(Context context, String str) {
        AppMethodBeat.i(151766);
        Signature[] cj = cj(context, str);
        if (cj == null || cj.length == 0) {
            Log.e("MicroMsg.AppUtil", "signs is null");
            AppMethodBeat.o(151766);
            return null;
        }
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(cj[0].toByteArray());
        AppMethodBeat.o(151766);
        return messageDigest;
    }

    public static boolean a(final Context context, g gVar, String str, boolean z) {
        AppMethodBeat.i(151767);
        a eAZ = a.C1616a.eAZ();
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.AppUtil", "isAppValid, packageName is null");
            eAZ.e(gVar);
            AppMethodBeat.o(151767);
            return false;
        } else if (gVar == null) {
            Log.i("MicroMsg.AppUtil", "app does not exist");
            AppMethodBeat.o(151767);
            return true;
        } else if (gVar.field_packageName == null || gVar.field_packageName.length() == 0) {
            Log.e("MicroMsg.AppUtil", "isAppValid fail, local packageName is null");
            eAZ.e(gVar);
            AppMethodBeat.o(151767);
            return false;
        } else if (gVar.field_signature == null || gVar.field_signature.length() == 0) {
            Log.e("MicroMsg.AppUtil", "isAppValid fail, local signature is null");
            eAZ.e(gVar);
            AppMethodBeat.o(151767);
            return false;
        } else {
            Signature[] cj = cj(context, str);
            if (cj == null || cj.length == 0) {
                Log.e("MicroMsg.AppUtil", "isAppValid, apk signatures is null");
                eAZ.e(gVar);
                AppMethodBeat.o(151767);
                return false;
            } else if (!Util.isEqual(gVar.field_packageName, str)) {
                Log.e("MicroMsg.AppUtil", "isAppValid, packageName is diff, src:%s,local:%s", gVar.field_packageName, str);
                eAZ.e(gVar);
                if (z) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.pluginsdk.model.app.q.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(151760);
                            Toast.makeText(context, context.getString(R.string.fiw), 1).show();
                            AppMethodBeat.o(151760);
                        }
                    });
                }
                AppMethodBeat.o(151767);
                return false;
            } else {
                Log.i("MicroMsg.AppUtil", "server signatures:%s", gVar.field_signature);
                for (Signature signature : cj) {
                    String bdM = r.bdM(com.tencent.mm.b.g.getMessageDigest(signature.toByteArray()));
                    Log.i("MicroMsg.AppUtil", "local signatures:%s", bdM);
                    if (gVar.field_signature != null && gVar.field_signature.equals(bdM)) {
                        eAZ.f(gVar);
                        AppMethodBeat.o(151767);
                        return true;
                    }
                }
                if (z) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.pluginsdk.model.app.q.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(162008);
                            Toast.makeText(context, context.getString(R.string.fix), 1).show();
                            AppMethodBeat.o(162008);
                        }
                    });
                }
                Log.w("MicroMsg.AppUtil", "isAppValid, signature is diff");
                eAZ.e(gVar);
                AppMethodBeat.o(151767);
                return false;
            }
        }
    }

    public static void bo(Bundle bundle) {
        AppMethodBeat.i(151768);
        if (bundle != null) {
            bundle.putString(ConstantsAPI.Token.WX_TOKEN_KEY, ConstantsAPI.Token.WX_TOKEN_VALUE_MSG);
        }
        AppMethodBeat.o(151768);
    }

    public static void bp(Bundle bundle) {
        AppMethodBeat.i(151769);
        if (bundle != null) {
            bundle.putString(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "wechat");
        }
        AppMethodBeat.o(151769);
    }

    public static void k(Bundle bundle, String str) {
        AppMethodBeat.i(151770);
        bundle.putString(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "wechat");
        if (!Util.isNullOrNil(str)) {
            bundle.putString(ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, str);
        }
        AppMethodBeat.o(151770);
    }

    public static Signature[] cj(Context context, String str) {
        AppMethodBeat.i(151771);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.AppUtil", "getSignature, packageName is null");
            AppMethodBeat.o(151771);
            return null;
        } else if (context == null) {
            Log.e("MicroMsg.AppUtil", "getSignature, context is null");
            AppMethodBeat.o(151771);
            return null;
        } else {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                if (packageInfo == null) {
                    Log.e("MicroMsg.AppUtil", "info is null, packageName = ".concat(String.valueOf(str)));
                    AppMethodBeat.o(151771);
                    return null;
                }
                Signature[] signatureArr = packageInfo.signatures;
                AppMethodBeat.o(151771);
                return signatureArr;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e("MicroMsg.AppUtil", "NameNotFoundException");
                AppMethodBeat.o(151771);
                return null;
            }
        }
    }

    public static boolean b(Context context, g gVar) {
        AppMethodBeat.i(151772);
        Log.i("MicroMsg.AppUtil", "check the signature of the Application.");
        if (context == null) {
            Log.e("MicroMsg.AppUtil", "context is null.");
            AppMethodBeat.o(151772);
            return true;
        } else if (gVar == null) {
            Log.e("MicroMsg.AppUtil", "appInfo is null.");
            AppMethodBeat.o(151772);
            return true;
        } else if (Util.isNullOrNil(gVar.field_packageName)) {
            Log.e("MicroMsg.AppUtil", "packageName is null.");
            AppMethodBeat.o(151772);
            return true;
        } else if (Util.isNullOrNil(gVar.field_signature)) {
            Log.e("MicroMsg.AppUtil", "app.field_signature is null. app.field_packageName is %s", gVar.field_packageName);
            AppMethodBeat.o(151772);
            return true;
        } else {
            Signature[] cj = cj(context, gVar.field_packageName);
            if (cj == null || cj.length == 0) {
                Log.e("MicroMsg.AppUtil", "apk signatures is null");
                AppMethodBeat.o(151772);
                return false;
            }
            for (Signature signature : cj) {
                if (gVar.field_signature.equals(r.bdM(com.tencent.mm.b.g.getMessageDigest(signature.toByteArray())))) {
                    Log.i("MicroMsg.AppUtil", "app_name : %s ,signature : %s", gVar.field_appName, gVar.field_signature);
                    AppMethodBeat.o(151772);
                    return true;
                }
            }
            Log.w("MicroMsg.AppUtil", "signature is diff.(app_name:%s)", gVar.field_appName);
            AppMethodBeat.o(151772);
            return false;
        }
    }

    public static void bdL(String str) {
        AppMethodBeat.i(151773);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.AppUtil", "appid is null");
            AppMethodBeat.o(151773);
            return;
        }
        SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
        if (defaultPreference != null) {
            String string = defaultPreference.getString("key_app_ids_registion_while_not_login", "");
            if (string.contains(str)) {
                Log.i("MicroMsg.AppUtil", "this app has been saved : %s in %s", str, string);
                AppMethodBeat.o(151773);
                return;
            }
            defaultPreference.edit().putString("key_app_ids_registion_while_not_login", str + "|" + string).commit();
        }
        AppMethodBeat.o(151773);
    }

    public static void gmZ() {
        aq.JXv = null;
        aq.JXw = -1;
    }

    public static void gna() {
        AppMethodBeat.i(151774);
        SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
        if (defaultPreference != null) {
            defaultPreference.edit().putString("key_app_ids_registion_while_not_login", "").commit();
        }
        AppMethodBeat.o(151774);
    }

    public static void n(final Activity activity, final String str) {
        AppMethodBeat.i(151775);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.pluginsdk.model.app.q.AnonymousClass3 */

            /* JADX WARNING: Removed duplicated region for block: B:27:0x009c  */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x00dd  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 246
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.model.app.q.AnonymousClass3.run():void");
            }
        }, "reportLaunchWechat");
        AppMethodBeat.o(151775);
    }

    public static String aV(Activity activity) {
        Uri referrer;
        AppMethodBeat.i(151776);
        String str = "";
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            str = callingActivity.getPackageName();
            Log.i("MicroMsg.AppUtil", "get calling activity, %s", str);
        }
        String str2 = str;
        if (Util.isNullOrNil(str2) && Build.VERSION.SDK_INT >= 22) {
            try {
                Object obj = new c(activity, "mReferrer", null).get();
                if (obj != null) {
                    str2 = (String) obj;
                }
                Log.i("MicroMsg.AppUtil", "get referrer, %s", str2);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppUtil", e2, "get mReferrer error", new Object[0]);
            }
        }
        if (Util.isNullOrNil(str2) && Build.VERSION.SDK_INT >= 22 && (referrer = activity.getReferrer()) != null) {
            str2 = referrer.getAuthority();
            Log.i("MicroMsg.AppUtil", "get referrer, %s", str2);
        }
        AppMethodBeat.o(151776);
        return str2;
    }

    public static boolean s(Context context, String str) {
        AppMethodBeat.i(151764);
        if (com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo(context, str) != null) {
            AppMethodBeat.o(151764);
            return true;
        }
        AppMethodBeat.o(151764);
        return false;
    }
}
