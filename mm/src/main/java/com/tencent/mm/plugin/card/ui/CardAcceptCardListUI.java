package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.h;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ab;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.p;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.dxg;
import com.tencent.mm.protocal.protobuf.dxy;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CardAcceptCardListUI extends MMActivity implements i, MMActivity.a {
    private View GT;
    int eaQ = 8;
    private q gxX = null;
    private String ixM = "";
    protected ListView pQq = null;
    protected RelativeLayout pQs = null;
    private boolean pSh = false;
    private String pUi = "";
    private int pUj;
    private String pUk;
    private int pUl;
    private String pUm;
    private Button pXa;
    public int pXh = 0;
    private String pXi = "";
    private String pXj = "";
    public ArrayList<String> pXk = new ArrayList<>();
    public ArrayList<String> pXl = new ArrayList<>();
    private View pYA;
    private View pYB;
    protected a pYC = null;
    private View pYD;
    private View pYE;
    private TextView pYF;
    private Button pYG;
    LinkedList<um> pYH = new LinkedList<>();
    int pYI = 7;
    String pYJ = "";
    String pYK = "";
    private String pYL = "";
    LinkedList<um> pYM = new LinkedList<>();
    LinkedList<String> pYN = new LinkedList<>();
    HashMap<String, Integer> pYu = new HashMap<>();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardAcceptCardListUI() {
        AppMethodBeat.i(113155);
        AppMethodBeat.o(113155);
    }

    static /* synthetic */ void a(CardAcceptCardListUI cardAcceptCardListUI, int i2) {
        AppMethodBeat.i(113167);
        cardAcceptCardListUI.Eq(i2);
        AppMethodBeat.o(113167);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.m1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(113156);
        setMMTitle(R.string.ana);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardAcceptCardListUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(113150);
                Log.v("MicroMsg.CardAcceptCardListUI", "setBackBtn cancel");
                CardAcceptCardListUI.a(CardAcceptCardListUI.this, 1);
                AppMethodBeat.o(113150);
                return true;
            }
        });
        this.pYA = findViewById(R.id.aju);
        this.pYB = findViewById(R.id.it1);
        this.GT = findViewById(R.id.ecu);
        this.pYB.setVisibility(4);
        this.pQq = (ListView) findViewById(16908298);
        this.pQs = (RelativeLayout) findViewById(R.id.bf4);
        this.pQq.setEmptyView(this.pQs);
        this.pYC = new a(this);
        this.pQq.setAdapter((ListAdapter) this.pYC);
        this.pQq.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardAcceptCardListUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(201306);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                a.a(this, "com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(201306);
            }
        });
        this.pYD = findViewById(R.id.ajy);
        this.pXa = (Button) findViewById(R.id.ajp);
        this.pXa.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardAcceptCardListUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(113151);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (CardAcceptCardListUI.this.pSh) {
                    CardAcceptCardListUI.a(CardAcceptCardListUI.this, CardAcceptCardListUI.b(CardAcceptCardListUI.this));
                } else {
                    CardAcceptCardListUI cardAcceptCardListUI = CardAcceptCardListUI.this;
                    LinkedList b2 = CardAcceptCardListUI.b(CardAcceptCardListUI.this);
                    cardAcceptCardListUI.ku(true);
                    g.aAg().hqi.a(new p(b2, cardAcceptCardListUI.eaQ, cardAcceptCardListUI.pYJ, cardAcceptCardListUI.pYK, cardAcceptCardListUI.pYI), 0);
                }
                a.a(this, "com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113151);
            }
        });
        this.pXa.setEnabled(false);
        this.pYE = findViewById(R.id.aom);
        this.pYF = (TextView) findViewById(R.id.aon);
        this.pYG = (Button) findViewById(R.id.aol);
        this.pYG.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardAcceptCardListUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(113152);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CardAcceptCardListUI.c(CardAcceptCardListUI.this);
                a.a(this, "com/tencent/mm/plugin/card/ui/CardAcceptCardListUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113152);
            }
        });
        Intent intent = getIntent();
        if (intent == null) {
            Log.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
            Eq(2);
            AppMethodBeat.o(113156);
            return;
        }
        Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
        String stringExtra = intent.getStringExtra("key_in_card_list");
        this.eaQ = intent.getIntExtra("key_from_scene", 8);
        String stringExtra2 = intent.getStringExtra("key_package_name");
        String stringExtra3 = intent.getStringExtra("key_sign");
        this.pYI = getIntent().getIntExtra("key_stastic_scene", 7);
        this.pYJ = getIntent().getStringExtra("src_username");
        this.pYK = getIntent().getStringExtra("js_url");
        this.pYL = getIntent().getStringExtra("key_consumed_card_id");
        this.ixM = getIntent().getStringExtra("key_template_id");
        ArrayList<um> cR = h.cR(stringExtra, this.eaQ);
        if (cR == null || cR.size() == 0) {
            Log.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
            Eq(2);
            AppMethodBeat.o(113156);
            return;
        }
        this.pYH.clear();
        this.pYH.addAll(cR);
        this.pYM.clear();
        this.pYN.clear();
        this.pYu.clear();
        LinkedList<um> linkedList = this.pYH;
        ku(true);
        g.aAg().hqi.a(new ab(linkedList, this.eaQ, stringExtra2, stringExtra3, this.pYJ, this.pYK, this.pYL, this.pYI), 0);
        AppMethodBeat.o(113156);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113157);
        super.onCreate(bundle);
        g.aAg().hqi.a(1079, this);
        g.aAg().hqi.a(1049, this);
        g.aAg().hqi.a(902, this);
        initView();
        AppMethodBeat.o(113157);
    }

    /* access modifiers changed from: package-private */
    public final void ku(boolean z) {
        AppMethodBeat.i(113159);
        if (z) {
            this.gxX = q.a(this, getString(R.string.ekc), false, 0, null);
            AppMethodBeat.o(113159);
            return;
        }
        if (this.gxX != null && this.gxX.isShowing()) {
            this.gxX.dismiss();
            this.gxX = null;
        }
        AppMethodBeat.o(113159);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(113160);
        if (i2 != 0 || i3 != 0) {
            Log.e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + qVar.getType() + "errType = " + i2 + " errCode = " + i3);
            ku(false);
            d.b(this, str, i3);
            if (qVar instanceof p) {
                this.pUi = str;
                AppMethodBeat.o(113160);
                return;
            } else if (qVar instanceof com.tencent.mm.plugin.card.sharecard.model.g) {
                this.pUi = "";
            }
        } else if (qVar instanceof ab) {
            ku(false);
            ab abVar = (ab) qVar;
            String str2 = abVar.pTY;
            this.pUj = abVar.pUj;
            this.pUk = abVar.pUk;
            this.pUl = abVar.pUl;
            this.pUm = abVar.pUm;
            Log.i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.pUj + "  accept_button_wording: " + this.pUk);
            Log.i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.pUl + "  private_wording: " + this.pUm);
            ArrayList<CardInfo> ajX = f.ajX(str2);
            ArrayList<CardInfo> cS = cS(ajX);
            if (ajX == null || ajX.size() <= 0) {
                Log.e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
            } else {
                Log.i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + ajX.size());
                if (cS != null && cS.size() > 0) {
                    a aVar = this.pYC;
                    HashMap<String, Integer> hashMap = this.pYu;
                    if (cS != null) {
                        aVar.pXz.clear();
                        aVar.pXz.addAll(cS);
                        aVar.pYu.putAll(hashMap);
                    }
                }
                this.pYC.notifyDataSetChanged();
                if (ajX.get(0).csw()) {
                    this.pSh = true;
                }
            }
            this.pYB.setVisibility(0);
            if (this.pYC.getCount() > 0) {
                CardInfo Ep = this.pYC.Ep(0);
                n.a(this, Ep);
                this.pYA.setBackgroundColor(l.ake(Ep.csQ().ixw));
                this.pYD.setVisibility(0);
                StateListDrawable stateListDrawable = new StateListDrawable();
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.vn);
                if (this.pUj == 1) {
                    this.pXa.setEnabled(true);
                    ShapeDrawable fi = l.fi(l.ake(Ep.csQ().ixw), dimensionPixelOffset);
                    int[] iArr = {16842919};
                    stateListDrawable.addState(iArr, l.fi(l.convertStringToRGB(Ep.csQ().ixw, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5), dimensionPixelOffset));
                    stateListDrawable.addState(new int[0], fi);
                } else {
                    this.pXa.setEnabled(false);
                    stateListDrawable.addState(new int[0], l.fi(l.convertStringToRGB(Ep.csQ().ixw, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5), dimensionPixelOffset));
                }
                this.pXa.setBackgroundDrawable(stateListDrawable);
                if (!TextUtils.isEmpty(this.pUk)) {
                    this.pXa.setText(this.pUk);
                }
                if (this.pUl == 1) {
                    int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.ir);
                    ShapeDrawable e2 = l.e(this, getResources().getColor(R.color.afz), dimensionPixelOffset2);
                    ShapeDrawable fi2 = l.fi(getResources().getColor(R.color.afz), dimensionPixelOffset2);
                    StateListDrawable stateListDrawable2 = new StateListDrawable();
                    stateListDrawable2.addState(new int[]{16842919}, fi2);
                    stateListDrawable2.addState(new int[0], e2);
                    this.pYG.setBackgroundDrawable(stateListDrawable2);
                    int[] iArr2 = {l.ake(Ep.csQ().ixw), getResources().getColor(R.color.afz)};
                    this.pYG.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr2));
                    this.pYE.setVisibility(0);
                    if (!TextUtils.isEmpty(this.pUm)) {
                        this.pYF.setText(this.pUm);
                        AppMethodBeat.o(113160);
                        return;
                    }
                    this.pYF.setText(R.string.asl);
                    AppMethodBeat.o(113160);
                    return;
                }
                this.pYE.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pYB.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.k5);
                layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.hw);
                this.pYB.setLayoutParams(layoutParams);
                this.pYB.invalidate();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.pYD.getLayoutParams();
                layoutParams2.addRule(8, R.id.ecu);
                this.pYD.setLayoutParams(layoutParams2);
                this.pYD.invalidate();
                AppMethodBeat.o(113160);
                return;
            }
            this.pYD.setVisibility(8);
            this.pYE.setVisibility(8);
            this.pYA.setBackgroundColor(getResources().getColor(R.color.hl));
            AppMethodBeat.o(113160);
            return;
        } else if (qVar instanceof p) {
            ku(false);
            p pVar = (p) qVar;
            if (pVar.pTZ != 0) {
                String str3 = pVar.pUa;
                if (TextUtils.isEmpty(str3)) {
                    str3 = getString(R.string.anp);
                }
                com.tencent.mm.ui.base.h.a((Context) this, str3, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.card.ui.CardAcceptCardListUI.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(113153);
                        dialogInterface.dismiss();
                        CardAcceptCardListUI.a(CardAcceptCardListUI.this, 2);
                        AppMethodBeat.o(113153);
                    }
                });
                this.pUi = pVar.pTY;
                AppMethodBeat.o(113160);
                return;
            }
            com.tencent.mm.ui.base.h.cD(this, getResources().getString(R.string.apk));
            Intent intent = new Intent();
            intent.putExtra("card_list", pVar.pTY);
            setResult(-1, intent);
            Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
            l.cxE();
            finish();
            AppMethodBeat.o(113160);
            return;
        } else if (qVar instanceof com.tencent.mm.plugin.card.sharecard.model.g) {
            ku(false);
            String str4 = ((com.tencent.mm.plugin.card.sharecard.model.g) qVar).pTY;
            int i4 = ((com.tencent.mm.plugin.card.sharecard.model.g) qVar).pTZ;
            String str5 = ((com.tencent.mm.plugin.card.sharecard.model.g) qVar).pUa;
            this.pUi = str4;
            if (i4 != 0) {
                if (TextUtils.isEmpty(str5)) {
                    str5 = getString(R.string.asw);
                }
                com.tencent.mm.ui.base.h.a((Context) this, str5, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.card.ui.CardAcceptCardListUI.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(113154);
                        dialogInterface.dismiss();
                        CardAcceptCardListUI.a(CardAcceptCardListUI.this, 2);
                        AppMethodBeat.o(113154);
                    }
                });
                AppMethodBeat.o(113160);
                return;
            }
            com.tencent.mm.ui.base.h.cD(this, getResources().getString(R.string.ang));
            Intent intent2 = new Intent();
            intent2.putExtra("card_list", this.pUi);
            setResult(-1, intent2);
            Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
            l.cxG();
            ShareCardInfo shareCardInfo = new ShareCardInfo();
            f.a(shareCardInfo, str4);
            l.a(shareCardInfo);
            am.ctX().onChange();
            finish();
            AppMethodBeat.o(113160);
            return;
        }
        AppMethodBeat.o(113160);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(113161);
        if (i2 == 4) {
            Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI onKeyDown() back cancel");
            Eq(1);
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(113161);
        return onKeyDown;
    }

    private void Eq(int i2) {
        AppMethodBeat.i(113162);
        Log.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:".concat(String.valueOf(i2)));
        Intent intent = new Intent();
        intent.putExtra("card_list", this.pUi);
        intent.putExtra("result_code", i2);
        setResult(0, intent);
        finish();
        AppMethodBeat.o(113162);
    }

    @Override // com.tencent.mm.ui.MMActivity.a
    public final void d(int i2, int i3, Intent intent) {
        AppMethodBeat.i(113163);
        switch (i2) {
            case 2:
                if (i3 == -1) {
                    this.pXh = intent.getIntExtra("Ktag_range_index", 0);
                    Log.i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", Integer.valueOf(this.pXh));
                    if (this.pXh < 2) {
                        cuZ();
                        break;
                    } else {
                        this.pXi = intent.getStringExtra("Klabel_name_list");
                        this.pXj = intent.getStringExtra("Kother_user_name_list");
                        Log.d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", Integer.valueOf(this.pXh), this.pXi);
                        if (!TextUtils.isEmpty(this.pXi) || !TextUtils.isEmpty(this.pXj)) {
                            List asList = Arrays.asList(this.pXi.split(","));
                            this.pXl = l.cZ(asList);
                            this.pXk = l.cY(asList);
                            if (this.pXj != null && this.pXj.length() > 0) {
                                this.pXk.addAll(Arrays.asList(this.pXj.split(",")));
                            }
                            if (this.pXl != null) {
                                Log.i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.pXl.size());
                            }
                            if (this.pXk != null) {
                                Log.i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.pXk.size());
                                Iterator<String> it = this.pXk.iterator();
                                while (it.hasNext()) {
                                    Log.d("MicroMsg.CardAcceptCardListUI", "username : %s", it.next());
                                }
                            }
                            if (TextUtils.isEmpty(this.pXi)) {
                                cuZ();
                            } else if (this.pXh == 2) {
                                this.pYF.setText(getString(R.string.asn, new Object[]{cuG()}));
                                AppMethodBeat.o(113163);
                                return;
                            } else if (this.pXh == 3) {
                                this.pYF.setText(getString(R.string.asm, new Object[]{cuG()}));
                                AppMethodBeat.o(113163);
                                return;
                            }
                            AppMethodBeat.o(113163);
                            return;
                        }
                        Log.e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
                        cuZ();
                        AppMethodBeat.o(113163);
                        return;
                    }
                } else {
                    AppMethodBeat.o(113163);
                    return;
                }
        }
        AppMethodBeat.o(113163);
    }

    private String cuG() {
        AppMethodBeat.i(113164);
        if (!TextUtils.isEmpty(this.pXi) && !TextUtils.isEmpty(this.pXj)) {
            String str = this.pXi + "," + l.akh(this.pXj);
            AppMethodBeat.o(113164);
            return str;
        } else if (!TextUtils.isEmpty(this.pXi)) {
            String str2 = this.pXi;
            AppMethodBeat.o(113164);
            return str2;
        } else if (!TextUtils.isEmpty(this.pXj)) {
            String akh = l.akh(this.pXj);
            AppMethodBeat.o(113164);
            return akh;
        } else {
            AppMethodBeat.o(113164);
            return "";
        }
    }

    private void cuZ() {
        AppMethodBeat.i(113165);
        if (!TextUtils.isEmpty(this.pUm)) {
            this.pYF.setText(this.pUm);
            AppMethodBeat.o(113165);
            return;
        }
        this.pYF.setText(R.string.asl);
        AppMethodBeat.o(113165);
    }

    private ArrayList<CardInfo> cS(List<CardInfo> list) {
        AppMethodBeat.i(113166);
        if (list == null || list.size() == 0) {
            Log.e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
            AppMethodBeat.o(113166);
            return null;
        }
        this.pYM.clear();
        this.pYN.clear();
        this.pYu.clear();
        ArrayList<CardInfo> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < list.size(); i2++) {
            CardInfo cardInfo = list.get(i2);
            if (this.pYN.contains(cardInfo.field_card_tp_id)) {
                this.pYu.put(cardInfo.field_card_tp_id, Integer.valueOf(this.pYu.get(cardInfo.field_card_tp_id).intValue() + 1));
            } else {
                arrayList.add(cardInfo);
                this.pYu.put(cardInfo.field_card_tp_id, 1);
                this.pYN.add(cardInfo.field_card_tp_id);
            }
        }
        AppMethodBeat.o(113166);
        return arrayList;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(113158);
        g.aAg().hqi.b(1079, this);
        g.aAg().hqi.b(1049, this);
        g.aAg().hqi.b(902, this);
        this.pYH.clear();
        a aVar = this.pYC;
        aVar.pXz.clear();
        aVar.mContext = null;
        super.onDestroy();
        AppMethodBeat.o(113158);
    }

    static /* synthetic */ LinkedList b(CardAcceptCardListUI cardAcceptCardListUI) {
        AppMethodBeat.i(113168);
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < cardAcceptCardListUI.pYH.size(); i2++) {
            linkedList.add(cardAcceptCardListUI.pYH.get(i2));
        }
        AppMethodBeat.o(113168);
        return linkedList;
    }

    static /* synthetic */ void a(CardAcceptCardListUI cardAcceptCardListUI, LinkedList linkedList) {
        AppMethodBeat.i(113169);
        cardAcceptCardListUI.ku(true);
        LinkedList linkedList2 = new LinkedList();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            um umVar = (um) linkedList.get(i2);
            dxg dxg = new dxg();
            dxg.pRX = umVar.pRX;
            dxg.eaP = umVar.eaP;
            dxg.KDg = cardAcceptCardListUI.pYJ;
            dxg.KDf = cardAcceptCardListUI.pYK;
            dxg.KDh = cardAcceptCardListUI.pYI;
            linkedList2.add(dxg);
        }
        dxy a2 = l.a(cardAcceptCardListUI.pXh, cardAcceptCardListUI.pXk, cardAcceptCardListUI.pXl);
        eck eck = new eck();
        eck.NcB = cardAcceptCardListUI.ixM;
        g.aAg().hqi.a(new com.tencent.mm.plugin.card.sharecard.model.g(0, linkedList2, "", cardAcceptCardListUI.pYL, a2, cardAcceptCardListUI.eaQ, eck), 0);
        AppMethodBeat.o(113169);
    }

    static /* synthetic */ void c(CardAcceptCardListUI cardAcceptCardListUI) {
        AppMethodBeat.i(113170);
        Log.i("MicroMsg.CardAcceptCardListUI", "doSelectShareUser");
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11582, "OpenShareUserSelectView", 0, "", "", "", "");
        Intent intent = new Intent();
        intent.putExtra("KLabel_range_index", cardAcceptCardListUI.pXh);
        intent.putExtra("Klabel_name_list", cardAcceptCardListUI.pXi);
        intent.putExtra("Kother_user_name_list", cardAcceptCardListUI.pXj);
        intent.putExtra("k_sns_label_ui_title", cardAcceptCardListUI.getString(R.string.aso));
        intent.putExtra("k_sns_label_ui_style", 0);
        intent.putExtra("KLabel_is_filter_private", true);
        c.b(cardAcceptCardListUI, "sns", ".ui.SnsLabelUI", intent, 2);
        cardAcceptCardListUI.mmSetOnActivityResultCallback(cardAcceptCardListUI);
        AppMethodBeat.o(113170);
    }
}
