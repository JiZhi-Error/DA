package com.tencent.tinker.loader.hotplug.interceptor;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.lang.reflect.Field;

public class TinkerHackInstrumentation extends Instrumentation {
    private static final String TAG = "Tinker.Instrumentation";
    private final Object mActivityThread;
    private final Field mInstrumentationField;
    private final Instrumentation mOriginal;

    public static TinkerHackInstrumentation create(Context context) {
        try {
            Object activityThread = ShareReflectUtil.getActivityThread(context, null);
            Field findField = ShareReflectUtil.findField(activityThread, "mInstrumentation");
            Instrumentation instrumentation = (Instrumentation) findField.get(activityThread);
            if (instrumentation instanceof TinkerHackInstrumentation) {
                return (TinkerHackInstrumentation) instrumentation;
            }
            return new TinkerHackInstrumentation(instrumentation, activityThread, findField);
        } catch (Throwable th) {
            throw new TinkerRuntimeException("see next stacktrace", th);
        }
    }

    public void install() {
        if (this.mInstrumentationField.get(this.mActivityThread) instanceof TinkerHackInstrumentation) {
            ShareTinkerLog.w(TAG, "already installed, skip rest logic.", new Object[0]);
        } else {
            this.mInstrumentationField.set(this.mActivityThread, this);
        }
    }

    public void uninstall() {
        this.mInstrumentationField.set(this.mActivityThread, this.mOriginal);
    }

    private TinkerHackInstrumentation(Instrumentation instrumentation, Object obj, Field field) {
        this.mOriginal = instrumentation;
        this.mActivityThread = obj;
        this.mInstrumentationField = field;
        try {
            copyAllFields(instrumentation);
        } catch (Throwable th) {
            throw new TinkerRuntimeException(th.getMessage(), th);
        }
    }

    @Override // android.app.Instrumentation
    public Activity newActivity(Class<?> cls, Context context, IBinder iBinder, Application application, Intent intent, ActivityInfo activityInfo, CharSequence charSequence, Activity activity, String str, Object obj) {
        processIntent(context.getClassLoader(), intent);
        return super.newActivity(cls, context, iBinder, application, intent, activityInfo, charSequence, activity, str, obj);
    }

    @Override // android.app.Instrumentation
    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) {
        if (processIntent(classLoader, intent)) {
            return super.newActivity(classLoader, intent.getComponent().getClassName(), intent);
        }
        return super.newActivity(classLoader, str, intent);
    }

    public void callActivityOnCreate(Activity activity, Bundle bundle) {
        ActivityInfo queryActivityInfo;
        if (!(activity == null || (queryActivityInfo = IncrementComponentManager.queryActivityInfo(activity.getClass().getName())) == null)) {
            fixActivityParams(activity, queryActivityInfo);
        }
        super.callActivityOnCreate(activity, bundle);
    }

    public void callActivityOnCreate(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        ActivityInfo queryActivityInfo;
        if (!(activity == null || (queryActivityInfo = IncrementComponentManager.queryActivityInfo(activity.getClass().getName())) == null)) {
            fixActivityParams(activity, queryActivityInfo);
        }
        super.callActivityOnCreate(activity, bundle, persistableBundle);
    }

    public void callActivityOnNewIntent(Activity activity, Intent intent) {
        if (activity != null) {
            processIntent(activity.getClass().getClassLoader(), intent);
        }
        super.callActivityOnNewIntent(activity, intent);
    }

    private boolean processIntent(ClassLoader classLoader, Intent intent) {
        if (intent == null) {
            return false;
        }
        ShareIntentUtil.fixIntentClassLoader(intent, classLoader);
        ComponentName componentName = (ComponentName) intent.getParcelableExtra(EnvConsts.INTENT_EXTRA_OLD_COMPONENT);
        if (componentName == null) {
            ShareTinkerLog.w(TAG, "oldComponent was null, start " + intent.getComponent() + " next.", new Object[0]);
            return false;
        }
        String className = componentName.getClassName();
        if (IncrementComponentManager.queryActivityInfo(className) == null) {
            ShareTinkerLog.e(TAG, "Failed to query target activity's info, perhaps the target is not hotpluged component. Target: ".concat(String.valueOf(className)), new Object[0]);
            return false;
        }
        intent.setComponent(componentName);
        intent.removeExtra(EnvConsts.INTENT_EXTRA_OLD_COMPONENT);
        return true;
    }

    private void fixActivityParams(Activity activity, ActivityInfo activityInfo) {
        activity.setRequestedOrientation(activityInfo.screenOrientation);
        activity.setTheme(activityInfo.theme);
        try {
            ShareReflectUtil.findField(activity, "mActivityInfo").set(activity, activityInfo);
        } catch (Throwable th) {
            throw new TinkerRuntimeException("see next stacktrace.", th);
        }
    }

    private void copyAllFields(Instrumentation instrumentation) {
        Field[] declaredFields = Instrumentation.class.getDeclaredFields();
        for (int i2 = 0; i2 < declaredFields.length; i2++) {
            declaredFields[i2].setAccessible(true);
            declaredFields[i2].set(this, declaredFields[i2].get(instrumentation));
        }
    }
}
