package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0001/B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010%\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020\tH\u0016J\b\u0010'\u001a\u00020\u0005H\u0002J\u0012\u0010(\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u0005H\u0016J\u0006\u0010,\u001a\u00020\u001bJ\u0010\u0010-\u001a\u00020\u001b2\b\b\u0002\u0010.\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013RL\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "getContext", "()Landroid/content/Context;", "forceUpdateOnNextLayout", "getItemCount", "Lkotlin/Function0;", "getGetItemCount", "()Lkotlin/jvm/functions/Function0;", "setGetItemCount", "(Lkotlin/jvm/functions/Function0;)V", "onItemSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Landroid/view/View;", "child", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function2;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function2;)V", "scrollState", "<set-?>", "selectedPosition", "getSelectedPosition", "()I", "canScrollHorizontally", "canScrollVertically", "findSelectedChildIndex", "onLayoutCompleted", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onScrollStateChanged", "setForceUpdateOnNextLayout", "updateSelectedChild", "force", "Companion", "plugin-finder_release"})
public final class FinderLiveLayoutManager extends LinearLayoutManager {
    private static final String TAG = TAG;
    public static final a uyL = new a((byte) 0);
    private final Context context;
    public boolean uyI;
    public m<? super Integer, ? super View, x> uyJ;
    public kotlin.g.a.a<Integer> uyK;
    private int va = -1;
    private int vp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveLayoutManager(Context context2, int i2) {
        super(i2, false);
        p.h(context2, "context");
        AppMethodBeat.i(260837);
        this.context = context2;
        AppMethodBeat.o(260837);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(247469);
        AppMethodBeat.o(247469);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void onLayoutCompleted(RecyclerView.s sVar) {
        AppMethodBeat.i(247462);
        super.onLayoutCompleted(sVar);
        nz(this.uyI);
        this.uyI = false;
        AppMethodBeat.o(247462);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public final void onScrollStateChanged(int i2) {
        AppMethodBeat.i(247463);
        super.onScrollStateChanged(i2);
        this.vp = i2;
        if (this.vp == 0) {
            nz(false);
        }
        AppMethodBeat.o(247463);
    }

    private void nz(boolean z) {
        AppMethodBeat.i(247464);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.hd(TAG, "updateSelectedChild: force ".concat(String.valueOf(z)));
        int div = div();
        if (div >= 0) {
            View childAt = getChildAt(div);
            if (childAt == null) {
                p.hyc();
            }
            p.g(childAt, "getChildAt(selectedChildIndex)!!");
            int position = getPosition(childAt);
            if (position != this.va || z) {
                this.va = position;
                m<? super Integer, ? super View, x> mVar2 = this.uyJ;
                if (mVar2 != null) {
                    mVar2.invoke(Integer.valueOf(this.va), childAt);
                    AppMethodBeat.o(247464);
                    return;
                }
            }
        }
        AppMethodBeat.o(247464);
    }

    private final int div() {
        int i2 = 0;
        AppMethodBeat.i(247465);
        if (getChildCount() != 1) {
            if (!super.canScrollHorizontally()) {
                int height = getHeight() / 2;
                int childCount = getChildCount();
                while (true) {
                    if (i2 < childCount) {
                        View childAt = getChildAt(i2);
                        if (childAt == null) {
                            p.hyc();
                        }
                        p.g(childAt, "getChildAt(i)!!");
                        int top = childAt.getTop();
                        View childAt2 = getChildAt(i2);
                        if (childAt2 == null) {
                            p.hyc();
                        }
                        p.g(childAt2, "getChildAt(i)!!");
                        if ((top + childAt2.getBottom()) / 2 == height) {
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            } else {
                int width = getWidth() / 2;
                int childCount2 = getChildCount();
                while (true) {
                    if (i2 < childCount2) {
                        View childAt3 = getChildAt(i2);
                        if (childAt3 == null) {
                            p.hyc();
                        }
                        p.g(childAt3, "getChildAt(i)!!");
                        int left = childAt3.getLeft();
                        View childAt4 = getChildAt(i2);
                        if (childAt4 == null) {
                            p.hyc();
                        }
                        p.g(childAt4, "getChildAt(i)!!");
                        if ((left + childAt4.getRight()) / 2 == width) {
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
            i2 = -1;
        }
        AppMethodBeat.o(247465);
        return i2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final boolean canScrollVertically() {
        Integer invoke;
        AppMethodBeat.i(247466);
        if (getOrientation() == 1) {
            Resources resources = this.context.getResources();
            p.g(resources, "context.resources");
            if (resources.getConfiguration().orientation == 1) {
                kotlin.g.a.a<Integer> aVar = this.uyK;
                if (((aVar == null || (invoke = aVar.invoke()) == null) ? 0 : invoke.intValue()) > 1) {
                    AppMethodBeat.o(247466);
                    return true;
                }
            }
        }
        AppMethodBeat.o(247466);
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final boolean canScrollHorizontally() {
        AppMethodBeat.i(247467);
        boolean canScrollHorizontally = super.canScrollHorizontally();
        AppMethodBeat.o(247467);
        return canScrollHorizontally;
    }
}
