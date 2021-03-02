package com.tencent.mm.plugin.appbrand.ad.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;
import java.util.List;

public final class a {
    private ac cwK;
    private e kHi;
    private List<t> kHj;
    private Context mContext;

    public a(Context context, ac acVar, List<t> list) {
        AppMethodBeat.i(160561);
        this.mContext = context;
        this.cwK = acVar;
        this.kHj = list;
        this.kHi = new e(context, false, 0);
        View bRy = this.cwK.bRy();
        if (bRy != null) {
            this.kHi.V(bRy, true);
        }
        this.kHi.HLX = new o.f() {
            /* class com.tencent.mm.plugin.appbrand.ad.ui.a.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(160557);
                a.a(a.this, mVar, true);
                AppMethodBeat.o(160557);
            }
        };
        this.kHi.HLY = new o.g() {
            /* class com.tencent.mm.plugin.appbrand.ad.ui.a.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(160558);
                a.a(a.this, menuItem);
                AppMethodBeat.o(160558);
            }
        };
        this.kHi.QNH = new o.f() {
            /* class com.tencent.mm.plugin.appbrand.ad.ui.a.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(160559);
                a.a(a.this, mVar, false);
                AppMethodBeat.o(160559);
            }
        };
        this.kHi.QNK = new o.g() {
            /* class com.tencent.mm.plugin.appbrand.ad.ui.a.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(160560);
                a.a(a.this, menuItem);
                AppMethodBeat.o(160560);
            }
        };
        if (e.a.BLACK == this.cwK.nqR) {
            this.kHi.setBackgroundColor(Color.parseColor("#000000"));
        }
        AppMethodBeat.o(160561);
    }

    public final boolean btY() {
        AppMethodBeat.i(160562);
        try {
            this.kHi.dGm();
            AppMethodBeat.o(160562);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandAdActionSheet", "show exception = %s", e2);
            AppMethodBeat.o(160562);
            return false;
        }
    }

    public final boolean btZ() {
        AppMethodBeat.i(160563);
        try {
            this.kHi.bMo();
            AppMethodBeat.o(160563);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandAdActionSheet", "hide exception = %s", e2);
            AppMethodBeat.o(160563);
            return false;
        }
    }

    static /* synthetic */ void a(a aVar, m mVar, boolean z) {
        AppMethodBeat.i(160564);
        for (t tVar : aVar.kHj) {
            if (tVar != null && tVar.neS == z) {
                Context context = aVar.mContext;
                ac acVar = aVar.cwK;
                String appId = aVar.cwK.getAppId();
                if (tVar != null) {
                    tVar.neU.a(context, acVar, mVar, appId);
                }
            }
        }
        AppMethodBeat.o(160564);
    }

    static /* synthetic */ void a(a aVar, MenuItem menuItem) {
        t tVar;
        boolean z;
        AppMethodBeat.i(160565);
        List<t> list = aVar.kHj;
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
        Context context = aVar.mContext;
        ac acVar = aVar.cwK;
        String appId = aVar.cwK.getAppId();
        if (tVar == null) {
            z = false;
        } else {
            tVar.neU.a(context, acVar, appId, tVar);
            z = true;
        }
        if (z) {
            aVar.kHi.bMo();
        }
        AppMethodBeat.o(160565);
    }
}
