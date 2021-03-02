package com.tencent.kinda.modularize;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class KindaAppModuleManager {
    private List<KindaModule> moduleList = new ArrayList();

    public KindaAppModuleManager() {
        AppMethodBeat.i(136073);
        AppMethodBeat.o(136073);
    }

    public void registerModule(KindaModule kindaModule) {
        AppMethodBeat.i(136074);
        if (kindaModule != null) {
            this.moduleList.add(kindaModule);
        }
        AppMethodBeat.o(136074);
    }

    public void initAllModule() {
        AppMethodBeat.i(136075);
        for (KindaModule kindaModule : this.moduleList) {
            kindaModule.configModule();
            kindaModule.initModuleInner();
        }
        AppMethodBeat.o(136075);
    }

    public void onAppCreate() {
        AppMethodBeat.i(136076);
        for (KindaModule kindaModule : this.moduleList) {
            kindaModule.onAppCreate();
        }
        AppMethodBeat.o(136076);
    }
}
