package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

abstract class m implements o, s, AdapterView.OnItemClickListener {
    Rect ahd;

    public abstract void f(h hVar);

    public abstract void setAnchorView(View view);

    public abstract void setForceShowIcon(boolean z);

    public abstract void setGravity(int i2);

    public abstract void setHorizontalOffset(int i2);

    public abstract void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener);

    public abstract void setShowTitle(boolean z);

    public abstract void setVerticalOffset(int i2);

    m() {
    }

    @Override // android.support.v7.view.menu.o
    public final void a(Context context, h hVar) {
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
        return 0;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        a(listAdapter).agm.a((MenuItem) listAdapter.getItem(i2), this, hS() ? 0 : 4);
    }

    protected static int a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i3 = 0;
        int i4 = 0;
        View view = null;
        int i5 = 0;
        FrameLayout frameLayout = viewGroup;
        while (i3 < count) {
            int itemViewType = listAdapter.getItemViewType(i3);
            if (itemViewType != i4) {
                i4 = itemViewType;
                view = null;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i3, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i2) {
                return i2;
            }
            if (measuredWidth <= i5) {
                measuredWidth = i5;
            }
            i3++;
            i5 = measuredWidth;
        }
        return i5;
    }

    protected static g a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (g) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (g) listAdapter;
    }

    protected static boolean h(h hVar) {
        int size = hVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = hVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean hS() {
        return true;
    }
}
