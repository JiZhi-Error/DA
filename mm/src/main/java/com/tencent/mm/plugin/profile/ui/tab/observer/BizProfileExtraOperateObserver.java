package com.tencent.mm.plugin.profile.ui.tab.observer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public class BizProfileExtraOperateObserver extends BaseBizProfileOperateObserver {
    private static String Bjc = "crashFlag";
    private static boolean Bjd = false;

    @Override // com.tencent.mm.plugin.profile.ui.tab.observer.IBizProfileOperateObserver, com.tencent.mm.plugin.profile.ui.tab.observer.BaseBizProfileOperateObserver
    public final boolean a(f fVar, as asVar) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(232008);
        if (asVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (Util.nullAsNil(asVar.field_username).length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (fVar != null) {
            z3 = true;
        }
        Assert.assertTrue(z3);
        AppMethodBeat.o(232008);
        return true;
    }
}
