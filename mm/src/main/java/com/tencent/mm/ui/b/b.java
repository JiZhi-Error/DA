package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.support.v7.widget.u;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends a implements h.a, o.a {
    a OMb;
    boolean OMc;
    private final Runnable OMd = new Runnable() {
        /* class com.tencent.mm.ui.b.b.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(141509);
            b bVar = b.this;
            Context context = bVar.mActivity;
            ActionBar supportActionBar = bVar.getSupportActionBar();
            if (supportActionBar != null) {
                context = supportActionBar.getThemedContext();
            }
            h hVar = new h(context);
            hVar.a(bVar);
            if (b.this.OMb != null) {
                b.this.OMb.e(hVar);
                b.this.OMb.d(hVar);
                b.a(b.this, hVar);
            } else {
                b.a(b.this, (h) null);
            }
            hVar.r(true);
            b.this.OMc = false;
            AppMethodBeat.o(141509);
        }
    };
    public ViewGroup WN;
    private boolean YM;
    private h aaQ;

    public interface a {
        boolean d(Menu menu);

        boolean e(Menu menu);

        boolean f(MenuItem menuItem);
    }

    public b(Activity activity, a aVar) {
        super(activity);
        AppMethodBeat.i(141510);
        this.OMb = aVar;
        AppMethodBeat.o(141510);
    }

    @Override // com.tencent.mm.ui.b.a
    public final ActionBar gKf() {
        AppMethodBeat.i(141511);
        gF();
        if (this.mActionBar == null) {
            this.mActionBar = new d(this.mActivity, this.WN);
        }
        ActionBar actionBar = this.mActionBar;
        AppMethodBeat.o(141511);
        return actionBar;
    }

    private void gF() {
        AppMethodBeat.i(141512);
        if (!this.YM) {
            this.YM = true;
            supportInvalidateOptionsMenu();
        }
        AppMethodBeat.o(141512);
    }

    @Override // android.support.v7.view.menu.h.a
    public final boolean a(h hVar, MenuItem menuItem) {
        AppMethodBeat.i(141513);
        if (this.OMb != null) {
            boolean f2 = this.OMb.f(menuItem);
            AppMethodBeat.o(141513);
            return f2;
        }
        AppMethodBeat.o(141513);
        return false;
    }

    @Override // android.support.v7.view.menu.o.a
    public final void a(h hVar, boolean z) {
    }

    @Override // android.support.v7.view.menu.o.a
    public final boolean d(h hVar) {
        return false;
    }

    public final void supportInvalidateOptionsMenu() {
        AppMethodBeat.i(141515);
        if (!this.OMc) {
            this.OMc = true;
            this.OMd.run();
        }
        AppMethodBeat.o(141515);
    }

    @Override // android.support.v7.view.menu.h.a
    public final void b(h hVar) {
        u uVar;
        AppMethodBeat.i(141514);
        if (this.mActionBar == null || (uVar = ((d) this.mActionBar).ZU) == null || !uVar.iB()) {
            hVar.close();
            AppMethodBeat.o(141514);
            return;
        }
        if (uVar.isOverflowMenuShowing()) {
            uVar.hideOverflowMenu();
        } else if (uVar.getVisibility() == 0) {
            uVar.showOverflowMenu();
            AppMethodBeat.o(141514);
            return;
        }
        AppMethodBeat.o(141514);
    }

    static /* synthetic */ void a(b bVar, h hVar) {
        AppMethodBeat.i(141516);
        if (hVar != bVar.aaQ) {
            bVar.aaQ = hVar;
            if (bVar.mActionBar != null) {
                ((d) bVar.mActionBar).ZU.a(hVar, bVar);
            }
        }
        AppMethodBeat.o(141516);
    }
}
