package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.framework.widget.tools.ActivityController;
import com.tencent.kinda.gen.IUIModal;
import com.tencent.kinda.gen.IUIPagePlatformDelegate;
import com.tencent.kinda.gen.KindaModalManager;
import com.tencent.kinda.gen.Platform;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class KindaModalManagerImpl implements KindaModalManager {
    public static final String TAG = "MicroMsg.KindaModalManagerImpl";

    @Override // com.tencent.kinda.gen.KindaModalManager
    public void addModalView(IUIModal iUIModal) {
        AppMethodBeat.i(18642);
        Log.i(TAG, "kinda call addModalView, modal: ".concat(String.valueOf(iUIModal)));
        ActivityController.startNewUIModal(iUIModal);
        AppMethodBeat.o(18642);
    }

    @Override // com.tencent.kinda.gen.KindaModalManager
    public void removeModalView(IUIModal iUIModal) {
        AppMethodBeat.i(18643);
        Log.i(TAG, "kinda call reremoveModalView, modal: ".concat(String.valueOf(iUIModal)));
        ActivityController.remove(iUIModal);
        AppMethodBeat.o(18643);
    }

    @Override // com.tencent.kinda.gen.KindaModalManager
    public void removeAllModalViews() {
        AppMethodBeat.i(185697);
        ActivityController.removeAll();
        AppMethodBeat.o(185697);
    }

    public IUIPagePlatformDelegate getPlatformDelegate() {
        AppMethodBeat.i(18644);
        AnonymousClass1 r0 = new IUIPagePlatformDelegate() {
            /* class com.tencent.kinda.framework.module.impl.KindaModalManagerImpl.AnonymousClass1 */

            @Override // com.tencent.kinda.gen.IUIPagePlatformDelegate
            public Platform currentPlatform() {
                return Platform.ANDROID;
            }
        };
        AppMethodBeat.o(18644);
        return r0;
    }
}
