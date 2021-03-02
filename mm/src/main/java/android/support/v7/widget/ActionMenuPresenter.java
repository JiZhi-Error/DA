package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.b;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.n;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.s;
import android.support.v7.view.menu.u;
import android.support.v7.widget.ActionMenuView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.tencent.mm.R;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public final class ActionMenuPresenter extends android.support.v7.view.menu.b implements b.a {
    private boolean aiA;
    private boolean aiB;
    boolean aiC;
    private int aiD;
    private final SparseBooleanArray aiE = new SparseBooleanArray();
    private View aiF;
    e aiG;
    a aiH;
    c aiI;
    private b aiJ;
    final f aiK = new f();
    int aiL;
    d air;
    Drawable ais;
    boolean ait;
    private boolean aiu;
    private boolean aiv;
    private int aiw;
    private int aix;
    private int aiy;
    private boolean aiz;

    public ActionMenuPresenter(Context context) {
        super(context);
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.o
    public final void a(Context context, h hVar) {
        boolean z = true;
        super.a(context, hVar);
        Resources resources = context.getResources();
        android.support.v7.view.a ab = android.support.v7.view.a.ab(context);
        if (!this.aiv) {
            if (Build.VERSION.SDK_INT < 19 && ViewConfiguration.get(ab.mContext).hasPermanentMenuKey()) {
                z = false;
            }
            this.aiu = z;
        }
        if (!this.aiB) {
            this.aiw = ab.mContext.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.aiz) {
            this.aiy = ab.hB();
        }
        int i2 = this.aiw;
        if (this.aiu) {
            if (this.air == null) {
                this.air = new d(this.afe);
                if (this.ait) {
                    this.air.setImageDrawable(this.ais);
                    this.ais = null;
                    this.ait = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.air.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i2 -= this.air.getMeasuredWidth();
        } else {
            this.air = null;
        }
        this.aix = i2;
        this.aiD = (int) (56.0f * resources.getDisplayMetrics().density);
        this.aiF = null;
    }

    public final void iE() {
        if (!this.aiz) {
            this.aiy = android.support.v7.view.a.ab(this.mContext).hB();
        }
        if (this.aaQ != null) {
            this.aaQ.r(true);
        }
    }

    public final void iF() {
        this.aiu = true;
        this.aiv = true;
    }

    @Override // android.support.v7.view.menu.b
    public final p c(ViewGroup viewGroup) {
        p pVar = this.afj;
        p c2 = super.c(viewGroup);
        if (pVar != c2) {
            ((ActionMenuView) c2).setPresenter(this);
        }
        return c2;
    }

    @Override // android.support.v7.view.menu.b
    public final View a(j jVar, View view, ViewGroup viewGroup) {
        View actionView = jVar.getActionView();
        if (actionView == null || jVar.it()) {
            actionView = super.a(jVar, view, viewGroup);
        }
        actionView.setVisibility(jVar.isActionViewExpanded() ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!((ActionMenuView) viewGroup).checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.b(layoutParams));
        }
        return actionView;
    }

    @Override // android.support.v7.view.menu.b
    public final void a(j jVar, p.a aVar) {
        aVar.a(jVar);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.afj);
        if (this.aiJ == null) {
            this.aiJ = new b();
        }
        actionMenuItemView.setPopupCallback(this.aiJ);
    }

    @Override // android.support.v7.view.menu.b
    public final boolean e(j jVar) {
        return jVar.ip();
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.o
    public final void p(boolean z) {
        boolean z2 = true;
        boolean z3 = false;
        super.p(z);
        ((View) this.afj).requestLayout();
        if (this.aaQ != null) {
            h hVar = this.aaQ;
            hVar.ig();
            ArrayList<j> arrayList = hVar.agt;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                android.support.v4.view.b bVar = arrayList.get(i2).agS;
                if (bVar != null) {
                    bVar.Po = this;
                }
            }
        }
        ArrayList<j> ih = this.aaQ != null ? this.aaQ.ih() : null;
        if (this.aiu && ih != null) {
            int size2 = ih.size();
            if (size2 == 1) {
                z3 = !ih.get(0).isActionViewExpanded();
            } else {
                if (size2 <= 0) {
                    z2 = false;
                }
                z3 = z2;
            }
        }
        if (z3) {
            if (this.air == null) {
                this.air = new d(this.afe);
            }
            ViewGroup viewGroup = (ViewGroup) this.air.getParent();
            if (viewGroup != this.afj) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.air);
                }
                ((ActionMenuView) this.afj).addView(this.air, ActionMenuView.iK());
            }
        } else if (this.air != null && this.air.getParent() == this.afj) {
            ((ViewGroup) this.afj).removeView(this.air);
        }
        ((ActionMenuView) this.afj).setOverflowReserved(this.aiu);
    }

    @Override // android.support.v7.view.menu.b
    public final boolean c(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.air) {
            return false;
        }
        return super.c(viewGroup, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.o
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.support.v7.view.menu.u r9) {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionMenuPresenter.a(android.support.v7.view.menu.u):boolean");
    }

    public final boolean showOverflowMenu() {
        if (!this.aiu || isOverflowMenuShowing() || this.aaQ == null || this.afj == null || this.aiI != null || this.aaQ.ih().isEmpty()) {
            return false;
        }
        this.aiI = new c(new e(this.mContext, this.aaQ, this.air));
        ((View) this.afj).post(this.aiI);
        super.a((u) null);
        return true;
    }

    public final boolean hideOverflowMenu() {
        if (this.aiI == null || this.afj == null) {
            e eVar = this.aiG;
            if (eVar == null) {
                return false;
            }
            eVar.dismiss();
            return true;
        }
        ((View) this.afj).removeCallbacks(this.aiI);
        this.aiI = null;
        return true;
    }

    public final boolean iG() {
        return hideOverflowMenu() | iH();
    }

    public final boolean iH() {
        if (this.aiH == null) {
            return false;
        }
        this.aiH.dismiss();
        return true;
    }

    public final boolean isOverflowMenuShowing() {
        return this.aiG != null && this.aiG.isShowing();
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.o
    public final boolean bF() {
        int i2;
        ArrayList<j> arrayList;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8;
        if (this.aaQ != null) {
            ArrayList<j> arrayList2 = this.aaQ.m1if();
            i2 = arrayList2.size();
            arrayList = arrayList2;
        } else {
            i2 = 0;
            arrayList = null;
        }
        int i9 = this.aiy;
        int i10 = this.aix;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.afj;
        int i11 = 0;
        int i12 = 0;
        boolean z2 = false;
        int i13 = 0;
        while (i13 < i2) {
            j jVar = arrayList.get(i13);
            if (jVar.ir()) {
                i11++;
            } else if (jVar.iq()) {
                i12++;
            } else {
                z2 = true;
            }
            if (!this.aiC || !jVar.isActionViewExpanded()) {
                i8 = i9;
            } else {
                i8 = 0;
            }
            i13++;
            i9 = i8;
        }
        if (this.aiu && (z2 || i11 + i12 > i9)) {
            i9--;
        }
        int i14 = i9 - i11;
        SparseBooleanArray sparseBooleanArray = this.aiE;
        sparseBooleanArray.clear();
        int i15 = 0;
        if (this.aiA) {
            i15 = i10 / this.aiD;
            i3 = ((i10 % this.aiD) / i15) + this.aiD;
        } else {
            i3 = 0;
        }
        int i16 = 0;
        int i17 = 0;
        int i18 = i15;
        while (i17 < i2) {
            j jVar2 = arrayList.get(i17);
            if (jVar2.ir()) {
                View a2 = a(jVar2, this.aiF, viewGroup);
                if (this.aiF == null) {
                    this.aiF = a2;
                }
                if (this.aiA) {
                    i7 = i18 - ActionMenuView.f(a2, i3, i18, makeMeasureSpec, 0);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                    i7 = i18;
                }
                int measuredWidth = a2.getMeasuredWidth();
                int i19 = i10 - measuredWidth;
                if (i16 != 0) {
                    measuredWidth = i16;
                }
                int groupId = jVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                jVar2.ae(true);
                i16 = measuredWidth;
                i4 = i7;
                i10 = i19;
            } else if (jVar2.iq()) {
                int groupId2 = jVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i14 > 0 || z3) && i10 > 0 && (!this.aiA || i18 > 0);
                if (z4) {
                    View a3 = a(jVar2, this.aiF, viewGroup);
                    if (this.aiF == null) {
                        this.aiF = a3;
                    }
                    if (this.aiA) {
                        int f2 = ActionMenuView.f(a3, i3, i18, makeMeasureSpec, 0);
                        i18 -= f2;
                        if (f2 == 0) {
                            z4 = false;
                        }
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a3.getMeasuredWidth();
                    i10 -= measuredWidth2;
                    if (i16 == 0) {
                        i16 = measuredWidth2;
                    }
                    if (this.aiA) {
                        z = z4 & (i10 >= 0);
                        i5 = i18;
                    } else {
                        z = z4 & (i10 + i16 > 0);
                        i5 = i18;
                    }
                } else {
                    z = z4;
                    i5 = i18;
                }
                if (z && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                    i6 = i14;
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    int i20 = i14;
                    for (int i21 = 0; i21 < i17; i21++) {
                        j jVar3 = arrayList.get(i21);
                        if (jVar3.getGroupId() == groupId2) {
                            if (jVar3.ip()) {
                                i20++;
                            }
                            jVar3.ae(false);
                        }
                    }
                    i6 = i20;
                } else {
                    i6 = i14;
                }
                if (z) {
                    i6--;
                }
                jVar2.ae(z);
                i4 = i5;
                i14 = i6;
            } else {
                jVar2.ae(false);
                i4 = i18;
            }
            i17++;
            i18 = i4;
        }
        return true;
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.o
    public final void a(h hVar, boolean z) {
        iG();
        super.a(hVar, z);
    }

    @Override // android.support.v7.view.menu.o
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.aiR = this.aiL;
        return savedState;
    }

    @Override // android.support.v7.view.menu.o
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.aiR > 0 && (findItem = this.aaQ.findItem(savedState.aiR)) != null) {
                a((u) findItem.getSubMenu());
            }
        }
    }

    @Override // android.support.v4.view.b.a
    public final void K(boolean z) {
        if (z) {
            super.a((u) null);
        } else if (this.aaQ != null) {
            this.aaQ.aa(false);
        }
    }

    public final void a(ActionMenuView actionMenuView) {
        this.afj = actionMenuView;
        actionMenuView.aaQ = this.aaQ;
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class android.support.v7.widget.ActionMenuPresenter.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        public int aiR;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.aiR = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.aiR);
        }
    }

    /* access modifiers changed from: package-private */
    public class d extends AppCompatImageView implements ActionMenuView.a {
        private final float[] aiO = new float[2];

        public d(Context context) {
            super(context, null, R.attr.ao);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            bb.a(this, getContentDescription());
            setOnTouchListener(new ab(this, ActionMenuPresenter.this) {
                /* class android.support.v7.widget.ActionMenuPresenter.d.AnonymousClass1 */

                @Override // android.support.v7.widget.ab
                public final s hO() {
                    if (ActionMenuPresenter.this.aiG == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.aiG.iu();
                }

                @Override // android.support.v7.widget.ab
                public final boolean hP() {
                    ActionMenuPresenter.this.showOverflowMenu();
                    return true;
                }

                @Override // android.support.v7.widget.ab
                public final boolean iI() {
                    if (ActionMenuPresenter.this.aiI != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.hideOverflowMenu();
                    return true;
                }
            });
        }

        public final boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                ActionMenuPresenter.this.showOverflowMenu();
            }
            return true;
        }

        @Override // android.support.v7.widget.ActionMenuView.a
        public final boolean hM() {
            return false;
        }

        @Override // android.support.v7.widget.ActionMenuView.a
        public final boolean hN() {
            return false;
        }

        /* access modifiers changed from: protected */
        public final boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                android.support.v4.graphics.drawable.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* access modifiers changed from: package-private */
    public class e extends n {
        public e(Context context, h hVar, View view) {
            super(context, hVar, view, true);
            this.afz = 8388613;
            c(ActionMenuPresenter.this.aiK);
        }

        @Override // android.support.v7.view.menu.n
        public final void onDismiss() {
            if (ActionMenuPresenter.this.aaQ != null) {
                ActionMenuPresenter.this.aaQ.close();
            }
            ActionMenuPresenter.this.aiG = null;
            super.onDismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends n {
        public a(Context context, u uVar, View view) {
            super(context, uVar, view, false);
            if (!((j) uVar.getItem()).ip()) {
                this.qK = ActionMenuPresenter.this.air == null ? (View) ActionMenuPresenter.this.afj : ActionMenuPresenter.this.air;
            }
            c(ActionMenuPresenter.this.aiK);
        }

        @Override // android.support.v7.view.menu.n
        public final void onDismiss() {
            ActionMenuPresenter.this.aiH = null;
            ActionMenuPresenter.this.aiL = 0;
            super.onDismiss();
        }
    }

    class f implements o.a {
        f() {
        }

        @Override // android.support.v7.view.menu.o.a
        public final boolean d(h hVar) {
            if (hVar == null) {
                return false;
            }
            ActionMenuPresenter.this.aiL = ((u) hVar).getItem().getItemId();
            o.a aVar = ActionMenuPresenter.this.afg;
            if (aVar != null) {
                return aVar.d(hVar);
            }
            return false;
        }

        @Override // android.support.v7.view.menu.o.a
        public final void a(h hVar, boolean z) {
            if (hVar instanceof u) {
                hVar.ii().aa(false);
            }
            o.a aVar = ActionMenuPresenter.this.afg;
            if (aVar != null) {
                aVar.a(hVar, z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements Runnable {
        private e aiN;

        public c(e eVar) {
            this.aiN = eVar;
        }

        public final void run() {
            if (ActionMenuPresenter.this.aaQ != null) {
                h hVar = ActionMenuPresenter.this.aaQ;
                if (hVar.agq != null) {
                    hVar.agq.b(hVar);
                }
            }
            View view = (View) ActionMenuPresenter.this.afj;
            if (!(view == null || view.getWindowToken() == null || !this.aiN.iv())) {
                ActionMenuPresenter.this.aiG = this.aiN;
            }
            ActionMenuPresenter.this.aiI = null;
        }
    }

    class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // android.support.v7.view.menu.ActionMenuItemView.b
        public final s hO() {
            if (ActionMenuPresenter.this.aiH != null) {
                return ActionMenuPresenter.this.aiH.iu();
            }
            return null;
        }
    }
}
