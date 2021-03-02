package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a.b;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public final class a implements b {
    private int FV = 16;
    private CharSequence Hn;
    private final int aeE;
    private final int aeF;
    private final int aeG;
    private CharSequence aeH;
    private char aeI;
    private int aeJ = 4096;
    private char aeK;
    private int aeL = 4096;
    private Drawable aeM;
    private int aeN = 0;
    private MenuItem.OnMenuItemClickListener aeO;
    private CharSequence aeP;
    private CharSequence aeQ;
    private ColorStateList aeR = null;
    private PorterDuff.Mode aeS = null;
    private boolean aeT = false;
    private boolean aeU = false;
    private Context mContext;
    private final int mId;
    private Intent mIntent;

    public a(Context context, CharSequence charSequence) {
        this.mContext = context;
        this.mId = 16908332;
        this.aeE = 0;
        this.aeF = 0;
        this.aeG = 0;
        this.Hn = charSequence;
    }

    public final char getAlphabeticShortcut() {
        return this.aeK;
    }

    @Override // android.support.v4.a.a.b
    public final int getAlphabeticModifiers() {
        return this.aeL;
    }

    public final int getGroupId() {
        return this.aeE;
    }

    public final Drawable getIcon() {
        return this.aeM;
    }

    public final Intent getIntent() {
        return this.mIntent;
    }

    public final int getItemId() {
        return this.mId;
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public final char getNumericShortcut() {
        return this.aeI;
    }

    @Override // android.support.v4.a.a.b
    public final int getNumericModifiers() {
        return this.aeJ;
    }

    public final int getOrder() {
        return this.aeG;
    }

    public final SubMenu getSubMenu() {
        return null;
    }

    public final CharSequence getTitle() {
        return this.Hn;
    }

    public final CharSequence getTitleCondensed() {
        return this.aeH != null ? this.aeH : this.Hn;
    }

    public final boolean hasSubMenu() {
        return false;
    }

    public final boolean isCheckable() {
        return (this.FV & 1) != 0;
    }

    public final boolean isChecked() {
        return (this.FV & 2) != 0;
    }

    public final boolean isEnabled() {
        return (this.FV & 16) != 0;
    }

    public final boolean isVisible() {
        return (this.FV & 8) == 0;
    }

    public final MenuItem setAlphabeticShortcut(char c2) {
        this.aeK = Character.toLowerCase(c2);
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.aeK = Character.toLowerCase(c2);
        this.aeL = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public final MenuItem setCheckable(boolean z) {
        this.FV = (z ? 1 : 0) | (this.FV & -2);
        return this;
    }

    public final MenuItem setChecked(boolean z) {
        this.FV = (z ? 2 : 0) | (this.FV & -3);
        return this;
    }

    public final MenuItem setEnabled(boolean z) {
        this.FV = (z ? 16 : 0) | (this.FV & -17);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.aeM = drawable;
        this.aeN = 0;
        hJ();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i2) {
        this.aeN = i2;
        this.aeM = android.support.v4.content.b.l(this.mContext, i2);
        hJ();
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c2) {
        this.aeI = c2;
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final MenuItem setNumericShortcut(char c2, int i2) {
        this.aeI = c2;
        this.aeJ = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.aeO = onMenuItemClickListener;
        return this;
    }

    public final MenuItem setShortcut(char c2, char c3) {
        this.aeI = c2;
        this.aeK = Character.toLowerCase(c3);
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.aeI = c2;
        this.aeJ = KeyEvent.normalizeMetaState(i2);
        this.aeK = Character.toLowerCase(c3);
        this.aeL = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.Hn = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i2) {
        this.Hn = this.mContext.getResources().getString(i2);
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.aeH = charSequence;
        return this;
    }

    public final MenuItem setVisible(boolean z) {
        this.FV = (z ? 0 : 8) | (this.FV & 8);
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final void setShowAsAction(int i2) {
    }

    @Override // android.support.v4.a.a.b
    public final View getActionView() {
        return null;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.a.a.b
    public final android.support.v4.view.b eJ() {
        return null;
    }

    @Override // android.support.v4.a.a.b
    public final b a(android.support.v4.view.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.a.a.b
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.support.v4.a.a.b
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.support.v4.a.a.b
    public final boolean isActionViewExpanded() {
        return false;
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.a.a.b
    public final b k(CharSequence charSequence) {
        this.aeP = charSequence;
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final CharSequence getContentDescription() {
        return this.aeP;
    }

    @Override // android.support.v4.a.a.b
    public final b l(CharSequence charSequence) {
        this.aeQ = charSequence;
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final CharSequence getTooltipText() {
        return this.aeQ;
    }

    @Override // android.support.v4.a.a.b
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.aeR = colorStateList;
        this.aeT = true;
        hJ();
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final ColorStateList getIconTintList() {
        return this.aeR;
    }

    @Override // android.support.v4.a.a.b
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.aeS = mode;
        this.aeU = true;
        hJ();
        return this;
    }

    @Override // android.support.v4.a.a.b
    public final PorterDuff.Mode getIconTintMode() {
        return this.aeS;
    }

    private void hJ() {
        if (this.aeM == null) {
            return;
        }
        if (this.aeT || this.aeU) {
            this.aeM = android.support.v4.graphics.drawable.a.i(this.aeM);
            this.aeM = this.aeM.mutate();
            if (this.aeT) {
                android.support.v4.graphics.drawable.a.a(this.aeM, this.aeR);
            }
            if (this.aeU) {
                android.support.v4.graphics.drawable.a.a(this.aeM, this.aeS);
            }
        }
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final /* synthetic */ MenuItem setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final /* synthetic */ MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.a.a.b
    public final /* synthetic */ MenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        this.aeQ = charSequence;
        return this;
    }

    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        this.aeP = charSequence;
        return this;
    }
}
