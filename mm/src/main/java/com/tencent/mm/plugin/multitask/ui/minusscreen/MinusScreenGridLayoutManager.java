package com.tencent.mm.plugin.multitask.ui.minusscreen;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000  2\u00020\u0001:\u0001 B\u0019\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B)\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J(\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u001f\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0005H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutManager;", "Landroid/support/v7/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "orientation", "reverseLayout", "", "(Landroid/content/Context;IIZ)V", "mMultiTaskRecycleView", "Landroid/support/v7/widget/RecyclerView;", "mPreTransY", "", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "reflectMarkItemDecorInsetsDirty", "requestSimpleAnimationsInNextLayout", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "setMultiTaskRecyclerView", "recyclerView", "smoothScrollToPosition", "Companion", "ui-multitask_release"})
public class MinusScreenGridLayoutManager extends GridLayoutManager {
    public static final a AdO = new a((byte) 0);
    public RecyclerView AdM;
    private float AdN;

    static {
        AppMethodBeat.i(236447);
        AppMethodBeat.o(236447);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutManager$Companion;", "", "()V", "TAG", "", "ui-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public MinusScreenGridLayoutManager(Context context, int i2) {
        super(i2);
    }

    @Override // android.support.v7.widget.GridLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(236441);
        try {
            super.onLayoutChildren(nVar, sVar);
            AppMethodBeat.o(236441);
        } catch (IndexOutOfBoundsException e2) {
            Log.printErrStackTrace("MicroMsg.MultiTask.MinusScreenGridLayoutManager", e2, "", new Object[0]);
            AppMethodBeat.o(236441);
        }
    }

    @Override // android.support.v7.widget.GridLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(236442);
        RecyclerView recyclerView = this.AdM;
        float translationY = recyclerView != null ? recyclerView.getTranslationY() : 0.0f;
        if (translationY == 0.0f || this.AdN * translationY < 0.0f) {
            if (translationY == 0.0f) {
                this.AdN = 0.0f;
            } else if (this.AdN * translationY < 0.0f) {
                RecyclerView recyclerView2 = this.AdM;
                if (recyclerView2 != null) {
                    recyclerView2.setTranslationY(0.0f);
                }
                this.AdN = translationY;
            }
            Log.d("MicroMsg.MultiTask.MinusScreenGridLayoutManager", "currentTransY: " + translationY + ", preTransY: " + this.AdN);
            int scrollVerticallyBy = super.scrollVerticallyBy(i2, nVar, sVar);
            AppMethodBeat.o(236442);
            return scrollVerticallyBy;
        }
        this.AdN = translationY;
        Log.d("MicroMsg.MultiTask.MinusScreenGridLayoutManager", "currentTransY: " + translationY + ", preTransY: " + this.AdN);
        AppMethodBeat.o(236442);
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        AppMethodBeat.i(236443);
        super.smoothScrollToPosition(recyclerView, sVar, i2);
        AppMethodBeat.o(236443);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public void scrollToPosition(int i2) {
        AppMethodBeat.i(236444);
        super.scrollToPosition(i2);
        AppMethodBeat.o(236444);
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public final void ah(int i2, int i3) {
        AppMethodBeat.i(236445);
        super.ah(i2, i3);
        AppMethodBeat.o(236445);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void requestSimpleAnimationsInNextLayout() {
        AppMethodBeat.i(236446);
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
                Log.i("MicroMsg.MultiTask.MinusScreenGridLayoutManager", "markItemDecorInsetsDirty");
                AppMethodBeat.o(236446);
                return;
            }
            AppMethodBeat.o(236446);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MultiTask.MinusScreenGridLayoutManager", e2, "", new Object[0]);
            AppMethodBeat.o(236446);
        }
    }
}
