package com.tencent.mm.wallet_core.ui.formview;

import android.content.DialogInterface;
import android.text.InputFilter;
import android.text.method.NumberKeyListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.zr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.f;

public final class a {
    private static String TAG = "MicroMsg.CommonHintViewConfig";

    public static void a(EditHintPasswdView editHintPasswdView) {
        AppMethodBeat.i(73102);
        if (editHintPasswdView != null) {
            editHintPasswdView.setEncrType(1);
        }
        AppMethodBeat.o(73102);
    }

    public static void a(EditHintPasswdView editHintPasswdView, boolean z) {
        AppMethodBeat.i(73103);
        if (editHintPasswdView != null) {
            editHintPasswdView.setEncrType(z ? -10 : 20);
        }
        AppMethodBeat.o(73103);
    }

    static class b implements com.tencent.mm.wallet_core.ui.formview.a.b {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        @Override // com.tencent.mm.wallet_core.ui.formview.a.b
        public boolean a(WalletFormView walletFormView) {
            return true;
        }

        @Override // com.tencent.mm.wallet_core.ui.formview.a.b
        public boolean a(WalletFormView walletFormView, String str) {
            return false;
        }

        @Override // com.tencent.mm.wallet_core.ui.formview.a.b
        public boolean b(WalletFormView walletFormView, String str) {
            return false;
        }

        @Override // com.tencent.mm.wallet_core.ui.formview.a.b
        public boolean eIg() {
            return false;
        }

        @Override // com.tencent.mm.wallet_core.ui.formview.a.b
        public String c(WalletFormView walletFormView, String str) {
            return null;
        }
    }

    public static void b(WalletFormView walletFormView) {
        AppMethodBeat.i(73104);
        if (walletFormView == null) {
            Log.e(TAG, "hy: param error");
            AppMethodBeat.o(73104);
            return;
        }
        walletFormView.setLogicDelegate(new b() {
            /* class com.tencent.mm.wallet_core.ui.formview.a.AnonymousClass1 */

            @Override // com.tencent.mm.wallet_core.ui.formview.a.b, com.tencent.mm.wallet_core.ui.formview.a.b
            public final boolean a(WalletFormView walletFormView, String str) {
                AppMethodBeat.i(73079);
                if (Util.isNullOrNil(str) || str.length() > 5) {
                    AppMethodBeat.o(73079);
                    return false;
                }
                walletFormView.setSelection(0);
                walletFormView.setBankcardTail(str);
                walletFormView.setMaxInputLength(24 - str.length());
                walletFormView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(walletFormView.getMaxInputLength())});
                AppMethodBeat.o(73079);
                return true;
            }

            @Override // com.tencent.mm.wallet_core.ui.formview.a.b, com.tencent.mm.wallet_core.ui.formview.a.b
            public final boolean b(WalletFormView walletFormView, String str) {
                AppMethodBeat.i(73080);
                if (Util.isNullOrNil(str) || str.length() > 5) {
                    AppMethodBeat.o(73080);
                    return false;
                }
                walletFormView.setSelection(0);
                walletFormView.set3DesToView(str);
                walletFormView.setMaxInputLength(24 - str.length());
                walletFormView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(walletFormView.getMaxInputLength())});
                AppMethodBeat.o(73080);
                return true;
            }

            @Override // com.tencent.mm.wallet_core.ui.formview.a.b, com.tencent.mm.wallet_core.ui.formview.a.b
            public final boolean eIg() {
                return true;
            }

            @Override // com.tencent.mm.wallet_core.ui.formview.a.b, com.tencent.mm.wallet_core.ui.formview.a.b
            public final String c(WalletFormView walletFormView, String str) {
                AppMethodBeat.i(73082);
                String replaceAll = Util.nullAs(str, "").replaceAll(" ", "");
                AppMethodBeat.o(73082);
                return replaceAll;
            }

            @Override // com.tencent.mm.wallet_core.ui.formview.a.b, com.tencent.mm.wallet_core.ui.formview.a.b
            public final boolean a(WalletFormView walletFormView) {
                AppMethodBeat.i(73081);
                if (walletFormView.Rwe == null) {
                    AppMethodBeat.o(73081);
                    return false;
                }
                boolean isBankcardNum = walletFormView.Rwe.isBankcardNum();
                AppMethodBeat.o(73081);
                return isBankcardNum;
            }
        });
        AppMethodBeat.o(73104);
    }

    public static void a(final MMActivity mMActivity, final WalletFormView walletFormView) {
        AppMethodBeat.i(73105);
        if (walletFormView == null) {
            Log.e(TAG, "hy: param error");
            AppMethodBeat.o(73105);
            return;
        }
        walletFormView.setLogicDelegate(new b() {
            /* class com.tencent.mm.wallet_core.ui.formview.a.AnonymousClass3 */

            @Override // com.tencent.mm.wallet_core.ui.formview.a.b, com.tencent.mm.wallet_core.ui.formview.a.b
            public final boolean eIg() {
                return true;
            }

            @Override // com.tencent.mm.wallet_core.ui.formview.a.b, com.tencent.mm.wallet_core.ui.formview.a.b
            public final String c(WalletFormView walletFormView, String str) {
                AppMethodBeat.i(73084);
                String replace = Util.nullAs((String) walletFormView.getTag(), "").replace(FilePathGenerator.ANDROID_DIR_SEP, "");
                AppMethodBeat.o(73084);
                return replace;
            }
        });
        b.f(mMActivity, walletFormView);
        walletFormView.setOnInfoIvClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.wallet_core.ui.formview.a.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(73085);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/formview/CommonHintViewConfig$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                walletFormView.getContext();
                int hhB = ah.hhB();
                walletFormView.getContext();
                b.a(mMActivity, hhB, ah.hhC());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/formview/CommonHintViewConfig$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(73085);
            }
        });
        AppMethodBeat.o(73105);
    }

    public static void b(final MMActivity mMActivity, final WalletFormView walletFormView) {
        AppMethodBeat.i(73106);
        if (walletFormView == null) {
            Log.e(TAG, "hy: param error");
            AppMethodBeat.o(73106);
            return;
        }
        walletFormView.setOnInfoIvClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.wallet_core.ui.formview.a.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(73086);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/formview/CommonHintViewConfig$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                walletFormView.getContext();
                b.a(mMActivity, ah.hhD(), (int) R.string.bk7);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/formview/CommonHintViewConfig$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(73086);
            }
        });
        AppMethodBeat.o(73106);
    }

    public static void c(WalletFormView walletFormView) {
        AppMethodBeat.i(73107);
        if (walletFormView == null) {
            Log.e(TAG, "hy: param error");
            AppMethodBeat.o(73107);
            return;
        }
        walletFormView.setLogicDelegate(new C2170a(walletFormView, (byte) 0));
        AppMethodBeat.o(73107);
    }

    public static void d(WalletFormView walletFormView) {
        AppMethodBeat.i(73108);
        if (walletFormView == null) {
            Log.e(TAG, "hy: param error");
            AppMethodBeat.o(73108);
            return;
        }
        walletFormView.setLogicDelegate(new C2170a(walletFormView));
        walletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
        AppMethodBeat.o(73108);
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.a$a  reason: collision with other inner class name */
    public static class C2170a extends b {
        private int RvP;
        private WalletFormView RvQ;

        @Override // com.tencent.mm.wallet_core.ui.formview.a.b, com.tencent.mm.wallet_core.ui.formview.a.b
        public final /* bridge */ /* synthetic */ boolean a(WalletFormView walletFormView, String str) {
            AppMethodBeat.i(73101);
            boolean a2 = super.a(walletFormView, str);
            AppMethodBeat.o(73101);
            return a2;
        }

        @Override // com.tencent.mm.wallet_core.ui.formview.a.b, com.tencent.mm.wallet_core.ui.formview.a.b
        public final /* bridge */ /* synthetic */ boolean b(WalletFormView walletFormView, String str) {
            AppMethodBeat.i(73100);
            boolean b2 = super.b(walletFormView, str);
            AppMethodBeat.o(73100);
            return b2;
        }

        @Override // com.tencent.mm.wallet_core.ui.formview.a.b, com.tencent.mm.wallet_core.ui.formview.a.b
        public final /* bridge */ /* synthetic */ String c(WalletFormView walletFormView, String str) {
            AppMethodBeat.i(73098);
            String c2 = super.c(walletFormView, str);
            AppMethodBeat.o(73098);
            return c2;
        }

        @Override // com.tencent.mm.wallet_core.ui.formview.a.b, com.tencent.mm.wallet_core.ui.formview.a.b
        public final /* bridge */ /* synthetic */ boolean eIg() {
            AppMethodBeat.i(73099);
            boolean eIg = super.eIg();
            AppMethodBeat.o(73099);
            return eIg;
        }

        public C2170a(WalletFormView walletFormView) {
            this(walletFormView, (byte) 0);
        }

        public C2170a(WalletFormView walletFormView, byte b2) {
            super((byte) 0);
            AppMethodBeat.i(73094);
            this.RvP = 1;
            this.RvQ = walletFormView;
            this.RvP = 1;
            hhX();
            AppMethodBeat.o(73094);
        }

        public final void aqn(int i2) {
            AppMethodBeat.i(73095);
            this.RvP = i2;
            hhX();
            AppMethodBeat.o(73095);
        }

        private void hhX() {
            AppMethodBeat.i(73096);
            if (this.RvP == 1) {
                if (this.RvQ != null) {
                    this.RvQ.setKeyListener(new NumberKeyListener() {
                        /* class com.tencent.mm.wallet_core.ui.formview.a.C2170a.AnonymousClass1 */

                        public final int getInputType() {
                            return 1;
                        }

                        /* access modifiers changed from: protected */
                        public final char[] getAcceptedChars() {
                            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                        }
                    });
                    AppMethodBeat.o(73096);
                    return;
                }
            } else if (this.RvQ != null) {
                this.RvQ.setInputType(1);
            }
            AppMethodBeat.o(73096);
        }

        @Override // com.tencent.mm.wallet_core.ui.formview.a.b, com.tencent.mm.wallet_core.ui.formview.a.b
        public final boolean a(WalletFormView walletFormView) {
            AppMethodBeat.i(73097);
            int i2 = this.RvP;
            if (walletFormView.Rwe == null) {
                AppMethodBeat.o(73097);
                return false;
            }
            boolean isAreaIDCardNum = walletFormView.Rwe.isAreaIDCardNum(i2);
            AppMethodBeat.o(73097);
            return isAreaIDCardNum;
        }
    }

    public static void e(WalletFormView walletFormView) {
        AppMethodBeat.i(73109);
        if (walletFormView == null) {
            Log.e(TAG, "hy: param error");
            AppMethodBeat.o(73109);
            return;
        }
        walletFormView.setLogicDelegate(new b() {
            /* class com.tencent.mm.wallet_core.ui.formview.a.AnonymousClass6 */

            @Override // com.tencent.mm.wallet_core.ui.formview.a.b, com.tencent.mm.wallet_core.ui.formview.a.b
            public final boolean a(WalletFormView walletFormView) {
                AppMethodBeat.i(73087);
                boolean isValidEmail = Util.isValidEmail(walletFormView.getText());
                AppMethodBeat.o(73087);
                return isValidEmail;
            }
        });
        AppMethodBeat.o(73109);
    }

    public static void c(final MMActivity mMActivity, WalletFormView walletFormView) {
        AppMethodBeat.i(73110);
        if (walletFormView == null) {
            Log.e(TAG, "hy: param error");
            AppMethodBeat.o(73110);
            return;
        }
        walletFormView.setOnInfoIvClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.wallet_core.ui.formview.a.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(73088);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/formview/CommonHintViewConfig$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.a(mMActivity, (int) R.layout.c_k, (int) R.string.i_s);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/formview/CommonHintViewConfig$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(73088);
            }
        });
        walletFormView.setLogicDelegate(new b() {
            /* class com.tencent.mm.wallet_core.ui.formview.a.AnonymousClass8 */

            @Override // com.tencent.mm.wallet_core.ui.formview.a.b, com.tencent.mm.wallet_core.ui.formview.a.b
            public final boolean a(WalletFormView walletFormView) {
                AppMethodBeat.i(73089);
                boolean isPhoneNum = walletFormView.isPhoneNum();
                AppMethodBeat.o(73089);
                return isPhoneNum;
            }
        });
        AppMethodBeat.o(73110);
    }

    public static void d(final MMActivity mMActivity, WalletFormView walletFormView) {
        AppMethodBeat.i(73111);
        if (walletFormView == null) {
            Log.e(TAG, "hy: param error");
            AppMethodBeat.o(73111);
            return;
        }
        walletFormView.setOnInfoIvClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.wallet_core.ui.formview.a.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(73092);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/formview/CommonHintViewConfig$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.c(mMActivity, mMActivity.getString(R.string.i_m), mMActivity.getString(R.string.i_j), mMActivity.getString(R.string.i_l), mMActivity.getString(R.string.i_n), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.wallet_core.ui.formview.a.AnonymousClass9.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(73090);
                        f.p(mMActivity, "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/payunregshow?operation=1", false);
                        EventCenter.instance.publish(new zr());
                        AppMethodBeat.o(73090);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.wallet_core.ui.formview.a.AnonymousClass9.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(73091);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(73091);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/formview/CommonHintViewConfig$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(73092);
            }
        });
        walletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
        AppMethodBeat.o(73111);
    }

    public static void e(final MMActivity mMActivity, WalletFormView walletFormView) {
        AppMethodBeat.i(73112);
        if (walletFormView == null) {
            Log.e(TAG, "hy: param error");
            AppMethodBeat.o(73112);
            return;
        }
        walletFormView.setOnInfoIvClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.wallet_core.ui.formview.a.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(73093);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/formview/CommonHintViewConfig$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.a(mMActivity, (int) R.layout.c9t, (int) R.string.i_j);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/formview/CommonHintViewConfig$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(73093);
            }
        });
        walletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
        AppMethodBeat.o(73112);
    }

    public static void f(WalletFormView walletFormView) {
        AppMethodBeat.i(73113);
        if (walletFormView == null) {
            Log.e(TAG, "hy: param error");
            AppMethodBeat.o(73113);
            return;
        }
        walletFormView.setLogicDelegate(new b() {
            /* class com.tencent.mm.wallet_core.ui.formview.a.AnonymousClass2 */

            @Override // com.tencent.mm.wallet_core.ui.formview.a.b, com.tencent.mm.wallet_core.ui.formview.a.b
            public final boolean a(WalletFormView walletFormView) {
                AppMethodBeat.i(73083);
                if (walletFormView.Rwe == null) {
                    AppMethodBeat.o(73083);
                    return false;
                }
                boolean isMoneyAmount = walletFormView.Rwe.isMoneyAmount();
                AppMethodBeat.o(73083);
                return isMoneyAmount;
            }
        });
        AppMethodBeat.o(73113);
    }

    public static void g(WalletFormView walletFormView) {
        AppMethodBeat.i(73114);
        if (walletFormView == null) {
            Log.e(TAG, "hy: param error");
            AppMethodBeat.o(73114);
            return;
        }
        walletFormView.setIsSecretAnswer(true);
        AppMethodBeat.o(73114);
    }
}
