package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.biu;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.e;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.smtt.sdk.WebView;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletBalanceManagerUI extends WalletBaseUI implements l, MStorageEx.IOnStorageChange {
    private static final String yQK = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1p) + "/touch/scene_product.html?scene_id=kf4");
    private IListener<lj> AJa = new IListener<lj>() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.AnonymousClass7 */

        {
            AppMethodBeat.i(163860);
            this.__eventId = lj.class.getName().hashCode();
            AppMethodBeat.o(163860);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lj ljVar) {
            AppMethodBeat.i(163861);
            lj ljVar2 = ljVar;
            Log.i("MicroMsg.WalletBalanceManagerUI", "KindaBindCardEvent callback");
            if (ljVar2 == null || !(ljVar2 instanceof lj)) {
                AppMethodBeat.o(163861);
                return false;
            }
            z.hhs();
            if (ljVar2.dQz != null) {
                if (ljVar2.dQz.dQA) {
                    Log.i("MicroMsg.WalletBalanceManagerUI", "KindaBindCardEvent bindCard Succ");
                    Log.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from WalletBalanceManagerUI");
                    com.tencent.mm.wallet_core.a.a(WalletBalanceManagerUI.this, com.tencent.mm.plugin.wallet.balance.b.class, (Bundle) null, (d.a) null);
                    f.aqm(15);
                } else {
                    Log.i("MicroMsg.WalletBalanceManagerUI", "KindaBindCardEvent bindCard Cancel");
                }
            }
            EventCenter.instance.removeListener(WalletBalanceManagerUI.this.AJa);
            AppMethodBeat.o(163861);
            return true;
        }
    };
    protected Button HvV;
    protected View HvW;
    protected TextView HvX;
    private ViewGroup HvY;
    private TextView HvZ;
    protected TextView Hvg;
    private ImageView Hwa;
    private WcPayMoneyLoadingView Hwb;
    protected Bankcard Hwc;
    private bj Hwd;
    private h Hwe;
    private com.tencent.mm.plugin.wallet.balance.model.a Hwf;
    private ViewGroup Hwg;
    private CdnImageView Hwh;
    private TextView Hwi;
    private CdnImageView Hwj;
    private View Hwk;
    private TextView Hwl;
    protected int mScene;
    private ProgressBar zmU;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBalanceManagerUI() {
        AppMethodBeat.i(68663);
        AppMethodBeat.o(68663);
    }

    static /* synthetic */ boolean a(WalletBalanceManagerUI walletBalanceManagerUI) {
        AppMethodBeat.i(68680);
        boolean needConfirmFinish = walletBalanceManagerUI.needConfirmFinish();
        AppMethodBeat.o(68680);
        return needConfirmFinish;
    }

    static {
        AppMethodBeat.i(213909);
        AppMethodBeat.o(213909);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c7m;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        ECardInfo fQq;
        AppMethodBeat.i(68664);
        fixStatusbar(true);
        super.onCreate(bundle);
        ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().add(this);
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        ((com.tencent.mm.plugin.walletlock.a.b) g.af(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68645);
                if (WalletBalanceManagerUI.a(WalletBalanceManagerUI.this)) {
                    WalletBalanceManagerUI.this.hideVKB();
                    WalletBalanceManagerUI.this.showDialog(1000);
                } else {
                    WalletBalanceManagerUI.this.finish();
                }
                AppMethodBeat.o(68645);
                return true;
            }
        }, R.raw.actionbar_icon_dark_back);
        this.mScene = getIntent().getIntExtra("key_scene_balance_manager", 0);
        dju fQp = ECardInfo.fQp();
        if (fQp != null) {
            if (fQp.KCl == 1) {
                Bundle bundle2 = new Bundle();
                isTransparent();
                com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle2, null, 0);
            } else if (fQp.KCl == 3 && (fQq = ECardInfo.fQq()) != null) {
                o.a(this, fQq, 1);
            }
        }
        addSceneEndListener(com.tencent.mm.plugin.appbrand.af.h.CTRL_INDEX);
        t.fQP();
        ah.a(this);
        initView();
        ab.mg(2, 0);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11850, 6, 0);
        f.aqm(10);
        a(w.ba(XmlParser.parseXml((String) ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.USERINFO_BALANCE_FREEZE_MESSAGE_STRING_SYNC, ""), "sysmsg", null)));
        AppMethodBeat.o(68664);
    }

    private void a(final w wVar) {
        AppMethodBeat.i(68665);
        if (wVar == null) {
            this.Hwg.setVisibility(8);
            AppMethodBeat.o(68665);
            return;
        }
        if (!Util.isNullOrNil(wVar.Ibd)) {
            this.Hwh.setUrl(wVar.Ibd);
            this.Hwh.setVisibility(0);
        } else {
            this.Hwh.setVisibility(8);
        }
        if (!Util.isNullOrNil(wVar.Ibe)) {
            this.Hwj.setUrl(wVar.Ibe);
            this.Hwj.setVisibility(0);
        } else {
            this.Hwj.setVisibility(8);
        }
        this.Hwi.setText(wVar.dQx);
        if (!Util.isNullOrNil(wVar.Iba)) {
            if (ao.isDarkMode()) {
                this.Hwi.setTextColor(ao.hT(Util.getHex(wVar.Iba, WebView.NIGHT_MODE_COLOR)));
            } else {
                this.Hwi.setTextColor(Util.getHex(wVar.Iba, WebView.NIGHT_MODE_COLOR));
            }
        }
        this.Hwi.setTextSize(1, (float) wVar.Ibb);
        if (!Util.isNullOrNil(wVar.DWN)) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (ao.isDarkMode()) {
                gradientDrawable.setColor(ao.hT(Util.getHex(wVar.DWN, -1)));
            } else {
                gradientDrawable.setColor(Util.getHex(wVar.DWN, -1));
            }
            gradientDrawable.setCornerRadius((float) com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 4));
            this.Hwg.setBackground(gradientDrawable);
        }
        this.Hwg.setVisibility(0);
        this.Hwg.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(68655);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.WalletBalanceManagerUI", "click freeze layout");
                f.o(WalletBalanceManagerUI.this.getContext(), wVar.Ibc, true);
                w.aVh("");
                WalletBalanceManagerUI.this.Hwg.setVisibility(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68655);
            }
        });
        this.HvY.setVisibility(8);
        AppMethodBeat.o(68665);
    }

    /* access modifiers changed from: protected */
    public void fNn() {
        AppMethodBeat.i(68666);
        s.fOg();
        doSceneProgress(new ad(null, 10), s.fOh().Hwc == null);
        AppMethodBeat.o(68666);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(68667);
        removeSceneEndListener(com.tencent.mm.plugin.appbrand.af.h.CTRL_INDEX);
        t.fQP();
        ah.b(this);
        ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().remove(this);
        if (this.Hwf != null) {
            this.Hwf.cancel();
        }
        this.Hwf = null;
        super.onDestroy();
        AppMethodBeat.o(68667);
    }

    /* access modifiers changed from: protected */
    public void fNo() {
        AppMethodBeat.i(68668);
        startActivity(WalletBalanceSaveUI.class);
        AppMethodBeat.o(68668);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(68669);
        setMMTitle("");
        this.Hwb = (WcPayMoneyLoadingView) findViewById(R.id.jdn);
        this.zmU = (ProgressBar) findViewById(R.id.jg5);
        this.Hvg = (TextView) findViewById(R.id.jd_);
        this.Hwb.setLoadingPb(this.zmU);
        this.Hwb.setPrefixSymbol(getString(R.string.ir3));
        getLifecycle().addObserver(this.Hwb);
        ((Button) findViewById(R.id.fz0)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(68657);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletBalanceManagerUI.this.fNo();
                f.aqm(14);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68657);
            }
        });
        this.HvV = (Button) findViewById(R.id.jda);
        this.HvV.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(68658);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                s.fOg();
                ArrayList<Bankcard> fRG = s.fOh().fRG();
                if (fRG == null || fRG.size() == 0) {
                    Log.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is empty, do bind card to fetch");
                    WalletBalanceManagerUI.d(WalletBalanceManagerUI.this);
                } else {
                    Log.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is valid, to do fetch");
                    com.tencent.mm.wallet_core.a.a(WalletBalanceManagerUI.this, com.tencent.mm.plugin.wallet.balance.b.class, (Bundle) null, (d.a) null);
                    f.aqm(15);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68658);
            }
        });
        this.Hwk = findViewById(R.id.jdb);
        this.Hwl = (TextView) findViewById(R.id.jd9);
        TextView textView = (TextView) findViewById(R.id.jdc);
        if (!isOverseasUser()) {
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.AnonymousClass13 */

                public final void onClick(View view) {
                    AppMethodBeat.i(68659);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", WalletBalanceManagerUI.yQK);
                    intent.putExtra("showShare", false);
                    intent.putExtra("geta8key_username", com.tencent.mm.model.z.aTY());
                    intent.putExtra(e.p.OzJ, true);
                    f.aA(WalletBalanceManagerUI.this.getContext(), intent);
                    f.aqm(17);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(68659);
                }
            });
            textView.setVisibility(0);
            f.G(textView);
        } else {
            textView.setVisibility(8);
        }
        ((TextView) findViewById(R.id.ji8)).setText(com.tencent.mm.wallet_core.c.ah.hhy());
        this.HvY = (ViewGroup) findViewById(R.id.zo);
        this.HvZ = (TextView) findViewById(R.id.zp);
        this.Hwa = (ImageView) findViewById(R.id.zn);
        this.HvW = findViewById(R.id.eas);
        this.HvX = (TextView) findViewById(R.id.eat);
        this.Hwg = (ViewGroup) findViewById(R.id.zy);
        this.Hwi = (TextView) findViewById(R.id.zw);
        this.Hwh = (CdnImageView) findViewById(R.id.zx);
        this.Hwj = (CdnImageView) findViewById(R.id.zv);
        final zt ztVar = new zt();
        ztVar.efM.scene = "2";
        ztVar.callback = new Runnable() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(68660);
                if (!Util.isNullOrNil(ztVar.efN.efO)) {
                    f.a(WalletBalanceManagerUI.this.Hvg, ztVar.efN.efO, ztVar.efN.content, ztVar.efN.url);
                }
                AppMethodBeat.o(68660);
            }
        };
        EventCenter.instance.publish(ztVar);
        AppMethodBeat.o(68669);
    }

    private static boolean isOverseasUser() {
        AppMethodBeat.i(163863);
        if (!LocaleUtil.getApplicationLanguage().equals(LocaleUtil.CHINA)) {
            AppMethodBeat.o(163863);
            return true;
        }
        boolean isOverseasUser = Util.isOverseasUser(MMApplicationContext.getContext());
        AppMethodBeat.o(163863);
        return isOverseasUser;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(68670);
        is(true);
        fNn();
        Log.i("MicroMsg.WalletBalanceManagerUI", "do query balance menu");
        if (this.Hwf != null) {
            this.Hwf.cancel();
        }
        this.Hwf = new com.tencent.mm.plugin.wallet.balance.model.a();
        this.Hwf.aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<biu>>() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.AnonymousClass10 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<biu> aVar) {
                AppMethodBeat.i(68656);
                c.a<biu> aVar2 = aVar;
                Log.i("MicroMsg.WalletBalanceManagerUI", "errCode: %s, errType: %s", Integer.valueOf(aVar2.errCode), Integer.valueOf(aVar2.errType));
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    WalletBalanceManagerUI.this.Hwd = ((biu) aVar2.iLC).LSK;
                    WalletBalanceManagerUI.this.fNp();
                }
                WalletBalanceManagerUI.this.Hwf = null;
                AppMethodBeat.o(68656);
                return null;
            }
        });
        super.onResume();
        com.tencent.mm.plugin.walletlock.a.b bVar = (com.tencent.mm.plugin.walletlock.a.b) g.af(com.tencent.mm.plugin.walletlock.a.b.class);
        bVar.a(this, bVar.fUE(), null);
        AppMethodBeat.o(68670);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(68671);
        super.onPause();
        this.Hwb.reset();
        AppMethodBeat.o(68671);
    }

    private void xL(boolean z) {
        AppMethodBeat.i(68672);
        this.Hwb.cH(f.formatMoney2f(f.b(String.valueOf(((Long) ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.USERINFO_NEW_BALANCE_LONG_SYNC, (Object) 0L)).longValue()), "100", 2, RoundingMode.HALF_UP).doubleValue()), !z);
        AppMethodBeat.o(68672);
    }

    /* access modifiers changed from: protected */
    public final void is(boolean z) {
        AppMethodBeat.i(68673);
        xL(z);
        s.fOg();
        this.Hwc = s.fOh().Hwc;
        if (this.Hwc != null) {
            if (fNq()) {
                this.HvV.setVisibility(0);
                if (((Long) ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.USERINFO_NEW_BALANCE_LONG_SYNC, (Object) 0L)).longValue() <= 0) {
                    this.HvV.setEnabled(false);
                }
            } else {
                this.HvV.setVisibility(8);
            }
        }
        View findViewById = findViewById(R.id.exa);
        g.aAi();
        if (((Integer) g.aAh().azQ().get(ar.a.USERINFO_LQT_LINK_RED_DOT_INT, (Object) -1)).intValue() == 1) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        if (new al().fRg()) {
            g.aAi();
            this.HvW.setVisibility(0);
            this.HvX.setTextColor(getResources().getColor(R.color.ads));
            this.HvX.setText((String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_RELEAY_NAME_TIP_CONTENT_STRING_SYNC, getString(R.string.fuo)));
            this.HvW.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.AnonymousClass15 */

                public final void onClick(View view) {
                    AppMethodBeat.i(68661);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    g.aAi();
                    g.aAh().azQ().set(ar.a.USERINFO_LQT_LINK_RED_DOT_INT, (Object) -1);
                    Bundle bundle = new Bundle();
                    bundle.putInt("real_name_verify_mode", 0);
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    bundle.putString("realname_verify_process_jump_activity", "com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI");
                    bundle.putInt("entry_scene", 1009);
                    com.tencent.mm.wallet_core.a.a(WalletBalanceManagerUI.this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(68661);
                }
            });
            AppMethodBeat.o(68673);
            return;
        }
        s.fOg();
        boolean z2 = s.fOh().fRT() == 1;
        s.fOg();
        String fRU = s.fOh().fRU();
        s.fOg();
        String fRV = s.fOh().fRV();
        Log.i("MicroMsg.WalletBalanceManagerUI", "isShowLqtCell:%s lqtCellTitle:%s lqtCellWording:%s", Boolean.valueOf(z2), fRU, fRV);
        if (!z2 || (Util.isNullOrNil(fRU) && Util.isNullOrNil(fRV))) {
            s.fOg();
            if (s.fOh().fRz()) {
                s.fOg();
                if (!Util.isNullOrNil(s.fOh().fRv())) {
                    this.HvW.setVisibility(0);
                    this.HvW.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.AnonymousClass16 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(68662);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            g.aAi();
                            g.aAh().azQ().set(ar.a.USERINFO_LQT_LINK_RED_DOT_INT, (Object) -1);
                            Intent intent = new Intent(WalletBalanceManagerUI.this, WalletLqtDetailUI.class);
                            intent.putExtra("key_account_type", 1);
                            WalletBalanceManagerUI walletBalanceManagerUI = WalletBalanceManagerUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(walletBalanceManagerUI, bl.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            walletBalanceManagerUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(walletBalanceManagerUI, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(68662);
                        }
                    });
                    TextView textView = this.HvX;
                    s.fOg();
                    textView.setText(s.fOh().fRv());
                    AppMethodBeat.o(68673);
                    return;
                }
            }
            s.fOg();
            final an fOh = s.fOh();
            if (fOh == null || !fOh.fRs().fRb() || TextUtils.isEmpty(fOh.fRv()) || TextUtils.isEmpty(fOh.fRw())) {
                this.HvW.setVisibility(8);
                AppMethodBeat.o(68673);
                return;
            }
            this.HvW.setVisibility(0);
            this.HvX.setText(fOh.fRv());
            this.HvW.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(68646);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    g.aAi();
                    g.aAh().azQ().set(ar.a.USERINFO_LQT_LINK_RED_DOT_INT, (Object) -1);
                    f.o(WalletBalanceManagerUI.this, fOh.fRw(), true);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(68646);
                }
            });
            AppMethodBeat.o(68673);
            return;
        }
        this.HvW.setVisibility(8);
        AppMethodBeat.o(68673);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fNp() {
        /*
        // Method dump skipped, instructions count: 472
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.fNp():void");
    }

    private static boolean fNq() {
        AppMethodBeat.i(68675);
        s.fOg();
        boolean fNq = s.fOh().fRs().fNq();
        AppMethodBeat.o(68675);
        return fNq;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(68676);
        if (i2 == 0 && i3 == 0 && !(qVar instanceof com.tencent.mm.plugin.wallet.bind.a.b) && (qVar instanceof ad)) {
            this.Hwe = ((ad) qVar).HQo;
            if (this.Hwe == null || this.Hwg.isShown()) {
                this.HvY.setVisibility(8);
            } else if (!Util.isNullOrNil(this.Hwe.dQx)) {
                this.HvZ.setText(this.Hwe.dQx);
                if (!Util.isNullOrNil(this.Hwe.ixw)) {
                    this.HvZ.setTextColor(Color.parseColor(this.Hwe.ixw));
                    this.Hwa.getDrawable().setColorFilter(Color.parseColor(this.Hwe.ixw), PorterDuff.Mode.SRC_ATOP);
                }
                this.HvY.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(163858);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.WalletBalanceManagerUI", "click action entry");
                        if (WalletBalanceManagerUI.this.Hwe.type == 1) {
                            if (Util.isNullOrNil(WalletBalanceManagerUI.this.Hwe.HWM)) {
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(163858);
                                return;
                            } else if (WalletBalanceManagerUI.this.Hwe.HWM.startsWith("weixin://wcpay/lqt/detail")) {
                                ag.parseUrl(WalletBalanceManagerUI.this.Hwe.HWM);
                                Intent intent = new Intent();
                                intent.putExtra("key_account_type", 1);
                                com.tencent.mm.br.c.b(WalletBalanceManagerUI.this.getContext(), "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent);
                            } else if (WalletBalanceManagerUI.this.Hwe.HWM.startsWith("weixin://wcpay/lqt/save")) {
                                ag.parseUrl(WalletBalanceManagerUI.this.Hwe.HWM);
                                final String aUI = ag.aUI(WalletBalanceManagerUI.this.Hwe.HWM);
                                final Dialog c2 = com.tencent.mm.wallet_core.ui.h.c(WalletBalanceManagerUI.this.getContext(), false, null);
                                new com.tencent.mm.plugin.wallet.balance.model.lqt.o().aYI().b(new com.tencent.mm.vending.c.a<Void, c.a<dhn>>() {
                                    /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.AnonymousClass4.AnonymousClass1 */

                                    /* Return type fixed from 'java.lang.Object' to match base method */
                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                    @Override // com.tencent.mm.vending.c.a
                                    public final /* synthetic */ Void call(c.a<dhn> aVar) {
                                        boolean z;
                                        boolean z2 = true;
                                        AppMethodBeat.i(163857);
                                        c.a<dhn> aVar2 = aVar;
                                        Log.i("MicroMsg.WalletBalanceManagerUI", "on qryusrfunddetail finish, errType: %s, errCode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                                        if (c2 != null) {
                                            c2.dismiss();
                                        }
                                        if (WalletBalanceManagerUI.this.isFinishing() || WalletBalanceManagerUI.this.isDestroyed()) {
                                            Log.w("MicroMsg.WalletBalanceManagerUI", "this activity has finished");
                                        } else if (aVar2.errType == 0 && aVar2.errCode == 0) {
                                            dhn dhn = (dhn) aVar2.iLC;
                                            Log.i("MicroMsg.WalletBalanceManagerUI", "on qryusrfunddetail finsih, retcode: %s, retmsg: %s", Integer.valueOf(dhn.pTZ), dhn.pUa);
                                            if (dhn.pTZ == 0) {
                                                ag.aUH(dhn.HuS);
                                                ArrayList<String> arrayList = new ArrayList<>();
                                                if (dhn.MLV != null && dhn.MLV.size() > 0) {
                                                    Iterator<ahq> it = dhn.MLV.iterator();
                                                    while (it.hasNext()) {
                                                        ahq next = it.next();
                                                        if (!Util.isNullOrNil(next.title) && !Util.isNullOrNil(next.yUB)) {
                                                            arrayList.add(String.format("%s||%s", next.title, next.yUB));
                                                        }
                                                    }
                                                }
                                                com.tencent.mm.plugin.wallet.balance.model.lqt.w wVar = (com.tencent.mm.plugin.wallet.balance.model.lqt.w) new com.tencent.mm.vending.app.c().a(WalletBalanceManagerUI.this.getContext(), com.tencent.mm.plugin.wallet.balance.model.lqt.w.class);
                                                if (wVar == null || WalletBalanceManagerUI.this.isFinishing() || WalletBalanceManagerUI.this.isDestroyed()) {
                                                    Void r0 = QZL;
                                                    AppMethodBeat.o(163857);
                                                    return r0;
                                                }
                                                wVar.HtX.jP(dhn.yba, 3);
                                                Intent intent = new Intent(WalletBalanceManagerUI.this.getContext(), WalletLqtSaveFetchUI.class);
                                                intent.putExtra("lqt_save_fund_code", dhn != null ? dhn.Mnl : null);
                                                intent.putExtra("lqt_save_fetch_mode", 1);
                                                if (dhn.egj == 1) {
                                                    z = true;
                                                } else {
                                                    z = false;
                                                }
                                                intent.putExtra("lqt_is_show_protocol", z);
                                                if (dhn.MLU != 1) {
                                                    z2 = false;
                                                }
                                                intent.putExtra("lqt_is_agree_protocol", z2);
                                                intent.putStringArrayListExtra("lqt_protocol_list", arrayList);
                                                intent.putExtra("lqt_profile_wording", dhn.MLJ);
                                                intent.putExtra("lqt_account_type", dhn.yba);
                                                intent.putExtra("lqt_fund_spid", dhn.Mnk);
                                                intent.putExtra("operate_id", aUI);
                                                WalletBalanceManagerUI walletBalanceManagerUI = WalletBalanceManagerUI.this;
                                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                                com.tencent.mm.hellhoundlib.a.a.a(walletBalanceManagerUI, bl.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12$1", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                                walletBalanceManagerUI.startActivity((Intent) bl.pG(0));
                                                com.tencent.mm.hellhoundlib.a.a.a(walletBalanceManagerUI, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12$1", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            }
                                        }
                                        Void r02 = QZL;
                                        AppMethodBeat.o(163857);
                                        return r02;
                                    }
                                });
                            }
                        } else if (WalletBalanceManagerUI.this.Hwe.type == 2) {
                            f.o(WalletBalanceManagerUI.this.getContext(), WalletBalanceManagerUI.this.Hwe.qHg, true);
                        } else if (WalletBalanceManagerUI.this.Hwe.type == 3) {
                            f.u(WalletBalanceManagerUI.this.Hwe.HWN, WalletBalanceManagerUI.this.Hwe.HWO, 0, 1061);
                        } else {
                            Log.w("MicroMsg.WalletBalanceManagerUI", "unknown type: %s", Integer.valueOf(WalletBalanceManagerUI.this.Hwe.type));
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(163858);
                    }
                });
                this.HvY.setVisibility(0);
            } else {
                this.HvY.setVisibility(8);
            }
            is(false);
            fNp();
        }
        AppMethodBeat.o(68676);
        return false;
    }

    @Override // com.tencent.mm.plugin.wallet_core.model.l
    public final void j(int i2, Object[] objArr) {
        AppMethodBeat.i(68677);
        if (i2 != 12 && i2 == 43 && objArr != null && objArr.length > 0) {
            a((w) objArr[0]);
        }
        AppMethodBeat.o(68677);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(68678);
        Log.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + intent.getIntExtra("from_bind_ui", 0));
        if (intent.getIntExtra("from_bind_ui", 0) == com.tencent.mm.plugin.wallet.balance.a.HsP) {
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, (Bundle) null, (d.a) null);
            f.aqm(15);
        }
        AppMethodBeat.o(68678);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(68679);
        if (mStorageEx == ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg() && i2 == 4) {
            Log.i("MicroMsg.WalletBalanceManagerUI", "on cache update: %s", obj);
            if (obj.equals("USERINFO_NEW_BALANCE_LONG")) {
                xL(false);
            }
        }
        AppMethodBeat.o(68679);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public String Hwr;
        public String Hws;
        public String pTL;
        public int uSc;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public int Hwt;
        public int color;
        public String dQx;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    static /* synthetic */ void d(WalletBalanceManagerUI walletBalanceManagerUI) {
        AppMethodBeat.i(68681);
        com.tencent.mm.ui.base.h.a((Context) walletBalanceManagerUI, false, walletBalanceManagerUI.getString(R.string.i6m), "", walletBalanceManagerUI.getString(R.string.i6l), walletBalanceManagerUI.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(163859);
                dialogInterface.dismiss();
                WalletBalanceManagerUI.f(WalletBalanceManagerUI.this);
                AppMethodBeat.o(163859);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(68652);
                dialogInterface.dismiss();
                AppMethodBeat.o(68652);
            }
        });
        AppMethodBeat.o(68681);
    }

    static /* synthetic */ void f(WalletBalanceManagerUI walletBalanceManagerUI) {
        boolean z = false;
        AppMethodBeat.i(213908);
        Bundle bundle = new Bundle();
        walletBalanceManagerUI.getInput().get("key_pay_info");
        PayInfo payInfo = new PayInfo();
        payInfo.dVv = 21;
        bundle.putParcelable("key_pay_info", payInfo);
        bundle.putInt("key_scene", 21);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.HsP);
        com.tencent.mm.wallet_core.b.hgC();
        if (com.tencent.mm.wallet_core.b.b(b.a.clicfg_open_kinda_bind_card, true)) {
            EventCenter.instance.add(walletBalanceManagerUI.AJa);
            Log.d("MicroMsg.WalletBalanceManagerUI", "startKindaBindCard:true");
            ab.mg(6, bundle.getInt("key_bind_scene"));
            z.aqh(bundle.getInt("key_bind_scene"));
            ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(walletBalanceManagerUI, bundle);
            z = true;
        } else {
            Log.d("MicroMsg.WalletBalanceManagerUI", "startKindaBindCard:false");
        }
        if (!z) {
            com.tencent.mm.wallet_core.a.a(walletBalanceManagerUI, com.tencent.mm.plugin.wallet.balance.a.class, bundle, (d.a) null);
        }
        AppMethodBeat.o(213908);
    }
}
