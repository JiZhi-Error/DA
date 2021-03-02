package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.model.j;
import com.tencent.mm.plugin.collect.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cqb;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectBillUI extends WalletBaseUI {
    private int fromScene;
    private boolean iGD = false;
    private String jTK;
    private int limit = 20;
    private l mHj;
    private boolean qAa = true;
    private long qAb;
    private i qAc = new i() {
        /* class com.tencent.mm.plugin.collect.ui.CollectBillUI.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(64072);
            if (qVar instanceof j) {
                j jVar = (j) qVar;
                if (i2 == 0 && i3 == 0) {
                    LinkedList<eh> linkedList = jVar.qwi.LgB;
                    if (linkedList == null || linkedList.isEmpty()) {
                        CollectBillUI.this.qzY.setVisibility(8);
                        AppMethodBeat.o(64072);
                        return;
                    }
                    for (final eh ehVar : linkedList) {
                        if (ehVar.type == 1 && !Util.isNullOrNil(ehVar.dQx)) {
                            Log.i("MicroMsg.CollectBillUI", "show notice");
                            CollectBillUI.this.qzY.setText(ehVar.dQx);
                            CollectBillUI.this.qzY.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.collect.ui.CollectBillUI.AnonymousClass1.AnonymousClass1 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(64071);
                                    b bVar = new b();
                                    bVar.bm(view);
                                    a.b("com/tencent/mm/plugin/collect/ui/CollectBillUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    if (!Util.isNullOrNil(ehVar.url)) {
                                        f.p(CollectBillUI.this.getContext(), ehVar.url, true);
                                    }
                                    a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillUI$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(64071);
                                }
                            });
                            CollectBillUI.this.qzY.setVisibility(0);
                            AppMethodBeat.o(64072);
                            return;
                        }
                    }
                    CollectBillUI.this.qzY.setVisibility(8);
                    AppMethodBeat.o(64072);
                    return;
                }
                Log.e("MicroMsg.CollectBillUI", "net error: %s", jVar);
                CollectBillUI.this.qzY.setVisibility(8);
            }
            AppMethodBeat.o(64072);
        }
    };
    private o.g qAd = new o.g() {
        /* class com.tencent.mm.plugin.collect.ui.CollectBillUI.AnonymousClass7 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            com.tencent.mm.plugin.collect.model.a aVar;
            AppMethodBeat.i(64078);
            if (menuItem.getItemId() == 0 && (aVar = (com.tencent.mm.plugin.collect.model.a) CollectBillUI.this.qzv.getItemAtPosition(((AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo()).position)) != null) {
                CollectBillUI.a(CollectBillUI.this, aVar.qvC, aVar.timestamp);
            }
            AppMethodBeat.o(64078);
        }
    };
    private View qdm;
    private long qwd;
    private boolean qzD = false;
    private a qzR;
    private LinearLayout qzS;
    private CollectBillHeaderView qzT;
    private ImageView qzU;
    private MMSwitchBtn qzV;
    private ImageView qzW;
    private MMSwitchBtn qzX;
    private TextView qzY;
    private boolean qzZ = false;
    private ListView qzv;
    private int type;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CollectBillUI() {
        AppMethodBeat.i(64079);
        AppMethodBeat.o(64079);
    }

    static /* synthetic */ void g(CollectBillUI collectBillUI) {
        AppMethodBeat.i(64089);
        collectBillUI.cAi();
        AppMethodBeat.o(64089);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64080);
        super.onCreate(bundle);
        this.qAb = z.aUd();
        this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
        this.type = getIntent().getIntExtra("key_type", 0);
        this.qwd = getIntent().getLongExtra("key_timestamp", System.currentTimeMillis() / 1000);
        cAi();
        initView();
        setMMTitle(R.string.b6f);
        g.aAi();
        g.aAg().hqi.a(1256, this.qAc);
        j jVar = new j();
        g.aAi();
        g.aAg().hqi.a(jVar, 0);
        AppMethodBeat.o(64080);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(64081);
        super.onDestroy();
        g.aAi();
        g.aAg().hqi.b(1256, this.qAc);
        AppMethodBeat.o(64081);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64082);
        this.qzv = (ListView) findViewById(R.id.b6f);
        this.qzS = (LinearLayout) findViewById(R.id.b62);
        this.qzY = (TextView) findViewById(R.id.b5z);
        this.qdm = aa.jQ(this).inflate(R.layout.v2, (ViewGroup) this.qzv, false);
        this.qzT = new CollectBillHeaderView(this);
        this.qzv.addHeaderView(this.qzT, null, false);
        this.qzR = new a(this);
        this.qzv.setAdapter((ListAdapter) this.qzR);
        this.qzv.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectBillUI.AnonymousClass2 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(64073);
                if (CollectBillUI.this.qzv.getLastVisiblePosition() == CollectBillUI.this.qzR.getCount() && CollectBillUI.this.qzR.getCount() > 0 && !CollectBillUI.this.iGD && !CollectBillUI.this.qzD) {
                    CollectBillUI.f(CollectBillUI.this);
                    CollectBillUI.g(CollectBillUI.this);
                }
                AppMethodBeat.o(64073);
            }
        });
        this.mHj = new l(this);
        this.qzv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectBillUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(64074);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/collect/ui/CollectBillUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (i2 < 0 || i2 >= adapterView.getAdapter().getCount()) {
                    Log.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", Integer.valueOf(i2), Integer.valueOf(adapterView.getAdapter().getCount()));
                    a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(64074);
                    return;
                }
                com.tencent.mm.plugin.collect.model.a aVar = (com.tencent.mm.plugin.collect.model.a) CollectBillUI.this.qzv.getItemAtPosition(i2);
                if (aVar == null) {
                    Log.w("MicroMsg.CollectBillUI", "invalid position: %d", Integer.valueOf(i2));
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("scene", 2);
                    intent.putExtra("trans_id", aVar.qvD);
                    intent.putExtra("bill_id", aVar.qvC);
                    c.b(CollectBillUI.this.getContext(), "order", ".ui.MallOrderTransactionInfoUI", intent);
                }
                a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(64074);
            }
        });
        this.qzv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectBillUI.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(64075);
                if (i2 < 0 || i2 >= adapterView.getAdapter().getCount()) {
                    Log.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", Integer.valueOf(i2), Integer.valueOf(adapterView.getAdapter().getCount()));
                    AppMethodBeat.o(64075);
                    return false;
                }
                CollectBillUI.this.mHj.a(view, i2, j2, CollectBillUI.this, CollectBillUI.this.qAd);
                AppMethodBeat.o(64075);
                return true;
            }
        });
        if (this.fromScene != 2) {
            addTextOptionMenu(0, getString(R.string.b6b), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.collect.ui.CollectBillUI.AnonymousClass5 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(64076);
                    Intent intent = new Intent(CollectBillUI.this.getContext(), CollectBillListUI.class);
                    CollectBillUI collectBillUI = CollectBillUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    a.a(collectBillUI, bl.axQ(), "com/tencent/mm/plugin/collect/ui/CollectBillUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    collectBillUI.startActivity((Intent) bl.pG(0));
                    a.a(collectBillUI, "com/tencent/mm/plugin/collect/ui/CollectBillUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(64076);
                    return false;
                }
            });
        }
        if (this.fromScene == 2) {
            View findViewById = this.qzT.findViewById(R.id.b7u);
            View findViewById2 = this.qzS.findViewById(R.id.b7t);
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            AppMethodBeat.o(64082);
            return;
        }
        this.qzU = (ImageView) this.qzT.findViewById(R.id.b7r);
        this.qzV = (MMSwitchBtn) this.qzT.findViewById(R.id.b7s);
        this.qzW = (ImageView) this.qzS.findViewById(R.id.b7r);
        this.qzX = (MMSwitchBtn) this.qzS.findViewById(R.id.b7s);
        com.tencent.mm.plugin.collect.a.a.czp();
        if (com.tencent.mm.plugin.collect.a.a.czr()) {
            this.qzV.setCheck(true);
            this.qzX.setCheck(true);
            this.qzU.setImageResource(R.raw.collect_sound_on);
            this.qzW.setImageResource(R.raw.collect_sound_on);
        } else {
            this.qzV.setCheck(false);
            this.qzX.setCheck(false);
            this.qzU.setImageResource(R.raw.collect_sound_off);
            this.qzW.setImageResource(R.raw.collect_sound_off);
        }
        AnonymousClass6 r0 = new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.collect.ui.CollectBillUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                int i2;
                AppMethodBeat.i(64077);
                Log.i("MicroMsg.CollectBillUI", "update switch: %B", Boolean.valueOf(z));
                CollectBillUI.this.qzV.setCheck(z);
                CollectBillUI.this.qzX.setCheck(z);
                if (z) {
                    CollectBillUI.this.qAb |= 32768;
                    CollectBillUI.this.qzU.setImageResource(R.raw.collect_sound_on);
                    CollectBillUI.this.qzW.setImageResource(R.raw.collect_sound_on);
                    Toast.makeText(CollectBillUI.this.getContext(), (int) R.string.b70, 1).show();
                    h.INSTANCE.a(13944, 11);
                    i2 = 1;
                } else {
                    CollectBillUI.this.qAb &= -32769;
                    CollectBillUI.this.qzU.setImageResource(R.raw.collect_sound_off);
                    CollectBillUI.this.qzW.setImageResource(R.raw.collect_sound_off);
                    Toast.makeText(CollectBillUI.this.getContext(), (int) R.string.b6q, 1).show();
                    h.INSTANCE.a(13944, 12);
                    i2 = 2;
                }
                g.aAi();
                g.aAh().azQ().set(147457, Long.valueOf(CollectBillUI.this.qAb));
                cqb cqb = new cqb();
                cqb.Cyb = i2;
                ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(209, cqb));
                if (i2 == 1) {
                    com.tencent.mm.plugin.collect.a.a.czp().czs();
                    AppMethodBeat.o(64077);
                    return;
                }
                com.tencent.mm.plugin.collect.a.a.czp().czt();
                AppMethodBeat.o(64077);
            }
        };
        this.qzV.setSwitchListener(r0);
        this.qzX.setSwitchListener(r0);
        AppMethodBeat.o(64082);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(64083);
        contextMenu.add(0, 0, 0, R.string.b6c);
        AppMethodBeat.o(64083);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64084);
        if (qVar instanceof s) {
            s sVar = (s) qVar;
            if (this.qzZ) {
                this.qzv.removeFooterView(this.qdm);
                this.qzZ = false;
            }
            if (i2 == 0 && i3 == 0) {
                this.iGD = sVar.iGD;
                this.type = sVar.type;
                this.qwd = sVar.qwd;
                h(sVar.qwe, sVar.dKt, sVar.qwd);
                if (!sVar.qwH.isEmpty()) {
                    if (Util.isNullOrNil(this.jTK)) {
                        Log.d("MicroMsg.CollectBillUI", "first query, hide block view");
                        this.qzv.setVisibility(0);
                        this.qzS.setVisibility(8);
                    }
                    a aVar = this.qzR;
                    aVar.qzs.addAll(sVar.qwH);
                    aVar.notifyDataSetChanged();
                    this.jTK = sVar.qwH.get(sVar.qwH.size() - 1).qvC;
                } else {
                    this.iGD = true;
                    if (Util.isNullOrNil(this.jTK)) {
                        Log.i("MicroMsg.CollectBillUI", "no record, show empty view");
                        bIo();
                    }
                }
                this.qzD = false;
                AppMethodBeat.o(64084);
                return true;
            }
            Log.i("MicroMsg.CollectBillUI", "net error!");
            this.qzD = false;
            Toast.makeText(this, (int) R.string.b69, 1).show();
            if (Util.isNullOrNil(this.jTK)) {
                Log.i("MicroMsg.CollectBillUI", "first query failed, finish activity!");
            }
            AppMethodBeat.o(64084);
            return true;
        } else if (qVar instanceof com.tencent.mm.plugin.collect.model.q) {
            com.tencent.mm.plugin.collect.model.q qVar2 = (com.tencent.mm.plugin.collect.model.q) qVar;
            if (i2 == 0 && i3 == 0) {
                a aVar2 = this.qzR;
                String str2 = qVar2.qvC;
                Iterator<com.tencent.mm.plugin.collect.model.a> it = aVar2.qzs.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.tencent.mm.plugin.collect.model.a next = it.next();
                    if (next.qvC.equals(str2)) {
                        aVar2.qzs.remove(next);
                        aVar2.notifyDataSetChanged();
                        break;
                    }
                }
                if (this.qzR.getCount() <= 0) {
                    Log.i("MicroMsg.CollectBillUI", "delete all records");
                    bIo();
                } else {
                    h(qVar2.qwe, qVar2.dKt, this.qwd);
                }
                AppMethodBeat.o(64084);
                return false;
            }
            Log.i("MicroMsg.CollectBillUI", "net error, errType: %s, errCode: %s, errMsg: %s, billId: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar2.qvC);
            Toast.makeText(this, (int) R.string.b68, 1).show();
            AppMethodBeat.o(64084);
            return false;
        } else {
            AppMethodBeat.o(64084);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.uv;
    }

    private void h(int i2, int i3, long j2) {
        AppMethodBeat.i(64085);
        if (this.qAa) {
            this.qzT.b(i2, i3, j2, this.type);
            this.qAa = false;
        }
        AppMethodBeat.o(64085);
    }

    private void cAi() {
        AppMethodBeat.i(64086);
        if (!this.iGD) {
            doSceneForceProgress(new s(this.type, this.qwd, this.jTK, this.limit));
            this.qzD = true;
        }
        AppMethodBeat.o(64086);
    }

    private void bIo() {
        AppMethodBeat.i(64087);
        this.qzv.setVisibility(8);
        this.qzS.setVisibility(0);
        findViewById(R.id.b63).setVisibility(0);
        AppMethodBeat.o(64087);
    }

    static /* synthetic */ void f(CollectBillUI collectBillUI) {
        AppMethodBeat.i(64088);
        if (!collectBillUI.qzZ) {
            Log.d("MicroMsg.CollectBillUI", "show loading");
            collectBillUI.qzv.addFooterView(collectBillUI.qdm, null, false);
            collectBillUI.qzZ = true;
        }
        AppMethodBeat.o(64088);
    }

    static /* synthetic */ void a(CollectBillUI collectBillUI, String str, long j2) {
        AppMethodBeat.i(64090);
        Log.i("MicroMsg.CollectBillUI", "do delete, billid: %s, timestamp: %s", str, Long.valueOf(j2));
        com.tencent.mm.plugin.collect.model.q qVar = new com.tencent.mm.plugin.collect.model.q(str, collectBillUI.type, j2);
        collectBillUI.qAa = true;
        collectBillUI.doSceneForceProgress(qVar);
        AppMethodBeat.o(64090);
    }
}
