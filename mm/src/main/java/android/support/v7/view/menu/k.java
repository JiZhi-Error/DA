package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public class k extends c<android.support.v4.a.a.b> implements MenuItem {
    public Method agX;

    k(Context context, android.support.v4.a.a.b bVar) {
        super(context, bVar);
    }

    public int getItemId() {
        return ((android.support.v4.a.a.b) this.afm).getItemId();
    }

    public int getGroupId() {
        return ((android.support.v4.a.a.b) this.afm).getGroupId();
    }

    public int getOrder() {
        return ((android.support.v4.a.a.b) this.afm).getOrder();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        ((android.support.v4.a.a.b) this.afm).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        ((android.support.v4.a.a.b) this.afm).setTitle(i2);
        return this;
    }

    public CharSequence getTitle() {
        return ((android.support.v4.a.a.b) this.afm).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((android.support.v4.a.a.b) this.afm).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((android.support.v4.a.a.b) this.afm).getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        ((android.support.v4.a.a.b) this.afm).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        ((android.support.v4.a.a.b) this.afm).setIcon(i2);
        return this;
    }

    public Drawable getIcon() {
        return ((android.support.v4.a.a.b) this.afm).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((android.support.v4.a.a.b) this.afm).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((android.support.v4.a.a.b) this.afm).getIntent();
    }

    public MenuItem setShortcut(char c2, char c3) {
        ((android.support.v4.a.a.b) this.afm).setShortcut(c2, c3);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        ((android.support.v4.a.a.b) this.afm).setShortcut(c2, c3, i2, i3);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        ((android.support.v4.a.a.b) this.afm).setNumericShortcut(c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        ((android.support.v4.a.a.b) this.afm).setNumericShortcut(c2, i2);
        return this;
    }

    public char getNumericShortcut() {
        return ((android.support.v4.a.a.b) this.afm).getNumericShortcut();
    }

    public int getNumericModifiers() {
        return ((android.support.v4.a.a.b) this.afm).getNumericModifiers();
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        ((android.support.v4.a.a.b) this.afm).setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        ((android.support.v4.a.a.b) this.afm).setAlphabeticShortcut(c2, i2);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((android.support.v4.a.a.b) this.afm).getAlphabeticShortcut();
    }

    public int getAlphabeticModifiers() {
        return ((android.support.v4.a.a.b) this.afm).getAlphabeticModifiers();
    }

    public MenuItem setCheckable(boolean z) {
        ((android.support.v4.a.a.b) this.afm).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((android.support.v4.a.a.b) this.afm).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((android.support.v4.a.a.b) this.afm).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((android.support.v4.a.a.b) this.afm).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((android.support.v4.a.a.b) this.afm).setVisible(z);
    }

    public boolean isVisible() {
        return ((android.support.v4.a.a.b) this.afm).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((android.support.v4.a.a.b) this.afm).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((android.support.v4.a.a.b) this.afm).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((android.support.v4.a.a.b) this.afm).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return a(((android.support.v4.a.a.b) this.afm).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((android.support.v4.a.a.b) this.afm).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((android.support.v4.a.a.b) this.afm).getMenuInfo();
    }

    public void setShowAsAction(int i2) {
        ((android.support.v4.a.a.b) this.afm).setShowAsAction(i2);
    }

    public MenuItem setShowAsActionFlags(int i2) {
        ((android.support.v4.a.a.b) this.afm).setShowAsActionFlags(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((android.support.v4.a.a.b) this.afm).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i2) {
        ((android.support.v4.a.a.b) this.afm).setActionView(i2);
        View actionView = ((android.support.v4.a.a.b) this.afm).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((android.support.v4.a.a.b) this.afm).setActionView(new b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((android.support.v4.a.a.b) this.afm).getActionView();
        return actionView instanceof b ? (View) ((b) actionView).aha : actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((android.support.v4.a.a.b) this.afm).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        android.support.v4.view.b eJ = ((android.support.v4.a.a.b) this.afm).eJ();
        if (eJ instanceof a) {
            return ((a) eJ).agY;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((android.support.v4.a.a.b) this.afm).expandActionView();
    }

    public boolean collapseActionView() {
        return ((android.support.v4.a.a.b) this.afm).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((android.support.v4.a.a.b) this.afm).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((android.support.v4.a.a.b) this.afm).setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        ((android.support.v4.a.a.b) this.afm).k(charSequence);
        return this;
    }

    public CharSequence getContentDescription() {
        return ((android.support.v4.a.a.b) this.afm).getContentDescription();
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        ((android.support.v4.a.a.b) this.afm).l(charSequence);
        return this;
    }

    public CharSequence getTooltipText() {
        return ((android.support.v4.a.a.b) this.afm).getTooltipText();
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((android.support.v4.a.a.b) this.afm).setIconTintList(colorStateList);
        return this;
    }

    public ColorStateList getIconTintList() {
        return ((android.support.v4.a.a.b) this.afm).getIconTintList();
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        ((android.support.v4.a.a.b) this.afm).setIconTintMode(mode);
        return this;
    }

    public PorterDuff.Mode getIconTintMode() {
        return ((android.support.v4.a.a.b) this.afm).getIconTintMode();
    }

    /* access modifiers changed from: package-private */
    public a a(ActionProvider actionProvider) {
        return new a(this.mContext, actionProvider);
    }

    class d extends d<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.afm).onMenuItemClick(k.this.b(menuItem));
        }
    }

    class c extends d<MenuItem.OnActionExpandListener> implements MenuItem.OnActionExpandListener {
        c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.afm).onMenuItemActionExpand(k.this.b(menuItem));
        }

        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.afm).onMenuItemActionCollapse(k.this.b(menuItem));
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends android.support.v4.view.b {
        final ActionProvider agY;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.agY = actionProvider;
        }

        @Override // android.support.v4.view.b
        public final View onCreateActionView() {
            return this.agY.onCreateActionView();
        }

        @Override // android.support.v4.view.b
        public final boolean onPerformDefaultAction() {
            return this.agY.onPerformDefaultAction();
        }

        @Override // android.support.v4.view.b
        public final boolean hasSubMenu() {
            return this.agY.hasSubMenu();
        }

        @Override // android.support.v4.view.b
        public final void onPrepareSubMenu(SubMenu subMenu) {
            this.agY.onPrepareSubMenu(k.this.a(subMenu));
        }
    }

    static class b extends FrameLayout implements android.support.v7.view.c {
        final CollapsibleActionView aha;

        b(View view) {
            super(view.getContext());
            this.aha = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // android.support.v7.view.c
        public final void onActionViewExpanded() {
            this.aha.onActionViewExpanded();
        }

        @Override // android.support.v7.view.c
        public final void onActionViewCollapsed() {
            this.aha.onActionViewCollapsed();
        }
    }
}
