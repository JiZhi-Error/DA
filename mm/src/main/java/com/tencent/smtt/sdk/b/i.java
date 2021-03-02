package com.tencent.smtt.sdk.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebViewDB;
import com.tencent.smtt.sdk.TbsWizard;

public class i implements IX5CoreWebViewDB {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f1999a;

    i(DexLoader dexLoader) {
        this.f1999a = dexLoader;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebViewDB
    public void clearFormData(Context context) {
        AppMethodBeat.i(188536);
        this.f1999a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
        AppMethodBeat.o(188536);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebViewDB
    public boolean hasUsernamePassword(Context context) {
        AppMethodBeat.i(188537);
        Object invokeStaticMethod = this.f1999a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "webViewDatabaseHasUsernamePassword", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188537);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188537);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebViewDB
    public void clearUsernamePassword(Context context) {
        AppMethodBeat.i(188538);
        this.f1999a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
        AppMethodBeat.o(188538);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebViewDB
    public boolean hasHttpAuthUsernamePassword(Context context) {
        AppMethodBeat.i(188539);
        Object invokeStaticMethod = this.f1999a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "webViewDatabaseHasHttpAuthUsernamePassword", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188539);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188539);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebViewDB
    public void clearHttpAuthUsernamePassword(Context context) {
        AppMethodBeat.i(188540);
        this.f1999a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
        AppMethodBeat.o(188540);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreWebViewDB
    public boolean hasFormData(Context context) {
        AppMethodBeat.i(188541);
        Object invokeStaticMethod = this.f1999a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "webViewDatabaseHasFormData", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188541);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188541);
        return booleanValue;
    }
}
