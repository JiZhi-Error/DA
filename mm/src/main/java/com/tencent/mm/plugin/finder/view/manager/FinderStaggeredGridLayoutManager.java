package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B+\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J(\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u0003H\u0016¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/manager/FinderStaggeredGridLayoutManager;", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "spanCount", "", "orientation", "(II)V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "reflectMarkItemDecorInsetsDirty", "requestSimpleAnimationsInNextLayout", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "smoothScrollToPosition", "recyclerView", "Companion", "plugin-finder_release"})
public class FinderStaggeredGridLayoutManager extends StaggeredGridLayoutManager {
    public static final a wto = new a((byte) 0);

    static {
        AppMethodBeat.i(168540);
        AppMethodBeat.o(168540);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/manager/FinderStaggeredGridLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public FinderStaggeredGridLayoutManager(int i2) {
        super(i2, 1);
    }

    public FinderStaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.StaggeredGridLayoutManager
    public void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(168538);
        try {
            super.onLayoutChildren(nVar, sVar);
            AppMethodBeat.o(168538);
        } catch (IndexOutOfBoundsException e2) {
            Log.printErrStackTrace("Finder.StaggeredGridLayoutManager", e2, "", new Object[0]);
            AppMethodBeat.o(168538);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.StaggeredGridLayoutManager
    public int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(255281);
        if (Log.getLogLevel() <= 1) {
            Log.d("Finder.StaggeredGridLayoutManager", "[scrollVerticallyBy] dy=" + i2 + " state=" + sVar);
        }
        int scrollVerticallyBy = super.scrollVerticallyBy(i2, nVar, sVar);
        AppMethodBeat.o(255281);
        return scrollVerticallyBy;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.StaggeredGridLayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        AppMethodBeat.i(255282);
        if (Log.getLogLevel() <= 1) {
            Log.d("Finder.StaggeredGridLayoutManager", "[smoothScrollToPosition] position=" + i2 + " state=" + sVar);
        }
        super.smoothScrollToPosition(recyclerView, sVar, i2);
        AppMethodBeat.o(255282);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.StaggeredGridLayoutManager
    public void scrollToPosition(int i2) {
        AppMethodBeat.i(255283);
        if (Log.getLogLevel() <= 1) {
            Log.d("Finder.StaggeredGridLayoutManager", "[scrollToPosition] position=" + i2 + ' ');
        }
        super.scrollToPosition(i2);
        AppMethodBeat.o(255283);
    }

    @Override // android.support.v7.widget.StaggeredGridLayoutManager
    public final void ah(int i2, int i3) {
        AppMethodBeat.i(255284);
        if (Log.getLogLevel() <= 1) {
            Log.d("Finder.StaggeredGridLayoutManager", "[scrollToPosition] position=" + i2 + " offset=" + i3);
        }
        super.ah(i2, i3);
        AppMethodBeat.o(255284);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void requestSimpleAnimationsInNextLayout() {
        AppMethodBeat.i(168539);
        super.requestSimpleAnimationsInNextLayout();
        try {
            Method declaredMethod = RecyclerView.class.getDeclaredMethod(LocaleUtil.LAO, new Class[0]);
            p.g(declaredMethod, "RecyclerView::class.java…arkItemDecorInsetsDirty\")");
            declaredMethod.setAccessible(true);
            Field declaredField = RecyclerView.LayoutManager.class.getDeclaredField("mRecyclerView");
            p.g(declaredField, "RecyclerView.LayoutManag…redField(\"mRecyclerView\")");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            if (obj != null) {
                declaredMethod.invoke(obj, new Object[0]);
                Log.i("Finder.StaggeredGridLayoutManager", "markItemDecorInsetsDirty");
                AppMethodBeat.o(168539);
                return;
            }
            AppMethodBeat.o(168539);
        } catch (Exception e2) {
            Log.printErrStackTrace("Finder.StaggeredGridLayoutManager", e2, "", new Object[0]);
            AppMethodBeat.o(168539);
        }
    }
}
