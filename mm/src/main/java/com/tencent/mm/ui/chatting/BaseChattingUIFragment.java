package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ol;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.af;
import com.tencent.mm.ui.chatting.d.ag;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.chatting.d.b.n;
import com.tencent.mm.ui.chatting.d.h;
import com.tencent.mm.ui.chatting.d.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.i.b;
import com.tencent.mm.ui.w;
import java.util.Map;

public abstract class BaseChattingUIFragment extends MMFragment implements ae, af {
    protected String PeA;
    private k PeB = new k();
    public boolean PeC = false;
    private int PeD = 0;
    int PeE;
    int PeF;
    protected String Pez;
    private long dUy;
    public a dom = new a(this, this, this);
    private long lastResumeTime;

    public abstract w gNg();

    public abstract boolean gNh();

    @Override // com.tencent.mm.ui.chatting.ae
    public abstract ListView getListView();

    public BaseChattingUIFragment() {
        gMV();
    }

    public BaseChattingUIFragment(boolean z) {
        super(true);
        gMV();
    }

    private void gMV() {
        Bundle bundle = new Bundle();
        if (!bundle.containsKey(getClass().getName())) {
            bundle.putInt(getClass().getName(), Integer.MAX_VALUE);
        }
        setArguments(bundle);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public final void onAttach(Context context) {
        super.onAttach(context);
        this.Pez = getActivity().getClass().getName() + "@" + hashCode() + " @talker:%s";
        kh(context);
        this.dom.a(j.class, this.PeB);
        this.dom.a(n.class, this.dom.Pwb);
        for (h.a aVar : h.getComponents()) {
            this.dom.a(aVar.aWC, aVar.gPt());
        }
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        ViewGroup.LayoutParams layoutParams = onCreateView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        onCreateView.setLayoutParams(layoutParams);
        return onCreateView;
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        gMW();
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public final void onStart() {
        super.onStart();
        Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStart] activity:%s isForeground:%s isFinishing:%s", this.PeA, Boolean.valueOf(this.dom.cQp), Boolean.valueOf(isFinishing()));
        gMX();
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public final void onResume() {
        super.onResume();
        Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onResume] activity:%s isForeground:%s isFinishing:%s", this.PeA, Boolean.valueOf(this.dom.cQp), Boolean.valueOf(isFinishing()));
        gMY();
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public final void onPause() {
        super.onPause();
        Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onPause] activity:%s isForeground:%s isFinishing:%s isExiting:%s", this.PeA, Boolean.valueOf(this.dom.cQp), Boolean.valueOf(isFinishing()), Boolean.valueOf(gNe()));
        gMZ();
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public final void onStop() {
        super.onStop();
        Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s isForeground:%s isFinishing:%s isEntering:%s", this.PeA, Boolean.valueOf(this.dom.cQp), Boolean.valueOf(isFinishing()), Boolean.valueOf(gNf()));
        gNa();
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public final void onDestroy() {
        super.onDestroy();
        Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onDestroy] activity:%s isForeground:%s isFinishing:%s", this.PeA, Boolean.valueOf(this.dom.cQp), Boolean.valueOf(isFinishing()));
        gNb();
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public final void onDetach() {
        super.onDetach();
        gNd();
    }

    public final void gMW() {
        gMJ();
        if (this.isCurrentActivity || this.PeC) {
            onEnterBegin();
        }
    }

    public final void gNb() {
        d(512, new Runnable() {
            /* class com.tencent.mm.ui.chatting.BaseChattingUIFragment.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(34290);
                Log.d("MicroMsg.BaseChattingUIFragment", "fallback for SwipeBack");
                BaseChattingUIFragment.this.amd(512);
                BaseChattingUIFragment.this.onExitBegin();
                AppMethodBeat.o(34290);
            }
        });
        gpe();
        onExitEnd();
    }

    /* access modifiers changed from: protected */
    public void kh(Context context) {
        Log.i("MicroMsg.BaseChattingUIFragment", "[doAttach] activity:%s isPreLoaded:%b", this.PeA, Boolean.valueOf(this.PeC));
    }

    public void gMJ() {
        d(2, new Runnable() {
            /* class com.tencent.mm.ui.chatting.BaseChattingUIFragment.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(34293);
                BaseChattingUIFragment.this.dom.cQp = true;
                BaseChattingUIFragment.this.dom.setFocused(true);
                BaseChattingUIFragment.this.dom.Pwj = false;
                BaseChattingUIFragment.this.dom.BX(false);
                BaseChattingUIFragment.this.dom.Pwl = false;
                BaseChattingUIFragment.this.PeB.gIk();
                Log.i("MicroMsg.BaseChattingUIFragment", "[doCreate] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC));
                AppMethodBeat.o(34293);
            }
        });
    }

    private void gNc() {
        d(4, new Runnable() {
            /* class com.tencent.mm.ui.chatting.BaseChattingUIFragment.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(34294);
                Log.i("MicroMsg.BaseChattingUIFragment", "[doStart] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC));
                AppMethodBeat.o(34294);
            }
        });
    }

    public void doResume() {
        d(8, new Runnable() {
            /* class com.tencent.mm.ui.chatting.BaseChattingUIFragment.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(34295);
                Log.i("MicroMsg.BaseChattingUIFragment", "[doResume] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC));
                BaseChattingUIFragment.this.PeB.cFx();
                BaseChattingUIFragment.this.lastResumeTime = System.currentTimeMillis();
                AppMethodBeat.o(34295);
            }
        });
    }

    public void doPause() {
        d(16, new Runnable() {
            /* class com.tencent.mm.ui.chatting.BaseChattingUIFragment.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(34296);
                Log.i("MicroMsg.BaseChattingUIFragment", "[doPause] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC));
                BaseChattingUIFragment.this.PeB.cFy();
                BaseChattingUIFragment.this.dUy += System.currentTimeMillis() - BaseChattingUIFragment.this.lastResumeTime;
                BaseChattingUIFragment.this.dom.Pwl = true;
                AppMethodBeat.o(34296);
            }
        });
    }

    private void dQn() {
        d(32, new Runnable() {
            /* class com.tencent.mm.ui.chatting.BaseChattingUIFragment.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(34297);
                Log.i("MicroMsg.BaseChattingUIFragment", "[doStop] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC));
                BaseChattingUIFragment.this.dom.Pwl = true;
                AppMethodBeat.o(34297);
            }
        });
    }

    private void gpe() {
        d(64, new Runnable() {
            /* class com.tencent.mm.ui.chatting.BaseChattingUIFragment.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(34298);
                Log.i("MicroMsg.BaseChattingUIFragment", "[doDestroy] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC));
                if (!BaseChattingUIFragment.this.amb(16) || BaseChattingUIFragment.this.amb(8)) {
                    BaseChattingUIFragment.this.dom.cQp = false;
                    BaseChattingUIFragment.this.dom.setFocused(false);
                    BaseChattingUIFragment.this.dom.Pwj = false;
                    BaseChattingUIFragment.this.dom.BX(false);
                    BaseChattingUIFragment.this.PeD = 0;
                    AppMethodBeat.o(34298);
                    return;
                }
                RuntimeException runtimeException = new RuntimeException(String.format("[doDestroy] never doPause, activity:%s isPreLoaded:%b isForeground:%b isFinishing:%b isNeverCreate:%b", BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC), Boolean.valueOf(BaseChattingUIFragment.this.dom.cQp), Boolean.valueOf(BaseChattingUIFragment.this.isFinishing()), Boolean.valueOf(BaseChattingUIFragment.this.amb(2))));
                AppMethodBeat.o(34298);
                throw runtimeException;
            }
        });
    }

    public void gNd() {
        Log.i("MicroMsg.BaseChattingUIFragment", "[doDetach] activity:%s isPreLoaded:%b", this.PeA, Boolean.valueOf(this.PeC));
        for (Map.Entry<Class<? extends af>, af> entry : this.dom.PvZ.PDU.entrySet()) {
            if (entry.getValue() instanceof ag) {
                ((ag) entry.getValue()).gOK();
            }
        }
    }

    public void onEnterBegin() {
        d(128, new Runnable() {
            /* class com.tencent.mm.ui.chatting.BaseChattingUIFragment.AnonymousClass10 */

            public final void run() {
                int i2;
                AppMethodBeat.i(34299);
                Log.i("MicroMsg.BaseChattingUIFragment", "[onEnterBegin] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC));
                BaseChattingUIFragment baseChattingUIFragment = BaseChattingUIFragment.this;
                boolean z = WXHardCoderJNI.hcEnterChattingEnable;
                int i3 = WXHardCoderJNI.hcEnterChattingDelay;
                int i4 = WXHardCoderJNI.hcEnterChattingCPU;
                int i5 = WXHardCoderJNI.hcEnterChattingIO;
                if (WXHardCoderJNI.hcEnterChattingThr) {
                    i2 = g.aAk().getProcessTid();
                } else {
                    i2 = 0;
                }
                baseChattingUIFragment.PeE = WXHardCoderJNI.startPerformance(z, i3, i4, i5, i2, WXHardCoderJNI.hcEnterChattingTimeout, 301, WXHardCoderJNI.hcEnterChattingAction, "ChattingUIFragment");
                BaseChattingUIFragment.this.dom.cQp = true;
                BaseChattingUIFragment.this.dom.setFocused(true);
                BaseChattingUIFragment.this.dom.Pwj = false;
                BaseChattingUIFragment.this.dom.BX(false);
                BaseChattingUIFragment.this.PeB.gIl();
                BaseChattingUIFragment.this.dUy = 0;
                AppMethodBeat.o(34299);
            }
        });
    }

    public final void onEnterEnd() {
        d(256, new Runnable() {
            /* class com.tencent.mm.ui.chatting.BaseChattingUIFragment.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(34300);
                BaseChattingUIFragment.this.PeB.gIm();
                BaseChattingUIFragment baseChattingUIFragment = BaseChattingUIFragment.this;
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEnterChattingEnable, baseChattingUIFragment.PeE);
                baseChattingUIFragment.PeE = 0;
                Log.i("MicroMsg.BaseChattingUIFragment", "[onEnterEnd] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC));
                AppMethodBeat.o(34300);
            }
        });
    }

    public void onExitBegin() {
        d(512, new Runnable() {
            /* class com.tencent.mm.ui.chatting.BaseChattingUIFragment.AnonymousClass2 */

            public final void run() {
                int i2 = 0;
                AppMethodBeat.i(34291);
                Log.i("MicroMsg.BaseChattingUIFragment", "[onExitBegin] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC));
                BaseChattingUIFragment baseChattingUIFragment = BaseChattingUIFragment.this;
                boolean z = WXHardCoderJNI.hcQuitChattingEnable;
                int i3 = WXHardCoderJNI.hcQuitChattingDelay;
                int i4 = WXHardCoderJNI.hcQuitChattingCPU;
                int i5 = WXHardCoderJNI.hcQuitChattingIO;
                if (WXHardCoderJNI.hcQuitChattingThr) {
                    i2 = g.aAk().getProcessTid();
                }
                baseChattingUIFragment.PeF = WXHardCoderJNI.startPerformance(z, i3, i4, i5, i2, WXHardCoderJNI.hcQuitChattingTimeout, 302, WXHardCoderJNI.hcQuitChattingAction, "ChattingUIFragment");
                BaseChattingUIFragment.this.PeB.gIn();
                AppMethodBeat.o(34291);
            }
        });
    }

    public void onExitEnd() {
        d(1024, new Runnable() {
            /* class com.tencent.mm.ui.chatting.BaseChattingUIFragment.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(34292);
                Log.i("MicroMsg.BaseChattingUIFragment", "[onExitEnd] activity:%s isPreLoaded:%b", BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC));
                BaseChattingUIFragment.this.PeB.gIo();
                BaseChattingUIFragment baseChattingUIFragment = BaseChattingUIFragment.this;
                if (baseChattingUIFragment.PeF != 0) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcQuitChattingEnable, baseChattingUIFragment.PeF);
                    baseChattingUIFragment.PeF = 0;
                }
                BaseChattingUIFragment.this.dom.cQp = false;
                BaseChattingUIFragment.this.dom.setFocused(false);
                BaseChattingUIFragment.this.dom.Pwj = false;
                BaseChattingUIFragment.this.dom.BX(false);
                ol olVar = new ol();
                olVar.dUx.action = 1;
                olVar.dUx.username = BaseChattingUIFragment.this.dom.getTalkerUserName();
                olVar.dUx.dUy = BaseChattingUIFragment.this.dUy;
                EventCenter.instance.asyncPublish(olVar, Looper.getMainLooper());
                AppMethodBeat.o(34292);
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        c.a d2;
        super.onActivityResult(i2, i3, intent);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        if (intent == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        Log.i("MicroMsg.BaseChattingUIFragment", "onActivityResult return, requestCode:%d resultCode:%s data is null? %s", objArr);
        if (!this.dom.cQp) {
            Log.w("MicroMsg.BaseChattingUIFragment", "[onActivityResult] not foreground, return, requestCode:%d", Integer.valueOf(i2));
            return;
        }
        Fragment fragment = this.dom.Pwa.getFragment();
        if (!(fragment == null || (d2 = b.d(fragment, i2)) == null)) {
            d2.onActivityResult(i2, i3, intent);
        }
        this.dom.Pwb.onActivityResult(i2, i3, intent);
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.dom.Pwb.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.support.v4.app.Fragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.dom.cQp) {
            this.dom.Pwb.onConfigurationChanged(configuration);
        }
    }

    public final boolean gNe() {
        return amb(1024) && !amb(512);
    }

    private boolean gNf() {
        return amb(256) && !amb(128);
    }

    /* access modifiers changed from: protected */
    public void as(as asVar) {
        this.PeA = String.format(this.Pez, asVar.field_username);
        this.dom.aw(asVar);
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final void addHeaderView(View view) {
        getListView().addHeaderView(view);
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public int getFirstVisiblePosition() {
        return getListView().getFirstVisiblePosition();
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final int getHeaderViewsCount() {
        return getListView().getHeaderViewsCount();
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final int cda() {
        return getListView().getFooterViewsCount();
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final int getLastVisiblePosition() {
        return getListView().getLastVisiblePosition();
    }

    @Override // com.tencent.mm.ui.chatting.ae
    public final View getChildAt(int i2) {
        return getListView().getChildAt(i2);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public boolean supportNavigationSwipeBack() {
        if (this.isCurrentActivity) {
            return false;
        }
        g.aAi();
        if (!com.tencent.mm.compatible.e.b.cv(g.aAe().azG().ca)) {
            return true;
        }
        Log.w("MicroMsg.BaseChattingUIFragment", "Running on a Chromebook, so we not support swipeback and so on");
        return false;
    }

    public com.tencent.mm.ui.chatting.n.a.a gNi() {
        return null;
    }

    public void gNj() {
    }

    public void eGg() {
    }

    @Override // com.tencent.mm.ui.MMFragment
    public String getIdentityString() {
        as asVar = this.dom.GUe;
        if (asVar == null || ((int) asVar.gMZ) == 0 || Util.isNullOrNil(asVar.field_username)) {
            return "";
        }
        if (g.aAc()) {
            if (com.tencent.mm.al.g.DQ(asVar.field_username)) {
                return "_EnterpriseChat";
            }
            if (com.tencent.mm.al.g.Ng(asVar.field_username)) {
                return "_EnterpriseFatherBiz";
            }
            if (com.tencent.mm.al.g.Nf(asVar.field_username)) {
                return "_EnterpriseChildBiz";
            }
        }
        if (asVar.gBM()) {
            return "_bizContact";
        }
        if (ab.Eq(asVar.field_username)) {
            return "_chatroom";
        }
        if (ab.IG(asVar.field_username)) {
            return "_bottle";
        }
        if (ab.IH(asVar.field_username)) {
            return "_QQ";
        }
        return "";
    }

    public final boolean amb(int i2) {
        return (this.PeD & i2) == 0;
    }

    private void amc(int i2) {
        this.PeD |= i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void amd(int i2) {
        this.PeD &= i2 ^ -1;
    }

    private void d(int i2, Runnable runnable) {
        boolean isStrict = isStrict(i2);
        boolean amb = amb(i2);
        if (!amb || !isStrict) {
            Log.w("MicroMsg.BaseChattingUIFragment", "catch! [check] %s flag:%x isNever:%s isStrict:%s", this.PeA, Integer.valueOf(i2), Boolean.valueOf(amb), Boolean.valueOf(isStrict));
            return;
        }
        amc(i2);
        if (2 == i2) {
            amd(64);
        } else if (64 == i2) {
            amd(2);
        } else if (4 == i2) {
            amd(32);
        } else if (32 == i2) {
            amd(4);
        } else if (8 == i2) {
            amd(16);
        } else if (16 == i2) {
            amd(8);
        } else if (128 == i2) {
            amd(256);
        } else if (256 == i2) {
            amd(128);
        } else if (512 == i2) {
            amd(1024);
        } else if (1024 == i2) {
            amd(512);
        }
        runnable.run();
    }

    private boolean isStrict(int i2) {
        if (4 == i2 && amb(2)) {
            return false;
        }
        if (8 == i2 && amb(4)) {
            return false;
        }
        if (16 == i2 && amb(8)) {
            return false;
        }
        if (32 == i2 && amb(4)) {
            return false;
        }
        if (64 == i2 && amb(2)) {
            return false;
        }
        if (512 != i2 || !amb(256)) {
            return true;
        }
        return false;
    }

    public final void gMX() {
        if (this.dom.cQp) {
            gNc();
        }
    }

    public final void gMY() {
        if (this.dom.cQp) {
            doResume();
            if (this.isCurrentActivity || this.PeC) {
                onEnterEnd();
            }
        }
    }

    public final void gMZ() {
        if (this.dom.cQp || isFinishing()) {
            if (amb(8) && !isFinishing() && !gNe()) {
                Log.w("MicroMsg.BaseChattingUIFragment", "[onPause] is never doResume before doPause! Because while entering ChattingUI, the app back to background.");
                doResume();
                onEnterEnd();
            }
            doPause();
        }
    }

    public final void gNa() {
        if ((this.dom.cQp || isFinishing()) && !gNf()) {
            if (amb(16)) {
                Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s is never pause when stop coming!", this.PeA);
                doPause();
            }
            dQn();
        }
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, com.tencent.mm.ui.MMFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return this.dom.Pwb.onKeyDown(i2, keyEvent);
    }
}
