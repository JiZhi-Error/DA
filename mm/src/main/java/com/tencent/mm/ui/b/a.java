package com.tencent.mm.ui.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.view.b;
import android.support.v7.view.f;
import android.support.v7.view.g;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class a {
    private MenuInflater YC;
    b YG = null;
    public ActionBar mActionBar;
    final Activity mActivity;

    /* access modifiers changed from: package-private */
    public abstract ActionBar gKf();

    public a(Activity activity) {
        this.mActivity = activity;
    }

    /* access modifiers changed from: package-private */
    public final ActionBar getSupportActionBar() {
        if (this.mActionBar == null) {
            this.mActionBar = gKf();
        }
        return this.mActionBar;
    }

    public final MenuInflater getMenuInflater() {
        if (this.YC == null) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                this.YC = new g(supportActionBar.getThemedContext());
            } else {
                this.YC = new g(this.mActivity);
            }
        }
        return this.YC;
    }

    @TargetApi(11)
    public final ActionMode startActionMode(ActionMode.Callback callback) {
        f.a aVar = new f.a(this.mActivity, callback);
        b startSupportActionMode = startSupportActionMode(aVar);
        if (startSupportActionMode != null) {
            return aVar.b(startSupportActionMode);
        }
        return null;
    }

    private b startSupportActionMode(b.a aVar) {
        if (this.YG != null) {
            this.YG.finish();
        }
        C2079a aVar2 = new C2079a(aVar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            this.YG = supportActionBar.a(aVar2);
        }
        return this.YG;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.ui.b.a$a  reason: collision with other inner class name */
    public class C2079a implements b.a {
        private b.a Zn;

        public C2079a(b.a aVar) {
            this.Zn = aVar;
        }

        @Override // android.support.v7.view.b.a
        public final boolean a(b bVar, Menu menu) {
            AppMethodBeat.i(141505);
            boolean a2 = this.Zn.a(bVar, menu);
            AppMethodBeat.o(141505);
            return a2;
        }

        @Override // android.support.v7.view.b.a
        public final boolean b(b bVar, Menu menu) {
            AppMethodBeat.i(141506);
            boolean b2 = this.Zn.b(bVar, menu);
            AppMethodBeat.o(141506);
            return b2;
        }

        @Override // android.support.v7.view.b.a
        public final boolean a(b bVar, MenuItem menuItem) {
            AppMethodBeat.i(141507);
            boolean a2 = this.Zn.a(bVar, menuItem);
            AppMethodBeat.o(141507);
            return a2;
        }

        @Override // android.support.v7.view.b.a
        public final void a(b bVar) {
            AppMethodBeat.i(141508);
            this.Zn.a(bVar);
            a.this.YG = null;
            AppMethodBeat.o(141508);
        }
    }
}
