package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.d;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.mall.a.f;
import com.tencent.mm.plugin.mall.a.k;
import com.tencent.mm.plugin.mall.ui.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class MallIndexBaseUIv2 extends WalletBaseUI implements u.a, l {
    private RelativeLayout hOX;
    protected String uuid;
    protected View vbj;
    private String yUq = null;
    private String zjn = null;
    private ArrayList<MallFunction> zjo = null;
    protected int zjs;
    private TextView zlg = null;
    protected ListView zlh = null;
    protected ImageView zlk;
    protected TextView zll = null;
    protected TextView zlm;
    private int zln = 0;
    protected View zlq;
    private boolean zlr = false;
    private c zlw = null;
    private ArrayList<bfv> zlx = null;

    /* access modifiers changed from: protected */
    public abstract void dYP();

    /* access modifiers changed from: protected */
    public abstract void egS();

    /* access modifiers changed from: protected */
    public abstract void egT();

    /* access modifiers changed from: protected */
    public abstract boolean egV();

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
    public abstract void ehg();

    /* access modifiers changed from: protected */
    public abstract int ehh();

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
        Log.i("MicorMsg.MallIndexBaseUIv2", "onCreate");
        super.onCreate(bundle);
        if (!g.aAc()) {
            Log.v("MicorMsg.MallIndexBaseUIv2", "MMCore is not ready");
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
        addSceneEndListener(4362);
        t.fQP();
        ah.a(this);
        this.zjn = getIntent().getStringExtra("key_func_id");
        Log.i("MicorMsg.MallIndexBaseUIv2", "mFuncId:" + this.zjn + " wallet_region: " + this.zjs + " walletType: " + z.aUf() + " default_region: " + intValue);
        this.yUq = getIntent().getStringExtra("key_native_url");
        Log.i("MicorMsg.MallIndexBaseUIv2", "mNativeUrl:" + this.yUq);
        if (isTransparent()) {
            Log.i("MicorMsg.MallIndexBaseUIv2", "Oncreate：isTransparent()");
            return;
        }
        dYP();
        setContentViewVisibility(0);
        egS();
        initView();
        c.fSj();
        egT();
        if (z.aUo()) {
            Log.e("MicorMsg.MallIndexBaseUIv2", "it is payu account ,not initFingerPrint");
        } else {
            a aVar = (a) g.af(a.class);
            if (aVar != null) {
                Log.i("MicorMsg.MallIndexBaseUIv2", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
                aVar.dJN();
            } else {
                Log.e("MicorMsg.MallIndexBaseUIv2", "IFingerPrintMgr is not null");
            }
        }
        ab.mg(1, 0);
        h.INSTANCE.a(11850, 1, 0);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        boolean z = true;
        super.onResume();
        com.tencent.mm.pluginsdk.wallet.h.setPayChannel(1);
        Log.i("MicorMsg.MallIndexBaseUIv2", "onResume");
        if (!g.aAc()) {
            Log.v("MicorMsg.MallIndexBaseUIv2", "MMCore is not ready");
            finish();
        }
        if (!isTransparent() && this.hOX != null) {
            this.hOX.post(new Runnable() {
                /* class com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(213554);
                    a.j(MallIndexBaseUIv2.this);
                    MallIndexBaseUIv2.this.updateView();
                    AppMethodBeat.o(213554);
                }
            });
        }
        if (isTransparent()) {
            this.zjo = k.egL().Qe(this.zjs);
            if (this.zjo == null || this.zjo.size() <= 0) {
                Log.i("MicorMsg.MallIndexBaseUIv2", "mFunctionList == null");
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
                    Log.printErrStackTrace("MicorMsg.MallIndexBaseUIv2", e2, "", new Object[0]);
                    egY();
                }
            } else {
                MallFunction fs = fs(this.zjo);
                if (fs == null) {
                    fs = ft(this.zjo);
                }
                c(fs);
                finish();
            }
        } else {
            egV();
            Log.d("MicorMsg.MallIndexBaseUIv2", "initFunctionList");
            if (b.fSd().size() == 0) {
                Log.e("MicorMsg.MallIndexBaseUIv2", "funcitonlist invalid");
                doSceneProgress(new com.tencent.mm.plugin.mall.a.g(this.zjs), true);
                z = false;
            } else {
                Log.i("MicorMsg.MallIndexBaseUIv2", "funcitonlist has cache");
                doSceneProgress(new com.tencent.mm.plugin.mall.a.g(this.zjs), false);
                this.zlx = b.fSd();
            }
            if (z) {
                Log.i("MicorMsg.MallIndexBaseUIv2", "has data");
                updateView();
                ehk();
            }
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        Log.d("MicorMsg.MallIndexBaseUIv2", "index initView");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(213555);
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 3);
                com.tencent.mm.br.c.f(MallIndexBaseUIv2.this, "com.tencent.mm.ui.LauncherUI", intent);
                MallIndexBaseUIv2.this.finish();
                if (!e.gsQ()) {
                    h.INSTANCE.a(14954, e.gsR(), "open_wcpay_specific_view:ok");
                    e.gsS();
                }
                h.INSTANCE.a(14419, MallIndexBaseUIv2.this.uuid, 6);
                Log.i("MicorMsg.MallIndexBaseUIv2", "set BackBtn");
                AppMethodBeat.o(213555);
                return true;
            }
        });
        this.hOX = (RelativeLayout) findViewById(R.id.h93);
        this.zlh = (ListView) findViewById(R.id.f77);
        initHeaderView();
        egZ();
        this.zlw = new c(this);
        this.zlh.setAdapter((ListAdapter) this.zlw);
        this.zlw.zkK = new c.d() {
            /* class com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.mall.ui.c.d
            public final void a(final int i2, final bfv bfv) {
                AppMethodBeat.i(213558);
                if (bfv != null) {
                    if (!b.a.aVs(new StringBuilder().append(bfv.LPr.Nuz).toString()) && !Util.isNullOrNil(bfv.LPw)) {
                        Log.i("MicorMsg.MallIndexBaseUIv2", "onFunctionItemClick show disclaimer funcId=%s", new StringBuilder().append(bfv.LPr.Nuz).toString());
                        if (!MallIndexBaseUIv2.this.a(bfv, i2)) {
                            d.a aVar = new d.a(MallIndexBaseUIv2.this.getContext());
                            String string = MallIndexBaseUIv2.this.getString(R.string.exz);
                            String string2 = MallIndexBaseUIv2.this.getString(R.string.w0);
                            aVar.bon(string);
                            aVar.boo(bfv.LPw);
                            aVar.bou(string2).c(new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2.AnonymousClass3.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(213556);
                                    Log.i("MicorMsg.MallIndexBaseUIv2", "onFunctionItemClick: onClick");
                                    b.a.aVr(new StringBuilder().append(bfv.LPr.Nuz).toString());
                                    MallIndexBaseUIv2.a(MallIndexBaseUIv2.this, bfv, i2);
                                    AppMethodBeat.o(213556);
                                }
                            });
                            aVar.Dk(true);
                            aVar.f(new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2.AnonymousClass3.AnonymousClass2 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(213557);
                                    Log.i("MicorMsg.MallIndexBaseUIv2", "onFunctionItemClick: onCancel");
                                    b.a.aVr(new StringBuilder().append(bfv.LPr.Nuz).toString());
                                    AppMethodBeat.o(213557);
                                }
                            });
                            aVar.hbn().show();
                        }
                    } else {
                        MallIndexBaseUIv2.a(MallIndexBaseUIv2.this, bfv, i2);
                    }
                    Log.d("MicorMsg.MallIndexBaseUIv2", "type: %s", Integer.valueOf(bfv.LPy));
                    h.INSTANCE.a(14419, MallIndexBaseUIv2.this.uuid, 4, Integer.valueOf(bfv.LPy));
                    AppMethodBeat.o(213558);
                    return;
                }
                Log.w("MicorMsg.MallIndexBaseUIv2", "onFunctionItemClick functionItem null; pos=%d", Integer.valueOf(i2));
                AppMethodBeat.o(213558);
            }
        };
        eq(this.vbj);
        this.zlm = (TextView) findViewById(R.id.a2b);
        eha();
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isTransparent() {
        if (!Util.isNullOrNil(this.zjn) || !Util.isNullOrNil(this.yUq)) {
            return true;
        }
        return false;
    }

    private void egX() {
        boolean booleanExtra = getIntent().getBooleanExtra("key_wallet_has_red", false);
        if (this.zlh.getChildCount() != 0) {
            int firstVisiblePosition = this.zlh.getFirstVisiblePosition();
            int top = this.zlh.getChildAt(0).getTop();
            Log.i("MicorMsg.MallIndexBaseUIv2", "initCheckNew %s fpos %s top %s", Boolean.valueOf(booleanExtra), Integer.valueOf(firstVisiblePosition), Integer.valueOf(top));
            if (firstVisiblePosition == 0 && top == 0 && booleanExtra && !this.zlr && this.zlx != null) {
                this.zlr = true;
                int headerViewsCount = this.zlh.getHeaderViewsCount() + this.zlw.getCount();
                Log.i("MicorMsg.MallIndexBaseUIv2", "mFunctionsGv.getHeaderViewsCount()： %s mFunctionAdapter.getCount(): %s", Integer.valueOf(this.zlh.getHeaderViewsCount()), Integer.valueOf(this.zlw.getCount()));
                List<ArrayList<c.C1470c>> list = this.zlw.zke;
                if (list != null) {
                    for (int size = list.size() - 1; size > 0; size--) {
                        Iterator<c.C1470c> it = list.get(size).iterator();
                        while (it.hasNext()) {
                            c.C1470c next = it.next();
                            if (!(next == null || next.zkP == null || !c.a(next.zkP))) {
                                int firstVisiblePosition2 = this.zlh.getFirstVisiblePosition();
                                int lastVisiblePosition = this.zlh.getLastVisiblePosition();
                                Log.i("MicorMsg.MallIndexBaseUIv2", "get listview show top %s bottom %s redPos: %d", Integer.valueOf(firstVisiblePosition2), Integer.valueOf(lastVisiblePosition), Integer.valueOf(headerViewsCount));
                                if (headerViewsCount < firstVisiblePosition2 || headerViewsCount > lastVisiblePosition) {
                                    int egM = ((headerViewsCount + 1) * a.egM()) + ehh() + (b.fSb().get(next.zkP.LPy).intValue() * (com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 48) + com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 8)));
                                    int i2 = ao.az(this).y;
                                    if (ao.aA(this)) {
                                        i2 -= ao.aD(this);
                                    }
                                    if (getSupportActionBar() != null) {
                                        i2 -= getSupportActionBar().getHeight();
                                    }
                                    this.zlh.smoothScrollBy(((egM - i2) - this.zlh.getScrollY()) + (a.egM() / 3), 1000);
                                    Log.i("MicorMsg.MallIndexBaseUIv2", "offset function is %s, groupName is %s", next.zkP.LPr.Name, Integer.valueOf(next.zkP.LPy));
                                    return;
                                }
                                Log.i("MicorMsg.MallIndexBaseUIv2", "the last redDot item is visible");
                                return;
                            }
                        }
                        headerViewsCount--;
                    }
                }
            }
        }
    }

    private void c(MallFunction mallFunction) {
        if (mallFunction == null || Util.isNullOrNil(mallFunction.egX) || !((s) g.af(s.class)).n(mallFunction.egX, null)) {
            int f2 = d.f(mallFunction);
            Log.i("MicorMsg.MallIndexBaseUIv2", "functionType : ".concat(String.valueOf(f2)));
            switch (f2) {
                case 0:
                    d(mallFunction);
                    ab.mg(15, 0);
                    return;
                case 1:
                    e(mallFunction);
                    return;
                case 2:
                    ehj();
                    return;
                case 3:
                    ehi();
                    return;
                default:
                    return;
            }
        } else {
            Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", mallFunction.egX);
            com.tencent.mm.plugin.wallet_core.model.mall.c.fSg().aVv(mallFunction.kHR);
            com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().aVv(mallFunction.kHR);
            if (mallFunction.Icf != null) {
                com.tencent.mm.plugin.wallet_core.model.mall.c.fSg();
                com.tencent.mm.plugin.wallet_core.model.mall.c.i(mallFunction);
            }
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        Log.d("MicorMsg.MallIndexBaseUIv2", "onSceneEnd :%s", Integer.valueOf(qVar.getType()));
        if (qVar.getType() == 4362) {
            com.tencent.mm.plugin.mall.a.g gVar = (com.tencent.mm.plugin.mall.a.g) qVar;
            if (gVar.zjs != this.zjs) {
                Log.i("MicorMsg.MallIndexBaseUIv2", "pass wallet local: %d cgi: %d", Integer.valueOf(this.zjs), Integer.valueOf(gVar.zjs));
            }
            if (i2 == 0 && i3 == 0) {
                this.zlx = b.fSd();
                Log.i("MicorMsg.MallIndexBaseUIv2", "get from server now! " + this.zjs + " " + this.zlx.size());
                com.tencent.mm.plugin.wallet_core.model.mall.c.fSg().aX(this.zlx);
                fu(this.zlx);
            }
            updateView();
            egX();
            egZ();
            ehk();
            return true;
        } else if (qVar.getType() != 495) {
            return false;
        } else {
            f fVar = (f) qVar;
            if (fVar.zjs != this.zjs) {
                Log.i("MicorMsg.MallIndexBaseUIv2", "pass wallet local: %d cgi: %d", Integer.valueOf(this.zjs), Integer.valueOf(fVar.zjs));
            }
            if (!isTransparent()) {
                return true;
            }
            Log.d("MicorMsg.MallIndexBaseUIv2", "errorType:%d | errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 == 0 && i3 == 0 && fVar.zjo != null) {
                if (getIntent().getIntExtra("key_scene", 0) == 1) {
                    MallFunction fs = fs(fVar.zjo);
                    if (fs != null) {
                        c(fs);
                    }
                } else if (!Util.isNullOrNil(this.yUq)) {
                    Log.d("MicorMsg.MallIndexBaseUIv2", "NativeUrl: %s", this.yUq);
                    MallFunction ft = ft(fVar.zjo);
                    if (ft != null) {
                        c(ft);
                    } else {
                        egY();
                        return true;
                    }
                } else if (fVar.zjo != null && fVar.zjo.size() > 0) {
                    Log.i("MicorMsg.MallIndexBaseUIv2", "functionScene.mFunctionList != null");
                    c(fs(fVar.zjo));
                } else if (k.egL().Qe(this.zjs) == null || k.egL().Qe(this.zjs).size() <= 0) {
                    Log.e("MicorMsg.MallIndexBaseUIv2", "SubCoreMall.getCore().getFunctionList() == null");
                } else {
                    Log.i("MicorMsg.MallIndexBaseUIv2", "SubCoreMall.getCore().getFunctionList() != null");
                    c(fs(k.egL().Qe(this.zjs)));
                }
                setResult(-1);
                finish();
                return true;
            }
            egY();
            return true;
        }
    }

    public final void updateView() {
        showOptionMenu(true);
        if (this.zlw != null) {
            this.zlw.ax(this.zlx);
        }
        ehd();
        ehg();
        ehe();
        ehf();
    }

    private void ehe() {
        if (this.zlg != null) {
            this.zlg.setVisibility(8);
        }
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

    private void d(MallFunction mallFunction) {
        Intent intent = new Intent();
        if (isTransparent()) {
            intent.putExtra("key_is_hide_progress", true);
        }
        intent.putExtra("key_func_info", mallFunction);
        com.tencent.mm.br.c.b(this, "recharge", ".ui.PhoneRechargeUI", intent);
    }

    private void e(MallFunction mallFunction) {
        g.aAi();
        this.zjs = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
        Intent intent = new Intent();
        intent.putExtra("rawUrl", mallFunction.h5Url);
        intent.putExtra("geta8key_username", z.aTY());
        intent.putExtra("pay_channel", 1);
        intent.putExtra("KPublisherId", "pay_wallet");
        intent.putExtra("key_download_restrict", mallFunction.Ich);
        intent.putExtra("key_wallet_region", this.zjs);
        intent.putExtra("key_function_id", mallFunction.kHR);
        intent.putExtra(e.p.OzJ, true);
        intent.putExtra("geta8key_scene", 46);
        com.tencent.mm.wallet_core.ui.f.aA(getContext(), intent);
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

    private void ehi() {
        Log.w("MicorMsg.MallIndexBaseUIv2", "doSelectFunction do nothing");
        com.tencent.mm.ui.base.u.makeText(this, "fuction list error", 1).show();
    }

    private static void ehj() {
        Log.w("MicorMsg.MallIndexBaseUIv2", "doSelectFunction no jump");
    }

    private void egY() {
        setResult(0);
        finish();
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        removeSceneEndListener(com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.CTRL_INDEX);
        removeSceneEndListener(4362);
        t.fQP();
        ah.b(this);
        super.onDestroy();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        super.finish();
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

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void shouldFixStatusBar() {
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void setStatusColor() {
    }

    private static void fu(List<bfv> list) {
        if (!(list == null || list.isEmpty())) {
            LinkedList linkedList = new LinkedList();
            for (bfv bfv : list) {
                if (bfv.LPt != null && bfv.LPt.type == 2 && bfv.LPt.Nuy != null && !TextUtils.isEmpty(bfv.LPt.Nuy.username)) {
                    linkedList.add(bfv.LPt.Nuy.username);
                }
            }
            if (!linkedList.isEmpty()) {
                ((w) g.af(w.class)).bh(linkedList);
            }
        }
    }

    public final boolean a(bfv bfv, int i2) {
        String str;
        int size;
        int i3;
        if (!(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_dialog_optimize_switch, 1) == 1)) {
            Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunctionByAppBrand clicfg_appbrand_dialog_optimize_switch close");
            return false;
        } else if (bfv.LPt != null || bfv.LPt.type == 2) {
            if (bfv != null && i2 >= 0) {
                if (bfv.LPs == null || Util.isNullOrNil(new StringBuilder().append(bfv.LPs.Nus).toString())) {
                    str = "";
                } else {
                    str = Long.toString(((long) bfv.LPs.Nus) & Util.MAX_32BIT_VALUE);
                }
                if (this.zlx == null) {
                    size = 0;
                } else {
                    size = this.zlx.size();
                }
                boolean a2 = c.a(bfv);
                SparseArray<ArrayList<Integer>> fSe = com.tencent.mm.plugin.wallet_core.model.mall.b.fSe();
                if (fSe.size() != 0) {
                    long j2 = (long) bfv.LPy;
                    ArrayList<Integer> arrayList = fSe.get(bfv.LPy);
                    int size2 = arrayList.size();
                    int i4 = 0;
                    while (true) {
                        i3 = i4;
                        if (i3 >= arrayList.size()) {
                            i3 = 0;
                            break;
                        }
                        Integer num = arrayList.get(i3);
                        if (num != null && num.compareTo(Integer.valueOf(bfv.LPr.Nuz)) == 0) {
                            break;
                        }
                        i4 = i3 + 1;
                    }
                    Log.i("MicorMsg.MallIndexBaseUIv2", "click report activityId:%s,FunctionID：%s", str, Long.toString(((long) bfv.LPr.Nuz) & Util.MAX_32BIT_VALUE));
                    h hVar = h.INSTANCE;
                    Object[] objArr = new Object[10];
                    objArr[0] = Long.toString(((long) bfv.LPr.Nuz) & Util.MAX_32BIT_VALUE);
                    objArr[1] = Integer.valueOf(size);
                    objArr[2] = 0;
                    objArr[3] = Integer.valueOf(i2);
                    objArr[4] = str;
                    objArr[5] = Integer.valueOf(a2 ? 2 : 1);
                    objArr[6] = 2;
                    objArr[7] = Long.valueOf(j2);
                    objArr[8] = Integer.valueOf(size2);
                    objArr[9] = Integer.valueOf(i3);
                    hVar.a(10881, objArr);
                }
            }
            com.tencent.mm.plugin.wallet_core.model.mall.c.fSg().aVv(new StringBuilder().append(bfv.LPr.Nuz).toString());
            com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().aVv(new StringBuilder().append(bfv.LPr.Nuz).toString());
            if (bfv.LPs != null) {
                MallFunction mallFunction = new MallFunction();
                mallFunction.kHR = new StringBuilder().append(bfv.LPr.Nuz).toString();
                mallFunction.edq = bfv.LPr.Name;
                mallFunction.Icf = new MallNews(mallFunction.kHR);
                mallFunction.Icf.FJm = new StringBuilder().append(bfv.LPs.Nus).toString();
                com.tencent.mm.plugin.wallet_core.model.mall.c.fSg();
                com.tencent.mm.plugin.wallet_core.model.mall.c.i(mallFunction);
            }
            Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunctionNew id：%s，name：%s，type：%s", Integer.valueOf(bfv.LPr.Nuz), bfv.LPr.Name, Integer.valueOf(bfv.LPt.type));
            Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunctionNew functionItem.Entrance.URLWeApp.username：%s,functionItem.Entrance.URLWeApp.pagepath:%s,functionItem.Entrance.URLWeApp.version:%s", bfv.LPt.Nuy.username, bfv.LPt.Nuy.Cqk, Integer.valueOf(bfv.LPt.Nuy.version));
            com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
            gVar.username = bfv.LPt.Nuy.username;
            gVar.version = bfv.LPt.Nuy.version;
            gVar.kHw = bfv.LPt.Nuy.Cqk;
            gVar.iOo = 0;
            gVar.scene = 1019;
            String string = getString(R.string.exz);
            String string2 = getString(R.string.w0);
            WeAppOpenDeclarePromptBundle weAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte) 0);
            weAppOpenDeclarePromptBundle.fuQ = 2;
            weAppOpenDeclarePromptBundle.kHS = string;
            weAppOpenDeclarePromptBundle.kHT = bfv.LPw;
            weAppOpenDeclarePromptBundle.kHU = string2;
            weAppOpenDeclarePromptBundle.ox = false;
            weAppOpenDeclarePromptBundle.kHR = new StringBuilder().append(bfv.LPr.Nuz).toString();
            gVar.kHJ = weAppOpenDeclarePromptBundle;
            ((r) g.af(r.class)).a(getContext(), gVar);
            return true;
        } else {
            Log.i("MicorMsg.MallIndexBaseUIv2", "functionItem.Entrance == null");
            return false;
        }
    }

    private void ehk() {
        int count;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int lastVisiblePosition = this.zlh.getLastVisiblePosition();
        if (lastVisiblePosition > this.zlh.getHeaderViewsCount()) {
            if (lastVisiblePosition <= this.zlh.getHeaderViewsCount() + this.zlw.getCount()) {
                count = lastVisiblePosition - this.zlh.getHeaderViewsCount();
            } else {
                count = this.zlw.getCount();
            }
            List<ArrayList<c.C1470c>> list = this.zlw.zke;
            for (int i2 = 0; i2 < count; i2++) {
                Iterator<c.C1470c> it = list.get(i2).iterator();
                while (it.hasNext()) {
                    c.C1470c next = it.next();
                    if (next != null) {
                        sb.append(Long.toString(((long) next.zkP.LPr.Nuz) & Util.MAX_32BIT_VALUE));
                        sb.append(";");
                    }
                }
            }
            if (count - 1 >= 0) {
                int intValue = com.tencent.mm.plugin.wallet_core.model.mall.b.fSb().get(list.get(count - 1).get(0).zkP.LPy).intValue();
                ArrayList<Integer> fSc = com.tencent.mm.plugin.wallet_core.model.mall.b.fSc();
                for (int i3 = 0; i3 < intValue; i3++) {
                    sb2.append(fSc.get(i3));
                    sb2.append(";");
                }
                Log.i("MicorMsg.MallIndexBaseUIv2", "exposure report productID：%s、groupId：%s", sb, sb2);
                h.INSTANCE.a(20548, sb, sb2);
            }
        }
    }

    static /* synthetic */ void a(MallIndexBaseUIv2 mallIndexBaseUIv2, bfv bfv, int i2) {
        String str;
        int size;
        int i3;
        if (bfv.LPt == null) {
            Log.i("MicorMsg.MallIndexBaseUIv2", "functionItem.Entrance == null");
            return;
        }
        if (bfv != null && i2 >= 0) {
            if (bfv.LPs == null || Util.isNullOrNil(new StringBuilder().append(bfv.LPs.Nus).toString())) {
                str = "";
            } else {
                str = Long.toString(((long) bfv.LPs.Nus) & Util.MAX_32BIT_VALUE);
            }
            if (mallIndexBaseUIv2.zlx == null) {
                size = 0;
            } else {
                size = mallIndexBaseUIv2.zlx.size();
            }
            boolean a2 = c.a(bfv);
            SparseArray<ArrayList<Integer>> fSe = com.tencent.mm.plugin.wallet_core.model.mall.b.fSe();
            if (fSe.size() != 0) {
                long j2 = (long) bfv.LPy;
                ArrayList<Integer> arrayList = fSe.get(bfv.LPy);
                if (arrayList != null) {
                    int size2 = arrayList.size();
                    int i4 = 0;
                    while (true) {
                        i3 = i4;
                        if (i3 >= arrayList.size()) {
                            i3 = 0;
                            break;
                        }
                        Integer num = arrayList.get(i3);
                        if (num != null && num.compareTo(Integer.valueOf(bfv.LPr.Nuz)) == 0) {
                            break;
                        }
                        i4 = i3 + 1;
                    }
                    Log.i("MicorMsg.MallIndexBaseUIv2", "click report activityId:%s,FunctionID：%s", str, Long.toString(((long) bfv.LPr.Nuz) & Util.MAX_32BIT_VALUE));
                    h hVar = h.INSTANCE;
                    Object[] objArr = new Object[10];
                    objArr[0] = Long.toString(((long) bfv.LPr.Nuz) & Util.MAX_32BIT_VALUE);
                    objArr[1] = Integer.valueOf(size);
                    objArr[2] = 0;
                    objArr[3] = Integer.valueOf(i2);
                    objArr[4] = str;
                    objArr[5] = Integer.valueOf(a2 ? 2 : 1);
                    objArr[6] = 2;
                    objArr[7] = Long.valueOf(j2);
                    objArr[8] = Integer.valueOf(size2);
                    objArr[9] = Integer.valueOf(i3);
                    hVar.a(10881, objArr);
                }
            }
        }
        com.tencent.mm.plugin.wallet_core.model.mall.c.fSg().aVv(new StringBuilder().append(bfv.LPr.Nuz).toString());
        com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().aVv(new StringBuilder().append(bfv.LPr.Nuz).toString());
        if (bfv.LPs != null) {
            MallFunction mallFunction = new MallFunction();
            mallFunction.kHR = new StringBuilder().append(bfv.LPr.Nuz).toString();
            mallFunction.edq = bfv.LPr.Name;
            mallFunction.Icf = new MallNews(mallFunction.kHR);
            mallFunction.Icf.FJm = new StringBuilder().append(bfv.LPs.Nus).toString();
            com.tencent.mm.plugin.wallet_core.model.mall.c.fSg();
            com.tencent.mm.plugin.wallet_core.model.mall.c.i(mallFunction);
        }
        Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunctionNew id：%s，name：%s，type：%s", Integer.valueOf(bfv.LPr.Nuz), bfv.LPr.Name, Integer.valueOf(bfv.LPt.type));
        switch (bfv.LPt.type) {
            case 0:
                if ("wxpay://bizmall/mobile_recharge".equals(bfv.LPt.Nuw)) {
                    MallFunction mallFunction2 = new MallFunction();
                    mallFunction2.kHR = new StringBuilder().append(bfv.LPr.Nuz).toString();
                    mallFunction2.edq = bfv.LPr.Name;
                    Intent intent = new Intent();
                    intent.putExtra("key_func_info", mallFunction2);
                    intent.putExtra("key_need_show_remind_dialog", false);
                    com.tencent.mm.br.c.b(mallIndexBaseUIv2, "recharge", ".ui.PhoneRechargeUI", intent);
                    ab.mg(15, 0);
                    return;
                }
                return;
            case 1:
                Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunctionNew functionItem.Entrance.URLHtml：%s", bfv.LPt.Nux);
                g.aAi();
                mallIndexBaseUIv2.zjs = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", bfv.LPt.Nux);
                intent2.putExtra("geta8key_username", z.aTY());
                intent2.putExtra("pay_channel", 1);
                intent2.putExtra("KPublisherId", "pay_wallet");
                intent2.putExtra("key_download_restrict", bfv.LPv);
                intent2.putExtra("key_wallet_region", mallIndexBaseUIv2.zjs);
                intent2.putExtra("key_function_id", new StringBuilder().append(bfv.LPr.Nuz).toString());
                intent2.putExtra(e.p.OzJ, true);
                intent2.putExtra("geta8key_scene", 46);
                com.tencent.mm.wallet_core.ui.f.aA(mallIndexBaseUIv2.getContext(), intent2);
                return;
            case 2:
                Log.i("MicorMsg.MallIndexBaseUIv2", "handleFunctionNew functionItem.Entrance.URLWeApp.username：%s,functionItem.Entrance.URLWeApp.pagepath:%s,functionItem.Entrance.URLWeApp.version:%s", bfv.LPt.Nuy.username, bfv.LPt.Nuy.Cqk, Integer.valueOf(bfv.LPt.Nuy.version));
                com.tencent.mm.wallet_core.ui.f.u(bfv.LPt.Nuy.username, bfv.LPt.Nuy.Cqk, bfv.LPt.Nuy.version, 1019);
                return;
            default:
                Log.i("MicorMsg.MallIndexBaseUIv2", "unknown entrance type");
                return;
        }
    }
}
