package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class EnterpriseBizSearchUI extends MMActivity implements b.a, EnterpriseBizContactListView.d {
    private b poM;
    private EnterpriseBizContactListView poR;
    private String ppO;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(5742);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(5742);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(5743);
        super.onDestroy();
        if (this.poR != null) {
            EnterpriseBizContactListView.release();
        }
        AppMethodBeat.o(5743);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnA() {
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnB() {
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnz() {
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bny() {
        AppMethodBeat.i(5745);
        finish();
        AppMethodBeat.o(5745);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void SO(String str) {
        AppMethodBeat.i(5746);
        Log.i("MicroMsg.EnterpriseBizSearchUI", "search biz, key word : %s", str);
        this.poR.bmm(str);
        AppMethodBeat.o(5746);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final boolean SN(String str) {
        AppMethodBeat.i(5747);
        hideVKB();
        AppMethodBeat.o(5747);
        return true;
    }

    @Override // com.tencent.mm.modelvoiceaddr.ui.b.a
    public final void biM() {
        AppMethodBeat.i(5748);
        hideVKB();
        AppMethodBeat.o(5748);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(5749);
        super.onPause();
        this.poM.cancel();
        this.poM.clearFocus();
        AppMethodBeat.o(5749);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(5750);
        this.poM.a((FragmentActivity) this, menu);
        AppMethodBeat.o(5750);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(5751);
        this.poM.a((Activity) this, menu);
        AppMethodBeat.o(5751);
        return true;
    }

    @Override // com.tencent.mm.modelvoiceaddr.ui.b.a
    public final void a(boolean z, String[] strArr, long j2, int i2) {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a3z;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.d
    public final boolean clY() {
        AppMethodBeat.i(5752);
        hideVKB();
        AppMethodBeat.o(5752);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(5744);
        if (Util.isNullOrNil(this.ppO)) {
            this.ppO = getIntent().getStringExtra("enterprise_biz_name");
            if (Util.isNullOrNil(this.ppO)) {
                finish();
            }
        }
        this.poR = (EnterpriseBizContactListView) findViewById(R.id.i2h);
        this.poR.setFatherBizName(this.ppO);
        this.poR.setExcludeBizChat(true);
        this.poR.refresh();
        this.poR.setMode(1);
        this.poR.clZ();
        this.poR.gLV();
        this.poR.BF(false);
        this.poR.setOnTouchListener(this);
        ((TextView) this.poR.getNoResultView()).setText(R.string.bxr);
        this.poM = new b();
        this.poM.CK(true);
        this.poM.a((b.a) this);
        this.poM.jxF = false;
        AppMethodBeat.o(5744);
    }
}
