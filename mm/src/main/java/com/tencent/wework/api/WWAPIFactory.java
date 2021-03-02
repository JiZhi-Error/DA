package com.tencent.wework.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWAPIFactory {
    public static IWWAPI ly(Context context) {
        AppMethodBeat.i(106526);
        if (TextUtils.equals(context.getPackageName(), "com.tencent.mm")) {
            WWAPIImplLocal wWAPIImplLocal = new WWAPIImplLocal(context);
            AppMethodBeat.o(106526);
            return wWAPIImplLocal;
        }
        WWAPIImpl wWAPIImpl = new WWAPIImpl(context);
        AppMethodBeat.o(106526);
        return wWAPIImpl;
    }
}
