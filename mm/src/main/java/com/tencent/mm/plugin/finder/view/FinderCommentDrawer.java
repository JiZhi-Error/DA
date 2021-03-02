package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.f;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 b2\u00020\u0001:\u0002abB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010U\u001a\u00020VJ\u0006\u0010W\u001a\u00020VJ\u0010\u0010X\u001a\u00020\f2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0006\u0010[\u001a\u00020VJ\u0006\u0010\\\u001a\u00020VJ`\u0010]\u001a\u00020V2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010+\u001a\u00020\f2\b\b\u0002\u0010=\u001a\u00020>2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010O\u001a\u00020\f2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\b\b\u0002\u0010^\u001a\u00020\f2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u00106\u001a\u00020\tJ\b\u0010_\u001a\u00020VH\u0002J\u0006\u0010`\u001a\u00020VR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000e\"\u0004\b*\u0010\u0010R\u001a\u0010+\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R\u001a\u0010-\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u0010\u0010R\u001c\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010=\u001a\u00020>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00108\"\u0004\bK\u0010:R\u001a\u0010L\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u00108\"\u0004\bN\u0010:R\u001a\u0010O\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u000e\"\u0004\bQ\u0010\u0010R\u001a\u0010R\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u000e\"\u0004\bT\u0010\u0010¨\u0006c"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "banSwitch", "", "getBanSwitch", "()Z", "setBanSwitch", "(Z)V", "blinkRefComment", "getBlinkRefComment", "setBlinkRefComment", "closeComment", "getCloseComment", "setCloseComment", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "footer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "getFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "setFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;)V", "interceptClose", "Lkotlin/Function0;", "getInterceptClose", "()Lkotlin/jvm/functions/Function0;", "setInterceptClose", "(Lkotlin/jvm/functions/Function0;)V", "isSelfProfile", "setSelfProfile", "isSingleMode", "setSingleMode", "oldVersion", "getOldVersion", "setOldVersion", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "getOnCloseDrawerCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "setOnCloseDrawerCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;)V", "reason", "getReason", "()I", "setReason", "(I)V", "rect", "Landroid/graphics/Rect;", "refCommentId", "", "getRefCommentId", "()J", "setRefCommentId", "(J)V", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getReplyCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "setReplyCommentObj", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "scene", "getScene", "setScene", "sceneForReply", "getSceneForReply", "setSceneForReply", "showFooter", "getShowFooter", "setShowFooter", "useCache", "getUseCache", "setUseCache", "closeDrawer", "", "closeDrawerWhenError", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onUIPause", "onUIResume", "openDrawer", "fullScreen", "refreshSceneForReply", "switchScene", "Builder", "Companion", "plugin-finder_release"})
public final class FinderCommentDrawer extends RecyclerViewDrawer {
    public static final b wkG = new b((byte) 0);
    private int bDZ;
    private boolean efT;
    private final Rect rect = new Rect();
    private int scene = 2;
    public FinderItem tMO;
    private CommentDrawerContract.CloseDrawerCallback tMR;
    public boolean tMV;
    private boolean tMW;
    private long tuj;
    private boolean tzn;
    public boolean uLZ;
    private an wkA;
    public int wkB;
    private boolean wkC;
    public FinderCommentFooter wkD;
    private boolean wkE;
    private kotlin.g.a.a<Boolean> wkF;
    private boolean wkz;

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\nH&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "", "onBuildDrawerBody", "", "context", "Landroid/content/Context;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "onBuildDrawerFooter", "footerLayout", "Landroid/widget/FrameLayout;", "fullScreen", "", "onBuildDrawerHeader", "headerLayout", "onBuildLoading", "loadingLayout", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "displayScene", "", "plugin-finder_release"})
    public interface a {
        void a(Context context, FrameLayout frameLayout, boolean z);

        void a(Context context, RefreshLoadMoreLayout refreshLoadMoreLayout);

        void a(RecyclerViewDrawer recyclerViewDrawer, int i2);

        void b(Context context, FrameLayout frameLayout);

        void b(Context context, FrameLayout frameLayout, boolean z);
    }

    static {
        AppMethodBeat.i(168255);
        AppMethodBeat.o(168255);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderCommentDrawer(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(168252);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wkB = com.tencent.mm.plugin.finder.storage.c.drS();
        this.efT = true;
        this.wkz = true;
        this.tzn = true;
        AppMethodBeat.o(168252);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderCommentDrawer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(168253);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wkB = com.tencent.mm.plugin.finder.storage.c.drS();
        this.efT = true;
        this.wkz = true;
        this.tzn = true;
        AppMethodBeat.o(168253);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderCommentDrawer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(168254);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wkB = com.tencent.mm.plugin.finder.storage.c.drS();
        this.efT = true;
        this.wkz = true;
        this.tzn = true;
        AppMethodBeat.o(168254);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Companion;", "", "()V", "TAG", "", "createDrawerToAttachWindow", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "context", "Lcom/tencent/mm/ui/MMFragmentActivity;", "parent", "Landroid/view/View;", "scene", "", "builder", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "safeMode", "", "fullScreen", "exposeScene", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static /* synthetic */ FinderCommentDrawer a(MMFragmentActivity mMFragmentActivity, View view, int i2, a aVar, boolean z, boolean z2, int i3, int i4) {
            AppMethodBeat.i(254734);
            FinderCommentDrawer a2 = a(mMFragmentActivity, view, i2, (i4 & 8) != 0 ? new com.tencent.mm.plugin.finder.view.builder.b(new f(mMFragmentActivity)) : aVar, (i4 & 16) != 0 ? false : z, z2, (i4 & 64) != 0 ? 58 : i3);
            AppMethodBeat.o(254734);
            return a2;
        }

        private static FinderCommentDrawer a(MMFragmentActivity mMFragmentActivity, View view, int i2, a aVar, boolean z, boolean z2, int i3) {
            a aVar2;
            CommentDrawerContract.NPresenter nPresenter;
            AppMethodBeat.i(254733);
            p.h(mMFragmentActivity, "context");
            p.h(view, "parent");
            p.h(aVar, "builder");
            FinderCommentDrawer finderCommentDrawer = new FinderCommentDrawer(mMFragmentActivity);
            if (z2) {
                finderCommentDrawer.setTopOffset(ao.jJ(mMFragmentActivity));
                finderCommentDrawer.setBackgroundColorRes(R.color.ac_);
            }
            Resources resources = mMFragmentActivity.getResources();
            p.g(resources, "context.resources");
            finderCommentDrawer.setTopOffset((int) (((double) resources.getDisplayMetrics().heightPixels) * 0.2d));
            aVar.a(finderCommentDrawer, i2);
            if (!(aVar instanceof com.tencent.mm.plugin.finder.view.builder.b)) {
                aVar2 = null;
            } else {
                aVar2 = aVar;
            }
            com.tencent.mm.plugin.finder.view.builder.b bVar = (com.tencent.mm.plugin.finder.view.builder.b) aVar2;
            if (bVar != null) {
                nPresenter = bVar.tzm;
            } else {
                nPresenter = null;
            }
            if (!(nPresenter instanceof f)) {
                nPresenter = null;
            }
            f fVar = (f) nPresenter;
            if (fVar != null) {
                fVar.tMM = i3;
            }
            CommentDrawerContract.NPresenter nPresenter2 = ((com.tencent.mm.plugin.finder.view.builder.b) aVar).tzm;
            if (nPresenter2 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderCommentDrawerPresenter");
                AppMethodBeat.o(254733);
                throw tVar;
            }
            ((f) nPresenter2).tAj = z;
            view.post(new a(mMFragmentActivity, view, finderCommentDrawer, new FrameLayout.LayoutParams(-1, -1), aVar, z2));
            AppMethodBeat.o(254733);
            return finderCommentDrawer;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        public static final class a implements Runnable {
            final /* synthetic */ MMFragmentActivity vWD;
            final /* synthetic */ View wkH;
            final /* synthetic */ FinderCommentDrawer wkI;
            final /* synthetic */ FrameLayout.LayoutParams wkJ;
            final /* synthetic */ a wkK;
            final /* synthetic */ boolean wkL;

            a(MMFragmentActivity mMFragmentActivity, View view, FinderCommentDrawer finderCommentDrawer, FrameLayout.LayoutParams layoutParams, a aVar, boolean z) {
                this.vWD = mMFragmentActivity;
                this.wkH = view;
                this.wkI = finderCommentDrawer;
                this.wkJ = layoutParams;
                this.wkK = aVar;
                this.wkL = z;
            }

            public final void run() {
                AppMethodBeat.i(168243);
                Log.i("Finder.CommentDrawer", "[initView] bottomMargin= ".concat(String.valueOf(au.aB(this.vWD))));
                View view = this.wkH;
                if (view == null) {
                    t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout");
                    AppMethodBeat.o(168243);
                    throw tVar;
                }
                ((FrameLayout) view).addView(this.wkI, this.wkJ);
                this.wkK.a(this.vWD, this.wkI.getHeaderLayout(), this.wkL);
                this.wkK.a(this.vWD, this.wkI.getCenterLayout());
                this.wkK.b(this.vWD, this.wkI.getFooterLayout(), this.wkL);
                this.wkK.b(this.vWD, this.wkI.getLoadingLayout());
                AppMethodBeat.o(168243);
            }
        }
    }

    @Override // com.tencent.mm.view.drawer.RecyclerViewDrawer
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(168247);
        p.h(motionEvent, "event");
        if (this.tMV) {
            View findViewById = getFooterLayout().findViewById(R.id.b8r);
            this.rect.setEmpty();
            findViewById.getGlobalVisibleRect(this.rect);
            if (((float) this.rect.top) > motionEvent.getY()) {
                if (motionEvent.getAction() == 2 || motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    dGr();
                } else if (motionEvent.getAction() == 0) {
                    super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(168247);
                    return true;
                }
            }
        } else {
            View findViewById2 = getHeaderLayout().findViewById(R.id.ckv);
            this.rect.setEmpty();
            findViewById2.getGlobalVisibleRect(this.rect);
            Log.d("Finder.CommentDrawer", "event.action " + motionEvent.getActionMasked() + " event.y " + motionEvent.getY() + ", " + this.rect.top + ", " + this.rect.bottom);
            if (motionEvent.getY() < ((float) this.rect.top) || motionEvent.getY() > ((float) this.rect.bottom)) {
                p.g(findViewById2, "headerErrTipLayout");
                findViewById2.setPressed(false);
            } else if (motionEvent.getActionMasked() != 2) {
                boolean dispatchTouchEvent = findViewById2.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(168247);
                return dispatchTouchEvent;
            }
        }
        boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
        if (this.Rof && motionEvent.getAction() == 0) {
            Context context = getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                AppMethodBeat.o(168247);
                throw tVar;
            }
            ((MMFragmentActivity) context).hideVKB();
        }
        AppMethodBeat.o(168247);
        return dispatchTouchEvent2;
    }

    public final FinderItem getFeedObj() {
        return this.tMO;
    }

    public final void setFeedObj(FinderItem finderItem) {
        this.tMO = finderItem;
    }

    public final long getRefCommentId() {
        return this.tuj;
    }

    public final void setRefCommentId(long j2) {
        this.tuj = j2;
    }

    public final int getScene() {
        return this.scene;
    }

    public final void setScene(int i2) {
        this.scene = i2;
    }

    public final int getSceneForReply() {
        return this.wkB;
    }

    public final void setSceneForReply(int i2) {
        this.wkB = i2;
    }

    public final void setSelfProfile(boolean z) {
        this.uLZ = z;
    }

    public final CommentDrawerContract.CloseDrawerCallback getOnCloseDrawerCallback() {
        return this.tMR;
    }

    public final void setOnCloseDrawerCallback(CommentDrawerContract.CloseDrawerCallback closeDrawerCallback) {
        this.tMR = closeDrawerCallback;
    }

    public final void setSingleMode(boolean z) {
        this.tMV = z;
    }

    public final boolean getUseCache() {
        return this.efT;
    }

    public final void setUseCache(boolean z) {
        this.efT = z;
    }

    public final boolean getShowFooter() {
        return this.wkz;
    }

    public final void setShowFooter(boolean z) {
        this.wkz = z;
    }

    public final boolean getCloseComment() {
        return this.wkC;
    }

    public final void setCloseComment(boolean z) {
        this.wkC = z;
    }

    public final boolean getOldVersion() {
        return this.tzn;
    }

    public final void setOldVersion(boolean z) {
        this.tzn = z;
    }

    public final an getReplyCommentObj() {
        return this.wkA;
    }

    public final void setReplyCommentObj(an anVar) {
        this.wkA = anVar;
    }

    public final boolean getBlinkRefComment() {
        return this.tMW;
    }

    public final void setBlinkRefComment(boolean z) {
        this.tMW = z;
    }

    public final FinderCommentFooter getFooter() {
        return this.wkD;
    }

    public final void setFooter(FinderCommentFooter finderCommentFooter) {
        this.wkD = finderCommentFooter;
    }

    public final boolean getBanSwitch() {
        return this.wkE;
    }

    public final void setBanSwitch(boolean z) {
        this.wkE = z;
    }

    public final int getReason() {
        return this.bDZ;
    }

    public final void setReason(int i2) {
        this.bDZ = i2;
    }

    public static /* synthetic */ void a(FinderCommentDrawer finderCommentDrawer, FinderItem finderItem, boolean z, long j2, boolean z2, boolean z3, an anVar, boolean z4, int i2, int i3) {
        boolean z5;
        boolean z6;
        int i4;
        AppMethodBeat.i(254736);
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            j2 = 0;
        }
        if ((i3 & 8) != 0) {
            z2 = false;
        }
        if ((i3 & 16) != 0) {
            z3 = true;
        }
        if ((i3 & 32) != 0) {
            anVar = null;
        }
        if ((i3 & 128) != 0) {
            z4 = false;
        }
        if ((i3 & 256) != 0) {
            i2 = 0;
        }
        p.h(finderItem, "feedObj");
        e.INSTANCE.idkeyStat(1278, 6, 1, false);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        Context context = finderCommentDrawer.getContext();
        p.g(context, "context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (fH != null) {
            if (i2 == 4) {
                i4 = 4;
            } else if (j2 == 0) {
                i4 = 1;
            } else {
                i4 = 2;
            }
            k kVar = k.vfA;
            k.a(fH.tCE, fH.sGQ, fH.sGE, finderItem.getId(), i4);
        }
        finderCommentDrawer.wkz = z3;
        finderCommentDrawer.wkC = false;
        finderCommentDrawer.tzn = finderItem.isOldVersion();
        finderCommentDrawer.wkE = z4;
        finderCommentDrawer.bDZ = i2;
        FinderCommentFooter finderCommentFooter = finderCommentDrawer.wkD;
        if (finderCommentFooter != null) {
            finderCommentFooter.setBanSwitchScene(z4);
        }
        FinderCommentFooter finderCommentFooter2 = finderCommentDrawer.wkD;
        if (finderCommentFooter2 != null) {
            finderCommentFooter2.dGx();
        }
        if (finderItem.isCommentClose()) {
            y yVar = y.vXH;
            if (!y.In(finderItem.field_username) || z) {
                f.a aVar2 = new f.a(MMApplicationContext.getContext());
                aVar2.bow(finderCommentDrawer.getContext().getString(R.string.cms)).Dq(true);
                aVar2.b(c.wkM).show();
                AppMethodBeat.o(254736);
                return;
            }
            finderCommentDrawer.wkC = true;
            finderCommentDrawer.wkz = false;
        }
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dsR() > 0) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
            com.tencent.mm.plugin.finder.storage.c.KR(com.tencent.mm.plugin.finder.storage.c.dsR() - 1);
        }
        finderCommentDrawer.dGv();
        if (!finderCommentDrawer.dGs()) {
            finderCommentDrawer.tMO = finderItem;
            finderCommentDrawer.tuj = j2;
            finderCommentDrawer.tMV = z;
            finderCommentDrawer.wkA = anVar;
            finderCommentDrawer.tMW = z2;
            if (z) {
                z5 = false;
                z6 = true;
            } else {
                z5 = true;
                z6 = j2 == 0;
            }
            super.bi(z5, z6);
        }
        AppMethodBeat.o(254736);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class c implements f.c {
        public static final c wkM = new c();

        static {
            AppMethodBeat.i(254735);
            AppMethodBeat.o(254735);
        }

        c() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void dGv() {
        AppMethodBeat.i(178471);
        if (this.uLZ) {
            this.wkB = this.scene;
            Log.i("Finder.CommentDrawer", "refreshSceneForReply isSelfProfile " + this.scene);
        } else {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            this.wkB = com.tencent.mm.plugin.finder.storage.c.drS();
        }
        FinderCommentFooter finderCommentFooter = this.wkD;
        if (finderCommentFooter != null) {
            finderCommentFooter.setScene(this.wkB);
        }
        FinderCommentFooter finderCommentFooter2 = this.wkD;
        if (finderCommentFooter2 != null) {
            finderCommentFooter2.dGy();
            AppMethodBeat.o(178471);
            return;
        }
        AppMethodBeat.o(178471);
    }

    public final kotlin.g.a.a<Boolean> getInterceptClose() {
        return this.wkF;
    }

    public final void setInterceptClose(kotlin.g.a.a<Boolean> aVar) {
        this.wkF = aVar;
    }

    public final void dGw() {
        Boolean invoke;
        AppMethodBeat.i(254737);
        kotlin.g.a.a<Boolean> aVar = this.wkF;
        if ((aVar == null || (invoke = aVar.invoke()) == null) ? false : invoke.booleanValue()) {
            AppMethodBeat.o(254737);
            return;
        }
        dGr();
        AppMethodBeat.o(254737);
    }

    public final void dGr() {
        AppMethodBeat.i(168251);
        if (dGs()) {
            if (this.tMV) {
                super.DG(false);
            } else {
                super.DG(true);
            }
            View findViewById = getHeaderLayout().findViewById(R.id.ckv);
            p.g(findViewById, "headerErrTipLayout");
            findViewById.setVisibility(8);
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = getContext();
            p.g(context, "context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            if (fH != null) {
                k kVar = k.vfA;
                int i2 = fH.tCE;
                String str = fH.sGQ;
                String str2 = fH.sGE;
                FinderItem finderItem = this.tMO;
                k.a(i2, str, str2, finderItem != null ? finderItem.getId() : 0, 3);
                AppMethodBeat.o(168251);
                return;
            }
        }
        AppMethodBeat.o(168251);
    }
}
