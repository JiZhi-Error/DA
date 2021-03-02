package org.xwalk.core.resource;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;

public class XWalkContextWrapper extends ContextWrapper {
    private static final String GENERATED_RESOURCE_CLASS = "org.xwalk.core.R";
    private static final String TAG = "XWalkLib";
    private static String mPackageName = null;
    private static HashMap<Long, Integer> mResourcessKeyIdMap;
    static PackageInfo sInfo;
    static String sLastInfoStr;
    static Resources sResources = null;
    public int apkVersion = 0;
    public String extractedCoreDir;
    public int forceDarkBehavior = 2;
    public boolean isForceDarkMode = false;
    private ApplicationInfo mApplicationInfo;
    private ClassLoader mClassLoader;
    private Context mContext;
    private boolean mHasAddFilterResources = false;
    private final LayoutInflater mLayoutInflater;
    private Resources mResources;
    private Resources.Theme mTheme;
    public boolean usingCustomContext = false;

    public XWalkContextWrapper(Context context, int i2) {
        super(context);
        AppMethodBeat.i(155326);
        this.apkVersion = i2;
        String downloadApkPath = XWalkEnvironment.getDownloadApkPath(i2);
        this.extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(i2);
        this.mContext = context;
        this.mLayoutInflater = ((LayoutInflater) context.getSystemService("layout_inflater")).cloneInContext(this);
        XWalkLayoutInflaterFactory xWalkLayoutInflaterFactory = new XWalkLayoutInflaterFactory();
        xWalkLayoutInflaterFactory.layoutInflater = this.mLayoutInflater;
        try {
            Field declaredField = LayoutInflater.class.getDeclaredField("mFactorySet");
            declaredField.setAccessible(true);
            declaredField.setBoolean(this.mLayoutInflater, false);
        } catch (NoSuchFieldException e2) {
            Log.e(TAG, "XWalkContextWrapper mFactorySet" + e2.getMessage());
        } catch (IllegalAccessException e3) {
            Log.e(TAG, "XWalkContextWrapper mFactorySet" + e3.getMessage());
        }
        this.mLayoutInflater.setFactory(xWalkLayoutInflaterFactory);
        this.usingCustomContext = XWalkEnvironment.getUsingCustomContext();
        if (this.usingCustomContext) {
            this.mResources = new XWalkResource(getResources(context, downloadApkPath), context);
        } else {
            this.mResources = getResources(context, downloadApkPath);
        }
        if (XWalkEnvironment.isCurrentVersionSupportForceDarkMode()) {
            this.isForceDarkMode = XWalkEnvironment.getForceDarkMode();
            this.forceDarkBehavior = XWalkEnvironment.getForceDarkBehavior();
            Log.i(TAG, "force dark mode suopported isForceDarkMode:" + this.isForceDarkMode + ", forceDarkBehavior:" + this.forceDarkBehavior);
        } else {
            Log.i(TAG, "force dark mode not suopported");
        }
        if (!(this.mResources == null || this.mApplicationInfo == null)) {
            this.mTheme = this.mResources.newTheme();
            if (getPackageInfo(context, downloadApkPath) != null) {
                Resources.Theme theme = context.getTheme();
                if (theme != null) {
                    this.mTheme.setTo(theme);
                }
                this.mTheme.applyStyle(this.mApplicationInfo.theme, true);
            }
        }
        AppMethodBeat.o(155326);
    }

    private ApplicationInfo initByPath(Context context, String str) {
        AppMethodBeat.i(155327);
        PackageInfo packageInfo = getPackageInfo(context, str);
        if (packageInfo != null) {
            mPackageName = packageInfo.packageName;
            this.mApplicationInfo = packageInfo.applicationInfo;
            if (this.mApplicationInfo != null) {
                this.mApplicationInfo.sourceDir = str;
                this.mApplicationInfo.publicSourceDir = str;
            }
        }
        ApplicationInfo applicationInfo = this.mApplicationInfo;
        AppMethodBeat.o(155327);
        return applicationInfo;
    }

    private Resources getResources(Context context, String str) {
        AppMethodBeat.i(155328);
        if (sResources != null) {
            initByPath(context, str);
            Resources resources = sResources;
            AppMethodBeat.o(155328);
            return resources;
        }
        if (checkResApkExist(str)) {
            this.mApplicationInfo = initByPath(context, str);
            if (this.mApplicationInfo != null) {
                this.mApplicationInfo.sourceDir = str;
                this.mApplicationInfo.publicSourceDir = str;
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(this.mApplicationInfo);
                    if (resourcesForApplication != null) {
                        sResources = resourcesForApplication;
                        AppMethodBeat.o(155328);
                        return resourcesForApplication;
                    }
                } catch (Throwable th) {
                }
                Log.i(TAG, "XWalkContextWrapper try getResourcesNotWithReflect failed, use getResourcesWithReflect");
            }
            sResources = getResourcesWithReflect(context, str);
        }
        Log.i(TAG, "XWalkContextWrapper checkResApkExist false");
        Resources resources2 = sResources;
        AppMethodBeat.o(155328);
        return resources2;
    }

    private Resources getResourcesWithReflect(Context context, String str) {
        AppMethodBeat.i(155329);
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            Resources resources = super.getResources();
            Resources resources2 = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            AppMethodBeat.o(155329);
            return resources2;
        } catch (Exception e2) {
            Log.e(TAG, "XWalkContextWrapper getResourcesWithReflect error:" + e2.getMessage());
            AppMethodBeat.o(155329);
            return null;
        }
    }

    private boolean checkResApkExist(String str) {
        AppMethodBeat.i(155330);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(155330);
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            AppMethodBeat.o(155330);
            return false;
        }
        AppMethodBeat.o(155330);
        return true;
    }

    private synchronized PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageArchiveInfo;
        AppMethodBeat.i(155331);
        if (str == null) {
            packageArchiveInfo = null;
            AppMethodBeat.o(155331);
        } else if (str.equals(sLastInfoStr)) {
            packageArchiveInfo = sInfo;
            AppMethodBeat.o(155331);
        } else {
            sLastInfoStr = str;
            packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
            sInfo = packageArchiveInfo;
            AppMethodBeat.o(155331);
        }
        return packageArchiveInfo;
    }

    public HashMap<Long, Integer> getResourcesKeyIdMap(Resources resources) {
        AppMethodBeat.i(155332);
        if (mResourcessKeyIdMap != null) {
            HashMap<Long, Integer> hashMap = (HashMap) mResourcessKeyIdMap.clone();
            AppMethodBeat.o(155332);
            return hashMap;
        }
        Log.i(TAG, "getResourcesKeyIdMap start");
        HashMap<Long, Integer> hashMap2 = new HashMap<>();
        try {
            Class<?>[] classes = getClassLoader().loadClass(GENERATED_RESOURCE_CLASS).getClasses();
            for (Class<?> cls : classes) {
                if (cls.getSimpleName().equals("drawable")) {
                    Field[] fields = cls.getFields();
                    for (Field field : fields) {
                        if (Modifier.isFinal(field.getModifiers())) {
                            field.setAccessible(true);
                        }
                        int i2 = 0;
                        try {
                            TypedValue typedValue = new TypedValue();
                            i2 = field.getInt(null);
                            resources.getValue(i2, typedValue, true);
                            long j2 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
                            hashMap2.put(Long.valueOf(j2), Integer.valueOf(i2));
                            Log.d(TAG, "name:" + field.getName() + ",id:" + i2 + ",key:" + j2);
                        } catch (IllegalAccessException e2) {
                            Log.w(TAG, field.getName() + " is not accessable.");
                        } catch (IllegalArgumentException e3) {
                            Log.w(TAG, field.getName() + " is not int.");
                        } catch (Resources.NotFoundException e4) {
                            Log.w(TAG, field.getName() + " is not found." + Integer.toHexString(i2));
                        }
                        if (Modifier.isFinal(field.getModifiers())) {
                            field.setAccessible(false);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e5) {
            Log.e(TAG, "org.xwalk.core.Ris not found.");
        } catch (Exception e6) {
            Log.e(TAG, e6.getMessage());
        }
        mResourcessKeyIdMap = hashMap2;
        Log.i(TAG, "getResourcesKeyIdMap end, size:" + mResourcessKeyIdMap.keySet().size());
        HashMap<Long, Integer> hashMap3 = (HashMap) mResourcessKeyIdMap.clone();
        AppMethodBeat.o(155332);
        return hashMap3;
    }

    private Intent getRealIntent(Intent intent) {
        AppMethodBeat.i(155333);
        ComponentName component = intent.getComponent();
        if (component != null) {
            intent.setComponent(new ComponentName(getBaseContext(), component.getClassName()));
        }
        AppMethodBeat.o(155333);
        return intent;
    }

    public Context getApplicationContext() {
        AppMethodBeat.i(155334);
        Context applicationContext = this.mContext.getApplicationContext();
        AppMethodBeat.o(155334);
        return applicationContext;
    }

    public AssetManager getAssets() {
        AppMethodBeat.i(155335);
        Resources resources = getResources();
        if (resources != null) {
            AssetManager assets = resources.getAssets();
            AppMethodBeat.o(155335);
            return assets;
        }
        AssetManager assets2 = super.getAssets();
        AppMethodBeat.o(155335);
        return assets2;
    }

    public Context getBaseContext() {
        return this.mContext;
    }

    public LayoutInflater getLayoutInflater() {
        return this.mLayoutInflater;
    }

    public String getPackageName() {
        AppMethodBeat.i(155336);
        String packageName = this.mContext.getPackageName();
        AppMethodBeat.o(155336);
        return packageName;
    }

    public Context getPlatformContext() {
        return this.mContext;
    }

    public Resources getResources() {
        AppMethodBeat.i(155337);
        if (!this.mHasAddFilterResources) {
            if (WebViewExtension.addFilterResources(this.mResources, getResourcesKeyIdMap(this.mResources))) {
                this.mHasAddFilterResources = true;
            } else {
                Log.e(TAG, "mHasAddFilterResources = false");
            }
        }
        Resources resources = this.mResources;
        if (resources != null) {
            AppMethodBeat.o(155337);
            return resources;
        }
        Resources resources2 = super.getResources();
        AppMethodBeat.o(155337);
        return resources2;
    }

    @Override // android.content.Context, android.content.ContextWrapper
    public Object getSystemService(String str) {
        AppMethodBeat.i(155338);
        if (str.equals("layout_inflater")) {
            LayoutInflater layoutInflater = getLayoutInflater();
            AppMethodBeat.o(155338);
            return layoutInflater;
        }
        try {
            Object systemService = this.mContext.getSystemService(str);
            AppMethodBeat.o(155338);
            return systemService;
        } catch (Exception e2) {
            Log.e(TAG, "getSystemService failed " + e2.getMessage());
            AppMethodBeat.o(155338);
            return null;
        }
    }

    public Resources.Theme getTheme() {
        AppMethodBeat.i(155339);
        if (this.mTheme != null) {
            Resources.Theme theme = this.mTheme;
            AppMethodBeat.o(155339);
            return theme;
        }
        Resources.Theme theme2 = super.getTheme();
        AppMethodBeat.o(155339);
        return theme2;
    }

    public void setTheme(int i2) {
        AppMethodBeat.i(155340);
        if (this.mContext.getTheme() != null) {
            this.mContext.getTheme().applyStyle(i2, true);
            AppMethodBeat.o(155340);
            return;
        }
        super.setTheme(i2);
        AppMethodBeat.o(155340);
    }

    public void startActivity(Intent intent) {
        AppMethodBeat.i(155341);
        super.startActivity(getRealIntent(intent));
        AppMethodBeat.o(155341);
    }

    public ComponentName startService(Intent intent) {
        AppMethodBeat.i(155342);
        ComponentName startService = super.startService(getRealIntent(intent));
        AppMethodBeat.o(155342);
        return startService;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.mClassLoader = classLoader;
    }

    public ClassLoader getClassLoader() {
        AppMethodBeat.i(155343);
        if (this.mClassLoader != null) {
            ClassLoader classLoader = this.mClassLoader;
            AppMethodBeat.o(155343);
            return classLoader;
        }
        XWalkCoreWrapper instance = XWalkCoreWrapper.getInstance();
        if (instance != null) {
            ClassLoader bridgeLoader = instance.getBridgeLoader();
            AppMethodBeat.o(155343);
            return bridgeLoader;
        }
        ClassLoader classLoader2 = super.getClassLoader();
        AppMethodBeat.o(155343);
        return classLoader2;
    }

    static final class XWalkLayoutInflaterFactory implements LayoutInflater.Factory {
        LayoutInflater layoutInflater;

        private XWalkLayoutInflaterFactory() {
        }

        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            AppMethodBeat.i(155323);
            View view = null;
            try {
                view = inflateView(str, context, attributeSet);
                if ((view instanceof ViewStub) && Build.VERSION.SDK_INT >= 21) {
                    ((ViewStub) view).setLayoutInflater(this.layoutInflater);
                }
            } catch (ClassNotFoundException e2) {
                Log.w(XWalkContextWrapper.TAG, String.format("[XWalkContextWrapper] class not found. name:%s. Use default Inflate.", str));
            } catch (InflateException e3) {
                Log.w(XWalkContextWrapper.TAG, String.format("[XWalkContextWrapper] Inflate failed. name:%s. Use default Inflate.", str));
            }
            AppMethodBeat.o(155323);
            return view;
        }

        public final View inflateView(String str, Context context, AttributeSet attributeSet) {
            View view = null;
            AppMethodBeat.i(155324);
            if (str.indexOf(".") == -1) {
                if (str.equals("WebView")) {
                    view = createView(str, "android.webkit.", attributeSet);
                }
                if (view == null) {
                    view = createView(str, "android.widget.", attributeSet);
                }
                if (view == null) {
                    view = createView(str, "android.view.", attributeSet);
                }
            } else {
                view = this.layoutInflater.createView(str, null, attributeSet);
            }
            AppMethodBeat.o(155324);
            return view;
        }

        private View createView(String str, String str2, AttributeSet attributeSet) {
            AppMethodBeat.i(155325);
            View view = null;
            try {
                view = this.layoutInflater.createView(str, str2, attributeSet);
            } catch (InflateException | ClassNotFoundException e2) {
            }
            AppMethodBeat.o(155325);
            return view;
        }
    }
}
