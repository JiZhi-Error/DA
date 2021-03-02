package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import java.util.ArrayList;

public abstract class b implements o {
    public h aaQ;
    protected Context afe;
    protected LayoutInflater aff;
    public o.a afg;
    private int afh = R.layout.ak;
    private int afi = R.layout.aj;
    public p afj;
    protected Context mContext;
    public int mId;
    protected LayoutInflater mInflater;

    public abstract void a(j jVar, p.a aVar);

    public b(Context context) {
        this.afe = context;
        this.aff = LayoutInflater.from(context);
    }

    @Override // android.support.v7.view.menu.o
    public void a(Context context, h hVar) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.aaQ = hVar;
    }

    public p c(ViewGroup viewGroup) {
        if (this.afj == null) {
            this.afj = (p) this.aff.inflate(this.afh, viewGroup, false);
            this.afj.a(this.aaQ);
            p(true);
        }
        return this.afj;
    }

    @Override // android.support.v7.view.menu.o
    public void p(boolean z) {
        int i2;
        int i3;
        ViewGroup viewGroup = (ViewGroup) this.afj;
        if (viewGroup != null) {
            if (this.aaQ != null) {
                this.aaQ.ig();
                ArrayList<j> arrayList = this.aaQ.m1if();
                int size = arrayList.size();
                int i4 = 0;
                i2 = 0;
                while (i4 < size) {
                    j jVar = arrayList.get(i4);
                    if (e(jVar)) {
                        View childAt = viewGroup.getChildAt(i2);
                        j itemData = childAt instanceof p.a ? ((p.a) childAt).getItemData() : null;
                        View a2 = a(jVar, childAt, viewGroup);
                        if (jVar != itemData) {
                            a2.setPressed(false);
                            a2.jumpDrawablesToCurrentState();
                        }
                        if (a2 != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a2.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a2);
                            }
                            ((ViewGroup) this.afj).addView(a2, i2);
                        }
                        i3 = i2 + 1;
                    } else {
                        i3 = i2;
                    }
                    i4++;
                    i2 = i3;
                }
            } else {
                i2 = 0;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (!c(viewGroup, i2)) {
                    i2++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean c(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    @Override // android.support.v7.view.menu.o
    public final void a(o.a aVar) {
        this.afg = aVar;
    }

    public View a(j jVar, View view, ViewGroup viewGroup) {
        p.a aVar;
        if (view instanceof p.a) {
            aVar = (p.a) view;
        } else {
            aVar = (p.a) this.aff.inflate(this.afi, viewGroup, false);
        }
        a(jVar, aVar);
        return (View) aVar;
    }

    public boolean e(j jVar) {
        return true;
    }

    @Override // android.support.v7.view.menu.o
    public void a(h hVar, boolean z) {
        if (this.afg != null) {
            this.afg.a(hVar, z);
        }
    }

    @Override // android.support.v7.view.menu.o
    public boolean a(u uVar) {
        if (this.afg != null) {
            return this.afg.d(uVar);
        }
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public boolean bF() {
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public final boolean b(j jVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public final boolean c(j jVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public final int getId() {
        return this.mId;
    }
}
