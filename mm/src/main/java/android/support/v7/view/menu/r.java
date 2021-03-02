package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.a.a.a;
import android.support.v4.a.a.b;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;

/* access modifiers changed from: package-private */
public class r extends c<a> implements Menu {
    r(Context context, a aVar) {
        super(context, aVar);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return b(((a) this.afm).add(charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return b(((a) this.afm).add(i2));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return b(((a) this.afm).add(i2, i3, i4, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return b(((a) this.afm).add(i2, i3, i4, i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(((a) this.afm).addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return a(((a) this.afm).addSubMenu(i2));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        return a(((a) this.afm).addSubMenu(i2, i3, i4, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return a(((a) this.afm).addSubMenu(i2, i3, i4, i5));
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((a) this.afm).addIntentOptions(i2, i3, i4, componentName, intentArr, intent, i5, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i6 = 0; i6 < length; i6++) {
                menuItemArr[i6] = b(menuItemArr2[i6]);
            }
        }
        return addIntentOptions;
    }

    public void setGroupCheckable(int i2, boolean z, boolean z2) {
        ((a) this.afm).setGroupCheckable(i2, z, z2);
    }

    public void setGroupVisible(int i2, boolean z) {
        ((a) this.afm).setGroupVisible(i2, z);
    }

    public void setGroupEnabled(int i2, boolean z) {
        ((a) this.afm).setGroupEnabled(i2, z);
    }

    public boolean hasVisibleItems() {
        return ((a) this.afm).hasVisibleItems();
    }

    public MenuItem findItem(int i2) {
        return b(((a) this.afm).findItem(i2));
    }

    public int size() {
        return ((a) this.afm).size();
    }

    public MenuItem getItem(int i2) {
        return b(((a) this.afm).getItem(i2));
    }

    public void close() {
        ((a) this.afm).close();
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        return ((a) this.afm).performShortcut(i2, keyEvent, i3);
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return ((a) this.afm).isShortcutKey(i2, keyEvent);
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return ((a) this.afm).performIdentifierAction(i2, i3);
    }

    public void setQwertyMode(boolean z) {
        ((a) this.afm).setQwertyMode(z);
    }

    public void removeItem(int i2) {
        if (this.afk != null) {
            Iterator<b> it = this.afk.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (i2 == it.next().getItemId()) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        ((a) this.afm).removeItem(i2);
    }

    public void removeGroup(int i2) {
        if (this.afk != null) {
            Iterator<b> it = this.afk.keySet().iterator();
            while (it.hasNext()) {
                if (i2 == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
        ((a) this.afm).removeGroup(i2);
    }

    public void clear() {
        if (this.afk != null) {
            this.afk.clear();
        }
        if (this.afl != null) {
            this.afl.clear();
        }
        ((a) this.afm).clear();
    }
}
