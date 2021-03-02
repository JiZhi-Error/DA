package com.tencent.smtt.sdk.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsWizard;

public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f1995a;

    public e(DexLoader dexLoader) {
        this.f1995a = dexLoader;
    }

    @Override // com.tencent.smtt.sdk.b.d
    public boolean a(Context context, String str) {
        AppMethodBeat.i(188491);
        Object invokeStaticMethod = this.f1995a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "canOpenFile", new Class[]{Context.class, String.class}, context, str);
        if (invokeStaticMethod instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
            AppMethodBeat.o(188491);
            return booleanValue;
        }
        AppMethodBeat.o(188491);
        return false;
    }

    @Override // com.tencent.smtt.sdk.b.d
    public void a() {
        AppMethodBeat.i(188492);
        this.f1995a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "closeFileReader", new Class[0], new Object[0]);
        AppMethodBeat.o(188492);
    }
}
