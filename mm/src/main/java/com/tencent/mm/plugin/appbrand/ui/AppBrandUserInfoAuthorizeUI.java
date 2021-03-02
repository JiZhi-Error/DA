package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.a;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b;
import com.tencent.mm.plugin.appbrand.ui.a.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.view.TouchableLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0014J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0014J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0006H\u0002J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "currentSelectedUserId", "", "hadShowCloseNote", "", "isOpen", "mOriginalToCompare", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mUserinfoListItems", "mainSwitch", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "userInfoList", "Landroid/support/v7/widget/RecyclerView;", "wxaUserInfoListOperationController", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController;", "checkUserInfoModified", "finish", "", "getLayoutId", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "processMainSwitchClick", "check", "showUserInfoPanel", WeChatBrands.Business.GROUP_OPEN, "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandUserInfoAuthorizeUI extends MMActivity {
    public static final a nYe = new a((byte) 0);
    private boolean VC;
    private HashMap _$_findViewCache;
    private q gxX;
    private final List<i.a> nXX = new ArrayList();
    private List<i.a> nXY;
    private boolean nXZ;
    private int nYa;
    private MMSwitchBtn nYb;
    private com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b nYc;
    private RecyclerView nYd;

    static {
        AppMethodBeat.i(180683);
        AppMethodBeat.o(180683);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(229538);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(229538);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(180688);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(180688);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppBrandUserInfoAuthorizeUI() {
        AppMethodBeat.i(180682);
        AppMethodBeat.o(180682);
    }

    public static final /* synthetic */ RecyclerView c(AppBrandUserInfoAuthorizeUI appBrandUserInfoAuthorizeUI) {
        AppMethodBeat.i(229537);
        RecyclerView recyclerView = appBrandUserInfoAuthorizeUI.nYd;
        if (recyclerView == null) {
            p.btv("userInfoList");
        }
        AppMethodBeat.o(229537);
        return recyclerView;
    }

    public static final /* synthetic */ void c(AppBrandUserInfoAuthorizeUI appBrandUserInfoAuthorizeUI, boolean z) {
        AppMethodBeat.i(180687);
        appBrandUserInfoAuthorizeUI.iQ(z);
        AppMethodBeat.o(180687);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b e(AppBrandUserInfoAuthorizeUI appBrandUserInfoAuthorizeUI) {
        AppMethodBeat.i(180685);
        com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b bVar = appBrandUserInfoAuthorizeUI.nYc;
        if (bVar == null) {
            p.btv("wxaUserInfoListOperationController");
        }
        AppMethodBeat.o(180685);
        return bVar;
    }

    public static final /* synthetic */ MMSwitchBtn f(AppBrandUserInfoAuthorizeUI appBrandUserInfoAuthorizeUI) {
        AppMethodBeat.i(180686);
        MMSwitchBtn mMSwitchBtn = appBrandUserInfoAuthorizeUI.nYb;
        if (mMSwitchBtn == null) {
            p.btv("mainSwitch");
        }
        AppMethodBeat.o(180686);
        return mMSwitchBtn;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.fy;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        String str;
        Boolean bool;
        boolean z;
        AppMethodBeat.i(180676);
        super.onCreate(bundle);
        setBackBtn(new e(this));
        setMMTitle(R.string.a3f);
        Bundle extras = getIntent().getExtras();
        MMUserAvatarInfo mMUserAvatarInfo = extras != null ? (MMUserAvatarInfo) extras.getParcelable("key_user_info") : null;
        Bundle extras2 = getIntent().getExtras();
        if (extras2 != null) {
            str = extras2.getString("key_app_id");
        } else {
            str = null;
        }
        Bundle extras3 = getIntent().getExtras();
        if (extras3 != null) {
            bool = Boolean.valueOf(extras3.getBoolean("key_is_state_open"));
        } else {
            bool = null;
        }
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            z = false;
        }
        this.VC = z;
        iQ(this.VC);
        if (mMUserAvatarInfo == null || str == null) {
            com.tencent.e.f.h.hkS();
            finish();
            AppMethodBeat.o(180676);
            return;
        }
        this.nYa = mMUserAvatarInfo.lHH;
        View findViewById = findViewById(R.id.f6k);
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById;
        mMSwitchBtn.setCheck(this.VC);
        mMSwitchBtn.setSwitchListener(new d(this));
        p.g(findViewById, "this.findViewById<MMSwit…)\n            }\n        }");
        this.nYb = (MMSwitchBtn) findViewById;
        Bundle extras4 = getIntent().getExtras();
        String string = extras4 != null ? extras4.getString("key_nickname") : null;
        String str2 = string == null ? "" : string;
        p.g(str2, "intent.run { extras?.get…ing(KEY_NICKNAME) } ?: \"\"");
        View findViewById2 = findViewById(R.id.bmr);
        p.g(findViewById2, "this.findViewById<TextView>(R.id.desc)");
        ae aeVar = ae.SYK;
        String string2 = getString(R.string.a3e);
        p.g(string2, "getString(R.string.appbr…g_usernifo_authrize_desc)");
        String format = String.format(string2, Arrays.copyOf(new Object[]{str2}, 1));
        p.g(format, "java.lang.String.format(format, *args)");
        ((TextView) findViewById2).setText(format);
        View findViewById3 = findViewById(R.id.j18);
        p.g(findViewById3, "this.findViewById<TextView>(R.id.user_Info_desc)");
        ae aeVar2 = ae.SYK;
        String string3 = getString(R.string.a3i);
        p.g(string3, "getString(R.string.appbr…rize_user_info_list_desc)");
        String format2 = String.format(string3, Arrays.copyOf(new Object[]{str2}, 1));
        p.g(format2, "java.lang.String.format(format, *args)");
        ((TextView) findViewById3).setText(format2);
        View findViewById4 = findViewById(R.id.j1h);
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        p.g(recyclerView, LocaleUtil.ITALIAN);
        recyclerView.setNestedScrollingEnabled(false);
        p.g(findViewById4, "this.findViewById<Recycl…Enabled = false\n        }");
        this.nYd = (RecyclerView) findViewById4;
        this.nYc = new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b(this, mMUserAvatarInfo, "", new f(this, str));
        com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b bVar = this.nYc;
        if (bVar == null) {
            p.btv("wxaUserInfoListOperationController");
        }
        bVar.lHQ = new g(this);
        com.tencent.mm.plugin.appbrand.widget.dialog.i iVar = new com.tencent.mm.plugin.appbrand.widget.dialog.i(this.nXX);
        RecyclerView recyclerView2 = this.nYd;
        if (recyclerView2 == null) {
            p.btv("userInfoList");
        }
        recyclerView2.setAdapter(iVar);
        RecyclerView recyclerView3 = this.nYd;
        if (recyclerView3 == null) {
            p.btv("userInfoList");
        }
        getContext();
        recyclerView3.setLayoutManager(new LinearLayoutManager());
        RecyclerView recyclerView4 = this.nYd;
        if (recyclerView4 == null) {
            p.btv("userInfoList");
        }
        recyclerView4.setItemAnimator(null);
        iVar.oqX = new b(this);
        iVar.nbX = new c(this);
        AppMethodBeat.o(180676);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class e implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ AppBrandUserInfoAuthorizeUI nYf;

        e(AppBrandUserInfoAuthorizeUI appBrandUserInfoAuthorizeUI) {
            this.nYf = appBrandUserInfoAuthorizeUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(180664);
            this.nYf.finish();
            AppMethodBeat.o(180664);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onStatusChange", "com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$3$1"})
    static final class d implements MMSwitchBtn.a {
        final /* synthetic */ AppBrandUserInfoAuthorizeUI nYf;

        d(AppBrandUserInfoAuthorizeUI appBrandUserInfoAuthorizeUI) {
            this.nYf = appBrandUserInfoAuthorizeUI;
        }

        @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
        public final void onStatusChange(boolean z) {
            AppMethodBeat.i(180663);
            AppBrandUserInfoAuthorizeUI.a(this.nYf, z);
            AppMethodBeat.o(180663);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016JB\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000fH\u0016¨\u0006\u0011"}, hxF = {"com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$5", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "onItemListChanged", "", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "updateAddNewAvatarEntry", "isBan", "", "reachMaxCount", "limitWording", "", "avatarWording", "goAddUserPage", "Lkotlin/Function2;", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
    public static final class f implements b.c {
        final /* synthetic */ String kPQ;
        final /* synthetic */ AppBrandUserInfoAuthorizeUI nYf;

        f(AppBrandUserInfoAuthorizeUI appBrandUserInfoAuthorizeUI, String str) {
            this.nYf = appBrandUserInfoAuthorizeUI;
            this.kPQ = str;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c
        public final void a(boolean z, boolean z2, String str, String str2, m<? super Activity, ? super String, x> mVar) {
            AppMethodBeat.i(229532);
            p.h(str, "limitWording");
            p.h(str2, "avatarWording");
            p.h(mVar, "goAddUserPage");
            TextView textView = (TextView) this.nYf.findViewById(R.id.j1o);
            View findViewById = this.nYf.findViewById(R.id.bi4);
            if (!z && !z2) {
                p.g(textView, "userReachMaxCountTip");
                textView.setVisibility(8);
                p.g(findViewById, "createNewUser");
                findViewById.setVisibility(0);
            } else if (!z) {
                p.g(textView, "userReachMaxCountTip");
                textView.setVisibility(0);
                p.g(findViewById, "createNewUser");
                findViewById.setVisibility(8);
            } else {
                p.g(textView, "userReachMaxCountTip");
                textView.setVisibility(8);
                p.g(findViewById, "createNewUser");
                findViewById.setVisibility(8);
            }
            findViewById.setOnClickListener(new a(this, mVar));
            AppMethodBeat.o(229532);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ f nYg;
            final /* synthetic */ m nYh;

            a(f fVar, m mVar) {
                this.nYg = fVar;
                this.nYh = mVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(229531);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$5$updateAddNewAvatarEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                m mVar = this.nYh;
                AppCompatActivity context = this.nYg.nYf.getContext();
                p.g(context, "context");
                mVar.invoke(context, this.nYg.kPQ);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$5$updateAddNewAvatarEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(229531);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c
        public final void bz(List<i.a> list) {
            AppMethodBeat.i(229533);
            p.h(list, "items");
            if (this.nYf.nXY == null) {
                this.nYf.nXY = new ArrayList(list);
            }
            this.nYf.nXX.clear();
            this.nYf.nXX.addAll(list);
            RecyclerView.a adapter = AppBrandUserInfoAuthorizeUI.c(this.nYf).getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
                AppMethodBeat.o(229533);
                return;
            }
            AppMethodBeat.o(229533);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$6", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "onResult", "", "ret", "", "onStart", "plugin-appbrand-integration_release"})
    public static final class g implements a.AbstractC0630a {
        final /* synthetic */ AppBrandUserInfoAuthorizeUI nYf;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(AppBrandUserInfoAuthorizeUI appBrandUserInfoAuthorizeUI) {
            this.nYf = appBrandUserInfoAuthorizeUI;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.entity.a.AbstractC0630a
        public final void onStart() {
            AppMethodBeat.i(229535);
            if (this.nYf.gxX == null) {
                AppBrandUserInfoAuthorizeUI appBrandUserInfoAuthorizeUI = this.nYf;
                this.nYf.getString(R.string.zb);
                appBrandUserInfoAuthorizeUI.gxX = com.tencent.mm.ui.base.h.a((Context) this.nYf.getContext(), 3, this.nYf.getString(R.string.a3a), false, (DialogInterface.OnCancelListener) a.nYi);
            }
            q qVar = this.nYf.gxX;
            if (qVar != null) {
                qVar.show();
                AppMethodBeat.o(229535);
                return;
            }
            AppMethodBeat.o(229535);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
        static final class a implements DialogInterface.OnCancelListener {
            public static final a nYi = new a();

            static {
                AppMethodBeat.i(229534);
                AppMethodBeat.o(229534);
            }

            a() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.entity.a.AbstractC0630a
        public final void bES() {
            AppMethodBeat.i(229536);
            q qVar = this.nYf.gxX;
            if (qVar != null) {
                qVar.dismiss();
                AppMethodBeat.o(229536);
                return;
            }
            AppMethodBeat.o(229536);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$7$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", FirebaseAnalytics.b.INDEX, "", "plugin-appbrand-integration_release"})
    public static final class b implements i.d {
        final /* synthetic */ AppBrandUserInfoAuthorizeUI nYf;

        b(AppBrandUserInfoAuthorizeUI appBrandUserInfoAuthorizeUI) {
            this.nYf = appBrandUserInfoAuthorizeUI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.dialog.i.d
        public final void a(View view, i.a aVar, int i2) {
            AppMethodBeat.i(229529);
            p.h(view, "v");
            p.h(aVar, "item");
            com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b e2 = AppBrandUserInfoAuthorizeUI.e(this.nYf);
            TouchableLayout.a aVar2 = TouchableLayout.Rni;
            int hfC = TouchableLayout.hfC();
            TouchableLayout.a aVar3 = TouchableLayout.Rni;
            e2.a(view, i2, hfC, TouchableLayout.hfD());
            AppMethodBeat.o(229529);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$onCreate$7$2", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "plugin-appbrand-integration_release"})
    public static final class c implements i.b {
        final /* synthetic */ AppBrandUserInfoAuthorizeUI nYf;

        c(AppBrandUserInfoAuthorizeUI appBrandUserInfoAuthorizeUI) {
            this.nYf = appBrandUserInfoAuthorizeUI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.dialog.i.b
        public final void a(i.a aVar) {
            AppMethodBeat.i(229530);
            p.h(aVar, "item");
            AppBrandUserInfoAuthorizeUI.e(this.nYf).b(aVar);
            this.nYf.nYa = aVar.lGW;
            AppMethodBeat.o(229530);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class h implements DialogInterface.OnClickListener {
        final /* synthetic */ kotlin.g.a.a nYj;

        h(kotlin.g.a.a aVar) {
            this.nYj = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(180671);
            this.nYj.invoke();
            AppMethodBeat.o(180671);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class i implements DialogInterface.OnClickListener {
        final /* synthetic */ kotlin.g.a.a nYk;

        i(kotlin.g.a.a aVar) {
            this.nYk = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(180672);
            this.nYk.invoke();
            AppMethodBeat.o(180672);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    public static final class j implements DialogInterface.OnCancelListener {
        final /* synthetic */ kotlin.g.a.a nYk;

        j(kotlin.g.a.a aVar) {
            this.nYk = aVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(180673);
            this.nYk.invoke();
            AppMethodBeat.o(180673);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(180677);
        super.onDestroy();
        q qVar = this.gxX;
        if (qVar != null) {
            qVar.dismiss();
            AppMethodBeat.o(180677);
            return;
        }
        AppMethodBeat.o(180677);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(180678);
        p.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b bVar = this.nYc;
        if (bVar == null) {
            p.btv("wxaUserInfoListOperationController");
        }
        if (bVar != null) {
            com.tencent.mm.ui.widget.b.a aVar = bVar.lHR;
            if (aVar != null) {
                aVar.gNq();
                AppMethodBeat.o(180678);
                return;
            }
            AppMethodBeat.o(180678);
            return;
        }
        AppMethodBeat.o(180678);
    }

    private final void iQ(boolean z) {
        AppMethodBeat.i(180679);
        View findViewById = findViewById(R.id.j1i);
        p.g(findViewById, "this.findViewById<View>(R.id.user_info_panel)");
        findViewById.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(180679);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(180680);
        Intent intent = new Intent();
        intent.putExtra("key_result_user_info_list_been_modified", bXH());
        intent.putExtra("key_result_is_open", this.VC);
        intent.putExtra("key_result_selected_user_id", this.nYa);
        setResult(-1, intent);
        super.finish();
        AppMethodBeat.o(180680);
    }

    private final boolean bXH() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(180681);
        List<i.a> list = this.nXY;
        if (list == null || list.size() != this.nXX.size()) {
            z = true;
        } else {
            z = false;
            for (T t : this.nXX) {
                List<i.a> list2 = this.nXY;
                if (list2 != null) {
                    Iterator<T> it = list2.iterator();
                    z2 = false;
                    while (it.hasNext()) {
                        if (t.lGW == it.next().lGW) {
                            z2 = true;
                        }
                    }
                } else {
                    z2 = false;
                }
                if (!z2) {
                    z = true;
                }
            }
        }
        AppMethodBeat.o(180681);
        return z;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUserInfoAuthorizeUI$Companion;", "", "()V", "KEY_APP_ID", "", "KEY_IS_STATE_OPEN", "KEY_NICKNAME", "KEY_RESULT_IS_OPEN", "KEY_RESULT_SELECTED_USER_ID", "KEY_RESULT_USER_INFO_LIST_BEEN_MODIFIED", "KEY_USER_INFO", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<no name provided>", "", "invoke"})
    public static final class k extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ AppBrandUserInfoAuthorizeUI nYf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(AppBrandUserInfoAuthorizeUI appBrandUserInfoAuthorizeUI) {
            super(0);
            this.nYf = appBrandUserInfoAuthorizeUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(180674);
            AppBrandUserInfoAuthorizeUI.f(this.nYf).setCheck(true);
            x xVar = x.SXb;
            AppMethodBeat.o(180674);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<no name provided>", "", "invoke"})
    public static final class l extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ AppBrandUserInfoAuthorizeUI nYf;
        final /* synthetic */ boolean nYl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(AppBrandUserInfoAuthorizeUI appBrandUserInfoAuthorizeUI, boolean z) {
            super(0);
            this.nYf = appBrandUserInfoAuthorizeUI;
            this.nYl = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(180675);
            this.nYf.VC = this.nYl;
            AppBrandUserInfoAuthorizeUI.c(this.nYf, this.nYf.VC);
            x xVar = x.SXb;
            AppMethodBeat.o(180675);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(AppBrandUserInfoAuthorizeUI appBrandUserInfoAuthorizeUI, boolean z) {
        AppMethodBeat.i(180684);
        k kVar = new k(appBrandUserInfoAuthorizeUI);
        l lVar = new l(appBrandUserInfoAuthorizeUI, z);
        if (z || appBrandUserInfoAuthorizeUI.nXZ) {
            lVar.invoke();
            AppMethodBeat.o(180684);
            return;
        }
        appBrandUserInfoAuthorizeUI.nXZ = true;
        a.C0803a aVar = com.tencent.mm.plugin.appbrand.ui.a.a.nZe;
        AppCompatActivity context = appBrandUserInfoAuthorizeUI.getContext();
        p.g(context, "context");
        a.C0803a.a(context, new h(lVar), new i(kVar), new j(kVar));
        AppMethodBeat.o(180684);
    }
}
