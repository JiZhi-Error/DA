package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bb.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class BrandServiceLocalSearchUI extends MMActivity implements b.a, BrandServiceSortView.a {
    private b poM;
    private BrandServiceSortView poN;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(5666);
        super.onCreate(bundle);
        setActionbarColor(android.support.v4.content.b.n(getContext(), R.color.a2r));
        initView();
        g.azz().a(new n(18), 0);
        AppMethodBeat.o(5666);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnA() {
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnB() {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(5667);
        this.poN = (BrandServiceSortView) findViewById(R.id.i2h);
        this.poN.setMode(1);
        this.poN.setReturnResult(getIntent().getBooleanExtra("is_return_result", false));
        this.poN.gLV();
        this.poN.BF(false);
        this.poN.setShowFooterView(false);
        this.poN.setITransferToChildOnTouchListener(this);
        this.poM = new b();
        this.poM.CK(true);
        this.poM.a((b.a) this);
        this.poM.jxF = false;
        AppMethodBeat.o(5667);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnz() {
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bny() {
        AppMethodBeat.i(5668);
        finish();
        AppMethodBeat.o(5668);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void SO(String str) {
        AppMethodBeat.i(5669);
        Log.i("MicroMsg.BrandServiceLocalSearchUI", "search biz, key word : %s", str);
        this.poN.bmm(str);
        AppMethodBeat.o(5669);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final boolean SN(String str) {
        AppMethodBeat.i(5670);
        hideVKB();
        AppMethodBeat.o(5670);
        return true;
    }

    @Override // com.tencent.mm.modelvoiceaddr.ui.b.a
    public final void biM() {
        AppMethodBeat.i(5671);
        hideVKB();
        AppMethodBeat.o(5671);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(5672);
        super.onPause();
        this.poM.cancel();
        this.poM.clearFocus();
        AppMethodBeat.o(5672);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(5673);
        super.onDestroy();
        this.poN.release();
        AppMethodBeat.o(5673);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(5674);
        this.poM.a((FragmentActivity) this, menu);
        AppMethodBeat.o(5674);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(5675);
        this.poM.a((Activity) this, menu);
        AppMethodBeat.o(5675);
        return true;
    }

    @Override // com.tencent.mm.modelvoiceaddr.ui.b.a
    public final void a(boolean z, String[] strArr, long j2, int i2) {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ln;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.a
    public final boolean clY() {
        AppMethodBeat.i(5676);
        hideVKB();
        AppMethodBeat.o(5676);
        return false;
    }
}
