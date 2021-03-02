package com.tencent.tinker.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.ArrayMap;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
public class TinkerResourcePatcher {
    private static final String TAG = "Tinker.ResourcePatcher";
    private static final String TEST_ASSETS_VALUE = "only_use_to_test_tinker_resource.txt";
    private static Method addAssetPathAsSharedLibraryMethod = null;
    private static Method addAssetPathMethod = null;
    private static Field assetsFiled = null;
    private static Object currentActivityThread = null;
    private static Method ensureStringBlocksMethod = null;
    private static AssetManager newAssetManager = null;
    private static Field packagesFiled = null;
    private static Field publicSourceDirField = null;
    private static Collection<WeakReference<Resources>> references = null;
    private static Field resDir = null;
    private static Field resourcePackagesFiled = null;
    private static Field resourcesImplFiled = null;
    private static Field stringBlocksField = null;

    TinkerResourcePatcher() {
    }

    public static void isResourceCanPatch(Context context) {
        Class<?> cls;
        Class<?> cls2 = Class.forName("android.app.ActivityThread");
        currentActivityThread = ShareReflectUtil.getActivityThread(context, cls2);
        try {
            cls = Class.forName("android.app.LoadedApk");
        } catch (ClassNotFoundException e2) {
            cls = Class.forName("android.app.ActivityThread$PackageInfo");
        }
        resDir = ShareReflectUtil.findField(cls, "mResDir");
        packagesFiled = ShareReflectUtil.findField(cls2, "mPackages");
        if (Build.VERSION.SDK_INT < 27) {
            resourcePackagesFiled = ShareReflectUtil.findField(cls2, "mResourcePackages");
        }
        AssetManager assets = context.getAssets();
        addAssetPathMethod = ShareReflectUtil.findMethod(assets, "addAssetPath", String.class);
        if (shouldAddSharedLibraryAssets(context.getApplicationInfo())) {
            addAssetPathAsSharedLibraryMethod = ShareReflectUtil.findMethod(assets, "addAssetPathAsSharedLibrary", String.class);
        }
        try {
            stringBlocksField = ShareReflectUtil.findField(assets, "mStringBlocks");
            ensureStringBlocksMethod = ShareReflectUtil.findMethod(assets, "ensureStringBlocks", new Class[0]);
        } catch (Throwable th) {
        }
        newAssetManager = (AssetManager) ShareReflectUtil.findConstructor(assets, new Class[0]).newInstance(new Object[0]);
        if (Build.VERSION.SDK_INT >= 19) {
            Class<?> cls3 = Class.forName("android.app.ResourcesManager");
            Object invoke = ShareReflectUtil.findMethod(cls3, "getInstance", (Class<?>[]) new Class[0]).invoke(null, new Object[0]);
            try {
                references = ((ArrayMap) ShareReflectUtil.findField(cls3, "mActiveResources").get(invoke)).values();
            } catch (NoSuchFieldException e3) {
                references = (Collection) ShareReflectUtil.findField(cls3, "mResourceReferences").get(invoke);
            }
        } else {
            references = ((HashMap) ShareReflectUtil.findField(cls2, "mActiveResources").get(currentActivityThread)).values();
        }
        if (references == null) {
            throw new IllegalStateException("resource references is null");
        }
        Resources resources = context.getResources();
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                resourcesImplFiled = ShareReflectUtil.findField(resources, "mResourcesImpl");
            } catch (Throwable th2) {
                assetsFiled = ShareReflectUtil.findField(resources, "mAssets");
            }
        } else {
            assetsFiled = ShareReflectUtil.findField(resources, "mAssets");
        }
        try {
            publicSourceDirField = ShareReflectUtil.findField((Class<?>) ApplicationInfo.class, "publicSourceDir");
        } catch (NoSuchFieldException e4) {
        }
    }

    public static void monkeyPatchExistingResources(Context context, String str) {
        if (str != null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            for (Field field : Build.VERSION.SDK_INT < 27 ? new Field[]{packagesFiled, resourcePackagesFiled} : new Field[]{packagesFiled}) {
                for (Map.Entry entry : ((Map) field.get(currentActivityThread)).entrySet()) {
                    Object obj = ((WeakReference) entry.getValue()).get();
                    if (obj != null) {
                        if (applicationInfo.sourceDir.equals((String) resDir.get(obj))) {
                            resDir.set(obj, str);
                        }
                    }
                }
            }
            if (((Integer) addAssetPathMethod.invoke(newAssetManager, str)).intValue() == 0) {
                throw new IllegalStateException("Could not create new AssetManager");
            }
            if (shouldAddSharedLibraryAssets(applicationInfo)) {
                String[] strArr = applicationInfo.sharedLibraryFiles;
                for (String str2 : strArr) {
                    if (str2.endsWith(".apk")) {
                        if (((Integer) addAssetPathAsSharedLibraryMethod.invoke(newAssetManager, str2)).intValue() == 0) {
                            throw new IllegalStateException("AssetManager add SharedLibrary Fail");
                        }
                    }
                }
            }
            if (!(stringBlocksField == null || ensureStringBlocksMethod == null)) {
                stringBlocksField.set(newAssetManager, null);
                ensureStringBlocksMethod.invoke(newAssetManager, new Object[0]);
            }
            for (WeakReference<Resources> weakReference : references) {
                Resources resources = weakReference.get();
                if (resources != null) {
                    try {
                        assetsFiled.set(resources, newAssetManager);
                    } catch (Throwable th) {
                        Object obj2 = resourcesImplFiled.get(resources);
                        ShareReflectUtil.findField(obj2, "mAssets").set(obj2, newAssetManager);
                    }
                    clearPreloadTypedArrayIssue(resources);
                    resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
                }
            }
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    if (publicSourceDirField != null) {
                        publicSourceDirField.set(context.getApplicationInfo(), str);
                    }
                } catch (Throwable th2) {
                }
            }
            if (!checkResUpdate(context)) {
                throw new TinkerRuntimeException(ShareConstants.CHECK_RES_INSTALL_FAIL);
            }
        }
    }

    private static void clearPreloadTypedArrayIssue(Resources resources) {
        ShareTinkerLog.w(TAG, "try to clear typedArray cache!", new Object[0]);
        try {
            Object obj = ShareReflectUtil.findField((Class<?>) Resources.class, "mTypedArrayPool").get(resources);
            do {
            } while (ShareReflectUtil.findMethod(obj, "acquire", new Class[0]).invoke(obj, new Object[0]) != null);
        } catch (Throwable th) {
            ShareTinkerLog.e(TAG, "clearPreloadTypedArrayIssue failed, ignore error: ".concat(String.valueOf(th)), new Object[0]);
        }
    }

    private static boolean checkResUpdate(Context context) {
        try {
            SharePatchFileUtil.closeQuietly(context.getAssets().open(TEST_ASSETS_VALUE));
            ShareTinkerLog.i(TAG, "checkResUpdate success, found test resource assets file only_use_to_test_tinker_resource.txt", new Object[0]);
            return true;
        } catch (Throwable th) {
            SharePatchFileUtil.closeQuietly(null);
            throw th;
        }
    }

    private static boolean shouldAddSharedLibraryAssets(ApplicationInfo applicationInfo) {
        return (Build.VERSION.SDK_INT < 24 || applicationInfo == null || applicationInfo.sharedLibraryFiles == null) ? false : true;
    }
}
