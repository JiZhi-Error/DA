package com.tencent.tinker.loader.hotplug;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.handler.AMSInterceptHandler;
import com.tencent.tinker.loader.hotplug.handler.MHMessageHandler;
import com.tencent.tinker.loader.hotplug.handler.PMSInterceptHandler;
import com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor;
import com.tencent.tinker.loader.hotplug.interceptor.TinkerHackInstrumentation;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;

public final class ComponentHotplug {
    private static final String TAG = "Tinker.ComponentHotplug";
    private static ServiceBinderInterceptor sAMSInterceptor;
    private static volatile boolean sInstalled = false;
    private static HandlerMessageInterceptor sMHMessageInterceptor;
    private static ServiceBinderInterceptor sPMSInterceptor;
    private static TinkerHackInstrumentation sTinkerHackInstrumentation;

    public static synchronized void install(TinkerApplication tinkerApplication, ShareSecurityCheck shareSecurityCheck) {
        synchronized (ComponentHotplug.class) {
            if (!sInstalled) {
                try {
                    if (IncrementComponentManager.init(tinkerApplication, shareSecurityCheck)) {
                        sAMSInterceptor = new ServiceBinderInterceptor(tinkerApplication, EnvConsts.ACTIVITY_MANAGER_SRVNAME, new AMSInterceptHandler(tinkerApplication));
                        sPMSInterceptor = new ServiceBinderInterceptor(tinkerApplication, "package", new PMSInterceptHandler());
                        sAMSInterceptor.install();
                        sPMSInterceptor.install();
                        if (Build.VERSION.SDK_INT < 27) {
                            HandlerMessageInterceptor handlerMessageInterceptor = new HandlerMessageInterceptor(fetchMHInstance(tinkerApplication), new MHMessageHandler(tinkerApplication));
                            sMHMessageInterceptor = handlerMessageInterceptor;
                            handlerMessageInterceptor.install();
                        } else {
                            TinkerHackInstrumentation create = TinkerHackInstrumentation.create(tinkerApplication);
                            sTinkerHackInstrumentation = create;
                            create.install();
                        }
                        sInstalled = true;
                        ShareTinkerLog.i(TAG, "installed successfully.", new Object[0]);
                    }
                } catch (Throwable th) {
                    uninstall();
                    throw new UnsupportedEnvironmentException(th);
                }
            }
        }
    }

    public static synchronized void ensureComponentHotplugInstalled(TinkerApplication tinkerApplication) {
        synchronized (ComponentHotplug.class) {
            if (sInstalled) {
                try {
                    sAMSInterceptor.install();
                    sPMSInterceptor.install();
                    if (Build.VERSION.SDK_INT < 27) {
                        sMHMessageInterceptor.install();
                    } else {
                        sTinkerHackInstrumentation.install();
                    }
                } catch (Throwable th) {
                    uninstall();
                    throw new UnsupportedEnvironmentException(th);
                }
            } else {
                ShareTinkerLog.i(TAG, "method install() is not invoked, ignore ensuring operations.", new Object[0]);
            }
        }
    }

    private static Handler fetchMHInstance(Context context) {
        Object activityThread = ShareReflectUtil.getActivityThread(context, null);
        if (activityThread == null) {
            throw new IllegalStateException("failed to fetch instance of ActivityThread.");
        }
        try {
            return (Handler) ShareReflectUtil.findField(activityThread, "mH").get(activityThread);
        } catch (Throwable th) {
            throw new IllegalStateException(th);
        }
    }

    public static synchronized void uninstall() {
        synchronized (ComponentHotplug.class) {
            if (sInstalled) {
                try {
                    sAMSInterceptor.uninstall();
                    sPMSInterceptor.uninstall();
                    if (Build.VERSION.SDK_INT < 27) {
                        sMHMessageInterceptor.uninstall();
                    } else {
                        sTinkerHackInstrumentation.uninstall();
                    }
                } catch (Throwable th) {
                    ShareTinkerLog.e(TAG, "exception when uninstall.", th);
                }
                sInstalled = false;
            }
        }
    }

    private ComponentHotplug() {
        throw new UnsupportedOperationException();
    }
}
