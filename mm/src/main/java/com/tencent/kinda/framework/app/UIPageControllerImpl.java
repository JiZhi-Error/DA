package com.tencent.kinda.framework.app;

import com.tencent.kinda.framework.widget.tools.ActivityController;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.IUIPage;
import com.tencent.kinda.gen.IUIPageController;
import com.tencent.kinda.gen.TransitionStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class UIPageControllerImpl implements IUIPageController {
    private static String TAG = "kinda UIPageControllerImpl";

    @Override // com.tencent.kinda.gen.IUIPageController
    public void startPageUI(IUIPage iUIPage, ITransmitKvData iTransmitKvData) {
        AppMethodBeat.i(18568);
        ActivityController.startNewUIPage(iUIPage, iTransmitKvData);
        AppMethodBeat.o(18568);
    }

    @Override // com.tencent.kinda.gen.IUIPageController
    public void startModalPageUI(IUIPage iUIPage, TransitionStyle transitionStyle, ITransmitKvData iTransmitKvData) {
        AppMethodBeat.i(18569);
        ActivityController.startNewUIPage(iUIPage, iTransmitKvData);
        AppMethodBeat.o(18569);
    }
}
