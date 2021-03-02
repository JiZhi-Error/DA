package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.pluginsdk.ui.c.a;

public final class bg implements a {
    public boolean EHG = false;
    public boolean EHH = false;
    public String dJX;
    public String dRS;
    public int scene;
    public String userName;

    public bg(String str, String str2, boolean z, boolean z2, int i2) {
        this.dRS = str;
        this.EHG = z;
        this.EHH = z2;
        this.scene = i2;
        this.dJX = str2;
    }

    public final boolean fiA() {
        int i2 = 2;
        AppMethodBeat.i(98984);
        if (this.scene != 1) {
            if (this.scene == 2) {
                i2 = 4;
            } else {
                i2 = -1;
            }
        }
        au.b aPp = au.aPp(this.dRS);
        if (aPp == null || !aPp.iGD || aPp.aGI || (i2 & aPp.showFlag) == 0) {
            AppMethodBeat.o(98984);
            return false;
        }
        AppMethodBeat.o(98984);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.c.a
    public final String getUserName() {
        return this.userName;
    }
}
