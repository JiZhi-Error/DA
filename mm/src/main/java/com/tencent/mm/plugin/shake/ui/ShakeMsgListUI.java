package com.tencent.mm.plugin.shake.ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.l;

public class ShakeMsgListUI extends MMActivity {
    private int AAs = 0;
    private int AAt = 0;
    private g DjP = null;
    private d DjQ;
    private ListView DjR;
    private int from;
    private int limit = 0;
    private int mType;
    private long oNJ;
    private o.g plk = new o.g() {
        /* class com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.AnonymousClass6 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(28428);
            g gVar = ShakeMsgListUI.this.DjP;
            Log.i("MicroMsg.ShakeMessageStorage", "delBySvrId = ".concat(String.valueOf(gVar.db.delete(gVar.getTableName(), "svrid = '" + String.valueOf(ShakeMsgListUI.this.oNJ) + "'", null))));
            ShakeMsgListUI.this.DjQ.onNotifyChange(null, null);
            AppMethodBeat.o(28428);
        }
    };
    private TextView qzz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ShakeMsgListUI() {
        AppMethodBeat.i(28429);
        AppMethodBeat.o(28429);
    }

    static /* synthetic */ void c(ShakeMsgListUI shakeMsgListUI) {
        AppMethodBeat.i(28436);
        shakeMsgListUI.eUU();
        AppMethodBeat.o(28436);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(28430);
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("shake_msg_type", 0);
        this.DjP = m.eUn();
        this.AAt = this.DjP.ctM();
        this.limit = this.AAt == 0 ? 8 : this.AAt;
        this.AAs = this.DjP.getCount();
        this.from = getIntent().getIntExtra("shake_msg_from", 1);
        if (this.from == 1) {
            h.INSTANCE.a(11313, Integer.valueOf(this.AAt), e.eVk());
        } else {
            h.INSTANCE.a(11315, Integer.valueOf(this.AAt), e.eVk());
        }
        g gVar = this.DjP;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        gVar.db.update(gVar.getTableName(), contentValues, "status!=? ", new String[]{"1"});
        initView();
        AppMethodBeat.o(28430);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(28431);
        super.onResume();
        if (this.AAs != this.DjP.getCount()) {
            this.AAs = this.DjP.getCount();
            if (this.AAs == 0) {
                eUU();
            }
            this.DjQ.anp();
        }
        this.DjQ.notifyDataSetChanged();
        AppMethodBeat.o(28431);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(28432);
        this.DjQ.ebf();
        super.onDestroy();
        AppMethodBeat.o(28432);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.brr;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(28433);
        setMMTitle(getIntent().getStringExtra("shake_msg_list_title"));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(28422);
                ShakeMsgListUI.this.hideVKB();
                ShakeMsgListUI.this.finish();
                AppMethodBeat.o(28422);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.t2), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(28424);
                com.tencent.mm.ui.base.h.a((Context) ShakeMsgListUI.this.getContext(), true, ShakeMsgListUI.this.getString(R.string.gz2), "", ShakeMsgListUI.this.getString(R.string.gax), ShakeMsgListUI.this.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.AnonymousClass2.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(28423);
                        g gVar = ShakeMsgListUI.this.DjP;
                        gVar.db.delete(gVar.getTableName(), null, null);
                        ShakeMsgListUI.this.DjQ.anp();
                        ShakeMsgListUI.c(ShakeMsgListUI.this);
                        AppMethodBeat.o(28423);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.AnonymousClass2.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(28424);
                return true;
            }
        });
        this.qzz = (TextView) findViewById(R.id.c30);
        if (this.AAs == 0) {
            eUU();
        }
        this.DjR = (ListView) findViewById(R.id.ho0);
        final View inflate = getLayoutInflater().inflate(R.layout.bnk, (ViewGroup) null);
        inflate.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(28425);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ShakeMsgListUI.this.limit += 8;
                ShakeMsgListUI.this.DjQ.XB(ShakeMsgListUI.this.limit);
                if (ShakeMsgListUI.this.AAs <= ShakeMsgListUI.this.limit) {
                    ShakeMsgListUI.this.DjR.removeFooterView(inflate);
                }
                a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28425);
            }
        });
        if (this.AAs > 0 && this.limit < this.AAs) {
            this.DjR.addFooterView(inflate);
        }
        this.DjQ = new d(this);
        this.DjQ.DjM = this.limit;
        this.DjR.setAdapter((ListAdapter) this.DjQ);
        this.DjR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(28426);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                f fVar = (f) ShakeMsgListUI.this.DjQ.getItem(i2);
                if (!Util.isNullOrNil(fVar.field_tag)) {
                    h.INSTANCE.kvStat(11316, ShakeMsgListUI.this.from + "," + fVar.field_tag);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", fVar.field_tag);
                    c.b(ShakeMsgListUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
                a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeMsgListUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(28426);
            }
        });
        final l lVar = new l(this);
        this.DjR.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.AnonymousClass5 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(28427);
                if (i2 < ShakeMsgListUI.this.DjR.getHeaderViewsCount()) {
                    Log.w("MicroMsg.ShakeMsgListUI", "on header view long click, ignore");
                    AppMethodBeat.o(28427);
                } else {
                    lVar.a(view, i2, j2, ShakeMsgListUI.this.getContext(), ShakeMsgListUI.this.plk);
                    AppMethodBeat.o(28427);
                }
                return true;
            }
        });
        AppMethodBeat.o(28433);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(28434);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        this.oNJ = ((f) this.DjQ.getItem(adapterContextMenuInfo.position)).field_svrid;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.string.tf);
        AppMethodBeat.o(28434);
    }

    private void eUU() {
        AppMethodBeat.i(28435);
        this.qzz.setText(R.string.gz3);
        this.qzz.setVisibility(0);
        enableOptionMenu(false);
        AppMethodBeat.o(28435);
    }
}
