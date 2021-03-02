package com.tencent.mm.plugin.wallet_core.id_verify;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.id_verify.model.g;
import com.tencent.mm.plugin.wallet_core.id_verify.model.l;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.ebx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;
import com.tenpay.android.wechat.TenpaySecureEncrypt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@a(3)
public class WcPayRealnameVerifyIdInputUI extends WalletBaseUI {
    private static final int HSh = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 88);
    private WalletFormView Cjx;
    private WalletFormView HRu;
    private WalletFormView HRv;
    private String[] HSA;
    private List<djv> HSB = new ArrayList();
    private ebx HSC;
    private String[] HSD = new String[100];
    private int HSE;
    private int HSF;
    private int HSG;
    private int HSH;
    private int HSI;
    private int HSJ;
    private int HSK;
    private int HSL;
    private int HSM;
    private String HSN;
    private TenpaySecureEncrypt HSO;
    private WalletFormView HSi;
    private WalletFormView HSj;
    private WalletFormView HSk;
    private WalletFormView HSl;
    private WalletFormView HSm;
    private WalletFormView HSn;
    private WalletFormView HSo;
    private WalletFormView HSp;
    private WalletFormView HSq;
    private c HSr;
    private TextView HSs;
    private b HSt;
    private String HSu;
    private String HSv;
    private boolean HSw;
    private VM HSx;
    private String HSy;
    private String HSz;
    private Button krs;
    private TextView mPa;
    private Profession[] mProfessions;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WcPayRealnameVerifyIdInputUI() {
        AppMethodBeat.i(70104);
        for (int i2 = 0; i2 < this.HSD.length; i2++) {
            this.HSD[i2] = MMApplicationContext.getContext().getString(R.string.ibj, Integer.valueOf(i2));
        }
        this.HSE = 0;
        this.HSF = 0;
        this.HSG = 0;
        this.HSH = 0;
        this.HSI = 0;
        this.HSJ = 0;
        this.HSK = 0;
        this.HSL = 0;
        this.HSM = 0;
        this.HSN = "";
        this.HSO = new TenpaySecureEncrypt();
        AppMethodBeat.o(70104);
    }

    static /* synthetic */ void a(WcPayRealnameVerifyIdInputUI wcPayRealnameVerifyIdInputUI, g gVar) {
        AppMethodBeat.i(214193);
        wcPayRealnameVerifyIdInputUI.a(gVar);
        AppMethodBeat.o(214193);
    }

    static {
        AppMethodBeat.i(70117);
        AppMethodBeat.o(70117);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70105);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.f3048f));
        hideActionbarLine();
        setMMTitle("");
        this.mNetSceneMgr.addSceneEndListener(1616);
        this.HSx = (VM) ViewModelProviders.of(this).get(VM.class);
        String string = getInput().getString("realname_verify_process_get_wording_cache");
        try {
            if (!Util.isNullOrNil(string)) {
                btr btr = (btr) new btr().parseFrom(string.getBytes(org.apache.commons.a.a.ISO_8859_1));
                this.HSB.addAll(btr.MaA);
                this.HSu = btr.HSu;
                this.HSv = btr.HSv;
                this.HSC = btr.MaC;
            }
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.WcPayRealnameVerifyIdInputUI", e2, "", new Object[0]);
        }
        initView();
        Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "do get user ext info");
        doSceneForceProgress(new l());
        AppMethodBeat.o(70105);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(70106);
        this.Cjx = (WalletFormView) findViewById(R.id.jql);
        this.HSq = (WalletFormView) findViewById(R.id.jqp);
        this.HSi = (WalletFormView) findViewById(R.id.jqj);
        this.HSj = (WalletFormView) findViewById(R.id.jqi);
        this.HSk = (WalletFormView) findViewById(R.id.jqh);
        this.HSl = (WalletFormView) findViewById(R.id.jqg);
        this.HSm = (WalletFormView) findViewById(R.id.jqf);
        this.HSn = (WalletFormView) findViewById(R.id.jqm);
        this.HSo = (WalletFormView) findViewById(R.id.jqe);
        this.HRu = (WalletFormView) findViewById(R.id.jqo);
        this.HRv = (WalletFormView) findViewById(R.id.jqd);
        this.HSp = (WalletFormView) findViewById(R.id.jqk);
        this.krs = (Button) findViewById(R.id.jqn);
        this.mPa = (TextView) findViewById(R.id.jqr);
        this.HSs = (TextView) findViewById(R.id.jqq);
        if (!Util.isNullOrNil(this.HSu)) {
            this.mPa.setText(this.HSu);
        }
        if (!Util.isNullOrNil(this.HSv)) {
            this.HSs.setText(this.HSv);
            this.HSs.setVisibility(0);
        }
        this.Cjx.setFilterChar("\\x20\\t\\r\\n".toCharArray());
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.hs);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.bt);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = dimensionPixelSize2;
        if (this.HSC == null || Util.isNullOrNil(this.HSC.Nbx)) {
            this.Cjx.getInfoIv().setLayoutParams(layoutParams);
            this.Cjx.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.Cjx.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(R.color.FG_2));
            this.Cjx.a(new TextWatcher() {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass12 */

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(214179);
                    WcPayRealnameVerifyIdInputUI.this.HSx.aVd(WcPayRealnameVerifyIdInputUI.this.Cjx.getText());
                    AppMethodBeat.o(214179);
                }
            });
        } else {
            this.Cjx.setText(this.HSC.Nbx);
            this.HSx.aVd(this.HSC.Nbx);
            this.Cjx.setContentTextColor(getResources().getColor(R.color.FG_2));
            this.Cjx.setInputEnable(false);
            this.Cjx.getInfoIv().setImageResource(R.raw.icons_outlined_info);
            this.Cjx.getInfoIv().setmUserSetImageIconColor(getResources().getColor(R.color.FG_2));
            this.Cjx.getInfoIv().setVisibility(0);
            this.Cjx.getInfoIv().setClickable(true);
            this.Cjx.setOnInfoIvClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(214175);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "on click listener");
                    final com.tencent.mm.ui.widget.a.g gVar = new com.tencent.mm.ui.widget.a.g(WcPayRealnameVerifyIdInputUI.this.getContext(), 1, 2);
                    gVar.aE(WcPayRealnameVerifyIdInputUI.this.HSC.Nby);
                    gVar.b(WcPayRealnameVerifyIdInputUI.this.HSC.NbA, WcPayRealnameVerifyIdInputUI.this.HSC.NbC);
                    gVar.a(new g.a() {
                        /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.widget.a.g.a
                        public final void onClick() {
                            AppMethodBeat.i(214173);
                            f.bn(WcPayRealnameVerifyIdInputUI.this.getContext(), WcPayRealnameVerifyIdInputUI.this.HSC.NbB);
                            gVar.bMo();
                            AppMethodBeat.o(214173);
                        }
                    }, new g.a() {
                        /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass1.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.widget.a.g.a
                        public final void onClick() {
                            AppMethodBeat.i(214174);
                            gVar.bMo();
                            AppMethodBeat.o(214174);
                        }
                    });
                    View inflate = LayoutInflater.from(WcPayRealnameVerifyIdInputUI.this.getContext()).inflate(R.layout.cb6, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.jr5)).setText(WcPayRealnameVerifyIdInputUI.this.HSC.Nbz);
                    gVar.setCustomView(inflate);
                    gVar.dGm();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(214175);
                }
            });
        }
        this.HSi.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass22 */

            public final void onClick(View view) {
                AppMethodBeat.i(214182);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "click cre type");
                WcPayRealnameVerifyIdInputUI.this.HSx.HTd.setValue(Boolean.TRUE);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(214182);
            }
        });
        this.HSi.getInfoIv().setClickable(false);
        this.HSi.getContentEt().setInputType(131073);
        this.HSj.getInfoIv().setLayoutParams(layoutParams);
        this.HSj.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.HSj.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(R.color.FG_2));
        com.tencent.mm.wallet_core.ui.formview.a.d(this.HSj);
        this.HSj.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass23 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(214183);
                WcPayRealnameVerifyIdInputUI.this.HSy = editable.toString();
                WcPayRealnameVerifyIdInputUI.this.HSz = WcPayRealnameVerifyIdInputUI.this.HSj.getText();
                VM vm = WcPayRealnameVerifyIdInputUI.this.HSx;
                vm.HTc.setValue(WcPayRealnameVerifyIdInputUI.this.HSz);
                AppMethodBeat.o(214183);
            }
        });
        this.HSq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass24 */

            public final void onClick(View view) {
                AppMethodBeat.i(70094);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                final c cVar = new c(WcPayRealnameVerifyIdInputUI.this.getContext(), WcPayRealnameVerifyIdInputUI.this.getResources().getStringArray(R.array.b1));
                cVar.QTc = new c.b() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass24.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.picker.c.b
                    public final void onResult(boolean z, Object obj, Object obj2) {
                        AppMethodBeat.i(70093);
                        if (z) {
                            WcPayRealnameVerifyIdInputUI.this.HSx.HTa.setValue((String) obj);
                        }
                        cVar.hide();
                        AppMethodBeat.o(70093);
                    }
                };
                cVar.show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70094);
            }
        });
        this.HSk.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass25 */

            public final void onClick(View view) {
                AppMethodBeat.i(70096);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                final b bVar2 = new b(WcPayRealnameVerifyIdInputUI.this.getContext());
                Calendar instance = Calendar.getInstance();
                int i2 = instance.get(1);
                int i3 = instance.get(2) + 1;
                int i4 = instance.get(5);
                bVar2.aZ(i2, i3, i4);
                bVar2.aY(1900, 1, 1);
                bVar2.QSU = new b.a() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass25.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.picker.b.a
                    public final void onResult(boolean z, int i2, int i3, int i4) {
                        AppMethodBeat.i(70095);
                        if (z) {
                            Log.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "year: %s, month: %s, day: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                            String format = String.format("%04d/%02d/%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                            WcPayRealnameVerifyIdInputUI.this.HSE = i2;
                            WcPayRealnameVerifyIdInputUI.this.HSF = i3;
                            WcPayRealnameVerifyIdInputUI.this.HSG = i4;
                            WcPayRealnameVerifyIdInputUI.this.HSx.HTl.setValue(format);
                        }
                        bVar2.hide();
                        AppMethodBeat.o(70095);
                    }
                };
                String value = WcPayRealnameVerifyIdInputUI.this.HSx.HTl.getValue();
                if (Util.isNullOrNil(value) || value.length() < 10) {
                    bVar2.aX(i2, i3, i4);
                } else {
                    int i5 = Util.getInt(value.substring(0, 4), 0);
                    int i6 = Util.getInt(value.substring(5, 7), 0);
                    int i7 = Util.getInt(value.substring(9, 10), 0);
                    if (i5 > 0 && i6 > 0 && i7 > 0) {
                        bVar2.aX(i5, i6, i7);
                    }
                }
                bVar2.show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70096);
            }
        });
        this.HSk.getInfoIv().setClickable(false);
        this.HSl.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass26 */

            public final void onClick(View view) {
                AppMethodBeat.i(70097);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WcPayRealnameVerifyIdInputUI.this.HSt = new b(WcPayRealnameVerifyIdInputUI.this.getContext());
                Calendar instance = Calendar.getInstance();
                int i2 = instance.get(1);
                int i3 = instance.get(2) + 1;
                int i4 = instance.get(5);
                WcPayRealnameVerifyIdInputUI.this.HSt.aX(i2, i3, i4);
                WcPayRealnameVerifyIdInputUI.this.HSt.aY(i2, i3, i4);
                WcPayRealnameVerifyIdInputUI.this.HSt.aZ(i2 + 200, 12, 31);
                WcPayRealnameVerifyIdInputUI.this.HSt.setLongTermYear(true);
                WcPayRealnameVerifyIdInputUI.this.HSt.QSU = new b.a() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass26.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.picker.b.a
                    public final void onResult(boolean z, int i2, int i3, int i4) {
                        AppMethodBeat.i(214184);
                        if (z) {
                            Log.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "year: %s, month: %s, day: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                            if (i2 == 1) {
                                String format = String.format("%04d/%02d/%02d", 9999, 12, 31);
                                WcPayRealnameVerifyIdInputUI.this.HSH = 9999;
                                WcPayRealnameVerifyIdInputUI.this.HSI = 12;
                                WcPayRealnameVerifyIdInputUI.this.HSJ = 31;
                                WcPayRealnameVerifyIdInputUI.this.HSx.aVe(format);
                            } else {
                                String format2 = String.format("%04d/%02d/%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                                WcPayRealnameVerifyIdInputUI.this.HSH = i2;
                                WcPayRealnameVerifyIdInputUI.this.HSI = i3;
                                WcPayRealnameVerifyIdInputUI.this.HSJ = i4;
                                WcPayRealnameVerifyIdInputUI.this.HSx.aVe(format2);
                            }
                        }
                        WcPayRealnameVerifyIdInputUI.this.HSt.hide();
                        AppMethodBeat.o(214184);
                    }
                };
                String value = WcPayRealnameVerifyIdInputUI.this.HSx.HTm.getValue();
                if (!Util.isNullOrNil(value) && value.length() >= 8) {
                    int i5 = Util.getInt(value.substring(0, 4), 0);
                    int i6 = Util.getInt(value.substring(5, 7), 0);
                    int i7 = Util.getInt(value.substring(8, 10), 0);
                    if (i5 > 0 && i6 > 0 && i7 > 0) {
                        if (i5 == 9999) {
                            WcPayRealnameVerifyIdInputUI.this.HSt.aX(1, 1, 1);
                        } else {
                            WcPayRealnameVerifyIdInputUI.this.HSt.aX(i5, i6, i7);
                        }
                    }
                }
                WcPayRealnameVerifyIdInputUI.this.HSt.show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70097);
            }
        });
        this.HSl.getInfoIv().setClickable(false);
        this.HSp.setInputType(3);
        this.HSp.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass27 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(214185);
                VM vm = WcPayRealnameVerifyIdInputUI.this.HSx;
                vm.HTr.setValue(WcPayRealnameVerifyIdInputUI.this.HSp.getText());
                AppMethodBeat.o(214185);
            }
        });
        this.HSm.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass28 */

            public final void onClick(View view) {
                AppMethodBeat.i(70099);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                final c cVar = new c(WcPayRealnameVerifyIdInputUI.this.getContext(), WcPayRealnameVerifyIdInputUI.this.HSD);
                cVar.QTc = new c.b() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass28.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.picker.c.b
                    public final void onResult(boolean z, Object obj, Object obj2) {
                        AppMethodBeat.i(214186);
                        if (z) {
                            WcPayRealnameVerifyIdInputUI.this.HSx.HTn.setValue(Integer.valueOf(cVar.hci()));
                        }
                        cVar.hide();
                        AppMethodBeat.o(214186);
                    }
                };
                if (WcPayRealnameVerifyIdInputUI.this.HSx.HTn.getValue() != null) {
                    cVar.app(WcPayRealnameVerifyIdInputUI.this.HSx.HTn.getValue().intValue());
                }
                cVar.show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70099);
            }
        });
        this.HSm.getInfoIv().setClickable(false);
        this.HSo.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(70076);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                final b bVar2 = new b(WcPayRealnameVerifyIdInputUI.this.getContext());
                Calendar instance = Calendar.getInstance();
                int i2 = instance.get(1);
                int i3 = instance.get(2) + 1;
                int i4 = instance.get(5);
                bVar2.aX(i2, i3, i4);
                int i5 = i2 - 200;
                if (i5 <= 0) {
                    i5 = 1;
                }
                bVar2.aY(i5, 1, 1);
                bVar2.aZ(i2, i3, i4);
                bVar2.QSU = new b.a() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.picker.b.a
                    public final void onResult(boolean z, int i2, int i3, int i4) {
                        AppMethodBeat.i(214176);
                        if (z) {
                            String format = String.format("%04d/%02d/%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                            WcPayRealnameVerifyIdInputUI.this.HSK = i2;
                            WcPayRealnameVerifyIdInputUI.this.HSL = i3;
                            WcPayRealnameVerifyIdInputUI.this.HSM = i4;
                            WcPayRealnameVerifyIdInputUI.this.HSx.HTo.setValue(format);
                        }
                        bVar2.hide();
                        AppMethodBeat.o(214176);
                    }
                };
                String value = WcPayRealnameVerifyIdInputUI.this.HSx.HTo.getValue();
                if (!Util.isNullOrNil(value) && value.length() >= 10) {
                    int i6 = Util.getInt(value.substring(0, 4), 0);
                    int i7 = Util.getInt(value.substring(5, 7), 0);
                    int i8 = Util.getInt(value.substring(9, 10), 0);
                    if (i6 > 0 && i7 > 0 && i8 > 0) {
                        bVar2.aX(i6, i7, i8);
                    }
                }
                bVar2.show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70076);
            }
        });
        this.HSo.getInfoIv().setClickable(false);
        this.HSn.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(174477);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.setClassName(WcPayRealnameVerifyIdInputUI.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
                if (WcPayRealnameVerifyIdInputUI.this.HSA != null) {
                    intent.putExtra("exclude_countries_iso", WcPayRealnameVerifyIdInputUI.this.HSA);
                }
                intent.putExtra("CountryCodeUI_isShowCountryCode", false);
                intent.putExtra("ui_title", WcPayRealnameVerifyIdInputUI.this.getString(R.string.isb));
                WcPayRealnameVerifyIdInputUI.this.startActivityForResult(intent, 3);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(174477);
            }
        });
        this.HSn.getInfoIv().setClickable(false);
        this.HRu.getContentEt().setInputType(131073);
        this.HRu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(174478);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
                WcPayRealnameVerifyIdInputUI.j(WcPayRealnameVerifyIdInputUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(174478);
            }
        });
        this.HRu.getInfoIv().setClickable(false);
        this.HRv.getContentEt().setInputType(131073);
        this.HRv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(174479);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
                if (WcPayRealnameVerifyIdInputUI.this.HSw) {
                    WcPayRealnameVerifyIdInputUI.l(WcPayRealnameVerifyIdInputUI.this);
                } else {
                    WcPayRealnameVerifyIdInputUI.m(WcPayRealnameVerifyIdInputUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(174479);
            }
        });
        this.HRv.getInfoIv().setClickable(false);
        this.krs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(214177);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
                WcPayRealnameVerifyIdInputUI.n(WcPayRealnameVerifyIdInputUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyIdInputUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(214177);
            }
        });
        this.Cjx.hic();
        this.HSx.HTd.observe(this, new Observer<Boolean>() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass7 */
            int jKz = 0;

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.lifecycle.Observer
            public final /* synthetic */ void onChanged(Boolean bool) {
                AppMethodBeat.i(70082);
                Boolean bool2 = bool;
                WcPayRealnameVerifyIdInputUI.this.hideTenpayKB();
                if (bool2 == null || !bool2.booleanValue()) {
                    if (WcPayRealnameVerifyIdInputUI.this.HSr != null) {
                        WcPayRealnameVerifyIdInputUI.this.HSr.hide();
                    }
                } else if (WcPayRealnameVerifyIdInputUI.this.HSB.size() > 0) {
                    String[] strArr = new String[WcPayRealnameVerifyIdInputUI.this.HSB.size()];
                    WcPayRealnameVerifyIdInputUI.this.getResources().getIntArray(R.array.az);
                    for (int i2 = 0; i2 < WcPayRealnameVerifyIdInputUI.this.HSB.size(); i2++) {
                        strArr[i2] = ((djv) WcPayRealnameVerifyIdInputUI.this.HSB.get(i2)).MNM.iFF;
                    }
                    WcPayRealnameVerifyIdInputUI.this.HSr = new c(WcPayRealnameVerifyIdInputUI.this.getContext(), strArr);
                    WcPayRealnameVerifyIdInputUI.this.HSr.QTc = new c.b() {
                        /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass7.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.widget.picker.c.b
                        public final void onResult(boolean z, Object obj, Object obj2) {
                            AppMethodBeat.i(214178);
                            WcPayRealnameVerifyIdInputUI.this.HSr.hide();
                            if (z && WcPayRealnameVerifyIdInputUI.this.HSr.hci() < WcPayRealnameVerifyIdInputUI.this.HSB.size()) {
                                WcPayRealnameVerifyIdInputUI.this.HSx.a((djv) WcPayRealnameVerifyIdInputUI.this.HSB.get(WcPayRealnameVerifyIdInputUI.this.HSr.hci()));
                                AnonymousClass7.this.jKz = WcPayRealnameVerifyIdInputUI.this.HSr.hci();
                            }
                            AppMethodBeat.o(214178);
                        }
                    };
                    WcPayRealnameVerifyIdInputUI.this.HSr.app(this.jKz);
                    WcPayRealnameVerifyIdInputUI.this.HSr.show();
                    AppMethodBeat.o(70082);
                    return;
                }
                AppMethodBeat.o(70082);
            }
        });
        this.HSx.HTb.observe(this, new Observer<djv>() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass8 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.lifecycle.Observer
            public final /* synthetic */ void onChanged(djv djv) {
                AppMethodBeat.i(70083);
                djv djv2 = djv;
                if (djv2 != null) {
                    com.tencent.mm.wallet_core.ui.formview.a.b logicDelegate = WcPayRealnameVerifyIdInputUI.this.HSj.getLogicDelegate();
                    if (logicDelegate instanceof a.C2170a) {
                        ((a.C2170a) logicDelegate).aqn(djv2.MNM.key);
                    }
                    WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, djv2);
                }
                AppMethodBeat.o(70083);
            }
        });
        this.HSx.HTl.observe(this, new Observer<String>() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass9 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.lifecycle.Observer
            public final /* synthetic */ void onChanged(String str) {
                AppMethodBeat.i(70084);
                WcPayRealnameVerifyIdInputUI.this.HSk.setText(str);
                AppMethodBeat.o(70084);
            }
        });
        this.HSx.HTm.observe(this, new Observer<String>() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass10 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.lifecycle.Observer
            public final /* synthetic */ void onChanged(String str) {
                AppMethodBeat.i(70085);
                String str2 = str;
                if ("9999/12/31".equals(str2)) {
                    WcPayRealnameVerifyIdInputUI.this.HSl.setText(WcPayRealnameVerifyIdInputUI.this.getString(R.string.ixm));
                    AppMethodBeat.o(70085);
                    return;
                }
                WcPayRealnameVerifyIdInputUI.this.HSl.setText(str2);
                AppMethodBeat.o(70085);
            }
        });
        this.HSx.HTa.observe(this, new Observer<String>() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass11 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.lifecycle.Observer
            public final /* synthetic */ void onChanged(String str) {
                AppMethodBeat.i(70086);
                WcPayRealnameVerifyIdInputUI.this.HSq.setText(str);
                AppMethodBeat.o(70086);
            }
        });
        this.HSx.HTn.observe(this, new Observer<Integer>() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass13 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.lifecycle.Observer
            public final /* synthetic */ void onChanged(Integer num) {
                AppMethodBeat.i(174481);
                Integer num2 = num;
                if (num2 == null) {
                    WcPayRealnameVerifyIdInputUI.this.HSm.setText("");
                    AppMethodBeat.o(174481);
                    return;
                }
                WcPayRealnameVerifyIdInputUI.this.HSm.setText(WcPayRealnameVerifyIdInputUI.this.HSD[num2.intValue()]);
                AppMethodBeat.o(174481);
            }
        });
        this.HSx.HTo.observe(this, new Observer<String>() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass14 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.lifecycle.Observer
            public final /* synthetic */ void onChanged(String str) {
                AppMethodBeat.i(174482);
                WcPayRealnameVerifyIdInputUI.this.HSo.setText(str);
                AppMethodBeat.o(174482);
            }
        });
        this.HSx.HTh.observe(this, new Observer<String>() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass15 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.lifecycle.Observer
            public final /* synthetic */ void onChanged(String str) {
                AppMethodBeat.i(174483);
                String str2 = str;
                if (!WcPayRealnameVerifyIdInputUI.this.HSw) {
                    WcPayRealnameVerifyIdInputUI.this.HRv.setText(str2);
                }
                AppMethodBeat.o(174483);
            }
        });
        this.HSx.HTi.observe(this, new Observer<String>() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass16 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.lifecycle.Observer
            public final /* synthetic */ void onChanged(String str) {
                AppMethodBeat.i(174484);
                if (WcPayRealnameVerifyIdInputUI.this.HSw) {
                    WcPayRealnameVerifyIdInputUI.this.HRv.setText(WcPayRealnameVerifyIdInputUI.this.HSx.HTh.getValue() + WcPayRealnameVerifyIdInputUI.this.HSx.HTi.getValue());
                }
                AppMethodBeat.o(174484);
            }
        });
        this.HSx.HTq.observe(this, new Observer<String>() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass17 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.lifecycle.Observer
            public final /* synthetic */ void onChanged(String str) {
                AppMethodBeat.i(174485);
                WcPayRealnameVerifyIdInputUI.this.HSn.setText(str);
                AppMethodBeat.o(174485);
            }
        });
        this.HSx.HTj.observe(this, new Observer<Profession>() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass18 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.lifecycle.Observer
            public final /* synthetic */ void onChanged(Profession profession) {
                AppMethodBeat.i(174486);
                WcPayRealnameVerifyIdInputUI.this.HRu.setText(profession.HTX);
                AppMethodBeat.o(174486);
            }
        });
        this.HSx.HTk.observe(this, new Observer<Boolean>() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass19 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.lifecycle.Observer
            public final /* synthetic */ void onChanged(Boolean bool) {
                AppMethodBeat.i(214180);
                WcPayRealnameVerifyIdInputUI.this.krs.setEnabled(bool.booleanValue());
                AppMethodBeat.o(214180);
            }
        });
        if (this.HSB.size() > 0) {
            this.HSx.a(this.HSB.get(0));
        } else {
            com.tencent.mm.wallet_core.ui.formview.a.b logicDelegate = this.HSj.getLogicDelegate();
            if (logicDelegate instanceof a.C2170a) {
                ((a.C2170a) logicDelegate).aqn(-1);
            }
        }
        f.a(new WalletFormView[]{this.Cjx, this.HSi, this.HSj, this.HRu, this.HRv, this.HSk, this.HSl, this.HSm, this.HSn, this.HSo, this.HSp, this.HSq});
        AppMethodBeat.o(70106);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(70107);
        super.onDestroy();
        this.mNetSceneMgr.removeSceneEndListener(1616);
        AppMethodBeat.o(70107);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(70108);
        if (qVar instanceof l) {
            l lVar = (l) qVar;
            this.mProfessions = lVar.HTV;
            this.HSA = lVar.HSA;
        } else if ((qVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.g) && i2 == 0 && i3 == 0) {
            final com.tencent.mm.plugin.wallet_core.id_verify.model.g gVar = (com.tencent.mm.plugin.wallet_core.id_verify.model.g) qVar;
            if (gVar.HPz == null) {
                a(gVar);
            } else {
                Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify show juveniles dialog");
                h.c(this, gVar.HPz.dQx, "", gVar.HPz.IaV, gVar.HPz.IaU, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass20 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(174488);
                        Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify dialog lOk");
                        WcPayRealnameVerifyIdInputUI.a(WcPayRealnameVerifyIdInputUI.this, gVar);
                        u.xV(1);
                        AppMethodBeat.o(174488);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.AnonymousClass21 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(214181);
                        Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify dialog lCancel");
                        u.xV(0);
                        AppMethodBeat.o(214181);
                    }
                });
            }
            AppMethodBeat.o(70108);
            return true;
        }
        AppMethodBeat.o(70108);
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        return true;
    }

    private void a(com.tencent.mm.plugin.wallet_core.id_verify.model.g gVar) {
        AppMethodBeat.i(70109);
        d process = getProcess();
        Bundle input = getInput();
        String str = gVar.token;
        Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "NetSceneRealNameVerify response succ");
        if (process != null) {
            input.putString("key_real_name_token", str);
            input.putString("key_country_code", this.HSx.HTe.getValue());
            input.putString("key_province_code", this.HSx.HTf.getValue());
            input.putString("key_city_code", this.HSx.HTg.getValue());
            input.putParcelable("key_profession", this.HSx.HTj.getValue());
            input.putBoolean("realname_verify_process_need_bind_card", gVar.HTF);
            input.putBoolean("realname_verify_process_need_face", gVar.HTG);
            input.putLong("realname_verify_process_face_scene", gVar.igp);
            input.putString("realname_verify_process_face_package", gVar.packageExt);
            input.putString("realname_verify_process_face_package_sign", gVar.dYK);
            input.putString("realname_verify_process_add_bank_word", gVar.HTJ);
            input.putString("realname_verify_process_req_key", gVar.dNQ);
            RealNameBundle realNameBundle = new RealNameBundle();
            realNameBundle.HTZ = this.HSx.HSZ.getValue();
            realNameBundle.HUa = this.HSy;
            realNameBundle.HUb = this.HSz;
            realNameBundle.HUc = this.HSx.HTb.getValue().MNM.key;
            realNameBundle.HUd = this.HSi.getText();
            realNameBundle.HUe = this.HSx.HTj.getValue();
            realNameBundle.HUf = this.HSx.HTe.getValue();
            realNameBundle.HUg = this.HSx.HTf.getValue();
            realNameBundle.HUh = this.HSx.HTg.getValue();
            realNameBundle.HUi = this.HSx.HTh.getValue();
            realNameBundle.HUj = this.HSx.HTn.getValue().intValue();
            realNameBundle.HUw = this.HSx.HTl.getValue();
            realNameBundle.HUx = this.HSE;
            realNameBundle.HUy = this.HSF;
            realNameBundle.HUz = this.HSG;
            realNameBundle.HUk = this.HSx.HTm.getValue();
            realNameBundle.HUl = this.HSH;
            realNameBundle.HUm = this.HSI;
            realNameBundle.HUn = this.HSJ;
            realNameBundle.HUo = this.HSo.getText();
            realNameBundle.HUp = this.HSK;
            realNameBundle.HUq = this.HSL;
            realNameBundle.HUr = this.HSM;
            realNameBundle.HUs = this.HSx.HTp.getValue();
            realNameBundle.HUt = this.HSx.HTq.getValue();
            realNameBundle.HUu = this.HSN;
            realNameBundle.HUv = this.HSx.HTi.getValue();
            realNameBundle.HUA = this.HSx.HTr.getValue();
            realNameBundle.fuA = getString(R.string.gxi).equals(this.HSx.HTa.getValue()) ? 1 : 2;
            input.putParcelable("realname_verify_process_bundle", realNameBundle);
            process.a(this, 0, input);
        }
        AppMethodBeat.o(70109);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(70110);
        getInput().getInt("key_err_code");
        super.onNewIntent(intent);
        AppMethodBeat.o(70110);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cb3;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(70111);
        if (i2 == 1) {
            if (i3 == -1) {
                String stringExtra = intent.getStringExtra("CountryName");
                String stringExtra2 = intent.getStringExtra("ProviceName");
                String stringExtra3 = intent.getStringExtra("CityName");
                String stringExtra4 = intent.getStringExtra("Country");
                String stringExtra5 = intent.getStringExtra("Contact_Province");
                String stringExtra6 = intent.getStringExtra("Contact_City");
                StringBuilder sb = new StringBuilder();
                if (!Util.isNullOrNil(stringExtra)) {
                    sb.append(stringExtra);
                    sb.append(" ");
                }
                if (!Util.isNullOrNil(stringExtra2)) {
                    sb.append(stringExtra2);
                    sb.append(" ");
                }
                if (!Util.isNullOrNil(stringExtra3)) {
                    sb.append(stringExtra3);
                }
                this.HSx.E(stringExtra4, stringExtra5, stringExtra6, sb.toString());
                AppMethodBeat.o(70111);
                return;
            }
            Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "no area choose!");
            AppMethodBeat.o(70111);
        } else if (i2 != 2) {
            if (i2 == 3 && i3 == 100) {
                if (!Util.isNullOrNil(intent.getStringExtra("country_name"))) {
                    String stringExtra7 = intent.getStringExtra("iso_code");
                    String stringExtra8 = intent.getStringExtra("country_name");
                    this.HSN = intent.getStringExtra("couttry_code");
                    VM vm = this.HSx;
                    vm.HTp.setValue(stringExtra7);
                    vm.HTq.setValue(stringExtra8);
                    AppMethodBeat.o(70111);
                    return;
                }
            } else if (i2 == 4 && i3 == -1 && intent != null) {
                String stringExtra9 = intent.getStringExtra(WcPayRealnameInputAddressUI.HRI);
                String stringExtra10 = intent.getStringExtra(WcPayRealnameInputAddressUI.HRJ);
                String stringExtra11 = intent.getStringExtra(WcPayRealnameInputAddressUI.HRK);
                String stringExtra12 = intent.getStringExtra(WcPayRealnameInputAddressUI.HRL);
                String stringExtra13 = intent.getStringExtra(WcPayRealnameInputAddressUI.HRM);
                this.HSx.E(stringExtra9, stringExtra10, stringExtra11, stringExtra12);
                this.HSx.HTi.setValue(stringExtra13);
                AppMethodBeat.o(70111);
                return;
            } else {
                super.onActivityResult(i2, i3, intent);
            }
            AppMethodBeat.o(70111);
        } else if (i3 == -1) {
            this.HSx.HTj.setValue((Profession) intent.getParcelableExtra("key_select_profession"));
            AppMethodBeat.o(70111);
        } else {
            Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "no choose!");
            AppMethodBeat.o(70111);
        }
    }

    public static class VM extends ViewModel {
        public MutableLiveData<String> HSZ = new MutableLiveData<>();
        public MutableLiveData<String> HTa = new MutableLiveData<>();
        public MutableLiveData<djv> HTb = new MutableLiveData<>();
        public MutableLiveData<String> HTc = new MutableLiveData<>();
        public MutableLiveData<Boolean> HTd = new MutableLiveData<>();
        public MutableLiveData<String> HTe = new MutableLiveData<>();
        public MutableLiveData<String> HTf = new MutableLiveData<>();
        public MutableLiveData<String> HTg = new MutableLiveData<>();
        public MutableLiveData<String> HTh = new MutableLiveData<>();
        public MutableLiveData<String> HTi = new MutableLiveData<>();
        public MutableLiveData<Profession> HTj = new MutableLiveData<>();
        public MutableLiveData<Boolean> HTk = new MutableLiveData<>();
        public MutableLiveData<String> HTl = new MutableLiveData<>();
        public MutableLiveData<String> HTm = new MutableLiveData<>();
        public MutableLiveData<Integer> HTn = new MutableLiveData<>();
        public MutableLiveData<String> HTo = new MutableLiveData<>();
        public MutableLiveData<String> HTp = new MutableLiveData<>();
        public MutableLiveData<String> HTq = new MutableLiveData<>();
        public MutableLiveData<String> HTr = new MutableLiveData<>();

        public VM() {
            AppMethodBeat.i(70101);
            this.HTn.setValue(0);
            AnonymousClass1 r0 = new Observer<Object>() {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.VM.AnonymousClass1 */

                @Override // android.arch.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AppMethodBeat.i(70100);
                    if (VM.a(VM.this)) {
                        VM.this.HTk.setValue(Boolean.TRUE);
                        AppMethodBeat.o(70100);
                        return;
                    }
                    VM.this.HTk.setValue(Boolean.FALSE);
                    AppMethodBeat.o(70100);
                }
            };
            this.HSZ.observeForever(r0);
            this.HTc.observeForever(r0);
            this.HTj.observeForever(r0);
            this.HTe.observeForever(r0);
            this.HTf.observeForever(r0);
            this.HTg.observeForever(r0);
            this.HTl.observeForever(r0);
            this.HTm.observeForever(r0);
            this.HTn.observeForever(r0);
            this.HTp.observeForever(r0);
            this.HTq.observeForever(r0);
            this.HTo.observeForever(r0);
            this.HTr.observeForever(r0);
            this.HTa.observeForever(r0);
            AppMethodBeat.o(70101);
        }

        public final void a(djv djv) {
            AppMethodBeat.i(70102);
            this.HTb.setValue(djv);
            AppMethodBeat.o(70102);
        }

        public final void E(String str, String str2, String str3, String str4) {
            AppMethodBeat.i(174494);
            this.HTe.setValue(str);
            this.HTf.setValue(str2);
            this.HTg.setValue(str3);
            this.HTh.setValue(str4);
            AppMethodBeat.o(174494);
        }

        public final void aVd(String str) {
            AppMethodBeat.i(214187);
            this.HSZ.setValue(str);
            AppMethodBeat.o(214187);
        }

        public final void aVe(String str) {
            AppMethodBeat.i(214188);
            this.HTm.setValue(str);
            AppMethodBeat.o(214188);
        }

        static /* synthetic */ boolean a(VM vm) {
            AppMethodBeat.i(214189);
            if (Util.isNullOrNil(vm.HSZ.getValue()) || Util.isNullOrNil(vm.HTc.getValue())) {
                AppMethodBeat.o(214189);
                return false;
            }
            djv value = vm.HTb.getValue();
            if (value == null || ((value.MNS && Util.isNullOrNil(vm.HTp.getValue())) || ((value.MNO && Util.isNullOrNil(vm.HTe.getValue()) && Util.isNullOrNil(vm.HTf.getValue()) && Util.isNullOrNil(vm.HTg.getValue()) && Util.isNullOrNil(vm.HTi.getValue())) || ((value.MNN && vm.HTj.getValue() == null) || ((value.MNQ && vm.HTn.getValue() == null) || ((value.MNP && Util.isNullOrNil(vm.HTm.getValue())) || ((value.MNT && Util.isNullOrNil(vm.HTl.getValue())) || ((value.MNR && Util.isNullOrNil(vm.HTo.getValue())) || (value.MNU && Util.isNullOrNil(vm.HTr.getValue())))))))))) {
                AppMethodBeat.o(214189);
                return false;
            }
            AppMethodBeat.o(214189);
            return true;
        }
    }

    static /* synthetic */ void j(WcPayRealnameVerifyIdInputUI wcPayRealnameVerifyIdInputUI) {
        AppMethodBeat.i(174497);
        Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "go to select profession ui");
        Intent intent = new Intent(wcPayRealnameVerifyIdInputUI.getContext(), WalletSelectProfessionUI.class);
        intent.putExtra("key_profession_list", wcPayRealnameVerifyIdInputUI.mProfessions);
        wcPayRealnameVerifyIdInputUI.startActivityForResult(intent, 2);
        AppMethodBeat.o(174497);
    }

    static /* synthetic */ void l(WcPayRealnameVerifyIdInputUI wcPayRealnameVerifyIdInputUI) {
        AppMethodBeat.i(174499);
        Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "go to detail address ui");
        Intent intent = new Intent(wcPayRealnameVerifyIdInputUI.getContext(), WcPayRealnameInputAddressUI.class);
        intent.putExtra(WcPayRealnameInputAddressUI.HRI, wcPayRealnameVerifyIdInputUI.HSx.HTe.getValue());
        intent.putExtra(WcPayRealnameInputAddressUI.HRJ, wcPayRealnameVerifyIdInputUI.HSx.HTf.getValue());
        intent.putExtra(WcPayRealnameInputAddressUI.HRK, wcPayRealnameVerifyIdInputUI.HSx.HTg.getValue());
        intent.putExtra(WcPayRealnameInputAddressUI.HRL, wcPayRealnameVerifyIdInputUI.HSx.HTh.getValue());
        intent.putExtra(WcPayRealnameInputAddressUI.HRM, wcPayRealnameVerifyIdInputUI.HSx.HTi.getValue());
        intent.putExtra(WcPayRealnameInputAddressUI.HRN, wcPayRealnameVerifyIdInputUI.HSA);
        wcPayRealnameVerifyIdInputUI.startActivityForResult(intent, 4);
        AppMethodBeat.o(174499);
    }

    static /* synthetic */ void m(WcPayRealnameVerifyIdInputUI wcPayRealnameVerifyIdInputUI) {
        AppMethodBeat.i(214190);
        Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "go to select address ui");
        Intent intent = new Intent();
        intent.putExtra("GetAddress", true);
        intent.putExtra("ShowSelectedLocation", false);
        intent.putExtra("IsRealNameVerifyScene", true);
        intent.putExtra("IsNeedShowSearchBar", true);
        com.tencent.mm.br.c.c(wcPayRealnameVerifyIdInputUI.getContext(), ".ui.tools.MultiStageCitySelectUI", intent, 1);
        AppMethodBeat.o(214190);
    }

    static /* synthetic */ void n(WcPayRealnameVerifyIdInputUI wcPayRealnameVerifyIdInputUI) {
        AppMethodBeat.i(214191);
        Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "do verify real name");
        int i2 = wcPayRealnameVerifyIdInputUI.getInput().getInt("entry_scene", -1);
        String string = wcPayRealnameVerifyIdInputUI.getInput().getString("key_realname_sessionid");
        wcPayRealnameVerifyIdInputUI.getString(R.string.gxi);
        Log.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "%s, %s, %s", Integer.valueOf(wcPayRealnameVerifyIdInputUI.HSH), Integer.valueOf(wcPayRealnameVerifyIdInputUI.HSI), Integer.valueOf(wcPayRealnameVerifyIdInputUI.HSJ));
        String str = "";
        if (wcPayRealnameVerifyIdInputUI.HSl.isShown()) {
            str = wcPayRealnameVerifyIdInputUI.HSO.desedeEncode(String.format("%04d%02d%02d", Integer.valueOf(wcPayRealnameVerifyIdInputUI.HSH), Integer.valueOf(wcPayRealnameVerifyIdInputUI.HSI), Integer.valueOf(wcPayRealnameVerifyIdInputUI.HSJ)), f.hhV());
        }
        Log.d("MicroMsg.WcPayRealnameVerifyIdInputUI", "enc: %s", str);
        String str2 = "";
        if (wcPayRealnameVerifyIdInputUI.HSo.isShown()) {
            str2 = wcPayRealnameVerifyIdInputUI.HSO.desedeEncode(String.format("%04d%02d%02d", Integer.valueOf(wcPayRealnameVerifyIdInputUI.HSK), Integer.valueOf(wcPayRealnameVerifyIdInputUI.HSL), Integer.valueOf(wcPayRealnameVerifyIdInputUI.HSM)), f.hhV());
        }
        wcPayRealnameVerifyIdInputUI.doSceneProgress(new com.tencent.mm.plugin.wallet_core.id_verify.model.g(wcPayRealnameVerifyIdInputUI.HSx.HSZ.getValue(), wcPayRealnameVerifyIdInputUI.HSx.HTc.getValue(), i2, wcPayRealnameVerifyIdInputUI.HSx.HTb.getValue().MNM.key, wcPayRealnameVerifyIdInputUI.HSx.HTj.getValue(), wcPayRealnameVerifyIdInputUI.HSx.HTe.getValue(), wcPayRealnameVerifyIdInputUI.HSx.HTf.getValue(), wcPayRealnameVerifyIdInputUI.HSx.HTg.getValue(), str, (long) wcPayRealnameVerifyIdInputUI.HSx.HTn.getValue().intValue(), str2, wcPayRealnameVerifyIdInputUI.HSx.HTp.getValue(), string), true);
        AppMethodBeat.o(214191);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void a(WcPayRealnameVerifyIdInputUI wcPayRealnameVerifyIdInputUI, djv djv) {
        AppMethodBeat.i(214192);
        if (djv != null) {
            int i2 = djv.MNM.key;
            Log.i("MicroMsg.WcPayRealnameVerifyIdInputUI", "change cre type: %s", Integer.valueOf(i2));
            wcPayRealnameVerifyIdInputUI.HSj.setText("");
            com.tencent.mm.wallet_core.ui.formview.a.b logicDelegate = wcPayRealnameVerifyIdInputUI.HSj.getLogicDelegate();
            if (logicDelegate instanceof a.C2170a) {
                ((a.C2170a) logicDelegate).aqn(i2);
            }
            VM vm = wcPayRealnameVerifyIdInputUI.HSx;
            vm.HTl.setValue("");
            vm.HTm.setValue("");
            vm.HTn.setValue(0);
            vm.HTo.setValue("");
            vm.HTp.setValue("");
            vm.HTq.setValue("");
            wcPayRealnameVerifyIdInputUI.HSi.setText(djv.MNM.iFF);
            if (djv.MNT) {
                wcPayRealnameVerifyIdInputUI.HSk.setVisibility(0);
            } else {
                wcPayRealnameVerifyIdInputUI.HSk.setVisibility(8);
            }
            if (djv.MNR) {
                wcPayRealnameVerifyIdInputUI.HSo.setVisibility(0);
            } else {
                wcPayRealnameVerifyIdInputUI.HSo.setVisibility(8);
            }
            if (djv.MNQ) {
                wcPayRealnameVerifyIdInputUI.HSm.setVisibility(0);
            } else {
                wcPayRealnameVerifyIdInputUI.HSm.setVisibility(8);
            }
            if (djv.MNS) {
                wcPayRealnameVerifyIdInputUI.HSn.setVisibility(0);
            } else {
                wcPayRealnameVerifyIdInputUI.HSn.setVisibility(8);
            }
            if (djv.MNN) {
                wcPayRealnameVerifyIdInputUI.HRu.setVisibility(0);
            } else {
                wcPayRealnameVerifyIdInputUI.HRu.setVisibility(8);
            }
            if (djv.MNP) {
                wcPayRealnameVerifyIdInputUI.HSl.setVisibility(0);
            } else {
                wcPayRealnameVerifyIdInputUI.HSl.setVisibility(8);
            }
            if (djv.MNU) {
                wcPayRealnameVerifyIdInputUI.HSp.setVisibility(0);
            } else {
                wcPayRealnameVerifyIdInputUI.HSp.setVisibility(8);
            }
            if (djv.MNV) {
                wcPayRealnameVerifyIdInputUI.HSq.setVisibility(0);
            } else {
                wcPayRealnameVerifyIdInputUI.HSq.setVisibility(8);
            }
            if (djv.MNO) {
                wcPayRealnameVerifyIdInputUI.HSw = true;
                wcPayRealnameVerifyIdInputUI.HRv.setVisibility(0);
            } else {
                wcPayRealnameVerifyIdInputUI.HRv.setVisibility(8);
            }
            switch (i2) {
                case 1:
                    wcPayRealnameVerifyIdInputUI.setEditFocusListener(wcPayRealnameVerifyIdInputUI.HSj, 1, false, false, false);
                    AppMethodBeat.o(214192);
                    return;
                case 2:
                    wcPayRealnameVerifyIdInputUI.setEditFocusListener(wcPayRealnameVerifyIdInputUI.HSj, 1, true, false, false);
                    AppMethodBeat.o(214192);
                    return;
                case 3:
                case 4:
                case 6:
                case 7:
                case 8:
                default:
                    wcPayRealnameVerifyIdInputUI.setEditFocusListener(wcPayRealnameVerifyIdInputUI.HSj, 1, true, false, false);
                    break;
                case 5:
                    wcPayRealnameVerifyIdInputUI.setEditFocusListener(wcPayRealnameVerifyIdInputUI.HSj, 1, true, false, false);
                    AppMethodBeat.o(214192);
                    return;
                case 9:
                    wcPayRealnameVerifyIdInputUI.setEditFocusListener(wcPayRealnameVerifyIdInputUI.HSj, 1, true, false, false);
                    AppMethodBeat.o(214192);
                    return;
            }
        }
        AppMethodBeat.o(214192);
    }
}
