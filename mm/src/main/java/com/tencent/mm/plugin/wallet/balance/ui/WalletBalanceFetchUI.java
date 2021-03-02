package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.b;
import com.tencent.mm.plugin.wallet.balance.model.d;
import com.tencent.mm.plugin.wallet_core.c.aa;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@a(2)
public class WalletBalanceFetchUI extends WalletBaseUI implements WcPayKeyboard.a, WalletFormView.a {
    private static final String Hvz = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e1p) + "/touch/product/wechatwallet_app.html?platform=15&scene_id=kf4");
    private IListener<lj> AJa = new IListener<lj>() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass21 */

        {
            AppMethodBeat.i(213891);
            this.__eventId = lj.class.getName().hashCode();
            AppMethodBeat.o(213891);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lj ljVar) {
            AppMethodBeat.i(213892);
            lj ljVar2 = ljVar;
            Log.i("MicroMsg.WalletBalanceFetchUI", "KindaBindCardEvent callback");
            if (ljVar2 == null || !(ljVar2 instanceof lj)) {
                AppMethodBeat.o(213892);
                return false;
            }
            z.hhs();
            if (ljVar2.dQz != null) {
                if (ljVar2.dQz.dQA) {
                    Log.i("MicroMsg.WalletBalanceFetchUI", "KindaBindCardEvent bindCard Succ");
                    WalletBalanceFetchUI.p(WalletBalanceFetchUI.this);
                    WalletBalanceFetchUI.this.Hvs = true;
                    PayInfo payInfo = (PayInfo) WalletBalanceFetchUI.this.getInput().get("key_pay_info");
                    if (payInfo == null) {
                        payInfo = new PayInfo();
                        payInfo.dDL = WalletBalanceFetchUI.this.dDL;
                        payInfo.dVv = 21;
                    }
                    WalletBalanceFetchUI.this.doSceneForceProgress(new aa(payInfo.dDL));
                } else {
                    Log.i("MicroMsg.WalletBalanceFetchUI", "KindaBindCardEvent bindCard Cancel");
                }
            }
            EventCenter.instance.removeListener(WalletBalanceFetchUI.this.AJa);
            AppMethodBeat.o(213892);
            return true;
        }
    };
    private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 270);
    protected boolean HvA = false;
    private Runnable HvB = new Runnable() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass27 */

        public final void run() {
            AppMethodBeat.i(213895);
            WalletBalanceFetchUI.this.showNormalStWcKb();
            AppMethodBeat.o(213895);
        }
    };
    private boolean HvC = false;
    private boolean HvD = false;
    private boolean HvE = false;
    private boolean HvF = false;
    private ArrayList<Bankcard> Hva;
    private Bankcard Hvb;
    private String Hvc;
    private WalletFormView Hvd;
    private LinearLayout Hve;
    private View Hvf;
    private TextView Hvg;
    private TextView Hvh;
    private TextView Hvi;
    private TextView Hvj;
    private ViewGroup Hvk;
    private ViewGroup Hvl;
    private int Hvm = 0;
    private int Hvn = 0;
    private int Hvo = 0;
    private double Hvp = 0.0d;
    private int Hvq = 0;
    private DecimalFormat Hvr = new DecimalFormat("0.00");
    private boolean Hvs = false;
    private int Hvt = 0;
    private int Hvu = 0;
    private b Hvv;
    private int Hvw = MMApplicationContext.getContext().getResources().getColor(R.color.FG_1);
    com.tencent.mm.plugin.wallet.ui.a Hvx;
    private Runnable Hvy = new Runnable() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(68576);
            WalletBalanceFetchUI.a(WalletBalanceFetchUI.this);
            AppMethodBeat.o(68576);
        }
    };
    private String dDL = null;
    private View jBN;
    private double jVp;
    public Runnable jVx = new Runnable() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass26 */

        public final void run() {
            AppMethodBeat.i(68600);
            if (WalletBalanceFetchUI.this.state == 2 && WalletBalanceFetchUI.this.isHandleAutoShowNormalStWcKb()) {
                WalletBalanceFetchUI.this.showNormalStWcKb();
            }
            AppMethodBeat.o(68600);
        }
    };
    private String lem;
    private int state = 0;
    private int whv = -1;
    HashMap<String, Integer> yNN = new HashMap<>();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBalanceFetchUI() {
        AppMethodBeat.i(68606);
        AppMethodBeat.o(68606);
    }

    static /* synthetic */ void a(WalletBalanceFetchUI walletBalanceFetchUI, double d2, String str, String str2, String str3, int i2) {
        AppMethodBeat.i(174436);
        walletBalanceFetchUI.a(d2, str, str2, str3, i2);
        AppMethodBeat.o(174436);
    }

    static /* synthetic */ boolean a(WalletBalanceFetchUI walletBalanceFetchUI, d dVar) {
        AppMethodBeat.i(68642);
        boolean b2 = walletBalanceFetchUI.b(dVar);
        AppMethodBeat.o(68642);
        return b2;
    }

    static /* synthetic */ void b(WalletBalanceFetchUI walletBalanceFetchUI, d dVar) {
        AppMethodBeat.i(68643);
        walletBalanceFetchUI.a(dVar);
        AppMethodBeat.o(68643);
    }

    static /* synthetic */ void d(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.i(213904);
        walletBalanceFetchUI.fNe();
        AppMethodBeat.o(213904);
    }

    static /* synthetic */ void f(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.i(68635);
        walletBalanceFetchUI.fNj();
        AppMethodBeat.o(68635);
    }

    static /* synthetic */ void fNl() {
    }

    static /* synthetic */ boolean fNm() {
        AppMethodBeat.i(174435);
        boolean eNx = eNx();
        AppMethodBeat.o(174435);
        return eNx;
    }

    static /* synthetic */ void g(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.i(213905);
        walletBalanceFetchUI.updateView();
        AppMethodBeat.o(213905);
    }

    static /* synthetic */ void k(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.i(68639);
        walletBalanceFetchUI.fNf();
        AppMethodBeat.o(68639);
    }

    static /* synthetic */ void l(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.i(68640);
        walletBalanceFetchUI.fNd();
        AppMethodBeat.o(68640);
    }

    static /* synthetic */ void o(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.i(68641);
        walletBalanceFetchUI.fNh();
        AppMethodBeat.o(68641);
    }

    static /* synthetic */ void p(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.i(68644);
        walletBalanceFetchUI.fNi();
        AppMethodBeat.o(68644);
    }

    static {
        AppMethodBeat.i(213907);
        AppMethodBeat.o(213907);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c7l;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68607);
        this.lem = UUID.randomUUID().toString();
        super.onCreate(bundle);
        hideActionbarLine();
        bf(getIntent());
        fetchData();
        this.Hvc = getString(R.string.i7_);
        initView();
        updateView();
        ab.mg(4, 0);
        AppMethodBeat.o(68607);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(68608);
        MMHandlerThread.removeRunnable(this.Hvy);
        MMHandlerThread.removeRunnable(this.jVx);
        MMHandlerThread.removeRunnable(this.HvB);
        super.onDestroy();
        AppMethodBeat.o(68608);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fetchData() {
        /*
        // Method dump skipped, instructions count: 403
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.fetchData():void");
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isTransparent() {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(68610);
        setMMTitle(R.string.i6f);
        this.jBN = findViewById(R.id.cfq);
        this.Hve = (LinearLayout) findViewById(R.id.zr);
        ao.a(((TextView) this.Hve.findViewById(R.id.zs)).getPaint(), 0.8f);
        AnonymousClass12 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass12 */

            public final void onClick(View view) {
                String str;
                String str2;
                AppMethodBeat.i(68591);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletBalanceFetchUI.this.mWcKeyboard.hgN();
                s.fOg();
                final ArrayList<Bankcard> fRG = s.fOh().fRG();
                s.fOg();
                com.tencent.mm.plugin.wallet_core.model.b bVar2 = s.fOh().IbO;
                if (bVar2 != null) {
                    str = bVar2.HVj;
                    str2 = bVar2.HVi;
                } else {
                    str = "";
                    str2 = "";
                }
                if (fRG == null) {
                    Log.i("MicroMsg.WalletBalanceFetchUI", "debit is null");
                }
                WalletBalanceFetchUI walletBalanceFetchUI = WalletBalanceFetchUI.this;
                AppCompatActivity context = WalletBalanceFetchUI.this.getContext();
                Bankcard bankcard = WalletBalanceFetchUI.this.Hvb;
                new o.g() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass12.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(68590);
                        if (fRG == null || i2 >= fRG.size()) {
                            Log.i("MicroMsg.WalletBalanceFetchUI", "add new card");
                            WalletBalanceFetchUI.f(WalletBalanceFetchUI.this);
                            h hVar = h.INSTANCE;
                            Object[] objArr = new Object[4];
                            objArr[0] = WalletBalanceFetchUI.this.lem;
                            objArr[1] = 9;
                            objArr[2] = WalletBalanceFetchUI.this.Hvb != null ? WalletBalanceFetchUI.this.Hvb.field_bankcardType : "";
                            objArr[3] = WalletBalanceFetchUI.this.Hvb != null ? WalletBalanceFetchUI.this.Hvb.field_bindSerial : "";
                            hVar.a(16398, objArr);
                        } else {
                            WalletBalanceFetchUI.this.Hvb = (Bankcard) fRG.get(i2);
                            WalletBalanceFetchUI.d(WalletBalanceFetchUI.this);
                            Log.i("MicroMsg.WalletBalanceFetchUI", "bankcard: %s", WalletBalanceFetchUI.this.Hvb.field_desc);
                            h hVar2 = h.INSTANCE;
                            Object[] objArr2 = new Object[4];
                            objArr2[0] = WalletBalanceFetchUI.this.lem;
                            objArr2[1] = 2;
                            objArr2[2] = WalletBalanceFetchUI.this.Hvb != null ? WalletBalanceFetchUI.this.Hvb.field_bankcardType : "";
                            objArr2[3] = WalletBalanceFetchUI.this.Hvb != null ? WalletBalanceFetchUI.this.Hvb.field_bindSerial : "";
                            hVar2.a(16398, objArr2);
                        }
                        WalletBalanceFetchUI.g(WalletBalanceFetchUI.this);
                        WalletBalanceFetchUI.fNl();
                        AppMethodBeat.o(68590);
                    }
                };
                if (walletBalanceFetchUI.Hvx == null || !walletBalanceFetchUI.Hvx.qAx.isShowing()) {
                    walletBalanceFetchUI.yNN.clear();
                    walletBalanceFetchUI.Hvx = new com.tencent.mm.plugin.wallet.ui.a(context);
                    walletBalanceFetchUI.Hvx.HLX = new o.f(fRG, context) {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass14 */
                        final /* synthetic */ List HvP;
                        final /* synthetic */ Context val$context;

                        {
                            this.HvP = r2;
                            this.val$context = r3;
                        }

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(final m mVar) {
                            final String str;
                            SpannableString spannableString;
                            String str2;
                            AppMethodBeat.i(213884);
                            int i2 = 0;
                            if (this.HvP != null) {
                                for (final Bankcard bankcard : this.HvP) {
                                    e j2 = com.tencent.mm.plugin.wallet_core.d.b.j(this.val$context, bankcard.field_bankcardType, bankcard.fQa());
                                    if (j2 != null) {
                                        str = j2.AAU;
                                    } else {
                                        str = "";
                                    }
                                    Log.d("MicroMsg.WalletBalanceFetchUI", "logo url: %s", str);
                                    Bitmap a2 = u.a(new c(str));
                                    u.a(new u.a() {
                                        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass14.AnonymousClass1 */

                                        @Override // com.tencent.mm.platformtools.u.a
                                        public final void k(final String str, final Bitmap bitmap) {
                                            AppMethodBeat.i(213882);
                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass14.AnonymousClass1.AnonymousClass1 */

                                                public final void run() {
                                                    int intValue;
                                                    AppMethodBeat.i(213881);
                                                    Log.i("MicroMsg.WalletBalanceFetchUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", str, str);
                                                    if (WalletBalanceFetchUI.this.Hvx.qAx.isShowing() && WalletBalanceFetchUI.this.yNN.containsKey(str) && (intValue = ((Integer) WalletBalanceFetchUI.this.yNN.get(str)).intValue()) < mVar.size() && mVar.getItem(intValue) != null) {
                                                        mVar.getItem(intValue).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(bitmap, WalletBalanceFetchUI.this.getResources().getDimensionPixelOffset(R.dimen.aov), WalletBalanceFetchUI.this.getResources().getDimensionPixelOffset(R.dimen.aov), true, false)));
                                                        WalletBalanceFetchUI.this.Hvx.fPw();
                                                    }
                                                    AppMethodBeat.o(213881);
                                                }
                                            });
                                            AppMethodBeat.o(213882);
                                        }
                                    });
                                    String str3 = "";
                                    if (!Util.isNullOrNil(bankcard.field_forbidWord)) {
                                        str3 = bankcard.field_forbidWord;
                                    }
                                    if (Util.isNullOrNil(bankcard.field_forbid_title)) {
                                        spannableString = new SpannableString(str3);
                                        str2 = str3;
                                    } else {
                                        String str4 = str3 + " ";
                                        SpannableString spannableString2 = new SpannableString(str4 + bankcard.field_forbid_title);
                                        AnonymousClass2 r3 = new l(this.val$context) {
                                            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass14.AnonymousClass2 */

                                            @Override // com.tencent.mm.plugin.wallet_core.ui.l
                                            public final void onClick(View view) {
                                                AppMethodBeat.i(213883);
                                                Intent intent = new Intent();
                                                String str = bankcard.field_forbid_url;
                                                Log.i("MicroMsg.WalletBalanceFetchUI", "go to url %s", str);
                                                intent.putExtra("rawUrl", str);
                                                intent.putExtra("geta8key_username", com.tencent.mm.model.z.aTY());
                                                intent.putExtra("pay_channel", 1);
                                                f.aA(WalletBalanceFetchUI.this.getContext(), intent);
                                                AppMethodBeat.o(213883);
                                            }
                                        };
                                        int length = str4.length();
                                        int length2 = str4.length() + bankcard.field_forbid_title.length();
                                        spannableString2.setSpan(new ForegroundColorSpan(this.val$context.getResources().getColor(R.color.ael)), length, length2, 33);
                                        spannableString2.setSpan(r3, length, length2, 33);
                                        spannableString = spannableString2;
                                        str2 = str4;
                                    }
                                    if (Util.isNullOrNil(spannableString)) {
                                        spannableString = new SpannableString(bankcard.field_fetchArriveTimeWording);
                                    }
                                    String str5 = bankcard.field_desc;
                                    Bitmap extractThumbNail = a2 != null ? BitmapUtil.extractThumbNail(a2, this.val$context.getResources().getDimensionPixelOffset(R.dimen.aov), this.val$context.getResources().getDimensionPixelOffset(R.dimen.aov), true, false) : null;
                                    Log.i("MicroMsg.WalletBalanceFetchUI", "i %d fee %s %s", Integer.valueOf(i2), str5, spannableString);
                                    int i3 = i2 + 1;
                                    mVar.a(i2, str5, spannableString, extractThumbNail == null ? null : new BitmapDrawable(extractThumbNail), 0, !Util.isNullOrNil(str2));
                                    if (extractThumbNail == null) {
                                        WalletBalanceFetchUI.this.yNN.put(str, Integer.valueOf(i3));
                                    }
                                    i2 = i3;
                                }
                            }
                            AppMethodBeat.o(213884);
                        }
                    };
                    m mVar = new m(walletBalanceFetchUI);
                    mVar.a(0, walletBalanceFetchUI.getString(R.string.i6g), null, walletBalanceFetchUI.getResources().getDrawable(R.raw.icons_outlined_pay_cards), walletBalanceFetchUI.getResources().getColor(R.color.FG_2), false);
                    walletBalanceFetchUI.Hvx.a(mVar, new o.g() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass15 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(213885);
                            if (WalletBalanceFetchUI.this.Hvx == null) {
                                AppMethodBeat.o(213885);
                                return;
                            }
                            WalletBalanceFetchUI.this.Hvx.qAx.bMo();
                            Log.i("MicroMsg.WalletBalanceFetchUI", "add new card");
                            WalletBalanceFetchUI.f(WalletBalanceFetchUI.this);
                            h hVar = h.INSTANCE;
                            Object[] objArr = new Object[4];
                            objArr[0] = WalletBalanceFetchUI.this.lem;
                            objArr[1] = 9;
                            objArr[2] = WalletBalanceFetchUI.this.Hvb != null ? WalletBalanceFetchUI.this.Hvb.field_bankcardType : "";
                            objArr[3] = WalletBalanceFetchUI.this.Hvb != null ? WalletBalanceFetchUI.this.Hvb.field_bindSerial : "";
                            hVar.a(16398, objArr);
                            AppMethodBeat.o(213885);
                        }
                    });
                    walletBalanceFetchUI.Hvx.a(new g.a(fRG) {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass16 */
                        final /* synthetic */ List HvP;

                        {
                            this.HvP = r2;
                        }

                        @Override // com.tencent.mm.ui.widget.a.g.a
                        public final void onClick() {
                            AppMethodBeat.i(213886);
                            if (this.HvP == null || WalletBalanceFetchUI.this.Hvx.jKz < 0 || WalletBalanceFetchUI.this.Hvx.jKz >= this.HvP.size()) {
                                Log.i("MicroMsg.WalletBalanceFetchUI", "add new card");
                                WalletBalanceFetchUI.f(WalletBalanceFetchUI.this);
                                h hVar = h.INSTANCE;
                                Object[] objArr = new Object[4];
                                objArr[0] = WalletBalanceFetchUI.this.lem;
                                objArr[1] = 9;
                                objArr[2] = WalletBalanceFetchUI.this.Hvb != null ? WalletBalanceFetchUI.this.Hvb.field_bankcardType : "";
                                objArr[3] = WalletBalanceFetchUI.this.Hvb != null ? WalletBalanceFetchUI.this.Hvb.field_bindSerial : "";
                                hVar.a(16398, objArr);
                            } else {
                                WalletBalanceFetchUI.this.Hvb = (Bankcard) this.HvP.get(WalletBalanceFetchUI.this.Hvx.jKz);
                                WalletBalanceFetchUI.d(WalletBalanceFetchUI.this);
                                Log.i("MicroMsg.WalletBalanceFetchUI", "bankcard: %s", WalletBalanceFetchUI.this.Hvb.field_desc);
                                h hVar2 = h.INSTANCE;
                                Object[] objArr2 = new Object[4];
                                objArr2[0] = WalletBalanceFetchUI.this.lem;
                                objArr2[1] = 2;
                                objArr2[2] = WalletBalanceFetchUI.this.Hvb != null ? WalletBalanceFetchUI.this.Hvb.field_bankcardType : "";
                                objArr2[3] = WalletBalanceFetchUI.this.Hvb != null ? WalletBalanceFetchUI.this.Hvb.field_bindSerial : "";
                                hVar2.a(16398, objArr2);
                            }
                            WalletBalanceFetchUI.g(WalletBalanceFetchUI.this);
                            WalletBalanceFetchUI.fNl();
                            WalletBalanceFetchUI.this.Hvx.qAx.bMo();
                            AppMethodBeat.o(213886);
                        }
                    });
                    View inflate = View.inflate(walletBalanceFetchUI, R.layout.b3b, null);
                    TextView textView = (TextView) inflate.findViewById(R.id.exq);
                    if (!Util.isNullOrNil(str2)) {
                        textView.setText(str2);
                    }
                    if (!Util.isNullOrNil(str)) {
                        ((TextView) inflate.findViewById(R.id.exp)).setText(str);
                    }
                    ao.a(textView.getPaint(), 0.8f);
                    inflate.findViewById(R.id.boz).setVisibility(0);
                    inflate.findViewById(R.id.ewv).setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass17 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(213887);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (WalletBalanceFetchUI.this.Hvx != null) {
                                WalletBalanceFetchUI.this.Hvx.qAx.bMo();
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(213887);
                        }
                    });
                    walletBalanceFetchUI.Hvx.setTitleView(inflate);
                    int i2 = 0;
                    if (fRG != null) {
                        i2 = fRG.size();
                        if (bankcard != null) {
                            for (int i3 = 0; i3 < fRG.size(); i3++) {
                                if (fRG.get(i3).field_bindSerial.equals(bankcard.field_bindSerial)) {
                                    i2 = i3;
                                }
                            }
                        }
                    }
                    walletBalanceFetchUI.Hvx.HMg = true;
                    walletBalanceFetchUI.Hvx.jKz = i2;
                    walletBalanceFetchUI.Hvx.HMf = true;
                    walletBalanceFetchUI.Hvx.T(walletBalanceFetchUI.getResources().getString(R.string.ic6));
                    walletBalanceFetchUI.Hvx.dGm();
                } else {
                    Log.i("MicroMsg.WalletBalanceFetchUI", "mmBottomSheet != null && mmBottomSheet.isShowing(),dont show bottomSheet");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68591);
            }
        };
        this.Hvf = findViewById(R.id.zr);
        this.Hvf.setOnClickListener(r0);
        this.Hve.setOnClickListener(r0);
        this.Hvd = (WalletFormView) findViewById(R.id.zu);
        com.tencent.mm.wallet_core.ui.formview.a.f(this.Hvd);
        this.Hvd.setOnInputValidChangeListener(this);
        this.mWcKeyboard = new WcPayKeyboard(this);
        this.mWcKeyboard.s(this);
        setWPKeyboard(this.Hvd.getContentEt(), true, false);
        this.mWcKeyboard.setActionText(getString(R.string.i6p));
        this.Hvd.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass22 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(213893);
                if (keyEvent != null && keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 66) {
                    WalletBalanceFetchUI.h(WalletBalanceFetchUI.this);
                }
                AppMethodBeat.o(213893);
                return true;
            }
        });
        this.Hvg = (TextView) findViewById(R.id.jd_);
        this.Hvh = (TextView) findViewById(R.id.cfo);
        this.Hvi = (TextView) findViewById(R.id.cfl);
        this.Hvj = (TextView) findViewById(R.id.cfm);
        this.Hvk = (ViewGroup) findViewById(R.id.cfn);
        this.Hvl = (ViewGroup) findViewById(R.id.cfp);
        ao.a(this.Hvi.getPaint(), 0.8f);
        this.Hvi.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass23 */

            public final void onClick(View view) {
                AppMethodBeat.i(68597);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletBalanceFetchUI.i(WalletBalanceFetchUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68597);
            }
        });
        this.Hvd.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass24 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(68598);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                obj.length();
                int lastIndexOf = obj.lastIndexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    WalletFormView.a(WalletBalanceFetchUI.this.Hvd.getContentEt(), obj, indexOf + 3, length);
                } else if (lastIndexOf != indexOf) {
                    WalletFormView.a(WalletBalanceFetchUI.this.Hvd.getContentEt(), obj, lastIndexOf, length);
                }
                WalletBalanceFetchUI.this.jVp = Util.getDouble(editable.toString(), 0.0d);
                WalletBalanceFetchUI.fNl();
                WalletBalanceFetchUI.k(WalletBalanceFetchUI.this);
                WalletBalanceFetchUI.l(WalletBalanceFetchUI.this);
                AppMethodBeat.o(68598);
            }
        });
        final zt ztVar = new zt();
        ztVar.efM.scene = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
        ztVar.callback = new Runnable() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass25 */

            public final void run() {
                AppMethodBeat.i(213894);
                if (!Util.isNullOrNil(ztVar.efN.efO)) {
                    f.a(WalletBalanceFetchUI.this.Hvg, ztVar.efN.efO, ztVar.efN.content, ztVar.efN.url);
                    AppMethodBeat.o(213894);
                    return;
                }
                Log.i("MicroMsg.WalletBalanceFetchUI", "no bulletin data");
                AppMethodBeat.o(213894);
            }
        };
        EventCenter.instance.publish(ztVar);
        AppMethodBeat.o(68610);
    }

    private void fNd() {
        AppMethodBeat.i(213898);
        if (Util.getDouble(this.Hvd.getText(), 0.0d) <= 0.0d || !this.Hvd.bql()) {
            this.mWcKeyboard.DH(false);
            AppMethodBeat.o(213898);
            return;
        }
        this.mWcKeyboard.DH(true);
        AppMethodBeat.o(213898);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(68611);
        fNi();
        super.onResume();
        if (this.state == 3 && isHandleAutoShowNormalStWcKb()) {
            MMHandlerThread.postToMainThreadDelayed(this.HvB, 300);
        }
        this.state = 2;
        fNd();
        AppMethodBeat.o(68611);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(213899);
        super.onPause();
        if (!this.mWcKeyboard.hgQ()) {
            this.state = 3;
        }
        AppMethodBeat.o(213899);
    }

    @Override // com.tencent.mm.ui.widget.a.c, com.tencent.mm.ui.MMActivity
    public void onDialogDismiss(Dialog dialog) {
        AppMethodBeat.i(213900);
        Log.i("MicroMsg.WalletBalanceFetchUI", "onDialogDismiss()");
        MMHandlerThread.postToMainThreadDelayed(this.jVx, 300);
        AppMethodBeat.o(213900);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isHandleAutoShowNormalStWcKb() {
        AppMethodBeat.i(213901);
        Log.d("MicroMsg.WalletBalanceFetchUI", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", Boolean.valueOf(this.HvA), Boolean.valueOf(this.mWcKeyboard.hgR()));
        if (this.HvA || !this.mWcKeyboard.hgR()) {
            AppMethodBeat.o(213901);
            return false;
        }
        AppMethodBeat.o(213901);
        return true;
    }

    private void fNe() {
        AppMethodBeat.i(68612);
        if (this.Hvb != null) {
            this.Hvp = f.a(new StringBuilder().append(this.Hvb.HVX).toString(), "100", 2, RoundingMode.HALF_UP);
            Log.i("MicroMsg.WalletBalanceFetchUI", "min charge fee: %s", Double.valueOf(this.Hvp));
        }
        AppMethodBeat.o(68612);
    }

    private void updateView() {
        AppMethodBeat.i(68613);
        if (this.Hvd.getTitleTv() != null) {
            this.Hvd.getTitleTv().setText(String.format(getString(R.string.g3d), ah.hhz()));
        } else {
            Log.i("MicroMsg.WalletBalanceFetchUI", "mTotalFeeEHV.getTitleTv() is null");
        }
        final ImageView imageView = (ImageView) this.Hve.findViewById(R.id.a1s);
        if (this.Hvb != null) {
            String str = "";
            e j2 = com.tencent.mm.plugin.wallet_core.d.b.j(this, this.Hvb.field_bankcardType, this.Hvb.fQa());
            if (j2 != null) {
                str = j2.AAU;
            }
            imageView.setImageBitmap(null);
            if (this.Hvb.fQb()) {
                imageView.setBackgroundResource(R.drawable.cqo);
            } else {
                Bitmap a2 = u.a(new c(str));
                u.a(new u.a() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass28 */

                    @Override // com.tencent.mm.platformtools.u.a
                    public final void k(String str, final Bitmap bitmap) {
                        AppMethodBeat.i(213897);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass28.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(213896);
                                if (!(WalletBalanceFetchUI.this.Hvb == null || imageView == null || imageView.getTag() == null || !imageView.getTag().equals(WalletBalanceFetchUI.this.Hvb.field_bindSerial))) {
                                    imageView.setImageBitmap(bitmap);
                                }
                                AppMethodBeat.o(213896);
                            }
                        });
                        AppMethodBeat.o(213897);
                    }
                });
                if (!(a2 == null || a2 == null)) {
                    imageView.setImageBitmap(BitmapUtil.extractThumbNail(a2, getResources().getDimensionPixelOffset(R.dimen.aov), getResources().getDimensionPixelOffset(R.dimen.aov), true, false));
                }
            }
            ((TextView) this.Hve.findViewById(R.id.zs)).setText(getString(R.string.i79, new Object[]{this.Hvb.field_bankName, this.Hvb.field_bankcardTail}));
            ((TextView) this.Hve.findViewById(R.id.zs)).setVisibility(0);
            if (!Util.isNullOrNil(this.Hvb.field_fetchArriveTimeWording)) {
                ((TextView) this.Hve.findViewById(R.id.dpd)).setText(this.Hvb.field_fetchArriveTimeWording);
                ((TextView) this.Hve.findViewById(R.id.dpd)).setVisibility(0);
                if (this.Hvb.field_is_hightlight_pre_arrive_time_wording == 1) {
                    ((TextView) this.Hve.findViewById(R.id.dpd)).setTextColor(getResources().getColor(R.color.Orange));
                } else {
                    ((TextView) this.Hve.findViewById(R.id.dpd)).setTextColor(getResources().getColor(R.color.uj));
                }
            }
        } else {
            imageView.setImageBitmap(null);
            ((TextView) this.Hve.findViewById(R.id.zs)).setText(this.Hvc);
            ((TextView) this.Hve.findViewById(R.id.dpd)).setText("");
            ((TextView) this.Hve.findViewById(R.id.dpd)).setVisibility(8);
            ((ImageView) this.Hve.findViewById(R.id.a1s)).setImageBitmap(null);
        }
        s.fOg();
        Util.isNullOrNil(s.fOh().Hwc.HVI);
        if (this.Hvt == 1) {
            this.Hvk.setVisibility(8);
            this.Hvl.setVisibility(0);
        } else {
            this.Hvk.setVisibility(0);
            this.Hvl.setVisibility(8);
        }
        fNf();
        fNg();
        dzO();
        AppMethodBeat.o(68613);
    }

    private void dzO() {
        AppMethodBeat.i(68614);
        s.fOg();
        final com.tencent.mm.plugin.wallet_core.model.b bVar = s.fOh().IbO;
        removeAllOptionMenu();
        if (!(bVar == null || bVar.HVk == null || bVar.HVk.HVm == null || bVar.HVk.HVm.length <= 0)) {
            addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass2 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(213871);
                    com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) WalletBalanceFetchUI.this.getContext(), 1, false);
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(213869);
                            b.c[] cVarArr = bVar.HVk.HVm;
                            int i2 = 0;
                            for (b.c cVar : cVarArr) {
                                if (!Util.isNullOrNil(cVar.title)) {
                                    if (!Util.isNullOrNil(cVar.desc)) {
                                        mVar.a(i2, cVar.title, cVar.desc, 0);
                                    } else {
                                        mVar.d(i2, cVar.title);
                                    }
                                }
                                i2++;
                            }
                            AppMethodBeat.o(213869);
                        }
                    };
                    eVar.HLY = new o.g() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass2.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(213870);
                            int itemId = menuItem.getItemId();
                            if (bVar.HVk.HVm != null && itemId < bVar.HVk.HVm.length) {
                                b.c cVar = bVar.HVk.HVm[itemId];
                                Log.i("MicroMsg.WalletBalanceFetchUI", "jump type: %s, url: %s", Integer.valueOf(cVar.uSc), cVar.pTL);
                                switch (cVar.uSc) {
                                    case 1:
                                        f.p(WalletBalanceFetchUI.this.getContext(), cVar.pTL, true);
                                        AppMethodBeat.o(213870);
                                        return;
                                    case 2:
                                        f.u(cVar.username, cVar.path, 0, 1000);
                                        break;
                                }
                            }
                            AppMethodBeat.o(213870);
                        }
                    };
                    eVar.dGm();
                    AppMethodBeat.o(213871);
                    return true;
                }
            });
        }
        AppMethodBeat.o(68614);
    }

    private void fNf() {
        AppMethodBeat.i(68616);
        if (this.Hvt == 0) {
            this.jVp = Util.getDouble(this.Hvd.getText(), 0.0d);
            double d2 = this.jVp;
            s.fOg();
            if (!(d2 == s.fOh().Hwc.HVE || this.Hvb == null)) {
                double d3 = this.jVp;
                s.fOg();
                if (d3 != s.fOh().Hwc.HVE - this.Hvb.field_full_fetch_charge_fee) {
                    this.Hvq = 0;
                }
            }
            StringBuilder sb = new StringBuilder();
            int i2 = -1;
            double d4 = this.jVp;
            s.fOg();
            if (d4 > s.fOh().Hwc.HVC) {
                this.Hvi.setVisibility(8);
                this.Hvh.setTextColor(getResources().getColor(R.color.Red));
                sb.append(getString(R.string.i6i));
            } else {
                if (!(this.Hvb == null || this.Hvm == 0 || ((this.Hvm == 1 && this.Hvb.field_fetch_charge_rate <= 0.0d) || (this.Hvm == 1 && this.Hvb.field_fetch_charge_rate > 0.0d && this.Hvn == 0)))) {
                    double d5 = this.Hvp;
                    s.fOg();
                    if (d5 < s.fOh().Hwc.HVE) {
                        if (this.Hvm == 1 && this.Hvb.field_fetch_charge_rate > 0.0d && this.Hvn == 1 && (this.jVp <= 0.0d || !this.Hvd.bql())) {
                            this.Hvh.setTextColor(this.Hvw);
                            s.fOg();
                            String str = s.fOh().Hwc.HVJ;
                            if (!Util.isNullOrNil(str)) {
                                sb.append(str);
                            } else {
                                Log.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
                                s.fOg();
                                sb.append(getString(R.string.i6_, new Object[]{f.d(s.fOh().Hwc.HVE, "CNY")}));
                            }
                            sb.append("，");
                            i2 = sb.length();
                            sb.append(getString(R.string.i5y));
                        } else if (this.Hvm == 1 && this.Hvb.field_fetch_charge_rate > 0.0d && this.Hvn == 1) {
                            this.Hvi.setVisibility(8);
                            this.Hvh.setTextColor(this.Hvw);
                            double d6 = this.jVp;
                            s.fOg();
                            if (d6 != s.fOh().Hwc.HVE - this.Hvb.field_full_fetch_charge_fee || this.Hvb.field_full_fetch_charge_fee <= 0.0d) {
                                if (!Util.isNullOrNil(this.Hvb.HVW)) {
                                    sb.append(String.format(this.Hvb.HVW, f.d(z(this.jVp), "CNY")));
                                } else {
                                    sb.append(getString(R.string.i5s, new Object[]{f.d(z(this.jVp), "CNY"), (this.Hvb.field_fetch_charge_rate * 100.0d) + "%"}));
                                }
                            } else if (!Util.isNullOrNil(this.Hvb.HVW)) {
                                sb.append(String.format(this.Hvb.HVW, f.d(this.Hvb.field_full_fetch_charge_fee, "CNY")));
                            } else {
                                sb.append(getString(R.string.i5s, new Object[]{f.d(this.Hvb.field_full_fetch_charge_fee, "CNY"), (this.Hvb.field_fetch_charge_rate * 100.0d) + "%"}));
                            }
                        }
                    }
                }
                this.Hvh.setTextColor(this.Hvw);
                s.fOg();
                String str2 = s.fOh().Hwc.HVJ;
                if (!Util.isNullOrNil(str2)) {
                    sb.append(str2);
                } else {
                    Log.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
                    s.fOg();
                    sb.append(getString(R.string.i6_, new Object[]{f.d(s.fOh().Hwc.HVE, "CNY")}));
                }
                sb.append("，");
                i2 = sb.length();
                sb.append(getString(R.string.i5y));
            }
            if (i2 == -1) {
                this.Hvh.setClickable(false);
                this.Hvh.setOnTouchListener(null);
                this.Hvh.setText(sb.toString());
                AppMethodBeat.o(68616);
                return;
            }
            f.a(this.Hvh, sb.toString(), i2, sb.length(), new com.tencent.mm.wallet_core.ui.e(new e.a() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.ui.e.a
                public final void bmr() {
                    AppMethodBeat.i(213872);
                    WalletBalanceFetchUI.i(WalletBalanceFetchUI.this);
                    AppMethodBeat.o(213872);
                }
            }), getContext());
        }
        AppMethodBeat.o(68616);
    }

    private void fNg() {
        AppMethodBeat.i(213902);
        s.fOg();
        final Bankcard bankcard = s.fOh().Hwc;
        if (this.Hvb == null || Util.isNullOrNil(bankcard.field_prompt_info_prompt_text)) {
            this.Hvj.setText("");
            this.Hvj.setVisibility(8);
            this.Hvw = getContext().getResources().getColor(R.color.FG_1);
            this.Hvh.setTextColor(this.Hvw);
            AppMethodBeat.o(213902);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bankcard.field_prompt_info_prompt_text);
        if (!Util.isNullOrNil(bankcard.field_prompt_info_jump_text)) {
            spannableStringBuilder.append((CharSequence) bankcard.field_prompt_info_jump_text);
        }
        spannableStringBuilder.setSpan(new q(new q.a() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
            public final void dF(View view) {
                AppMethodBeat.i(213873);
                if (!Util.isNullOrNil(bankcard.field_prompt_info_jump_url)) {
                    f.bn(WalletBalanceFetchUI.this.getContext(), bankcard.field_prompt_info_jump_url);
                    h.INSTANCE.a(20216, 4, bankcard.field_prompt_info_jump_url);
                }
                AppMethodBeat.o(213873);
            }
        }), bankcard.field_prompt_info_prompt_text.length(), spannableStringBuilder.length(), 18);
        this.Hvj.setText(spannableStringBuilder);
        this.Hvj.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(getContext()));
        this.Hvj.setVisibility(0);
        this.Hvw = getContext().getResources().getColor(R.color.FG_0);
        this.Hvh.setTextColor(this.Hvw);
        AppMethodBeat.o(213902);
    }

    private double z(double d2) {
        AppMethodBeat.i(68617);
        s.fOg();
        double max = Math.max(f.b(new StringBuilder().append(d2 - s.fOh().IbO.Cpd).toString(), new StringBuilder().append(this.Hvb.field_fetch_charge_rate).toString(), RoundingMode.HALF_UP), this.Hvp);
        AppMethodBeat.o(68617);
        return max;
    }

    private void a(d dVar) {
        AppMethodBeat.i(68618);
        if (!Util.isNullOrNil(this.dDL)) {
            PayInfo payInfo = new PayInfo();
            payInfo.dDL = this.dDL;
            payInfo.dVv = 21;
            getInput().putParcelable("key_pay_info", payInfo);
            Orders orders = new Orders();
            orders.dDO = dVar.Cpj - dVar.CoZ;
            orders.HYM = dVar.Cpj - dVar.CoZ;
            orders.HZd.add(new Orders.Commodity());
            orders.CoZ = dVar.CoZ;
            getInput().putString("key_fetch_cashier_encode_str", dVar.Htb);
            getInput().putParcelable("key_orders", orders);
            getInput().putParcelable("key_bankcard", this.Hvb);
            getInput().putString("key_fetch_cashier_desc", dVar.HsY);
            getInput().putString("key_report_session_id", this.lem);
            if (getProcess() == null) {
                com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, getInput(), (d.a) null);
                AppMethodBeat.o(68618);
                return;
            }
            getNetController().r(getInput());
            AppMethodBeat.o(68618);
            return;
        }
        Log.w("MicroMsg.WalletBalanceFetchUI", "hy: req key is null. abandon");
        AppMethodBeat.o(68618);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(68619);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof com.tencent.mm.plugin.wallet.balance.model.d) {
                com.tencent.mm.plugin.wallet.balance.model.d dVar = (com.tencent.mm.plugin.wallet.balance.model.d) qVar;
                this.HvC = false;
                if (!this.HvF) {
                    this.HvD = false;
                }
                this.HvE = false;
                this.HvF = false;
                if ("1".equals(dVar.egd)) {
                    Log.i("MicroMsg.WalletBalanceFetchUI", "need realname verify");
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceFetchUI");
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    isTransparent();
                    z = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, null, 0);
                } else if ("2".equals(dVar.egd)) {
                    Log.i("MicroMsg.WalletBalanceFetchUI", "need upload credit");
                    z = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, dVar.ege, dVar.egh, dVar.egf, dVar.egg, isTransparent(), (DialogInterface.OnClickListener) null);
                } else {
                    Log.i("MicroMsg.WalletBalanceFetchUI", "realnameGuideFlag =  " + dVar.egd);
                    z = false;
                }
                if (z) {
                    AppMethodBeat.o(68619);
                    return false;
                }
                if (dVar.HsZ) {
                    if (dVar.Hta != null) {
                        Log.i("MicroMsg.WalletBalanceFetchUI", "debugIdentifyInfoCompleteDialog() show");
                        String str2 = dVar.Hta.title;
                        String str3 = dVar.Hta.content;
                        String str4 = dVar.Hta.gTt;
                        final String str5 = dVar.Hta.Htc;
                        Log.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog()");
                        View inflate = LayoutInflater.from(this).inflate(R.layout.c7k, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.f6o)).setText(str2);
                        ((TextView) inflate.findViewById(R.id.f6j)).setText(str3);
                        ((Button) inflate.findViewById(R.id.b9t)).setText(str4);
                        final com.tencent.mm.plugin.crashfix.b.a aVar = new com.tencent.mm.plugin.crashfix.b.a(this, R.style.a66);
                        aVar.setContentView(inflate);
                        aVar.setTitle((CharSequence) null);
                        aVar.setOnCancelListener(new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass18 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(213888);
                                Log.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog onCancel");
                                if (aVar != null && aVar.isShowing()) {
                                    aVar.dismiss();
                                }
                                AppMethodBeat.o(213888);
                            }
                        });
                        ((ImageView) inflate.findViewById(R.id.b4d)).setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass19 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(213889);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Log.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog closeIcon click");
                                if (aVar != null && aVar.isShowing()) {
                                    aVar.dismiss();
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(213889);
                            }
                        });
                        ((Button) inflate.findViewById(R.id.b9t)).setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass20 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(213890);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Log.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog completeBtn click");
                                com.tencent.mm.plugin.account.a.b.a.b(this, str5, 2, true);
                                if (aVar != null && aVar.isShowing()) {
                                    aVar.dismiss();
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(213890);
                            }
                        });
                        aVar.show();
                        com.tencent.mm.ui.base.h.a(this, aVar);
                    } else {
                        Log.i("MicroMsg.WalletBalanceFetchUI", "fetchScene.accountTipDialog == null");
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    AppMethodBeat.o(68619);
                    return false;
                }
                af.z(21, dVar.dNQ, i3);
                if (!b(dVar)) {
                    this.dDL = dVar.dNQ;
                    a(dVar);
                }
            } else if (qVar instanceof ad) {
                final ad adVar = (ad) qVar;
                fNh();
                if (adVar.isJumpRemind()) {
                    final com.tencent.mm.wallet_core.c.m jumpRemind = adVar.getJumpRemind();
                    jumpRemind.a(this, new com.tencent.mm.wallet_core.c.f() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass5 */

                        @Override // com.tencent.mm.wallet_core.c.f
                        public final void onCancel() {
                            AppMethodBeat.i(213874);
                            if (jumpRemind.hhm()) {
                                WalletBalanceFetchUI.this.finish();
                            }
                            AppMethodBeat.o(213874);
                        }

                        @Override // com.tencent.mm.wallet_core.c.f
                        public final void onEnter() {
                        }

                        @Override // com.tencent.mm.wallet_core.c.f
                        public final void onUrlOk() {
                            AppMethodBeat.i(213875);
                            if (jumpRemind.hhm()) {
                                WalletBalanceFetchUI.o(WalletBalanceFetchUI.this);
                            }
                            AppMethodBeat.o(213875);
                        }

                        @Override // com.tencent.mm.wallet_core.c.f
                        public final void onUrlCancel() {
                            AppMethodBeat.i(213876);
                            if (jumpRemind.hhm()) {
                                WalletBalanceFetchUI.this.finish();
                            }
                            AppMethodBeat.o(213876);
                        }
                    });
                    AppMethodBeat.o(68619);
                    return true;
                }
            }
        } else if (qVar instanceof com.tencent.mm.plugin.wallet.balance.model.d) {
            af.z(21, "", i3);
            fNi();
            MMHandlerThread.postToMainThreadDelayed(this.jVx, 300);
        }
        AppMethodBeat.o(68619);
        return false;
    }

    private void fNh() {
        AppMethodBeat.i(68620);
        fetchData();
        updateView();
        fNk();
        AppMethodBeat.o(68620);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(68622);
        if (i2 != 1) {
            super.onActivityResult(i2, i3, intent);
            AppMethodBeat.o(68622);
        } else if (i3 != -1 || intent == null) {
            Log.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult cancel select");
            AppMethodBeat.o(68622);
        } else {
            int intExtra = intent.getIntExtra("key_select_index", -1);
            int i4 = this.whv;
            this.whv = intExtra;
            Log.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult select bankcard index is ".concat(String.valueOf(intExtra)));
            if (this.Hva == null || intExtra < 0 || intExtra >= this.Hva.size()) {
                if (this.Hva == null || intExtra < 0 || intExtra > this.Hva.size()) {
                    this.Hvb = null;
                } else {
                    this.whv = i4;
                }
                fNj();
            } else {
                this.Hvb = this.Hva.get(intExtra);
            }
            updateView();
            AppMethodBeat.o(68622);
        }
    }

    @Override // com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a
    public final void bO(float f2) {
        AppMethodBeat.i(213903);
        if (this.jBN != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jBN.getLayoutParams();
            layoutParams.bottomMargin = (int) f2;
            Log.d("MicroMsg.WalletBalanceFetchUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", Float.valueOf(f2), Integer.valueOf(layoutParams.height));
            this.jBN.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(213903);
    }

    private boolean b(com.tencent.mm.plugin.wallet.balance.model.d dVar) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(68623);
        if (!this.HvC) {
            z = c(dVar);
        } else {
            z = false;
        }
        if (!z) {
            z = false;
        }
        if (z || this.HvD) {
            z2 = z;
        }
        if (!z2 && !this.HvE) {
            z2 = d(dVar);
        }
        AppMethodBeat.o(68623);
        return z2;
    }

    private void fNi() {
        this.HvC = false;
        this.HvD = false;
        this.HvE = false;
        this.HvF = false;
    }

    private boolean c(final com.tencent.mm.plugin.wallet.balance.model.d dVar) {
        AppMethodBeat.i(68624);
        if (dVar.HsT) {
            this.HvC = true;
            com.tencent.mm.ui.base.h.a((Context) this, false, dVar.HsU, "", getString(R.string.x_), getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(68583);
                    dialogInterface.dismiss();
                    if (!WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, dVar)) {
                        WalletBalanceFetchUI.this.dDL = dVar.dNQ;
                        WalletBalanceFetchUI.b(WalletBalanceFetchUI.this, dVar);
                    }
                    AppMethodBeat.o(68583);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(68584);
                    dialogInterface.dismiss();
                    WalletBalanceFetchUI.p(WalletBalanceFetchUI.this);
                    AppMethodBeat.o(68584);
                }
            });
            AppMethodBeat.o(68624);
            return true;
        }
        AppMethodBeat.o(68624);
        return false;
    }

    private boolean d(com.tencent.mm.plugin.wallet.balance.model.d dVar) {
        AppMethodBeat.i(68625);
        com.tencent.mm.plugin.wallet_core.model.b bVar = dVar.HsW;
        if (bVar == null || (TextUtils.isEmpty(bVar.HVg) && (bVar.HVh == null || bVar.HVh.size() <= 0))) {
            AppMethodBeat.o(68625);
            return false;
        }
        this.HvE = true;
        com.tencent.mm.plugin.wallet_core.ui.m.a(this, bVar, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass8 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(213877);
                dialogInterface.dismiss();
                String str = "";
                String str2 = "";
                if (WalletBalanceFetchUI.this.Hvb != null) {
                    str = WalletBalanceFetchUI.this.Hvb.field_bankcardType;
                    str2 = WalletBalanceFetchUI.this.Hvb.field_bindSerial;
                }
                WalletBalanceFetchUI.this.Hvq = 1;
                WalletBalanceFetchUI.this.HvF = true;
                if (WalletBalanceFetchUI.fNm()) {
                    WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, WalletBalanceFetchUI.this.jVp, "1", str, str2, WalletBalanceFetchUI.this.Hvq);
                    AppMethodBeat.o(213877);
                    return;
                }
                WalletBalanceFetchUI.this.doSceneProgress(new com.tencent.mm.plugin.wallet.balance.model.d(WalletBalanceFetchUI.this.jVp, "CNY", str, WalletBalanceFetchUI.this.Hvq));
                AppMethodBeat.o(213877);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass9 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(68586);
                dialogInterface.dismiss();
                WalletBalanceFetchUI.p(WalletBalanceFetchUI.this);
                AppMethodBeat.o(68586);
            }
        });
        AppMethodBeat.o(68625);
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(68626);
        fNi();
        bf(intent);
        super.onNewIntent(intent);
        AppMethodBeat.o(68626);
    }

    private void bf(Intent intent) {
        AppMethodBeat.i(68627);
        this.Hvs = bg(intent);
        if (this.Hvs) {
            Log.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card success");
            PayInfo payInfo = (PayInfo) getInput().get("key_pay_info");
            if (payInfo == null) {
                payInfo = new PayInfo();
                payInfo.dDL = this.dDL;
                payInfo.dVv = 21;
            }
            doSceneForceProgress(new aa(payInfo.dDL));
        }
        AppMethodBeat.o(68627);
    }

    private void fNj() {
        AppMethodBeat.i(68628);
        com.tencent.mm.plugin.wallet_core.model.g fQl = com.tencent.mm.plugin.wallet_core.model.g.fQl();
        if (fQl.bJw()) {
            com.tencent.mm.ui.base.h.c(this, fQl.ANp, getString(R.string.zb), true);
            AppMethodBeat.o(68628);
            return;
        }
        Bundle bundle = new Bundle();
        PayInfo payInfo = (PayInfo) getInput().get("key_pay_info");
        if (payInfo == null) {
            payInfo = new PayInfo();
            payInfo.dDL = this.dDL;
            payInfo.dVv = 21;
        }
        if (payInfo != null) {
            bundle.putParcelable("key_pay_info", payInfo);
        }
        bundle.putInt("key_scene", 21);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.HsQ);
        bundle.putBoolean("key_bind_show_change_card", true);
        if (h(this, bundle)) {
            AppMethodBeat.o(68628);
            return;
        }
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.a.class, bundle, (d.a) null);
        AppMethodBeat.o(68628);
    }

    private static boolean bg(Intent intent) {
        AppMethodBeat.i(68629);
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            AppMethodBeat.o(68629);
            return false;
        }
        AppMethodBeat.o(68629);
        return true;
    }

    private void fNk() {
        AppMethodBeat.i(68630);
        if (this.Hvm != 0) {
            Log.i("MicroMsg.WalletBalanceFetchUI", "showRemainFeeTip is_show_charge =" + this.Hvm);
            AppMethodBeat.o(68630);
            return;
        }
        com.tencent.mm.kernel.g.aAi();
        boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_FETCH_CHARGE_TIP_DIALOG_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        s.fOg();
        com.tencent.mm.plugin.wallet_core.model.b bVar = s.fOh().IbO;
        if (bVar != null && !booleanValue) {
            com.tencent.mm.ui.base.h.a(this, getString(R.string.ino, new Object[]{f.D(bVar.Cpd)}), getString(R.string.inp), getString(R.string.idg), getString(R.string.inq), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(213879);
                    dialogInterface.dismiss();
                    h.INSTANCE.a(16398, WalletBalanceFetchUI.this.lem, 4, "", "");
                    AppMethodBeat.o(213879);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass13 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(213880);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", WalletBalanceFetchUI.this.getString(R.string.icm));
                    intent.putExtra("showShare", false);
                    f.aA(WalletBalanceFetchUI.this.getContext(), intent);
                    dialogInterface.dismiss();
                    h.INSTANCE.a(16398, WalletBalanceFetchUI.this.lem, 3, "", "");
                    AppMethodBeat.o(213880);
                }
            }, (int) R.color.afp);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_FETCH_CHARGE_TIP_DIALOG_BOOLEAN_SYNC, Boolean.TRUE);
        }
        AppMethodBeat.o(68630);
    }

    private boolean h(Context context, Bundle bundle) {
        AppMethodBeat.i(68631);
        com.tencent.mm.wallet_core.b.hgC();
        if (com.tencent.mm.wallet_core.b.b(b.a.clicfg_open_kinda_bind_card, true)) {
            EventCenter.instance.add(this.AJa);
            Log.d("MicroMsg.WalletBalanceFetchUI", "startKindaBindCard:true");
            ab.mg(6, bundle.getInt("key_bind_scene"));
            z.aqh(bundle.getInt("key_bind_scene"));
            ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(context, bundle);
            AppMethodBeat.o(68631);
            return true;
        }
        Log.d("MicroMsg.WalletBalanceFetchUI", "startKindaBindCard:false");
        AppMethodBeat.o(68631);
        return false;
    }

    private static boolean eNx() {
        AppMethodBeat.i(174433);
        com.tencent.mm.wallet_core.b.hgC();
        boolean b2 = com.tencent.mm.wallet_core.b.b(b.a.clicfg_kinda_open, true);
        com.tencent.mm.wallet_core.b.hgC();
        boolean b3 = com.tencent.mm.wallet_core.b.b(b.a.clicfg_open_kinda_wallet_balance_fetch, false);
        if (!b2 || !b3) {
            AppMethodBeat.o(174433);
            return false;
        }
        AppMethodBeat.o(174433);
        return true;
    }

    private void a(double d2, String str, String str2, String str3, int i2) {
        AppMethodBeat.i(174434);
        Bundle bundle = new Bundle();
        bundle.putInt("payScene", 21);
        bundle.putString("totalFee", f.c(String.valueOf(d2), "100", 0, RoundingMode.HALF_UP).toString());
        bundle.putString("feeType", str);
        bundle.putString("bankType", str2);
        bundle.putString("bindSerial", str3);
        bundle.putString("operation", String.valueOf(i2));
        bundle.putString("reportSessionId", this.lem);
        Log.i("MicroMsg.WalletBalanceFetchUI", "startWalletBalanceFetchUseCase totalFee：%s reportSessionId %s", f.c(String.valueOf(d2), "100", 0, RoundingMode.HALF_UP).toString(), this.lem);
        ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startWalletBalanceFetchUseCase(this, bundle);
        AppMethodBeat.o(174434);
    }

    @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.a
    public final void onInputValidChange(boolean z) {
        AppMethodBeat.i(68621);
        this.Hvd.hK(null);
        AppMethodBeat.o(68621);
    }

    static /* synthetic */ void a(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.i(68632);
        Log.i("MicroMsg.WalletBalanceFetchUI", "do get free fee");
        if (walletBalanceFetchUI.Hvb != null) {
            if (walletBalanceFetchUI.Hvv != null) {
                Log.i("MicroMsg.WalletBalanceFetchUI", "cancel prev cgi");
                walletBalanceFetchUI.Hvv.cancel();
            }
            walletBalanceFetchUI.Hvv = new com.tencent.mm.plugin.wallet.balance.model.b(f.nF(new StringBuilder().append(walletBalanceFetchUI.jVp).toString(), "100"), walletBalanceFetchUI.Hvb.field_bankcardType, walletBalanceFetchUI.Hvb.field_bindSerial);
            walletBalanceFetchUI.Hvv.aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<vz>>() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.AnonymousClass10 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(c.a<vz> aVar) {
                    int i2 = 0;
                    AppMethodBeat.i(213878);
                    c.a<vz> aVar2 = aVar;
                    Log.i("MicroMsg.WalletBalanceFetchUI", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode), aVar2.errMsg);
                    WalletBalanceFetchUI.this.Hvv = null;
                    if (aVar2.errType == 0 && aVar2.errCode == 0) {
                        WalletBalanceFetchUI.this.Hvl.removeAllViews();
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        if (((vz) aVar2.iLC).Lhi != null && !((vz) aVar2.iLC).Lhi.isEmpty()) {
                            Iterator<ehf> it = ((vz) aVar2.iLC).Lhi.iterator();
                            while (it.hasNext()) {
                                TextView textView = new TextView(WalletBalanceFetchUI.this.getContext());
                                com.tencent.mm.plugin.wallet_core.utils.g.a(textView, it.next(), (g.a) null);
                                if (i2 != 0) {
                                    layoutParams.topMargin = com.tencent.mm.cb.a.aG(WalletBalanceFetchUI.this.getContext(), R.dimen.f3062g);
                                }
                                WalletBalanceFetchUI.this.Hvl.addView(textView, layoutParams);
                                i2++;
                            }
                        }
                    }
                    AppMethodBeat.o(213878);
                    return null;
                }
            });
        }
        AppMethodBeat.o(68632);
    }

    static /* synthetic */ void h(WalletBalanceFetchUI walletBalanceFetchUI) {
        String str;
        String str2;
        AppMethodBeat.i(68637);
        walletBalanceFetchUI.jVp = Util.getDouble(walletBalanceFetchUI.Hvd.getText(), 0.0d);
        String str3 = "";
        String str4 = "";
        if (walletBalanceFetchUI.Hvb != null) {
            str3 = walletBalanceFetchUI.Hvb.field_bankcardType;
            str4 = walletBalanceFetchUI.Hvb.field_bindSerial;
        } else {
            com.tencent.mm.plugin.wallet_core.model.g fQl = com.tencent.mm.plugin.wallet_core.model.g.fQl();
            if (fQl.bJw()) {
                com.tencent.mm.ui.base.h.c(walletBalanceFetchUI, fQl.ANp, walletBalanceFetchUI.getString(R.string.zb), true);
                AppMethodBeat.o(68637);
                return;
            }
        }
        if (walletBalanceFetchUI.Hvb != null && !Util.isNullOrNil(walletBalanceFetchUI.Hvb.field_forbidWord)) {
            com.tencent.mm.ui.base.u.makeText(walletBalanceFetchUI.getContext(), walletBalanceFetchUI.Hvb.field_forbidWord, 0).show();
        } else if (walletBalanceFetchUI.jVp <= 0.0d || !walletBalanceFetchUI.Hvd.bql()) {
            com.tencent.mm.ui.base.u.makeText(walletBalanceFetchUI.getContext(), (int) R.string.i7f, 0).show();
        } else {
            double d2 = walletBalanceFetchUI.jVp;
            s.fOg();
            if (d2 > s.fOh().Hwc.HVC) {
                com.tencent.mm.ui.base.u.makeText(walletBalanceFetchUI.getContext(), (int) R.string.i6c, 0).show();
            } else {
                double d3 = walletBalanceFetchUI.jVp;
                s.fOg();
                if (d3 > s.fOh().Hwc.HVE) {
                    com.tencent.mm.ui.base.u.makeText(walletBalanceFetchUI.getContext(), (int) R.string.i6d, 0).show();
                } else {
                    if (eNx()) {
                        walletBalanceFetchUI.a(walletBalanceFetchUI.jVp, "1", str3, str4, walletBalanceFetchUI.Hvq);
                    } else {
                        walletBalanceFetchUI.doSceneProgress(new com.tencent.mm.plugin.wallet.balance.model.d(walletBalanceFetchUI.jVp, "CNY", str3, walletBalanceFetchUI.Hvq));
                    }
                    walletBalanceFetchUI.hideWcKb();
                }
            }
        }
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[4];
        objArr[0] = walletBalanceFetchUI.lem;
        objArr[1] = 7;
        if (walletBalanceFetchUI.Hvb != null) {
            str = walletBalanceFetchUI.Hvb.field_bankcardType;
        } else {
            str = "";
        }
        objArr[2] = str;
        if (walletBalanceFetchUI.Hvb != null) {
            str2 = walletBalanceFetchUI.Hvb.field_bindSerial;
        } else {
            str2 = "";
        }
        objArr[3] = str2;
        hVar.a(16398, objArr);
        AppMethodBeat.o(68637);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void i(com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI r9) {
        /*
        // Method dump skipped, instructions count: 242
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.i(com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI):void");
    }
}
