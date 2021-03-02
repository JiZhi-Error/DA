package com.tencent.mm.plugin.finder.ui;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.aj;
import android.support.v7.widget.ak;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J(\u0010!\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J \u0010&\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0007H\u0002J\u001a\u0010(\u001a\u0004\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020#H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u001eH\u0016J \u0010+\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u0015H\u0016J\u0012\u0010.\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u001c\u0010/\u001a\u0004\u0018\u00010 2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010-\u001a\u00020\u0015H\u0002J\u0012\u00100\u001a\u00020#2\b\u0010\u001c\u001a\u0004\u0018\u00010 H\u0002J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020%H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0004¢\u0006\u0002\n\u0000R#\u0010\u0017\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0018\u0010\n¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper;", "Landroid/support/v7/widget/PagerSnapHelper;", "()V", "endRect", "", "firstRect", "horizontalHelper", "Landroid/support/v7/widget/OrientationHelper;", "kotlin.jvm.PlatformType", "getHorizontalHelper", "()Landroid/support/v7/widget/OrientationHelper;", "horizontalHelper$delegate", "Lkotlin/Lazy;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "rect", "Landroid/graphics/Rect;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "specialIds", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "verticalHelper", "getVerticalHelper", "verticalHelper$delegate", "attachToRecyclerView", "", "view", "calculateDistanceToFinalSnap", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "checkMask", "isHardAlpha", "", "source", "", "distanceToTop", "helper", "findCenterView", "canScrollVertically", "findSnapView", "findTargetSnapPosition", "velocityX", "velocityY", "findVisiblePos", "findVisibleView", "isSpecialView", SharePatchInfo.FINGER_PRINT, "msg", "Companion", "plugin-finder_release"})
public final class e extends ak {
    private static final boolean cWq;
    public static final a vKs = new a((byte) 0);
    private RecyclerView hak;
    private final Rect rect;
    private final int[] vKm = new int[2];
    private final int[] vKn = new int[2];
    private final HashSet<Integer> vKo;
    private LinearLayoutManager vKp;
    private final f vKq;
    private final f vKr;

    private final aj dzz() {
        AppMethodBeat.i(252410);
        aj ajVar = (aj) this.vKq.getValue();
        AppMethodBeat.o(252410);
        return ajVar;
    }

    public e() {
        AppMethodBeat.i(252418);
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(Integer.valueOf((int) R.id.dmn));
        this.vKo = hashSet;
        this.vKq = g.ah(new C1296e(this));
        this.vKr = g.ah(new d(this));
        this.rect = new Rect();
        AppMethodBeat.o(252418);
    }

    public static final /* synthetic */ LinearLayoutManager a(e eVar) {
        AppMethodBeat.i(252421);
        LinearLayoutManager linearLayoutManager = eVar.vKp;
        if (linearLayoutManager == null) {
            p.btv("layoutManager");
        }
        AppMethodBeat.o(252421);
        return linearLayoutManager;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$Companion;", "", "()V", "TAG", "", "isDebug", "", "()Z", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        boolean z = false;
        AppMethodBeat.i(252419);
        if (BuildInfo.DEBUG) {
            z = true;
        }
        cWq = z;
        AppMethodBeat.o(252419);
    }

    @Override // android.support.v7.widget.at
    public final void f(RecyclerView recyclerView) {
        AppMethodBeat.i(252411);
        if (recyclerView != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(252411);
                throw tVar;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            this.hak = recyclerView;
            this.vKp = linearLayoutManager;
            recyclerView.a(new b(linearLayoutManager, this, recyclerView));
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.a(new c(recyclerView, linearLayoutManager, this, recyclerView));
            }
        }
        super.f(recyclerView);
        AppMethodBeat.o(252411);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$1$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
    public static final class b extends RecyclerView.l {
        final /* synthetic */ LinearLayoutManager tSy;
        final /* synthetic */ e vKt;
        final /* synthetic */ RecyclerView vKu;

        b(LinearLayoutManager linearLayoutManager, e eVar, RecyclerView recyclerView) {
            this.tSy = linearLayoutManager;
            this.vKt = eVar;
            this.vKu = recyclerView;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(final RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(252398);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                recyclerView.post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.finder.ui.e.b.AnonymousClass1 */
                    final /* synthetic */ b vKv;

                    {
                        this.vKv = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(252397);
                        e.a(this.vKv.vKt, recyclerView, this.vKv.tSy, false);
                        AppMethodBeat.o(252397);
                    }
                });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(252398);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(252399);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            e.a(this.vKt, recyclerView, this.tSy, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(252399);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderFullPagerSnapHelper$attachToRecyclerView$1$2", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onItemRangeInserted", "onItemRangeRemoved", "plugin-finder_release"})
    public static final class c extends RecyclerView.c {
        final /* synthetic */ LinearLayoutManager tSy;
        final /* synthetic */ RecyclerView uMW;
        final /* synthetic */ e vKt;
        final /* synthetic */ RecyclerView vKu;

        c(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager, e eVar, RecyclerView recyclerView2) {
            this.uMW = recyclerView;
            this.tSy = linearLayoutManager;
            this.vKt = eVar;
            this.vKu = recyclerView2;
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onChanged() {
            AppMethodBeat.i(252404);
            super.onChanged();
            this.uMW.postDelayed(new Runnable(this) {
                /* class com.tencent.mm.plugin.finder.ui.e.c.AnonymousClass1 */
                final /* synthetic */ c vKw;

                {
                    this.vKw = r1;
                }

                public final void run() {
                    AppMethodBeat.i(252400);
                    e.a(this.vKw.vKt, this.vKw.uMW, this.vKw.tSy, true);
                    AppMethodBeat.o(252400);
                }
            }, 600);
            AppMethodBeat.o(252404);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            AppMethodBeat.i(252405);
            super.onItemRangeChanged(i2, i3, obj);
            this.uMW.postDelayed(new Runnable(this) {
                /* class com.tencent.mm.plugin.finder.ui.e.c.AnonymousClass2 */
                final /* synthetic */ c vKw;

                {
                    this.vKw = r1;
                }

                public final void run() {
                    AppMethodBeat.i(252401);
                    e.a(this.vKw.vKt, this.vKw.uMW, this.vKw.tSy, true);
                    AppMethodBeat.o(252401);
                }
            }, 600);
            AppMethodBeat.o(252405);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeInserted(int i2, int i3) {
            AppMethodBeat.i(252406);
            super.onItemRangeInserted(i2, i3);
            this.uMW.postDelayed(new Runnable(this) {
                /* class com.tencent.mm.plugin.finder.ui.e.c.AnonymousClass3 */
                final /* synthetic */ c vKw;

                {
                    this.vKw = r1;
                }

                public final void run() {
                    AppMethodBeat.i(252402);
                    e.a(this.vKw.vKt, this.vKw.uMW, this.vKw.tSy, true);
                    AppMethodBeat.o(252402);
                }
            }, 600);
            AppMethodBeat.o(252406);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeRemoved(int i2, int i3) {
            AppMethodBeat.i(252407);
            super.onItemRangeRemoved(i2, i3);
            this.uMW.postDelayed(new Runnable(this) {
                /* class com.tencent.mm.plugin.finder.ui.e.c.AnonymousClass4 */
                final /* synthetic */ c vKw;

                {
                    this.vKw = r1;
                }

                public final void run() {
                    AppMethodBeat.i(252403);
                    e.a(this.vKw.vKt, this.vKw.uMW, this.vKw.tSy, true);
                    AppMethodBeat.o(252403);
                }
            }, 600);
            AppMethodBeat.o(252407);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007a  */
    @Override // android.support.v7.widget.at, android.support.v7.widget.ak
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(android.support.v7.widget.RecyclerView.LayoutManager r9, int r10, int r11) {
        /*
        // Method dump skipped, instructions count: 252
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.ui.e.a(android.support.v7.widget.RecyclerView$LayoutManager, int, int):int");
    }

    @Override // android.support.v7.widget.at, android.support.v7.widget.ak
    public final View a(RecyclerView.LayoutManager layoutManager) {
        AppMethodBeat.i(252413);
        p.h(layoutManager, "layoutManager");
        boolean canScrollVertically = layoutManager.canScrollVertically();
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            AppMethodBeat.o(252413);
            return null;
        }
        float f2 = 0.0f;
        View view = null;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = layoutManager.getChildAt(i2);
            if (childAt != null) {
                p.g(childAt, "layoutManager.getChildAt(i) ?: continue");
                if ((!canScrollVertically || childAt.getHeight() > 0) && (canScrollVertically || childAt.getWidth() > 0)) {
                    if (!eb(childAt) || !childAt.getGlobalVisibleRect(this.rect) || this.rect.height() <= 0) {
                        float height = (1.0f * ((float) (childAt.getGlobalVisibleRect(this.rect) ? canScrollVertically ? this.rect.height() : this.rect.width() : 0))) / ((float) (canScrollVertically ? childAt.getHeight() : childAt.getWidth()));
                        if (f2 < height) {
                            f2 = height;
                            view = childAt;
                        }
                    } else {
                        Object tag = childAt.getTag(R.id.cm_);
                        print("[findSnapView] isSpecialView child=" + childAt + " rect=" + this.rect + " tag=" + tag);
                        if (tag == null || p.j(tag, Boolean.TRUE)) {
                            AppMethodBeat.o(252413);
                            return childAt;
                        }
                        childAt.setTag(R.id.cm_, Boolean.FALSE);
                        AppMethodBeat.o(252413);
                        return null;
                    }
                }
            }
        }
        AppMethodBeat.o(252413);
        return view;
    }

    private final boolean eb(View view) {
        AppMethodBeat.i(252414);
        if (view == null) {
            AppMethodBeat.o(252414);
            return false;
        }
        Iterator<T> it = this.vKo.iterator();
        while (it.hasNext()) {
            View findViewById = view.findViewById(it.next().intValue());
            if (findViewById != null && findViewById.getVisibility() == 0) {
                AppMethodBeat.o(252414);
                return true;
            }
        }
        AppMethodBeat.o(252414);
        return false;
    }

    @Override // android.support.v7.widget.at, android.support.v7.widget.ak
    public final int[] a(RecyclerView.LayoutManager layoutManager, View view) {
        AppMethodBeat.i(252415);
        p.h(layoutManager, "layoutManager");
        p.h(view, "targetView");
        int[] iArr = new int[2];
        if (eb(view)) {
            Object tag = view.getTag(R.id.cm_);
            aj dzz = dzz();
            p.g(dzz, "verticalHelper");
            iArr[1] = a(view, dzz);
            if (tag == null || p.j(tag, Boolean.TRUE)) {
                iArr[1] = 0;
            }
            view.setTag(R.id.cm_, Boolean.FALSE);
        } else {
            if (layoutManager.canScrollHorizontally()) {
                aj ajVar = (aj) this.vKr.getValue();
                p.g(ajVar, "horizontalHelper");
                iArr[0] = a(view, ajVar);
            } else {
                iArr[0] = 0;
            }
            if (layoutManager.canScrollVertically()) {
                aj dzz2 = dzz();
                p.g(dzz2, "verticalHelper");
                iArr[1] = a(view, dzz2);
            } else {
                iArr[1] = 0;
            }
        }
        AppMethodBeat.o(252415);
        return iArr;
    }

    private static int a(View view, aj ajVar) {
        AppMethodBeat.i(252416);
        int bo = ajVar.bo(view) - ajVar.kH();
        AppMethodBeat.o(252416);
        return bo;
    }

    private static void print(String str) {
        AppMethodBeat.i(252417);
        if (cWq) {
            Log.i("Finder.FullPagerSnapHelper", str);
        }
        AppMethodBeat.o(252417);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/OrientationHelper;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.ui.e$e  reason: collision with other inner class name */
    static final class C1296e extends q implements kotlin.g.a.a<aj> {
        final /* synthetic */ e vKt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1296e(e eVar) {
            super(0);
            this.vKt = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ aj invoke() {
            AppMethodBeat.i(252409);
            aj e2 = aj.e(e.a(this.vKt));
            AppMethodBeat.o(252409);
            return e2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/OrientationHelper;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<aj> {
        final /* synthetic */ e vKt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(e eVar) {
            super(0);
            this.vKt = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ aj invoke() {
            AppMethodBeat.i(252408);
            aj d2 = aj.d(e.a(this.vKt));
            AppMethodBeat.o(252408);
            return d2;
        }
    }

    public static final /* synthetic */ void a(e eVar, RecyclerView recyclerView, LinearLayoutManager linearLayoutManager, boolean z) {
        AppMethodBeat.i(252420);
        int ks = linearLayoutManager.ks();
        int ku = linearLayoutManager.ku();
        RecyclerView.v ch = recyclerView.ch(ks);
        RecyclerView.v ch2 = recyclerView.ch(ku);
        int height = recyclerView.getHeight() / 2;
        y yVar = y.vXH;
        if (!(ch == null || ch2 == null)) {
            if (z || ks == ku) {
                int childCount = recyclerView.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View findViewById = recyclerView.getChildAt(i2).findViewById(R.id.e32);
                    if (findViewById != null) {
                        ViewPropertyAnimator animate = findViewById.animate();
                        if (animate != null) {
                            animate.cancel();
                        }
                        findViewById.animate().alpha(0.0f).setDuration(250).start();
                    }
                }
                AppMethodBeat.o(252420);
                return;
            }
            ch.aus.getLocationInWindow(eVar.vKm);
            ch2.aus.getLocationInWindow(eVar.vKn);
            int i3 = eVar.vKm[1];
            View view = ch.aus;
            p.g(view, "first.itemView");
            int height2 = i3 + (view.getHeight() / 2);
            int i4 = eVar.vKn[1];
            View view2 = ch2.aus;
            p.g(view2, "end.itemView");
            int height3 = i4 + (view2.getHeight() / 2);
            float abs = (((float) Math.abs(height - height2)) * 1.0f) / ((float) recyclerView.getHeight());
            float abs2 = (((float) Math.abs(height - height3)) * 1.0f) / ((float) recyclerView.getHeight());
            View findViewById2 = ch.aus.findViewById(R.id.e32);
            if (findViewById2 != null) {
                findViewById2.setAlpha(abs);
            }
            View findViewById3 = ch2.aus.findViewById(R.id.e32);
            if (findViewById3 != null) {
                findViewById3.setAlpha(abs2);
                AppMethodBeat.o(252420);
                return;
            }
        }
        AppMethodBeat.o(252420);
    }
}
