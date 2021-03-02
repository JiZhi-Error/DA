package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.remittance.bankcard.a.d;
import com.tencent.mm.plugin.remittance.bankcard.a.g;
import com.tencent.mm.plugin.remittance.bankcard.a.k;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.tavkit.component.TAVExporter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankRemitBankcardInputUI extends BankRemitBaseUI {
    private WalletFormView CjA;
    private ListPopupWindow CjB;
    private c CjC;
    private Filter.FilterListener CjD;
    private ArrayList<TransferRecordParcel> CjE;
    private ArrayList<TransferRecordParcel> CjF;
    private int CjG;
    private int CjH;
    private String CjI;
    private String CjJ;
    private String CjK;
    private String CjL;
    private String CjM;
    private String CjN;
    private EnterTimeParcel CjO;
    private BankcardElemParcel CjP;
    private TransferRecordParcel CjQ;
    private boolean CjR = true;
    private boolean CjS = false;
    private boolean CjT = false;
    private boolean CjU = false;
    private g CjV = null;
    private boolean CjW = false;
    private boolean CjX = false;
    private boolean CjY = true;
    private boolean CjZ = false;
    private CdnImageView Cjq;
    private WalletFormView Cjx;
    private WalletFormView Cjy;
    private WalletFormView Cjz;
    private boolean Cka = false;
    private boolean Ckb = false;
    private String Ckc;
    private String Ckd;
    private String content;
    private String dUb = "";
    private Button krs;
    private e tiF;
    private Dialog zhz = null;

    @Override // com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ View D(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67487);
        View contentView = bankRemitBankcardInputUI.getContentView();
        AppMethodBeat.o(67487);
        return contentView;
    }

    static /* synthetic */ View E(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67488);
        View contentView = bankRemitBankcardInputUI.getContentView();
        AppMethodBeat.o(67488);
        return contentView;
    }

    static /* synthetic */ void F(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67489);
        bankRemitBankcardInputUI.forceCancel();
        AppMethodBeat.o(67489);
    }

    static /* synthetic */ void G(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67490);
        bankRemitBankcardInputUI.eNa();
        AppMethodBeat.o(67490);
    }

    static /* synthetic */ void H(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67491);
        bankRemitBankcardInputUI.eNe();
        AppMethodBeat.o(67491);
    }

    static /* synthetic */ void I(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67492);
        bankRemitBankcardInputUI.eNi();
        AppMethodBeat.o(67492);
    }

    static /* synthetic */ void J(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67493);
        bankRemitBankcardInputUI.eNf();
        AppMethodBeat.o(67493);
    }

    static /* synthetic */ void K(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67494);
        bankRemitBankcardInputUI.eNg();
        AppMethodBeat.o(67494);
    }

    static /* synthetic */ void R(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67497);
        bankRemitBankcardInputUI.eNd();
        AppMethodBeat.o(67497);
    }

    static /* synthetic */ void V(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67499);
        bankRemitBankcardInputUI.tI(true);
        AppMethodBeat.o(67499);
    }

    static /* synthetic */ void a(BankRemitBankcardInputUI bankRemitBankcardInputUI, String str, String str2, String str3) {
        AppMethodBeat.i(67498);
        bankRemitBankcardInputUI.aE(str, str2, str3);
        AppMethodBeat.o(67498);
    }

    static /* synthetic */ void a(BankRemitBankcardInputUI bankRemitBankcardInputUI, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(67486);
        bankRemitBankcardInputUI.z(str, str2, str3, str4);
        AppMethodBeat.o(67486);
    }

    static /* synthetic */ void k(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67480);
        bankRemitBankcardInputUI.eNh();
        AppMethodBeat.o(67480);
    }

    @Override // com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67456);
        super.onCreate(bundle);
        hideActionbarLine();
        this.content = getIntent().getStringExtra("key_content");
        initView();
        final zt ztVar = new zt();
        ztVar.efM.scene = "12";
        ztVar.callback = new Runnable() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(67422);
                if (!Util.isNullOrNil(ztVar.efN.efO)) {
                    f.a((TextView) BankRemitBankcardInputUI.this.findViewById(R.id.a2b), ztVar.efN.efO, ztVar.efN.content, ztVar.efN.url);
                }
                AppMethodBeat.o(67422);
            }
        };
        EventCenter.instance.publish(ztVar);
        addSceneEndListener(1348);
        addSceneEndListener(1542);
        addSceneEndListener(1378);
        addSceneEndListener(1349);
        addSceneEndListener(TAVExporter.VIDEO_EXPORT_HEIGHT);
        this.CjN = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_BANK_REMIT_PAYLIST_STRING_SYNC, "");
        tI(false);
        eNa();
        setMMTitle(R.string.acb);
        addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass12 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(67435);
                Log.d("MicroMsg.BankRemitBankcardInputUI", "help click");
                BankRemitBankcardInputUI.this.tiF = new e((Context) BankRemitBankcardInputUI.this.getContext(), 1, false);
                BankRemitBankcardInputUI.this.tiF.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass12.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(67433);
                        mVar.add(0, 0, 0, BankRemitBankcardInputUI.this.getString(R.string.abm));
                        mVar.add(0, 1, 0, BankRemitBankcardInputUI.this.getString(R.string.abk));
                        AppMethodBeat.o(67433);
                    }
                };
                BankRemitBankcardInputUI.this.tiF.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass12.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(67434);
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (!Util.isNullOrNil(BankRemitBankcardInputUI.this.CjN)) {
                                    f.p(BankRemitBankcardInputUI.this.getContext(), BankRemitBankcardInputUI.this.CjN, false);
                                } else {
                                    Log.w("MicroMsg.BankRemitBankcardInputUI", "paylist url is null");
                                }
                                h.INSTANCE.a(14673, 6);
                                AppMethodBeat.o(67434);
                                return;
                            case 1:
                                f.p(BankRemitBankcardInputUI.this.getContext(), HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1p) + "/touch/scene_product.html?scene_id=kf4568", true);
                                break;
                        }
                        AppMethodBeat.o(67434);
                    }
                };
                BankRemitBankcardInputUI.this.hideTenpayKB();
                BankRemitBankcardInputUI.this.tiF.dGm();
                h.INSTANCE.a(14673, 2);
                AppMethodBeat.o(67435);
                return false;
            }
        });
        h.INSTANCE.a(14673, 1);
        AppMethodBeat.o(67456);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67457);
        int fromDPToPix = a.fromDPToPix((Context) getContext(), 16);
        int fromDPToPix2 = a.fromDPToPix((Context) getContext(), 8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(fromDPToPix, fromDPToPix);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = fromDPToPix2;
        this.Cjx = (WalletFormView) findViewById(R.id.acb);
        this.Cjx.getInfoIv().setLayoutParams(layoutParams);
        this.Cjx.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.Cjx.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(R.color.FG_2));
        this.Cjy = (WalletFormView) findViewById(R.id.aca);
        this.Cjy.getInfoIv().setLayoutParams(layoutParams);
        this.Cjy.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.Cjy.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(R.color.FG_2));
        this.Cjz = (WalletFormView) findViewById(R.id.ac_);
        this.Cjq = (CdnImageView) this.Cjz.findViewById(R.id.jfw);
        this.CjA = (WalletFormView) findViewById(R.id.ac9);
        this.krs = (Button) findViewById(R.id.acc);
        this.Cjx.setFilterChar("\\x20\\t\\r\\n".toCharArray());
        this.Cjx.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass23 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(67446);
                BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this);
                BankRemitBankcardInputUI.d(BankRemitBankcardInputUI.this);
                if (!BankRemitBankcardInputUI.this.CjR || BankRemitBankcardInputUI.this.CjB == null) {
                    BankRemitBankcardInputUI.this.CjR = true;
                } else {
                    BankRemitBankcardInputUI.this.CjC.getFilter().filter(editable.toString(), BankRemitBankcardInputUI.this.CjD);
                }
                if (BankRemitBankcardInputUI.this.CjS) {
                    BankRemitBankcardInputUI.j(BankRemitBankcardInputUI.this);
                }
                BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
                BankRemitBankcardInputUI.this.CjS = false;
                if (BankRemitBankcardInputUI.this.CjZ && BankRemitBankcardInputUI.this.Cjx.getInputLength() <= BankRemitBankcardInputUI.this.CjG) {
                    BankRemitBankcardInputUI.this.Cjx.setMaxInputLength(BankRemitBankcardInputUI.this.CjG);
                    BankRemitBankcardInputUI.this.Cjx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(BankRemitBankcardInputUI.this.CjG)});
                }
                AppMethodBeat.o(67446);
            }
        });
        this.Cjx.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass24 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(67448);
                if (i2 == 5) {
                    BankRemitBankcardInputUI.this.hideVKB();
                    if (!BankRemitBankcardInputUI.this.CjT) {
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass24.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(67447);
                                BankRemitBankcardInputUI.this.showTenpayKB();
                                AppMethodBeat.o(67447);
                            }
                        }, 200);
                    }
                }
                AppMethodBeat.o(67448);
                return false;
            }
        });
        this.Cjx.hic();
        com.tencent.mm.wallet_core.ui.formview.a.b(this.Cjy);
        setEditFocusListener(this.Cjy, 2, false, false, true);
        this.Cjy.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass25 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(67450);
                BankRemitBankcardInputUI.this.CjY = true;
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass25.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(67449);
                        BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
                        AppMethodBeat.o(67449);
                    }
                }, 200);
                AppMethodBeat.o(67450);
            }
        });
        if (!Util.isNullOrNil(this.content)) {
            this.Cjy.setText(this.content);
        }
        this.Cjz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass26 */

            public final void onClick(View view) {
                AppMethodBeat.i(67451);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BankRemitBankcardInputUI.this.hideVKB();
                String text = BankRemitBankcardInputUI.this.Cjy.getText();
                if (!BankRemitBankcardInputUI.this.CjY || Util.isNullOrNil(text)) {
                    BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
                } else {
                    BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, text, BankRemitBankcardInputUI.this.Cjy.getMD5Value());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67451);
            }
        });
        this.CjA.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass27 */

            public final void onClick(View view) {
                AppMethodBeat.i(67452);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.BankRemitBankcardInputUI", "click arrive time et");
                BankRemitBankcardInputUI.this.hideVKB();
                BankRemitBankcardInputUI.this.Cjy.eIi();
                if (!BankRemitBankcardInputUI.u(BankRemitBankcardInputUI.this)) {
                    Intent intent = new Intent(BankRemitBankcardInputUI.this.getContext(), BankRemitSelectArriveTimeUI.class);
                    if (!(BankRemitBankcardInputUI.this.CjP == null || BankRemitBankcardInputUI.this.CjP.Cjd == null)) {
                        intent.putParcelableArrayListExtra("key_arrive_time_parcel_list", BankRemitBankcardInputUI.this.CjP.Cjd);
                    }
                    if (BankRemitBankcardInputUI.this.CjO != null) {
                        intent.putExtra("key_select_arrive_time", BankRemitBankcardInputUI.this.CjO.Cjg);
                    }
                    BankRemitBankcardInputUI.this.startActivityForResult(intent, 3);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67452);
            }
        });
        this.krs.setOnClickListener(new x() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass28 */

            @Override // com.tencent.mm.ui.x
            public final void czW() {
                AppMethodBeat.i(67454);
                Log.i("MicroMsg.BankRemitBankcardInputUI", "click next btn");
                BankRemitBankcardInputUI.this.hideVKB();
                BankRemitBankcardInputUI.this.hideTenpayKB();
                if (BankRemitBankcardInputUI.u(BankRemitBankcardInputUI.this)) {
                    AppMethodBeat.o(67454);
                    return;
                }
                String text = BankRemitBankcardInputUI.this.Cjx.getText();
                String text2 = BankRemitBankcardInputUI.this.Cjy.getText();
                if (Util.isNullOrNil(text) || text.trim().isEmpty() || Util.isNullOrNil(text2) || text2.trim().isEmpty() || BankRemitBankcardInputUI.this.CjP == null) {
                    Log.w("MicroMsg.BankRemitBankcardInputUI", "args is empty, payeeName: %s, bankCardNo: %s, bankcard: %s", text, text2, BankRemitBankcardInputUI.this.CjP);
                    AppMethodBeat.o(67454);
                    return;
                }
                Log.i("MicroMsg.BankRemitBankcardInputUI", "onRealClick() ifGetOperation:%s waitingGetOperation:%s ifAutoNext:%s", Boolean.valueOf(BankRemitBankcardInputUI.this.CjZ), Boolean.valueOf(BankRemitBankcardInputUI.this.Cka), Boolean.valueOf(BankRemitBankcardInputUI.this.Ckb));
                if (!BankRemitBankcardInputUI.this.CjZ) {
                    BankRemitBankcardInputUI.this.Ckb = true;
                    BankRemitBankcardInputUI.this.Ckc = text;
                    BankRemitBankcardInputUI.this.Ckd = text2;
                    if (BankRemitBankcardInputUI.this.zhz != null) {
                        BankRemitBankcardInputUI.this.zhz.show();
                    } else {
                        BankRemitBankcardInputUI bankRemitBankcardInputUI = BankRemitBankcardInputUI.this;
                        BankRemitBankcardInputUI bankRemitBankcardInputUI2 = BankRemitBankcardInputUI.this;
                        BankRemitBankcardInputUI.this.getString(R.string.ty);
                        bankRemitBankcardInputUI.zhz = com.tencent.mm.ui.base.h.a((Context) bankRemitBankcardInputUI2, BankRemitBankcardInputUI.this.getString(R.string.inu), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass28.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(67453);
                                Log.i("MicroMsg.BankRemitBankcardInputUI", "coperationTipDialogNoTransparent onCancel()");
                                BankRemitBankcardInputUI.this.Ckb = false;
                                BankRemitBankcardInputUI.this.Cka = false;
                                if (BankRemitBankcardInputUI.this.zhz != null && BankRemitBankcardInputUI.this.zhz.isShowing()) {
                                    BankRemitBankcardInputUI.this.zhz.dismiss();
                                }
                                if (BankRemitBankcardInputUI.D(BankRemitBankcardInputUI.this).getVisibility() == 8 || BankRemitBankcardInputUI.E(BankRemitBankcardInputUI.this).getVisibility() == 4) {
                                    Log.i("MicroMsg.BankRemitBankcardInputUI", "usr cancel, & visibility not visiable, so finish");
                                    BankRemitBankcardInputUI.this.finish();
                                }
                                BankRemitBankcardInputUI.F(BankRemitBankcardInputUI.this);
                                AppMethodBeat.o(67453);
                            }
                        });
                    }
                    if (!BankRemitBankcardInputUI.this.Cka) {
                        BankRemitBankcardInputUI.G(BankRemitBankcardInputUI.this);
                    }
                } else if (BankRemitBankcardInputUI.z(BankRemitBankcardInputUI.this)) {
                    if (BankRemitBankcardInputUI.this.CjS) {
                        Log.i("MicroMsg.BankRemitBankcardInputUI", "from record goto next direct");
                        BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
                        AppMethodBeat.o(67454);
                        return;
                    }
                    BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, text, text2, BankRemitBankcardInputUI.this.CjP.ynT, BankRemitBankcardInputUI.this.CjP.dDj);
                    AppMethodBeat.o(67454);
                    return;
                }
                AppMethodBeat.o(67454);
            }
        });
        this.Cjx.getInfoIv().setVisibility(0);
        this.Cjx.getInfoIv().setClickable(true);
        this.Cjx.getInfoIv().setEnabled(true);
        this.Cjx.getInfoIv().setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass21 */

            public final void onClick(View view) {
                AppMethodBeat.i(67445);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.BankRemitBankcardInputUI", "name iv click");
                if (BankRemitBankcardInputUI.this.CjW || !BankRemitBankcardInputUI.this.CjX) {
                    BankRemitBankcardInputUI.V(BankRemitBankcardInputUI.this);
                } else {
                    Intent intent = new Intent(BankRemitBankcardInputUI.this.getContext(), BankRemitSelectPayeeUI.class);
                    if (BankRemitBankcardInputUI.this.CjE != null) {
                        intent.putParcelableArrayListExtra("key_self_transfer_record_list", BankRemitBankcardInputUI.this.CjE);
                    }
                    if (BankRemitBankcardInputUI.this.CjF != null) {
                        intent.putParcelableArrayListExtra("key_freq_transfer_record_list", BankRemitBankcardInputUI.this.CjF);
                    }
                    BankRemitBankcardInputUI.this.startActivityForResult(intent, 1);
                }
                h.INSTANCE.a(14673, 3);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67445);
            }
        });
        eNh();
        AppMethodBeat.o(67457);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(67458);
        Log.i("MicroMsg.BankRemitBankcardInputUI", "errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " scenetype:" + qVar.getType());
        if (qVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.a) {
            final com.tencent.mm.plugin.remittance.bankcard.a.a aVar = (com.tencent.mm.plugin.remittance.bankcard.a.a) qVar;
            if (!aVar.CiJ.equals(this.CjQ.Cjt)) {
                Log.i("MicroMsg.BankRemitBankcardInputUI", "outdated request: %s, %s", aVar.CiJ, this.CjK);
                AppMethodBeat.o(67458);
                return true;
            }
            aVar.a(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67424);
                    BankRemitBankcardInputUI.this.CjI = aVar.CiI.KKI;
                    BankRemitBankcardInputUI.this.CjP = new BankcardElemParcel(aVar.CiI.KKH);
                    Object[] objArr = new Object[1];
                    objArr[0] = BankRemitBankcardInputUI.this.CjP != null ? BankRemitBankcardInputUI.this.CjP.ynT : "";
                    Log.i("MicroMsg.BankRemitBankcardInputUI", "response bank: %s", objArr);
                    BankRemitBankcardInputUI.H(BankRemitBankcardInputUI.this);
                    BankRemitBankcardInputUI.I(BankRemitBankcardInputUI.this);
                    BankRemitBankcardInputUI.J(BankRemitBankcardInputUI.this);
                    BankRemitBankcardInputUI.K(BankRemitBankcardInputUI.this);
                    BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
                    AppMethodBeat.o(67424);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67423);
                    Log.e("MicroMsg.BankRemitBankcardInputUI", "appoint reponse error: %s, msg: %s", Integer.valueOf(aVar.CiI.dDN), aVar.CiI.qwn);
                    if (!Util.isNullOrNil(aVar.CiI.qwn)) {
                        com.tencent.mm.ui.base.h.a((Context) BankRemitBankcardInputUI.this.getContext(), aVar.CiI.qwn, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass2.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                    }
                    AppMethodBeat.o(67423);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass29 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67455);
                    Log.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", qVar);
                    AppMethodBeat.o(67455);
                }
            });
        } else if (qVar instanceof g) {
            final g gVar = (g) qVar;
            if (gVar == this.CjV) {
                Log.i("MicroMsg.BankRemitBankcardInputUI", "reset pending scene");
                this.CjV = null;
            }
            if (!gVar.md5.equals(this.Cjy.getMD5Value())) {
                Log.i("MicroMsg.BankRemitBankcardInputUI", "outdated card request: %s, %s", gVar.md5, this.Cjy.getMD5Value());
                AppMethodBeat.o(67458);
                return true;
            }
            gVar.a(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass6 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67427);
                    if (gVar.CiO.KKH == null) {
                        Log.w("MicroMsg.BankRemitBankcardInputUI", "bank_elem is null");
                        BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
                        AppMethodBeat.o(67427);
                        return;
                    }
                    BankRemitBankcardInputUI.this.CjP = new BankcardElemParcel(gVar.CiO.KKH);
                    BankRemitBankcardInputUI.H(BankRemitBankcardInputUI.this);
                    BankRemitBankcardInputUI.I(BankRemitBankcardInputUI.this);
                    BankRemitBankcardInputUI.J(BankRemitBankcardInputUI.this);
                    BankRemitBankcardInputUI.K(BankRemitBankcardInputUI.this);
                    BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
                    AppMethodBeat.o(67427);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass5 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67426);
                    Log.e("MicroMsg.BankRemitBankcardInputUI", "bank info reponse error: %s, msg: %s", Integer.valueOf(gVar.CiO.dDN), gVar.CiO.qwn);
                    BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
                    AppMethodBeat.o(67426);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass4 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67425);
                    Log.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", qVar);
                    AppMethodBeat.o(67425);
                }
            });
        } else if (qVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.m) {
            final com.tencent.mm.plugin.remittance.bankcard.a.m mVar = (com.tencent.mm.plugin.remittance.bankcard.a.m) qVar;
            this.CjX = true;
            mVar.a(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass9 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67430);
                    BankRemitBankcardInputUI.this.CjW = false;
                    BankRemitBankcardInputUI.this.CjJ = mVar.CiU.KKG;
                    Log.d("MicroMsg.BankRemitBankcardInputUI", "timing_id: %s", BankRemitBankcardInputUI.this.CjJ);
                    BankRemitBankcardInputUI.this.CjE = TransferRecordParcel.go(mVar.CiU.MMN);
                    BankRemitBankcardInputUI.this.CjF = TransferRecordParcel.go(mVar.CiU.MMM);
                    Log.i("MicroMsg.BankRemitBankcardInputUI", "selfList: %d, freqList: %d", Integer.valueOf(BankRemitBankcardInputUI.this.CjE.size()), Integer.valueOf(BankRemitBankcardInputUI.this.CjF.size()));
                    BankRemitBankcardInputUI.O(BankRemitBankcardInputUI.this);
                    AppMethodBeat.o(67430);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass8 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67429);
                    Log.e("MicroMsg.BankRemitBankcardInputUI", "records response error: %s, %s", Integer.valueOf(mVar.CiU.dDN), mVar.CiU.qwn);
                    if (!Util.isNullOrNil(mVar.CiU.qwn)) {
                        com.tencent.mm.ui.base.h.a((Context) BankRemitBankcardInputUI.this.getContext(), mVar.CiU.qwn, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass8.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                    }
                    BankRemitBankcardInputUI.this.CjW = true;
                    AppMethodBeat.o(67429);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass7 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67428);
                    Log.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", qVar);
                    BankRemitBankcardInputUI.this.CjW = true;
                    AppMethodBeat.o(67428);
                }
            });
        } else if (qVar instanceof d) {
            final d dVar = (d) qVar;
            dVar.a(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass13 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67436);
                    BankRemitBankcardInputUI.this.CjI = dVar.CiL.KKI;
                    BankRemitBankcardInputUI.this.CjM = dVar.CiL.Cjv;
                    BankRemitBankcardInputUI.this.CjK = dVar.CiL.Cjt;
                    BankRemitBankcardInputUI.this.CjL = dVar.CiL.Cju;
                    BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
                    AppMethodBeat.o(67436);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass11 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67432);
                    Log.e("MicroMsg.BankRemitBankcardInputUI", "check response error: %s, %s", Integer.valueOf(dVar.CiL.dDN), dVar.CiL.qwn);
                    if (!Util.isNullOrNil(dVar.CiL.qwn)) {
                        com.tencent.mm.ui.base.h.a((Context) BankRemitBankcardInputUI.this.getContext(), dVar.CiL.qwn, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass11.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                    }
                    AppMethodBeat.o(67432);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass10 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67431);
                    Log.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", qVar);
                    AppMethodBeat.o(67431);
                }
            });
        } else if (qVar instanceof k) {
            final k kVar = (k) qVar;
            kVar.a(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass16 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67439);
                    if (BankRemitBankcardInputUI.this.zhz != null && BankRemitBankcardInputUI.this.zhz.isShowing()) {
                        BankRemitBankcardInputUI.this.zhz.dismiss();
                    }
                    BankRemitBankcardInputUI.this.CjZ = true;
                    BankRemitBankcardInputUI.this.Cka = false;
                    BankRemitBankcardInputUI.this.CjN = kVar.CiS.MBU;
                    BankRemitBankcardInputUI.this.dUb = kVar.CiS.MBV;
                    Log.i("MicroMsg.BankRemitBankcardInputUI", "set uniqueId:%s", BankRemitBankcardInputUI.this.dUb);
                    BankRemitBankcardInputUI.this.CjG = kVar.CiS.MBW;
                    BankRemitBankcardInputUI.this.CjH = kVar.CiS.MBX;
                    Log.d("MicroMsg.BankRemitBankcardInputUI", "set nameLenLimit:%s", Integer.valueOf(BankRemitBankcardInputUI.this.CjG));
                    if (!BankRemitBankcardInputUI.z(BankRemitBankcardInputUI.this)) {
                        BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
                    } else if (BankRemitBankcardInputUI.this.Ckb) {
                        if (BankRemitBankcardInputUI.this.CjS) {
                            Log.i("MicroMsg.BankRemitBankcardInputUI", "NetSceneBankRemitOperation: from record goto next direct");
                            BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
                        } else {
                            BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, BankRemitBankcardInputUI.this.CjP.ynT, BankRemitBankcardInputUI.this.CjP.dDj);
                        }
                        BankRemitBankcardInputUI.this.Ckb = false;
                        AppMethodBeat.o(67439);
                        return;
                    }
                    AppMethodBeat.o(67439);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass15 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67438);
                    Log.e("MicroMsg.BankRemitBankcardInputUI", "operation response error: %s, %s", Integer.valueOf(kVar.CiS.dDN), kVar.CiS.qwn);
                    if (!Util.isNullOrNil(kVar.CiS.qwn)) {
                        com.tencent.mm.ui.base.h.a((Context) BankRemitBankcardInputUI.this.getContext(), kVar.CiS.qwn, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass15.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                    }
                    BankRemitBankcardInputUI.this.finish();
                    AppMethodBeat.o(67438);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass14 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67437);
                    Log.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", qVar);
                    BankRemitBankcardInputUI.this.Cka = false;
                    BankRemitBankcardInputUI.this.Ckb = false;
                    AppMethodBeat.o(67437);
                }
            });
        }
        AppMethodBeat.o(67458);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(67459);
        super.onResume();
        this.Cjx.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass17 */

            public final void run() {
                AppMethodBeat.i(67440);
                BankRemitBankcardInputUI.this.showVKB();
                AppMethodBeat.o(67440);
            }
        }, 500);
        AppMethodBeat.o(67459);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.i_;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(67460);
        super.onDestroy();
        removeSceneEndListener(1348);
        removeSceneEndListener(1542);
        removeSceneEndListener(1378);
        removeSceneEndListener(1349);
        removeSceneEndListener(TAVExporter.VIDEO_EXPORT_HEIGHT);
        AppMethodBeat.o(67460);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(67461);
        super.finish();
        try {
            hideVKB();
            AppMethodBeat.o(67461);
        } catch (Exception e2) {
            Log.e("MicroMsg.BankRemitBankcardInputUI", "%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(67461);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        TransferRecordParcel transferRecordParcel;
        AppMethodBeat.i(67462);
        if (i2 == 1) {
            if (i3 == -1) {
                this.CjR = false;
                this.CjK = intent.getStringExtra("key_bank_card_seqno");
                String str = this.CjK;
                if (this.CjE != null) {
                    Iterator<TransferRecordParcel> it = this.CjE.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        transferRecordParcel = it.next();
                        if (transferRecordParcel.Cjt.equals(str)) {
                            break;
                        }
                    }
                }
                if (this.CjF != null) {
                    Iterator<TransferRecordParcel> it2 = this.CjF.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        transferRecordParcel = it2.next();
                        if (transferRecordParcel.Cjt.equals(str)) {
                            break;
                        }
                    }
                }
                transferRecordParcel = null;
                this.CjQ = transferRecordParcel;
                eNd();
                eNh();
                if (this.CjQ != null) {
                    aE(this.CjQ.Cjt, this.CjJ, this.CjQ.dDj);
                }
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass18 */

                    public final void run() {
                        AppMethodBeat.i(67441);
                        BankRemitBankcardInputUI.this.Cjx.eIi();
                        AppMethodBeat.o(67441);
                    }
                }, 50);
            }
            Log.i("MicroMsg.BankRemitBankcardInputUI", "resultCode: %s", Integer.valueOf(i3));
            if (intent != null) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_delete_seq_no_list");
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_modified_record_list");
                if (stringArrayListExtra != null) {
                    Iterator<String> it3 = stringArrayListExtra.iterator();
                    while (it3.hasNext()) {
                        String next = it3.next();
                        A(next, this.CjE);
                        A(next, this.CjF);
                    }
                }
                if (parcelableArrayListExtra != null) {
                    Iterator it4 = parcelableArrayListExtra.iterator();
                    while (it4.hasNext()) {
                        TransferRecordParcel transferRecordParcel2 = (TransferRecordParcel) it4.next();
                        a(transferRecordParcel2, this.CjE);
                        a(transferRecordParcel2, this.CjF);
                    }
                }
                AppMethodBeat.o(67462);
                return;
            }
        } else if (i2 == 3) {
            if (i3 == -1) {
                int intExtra = intent.getIntExtra("key_enter_time_scene", -1);
                if (this.CjP != null && this.CjP.Cjd != null) {
                    Iterator<EnterTimeParcel> it5 = this.CjP.Cjd.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        EnterTimeParcel next2 = it5.next();
                        if (next2.Cjg == intExtra) {
                            this.CjO = next2;
                            break;
                        }
                    }
                }
                Log.w("MicroMsg.BankRemitBankcardInputUI", "can't find the right enter scene: %d", Integer.valueOf(intExtra));
                eNf();
                eNh();
                AppMethodBeat.o(67462);
                return;
            }
        } else if (i2 != 2) {
            super.onActivityResult(i2, i3, intent);
        } else if (i3 == -1) {
            this.CjP = (BankcardElemParcel) intent.getParcelableExtra("key_bank_card_elem_parcel");
            eNe();
            eNi();
            eNf();
            eNg();
            eNh();
            AppMethodBeat.o(67462);
            return;
        }
        AppMethodBeat.o(67462);
    }

    private static void a(TransferRecordParcel transferRecordParcel, List<TransferRecordParcel> list) {
        AppMethodBeat.i(67463);
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                TransferRecordParcel transferRecordParcel2 = list.get(size);
                if (transferRecordParcel2.Cjt.equals(transferRecordParcel.Cjt)) {
                    transferRecordParcel2.Cjw = transferRecordParcel.Cjw;
                    AppMethodBeat.o(67463);
                    return;
                }
            }
        }
        AppMethodBeat.o(67463);
    }

    private static void A(String str, List<TransferRecordParcel> list) {
        AppMethodBeat.i(67464);
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                TransferRecordParcel transferRecordParcel = list.get(size);
                if (transferRecordParcel.Cjt.equals(str)) {
                    list.remove(transferRecordParcel);
                    AppMethodBeat.o(67464);
                    return;
                }
            }
        }
        AppMethodBeat.o(67464);
    }

    private void aE(String str, String str2, String str3) {
        AppMethodBeat.i(67465);
        Log.i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by seq: %s", str);
        doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.a(str, str2, str3), false);
        AppMethodBeat.o(67465);
    }

    private void tI(boolean z) {
        AppMethodBeat.i(67466);
        Log.i("MicroMsg.BankRemitBankcardInputUI", "do fetch transfer record: %s", Boolean.valueOf(z));
        if (z) {
            doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.m(), true);
            AppMethodBeat.o(67466);
            return;
        }
        doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.m(), false);
        AppMethodBeat.o(67466);
    }

    private void z(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(67467);
        Log.i("MicroMsg.BankRemitBankcardInputUI", "do check bank bind: %s %s", str3, str4);
        Log.d("MicroMsg.BankRemitBankcardInputUI", "payeeName: %s, bankCardNo: %s", str, str2);
        doSceneProgress(new d(str, str2, str3, str4));
        AppMethodBeat.o(67467);
    }

    private void eNa() {
        AppMethodBeat.i(67468);
        Log.i("MicroMsg.BankRemitBankcardInputUI", "do operation");
        this.Cka = true;
        doSceneProgress(new k(), false);
        AppMethodBeat.o(67468);
    }

    private void eNb() {
        AppMethodBeat.i(67469);
        this.Cjy.eIi();
        this.Cjy.setContentEnabled(false);
        this.CjT = true;
        AppMethodBeat.o(67469);
    }

    private void eNc() {
        AppMethodBeat.i(67470);
        this.Cjz.setClickable(false);
        this.CjU = true;
        AppMethodBeat.o(67470);
    }

    private void eNd() {
        AppMethodBeat.i(67471);
        if (this.CjQ != null) {
            this.Cjx.setText(this.CjQ.Cjv);
            this.CjS = true;
            this.Cjy.setText(getString(R.string.ab0, new Object[]{this.CjQ.Cju}));
            this.Cjz.setText(this.CjQ.ynT);
            this.Cjq.setUrl(this.CjQ.CiX);
            eNb();
            eNc();
        }
        AppMethodBeat.o(67471);
    }

    private void eNe() {
        AppMethodBeat.i(67472);
        if (this.CjP != null) {
            this.Cjz.setText(this.CjP.ynT);
            this.Cjq.setUrl(this.CjP.CiX);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Cjq.getLayoutParams();
            layoutParams.setMargins(a.fromDPToPix((Context) getContext(), 15), 0, 0, 0);
            this.Cjq.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(67472);
    }

    private void eNf() {
        AppMethodBeat.i(67473);
        if (this.CjO != null) {
            if (!Util.isNullOrNil(this.CjO.ixw)) {
                this.CjA.setContentTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(this.CjO.ixw, true));
            } else {
                this.CjA.setContentTextColorRes(R.color.a2x);
            }
            this.CjA.setText(this.CjO.Cjh);
            this.CjA.setVisibility(0);
            AppMethodBeat.o(67473);
        } else if (this.CjP == null || Util.isNullOrNil(this.CjP.Cja)) {
            this.CjA.setVisibility(8);
            AppMethodBeat.o(67473);
        } else {
            this.CjA.setText(this.CjP.Cja);
            if (!Util.isNullOrNil(this.CjP.Cjb)) {
                this.CjA.setContentTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(this.CjP.Cjb, true));
            } else {
                this.CjA.setContentTextColorRes(R.color.a2x);
            }
            this.CjA.setVisibility(0);
            AppMethodBeat.o(67473);
        }
    }

    private void eNg() {
        AppMethodBeat.i(67474);
        if (this.CjA.getVisibility() == 0) {
            this.Cjz.setBackground(getResources().getDrawable(R.drawable.b3g));
            AppMethodBeat.o(67474);
            return;
        }
        this.Cjz.setBackground(getResources().getDrawable(R.drawable.f6));
        AppMethodBeat.o(67474);
    }

    private void eNh() {
        AppMethodBeat.i(67475);
        if (Util.isNullOrNil(this.Cjx.getText()) || this.Cjx.getText().trim().isEmpty() || Util.isNullOrNil(this.Cjy.getText()) || !this.Cjx.bql() || this.Cjy.getText().trim().isEmpty() || !this.Cjy.bql() || Util.isNullOrNil(this.Cjz.getText()) || this.CjA.getVisibility() != 0 || Util.isNullOrNil(this.CjA.getText()) || this.CjP == null || !Util.isNullOrNil(this.CjP.Cjc)) {
            this.krs.setEnabled(false);
            AppMethodBeat.o(67475);
            return;
        }
        this.krs.setEnabled(true);
        AppMethodBeat.o(67475);
    }

    private void eNi() {
        AppMethodBeat.i(67476);
        if (this.CjP == null || Util.isNullOrNil(this.CjP.Cja)) {
            if (!(this.CjP == null || this.CjP.Cjd == null)) {
                Iterator<EnterTimeParcel> it = this.CjP.Cjd.iterator();
                while (it.hasNext()) {
                    EnterTimeParcel next = it.next();
                    if (next.Cjj > 0) {
                        this.CjO = next;
                        AppMethodBeat.o(67476);
                        return;
                    }
                }
            }
            AppMethodBeat.o(67476);
            return;
        }
        this.CjO = null;
        AppMethodBeat.o(67476);
    }

    static /* synthetic */ void c(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67477);
        bankRemitBankcardInputUI.Cjy.setContentEnabled(true);
        bankRemitBankcardInputUI.CjT = false;
        AppMethodBeat.o(67477);
    }

    static /* synthetic */ void d(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67478);
        bankRemitBankcardInputUI.Cjz.setClickable(true);
        bankRemitBankcardInputUI.CjU = false;
        AppMethodBeat.o(67478);
    }

    static /* synthetic */ void j(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67479);
        bankRemitBankcardInputUI.Cjy.eIj();
        bankRemitBankcardInputUI.Cjz.eIj();
        bankRemitBankcardInputUI.Cjq.setImageBitmap(null);
        bankRemitBankcardInputUI.CjA.eIj();
        bankRemitBankcardInputUI.CjA.setVisibility(8);
        bankRemitBankcardInputUI.eNg();
        bankRemitBankcardInputUI.CjK = "";
        bankRemitBankcardInputUI.CjL = "";
        bankRemitBankcardInputUI.CjI = "";
        bankRemitBankcardInputUI.CjP = null;
        bankRemitBankcardInputUI.CjO = null;
        AppMethodBeat.o(67479);
    }

    static /* synthetic */ void a(BankRemitBankcardInputUI bankRemitBankcardInputUI, String str, String str2) {
        AppMethodBeat.i(67481);
        Log.i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by cardNo");
        if (bankRemitBankcardInputUI.CjV != null) {
            Log.i("MicroMsg.BankRemitBankcardInputUI", "cancel pre scene");
            bankRemitBankcardInputUI.cancelNetScene(bankRemitBankcardInputUI.CjV);
        }
        bankRemitBankcardInputUI.CjY = false;
        g gVar = new g(str, str2);
        bankRemitBankcardInputUI.CjV = gVar;
        bankRemitBankcardInputUI.doSceneProgress(gVar, true);
        AppMethodBeat.o(67481);
    }

    static /* synthetic */ void t(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67482);
        bankRemitBankcardInputUI.startActivityForResult(new Intent(bankRemitBankcardInputUI.getContext(), BankRemitSelectBankUI.class), 2);
        AppMethodBeat.o(67482);
    }

    static /* synthetic */ boolean u(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67483);
        if (bankRemitBankcardInputUI.CjP == null) {
            AppMethodBeat.o(67483);
            return false;
        } else if (!Util.isNullOrNil(bankRemitBankcardInputUI.CjP.Cjc)) {
            Log.i("MicroMsg.BankRemitBankcardInputUI", "show alert text: %s", bankRemitBankcardInputUI.CjP.Cjc);
            com.tencent.mm.ui.base.h.a((Context) bankRemitBankcardInputUI, bankRemitBankcardInputUI.CjP.Cjc, "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass22 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(67483);
            return true;
        } else {
            AppMethodBeat.o(67483);
            return false;
        }
    }

    static /* synthetic */ boolean z(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67484);
        if (bankRemitBankcardInputUI.CjG <= 0 || bankRemitBankcardInputUI.CjG >= bankRemitBankcardInputUI.Cjx.getInputLength()) {
            AppMethodBeat.o(67484);
            return true;
        }
        Toast.makeText(bankRemitBankcardInputUI, bankRemitBankcardInputUI.getString(R.string.abv, new Object[]{new StringBuilder().append(bankRemitBankcardInputUI.CjG).toString()}), 1).show();
        AppMethodBeat.o(67484);
        return false;
    }

    static /* synthetic */ void A(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67485);
        Intent intent = new Intent(bankRemitBankcardInputUI.getContext(), BankRemitMoneyInputUI.class);
        if (bankRemitBankcardInputUI.CjS) {
            intent.putExtra("key_bank_card_seqno", bankRemitBankcardInputUI.CjQ.Cjt);
            intent.putExtra("key_bank_card_tailno", bankRemitBankcardInputUI.CjQ.Cju);
            intent.putExtra("key_payee_name", bankRemitBankcardInputUI.CjQ.Cjv);
            intent.putExtra("key_input_type", 1);
        } else {
            intent.putExtra("key_bank_card_seqno", bankRemitBankcardInputUI.CjK);
            intent.putExtra("key_bank_card_tailno", bankRemitBankcardInputUI.CjL);
            intent.putExtra("key_payee_name", bankRemitBankcardInputUI.CjM);
            if (Util.isNullOrNil(bankRemitBankcardInputUI.content)) {
                intent.putExtra("key_input_type", 0);
            } else {
                intent.putExtra("key_input_type", 3);
            }
        }
        intent.putExtra("key_unique_id", Util.nullAsNil(bankRemitBankcardInputUI.dUb));
        intent.putExtra("key_enter_time_scene", bankRemitBankcardInputUI.CjO.Cjg);
        intent.putExtra("key_encrypt_data", bankRemitBankcardInputUI.CjI);
        intent.putExtra("key_bank_card_elem_parcel", bankRemitBankcardInputUI.CjP);
        intent.putExtra("key_reason_len", bankRemitBankcardInputUI.CjH);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(bankRemitBankcardInputUI, bl.axQ(), "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI", "gotoMoneyInputUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        bankRemitBankcardInputUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(bankRemitBankcardInputUI, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI", "gotoMoneyInputUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(67485);
    }

    static /* synthetic */ void O(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(67495);
        Log.d("MicroMsg.BankRemitBankcardInputUI", "init popup window");
        bankRemitBankcardInputUI.CjB = new ListPopupWindow(bankRemitBankcardInputUI);
        bankRemitBankcardInputUI.CjB.akZ = a.jn(bankRemitBankcardInputUI) - a.fromDPToPix((Context) bankRemitBankcardInputUI, 30);
        bankRemitBankcardInputUI.CjB.setHeight(a.fromDPToPix((Context) bankRemitBankcardInputUI, (int) com.tencent.mm.plugin.appbrand.jsapi.k.r.CTRL_INDEX));
        bankRemitBankcardInputUI.CjB.setBackgroundDrawable(new ColorDrawable(0));
        bankRemitBankcardInputUI.CjB.setVerticalOffset(1);
        bankRemitBankcardInputUI.CjB.setAnimationStyle(R.style.hy);
        bankRemitBankcardInputUI.CjB.arp = bankRemitBankcardInputUI.Cjx;
        bankRemitBankcardInputUI.CjB.setModal(false);
        bankRemitBankcardInputUI.CjB.ars = new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass19 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(67443);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$26", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Log.i("MicroMsg.BankRemitBankcardInputUI", "popup window click: %d", Integer.valueOf(i2));
                BankRemitBankcardInputUI.this.CjR = false;
                BankRemitBankcardInputUI.this.CjQ = (TransferRecordParcel) adapterView.getAdapter().getItem(i2);
                BankRemitBankcardInputUI.R(BankRemitBankcardInputUI.this);
                BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, BankRemitBankcardInputUI.this.CjQ.Cjt, BankRemitBankcardInputUI.this.CjJ, BankRemitBankcardInputUI.this.CjQ.dDj);
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass19.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(67442);
                        BankRemitBankcardInputUI.this.Cjx.eIi();
                        AppMethodBeat.o(67442);
                    }
                }, 500);
                BankRemitBankcardInputUI.this.CjB.dismiss();
                BankRemitBankcardInputUI.this.hideVKB();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitBankcardInputUI$26", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(67443);
            }
        };
        bankRemitBankcardInputUI.CjD = new Filter.FilterListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.AnonymousClass20 */

            public final void onFilterComplete(int i2) {
                AppMethodBeat.i(67444);
                Log.i("MicroMsg.BankRemitBankcardInputUI", "filter complete: %d", Integer.valueOf(i2));
                if (BankRemitBankcardInputUI.this.CjB != null) {
                    if (i2 > 0) {
                        if (i2 == 1) {
                            BankRemitBankcardInputUI.this.CjB.setHeight(a.fromDPToPix((Context) BankRemitBankcardInputUI.this.getContext(), 68));
                        } else {
                            BankRemitBankcardInputUI.this.CjB.setHeight(a.fromDPToPix((Context) BankRemitBankcardInputUI.this.getContext(), (int) com.tencent.mm.plugin.appbrand.jsapi.k.r.CTRL_INDEX));
                        }
                        BankRemitBankcardInputUI.this.CjB.show();
                        AppMethodBeat.o(67444);
                        return;
                    } else if (i2 <= 0 && BankRemitBankcardInputUI.this.CjB.arA.isShowing()) {
                        BankRemitBankcardInputUI.this.CjB.dismiss();
                    }
                }
                AppMethodBeat.o(67444);
            }
        };
        ArrayList arrayList = new ArrayList();
        if (bankRemitBankcardInputUI.CjE != null) {
            arrayList.addAll(bankRemitBankcardInputUI.CjE);
        }
        if (bankRemitBankcardInputUI.CjF != null) {
            arrayList.addAll(bankRemitBankcardInputUI.CjF);
        }
        bankRemitBankcardInputUI.CjC = new c(bankRemitBankcardInputUI, arrayList);
        bankRemitBankcardInputUI.CjB.setAdapter(bankRemitBankcardInputUI.CjC);
        AppMethodBeat.o(67495);
    }

    static /* synthetic */ void b(BankRemitBankcardInputUI bankRemitBankcardInputUI, String str, String str2) {
        AppMethodBeat.i(67496);
        Log.i("MicroMsg.BankRemitBankcardInputUI", "doCheckBankBind()");
        bankRemitBankcardInputUI.z(bankRemitBankcardInputUI.Ckc, bankRemitBankcardInputUI.Ckd, str, str2);
        AppMethodBeat.o(67496);
    }
}
