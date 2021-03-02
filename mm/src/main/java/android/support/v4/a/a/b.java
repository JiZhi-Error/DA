package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import android.view.View;

public interface b extends MenuItem {
    b a(android.support.v4.view.b bVar);

    boolean collapseActionView();

    android.support.v4.view.b eJ();

    boolean expandActionView();

    View getActionView();

    int getAlphabeticModifiers();

    CharSequence getContentDescription();

    ColorStateList getIconTintList();

    PorterDuff.Mode getIconTintMode();

    int getNumericModifiers();

    CharSequence getTooltipText();

    boolean isActionViewExpanded();

    b k(CharSequence charSequence);

    b l(CharSequence charSequence);

    @Override // android.view.MenuItem
    MenuItem setActionView(int i2);

    @Override // android.view.MenuItem
    MenuItem setActionView(View view);

    MenuItem setAlphabeticShortcut(char c2, int i2);

    MenuItem setIconTintList(ColorStateList colorStateList);

    MenuItem setIconTintMode(PorterDuff.Mode mode);

    MenuItem setNumericShortcut(char c2, int i2);

    MenuItem setShortcut(char c2, char c3, int i2, int i3);

    void setShowAsAction(int i2);

    MenuItem setShowAsActionFlags(int i2);
}
