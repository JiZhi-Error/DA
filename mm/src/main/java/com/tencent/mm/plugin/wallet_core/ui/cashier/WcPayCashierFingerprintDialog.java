package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.c;
import com.tencent.mm.plugin.fingerprint.b.a.d;
import com.tencent.mm.plugin.fingerprint.b.a.e;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.i;

public class WcPayCashierFingerprintDialog extends i implements LifecycleObserver {
    private ImageView Img;
    TextView Imj;
    ImageView Imk;
    TextView Iml;
    a Imm;
    b Imn;
    private ViewGroup nmW;

    public interface b {
        void a(e eVar);

        void fTK();

        void fTL();

        void yw(boolean z);
    }

    public WcPayCashierFingerprintDialog(Context context) {
        super(context, R.style.a66);
        AppMethodBeat.i(71428);
        init();
        AppMethodBeat.o(71428);
    }

    public WcPayCashierFingerprintDialog(Context context, int i2) {
        super(context, R.style.a66);
        AppMethodBeat.i(71429);
        init();
        AppMethodBeat.o(71429);
    }

    private void init() {
        AppMethodBeat.i(71430);
        initView();
        setContentView(this.nmW);
        setCanceledOnTouchOutside(false);
        this.Imm = new a();
        setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(71418);
                if (WcPayCashierFingerprintDialog.this.Imn != null) {
                    WcPayCashierFingerprintDialog.this.Imn.fTK();
                }
                AppMethodBeat.o(71418);
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog.AnonymousClass2 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(71419);
                Log.i("MicroMsg.WcPayCashierFingerprintDialog", "dialog dismiss");
                if (WcPayCashierFingerprintDialog.this.Imm != null) {
                    WcPayCashierFingerprintDialog.this.Imm.fTN();
                    WcPayCashierFingerprintDialog.this.Imm = null;
                }
                WcPayCashierFingerprintDialog.this.Imn = null;
                AppMethodBeat.o(71419);
            }
        });
        AppMethodBeat.o(71430);
    }

    private void initView() {
        AppMethodBeat.i(71431);
        this.nmW = (ViewGroup) View.inflate(getContext(), R.layout.cav, null);
        this.Img = (ImageView) this.nmW.findViewById(R.id.jpp);
        this.Imj = (TextView) this.nmW.findViewById(R.id.jpq);
        this.Imk = (ImageView) this.nmW.findViewById(R.id.jps);
        this.Iml = (TextView) this.nmW.findViewById(R.id.jpr);
        this.Img.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(71420);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFingerprintDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.WcPayCashierFingerprintDialog", "click back icon");
                WcPayCashierFingerprintDialog.this.cancel();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFingerprintDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71420);
            }
        });
        AppMethodBeat.o(71431);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71432);
        super.onCreate(bundle);
        a aVar = this.Imm;
        Log.i("MicroMsg.WcPayCashierFingerprintDialog", "req fingerprint auth 2");
        com.tencent.mm.plugin.soter.d.a.flK();
        h.INSTANCE.dN(1104, 38);
        f fVar = new f(aVar.wFE);
        fVar.dDL = aVar.dDL;
        ((com.tencent.mm.plugin.fingerprint.b.a.i) g.af(com.tencent.mm.plugin.fingerprint.b.a.i.class)).a(MMApplicationContext.getContext(), fVar, new d() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.fingerprint.b.a.d
            public final void onSuccess(e eVar) {
                AppMethodBeat.i(71423);
                WcPayCashierFingerprintDialog.this.fTM();
                a.this.Iju = eVar.retryCount;
                WcPayCashierFingerprintDialog.this.dismiss();
                if (WcPayCashierFingerprintDialog.this.Imn != null) {
                    WcPayCashierFingerprintDialog.this.Imn.a(eVar);
                    WcPayCashierFingerprintDialog.this.Imn = null;
                }
                h.INSTANCE.dN(1104, 37);
                com.tencent.mm.plugin.soter.d.a.aau(0);
                AppMethodBeat.o(71423);
            }

            @Override // com.tencent.mm.plugin.fingerprint.b.a.d
            public final void onFail(e eVar) {
                AppMethodBeat.i(71424);
                a.this.Iju = eVar.retryCount;
                com.tencent.mm.plugin.soter.d.a.aau(2);
                c cVar = eVar.wFV;
                if (cVar.errCode == 2005 || cVar.errCode == 2007) {
                    h.INSTANCE.dN(1104, 36);
                }
                WcPayCashierFingerprintDialog.this.dismiss();
                if (WcPayCashierFingerprintDialog.this.Imn != null) {
                    WcPayCashierFingerprintDialog.this.Imn.yw(eVar.wFM);
                    WcPayCashierFingerprintDialog.this.Imn = null;
                }
                AppMethodBeat.o(71424);
            }

            @Override // com.tencent.mm.plugin.fingerprint.b.a.d
            public final void onRetry(e eVar) {
                AppMethodBeat.i(71425);
                WcPayCashierFingerprintDialog wcPayCashierFingerprintDialog = WcPayCashierFingerprintDialog.this;
                wcPayCashierFingerprintDialog.Imk.setImageDrawable(ar.m(wcPayCashierFingerprintDialog.getContext(), R.raw.icons_outlined_pay_fingerprint_android, wcPayCashierFingerprintDialog.getContext().getResources().getColor(R.color.Red)));
                wcPayCashierFingerprintDialog.Iml.setTextColor(wcPayCashierFingerprintDialog.getContext().getResources().getColor(R.color.Red));
                wcPayCashierFingerprintDialog.Imj.setVisibility(0);
                wcPayCashierFingerprintDialog.Imj.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(71421);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFingerprintDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.WcPayCashierFingerprintDialog", "click switch payway");
                        WcPayCashierFingerprintDialog.this.dismiss();
                        if (WcPayCashierFingerprintDialog.this.Imn != null) {
                            WcPayCashierFingerprintDialog.this.Imn.fTL();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFingerprintDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(71421);
                    }
                });
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(71422);
                        WcPayCashierFingerprintDialog.this.fTM();
                        AppMethodBeat.o(71422);
                    }
                }, 500);
                a.this.Iju = eVar.retryCount;
                com.tencent.mm.plugin.soter.d.a.aau(1);
                AppMethodBeat.o(71425);
            }
        });
        AppMethodBeat.o(71432);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onActivityPause() {
        AppMethodBeat.i(71433);
        Log.i("MicroMsg.WcPayCashierFingerprintDialog", "activity paused, release and dismiss");
        cancel();
        AppMethodBeat.o(71433);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onActivityDestroy() {
        AppMethodBeat.i(71434);
        Log.i("MicroMsg.WcPayCashierFingerprintDialog", "activity destroy");
        if (this.Imm != null) {
            this.Imm.fTN();
            this.Imm = null;
        }
        this.Img = null;
        this.Imn = null;
        AppMethodBeat.o(71434);
    }

    public final void fTM() {
        AppMethodBeat.i(71435);
        this.Imk.setImageDrawable(ar.m(getContext(), R.raw.icons_outlined_pay_fingerprint_android, getContext().getResources().getColor(R.color.FG_2)));
        this.Iml.setTextColor(getContext().getResources().getColor(R.color.u_));
        AppMethodBeat.o(71435);
    }

    /* access modifiers changed from: package-private */
    public class a {
        int Iju;
        com.tencent.mm.plugin.fingerprint.b.a.i Imp = ((com.tencent.mm.plugin.fingerprint.b.a.i) g.af(com.tencent.mm.plugin.fingerprint.b.a.i.class));
        public String dDL;
        com.tencent.mm.plugin.fingerprint.d.a wEQ = ((com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class));
        public String wFE;

        a() {
            AppMethodBeat.i(71426);
            AppMethodBeat.o(71426);
        }

        public final void fTN() {
            AppMethodBeat.i(71427);
            Log.i("MicroMsg.WcPayCashierFingerprintDialog", "release fingerprint");
            this.Imp.cancel();
            com.tencent.soter.a.g.f.hlO().hlP();
            this.wEQ = null;
            this.Imp = null;
            AppMethodBeat.o(71427);
        }
    }
}
