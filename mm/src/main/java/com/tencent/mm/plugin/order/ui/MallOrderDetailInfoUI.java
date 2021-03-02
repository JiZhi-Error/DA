package com.tencent.mm.plugin.order.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.h;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderDetailInfoUI extends WalletBaseUI implements u.a {
    private HashMap<String, View> AKR = new HashMap<>();
    private List<MallOrderDetailObject.a> ANL = new ArrayList();
    protected MallOrderDetailObject AOR = null;
    private a APA;
    private View APB;
    private View APC;
    private View APD;
    private View APF;
    private View APG;
    private View APH;
    private View APJ;
    private boolean APK = false;
    private boolean APL = false;
    private int APM = 0;
    private CheckedTextView APN;
    private CheckedTextView APO;
    View.OnClickListener APQ = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI.AnonymousClass7 */

        public final void onClick(View view) {
            AppMethodBeat.i(66710);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(MallOrderDetailInfoUI.this.APN == null || MallOrderDetailInfoUI.this.APO == null)) {
                if (view.getId() == R.id.g5h) {
                    MallOrderDetailInfoUI.this.APN.setSelected(true);
                    MallOrderDetailInfoUI.this.APO.setSelected(false);
                    MallOrderDetailInfoUI.this.APM = 100;
                } else {
                    MallOrderDetailInfoUI.this.APN.setSelected(false);
                    MallOrderDetailInfoUI.this.APO.setSelected(true);
                    MallOrderDetailInfoUI.this.APM = -100;
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66710);
        }
    };
    String APz;
    private View.OnClickListener kuO = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI.AnonymousClass1 */

        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.i(66706);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getId() == R.id.g5p) {
                if (MallOrderDetailInfoUI.this.AOR.ANJ != null) {
                    c.bl(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.AOR.ANJ.xIy);
                    MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.AOR.ANJ.ANR);
                }
            } else if (view.getId() == R.id.g63 || view.getId() == R.id.g62) {
                if (MallOrderDetailInfoUI.this.AOR.ANK != null && MallOrderDetailInfoUI.this.AOR.ANK.size() > 0) {
                    if (!TextUtils.isEmpty(MallOrderDetailInfoUI.this.AOR.ANK.get(0).jumpUrl)) {
                        z = c.bl(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.AOR.ANK.get(0).jumpUrl);
                    } else {
                        z = false;
                    }
                    if (!z) {
                        c.bm(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.AOR.ANK.get(0).APx);
                    }
                    MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.AOR.ANK.get(0).name);
                }
            } else if (view.getId() == R.id.g61) {
                Bundle input = MallOrderDetailInfoUI.this.getInput();
                input.putParcelableArrayList("order_product_list", MallOrderDetailInfoUI.this.AOR.ANK);
                input.putInt("key_enter_id", 0);
                input.putString("key_trans_id", MallOrderDetailInfoUI.this.qvD);
                input.putString("appname", MallOrderDetailInfoUI.this.AOR.appUserName);
                com.tencent.mm.wallet_core.a.l(MallOrderDetailInfoUI.this, new Bundle());
                MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(R.string.ewg));
            } else if (view.getId() == R.id.g6_) {
                String string = MallOrderDetailInfoUI.this.getInput().getString("key_trans_id");
                Bundle input2 = MallOrderDetailInfoUI.this.getInput();
                input2.putString("key_trans_id", string);
                input2.putInt("key_enter_id", 1);
                if (MallOrderDetailInfoUI.this.AOR != null) {
                    input2.putParcelable("transaction_data", MallOrderDetailInfoUI.this.AOR.ANI);
                }
                com.tencent.mm.wallet_core.a.l(MallOrderDetailInfoUI.this, input2);
                MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(R.string.ewd));
            } else if (view.getId() == R.id.g5l) {
                MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this);
            } else if (view.getId() == R.id.dq2) {
                if (!(MallOrderDetailInfoUI.this.AOR == null || MallOrderDetailInfoUI.this.AOR.ANP == null)) {
                    MallOrderDetailInfoUI.this.APz = MallOrderDetailInfoUI.this.AOR.ANP;
                    MallOrderDetailInfoUI.c(MallOrderDetailInfoUI.this);
                    MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(R.string.ewb));
                }
            } else if (view.getId() == R.id.jrb) {
                f.an(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.AOR.appUserName);
                MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(R.string.ewm));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66706);
        }
    };
    private ListView mListView;
    private String qvD = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MallOrderDetailInfoUI() {
        AppMethodBeat.i(66717);
        AppMethodBeat.o(66717);
    }

    static /* synthetic */ void b(View view, MallOrderDetailObject.a aVar) {
        AppMethodBeat.i(66742);
        a(view, aVar);
        AppMethodBeat.o(66742);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b5w;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        MallOrderDetailObject mallOrderDetailObject = null;
        AppMethodBeat.i(66718);
        super.onCreate(bundle);
        d by = com.tencent.mm.wallet_core.a.by(this);
        if (by != null && (by instanceof com.tencent.mm.plugin.order.a.a)) {
            String string = getInput().getString("key_trans_id");
            this.qvD = string;
            if (string != null) {
                com.tencent.mm.plugin.order.a.b.eBa();
                if (!com.tencent.mm.plugin.order.a.b.eBd().aJC(string)) {
                    this.APK = false;
                    doSceneProgress(new h(string));
                }
            }
            com.tencent.mm.plugin.order.a.b.eBa();
            if (com.tencent.mm.plugin.order.a.b.eBd().aJC(string)) {
                this.APK = true;
                com.tencent.mm.plugin.order.a.b.eBa();
                com.tencent.mm.plugin.order.model.c eBd = com.tencent.mm.plugin.order.a.b.eBd();
                if (!TextUtils.isEmpty(string)) {
                    Log.v("MicroMsg.MallPayMsgManager", "getMallOrderDetailObjectByMsgId msgId:".concat(String.valueOf(string)));
                    j aJD = eBd.aJD(string);
                    if (aJD != null) {
                        MallOrderDetailObject mallOrderDetailObject2 = new MallOrderDetailObject();
                        MallOrderDetailObject.b bVar = new MallOrderDetailObject.b();
                        bVar.ANR = aJD.APq;
                        if (TextUtils.isEmpty(aJD.APo) || !c.isNumeric(aJD.APo)) {
                            bVar.hXs = (int) (System.currentTimeMillis() / 1000);
                        } else {
                            bVar.hXs = Util.getInt(aJD.APo, 0);
                        }
                        bVar.thumbUrl = aJD.APp;
                        bVar.xIy = aJD.APr;
                        bVar.ANS = aJD.dWG;
                        mallOrderDetailObject2.ANJ = bVar;
                        List<j.a> list = aJD.APu;
                        if (list != null && list.size() > 0) {
                            mallOrderDetailObject2.ANL = new ArrayList();
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                j.a aVar = list.get(i2);
                                MallOrderDetailObject.a aVar2 = new MallOrderDetailObject.a();
                                aVar2.name = aVar.name;
                                aVar2.value = "";
                                aVar2.jumpUrl = aVar.jumpUrl;
                                aVar2.pSj = false;
                                mallOrderDetailObject2.ANL.add(aVar2);
                            }
                        }
                        List<j.b> list2 = aJD.APv;
                        if (list2 != null && list2.size() > 0) {
                            if (mallOrderDetailObject2.ANL == null) {
                                mallOrderDetailObject2.ANL = new ArrayList();
                            }
                            for (int i3 = 0; i3 < list2.size(); i3++) {
                                j.b bVar2 = list2.get(i3);
                                MallOrderDetailObject.a aVar3 = new MallOrderDetailObject.a();
                                aVar3.name = bVar2.name;
                                aVar3.value = bVar2.value;
                                aVar3.jumpUrl = bVar2.jumpUrl;
                                aVar3.pSj = false;
                                if (i3 == 0) {
                                    aVar3.pSj = true;
                                }
                                mallOrderDetailObject2.ANL.add(aVar3);
                            }
                        }
                        mallOrderDetailObject2.ANP = aJD.APt;
                        mallOrderDetailObject2.appUserName = aJD.APs;
                        if (TextUtils.isEmpty(aJD.APo) || !c.isNumeric(aJD.APo)) {
                            mallOrderDetailObject2.ANQ = (int) (System.currentTimeMillis() / 1000);
                        } else {
                            mallOrderDetailObject2.ANQ = Util.getInt(aJD.APo, 0);
                        }
                        mallOrderDetailObject = mallOrderDetailObject2;
                    }
                }
                this.AOR = mallOrderDetailObject;
                if (this.AOR == null) {
                    eBl();
                }
            } else {
                Log.w("MicroMsg.MallOrderDetailInfoUI", "mOrders info is Illegal!");
                eBl();
            }
        }
        initView();
        AppMethodBeat.o(66718);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        int i2;
        AppMethodBeat.i(66719);
        if (this.APK) {
            com.tencent.mm.plugin.order.a.b.eBa();
            j aJD = com.tencent.mm.plugin.order.a.b.eBd().aJD(this.qvD);
            if (aJD == null || TextUtils.isEmpty(aJD.APm) || !c.isNumeric(aJD.APm)) {
                i2 = -1;
            } else {
                i2 = Util.getInt(aJD.APm, 0);
            }
            if (i2 == 2) {
                setMMTitle(R.string.ew9);
            } else if (i2 == 1) {
                setMMTitle(R.string.ew_);
            }
        } else {
            setMMTitle(R.string.ewa);
        }
        this.APB = findViewById(R.id.g5p);
        this.APC = findViewById(R.id.g5o);
        this.APH = findViewById(R.id.g63);
        this.APJ = findViewById(R.id.g61);
        this.APG = findViewById(R.id.g62);
        this.APD = findViewById(R.id.g6_);
        this.APF = findViewById(R.id.g69);
        this.APB.setOnClickListener(this.kuO);
        this.APJ.setOnClickListener(this.kuO);
        this.APH.setOnClickListener(this.kuO);
        this.APG.setOnClickListener(this.kuO);
        this.APD.setOnClickListener(this.kuO);
        findViewById(R.id.g5l).setOnClickListener(this.kuO);
        findViewById(R.id.dq2).setOnClickListener(this.kuO);
        findViewById(R.id.jrb).setOnClickListener(this.kuO);
        this.mListView = (ListView) findViewById(R.id.g5k);
        this.APA = new a(this, (byte) 0);
        this.mListView.setAdapter((ListAdapter) this.APA);
        this.APA.notifyDataSetChanged();
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI.AnonymousClass6 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(66709);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                MallOrderDetailObject.a aVar = (MallOrderDetailObject.a) MallOrderDetailInfoUI.this.ANL.get(i2);
                if (!TextUtils.isEmpty(aVar.jumpUrl)) {
                    c.bl(MallOrderDetailInfoUI.this, aVar.jumpUrl);
                }
                MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, aVar.name);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(66709);
            }
        });
        bpn();
        AppMethodBeat.o(66719);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(66720);
        if (i2 == 4) {
            if (com.tencent.mm.wallet_core.a.by(this) instanceof com.tencent.mm.plugin.order.a.a) {
                com.tencent.mm.wallet_core.a.bv(this);
            }
            AppMethodBeat.o(66720);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(66720);
        return onKeyUp;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(66721);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof h) {
                MallOrderDetailObject mallOrderDetailObject = ((h) qVar).AOR;
                Log.d("MicroMsg.MallOrderDetailInfoUI", "tempObject:".concat(String.valueOf(mallOrderDetailObject)));
                if (mallOrderDetailObject != null) {
                    this.AOR = mallOrderDetailObject;
                    bpn();
                }
            }
            AppMethodBeat.o(66721);
            return true;
        }
        AppMethodBeat.o(66721);
        return false;
    }

    private void bpn() {
        AppMethodBeat.i(66722);
        if (this.AOR == null) {
            AppMethodBeat.o(66722);
            return;
        }
        u.a(this);
        this.AKR.clear();
        a(this.AOR.ANJ);
        fL(this.AOR.ANK);
        a(this.AOR.ANI);
        fK(this.AOR.ANL);
        findViewById(R.id.f7m).setVisibility(0);
        if (this.AOR != null && TextUtils.isEmpty(this.AOR.ANP) && TextUtils.isEmpty(this.AOR.appUserName)) {
            findViewById(R.id.f7m).setVisibility(8);
        } else if (this.AOR != null && !TextUtils.isEmpty(this.AOR.ANP) && TextUtils.isEmpty(this.AOR.appUserName)) {
            findViewById(R.id.jrb).setVisibility(8);
            findViewById(R.id.jra).setVisibility(8);
            TextView textView = (TextView) findViewById(R.id.dq2);
            textView.setVisibility(0);
            textView.setGravity(3);
        } else if (this.AOR != null && TextUtils.isEmpty(this.AOR.ANP) && !TextUtils.isEmpty(this.AOR.appUserName)) {
            findViewById(R.id.dq2).setVisibility(8);
            findViewById(R.id.jra).setVisibility(8);
            TextView textView2 = (TextView) findViewById(R.id.jrb);
            textView2.setVisibility(0);
            textView2.setGravity(3);
        }
        if (this.AOR != null && !TextUtils.isEmpty(this.AOR.ANO)) {
            cvL();
        }
        AppMethodBeat.o(66722);
    }

    private void a(MallOrderDetailObject.b bVar) {
        String str;
        AppMethodBeat.i(66723);
        if (bVar != null) {
            String str2 = bVar.ANR;
            if (!TextUtils.isEmpty(bVar.ANS)) {
                str = str2 + "：" + bVar.ANS;
            } else {
                str = str2;
            }
            if (!this.APK) {
                this.APC.setVisibility(8);
                this.APB.setVisibility(0);
                ((TextView) this.APB.findViewById(R.id.g5r)).setText(str);
                ((TextView) this.APB.findViewById(R.id.g5q)).setText(f.rZ(this.AOR.ANQ));
                if (TextUtils.isEmpty(bVar.thumbUrl) || !f.bpr(bVar.thumbUrl)) {
                    j((ImageView) this.APB.findViewById(R.id.g60));
                    AppMethodBeat.o(66723);
                    return;
                }
                v((ImageView) this.APB.findViewById(R.id.g60), bVar.thumbUrl);
                AppMethodBeat.o(66723);
                return;
            }
            this.APB.setVisibility(8);
            this.APC.setVisibility(0);
            ((TextView) this.APC.findViewById(R.id.g5r)).setText(str);
            ((TextView) this.APC.findViewById(R.id.g5q)).setText(f.rZ(this.AOR.ANQ));
            if (TextUtils.isEmpty(bVar.thumbUrl) || !f.bpr(bVar.thumbUrl)) {
                j((ImageView) this.APC.findViewById(R.id.g60));
                AppMethodBeat.o(66723);
                return;
            }
            v((ImageView) this.APC.findViewById(R.id.g60), bVar.thumbUrl);
            AppMethodBeat.o(66723);
            return;
        }
        this.APB.setVisibility(8);
        this.APC.setVisibility(8);
        AppMethodBeat.o(66723);
    }

    private void a(MallTransactionObject mallTransactionObject) {
        AppMethodBeat.i(66724);
        if (mallTransactionObject != null) {
            this.APD.setVisibility(0);
            ((TextView) findViewById(R.id.g6a)).setText(f.d(mallTransactionObject.qwJ, mallTransactionObject.AOl));
            if (!(this.AOR == null || this.AOR.ANL == null || this.AOR.ANL.size() <= 0)) {
                a(this.APF, this.AOR.ANL.get(0));
                AppMethodBeat.o(66724);
                return;
            }
        } else {
            this.APD.setVisibility(8);
        }
        AppMethodBeat.o(66724);
    }

    private void fK(List<MallOrderDetailObject.a> list) {
        AppMethodBeat.i(66725);
        if (list != null) {
            this.ANL.addAll(list);
            this.APA.notifyDataSetChanged();
        }
        AppMethodBeat.o(66725);
    }

    private void fL(List<ProductSectionItem> list) {
        AppMethodBeat.i(66726);
        if (list == null || list.size() == 0) {
            this.APG.setVisibility(8);
            this.APH.setVisibility(8);
            this.APJ.setVisibility(8);
            AppMethodBeat.o(66726);
        } else if (list.size() == 1) {
            this.APJ.setVisibility(8);
            ProductSectionItem productSectionItem = list.get(0);
            if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
                this.APG.setVisibility(8);
                this.APH.setVisibility(0);
                ((TextView) this.APH.findViewById(R.id.e3h)).setText(productSectionItem.name);
                ((TextView) this.APH.findViewById(R.id.e3j)).setText(productSectionItem.price);
                ((TextView) this.APH.findViewById(R.id.e3f)).setText("+" + productSectionItem.count);
                ((TextView) this.APH.findViewById(R.id.e3e)).setText(ProductSectionItem.Skus.fJ(productSectionItem.APw));
                if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
                    v((ImageView) this.APH.findViewById(R.id.e3i), productSectionItem.iconUrl);
                    AppMethodBeat.o(66726);
                    return;
                }
            } else {
                this.APH.setVisibility(8);
                this.APG.setVisibility(0);
                ((TextView) this.APG.findViewById(R.id.e3h)).setText(productSectionItem.name);
                if (TextUtils.isEmpty(productSectionItem.jumpUrl)) {
                    Rect rect = new Rect();
                    rect.set(this.APG.findViewById(R.id.e3g).getPaddingLeft(), this.APG.findViewById(R.id.e3g).getPaddingTop(), this.APG.findViewById(R.id.e3g).getPaddingRight(), this.APG.findViewById(R.id.e3g).getPaddingBottom());
                    this.APG.findViewById(R.id.e3g).setBackgroundResource(R.drawable.b9w);
                    this.APG.findViewById(R.id.e3g).setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    AppMethodBeat.o(66726);
                    return;
                }
                ((TextView) this.APG.findViewById(R.id.e3h)).setTextColor(getResources().getColor(R.color.zj));
            }
            AppMethodBeat.o(66726);
        } else {
            this.APG.setVisibility(8);
            this.APH.setVisibility(8);
            this.APJ.setVisibility(0);
            if (list.size() == 2) {
                a(this.APJ.findViewById(R.id.g64), list.get(0));
                a(this.APJ.findViewById(R.id.g65), list.get(1));
                this.APJ.findViewById(R.id.g66).setVisibility(8);
                this.APJ.findViewById(R.id.g67).setVisibility(8);
                AppMethodBeat.o(66726);
            } else if (list.size() == 3) {
                a(this.APJ.findViewById(R.id.g64), list.get(0));
                a(this.APJ.findViewById(R.id.g65), list.get(1));
                a(this.APJ.findViewById(R.id.g66), list.get(2));
                this.APJ.findViewById(R.id.g67).setVisibility(8);
                AppMethodBeat.o(66726);
            } else {
                if (list.size() >= 4) {
                    a(this.APJ.findViewById(R.id.g64), list.get(0));
                    a(this.APJ.findViewById(R.id.g65), list.get(1));
                    a(this.APJ.findViewById(R.id.g66), list.get(2));
                    a(this.APJ.findViewById(R.id.g67), list.get(3));
                }
                AppMethodBeat.o(66726);
            }
        }
    }

    private void a(View view, ProductSectionItem productSectionItem) {
        AppMethodBeat.i(66727);
        if (view == null || productSectionItem == null) {
            AppMethodBeat.o(66727);
            return;
        }
        view.setVisibility(0);
        TextView textView = (TextView) view.findViewById(R.id.e3h);
        if (textView != null) {
            textView.setText(productSectionItem.name);
        }
        if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
            v((ImageView) view.findViewById(R.id.e3i), productSectionItem.iconUrl);
        }
        AppMethodBeat.o(66727);
    }

    private void v(ImageView imageView, String str) {
        AppMethodBeat.i(66728);
        if (imageView == null || TextUtils.isEmpty(str) || !f.bpr(str)) {
            AppMethodBeat.o(66728);
            return;
        }
        imageView.setImageBitmap(u.a(new com.tencent.mm.plugin.order.c.b(str)));
        this.AKR.put(str, imageView);
        AppMethodBeat.o(66728);
    }

    private void cvL() {
        AppMethodBeat.i(66729);
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(66707);
                MallOrderDetailInfoUI.d(MallOrderDetailInfoUI.this);
                AppMethodBeat.o(66707);
                return true;
            }
        });
        AppMethodBeat.o(66729);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(MallOrderDetailInfoUI mallOrderDetailInfoUI, byte b2) {
            this();
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(66716);
            MallOrderDetailObject.a Ui = Ui(i2);
            AppMethodBeat.o(66716);
            return Ui;
        }

        public final int getCount() {
            AppMethodBeat.i(66712);
            int size = MallOrderDetailInfoUI.this.ANL.size();
            AppMethodBeat.o(66712);
            return size;
        }

        private MallOrderDetailObject.a Ui(int i2) {
            AppMethodBeat.i(66713);
            MallOrderDetailObject.a aVar = (MallOrderDetailObject.a) MallOrderDetailInfoUI.this.ANL.get(i2);
            AppMethodBeat.o(66713);
            return aVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(66714);
            MallOrderDetailObject.a Ui = Ui(i2);
            switch (Ui.type) {
                case 1:
                    view = View.inflate(MallOrderDetailInfoUI.this, R.layout.b5q, null);
                    View findViewById = view.findViewById(R.id.g5e);
                    MallOrderDetailInfoUI.this.APN = (CheckedTextView) view.findViewById(R.id.g5h);
                    MallOrderDetailInfoUI.this.APO = (CheckedTextView) view.findViewById(R.id.g5d);
                    MallOrderDetailInfoUI.this.APN.setOnClickListener(MallOrderDetailInfoUI.this.APQ);
                    MallOrderDetailInfoUI.this.APO.setOnClickListener(MallOrderDetailInfoUI.this.APQ);
                    if (i2 + 1 < getCount()) {
                        MallOrderDetailInfoUI.b(findViewById, Ui(i2 + 1));
                    }
                    AppMethodBeat.o(66714);
                    break;
                case 2:
                    view = View.inflate(MallOrderDetailInfoUI.this, R.layout.b5p, null);
                    TextView textView = (TextView) view.findViewById(R.id.g5d);
                    View findViewById2 = view.findViewById(R.id.g5e);
                    if (Util.getInt(Ui.value, 0) >= 0) {
                        textView.setText(R.string.ew7);
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.raw.mall_order_detail_good, 0);
                    } else {
                        textView.setText(R.string.ew6);
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.raw.mall_order_detail_bad, 0);
                    }
                    if (i2 + 1 < getCount()) {
                        MallOrderDetailInfoUI.b(findViewById2, Ui(i2 + 1));
                    }
                    AppMethodBeat.o(66714);
                    break;
                default:
                    if (view == null) {
                        view = View.inflate(MallOrderDetailInfoUI.this, R.layout.b5o, null);
                        b bVar2 = new b(MallOrderDetailInfoUI.this, (byte) 0);
                        bVar2.qdx = (TextView) view.findViewById(R.id.g5j);
                        bVar2.qez = (TextView) view.findViewById(R.id.g5i);
                        bVar2.qeA = (TextView) view.findViewById(R.id.g5g);
                        bVar2.sc = view.findViewById(R.id.g5e);
                        view.setTag(bVar2);
                        bVar = bVar2;
                    } else {
                        bVar = (b) view.getTag();
                    }
                    bVar.qdx.setText(Ui.name);
                    if (TextUtils.isEmpty(Ui.value)) {
                        bVar.qez.setVisibility(4);
                    } else {
                        bVar.qez.setVisibility(0);
                        bVar.qez.setText(Ui.value);
                    }
                    if (Ui.pSj) {
                        bVar.qeA.setVisibility(0);
                    } else {
                        bVar.qeA.setVisibility(8);
                    }
                    if (i2 + 1 < getCount()) {
                        MallOrderDetailInfoUI.b(bVar.sc, Ui(i2 + 1));
                    }
                    AppMethodBeat.o(66714);
                    break;
            }
            return view;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(66715);
            int i3 = Ui(i2).type;
            AppMethodBeat.o(66715);
            return i3;
        }

        public final int getViewTypeCount() {
            return 3;
        }
    }

    private static void a(View view, MallOrderDetailObject.a aVar) {
        AppMethodBeat.i(66730);
        if (aVar == null) {
            AppMethodBeat.o(66730);
            return;
        }
        Rect rect = new Rect();
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (aVar == null || !aVar.pSj) {
            view.setBackgroundResource(R.drawable.b9w);
        } else {
            view.setBackgroundResource(R.drawable.aij);
        }
        view.setLayoutParams(layoutParams);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.o(66730);
    }

    class b {
        TextView qdx;
        TextView qeA;
        TextView qez;
        View sc;

        private b() {
        }

        /* synthetic */ b(MallOrderDetailInfoUI mallOrderDetailInfoUI, byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(String str, Bitmap bitmap) {
        AppMethodBeat.i(66731);
        ImageView imageView = (ImageView) this.AKR.get(str);
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        AppMethodBeat.o(66731);
    }

    private void j(ImageView imageView) {
        AppMethodBeat.i(66732);
        Bitmap decodeResource = com.tencent.mm.compatible.f.a.decodeResource(getResources(), R.raw.mall_order_trade_state_icon);
        if (decodeResource != null) {
            imageView.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(decodeResource, false, 96.0f));
        }
        AppMethodBeat.o(66732);
    }

    private void eBk() {
        AppMethodBeat.i(66733);
        if (!this.APL && this.APM != 0) {
            g.aAi();
            g.aAg().hqi.a(new com.tencent.mm.plugin.order.model.f(this.qvD, "", this.APM), 0);
            this.APL = true;
        }
        AppMethodBeat.o(66733);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(66734);
        eBk();
        super.finish();
        AppMethodBeat.o(66734);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(66735);
        eBk();
        super.onDestroy();
        AppMethodBeat.o(66735);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void cleanUiData(int i2) {
        AppMethodBeat.i(66736);
        finish();
        AppMethodBeat.o(66736);
    }

    private void eBl() {
        AppMethodBeat.i(66737);
        com.tencent.mm.ui.base.h.a(getContext(), (int) R.string.ijv, 0, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI.AnonymousClass8 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(66711);
                MallOrderDetailInfoUI.this.finish();
                AppMethodBeat.o(66711);
            }
        });
        AppMethodBeat.o(66737);
    }

    static /* synthetic */ void a(MallOrderDetailInfoUI mallOrderDetailInfoUI, String str) {
        AppMethodBeat.i(66738);
        c.a(Boolean.valueOf(mallOrderDetailInfoUI.APK), mallOrderDetailInfoUI.AOR.appUserName, mallOrderDetailInfoUI.qvD, str, "");
        AppMethodBeat.o(66738);
    }

    static /* synthetic */ void b(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        AppMethodBeat.i(66739);
        com.tencent.mm.ui.base.h.c(mallOrderDetailInfoUI, "商家已退全款，总价125元，包含商品价格115元，邮费10元，请确认是否同意通过该处理结果。", mallOrderDetailInfoUI.getString(R.string.ew2), mallOrderDetailInfoUI.getString(R.string.ewh), mallOrderDetailInfoUI.getString(R.string.ewi), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(66739);
    }

    static /* synthetic */ void c(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        AppMethodBeat.i(66740);
        if (!TextUtils.isEmpty(mallOrderDetailInfoUI.APz)) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + mallOrderDetailInfoUI.APz));
            intent.addFlags(268435456);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(mallOrderDetailInfoUI, bl.axQ(), "com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI", "dialPhone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            mallOrderDetailInfoUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(mallOrderDetailInfoUI, "com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI", "dialPhone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(66740);
    }

    static /* synthetic */ void d(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        AppMethodBeat.i(66741);
        com.tencent.mm.ui.base.h.b(mallOrderDetailInfoUI, "", new String[]{mallOrderDetailInfoUI.getString(R.string.ewj)}, "", new h.d() {
            /* class com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.h.d
            public final void oj(int i2) {
                AppMethodBeat.i(66708);
                switch (i2) {
                    case 0:
                        c.bn(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.AOR.ANO);
                        break;
                }
                AppMethodBeat.o(66708);
            }
        });
        AppMethodBeat.o(66741);
    }
}
