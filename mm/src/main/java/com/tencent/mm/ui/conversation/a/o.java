package com.tencent.mm.ui.conversation.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.GreenManUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.ar;

public final class o extends b {
    private static final String DaV = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2j) + "/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s");
    private int GrC = 0;
    private TextView QiB;
    private TextView QiC;
    private ImageView QiD;
    private ImageView QiE;
    private ImageView QiF;
    private ProgressBar QiG;
    private String QiH;
    private boolean QiI = false;
    private int QiJ;
    private boolean QiK;
    private boolean QiL;
    private boolean QiM;
    private String QiN;
    private MTimerHandler QiO;
    private IListener<nk> QiP;
    private boolean QiQ = false;
    private ProgressDialog gtM = null;
    private TextView jBR;
    private TextView jVO;
    private boolean jcC = false;
    private TextView knK;
    private ImageView nnL;
    private View sc = null;

    static /* synthetic */ void a(o oVar) {
        AppMethodBeat.i(234285);
        oVar.gWm();
        AppMethodBeat.o(234285);
    }

    static {
        AppMethodBeat.i(234288);
        AppMethodBeat.o(234288);
    }

    public o(Context context) {
        super(context);
        AppMethodBeat.i(38844);
        initialize();
        AppMethodBeat.o(38844);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.bfl;
    }

    private void initialize() {
        AppMethodBeat.i(38845);
        if (!this.QiI && this.view != null) {
            this.sc = this.view.findViewById(R.id.g32);
            this.jVO = (TextView) this.view.findViewById(R.id.g2x);
            this.jBR = (TextView) this.view.findViewById(R.id.g2y);
            this.knK = (TextView) this.view.findViewById(R.id.g2z);
            this.QiB = (TextView) this.view.findViewById(R.id.g2w);
            this.QiG = (ProgressBar) this.view.findViewById(R.id.g31);
            this.nnL = (ImageView) this.view.findViewById(R.id.g30);
            this.QiD = (ImageView) this.view.findViewById(R.id.b4d);
            this.QiE = (ImageView) this.view.findViewById(R.id.d9f);
            this.QiF = (ImageView) this.view.findViewById(R.id.hs6);
            this.QiC = (TextView) this.view.findViewById(R.id.c34);
            this.QiD.setVisibility(8);
            this.QiI = true;
        }
        AppMethodBeat.o(38845);
    }

    private void gWm() {
        AppMethodBeat.i(38846);
        if (this.QiO != null) {
            this.QiO.stopTimer();
            this.QiO = null;
        }
        AppMethodBeat.o(38846);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final boolean bYa() {
        boolean z;
        boolean z2 = true;
        int i2 = 0;
        AppMethodBeat.i(38847);
        int aYS = bg.azz().aYS();
        this.QiH = String.format(DaV, "0x" + Integer.toHexString(d.KyO), d.ics, z.aTY(), bg.azz().getNetworkServerIp(), LocaleUtil.getApplicationLanguage());
        initialize();
        Log.i("MicroMsg.NetWarnView", "update st:%d", Integer.valueOf(aYS));
        switch (aYS) {
            case 0:
                this.jVO.setText(R.string.fbd);
                this.jBR.setVisibility(8);
                this.QiB.setVisibility(8);
                this.QiG.setVisibility(8);
                this.nnL.setVisibility(0);
                this.sc.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.conversation.a.o.AnonymousClass3 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(38837);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Intent intent = new Intent();
                        intent.putExtra("title", ((Context) o.this.Kgr.get()).getString(R.string.fbd));
                        intent.putExtra("rawUrl", ((Context) o.this.Kgr.get()).getString(R.string.fba));
                        intent.putExtra("neverGetA8Key", true);
                        intent.putExtra("showShare", false);
                        c.b((Context) o.this.Kgr.get(), "webview", ".ui.tools.WebViewUI", intent);
                        a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(38837);
                    }
                });
                z = true;
                break;
            case 1:
            case 4:
            default:
                z = false;
                break;
            case 2:
                if (this.GrC == 1) {
                    this.jVO.setText(((Context) this.Kgr.get()).getResources().getString(R.string.fbc, Integer.valueOf(this.QiJ)));
                } else {
                    this.jVO.setText(R.string.fbb);
                }
                this.jBR.setVisibility(8);
                this.QiB.setVisibility(8);
                this.QiG.setVisibility(8);
                this.nnL.setVisibility(0);
                this.sc.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.conversation.a.o.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(38838);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        o.c(o.this, o.this.GrC);
                        o.this.GrC = 1;
                        if (o.this.QiP == null) {
                            o.n(o.this);
                        }
                        if (o.this.QiO == null) {
                            o.p(o.this);
                        }
                        a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(38838);
                    }
                });
                z = true;
                break;
            case 3:
                this.jVO.setText(R.string.fb_);
                this.jBR.setVisibility(8);
                this.QiB.setVisibility(8);
                this.QiG.setVisibility(0);
                this.nnL.setVisibility(0);
                z = true;
                break;
            case 5:
                this.jVO.setText(R.string.fbe);
                this.jBR.setText(((Context) this.Kgr.get()).getString(R.string.fbf));
                this.jBR.setVisibility(0);
                this.QiB.setVisibility(8);
                this.QiG.setVisibility(8);
                this.nnL.setVisibility(0);
                this.sc.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.conversation.a.o.AnonymousClass5 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(38839);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (!Util.jump((Context) o.this.Kgr.get(), o.this.QiH)) {
                            Intent intent = new Intent();
                            intent.putExtra("title", ((Context) o.this.Kgr.get()).getString(R.string.fbg));
                            intent.putExtra("rawUrl", ((Context) o.this.Kgr.get()).getString(R.string.fba));
                            intent.putExtra("showShare", false);
                            c.b((Context) o.this.Kgr.get(), "webview", ".ui.tools.WebViewUI", intent);
                        }
                        a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(38839);
                    }
                });
                z = true;
                break;
        }
        ((Context) this.Kgr.get()).getResources().getColor(R.color.BW_50);
        if (z) {
            this.knK.setVisibility(8);
            this.jVO.setVisibility(0);
            this.sc.setBackgroundResource(R.drawable.azp);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.nnL.getLayoutParams());
            layoutParams.setMargins(com.tencent.mm.cb.a.fromDPToPix((Context) this.Kgr.get(), 28), 0, com.tencent.mm.cb.a.fromDPToPix((Context) this.Kgr.get(), 24), 0);
            this.nnL.setLayoutParams(layoutParams);
            if (q(this.nnL.getTag(), R.raw.icons_filled_error)) {
                this.nnL.setTag(Integer.valueOf((int) R.raw.icons_filled_error));
                this.nnL.setImageDrawable(ar.m((Context) this.Kgr.get(), R.raw.icons_filled_error, ((Context) this.Kgr.get()).getResources().getColor(R.color.Red)));
            }
            this.QiE.setVisibility(8);
            this.QiF.setVisibility(8);
            this.QiC.setVisibility(8);
        }
        if (!z) {
            this.QiD.setVisibility(8);
            if (ac.jNV) {
                final int backgroundLimitType = NetStatusUtil.getBackgroundLimitType((Context) this.Kgr.get());
                if (!NetStatusUtil.isLimited(backgroundLimitType) || this.QiQ) {
                    this.QiD.setVisibility(8);
                    z2 = z;
                } else {
                    this.jVO.setText(((Context) this.Kgr.get()).getString(R.string.fpg));
                    this.jBR.setText(((Context) this.Kgr.get()).getString(R.string.fpf));
                    this.jBR.setVisibility(0);
                    this.QiB.setVisibility(8);
                    this.QiG.setVisibility(8);
                    this.nnL.setVisibility(0);
                    this.QiD.setVisibility(0);
                    this.sc.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.ui.conversation.a.o.AnonymousClass6 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(38840);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            try {
                                NetStatusUtil.startSettingItent((Context) o.this.Kgr.get(), backgroundLimitType);
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.NetWarnView", e2, "", new Object[0]);
                            }
                            a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(38840);
                        }
                    });
                    this.QiD.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.ui.conversation.a.o.AnonymousClass7 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(38843);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/ui/conversation/banner/NetWarnBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            MMAppMgr.a((Context) o.this.Kgr.get(), backgroundLimitType, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.conversation.a.o.AnonymousClass7.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(38841);
                                    try {
                                        o.this.sc.setVisibility(8);
                                        o.this.QiQ = true;
                                        NetStatusUtil.startSettingItent((Context) o.this.Kgr.get(), backgroundLimitType);
                                        AppMethodBeat.o(38841);
                                    } catch (Exception e2) {
                                        Log.printErrStackTrace("MicroMsg.NetWarnView", e2, "", new Object[0]);
                                        AppMethodBeat.o(38841);
                                    }
                                }
                            }, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.conversation.a.o.AnonymousClass7.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(38842);
                                    o.this.sc.setVisibility(8);
                                    o.this.QiQ = true;
                                    AppMethodBeat.o(38842);
                                }
                            });
                            a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(38843);
                        }
                    });
                }
                z = z2;
            }
        }
        if (q(this.QiF.getTag(), R.raw.chat_mute_notify_normal)) {
            this.QiF.setTag(Integer.valueOf((int) R.raw.chat_mute_notify_normal));
            this.QiF.setImageResource(R.raw.chat_mute_notify_normal);
        }
        if (q(this.QiD.getTag(), R.raw.chat_mute_notify_normal)) {
            this.QiD.setTag(Integer.valueOf((int) R.raw.chat_mute_notify_normal));
            this.QiD.setImageResource(R.drawable.jb);
        }
        View view = this.sc;
        if (!z) {
            i2 = 8;
        }
        view.setVisibility(i2);
        AppMethodBeat.o(38847);
        return z;
    }

    private static boolean q(Object obj, int i2) {
        AppMethodBeat.i(38848);
        if (obj == null) {
            AppMethodBeat.o(38848);
            return true;
        } else if (((Integer) obj).intValue() != i2) {
            AppMethodBeat.o(38848);
            return true;
        } else {
            AppMethodBeat.o(38848);
            return false;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
        AppMethodBeat.i(38849);
        gWm();
        if (this.QiP != null) {
            EventCenter.instance.removeListener(this.QiP);
        }
        AppMethodBeat.o(38849);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void setVisibility(int i2) {
        AppMethodBeat.i(38850);
        if (this.sc != null) {
            this.sc.setVisibility(i2);
        }
        AppMethodBeat.o(38850);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getOrder() {
        return 4;
    }

    static /* synthetic */ void c(o oVar, int i2) {
        AppMethodBeat.i(38851);
        Intent intent = new Intent();
        intent.putExtra("diagnose_state", i2);
        intent.putExtra("diagnose_percent", oVar.QiJ);
        intent.putExtra("diagnose_kvInfo", oVar.QiN);
        Log.i("MicroMsg.NetWarnView", "put state: %d, process: %d, kv: %s", Integer.valueOf(i2), Integer.valueOf(oVar.QiJ), oVar.QiN);
        c.b((Context) oVar.Kgr.get(), "traceroute", ".ui.NetworkDiagnoseAllInOneUI", intent);
        AppMethodBeat.o(38851);
    }

    static /* synthetic */ void n(o oVar) {
        AppMethodBeat.i(234286);
        oVar.QiP = new IListener<nk>() {
            /* class com.tencent.mm.ui.conversation.a.o.AnonymousClass1 */

            {
                AppMethodBeat.i(161578);
                this.__eventId = nk.class.getName().hashCode();
                AppMethodBeat.o(161578);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(nk nkVar) {
                boolean z = true;
                AppMethodBeat.i(38835);
                nk nkVar2 = nkVar;
                Log.v("MicroMsg.NetWarnView", "diagnose callback, stage:%d, status:%d", Integer.valueOf(nkVar2.dTy.dTz), Integer.valueOf(nkVar2.dTy.status));
                if (nkVar2.dTy.dTz == 0) {
                    o.this.QiJ = 33;
                    o oVar = o.this;
                    if (nkVar2.dTy.status != 0) {
                        z = false;
                    }
                    oVar.QiK = z;
                } else if (nkVar2.dTy.dTz == 1) {
                    o.this.QiJ = 66;
                    o oVar2 = o.this;
                    if (nkVar2.dTy.status != 0) {
                        z = false;
                    }
                    oVar2.QiL = z;
                } else if (nkVar2.dTy.dTz == 2) {
                    o oVar3 = o.this;
                    if (nkVar2.dTy.status != 0) {
                        z = false;
                    }
                    oVar3.QiM = z;
                }
                if (nkVar2.dTy.dTA) {
                    o.this.QiJ = 0;
                    o.this.GrC = 0;
                    o.this.QiN = nkVar2.dTy.dTB;
                    o.a(o.this);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.ui.conversation.a.o.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            int i2;
                            AppMethodBeat.i(38833);
                            String topActivityName = GreenManUtil.getTopActivityName((Context) o.this.Kgr.get());
                            Log.i("MicroMsg.NetWarnView", "curr top activity is: %s", topActivityName);
                            if (!topActivityName.endsWith("NetworkDiagnoseAllInOneUI")) {
                                if (o.this.QiK) {
                                    i2 = 2;
                                } else if (o.this.QiL) {
                                    i2 = 4;
                                } else if (o.this.QiM) {
                                    i2 = 5;
                                } else {
                                    i2 = 3;
                                }
                                o.c(o.this, i2);
                            }
                            AppMethodBeat.o(38833);
                        }
                    });
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.conversation.a.o.AnonymousClass1.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(38834);
                        o.this.bYa();
                        AppMethodBeat.o(38834);
                    }
                });
                AppMethodBeat.o(38835);
                return false;
            }
        };
        EventCenter.instance.add(oVar.QiP);
        AppMethodBeat.o(234286);
    }

    static /* synthetic */ void p(o oVar) {
        AppMethodBeat.i(234287);
        oVar.QiO = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.ui.conversation.a.o.AnonymousClass2 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(38836);
                o.this.QiJ++;
                Log.v("MicroMsg.NetWarnView", "timer fired, percent:%d", Integer.valueOf(o.this.QiJ));
                if (o.this.QiJ > 99) {
                    AppMethodBeat.o(38836);
                    return false;
                }
                if (o.this.GrC == 1) {
                    o.this.jVO.setText(((Context) o.this.Kgr.get()).getResources().getString(R.string.fbc, Integer.valueOf(o.this.QiJ)));
                }
                AppMethodBeat.o(38836);
                return true;
            }
        }, true);
        oVar.QiO.startTimer(1000);
        AppMethodBeat.o(234287);
    }
}
