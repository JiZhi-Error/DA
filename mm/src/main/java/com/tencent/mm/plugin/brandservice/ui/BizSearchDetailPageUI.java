package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer;
import com.tencent.mm.plugin.brandservice.ui.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.protocal.protobuf.sb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.tools.s;
import java.io.IOException;
import java.util.LinkedList;

public class BizSearchDetailPageUI extends MMActivity implements s.b {
    private int fs;
    private int gwE;
    private s mSearchViewHelper;
    private BizSearchResultItemContainer pnY;
    private long pnZ;
    private String poa;
    private int pob;
    private Runnable poc = new Runnable() {
        /* class com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(5613);
            BizSearchDetailPageUI.this.pnY.cH(BizSearchDetailPageUI.this.poa, BizSearchDetailPageUI.this.fs);
            BizSearchDetailPageUI.this.fs = 0;
            AppMethodBeat.o(5613);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BizSearchDetailPageUI() {
        AppMethodBeat.i(5617);
        AppMethodBeat.o(5617);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.jl;
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnA() {
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnB() {
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        ru ruVar;
        boolean z;
        AppMethodBeat.i(5618);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(5614);
                BizSearchDetailPageUI.this.finish();
                AppMethodBeat.o(5614);
                return true;
            }
        });
        Intent intent = getIntent();
        this.pnZ = intent.getLongExtra("businessType", 0);
        boolean booleanExtra = intent.getBooleanExtra("showEditText", false);
        this.gwE = intent.getIntExtra("fromScene", 0);
        this.pob = intent.getIntExtra("addContactScene", 35);
        String stringExtra = intent.getStringExtra("title");
        String stringExtra2 = intent.getStringExtra("keyword");
        boolean booleanExtra2 = intent.getBooleanExtra("showCatalog", false);
        this.fs = intent.getIntExtra("offset", 0);
        if (this.pnZ == 0 || Util.isNullOrNil(stringExtra2)) {
            Log.e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", Long.valueOf(this.pnZ));
            finish();
            AppMethodBeat.o(5618);
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("result");
        boolean z2 = false;
        if (byteArrayExtra != null) {
            try {
                ru ruVar2 = (ru) new ru().parseFrom(byteArrayExtra);
                if (ruVar2 != null) {
                    z2 = true;
                }
                ruVar = ruVar2;
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.BrandService.BizSearchDetailPageUI", e2, "", new Object[0]);
                finish();
                AppMethodBeat.o(5618);
                return;
            }
        } else {
            ruVar = null;
        }
        this.pnY = (BizSearchResultItemContainer) findViewById(R.id.hd6);
        this.pnY.setAdapter(new c(this));
        this.pnY.setBusinessTypes(this.pnZ);
        this.pnY.setMode(1);
        this.pnY.setDisplayArgs$25decb5(booleanExtra2);
        this.pnY.setScene(this.gwE);
        this.pnY.setAddContactScene(this.pob);
        this.pnY.setReporter(new c.b() {
            /* class com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.brandservice.ui.c.b
            public final void a(c cVar, a aVar, int i2, String str, int i3, int i4) {
                AppMethodBeat.i(5615);
                if (BizSearchDetailPageUI.this.gwE == 1 && aVar.type == 5) {
                    sb sbVar = (sb) aVar.getData();
                    if (sbVar.KZG == null || sbVar.KZG.KZe == null) {
                        Log.e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
                        AppMethodBeat.o(5615);
                        return;
                    }
                    ru CX = cVar.CX(i4);
                    String str2 = Util.nullAsNil(BizSearchDetailPageUI.this.poa) + "," + i2 + "," + Util.nullAsNil(str) + "," + i3 + "," + cVar.poi + "," + (CX == null ? "" : CX.KZj + ",1");
                    h.INSTANCE.kvStat(10866, str2);
                    Log.d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : ".concat(String.valueOf(str2)));
                    if ((sbVar.KZG.KZe.MmK & 8) > 0) {
                        h.INSTANCE.kvStat(10298, str + ",35");
                    }
                }
                AppMethodBeat.o(5615);
            }
        });
        if (booleanExtra) {
            this.mSearchViewHelper = new s();
            addSearchMenu(true, this.mSearchViewHelper);
            this.mSearchViewHelper.CK(false);
            this.mSearchViewHelper.clearFocus();
            this.mSearchViewHelper.setSearchContent(stringExtra2);
            this.mSearchViewHelper.Qwi = this;
            this.pnY.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI.AnonymousClass4 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(5616);
                    if (BizSearchDetailPageUI.this.mSearchViewHelper != null) {
                        BizSearchDetailPageUI.this.mSearchViewHelper.clearFocus();
                    }
                    BizSearchDetailPageUI.this.hideVKB();
                    AppMethodBeat.o(5616);
                    return false;
                }
            });
        } else if (!Util.isNullOrNil(stringExtra)) {
            setMMTitle(stringExtra);
        }
        if (z2) {
            BizSearchResultItemContainer bizSearchResultItemContainer = this.pnY;
            int i2 = this.fs;
            bizSearchResultItemContainer.reset();
            if (ruVar == null) {
                Log.e("MicroMsg.BrandService.BizSearchResultItemContainer", "setFirst page content failed, content is null.");
                AppMethodBeat.o(5618);
                return;
            }
            bizSearchResultItemContainer.pot.dDv = stringExtra2;
            bizSearchResultItemContainer.setBusinessTypes(ruVar.KZg);
            bizSearchResultItemContainer.pot.continueFlag = ruVar.KZh;
            bizSearchResultItemContainer.poy = i2;
            LinkedList linkedList = new LinkedList();
            linkedList.add(ruVar);
            bizSearchResultItemContainer.poq.m(stringExtra2, linkedList);
            bizSearchResultItemContainer.pot.offset = i2 + ruVar.KZk;
            BizSearchResultItemContainer.c cVar = bizSearchResultItemContainer.pot;
            if (!bizSearchResultItemContainer.poq.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            cVar.isSearchMode = z;
            AppMethodBeat.o(5618);
            return;
        }
        SO(stringExtra2);
        AppMethodBeat.o(5618);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(5619);
        if (this.mSearchViewHelper != null) {
            this.mSearchViewHelper.a((FragmentActivity) this, menu);
        }
        AppMethodBeat.o(5619);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(5620);
        if (this.mSearchViewHelper != null) {
            this.mSearchViewHelper.a((Activity) this, menu);
        }
        AppMethodBeat.o(5620);
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(5621);
        super.onPause();
        if (this.mSearchViewHelper != null) {
            this.mSearchViewHelper.clearFocus();
        }
        AppMethodBeat.o(5621);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final boolean SN(String str) {
        return false;
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void SO(String str) {
        AppMethodBeat.i(5622);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(5622);
            return;
        }
        String trim = str.trim();
        if (!trim.equals(this.poa)) {
            MMHandlerThread.removeRunnable(this.poc);
            this.poa = trim;
            MMHandlerThread.postToMainThreadDelayed(this.poc, 400);
        }
        AppMethodBeat.o(5622);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bny() {
        AppMethodBeat.i(5623);
        finish();
        AppMethodBeat.o(5623);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnz() {
    }
}
