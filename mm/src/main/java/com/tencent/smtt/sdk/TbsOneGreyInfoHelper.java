package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreEntry;
import com.tencent.smtt.sandbox.Log;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.b.b;
import com.tencent.smtt.sdk.b.c;
import com.tencent.smtt.sdk.b.d;
import com.tencent.smtt.sdk.b.e;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class TbsOneGreyInfoHelper {

    /* renamed from: a  reason: collision with root package name */
    static IX5CoreEntry f1839a;

    /* renamed from: b  reason: collision with root package name */
    static c f1840b;

    /* renamed from: c  reason: collision with root package name */
    static boolean f1841c = false;

    /* renamed from: d  reason: collision with root package name */
    private static d f1842d;

    /* renamed from: e  reason: collision with root package name */
    private static int f1843e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static int f1844f = -1;

    /* renamed from: g  reason: collision with root package name */
    private static int f1845g = -1;
    public static DexLoader mDexloader;
    public static File path;

    static /* synthetic */ String a(String str) {
        AppMethodBeat.i(174296);
        String b2 = b(str);
        AppMethodBeat.o(174296);
        return b2;
    }

    public static void initExtension(final Context context) {
        AppMethodBeat.i(54343);
        if (f1840b != null) {
            AppMethodBeat.o(54343);
        } else if (!isOneModeAvailable(context)) {
            f1840b = new TbsOnlineSDKExtensionEntry();
            AppMethodBeat.o(54343);
        } else {
            f1840b = new c() {
                /* class com.tencent.smtt.sdk.TbsOneGreyInfoHelper.AnonymousClass1 */

                @Override // com.tencent.smtt.sdk.b.c
                public final boolean canLoadVideo(Context context) {
                    return false;
                }

                @Override // com.tencent.smtt.sdk.b.c
                public final boolean canLoadX5(Context context, boolean z, boolean z2) {
                    return true;
                }

                @Override // com.tencent.smtt.sdk.b.c
                public final String[] getDexLoaderFileList(Context context, Context context2, String str) {
                    return new String[0];
                }

                @Override // com.tencent.smtt.sdk.b.c
                public final boolean useSoftWare() {
                    return true;
                }

                @Override // com.tencent.smtt.sdk.b.c
                public final Object onMiscCallExtension(Context context, String str, Bundle bundle) {
                    return null;
                }

                @Override // com.tencent.smtt.sdk.b.c
                public final boolean init(Context context) {
                    return true;
                }

                @Override // com.tencent.smtt.sdk.b.c
                public final boolean canLoadX5FirstTimeThirdApp(Context context) {
                    return true;
                }

                @Override // com.tencent.smtt.sdk.b.c
                public final Bundle incrUpdate(Context context, Bundle bundle) {
                    return null;
                }

                @Override // com.tencent.smtt.sdk.b.c
                public final boolean isX5Disabled(Context context, int i2, int i3) {
                    return false;
                }

                @Override // com.tencent.smtt.sdk.b.c
                public final boolean isX5DisabledSync(Context context) {
                    return false;
                }

                @Override // com.tencent.smtt.sdk.b.c
                public final boolean canUseVideoFeatrue(Context context, int i2) {
                    return true;
                }

                @Override // com.tencent.smtt.sdk.b.c
                public final String getLibraryPath() {
                    return null;
                }

                @Override // com.tencent.smtt.sdk.b.c
                public final String getTbsCoreVersionString() {
                    AppMethodBeat.i(55104);
                    String valueOf = String.valueOf(q.a().j(context));
                    AppMethodBeat.o(55104);
                    return valueOf;
                }
            };
            AppMethodBeat.o(54343);
        }
    }

    public static synchronized void init(Context context) {
        synchronized (TbsOneGreyInfoHelper.class) {
            AppMethodBeat.i(54344);
            try {
                if (f1841c) {
                    AppMethodBeat.o(54344);
                } else {
                    TbsLog.i("TbsOneGreyInfoHolder", "init,current process=" + QbSdk.getCurrentProcessName(context));
                    if (!isOneModeAvailable(context)) {
                        TbsLog.i("TbsOneGreyInfoHolder", "tbsone mode not enable,return!");
                        AppMethodBeat.o(54344);
                    } else {
                        TBSOneManager a2 = a(context);
                        if (!a2.isComponentInstalled("x5webview")) {
                            TbsLog.i("TbsOneGreyInfoHolder", "x5 webview not installed,return!");
                            AppMethodBeat.o(54344);
                        } else {
                            a2.setPolicy(TBSOneManager.Policy.LOCAL_ONLY);
                            TBSOneComponent loadComponentSync = a2.loadComponentSync("x5webview");
                            if (loadComponentSync != null) {
                                IX5CoreEntry iX5CoreEntry = (IX5CoreEntry) loadComponentSync.getEntryObject();
                                f1839a = iX5CoreEntry;
                                path = loadComponentSync.getInstallationDirectory();
                                TbsLog.i("TbsOneGreyInfoHolder", "tbsone init success!,path=" + path + ",entry=" + iX5CoreEntry);
                            } else {
                                StatisticReport.create("LOAD_ERROR", TbsListener.ErrorCode.ERROR_ONE_ENTRY_INIT_NULL).report();
                            }
                            f1841c = true;
                            AppMethodBeat.o(54344);
                        }
                    }
                }
            } catch (Exception e2) {
                StatisticReport.create("LOAD_ERROR", TbsListener.ErrorCode.ERROR_ONE_ENTRY_INIT_THROWABLE).setDescription("exception", e2).report();
                TbsLog.e("tag", "entry create failed" + Log.getStackTraceString(e2));
                AppMethodBeat.o(54344);
            }
        }
    }

    static TBSOneManager a(Context context) {
        AppMethodBeat.i(188384);
        String str = BuildConfig.KINDA_DEFAULT;
        if (is64BitImpl()) {
            str = "default_64";
        }
        TBSOneManager instance = TBSOneManager.getInstance(context, str);
        AppMethodBeat.o(188384);
        return instance;
    }

    public static void init(DexLoader dexLoader, Context context, Context context2, String str, String str2) {
        AppMethodBeat.i(54345);
        f1839a = new b(dexLoader, context, context2, str, str2);
        f1842d = new e(dexLoader);
        AppMethodBeat.o(54345);
    }

    public static DexLoader getDexloader() {
        return mDexloader;
    }

    public static IX5CoreEntry getCoreEntry() {
        return f1839a;
    }

    public static boolean isTbsOneModeEnable(Context context) {
        AppMethodBeat.i(54346);
        if (f1843e == 1) {
            AppMethodBeat.o(54346);
            return true;
        } else if (f1843e == 2) {
            AppMethodBeat.o(54346);
            return false;
        } else {
            int b2 = b(context);
            if (b2 == 1) {
                f1843e = 2;
                AppMethodBeat.o(54346);
                return false;
            } else if (b2 == 2) {
                f1843e = 1;
                AppMethodBeat.o(54346);
                return true;
            } else {
                SharedPreferences sharedPreferences = context.getSharedPreferences(getCurrentProcessNameIngoreColon(context) + "_tbs_public_settings", 0);
                if (!sharedPreferences.contains("TBS_ONE_GREY") || sharedPreferences.getInt("TBS_ONE_GREY", -1) != 1 || TbsPVConfig.getInstance(context).isDisableTbsOneGrey()) {
                    f1843e = 2;
                    AppMethodBeat.o(54346);
                    return false;
                }
                f1843e = 1;
                AppMethodBeat.o(54346);
                return true;
            }
        }
    }

    public static boolean isOneModeAvailable(Context context) {
        boolean isComponentInstalled;
        AppMethodBeat.i(174293);
        int b2 = b(context);
        if (b2 == 1) {
            AppMethodBeat.o(174293);
            return false;
        } else if (b2 == 2) {
            AppMethodBeat.o(174293);
            return true;
        } else if (!QbSdk.isEnableSensitiveApi()) {
            TbsLog.i(TbsLog.X5LOGTAG, "isOneModeAvailable enable=false,isEnableSensitiveApi=false");
            AppMethodBeat.o(174293);
            return false;
        } else {
            boolean isTbsOneModeEnable = isTbsOneModeEnable(context);
            if (f1844f == 1) {
                isComponentInstalled = true;
            } else if (f1844f == 2) {
                isComponentInstalled = false;
            } else {
                isComponentInstalled = a(context).isComponentInstalled("x5webview");
                if (isComponentInstalled) {
                    f1844f = 1;
                } else {
                    f1844f = 2;
                }
            }
            if (!isTbsOneModeEnable || !isComponentInstalled) {
                AppMethodBeat.o(174293);
                return false;
            }
            AppMethodBeat.o(174293);
            return true;
        }
    }

    private static int b(Context context) {
        AppMethodBeat.i(188385);
        if (f1845g != -1) {
            int i2 = f1845g;
            AppMethodBeat.o(188385);
            return i2;
        }
        int i3 = context.getSharedPreferences("one_config", 0).getInt("one_enable", 0);
        f1845g = i3;
        AppMethodBeat.o(188385);
        return i3;
    }

    public static String getCurrentProcessNameIngoreColon(Context context) {
        AppMethodBeat.i(54347);
        if ("com.tencent.mm".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
            AppMethodBeat.o(54347);
            return "com.tencent.mm_tools";
        } else if (TbsConfig.APP_DEMO.equals(context.getApplicationContext().getApplicationInfo().packageName)) {
            AppMethodBeat.o(54347);
            return "com.tencent.tbs_tool";
        } else {
            String currentProcessName = QbSdk.getCurrentProcessName(context);
            if (TextUtils.isEmpty(currentProcessName)) {
                AppMethodBeat.o(54347);
                return "";
            }
            String replace = currentProcessName.replace(":", "_");
            AppMethodBeat.o(54347);
            return replace;
        }
    }

    public static synchronized c getSDKExtensionEntry() {
        c cVar;
        synchronized (TbsOneGreyInfoHelper.class) {
            cVar = f1840b;
        }
        return cVar;
    }

    public static boolean isTbsAvailable(Context context) {
        AppMethodBeat.i(54348);
        g a2 = g.a(true);
        a2.a(context, false, false, null);
        if (a2 == null || !a2.b()) {
            AppMethodBeat.o(54348);
            return false;
        }
        AppMethodBeat.o(54348);
        return true;
    }

    private static String b(String str) {
        JSONObject jSONObject;
        AppMethodBeat.i(174295);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(174295);
            return "";
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e2) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            String extensionName = getExtensionName(str);
            AppMethodBeat.o(174295);
            return extensionName;
        } else if (!jSONObject.isNull("ext")) {
            String optString = jSONObject.optString("ext");
            AppMethodBeat.o(174295);
            return optString;
        } else {
            AppMethodBeat.o(174295);
            return "";
        }
    }

    public static String getExtensionName(String str) {
        int lastIndexOf;
        AppMethodBeat.i(54349);
        if (str == null || str.length() <= 0 || (lastIndexOf = str.lastIndexOf(46)) < 0 || lastIndexOf >= str.length() - 1) {
            AppMethodBeat.o(54349);
            return str;
        }
        String substring = str.substring(lastIndexOf + 1);
        AppMethodBeat.o(54349);
        return substring;
    }

    public static d getTbsFileInterface(final Context context) {
        AppMethodBeat.i(188386);
        if (isOneModeAvailable(context)) {
            AnonymousClass2 r0 = new d() {
                /* class com.tencent.smtt.sdk.TbsOneGreyInfoHelper.AnonymousClass2 */

                @Override // com.tencent.smtt.sdk.b.d
                public final boolean a(Context context, String str) {
                    AppMethodBeat.i(54532);
                    boolean canOpenFile = TbsOneFileOpenManager.getInstance(context).canOpenFile(context, TbsOneGreyInfoHelper.a(str));
                    AppMethodBeat.o(54532);
                    return canOpenFile;
                }

                @Override // com.tencent.smtt.sdk.b.d
                public final void a() {
                    AppMethodBeat.i(54533);
                    TbsOneFileOpenManager.getInstance(context).closeFileReader();
                    AppMethodBeat.o(54533);
                }
            };
            AppMethodBeat.o(188386);
            return r0;
        }
        d dVar = f1842d;
        AppMethodBeat.o(188386);
        return dVar;
    }

    public static File getCoreDir(Context context) {
        AppMethodBeat.i(54351);
        if (isOneModeAvailable(context)) {
            File file = path;
            AppMethodBeat.o(54351);
            return file;
        }
        File file2 = new File(QbSdk.getTbsFolderDir(context), "core_share");
        if (file2.isDirectory() || file2.mkdir()) {
            AppMethodBeat.o(54351);
            return file2;
        }
        TbsLog.i("", "getTbsCoreShareDir,mkdir false");
        AppMethodBeat.o(54351);
        return null;
    }

    public static boolean is64BitImpl() {
        AppMethodBeat.i(188387);
        try {
            if (Build.VERSION.SDK_INT < 21) {
                AppMethodBeat.o(188387);
                return false;
            }
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            if (cls == null) {
                AppMethodBeat.o(188387);
                return false;
            }
            Method declaredMethod = cls.getDeclaredMethod("getRuntime", new Class[0]);
            if (declaredMethod == null) {
                AppMethodBeat.o(188387);
                return false;
            }
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke == null) {
                AppMethodBeat.o(188387);
                return false;
            }
            Method declaredMethod2 = cls.getDeclaredMethod("is64Bit", new Class[0]);
            if (declaredMethod2 == null) {
                AppMethodBeat.o(188387);
                return false;
            }
            Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
            if (invoke2 instanceof Boolean) {
                boolean booleanValue = ((Boolean) invoke2).booleanValue();
                AppMethodBeat.o(188387);
                return booleanValue;
            }
            AppMethodBeat.o(188387);
            return false;
        } catch (Throwable th) {
        }
    }
}
