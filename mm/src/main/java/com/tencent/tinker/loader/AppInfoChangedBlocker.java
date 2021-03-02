package com.tencent.tinker.loader;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.lang.reflect.Field;

public final class AppInfoChangedBlocker {
    private static final String TAG = "Tinker.AppInfoChangedBlocker";

    public static boolean tryStart(Application application) {
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        try {
            ShareTinkerLog.i(TAG, "tryStart called.", new Object[0]);
            interceptHandler(fetchMHObject(application));
            ShareTinkerLog.i(TAG, "tryStart done.", new Object[0]);
            return true;
        } catch (Throwable th) {
            ShareTinkerLog.e(TAG, "AppInfoChangedBlocker start failed, simply ignore.", th);
            return false;
        }
    }

    private static Handler fetchMHObject(Context context) {
        Object activityThread = ShareReflectUtil.getActivityThread(context, null);
        return (Handler) ShareReflectUtil.findField(activityThread, "mH").get(activityThread);
    }

    private static void interceptHandler(Handler handler) {
        Field findField = ShareReflectUtil.findField((Class<?>) Handler.class, "mCallback");
        Handler.Callback callback = (Handler.Callback) findField.get(handler);
        if (!(callback instanceof HackerCallback)) {
            findField.set(handler, new HackerCallback(callback, handler.getClass()));
        } else {
            ShareTinkerLog.w(TAG, "Already intercepted, skip rest logic.", new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public static class HackerCallback implements Handler.Callback {
        private final int APPLICATION_INFO_CHANGED;
        private Handler.Callback origin;

        HackerCallback(Handler.Callback callback, Class cls) {
            int i2;
            this.origin = callback;
            try {
                i2 = ShareReflectUtil.findField((Class<?>) cls, "APPLICATION_INFO_CHANGED").getInt(null);
            } catch (Throwable th) {
                i2 = 156;
            }
            this.APPLICATION_INFO_CHANGED = i2;
        }

        public boolean handleMessage(Message message) {
            if (hackMessage(message)) {
                return true;
            }
            if (this.origin != null) {
                return this.origin.handleMessage(message);
            }
            return false;
        }

        private boolean hackMessage(Message message) {
            ShareTinkerLog.i(AppInfoChangedBlocker.TAG, "hackmsg: " + message.what, new Object[0]);
            if (message.what != this.APPLICATION_INFO_CHANGED) {
                return false;
            }
            ShareTinkerLog.w(AppInfoChangedBlocker.TAG, "Suicide now.", new Object[0]);
            Process.killProcess(Process.myPid());
            return true;
        }
    }
}
