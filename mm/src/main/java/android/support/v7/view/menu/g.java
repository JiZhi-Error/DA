package android.support.v7.view.menu;

import android.support.v7.view.menu.p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public final class g extends BaseAdapter {
    boolean afG;
    private final int afi;
    private final boolean afr;
    private int agk = -1;
    public h agm;
    private final LayoutInflater mInflater;

    public g(h hVar, LayoutInflater layoutInflater, boolean z, int i2) {
        this.afr = z;
        this.mInflater = layoutInflater;
        this.agm = hVar;
        this.afi = i2;
        hV();
    }

    public final int getCount() {
        ArrayList<j> ih = this.afr ? this.agm.ih() : this.agm.m1if();
        if (this.agk < 0) {
            return ih.size();
        }
        return ih.size() - 1;
    }

    /* renamed from: bv */
    public final j getItem(int i2) {
        ArrayList<j> ih = this.afr ? this.agm.ih() : this.agm.m1if();
        if (this.agk >= 0 && i2 >= this.agk) {
            i2++;
        }
        return ih.get(i2);
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        boolean z;
        if (view == null) {
            view2 = this.mInflater.inflate(this.afi, viewGroup, false);
        } else {
            view2 = view;
        }
        int groupId = getItem(i2).getGroupId();
        int groupId2 = i2 + -1 >= 0 ? getItem(i2 - 1).getGroupId() : groupId;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view2;
        if (!this.agm.hX() || groupId == groupId2) {
            z = false;
        } else {
            z = true;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        p.a aVar = (p.a) view2;
        if (this.afG) {
            ((ListMenuItemView) view2).setForceShowIcon(true);
        }
        aVar.a(getItem(i2));
        return view2;
    }

    private void hV() {
        j jVar = this.agm.agI;
        if (jVar != null) {
            ArrayList<j> ih = this.agm.ih();
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
