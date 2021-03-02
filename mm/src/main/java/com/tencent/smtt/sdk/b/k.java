package com.tencent.smtt.sdk.b;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreGeolocationPermissions;
import com.tencent.smtt.sdk.TbsWizard;
import java.util.Set;

public class k implements IX5CoreGeolocationPermissions {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f2001a;

    k(DexLoader dexLoader) {
        this.f2001a = dexLoader;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreGeolocationPermissions
    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        AppMethodBeat.i(188455);
        this.f2001a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "geolocationPermissionsGetOrigins", new Class[]{ValueCallback.class}, valueCallback);
        AppMethodBeat.o(188455);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreGeolocationPermissions
    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(188456);
        this.f2001a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "geolocationPermissionsGetAllowed", new Class[]{String.class, ValueCallback.class}, str, valueCallback);
        AppMethodBeat.o(188456);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreGeolocationPermissions
    public void clear(String str) {
        AppMethodBeat.i(188457);
        this.f2001a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "geolocationPermissionsClear", new Class[]{String.class}, str);
        AppMethodBeat.o(188457);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreGeolocationPermissions
    public void allow(String str) {
        AppMethodBeat.i(188458);
        this.f2001a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "geolocationPermissionsAllow", new Class[]{String.class}, str);
        AppMethodBeat.o(188458);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreGeolocationPermissions
    public void clearAll() {
        AppMethodBeat.i(188459);
        this.f2001a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "geolocationPermissionsClearAll", null, new Object[0]);
        AppMethodBeat.o(188459);
    }
}
