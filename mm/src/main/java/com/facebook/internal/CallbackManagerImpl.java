package com.facebook.internal;

import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class CallbackManagerImpl implements CallbackManager {
    private static final String INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
    private static final String TAG = CallbackManagerImpl.class.getSimpleName();
    private static Map<Integer, Callback> staticCallbacks = new HashMap();
    private Map<Integer, Callback> callbacks = new HashMap();

    public interface Callback {
        boolean onActivityResult(int i2, Intent intent);
    }

    public CallbackManagerImpl() {
        AppMethodBeat.i(17707);
        AppMethodBeat.o(17707);
    }

    static {
        AppMethodBeat.i(17714);
        AppMethodBeat.o(17714);
    }

    public static synchronized void registerStaticCallback(int i2, Callback callback) {
        synchronized (CallbackManagerImpl.class) {
            AppMethodBeat.i(17708);
            Validate.notNull(callback, "callback");
            if (staticCallbacks.containsKey(Integer.valueOf(i2))) {
                AppMethodBeat.o(17708);
            } else {
                staticCallbacks.put(Integer.valueOf(i2), callback);
                AppMethodBeat.o(17708);
            }
        }
    }

    private static synchronized Callback getStaticCallback(Integer num) {
        Callback callback;
        synchronized (CallbackManagerImpl.class) {
            AppMethodBeat.i(17709);
            callback = staticCallbacks.get(num);
            AppMethodBeat.o(17709);
        }
        return callback;
    }

    private static boolean runStaticCallback(int i2, int i3, Intent intent) {
        AppMethodBeat.i(17710);
        Callback staticCallback = getStaticCallback(Integer.valueOf(i2));
        if (staticCallback != null) {
            boolean onActivityResult = staticCallback.onActivityResult(i3, intent);
            AppMethodBeat.o(17710);
            return onActivityResult;
        }
        AppMethodBeat.o(17710);
        return false;
    }

    public final void registerCallback(int i2, Callback callback) {
        AppMethodBeat.i(17711);
        Validate.notNull(callback, "callback");
        this.callbacks.put(Integer.valueOf(i2), callback);
        AppMethodBeat.o(17711);
    }

    public final void unregisterCallback(int i2) {
        AppMethodBeat.i(17712);
        this.callbacks.remove(Integer.valueOf(i2));
        AppMethodBeat.o(17712);
    }

    @Override // com.facebook.CallbackManager
    public final boolean onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(17713);
        Callback callback = this.callbacks.get(Integer.valueOf(i2));
        if (callback != null) {
            boolean onActivityResult = callback.onActivityResult(i3, intent);
            AppMethodBeat.o(17713);
            return onActivityResult;
        }
        boolean runStaticCallback = runStaticCallback(i2, i3, intent);
        AppMethodBeat.o(17713);
        return runStaticCallback;
    }

    public enum RequestCodeOffset {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8);
        
        private final int offset;

        public static RequestCodeOffset valueOf(String str) {
            AppMethodBeat.i(17704);
            RequestCodeOffset requestCodeOffset = (RequestCodeOffset) Enum.valueOf(RequestCodeOffset.class, str);
            AppMethodBeat.o(17704);
            return requestCodeOffset;
        }

        static {
            AppMethodBeat.i(17706);
            AppMethodBeat.o(17706);
        }

        private RequestCodeOffset(int i2) {
            this.offset = i2;
        }

        public final int toRequestCode() {
            AppMethodBeat.i(17705);
            int callbackRequestCodeOffset = FacebookSdk.getCallbackRequestCodeOffset() + this.offset;
            AppMethodBeat.o(17705);
            return callbackRequestCodeOffset;
        }
    }
}
