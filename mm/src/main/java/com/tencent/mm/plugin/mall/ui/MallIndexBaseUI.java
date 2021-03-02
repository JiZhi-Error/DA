package com.tencent.mm.plugin.mall.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.d;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.mall.a.f;
import com.tencent.mm.plugin.mall.a.k;
import com.tencent.mm.plugin.mall.ui.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class MallIndexBaseUI extends WalletBaseUI implements u.a, l {
    private static final String zlf = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1p) + "/touch/scene_product.html?scene_id=kf1");
    protected String uuid;
    protected View vbj;
    private String yUq = null;
    private String zjn = null;
    ArrayList<MallFunction> zjo = null;
    protected int zjs;
    private TextView zlg = null;
    protected ListView zlh = null;
    private b zli = null;
    protected ImageView zlj = null;
    protected ImageView zlk;
    protected TextView zll = null;
    protected TextView zlm;
    private int zln = 0;
    private boolean zlo = true;
    protected int zlp;
    protected View zlq;
    private boolean zlr = false;

    /* access modifiers changed from: protected */
    public abstract void dYP();

    /* access modifiers changed from: protected */
    public abstract void egS();

    /* access modifiers changed from: protected */
    public abstract void egT();

    /* access modifiers changed from: protected */
    public abstract void egU();

    /* access modifiers changed from: protected */
    public abstract boolean egV();

    /* access modifiers changed from: protected */
    public abstract void egW();

    /* access modifiers changed from: protected */
    public abstract void egZ();

    /* access modifiers changed from: protected */
    public abstract void eha();

    /* access modifiers changed from: protected */
    public abstract void ehb();

    /* access modifiers changed from: protected */
    public abstract void ehd();

    /* access modifiers changed from: protected */
    public abstract void ehf();

    /* access modifiers changed from: protected */
    public abstract void eq(View view);

    /* access modifiers changed from: protected */
    public abstract void initHeaderView();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b5m;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        Log.i("MicroMsg.MallIndexBaseUI", "onCreate");
        super.onCreate(bundle);
        if (!g.aAc()) {
            Log.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
            finish();
        }
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
        this.zjs = getIntent().getIntExtra("key_wallet_region", intValue);
        this.uuid = getIntent().getStringExtra("key_uuid");
        if (Util.isNullOrNil(this.uuid)) {
            this.uuid = UUID.randomUUID().toString();
        }
        addSceneEndListener(d.CTRL_INDEX);
        t.fQP();
        ah.a(this);
        this.zjn = getIntent().getStringExtra("key_func_id");
        Log.i("MicroMsg.MallIndexBaseUI", "mFuncId:" + this.zjn + " wallet_region: " + this.zjs + " walletType: " + z.aUf() + " default_region: " + intValue);
        this.yUq = getIntent().getStringExtra("key_native_url");
        Log.i("MicroMsg.MallIndexBaseUI", "mNativeUrl:" + this.yUq);
        if (!isTransparent()) {
            dYP();
            setContentViewVisibility(0);
            Log.i("MicroMsg.MallIndexBaseUI", "index Oncreate");
            egS();
            initView();
            c.fSj();
            egT();
            Log.i("MicroMsg.MallIndexBaseUI", "hy: use default controller for MallIndexUI");
            egU();
            if (z.aUo()) {
                Log.e("MicroMsg.MallIndexBaseUI", "it is payu account ,not initFingerPrint");
            } else {
                a aVar = (a) g.af(a.class);
                if (aVar != null) {
                    Log.i("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
                    aVar.dJN();
                } else {
                    Log.e("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null");
                }
            }
            ab.mg(1, 0);
            h.INSTANCE.a(11850, 1, 0);
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void shouldFixStatusBar() {
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void setStatusColor() {
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isTransparent() {
        if (!Util.isNullOrNil(this.zjn) || !Util.isNullOrNil(this.yUq)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        boolean z = true;
        super.onResume();
        com.tencent.mm.pluginsdk.wallet.h.setPayChannel(1);
        Log.i("MicroMsg.MallIndexBaseUI", "index onResume");
        if (!g.aAc()) {
            Log.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
            finish();
        }
        if (isTransparent()) {
            this.zjo = k.egL().Qe(this.zjs);
            if (this.zjo == null || this.zjo.size() <= 0) {
                Log.i("MicroMsg.MallIndexBaseUI", "mFunctionList == null");
                try {
                    if (getIntent().getIntExtra("key_scene", 0) == 1 || !Util.isNullOrNil(this.yUq)) {
                        doSceneForceProgress(new f(this.zjs, b.fRY(), 0));
                        return;
                    }
                    String stringExtra = getIntent().getStringExtra("key_url");
                    if (stringExtra == null) {
                        stringExtra = "";
                    }
                    doSceneForceProgress(new f(this.zjs, b.fRY(), getIntent().getStringExtra("key_app_id"), this.zjn, stringExtra));
                } catch (UnsupportedEncodingException e2) {
                    Log.printErrStackTrace("MicroMsg.MallIndexBaseUI", e2, "", new Object[0]);
                    egY();
                }
            } else {
                MallFunction fs = fs(this.zjo);
                if (fs == null) {
                    fs = ft(this.zjo);
                }
                a(fs, -1);
                finish();
            }
        } else {
            egV();
            Log.d("MicroMsg.MallIndexBaseUI", "initFunctionList");
            if (k.egL().Qe(this.zjs) == null) {
                doSceneProgress(new f(this.zjs, b.fRY(), 0), true);
                Log.e("MicroMsg.MallIndexBaseUI", "funcitonlist invalid");
                z = false;
            } else {
                doSceneProgress(new f(this.zjs, b.fRY(), 1), false);
                this.zjo = k.egL().Qe(this.zjs);
            }
            if (z) {
                Log.i("MicroMsg.MallIndexBaseUI", "has data");
                updateView();
            }
        }
    }

    private void egX() {
        boolean booleanExtra = getIntent().getBooleanExtra("key_wallet_has_red", false);
        if (this.zlh.getChildCount() != 0) {
            int firstVisiblePosition = this.zlh.getFirstVisiblePosition();
            int top = this.zlh.getChildAt(0).getTop();
            Log.i("MicroMsg.MallIndexBaseUI", "initCheckNew %s fpos %s top %s", Boolean.valueOf(booleanExtra), Integer.valueOf(firstVisiblePosition), Integer.valueOf(top));
            if (firstVisiblePosition == 0 && top == 0 && booleanExtra && !this.zlr && this.zjo != null) {
                this.zlr = true;
                int headerViewsCount = this.zlh.getHeaderViewsCount() + this.zli.getCount();
                List<ArrayList<b.c>> list = this.zli.zke;
                if (list != null) {
                    for (int size = list.size() - 1; size > 0; size--) {
                        Iterator<b.c> it = list.get(size).iterator();
                        while (it.hasNext()) {
                            b.c next = it.next();
                            if (!(next == null || next.zkI == null || !b.a(next.zkI))) {
                                int firstVisiblePosition2 = this.zlh.getFirstVisiblePosition();
                                int lastVisiblePosition = this.zlh.getLastVisiblePosition();
                                Log.i("MicroMsg.MallIndexBaseUI", "get listview show top %s bottom %s redPos: %d", Integer.valueOf(firstVisiblePosition2), Integer.valueOf(lastVisiblePosition), Integer.valueOf(headerViewsCount));
                                if (headerViewsCount < firstVisiblePosition2 || headerViewsCount > lastVisiblePosition) {
                                    int egO = a.egO();
                                    int egN = a.egN() + (a.egM() * (headerViewsCount + 1)) + egO;
                                    if (headerViewsCount > 2) {
                                        egN += egO;
                                    }
                                    if (headerViewsCount > 3) {
                                        egN += egO;
                                    }
                                    int egM = (egN + (a.egM() / 3)) - this.zlh.getScrollY();
                                    int i2 = ao.az(this).y;
                                    if (ao.aA(this)) {
                                        i2 -= ao.aD(this);
                                    }
                                    if (getSupportActionBar() != null) {
                                        i2 -= getSupportActionBar().getHeight();
                                    }
                                    this.zlh.smoothScrollBy(egM - i2, 1000);
                                    return;
                                }
                                return;
                            }
                        }
                        headerViewsCount--;
                    }
                }
            }
        }
    }

    public void a(MallFunction mallFunction, int i2) {
        int i3;
        if (mallFunction != null && i2 >= 0) {
            String str = "";
            if (mallFunction.Icf != null && !Util.isNullOrNil(mallFunction.Icf.FJm)) {
                str = mallFunction.Icf.FJm;
            }
            int size = this.zjo == null ? 0 : this.zjo.size();
            boolean a2 = b.a(mallFunction);
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[10];
            objArr[0] = mallFunction.kHR;
            objArr[1] = Integer.valueOf(size);
            objArr[2] = 0;
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = str;
            if (a2) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            objArr[5] = Integer.valueOf(i3);
            objArr[6] = 1;
            objArr[7] = 0;
            objArr[8] = 0;
            objArr[9] = 0;
            hVar.a(10881, objArr);
        }
        if (mallFunction == null || Util.isNullOrNil(mallFunction.egX) || !((s) g.af(s.class)).n(mallFunction.egX, null)) {
            int f2 = d.f(mallFunction);
            Log.i("MicroMsg.MallIndexBaseUI", "functionType : ".concat(String.valueOf(f2)));
            switch (f2) {
                case 0:
                    Intent intent = new Intent();
                    if (isTransparent()) {
                        intent.putExtra("key_is_hide_progress", true);
                    }
                    intent.putExtra("key_func_info", mallFunction);
                    com.tencent.mm.br.c.b(this, "recharge", ".ui.PhoneRechargeUI", intent);
                    ab.mg(15, 0);
                    return;
                case 1:
                    g.aAi();
                    this.zjs = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", mallFunction.h5Url);
                    intent2.putExtra("geta8key_username", z.aTY());
                    intent2.putExtra("pay_channel", 1);
                    intent2.putExtra("KPublisherId", "pay_wallet");
                    intent2.putExtra("key_download_restrict", mallFunction.Ich);
                    intent2.putExtra("key_wallet_region", this.zjs);
                    intent2.putExtra("key_function_id", mallFunction.kHR);
                    intent2.putExtra(e.p.OzJ, true);
                    intent2.putExtra("geta8key_scene", 46);
                    com.tencent.mm.wallet_core.ui.f.aA(getContext(), intent2);
                    return;
                case 2:
                    Log.w("MicroMsg.MallIndexBaseUI", "doSelectFunction no jump");
                    return;
                case 3:
                    Log.w("MicroMsg.MallIndexBaseUI", "doSelectFunction do nothing");
                    com.tencent.mm.ui.base.u.makeText(this, "fuction list error", 1).show();
                    return;
                case 4:
                    h.INSTANCE.a(11701, 0, 0, 0, 0, 1);
                    Intent intent3 = new Intent();
                    intent3.putExtra("pay_channel", 1);
                    com.tencent.mm.br.c.b(this, "luckymoney", ".ui.LuckyMoneyIndexUI", intent3);
                    ab.mg(13, 0);
                    h.INSTANCE.a(11850, 4, 0);
                    return;
                case 5:
                    h.INSTANCE.a(11458, 1);
                    if (z.aUo()) {
                        LinkedList linkedList = new LinkedList();
                        LinkedList linkedList2 = new LinkedList();
                        linkedList.add(getString(R.string.g4o));
                        linkedList2.add(0);
                        linkedList.add(getString(R.string.b7s));
                        linkedList2.add(1);
                        com.tencent.mm.ui.base.h.b(this, getString(R.string.g26), linkedList, linkedList2, (String) null, new h.e() {
                            /* class com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.AnonymousClass3 */

                            @Override // com.tencent.mm.ui.base.h.e
                            public final void cy(int i2, int i3) {
                                AppMethodBeat.i(66066);
                                switch (i3) {
                                    case 0:
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11458, 2);
                                        if (z.aUo()) {
                                            com.tencent.mm.wallet_core.a.b(MallIndexBaseUI.this.getContext(), "PayURemittanceProcess", null);
                                            AppMethodBeat.o(66066);
                                            return;
                                        }
                                        com.tencent.mm.wallet_core.a.b(MallIndexBaseUI.this.getContext(), "RemittanceProcess", null);
                                        AppMethodBeat.o(66066);
                                        return;
                                    case 1:
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11458, 3);
                                        com.tencent.mm.pluginsdk.wallet.f.aD(MallIndexBaseUI.this, 2);
                                        break;
                                }
                                AppMethodBeat.o(66066);
                            }
                        });
                    } else {
                        g.aAi();
                        if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_MALL_INDEX_HAS_SHOWN_FTF_NOTICE_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                            g.aAi();
                            g.aAh().azQ().set(ar.a.USERINFO_MALL_INDEX_HAS_SHOWN_FTF_NOTICE_BOOLEAN, Boolean.TRUE);
                            com.tencent.mm.ui.base.h.d(this, getString(R.string.idw), "", new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.AnonymousClass4 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(66067);
                                    MallIndexBaseUI.this.ehc();
                                    AppMethodBeat.o(66067);
                                }
                            });
                        } else {
                            ehc();
                        }
                    }
                    ab.mg(14, 0);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11850, 3, 0);
                    return;
                case 6:
                    Intent intent4 = new Intent();
                    intent4.putExtra("key_from_scene", 1);
                    com.tencent.mm.br.c.b(getContext(), "offline", ".ui.WalletOfflineEntranceUI", intent4);
                    ab.mg(9, 0);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11850, 5, 0);
                    return;
                case 7:
                    Intent intent5 = new Intent();
                    if (isTransparent()) {
                        intent5.putExtra("key_is_hide_progress", true);
                    }
                    intent5.putExtra("key_func_info", mallFunction);
                    com.tencent.mm.br.c.b(this, "recharge", ".ui.RechargeUI", intent5);
                    return;
                case 8:
                    Intent intent6 = new Intent();
                    intent6.putExtra("BaseScanUI_select_scan_mode", 1);
                    com.tencent.mm.br.c.b(getContext(), "scanner", ".ui.BaseScanUI", intent6);
                    return;
                case 9:
                    com.tencent.mm.br.c.V(getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
                    return;
                default:
                    return;
            }
        } else {
            Log.i("MicroMsg.MallIndexBaseUI", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", mallFunction.egX);
            c.fSg().aVv(mallFunction.kHR);
            com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().aVv(mallFunction.kHR);
            if (mallFunction.Icf != null) {
                c.fSg();
                c.i(mallFunction);
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        removeSceneEndListener(d.CTRL_INDEX);
        t.fQP();
        ah.b(this);
        super.onDestroy();
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        w wVar;
        Log.d("MicroMsg.MallIndexBaseUI", "onOtherSceneEnd");
        if (qVar instanceof com.tencent.mm.plugin.wallet_core.c.b.a) {
            Log.d("MicroMsg.MallIndexBaseUI", "hy: query bound scene end");
            if (i2 != 0 || i3 != 0) {
                finish();
                return true;
            } else if (this.zlo) {
                this.zlo = false;
                if (t.fQD().fRN().fRm()) {
                    com.tencent.mm.wallet_core.a.b(this, "PayUOpenProcess", null);
                    return true;
                }
            }
        }
        switch (qVar.getType()) {
            case d.CTRL_INDEX:
                f fVar = (f) qVar;
                if (fVar.zjs != this.zjs) {
                    Log.i("MicroMsg.MallIndexBaseUI", "pass wallet local: %d cgi: %d", Integer.valueOf(this.zjs), Integer.valueOf(fVar.zjs));
                }
                if (isTransparent()) {
                    Log.d("MicroMsg.MallIndexBaseUI", "errorType:%d | errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (i2 == 0 && i3 == 0 && fVar.zjo != null) {
                        if (getIntent().getIntExtra("key_scene", 0) == 1) {
                            MallFunction fs = fs(fVar.zjo);
                            if (fs != null) {
                                a(fs, -1);
                            }
                        } else if (!Util.isNullOrNil(this.yUq)) {
                            Log.d("MicroMsg.MallIndexBaseUI", "NativeUrl: %s", this.yUq);
                            MallFunction ft = ft(fVar.zjo);
                            if (ft != null) {
                                a(ft, -1);
                            } else {
                                egY();
                                return true;
                            }
                        } else if (fVar.zjo != null && fVar.zjo.size() > 0) {
                            Log.i("MicroMsg.MallIndexBaseUI", "functionScene.mFunctionList != null");
                            a(fs(fVar.zjo), -1);
                        } else if (k.egL().Qe(this.zjs) == null || k.egL().Qe(this.zjs).size() <= 0) {
                            Log.e("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() == null");
                        } else {
                            Log.i("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() != null");
                            a(fs(k.egL().Qe(this.zjs)), -1);
                        }
                        setResult(-1);
                        finish();
                    } else {
                        egY();
                    }
                } else {
                    if (i2 == 0 && i3 == 0 && k.egL().Qe(this.zjs) != null && fVar.zjo != null) {
                        this.zjo = k.egL().Qe(this.zjs);
                        Log.i("MicroMsg.MallIndexBaseUI", "get from server now! " + this.zjs + " " + this.zjo.size());
                        c.fSg().aW(this.zjo);
                        if (!Util.isNullOrNil(this.zjo)) {
                            LinkedList linkedList = new LinkedList();
                            Iterator<MallFunction> it = this.zjo.iterator();
                            while (it.hasNext()) {
                                MallFunction next = it.next();
                                if (!Util.isNullOrNil(next.egX)) {
                                    linkedList.add(next.egX);
                                }
                            }
                            if (!Util.isNullOrNil(linkedList) && (wVar = (w) g.af(w.class)) != null) {
                                wVar.bg(linkedList);
                            }
                        }
                    }
                    updateView();
                    egX();
                    egZ();
                }
                return true;
            default:
                return false;
        }
    }

    private MallFunction fs(List<MallFunction> list) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(this.zjn)) {
            return null;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            MallFunction mallFunction = list.get(i2);
            if (mallFunction != null && this.zjn.equals(mallFunction.kHR)) {
                return mallFunction;
            }
        }
        return null;
    }

    private MallFunction ft(List<MallFunction> list) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(this.yUq)) {
            return null;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            MallFunction mallFunction = list.get(i2);
            if (mallFunction != null && this.yUq.equals(mallFunction.egX)) {
                return mallFunction;
            }
        }
        return null;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onProgressFinish() {
        if (isTransparent()) {
            return true;
        }
        updateView();
        return true;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean checkProcLife() {
        return false;
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(String str, Bitmap bitmap) {
    }

    private void egY() {
        setResult(0);
        finish();
    }

    public final void updateView() {
        showOptionMenu(true);
        this.zli.ax(this.zjo);
        ehd();
        ehe();
        ehf();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        Log.d("MicroMsg.MallIndexBaseUI", "index initView");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(66063);
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 3);
                com.tencent.mm.br.c.f(MallIndexBaseUI.this, "com.tencent.mm.ui.LauncherUI", intent);
                MallIndexBaseUI.this.finish();
                if (!com.tencent.mm.pluginsdk.wallet.e.gsQ()) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14954, com.tencent.mm.pluginsdk.wallet.e.gsR(), "open_wcpay_specific_view:ok");
                    com.tencent.mm.pluginsdk.wallet.e.gsS();
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14419, MallIndexBaseUI.this.uuid, 6);
                Log.i("MicroMsg.MallIndexBaseUI", "set BackBtn");
                AppMethodBeat.o(66063);
                return true;
            }
        });
        this.zlh = (ListView) findViewById(R.id.f77);
        initHeaderView();
        egZ();
        this.zli = new b(this, this.zjs);
        this.zlh.setAdapter((ListAdapter) this.zli);
        this.zli.zkf = new b.d() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:15:0x0084  */
            @Override // com.tencent.mm.plugin.mall.ui.b.d
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(final int r11, final com.tencent.mm.plugin.wallet_core.model.mall.MallFunction r12) {
                /*
                // Method dump skipped, instructions count: 484
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.AnonymousClass2.a(int, com.tencent.mm.plugin.wallet_core.model.mall.MallFunction):void");
            }
        };
        eq(this.vbj);
        this.zlm = (TextView) findViewById(R.id.a2b);
        eha();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void ehc() {
        if (z.aUo()) {
            com.tencent.mm.wallet_core.a.b(getContext(), "PayURemittanceProcess", null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pay_channel", 1);
        com.tencent.mm.wallet_core.a.b(getContext(), "RemittanceProcess", bundle);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        super.finish();
    }

    private void ehe() {
        if (this.zlg != null) {
            this.zlg.setVisibility(8);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.wallet_core.model.l
    public final void j(int i2, Object[] objArr) {
        if (i2 == 12 && this.zll != null) {
            ehb();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1) {
            g.aAi();
            this.zjs = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
            if (i3 != -1) {
                return;
            }
            if (z.aUp()) {
                finish();
                return;
            }
            finish();
            sd sdVar = new sd();
            sdVar.dYH.context = getContext();
            EventCenter.instance.publish(sdVar);
        }
    }
}
