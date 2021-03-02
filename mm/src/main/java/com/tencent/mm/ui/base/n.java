package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.o;

public final class n implements MenuItem {
    public boolean Bno = false;
    private Drawable JlN;
    public boolean ORE;
    public TextUtils.TruncateAt ORF;
    public boolean ORG = true;
    public ContextMenu.ContextMenuInfo ORH;
    private MenuItem.OnMenuItemClickListener ORI;
    public boolean ORJ = false;
    public o.d ORK = null;
    public o.h ORL = null;
    private int adT;
    private int aea;
    public boolean eaY;
    private int iconId;
    private Intent intent;
    public String lDS;
    private Context mContext;
    public boolean neT = false;
    private CharSequence title;
    private int uQk;
    public int uzt;
    public CharSequence xdb = null;

    public n(Context context, int i2, int i3) {
        AppMethodBeat.i(159237);
        this.mContext = context;
        this.aea = i2;
        this.adT = i3;
        this.uzt = context.getResources().getColor(R.color.FG_0);
        AppMethodBeat.o(159237);
    }

    public final void a(o.h hVar) {
        this.ORL = hVar;
    }

    public final int getItemId() {
        return this.aea;
    }

    public final int getGroupId() {
        return this.adT;
    }

    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.title = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i2) {
        this.uQk = i2;
        return this;
    }

    public final CharSequence getTitle() {
        AppMethodBeat.i(159238);
        if (this.title != null) {
            CharSequence charSequence = this.title;
            AppMethodBeat.o(159238);
            return charSequence;
        } else if (this.uQk == 0 || this.mContext == null) {
            AppMethodBeat.o(159238);
            return null;
        } else {
            String string = this.mContext.getString(this.uQk);
            AppMethodBeat.o(159238);
            return string;
        }
    }

    public final CharSequence gKS() {
        return this.xdb;
    }

    public final MenuItem Bw(boolean z) {
        this.neT = z;
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        return this;
    }

    public final CharSequence getTitleCondensed() {
        return null;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        AppMethodBeat.i(198207);
        this.JlN = drawable;
        if (this.ORK != null) {
            this.ORK.a(this);
        }
        AppMethodBeat.o(198207);
        return this;
    }

    public final MenuItem f(Drawable drawable, int i2) {
        AppMethodBeat.i(198208);
        this.JlN = drawable;
        this.uzt = i2;
        if (this.ORK != null) {
            this.ORK.a(this);
        }
        AppMethodBeat.o(198208);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i2) {
        AppMethodBeat.i(198209);
        this.iconId = i2;
        if (this.ORK != null) {
            this.ORK.a(this);
        }
        AppMethodBeat.o(198209);
        return this;
    }

    public final MenuItem kW(int i2, int i3) {
        AppMethodBeat.i(198210);
        this.iconId = i2;
        this.uzt = i3;
        if (this.ORK != null) {
            this.ORK.a(this);
        }
        AppMethodBeat.o(198210);
        return this;
    }

    public final Drawable getIcon() {
        AppMethodBeat.i(159239);
        if (this.JlN != null) {
            Drawable drawable = this.JlN;
            AppMethodBeat.o(159239);
            return drawable;
        } else if (this.iconId == 0 || this.mContext == null) {
            AppMethodBeat.o(159239);
            return null;
        } else {
            Drawable drawable2 = this.mContext.getResources().getDrawable(this.iconId);
            AppMethodBeat.o(159239);
            return drawable2;
        }
    }

    public final MenuItem setIntent(Intent intent2) {
        this.intent = intent2;
        return this;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final MenuItem setShortcut(char c2, char c3) {
        return this;
    }

    public final MenuItem setNumericShortcut(char c2) {
        return this;
    }

    public final char getNumericShortcut() {
        return 0;
    }

    public final MenuItem setAlphabeticShortcut(char c2) {
        return this;
    }

    public final char getAlphabeticShortcut() {
        return 0;
    }

    public final MenuItem setCheckable(boolean z) {
        return this;
    }

    public final boolean isCheckable() {
        return false;
    }

    public final MenuItem setChecked(boolean z) {
        return this;
    }

    public final boolean isChecked() {
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        return this;
    }

    public final boolean isVisible() {
        return true;
    }

    public final MenuItem setEnabled(boolean z) {
        return this;
    }

    public final boolean isEnabled() {
        return true;
    }

    public final boolean hasSubMenu() {
        return false;
    }

    public final SubMenu getSubMenu() {
        return null;
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.ORI = onMenuItemClickListener;
        return this;
    }

    public final boolean performClick() {
        AppMethodBeat.i(159240);
        if (this.ORI != null) {
            boolean onMenuItemClick = this.ORI.onMenuItemClick(this);
            AppMethodBeat.o(159240);
            return onMenuItemClick;
        }
        AppMethodBeat.o(159240);
        return false;
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.ORH;
    }

    public final void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.ORH = contextMenuInfo;
    }

    public final boolean collapseActionView() {
        return false;
    }

    public final boolean expandActionView() {
        return false;
    }

    public final ActionProvider getActionProvider() {
        return null;
    }

    public final View getActionView() {
        return null;
    }

    public final boolean isActionViewExpanded() {
        return false;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        return null;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        return null;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i2) {
        return null;
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        return null;
    }

    public final void setShowAsAction(int i2) {
    }

    public final MenuItem setShowAsActionFlags(int i2) {
        return null;
    }
}
