package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.e;
import com.tencent.mm.plugin.wallet.balance.model.lqt.w;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.c.ag;
import com.tencent.mm.plugin.wallet_core.c.ak;
import com.tencent.mm.plugin.wallet_core.c.al;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@a(2)
public class WalletBalanceSaveUI extends WalletBaseUI implements WcPayKeyboard.a {
    private com.tencent.mm.plugin.wallet.ui.a ALJ;
    private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 270);
    protected boolean HvA = false;
    private Runnable HvB = new Runnable() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass15 */

        public final void run() {
            AppMethodBeat.i(213923);
            WalletBalanceSaveUI.this.showNormalStWcKb();
            AppMethodBeat.o(213923);
        }
    };
    private ArrayList<Bankcard> Hva;
    protected Bankcard Hvb;
    private String Hvc;
    protected LinearLayout Hve;
    private TextView HwA;
    private al HwB;
    private boolean HwC = false;
    private LinearLayout Hwy;
    private TextView Hwz;
    protected double jVp;
    public Runnable jVx = new Runnable() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass14 */

        public final void run() {
            AppMethodBeat.i(213922);
            if (WalletBalanceSaveUI.this.state == 2 && WalletBalanceSaveUI.this.isHandleAutoShowNormalStWcKb()) {
                WalletBalanceSaveUI.this.showNormalStWcKb();
            }
            AppMethodBeat.o(213922);
        }
    };
    private ViewGroup nmW;
    protected WalletFormView qAh;
    private int state = 0;
    private HashMap<String, Integer> yNN = new HashMap<>();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBalanceSaveUI() {
        AppMethodBeat.i(68709);
        AppMethodBeat.o(68709);
    }

    static /* synthetic */ void f(WalletBalanceSaveUI walletBalanceSaveUI) {
        AppMethodBeat.i(68725);
        walletBalanceSaveUI.fNd();
        AppMethodBeat.o(68725);
    }

    static /* synthetic */ void fNu() {
    }

    static /* synthetic */ void k(WalletBalanceSaveUI walletBalanceSaveUI) {
        AppMethodBeat.i(213931);
        walletBalanceSaveUI.updateView();
        AppMethodBeat.o(213931);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        String str2;
        AppMethodBeat.i(68710);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof e) {
                e eVar = (e) qVar;
                if ("1".equals(eVar.egd)) {
                    Log.i("MicroMsg.WalletBalanceSaveUI", "need realname verify");
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceSaveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    isTransparent();
                    z = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, null, 0);
                } else if ("2".equals(eVar.egd)) {
                    Log.i("MicroMsg.WalletBalanceSaveUI", "need upload credit");
                    z = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, eVar.ege, eVar.egh, eVar.egf, eVar.egg, isTransparent(), (DialogInterface.OnClickListener) null);
                } else {
                    Log.i("MicroMsg.WalletBalanceSaveUI", "realnameGuideFlag =  " + eVar.egd);
                    z = false;
                }
                if (z) {
                    AppMethodBeat.o(68710);
                } else {
                    String str3 = ((e) qVar).dNQ;
                    af.z(11, str3, i3);
                    if (this.Hvb == null) {
                        str2 = "";
                    } else {
                        str2 = this.Hvb.field_bindSerial;
                    }
                    f.b(this, str2, str3, "", 11, 1);
                }
            } else if (qVar instanceof ag) {
                ag agVar = (ag) qVar;
                if (!this.HwC) {
                    fetchData();
                    updateView();
                }
                this.HwC = false;
                this.HwB = agVar.HwB;
                fNs();
            }
            AppMethodBeat.o(68710);
        } else {
            if (qVar instanceof e) {
                af.z(11, "", i3);
                MMHandlerThread.postToMainThreadDelayed(this.jVx, 300);
            }
            AppMethodBeat.o(68710);
        }
        return false;
    }

    private void fNs() {
        AppMethodBeat.i(68711);
        if (this.HwB == null) {
            this.Hwy.setVisibility(8);
            AppMethodBeat.o(68711);
            return;
        }
        this.Hwy.setVisibility(0);
        this.Hwz.setText(this.HwB.title);
        this.HwA.setText(this.HwB.oqZ);
        this.Hwy.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(68693);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.WalletBalanceSaveUI", "click lqt entrance: %s", Boolean.valueOf(WalletBalanceSaveUI.this.HwB.HQD));
                h.INSTANCE.a(17084, 5);
                if (WalletBalanceSaveUI.this.HwB.HQD) {
                    WalletBalanceSaveUI.this.hideWcKb();
                    WalletBalanceSaveUI.b(WalletBalanceSaveUI.this);
                } else {
                    WalletBalanceSaveUI.c(WalletBalanceSaveUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68693);
            }
        });
        AppMethodBeat.o(68711);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(68712);
        super.onResume();
        if (this.HwC) {
            fNn();
        }
        if (this.state == 3 && isHandleAutoShowNormalStWcKb()) {
            MMHandlerThread.postToMainThreadDelayed(this.HvB, 300);
        }
        this.state = 2;
        fNd();
        AppMethodBeat.o(68712);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(213925);
        super.onPause();
        if (!this.mWcKeyboard.hgQ()) {
            this.state = 3;
        }
        AppMethodBeat.o(213925);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(213926);
        super.onDestroy();
        MMHandlerThread.removeRunnable(this.jVx);
        MMHandlerThread.removeRunnable(this.HvB);
        AppMethodBeat.o(213926);
    }

    @Override // com.tencent.mm.ui.widget.a.c, com.tencent.mm.ui.MMActivity
    public void onDialogDismiss(Dialog dialog) {
        AppMethodBeat.i(213927);
        Log.i("MicroMsg.WalletBalanceSaveUI", "onDialogDismiss()");
        MMHandlerThread.postToMainThreadDelayed(this.jVx, 300);
        AppMethodBeat.o(213927);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isHandleAutoShowNormalStWcKb() {
        AppMethodBeat.i(213928);
        Log.d("MicroMsg.WalletBalanceSaveUI", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", Boolean.valueOf(this.HvA), Boolean.valueOf(this.mWcKeyboard.hgR()));
        if (this.HvA || !this.mWcKeyboard.hgR()) {
            AppMethodBeat.o(213928);
            return false;
        }
        AppMethodBeat.o(213928);
        return true;
    }

    private void fetchData() {
        AppMethodBeat.i(68713);
        s.fOg();
        an fOh = s.fOh();
        this.Hva = fOh.fRG();
        this.Hvb = fOh.a(this.Hva, null, false, true);
        if (this.Hvb != null && Util.isNullOrNil(this.Hvb.field_forbidWord)) {
            this.Hvb = null;
            int i2 = 0;
            while (true) {
                if (i2 >= this.Hva.size()) {
                    break;
                }
                if (this.Hva.get(i2) != null && Util.isNullOrNil(this.Hva.get(i2).field_forbidWord)) {
                    this.Hvb = this.Hva.get(i2);
                    break;
                }
                i2++;
            }
        }
        if (this.Hvb != null && !Util.isNullOrNil(this.Hvb.field_forbidWord)) {
            this.Hvb = null;
        }
        ArrayList<Bankcard> arrayList = this.Hva;
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Log.v("MicroMsg.WalletBalanceSaveUI", "pos %s word %s", Integer.valueOf(i3), arrayList.get(i3).field_forbidWord);
            }
        }
        AppMethodBeat.o(68713);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c7s;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68714);
        super.onCreate(bundle);
        if (!z.aUo()) {
            fNn();
        }
        setActionbarColor(getResources().getColor(R.color.BW_BG_95));
        hideActionbarLine();
        fetchData();
        this.Hvc = getString(R.string.i7a);
        initView();
        String str = (String) ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.USERINFO_BALANCE_LQT_OPERATION_STRING_SYNC, "");
        if (!Util.isNullOrNil(str)) {
            try {
                this.HwB = al.bx(new JSONObject(str));
                fNs();
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.WalletBalanceSaveUI", e2, "", new Object[0]);
            }
        }
        updateView();
        ab.mg(3, 0);
        AppMethodBeat.o(68714);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(68715);
        setMMTitle(R.string.i7h);
        this.nmW = (ViewGroup) findViewById(R.id.h_e);
        this.qAh = (WalletFormView) findViewById(R.id.fjf);
        this.Hwy = (LinearLayout) findViewById(R.id.ewe);
        this.Hwz = (TextView) findViewById(R.id.ewf);
        this.HwA = (TextView) findViewById(R.id.ewd);
        this.mWcKeyboard = new WcPayKeyboard(this);
        com.tencent.mm.wallet_core.ui.formview.a.f(this.qAh);
        this.qAh.getTitleTv().setText(ah.hhz());
        this.mWcKeyboard.s(this);
        setWPKeyboard(this.qAh.getContentEt(), true, false);
        this.mWcKeyboard.setActionText(getString(R.string.i6s));
        this.qAh.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass16 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(213924);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    WalletFormView.a(WalletBalanceSaveUI.this.qAh.getContentEt(), obj, indexOf + 3, length);
                } else if (indexOf > 10) {
                    WalletFormView.a(WalletBalanceSaveUI.this.qAh.getContentEt(), obj, 10, indexOf);
                } else if (indexOf == -1 && length > 10) {
                    WalletFormView.a(WalletBalanceSaveUI.this.qAh.getContentEt(), obj, 10, length);
                }
                WalletBalanceSaveUI.f(WalletBalanceSaveUI.this);
                AppMethodBeat.o(213924);
            }
        });
        final AnonymousClass17 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass17 */

            public final void onClick(View view) {
                AppMethodBeat.i(68708);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletBalanceSaveUI.this.jVp = Util.getDouble(WalletBalanceSaveUI.this.qAh.getText(), 0.0d);
                if (WalletBalanceSaveUI.this.jVp <= 0.0d || !WalletBalanceSaveUI.this.qAh.bql()) {
                    u.makeText(WalletBalanceSaveUI.this.getContext(), (int) R.string.i7f, 0).show();
                } else {
                    WalletBalanceSaveUI.this.hideWcKb();
                    WalletBalanceSaveUI.this.fNt();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68708);
            }
        };
        this.qAh.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass2 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(213911);
                if (keyEvent != null && keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 66) {
                    r0.onClick(null);
                }
                AppMethodBeat.o(213911);
                return true;
            }
        });
        this.Hve = (LinearLayout) findViewById(R.id.zr);
        if (this.Hve != null) {
            com.tencent.mm.wallet_core.ui.f.G((TextView) this.Hve.findViewById(R.id.zs));
            this.Hve.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(213912);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    WalletBalanceSaveUI.g(WalletBalanceSaveUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213912);
                }
            });
        }
        setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass4 */

            @Override // com.tencent.mm.wallet_core.ui.a
            public final void onVisibleStateChange(boolean z) {
                AppMethodBeat.i(213913);
                if (z) {
                    WalletBalanceSaveUI.fNu();
                    AppMethodBeat.o(213913);
                    return;
                }
                WalletBalanceSaveUI.this.nmW.scrollTo(0, 0);
                AppMethodBeat.o(213913);
            }
        });
        AppMethodBeat.o(68715);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(68716);
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(68716);
    }

    private void fNd() {
        AppMethodBeat.i(213929);
        if (Util.getDouble(this.qAh.getText(), 0.0d) <= 0.0d || !this.qAh.bql()) {
            this.mWcKeyboard.DH(false);
            AppMethodBeat.o(213929);
            return;
        }
        this.mWcKeyboard.DH(true);
        AppMethodBeat.o(213929);
    }

    private void updateView() {
        AppMethodBeat.i(68717);
        if (this.Hve != null) {
            if (this.Hvb != null) {
                final ImageView imageView = (ImageView) this.Hve.findViewById(R.id.a1s);
                String str = "";
                com.tencent.mm.plugin.wallet_core.model.e j2 = com.tencent.mm.plugin.wallet_core.d.b.j(this, this.Hvb.field_bankcardType, this.Hvb.fQa());
                if (j2 != null) {
                    str = j2.AAU;
                }
                imageView.setImageBitmap(null);
                if (this.Hvb.fQb()) {
                    imageView.setBackgroundResource(R.drawable.cqo);
                } else {
                    Bitmap a2 = com.tencent.mm.platformtools.u.a(new c(str));
                    com.tencent.mm.platformtools.u.a(new u.a() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass9 */

                        @Override // com.tencent.mm.platformtools.u.a
                        public final void k(String str, final Bitmap bitmap) {
                            AppMethodBeat.i(213921);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass9.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(213920);
                                    if (!(WalletBalanceSaveUI.this.Hvb == null || imageView == null || imageView.getTag() == null || !imageView.getTag().equals(WalletBalanceSaveUI.this.Hvb.field_bindSerial))) {
                                        imageView.setImageBitmap(bitmap);
                                    }
                                    AppMethodBeat.o(213920);
                                }
                            });
                            AppMethodBeat.o(213921);
                        }
                    });
                    if (!(a2 == null || a2 == null)) {
                        imageView.setImageBitmap(BitmapUtil.extractThumbNail(a2, getResources().getDimensionPixelOffset(R.dimen.aov), getResources().getDimensionPixelOffset(R.dimen.aov), true, false));
                    }
                }
                ((TextView) this.Hve.findViewById(R.id.zs)).setText(getString(R.string.i79, new Object[]{this.Hvb.field_bankName, this.Hvb.field_bankcardTail}));
                if (!Util.isNullOrNil(this.Hvb.field_avail_save_wording)) {
                    ((TextView) this.Hve.findViewById(R.id.dpd)).setText(this.Hvb.field_avail_save_wording);
                    ((TextView) this.Hve.findViewById(R.id.dpd)).setVisibility(0);
                } else {
                    Log.i("MicroMsg.WalletBalanceSaveUI", "hy: wording's missing. use default");
                    ((TextView) this.Hve.findViewById(R.id.dpd)).setText("");
                }
            } else {
                ((TextView) this.Hve.findViewById(R.id.zs)).setText(this.Hvc);
                ((TextView) this.Hve.findViewById(R.id.dpd)).setText("");
                ((ImageView) this.Hve.findViewById(R.id.a1s)).setImageBitmap(null);
            }
            ((TextView) this.Hve.findViewById(R.id.jia)).setText(R.string.i78);
        }
        AppMethodBeat.o(68717);
    }

    /* access modifiers changed from: protected */
    public void fNt() {
        AppMethodBeat.i(68718);
        if (this.Hvb != null) {
            doSceneProgress(new e(this.jVp, "CNY", this.Hvb.field_bindSerial, this.Hvb.field_bankcardType));
            AppMethodBeat.o(68718);
            return;
        }
        com.tencent.mm.plugin.wallet_core.model.g fQl = com.tencent.mm.plugin.wallet_core.model.g.fQl();
        if (fQl.bJw()) {
            com.tencent.mm.ui.base.h.c(this, fQl.ANp, getString(R.string.zb), true);
            AppMethodBeat.o(68718);
            return;
        }
        doSceneProgress(new e(this.jVp, "CNY", "", ""));
        AppMethodBeat.o(68718);
    }

    private void fNn() {
        AppMethodBeat.i(68719);
        doSceneProgress(new ag(), false);
        AppMethodBeat.o(68719);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a
    public final void bO(float f2) {
        AppMethodBeat.i(68720);
        if (this.nmW != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nmW.getLayoutParams();
            layoutParams.bottomMargin = (int) f2;
            Log.d("MicroMsg.WalletBalanceSaveUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", Float.valueOf(f2), Integer.valueOf(layoutParams.height));
            this.nmW.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(68720);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(68721);
        if (this.mWcKeyboard == null || !this.mWcKeyboard.onKeyUp(i2, keyEvent)) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(68721);
            return onKeyUp;
        }
        AppMethodBeat.o(68721);
        return true;
    }

    static /* synthetic */ void b(WalletBalanceSaveUI walletBalanceSaveUI) {
        AppMethodBeat.i(68722);
        final w wVar = (w) new com.tencent.mm.vending.app.c().a(walletBalanceSaveUI, w.class);
        final Dialog c2 = com.tencent.mm.wallet_core.ui.h.c(walletBalanceSaveUI, false, null);
        if (wVar == null || wVar.HtU == null) {
            Log.i("MicroMsg.WalletBalanceSaveUI", "fetchDetail() interactorGlueApi == null || interactorGlueApi.fetchLqtDetail == null");
            AppMethodBeat.o(68722);
            return;
        }
        wVar.HtU.bmq().f(new com.tencent.mm.vending.c.a<Void, dhn>() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass11 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(dhn dhn) {
                boolean z = true;
                AppMethodBeat.i(68702);
                dhn dhn2 = dhn;
                if (dhn2 != null) {
                    Log.i("MicroMsg.WalletBalanceSaveUI", "fetch detail success, account_type: %s, is_hide_close_account_btn: %s", Integer.valueOf(dhn2.yba), Boolean.valueOf(dhn2.MMe));
                    wVar.HtX.jP(dhn2.yba, 8);
                    Log.i("MicroMsg.WalletBalanceSaveUI", "goWalletLqtSaveFetchUI()");
                    if (c2 != null) {
                        c2.dismiss();
                    }
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (dhn2.MLV != null && dhn2.MLV.size() > 0) {
                        Iterator<ahq> it = dhn2.MLV.iterator();
                        while (it.hasNext()) {
                            ahq next = it.next();
                            if (!Util.isNullOrNil(next.title) && !Util.isNullOrNil(next.yUB)) {
                                arrayList.add(String.format("%s||%s", next.title, next.yUB));
                            }
                        }
                    }
                    Intent intent = new Intent(WalletBalanceSaveUI.this.getContext(), WalletLqtSaveFetchUI.class);
                    intent.putExtra("lqt_save_fund_code", dhn2.Mnl);
                    intent.putExtra("lqt_account_type", dhn2.yba);
                    intent.putExtra("lqt_fund_spid", dhn2.Mnk);
                    intent.putExtra("lqt_save_fetch_mode", 1);
                    intent.putExtra("lqt_is_show_protocol", dhn2.egj == 1);
                    if (dhn2.MLU != 1) {
                        z = false;
                    }
                    intent.putExtra("lqt_is_agree_protocol", z);
                    intent.putExtra("operate_id", WalletBalanceSaveUI.this.HwB.HQF);
                    intent.putStringArrayListExtra("lqt_protocol_list", arrayList);
                    intent.putExtra("lqt_profile_wording", dhn2.MLJ);
                    intent.putExtra("entrance_type", 8);
                    intent.putExtra("fill_money", WalletBalanceSaveUI.this.qAh.getText());
                    if (WalletBalanceSaveUI.this.Hvb != null) {
                        intent.putExtra("card_serial", WalletBalanceSaveUI.this.Hvb.field_bindSerial);
                    }
                    WalletBalanceSaveUI.this.startActivityForResult(intent, 3);
                } else {
                    Log.i("MicroMsg.WalletBalanceSaveUI", "fetch detail failed");
                }
                Void r0 = QZL;
                AppMethodBeat.o(68702);
                return r0;
            }
        }).a(new d.a() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass10 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                String string;
                AppMethodBeat.i(68701);
                if (c2 != null) {
                    c2.dismiss();
                }
                Log.i("MicroMsg.WalletBalanceSaveUI", "fetch detail failed: %s", obj);
                if (obj != null) {
                    if (obj instanceof String) {
                        string = obj.toString();
                    } else {
                        string = WalletBalanceSaveUI.this.getString(R.string.ih4);
                    }
                    Toast.makeText(WalletBalanceSaveUI.this.getContext(), string, 1).show();
                }
                AppMethodBeat.o(68701);
            }
        });
        AppMethodBeat.o(68722);
    }

    static /* synthetic */ void c(WalletBalanceSaveUI walletBalanceSaveUI) {
        AppMethodBeat.i(68723);
        if (walletBalanceSaveUI.HwB.HQE != null) {
            h.INSTANCE.a(17084, 6);
            final ak akVar = walletBalanceSaveUI.HwB.HQE;
            Log.i("MicroMsg.WalletBalanceSaveUI", "show open lqt alert");
            d.a aVar = new d.a(walletBalanceSaveUI.getContext());
            aVar.boo(akVar.HQB);
            aVar.aoW(R.string.iim);
            aVar.aoV(R.string.ih2);
            aVar.a(true, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass12 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(68703);
                    Log.i("MicroMsg.WalletBalanceSaveUI", "click open lqt: %s", Integer.valueOf(akVar.lHz));
                    h.INSTANCE.a(17084, 8);
                    if (akVar.lHz == 2) {
                        WalletBalanceSaveUI.this.HwC = true;
                        com.tencent.mm.wallet_core.ui.f.p(WalletBalanceSaveUI.this.getContext(), akVar.HQC, true);
                        AppMethodBeat.o(68703);
                        return;
                    }
                    if (akVar.lHz == 3) {
                        WalletBalanceSaveUI.this.HwC = true;
                        com.tencent.mm.wallet_core.ui.f.u(akVar.ixZ, akVar.HQC, 0, 1000);
                    }
                    AppMethodBeat.o(68703);
                }
            });
            aVar.d(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass13 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(68704);
                    h.INSTANCE.a(17084, 7);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(68704);
                }
            });
            aVar.hbn().show();
        }
        AppMethodBeat.o(68723);
    }

    static /* synthetic */ void g(WalletBalanceSaveUI walletBalanceSaveUI) {
        AppMethodBeat.i(213930);
        walletBalanceSaveUI.yNN.clear();
        if (walletBalanceSaveUI.ALJ == null || !walletBalanceSaveUI.ALJ.qAx.isShowing()) {
            walletBalanceSaveUI.ALJ = new com.tencent.mm.plugin.wallet.ui.a(walletBalanceSaveUI);
            final List linkedList = walletBalanceSaveUI.Hva == null ? new LinkedList() : walletBalanceSaveUI.Hva;
            int size = linkedList.size();
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                Bankcard bankcard = linkedList.get(i2);
                if (walletBalanceSaveUI.Hvb != null && !Util.isNullOrNil(bankcard.field_bindSerial) && walletBalanceSaveUI.Hvb.field_bindSerial.equals(bankcard.field_bindSerial)) {
                    size = i2;
                }
            }
            int i3 = walletBalanceSaveUI.Hvb == null ? -1 : size;
            walletBalanceSaveUI.ALJ.HLX = new o.f() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass5 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(final m mVar) {
                    final String str;
                    SpannableString spannableString;
                    String str2;
                    AppMethodBeat.i(213916);
                    int size = linkedList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        Bankcard bankcard = (Bankcard) linkedList.get(i2);
                        com.tencent.mm.plugin.wallet_core.model.e j2 = com.tencent.mm.plugin.wallet_core.d.b.j(WalletBalanceSaveUI.this, bankcard.field_bankcardType, bankcard.fQa());
                        if (j2 != null) {
                            str = j2.AAU;
                        } else {
                            str = "";
                        }
                        Bitmap a2 = com.tencent.mm.platformtools.u.a(new c(str));
                        com.tencent.mm.platformtools.u.a(new u.a() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass5.AnonymousClass1 */

                            @Override // com.tencent.mm.platformtools.u.a
                            public final void k(final String str, final Bitmap bitmap) {
                                AppMethodBeat.i(213915);
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(213914);
                                        Log.i("MicroMsg.WalletBalanceSaveUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", str, str);
                                        if (WalletBalanceSaveUI.this.yNN.containsKey(str)) {
                                            int intValue = ((Integer) WalletBalanceSaveUI.this.yNN.get(str)).intValue();
                                            if (mVar.getItem(intValue) != null) {
                                                mVar.getItem(intValue).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(bitmap, WalletBalanceSaveUI.this.getResources().getDimensionPixelOffset(R.dimen.aov), WalletBalanceSaveUI.this.getResources().getDimensionPixelOffset(R.dimen.aov), true, false)));
                                                WalletBalanceSaveUI.this.ALJ.fPw();
                                            }
                                        }
                                        AppMethodBeat.o(213914);
                                    }
                                });
                                AppMethodBeat.o(213915);
                            }
                        });
                        Bitmap bitmap = null;
                        String str3 = "";
                        if (!Util.isNullOrNil(bankcard.field_forbidWord)) {
                            str3 = bankcard.field_forbidWord;
                        }
                        if (Util.isNullOrNil(bankcard.field_forbid_title)) {
                            spannableString = new SpannableString(str3);
                            str2 = str3;
                        } else {
                            String str4 = str3 + " ";
                            spannableString = new SpannableString(str4 + bankcard.field_forbid_title);
                            AnonymousClass2 r5 = new l(WalletBalanceSaveUI.this) {
                                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass5.AnonymousClass2 */

                                @Override // com.tencent.mm.plugin.wallet_core.ui.l
                                public final void onClick(View view) {
                                }
                            };
                            int length = str4.length();
                            int length2 = str4.length() + bankcard.field_forbid_title.length();
                            spannableString.setSpan(new ForegroundColorSpan(WalletBalanceSaveUI.this.getResources().getColor(R.color.ael)), length, length2, 33);
                            spannableString.setSpan(r5, length, length2, 33);
                            str2 = str4;
                        }
                        CharSequence charSequence = bankcard.field_desc;
                        if (bankcard.fQb()) {
                            Log.i("MicroMsg.WalletBalanceSaveUI", "i %d fee %s %s", Integer.valueOf(i2), charSequence, spannableString);
                            mVar.a(i2, charSequence, spannableString, WalletBalanceSaveUI.this.getResources().getDrawable(R.drawable.cqo), !Util.isNullOrNil(str2));
                        } else {
                            if (a2 != null) {
                                bitmap = BitmapUtil.extractThumbNail(a2, WalletBalanceSaveUI.this.getResources().getDimensionPixelOffset(R.dimen.aov), WalletBalanceSaveUI.this.getResources().getDimensionPixelOffset(R.dimen.aov), true, false);
                            }
                            Log.i("MicroMsg.WalletBalanceSaveUI", "i %d fee %s %s", Integer.valueOf(i2), charSequence, spannableString);
                            mVar.a(i2, charSequence, spannableString, bitmap == null ? null : new BitmapDrawable(bitmap), 0, !Util.isNullOrNil(str2));
                        }
                        if (bitmap == null) {
                            WalletBalanceSaveUI.this.yNN.put(str, Integer.valueOf(i2));
                        }
                    }
                    AppMethodBeat.o(213916);
                }
            };
            m mVar = new m(walletBalanceSaveUI);
            mVar.a(0, walletBalanceSaveUI.getString(R.string.i7a), null, walletBalanceSaveUI.getResources().getDrawable(R.raw.icons_outlined_pay_cards), walletBalanceSaveUI.getResources().getColor(R.color.FG_2), false);
            walletBalanceSaveUI.ALJ.a(mVar, new o.g() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass6 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(213917);
                    if (WalletBalanceSaveUI.this.ALJ == null) {
                        AppMethodBeat.o(213917);
                        return;
                    }
                    WalletBalanceSaveUI.this.ALJ.qAx.bMo();
                    WalletBalanceSaveUI.this.Hvb = null;
                    WalletBalanceSaveUI.k(WalletBalanceSaveUI.this);
                    AppMethodBeat.o(213917);
                }
            });
            walletBalanceSaveUI.ALJ.a(new g.a() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass7 */

                @Override // com.tencent.mm.ui.widget.a.g.a
                public final void onClick() {
                    AppMethodBeat.i(213918);
                    if (WalletBalanceSaveUI.this.ALJ != null) {
                        WalletBalanceSaveUI.this.ALJ.qAx.bMo();
                        if (WalletBalanceSaveUI.this.ALJ.jKz < 0 || WalletBalanceSaveUI.this.ALJ.jKz >= linkedList.size()) {
                            WalletBalanceSaveUI.this.Hvb = null;
                            WalletBalanceSaveUI.k(WalletBalanceSaveUI.this);
                        } else {
                            WalletBalanceSaveUI.this.Hvb = (Bankcard) WalletBalanceSaveUI.this.Hva.get(WalletBalanceSaveUI.this.ALJ.jKz);
                            WalletBalanceSaveUI.k(WalletBalanceSaveUI.this);
                            AppMethodBeat.o(213918);
                            return;
                        }
                    }
                    AppMethodBeat.o(213918);
                }
            });
            View inflate = View.inflate(walletBalanceSaveUI, R.layout.b3b, null);
            TextView textView = (TextView) inflate.findViewById(R.id.exq);
            textView.setText(R.string.i5w);
            ao.a(textView.getPaint(), 0.8f);
            inflate.findViewById(R.id.boz).setVisibility(0);
            inflate.findViewById(R.id.ewv).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(213919);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (WalletBalanceSaveUI.this.ALJ != null) {
                        WalletBalanceSaveUI.this.ALJ.qAx.bMo();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceSaveUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213919);
                }
            });
            walletBalanceSaveUI.ALJ.setTitleView(inflate);
            walletBalanceSaveUI.ALJ.jKz = i3;
            walletBalanceSaveUI.ALJ.HMg = true;
            walletBalanceSaveUI.ALJ.HMf = true;
            walletBalanceSaveUI.ALJ.T(walletBalanceSaveUI.getResources().getString(R.string.ic6));
            walletBalanceSaveUI.ALJ.dGm();
            walletBalanceSaveUI.mWcKeyboard.hgN();
            AppMethodBeat.o(213930);
            return;
        }
        Log.i("MicroMsg.WalletBalanceSaveUI", "mmBottomSheet != null && mmBottomSheet.isShowing(),dont show bottomSheet");
        AppMethodBeat.o(213930);
    }
}
