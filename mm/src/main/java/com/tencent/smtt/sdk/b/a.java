package com.tencent.smtt.sdk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreCacheManager;
import com.tencent.smtt.sdk.TbsWizard;
import java.io.File;
import java.io.InputStream;

public class a implements IX5CoreCacheManager {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f1989a;

    a(DexLoader dexLoader) {
        this.f1989a = dexLoader;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCacheManager
    public boolean cacheDisabled() {
        AppMethodBeat.i(188460);
        boolean booleanValue = ((Boolean) this.f1989a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cacheDisabled", new Class[0], new Object[0])).booleanValue();
        AppMethodBeat.o(188460);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCacheManager
    public File getCacheFileBaseDir() {
        AppMethodBeat.i(188461);
        File file = (File) this.f1989a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "getCachFileBaseDir", new Class[0], new Object[0]);
        AppMethodBeat.o(188461);
        return file;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCacheManager
    public void clearNetworkCache() {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCacheManager
    public void clearLocalStorage() {
        AppMethodBeat.i(188462);
        this.f1989a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "clearLocalStorage", null, new Object[0]);
        AppMethodBeat.o(188462);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCacheManager
    public InputStream getCacheFile(String str, boolean z) {
        AppMethodBeat.i(188463);
        Object invokeStaticMethod = this.f1989a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "getCacheFile", new Class[]{String.class, Boolean.TYPE}, str, Boolean.valueOf(z));
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188463);
            return null;
        }
        InputStream inputStream = (InputStream) invokeStaticMethod;
        AppMethodBeat.o(188463);
        return inputStream;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCacheManager
    public String getLocalPath(String str) {
        return null;
    }
}
