package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.appbrand.a.i;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.din;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

public class WxaLuckyMoneyDetailUI extends WxaLuckyMoneyBaseUI implements b {
    private View agA;
    private TextView jVn;
    private TextView nAB;
    private q tipDialog = null;
    private TextView yQk;
    private final a yQq = new d();
    private Intent yQr = null;
    private ListView yQs;
    private ImageView yQt;
    private TextView yQu;
    private ImageView yQv;
    private View yQw;
    private View yQx;
    private c yQy;
    private AbsListView.OnScrollListener yQz = new AbsListView.OnScrollListener() {
        /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI.AnonymousClass1 */
        private boolean yQA = false;
        private boolean yQB;

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(64912);
            if (absListView.getCount() == 0) {
                AppMethodBeat.o(64912);
                return;
            }
            switch (i2) {
                case 0:
                    if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                        WxaLuckyMoneyDetailUI.this.yQq.PB(absListView.getCount());
                    }
                    this.yQA = false;
                    AppMethodBeat.o(64912);
                    return;
                case 1:
                    this.yQA = true;
                    break;
            }
            AppMethodBeat.o(64912);
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            int i5;
            boolean z = true;
            AppMethodBeat.i(64913);
            if (i4 == 0 || !this.yQA) {
                AppMethodBeat.o(64913);
                return;
            }
            if (i2 <= 0) {
                View childAt = absListView.getChildAt(i2);
                if (childAt != null) {
                    i5 = 0 - childAt.getTop();
                } else {
                    i5 = 0;
                }
                if (i5 <= 100) {
                    z = false;
                }
            }
            if (this.yQB != z) {
                if (z) {
                    WxaLuckyMoneyDetailUI.a(WxaLuckyMoneyDetailUI.this, WxaLuckyMoneyDetailUI.this.getResources().getDrawable(R.drawable.cbq));
                } else {
                    WxaLuckyMoneyDetailUI.b(WxaLuckyMoneyDetailUI.this);
                }
                this.yQB = z;
            }
            AppMethodBeat.o(64913);
        }
    };
    private TextView yln;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WxaLuckyMoneyDetailUI() {
        AppMethodBeat.i(64916);
        AppMethodBeat.o(64916);
    }

    static /* synthetic */ void a(WxaLuckyMoneyDetailUI wxaLuckyMoneyDetailUI, Drawable drawable) {
        AppMethodBeat.i(64928);
        wxaLuckyMoneyDetailUI.A(drawable);
        AppMethodBeat.o(64928);
    }

    static /* synthetic */ void b(WxaLuckyMoneyDetailUI wxaLuckyMoneyDetailUI) {
        AppMethodBeat.i(64929);
        wxaLuckyMoneyDetailUI.A(null);
        AppMethodBeat.o(64929);
    }

    static /* synthetic */ View d(WxaLuckyMoneyDetailUI wxaLuckyMoneyDetailUI) {
        AppMethodBeat.i(64930);
        View contentView = wxaLuckyMoneyDetailUI.getContentView();
        AppMethodBeat.o(64930);
        return contentView;
    }

    static /* synthetic */ View e(WxaLuckyMoneyDetailUI wxaLuckyMoneyDetailUI) {
        AppMethodBeat.i(64931);
        View contentView = wxaLuckyMoneyDetailUI.getContentView();
        AppMethodBeat.o(64931);
        return contentView;
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.b
    public final MMActivity eeF() {
        return this;
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.b
    public final void eeG() {
        AppMethodBeat.i(64918);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(64918);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64919);
        super.onCreate(bundle);
        initView();
        this.yQq.d(this, getIntent());
        AppMethodBeat.o(64919);
    }

    @Override // android.support.v4.app.FragmentActivity
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        AppMethodBeat.i(64920);
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i2, menu);
        TextView textView = (TextView) findViewById(R.id.d9);
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.yl));
        }
        AppMethodBeat.o(64920);
        return onCreatePanelMenu;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(64921);
        if (this.yQr != null) {
            setResult(0, this.yQr);
        } else {
            setResult(-1, null);
        }
        finish();
        AppMethodBeat.o(64921);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64922);
        setMMTitle(R.string.eoh);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(64914);
                if (WxaLuckyMoneyDetailUI.this.yQr != null) {
                    WxaLuckyMoneyDetailUI.this.setResult(0, WxaLuckyMoneyDetailUI.this.yQr);
                } else {
                    WxaLuckyMoneyDetailUI.this.setResult(-1, null);
                }
                WxaLuckyMoneyDetailUI.this.finish();
                AppMethodBeat.o(64914);
                return true;
            }
        });
        this.yQs = (ListView) findViewById(R.id.ezi);
        this.yQy = new c(getContext());
        this.agA = LayoutInflater.from(this).inflate(R.layout.b3m, (ViewGroup) null);
        this.yQs.addHeaderView(this.agA);
        this.yQs.setAdapter((ListAdapter) this.yQy);
        this.yQy.yQg = false;
        this.yQs.setOnScrollListener(this.yQz);
        this.yQt = (ImageView) this.agA.findViewById(R.id.ezm);
        this.yQu = (TextView) this.agA.findViewById(R.id.f03);
        this.yQv = (ImageView) this.agA.findViewById(R.id.ez6);
        this.yln = (TextView) this.agA.findViewById(R.id.f06);
        this.yQw = this.agA.findViewById(R.id.eyr);
        this.yQk = (TextView) this.agA.findViewById(R.id.eyq);
        this.yQx = this.agA.findViewById(R.id.ez8);
        this.nAB = (TextView) this.agA.findViewById(R.id.ezz);
        this.jVn = (TextView) this.agA.findViewById(R.id.eyx);
        this.tipDialog = h.a((Context) getContext(), getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(64915);
                WxaLuckyMoneyDetailUI.this.eeG();
                if (WxaLuckyMoneyDetailUI.d(WxaLuckyMoneyDetailUI.this).getVisibility() == 8 || WxaLuckyMoneyDetailUI.e(WxaLuckyMoneyDetailUI.this).getVisibility() == 4) {
                    Log.i("MicroMsg.WxaLuckyMoneyDetailUI", "user cancel & finish");
                    WxaLuckyMoneyDetailUI.this.f(-1, null);
                }
                AppMethodBeat.o(64915);
            }
        });
        this.tipDialog.show();
        AppMethodBeat.o(64922);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b
    public final void fp(List<cai> list) {
        AppMethodBeat.i(64925);
        this.yQy.fq(list);
        AppMethodBeat.o(64925);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b
    public final void aF(Intent intent) {
        this.yQr = intent;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b3r;
    }

    private void a(i iVar) {
        AppMethodBeat.i(64926);
        AppCompatActivity context = getContext();
        af.a(this.yQt, iVar.yPH, iVar.username);
        af.a(context, this.yQu, iVar.nickname);
        af.a(context, this.yln, iVar.yPK);
        if (iVar.yPJ == 1) {
            this.yQv.setVisibility(0);
            this.yQv.setImageResource(R.drawable.cd9);
        } else {
            this.yQv.setVisibility(8);
        }
        if (iVar.yPI == 2) {
            this.yQk.setText(f.formatMoney2f(((double) iVar.eht) / 100.0d));
            this.yQy.yQg = false;
            this.yQw.setVisibility(0);
        } else {
            this.yQw.setVisibility(8);
        }
        if (!Util.isNullOrNil(iVar.yPL)) {
            this.yQx.setVisibility(0);
            this.nAB.setText(iVar.yPL);
            this.nAB.setTextColor(getResources().getColor(R.color.z7));
        } else {
            this.yQx.setVisibility(8);
        }
        if (!Util.isNullOrNil(iVar.yPM)) {
            this.jVn.setText(iVar.yPM);
            AppMethodBeat.o(64926);
            return;
        }
        this.jVn.setText((CharSequence) null);
        AppMethodBeat.o(64926);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(64927);
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(64927);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.b
    public final void error(String str) {
        AppMethodBeat.i(64917);
        h.cD(this, str);
        AppMethodBeat.o(64917);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b
    public final void a(cxg cxg) {
        i iVar;
        AppMethodBeat.i(64923);
        if (cxg == null) {
            iVar = null;
        } else {
            i iVar2 = new i();
            iVar2.username = cxg.MBJ;
            iVar2.yPH = cxg.MBL;
            iVar2.nickname = cxg.MBK;
            iVar2.eht = cxg.eht;
            iVar2.yPL = cxg.yPL;
            iVar2.yPM = cxg.yPM;
            iVar2.yPN = cxg.MBN != 0;
            iVar2.yPJ = cxg.yPJ;
            iVar2.yPI = cxg.yPI;
            iVar2.yPK = cxg.yPK;
            iVar = iVar2;
        }
        a(iVar);
        fp(cxg.MBI);
        AppMethodBeat.o(64923);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b
    public final void a(din din) {
        i iVar;
        AppMethodBeat.i(64924);
        if (din == null) {
            iVar = null;
        } else {
            i iVar2 = new i();
            iVar2.username = din.MBJ;
            iVar2.yPH = din.MBL;
            iVar2.nickname = din.MBK;
            iVar2.eht = din.eht;
            iVar2.yPL = din.yPL;
            iVar2.yPM = din.yPM;
            iVar2.yPN = din.MBN != 0;
            iVar2.yPJ = din.yPJ;
            iVar2.yPI = din.yPI;
            iVar2.yPK = din.yPK;
            iVar = iVar2;
        }
        a(iVar);
        fp(din.MBI);
        AppMethodBeat.o(64924);
    }
}
