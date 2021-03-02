package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.plugin.product.ui.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@a(3)
public class MallProductUI extends MallBaseUI implements u.a {
    protected c BaP;
    private HtmlTextView Baw;
    private ListView BbX;
    private a BbY;
    private TextView Bbs;
    private f Bby;
    private LinearLayout Bca;
    private LinearLayout Bcb;
    private ImageView Bcc;
    private TextView Bcd;
    private HtmlTextView Bce;
    private RelativeLayout Bcf;
    private ListView Bcg;
    private k Bch = null;
    private Button Bci;
    private TextView jVn;
    private Button krs;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.product.ui.MallBaseUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bjd;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.product.ui.MallBaseUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67073);
        super.onCreate(bundle);
        setContentViewVisibility(8);
        boolean booleanExtra = getIntent().getBooleanExtra("key_go_finish", false);
        setResult(-1);
        if (booleanExtra) {
            finish();
            AppMethodBeat.o(67073);
            return;
        }
        initView();
        com.tencent.mm.plugin.product.a.a.eDb();
        this.BaP = com.tencent.mm.plugin.product.a.a.eDc();
        this.Bby = new f(getContext(), new f.a() {
            /* class com.tencent.mm.plugin.product.ui.MallProductUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.product.ui.f.a
            public final void D(int i2, int i3, String str) {
                AppMethodBeat.i(67064);
                if (i2 == 0 && i3 == 0) {
                    MallProductUI.this.updateView();
                    if (MallProductUI.this.krs != null) {
                        MallProductUI.this.krs.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.product.ui.MallProductUI.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(67063);
                                ScrollView scrollView = (ScrollView) MallProductUI.this.findViewById(R.id.f_8);
                                if (scrollView != null) {
                                    scrollView.pageScroll(33);
                                }
                                AppMethodBeat.o(67063);
                            }
                        }, 200);
                        AppMethodBeat.o(67064);
                        return;
                    }
                } else if (i3 == -10010003) {
                    MallProductUI.this.setContentViewVisibility(0);
                    MallProductUI.this.Bca.setVisibility(8);
                    MallProductUI.this.Bcb.setVisibility(0);
                    MallProductUI.d(MallProductUI.this);
                    AppMethodBeat.o(67064);
                    return;
                } else {
                    MallProductUI.this.aKi(str);
                }
                AppMethodBeat.o(67064);
            }
        });
        f fVar = this.Bby;
        g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread(getIntent(), new m()) {
            /* class com.tencent.mm.plugin.product.ui.f.AnonymousClass1 */
            final /* synthetic */ m BaS;
            private volatile int result;
            final /* synthetic */ Intent val$intent;

            {
                this.val$intent = r2;
                this.BaS = r3;
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean doInBackground() {
                AppMethodBeat.i(66960);
                this.result = f.a(f.this, this.val$intent, this.BaS);
                AppMethodBeat.o(66960);
                return true;
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean onPostExecute() {
                AppMethodBeat.i(66961);
                switch (this.result) {
                    case -1:
                        if (f.this.BaQ != null) {
                            f.this.BaQ.D(0, -1, f.this.mContext.getString(R.string.ewn));
                            break;
                        }
                        break;
                    case 0:
                        if (f.this.BaQ != null) {
                            f.this.BaQ.D(0, 0, "");
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(66961);
                return true;
            }

            public final String toString() {
                AppMethodBeat.i(66962);
                String str = super.toString() + "|initData";
                AppMethodBeat.o(66962);
                return str;
            }
        });
        fVar.BaN = true;
        qj qjVar = new qj();
        qjVar.dWL.errCode = -1;
        qjVar.callback = new Runnable(qjVar) {
            /* class com.tencent.mm.plugin.product.ui.f.AnonymousClass2 */
            final /* synthetic */ qj BaU;

            {
                this.BaU = r2;
            }

            public final void run() {
                AppMethodBeat.i(66963);
                Log.d("MicroMsg.MallProductUI", "JSOAUTH errCode[%s], isAccept[%s]", Integer.valueOf(this.BaU.dWL.errCode), Boolean.valueOf(this.BaU.dWL.dWM));
                if (this.BaU.dWL.errCode == 0) {
                    c cVar = f.this.BaP;
                    qj qjVar = this.BaU;
                    dr drVar = new dr();
                    drVar.UserName = qjVar.dWL.userName;
                    drVar.KHE = qjVar.dWL.dWO;
                    drVar.KHF = qjVar.dWL.dWP;
                    drVar.kdZ = qjVar.dWL.dWQ;
                    drVar.kea = qjVar.dWL.dWR;
                    drVar.keh = qjVar.dWL.dWS;
                    drVar.xKd = qjVar.dWL.dWT;
                    if (!Util.isNullOrNil(drVar.UserName) && !Util.isNullOrNil(drVar.KHE)) {
                        cVar.AZd = drVar;
                    }
                }
                f.this.BaN = false;
                AppMethodBeat.o(66963);
            }
        };
        EventCenter.instance.asyncPublish(qjVar, Looper.getMainLooper());
        AppMethodBeat.o(67073);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(67074);
        super.onResume();
        this.Bby.onStart();
        AppMethodBeat.o(67074);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(67075);
        this.Bby.onStop();
        super.onPause();
        AppMethodBeat.o(67075);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67076);
        setMMTitle(R.string.exi);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(67065);
                f fVar = MallProductUI.this.Bby;
                if (!Util.isNullOrNil(fVar.BaP.AYZ)) {
                    g.aAi();
                    g.aAg().hqi.a(new com.tencent.mm.plugin.product.b.f(fVar.BaP.eDr(), fVar.BaP.AYZ), 0);
                }
                fVar.BaP.clear();
                MallProductUI.this.finish();
                AppMethodBeat.o(67065);
                return true;
            }
        });
        this.Bca = (LinearLayout) findViewById(R.id.f97);
        this.Bcb = (LinearLayout) findViewById(R.id.f9r);
        this.Bcc = (ImageView) findViewById(R.id.f95);
        this.jVn = (TextView) findViewById(R.id.f91);
        this.Bbs = (TextView) findViewById(R.id.f9_);
        this.Bcd = (TextView) findViewById(R.id.f98);
        this.Bcd.getPaint().setFlags(16);
        this.Bcf = (RelativeLayout) findViewById(R.id.f93);
        this.Baw = (HtmlTextView) findViewById(R.id.f92);
        this.Bce = (HtmlTextView) findViewById(R.id.f99);
        this.BbX = (ListView) findViewById(R.id.f90);
        this.BbY = new a(this);
        this.BbX.setAdapter((ListAdapter) this.BbY);
        this.BbX.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(67066);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                b bVar2 = (b) view.getTag();
                switch (bVar2.type) {
                    case 2:
                        m mVar = MallProductUI.this.BaP.AYX;
                        if (mVar.AZB.AZO != null && mVar.AZB.AZO.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<String> it = mVar.AZB.AZO.iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next());
                            }
                            bVar2.Bax = arrayList;
                            break;
                        }
                }
                MallProductUI.this.BbY.a(MallProductUI.this, view, i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(67066);
            }
        });
        this.Bci = (Button) findViewById(R.id.f9j);
        this.Bci.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(67067);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f fVar = MallProductUI.this.Bby;
                com.tencent.mm.wallet_core.ui.f.an(fVar.mContext, fVar.BaP.eDk());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67067);
            }
        });
        this.Bcg = (ListView) findViewById(R.id.f9s);
        this.Bch = new k(this);
        this.Bch.BbB = new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductUI.AnonymousClass5 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(67068);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                m mVar = (m) view.getTag();
                f fVar = MallProductUI.this.Bby;
                if (!(mVar == null || mVar.BbM == null)) {
                    n.a aVar = mVar.BbM;
                    Log.i("MicroMsg.MallProductUI", "goProductUI type : " + aVar.type);
                    switch (aVar.type) {
                        case 0:
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", aVar.url);
                            com.tencent.mm.wallet_core.ui.f.aA(fVar.mContext, intent);
                            break;
                        case 1:
                            String replace = aVar.data.replace("product_id=", "");
                            Intent intent2 = new Intent();
                            intent2.putExtra("key_product_id", replace);
                            intent2.putExtra("key_product_scene", 6);
                            com.tencent.mm.br.c.b(fVar.mContext, "mall", ".product.ui.MallProductUI", intent2);
                            fVar.mContext.finish();
                            break;
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(67068);
            }
        };
        this.Bcg.setAdapter((ListAdapter) this.Bch);
        this.krs = (Button) findViewById(R.id.f94);
        this.krs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(67069);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f fVar = MallProductUI.this.Bby;
                if (fVar.BaP.eDo()) {
                    Activity activity = fVar.mContext;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(fVar.mContext, MallProductSelectSkuUI.class));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "goSelectSku", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/product/ui/MallProductHelper", "goSelectSku", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    h.INSTANCE.a(11008, fVar.BaP.eDk(), fVar.BaP.AYX.AZx, Integer.valueOf(f.mScene), 1);
                } else {
                    com.tencent.mm.ui.base.u.makeText(fVar.mContext, (int) R.string.ewo, 1).show();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67069);
            }
        });
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean z = false;
                AppMethodBeat.i(67071);
                String[] stringArray = MallProductUI.this.getResources().getStringArray(R.array.a2);
                ArrayList arrayList = new ArrayList();
                for (String str : stringArray) {
                    arrayList.add(str);
                }
                if ((MallProductUI.this.BaP.eDe().BaL & 1) > 0) {
                    z = true;
                }
                Log.d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = ".concat(String.valueOf(z)));
                if (z) {
                    arrayList.add(MallProductUI.this.getString(R.string.ex1));
                }
                com.tencent.mm.ui.base.h.b(MallProductUI.this.getContext(), null, (String[]) arrayList.toArray(new String[arrayList.size()]), null, new h.d() {
                    /* class com.tencent.mm.plugin.product.ui.MallProductUI.AnonymousClass7.AnonymousClass1 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        AppMethodBeat.i(67070);
                        switch (i2) {
                            case 0:
                                f fVar = MallProductUI.this.Bby;
                                String eDu = fVar.BaP.eDu();
                                Intent intent = new Intent();
                                intent.putExtra("Retr_Msg_content", eDu);
                                intent.putExtra("Retr_Msg_Type", 2);
                                if (!Util.isNullOrNil(fVar.BaP.AYX.eDx())) {
                                    intent.putExtra("Retr_Msg_thumb_path", fVar.BaP.eDl());
                                }
                                intent.putExtra("Retr_go_to_chattingUI", false);
                                intent.putExtra("Retr_show_success_tips", true);
                                intent.putExtra("Retr_Msg_Type", 2);
                                com.tencent.mm.br.c.f(fVar.mContext, ".ui.transmit.MsgRetransmitUI", intent);
                                if (f.mScene == 4) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(10651, 11, 1, 0);
                                }
                                AppMethodBeat.o(67070);
                                return;
                            case 1:
                                f fVar2 = MallProductUI.this.Bby;
                                m mVar = fVar2.BaP.AYX;
                                Intent intent2 = new Intent();
                                intent2.putExtra("KContentObjDesc", fVar2.BaP.eDv());
                                intent2.putExtra("Ksnsupload_title", mVar.AZB.name);
                                intent2.putExtra("Ksnsupload_link", fVar2.BaP.eDm());
                                intent2.putExtra("Ksnsupload_imgurl", fVar2.BaP.AYX.eDx());
                                if (!Util.isNullOrNil(fVar2.BaP.AYX.eDx())) {
                                    intent2.putExtra("KsnsUpload_imgPath", fVar2.BaP.eDl());
                                }
                                intent2.putExtra("Ksnsupload_type", 6);
                                intent2.putExtra("KUploadProduct_UserData", fVar2.BaP.a(mVar));
                                intent2.putExtra("KUploadProduct_subType", mVar.AZy);
                                String JX = ad.JX("scan_product");
                                ad.aVe().G(JX, true).l("prePublishId", "scan_product");
                                intent2.putExtra("reportSessionId", JX);
                                com.tencent.mm.br.c.b(fVar2.mContext, "sns", ".ui.SnsUploadUI", intent2);
                                if (f.mScene == 4) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(10651, 11, 0, 0);
                                }
                                AppMethodBeat.o(67070);
                                return;
                            case 2:
                                MallProductUI.this.Bby.eDB();
                                AppMethodBeat.o(67070);
                                return;
                            case 3:
                                f fVar3 = MallProductUI.this.Bby;
                                com.tencent.mm.wallet_core.ui.f.am(fVar3.mContext, fVar3.BaP.eDk());
                                break;
                        }
                        AppMethodBeat.o(67070);
                    }
                });
                AppMethodBeat.o(67071);
                return true;
            }
        });
        showOptionMenu(false);
        this.Bcc.setFocusable(true);
        this.Bcc.setFocusableInTouchMode(true);
        this.Bcc.requestFocus();
        AppMethodBeat.o(67076);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(67077);
        super.onNewIntent(intent);
        Log.v("MicroMsg.MallProductUI", "onNewIntent");
        setIntent(intent);
        AppMethodBeat.o(67077);
    }

    /* access modifiers changed from: protected */
    public final void updateView() {
        AppMethodBeat.i(67078);
        m mVar = this.BaP.AYX;
        if (mVar == null) {
            showOptionMenu(false);
            AppMethodBeat.o(67078);
            return;
        }
        showOptionMenu(true);
        setContentViewVisibility(0);
        this.Bca.setVisibility(0);
        this.Bcb.setVisibility(8);
        if (mVar.AZB != null) {
            this.jVn.setText(mVar.AZB.name);
            this.Bbs.setText(com.tencent.mm.plugin.product.b.b.C(mVar.AZB.AZM, mVar.AZB.AZN, mVar.AZB.AOl));
            this.Bcd.setText(com.tencent.mm.plugin.product.b.b.c((double) mVar.AZB.AZL, mVar.AZB.AOl));
        }
        if (this.BaP.eDn() <= 0) {
            this.krs.setEnabled(false);
            this.krs.setText(R.string.ex3);
        } else if (this.BaP.AYX.AZA <= 0) {
            this.krs.setEnabled(false);
            this.krs.setText(R.string.ex2);
        } else {
            this.krs.setEnabled(true);
            if (!Util.isNullOrNil(mVar.AZF)) {
                this.krs.setText(mVar.AZF);
            } else {
                this.krs.setText(R.string.ewq);
            }
        }
        if (mVar.AZB == null || mVar.AZB.AZV == null || mVar.AZB.AZV.size() <= 0) {
            this.BbX.setVisibility(8);
        } else {
            this.BbX.setVisibility(0);
            this.BbY.fO(mVar.AZB.AZV);
            this.BbY.notifyDataSetChanged();
        }
        if (mVar.AZB == null || Util.isNullOrNil(mVar.AZB.detail)) {
            this.Bcf.setVisibility(8);
            this.Baw.setVisibility(8);
        } else {
            this.Bcf.setVisibility(0);
            this.Baw.setVisibility(0);
            this.Baw.setText(mVar.AZB.detail);
        }
        if (!Util.isNullOrNil(mVar.AZG)) {
            this.Bce.setVisibility(0);
            this.Bce.setText(mVar.AZG);
        } else {
            this.Bce.setVisibility(8);
        }
        showOptionMenu(true);
        if (!Util.isNullOrNil(this.BaP.AZf)) {
            this.Bcc.setImageBitmap(u.a(new c(this.BaP.AZf)));
            u.a(this);
        }
        AppMethodBeat.o(67078);
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(String str, final Bitmap bitmap) {
        AppMethodBeat.i(67079);
        if (str != null && str.equals(this.BaP.AZf)) {
            this.Bcc.post(new Runnable() {
                /* class com.tencent.mm.plugin.product.ui.MallProductUI.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(67072);
                    MallProductUI.this.Bcc.setImageBitmap(bitmap);
                    AppMethodBeat.o(67072);
                }
            });
        }
        AppMethodBeat.o(67079);
    }

    static /* synthetic */ void d(MallProductUI mallProductUI) {
        AppMethodBeat.i(67080);
        List<n> list = mallProductUI.BaP.AYY;
        if (list != null && list.size() > 0) {
            mallProductUI.Bch.BbI = list;
        }
        AppMethodBeat.o(67080);
    }
}
