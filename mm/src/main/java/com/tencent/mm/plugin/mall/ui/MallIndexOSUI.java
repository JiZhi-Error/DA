package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.aat;
import com.tencent.mm.g.a.aav;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.mall.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.exd;
import com.tencent.mm.protocal.protobuf.exe;
import com.tencent.mm.protocal.protobuf.exk;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e;
import com.tencent.mm.wallet_core.ui.f;

public class MallIndexOSUI extends MallIndexBaseUI {
    private boolean isFinished = false;
    private boolean isFirst = true;
    private long lastUpdateTime = 0;
    private View psf = null;
    private a[] zlF = new a[4];
    private aj zlG = new aj();
    private TextView zlH = null;
    private boolean zlI = false;
    private long zlJ = 0;
    private boolean zlK = false;
    private boolean zlL = false;
    private String zlM = "";
    private int zlN = 0;
    private IListener zlO = new IListener<aat>() {
        /* class com.tencent.mm.plugin.mall.ui.MallIndexOSUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160809);
            this.__eventId = aat.class.getName().hashCode();
            AppMethodBeat.o(160809);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aat aat) {
            AppMethodBeat.i(66075);
            aat aat2 = aat;
            Log.i("MicroMsg.MallIndexOSUI", "WebViewCloseWindowEventListener %s", aat2.ehI.dvn);
            if (MallIndexOSUI.this.zlM != null && MallIndexOSUI.this.zlM.equals(aat2.ehI.dvn)) {
                MallIndexOSUI.this.zlK = true;
            }
            AppMethodBeat.o(66075);
            return false;
        }
    };
    private IListener zlP = new IListener<aav>() {
        /* class com.tencent.mm.plugin.mall.ui.MallIndexOSUI.AnonymousClass2 */

        {
            AppMethodBeat.i(160810);
            this.__eventId = aav.class.getName().hashCode();
            AppMethodBeat.o(160810);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aav aav) {
            AppMethodBeat.i(66077);
            aav aav2 = aav;
            Log.i("MicroMsg.MallIndexOSUI", "WebViewUIDestroyEvent %s isCloseWindow %s", aav2.ehL.dvn, Boolean.valueOf(MallIndexOSUI.this.zlK));
            if (MallIndexOSUI.this.zlM != null && MallIndexOSUI.this.zlM.equals(aav2.ehL.dvn)) {
                MallIndexOSUI.this.zlL = true;
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.mall.ui.MallIndexOSUI.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(66076);
                        if (!MallIndexOSUI.this.zlK) {
                            MallIndexOSUI.this.finish();
                        }
                        AppMethodBeat.o(66076);
                    }
                }, 500);
            }
            AppMethodBeat.o(66077);
            return false;
        }
    };

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MallIndexOSUI() {
        AppMethodBeat.i(66081);
        AppMethodBeat.o(66081);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(66082);
        e.ehs();
        a.b(this, false);
        customfixStatusbar(true);
        super.onCreate(bundle);
        this.psf = View.inflate(this, R.layout.b5b, null);
        this.psf.setClickable(false);
        this.psf.setEnabled(false);
        this.zlH = (TextView) this.psf.findViewById(R.id.ji3);
        this.zlG = t.fQO().aeO(this.zjs);
        addSceneEndListener(1577);
        Log.i("MicroMsg.MallIndexOSUI", "walletMallIndexOsUI ");
        i iVar = new i();
        if (this.zlG != null) {
            aj ajVar = this.zlG;
            if (ajVar.Ibw == null || ajVar.Ibw.LSL == null || ajVar.Ibw.LSL.size() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                doSceneProgress(iVar, false);
                AppMethodBeat.o(66082);
                return;
            }
        }
        doSceneForceProgress(iVar);
        AppMethodBeat.o(66082);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(66083);
        super.initView();
        this.zlh.setPadding(a.zjP, 0, a.zjP, 0);
        AppMethodBeat.o(66083);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void eha() {
        AppMethodBeat.i(66084);
        f.a(this.zlm, "1", this.zlG.IbB, this.zlG.yXn);
        AppMethodBeat.o(66084);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void a(MallFunction mallFunction, int i2) {
        AppMethodBeat.i(66085);
        super.a(mallFunction, i2);
        h hVar = h.INSTANCE;
        g.aAi();
        hVar.a(13720, mallFunction.h5Url, Long.valueOf(Util.safeParseLong(mallFunction.kHR)), (Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0));
        AppMethodBeat.o(66085);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void dYP() {
        AppMethodBeat.i(66086);
        int color = getResources().getColor(R.color.zd);
        setActionbarColor(color);
        hideActionbarLine();
        findViewById(R.id.h93).setBackgroundColor(color);
        AppMethodBeat.o(66086);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void egS() {
        AppMethodBeat.i(66087);
        String str = this.zlG.Ibz;
        String str2 = this.zlG.IbA;
        setMMTitle(str);
        if (!Util.isNullOrNil(str2)) {
            setMMSubTitle(str2);
        }
        AppMethodBeat.o(66087);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void initHeaderView() {
        AppMethodBeat.i(66088);
        this.vbj = aa.jQ(this).inflate(R.layout.b5k, (ViewGroup) null);
        this.zlh.addHeaderView(this.vbj);
        LinearLayout linearLayout = (LinearLayout) this.vbj.findViewById(R.id.do6);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = a.egN();
        linearLayout.setLayoutParams(layoutParams);
        AppMethodBeat.o(66088);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void egZ() {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void eq(View view) {
        AppMethodBeat.i(66089);
        this.zlF[0] = new a();
        this.zlF[0].view = view.findViewById(R.id.g3_);
        this.zlF[0].zjO = (CdnImageView) view.findViewById(R.id.g3b);
        this.zlF[0].zjO.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        this.zlF[0].gyt = (TextView) view.findViewById(R.id.g3h);
        this.zlF[0].zlW = (TextView) view.findViewById(R.id.c7q);
        this.zlF[0].zjO.setVisibility(4);
        this.zlF[1] = new a();
        this.zlF[1].view = view.findViewById(R.id.zq);
        this.zlF[1].zjO = (CdnImageView) view.findViewById(R.id.a02);
        this.zlF[1].zjO.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        this.zlF[1].gyt = (TextView) view.findViewById(R.id.a08);
        this.zlF[1].zlW = (TextView) view.findViewById(R.id.a01);
        this.zlF[1].zjO.setVisibility(4);
        this.zlF[2] = new a();
        this.zlF[2].view = view.findViewById(R.id.a10);
        this.zlF[2].zjO = (CdnImageView) view.findViewById(R.id.a1x);
        this.zlF[2].zjO.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        this.zlF[2].gyt = (TextView) view.findViewById(R.id.a22);
        this.zlF[2].zlW = (TextView) view.findViewById(R.id.c7r);
        this.zlF[2].zjO.setVisibility(4);
        this.zlF[3] = new a();
        this.zlF[3].view = view.findViewById(R.id.ev0);
        this.zlF[3].zjO = (CdnImageView) view.findViewById(R.id.ex_);
        this.zlF[3].gyt = (TextView) view.findViewById(R.id.exr);
        this.zlF[3].zjO.setVisibility(4);
        this.zlF[3].view.setVisibility(8);
        AppMethodBeat.o(66089);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void egT() {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void egU() {
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(66090);
        super.onResume();
        if (!this.isFirst) {
            int i2 = com.tencent.mm.n.h.aqJ().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000;
            long currentTimeMillis = System.currentTimeMillis();
            Log.d("MicroMsg.MallIndexOSUI", "checkUpdate svrTime: %d lastUpdateTime : %d  curTime %d", Integer.valueOf(i2), Long.valueOf(this.lastUpdateTime), Long.valueOf(currentTimeMillis));
            if (currentTimeMillis - this.lastUpdateTime >= ((long) i2)) {
                this.lastUpdateTime = System.currentTimeMillis();
                doSceneProgress(new i(), false);
            }
        } else {
            this.isFirst = false;
        }
        egS();
        AppMethodBeat.o(66090);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(66091);
        super.onPause();
        AppMethodBeat.o(66091);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(66092);
        super.onDestroy();
        removeSceneEndListener(1577);
        this.zlO.dead();
        this.zlP.dead();
        AppMethodBeat.o(66092);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final boolean egV() {
        AppMethodBeat.i(66093);
        exd exd = this.zlG.Ibw;
        for (int i2 = 0; i2 < this.zlF.length; i2++) {
            this.zlF[i2].view.setVisibility(8);
            this.zlF[i2].zjO.setImageBitmap(null);
        }
        int i3 = 0;
        while (i3 < exd.LSL.size() && i3 < this.zlF.length) {
            final exe exe = exd.LSL.get(i3);
            this.zlF[i3].view.setVisibility(0);
            this.zlF[i3].zjO.setUrl(z.a(exe.NuC));
            this.zlF[i3].zjO.setVisibility(0);
            this.zlF[i3].gyt.setText(z.a(exe.NuB));
            Log.i("MicroMsg.MallIndexOSUI", "item %d url %s", Integer.valueOf(i3), z.a(exe.NuC));
            this.zlF[i3].zlW.setVisibility(8);
            String a2 = z.a(exe.NuE);
            if (!Util.isNullOrNil(a2)) {
                this.zlF[i3].zlW.setText(a2);
                this.zlF[i3].zlW.setVisibility(0);
            }
            this.zlF[i3].view.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.mall.ui.MallIndexOSUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(66078);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexOSUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    h.INSTANCE.a(13867, z.a(exe.NuD), Integer.valueOf(MallIndexOSUI.this.zjs));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", z.a(exe.NuD));
                    intent.putExtra("geta8key_username", com.tencent.mm.model.z.aTY());
                    intent.putExtra("pay_channel", 1);
                    intent.putExtra(e.p.OzJ, true);
                    f.aA(MallIndexOSUI.this.getContext(), intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexOSUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(66078);
                }
            });
            i3++;
        }
        if (!(this.zlh == null || this.psf == null || this.zlI)) {
            this.zlh.addFooterView(this.psf);
            this.zlI = true;
        }
        if (!Util.isNullOrNil(this.zlG.IbC)) {
            this.zlH.setText(this.zlG.IbC);
            this.zlH.setVisibility(0);
        }
        AppMethodBeat.o(66093);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void egW() {
        boolean z;
        AppMethodBeat.i(66094);
        Log.i("MicroMsg.MallIndexOSUI", "showGetNewWalletTip call");
        boolean z2 = this.zlG.Iby;
        g.aAi();
        Object obj = g.aAh().azQ().get(ar.a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.FALSE);
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        } else {
            z = false;
        }
        Log.i("MicroMsg.MallIndexOSUI", "showGetNewWalletTip hadShow=" + z + ";isswc=" + z2);
        if (!z && z2) {
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.TRUE);
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.ew1), (String) null, true, (DialogInterface.OnClickListener) null);
        }
        AppMethodBeat.o(66094);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void ehb() {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void ehd() {
        AppMethodBeat.i(66095);
        removeAllOptionMenu();
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexOSUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String[] strArr;
                AppMethodBeat.i(66080);
                final exk exk = MallIndexOSUI.this.zlG.Ibx;
                final boolean z = MallIndexOSUI.this.zlG.Iby;
                if (z) {
                    String[] strArr2 = new String[(exk.LSL.size() + 1)];
                    strArr2[exk.LSL.size()] = MallIndexOSUI.this.getString(R.string.ie5);
                    strArr = strArr2;
                } else {
                    strArr = new String[exk.LSL.size()];
                }
                for (int i2 = 0; i2 < exk.LSL.size(); i2++) {
                    strArr[i2] = z.a(exk.LSL.get(i2).NuB);
                }
                com.tencent.mm.ui.base.h.b(MallIndexOSUI.this.getContext(), null, strArr, null, new h.d() {
                    /* class com.tencent.mm.plugin.mall.ui.MallIndexOSUI.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        AppMethodBeat.i(66079);
                        if (i2 < exk.LSL.size()) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", z.a(exk.LSL.get(i2).NuN));
                            intent.putExtra(e.p.OzJ, true);
                            f.aA(MallIndexOSUI.this.getContext(), intent);
                            AppMethodBeat.o(66079);
                            return;
                        }
                        if (z) {
                            c.d(MallIndexOSUI.this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
                        }
                        AppMethodBeat.o(66079);
                    }
                });
                AppMethodBeat.o(66080);
                return true;
            }
        });
        AppMethodBeat.o(66095);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI
    public final void ehf() {
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(66096);
        this.isFinished = true;
        super.finish();
        AppMethodBeat.o(66096);
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4;
        AppMethodBeat.i(66097);
        super.onSceneEnd(i2, i3, str, qVar);
        if (qVar.getType() == 1577) {
            i iVar = (i) qVar;
            if (iVar.zjx == null) {
                i4 = 0;
            } else {
                i4 = iVar.zjx.NuH;
            }
            if (i4 == 1 && !Util.isNullOrNil(iVar.egK())) {
                if (this.isFinished) {
                    AppMethodBeat.o(66097);
                    return true;
                } else if (System.currentTimeMillis() - this.zlJ > 500) {
                    this.zlJ = System.currentTimeMillis();
                    this.zlO.alive();
                    this.zlP.alive();
                    Bundle bundle = new Bundle();
                    this.zlM = iVar.egK();
                    Intent intent = new Intent();
                    Log.i("MicroMsg.MallIndexOSUI", "startWebViewUI %s", this.zlM);
                    bundle.putString("KoriginUrl", this.zlM);
                    bundle.putBoolean("KIsHKAgreeUrl", true);
                    intent.putExtra("rawUrl", this.zlM);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("geta8key_username", com.tencent.mm.model.z.aTY());
                    intent.putExtra("pay_channel", 1);
                    f.b(getContext(), intent, 4);
                }
            }
            this.zlG = t.fQO().aeO(this.zjs);
            eha();
            egV();
            egS();
            egW();
        }
        AppMethodBeat.o(66097);
        return true;
    }

    @Override // com.tencent.mm.plugin.mall.ui.MallIndexBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(66098);
        Log.i("MicroMsg.MallIndexOSUI", "onActivityResult requestCode %s resultCode %s", Integer.valueOf(i2), Integer.valueOf(i3));
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(66098);
    }

    /* access modifiers changed from: package-private */
    public class a {
        public TextView gyt;
        public View view;
        public CdnImageView zjO;
        public TextView zlW;

        a() {
        }
    }
}
