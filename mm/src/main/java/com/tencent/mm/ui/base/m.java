package com.tencent.mm.ui.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class m implements ContextMenu {
    public List<MenuItem> ORD = new ArrayList();
    public CharSequence agy;
    public Context mContext;

    public m(Context context) {
        AppMethodBeat.i(159211);
        this.mContext = context;
        AppMethodBeat.o(159211);
    }

    public final List<MenuItem> avn() {
        return this.ORD;
    }

    public final boolean gKQ() {
        AppMethodBeat.i(159212);
        if (this.ORD.size() == 0) {
            AppMethodBeat.o(159212);
            return true;
        }
        AppMethodBeat.o(159212);
        return false;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(159213);
        n nVar = new n(this.mContext, i3, i2);
        nVar.setTitle(i5);
        this.ORD.add(nVar);
        AppMethodBeat.o(159213);
        return nVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        AppMethodBeat.i(159214);
        n nVar = new n(this.mContext, i3, i2);
        nVar.setTitle(charSequence);
        this.ORD.add(nVar);
        AppMethodBeat.o(159214);
        return nVar;
    }

    public final MenuItem a(int i2, int i3, CharSequence charSequence, int i4) {
        AppMethodBeat.i(198200);
        n nVar = new n(this.mContext, i3, i2);
        nVar.setTitle(charSequence);
        nVar.setIcon(i4);
        this.ORD.add(nVar);
        AppMethodBeat.o(198200);
        return nVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2) {
        AppMethodBeat.i(159215);
        n nVar = new n(this.mContext, 0, 0);
        nVar.setTitle(i2);
        this.ORD.add(nVar);
        AppMethodBeat.o(159215);
        return nVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        AppMethodBeat.i(159216);
        n nVar = new n(this.mContext, 0, 0);
        nVar.setTitle(charSequence);
        this.ORD.add(nVar);
        AppMethodBeat.o(159216);
        return nVar;
    }

    public final MenuItem aS(int i2, int i3, int i4) {
        AppMethodBeat.i(159217);
        n nVar = new n(this.mContext, i2, 0);
        nVar.setTitle(i3);
        nVar.setIcon(i4);
        this.ORD.add(nVar);
        AppMethodBeat.o(159217);
        return nVar;
    }

    public final MenuItem a(int i2, CharSequence charSequence, Drawable drawable) {
        AppMethodBeat.i(159218);
        n nVar = new n(this.mContext, i2, 0);
        nVar.setTitle(charSequence);
        nVar.setIcon(drawable);
        this.ORD.add(nVar);
        AppMethodBeat.o(159218);
        return nVar;
    }

    public final MenuItem a(int i2, CharSequence charSequence, CharSequence charSequence2, Drawable drawable, boolean z) {
        AppMethodBeat.i(159219);
        n nVar = new n(this.mContext, i2, 0);
        nVar.setTitle(charSequence);
        nVar.xdb = charSequence2;
        nVar.setIcon(drawable);
        nVar.neT = z;
        this.ORD.add(nVar);
        AppMethodBeat.o(159219);
        return nVar;
    }

    public final MenuItem a(int i2, CharSequence charSequence, CharSequence charSequence2, Drawable drawable, int i3, boolean z) {
        AppMethodBeat.i(198201);
        n nVar = new n(this.mContext, i2, 0);
        nVar.setTitle(charSequence);
        nVar.xdb = charSequence2;
        nVar.f(drawable, i3);
        nVar.neT = z;
        this.ORD.add(nVar);
        AppMethodBeat.o(198201);
        return nVar;
    }

    public final MenuItem c(int i2, CharSequence charSequence) {
        AppMethodBeat.i(198202);
        n nVar = new n(this.mContext, i2, 0);
        nVar.setTitle(charSequence);
        nVar.neT = false;
        this.ORD.add(nVar);
        AppMethodBeat.o(198202);
        return nVar;
    }

    public final MenuItem a(int i2, CharSequence charSequence, int i3, boolean z) {
        AppMethodBeat.i(159221);
        n nVar = new n(this.mContext, i2, 0);
        nVar.setTitle(charSequence);
        nVar.setIcon(i3);
        nVar.neT = z;
        this.ORD.add(nVar);
        AppMethodBeat.o(159221);
        return nVar;
    }

    public final MenuItem a(int i2, CharSequence charSequence, CharSequence charSequence2, int i3) {
        AppMethodBeat.i(159222);
        n nVar = new n(this.mContext, i2, 0);
        nVar.setTitle(charSequence);
        nVar.xdb = charSequence2;
        nVar.setIcon(i3);
        this.ORD.add(nVar);
        AppMethodBeat.o(159222);
        return nVar;
    }

    public final MenuItem kV(int i2, int i3) {
        AppMethodBeat.i(159223);
        n nVar = new n(this.mContext, i2, 0);
        nVar.setTitle(i3);
        this.ORD.add(nVar);
        AppMethodBeat.o(159223);
        return nVar;
    }

    public final MenuItem d(int i2, CharSequence charSequence) {
        AppMethodBeat.i(159224);
        n nVar = new n(this.mContext, i2, 0);
        nVar.setTitle(charSequence);
        this.ORD.add(nVar);
        AppMethodBeat.o(159224);
        return nVar;
    }

    public final MenuItem a(int i2, CharSequence charSequence, boolean z) {
        AppMethodBeat.i(179496);
        n nVar = new n(this.mContext, i2, 0);
        nVar.ORE = z;
        nVar.eaY = false;
        nVar.setTitle(charSequence);
        this.ORD.add(nVar);
        AppMethodBeat.o(179496);
        return nVar;
    }

    public final MenuItem b(int i2, CharSequence charSequence, int i3) {
        AppMethodBeat.i(159226);
        n nVar = new n(this.mContext, i2, 0);
        nVar.setTitle(charSequence);
        nVar.setIcon(i3);
        this.ORD.add(nVar);
        AppMethodBeat.o(159226);
        return nVar;
    }

    public final MenuItem c(int i2, CharSequence charSequence, int i3) {
        AppMethodBeat.i(198203);
        n nVar = new n(this.mContext, i2, 0);
        nVar.setTitle(charSequence);
        nVar.setIcon(i3);
        nVar.ORJ = true;
        this.ORD.add(nVar);
        AppMethodBeat.o(198203);
        return nVar;
    }

    public final MenuItem a(int i2, CharSequence charSequence, int i3, int i4) {
        AppMethodBeat.i(159227);
        n nVar = new n(this.mContext, i2, 0);
        nVar.setTitle(charSequence);
        nVar.kW(i3, i4);
        this.ORD.add(nVar);
        AppMethodBeat.o(159227);
        return nVar;
    }

    public final MenuItem a(CharSequence charSequence, CharSequence charSequence2, int i2) {
        AppMethodBeat.i(198204);
        n nVar = new n(this.mContext, 3, 0);
        nVar.setTitle(charSequence);
        nVar.xdb = charSequence2;
        nVar.kW(0, i2);
        this.ORD.add(nVar);
        AppMethodBeat.o(198204);
        return nVar;
    }

    public final MenuItem a(int i2, CharSequence charSequence, int i3, int i4, boolean z) {
        AppMethodBeat.i(159228);
        n nVar = new n(this.mContext, i2, 0);
        nVar.setTitle(charSequence);
        nVar.kW(i3, i4);
        nVar.neT = z;
        this.ORD.add(nVar);
        AppMethodBeat.o(159228);
        return nVar;
    }

    public final MenuItem b(int i2, CharSequence charSequence, boolean z) {
        AppMethodBeat.i(198205);
        n nVar = new n(this.mContext, 45, 0);
        nVar.setTitle(charSequence);
        nVar.kW(0, 0);
        nVar.neT = z;
        this.ORD.add(i2, nVar);
        AppMethodBeat.o(198205);
        return nVar;
    }

    public final MenuItem a(int i2, int i3, CharSequence charSequence) {
        AppMethodBeat.i(159229);
        n nVar = new n(this.mContext, i2, 0);
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i3), 0, spannableString.length(), 0);
        nVar.setTitle(spannableString);
        this.ORD.add(nVar);
        AppMethodBeat.o(159229);
        return nVar;
    }

    public final MenuItem g(MenuItem menuItem) {
        AppMethodBeat.i(159230);
        if (menuItem != null) {
            this.ORD.add(menuItem);
        }
        AppMethodBeat.o(159230);
        return null;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return null;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2) {
        return null;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        return null;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return null;
    }

    public final int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        return 0;
    }

    public final void removeItem(int i2) {
        AppMethodBeat.i(159231);
        ArrayList arrayList = new ArrayList();
        for (MenuItem menuItem : this.ORD) {
            if (menuItem.getItemId() == i2) {
                arrayList.add(menuItem);
            }
        }
        this.ORD.removeAll(arrayList);
        AppMethodBeat.o(159231);
    }

    public final void removeGroup(int i2) {
    }

    public final void clear() {
        AppMethodBeat.i(159232);
        for (MenuItem menuItem : this.ORD) {
            ((n) menuItem).ORH = null;
            ((n) menuItem).setOnMenuItemClickListener(null);
        }
        this.ORD.clear();
        this.agy = null;
        AppMethodBeat.o(159232);
    }

    public final void setGroupCheckable(int i2, boolean z, boolean z2) {
    }

    public final void setGroupVisible(int i2, boolean z) {
    }

    public final void setGroupEnabled(int i2, boolean z) {
    }

    public final boolean hasVisibleItems() {
        return false;
    }

    public final MenuItem findItem(int i2) {
        AppMethodBeat.i(159233);
        for (MenuItem menuItem : this.ORD) {
            if (menuItem.getItemId() == i2) {
                AppMethodBeat.o(159233);
                return menuItem;
            }
        }
        AppMethodBeat.o(159233);
        return null;
    }

    public final int gKR() {
        AppMethodBeat.i(198206);
        int i2 = -1;
        for (MenuItem menuItem : this.ORD) {
            i2++;
            if (menuItem.getItemId() == 7) {
                AppMethodBeat.o(198206);
                return i2;
            }
        }
        AppMethodBeat.o(198206);
        return -1;
    }

    public final int size() {
        AppMethodBeat.i(159234);
        if (this.ORD == null) {
            AppMethodBeat.o(159234);
            return 0;
        }
        int size = this.ORD.size();
        AppMethodBeat.o(159234);
        return size;
    }

    public final MenuItem getItem(int i2) {
        AppMethodBeat.i(159235);
        MenuItem menuItem = this.ORD.get(i2);
        AppMethodBeat.o(159235);
        return menuItem;
    }

    public final void close() {
    }

    public final boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        return false;
    }

    public final boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return false;
    }

    public final boolean performIdentifierAction(int i2, int i3) {
        return false;
    }

    public final void setQwertyMode(boolean z) {
    }

    @Override // android.view.ContextMenu
    public final ContextMenu setHeaderTitle(int i2) {
        AppMethodBeat.i(159236);
        if (i2 > 0) {
            ContextMenu headerTitle = setHeaderTitle(this.mContext.getString(i2));
            AppMethodBeat.o(159236);
            return headerTitle;
        }
        AppMethodBeat.o(159236);
        return this;
    }

    @Override // android.view.ContextMenu
    public final ContextMenu setHeaderTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.agy = charSequence;
        }
        return this;
    }

    @Override // android.view.ContextMenu
    public final ContextMenu setHeaderIcon(int i2) {
        return this;
    }

    @Override // android.view.ContextMenu
    public final ContextMenu setHeaderIcon(Drawable drawable) {
        return this;
    }

    public final ContextMenu setHeaderView(View view) {
        return this;
    }

    public final void clearHeader() {
    }
}
