package com.tencent.kinda.framework.boot;

import com.tencent.kinda.framework.WxCrossServices;
import com.tencent.kinda.framework.module.base.KindaBaseServiceModule;
import com.tencent.kinda.framework.module.base.KindaBaseViewModule;
import com.tencent.kinda.framework.module.pay.KindaPayServiceModule;
import com.tencent.kinda.gen.IAppKinda;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.modularize.KindaAppModuleManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class KindaApp {
    private static final String TAG = "MicroMsg.Kinda.KindaApp";
    private static KindaApp instance = new KindaApp();
    private KindaAppModuleManager appModuleManager = new KindaAppModuleManager();
    private IAppKinda kinda;
    private MMHandlerThread threadHandler;

    static {
        AppMethodBeat.i(18617);
        tryLoadLibrary();
        AppMethodBeat.o(18617);
    }

    public static boolean isEnabled() {
        AppMethodBeat.i(18609);
        boolean cMr = a.cMr();
        AppMethodBeat.o(18609);
        return cMr;
    }

    private static void tryLoadLibrary() {
        AppMethodBeat.i(18610);
        if (isEnabled()) {
            WxCrossServices.tryLoadLibrary();
        }
        AppMethodBeat.o(18610);
    }

    public static KindaApp instance() {
        return instance;
    }

    public static IAppKinda appKinda() {
        AppMethodBeat.i(18611);
        IAppKinda iAppKinda = instance().kinda;
        AppMethodBeat.o(18611);
        return iAppKinda;
    }

    public KindaApp() {
        AppMethodBeat.i(18612);
        Log.i(TAG, "create kinda app");
        h.INSTANCE.dN(782, 30);
        this.appModuleManager.registerModule(new KindaBaseViewModule());
        this.appModuleManager.registerModule(new KindaBaseServiceModule());
        this.appModuleManager.registerModule(new KindaPayServiceModule());
        this.appModuleManager.initAllModule();
        this.kinda = IAppKinda.getInstance();
        AppMethodBeat.o(18612);
    }

    public void reInitModule() {
        AppMethodBeat.i(214439);
        if (this.appModuleManager != null) {
            this.appModuleManager.initAllModule();
            this.kinda = IAppKinda.getInstance();
        }
        AppMethodBeat.o(214439);
    }

    public void releaseAppKinda() {
        this.kinda = null;
    }

    public void onCreate() {
        AppMethodBeat.i(18613);
        tryLoadLibrary();
        this.appModuleManager.onAppCreate();
        AppMethodBeat.o(18613);
    }

    public void onForeground() {
        AppMethodBeat.i(18614);
        Log.i(TAG, "onForeground");
        this.kinda.applicationEnterForeground();
        AppMethodBeat.o(18614);
    }

    public void onBackground() {
        AppMethodBeat.i(18615);
        Log.i(TAG, "onBackground");
        this.kinda.applicationEnterBackground();
        AppMethodBeat.o(18615);
    }

    public void notifyAllUseCases(ITransmitKvData iTransmitKvData) {
        AppMethodBeat.i(18616);
        Log.i(TAG, "notifyAllUseCases");
        this.kinda.notifyAllUseCases(iTransmitKvData);
        AppMethodBeat.o(18616);
    }
}
