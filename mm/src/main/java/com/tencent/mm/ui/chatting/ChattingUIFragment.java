package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.abh;
import com.tencent.mm.g.a.be;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.j.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.expt.hellhound.a.a.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.a.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.a.a;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.ui.chatting.d.b.o;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.d.b.v;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.n.a.f;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.LinkedList;

@SuppressLint({"ValidFragment"})
public class ChattingUIFragment extends BaseChattingUIFragment {
    public static String NQL;
    private c EOZ;
    private final e EPa = new e() {
        /* class com.tencent.mm.ui.chatting.ChattingUIFragment.AnonymousClass5 */

        {
            AppMethodBeat.i(34707);
            AppMethodBeat.o(34707);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.b.e
        public final void b(AbsListView absListView, int i2, int i3) {
            AppMethodBeat.i(232892);
            if (absListView == null) {
                AppMethodBeat.o(232892);
            } else if (i2 < 0 || i3 <= 0) {
                AppMethodBeat.o(232892);
            } else {
                a aVar = ChattingUIFragment.this.Pjp;
                if (aVar == null) {
                    AppMethodBeat.o(232892);
                    return;
                }
                ((aj) g.ah(aj.class)).report21053(ChattingUIFragment.this.Pjq, aVar, c.e.VISIABLE_ON_SCROLL.state, i2, i3, 2, "temp_6", 1, false);
                AppMethodBeat.o(232892);
            }
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.b.e
        public final void c(AbsListView absListView, int i2, int i3) {
            AppMethodBeat.i(232893);
            if (absListView == null) {
                AppMethodBeat.o(232893);
                return;
            }
            a aVar = ChattingUIFragment.this.Pjp;
            if (aVar == null) {
                AppMethodBeat.o(232893);
                return;
            }
            ((aj) g.ah(aj.class)).report21053(ChattingUIFragment.this.Pjq, aVar, c.e.VISIABLE_ON_SCROLL.state, i2, i3, 2, "temp_6", 1, false);
            AppMethodBeat.o(232893);
        }
    };
    public a Pjp;
    public ListView Pjq;
    private Runnable Pjr;
    private q Pjs;
    private MMChattingListView Pjt;
    private boolean Pju = true;
    protected boolean Pjv = true;
    private boolean Pjw = false;
    private com.tencent.mm.ui.chatting.n.a.a Pjx;
    private int mScrollState = 0;
    private boolean ptd = false;
    private int ptj = 0;
    private final int ptk = 10;
    private com.tencent.mm.ui.base.q tipDialog = null;

    static /* synthetic */ void a(ChattingUIFragment chattingUIFragment, boolean z) {
        AppMethodBeat.i(34776);
        chattingUIFragment.BO(z);
        AppMethodBeat.o(34776);
    }

    static /* synthetic */ void g(ChattingUIFragment chattingUIFragment) {
        AppMethodBeat.i(34777);
        super.finish();
        AppMethodBeat.o(34777);
    }

    @SuppressLint({"ValidFragment"})
    public ChattingUIFragment() {
        AppMethodBeat.i(232895);
        AppMethodBeat.o(232895);
    }

    @SuppressLint({"ValidFragment"})
    public ChattingUIFragment(byte b2) {
        super(true);
        AppMethodBeat.i(232896);
        AppMethodBeat.o(232896);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public void dealContentView(View view) {
        AppMethodBeat.i(34718);
        super.dealContentView(view);
        ((aa) this.dom.bh(aa.class)).gC(view);
        AppMethodBeat.o(34718);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public void setMMTitle(int i2) {
        AppMethodBeat.i(34719);
        setMMTitle(getMMString(i2));
        AppMethodBeat.o(34719);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public void setMMSubTitle(int i2) {
        AppMethodBeat.i(34722);
        setMMSubTitle(getMMString(i2));
        AppMethodBeat.o(34722);
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final void cmy() {
        AppMethodBeat.i(34724);
        if (this.Pjp == null) {
            AppMethodBeat.o(34724);
            return;
        }
        this.Pjp.notifyDataSetChanged();
        AppMethodBeat.o(34724);
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final void gNX() {
        boolean z;
        AppMethodBeat.i(34725);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        } else {
            z = false;
        }
        bf(false, z);
        AppMethodBeat.o(34725);
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final void BN(boolean z) {
        AppMethodBeat.i(34726);
        bf(z, Looper.myLooper() != Looper.getMainLooper());
        AppMethodBeat.o(34726);
    }

    @Deprecated
    public final void bf(final boolean z, boolean z2) {
        AppMethodBeat.i(34727);
        if (z2) {
            com.tencent.mm.ui.chatting.e.a.gRP().removeCallbacks(this.Pjr);
            MMHandler gRP = com.tencent.mm.ui.chatting.e.a.gRP();
            AnonymousClass1 r1 = new Runnable() {
                /* class com.tencent.mm.ui.chatting.ChattingUIFragment.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(34702);
                    ChattingUIFragment.a(ChattingUIFragment.this, z);
                    AppMethodBeat.o(34702);
                }
            };
            this.Pjr = r1;
            gRP.post(r1);
            AppMethodBeat.o(34727);
            return;
        }
        BO(z);
        AppMethodBeat.o(34727);
    }

    private void BO(final boolean z) {
        final int i2 = 0;
        AppMethodBeat.i(34728);
        int lastVisiblePosition = this.Pjq.getLastVisiblePosition();
        int firstVisiblePosition = this.Pjq.getFirstVisiblePosition();
        final int count = this.Pjq.getCount();
        Log.i("MicroMsg.ChattingUIFragment", "[scrollToLastImpl] isFirstScroll:%s [%s:%s] count:%s force:%s", Boolean.valueOf(this.Pju), Integer.valueOf(lastVisiblePosition), Integer.valueOf(firstVisiblePosition), Integer.valueOf(count), Boolean.valueOf(z));
        this.Pju = false;
        if (z && lastVisiblePosition == firstVisiblePosition && lastVisiblePosition >= count - 1 && this.Pjq.getChildCount() > 0) {
            i2 = this.Pjq.getChildAt(this.Pjq.getChildCount() - 1).getHeight();
        }
        if (!z || !this.Pjt.cAl()) {
            p.a(this.Pjq, count - 1, -i2, true);
        } else {
            Log.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom");
        }
        this.Pjq.post(new Runnable() {
            /* class com.tencent.mm.ui.chatting.ChattingUIFragment.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(34709);
                if (!z || !ChattingUIFragment.this.Pjt.cAl()) {
                    p.a(ChattingUIFragment.this.Pjq, count - 1, -i2, true);
                    AppMethodBeat.o(34709);
                    return;
                }
                Log.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom in post");
                AppMethodBeat.o(34709);
            }
        });
        AppMethodBeat.o(34728);
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final void scrollToPosition(int i2) {
        int i3;
        AppMethodBeat.i(34729);
        com.tencent.mm.ui.chatting.e.a.gRP().removeCallbacks(this.Pjr);
        Log.i("MicroMsg.ChattingUIFragment", "[scrollToPosition] scroll to pos:%d", Integer.valueOf(i2));
        if (this.Pjs == null) {
            this.Pjs = new q(this.Pjq);
        }
        q qVar = this.Pjs;
        int headerViewsCount = i2 + this.Pjq.getHeaderViewsCount();
        qVar.GP.removeCallbacks(qVar);
        qVar.QvV = System.currentTimeMillis();
        qVar.Qwa = 0;
        int firstVisiblePosition = qVar.GP.getFirstVisiblePosition();
        int childCount = (qVar.GP.getChildCount() + firstVisiblePosition) - 1;
        if (headerViewsCount <= firstVisiblePosition) {
            i3 = (firstVisiblePosition - headerViewsCount) + 1;
            qVar.mMode = 2;
        } else if (headerViewsCount >= childCount) {
            i3 = (headerViewsCount - childCount) + 1;
            qVar.mMode = 1;
        } else {
            AppMethodBeat.o(34729);
            return;
        }
        if (i3 > 0) {
            qVar.QvY = 1000 / i3;
        } else {
            qVar.QvY = 1000;
        }
        qVar.QvW = headerViewsCount;
        qVar.QvX = -1;
        qVar.GP.post(qVar);
        AppMethodBeat.o(34729);
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final void gNY() {
        AppMethodBeat.i(34730);
        Log.i("MicroMsg.ChattingUIFragment", "[smoothScrollBy] dis:%d duration:%d", 0, 0);
        this.Pjq.smoothScrollBy(0, 0);
        AppMethodBeat.o(34730);
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final void amm(int i2) {
        AppMethodBeat.i(34731);
        com.tencent.mm.ui.chatting.e.a.gRP().removeCallbacks(this.Pjr);
        Log.i("MicroMsg.ChattingUIFragment", "[setSelection] pos:%d isSmooth:%s", Integer.valueOf(i2), Boolean.FALSE);
        ListView listView = this.Pjq;
        if (listView != null) {
            Log.i("MicroMsg.ChattingUI.ScrollController", "setSelection position %s smooth %s", Integer.valueOf(i2), Boolean.FALSE);
            listView.setItemChecked(i2, true);
            listView.setSelection(i2);
        }
        AppMethodBeat.o(34731);
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final void lf(int i2, int i3) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(34732);
        com.tencent.mm.ui.chatting.e.a.gRP().removeCallbacks(this.Pjr);
        Log.i("MicroMsg.ChattingUIFragment", "[setSelectionFromTop] pos:%d offset:%s isSmooth:%s", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.FALSE);
        if (!this.dom.Pwg) {
            p.a(this.Pjq, i2, i3, false);
            AppMethodBeat.o(34732);
            return;
        }
        ListView listView = this.Pjq;
        if (listView != null) {
            int lastVisiblePosition = listView.getLastVisiblePosition();
            if (listView.getFirstVisiblePosition() >= i2 || i2 >= lastVisiblePosition) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                Log.i("MicroMsg.ChattingUI.ScrollController", "setSelectionFromTop position %s smooth %s", Integer.valueOf(i2), Boolean.TRUE);
                listView.setItemChecked(i2, true);
                if (d.oF(11)) {
                    int lastVisiblePosition2 = listView.getLastVisiblePosition();
                    int firstVisiblePosition = listView.getFirstVisiblePosition();
                    if ((i2 >= firstVisiblePosition || firstVisiblePosition - i2 < 20) && (i2 <= lastVisiblePosition2 || i2 - lastVisiblePosition2 < 20)) {
                        z2 = false;
                    }
                    if (!z2) {
                        listView.smoothScrollToPositionFromTop(i2, i3, 200);
                        AppMethodBeat.o(34732);
                        return;
                    }
                }
                listView.setSelectionFromTop(i2, i3);
            }
        }
        AppMethodBeat.o(34732);
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final void b(Context context, String str, String str2, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(232897);
        dismissDialog();
        this.tipDialog = h.a(context, str2, true, onCancelListener);
        AppMethodBeat.o(232897);
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final void dismissDialog() {
        AppMethodBeat.i(34735);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        AppMethodBeat.o(34735);
    }

    @Override // com.tencent.mm.ui.chatting.ae, com.tencent.mm.ui.chatting.BaseChattingUIFragment
    public final int getFirstVisiblePosition() {
        AppMethodBeat.i(34749);
        int firstVisiblePosition = this.Pjq.getFirstVisiblePosition();
        AppMethodBeat.o(34749);
        return firstVisiblePosition;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public int getLayoutId() {
        return R.layout.pu;
    }

    @Override // com.tencent.mm.ui.chatting.af
    public final MMChattingListView gOd() {
        return this.Pjt;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public boolean isSupportCustomActionBar() {
        AppMethodBeat.i(34751);
        boolean isSupportNavigationSwipeBack = isSupportNavigationSwipeBack();
        AppMethodBeat.o(34751);
        return isSupportNavigationSwipeBack;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment
    public final void as(as asVar) {
        AppMethodBeat.i(34752);
        super.as(asVar);
        NQL = asVar.field_username;
        AppMethodBeat.o(34752);
    }

    @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment
    public final void kh(Context context) {
        AppMethodBeat.i(34753);
        b bVar = new b();
        bVar.bm(context);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doAttach", "(Landroid/content/Context;)V", this, bVar.axR());
        super.kh(context);
        Log.i("MicroMsg.ChattingUIFragment", "[doAttach]:%s#0x%x task:%s hc:%d", thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), Util.getActivityTaskInfo(thisActivity()), Integer.valueOf(hashCode()));
        if (this.mController != null) {
            this.mController.bF(3, true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doAttach", "(Landroid/content/Context;)V");
        AppMethodBeat.o(34753);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0154  */
    @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void gMJ() {
        /*
        // Method dump skipped, instructions count: 354
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingUIFragment.gMJ():void");
    }

    @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment
    public void doResume() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(34755);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V", this);
        super.doResume();
        if (getWindow() != null) {
            getWindow().setBackgroundDrawableResource(R.color.a5p);
        }
        boolean isShown = getContentView() != null ? getContentView().isShown() : false;
        if (getView() != null) {
            z = getView().isShown();
        } else {
            z = false;
        }
        if (this.Pjq.getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!this.dom.cQp) {
            Log.i("MicroMsg.ChattingUIFragment", "onResume fragment not foreground, return,  chatting contentview is show %b, viewShow %b listviewShow:%b", Boolean.valueOf(isShown), Boolean.valueOf(z), Boolean.valueOf(z2));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V");
            AppMethodBeat.o(34755);
        } else if (!bg.aAc()) {
            Log.w("MicroMsg.ChattingUIFragment", "account not ready, mabey not call onDestroy!!!");
            finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V");
            AppMethodBeat.o(34755);
        } else {
            this.Pjp.resume();
            a aVar = this.Pjp;
            if (aVar != null) {
                ((aj) g.ah(aj.class)).report21053(this.Pjq, aVar, c.e.VISIABLE_ON_RESUME.state, -1, -1, 2, "temp_6", 2, false);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V");
            AppMethodBeat.o(34755);
        }
    }

    @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment
    public void doPause() {
        AppMethodBeat.i(34756);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doPause", "()V", this);
        super.doPause();
        r.dismiss();
        Log.i("MicroMsg.ChattingUIFragment", "on chatting ui pause  rawuser:%s", this.dom.getTalkerUserName());
        if (this.dom.getTalkerUserName() == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doPause", "()V");
            AppMethodBeat.o(34756);
            return;
        }
        this.Pjp.pause();
        hideVKB();
        Log.d("MicroMsg.ChattingUIFragment", "chattingui cancel pause auto download logic");
        a aVar = this.Pjp;
        if (aVar != null) {
            ((aj) g.ah(aj.class)).report21053(this.Pjq, aVar, c.e.INVISIABLE_ON_PAUSE.state, -1, -1, 2, "temp_6", 3, false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doPause", "()V");
        AppMethodBeat.o(34756);
    }

    @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment
    public final void gNd() {
        AppMethodBeat.i(34757);
        super.gNd();
        if (this.dom.getTalkerUserName() == null) {
            AppMethodBeat.o(34757);
        } else {
            AppMethodBeat.o(34757);
        }
    }

    @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment
    public void onEnterBegin() {
        AppMethodBeat.i(34758);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onEnterBegin", "()V", this);
        super.onEnterBegin();
        eGg();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onEnterBegin", "()V");
        AppMethodBeat.o(34758);
    }

    @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment
    public final void onExitBegin() {
        AppMethodBeat.i(34759);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onExitBegin", "()V", this);
        super.onExitBegin();
        a aVar = this.Pjp;
        aVar.PlH = -1;
        aVar.PlG.clear();
        this.Pjx.PFv.cancel();
        eGg();
        EventCenter.instance.publish(new be());
        EventCenter.instance.publish(new abh());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onExitBegin", "()V");
        AppMethodBeat.o(34759);
    }

    @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment
    public final void onExitEnd() {
        AppMethodBeat.i(34760);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onExitEnd", "()V", this);
        super.onExitEnd();
        dismissDialog();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onExitEnd", "()V");
        AppMethodBeat.o(34760);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public void onKeyboardStateChanged() {
        AppMethodBeat.i(34762);
        if (keyboardState() == 1) {
            this.Pjq.post(new Runnable() {
                /* class com.tencent.mm.ui.chatting.ChattingUIFragment.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(34712);
                    ChattingUIFragment.this.bf(true, false);
                    AppMethodBeat.o(34712);
                }
            });
        }
        AppMethodBeat.o(34762);
    }

    @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment
    public final boolean gNh() {
        AppMethodBeat.i(34763);
        if (!isScreenEnable()) {
            Log.w("MicroMsg.ChattingUIFragment", "Actionbar customView onclick screen not enable");
            AppMethodBeat.o(34763);
        } else {
            hideVKB();
            if (getActivity() != null) {
                View findViewById = getActivity().findViewById(R.id.e8x);
                if (findViewById != null) {
                    findViewById.setVisibility(0);
                    findViewById.post(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.ChattingUIFragment.AnonymousClass10 */

                        public final void run() {
                            AppMethodBeat.i(34713);
                            ChattingUIFragment.this.gOf();
                            AppMethodBeat.o(34713);
                        }
                    });
                } else {
                    gOf();
                }
            }
            AppMethodBeat.o(34763);
        }
        return true;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public void onSwipeBack() {
        AppMethodBeat.i(34765);
        Log.w("MicroMsg.ChattingUIFragment", "onSwipeBack");
        gOg();
        if (n.ecR().ecV()) {
            fo foVar = new fo();
            foVar.dIN.username = com.tencent.mm.bi.d.jpB.bgL();
            EventCenter.instance.publish(foVar);
        }
        if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(34765);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public void onDragBegin() {
        AppMethodBeat.i(34766);
        if (isSupportNavigationSwipeBack() && this.Pjp != null) {
            this.Pjv = false;
        }
        AppMethodBeat.o(34766);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public void onCancelDrag() {
        AppMethodBeat.i(34767);
        if (isSupportNavigationSwipeBack() && this.Pjp != null) {
            this.Pjv = true;
        }
        AppMethodBeat.o(34767);
    }

    /* access modifiers changed from: protected */
    public final void gOg() {
        AppMethodBeat.i(34768);
        gOh();
        com.tencent.mm.ui.chatting.d.b.d dVar = (com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class);
        if (as.bjm(this.dom.getTalkerUserName())) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            com.tencent.mm.br.c.b(getContext(), "tmessage", ".ui.TConversationUI", intent);
        } else if (getIntExtra("chat_from_scene", 0) == 4) {
            finish();
            AppMethodBeat.o(34768);
            return;
        } else if ((getIntExtra("chat_from_scene", 0) == 1 || getIntExtra("chat_from_scene", 0) == 3) && this.dom.GUe != null && this.dom.GUe.gBM() && dVar.gOM() != null && dVar.gOM().UG() && dVar.gOM().cG(false) != null && dVar.gOM().cG(false).Vh() != null && !Util.isNullOrNil(dVar.gOM().UN())) {
            finish();
            AppMethodBeat.o(34768);
            return;
        } else if (((ac) this.dom.bh(ac.class)).gQH()) {
            finish();
        } else if (!getBooleanExtra("finish_direct", false).booleanValue()) {
            if (!this.isCurrentActivity) {
                finish();
                AppMethodBeat.o(34768);
                return;
            }
            Intent intent2 = new Intent(getContext(), LauncherUI.class);
            intent2.addFlags(67108864);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/chatting/ChattingUIFragment", "goBackImpl", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "goBackImpl", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
            finish();
            AppMethodBeat.o(34768);
            return;
        }
        finish();
        AppMethodBeat.o(34768);
    }

    @Override // com.tencent.mm.ui.chatting.ae, com.tencent.mm.ui.chatting.BaseChattingUIFragment
    public final ListView getListView() {
        return this.Pjq;
    }

    @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment
    public final com.tencent.mm.ui.chatting.n.a.a gNi() {
        return this.Pjx;
    }

    @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment
    public final void gNj() {
        com.tencent.mm.ui.chatting.n.a.a fVar;
        AppMethodBeat.i(34771);
        if (this.Pjt == null || this.Pjp == null) {
            AppMethodBeat.o(34771);
            return;
        }
        com.tencent.mm.ui.chatting.e.a aVar = this.dom;
        com.tencent.mm.ui.chatting.h.a aVar2 = new com.tencent.mm.ui.chatting.h.a(this.dom, this.Pjp.PlE);
        com.tencent.mm.ui.chatting.h.b bVar = new com.tencent.mm.ui.chatting.h.b(this.dom, this.Pjt);
        com.tencent.mm.ui.chatting.h.e eVar = new com.tencent.mm.ui.chatting.h.e(bVar, aVar2);
        if (((com.tencent.mm.ui.chatting.d.b.d) aVar.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()) {
            fVar = new com.tencent.mm.ui.chatting.n.a.b(aVar, eVar);
        } else if (((v) aVar.bh(v.class)).gQb()) {
            fVar = new com.tencent.mm.ui.chatting.n.a.d(aVar, eVar);
        } else if (((am) aVar.bh(am.class)).gRb() || ((am) aVar.bh(am.class)).gRc() || ((am) aVar.bh(am.class)).gQZ() || ((ai) aVar.bh(ai.class)).gQO()) {
            fVar = new f(aVar, eVar);
        } else if (((com.tencent.mm.ui.chatting.d.b.h) aVar.bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPu() || ((i) aVar.bh(i.class)).gPw()) {
            fVar = new com.tencent.mm.ui.chatting.n.a.c(aVar, eVar);
        } else if (((o) aVar.bh(o.class)).gPH()) {
            fVar = new com.tencent.mm.ui.chatting.n.a.g(aVar, eVar);
        } else {
            fVar = new com.tencent.mm.ui.chatting.n.a.e(aVar, eVar);
        }
        bVar.PDC = fVar;
        Log.i("MicroMsg.ChattingLoader.ChattingDataPresenterFactory", "[ChattingDataPresenterFactory] executor:%s", fVar.toString());
        this.Pjx = fVar;
        this.Pjp.PlQ = this.Pjx;
        this.Pjt.setLoadExecutor(this.Pjx);
        AppMethodBeat.o(34771);
    }

    /* access modifiers changed from: protected */
    public void gML() {
        com.tencent.mm.ui.chatting.e.a aVar;
        as asVar;
        AppMethodBeat.i(34772);
        this.EOZ = new com.tencent.mm.plugin.expt.hellhound.a.a.b.c(this.EPa, "ChattingUIFragment", c.a.STRATEGY_SAMPLING);
        this.mScrollState = 0;
        this.Pjt = (MMChattingListView) findViewById(R.id.avl);
        this.Pjt.setIsReturnSuperDispatchWhenCancel(true);
        this.Pjq = this.Pjt.getListView();
        this.Pjq.setVisibility(0);
        ((aa) this.dom.bh(aa.class)).gQk();
        if (this.Pjt.getBaseAdapter() == null) {
            this.Pjp = new a(this.dom, this.Pjq);
            this.Pjt.setAdapter(this.Pjp);
        }
        MMChattingListView mMChattingListView = this.Pjt;
        mMChattingListView.By(false);
        mMChattingListView.By(false);
        gNj();
        this.Pjx.a(d.a.ACTION_ENTER, true, (Bundle) null);
        this.Pjq.setOverScrollMode(2);
        if (!((am) this.dom.bh(am.class)).gQZ()) {
            this.Pjq.setTranscriptMode(1);
        } else {
            this.Pjq.setTranscriptMode(0);
        }
        this.Pjq.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.chatting.ChattingUIFragment.AnonymousClass13 */
            boolean pJi = false;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(232894);
                ChattingUIFragment.this.ptd = true;
                if (motionEvent.getAction() == 0) {
                    Log.i("MicroMsg.ChattingUIFragment", "onTouch: touch down");
                    this.pJi = true;
                } else if (motionEvent.getAction() == 1) {
                    Log.i("MicroMsg.ChattingUIFragment", "onTouch: touch up");
                    this.pJi = false;
                }
                if (!this.pJi || !ChattingUIFragment.this.Pjv) {
                    AppMethodBeat.o(232894);
                } else {
                    u uVar = (u) ChattingUIFragment.this.dom.bh(u.class);
                    if (uVar == null || uVar.gPO() == null) {
                        AppMethodBeat.o(232894);
                    } else {
                        uVar.gPO().Ak(true);
                        AppMethodBeat.o(232894);
                    }
                }
                return false;
            }
        });
        this.Pjq.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.ui.chatting.ChattingUIFragment.AnonymousClass2 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                View childAt;
                as asVar;
                String str;
                k.b aD;
                AppMethodBeat.i(232887);
                ChattingUIFragment.this.dom.Pwb.onScrollStateChanged(absListView, i2);
                ChattingUIFragment.this.mScrollState = i2;
                if (i2 == 0) {
                    Log.d("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] [%s:%s]", Integer.valueOf(ChattingUIFragment.this.Pjq.getFirstVisiblePosition()), Integer.valueOf(ChattingUIFragment.this.Pjq.getLastVisiblePosition()));
                    if (ChattingUIFragment.this.Pjq.getFirstVisiblePosition() == 0) {
                        View childAt2 = ChattingUIFragment.this.Pjq.getChildAt(0);
                        if (childAt2 != null) {
                            if (childAt2.getTop() == 0) {
                                Log.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load top more!");
                                ChattingUIFragment.this.Pjt.Bx(true);
                            } else if (childAt2.getTop() < 0) {
                                Log.w("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] exception auto load top more wit reset adapter!");
                                ChattingUIFragment.this.Pjt.setAdapter(ChattingUIFragment.this.Pjp);
                            }
                        }
                    } else if (ChattingUIFragment.this.Pjq.getLastVisiblePosition() == ChattingUIFragment.this.Pjq.getCount() - 1 && (childAt = ChattingUIFragment.this.Pjq.getChildAt(ChattingUIFragment.this.Pjq.getChildCount() - 1)) != null && ChattingUIFragment.this.Pjq.getBottom() - ChattingUIFragment.this.Pjt.getBottomHeight() >= childAt.getBottom()) {
                        Log.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load bottom more!");
                        ChattingUIFragment.this.Pjt.By(true);
                    }
                    ChattingUIFragment.this.Pjp.fc(ChattingUIFragment.this.Pjq.getFirstVisiblePosition() - ChattingUIFragment.this.Pjq.getHeaderViewsCount(), ChattingUIFragment.this.Pjq.getLastVisiblePosition());
                    a aVar = ChattingUIFragment.this.Pjp;
                    int firstVisiblePosition = ChattingUIFragment.this.Pjq.getFirstVisiblePosition() - ChattingUIFragment.this.Pjq.getHeaderViewsCount();
                    int lastVisiblePosition = ChattingUIFragment.this.Pjq.getLastVisiblePosition();
                    if (!(aVar.OIz == null || (asVar = aVar.OIz.GUe) == null || asVar.gBM())) {
                        LinkedList linkedList = new LinkedList();
                        for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                            ca amw = aVar.amw(i3);
                            if (!(amw == null || (str = amw.field_content) == null || (aD = k.b.aD(str, amw.field_reserved)) == null || aD.type != 5 || TextUtils.isEmpty(aD.url))) {
                                e.a aVar2 = new e.a();
                                aVar2.url = aD.url;
                                aVar2.pmM = 1;
                                aVar2.appId = aD.appId;
                                aVar2.title = aD.title;
                                aVar2.desc = aD.description;
                                aVar2.from = aVar.OIz.gRM() ? "groupmessage" : "singlemessage";
                                linkedList.add(aVar2);
                            }
                        }
                        if (((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)) != null && linkedList.size() > 0) {
                            Log.v("MicroMsg.ChattingDataAdapter", "[TRACE_PREFETCH] checkPreAuths authInfo size = %s", Integer.valueOf(linkedList.size()));
                            ((com.tencent.mm.plugin.brandservice.a.e) g.af(com.tencent.mm.plugin.brandservice.a.e.class)).m(linkedList, 2);
                        }
                    }
                }
                ChattingUIFragment.a(ChattingUIFragment.this, absListView, i2);
                AppMethodBeat.o(232887);
            }

            public final synchronized void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(232888);
                ChattingUIFragment.this.dom.Pwb.onScroll(absListView, i2, i3, i4);
                if (ChattingUIFragment.this.Pjw) {
                    if (ChattingUIFragment.this.Pjq.getLastVisiblePosition() != i4 - 1) {
                        AppMethodBeat.o(232888);
                    } else {
                        ChattingUIFragment.this.Pjw = false;
                    }
                }
                ChattingUIFragment.a(ChattingUIFragment.this, absListView, i2, i3);
                AppMethodBeat.o(232888);
            }
        });
        this.Pjq.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            /* class com.tencent.mm.ui.chatting.ChattingUIFragment.AnonymousClass3 */

            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                AppMethodBeat.i(232889);
                ChattingUIFragment.this.Pjp.fc(ChattingUIFragment.this.Pjq.getFirstVisiblePosition() - ChattingUIFragment.this.Pjq.getHeaderViewsCount(), ChattingUIFragment.this.Pjq.getLastVisiblePosition());
                ChattingUIFragment.this.Pjq.removeOnLayoutChangeListener(this);
                AppMethodBeat.o(232889);
            }
        });
        if (((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(2) && (aVar = this.dom) != null && (asVar = aVar.GUe) != null && asVar.gBM()) {
            ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CS(0);
        }
        registerForContextMenu(this.Pjq);
        bf(false, true);
        AppMethodBeat.o(34772);
    }

    @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment
    public void eGg() {
        AppMethodBeat.i(34773);
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.ui.chatting.ChattingUIFragment.AnonymousClass4 */
            ae Pjz = ((ae) ChattingUIFragment.this.dom.bh(ae.class));
            String username = ChattingUIFragment.this.dom.getTalkerUserName();

            {
                AppMethodBeat.i(232890);
                AppMethodBeat.o(232890);
            }

            public final void run() {
                AppMethodBeat.i(232891);
                long currentTimeMillis = System.currentTimeMillis();
                if (this.Pjz == null) {
                    Log.e("MicroMsg.ChattingUIFragment", "messBoxComponent == null! without writeOpLogAndMarkRead!");
                    AppMethodBeat.o(232891);
                    return;
                }
                this.Pjz.bmN(this.username);
                Log.i("MicroMsg.ChattingUIFragment", "ChattingUI writeOpLogAndMarkRead last : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(232891);
            }
        }, "MicroMsg.ChattingUIFragment");
        AppMethodBeat.o(34773);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.chatting.BaseChattingUIFragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Bundle bundleExtra;
        AppMethodBeat.i(34774);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 30763 || i2 == 30762) {
            switch (i2) {
                case 30762:
                case 30763:
                    if (!(intent == null || (bundleExtra = intent.getBundleExtra("result_data")) == null || !bundleExtra.getString("go_next", "").equals("gdpr_auth_location"))) {
                        g.aAh().azQ().set(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                        if (i2 != 30763) {
                            com.tencent.mm.pluginsdk.permission.b.a(getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 68);
                            break;
                        } else {
                            com.tencent.mm.pluginsdk.permission.b.a(getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 67);
                            AppMethodBeat.o(34774);
                            return;
                        }
                    }
            }
            AppMethodBeat.o(34774);
            return;
        }
        AppMethodBeat.o(34774);
    }

    @Override // android.support.v4.app.Fragment
    public void onMultiWindowModeChanged(boolean z) {
        AppMethodBeat.i(34775);
        super.onMultiWindowModeChanged(z);
        Log.i("MicroMsg.ChattingUIFragment", "onMultiWindowModeChanged: %s", Boolean.valueOf(z));
        ChatFooter gPO = ((u) this.dom.bh(u.class)).gPO();
        if (gPO != null) {
            gPO.setIsMultiWindow(z);
        }
        AppMethodBeat.o(34775);
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final void a(d.a aVar) {
        AppMethodBeat.i(232899);
        if (this.Pjp == null) {
            AppMethodBeat.o(232899);
            return;
        }
        a aVar2 = this.Pjp;
        if (aVar2.PlQ != null) {
            aVar2.PlQ.a(aVar, false, (Bundle) null);
        }
        AppMethodBeat.o(232899);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        AppMethodBeat.i(34717);
        if (!this.dom.cQp) {
            AppMethodBeat.o(34717);
            return;
        }
        super.onCreateOptionsMenu(menu, menuInflater);
        AppMethodBeat.o(34717);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public void setMMTitle(String str) {
        AppMethodBeat.i(34720);
        ((aa) this.dom.bh(aa.class)).setMMTitle(str);
        AppMethodBeat.o(34720);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public void setMMSubTitle(String str) {
        AppMethodBeat.i(34721);
        ((aa) this.dom.bh(aa.class)).setMMSubTitle(str);
        AppMethodBeat.o(34721);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        AppMethodBeat.i(34723);
        ((aa) this.dom.bh(aa.class)).setBackBtn(onMenuItemClickListener);
        AppMethodBeat.o(34723);
    }

    @Override // com.tencent.mm.ui.chatting.ae, com.tencent.mm.ui.MMFragment
    public boolean hideVKB() {
        AppMethodBeat.i(34733);
        ChatFooter gPO = ((u) this.dom.bh(u.class)).gPO();
        if (gPO != null) {
            boolean hideVKB = gPO.hideVKB();
            AppMethodBeat.o(34733);
            return hideVKB;
        }
        boolean hideVKB2 = super.hideVKB();
        AppMethodBeat.o(34733);
        return hideVKB2;
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final void setKeepScreenOn(boolean z) {
        AppMethodBeat.i(34736);
        if (this.Pjq != null) {
            this.Pjq.setKeepScreenOn(z);
        }
        AppMethodBeat.o(34736);
    }

    @Override // com.tencent.mm.ui.chatting.af
    public final void setBottomViewVisible(boolean z) {
        AppMethodBeat.i(34737);
        this.Pjt.setBottomViewVisible(z);
        AppMethodBeat.o(34737);
    }

    @Override // com.tencent.mm.ui.chatting.af
    public final void gNZ() {
        AppMethodBeat.i(34738);
        this.Pjt.setTopViewVisible(true);
        AppMethodBeat.o(34738);
    }

    @Override // com.tencent.mm.ui.chatting.af
    public final void gOa() {
        AppMethodBeat.i(34739);
        this.Pjt.setIsTopShowAll(false);
        AppMethodBeat.o(34739);
    }

    @Override // com.tencent.mm.ui.chatting.af
    public final void setIsBottomShowAll(boolean z) {
        AppMethodBeat.i(34740);
        this.Pjt.setIsBottomShowAll(z);
        AppMethodBeat.o(34740);
    }

    @Override // com.tencent.mm.ui.chatting.af
    public final void amn(int i2) {
        AppMethodBeat.i(232898);
        try {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Pjt.getLayoutParams();
            layoutParams.topMargin = i2;
            this.Pjt.setLayoutParams(layoutParams);
            Log.d("MicroMsg.ChattingUIFragment", "setTopMarginHeight height:%s", Integer.valueOf(i2));
            AppMethodBeat.o(232898);
        } catch (Exception e2) {
            Log.e("MicroMsg.ChattingUIFragment", "setTopMarginHeight height:%s, %s, %s", Integer.valueOf(i2), e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(232898);
        }
    }

    @Override // com.tencent.mm.ui.chatting.af
    public final void By(boolean z) {
        AppMethodBeat.i(34741);
        this.Pjt.By(z);
        AppMethodBeat.o(34741);
    }

    @Override // com.tencent.mm.ui.chatting.af
    public final void bs(Bundle bundle) {
        AppMethodBeat.i(34742);
        this.Pjt.bs(bundle);
        AppMethodBeat.o(34742);
    }

    @Override // com.tencent.mm.ui.chatting.af
    public final void gOb() {
        AppMethodBeat.i(34743);
        this.Pjt.Bx(false);
        AppMethodBeat.o(34743);
    }

    @Override // com.tencent.mm.ui.chatting.af
    public final void bt(Bundle bundle) {
        AppMethodBeat.i(34744);
        this.Pjt.c(true, bundle);
        AppMethodBeat.o(34744);
    }

    @Override // com.tencent.mm.ui.chatting.af
    public final int getBottomHeight() {
        AppMethodBeat.i(34745);
        if (this.Pjt == null) {
            AppMethodBeat.o(34745);
            return 0;
        }
        int bottomHeight = this.Pjt.getBottomHeight();
        AppMethodBeat.o(34745);
        return bottomHeight;
    }

    @Override // com.tencent.mm.ui.chatting.af
    public final int getTopHeight() {
        AppMethodBeat.i(34746);
        int topHeight = this.Pjt.getTopHeight();
        AppMethodBeat.o(34746);
        return topHeight;
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final void amo(int i2) {
        AppMethodBeat.i(34747);
        this.Pjq.setVisibility(i2);
        if (Log.getLogLevel() == 2) {
            Log.i("MicroMsg.ChattingUIFragment", "[setListViewVisibility] visibility:" + i2 + " stack:" + Util.getStack().toString());
        }
        AppMethodBeat.o(34747);
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final void gOc() {
        AppMethodBeat.i(34748);
        this.Pjq.setTranscriptMode(0);
        AppMethodBeat.o(34748);
    }

    @Override // android.support.v4.app.Fragment
    public boolean getUserVisibleHint() {
        return this.dom.cQp;
    }

    @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment
    public final w gNg() {
        AppMethodBeat.i(34750);
        if (this.dom.bh(aa.class) == null) {
            AppMethodBeat.o(34750);
            return null;
        }
        w gNg = ((aa) this.dom.bh(aa.class)).gNg();
        AppMethodBeat.o(34750);
        return gNg;
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final void gOe() {
        int i2;
        AppMethodBeat.i(34761);
        am amVar = (am) this.dom.bh(am.class);
        ai aiVar = (ai) this.dom.bh(ai.class);
        if (!amVar.gQZ() && !amVar.gRb() && !amVar.gRc() && !aiVar.gQN()) {
            int i3 = this.ptj;
            this.ptj = i3 + 1;
            if (i3 < 10 && ((thisActivity() instanceof ChattingUI) || (thisActivity() instanceof AppBrandServiceChattingUI))) {
                ListView listView = this.Pjq;
                AnonymousClass8 r3 = new Runnable() {
                    /* class com.tencent.mm.ui.chatting.ChattingUIFragment.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(34711);
                        if (ChattingUIFragment.this.ptd || ChattingUIFragment.this.mScrollState != 0) {
                            ChattingUIFragment.this.ptj = 10;
                            Log.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect userTouched: %s state: %s", Boolean.valueOf(ChattingUIFragment.this.ptd), Integer.valueOf(ChattingUIFragment.this.mScrollState));
                            AppMethodBeat.o(34711);
                            return;
                        }
                        int lastVisiblePosition = ChattingUIFragment.this.Pjq.getLastVisiblePosition();
                        int count = ChattingUIFragment.this.Pjq.getCount() - 1;
                        Log.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect tryScrollTimes : %s, lastvisible/total=%s/%s", Integer.valueOf(ChattingUIFragment.this.ptj), Integer.valueOf(lastVisiblePosition), Integer.valueOf(count));
                        if (lastVisiblePosition < count) {
                            ChattingUIFragment.a(ChattingUIFragment.this, true);
                            ChattingUIFragment.this.gOe();
                            AppMethodBeat.o(34711);
                            return;
                        }
                        ChattingUIFragment.this.ptj = 10;
                        AppMethodBeat.o(34711);
                    }
                };
                if (this.ptj == 1) {
                    i2 = 10;
                } else {
                    i2 = 100;
                }
                listView.postDelayed(r3, (long) i2);
                AppMethodBeat.o(34761);
                return;
            }
        }
        Log.d("MicroMsg.ChattingUIFragment", "scrollToLastProtect:%s, %s ,%s", Boolean.valueOf(amVar.gQZ()), Boolean.valueOf(amVar.gRb()), Integer.valueOf(this.ptj));
        AppMethodBeat.o(34761);
    }

    /* access modifiers changed from: protected */
    public final void gOf() {
        AppMethodBeat.i(34764);
        ((com.tencent.mm.ui.chatting.d.b.as) this.dom.bh(com.tencent.mm.ui.chatting.d.b.as.class)).aL(new Runnable() {
            /* class com.tencent.mm.ui.chatting.ChattingUIFragment.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(34714);
                ChattingUIFragment.this.onExitBegin();
                if (ChattingUIFragment.this.thisActivity() instanceof a.d) {
                    ((a.d) ChattingUIFragment.this.thisActivity()).anz();
                }
                if (ChattingUIFragment.this.isCurrentActivity || !ChattingUIFragment.this.isSupportNavigationSwipeBack()) {
                    ChattingUIFragment.this.gOg();
                    AppMethodBeat.o(34714);
                    return;
                }
                SwipeBackLayout swipeBackLayout = ChattingUIFragment.this.getSwipeBackLayout();
                Log.i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", Boolean.valueOf(swipeBackLayout.hfx), Boolean.valueOf(swipeBackLayout.hfv), Boolean.valueOf(swipeBackLayout.hfw));
                if (!swipeBackLayout.awK()) {
                    com.tencent.mm.ui.widget.h.aq(0.0f);
                    swipeBackLayout.hfx = true;
                    swipeBackLayout.hfw = false;
                    int width = swipeBackLayout.mContentView.getWidth() + swipeBackLayout.hfs.getIntrinsicWidth() + 10;
                    com.tencent.mm.ui.mogic.a aVar = swipeBackLayout.QFb;
                    aVar.WL = swipeBackLayout.mContentView;
                    aVar.mActivePointerId = -1;
                    aVar.b(width, 0, 0, 0, 260);
                    swipeBackLayout.invalidate();
                    if (swipeBackLayout.QFc != null) {
                        swipeBackLayout.QFc.onDrag();
                    }
                    com.tencent.mm.ui.widget.h.h(true, 0);
                }
                AppMethodBeat.o(34714);
            }
        });
        AppMethodBeat.o(34764);
    }

    private boolean gOh() {
        AppMethodBeat.i(34769);
        l lVar = (l) this.dom.bh(l.class);
        am amVar = (am) this.dom.bh(am.class);
        if (lVar.gPB()) {
            if (amVar.gQX()) {
                amVar.gQW();
                lVar.gPC();
            } else {
                lVar.gPz();
            }
            AppMethodBeat.o(34769);
            return true;
        }
        AppMethodBeat.o(34769);
        return false;
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, com.tencent.mm.ui.MMFragment
    public void finish() {
        boolean z;
        AppMethodBeat.i(34770);
        this.dom.Pwb.onFinish();
        u uVar = (u) this.dom.bh(u.class);
        if (!(uVar == null || uVar.gPO() == null)) {
            uVar.gPO().Ak(true);
        }
        if (!hideVKB()) {
            z = false;
        } else {
            z = true;
        }
        AnonymousClass12 r1 = new Runnable() {
            /* class com.tencent.mm.ui.chatting.ChattingUIFragment.AnonymousClass12 */

            public final void run() {
                boolean z = true;
                AppMethodBeat.i(34715);
                Log.i("MicroMsg.ChattingUIFragment", "[finish] isCurrentActivity:%s", Boolean.valueOf(ChattingUIFragment.this.isCurrentActivity));
                if (ChattingUIFragment.this.isCurrentActivity) {
                    ChattingUIFragment.g(ChattingUIFragment.this);
                    AppMethodBeat.o(34715);
                } else if (ChattingUIFragment.this.thisActivity() instanceof LauncherUI) {
                    LauncherUI launcherUI = (LauncherUI) ChattingUIFragment.this.thisActivity();
                    if (launcherUI != null) {
                        if (ChattingUIFragment.this.isSupportNavigationSwipeBack()) {
                            z = false;
                        }
                        launcherUI.closeChatting(z);
                        AppMethodBeat.o(34715);
                        return;
                    }
                    Log.e("MicroMsg.ChattingUIFragment", "LauncherUI is null!???");
                    AppMethodBeat.o(34715);
                } else if (ChattingUIFragment.this.thisActivity() instanceof BaseConversationUI) {
                    BaseConversationUI baseConversationUI = (BaseConversationUI) ChattingUIFragment.this.thisActivity();
                    if (baseConversationUI != null) {
                        if (ChattingUIFragment.this.isSupportNavigationSwipeBack()) {
                            z = false;
                        }
                        baseConversationUI.closeChatting(z);
                    }
                    AppMethodBeat.o(34715);
                } else {
                    if (ChattingUIFragment.this.thisActivity() instanceof a.d) {
                        ((a.d) ChattingUIFragment.this.thisActivity()).anA();
                    }
                    AppMethodBeat.o(34715);
                }
            }
        };
        if (!z) {
            r1.run();
            AppMethodBeat.o(34770);
            return;
        }
        MMHandlerThread.postToMainThreadDelayed(r1, 100);
        AppMethodBeat.o(34770);
    }

    static /* synthetic */ void a(ChattingUIFragment chattingUIFragment, AbsListView absListView, int i2) {
        AppMethodBeat.i(232900);
        if (chattingUIFragment.EOZ != null) {
            chattingUIFragment.EOZ.a(absListView, i2);
        }
        AppMethodBeat.o(232900);
    }

    static /* synthetic */ void a(ChattingUIFragment chattingUIFragment, AbsListView absListView, int i2, int i3) {
        AppMethodBeat.i(232901);
        if (chattingUIFragment.EOZ != null) {
            chattingUIFragment.EOZ.a(absListView, i2, i3);
        }
        AppMethodBeat.o(232901);
    }
}
