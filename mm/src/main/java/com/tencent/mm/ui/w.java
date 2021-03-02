package com.tencent.mm.ui;

import android.support.v7.app.ActionBar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.b.b;

public final class w extends t implements b.a {
    public MMFragment OHs = null;
    public b OHt;
    private ActionBar mActionBar;

    public final ActionMode startActionMode(ActionMode.Callback callback) {
        AppMethodBeat.i(141379);
        ActionMode startActionMode = this.OHt.startActionMode(callback);
        AppMethodBeat.o(141379);
        return startActionMode;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.t
    public final int getLayoutId() {
        AppMethodBeat.i(141380);
        if (this.OHs != null) {
            int layoutId = this.OHs.getLayoutId();
            AppMethodBeat.o(141380);
            return layoutId;
        }
        AppMethodBeat.o(141380);
        return -1;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.t
    public final void dealContentView(View view) {
        AppMethodBeat.i(141381);
        if (this.OHs != null) {
            this.OHs.dealContentView(view);
        }
        AppMethodBeat.o(141381);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.t
    public final String getIdentString() {
        AppMethodBeat.i(141382);
        if (this.OHs != null) {
            String identityString = this.OHs.getIdentityString();
            AppMethodBeat.o(141382);
            return identityString;
        }
        AppMethodBeat.o(141382);
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.t
    public final View getLayoutView() {
        AppMethodBeat.i(141383);
        if (this.OHs != null) {
            View layoutView = this.OHs.getLayoutView();
            AppMethodBeat.o(141383);
            return layoutView;
        }
        AppMethodBeat.o(141383);
        return null;
    }

    @Override // com.tencent.mm.ui.t
    public final void onKeyboardStateChanged() {
        AppMethodBeat.i(141384);
        if (this.OHs != null) {
            this.OHs.onKeyboardStateChanged();
        }
        AppMethodBeat.o(141384);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.t
    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.i(141385);
        if (this.OHs != null) {
            this.OHs.onCreateBeforeSetContentView();
        }
        AppMethodBeat.o(141385);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.t
    public final String getClassName() {
        AppMethodBeat.i(141386);
        String name = this.OHs.getClass().getName();
        AppMethodBeat.o(141386);
        return name;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.t
    public final boolean fromFullScreenActivity() {
        return false;
    }

    @Override // com.tencent.mm.ui.t
    public final ActionBar getSupportActionBar() {
        AppMethodBeat.i(141387);
        if (this.mActionBar == null) {
            this.mActionBar = this.OHt.gKf();
        }
        ActionBar actionBar = this.mActionBar;
        AppMethodBeat.o(141387);
        return actionBar;
    }

    @Override // com.tencent.mm.ui.t
    public final boolean interceptSupportInvalidateOptionsMenu() {
        return true;
    }

    @Override // com.tencent.mm.ui.t
    public final void supportInvalidateOptionsMenu() {
        AppMethodBeat.i(141388);
        this.OHt.supportInvalidateOptionsMenu();
        AppMethodBeat.o(141388);
    }

    @Override // com.tencent.mm.ui.b.b.a
    public final boolean d(Menu menu) {
        AppMethodBeat.i(141389);
        if (this.OHs != null) {
            this.OHs.onPrepareOptionsMenu(menu);
        }
        AppMethodBeat.o(141389);
        return true;
    }

    @Override // com.tencent.mm.ui.b.b.a
    public final boolean e(Menu menu) {
        AppMethodBeat.i(141390);
        this.OHs.onCreateOptionsMenu(menu, this.OHt.getMenuInflater());
        AppMethodBeat.o(141390);
        return true;
    }

    @Override // com.tencent.mm.ui.b.b.a
    public final boolean f(MenuItem menuItem) {
        AppMethodBeat.i(141391);
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        AppMethodBeat.o(141391);
        return onOptionsItemSelected;
    }
}
