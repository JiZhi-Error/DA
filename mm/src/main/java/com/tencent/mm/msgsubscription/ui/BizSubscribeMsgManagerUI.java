package com.tencent.mm.msgsubscription.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.i;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.msgsubscription.presenter.b;
import com.tencent.mm.msgsubscription.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@i
@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020\u0014H\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002J\u0012\u0010#\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0014H\u0014J\b\u0010'\u001a\u00020\u0014H\u0014J\b\u0010(\u001a\u00020\u0014H\u0014J\b\u0010)\u001a\u00020\u0014H\u0016J\b\u0010*\u001a\u00020\u0014H\u0014J\u0012\u0010+\u001a\u00020\u00142\b\b\u0002\u0010,\u001a\u00020\u0016H\u0002J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingView;", "()V", "bizUsername", "", "mAdapter", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter;", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "mSwitchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "nickname", "presenter", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "subscribeMsgList", "Lcom/tencent/mm/msgsubscription/ui/MaxRecyclerView;", "applyData", "", "switch", "", "items", "", "exampleTitle", "finish", "getLayoutId", "", "getUserName", "initAdapter", "initData", "initPresenter", "initViews", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "showSubscribeMsgList", "show", "updateResult", "result", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "Companion", "plugin-comm_release"})
public final class BizSubscribeMsgManagerUI extends MMActivity implements com.tencent.mm.msgsubscription.presenter.c {
    public static final a jBA = new a((byte) 0);
    private HashMap _$_findViewCache;
    private String dVu = "";
    private a jBw;
    private MMSwitchBtn jBx;
    private com.tencent.mm.msgsubscription.presenter.a jBy;
    private MaxRecyclerView jBz;
    private ArrayList<SubscribeMsgTmpItem> mDataList = new ArrayList<>();
    private String nickname = "";

    static {
        AppMethodBeat.i(149721);
        AppMethodBeat.o(149721);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(223416);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(223416);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(149724);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(149724);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI$Companion;", "", "()V", "REQUEST_CODE_SUBSCRIBEMSG_FOR_APPBRAND_SETTING_UI", "", "REQUEST_CODE_SUBSCRIBEMSG_FOR_SERVICE_BRAND_SETTING_UI", "TAG", "", "plugin-comm_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public BizSubscribeMsgManagerUI() {
        AppMethodBeat.i(149720);
        AppMethodBeat.o(149720);
    }

    public static final /* synthetic */ void a(BizSubscribeMsgManagerUI bizSubscribeMsgManagerUI, boolean z) {
        AppMethodBeat.i(149723);
        bizSubscribeMsgManagerUI.ga(z);
        AppMethodBeat.o(149723);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.jn;
    }

    @Override // com.tencent.mm.msgsubscription.presenter.c
    public final String getUserName() {
        return this.dVu;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(149712);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_biz_presenter_class");
        if (stringExtra == null) {
            stringExtra = "";
        }
        if (stringExtra.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Exception exc = new Exception("Presenter ClassName is empty");
            AppMethodBeat.o(149712);
            throw exc;
        }
        try {
            this.jBy = (com.tencent.mm.msgsubscription.presenter.a) Class.forName(stringExtra).newInstance();
            com.tencent.mm.msgsubscription.presenter.a aVar = this.jBy;
            if (aVar != null) {
                BizSubscribeMsgManagerUI bizSubscribeMsgManagerUI = this;
                p.h(bizSubscribeMsgManagerUI, "<set-?>");
                aVar.jAh = bizSubscribeMsgManagerUI;
            }
            com.tencent.mm.msgsubscription.presenter.a aVar2 = this.jBy;
            if (aVar2 != null) {
                aVar2.onActivityCreated(this);
            }
            setMMTitle(R.string.aho);
            this.jBw = new a(this, new b(this));
            View findViewById = findViewById(R.id.idm);
            p.g(findViewById, "this.findViewById(R.id.subscribe_msg_list)");
            this.jBz = (MaxRecyclerView) findViewById;
            MaxRecyclerView maxRecyclerView = this.jBz;
            if (maxRecyclerView == null) {
                p.btv("subscribeMsgList");
            }
            maxRecyclerView.setAdapter(this.jBw);
            MaxRecyclerView maxRecyclerView2 = this.jBz;
            if (maxRecyclerView2 == null) {
                p.btv("subscribeMsgList");
            }
            maxRecyclerView2.setLayoutManager(new LinearLayoutManager(1, false));
            View findViewById2 = findViewById(R.id.idn);
            if (findViewById2 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMSwitchBtn");
                AppMethodBeat.o(149712);
                throw tVar;
            }
            this.jBx = (MMSwitchBtn) findViewById2;
            MMSwitchBtn mMSwitchBtn = this.jBx;
            if (mMSwitchBtn != null) {
                mMSwitchBtn.setSwitchListener(new c(this));
            }
            String stringExtra2 = getIntent().getStringExtra("key_biz_username");
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.dVu = stringExtra2;
            String stringExtra3 = getIntent().getStringExtra("key_biz_nickname");
            if (stringExtra3 == null) {
                stringExtra3 = "";
            }
            this.nickname = stringExtra3;
            Log.d("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo SubscribeMsgManager username: %s, nickname: %s", this.dVu, this.nickname);
            com.tencent.mm.msgsubscription.presenter.a aVar3 = this.jBy;
            if (aVar3 != null) {
                aVar3.a(this.dVu, new d(this));
            }
            setBackBtn(new e(this));
            AppMethodBeat.o(149712);
        } catch (Exception e2) {
            Exception exc2 = new Exception("create presenter instance fail!", e2);
            AppMethodBeat.o(149712);
            throw exc2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class e implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ BizSubscribeMsgManagerUI jBB;

        e(BizSubscribeMsgManagerUI bizSubscribeMsgManagerUI) {
            this.jBB = bizSubscribeMsgManagerUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(149711);
            this.jBB.finish();
            AppMethodBeat.o(149711);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStart() {
        AppMethodBeat.i(149713);
        super.onStart();
        if (this.jBy != null) {
            p.h(this, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        }
        AppMethodBeat.o(149713);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(149714);
        super.onResume();
        com.tencent.mm.msgsubscription.presenter.a aVar = this.jBy;
        if (aVar != null) {
            aVar.onActivityResumed(this);
            AppMethodBeat.o(149714);
            return;
        }
        AppMethodBeat.o(149714);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI$loadData$1", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "onError", "", "onSuccess", "data", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "plugin-comm_release"})
    public static final class d implements b.a {
        final /* synthetic */ BizSubscribeMsgManagerUI jBB;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(BizSubscribeMsgManagerUI bizSubscribeMsgManagerUI) {
            this.jBB = bizSubscribeMsgManagerUI;
        }

        @Override // com.tencent.mm.msgsubscription.presenter.b.a
        public final void onError() {
            AppMethodBeat.i(177284);
            Log.e("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo getSubscribeMsgList ERROR");
            AppMethodBeat.o(177284);
        }

        @Override // com.tencent.mm.msgsubscription.presenter.b.a
        public final void a(SubscribeMsgSettingData subscribeMsgSettingData) {
            AppMethodBeat.i(177285);
            p.h(subscribeMsgSettingData, "data");
            Log.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo getSubscribeMsgList onSuccess");
            this.jBB.runOnUiThread(new a(this, subscribeMsgSettingData));
            AppMethodBeat.o(177285);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ d jBC;
            final /* synthetic */ SubscribeMsgSettingData jBD;

            a(d dVar, SubscribeMsgSettingData subscribeMsgSettingData) {
                this.jBC = dVar;
                this.jBD = subscribeMsgSettingData;
            }

            public final void run() {
                AppMethodBeat.i(177283);
                if (this.jBC.jBB.isFinishing()) {
                    AppMethodBeat.o(177283);
                    return;
                }
                BizSubscribeMsgManagerUI.a(this.jBC.jBB, this.jBD);
                AppMethodBeat.o(177283);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u001a\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI$initAdapter$1", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgItemOpListener;", "getCheckBoxState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "onCheckBoxStatusChanged", "", "check", "onItemInfoClick", "view", "Landroid/view/View;", "plugin-comm_release"})
    public static final class b implements a.b {
        final /* synthetic */ BizSubscribeMsgManagerUI jBB;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(BizSubscribeMsgManagerUI bizSubscribeMsgManagerUI) {
            this.jBB = bizSubscribeMsgManagerUI;
        }

        @Override // com.tencent.mm.msgsubscription.ui.a.b
        public final void b(SubscribeMsgTmpItem subscribeMsgTmpItem, boolean z) {
            AppMethodBeat.i(223414);
            p.h(subscribeMsgTmpItem, "item");
            com.tencent.mm.msgsubscription.presenter.a aVar = this.jBB.jBy;
            if (aVar != null) {
                aVar.a(subscribeMsgTmpItem, z);
                AppMethodBeat.o(223414);
                return;
            }
            AppMethodBeat.o(223414);
        }

        @Override // com.tencent.mm.msgsubscription.ui.a.b
        public final boolean a(SubscribeMsgTmpItem subscribeMsgTmpItem) {
            AppMethodBeat.i(223415);
            p.h(subscribeMsgTmpItem, "item");
            com.tencent.mm.msgsubscription.presenter.a aVar = this.jBB.jBy;
            if (aVar != null) {
                boolean a2 = aVar.a(subscribeMsgTmpItem);
                AppMethodBeat.o(223415);
                return a2;
            }
            AppMethodBeat.o(223415);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onStatusChange"})
    static final class c implements MMSwitchBtn.a {
        final /* synthetic */ BizSubscribeMsgManagerUI jBB;

        c(BizSubscribeMsgManagerUI bizSubscribeMsgManagerUI) {
            this.jBB = bizSubscribeMsgManagerUI;
        }

        @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
        public final void onStatusChange(boolean z) {
            boolean z2;
            AppMethodBeat.i(149704);
            Object[] objArr = new Object[1];
            MMSwitchBtn mMSwitchBtn = this.jBB.jBx;
            objArr[0] = mMSwitchBtn != null ? Boolean.valueOf(mMSwitchBtn.isCheck()) : null;
            Log.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo SubscribeMsg onSwitchChanged %s", objArr);
            com.tencent.mm.msgsubscription.presenter.a aVar = this.jBB.jBy;
            if (aVar != null) {
                MMSwitchBtn mMSwitchBtn2 = this.jBB.jBx;
                if (mMSwitchBtn2 != null) {
                    z2 = mMSwitchBtn2.isCheck();
                } else {
                    z2 = false;
                }
                aVar.fC(z2);
            }
            MMSwitchBtn mMSwitchBtn3 = this.jBB.jBx;
            if (mMSwitchBtn3 == null || !mMSwitchBtn3.isCheck()) {
                BizSubscribeMsgManagerUI.a(this.jBB, false);
                AppMethodBeat.o(149704);
                return;
            }
            BizSubscribeMsgManagerUI.a(this.jBB, true);
            AppMethodBeat.o(149704);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(149715);
        com.tencent.mm.msgsubscription.presenter.a aVar = this.jBy;
        if (aVar != null) {
            aVar.onActivityPaused(this);
        }
        super.onPause();
        AppMethodBeat.o(149715);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(149716);
        if (this.jBy != null) {
            p.h(this, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        }
        super.onDestroy();
        Log.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo onDestroy");
        AppMethodBeat.o(149716);
    }

    private final void ga(boolean z) {
        boolean z2;
        AppMethodBeat.i(149717);
        MaxRecyclerView maxRecyclerView = this.jBz;
        if (maxRecyclerView == null) {
            p.btv("subscribeMsgList");
        }
        maxRecyclerView.setVisibility((!(!this.mDataList.isEmpty()) || !z) ? 8 : 0);
        TextView textView = (TextView) findViewById(R.id.idp);
        if (!this.mDataList.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            p.g(textView, "subscribeMsgTitleWithNickname");
            textView.setVisibility(0);
            String string = z ? getString(R.string.ahp) : getString(R.string.ahn);
            p.g(string, "if (show) getString(R.st…_msg_close_with_nickname)");
            ae aeVar = ae.SYK;
            String format = String.format(string, Arrays.copyOf(new Object[]{this.nickname}, 1));
            p.g(format, "java.lang.String.format(format, *args)");
            textView.setText(format);
            textView.setPadding(textView.getPaddingLeft(), z ? getResources().getDimensionPixelSize(R.dimen.hv) : getResources().getDimensionPixelSize(R.dimen.k5), textView.getPaddingRight(), textView.getPaddingBottom());
        } else {
            p.g(textView, "subscribeMsgTitleWithNickname");
            textView.setVisibility(8);
        }
        a aVar = this.jBw;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
            AppMethodBeat.o(149717);
            return;
        }
        AppMethodBeat.o(149717);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStop() {
        AppMethodBeat.i(149718);
        super.onStop();
        if (this.jBy != null) {
            p.h(this, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        }
        AppMethodBeat.o(149718);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(149719);
        com.tencent.mm.msgsubscription.presenter.a aVar = this.jBy;
        if (aVar != null) {
            aVar.y(this);
        }
        super.finish();
        AppMethodBeat.o(149719);
    }

    public static final /* synthetic */ void a(BizSubscribeMsgManagerUI bizSubscribeMsgManagerUI, SubscribeMsgSettingData subscribeMsgSettingData) {
        AppMethodBeat.i(149722);
        Log.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo updateResult %d, isOpened: %b", Integer.valueOf(subscribeMsgSettingData.iHf.size()), Boolean.valueOf(subscribeMsgSettingData.iQD));
        MaxRecyclerView maxRecyclerView = bizSubscribeMsgManagerUI.jBz;
        if (maxRecyclerView == null) {
            p.btv("subscribeMsgList");
        }
        if (maxRecyclerView != null) {
            maxRecyclerView.setVisibility(!subscribeMsgSettingData.iHf.isEmpty() ? 0 : 8);
        }
        MaxRecyclerView maxRecyclerView2 = (MaxRecyclerView) bizSubscribeMsgManagerUI.findViewById(R.id.idm);
        if (maxRecyclerView2 != null) {
            maxRecyclerView2.setVisibility(0);
        }
        boolean z = subscribeMsgSettingData.iQD;
        List<SubscribeMsgTmpItem> list = subscribeMsgSettingData.iHf;
        String str = subscribeMsgSettingData.jAi;
        MMSwitchBtn mMSwitchBtn = bizSubscribeMsgManagerUI.jBx;
        if (mMSwitchBtn != null) {
            mMSwitchBtn.setCheck(z);
        }
        bizSubscribeMsgManagerUI.mDataList.clear();
        bizSubscribeMsgManagerUI.mDataList.addAll(list);
        a aVar = bizSubscribeMsgManagerUI.jBw;
        if (aVar != null) {
            ArrayList<SubscribeMsgTmpItem> arrayList = bizSubscribeMsgManagerUI.mDataList;
            p.h(arrayList, "list");
            aVar.jBE.clear();
            aVar.jBE.addAll(arrayList);
        }
        a aVar2 = bizSubscribeMsgManagerUI.jBw;
        if (aVar2 != null) {
            p.h(str, "value");
            aVar2.jAi = str;
        }
        bizSubscribeMsgManagerUI.ga(z);
        AppMethodBeat.o(149722);
    }
}
