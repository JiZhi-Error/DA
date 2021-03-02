package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.honey_pay.a.i;
import com.tencent.mm.plugin.honey_pay.a.j;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.protocal.protobuf.crf;
import com.tencent.mm.protocal.protobuf.czq;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.protocal.protobuf.dhf;
import com.tencent.mm.protocal.protobuf.eig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HoneyPayCardManagerUI extends HoneyPayBaseUI {
    private int mScene;
    private ViewGroup qgZ;
    private ImageView qyu;
    private String yjY;
    private eig yjZ;
    private MMSwitchBtn ykA;
    private LinearLayout ykB;
    private TextView ykC;
    private TextView ykD;
    private TextView ykE;
    private View ykF;
    private View ykG;
    private TextView ykH;
    private a ykI;
    private List<czq> ykJ = new ArrayList();
    private Bankcard ykK;
    private dbf ykL;
    private dbf ykM;
    private long ykN;
    private long ykO;
    private boolean ykP;
    private String ykQ;
    private TextView ykc;
    private TextView yke;
    private TextView ykf;
    private TextView ykg;
    private TextView ykh;
    private WalletTextView yks;
    private ListView ykv;
    private ViewGroup ykw;
    private ViewGroup ykx;
    private ViewGroup yky;
    private TextView ykz;

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public HoneyPayCardManagerUI() {
        AppMethodBeat.i(64702);
        AppMethodBeat.o(64702);
    }

    static /* synthetic */ void a(HoneyPayCardManagerUI honeyPayCardManagerUI, dhf dhf) {
        AppMethodBeat.i(64714);
        honeyPayCardManagerUI.a(dhf);
        AppMethodBeat.o(64714);
    }

    static /* synthetic */ Bankcard aBF(String str) {
        AppMethodBeat.i(64715);
        Bankcard aBE = aBE(str);
        AppMethodBeat.o(64715);
        return aBE;
    }

    static /* synthetic */ void d(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        AppMethodBeat.i(64716);
        honeyPayCardManagerUI.dYT();
        AppMethodBeat.o(64716);
    }

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64703);
        super.onCreate(bundle);
        addSceneEndListener(2876);
        addSceneEndListener(2742);
        addSceneEndListener(2941);
        this.yjY = getIntent().getStringExtra("key_card_no");
        this.mScene = getIntent().getIntExtra("key_scene", 0);
        this.ykP = getIntent().getBooleanExtra("key_is_create", false);
        this.ykQ = getIntent().getStringExtra("key_card_type");
        initView();
        Log.d(this.TAG, "cardtype: %s", this.ykQ);
        setMMTitle(R.string.e0n);
        if (this.mScene == 1) {
            dhf dhf = new dhf();
            try {
                dhf.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
                a(dhf);
                AppMethodBeat.o(64703);
            } catch (IOException e2) {
                Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
                dYS();
                AppMethodBeat.o(64703);
            }
        } else {
            dYS();
            AppMethodBeat.o(64703);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(64705);
        super.onDestroy();
        removeSceneEndListener(2876);
        removeSceneEndListener(2742);
        removeSceneEndListener(2941);
        AppMethodBeat.o(64705);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64706);
        if (qVar instanceof l) {
            final l lVar = (l) qVar;
            lVar.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.AnonymousClass11 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64692);
                    HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, lVar.yjJ);
                    AppMethodBeat.o(64692);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.AnonymousClass10 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.AnonymousClass9 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            });
        } else if (qVar instanceof i) {
            final i iVar = (i) qVar;
            iVar.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.AnonymousClass14 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.AnonymousClass13 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    boolean z = true;
                    AppMethodBeat.i(64694);
                    MMSwitchBtn mMSwitchBtn = HoneyPayCardManagerUI.this.ykA;
                    if (iVar.cSx == 1) {
                        z = false;
                    }
                    mMSwitchBtn.setCheck(z);
                    AppMethodBeat.o(64694);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.AnonymousClass12 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    boolean z = true;
                    AppMethodBeat.i(64693);
                    MMSwitchBtn mMSwitchBtn = HoneyPayCardManagerUI.this.ykA;
                    if (iVar.cSx == 1) {
                        z = false;
                    }
                    mMSwitchBtn.setCheck(z);
                    AppMethodBeat.o(64693);
                }
            });
        } else if (qVar instanceof j) {
            final j jVar = (j) qVar;
            jVar.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64685);
                    HoneyPayCardManagerUI.this.ykL = jVar.yjH.Mws;
                    if (HoneyPayCardManagerUI.this.ykL != null) {
                        HoneyPayCardManagerUI.this.ykK = HoneyPayCardManagerUI.aBF(HoneyPayCardManagerUI.this.ykL.MGj);
                    }
                    HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
                    AppMethodBeat.o(64685);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.AnonymousClass16 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64696);
                    HoneyPayCardManagerUI.this.ykL = HoneyPayCardManagerUI.this.ykM;
                    if (HoneyPayCardManagerUI.this.ykL != null) {
                        HoneyPayCardManagerUI.this.ykK = HoneyPayCardManagerUI.aBF(HoneyPayCardManagerUI.this.ykL.MGj);
                    }
                    HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
                    AppMethodBeat.o(64696);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.AnonymousClass15 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64695);
                    HoneyPayCardManagerUI.this.ykL = HoneyPayCardManagerUI.this.ykM;
                    if (HoneyPayCardManagerUI.this.ykL != null) {
                        HoneyPayCardManagerUI.this.ykK = HoneyPayCardManagerUI.aBF(HoneyPayCardManagerUI.this.ykL.MGj);
                    }
                    HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
                    AppMethodBeat.o(64695);
                }
            });
        }
        AppMethodBeat.o(64706);
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(64707);
        if (i2 == 1) {
            if (i3 == -1 && intent.getBooleanExtra("key_modify_create_line_succ", false)) {
                this.yks.setText(c.GO(intent.getLongExtra("key_credit_line", 0)));
                setResult(-1);
            }
        } else if (i2 == 2) {
            if (i3 == -1) {
                removeAllOptionMenu();
                setResult(-1);
                finish();
            }
        } else if (i2 == 3 && i3 == -1) {
            dYS();
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(64707);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aul;
    }

    private void dYS() {
        AppMethodBeat.i(64708);
        Log.i(this.TAG, "do qry detail");
        l lVar = new l(this.yjY);
        lVar.t(this);
        doSceneProgress(lVar, true);
        AppMethodBeat.o(64708);
    }

    private void a(dhf dhf) {
        AppMethodBeat.i(64709);
        this.yjZ = dhf.LUW;
        this.ykJ.clear();
        this.ykI.notifyDataSetChanged();
        if (dhf.LpE != null) {
            setMMTitle(dhf.LpE.pTn);
            this.ykN = dhf.LjF;
            this.ykO = dhf.LjE;
            if (dhf.LpE.MhM != null) {
                this.ykK = aBE(dhf.LpE.MhM.MGj);
                this.ykL = dhf.LpE.MhM;
            }
            a(dhf.LpE);
            int i2 = dhf.LpE.state;
            Log.i(this.TAG, "detail state: %s", Integer.valueOf(i2));
            Log.d(this.TAG, "state title: %s", dhf.LpE.MhP);
            if (!Util.isNullOrNil(dhf.LpE.MhP)) {
                this.ykc.setText(dhf.LpE.MhP);
                this.ykc.setVisibility(0);
            } else {
                this.ykc.setVisibility(8);
            }
            if (!Util.isNullOrNil(dhf.LpE.MhL)) {
                this.ykE.setText(dhf.LpE.MhL);
                this.ykE.setVisibility(0);
            } else {
                this.ykE.setVisibility(8);
            }
            if (i2 == 1) {
                this.ykc.setTextColor(getResources().getColor(R.color.Orange));
                this.yks.setTextColor(getResources().getColor(R.color.FG_1));
                findViewById(R.id.dr6).setVisibility(8);
                this.ykv.removeFooterView(this.ykw);
                this.ykw.setVisibility(8);
                this.ykF.setVisibility(8);
                if (this.ykP) {
                    this.yky = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.aug, (ViewGroup) null);
                    ((Button) this.yky.findViewById(R.id.dr7)).setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.AnonymousClass7 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(64690);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            HoneyPayCardManagerUI.this.finish();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(64690);
                        }
                    });
                    this.ykv.addFooterView(this.yky);
                    showHomeBtn(false);
                    enableBackMenu(false);
                    setMMTitle("");
                }
            } else if (i2 == 2) {
                if (dhf.dkr != null && !dhf.dkr.isEmpty()) {
                    this.ykJ = dhf.dkr;
                    this.ykI.notifyDataSetChanged();
                    this.ykv.removeFooterView(this.ykw);
                    this.ykw.setVisibility(8);
                    if (dhf.MLE != null) {
                        a(dhf.MLE);
                        this.ykv.addFooterView(this.ykx);
                    }
                    findViewById(R.id.drh).setBackgroundResource(R.color.ul);
                }
                this.ykz.setVisibility(0);
                this.yks.setVisibility(0);
                this.ykF.setVisibility(0);
                findViewById(R.id.dr6).setVisibility(8);
            } else if (i2 == 3) {
                findViewById(R.id.dr6).setVisibility(0);
                this.yke.setText(R.string.e0b);
                this.ykf.setText(R.string.e16);
                this.ykg.setText(c.GP((long) dhf.LpE.Gaz));
                this.ykh.setText(c.GP((long) dhf.LpE.pRN));
                this.ykv.removeFooterView(this.ykw);
                this.ykw.setVisibility(8);
                this.ykF.setVisibility(8);
                findViewById(R.id.drl).setVisibility(8);
            } else if (i2 == 4) {
                this.ykz.setVisibility(8);
                findViewById(R.id.dr6).setVisibility(0);
                this.yke.setText(R.string.e15);
                this.ykg.setText(c.GP((long) dhf.LpE.MhN));
                findViewById(R.id.dri).setVisibility(8);
                this.ykv.removeFooterView(this.ykw);
                this.ykw.setVisibility(8);
                this.ykF.setVisibility(8);
                findViewById(R.id.drl).setVisibility(8);
                findViewById(R.id.drh).setBackgroundResource(R.color.afz);
            } else {
                Log.d(this.TAG, "unknown state: %s", Integer.valueOf(i2));
            }
        }
        this.ykG.setVisibility(8);
        c.b(this, dhf.MhF, this.yjY, 2, this.yjZ);
        AppMethodBeat.o(64709);
    }

    private void a(final crf crf) {
        AppMethodBeat.i(64710);
        this.ykx = (ViewGroup) View.inflate(this, R.layout.aui, null);
        ((TextView) this.ykx.findViewById(R.id.dr2)).setText(crf.title);
        this.ykx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(64691);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f.p(HoneyPayCardManagerUI.this.getContext(), crf.url, false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64691);
            }
        });
        AppMethodBeat.o(64710);
    }

    private static Bankcard aBE(String str) {
        Bankcard bankcard;
        AppMethodBeat.i(64711);
        Bankcard aVm = t.fQI().aVm(str);
        if (aVm != null || (bankcard = t.fQI().IbQ) == null || !bankcard.field_bindSerial.equals(str)) {
            AppMethodBeat.o(64711);
            return aVm;
        }
        AppMethodBeat.o(64711);
        return bankcard;
    }

    private void a(cbw cbw) {
        boolean z = false;
        AppMethodBeat.i(64712);
        this.ykC.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, f.ht(cbw.LjD, 6) + getString(R.string.e0s), this.ykC.getTextSize()));
        a.b.a(this.qyu, cbw.LjD, 0.06f, false);
        this.yks.setText(c.GO(cbw.LpD));
        MMSwitchBtn mMSwitchBtn = this.ykA;
        if (cbw.HFB != 0) {
            z = true;
        }
        mMSwitchBtn.setCheck(z);
        dYT();
        AppMethodBeat.o(64712);
    }

    private void dYT() {
        AppMethodBeat.i(64713);
        if (this.ykL != null) {
            this.ykD.setText(this.ykL.MGh);
            if (!Util.isNullOrNil(this.ykL.MGi)) {
                this.ykD.setTextColor(g.cI(this.ykL.MGi, true));
            } else {
                this.ykD.setTextColor(getResources().getColor(R.color.a2x));
            }
            if (!Util.isNullOrNil(this.ykL.MGm)) {
                this.ykH.setText(this.ykL.MGm);
                this.ykH.setVisibility(0);
                AppMethodBeat.o(64713);
                return;
            }
            this.ykH.setVisibility(8);
            AppMethodBeat.o(64713);
            return;
        }
        Log.i(this.TAG, "reset payway view for null");
        this.ykD.setText("");
        this.ykD.setTextColor(getResources().getColor(R.color.a2x));
        this.ykH.setVisibility(8);
        AppMethodBeat.o(64713);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(HoneyPayCardManagerUI honeyPayCardManagerUI, byte b2) {
            this();
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(64701);
            czq ON = ON(i2);
            AppMethodBeat.o(64701);
            return ON;
        }

        public final int getCount() {
            AppMethodBeat.i(64697);
            int size = HoneyPayCardManagerUI.this.ykJ.size();
            AppMethodBeat.o(64697);
            return size;
        }

        private czq ON(int i2) {
            AppMethodBeat.i(64698);
            czq czq = (czq) HoneyPayCardManagerUI.this.ykJ.get(i2);
            AppMethodBeat.o(64698);
            return czq;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final boolean isEnabled(int i2) {
            AppMethodBeat.i(64699);
            if (!Util.isNullOrNil(ON(i2).url)) {
                AppMethodBeat.o(64699);
                return true;
            }
            AppMethodBeat.o(64699);
            return false;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(64700);
            if (view == null) {
                view = LayoutInflater.from(HoneyPayCardManagerUI.this.getContext()).inflate(R.layout.auk, viewGroup, false);
                b bVar = new b(HoneyPayCardManagerUI.this, (byte) 0);
                bVar.qpf = (TextView) view.findViewById(R.id.dqu);
                bVar.ykX = (WalletTextView) view.findViewById(R.id.dqs);
                bVar.ykX.setPrefix(ah.hhz());
                bVar.jWr = view.findViewById(R.id.dqt);
                view.setTag(bVar);
            }
            czq ON = ON(i2);
            b bVar2 = (b) view.getTag();
            bVar2.qpf.setText(ON.BrH);
            bVar2.ykX.setText(c.GO(ON.MEU));
            if (HoneyPayCardManagerUI.this.ykJ.size() == 1) {
                bVar2.jWr.setVisibility(8);
            } else {
                bVar2.jWr.setVisibility(0);
            }
            AppMethodBeat.o(64700);
            return view;
        }
    }

    class b {
        View jWr;
        TextView qpf;
        WalletTextView ykX;

        private b() {
        }

        /* synthetic */ b(HoneyPayCardManagerUI honeyPayCardManagerUI, byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64704);
        this.qgZ = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.auj, (ViewGroup) null);
        this.ykA = (MMSwitchBtn) this.qgZ.findViewById(R.id.drc);
        this.ykB = (LinearLayout) this.qgZ.findViewById(R.id.drd);
        this.ykD = (TextView) this.qgZ.findViewById(R.id.drf);
        this.qyu = (ImageView) this.qgZ.findViewById(R.id.dr3);
        this.yks = (WalletTextView) this.qgZ.findViewById(R.id.drg);
        this.ykC = (TextView) this.qgZ.findViewById(R.id.dro);
        this.ykz = (TextView) this.qgZ.findViewById(R.id.drb);
        this.ykc = (TextView) this.qgZ.findViewById(R.id.drn);
        this.ykE = (TextView) this.qgZ.findViewById(R.id.drm);
        this.yke = (TextView) this.qgZ.findViewById(R.id.dr9);
        this.ykg = (TextView) this.qgZ.findViewById(R.id.dr_);
        this.ykf = (TextView) this.qgZ.findViewById(R.id.drj);
        this.ykh = (TextView) this.qgZ.findViewById(R.id.drk);
        this.ykF = this.qgZ.findViewById(R.id.dr5);
        this.ykH = (TextView) this.qgZ.findViewById(R.id.dre);
        this.yks.setPrefix(ah.hhz());
        this.ykA.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                int i2 = 1;
                AppMethodBeat.i(64686);
                Log.d(HoneyPayCardManagerUI.this.TAG, "check %s", Boolean.valueOf(z));
                HoneyPayCardManagerUI honeyPayCardManagerUI = HoneyPayCardManagerUI.this;
                if (!z) {
                    i2 = 0;
                }
                HoneyPayCardManagerUI.a(honeyPayCardManagerUI, i2);
                AppMethodBeat.o(64686);
            }
        });
        this.ykB.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(64687);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (HoneyPayCardManagerUI.this.ykL != null) {
                    Log.d(HoneyPayCardManagerUI.this.TAG, "click pay way: %s", Boolean.valueOf(HoneyPayCardManagerUI.this.ykL.MGl));
                    if (HoneyPayCardManagerUI.this.ykL.MGl) {
                        HoneyPayCardManagerUI.e(HoneyPayCardManagerUI.this);
                    } else {
                        HoneyPayCardManagerUI.f(HoneyPayCardManagerUI.this);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64687);
            }
        });
        String string = getString(R.string.e0s);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.append((CharSequence) getString(R.string.e0u));
        spannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(1, new q.a() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
            public final void dF(View view) {
                AppMethodBeat.i(64688);
                HoneyPayCardManagerUI.g(HoneyPayCardManagerUI.this);
                AppMethodBeat.o(64688);
            }
        }), string.length(), spannableStringBuilder.length(), 18);
        this.ykz.setClickable(true);
        this.ykz.setOnTouchListener(new o(this));
        this.ykz.setText(spannableStringBuilder);
        this.ykw = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.auh, (ViewGroup) null);
        this.ykG = findViewById(R.id.dr4);
        this.ykv = (ListView) findViewById(R.id.dra);
        this.ykv.addHeaderView(this.qgZ);
        this.ykv.addFooterView(this.ykw, null, false);
        this.ykI = new a(this, (byte) 0);
        this.ykv.setAdapter((ListAdapter) this.ykI);
        this.ykv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(64684);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                czq czq = (czq) adapterView.getAdapter().getItem(i2);
                if (czq != null && !Util.isNullOrNil(czq.url)) {
                    Log.i(HoneyPayCardManagerUI.this.TAG, "click item: %s, %s", Integer.valueOf(i2), Long.valueOf(czq.MEU));
                    f.p(HoneyPayCardManagerUI.this.getContext(), czq.url, false);
                    h.INSTANCE.a(15191, 0, 0, 0, 0, 1, 0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(64684);
            }
        });
        AppMethodBeat.o(64704);
    }

    static /* synthetic */ void a(HoneyPayCardManagerUI honeyPayCardManagerUI, int i2) {
        AppMethodBeat.i(64717);
        Log.i(honeyPayCardManagerUI.TAG, "do modify notify");
        i iVar = new i(i2);
        iVar.t(honeyPayCardManagerUI);
        honeyPayCardManagerUI.doSceneProgress(iVar, false);
        AppMethodBeat.o(64717);
    }

    static /* synthetic */ void e(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        AppMethodBeat.i(64718);
        Log.i(honeyPayCardManagerUI.TAG, "go to uni pay ui");
        com.tencent.mm.br.c.b(honeyPayCardManagerUI, "wallet", ".pwd.ui.WalletUniversalPayOrderUI", new Intent(), 3);
        AppMethodBeat.o(64718);
    }

    static /* synthetic */ void f(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        AppMethodBeat.i(64719);
        Log.i(honeyPayCardManagerUI.TAG, "show select payway dialog");
        ArrayList<Bankcard> yh = af.yh(false);
        final ArrayList arrayList = new ArrayList();
        for (Bankcard bankcard : yh) {
            if (!bankcard.fQf()) {
                arrayList.add(bankcard);
            } else {
                Log.i(honeyPayCardManagerUI.TAG, "remove honey card %s", bankcard.field_bindSerial);
            }
        }
        com.tencent.mm.plugin.wallet_core.ui.j.a(honeyPayCardManagerUI, arrayList, honeyPayCardManagerUI.ykK, honeyPayCardManagerUI.getString(R.string.e0q), honeyPayCardManagerUI.getString(R.string.e0p), false, "", new o.g() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(64689);
                HoneyPayCardManagerUI.this.ykK = (Bankcard) arrayList.get(i2);
                Log.i(HoneyPayCardManagerUI.this.TAG, "select bankcard: %s, %s", HoneyPayCardManagerUI.this.ykK.field_bindSerial, HoneyPayCardManagerUI.this.ykK.field_bankcardTypeName);
                HoneyPayCardManagerUI.this.ykM = HoneyPayCardManagerUI.this.ykL;
                dbf dbf = new dbf();
                dbf.MGh = HoneyPayCardManagerUI.this.ykK.field_desc;
                dbf.dDj = HoneyPayCardManagerUI.this.ykK.field_bankcardType;
                dbf.MGj = HoneyPayCardManagerUI.this.ykK.field_bindSerial;
                dbf.MGk = HoneyPayCardManagerUI.this.ykK.field_bankcardTail;
                HoneyPayCardManagerUI.this.ykL = dbf;
                HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
                HoneyPayCardManagerUI.i(HoneyPayCardManagerUI.this);
                AppMethodBeat.o(64689);
            }
        });
        h.INSTANCE.a(15191, 0, 0, 1, 0, 0, 0);
        AppMethodBeat.o(64719);
    }

    static /* synthetic */ void g(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        AppMethodBeat.i(64720);
        Log.i(honeyPayCardManagerUI.TAG, "go to quata ui");
        Intent intent = new Intent(honeyPayCardManagerUI, HoneyPayModifyQuotaUI.class);
        intent.putExtra("key_max_credit_line", honeyPayCardManagerUI.ykN);
        intent.putExtra("key_min_credit_line", honeyPayCardManagerUI.ykO);
        intent.putExtra("key_card_no", honeyPayCardManagerUI.yjY);
        honeyPayCardManagerUI.startActivityForResult(intent, 1);
        h.INSTANCE.a(15191, 0, 0, 0, 1, 0, 0);
        AppMethodBeat.o(64720);
    }

    static /* synthetic */ void i(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        AppMethodBeat.i(64721);
        Log.i(honeyPayCardManagerUI.TAG, "do modify pay way");
        j jVar = new j(honeyPayCardManagerUI.ykL, honeyPayCardManagerUI.yjY);
        jVar.t(honeyPayCardManagerUI);
        honeyPayCardManagerUI.doSceneProgress(jVar, false);
        AppMethodBeat.o(64721);
    }
}
