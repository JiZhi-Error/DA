package android.support.v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.b;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.mm.R;
import java.util.ArrayList;

public final class f implements o, AdapterView.OnItemClickListener {
    h aaQ;
    public o.a afg;
    int afi;
    ExpandedMenuView agg;
    int agh;
    int agi;
    a agj;
    Context mContext;
    private int mId;
    LayoutInflater mInflater;

    public f(Context context) {
        this();
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
    }

    private f() {
        this.afi = R.layout.ax;
        this.agi = 0;
    }

    @Override // android.support.v7.view.menu.o
    public final void a(Context context, h hVar) {
        if (this.agi != 0) {
            this.mContext = new ContextThemeWrapper(context, this.agi);
            this.mInflater = LayoutInflater.from(this.mContext);
        } else if (this.mContext != null) {
            this.mContext = context;
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from(this.mContext);
            }
        }
        this.aaQ = hVar;
        if (this.agj != null) {
            this.agj.notifyDataSetChanged();
        }
    }

    public final p c(ViewGroup viewGroup) {
        if (this.agg == null) {
            this.agg = (ExpandedMenuView) this.mInflater.inflate(R.layout.au, viewGroup, false);
            if (this.agj == null) {
                this.agj = new a();
            }
            this.agg.setAdapter((ListAdapter) this.agj);
            this.agg.setOnItemClickListener(this);
        }
        return this.agg;
    }

    public final ListAdapter getAdapter() {
        if (this.agj == null) {
            this.agj = new a();
        }
        return this.agj;
    }

    @Override // android.support.v7.view.menu.o
    public final void p(boolean z) {
        if (this.agj != null) {
            this.agj.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.o
    public final void a(o.a aVar) {
        this.afg = aVar;
    }

    @Override // android.support.v7.view.menu.o
    public final boolean a(u uVar) {
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        i iVar = new i(uVar);
        h hVar = iVar.aaQ;
        b.a aVar = new b.a(hVar.mContext);
        iVar.agM = new f(aVar.Yu.mContext);
        iVar.agM.afg = iVar;
        iVar.aaQ.a(iVar.agM);
        aVar.Yu.GO = iVar.agM.getAdapter();
        aVar.Yu.Yc = iVar;
        View view = hVar.agA;
        if (view != null) {
            aVar.Yu.XA = view;
        } else {
            aVar.Yu.Xw = hVar.agz;
            aVar.Yu.Hn = hVar.agy;
        }
        aVar.Yu.Ya = iVar;
        iVar.agL = aVar.gz();
        iVar.agL.setOnDismissListener(iVar);
        WindowManager.LayoutParams attributes = iVar.agL.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        iVar.agL.show();
        if (this.afg != null) {
            this.afg.d(uVar);
        }
        return true;
    }

    @Override // android.support.v7.view.menu.o
    public final void a(h hVar, boolean z) {
        if (this.afg != null) {
            this.afg.a(hVar, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.aaQ.a(this.agj.getItem(i2), this, 0);
    }

    @Override // android.support.v7.view.menu.o
    public final boolean bF() {
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

    @Override // android.support.v7.view.menu.o
    public final Parcelable onSaveInstanceState() {
        if (this.agg == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        if (this.agg != null) {
            this.agg.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    @Override // android.support.v7.view.menu.o
    public final void onRestoreInstanceState(Parcelable parcelable) {
        SparseArray<Parcelable> sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.agg.restoreHierarchyState(sparseParcelableArray);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private int agk = -1;

        public a() {
            hV();
        }

        public final int getCount() {
            int size = f.this.aaQ.ih().size() - f.this.agh;
            return this.agk < 0 ? size : size - 1;
        }

        /* renamed from: bv */
        public final j getItem(int i2) {
            ArrayList<j> ih = f.this.aaQ.ih();
            int i3 = f.this.agh + i2;
            if (this.agk >= 0 && i3 >= this.agk) {
                i3++;
            }
            return ih.get(i3);
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            View view2;
            if (view == null) {
                view2 = f.this.mInflater.inflate(f.this.afi, viewGroup, false);
            } else {
                view2 = view;
            }
            ((p.a) view2).a(getItem(i2));
            return view2;
        }

        private void hV() {
            j jVar = f.this.aaQ.agI;
            if (jVar != null) {
                ArrayList<j> ih = f.this.aaQ.ih();
                int size = ih.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (ih.get(i2) == jVar) {
                        this.agk = i2;
                        return;
                    }
                }
            }
            this.agk = -1;
        }

        public final void notifyDataSetChanged() {
            hV();
            super.notifyDataSetChanged();
        }
    }
}
