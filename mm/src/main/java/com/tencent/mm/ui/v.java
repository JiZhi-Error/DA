package com.tencent.mm.ui;

import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.b.b;

public final class v extends t implements b.a {
    public MMFragment OHs = null;
    public b OHt;
    private ActionBar mActionBar;

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.t
    public final int getLayoutId() {
        AppMethodBeat.i(141367);
        if (this.OHs != null) {
            int layoutId = this.OHs.getLayoutId();
            AppMethodBeat.o(141367);
            return layoutId;
        }
        AppMethodBeat.o(141367);
        return -1;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.t
    public final void dealContentView(View view) {
        AppMethodBeat.i(141368);
        if (this.OHs != null) {
            this.OHs.dealContentView(view);
        }
        AppMethodBeat.o(141368);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.t
    public final String getIdentString() {
        AppMethodBeat.i(141369);
        if (this.OHs != null) {
            String identityString = this.OHs.getIdentityString();
            AppMethodBeat.o(141369);
            return identityString;
        }
        AppMethodBeat.o(141369);
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.t
    public final View getLayoutView() {
        AppMethodBeat.i(141370);
        if (this.OHs != null) {
            View layoutView = this.OHs.getLayoutView();
            AppMethodBeat.o(141370);
            return layoutView;
        }
        AppMethodBeat.o(141370);
        return null;
    }

    @Override // com.tencent.mm.ui.t
    public final void onKeyboardStateChanged() {
        AppMethodBeat.i(141371);
        if (this.OHs != null) {
            this.OHs.onKeyboardStateChanged();
        }
        AppMethodBeat.o(141371);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.t
    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.i(141372);
        if (this.OHs != null) {
            this.OHs.onCreateBeforeSetContentView();
        }
        AppMethodBeat.o(141372);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.t
    public final String getClassName() {
        AppMethodBeat.i(141373);
        String name = this.OHs.getClass().getName();
        AppMethodBeat.o(141373);
        return name;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.t
    public final boolean fromFullScreenActivity() {
        return false;
    }

    @Override // com.tencent.mm.ui.t
    public final ActionBar getSupportActionBar() {
        AppMethodBeat.i(141374);
        if (this.mActionBar == null) {
            this.mActionBar = this.OHt.gKf();
        }
        ActionBar actionBar = this.mActionBar;
        AppMethodBeat.o(141374);
        return actionBar;
    }

    @Override // com.tencent.mm.ui.t
    public final boolean interceptSupportInvalidateOptionsMenu() {
        return true;
    }

    @Override // com.tencent.mm.ui.t
    public final void supportInvalidateOptionsMenu() {
        AppMethodBeat.i(141375);
        this.OHt.supportInvalidateOptionsMenu();
        AppMethodBeat.o(141375);
    }

    @Override // com.tencent.mm.ui.b.b.a
    public final boolean d(Menu menu) {
        AppMethodBeat.i(141376);
        if (this.OHs != null) {
            this.OHs.onPrepareOptionsMenu(menu);
        }
        AppMethodBeat.o(141376);
        return true;
    }

    @Override // com.tencent.mm.ui.b.b.a
    public final boolean e(Menu menu) {
        AppMethodBeat.i(141377);
        this.OHs.onCreateOptionsMenu(menu, this.OHt.getMenuInflater());
        AppMethodBeat.o(141377);
        return true;
    }

    @Override // com.tencent.mm.ui.b.b.a
    public final boolean f(MenuItem menuItem) {
        AppMethodBeat.i(141378);
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        AppMethodBeat.o(141378);
        return onOptionsItemSelected;
    }

    @Override // com.tencent.mm.ui.t
    public final int getForceOrientation() {
        return 1;
    }
}
