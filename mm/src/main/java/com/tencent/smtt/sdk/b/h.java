package com.tencent.smtt.sdk.b;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebStorage;
import com.tencent.smtt.sdk.TbsWizard;
import java.util.Map;

public class h implements IX5CoreWebStorage {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f1998a;

    h(DexLoader dexLoader) {
        this.f1998a = dexLoader;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebStorage
    public void getOrigins(ValueCallback<Map> valueCallback) {
        AppMethodBeat.i(188542);
        this.f1998a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "webStorageGetOrigins", new Class[]{ValueCallback.class}, valueCallback);
        AppMethodBeat.o(188542);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebStorage
    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        AppMethodBeat.i(188543);
        this.f1998a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "webStorageGetUsageForOrigin", new Class[]{String.class, ValueCallback.class}, str, valueCallback);
        AppMethodBeat.o(188543);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebStorage
    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        AppMethodBeat.i(188544);
        this.f1998a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "webStorageGetQuotaForOrigin", new Class[]{String.class, ValueCallback.class}, str, valueCallback);
        AppMethodBeat.o(188544);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebStorage
    public void setQuotaForOrigin(String str, long j2) {
        AppMethodBeat.i(188545);
        this.f1998a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "webStorageSetQuotaForOrigin", new Class[]{String.class, Long.TYPE}, str, Long.valueOf(j2));
        AppMethodBeat.o(188545);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebStorage
    public void deleteOrigin(String str) {
        AppMethodBeat.i(188546);
        this.f1998a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "webStorageDeleteOrigin", new Class[]{String.class}, str);
        AppMethodBeat.o(188546);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebStorage
    public void deleteAllData() {
        AppMethodBeat.i(188547);
        this.f1998a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "webStorageDeleteAllData", null, new Object[0]);
        AppMethodBeat.o(188547);
    }
}
