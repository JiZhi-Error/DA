package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.view.i;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ba;
import android.support.v7.widget.u;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import com.tencent.mm.R;
import java.util.ArrayList;

final class g extends ActionBar {
    u ZU;
    boolean ZV;
    Window.Callback ZW;
    private boolean ZX;
    private boolean ZY;
    private ArrayList<Object> ZZ = new ArrayList<>();
    private final Runnable aaa = new Runnable() {
        /* class android.support.v7.app.g.AnonymousClass1 */

        public final void run() {
            g gVar = g.this;
            Menu menu = gVar.getMenu();
            h hVar = menu instanceof h ? (h) menu : null;
            if (hVar != null) {
                hVar.ia();
            }
            try {
                menu.clear();
                if (!gVar.ZW.onCreatePanelMenu(0, menu) || !gVar.ZW.onPreparePanel(0, null, menu)) {
                    menu.clear();
                }
            } finally {
                if (hVar != null) {
                    hVar.ib();
                }
            }
        }
    };
    private final Toolbar.b aab = new Toolbar.b() {
        /* class android.support.v7.app.g.AnonymousClass2 */

        @Override // android.support.v7.widget.Toolbar.b
        public final boolean onMenuItemClick(MenuItem menuItem) {
            return g.this.ZW.onMenuItemSelected(0, menuItem);
        }
    };

    g(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.ZU = new ba(toolbar, false);
        this.ZW = new c(callback);
        this.ZU.setWindowCallback(this.ZW);
        toolbar.setOnMenuItemClickListener(this.aab);
        this.ZU.setWindowTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setCustomView(View view) {
        a(view, new ActionBar.LayoutParams(-2, -2));
    }

    @Override // android.support.v7.app.ActionBar
    public final void a(View view, ActionBar.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.ZU.setCustomView(view);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setCustomView(int i2) {
        setCustomView(LayoutInflater.from(this.ZU.getContext()).inflate(i2, this.ZU.jC(), false));
    }

    @Override // android.support.v7.app.ActionBar
    public final void gr() {
        this.ZU.setIcon(R.drawable.b0w);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setLogo(Drawable drawable) {
        this.ZU.setLogo(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setElevation(float f2) {
        android.support.v4.view.u.l(this.ZU.jC(), f2);
    }

    @Override // android.support.v7.app.ActionBar
    public final Context getThemedContext() {
        return this.ZU.getContext();
    }

    @Override // android.support.v7.app.ActionBar
    public final void P(boolean z) {
    }

    @Override // android.support.v7.app.ActionBar
    public final void setHomeActionContentDescription(int i2) {
        this.ZU.setNavigationContentDescription(i2);
    }

    @Override // android.support.v7.app.ActionBar
    public final void Q(boolean z) {
    }

    @Override // android.support.v7.app.ActionBar
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setTitle(CharSequence charSequence) {
        this.ZU.setTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setWindowTitle(CharSequence charSequence) {
        this.ZU.setWindowTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    @SuppressLint({"WrongConstant"})
    public final void setDisplayOptions(int i2) {
        setDisplayOptions(i2, -1);
    }

    private void setDisplayOptions(int i2, int i3) {
        this.ZU.setDisplayOptions((this.ZU.getDisplayOptions() & (i3 ^ -1)) | (i2 & i3));
    }

    @Override // android.support.v7.app.ActionBar
    public final void gs() {
        setDisplayOptions(0, 2);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    @Override // android.support.v7.app.ActionBar
    public final void gt() {
        setDisplayOptions(0, 8);
    }

    @Override // android.support.v7.app.ActionBar
    public final void gu() {
        setDisplayOptions(16, 16);
    }

    @Override // android.support.v7.app.ActionBar
    public final void setBackgroundDrawable(Drawable drawable) {
        this.ZU.setBackgroundDrawable(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public final View getCustomView() {
        return this.ZU.getCustomView();
    }

    @Override // android.support.v7.app.ActionBar
    public final CharSequence getTitle() {
        return this.ZU.getTitle();
    }

    @Override // android.support.v7.app.ActionBar
    public final int getDisplayOptions() {
        return this.ZU.getDisplayOptions();
    }

    @Override // android.support.v7.app.ActionBar
    public final int getHeight() {
        return this.ZU.getHeight();
    }

    @Override // android.support.v7.app.ActionBar
    public final void show() {
        this.ZU.setVisibility(0);
    }

    @Override // android.support.v7.app.ActionBar
    public final void hide() {
        this.ZU.setVisibility(8);
    }

    @Override // android.support.v7.app.ActionBar
    public final boolean isShowing() {
        return this.ZU.getVisibility() == 0;
    }

    @Override // android.support.v7.app.ActionBar
    public final boolean gw() {
        return this.ZU.showOverflowMenu();
    }

    @Override // android.support.v7.app.ActionBar
    public final boolean gx() {
        return this.ZU.hideOverflowMenu();
    }

    @Override // android.support.v7.app.ActionBar
    public final boolean gy() {
        this.ZU.jC().removeCallbacks(this.aaa);
        android.support.v4.view.u.b(this.ZU.jC(), this.aaa);
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public final boolean collapseActionView() {
        if (!this.ZU.hasExpandedActionView()) {
            return false;
        }
        this.ZU.collapseActionView();
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public final boolean b(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            gw();
        }
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public final boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        boolean z;
        Menu menu = getMenu();
        if (menu == null) {
            return false;
        }
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
            z = true;
        } else {
            z = false;
        }
        menu.setQwertyMode(z);
        return menu.performShortcut(i2, keyEvent, 0);
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v7.app.ActionBar
    public final void onDestroy() {
        this.ZU.jC().removeCallbacks(this.aaa);
    }

    @Override // android.support.v7.app.ActionBar
    public final void R(boolean z) {
        if (z != this.ZY) {
            this.ZY = z;
            int size = this.ZZ.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.ZZ.get(i2);
            }
        }
    }

    class c extends i {
        public c(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.i
        public final boolean onPreparePanel(int i2, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (onPreparePanel && !g.this.ZV) {
                g.this.ZU.iD();
                g.this.ZV = true;
            }
            return onPreparePanel;
        }

        @Override // android.support.v7.view.i
        public final View onCreatePanelView(int i2) {
            if (i2 == 0) {
                return new View(g.this.ZU.getContext());
            }
            return super.onCreatePanelView(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final Menu getMenu() {
        if (!this.ZX) {
            this.ZU.a(new a(), new b());
            this.ZX = true;
        }
        return this.ZU.getMenu();
    }

    /* access modifiers changed from: package-private */
    public final class a implements o.a {
        private boolean YW;

        a() {
        }

        @Override // android.support.v7.view.menu.o.a
        public final boolean d(h hVar) {
            if (g.this.ZW == null) {
                return false;
            }
            g.this.ZW.onMenuOpened(108, hVar);
            return true;
        }

        @Override // android.support.v7.view.menu.o.a
        public final void a(h hVar, boolean z) {
            if (!this.YW) {
                this.YW = true;
                g.this.ZU.dismissPopupMenus();
                if (g.this.ZW != null) {
                    g.this.ZW.onPanelClosed(108, hVar);
                }
                this.YW = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final class b implements h.a {
        b() {
        }

        @Override // android.support.v7.view.menu.h.a
        public final boolean a(h hVar, MenuItem menuItem) {
            return false;
        }

        @Override // android.support.v7.view.menu.h.a
        public final void b(h hVar) {
            if (g.this.ZW == null) {
                return;
            }
            if (g.this.ZU.isOverflowMenuShowing()) {
                g.this.ZW.onPanelClosed(108, hVar);
            } else if (g.this.ZW.onPreparePanel(0, null, hVar)) {
                g.this.ZW.onMenuOpened(108, hVar);
            }
        }
    }
}
