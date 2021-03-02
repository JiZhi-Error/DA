package com.tencent.mm.plugin.brandservice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.j;
import com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer;
import com.tencent.mm.protocal.protobuf.dkz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import java.util.LinkedList;

public class SearchOrRecommendBizUI extends MMActivity implements BizSearchResultItemContainer.b {
    private int gwE = 0;
    private BizSearchResultItemContainer pnY;
    private ProgressDialog pqa = null;
    private int pqb = 0;
    private SearchViewNotRealTimeHelper pqc;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ya;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(5787);
        super.onCreate(bundle);
        this.pqb = getIntent().getIntExtra("intent_extra_entry_flag", 0);
        this.gwE = getIntent().getIntExtra("fromScene", 0);
        initView();
        if (j.clP()) {
            g.azz().a(456, new i() {
                /* class com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI.AnonymousClass1 */

                @Override // com.tencent.mm.ak.i
                public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                    boolean z;
                    AppMethodBeat.i(5779);
                    if (qVar == null) {
                        Log.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "NetScene is null.");
                        AppMethodBeat.o(5779);
                    } else if (qVar.getType() != 456) {
                        Log.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "The NetScene is not a RecommendGroupNetScene.");
                        AppMethodBeat.o(5779);
                    } else {
                        g.azz().b(456, this);
                        Log.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 == 0 && i3 == 0) {
                            LinkedList<dkz> clQ = j.clQ();
                            final g gVar = SearchOrRecommendBizUI.this.pnY == null ? null : (g) SearchOrRecommendBizUI.this.pnY.getAdapter();
                            if (!(gVar == null || clQ == null || clQ.size() <= 0)) {
                                if (gVar.getCount() == 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                gVar.ppW = clQ;
                                if (z) {
                                    MMHandlerThread.postToMainThread(new Runnable() {
                                        /* class com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(5778);
                                            Log.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "Has got recommend groups, so notifyDataSetChanged.");
                                            gVar.notifyDataSetChanged();
                                            AppMethodBeat.o(5778);
                                        }
                                    });
                                }
                            }
                        }
                        AppMethodBeat.o(5779);
                    }
                }
            });
            g.azz().a(new j(), 0);
        }
        final String stringExtra = getIntent().getStringExtra("Search_Str");
        if (!Util.isNullOrNil(stringExtra)) {
            new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(5780);
                    SearchOrRecommendBizUI.this.pqc.setSearchContent(stringExtra);
                    SearchOrRecommendBizUI.this.pqc.Qwv.performClick();
                    AppMethodBeat.o(5780);
                }
            });
        }
        AppMethodBeat.o(5787);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(5788);
        super.onDestroy();
        ag.bas().aZX();
        AppMethodBeat.o(5788);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(5789);
        setMMTitle(R.string.bi9);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(5781);
                SearchOrRecommendBizUI.this.hideVKB();
                SearchOrRecommendBizUI.this.finish();
                AppMethodBeat.o(5781);
                return true;
            }
        });
        this.pqc = (SearchViewNotRealTimeHelper) findViewById(R.id.hf7);
        this.pqc.setSearchColor(getResources().getColor(R.color.a2x));
        this.pqc.setSearchHint(getString(R.string.bi9));
        this.pqc.setSearchHintColor(getResources().getColor(R.color.ui));
        this.pqc.setSearchIcon(0);
        this.pqc.setShowBackIcon(false);
        this.pqc.setCallBack(new SearchViewNotRealTimeHelper.a() {
            /* class com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a
            public final boolean SN(String str) {
                AppMethodBeat.i(5783);
                ahN(str);
                AppMethodBeat.o(5783);
                return true;
            }

            @Override // com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a
            public final void ahN(String str) {
                AppMethodBeat.i(5784);
                if (!Util.isNullOrNil(str)) {
                    SearchOrRecommendBizUI.this.hideVKB();
                    SearchOrRecommendBizUI.this.pnY.cH(str, 0);
                    AppMethodBeat.o(5784);
                    return;
                }
                h.cD(SearchOrRecommendBizUI.this.getContext(), SearchOrRecommendBizUI.this.getString(R.string.bi6));
                AppMethodBeat.o(5784);
            }

            @Override // com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a
            public final void cmh() {
                AppMethodBeat.i(5785);
                SearchOrRecommendBizUI.this.showVKB();
                AppMethodBeat.o(5785);
            }
        });
        this.pnY = (BizSearchResultItemContainer) findViewById(R.id.hd6);
        this.pnY.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI.AnonymousClass4 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(5782);
                SearchOrRecommendBizUI.this.pqc.clearFocus();
                SearchOrRecommendBizUI.this.hideVKB();
                AppMethodBeat.o(5782);
                return false;
            }
        });
        g gVar = new g(this);
        gVar.ppW = j.clQ();
        this.pnY.setAdapter(gVar);
        this.pnY.setBusinessTypes(1);
        this.pnY.setDisplayArgs$25decb5(false);
        this.pnY.setMode(1);
        this.pnY.setScene(this.gwE);
        this.pnY.setIOnSearchStateChangedListener(this);
        AppMethodBeat.o(5789);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.b
    public final void clW() {
        AppMethodBeat.i(5790);
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.pqa = h.a((Context) context, getString(R.string.bi7), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI.AnonymousClass6 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(5786);
                BizSearchResultItemContainer bizSearchResultItemContainer = SearchOrRecommendBizUI.this.pnY;
                g.azz().a(bizSearchResultItemContainer.pov);
                bizSearchResultItemContainer.pot.poG = false;
                AppMethodBeat.o(5786);
            }
        });
        AppMethodBeat.o(5790);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.b
    public final void clX() {
        AppMethodBeat.i(5791);
        if (this.pqa != null) {
            this.pqa.dismiss();
            this.pqa = null;
        }
        AppMethodBeat.o(5791);
    }
}
