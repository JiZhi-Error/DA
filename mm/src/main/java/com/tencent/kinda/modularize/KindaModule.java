package com.tencent.kinda.modularize;

import com.tencent.kinda.ConstructProxy;
import java.util.HashMap;

public abstract class KindaModule {
    private HashMap<String, Class> nativeModuleMap = new HashMap<>();
    private HashMap<String, Class> nativeViewMap = new HashMap<>();

    public abstract void configModule();

    public abstract void onAppCreate();

    /* access modifiers changed from: package-private */
    public void initModuleInner() {
        for (String str : this.nativeModuleMap.keySet()) {
            ConstructProxy.proxyDefaultConstructor(this.nativeModuleMap.get(str), str);
        }
        for (String str2 : this.nativeViewMap.keySet()) {
            ConstructProxy.proxyDefaultConstructor(this.nativeViewMap.get(str2), str2);
        }
    }

    /* access modifiers changed from: protected */
    public void registerView(String str, Class cls) {
        if (str != null && cls != null) {
            this.nativeViewMap.put(str, cls);
        }
    }

    /* access modifiers changed from: protected */
    public void registerNativeModule(String str, Class cls) {
        if (str != null && cls != null) {
            this.nativeModuleMap.put(str, cls);
        }
    }
}
