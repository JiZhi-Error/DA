package com.tencent.tinker.loader.hotplug.handler;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PMSInterceptHandler implements ServiceBinderInterceptor.BinderInvocationHandler {
    private static final String TAG = "Tinker.PMSIntrcptHndlr";

    @Override // com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.BinderInvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if ("getActivityInfo".equals(name)) {
            return handleGetActivityInfo(obj, method, objArr);
        }
        if ("resolveIntent".equals(name)) {
            return handleResolveIntent(obj, method, objArr);
        }
        return method.invoke(obj, objArr);
    }

    private Object handleGetActivityInfo(Object obj, Method method, Object[] objArr) {
        ComponentName componentName;
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        try {
            Object invoke = method.invoke(obj, objArr);
            if (invoke != null) {
                return invoke;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= objArr.length) {
                    componentName = null;
                    break;
                } else if (objArr[i2] instanceof ComponentName) {
                    ShareTinkerLog.i(TAG, "locate componentName field of " + method.getName() + " done at idx: " + i2, new Object[0]);
                    componentName = (ComponentName) objArr[i2];
                    break;
                } else {
                    i2++;
                }
            }
            if (componentName != null) {
                return IncrementComponentManager.queryActivityInfo(componentName.getClassName());
            }
            ShareTinkerLog.w(TAG, "failed to locate componentName field of " + method.getName() + ", notice any crashes or mistakes after resolve works.", new Object[0]);
            return null;
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (exceptionTypes == null || exceptionTypes.length <= 0) {
                Object[] objArr2 = new Object[1];
                if (targetException == null) {
                    targetException = e2;
                }
                objArr2[0] = targetException;
                ShareTinkerLog.e(TAG, "unexpected exception.", objArr2);
                return null;
            } else if (targetException != null) {
                throw targetException;
            } else {
                throw e2;
            }
        } catch (Throwable th) {
            ShareTinkerLog.e(TAG, "unexpected exception.", th);
            return null;
        }
    }

    private Object handleResolveIntent(Object obj, Method method, Object[] objArr) {
        Intent intent;
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        try {
            Object invoke = method.invoke(obj, objArr);
            if (invoke != null) {
                return invoke;
            }
            ShareTinkerLog.w(TAG, "failed to resolve activity in base package, try again in patch package.", new Object[0]);
            int i2 = 0;
            while (true) {
                if (i2 >= objArr.length) {
                    intent = null;
                    break;
                } else if (objArr[i2] instanceof Intent) {
                    ShareTinkerLog.i(TAG, "locate intent field of " + method.getName() + " done at idx: " + i2, new Object[0]);
                    intent = (Intent) objArr[i2];
                    break;
                } else {
                    i2++;
                }
            }
            if (intent != null) {
                return IncrementComponentManager.resolveIntent(intent);
            }
            ShareTinkerLog.w(TAG, "failed to locate intent field of " + method.getName() + ", notice any crashes or mistakes after resolve works.", new Object[0]);
            return null;
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (exceptionTypes == null || exceptionTypes.length <= 0) {
                Object[] objArr2 = new Object[1];
                if (targetException == null) {
                    targetException = e2;
                }
                objArr2[0] = targetException;
                ShareTinkerLog.e(TAG, "unexpected exception.", objArr2);
                return null;
            } else if (targetException != null) {
                throw targetException;
            } else {
                throw e2;
            }
        } catch (Throwable th) {
            ShareTinkerLog.e(TAG, "unexpected exception.", th);
            return null;
        }
    }
}
