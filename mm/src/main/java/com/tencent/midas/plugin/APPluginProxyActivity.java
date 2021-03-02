package com.tencent.midas.plugin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogUtil;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import dalvik.system.DexClassLoader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class APPluginProxyActivity extends HellActivity {
    private static final String TAG = "APPluginProxyActivity";
    private static String gPluginApkFilePath = null;
    protected static String gPluginName = "MidasPay";
    public static boolean mAppForground = true;
    private static Field sMMapField = null;
    private static Method sUnparcelMethod = null;
    protected String mCreateErrorInfo = null;
    private String mLaunchActivity = null;
    private IAPPluginActivity mPluginActivity = null;
    private String mPluginApkFilePath = null;
    private String mPluginName = null;
    protected int mStopFlag = 0;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0112 A[SYNTHETIC, Splitter:B:21:0x0112] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0188  */
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r10) {
        /*
        // Method dump skipped, instructions count: 537
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.plugin.APPluginProxyActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public boolean isWrapContent() {
        AppMethodBeat.i(193170);
        boolean z = true;
        if (this.mPluginActivity != null) {
            z = this.mPluginActivity.IIsWrapContent();
        }
        AppMethodBeat.o(193170);
        return z;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(193171);
        super.onNewIntent(intent);
        ClassLoader classLoader = APPluginLoader.getClassLoader(this.mPluginName, APPluginUtils.getMD5FromPath(APPluginInstallerAndUpdater.getInstallPathString(this, this.mPluginName)));
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity onNewIntent mPluginName:" + this.mPluginName + " classLoader: " + classLoader);
        if (classLoader != null) {
            intent.setExtrasClassLoader(classLoader);
        }
        if (this.mPluginActivity != null && intent.getBooleanExtra(APPluginStatic.PARAM_CLEAR_TOP, false)) {
            this.mPluginActivity.IOnNewIntent(intent);
        }
        AppMethodBeat.o(193171);
    }

    /* access modifiers changed from: protected */
    public void onUserLeaveHint() {
        AppMethodBeat.i(193172);
        super.onUserLeaveHint();
        AppMethodBeat.o(193172);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(193173);
        boolean z = false;
        if (this.mPluginActivity != null) {
            z = this.mPluginActivity.IOnKeyDown(i2, keyEvent);
        }
        if (!z) {
            z = super.onKeyDown(i2, keyEvent);
        }
        AppMethodBeat.o(193173);
        return z;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        AppMethodBeat.i(193174);
        super.onStart();
        if (this.mPluginActivity != null) {
            this.mPluginActivity.IOnStart();
        }
        AppMethodBeat.o(193174);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(193175);
        super.onResume();
        if (this.mPluginActivity != null) {
            this.mPluginActivity.IOnResume();
        }
        AppMethodBeat.o(193175);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onStop() {
        AppMethodBeat.i(193176);
        super.onStop();
        if (this.mPluginActivity != null) {
            this.mPluginActivity.IOnStop();
        }
        AppMethodBeat.o(193176);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(193177);
        super.onPause();
        if (this.mPluginActivity != null) {
            this.mPluginActivity.IOnPause();
        }
        AppMethodBeat.o(193177);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(193178);
        super.onDestroy();
        APLog.i(TAG, "onDestroy mPluginActivity:" + this.mPluginActivity);
        APLogUtil.flushIfNewProcess();
        if (this.mPluginActivity != null) {
            try {
                this.mPluginActivity.IOnDestroy();
                AppMethodBeat.o(193178);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(193178);
    }

    public void setRequestedOrientation(int i2) {
        AppMethodBeat.i(193179);
        APLog.i(TAG, "setRequestedOrientation requestedOrientation:".concat(String.valueOf(i2)));
        super.setRequestedOrientation(i2);
        AppMethodBeat.o(193179);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(193180);
        super.onConfigurationChanged(configuration);
        if (this.mPluginActivity != null) {
            try {
                this.mPluginActivity.IOnConfigurationChanged(configuration);
                AppMethodBeat.o(193180);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(193180);
    }

    public void startActivityForResult(Intent intent, int i2) {
        AppMethodBeat.i(193181);
        if (intent.getBooleanExtra("pluginsdk_IsPluginActivity", false)) {
            String str = null;
            ComponentName component = intent.getComponent();
            if (component != null) {
                str = component.getClassName();
            }
            intent.putExtra("pluginsdk_IsPluginActivity", false);
            if (str != null && str.length() > 0) {
                startPluginActivityForResult(this, str, intent, i2);
            }
        } else {
            super.startActivityForResult(intent, i2);
        }
        this.mStopFlag = 2;
        AppMethodBeat.o(193181);
    }

    public void startActivityForResult(Intent intent, int i2, int i3) {
        AppMethodBeat.i(193182);
        APLog.i("APPLuginProxyActivity", "startActivityForResult.public");
        this.mStopFlag = 2;
        isStart3rdApp(intent);
        if (!isMoveTaskToBack(this, intent)) {
            intent.addFlags(TPMediaCodecProfileLevel.HEVCMainTierLevel52);
        }
        super.startActivityForResult(intent, i2);
        AppMethodBeat.o(193182);
    }

    private void startPluginActivityForResult(Activity activity, String str, Intent intent, int i2) {
        AppMethodBeat.i(193183);
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity startPluginActivityForResult.private");
        Intent intent2 = new Intent(activity, getProxyActivity(str));
        intent2.putExtra(APPluginStatic.PARAM_PLUGIN_NAME, this.mPluginName);
        intent2.putExtra(APPluginStatic.PARAM_PLUGIN_PATH, this.mPluginApkFilePath);
        intent2.putExtra(APPluginStatic.PARAM_LAUNCH_ACTIVITY, str);
        if (intent != null) {
            intent2.addFlags(intent.getFlags());
            intent2.putExtras(intent);
        }
        activity.startActivityForResult(intent2, i2);
        AppMethodBeat.o(193183);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(193184);
        APLog.i("APPLuginProxyActivity", "onActivityResult requestCode:" + i2 + " resultCode:" + i3 + " mPluginActivity:" + this.mPluginActivity);
        super.onActivityResult(i2, i3, intent);
        if (this.mPluginActivity != null) {
            try {
                ClassLoader classLoader = APPluginLoader.getClassLoader(this.mPluginName, APPluginUtils.getMD5FromPath(APPluginInstallerAndUpdater.getInstallPath(this, this.mPluginName).getCanonicalPath()));
                if (!(classLoader == null || intent == null)) {
                    intent.setExtrasClassLoader(classLoader);
                }
                this.mPluginActivity.IOnActivityResult(i2, i3, intent);
                AppMethodBeat.o(193184);
                return;
            } catch (Exception e2) {
                APLog.w("APPLuginProxyActivity onActivityResult", e2.toString());
            }
        }
        AppMethodBeat.o(193184);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(193185);
        APLog.i("APPLuginProxyActivity", "onRequestPermissionsResult requestCode:" + i2 + " permissions:" + strArr + " grantResults:" + iArr);
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (this.mPluginActivity != null) {
            try {
                APPluginLoader.getClassLoader(this.mPluginName, APPluginUtils.getMD5FromPath(APPluginInstallerAndUpdater.getInstallPath(this, this.mPluginName).getCanonicalPath()));
                this.mPluginActivity.IOnRequestPermissionsResult(i2, strArr, iArr);
                AppMethodBeat.o(193185);
                return;
            } catch (Exception e2) {
                APLog.w("APPLuginProxyActivity onRequestPermissionsResult", e2.toString());
            }
        }
        AppMethodBeat.o(193185);
    }

    public static void openActivityForResult(Activity activity, String str, String str2, String str3, Intent intent, int i2) {
        AppMethodBeat.i(193186);
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult pluginName：".concat(String.valueOf(str)));
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult contextActivity：".concat(String.valueOf(activity)));
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult apkFilePath：".concat(String.valueOf(str2)));
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult startIntent：" + intent.getClass().getSimpleName());
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult startIntent：" + intent.getClass().getCanonicalName());
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult startIntent：" + intent.getClass().getClassLoader());
        gPluginName = str;
        try {
            gPluginApkFilePath = APPluginInstallerAndUpdater.getInstallPath(activity, str).getCanonicalPath();
        } catch (IOException e2) {
        }
        intent.putExtra(APPluginStatic.PARAM_PLUGIN_NAME, str);
        intent.putExtra(APPluginStatic.PARAM_LAUNCH_ACTIVITY, str3);
        intent.putExtra(APPluginStatic.PARAM_PLUGIN_PATH, str2);
        APLog.e("APPLuginProxyActivity", "put is new process: " + APMidasPayHelper.isNewProcess);
        APLog.e("APPLuginProxyActivity", "put is log enable: " + APMidasPayHelper.isLogEnable());
        intent.putExtra(APPluginStatic.PARAM_PLUGIN_IS_NEW_PROCESS, APMidasPayHelper.isNewProcess);
        intent.putExtra(APPluginStatic.PARAM_PLUGIN_LOG_ENABLE, APMidasPayHelper.isLogEnable());
        try {
            activity.startActivityForResult(intent, i2);
            AppMethodBeat.o(193186);
        } catch (Throwable th) {
            APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult Throwable:" + th.toString());
            AppMethodBeat.o(193186);
        }
    }

    public void onBackPressed() {
        AppMethodBeat.i(193187);
        try {
            super.onBackPressed();
            AppMethodBeat.o(193187);
        } catch (IllegalStateException e2) {
            finish();
            AppMethodBeat.o(193187);
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(193188);
        AppMethodBeat.at(this, z);
        super.onWindowFocusChanged(z);
        if (this.mPluginActivity != null) {
            this.mPluginActivity.IOnWindowFocusChanged(z);
        }
        AppMethodBeat.o(193188);
    }

    private String initPlugin() {
        PackageInfo packageInfo;
        AppMethodBeat.i(193189);
        PackageInfo packageInfo2 = APPluginStatic.sPackageInfoMap.get(this.mPluginApkFilePath);
        if (packageInfo2 == null) {
            packageInfo = APApkFileParser.getPackageInfo(this, this.mPluginApkFilePath, 1);
            if (packageInfo == null) {
                AppMethodBeat.o(193189);
                return "Get Package Info Failed!";
            }
            APPluginStatic.sPackageInfoMap.put(this.mPluginApkFilePath, packageInfo);
        } else {
            packageInfo = packageInfo2;
        }
        if (this.mLaunchActivity == null || this.mLaunchActivity.length() == 0) {
            if (packageInfo.activities == null || packageInfo.activities.length == 0) {
                AppMethodBeat.o(193189);
                return "Activity Not Found!";
            }
            this.mLaunchActivity = packageInfo.activities[0].name;
        }
        DexClassLoader orCreateClassLoaderByPath = APPluginLoader.getOrCreateClassLoaderByPath(this, this.mPluginName, this.mPluginApkFilePath);
        getIntent().setExtrasClassLoader(orCreateClassLoaderByPath);
        this.mPluginActivity = (IAPPluginActivity) orCreateClassLoaderByPath.loadClass(this.mLaunchActivity).newInstance();
        this.mPluginActivity.IInit(this.mPluginName, this.mPluginApkFilePath, this, orCreateClassLoaderByPath, packageInfo);
        this.mPluginActivity.ISetIntent(getIntent());
        AppMethodBeat.o(193189);
        return null;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(193190);
        if (this.mPluginActivity != null) {
            boolean IOnCreateOptionsMenu = this.mPluginActivity.IOnCreateOptionsMenu(menu);
            AppMethodBeat.o(193190);
            return IOnCreateOptionsMenu;
        }
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        AppMethodBeat.o(193190);
        return onCreateOptionsMenu;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(193191);
        if (this.mPluginActivity != null) {
            boolean IOnPrepareOptionsMenu = this.mPluginActivity.IOnPrepareOptionsMenu(menu);
            AppMethodBeat.o(193191);
            return IOnPrepareOptionsMenu;
        }
        boolean onPrepareOptionsMenu = super.onPrepareOptionsMenu(menu);
        AppMethodBeat.o(193191);
        return onPrepareOptionsMenu;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        AppMethodBeat.i(193192);
        if (this.mPluginActivity != null) {
            boolean IOnOptionsItemSelected = this.mPluginActivity.IOnOptionsItemSelected(menuItem);
            AppMethodBeat.o(193192);
            return IOnOptionsItemSelected;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        AppMethodBeat.o(193192);
        return onOptionsItemSelected;
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        AppMethodBeat.i(193193);
        if (this.mPluginActivity != null) {
            boolean IOnMenuItemSelected = this.mPluginActivity.IOnMenuItemSelected(i2, menuItem);
            AppMethodBeat.o(193193);
            return IOnMenuItemSelected;
        }
        boolean onMenuItemSelected = super.onMenuItemSelected(i2, menuItem);
        AppMethodBeat.o(193193);
        return onMenuItemSelected;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.i(193194);
        ClassLoader classLoader = APPluginLoader.getClassLoader(this.mPluginName, APPluginUtils.getMD5FromPath(APPluginInstallerAndUpdater.getInstallPathString(this, this.mPluginName)));
        if (classLoader != null) {
            try {
                setClassLoaderToEveryBundle(bundle, classLoader);
            } catch (Exception e2) {
            }
        }
        super.onRestoreInstanceState(bundle);
        if (this.mPluginActivity != null) {
            this.mPluginActivity.IOnRestoreInstanceState(bundle);
        }
        AppMethodBeat.o(193194);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(193195);
        if (this.mPluginActivity != null) {
            this.mPluginActivity.IOnSaveInstanceState(bundle);
        }
        bundle.putString(APPluginStatic.PARAM_PLUGIN_NAME, this.mPluginName);
        bundle.putString(APPluginStatic.PARAM_PLUGIN_LOCATION, this.mPluginName);
        bundle.putString(APPluginStatic.PARAM_PLUGIN_PATH, this.mPluginApkFilePath);
        bundle.putString(APPluginStatic.PARAM_LAUNCH_ACTIVITY, this.mLaunchActivity);
        super.onSaveInstanceState(bundle);
        AppMethodBeat.o(193195);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(193196);
        if (this.mPluginActivity != null) {
            boolean IOnTouchEvent = this.mPluginActivity.IOnTouchEvent(motionEvent);
            AppMethodBeat.o(193196);
            return IOnTouchEvent;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(193196);
        return onTouchEvent;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(193197);
        if (this.mPluginActivity != null) {
            boolean IDispatchTouchEvent = this.mPluginActivity.IDispatchTouchEvent(motionEvent);
            AppMethodBeat.o(193197);
            return IDispatchTouchEvent;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(193197);
        return dispatchTouchEvent;
    }

    public void onUserInteraction() {
        AppMethodBeat.i(193198);
        if (this.mPluginActivity != null) {
            this.mPluginActivity.IOnUserInteraction();
            AppMethodBeat.o(193198);
            return;
        }
        super.onUserInteraction();
        AppMethodBeat.o(193198);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends com.tencent.midas.plugin.APPluginProxyActivity> */
    /* access modifiers changed from: protected */
    public Class<? extends APPluginProxyActivity> getProxyActivity(String str) {
        AppMethodBeat.i(193199);
        Class cls = getClass();
        AppMethodBeat.o(193199);
        return cls;
    }

    private boolean isStart3rdApp(Intent intent) {
        AppMethodBeat.i(193200);
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action) && action.equals("android.media.action.IMAGE_CAPTURE")) {
            AppMethodBeat.o(193200);
            return true;
        } else if (TextUtils.isEmpty(action) || !action.equals("android.intent.action.GET_CONTENT")) {
            ComponentName component = intent.getComponent();
            if (component != null) {
                String packageName = component.getPackageName();
                if (TextUtils.isEmpty(packageName) || !packageName.equals("com.tencent.midas.pay")) {
                    String className = component.getClassName();
                    if (!TextUtils.isEmpty(className) && className.equals(TbsConfig.APP_QZONE)) {
                        AppMethodBeat.o(193200);
                        return true;
                    }
                } else {
                    AppMethodBeat.o(193200);
                    return true;
                }
            }
            AppMethodBeat.o(193200);
            return false;
        } else {
            AppMethodBeat.o(193200);
            return true;
        }
    }

    public static boolean isMoveTaskToBack(Context context, Intent intent) {
        AppMethodBeat.i(193201);
        if (intent.getComponent() == null) {
            AppMethodBeat.o(193201);
            return true;
        } else if (!intent.getComponent().getPackageName().equals(context.getPackageName())) {
            AppMethodBeat.o(193201);
            return true;
        } else {
            AppMethodBeat.o(193201);
            return false;
        }
    }

    private static void setClassLoaderToEveryBundle(Bundle bundle, ClassLoader classLoader) {
        AppMethodBeat.i(193202);
        if (bundle == null) {
            AppMethodBeat.o(193202);
            return;
        }
        bundle.setClassLoader(classLoader);
        if (sUnparcelMethod == null || sMMapField == null) {
            Class<?> cls = bundle.getClass();
            Method declaredMethod = cls.getDeclaredMethod("unparcel", new Class[0]);
            sUnparcelMethod = declaredMethod;
            declaredMethod.setAccessible(true);
            Field declaredField = cls.getDeclaredField("mMap");
            sMMapField = declaredField;
            declaredField.setAccessible(true);
        }
        sUnparcelMethod.invoke(bundle, new Object[0]);
        Map map = (Map) sMMapField.get(bundle);
        if (map != null) {
            for (Object obj : map.values()) {
                if (obj instanceof Bundle) {
                    setClassLoaderToEveryBundle((Bundle) obj, classLoader);
                }
            }
        }
        AppMethodBeat.o(193202);
    }

    /* access modifiers changed from: protected */
    public boolean shouldHandleStartPluginFailed(String str) {
        AppMethodBeat.i(193203);
        boolean z = false;
        if (str.contains("permission") || str.contains("filenotfoundexception")) {
            showNeedUninstanllAndInstallDialog();
            z = true;
        } else if (str.contains("resources$notfoundexception") || str.contains("resourcesnotfoundexception")) {
            showNeedUninstanllAndInstallDialog();
            z = true;
        }
        AppMethodBeat.o(193203);
        return z;
    }

    private void logStartPluginErrInfo(String str) {
        boolean z = true;
        AppMethodBeat.i(193204);
        if (str.contains("permission") || str.contains("filenotfoundexception")) {
            APLog.i("logStartPluginErrInfo", "mPluginApkFilePath" + this.mPluginApkFilePath);
            ApplicationInfo applicationInfo = getApplicationInfo();
            if (applicationInfo != null) {
                boolean z2 = (applicationInfo.flags & 1) > 0;
                if ((applicationInfo.flags & 128) <= 0) {
                    z = false;
                }
                APLog.d("", "UID: " + applicationInfo.uid + ", IsSystemApp: " + z2 + ", IsUpdateSystemApp: " + z);
            }
            AppMethodBeat.o(193204);
            return;
        }
        if (!str.contains("resources$notfoundexception") && !str.contains("resourcesnotfoundexception")) {
            str.contains("classnotfoundexception");
        }
        AppMethodBeat.o(193204);
    }

    /* access modifiers changed from: protected */
    public void showNeedUninstanllAndInstallDialog() {
        AppMethodBeat.i(193205);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("温馨提示");
        builder.setMessage("系统繁忙" + this.mPluginName + "失败，请卸载重装~");
        builder.setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
            /* class com.tencent.midas.plugin.APPluginProxyActivity.AnonymousClass1 */

            public void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(193038);
                APPluginProxyActivity.this.finish();
                AppMethodBeat.o(193038);
            }
        });
        try {
            builder.create().show();
            AppMethodBeat.o(193205);
        } catch (Exception e2) {
            AppMethodBeat.o(193205);
        }
    }
}
