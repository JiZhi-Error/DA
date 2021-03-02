package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.j;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.bb;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.report.service.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.AbstractTabChildActivity;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.c;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.HashSet;

public class MainTabUI {
    private static HashMap<String, Integer> OIk;
    com.tencent.mm.plugin.taskbar.api.a FSw;
    ab OHZ = new ab();
    LauncherUI.d OIa;
    boolean OIb;
    private HashSet<n> OIc = new HashSet<>();
    private int OId = -1;
    private int OIe = -1;
    a OIf;
    IListener OIg = new IListener<bb>() {
        /* class com.tencent.mm.ui.MainTabUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161505);
            this.__eventId = bb.class.getName().hashCode();
            AppMethodBeat.o(161505);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bb bbVar) {
            AppMethodBeat.i(33454);
            int i2 = bbVar.dEk.index;
            if (i2 < 0 || i2 > 3) {
                AppMethodBeat.o(33454);
            } else {
                switch (i2) {
                    case 0:
                        MainTabUI.this.blU("tab_main");
                        break;
                    case 1:
                        MainTabUI.this.blU("tab_address");
                        break;
                    case 2:
                        MainTabUI.this.blU("tab_find_friend");
                        break;
                    case 3:
                        MainTabUI.this.blU("tab_settings");
                        break;
                }
                AppMethodBeat.o(33454);
            }
            return false;
        }
    };
    private boolean OIh = true;
    IListener OIi = new IListener<dq>() {
        /* class com.tencent.mm.ui.MainTabUI.AnonymousClass2 */

        {
            AppMethodBeat.i(161506);
            this.__eventId = dq.class.getName().hashCode();
            AppMethodBeat.o(161506);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dq dqVar) {
            AppMethodBeat.i(33455);
            dq dqVar2 = dqVar;
            Log.i("MicroMsg.LauncherUI.MainTabUI", "alvinluo EnableMainBottomTabSwitchEvent enable: %b", Boolean.valueOf(dqVar2.dGE.enable));
            MainTabUI.this.OIh = dqVar2.dGE.enable;
            MainTabUI.b(MainTabUI.this, MainTabUI.this.OIh);
            AppMethodBeat.o(33455);
            return true;
        }
    };
    IListener OIj = new IListener<jy>() {
        /* class com.tencent.mm.ui.MainTabUI.AnonymousClass3 */

        {
            AppMethodBeat.i(179843);
            this.__eventId = jy.class.getName().hashCode();
            AppMethodBeat.o(179843);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(jy jyVar) {
            AppMethodBeat.i(179844);
            jy jyVar2 = jyVar;
            jyVar2.dOR.dOS = MainTabUI.this.OHZ.gJh();
            Log.d("MicroMsg.LauncherUI.MainTabUI", "alvinluo getTitleUnReadCount: %d", Integer.valueOf(jyVar2.dOR.dOS));
            AppMethodBeat.o(179844);
            return true;
        }
    };
    public HashMap<Integer, MMFragment> OIl = new HashMap<>();
    public int acm = -1;
    private int acn = -1;
    private final long jpE = 180000;
    TabsAdapter mTabsAdapter;
    CustomViewPager mViewPager;
    MMFragmentActivity uLr;

    public interface a {
        void akP(int i2);

        void akQ(int i2);

        void awZ(int i2);

        void axa(int i2);

        void z(int i2, float f2);
    }

    public MainTabUI() {
        AppMethodBeat.i(33466);
        AppMethodBeat.o(33466);
    }

    static /* synthetic */ void b(MainTabUI mainTabUI, boolean z) {
        AppMethodBeat.i(232647);
        mainTabUI.setCanSlide(z);
        AppMethodBeat.o(232647);
    }

    public final MMFragment gIX() {
        AppMethodBeat.i(33467);
        MMFragment mMFragment = this.OIl.get(Integer.valueOf(this.acm));
        AppMethodBeat.o(33467);
        return mMFragment;
    }

    public final void alb(int i2) {
        AppMethodBeat.i(33468);
        MainUI mainUI = (MainUI) this.OIl.get(0);
        if (mainUI != null) {
            mainUI.alb(i2);
        }
        AppMethodBeat.o(33468);
    }

    public final void cpB() {
        AppMethodBeat.i(33469);
        EventCenter.instance.removeListener(this.OIg);
        EventCenter.instance.removeListener(this.OIi);
        EventCenter.instance.removeListener(this.OIj);
        gIY();
        AppMethodBeat.o(33469);
    }

    private void gIY() {
        AppMethodBeat.i(33470);
        this.OIl.clear();
        if (this.mViewPager != null) {
            this.mViewPager.setCanSlide(false);
            this.mViewPager.setCanSlideBySide(false);
        }
        AppMethodBeat.o(33470);
    }

    /* access modifiers changed from: package-private */
    public final void setCanSlide(boolean z) {
        AppMethodBeat.i(232645);
        this.mViewPager.setCanSlide(z);
        AppMethodBeat.o(232645);
    }

    public final void gIb() {
        AppMethodBeat.i(33471);
        MainUI mainUI = (MainUI) this.OIl.get(0);
        if (mainUI != null) {
            mainUI.gUq();
            mainUI.gVW();
        }
        AppMethodBeat.o(33471);
    }

    public final void gIZ() {
        AppMethodBeat.i(33472);
        MainUI mainUI = (MainUI) this.OIl.get(0);
        if (mainUI != null) {
            mainUI.gVX();
        }
        AppMethodBeat.o(33472);
    }

    public final void kP(int i2, int i3) {
        AppMethodBeat.i(33473);
        if (i2 == i3) {
            AppMethodBeat.o(33473);
            return;
        }
        MMFragment alf = alf(i2);
        if (alf != null && (alf instanceof n)) {
            ((n) alf).gHF();
        }
        MMFragment alf2 = alf(i3);
        if (alf2 != null && (alf2 instanceof n)) {
            ((n) alf2).gHE();
        }
        k.a(this.uLr, 4, i2, "deliverOnTabChange");
        k.a(this.uLr, 3, i3, "deliverOnTabChange");
        AppMethodBeat.o(33473);
    }

    public final void alc(int i2) {
        AppMethodBeat.i(33474);
        Log.i("MicroMsg.LauncherUI.MainTabUI", "deliverOnTabResume %s", Integer.valueOf(i2));
        MMFragment alf = alf(i2);
        if (alf == null) {
            AppMethodBeat.o(33474);
            return;
        }
        if (alf instanceof n) {
            ((n) alf).gGH();
        }
        this.mTabsAdapter.mFragmentResumedFlags[i2] = true;
        AppMethodBeat.o(33474);
    }

    public final void gHX() {
        AppMethodBeat.i(33475);
        MainUI mainUI = (MainUI) this.OIl.get(0);
        ViewGroup viewGroup = (ViewGroup) this.uLr.findViewById(R.id.e8x);
        if (viewGroup != null) {
            viewGroup.setImportantForAccessibility(4);
        }
        if (mainUI != null) {
            mainUI.onHiddenChanged(true);
        }
        k.a(this.uLr, 4, this.acm, "prepareStartChatting");
        gIZ();
        this.OHZ.gJb();
        AppMethodBeat.o(33475);
    }

    public final void gJa() {
        AppMethodBeat.i(33476);
        if (this.acm != 0 || !g.aAg().hqi.foreground) {
            bg.getNotification().dh(false);
        } else {
            bg.getNotification().dh(true);
        }
        ViewGroup viewGroup = (ViewGroup) this.uLr.findViewById(R.id.e8x);
        if (viewGroup != null) {
            viewGroup.setImportantForAccessibility(1);
        }
        gIb();
        k.a(this.uLr, 3, this.acm, "prepareCloseChatting");
        MainUI mainUI = (MainUI) this.OIl.get(0);
        if (mainUI != null) {
            mainUI.getContentView();
            if (mainUI.mController != null) {
                mainUI.mController.onResume();
            }
            mainUI.onHiddenChanged(false);
        }
        i.CyW.tN(true);
        AppMethodBeat.o(33476);
    }

    public class TabsAdapter extends j implements ViewPager.OnPageChangeListener, c.a {
        private byte _hellAccFlag_;
        private AddressUI.AddressUIFragment addressFragment;
        private int clickCount = 0;
        private boolean isTabClicked = false;
        boolean[] mFragmentResumedFlags = {true, false, false, false};
        private final WxViewPager mViewPager;

        public TabsAdapter(FragmentActivity fragmentActivity, WxViewPager wxViewPager) {
            super(fragmentActivity.getSupportFragmentManager());
            AppMethodBeat.i(33457);
            this.mViewPager = wxViewPager;
            this.mViewPager.setAdapter(this);
            this.mViewPager.setOnPageChangeListener(this);
            AppMethodBeat.o(33457);
        }

        @Override // android.support.v4.view.q
        public int getCount() {
            return 4;
        }

        @Override // android.support.v4.app.j
        public Fragment getItem(int i2) {
            AppMethodBeat.i(33458);
            MMFragment alf = MainTabUI.this.alf(i2);
            AppMethodBeat.o(33458);
            return alf;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(final int i2, float f2, int i3) {
            AppMethodBeat.i(33459);
            ab abVar = MainTabUI.this.OHZ;
            if (abVar.OIo != null) {
                abVar.OIo.p(i2, f2);
            }
            if (MainTabUI.this.OIf != null) {
                MainTabUI.this.OIf.z(i2, f2);
            }
            if (0.0f != f2) {
                if (this.addressFragment == null) {
                    this.addressFragment = (AddressUI.AddressUIFragment) MainTabUI.this.alf(1);
                }
                this.addressFragment.Cl(false);
            } else {
                Log.v("MicroMsg.LauncherUI.MainTabUI", "onPageScrolled, position = %d, mLastIndex = %d", Integer.valueOf(i2), Integer.valueOf(MainTabUI.this.acn));
                if (-1 == MainTabUI.this.acn) {
                    MainTabUI.this.kP(MainTabUI.this.acn, MainTabUI.this.acm);
                    MainTabUI.this.alc(i2);
                } else {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.ui.MainTabUI.TabsAdapter.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(33456);
                            MainTabUI.this.kP(MainTabUI.this.acn, MainTabUI.this.acm);
                            MainTabUI.this.alc(i2);
                            AppMethodBeat.o(33456);
                        }
                    });
                }
            }
            fixAndroidOProgressBarOutScreenFlashProblem(i2, f2, i3);
            AppMethodBeat.o(33459);
        }

        private void fixAndroidOProgressBarOutScreenFlashProblem(int i2, float f2, int i3) {
            AppMethodBeat.i(33460);
            if (i3 == 0) {
                for (Integer num : MainTabUI.OIk.values()) {
                    if (num.intValue() != i2) {
                        setFragmentLoadingIconVisibility(num.intValue(), 8);
                    } else if (!this.mFragmentResumedFlags[num.intValue()]) {
                        setFragmentLoadingIconVisibility(num.intValue(), 0);
                    }
                }
                AppMethodBeat.o(33460);
                return;
            }
            for (Integer num2 : MainTabUI.OIk.values()) {
                if (num2.intValue() != i2 && !this.mFragmentResumedFlags[num2.intValue()]) {
                    setFragmentLoadingIconVisibility(num2.intValue(), 0);
                }
            }
            AppMethodBeat.o(33460);
        }

        private void setFragmentLoadingIconVisibility(int i2, int i3) {
            View findViewById;
            AppMethodBeat.i(33461);
            if (!(MainTabUI.this.alf(i2) == null || MainTabUI.this.alf(i2).getActivity() == null || (findViewById = MainTabUI.this.alf(i2).findViewById(R.id.epr)) == null)) {
                findViewById.setVisibility(i3);
            }
            AppMethodBeat.o(33461);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            AppMethodBeat.i(33462);
            b bVar = new b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V", this, bVar.axR());
            Log.d("MicroMsg.LauncherUI.MainTabUI", "on page selected changed to %d", Integer.valueOf(i2));
            if (!g.aAf().azp()) {
                Log.i("MicroMsg.LauncherUI.MainTabUI", "on page position %d selected, but account not initialized.", Integer.valueOf(i2));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V");
                AppMethodBeat.o(33462);
                return;
            }
            switch (i2) {
                case 2:
                    com.tencent.mm.plugin.newtips.a.exl().TC(2);
                    ((aj) g.ah(aj.class)).getRedDotManager().asV("Discovery");
                    break;
                case 3:
                    com.tencent.mm.plugin.newtips.a.exl().TC(1);
                    break;
            }
            reportSwitch(i2);
            MainTabUI.this.acn = MainTabUI.this.acm;
            MainTabUI.this.acm = i2;
            MainTabUI.this.OHZ.alg(i2);
            MainTabUI.this.uLr.supportInvalidateOptionsMenu();
            MMFragment alf = MainTabUI.this.alf(MainTabUI.this.acm);
            if (MainTabUI.this.acn == 1 && MainTabUI.this.acm != 1) {
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(340226, Long.valueOf(System.currentTimeMillis()));
            }
            if (MainTabUI.this.acm == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                bg.aVF();
                if (currentTimeMillis - Util.nullAs((Long) com.tencent.mm.model.c.azQ().get(340226, (Object) null), 0) >= 180000) {
                    ((AddressUI.AddressUIFragment) alf).gUs();
                }
            }
            if (MainTabUI.this.acm == 0) {
                bg.getNotification().dh(true);
            } else {
                bg.getNotification().dh(false);
            }
            if (!(alf == null || !com.tencent.matrix.b.isInstalled() || alf.getActivity() == null)) {
                com.tencent.matrix.a.INSTANCE.eg(alf.getActivity().getClass().getName() + "#" + alf.getClass().getSimpleName());
            }
            if (MainTabUI.this.OIf != null) {
                MainTabUI.this.OIf.akP(MainTabUI.this.acm);
            }
            kt ktVar = new kt();
            ktVar.dPO.currentIndex = MainTabUI.this.acm;
            EventCenter.instance.publish(ktVar);
            if (ao.gJN() && aw.b(aw.gWy(), MainTabUI.this.uLr.getTaskId()) && aw.a(aw.gWy(), MainTabUI.this.uLr.getTaskId()) != 1) {
                Intent intent = new Intent(MainTabUI.this.uLr, EmptyActivity.class);
                MMFragmentActivity mMFragmentActivity = MainTabUI.this.uLr;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(mMFragmentActivity, bl.axQ(), "com/tencent/mm/ui/MainTabUI$TabsAdapter", "onPageSelected", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                mMFragmentActivity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(mMFragmentActivity, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "onPageSelected", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                Log.i("MicroMsg.LauncherUI.MainTabUI", "start empty activity");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V");
            AppMethodBeat.o(33462);
        }

        private void reportSwitch(int i2) {
            boolean z = true;
            AppMethodBeat.i(33463);
            Log.v("MicroMsg.LauncherUI.MainTabUI", "reportSwitch clickCount:%d, pos:%d", Integer.valueOf(this.clickCount), Integer.valueOf(i2));
            i iVar = i.CyW;
            if (i2 != 0) {
                z = false;
            }
            iVar.tN(z);
            if (this.clickCount <= 0) {
                switch (i2) {
                    case 0:
                        h.INSTANCE.kvStat(10957, "5");
                        break;
                    case 1:
                        h.INSTANCE.kvStat(10957, "6");
                        break;
                    case 2:
                        h.INSTANCE.kvStat(10957, "7");
                        break;
                }
            } else {
                this.clickCount--;
                switch (i2) {
                    case 0:
                        h.INSTANCE.kvStat(10957, "1");
                        break;
                    case 1:
                        h.INSTANCE.kvStat(10957, "2");
                        break;
                    case 2:
                        h.INSTANCE.kvStat(10957, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                        break;
                    case 3:
                        h.INSTANCE.kvStat(10957, "4");
                        break;
                }
            }
            this.isTabClicked = false;
            AppMethodBeat.o(33463);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            AppMethodBeat.i(33464);
            b bVar = new b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageScrollStateChanged", "(I)V", this, bVar.axR());
            Log.d("MicroMsg.LauncherUI.MainTabUI", "onPageScrollStateChanged state %d", Integer.valueOf(i2));
            if (i2 == 0 && this.addressFragment != null) {
                this.addressFragment.Cl(true);
                this.addressFragment = null;
            }
            if (MainTabUI.this.OIf != null) {
                MainTabUI.this.OIf.akQ(i2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageScrollStateChanged", "(I)V");
            AppMethodBeat.o(33464);
        }

        @Override // com.tencent.mm.ui.c.a
        public void onTabClick(int i2) {
            AppMethodBeat.i(33465);
            if (!MainTabUI.this.OIh) {
                Log.i("MicroMsg.LauncherUI.MainTabUI", "alvinluo now cannot change tab");
                AppMethodBeat.o(33465);
            } else if (i2 == MainTabUI.this.acm) {
                Log.d("MicroMsg.LauncherUI.MainTabUI", "on click same index");
                MMFragment alf = MainTabUI.this.alf(i2);
                if (alf instanceof AbstractTabChildActivity.AbStractTabFragment) {
                    ((AbstractTabChildActivity.AbStractTabFragment) alf).gGA();
                }
                AppMethodBeat.o(33465);
            } else {
                this.isTabClicked = true;
                this.clickCount++;
                Log.v("MicroMsg.LauncherUI.MainTabUI", "onTabClick count:%d", Integer.valueOf(this.clickCount));
                this.mViewPager.setCurrentItem(i2, false);
                if (i2 == 3) {
                    com.tencent.mm.y.c.axV().cQ(262145, 266241);
                    com.tencent.mm.y.c.axV().cQ(262156, 266241);
                    com.tencent.mm.y.c.axV().cQ(262147, 266241);
                    com.tencent.mm.y.c.axV().cQ(262149, 266241);
                    com.tencent.mm.y.c.axV().cQ(262152, 266241);
                    com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266241);
                    com.tencent.mm.y.c.axV().c(ar.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, ar.a.USERINFO_NEW_BANDAGE_WATCHER_ME_TAB_STRING_SYNC);
                    boolean axS = com.tencent.mm.y.c.axV().axS();
                    if (axS) {
                        com.tencent.mm.y.c.axV().B(352280, false);
                    }
                    boolean cP = com.tencent.mm.y.c.axV().cP(262156, 266241);
                    h hVar = h.INSTANCE;
                    Object[] objArr = new Object[5];
                    objArr[0] = 6;
                    objArr[1] = Integer.valueOf(cP ? 1 : 0);
                    objArr[2] = "";
                    objArr[3] = "";
                    objArr[4] = 0;
                    hVar.a(14872, objArr);
                    g.aAi();
                    g.aAh().azQ().set(ar.a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_BOOLEAN_SYNC, Boolean.FALSE);
                    ((com.tencent.mm.plugin.textstatus.a.c) g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).report22208(axS ? 7 : 8, "");
                }
                AppMethodBeat.o(33465);
            }
        }
    }

    static {
        AppMethodBeat.i(33486);
        HashMap<String, Integer> hashMap = new HashMap<>();
        OIk = hashMap;
        hashMap.put("tab_main", 0);
        OIk.put("tab_address", 1);
        OIk.put("tab_find_friend", 2);
        OIk.put("tab_settings", 3);
        AppMethodBeat.o(33486);
    }

    public final void blU(String str) {
        AppMethodBeat.i(33477);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(33477);
            return;
        }
        ale(OIk.get(str).intValue());
        AppMethodBeat.o(33477);
    }

    private MMFragment ald(int i2) {
        AppMethodBeat.i(33478);
        MMFragment mMFragment = null;
        Bundle bundle = new Bundle();
        switch (i2) {
            case 0:
                bundle.putInt(MainUI.class.getName(), 0);
                mMFragment = (MMFragment) Fragment.instantiate(this.uLr, MainUI.class.getName(), bundle);
                if (mMFragment instanceof MainUI) {
                    MainUI mainUI = (MainUI) mMFragment;
                    MMFragmentActivity mMFragmentActivity = this.uLr;
                    mainUI.Dpx = mMFragmentActivity;
                    if (mainUI.QfG != null) {
                        mainUI.QfG.setActivity(mMFragmentActivity);
                    }
                    MainUI mainUI2 = (MainUI) mMFragment;
                    com.tencent.mm.plugin.taskbar.api.a aVar = this.FSw;
                    mainUI2.QfN = aVar;
                    if (mainUI2.QfG != null) {
                        mainUI2.QfG.setActionBarUpdateCallback(aVar);
                    }
                }
                bg.getNotification().dh(true);
                break;
            case 1:
                bundle.putInt(AddressUI.AddressUIFragment.class.getName(), 1);
                bundle.putBoolean("Need_Voice_Search", true);
                bundle.putBoolean("favour_include_biz", true);
                mMFragment = (MMFragment) Fragment.instantiate(this.uLr, AddressUI.AddressUIFragment.class.getName(), bundle);
                break;
            case 2:
                bundle.putInt(FindMoreFriendsUI.class.getName(), 2);
                mMFragment = (MMFragment) Fragment.instantiate(this.uLr, FindMoreFriendsUI.class.getName(), bundle);
                break;
            case 3:
                bundle.putInt(MoreTabUI.class.getName(), 3);
                mMFragment = (MMFragment) Fragment.instantiate(this.uLr, MoreTabUI.class.getName(), bundle);
                break;
        }
        Log.i("MicroMsg.LauncherUI.MainTabUI", "createFragment index:%d", Integer.valueOf(i2));
        if (mMFragment != null) {
            mMFragment.setParent(this.uLr);
        }
        AppMethodBeat.o(33478);
        return mMFragment;
    }

    public final void ale(int i2) {
        AppMethodBeat.i(33479);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(this.acm);
        objArr[2] = Boolean.valueOf(this.mViewPager != null);
        objArr[3] = Integer.valueOf(this.OIl.size());
        Log.i("MicroMsg.LauncherUI.MainTabUI", "change tab to %d, cur tab %d, has init tab %B, tab cache size %d", objArr);
        if (this.mViewPager == null || i2 < 0 || (this.mTabsAdapter != null && i2 > this.mTabsAdapter.getCount() - 1)) {
            AppMethodBeat.o(33479);
        } else if (this.acm != i2 || this.OIl.size() == 0) {
            int i3 = this.acm;
            this.acm = i2;
            this.OHZ.alg(this.acm);
            if (this.mViewPager != null) {
                if (i3 == -1) {
                    this.mViewPager.setCurrentItemNotify(this.acm, false);
                } else {
                    this.mViewPager.setCurrentItem(this.acm, false);
                }
                alc(this.acm);
            }
            if (this.acm != 0 || !com.tencent.matrix.a.INSTANCE.cPB) {
                bg.getNotification().dh(false);
            } else {
                bg.getNotification().dh(true);
            }
            if (this.acm != 0) {
                MMFragment alf = alf(0);
                if (alf instanceof MainUI) {
                    ((MainUI) alf).gVY();
                }
            }
            AppMethodBeat.o(33479);
        } else {
            AppMethodBeat.o(33479);
        }
    }

    public final MMFragment alf(int i2) {
        AppMethodBeat.i(33480);
        if (i2 < 0) {
            AppMethodBeat.o(33480);
            return null;
        } else if (this.OIl.containsKey(Integer.valueOf(i2))) {
            MMFragment mMFragment = this.OIl.get(Integer.valueOf(i2));
            AppMethodBeat.o(33480);
            return mMFragment;
        } else {
            Log.i("MicroMsg.LauncherUI.MainTabUI", "create tab %d", Integer.valueOf(i2));
            MMFragment ald = ald(i2);
            this.OIl.put(Integer.valueOf(i2), ald);
            AppMethodBeat.o(33480);
            return ald;
        }
    }

    /* access modifiers changed from: protected */
    public final void gJb() {
        AppMethodBeat.i(33481);
        this.OHZ.gJb();
        AppMethodBeat.o(33481);
    }

    /* access modifiers changed from: protected */
    public final void gJc() {
        AppMethodBeat.i(33482);
        this.OHZ.gJc();
        AppMethodBeat.o(33482);
    }

    /* access modifiers changed from: protected */
    public final void gJd() {
        AppMethodBeat.i(33483);
        this.OHZ.gJd();
        AppMethodBeat.o(33483);
    }

    public final void gJe() {
        AppMethodBeat.i(232646);
        com.tencent.f.h.RTc.d(new Runnable() {
            /* class com.tencent.mm.ui.ab.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(33493);
                long currentTimeMillis = System.currentTimeMillis();
                final int gVB = com.tencent.mm.ui.conversation.h.gVB();
                com.tencent.f.h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.ui.ab.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(232648);
                        ab abVar = ab.this;
                        int i2 = gVB;
                        if (abVar.OIo != null) {
                            abVar.OIo.akH(i2);
                            abVar.OIn.gIa();
                        }
                        AppMethodBeat.o(232648);
                    }
                });
                Log.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "unreadcheck setConversationTagUnread  last time %d, unread %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(gVB));
                AppMethodBeat.o(33493);
            }
        }, "setConversationTagUnread");
        AppMethodBeat.o(232646);
    }

    public final void gJf() {
        AppMethodBeat.i(33485);
        this.OIl.get(0);
        AppMethodBeat.o(33485);
    }
}
