package com.tencent.midas.plugin;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import java.lang.reflect.Field;
import java.util.List;

public class APPluginActivity extends HellActivity implements IAPPluginActivity {
    private byte _hellAccFlag_;
    public Activity mActivity = null;
    protected String mApkFilePath = "";
    public Context mContext = null;
    private ClassLoader mDexClassLoader = null;
    private boolean mFinished = false;
    protected boolean mIsRunInPlugin = false;
    protected PackageInfo mPackageInfo = null;
    protected String mPluginName = "";
    public Activity mProxyActivity = null;
    protected View mProxyContentView = null;

    public static final Bitmap getDrawableBitmap(Drawable drawable) {
        AppMethodBeat.i(193046);
        if (drawable == null) {
            AppMethodBeat.o(193046);
            return null;
        } else if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            AppMethodBeat.o(193046);
            return bitmap;
        } else {
            AppMethodBeat.o(193046);
            return null;
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(193047);
        if (this.mIsRunInPlugin) {
            this.mActivity = this.mProxyActivity;
            APPluginStatic.add(this);
            AppMethodBeat.o(193047);
            return;
        }
        super.onCreate(bundle);
        this.mActivity = this;
        AppMethodBeat.o(193047);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnCreate(Bundle bundle) {
        AppMethodBeat.i(193048);
        onCreate(bundle);
        AppMethodBeat.o(193048);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnNewIntent(Intent intent) {
        AppMethodBeat.i(193049);
        onNewIntent(intent);
        AppMethodBeat.o(193049);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        AppMethodBeat.i(193050);
        if (this.mIsRunInPlugin) {
            AppMethodBeat.o(193050);
            return;
        }
        super.onStart();
        AppMethodBeat.o(193050);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnStart() {
        AppMethodBeat.i(193051);
        onStart();
        AppMethodBeat.o(193051);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(193052);
        if (this.mIsRunInPlugin) {
            AppMethodBeat.o(193052);
            return;
        }
        super.onResume();
        AppMethodBeat.o(193052);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnResume() {
        AppMethodBeat.i(193053);
        onResume();
        AppMethodBeat.o(193053);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(193054);
        if (this.mIsRunInPlugin) {
            AppMethodBeat.o(193054);
            return;
        }
        super.onPause();
        AppMethodBeat.o(193054);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnPause() {
        AppMethodBeat.i(193055);
        onPause();
        AppMethodBeat.o(193055);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onStop() {
        AppMethodBeat.i(193056);
        if (this.mIsRunInPlugin) {
            AppMethodBeat.o(193056);
            return;
        }
        super.onStop();
        AppMethodBeat.o(193056);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnStop() {
        AppMethodBeat.i(193057);
        onStop();
        AppMethodBeat.o(193057);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(193058);
        APLog.i("APPluginActivity", "onDestroy mIsRunInPlugin:" + this.mIsRunInPlugin);
        if (this.mIsRunInPlugin) {
            this.mDexClassLoader = null;
            APPluginStatic.remove(this);
            AppMethodBeat.o(193058);
            return;
        }
        super.onDestroy();
        AppMethodBeat.o(193058);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnDestroy() {
        AppMethodBeat.i(193059);
        onDestroy();
        AppMethodBeat.o(193059);
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        AppMethodBeat.i(193060);
        if (this.mIsRunInPlugin) {
            AppMethodBeat.o(193060);
            return;
        }
        super.onRestart();
        AppMethodBeat.o(193060);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnRestart() {
        AppMethodBeat.i(193061);
        onRestart();
        AppMethodBeat.o(193061);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnRestoreInstanceState(Bundle bundle) {
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnSaveInstanceState(Bundle bundle) {
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        AppMethodBeat.i(193062);
        if (this.mIsRunInPlugin) {
            this.mProxyContentView = LayoutInflater.from(this).inflate(i2, (ViewGroup) null);
            this.mActivity.setContentView(this.mProxyContentView);
            AppMethodBeat.o(193062);
            return;
        }
        super.setContentView(i2);
        AppMethodBeat.o(193062);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        AppMethodBeat.i(193063);
        if (this.mIsRunInPlugin) {
            this.mProxyContentView = view;
            this.mActivity.setContentView(this.mProxyContentView);
            AppMethodBeat.o(193063);
            return;
        }
        super.setContentView(view);
        AppMethodBeat.o(193063);
    }

    @Override // android.app.Activity
    public View findViewById(int i2) {
        AppMethodBeat.i(193064);
        if (!this.mIsRunInPlugin || this.mProxyContentView == null) {
            View findViewById = super.findViewById(i2);
            AppMethodBeat.o(193064);
            return findViewById;
        }
        View findViewById2 = this.mProxyContentView.findViewById(i2);
        if (findViewById2 == null) {
            findViewById2 = super.findViewById(i2);
        }
        AppMethodBeat.o(193064);
        return findViewById2;
    }

    public void startActivityForResult(Intent intent, int i2) {
        boolean z = false;
        AppMethodBeat.i(193065);
        if (this.mIsRunInPlugin) {
            if (intent.hasExtra(APPluginStatic.PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY)) {
                z = intent.getBooleanExtra(APPluginStatic.PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY, false);
            } else {
                List<ResolveInfo> queryIntentActivities = this.mActivity.getPackageManager().queryIntentActivities(intent, 65536);
                if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
                    z = true;
                }
            }
            if (!z) {
                this.mActivity.startActivityForResult(intent, i2);
                AppMethodBeat.o(193065);
                return;
            }
            intent.putExtra("pluginsdk_IsPluginActivity", true);
            this.mActivity.startActivityForResult(intent, i2);
            AppMethodBeat.o(193065);
            return;
        }
        super.startActivityForResult(intent, i2);
        AppMethodBeat.o(193065);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(193066);
        boolean onKeyDown = onKeyDown(i2, keyEvent);
        AppMethodBeat.o(193066);
        return onKeyDown;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(193067);
        boolean onKeyUp = onKeyUp(i2, keyEvent);
        AppMethodBeat.o(193067);
        return onKeyUp;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        AppMethodBeat.i(193068);
        boolean onKeyMultiple = onKeyMultiple(i2, i3, keyEvent);
        AppMethodBeat.o(193068);
        return onKeyMultiple;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void ISetOutHandler(Handler handler) {
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public Handler IGetInHandler() {
        return null;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void ISetIntent(Intent intent) {
        AppMethodBeat.i(193069);
        setIntent(intent);
        AppMethodBeat.o(193069);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public View IGetContentView() {
        return this.mProxyContentView;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(193070);
        AppMethodBeat.at(this, z);
        if (this.mIsRunInPlugin) {
            AppMethodBeat.o(193070);
            return;
        }
        super.onWindowFocusChanged(z);
        AppMethodBeat.o(193070);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnWindowFocusChanged(boolean z) {
        AppMethodBeat.i(193071);
        onWindowFocusChanged(z);
        AppMethodBeat.o(193071);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(193072);
        if (this.mIsRunInPlugin) {
            AppMethodBeat.o(193072);
            return false;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(193072);
        return onKeyDown;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(193073);
        if (this.mIsRunInPlugin) {
            AppMethodBeat.o(193073);
            return false;
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(193073);
        return onKeyUp;
    }

    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        AppMethodBeat.i(193074);
        if (this.mIsRunInPlugin) {
            AppMethodBeat.o(193074);
            return false;
        }
        boolean onKeyMultiple = super.onKeyMultiple(i2, i3, keyEvent);
        AppMethodBeat.o(193074);
        return onKeyMultiple;
    }

    public void openOptionsMenu() {
        AppMethodBeat.i(193075);
        if (this.mIsRunInPlugin) {
            this.mProxyActivity.openOptionsMenu();
            AppMethodBeat.o(193075);
            return;
        }
        super.openOptionsMenu();
        AppMethodBeat.o(193075);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(193076);
        if (this.mIsRunInPlugin) {
            AppMethodBeat.o(193076);
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(193076);
        return onTouchEvent;
    }

    public Context getApplicationContext() {
        AppMethodBeat.i(193077);
        APLog.i("APPluginActivity", "APPluginActivity getApplicationContext mProxyActivity:" + this.mProxyActivity);
        if (this.mIsRunInPlugin) {
            Context applicationContext = this.mProxyActivity.getApplicationContext();
            AppMethodBeat.o(193077);
            return applicationContext;
        }
        Context applicationContext2 = super.getApplicationContext();
        AppMethodBeat.o(193077);
        return applicationContext2;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void finish() {
        Intent intent;
        AppMethodBeat.i(193078);
        APLog.i("APPluginActivity", "APPluginActivity finish");
        if (this.mIsRunInPlugin) {
            int i2 = 0;
            synchronized (this) {
                try {
                    Field declaredField = Activity.class.getDeclaredField("mResultCode");
                    declaredField.setAccessible(true);
                    i2 = ((Integer) declaredField.get(this)).intValue();
                    Field declaredField2 = Activity.class.getDeclaredField("mResultData");
                    declaredField2.setAccessible(true);
                    intent = (Intent) declaredField2.get(this);
                } catch (Exception e2) {
                    new StringBuilder("APPluginActivity finish Exception:").append(e2.toString());
                    intent = null;
                }
                try {
                } catch (Throwable th) {
                    AppMethodBeat.o(193078);
                    throw th;
                }
            }
            this.mProxyActivity.setResult(i2, intent);
            this.mProxyActivity.finish();
            this.mFinished = true;
            AppMethodBeat.o(193078);
            return;
        }
        super.finish();
        AppMethodBeat.o(193078);
    }

    public boolean isFinishing() {
        AppMethodBeat.i(193079);
        if (this.mIsRunInPlugin) {
            boolean z = this.mFinished;
            AppMethodBeat.o(193079);
            return z;
        }
        boolean isFinishing = super.isFinishing();
        AppMethodBeat.o(193079);
        return isFinishing;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(193080);
        APLog.i("APPluginActivity", "APPluginActivity onActivityResult");
        if (this.mIsRunInPlugin) {
            AppMethodBeat.o(193080);
            return;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(193080);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(193081);
        onActivityResult(i2, i3, intent);
        AppMethodBeat.o(193081);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    @TargetApi(23)
    public void IRequestPermissions(String[] strArr, int i2) {
        AppMethodBeat.i(193082);
        a bl = c.a(i2, new a()).bl(strArr);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/midas/plugin/APPluginActivity", "IRequestPermissions", "([Ljava/lang/String;I)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        requestPermissions((String[]) bl.pG(0), ((Integer) bl.pG(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/midas/plugin/APPluginActivity", "IRequestPermissions", "([Ljava/lang/String;I)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        APLog.i("APPluginActivity", "IRequestPermissions() permissions=" + strArr + ", requestCode=" + i2);
        if (this.mIsRunInPlugin) {
            AppMethodBeat.o(193082);
            return;
        }
        super.requestPermissions(strArr, i2);
        AppMethodBeat.o(193082);
    }

    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(193083);
        APLog.i("APPluginActivity", "onRequestPermissionsResult() requestCode=".concat(String.valueOf(i2)));
        if (this.mIsRunInPlugin) {
            AppMethodBeat.o(193083);
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
        AppMethodBeat.o(193083);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    @TargetApi(23)
    public void IOnRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(193084);
        onRequestPermissionsResult(i2, strArr, iArr);
        AppMethodBeat.o(193084);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IInit(String str, String str2, Activity activity, ClassLoader classLoader, PackageInfo packageInfo) {
        AppMethodBeat.i(193085);
        this.mIsRunInPlugin = true;
        this.mDexClassLoader = classLoader;
        this.mProxyActivity = activity;
        this.mPluginName = str;
        this.mApkFilePath = str2;
        this.mPackageInfo = packageInfo;
        this.mContext = new APPluginContext(activity, 0, this.mApkFilePath, this.mDexClassLoader);
        attachBaseContext(this.mContext);
        AppMethodBeat.o(193085);
    }

    public LayoutInflater getLayoutInflater() {
        AppMethodBeat.i(193086);
        if (this.mContext != null) {
            LayoutInflater from = LayoutInflater.from(this.mContext);
            AppMethodBeat.o(193086);
            return from;
        }
        LayoutInflater from2 = LayoutInflater.from(this.mActivity);
        AppMethodBeat.o(193086);
        return from2;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public Resources IGetResource() {
        AppMethodBeat.i(193087);
        if (this.mContext != null) {
            Resources resources = this.mContext.getResources();
            AppMethodBeat.o(193087);
            return resources;
        }
        Resources resources2 = this.mActivity.getResources();
        AppMethodBeat.o(193087);
        return resources2;
    }

    public void overridePendingTransition(int i2, int i3) {
        AppMethodBeat.i(193088);
        if (this.mIsRunInPlugin) {
            this.mActivity.overridePendingTransition(i2, i3);
            AppMethodBeat.o(193088);
            return;
        }
        super.overridePendingTransition(i2, i3);
        AppMethodBeat.o(193088);
    }

    public Resources getOutResources() {
        AppMethodBeat.i(193089);
        if (this.mIsRunInPlugin) {
            Resources resources = this.mProxyActivity.getResources();
            AppMethodBeat.o(193089);
            return resources;
        }
        Resources resources2 = this.mActivity.getResources();
        AppMethodBeat.o(193089);
        return resources2;
    }

    public Activity getOutActivity() {
        return this.mProxyActivity;
    }

    @Override // android.content.Context, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.app.Activity
    public Object getSystemService(String str) {
        AppMethodBeat.i(193090);
        if ("window".equals(str) || "search".equals(str)) {
            if (this.mIsRunInPlugin) {
                Object systemService = this.mProxyActivity.getSystemService(str);
                AppMethodBeat.o(193090);
                return systemService;
            }
            Object systemService2 = super.getSystemService(str);
            AppMethodBeat.o(193090);
            return systemService2;
        } else if (this.mContext != null) {
            Object systemService3 = this.mContext.getSystemService(str);
            AppMethodBeat.o(193090);
            return systemService3;
        } else {
            Object systemService4 = super.getSystemService(str);
            AppMethodBeat.o(193090);
            return systemService4;
        }
    }

    public WindowManager getWindowManager() {
        AppMethodBeat.i(193091);
        if (this.mIsRunInPlugin) {
            WindowManager windowManager = this.mProxyActivity.getWindowManager();
            AppMethodBeat.o(193091);
            return windowManager;
        }
        WindowManager windowManager2 = super.getWindowManager();
        AppMethodBeat.o(193091);
        return windowManager2;
    }

    public int getChangingConfigurations() {
        AppMethodBeat.i(193092);
        if (this.mIsRunInPlugin) {
            int changingConfigurations = this.mProxyActivity.getChangingConfigurations();
            AppMethodBeat.o(193092);
            return changingConfigurations;
        }
        int changingConfigurations2 = super.getChangingConfigurations();
        AppMethodBeat.o(193092);
        return changingConfigurations2;
    }

    public Window getWindow() {
        AppMethodBeat.i(193093);
        if (this.mIsRunInPlugin) {
            Window window = this.mProxyActivity.getWindow();
            AppMethodBeat.o(193093);
            return window;
        }
        Window window2 = super.getWindow();
        AppMethodBeat.o(193093);
        return window2;
    }

    @Override // android.view.ContextThemeWrapper, android.app.Activity
    public void setTheme(int i2) {
        AppMethodBeat.i(193094);
        if (this.mIsRunInPlugin) {
            this.mProxyActivity.setTheme(i2);
            AppMethodBeat.o(193094);
            return;
        }
        super.setTheme(i2);
        AppMethodBeat.o(193094);
    }

    public void setRequestedOrientation(int i2) {
        AppMethodBeat.i(193095);
        super.setRequestedOrientation(i2);
        AppMethodBeat.o(193095);
    }

    public String getPackageName() {
        AppMethodBeat.i(193096);
        if (this.mIsRunInPlugin) {
            String str = this.mPackageInfo.packageName;
            AppMethodBeat.o(193096);
            return str;
        }
        String packageName = super.getPackageName();
        AppMethodBeat.o(193096);
        return packageName;
    }

    public PackageInfo getPackageInfo() {
        if (this.mIsRunInPlugin) {
            return this.mPackageInfo;
        }
        return null;
    }

    public ApplicationInfo getApplicationInfo() {
        AppMethodBeat.i(193097);
        if (this.mIsRunInPlugin) {
            ApplicationInfo applicationInfo = this.mPackageInfo.applicationInfo;
            AppMethodBeat.o(193097);
            return applicationInfo;
        }
        ApplicationInfo applicationInfo2 = super.getApplicationInfo();
        AppMethodBeat.o(193097);
        return applicationInfo2;
    }

    public Resources getHostResources() {
        AppMethodBeat.i(193098);
        Resources resources = this.mProxyActivity.getResources();
        AppMethodBeat.o(193098);
        return resources;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(193099);
        boolean onCreateOptionsMenu = onCreateOptionsMenu(menu);
        AppMethodBeat.o(193099);
        return onCreateOptionsMenu;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(193100);
        boolean onPrepareOptionsMenu = onPrepareOptionsMenu(menu);
        AppMethodBeat.o(193100);
        return onPrepareOptionsMenu;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnOptionsItemSelected(MenuItem menuItem) {
        AppMethodBeat.i(193101);
        boolean onOptionsItemSelected = onOptionsItemSelected(menuItem);
        AppMethodBeat.o(193101);
        return onOptionsItemSelected;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(193102);
        boolean onTouchEvent = onTouchEvent(motionEvent);
        AppMethodBeat.o(193102);
        return onTouchEvent;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IDispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(193103);
        boolean z = true;
        try {
            z = dispatchTouchEvent(motionEvent);
        } catch (Exception e2) {
        }
        AppMethodBeat.o(193103);
        return z;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnUserInteraction() {
        AppMethodBeat.i(193104);
        onUserInteraction();
        AppMethodBeat.o(193104);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IFinish() {
        AppMethodBeat.i(193105);
        finish();
        AppMethodBeat.o(193105);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IOnMenuItemSelected(int i2, MenuItem menuItem) {
        AppMethodBeat.i(193106);
        boolean onMenuItemSelected = onMenuItemSelected(i2, menuItem);
        AppMethodBeat.o(193106);
        return onMenuItemSelected;
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public void IOnConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(193107);
        onConfigurationChanged(configuration);
        AppMethodBeat.o(193107);
    }

    @Override // com.tencent.midas.plugin.IAPPluginActivity
    public boolean IIsWrapContent() {
        return true;
    }
}
