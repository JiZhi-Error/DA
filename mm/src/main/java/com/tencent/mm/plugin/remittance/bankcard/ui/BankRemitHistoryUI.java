package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.remittance.bankcard.a.e;
import com.tencent.mm.plugin.remittance.bankcard.a.i;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cbs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.wallet_core.c.r;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankRemitHistoryUI extends BankRemitBaseUI implements o.g {
    private ListView CkK;
    private a CkL;
    private boolean jUW = false;
    private boolean jUX = false;
    private int limit = 20;
    private l mHj;
    private int offset = 0;
    private List<cbs> qLE = new ArrayList();
    private View rkW;

    @Override // com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BankRemitHistoryUI() {
        AppMethodBeat.i(67534);
        AppMethodBeat.o(67534);
    }

    static /* synthetic */ void e(BankRemitHistoryUI bankRemitHistoryUI) {
        AppMethodBeat.i(67542);
        bankRemitHistoryUI.fetchData();
        AppMethodBeat.o(67542);
    }

    @Override // com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67535);
        super.onCreate(bundle);
        addSceneEndListener(1511);
        addSceneEndListener(1737);
        setMMTitle(R.string.abm);
        initView();
        fetchData();
        AppMethodBeat.o(67535);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67536);
        this.CkK = (ListView) findViewById(R.id.ad9);
        this.rkW = LayoutInflater.from(this).inflate(R.layout.ad, (ViewGroup) null);
        this.mHj = new l(this);
        this.CkL = new a(this, (byte) 0);
        this.CkK.addFooterView(this.rkW);
        this.CkK.setAdapter((ListAdapter) this.CkL);
        this.CkK.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(67520);
                Log.d("MicroMsg.BankRemitHistoryUI", "click item, %s", ((cbs) adapterView.getAdapter().getItem(i2)).title);
                BankRemitHistoryUI.this.mHj.a(view, i2, j2, BankRemitHistoryUI.this, BankRemitHistoryUI.this);
                AppMethodBeat.o(67520);
                return false;
            }
        });
        this.CkK.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.AnonymousClass2 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(67521);
                if (BankRemitHistoryUI.this.CkK.getLastVisiblePosition() == BankRemitHistoryUI.this.CkK.getCount() - 1 && BankRemitHistoryUI.this.CkK.getCount() > 0 && !BankRemitHistoryUI.this.jUX && !BankRemitHistoryUI.this.jUW) {
                    BankRemitHistoryUI.e(BankRemitHistoryUI.this);
                }
                AppMethodBeat.o(67521);
            }
        });
        AppMethodBeat.o(67536);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(67537);
        contextMenu.add(0, 1, 0, R.string.ac3);
        AppMethodBeat.o(67537);
    }

    @Override // com.tencent.mm.ui.base.o.g
    public void onMMMenuItemSelected(MenuItem menuItem, int i2) {
        AppMethodBeat.i(67538);
        cbs cbs = (cbs) this.CkK.getItemAtPosition(((AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
        if (menuItem.getItemId() == 1 && cbs != null) {
            String str = cbs.KZa;
            Log.i("MicroMsg.BankRemitHistoryUI", "delete record: %s", str);
            e eVar = new e(str);
            eVar.t(this);
            doSceneProgress(eVar);
        }
        AppMethodBeat.o(67538);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(67539);
        if (qVar instanceof i) {
            final i iVar = (i) qVar;
            iVar.a(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.AnonymousClass5 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67524);
                    if (iVar.CiQ.Mff != null) {
                        Log.i("MicroMsg.BankRemitHistoryUI", "history size: %s", Integer.valueOf(iVar.CiQ.Mff.size()));
                        if (iVar.CiQ.Mff.size() < iVar.limit) {
                            Log.i("MicroMsg.BankRemitHistoryUI", "is last: %s", Integer.valueOf(BankRemitHistoryUI.this.offset));
                            BankRemitHistoryUI.this.jUX = true;
                            BankRemitHistoryUI.this.CkK.removeFooterView(BankRemitHistoryUI.this.rkW);
                        }
                        if (iVar.CiQ.Mff != null) {
                            BankRemitHistoryUI.this.offset += iVar.CiQ.Mff.size();
                            BankRemitHistoryUI.this.qLE.addAll(iVar.CiQ.Mff);
                            BankRemitHistoryUI.this.CkL.notifyDataSetChanged();
                            AppMethodBeat.o(67524);
                            return;
                        }
                    } else {
                        Log.i("MicroMsg.BankRemitHistoryUI", "return history is null");
                        BankRemitHistoryUI.this.jUX = true;
                        BankRemitHistoryUI.this.CkK.removeFooterView(BankRemitHistoryUI.this.rkW);
                    }
                    AppMethodBeat.o(67524);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.AnonymousClass4 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67523);
                    Log.e("MicroMsg.BankRemitHistoryUI", "history response error: %s, %s", Integer.valueOf(iVar.CiQ.dDN), iVar.CiQ.qwn);
                    AppMethodBeat.o(67523);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67522);
                    Log.e("MicroMsg.BankRemitHistoryUI", "net error: %s", qVar);
                    AppMethodBeat.o(67522);
                }
            });
            this.jUW = false;
        } else if (qVar instanceof e) {
            final e eVar = (e) qVar;
            eVar.a(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.AnonymousClass8 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67527);
                    BankRemitHistoryUI.a(BankRemitHistoryUI.this, eVar.qvC);
                    AppMethodBeat.o(67527);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.AnonymousClass7 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67526);
                    Log.e("MicroMsg.BankRemitHistoryUI", "history response: %s, %s", Integer.valueOf(eVar.CiM.dDN), eVar.CiM.qwn);
                    AppMethodBeat.o(67526);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.AnonymousClass6 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67525);
                    Log.e("MicroMsg.BankRemitHistoryUI", "net error: %s", qVar);
                    AppMethodBeat.o(67525);
                }
            });
        }
        AppMethodBeat.o(67539);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.f20if;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(67540);
        super.onDestroy();
        removeSceneEndListener(1511);
        removeSceneEndListener(1737);
        AppMethodBeat.o(67540);
    }

    private void fetchData() {
        AppMethodBeat.i(67541);
        Log.i("MicroMsg.BankRemitHistoryUI", "fetch data: %s, %s", Integer.valueOf(this.limit), Integer.valueOf(this.offset));
        this.jUW = true;
        i iVar = new i(this.limit, this.offset);
        iVar.t(this);
        doSceneProgress(iVar, false);
        AppMethodBeat.o(67541);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private SimpleDateFormat BGt;

        private a() {
            AppMethodBeat.i(67528);
            this.BGt = new SimpleDateFormat(BankRemitHistoryUI.this.getContext().getString(R.string.abl));
            AppMethodBeat.o(67528);
        }

        /* synthetic */ a(BankRemitHistoryUI bankRemitHistoryUI, byte b2) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(67529);
            int size = BankRemitHistoryUI.this.qLE.size();
            AppMethodBeat.o(67529);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(67530);
            Object obj = BankRemitHistoryUI.this.qLE.get(i2);
            AppMethodBeat.o(67530);
            return obj;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            boolean z;
            AppMethodBeat.i(67531);
            if (view == null) {
                view = LayoutInflater.from(BankRemitHistoryUI.this.getContext()).inflate(R.layout.ie, viewGroup, false);
                view.setTag(new b(view));
            }
            b bVar = (b) view.getTag();
            cbs cbs = (cbs) getItem(i2);
            String AF = AF(cbs.Mhz);
            if (i2 == 0) {
                z = true;
            } else if (!AF.equals(AF(((cbs) getItem(i2 - 1)).Mhz))) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                bVar.CkP.setText(AF);
                bVar.CkP.setVisibility(0);
            } else {
                bVar.CkP.setVisibility(8);
            }
            bVar.CkR.setUrl(cbs.CiX);
            bVar.hPW.setText(cbs.title);
            bVar.CkQ.setText(cbs.MhA);
            bVar.jUO.setText(cbs.Mhy);
            if (!Util.isNullOrNil(cbs.MhB)) {
                if (!Util.isNullOrNil(cbs.MhC)) {
                    bVar.uzB.setTextColor(g.cI(cbs.MhC, true));
                }
                bVar.uzB.setText(cbs.MhB);
                bVar.uzB.setVisibility(0);
            } else {
                bVar.uzB.setVisibility(8);
            }
            AppMethodBeat.o(67531);
            return view;
        }

        private String AF(long j2) {
            AppMethodBeat.i(67532);
            String format = this.BGt.format(new Date(1000 * j2));
            AppMethodBeat.o(67532);
            return format;
        }
    }

    class b {
        TextView CkP;
        TextView CkQ;
        CdnImageView CkR;
        TextView hPW;
        TextView jUO;
        TextView uzB;

        public b(View view) {
            AppMethodBeat.i(67533);
            this.CkP = (TextView) view.findViewById(R.id.ad6);
            this.hPW = (TextView) view.findViewById(R.id.ad5);
            this.CkQ = (TextView) view.findViewById(R.id.ad7);
            this.jUO = (TextView) view.findViewById(R.id.ad4);
            this.uzB = (TextView) view.findViewById(R.id.ad8);
            this.CkR = (CdnImageView) view.findViewById(R.id.ad2);
            AppMethodBeat.o(67533);
        }
    }

    static /* synthetic */ void a(BankRemitHistoryUI bankRemitHistoryUI, String str) {
        AppMethodBeat.i(67543);
        for (int size = bankRemitHistoryUI.qLE.size() - 1; size >= 0; size--) {
            if (bankRemitHistoryUI.qLE.get(size).KZa.equals(str)) {
                bankRemitHistoryUI.qLE.remove(size);
                bankRemitHistoryUI.CkL.notifyDataSetChanged();
                AppMethodBeat.o(67543);
                return;
            }
        }
        AppMethodBeat.o(67543);
    }
}
