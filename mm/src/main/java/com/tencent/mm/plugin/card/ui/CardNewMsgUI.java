package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.tw;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.List;

public class CardNewMsgUI extends MMActivity implements k.a {
    private View GQ;
    View.OnClickListener kuO = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.card.ui.CardNewMsgUI.AnonymousClass9 */

        public final void onClick(View view) {
            AppMethodBeat.i(113527);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getId() == R.id.c7n) {
                g gVar = (g) view.getTag();
                if (gVar == null || gVar.ctH() == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113527);
                    return;
                }
                h.INSTANCE.a(11941, 2, gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, "");
                if (gVar.ctH().pTI == 0) {
                    Log.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
                    if (!TextUtils.isEmpty(gVar.ctH().url)) {
                        com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, gVar.ctH().url, 2);
                    } else {
                        Log.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
                    }
                } else if (gVar.ctH().pTI == 1) {
                    Log.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
                    Intent intent = new Intent();
                    intent.putExtra("KEY_CARD_ID", gVar.field_card_id);
                    intent.putExtra("KEY_CARD_TP_ID", gVar.field_card_tp_id);
                    intent.setClass(CardNewMsgUI.this, CardShopUI.class);
                    CardNewMsgUI cardNewMsgUI = CardNewMsgUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(cardNewMsgUI, bl.axQ(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    cardNewMsgUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(cardNewMsgUI, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    h.INSTANCE.a(11324, "UsedStoresView", Integer.valueOf(gVar.field_card_type), gVar.field_card_tp_id, gVar.field_card_id, 0, 0, "", 0, "");
                }
            } else if (view.getId() == R.id.g4t) {
                g gVar2 = (g) view.getTag();
                if (gVar2 == null || gVar2.ctI() == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113527);
                    return;
                } else if (gVar2.ctI().type == 0) {
                    Log.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
                    if (!TextUtils.isEmpty(gVar2.ctI().url)) {
                        com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, gVar2.ctI().url, 2);
                    } else {
                        Log.e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
                    }
                } else if (gVar2.ctI().type == 1) {
                    Log.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_CARDS");
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113527);
        }
    };
    private ListView mListView;
    private a qdk;
    private View qdl;
    private View qdm = null;
    private boolean qdn = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardNewMsgUI() {
        AppMethodBeat.i(113537);
        AppMethodBeat.o(113537);
    }

    static /* synthetic */ void g(CardNewMsgUI cardNewMsgUI) {
        AppMethodBeat.i(113546);
        cardNewMsgUI.cuE();
        AppMethodBeat.o(113546);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.o8;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113538);
        super.onCreate(bundle);
        initView();
        am.ctU().a(this);
        am.ctU().ctE();
        AppMethodBeat.o(113538);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(113539);
        this.qdk.ebf();
        am.ctU().b(this);
        if (am.ctS().ctM() > 0) {
            am.ctS().ctN();
        }
        super.onDestroy();
        AppMethodBeat.o(113539);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(113540);
        setMMTitle(R.string.arj);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardNewMsgUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(113519);
                CardNewMsgUI.this.finish();
                AppMethodBeat.o(113519);
                return true;
            }
        });
        this.mListView = (ListView) findViewById(R.id.ao5);
        this.qdk = new a();
        this.mListView.setAdapter((ListAdapter) this.qdk);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardNewMsgUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(113520);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardNewMsgUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (i2 == CardNewMsgUI.this.qdk.getCount()) {
                    int i3 = 1;
                    if (am.ctS().ctM() > 0) {
                        am.ctS().ctN();
                    } else {
                        i3 = CardNewMsgUI.this.qdk.cwh();
                    }
                    CardNewMsgUI.this.qdk.onNotifyChange(null, null);
                    if (!CardNewMsgUI.this.qdn) {
                        if (CardNewMsgUI.this.qdl.getParent() != null) {
                            Log.d("MicroMsg.CardNewMsgUI", "remove footer");
                            CardNewMsgUI.this.mListView.removeFooterView(CardNewMsgUI.this.qdl);
                        }
                        if (!CardNewMsgUI.this.qdk.cwg() && CardNewMsgUI.this.qdm.getParent() == null && i3 > 0) {
                            CardNewMsgUI.this.mListView.addFooterView(CardNewMsgUI.this.qdm);
                            Log.i("MicroMsg.CardNewMsgUI", "add mLoadingFooterView");
                        }
                    }
                    CardNewMsgUI.this.qdn = true;
                    CardNewMsgUI.this.qdl.setVisibility(8);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(113520);
                    return;
                }
                CardNewMsgUI.a(CardNewMsgUI.this, i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(113520);
            }
        });
        this.mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardNewMsgUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(113521);
                CardNewMsgUI.b(CardNewMsgUI.this, i2);
                AppMethodBeat.o(113521);
                return true;
            }
        });
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.card.ui.CardNewMsgUI.AnonymousClass4 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(113522);
                if (!CardNewMsgUI.this.qdn) {
                    AppMethodBeat.o(113522);
                } else if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    if (am.ctS().ctM() > 0) {
                        am.ctS().ctN();
                    } else {
                        CardNewMsgUI.this.qdk.cwh();
                    }
                    CardNewMsgUI.this.qdk.onNotifyChange(null, null);
                    AppMethodBeat.o(113522);
                } else {
                    AppMethodBeat.o(113522);
                }
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
        this.qdk.a(new s.a() {
            /* class com.tencent.mm.plugin.card.ui.CardNewMsgUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.s.a
            public final void bnE() {
                AppMethodBeat.i(113523);
                CardNewMsgUI.g(CardNewMsgUI.this);
                if (CardNewMsgUI.this.qdk.cwg() && am.ctS().ctM() == 0) {
                    CardNewMsgUI.this.qdl.setVisibility(8);
                }
                AppMethodBeat.o(113523);
            }
        });
        addTextOptionMenu(0, getString(R.string.anu), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardNewMsgUI.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(113524);
                h.INSTANCE.a(11582, "CardMsgClearMenu", 2, 0, "", "", "");
                CardNewMsgUI.h(CardNewMsgUI.this);
                AppMethodBeat.o(113524);
                return true;
            }
        });
        this.GQ = findViewById(R.id.bf4);
        cuE();
        this.qdl = aa.jQ(this).inflate(R.layout.o5, (ViewGroup) null);
        this.qdm = aa.jQ(this).inflate(R.layout.b84, (ViewGroup) null);
        int ctM = am.ctS().ctM();
        if (ctM > 0) {
            this.mListView.addFooterView(this.qdl);
            AppMethodBeat.o(113540);
        } else if (this.qdk.cwg() || ctM != 0 || am.ctS().getCount() <= 0) {
            if (this.qdk.cwg() && ctM == 0) {
                am.ctS().getCount();
            }
            AppMethodBeat.o(113540);
        } else {
            this.mListView.addFooterView(this.qdm);
            this.qdn = true;
            AppMethodBeat.o(113540);
        }
    }

    private void cuE() {
        AppMethodBeat.i(113541);
        if (am.ctU().getCount() > 0) {
            this.mListView.setVisibility(0);
            this.GQ.setVisibility(8);
            enableOptionMenu(true);
        } else {
            this.mListView.setVisibility(8);
            this.GQ.setVisibility(0);
            enableOptionMenu(false);
        }
        this.qdk.notifyDataSetChanged();
        AppMethodBeat.o(113541);
    }

    private void aM(String str, boolean z) {
        AppMethodBeat.i(113542);
        Intent intent = new Intent(this, CardDetailUI.class);
        intent.putExtra("key_card_id", str);
        intent.putExtra("key_is_share_card", z);
        intent.putExtra("key_from_scene", 4);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI", "gotoCardDetailUI", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI", "gotoCardDetailUI", "(Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(113542);
    }

    /* access modifiers changed from: package-private */
    public class a extends s<g> {
        private int gAZ = this.qdp;
        private int qdp = 10;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
        @Override // com.tencent.mm.ui.s
        public final /* synthetic */ g a(g gVar, Cursor cursor) {
            AppMethodBeat.i(113536);
            g gVar2 = gVar;
            if (gVar2 == null) {
                gVar2 = new g();
            }
            gVar2.convertFrom(cursor);
            AppMethodBeat.o(113536);
            return gVar2;
        }

        public a() {
            super(CardNewMsgUI.this, new g());
            AppMethodBeat.i(113530);
            Bh(true);
            AppMethodBeat.o(113530);
        }

        @Override // com.tencent.mm.ui.s
        public final void anp() {
            AppMethodBeat.i(113531);
            if (am.ctS().ctM() > 0) {
                setCursor(am.ctS().db.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[]{"1"}));
            } else {
                this.gAZ = am.ctS().getCount();
                com.tencent.mm.plugin.card.model.h ctS = am.ctS();
                setCursor(ctS.db.rawQuery("select * from CardMsgInfo order by time desc LIMIT ".concat(String.valueOf(this.qdp)), null));
            }
            notifyDataSetChanged();
            AppMethodBeat.o(113531);
        }

        @Override // com.tencent.mm.ui.s
        public final void anq() {
            AppMethodBeat.i(113532);
            ebf();
            anp();
            AppMethodBeat.o(113532);
        }

        public final boolean cwg() {
            return this.qdp >= this.gAZ;
        }

        public final int cwh() {
            AppMethodBeat.i(113533);
            if (cwg()) {
                if (CardNewMsgUI.this.qdm.getParent() != null) {
                    CardNewMsgUI.this.mListView.removeFooterView(CardNewMsgUI.this.qdm);
                }
                AppMethodBeat.o(113533);
                return 0;
            }
            this.qdp += 10;
            if (this.qdp <= this.gAZ) {
                AppMethodBeat.o(113533);
                return 10;
            }
            this.qdp = this.gAZ;
            int i2 = this.gAZ % 10;
            AppMethodBeat.o(113533);
            return i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(113534);
            g gVar = (g) getItem(i2);
            if (view == null) {
                view = View.inflate(CardNewMsgUI.this.getContext(), R.layout.o6, null);
                b bVar2 = new b(CardNewMsgUI.this, (byte) 0);
                bVar2.qdu = (ImageView) view.findViewById(R.id.esi);
                bVar2.qdv = view.findViewById(R.id.apo);
                bVar2.qdw = (ImageView) view.findViewById(R.id.apn);
                bVar2.qdx = (TextView) view.findViewById(R.id.ir3);
                bVar2.qdy = (TextView) view.findViewById(R.id.in3);
                bVar2.qdz = (TextView) view.findViewById(R.id.bn9);
                bVar2.qdA = (TextView) view.findViewById(R.id.c7n);
                bVar2.qdB = (TextView) view.findViewById(R.id.i3t);
                bVar2.qdC = view.findViewById(R.id.g4t);
                bVar2.qdD = (TextView) view.findViewById(R.id.g4u);
                bVar2.qdE = (LinearLayout) view.findViewById(R.id.b9);
                bVar2.qdF = (LinearLayout) view.findViewById(R.id.b_);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.qdx.setText(gVar.field_title);
            bVar.qdy.setText(f.c(CardNewMsgUI.this, ((long) gVar.field_time) * 1000, true));
            bVar.qdz.setText(gVar.field_description);
            int dimensionPixelSize = CardNewMsgUI.this.getResources().getDimensionPixelSize(R.dimen.vu);
            Log.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + i2 + " logo_url :  " + gVar.field_logo_url);
            if (TextUtils.isEmpty(gVar.field_logo_color)) {
                bVar.qdv.setVisibility(8);
                bVar.qdu.setVisibility(0);
                bVar.qdu.setImageResource(R.drawable.ci4);
                n.a(bVar.qdu, gVar.field_logo_url, dimensionPixelSize, (int) R.drawable.ci4, true);
            } else {
                Log.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + i2 + " field_logo_color :  " + gVar.field_logo_color);
                bVar.qdv.setVisibility(0);
                bVar.qdu.setVisibility(8);
                if (!TextUtils.isEmpty(gVar.field_logo_url)) {
                    n.a(CardNewMsgUI.this, bVar.qdw, gVar.field_logo_url, dimensionPixelSize, l.ake(gVar.field_logo_color));
                } else {
                    n.b(bVar.qdw, R.drawable.c2i, l.ake(gVar.field_logo_color));
                }
            }
            tw ctH = gVar.ctH();
            if (ctH == null || TextUtils.isEmpty(ctH.text)) {
                bVar.qdA.setVisibility(8);
            } else {
                bVar.qdA.setText(ctH.text);
                bVar.qdA.setTag(gVar);
                bVar.qdA.setVisibility(0);
                bVar.qdA.setOnClickListener(CardNewMsgUI.this.kuO);
            }
            uo ctI = gVar.ctI();
            if (ctI == null || TextUtils.isEmpty(ctI.text)) {
                bVar.qdC.setVisibility(8);
                bVar.qdB.setVisibility(8);
            } else {
                bVar.qdD.setText(ctI.text);
                bVar.qdC.setVisibility(0);
                bVar.qdC.setOnClickListener(CardNewMsgUI.this.kuO);
                bVar.qdC.setTag(gVar);
                bVar.qdB.setVisibility(0);
            }
            gVar.ctJ();
            gVar.ctK();
            a(gVar.pTC, gVar.pTD, bVar, gVar);
            AppMethodBeat.o(113534);
            return view;
        }

        private void a(List<g.a> list, List<g.b> list2, b bVar, final g gVar) {
            AppMethodBeat.i(113535);
            bVar.qdE.removeAllViews();
            if ((list == null || list.size() == 0) && (list2 == null || list2.size() == 0)) {
                bVar.qdF.setVisibility(8);
                AppMethodBeat.o(113535);
                return;
            }
            if (!Util.isNullOrNil(list)) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    final g.a aVar = list.get(i2);
                    View inflate = View.inflate(CardNewMsgUI.this.getContext(), R.layout.lz, null);
                    if (i2 == 0) {
                        inflate.findViewById(R.id.ajr).setVisibility(8);
                    }
                    ((TextView) inflate.findViewById(R.id.ajt)).setText(aVar.title);
                    ((TextView) inflate.findViewById(R.id.ajs)).setText(aVar.oqZ);
                    Button button = (Button) inflate.findViewById(R.id.ajq);
                    button.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.card.ui.CardNewMsgUI.a.AnonymousClass1 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(113528);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Intent intent = new Intent();
                            if (aVar.pTI == 0) {
                                intent.setClass(CardNewMsgUI.this.getContext(), CardDetailUI.class);
                                intent.putExtra("key_card_id", aVar.cardId);
                                intent.putExtra("key_card_ext", aVar.cardExt);
                                intent.putExtra("key_from_scene", 17);
                                CardNewMsgUI cardNewMsgUI = CardNewMsgUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(cardNewMsgUI, bl.axQ(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                cardNewMsgUI.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(cardNewMsgUI, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            } else if (aVar.pTI == 1) {
                                intent.setClass(CardNewMsgUI.this.getContext(), CardConsumeSuccessUI.class);
                                intent.putExtra("key_card_id", gVar.field_card_id);
                                intent.putExtra("key_from_scene", 2);
                                CardNewMsgUI cardNewMsgUI2 = CardNewMsgUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(cardNewMsgUI2, bl2.axQ(), "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                cardNewMsgUI2.startActivity((Intent) bl2.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(cardNewMsgUI2, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            }
                            h.INSTANCE.a(11941, 8, gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, aVar.cardId);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(113528);
                        }
                    });
                    if (aVar.pTI == 0) {
                        button.setText(R.string.an7);
                    } else if (aVar.pTI == 1) {
                        button.setText(R.string.an8);
                    }
                    bVar.qdE.addView(inflate);
                }
            }
            if (!Util.isNullOrNil(list2)) {
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    final g.b bVar2 = list2.get(i3);
                    View inflate2 = View.inflate(CardNewMsgUI.this.getContext(), R.layout.lz, null);
                    if (i3 == 0 && Util.isNullOrNil(list)) {
                        inflate2.findViewById(R.id.ajr).setVisibility(8);
                    }
                    ((TextView) inflate2.findViewById(R.id.ajt)).setText(bVar2.title);
                    ((TextView) inflate2.findViewById(R.id.ajs)).setText(bVar2.description);
                    Button button2 = (Button) inflate2.findViewById(R.id.ajq);
                    button2.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.card.ui.CardNewMsgUI.a.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(113529);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (!TextUtils.isEmpty(bVar2.pTL)) {
                                com.tencent.mm.plugin.card.d.b.a(CardNewMsgUI.this, bVar2.pTL, 2);
                            } else {
                                Log.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardNewMsgUI$CardMsgAdaper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(113529);
                        }
                    });
                    button2.setText(bVar2.pTK);
                    bVar.qdE.addView(inflate2);
                }
            }
            bVar.qdF.setVisibility(0);
            AppMethodBeat.o(113535);
        }
    }

    /* access modifiers changed from: package-private */
    public class b {
        TextView qdA;
        TextView qdB;
        View qdC;
        TextView qdD;
        LinearLayout qdE;
        LinearLayout qdF;
        ImageView qdu;
        View qdv;
        ImageView qdw;
        TextView qdx;
        TextView qdy;
        TextView qdz;

        private b() {
        }

        /* synthetic */ b(CardNewMsgUI cardNewMsgUI, byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.card.b.k.a
    public final void a(g gVar) {
        AppMethodBeat.i(113543);
        if ((gVar.field_msg_type & 1) == 0 || (gVar.field_msg_type & 3) == 0) {
            AppMethodBeat.o(113543);
            return;
        }
        cuE();
        this.qdk.onNotifyChange(null, null);
        AppMethodBeat.o(113543);
    }

    @Override // com.tencent.mm.plugin.card.b.k.a
    public final void onChange() {
    }

    static /* synthetic */ void a(CardNewMsgUI cardNewMsgUI, int i2) {
        int i3;
        AppMethodBeat.i(113544);
        g gVar = (g) cardNewMsgUI.qdk.getItem(i2);
        if (gVar != null) {
            if (gVar.field_jump_type == 3) {
                if (!TextUtils.isEmpty(gVar.field_card_id)) {
                    cardNewMsgUI.aM(gVar.field_card_id, false);
                } else if (!TextUtils.isEmpty(gVar.field_card_tp_id)) {
                    cardNewMsgUI.aM(gVar.field_card_tp_id, false);
                } else {
                    Log.e("MicroMsg.CardNewMsgUI", "field_card_id and field_card_tp_id is null");
                }
            } else if (gVar.field_jump_type == 2) {
                if (!TextUtils.isEmpty(gVar.field_url)) {
                    com.tencent.mm.plugin.card.d.b.a(cardNewMsgUI, gVar.field_url, 4);
                } else {
                    Log.e("MicroMsg.CardNewMsgUI", "field_url is null");
                }
            } else if (gVar.field_jump_type == 1) {
                Log.i("MicroMsg.CardNewMsgUI", "field_jump_type is MM_CARD_ITEM_XML_MSG_JUMP_TYPE_NO");
            } else if (gVar.field_jump_type == 4) {
                if (!TextUtils.isEmpty(gVar.field_card_id)) {
                    cardNewMsgUI.aM(gVar.field_card_id, true);
                } else if (!TextUtils.isEmpty(gVar.field_card_tp_id)) {
                    cardNewMsgUI.aM(gVar.field_card_tp_id, true);
                } else {
                    Log.e("MicroMsg.CardNewMsgUI", "field_card_id and field_card_tp_id is null");
                }
            }
            if (cardNewMsgUI.getIntent().getBooleanExtra("from_menu", false)) {
                i3 = 7;
            } else {
                i3 = 1;
            }
            h.INSTANCE.a(11941, Integer.valueOf(i3), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, "");
        }
        AppMethodBeat.o(113544);
    }

    static /* synthetic */ void b(CardNewMsgUI cardNewMsgUI, final int i2) {
        AppMethodBeat.i(113545);
        com.tencent.mm.ui.base.h.a(cardNewMsgUI, cardNewMsgUI.getResources().getString(R.string.ark), (String[]) null, cardNewMsgUI.getResources().getString(R.string.tf), new h.d() {
            /* class com.tencent.mm.plugin.card.ui.CardNewMsgUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.h.d
            public final void oj(int i2) {
                AppMethodBeat.i(113525);
                switch (i2) {
                    case 0:
                        g gVar = (g) CardNewMsgUI.this.qdk.getItem(i2);
                        if (gVar != null) {
                            am.ctU().ajh(gVar.field_msg_id);
                            CardNewMsgUI.g(CardNewMsgUI.this);
                            CardNewMsgUI.this.qdk.onNotifyChange(null, null);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(113525);
            }
        });
        AppMethodBeat.o(113545);
    }

    static /* synthetic */ void h(CardNewMsgUI cardNewMsgUI) {
        AppMethodBeat.i(113547);
        d.a(cardNewMsgUI, new d.a() {
            /* class com.tencent.mm.plugin.card.ui.CardNewMsgUI.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.card.d.d.a, com.tencent.mm.plugin.card.d.d.b
            public final void cwc() {
                AppMethodBeat.i(113526);
                k ctU = am.ctU();
                if (ctU.pRP.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(ctU.pRP);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        g gVar = (g) arrayList.get(i2);
                        if (gVar != null) {
                            ctU.pRP.remove(gVar);
                            k.d(gVar);
                        }
                    }
                    arrayList.clear();
                }
                CardNewMsgUI.g(CardNewMsgUI.this);
                CardNewMsgUI.this.qdk.onNotifyChange(null, null);
                AppMethodBeat.o(113526);
            }
        });
        AppMethodBeat.o(113547);
    }
}
