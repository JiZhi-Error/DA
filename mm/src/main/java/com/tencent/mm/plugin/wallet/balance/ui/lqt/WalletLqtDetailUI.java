package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.design.widget.BottomSheetBehavior;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.zk;
import com.tencent.mm.g.a.zn;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ah;
import com.tencent.mm.plugin.wallet.balance.model.lqt.v;
import com.tencent.mm.plugin.wallet.balance.model.lqt.w;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.abc;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.aog;
import com.tencent.mm.protocal.protobuf.cgt;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletLqtDetailUI extends WalletLqtBasePresenterUI {
    private static final int qfn = a.fromDPToPix(MMApplicationContext.getContext(), 16);
    private LinearLayout HxA;
    private LinearLayout HxB;
    private TextView HxC;
    private TextView HxD;
    private View HxE;
    private TextView HxF;
    private RelativeLayout HxG;
    private View HxH;
    private View HxI;
    private CdnImageView HxJ;
    private TextView HxK;
    private TextView HxL;
    private LinearLayout HxM;
    private TextView HxN;
    private TextView HxO;
    private TextView HxP;
    private LinearLayout HxQ;
    private TextView HxR;
    private WcPayMoneyLoadingView HxS;
    private boolean HxT = true;
    private boolean HxU = false;
    private boolean HxV = false;
    private boolean HxW = false;
    private boolean HxX = false;
    private LinearLayout HxY;
    private LinearLayout HxZ;
    private v Hxm = ((v) au(v.class));
    private w Hxn = ((w) aq(w.class));
    private dhn Hxo;
    private ViewGroup Hxp;
    private TextView Hxq;
    private ViewGroup Hxr;
    private TextView Hxs;
    private TextView Hxt;
    private ViewGroup Hxu;
    private TextView Hxv;
    private WalletTextView Hxw;
    private Button Hxx;
    private Button Hxy;
    private LinearLayout Hxz;
    private CdnImageView Hya;
    private TextView Hyb;
    private ImageView Hyc;
    private WeImageView Hyd;
    private boolean Hye = false;
    private a Hyf;
    private IListener Hyg = new IListener<zn>() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass13 */

        {
            AppMethodBeat.i(213935);
            this.__eventId = zn.class.getName().hashCode();
            AppMethodBeat.o(213935);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zn znVar) {
            AppMethodBeat.i(213936);
            zn znVar2 = znVar;
            if (znVar2.efE.mode == 1) {
                WalletLqtDetailUI.this.Hxn.HtX.jP(WalletLqtDetailUI.this.Hxo.yba, 1);
            } else if (znVar2.efE.mode == 2) {
                WalletLqtDetailUI.this.Hxn.HtW.aen(WalletLqtDetailUI.this.Hxo.yba);
            }
            AppMethodBeat.o(213936);
            return false;
        }
    };
    private IListener Hyh = new IListener<zk>() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass14 */

        {
            AppMethodBeat.i(213937);
            this.__eventId = zk.class.getName().hashCode();
            AppMethodBeat.o(213937);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zk zkVar) {
            AppMethodBeat.i(213938);
            WalletLqtDetailUI.this.Hyf.a(zkVar.efA.efB, null);
            AppMethodBeat.o(213938);
            return false;
        }
    };
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private Dialog jUV;
    private ProgressBar zmi;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletLqtDetailUI() {
        AppMethodBeat.i(68814);
        AppMethodBeat.o(68814);
    }

    static /* synthetic */ void c(WalletLqtDetailUI walletLqtDetailUI) {
        AppMethodBeat.i(213961);
        walletLqtDetailUI.xM(false);
        AppMethodBeat.o(213961);
    }

    static /* synthetic */ ArrayList f(WalletLqtDetailUI walletLqtDetailUI) {
        AppMethodBeat.i(213963);
        ArrayList<String> fND = walletLqtDetailUI.fND();
        AppMethodBeat.o(213963);
        return fND;
    }

    static {
        AppMethodBeat.i(68832);
        AppMethodBeat.o(68832);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68815);
        fixStatusbar(true);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.ae_));
        setActionbarElementColor(getResources().getColor(R.color.am));
        hideActionbarLine();
        setMMTitle("");
        this.Hyf = new a(this);
        Log.i("MicroMsg.WalletLqtDetailUI", "inputAccountType: %s", Integer.valueOf(getIntent().getIntExtra("key_account_type", 1)));
        if (getIntent().getIntExtra("key_auto_jump_transfer", 0) == 1) {
            Log.i("MicroMsg.WalletLqtDetailUI", "auto jump to balance transfer");
            Intent intent = new Intent(getContext(), WalletLqtBalanceAutoTransferUI.class);
            intent.putExtra("show_open_toast", getIntent().getIntExtra("show_open_toast", 0));
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        this.Hxp = (ViewGroup) findViewById(R.id.bo4);
        this.Hxq = (TextView) findViewById(R.id.ew9);
        ao.a(this.Hxq.getPaint(), 0.8f);
        this.HxG = (RelativeLayout) findViewById(R.id.eve);
        this.Hxr = (ViewGroup) findViewById(R.id.bo1);
        this.Hxs = (TextView) findViewById(R.id.evc);
        this.Hxt = (TextView) findViewById(R.id.evd);
        this.Hxu = (ViewGroup) findViewById(R.id.bo8);
        this.Hxv = (TextView) findViewById(R.id.evw);
        this.Hxw = (WalletTextView) findViewById(R.id.evx);
        this.Hxx = (Button) findViewById(R.id.ew1);
        ao.a(this.Hxx.getPaint(), 0.8f);
        this.Hxy = (Button) findViewById(R.id.evr);
        ao.a(this.Hxy.getPaint(), 0.8f);
        this.Hxz = (LinearLayout) findViewById(R.id.evl);
        this.HxA = (LinearLayout) findViewById(R.id.ewx);
        this.HxB = (LinearLayout) findViewById(R.id.evp);
        this.HxC = (TextView) findViewById(R.id.evq);
        this.HxE = findViewById(R.id.evh);
        this.HxF = (TextView) findViewById(R.id.evi);
        this.HxI = findViewById(R.id.ew8);
        this.HxJ = (CdnImageView) findViewById(R.id.inu);
        this.HxK = (TextView) findViewById(R.id.inv);
        this.HxL = (TextView) findViewById(R.id.f18int);
        this.HxH = findViewById(R.id.ew7);
        this.HxD = (TextView) findViewById(R.id.evn);
        this.HxM = (LinearLayout) findViewById(R.id.ew_);
        this.HxN = (TextView) findViewById(R.id.ewa);
        this.HxO = (TextView) findViewById(R.id.evu);
        this.HxP = (TextView) findViewById(R.id.ewb);
        this.HxQ = (LinearLayout) findViewById(R.id.evs);
        this.HxR = (TextView) findViewById(R.id.evt);
        this.HxS = (WcPayMoneyLoadingView) findViewById(R.id.evg);
        this.zmi = (ProgressBar) findViewById(R.id.jg5);
        this.HxZ = (LinearLayout) findViewById(R.id.ew3);
        this.Hya = (CdnImageView) findViewById(R.id.ew4);
        this.Hyb = (TextView) findViewById(R.id.ew6);
        this.Hyc = (ImageView) findViewById(R.id.ew5);
        this.Hyd = (WeImageView) findViewById(R.id.ew2);
        this.HxY = (LinearLayout) findViewById(R.id.evy);
        this.HxS.setLoadingPb(this.zmi);
        getLifecycle().addObserver(this.HxS);
        this.HxS.setPrefixSymbol(getString(R.string.ir3));
        this.HxB.setVisibility(4);
        this.Hyg.alive();
        AppMethodBeat.o(68815);
    }

    private ArrayList<String> fND() {
        AppMethodBeat.i(68816);
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.Hxo.MLV != null && this.Hxo.MLV.size() > 0) {
            Iterator<ahq> it = this.Hxo.MLV.iterator();
            while (it.hasNext()) {
                ahq next = it.next();
                if (!Util.isNullOrNil(next.title) && !Util.isNullOrNil(next.yUB)) {
                    arrayList.add(String.format("%s||%s", next.title, next.yUB));
                }
            }
        }
        AppMethodBeat.o(68816);
        return arrayList;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(68817);
        super.onResume();
        this.Hyh.alive();
        if (this.HxT) {
            try {
                String str = (String) ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.USERINFO_LQT_DETAIL_STRING_SYNC, "");
                if (!Util.isNullOrNil(str)) {
                    this.Hxo = (dhn) new dhn().parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1));
                }
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.WalletLqtDetailUI", e2, "", new Object[0]);
            }
            xM(true);
            bn(0, false);
        }
        this.HxT = true;
        g.aAi();
        if (((Integer) g.aAh().azQ().get(ar.a.USERINFO_PAY_LQT_SECURITY_REDDOT_TIME_INT_SYNC, (Object) 0)).intValue() == -1 && this.Hyc.getVisibility() == 0) {
            Log.i("MicroMsg.WalletLqtDetailUI", "remove lqt security reddot");
            this.Hyc.setVisibility(8);
            h.INSTANCE.a(17084, 23);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Hyd.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.leftMargin = a.fromDPToPix((Context) getContext(), 4);
                this.Hyd.setLayoutParams(layoutParams);
            }
        }
        AppMethodBeat.o(68817);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(68818);
        super.onPause();
        this.Hyh.dead();
        this.HxS.reset();
        AppMethodBeat.o(68818);
    }

    public final void bn(final int i2, boolean z) {
        AppMethodBeat.i(213954);
        Log.i("MicroMsg.WalletLqtDetailUI", "fetch detail: %s", Integer.valueOf(i2));
        if (this.Hxn == null) {
            AppMethodBeat.o(213954);
            return;
        }
        if (z) {
            if (this.jUV == null) {
                this.jUV = com.tencent.mm.wallet_core.ui.h.c(this, false, null);
            } else {
                this.jUV.show();
            }
        }
        this.Hxn.HtU.bmq().f(new com.tencent.mm.vending.c.a<Void, dhn>() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass12 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(dhn dhn) {
                AppMethodBeat.i(68799);
                Void a2 = a(dhn);
                AppMethodBeat.o(68799);
                return a2;
            }

            private Void a(dhn dhn) {
                AppMethodBeat.i(68798);
                if (dhn != null) {
                    Log.i("MicroMsg.WalletLqtDetailUI", "fetch detail success, account_type: %s, is_hide_close_account_btn: %s", Integer.valueOf(dhn.yba), Boolean.valueOf(dhn.MMe));
                    WalletLqtDetailUI.this.Hxo = dhn;
                    WalletLqtDetailUI.b(WalletLqtDetailUI.this);
                    WalletLqtDetailUI.c(WalletLqtDetailUI.this);
                    if (WalletLqtDetailUI.this.Hxo != null) {
                        try {
                            ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.USERINFO_LQT_DETAIL_STRING_SYNC, new String(WalletLqtDetailUI.this.Hxo.toByteArray(), org.apache.commons.a.a.ISO_8859_1));
                        } catch (IOException e2) {
                            Log.printErrStackTrace("MicroMsg.WalletLqtDetailUI", e2, "", new Object[0]);
                        }
                    }
                } else {
                    Log.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed");
                }
                if (WalletLqtDetailUI.this.jUV != null) {
                    WalletLqtDetailUI.this.jUV.dismiss();
                }
                Void r0 = QZL;
                AppMethodBeat.o(68798);
                return r0;
            }
        }).a(new d.a() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass1 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                String string;
                AppMethodBeat.i(68787);
                if (WalletLqtDetailUI.this.jUV != null) {
                    WalletLqtDetailUI.this.jUV.dismiss();
                }
                Log.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed: %s", obj);
                int i2 = i2 - 1;
                if (i2 > 0) {
                    WalletLqtDetailUI.this.bn(i2, false);
                    AppMethodBeat.o(68787);
                    return;
                }
                if (obj != null) {
                    if (obj instanceof String) {
                        string = obj.toString();
                    } else {
                        string = WalletLqtDetailUI.this.getString(R.string.ih4);
                    }
                    Toast.makeText(WalletLqtDetailUI.this, string, 1).show();
                }
                AppMethodBeat.o(68787);
            }
        });
        AppMethodBeat.o(213954);
    }

    private void xM(boolean z) {
        boolean z2;
        boolean z3;
        View findViewById;
        AppMethodBeat.i(68820);
        if (this.Hxo != null) {
            fNE();
            this.Hxp.setVisibility(0);
            this.HxS.cH(f.formatMoney2f(f.a(String.valueOf(((Long) ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.USERINFO_NEW_LQT_LONG_SYNC, (Object) 0L)).longValue()), "100", 2, RoundingMode.HALF_UP)), !z);
            ImageView imageView = (ImageView) findViewById(R.id.evb);
            if (imageView != null) {
                if (!Util.isNullOrNil(this.Hxo.MMf)) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
            }
            ImageView imageView2 = (ImageView) findViewById(R.id.evv);
            if (imageView2 != null) {
                if (!Util.isNullOrNil(this.Hxo.MMf)) {
                    imageView2.setVisibility(0);
                } else {
                    imageView2.setVisibility(8);
                }
            }
            AnonymousClass23 r0 = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass23 */

                public final void onClick(View view) {
                    AppMethodBeat.i(68807);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.WalletLqtDetailUI", "click balance title");
                    f.o(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.this.Hxo.MMt, false);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(68807);
                }
            };
            this.HxG.setOnClickListener(r0);
            this.HxS.setOnClickListener(r0);
            this.Hxr.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass27 */

                public final void onClick(View view) {
                    AppMethodBeat.i(68808);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!Util.isNullOrNil(WalletLqtDetailUI.this.Hxo.MMf)) {
                        f.o(WalletLqtDetailUI.this, WalletLqtDetailUI.this.Hxo.MMf, false);
                        h.INSTANCE.a(17084, 1);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(68808);
                }
            });
            this.Hxs.setText(this.Hxo.MLP);
            this.Hxt.setText(this.Hxo.MLQ);
            this.Hxv.setText(this.Hxo.MLR);
            this.Hxw.setText(f.D(f.a(new StringBuilder().append(this.Hxo.MLS).toString(), "100", 2, RoundingMode.HALF_UP)));
            this.Hxu.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass28 */

                public final void onClick(View view) {
                    AppMethodBeat.i(68809);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!Util.isNullOrNil(WalletLqtDetailUI.this.Hxo.MMg)) {
                        f.o(WalletLqtDetailUI.this, WalletLqtDetailUI.this.Hxo.MMg, false);
                        h.INSTANCE.a(17084, 2);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(68809);
                }
            });
            if (!Util.isNullOrNil(this.Hxo.MMi)) {
                this.HxO.setText(this.Hxo.MMi);
                this.HxO.setVisibility(0);
            } else {
                this.HxO.setVisibility(4);
            }
            if (!Util.isNullOrNil(this.Hxo.MMo)) {
                this.HxP.setText(this.Hxo.MMo);
                this.HxP.setVisibility(0);
            } else {
                this.HxP.setVisibility(4);
            }
            this.Hxz.removeAllViews();
            this.HxA.removeAllViews();
            if (this.Hxo.MMv != null && this.Hxo.MMv.Mne == 1) {
                fNF();
            } else if (!(this.Hxo.MMv == null || this.Hxo.MMv.Mne != 2 || this.Hxo.MMv.Mng == null)) {
                chw chw = this.Hxo.MMv.Mng;
                if (chw.Mnp == null || chw.Mnp.isEmpty()) {
                    fNG();
                } else {
                    fNH();
                }
            }
            if (this.Hxo.MMh != null && !this.Hxo.MMh.isEmpty()) {
                Iterator<ctg> it = this.Hxo.MMh.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    final ctg next = it.next();
                    final ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.b2u, (ViewGroup) this.Hxz, false);
                    TextView textView = (TextView) viewGroup.findViewById(R.id.evm);
                    TextView textView2 = (TextView) viewGroup.findViewById(R.id.evk);
                    CdnImageView cdnImageView = (CdnImageView) viewGroup.findViewById(R.id.e_w);
                    View findViewById2 = viewGroup.findViewById(R.id.e_y);
                    if (i2 == this.Hxo.MMh.size() - 1) {
                        findViewById2.setVisibility(8);
                        viewGroup.setBackgroundResource(R.drawable.jj);
                    }
                    a(next);
                    textView.setText(next.title);
                    textView2.setText(next.desc);
                    if (!Util.isNullOrNil(next.icon)) {
                        cdnImageView.setUseSdcardCache(true);
                        cdnImageView.setUrl(next.icon);
                        cdnImageView.setVisibility(0);
                    } else {
                        cdnImageView.setVisibility(8);
                    }
                    if (next.Myg == 1) {
                        if ("wxpay://lqt/planindex".equals(next.yUB)) {
                            viewGroup.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass29 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(68810);
                                    b bVar = new b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    Log.i("MicroMsg.WalletLqtDetailUI", "go to lqt plan home");
                                    Intent intent = new Intent(WalletLqtDetailUI.this.getContext(), WalletLqtPlanBeforeHomeUI.class);
                                    WalletLqtDetailUI walletLqtDetailUI = WalletLqtDetailUI.this;
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(walletLqtDetailUI, bl.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    walletLqtDetailUI.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(walletLqtDetailUI, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    h.INSTANCE.a(16807, 2, 1, "", "", Integer.valueOf(next.Myf));
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(68810);
                                }
                            });
                        } else if ("wxpay://lqt/autochargesetting".equals(next.yUB)) {
                            viewGroup.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass30 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(68811);
                                    b bVar = new b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    Log.i("MicroMsg.WalletLqtDetailUI", "go to lqt auto charge home");
                                    Intent intent = new Intent(WalletLqtDetailUI.this.getContext(), WalletLqtBalanceAutoTransferUI.class);
                                    WalletLqtDetailUI walletLqtDetailUI = WalletLqtDetailUI.this;
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(walletLqtDetailUI, bl.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    walletLqtDetailUI.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(walletLqtDetailUI, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    h.INSTANCE.a(16807, 2, 1, "", "", Integer.valueOf(next.Myf));
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(68811);
                                }
                            });
                        } else if ("wxpay://lqt/fixeddeposit/makeplan".equals(next.yUB)) {
                            viewGroup.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass31 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(68812);
                                    b bVar = new b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    Log.i("MicroMsg.WalletLqtDetailUI", "go to lqt make plan");
                                    ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startLqtFixedDepositMakePlanUseCase(WalletLqtDetailUI.this.getContext(), new Bundle());
                                    g.aAh().azQ().set(ar.a.USERINFO_LQT_FIXED_DEPOSIT_HAS_SHOW_ENTRANCE_TIPS_BOOLEAN_SYNC, Boolean.TRUE);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(68812);
                                }
                            });
                        } else if ("wxpay://lqt/fixeddeposit/planlist".equals(next.yUB)) {
                            viewGroup.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass32 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(68813);
                                    b bVar = new b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    Log.i("MicroMsg.WalletLqtDetailUI", "go to lqt make plan");
                                    ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startLqtFixedDepositPlanListUseCase(WalletLqtDetailUI.this.getContext(), new Bundle());
                                    g.aAh().azQ().set(ar.a.USERINFO_LQT_FIXED_DEPOSIT_HAS_SHOW_ENTRANCE_TIPS_BOOLEAN_SYNC, Boolean.TRUE);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(68813);
                                }
                            });
                        }
                    } else if (next.Myg == 2) {
                        if (!Util.isNullOrNil(next.yUB)) {
                            viewGroup.setTag(next.yUB);
                            viewGroup.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass2 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(68788);
                                    b bVar = new b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    f.o(WalletLqtDetailUI.this, (String) viewGroup.getTag(), false);
                                    h.INSTANCE.a(16807, 2, 2, next.yUB);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(68788);
                                }
                            });
                        }
                    } else if (next.Myg == 3 && !Util.isNullOrNil(next.KZR) && !Util.isNullOrNil(next.yUB)) {
                        viewGroup.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass3 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(68789);
                                b bVar = new b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                f.u(next.KZR, next.yUB, 0, 1061);
                                h.INSTANCE.a(16807, 2, 2, next.yUB, next.KZR);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(68789);
                            }
                        });
                    }
                    this.Hxz.addView(viewGroup, new LinearLayout.LayoutParams(-1, -2, -1.0f));
                    i2++;
                }
            } else if (this.Hxo.MLT != null && this.Hxo.MLT.size() > 0) {
                Iterator<ahq> it2 = this.Hxo.MLT.iterator();
                int i3 = 0;
                while (it2.hasNext()) {
                    ahq next2 = it2.next();
                    final ViewGroup viewGroup2 = (ViewGroup) getLayoutInflater().inflate(R.layout.b2u, (ViewGroup) this.Hxz, false);
                    TextView textView3 = (TextView) viewGroup2.findViewById(R.id.evm);
                    TextView textView4 = (TextView) viewGroup2.findViewById(R.id.evk);
                    View findViewById3 = viewGroup2.findViewById(R.id.e_y);
                    if (i3 == this.Hxo.MLT.size() - 1) {
                        findViewById3.setVisibility(8);
                        viewGroup2.setBackgroundResource(R.drawable.jj);
                    }
                    textView3.setText(next2.title);
                    textView4.setText(next2.desc);
                    if (!Util.isNullOrNil(next2.yUB)) {
                        viewGroup2.setTag(next2.yUB);
                        viewGroup2.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass4 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(68790);
                                b bVar = new b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                f.o(WalletLqtDetailUI.this, (String) viewGroup2.getTag(), false);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(68790);
                            }
                        });
                    }
                    this.Hxz.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2, -1.0f));
                    i3++;
                }
            }
            if (this.Hxz.getChildCount() == 0 && (findViewById = findViewById(R.id.ewc)) != null) {
                findViewById.setVisibility(4);
            }
            if (this.Hxo.MAf <= 0) {
                this.Hxy.setEnabled(false);
            } else {
                this.Hxy.setEnabled(true);
            }
            if (!Util.isNullOrNil(this.Hxo.MMp)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.Hxo.MLW == null || Util.isNullOrNil(this.Hxo.MLW.title)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z2) {
                this.HxR.setText(this.Hxo.MMp);
                ao.a(this.HxR.getPaint(), 0.8f);
                f.aZ(this.HxR, 50);
                this.HxQ.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass5 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(68791);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        WalletLqtDetailUI.e(WalletLqtDetailUI.this);
                        h.INSTANCE.a(17084, 3);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(68791);
                    }
                });
            }
            if (z3) {
                this.HxC.setText(this.Hxo.MLW.title);
                ao.a(this.HxC.getPaint(), 0.8f);
                this.HxB.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass6 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(68792);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        f.o(WalletLqtDetailUI.this, WalletLqtDetailUI.this.Hxo.MLW.yUB, false);
                        h.INSTANCE.a(17084, 4);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(68792);
                    }
                });
            }
            if (z2 && z3) {
                this.HxQ.setVisibility(0);
                this.HxQ.setGravity(5);
                this.HxB.setVisibility(0);
                this.HxB.setGravity(3);
            } else if (z2) {
                this.HxQ.setVisibility(0);
                this.HxQ.setGravity(17);
                this.HxB.setVisibility(8);
            } else if (z3) {
                this.HxQ.setVisibility(8);
                this.HxB.setVisibility(0);
                this.HxB.setGravity(17);
            } else {
                this.HxQ.setVisibility(8);
                this.HxB.setVisibility(8);
            }
            this.HxE.setVisibility(8);
            if (this.Hxo.MLY != null && !Util.isNullOrNil(this.Hxo.MLY.title)) {
                this.HxE.setVisibility(0);
                this.HxF.setText(this.Hxo.MLY.title);
                if (!Util.isNullOrNil(this.Hxo.MLY.yUB)) {
                    this.HxE.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass7 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(68793);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            f.o(WalletLqtDetailUI.this, WalletLqtDetailUI.this.Hxo.MLY.yUB, false);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(68793);
                        }
                    });
                }
            }
            this.HxI.setVisibility(8);
            this.HxH.setVisibility(8);
            if (this.Hxo.MLZ != null && !Util.isNullOrNil(this.Hxo.MLZ.username)) {
                this.HxJ.setUrl(this.Hxo.MLZ.iwv);
                this.HxK.setText(this.Hxo.MLZ.title);
                this.HxL.setText(this.Hxo.MLZ.desc);
                this.HxI.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass8 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(68794);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        wq wqVar = new wq();
                        wqVar.ecI.userName = WalletLqtDetailUI.this.Hxo.MLZ.username;
                        wqVar.ecI.ecK = Util.nullAs(WalletLqtDetailUI.this.Hxo.MLZ.path, "");
                        wqVar.ecI.scene = 1061;
                        wqVar.ecI.ecL = 0;
                        EventCenter.instance.publish(wqVar);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(68794);
                    }
                });
                this.HxH.setVisibility(0);
                this.HxI.setVisibility(0);
            }
            if (!Util.isNullOrNil(this.Hxo.HtI)) {
                this.HxD.setText(this.Hxo.HtI);
            } else if (this.Hxo.yba == 1) {
                this.HxD.setText(R.string.ig7);
            } else if (this.Hxo.yba == 2) {
                this.HxD.setText(R.string.ig8);
            }
            if (this.Hxo.MMl == null || Util.isNullOrNil(this.Hxo.MMl.title)) {
                this.HxM.setVisibility(8);
            } else {
                this.HxM.setVisibility(0);
                this.HxN.setText(this.Hxo.MMl.title);
                ao.a(this.HxN.getPaint(), 0.8f);
                this.HxM.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass9 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(68795);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.WalletLqtDetailUI", "click top biz");
                        if (WalletLqtDetailUI.this.Hxo.MMl.Myg == 2) {
                            if (!Util.isNullOrNil(WalletLqtDetailUI.this.Hxo.MMl.yUB)) {
                                f.o(WalletLqtDetailUI.this, WalletLqtDetailUI.this.Hxo.MMl.yUB, false);
                                h.INSTANCE.a(16807, 1, 2, WalletLqtDetailUI.this.Hxo.MMl.yUB);
                            }
                        } else if (WalletLqtDetailUI.this.Hxo.MMl.Myg == 3 && !Util.isNullOrNil(WalletLqtDetailUI.this.Hxo.MMl.KZR) && !Util.isNullOrNil(WalletLqtDetailUI.this.Hxo.MMl.yUB)) {
                            f.u(WalletLqtDetailUI.this.Hxo.MMl.KZR, WalletLqtDetailUI.this.Hxo.MMl.yUB, 0, 1061);
                            h.INSTANCE.a(16807, 1, 3, WalletLqtDetailUI.this.Hxo.MMl.yUB, WalletLqtDetailUI.this.Hxo.MMl.KZR);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(68795);
                    }
                });
            }
            this.Hxx.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass10 */

                public final void onClick(View view) {
                    boolean z;
                    boolean z2 = true;
                    AppMethodBeat.i(68796);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (ac.jPD) {
                        Intent intent = new Intent(WalletLqtDetailUI.this, WalletLqtSaveFetchUI.class);
                        intent.putExtra("lqt_save_fund_code", WalletLqtDetailUI.this.Hxo != null ? WalletLqtDetailUI.this.Hxo.Mnl : null);
                        intent.putExtra("lqt_save_fetch_mode", 1);
                        if (WalletLqtDetailUI.this.Hxo.egj == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        intent.putExtra("lqt_is_show_protocol", z);
                        if (WalletLqtDetailUI.this.Hxo.MLU != 1) {
                            z2 = false;
                        }
                        intent.putExtra("lqt_is_agree_protocol", z2);
                        intent.putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.f(WalletLqtDetailUI.this));
                        intent.putExtra("lqt_profile_wording", WalletLqtDetailUI.this.Hxo.MLJ);
                        WalletLqtDetailUI walletLqtDetailUI = WalletLqtDetailUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(walletLqtDetailUI, bl.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        walletLqtDetailUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(walletLqtDetailUI, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(68796);
                    } else if (WalletLqtDetailUI.this.Hxo.MMm == null || !WalletLqtDetailUI.this.Hxo.MMm.Mma || WalletLqtDetailUI.this.Hxo.MAl == null) {
                        WalletLqtDetailUI.this.Hxn.HtX.jP(WalletLqtDetailUI.this.Hxo.yba, 1);
                        if (!Util.isNullOrNil(WalletLqtDetailUI.this.Hxo.MMa)) {
                            Log.i("MicroMsg.WalletLqtDetailUI", "click save button, go to block url: %s", WalletLqtDetailUI.this.Hxo.MMa);
                            f.o(WalletLqtDetailUI.this, WalletLqtDetailUI.this.Hxo.MMa, false);
                        } else {
                            WalletLqtDetailUI.a(WalletLqtDetailUI.this, true, WalletLqtDetailUI.this.Hxo.MMm);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(68796);
                    } else {
                        ah.a(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.this.Hxo.MAl);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(68796);
                    }
                }
            });
            this.Hxy.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass11 */

                public final void onClick(View view) {
                    AppMethodBeat.i(213934);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (WalletLqtDetailUI.this.Hxo.MMn == null || !WalletLqtDetailUI.this.Hxo.MMn.Mma || WalletLqtDetailUI.this.Hxo.MAl == null) {
                        WalletLqtDetailUI.this.Hxn.HtW.aen(WalletLqtDetailUI.this.Hxo.yba);
                        WalletLqtDetailUI.a(WalletLqtDetailUI.this, false, WalletLqtDetailUI.this.Hxo.MMn);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213934);
                        return;
                    }
                    ah.a(WalletLqtDetailUI.this.getContext(), WalletLqtDetailUI.this.Hxo.MAl);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213934);
                }
            });
            if (this.Hxo.Mma && this.Hxo.MAl != null) {
                ah.a(this, this.Hxo.MAl);
            }
        }
        eeh();
        AppMethodBeat.o(68820);
    }

    private void aUK(String str) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(68821);
        Log.i("MicroMsg.WalletLqtDetailUI", "go to save ui");
        Intent intent = new Intent(this, WalletLqtSaveFetchUI.class);
        intent.putExtra("lqt_save_fund_code", this.Hxo != null ? this.Hxo.Mnl : null);
        intent.putExtra("lqt_save_fetch_mode", 1);
        if (this.Hxo.egj == 1) {
            z = true;
        } else {
            z = false;
        }
        intent.putExtra("lqt_is_show_protocol", z);
        if (this.Hxo.MLU != 1) {
            z2 = false;
        }
        intent.putExtra("lqt_is_agree_protocol", z2);
        intent.putStringArrayListExtra("lqt_protocol_list", fND());
        intent.putExtra("lqt_profile_wording", this.Hxo.MLJ);
        intent.putExtra("lqt_account_type", this.Hxo.yba);
        intent.putExtra("lqt_fund_spid", this.Hxo.Mnk);
        intent.putExtra("operate_id", str);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoSaveUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoSaveUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(68821);
    }

    private void aUL(String str) {
        AppMethodBeat.i(68822);
        Log.i("MicroMsg.WalletLqtDetailUI", "go to fetch ui");
        Intent intent = new Intent(this, WalletLqtSaveFetchUI.class);
        intent.putExtra("lqt_save_fetch_mode", 2);
        intent.putExtra("lqt_balance", this.Hxo.MAf);
        intent.putExtra("lqt_max_redeem_amount", this.Hxo.MMb);
        intent.putExtra("lqt_redeem_invalid_amount_hint", this.Hxo.MMc);
        intent.putExtra("lqt_account_type", this.Hxo.yba);
        intent.putExtra("operate_id", str);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoFetchUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI", "gotoFetchUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(68822);
    }

    private void eeh() {
        AppMethodBeat.i(68823);
        removeAllOptionMenu();
        if (this.Hxo != null) {
            if (this.Hxo.MMr == null || this.Hxo.MMr.size() != 1 || !this.Hxo.MMe) {
                addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass17 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(213944);
                        e eVar = new e((Context) WalletLqtDetailUI.this, 1, false);
                        eVar.HLX = new o.f() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass17.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.o.f
                            public final void onCreateMMMenu(m mVar) {
                                AppMethodBeat.i(213941);
                                if (WalletLqtDetailUI.this.Hxo.MMr != null && WalletLqtDetailUI.this.Hxo.MMr.size() > 0) {
                                    int i2 = 0;
                                    Iterator<ctg> it = WalletLqtDetailUI.this.Hxo.MMr.iterator();
                                    while (it.hasNext()) {
                                        ctg next = it.next();
                                        if (!Util.isNullOrNil(next.title)) {
                                            mVar.d(i2, next.title);
                                        }
                                        i2++;
                                    }
                                }
                                if (!WalletLqtDetailUI.this.Hxo.MMe) {
                                    mVar.a(-1, WalletLqtDetailUI.this.getContext().getResources().getColor(R.color.Red), WalletLqtDetailUI.this.getString(R.string.ig3));
                                }
                                AppMethodBeat.o(213941);
                            }
                        };
                        eVar.HLY = new o.g() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass17.AnonymousClass2 */

                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                String string;
                                AppMethodBeat.i(213943);
                                if (menuItem.getItemId() != -1 || WalletLqtDetailUI.this.Hxo.MMe) {
                                    if (WalletLqtDetailUI.this.Hxo.MMr != null && WalletLqtDetailUI.this.Hxo.MMr.size() > 0 && menuItem.getItemId() < WalletLqtDetailUI.this.Hxo.MMr.size()) {
                                        ctg ctg = WalletLqtDetailUI.this.Hxo.MMr.get(menuItem.getItemId());
                                        if (ctg.Myg != 1) {
                                            if (ctg.Myg == 2) {
                                                if (!Util.isNullOrNil(ctg.yUB)) {
                                                    f.o(WalletLqtDetailUI.this, ctg.yUB, false);
                                                    AppMethodBeat.o(213943);
                                                    return;
                                                }
                                            } else if (ctg.Myg == 3 && !Util.isNullOrNil(ctg.KZR) && !Util.isNullOrNil(ctg.yUB)) {
                                                f.u(ctg.KZR, ctg.yUB, 0, 1061);
                                            }
                                        }
                                    }
                                    AppMethodBeat.o(213943);
                                    return;
                                }
                                if (!Util.isNullOrNil(WalletLqtDetailUI.this.Hxo.MMj)) {
                                    string = WalletLqtDetailUI.this.Hxo.MMj;
                                } else if (WalletLqtDetailUI.this.Hxo.yba == 0) {
                                    string = WalletLqtDetailUI.this.getString(R.string.ig5);
                                } else {
                                    string = WalletLqtDetailUI.this.getString(R.string.ifn);
                                }
                                com.tencent.mm.ui.base.h.a(WalletLqtDetailUI.this, string, "", WalletLqtDetailUI.this.getString(R.string.b5x), new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass17.AnonymousClass2.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(213942);
                                        WalletLqtDetailUI.this.HxT = false;
                                        WalletLqtDetailUI.this.startActivityForResult(new Intent(WalletLqtDetailUI.this, WalletLqtSimpleCheckPwdUI.class), 123);
                                        AppMethodBeat.o(213942);
                                    }
                                });
                                AppMethodBeat.o(213943);
                            }
                        };
                        eVar.dGm();
                        AppMethodBeat.o(213944);
                        return false;
                    }
                });
            } else {
                Log.i("MicroMsg.WalletLqtDetailUI", "show text menu");
                final ctg ctg = this.Hxo.MMr.get(0);
                addTextOptionMenu(0, ctg.title, new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass16 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(213940);
                        if (ctg.Myg != 1) {
                            if (ctg.Myg == 2) {
                                if (!Util.isNullOrNil(ctg.yUB)) {
                                    f.o(WalletLqtDetailUI.this, ctg.yUB, false);
                                }
                            } else if (ctg.Myg == 3 && !Util.isNullOrNil(ctg.KZR) && !Util.isNullOrNil(ctg.yUB)) {
                                f.u(ctg.KZR, ctg.yUB, 0, 1061);
                            }
                        }
                        AppMethodBeat.o(213940);
                        return false;
                    }
                });
                AppMethodBeat.o(68823);
                return;
            }
        }
        AppMethodBeat.o(68823);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI
    public int getLayoutId() {
        return R.layout.c9k;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(68824);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 123 && i3 == -1) {
            this.HxT = false;
            String stringExtra = intent.getStringExtra("lqt_enc_pwd");
            if (this.jUV == null) {
                this.jUV = com.tencent.mm.wallet_core.ui.h.c(this, false, null);
            } else {
                this.jUV.show();
            }
            com.tencent.mm.vending.g.g.O(stringExtra, Integer.valueOf(this.Hxo.yba)).c(this.Hxn.HtV).f(new com.tencent.mm.vending.c.a<Void, abc>() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass19 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Void call(abc abc) {
                    AppMethodBeat.i(213947);
                    WalletLqtDetailUI.this.handler.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass19.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(213946);
                            if (WalletLqtDetailUI.this.jUV != null) {
                                WalletLqtDetailUI.this.jUV.dismiss();
                            }
                            Toast.makeText(WalletLqtDetailUI.this, WalletLqtDetailUI.this.getString(R.string.ig4), 1).show();
                            WalletLqtDetailUI.this.finish();
                            AppMethodBeat.o(213946);
                        }
                    }, 1000);
                    Void r0 = QZL;
                    AppMethodBeat.o(213947);
                    return r0;
                }
            }).a(new d.a() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass18 */

                @Override // com.tencent.mm.vending.g.d.a
                public final void cn(Object obj) {
                    String string;
                    AppMethodBeat.i(213945);
                    if (WalletLqtDetailUI.this.jUV != null) {
                        WalletLqtDetailUI.this.jUV.dismiss();
                    }
                    Log.i("MicroMsg.WalletLqtDetailUI", "close account failed: %s", obj);
                    if (obj != null) {
                        if (obj instanceof String) {
                            string = obj.toString();
                        } else {
                            string = WalletLqtDetailUI.this.getString(R.string.ih4);
                        }
                        Toast.makeText(WalletLqtDetailUI.this, string, 1).show();
                    }
                    AppMethodBeat.o(213945);
                }
            });
        }
        AppMethodBeat.o(68824);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(68825);
        super.onDestroy();
        this.Hxm = null;
        this.Hxn = null;
        this.Hyg.dead();
        AppMethodBeat.o(68825);
    }

    private void fNE() {
        boolean z;
        AppMethodBeat.i(213955);
        if (this.Hxo.MMw == null) {
            Log.i("MicroMsg.WalletLqtDetailUI", "svr not return data, hide security entry");
            this.HxZ.setVisibility(8);
            AppMethodBeat.o(213955);
            return;
        }
        Log.i("MicroMsg.WalletLqtDetailUI", "show lqt security entry with svr data");
        this.HxZ.setVisibility(0);
        if (!Util.isNullOrNil(this.Hxo.MMw.icon)) {
            this.Hya.setVisibility(0);
            this.Hya.setUrl(this.Hxo.MMw.icon);
        } else {
            this.Hya.setVisibility(8);
        }
        this.Hyb.setText(this.Hxo.MMw.title);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.HxY.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = a.fromDPToPix((Context) getContext(), 16);
            this.HxY.setLayoutParams(layoutParams);
        }
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_PAY_LQT_SECURITY_REDDOT_TIME_INT_SYNC, (Object) 0)).intValue();
        if (intValue == 0) {
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_PAY_LQT_SECURITY_REDDOT_TIME_INT_SYNC, Integer.valueOf(cl.aWB()));
            z = true;
        } else if (intValue <= 0) {
            if (intValue == -1) {
                Log.i("MicroMsg.WalletLqtDetailUI", "has click reddot");
            }
            z = false;
        } else if (((long) cl.aWB()) - ((long) intValue) >= 604800) {
            Log.i("MicroMsg.WalletLqtDetailUI", "reddot has display above 7 day, hide it");
            h.INSTANCE.a(17084, 24);
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.Hyc.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.Hyd.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.leftMargin = a.fromDPToPix((Context) getContext(), 8);
                this.Hyd.setLayoutParams(layoutParams2);
            }
        } else {
            this.Hyc.setVisibility(8);
        }
        if (!this.Hye) {
            this.Hye = true;
            h.INSTANCE.a(17084, 20);
            Log.i("MicroMsg.WalletLqtDetailUI", "report show security entry");
            if (z) {
                h.INSTANCE.a(17084, 22);
            }
        }
        this.HxZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass20 */

            public final void onClick(View view) {
                AppMethodBeat.i(213948);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.WalletLqtDetailUI", "click security entry, url type is : %d", Integer.valueOf(WalletLqtDetailUI.this.Hxo.MMw.Myg));
                h.INSTANCE.a(17084, 21);
                if (WalletLqtDetailUI.this.Hxo.MMw.Myg == 2) {
                    String str = WalletLqtDetailUI.this.Hxo.MMw.yUB;
                    Log.i("MicroMsg.WalletLqtDetailUI", "jump to h5 with url : %s", str);
                    f.o(WalletLqtDetailUI.this, str, false);
                } else if (WalletLqtDetailUI.this.Hxo.MMw.Myg == 3) {
                    String str2 = WalletLqtDetailUI.this.Hxo.MMw.KZR;
                    String str3 = WalletLqtDetailUI.this.Hxo.MMw.yUB;
                    Log.i("MicroMsg.WalletLqtDetailUI", "jump to tinyapp with username : %s, path : %s", str2, str3);
                    f.u(str2, str3, 0, 1061);
                }
                if (WalletLqtDetailUI.this.Hyc.getVisibility() == 0) {
                    g.aAi();
                    g.aAh().azQ().set(ar.a.USERINFO_PAY_LQT_SECURITY_REDDOT_TIME_INT_SYNC, (Object) -1);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213948);
            }
        });
        AppMethodBeat.o(213955);
    }

    private void fNF() {
        AppMethodBeat.i(213956);
        Log.i("MicroMsg.WalletLqtDetailUI", "showLctOperationView");
        if (!this.HxV) {
            h.INSTANCE.a(17084, 10);
            this.HxV = true;
            Log.i("MicroMsg.WalletLqtDetailUI", "ReportShowLctOperationView");
        }
        final ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.b31, (ViewGroup) this.HxA, false);
        ((TextView) viewGroup.findViewById(R.id.ex5)).setText(this.Hxo.MMv.Mnf.title);
        ((TextView) viewGroup.findViewById(R.id.ex4)).setText(this.Hxo.MMv.Mnf.desc);
        if (this.Hxo.MMv.Mnf.Myg != 1) {
            if (this.Hxo.MMv.Mnf.Myg == 2) {
                if (!Util.isNullOrNil(this.Hxo.MMv.Mnf.yUB)) {
                    viewGroup.setTag(this.Hxo.MMv.Mnf.yUB);
                    viewGroup.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass21 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(213949);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            f.o(WalletLqtDetailUI.this, (String) viewGroup.getTag(), false);
                            h.INSTANCE.a(17084, 11);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(213949);
                        }
                    });
                }
            } else if (this.Hxo.MMv.Mnf.Myg == 3 && !Util.isNullOrNil(this.Hxo.MMv.Mnf.KZR) && !Util.isNullOrNil(this.Hxo.MMv.Mnf.yUB)) {
                viewGroup.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass22 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(213950);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        f.u(WalletLqtDetailUI.this.Hxo.MMv.Mnf.KZR, WalletLqtDetailUI.this.Hxo.MMv.Mnf.yUB, 0, 1061);
                        h.INSTANCE.a(17084, 11);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213950);
                    }
                });
            }
        }
        this.HxA.addView(viewGroup);
        AppMethodBeat.o(213956);
    }

    private void fNG() {
        AppMethodBeat.i(213957);
        Log.i("MicroMsg.WalletLqtDetailUI", "showLctOperationView2");
        if (this.Hxo.MMv.Mng.Mno != null) {
            if (!this.HxW) {
                h.INSTANCE.a(21309, 1, 1);
                this.HxW = true;
            }
            final ctg ctg = this.Hxo.MMv.Mng.Mno;
            ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.b32, (ViewGroup) this.HxA, false);
            CdnImageView cdnImageView = (CdnImageView) viewGroup.findViewById(R.id.eww);
            TextView textView = (TextView) viewGroup.findViewById(R.id.ex6);
            if (!Util.isNullOrNil(ctg.icon)) {
                cdnImageView.setUrl(ctg.icon);
                cdnImageView.setVisibility(0);
            } else {
                cdnImageView.setVisibility(8);
            }
            textView.setText(ctg.title);
            viewGroup.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass24 */

                public final void onClick(View view) {
                    AppMethodBeat.i(213951);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WALLET_LQT_LCT_SHOW_FIRST_TIPS_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                    if (ctg.Myg == 2) {
                        if (!Util.isNullOrNil(ctg.yUB)) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", ctg.yUB);
                            intent.putExtra("showShare", true);
                            intent.putExtra(e.p.OzJ, true);
                            if (!booleanValue && WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq != null) {
                                intent.putExtra("key_first_tips", WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq.content);
                                intent.putExtra("key_first_tips_title", WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq.title);
                            }
                            f.aA(WalletLqtDetailUI.this.getContext(), intent);
                            if (!booleanValue) {
                                g.aAh().azQ().set(ar.a.USERINFO_WALLET_LQT_LCT_SHOW_FIRST_TIPS_BOOLEAN_SYNC, Boolean.TRUE);
                            }
                            h.INSTANCE.a(21309, 1, 2);
                        }
                    } else if (ctg.Myg == 3 && !Util.isNullOrNil(ctg.KZR) && !Util.isNullOrNil(ctg.yUB)) {
                        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                        gVar.username = ctg.KZR;
                        gVar.kHw = ctg.yUB;
                        gVar.scene = 1061;
                        if (!booleanValue && WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq != null) {
                            String str = WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq.title;
                            String str2 = WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq.content;
                            String string = WalletLqtDetailUI.this.getString(R.string.w1);
                            WeAppOpenDeclarePromptBundle weAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte) 0);
                            weAppOpenDeclarePromptBundle.kHS = str;
                            weAppOpenDeclarePromptBundle.kHT = str2;
                            weAppOpenDeclarePromptBundle.kHU = string;
                            weAppOpenDeclarePromptBundle.ox = false;
                            gVar.kHJ = weAppOpenDeclarePromptBundle;
                        }
                        ((r) g.af(r.class)).a(WalletLqtDetailUI.this.getContext(), gVar);
                        if (!booleanValue) {
                            g.aAh().azQ().set(ar.a.USERINFO_WALLET_LQT_LCT_SHOW_FIRST_TIPS_BOOLEAN_SYNC, Boolean.TRUE);
                        }
                        h.INSTANCE.a(21309, 1, 2);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213951);
                }
            });
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            int fromDPToPix = a.fromDPToPix(MMApplicationContext.getContext(), 8);
            marginLayoutParams.leftMargin = fromDPToPix;
            marginLayoutParams.rightMargin = fromDPToPix;
            this.HxA.addView(viewGroup, marginLayoutParams);
        }
        AppMethodBeat.o(213957);
    }

    private void fNH() {
        AppMethodBeat.i(213958);
        Log.i("MicroMsg.WalletLqtDetailUI", "showLctOperationView3");
        if (this.Hxo.MMv.Mng.Mno != null) {
            if (!this.HxX) {
                h.INSTANCE.a(21309, 2, 1);
                this.HxX = true;
            }
            final ctg ctg = this.Hxo.MMv.Mng.Mno;
            final chv chv = this.Hxo.MMv.Mng.Mnp.get(0);
            ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.b33, (ViewGroup) this.HxA, false);
            CdnImageView cdnImageView = (CdnImageView) viewGroup.findViewById(R.id.eww);
            TextView textView = (TextView) viewGroup.findViewById(R.id.ex6);
            if (!Util.isNullOrNil(ctg.icon)) {
                cdnImageView.setUrl(ctg.icon);
                cdnImageView.setVisibility(0);
            } else {
                cdnImageView.setVisibility(8);
            }
            textView.setText(ctg.title);
            viewGroup.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass25 */

                public final void onClick(View view) {
                    AppMethodBeat.i(213952);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WALLET_LQT_LCT_SHOW_FIRST_TIPS_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                    if (ctg.Myg == 2) {
                        if (!Util.isNullOrNil(ctg.yUB)) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", ctg.yUB);
                            intent.putExtra("showShare", true);
                            intent.putExtra(e.p.OzJ, true);
                            if (!booleanValue && WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq != null) {
                                intent.putExtra("key_first_tips", WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq.content);
                                intent.putExtra("key_first_tips_title", WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq.title);
                            }
                            f.aA(WalletLqtDetailUI.this.getContext(), intent);
                            if (!booleanValue) {
                                g.aAh().azQ().set(ar.a.USERINFO_WALLET_LQT_LCT_SHOW_FIRST_TIPS_BOOLEAN_SYNC, Boolean.TRUE);
                            }
                            h.INSTANCE.a(21309, 2, 2, chv.Mnk, chv.Mnl, chv.Mnm, chv.Mnn, 1);
                        }
                    } else if (ctg.Myg == 3 && !Util.isNullOrNil(ctg.KZR) && !Util.isNullOrNil(ctg.yUB)) {
                        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                        gVar.username = ctg.KZR;
                        gVar.kHw = ctg.yUB;
                        gVar.scene = 1061;
                        if (!booleanValue && WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq != null) {
                            String str = WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq.title;
                            String str2 = WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq.content;
                            String string = WalletLqtDetailUI.this.getString(R.string.w1);
                            WeAppOpenDeclarePromptBundle weAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte) 0);
                            weAppOpenDeclarePromptBundle.kHS = str;
                            weAppOpenDeclarePromptBundle.kHT = str2;
                            weAppOpenDeclarePromptBundle.kHU = string;
                            weAppOpenDeclarePromptBundle.ox = false;
                            gVar.kHJ = weAppOpenDeclarePromptBundle;
                        }
                        ((r) g.af(r.class)).a(WalletLqtDetailUI.this.getContext(), gVar);
                        if (!booleanValue) {
                            g.aAh().azQ().set(ar.a.USERINFO_WALLET_LQT_LCT_SHOW_FIRST_TIPS_BOOLEAN_SYNC, Boolean.TRUE);
                        }
                        h.INSTANCE.a(21309, 2, 2, chv.Mnk, chv.Mnl, chv.Mnm, chv.Mnn, 1);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213952);
                }
            });
            ((TextView) viewGroup.findViewById(R.id.ex0)).setText(chv.name);
            ((TextView) viewGroup.findViewById(R.id.ewy)).setText(chv.desc);
            ((TextView) viewGroup.findViewById(R.id.ex2)).setText(chv.Mnh);
            ((TextView) viewGroup.findViewById(R.id.ex1)).setText(chv.Mni);
            ((ViewGroup) viewGroup.findViewById(R.id.ewz)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass26 */

                public final void onClick(View view) {
                    AppMethodBeat.i(213953);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WALLET_LQT_LCT_SHOW_FIRST_TIPS_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                    if (chv.Mnj == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213953);
                        return;
                    }
                    if (chv.Mnj.Myg == 2) {
                        if (!Util.isNullOrNil(chv.Mnj.url)) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", chv.Mnj.url);
                            intent.putExtra("showShare", true);
                            intent.putExtra(e.p.OzJ, true);
                            if (!booleanValue && WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq != null) {
                                intent.putExtra("key_first_tips", WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq.content);
                                intent.putExtra("key_first_tips_title", WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq.title);
                            }
                            f.aA(WalletLqtDetailUI.this.getContext(), intent);
                            if (!booleanValue) {
                                g.aAh().azQ().set(ar.a.USERINFO_WALLET_LQT_LCT_SHOW_FIRST_TIPS_BOOLEAN_SYNC, Boolean.TRUE);
                            }
                            h.INSTANCE.a(21309, 2, 2, chv.Mnk, chv.Mnl, chv.Mnm, chv.Mnn, 2);
                        }
                    } else if (chv.Mnj.Myg == 3 && !Util.isNullOrNil(chv.Mnj.KZR) && !Util.isNullOrNil(chv.Mnj.url)) {
                        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                        gVar.username = chv.Mnj.KZR;
                        gVar.kHw = chv.Mnj.url;
                        gVar.scene = 1061;
                        if (!booleanValue && WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq != null) {
                            String str = WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq.title;
                            String str2 = WalletLqtDetailUI.this.Hxo.MMv.Mng.Mnq.content;
                            String string = WalletLqtDetailUI.this.getString(R.string.w1);
                            WeAppOpenDeclarePromptBundle weAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte) 0);
                            weAppOpenDeclarePromptBundle.kHS = str;
                            weAppOpenDeclarePromptBundle.kHT = str2;
                            weAppOpenDeclarePromptBundle.kHU = string;
                            weAppOpenDeclarePromptBundle.ox = false;
                            gVar.kHJ = weAppOpenDeclarePromptBundle;
                        }
                        ((r) g.af(r.class)).a(WalletLqtDetailUI.this.getContext(), gVar);
                        if (!booleanValue) {
                            g.aAh().azQ().set(ar.a.USERINFO_WALLET_LQT_LCT_SHOW_FIRST_TIPS_BOOLEAN_SYNC, Boolean.TRUE);
                        }
                        h.INSTANCE.a(21309, 2, 2, chv.Mnk, chv.Mnl, chv.Mnm, chv.Mnn, 2);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213953);
                }
            });
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            int fromDPToPix = a.fromDPToPix(MMApplicationContext.getContext(), 8);
            marginLayoutParams.leftMargin = fromDPToPix;
            marginLayoutParams.rightMargin = fromDPToPix;
            this.HxA.addView(viewGroup, marginLayoutParams);
        }
        AppMethodBeat.o(213958);
    }

    private void a(ctg ctg) {
        AppMethodBeat.i(213959);
        if (ctg == null) {
            AppMethodBeat.o(213959);
            return;
        }
        if (("wxpay://lqt/fixeddeposit/makeplan".equals(ctg.yUB) || "wxpay://lqt/fixeddeposit/planlist".equals(ctg.yUB)) && !((Boolean) g.aAh().azQ().get(ar.a.USERINFO_LQT_FIXED_DEPOSIT_HAS_SHOW_ENTRANCE_TIPS_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue() && Util.isNullOrNil(ctg.desc)) {
            ctg.desc = getContext().getResources().getText(R.string.ih0).toString();
        }
        AppMethodBeat.o(213959);
    }

    static /* synthetic */ void b(WalletLqtDetailUI walletLqtDetailUI) {
        AppMethodBeat.i(213960);
        if (walletLqtDetailUI.Hxo != null && !walletLqtDetailUI.HxU && !Util.isNullOrNil(walletLqtDetailUI.Hxo.MMs)) {
            try {
                JSONObject jSONObject = new JSONObject(walletLqtDetailUI.Hxo.MMs);
                String optString = jSONObject.optString("done_button_wording");
                int optInt = jSONObject.optInt("is_show_protocol", 0);
                String optString2 = jSONObject.optString("left_protocol_wording");
                String optString3 = jSONObject.optString("new_upload_credit_url");
                String optString4 = jSONObject.optString("protocol_url");
                String optString5 = jSONObject.optString("right_protocol_wording");
                String optString6 = jSONObject.optString(MessengerShareContentUtility.SUBTITLE);
                String optString7 = jSONObject.optString("title");
                JSONArray optJSONArray = jSONObject.optJSONArray("upload_reasons");
                LinkedList linkedList = new LinkedList();
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        linkedList.add(optJSONArray.optString(i2));
                    }
                }
                com.tencent.mm.plugin.wallet_core.ui.o.a(walletLqtDetailUI.getContext(), optString7, optString6, linkedList, optString, optInt, optString2, optString5, optString4, optString3);
                walletLqtDetailUI.HxU = true;
                AppMethodBeat.o(213960);
                return;
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.WalletLqtDetailUI", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(213960);
    }

    static /* synthetic */ void e(WalletLqtDetailUI walletLqtDetailUI) {
        AppMethodBeat.i(213962);
        if (walletLqtDetailUI.Hxo.MMq != null) {
            final android.support.design.widget.a aVar = new android.support.design.widget.a(walletLqtDetailUI.getContext());
            View inflate = View.inflate(walletLqtDetailUI.getContext(), R.layout.b2z, null);
            TextView textView = (TextView) inflate.findViewById(R.id.ewo);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.ewt);
            TextView textView2 = (TextView) inflate.findViewById(R.id.ews);
            ((TextView) inflate.findViewById(R.id.ewu)).setText(walletLqtDetailUI.Hxo.MMq.title);
            if (!Util.isNullOrNil(walletLqtDetailUI.Hxo.MMq.desc)) {
                textView.setText(walletLqtDetailUI.Hxo.MMq.desc);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            textView2.setText(walletLqtDetailUI.Hxo.MMq.LAi);
            if (walletLqtDetailUI.Hxo.MMq.LAj != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = qfn;
                Iterator<aog> it = walletLqtDetailUI.Hxo.MMq.LAj.iterator();
                while (it.hasNext()) {
                    aog next = it.next();
                    ViewGroup viewGroup2 = (ViewGroup) View.inflate(walletLqtDetailUI.getContext(), R.layout.b30, null);
                    ((CdnImageView) viewGroup2.findViewById(R.id.ewq)).setUrl(next.iwv);
                    ((TextView) viewGroup2.findViewById(R.id.ewr)).setText(next.title);
                    ((TextView) viewGroup2.findViewById(R.id.ewp)).setText(next.desc);
                    viewGroup.addView(viewGroup2, layoutParams);
                }
            }
            textView2.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.AnonymousClass15 */

                public final void onClick(View view) {
                    AppMethodBeat.i(213939);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    aVar.dismiss();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtDetailUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213939);
                }
            });
            aVar.setContentView(inflate);
            BottomSheetBehavior l = BottomSheetBehavior.l((View) inflate.getParent());
            if (l != null) {
                l.J(a.fromDPToPix((Context) walletLqtDetailUI.getContext(), (int) JsApiOpenAdCanvas.CTRL_INDEX));
                l.ob = false;
            }
            aVar.show();
        }
        AppMethodBeat.o(213962);
    }

    static /* synthetic */ void a(WalletLqtDetailUI walletLqtDetailUI, boolean z, cgt cgt) {
        AppMethodBeat.i(213964);
        if (cgt == null) {
            if (z) {
                walletLqtDetailUI.aUK("");
                AppMethodBeat.o(213964);
                return;
            }
            walletLqtDetailUI.aUL("");
            AppMethodBeat.o(213964);
        } else if (cgt.type == 1 && !Util.isNullOrNil(cgt.url)) {
            String aUI = ag.aUI(cgt.url);
            if (z) {
                walletLqtDetailUI.aUK(aUI);
                AppMethodBeat.o(213964);
                return;
            }
            walletLqtDetailUI.aUL(aUI);
            AppMethodBeat.o(213964);
        } else if (cgt.type == 2) {
            f.o(walletLqtDetailUI.getContext(), cgt.url, true);
            AppMethodBeat.o(213964);
        } else if (cgt.type == 3) {
            f.u(cgt.KZR, cgt.url, 0, 1061);
            AppMethodBeat.o(213964);
        } else if (z) {
            walletLqtDetailUI.aUK("");
            AppMethodBeat.o(213964);
        } else {
            walletLqtDetailUI.aUL("");
            AppMethodBeat.o(213964);
        }
    }
}
