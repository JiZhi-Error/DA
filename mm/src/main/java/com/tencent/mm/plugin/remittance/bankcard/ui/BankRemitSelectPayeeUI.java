package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.remittance.bankcard.a.f;
import com.tencent.mm.plugin.remittance.bankcard.a.j;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.wallet_core.c.r;
import java.util.ArrayList;
import java.util.List;

public class BankRemitSelectPayeeUI extends BankRemitBaseUI implements o.g {
    private List<TransferRecordParcel> ClA;
    private ArrayList<TransferRecordParcel> ClB;
    private ArrayList<String> ClC;
    private int ClD = -1;
    private int ClE = -1;
    private Intent ClF;
    private ListView Cly;
    private b Clz;
    private l mHj;

    @Override // com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67602);
        super.onCreate(bundle);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_self_transfer_record_list");
        ArrayList parcelableArrayListExtra2 = getIntent().getParcelableArrayListExtra("key_freq_transfer_record_list");
        this.ClA = new ArrayList();
        if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
            this.ClD = 0;
            this.ClA.addAll(parcelableArrayListExtra);
        }
        if (parcelableArrayListExtra2 != null && !parcelableArrayListExtra2.isEmpty()) {
            this.ClE = this.ClA.size() + this.ClD + 1;
            this.ClA.addAll(parcelableArrayListExtra2);
        }
        Log.i("MicroMsg.BankRemitSelectPayeeUI", "selfHeaderPos: %s, otherHeaderPos: %s", Integer.valueOf(this.ClD), Integer.valueOf(this.ClE));
        for (TransferRecordParcel transferRecordParcel : this.ClA) {
            Log.d("MicroMsg.BankRemitSelectPayeeUI", "seqno: %s, tail: %s, bank_logo: %s, bank_name: %s, bank_type: %s, payee: %s, explain: %s", transferRecordParcel.Cjt, transferRecordParcel.Cju, transferRecordParcel.CiX, transferRecordParcel.ynT, transferRecordParcel.dDj, transferRecordParcel.Cjv, transferRecordParcel.Cjw);
        }
        this.ClF = new Intent();
        initView();
        setMMTitle(R.string.ac8);
        addSceneEndListener(1590);
        addSceneEndListener(1395);
        AppMethodBeat.o(67602);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67603);
        this.Cly = (ListView) findViewById(R.id.ae7);
        this.mHj = new l(this);
        this.Clz = new b(this, (byte) 0);
        this.Cly.setAdapter((ListAdapter) this.Clz);
        this.Cly.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(67584);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitSelectPayeeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Log.d("MicroMsg.BankRemitSelectPayeeUI", "item click: %s", Integer.valueOf(i2));
                TransferRecordParcel transferRecordParcel = (TransferRecordParcel) adapterView.getAdapter().getItem(i2);
                if (transferRecordParcel != null) {
                    BankRemitSelectPayeeUI.this.ClF.putExtra("key_bank_card_seqno", transferRecordParcel.Cjt);
                    BankRemitSelectPayeeUI.this.setResult(-1, BankRemitSelectPayeeUI.this.ClF);
                    BankRemitSelectPayeeUI.this.finish();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitSelectPayeeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(67584);
            }
        });
        this.Cly.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(67586);
                BankRemitSelectPayeeUI.this.mHj.a(view, i2, j2, BankRemitSelectPayeeUI.this, BankRemitSelectPayeeUI.this);
                AppMethodBeat.o(67586);
                return true;
            }
        });
        AppMethodBeat.o(67603);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(67604);
        contextMenu.add(0, 1, 0, R.string.ac6);
        contextMenu.add(0, 0, 0, R.string.ac3);
        AppMethodBeat.o(67604);
    }

    @Override // com.tencent.mm.ui.base.o.g
    public void onMMMenuItemSelected(MenuItem menuItem, int i2) {
        AppMethodBeat.i(67605);
        int itemId = menuItem.getItemId();
        final TransferRecordParcel transferRecordParcel = (TransferRecordParcel) this.Cly.getItemAtPosition(((AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
        if (transferRecordParcel == null) {
            Log.i("MicroMsg.BankRemitSelectPayeeUI", "select record is null");
            AppMethodBeat.o(67605);
        } else if (itemId == 1) {
            com.tencent.mm.plugin.wallet_core.ui.view.a.a(this, getString(R.string.b6l), transferRecordParcel.Cjw, "", 32, new h.b() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.AnonymousClass4 */

                @Override // com.tencent.mm.ui.base.h.b
                public final boolean onFinish(CharSequence charSequence) {
                    AppMethodBeat.i(67587);
                    if (!(transferRecordParcel.Cjw == null && charSequence == null) && (transferRecordParcel.Cjw == null || !transferRecordParcel.Cjw.equals(charSequence))) {
                        BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, transferRecordParcel.Cjt, String.valueOf(charSequence));
                        AppMethodBeat.o(67587);
                    } else {
                        Log.i("MicroMsg.BankRemitSelectPayeeUI", "no change: %s, %s", transferRecordParcel.Cjw, charSequence);
                        AppMethodBeat.o(67587);
                    }
                    return true;
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(67589);
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(67588);
                            BankRemitSelectPayeeUI.this.hideVKB();
                            AppMethodBeat.o(67588);
                        }
                    }, 500);
                    AppMethodBeat.o(67589);
                }
            });
            AppMethodBeat.o(67605);
        } else if (itemId == 0) {
            String str = transferRecordParcel.Cjt;
            Log.i("MicroMsg.BankRemitSelectPayeeUI", "do delete record");
            doSceneProgress(new f(str), true);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14673, 7);
            AppMethodBeat.o(67605);
        } else {
            Log.i("MicroMsg.BankRemitSelectPayeeUI", "unknown itemId: %s", Integer.valueOf(itemId));
            AppMethodBeat.o(67605);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.f3121io;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(67606);
        super.onDestroy();
        removeSceneEndListener(1590);
        removeSceneEndListener(1395);
        AppMethodBeat.o(67606);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(67607);
        if (qVar instanceof j) {
            final j jVar = (j) qVar;
            jVar.a(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.AnonymousClass8 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67592);
                    Log.i("MicroMsg.BankRemitSelectPayeeUI", "modify success");
                    BankRemitSelectPayeeUI.b(BankRemitSelectPayeeUI.this, jVar.CiJ, jVar.remark);
                    AppMethodBeat.o(67592);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.AnonymousClass7 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67591);
                    Log.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", Integer.valueOf(jVar.CiR.dDN), jVar.CiR.qwn);
                    if (!Util.isNullOrNil(jVar.CiR.qwn)) {
                        Toast.makeText(BankRemitSelectPayeeUI.this, jVar.CiR.qwn, 1).show();
                    }
                    AppMethodBeat.o(67591);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.AnonymousClass6 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67590);
                    Log.e("MicroMsg.BankRemitSelectPayeeUI", "net error: %s", qVar);
                    AppMethodBeat.o(67590);
                }
            });
        } else if (qVar instanceof f) {
            final f fVar = (f) qVar;
            fVar.a(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67585);
                    BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, fVar.CiJ);
                    AppMethodBeat.o(67585);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.AnonymousClass10 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67594);
                    Log.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", Integer.valueOf(fVar.CiN.dDN), fVar.CiN.qwn);
                    if (!Util.isNullOrNil(fVar.CiN.qwn)) {
                        Toast.makeText(BankRemitSelectPayeeUI.this, fVar.CiN.qwn, 1).show();
                    }
                    AppMethodBeat.o(67594);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.AnonymousClass9 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67593);
                    Log.e("MicroMsg.BankRemitSelectPayeeUI", "net error: %s", qVar);
                    AppMethodBeat.o(67593);
                }
            });
        }
        AppMethodBeat.o(67607);
        return false;
    }

    /* access modifiers changed from: package-private */
    public class b extends BaseAdapter {
        private b() {
        }

        /* synthetic */ b(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, byte b2) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(67595);
            int size = BankRemitSelectPayeeUI.this.ClA.size();
            if (eNj()) {
                size++;
            }
            if (eNk()) {
                size++;
            }
            AppMethodBeat.o(67595);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(67596);
            if (i2 == BankRemitSelectPayeeUI.this.ClD || i2 == BankRemitSelectPayeeUI.this.ClE) {
                AppMethodBeat.o(67596);
                return null;
            } else if (i2 < BankRemitSelectPayeeUI.this.ClE) {
                Object obj = BankRemitSelectPayeeUI.this.ClA.get(i2 - 1);
                AppMethodBeat.o(67596);
                return obj;
            } else if (!eNk() || i2 <= BankRemitSelectPayeeUI.this.ClE) {
                if (eNj()) {
                    Object obj2 = BankRemitSelectPayeeUI.this.ClA.get(i2 - 1);
                    AppMethodBeat.o(67596);
                    return obj2;
                }
                Log.i("MicroMsg.BankRemitSelectPayeeUI", "maybe wrong pos: [%s,%s,%s]", Integer.valueOf(i2), Integer.valueOf(BankRemitSelectPayeeUI.this.ClD), Integer.valueOf(BankRemitSelectPayeeUI.this.ClE));
                AppMethodBeat.o(67596);
                return null;
            } else if (eNj()) {
                Object obj3 = BankRemitSelectPayeeUI.this.ClA.get(i2 - 2);
                AppMethodBeat.o(67596);
                return obj3;
            } else {
                Object obj4 = BankRemitSelectPayeeUI.this.ClA.get(i2 - 1);
                AppMethodBeat.o(67596);
                return obj4;
            }
        }

        public final boolean isEnabled(int i2) {
            AppMethodBeat.i(67597);
            if (i2 == BankRemitSelectPayeeUI.this.ClD || i2 == BankRemitSelectPayeeUI.this.ClE) {
                AppMethodBeat.o(67597);
                return false;
            }
            AppMethodBeat.o(67597);
            return true;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(67598);
            if (i2 == BankRemitSelectPayeeUI.this.ClD || i2 == BankRemitSelectPayeeUI.this.ClE) {
                AppMethodBeat.o(67598);
                return 0;
            }
            AppMethodBeat.o(67598);
            return 1;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(67599);
            int itemViewType = getItemViewType(i2);
            if (view == null) {
                if (itemViewType == 0) {
                    view = LayoutInflater.from(BankRemitSelectPayeeUI.this.getContext()).inflate(R.layout.im, viewGroup, false);
                } else {
                    view = LayoutInflater.from(BankRemitSelectPayeeUI.this.getContext()).inflate(R.layout.in, viewGroup, false);
                    a aVar = new a(BankRemitSelectPayeeUI.this, (byte) 0);
                    aVar.ClL = (CdnImageView) view.findViewById(R.id.ae3);
                    aVar.Cjr = (TextView) view.findViewById(R.id.ae6);
                    aVar.ClM = (TextView) view.findViewById(R.id.ae4);
                    view.setTag(aVar);
                }
            }
            switch (itemViewType) {
                case 0:
                    TextView textView = (TextView) view.findViewById(R.id.ae2);
                    if (BankRemitSelectPayeeUI.this.ClD == i2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (BankRemitSelectPayeeUI.this.ClE == i2) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            textView.setText("");
                            Log.w("MicroMsg.BankRemitSelectPayeeUI", "wrong header pos: %s", Integer.valueOf(i2));
                            break;
                        } else {
                            textView.setText(R.string.ac5);
                            break;
                        }
                    } else {
                        textView.setText(R.string.ac7);
                        break;
                    }
                case 1:
                    a aVar2 = (a) view.getTag();
                    TransferRecordParcel transferRecordParcel = (TransferRecordParcel) getItem(i2);
                    if (transferRecordParcel == null) {
                        aVar2.ClL.setImageResource(R.color.ac_);
                        aVar2.Cjr.setText("");
                        aVar2.ClM.setText("");
                        Log.w("MicroMsg.BankRemitSelectPayeeUI", "empty record");
                        break;
                    } else {
                        aVar2.ClL.gI(transferRecordParcel.CiX, R.color.ac_);
                        if (!Util.isNullOrNil(transferRecordParcel.Cjw)) {
                            aVar2.Cjr.setText(com.tencent.mm.pluginsdk.ui.span.l.c(BankRemitSelectPayeeUI.this.getContext(), BankRemitSelectPayeeUI.this.getContext().getString(R.string.ac4, new Object[]{transferRecordParcel.Cjv, transferRecordParcel.Cjw})));
                        } else {
                            aVar2.Cjr.setText(transferRecordParcel.Cjv);
                        }
                        aVar2.ClM.setText(BankRemitSelectPayeeUI.this.getString(R.string.ac4, new Object[]{transferRecordParcel.ynT, transferRecordParcel.Cju}));
                        break;
                    }
                default:
                    Log.w("MicroMsg.BankRemitSelectPayeeUI", "unknown type: %d", Integer.valueOf(itemViewType));
                    break;
            }
            AppMethodBeat.o(67599);
            return view;
        }

        private boolean eNj() {
            AppMethodBeat.i(67600);
            if (BankRemitSelectPayeeUI.this.ClD >= 0) {
                AppMethodBeat.o(67600);
                return true;
            }
            AppMethodBeat.o(67600);
            return false;
        }

        private boolean eNk() {
            AppMethodBeat.i(67601);
            if (BankRemitSelectPayeeUI.this.ClE >= 0) {
                AppMethodBeat.o(67601);
                return true;
            }
            AppMethodBeat.o(67601);
            return false;
        }
    }

    class a {
        TextView Cjr;
        CdnImageView ClL;
        TextView ClM;

        private a() {
        }

        /* synthetic */ a(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, byte b2) {
            this();
        }
    }

    static /* synthetic */ void a(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, String str, String str2) {
        AppMethodBeat.i(67608);
        Log.i("MicroMsg.BankRemitSelectPayeeUI", "do modify remark: %s", str2);
        bankRemitSelectPayeeUI.doSceneProgress(new j(str, str2), true);
        AppMethodBeat.o(67608);
    }

    static /* synthetic */ void b(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, String str, String str2) {
        AppMethodBeat.i(67609);
        Log.i("MicroMsg.BankRemitSelectPayeeUI", "do modify record");
        if (bankRemitSelectPayeeUI.ClB == null) {
            bankRemitSelectPayeeUI.ClB = new ArrayList<>();
        }
        int size = bankRemitSelectPayeeUI.ClA.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            TransferRecordParcel transferRecordParcel = bankRemitSelectPayeeUI.ClA.get(size);
            if (transferRecordParcel.Cjt.equals(str)) {
                transferRecordParcel.Cjw = str2;
                bankRemitSelectPayeeUI.ClB.add(transferRecordParcel);
                break;
            }
            size--;
        }
        bankRemitSelectPayeeUI.Clz.notifyDataSetChanged();
        bankRemitSelectPayeeUI.ClF.putParcelableArrayListExtra("key_modified_record_list", bankRemitSelectPayeeUI.ClB);
        bankRemitSelectPayeeUI.setResult(0, bankRemitSelectPayeeUI.ClF);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14673, 5);
        AppMethodBeat.o(67609);
    }

    static /* synthetic */ void a(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, String str) {
        AppMethodBeat.i(67610);
        Log.i("MicroMsg.BankRemitSelectPayeeUI", "do remove record");
        int size = bankRemitSelectPayeeUI.ClA.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (bankRemitSelectPayeeUI.ClA.get(size).Cjt.equals(str)) {
                bankRemitSelectPayeeUI.ClA.remove(size);
                break;
            } else {
                size--;
            }
        }
        bankRemitSelectPayeeUI.Clz.notifyDataSetChanged();
        if (bankRemitSelectPayeeUI.ClC == null) {
            bankRemitSelectPayeeUI.ClC = new ArrayList<>();
        }
        bankRemitSelectPayeeUI.ClC.add(str);
        bankRemitSelectPayeeUI.ClF.putStringArrayListExtra("key_delete_seq_no_list", bankRemitSelectPayeeUI.ClC);
        bankRemitSelectPayeeUI.setResult(0, bankRemitSelectPayeeUI.ClF);
        AppMethodBeat.o(67610);
    }
}
