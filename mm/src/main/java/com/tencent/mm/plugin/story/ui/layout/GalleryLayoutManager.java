package com.tencent.mm.plugin.story.ui.layout;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010&\u001a\u00020\tH\u0016J\b\u0010'\u001a\u00020\tH\u0016J\b\u0010(\u001a\u00020\u0005H\u0002J \u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0016J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+H\u0016J \u0010/\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0016J \u00100\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0016J\u0012\u00101\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0010\u00104\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0005H\u0016J$\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\n\u00107\u001a\u000608R\u00020+2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00109\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J$\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00052\n\u00107\u001a\u000608R\u00020+2\u0006\u00102\u001a\u000203H\u0016J\b\u0010<\u001a\u00020\u0017H\u0002J\u0010\u0010=\u001a\u00020\u00172\b\b\u0002\u0010>\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRL\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bRL\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001bR\u000e\u0010!\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "forceUpdateOnNextLayout", "isScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "onItemSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Landroid/view/View;", "child", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function2;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function2;)V", "scrollCallback", "", "offset", "getScrollCallback", "setScrollCallback", "scrollState", "<set-?>", "selectedPosition", "getSelectedPosition", "()I", "canScrollHorizontally", "canScrollVertically", "findSelectedChildIndex", "onItemsAdded", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "positionStart", "itemCount", "onItemsChanged", "onItemsRemoved", "onItemsUpdated", "onLayoutCompleted", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "scrollToPosition", "scrollVerticallyBy", "dy", "updateScroll", "updateSelectedChild", "force", "Companion", "plugin-story_release"})
public final class GalleryLayoutManager extends LinearLayoutManager {
    public static final a FzN = new a((byte) 0);
    private static final String TAG = TAG;
    public m<? super Integer, ? super Float, x> FzM;
    public boolean hbX;
    private boolean uyI;
    public m<? super Integer, ? super View, x> uyJ;
    public int va;
    private int vp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private GalleryLayoutManager(Context context, int i2) {
        super(i2, false);
        p.h(context, "context");
        AppMethodBeat.i(119932);
        this.va = -1;
        this.hbX = true;
        AppMethodBeat.o(119932);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GalleryLayoutManager(Context context, int i2, byte b2) {
        this(context, i2);
        p.h(context, "context");
        AppMethodBeat.i(119933);
        AppMethodBeat.o(119933);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GalleryLayoutManager(Context context) {
        this(context, 1, (byte) 0);
        p.h(context, "context");
        AppMethodBeat.i(119934);
        AppMethodBeat.o(119934);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119935);
        AppMethodBeat.o(119935);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final boolean canScrollHorizontally() {
        AppMethodBeat.i(119919);
        if (!this.hbX || !super.canScrollHorizontally()) {
            AppMethodBeat.o(119919);
            return false;
        }
        AppMethodBeat.o(119919);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final boolean canScrollVertically() {
        AppMethodBeat.i(119920);
        if (!this.hbX || getItemCount() <= 1 || !super.canScrollVertically()) {
            AppMethodBeat.o(119920);
            return false;
        }
        AppMethodBeat.o(119920);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void onLayoutCompleted(RecyclerView.s sVar) {
        AppMethodBeat.i(119921);
        Log.i(TAG, "LogStory: onLayoutCompleted");
        super.onLayoutCompleted(sVar);
        nz(this.uyI);
        this.uyI = false;
        AppMethodBeat.o(119921);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public final void onScrollStateChanged(int i2) {
        AppMethodBeat.i(119922);
        Log.i(TAG, "LogStory: onScrollStateChanged ".concat(String.valueOf(i2)));
        super.onScrollStateChanged(i2);
        this.vp = i2;
        if (this.vp == 0) {
            nz(false);
        }
        AppMethodBeat.o(119922);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        ViewParent viewParent;
        AppMethodBeat.i(119923);
        p.h(nVar, "recycler");
        p.h(sVar, "state");
        int scrollHorizontallyBy = super.scrollHorizontallyBy(i2, nVar, sVar);
        if (i2 + 1 <= scrollHorizontallyBy && -1 >= scrollHorizontallyBy && this.vp == 1) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                viewParent = childAt.getParent();
            } else {
                viewParent = null;
            }
            if (!(viewParent instanceof RecyclerView)) {
                viewParent = null;
            }
            RecyclerView recyclerView = (RecyclerView) viewParent;
            Log.i(TAG, "horizontal Drag to end, " + i2 + ' ' + scrollHorizontallyBy + ", " + recyclerView);
            if (recyclerView != null) {
                recyclerView.kQ();
            }
        }
        AppMethodBeat.o(119923);
        return scrollHorizontallyBy;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        ViewParent viewParent;
        int position;
        float decoratedMeasuredWidth;
        AppMethodBeat.i(119924);
        p.h(nVar, "recycler");
        p.h(sVar, "state");
        int scrollVerticallyBy = super.scrollVerticallyBy(i2, nVar, sVar);
        Log.i(TAG, "LogStory: vertical " + i2 + ' ' + scrollVerticallyBy);
        if (i2 + 1 <= scrollVerticallyBy && -1 >= scrollVerticallyBy && this.vp == 1) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                viewParent = childAt.getParent();
            } else {
                viewParent = null;
            }
            if (!(viewParent instanceof RecyclerView)) {
                viewParent = null;
            }
            RecyclerView recyclerView = (RecyclerView) viewParent;
            Log.i(TAG, "vertical Drag to end, " + i2 + ' ' + scrollVerticallyBy + ", " + recyclerView);
            if (recyclerView != null) {
                recyclerView.kQ();
            }
        }
        if (getChildCount() != 0) {
            if (getChildCount() == 1) {
                View childAt2 = getChildAt(0);
                if (childAt2 == null) {
                    p.hyc();
                }
                position = getPosition(childAt2);
                decoratedMeasuredWidth = 0.0f;
            } else {
                View childAt3 = getChildAt(0);
                if (childAt3 == null) {
                    p.hyc();
                }
                p.g(childAt3, "getChildAt(0)!!");
                position = getPosition(childAt3);
                if (canScrollVertically()) {
                    decoratedMeasuredWidth = (-((float) getDecoratedTop(childAt3))) / ((float) getDecoratedMeasuredHeight(childAt3));
                } else {
                    decoratedMeasuredWidth = (-((float) getDecoratedLeft(childAt3))) / ((float) getDecoratedMeasuredWidth(childAt3));
                }
            }
            m<? super Integer, ? super Float, x> mVar = this.FzM;
            if (mVar != null) {
                mVar.invoke(Integer.valueOf(position), Float.valueOf(decoratedMeasuredWidth));
            }
        }
        AppMethodBeat.o(119924);
        return scrollVerticallyBy;
    }

    public final void nz(boolean z) {
        AppMethodBeat.i(119925);
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
                m<? super Integer, ? super View, x> mVar = this.uyJ;
                if (mVar != null) {
                    mVar.invoke(Integer.valueOf(this.va), childAt);
                    AppMethodBeat.o(119925);
                    return;
                }
            }
        }
        AppMethodBeat.o(119925);
    }

    private final int div() {
        int i2 = 0;
        AppMethodBeat.i(119926);
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
        AppMethodBeat.o(119926);
        return i2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public final void onItemsChanged(RecyclerView recyclerView) {
        AppMethodBeat.i(119927);
        p.h(recyclerView, "recyclerView");
        Log.i(TAG, "LogStory: onItemsChanged");
        this.uyI = true;
        AppMethodBeat.o(119927);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public final void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        AppMethodBeat.i(119928);
        p.h(recyclerView, "recyclerView");
        super.onItemsAdded(recyclerView, i2, i3);
        if (this.va >= i2 && this.va < i2 + i3) {
            this.uyI = true;
        }
        AppMethodBeat.o(119928);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public final void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        AppMethodBeat.i(119929);
        p.h(recyclerView, "recyclerView");
        Log.i(TAG, "LogStory: onItemsRemoved " + i2 + ", " + i3);
        super.onItemsRemoved(recyclerView, i2, i3);
        if (this.va >= i2 && this.va < i2 + i3) {
            this.uyI = true;
        }
        AppMethodBeat.o(119929);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public final void onItemsUpdated(RecyclerView recyclerView, int i2, int i3) {
        AppMethodBeat.i(119930);
        p.h(recyclerView, "recyclerView");
        Log.i(TAG, "LogStory: onItemsUpdated " + i2 + ", " + i3);
        super.onItemsUpdated(recyclerView, i2, i3);
        if (this.va >= i2 && this.va < i2 + i3) {
            this.uyI = true;
        }
        AppMethodBeat.o(119930);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void scrollToPosition(int i2) {
        AppMethodBeat.i(119931);
        Log.i(TAG, "LogStory: scrollToPosition " + i2 + ' ' + Util.getStack());
        super.scrollToPosition(i2);
        m<? super Integer, ? super Float, x> mVar = this.FzM;
        if (mVar != null) {
            mVar.invoke(Integer.valueOf(i2), Float.valueOf(0.0f));
            AppMethodBeat.o(119931);
            return;
        }
        AppMethodBeat.o(119931);
    }
}
