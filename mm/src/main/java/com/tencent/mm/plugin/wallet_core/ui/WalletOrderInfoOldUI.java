package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.az;
import com.tencent.mm.g.a.ba;
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.zx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.af;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoOldUI extends WalletOrderInfoUI {
    protected String AJn;
    private IListener AMo = new IListener<zx>() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.AnonymousClass5 */

        {
            AppMethodBeat.i(160889);
            this.__eventId = zx.class.getName().hashCode();
            AppMethodBeat.o(160889);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zx zxVar) {
            AppMethodBeat.i(71047);
            zx zxVar2 = zxVar;
            if (zxVar2 instanceof zx) {
                if (!zxVar2.egC.egD.AKs) {
                    Log.i("MicroMsg.WalletOrderInfoOldUI", "block pass");
                    AppMethodBeat.o(71047);
                    return true;
                } else if ("1".equals(zxVar2.egC.egD.egd) || "2".equals(zxVar2.egC.egD.egd)) {
                    RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
                    realnameGuideHelper.b(zxVar2.egC.egD.egd, zxVar2.egC.egD.ege, zxVar2.egC.egD.egf, zxVar2.egC.egD.egg, zxVar2.egC.egD.egh, WalletOrderInfoOldUI.this.mPayInfo == null ? 0 : WalletOrderInfoOldUI.this.mPayInfo.dVv);
                    Log.i("MicroMsg.WalletOrderInfoOldUI", "receive guide");
                    WalletOrderInfoOldUI.this.getInput().putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
            }
            AppMethodBeat.o(71047);
            return false;
        }
    };
    protected String APz = null;
    private String Cvu;
    protected Orders HFH;
    protected boolean IdD = false;
    private HashMap<String, b> IdI = new HashMap<>();
    protected String IdJ;
    private IListener IhP = new IListener<ba>() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.AnonymousClass3 */

        {
            AppMethodBeat.i(160888);
            this.__eventId = ba.class.getName().hashCode();
            AppMethodBeat.o(160888);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ba baVar) {
            TextView textView;
            AppMethodBeat.i(71045);
            ba baVar2 = baVar;
            if (baVar2 instanceof ba) {
                WalletOrderInfoOldUI.this.Iij = baVar2.dEe.dEg;
                WalletOrderInfoOldUI.this.dEh = baVar2.dEe.dEh;
                WalletOrderInfoOldUI.this.dEi = baVar2.dEe.dEi;
                WalletOrderInfoOldUI.this.dEj = baVar2.dEe.dEj;
                if (WalletOrderInfoOldUI.this.dEj && !Util.isNullOrNil(WalletOrderInfoOldUI.this.IdJ)) {
                    for (int i2 = 0; i2 < WalletOrderInfoOldUI.this.Iho.size(); i2++) {
                        Orders.Commodity commodity = WalletOrderInfoOldUI.this.Iho.get(i2);
                        int i3 = -1;
                        for (int i4 = 0; i4 < commodity.HZN.size(); i4++) {
                            Orders.Promotions promotions = commodity.HZN.get(i4);
                            if (promotions.type == Orders.HZD && !Util.isNullOrNil(promotions.url) && promotions.url.equals(WalletOrderInfoOldUI.this.IdJ)) {
                                i3 = i4;
                            }
                        }
                        if (i3 >= 0) {
                            commodity.HZN.remove(i3);
                        }
                    }
                }
                WalletOrderInfoOldUI.this.Iii.notifyDataSetChanged();
                if (!Util.isNullOrNil(WalletOrderInfoOldUI.this.IdJ) && (textView = WalletOrderInfoOldUI.this.Iik.get(WalletOrderInfoOldUI.this.IdJ)) != null) {
                    textView.setClickable(WalletOrderInfoOldUI.this.dEh);
                    textView.setEnabled(WalletOrderInfoOldUI.this.dEh);
                    textView.setOnClickListener(null);
                    if (WalletOrderInfoOldUI.this.dEi) {
                        textView.setVisibility(8);
                    }
                }
                baVar2.dEf.result = true;
            }
            AppMethodBeat.o(71045);
            return false;
        }
    };
    protected Set<String> Ihn = null;
    protected List<Orders.Commodity> Iho = null;
    protected LinearLayout Iif = null;
    protected TextView Iig = null;
    protected TextView Iih = null;
    protected a Iii = null;
    protected String Iij = null;
    protected HashMap<String, TextView> Iik = new HashMap<>();
    protected c Iil;
    protected Map<Long, String> Iim = new HashMap();
    private d Iin;
    private boolean Iio = false;
    protected ay.b.a Iip = new ay.b.a() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.AnonymousClass6 */

        @Override // com.tencent.mm.model.ay.b.a
        public final void p(String str, boolean z) {
            AppMethodBeat.i(71048);
            as Kn = ((l) g.af(l.class)).aSN().Kn(str);
            Log.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer " + str + " succ: " + z);
            WalletOrderInfoOldUI.this.ai(Kn);
            AppMethodBeat.o(71048);
        }
    };
    private View.OnLongClickListener Iiq = new View.OnLongClickListener() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.AnonymousClass11 */

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(71053);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            if (view.getId() == R.id.jgo || view.getId() == R.id.jhf) {
                try {
                    String str = (String) view.getTag();
                    Toast.makeText(WalletOrderInfoOldUI.this, (int) R.string.ijl, 0).show();
                    ClipboardHelper.setText(WalletOrderInfoOldUI.this.getContext(), str, str);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.WalletOrderInfoOldUI", e2, "", new Object[0]);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(71053);
            return true;
        }
    };
    protected boolean dEh = true;
    protected boolean dEi = false;
    protected boolean dEj = false;
    protected String mAppId = "";
    protected PayInfo mPayInfo;
    protected String mRa = null;

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletOrderInfoOldUI() {
        AppMethodBeat.i(71067);
        AppMethodBeat.o(71067);
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c_7;
    }

    private void amZ() {
        boolean z;
        int i2 = 1;
        AppMethodBeat.i(71068);
        com.tencent.mm.wallet_core.d by = com.tencent.mm.wallet_core.a.by(this);
        this.mPayInfo = (PayInfo) getInput().getParcelable("key_pay_info");
        this.AJn = getInput().getString("key_trans_id");
        getInput().getInt("key_pay_type", -1);
        Log.i("MicroMsg.WalletOrderInfoOldUI", "mTransId %s", this.AJn);
        this.HFH = fSS();
        if (this.HFH != null) {
            setContentViewVisibility(0);
            d(this.HFH);
            if (!(by == null || this.HFH == null || this.mPayInfo == null)) {
                this.mAppId = this.mPayInfo.appId;
                boolean hgK = by.hgK();
                f.b(this, getInput(), 7);
                int i3 = getInput().getInt("key_support_bankcard", 1) == 2 ? 2 : 1;
                h hVar = h.INSTANCE;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(this.mPayInfo.dVv);
                if (this.mPayInfo.dVv == 3) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                if (!hgK) {
                    i2 = 2;
                }
                objArr[2] = Integer.valueOf(i2);
                objArr[3] = Integer.valueOf(ab.hhu());
                objArr[4] = Integer.valueOf((int) (this.HFH.dDO * 100.0d));
                objArr[5] = this.HFH.AOl;
                objArr[6] = Integer.valueOf(i3);
                hVar.a(10691, objArr);
            }
            if ((!t.fQI().fRk() && by != null && by.hgK()) || !z.aUj()) {
                z.aUk();
            }
            if (this.HFH == null || this.HFH.HZd == null || this.HFH.HZd.size() <= 0) {
                Log.printInfoStack("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
                com.tencent.mm.ui.base.h.a(getContext(), (int) R.string.ijv, 0, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(71044);
                        WalletOrderInfoOldUI.this.done();
                        AppMethodBeat.o(71044);
                    }
                });
            } else {
                this.Iho = this.HFH.HZd;
                this.AJn = this.Iho.get(0).dDM;
                if (!(this.mPayInfo == null || by == null || (!by.hgJ() && !by.hgK()))) {
                    doSceneProgress(new ad(getPayReqKey(), 21));
                }
            }
            if (this.AJn == null) {
                if (((com.tencent.mm.plugin.fingerprint.b.h) g.af(com.tencent.mm.plugin.fingerprint.b.h.class)).i(this)) {
                    this.Iio = false;
                }
                AppMethodBeat.o(71068);
                return;
            }
        } else {
            Log.printInfoStack("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
            com.tencent.mm.ui.base.h.a(getContext(), (int) R.string.ijv, 0, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(71046);
                    WalletOrderInfoOldUI.this.finish();
                    AppMethodBeat.o(71046);
                }
            });
        }
        AppMethodBeat.o(71068);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71069);
        super.onCreate(bundle);
        setContentViewVisibility(4);
        this.Ihn = new HashSet();
        amZ();
        initView();
        addSceneEndListener(1979);
        EventCenter.instance.addListener(this.IhP);
        EventCenter.instance.addListener(this.AMo);
        this.Iio = false;
        AppMethodBeat.o(71069);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI
    public final boolean eOn() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI
    public Orders fSS() {
        AppMethodBeat.i(71070);
        Orders orders = (Orders) getInput().getParcelable("key_orders");
        AppMethodBeat.o(71070);
        return orders;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI
    public final void aVQ(String str) {
        AppMethodBeat.i(71072);
        doSceneProgress(new ae(str));
        AppMethodBeat.o(71072);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI
    public final void ga(String str, int i2) {
        AppMethodBeat.i(71073);
        doSceneProgress(new ae(str, i2));
        AppMethodBeat.o(71073);
    }

    /* access modifiers changed from: protected */
    public final void a(Orders.Promotions promotions) {
        AppMethodBeat.i(71074);
        doSceneForceProgress(new s(promotions, getPayReqKey(), this.AJn, promotions.HYE));
        AppMethodBeat.o(71074);
    }

    private void d(Orders orders) {
        AppMethodBeat.i(71075);
        this.Ihn.clear();
        if (orders == null || orders.HZd == null) {
            Log.w("MicroMsg.WalletOrderInfoOldUI", "hy: orders is null");
            AppMethodBeat.o(71075);
            return;
        }
        for (Orders.Commodity commodity : orders.HZd) {
            if (commodity.HYT == 2 && !Util.isNullOrNil(commodity.HZF)) {
                Log.d("MicroMsg.WalletOrderInfoOldUI", "hy: has username and is force recommend");
                this.Ihn.add(commodity.HZF);
            }
        }
        AppMethodBeat.o(71075);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(71076);
        setMMTitle(R.string.iks);
        showHomeBtn(false);
        enableBackMenu(false);
        String string = getString(R.string.vl);
        if (this.mPayInfo == null || this.mPayInfo.dVv != 2) {
            if (this.HFH != null && !Util.isNullOrNil(this.HFH.HZo)) {
                string = this.HFH.HZo;
            }
        } else if (!Util.isNullOrNil(this.mPayInfo.IqM)) {
            string = getString(R.string.he) + this.mPayInfo.IqM;
        } else if (!Util.isNullOrNil(this.mPayInfo.appId) && !Util.isNullOrNil(com.tencent.mm.pluginsdk.model.app.h.r(this, this.mPayInfo.appId))) {
            string = getString(R.string.he) + com.tencent.mm.pluginsdk.model.app.h.r(this, this.mPayInfo.appId);
        }
        addTextOptionMenu(0, string, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(71049);
                WalletOrderInfoOldUI.this.done();
                AppMethodBeat.o(71049);
                return true;
            }
        });
        this.Iif = (LinearLayout) findViewById(R.id.jh5);
        this.Iig = (TextView) findViewById(R.id.jh4);
        this.Iih = (TextView) findViewById(R.id.jgx);
        this.Iii = new a();
        ((MaxListView) findViewById(R.id.jgh)).setAdapter((ListAdapter) this.Iii);
        fSZ();
        fTa();
        ((ScrollView) findViewById(R.id.ji9)).pageScroll(33);
        AppMethodBeat.o(71076);
    }

    private void fSZ() {
        boolean z;
        AppMethodBeat.i(71077);
        if (this.HFH != null) {
            this.Iho = this.HFH.HZd;
            Iterator<Orders.Commodity> it = this.Iho.iterator();
            while (true) {
                if (it.hasNext()) {
                    if ("1".equals(it.next().AOe)) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            this.Iif.setVisibility(0);
            this.Iig.setVisibility(0);
            if (!z) {
                this.Iig.setText(R.string.ikf);
            } else if (!Util.isNullOrNil(this.HFH.HYV) && !Util.isNullOrNil(this.HFH.HYV.trim())) {
                this.Iig.setText(this.HFH.HYV);
                AppMethodBeat.o(71077);
                return;
            } else if (this.HFH.HQg != 1) {
                this.Iig.setText(R.string.ike);
                AppMethodBeat.o(71077);
                return;
            } else {
                this.Iig.setText(R.string.ikd);
                AppMethodBeat.o(71077);
                return;
            }
        }
        AppMethodBeat.o(71077);
    }

    /* access modifiers changed from: protected */
    public final void a(String str, d dVar) {
        AppMethodBeat.i(71078);
        fSE();
        this.Iin = dVar;
        com.tencent.mm.wallet_core.ui.f.a((Context) this, str, false, 1);
        this.Iio = false;
        AppMethodBeat.o(71078);
    }

    /* access modifiers changed from: protected */
    public final void ahM(String str) {
        AppMethodBeat.i(71079);
        fSE();
        com.tencent.mm.wallet_core.ui.f.p(this, str, false);
        this.Iio = false;
        AppMethodBeat.o(71079);
    }

    private void fSE() {
        int i2 = 0;
        AppMethodBeat.i(71080);
        if (!this.IdD) {
            le leVar = new le();
            leVar.dQr.requestCode = 4;
            le.a aVar = leVar.dQr;
            if (getInput().getBoolean("intent_pay_end", false)) {
                i2 = -1;
            }
            aVar.resultCode = i2;
            EventCenter.instance.publish(leVar);
            this.IdD = true;
        }
        AppMethodBeat.o(71080);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI
    public final void ai(as asVar) {
        AppMethodBeat.i(71081);
        if (!(asVar == null || ((int) asVar.gMZ) == 0)) {
            String arI = asVar.arI();
            Log.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer nickName " + arI + " username: " + asVar.field_username);
            if (this.Iho != null && this.Iho.size() > 0) {
                for (Orders.Commodity commodity : this.Iho) {
                    commodity.dCu = arI;
                }
                this.Iii.notifyDataSetChanged();
            }
            this.mRa = asVar.field_username;
        }
        AppMethodBeat.o(71081);
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(71082);
        super.onDestroy();
        EventCenter.instance.removeListener(this.IhP);
        EventCenter.instance.removeListener(this.AMo);
        removeSceneEndListener(1979);
        AppMethodBeat.o(71082);
    }

    public void done() {
        AppMethodBeat.i(71083);
        if (getInput().containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) getInput().getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoOldUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
                boolean b2 = realnameGuideHelper.b(this, bundle, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.AnonymousClass8 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(71050);
                        WalletOrderInfoOldUI.this.fSY();
                        AppMethodBeat.o(71050);
                    }
                });
                getInput().remove("key_realname_guide_helper");
                if (!b2) {
                    fSY();
                }
            }
            AppMethodBeat.o(71083);
            return;
        }
        fSY();
        AppMethodBeat.o(71083);
    }

    public final void fSY() {
        String str;
        AppMethodBeat.i(71084);
        fSE();
        this.Iio = false;
        az azVar = new az();
        azVar.dEc.dEd = true;
        EventCenter.instance.publish(azVar);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
        Log.i("MicroMsg.WalletOrderInfoOldUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
        for (String str2 : this.Ihn) {
            if (!Util.isNullOrNil(str2)) {
                Log.i("MicroMsg.WalletOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", str2);
                if (this.HFH == null || this.mPayInfo == null) {
                    g.aAg().hqi.a(new com.tencent.mm.wallet_core.c.t(str2), 0);
                } else {
                    com.tencent.mm.ak.t tVar = g.aAg().hqi;
                    String str3 = this.HFH.dDL;
                    if (this.HFH.HZd.size() > 0) {
                        str = this.HFH.HZd.get(0).dDM;
                    } else {
                        str = "";
                    }
                    tVar.a(new com.tencent.mm.wallet_core.c.t(str2, str3, str, this.mPayInfo.dVv, this.mPayInfo.channel, this.HFH.HYT), 0);
                }
            }
            h.INSTANCE.a(13033, 2, str2, "", "", "");
        }
        com.tencent.mm.wallet_core.a.l(this, bundle);
        if (this.HFH != null && !Util.isNullOrNil(this.HFH.rCq)) {
            String i2 = i(this.HFH.rCq, this.HFH.dDL, this.HFH.HZd.size() > 0 ? this.HFH.HZd.get(0).dDM : "", this.mPayInfo.pSm, this.mPayInfo.remark);
            Log.d("MicroMsg.WalletOrderInfoOldUI", "url = ".concat(String.valueOf(i2)));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", i2);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", z.aTY());
            intent.putExtra("stastic_scene", 8);
            com.tencent.mm.br.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(71084);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(71085);
        if (i2 == 4) {
            done();
            AppMethodBeat.o(71085);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(71085);
        return onKeyUp;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    @Deprecated
    public Dialog onCreateDialog(int i2) {
        AppMethodBeat.i(71086);
        Dialog a2 = com.tencent.mm.ui.base.h.a(getContext(), getString(R.string.ik_), getResources().getStringArray(R.array.ax), "", new h.d() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.AnonymousClass9 */

            @Override // com.tencent.mm.ui.base.h.d
            public final void oj(int i2) {
                AppMethodBeat.i(71051);
                switch (i2) {
                    case 0:
                        WalletOrderInfoOldUI.this.Iio = false;
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + WalletOrderInfoOldUI.this.APz));
                        intent.addFlags(268435456);
                        WalletOrderInfoOldUI walletOrderInfoOldUI = WalletOrderInfoOldUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(walletOrderInfoOldUI, bl.axQ(), "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$7", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        walletOrderInfoOldUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(walletOrderInfoOldUI, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$7", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        break;
                }
                AppMethodBeat.o(71051);
            }
        });
        AppMethodBeat.o(71086);
        return a2;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(71087);
        super.onResume();
        Log.i("MicroMsg.WalletOrderInfoOldUI", "onResume, isClickActivityTinyApp: %s", Boolean.valueOf(this.Iio));
        if (this.Iio) {
            doSceneProgress(new af(this.Iin.HQn, this.Iin.Iia, this.Iin.Iib, this.Iin.Iic, this.Iin.dNQ, this.Iin.CpP, this.Iin.Ian));
        }
        AppMethodBeat.o(71087);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(71088);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.WalletOrderInfoOldUI", "onActivityResult %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 1) {
            doSceneProgress(new af(this.Iin.HQn, this.Iin.Iia, this.Iin.Iib, this.Iin.Iic, this.Iin.dNQ, this.Iin.CpP, this.Iin.Ian));
        }
        AppMethodBeat.o(71088);
    }

    private void fTa() {
        AppMethodBeat.i(71089);
        if (this.HFH == null || this.HFH.HZd == null || this.HFH.HZd.size() <= 0 || this.HFH.HZd.get(0).HZP == null || Util.isNullOrNil(this.HFH.HZd.get(0).HZP.text) || Util.isNullOrNil(this.HFH.HZd.get(0).HZP.url)) {
            Log.i("MicroMsg.WalletOrderInfoOldUI", "hy: no commodity or no link act or link act is illegal!");
            this.Iih.setVisibility(8);
            AppMethodBeat.o(71089);
            return;
        }
        this.Iih.setVisibility(0);
        this.Iih.setText(this.HFH.HZd.get(0).HZP.text);
        this.Iih.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(71052);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.wallet_core.ui.f.p(WalletOrderInfoOldUI.this, WalletOrderInfoOldUI.this.HFH.HZd.get(0).HZP.url, false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71052);
            }
        });
        AppMethodBeat.o(71089);
    }

    public class a extends BaseAdapter {
        public a() {
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(71059);
            Orders.Commodity aeT = aeT(i2);
            AppMethodBeat.o(71059);
            return aeT;
        }

        public final int getCount() {
            AppMethodBeat.i(71056);
            if (WalletOrderInfoOldUI.this.Iho != null) {
                int size = WalletOrderInfoOldUI.this.Iho.size();
                AppMethodBeat.o(71056);
                return size;
            }
            AppMethodBeat.o(71056);
            return 0;
        }

        private Orders.Commodity aeT(int i2) {
            AppMethodBeat.i(71057);
            Orders.Commodity commodity = WalletOrderInfoOldUI.this.Iho.get(i2);
            AppMethodBeat.o(71057);
            return commodity;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1919a aVar;
            String string;
            AppMethodBeat.i(71058);
            if (view == null) {
                view = View.inflate(WalletOrderInfoOldUI.this, R.layout.c_8, null);
                C1919a aVar2 = new C1919a();
                aVar2.Iiu = (TextView) view.findViewById(R.id.jgj);
                aVar2.jBR = (TextView) view.findViewById(R.id.jgo);
                aVar2.Iix = (TextView) view.findViewById(R.id.jh9);
                aVar2.Iiv = (TextView) view.findViewById(R.id.jhe);
                aVar2.Iiw = (TextView) view.findViewById(R.id.jh1);
                aVar2.Iiw.getPaint().setFlags(16);
                aVar2.Iiy = (TextView) view.findViewById(R.id.jhf);
                aVar2.Iiz = (TextView) view.findViewById(R.id.jgm);
                aVar2.IiA = (TextView) view.findViewById(R.id.jgi);
                aVar2.IiC = (MaxListView) view.findViewById(R.id.jh3);
                aVar2.IiD = view.findViewById(R.id.jgr);
                aVar2.IiB = view.findViewById(R.id.jh7);
                aVar2.IiF = (TextView) view.findViewById(R.id.jhh);
                aVar2.IiE = (TextView) view.findViewById(R.id.jhi);
                aVar2.IiG = (TextView) view.findViewById(R.id.jhj);
                aVar2.IiH = (TextView) view.findViewById(R.id.jhk);
                aVar2.IiJ = (ViewGroup) view.findViewById(R.id.jhb);
                aVar2.IdP = (CdnImageView) view.findViewById(R.id.io1);
                aVar2.IdQ = (TextView) view.findViewById(R.id.inx);
                aVar2.IdR = (TextView) view.findViewById(R.id.io2);
                aVar2.IiI = view.findViewById(R.id.jh8);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1919a) view.getTag();
            }
            final Orders.Commodity aeT = aeT(i2);
            if (!(aeT == null || aVar == null)) {
                WalletOrderInfoOldUI.this.Cvu = aeT.dDM;
                aVar.Iiv.setText(com.tencent.mm.wallet_core.ui.f.d(aeT.qwJ, aeT.AOl));
                if (aeT.HZE < 0.0d || aeT.qwJ >= aeT.HZE) {
                    aVar.Iiw.setVisibility(8);
                } else {
                    aVar.Iiw.setText(com.tencent.mm.wallet_core.ui.f.d(aeT.HZE, aeT.AOl));
                    aVar.Iiw.setVisibility(0);
                }
                LinearLayout linearLayout = (LinearLayout) aVar.IiD;
                List<Orders.DiscountInfo> list = aeT.HZH;
                linearLayout.removeAllViews();
                if (list != null && list.size() > 0) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        Orders.DiscountInfo discountInfo = list.get(i3);
                        TextView textView = new TextView(WalletOrderInfoOldUI.this.getContext());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.bottomMargin = WalletOrderInfoOldUI.this.getContext().getResources().getDimensionPixelOffset(R.dimen.f3062g);
                        textView.setLayoutParams(layoutParams);
                        textView.setTextAppearance(WalletOrderInfoOldUI.this.getContext(), R.style.ql);
                        if (discountInfo.HZY > 0.0d) {
                            textView.setText(discountInfo.Coh + com.tencent.mm.wallet_core.ui.f.d(discountInfo.HZY / 100.0d, WalletOrderInfoOldUI.this.HFH.AOl));
                        } else {
                            textView.setText(discountInfo.Coh);
                        }
                        linearLayout.addView(textView);
                        textView.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(R.color.ady));
                    }
                }
                if (linearLayout.getChildCount() > 0) {
                    linearLayout.setVisibility(0);
                } else {
                    linearLayout.setVisibility(8);
                }
                TextView textView2 = aVar.Iiu;
                WalletOrderInfoOldUI walletOrderInfoOldUI = WalletOrderInfoOldUI.this;
                if (z.aUo()) {
                    string = walletOrderInfoOldUI.getString(R.string.ik9);
                } else {
                    string = walletOrderInfoOldUI.getString(R.string.ik8);
                }
                textView2.setText(string);
                aVar.Iix.setText(aeT.AOa);
                aVar.jBR.setText(aeT.desc);
                aVar.jBR.setTag(aeT.desc);
                aVar.jBR.setOnLongClickListener(WalletOrderInfoOldUI.this.Iiq);
                aVar.jBR.setBackgroundResource(R.drawable.b49);
                aVar.Iiy.setText(aeT.dDM);
                aVar.Iiy.setTag(aeT.dDM);
                aVar.Iiy.setOnLongClickListener(WalletOrderInfoOldUI.this.Iiq);
                aVar.Iiy.setBackgroundResource(R.drawable.b49);
                aVar.Iiz.setText(com.tencent.mm.wallet_core.ui.f.rZ(aeT.AOh));
                aVar.IiA.setText(aeT.AOj);
                String str = aeT.HZI;
                if (aVar.IiG != null) {
                    if (!Util.isNullOrNil(str)) {
                        aVar.IiG.setText(str);
                        aVar.IiG.setVisibility(0);
                        aVar.IiH.setVisibility(0);
                    } else {
                        aVar.IiH.setVisibility(8);
                        aVar.IiG.setVisibility(8);
                    }
                }
                String str2 = aeT.HZK;
                if (aVar.IiF != null) {
                    if (!Util.isNullOrNil(str2)) {
                        aVar.IiF.setText(str2);
                        aVar.IiF.setVisibility(0);
                        aVar.IiE.setVisibility(0);
                    } else {
                        aVar.IiE.setVisibility(8);
                        aVar.IiF.setVisibility(8);
                    }
                }
                if (aeT.HZN.size() > 0) {
                    Orders.Promotions promotions = aeT.HZN.get(0);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13033, 1, promotions.dCu, promotions.url, promotions.name, WalletOrderInfoOldUI.this.Cvu);
                    WalletOrderInfoOldUI.this.Iil = new c(aeT.HZN);
                    aVar.IiC.setAdapter((ListAdapter) WalletOrderInfoOldUI.this.Iil);
                    aVar.IiC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.a.AnonymousClass1 */

                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                            AppMethodBeat.i(71054);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(adapterView);
                            bVar.bm(view);
                            bVar.pH(i2);
                            bVar.zo(j2);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                            Orders.Promotions aeU = WalletOrderInfoOldUI.this.Iil.aeU(i2);
                            if (!Util.isNullOrNil(aeU.dCu)) {
                                if (WalletOrderInfoOldUI.this.Ihn.contains(aeU.dCu)) {
                                    WalletOrderInfoOldUI.this.Ihn.remove(aeU.dCu);
                                } else {
                                    WalletOrderInfoOldUI.this.Ihn.add(aeU.dCu);
                                }
                                WalletOrderInfoOldUI.this.Iii.notifyDataSetChanged();
                            } else {
                                String LT = WalletOrderInfoOldUI.this.LT(aeU.crw);
                                if ("-1".equals(LT) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(LT)) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13472, WalletOrderInfoOldUI.this.Cvu, Integer.valueOf(aeU.Vgg), 1, Long.valueOf(aeU.crw), Long.valueOf(aeU.HYE));
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13033, 2, "", aeU.url, aeU.name, "");
                                    if (!Util.isNullOrNil(aeU.Vgj) && !Util.isNullOrNil(aeU.Vgk)) {
                                        Log.i("MicroMsg.WalletOrderInfoOldUI", "promotion jump tiny app, username: %s, path: %s", aeU.Vgj, aeU.Vgk);
                                        wq wqVar = new wq();
                                        wqVar.ecI.userName = aeU.Vgj;
                                        wqVar.ecI.ecK = Util.nullAs(aeU.Vgk, "");
                                        wqVar.ecI.scene = 1060;
                                        wqVar.ecI.dCw = WalletOrderInfoOldUI.this.AJn;
                                        wqVar.ecI.ecL = 0;
                                        EventCenter.instance.publish(wqVar);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14118, WalletOrderInfoOldUI.this.AJn, WalletOrderInfoOldUI.this.getPayReqKey(), 2);
                                        WalletOrderInfoOldUI.this.Iin = new d(new StringBuilder().append(aeU.crw).toString(), new StringBuilder().append(aeU.Vgh).toString(), new StringBuilder().append(aeU.HYC).toString(), new StringBuilder().append(aeU.HYD).toString(), WalletOrderInfoOldUI.this.getPayReqKey(), WalletOrderInfoOldUI.this.Cvu, aeU.HYE);
                                        WalletOrderInfoOldUI.this.Iio = true;
                                    } else if (aeU.Vgg == 1) {
                                        WalletOrderInfoOldUI.this.a(aeU);
                                    } else if (aeU.Vgg != 2 || Util.isNullOrNil(aeU.url)) {
                                        Log.e("MicroMsg.WalletOrderInfoOldUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                                    } else if (WalletOrderInfoOldUI.this.IdI.containsKey(new StringBuilder().append(aeU.crw).toString())) {
                                        b bVar2 = (b) WalletOrderInfoOldUI.this.IdI.get(new StringBuilder().append(aeU.crw).toString());
                                        Log.i("MicroMsg.WalletOrderInfoOldUI", "go to new url %s", bVar2.url);
                                        WalletOrderInfoOldUI.this.ahM(bVar2.url);
                                    } else {
                                        WalletOrderInfoOldUI.this.IdJ = aeU.url;
                                        WalletOrderInfoOldUI.this.a(aeU.url, new d(new StringBuilder().append(aeU.crw).toString(), new StringBuilder().append(aeU.Vgh).toString(), new StringBuilder().append(aeU.HYC).toString(), new StringBuilder().append(aeU.HYD).toString(), WalletOrderInfoOldUI.this.getPayReqKey(), WalletOrderInfoOldUI.this.Cvu, aeU.HYE));
                                    }
                                }
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                            AppMethodBeat.o(71054);
                        }
                    });
                    WalletOrderInfoOldUI.this.Iil.notifyDataSetChanged();
                    aVar.IiC.setVisibility(0);
                    aVar.IiB.setVisibility(0);
                } else {
                    aVar.IiC.setVisibility(8);
                    aVar.IiJ.setVisibility(8);
                    aVar.IiB.setVisibility(8);
                }
                if (aeT.HZL == null || Util.isNullOrNil(aeT.HZL.Hwr)) {
                    aVar.IiJ.setVisibility(8);
                    aVar.IiI.setVisibility(8);
                } else {
                    aVar.IdP.setUrl(aeT.HZL.HYH);
                    aVar.IdQ.setText(aeT.HZL.HYI);
                    aVar.IdR.setText(aeT.HZL.HLz);
                    aVar.IiJ.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.a.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(71055);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            wq wqVar = new wq();
                            wqVar.ecI.userName = aeT.HZL.Hwr;
                            wqVar.ecI.ecK = Util.nullAs(aeT.HZL.Hws, "");
                            wqVar.ecI.scene = 1034;
                            wqVar.ecI.ecL = 0;
                            EventCenter.instance.publish(wqVar);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14118, WalletOrderInfoOldUI.this.AJn, WalletOrderInfoOldUI.this.getPayReqKey(), 1);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$OrderInfoAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(71055);
                        }
                    });
                    aVar.IiI.setVisibility(0);
                }
            }
            AppMethodBeat.o(71058);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI$a$a  reason: collision with other inner class name */
        class C1919a {
            CdnImageView IdP;
            TextView IdQ;
            TextView IdR;
            TextView IiA;
            View IiB;
            MaxListView IiC;
            View IiD;
            TextView IiE;
            TextView IiF;
            TextView IiG;
            TextView IiH;
            View IiI;
            ViewGroup IiJ;
            TextView Iiu;
            TextView Iiv;
            TextView Iiw;
            TextView Iix;
            TextView Iiy;
            TextView Iiz;
            TextView jBR;

            C1919a() {
            }
        }
    }

    class c extends BaseAdapter {
        protected List<Orders.Promotions> HZN;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(71066);
            Orders.Promotions aeU = aeU(i2);
            AppMethodBeat.o(71066);
            return aeU;
        }

        public c(List<Orders.Promotions> list) {
            AppMethodBeat.i(71062);
            this.HZN = null;
            this.HZN = new ArrayList();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Orders.Promotions promotions = list.get(i2);
                if (promotions != null && (!Util.isNullOrNil(promotions.dCu) || promotions.Vgg == 2 || promotions.Vgg == 1)) {
                    this.HZN.add(list.get(i2));
                }
            }
            AppMethodBeat.o(71062);
        }

        public final int getCount() {
            AppMethodBeat.i(71063);
            if (this.HZN != null) {
                int size = this.HZN.size();
                AppMethodBeat.o(71063);
                return size;
            }
            AppMethodBeat.o(71063);
            return 0;
        }

        public final Orders.Promotions aeU(int i2) {
            AppMethodBeat.i(71064);
            Orders.Promotions promotions = this.HZN.get(i2);
            AppMethodBeat.o(71064);
            return promotions;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            a aVar;
            View view2;
            View view3;
            AppMethodBeat.i(71065);
            Orders.Promotions aeU = aeU(i2);
            if (Util.isNullOrNil(aeU.dCu) && aeU.crw > 0) {
                int LT = WalletOrderInfoOldUI.this.LT(aeU.crw);
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[6];
                objArr[0] = WalletOrderInfoOldUI.this.Cvu;
                objArr[1] = 1;
                objArr[2] = Integer.valueOf(aeU.Vgg);
                if ("-1".equals(LT)) {
                    LT = 5;
                }
                objArr[3] = LT;
                objArr[4] = Long.valueOf(aeU.crw);
                objArr[5] = Long.valueOf(aeU.HYE);
                hVar.a(13471, objArr);
            }
            if (view == null) {
                a aVar2 = new a();
                aVar2.type = aeU.type;
                if (aeU.type == Orders.HZD) {
                    if (aeU.trD == 1) {
                        View inflate = View.inflate(WalletOrderInfoOldUI.this, R.layout.c_9, null);
                        aVar2.qgQ = (CdnImageView) inflate.findViewById(R.id.jgy);
                        aVar2.titleTv = (TextView) inflate.findViewById(R.id.jhc);
                        aVar2.IiK = (TextView) inflate.findViewById(R.id.jgl);
                        aVar2.gxs = (TextView) inflate.findViewById(R.id.jh0);
                        if (!TextUtils.isEmpty(aeU.url)) {
                            WalletOrderInfoOldUI.this.Iik.put(aeU.url, aVar2.IiK);
                        }
                        inflate.setTag(aVar2);
                        view3 = inflate;
                    } else {
                        View inflate2 = View.inflate(WalletOrderInfoOldUI.this, R.layout.c__, null);
                        aVar2.qgQ = (CdnImageView) inflate2.findViewById(R.id.jgy);
                        aVar2.IiK = (TextView) inflate2.findViewById(R.id.jgl);
                        aVar2.gxs = (TextView) inflate2.findViewById(R.id.jh0);
                        aVar2.titleTv = (TextView) inflate2.findViewById(R.id.jhc);
                        if (!TextUtils.isEmpty(aeU.url)) {
                            WalletOrderInfoOldUI.this.Iik.put(aeU.url, aVar2.IiK);
                        }
                        inflate2.setTag(aVar2);
                        view3 = inflate2;
                    }
                    aVar2.trD = aeU.trD;
                    view = view3;
                    aVar = aVar2;
                } else {
                    view = View.inflate(WalletOrderInfoOldUI.this, R.layout.c_a, null);
                    aVar2.qgQ = (CdnImageView) view.findViewById(R.id.jgy);
                    aVar2.IiK = (TextView) view.findViewById(R.id.jgl);
                    aVar2.gxs = (TextView) view.findViewById(R.id.jh0);
                    aVar2.IiL = (CheckBox) view.findViewById(R.id.id);
                    if (!TextUtils.isEmpty(aeU.url)) {
                        WalletOrderInfoOldUI.this.Iik.put(aeU.url, aVar2.IiK);
                    }
                    view.setTag(aVar2);
                    aVar = aVar2;
                }
            } else {
                a aVar3 = (a) view.getTag();
                boolean z = false;
                if (aeU.type == aVar3.type && (aeU.type != Orders.HZD || aeU.trD == aVar3.trD)) {
                    z = true;
                }
                if (!z) {
                    a aVar4 = new a();
                    aVar4.type = aeU.type;
                    if (aeU.type == Orders.HZD) {
                        if (aeU.trD == 1) {
                            View inflate3 = View.inflate(WalletOrderInfoOldUI.this, R.layout.c_9, null);
                            aVar4.qgQ = (CdnImageView) inflate3.findViewById(R.id.jgy);
                            aVar4.titleTv = (TextView) inflate3.findViewById(R.id.jhc);
                            aVar4.IiK = (TextView) inflate3.findViewById(R.id.jgl);
                            aVar4.gxs = (TextView) inflate3.findViewById(R.id.jh0);
                            if (!TextUtils.isEmpty(aeU.url)) {
                                WalletOrderInfoOldUI.this.Iik.put(aeU.url, aVar4.IiK);
                            }
                            inflate3.setTag(aVar4);
                            view2 = inflate3;
                        } else {
                            View inflate4 = View.inflate(WalletOrderInfoOldUI.this, R.layout.c__, null);
                            aVar4.qgQ = (CdnImageView) inflate4.findViewById(R.id.jgy);
                            aVar4.IiK = (TextView) inflate4.findViewById(R.id.jgl);
                            aVar4.gxs = (TextView) inflate4.findViewById(R.id.jh0);
                            aVar4.titleTv = (TextView) inflate4.findViewById(R.id.jhc);
                            if (!TextUtils.isEmpty(aeU.url)) {
                                WalletOrderInfoOldUI.this.Iik.put(aeU.url, aVar4.IiK);
                            }
                            inflate4.setTag(aVar4);
                            view2 = inflate4;
                        }
                        aVar4.trD = aeU.trD;
                        view = view2;
                        aVar = aVar4;
                    } else {
                        view = View.inflate(WalletOrderInfoOldUI.this, R.layout.c_a, null);
                        aVar4.qgQ = (CdnImageView) view.findViewById(R.id.jgy);
                        aVar4.IiK = (TextView) view.findViewById(R.id.jgl);
                        aVar4.gxs = (TextView) view.findViewById(R.id.jh0);
                        aVar4.IiL = (CheckBox) view.findViewById(R.id.id);
                        if (!TextUtils.isEmpty(aeU.url)) {
                            WalletOrderInfoOldUI.this.Iik.put(aeU.url, aVar4.IiK);
                        }
                        view.setTag(aVar4);
                        aVar = aVar4;
                    }
                } else {
                    aVar = aVar3;
                }
            }
            if (aeU != null) {
                b bVar = (b) WalletOrderInfoOldUI.this.IdI.get(new StringBuilder().append(aeU.crw).toString());
                Log.i("MicroMsg.WalletOrderInfoOldUI", "try get result ".concat(String.valueOf(bVar)));
                if (bVar != null) {
                    aVar.qgQ.setUrl(bVar.icon);
                    aVar.gxs.setText(bVar.dQx);
                    aVar.IiK.setText(bVar.IhY);
                } else {
                    aVar.qgQ.setUrl(aeU.Bah);
                    aVar.gxs.setText(aeU.name);
                    aVar.IiK.setText(aeU.HYF);
                }
                if (!Util.isNullOrNil(aeU.dCu)) {
                    aVar.IiK.setVisibility(8);
                    if (aVar.IiL != null) {
                        aVar.IiL.setVisibility(0);
                        if (WalletOrderInfoOldUI.this.Ihn.contains(aeU.dCu)) {
                            aVar.IiL.setChecked(true);
                        } else {
                            aVar.IiL.setChecked(false);
                        }
                    }
                } else {
                    aVar.IiK.setVisibility(0);
                    if (aVar.IiL != null) {
                        aVar.IiL.setVisibility(8);
                    }
                }
                if (aVar.titleTv != null && bVar != null && !Util.isNullOrNil(bVar.title)) {
                    aVar.titleTv.setText(bVar.title);
                } else if (aVar.titleTv != null && !Util.isNullOrNil(aeU.title)) {
                    aVar.titleTv.setText(aeU.title);
                } else if (aVar.titleTv != null) {
                    aVar.titleTv.setVisibility(8);
                }
                if (!Util.isNullOrNil(WalletOrderInfoOldUI.this.IdJ) && aVar.IiK != null) {
                    aVar.IiK.setClickable(WalletOrderInfoOldUI.this.dEh);
                    aVar.IiK.setEnabled(WalletOrderInfoOldUI.this.dEh);
                    aVar.IiK.setOnClickListener(null);
                    if (WalletOrderInfoOldUI.this.dEi) {
                        aVar.IiK.setVisibility(8);
                    }
                }
                String LT2 = WalletOrderInfoOldUI.this.LT(aeU.crw);
                if (LT2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    aVar.IiK.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(R.color.ac_));
                    aVar.IiK.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(R.color.afp));
                } else if (LT2.equals("-1") || LT2.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                    aVar.IiK.setBackgroundDrawable(WalletOrderInfoOldUI.this.getResources().getDrawable(R.drawable.kk));
                    aVar.IiK.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(R.color.afp));
                } else if (LT2.equals("4") || LT2.equals("2") || LT2.equals("1")) {
                    aVar.IiK.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(R.color.ac_));
                    aVar.IiK.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(R.color.uj));
                } else {
                    Log.e("MicroMsg.WalletOrderInfoOldUI", "PromotionsAdapter unknow award state");
                }
            }
            if (aVar.IiK != null) {
                int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(WalletOrderInfoOldUI.this.getContext(), 15.0f);
                int fromDPToPix2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(WalletOrderInfoOldUI.this.getContext(), 5.0f);
                aVar.IiK.setPadding(fromDPToPix, fromDPToPix2, fromDPToPix, fromDPToPix2);
            }
            AppMethodBeat.o(71065);
            return view;
        }

        class a {
            TextView IiK;
            CheckBox IiL;
            TextView gxs;
            CdnImageView qgQ;
            TextView titleTv;
            int trD;
            int type;

            a() {
            }
        }
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        String string;
        boolean z;
        AppMethodBeat.i(71090);
        if ((qVar instanceof af) && i2 == 0 && i3 == 0) {
            af afVar = (af) qVar;
            b bVar = new b(afVar.lxS);
            if (Util.isNullOrNil(bVar.url) || Util.isNullOrNil(bVar.dQx)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.IdI.put(afVar.HQn, bVar);
            }
            this.Iii.notifyDataSetChanged();
        }
        if (qVar instanceof ae) {
            if (i2 == 0 && i3 == 0) {
                setContentViewVisibility(0);
                this.HFH = ((ae) qVar).HQs;
                if (this.HFH != null) {
                    this.Iho = this.HFH.HZd;
                }
                d(this.HFH);
                Log.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + this.Iho);
                if (!(this.Iho == null || this.Iho.size() == 0)) {
                    Orders.Commodity commodity = this.Iho.get(0);
                    this.AJn = commodity.dDM;
                    Log.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + commodity.toString());
                    as Kn = ((l) g.af(l.class)).aSN().Kn(commodity.dCu);
                    if (Kn == null || ((int) Kn.gMZ) == 0) {
                        ay.a.iDq.a(commodity.dCu, "", this.Iip);
                    } else {
                        ai(Kn);
                    }
                    this.Iii.notifyDataSetChanged();
                    fSZ();
                }
            }
            if (this.Iii != null) {
                this.Iii.notifyDataSetChanged();
            }
            fTa();
            AppMethodBeat.o(71090);
            return true;
        }
        if (qVar instanceof s) {
            if (i2 == 0 && i3 == 0) {
                s sVar = (s) qVar;
                String str2 = sVar.HPV;
                this.Iim.put(Long.valueOf(sVar.HPY.crw), str2);
                sVar.HPY.HYF = sVar.resultMsg;
                if (!"-1".equals(str2) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2) && !Util.isNullOrNil(sVar.HPW)) {
                    com.tencent.mm.ui.base.h.c(this, sVar.HPW, "", true);
                } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2)) {
                    if (!Util.isNullOrNil(sVar.HPW)) {
                        string = sVar.HPW;
                    } else {
                        string = getString(R.string.imw);
                    }
                    Toast.makeText(this, string, 0).show();
                }
                this.Iii.notifyDataSetChanged();
                AppMethodBeat.o(71090);
                return true;
            } else if (qVar instanceof s) {
                if (Util.isNullOrNil(str)) {
                    str = getString(R.string.itf);
                }
                com.tencent.mm.ui.base.h.a((Context) this, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(71090);
                return true;
            }
        }
        AppMethodBeat.o(71090);
        return false;
    }

    public final String LT(long j2) {
        AppMethodBeat.i(71091);
        if (this.Iim.containsKey(Long.valueOf(j2))) {
            String str = this.Iim.get(Long.valueOf(j2));
            AppMethodBeat.o(71091);
            return str;
        }
        AppMethodBeat.o(71091);
        return "-1";
    }

    /* access modifiers changed from: package-private */
    public class d {
        public String CpP;
        public String HQn;
        public long Ian;
        public String Iia;
        public String Iib;
        public String Iic;
        public String dNQ;

        public d(String str, String str2, String str3, String str4, String str5, String str6, long j2) {
            this.HQn = str;
            this.Iia = str2;
            this.Iib = str3;
            this.Iic = str4;
            this.dNQ = str5;
            this.CpP = str6;
            this.Ian = j2;
        }
    }

    /* access modifiers changed from: package-private */
    public class b {
        public String IhY;
        public String dQx;
        public String icon;
        public String title;
        public String url;

        public b(JSONObject jSONObject) {
            AppMethodBeat.i(71060);
            if (jSONObject == null) {
                AppMethodBeat.o(71060);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("activity_change_info");
            if (optJSONObject != null) {
                this.url = optJSONObject.optString("url");
                this.dQx = optJSONObject.optString("wording");
                this.icon = optJSONObject.optString("icon");
                this.IhY = optJSONObject.optString("btn_text");
                this.title = optJSONObject.optString("title");
            }
            AppMethodBeat.o(71060);
        }

        public final String toString() {
            AppMethodBeat.i(71061);
            String str = this.url + " , " + this.dQx + " , " + this.icon + " , " + this.IhY + " , " + this.title;
            AppMethodBeat.o(71061);
            return str;
        }
    }
}
