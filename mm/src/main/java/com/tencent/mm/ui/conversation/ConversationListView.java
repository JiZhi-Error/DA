package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recent.l;
import com.tencent.mm.plugin.taskbar.api.HeaderContainer;
import com.tencent.mm.plugin.taskbar.api.a;
import com.tencent.mm.plugin.taskbar.api.b;
import com.tencent.mm.plugin.taskbar.api.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationListView extends ListView implements View.OnTouchListener, AbsListView.OnScrollListener, AppBrandRecentView.e, b.a {
    private int DBe;
    private MMFragmentActivity Dpx;
    boolean FSV = false;
    private a FSw = null;
    private View FSz;
    private boolean FTf = true;
    private View.OnTouchListener HeV;
    private AdapterView.OnItemLongClickListener OZU;
    private int QcA;
    private Bitmap QcB = null;
    private RectF QcC = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    private boolean QcD = false;
    private NinePatchDrawable QcE = null;
    private Rect QcF = new Rect();
    private final float QcG = ((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 30));
    private final float QcH = ((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 8));
    private final float QcI = ((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 24));
    private final float QcJ = ((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 64));
    private final float QcK = 0.5f;
    private boolean QcL = false;
    private final float QcM = ((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 200));
    private int QcN = 0;
    private boolean QcO = false;
    Runnable QcP = null;
    Runnable QcQ = null;
    Runnable QcR = null;
    View QcS;
    private int QcT = 0;
    private int QcU = com.tencent.mm.cb.a.fromDPToPix(getContext(), 56);
    private int QcV = 0;
    IListener<mv> QcW = new IListener<mv>() {
        /* class com.tencent.mm.ui.conversation.ConversationListView.AnonymousClass1 */

        {
            AppMethodBeat.i(161565);
            this.__eventId = mv.class.getName().hashCode();
            AppMethodBeat.o(161565);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mv mvVar) {
            AppMethodBeat.i(38325);
            mv mvVar2 = mvVar;
            if (ConversationListView.this.dSv != mvVar2.dSu.dSv) {
                Log.i("MicroMsg.ConversationListView", "alvinluo MultiWindowModeChanged: %b", Boolean.valueOf(mvVar2.dSu.dSv));
                ConversationListView.this.dSv = mvVar2.dSu.dSv;
                ConversationListView.b(ConversationListView.this);
                if (ConversationListView.this.onh != null) {
                    ConversationListView.this.onh.wn(ConversationListView.this.dSv);
                }
            }
            AppMethodBeat.o(38325);
            return false;
        }
    };
    private View.OnLayoutChangeListener QcX = new View.OnLayoutChangeListener() {
        /* class com.tencent.mm.ui.conversation.ConversationListView.AnonymousClass5 */

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            AppMethodBeat.i(234118);
            Log.i("MicroMsg.ConversationListView", "ActionBarView layout changed, call setupActionBarView()");
            ConversationListView.b(ConversationListView.this);
            AppMethodBeat.o(234118);
        }
    };
    private View.OnTouchListener QcY = null;
    private int QcZ = 0;
    private LinkedList<ListView.FixedViewInfo> Qcu = new LinkedList<>();
    boolean Qcv = true;
    private boolean Qcw = false;
    b Qcx;
    private String Qcy;
    private float Qcz;
    View Qda;
    private boolean Qdb;
    private boolean Qdc = false;
    final g VlV = new g() {
        /* class com.tencent.mm.ui.conversation.ConversationListView.AnonymousClass12 */

        @Override // com.tencent.mm.kernel.api.g
        public final void WY() {
            AppMethodBeat.i(259020);
            com.tencent.mm.kernel.g.aAi().b(this);
            if (!bg.aAc() || !com.tencent.mm.kernel.g.aAf().hpY) {
                Log.w("MicroMsg.ConversationListView", "onStartupDone but account not initialized");
                AppMethodBeat.o(259020);
                return;
            }
            Log.i("MicroMsg.ConversationListView", "onStartupDone account initialized, initHeaderContainer");
            ConversationListView.a(ConversationListView.this, ConversationListView.this.getContext());
            AppMethodBeat.o(259020);
        }

        @Override // com.tencent.mm.kernel.api.g
        public final void cQ(boolean z) {
        }
    };
    private View ahC;
    private AdapterView.OnItemClickListener awr;
    boolean dSv = false;
    private int hIX = 0;
    private boolean iCn;
    private int mActionBarHeight;
    private int mCount;
    private Paint mPaint = new Paint(1);
    private int mScrollState;
    private int mStatusBarHeight = 0;
    private int ocu;
    HeaderContainer onh;
    private AbsListView.OnScrollListener yQz;

    static /* synthetic */ void a(ConversationListView conversationListView, int i2, int i3) {
        AppMethodBeat.i(259024);
        conversationListView.lm(i2, i3);
        AppMethodBeat.o(259024);
    }

    static /* synthetic */ void a(ConversationListView conversationListView, Context context) {
        AppMethodBeat.i(259023);
        conversationListView.kq(context);
        AppMethodBeat.o(259023);
    }

    static /* synthetic */ void axu(int i2) {
        AppMethodBeat.i(259025);
        bN(i2, false);
        AppMethodBeat.o(259025);
    }

    static /* synthetic */ void b(ConversationListView conversationListView) {
        AppMethodBeat.i(38383);
        conversationListView.gVu();
        AppMethodBeat.o(38383);
    }

    static /* synthetic */ void b(ConversationListView conversationListView, int i2, int i3) {
        AppMethodBeat.i(259027);
        conversationListView.ln(i2, i3);
        AppMethodBeat.o(259027);
    }

    static /* synthetic */ void f(ConversationListView conversationListView) {
        AppMethodBeat.i(259026);
        conversationListView.gVx();
        AppMethodBeat.o(259026);
    }

    public ConversationListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38336);
        init(context);
        AppMethodBeat.o(38336);
    }

    public ConversationListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(38337);
        init(context);
        AppMethodBeat.o(38337);
    }

    public boolean canScrollHorizontally(int i2) {
        AppMethodBeat.i(38338);
        if (this.onh == null) {
            boolean canScrollHorizontally = super.canScrollHorizontally(i2);
            AppMethodBeat.o(38338);
            return canScrollHorizontally;
        } else if (this.onh.getBottom() >= this.onh.getHeight()) {
            AppMethodBeat.o(38338);
            return true;
        } else {
            AppMethodBeat.o(38338);
            return false;
        }
    }

    private void init(Context context) {
        AppMethodBeat.i(38339);
        this.mPaint.setAlpha(255);
        this.mPaint.setTextSize((float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.i_));
        this.Qcy = getResources().getString(R.string.b5x);
        this.Qcz = this.mPaint.measureText(this.Qcy);
        super.setOnScrollListener(this);
        super.setOnTouchListener(this);
        setOverScrollMode(2);
        Log.i("MicroMsg.ConversationListView", "alvinluo HeaderContainer new, ConversationListView: %d", Integer.valueOf(hashCode()));
        cau();
        Cv(false);
        addFooterView(getEmptyFooter());
        this.QcN = (int) (((float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.bc)) * com.tencent.mm.cb.a.ji(getContext()));
        this.DBe = au.eu(getContext()) + au.getStatusBarHeight(getContext());
        this.QcZ = com.tencent.mm.cb.a.fromDPToPix(context, 100);
        gVt();
        AppMethodBeat.o(38339);
    }

    /* access modifiers changed from: package-private */
    public final void cau() {
        AppMethodBeat.i(234122);
        this.iCn = ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
        this.ocu = ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvp();
        Log.d("MicroMsg.ConversationListView", "updateTeenModeStatus isTeenMode: %b, miniProgramOption: %d", Boolean.valueOf(this.iCn), Integer.valueOf(this.ocu));
        AppMethodBeat.o(234122);
    }

    /* access modifiers changed from: package-private */
    public final void kq(Context context) {
        AppMethodBeat.i(234123);
        if (com.tencent.mm.kernel.g.af(l.class) == null) {
            Log.e("MicroMsg.ConversationListView", "alvinluo initHeaderContainer service is null");
            AppMethodBeat.o(234123);
        } else if (this.onh != null) {
            AppMethodBeat.o(234123);
        } else {
            Log.i("MicroMsg.ConversationListView", "do initHeaderContainer");
            this.onh = ((c) com.tencent.mm.kernel.g.af(c.class)).hn(context);
            if (this.onh != null) {
                this.onh.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                this.Qcx = ((c) com.tencent.mm.kernel.g.af(c.class)).a(context, this, this.onh);
                this.Qcx.a(this);
                this.onh.setAnimController(this.Qcx);
                if (this.Qcv) {
                    this.Qcw = true;
                    addHeaderView(this.onh);
                }
            }
            AppMethodBeat.o(234123);
        }
    }

    private void gVr() {
        AppMethodBeat.i(234124);
        if (this.onh != null) {
            ArrayList<View> headerViewList = getHeaderViewList();
            Log.i("MicroMsg.ConversationListView", "removeHeaderViewList size: %d", Integer.valueOf(headerViewList.size()));
            for (int i2 = 0; i2 < headerViewList.size(); i2++) {
                View view = headerViewList.get(i2);
                if (view != null) {
                    removeHeaderView(view);
                }
            }
            addHeaderView(this.onh);
            headerViewList.remove(this.onh);
            Log.i("MicroMsg.ConversationListView", "addHeaderViewList addViewList: %d", Integer.valueOf(headerViewList.size()));
            for (int i3 = 0; i3 < headerViewList.size(); i3++) {
                addHeaderView(headerViewList.get(i3));
            }
            gVu();
        }
        AppMethodBeat.o(234124);
    }

    private void gVs() {
        AppMethodBeat.i(234125);
        if (this.onh != null) {
            removeHeaderView(this.onh);
            gVu();
        }
        AppMethodBeat.o(234125);
    }

    /* access modifiers changed from: package-private */
    public final void Cv(boolean z) {
        AppMethodBeat.i(234126);
        boolean z2 = this.Qcv;
        this.Qcv = true;
        Log.i("MicroMsg.ConversationListView", "updateHeaderContainer showHeaderContainer: %b, last: %b, updateView: %b, isHeaderContainerAdded: %b", Boolean.valueOf(this.Qcv), Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(this.Qcw));
        if (!z) {
            AppMethodBeat.o(234126);
            return;
        }
        if (z2 != this.Qcv) {
            if (this.Qcv) {
                if (!this.Qcw) {
                    gVr();
                    this.Qcw = true;
                    i(200, 0, true);
                    AppMethodBeat.o(234126);
                    return;
                }
            } else if (this.Qcw) {
                gVs();
                this.Qcw = false;
                setSelection(0);
            }
        }
        AppMethodBeat.o(234126);
    }

    public boolean getShowHeaderContainer() {
        return this.Qcv;
    }

    private void gVt() {
        AppMethodBeat.i(38340);
        if (Build.VERSION.SDK_INT >= 24 && LauncherUI.getInstance() != null) {
            this.dSv = LauncherUI.getInstance().isInMultiWindowMode();
            if (this.onh != null) {
                this.onh.wn(this.dSv);
            }
        }
        AppMethodBeat.o(38340);
    }

    public void setonDispatchTouchEventListener(View.OnTouchListener onTouchListener) {
        this.QcY = onTouchListener;
    }

    /* access modifiers changed from: package-private */
    public final void gVu() {
        boolean z = true;
        AppMethodBeat.i(234127);
        if (this.ahC == null) {
            this.ahC = getRootView().findViewById(R.id.c_);
            if (this.ahC != null) {
                this.ahC.addOnLayoutChangeListener(this.QcX);
            } else {
                AppMethodBeat.o(234127);
                return;
            }
        }
        if (this.dSv && Build.VERSION.SDK_INT >= 24 && LauncherUI.getInstance() != null) {
            this.dSv = LauncherUI.getInstance().isInMultiWindowMode();
            Log.i("MicroMsg.ConversationListView", "alvinluo initActionBarView check multiWindowMode %b", Boolean.valueOf(this.dSv));
        }
        final int eu = h.eu(getContext());
        if (this.mStatusBarHeight == 0 || !(this.dSv || this.ahC.getTop() == this.mStatusBarHeight || this.ahC.getTop() == 0)) {
            this.mStatusBarHeight = this.ahC.getTop();
        } else {
            z = false;
        }
        if (!z || this.dSv) {
            this.QcT = this.ahC.getTop();
            lm(this.QcT, eu);
            bN(this.QcT, false);
            AppMethodBeat.o(234127);
            return;
        }
        post(new Runnable() {
            /* class com.tencent.mm.ui.conversation.ConversationListView.AnonymousClass7 */
            int ibG = 0;

            public final void run() {
                AppMethodBeat.i(38331);
                if (ConversationListView.this.ahC == null) {
                    AppMethodBeat.o(38331);
                    return;
                }
                if (ConversationListView.this.ahC.getTop() != 0) {
                    ConversationListView.this.mStatusBarHeight = ConversationListView.this.ahC.getTop();
                }
                if (ConversationListView.this.mStatusBarHeight > 0) {
                    ConversationListView.a(ConversationListView.this, ConversationListView.this.mStatusBarHeight, eu);
                    ConversationListView.axu(ConversationListView.this.mStatusBarHeight);
                } else if (this.ibG <= 2) {
                    Log.i("MicroMsg.ConversationListView", "alvinluo initActionBarView try again tryCount: %d", Integer.valueOf(this.ibG));
                    ConversationListView.this.post(this);
                } else {
                    ConversationListView.b(ConversationListView.this, eu);
                }
                this.ibG++;
                AppMethodBeat.o(38331);
            }
        });
        AppMethodBeat.o(234127);
    }

    private void lm(int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.i(234128);
        Log.i("MicroMsg.ConversationListView", "alvinluo initActionBarView statusBarHeight: %d, isInMultiWindowMode: %b, target: %d, actionBarTop: %d, actionBarHeight: %d", Integer.valueOf(this.mStatusBarHeight), Boolean.valueOf(this.dSv), Integer.valueOf(i2), Integer.valueOf(this.ahC.getTop()), Integer.valueOf(i3));
        if (i2 >= 0) {
            if (this.FSz != null) {
                if (!this.dSv) {
                    this.FSz.getLayoutParams().height = (this.Qcv ? 0 : i3) + this.mStatusBarHeight;
                } else {
                    this.FSz.getLayoutParams().height = i2;
                }
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                if (!this.dSv) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    if (!this.Qcv) {
                        i4 = i3;
                    }
                    layoutParams2.topMargin = i4;
                } else {
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = i2;
                }
            }
            gVv();
        }
        AppMethodBeat.o(234128);
    }

    private static void bN(int i2, boolean z) {
        SharedPreferences.Editor edit;
        AppMethodBeat.i(38343);
        Log.i("MicroMsg.ConversationListView", "alvinluo saveTopMargin topMargin: %d, needRead: %b", Integer.valueOf(i2), Boolean.valueOf(z));
        SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
        if (!(defaultPreference == null || (edit = defaultPreference.edit()) == null)) {
            edit.putBoolean("Main_need_read_top_margin", z);
            edit.putInt("Main_top_marign", i2);
            edit.apply();
            Log.i("MicroMsg.ConversationListView", "alvinluo saveTopMargin success");
        }
        AppMethodBeat.o(38343);
    }

    private void gVv() {
        AppMethodBeat.i(234129);
        int statusBarHeight = au.getStatusBarHeight(getContext());
        Log.i("MicroMsg.ConversationListView", "updateScrollOffset %d %d", Integer.valueOf(statusBarHeight), Integer.valueOf(this.mStatusBarHeight));
        if (this.mStatusBarHeight > 0) {
            statusBarHeight = this.mStatusBarHeight;
        }
        if (!this.dSv) {
            this.DBe = statusBarHeight + au.eu(getContext());
        } else {
            this.DBe = au.eu(getContext());
        }
        if (this.Qcv && this.Qcx != null) {
            this.Qcx.abv(this.DBe);
        }
        AppMethodBeat.o(234129);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        AppMethodBeat.i(38344);
        if (getFirstVisiblePosition() != 0 || i3 >= 0 || iArr == null || iArr.length < 2 || this.FSV) {
            boolean dispatchNestedPreScroll = super.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
            AppMethodBeat.o(38344);
            return dispatchNestedPreScroll;
        }
        iArr[1] = (int) (((float) i3) * 0.32f);
        super.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
        AppMethodBeat.o(38344);
        return true;
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.yQz = onScrollListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.HeV = onTouchListener;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(38345);
        boolean z = this.Qcv && this.Qcx != null && this.Qcx.onTouch(view, motionEvent);
        if (this.HeV != null) {
            z |= this.HeV.onTouch(view, motionEvent);
        }
        AppMethodBeat.o(38345);
        return z;
    }

    /* access modifiers changed from: protected */
    public void attachViewToParent(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(38346);
        super.attachViewToParent(view, i2, layoutParams);
        if (this.mActionBarHeight <= 0 && this.Qcx != null) {
            this.mActionBarHeight = au.eu(getContext()) + au.D(getContext(), 0);
            this.DBe = au.eu(getContext()) + au.getStatusBarHeight(getContext());
            gVu();
            if (this.onh != null) {
                this.onh.setActionBar(this.ahC);
            }
            this.Qcx.setActionBar(this.ahC);
            this.Qcx.setTabView(getRootView().findViewById(R.id.e8y));
        }
        AppMethodBeat.o(38346);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(38347);
        super.onDraw(canvas);
        if (this.onh != null && getFirstVisiblePosition() == 0 && this.onh.isFullScreen() && this.onh.getBottom() > 6) {
            if (this.QcA < 30) {
                AppMethodBeat.o(38347);
                return;
            }
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(getContext().getResources().getColor(R.color.d4));
            this.mPaint.setAlpha(this.QcA);
            canvas.drawRect((float) this.onh.getBackUpFooterRect().left, (float) (this.onh.getBackUpFooterRect().top + this.QcU), (float) this.onh.getBackUpFooterRect().right, (float) this.onh.getBackUpFooterRect().bottom, this.mPaint);
        }
        AppMethodBeat.o(38347);
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(38348);
        if (this.yQz != null) {
            this.yQz.onScrollStateChanged(absListView, i2);
        }
        if (this.Qcx != null && this.Qcv) {
            this.Qcx.onScrollStateChanged(absListView, i2);
        }
        this.mScrollState = i2;
        AppMethodBeat.o(38348);
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        int i5;
        AppMethodBeat.i(38349);
        if (this.Qcv && i2 == 0 && this.FTf) {
            View childAt = getChildAt(1);
            if (childAt == null) {
                i5 = (!esy() || this.onh == null) ? 0 : this.onh.getMeasuredHeight() - this.DBe;
                Log.i("MicroMsg.ConversationListView", "alvinluo computeActionBarTranslation %d", Integer.valueOf(i5));
            } else {
                i5 = -((-childAt.getTop()) + ((int) (((float) Math.max(i2 - getHeaderViewsCount(), 0)) * getResources().getDimension(R.dimen.iq))) + this.DBe);
            }
            int max = Math.max(0, i5);
            if (this.ahC != null) {
                Log.v("MicroMsg.ConversationListView", "alvinluo onScroll setTranslationY before: %f, trans: %d", Float.valueOf(this.ahC.getTranslationY()), Integer.valueOf(max));
                this.ahC.setTranslationY((float) max);
            }
            if (this.Qcv && this.onh != null) {
                HeaderContainer headerContainer = this.onh;
                this.onh.getHeight();
                headerContainer.jh(max, this.onh.getHeight() - this.DBe);
            }
        } else if (i2 > 0) {
            gVz();
        }
        if (this.yQz != null) {
            this.yQz.onScroll(absListView, i2, i3, i4);
        }
        if (this.Qcv && this.Qcx != null) {
            this.Qcx.onScroll(absListView, i2, i3, i4);
        }
        if (this.Qcv && i3 > 1 && gVy() && this.onh != null) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            this.QcV = iArr[1];
            int bottom = this.onh.getBottom() - com.tencent.mm.cb.a.fromDPToPix(getContext(), 56);
            this.onh.getBackUpFooterRect().set(0, bottom, getWidth(), getHeight() + bottom);
            Log.d("MicroMsg.ConversationListView", "alvinluo onScroll BackUpFooterRect: %s, headerContainer top: %d, bottom: %d", this.onh.getBackUpFooterRect().toString(), Integer.valueOf(this.onh.getTop()), Integer.valueOf(this.onh.getBottom()));
            this.QcA = (int) ((255.0f * ((float) this.onh.getBottom())) / ((float) this.onh.getHeight()));
        }
        AppMethodBeat.o(38349);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(38350);
        try {
            super.onLayout(z, i2, i3, i4, i5);
            boolean esy = esy();
            Log.i("MicroMsg.ConversationListView", "[onLayout] changed:%s, isHeaderOpen: %b", Boolean.valueOf(z), Boolean.valueOf(esy));
            Log.d("MicroMsg.ConversationListView", "[onLayout] top: %d, bottom: %d, height: %d, count: %d, realCount: %d, hashCode: %s", Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i5 - i3), Integer.valueOf(this.mCount), Integer.valueOf(getRealCount()), Integer.valueOf(hashCode()));
            if (z && !esy) {
                setSelection(1);
                post(new Runnable() {
                    /* class com.tencent.mm.ui.conversation.ConversationListView.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(38332);
                        ConversationListView.this.setSelection(1);
                        AppMethodBeat.o(38332);
                    }
                });
            }
            if (z || (this.mCount < 16 && getRealCount() != this.mCount)) {
                Cw(false);
            }
            this.mCount = getRealCount();
            AppMethodBeat.o(38350);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ConversationListView", e2, "alvinluo onLayout exception", new Object[0]);
            AppMethodBeat.o(38350);
        }
    }

    private int getRealCount() {
        AppMethodBeat.i(38351);
        if (getAdapter() == null) {
            AppMethodBeat.o(38351);
            return 1;
        }
        int count = (getAdapter().getCount() - getHeaderViewsCount()) - getFooterViewsCount();
        AppMethodBeat.o(38351);
        return count;
    }

    public final void i(long j2, final int i2, boolean z) {
        AppMethodBeat.i(234130);
        Log.i("MicroMsg.ConversationListView", "[closeHeader] delay:%s, type: %d, forceClose: %b", Long.valueOf(j2), Integer.valueOf(i2), Boolean.valueOf(z));
        if (getFirstVisiblePosition() != 0 && !z) {
            AppMethodBeat.o(234130);
        } else if (j2 > 0) {
            if (this.QcQ != null) {
                removeCallbacks(this.QcQ);
            }
            this.QcQ = new Runnable() {
                /* class com.tencent.mm.ui.conversation.ConversationListView.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(234119);
                    ConversationListView conversationListView = ConversationListView.this;
                    int i2 = i2;
                    if (conversationListView.Qcv && conversationListView.Qcx != null) {
                        conversationListView.Qcx.abu(i2);
                    }
                    AppMethodBeat.o(234119);
                }
            };
            postDelayed(this.QcQ, j2);
            AppMethodBeat.o(234130);
        } else {
            setSelection(0);
            AppMethodBeat.o(234130);
        }
    }

    /* access modifiers changed from: package-private */
    public final void ln(int i2, int i3) {
        AppMethodBeat.i(38352);
        if (this.FSw != null) {
            this.FSw.f(1.0f, i2, 0);
            this.FSw.g(1.0f, i3, i3);
        }
        AppMethodBeat.o(38352);
    }

    public final void gVw() {
        AppMethodBeat.i(38353);
        if (this.Qcv && this.Qcx != null) {
            this.Qcx.i(0, 0, true);
        }
        gVz();
        AppMethodBeat.o(38353);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b.a
    public final void caB() {
        AppMethodBeat.i(38354);
        Log.d("MicroMsg.ConversationListView", "[onOpenHeader]");
        this.FSV = true;
        if (this.QcP != null) {
            removeCallbacks(this.QcP);
        }
        if (this.FSw != null) {
            this.FSw.FF(false);
        }
        AppMethodBeat.o(38354);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b.a
    public final void eG(int i2, int i3) {
        AppMethodBeat.i(234131);
        Log.d("MicroMsg.ConversationListView", "[onCloseHeader]");
        this.Qdb = false;
        this.FSV = false;
        this.QcA = 0;
        if (this.QcP != null) {
            removeCallbacks(this.QcP);
        }
        if (this.FSw != null) {
            this.FSw.FF(true);
        }
        AppMethodBeat.o(234131);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b.a
    public final void zT(int i2) {
        AppMethodBeat.i(38356);
        eG(i2, 0);
        AppMethodBeat.o(38356);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b.a
    public final void caC() {
        AppMethodBeat.i(38357);
        caB();
        AppMethodBeat.o(38357);
    }

    /* access modifiers changed from: package-private */
    public final void Cw(boolean z) {
        AppMethodBeat.i(38358);
        if (this.Qda == null) {
            AppMethodBeat.o(38358);
        } else if (z) {
            postDelayed(new Runnable() {
                /* class com.tencent.mm.ui.conversation.ConversationListView.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(259021);
                    ConversationListView.f(ConversationListView.this);
                    AppMethodBeat.o(259021);
                }
            }, 0);
            AppMethodBeat.o(38358);
        } else {
            gVx();
            AppMethodBeat.o(38358);
        }
    }

    private void gVx() {
        boolean z;
        int i2;
        AppMethodBeat.i(38359);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Qda.getLayoutParams();
        float anM = anM(getAdapter() == null ? 0 : getAdapter().getCount());
        if (anM < 0.0f) {
            z = true;
        } else {
            z = false;
        }
        int i3 = layoutParams.height;
        Log.i("MicroMsg.ConversationListView", "[checkEmptyFooter] isRealFull:" + z + " old height:" + i3);
        View findViewById = getRootView().findViewById(R.id.e8y);
        if (findViewById != null) {
            Log.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabView Height: %d", Integer.valueOf(findViewById.getHeight()));
        }
        int dimension = (int) getResources().getDimension(R.dimen.iq);
        if (findViewById != null) {
            i2 = findViewById.getHeight();
        } else {
            i2 = 0;
        }
        if (i2 <= 0) {
            i2 = this.QcN;
        }
        Log.d("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabHeight: %d", Integer.valueOf(i2));
        if (z) {
            layoutParams.height = i2;
        } else {
            if (anM < ((float) i2)) {
                anM = (float) i2;
            }
            layoutParams.height = (int) anM;
        }
        if (i3 != layoutParams.height) {
            Log.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter isHeaderOpen: %b", Boolean.valueOf(esy()));
            if ((!z || Math.abs(anM) <= ((float) (i2 + dimension))) && !esy()) {
                Log.i("MicroMsg.ConversationListView", "[checkEmptyFooter] setSelection");
                setSelection(1);
                if (this.Qcx != null) {
                    this.Qcx.wk(true);
                }
            }
            this.Qda.requestLayout();
        }
        AppMethodBeat.o(38359);
    }

    private View getEmptyFooter() {
        AppMethodBeat.i(38360);
        View findViewById = getRootView().findViewById(R.id.e8y);
        int dimension = (int) getResources().getDimension(R.dimen.iq);
        int height = findViewById != null ? findViewById.getHeight() : 0;
        if (height > 0) {
            dimension = height;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.Qda = new View(getContext());
        this.Qda.setLayoutParams(new LinearLayout.LayoutParams(-1, dimension));
        linearLayout.addView(this.Qda);
        linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.f3045c));
        AppMethodBeat.o(38360);
        return linearLayout;
    }

    private float anM(int i2) {
        AppMethodBeat.i(38361);
        float measuredHeight = (float) (((getMeasuredHeight() - (((int) getResources().getDimension(R.dimen.iq)) * ((i2 - getHeaderViewsCount()) - getFooterViewsCount()))) - au.eu(getContext())) - au.getStatusBarHeight(getContext()));
        Log.d("MicroMsg.ConversationListView", "alvinluo isFullScreen getMeasuredHeight: %d", Integer.valueOf(getMeasuredHeight()));
        Log.i("MicroMsg.ConversationListView", "[isFullScreen] totalItemCount:" + i2 + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount() + " extraHeight:" + measuredHeight);
        AppMethodBeat.o(38361);
        return measuredHeight;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.e
    public final void yL(int i2) {
    }

    public void setSelection(int i2) {
        AppMethodBeat.i(38362);
        Log.i("MicroMsg.ConversationListView", "[setSelection] position:%s, scrollOffset: %d", Integer.valueOf(i2), Integer.valueOf(this.DBe));
        if (i2 == 0) {
            super.setSelectionFromTop(getFirstHeaderVisible(), this.DBe);
            AppMethodBeat.o(38362);
            return;
        }
        super.setSelectionFromTop(i2, this.DBe);
        AppMethodBeat.o(38362);
    }

    public void smoothScrollToPosition(int i2) {
        AppMethodBeat.i(38363);
        Log.i("MicroMsg.ConversationListView", "[smoothScrollToPosition] position:%s", Integer.valueOf(i2));
        if (i2 == 0) {
            super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.DBe);
            AppMethodBeat.o(38363);
            return;
        }
        super.smoothScrollToPositionFromTop(i2, this.DBe);
        AppMethodBeat.o(38363);
    }

    public void smoothScrollToPositionFromTop(int i2, int i3) {
        AppMethodBeat.i(38364);
        Log.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0) {
            super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.DBe + i3);
            AppMethodBeat.o(38364);
            return;
        }
        super.smoothScrollToPositionFromTop(i2, this.DBe + i3);
        AppMethodBeat.o(38364);
    }

    public void smoothScrollToPositionFromTop(int i2, int i3, int i4) {
        AppMethodBeat.i(38365);
        Log.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i2 == 0) {
            super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.DBe + i3, i4);
            AppMethodBeat.o(38365);
            return;
        }
        super.smoothScrollToPositionFromTop(i2, this.DBe + i3, i4);
        AppMethodBeat.o(38365);
    }

    public final void q(boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(38366);
        Log.i("MicroMsg.ConversationListView", "[showAppBrandHeader] isShow:" + z + " isAnim:" + z2 + " isScrollFirst:" + z3);
        if (z) {
            if (this.Qcv && this.Qcx != null) {
                this.Qcx.fux();
                AppMethodBeat.o(38366);
                return;
            }
        } else if (this.Qcv && this.Qcx != null) {
            this.Qcx.abu(0);
        }
        AppMethodBeat.o(38366);
    }

    public int getFirstHeaderVisible() {
        View childAt;
        AppMethodBeat.i(38367);
        Iterator<ListView.FixedViewInfo> it = this.Qcu.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                Log.i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", Integer.valueOf(i2));
                AppMethodBeat.o(38367);
                break;
            }
            ListView.FixedViewInfo next = it.next();
            if (next.view != this.onh) {
                if (next.view != null && (next.view instanceof ViewGroup) && (childAt = ((ViewGroup) next.view).getChildAt(0)) != null && childAt.getVisibility() == 0) {
                    Log.i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", Integer.valueOf(i2));
                    AppMethodBeat.o(38367);
                    break;
                }
                i2++;
            } else {
                i2++;
            }
        }
        return i2;
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        AppMethodBeat.i(38368);
        super.addHeaderView(view, obj, z);
        ListView.FixedViewInfo fixedViewInfo = new ListView.FixedViewInfo(this);
        fixedViewInfo.view = view;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z;
        this.Qcu.add(fixedViewInfo);
        AppMethodBeat.o(38368);
    }

    public boolean removeHeaderView(View view) {
        int i2;
        AppMethodBeat.i(234132);
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (i2 >= this.Qcu.size()) {
                i2 = -1;
                break;
            }
            ListView.FixedViewInfo fixedViewInfo = this.Qcu.get(i2);
            if (fixedViewInfo != null && fixedViewInfo.view == view) {
                break;
            }
            i3 = i2 + 1;
        }
        if (i2 != -1) {
            this.Qcu.remove(i2);
        }
        boolean removeHeaderView = super.removeHeaderView(view);
        AppMethodBeat.o(234132);
        return removeHeaderView;
    }

    private ArrayList<View> getHeaderViewList() {
        AppMethodBeat.i(234133);
        ArrayList<View> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < this.Qcu.size(); i2++) {
            ListView.FixedViewInfo fixedViewInfo = this.Qcu.get(i2);
            if (!(fixedViewInfo == null || fixedViewInfo.view == null)) {
                arrayList.add(fixedViewInfo.view);
            }
        }
        AppMethodBeat.o(234133);
        return arrayList;
    }

    public final boolean esy() {
        AppMethodBeat.i(38369);
        if (!gVy() || !this.FSV) {
            AppMethodBeat.o(38369);
            return false;
        }
        AppMethodBeat.o(38369);
        return true;
    }

    private boolean gVy() {
        AppMethodBeat.i(38370);
        if (this.onh == null) {
            AppMethodBeat.o(38370);
            return false;
        } else if (this.onh.getBottom() < this.mActionBarHeight + 3 || getFirstVisiblePosition() != 0) {
            AppMethodBeat.o(38370);
            return false;
        } else {
            AppMethodBeat.o(38370);
            return true;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(38371);
        if (this.QcY != null) {
            this.QcY.onTouch(this, motionEvent);
        }
        try {
            if (this.onh != null) {
                Log.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent backUpFooterRect: %s, %f, %f, bottom: %d, height: %d, isCanClose: %b", this.onh.getBackUpFooterRect().toString(), Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()), Integer.valueOf(this.onh.getBottom()), Integer.valueOf(this.onh.getHeight()), Boolean.valueOf(this.Qdb));
            }
            int rawY = (int) motionEvent.getRawY();
            if (this.dSv) {
                rawY = (rawY - this.QcV) + this.mStatusBarHeight;
            }
            if (esy() && this.onh != null) {
                if (motionEvent.getAction() == 0) {
                    if (this.onh.getBackUpFooterRect().contains((int) motionEvent.getRawX(), rawY)) {
                        this.Qdc = true;
                    } else {
                        this.Qdc = false;
                    }
                }
                Log.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent isDownInCloseRect: %b, touchY: %d", Boolean.valueOf(this.Qdc), Integer.valueOf(rawY));
                if (!this.Qdc) {
                    boolean dispatchTouchEvent = this.onh.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(38371);
                    return dispatchTouchEvent;
                }
            }
            if (this.onh == null || this.onh.getBottom() < this.onh.getHeight() || !this.onh.isFullScreen() || getFirstVisiblePosition() != 0) {
                if (this.Qdb && motionEvent.getAction() == 1) {
                    Log.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event..., isHeaderOpen: %b, isHeaderVisible: %b", Boolean.valueOf(esy()), Boolean.valueOf(gVy()));
                    if (!esy()) {
                        this.Qdb = false;
                    } else {
                        motionEvent.setAction(3);
                    }
                }
                if (motionEvent.getAction() == 0 && this.Qcx != null && motionEvent.getAction() == 0) {
                    this.Qcx.ac(motionEvent);
                }
                boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(38371);
                return dispatchTouchEvent2;
            }
            if (motionEvent.getAction() == 0 && this.onh.getBackUpFooterRect().contains((int) motionEvent.getRawX(), rawY)) {
                this.Qdb = true;
            } else if (motionEvent.getAction() == 0) {
                this.Qdb = false;
            }
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                if (this.Qcx != null && motionEvent.getAction() == 0) {
                    this.Qcx.ac(motionEvent);
                }
                boolean dispatchTouchEvent3 = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(38371);
                return dispatchTouchEvent3;
            } else if (this.Qdb) {
                this.Qdb = false;
                if (this.Qcx != null) {
                    Log.i("MicroMsg.ConversationListView", "alvinluo closeHeader by click BackUpFooterRect");
                    this.Qcx.abu(12);
                }
                if (motionEvent.getAction() == 1) {
                    Log.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event");
                    motionEvent.setAction(3);
                    boolean dispatchTouchEvent4 = super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(38371);
                    return dispatchTouchEvent4;
                }
                AppMethodBeat.o(38371);
                return true;
            } else {
                boolean dispatchTouchEvent5 = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(38371);
                return dispatchTouchEvent5;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ConversationListView", e2, "alvinluo ConversationListView dispatchTouchEvent exception", new Object[0]);
            AppMethodBeat.o(38371);
            return false;
        }
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        AppMethodBeat.i(38372);
        this.OZU = onItemLongClickListener;
        super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.ui.conversation.ConversationListView.AnonymousClass11 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(259022);
                Log.i("MicroMsg.ConversationListView", "alvinluo onItemLongClick isCanClose: %b", Boolean.valueOf(ConversationListView.this.Qdb));
                if (ConversationListView.this.OZU == null || ConversationListView.this.Qdb) {
                    AppMethodBeat.o(259022);
                    return false;
                }
                boolean onItemLongClick = ConversationListView.this.OZU.onItemLongClick(adapterView, view, i2, j2);
                AppMethodBeat.o(259022);
                return onItemLongClick;
            }
        });
        AppMethodBeat.o(38372);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        AppMethodBeat.i(38373);
        this.awr = onItemClickListener;
        super.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.conversation.ConversationListView.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(259016);
                Log.i("MicroMsg.ConversationListView", "alvinluo onItemClick isCanClose: %b", Boolean.valueOf(ConversationListView.this.Qdb));
                if (ConversationListView.this.awr != null && !ConversationListView.this.Qdb) {
                    ConversationListView.this.awr.onItemClick(adapterView, view, i2, j2);
                }
                AppMethodBeat.o(259016);
            }
        });
        AppMethodBeat.o(38373);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(38374);
        super.onConfigurationChanged(configuration);
        Log.i("MicroMsg.ConversationListView", "[onConfigurationChanged] orientation:%s, last: %d", Integer.valueOf(configuration.orientation), Integer.valueOf(this.hIX));
        Cw(true);
        gVv();
        if (this.Qcv && this.Qcx != null) {
            this.Qcx.iE();
        }
        if (this.onh != null) {
            this.onh.f(configuration);
        }
        if (this.FSw != null) {
            this.FSw.FF(true);
        }
        if (this.QcR != null) {
            removeCallbacks(this.QcR);
        }
        AnonymousClass3 r0 = new Runnable() {
            /* class com.tencent.mm.ui.conversation.ConversationListView.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(38329);
                if (ao.isDarkMode()) {
                    ConversationListView.b(ConversationListView.this, ConversationListView.this.getResources().getColor(R.color.ko), ConversationListView.this.getResources().getColor(R.color.bw));
                } else {
                    ConversationListView.b(ConversationListView.this, ConversationListView.this.getResources().getColor(R.color.a2r), ConversationListView.this.getResources().getColor(R.color.bv));
                }
                if (ConversationListView.this.Qcx != null) {
                    ConversationListView.this.Qcx.fuz();
                }
                if (ConversationListView.this.onh != null) {
                    ConversationListView.this.onh.fuA();
                }
                ConversationListView.this.setSelection(1);
                ConversationListView.k(ConversationListView.this);
                AppMethodBeat.o(38329);
            }
        };
        this.QcR = r0;
        postDelayed(r0, 800);
        this.FSV = false;
        AppMethodBeat.o(38374);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(38375);
        super.onAttachedToWindow();
        if (this.QcW != null) {
            this.QcW.alive();
        }
        AppMethodBeat.o(38375);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(38376);
        super.onDetachedFromWindow();
        if (this.QcW != null) {
            this.QcW.dead();
        }
        AppMethodBeat.o(38376);
    }

    public void setActionBarUpdateCallback(final a aVar) {
        AppMethodBeat.i(234134);
        if (this.Qcx != null) {
            this.FSw = aVar;
            this.Qcx.setActionBarUpdateCallback(new a() {
                /* class com.tencent.mm.ui.conversation.ConversationListView.AnonymousClass6 */

                @Override // com.tencent.mm.plugin.taskbar.api.a
                public final void f(float f2, int i2, int i3) {
                    AppMethodBeat.i(259017);
                    if (aVar != null) {
                        aVar.f(f2, i2, i3);
                    }
                    AppMethodBeat.o(259017);
                }

                @Override // com.tencent.mm.plugin.taskbar.api.a
                public final void g(float f2, int i2, int i3) {
                    AppMethodBeat.i(259018);
                    if (aVar != null) {
                        aVar.g(f2, i2, i3);
                    }
                    AppMethodBeat.o(259018);
                }

                @Override // com.tencent.mm.plugin.taskbar.api.a
                public final void FF(boolean z) {
                    AppMethodBeat.i(259019);
                    if (aVar != null) {
                        aVar.FF(z);
                    }
                    AppMethodBeat.o(259019);
                }
            });
        }
        AppMethodBeat.o(234134);
    }

    public void setActivity(MMFragmentActivity mMFragmentActivity) {
        AppMethodBeat.i(38378);
        this.Dpx = mMFragmentActivity;
        if (this.onh != null) {
            this.onh.setActivity(this.Dpx);
        }
        AppMethodBeat.o(38378);
    }

    public void setStatusBarMaskView(View view) {
        AppMethodBeat.i(38379);
        this.FSz = view;
        if (this.Qcx != null) {
            this.Qcx.setStatusBarMaskView(view);
        }
        AppMethodBeat.o(38379);
    }

    public void setIsCurrentMainUI(boolean z) {
        AppMethodBeat.i(38380);
        Log.i("MicroMsg.ConversationListView", "alvinluo setIsCurrentMainUI: %b", Boolean.valueOf(z));
        this.FTf = z;
        if (this.Qcx != null) {
            this.Qcx.setIsCurrentMainUI(z);
        }
        AppMethodBeat.o(38380);
    }

    /* access modifiers changed from: package-private */
    public final void gVz() {
        AppMethodBeat.i(38381);
        if (this.ahC != null) {
            this.ahC.setTranslationY(0.0f);
            this.ahC.setVisibility(0);
        }
        gVA();
        AppMethodBeat.o(38381);
    }

    private void gVA() {
        AppMethodBeat.i(38382);
        if (this.FSw != null) {
            if (ao.isDarkMode()) {
                int color = getResources().getColor(R.color.bw);
                this.FSw.g(0.0f, color, color);
                this.FSw.f(0.0f, getResources().getColor(R.color.ko), 0);
                AppMethodBeat.o(38382);
                return;
            }
            int color2 = getResources().getColor(R.color.bv);
            this.FSw.g(0.0f, color2, color2);
            this.FSw.f(0.0f, getResources().getColor(R.color.a2r), 0);
        }
        AppMethodBeat.o(38382);
    }

    static /* synthetic */ void b(ConversationListView conversationListView, int i2) {
        int i3;
        AppMethodBeat.i(38385);
        int[] iArr = new int[2];
        conversationListView.ahC.getLocationOnScreen(iArr);
        int i4 = iArr[1];
        int[] iArr2 = new int[2];
        conversationListView.getLocationOnScreen(iArr2);
        int i5 = iArr2[1];
        ViewGroup.LayoutParams layoutParams = conversationListView.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            i3 = ((RelativeLayout.LayoutParams) layoutParams).topMargin;
        } else {
            i3 = 0;
        }
        String lowerCase = Util.nullAs(Build.MANUFACTURER, "").toLowerCase();
        boolean z = lowerCase.contains("vivo") && Build.VERSION.SDK_INT == 28;
        Log.i("MicroMsg.ConversationListView", "alvinluo initActionBarView actionBarTopOnScreen: %d, listTopOnScreen: %d, listTopMargin: %d, manufacturer: %s, isVivoAbove28: %b", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i3), lowerCase, Boolean.valueOf(z));
        if (i5 - i3 != i4 || !z) {
            conversationListView.mStatusBarHeight = au.getStatusBarHeight(conversationListView.getContext());
            Log.e("MicroMsg.ConversationListView", "alvinluo initActionBarView get default status bar height: %d", Integer.valueOf(conversationListView.mStatusBarHeight));
            conversationListView.lm(conversationListView.mStatusBarHeight, i2);
            bN(conversationListView.mStatusBarHeight, false);
            AppMethodBeat.o(38385);
            return;
        }
        conversationListView.mStatusBarHeight = 0;
        Log.i("MicroMsg.ConversationListView", "alvinluo initActionBarView set top to 0");
        conversationListView.lm(0, i2);
        bN(0, true);
        AppMethodBeat.o(38385);
    }

    static /* synthetic */ void k(ConversationListView conversationListView) {
        AppMethodBeat.i(259028);
        int childCount = conversationListView.getChildCount();
        Log.i("MicroMsg.ConversationListView", "alvinluo resetListAlpha first: %d, last: %d", 1, Integer.valueOf(childCount));
        for (int i2 = 1; i2 <= childCount; i2++) {
            View childAt = conversationListView.getChildAt(i2);
            if (childAt != null) {
                Log.v("MicroMsg.ConversationListView", "alvinluo resetListAlpha index: %d", Integer.valueOf(i2));
                childAt.setAlpha(1.0f);
            }
        }
        AppMethodBeat.o(259028);
    }
}
