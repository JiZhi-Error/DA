package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebStorage;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkCoreWrapper;

public final class j implements IWebStorage {
    @Override // com.tencent.xweb.internal.IWebStorage
    public final void deleteOrigin(String str) {
        AppMethodBeat.i(154295);
        Log.i("XWStorage", "delete origin ret is ".concat(String.valueOf(XWalkCoreWrapper.invokeRuntimeChannel(80006, new Object[]{str}))));
        AppMethodBeat.o(154295);
    }
}
