package com.tencent.qqvideo.proxy.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqvideo.proxy.common.PlayManagerImp;

public class FactoryProxyManager {
    private static IPlayManager playManager = null;

    public static synchronized IPlayManager getPlayManager() {
        IPlayManager iPlayManager;
        synchronized (FactoryProxyManager.class) {
            AppMethodBeat.i(89664);
            if (playManager == null) {
                playManager = new PlayManagerImp();
            }
            iPlayManager = playManager;
            AppMethodBeat.o(89664);
        }
        return iPlayManager;
    }
}
