package com.tencent.tinker.loader.hotplug.interceptor;

import android.os.Handler;
import android.os.Message;
import com.tencent.tinker.loader.hotplug.interceptor.Interceptor;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;

public class HandlerMessageInterceptor extends Interceptor<Handler.Callback> {
    private static Field sMCallbackField;
    private final MessageHandler mMessageHandler;
    private final Handler mTarget;

    public interface MessageHandler {
        boolean handleMessage(Message message);
    }

    static {
        sMCallbackField = null;
        synchronized (HandlerMessageInterceptor.class) {
            if (sMCallbackField == null) {
                try {
                    sMCallbackField = ShareReflectUtil.findField((Class<?>) Handler.class, "mCallback");
                } catch (Throwable th) {
                }
            }
        }
    }

    public HandlerMessageInterceptor(Handler handler, MessageHandler messageHandler) {
        this.mTarget = handler;
        this.mMessageHandler = messageHandler;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.loader.hotplug.interceptor.Interceptor
    public Handler.Callback fetchTarget() {
        return (Handler.Callback) sMCallbackField.get(this.mTarget);
    }

    /* access modifiers changed from: protected */
    public Handler.Callback decorate(Handler.Callback callback) {
        return (callback == null || !Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(callback.getClass())) ? new CallbackWrapper(this.mMessageHandler, callback) : callback;
    }

    /* access modifiers changed from: protected */
    public void inject(Handler.Callback callback) {
        sMCallbackField.set(this.mTarget, callback);
    }

    /* access modifiers changed from: package-private */
    public static class CallbackWrapper implements Handler.Callback, Interceptor.ITinkerHotplugProxy {
        private volatile boolean mIsInHandleMethod = false;
        private final MessageHandler mMessageHandler;
        private final Handler.Callback mOrigCallback;

        CallbackWrapper(MessageHandler messageHandler, Handler.Callback callback) {
            this.mMessageHandler = messageHandler;
            this.mOrigCallback = callback;
        }

        public boolean handleMessage(Message message) {
            boolean z = true;
            if (this.mIsInHandleMethod) {
                return false;
            }
            this.mIsInHandleMethod = true;
            if (!this.mMessageHandler.handleMessage(message)) {
                z = this.mOrigCallback != null ? this.mOrigCallback.handleMessage(message) : false;
            }
            this.mIsInHandleMethod = false;
            return z;
        }
    }
}
