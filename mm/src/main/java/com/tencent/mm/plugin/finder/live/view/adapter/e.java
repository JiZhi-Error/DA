package com.tencent.mm.plugin.finder.live.view.adapter;

import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\u0011J \u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0018H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R*\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftViewPagerAdapter;", "Landroid/support/v4/view/PagerAdapter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "gridList", "Ljava/util/ArrayList;", "Landroid/widget/GridView;", "Lkotlin/collections/ArrayList;", "getGridList", "()Ljava/util/ArrayList;", "setGridList", "(Ljava/util/ArrayList;)V", "add", "", "", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "getItemPosition", "instantiateItem", "isViewFromObject", "", "p0", "Landroid/view/View;", "p1", "plugin-finder_release"})
public final class e extends q {
    private final String TAG = "FinderLiveGiftViewPagerAdapter";
    public ArrayList<GridView> uAT = new ArrayList<>();

    public e() {
        AppMethodBeat.i(247784);
        AppMethodBeat.o(247784);
    }

    @Override // android.support.v4.view.q
    public final boolean isViewFromObject(View view, Object obj) {
        AppMethodBeat.i(247779);
        p.h(view, "p0");
        p.h(obj, "p1");
        boolean j2 = p.j(view, obj);
        AppMethodBeat.o(247779);
        return j2;
    }

    @Override // android.support.v4.view.q
    public final int getCount() {
        AppMethodBeat.i(247780);
        int size = this.uAT.size();
        AppMethodBeat.o(247780);
        return size;
    }

    @Override // android.support.v4.view.q
    public final int getItemPosition(Object obj) {
        AppMethodBeat.i(247781);
        p.h(obj, "object");
        AppMethodBeat.o(247781);
        return -2;
    }

    @Override // android.support.v4.view.q
    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(247782);
        p.h(viewGroup, "container");
        Log.i(this.TAG, "instantiateItem pos:".concat(String.valueOf(i2)));
        GridView gridView = this.uAT.get(i2);
        p.g(gridView, "gridList[position]");
        GridView gridView2 = gridView;
        viewGroup.addView(gridView2);
        AppMethodBeat.o(247782);
        return gridView2;
    }

    @Override // android.support.v4.view.q
    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        AppMethodBeat.i(247783);
        p.h(viewGroup, "container");
        p.h(obj, "object");
        Log.i(this.TAG, "destroyItem pos:".concat(String.valueOf(i2)));
        viewGroup.removeView((View) obj);
        AppMethodBeat.o(247783);
    }
}
