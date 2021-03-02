package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.b;
import com.tencent.mm.plugin.wallet_payu.remittance.a.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.f;

public class PayURemittanceDetailUI extends RemittanceDetailUI {
    private int AOC;
    private int AOD;
    private int Cvz;
    private String IuA;
    private int IuB;
    private int IuC;
    private String Iuz;
    private String mReceiverName;

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ String aWd(String str) {
        AppMethodBeat.i(72201);
        String bZ = bZ(str, false);
        AppMethodBeat.o(72201);
        return bZ;
    }

    static /* synthetic */ String aWe(String str) {
        AppMethodBeat.i(72202);
        String bZ = bZ(str, false);
        AppMethodBeat.o(72202);
        return bZ;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72194);
        super.onCreate(bundle);
        this.Cvz = getIntent().getIntExtra("total_fee", 0);
        this.Iuz = getIntent().getStringExtra("fee_type");
        if (getIntent().getBooleanExtra("is_sender", false)) {
            this.IuA = z.aTY();
            this.mReceiverName = this.Cvv;
            AppMethodBeat.o(72194);
            return;
        }
        this.IuA = this.Cvv;
        this.mReceiverName = z.aTY();
        AppMethodBeat.o(72194);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI
    public final void Wg(int i2) {
        AppMethodBeat.i(72195);
        doSceneProgress(new e(this.Crw, this.Cvv, this.Cvs), true);
        AppMethodBeat.o(72195);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI
    public final void Wh(int i2) {
        AppMethodBeat.i(72196);
        doSceneProgress(new e(this.Crw, this.Cvv, this.Cvs, i2), true);
        AppMethodBeat.o(72196);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI
    public final void aQ(Intent intent) {
        AppMethodBeat.i(72197);
        c.b(this, "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", intent);
        AppMethodBeat.o(72197);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI
    public final void eOg() {
        AppMethodBeat.i(72198);
        doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.c(this.Crw, this.Cvz, this.Iuz, this.Cvv));
        AppMethodBeat.o(72198);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI
    public final void eOh() {
        AppMethodBeat.i(72199);
        doSceneProgress(new b(this.Crw, this.Cvz, this.Iuz, this.Cvv));
        AppMethodBeat.o(72199);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z = false;
        AppMethodBeat.i(72200);
        if (qVar instanceof e) {
            e eVar = (e) qVar;
            if (eVar.dJY != 0) {
                if (i2 == 0 && i3 == 0) {
                    this.IuB = eVar.status;
                    this.IuC = eVar.CpR;
                    this.AOD = eVar.Iuv;
                    this.AOC = eVar.Iuw;
                    this.Cvz = (int) (eVar.qwJ * 100.0d);
                    this.Iuz = eVar.AOl;
                    boolean equals = this.mReceiverName.equals(z.aTY());
                    this.CuL.setVisibility(8);
                    this.CuI.setText(f.d(((double) this.Cvz) / 100.0d, this.Iuz));
                    this.CuM.setVisibility(0);
                    this.Cvi.setVisibility(8);
                    int i4 = this.IuB;
                    switch (i4) {
                        case 2000:
                            if (!equals) {
                                this.CuH.setText(l.b(this, getString(R.string.g31, new Object[]{bZ(this.mReceiverName, true)}), this.CuH.getTextSize()));
                                String string = getString(R.string.g38, new Object[]{Integer.valueOf(this.Cvx)});
                                String string2 = getString(R.string.g4_);
                                SpannableString spannableString = new SpannableString(string + string2);
                                a aVar = new a(this);
                                aVar.AQT = new a.AbstractC1567a() {
                                    /* class com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.AnonymousClass1 */

                                    @Override // com.tencent.mm.plugin.order.c.a.AbstractC1567a
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(72184);
                                        h.c(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(R.string.g27), PayURemittanceDetailUI.this.getString(R.string.yd), PayURemittanceDetailUI.this.getString(R.string.g49), PayURemittanceDetailUI.this.getString(R.string.sz), new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.AnonymousClass1.AnonymousClass1 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(72183);
                                                Intent intent = new Intent();
                                                intent.putExtra(FirebaseAnalytics.b.TRANSACTION_ID, PayURemittanceDetailUI.this.Cvu);
                                                intent.putExtra("receiver_name", PayURemittanceDetailUI.this.mReceiverName);
                                                intent.putExtra("total_fee", PayURemittanceDetailUI.this.Cvz);
                                                intent.putExtra("fee_type", PayURemittanceDetailUI.this.Iuz);
                                                PayURemittanceDetailUI.this.aQ(intent);
                                                AppMethodBeat.o(72183);
                                            }
                                        }, new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.AnonymousClass1.AnonymousClass2 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                            }
                                        });
                                        AppMethodBeat.o(72184);
                                    }
                                };
                                spannableString.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                this.zcv.setMovementMethod(LinkMovementMethod.getInstance());
                                this.zcv.setText(spannableString);
                            } else {
                                this.Cnb.setImageResource(R.drawable.cs4);
                                this.CuL.setVisibility(0);
                                this.CuL.setOnClickListener(new View.OnClickListener() {
                                    /* class com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.AnonymousClass2 */

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(72185);
                                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                        bVar.bm(view);
                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        PayURemittanceDetailUI.this.eOg();
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(72185);
                                    }
                                });
                                String string3 = getString(R.string.g34, new Object[]{Integer.valueOf(this.Cvx)});
                                String string4 = getString(R.string.g2s);
                                SpannableString spannableString2 = new SpannableString(string3 + string4);
                                a aVar2 = new a(this);
                                aVar2.AQT = new a.AbstractC1567a() {
                                    /* class com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.AnonymousClass3 */

                                    @Override // com.tencent.mm.plugin.order.c.a.AbstractC1567a
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(72187);
                                        h.c(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(R.string.g2o, new Object[]{PayURemittanceDetailUI.aWd(PayURemittanceDetailUI.this.IuA)}), PayURemittanceDetailUI.this.getString(R.string.yd), PayURemittanceDetailUI.this.getString(R.string.g2t), PayURemittanceDetailUI.this.getString(R.string.sz), new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.AnonymousClass3.AnonymousClass1 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(72186);
                                                PayURemittanceDetailUI.this.eOh();
                                                AppMethodBeat.o(72186);
                                            }
                                        }, new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.AnonymousClass3.AnonymousClass2 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                            }
                                        });
                                        AppMethodBeat.o(72187);
                                    }
                                };
                                spannableString2.setSpan(aVar2, string3.length(), string3.length() + string4.length(), 33);
                                this.zcv.setMovementMethod(LinkMovementMethod.getInstance());
                                this.zcv.setText(spannableString2);
                            }
                            this.Cnb.setImageResource(R.drawable.cs4);
                            this.CuJ.setText(getString(R.string.g39, new Object[]{f.rZ(this.AOD)}));
                            this.CuJ.setVisibility(0);
                            this.CuK.setVisibility(8);
                            z = true;
                            break;
                        case 2001:
                            this.Cnb.setImageResource(R.raw.remittance_received);
                            if (equals) {
                                this.CuH.setText(R.string.g2v);
                                String string5 = getString(R.string.g2c);
                                SpannableString spannableString3 = new SpannableString(string5);
                                a aVar3 = new a(this);
                                aVar3.AQT = new a.AbstractC1567a() {
                                    /* class com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.AnonymousClass4 */

                                    @Override // com.tencent.mm.plugin.order.c.a.AbstractC1567a
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(72188);
                                        com.tencent.mm.pluginsdk.wallet.f.aF(PayURemittanceDetailUI.this, 0);
                                        AppMethodBeat.o(72188);
                                    }
                                };
                                spannableString3.setSpan(aVar3, 0, string5.length(), 33);
                                this.zcv.setMovementMethod(LinkMovementMethod.getInstance());
                                this.zcv.setText(spannableString3);
                                this.zcv.setVisibility(0);
                            } else {
                                this.CuH.setText(l.b(this, bZ(this.mReceiverName, true) + " " + getString(R.string.g2v), this.CuH.getTextSize()));
                                this.zcv.setVisibility(8);
                            }
                            this.CuJ.setText(getString(R.string.g39, new Object[]{f.rZ(this.IuC)}));
                            this.CuJ.setVisibility(0);
                            this.CuK.setText(getString(R.string.g2k, new Object[]{f.rZ(this.AOC)}));
                            this.CuK.setVisibility(0);
                            z = true;
                            break;
                        case 2002:
                        case 2003:
                            if (i4 != 2003 || equals) {
                                this.Cnb.setImageResource(R.raw.remittance_refunded);
                                if (equals) {
                                    this.CuH.setText(R.string.g2x);
                                } else {
                                    this.CuH.setText(l.b(this, bZ(this.mReceiverName, true) + getString(R.string.g2x), this.CuH.getTextSize()));
                                }
                            } else {
                                this.Cnb.setImageResource(R.raw.remittance_timed_out);
                                this.CuH.setText(R.string.g2z);
                            }
                            if (!equals) {
                                String string6 = getString(R.string.g2p);
                                String string7 = getString(R.string.g2c);
                                SpannableString spannableString4 = new SpannableString(string6 + string7);
                                a aVar4 = new a(this);
                                aVar4.AQT = new a.AbstractC1567a() {
                                    /* class com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.AnonymousClass5 */

                                    @Override // com.tencent.mm.plugin.order.c.a.AbstractC1567a
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(72189);
                                        com.tencent.mm.pluginsdk.wallet.f.aF(PayURemittanceDetailUI.this, 0);
                                        AppMethodBeat.o(72189);
                                    }
                                };
                                spannableString4.setSpan(aVar4, string6.length(), string6.length() + string7.length(), 33);
                                this.zcv.setMovementMethod(LinkMovementMethod.getInstance());
                                this.zcv.setText(spannableString4);
                            } else {
                                this.zcv.setText("");
                            }
                            this.zcv.setVisibility(0);
                            this.CuJ.setText(getString(R.string.g39, new Object[]{f.rZ(this.IuC)}));
                            this.CuJ.setVisibility(0);
                            this.CuK.setText(getString(R.string.g2n, new Object[]{f.rZ(this.AOD)}));
                            this.CuK.setVisibility(0);
                            z = true;
                            break;
                        default:
                            finish();
                            z = true;
                            break;
                    }
                }
                if (eVar.cSx == 1) {
                    g.aAi();
                    if (((String) g.aAh().azQ().get(327729, AppEventsConstants.EVENT_PARAM_VALUE_NO)).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        h.a(getContext(), (int) R.string.az_, (int) R.string.iqq, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.AnonymousClass8 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(72193);
                                h.cD(PayURemittanceDetailUI.this.getContext(), PayURemittanceDetailUI.this.getString(R.string.g2i));
                                AppMethodBeat.o(72193);
                            }
                        });
                        g.aAi();
                        g.aAh().azQ().set(327729, "1");
                    } else {
                        h.cD(getContext(), getString(R.string.g2i));
                    }
                }
                AppMethodBeat.o(72200);
                return z;
            } else if (i2 == 0 && i3 == 0) {
                if (this.Cvt == 1 && !getIntent().getBooleanExtra("is_sender", false)) {
                    this.Cnb.setImageResource(R.drawable.cs4);
                    this.CuH.setText(R.string.g30);
                    this.CuI.setText(f.d(eVar.qwJ, eVar.AOl));
                    this.CuL.setVisibility(0);
                    this.CuL.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.AnonymousClass6 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(72190);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            PayURemittanceDetailUI.this.eOg();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(72190);
                        }
                    });
                    String string8 = getString(R.string.g34, new Object[]{Integer.valueOf(this.Cvx)});
                    String string9 = getString(R.string.g2s);
                    SpannableString spannableString5 = new SpannableString(string8 + string9);
                    a aVar5 = new a(this);
                    aVar5.AQT = new a.AbstractC1567a() {
                        /* class com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.AnonymousClass7 */

                        @Override // com.tencent.mm.plugin.order.c.a.AbstractC1567a
                        public final void onClick(View view) {
                            AppMethodBeat.i(72192);
                            h.c(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(R.string.g2o, new Object[]{PayURemittanceDetailUI.aWe(PayURemittanceDetailUI.this.Cvv)}), PayURemittanceDetailUI.this.getString(R.string.yd), PayURemittanceDetailUI.this.getString(R.string.g2t), PayURemittanceDetailUI.this.getString(R.string.sz), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.AnonymousClass7.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(72191);
                                    PayURemittanceDetailUI.this.eOh();
                                    AppMethodBeat.o(72191);
                                }
                            }, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.AnonymousClass7.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            });
                            AppMethodBeat.o(72192);
                        }
                    };
                    spannableString5.setSpan(aVar5, string8.length(), string8.length() + string9.length(), 33);
                    this.zcv.setMovementMethod(LinkMovementMethod.getInstance());
                    this.zcv.setText(spannableString5);
                    this.CuJ.setText(getString(R.string.g39, new Object[]{f.rZ(eVar.CpR)}));
                    this.CuJ.setVisibility(0);
                    this.CuK.setVisibility(8);
                }
                AppMethodBeat.o(72200);
                return true;
            } else {
                Wh(0);
                AppMethodBeat.o(72200);
                return true;
            }
        } else if (!(qVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.c) && !(qVar instanceof b)) {
            AppMethodBeat.o(72200);
            return false;
        } else if (i2 == 0 && i3 == 0) {
            if (qVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.c) {
                Wh(1);
            } else {
                bY(0, getString(R.string.g2j));
            }
            AppMethodBeat.o(72200);
            return true;
        } else {
            bY(i3, str);
            AppMethodBeat.o(72200);
            return true;
        }
    }
}
