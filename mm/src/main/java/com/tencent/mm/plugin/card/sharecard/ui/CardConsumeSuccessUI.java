package com.tencent.mm.plugin.card.sharecard.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.s;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.d;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dxg;
import com.tencent.mm.protocal.protobuf.dxy;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CardConsumeSuccessUI extends MMActivity implements i {
    private final String TAG = "MicroMsg.CardConsumeSuccessUI";
    private q gxX = null;
    private View.OnClickListener kuO = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(113052);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeSuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getId() == R.id.b8) {
                CardConsumeSuccessUI.a(CardConsumeSuccessUI.this);
            } else if (view.getId() == R.id.idy) {
                Intent intent = new Intent();
                intent.putExtra("KLabel_range_index", CardConsumeSuccessUI.this.pXh);
                intent.putExtra("Klabel_name_list", CardConsumeSuccessUI.this.pXi);
                intent.putExtra("Kother_user_name_list", CardConsumeSuccessUI.this.pXj);
                intent.putExtra("k_sns_label_ui_title", CardConsumeSuccessUI.this.getString(R.string.aso));
                intent.putExtra("k_sns_label_ui_style", 0);
                intent.putExtra("KLabel_is_filter_private", true);
                c.b(CardConsumeSuccessUI.this, "sns", ".ui.SnsLabelUI", intent, 1);
            }
            a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeSuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113052);
        }
    };
    private View mContentView;
    private long mStartTime = 0;
    MMHandler ndA = new MMHandler(Looper.getMainLooper());
    private String pQH = "";
    private String pRT = "";
    private TextView pWJ;
    private TextView pWK;
    private TextView pWV;
    private TextView pWW;
    private TextView pWX;
    private TextView pWY;
    private ImageView pWZ;
    private Button pXa;
    private CheckBox pXb;
    private j pXc;
    private String pXd = "";
    private String pXe = "";
    int pXf = 0;
    int pXg = 0;
    public int pXh = 0;
    private String pXi = "";
    private String pXj = "";
    public ArrayList<String> pXk = new ArrayList<>();
    public ArrayList<String> pXl = new ArrayList<>();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardConsumeSuccessUI() {
        AppMethodBeat.i(113055);
        AppMethodBeat.o(113055);
    }

    static /* synthetic */ void cuH() {
        AppMethodBeat.i(113071);
        En(0);
        AppMethodBeat.o(113071);
    }

    static /* synthetic */ void d(CardConsumeSuccessUI cardConsumeSuccessUI) {
        AppMethodBeat.i(113073);
        cardConsumeSuccessUI.updateView();
        AppMethodBeat.o(113073);
    }

    private void ku(boolean z) {
        AppMethodBeat.i(113056);
        if (z) {
            this.gxX = q.a(this, getString(R.string.ekc), true, 0, null);
            AppMethodBeat.o(113056);
            return;
        }
        if (this.gxX != null && this.gxX.isShowing()) {
            this.gxX.dismiss();
            this.gxX = null;
        }
        AppMethodBeat.o(113056);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.mh;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        String str;
        uz uzVar;
        AppMethodBeat.i(113057);
        super.onCreate(bundle);
        Log.i("MicroMsg.CardConsumeSuccessUI", "onCreate()");
        this.mStartTime = System.currentTimeMillis();
        setMMTitle("");
        setResult(0);
        g.aAg().hqi.a(902, this);
        g.aAg().hqi.a(com.tencent.mm.plugin.appbrand.jsapi.f.b.CTRL_INDEX, this);
        String str2 = "";
        this.pXf = getIntent().getIntExtra("key_from_scene", 0);
        if (this.pXf == 1) {
            Log.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
            this.pXd = getIntent().getStringExtra("key_consumed_card_id");
            this.pXe = getIntent().getStringExtra("key_consumed_Code");
            if (TextUtils.isEmpty(this.pXd)) {
                Log.e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
                En(0);
                finish();
                AppMethodBeat.o(113057);
                return;
            }
            Log.i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.pXe);
            ku(true);
            g.aAg().hqi.a(new d("", this.pXd, this.pXe), 0);
            cuF();
            this.pXg = 7;
        } else if (this.pXf == 2) {
            Log.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
            this.pQH = getIntent().getStringExtra("key_card_id");
            if (TextUtils.isEmpty(this.pQH)) {
                Log.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
                En(0);
                finish();
                AppMethodBeat.o(113057);
                return;
            }
            Log.i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.pQH);
            ku(true);
            g.aAg().hqi.a(new d(this.pQH, "", ""), 0);
            cuF();
            this.pXg = 4;
        } else {
            Log.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
            this.pQH = getIntent().getStringExtra("KEY_CARD_ID");
            if (!ajB(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON"))) {
                Log.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
                En(0);
                finish();
                AppMethodBeat.o(113057);
                return;
            }
            if (this.pXc == null || Util.isNullOrNil(this.pXc.dtS) || (uzVar = this.pXc.dtS.get(0).pTh) == null) {
                str = str2;
            } else {
                str = uzVar.ixw;
            }
            if (Util.isNullOrNil(str)) {
                str = getIntent().getStringExtra("KEY_CARD_COLOR");
            }
            this.pXg = getIntent().getIntExtra("key_stastic_scene", 0);
            str2 = str;
        }
        h.INSTANCE.a(11324, "CardConsumeSuccessUI", 0, "", "", 0, Integer.valueOf(this.pXg), "", 0, "");
        initView();
        if (!TextUtils.isEmpty(str2)) {
            ajC(str2);
        }
        AppMethodBeat.o(113057);
    }

    private boolean ajB(String str) {
        AppMethodBeat.i(113058);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
            AppMethodBeat.o(113058);
            return false;
        }
        this.pXc = s.akm(str);
        if (this.pXc == null) {
            Log.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is ".concat(String.valueOf(str)));
            AppMethodBeat.o(113058);
            return false;
        }
        AppMethodBeat.o(113058);
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(113059);
        super.onResume();
        AppMethodBeat.o(113059);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(113061);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(113051);
                CardConsumeSuccessUI.this.finish();
                CardConsumeSuccessUI.cuH();
                AppMethodBeat.o(113051);
                return true;
            }
        });
        this.mContentView = getContentView();
        this.pWJ = (TextView) findViewById(R.id.aku);
        this.pWK = (TextView) findViewById(R.id.ao6);
        this.pWV = (TextView) findViewById(R.id.alp);
        this.pWW = (TextView) findViewById(R.id.idz);
        this.pWX = (TextView) findViewById(R.id.idy);
        this.pWY = (TextView) findViewById(R.id.idx);
        this.pWZ = (ImageView) findViewById(R.id.an8);
        this.pXa = (Button) findViewById(R.id.b8);
        this.pXb = (CheckBox) findViewById(R.id.vl);
        this.pXa.setOnClickListener(this.kuO);
        this.pXb.setOnClickListener(this.kuO);
        this.pWX.setOnClickListener(this.kuO);
        if (this.pXc != null) {
            updateView();
        }
        AppMethodBeat.o(113061);
    }

    private void updateView() {
        AppMethodBeat.i(113062);
        if (this.pXc == null) {
            Log.e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
            AppMethodBeat.o(113062);
            return;
        }
        findViewById(R.id.h8x).setVisibility(0);
        if (TextUtils.isEmpty(this.pXc.pVX) || TextUtils.isEmpty(this.pXc.pVY)) {
            this.pXb.setVisibility(8);
            Log.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
        } else {
            this.pXb.setText(this.pXc.pVX);
            this.pXb.setVisibility(0);
        }
        if (this.pXc.dtS == null || this.pXc.dtS.size() <= 0) {
            this.pXa.setEnabled(false);
            Log.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
            AppMethodBeat.o(113062);
            return;
        }
        this.pWW.setText(getString(R.string.ao7, new Object[]{Integer.valueOf(this.pXc.dtS.size())}));
        uz uzVar = this.pXc.dtS.get(0).pTh;
        if (uzVar != null) {
            ajC(uzVar.ixw);
            this.pWJ.setText(uzVar.gTG);
            this.pWK.setText(uzVar.title);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.vi);
            if (!TextUtils.isEmpty(uzVar.iwv)) {
                c.a aVar = new c.a();
                aVar.prefixPath = com.tencent.mm.loader.j.b.aKJ();
                com.tencent.mm.av.q.bcW();
                aVar.jbw = null;
                aVar.fullPath = m.ajp(uzVar.iwv);
                aVar.jbf = true;
                aVar.iaT = true;
                aVar.jbd = true;
                aVar.hZA = dimensionPixelSize;
                aVar.hZz = dimensionPixelSize;
                aVar.jbq = R.drawable.ci4;
                com.tencent.mm.av.q.bcV().a(uzVar.iwv, this.pWZ, aVar.bdv());
            } else {
                Log.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
                this.pWZ.setImageResource(R.drawable.ci4);
            }
            if (TextUtils.isEmpty(uzVar.LeJ)) {
                this.pXa.setText(R.string.ao4);
                AppMethodBeat.o(113062);
                return;
            }
            Log.e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
            this.pXa.setText(uzVar.LeJ);
            AppMethodBeat.o(113062);
            return;
        }
        Log.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
        AppMethodBeat.o(113062);
    }

    private void cuF() {
        AppMethodBeat.i(113063);
        getContentView().setBackgroundColor(getResources().getColor(R.color.hl));
        findViewById(R.id.h8x).setVisibility(4);
        AppMethodBeat.o(113063);
    }

    @TargetApi(16)
    private void ajC(String str) {
        AppMethodBeat.i(113064);
        int ake = l.ake(str);
        this.mContentView.setBackgroundColor(ake);
        setActionbarColor(ake);
        if (com.tencent.mm.compatible.util.d.oD(16)) {
            this.pXa.setBackground(l.fi(ake, getResources().getDimensionPixelSize(R.dimen.uu) / 2));
        } else {
            this.pXa.setBackgroundDrawable(l.fi(ake, getResources().getDimensionPixelSize(R.dimen.uu) / 2));
        }
        this.mContentView.invalidate();
        AppMethodBeat.o(113064);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(113065);
        Log.i("MicroMsg.CardConsumeSuccessUI", "onSceneEnd, errType = " + i2 + " errCode = " + i3 + " scene cmd is " + qVar.getType());
        ku(false);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof com.tencent.mm.plugin.card.sharecard.model.g) {
                com.tencent.mm.plugin.card.sharecard.model.g gVar = (com.tencent.mm.plugin.card.sharecard.model.g) qVar;
                if (gVar.pTZ == 0) {
                    com.tencent.mm.ui.base.h.cD(this, getString(R.string.ang));
                    setResult(-1);
                    this.pXa.setEnabled(false);
                    l.cxG();
                    Log.i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
                    En(-1);
                    String str2 = ((com.tencent.mm.plugin.card.sharecard.model.g) qVar).pTY;
                    ShareCardInfo shareCardInfo = new ShareCardInfo();
                    f.a(shareCardInfo, str2);
                    l.a(shareCardInfo);
                    am.ctX().onChange();
                    finish();
                    AppMethodBeat.o(113065);
                    return;
                }
                Log.e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + gVar.pTZ);
                com.tencent.mm.plugin.card.d.d.c(this, gVar.pUa);
                com.tencent.mm.ui.base.h.cD(this, getString(R.string.anc));
                AppMethodBeat.o(113065);
                return;
            } else if (qVar instanceof d) {
                d dVar = (d) qVar;
                if (dVar.pTZ == 0) {
                    if (TextUtils.isEmpty(dVar.pTY) || !ajB(dVar.pTY)) {
                        Log.e("MicroMsg.CardConsumeSuccessUI", "consumed return json is empty, finish ui!");
                        if (this.pXf == 1) {
                            En(0);
                            finish();
                            AppMethodBeat.o(113065);
                            return;
                        }
                        cuF();
                        ajD(dVar.pUa);
                        if (Util.isNullOrNil(dVar.pUa)) {
                            com.tencent.mm.ui.base.h.cD(this, getString(R.string.ane));
                            AppMethodBeat.o(113065);
                            return;
                        }
                        com.tencent.mm.ui.base.h.cD(this, dVar.pUa);
                        AppMethodBeat.o(113065);
                        return;
                    }
                    Log.i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
                    this.ndA.post(new Runnable() {
                        /* class com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(113053);
                            CardConsumeSuccessUI.d(CardConsumeSuccessUI.this);
                            AppMethodBeat.o(113053);
                        }
                    });
                    AppMethodBeat.o(113065);
                    return;
                } else if (this.pXf == 1) {
                    En(0);
                    finish();
                    AppMethodBeat.o(113065);
                    return;
                } else {
                    Log.e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + dVar.pTZ);
                    cuF();
                    ajD(dVar.pUa);
                    AppMethodBeat.o(113065);
                    return;
                }
            }
        } else if (!(qVar instanceof d) || this.pXf != 1) {
            com.tencent.mm.plugin.card.d.d.c(this, str);
        } else {
            En(0);
            finish();
            AppMethodBeat.o(113065);
            return;
        }
        AppMethodBeat.o(113065);
    }

    private void ajD(String str) {
        AppMethodBeat.i(113066);
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.ane);
        }
        com.tencent.mm.ui.base.h.a((Context) this, str, "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(113054);
                dialogInterface.dismiss();
                CardConsumeSuccessUI.cuH();
                CardConsumeSuccessUI.this.finish();
                AppMethodBeat.o(113054);
            }
        });
        AppMethodBeat.o(113066);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(113067);
        if (i2 == 4) {
            Log.e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
            En(0);
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(113067);
        return onKeyDown;
    }

    private static void En(int i2) {
        AppMethodBeat.i(113068);
        Log.i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is ".concat(String.valueOf(i2)));
        cn cnVar = new cn();
        cnVar.dFI.resultCode = i2;
        EventCenter.instance.publish(cnVar);
        AppMethodBeat.o(113068);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(113069);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    this.pXh = intent.getIntExtra("Ktag_range_index", 0);
                    Log.i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", Integer.valueOf(this.pXh));
                    if (this.pXh < 2) {
                        this.pWY.setVisibility(8);
                        break;
                    } else {
                        this.pXi = intent.getStringExtra("Klabel_name_list");
                        this.pXj = intent.getStringExtra("Kother_user_name_list");
                        Log.d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", Integer.valueOf(this.pXh), this.pXi);
                        if (!TextUtils.isEmpty(this.pXi) || !TextUtils.isEmpty(this.pXj)) {
                            List asList = Arrays.asList(this.pXi.split(","));
                            this.pXl = l.cZ(asList);
                            this.pXk = l.cY(asList);
                            if (this.pXj != null && this.pXj.length() > 0) {
                                this.pXk.addAll(Arrays.asList(this.pXj.split(",")));
                            }
                            if (this.pXl != null) {
                                Log.i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.pXl.size());
                            }
                            if (this.pXk != null) {
                                Log.i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.pXk.size());
                                Iterator<String> it = this.pXk.iterator();
                                while (it.hasNext()) {
                                    Log.d("MicroMsg.CardConsumeSuccessUI", "username : %s", it.next());
                                }
                            }
                            if (this.pXh == 2) {
                                this.pWY.setVisibility(0);
                                this.pWY.setText(getString(R.string.asn, new Object[]{cuG()}));
                                AppMethodBeat.o(113069);
                                return;
                            } else if (this.pXh == 3) {
                                this.pWY.setVisibility(0);
                                this.pWY.setText(getString(R.string.asm, new Object[]{cuG()}));
                                AppMethodBeat.o(113069);
                                return;
                            } else {
                                this.pWY.setVisibility(8);
                                AppMethodBeat.o(113069);
                                return;
                            }
                        } else {
                            Log.e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
                            AppMethodBeat.o(113069);
                            return;
                        }
                    }
                } else {
                    AppMethodBeat.o(113069);
                    return;
                }
        }
        AppMethodBeat.o(113069);
    }

    private String cuG() {
        AppMethodBeat.i(113070);
        if (!TextUtils.isEmpty(this.pXi) && !TextUtils.isEmpty(this.pXj)) {
            String str = this.pXi + "," + l.akh(this.pXj);
            AppMethodBeat.o(113070);
            return str;
        } else if (!TextUtils.isEmpty(this.pXi)) {
            String str2 = this.pXi;
            AppMethodBeat.o(113070);
            return str2;
        } else if (!TextUtils.isEmpty(this.pXj)) {
            String akh = l.akh(this.pXj);
            AppMethodBeat.o(113070);
            return akh;
        } else {
            AppMethodBeat.o(113070);
            return "";
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(113060);
        g.aAg().hqi.b(902, this);
        g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.jsapi.f.b.CTRL_INDEX, this);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (!TextUtils.isEmpty(this.pQH)) {
            h.INSTANCE.a(13219, "CardConsumeSuccessUI", Integer.valueOf(this.pXf), this.pRT, this.pQH, Long.valueOf(currentTimeMillis));
        } else {
            h.INSTANCE.a(13219, "CardConsumeSuccessUI", Integer.valueOf(this.pXf), this.pRT, this.pXd, Long.valueOf(currentTimeMillis));
        }
        super.onDestroy();
        AppMethodBeat.o(113060);
    }

    static /* synthetic */ void a(CardConsumeSuccessUI cardConsumeSuccessUI) {
        String str;
        com.tencent.mm.plugin.card.sharecard.model.g gVar;
        AppMethodBeat.i(113072);
        if (cardConsumeSuccessUI.pXc == null || cardConsumeSuccessUI.pXc.dtS == null || cardConsumeSuccessUI.pXc.dtS.isEmpty()) {
            Log.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list == null || mConsumedInfo.list.isEmpty()!");
            AppMethodBeat.o(113072);
            return;
        }
        cardConsumeSuccessUI.ku(true);
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < cardConsumeSuccessUI.pXc.dtS.size(); i2++) {
            uz uzVar = cardConsumeSuccessUI.pXc.dtS.get(i2).pTh;
            dxg dxg = new dxg();
            if (uzVar != null) {
                dxg.pRX = uzVar.pRX;
                cardConsumeSuccessUI.pRT = uzVar.pRX;
            }
            dxg.eaP = cardConsumeSuccessUI.pXc.dtS.get(i2).eaP;
            dxg.KDg = "";
            dxg.KDf = "";
            dxg.KDh = cardConsumeSuccessUI.pXg;
            linkedList.add(dxg);
        }
        if (cardConsumeSuccessUI.pXf == 1) {
            str = cardConsumeSuccessUI.pXc.pVW;
        } else {
            str = cardConsumeSuccessUI.pQH;
        }
        dxy a2 = l.a(cardConsumeSuccessUI.pXh, cardConsumeSuccessUI.pXk, cardConsumeSuccessUI.pXl);
        if (cardConsumeSuccessUI.pXb.isChecked()) {
            gVar = new com.tencent.mm.plugin.card.sharecard.model.g(0, linkedList, cardConsumeSuccessUI.pXc.pVY, str, a2, 20, null);
        } else {
            gVar = new com.tencent.mm.plugin.card.sharecard.model.g(0, linkedList, "", str, a2, 20, null);
        }
        if (cardConsumeSuccessUI.pXb != null && cardConsumeSuccessUI.pXb.getVisibility() == 0) {
            if (cardConsumeSuccessUI.pXb.isChecked()) {
                h.INSTANCE.a(11324, "CardConsumeSuccessFollowServices", 0, "", "", 0, 0, "", 0, "");
            } else {
                h.INSTANCE.a(11324, "CardConsumeSuccessView", 0, "", "", 0, 0, "", 0, "");
            }
        }
        g.aAg().hqi.a(gVar, 0);
        AppMethodBeat.o(113072);
    }
}
