package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.extension.ReflectionHelper;

public class MessageHandler {
    private String TAG = "MessageHandler";
    private Map<String, Handler> mHandlers = new HashMap();

    public class Handler {
        String javaName;
        ReflectionHelper reflection;
        Object targetObject;
        ReflectionHelper.MemberType type;

        public Handler(String str, ReflectionHelper.MemberType memberType, Object obj, ReflectionHelper reflectionHelper) {
            this.type = memberType;
            this.javaName = str;
            this.targetObject = obj;
            this.reflection = reflectionHelper;
        }

        public Handler(MessageHandler messageHandler, String str, ReflectionHelper.MemberType memberType, Object obj) {
            this(str, memberType, obj, null);
        }
    }

    public MessageHandler() {
        AppMethodBeat.i(155239);
        AppMethodBeat.o(155239);
    }

    public MessageHandler(MessageHandler messageHandler) {
        AppMethodBeat.i(155240);
        this.mHandlers.putAll(messageHandler.mHandlers);
        AppMethodBeat.o(155240);
    }

    public void register(String str, String str2, ReflectionHelper.MemberType memberType, Object obj, ReflectionHelper reflectionHelper) {
        AppMethodBeat.i(155241);
        if (this.mHandlers.containsKey(str)) {
            Log.w(this.TAG, "Existing handler for ".concat(String.valueOf(str)));
            AppMethodBeat.o(155241);
            return;
        }
        this.mHandlers.put(str, new Handler(str2, memberType, obj, reflectionHelper));
        AppMethodBeat.o(155241);
    }

    public void register(String str, String str2, ReflectionHelper.MemberType memberType, Object obj) {
        AppMethodBeat.i(155242);
        register(str, str2, memberType, obj, null);
        AppMethodBeat.o(155242);
    }

    public void register(String str, String str2, Object obj) {
        AppMethodBeat.i(155243);
        register(str, str2, ReflectionHelper.MemberType.JS_METHOD, obj, null);
        AppMethodBeat.o(155243);
    }

    public void register(String str, Object obj) {
        AppMethodBeat.i(155244);
        register(str, str, ReflectionHelper.MemberType.JS_METHOD, obj, null);
        AppMethodBeat.o(155244);
    }

    public Object handleMessage(MessageInfo messageInfo) {
        Object obj;
        AppMethodBeat.i(155245);
        String jsName = messageInfo.getJsName();
        Handler handler = this.mHandlers.get(jsName);
        if (handler == null || handler.targetObject == null) {
            Log.w(this.TAG, "Cannot find handler for method ".concat(String.valueOf(jsName)));
            AppMethodBeat.o(155245);
            return null;
        }
        Object obj2 = handler.targetObject;
        if (!messageInfo.getExtension().isAutoJS() || handler.reflection == null) {
            try {
                obj = obj2.getClass().getMethod(handler.javaName, MessageInfo.class).invoke(obj2, messageInfo);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
                Log.e(this.TAG, e2.toString());
                obj = null;
            }
        } else {
            try {
                obj = handler.reflection.handleMessage(messageInfo, obj2);
            } catch (Exception e3) {
                Log.e(this.TAG, e3.toString());
                obj = null;
            }
        }
        AppMethodBeat.o(155245);
        return obj;
    }
}
