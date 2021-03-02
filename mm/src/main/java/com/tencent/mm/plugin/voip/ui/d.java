package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public final class d {
    public VoipViewFragment HeX;
    private Intent intent;
    private a zTN;
    boolean zTO = false;
    MTimerHandler zTP;

    public final void a(final Intent intent2, final boolean z, final a aVar) {
        AppMethodBeat.i(235778);
        if (aVar == null) {
            Log.e("MicroMsg.VoipVoiceMiniManager", "showMini, VoipMiniCallBack cannot be null!");
            AppMethodBeat.o(235778);
            return;
        }
        this.intent = intent2;
        this.zTN = aVar;
        if (!b.cx(MMApplicationContext.getContext())) {
            Log.e("MicroMsg.VoipVoiceMiniManager", "mini, permission denied");
            Context context = MMApplicationContext.getContext();
            RequestFloatWindowPermissionDialog.a(context, context.getString(R.string.i2r), new RequestFloatWindowPermissionDialog.a() {
                /* class com.tencent.mm.plugin.voip.ui.d.AnonymousClass1 */
                final /* synthetic */ boolean GSR = false;

                @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
                public final void onResultAllow(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                    AppMethodBeat.i(184065);
                    requestFloatWindowPermissionDialog.finish();
                    if (aVar.dZV()) {
                        d.this.a(intent2, z, this.GSR);
                    }
                    AppMethodBeat.o(184065);
                }

                @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
                public final void onResultRefuse(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                    AppMethodBeat.i(184066);
                    requestFloatWindowPermissionDialog.finish();
                    AppMethodBeat.o(184066);
                }

                @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
                public final void onResultCancel(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                    AppMethodBeat.i(185955);
                    requestFloatWindowPermissionDialog.finish();
                    AppMethodBeat.o(185955);
                }
            }, a.apJ());
            AppMethodBeat.o(235778);
            return;
        }
        a(intent2, z, false);
        AppMethodBeat.o(235778);
    }

    /* access modifiers changed from: package-private */
    public final void a(final Intent intent2, boolean z, boolean z2) {
        AppMethodBeat.i(184079);
        Log.i("MicroMsg.VoipVoiceMiniManager", "mini now..");
        if (this.HeX != null) {
            this.zTN.a(intent2, this.HeX.aJ(z, false));
            AppMethodBeat.o(184079);
            return;
        }
        this.HeX = new VoipViewFragment(MMApplicationContext.getContext());
        this.zTO = false;
        if (this.zTP != null) {
            this.zTP.stopTimer();
        }
        this.HeX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.d.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(184069);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                view.setOnClickListener(null);
                com.tencent.mm.plugin.voip.a.a aVar = a.C1887a.GST;
                aVar.oWE.oWs.opType = 3;
                ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).m(aVar.oWE);
                intent2.addFlags(268435456);
                Context context = MMApplicationContext.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                d.this.zTP = new MTimerHandler(new MTimerHandler.CallBack() {
                    /* class com.tencent.mm.plugin.voip.ui.d.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                    public final boolean onTimerExpired() {
                        AppMethodBeat.i(184067);
                        Log.i("MicroMsg.VoipVoiceMiniManager", "click small view and time is up we remove it..");
                        d.this.rX(false);
                        if (d.this.zTP != null) {
                            d.this.zTP.stopTimer();
                        }
                        AppMethodBeat.o(184067);
                        return true;
                    }
                }, false);
                d.this.zTP.startTimer(2000);
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.voip.ui.d.AnonymousClass2.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(184068);
                        d.this.rX(false);
                        AppMethodBeat.o(184068);
                    }
                }, 200);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipMiniViewManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(184069);
            }
        });
        if (z) {
            a.C1887a.GST.a(4, z2, this.HeX);
        } else {
            a.C1887a.GST.a(8, z2, this.HeX);
        }
        this.zTN.a(intent2, this.HeX.aJ(z, false));
        AppMethodBeat.o(184079);
    }

    public final void xv(int i2) {
        AppMethodBeat.i(184080);
        if (this.HeX != null) {
            this.HeX.aGy(String.format("%02d:%02d", Integer.valueOf(i2 / 60), Integer.valueOf(i2 % 60)));
        }
        AppMethodBeat.o(184080);
    }

    public final void aGy(String str) {
        AppMethodBeat.i(235779);
        if (this.HeX != null) {
            this.HeX.aGy(str);
        }
        AppMethodBeat.o(235779);
    }

    public final void aGx(String str) {
        AppMethodBeat.i(184081);
        if (this.HeX != null) {
            this.HeX.aGx(str);
        }
        AppMethodBeat.o(184081);
    }

    public final void eoN() {
        AppMethodBeat.i(184082);
        if (this.HeX != null) {
            this.zTO = true;
            h.RTc.bqo("showIcon");
            h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.voip.ui.d.AnonymousClass3 */

                public final void run() {
                    boolean z;
                    AppMethodBeat.i(184071);
                    if (d.this.HeX != null) {
                        BaseSmallView currentView = d.this.HeX.getCurrentView();
                        if (currentView != null) {
                            z = currentView.eoK();
                        } else {
                            z = false;
                        }
                        if (z) {
                            h.RTc.n(new Runnable() {
                                /* class com.tencent.mm.plugin.voip.ui.d.AnonymousClass3.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(184070);
                                    d.this.rX(true);
                                    AppMethodBeat.o(184070);
                                }
                            }, 2000);
                        }
                    }
                    AppMethodBeat.o(184071);
                }
            });
            AppMethodBeat.o(184082);
            return;
        }
        rX(true);
        AppMethodBeat.o(184082);
    }

    public final void enR() {
        AppMethodBeat.i(235780);
        if (this.HeX != null && !this.zTO) {
            h.RTc.bqo("showIcon");
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.voip.ui.d.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(184073);
                    h.RTc.aV(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.ui.d.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            BaseSmallView currentView;
                            AppMethodBeat.i(184072);
                            if (d.this.HeX == null || d.this.zTO || (currentView = d.this.HeX.getCurrentView()) == null) {
                                AppMethodBeat.o(184072);
                                return;
                            }
                            currentView.enR();
                            AppMethodBeat.o(184072);
                        }
                    });
                    AppMethodBeat.o(184073);
                }
            }, "showIcon");
        }
        AppMethodBeat.o(235780);
    }

    public final void setVoicePlayDevice(final int i2) {
        AppMethodBeat.i(184083);
        if (this.HeX != null && !this.zTO) {
            h.RTc.bqo("showIcon");
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.voip.ui.d.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(184075);
                    h.RTc.aV(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.ui.d.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(184074);
                            if (d.this.HeX != null && !d.this.zTO) {
                                d.this.HeX.setVoicePlayDevice(i2);
                            }
                            AppMethodBeat.o(184074);
                        }
                    });
                    AppMethodBeat.o(184075);
                }
            }, "showIcon");
        }
        AppMethodBeat.o(184083);
    }

    public final void xm(final boolean z) {
        AppMethodBeat.i(235781);
        if (this.HeX != null && !this.zTO) {
            h.RTc.bqo("showIcon");
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.voip.ui.d.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(184077);
                    h.RTc.aV(new Runnable() {
                        /* class com.tencent.mm.plugin.voip.ui.d.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(184076);
                            if (d.this.HeX != null && !d.this.zTO) {
                                VoipViewFragment voipViewFragment = d.this.HeX;
                                boolean z = z;
                                BaseSmallView currentView = voipViewFragment.getCurrentView();
                                if (currentView != null) {
                                    currentView.xm(z);
                                    AppMethodBeat.o(184076);
                                    return;
                                }
                            }
                            AppMethodBeat.o(184076);
                        }
                    });
                    AppMethodBeat.o(184077);
                }
            }, "showIcon");
        }
        AppMethodBeat.o(235781);
    }

    public final void rX(boolean z) {
        AppMethodBeat.i(184084);
        Log.i("MicroMsg.VoipVoiceMiniManager", "dismiss now.. isFinish: %b, smallView: %s", Boolean.valueOf(z), this.HeX);
        if (this.HeX != null) {
            if (z) {
                a.C1887a.GST.b(this.HeX);
            }
            if (this.HeX != null) {
                this.HeX.setOnClickListener(null);
                this.HeX = null;
                AppMethodBeat.o(184084);
                return;
            }
        } else if (z) {
            a.C1887a.GST.cir();
        }
        AppMethodBeat.o(184084);
    }

    public final BaseSmallView aJ(boolean z, boolean z2) {
        AppMethodBeat.i(235782);
        if (this.HeX != null) {
            BaseSmallView aJ = this.HeX.aJ(z, z2);
            AppMethodBeat.o(235782);
            return aJ;
        }
        AppMethodBeat.o(235782);
        return null;
    }
}
