package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.PowerManager;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.p;
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.a;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.g.a.xj;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.AbstractTabChildActivity;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.conversation.i;
import com.tencent.mm.ui.conversation.k;
import com.tencent.mm.ui.f;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.Executor;

public class MainUI extends AbstractTabChildActivity.AbStractTabFragment implements k.a {
    public MMFragmentActivity Dpx;
    private View FSz;
    private i Qct;
    public ConversationListView QfG;
    private View QfH;
    private View QfI;
    private TextView QfJ;
    private k QfK = new k();
    private p QfL = new p();
    private n QfM = new n();
    public com.tencent.mm.plugin.taskbar.api.a QfN;
    private com.tencent.mm.ui.k.a QfO;
    private IListener QfP;
    IListener QfQ;
    private a QfR;
    private a Qfu = new a();
    private boolean dSv;
    private View jBN;
    private int[] tef = new int[2];

    public MainUI() {
        AppMethodBeat.i(38633);
        Log.i("MicroMsg.MainUI", "create mainUI");
        this.QfO = new com.tencent.mm.ui.k.a() {
            /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.k.a
            public final void onFragmentVisibilityChanged(boolean z) {
                AppMethodBeat.i(38619);
                if (MainUI.this.QfG != null) {
                    d dVar = d.QbK;
                    d.Cu(z);
                    ConversationListView conversationListView = MainUI.this.QfG;
                    if (conversationListView.dSv) {
                        Log.i("MicroMsg.ConversationListView", "alvinluo onFragmentVisibilityChanged visible: %b", Boolean.valueOf(z));
                        conversationListView.gVu();
                    }
                    d dVar2 = d.QbK;
                    d.a(MainUI.this.QfG, MainUI.this.Qct, z, false);
                }
                AppMethodBeat.o(38619);
            }
        };
        this.QfP = new IListener<ri>() {
            /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass9 */

            {
                AppMethodBeat.i(234183);
                this.__eventId = ri.class.getName().hashCode();
                AppMethodBeat.o(234183);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ri riVar) {
                AppMethodBeat.i(234184);
                if (MainUI.this.Qct != null) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass9.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(234182);
                            Log.d("MicroMsg.MainUI", "refresh main ui unread count.");
                            MainUI.this.Qct.notifyDataSetChanged();
                            LauncherUI.getInstance().ODR.getMainTabUI().gJe();
                            AppMethodBeat.o(234182);
                        }
                    });
                }
                AppMethodBeat.o(234184);
                return true;
            }
        };
        this.QfQ = new IListener<mh>() {
            /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass10 */
            private final long INTERVAL = 3000;
            private long QfV = 0;
            private int QfW = -1;
            private int QfX = 0;

            {
                AppMethodBeat.i(234186);
                this.__eventId = mh.class.getName().hashCode();
                AppMethodBeat.o(234186);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(mh mhVar) {
                AppMethodBeat.i(234187);
                final mh mhVar2 = mhVar;
                Log.d("MicroMsg.MainUI", "trigger double tab");
                MainUI.this.QfG.postDelayed(new Runnable() {
                    /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass10.AnonymousClass2 */

                    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
                    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081  */
                    /* JADX WARNING: Removed duplicated region for block: B:28:0x009a  */
                    /* JADX WARNING: Removed duplicated region for block: B:39:0x0119  */
                    /* JADX WARNING: Removed duplicated region for block: B:40:0x012d  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                        // Method dump skipped, instructions count: 413
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.conversation.MainUI.AnonymousClass10.AnonymousClass2.run():void");
                    }
                }, 100);
                AppMethodBeat.o(234187);
                return false;
            }

            static /* synthetic */ void a(AnonymousClass10 r12, final int i2) {
                AppMethodBeat.i(234188);
                final int firstVisiblePosition = MainUI.this.QfG.getFirstVisiblePosition();
                ConversationListView conversationListView = MainUI.this.QfG;
                com.tencent.mm.hellhoundlib.b.a a2 = c.a(i2, c.a(0, new com.tencent.mm.hellhoundlib.b.a()));
                com.tencent.mm.hellhoundlib.a.a.a(conversationListView, a2.axQ(), "com/tencent/mm/ui/conversation/MainUI$3", "scrollToFromTop", "(I)V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                conversationListView.smoothScrollToPositionFromTop(((Integer) a2.pG(0)).intValue(), ((Integer) a2.pG(1)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(conversationListView, "com/tencent/mm/ui/conversation/MainUI$3", "scrollToFromTop", "(I)V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                r12.QfX = i2;
                MainUI.this.QfG.postOnAnimationDelayed(new Runnable() {
                    /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass10.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(38624);
                        if (firstVisiblePosition == i2 || AnonymousClass10.this.QfX != i2) {
                            AppMethodBeat.o(38624);
                            return;
                        }
                        int firstVisiblePosition = MainUI.this.QfG.getFirstVisiblePosition();
                        if (firstVisiblePosition == firstVisiblePosition && Math.abs(i2 - firstVisiblePosition) > 2) {
                            MainUI.this.QfG.setSelection(i2);
                        } else if (Math.abs(firstVisiblePosition - i2) > 2) {
                            ConversationListView conversationListView = MainUI.this.QfG;
                            com.tencent.mm.hellhoundlib.b.a a2 = c.a(i2, c.a(0, new com.tencent.mm.hellhoundlib.b.a()));
                            com.tencent.mm.hellhoundlib.a.a.a(conversationListView, a2.axQ(), "com/tencent/mm/ui/conversation/MainUI$3$1", "run", "()V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                            conversationListView.smoothScrollToPositionFromTop(((Integer) a2.pG(0)).intValue(), ((Integer) a2.pG(1)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(conversationListView, "com/tencent/mm/ui/conversation/MainUI$3$1", "run", "()V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                        }
                        Log.i("MicroMsg.MainUI", "auto pos result:%d, %d, %d", Integer.valueOf(firstVisiblePosition), Integer.valueOf(i2), Integer.valueOf(firstVisiblePosition));
                        AppMethodBeat.o(38624);
                    }
                }, 250);
                AppMethodBeat.o(234188);
            }
        };
        this.jBN = null;
        this.dSv = false;
        AppMethodBeat.o(38633);
    }

    static /* synthetic */ void a(MainUI mainUI, int i2, int i3) {
        AppMethodBeat.i(234198);
        mainUI.lo(i2, i3);
        AppMethodBeat.o(234198);
    }

    @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment, com.tencent.mm.ui.MMFragment
    public int getLayoutId() {
        return R.layout.b4z;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public View getLayoutView() {
        AppMethodBeat.i(38634);
        b.aBh();
        this.jBN = b.c(getContext(), R.layout.b4z);
        View view = this.jBN;
        AppMethodBeat.o(38634);
        return view;
    }

    @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment, com.tencent.mm.ui.MMFragment
    public boolean supportNavigationSwipeBack() {
        return false;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public boolean noActionBar() {
        return true;
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment, com.tencent.mm.ui.MMFragment
    public void onResume() {
        AppMethodBeat.i(38635);
        Log.i("MicroMsg.MainUI", "onResume");
        super.onResume();
        if (this.QfG != null) {
            ConversationListView conversationListView = this.QfG;
            if (conversationListView.Qcv && conversationListView.onh != null) {
                conversationListView.onh.onResume();
            }
            if (conversationListView.Qcv && conversationListView.Qcx != null && conversationListView.Qcx.fuw() && conversationListView.onh != null && conversationListView.onh.getBottom() < com.tencent.mm.cb.a.fromDPToPix(conversationListView.getContext(), 100)) {
                if (ao.isDarkMode()) {
                    conversationListView.ln(conversationListView.getResources().getColor(R.color.ko), conversationListView.getResources().getColor(R.color.bw));
                } else {
                    conversationListView.ln(conversationListView.getResources().getColor(R.color.a2r), conversationListView.getResources().getColor(R.color.bv));
                }
            }
            if (conversationListView.Qcv && conversationListView.Qcx != null) {
                conversationListView.Qcx.onResume();
            }
            conversationListView.cau();
            conversationListView.Cv(true);
        }
        AppMethodBeat.o(38635);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment, com.tencent.mm.ui.MMFragment
    public void onPause() {
        AppMethodBeat.i(38636);
        Log.i("MicroMsg.MainUI", "onPause");
        super.onPause();
        if (this.QfG != null) {
            ConversationListView conversationListView = this.QfG;
            if (conversationListView.Qcv && conversationListView.onh != null) {
                conversationListView.onh.onPause();
            }
        }
        AppMethodBeat.o(38636);
    }

    private void lo(int i2, int i3) {
        AppMethodBeat.i(234196);
        Log.i("MicroMsg.MainUI", "alvinluo setListMargin isInMultiWindowMode: %b", Boolean.valueOf(this.dSv));
        ViewGroup.LayoutParams layoutParams = this.QfG.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            int i4 = ((RelativeLayout.LayoutParams) layoutParams).topMargin;
            Log.i("MicroMsg.MainUI", "alvinluo setListMargin origin: %d, topMargin: %d", Integer.valueOf(i4), Integer.valueOf(i2));
            if (i4 <= 0 || this.dSv) {
                if (!this.dSv) {
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = i2;
                } else {
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = 0;
                }
                this.QfG.setLayoutParams(layoutParams);
            }
        }
        if (this.FSz != null) {
            int i5 = this.FSz.getLayoutParams().height;
            Log.i("MicroMsg.MainUI", "alvinluo setStatusBarMaskView height origin: %d, new: %d", Integer.valueOf(i5), Integer.valueOf(i3));
            if (i5 <= 0 || this.dSv) {
                if (!this.dSv) {
                    this.FSz.getLayoutParams().height = i3;
                    AppMethodBeat.o(234196);
                    return;
                }
                this.FSz.getLayoutParams().height = 0;
            }
        }
        AppMethodBeat.o(234196);
    }

    public final void q(boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(38638);
        if (this.QfG instanceof ConversationListView) {
            this.QfG.q(z, z2, z3);
            AppMethodBeat.o(38638);
            return;
        }
        this.QfR = new a(z, z2, z3);
        AppMethodBeat.o(38638);
    }

    /* access modifiers changed from: package-private */
    public class a {
        boolean Qgc;
        boolean dEF;
        boolean jLE;

        public a(boolean z, boolean z2, boolean z3) {
            this.dEF = z;
            this.jLE = z2;
            this.Qgc = z3;
        }
    }

    public final void gUq() {
        AppMethodBeat.i(38639);
        if (this.Qct != null) {
            this.Qct.gUq();
        }
        AppMethodBeat.o(38639);
    }

    @Override // android.support.v4.app.Fragment
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(38640);
        super.onConfigurationChanged(configuration);
        this.Qfu.gVm();
        AppMethodBeat.o(38640);
    }

    @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
    public final void gGu() {
        AppMethodBeat.i(38641);
        Log.i("MicroMsg.MainUI", "onTabCreate, %d", Integer.valueOf(hashCode()));
        if (this.mController != null) {
            this.mController.bF(4, false);
        }
        Log.i("MicroMsg.MainUI", "mainUIOnCreate");
        long currentTimeMillis = System.currentTimeMillis();
        setMenuVisibility(true);
        bg.aAk().setLowPriority();
        Log.i("MicroMsg.MainUI", "main ui init view");
        if (this.QfG != null) {
            a aVar = this.Qfu;
            if (aVar.Qbd != null) {
                aVar.jR(aVar.QaV);
                aVar.jR(aVar.QaW);
                aVar.jR(aVar.QaX);
                aVar.jR(aVar.QaY);
                for (com.tencent.mm.pluginsdk.ui.b.b bVar : aVar.QaZ) {
                    if (!(bVar == null || bVar.getView() == null)) {
                        aVar.Qbd.removeFooterView(bVar.getView());
                    }
                }
            }
        }
        this.QfJ = (TextView) findViewById(R.id.c2q);
        this.QfG = (ConversationListView) findViewById(R.id.f67);
        ConversationListView conversationListView = this.QfG;
        if (!bg.aAc() || !g.aAf().hpY) {
            Log.i("MicroMsg.ConversationListView", "account not initialized, add callback");
            g.aAi().a(conversationListView.VlV);
        } else {
            Log.i("MicroMsg.ConversationListView", "account initialized, initHeaderContainer");
            conversationListView.kq(conversationListView.getContext());
        }
        this.FSz = findViewById(R.id.i58);
        this.QfG.setStatusBarMaskView(this.FSz);
        if (this.QfG != null) {
            final boolean showHeaderContainer = this.QfG.getShowHeaderContainer();
            int D = au.D(getContext(), -1);
            int eu = h.eu(this.QfG.getContext());
            Log.i("MicroMsg.MainUI", "alvinluo initListViewPadding actionBarHeight: %d, statusBarHeight: %d, showHeadrContainer: %b", Integer.valueOf(eu), Integer.valueOf(D), Boolean.valueOf(showHeaderContainer));
            AnonymousClass2 r3 = new Runnable() {
                /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass2 */
                int ibG = 0;

                public final void run() {
                    AppMethodBeat.i(38620);
                    if (MainUI.this.QfG == null) {
                        AppMethodBeat.o(38620);
                        return;
                    }
                    int D = au.D(MainUI.this.getContext(), -1);
                    int eu = h.eu(MainUI.this.QfG.getContext());
                    if (D <= 0 || eu <= 0) {
                        if (this.ibG < 2) {
                            Log.i("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight again!");
                            MainUI.this.QfG.post(this);
                        } else {
                            Log.e("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight finally!");
                        }
                        this.ibG++;
                    } else if (D != MainUI.this.QfG.getPaddingTop()) {
                        Log.i("MicroMsg.MainUI", "[initListViewPadding] now:%s old:%s", Integer.valueOf(D), Integer.valueOf(MainUI.this.QfG.getPaddingTop()));
                        MainUI mainUI = MainUI.this;
                        if (showHeaderContainer) {
                            eu = 0;
                        }
                        MainUI.a(mainUI, eu, D);
                    } else {
                        Log.i("MicroMsg.MainUI", "[trySetListViewMargin] has try more once! it's right! statusHeight:%s", Integer.valueOf(D));
                    }
                    Log.i("MicroMsg.MainUI", "[trySetListViewMargin] tryCount:%s statusHeight:%s", Integer.valueOf(this.ibG), Integer.valueOf(D));
                    AppMethodBeat.o(38620);
                }
            };
            if (D <= 0) {
                this.QfG.post(r3);
            } else {
                lo(showHeaderContainer ? 0 : eu, D);
                Log.i("MicroMsg.MainUI", "[trySetListViewMargin] statusHeight: %s, actionBarHeight: %d", Integer.valueOf(D), Integer.valueOf(eu));
                this.QfG.postDelayed(r3, 100);
            }
        }
        this.QfH = new DynamicBgContainer(getContext());
        ((ViewGroup) this.jBN).addView(this.QfH, 0, new ViewGroup.LayoutParams(-1, -1));
        this.QfG.setDrawingCacheEnabled(false);
        this.QfG.setScrollingCacheEnabled(false);
        this.QfI = findViewById(R.id.no);
        ConversationListView conversationListView2 = this.QfG;
        View view = this.QfH;
        View view2 = this.QfI;
        conversationListView2.QcS = view;
        if (conversationListView2.onh != null) {
            conversationListView2.onh.o(view, view2);
        }
        this.Qct = new i(getContext(), this.QfG, new f.a() {
            /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass12 */

            @Override // com.tencent.mm.ui.f.a
            public final void gHg() {
                AppMethodBeat.i(234191);
                com.tencent.mm.plugin.report.service.g.Wl(12);
                AppMethodBeat.o(234191);
            }

            @Override // com.tencent.mm.ui.f.a
            public final void bnE() {
                AppMethodBeat.i(234192);
                if (MainUI.this.Qct != null) {
                    i iVar = MainUI.this.Qct;
                    if (!(iVar.Pax == null || iVar.Qep == null || iVar.Qep.isEmpty())) {
                        if (iVar.Qeq) {
                            iVar.Pax.clear();
                            iVar.Qeq = false;
                        } else {
                            Log.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", Integer.valueOf(iVar.Qep.size()));
                            Iterator<String> it = iVar.Qep.iterator();
                            while (it.hasNext()) {
                                iVar.Pax.remove(it.next());
                            }
                        }
                        iVar.Qep.clear();
                    }
                }
                MainUI.this.QfG.post(new Runnable() {
                    /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass12.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(234190);
                        try {
                            LauncherUI.getInstance().ODR.getMainTabUI().gJe();
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.MainUI", e2, "report unread", new Object[0]);
                        }
                        MainUI.a(MainUI.this, MainUI.this.Qct.getCount());
                        if (MainUI.this.Qct.getCount() <= 0 && MainUI.this.QfG != null) {
                            ConversationListView conversationListView = MainUI.this.QfG;
                            Log.i("MicroMsg.ConversationListView", "alvinluo refreshFooter mHeaderOpen: %b", Boolean.valueOf(conversationListView.FSV));
                            if (!conversationListView.FSV) {
                                conversationListView.Cw(false);
                                if (conversationListView.Qda != null) {
                                    conversationListView.Qda.setBackgroundColor(conversationListView.getContext().getResources().getColor(R.color.f3045c));
                                }
                                if (ao.isDarkMode()) {
                                    conversationListView.ln(conversationListView.getResources().getColor(R.color.ko), conversationListView.getResources().getColor(R.color.bw));
                                } else {
                                    conversationListView.ln(conversationListView.getResources().getColor(R.color.a2r), conversationListView.getResources().getColor(R.color.bv));
                                }
                            }
                        }
                        MainUI.this.Qfu.gVm();
                        com.tencent.mm.plugin.report.service.g.Wm(12);
                        AppMethodBeat.o(234190);
                    }
                });
                AppMethodBeat.o(234192);
            }
        });
        bg.aVF();
        com.tencent.mm.model.c.aST().add(this.Qct);
        this.Qct.setGetViewPositionCallback(new MMSlideDelView.c() {
            /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass13 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.c
            public final int dr(View view) {
                AppMethodBeat.i(234193);
                int positionForView = MainUI.this.QfG.getPositionForView(view);
                AppMethodBeat.o(234193);
                return positionForView;
            }
        });
        this.Qct.setPerformItemClickListener(new MMSlideDelView.g() {
            /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass14 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.g
            public final void r(View view, int i2, int i3) {
                AppMethodBeat.i(234194);
                MainUI.this.QfG.performItemClick(view, i2, (long) i3);
                AppMethodBeat.o(234194);
            }
        });
        if (d.oF(18)) {
            com.tencent.mm.blink.b.ake().arrange(new Runnable() {
                /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass15 */

                public final void run() {
                    AppMethodBeat.i(38631);
                    MainUI.this.Qfu.a(MainUI.this.getContext(), MainUI.this.QfG, MainUI.this.QfJ);
                    AppMethodBeat.o(38631);
                }
            });
        } else {
            this.Qfu.a(getContext(), this.QfG, this.QfJ);
        }
        n nVar = this.QfM;
        ConversationListView conversationListView3 = this.QfG;
        i iVar = this.Qct;
        nVar.Qbd = conversationListView3;
        nVar.Qct = iVar;
        conversationListView3.setOnScrollListener(nVar.gup);
        iVar.QbN = nVar.gup;
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.conversation.n.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(38704);
                n.a(n.this, 0);
                AppMethodBeat.o(38704);
            }
        });
        LauncherUI.getInstance().ODR.getMainTabUI().gJe();
        this.QfG.setAdapter((ListAdapter) this.Qct);
        this.QfG.setOnItemClickListener(new f(this.Qct, this.QfG, getActivity()));
        this.QfG.setOnItemLongClickListener(new g(this.Qct, this.QfG, getActivity(), this.tef));
        this.QfG.setonDispatchTouchEventListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass16 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(234195);
                switch (motionEvent.getAction()) {
                    case 0:
                        MainUI.this.hideVKB();
                        MainUI.this.tef[0] = (int) motionEvent.getRawX();
                        MainUI.this.tef[1] = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.o(234195);
                return false;
            }
        });
        if (this.QfN != null) {
            this.QfG.setActionBarUpdateCallback(this.QfN);
        }
        if (this.Dpx != null) {
            this.QfG.setActivity(this.Dpx);
        }
        if (this.QfR != null) {
            q(this.QfR.dEF, this.QfR.jLE, this.QfR.Qgc);
        }
        this.QfG.setSelection(0);
        k kVar = this.QfK;
        FragmentActivity activity = getActivity();
        a aVar2 = this.Qfu;
        Log.i("MicroMsg.InitHelper", "onCreate %s", Integer.valueOf(activity.hashCode()));
        kVar.dKq = activity;
        kVar.Qfu = aVar2;
        kVar.Qfv = this;
        kVar.kRw = new WeakReference<>(activity);
        kVar.wakeLock = ((PowerManager) MMApplicationContext.getContext().getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
        bg.azz().a(-1, kVar);
        kVar.Qfr = false;
        EventCenter.instance.addListener(kVar.Qfw);
        EventCenter.instance.addListener(kVar.Qfx);
        o oVar = new o(MMApplicationContext.getContext().getFilesDir(), "DBRecoverStarted");
        if (oVar.exists()) {
            e.INSTANCE.e("DBRepair", "Last recovery interrupted.", null);
            oVar.delete();
        }
        kVar.Qfy = new FLock(s.k(aa.z(new o(MMApplicationContext.getContext().getFilesDir(), "MMStarted").mUri), true), true);
        if (kVar.Qfy.tryLockWrite()) {
            kVar.Qfy.unlock();
            Log.i("MicroMsg.DuplicateDetect", "No data multiple instance detected.");
        } else {
            Log.w("MicroMsg.DuplicateDetect", "Data multiple instance detected.");
            e.INSTANCE.idkeyStat(579, 0, 1, true);
        }
        kVar.Qfy.lockRead();
        p pVar = this.QfL;
        i iVar2 = this.Qct;
        ConversationListView conversationListView4 = this.QfG;
        FragmentActivity activity2 = getActivity();
        pVar.Qct = iVar2;
        pVar.dKq = activity2;
        pVar.QfG = conversationListView4;
        if (pVar.qZo == null) {
            pVar.qZo = new IListener<ql>(new MMHandler() {
                /* class com.tencent.mm.ui.conversation.p.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MMHandler
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(38721);
                    if (p.this.Qct != null) {
                        p.this.Qct.clearCache();
                        p.this.Qct.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(38721);
                }
            }) {
                /* class com.tencent.mm.ui.conversation.p.AnonymousClass3 */
                final /* synthetic */ MMHandler Qhe;

                {
                    this.Qhe = r4;
                    AppMethodBeat.i(161574);
                    this.__eventId = ql.class.getName().hashCode();
                    AppMethodBeat.o(161574);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(ql qlVar) {
                    AppMethodBeat.i(38723);
                    this.Qhe.sendEmptyMessage(0);
                    AppMethodBeat.o(38723);
                    return false;
                }
            };
        }
        if (pVar.Qhb == null) {
            pVar.Qhb = new IListener<rh>() {
                /* class com.tencent.mm.ui.conversation.p.AnonymousClass4 */

                {
                    AppMethodBeat.i(161575);
                    this.__eventId = rh.class.getName().hashCode();
                    AppMethodBeat.o(161575);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(rh rhVar) {
                    AppMethodBeat.i(38725);
                    if (p.this.Qct != null) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.ui.conversation.p.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(38724);
                                Log.d("MicroMsg.RefreshHelper", "refresh main ui multitalk icon.");
                                if (p.this.Qct != null) {
                                    p.this.Qct.notifyDataSetChanged();
                                }
                                AppMethodBeat.o(38724);
                            }
                        });
                    }
                    AppMethodBeat.o(38725);
                    return true;
                }
            };
        }
        if (pVar.Qhc == null) {
            pVar.Qhc = new IListener<mf>(conversationListView4) {
                /* class com.tencent.mm.ui.conversation.p.AnonymousClass5 */
                final /* synthetic */ ConversationListView Qhg;

                {
                    this.Qhg = r4;
                    AppMethodBeat.i(161576);
                    this.__eventId = mf.class.getName().hashCode();
                    AppMethodBeat.o(161576);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(mf mfVar) {
                    AppMethodBeat.i(38726);
                    if (this.Qhg != null) {
                        this.Qhg.setSelection(0);
                    }
                    AppMethodBeat.o(38726);
                    return false;
                }
            };
        }
        EventCenter.instance.addListener(pVar.qZo);
        EventCenter.instance.addListener(pVar.Qhb);
        EventCenter.instance.addListener(pVar.Qhc);
        pVar.pzA = new MessageQueue.IdleHandler() {
            /* class com.tencent.mm.ui.conversation.p.AnonymousClass6 */

            public final boolean queueIdle() {
                AppMethodBeat.i(38727);
                Log.d("MicroMsg.RefreshHelper", "dkuploadAddrBook idleHandler");
                if (bg.aAc() && l.bnZ() == l.a.SUCC && !l.bnY()) {
                    bg.azz().a(new com.tencent.mm.plugin.account.friend.a.ao(l.boi(), l.boh()), 0);
                }
                Looper.myQueue().removeIdleHandler(p.this.pzA);
                AppMethodBeat.o(38727);
                return false;
            }
        };
        Looper.myQueue().addIdleHandler(pVar.pzA);
        conversationListView4.post(new Runnable() {
            /* class com.tencent.mm.ui.conversation.p.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(38729);
                if (!MMApplicationContext.isAppHasInit()) {
                    MMApplicationContext.setAppHasInitFlag(true);
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.ui.conversation.p.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(38728);
                            Log.i("MicroMsg.RefreshHelper", "APPHasInitEvent begin");
                            EventCenter.instance.publish(new a());
                            AppMethodBeat.o(38728);
                        }
                    }, 100);
                }
                com.tencent.mm.plugin.report.service.g.Wm(8);
                AppMethodBeat.o(38729);
            }
        });
        com.tencent.mm.av.b bcT = q.bcT();
        Log.i("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + bcT.iWK + " to 2131231628");
        bcT.iWK = R.drawable.c3h;
        EventCenter.instance.addListener(this.QfP);
        EventCenter.instance.addListener(this.QfQ);
        bg.aVB();
        bg.aVF();
        com.tencent.mm.model.c.aST().add(h.Qdi);
        bg.aVF();
        com.tencent.mm.model.c.aSN().add(h.Qdi);
        bg.aVF();
        com.tencent.mm.model.c.aSN().add(this.Qct);
        i iVar3 = this.Qct;
        if (iVar3.QbR == null) {
            iVar3.QbR = new IListener<ae>() {
                /* class com.tencent.mm.ui.conversation.i.AnonymousClass3 */

                {
                    AppMethodBeat.i(161568);
                    this.__eventId = ae.class.getName().hashCode();
                    AppMethodBeat.o(161568);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(ae aeVar) {
                    AppMethodBeat.i(38484);
                    i.this.QbO = true;
                    AppMethodBeat.o(38484);
                    return false;
                }
            };
        }
        EventCenter.instance.addListener(iVar3.QbR);
        this.Qct.Qej = new i.b() {
            /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass11 */

            @Override // com.tencent.mm.ui.conversation.i.b
            public final void gVP() {
                AppMethodBeat.i(234189);
                MainUI.this.Qct.clearCache();
                bg.aVF();
                com.tencent.mm.model.c.aST().add(MainUI.this.Qct);
                bg.aVF();
                com.tencent.mm.model.c.aSN().add(MainUI.this.Qct);
                AppMethodBeat.o(234189);
            }
        };
        i iVar4 = this.Qct;
        com.tencent.mm.plugin.forcenotify.a.b bVar2 = (com.tencent.mm.plugin.forcenotify.a.b) g.af(com.tencent.mm.plugin.forcenotify.a.b.class);
        if (!(bVar2 == null || bVar2.dMm() == null)) {
            bVar2.dMm().add(iVar4.OLa);
        }
        bg.aVF();
        Log.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", Long.valueOf(Util.milliSecondsToNow(currentTimeMillis)), Integer.valueOf(com.tencent.mm.model.c.getUin()), Integer.valueOf(com.tencent.mm.protocal.d.KyO));
        if (Build.VERSION.SDK_INT >= 24 && LauncherUI.getInstance() != null) {
            this.dSv = LauncherUI.getInstance().isInMultiWindowMode();
        }
        this.QfG.postDelayed(new Runnable() {
            /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(38621);
                if (MainUI.this.thisActivity() != null) {
                    MainUI.this.thisActivity().supportInvalidateOptionsMenu();
                }
                AppMethodBeat.o(38621);
            }
        }, 200);
        setOnVisibilityChangedListener(this.QfO);
        AppMethodBeat.o(38641);
    }

    public final void gVW() {
        AppMethodBeat.i(38642);
        if (this.Qct != null) {
            this.Qct.onResume();
        }
        AppMethodBeat.o(38642);
    }

    public final void gVX() {
        AppMethodBeat.i(38643);
        if (this.Qct != null) {
            this.Qct.onPause();
        }
        AppMethodBeat.o(38643);
    }

    public final void alb(int i2) {
        AppMethodBeat.i(38644);
        if (this.Qct != null) {
            this.Qct.anQ(i2);
        }
        AppMethodBeat.o(38644);
    }

    @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
    public final void gGv() {
        AppMethodBeat.i(38645);
        Log.i("MicroMsg.MainUI", "onTabResume");
        long nowMilliSecond = Util.nowMilliSecond();
        gVW();
        com.tencent.mm.blink.b.ake().arrange(new Runnable() {
            /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(38622);
                a aVar = MainUI.this.Qfu;
                if (!aVar.Qbf) {
                    aVar.Qbf = true;
                    p.aYn().d(aVar);
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().add(aVar);
                    aVar.gVm();
                }
                AppMethodBeat.o(38622);
            }
        });
        Log.d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
        p pVar = this.QfL;
        if (com.tencent.mm.bh.g.jpy != null) {
            com.tencent.mm.bh.g.jpy.a(pVar);
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.conversation.p.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(38730);
                in inVar = new in();
                inVar.dNg.data = "MAIN_UI_EVENT_UPDATE_VIEW";
                EventCenter.instance.publish(inVar);
                AppMethodBeat.o(38730);
            }
        });
        o.kr(pVar.dKq);
        if (!(pVar.dKq == null || pVar.dKq.getIntent() == null || !pVar.dKq.getIntent().getBooleanExtra("resend_fail_messages", false))) {
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.ui.conversation.p.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(38733);
                    com.tencent.mm.ui.base.h.c(p.this.dKq, p.this.dKq.getString(R.string.ffz), "", p.this.dKq.getString(R.string.fg0), p.this.dKq.getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.conversation.p.AnonymousClass9.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(38731);
                            EventCenter.instance.publish(new sj());
                            AppMethodBeat.o(38731);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.conversation.p.AnonymousClass9.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(38732);
                            EventCenter.instance.publish(new oh());
                            AppMethodBeat.o(38732);
                        }
                    });
                    AppMethodBeat.o(38733);
                }
            }, 500);
            pVar.dKq.getIntent().putExtra("resend_fail_messages", false);
        }
        LauncherUI launcherUI = (LauncherUI) pVar.dKq;
        if (launcherUI != null) {
            launcherUI.getHomeUI().setTitleBarDoubleClickListener(pVar.PTi);
        }
        if (IntentUtil.getBooleanExtra(pVar.dKq.getIntent(), "Main_ListToTop", false) && pVar.QfG != null) {
            pVar.QfG.post(new Runnable() {
                /* class com.tencent.mm.ui.conversation.p.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(38722);
                    if (!p.this.dKq.isFinishing()) {
                        p.this.QfG.setSelection(0);
                    }
                    AppMethodBeat.o(38722);
                }
            });
        }
        IntentUtil.putExtra(pVar.dKq.getIntent(), "Main_ListToTop", false);
        k kVar = this.QfK;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(kVar.gtM == null ? -1 : kVar.gtM.isShowing() ? 1 : 0);
        objArr[1] = Integer.valueOf(kVar.gVT());
        Log.i("MicroMsg.InitHelper", "onTabResume tip:%d initscene:%d", objArr);
        kVar.gVR();
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.ui.conversation.k.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(38600);
                k.d(k.this);
                AppMethodBeat.o(38600);
            }
        }, 100);
        if (bg.aAc() && !this.QfK.gVU()) {
            EventCenter.instance.asyncPublish(new xj(), Looper.getMainLooper());
            wp wpVar = new wp();
            wpVar.ecH.action = 4;
            EventCenter.instance.asyncPublish(wpVar, new Executor() {
                /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass5 */

                public final void execute(Runnable runnable) {
                    AppMethodBeat.i(234178);
                    com.tencent.f.h.RTc.aX(runnable);
                    AppMethodBeat.o(234178);
                }
            });
        }
        AppMethodBeat.o(38645);
    }

    @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
    public final void gGw() {
        AppMethodBeat.i(38646);
        Log.i("MicroMsg.MainUI", "onTabStart");
        AppMethodBeat.o(38646);
    }

    @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
    public final void gGx() {
        AppMethodBeat.i(38647);
        Log.i("MicroMsg.MainUI", "onTabPause");
        if (!ao.gJK()) {
            com.tencent.mm.blink.b.ake().arrange(new Runnable() {
                /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(234179);
                    MainUI.this.Qfu.gGx();
                    AppMethodBeat.o(234179);
                }
            });
            this.QfK.gGx();
            hideVKB();
            this.QfL.gGx();
            gVX();
        }
        AppMethodBeat.o(38647);
    }

    @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
    public final void gGy() {
        AppMethodBeat.i(38648);
        Log.i("MicroMsg.MainUI", "onTabStop");
        if (ao.gJK()) {
            com.tencent.mm.blink.b.ake().arrange(new Runnable() {
                /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(234180);
                    MainUI.this.Qfu.gGx();
                    AppMethodBeat.o(234180);
                }
            });
            this.QfK.gGx();
            hideVKB();
            this.QfL.gGx();
            gVX();
        }
        AppMethodBeat.o(38648);
    }

    @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
    public final void gGz() {
        AppMethodBeat.i(38649);
        Log.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", Boolean.valueOf(bg.aAc()));
        com.tencent.mm.blink.b.ake().arrange(new Runnable() {
            /* class com.tencent.mm.ui.conversation.MainUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(234181);
                a aVar = MainUI.this.Qfu;
                Log.i("MicroMsg.BannerHelper", "destroyBanner");
                aVar.gGx();
                a.jU(aVar.QaV);
                a.jU(aVar.QaW);
                a.jU(aVar.QaX);
                a.jU(aVar.QaY);
                for (com.tencent.mm.pluginsdk.ui.b.b bVar : aVar.QaZ) {
                    if (bVar != null) {
                        bVar.destroy();
                    }
                }
                bg.b(aVar.FPE);
                EventCenter.instance.removeListener(aVar.Qbb);
                EventCenter.instance.removeListener(aVar.Qbc);
                if (bg.aAc()) {
                    bg.aVF();
                    com.tencent.mm.model.c.b(aVar);
                }
                aVar.context = null;
                AppMethodBeat.o(234181);
            }
        });
        k kVar = this.QfK;
        kVar.Qfy.unlock();
        bg.azz().b(-1, kVar);
        if (kVar.gtM != null) {
            kVar.gtM.dismiss();
            kVar.gtM = null;
        }
        EventCenter.instance.removeListener(kVar.Qfw);
        EventCenter.instance.removeListener(kVar.Qfx);
        p pVar = this.QfL;
        if (pVar.qZo != null) {
            EventCenter.instance.removeListener(pVar.qZo);
            pVar.qZo = null;
        }
        EventCenter.instance.removeListener(pVar.Qhb);
        EventCenter.instance.removeListener(pVar.Qhc);
        if (com.tencent.mm.bh.g.jpy != null) {
            com.tencent.mm.bh.g.jpy.b(pVar);
        }
        if (bg.aAc()) {
            af.blM();
        }
        EventCenter.instance.removeListener(this.QfP);
        EventCenter.instance.removeListener(this.QfQ);
        if (bg.aAc()) {
            bg.aVF();
            com.tencent.mm.model.c.aST().add(h.Qdi);
            bg.aVF();
            com.tencent.mm.model.c.aSN().add(h.Qdi);
            if (this.Qct != null) {
                bg.aVF();
                com.tencent.mm.model.c.aST().remove(this.Qct);
                bg.aVF();
                com.tencent.mm.model.c.aSN().remove(this.Qct);
            }
        }
        if (this.Qct != null) {
            i iVar = this.Qct;
            if (iVar.QbR != null) {
                EventCenter.instance.removeListener(iVar.QbR);
                iVar.QbR = null;
            }
            this.Qct.Qej = null;
            i iVar2 = this.Qct;
            iVar2.Qej = null;
            if (iVar2.Pax != null) {
                iVar2.Pax.clear();
                iVar2.Pax = null;
            }
            iVar2.AV(true);
            iVar2.gGV();
            iVar2.Qem.clear();
            com.tencent.mm.plugin.forcenotify.a.b bVar = (com.tencent.mm.plugin.forcenotify.a.b) g.af(com.tencent.mm.plugin.forcenotify.a.b.class);
            if (!(bVar == null || bVar.dMm() == null)) {
                bVar.dMm().remove(iVar2.OLa);
            }
            Log.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
        }
        this.QfO = null;
        setOnVisibilityChangedListener(null);
        AppMethodBeat.o(38649);
    }

    @Override // com.tencent.mm.ui.n, com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
    public final void gGB() {
        AppMethodBeat.i(38650);
        Log.i("MicroMsg.MainUI", "turn to bg");
        AppMethodBeat.o(38650);
    }

    @Override // com.tencent.mm.ui.n, com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
    public final void gGC() {
        AppMethodBeat.i(38651);
        Log.i("MicroMsg.MainUI", "turn to fg");
        AppMethodBeat.o(38651);
    }

    @Override // com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
    public final void gGA() {
    }

    @Override // com.tencent.mm.ui.n
    public final void gHE() {
        AppMethodBeat.i(38652);
        Log.i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
        k kVar = this.QfK;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(kVar.gtM == null ? -1 : kVar.gtM.isShowing() ? 1 : 0);
        objArr[1] = Integer.valueOf(kVar.gVT());
        Log.i("MicroMsg.InitHelper", "onTabSwitchIn tip:%d initscene:%d", objArr);
        if (kVar.wakeLock != null) {
            kVar.gVR();
        }
        if (this.mController != null) {
            this.mController.onResume();
        }
        if (this.Qct != null) {
            this.Qct.Qeu = true;
        }
        AppMethodBeat.o(38652);
    }

    @Override // com.tencent.mm.ui.n
    public final void gHF() {
        AppMethodBeat.i(38653);
        Log.i("MicroMsg.MainUI", "onTabSwitchOut");
        if (this.QfG != null) {
            ConversationListView conversationListView = this.QfG;
            conversationListView.gVz();
            if (conversationListView.Qcx != null) {
                conversationListView.Qcx.fuy();
            }
        }
        if (this.Qct != null) {
            this.Qct.Qeu = false;
        }
        AppMethodBeat.o(38653);
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment, com.tencent.mm.ui.MMFragment
    public void onDestroy() {
        AppMethodBeat.i(38654);
        Log.i("MicroMsg.MainUI", "onDestroy");
        this.QfM.gWg();
        if (this.QfG != null) {
            ConversationListView conversationListView = this.QfG;
            Log.i("MicroMsg.ConversationListView", "onDestroy");
            g.aAi().b(conversationListView.VlV);
            if (conversationListView.onh != null) {
                conversationListView.onh.onDestroy();
            }
            if (conversationListView.Qcx != null) {
                conversationListView.Qcx.onDestroy();
            }
            if (conversationListView.QcR != null) {
                conversationListView.removeCallbacks(conversationListView.QcR);
            }
            if (conversationListView.QcQ != null) {
                conversationListView.removeCallbacks(conversationListView.QcQ);
            }
            if (conversationListView.QcP != null) {
                conversationListView.removeCallbacks(conversationListView.QcP);
            }
            if (conversationListView.QcW != null) {
                conversationListView.QcW.dead();
            }
        }
        super.onDestroy();
        AppMethodBeat.o(38654);
    }

    @Override // com.tencent.mm.ui.conversation.k.a
    public final void gVV() {
        if (this.Qct != null) {
            this.Qct.yJA = true;
        }
    }

    @Override // com.tencent.mm.ui.conversation.k.a
    public final void atH() {
        AppMethodBeat.i(38655);
        if (this.Qct != null) {
            this.Qct.yJA = false;
            this.Qct.gVM();
            LauncherUI.getInstance().ODR.getMainTabUI().gJe();
        }
        AppMethodBeat.o(38655);
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment, com.tencent.mm.ui.MMFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(38656);
        if (i2 != 4 || keyEvent.getAction() != 0) {
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(38656);
            return onKeyDown;
        } else if (this.QfG == null || !this.QfG.esy()) {
            boolean onKeyDown2 = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(38656);
            return onKeyDown2;
        } else {
            this.QfG.i(10, 11, false);
            AppMethodBeat.o(38656);
            return true;
        }
    }

    public final void gVY() {
        AppMethodBeat.i(38657);
        if (this.QfG != null && this.QfG.esy()) {
            this.QfG.gVw();
        }
        AppMethodBeat.o(38657);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0045, code lost:
        if (r2.A(r2.QaY, false) == false) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.ui.conversation.MainUI r9, int r10) {
        /*
            r8 = 234197(0x392d5, float:3.2818E-40)
            r7 = 8
            r0 = 1
            r1 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r8)
            if (r10 > 0) goto L_0x0053
            com.tencent.mm.ui.conversation.a r2 = r9.Qfu
            android.content.Context r3 = r2.context
            if (r3 == 0) goto L_0x0061
            java.lang.String r3 = "MicroMsg.BannerHelper"
            java.lang.String r4 = "checkBannerEmpyt %d"
            java.lang.Object[] r5 = new java.lang.Object[r0]
            int r6 = r2.hashCode()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5[r1] = r6
            com.tencent.mm.sdk.platformtools.Log.i(r3, r4, r5)
            java.util.List<com.tencent.mm.pluginsdk.ui.b.b> r3 = r2.QaV
            boolean r3 = r2.A(r3, r1)
            if (r3 != 0) goto L_0x0061
            java.util.List<com.tencent.mm.pluginsdk.ui.b.b> r3 = r2.QaW
            boolean r3 = r2.A(r3, r1)
            if (r3 != 0) goto L_0x0061
            java.util.List<com.tencent.mm.pluginsdk.ui.b.b> r3 = r2.QaX
            boolean r3 = r2.A(r3, r1)
            if (r3 != 0) goto L_0x0061
            java.util.List<com.tencent.mm.pluginsdk.ui.b.b> r3 = r2.QaY
            boolean r2 = r2.A(r3, r1)
            if (r2 != 0) goto L_0x0061
        L_0x0047:
            if (r0 == 0) goto L_0x0053
            android.widget.TextView r0 = r9.QfJ
            r0.setVisibility(r1)
            com.tencent.mm.ui.conversation.ConversationListView r0 = r9.QfG
            r0.setVisibility(r7)
        L_0x0053:
            com.tencent.mm.ui.conversation.ConversationListView r0 = r9.QfG
            r0.setVisibility(r1)
            android.widget.TextView r0 = r9.QfJ
            r0.setVisibility(r7)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
            return
        L_0x0061:
            r0 = r1
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.conversation.MainUI.a(com.tencent.mm.ui.conversation.MainUI, int):void");
    }
}
