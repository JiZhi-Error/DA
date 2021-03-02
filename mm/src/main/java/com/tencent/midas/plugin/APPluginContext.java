package com.tencent.midas.plugin;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;

class APPluginContext extends ContextThemeWrapper {
    private AssetManager mAsset;
    private ClassLoader mClassLoader;
    private Resources mResources;
    private Resources.Theme mTheme;
    private int mThemeResId;

    public APPluginContext(Context context, int i2, String str, ClassLoader classLoader) {
        this(context, i2, str, classLoader, null);
    }

    public APPluginContext(Context context, int i2, String str, ClassLoader classLoader, Resources resources) {
        super(context, i2);
        AppMethodBeat.i(193039);
        this.mAsset = null;
        this.mResources = null;
        this.mTheme = null;
        this.mClassLoader = classLoader;
        APLog.i("APPluginContext", "APPluginContext mClassLoader:" + this.mClassLoader + " apkPath:" + str);
        if (resources != null) {
            this.mAsset = resources.getAssets();
            APLog.i("APPluginContext", "APPluginActivity APPluginContext 1 mAsset:" + this.mAsset);
            this.mResources = resources;
        } else {
            this.mAsset = getSelfAssets(context, str);
            this.mResources = getSelfRes(context, this.mAsset);
            APLog.i("APPluginContext", "APPluginActivity APPluginContext 2 mAsset:" + this.mAsset + ", mResources:" + this.mResources);
        }
        this.mTheme = getSelfTheme(this.mResources);
        AppMethodBeat.o(193039);
    }

    private AssetManager getSelfAssets(Context context, String str) {
        AssetManager assetManager;
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(193040);
        try {
            assetManager = (AssetManager) AssetManager.class.newInstance();
            try {
                Class.forName("com.tencent.theme.SkinEngine").getMethod("getInstances", new Class[0]);
                z = true;
            } catch (Exception e2) {
                APLog.w("APPluginContext", " is not has com.tencent.theme.SkinEngine e:" + e2.toString());
                z = false;
            } catch (Throwable th) {
            }
            if (!z) {
                try {
                    Class.forName("com.tencent.component.theme.SkinEngine").getMethod("getInstances", new Class[0]);
                    z2 = true;
                } catch (Exception e3) {
                    APLog.w("APPluginContext", " is not has com.tencent.component.theme.SkinEngine e:" + e3.toString());
                    z2 = false;
                }
            } else {
                z2 = z;
            }
            try {
                z3 = "com.tencent.weread".equals(getApplicationPackageName(context));
            } catch (Exception e4) {
                z3 = false;
            }
            if (z2 || z3) {
                ArrayList<String> midasEmptyPaht = APPluginUtils.getMidasEmptyPaht(context);
                APLog.i("APPluginContext", "loadEmptyResAPK emptyList.size:" + midasEmptyPaht.size());
                for (int i2 = 0; i2 < midasEmptyPaht.size(); i2++) {
                    String str2 = midasEmptyPaht.get(i2);
                    APLog.i("APPluginContext", "loadEmptyResAPK emptyResFirstPath:".concat(String.valueOf(str2)));
                    if (!TextUtils.isEmpty(str2)) {
                        APLog.i("APPluginContext", "loadEmptyResAPK id:".concat(String.valueOf(((Integer) AssetManager.class.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager, str2)).intValue())));
                    }
                }
            }
            AssetManager.class.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager, str);
        } catch (Throwable th2) {
            assetManager = null;
        }
        AppMethodBeat.o(193040);
        return assetManager;
    }

    private Resources getSelfRes(Context context, AssetManager assetManager) {
        AppMethodBeat.i(193041);
        Resources resources = new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
        AppMethodBeat.o(193041);
        return resources;
    }

    private Resources.Theme getSelfTheme(Resources resources) {
        AppMethodBeat.i(193042);
        Resources.Theme newTheme = resources.newTheme();
        this.mThemeResId = getInnerRIdValue("com.android.internal.R.style.Theme");
        newTheme.applyStyle(this.mThemeResId, true);
        AppMethodBeat.o(193042);
        return newTheme;
    }

    private int getInnerRIdValue(String str) {
        AppMethodBeat.i(193043);
        int i2 = -1;
        try {
            String substring = str.substring(0, str.indexOf(".R.") + 2);
            int lastIndexOf = str.lastIndexOf(".");
            String substring2 = str.substring(lastIndexOf + 1, str.length());
            String substring3 = str.substring(0, lastIndexOf);
            String str2 = substring + "$" + substring3.substring(substring3.lastIndexOf(".") + 1, substring3.length());
            i2 = Class.forName(str2).getDeclaredField(substring2).getInt(null);
            APLog.i("APPluginContext", "getInnderR rStrnig:" + substring3 + ", className:" + str2 + ", fieldName:" + substring2);
        } catch (Throwable th) {
        }
        AppMethodBeat.o(193043);
        return i2;
    }

    public Resources getRes() {
        return this.mResources;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public AssetManager getAssets() {
        return this.mAsset;
    }

    public Resources.Theme getTheme() {
        return this.mTheme;
    }

    public ClassLoader getClassLoader() {
        AppMethodBeat.i(193044);
        if (this.mClassLoader != null) {
            ClassLoader classLoader = this.mClassLoader;
            AppMethodBeat.o(193044);
            return classLoader;
        }
        ClassLoader classLoader2 = super.getClassLoader();
        AppMethodBeat.o(193044);
        return classLoader2;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.mClassLoader = classLoader;
    }

    private static String getApplicationPackageName(Context context) {
        AppMethodBeat.i(193045);
        String str = "";
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    str = packageManager.getPackageInfo(context.getPackageName(), 0).packageName;
                }
            } catch (Exception e2) {
                APLog.i("APMidasCommMethod", "getApplicationPackageName error:" + e2.toString());
                AppMethodBeat.o(193045);
            }
        }
        AppMethodBeat.o(193045);
        return str;
    }
}
