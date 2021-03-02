package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.b;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalletPhoneInputView extends LinearLayout {
    private WalletFormView Inn;
    public WalletFormView Ino;
    private TenpaySecureEditText Inp;
    private TextView Inq;
    private Map<String, b.a> Inr;
    private String Ins = "";
    private String Int = "";
    private boolean Inu = true;
    public String Inv;
    private int mMode = 0;

    public WalletPhoneInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(71521);
        init(context);
        d(context, attributeSet, -1);
        AppMethodBeat.o(71521);
    }

    public WalletPhoneInputView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(71522);
        init(context);
        d(context, attributeSet, i2);
        AppMethodBeat.o(71522);
    }

    private void init(Context context) {
        AppMethodBeat.i(71523);
        inflate(context, R.layout.c_m, this);
        this.Inn = (WalletFormView) findViewById(R.id.ga8);
        this.Ino = (WalletFormView) findViewById(R.id.gaj);
        this.Inq = (TextView) findViewById(R.id.gdl);
        this.Inn.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(71515);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.WalletPhoneInputView", "click area");
                Intent intent = new Intent();
                intent.setClassName(WalletPhoneInputView.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
                ((MMActivity) WalletPhoneInputView.this.getContext()).startActivityForResult(intent, ShareElfFile.SectionHeader.SHN_ABS);
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71515);
            }
        });
        this.Inp = (TenpaySecureEditText) this.Ino.findViewById(R.id.gg7);
        if (getContext() instanceof MMActivity) {
            this.Ino.setOnInfoIvClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(71516);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    WalletPhoneInputView.a(WalletPhoneInputView.this, WalletPhoneInputView.this.Inv);
                    a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(71516);
                }
            });
            this.Ino.setLogicDelegate(new com.tencent.mm.wallet_core.ui.formview.a.b() {
                /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.ui.formview.a.b
                public final boolean a(WalletFormView walletFormView) {
                    AppMethodBeat.i(71517);
                    if (WalletPhoneInputView.this.fTT()) {
                        boolean isPhoneNum = walletFormView.isPhoneNum();
                        AppMethodBeat.o(71517);
                        return isPhoneNum;
                    } else if (Util.isNullOrNil(WalletPhoneInputView.this.Int) || Util.isNullOrNil(WalletPhoneInputView.this.Ins) || Util.isNullOrNil(WalletPhoneInputView.this.Ino.getText())) {
                        AppMethodBeat.o(71517);
                        return false;
                    } else {
                        AppMethodBeat.o(71517);
                        return true;
                    }
                }

                @Override // com.tencent.mm.wallet_core.ui.formview.a.b
                public final boolean a(WalletFormView walletFormView, String str) {
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.ui.formview.a.b
                public final boolean b(WalletFormView walletFormView, String str) {
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.ui.formview.a.b
                public final boolean eIg() {
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.ui.formview.a.b
                public final String c(WalletFormView walletFormView, String str) {
                    return null;
                }
            });
        }
        getContext();
        List<b.a> Pf = b.Pf(getContext().getString(R.string.bj8));
        this.Inr = new HashMap();
        for (b.a aVar : Pf) {
            this.Inr.put(aVar.jbY, aVar);
        }
        AppMethodBeat.o(71523);
    }

    private void d(Context context, AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(71524);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C2011a.WalletPhoneInputViewAttrs, i2, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.Ino.setHint(context.getString(resourceId));
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId2 != 0) {
            this.Ino.setTitleText(context.getString(resourceId2));
        }
        AppMethodBeat.o(71524);
    }

    public WalletFormView getPhoneNumberEt() {
        return this.Ino;
    }

    public String getCountryCode() {
        AppMethodBeat.i(71525);
        if (fTT()) {
            AppMethodBeat.o(71525);
            return "86";
        }
        String obj = this.Inp.getText().toString();
        AppMethodBeat.o(71525);
        return obj;
    }

    public final boolean g(int i2, int i3, Intent intent) {
        AppMethodBeat.i(71526);
        if (i2 == 65521) {
            if (i3 == 100) {
                String stringExtra = intent.getStringExtra("country_name");
                String stringExtra2 = intent.getStringExtra("couttry_code");
                Log.i("MicroMsg.WalletPhoneInputView", "countryName: %s, countryCode: %s", this.Ins, this.Int);
                if (Util.isNullOrNil(stringExtra) || Util.isNullOrNil(stringExtra2)) {
                    Log.i("MicroMsg.WalletPhoneInputView", "cancel pick");
                    AppMethodBeat.o(71526);
                    return true;
                }
                this.Ins = stringExtra;
                this.Int = stringExtra2;
                this.Inu = false;
                fTR();
                this.Inp.clearFocus();
            }
            AppMethodBeat.o(71526);
            return true;
        }
        AppMethodBeat.o(71526);
        return false;
    }

    private void fTR() {
        AppMethodBeat.i(71527);
        this.Inn.setText(this.Ins);
        this.Inp.setText(this.Int);
        AppMethodBeat.o(71527);
    }

    private void fTS() {
        AppMethodBeat.i(71528);
        b.a aVar = this.Inr.get("86");
        this.Int = aVar.jbY;
        this.Ins = aVar.jbZ;
        fTR();
        AppMethodBeat.o(71528);
    }

    public final boolean fTT() {
        return this.mMode == 0;
    }

    public final void fTU() {
        AppMethodBeat.i(71529);
        this.mMode = 0;
        fTS();
        this.Inn.setVisibility(8);
        this.Inp.setVisibility(8);
        this.Inq.setVisibility(8);
        AppMethodBeat.o(71529);
    }

    public final void fTV() {
        AppMethodBeat.i(71530);
        this.mMode = 1;
        fTS();
        this.Inn.setVisibility(0);
        this.Inp.setVisibility(0);
        this.Inq.setVisibility(0);
        this.Inp.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView.AnonymousClass5 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(71519);
                if (Util.isNullOrNil(editable.toString())) {
                    WalletPhoneInputView.this.Inn.setText("");
                    WalletPhoneInputView.this.Inn.setContentTextColorRes(R.color.a2x);
                    WalletPhoneInputView.this.Inp.setTextColor(WalletPhoneInputView.this.getResources().getColor(R.color.a2x));
                    AppMethodBeat.o(71519);
                } else if (!WalletPhoneInputView.this.Inu) {
                    Log.i("MicroMsg.WalletPhoneInputView", "manual pick don't search");
                    WalletPhoneInputView.this.Inn.setContentTextColorRes(R.color.a2x);
                    WalletPhoneInputView.this.Inp.setTextColor(WalletPhoneInputView.this.getResources().getColor(R.color.a2x));
                    WalletPhoneInputView.this.Inu = true;
                    AppMethodBeat.o(71519);
                } else {
                    b.a aVar = (b.a) WalletPhoneInputView.this.Inr.get(editable.toString());
                    Log.d("MicroMsg.WalletPhoneInputView", "cCode: %s, s: %s", aVar, editable.toString());
                    if (aVar != null) {
                        WalletPhoneInputView.this.Int = aVar.jbY;
                        WalletPhoneInputView.this.Ins = aVar.jbZ;
                        WalletPhoneInputView.this.Inn.setText(aVar.jbZ);
                        WalletPhoneInputView.this.Inn.setContentTextColorRes(R.color.a2x);
                        WalletPhoneInputView.this.Inp.setTextColor(WalletPhoneInputView.this.getResources().getColor(R.color.a2x));
                    } else {
                        WalletPhoneInputView.this.Int = "";
                        WalletPhoneInputView.this.Ins = "";
                        WalletPhoneInputView.this.Inn.setText(WalletPhoneInputView.this.getContext().getString(R.string.ip0));
                    }
                    WalletPhoneInputView.this.Ino.getInputValidChangeListener().onInputValidChange(WalletPhoneInputView.this.Ino.bql());
                    AppMethodBeat.o(71519);
                }
            }
        });
        this.Inp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView.AnonymousClass6 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(71520);
                if (!z) {
                    if (((b.a) WalletPhoneInputView.this.Inr.get(WalletPhoneInputView.this.Inp.getText().toString())) == null) {
                        WalletPhoneInputView.this.Inn.setContentTextColorRes(R.color.a5e);
                        WalletPhoneInputView.this.Inp.setTextColor(WalletPhoneInputView.this.getResources().getColor(R.color.a5e));
                        AppMethodBeat.o(71520);
                        return;
                    }
                    WalletPhoneInputView.this.Inn.setContentTextColorRes(R.color.a2x);
                    WalletPhoneInputView.this.Inp.setTextColor(WalletPhoneInputView.this.getResources().getColor(R.color.a2x));
                }
                AppMethodBeat.o(71520);
            }
        });
        AppMethodBeat.o(71530);
    }

    static /* synthetic */ void a(WalletPhoneInputView walletPhoneInputView, String str) {
        AppMethodBeat.i(71531);
        String string = walletPhoneInputView.getContext().getString(R.string.i_s);
        if (Util.isNullOrNil(str)) {
            str = walletPhoneInputView.getContext().getString(R.string.i_t);
        }
        h.a(walletPhoneInputView.getContext(), str, string, walletPhoneInputView.getContext().getString(R.string.idg), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(71518);
                dialogInterface.dismiss();
                AppMethodBeat.o(71518);
            }
        });
        AppMethodBeat.o(71531);
    }
}
