package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.collect.reward.a.a;
import com.tencent.mm.plugin.collect.reward.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.MMGridView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(2)
public class QrRewardSelectMoneyUI extends QrRewardBaseUI {
    private int channel;
    private String lDS;
    private String qxX;
    private String qxZ;
    private List<Integer> qyQ = new ArrayList();
    private CdnImageView qyR;
    private TextView qyS;
    private TextView qyT;
    private TextView qyU;
    private TextView qyV;
    private MMGridView qyW;
    private TextView qyX;
    private a qyY;
    private String qyZ;
    private String qyb;
    private String qyc;
    private String qyd;
    private String qye;
    private String qyf;
    private int qyg;
    private String qyh;
    private String qyi;
    private String qza;

    @Override // com.tencent.mm.plugin.collect.reward.ui.QrRewardBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public QrRewardSelectMoneyUI() {
        AppMethodBeat.i(64000);
        AppMethodBeat.o(64000);
    }

    static /* synthetic */ void k(QrRewardSelectMoneyUI qrRewardSelectMoneyUI, String str) {
        AppMethodBeat.i(64009);
        qrRewardSelectMoneyUI.akO(str);
        AppMethodBeat.o(64009);
    }

    @Override // com.tencent.mm.plugin.collect.reward.ui.QrRewardBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64001);
        super.onCreate(bundle);
        addSceneEndListener(1516);
        setMMTitle(R.string.frs);
        setContentViewVisibility(4);
        this.qyZ = getIntent().getStringExtra("key_qrcode_url");
        this.channel = getIntent().getIntExtra("key_channel", 0);
        this.lDS = getIntent().getStringExtra("key_web_url");
        Log.i("MicroMsg.QrRewardSelectMoneyUI", "do scan code");
        doSceneProgress(new f(this.qyZ, this.channel, this.lDS));
        initView();
        int intExtra = getIntent().getIntExtra("key_scene", 0);
        Log.d("MicroMsg.QrRewardSelectMoneyUI", "scene: %s", Integer.valueOf(intExtra));
        h.INSTANCE.a(14721, 2, Integer.valueOf(intExtra));
        AppMethodBeat.o(64001);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public boolean convertActivityFromTranslucent() {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64002);
        this.qyR = (CdnImageView) findViewById(R.id.gpd);
        this.qyS = (TextView) findViewById(R.id.gpi);
        this.qyT = (TextView) findViewById(R.id.gpg);
        this.qyU = (TextView) findViewById(R.id.gpe);
        this.qyV = (TextView) findViewById(R.id.gpj);
        this.qyW = (MMGridView) findViewById(R.id.gpf);
        this.qyX = (TextView) findViewById(R.id.gph);
        this.qyY = new a(this, (byte) 0);
        this.qyW.setAdapter((ListAdapter) this.qyY);
        this.qyW.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(63990);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, ((Integer) adapterView.getAdapter().getItem(i2)).intValue(), 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(63990);
            }
        });
        this.qyX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(63991);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, 0, 2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/reward/ui/QrRewardSelectMoneyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(63991);
            }
        });
        AppMethodBeat.o(64002);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64003);
        if (qVar instanceof f) {
            final f fVar = (f) qVar;
            fVar.a(new a.AbstractC0930a() {
                /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.collect.reward.a.a.AbstractC0930a
                public final void g(q qVar) {
                    AppMethodBeat.i(63995);
                    Log.d("MicroMsg.QrRewardSelectMoneyUI", "callback succ");
                    QrRewardSelectMoneyUI.this.qyb = fVar.qxF.LhF;
                    QrRewardSelectMoneyUI.this.qyc = fVar.qxF.Cpg;
                    QrRewardSelectMoneyUI.this.qyg = fVar.qxF.Lhp;
                    QrRewardSelectMoneyUI.this.qxZ = fVar.qxF.Lhz;
                    QrRewardSelectMoneyUI.this.qxX = fVar.qxF.desc;
                    QrRewardSelectMoneyUI.this.qye = fVar.qxF.LhK;
                    QrRewardSelectMoneyUI.this.qyf = fVar.qxF.LhL;
                    QrRewardSelectMoneyUI.this.qyd = fVar.qxF.LhI;
                    QrRewardSelectMoneyUI.this.qza = fVar.qxF.LhO;
                    QrRewardSelectMoneyUI.this.qyQ = fVar.qxF.Lhn;
                    QrRewardSelectMoneyUI.this.qyh = fVar.qxF.LhP;
                    QrRewardSelectMoneyUI.this.qyi = fVar.qxF.LhQ;
                    if (QrRewardSelectMoneyUI.this.qyQ == null) {
                        Log.i("MicroMsg.QrRewardSelectMoneyUI", "amt_list is null");
                        QrRewardSelectMoneyUI.this.qyQ = new LinkedList();
                    }
                    QrRewardSelectMoneyUI.b(QrRewardSelectMoneyUI.this);
                    AppMethodBeat.o(63995);
                }
            }).b(new a.AbstractC0930a() {
                /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.collect.reward.a.a.AbstractC0930a
                public final void g(q qVar) {
                    AppMethodBeat.i(63994);
                    Log.e("MicroMsg.QrRewardSelectMoneyUI", "scan response error");
                    if (!Util.isNullOrNil(fVar.qxF.qwn)) {
                        Toast.makeText(QrRewardSelectMoneyUI.this, fVar.qxF.qwn, 1).show();
                    }
                    QrRewardSelectMoneyUI.this.finish();
                    AppMethodBeat.o(63994);
                }
            }).c(new a.AbstractC0930a() {
                /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.collect.reward.a.a.AbstractC0930a
                public final void g(q qVar) {
                    AppMethodBeat.i(63993);
                    Log.e("MicroMsg.QrRewardSelectMoneyUI", "net error: %s", fVar);
                    com.tencent.mm.ui.base.h.a((Context) QrRewardSelectMoneyUI.this.getContext(), QrRewardSelectMoneyUI.this.getString(R.string.itf), (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.AnonymousClass3.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(63992);
                            QrRewardSelectMoneyUI.this.finish();
                            AppMethodBeat.o(63992);
                        }
                    });
                    AppMethodBeat.o(63993);
                }
            });
            setContentViewVisibility(0);
        }
        AppMethodBeat.o(64003);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bk9;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(64004);
        super.onDestroy();
        removeSceneEndListener(1516);
        AppMethodBeat.o(64004);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(64005);
        if (i2 != 1) {
            super.onActivityResult(i2, i3, intent);
        } else if (i3 == -1) {
            Log.i("MicroMsg.QrRewardSelectMoneyUI", "pay succ");
            finish();
            AppMethodBeat.o(64005);
            return;
        }
        AppMethodBeat.o(64005);
    }

    private void akO(String str) {
        String str2;
        AppMethodBeat.i(64006);
        if (Util.isNullOrNil(this.qyh)) {
            str2 = com.tencent.mm.wallet_core.ui.f.getDisplayName(str);
        } else {
            str2 = this.qyh;
        }
        this.qyT.setText(l.c(getContext(), str2));
        AppMethodBeat.o(64006);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(QrRewardSelectMoneyUI qrRewardSelectMoneyUI, byte b2) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(63997);
            int size = QrRewardSelectMoneyUI.this.qyQ.size();
            AppMethodBeat.o(63997);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(63998);
            Object obj = QrRewardSelectMoneyUI.this.qyQ.get(i2);
            AppMethodBeat.o(63998);
            return obj;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(63999);
            if (view == null) {
                view = LayoutInflater.from(QrRewardSelectMoneyUI.this.getContext()).inflate(R.layout.bk8, viewGroup, false);
            }
            int intValue = ((Integer) getItem(i2)).intValue();
            TextView textView = (TextView) view.findViewById(R.id.gpc);
            int i3 = intValue / 100;
            double d2 = ((double) intValue) / 100.0d;
            if (d2 > ((double) i3)) {
                textView.setText(String.format("%.2f", Double.valueOf(d2)) + QrRewardSelectMoneyUI.this.getString(R.string.fs_));
            } else {
                textView.setText(String.format("%d", Integer.valueOf(i3)) + QrRewardSelectMoneyUI.this.getString(R.string.fs_));
            }
            AppMethodBeat.o(63999);
            return view;
        }
    }

    static /* synthetic */ void a(QrRewardSelectMoneyUI qrRewardSelectMoneyUI, int i2, int i3) {
        AppMethodBeat.i(64007);
        Log.i("MicroMsg.QrRewardSelectMoneyUI", "go to grant ui");
        Intent intent = new Intent(qrRewardSelectMoneyUI.getContext(), QrRewardGrantUI.class);
        intent.putExtra("key_amt_type", i3);
        if (i3 == 1) {
            intent.putExtra("key_money_amt", i2);
        }
        intent.putExtra("key_rcvr_name", qrRewardSelectMoneyUI.qyb);
        intent.putExtra("key_rcvr_true_name", qrRewardSelectMoneyUI.qyc);
        intent.putExtra("key_rcvr_open_id", qrRewardSelectMoneyUI.qxZ);
        intent.putExtra("key_qrcode_desc", qrRewardSelectMoneyUI.qxX);
        intent.putExtra("key_channel", qrRewardSelectMoneyUI.channel);
        intent.putExtra("key_web_url", qrRewardSelectMoneyUI.lDS);
        intent.putExtra("key_scan_id", qrRewardSelectMoneyUI.qyd);
        intent.putExtra("key_sxtend_1", qrRewardSelectMoneyUI.qye);
        intent.putExtra("key_sxtend_2", qrRewardSelectMoneyUI.qyf);
        intent.putExtra("key_max_amt", qrRewardSelectMoneyUI.qyg);
        intent.putExtra("key_receiver_nickname", qrRewardSelectMoneyUI.qyh);
        intent.putExtra("key_photo_url", qrRewardSelectMoneyUI.qyi);
        qrRewardSelectMoneyUI.startActivityForResult(intent, 1);
        AppMethodBeat.o(64007);
    }

    static /* synthetic */ void b(QrRewardSelectMoneyUI qrRewardSelectMoneyUI) {
        AppMethodBeat.i(64008);
        if (Util.isNullOrNil(qrRewardSelectMoneyUI.qyi)) {
            String str = qrRewardSelectMoneyUI.qyb;
            g.aAi();
            as bjK = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjK(str);
            if (bjK == null || ((int) bjK.gMZ) <= 0) {
                Log.d("MicroMsg.QrRewardSelectMoneyUI", "Receiver in contactStg and try to get contact");
                final long nowMilliSecond = Util.nowMilliSecond();
                ay.a.iDq.a(str, "", new ay.b.a() {
                    /* class com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.AnonymousClass6 */

                    @Override // com.tencent.mm.model.ay.b.a
                    public final void p(String str, boolean z) {
                        AppMethodBeat.i(63996);
                        if (z) {
                            Log.v("MicroMsg.QrRewardSelectMoneyUI", "getContact suc; cost=" + (Util.nowMilliSecond() - nowMilliSecond) + " ms");
                            c.ap(str, 3);
                            p.aYD().Mg(str);
                        } else {
                            Log.w("MicroMsg.QrRewardSelectMoneyUI", "getContact failed");
                        }
                        a.b.a(QrRewardSelectMoneyUI.this.qyR, str, 0.03f, false);
                        QrRewardSelectMoneyUI.k(QrRewardSelectMoneyUI.this, str);
                        AppMethodBeat.o(63996);
                    }
                });
            } else {
                a.b.a(qrRewardSelectMoneyUI.qyR, str, 0.03f, false);
                qrRewardSelectMoneyUI.akO(str);
            }
        } else {
            int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(qrRewardSelectMoneyUI, 50.0f);
            qrRewardSelectMoneyUI.qyR.setRoundCorner(true);
            qrRewardSelectMoneyUI.qyR.s(qrRewardSelectMoneyUI.qyi, fromDPToPix, fromDPToPix, R.drawable.bca);
            qrRewardSelectMoneyUI.akO(qrRewardSelectMoneyUI.qyb);
        }
        if (!Util.isNullOrNil(qrRewardSelectMoneyUI.qxX)) {
            qrRewardSelectMoneyUI.qyU.setText(l.b(qrRewardSelectMoneyUI, qrRewardSelectMoneyUI.getString(R.string.fs9, new Object[]{qrRewardSelectMoneyUI.qxX}), qrRewardSelectMoneyUI.qyU.getTextSize()));
        }
        if (!Util.isNullOrNil(qrRewardSelectMoneyUI.qza)) {
            qrRewardSelectMoneyUI.qyS.setText(qrRewardSelectMoneyUI.qza);
        } else {
            qrRewardSelectMoneyUI.qyS.setVisibility(8);
        }
        qrRewardSelectMoneyUI.qyY.notifyDataSetChanged();
        AppMethodBeat.o(64008);
    }
}
