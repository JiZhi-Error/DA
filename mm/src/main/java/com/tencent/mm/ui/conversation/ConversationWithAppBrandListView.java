package com.tencent.mm.ui.conversation;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Vibrator;
import android.support.v4.view.v;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recent.g;
import com.tencent.mm.plugin.appbrand.widget.recent.l;
import com.tencent.mm.plugin.taskbar.api.GyroView;
import com.tencent.mm.plugin.taskbar.api.HeaderContainer;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.au;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationWithAppBrandListView extends ListView implements AbsListView.OnScrollListener, AppBrandRecentView.e {
    private float CBd;
    private MMFragmentActivity Dpx;
    private float FSk;
    private GyroView FTo;
    private View GQ;
    private LinkedList<ListView.FixedViewInfo> Qcu;
    private boolean QdA;
    private com.tencent.mm.plugin.taskbar.api.a QdB;
    private Runnable QdC;
    private boolean QdD;
    private float QdE;
    private com.tencent.mm.plugin.appbrand.widget.c.a QdF;
    private com.tencent.mm.plugin.appbrand.widget.c.a QdG;
    private com.tencent.mm.plugin.appbrand.widget.c.a QdH;
    private IListener<mh> QdI;
    private int QdJ;
    boolean QdK;
    private final IListener<ks> QdL;
    private a QdM;
    private int QdN;
    private float QdO;
    private float QdP;
    private boolean QdQ;
    private boolean QdR;
    private boolean QdS;
    private boolean QdT;
    private boolean QdU;
    private Runnable QdV;
    private Runnable QdW;
    private boolean QdX;
    private boolean QdY;
    private int QdZ;
    private View Qda;
    private HeaderContainer Qdm;
    private View Qdn;
    private AppBrandRecentView Qdo;
    private boolean Qdp;
    private Paint Qdq;
    private g Qdr;
    private String Qds;
    private float Qdt;
    private com.tencent.mm.plugin.appbrand.widget.c.a.a Qdu;
    private boolean Qdv;
    private boolean Qdw;
    private float Qdx;
    private float Qdy;
    private int Qdz;
    private int asD;
    private int asE;
    private int asF;
    private boolean dLD;
    private boolean dLH;
    private ValueAnimator dgN;
    private boolean hasInit;
    private boolean isInit;
    private int mTouchSlop;
    private Paint nYR;
    private float onW;
    private Vibrator ooM;
    private float riK;
    private float riL;
    private boolean xbw;
    private AbsListView.OnScrollListener yQz;

    static /* synthetic */ void a(ConversationWithAppBrandListView conversationWithAppBrandListView, int i2, int i3) {
        AppMethodBeat.i(38475);
        super.smoothScrollToPositionFromTop(i2, i3);
        AppMethodBeat.o(38475);
    }

    static /* synthetic */ void a(ConversationWithAppBrandListView conversationWithAppBrandListView, boolean z) {
        AppMethodBeat.i(38469);
        conversationWithAppBrandListView.Cw(z);
        AppMethodBeat.o(38469);
    }

    static /* synthetic */ void e(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(38472);
        conversationWithAppBrandListView.gVJ();
        AppMethodBeat.o(38472);
    }

    static /* synthetic */ void f(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(38473);
        conversationWithAppBrandListView.gVD();
        AppMethodBeat.o(38473);
    }

    static /* synthetic */ void g(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(38476);
        conversationWithAppBrandListView.gVI();
        AppMethodBeat.o(38476);
    }

    static /* synthetic */ void h(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(38477);
        conversationWithAppBrandListView.Cz(true);
        AppMethodBeat.o(38477);
    }

    static /* synthetic */ void m(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(38478);
        conversationWithAppBrandListView.Cx(true);
        AppMethodBeat.o(38478);
    }

    static /* synthetic */ void p(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(38480);
        conversationWithAppBrandListView.anO(0);
        AppMethodBeat.o(38480);
    }

    @Override // android.widget.AbsListView, android.widget.ListView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter adapter) {
        AppMethodBeat.i(38468);
        setAdapter((ListAdapter) adapter);
        AppMethodBeat.o(38468);
    }

    public ConversationWithAppBrandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38422);
        this.Qcu = new LinkedList<>();
        this.Qdp = false;
        this.Qdv = false;
        this.Qdw = false;
        this.dLH = false;
        this.Qdx = 0.0f;
        this.Qdy = 0.0f;
        this.Qdz = 0;
        this.QdA = false;
        this.QdC = null;
        this.QdD = true;
        this.QdE = 0.0f;
        this.QdF = null;
        this.QdG = null;
        this.QdH = null;
        this.QdI = new IListener<mh>() {
            /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass1 */

            {
                AppMethodBeat.i(161566);
                this.__eventId = mh.class.getName().hashCode();
                AppMethodBeat.o(161566);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(mh mhVar) {
                AppMethodBeat.i(38395);
                Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo MainUITabDoubleClick callback");
                ConversationWithAppBrandListView.this.as(0, 7);
                AppMethodBeat.o(38395);
                return false;
            }
        };
        this.isInit = true;
        this.QdJ = 0;
        this.QdK = false;
        this.asD = -1;
        this.QdL = new IListener<ks>() {
            /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass21 */

            {
                AppMethodBeat.i(161567);
                this.__eventId = ks.class.getName().hashCode();
                AppMethodBeat.o(161567);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ks ksVar) {
                AppMethodBeat.i(38417);
                ks ksVar2 = ksVar;
                ConversationWithAppBrandListView.this.as((long) ksVar2.dPN.delay, ksVar2.dPN.type);
                AppMethodBeat.o(38417);
                return true;
            }
        };
        this.QdM = new a();
        this.QdN = 0;
        this.QdO = 0.0f;
        this.QdP = 0.0f;
        this.QdR = false;
        this.QdT = false;
        this.QdU = false;
        this.QdW = new Runnable() {
            /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass17 */

            public final void run() {
                AppMethodBeat.i(38413);
                ConversationWithAppBrandListView.this.xbw = false;
                ConversationWithAppBrandListView.this.QdX = true;
                ConversationWithAppBrandListView.m(ConversationWithAppBrandListView.this);
                AppMethodBeat.o(38413);
            }
        };
        this.xbw = false;
        this.QdX = false;
        this.QdY = false;
        this.hasInit = false;
        this.QdF = new com.tencent.mm.plugin.appbrand.widget.c.a(getContext().getResources().getColor(R.color.f3043a), getContext().getResources().getColor(R.color.d2));
        this.QdI.alive();
        AppMethodBeat.o(38422);
    }

    public void setActivity(MMFragmentActivity mMFragmentActivity) {
        AppMethodBeat.i(38424);
        this.Dpx = mMFragmentActivity;
        gVG();
        AppMethodBeat.o(38424);
    }

    public void setActionBarUpdateCallback(com.tencent.mm.plugin.taskbar.api.a aVar) {
        this.QdB = aVar;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(38425);
        super.onLayout(z, i2, i3, i4, i5);
        if (z && CA(true)) {
            if (this.isInit) {
                Cw(true);
                post(new Runnable() {
                    /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass20 */

                    public final void run() {
                        AppMethodBeat.i(38416);
                        ConversationWithAppBrandListView.this.setSelection(0);
                        AppMethodBeat.o(38416);
                    }
                });
                this.QdJ = i5;
                this.isInit = false;
                AppMethodBeat.o(38425);
                return;
            } else if (!this.dLD && this.QdJ != i5) {
                Log.i("MicroMsg.ConversationWithAppBrandListView", "[onLayout] mLastBottom:" + this.QdJ + " b:" + i5);
                Cw(true);
                this.QdJ = i5;
            }
        }
        AppMethodBeat.o(38425);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(38426);
        super.onConfigurationChanged(configuration);
        Log.i("MicroMsg.ConversationWithAppBrandListView", "[onConfigurationChanged] orientation:%s", Integer.valueOf(configuration.orientation));
        this.QdK = true;
        Cw(true);
        this.QdD = false;
        AppMethodBeat.o(38426);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(38427);
        if (getFirstVisiblePosition() != 0) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(38427);
            return onInterceptTouchEvent;
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        switch (actionMasked) {
            case 0:
                this.asD = motionEvent.getPointerId(0);
                this.asE = (int) (motionEvent.getX() + 0.5f);
                this.asF = (int) (motionEvent.getY() + 0.5f);
                boolean onInterceptTouchEvent2 = super.onInterceptTouchEvent(motionEvent);
                AppMethodBeat.o(38427);
                return onInterceptTouchEvent2;
            case 1:
            case 3:
            case 4:
            default:
                boolean onInterceptTouchEvent3 = super.onInterceptTouchEvent(motionEvent);
                AppMethodBeat.o(38427);
                return onInterceptTouchEvent3;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.asD);
                if (findPointerIndex < 0) {
                    AppMethodBeat.o(38427);
                    return false;
                }
                int x = ((int) (motionEvent.getX(findPointerIndex) + 0.5f)) - this.asE;
                int y = ((int) (motionEvent.getY(findPointerIndex) + 0.5f)) - this.asF;
                if (Math.abs(y) <= this.mTouchSlop || Math.abs(y) < Math.abs(x)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z || !super.onInterceptTouchEvent(motionEvent)) {
                    AppMethodBeat.o(38427);
                    return false;
                }
                AppMethodBeat.o(38427);
                return true;
            case 5:
                this.asD = motionEvent.getPointerId(actionIndex);
                this.asE = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.asF = (int) (motionEvent.getY(actionIndex) + 0.5f);
                boolean onInterceptTouchEvent4 = super.onInterceptTouchEvent(motionEvent);
                AppMethodBeat.o(38427);
                return onInterceptTouchEvent4;
        }
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        AppMethodBeat.i(38428);
        ListView.FixedViewInfo fixedViewInfo = new ListView.FixedViewInfo(this);
        fixedViewInfo.view = view;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z;
        this.Qcu.add(fixedViewInfo);
        if (getAdapter() != null) {
            super.addHeaderView(fixedViewInfo.view, fixedViewInfo.data, fixedViewInfo.isSelectable);
        }
        Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo addHeaderView %d", Integer.valueOf(this.Qcu.size()));
        AppMethodBeat.o(38428);
    }

    public void setOnItemClickListener(final AdapterView.OnItemClickListener onItemClickListener) {
        AppMethodBeat.i(38429);
        super.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass22 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(38418);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(adapterView, view, i2, j2);
                }
                if (!ConversationWithAppBrandListView.b(ConversationWithAppBrandListView.this)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(38418);
                    return;
                }
                if (ConversationWithAppBrandListView.this.getFirstVisiblePosition() == 0) {
                    ConversationWithAppBrandListView.this.as(500, 8);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(38418);
            }
        });
        AppMethodBeat.o(38429);
    }

    public void setOnItemLongClickListener(final AdapterView.OnItemLongClickListener onItemLongClickListener) {
        AppMethodBeat.i(38430);
        super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass23 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(38419);
                if (i2 == 0 && ConversationWithAppBrandListView.b(ConversationWithAppBrandListView.this)) {
                    AppMethodBeat.o(38419);
                    return false;
                } else if (onItemLongClickListener != null) {
                    boolean onItemLongClick = onItemLongClickListener.onItemLongClick(adapterView, view, i2, j2);
                    AppMethodBeat.o(38419);
                    return onItemLongClick;
                } else {
                    AppMethodBeat.o(38419);
                    return false;
                }
            }
        });
        AppMethodBeat.o(38430);
    }

    public final void as(long j2, int i2) {
        AppMethodBeat.i(38431);
        Log.i("MicroMsg.ConversationWithAppBrandListView", "[hideAppBrandRecentView] delay:%s, type: %d", Long.valueOf(j2), Integer.valueOf(i2));
        if (!CA(true)) {
            if (this.Qdn != null) {
                this.Qdn.setVisibility(8);
            }
            AppMethodBeat.o(38431);
        } else if (getFirstVisiblePosition() != 0) {
            AppMethodBeat.o(38431);
        } else {
            if (!(this.Qdr == null || this.Qdu == null)) {
                this.Qdr.R(this.Qdu.caL(), this.Qdu.caM(), i2);
            }
            if (j2 > 0) {
                if (this.QdC != null) {
                    removeCallbacks(this.QdC);
                }
                this.QdC = new Runnable() {
                    /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass24 */

                    public final void run() {
                        AppMethodBeat.i(38420);
                        if (ConversationWithAppBrandListView.this.Qdu != null) {
                            Log.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetToFirstPage");
                            com.tencent.mm.plugin.appbrand.widget.c.a.a unused = ConversationWithAppBrandListView.this.Qdu;
                        }
                        if (ConversationWithAppBrandListView.this.Qdo != null) {
                            AppBrandRecentView appBrandRecentView = ConversationWithAppBrandListView.this.Qdo;
                            com.tencent.mm.hellhoundlib.b.a a2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                            com.tencent.mm.hellhoundlib.a.a.a(appBrandRecentView, a2.axQ(), "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$9", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                            appBrandRecentView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(appBrandRecentView, "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$9", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                        }
                        View childAt = ConversationWithAppBrandListView.this.getChildAt(0);
                        int bottom = childAt == null ? 0 : childAt.getBottom();
                        if (bottom != 0) {
                            ConversationWithAppBrandListView.this.smoothScrollBy(bottom, 0);
                        }
                        ConversationWithAppBrandListView.this.setSelection(0);
                        ConversationWithAppBrandListView.e(ConversationWithAppBrandListView.this);
                        AppMethodBeat.o(38420);
                    }
                };
                postDelayed(this.QdC, j2);
            } else {
                if (this.Qdo != null) {
                    AppBrandRecentView appBrandRecentView = this.Qdo;
                    com.tencent.mm.hellhoundlib.b.a a2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(appBrandRecentView, a2.axQ(), "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView", "hideAppBrandRecentView", "(JI)V", "Undefined", "smoothScrollToPosition", "(I)V");
                    appBrandRecentView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(appBrandRecentView, "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView", "hideAppBrandRecentView", "(JI)V", "Undefined", "smoothScrollToPosition", "(I)V");
                }
                setSelection(0);
                Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
                gVJ();
            }
            gVI();
            AppMethodBeat.o(38431);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.e
    public final void yL(int i2) {
        AppMethodBeat.i(38432);
        Log.i("MicroMsg.ConversationWithAppBrandListView", "[next] size:%s isAppBrandHeaderEnable:%s", Integer.valueOf(i2), Boolean.valueOf(this.Qdp));
        if (!CA(true)) {
            Log.w("MicroMsg.ConversationWithAppBrandListView", "[next] is disable!");
            if (this.Qdn != null) {
                this.Qdn.setVisibility(8);
            }
            AppMethodBeat.o(38432);
            return;
        }
        if (i2 == 1 && this.Qdn != null) {
            setEmptyViewVisible(true);
        } else if (i2 > 1 && this.Qdn != null) {
            setEmptyViewVisible(false);
        }
        if (this.Qdn != null && this.Qdn.getVisibility() == 8) {
            this.Qdn.setVisibility(0);
            setSelection(getFirstVisiblePosition());
        }
        AppMethodBeat.o(38432);
    }

    private View getEmptyFooter() {
        AppMethodBeat.i(38433);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.Qda = new View(getContext());
        this.Qda.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
        linearLayout.addView(this.Qda);
        linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.afz));
        AppMethodBeat.o(38433);
        return linearLayout;
    }

    private void Cw(boolean z) {
        AppMethodBeat.i(38434);
        if (this.Qda == null || !CA(true)) {
            AppMethodBeat.o(38434);
        } else if (z) {
            postDelayed(new Runnable() {
                /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(38396);
                    ConversationWithAppBrandListView.f(ConversationWithAppBrandListView.this);
                    AppMethodBeat.o(38396);
                }
            }, 0);
            AppMethodBeat.o(38434);
        } else {
            gVD();
            AppMethodBeat.o(38434);
        }
    }

    private int getTabViewHeight() {
        View findViewById;
        AppMethodBeat.i(38435);
        if (this.Qdz == 0 && (findViewById = getRootView().findViewById(R.id.e8y)) != null) {
            Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initTabViewHeight tabView.getHeight: %d", Integer.valueOf(findViewById.getHeight()));
            this.Qdz = findViewById.getHeight();
        }
        int i2 = this.Qdz;
        AppMethodBeat.o(38435);
        return i2;
    }

    private void gVD() {
        float f2;
        int count;
        boolean z = false;
        AppMethodBeat.i(38436);
        int firstHeaderVisible = getFirstHeaderVisible();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Qda.getLayoutParams();
        int i2 = layoutParams.height;
        try {
            if (getAdapter() == null) {
                count = 0;
            } else {
                count = getAdapter().getCount();
            }
            f2 = anP(count);
        } catch (Exception e2) {
            f2 = 0.0f;
        }
        if (f2 < 0.0f) {
            z = true;
        }
        if (f2 < ((float) getTabViewHeight())) {
            f2 = (float) getTabViewHeight();
        }
        Log.i("MicroMsg.ConversationWithAppBrandListView", "[checkEmptyFooter] isRealFull:" + z + " extraHeight:" + f2);
        if (z) {
            layoutParams.height = getTabViewHeight();
        } else {
            layoutParams.height = (int) f2;
            if (this.isInit) {
                post(new Runnable() {
                    /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(38397);
                        ConversationWithAppBrandListView.this.setSelection(0);
                        AppMethodBeat.o(38397);
                    }
                });
            }
        }
        if (i2 != layoutParams.height) {
            this.Qda.setLayoutParams(layoutParams);
            if (!this.isInit) {
                super.setSelection(firstHeaderVisible);
            }
        }
        AppMethodBeat.o(38436);
    }

    private void Cx(boolean z) {
        AppMethodBeat.i(38437);
        if (z) {
            MMHandlerThread.removeRunnable(this.QdM);
            AppMethodBeat.o(38437);
            return;
        }
        MMHandlerThread.removeRunnable(this.QdM);
        MMHandlerThread.postToMainThreadDelayed(this.QdM, 1000);
        AppMethodBeat.o(38437);
    }

    private void setEmptyViewVisible(boolean z) {
        View findViewById;
        int i2 = 0;
        AppMethodBeat.i(38438);
        Log.i("MicroMsg.ConversationWithAppBrandListView", "[setEmptyViewVisible] isShow:%s", Boolean.valueOf(z));
        if (this.GQ != null) {
            this.GQ.setVisibility(z ? 0 : 8);
        }
        if (!(this.Qdn == null || (findViewById = this.Qdn.findViewById(R.id.td)) == null)) {
            if (z) {
                i2 = 4;
            }
            findViewById.setVisibility(i2);
        }
        AppMethodBeat.o(38438);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(38439);
        super.onMeasure(i2, i3);
        gVF();
        AppMethodBeat.o(38439);
    }

    private boolean gVE() {
        int measuredHeight;
        AppMethodBeat.i(38440);
        if (this.Qdn == null || this.Qdu == null || (measuredHeight = this.Qdm.getMeasuredHeight()) == 0 || measuredHeight == this.QdN) {
            AppMethodBeat.o(38440);
            return false;
        }
        this.QdN = measuredHeight;
        AppMethodBeat.o(38440);
        return true;
    }

    private void gVF() {
        AppMethodBeat.i(38441);
        if (gVE()) {
            if (this.FTo != null) {
                this.FTo.setVisibility(0);
            }
            this.Qdx = -(this.FSk - getResources().getDimension(R.dimen.hw));
            this.Qdy = -(this.FSk - (((float) (this.QdN / 2)) - getResources().getDimension(R.dimen.hd)));
            if (!this.dLH) {
                if (this.Qdn != null) {
                    this.Qdn.setTranslationY(this.Qdx);
                }
                if (this.GQ != null) {
                    this.GQ.setTranslationY(0.0f);
                }
                Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight AppBrandHeader appBrandHeight: %d, setTranslationY: %s", Integer.valueOf(this.QdN), Float.valueOf(this.Qdx));
                AppMethodBeat.o(38441);
                return;
            }
            if (this.Qdn != null) {
                this.Qdn.setTranslationY(0.0f);
            }
            if (this.GQ != null) {
                this.GQ.setTranslationY(this.Qdy);
            }
            Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight emptyView appBrandHeight: %d, setTranslationY: %s", Integer.valueOf(this.QdN), Float.valueOf(this.Qdy));
        }
        AppMethodBeat.o(38441);
    }

    private void gVG() {
        AppMethodBeat.i(38442);
        if (this.QdA) {
            AppMethodBeat.o(38442);
        } else if (com.tencent.mm.kernel.g.af(l.class) != null) {
            this.Qdm = ((com.tencent.mm.plugin.taskbar.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.taskbar.api.c.class)).hn(this.Dpx);
            this.QdA = true;
            this.Qdm.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            this.Qdn = this.Qdm.findViewById(R.id.tc);
            this.Qdn.setVisibility(8);
            this.FTo = this.Qdm.getGyroView();
            this.Qdu = this.Qdm.getHeaderView();
            new AppBrandRecentView.e() {
                /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.e
                public final void yL(int i2) {
                    AppMethodBeat.i(38398);
                    Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone MyAppBrand size: %d", Integer.valueOf(i2));
                    if (i2 <= 0) {
                        ConversationWithAppBrandListView.this.Qdv = true;
                    } else {
                        ConversationWithAppBrandListView.this.Qdv = false;
                    }
                    ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, i2);
                    AppMethodBeat.o(38398);
                }
            };
            new AppBrandRecentView.e() {
                /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.e
                public final void yL(int i2) {
                    AppMethodBeat.i(38399);
                    Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone RecentAppBrand size: %d", Integer.valueOf(i2));
                    if (i2 <= 0) {
                        ConversationWithAppBrandListView.this.Qdw = true;
                    } else {
                        ConversationWithAppBrandListView.this.Qdw = false;
                    }
                    ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, i2);
                    AppMethodBeat.o(38399);
                }
            };
            new Object() {
                /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass6 */
            };
            new Object() {
                /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass7 */
            };
            this.GQ = this.Qdm.getEmptyView();
            this.Qcu.remove(this.Qdm);
            ListView.FixedViewInfo fixedViewInfo = new ListView.FixedViewInfo(this);
            fixedViewInfo.view = this.Qdm;
            fixedViewInfo.data = null;
            fixedViewInfo.isSelectable = true;
            this.Qcu.addFirst(fixedViewInfo);
            Iterator<ListView.FixedViewInfo> it = this.Qcu.iterator();
            while (it.hasNext()) {
                ListView.FixedViewInfo next = it.next();
                super.addHeaderView(next.view, next.data, next.isSelectable);
            }
            AppMethodBeat.o(38442);
        } else {
            Log.e("MicroMsg.ConversationWithAppBrandListView", "alvinluo addAppBrandHalfView error");
            AppMethodBeat.o(38442);
        }
    }

    public void setSelection(int i2) {
        AppMethodBeat.i(38443);
        Log.i("MicroMsg.ConversationWithAppBrandListView", "[setSelection] position:%s", Integer.valueOf(i2));
        if (i2 != 0 || !CA(true)) {
            super.setSelection(i2);
            AppMethodBeat.o(38443);
            return;
        }
        int firstHeaderVisible = getFirstHeaderVisible();
        Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo setSelection pos: %d, appbrandHeight: %d", Integer.valueOf(firstHeaderVisible), Integer.valueOf(this.QdN));
        super.setSelection(firstHeaderVisible);
        if (!(this.Qdr == null || this.Qdu == null)) {
            this.Qdr.R(this.Qdu.caL(), this.Qdu.caM(), 7);
        }
        AppMethodBeat.o(38443);
    }

    public void smoothScrollToPosition(int i2) {
        AppMethodBeat.i(38444);
        Log.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPosition] position:%s", Integer.valueOf(i2));
        if (i2 != 0 || !CA(true)) {
            super.smoothScrollToPosition(i2);
            AppMethodBeat.o(38444);
            return;
        }
        super.smoothScrollToPosition(getFirstHeaderVisible());
        AppMethodBeat.o(38444);
    }

    public void smoothScrollToPositionFromTop(final int i2, final int i3) {
        AppMethodBeat.i(38445);
        Log.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && CA(true)) {
            i2 = getFirstHeaderVisible();
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(38403);
                ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, i2, i3);
                AppMethodBeat.o(38403);
            }
        }, 100);
        AppMethodBeat.o(38445);
    }

    public void smoothScrollToPositionFromTop(int i2, int i3, int i4) {
        AppMethodBeat.i(38446);
        Log.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i2 != 0 || !CA(true)) {
            super.smoothScrollToPositionFromTop(i2, i3, i4);
            AppMethodBeat.o(38446);
            return;
        }
        super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), i3, i4);
        AppMethodBeat.o(38446);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.yQz = onScrollListener;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(38448);
        try {
            if (motionEvent.getAction() == 0) {
                float x = motionEvent.getX();
                this.riK = x;
                this.CBd = x;
                float y = motionEvent.getY();
                this.riL = y;
                this.onW = y;
            }
            return super.dispatchTouchEvent(motionEvent);
        } finally {
            this.riK = motionEvent.getX();
            this.riL = motionEvent.getY();
            AppMethodBeat.o(38448);
        }
    }

    private boolean aj(MotionEvent motionEvent) {
        AppMethodBeat.i(38450);
        if (!gVK()) {
            AppMethodBeat.o(38450);
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.QdP = motionEvent.getY();
            if (this.dgN != null) {
                this.dgN.cancel();
            }
        } else if (motionEvent.getActionMasked() == 5) {
            this.QdP = motionEvent.getY();
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.Qdm.getTop() == 0 && getChildTranslationY() != 0.0f) {
            Cy(true);
            this.QdR = false;
            Log.d("MicroMsg.ConversationWithAppBrandListView", "[animationChild] offset:%s delay:%s duration%s", 0, 0, Integer.valueOf((int) TXLiveConstants.RENDER_ROTATION_180));
            if (gVK()) {
                if (this.dgN != null) {
                    this.dgN.cancel();
                }
                this.dgN = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("deltaY", getChildTranslationY() + 0.0f, 0.0f), PropertyValuesHolder.ofFloat("headerDeltaY", getHeaderY() + 0.0f, 0.0f));
                this.dgN.setDuration(180L);
                this.dgN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass10 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(38405);
                        float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue("headerDeltaY")).floatValue();
                        for (int i2 = 0; i2 < ConversationWithAppBrandListView.this.getChildCount(); i2++) {
                            if (i2 == 0) {
                                ConversationWithAppBrandListView.this.getChildAt(i2).setTranslationY(floatValue2);
                            } else {
                                ConversationWithAppBrandListView.this.getChildAt(i2).setTranslationY(floatValue);
                            }
                            ConversationWithAppBrandListView.this.QdO = floatValue;
                        }
                        ConversationWithAppBrandListView.this.invalidate();
                        AppMethodBeat.o(38405);
                    }
                });
                this.dgN.addListener(new Animator.AnimatorListener() {
                    /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass12 */

                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(38407);
                        ConversationWithAppBrandListView.g(ConversationWithAppBrandListView.this);
                        AppMethodBeat.o(38407);
                    }

                    public final void onAnimationCancel(Animator animator) {
                        AppMethodBeat.i(38408);
                        ConversationWithAppBrandListView.g(ConversationWithAppBrandListView.this);
                        AppMethodBeat.o(38408);
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
                this.dgN.setStartDelay(0);
                this.dgN.start();
            }
        }
        try {
            if (!(motionEvent.getAction() == 2 && Math.abs(motionEvent.getY() - this.riL) > 2.0f && getFirstVisiblePosition() == 0 && this.Qdm.getTop() == 0) && getChildTranslationY() == 0.0f) {
                this.QdP = motionEvent.getY();
                AppMethodBeat.o(38450);
                return false;
            }
            Cx(true);
            if (((float) (((getHeight() - getTabViewHeight()) - this.QdN) / 2)) <= this.QdO) {
                Cy(false);
            } else {
                Cy(true);
            }
            float y = motionEvent.getY() - this.QdP;
            float height = (float) ((getHeight() - getTabViewHeight()) - this.QdN);
            this.QdO = (y * 0.4f) + this.QdO;
            if (this.QdO < 0.0f) {
                this.QdO = 0.0f;
                gVI();
                invalidate();
                return false;
            }
            if (height < this.QdO) {
                this.QdO = height;
            }
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                if (i2 == 0) {
                    getChildAt(i2).setTranslationY(this.QdO * 0.5f);
                } else {
                    getChildAt(i2).setTranslationY(this.QdO);
                }
            }
            invalidate();
            this.QdP = motionEvent.getY();
            AppMethodBeat.o(38450);
            return true;
        } finally {
            this.QdP = motionEvent.getY();
            AppMethodBeat.o(38450);
        }
    }

    private void gVH() {
        AppMethodBeat.i(38451);
        if (!this.QdS) {
            PlaySound.play(getContext(), (int) R.string.qc, 3);
            if (!(this.Qdr == null || this.Qdu == null)) {
                this.Qdr.eO(this.Qdu.caL(), this.Qdu.caM());
            }
        }
        if (this.QdK && this.Qdo != null) {
            this.Qdo.getAdapter().atj.notifyChanged();
            this.QdK = true;
        }
        super.smoothScrollToPositionFromTop(0, 0, 250);
        Cx(true);
        setOpenAppBrandRecentView(true);
        AppMethodBeat.o(38451);
    }

    private void anO(int i2) {
        AppMethodBeat.i(38453);
        Log.i("MicroMsg.ConversationWithAppBrandListView", "[closeAppBrandRecentView] isOpenAppBrandRecentView:%s type:%s", Boolean.valueOf(this.QdS), Integer.valueOf(i2));
        if (!(!this.QdS || getChildAt(0) == null || this.Qdr == null || this.Qdu == null)) {
            this.Qdr.R(this.Qdu.caL(), this.Qdu.caM(), i2);
        }
        if (getFirstVisiblePosition() == 0) {
            View childAt = getChildAt(0);
            if ((childAt == null ? 0 : childAt.getBottom()) != 0) {
                smoothScrollToPositionFromTop(getFirstHeaderVisible(), 0, 150);
            }
        }
        gVI();
        Cx(true);
        setOpenAppBrandRecentView(false);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(38404);
                if (ConversationWithAppBrandListView.this.Qdu != null) {
                    Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo scrollToFirstPage");
                    com.tencent.mm.plugin.appbrand.widget.c.a.a unused = ConversationWithAppBrandListView.this.Qdu;
                }
                AppMethodBeat.o(38404);
            }
        }, 500);
        AppMethodBeat.o(38453);
    }

    private void setOpenAppBrandRecentView(boolean z) {
        this.QdS = z;
    }

    private float getChildTranslationY() {
        AppMethodBeat.i(38454);
        View childAt = getChildAt(1);
        if (childAt == null) {
            AppMethodBeat.o(38454);
            return 0.0f;
        }
        float translationY = childAt.getTranslationY();
        AppMethodBeat.o(38454);
        return translationY;
    }

    private float getHeaderY() {
        AppMethodBeat.i(38455);
        View childAt = getChildAt(0);
        if (childAt == null) {
            AppMethodBeat.o(38455);
            return 0.0f;
        }
        float translationY = childAt.getTranslationY();
        AppMethodBeat.o(38455);
        return translationY;
    }

    private void gVI() {
        AppMethodBeat.i(38456);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).setTranslationY(0.0f);
        }
        this.QdO = 0.0f;
        invalidate();
        AppMethodBeat.o(38456);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z;
        AppMethodBeat.i(38457);
        super.onDraw(canvas);
        if (getFirstVisiblePosition() == 0 && this.Qdm != null) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), ((float) this.Qdm.getBottom()) + this.QdO, this.nYR);
            if (getChildAt(1) != null) {
                if (getHeight() == 0 || !this.QdU) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    canvas.drawText(this.Qds, (((float) getWidth()) - this.Qdt) / 2.0f, (((float) this.Qdm.getBottom()) + this.QdO) - getResources().getDimension(R.dimen.i1), this.Qdq);
                }
            }
        }
        AppMethodBeat.o(38457);
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(38458);
        if (this.yQz != null) {
            this.yQz.onScrollStateChanged(absListView, i2);
        }
        if (getFirstVisiblePosition() != 0 && i2 == 2 && !this.QdT) {
            this.xbw = true;
        }
        AppMethodBeat.o(38458);
    }

    private void Cy(boolean z) {
        AppMethodBeat.i(38459);
        if (z && this.QdV != null) {
            MMHandlerThread.removeRunnable(this.QdV);
            this.QdV = null;
            if (this.QdU) {
                Cz(false);
                AppMethodBeat.o(38459);
                return;
            }
        } else if (!z && this.QdV == null) {
            AnonymousClass13 r0 = new Runnable() {
                /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass13 */

                public final void run() {
                    AppMethodBeat.i(38409);
                    Log.i("MicroMsg.ConversationWithAppBrandListView", "[CheckShowTipTask]");
                    ConversationWithAppBrandListView.h(ConversationWithAppBrandListView.this);
                    AppMethodBeat.o(38409);
                }
            };
            this.QdV = r0;
            MMHandlerThread.postToMainThreadDelayed(r0, 3000);
        }
        AppMethodBeat.o(38459);
    }

    private void Cz(boolean z) {
        AppMethodBeat.i(38460);
        Log.i("MicroMsg.ConversationWithAppBrandListView", "[showTipWithAnim] isShow:%s", Boolean.valueOf(z));
        if (z) {
            this.QdU = true;
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("alpha", 0, 77));
            ofPropertyValuesHolder.setDuration(200L);
            ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass14 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(38410);
                    ConversationWithAppBrandListView.this.Qdq.setAlpha(((Integer) valueAnimator.getAnimatedValue("alpha")).intValue());
                    ConversationWithAppBrandListView.this.invalidate();
                    AppMethodBeat.o(38410);
                }
            });
            ofPropertyValuesHolder.start();
            if (this.Qdr != null) {
                this.Qdr.ccT();
            }
            AppMethodBeat.o(38460);
            return;
        }
        ValueAnimator ofPropertyValuesHolder2 = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("alpha", 77, 0));
        ofPropertyValuesHolder2.setDuration(200L);
        ofPropertyValuesHolder2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass15 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(38411);
                ConversationWithAppBrandListView.this.Qdq.setAlpha(((Integer) valueAnimator.getAnimatedValue("alpha")).intValue());
                ConversationWithAppBrandListView.this.invalidate();
                AppMethodBeat.o(38411);
            }
        });
        ofPropertyValuesHolder2.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass16 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(38412);
                ConversationWithAppBrandListView.this.QdU = false;
                AppMethodBeat.o(38412);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        ofPropertyValuesHolder2.start();
        AppMethodBeat.o(38460);
    }

    private void gVJ() {
        AppMethodBeat.i(38461);
        Log.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
        if (this.nYR != null) {
            this.nYR.setColor(this.Dpx.getResources().getColor(R.color.d8));
        }
        AppMethodBeat.o(38461);
    }

    private float getRatio() {
        float f2 = 0.0f;
        AppMethodBeat.i(38462);
        if (this.Qdm == null || this.QdN == 0) {
            AppMethodBeat.o(38462);
        } else {
            float abs = 1.0f - (Math.abs(((float) this.Qdm.getTop()) * 1.0f) / ((float) this.QdN));
            if (abs >= 0.0f) {
                f2 = abs;
            }
            Log.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo header top: %d, header bottom: %d, ratio: %f, appBrandHeight: %d", Integer.valueOf(this.Qdm.getTop()), Integer.valueOf(this.Qdm.getBottom()), Float.valueOf(f2), Integer.valueOf(this.QdN));
            AppMethodBeat.o(38462);
        }
        return f2;
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AppMethodBeat.i(38463);
        if (this.yQz != null) {
            this.yQz.onScroll(absListView, i2, i3, i4);
        }
        if (!CA(true)) {
            AppMethodBeat.o(38463);
            return;
        }
        gVF();
        if (this.QdN == 0) {
            AppMethodBeat.o(38463);
            return;
        }
        Log.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo onScroll firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i2 == 0) {
            float ratio = getRatio();
            if (this.QdE == 0.0f || this.QdE == 1.0f || ((double) Math.abs(ratio - this.QdE)) >= 0.01d) {
                this.QdE = ratio;
                if (this.Qdm != null) {
                    if (this.Qdm.getTop() == 0 && !this.QdD) {
                        ratio = 0.0f;
                    } else if (this.Qdm.getTop() != 0) {
                        this.QdD = true;
                    }
                }
                if (this.QdF != null) {
                    int aW = this.QdF.aW(ratio);
                    if (this.nYR != null) {
                        this.nYR.setColor(aW);
                    }
                    if (this.Qdn != null) {
                        this.Qdn.setBackgroundColor(aW);
                    }
                }
            }
            Cx(false);
            View childAt = absListView.getChildAt(0);
            if (childAt != null && (childAt instanceof HeaderContainer)) {
                View findViewById = childAt.findViewById(R.id.tc);
                if (findViewById == null || findViewById.getVisibility() == 8) {
                    AppMethodBeat.o(38463);
                    return;
                }
                GyroView gyroView = ((HeaderContainer) childAt).getGyroView();
                Log.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo appBrandHeaderTransH: %s, emptyTransH: %s, headerParent.bottom: %s, translationY: %f, mAppBrandHeight: %d", Float.valueOf(this.Qdx), Float.valueOf(this.Qdy), Integer.valueOf(childAt.getBottom()), Float.valueOf(findViewById.getTranslationY()), Integer.valueOf(this.QdN));
                if (childAt.getBottom() <= 3) {
                    if (!this.dLH) {
                        findViewById.setTranslationY(this.Qdx);
                    } else {
                        if (this.GQ != null) {
                            this.GQ.setTranslationY(this.Qdy);
                        }
                        findViewById.setTranslationY(0.0f);
                    }
                    if (gyroView.getVisibility() == 0) {
                        gyroView.setVerticalScroll(0.0f);
                        gyroView.setVisibility(8);
                    }
                    this.QdY = false;
                }
                if (childAt.getBottom() > 3 && ((float) childAt.getBottom()) <= this.FSk && (findViewById.getTranslationY() != 0.0f || (this.GQ != null && this.GQ.getTranslationY() != 0.0f))) {
                    if (gyroView.getVisibility() == 8) {
                        gyroView.setVisibility(0);
                    }
                    gyroView.setAlpha(1.0f);
                    gyroView.setTranslationY((float) (((-childAt.getBottom()) / 2) + (gyroView.getHeight() / 2)));
                    gyroView.setVerticalScroll((float) childAt.getBottom());
                } else if (((float) childAt.getBottom()) > this.FSk && !(findViewById.getTranslationY() == 0.0f && (this.GQ == null || this.GQ.getTranslationY() == 0.0f))) {
                    float bottom = (float) ((1.0d * ((double) (((float) childAt.getBottom()) - this.FSk))) / ((double) (((float) this.QdN) - this.FSk)));
                    Log.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo checkUpAppBrandHeader appbrandHeader translationY: %f, percent: %f, setTranslationY: %f, isEmpty: %b", Float.valueOf(findViewById.getTranslationY()), Float.valueOf(bottom), Float.valueOf(this.Qdx * (1.0f - bottom)), Boolean.valueOf(this.dLH));
                    if (!this.dLH) {
                        findViewById.setTranslationY(this.Qdx * (1.0f - bottom));
                    } else {
                        if (this.GQ != null) {
                            Log.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo emptyView translationY: %f, set: %f", Float.valueOf(this.GQ.getTranslationY()), Float.valueOf((-this.Qdy) * (1.0f - bottom)));
                            this.GQ.setTranslationY(this.Qdy * (1.0f - bottom));
                        }
                        findViewById.setTranslationY(0.0f);
                    }
                    gyroView.setTranslationY(((-this.FSk) / 2.0f) + ((float) (gyroView.getHeight() / 2)) + (((this.FSk / 2.0f) + ((float) gyroView.getHeight())) * bottom));
                    gyroView.setAlpha(1.0f - (2.0f * bottom));
                    if (!this.QdY && 1.0f != bottom) {
                        this.ooM.vibrate(10);
                        this.QdY = true;
                    }
                    Cx(true);
                }
            }
        } else {
            if (this.Qdm != null) {
                View findViewById2 = this.Qdm.findViewById(R.id.tc);
                if (this.dLH) {
                    if (this.GQ != null) {
                        this.GQ.setTranslationY(this.Qdy);
                    }
                    if (findViewById2 != null) {
                        findViewById2.setTranslationY(0.0f);
                    }
                } else if (findViewById2 != null) {
                    findViewById2.setTranslationY(this.Qdx);
                }
            }
            if (this.QdZ == 0 && i2 != 0) {
                anO(4);
                Cy(true);
                Cx(true);
            }
        }
        this.QdZ = i2;
        if (this.QdX && this.xbw && i2 == 0) {
            Log.e("MicroMsg.ConversationWithAppBrandListView", "[Stop fling!]");
            smoothScrollBy(0, 0);
            post(new Runnable() {
                /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass18 */

                public final void run() {
                    AppMethodBeat.i(38414);
                    View childAt = ConversationWithAppBrandListView.this.getChildAt(0);
                    Log.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollBy] offset: ".concat(String.valueOf(childAt == null ? 0 : childAt.getBottom())));
                    ConversationWithAppBrandListView.this.smoothScrollToPositionFromTop(ConversationWithAppBrandListView.this.getFirstHeaderVisible(), 0, 300);
                    ConversationWithAppBrandListView.m(ConversationWithAppBrandListView.this);
                    AppMethodBeat.o(38414);
                }
            });
            this.QdX = false;
        }
        MMHandlerThread.removeRunnable(this.QdW);
        MMHandlerThread.postToMainThreadDelayed(this.QdW, 50);
        AppMethodBeat.o(38463);
    }

    private float anP(int i2) {
        AppMethodBeat.i(38464);
        Log.d("MicroMsg.ConversationWithAppBrandListView", "[isFull] totalItemCount:" + i2 + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount());
        int headerViewsCount = (i2 - getHeaderViewsCount()) - getFooterViewsCount();
        float measuredHeight = (float) (getMeasuredHeight() - (((int) getResources().getDimension(R.dimen.iq)) * headerViewsCount));
        Log.i("MicroMsg.ConversationWithAppBrandListView", "[isFull] height:%s rawCount:%s extraHeight:%s", Integer.valueOf(getHeight()), Integer.valueOf(headerViewsCount), Float.valueOf(measuredHeight));
        AppMethodBeat.o(38464);
        return measuredHeight;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s", java.lang.Integer.valueOf(r2));
        com.tencent.matrix.trace.core.AppMethodBeat.o(38465);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getFirstHeaderVisible() {
        /*
        // Method dump skipped, instructions count: 143
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.getFirstHeaderVisible():int");
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        a() {
        }

        public final void run() {
            AppMethodBeat.i(38421);
            View childAt = ConversationWithAppBrandListView.this.getChildAt(0);
            if (ConversationWithAppBrandListView.this.getFirstVisiblePosition() == 0 && childAt != null) {
                if (childAt.getTop() >= 0) {
                    AppMethodBeat.o(38421);
                    return;
                }
                Log.i("MicroMsg.ConversationWithAppBrandListView", "[UpAppBrandHeaderTask] run...");
                if (((float) childAt.getBottom()) >= ConversationWithAppBrandListView.this.FSk) {
                    ConversationWithAppBrandListView.o(ConversationWithAppBrandListView.this);
                    AppMethodBeat.o(38421);
                    return;
                }
                ConversationWithAppBrandListView.p(ConversationWithAppBrandListView.this);
            }
            AppMethodBeat.o(38421);
        }
    }

    private boolean CA(boolean z) {
        AppMethodBeat.i(38466);
        if ((!this.hasInit || !z) && com.tencent.mm.kernel.g.af(l.class) != null) {
            com.tencent.mm.kernel.g.af(l.class);
            this.Qdp = true;
            Log.i("MicroMsg.ConversationWithAppBrandListView", "[isAppBrandHeaderEnable] :%s", Boolean.valueOf(this.Qdp));
            this.hasInit = true;
        }
        boolean z2 = this.Qdp;
        AppMethodBeat.o(38466);
        return z2;
    }

    private boolean gVK() {
        AppMethodBeat.i(38467);
        if (this.Qdn == null) {
            AppMethodBeat.o(38467);
            return false;
        } else if (!CA(true) || this.Qdn.getVisibility() != 0) {
            AppMethodBeat.o(38467);
            return false;
        } else {
            AppMethodBeat.o(38467);
            return true;
        }
    }

    @Override // android.widget.AbsListView, android.widget.ListView
    public void setAdapter(final ListAdapter listAdapter) {
        AppMethodBeat.i(38423);
        Log.i("MicroMsg.ConversationWithAppBrandListView", "[init] ");
        this.QdL.alive();
        this.ooM = (Vibrator) getContext().getSystemService("vibrator");
        this.mTouchSlop = v.a(ViewConfiguration.get(getContext()));
        this.nYR = new Paint(1);
        this.Qdq = new Paint(1);
        this.nYR.setColor(getResources().getColor(R.color.dt));
        this.Qdq.setColor(Integer.MIN_VALUE);
        this.Qdq.setTextSize(getResources().getDimension(R.dimen.kc));
        CA(false);
        if (com.tencent.mm.kernel.g.af(l.class) != null) {
            this.Qdr = ((l) com.tencent.mm.kernel.g.af(l.class)).ccW();
        }
        this.FSk = 100.0f * getResources().getDisplayMetrics().density;
        Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo init mAnimationPadding: %f, density: %f", Float.valueOf(this.FSk), Float.valueOf(getResources().getDisplayMetrics().density));
        this.Qds = getResources().getString(R.string.biy);
        this.Qdt = this.Qdq.measureText(this.Qds);
        super.setOnScrollListener(this);
        listAdapter.registerDataSetObserver(new DataSetObserver() {
            /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass11 */
            int Qec = -1;

            public final void onChanged() {
                AppMethodBeat.i(38406);
                if (this.Qec != listAdapter.getCount()) {
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(this.Qec > listAdapter.getCount());
                    Log.i("MicroMsg.ConversationWithAppBrandListView", "[onChanged] isDelete:%s", objArr);
                    if (this.Qec > listAdapter.getCount()) {
                        ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, false);
                        ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, true);
                    } else {
                        ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this);
                    }
                }
                this.Qec = listAdapter.getCount();
                AppMethodBeat.o(38406);
            }
        });
        try {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.topMargin = au.eu(getContext());
            Log.i("MicroMsg.ConversationWithAppBrandListView", "[initLayoutParams]1 ActionBar height:%s", Integer.valueOf(layoutParams.topMargin));
            if (layoutParams.topMargin <= 0) {
                postDelayed(new Runnable() {
                    /* class com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass19 */

                    public final void run() {
                        AppMethodBeat.i(38415);
                        layoutParams.topMargin = au.eu(ConversationWithAppBrandListView.this.getContext());
                        Log.i("MicroMsg.ConversationWithAppBrandListView", "[initLayoutParams]2 ActionBar height:%s", Integer.valueOf(layoutParams.topMargin));
                        AppMethodBeat.o(38415);
                    }
                }, 200);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ConversationWithAppBrandListView", e2, "alvinluo initLayoutParams exception", new Object[0]);
        }
        if (this.Dpx != null) {
            gVG();
        }
        addFooterView(getEmptyFooter());
        super.setAdapter(listAdapter);
        AppMethodBeat.o(38423);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        AppMethodBeat.i(38447);
        if (!CA(true) || getFirstVisiblePosition() != 0 || i3 >= 0) {
            boolean dispatchNestedPreScroll = super.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
            AppMethodBeat.o(38447);
            return dispatchNestedPreScroll;
        }
        iArr[1] = (int) (((float) i3) / 3.0f);
        super.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
        AppMethodBeat.o(38447);
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(38449);
        if (!CA(true)) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(38449);
            return onTouchEvent;
        }
        if (motionEvent.getAction() == 0) {
            if (getFirstVisiblePosition() != 0) {
                this.QdX = true;
            }
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && getFirstVisiblePosition() == 0) {
            View childAt = getChildAt(0);
            if (childAt == null) {
                AppMethodBeat.o(38449);
                return true;
            }
            if (Math.abs(motionEvent.getX() - this.riK) < 3.0f && Math.abs(motionEvent.getY() - this.riL) < 3.0f) {
                super.onTouchEvent(motionEvent);
            }
            if (getChildTranslationY() < 60.0f * getResources().getDisplayMetrics().density) {
                float abs = Math.abs(motionEvent.getX() - this.CBd) - Math.abs(motionEvent.getY() - this.onW);
                if ((motionEvent.getY() - this.onW < -5.0f && abs < 0.0f && getFirstVisiblePosition() == 0) || (childAt.getBottom() > 0 && ((float) childAt.getBottom()) < this.FSk)) {
                    anO(4);
                } else if (((float) childAt.getBottom()) >= this.FSk && motionEvent.getY() - this.onW > 5.0f) {
                    gVH();
                }
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            Cx(true);
            this.QdQ = false;
            if (getChildTranslationY() > 0.0f) {
                gVH();
            }
        }
        if (!aj(motionEvent)) {
            if (this.QdQ && motionEvent.getAction() == 2) {
                motionEvent.setAction(0);
                super.onTouchEvent(motionEvent);
                motionEvent.setAction(2);
                this.QdQ = false;
            }
            boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(38449);
            return onTouchEvent2;
        }
        if (motionEvent.getAction() == 0) {
            super.onTouchEvent(motionEvent);
        } else if (motionEvent.getAction() == 2 && !this.QdQ && Math.abs(motionEvent.getY() - this.riL) > 2.0f) {
            motionEvent.setAction(3);
            super.onTouchEvent(motionEvent);
            this.QdQ = true;
        } else if (!this.QdQ) {
            super.onTouchEvent(motionEvent);
        }
        AppMethodBeat.o(38449);
        return true;
    }

    static /* synthetic */ void a(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(38470);
        conversationWithAppBrandListView.Cw(true);
        AppMethodBeat.o(38470);
    }

    static /* synthetic */ boolean b(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(38471);
        boolean CA = conversationWithAppBrandListView.CA(true);
        AppMethodBeat.o(38471);
        return CA;
    }

    static /* synthetic */ void a(ConversationWithAppBrandListView conversationWithAppBrandListView, int i2) {
        AppMethodBeat.i(38474);
        Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onRefreshDone size:%s isAppBrandHeaderEnable:%s", Integer.valueOf(i2), Boolean.valueOf(conversationWithAppBrandListView.Qdp));
        if (!conversationWithAppBrandListView.CA(true)) {
            Log.w("MicroMsg.ConversationWithAppBrandListView", "[onDone] is disable!");
            if (conversationWithAppBrandListView.Qdn != null) {
                conversationWithAppBrandListView.Qdn.setVisibility(8);
            }
            AppMethodBeat.o(38474);
            return;
        }
        if (!(conversationWithAppBrandListView.Qdn == null || conversationWithAppBrandListView.Qdn.getVisibility() == 0)) {
            conversationWithAppBrandListView.Qdn.setVisibility(0);
            conversationWithAppBrandListView.setSelection(conversationWithAppBrandListView.getFirstVisiblePosition());
        }
        if (!conversationWithAppBrandListView.Qdw || !conversationWithAppBrandListView.Qdv) {
            conversationWithAppBrandListView.dLH = false;
        } else {
            conversationWithAppBrandListView.dLH = true;
        }
        Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onRefreshDone isEmpty: %b", Boolean.valueOf(conversationWithAppBrandListView.dLH));
        AppMethodBeat.o(38474);
    }

    static /* synthetic */ void o(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(38479);
        conversationWithAppBrandListView.gVH();
        AppMethodBeat.o(38479);
    }
}
