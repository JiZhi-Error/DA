package com.tencent.tinker.loader.hotplug.handler;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import com.tencent.tinker.loader.hotplug.ActivityStubManager;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Method;

public class AMSInterceptHandler implements ServiceBinderInterceptor.BinderInvocationHandler {
    private static final int INTENT_SENDER_ACTIVITY;
    private static final String TAG = "Tinker.AMSIntrcptHndlr";
    private static final int[] TRANSLUCENT_ATTR_ID = {16842840};
    private final Context mContext;

    static {
        int i2;
        if (Build.VERSION.SDK_INT < 27) {
            try {
                i2 = ((Integer) ShareReflectUtil.findField((Class<?>) ActivityManager.class, "INTENT_SENDER_ACTIVITY").get(null)).intValue();
            } catch (Throwable th) {
                i2 = 2;
            }
        } else {
            i2 = 2;
        }
        INTENT_SENDER_ACTIVITY = i2;
    }

    public AMSInterceptHandler(Context context) {
        while ((context instanceof ContextWrapper) && (context = ((ContextWrapper) context).getBaseContext()) != null) {
        }
        this.mContext = context;
    }

    @Override // com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.BinderInvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if ("startActivity".equals(name)) {
            return handleStartActivity(obj, method, objArr);
        }
        if ("startActivities".equals(name)) {
            return handleStartActivities(obj, method, objArr);
        }
        if ("startActivityAndWait".equals(name)) {
            return handleStartActivity(obj, method, objArr);
        }
        if ("startActivityWithConfig".equals(name)) {
            return handleStartActivity(obj, method, objArr);
        }
        if ("startActivityAsUser".equals(name)) {
            return handleStartActivity(obj, method, objArr);
        }
        if ("getIntentSender".equals(name)) {
            return handleGetIntentSender(obj, method, objArr);
        }
        return method.invoke(obj, objArr);
    }

    private Object handleStartActivity(Object obj, Method method, Object[] objArr) {
        int i2;
        int i3 = 0;
        while (true) {
            if (i3 >= objArr.length) {
                i2 = -1;
                break;
            } else if (objArr[i3] instanceof Intent) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            Intent intent = new Intent((Intent) objArr[i2]);
            processActivityIntent(intent);
            objArr[i2] = intent;
        }
        return method.invoke(obj, objArr);
    }

    private Object handleStartActivities(Object obj, Method method, Object[] objArr) {
        int i2 = 0;
        while (true) {
            if (i2 >= objArr.length) {
                i2 = -1;
                break;
            } else if (objArr[i2] instanceof Intent[]) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            Intent[] intentArr = (Intent[]) objArr[i2];
            for (int i3 = 0; i3 < intentArr.length; i3++) {
                Intent intent = new Intent(intentArr[i3]);
                processActivityIntent(intent);
                intentArr[i3] = intent;
            }
        }
        return method.invoke(obj, objArr);
    }

    private Object handleGetIntentSender(Object obj, Method method, Object[] objArr) {
        int i2;
        int i3 = 0;
        while (true) {
            if (i3 >= objArr.length) {
                i2 = -1;
                break;
            } else if (objArr[i3] instanceof Intent[]) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1 && ((Integer) objArr[0]).intValue() == INTENT_SENDER_ACTIVITY) {
            Intent[] intentArr = (Intent[]) objArr[i2];
            for (int i4 = 0; i4 < intentArr.length; i4++) {
                Intent intent = new Intent(intentArr[i4]);
                processActivityIntent(intent);
                intentArr[i4] = intent;
            }
        }
        return method.invoke(obj, objArr);
    }

    private void processActivityIntent(Intent intent) {
        String str;
        String str2;
        if (intent.getComponent() != null) {
            String packageName = intent.getComponent().getPackageName();
            str = intent.getComponent().getClassName();
            str2 = packageName;
        } else {
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity == null) {
                resolveActivity = IncrementComponentManager.resolveIntent(intent);
            }
            if (resolveActivity == null || resolveActivity.filter == null || !resolveActivity.filter.hasCategory("android.intent.category.DEFAULT")) {
                str = null;
                str2 = null;
            } else {
                String str3 = resolveActivity.activityInfo.packageName;
                str = resolveActivity.activityInfo.name;
                str2 = str3;
            }
        }
        if (IncrementComponentManager.isIncrementActivity(str)) {
            ActivityInfo queryActivityInfo = IncrementComponentManager.queryActivityInfo(str);
            storeAndReplaceOriginalComponentName(intent, str2, str, ActivityStubManager.assignStub(str, queryActivityInfo.launchMode, hasTransparentTheme(queryActivityInfo)));
        }
    }

    private void storeAndReplaceOriginalComponentName(Intent intent, String str, String str2, String str3) {
        ComponentName componentName = new ComponentName(str, str2);
        ShareIntentUtil.fixIntentClassLoader(intent, this.mContext.getClassLoader());
        intent.putExtra(EnvConsts.INTENT_EXTRA_OLD_COMPONENT, componentName);
        intent.setComponent(new ComponentName(str, str3));
    }

    private boolean hasTransparentTheme(ActivityInfo activityInfo) {
        boolean z = false;
        int themeResource = activityInfo.getThemeResource();
        Resources.Theme newTheme = this.mContext.getResources().newTheme();
        newTheme.applyStyle(themeResource, true);
        TypedArray typedArray = null;
        try {
            typedArray = newTheme.obtainStyledAttributes(TRANSLUCENT_ATTR_ID);
            z = typedArray.getBoolean(0, false);
            if (typedArray != null) {
                typedArray.recycle();
            }
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
        return z;
    }
}
