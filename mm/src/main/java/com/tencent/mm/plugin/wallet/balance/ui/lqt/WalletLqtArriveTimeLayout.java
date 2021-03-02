package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.dlw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WalletLqtArriveTimeLayout extends LinearLayout {
    List<dlw> HwO = new ArrayList();
    List<WeakReference<b>> HwP = new ArrayList();
    dlw HwQ;
    private a HwR;
    boolean HwS = false;
    private View.OnClickListener qOH = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(68741);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtArriveTimeLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this);
            b bVar2 = (b) view.getTag();
            if (WalletLqtArriveTimeLayout.this.HwO == null || WalletLqtArriveTimeLayout.this.HwO.size() <= bVar2.index) {
                WalletLqtArriveTimeLayout.this.HwQ = null;
            } else {
                bVar2.afT.setChecked(true);
                WalletLqtArriveTimeLayout.this.HwQ = (dlw) WalletLqtArriveTimeLayout.this.HwO.get(bVar2.index);
            }
            WalletLqtArriveTimeLayout.c(WalletLqtArriveTimeLayout.this);
            Log.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", Integer.valueOf(bVar2.index), bVar2.mPa.getText());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtArriveTimeLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(68741);
        }
    };

    public interface a {
        void fNw();
    }

    static /* synthetic */ void c(WalletLqtArriveTimeLayout walletLqtArriveTimeLayout) {
        AppMethodBeat.i(68750);
        walletLqtArriveTimeLayout.fNv();
        AppMethodBeat.o(68750);
    }

    public WalletLqtArriveTimeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(68743);
        AppMethodBeat.o(68743);
    }

    public WalletLqtArriveTimeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(68744);
        AppMethodBeat.o(68744);
    }

    public void setCallback(a aVar) {
        this.HwR = aVar;
    }

    private void fNv() {
        AppMethodBeat.i(68745);
        if (this.HwR != null) {
            this.HwR.fNw();
        }
        AppMethodBeat.o(68745);
    }

    public dlw getSelectRedeemType() {
        return this.HwQ;
    }

    public List<dlw> getRedeemTypeList() {
        return this.HwO;
    }

    public final void w(List<dlw> list, boolean z) {
        AppMethodBeat.i(182505);
        this.HwS = true;
        this.HwO.clear();
        this.HwO.addAll(list);
        this.HwP.clear();
        removeAllViews();
        setVisibility(0);
        if (this.HwO != null && !this.HwO.isEmpty()) {
            int i2 = 0;
            for (dlw dlw : this.HwO) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.c9m, (ViewGroup) this, false);
                b bVar = new b((byte) 0);
                bVar.jBN = linearLayout;
                bVar.mPa = (TextView) linearLayout.findViewById(R.id.exd);
                bVar.jVn = (TextView) linearLayout.findViewById(R.id.exc);
                bVar.afT = (RadioButton) linearLayout.findViewById(R.id.exf);
                bVar.mPa.setText(dlw.MPz);
                if (!Util.isNullOrNil(dlw.MPA)) {
                    bVar.jVn.setText(dlw.MPA);
                } else {
                    bVar.jVn.setVisibility(8);
                }
                if (this.HwQ != null) {
                    Log.d("MicroMsg.WalletLqtArriveTimeLayout", "arrive wording: %s, %s, %s", Boolean.valueOf(z), Integer.valueOf(this.HwQ.MJg), Integer.valueOf(dlw.MJg));
                }
                if (z) {
                    if (this.HwQ != null && this.HwQ.MJg == dlw.MJg) {
                        bVar.afT.setChecked(true);
                    }
                } else if (i2 == 0) {
                    bVar.afT.setChecked(true);
                    this.HwQ = dlw;
                }
                bVar.index = i2;
                linearLayout.setTag(bVar);
                linearLayout.setOnClickListener(this.qOH);
                this.HwP.add(new WeakReference<>(bVar));
                addView(linearLayout);
                i2++;
            }
        }
        AppMethodBeat.o(182505);
    }

    private static void a(b bVar, boolean z) {
        AppMethodBeat.i(68747);
        bVar.afT.setEnabled(z);
        bVar.mPa.setEnabled(z);
        bVar.jVn.setEnabled(z);
        bVar.jBN.setEnabled(z);
        AppMethodBeat.o(68747);
    }

    public final void aUJ(String str) {
        AppMethodBeat.i(68748);
        Log.i("MicroMsg.WalletLqtArriveTimeLayout", "input money: %s", str);
        if (this.HwO == null || this.HwO.isEmpty()) {
            AppMethodBeat.o(68748);
            return;
        }
        this.HwQ = null;
        for (WeakReference<b> weakReference : this.HwP) {
            if (weakReference.get() != null) {
                weakReference.get().afT.setEnabled(true);
                weakReference.get().afT.setChecked(false);
            }
        }
        int nE = f.nE(str, "100");
        int i2 = 0;
        for (dlw dlw : this.HwO) {
            if (dlw.MPB < 0 || nE <= dlw.MPB) {
                b bVar = this.HwP.get(i2).get();
                if (bVar != null) {
                    a(bVar, true);
                    if (this.HwQ == null) {
                        Log.i("MicroMsg.WalletLqtArriveTimeLayout", "auto select type: %s", Integer.valueOf(dlw.MJg));
                        bVar.afT.setChecked(true);
                        this.HwQ = dlw;
                        fNv();
                        if (i2 > 0) {
                            bVar.mPa.setTextColor(MMApplicationContext.getContext().getResources().getColor(R.color.ts));
                        } else {
                            bVar.fNx();
                        }
                    } else {
                        bVar.fNx();
                    }
                }
            } else {
                Log.i("MicroMsg.WalletLqtArriveTimeLayout", "disable item: %s, %s", Integer.valueOf(i2), Integer.valueOf(dlw.MPB));
                b bVar2 = this.HwP.get(i2).get();
                if (bVar2 != null) {
                    bVar2.afT.setChecked(false);
                    a(bVar2, false);
                    this.HwQ = null;
                    fNv();
                }
            }
            i2++;
        }
        AppMethodBeat.o(68748);
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public RadioButton afT;
        public int index;
        public View jBN;
        public TextView jVn;
        public TextView mPa;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final void fNx() {
            AppMethodBeat.i(68742);
            this.mPa.setTextColor(MMApplicationContext.getContext().getResources().getColorStateList(R.color.ae9));
            AppMethodBeat.o(68742);
        }
    }

    static /* synthetic */ void a(WalletLqtArriveTimeLayout walletLqtArriveTimeLayout) {
        AppMethodBeat.i(68749);
        for (WeakReference<b> weakReference : walletLqtArriveTimeLayout.HwP) {
            if (weakReference.get() != null && weakReference.get().afT.isEnabled()) {
                weakReference.get().afT.setChecked(false);
            }
        }
        AppMethodBeat.o(68749);
    }
}
