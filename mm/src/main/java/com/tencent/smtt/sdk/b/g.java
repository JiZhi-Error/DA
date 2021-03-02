package com.tencent.smtt.sdk.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebIconDB;
import com.tencent.smtt.export.external.interfaces.IconListener;
import com.tencent.smtt.sdk.TbsWizard;

public class g implements IX5CoreWebIconDB {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f1997a;

    g(DexLoader dexLoader) {
        this.f1997a = dexLoader;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebIconDB
    public void open(String str) {
        AppMethodBeat.i(188529);
        this.f1997a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "openIconDB", new Class[]{String.class}, str);
        AppMethodBeat.o(188529);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebIconDB
    public void close() {
        AppMethodBeat.i(188530);
        this.f1997a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "closeIconDB", null, new Object[0]);
        AppMethodBeat.o(188530);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebIconDB
    public void removeAllIcons() {
        AppMethodBeat.i(188531);
        this.f1997a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "removeAllIcons", null, new Object[0]);
        AppMethodBeat.o(188531);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebIconDB
    public void requestIconForPageUrl(String str, IconListener iconListener) {
        AppMethodBeat.i(188532);
        this.f1997a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "requestIconForPageUrl", new Class[]{String.class, IconListener.class}, str, iconListener);
        AppMethodBeat.o(188532);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebIconDB
    public void retainIconForPageUrl(String str) {
        AppMethodBeat.i(188533);
        this.f1997a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "retainIconForPageUrl", new Class[]{String.class}, str);
        AppMethodBeat.o(188533);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebIconDB
    public void releaseIconForPageUrl(String str) {
        AppMethodBeat.i(188534);
        this.f1997a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "releaseIconForPageUrl", new Class[]{String.class}, str);
        AppMethodBeat.o(188534);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebIconDB
    public Bitmap getIconForPageUrl(String str) {
        AppMethodBeat.i(188535);
        Object invokeStaticMethod = this.f1997a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "getIconForPageUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188535);
            return null;
        }
        Bitmap bitmap = (Bitmap) invokeStaticMethod;
        AppMethodBeat.o(188535);
        return bitmap;
    }
}
