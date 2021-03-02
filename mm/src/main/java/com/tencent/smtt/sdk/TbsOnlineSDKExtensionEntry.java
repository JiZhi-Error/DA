package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ValueCallback;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.b.c;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.m;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Map;

public class TbsOnlineSDKExtensionEntry implements c {
    public static final int EXTENSION_INIT_FAILURE = -99999;
    public static final String TAG = "TbsOnlineSDKExtensionEntry";

    /* renamed from: a  reason: collision with root package name */
    static String f1848a;

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f1849b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Object f1850c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String[] f1851d;

    /* renamed from: e  reason: collision with root package name */
    private static int f1852e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static String f1853f = "";

    @Override // com.tencent.smtt.sdk.b.c
    public boolean canLoadVideo(Context context) {
        AppMethodBeat.i(54992);
        Object a2 = k.a(f1850c, "canLoadVideo", new Class[]{Integer.TYPE}, 0);
        TbsLog.d(TAG, "QbSdk canLoadVideo ret=" + ((Boolean) a2));
        if (a2 == null) {
            TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 314);
        } else if (!((Boolean) a2).booleanValue()) {
            TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 313);
        }
        if (a2 == null) {
            AppMethodBeat.o(54992);
            return false;
        }
        boolean booleanValue = ((Boolean) a2).booleanValue();
        AppMethodBeat.o(54992);
        return booleanValue;
    }

    @Override // com.tencent.smtt.sdk.b.c
    public boolean canLoadX5(Context context, boolean z, boolean z2) {
        int i2;
        boolean z3;
        boolean z4 = true;
        boolean z5 = false;
        AppMethodBeat.i(54993);
        int disabledCoreVersion = TbsPVConfig.getInstance(context).getDisabledCoreVersion();
        if (disabledCoreVersion != 0 && disabledCoreVersion == q.a().j(context)) {
            TbsLog.e(TAG, "force use sys by remote switch");
            AppMethodBeat.o(54993);
        } else if (!QbSdk.a(context, z)) {
            TbsLog.e(TAG, "QbSdk.init failure!");
            AppMethodBeat.o(54993);
        } else {
            Object a2 = k.a(f1850c, "canLoadX5Core", new Class[]{Integer.TYPE}, Integer.valueOf((int) TbsConfig.TBS_SDK_VERSIONCODE));
            if (a2 == null) {
                Object a3 = k.a(f1850c, "canLoadX5", new Class[]{Integer.TYPE}, Integer.valueOf(a.a()));
                if (a3 == null) {
                    TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_NULL);
                } else if ((a3 instanceof String) && ((String) a3).equalsIgnoreCase("AuthenticationFail")) {
                    AppMethodBeat.o(54993);
                } else if (a3 instanceof Boolean) {
                    f1852e = g.d();
                    boolean a4 = QbSdk.a(context, g.d());
                    if (((Boolean) a3).booleanValue() && !a4) {
                        z5 = true;
                    }
                    if (!z5) {
                        TbsLog.e(TbsListener.tag_load_error, "318");
                        TbsLog.w(TbsListener.tag_load_error, "isX5Disable:".concat(String.valueOf(a4)));
                        TbsLog.w(TbsListener.tag_load_error, "(Boolean) ret:" + ((Boolean) a3));
                    }
                    AppMethodBeat.o(54993);
                }
            } else if ((a2 instanceof String) && ((String) a2).equalsIgnoreCase("AuthenticationFail")) {
                AppMethodBeat.o(54993);
            } else if (!(a2 instanceof Bundle)) {
                TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, new Throwable(String.valueOf(a2)));
                TbsLog.e(TbsListener.tag_load_error, "ret not instance of bundle");
                AppMethodBeat.o(54993);
            } else {
                Bundle bundle = (Bundle) a2;
                if (bundle.isEmpty()) {
                    TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, new Throwable(String.valueOf(a2)));
                    TbsLog.e(TbsListener.tag_load_error, "empty bundle");
                    AppMethodBeat.o(54993);
                } else {
                    try {
                        i2 = bundle.getInt("result_code", -1);
                    } catch (Exception e2) {
                        TbsLog.e(TAG, "bundle.getInt(KEY_RESULT_CODE) error : " + e2.toString());
                        i2 = -1;
                    }
                    if (i2 == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (TbsShareManager.isThirdPartyApp(context)) {
                        g.a(TbsShareManager.d(context));
                        String valueOf = String.valueOf(TbsShareManager.d(context));
                        f1853f = valueOf;
                        if (valueOf.length() == 5) {
                            f1853f = AppEventsConstants.EVENT_PARAM_VALUE_NO + f1853f;
                        }
                        if (f1853f.length() != 6) {
                            f1853f = "";
                        }
                    } else {
                        try {
                            if (Build.VERSION.SDK_INT >= 12) {
                                f1853f = bundle.getString("tbs_core_version", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            } else {
                                String string = bundle.getString("tbs_core_version");
                                f1853f = string;
                                if (string == null) {
                                    f1853f = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                                }
                            }
                        } catch (Exception e3) {
                            f1853f = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        }
                        try {
                            f1852e = Integer.parseInt(f1853f);
                        } catch (NumberFormatException e4) {
                            f1852e = 0;
                        }
                        g.a(f1852e);
                        if (f1852e == 0) {
                            TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE, new Throwable("sTbsVersion is 0"));
                            AppMethodBeat.o(54993);
                        } else {
                            if ((f1852e <= 0 || f1852e > 25442) && f1852e != 25472) {
                                z4 = false;
                            }
                            TbsLog.d(TbsDownloader.LOGTAG, "is_obsolete:".concat(String.valueOf(z4)));
                            if (z4) {
                                TbsLog.e(TbsDownloader.LOGTAG, "is_obsolete --> delete old core:" + f1852e);
                                f.b(q.a().r(context));
                                TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE, new Throwable("is_obsolete --> delete old core:" + f1852e));
                                AppMethodBeat.o(54993);
                            }
                        }
                    }
                    try {
                        f1851d = bundle.getStringArray("tbs_jarfiles");
                        if (!(f1851d instanceof String[])) {
                            TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE, new Throwable("sJarFiles not instanceof String[]: " + f1851d));
                            AppMethodBeat.o(54993);
                        } else {
                            try {
                                f1848a = bundle.getString("tbs_librarypath");
                                Object obj = null;
                                if (i2 != 0) {
                                    try {
                                        obj = k.a(f1850c, "getErrorCodeForLogReport", new Class[0], new Object[0]);
                                    } catch (Exception e5) {
                                    }
                                }
                                switch (i2) {
                                    case -2:
                                        if (!(obj instanceof Integer)) {
                                            TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 404, new Throwable("detail: ".concat(String.valueOf(obj))));
                                            z5 = z3;
                                            break;
                                        } else {
                                            TbsCoreLoadStat.getInstance().setLoadErrorCode(context, ((Integer) obj).intValue(), new Throwable("detail: ".concat(String.valueOf(obj))));
                                            z5 = z3;
                                            break;
                                        }
                                    case -1:
                                        if (!(obj instanceof Integer)) {
                                            TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE, new Throwable("detail: ".concat(String.valueOf(obj))));
                                            z5 = z3;
                                            break;
                                        } else {
                                            TbsCoreLoadStat.getInstance().setLoadErrorCode(context, ((Integer) obj).intValue(), new Throwable("detail: ".concat(String.valueOf(obj))));
                                            z5 = z3;
                                            break;
                                        }
                                    case 0:
                                        z5 = z3;
                                        break;
                                    default:
                                        TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 415, new Throwable("detail: " + obj + "errcode" + i2));
                                        z5 = z3;
                                        break;
                                }
                            } catch (Exception e6) {
                                AppMethodBeat.o(54993);
                            }
                        }
                    } catch (Throwable th) {
                        TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, th);
                        AppMethodBeat.o(54993);
                    }
                }
            }
            if (!z5) {
                TbsLog.e(TbsListener.tag_load_error, "319");
            }
            AppMethodBeat.o(54993);
        }
        return z5;
    }

    @Override // com.tencent.smtt.sdk.b.c
    public String[] getDexLoaderFileList(Context context, Context context2, String str) {
        AppMethodBeat.i(54994);
        a(context);
        if (f1851d instanceof String[]) {
            int length = f1851d.length;
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = str + f1851d[i2];
            }
            AppMethodBeat.o(54994);
            return strArr;
        }
        Object a2 = k.a(f1850c, "getJarFiles", new Class[]{Context.class, Context.class, String.class}, context, context2, str);
        boolean z = a2 instanceof String[];
        String[] strArr2 = a2;
        if (!z) {
            strArr2 = new String[]{""};
        }
        String[] strArr3 = (String[]) strArr2;
        AppMethodBeat.o(54994);
        return strArr3;
    }

    @Override // com.tencent.smtt.sdk.b.c
    public boolean useSoftWare() {
        AppMethodBeat.i(54995);
        if (f1850c == null) {
            AppMethodBeat.o(54995);
            return false;
        }
        Object a2 = k.a(f1850c, "useSoftWare", new Class[0], new Object[0]);
        if (a2 == null) {
            a2 = k.a(f1850c, "useSoftWare", new Class[]{Integer.TYPE}, Integer.valueOf(a.a()));
        }
        if (a2 == null) {
            AppMethodBeat.o(54995);
            return false;
        }
        boolean booleanValue = ((Boolean) a2).booleanValue();
        AppMethodBeat.o(54995);
        return booleanValue;
    }

    @Override // com.tencent.smtt.sdk.b.c
    public Object onMiscCallExtension(Context context, String str, Bundle bundle) {
        AppMethodBeat.i(54996);
        if (!a(context)) {
            Integer valueOf = Integer.valueOf((int) EXTENSION_INIT_FAILURE);
            AppMethodBeat.o(54996);
            return valueOf;
        }
        Object a2 = k.a(f1850c, "miscCall", new Class[]{String.class, Bundle.class}, str, bundle);
        if (a2 != null) {
            AppMethodBeat.o(54996);
            return a2;
        }
        AppMethodBeat.o(54996);
        return null;
    }

    @Override // com.tencent.smtt.sdk.b.c
    public boolean init(Context context) {
        int i2;
        File file;
        String absolutePath;
        AppMethodBeat.i(54997);
        try {
            File r = q.a().r(context);
            if (r == null) {
                TbsLog.e(TAG, "QbSdk init (false) optDir == null");
                TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                AppMethodBeat.o(54997);
                return false;
            }
            if (!TbsShareManager.isThirdPartyApp(context)) {
                if (f1852e != 0) {
                    i2 = q.a().a(true, context);
                    if (f1852e != i2) {
                        f1849b = null;
                        f1850c = null;
                        TbsLog.e(TAG, "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=".concat(String.valueOf(i2)), true);
                        TbsLog.e(TAG, "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + f1852e, true);
                        TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 303, new Throwable("sTbsVersion: " + f1852e + "; tbsCoreInstalledVer: " + i2));
                        AppMethodBeat.o(54997);
                        return false;
                    }
                } else {
                    i2 = 0;
                }
                f1852e = i2;
            } else if (f1852e == 0 || f1852e == TbsShareManager.d(context)) {
                int d2 = TbsShareManager.d(context);
                f1852e = d2;
                if (d2 == 0 || f1852e == TbsShareManager.d(context)) {
                    f1852e = TbsShareManager.d(context);
                } else {
                    f1849b = null;
                    f1850c = null;
                    TbsLog.e(TAG, "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
                    TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 302, new Throwable("sTbsVersion: " + f1852e + "; AvailableTbsCoreVersion: " + TbsShareManager.d(context)));
                    AppMethodBeat.o(54997);
                    return false;
                }
            } else {
                f1849b = null;
                f1850c = null;
                TbsLog.e(TAG, "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
                TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 302, new Throwable("sTbsVersion: " + f1852e + "; AvailableTbsCoreVersion: " + TbsShareManager.d(context)));
                AppMethodBeat.o(54997);
                return false;
            }
            if (f1849b == null || f1850c == null) {
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    file = new File(q.a().r(context), "tbs_sdk_extension_dex.jar");
                } else if (TbsShareManager.j(context)) {
                    file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                } else {
                    TbsLog.d(TAG, "QbSdk init (false) isShareTbsCoreAvailable=false");
                    TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                    AppMethodBeat.o(54997);
                    return false;
                }
                if (!file.exists()) {
                    try {
                        TbsLog.e(TAG, "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                        int j2 = q.a().j(context);
                        if (new File(file.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                            if (j2 > 0) {
                                TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITH_CORE, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!".concat(String.valueOf(j2))));
                            } else {
                                TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!".concat(String.valueOf(j2))));
                            }
                        } else if (j2 > 0) {
                            TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITH_CORE, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!".concat(String.valueOf(j2))));
                        } else {
                            TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITHOUT_CORE, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!".concat(String.valueOf(j2))));
                        }
                    } catch (Throwable th) {
                    }
                    AppMethodBeat.o(54997);
                    return false;
                }
                if (TbsShareManager.getHostCorePathAppDefined() != null) {
                    absolutePath = TbsShareManager.getHostCorePathAppDefined();
                } else {
                    absolutePath = r.getAbsolutePath();
                }
                TbsLog.i(TAG, "QbSdk init optDirExtension #1 is ".concat(String.valueOf(absolutePath)));
                TbsLog.i(TAG, "new DexLoader #1 dexFile is " + file.getAbsolutePath());
                x.a().a(context);
                m.a(context);
                f1849b = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, absolutePath, QbSdk.getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                if (QbSdk.isEnableSensitiveApi() || k.a(f1849b, "isSuiteableGetSensitative", (Class<?>[]) new Class[0], new Object[0]) != null) {
                    loadTBSSDKExtension(context, file.getParent());
                    k.a(f1850c, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, b.f2161a, b.f2162b, b.f2163c, b.f2164d);
                    k.a(f1850c, "setClientVersion", new Class[]{Integer.TYPE}, 1);
                    TbsLog.d(TAG, "QbSdk init (true)");
                    AppMethodBeat.o(54997);
                    return true;
                }
                TbsLog.e(TAG, "isSuiteableGetSensitative check failed,can not use x5");
                AppMethodBeat.o(54997);
                return false;
            }
            TbsLog.d(TAG, "QbSdk init (true) sExtensionClass != null");
            AppMethodBeat.o(54997);
            return true;
        } catch (Throwable th2) {
            TbsLog.e(TAG, "QbSdk init Throwable: " + Log.getStackTraceString(th2));
            TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.THROWABLE_QBSDK_INIT, th2);
            AppMethodBeat.o(54997);
            return false;
        }
    }

    @Override // com.tencent.smtt.sdk.b.c
    public boolean canLoadX5FirstTimeThirdApp(Context context) {
        String absolutePath;
        AppMethodBeat.i(54998);
        try {
            if (!context.getApplicationInfo().packageName.contains("com.moji.mjweather") || Build.VERSION.SDK_INT != 19) {
                if (f1849b == null) {
                    File r = q.a().r(context);
                    if (r == null) {
                        TbsLog.e(TAG, "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
                        AppMethodBeat.o(54998);
                        return false;
                    }
                    File file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                    if (!file.exists()) {
                        TbsLog.e(TAG, "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
                        AppMethodBeat.o(54998);
                        return false;
                    }
                    if (TbsShareManager.getHostCorePathAppDefined() != null) {
                        absolutePath = TbsShareManager.getHostCorePathAppDefined();
                    } else {
                        absolutePath = r.getAbsolutePath();
                    }
                    TbsLog.i(TAG, "QbSdk init optDirExtension #2 is ".concat(String.valueOf(absolutePath)));
                    TbsLog.i(TAG, "new DexLoader #2 dexFile is " + file.getAbsolutePath());
                    x.a().a(context);
                    m.a(context);
                    f1849b = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, absolutePath, QbSdk.getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    if (f1850c == null) {
                        if (TbsShareManager.e(context) == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                            TbsLogReport.getInstance(context.getApplicationContext()).setLoadErrorCode(TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL, "host context is null!");
                            AppMethodBeat.o(54998);
                            return false;
                        } else if (QbSdk.isEnableSensitiveApi() || k.a(f1849b, "isSuiteableGetSensitative", (Class<?>[]) new Class[0], new Object[0]) != null) {
                            loadTBSSDKExtension(context, file.getParent());
                        } else {
                            TbsLog.e(TAG, "isSuiteableGetSensitative check failed,can not use x5");
                            AppMethodBeat.o(54998);
                            return false;
                        }
                    }
                }
                Object a2 = k.a(f1850c, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
                if (a2 == null || !(a2 instanceof Boolean)) {
                    AppMethodBeat.o(54998);
                    return false;
                }
                boolean booleanValue = ((Boolean) a2).booleanValue();
                AppMethodBeat.o(54998);
                return booleanValue;
            }
            AppMethodBeat.o(54998);
            return true;
        } catch (Throwable th) {
            TbsLog.e(TAG, "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(th));
            AppMethodBeat.o(54998);
            return false;
        }
    }

    @Override // com.tencent.smtt.sdk.b.c
    public Bundle incrUpdate(Context context, Bundle bundle) {
        AppMethodBeat.i(54999);
        if (!a(context)) {
            TbsLogReport.getInstance(context).setInstallErrorCode(216, "initForPatch return false!");
            AppMethodBeat.o(54999);
            return null;
        }
        Object a2 = k.a(f1850c, "incrUpdate", new Class[]{Context.class, Bundle.class}, context, bundle);
        if (a2 != null) {
            Bundle bundle2 = (Bundle) a2;
            AppMethodBeat.o(54999);
            return bundle2;
        }
        TbsLogReport.getInstance(context).setInstallErrorCode(216, "incrUpdate return null!");
        AppMethodBeat.o(54999);
        return null;
    }

    public void dispatchX5EcCommands(Context context, Integer num, Map<Integer, String> map) {
        AppMethodBeat.i(188419);
        if (!a(context)) {
            AppMethodBeat.o(188419);
            return;
        }
        k.a(f1850c, "dispatchEmergencyCommand", new Class[]{Integer.class, Map.class}, num, map);
        AppMethodBeat.o(188419);
    }

    @Override // com.tencent.smtt.sdk.b.c
    public boolean isX5Disabled(Context context, int i2, int i3) {
        AppMethodBeat.i(55000);
        if (QbSdk.mSettings == null || !QbSdk.mSettings.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) || !QbSdk.mSettings.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            q.a().b(context, g.f2050a == 0);
            if (!QbSdk.isEnableSensitiveApi()) {
                TbsLog.e(TAG, "isEnableSensitiveApi return false,disable core");
                AppMethodBeat.o(55000);
                return true;
            } else if (!b(context)) {
                AppMethodBeat.o(55000);
                return true;
            } else {
                Object a2 = k.a(f1850c, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i2), Integer.valueOf((int) TbsConfig.TBS_SDK_VERSIONCODE), Integer.valueOf(i3));
                TbsLog.d(TAG, "QbSdk isX5Disabled  ret=".concat(String.valueOf(a2)));
                if (a2 != null) {
                    boolean booleanValue = ((Boolean) a2).booleanValue();
                    AppMethodBeat.o(55000);
                    return booleanValue;
                }
                Object a3 = k.a(f1850c, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i2), Integer.valueOf((int) TbsConfig.TBS_SDK_VERSIONCODE));
                if (a3 != null) {
                    boolean booleanValue2 = ((Boolean) a3).booleanValue();
                    AppMethodBeat.o(55000);
                    return booleanValue2;
                }
                AppMethodBeat.o(55000);
                return true;
            }
        } else {
            TbsLog.i(TAG, "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
            AppMethodBeat.o(55000);
            return true;
        }
    }

    @Override // com.tencent.smtt.sdk.b.c
    public boolean isX5DisabledSync(Context context) {
        AppMethodBeat.i(55001);
        if (n.a(context).c() == 2) {
            AppMethodBeat.o(55001);
            return false;
        } else if (!b(context)) {
            AppMethodBeat.o(55001);
            return true;
        } else {
            Object a2 = k.a(f1850c, "isX5DisabledSync", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(q.a().j(context)), Integer.valueOf((int) TbsConfig.TBS_SDK_VERSIONCODE));
            TbsLog.d(TAG, "QbSdk isX5DisabledSync  ret=".concat(String.valueOf(a2)));
            if (a2 != null) {
                boolean booleanValue = ((Boolean) a2).booleanValue();
                AppMethodBeat.o(55001);
                return booleanValue;
            }
            AppMethodBeat.o(55001);
            return true;
        }
    }

    @Override // com.tencent.smtt.sdk.b.c
    public boolean canUseVideoFeatrue(Context context, int i2) {
        AppMethodBeat.i(55002);
        Object a2 = k.a(f1850c, "canUseVideoFeatrue", new Class[]{Integer.TYPE}, Integer.valueOf(i2));
        if (a2 == null || !(a2 instanceof Boolean)) {
            AppMethodBeat.o(55002);
            return false;
        }
        boolean booleanValue = ((Boolean) a2).booleanValue();
        AppMethodBeat.o(55002);
        return booleanValue;
    }

    @Override // com.tencent.smtt.sdk.b.c
    public String getLibraryPath() {
        return f1848a;
    }

    @Override // com.tencent.smtt.sdk.b.c
    public String getTbsCoreVersionString() {
        return f1853f;
    }

    static boolean a(Context context) {
        AppMethodBeat.i(55003);
        TbsLog.d(TAG, "QbSdk initExtension");
        try {
            if (f1849b != null) {
                TbsLog.d(TAG, "QbSdk initExtension (true) sExtensionClass != null");
                AppMethodBeat.o(55003);
                return true;
            }
            File r = q.a().r(context);
            if (r == null) {
                TbsLog.e(TAG, "QbSdk initExtension (false) optDir == null");
                AppMethodBeat.o(55003);
                return false;
            }
            File file = new File(r, "tbs_sdk_extension_dex.jar");
            if (!file.exists()) {
                TbsLog.e(TAG, "QbSdk initExtension (false) dexFile.exists()=false", true);
                AppMethodBeat.o(55003);
                return false;
            }
            TbsLog.i(TAG, "new DexLoader #3 dexFile is " + file.getAbsolutePath());
            x.a().a(context);
            m.a(context);
            f1849b = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, r.getAbsolutePath(), QbSdk.getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            if (QbSdk.isEnableSensitiveApi() || k.a(f1849b, "isSuiteableGetSensitative", (Class<?>[]) new Class[0], new Object[0]) != null) {
                loadTBSSDKExtension(context, file.getParent());
                TbsLog.d(TAG, "QbSdk initExtension (true)");
                AppMethodBeat.o(55003);
                return true;
            }
            TbsLog.e(TAG, "isSuiteableGetSensitative check failed,can not use x5");
            AppMethodBeat.o(55003);
            return false;
        } catch (Throwable th) {
            TbsLog.e(TAG, "initExtension sys WebView: " + Log.getStackTraceString(th));
            AppMethodBeat.o(55003);
            return false;
        }
    }

    private static boolean b(Context context) {
        File file;
        String absolutePath;
        AppMethodBeat.i(55004);
        TbsLog.d(TAG, "QbSdk initForX5DisableConfig");
        try {
            if (f1849b != null) {
                TbsLog.d(TAG, "QbSdk initForX5DisableConfig (true) sExtensionClass != null");
                AppMethodBeat.o(55004);
                return true;
            }
            File r = q.a().r(context);
            if (r == null) {
                TbsLog.e(TAG, "QbSdk initForX5DisableConfig (false) optDir == null");
                AppMethodBeat.o(55004);
                return false;
            }
            if (!TbsShareManager.isThirdPartyApp(context)) {
                file = new File(q.a().r(context), "tbs_sdk_extension_dex.jar");
            } else if (TbsShareManager.j(context)) {
                file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
            } else {
                TbsLog.d(TAG, "QbSdk initForX5DisableConfig (false) isShareTbsCoreAvailable=false");
                TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 304);
                AppMethodBeat.o(55004);
                return false;
            }
            if (!file.exists()) {
                TbsLog.d(TAG, "QbSdk initForX5DisableConfig (false) tbs_sdk_extension_dex.jar is not exist!");
                TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
                AppMethodBeat.o(55004);
                return false;
            }
            if (TbsShareManager.getHostCorePathAppDefined() != null) {
                absolutePath = TbsShareManager.getHostCorePathAppDefined();
            } else {
                absolutePath = r.getAbsolutePath();
            }
            TbsLog.i(TAG, "QbSdk init optDirExtension #3 is ".concat(String.valueOf(absolutePath)));
            TbsLog.i(TAG, "new DexLoader #4 dexFile is " + file.getAbsolutePath());
            x.a().a(context);
            m.a(context);
            f1849b = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, absolutePath, QbSdk.getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            if (QbSdk.isEnableSensitiveApi() || k.a(f1849b, "isSuiteableGetSensitative", (Class<?>[]) new Class[0], new Object[0]) != null) {
                loadTBSSDKExtension(context, file.getParent());
                k.a(f1850c, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, b.f2161a, b.f2162b, b.f2163c, b.f2164d);
                k.a(f1850c, "setClientVersion", new Class[]{Integer.TYPE}, 1);
                TbsLog.d(TAG, "QbSdk initForX5DisableConfig (true)");
                AppMethodBeat.o(55004);
                return true;
            }
            TbsLog.e(TAG, "isSuiteableGetSensitative check failed,can not use x5");
            AppMethodBeat.o(55004);
            return false;
        } catch (Throwable th) {
            TbsLog.e(TAG, "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(th));
            AppMethodBeat.o(55004);
            return false;
        }
    }

    public static void loadTBSSDKExtension(Context context, String str) {
        Constructor<?> constructor;
        boolean z = true;
        AppMethodBeat.i(55005);
        if (f1850c != null) {
            AppMethodBeat.o(55005);
            return;
        }
        synchronized (QbSdk.class) {
            try {
                if (f1850c == null) {
                    if (f1849b == null) {
                        TbsLog.i(TAG, "QbSdk loadTBSSDKExtension sExtensionClass is null");
                    }
                    Constructor<?> constructor2 = null;
                    try {
                        constructor2 = f1849b.getConstructor(Context.class, Context.class, String.class, String.class, String.class);
                    } catch (Throwable th) {
                        z = false;
                    }
                    try {
                        if (TbsShareManager.isThirdPartyApp(context)) {
                            Context e2 = TbsShareManager.e(context);
                            if (e2 == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                                TbsLogReport.getInstance(context.getApplicationContext()).setLoadErrorCode(TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL, "host context is null!");
                                AppMethodBeat.o(55005);
                                return;
                            }
                            if (z) {
                                constructor = constructor2;
                            } else if (e2 == null) {
                                constructor = f1849b.getConstructor(Context.class, Context.class, String.class);
                            } else {
                                f1850c = f1849b.getConstructor(Context.class, Context.class).newInstance(context, e2);
                            }
                            f1850c = constructor.newInstance(context, e2, TbsShareManager.getHostCorePathAppDefined(), str, null);
                        } else if (!z) {
                            Constructor<?> constructor3 = f1849b.getConstructor(Context.class, Context.class);
                            if (context.getApplicationContext() != null) {
                                context = context.getApplicationContext();
                            }
                            f1850c = constructor3.newInstance(context, context);
                        } else {
                            String str2 = null;
                            if ("com.tencent.mm".equals(QbSdk.getCurrentProcessName(context)) && !WebView.mWebViewCreated) {
                                str2 = "notLoadSo";
                            }
                            if (context.getApplicationContext() != null) {
                                context = context.getApplicationContext();
                            }
                            f1850c = constructor2.newInstance(context, context, null, str, str2);
                        }
                    } catch (Throwable th2) {
                        TbsLog.e("QbSdk", "throwable" + Log.getStackTraceString(th2));
                    }
                    AppMethodBeat.o(55005);
                }
            } finally {
                AppMethodBeat.o(55005);
            }
        }
    }

    public static void fileInfoDetect(Context context, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(55006);
        x a2 = x.a();
        if (a2 != null && a2.b()) {
            try {
                a2.c().a().invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "fileInfoDetect", new Class[]{Context.class, String.class, ValueCallback.class}, context, str, valueCallback);
                AppMethodBeat.o(55006);
                return;
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(55006);
    }
}
