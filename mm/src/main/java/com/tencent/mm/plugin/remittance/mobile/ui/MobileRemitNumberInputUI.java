package com.tencent.mm.plugin.remittance.mobile.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.b.a.lc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.plugin.remittance.mobile.cgi.d;
import com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.protocal.protobuf.ejy;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.protocal.protobuf.eke;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.b;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class MobileRemitNumberInputUI extends MobileRemitBaseUI {
    private RelativeLayout CmR;
    private LinearLayout CmS;
    private WalletFormView CmT;
    private Button CmU;
    private View CmV;
    private eke CmW;
    private String content;
    private TextView jVn;
    private ScrollView lTw;
    private TextView mPa;
    private boolean qnr;
    private boolean uMD = false;
    private InputPanelFrameLayout yMr;
    private TextView yQS;
    private View yfU;
    private int ygg;

    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(MobileRemitNumberInputUI mobileRemitNumberInputUI, boolean z) {
        AppMethodBeat.i(67739);
        mobileRemitNumberInputUI.tJ(z);
        AppMethodBeat.o(67739);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bb6;
    }

    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67731);
        super.onCreate(bundle);
        this.content = getIntent().getStringExtra("key_content");
        overridePendingTransition(R.anim.eq, R.anim.en);
        initView();
        if (!Util.isNullOrNil(this.content)) {
            this.CmT.setText(this.content);
            this.CmU.setEnabled(true);
        }
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_MOBILE_REMITTANCE_HOME_PAGE_INFO_STRING_SYNC, "");
        Object[] objArr = new Object[1];
        objArr[0] = Util.isNullOrNil(str) ? BuildConfig.COMMAND : str;
        Log.d("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "updateResponse() jsonString:%s", objArr);
        if (!Util.isNullOrNil(str)) {
            this.CmW = d.aLZ(str);
        }
        updateView();
        boolean isNullOrNil = Util.isNullOrNil(str);
        Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "doNetSceneMobileRemitGetHomePage() isShowProgress:%s", Boolean.valueOf(isNullOrNil));
        this.qnr = isNullOrNil;
        doSceneProgress(new d(), isNullOrNil);
        addSceneEndListener(2952);
        addSceneEndListener(2993);
        addSceneEndListener(1495);
        AppMethodBeat.o(67731);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67732);
        super.initView();
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        setBackGroundColorResource(R.color.afz);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(67713);
                MobileRemitNumberInputUI.this.finish();
                AppMethodBeat.o(67713);
                return true;
            }
        });
        this.yMr = (InputPanelFrameLayout) findViewById(R.id.h8y);
        this.lTw = (ScrollView) findViewById(R.id.hcs);
        this.CmR = (RelativeLayout) findViewById(R.id.fhw);
        this.CmS = (LinearLayout) findViewById(R.id.fhv);
        this.yQS = (TextView) findViewById(R.id.a2b);
        this.mPa = (TextView) findViewById(R.id.fhx);
        this.jVn = (TextView) findViewById(R.id.fhr);
        this.CmT = (WalletFormView) findViewById(R.id.fhy);
        TextView titleTv = this.CmT.getTitleTv();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) titleTv.getLayoutParams();
        layoutParams.width = -2;
        titleTv.setLayoutParams(layoutParams);
        TenpaySecureEditText tenpaySecureEditText = (TenpaySecureEditText) this.CmT.getContentEt();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tenpaySecureEditText.getLayoutParams();
        layoutParams2.leftMargin = a.fromDPToPix((Context) getContext(), 24);
        tenpaySecureEditText.setLayoutParams(layoutParams2);
        tenpaySecureEditText.setFocusable(true);
        this.CmT.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(R.color.FG_2));
        this.CmU = (Button) findViewById(R.id.fhs);
        this.yfU = findViewById(R.id.fhu);
        this.CmV = findViewById(R.id.aaq);
        this.yMr.setExternalListener(new b.a() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.widget.b.a
            public final void f(boolean z, int i2) {
                AppMethodBeat.i(67716);
                if (MobileRemitNumberInputUI.this.ygg == 0) {
                    int height = ((WindowManager) MobileRemitNumberInputUI.this.getSystemService("window")).getDefaultDisplay().getHeight();
                    int fromDPToPix = a.fromDPToPix((Context) MobileRemitNumberInputUI.this.getContext(), 96);
                    int fromDPToPix2 = a.fromDPToPix((Context) MobileRemitNumberInputUI.this.getContext(), 64);
                    int fromDPToPix3 = a.fromDPToPix((Context) MobileRemitNumberInputUI.this.getContext(), 48);
                    int fromDPToPix4 = a.fromDPToPix((Context) MobileRemitNumberInputUI.this.getContext(), 40);
                    int ay = ((height - au.ay(MobileRemitNumberInputUI.this.getContext())) - h.eu(MobileRemitNumberInputUI.this.getContext())) - MobileRemitNumberInputUI.this.yfU.getBottom();
                    if (((ay - fromDPToPix4) - i2) - fromDPToPix2 > fromDPToPix3) {
                        MobileRemitNumberInputUI.this.ygg = i2 - (fromDPToPix - fromDPToPix2);
                    } else {
                        MobileRemitNumberInputUI.this.ygg = ((ay - fromDPToPix3) - fromDPToPix4) - fromDPToPix;
                    }
                }
                MobileRemitNumberInputUI.a(MobileRemitNumberInputUI.this, z);
                Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(MobileRemitNumberInputUI.this.ygg));
                AppMethodBeat.o(67716);
            }
        });
        this.CmU.setEnabled(false);
        this.CmU.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI.AnonymousClass4 */

            public final void onClick(View view) {
                int i2;
                AppMethodBeat.i(67717);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "mSubmitBt click!");
                if (!Util.isNullOrNil(MobileRemitNumberInputUI.this.content)) {
                    i2 = 3;
                } else {
                    i2 = 1;
                }
                MobileRemitNumberInputUI.this.doSceneProgress(new NetSceneMobileRemitGetRecvInfo(MobileRemitNumberInputUI.this.CmT.getText(), "", MobileRemitNumberInputUI.this.CmW.Njj, i2), true);
                MobileRemitNumberInputUI.Wc(5);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67717);
            }
        });
        this.CmT.getInfoIv().setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(67718);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "history click!");
                MobileRemitNumberInputUI.f(MobileRemitNumberInputUI.this);
                MobileRemitNumberInputUI.Wc(12);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67718);
            }
        });
        this.CmT.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI.AnonymousClass6 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(67719);
                if (MobileRemitNumberInputUI.this.CmT.getInputLength() > 0) {
                    MobileRemitNumberInputUI.this.CmU.setEnabled(true);
                    AppMethodBeat.o(67719);
                    return;
                }
                MobileRemitNumberInputUI.this.CmU.setEnabled(false);
                AppMethodBeat.o(67719);
            }
        });
        this.CmT.getContentEt().requestFocus();
        AppMethodBeat.o(67732);
    }

    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(67733);
        if (this.Cmp == MobileRemitBaseUI.a.ACTIVITY_PAUSE && this.uMD) {
            tJ(false);
            this.yMr.getInputPanelHelper().AxH = false;
        }
        super.onResume();
        this.yMr.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(67720);
                MobileRemitNumberInputUI.this.showVKB();
                AppMethodBeat.o(67720);
            }
        }, 500);
        AppMethodBeat.o(67733);
    }

    private void updateView() {
        AppMethodBeat.i(67734);
        Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "updateView() mResponse:%s", d.a(this.CmW));
        if (this.CmW == null) {
            this.CmR.setVisibility(4);
            AppMethodBeat.o(67734);
            return;
        }
        this.CmR.setVisibility(0);
        if (this.CmW.Njs != null) {
            this.CmS.setVisibility(0);
            this.yQS.setText(this.CmW.Njs.dQx);
            this.CmS.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(67723);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click!");
                    l.a(MobileRemitNumberInputUI.this.getContext(), MobileRemitNumberInputUI.this.CmW.Njs, (Object) null, new com.tencent.mm.plugin.remittance.mobile.a.a() {
                        /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI.AnonymousClass8.AnonymousClass1 */

                        @Override // com.tencent.mm.wallet_core.c.l.a
                        public final void eNw() {
                            AppMethodBeat.i(67721);
                            Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click jumpItem.action:exit");
                            MobileRemitNumberInputUI.this.eNv();
                            AppMethodBeat.o(67721);
                        }

                        @Override // com.tencent.mm.wallet_core.c.l.a
                        public final void dP(Object obj) {
                            AppMethodBeat.i(67722);
                            Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "notice click jumpItem.action:continue");
                            AppMethodBeat.o(67722);
                        }
                    });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitNumberInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(67723);
                }
            });
        } else {
            this.CmS.setVisibility(8);
        }
        this.mPa.setText(this.CmW.title);
        this.jVn.setText(this.CmW.subtitle);
        if (this.CmW.Njq == 0) {
            this.CmT.getInfoIv().setVisibility(8);
        } else if (this.CmW.Njq == 1) {
            this.CmT.getInfoIv().setVisibility(0);
        }
        if (this.CmW.Njr.size() > 0) {
            addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI.AnonymousClass9 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(67728);
                    Log.d("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "onMenuItemClick click");
                    e eVar = new e((Context) MobileRemitNumberInputUI.this.getContext(), 1, false);
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI.AnonymousClass9.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(67724);
                            for (int i2 = 0; i2 < MobileRemitNumberInputUI.this.CmW.Njr.size(); i2++) {
                                mVar.d(i2, MobileRemitNumberInputUI.this.CmW.Njr.get(i2).dQx);
                            }
                            AppMethodBeat.o(67724);
                        }
                    };
                    eVar.HLY = new o.g() {
                        /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI.AnonymousClass9.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(67727);
                            if (menuItem.getItemId() >= MobileRemitNumberInputUI.this.CmW.Njr.size() || menuItem.getItemId() < 0) {
                                Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "menuItem click menuItem.getItemId() illegal");
                                AppMethodBeat.o(67727);
                                return;
                            }
                            l.a(MobileRemitNumberInputUI.this.getContext(), MobileRemitNumberInputUI.this.CmW.Njr.get(menuItem.getItemId()), (Object) null, new com.tencent.mm.plugin.remittance.mobile.a.a() {
                                /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI.AnonymousClass9.AnonymousClass2.AnonymousClass1 */

                                @Override // com.tencent.mm.wallet_core.c.l.a
                                public final void eNw() {
                                    AppMethodBeat.i(67725);
                                    Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "bottomSheet click jumpItem.action:exit");
                                    MobileRemitNumberInputUI.this.eNv();
                                    AppMethodBeat.o(67725);
                                }

                                @Override // com.tencent.mm.wallet_core.c.l.a
                                public final void dP(Object obj) {
                                    AppMethodBeat.i(67726);
                                    Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "bottomSheet click jumpItem.action:continue");
                                    AppMethodBeat.o(67726);
                                }
                            });
                            Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "menuItem click JumpItem:%s", l.b(MobileRemitNumberInputUI.this.CmW.Njr.get(menuItem.getItemId())));
                            AppMethodBeat.o(67727);
                        }
                    };
                    eVar.dGm();
                    AppMethodBeat.o(67728);
                    return false;
                }
            });
            AppMethodBeat.o(67734);
            return;
        }
        removeOptionMenu(0);
        AppMethodBeat.o(67734);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(67735);
        super.finish();
        try {
            hideVKB();
            AppMethodBeat.o(67735);
        } catch (Exception e2) {
            Log.e("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(67735);
        }
    }

    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(67736);
        super.onDestroy();
        removeSceneEndListener(2952);
        removeSceneEndListener(2993);
        removeSceneEndListener(1495);
        AppMethodBeat.o(67736);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        eke eke = null;
        AppMethodBeat.i(67737);
        Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " scenetype:" + qVar.getType());
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof d) {
                d dVar = (d) qVar;
                if (dVar.ClS != null) {
                    eke = dVar.ClS;
                }
                this.CmW = eke;
                if (this.CmW != null && this.CmW.pTZ == 0) {
                    updateView();
                    g.aAh().azQ().set(ar.a.USERINFO_MOBILE_REMITTANCE_HOME_PAGE_INFO_STRING_SYNC, d.b(this.CmW));
                } else if (this.qnr) {
                    u.makeText(getContext(), (this.CmW == null || Util.isNullOrNil(this.CmW.pUa)) ? getString(R.string.ibn) : this.CmW.pUa, 0).show();
                }
            } else if (qVar instanceof NetSceneMobileRemitGetRecord) {
                ejy eNm = ((NetSceneMobileRemitGetRecord) qVar).eNm();
                if (eNm == null || eNm.pTZ != 0) {
                    u.makeText(getContext(), (eNm == null || Util.isNullOrNil(eNm.pUa)) ? getString(R.string.ibn) : eNm.pUa, 0).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("key_homepage_ext", this.CmW.Njj);
                    intent.putExtra("key_finish", eNm.chA);
                    intent.putExtra("key_last_id", eNm.Nji);
                    intent.putExtra("key_history_record", NetSceneMobileRemitGetRecord.bl(eNm.Njk));
                    c.b(getContext(), "remittance", ".mobile.ui.MobileRemitHistoryRecodUI", intent);
                    Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "TransferPhoneGetHisRcvrsResp finish:%s lastId:%s hisRecord.size:%s", Boolean.valueOf(eNm.chA), eNm.Nji, Integer.valueOf(eNm.Njk.size()));
                }
            } else if (qVar instanceof NetSceneMobileRemitGetRecvInfo) {
                final eka eNn = ((NetSceneMobileRemitGetRecvInfo) qVar).eNn();
                if (eNn == null) {
                    Log.e("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "NetSceneMobileRemitGetRecvInfo rcvrResp is null");
                    AppMethodBeat.o(67737);
                    return true;
                }
                Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "NetSceneMobileRemitGetRecvInfo phone:%s ret_code:%s ret_msg:%s", ((NetSceneMobileRemitGetRecvInfo) qVar).pSm, Integer.valueOf(eNn.pTZ), eNn.pUa);
                if (eNn.pTZ != 0) {
                    if (eNn.ClW == 1) {
                        Log.w("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "why here???");
                    }
                    com.tencent.mm.ui.base.h.a((Context) getContext(), Util.isNullOrNil(eNn.pUa) ? getString(R.string.ibn) : eNn.pUa, "", getResources().getString(R.string.f1r), false, (DialogInterface.OnClickListener) null).show();
                } else {
                    if (eNn.Njl != null) {
                        Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "show remark or nickname change dialog!");
                        l.a(this, eNn.Njl, (Object) null, new com.tencent.mm.plugin.remittance.mobile.a.a() {
                            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI.AnonymousClass10 */

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final void eNw() {
                                AppMethodBeat.i(67729);
                                Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "wxname_chg_win dialog click jumpItem.action:exit");
                                MobileRemitNumberInputUI.this.eNv();
                                AppMethodBeat.o(67729);
                            }

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final void dP(Object obj) {
                                AppMethodBeat.i(67730);
                                Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "wxname_chg_win dialog click jumpItem.action:continue");
                                com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitNumberInputUI.this.getContext(), eNn);
                                AppMethodBeat.o(67730);
                            }
                        });
                    } else if (eNn.Nja != null) {
                        Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "show free oneself from dialog!");
                        l.a(this, eNn.Nja, (Object) null, new com.tencent.mm.plugin.remittance.mobile.a.a() {
                            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitNumberInputUI.AnonymousClass2 */

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final void eNw() {
                                AppMethodBeat.i(67714);
                                Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "jump_win dialog click jumpItem.action:exit");
                                MobileRemitNumberInputUI.this.eNv();
                                AppMethodBeat.o(67714);
                            }

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final void dP(Object obj) {
                                AppMethodBeat.i(67715);
                                Log.i("MicroMsg.mobileRemit.MobileRemitNumberInputUI", "jump_win dialog click jumpItem.action:continue");
                                com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitNumberInputUI.this.getContext(), eNn);
                                AppMethodBeat.o(67715);
                            }
                        });
                    } else {
                        com.tencent.mm.plugin.remittance.mobile.a.b.a(getContext(), eNn);
                    }
                    AppMethodBeat.o(67737);
                    return true;
                }
            }
            AppMethodBeat.o(67737);
            return false;
        } else if (qVar instanceof d) {
            if (this.qnr) {
                AppCompatActivity context = getContext();
                if (Util.isNullOrNil(str)) {
                    str = getString(R.string.ibn);
                }
                u.makeText(context, str, 0).show();
            }
            AppMethodBeat.o(67737);
            return true;
        } else {
            if (i3 == 0) {
                AppCompatActivity context2 = getContext();
                if (Util.isNullOrNil(str)) {
                    str = getString(R.string.f1s);
                }
                u.makeText(context2, str, 0).show();
            }
            AppMethodBeat.o(67737);
            return true;
        }
    }

    private void tJ(boolean z) {
        ObjectAnimator ofFloat;
        AppMethodBeat.i(67738);
        this.uMD = z;
        if (z) {
            ofFloat = ObjectAnimator.ofFloat(this.CmV, "translationY", this.CmV.getTranslationY(), this.CmV.getTranslationY() - ((float) this.ygg));
        } else {
            ofFloat = ObjectAnimator.ofFloat(this.CmV, "translationY", this.CmV.getTranslationY(), this.CmV.getTranslationY() + ((float) this.ygg));
        }
        ofFloat.setDuration(175L);
        ofFloat.setInterpolator(new android.support.v4.view.b.b());
        ofFloat.start();
        AppMethodBeat.o(67738);
    }

    static /* synthetic */ void Wc(int i2) {
        AppMethodBeat.i(67740);
        lc lcVar = new lc();
        lcVar.ejA = (long) i2;
        lcVar.bfK();
        AppMethodBeat.o(67740);
    }

    static /* synthetic */ void f(MobileRemitNumberInputUI mobileRemitNumberInputUI) {
        AppMethodBeat.i(67741);
        mobileRemitNumberInputUI.doSceneProgress(new NetSceneMobileRemitGetRecord("", mobileRemitNumberInputUI.CmW.Njj), true);
        AppMethodBeat.o(67741);
    }
}
