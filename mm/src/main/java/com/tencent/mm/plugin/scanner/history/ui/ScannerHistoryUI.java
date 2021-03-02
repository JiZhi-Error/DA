package com.tencent.mm.plugin.scanner.history.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.scanner.model.r;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

public class ScannerHistoryUI extends MMActivity {
    private a CEv;
    private View GQ;
    private ListView mListView;
    private LinearLayout qdT;
    private View qdU;
    private TextView qdV;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(ScannerHistoryUI scannerHistoryUI) {
        AppMethodBeat.i(51608);
        scannerHistoryUI.cuE();
        AppMethodBeat.o(51608);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bny;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(51600);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(51600);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(51601);
        super.onResume();
        AppMethodBeat.o(51601);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(51602);
        super.onDestroy();
        AppMethodBeat.o(51602);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(51603);
        setMMTitle(R.string.gc_);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(51588);
                ScannerHistoryUI.this.finish();
                AppMethodBeat.o(51588);
                return true;
            }
        });
        this.mListView = (ListView) findViewById(R.id.ha5);
        this.qdT = (LinearLayout) View.inflate(getBaseContext(), R.layout.bnx, null);
        this.mListView.addHeaderView(this.qdT);
        this.CEv = new a();
        this.mListView.setAdapter((ListAdapter) this.CEv);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(51589);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/history/ui/ScannerHistoryUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (i2 == 0) {
                    Log.v("MicroMsg.ScannerHistoryUI", "onItemClick pos is 0, click headerview");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/history/ui/ScannerHistoryUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(51589);
                    return;
                }
                if (i2 > 0) {
                    i2--;
                }
                ScannerHistoryUI.a(ScannerHistoryUI.this, i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/history/ui/ScannerHistoryUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(51589);
            }
        });
        this.mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(51590);
                if (i2 == 0) {
                    Log.i("MicroMsg.ScannerHistoryUI", "onItemLongClick pos is 0");
                    AppMethodBeat.o(51590);
                } else {
                    if (i2 > 0) {
                        i2--;
                    }
                    if (i2 >= ScannerHistoryUI.this.CEv.getCount()) {
                        AppMethodBeat.o(51590);
                    } else {
                        ScannerHistoryUI.b(ScannerHistoryUI.this, i2);
                        AppMethodBeat.o(51590);
                    }
                }
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.anu), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(51591);
                ScannerHistoryUI.b(ScannerHistoryUI.this);
                AppMethodBeat.o(51591);
                return true;
            }
        });
        this.GQ = findViewById(R.id.bf4);
        this.qdU = View.inflate(this, R.layout.bnw, null);
        if (this.qdT != null) {
            this.qdT.addView(this.qdU);
        }
        this.qdV = (TextView) this.qdU.findViewById(R.id.dpp);
        this.qdV.setText(R.string.e01);
        cuE();
        AppMethodBeat.o(51603);
    }

    private void cuE() {
        AppMethodBeat.i(51604);
        if (j.eOR().eOS().getCount() > 0) {
            this.mListView.setVisibility(0);
            this.GQ.setVisibility(8);
            this.qdU.setVisibility(0);
            enableOptionMenu(true);
        } else {
            this.mListView.setVisibility(8);
            this.GQ.setVisibility(0);
            this.qdU.setVisibility(8);
            enableOptionMenu(false);
        }
        this.CEv.notifyDataSetChanged();
        AppMethodBeat.o(51604);
    }

    /* access modifiers changed from: package-private */
    public class a extends s<com.tencent.mm.plugin.scanner.history.a.a> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
        @Override // com.tencent.mm.ui.s
        public final /* synthetic */ com.tencent.mm.plugin.scanner.history.a.a a(com.tencent.mm.plugin.scanner.history.a.a aVar, Cursor cursor) {
            AppMethodBeat.i(51599);
            com.tencent.mm.plugin.scanner.history.a.a aVar2 = aVar;
            if (aVar2 == null) {
                aVar2 = new com.tencent.mm.plugin.scanner.history.a.a();
            }
            aVar2.convertFrom(cursor);
            AppMethodBeat.o(51599);
            return aVar2;
        }

        public a() {
            super(ScannerHistoryUI.this, new com.tencent.mm.plugin.scanner.history.a.a());
            AppMethodBeat.i(51595);
            Bh(true);
            AppMethodBeat.o(51595);
        }

        @Override // com.tencent.mm.ui.s
        public final void anp() {
            AppMethodBeat.i(51596);
            setCursor(j.eOR().eOS().getAll());
            notifyDataSetChanged();
            AppMethodBeat.o(51596);
        }

        @Override // com.tencent.mm.ui.s
        public final void anq() {
            AppMethodBeat.i(51597);
            ebf();
            anp();
            AppMethodBeat.o(51597);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            String str;
            AppMethodBeat.i(51598);
            com.tencent.mm.plugin.scanner.history.a.a aVar = (com.tencent.mm.plugin.scanner.history.a.a) getItem(i2);
            if (view == null) {
                view = View.inflate(ScannerHistoryUI.this.getContext(), R.layout.bnv, null);
                b bVar2 = new b(ScannerHistoryUI.this, (byte) 0);
                bVar2.kc = (ImageView) view.findViewById(R.id.e2f);
                bVar2.qdx = (TextView) view.findViewById(R.id.e40);
                bVar2.qdy = (TextView) view.findViewById(R.id.e3y);
                bVar2.qdz = (TextView) view.findViewById(R.id.e28);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            n.a fn = r.fn(aVar.field_xmlContent, aVar.field_funcType);
            bVar.qdx.setText(fn.field_title);
            bVar.qdy.setText(f.c(ScannerHistoryUI.this, aVar.field_ScanTime, true));
            bVar.qdz.setText(fn.field_subtitle);
            int dimensionPixelSize = ScannerHistoryUI.this.getResources().getDimensionPixelSize(R.dimen.ai5);
            bVar.kc.setImageResource(R.drawable.ckb);
            Log.d("MicroMsg.ScannerHistoryUI", "ScannerHistoryUI getView () position : " + i2 + " logo_url :  " + fn.field_thumburl);
            if (!TextUtils.isEmpty(fn.field_thumburl)) {
                c.a aVar2 = new c.a();
                aVar2.prefixPath = com.tencent.mm.loader.j.b.aKJ();
                q.bcW();
                aVar2.jbw = null;
                j eOR = j.eOR();
                String str2 = fn.field_thumburl;
                if (g.aAc()) {
                    str = String.format("%s/scanbook_%s", eOR.hqG + "image/scan/img", com.tencent.mm.b.g.getMessageDigest(str2.getBytes()));
                } else {
                    str = "";
                }
                aVar2.fullPath = str;
                aVar2.jbf = true;
                aVar2.iaT = false;
                aVar2.jbd = true;
                aVar2.hZA = dimensionPixelSize;
                aVar2.hZz = dimensionPixelSize;
                aVar2.jbq = R.drawable.ckb;
                q.bcV().a(fn.field_thumburl, bVar.kc, aVar2.bdv());
            } else {
                bVar.kc.setImageResource(R.drawable.ckb);
            }
            AppMethodBeat.o(51598);
            return view;
        }
    }

    class b {
        ImageView kc;
        TextView qdx;
        TextView qdy;
        TextView qdz;

        private b() {
        }

        /* synthetic */ b(ScannerHistoryUI scannerHistoryUI, byte b2) {
            this();
        }
    }

    static /* synthetic */ void a(ScannerHistoryUI scannerHistoryUI, int i2) {
        AppMethodBeat.i(51605);
        com.tencent.mm.plugin.scanner.history.a.a aVar = (com.tencent.mm.plugin.scanner.history.a.a) scannerHistoryUI.CEv.getItem(i2);
        if (aVar != null) {
            Intent intent = new Intent();
            intent.setClass(scannerHistoryUI, ProductUI.class);
            intent.setFlags(65536);
            intent.putExtra("key_Product_xml", aVar.field_xmlContent);
            intent.putExtra("key_Product_funcType", aVar.field_funcType);
            intent.putExtra("key_Qrcode_Url", aVar.field_qrcodeUrl);
            intent.putExtra("key_need_add_to_history", false);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(scannerHistoryUI, bl.axQ(), "com/tencent/mm/plugin/scanner/history/ui/ScannerHistoryUI", "OnItemClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            scannerHistoryUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(scannerHistoryUI, "com/tencent/mm/plugin/scanner/history/ui/ScannerHistoryUI", "OnItemClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            h.INSTANCE.a(12684, 0, 1);
        }
        AppMethodBeat.o(51605);
    }

    static /* synthetic */ void b(ScannerHistoryUI scannerHistoryUI, final int i2) {
        AppMethodBeat.i(51606);
        com.tencent.mm.ui.base.h.a(scannerHistoryUI, scannerHistoryUI.getResources().getString(R.string.ark), (String[]) null, scannerHistoryUI.getResources().getString(R.string.tf), new h.d() {
            /* class com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.h.d
            public final void oj(int i2) {
                AppMethodBeat.i(51592);
                switch (i2) {
                    case 0:
                        com.tencent.mm.plugin.scanner.history.a.a aVar = (com.tencent.mm.plugin.scanner.history.a.a) ScannerHistoryUI.this.CEv.getItem(i2);
                        if (aVar != null) {
                            j.eOR().eOS().delete(aVar, new String[0]);
                            ScannerHistoryUI.c(ScannerHistoryUI.this);
                            ScannerHistoryUI.this.CEv.onNotifyChange(null, null);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(51592);
            }
        });
        AppMethodBeat.o(51606);
    }

    static /* synthetic */ void b(ScannerHistoryUI scannerHistoryUI) {
        AppMethodBeat.i(51607);
        com.tencent.mm.ui.base.h.a((Context) scannerHistoryUI, true, scannerHistoryUI.getString(R.string.gc9), "", scannerHistoryUI.getString(R.string.x_), scannerHistoryUI.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(51593);
                dialogInterface.dismiss();
                j.eOR().eOS().db.execSQL("ScanHistoryItem", "delete from ScanHistoryItem");
                ScannerHistoryUI.c(ScannerHistoryUI.this);
                ScannerHistoryUI.this.CEv.onNotifyChange(null, null);
                AppMethodBeat.o(51593);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(51594);
                dialogInterface.dismiss();
                AppMethodBeat.o(51594);
            }
        });
        AppMethodBeat.o(51607);
    }
}
