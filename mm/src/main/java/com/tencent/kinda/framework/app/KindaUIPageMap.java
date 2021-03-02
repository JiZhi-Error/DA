package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.IUIPage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class KindaUIPageMap {
    private static ConcurrentHashMap<String, Value> data = new ConcurrentHashMap<>();

    public static class Value {
        public IUIPage uiPage;
    }

    static {
        AppMethodBeat.i(18528);
        AppMethodBeat.o(18528);
    }

    public static String getUUID() {
        AppMethodBeat.i(18525);
        String uuid = UUID.randomUUID().toString();
        AppMethodBeat.o(18525);
        return uuid;
    }

    public static String put(IUIPage iUIPage) {
        AppMethodBeat.i(18526);
        String uuid = getUUID();
        Value value = new Value();
        value.uiPage = iUIPage;
        data.put(uuid, value);
        AppMethodBeat.o(18526);
        return uuid;
    }

    public static Value getAndRemove(String str) {
        AppMethodBeat.i(18527);
        Value value = null;
        if (data.containsKey(str)) {
            value = data.get(str);
            data.remove(str);
        }
        AppMethodBeat.o(18527);
        return value;
    }
}
