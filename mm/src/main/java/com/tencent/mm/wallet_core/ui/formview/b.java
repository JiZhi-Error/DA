package com.tencent.mm.wallet_core.ui.formview;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

public final class b {
    private static int Rvl = 0;
    private static int Rvm = 0;
    private static final int Rwa = R.id.jfg;

    static void a(TenpaySecureEditText tenpaySecureEditText, int i2) {
        AppMethodBeat.i(73135);
        a(tenpaySecureEditText, i2, true);
        AppMethodBeat.o(73135);
    }

    static void a(TenpaySecureEditText tenpaySecureEditText, int i2, boolean z) {
        AppMethodBeat.i(214345);
        if (tenpaySecureEditText == null) {
            Log.e("MicroMsg.FormatViewUtil", "hy: param error: no edit text view");
            AppMethodBeat.o(214345);
        } else if (i2 == 1) {
            tenpaySecureEditText.setIsPasswordFormat(true, z);
            AppMethodBeat.o(214345);
        } else if (i2 == 2) {
            tenpaySecureEditText.setIsSecurityAnswerFormat(true);
            AppMethodBeat.o(214345);
        } else if (i2 == 3) {
            tenpaySecureEditText.setIsCvvPaymentFormat(true);
            AppMethodBeat.o(214345);
        } else if (i2 == 4) {
            tenpaySecureEditText.setIsCvv4PaymentFormat(true);
            AppMethodBeat.o(214345);
        } else if (i2 == 5) {
            tenpaySecureEditText.setIsValidThru(true);
            AppMethodBeat.o(214345);
        } else if (i2 == 6) {
            tenpaySecureEditText.setIsBankcardFormat(true);
            AppMethodBeat.o(214345);
        } else if (i2 == 7) {
            tenpaySecureEditText.setIsMoneyAmountFormat(true);
            AppMethodBeat.o(214345);
        } else if (i2 == 8) {
            tenpaySecureEditText.setIsIdCardTailFormat(true);
            AppMethodBeat.o(214345);
        } else {
            tenpaySecureEditText.setIsCvv4PaymentFormat(false);
            AppMethodBeat.o(214345);
        }
    }

    public static void f(final MMActivity mMActivity, final WalletFormView walletFormView) {
        AppMethodBeat.i(73136);
        walletFormView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.wallet_core.ui.formview.b.AnonymousClass1 */
            int Rwb = -1;
            int year = -1;

            public final void onClick(View view) {
                AppMethodBeat.i(73132);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/wallet_core/ui/formview/FormViewUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                mMActivity.hideVKB();
                if (mMActivity instanceof WalletBaseUI) {
                    ((WalletBaseUI) mMActivity).hideTenpayKB();
                }
                final com.tencent.mm.ui.widget.picker.b bVar2 = new com.tencent.mm.ui.widget.picker.b(mMActivity);
                bVar2.bg(true, false);
                bVar2.QSU = new b.a() {
                    /* class com.tencent.mm.wallet_core.ui.formview.b.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.picker.b.a
                    public final void onResult(boolean z, int i2, int i3, int i4) {
                        AppMethodBeat.i(73131);
                        bVar2.hide();
                        if (z) {
                            String hcf = bVar2.hcf();
                            if (Util.isNullOrNil(hcf)) {
                                AppMethodBeat.o(73131);
                                return;
                            }
                            String[] split = hcf.split("-");
                            if (split.length < 2) {
                                AppMethodBeat.o(73131);
                                return;
                            }
                            Log.d("MicroMsg.FormatViewUtil", "result: %s", hcf);
                            int safeParseInt = Util.safeParseInt(split[0]);
                            AnonymousClass1.this.Rwb = Util.safeParseInt(split[1]) - 1;
                            Log.d("MicroMsg.FormatViewUtil", "year: %s, month: %s", Integer.valueOf(safeParseInt), Integer.valueOf(AnonymousClass1.this.Rwb));
                            if (safeParseInt >= b.Rvl || AnonymousClass1.this.Rwb >= b.Rvm) {
                                DecimalFormat decimalFormat = new DecimalFormat("00");
                                if (z.aUo()) {
                                    walletFormView.setTag(decimalFormat.format((long) (AnonymousClass1.this.Rwb + 1)) + safeParseInt);
                                } else {
                                    walletFormView.setTag(decimalFormat.format((long) safeParseInt).substring(2) + decimalFormat.format((long) (AnonymousClass1.this.Rwb + 1)));
                                }
                                walletFormView.setText(decimalFormat.format((long) (AnonymousClass1.this.Rwb + 1)) + decimalFormat.format((long) safeParseInt).substring(2));
                            } else {
                                h.c(mMActivity, mMActivity.getString(R.string.icc), null, true);
                            }
                            if (walletFormView.getInputValidChangeListener() != null) {
                                walletFormView.getInputValidChangeListener().onInputValidChange(walletFormView.bql());
                            }
                        }
                        AppMethodBeat.o(73131);
                    }
                };
                if (this.year < b.Rvl || this.Rwb < b.Rvm) {
                    Calendar instance = Calendar.getInstance();
                    bVar2.aX(instance.get(1), instance.get(2) + 1, instance.get(5));
                } else {
                    bVar2.aX(this.year, this.Rwb + 1, 1);
                }
                bVar2.show();
                a.a(this, "com/tencent/mm/wallet_core/ui/formview/FormViewUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(73132);
            }
        });
        AppMethodBeat.o(73136);
    }

    public static void a(MMActivity mMActivity, int i2, int i3) {
        AppMethodBeat.i(73137);
        if (i2 == -1) {
            AppMethodBeat.o(73137);
            return;
        }
        mMActivity.addDialog(com.tencent.mm.wallet_core.ui.b.a(mMActivity, i2, mMActivity.getResources().getString(i3), mMActivity.getResources().getString(R.string.idg), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.wallet_core.ui.formview.b.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(73133);
                dialogInterface.dismiss();
                AppMethodBeat.o(73133);
            }
        }));
        AppMethodBeat.o(73137);
    }

    public static void e(MMActivity mMActivity, String str) {
        AppMethodBeat.i(73138);
        String string = mMActivity.getResources().getString(R.string.i_s);
        String string2 = mMActivity.getResources().getString(R.string.idg);
        AnonymousClass3 r3 = new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.wallet_core.ui.formview.b.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(73134);
                dialogInterface.dismiss();
                AppMethodBeat.o(73134);
            }
        };
        View inflate = ((LayoutInflater) mMActivity.getSystemService("layout_inflater")).inflate(R.layout.c_k, (ViewGroup) null);
        if (str != null && !str.isEmpty()) {
            ((TextView) inflate.findViewById(R.id.ipe)).setText(str);
        }
        mMActivity.addDialog(h.a(mMActivity, string, string2, inflate, r3));
        AppMethodBeat.o(73138);
    }
}
