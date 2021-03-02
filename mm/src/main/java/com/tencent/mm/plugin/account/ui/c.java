package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.applet.SecurityImage;

public abstract class c extends SecurityImage.b {
    SecurityImage kdp = null;
    q kjU = null;

    public abstract q a(q qVar, String str);

    @Override // com.tencent.mm.ui.applet.SecurityImage.b
    public final void bnH() {
        g.azz().a(a(this.kjU, ""), 0);
    }
}
