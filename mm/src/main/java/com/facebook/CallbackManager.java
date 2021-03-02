package com.facebook;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface CallbackManager {
    boolean onActivityResult(int i2, int i3, Intent intent);

    public static class Factory {
        public static CallbackManager create() {
            AppMethodBeat.i(17008);
            CallbackManagerImpl callbackManagerImpl = new CallbackManagerImpl();
            AppMethodBeat.o(17008);
            return callbackManagerImpl;
        }
    }
}
