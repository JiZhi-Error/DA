package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.bv;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.profile.FinderProfileAtFeedFragment;
import com.tencent.mm.plugin.finder.profile.FinderProfileFeedFragment;
import com.tencent.mm.plugin.finder.profile.FinderProfileMegaVideoFragment;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 A2\u00020\u0001:\u0005ABCDEB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010$\u001a\u00020%H\u0002J\u0006\u0010&\u001a\u00020%J\b\u0010'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020\bH\u0002J\u0012\u0010)\u001a\u00020\b2\b\b\u0002\u0010*\u001a\u00020\bH\u0002J\b\u0010+\u001a\u00020\bH\u0002J\b\u0010,\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020%H\u0016J\f\u0010.\u001a\u00060/R\u00020\u0000H\u0016J\u001e\u00100\u001a\u000201\"\b\b\u0000\u00102*\u0002012\f\u00103\u001a\b\u0012\u0004\u0012\u0002H204J\b\u00105\u001a\u00020\bH\u0002J\b\u00106\u001a\u00020\bH\u0002J\b\u00107\u001a\u00020\bH\u0002J\u0012\u00108\u001a\u00020%2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020%H\u0016J\b\u0010<\u001a\u00020%H\u0016J\u0010\u0010=\u001a\u00020%2\b\b\u0002\u0010>\u001a\u00020\bJ\u0010\u0010?\u001a\u00020%2\b\b\u0002\u0010>\u001a\u00020\bJ\u0012\u0010@\u001a\u00020%2\b\b\u0002\u0010>\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u001b\u0010\f\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\f\u0010\nR\u001b\u0010\u000f\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u000f\u0010\nR\u001b\u0010\u0011\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0011\u0010\nR#\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\n \u0015*\u0004\u0018\u00010\u001e0\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020\u001e8FX\u0002¢\u0006\f\n\u0004\b#\u0010\u000e\u001a\u0004\b!\u0010\"¨\u0006F"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "atFeedLoader", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "checkMusicFirstPage", "", "isNoSeeAtTab", "()Z", "isPrivateAccount", "isSelf", "isSelf$delegate", "Lkotlin/Lazy;", "isSelfFlag", "isSelfFlag$delegate", "isSelfScene", "isSelfScene$delegate", "line", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getLine", "()Landroid/view/View;", "line$delegate", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "selfUserName", "", "targetUsername", ch.COL_USERNAME, "getUsername", "()Ljava/lang/String;", "username$delegate", "addAtFeedFragment", "", "addMegaVideoFragment", "addMusicFragment", "checkHasAtFeed", "checkHasMegaVideoItem", "checkFirstPage", "checkHasMusic", "checkMusicTab", "checkTabLayoutVisibility", "generateProvider", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$Provider;", "getFragmentBy", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "T", "clazz", "Ljava/lang/Class;", "isEnableShowAtFeedFragment", "isPostingMvExist", "isShouldAddDraftTab", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "removeAtFeedFragment", "clearCache", "removeMegaVideoFragment", "removeMusicFragment", "Companion", "Provider", "Tab", "TabContainer", "TabViewAction", "plugin-finder_release"})
public final class FinderProfileTabUIC extends FinderTabUIC {
    public static final a vcI = new a((byte) 0);
    private final kotlin.f tZk = kotlin.g.ah(new s(this));
    private final kotlin.f tZl = kotlin.g.ah(new k(this));
    private final String tvp;
    private final kotlin.f vag = kotlin.g.ah(new j(this));
    private boolean vcD;
    private final kotlin.f vcE = kotlin.g.ah(new l(this));
    private final kotlin.f vcF;
    private FinderAtFeedLoader vcG;
    private final String vcH;

    static {
        AppMethodBeat.i(250494);
        AppMethodBeat.o(250494);
    }

    private boolean dns() {
        AppMethodBeat.i(250476);
        boolean booleanValue = ((Boolean) this.vcE.getValue()).booleanValue();
        AppMethodBeat.o(250476);
        return booleanValue;
    }

    private View dnt() {
        AppMethodBeat.i(250477);
        View view = (View) this.vcF.getValue();
        AppMethodBeat.o(250477);
        return view;
    }

    public final String getUsername() {
        AppMethodBeat.i(250473);
        String str = (String) this.tZk.getValue();
        AppMethodBeat.o(250473);
        return str;
    }

    public final boolean isSelf() {
        AppMethodBeat.i(250475);
        boolean booleanValue = ((Boolean) this.vag.getValue()).booleanValue();
        AppMethodBeat.o(250475);
        return booleanValue;
    }

    public final boolean isSelfFlag() {
        AppMethodBeat.i(250474);
        boolean booleanValue = ((Boolean) this.tZl.getValue()).booleanValue();
        AppMethodBeat.o(250474);
        return booleanValue;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$onCreate$5$1"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderProfileTabUIC vcJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(FinderProfileTabUIC finderProfileTabUIC) {
            super(1);
            this.vcJ = finderProfileTabUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            AppMethodBeat.i(250466);
            IResponse<bo> iResponse2 = iResponse;
            kotlin.g.b.p.h(iResponse2, LocaleUtil.ITALIAN);
            boolean b2 = FinderProfileTabUIC.b(this.vcJ);
            StringBuilder append = new StringBuilder("[refreshCallback] isEnableShowAtFeedFragment=").append(b2).append(" targetUsername=").append(this.vcJ.tvp).append(" errType=").append(iResponse2.getErrType()).append(" errCode=").append(iResponse2.getErrCode()).append(" size=");
            List<bo> incrementList = iResponse2.getIncrementList();
            Log.i("Finder.FinderProfileTabUIC", append.append(incrementList != null ? Integer.valueOf(incrementList.size()) : null).toString());
            if (b2) {
                List<bo> incrementList2 = iResponse2.getIncrementList();
                if (!(incrementList2 == null || incrementList2.isEmpty())) {
                    FinderProfileTabUIC.e(this.vcJ);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(250466);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderProfileTabUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        boolean z;
        kotlin.g.b.p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(250493);
        this.vcF = kotlin.g.ah(new m(appCompatActivity));
        StringBuilder append = new StringBuilder("[Provider] username=").append(getUsername()).append(" isSelf=").append(isSelf()).append(" isSelfFlag=").append(isSelfFlag()).append(" isNoSeeAtTab=").append(dnu()).append(" isPrivateAccount=").append(dnv()).append(" profileContact=");
        if (getProfileContact() != null) {
            z = true;
        } else {
            z = false;
        }
        Log.i("Finder.FinderProfileTabUIC", append.append(z).toString());
        String stringExtra = appCompatActivity.getIntent().getStringExtra("finder_username");
        this.tvp = stringExtra == null ? "" : stringExtra;
        this.vcH = z.aUg();
        AppMethodBeat.o(250493);
    }

    public static final /* synthetic */ boolean b(FinderProfileTabUIC finderProfileTabUIC) {
        AppMethodBeat.i(250496);
        boolean dnw = finderProfileTabUIC.dnw();
        AppMethodBeat.o(250496);
        return dnw;
    }

    public static final /* synthetic */ void e(FinderProfileTabUIC finderProfileTabUIC) {
        AppMethodBeat.i(250498);
        finderProfileTabUIC.dnz();
        AppMethodBeat.o(250498);
    }

    public static final /* synthetic */ boolean i(FinderProfileTabUIC finderProfileTabUIC) {
        AppMethodBeat.i(261314);
        boolean hUE = finderProfileTabUIC.hUE();
        AppMethodBeat.o(261314);
        return hUE;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final com.tencent.mm.plugin.finder.api.g getProfileContact() {
        AppMethodBeat.i(250478);
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(getUsername());
        AppMethodBeat.o(250478);
        return asG;
    }

    private boolean dnu() {
        AppMethodBeat.i(250479);
        y yVar = y.vXH;
        boolean awr = y.awr(getUsername());
        AppMethodBeat.o(250479);
        return awr;
    }

    private boolean dnv() {
        AppMethodBeat.i(250480);
        y yVar = y.vXH;
        boolean i2 = y.i(getProfileContact());
        AppMethodBeat.o(250480);
        return i2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$Provider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC;)V", "isDynamic", "", "plugin-finder_release"})
    public final class b extends FinderTabProvider {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            AppMethodBeat.i(250454);
            setTabContainer(new d());
            setTabViewAction(new e());
            boolean i2 = FinderProfileTabUIC.i(FinderProfileTabUIC.this);
            LinkedList linkedList = new LinkedList();
            linkedList.add(new c(R.string.d8r));
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dvJ().value().intValue() == 1) {
                linkedList.add(new c(R.string.d_v));
            }
            if (FinderProfileTabUIC.b(FinderProfileTabUIC.this)) {
                linkedList.add(new c(R.string.d8p));
            }
            if (FinderProfileTabUIC.c(FinderProfileTabUIC.this)) {
                linkedList.add(new c(R.string.d70));
            }
            if (FinderProfileTabUIC.this.isSelf() && i2) {
                linkedList.add(new c(R.string.d6o));
            }
            setTabs(linkedList);
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(new FinderProfileFeedFragment());
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dvJ().value().intValue() == 1) {
                linkedList2.add(new FinderProfileMegaVideoFragment());
            }
            if (FinderProfileTabUIC.b(FinderProfileTabUIC.this)) {
                linkedList2.add(new FinderProfileAtFeedFragment());
            }
            if (FinderProfileTabUIC.c(FinderProfileTabUIC.this)) {
                linkedList2.add(new FinderProfileMusicFragment());
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                FinderProfileEduUIC.a((FinderProfileEduUIC) com.tencent.mm.ui.component.a.b(FinderProfileTabUIC.this.getActivity()).get(FinderProfileEduUIC.class), "mvtab", 0, null, 6);
            }
            if (FinderProfileTabUIC.this.isSelf() && i2) {
                linkedList2.add(new FinderProfileDraftFragment());
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                FinderProfileEduUIC.a((FinderProfileEduUIC) com.tencent.mm.ui.component.a.b(FinderProfileTabUIC.this.getActivity()).get(FinderProfileEduUIC.class), "drafttab", 0, null, 6);
            }
            setFragments(linkedList2);
            AppMethodBeat.o(250454);
        }

        @Override // com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider, com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider
        public final boolean isDynamic() {
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (com.tencent.mm.plugin.finder.upload.action.g.dBr().asJ(r3.tvp) != false) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        if (dnu() == false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean dnw() {
        /*
            r3 = this;
            r2 = 250481(0x3d271, float:3.50999E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            boolean r0 = r3.dns()
            if (r0 == 0) goto L_0x0012
            boolean r0 = r3.dnu()
            if (r0 == 0) goto L_0x0038
        L_0x0012:
            boolean r0 = r3.dns()
            if (r0 != 0) goto L_0x003d
            boolean r0 = r3.dnv()
            if (r0 == 0) goto L_0x0032
            boolean r0 = r3.dnv()
            if (r0 == 0) goto L_0x003d
            com.tencent.mm.plugin.finder.upload.action.g$a r0 = com.tencent.mm.plugin.finder.upload.action.g.vUn
            com.tencent.mm.plugin.finder.upload.action.g r0 = com.tencent.mm.plugin.finder.upload.action.g.dBr()
            java.lang.String r1 = r3.tvp
            boolean r0 = r0.asJ(r1)
            if (r0 == 0) goto L_0x003d
        L_0x0032:
            boolean r0 = r3.dnu()
            if (r0 != 0) goto L_0x003d
        L_0x0038:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x003c:
            return r0
        L_0x003d:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.profile.uic.FinderProfileTabUIC.dnw():boolean");
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC, com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(250482);
        super.onCreate(bundle);
        ViewPager viewPager = this.uO;
        if (viewPager instanceof FinderViewPager) {
            ((FinderViewPager) viewPager).setEnableViewPagerScroll(true);
        }
        switch (getActivity().getIntent().getIntExtra("key_enter_profile_tab", 0)) {
            case 1:
                int i2 = 0;
                for (T t : getFragments()) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.j.hxH();
                    }
                    if (t instanceof FinderProfileAtFeedFragment) {
                        aw(i2, false);
                    }
                    i2 = i3;
                }
                break;
            case 2:
                int i4 = 0;
                for (T t2 : getFragments()) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        kotlin.a.j.hxH();
                    }
                    if (t2 instanceof FinderProfileMegaVideoFragment) {
                        aw(i4, false);
                    }
                    i4 = i5;
                }
                break;
            case 3:
                int i6 = 0;
                for (T t3 : getFragments()) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        kotlin.a.j.hxH();
                    }
                    if (t3 instanceof FinderProfileMusicFragment) {
                        aw(i6, false);
                    }
                    i6 = i7;
                }
                break;
            case 4:
                int i8 = 0;
                for (T t4 : getFragments()) {
                    int i9 = i8 + 1;
                    if (i8 < 0) {
                        kotlin.a.j.hxH();
                    }
                    if (t4 instanceof FinderProfileDraftFragment) {
                        aw(i8, false);
                    }
                    i8 = i9;
                }
                break;
        }
        if (!nS(true)) {
            Log.i("Finder.FinderProfileTabUIC", "onCreate: do not have mega video item, remove the tab");
            nR(false);
        }
        if (dnw() && !dnA()) {
            Log.i("Finder.FinderProfileTabUIC", "onCreate: do not have at item, remove the tab");
            com.tencent.mm.ac.d.h(new p(this));
            FinderAtFeedLoader finderAtFeedLoader = new FinderAtFeedLoader(com.tencent.mm.plugin.finder.feed.model.internal.e.FEED_AT_TIMELINE, this.tvp, null);
            finderAtFeedLoader.tVa = new n(this);
            this.vcG = finderAtFeedLoader;
            FinderAtFeedLoader finderAtFeedLoader2 = this.vcG;
            if (finderAtFeedLoader2 != null) {
                finderAtFeedLoader2.onAlive();
            }
            FinderAtFeedLoader finderAtFeedLoader3 = this.vcG;
            if (finderAtFeedLoader3 != null) {
                finderAtFeedLoader3.requestRefresh();
            }
        }
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dvJ().value().intValue() == 1 && !MJ(105)) {
            com.tencent.mm.kernel.g.azz().a(3736, new o(this));
            t azz = com.tencent.mm.kernel.g.azz();
            String str = this.tvp;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            azz.b(new cn(str, 0, null, 0, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx(), 1, 0, 64));
        }
        com.tencent.mm.kernel.g.azz().a(6628, new i(this));
        String str2 = this.tvp;
        String str3 = this.vcH;
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.kernel.g.azz().b(new bv(str2, str3, null, 0, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx()));
        dnx();
        AppMethodBeat.o(250482);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$onCreate$6", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
    public static final class o implements com.tencent.mm.ak.i {
        final /* synthetic */ FinderProfileTabUIC vcJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        o(FinderProfileTabUIC finderProfileTabUIC) {
            this.vcJ = finderProfileTabUIC;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(250467);
            com.tencent.mm.kernel.g.azz().b(3736, this);
            if (qVar instanceof cn) {
                if (!kotlin.g.b.p.j(((cn) qVar).tuH, this.vcJ.tvp)) {
                    AppMethodBeat.o(250467);
                    return;
                } else if (i2 == 0 && i3 == 0 && !Util.isNullOrNil(((cn) qVar).tvo)) {
                    Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add long video tab back");
                    this.vcJ.dny();
                }
            }
            AppMethodBeat.o(250467);
        }
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC
    public final void dnx() {
        AppMethodBeat.i(250483);
        super.dnx();
        HardTouchableLayout dHK = getTabContainer().dHK();
        if (dHK == null || dHK.getVisibility() != 0) {
            View dnt = dnt();
            if (dnt != null) {
                dnt.setVisibility(8);
                AppMethodBeat.o(250483);
                return;
            }
            AppMethodBeat.o(250483);
            return;
        }
        View dnt2 = dnt();
        if (dnt2 != null) {
            dnt2.setVisibility(0);
            AppMethodBeat.o(250483);
            return;
        }
        AppMethodBeat.o(250483);
    }

    public final void dny() {
        AppMethodBeat.i(250484);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dvJ().value().intValue() != 1) {
            AppMethodBeat.o(250484);
            return;
        }
        com.tencent.mm.ac.d.h(new g(this));
        AppMethodBeat.o(250484);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$checkMusicTab$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
    public static final class i implements com.tencent.mm.ak.i {
        final /* synthetic */ FinderProfileTabUIC vcJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(FinderProfileTabUIC finderProfileTabUIC) {
            this.vcJ = finderProfileTabUIC;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(250461);
            com.tencent.mm.kernel.g.azz().b(6628, this);
            if (qVar instanceof bv) {
                if (!kotlin.g.b.p.j(((bv) qVar).sBN, this.vcJ.tvp)) {
                    AppMethodBeat.o(250461);
                    return;
                } else if (i2 == 0) {
                    if (i3 == -1234) {
                        Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add music tab MM_ERR_DROP_CGI_BY_BUSINESS");
                        FinderProfileTabUIC.f(this.vcJ);
                        AppMethodBeat.o(250461);
                        return;
                    } else if (i3 == 0) {
                        if (!((bv) qVar).cYL().isEmpty()) {
                            Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add music tab items not empty");
                            FinderProfileTabUIC.f(this.vcJ);
                            AppMethodBeat.o(250461);
                            return;
                        } else if (kotlin.g.b.p.j(this.vcJ.tvp, this.vcJ.vcH) && FinderProfileTabUIC.h(this.vcJ)) {
                            Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: add music tab self mv posting");
                            FinderProfileTabUIC.f(this.vcJ);
                            AppMethodBeat.o(250461);
                            return;
                        } else if (((bv) qVar).cYL().isEmpty()) {
                            Log.i("Finder.FinderProfileTabUIC", "onSceneEnd: remove music tab items  empty");
                            FinderProfileTabUIC.a(this.vcJ);
                        }
                    }
                }
            }
            AppMethodBeat.o(250461);
        }
    }

    private final boolean hUE() {
        AppMethodBeat.i(261313);
        if (!isSelfFlag() || ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getDraftStorage().getCount() <= 0) {
            AppMethodBeat.o(261313);
            return false;
        }
        AppMethodBeat.o(261313);
        return true;
    }

    private final void dnz() {
        AppMethodBeat.i(250486);
        com.tencent.mm.ac.d.h(new f(this));
        AppMethodBeat.o(250486);
    }

    public final void nR(boolean z) {
        AppMethodBeat.i(250487);
        com.tencent.mm.ac.d.h(new q(this, z));
        AppMethodBeat.o(250487);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        int i2 = 0;
        AppMethodBeat.i(250488);
        super.onResume();
        Iterator<FinderHomeTabFragment> it = getFragments().iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (it.next() instanceof FinderProfileAtFeedFragment) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            if (!dnw()) {
                gx(i3, -1);
            }
        } else if (dnw() && dnA()) {
            dnz();
        }
        if (!MJ(105) && nS(false)) {
            Log.i("Finder.FinderProfileTabUIC", "onResume: add long video tab back because of local item");
            dny();
        }
        Iterator<FinderHomeTabFragment> it2 = getFragments().iterator();
        while (true) {
            if (!it2.hasNext()) {
                i2 = -1;
                break;
            } else if (it2.next() instanceof FinderProfileDraftFragment) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 && hUE()) {
            a(new c(R.string.d6o), new FinderProfileDraftFragment());
        }
        AppMethodBeat.o(250488);
    }

    private final boolean nS(boolean z) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(250489);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dvJ().value().intValue() != 1) {
            AppMethodBeat.o(250489);
            return false;
        }
        if (z) {
            if (!com.tencent.mm.plugin.finder.storage.data.l.vGw.bc(13, this.tvp).isEmpty()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                Log.i("Finder.FinderProfileTabUIC", "checkHasMegaVideoItem: has mega video first page data");
                AppMethodBeat.o(250489);
                return true;
            }
        }
        if (!dns()) {
            AppMethodBeat.o(250489);
            return false;
        }
        c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        LinkedList<FinderItem> af = c.a.af(this.tvp, 0, Integer.MAX_VALUE);
        if (!af.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        LinkedList<FinderItem> linkedList = z2 ? af : null;
        if (linkedList != null) {
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                if (it.next().isLongVideo()) {
                    Log.i("Finder.FinderProfileTabUIC", "checkHasMegaVideoItem: has posting mega video");
                    AppMethodBeat.o(250489);
                    return true;
                }
            }
        }
        AppMethodBeat.o(250489);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC, com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(250490);
        super.onDestroy();
        FinderAtFeedLoader finderAtFeedLoader = this.vcG;
        if (finderAtFeedLoader != null) {
            finderAtFeedLoader.onDead();
            AppMethodBeat.o(250490);
            return;
        }
        AppMethodBeat.o(250490);
    }

    private final boolean dnA() {
        AppMethodBeat.i(250491);
        if (!com.tencent.mm.plugin.finder.storage.data.l.vGw.bc(14, this.tvp).isEmpty()) {
            AppMethodBeat.o(250491);
            return true;
        }
        AppMethodBeat.o(250491);
        return false;
    }

    public final <T extends FinderHomeTabFragment> FinderHomeTabFragment aN(Class<T> cls) {
        T t;
        AppMethodBeat.i(250492);
        kotlin.g.b.p.h(cls, "clazz");
        Iterator<T> it = getFragments().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (kotlin.g.b.p.j(next.getClass(), cls)) {
                t = next;
                break;
            }
        }
        if (t == null) {
            kotlin.g.b.p.hyc();
        }
        T t2 = t;
        AppMethodBeat.o(250492);
        return t2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$TabViewAction;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabViewAction;", "()V", "onTabSelected", "", "context", "Landroid/content/Context;", "tab", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "onTabUnSelected", "plugin-finder_release"})
    public static final class e extends com.tencent.mm.plugin.finder.view.tabcomp.e {
        @Override // com.tencent.mm.plugin.finder.view.tabcomp.e, com.tencent.mm.plugin.finder.view.tabcomp.f
        public final void a(Context context, com.tencent.mm.plugin.finder.view.tabcomp.a aVar) {
            AppMethodBeat.i(250456);
            kotlin.g.b.p.h(context, "context");
            kotlin.g.b.p.h(aVar, "tab");
            super.a(context, aVar);
            aVar.pd(true);
            AppMethodBeat.o(250456);
        }

        @Override // com.tencent.mm.plugin.finder.view.tabcomp.e, com.tencent.mm.plugin.finder.view.tabcomp.f
        public final void b(Context context, com.tencent.mm.plugin.finder.view.tabcomp.a aVar) {
            AppMethodBeat.i(250457);
            kotlin.g.b.p.h(context, "context");
            kotlin.g.b.p.h(aVar, "tab");
            super.b(context, aVar);
            aVar.pd(false);
            AppMethodBeat.o(250457);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$TabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabContainer;", "()V", "getBackBtn", "Landroid/view/View;", "getLayoutId", "", "plugin-finder_release"})
    public static final class d extends com.tencent.mm.plugin.finder.view.tabcomp.d {
        @Override // com.tencent.mm.plugin.finder.view.tabcomp.d, com.tencent.mm.plugin.finder.view.tabcomp.g
        public final int getLayoutId() {
            return R.layout.aj6;
        }

        @Override // com.tencent.mm.plugin.finder.view.tabcomp.d, com.tencent.mm.plugin.finder.view.tabcomp.g
        public final View getBackBtn() {
            return null;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileTabUIC$Tab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "titleId", "", "(I)V", "getTitleId", "()I", "firstValidSelect", "", "tabView", "Landroid/view/ViewGroup;", "getLayoutId", "getTabMargin", "", "plugin-finder_release"})
    public static final class c extends com.tencent.mm.plugin.finder.view.tabcomp.c {
        private final int uQk;

        public c(int i2) {
            super(i2);
            this.uQk = i2;
        }

        @Override // com.tencent.mm.plugin.finder.view.tabcomp.c, com.tencent.mm.plugin.finder.view.tabcomp.a
        public final int getLayoutId() {
            return R.layout.aj1;
        }

        @Override // com.tencent.mm.plugin.finder.view.tabcomp.a
        public final int[] cXC() {
            return new int[]{0, 6};
        }

        @Override // com.tencent.mm.plugin.finder.view.tabcomp.c
        public final void t(ViewGroup viewGroup) {
            bbn bbn = null;
            AppMethodBeat.i(250455);
            kotlin.g.b.p.h(viewGroup, "tabView");
            super.t(viewGroup);
            int i2 = this.uQk;
            if (i2 == R.string.chl) {
                Context context = viewGroup.getContext();
                if (context == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(250455);
                    throw tVar;
                }
                String stringExtra = ((MMActivity) context).getIntent().getStringExtra("finder_username");
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                long j2 = kotlin.g.b.p.j(stringExtra, z.aUg()) ? 1 : 0;
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                Context context2 = viewGroup.getContext();
                kotlin.g.b.p.g(context2, "tabView.context");
                FinderReporterUIC fH = FinderReporterUIC.a.fH(context2);
                if (fH != null) {
                    bbn = fH.dIx();
                }
                com.tencent.mm.plugin.finder.report.k.a(j2, "2", 3, "", bbn);
                AppMethodBeat.o(250455);
            } else if (i2 == R.string.d70) {
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                Context context3 = viewGroup.getContext();
                kotlin.g.b.p.g(context3, "tabView.context");
                FinderProfileEduUIC.a((FinderProfileEduUIC) com.tencent.mm.ui.component.a.ko(context3).get(FinderProfileEduUIC.class), "mvtab", 1, null, 4);
                AppMethodBeat.o(250455);
            } else {
                if (i2 == R.string.d6o) {
                    com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                    Context context4 = viewGroup.getContext();
                    kotlin.g.b.p.g(context4, "tabView.context");
                    FinderProfileEduUIC.a((FinderProfileEduUIC) com.tencent.mm.ui.component.a.ko(context4).get(FinderProfileEduUIC.class), "drafttab", 1, null, 4);
                }
                AppMethodBeat.o(250455);
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC
    public final /* synthetic */ IFinderTabProvider cXB() {
        AppMethodBeat.i(250472);
        b bVar = new b();
        AppMethodBeat.o(250472);
        return bVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class s extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ FinderProfileTabUIC vcJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(FinderProfileTabUIC finderProfileTabUIC) {
            super(0);
            this.vcJ = finderProfileTabUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(250471);
            String stringExtra = this.vcJ.getIntent().getStringExtra("finder_username");
            AppMethodBeat.o(250471);
            return stringExtra;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderProfileTabUIC vcJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(FinderProfileTabUIC finderProfileTabUIC) {
            super(0);
            this.vcJ = finderProfileTabUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(250463);
            Boolean valueOf = Boolean.valueOf(this.vcJ.getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false));
            AppMethodBeat.o(250463);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderProfileTabUIC vcJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderProfileTabUIC finderProfileTabUIC) {
            super(0);
            this.vcJ = finderProfileTabUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(250462);
            Boolean valueOf = Boolean.valueOf(kotlin.g.b.p.j(this.vcJ.getUsername(), z.aUg()));
            AppMethodBeat.o(250462);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderProfileTabUIC vcJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(FinderProfileTabUIC finderProfileTabUIC) {
            super(0);
            this.vcJ = finderProfileTabUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(250464);
            if (!this.vcJ.isSelf() || !this.vcJ.isSelfFlag()) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(250464);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(250465);
            View findViewById = this.uQi.findViewById(R.id.igc);
            AppMethodBeat.o(250465);
            return findViewById;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderProfileTabUIC vcJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderProfileTabUIC finderProfileTabUIC) {
            super(0);
            this.vcJ = finderProfileTabUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250459);
            if (!this.vcJ.MJ(105)) {
                this.vcJ.a((FinderTabUIC) 1, (int) new c(R.string.d_v), (com.tencent.mm.plugin.finder.view.tabcomp.a) new FinderProfileMegaVideoFragment(), (FinderHomeTabFragment) false);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(250459);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderProfileTabUIC vcJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(FinderProfileTabUIC finderProfileTabUIC) {
            super(0);
            this.vcJ = finderProfileTabUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250460);
            if (!this.vcJ.MJ(108)) {
                int dIM = this.vcJ.dIM();
                this.vcJ.a((FinderTabUIC) 1, (int) new c(R.string.d70), (com.tencent.mm.plugin.finder.view.tabcomp.a) new FinderProfileMusicFragment(), (FinderHomeTabFragment) false);
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                FinderProfileEduUIC.a((FinderProfileEduUIC) com.tencent.mm.ui.component.a.b(this.vcJ.getActivity()).get(FinderProfileEduUIC.class), "mvtab", 0, null, 6);
                if (dIM > 0 && dIM + 1 < this.vcJ.getTabs().size()) {
                    this.vcJ.aw(dIM + 1, true);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(250460);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class r extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderProfileTabUIC vcJ;
        final /* synthetic */ boolean vcK = false;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(FinderProfileTabUIC finderProfileTabUIC) {
            super(0);
            this.vcJ = finderProfileTabUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250470);
            this.vcJ.gw(108, -1);
            if (this.vcK) {
                l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                String aUg = TextUtils.isEmpty(this.vcJ.tvp) ? z.aUg() : this.vcJ.tvp;
                kotlin.g.b.p.g(aUg, "if (TextUtils.isEmpty(ta…ame() else targetUsername");
                l.a.a(17, aUg, new LinkedList());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(250470);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderProfileTabUIC vcJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderProfileTabUIC finderProfileTabUIC) {
            super(0);
            this.vcJ = finderProfileTabUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2;
            AppMethodBeat.i(250458);
            if (!this.vcJ.MJ(106)) {
                int i3 = 0;
                Iterator<FinderHomeTabFragment> it = this.vcJ.getFragments().iterator();
                while (true) {
                    i2 = i3;
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    } else if (it.next() instanceof FinderProfileMusicFragment) {
                        break;
                    } else {
                        i3 = i2 + 1;
                    }
                }
                Log.i("Finder.FinderProfileTabUIC", "[addAtFeedFragment] megaIndex=".concat(String.valueOf(i2)));
                if (i2 < 0) {
                    this.vcJ.a((FinderTabUIC) 1, (int) new c(R.string.d8p), (com.tencent.mm.plugin.finder.view.tabcomp.a) new FinderProfileAtFeedFragment(), (FinderHomeTabFragment) false);
                } else {
                    this.vcJ.a((FinderTabUIC) 2, (int) new c(R.string.d8p), (com.tencent.mm.plugin.finder.view.tabcomp.a) new FinderProfileAtFeedFragment(), (FinderHomeTabFragment) false);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(250458);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class q extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderProfileTabUIC vcJ;
        final /* synthetic */ boolean vcK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(FinderProfileTabUIC finderProfileTabUIC, boolean z) {
            super(0);
            this.vcJ = finderProfileTabUIC;
            this.vcK = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250469);
            this.vcJ.gw(105, -1);
            if (this.vcK) {
                l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                String aUg = TextUtils.isEmpty(this.vcJ.tvp) ? z.aUg() : this.vcJ.tvp;
                kotlin.g.b.p.g(aUg, "if (TextUtils.isEmpty(ta…ame() else targetUsername");
                l.a.a(13, aUg, new LinkedList());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(250469);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderProfileTabUIC vcJ;
        final /* synthetic */ boolean vcK = false;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(FinderProfileTabUIC finderProfileTabUIC) {
            super(0);
            this.vcJ = finderProfileTabUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250468);
            this.vcJ.gw(106, 0);
            if (this.vcK) {
                l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                String aUg = TextUtils.isEmpty(this.vcJ.tvp) ? z.aUg() : this.vcJ.tvp;
                kotlin.g.b.p.g(aUg, "if (TextUtils.isEmpty(ta…ame() else targetUsername");
                l.a.a(14, aUg, new LinkedList());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(250468);
            return xVar;
        }
    }

    static /* synthetic */ void a(FinderProfileTabUIC finderProfileTabUIC) {
        AppMethodBeat.i(250485);
        com.tencent.mm.ac.d.h(new r(finderProfileTabUIC));
        AppMethodBeat.o(250485);
    }

    public static final /* synthetic */ boolean c(FinderProfileTabUIC finderProfileTabUIC) {
        boolean z;
        AppMethodBeat.i(250497);
        if (!finderProfileTabUIC.vcD) {
            if (!com.tencent.mm.plugin.finder.storage.data.l.vGw.bc(17, finderProfileTabUIC.tvp).isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                AppMethodBeat.o(250497);
                return false;
            }
        }
        finderProfileTabUIC.vcD = true;
        AppMethodBeat.o(250497);
        return true;
    }

    public static final /* synthetic */ void f(FinderProfileTabUIC finderProfileTabUIC) {
        AppMethodBeat.i(250499);
        com.tencent.mm.ac.d.h(new h(finderProfileTabUIC));
        AppMethodBeat.o(250499);
    }

    public static final /* synthetic */ boolean h(FinderProfileTabUIC finderProfileTabUIC) {
        boolean z;
        AppMethodBeat.i(250500);
        c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        String str = finderProfileTabUIC.vcH;
        kotlin.g.b.p.g(str, "selfUserName");
        LinkedList<FinderItem> af = c.a.af(str, 0, Integer.MAX_VALUE);
        if (!(af instanceof Collection) || !af.isEmpty()) {
            Iterator<T> it = af.iterator();
            while (it.hasNext()) {
                if (it.next().getFeedObject().objectType == 2) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    AppMethodBeat.o(250500);
                    return true;
                }
            }
        }
        AppMethodBeat.o(250500);
        return false;
    }
}
