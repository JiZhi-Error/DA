package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.u;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import java.util.ArrayList;

public final class c implements o {
    public int id;
    public Drawable kA;
    android.support.v7.view.menu.h kE;
    public ColorStateList kT;
    public NavigationMenuView kY;
    public LinearLayout kZ;
    final View.OnClickListener ko = new View.OnClickListener() {
        /* class android.support.design.internal.c.AnonymousClass1 */

        public final void onClick(View view) {
            c.this.q(true);
            android.support.v7.view.menu.j itemData = ((NavigationMenuItemView) view).getItemData();
            boolean a2 = c.this.kE.a(itemData, c.this, 0);
            if (itemData != null && itemData.isCheckable() && a2) {
                c.this.lb.d(itemData);
            }
            c.this.q(false);
            c.this.p(false);
        }
    };
    private o.a la;
    public LayoutInflater layoutInflater;
    public b lb;
    boolean lc;
    public ColorStateList ld;
    public int le;
    public int lf;
    public int lg;
    int lh;
    int textAppearance;

    /* access modifiers changed from: package-private */
    public interface d {
    }

    @Override // android.support.v7.view.menu.o
    public final void a(Context context, android.support.v7.view.menu.h hVar) {
        this.layoutInflater = LayoutInflater.from(context);
        this.kE = hVar;
        this.lh = context.getResources().getDimensionPixelOffset(R.dimen.zk);
    }

    @Override // android.support.v7.view.menu.o
    public final void p(boolean z) {
        if (this.lb != null) {
            b bVar = this.lb;
            bVar.bG();
            bVar.atj.notifyChanged();
        }
    }

    @Override // android.support.v7.view.menu.o
    public final void a(o.a aVar) {
        this.la = aVar;
    }

    @Override // android.support.v7.view.menu.o
    public final boolean a(u uVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public final void a(android.support.v7.view.menu.h hVar, boolean z) {
        if (this.la != null) {
            this.la.a(hVar, z);
        }
    }

    @Override // android.support.v7.view.menu.o
    public final boolean bF() {
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public final boolean b(android.support.v7.view.menu.j jVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public final boolean c(android.support.v7.view.menu.j jVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public final int getId() {
        return this.id;
    }

    @Override // android.support.v7.view.menu.o
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.kY != null) {
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            this.kY.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.lb != null) {
            bundle.putBundle("android:menu:adapter", this.lb.bH());
        }
        if (this.kZ != null) {
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            this.kZ.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // android.support.v7.view.menu.o
    public final void onRestoreInstanceState(Parcelable parcelable) {
        android.support.v7.view.menu.j jVar;
        View actionView;
        ParcelableSparseArray parcelableSparseArray;
        android.support.v7.view.menu.j jVar2;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.kY.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                b bVar = this.lb;
                int i2 = bundle2.getInt("android:menu:checked", 0);
                if (i2 != 0) {
                    bVar.kH = true;
                    int size = bVar.lj.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            break;
                        }
                        d dVar = bVar.lj.get(i3);
                        if ((dVar instanceof f) && (jVar2 = ((f) dVar).ll) != null && jVar2.getItemId() == i2) {
                            bVar.d(jVar2);
                            break;
                        }
                        i3++;
                    }
                    bVar.kH = false;
                    bVar.bG();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = bVar.lj.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        d dVar2 = bVar.lj.get(i4);
                        if (!(!(dVar2 instanceof f) || (jVar = ((f) dVar2).ll) == null || (actionView = jVar.getActionView()) == null || (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray2.get(jVar.getItemId())) == null)) {
                            actionView.restoreHierarchyState(parcelableSparseArray);
                        }
                    }
                }
            }
            SparseArray sparseParcelableArray3 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray3 != null) {
                this.kZ.restoreHierarchyState(sparseParcelableArray3);
            }
        }
    }

    public final void d(android.support.v7.view.menu.j jVar) {
        this.lb.d(jVar);
    }

    public final void setItemIconTintList(ColorStateList colorStateList) {
        this.kT = colorStateList;
        p(false);
    }

    public final void setItemTextColor(ColorStateList colorStateList) {
        this.ld = colorStateList;
        p(false);
    }

    public final void setItemTextAppearance(int i2) {
        this.textAppearance = i2;
        this.lc = true;
        p(false);
    }

    public final void setItemBackground(Drawable drawable) {
        this.kA = drawable;
        p(false);
    }

    public final void setItemHorizontalPadding(int i2) {
        this.le = i2;
        p(false);
    }

    public final void setItemIconPadding(int i2) {
        this.lf = i2;
        p(false);
    }

    public final void q(boolean z) {
        if (this.lb != null) {
            this.lb.kH = z;
        }
    }

    static abstract class j extends RecyclerView.v {
        public j(View view) {
            super(view);
        }
    }

    static class g extends j {
        public g(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.ze, viewGroup, false));
            this.aus.setOnClickListener(onClickListener);
        }
    }

    static class i extends j {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.zh, viewGroup, false));
        }
    }

    static class h extends j {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.zg, viewGroup, false));
        }
    }

    static class a extends j {
        public a(View view) {
            super(view);
        }
    }

    public class b extends RecyclerView.a<j> {
        boolean kH;
        final ArrayList<d> lj = new ArrayList<>();
        public android.support.v7.view.menu.j lk;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(j jVar) {
            j jVar2 = jVar;
            if (jVar2 instanceof g) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar2.aus;
                if (navigationMenuItemView.kS != null) {
                    navigationMenuItemView.kS.removeAllViews();
                }
                navigationMenuItemView.kR.setCompoundDrawables(null, null, null, null);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(j jVar, int i2) {
            j jVar2 = jVar;
            switch (getItemViewType(i2)) {
                case 0:
                    NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar2.aus;
                    navigationMenuItemView.setIconTintList(c.this.kT);
                    if (c.this.lc) {
                        navigationMenuItemView.setTextAppearance(c.this.textAppearance);
                    }
                    if (c.this.ld != null) {
                        navigationMenuItemView.setTextColor(c.this.ld);
                    }
                    android.support.v4.view.u.a(navigationMenuItemView, c.this.kA != null ? c.this.kA.getConstantState().newDrawable() : null);
                    f fVar = (f) this.lj.get(i2);
                    navigationMenuItemView.setNeedsEmptyIcon(fVar.kQ);
                    navigationMenuItemView.setHorizontalPadding(c.this.le);
                    navigationMenuItemView.setIconPadding(c.this.lf);
                    navigationMenuItemView.a(fVar.ll);
                    return;
                case 1:
                    ((TextView) jVar2.aus).setText(((f) this.lj.get(i2)).ll.getTitle());
                    return;
                case 2:
                    e eVar = (e) this.lj.get(i2);
                    jVar2.aus.setPadding(0, eVar.paddingTop, 0, eVar.paddingBottom);
                    return;
                default:
                    return;
            }
        }

        public b() {
            bG();
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final long getItemId(int i2) {
            return (long) i2;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            return this.lj.size();
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            d dVar = this.lj.get(i2);
            if (dVar instanceof e) {
                return 2;
            }
            if (dVar instanceof C0011c) {
                return 3;
            }
            if (!(dVar instanceof f)) {
                throw new RuntimeException("Unknown item type.");
            } else if (((f) dVar).ll.hasSubMenu()) {
                return 1;
            } else {
                return 0;
            }
        }

        /* access modifiers changed from: package-private */
        public final void bG() {
            boolean z;
            int i2;
            int i3;
            if (!this.kH) {
                this.kH = true;
                this.lj.clear();
                this.lj.add(new C0011c());
                int i4 = -1;
                int i5 = 0;
                boolean z2 = false;
                int size = c.this.kE.m1if().size();
                int i6 = 0;
                while (i6 < size) {
                    android.support.v7.view.menu.j jVar = c.this.kE.m1if().get(i6);
                    if (jVar.isChecked()) {
                        d(jVar);
                    }
                    if (jVar.isCheckable()) {
                        jVar.ab(false);
                    }
                    if (jVar.hasSubMenu()) {
                        SubMenu subMenu = jVar.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i6 != 0) {
                                this.lj.add(new e(c.this.lh, 0));
                            }
                            this.lj.add(new f(jVar));
                            boolean z3 = false;
                            int size2 = this.lj.size();
                            int size3 = subMenu.size();
                            for (int i7 = 0; i7 < size3; i7++) {
                                android.support.v7.view.menu.j jVar2 = (android.support.v7.view.menu.j) subMenu.getItem(i7);
                                if (jVar2.isVisible()) {
                                    if (!z3 && jVar2.getIcon() != null) {
                                        z3 = true;
                                    }
                                    if (jVar2.isCheckable()) {
                                        jVar2.ab(false);
                                    }
                                    if (jVar.isChecked()) {
                                        d(jVar);
                                    }
                                    this.lj.add(new f(jVar2));
                                }
                            }
                            if (z3) {
                                n(size2, this.lj.size());
                            }
                        }
                        i3 = i4;
                    } else {
                        int groupId = jVar.getGroupId();
                        if (groupId != i4) {
                            i2 = this.lj.size();
                            z = jVar.getIcon() != null;
                            if (i6 != 0) {
                                i2++;
                                this.lj.add(new e(c.this.lh, c.this.lh));
                            }
                        } else if (z2 || jVar.getIcon() == null) {
                            z = z2;
                            i2 = i5;
                        } else {
                            z = true;
                            n(i5, this.lj.size());
                            i2 = i5;
                        }
                        f fVar = new f(jVar);
                        fVar.kQ = z;
                        this.lj.add(fVar);
                        z2 = z;
                        i5 = i2;
                        i3 = groupId;
                    }
                    i6++;
                    i4 = i3;
                }
                this.kH = false;
            }
        }

        private void n(int i2, int i3) {
            while (i2 < i3) {
                ((f) this.lj.get(i2)).kQ = true;
                i2++;
            }
        }

        public final void d(android.support.v7.view.menu.j jVar) {
            if (this.lk != jVar && jVar.isCheckable()) {
                if (this.lk != null) {
                    this.lk.setChecked(false);
                }
                this.lk = jVar;
                jVar.setChecked(true);
            }
        }

        public final Bundle bH() {
            Bundle bundle = new Bundle();
            if (this.lk != null) {
                bundle.putInt("android:menu:checked", this.lk.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.lj.size();
            for (int i2 = 0; i2 < size; i2++) {
                d dVar = this.lj.get(i2);
                if (dVar instanceof f) {
                    android.support.v7.view.menu.j jVar = ((f) dVar).ll;
                    View actionView = jVar != null ? jVar.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(jVar.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ j a(ViewGroup viewGroup, int i2) {
            switch (i2) {
                case 0:
                    return new g(c.this.layoutInflater, viewGroup, c.this.ko);
                case 1:
                    return new i(c.this.layoutInflater, viewGroup);
                case 2:
                    return new h(c.this.layoutInflater, viewGroup);
                case 3:
                    return new a(c.this.kZ);
                default:
                    return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class f implements d {
        boolean kQ;
        final android.support.v7.view.menu.j ll;

        f(android.support.v7.view.menu.j jVar) {
            this.ll = jVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static class e implements d {
        final int paddingBottom;
        final int paddingTop;

        public e(int i2, int i3) {
            this.paddingTop = i2;
            this.paddingBottom = i3;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.design.internal.c$c  reason: collision with other inner class name */
    public static class C0011c implements d {
        C0011c() {
        }
    }
}
