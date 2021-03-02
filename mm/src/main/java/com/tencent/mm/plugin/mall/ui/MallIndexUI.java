package com.tencent.mm.plugin.mall.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aah;
import com.tencent.mm.g.a.aba;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mall.a.d;
import com.tencent.mm.plugin.mall.a.e;
import com.tencent.mm.plugin.mall.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.aa;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.math.RoundingMode;

@i
public class MallIndexUI extends MallIndexBaseUI implements MStorageEx.IOnStorageChange {
    private String egv;
    private boolean isFinished = false;
    private View psf = null;
    private TextView zlH = null;
    private boolean zlI = false;
    private zv.b zlX;
    private RelativeLayout zlY;
    private boolean zlZ;
    private boolean zma;
    u zmb = new u();
    private boolean zmc = false;
    private Dialog zmd;
    private boolean zme = false;
    private b zmf = null;
    private c zmg = null;
    private WcPayMoneyLoadingView zmh;
    private ProgressBar zmi;
    private IListener<ov> zmj = new IListener<ov>() {
        /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160811);
            this.__eventId = ov.class.getName().hashCode();
            AppMethodBeat.o(160811);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ov ovVar) {
            AppMethodBeat.i(66099);
            Log.i("MicorMsg.MallIndexUI", "open ecard finish");
            ECardInfo.bF(null);
            AppMethodBeat.o(66099);
            return false;
        }
    };
    private boolean zmk = false;
    private IListener zml = new IListener<aah>() {
        /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.AnonymousClass7 */

        {
            AppMethodBeat.i(160812);
            this.__eventId = aah.class.getName().hashCode();
            AppMethodBeat.o(160812);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aah aah) {
            AppMethodBeat.i(66104);
            aah aah2 = aah;
            Log.i("MicorMsg.MallIndexUI", "real name verify callback, result: %s, isDoRealNameForBalance: %s", Integer.valueOf(aah2.ehe.result), Boolean.valueOf(MallIndexUI.this.zmk));
            if (aah2.ehe.result == -1 && MallIndexUI.this.zmk) {
                MallIndexUI.this.zmk = false;
                MallIndexUI.c(MallIndexUI.this);
            }
            AppMethodBeat.o(66104);
            return false;
        }
    };
    private IListener<aba> zmm = new IListener<aba>() {
        /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.AnonymousClass8 */

        {
            AppMethodBeat.i(160813);
            this.__eventId = aba.class.getName().hashCode();
            AppMethodBeat.o(160813);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aba aba) {
            AppMethodBeat.i(66106);
            boolean a2 = a(aba);
            AppMethodBeat.o(66106);
            return a2;
        }

        private static boolean a(aba aba) {
            AppMethodBeat.i(66105);
            String str = aba.eim.dNk;
            Log.i("MicorMsg.MallIndexUI", "get result %s", str);
            if ("agree_privacy".equals(str)) {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_MALL_INDEX_GDPR_AGREE_BOOLEAN_SYNC, Boolean.TRUE);
            }
            AppMethodBeat.o(66105);
            return false;
        }
    };
    private boolean zmn = false;
    private boolean zmo = false;

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MallIndexUI() {
        AppMethodBeat.i(66117);
        AppMethodBeat.o(66117);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(66118);
        Log.i("MicorMsg.MallIndexUI", "onActivityResult %s %s %s", Integer.valueOf(i2), Integer.valueOf(i3), intent);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 3) {
            if (i3 == -1) {
                this.zmb.ehm();
                AppMethodBeat.o(66118);
                return;
            }
            this.zmb.cancel();
            AppMethodBeat.o(66118);
        } else if (i2 == 5) {
            g.aAi();
            if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_MALL_INDEX_GDPR_AGREE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                finish();
            }
            AppMethodBeat.o(66118);
        } else {
            if (i2 == 6 && intent != null && intent.getIntExtra("is_switch_wallet", 0) == 1) {
                finish();
                sd sdVar = new sd();
                sdVar.dYH.context = getContext();
                EventCenter.instance.publish(sdVar);
            }
            AppMethodBeat.o(66118);
        }
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(66119);
        fixStatusbar(true);
        if (26 != Build.VERSION.SDK_INT) {
            setRequestedOrientation(1);
        }
        ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().add(this);
        ((com.tencent.mm.plugin.walletlock.a.b) g.af(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
        k.aeJ(2);
        this.zlX = new zv.b();
        this.zlX.efV = false;
        this.zlX.efW = true;
        this.zlX.efX = false;
        this.zmj.alive();
        this.zmm.alive();
        this.zmb.IkQ = new u.b() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.b
            public final int eho() {
                return 3;
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.b
            public final Context getContext() {
                return MallIndexUI.this;
            }
        };
        e.ehs();
        a.b(this, true);
        super.onCreate(bundle);
        EventCenter.instance.addListener(this.zml);
        addSceneEndListener(2713);
        addSceneEndListener(385);
        if (com.tencent.mm.aw.b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
            g.aAi();
            a(new d((String) g.aAh().azQ().get(ar.a.USERINFO_MALL_INDEX_GDPR_CACHE_STRING_SYNC, "")));
            g.aAi();
            ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_MALL_INDEX_GDPR_AGREE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
            doSceneProgress(new e(), false);
        }
        h.INSTANCE.a(16500, 1);
        AppMethodBeat.o(66119);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void dYP() {
        AppMethodBeat.i(66120);
        int color = getResources().getColor(R.color.zd);
        setActionbarColor(color);
        hideActionbarLine();
        findViewById(R.id.h93).setBackgroundColor(color);
        AppMethodBeat.o(66120);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void egS() {
        AppMethodBeat.i(66121);
        setMMTitle(R.string.evy);
        AppMethodBeat.o(66121);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(66122);
        super.initView();
        this.zlh.setPadding(a.zjP, 0, a.zjP, 0);
        AppMethodBeat.o(66122);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void initHeaderView() {
        AppMethodBeat.i(66123);
        this.vbj = aa.jQ(this).inflate(R.layout.b5h, (ViewGroup) null);
        this.zlh.addHeaderView(this.vbj, null, false);
        LinearLayout linearLayout = (LinearLayout) this.vbj.findViewById(R.id.do6);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = a.egN();
        linearLayout.setLayoutParams(layoutParams);
        AppMethodBeat.o(66123);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void egZ() {
        AppMethodBeat.i(66124);
        this.zlp = com.tencent.mm.plugin.mall.a.k.egL().Qd(this.zjs).field_isShowSetting;
        if (this.zlq == null) {
            this.zlq = aa.jQ(this).inflate(R.layout.b5j, (ViewGroup) null);
            this.zlh.addFooterView(this.zlq, null, false);
            TextView textView = (TextView) this.zlq.findViewById(R.id.ff1);
            f.aZ(textView, 100);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.AnonymousClass10 */

                public final void onClick(View view) {
                    AppMethodBeat.i(66107);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicorMsg.MallIndexUI", "click settings btn");
                    com.tencent.mm.br.c.V(MallIndexUI.this.getContext(), "mall", ".ui.MallFunctionSettingsUI");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(66107);
                }
            });
        }
        Log.i("MicorMsg.MallIndexUI", "is show setting: %s", Integer.valueOf(this.zlp));
        if (this.zlp == 0) {
            this.zlq.setVisibility(8);
            this.zlq.setPadding(0, 0, 0, 0);
            AppMethodBeat.o(66124);
            return;
        }
        this.zlq.setVisibility(0);
        getWindow().getDecorView().post(new Runnable() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(66108);
                int jo = com.tencent.mm.cb.a.jo(MallIndexUI.this.getContext());
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) MallIndexUI.this.getContext(), 53);
                int[] iArr = new int[2];
                MallIndexUI.this.zlh.getLocationInWindow(iArr);
                int bottom = (MallIndexUI.this.zlq.getBottom() + iArr[1]) - jo;
                int height = (MallIndexUI.this.zlh.getHeight() - MallIndexUI.this.zlq.getHeight()) + iArr[1];
                if (bottom > 0) {
                    height += bottom;
                }
                int i2 = (jo - height) - fromDPToPix;
                int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix((Context) MallIndexUI.this.getContext(), 33);
                Log.d("MicorMsg.MallIndexUI", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", Integer.valueOf(jo), Integer.valueOf(height), Integer.valueOf(MallIndexUI.this.zlq.getHeight()), Integer.valueOf(iArr[1]), Integer.valueOf(bottom), Integer.valueOf(i2));
                if (i2 > fromDPToPix2) {
                    MallIndexUI.this.zlq.setPadding(0, i2, 0, fromDPToPix2);
                    AppMethodBeat.o(66108);
                    return;
                }
                MallIndexUI.this.zlq.setPadding(0, fromDPToPix2, 0, fromDPToPix2);
                AppMethodBeat.o(66108);
            }
        });
        AppMethodBeat.o(66124);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void eq(View view) {
        AppMethodBeat.i(66125);
        this.zmf = new b(this, view);
        com.tencent.mm.plugin.newtips.a.exl().h(this.zmf);
        this.zmg = new c(this, view);
        this.zmg.ehq();
        com.tencent.mm.plugin.newtips.a.exl().h(this.zmg);
        AppMethodBeat.o(66125);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(66126);
        if (mStorageEx == ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg() && i2 == 4) {
            Log.i("MicorMsg.MallIndexUI", "on cache update: %s", obj);
            if (obj.equals("USERINFO_NEW_BALANCE_LONG")) {
                ehb();
            }
        }
        AppMethodBeat.o(66126);
    }

    abstract class a implements com.tencent.mm.plugin.newtips.a.a {
        private Context context;
        protected TextView pzn;
        protected ImageView zmt;

        public abstract void eq(View view);

        public a(Context context2, View view) {
            this.context = context2;
            eq(view);
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean ehp() {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final void a(com.tencent.mm.plugin.newtips.a.k kVar, boolean z) {
            com.tencent.mm.plugin.newtips.a.g.a(this, kVar, z);
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean qV(boolean z) {
            return com.tencent.mm.plugin.newtips.a.g.a(z, this);
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean qW(boolean z) {
            if (z) {
                this.zmt.setVisibility(0);
                return true;
            }
            this.zmt.setVisibility(8);
            return true;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean qX(boolean z) {
            if (z) {
                this.pzn.setVisibility(0);
                this.pzn.setText(this.context.getString(R.string.x4));
                return true;
            }
            this.pzn.setVisibility(8);
            return true;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean a(boolean z, ehv ehv) {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean b(boolean z, ehv ehv) {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean c(boolean z, ehv ehv) {
            return false;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final boolean d(boolean z, ehv ehv) {
            if (z) {
                this.pzn.setVisibility(0);
                String sb = new StringBuilder().append(ehv.ibS).toString();
                if (ehv.ibS > 99) {
                    sb = this.context.getString(R.string.hk6);
                }
                this.pzn.setText(sb);
                return true;
            }
            this.pzn.setVisibility(8);
            return true;
        }
    }

    class c extends a {
        private LinearLayout zmw;

        public c(Context context, View view) {
            super(context, view);
        }

        @Override // com.tencent.mm.plugin.mall.ui.MallIndexUI.a
        public final void eq(View view) {
            AppMethodBeat.i(66115);
            this.zmw = (LinearLayout) view.findViewById(R.id.fev);
            MallIndexUI.this.zll = (TextView) this.zmw.findViewById(R.id.jeh);
            MallIndexUI.this.zmh = (WcPayMoneyLoadingView) this.zmw.findViewById(R.id.jei);
            MallIndexUI.this.zmi = (ProgressBar) this.zmw.findViewById(R.id.jg5);
            MallIndexUI.this.getLifecycle().addObserver(MallIndexUI.this.zmh);
            MallIndexUI.this.zmh.setLoadingPb(MallIndexUI.this.zmi);
            MallIndexUI.this.zmh.setPrefixSymbol("¥");
            MallIndexUI.this.zmh.setTextColor(-1);
            MallIndexUI.this.zmh.setTextSize((float) com.tencent.mm.cb.a.fromDPToPix((Context) MallIndexUI.this.getContext(), 15));
            this.zmt = (ImageView) this.zmw.findViewById(R.id.few);
            this.pzn = (TextView) this.zmw.findViewById(R.id.fex);
            this.zmw.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.c.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(66114);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    MallIndexUI.c(MallIndexUI.this);
                    com.tencent.mm.plugin.newtips.a.exl().TC(15);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(66114);
                }
            });
            AppMethodBeat.o(66115);
        }

        public final boolean ehq() {
            boolean z;
            AppMethodBeat.i(66116);
            g.aAi();
            boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
            g.aAi();
            long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, (Object) 0L)).longValue();
            if (!booleanValue || longValue <= 0 || System.currentTimeMillis() < longValue) {
                z = booleanValue;
            } else {
                Log.i("MicorMsg.MallIndexUI", "hasRedDot expire, ignore reddot");
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.FALSE);
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, (Object) 0L);
                z = false;
            }
            if (z) {
                this.zmt.setVisibility(0);
            } else {
                this.zmt.setVisibility(8);
            }
            com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_REDPOINT, z);
            AppMethodBeat.o(66116);
            return true;
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final String getPath() {
            return "wallet";
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final View getRoot() {
            return this.zmw;
        }
    }

    class b extends a {
        private LinearLayout zmu;

        public b(Context context, View view) {
            super(context, view);
        }

        @Override // com.tencent.mm.plugin.mall.ui.MallIndexUI.a
        public final void eq(View view) {
            AppMethodBeat.i(66113);
            this.zmu = (LinearLayout) view.findViewById(R.id.fer);
            this.zmt = (ImageView) this.zmu.findViewById(R.id.fes);
            this.pzn = (TextView) this.zmu.findViewById(R.id.fet);
            this.zmu.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(66112);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.plugin.newtips.a.exl().TC(5);
                    Intent intent = new Intent();
                    intent.putExtra("key_from_scene", 1);
                    com.tencent.mm.br.c.b(MallIndexUI.this.getContext(), "offline", ".ui.WalletOfflineEntranceUI", intent);
                    ab.mg(9, 0);
                    h.INSTANCE.a(11850, 5, 0);
                    h.INSTANCE.a(14419, MallIndexUI.this.uuid, 1);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(66112);
                }
            });
            AppMethodBeat.o(66113);
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final String getPath() {
            return "pay_receiveorpay";
        }

        @Override // com.tencent.mm.plugin.newtips.a.a
        public final View getRoot() {
            return this.zmu;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void eha() {
        AppMethodBeat.i(66127);
        final zt ztVar = new zt();
        ztVar.efM.scene = "1";
        ztVar.callback = new Runnable() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(66109);
                if (!Util.isNullOrNil(ztVar.efN.efO)) {
                    f.a(MallIndexUI.this.zlm, ztVar.efN.efO, ztVar.efN.content, ztVar.efN.url);
                }
                AppMethodBeat.o(66109);
            }
        };
        EventCenter.instance.publish(ztVar);
        AppMethodBeat.o(66127);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void egW() {
        boolean z;
        AppMethodBeat.i(66129);
        Log.i("MicorMsg.MallIndexUI", "showGetNewWalletTip call");
        if (this.zlX == null || (!this.zlX.efV && !this.zlX.egb)) {
            Log.e("MicorMsg.MallIndexUI", "user is not reg or simplereg，should not show this dialog");
            AppMethodBeat.o(66129);
            return;
        }
        boolean fRc = t.fQI().fRs().fRc();
        Object obj = g.aAh().azQ().get(ar.a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.FALSE);
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        } else {
            z = false;
        }
        Log.i("MicorMsg.MallIndexUI", "showGetNewWalletTip hadShow=" + z + ";isswc=" + fRc);
        if (!z && fRc) {
            g.aAh().azQ().set(ar.a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.TRUE);
            o.hN(this);
        }
        AppMethodBeat.o(66129);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006d  */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ehf() {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mall.ui.MallIndexUI.ehf():void");
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void ehb() {
        AppMethodBeat.i(66131);
        Log.i("MicorMsg.MallIndexUI", "updateBalanceNum");
        al alVar = new al();
        if (alVar.fRf()) {
            this.zll.setText((String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_RELEAY_NAME_BALANCE_CONTENT_STRING_SYNC, getString(R.string.fun)));
            this.zll.setVisibility(0);
            this.zmh.setVisibility(8);
            this.zmi.setVisibility(8);
            AppMethodBeat.o(66131);
            return;
        }
        if (alVar.fRh()) {
            Log.i("MicorMsg.MallIndexUI", "show balance amount");
            long longValue = ((Long) ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.USERINFO_NEW_BALANCE_LONG_SYNC, (Object) 0L)).longValue();
            if (this.zmh != null) {
                qU(alVar.fRj());
                if (this.zmh.getVisibility() == 0) {
                    this.zmh.setMoney(f.formatMoney2f(f.b(String.valueOf(longValue), "100", 2, RoundingMode.HALF_UP).doubleValue()));
                    AppMethodBeat.o(66131);
                    return;
                }
            } else {
                Log.w("MicorMsg.MallIndexUI", "moneyLoadingView is null");
            }
        }
        AppMethodBeat.o(66131);
    }

    private void qU(boolean z) {
        AppMethodBeat.i(66132);
        if (z) {
            this.zll.setText(getString(R.string.idn));
            this.zll.setVisibility(0);
            this.zmh.setVisibility(8);
            this.zmi.setVisibility(8);
            this.zmh.reset();
            AppMethodBeat.o(66132);
            return;
        }
        this.zll.setVisibility(8);
        this.zmh.setVisibility(0);
        this.zmi.setVisibility(0);
        AppMethodBeat.o(66132);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void ehd() {
        AppMethodBeat.i(66133);
        removeAllOptionMenu();
        Log.i("MicorMsg.MallIndexUI", "addIconOptionMenuByMode");
        addIconOptionMenu(0, 0, R.raw.icons_outlined_more, false, (MenuItem.OnMenuItemClickListener) new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(66101);
                h.INSTANCE.a(14872, 0, 0, "", "", 0);
                h.INSTANCE.a(16500, 3);
                MallIndexUI mallIndexUI = MallIndexUI.this;
                boolean z = MallIndexUI.this.zlX.egc;
                Intent intent = new Intent();
                intent.putExtra("key_default_show_currency", z);
                com.tencent.mm.br.c.b(mallIndexUI, "wallet", ".pwd.ui.WalletPasswordSettingUI", intent, 6);
                AppMethodBeat.o(66101);
                return true;
            }
        });
        h.INSTANCE.a(14872, 0, 0, "", "", 1);
        AppMethodBeat.o(66133);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(66134);
        Log.v("MicorMsg.MallIndexUI", "alvinluo MallIndexUI onResume");
        this.zmb.onResume();
        com.tencent.mm.plugin.walletlock.a.b bVar = (com.tencent.mm.plugin.walletlock.a.b) g.af(com.tencent.mm.plugin.walletlock.a.b.class);
        bVar.a(this, bVar.fUE(), null);
        super.onResume();
        ehb();
        AppMethodBeat.o(66134);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(66135);
        super.onPause();
        this.zmb.onPause();
        if (this.zmh != null) {
            this.zmh.reset();
        }
        AppMethodBeat.o(66135);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(66136);
        super.onDestroy();
        ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().remove(this);
        this.zmj.dead();
        this.zmm.dead();
        removeSceneEndListener(2713);
        removeSceneEndListener(385);
        EventCenter.instance.removeListener(this.zml);
        AppMethodBeat.o(66136);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void egT() {
        AppMethodBeat.i(66137);
        com.tencent.mm.plugin.mall.b.a.ehv();
        AppMethodBeat.o(66137);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void egU() {
        AppMethodBeat.i(66138);
        t.fQD().fRN();
        if ((t.fQD().fRN().fRn() || t.fQD().fRN().fRm()) && z.aUo()) {
            Log.e("MicorMsg.MallIndexUI", "hy: user not open wallet or status unknown. try query");
            doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.b.a("", false));
        }
        AppMethodBeat.o(66138);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(66139);
        this.isFinished = true;
        super.finish();
        AppMethodBeat.o(66139);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(66140);
        super.onSceneEnd(i2, i3, str, qVar);
        if (qVar instanceof e) {
            a(((e) qVar).zjm);
        } else if (qVar instanceof ad) {
            ad adVar = (ad) qVar;
            if (adVar.isJumpRemind() && adVar.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g() {
                /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.AnonymousClass4 */

                @Override // com.tencent.mm.wallet_core.c.g
                public final void eeY() {
                }
            })) {
                AppMethodBeat.o(66140);
                return true;
            }
        }
        AppMethodBeat.o(66140);
        return true;
    }

    private void a(final d dVar) {
        AppMethodBeat.i(66141);
        if (dVar == null || Util.isNullOrNil(dVar.zjl)) {
            AppMethodBeat.o(66141);
        } else if (this.zlI) {
            if (this.zlH != null) {
                this.zlH.setText(R.string.evt);
                this.zlH.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.AnonymousClass5 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(66102);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        new Intent();
                        f.cN(MallIndexUI.this, dVar.zjl);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(66102);
                    }
                });
            }
            AppMethodBeat.o(66141);
        } else {
            this.psf = View.inflate(this, R.layout.b5f, null);
            this.psf.setClickable(false);
            this.psf.setEnabled(false);
            this.zlH = (TextView) this.psf.findViewById(R.id.ji3);
            this.zlH.setVisibility(0);
            this.zlH.setText(R.string.evt);
            this.zlH.setTextColor(getResources().getColor(R.color.x0));
            this.zlH.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(66103);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    f.bn(MallIndexUI.this.getContext(), dVar.zjl);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(66103);
                }
            });
            if (this.zlh != null) {
                this.zlh.addFooterView(this.psf);
                this.zlI = true;
            }
            AppMethodBeat.o(66141);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final boolean egV() {
        AppMethodBeat.i(66128);
        Log.i("MicorMsg.MallIndexUI", "init BankcardList");
        final zv zvVar = new zv();
        zvVar.efR.scene = 1;
        zvVar.efR.efT = true;
        zvVar.efR.retryCount = 0;
        zvVar.efR.efU = true;
        zvVar.efS.efJ = new Runnable() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.AnonymousClass14 */
            boolean iMQ = false;

            public final void run() {
                AppMethodBeat.i(66111);
                if (MallIndexUI.this.isFinishing() || MallIndexUI.this.hasFinish() || MallIndexUI.this.isDestroyed()) {
                    AppMethodBeat.o(66111);
                    return;
                }
                Log.d("MicorMsg.MallIndexUI", "mUserInfo needBind : " + MallIndexUI.this.zlX.efW + " hasNewTips : " + MallIndexUI.this.zlX.efX + " swipeOn : " + MallIndexUI.this.zlX.efY);
                if (MallIndexUI.this.isFinished || MallIndexUI.this.getContext().isFinishing()) {
                    Log.e("MicorMsg.MallIndexUI", "error for callback ac finish");
                    AppMethodBeat.o(66111);
                    return;
                }
                Log.i("MicorMsg.MallIndexUI", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", Boolean.valueOf(zvVar.efS.egx), Boolean.valueOf(this.iMQ));
                MallIndexUI.this.zlX = zvVar.efS;
                if ((MallIndexUI.this.zlX.egy != null) && (MallIndexUI.this.zlX.egy instanceof m)) {
                    m mVar = (m) MallIndexUI.this.zlX.egy;
                    if (mVar.isJumpRemind()) {
                        mVar.getJumpRemind().a(MallIndexUI.this, new com.tencent.mm.wallet_core.c.g() {
                            /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.AnonymousClass14.AnonymousClass1 */

                            @Override // com.tencent.mm.wallet_core.c.g
                            public final void eeY() {
                            }
                        });
                    }
                }
                if (MallIndexUI.this.zlX.errCode == 0) {
                    MallIndexUI.this.ehf();
                    if (MallIndexUI.this.zlX.egx) {
                        MallIndexUI.this.ehb();
                    }
                    MallIndexUI.this.egW();
                    if (!this.iMQ) {
                        MallIndexUI.ehl();
                    }
                    MallIndexUI.b(MallIndexUI.this, MallIndexUI.this.zlX);
                    MallIndexUI.this.ehd();
                    Log.i("MicorMsg.MallIndexUI", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", Integer.valueOf(MallIndexUI.this.zlX.egt), Boolean.valueOf(MallIndexUI.this.zlX.egu), MallIndexUI.this.zlX.egv);
                    MallIndexUI.this.zlZ = MallIndexUI.this.zlX.egt == 1;
                    MallIndexUI.this.zma = MallIndexUI.this.zlX.egu;
                    MallIndexUI.this.egv = MallIndexUI.this.zlX.egv;
                    if (MallIndexUI.this.zlY != null) {
                        if (MallIndexUI.this.zlZ) {
                            MallIndexUI.this.zlY.setVisibility(0);
                        } else {
                            MallIndexUI.this.zlY.setVisibility(8);
                        }
                    }
                    MallIndexUI mallIndexUI = MallIndexUI.this;
                    mallIndexUI.zmb.a(new u.a() {
                        /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.AnonymousClass2 */

                        @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
                        public final void ehm() {
                        }

                        @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
                        public final void cancel() {
                            AppMethodBeat.i(66100);
                            MallIndexUI.this.finish();
                            AppMethodBeat.o(66100);
                        }

                        @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
                        public final void ehn() {
                        }
                    }, new al().fRi());
                }
                if (zvVar.efS.egx && this.iMQ) {
                    MallIndexUI.this.updateView();
                }
                this.iMQ = true;
                AppMethodBeat.o(66111);
            }
        };
        EventCenter.instance.asyncPublish(zvVar, Looper.myLooper());
        AppMethodBeat.o(66128);
        return false;
    }

    static /* synthetic */ void c(MallIndexUI mallIndexUI) {
        AppMethodBeat.i(66142);
        if (z.aUo()) {
            Intent intent = new Intent();
            intent.putExtra("key_scene_balance_manager", 2);
            com.tencent.mm.br.c.b(mallIndexUI, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", intent);
        } else {
            ImageView imageView = (ImageView) mallIndexUI.findViewById(R.id.few);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(mallIndexUI.getContext(), MallWalletUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(mallIndexUI, bl.axQ(), "com/tencent/mm/plugin/mall/ui/MallIndexUI", "handleClickBalanceEntry", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            mallIndexUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(mallIndexUI, "com/tencent/mm/plugin/mall/ui/MallIndexUI", "handleClickBalanceEntry", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            imageView.setVisibility(8);
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.FALSE);
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, (Object) 0L);
            h.INSTANCE.a(16500, 2);
        }
        f.aqm(11);
        h.INSTANCE.a(14419, mallIndexUI.uuid, 2);
        AppMethodBeat.o(66142);
    }

    static /* synthetic */ void ehl() {
        AppMethodBeat.i(66143);
        Log.i("MicorMsg.MallIndexUI", "query wechat wallet");
        j.a((j.a) null, false, false);
        AppMethodBeat.o(66143);
    }

    static /* synthetic */ boolean b(MallIndexUI mallIndexUI, zv.b bVar) {
        AppMethodBeat.i(66144);
        if (mallIndexUI.zmo) {
            Log.i("MicorMsg.MallIndexUI", "isDoRealname bye bye");
            AppMethodBeat.o(66144);
            return true;
        }
        if ("1".equals(bVar.egd)) {
            Log.i("MicorMsg.MallIndexUI", "need realname verify");
        } else if ("2".equals(bVar.egd)) {
            Log.i("MicorMsg.MallIndexUI", "need upload credit");
            mallIndexUI.zmo = true;
            o.a(mallIndexUI, bVar);
        } else if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(bVar.egd)) {
            Log.i("MicorMsg.MallIndexUI", "need increase the balance amount");
            ECardInfo fQq = ECardInfo.fQq();
            if (fQq != null && mallIndexUI.zmd == null && !mallIndexUI.zmc) {
                mallIndexUI.zmd = o.a(mallIndexUI, fQq, 0);
                mallIndexUI.zmd.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    /* class com.tencent.mm.plugin.mall.ui.MallIndexUI.AnonymousClass13 */

                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(66110);
                        MallIndexUI.this.zmd = null;
                        AppMethodBeat.o(66110);
                    }
                });
                mallIndexUI.zmc = true;
            }
        } else {
            Log.i("MicorMsg.MallIndexUI", "realnameGuideFlag =  " + bVar.egd);
        }
        AppMethodBeat.o(66144);
        return false;
    }
}
