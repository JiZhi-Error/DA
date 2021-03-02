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
import com.tencent.f.h;
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
public class MallIndexUIv2 extends MallIndexBaseUIv2 implements MStorageEx.IOnStorageChange {
    private String egv;
    private boolean isFinished = false;
    private View psf = null;
    private TextView zlH = null;
    private boolean zlI = false;
    zv.b zlX;
    private RelativeLayout zlY;
    private boolean zlZ;
    private c zmA = null;
    private int zmB;
    private boolean zma;
    u zmb = new u();
    private boolean zmc = false;
    private Dialog zmd;
    private boolean zme = false;
    private WcPayMoneyLoadingView zmh;
    private ProgressBar zmi;
    private IListener<ov> zmj = new IListener<ov>() {
        /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass1 */

        {
            AppMethodBeat.i(213561);
            this.__eventId = ov.class.getName().hashCode();
            AppMethodBeat.o(213561);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ov ovVar) {
            AppMethodBeat.i(213562);
            Log.i("MicorMsg.MallIndexUIv2", "open ecard finish");
            ECardInfo.bF(null);
            AppMethodBeat.o(213562);
            return false;
        }
    };
    private boolean zmk = false;
    private IListener zml = new IListener<aah>() {
        /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass9 */

        {
            AppMethodBeat.i(213569);
            this.__eventId = aah.class.getName().hashCode();
            AppMethodBeat.o(213569);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aah aah) {
            AppMethodBeat.i(213570);
            aah aah2 = aah;
            Log.i("MicorMsg.MallIndexUIv2", "real name verify callback, result: %s, isDoRealNameForBalance: %s", Integer.valueOf(aah2.ehe.result), Boolean.valueOf(MallIndexUIv2.this.zmk));
            if (aah2.ehe.result == -1 && MallIndexUIv2.this.zmk) {
                MallIndexUIv2.this.zmk = false;
                MallIndexUIv2.c(MallIndexUIv2.this);
            }
            AppMethodBeat.o(213570);
            return false;
        }
    };
    private IListener<aba> zmm = new IListener<aba>() {
        /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass10 */

        {
            AppMethodBeat.i(213571);
            this.__eventId = aba.class.getName().hashCode();
            AppMethodBeat.o(213571);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aba aba) {
            AppMethodBeat.i(213573);
            boolean a2 = a(aba);
            AppMethodBeat.o(213573);
            return a2;
        }

        private static boolean a(aba aba) {
            AppMethodBeat.i(213572);
            String str = aba.eim.dNk;
            Log.i("MicorMsg.MallIndexUIv2", "get result %s", str);
            if ("agree_privacy".equals(str)) {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_MALL_INDEX_GDPR_AGREE_BOOLEAN_SYNC, Boolean.TRUE);
            }
            AppMethodBeat.o(213572);
            return false;
        }
    };
    private boolean zmo = false;
    private RelativeLayout zmy;
    private b zmz = null;

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MallIndexUIv2() {
        AppMethodBeat.i(213584);
        AppMethodBeat.o(213584);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(213585);
        fixStatusbar(true);
        if (26 != Build.VERSION.SDK_INT) {
            setRequestedOrientation(1);
        }
        ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().add(this);
        ((com.tencent.mm.plugin.walletlock.a.b) g.af(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
        h.RTc.c(new Runnable() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(213574);
                k.aeJ(2);
                AppMethodBeat.o(213574);
            }
        }, "wxpay_mallindex_refresh_location");
        this.zlX = new zv.b();
        this.zlX.efV = false;
        this.zlX.efW = true;
        this.zlX.efX = false;
        this.zmj.alive();
        this.zmm.alive();
        this.zmb.IkQ = new u.b() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass12 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.b
            public final int eho() {
                return 3;
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.b
            public final Context getContext() {
                return MallIndexUIv2.this;
            }
        };
        e.ehs();
        a.j(this);
        super.onCreate(bundle);
        EventCenter.instance.addListener(this.zml);
        addSceneEndListener(2713);
        addSceneEndListener(385);
        if (com.tencent.mm.aw.b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
            g.aAi();
            a(new d((String) g.aAh().azQ().get(ar.a.USERINFO_MALL_INDEX_GDPR_CACHE_STRING_SYNC, "")));
            doSceneProgress(new e(), false);
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16500, 1);
        AppMethodBeat.o(213585);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2, com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(213586);
        super.initView();
        this.zlh.setPadding(a.zjP, 0, a.zjP, 0);
        AppMethodBeat.o(213586);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
    public final void initHeaderView() {
        AppMethodBeat.i(213587);
        this.vbj = aa.jQ(this).inflate(R.layout.b5i, (ViewGroup) null);
        this.zlh.addHeaderView(this.vbj, null, false);
        ehg();
        AppMethodBeat.o(213587);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
    public final void egZ() {
        AppMethodBeat.i(213588);
        String fSf = com.tencent.mm.plugin.wallet_core.model.mall.b.fSf();
        Log.i("MicorMsg.MallIndexUIv2", "emptyHint: %s", fSf);
        if (this.zlq == null) {
            this.zlq = aa.jQ(this).inflate(R.layout.b5j, (ViewGroup) null);
            this.zlh.addFooterView(this.zlq, null, false);
            TextView textView = (TextView) this.zlq.findViewById(R.id.ff1);
            f.aZ(textView, 100);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass13 */

                public final void onClick(View view) {
                    AppMethodBeat.i(213575);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicorMsg.MallIndexUIv2", "click settings btn");
                    com.tencent.mm.br.c.V(MallIndexUIv2.this.getContext(), "mall", ".ui.MallFunctionSettingsUI");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213575);
                }
            });
        }
        if (Util.isNullOrNil(fSf)) {
            this.zlq.setVisibility(8);
            this.zlq.setPadding(0, 0, 0, 0);
            AppMethodBeat.o(213588);
            return;
        }
        this.zlq.setVisibility(0);
        ((TextView) this.zlq.findViewById(R.id.ff1)).setText(fSf);
        getWindow().getDecorView().post(new Runnable() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(213576);
                int jo = com.tencent.mm.cb.a.jo(MallIndexUIv2.this.getContext());
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) MallIndexUIv2.this.getContext(), 53);
                int[] iArr = new int[2];
                MallIndexUIv2.this.zlh.getLocationInWindow(iArr);
                int bottom = (MallIndexUIv2.this.zlq.getBottom() + iArr[1]) - jo;
                int height = (MallIndexUIv2.this.zlh.getHeight() - MallIndexUIv2.this.zlq.getHeight()) + iArr[1];
                if (bottom > 0) {
                    height += bottom;
                }
                int i2 = (jo - height) - fromDPToPix;
                int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix((Context) MallIndexUIv2.this.getContext(), 33);
                Log.d("MicorMsg.MallIndexUIv2", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", Integer.valueOf(jo), Integer.valueOf(height), Integer.valueOf(MallIndexUIv2.this.zlq.getHeight()), Integer.valueOf(iArr[1]), Integer.valueOf(bottom), Integer.valueOf(i2));
                if (i2 > fromDPToPix2) {
                    MallIndexUIv2.this.zlq.setPadding(0, i2, 0, fromDPToPix2);
                    AppMethodBeat.o(213576);
                    return;
                }
                MallIndexUIv2.this.zlq.setPadding(0, fromDPToPix2, 0, fromDPToPix2);
                AppMethodBeat.o(213576);
            }
        });
        AppMethodBeat.o(213588);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
    public final void eq(View view) {
        AppMethodBeat.i(213589);
        this.zmz = new b(this, view);
        com.tencent.mm.plugin.newtips.a.exl().h(this.zmz);
        this.zmA = new c(this, view);
        this.zmA.ehq();
        com.tencent.mm.plugin.newtips.a.exl().h(this.zmA);
        AppMethodBeat.o(213589);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(213590);
        if (mStorageEx == ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg() && i2 == 4) {
            Log.i("MicorMsg.MallIndexUIv2", "on cache update: %s", obj);
            if (obj.equals("USERINFO_NEW_BALANCE_LONG")) {
                ehb();
            }
        }
        AppMethodBeat.o(213590);
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

        @Override // com.tencent.mm.plugin.mall.ui.MallIndexUIv2.a
        public final void eq(View view) {
            AppMethodBeat.i(213582);
            this.zmw = (LinearLayout) view.findViewById(R.id.fev);
            MallIndexUIv2.this.zll = (TextView) this.zmw.findViewById(R.id.jeh);
            MallIndexUIv2.this.zmh = (WcPayMoneyLoadingView) this.zmw.findViewById(R.id.jei);
            MallIndexUIv2.this.zmi = (ProgressBar) this.zmw.findViewById(R.id.jg5);
            MallIndexUIv2.this.zmy = (RelativeLayout) this.zmw.findViewById(R.id.jeg);
            MallIndexUIv2.this.getLifecycle().addObserver(MallIndexUIv2.this.zmh);
            MallIndexUIv2.this.zmh.setLoadingPb(MallIndexUIv2.this.zmi);
            MallIndexUIv2.this.zmh.setPrefixSymbol("¥");
            MallIndexUIv2.this.zmh.setTextColor(-1);
            MallIndexUIv2.this.zmh.setTextSize((float) com.tencent.mm.cb.a.fromDPToPix((Context) MallIndexUIv2.this.getContext(), 15));
            this.zmt = (ImageView) this.zmw.findViewById(R.id.few);
            this.pzn = (TextView) this.zmw.findViewById(R.id.fex);
            this.zmw.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.c.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(213581);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    MallIndexUIv2.c(MallIndexUIv2.this);
                    com.tencent.mm.plugin.newtips.a.exl().TC(15);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213581);
                }
            });
            AppMethodBeat.o(213582);
        }

        public final boolean ehq() {
            boolean z;
            AppMethodBeat.i(213583);
            g.aAi();
            boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
            g.aAi();
            long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, (Object) 0L)).longValue();
            if (!booleanValue || longValue <= 0 || System.currentTimeMillis() < longValue) {
                z = booleanValue;
            } else {
                Log.i("MicorMsg.MallIndexUIv2", "hasRedDot expire, ignore reddot");
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
            AppMethodBeat.o(213583);
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

        @Override // com.tencent.mm.plugin.mall.ui.MallIndexUIv2.a
        public final void eq(View view) {
            AppMethodBeat.i(213580);
            this.zmu = (LinearLayout) view.findViewById(R.id.fer);
            this.zmt = (ImageView) this.zmu.findViewById(R.id.fes);
            this.pzn = (TextView) this.zmu.findViewById(R.id.fet);
            this.zmu.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(213579);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.plugin.newtips.a.exl().TC(5);
                    Intent intent = new Intent();
                    intent.putExtra("key_from_scene", 1);
                    com.tencent.mm.br.c.b(MallIndexUIv2.this.getContext(), "offline", ".ui.WalletOfflineEntranceUI", intent);
                    ab.mg(9, 0);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11850, 5, 0);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14419, MallIndexUIv2.this.uuid, 1);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213579);
                }
            });
            AppMethodBeat.o(213580);
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
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
    public final void eha() {
        AppMethodBeat.i(213591);
        final zt ztVar = new zt();
        ztVar.efM.scene = "1";
        ztVar.callback = new Runnable() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass15 */

            public final void run() {
                AppMethodBeat.i(213577);
                if (!Util.isNullOrNil(ztVar.efN.efO)) {
                    f.a(MallIndexUIv2.this.zlm, ztVar.efN.efO, ztVar.efN.content, ztVar.efN.url);
                }
                AppMethodBeat.o(213577);
            }
        };
        EventCenter.instance.publish(ztVar);
        AppMethodBeat.o(213591);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006d  */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ehf() {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mall.ui.MallIndexUIv2.ehf():void");
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
    public final void ehb() {
        AppMethodBeat.i(213594);
        Log.i("MicorMsg.MallIndexUIv2", "updateBalanceNum");
        al alVar = new al();
        if (alVar.fRf()) {
            this.zll.setText((String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_RELEAY_NAME_BALANCE_CONTENT_STRING_SYNC, getString(R.string.fun)));
            this.zll.setVisibility(0);
            this.zmh.setVisibility(8);
            this.zmi.setVisibility(8);
            AppMethodBeat.o(213594);
            return;
        }
        if (alVar.fRh()) {
            Log.i("MicorMsg.MallIndexUIv2", "show balance amount");
            long longValue = ((Long) ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.USERINFO_NEW_BALANCE_LONG_SYNC, (Object) 0L)).longValue();
            if (this.zmh != null) {
                qU(alVar.fRj());
                if (this.zmh.getVisibility() == 0) {
                    this.zmh.setMoney(f.formatMoney2f(f.b(String.valueOf(longValue), "100", 2, RoundingMode.HALF_UP).doubleValue()));
                    AppMethodBeat.o(213594);
                    return;
                }
            } else {
                Log.w("MicorMsg.MallIndexUIv2", "moneyLoadingView is null");
            }
        }
        AppMethodBeat.o(213594);
    }

    private void qU(boolean z) {
        AppMethodBeat.i(213595);
        if (z) {
            this.zll.setText(getString(R.string.idn));
            this.zll.setVisibility(0);
            this.zmh.setVisibility(8);
            this.zmi.setVisibility(8);
            this.zmy.setVisibility(8);
            this.zmh.reset();
            AppMethodBeat.o(213595);
            return;
        }
        this.zll.setVisibility(8);
        this.zmh.setVisibility(0);
        this.zmi.setVisibility(0);
        this.zmy.setVisibility(0);
        AppMethodBeat.o(213595);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
    public final void ehd() {
        AppMethodBeat.i(213596);
        removeAllOptionMenu();
        Log.i("MicorMsg.MallIndexUIv2", "addIconOptionMenuByMode");
        addIconOptionMenu(0, 0, R.raw.icons_outlined_more, false, (MenuItem.OnMenuItemClickListener) new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(213565);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14872, 0, 0, "", "", 0);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(16500, 3);
                MallIndexUIv2 mallIndexUIv2 = MallIndexUIv2.this;
                boolean z = MallIndexUIv2.this.zlX.egc;
                Intent intent = new Intent();
                intent.putExtra("key_default_show_currency", z);
                com.tencent.mm.br.c.b(mallIndexUIv2, "wallet", ".pwd.ui.WalletPasswordSettingUI", intent, 6);
                AppMethodBeat.o(213565);
                return true;
            }
        });
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14872, 0, 0, "", "", 1);
        AppMethodBeat.o(213596);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(213597);
        Log.v("MicorMsg.MallIndexUIv2", "alvinluo MallIndexUI onResume");
        this.zmb.onResume();
        com.tencent.mm.plugin.walletlock.a.b bVar = (com.tencent.mm.plugin.walletlock.a.b) g.af(com.tencent.mm.plugin.walletlock.a.b.class);
        bVar.a(this, bVar.fUE(), null);
        super.onResume();
        ehb();
        AppMethodBeat.o(213597);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(213598);
        super.onPause();
        this.zmb.onPause();
        if (this.zmh != null) {
            this.zmh.reset();
        }
        AppMethodBeat.o(213598);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(213599);
        super.onDestroy();
        ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().remove(this);
        this.zmj.dead();
        this.zmm.dead();
        removeSceneEndListener(2713);
        removeSceneEndListener(385);
        EventCenter.instance.removeListener(this.zml);
        AppMethodBeat.o(213599);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
    public final void egT() {
        AppMethodBeat.i(213600);
        com.tencent.mm.plugin.mall.b.a.ehv();
        AppMethodBeat.o(213600);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(213601);
        this.isFinished = true;
        super.finish();
        AppMethodBeat.o(213601);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(213602);
        super.onSceneEnd(i2, i3, str, qVar);
        if (qVar instanceof e) {
            a(((e) qVar).zjm);
        } else if (qVar instanceof ad) {
            ad adVar = (ad) qVar;
            if (adVar.isJumpRemind() && adVar.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g() {
                /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass5 */

                @Override // com.tencent.mm.wallet_core.c.g
                public final void eeY() {
                }
            })) {
                AppMethodBeat.o(213602);
                return true;
            }
        }
        AppMethodBeat.o(213602);
        return true;
    }

    private void a(final d dVar) {
        AppMethodBeat.i(213603);
        if (dVar == null || Util.isNullOrNil(dVar.zjl)) {
            AppMethodBeat.o(213603);
        } else if (this.zlI) {
            if (this.zlH != null) {
                this.zlH.setText(R.string.evt);
                this.zlH.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass6 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(213566);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        new Intent();
                        f.cN(MallIndexUIv2.this, dVar.zjl);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213566);
                    }
                });
            }
            AppMethodBeat.o(213603);
        } else {
            this.psf = View.inflate(this, R.layout.b5f, null);
            this.psf.setClickable(false);
            this.psf.setEnabled(false);
            this.zlH = (TextView) this.psf.findViewById(R.id.ji3);
            this.zlH.setVisibility(0);
            this.zlH.setText(R.string.evt);
            this.zlH.setTextColor(getResources().getColor(R.color.x0));
            this.zlH.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass7 */

                public final void onClick(View view) {
                    AppMethodBeat.i(213567);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    f.bn(MallIndexUIv2.this.getContext(), dVar.zjl);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213567);
                }
            });
            if (this.zlh != null) {
                this.zlh.addFooterView(this.psf);
                this.zlI = true;
            }
            AppMethodBeat.o(213603);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
    public final void ehg() {
        AppMethodBeat.i(213604);
        if (this.vbj == null) {
            Log.i("MicorMsg.MallIndexUIv2", "header = null");
            AppMethodBeat.o(213604);
            return;
        }
        final LinearLayout linearLayout = (LinearLayout) this.vbj.findViewById(R.id.do6);
        if (linearLayout == null) {
            Log.i("MicorMsg.MallIndexUIv2", "headerContentLayout = null");
            AppMethodBeat.o(213604);
            return;
        }
        linearLayout.post(new Runnable() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass8 */

            public final void run() {
                int i2;
                AppMethodBeat.i(213568);
                int width = linearLayout.getWidth();
                MallIndexUIv2.this.zmB = linearLayout.getHeight();
                int fromDPToPix = (width - (com.tencent.mm.cb.a.fromDPToPix((Context) MallIndexUIv2.this.getContext(), 8) * 3)) / 2;
                LinearLayout linearLayout = (LinearLayout) MallIndexUIv2.this.vbj.findViewById(R.id.fev);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                int width2 = linearLayout.getWidth();
                int height = linearLayout.getHeight();
                if (width2 > fromDPToPix) {
                    layoutParams.width = fromDPToPix;
                    i2 = fromDPToPix;
                } else {
                    i2 = width2;
                }
                Log.i("MicorMsg.MallIndexUIv2", "headContentLayoutWidth:%s,itemLayoutMaxWidth ：%s,walletLayoutWidth:%s", Integer.valueOf(width), Integer.valueOf(fromDPToPix), Integer.valueOf(i2));
                LinearLayout linearLayout2 = (LinearLayout) MallIndexUIv2.this.vbj.findViewById(R.id.fer);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) linearLayout2.getLayoutParams();
                layoutParams2.width = i2;
                layoutParams2.height = height;
                int i3 = (width - (i2 * 2)) / 3;
                layoutParams2.leftMargin = i3;
                linearLayout2.setLayoutParams(layoutParams2);
                layoutParams.rightMargin = i3;
                linearLayout.setLayoutParams(layoutParams);
                AppMethodBeat.o(213568);
            }
        });
        AppMethodBeat.o(213604);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
    public final int ehh() {
        return this.zmB;
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(213605);
        Log.i("MicorMsg.MallIndexUIv2", "onActivityResult %s %s %s", Integer.valueOf(i2), Integer.valueOf(i3), intent);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 3) {
            if (i3 == -1) {
                this.zmb.ehm();
                AppMethodBeat.o(213605);
                return;
            }
            this.zmb.cancel();
            AppMethodBeat.o(213605);
        } else if (i2 == 5) {
            g.aAi();
            if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_MALL_INDEX_GDPR_AGREE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                finish();
            }
            AppMethodBeat.o(213605);
        } else {
            if (i2 == 6 && intent != null && intent.getIntExtra("is_switch_wallet", 0) == 1) {
                finish();
                sd sdVar = new sd();
                sdVar.dYH.context = getContext();
                EventCenter.instance.publish(sdVar);
            }
            AppMethodBeat.o(213605);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
    public final void dYP() {
        AppMethodBeat.i(213606);
        int color = getResources().getColor(R.color.zd);
        setActionbarColor(color);
        hideActionbarLine();
        findViewById(R.id.h93).setBackgroundColor(color);
        AppMethodBeat.o(213606);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
    public final void egS() {
        AppMethodBeat.i(213607);
        setMMTitle(R.string.evy);
        AppMethodBeat.o(213607);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2
    public final boolean egV() {
        AppMethodBeat.i(213592);
        Log.i("MicorMsg.MallIndexUIv2", "init BankcardList");
        final zv zvVar = new zv();
        zvVar.efR.scene = 1;
        zvVar.efR.efT = true;
        zvVar.efR.retryCount = 0;
        zvVar.efR.efU = true;
        zvVar.efS.efJ = new Runnable() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass2 */
            boolean iMQ = false;

            public final void run() {
                boolean z;
                AppMethodBeat.i(213563);
                if (MallIndexUIv2.this.isFinishing() || MallIndexUIv2.this.hasFinish() || MallIndexUIv2.this.isDestroyed()) {
                    AppMethodBeat.o(213563);
                    return;
                }
                Log.d("MicorMsg.MallIndexUIv2", "mUserInfo needBind : " + MallIndexUIv2.this.zlX.efW + " hasNewTips : " + MallIndexUIv2.this.zlX.efX + " swipeOn : " + MallIndexUIv2.this.zlX.efY);
                if (MallIndexUIv2.this.isFinished || MallIndexUIv2.this.getContext().isFinishing()) {
                    Log.e("MicorMsg.MallIndexUIv2", "error for callback ac finish");
                    AppMethodBeat.o(213563);
                    return;
                }
                Log.i("MicorMsg.MallIndexUIv2", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", Boolean.valueOf(zvVar.efS.egx), Boolean.valueOf(this.iMQ));
                MallIndexUIv2.this.zlX = zvVar.efS;
                if ((MallIndexUIv2.this.zlX.egy != null) && (MallIndexUIv2.this.zlX.egy instanceof m)) {
                    m mVar = (m) MallIndexUIv2.this.zlX.egy;
                    if (mVar.isJumpRemind()) {
                        mVar.getJumpRemind().a(MallIndexUIv2.this, new com.tencent.mm.wallet_core.c.g() {
                            /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.wallet_core.c.g
                            public final void eeY() {
                            }
                        });
                    }
                }
                if (MallIndexUIv2.this.zlX.errCode == 0) {
                    MallIndexUIv2.this.ehf();
                    if (MallIndexUIv2.this.zlX.egx) {
                        MallIndexUIv2.this.ehb();
                    }
                    MallIndexUIv2 mallIndexUIv2 = MallIndexUIv2.this;
                    Log.i("MicorMsg.MallIndexUIv2", "showGetNewWalletTip call");
                    if (mallIndexUIv2.zlX == null || (!mallIndexUIv2.zlX.efV && !mallIndexUIv2.zlX.egb)) {
                        Log.e("MicorMsg.MallIndexUIv2", "user is not reg or simplereg，should not show this dialog");
                    } else {
                        boolean fRc = t.fQI().fRs().fRc();
                        Object obj = g.aAh().azQ().get(ar.a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.FALSE);
                        if (obj != null) {
                            z = ((Boolean) obj).booleanValue();
                        } else {
                            z = false;
                        }
                        Log.i("MicorMsg.MallIndexUIv2", "showGetNewWalletTip hadShow=" + z + ";isswc=" + fRc);
                        if (!z && fRc) {
                            g.aAh().azQ().set(ar.a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.TRUE);
                            o.hN(mallIndexUIv2);
                        }
                    }
                    if (!this.iMQ) {
                        MallIndexUIv2.ehr();
                    }
                    MallIndexUIv2.b(MallIndexUIv2.this, MallIndexUIv2.this.zlX);
                    MallIndexUIv2.this.ehd();
                    Log.i("MicorMsg.MallIndexUIv2", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", Integer.valueOf(MallIndexUIv2.this.zlX.egt), Boolean.valueOf(MallIndexUIv2.this.zlX.egu), MallIndexUIv2.this.zlX.egv);
                    MallIndexUIv2.this.zlZ = MallIndexUIv2.this.zlX.egt == 1;
                    MallIndexUIv2.this.zma = MallIndexUIv2.this.zlX.egu;
                    MallIndexUIv2.this.egv = MallIndexUIv2.this.zlX.egv;
                    if (MallIndexUIv2.this.zlY != null) {
                        if (MallIndexUIv2.this.zlZ) {
                            MallIndexUIv2.this.zlY.setVisibility(0);
                        } else {
                            MallIndexUIv2.this.zlY.setVisibility(8);
                        }
                    }
                    MallIndexUIv2 mallIndexUIv22 = MallIndexUIv2.this;
                    mallIndexUIv22.zmb.a(new u.a() {
                        /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass3 */

                        @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
                        public final void ehm() {
                        }

                        @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
                        public final void cancel() {
                            AppMethodBeat.i(213564);
                            MallIndexUIv2.this.finish();
                            AppMethodBeat.o(213564);
                        }

                        @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
                        public final void ehn() {
                        }
                    }, new al().fRi());
                }
                if (zvVar.efS.egx && this.iMQ) {
                    MallIndexUIv2.this.updateView();
                }
                this.iMQ = true;
                AppMethodBeat.o(213563);
            }
        };
        EventCenter.instance.asyncPublish(zvVar, Looper.myLooper());
        AppMethodBeat.o(213592);
        return false;
    }

    static /* synthetic */ void c(MallIndexUIv2 mallIndexUIv2) {
        AppMethodBeat.i(213608);
        if (z.aUo()) {
            Intent intent = new Intent();
            intent.putExtra("key_scene_balance_manager", 2);
            com.tencent.mm.br.c.b(mallIndexUIv2, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", intent);
        } else {
            ImageView imageView = (ImageView) mallIndexUIv2.findViewById(R.id.few);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(mallIndexUIv2.getContext(), MallWalletUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(mallIndexUIv2, bl.axQ(), "com/tencent/mm/plugin/mall/ui/MallIndexUIv2", "handleClickBalanceEntry", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            mallIndexUIv2.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(mallIndexUIv2, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2", "handleClickBalanceEntry", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            imageView.setVisibility(8);
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_BOOLEAN_SYNC, Boolean.FALSE);
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MALL_UI_REDDOT_CONFIG_EXPIRETIME_LONG_SYNC, (Object) 0L);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16500, 2);
        }
        f.aqm(11);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14419, mallIndexUIv2.uuid, 2);
        AppMethodBeat.o(213608);
    }

    static /* synthetic */ void ehr() {
        AppMethodBeat.i(213609);
        Log.i("MicorMsg.MallIndexUIv2", "query wechat wallet");
        j.a((j.a) null, false, false);
        AppMethodBeat.o(213609);
    }

    static /* synthetic */ boolean b(MallIndexUIv2 mallIndexUIv2, zv.b bVar) {
        AppMethodBeat.i(213610);
        if (mallIndexUIv2.zmo) {
            Log.i("MicorMsg.MallIndexUIv2", "isDoRealname bye bye");
            AppMethodBeat.o(213610);
            return true;
        }
        if ("1".equals(bVar.egd)) {
            Log.i("MicorMsg.MallIndexUIv2", "need realname verify");
        } else if ("2".equals(bVar.egd)) {
            Log.i("MicorMsg.MallIndexUIv2", "need upload credit");
            mallIndexUIv2.zmo = true;
            o.a(mallIndexUIv2, bVar);
        } else if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(bVar.egd)) {
            Log.i("MicorMsg.MallIndexUIv2", "need increase the balance amount");
            ECardInfo fQq = ECardInfo.fQq();
            if (fQq != null && mallIndexUIv2.zmd == null && !mallIndexUIv2.zmc) {
                mallIndexUIv2.zmd = o.a(mallIndexUIv2, fQq, 0);
                mallIndexUIv2.zmd.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    /* class com.tencent.mm.plugin.mall.ui.MallIndexUIv2.AnonymousClass16 */

                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(213578);
                        MallIndexUIv2.this.zmd = null;
                        AppMethodBeat.o(213578);
                    }
                });
                mallIndexUIv2.zmc = true;
            }
        } else {
            Log.i("MicorMsg.MallIndexUIv2", "realnameGuideFlag =  " + bVar.egd);
        }
        AppMethodBeat.o(213610);
        return false;
    }
}
