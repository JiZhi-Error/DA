package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Color;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;
import java.util.List;

public class u implements i.b, i.c {
    ac cwK;
    private e kHi;
    private List<t> kHj;
    private String mAppId;
    private View noT;

    public u(ac acVar, List<t> list) {
        this(acVar, list, true);
        AppMethodBeat.i(135013);
        AppMethodBeat.o(135013);
    }

    public u(ac acVar, List<t> list, boolean z) {
        AppMethodBeat.i(176563);
        this.noT = null;
        this.mAppId = acVar.getAppId();
        this.cwK = acVar;
        this.kHj = list;
        this.kHi = new e(acVar.getContext(), false, z ? 0 : 1);
        c windowAndroid = acVar.getRuntime().getWindowAndroid();
        Log.i("MicroMsg.AppBrandPageActionSheet", "AppBrandPageActionSheet: width [%d]", Integer.valueOf(windowAndroid.getVDisplayMetrics().widthPixels));
        if (windowAndroid.OD()) {
            this.kHi.mLQ = (int) (windowAndroid.getScale() * ((float) windowAndroid.getVDisplayMetrics().widthPixels));
        }
        View bRy = this.cwK.bRy();
        if (bRy != null) {
            this.kHi.V(bRy, true);
            this.noT = bRy;
        }
        View bRz = this.cwK.bRz();
        if (bRz != null) {
            this.kHi.setFooterView(bRz);
        }
        this.kHi.HLX = new o.f() {
            /* class com.tencent.mm.plugin.appbrand.page.u.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(135008);
                u.a(u.this, mVar, true);
                AppMethodBeat.o(135008);
            }
        };
        this.kHi.HLY = new o.g() {
            /* class com.tencent.mm.plugin.appbrand.page.u.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(135009);
                u.a(u.this, menuItem);
                AppMethodBeat.o(135009);
            }
        };
        this.kHi.QNH = new o.f() {
            /* class com.tencent.mm.plugin.appbrand.page.u.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(135010);
                u.a(u.this, mVar, false);
                AppMethodBeat.o(135010);
            }
        };
        this.kHi.QNK = new o.g() {
            /* class com.tencent.mm.plugin.appbrand.page.u.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(135011);
                u.a(u.this, menuItem);
                AppMethodBeat.o(135011);
            }
        };
        if (e.a.BLACK == this.cwK.nqR) {
            this.kHi.setBackgroundColor(Color.parseColor("#000000"));
        }
        AppMethodBeat.o(176563);
    }

    public final boolean btY() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(135014);
        try {
            com.tencent.mm.ui.widget.a.e eVar = this.kHi;
            if (this.cwK.btO() || this.cwK.isFullScreen()) {
                z = true;
            } else {
                z = false;
            }
            eVar.mLN = z;
            com.tencent.mm.ui.widget.a.e eVar2 = this.kHi;
            if (this.cwK.btO() || this.cwK.isFullScreen()) {
                z2 = true;
            } else {
                z2 = false;
            }
            eVar2.mLO = z2;
            a(this.kHi);
            this.kHi.dGm();
            this.cwK.a((i.b) this);
            this.cwK.a((i.c) this);
            AppMethodBeat.o(135014);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandPageActionSheet", "show exception = %s", e2);
            AppMethodBeat.o(135014);
            return false;
        }
    }

    private boolean btZ() {
        AppMethodBeat.i(135015);
        try {
            this.kHi.bMo();
            this.cwK.b((i.b) this);
            this.cwK.b((i.c) this);
            AppMethodBeat.o(135015);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandPageActionSheet", "hide exception = %s", e2);
            AppMethodBeat.o(135015);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void a(com.tencent.mm.ui.widget.a.e eVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
    public final void onDestroy() {
        AppMethodBeat.i(135016);
        btZ();
        AppMethodBeat.o(135016);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
    public final void onBackground() {
        AppMethodBeat.i(135017);
        btZ();
        AppMethodBeat.o(135017);
    }

    static /* synthetic */ void a(u uVar, m mVar, boolean z) {
        AppMethodBeat.i(135018);
        for (t tVar : uVar.kHj) {
            if (tVar != null && tVar.neS == z) {
                Context context = uVar.cwK.getContext();
                ac acVar = uVar.cwK;
                String str = uVar.mAppId;
                if (tVar != null) {
                    tVar.neU.a(context, acVar, mVar, str);
                }
            }
        }
        AppMethodBeat.o(135018);
    }

    static /* synthetic */ void a(u uVar, MenuItem menuItem) {
        t tVar;
        boolean z;
        AppMethodBeat.i(135019);
        List<t> list = uVar.kHj;
        int itemId = menuItem.getItemId();
        Iterator<t> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                tVar = null;
                break;
            }
            tVar = it.next();
            if (tVar.id == itemId) {
                break;
            }
        }
        Context context = uVar.cwK.getContext();
        ac acVar = uVar.cwK;
        String str = uVar.mAppId;
        if (tVar == null) {
            z = false;
        } else {
            tVar.neU.a(context, acVar, str, tVar);
            z = true;
        }
        if (z) {
            uVar.kHi.bMo();
        }
        AppMethodBeat.o(135019);
    }
}
