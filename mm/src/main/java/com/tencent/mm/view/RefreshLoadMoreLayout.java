package com.tencent.mm.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import kotlin.g.b.z;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u000e\b\u0016\u0018\u0000 »\u00012\u00020\u00012\u00020\u0002:\bº\u0001»\u0001¼\u0001½\u0001B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010X\u001a\u00020YH\u0002J\u0016\u0010Z\u001a\u00020Y2\u000e\b\u0002\u0010[\u001a\b\u0012\u0004\u0012\u00020Y0\\J\u0016\u0010]\u001a\u00020Y2\u000e\b\u0002\u0010[\u001a\b\u0012\u0004\u0012\u00020Y0\\J\b\u0010^\u001a\u00020YH\u0002J\u0012\u0010_\u001a\u00020Y2\b\b\u0002\u0010`\u001a\u00020\nH\u0004J\b\u0010a\u001a\u00020YH\u0002J\b\u0010b\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010c\u001a\u00020\nJ\u0010\u0010d\u001a\u00020Y2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001c\u0010e\u001a\u00020\r2\b\b\u0002\u0010f\u001a\u00020\r2\b\b\u0002\u0010g\u001a\u00020hH\u0002J\u001c\u0010i\u001a\u00020\r2\b\b\u0002\u0010f\u001a\u00020\r2\b\b\u0002\u0010g\u001a\u00020hH\u0004J\b\u0010j\u001a\u00020\rH\u0002J\b\u0010k\u001a\u00020\rH\u0016J\u0018\u0010l\u001a\u00020Y2\u0010\b\u0002\u0010m\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010nJ\u0018\u0010p\u001a\u00020Y2\u0010\b\u0002\u0010m\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010nJ\u0010\u0010q\u001a\u00020Y2\b\b\u0002\u0010r\u001a\u00020\rJ\u0010\u0010s\u001a\u00020Y2\b\b\u0002\u0010r\u001a\u00020\rJ\b\u0010t\u001a\u00020YH\u0016J\b\u0010u\u001a\u00020YH\u0014J\u000e\u0010v\u001a\u00020Y2\u0006\u0010w\u001a\u00020\nJ\u0016\u0010x\u001a\u00020Y2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020o0nH\u0002J\u000e\u0010y\u001a\u00020Y2\u0006\u0010w\u001a\u00020\nJ\u0014\u0010z\u001a\u00020Y2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020o0nJ\u0010\u0010{\u001a\u00020\r2\u0006\u0010|\u001a\u00020}H\u0016J\u0019\u0010~\u001a\u00020Y2\u0006\u0010\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0016J$\u0010~\u001a\u00020Y2\u0006\u0010\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010oH\u0016J\u001a\u0010\u0001\u001a\u00020Y2\u0006\u0010\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0016J$\u0010\u0001\u001a\u00020Y2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0016J\u001a\u0010\u0001\u001a\u00020Y2\u0006\u0010\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0016J6\u0010\u0001\u001a\u00020Y2\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0014J\u001b\u0010\u0001\u001a\u00020Y2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0014J-\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020\u00172\u0007\u0010\u0001\u001a\u00020\u00172\u0007\u0010\u0001\u001a\u00020\rH\u0016J$\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020\u00172\u0007\u0010\u0001\u001a\u00020\u0017H\u0016J7\u0010\u0001\u001a\u00020Y2\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\nH\u0016J\\\u0010\u0001\u001a\u00020Y2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00012\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010 \u0001\u001a\u00020\r2\u0007\u0010¡\u0001\u001a\u00020\r2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010¢\u0001\u001a\u00020\rH\u0016J\u0017\u0010£\u0001\u001a\u00020Y2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020o0nH\u0016J\u0017\u0010¤\u0001\u001a\u00020Y2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020o0nH\u0016J\u0017\u0010¥\u0001\u001a\u00020Y2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020o0nH\u0016J\u0007\u0010¦\u0001\u001a\u00020YJ\u0011\u0010§\u0001\u001a\u00020Y2\b\b\u0002\u0010`\u001a\u00020\nJ-\u0010¨\u0001\u001a\u00020\r2\u0007\u0010©\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010ª\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0016J%\u0010«\u0001\u001a\u00020Y2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00012\u0007\u0010\u0001\u001a\u00020\nH\u0016J\u0012\u0010¬\u0001\u001a\u00020Y2\u0007\u0010\u0001\u001a\u00020\nH\u0002J\u0007\u0010­\u0001\u001a\u00020YJ \u0010®\u0001\u001a\u00020Y2\b\u0010¯\u0001\u001a\u00030°\u00012\r\u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020Y0\\J\u0010\u0010²\u0001\u001a\u00020Y2\u0007\u0010³\u0001\u001a\u00020\u001fJ\u0010\u0010´\u0001\u001a\u00020Y2\u0007\u0010µ\u0001\u001a\u00020\u001fJ\u0012\u0010¶\u0001\u001a\u00020Y2\u0007\u0010·\u0001\u001a\u00020\u0017H\u0016J\u0016\u0010¸\u0001\u001a\u00020Y2\r\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020Y0\\R\u0014\u0010\f\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000f\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000f\"\u0004\b+\u0010(R$\u0010,\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010(R\u000e\u0010/\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R$\u00104\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000f\"\u0004\b5\u0010(R\u000e\u00106\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000f\"\u0004\b8\u0010(R\u000e\u00109\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000f\"\u0004\b<\u0010(R\u001a\u0010=\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010?\"\u0004\bD\u0010AR\u0010\u0010E\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010K\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010!\"\u0004\bM\u0010#R\u000e\u0010N\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010O\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010?\"\u0004\bQ\u0010AR\u001c\u0010R\u001a\u0004\u0018\u00010SX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006¾\u0001"}, hxF = {"Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "Lcom/tencent/mm/view/HeadFooterLayout;", "Lcom/tencent/mm/view/IViewActionCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEBUG", "", "getDEBUG", "()Z", "actionCallback", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "getActionCallback", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "setActionCallback", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;)V", "damping", "", "getDamping", "()F", "setDamping", "(F)V", "delaySetHasTopMoreRunnable", "Ljava/lang/Runnable;", "emptyView", "Landroid/view/View;", "getEmptyView", "()Landroid/view/View;", "setEmptyView", "(Landroid/view/View;)V", "value", "enableLoadMore", "getEnableLoadMore", "setEnableLoadMore", "(Z)V", "enablePullDownHeader", "getEnablePullDownHeader", "setEnablePullDownHeader", "enableRefresh", "getEnableRefresh", "setEnableRefresh", "isAnimation", "isAttachLoadMoreAtDown", "isAttachRefreshAtDown", "isAttachRefreshVisitor", "isFirstChangeLayout", "isHasBottomMore", "setHasBottomMore", "isHasPerformHapticFeedback", "isHasTopMore", "setHasTopMore", "isLoadingMore", "isPullDownHeader", "isRefreshing", "setRefreshing", "limitBottomRequest", "getLimitBottomRequest", "()I", "setLimitBottomRequest", "(I)V", "limitTopRequest", "getLimitTopRequest", "setLimitTopRequest", "loadMoreFooter", "loadMoreFooterHeight", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "preLoadMoreItemCount", "preRefreshItemCount", "refreshHeader", "getRefreshHeader", "setRefreshHeader", "refreshHeaderHeight", "refreshTargetY", "getRefreshTargetY", "setRefreshTargetY", "stickTopLoadingLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$StickTopLoadingLayout;", "getStickTopLoadingLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout$StickTopLoadingLayout;", "setStickTopLoadingLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$StickTopLoadingLayout;)V", "animToCollapseHeader", "", "animToFinishLoadMore", "callback", "Lkotlin/Function0;", "animToFinishRefresh", "animToLoadMore", "animToRefresh", "refreshType", "checkEmptyViewVisible", "getLoadMoreFooter", "getRefreshHeaderHeight", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "isAttachLoadMore", "isHard", "invokeSource", "", "isAttachRefresh", "isFlingScope", "isNestedScrollingEnabled", "noFooterMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "noRefreshMore", "onAutoToLoadMore", "isSilence", "onAutoToRefresh", "onChanged", "onDetachedFromWindow", "onFinishLoadMore", "incrementSize", "onFinishLoadMore2", "onFinishRefresh", "onFinishRefresh2", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onItemRangeChanged", "positionStart", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedFling", "target", "velocityX", "velocityY", "consumed", "onNestedPreFling", "onNotOverScroll", "dx", "dy", "", "type", "onOverScroll", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "parent", "dampingDy", "isEnd", "isVertical", "isTopOverScroll", "onPreFinishLoadMore", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "onRequestLoadMore", "onRequestRefresh", "onStartNestedScroll", "child", "axes", "onStopScroll", "pullDown", "reset", "setHasTopMoreDelay", "delay", "", "finish", "setLoadMoreFooter", "footer", "setRefreshHeaderView", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "setTranslationY", "translationY", "uiThread", "block", "ActionCallback", "Companion", "MoreReason", "StickTopLoadingLayout", "libmmui_release"})
public class RefreshLoadMoreLayout extends HeadFooterLayout implements j {
    public static final b Rmg = new b((byte) 0);
    private final boolean DEBUG;
    private boolean RlI;
    private boolean RlJ;
    View RlK;
    private View RlL;
    private int RlM = -1;
    private int RlN = -1;
    private int RlO;
    private int RlP;
    private boolean RlQ;
    private int RlR;
    private int RlS;
    private int RlT = -1;
    private float RlU;
    public boolean RlV = true;
    protected boolean RlW = true;
    private Runnable RlX;
    private a RlY;
    private boolean RlZ = true;
    private boolean Rma = true;
    private boolean Rmb;
    private StickTopLoadingLayout Rmc;
    private boolean Rmd;
    private boolean Rme;
    private boolean Rmf = true;
    private boolean isLoadingMore;
    protected boolean isRefreshing;
    private final MMHandler mainHandler = new MMHandler(Looper.getMainLooper());
    private View poS;
    private boolean ydj = true;

    static {
        AppMethodBeat.i(164644);
        AppMethodBeat.o(164644);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final e Rmz = new e();

        static {
            AppMethodBeat.i(164577);
            AppMethodBeat.o(164577);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final g RmB = new g();

        static {
            AppMethodBeat.i(164581);
            AppMethodBeat.o(164581);
        }

        g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 .*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001.B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\u0019\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010)\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010+\u001a\u00020\u0004HÖ\u0001J\b\u0010,\u001a\u00020-H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u0005R\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\u0005R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006/"}, hxF = {"Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", QLog.TAG_REPORTLEVEL_USER, "", "actionType", "", "(I)V", "getActionType", "()I", "extra", "getExtra", "()Ljava/lang/Object;", "setExtra", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "extraData", "getExtraData", "setExtraData", "hasAnyMore", "", "getHasAnyMore", "()Z", "setHasAnyMore", "(Z)V", "isAnim", "setAnim", "isFooterVisible", "setFooterVisible", "reasonType", "getReasonType", "setReasonType", "remainSize", "getRemainSize", "setRemainSize", "wording", "", "getWording", "()Ljava/lang/CharSequence;", "setWording", "(Ljava/lang/CharSequence;)V", "component1", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "Companion", "libmmui_release"})
    public static final class c<E> {
        private static final int Rmm = 0;
        private static final int Rmn = 1;
        private static final int Rmo = 2;
        private static final int Rmp = 0;
        private static final int Rmq = 1;
        private static final int Rmr = 2;
        public static final a Rms = new a((byte) 0);
        public int Rmh;
        public CharSequence Rmi = "";
        public boolean Rmj = true;
        public int Rmk;
        public boolean Rml;
        public final int actionType;
        public E iMa;
        public boolean jLE = true;
        public E tXF;

        public final boolean equals(Object obj) {
            return this == obj || ((obj instanceof c) && this.actionType == ((c) obj).actionType);
        }

        public final int hashCode() {
            return this.actionType;
        }

        public c(int i2) {
            AppMethodBeat.i(164572);
            this.actionType = i2;
            AppMethodBeat.o(164572);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason$Companion;", "", "()V", "AutoPull", "", "getAutoPull", "()I", "INSERTED", "getINSERTED", "LOADMORE", "getLOADMORE", "Other", "getOther", "REFRESH", "getREFRESH", "TouchPull", "getTouchPull", "libmmui_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(164573);
            AppMethodBeat.o(164573);
        }

        public final String toString() {
            AppMethodBeat.i(164571);
            String str = "(actionType=" + this.actionType + ", reasonType=" + this.Rmh + ", extra=" + ((Object) this.iMa) + ", hasAnyMore=" + this.Rmj + ", isAnim=" + this.jLE + ", remainSize=" + this.Rmk + " isFooterVisible=" + this.Rml + ')';
            AppMethodBeat.o(164571);
            return str;
        }
    }

    public final View getRefreshHeader() {
        return this.RlK;
    }

    public final void setRefreshHeader(View view) {
        this.RlK = view;
    }

    public final int getLimitTopRequest() {
        return this.RlM;
    }

    public final void setLimitTopRequest(int i2) {
        this.RlM = i2;
    }

    public final int getLimitBottomRequest() {
        return this.RlN;
    }

    public final void setLimitBottomRequest(int i2) {
        this.RlN = i2;
    }

    /* access modifiers changed from: protected */
    public final void setRefreshing(boolean z) {
        this.isRefreshing = z;
    }

    public final int getRefreshTargetY() {
        return this.RlT;
    }

    public final void setRefreshTargetY(int i2) {
        this.RlT = i2;
    }

    public final float getDamping() {
        return this.RlU;
    }

    public final void setDamping(float f2) {
        this.RlU = f2;
    }

    public final void setHasBottomMore(boolean z) {
        AppMethodBeat.i(164608);
        if (z) {
            ag(new k(this));
        }
        this.RlV = z;
        AppMethodBeat.o(164608);
    }

    public final void setHasTopMore(boolean z) {
        this.RlW = z;
    }

    public final a getActionCallback() {
        return this.RlY;
    }

    public final void setActionCallback(a aVar) {
        this.RlY = aVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0014\u0010,\u001a\u00020\u001e2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.J\u0006\u00100\u001a\u00020\u001eJ\u000e\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u001aJ\u0006\u00103\u001a\u00020\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R5\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00064"}, hxF = {"Lcom/tencent/mm/view/RefreshLoadMoreLayout$StickTopLoadingLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionCallback", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "getActionCallback", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "setActionCallback", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;)V", "alphaOffset", "getAlphaOffset", "()I", "setAlphaOffset", "(I)V", "isRefreshing", "", "onScrollCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "offset", "", "getOnScrollCallback", "()Lkotlin/jvm/functions/Function1;", "setOnScrollCallback", "(Lkotlin/jvm/functions/Function1;)V", "progressBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getProgressBar", "()Lcom/tencent/mm/ui/widget/MMProcessBar;", "topLoadingOffsetLimit", "getTopLoadingOffsetLimit", "()F", "setTopLoadingOffsetLimit", "(F)V", "onRefreshed", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshing", "onScroll", "y", "reset", "libmmui_release"})
    public static final class StickTopLoadingLayout extends FrameLayout {
        a RlY;
        final MMProcessBar Rmt = new MMProcessBar(getContext());
        float Rmu;
        private kotlin.g.a.b<? super Float, x> Rmv;
        private int Rmw;
        boolean isRefreshing;

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.b<Float, x> {
            public static final a Rmx = new a();

            static {
                AppMethodBeat.i(204985);
                AppMethodBeat.o(204985);
            }

            a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Float f2) {
                AppMethodBeat.i(204984);
                f2.floatValue();
                x xVar = x.SXb;
                AppMethodBeat.o(204984);
                return xVar;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StickTopLoadingLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            kotlin.g.b.p.h(context, "context");
            AppMethodBeat.i(204989);
            Context context2 = getContext();
            kotlin.g.b.p.g(context2, "context");
            this.Rmu = context2.getResources().getDimension(R.dimen.cr);
            this.Rmv = a.Rmx;
            int dimension = (int) getResources().getDimension(R.dimen.ce);
            this.Rmt.setBackgroundResource(R.drawable.apc);
            addView(this.Rmt, new FrameLayout.LayoutParams(dimension, dimension));
            AppMethodBeat.o(204989);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StickTopLoadingLayout(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            kotlin.g.b.p.h(context, "context");
            AppMethodBeat.i(204990);
            Context context2 = getContext();
            kotlin.g.b.p.g(context2, "context");
            this.Rmu = context2.getResources().getDimension(R.dimen.cr);
            this.Rmv = a.Rmx;
            int dimension = (int) getResources().getDimension(R.dimen.ce);
            this.Rmt.setBackgroundResource(R.drawable.apc);
            addView(this.Rmt, new FrameLayout.LayoutParams(dimension, dimension));
            AppMethodBeat.o(204990);
        }

        public final MMProcessBar getProgressBar() {
            return this.Rmt;
        }

        public final float getTopLoadingOffsetLimit() {
            return this.Rmu;
        }

        public final void setTopLoadingOffsetLimit(float f2) {
            this.Rmu = f2;
        }

        public final a getActionCallback() {
            return this.RlY;
        }

        public final void setActionCallback(a aVar) {
            this.RlY = aVar;
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Float, kotlin.x>, kotlin.g.a.b<java.lang.Float, kotlin.x> */
        public final kotlin.g.a.b<Float, x> getOnScrollCallback() {
            return this.Rmv;
        }

        public final void setOnScrollCallback(kotlin.g.a.b<? super Float, x> bVar) {
            AppMethodBeat.i(204986);
            kotlin.g.b.p.h(bVar, "<set-?>");
            this.Rmv = bVar;
            AppMethodBeat.o(204986);
        }

        public final int getAlphaOffset() {
            return this.Rmw;
        }

        public final void setAlphaOffset(int i2) {
            this.Rmw = i2;
        }

        public final void bY(float f2) {
            float f3;
            AppMethodBeat.i(204987);
            if (this.isRefreshing) {
                AppMethodBeat.o(204987);
                return;
            }
            float f4 = f2 - ((float) this.Rmw);
            setVisibility(0);
            if (f4 >= this.Rmu) {
                f3 = this.Rmu;
            } else {
                f3 = f4;
            }
            setAlpha(f3 / this.Rmu);
            this.Rmt.rotate(f4 / 6000.0f);
            setTranslationY(f3);
            this.Rmv.invoke(Float.valueOf(getTranslationY()));
            AppMethodBeat.o(204987);
        }

        public final void i(c<Object> cVar) {
            AppMethodBeat.i(204988);
            kotlin.g.b.p.h(cVar, "reason");
            this.isRefreshing = false;
            setVisibility(8);
            setAlpha(1.0f);
            this.Rmt.gYO();
            this.Rmv.invoke(Float.valueOf(0.0f));
            a aVar = this.RlY;
            if (aVar != null) {
                aVar.onRefreshEnd(cVar);
                AppMethodBeat.o(204988);
                return;
            }
            AppMethodBeat.o(204988);
        }
    }

    public final StickTopLoadingLayout getStickTopLoadingLayout() {
        return this.Rmc;
    }

    public final void setStickTopLoadingLayout(StickTopLoadingLayout stickTopLoadingLayout) {
        this.Rmc = stickTopLoadingLayout;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/view/RefreshLoadMoreLayout$Companion;", "", "()V", "DAMPING", "", "DURATION", "", "PULL_DOWN_DAMPING", "PULL_DOWN_DURATION", "TAG", "", "libmmui_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0017J\b\u0010\u0007\u001a\u00020\u0004H\u0017J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0017J\u0012\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0006H\u0017J\u0016\u0010\r\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0017¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "", "()V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onRefreshBegin", "refreshType", "onRefreshEnd", "libmmui_release"})
    public static abstract class a {
        public void ED(int i2) {
        }

        public void onRefreshEnd(c<Object> cVar) {
            kotlin.g.b.p.h(cVar, "reason");
        }

        public void cxo() {
        }

        public void a(c<Object> cVar) {
            kotlin.g.b.p.h(cVar, "reason");
        }

        public void IF(int i2) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RefreshLoadMoreLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.g.b.p.h(attributeSet, "attrs");
        AppMethodBeat.i(164642);
        init(attributeSet);
        AppMethodBeat.o(164642);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RefreshLoadMoreLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.g.b.p.h(attributeSet, "attrs");
        AppMethodBeat.i(164643);
        init(attributeSet);
        AppMethodBeat.o(164643);
    }

    @Override // com.tencent.mm.view.HeadFooterLayout
    public void a(RecyclerView recyclerView, HeadFooterLayout headFooterLayout, int i2) {
        AppMethodBeat.i(164609);
        kotlin.g.b.p.h(recyclerView, "recyclerView");
        kotlin.g.b.p.h(headFooterLayout, "parent");
        super.a(recyclerView, headFooterLayout, i2);
        if (this.Rmd) {
            this.Rmd = false;
            recyclerView.kQ();
            Log.i("MicroMsg.RLMoreLayout", "animToCollapseHeader");
            if (getTranslationY() != 0.0f) {
                animate().cancel();
                animate().translationY(0.0f).setDuration(240).setListener(new d(this)).start();
            }
            AppMethodBeat.o(164609);
        } else if (i2 != 0) {
            if (a(this, false, "onStopScroll", 1)) {
                Log.w("MicroMsg.RLMoreLayout", "[onStopScroll] isAttachRefresh but type=" + i2 + ' ');
            }
            AppMethodBeat.o(164609);
        } else if (!a(this, false, "onStopScroll", 1)) {
            if (T(true, "onStopScroll") && !this.isLoadingMore && this.RlV) {
                recyclerView.kQ();
                if (((float) ((-this.RlO) - (this.RlP - this.RlN))) > getTranslationY()) {
                    hfS();
                    AppMethodBeat.o(164609);
                    return;
                } else if (((float) ((-this.RlO) - (this.RlP - this.RlN))) < getTranslationY()) {
                    ag(e.Rmz);
                }
            }
            AppMethodBeat.o(164609);
        } else if (this.isRefreshing || !this.RlW) {
            if (this.isRefreshing) {
                c.a aVar = c.Rms;
                apQ(c.Rmq);
            }
            AppMethodBeat.o(164609);
        } else {
            recyclerView.kQ();
            if (((float) (-this.RlM)) < getTranslationY()) {
                c.a aVar2 = c.Rms;
                apQ(c.Rmq);
                AppMethodBeat.o(164609);
                return;
            }
            if (((float) (-this.RlM)) > getTranslationY()) {
                b(this);
            }
            AppMethodBeat.o(164609);
        }
    }

    public final boolean getEnablePullDownHeader() {
        return this.Rme;
    }

    public final void setEnablePullDownHeader(boolean z) {
        this.Rme = z;
    }

    @Override // com.tencent.mm.view.HeadFooterLayout
    public final void a(View view, int i2, int[] iArr) {
        AppMethodBeat.i(164610);
        kotlin.g.b.p.h(view, "target");
        kotlin.g.b.p.h(iArr, "consumed");
        if (this.Rmd) {
            apP(i2);
            iArr[1] = i2;
        }
        AppMethodBeat.o(164610);
    }

    private final void apP(int i2) {
        int i3;
        AppMethodBeat.i(164611);
        if (((int) (((float) i2) / 1.5f)) == 0) {
            i3 = i2 > 0 ? 1 : -1;
        } else {
            i3 = (int) (((float) i2) / 1.5f);
        }
        this.Rmd = true;
        setTranslationY(getTranslationY() - ((float) i3));
        Log.d("MicroMsg.RLMoreLayout", "onNotOverScroll enablePullDownHeader " + i3 + ", " + getTranslationY() + ", " + i2);
        if (getTranslationY() < 0.0f) {
            setTranslationY(0.0f);
        }
        AppMethodBeat.o(164611);
    }

    @Override // com.tencent.mm.view.HeadFooterLayout
    public void a(RecyclerView recyclerView, HeadFooterLayout headFooterLayout, int i2, int i3, boolean z, boolean z2, int[] iArr, int i4, boolean z3) {
        int i5;
        View view;
        View view2;
        View findViewById;
        View findViewById2;
        AppMethodBeat.i(164612);
        kotlin.g.b.p.h(recyclerView, "recyclerView");
        kotlin.g.b.p.h(headFooterLayout, "parent");
        kotlin.g.b.p.h(iArr, "consumed");
        if (i4 == 0 && this.RlX != null) {
            this.mainHandler.removeCallbacks(this.RlX);
            View view3 = this.RlK;
            if (!(view3 == null || (findViewById2 = view3.findViewById(R.id.h7v)) == null)) {
                findViewById2.setVisibility(0);
            }
            View view4 = this.RlK;
            if (!(view4 == null || (findViewById = view4.findViewById(R.id.gyj)) == null)) {
                findViewById.setVisibility(8);
            }
            View view5 = this.RlK;
            if (view5 != null) {
                view5.setVisibility(4);
            }
            this.RlW = true;
            this.RlX = null;
        }
        boolean T = T(false, "onOverScroll");
        boolean w = w(recyclerView);
        if (this.Rma && !this.Rmb && ((float) (-this.RlM)) < getTranslationY() && i4 == 0) {
            performHapticFeedback(0, 2);
            this.Rmb = true;
        }
        if (i4 != 1 || ((!T || this.isLoadingMore || !this.RlV) && (!w || this.isRefreshing))) {
            boolean a2 = a(this, false, "onOverScroll", 1);
            boolean T2 = T(true, "onOverScroll");
            if (!this.Rme || i4 != 0 || !z3) {
                if (this.Rmd) {
                    HeadFooterLayout.dD("[onOverScroll] isPullDownHeader ：" + this.Rmd, true);
                    AppMethodBeat.o(164612);
                    return;
                }
            } else if (i2 < 0 || this.Rmd) {
                apP(i2);
                iArr[1] = i2;
                HeadFooterLayout.dD("[onOverScroll] pullDown", true);
                AppMethodBeat.o(164612);
                return;
            }
            if (i4 == 0 || !w || !this.isRefreshing || i2 >= 0 || getTranslationY() <= ((float) this.RlT) || this.RlT == -1) {
                if ((!a2 || i2 >= 0 || !this.RlW) && (!T2 || i2 <= 0 || !this.RlV)) {
                    i5 = i2;
                } else {
                    i5 = (int) (((float) i2) / (this.RlU == 0.0f ? 3.0f : this.RlU));
                }
                if ((a2 && i2 < 0) || (T2 && i2 > 0)) {
                    if (a2 && (view2 = this.RlK) != null) {
                        view2.setVisibility(0);
                    }
                    if (T2 && (view = this.RlL) != null) {
                        view.setVisibility(0);
                    }
                }
                super.a(recyclerView, headFooterLayout, i2, i5, z, z2, iArr, i4, z3);
                AppMethodBeat.o(164612);
                return;
            }
            dD("[onOverScroll] isFirstItemReachTop  stopScroll", false);
            recyclerView.kQ();
            AppMethodBeat.o(164612);
        } else if (!this.Rmf || !w || i2 >= 0) {
            if (this.ydj && T && i2 > 0) {
                recyclerView.kQ();
            }
            AppMethodBeat.o(164612);
        } else {
            recyclerView.kQ();
            AppMethodBeat.o(164612);
        }
    }

    @Override // com.tencent.mm.view.HeadFooterLayout
    public void setTranslationY(float f2) {
        AppMethodBeat.i(204997);
        super.setTranslationY(f2);
        StickTopLoadingLayout stickTopLoadingLayout = this.Rmc;
        if (stickTopLoadingLayout != null) {
            stickTopLoadingLayout.bY(((float) getRefreshHeaderHeight()) - Math.abs(f2));
            AppMethodBeat.o(204997);
            return;
        }
        AppMethodBeat.o(204997);
    }

    @Override // com.tencent.mm.view.HeadFooterLayout
    public boolean isNestedScrollingEnabled() {
        return true;
    }

    @Override // android.support.v4.view.m
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        AppMethodBeat.i(204998);
        kotlin.g.b.p.h(view, "target");
        boolean onNestedFling = super.onNestedFling(view, f2, f3, z);
        AppMethodBeat.o(204998);
        return onNestedFling;
    }

    @Override // android.support.v4.view.m
    public boolean onNestedPreFling(View view, float f2, float f3) {
        AppMethodBeat.i(204999);
        kotlin.g.b.p.h(view, "target");
        boolean onNestedPreFling = super.onNestedPreFling(view, f2, f3);
        AppMethodBeat.o(204999);
        return onNestedPreFling;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.HeadFooterLayout
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5 = 0;
        AppMethodBeat.i(164613);
        super.onMeasure(i2, i3);
        if (this.RlK != null) {
            View view = this.RlK;
            if (view == null) {
                kotlin.g.b.p.hyc();
            }
            i4 = view.getMeasuredHeight();
        } else {
            i4 = 0;
        }
        this.RlO = i4;
        if (this.RlL != null) {
            View view2 = this.RlL;
            if (view2 == null) {
                kotlin.g.b.p.hyc();
            }
            i5 = view2.getMeasuredHeight();
        }
        this.RlP = i5;
        if (-1 == this.RlM) {
            this.RlM = (int) (((float) this.RlO) * 0.15f);
        }
        if (-1 == this.RlN) {
            this.RlN = (int) (((float) this.RlP) * 0.15f);
        }
        AppMethodBeat.o(164613);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(164614);
        super.onLayout(z, i2, i3, i4, i5);
        if (z && this.RlZ) {
            setTranslationY(-((float) this.RlO));
            this.RlZ = false;
        }
        AppMethodBeat.o(164614);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(164615);
        kotlin.g.b.p.h(motionEvent, "ev");
        if (this.RlQ) {
            AppMethodBeat.o(164615);
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.RlI = S(false, "onInterceptTouchEvent ACTION_DOWN");
                this.RlJ = T(false, "onInterceptTouchEvent ACTION_DOWN");
                dD("[onInterceptTouchEvent] ACTION_DOWN isAttachRefreshAtDown=" + this.RlI + " isAttachLoadMoreAtDown=" + this.RlJ, false);
                break;
            case 1:
            case 3:
                dD("[onInterceptTouchEvent] ACTION_UP isAttachRefreshAtDown=" + this.RlI + " isAttachLoadMoreAtDown=" + this.RlJ, false);
                break;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(164615);
        return onInterceptTouchEvent;
    }

    private final void init(AttributeSet attributeSet) {
        AppMethodBeat.i(164616);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0244a.RefreshLoadMoreLayout);
        kotlin.g.b.p.g(obtainStyledAttributes, "tArray");
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 1) {
                int resourceId = obtainStyledAttributes.getResourceId(1, 0);
                if (resourceId != 0) {
                    this.RlK = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) null);
                    View view = this.RlK;
                    if (view != null) {
                        view.setVisibility(4);
                    }
                    View view2 = this.RlK;
                    if (view2 == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.o(164616);
                        throw tVar;
                    }
                    W(view2, false);
                } else {
                    continue;
                }
            } else if (index == 0) {
                int resourceId2 = obtainStyledAttributes.getResourceId(0, 0);
                Log.i("MicroMsg.RLMoreLayout", "check footer res " + resourceId2 + " i " + i2);
                if (resourceId2 != 0) {
                    this.RlL = LayoutInflater.from(getContext()).inflate(resourceId2, (ViewGroup) this, false);
                    View view3 = this.RlL;
                    if (view3 != null) {
                        view3.setVisibility(4);
                    }
                    View view4 = this.RlL;
                    if (view4 == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.o(164616);
                        throw tVar2;
                    }
                    Y(view4, false);
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        Log.i("MicroMsg.RLMoreLayout", "has static refreshHeader=" + this.RlK + " loadMoreFooter=" + this.RlL + " hash=" + hashCode());
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(164616);
    }

    public final void setLoadMoreFooter(View view) {
        AppMethodBeat.i(164617);
        kotlin.g.b.p.h(view, "footer");
        View view2 = this.RlL;
        if (view2 != null) {
            Z(view2, true);
        }
        Y(view, true);
        this.RlL = view;
        View view3 = this.RlL;
        if (view3 != null) {
            view3.setVisibility(4);
            AppMethodBeat.o(164617);
            return;
        }
        AppMethodBeat.o(164617);
    }

    public final View getLoadMoreFooter() {
        return this.RlL;
    }

    public final boolean getEnableRefresh() {
        return this.Rmf;
    }

    public final void setEnableRefresh(boolean z) {
        AppMethodBeat.i(164618);
        this.Rmf = z;
        if (!this.Rmf && this.RlK != null) {
            View view = this.RlK;
            if (view == null) {
                kotlin.g.b.p.hyc();
            }
            X(view, false);
            this.RlK = null;
            if (getTranslationY() <= ((float) (0 - this.RlO))) {
                setTranslationY(getTranslationY() + ((float) this.RlO));
            }
            Log.i("MicroMsg.RLMoreLayout", "set enableRefresh false and remove header, " + getTranslationY() + ", " + this.RlO + " hash=" + hashCode());
        }
        Log.i("MicroMsg.RLMoreLayout", "set enableRefresh " + z + " hash=" + hashCode());
        AppMethodBeat.o(164618);
    }

    public final boolean getEnableLoadMore() {
        return this.ydj;
    }

    public final void setEnableLoadMore(boolean z) {
        AppMethodBeat.i(205001);
        this.ydj = z;
        if (!this.ydj && this.RlL != null) {
            View view = this.RlL;
            if (view == null) {
                kotlin.g.b.p.hyc();
            }
            Z(view, false);
            this.RlL = null;
            if (getTranslationY() > ((float) this.RlO)) {
                setTranslationY((float) this.RlO);
            }
            Log.i("MicroMsg.RLMoreLayout", "set enableLoadMore false and remove footer hash=" + hashCode() + ", " + getTranslationY() + ", " + this.RlO);
        }
        Log.i("MicroMsg.RLMoreLayout", "set enableLoadMore " + z + ", hash=" + hashCode());
        AppMethodBeat.o(205001);
    }

    public final void setRefreshHeaderView(View view) {
        AppMethodBeat.i(164619);
        kotlin.g.b.p.h(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        this.RlZ = true;
        View view2 = this.RlK;
        if (view2 != null) {
            X(view2, true);
        }
        W(view, true);
        setEnableRefresh(true);
        this.RlK = view;
        View view3 = this.RlK;
        if (view3 != null) {
            view3.setVisibility(4);
            AppMethodBeat.o(164619);
            return;
        }
        AppMethodBeat.o(164619);
    }

    public static /* synthetic */ boolean a(RefreshLoadMoreLayout refreshLoadMoreLayout, boolean z, String str, int i2) {
        AppMethodBeat.i(205003);
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            str = "";
        }
        boolean S = refreshLoadMoreLayout.S(z, str);
        AppMethodBeat.o(205003);
        return S;
    }

    private boolean S(boolean z, String str) {
        AppMethodBeat.i(205002);
        kotlin.g.b.p.h(str, "invokeSource");
        if (this.RlK == null || !this.Rmf) {
            AppMethodBeat.o(205002);
            return false;
        }
        RecyclerView.LayoutManager layoutManager = getRecyclerView().getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            if (this.DEBUG) {
                Log.i("MicroMsg.RLMoreLayout", "isAttachRefresh " + str + " isHard " + z + " translationY:" + getTranslationY() + " refreshHeaderHeight:" + this.RlO + " findFirstCompletelyVisibleItemPosition:" + ((LinearLayoutManager) layoutManager).kt());
            }
            if (z) {
                if (getTranslationY() > ((float) (-this.RlO))) {
                    AppMethodBeat.o(205002);
                    return true;
                }
                AppMethodBeat.o(205002);
                return false;
            } else if (getTranslationY() < ((float) (-this.RlO)) || ((LinearLayoutManager) layoutManager).kt() != 0) {
                AppMethodBeat.o(205002);
                return false;
            } else {
                AppMethodBeat.o(205002);
                return true;
            }
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] mD = ((StaggeredGridLayoutManager) layoutManager).mD();
            kotlin.g.b.p.g(mD, "lastInfo");
            boolean z2 = false;
            for (int i2 : mD) {
                if (i2 == 0) {
                    z2 = true;
                }
            }
            if (z) {
                if (getTranslationY() > ((float) (-this.RlO))) {
                    AppMethodBeat.o(205002);
                    return true;
                }
                AppMethodBeat.o(205002);
                return false;
            } else if (getTranslationY() < ((float) (-this.RlO)) || !z2) {
                AppMethodBeat.o(205002);
                return false;
            } else {
                AppMethodBeat.o(205002);
                return true;
            }
        } else {
            AppMethodBeat.o(205002);
            return false;
        }
    }

    private final boolean T(boolean z, String str) {
        boolean z2;
        AppMethodBeat.i(205004);
        if (this.RlL == null) {
            AppMethodBeat.o(205004);
            return false;
        }
        RecyclerView.LayoutManager layoutManager = getRecyclerView().getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            if (z) {
                if (getTranslationY() < ((float) (-getHeadersHeight()))) {
                    AppMethodBeat.o(205004);
                    return true;
                }
                AppMethodBeat.o(205004);
                return false;
            } else if (getTranslationY() > ((float) (-getHeadersHeight())) || !x(getRecyclerView())) {
                AppMethodBeat.o(205004);
                return false;
            } else {
                AppMethodBeat.o(205004);
                return true;
            }
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] mE = ((StaggeredGridLayoutManager) layoutManager).mE();
            kotlin.g.b.p.g(mE, "lastInfo");
            int length = mE.length;
            int i2 = 0;
            boolean z3 = false;
            while (i2 < length) {
                if (mE[i2] == ((StaggeredGridLayoutManager) layoutManager).getItemCount() - 1) {
                    z2 = true;
                } else {
                    z2 = z3;
                }
                i2++;
                z3 = z2;
            }
            dD("[isAttachLoadMore] " + str + " isHard " + z + " translationY:" + getTranslationY() + " headersHeight:" + getHeadersHeight() + " loadingLast:" + z3 + " itemCount " + ((StaggeredGridLayoutManager) layoutManager).getItemCount(), false);
            if (z) {
                if (getTranslationY() < ((float) (-getHeadersHeight()))) {
                    AppMethodBeat.o(205004);
                    return true;
                }
                AppMethodBeat.o(205004);
                return false;
            } else if (getTranslationY() > ((float) (-getHeadersHeight())) || !z3 || ((StaggeredGridLayoutManager) layoutManager).getItemCount() == 0) {
                AppMethodBeat.o(205004);
                return false;
            } else {
                AppMethodBeat.o(205004);
                return true;
            }
        } else {
            AppMethodBeat.o(205004);
            return false;
        }
    }

    public static /* synthetic */ void a(RefreshLoadMoreLayout refreshLoadMoreLayout) {
        AppMethodBeat.i(205006);
        c.a aVar = c.Rms;
        refreshLoadMoreLayout.apQ(c.Rmp);
        AppMethodBeat.o(205006);
    }

    private void apQ(int i2) {
        float f2;
        AppMethodBeat.i(205005);
        if (this.RlT == -1) {
            f2 = 0.0f;
        } else if (this.Rmc != null) {
            f2 = -((float) this.RlO);
        } else {
            f2 = (float) this.RlT;
        }
        apR(i2);
        animate().cancel();
        animate().translationY(f2).setDuration(240).setListener(new j(this, f2)).start();
        AppMethodBeat.o(205005);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/view/RefreshLoadMoreLayout$animToRefresh$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
    public static final class j implements Animator.AnimatorListener {
        final /* synthetic */ float RmC;
        final /* synthetic */ RefreshLoadMoreLayout Rmy;

        j(RefreshLoadMoreLayout refreshLoadMoreLayout, float f2) {
            this.Rmy = refreshLoadMoreLayout;
            this.RmC = f2;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(164585);
            this.Rmy.RlQ = false;
            this.Rmy.setTranslationY(this.RmC);
            AppMethodBeat.o(164585);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(164586);
            AppMethodBeat.o(164586);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(164587);
            this.Rmy.RlQ = true;
            AppMethodBeat.o(164587);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/view/RefreshLoadMoreLayout$animToCollapseHeader$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
    public static final class d implements Animator.AnimatorListener {
        final /* synthetic */ RefreshLoadMoreLayout Rmy;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(RefreshLoadMoreLayout refreshLoadMoreLayout) {
            this.Rmy = refreshLoadMoreLayout;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(164574);
            this.Rmy.RlQ = false;
            this.Rmy.setTranslationY(0.0f);
            AppMethodBeat.o(164574);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(164575);
            AppMethodBeat.o(164575);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(164576);
            this.Rmy.RlQ = true;
            AppMethodBeat.o(164576);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class v implements Runnable {
        final /* synthetic */ kotlin.g.a.a RmL;
        final /* synthetic */ RefreshLoadMoreLayout Rmy;

        v(RefreshLoadMoreLayout refreshLoadMoreLayout, kotlin.g.a.a aVar) {
            this.Rmy = refreshLoadMoreLayout;
            this.RmL = aVar;
        }

        public final void run() {
            AppMethodBeat.i(164607);
            this.Rmy.af(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.view.RefreshLoadMoreLayout.v.AnonymousClass1 */
                final /* synthetic */ v RmM;

                {
                    this.RmM = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    View findViewById;
                    View findViewById2;
                    AppMethodBeat.i(164606);
                    View refreshHeader = this.RmM.Rmy.getRefreshHeader();
                    if (!(refreshHeader == null || (findViewById2 = refreshHeader.findViewById(R.id.h7v)) == null)) {
                        findViewById2.setVisibility(0);
                    }
                    View refreshHeader2 = this.RmM.Rmy.getRefreshHeader();
                    if (!(refreshHeader2 == null || (findViewById = refreshHeader2.findViewById(R.id.gyj)) == null)) {
                        findViewById.setVisibility(8);
                    }
                    View refreshHeader3 = this.RmM.Rmy.getRefreshHeader();
                    if (refreshHeader3 != null) {
                        refreshHeader3.setVisibility(4);
                    }
                    this.RmM.Rmy.setHasTopMore(true);
                    x xVar = x.SXb;
                    AppMethodBeat.o(164606);
                    return xVar;
                }
            });
            this.RmL.invoke();
            AppMethodBeat.o(164607);
        }
    }

    public final void b(long j2, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(205007);
        kotlin.g.b.p.h(aVar, "finish");
        this.RlX = new v(this, aVar);
        this.mainHandler.postDelayed(this.RlX, j2);
        AppMethodBeat.o(205007);
    }

    public static /* synthetic */ void b(RefreshLoadMoreLayout refreshLoadMoreLayout) {
        AppMethodBeat.i(164625);
        refreshLoadMoreLayout.af(g.RmB);
        AppMethodBeat.o(164625);
    }

    public final void af(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(164624);
        kotlin.g.b.p.h(aVar, "callback");
        float f2 = -((float) this.RlO);
        if (this.DEBUG) {
            Log.i("MicroMsg.RLMoreLayout", "animToFinishRefresh " + getTranslationY() + " rectHeight:" + f2);
        }
        if (!a(this, false, "onInterceptTouchEvent animToFinishRefresh", 1)) {
            aVar.invoke();
            this.Rmb = false;
            AppMethodBeat.o(164624);
            return;
        }
        animate().cancel();
        animate().translationY(f2).setDuration(240).setUpdateListener(new h(this)).setListener(new i(this, f2, aVar)).start();
        AppMethodBeat.o(164624);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class h implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ RefreshLoadMoreLayout Rmy;

        h(RefreshLoadMoreLayout refreshLoadMoreLayout) {
            this.Rmy = refreshLoadMoreLayout;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(204991);
            kotlin.g.a.m<Integer, Integer, x> onTranslateYCallback = this.Rmy.getOnTranslateYCallback();
            if (onTranslateYCallback != null) {
                onTranslateYCallback.invoke(0, Integer.valueOf((int) this.Rmy.getTranslationY()));
            }
            StickTopLoadingLayout stickTopLoadingLayout = this.Rmy.getStickTopLoadingLayout();
            if (stickTopLoadingLayout != null) {
                stickTopLoadingLayout.bY(((float) this.Rmy.getRefreshHeaderHeight()) - Math.abs(this.Rmy.getTranslationY()));
                AppMethodBeat.o(204991);
                return;
            }
            AppMethodBeat.o(204991);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/view/RefreshLoadMoreLayout$animToFinishRefresh$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
    public static final class i implements Animator.AnimatorListener {
        final /* synthetic */ float RmC;
        final /* synthetic */ RefreshLoadMoreLayout Rmy;
        final /* synthetic */ kotlin.g.a.a ihE;

        i(RefreshLoadMoreLayout refreshLoadMoreLayout, float f2, kotlin.g.a.a aVar) {
            this.Rmy = refreshLoadMoreLayout;
            this.RmC = f2;
            this.ihE = aVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(204992);
            this.Rmy.RlQ = false;
            this.Rmy.setTranslationY(this.RmC);
            this.Rmy.Rmb = false;
            this.ihE.invoke();
            AppMethodBeat.o(204992);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(204993);
            this.Rmy.RlQ = true;
            AppMethodBeat.o(204993);
        }
    }

    public final void ag(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(164626);
        kotlin.g.b.p.h(aVar, "callback");
        Rect rect = new Rect(0, 0, 0, 0);
        View view = this.RlL;
        if (view != null) {
            view.getGlobalVisibleRect(rect);
        }
        z.c cVar = new z.c();
        cVar.SYD = getTranslationY() + ((float) rect.height());
        if (this.DEBUG) {
            Log.i("MicroMsg.RLMoreLayout", "animToFinishLoadMore " + getTranslationY() + " rectHeight:" + rect.height() + " targetY:" + cVar.SYD);
        }
        if (cVar.SYD >= ((float) (-this.RlO))) {
            cVar.SYD = -((float) this.RlO);
        }
        animate().cancel();
        animate().translationY(cVar.SYD).setDuration(240).setListener(new f(this, cVar, aVar)).start();
        AppMethodBeat.o(164626);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/view/RefreshLoadMoreLayout$animToFinishLoadMore$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"})
    public static final class f implements Animator.AnimatorListener {
        final /* synthetic */ z.c RmA;
        final /* synthetic */ RefreshLoadMoreLayout Rmy;
        final /* synthetic */ kotlin.g.a.a ihE;

        f(RefreshLoadMoreLayout refreshLoadMoreLayout, z.c cVar, kotlin.g.a.a aVar) {
            this.Rmy = refreshLoadMoreLayout;
            this.RmA = cVar;
            this.ihE = aVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(164578);
            this.Rmy.RlQ = false;
            this.Rmy.setTranslationY(this.RmA.SYD);
            this.ihE.invoke();
            AppMethodBeat.o(164578);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(164579);
            AppMethodBeat.o(164579);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(164580);
            this.Rmy.RlQ = true;
            AppMethodBeat.o(164580);
        }
    }

    public final void DD(boolean z) {
        AppMethodBeat.i(205008);
        Log.i("MicroMsg.RLMoreLayout", "[onAutoToRefresh] isSilence=".concat(String.valueOf(z)));
        if (z) {
            c.a aVar = c.Rms;
            apR(c.Rmr);
            AppMethodBeat.o(205008);
            return;
        }
        c.a aVar2 = c.Rms;
        apQ(c.Rmr);
        AppMethodBeat.o(205008);
    }

    public static /* synthetic */ void c(RefreshLoadMoreLayout refreshLoadMoreLayout) {
        AppMethodBeat.i(205010);
        refreshLoadMoreLayout.DE(false);
        AppMethodBeat.o(205010);
    }

    public final void DE(boolean z) {
        AppMethodBeat.i(205009);
        Log.i("MicroMsg.RLMoreLayout", "[onAutoToLoadMore] isSilence=".concat(String.valueOf(z)));
        if (z) {
            hfS();
            AppMethodBeat.o(205009);
            return;
        }
        hfS();
        AppMethodBeat.o(205009);
    }

    public static /* synthetic */ void d(RefreshLoadMoreLayout refreshLoadMoreLayout) {
        AppMethodBeat.i(205012);
        c.a aVar = c.Rms;
        refreshLoadMoreLayout.apR(c.Rmp);
        AppMethodBeat.o(205012);
    }

    private void apR(int i2) {
        AppMethodBeat.i(205011);
        Log.i("MicroMsg.RLMoreLayout", "[onRequestRefresh] isHasTopMore=" + this.RlW + " isRefreshing=" + this.isRefreshing);
        if (!this.RlW) {
            AppMethodBeat.o(205011);
        } else if (this.isRefreshing) {
            AppMethodBeat.o(205011);
        } else {
            u uVar = new u(this, i2);
            Thread currentThread = Thread.currentThread();
            Looper mainLooper = Looper.getMainLooper();
            kotlin.g.b.p.g(mainLooper, "Looper.getMainLooper()");
            if (kotlin.g.b.p.j(currentThread, mainLooper.getThread())) {
                uVar.invoke();
                AppMethodBeat.o(205011);
                return;
            }
            h(new t(uVar));
            AppMethodBeat.o(205011);
        }
    }

    private void hfS() {
        AppMethodBeat.i(164628);
        if (!this.RlV) {
            Log.i("MicroMsg.RLMoreLayout", "has't any more");
            AppMethodBeat.o(164628);
        } else if (this.isLoadingMore) {
            Log.i("MicroMsg.RLMoreLayout", "isLoadingMore...");
            AppMethodBeat.o(164628);
        } else {
            this.isLoadingMore = true;
            s sVar = new s(this);
            Thread currentThread = Thread.currentThread();
            Looper mainLooper = Looper.getMainLooper();
            kotlin.g.b.p.g(mainLooper, "Looper.getMainLooper()");
            if (kotlin.g.b.p.j(currentThread, mainLooper.getThread())) {
                sVar.invoke();
                AppMethodBeat.o(164628);
                return;
            }
            post(new r(sVar));
            AppMethodBeat.o(164628);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class r implements Runnable {
        final /* synthetic */ kotlin.g.a.a qgW;

        r(kotlin.g.a.a aVar) {
            this.qgW = aVar;
        }

        public final void run() {
            AppMethodBeat.i(164601);
            this.qgW.invoke();
            AppMethodBeat.o(164601);
        }
    }

    public final void apS(int i2) {
        AppMethodBeat.i(205013);
        h(new n(this, i2));
        AppMethodBeat.o(205013);
    }

    public final void apT(int i2) {
        AppMethodBeat.i(164629);
        h(new l(this, i2));
        AppMethodBeat.o(164629);
    }

    public final void g(c<Object> cVar) {
        AppMethodBeat.i(164630);
        kotlin.g.b.p.h(cVar, "reason");
        h(new o(this, cVar));
        AppMethodBeat.o(164630);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(164631);
        super.onDetachedFromWindow();
        reset();
        AppMethodBeat.o(164631);
    }

    public final void reset() {
        AppMethodBeat.i(164632);
        this.RlZ = true;
        this.isRefreshing = false;
        this.isLoadingMore = false;
        this.RlQ = false;
        setTranslationY(-((float) this.RlO));
        View view = this.RlK;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.RlL;
        if (view2 != null) {
            view2.setVisibility(4);
            AppMethodBeat.o(164632);
            return;
        }
        AppMethodBeat.o(164632);
    }

    @Override // com.tencent.mm.view.i
    public void onPreFinishRefresh(c<Object> cVar) {
        AppMethodBeat.i(164633);
        kotlin.g.b.p.h(cVar, "reason");
        g(cVar);
        AppMethodBeat.o(164633);
    }

    @Override // com.tencent.mm.view.i
    public void onPreFinishLoadMoreSmooth(c<Object> cVar) {
        AppMethodBeat.i(164634);
        kotlin.g.b.p.h(cVar, "reason");
        h(new q(this, cVar));
        AppMethodBeat.o(164634);
    }

    public static /* synthetic */ void e(RefreshLoadMoreLayout refreshLoadMoreLayout) {
        AppMethodBeat.i(164636);
        refreshLoadMoreLayout.h((c<Object>) null);
        AppMethodBeat.o(164636);
    }

    public final void h(c<Object> cVar) {
        View findViewById;
        TextView textView;
        TextView textView2;
        CharSequence charSequence;
        AppMethodBeat.i(164635);
        Log.d("MicroMsg.RLMoreLayout", "noFooterMore reason: ".concat(String.valueOf(cVar)));
        setHasBottomMore(false);
        View view = this.RlL;
        if (!(view == null || (textView2 = (TextView) view.findViewById(R.id.ep1)) == null)) {
            if (cVar == null || (charSequence = cVar.Rmi) == null) {
                textView2.setText(R.string.ek8);
            } else {
                textView2.setText(charSequence);
            }
        }
        View view2 = this.RlL;
        if (view2 == null || (findViewById = view2.findViewById(R.id.ep0)) == null) {
            AppMethodBeat.o(164635);
            return;
        }
        View view3 = this.RlL;
        if (!(view3 == null || (textView = (TextView) view3.findViewById(R.id.ep1)) == null)) {
            textView.setVisibility(8);
        }
        findViewById.setVisibility(0);
        AppMethodBeat.o(164635);
    }

    public final boolean getDEBUG() {
        return this.DEBUG;
    }

    public final View getEmptyView() {
        return this.poS;
    }

    public final void setEmptyView(View view) {
        this.poS = view;
    }

    @Override // com.tencent.mm.view.j
    public void onChanged() {
        AppMethodBeat.i(164637);
        RecyclerView.a adapter = getRecyclerView().getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
            AppMethodBeat.o(164637);
            return;
        }
        AppMethodBeat.o(164637);
    }

    @Override // com.tencent.mm.view.j
    public void onItemRangeChanged(int i2, int i3) {
        RecyclerView.a adapter;
        AppMethodBeat.i(205015);
        if (i3 <= 0 || (adapter = getRecyclerView().getAdapter()) == null) {
            AppMethodBeat.o(205015);
            return;
        }
        adapter.aq(i2, i3);
        AppMethodBeat.o(205015);
    }

    @Override // com.tencent.mm.view.j
    public void onItemRangeChanged(int i2, int i3, Object obj) {
        RecyclerView.a adapter;
        AppMethodBeat.i(164638);
        if (i3 <= 0 || (adapter = getRecyclerView().getAdapter()) == null) {
            AppMethodBeat.o(164638);
            return;
        }
        adapter.e(i2, i3, obj);
        AppMethodBeat.o(164638);
    }

    @Override // com.tencent.mm.view.j
    public void onItemRangeInserted(int i2, int i3) {
        AppMethodBeat.i(164639);
        if (i3 > 0) {
            RecyclerView.a adapter = getRecyclerView().getAdapter();
            if (adapter != null) {
                adapter.as(i2, i3);
            }
            getRecyclerView().post(new p(this, i3));
        }
        AppMethodBeat.o(164639);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class p implements Runnable {
        final /* synthetic */ RefreshLoadMoreLayout Rmy;
        final /* synthetic */ int tYh;

        p(RefreshLoadMoreLayout refreshLoadMoreLayout, int i2) {
            this.Rmy = refreshLoadMoreLayout;
            this.tYh = i2;
        }

        public final void run() {
            AppMethodBeat.i(164596);
            a actionCallback = this.Rmy.getActionCallback();
            if (actionCallback != null) {
                actionCallback.IF(this.tYh);
                AppMethodBeat.o(164596);
                return;
            }
            AppMethodBeat.o(164596);
        }
    }

    @Override // com.tencent.mm.view.j
    public void onItemRangeRemoved(int i2, int i3) {
        RecyclerView.a adapter;
        AppMethodBeat.i(164640);
        if (i3 <= 0 || (adapter = getRecyclerView().getAdapter()) == null) {
            AppMethodBeat.o(164640);
            return;
        }
        adapter.at(i2, i3);
        AppMethodBeat.o(164640);
    }

    public final int getRefreshHeaderHeight() {
        return this.RlO;
    }

    private void h(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(164641);
        kotlin.g.b.p.h(aVar, "block");
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        kotlin.g.b.p.g(mainLooper, "Looper.getMainLooper()");
        if (kotlin.g.b.p.j(currentThread, mainLooper.getThread())) {
            aVar.invoke();
            AppMethodBeat.o(164641);
            return;
        }
        this.mainHandler.post(new n(aVar));
        AppMethodBeat.o(164641);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class k extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ RefreshLoadMoreLayout Rmy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(RefreshLoadMoreLayout refreshLoadMoreLayout) {
            super(0);
            this.Rmy = refreshLoadMoreLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            View findViewById;
            TextView textView;
            AppMethodBeat.i(164588);
            View view = this.Rmy.RlL;
            if (view != null) {
                view.setVisibility(4);
            }
            View view2 = this.Rmy.RlL;
            if (!(view2 == null || (textView = (TextView) view2.findViewById(R.id.ep1)) == null)) {
                textView.setText(R.string.wc);
            }
            View view3 = this.Rmy.RlL;
            if (!(view3 == null || (findViewById = view3.findViewById(R.id.ep0)) == null)) {
                findViewById.setVisibility(8);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(164588);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, hxF = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
    public static final class u extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ int RmK;
        final /* synthetic */ RefreshLoadMoreLayout Rmy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(RefreshLoadMoreLayout refreshLoadMoreLayout, int i2) {
            super(0);
            this.Rmy = refreshLoadMoreLayout;
            this.RmK = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z;
            Integer num;
            AppMethodBeat.i(164604);
            Log.i("MicroMsg.RLMoreLayout", "[onRequestRefresh]");
            this.Rmy.setRefreshing(true);
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.Rmy;
            RecyclerView.a adapter = this.Rmy.getRecyclerView().getAdapter();
            refreshLoadMoreLayout.RlR = adapter != null ? adapter.getItemCount() : 0;
            View refreshHeader = this.Rmy.getRefreshHeader();
            if (refreshHeader != null) {
                refreshHeader.setVisibility(0);
            }
            this.Rmy.RlI = false;
            this.Rmy.RlJ = false;
            StringBuilder sb = new StringBuilder("[onRequestRefresh], stickTopLoadingLayout is null? ");
            if (this.Rmy.getStickTopLoadingLayout() == null) {
                z = true;
            } else {
                z = false;
            }
            StringBuilder append = sb.append(z).append(", hash:");
            a actionCallback = this.Rmy.getActionCallback();
            if (actionCallback != null) {
                num = Integer.valueOf(actionCallback.hashCode());
            } else {
                num = null;
            }
            Log.i("MicroMsg.RLMoreLayout", append.append(num).toString());
            StickTopLoadingLayout stickTopLoadingLayout = this.Rmy.getStickTopLoadingLayout();
            if (stickTopLoadingLayout != null) {
                stickTopLoadingLayout.bY(stickTopLoadingLayout.Rmu);
                stickTopLoadingLayout.isRefreshing = true;
                stickTopLoadingLayout.setVisibility(0);
                stickTopLoadingLayout.setAlpha(1.0f);
                stickTopLoadingLayout.Rmt.setVisibility(0);
                stickTopLoadingLayout.Rmt.gYP();
                a aVar = stickTopLoadingLayout.RlY;
                if (aVar != null) {
                    c.a aVar2 = c.Rms;
                    aVar.ED(c.Rmp);
                }
            }
            a actionCallback2 = this.Rmy.getActionCallback();
            if (actionCallback2 != null) {
                actionCallback2.ED(this.RmK);
                x xVar = x.SXb;
                AppMethodBeat.o(164604);
                return xVar;
            }
            AppMethodBeat.o(164604);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class t extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ kotlin.g.a.a qgW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(kotlin.g.a.a aVar) {
            super(0);
            this.qgW = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            AppMethodBeat.i(204996);
            this.qgW.invoke();
            x xVar = x.SXb;
            AppMethodBeat.o(204996);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, hxF = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
    public static final class s extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ RefreshLoadMoreLayout Rmy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(RefreshLoadMoreLayout refreshLoadMoreLayout) {
            super(0);
            this.Rmy = refreshLoadMoreLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2;
            AppMethodBeat.i(164602);
            Log.i("MicroMsg.RLMoreLayout", "[onRequestLoadMore]");
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.Rmy;
            RecyclerView.a adapter = this.Rmy.getRecyclerView().getAdapter();
            if (adapter != null) {
                i2 = adapter.getItemCount();
            } else {
                i2 = 0;
            }
            refreshLoadMoreLayout.RlS = i2;
            View view = this.Rmy.RlL;
            if (view != null) {
                view.setVisibility(0);
            }
            this.Rmy.RlI = false;
            this.Rmy.RlJ = false;
            a actionCallback = this.Rmy.getActionCallback();
            if (actionCallback != null) {
                actionCallback.cxo();
                x xVar = x.SXb;
                AppMethodBeat.o(164602);
                return xVar;
            }
            AppMethodBeat.o(164602);
            return null;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ int RmD;
        final /* synthetic */ RefreshLoadMoreLayout Rmy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(RefreshLoadMoreLayout refreshLoadMoreLayout, int i2) {
            super(0);
            this.Rmy = refreshLoadMoreLayout;
            this.RmD = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(164592);
            Log.i("MicroMsg.RLMoreLayout", "[onFinishRefresh]");
            this.Rmy.setRefreshing(false);
            this.Rmy.af(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.view.RefreshLoadMoreLayout.n.AnonymousClass1 */
                final /* synthetic */ n RmG;

                {
                    this.RmG = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    View findViewById;
                    View findViewById2;
                    AppMethodBeat.i(164591);
                    View refreshHeader = this.RmG.Rmy.getRefreshHeader();
                    if (!(refreshHeader == null || (findViewById2 = refreshHeader.findViewById(R.id.h7v)) == null)) {
                        findViewById2.setVisibility(0);
                    }
                    View refreshHeader2 = this.RmG.Rmy.getRefreshHeader();
                    if (!(refreshHeader2 == null || (findViewById = refreshHeader2.findViewById(R.id.gyj)) == null)) {
                        findViewById.setVisibility(8);
                    }
                    View refreshHeader3 = this.RmG.Rmy.getRefreshHeader();
                    if (refreshHeader3 != null) {
                        refreshHeader3.setVisibility(4);
                    }
                    c<Object> cVar = new c<>(-1);
                    cVar.Rmk = this.RmG.RmD;
                    this.RmG.Rmy.Rmb = false;
                    StickTopLoadingLayout stickTopLoadingLayout = this.RmG.Rmy.getStickTopLoadingLayout();
                    if (stickTopLoadingLayout != null) {
                        stickTopLoadingLayout.i(cVar);
                    }
                    a actionCallback = this.RmG.Rmy.getActionCallback();
                    if (actionCallback != null) {
                        actionCallback.onRefreshEnd(cVar);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(164591);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(164592);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class l extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ int RmD;
        final /* synthetic */ RefreshLoadMoreLayout Rmy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(RefreshLoadMoreLayout refreshLoadMoreLayout, int i2) {
            super(0);
            this.Rmy = refreshLoadMoreLayout;
            this.RmD = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(164590);
            Log.i("MicroMsg.RLMoreLayout", "[onFinishLoadMore]");
            this.Rmy.isLoadingMore = false;
            this.Rmy.ag(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.view.RefreshLoadMoreLayout.l.AnonymousClass1 */
                final /* synthetic */ l RmE;

                {
                    this.RmE = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    View findViewById;
                    TextView textView;
                    AppMethodBeat.i(164589);
                    View view = this.RmE.Rmy.RlL;
                    if (view != null) {
                        view.setVisibility(4);
                    }
                    View view2 = this.RmE.Rmy.RlL;
                    if (!(view2 == null || (textView = (TextView) view2.findViewById(R.id.ep1)) == null)) {
                        textView.setText(R.string.wc);
                    }
                    View view3 = this.RmE.Rmy.RlL;
                    if (!(view3 == null || (findViewById = view3.findViewById(R.id.ep0)) == null)) {
                        findViewById.setVisibility(8);
                    }
                    c<Object> cVar = new c<>(-1);
                    cVar.Rmk = this.RmE.RmD;
                    a actionCallback = this.RmE.Rmy.getActionCallback();
                    if (actionCallback != null) {
                        actionCallback.a(cVar);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(164589);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(164590);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class o extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ c $reason;
        final /* synthetic */ RefreshLoadMoreLayout Rmy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(RefreshLoadMoreLayout refreshLoadMoreLayout, c cVar) {
            super(0);
            this.Rmy = refreshLoadMoreLayout;
            this.$reason = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            View findViewById;
            TextView textView;
            CharSequence charSequence;
            AppMethodBeat.i(164595);
            Log.i("MicroMsg.RLMoreLayout", "[onFinishRefresh2] reason=" + this.$reason);
            this.Rmy.setRefreshing(false);
            final a aVar = new a(this);
            if (this.$reason.Rmk <= 0) {
                CharSequence charSequence2 = this.$reason.Rmi;
                if (!(charSequence2 == null || charSequence2.length() == 0)) {
                    RefreshLoadMoreLayout refreshLoadMoreLayout = this.Rmy;
                    c cVar = this.$reason;
                    refreshLoadMoreLayout.RlW = false;
                    View view = refreshLoadMoreLayout.RlK;
                    if (!(view == null || (textView = (TextView) view.findViewById(R.id.gyj)) == null)) {
                        if (cVar == null || (charSequence = cVar.Rmi) == null) {
                            textView.setText(R.string.fxj);
                        } else {
                            textView.setVisibility(0);
                            textView.setText(charSequence);
                        }
                    }
                    View view2 = refreshLoadMoreLayout.RlK;
                    if (!(view2 == null || (findViewById = view2.findViewById(R.id.h7v)) == null)) {
                        findViewById.setVisibility(8);
                    }
                }
                a actionCallback = this.Rmy.getActionCallback();
                if (actionCallback != null) {
                    actionCallback.onRefreshEnd(this.$reason);
                }
            } else if (!this.$reason.jLE) {
                aVar.invoke();
                a actionCallback2 = this.Rmy.getActionCallback();
                if (actionCallback2 != null) {
                    actionCallback2.onRefreshEnd(this.$reason);
                }
            } else {
                this.Rmy.af(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.view.RefreshLoadMoreLayout.o.AnonymousClass1 */
                    final /* synthetic */ o RmH;

                    {
                        this.RmH = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(164593);
                        aVar.invoke();
                        a actionCallback = this.RmH.Rmy.getActionCallback();
                        if (actionCallback != null) {
                            actionCallback.onRefreshEnd(this.RmH.$reason);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(164593);
                        return xVar;
                    }
                });
            }
            this.Rmy.Rmb = false;
            StickTopLoadingLayout stickTopLoadingLayout = this.Rmy.getStickTopLoadingLayout();
            if (stickTopLoadingLayout != null) {
                stickTopLoadingLayout.i(this.$reason);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(164595);
            return xVar;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/View;", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<View> {
            final /* synthetic */ o RmH;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(o oVar) {
                super(0);
                this.RmH = oVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ View invoke() {
                View findViewById;
                View findViewById2;
                AppMethodBeat.i(164594);
                this.RmH.Rmy.animate().cancel();
                float f2 = -((float) this.RmH.Rmy.RlO);
                Log.i("MicroMsg.RLMoreLayout", "[onFinishRefresh2] targetY=".concat(String.valueOf(f2)));
                this.RmH.Rmy.setTranslationY(f2);
                View refreshHeader = this.RmH.Rmy.getRefreshHeader();
                if (refreshHeader != null) {
                    refreshHeader.setVisibility(4);
                }
                View refreshHeader2 = this.RmH.Rmy.getRefreshHeader();
                if (!(refreshHeader2 == null || (findViewById2 = refreshHeader2.findViewById(R.id.h7v)) == null)) {
                    findViewById2.setVisibility(0);
                }
                View refreshHeader3 = this.RmH.Rmy.getRefreshHeader();
                if (refreshHeader3 == null || (findViewById = refreshHeader3.findViewById(R.id.gyj)) == null) {
                    AppMethodBeat.o(164594);
                    return null;
                }
                findViewById.setVisibility(8);
                AppMethodBeat.o(164594);
                return findViewById;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ c $reason;
        final /* synthetic */ RefreshLoadMoreLayout Rmy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(RefreshLoadMoreLayout refreshLoadMoreLayout, c cVar) {
            super(0);
            this.Rmy = refreshLoadMoreLayout;
            this.$reason = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(204995);
            Log.i("MicroMsg.RLMoreLayout", "[onFinishLoadMore2] reason=" + this.$reason);
            this.Rmy.isLoadingMore = false;
            this.Rmy.ag(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.view.RefreshLoadMoreLayout.m.AnonymousClass1 */
                final /* synthetic */ m RmF;

                {
                    this.RmF = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    View findViewById;
                    TextView textView;
                    AppMethodBeat.i(204994);
                    a actionCallback = this.RmF.Rmy.getActionCallback();
                    if (actionCallback != null) {
                        actionCallback.a(this.RmF.$reason);
                    }
                    View view = this.RmF.Rmy.RlL;
                    if (view != null) {
                        view.setVisibility(4);
                    }
                    View view2 = this.RmF.Rmy.RlL;
                    if (!(view2 == null || (textView = (TextView) view2.findViewById(R.id.ep1)) == null)) {
                        textView.setText(R.string.wc);
                    }
                    View view3 = this.RmF.Rmy.RlL;
                    if (!(view3 == null || (findViewById = view3.findViewById(R.id.ep0)) == null)) {
                        findViewById.setVisibility(8);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(204994);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(204995);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ c $reason;
        final /* synthetic */ RefreshLoadMoreLayout Rmy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(RefreshLoadMoreLayout refreshLoadMoreLayout, c cVar) {
            super(0);
            this.Rmy = refreshLoadMoreLayout;
            this.$reason = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(164600);
            Log.i("MicroMsg.RLMoreLayout", "[onPreFinishLoadMoreSmooth] reason=" + this.$reason);
            this.Rmy.isLoadingMore = false;
            final a aVar = new a(this);
            if (!this.$reason.Rmj) {
                this.Rmy.h(this.$reason);
                if (this.$reason.Rmk <= 0) {
                    a actionCallback = this.Rmy.getActionCallback();
                    if (actionCallback != null) {
                        actionCallback.a(this.$reason);
                    }
                } else if (!this.$reason.jLE) {
                    aVar.invoke();
                    a actionCallback2 = this.Rmy.getActionCallback();
                    if (actionCallback2 != null) {
                        actionCallback2.a(this.$reason);
                    }
                } else {
                    this.Rmy.ag(new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.view.RefreshLoadMoreLayout.q.AnonymousClass1 */
                        final /* synthetic */ q RmJ;

                        {
                            this.RmJ = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(164597);
                            aVar.invoke();
                            a actionCallback = this.RmJ.Rmy.getActionCallback();
                            if (actionCallback != null) {
                                actionCallback.a(this.RmJ.$reason);
                            }
                            x xVar = x.SXb;
                            AppMethodBeat.o(164597);
                            return xVar;
                        }
                    });
                }
            } else if (!this.$reason.jLE) {
                aVar.invoke();
                a actionCallback3 = this.Rmy.getActionCallback();
                if (actionCallback3 != null) {
                    actionCallback3.a(this.$reason);
                }
            } else {
                this.Rmy.ag(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.view.RefreshLoadMoreLayout.q.AnonymousClass2 */
                    final /* synthetic */ q RmJ;

                    {
                        this.RmJ = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(164598);
                        aVar.invoke();
                        a actionCallback = this.RmJ.Rmy.getActionCallback();
                        if (actionCallback != null) {
                            actionCallback.a(this.RmJ.$reason);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(164598);
                        return xVar;
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(164600);
            return xVar;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ q RmJ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(q qVar) {
                super(0);
                this.RmJ = qVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                int i2;
                float f2;
                boolean z = true;
                AppMethodBeat.i(164599);
                int[] iArr = new int[2];
                View view = this.RmJ.Rmy.RlL;
                if (view != null) {
                    view.getLocationInWindow(iArr);
                    int i3 = iArr[1];
                    Log.d("MicroMsg.RLMoreLayout", "loadMoreFooter top=".concat(String.valueOf(i3)));
                    Rect rect = new Rect();
                    if (this.RmJ.Rmy.getGlobalVisibleRect(rect)) {
                        int i4 = rect.bottom;
                        Log.d("MicroMsg.RLMoreLayout", "parentBottom=".concat(String.valueOf(i4)));
                        i2 = i4 - i3;
                    } else {
                        float translationY = this.RmJ.Rmy.getTranslationY() - ((float) (-this.RmJ.Rmy.RlO));
                        Log.d("MicroMsg.RLMoreLayout", "reset offset=".concat(String.valueOf(translationY)));
                        i2 = (int) translationY;
                    }
                } else {
                    i2 = 0;
                }
                float translationY2 = this.RmJ.Rmy.getTranslationY() + ((float) i2);
                c cVar = this.RmJ.$reason;
                if (i2 <= 0) {
                    z = false;
                }
                cVar.Rml = z;
                if (this.RmJ.Rmy.getDEBUG()) {
                    Log.i("MicroMsg.RLMoreLayout", "onPreFinishLoadMoreSmooth " + this.RmJ.Rmy.getTranslationY() + " rectHeight:" + i2 + " targetY:" + translationY2);
                }
                if (translationY2 >= ((float) (-this.RmJ.Rmy.RlO))) {
                    f2 = -((float) this.RmJ.Rmy.RlO);
                } else {
                    f2 = translationY2;
                }
                this.RmJ.Rmy.setTranslationY(f2);
                this.RmJ.Rmy.getRecyclerView().scrollBy(0, i2);
                View view2 = this.RmJ.Rmy.RlL;
                if (view2 != null) {
                    view2.setVisibility(4);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(164599);
                return xVar;
            }
        }
    }

    @Override // android.support.v4.view.n, com.tencent.mm.view.HeadFooterLayout
    public boolean a(View view, View view2, int i2, int i3) {
        AppMethodBeat.i(205000);
        kotlin.g.b.p.h(view, "child");
        kotlin.g.b.p.h(view2, "target");
        if (this.Rjr) {
            boolean startNestedScroll = super.startNestedScroll(i2);
            AppMethodBeat.o(205000);
            return startNestedScroll;
        }
        boolean z = this.Rjq;
        AppMethodBeat.o(205000);
        return z;
    }

    @Override // com.tencent.mm.view.i
    public void onPreFinishLoadMore(c<Object> cVar) {
        AppMethodBeat.i(205014);
        kotlin.g.b.p.h(cVar, "reason");
        h(new m(this, cVar));
        AppMethodBeat.o(205014);
    }
}
