package com.tencent.tinker.loader.hotplug.handler;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MHMessageHandler implements HandlerMessageInterceptor.MessageHandler {
    private static final int LAUNCH_ACTIVITY;
    private static final String TAG = "Tinker.MHMsgHndlr";
    private final Context mContext;

    static {
        int i2 = 100;
        if (Build.VERSION.SDK_INT < 27) {
            try {
                i2 = ShareReflectUtil.findField(Class.forName("android.app.ActivityThread$H"), "LAUNCH_ACTIVITY").getInt(null);
            } catch (Throwable th) {
            }
        }
        LAUNCH_ACTIVITY = i2;
    }

    public MHMessageHandler(Context context) {
        while ((context instanceof ContextWrapper) && (context = ((ContextWrapper) context).getBaseContext()) != null) {
        }
        this.mContext = context;
    }

    @Override // com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor.MessageHandler
    public boolean handleMessage(Message message) {
        if (message.what == LAUNCH_ACTIVITY) {
            try {
                Object obj = message.obj;
                if (obj == null) {
                    ShareTinkerLog.w(TAG, "msg: [" + message.what + "] has no 'obj' value.", new Object[0]);
                } else {
                    Intent intent = (Intent) ShareReflectUtil.findField(obj, "intent").get(obj);
                    if (intent == null) {
                        ShareTinkerLog.w(TAG, "cannot fetch intent from message received by mH.", new Object[0]);
                    } else {
                        ShareIntentUtil.fixIntentClassLoader(intent, this.mContext.getClassLoader());
                        ComponentName componentName = (ComponentName) intent.getParcelableExtra(EnvConsts.INTENT_EXTRA_OLD_COMPONENT);
                        if (componentName == null) {
                            ShareTinkerLog.w(TAG, "oldComponent was null, start " + intent.getComponent() + " next.", new Object[0]);
                        } else {
                            ActivityInfo activityInfo = (ActivityInfo) ShareReflectUtil.findField(obj, "activityInfo").get(obj);
                            if (activityInfo != null) {
                                ActivityInfo queryActivityInfo = IncrementComponentManager.queryActivityInfo(componentName.getClassName());
                                if (queryActivityInfo == null) {
                                    ShareTinkerLog.e(TAG, "Failed to query target activity's info, perhaps the target is not hotpluged component. Target: " + componentName.getClassName(), new Object[0]);
                                } else {
                                    fixActivityScreenOrientation(obj, queryActivityInfo.screenOrientation);
                                    fixStubActivityInfo(activityInfo, queryActivityInfo);
                                    intent.setComponent(componentName);
                                    intent.removeExtra(EnvConsts.INTENT_EXTRA_OLD_COMPONENT);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                ShareTinkerLog.e(TAG, "exception in handleMessage.", th);
            }
        }
        return false;
    }

    private void fixStubActivityInfo(ActivityInfo activityInfo, ActivityInfo activityInfo2) {
        copyInstanceFields(activityInfo2, activityInfo);
    }

    private <T> void copyInstanceFields(T t, T t2) {
        if (!(t == null || t2 == null)) {
            for (Class<?> cls = t.getClass(); !cls.equals(Object.class); cls = cls.getSuperclass()) {
                Field[] declaredFields = cls.getDeclaredFields();
                for (Field field : declaredFields) {
                    if (!field.isSynthetic() && !Modifier.isStatic(field.getModifiers())) {
                        if (!field.isAccessible()) {
                            field.setAccessible(true);
                        }
                        try {
                            field.set(t2, field.get(t));
                        } catch (Throwable th) {
                        }
                    }
                }
            }
        }
    }

    private void fixActivityScreenOrientation(Object obj, int i2) {
        if (i2 == -1) {
            i2 = 2;
        }
        try {
            Object obj2 = ShareReflectUtil.findField(obj, "token").get(obj);
            Object invoke = ShareReflectUtil.findMethod(Class.forName("android.app.ActivityManagerNative"), "getDefault", (Class<?>[]) new Class[0]).invoke(null, new Object[0]);
            ShareReflectUtil.findMethod(invoke, "setRequestedOrientation", IBinder.class, Integer.TYPE).invoke(invoke, obj2, Integer.valueOf(i2));
        } catch (Throwable th) {
            ShareTinkerLog.e(TAG, "Failed to fix screen orientation.", th);
        }
    }
}
