package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.aj;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class CardListSelectedUI extends MMActivity implements i, j.a {
    private View GQ;
    private String app_id;
    private int gwE = 0;
    private q gxX = null;
    LinkedList<com.tencent.mm.plugin.card.model.a> heS = new LinkedList<>();
    boolean idt = true;
    private ListView mListView;
    private String pRX;
    com.tencent.mm.bw.b pUz = null;
    private boolean pXJ = false;
    private BaseAdapter pXY;
    private String pYS = "";
    private String pYT;
    private TextView qcA;
    private RelativeLayout qcB;
    private TextView qcC;
    private TextView qcD;
    boolean qcE = false;
    HashMap<Integer, Boolean> qcF = new HashMap<>();
    private boolean qcG;
    private boolean qcH;
    private boolean qcI;
    private int qcJ;
    private String qcK;
    private String qcL;
    private String qcM;
    private String qcN;
    private int qcO;
    public String qcP;
    private boolean qcQ = false;
    private com.tencent.mm.plugin.card.model.a qcR;
    private int time_stamp;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardListSelectedUI() {
        AppMethodBeat.i(113496);
        AppMethodBeat.o(113496);
    }

    static /* synthetic */ void a(CardListSelectedUI cardListSelectedUI) {
        AppMethodBeat.i(113511);
        cardListSelectedUI.cvn();
        AppMethodBeat.o(113511);
    }

    static /* synthetic */ void a(CardListSelectedUI cardListSelectedUI, String str) {
        AppMethodBeat.i(113510);
        cardListSelectedUI.aN(0, str);
        AppMethodBeat.o(113510);
    }

    static /* synthetic */ void e(CardListSelectedUI cardListSelectedUI) {
        AppMethodBeat.i(113513);
        cardListSelectedUI.cwd();
        AppMethodBeat.o(113513);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.o2;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113497);
        super.onCreate(bundle);
        am.cuc().a(this);
        Intent intent = getIntent();
        Log.i("MicroMsg.CardListSelectedUI", "initData()");
        if (intent == null) {
            Log.e("MicroMsg.CardListSelectedUI", "doGetCardList()  intent == null");
            setResult(1);
            aN(1, "");
            finish();
        } else {
            this.gwE = intent.getIntExtra("key_from_scene", 0);
            Log.i("MicroMsg.CardListSelectedUI", "mFromScene:" + this.gwE);
            this.app_id = intent.getStringExtra("app_id");
            this.qcJ = intent.getIntExtra("shop_id", 0);
            this.qcK = intent.getStringExtra("sign_type");
            this.qcL = intent.getStringExtra("card_sign");
            this.time_stamp = intent.getIntExtra("time_stamp", 0);
            this.qcM = intent.getStringExtra("nonce_str");
            this.pRX = intent.getStringExtra("card_tp_id");
            this.qcN = intent.getStringExtra("card_type");
            this.qcO = intent.getIntExtra("can_multi_select", 0);
            this.pYS = intent.getStringExtra("key_package_name");
            this.pYT = intent.getStringExtra("key_transaction");
            Log.i("MicroMsg.CardListSelectedUI", "app_id:" + this.app_id + " shop_id:" + this.qcJ + " sign_type:" + this.qcK + " time_stamp:" + this.time_stamp);
            Log.i("MicroMsg.CardListSelectedUI", "nonce_str:" + this.qcM + " card_tp_id:" + this.pRX + " card_type:" + this.qcN + " canMultiSelect:" + this.qcO + " packateName:" + this.pYS);
            if ("INVOICE".equalsIgnoreCase(this.qcN)) {
                this.qcQ = true;
            }
            if (TextUtils.isEmpty(this.app_id)) {
                Log.e("MicroMsg.CardListSelectedUI", "doGetCardList()  app_id is nulls");
                setResult(1);
                aN(1, "app_id  or card_sign is empty!");
                finish();
            }
        }
        cwd();
        initView();
        AppMethodBeat.o(113497);
    }

    private void cwd() {
        AppMethodBeat.i(113498);
        if (this.pXJ) {
            Log.e("MicroMsg.CardListSelectedUI", "doNetSceneGetShareCardsLayout, isDoingGetData is true");
            AppMethodBeat.o(113498);
            return;
        }
        if (this.pUz == null) {
            this.qcG = false;
            this.qcH = false;
            this.qcI = false;
        }
        g.aAg().hqi.a(1059, this);
        g.aAg().hqi.a(new aj(this.app_id, this.qcJ, this.qcK, this.qcL, this.time_stamp, this.qcM, this.pRX, this.qcN, this.pUz), 0);
        ku(true);
        this.pXJ = true;
        if (this.qcO == 1) {
            this.qcE = true;
        }
        AppMethodBeat.o(113498);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(113499);
        if (this.qcQ) {
            setMMTitle(R.string.ar0);
        } else {
            setMMTitle(R.string.aqz);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardListSelectedUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(113482);
                CardListSelectedUI.this.setResult(0);
                CardListSelectedUI.a(CardListSelectedUI.this, "");
                CardListSelectedUI.this.finish();
                AppMethodBeat.o(113482);
                return true;
            }
        });
        if (!this.qcQ) {
            addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.card.ui.CardListSelectedUI.AnonymousClass2 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(113483);
                    if (CardListSelectedUI.this.qcE || !CardListSelectedUI.this.qcR.pSh) {
                        CardListSelectedUI.a(CardListSelectedUI.this);
                    } else {
                        CardListSelectedUI.this.ku(true);
                        am.cuc().V(CardListSelectedUI.this.qcR.pSc, l.akk(CardListSelectedUI.this.qcR.userName), 3);
                    }
                    AppMethodBeat.o(113483);
                    return true;
                }
            });
            enableOptionMenu(false);
        }
        this.mListView = (ListView) findViewById(R.id.ank);
        if (this.qcQ) {
            this.pXY = new b();
        } else {
            this.pXY = new a();
        }
        this.mListView.setAdapter((ListAdapter) this.pXY);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardListSelectedUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(113484);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardListSelectedUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (view.getAlpha() != 1.0f) {
                    Log.d("MicroMsg.CardListSelectedUI", "item view is gray, cannot click, do nothing return！");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(113484);
                    return;
                }
                if (CardListSelectedUI.this.qcE) {
                    CardListSelectedUI.this.qcF.put(Integer.valueOf(i2), Boolean.valueOf(!CardListSelectedUI.this.qcF.get(Integer.valueOf(i2)).booleanValue()));
                } else {
                    for (int i3 = 0; i3 < CardListSelectedUI.this.heS.size(); i3++) {
                        CardListSelectedUI.this.qcF.put(Integer.valueOf(i3), Boolean.FALSE);
                    }
                    CardListSelectedUI.this.qcF.put(Integer.valueOf(i2), Boolean.TRUE);
                    CardListSelectedUI.this.qcR = CardListSelectedUI.this.heS.get(i2);
                }
                CardListSelectedUI.this.pXY.notifyDataSetChanged();
                CardListSelectedUI.d(CardListSelectedUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(113484);
            }
        });
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.card.ui.CardListSelectedUI.AnonymousClass4 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(113485);
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !CardListSelectedUI.this.idt) {
                    Log.d("MicroMsg.CardListSelectedUI", "onScroll() >> doGetCardList()");
                    CardListSelectedUI.e(CardListSelectedUI.this);
                }
                AppMethodBeat.o(113485);
            }
        });
        this.GQ = findViewById(R.id.bf4);
        this.qcA = (TextView) findViewById(R.id.fzl);
        if (this.qcQ) {
            this.qcA.setText(getString(R.string.as4));
        }
        this.qcB = (RelativeLayout) findViewById(R.id.e0d);
        this.qcC = (TextView) findViewById(R.id.e0u);
        this.qcD = (TextView) findViewById(R.id.e0p);
        if (this.qcQ) {
            this.qcB.setVisibility(0);
            this.qcC.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.card.ui.CardListSelectedUI.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(113486);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardListSelectedUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!Util.isNullOrNil(CardListSelectedUI.this.qcP)) {
                        com.tencent.mm.plugin.card.d.b.a(CardListSelectedUI.this, CardListSelectedUI.this.qcP, CardListSelectedUI.this.getString(R.string.aqo));
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113486);
                }
            });
            this.qcD.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.card.ui.CardListSelectedUI.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(113487);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardListSelectedUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    CardListSelectedUI.a(CardListSelectedUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113487);
                }
            });
            AppMethodBeat.o(113499);
            return;
        }
        this.qcB.setVisibility(8);
        AppMethodBeat.o(113499);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(113500);
        if (qVar instanceof aj) {
            g.aAg().hqi.b(1059, this);
            ku(false);
            if (i2 == 0 && i3 == 0) {
                String str2 = ((aj) qVar).pTY;
                Log.d("MicroMsg.CardListSelectedUI", str2);
                LinkedList<com.tencent.mm.plugin.card.model.a> aji = com.tencent.mm.plugin.card.model.a.aji(str2);
                LinkedList<com.tencent.mm.plugin.card.model.a> ajj = com.tencent.mm.plugin.card.model.a.ajj(str2);
                this.qcP = ajJ(str2);
                if (this.pUz == null && !(aji == null && ajj == null)) {
                    this.qcF.clear();
                    this.heS.clear();
                }
                if (aji != null) {
                    if (aji.size() > 0 && !this.qcG) {
                        this.qcG = true;
                        if (this.qcQ) {
                            aji.get(0).pnW = getString(R.string.ase);
                        } else {
                            aji.get(0).pnW = getString(R.string.asd);
                        }
                    }
                    this.heS.addAll(aji);
                    for (int size = this.heS.size(); size < this.heS.size(); size++) {
                        this.qcF.put(Integer.valueOf(size), Boolean.FALSE);
                    }
                }
                if (ajj != null) {
                    if (ajj.size() > 0 && !this.qcH) {
                        this.qcH = true;
                        ajj.get(0).pnW = getString(R.string.ao_);
                    }
                    this.heS.addAll(ajj);
                    for (int size2 = this.heS.size(); size2 < this.heS.size(); size2++) {
                        this.qcF.put(Integer.valueOf(size2), Boolean.FALSE);
                    }
                }
                this.idt = ((aj) qVar).idt;
                this.pUz = ((aj) qVar).pUz;
                this.pXY.notifyDataSetChanged();
            } else {
                com.tencent.mm.plugin.card.d.d.b(this, str, i3);
            }
            if (this.heS.size() != 0) {
                this.GQ.setVisibility(8);
                this.mListView.setVisibility(0);
            } else {
                this.GQ.setVisibility(0);
                this.mListView.setVisibility(8);
            }
            this.pXJ = false;
        }
        AppMethodBeat.o(113500);
    }

    private static String ajJ(String str) {
        String str2 = null;
        AppMethodBeat.i(113501);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(113501);
        } else {
            try {
                str2 = new JSONObject(str).optString("rule_url");
                AppMethodBeat.o(113501);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.CardListSelectedUI", e2, "", new Object[0]);
                AppMethodBeat.o(113501);
            }
        }
        return str2;
    }

    @Override // com.tencent.mm.plugin.card.b.j.a
    public final void b(String str, j.b bVar) {
        AppMethodBeat.i(113502);
        ku(false);
        if (TextUtils.isEmpty(str) || str.equals(this.qcR.pSc)) {
            Log.i("MicroMsg.CardListSelectedUI", "onMarkSuccess()");
            Log.i("MicroMsg.CardListSelectedUI", "markSucc:" + bVar.pRL + " markCardId: " + bVar.pRM);
            if (bVar.pRL == 1) {
                if (TextUtils.isEmpty(bVar.pRM) || str.equals(bVar.pRM)) {
                    Log.i("MicroMsg.CardListSelectedUI", "markCardId is same as now id!");
                } else {
                    Log.i("MicroMsg.CardListSelectedUI", "markCardId is diff as now id!");
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.heS.size()) {
                            break;
                        } else if (this.heS.get(i2).pSc == bVar.pRM) {
                            for (int i3 = 0; i3 < this.heS.size(); i3++) {
                                this.qcF.put(Integer.valueOf(i3), Boolean.FALSE);
                            }
                            this.qcF.put(Integer.valueOf(i2), Boolean.TRUE);
                        } else {
                            i2++;
                        }
                    }
                }
                cvn();
                AppMethodBeat.o(113502);
                return;
            }
            com.tencent.mm.plugin.card.d.d.c(this, getString(R.string.ar6));
            AppMethodBeat.o(113502);
            return;
        }
        Log.e("MicroMsg.CardListSelectedUI", "onMarkSuccess(), the mark card id is diff from current id!");
        AppMethodBeat.o(113502);
    }

    @Override // com.tencent.mm.plugin.card.b.j.a
    public final void fq(String str, String str2) {
        AppMethodBeat.i(113503);
        ku(false);
        if (TextUtils.isEmpty(str) || str.equals(this.qcR.pSc)) {
            Log.i("MicroMsg.CardListSelectedUI", "onMarkFail()");
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.string.ar5);
            }
            com.tencent.mm.plugin.card.d.d.c(this, str2);
            AppMethodBeat.o(113503);
            return;
        }
        Log.e("MicroMsg.CardListSelectedUI", "onMarkFail(), the mark card id is diff from current id!");
        AppMethodBeat.o(113503);
    }

    @Override // com.tencent.mm.plugin.card.b.j.a
    public final void ajf(String str) {
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        a() {
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(113491);
            com.tencent.mm.plugin.card.model.a Eu = Eu(i2);
            AppMethodBeat.o(113491);
            return Eu;
        }

        public final int getCount() {
            AppMethodBeat.i(113488);
            int size = CardListSelectedUI.this.heS.size();
            AppMethodBeat.o(113488);
            return size;
        }

        private com.tencent.mm.plugin.card.model.a Eu(int i2) {
            AppMethodBeat.i(113489);
            com.tencent.mm.plugin.card.model.a aVar = CardListSelectedUI.this.heS.get(i2);
            AppMethodBeat.o(113489);
            return aVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            d dVar;
            int i3;
            AppMethodBeat.i(113490);
            com.tencent.mm.plugin.card.model.a Eu = Eu(i2);
            if (view == null) {
                view = View.inflate(CardListSelectedUI.this, R.layout.om, null);
                dVar = new d();
                dVar.qcZ = (ImageView) view.findViewById(R.id.esi);
                dVar.hbb = (TextView) view.findViewById(R.id.ipm);
                dVar.qcV = (TextView) view.findViewById(R.id.id1);
                dVar.qda = (TextView) view.findViewById(R.id.wk);
                dVar.pnP = (TextView) view.findViewById(R.id.apx);
                dVar.qdb = view.findViewById(R.id.a_u);
                dVar.qdc = (ImageView) view.findViewById(R.id.ap2);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            if (l.Eg(Eu.nHh)) {
                dVar.hbb.setText(Eu.pRY);
                if (!TextUtils.isEmpty(Eu.title)) {
                    dVar.qcV.setVisibility(0);
                    dVar.qcV.setText(Eu.title);
                } else {
                    dVar.qcV.setVisibility(8);
                }
                if (!TextUtils.isEmpty(Eu.pRZ)) {
                    dVar.qda.setVisibility(0);
                    dVar.qda.setText(Eu.pRZ);
                } else {
                    dVar.qda.setVisibility(8);
                }
                TextView textView = dVar.pnP;
                if (Util.isNullOrNil(Eu.pnW)) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                textView.setVisibility(i3);
                dVar.pnP.setText(Eu.pnW);
                CardListSelectedUI.a(dVar.qcZ, Eu.iwv, CardListSelectedUI.this.getBaseContext().getResources().getDimensionPixelSize(R.dimen.vz));
                Boolean bool = CardListSelectedUI.this.qcF.get(Integer.valueOf(i2));
                if (bool == null || !bool.booleanValue()) {
                    dVar.qdc.setImageResource(R.drawable.kz);
                } else {
                    dVar.qdc.setImageResource(R.drawable.ky);
                }
            } else {
                Log.i("MicroMsg.CardListSelectedUI", "not support type");
            }
            AppMethodBeat.o(113490);
            return view;
        }
    }

    class d {
        public TextView hbb;
        public TextView pnP;
        public TextView qcV;
        public ImageView qcZ;
        public TextView qda;
        public View qdb;
        public ImageView qdc;

        d() {
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends BaseAdapter {
        b() {
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(113495);
            com.tencent.mm.plugin.card.model.a Eu = Eu(i2);
            AppMethodBeat.o(113495);
            return Eu;
        }

        public final int getCount() {
            AppMethodBeat.i(113492);
            int size = CardListSelectedUI.this.heS.size();
            AppMethodBeat.o(113492);
            return size;
        }

        private com.tencent.mm.plugin.card.model.a Eu(int i2) {
            AppMethodBeat.i(113493);
            com.tencent.mm.plugin.card.model.a aVar = CardListSelectedUI.this.heS.get(i2);
            AppMethodBeat.o(113493);
            return aVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(113494);
            com.tencent.mm.plugin.card.model.a Eu = Eu(i2);
            if (view == null) {
                view = View.inflate(CardListSelectedUI.this, R.layout.ol, null);
                cVar = new c();
                cVar.qcT = (ImageView) view.findViewById(R.id.ap2);
                cVar.qcU = (TextView) view.findViewById(R.id.e0o);
                cVar.hbb = (TextView) view.findViewById(R.id.ipm);
                cVar.qcV = (TextView) view.findViewById(R.id.id1);
                cVar.qcW = view.findViewById(R.id.j27);
                cVar.qcX = (TextView) view.findViewById(R.id.e0s);
                cVar.qcY = (TextView) view.findViewById(R.id.e0g);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            if (l.Eg(Eu.nHh)) {
                if (!TextUtils.isEmpty(Eu.title)) {
                    cVar.hbb.setVisibility(0);
                    cVar.hbb.setText(Eu.title);
                } else {
                    cVar.hbb.setVisibility(8);
                }
                if (!TextUtils.isEmpty(Eu.pRY)) {
                    cVar.qcV.setVisibility(0);
                    cVar.qcV.setText(Eu.pRY);
                } else {
                    cVar.qcV.setVisibility(8);
                }
                if (Eu.pSd == 0) {
                    view.setAlpha(1.0f);
                    cVar.qcT.setVisibility(0);
                    cVar.qcU.setVisibility(8);
                    Boolean bool = CardListSelectedUI.this.qcF.get(Integer.valueOf(i2));
                    if (bool == null || !bool.booleanValue()) {
                        cVar.qcT.setImageResource(R.drawable.kz);
                    } else {
                        cVar.qcT.setImageResource(R.drawable.ky);
                    }
                } else if (Eu.pSd == 1) {
                    view.setAlpha(0.2f);
                    cVar.qcT.setVisibility(8);
                    if (!Util.isNullOrNil(Eu.pSg)) {
                        cVar.qcU.setVisibility(0);
                        cVar.qcU.setText(Eu.pSg);
                    } else {
                        cVar.qcU.setVisibility(8);
                    }
                } else {
                    cVar.qcT.setVisibility(8);
                    cVar.qcU.setVisibility(8);
                }
                if (!Util.isNullOrNil(Eu.pSe)) {
                    cVar.qcX.setVisibility(0);
                    cVar.qcX.setText(Eu.pSe);
                } else {
                    cVar.qcX.setVisibility(8);
                }
                if (!Util.isNullOrNil(Eu.pSf)) {
                    cVar.qcY.setVisibility(0);
                    cVar.qcY.setText(Eu.pSf);
                } else {
                    cVar.qcY.setVisibility(8);
                }
                if (!Util.isNullOrNil(Eu.pSe) || !Util.isNullOrNil(Eu.pSf)) {
                    cVar.qcW.setVisibility(0);
                } else {
                    cVar.qcW.setVisibility(8);
                }
            } else {
                Log.i("MicroMsg.CardListSelectedUI", "not support type");
            }
            AppMethodBeat.o(113494);
            return view;
        }
    }

    class c {
        public TextView hbb;
        public ImageView qcT;
        public TextView qcU;
        public TextView qcV;
        public View qcW;
        public TextView qcX;
        public TextView qcY;

        c() {
        }
    }

    /* access modifiers changed from: protected */
    public final void ku(boolean z) {
        AppMethodBeat.i(113505);
        if (z) {
            this.gxX = q.a(this, getString(R.string.ekc), false, 0, null);
            AppMethodBeat.o(113505);
            return;
        }
        if (this.gxX != null && this.gxX.isShowing()) {
            this.gxX.dismiss();
            this.gxX = null;
        }
        AppMethodBeat.o(113505);
    }

    private void cvn() {
        AppMethodBeat.i(113506);
        Intent intent = new Intent();
        String cwe = cwe();
        if (this.qcQ) {
            intent.putExtra("choose_invoice_info", cwe);
        } else {
            intent.putExtra("choose_card_info", cwe);
        }
        setResult(-1, intent);
        aN(-1, cwe);
        finish();
        AppMethodBeat.o(113506);
    }

    private String cwe() {
        AppMethodBeat.i(113507);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.heS.size(); i2++) {
            Boolean bool = this.qcF.get(Integer.valueOf(i2));
            if (bool != null && bool.booleanValue()) {
                arrayList.add(this.heS.get(i2));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            com.tencent.mm.plugin.card.model.a aVar = (com.tencent.mm.plugin.card.model.a) arrayList.get(i3);
            sb.append("{");
            sb.append("\"card_id\":");
            sb.append("\"" + aVar.pRX + "\"");
            sb.append(",");
            sb.append("\"encrypt_code\":");
            sb.append("\"" + aVar.pSa + "\"");
            if (this.qcQ) {
                sb.append(",");
                sb.append("\"app_id\":");
                sb.append("\"" + aVar.app_id + "\"");
            }
            sb.append("}");
        }
        sb.append("]");
        String sb2 = sb.toString();
        AppMethodBeat.o(113507);
        return sb2;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(113508);
        if (i2 == 4) {
            setResult(0);
            aN(0, "");
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(113508);
        return onKeyDown;
    }

    private void aN(int i2, String str) {
        AppMethodBeat.i(113509);
        if (this.gwE != 8) {
            Log.e("MicroMsg.CardListSelectedUI", "setResultToSDK need MM_CARD_ITEM_FROM_SCENE_OPENAPI scene, the fromscene is " + this.gwE);
            AppMethodBeat.o(113509);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_wxapi_choose_card_from_wx_card_list", str);
        com.tencent.mm.pluginsdk.model.app.g o = h.o(this.app_id, true, false);
        ChooseCardFromWXCardPackage.Resp resp = new ChooseCardFromWXCardPackage.Resp(bundle);
        if (o != null) {
            resp.openId = o.field_openId;
        }
        resp.transaction = this.pYT;
        Object[] objArr = new Object[4];
        objArr[0] = this.app_id;
        objArr[1] = o == null ? "null appinfo" : o.field_appName;
        objArr[2] = o == null ? "null appinfo" : o.field_openId;
        objArr[3] = this.pYT;
        Log.i("MicroMsg.CardListSelectedUI", "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s", objArr);
        resp.toBundle(bundle);
        Log.i("MicroMsg.CardListSelectedUI", "setResultToSDK result:".concat(String.valueOf(i2)));
        Log.d("MicroMsg.CardListSelectedUI", "setResultToSDK card_list:".concat(String.valueOf(str)));
        if (i2 == -1) {
            resp.errCode = 0;
        } else {
            resp.errCode = -2;
        }
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.targetPkgName = this.pYS;
        args.bundle = bundle;
        com.tencent.mm.pluginsdk.model.app.q.bo(bundle);
        com.tencent.mm.pluginsdk.model.app.q.bp(bundle);
        MMessageActV2.send(MMApplicationContext.getContext(), args);
        AppMethodBeat.o(113509);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(113504);
        am.cuc().b(this);
        super.onDestroy();
        AppMethodBeat.o(113504);
    }

    static /* synthetic */ void d(CardListSelectedUI cardListSelectedUI) {
        AppMethodBeat.i(113512);
        for (int i2 = 0; i2 < cardListSelectedUI.heS.size(); i2++) {
            Boolean bool = cardListSelectedUI.qcF.get(Integer.valueOf(i2));
            if (bool != null && bool.booleanValue()) {
                cardListSelectedUI.enableOptionMenu(true);
            }
        }
        AppMethodBeat.o(113512);
    }

    static /* synthetic */ void a(ImageView imageView, String str, int i2) {
        AppMethodBeat.i(113514);
        n.a(imageView, str, i2, (int) R.drawable.ci4, true);
        AppMethodBeat.o(113514);
    }
}
