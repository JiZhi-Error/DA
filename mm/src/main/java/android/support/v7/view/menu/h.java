package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.v;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class h implements android.support.v4.a.a.a {
    private static final int[] agn = {1, 4, 5, 3, 2, 0};
    View agA;
    private boolean agB = false;
    private boolean agC = false;
    private boolean agD = false;
    boolean agE = false;
    private boolean agF = false;
    private ArrayList<j> agG = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<o>> agH = new CopyOnWriteArrayList<>();
    j agI;
    private boolean agJ = false;
    public boolean agK;
    private boolean ago;
    private boolean agp;
    public a agq;
    private ArrayList<j> agr;
    private boolean ags;
    public ArrayList<j> agt;
    private ArrayList<j> agu;
    private boolean agv;
    public int agw = 0;
    private ContextMenu.ContextMenuInfo agx;
    CharSequence agy;
    Drawable agz;
    protected final Context mContext;
    ArrayList<j> mItems;
    private final Resources mResources;

    public interface a {
        boolean a(h hVar, MenuItem menuItem);

        void b(h hVar);
    }

    public interface b {
        boolean f(j jVar);
    }

    public h(Context context) {
        boolean z = true;
        this.mContext = context;
        this.mResources = context.getResources();
        this.mItems = new ArrayList<>();
        this.agr = new ArrayList<>();
        this.ags = true;
        this.agt = new ArrayList<>();
        this.agu = new ArrayList<>();
        this.agv = true;
        this.agp = (this.mResources.getConfiguration().keyboard == 1 || !v.d(ViewConfiguration.get(this.mContext), this.mContext)) ? false : z;
    }

    public final void a(o oVar) {
        a(oVar, this.mContext);
    }

    public final void a(o oVar, Context context) {
        this.agH.add(new WeakReference<>(oVar));
        oVar.a(context, this);
        this.agv = true;
    }

    public final void b(o oVar) {
        Iterator<WeakReference<o>> it = this.agH.iterator();
        while (it.hasNext()) {
            WeakReference<o> next = it.next();
            o oVar2 = next.get();
            if (oVar2 == null || oVar2 == oVar) {
                this.agH.remove(next);
            }
        }
    }

    private boolean a(u uVar, o oVar) {
        boolean z;
        boolean z2 = false;
        if (this.agH.isEmpty()) {
            return false;
        }
        if (oVar != null) {
            z2 = oVar.a(uVar);
        }
        Iterator<WeakReference<o>> it = this.agH.iterator();
        boolean z3 = z2;
        while (it.hasNext()) {
            WeakReference<o> next = it.next();
            o oVar2 = next.get();
            if (oVar2 == null) {
                this.agH.remove(next);
            } else {
                if (!z3) {
                    z = oVar2.a(uVar);
                } else {
                    z = z3;
                }
                z3 = z;
            }
        }
        return z3;
    }

    private void dispatchSaveInstanceState(Bundle bundle) {
        Parcelable onSaveInstanceState;
        if (!this.agH.isEmpty()) {
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            Iterator<WeakReference<o>> it = this.agH.iterator();
            while (it.hasNext()) {
                WeakReference<o> next = it.next();
                o oVar = next.get();
                if (oVar == null) {
                    this.agH.remove(next);
                } else {
                    int id = oVar.getId();
                    if (id > 0 && (onSaveInstanceState = oVar.onSaveInstanceState()) != null) {
                        sparseArray.put(id, onSaveInstanceState);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    public final void dispatchRestoreInstanceState(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.agH.isEmpty()) {
            Iterator<WeakReference<o>> it = this.agH.iterator();
            while (it.hasNext()) {
                WeakReference<o> next = it.next();
                o oVar = next.get();
                if (oVar == null) {
                    this.agH.remove(next);
                } else {
                    int id = oVar.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        oVar.onRestoreInstanceState(parcelable);
                    }
                }
            }
        }
    }

    public final void e(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public final void f(Bundle bundle) {
        SparseArray<? extends Parcelable> sparseArray = null;
        int size = size();
        int i2 = 0;
        while (i2 < size) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((u) item.getSubMenu()).f(bundle);
            }
            i2++;
            sparseArray = sparseArray;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(hW(), sparseArray);
        }
    }

    public final void g(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(hW());
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = getItem(i2);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((u) item.getSubMenu()).g(bundle);
                }
            }
            int i3 = bundle.getInt("android:menu:expandedactionview");
            if (i3 > 0 && (findItem = findItem(i3)) != null) {
                findItem.expandActionView();
            }
        }
    }

    /* access modifiers changed from: protected */
    public String hW() {
        return "android:menu:actionviewstates";
    }

    public void a(a aVar) {
        this.agq = aVar;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return a(0, 0, 0, this.mResources.getString(i2));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.mResources.getString(i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, this.mResources.getString(i2));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        j jVar = (j) a(i2, i3, i4, charSequence);
        u uVar = new u(this.mContext, this, jVar);
        jVar.b(uVar);
        return uVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, this.mResources.getString(i5));
    }

    public void setGroupDividerEnabled(boolean z) {
        this.agJ = z;
    }

    public boolean hX() {
        return this.agJ;
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        Intent intent2;
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeGroup(int i2) {
        int i3;
        int size = size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                i3 = -1;
                break;
            } else if (this.mItems.get(i4).getGroupId() == i2) {
                i3 = i4;
                break;
            } else {
                i4++;
            }
        }
        if (i3 >= 0) {
            int size2 = this.mItems.size() - i3;
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (i5 >= size2 || this.mItems.get(i3).getGroupId() != i2) {
                    r(true);
                } else {
                    h(i3, false);
                    i5 = i6;
                }
            }
            r(true);
        }
    }

    private void h(int i2, boolean z) {
        if (i2 >= 0 && i2 < this.mItems.size()) {
            this.mItems.remove(i2);
            if (z) {
                r(true);
            }
        }
    }

    public void clear() {
        if (this.agI != null) {
            h(this.agI);
        }
        this.mItems.clear();
        r(true);
    }

    public void setGroupCheckable(int i2, boolean z, boolean z2) {
        int size = this.mItems.size();
        for (int i3 = 0; i3 < size; i3++) {
            j jVar = this.mItems.get(i3);
            if (jVar.getGroupId() == i2) {
                jVar.ab(z2);
                jVar.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i2, boolean z) {
        boolean z2;
        int size = this.mItems.size();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < size) {
            j jVar = this.mItems.get(i3);
            if (jVar.getGroupId() != i2 || !jVar.ad(z)) {
                z2 = z3;
            } else {
                z2 = true;
            }
            i3++;
            z3 = z2;
        }
        if (z3) {
            r(true);
        }
    }

    public void setGroupEnabled(int i2, boolean z) {
        int size = this.mItems.size();
        for (int i3 = 0; i3 < size; i3++) {
            j jVar = this.mItems.get(i3);
            if (jVar.getGroupId() == i2) {
                jVar.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.agK) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mItems.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i2) {
        MenuItem findItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            j jVar = this.mItems.get(i3);
            if (jVar.getItemId() == i2) {
                return jVar;
            }
            if (jVar.hasSubMenu() && (findItem = jVar.getSubMenu().findItem(i2)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public int size() {
        return this.mItems.size();
    }

    public MenuItem getItem(int i2) {
        return this.mItems.get(i2);
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return a(i2, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.ago = z;
        r(false);
    }

    /* access modifiers changed from: package-private */
    public boolean hY() {
        return this.ago;
    }

    public boolean hZ() {
        return this.agp;
    }

    /* access modifiers changed from: package-private */
    public boolean d(h hVar, MenuItem menuItem) {
        return this.agq != null && this.agq.a(hVar, menuItem);
    }

    private static int b(ArrayList<j> arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).aeG <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        j a2 = a(i2, keyEvent);
        boolean z = false;
        if (a2 != null) {
            z = a(a2, (o) null, i3);
        }
        if ((i3 & 2) != 0) {
            aa(true);
        }
        return z;
    }

    private void a(List<j> list, int i2, KeyEvent keyEvent) {
        boolean hY = hY();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.mItems.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar = this.mItems.get(i3);
                if (jVar.hasSubMenu()) {
                    ((h) jVar.getSubMenu()).a(list, i2, keyEvent);
                }
                char alphabeticShortcut = hY ? jVar.getAlphabeticShortcut() : jVar.getNumericShortcut();
                if (((modifiers & 69647) == ((hY ? jVar.getAlphabeticModifiers() : jVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (hY && alphabeticShortcut == '\b' && i2 == 67)) && jVar.isEnabled())) {
                    list.add(jVar);
                }
            }
        }
    }

    private j a(int i2, KeyEvent keyEvent) {
        char numericShortcut;
        ArrayList<j> arrayList = this.agG;
        arrayList.clear();
        a(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean hY = hY();
        for (int i3 = 0; i3 < size; i3++) {
            j jVar = arrayList.get(i3);
            if (hY) {
                numericShortcut = jVar.getAlphabeticShortcut();
            } else {
                numericShortcut = jVar.getNumericShortcut();
            }
            if (numericShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return jVar;
            }
            if (numericShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return jVar;
            }
            if (hY && numericShortcut == '\b' && i2 == 67) {
                return jVar;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return a(findItem(i2), (o) null, i3);
    }

    public final boolean a(MenuItem menuItem, o oVar, int i2) {
        boolean z;
        j jVar = (j) menuItem;
        if (jVar == null || !jVar.isEnabled()) {
            return false;
        }
        boolean ij = jVar.ij();
        android.support.v4.view.b bVar = jVar.agS;
        if (bVar == null || !bVar.hasSubMenu()) {
            z = false;
        } else {
            z = true;
        }
        if (jVar.it()) {
            boolean expandActionView = jVar.expandActionView() | ij;
            if (!expandActionView) {
                return expandActionView;
            }
            aa(true);
            return expandActionView;
        } else if (jVar.hasSubMenu() || z) {
            if ((i2 & 4) == 0) {
                aa(false);
            }
            if (!jVar.hasSubMenu()) {
                jVar.b(new u(this.mContext, this, jVar));
            }
            u uVar = (u) jVar.getSubMenu();
            if (z) {
                bVar.onPrepareSubMenu(uVar);
            }
            boolean a2 = a(uVar, oVar) | ij;
            if (a2) {
                return a2;
            }
            aa(true);
            return a2;
        } else {
            if ((i2 & 1) == 0) {
                aa(true);
            }
            return ij;
        }
    }

    public final void aa(boolean z) {
        if (!this.agF) {
            this.agF = true;
            Iterator<WeakReference<o>> it = this.agH.iterator();
            while (it.hasNext()) {
                WeakReference<o> next = it.next();
                o oVar = next.get();
                if (oVar == null) {
                    this.agH.remove(next);
                } else {
                    oVar.a(this, z);
                }
            }
            this.agF = false;
        }
    }

    public void close() {
        aa(true);
    }

    public void r(boolean z) {
        if (!this.agB) {
            if (z) {
                this.ags = true;
                this.agv = true;
            }
            if (!this.agH.isEmpty()) {
                ia();
                Iterator<WeakReference<o>> it = this.agH.iterator();
                while (it.hasNext()) {
                    WeakReference<o> next = it.next();
                    o oVar = next.get();
                    if (oVar == null) {
                        this.agH.remove(next);
                    } else {
                        oVar.p(z);
                    }
                }
                ib();
                return;
            }
            return;
        }
        this.agC = true;
        if (z) {
            this.agD = true;
        }
    }

    public final void ia() {
        if (!this.agB) {
            this.agB = true;
            this.agC = false;
            this.agD = false;
        }
    }

    public final void ib() {
        this.agB = false;
        if (this.agC) {
            this.agC = false;
            r(this.agD);
        }
    }

    /* access modifiers changed from: package-private */
    public final void ic() {
        this.ags = true;
        r(true);
    }

    /* access modifiers changed from: package-private */
    public final void ie() {
        this.agv = true;
        r(true);
    }

    /* renamed from: if  reason: not valid java name */
    public final ArrayList<j> m1if() {
        if (!this.ags) {
            return this.agr;
        }
        this.agr.clear();
        int size = this.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = this.mItems.get(i2);
            if (jVar.isVisible()) {
                this.agr.add(jVar);
            }
        }
        this.ags = false;
        this.agv = true;
        return this.agr;
    }

    public final void ig() {
        ArrayList<j> arrayList = m1if();
        if (this.agv) {
            Iterator<WeakReference<o>> it = this.agH.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<o> next = it.next();
                o oVar = next.get();
                if (oVar == null) {
                    this.agH.remove(next);
                } else {
                    z = oVar.bF() | z;
                }
            }
            if (z) {
                this.agt.clear();
                this.agu.clear();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    j jVar = arrayList.get(i2);
                    if (jVar.ip()) {
                        this.agt.add(jVar);
                    } else {
                        this.agu.add(jVar);
                    }
                }
            } else {
                this.agt.clear();
                this.agu.clear();
                this.agu.addAll(m1if());
            }
            this.agv = false;
        }
    }

    public final ArrayList<j> ih() {
        ig();
        return this.agu;
    }

    public void clearHeader() {
        this.agz = null;
        this.agy = null;
        this.agA = null;
        r(false);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources resources = this.mResources;
        if (view != null) {
            this.agA = view;
            this.agy = null;
            this.agz = null;
        } else {
            if (i2 > 0) {
                this.agy = resources.getText(i2);
            } else if (charSequence != null) {
                this.agy = charSequence;
            }
            if (i3 > 0) {
                this.agz = android.support.v4.content.b.l(this.mContext, i3);
            } else if (drawable != null) {
                this.agz = drawable;
            }
            this.agA = null;
        }
        r(false);
    }

    public h ii() {
        return this;
    }

    public boolean g(j jVar) {
        boolean z = false;
        if (!this.agH.isEmpty()) {
            ia();
            Iterator<WeakReference<o>> it = this.agH.iterator();
            boolean z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                WeakReference<o> next = it.next();
                o oVar = next.get();
                if (oVar == null) {
                    this.agH.remove(next);
                } else {
                    z = oVar.b(jVar);
                    if (z) {
                        break;
                    }
                    z2 = z;
                }
            }
            ib();
            if (z) {
                this.agI = jVar;
            }
        }
        return z;
    }

    public boolean h(j jVar) {
        boolean z = false;
        if (!this.agH.isEmpty() && this.agI == jVar) {
            ia();
            Iterator<WeakReference<o>> it = this.agH.iterator();
            boolean z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                WeakReference<o> next = it.next();
                o oVar = next.get();
                if (oVar == null) {
                    this.agH.remove(next);
                } else {
                    z = oVar.c(jVar);
                    if (z) {
                        break;
                    }
                    z2 = z;
                }
            }
            ib();
            if (z) {
                this.agI = null;
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int i5 = (-65536 & i4) >> 16;
        if (i5 < 0 || i5 >= agn.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i6 = (agn[i5] << 16) | (65535 & i4);
        j jVar = new j(this, i2, i3, i4, i6, charSequence, this.agw);
        if (this.agx != null) {
            jVar.agV = this.agx;
        }
        this.mItems.add(b(this.mItems, i6), jVar);
        r(true);
        return jVar;
    }

    public void removeItem(int i2) {
        int i3;
        int size = size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                i3 = -1;
                break;
            } else if (this.mItems.get(i4).getItemId() == i2) {
                i3 = i4;
                break;
            } else {
                i4++;
            }
        }
        h(i3, true);
    }
}
