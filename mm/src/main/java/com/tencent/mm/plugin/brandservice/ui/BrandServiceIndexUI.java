package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.q;
import com.tencent.mm.br.c;
import com.tencent.mm.cr.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.u;
import java.util.Map;

@i
public class BrandServiceIndexUI extends MMActivity implements MStorage.IOnStorageChange {
    private boolean nRl = false;
    private TextView poH = null;
    private BrandServiceSortView poI;
    private boolean poJ = false;
    private int serviceType = 251658241;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.lm;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(5659);
        super.onCreate(bundle);
        this.serviceType = getIntent().getIntExtra("intent_service_type", 251658241);
        this.poJ = u.hasAttr(getIntent().getIntExtra("list_attr", 0), 16384);
        initView();
        ag.bah().add(this);
        AppMethodBeat.o(5659);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(5660);
        if (this.nRl) {
            this.nRl = false;
            this.poI.refresh();
        }
        super.onResume();
        d.hiy();
        enableOptionMenu(1, true);
        AppMethodBeat.o(5660);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(5661);
        g.aAi();
        g.aAh().azQ().set(233474, Long.valueOf(System.currentTimeMillis()));
        g.aAi();
        g.aAh().azQ().set(233473, Long.valueOf(System.currentTimeMillis()));
        g.aAi();
        g.aAh().azQ().set(233476, Long.valueOf(System.currentTimeMillis()));
        super.onPause();
        AppMethodBeat.o(5661);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(5662);
        if (g.aAc()) {
            this.poI.release();
            ag.bah().remove(this);
        }
        super.onDestroy();
        AppMethodBeat.o(5662);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(5663);
        setMMTitle(R.string.fo);
        this.poI = (BrandServiceSortView) findViewById(R.id.i2h);
        this.poI.setShowFooterView(true);
        this.poI.setReturnResult(this.poJ);
        this.poH = (TextView) findViewById(R.id.g7n);
        this.poH.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(5654);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/brandservice/ui/BrandServiceIndexUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.a(this, "com/tencent/mm/plugin/brandservice/ui/BrandServiceIndexUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(5654);
            }
        });
        this.poH.setVisibility(8);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(5655);
                BrandServiceIndexUI.this.finish();
                AppMethodBeat.o(5655);
                return true;
            }
        });
        if (((q) g.af(q.class)).Vu()) {
            addIconOptionMenu(0, R.string.hpa, R.raw.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI.AnonymousClass3 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(5656);
                    if (BrandServiceIndexUI.this.poJ) {
                        Intent intent = new Intent(BrandServiceIndexUI.this, BrandServiceLocalSearchUI.class);
                        intent.putExtra("is_return_result", BrandServiceIndexUI.this.poJ);
                        intent.addFlags(67108864);
                        BrandServiceIndexUI.this.startActivityForResult(intent, 1);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Search_Scene", 5);
                        intent2.putExtra("detail_type", -7);
                        com.tencent.mm.plugin.fts.a.d.d(BrandServiceIndexUI.this, ".ui.FTSBizDetailUI", intent2);
                    }
                    AppMethodBeat.o(5656);
                    return true;
                }
            });
            addIconOptionMenu(1, R.string.h6, R.raw.actionbar_icon_dark_add, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI.AnonymousClass4 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(5658);
                    if (ai.afs(0)) {
                        ((com.tencent.mm.plugin.websearch.api.i) g.af(com.tencent.mm.plugin.websearch.api.i.class)).a(MMApplicationContext.getContext(), new Runnable() {
                            /* class com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(5657);
                                Intent fXX = ai.fXX();
                                fXX.putExtra("KRightBtn", true);
                                fXX.putExtra("ftsneedkeyboard", true);
                                fXX.putExtra("key_load_js_without_delay", true);
                                fXX.putExtra("ftsType", 1);
                                fXX.putExtra("ftsbizscene", 6);
                                Map<String, String> h2 = ai.h(6, true, 0);
                                String afq = ai.afq(Util.safeParseInt(h2.get("scene")));
                                h2.put("sessionId", afq);
                                h2.put("subSessionId", afq);
                                fXX.putExtra("sessionId", afq);
                                fXX.putExtra("rawUrl", ai.bd(h2));
                                c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", fXX);
                                AppMethodBeat.o(5657);
                            }
                        });
                    } else {
                        Log.e("MicroMsg.BrandService.BrandServiceIndexUI", "fts h5 template not avail");
                    }
                    BrandServiceIndexUI.this.enableOptionMenu(1, false);
                    AppMethodBeat.o(5658);
                    return true;
                }
            });
        }
        AppMethodBeat.o(5663);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(5664);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1 && this.poJ) {
            setResult(-1, intent);
            finish();
        }
        AppMethodBeat.o(5664);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(5665);
        Log.v("MicroMsg.BrandService.BrandServiceIndexUI", "On Storage Change, event : %s.", str);
        this.nRl = true;
        AppMethodBeat.o(5665);
    }
}
