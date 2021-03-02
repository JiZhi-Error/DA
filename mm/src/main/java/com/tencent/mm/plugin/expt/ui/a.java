package com.tencent.mm.plugin.expt.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.wt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f;

public final class a extends b {
    View oQL;
    View sLO;
    private IListener<wt> sLP = new IListener<wt>() {
        /* class com.tencent.mm.plugin.expt.ui.a.AnonymousClass4 */

        {
            AppMethodBeat.i(220664);
            this.__eventId = wt.class.getName().hashCode();
            AppMethodBeat.o(220664);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wt wtVar) {
            AppMethodBeat.i(220665);
            wt wtVar2 = wtVar;
            Log.i("MicroMsg.ExptReportBanner", "expt report banner callback %s", Integer.valueOf(a.this.hashCode()));
            if (wtVar2 != null) {
                if (!Util.isNullOrNil(wtVar2.edh.edi)) {
                    a.this.show();
                } else {
                    a.this.close();
                }
            }
            AppMethodBeat.o(220665);
            return false;
        }
    };
    TextView vr;

    public a(Context context) {
        super(context);
        AppMethodBeat.i(220666);
        Log.i("MicroMsg.ExptReportBanner", "expt report banner initialize %d", Integer.valueOf(hashCode()));
        EventCenter.instance.add(this.sLP);
        this.oQL = this.view.findViewById(R.id.a24);
        this.sLO = this.view.findViewById(R.id.a28);
        this.vr = (TextView) this.view.findViewById(R.id.g2w);
        this.oQL.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.a.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(220661);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptReportBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f.a aVar = new f.a(MMApplicationContext.getContext());
                aVar.bow("cancel expt debug now!").Dq(true);
                aVar.c(new f.c() {
                    /* class com.tencent.mm.plugin.expt.ui.a.AnonymousClass1.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(220660);
                        if (z) {
                            ((com.tencent.mm.plugin.expt.b.a) g.af(com.tencent.mm.plugin.expt.b.a.class)).cMC();
                        }
                        AppMethodBeat.o(220660);
                    }
                }).b(new DialogInterface.OnDismissListener() {
                    /* class com.tencent.mm.plugin.expt.ui.a.AnonymousClass1.AnonymousClass1 */

                    public final void onDismiss(DialogInterface dialogInterface) {
                    }
                }).show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptReportBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(220661);
            }
        });
        if (com.tencent.mm.plugin.expt.e.a.cRf().cRg()) {
            show();
            AppMethodBeat.o(220666);
            return;
        }
        close();
        AppMethodBeat.o(220666);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.a5e;
    }

    /* access modifiers changed from: package-private */
    public final void show() {
        AppMethodBeat.i(220667);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.expt.ui.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(220662);
                Log.i("MicroMsg.ExptReportBanner", "expt report banner show");
                a.this.vr.setText("expt debug now!!! key=" + com.tencent.mm.plugin.expt.e.a.cRf().sJO);
                a.this.oQL.setVisibility(0);
                a.this.sLO.setVisibility(0);
                AppMethodBeat.o(220662);
            }
        });
        AppMethodBeat.o(220667);
    }

    /* access modifiers changed from: package-private */
    public final void close() {
        AppMethodBeat.i(220668);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.expt.ui.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(220663);
                Log.i("MicroMsg.ExptReportBanner", "expt report banner close");
                a.this.oQL.setVisibility(8);
                a.this.sLO.setVisibility(8);
                AppMethodBeat.o(220663);
            }
        });
        AppMethodBeat.o(220668);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
        AppMethodBeat.i(220669);
        Log.i("MicroMsg.ExptReportBanner", "expt report banner destroy %d", Integer.valueOf(hashCode()));
        EventCenter.instance.removeListener(this.sLP);
        AppMethodBeat.o(220669);
    }
}
