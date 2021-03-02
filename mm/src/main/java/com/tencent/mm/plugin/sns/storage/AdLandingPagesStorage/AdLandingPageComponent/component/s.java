package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.f.c.d;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.e.f;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.statemachine.IState;
import com.tencent.mm.sdk.statemachine.LogStateTransitionState;
import com.tencent.mm.sdk.statemachine.State;
import com.tencent.mm.sdk.statemachine.StateMachine;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public final class s extends p implements Serializable {
    private View EdA;
    Button EdB;
    private SnsTextProgressBar EdC;
    a EdD;
    private HandlerThread EdE;
    private b EdF;
    boolean EdG;
    boolean EdH = true;
    private View.OnClickListener EdI = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(96505);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageDownloadApkBtnComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            s.this.EdD.sendMessage(0);
            s.this.fdw();
            s.this.fdf();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageDownloadApkBtnComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96505);
        }
    };
    AdLandingPagesProxy.e EdJ = new AdLandingPagesProxy.e() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
        public final void bn(Object obj) {
        }

        @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
        public final void h(int i2, int i3, Object obj) {
            AppMethodBeat.i(96506);
            Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", " AdLandingPagesProxy.Callback, errType=" + i2 + ", errNo=" + i3);
            if (i2 == 0 && i3 == 0) {
                xc xcVar = new xc();
                try {
                    xcVar.parseFrom((byte[]) obj);
                } catch (IOException e2) {
                    Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp", Util.stackTraceToString(e2));
                }
                if (!TextUtils.isEmpty(xcVar.KJw)) {
                    Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "opening url " + xcVar.KJw);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", xcVar.KJw);
                    intent.putExtra("showShare", true);
                    c.b(s.this.context, "webview", ".ui.tools.WebViewUI", intent);
                    s.this.EdD.sendMessage(10);
                    AppMethodBeat.o(96506);
                } else if (xcVar.Lik != null) {
                    String str = "";
                    if (s.b(s.this).DXz) {
                        s.b(s.this).DXA = xcVar.Lik.Lie;
                        s.b(s.this).md5 = xcVar.Lik.Lic;
                        s.b(s.this).downloadUrl = xcVar.Lik.Lid;
                        s.b(s.this).fileSize = (long) xcVar.Lik.Lif;
                        str = xcVar.Lik.Lib;
                        if (TextUtils.isEmpty(s.b(s.this).md5) || TextUtils.isEmpty(s.b(s.this).downloadUrl) || s.b(s.this).fileSize == 0) {
                            s.b(s.this).DXz = false;
                            Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState], useGameDownloadWidget, but wxAppInfo is empty");
                        }
                    }
                    if (!s.b(s.this).DXz) {
                        s.b(s.this).DXA = xcVar.Lik.qGA;
                        s.b(s.this).md5 = xcVar.Lik.qHn;
                        s.b(s.this).downloadUrl = xcVar.Lik.LhX;
                        s.b(s.this).fileSize = (long) xcVar.Lik.Lia;
                        str = new StringBuilder().append(xcVar.Lik.LhW).toString();
                    }
                    s.this.EdD.sendMessage(6);
                    Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState] PkgInfoResp, name=" + s.b(s.this).DXA + ", useGameDownloadWidget=" + s.b(s.this).DXz + ", fileSize=" + s.b(s.this).fileSize + ", apkId=" + str + ", url=" + s.b(s.this).downloadUrl);
                    AppMethodBeat.o(96506);
                } else {
                    Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "resp is null");
                    s.this.EdD.sendMessage(5);
                    AppMethodBeat.o(96506);
                }
            } else {
                s.this.EdD.sendMessage(5);
                AppMethodBeat.o(96506);
            }
        }
    };
    String adExtInfo = "";
    String appId = "";
    String dRS = "";
    String uxInfo = "";

    static /* synthetic */ boolean j(s sVar) {
        AppMethodBeat.i(202980);
        boolean fdA = sVar.fdA();
        AppMethodBeat.o(202980);
        return fdA;
    }

    public s(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b bVar, ViewGroup viewGroup) {
        super(context, bVar, viewGroup);
        AppMethodBeat.i(96554);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "component create, new BtnStateMachine");
        this.EdE = d.bqr("apkStateMachine");
        this.EdE.start();
        this.EdD = new a("apkStateMachine", this.EdE.getLooper());
        if (context instanceof Activity) {
            this.EdG = ((Activity) context).getIntent().getBooleanExtra("sns_landing_pages_auto_download_for_action_btn", false);
            this.EdH = true;
            Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "autoDownloadFromActionBtn=" + this.EdG + ", activity=" + context + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).DXN + ", appId=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).dNI + ", wxAppid=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).DXy + ", useGameDownloader=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).DXz + ", pkg=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).LG);
        }
        this.Edn.bo(TPDownloadProxyEnum.USER_PLATFORM, (long) bVar.DXC);
        this.Edn.kv("appid", bVar.dNI);
        this.Edn.kv("channelId", bVar.channelId);
        this.Edn.kv("pkg", bVar.LG);
        this.Edn.kv("appPageUrlAndroid", bVar.appPageUrl);
        try {
            this.appId = Util.nullAsNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).dNI);
            this.uxInfo = Util.nullAsNil(fds().uxInfo);
            this.adExtInfo = Util.nullAsNil(fds().adExtInfo);
            this.dRS = fds().getSnsId();
            AppMethodBeat.o(96554);
        } catch (Throwable th) {
            Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp.DownloadToastReport", th.toString());
            AppMethodBeat.o(96554);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.btw;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(96557);
        super.eWZ();
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "viewWillAppear, sendMsg=2");
        this.EdD.sendMessage(2);
        AdLandingPagesProxy.getInstance().addReportInfo(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).dNI, fds().aid, fds().kZe, fds().uxInfo);
        AppMethodBeat.o(96557);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(96558);
        super.eXd();
        Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "view destroy");
        this.EdE.quit();
        if (this.EdF != null) {
            this.context.unregisterReceiver(this.EdF);
            this.EdF = null;
        }
        AppMethodBeat.o(96558);
    }

    /* access modifiers changed from: package-private */
    public class a extends StateMachine implements Serializable {
        State EdL = new c();
        State EdM = new g();
        State EdN = new e();
        State EdO = new h();
        State EdP = new i();
        State EdQ = new f();
        State EdR = new b();
        State EdS = new C1720a();
        State EdT = new d();

        static /* synthetic */ void A(a aVar, IState iState) {
            AppMethodBeat.i(202970);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202970);
        }

        static /* synthetic */ void B(a aVar, IState iState) {
            AppMethodBeat.i(202971);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202971);
        }

        static /* synthetic */ void C(a aVar, IState iState) {
            AppMethodBeat.i(202972);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202972);
        }

        static /* synthetic */ void D(a aVar, IState iState) {
            AppMethodBeat.i(202973);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202973);
        }

        static /* synthetic */ void E(a aVar, IState iState) {
            AppMethodBeat.i(202974);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202974);
        }

        static /* synthetic */ void F(a aVar, IState iState) {
            AppMethodBeat.i(202975);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202975);
        }

        static /* synthetic */ void G(a aVar, IState iState) {
            AppMethodBeat.i(202976);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202976);
        }

        static /* synthetic */ void H(a aVar, IState iState) {
            AppMethodBeat.i(202977);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202977);
        }

        static /* synthetic */ void I(a aVar, IState iState) {
            AppMethodBeat.i(202978);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202978);
        }

        static /* synthetic */ void a(a aVar, IState iState) {
            AppMethodBeat.i(202940);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202940);
        }

        static /* synthetic */ void b(a aVar, IState iState) {
            AppMethodBeat.i(202941);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202941);
        }

        static /* synthetic */ void c(a aVar, IState iState) {
            AppMethodBeat.i(202942);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202942);
        }

        static /* synthetic */ void d(a aVar, IState iState) {
            AppMethodBeat.i(202943);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202943);
        }

        static /* synthetic */ void e(a aVar, IState iState) {
            AppMethodBeat.i(202944);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202944);
        }

        static /* synthetic */ void f(a aVar, IState iState) {
            AppMethodBeat.i(202945);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202945);
        }

        static /* synthetic */ void g(a aVar, IState iState) {
            AppMethodBeat.i(202946);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202946);
        }

        static /* synthetic */ void h(a aVar, IState iState) {
            AppMethodBeat.i(202947);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202947);
        }

        static /* synthetic */ void i(a aVar, IState iState) {
            AppMethodBeat.i(202950);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202950);
        }

        static /* synthetic */ void j(a aVar, IState iState) {
            AppMethodBeat.i(202951);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202951);
        }

        static /* synthetic */ void k(a aVar, IState iState) {
            AppMethodBeat.i(202952);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202952);
        }

        static /* synthetic */ void l(a aVar, IState iState) {
            AppMethodBeat.i(202955);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202955);
        }

        static /* synthetic */ void m(a aVar, IState iState) {
            AppMethodBeat.i(202956);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202956);
        }

        static /* synthetic */ void n(a aVar, IState iState) {
            AppMethodBeat.i(202957);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202957);
        }

        static /* synthetic */ void o(a aVar, IState iState) {
            AppMethodBeat.i(202958);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202958);
        }

        static /* synthetic */ void p(a aVar, IState iState) {
            AppMethodBeat.i(202959);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202959);
        }

        static /* synthetic */ void q(a aVar, IState iState) {
            AppMethodBeat.i(202960);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202960);
        }

        static /* synthetic */ void r(a aVar, IState iState) {
            AppMethodBeat.i(202961);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202961);
        }

        static /* synthetic */ void s(a aVar, IState iState) {
            AppMethodBeat.i(202962);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202962);
        }

        static /* synthetic */ void t(a aVar, IState iState) {
            AppMethodBeat.i(202963);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202963);
        }

        static /* synthetic */ void u(a aVar, IState iState) {
            AppMethodBeat.i(202964);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202964);
        }

        static /* synthetic */ void v(a aVar, IState iState) {
            AppMethodBeat.i(202965);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202965);
        }

        static /* synthetic */ void w(a aVar, IState iState) {
            AppMethodBeat.i(202966);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202966);
        }

        static /* synthetic */ void x(a aVar, IState iState) {
            AppMethodBeat.i(202967);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202967);
        }

        static /* synthetic */ void y(a aVar, IState iState) {
            AppMethodBeat.i(202968);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202968);
        }

        static /* synthetic */ void z(a aVar, IState iState) {
            AppMethodBeat.i(202969);
            aVar.transitionTo(iState);
            AppMethodBeat.o(202969);
        }

        protected a(String str, Looper looper) {
            super(str, looper);
            AppMethodBeat.i(96551);
            addState(this.EdM);
            addState(this.EdL);
            addState(this.EdN);
            addState(this.EdO);
            addState(this.EdP);
            addState(this.EdQ);
            addState(this.EdR);
            addState(this.EdS);
            addState(this.EdT);
            setInitialState(this.EdT);
            AppMethodBeat.o(96551);
        }

        class d extends LogStateTransitionState {
            d() {
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
            public final void enter() {
                boolean z;
                AppMethodBeat.i(96529);
                super.enter();
                Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "InitState enter, idx=" + s.b(s.this).DXN);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b b2 = s.b(s.this);
                if (b2.DXC == 0 || b2.DXC == 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    a.d(a.this, a.this.EdS);
                    AppMethodBeat.o(96529);
                } else if (AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dNI)) {
                    a.a(a.this, a.this.EdO);
                    AppMethodBeat.o(96529);
                } else if (AdLandingPagesProxy.getInstance().isPkgInstalled(s.b(s.this).LG)) {
                    a.b(a.this, a.this.EdP);
                    AppMethodBeat.o(96529);
                } else {
                    a.c(a.this, a.this.EdR);
                    AppMethodBeat.o(96529);
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s$a$a  reason: collision with other inner class name */
        class C1720a extends LogStateTransitionState {
            C1720a() {
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
            public final void enter() {
                AppMethodBeat.i(96513);
                super.enter();
                Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DisableUnsupportPlatformState enter, idx=" + s.b(s.this).DXN);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.C1720a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(96512);
                        s.this.EdC.setVisibility(8);
                        s.this.EdB.setEnabled(false);
                        s.this.EdB.setText(!TextUtils.isEmpty(s.b(s.this).DXD) ? s.b(s.this).DXD : "暂不支持安卓手机");
                        s.this.EdB.setVisibility(0);
                        com.tencent.mm.plugin.sns.ad.e.f.a(s.this.context, s.b(s.this), s.this.EdB);
                        AppMethodBeat.o(96512);
                    }
                });
                AppMethodBeat.o(96513);
            }
        }

        class g extends LogStateTransitionState {
            g() {
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
            public final void enter() {
                boolean z;
                AppMethodBeat.i(96543);
                super.enter();
                Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToDownloadState enter, idx=" + s.b(s.this).DXN);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.g.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(96537);
                        if (s.this.EdF == null) {
                            s.this.EdF = new b(s.this, (byte) 0);
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                            intentFilter.addDataScheme("package");
                            s.this.context.registerReceiver(s.this.EdF, intentFilter);
                        }
                        AppMethodBeat.o(96537);
                    }
                });
                if (AdLandingPagesProxy.getInstance().isPkgInstalled(s.b(s.this).LG)) {
                    a.e(a.this, a.this.EdP);
                    AppMethodBeat.o(96543);
                } else if (AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dNI)) {
                    a.f(a.this, a.this.EdO);
                    AppMethodBeat.o(96543);
                } else if (AdLandingPagesProxy.getInstance().isDownloading(s.b(s.this).dNI)) {
                    a.g(a.this, a.this.EdL);
                    AppMethodBeat.o(96543);
                } else if (AdLandingPagesProxy.getInstance().isPaused(s.b(s.this).dNI)) {
                    a.h(a.this, a.this.EdN);
                    AppMethodBeat.o(96543);
                } else {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.g.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(96538);
                            s.this.EdC.setVisibility(8);
                            s.this.EdB.setVisibility(0);
                            s.this.EdB.setText(s.b(s.this).title);
                            com.tencent.mm.plugin.sns.ad.e.f.a(s.this.context, s.b(s.this), s.this.EdB);
                            AppMethodBeat.o(96538);
                        }
                    });
                    if (s.this.EdG) {
                        z = s.this.fds().DZX ? s.b(s.this).DXO : s.b(s.this).DXN == 0;
                    } else {
                        z = false;
                    }
                    if (z && s.this.EdH) {
                        s.this.EdH = false;
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.g.AnonymousClass3 */

                            public final void run() {
                                String string;
                                AppMethodBeat.i(96540);
                                try {
                                    double d2 = (double) ((((float) s.b(s.this).fileSize) / 1024.0f) / 1024.0f);
                                    if (d2 > 0.0d) {
                                        String format = String.format("%.1f", Double.valueOf(d2));
                                        string = s.this.context.getString(R.string.h36, s.b(s.this).DXA, format);
                                    } else {
                                        string = s.this.context.getString(R.string.h35, s.b(s.this).DXA);
                                    }
                                    com.tencent.mm.plugin.sns.data.i.a(s.this.dRS, s.this.appId, 0, 0, s.this.uxInfo, s.this.adExtInfo, 1);
                                    com.tencent.mm.ui.base.h.a(s.this.context, string, "", new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.g.AnonymousClass3.AnonymousClass1 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(96539);
                                            s.this.EdD.sendMessage(0);
                                            com.tencent.mm.plugin.sns.data.i.a(s.this.dRS, s.this.appId, 1, 0, s.this.uxInfo, s.this.adExtInfo, 1);
                                            AppMethodBeat.o(96539);
                                        }
                                    }, (DialogInterface.OnClickListener) null);
                                    AppMethodBeat.o(96540);
                                } catch (Exception e2) {
                                    Log.e(LogStateTransitionState.TAG, "showAutoDownloadDialog exp=" + e2.toString());
                                    AppMethodBeat.o(96540);
                                }
                            }
                        }, 800);
                    }
                    AppMethodBeat.o(96543);
                }
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final boolean processMessage(Message message) {
                AppMethodBeat.i(96544);
                Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToDownloadState, msg=" + message.what + ", idx=" + s.b(s.this).DXN);
                Log.i(LogStateTransitionState.TAG, hashCode() + "[ToDownloadState]recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (AdLandingPagesProxy.getInstance().isDownloading(s.b(s.this).dNI)) {
                            a.a(a.this, s.this.context.getString(R.string.h3k));
                        } else {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.g.AnonymousClass4 */

                                public final void run() {
                                    AppMethodBeat.i(96542);
                                    if (s.j(s.this)) {
                                        Log.i(LogStateTransitionState.TAG, "download not in wifi!");
                                        com.tencent.mm.plugin.sns.data.i.a(s.this.dRS, s.this.appId, 0, 0, s.this.uxInfo, s.this.adExtInfo, 1);
                                        com.tencent.mm.ui.base.h.a(s.this.context, (int) R.string.iyr, (int) R.string.iys, new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.g.AnonymousClass4.AnonymousClass1 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(96541);
                                                s.this.EdD.sendMessage(12);
                                                com.tencent.mm.plugin.sns.data.i.a(s.this.dRS, s.this.appId, 1, 0, s.this.uxInfo, s.this.adExtInfo, 1);
                                                com.tencent.mm.modelstat.d.d(10, "AdLandingPageDownloadApkBtnComp_TODOWLOAD_MSG_BTN_CLICK", g.this.hashCode());
                                                AppMethodBeat.o(96541);
                                            }
                                        }, (DialogInterface.OnClickListener) null);
                                        AppMethodBeat.o(96542);
                                        return;
                                    }
                                    int i2 = s.b(s.this).DXP;
                                    Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showDownloadTip = ".concat(String.valueOf(i2)));
                                    if (i2 != 1) {
                                        s.this.EdD.sendMessage(12);
                                        AppMethodBeat.o(96542);
                                    } else if (AdLandingPagesProxy.getInstance().isPaused(s.b(s.this).dNI)) {
                                        a.a(a.this, 1);
                                        AppMethodBeat.o(96542);
                                    } else {
                                        a.a(a.this, 0);
                                        AppMethodBeat.o(96542);
                                    }
                                }
                            });
                        }
                        AppMethodBeat.o(96544);
                        return true;
                    case 3:
                        a.i(a.this, a.this.EdP);
                        AppMethodBeat.o(96544);
                        return true;
                    case 11:
                        a.j(a.this, a.this.EdM);
                        AppMethodBeat.o(96544);
                        return true;
                    case 12:
                        a.k(a.this, a.this.EdL);
                        AppMethodBeat.o(96544);
                        return true;
                    default:
                        AppMethodBeat.o(96544);
                        return false;
                }
            }
        }

        class b extends LogStateTransitionState {
            b() {
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final boolean processMessage(Message message) {
                AppMethodBeat.i(96514);
                Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DoNetSceneState msg=" + message.what + ", idx=" + s.b(s.this).DXN);
                Log.i(LogStateTransitionState.TAG, hashCode() + "[DoNetSceneState]recv msg.what " + message.what);
                if (AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dNI)) {
                    a.l(a.this, a.this.EdO);
                    AppMethodBeat.o(96514);
                    return true;
                }
                switch (message.what) {
                    case 5:
                        a.a(a.this, s.this.context.getString(R.string.h3m));
                        a.n(a.this, a.this.EdQ);
                        AppMethodBeat.o(96514);
                        return true;
                    case 6:
                        a.m(a.this, a.this.EdM);
                        AppMethodBeat.o(96514);
                        return true;
                    case 7:
                    case 8:
                    case 9:
                    default:
                        AppMethodBeat.o(96514);
                        return false;
                    case 10:
                        a.o(a.this, a.this.EdM);
                        AppMethodBeat.o(96514);
                        return true;
                }
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
            public final void enter() {
                AppMethodBeat.i(96515);
                super.enter();
                Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DoNetSceneState enter, idx=" + s.b(s.this).DXN);
                AdLandingPagesProxy.getInstance().doAdChannelScene(s.b(s.this).LG, s.b(s.this).channelId, s.this.EdJ, s.b(s.this).DXz);
                Log.i(LogStateTransitionState.TAG, "[DoNetSceneState], appid=" + s.b(s.this).dNI + ", pkg=" + s.b(s.this).LG + ", channelId=" + s.b(s.this).channelId + ", useGameDownloadWidget=" + s.b(s.this).DXz + ", hash=" + hashCode());
                AppMethodBeat.o(96515);
            }
        }

        class c extends LogStateTransitionState {
            AdLandingPagesProxy.a EdY;

            c() {
            }

            /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s$a$c$a  reason: collision with other inner class name */
            class C1721a implements AdLandingPagesProxy.a {
                private C1721a() {
                }

                /* synthetic */ C1721a(c cVar, byte b2) {
                    this();
                }

                @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a
                public final void start() {
                    AppMethodBeat.i(96520);
                    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "start, idx=" + s.b(s.this).DXN);
                    AppMethodBeat.o(96520);
                }

                @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a
                public final void Yr(int i2) {
                    AppMethodBeat.i(96521);
                    if (i2 % 20 == 0) {
                        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "progress:" + i2 + ", idx=" + s.b(s.this).DXN);
                    }
                    s.this.EdD.sendMessage(1, i2);
                    AppMethodBeat.o(96521);
                }

                @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a
                public final void eZP() {
                    AppMethodBeat.i(96522);
                    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "paused, idx=" + s.b(s.this).DXN);
                    s.this.EdD.sendMessage(7);
                    AppMethodBeat.o(96522);
                }

                @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a
                public final void eZQ() {
                    AppMethodBeat.i(96523);
                    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "stopped, idx=" + s.b(s.this).DXN);
                    AppMethodBeat.o(96523);
                }

                @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a
                public final void eZR() {
                    AppMethodBeat.i(96524);
                    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "succeed, idx=" + s.b(s.this).DXN);
                    s.this.EdD.sendMessage(9);
                    AppMethodBeat.o(96524);
                }

                @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a
                public final void eZS() {
                    AppMethodBeat.i(96525);
                    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "failed, idx=" + s.b(s.this).DXN);
                    s.this.EdD.sendMessage(8);
                    AppMethodBeat.o(96525);
                }

                @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a
                public final void eZT() {
                    AppMethodBeat.i(96526);
                    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "resumed, idx=" + s.b(s.this).DXN);
                    s.this.EdD.sendMessage(13);
                    AppMethodBeat.o(96526);
                }
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
            public final void enter() {
                AppMethodBeat.i(96527);
                super.enter();
                Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DownloadingState enter, idx=" + s.b(s.this).DXN);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.c.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(96516);
                        s.this.EdB.setVisibility(8);
                        s.this.EdC.setVisibility(0);
                        AppMethodBeat.o(96516);
                    }
                });
                if (AdLandingPagesProxy.getInstance().isPaused(s.b(s.this).dNI) || AdLandingPagesProxy.getInstance().isDownloading(s.b(s.this).dNI)) {
                    if (this.EdY == null) {
                        this.EdY = new C1721a(this, (byte) 0);
                    }
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.c.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(96517);
                            s.this.EdC.setProgress(AdLandingPagesProxy.getInstance().getTaskProgress(s.b(s.this).dNI));
                            AppMethodBeat.o(96517);
                        }
                    });
                    if (!AdLandingPagesProxy.getInstance().resumeTask(s.b(s.this).dNI, this.EdY, s.this.fds().aid, s.this.fds().kZe, s.this.fds().uxInfo)) {
                        AdLandingPagesProxy.getInstance().stopTask(s.b(s.this).dNI);
                        a.p(a.this, a.this.EdL);
                        AppMethodBeat.o(96527);
                        return;
                    }
                } else if (TextUtils.isEmpty(s.b(s.this).downloadUrl)) {
                    a.q(a.this, a.this.EdR);
                    AppMethodBeat.o(96527);
                    return;
                } else if (AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dNI)) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.c.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(96518);
                            s.this.EdC.setProgress(100);
                            AppMethodBeat.o(96518);
                        }
                    });
                    a.r(a.this, a.this.EdO);
                    AppMethodBeat.o(96527);
                    return;
                } else {
                    AdLandingPagesProxy.getInstance().stopTask(s.b(s.this).dNI);
                    this.EdY = new C1721a(this, (byte) 0);
                    AdLandingPagesProxy.getInstance().startDownload(s.b(s.this).dNI, s.b(s.this).DXy, s.b(s.this).LG, s.b(s.this).md5, s.b(s.this).downloadUrl, s.b(s.this).DXA, s.b(s.this).DXB, this.EdY, s.this.fds().aid, s.this.fds().kZe, s.this.fds().uxInfo, s.b(s.this).DXz);
                }
                AppMethodBeat.o(96527);
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final boolean processMessage(Message message) {
                AppMethodBeat.i(96528);
                if (message.what != 1) {
                    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DownloadingState, msg=" + message.what + ", idx=" + s.b(s.this).DXN);
                }
                Log.i(LogStateTransitionState.TAG, hashCode() + "[DownloadingState] recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (AdLandingPagesProxy.getInstance().pauseTask(s.b(s.this).dNI) && AdLandingPagesProxy.getInstance().isPaused(s.b(s.this).dNI)) {
                            a.s(a.this, a.this.EdN);
                        }
                        AppMethodBeat.o(96528);
                        return true;
                    case 1:
                        final int i2 = message.arg1;
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.c.AnonymousClass4 */

                            public final void run() {
                                AppMethodBeat.i(96519);
                                if (i2 >= 0) {
                                    s.this.EdC.setProgress(i2);
                                }
                                AppMethodBeat.o(96519);
                            }
                        });
                        AppMethodBeat.o(96528);
                        return true;
                    case 2:
                    case 4:
                    case 5:
                    case 6:
                    default:
                        AppMethodBeat.o(96528);
                        return false;
                    case 3:
                        a.t(a.this, a.this.EdP);
                        AppMethodBeat.o(96528);
                        return true;
                    case 7:
                        a.u(a.this, a.this.EdN);
                        AppMethodBeat.o(96528);
                        return true;
                    case 8:
                        a.a(a.this, s.this.context.getString(R.string.h3m));
                        a.v(a.this, a.this.EdQ);
                        AppMethodBeat.o(96528);
                        return true;
                    case 9:
                        s.this.fdz();
                        a.w(a.this, a.this.EdO);
                        AppMethodBeat.o(96528);
                        return true;
                }
            }
        }

        class e extends LogStateTransitionState {
            e() {
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
            public final void enter() {
                AppMethodBeat.i(96532);
                super.enter();
                Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "PauseState enter, idx=" + s.b(s.this).DXN);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.e.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(96530);
                        s.this.EdC.setVisibility(8);
                        s.this.EdB.setVisibility(0);
                        s.this.EdB.setText(R.string.h3l);
                        com.tencent.mm.plugin.sns.ad.e.f.a(s.this.context, s.b(s.this), s.this.EdB);
                        AppMethodBeat.o(96530);
                    }
                });
                AppMethodBeat.o(96532);
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final boolean processMessage(Message message) {
                AppMethodBeat.i(96533);
                Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "PauseState, msg=" + message.what + ", idx=" + s.b(s.this).DXN);
                Log.i(LogStateTransitionState.TAG, hashCode() + "[PauseState] recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (AdLandingPagesProxy.getInstance().isDownloading(s.b(s.this).dNI)) {
                            a.a(a.this, s.this.context.getString(R.string.h3k));
                        } else if (s.this.fdA()) {
                            Log.i(LogStateTransitionState.TAG, "download not in wifi!");
                            com.tencent.mm.plugin.sns.data.i.a(s.this.dRS, s.this.appId, 0, 1, s.this.uxInfo, s.this.adExtInfo, 1);
                            com.tencent.mm.ui.base.h.a(s.this.context, (int) R.string.iyr, (int) R.string.iys, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.e.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(96531);
                                    a.this.sendMessage(12);
                                    com.tencent.mm.plugin.sns.data.i.a(s.this.dRS, s.this.appId, 1, 1, s.this.uxInfo, s.this.adExtInfo, 1);
                                    com.tencent.mm.modelstat.d.d(10, "AdLandingPageDownloadApkBtnComp_PAUSE_MSG_BTN_CLICK", e.this.hashCode());
                                    AppMethodBeat.o(96531);
                                }
                            }, (DialogInterface.OnClickListener) null);
                        } else {
                            int i2 = s.b(s.this).DXP;
                            Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showDownloadTip = ".concat(String.valueOf(i2)));
                            if (i2 == 1) {
                                a.a(a.this, 1);
                            } else {
                                a.this.sendMessage(12);
                            }
                        }
                        AppMethodBeat.o(96533);
                        return true;
                    case 3:
                        a.x(a.this, a.this.EdP);
                        AppMethodBeat.o(96533);
                        return true;
                    case 8:
                        a.a(a.this, s.this.context.getString(R.string.h3m));
                        a.y(a.this, a.this.EdQ);
                        AppMethodBeat.o(96533);
                        return true;
                    case 12:
                        a.z(a.this, a.this.EdL);
                        AppMethodBeat.o(96533);
                        return true;
                    case 13:
                        a.A(a.this, a.this.EdL);
                        AppMethodBeat.o(96533);
                        return true;
                    default:
                        AppMethodBeat.o(96533);
                        return false;
                }
            }
        }

        class h extends LogStateTransitionState {
            private boolean Eef;

            h() {
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
            public final void enter() {
                AppMethodBeat.i(96546);
                Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToInstallState enter, idx=" + s.b(s.this).DXN);
                super.enter();
                if (!AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dNI)) {
                    a.B(a.this, a.this.EdM);
                    AppMethodBeat.o(96546);
                    return;
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.h.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(96545);
                        s.this.EdC.setVisibility(8);
                        s.this.EdB.setVisibility(0);
                        s.this.EdB.setText(R.string.h3n);
                        com.tencent.mm.plugin.sns.ad.e.f.a(s.this.context, s.b(s.this), s.this.EdB);
                        AppMethodBeat.o(96545);
                    }
                });
                this.Eef = true;
                AppMethodBeat.o(96546);
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final boolean processMessage(Message message) {
                AppMethodBeat.i(96547);
                Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToInstallState, msg=" + message.what + ", idx=" + s.b(s.this).DXN);
                Log.i(LogStateTransitionState.TAG, hashCode() + "[ToInstallState] recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (AdLandingPagesProxy.getInstance().installApp(s.this.context, s.b(s.this).dNI, s.b(s.this).LG, s.b(s.this).md5, s.b(s.this).downloadUrl)) {
                            this.Eef = true;
                            AppMethodBeat.o(96547);
                            return true;
                        }
                        a.a(a.this, s.this.context.getString(R.string.h3o));
                        a.C(a.this, a.this.EdQ);
                        AppMethodBeat.o(96547);
                        return true;
                    case 1:
                    default:
                        AppMethodBeat.o(96547);
                        return false;
                    case 2:
                        if (!AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dNI)) {
                            a.D(a.this, a.this.EdM);
                        }
                        AppMethodBeat.o(96547);
                        return true;
                    case 3:
                        if (this.Eef) {
                            this.Eef = false;
                        }
                        a.E(a.this, a.this.EdP);
                        AppMethodBeat.o(96547);
                        return true;
                }
            }
        }

        class i extends LogStateTransitionState {
            i() {
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
            public final void enter() {
                AppMethodBeat.i(96549);
                super.enter();
                Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToOpenState enter, idx=" + s.b(s.this).DXN);
                if (AdLandingPagesProxy.getInstance().isPkgInstalled(s.b(s.this).LG)) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.i.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(96548);
                            s.this.EdC.setVisibility(8);
                            s.this.EdB.setVisibility(0);
                            s.this.EdB.setText(R.string.h3p);
                            com.tencent.mm.plugin.sns.ad.e.f.a(s.this.context, s.b(s.this), s.this.EdB);
                            AppMethodBeat.o(96548);
                        }
                    });
                    AppMethodBeat.o(96549);
                    return;
                }
                a.F(a.this, a.this.EdO);
                AppMethodBeat.o(96549);
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final boolean processMessage(Message message) {
                AppMethodBeat.i(96550);
                Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToOpenState, msg=" + message.what + ", idx=" + s.b(s.this).DXN);
                Log.i(LogStateTransitionState.TAG, hashCode() + "[ToOpenState] recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (k.a(s.this.context, s.b(s.this).dNI, s.b(s.this).LG, "", s.b(s.this).appPageUrl, s.this.uxInfo, s.this.adExtInfo, s.this.dRS, 1, 2)) {
                            AppMethodBeat.o(96550);
                            return true;
                        }
                        a.a(a.this, s.this.context.getString(R.string.h3q));
                        a.G(a.this, a.this.EdP);
                        AppMethodBeat.o(96550);
                        return true;
                    case 4:
                        a.H(a.this, a.this.EdM);
                        AppMethodBeat.o(96550);
                        return true;
                    default:
                        AppMethodBeat.o(96550);
                        return false;
                }
            }
        }

        class f extends LogStateTransitionState {
            f() {
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.LogStateTransitionState, com.tencent.mm.sdk.statemachine.IState
            public final void enter() {
                AppMethodBeat.i(96535);
                super.enter();
                Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ReDownloadState enter, idx=" + s.b(s.this).DXN);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.f.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(96534);
                        s.this.EdC.setVisibility(8);
                        s.this.EdB.setVisibility(0);
                        s.this.EdB.setText(R.string.h3r);
                        com.tencent.mm.plugin.sns.ad.e.f.a(s.this.context, s.b(s.this), s.this.EdB);
                        AppMethodBeat.o(96534);
                    }
                });
                AppMethodBeat.o(96535);
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final boolean processMessage(Message message) {
                AppMethodBeat.i(96536);
                Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ReDownloadState, msg=" + message.what + ", idx=" + s.b(s.this).DXN);
                Log.i(LogStateTransitionState.TAG, hashCode() + "[ReDownloadState] recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        a.I(a.this, a.this.EdR);
                        AppMethodBeat.o(96536);
                        return true;
                    default:
                        AppMethodBeat.o(96536);
                        return false;
                }
            }
        }

        static /* synthetic */ void a(a aVar, final String str) {
            AppMethodBeat.i(202948);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(179128);
                    com.tencent.mm.ui.base.h.cD(s.this.context, str);
                    AppMethodBeat.o(179128);
                }
            });
            AppMethodBeat.o(202948);
        }

        static /* synthetic */ void a(a aVar, final int i2) {
            AppMethodBeat.i(202949);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(96511);
                    try {
                        String a2 = a.a(a.this, i2, (double) ((((float) s.b(s.this).fileSize) / 1024.0f) / 1024.0f));
                        a.a(a.this, i2, 0);
                        com.tencent.mm.ui.base.h.a(s.this.context, a2, "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s.a.AnonymousClass1.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(179127);
                                a.this.sendMessage(12);
                                a.a(a.this, i2, 1);
                                AppMethodBeat.o(179127);
                            }
                        }, (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(96511);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showGroceryDownload exp=" + e2.toString());
                        AppMethodBeat.o(96511);
                    }
                }
            });
            AppMethodBeat.o(202949);
        }

        static /* synthetic */ String a(a aVar, int i2, double d2) {
            AppMethodBeat.i(202953);
            String str = "";
            String str2 = s.b(s.this).DXA;
            switch (i2) {
                case 0:
                    if (!Util.isNullOrNil(str2)) {
                        if (d2 <= 0.0d) {
                            str = s.this.context.getString(R.string.h35, str2);
                            break;
                        } else {
                            String format = String.format("%.1f", Double.valueOf(d2));
                            str = s.this.context.getString(R.string.h36, str2, format);
                            break;
                        }
                    } else {
                        str = s.this.context.getString(R.string.h34);
                        break;
                    }
                case 1:
                    if (!Util.isNullOrNil(str2)) {
                        str = s.this.context.getString(R.string.h3_, str2);
                        break;
                    } else {
                        str = s.this.context.getString(R.string.h39);
                        break;
                    }
            }
            AppMethodBeat.o(202953);
            return str;
        }

        static /* synthetic */ void a(a aVar, int i2, int i3) {
            AppMethodBeat.i(202954);
            switch (i2) {
                case 0:
                    if (i3 == 0) {
                        com.tencent.mm.plugin.sns.data.i.a(s.this.dRS, s.this.appId, 0, 0, s.this.uxInfo, s.this.adExtInfo, 1);
                        AppMethodBeat.o(202954);
                        return;
                    } else if (i3 == 1) {
                        com.tencent.mm.plugin.sns.data.i.a(s.this.dRS, s.this.appId, 1, 0, s.this.uxInfo, s.this.adExtInfo, 1);
                        AppMethodBeat.o(202954);
                        return;
                    }
                    break;
                case 1:
                    if (i3 != 0) {
                        if (i3 == 1) {
                            com.tencent.mm.plugin.sns.data.i.a(s.this.dRS, s.this.appId, 1, 1, s.this.uxInfo, s.this.adExtInfo, 1);
                            break;
                        }
                    } else {
                        com.tencent.mm.plugin.sns.data.i.a(s.this.dRS, s.this.appId, 0, 1, s.this.uxInfo, s.this.adExtInfo, 1);
                        AppMethodBeat.o(202954);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(202954);
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends BroadcastReceiver implements Serializable {
        private b() {
        }

        /* synthetic */ b(s sVar, byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(96553);
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (!TextUtils.isEmpty(schemeSpecificPart) && schemeSpecificPart.equals(s.b(s.this).LG)) {
                        s.this.EdD.sendMessage(3);
                    }
                    AppMethodBeat.o(96553);
                    return;
                } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    String schemeSpecificPart2 = intent.getData().getSchemeSpecificPart();
                    if (!TextUtils.isEmpty(schemeSpecificPart2) && schemeSpecificPart2.equals(s.b(s.this).LG)) {
                        s.this.EdD.sendMessage(4);
                    }
                }
            }
            AppMethodBeat.o(96553);
        }
    }

    public final void fdz() {
        AppMethodBeat.i(96560);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "writing deferred deep link");
        AdLandingPagesProxy.getInstance().writeDeferredDeepLink(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).LG, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).appPageUrl);
        k.jZ(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).LG, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).appPageUrl);
        AppMethodBeat.o(96560);
    }

    private static String kt(String str, String str2) {
        AppMethodBeat.i(96561);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(96561);
            return str2;
        } else if (str.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?")) {
            AppMethodBeat.o(96561);
            return str;
        } else {
            AppMethodBeat.o(96561);
            return str2;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean fdA() {
        AppMethodBeat.i(202979);
        try {
            boolean isWifi = NetStatusUtil.isWifi(this.context);
            boolean isFreeSimCard = AdLandingPagesProxy.getInstance().isFreeSimCard();
            Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "isNeedShowNetworkTip, isWifi=" + isWifi + ", isFreeSimCard=" + isFreeSimCard);
            if (isWifi) {
                h.INSTANCE.dN(1612, 2);
            } else if (isFreeSimCard) {
                h.INSTANCE.dN(1612, 3);
            } else {
                h.INSTANCE.dN(1612, 4);
            }
            if (isWifi || isFreeSimCard) {
                AppMethodBeat.o(202979);
                return false;
            }
            AppMethodBeat.o(202979);
            return true;
        } catch (Throwable th) {
            Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "isNeedShowNetworkTip exp=" + th.toString());
            AppMethodBeat.o(202979);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96555);
        HashMap hashMap = new HashMap();
        hashMap.put("fontNormalColor", kt(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).DXK, "#FFFFFF"));
        hashMap.put("fontDisableColor", kt(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).DXL, "#4CFFFFFF"));
        hashMap.put("fontPressedColor", kt(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).DXM, "#99FFFFFF"));
        hashMap.put("NormalColor", kt(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).DXE, "#1AAD19"));
        hashMap.put("PressedColor", kt(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).DXG, "#179B16"));
        hashMap.put("DisableColor", kt(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).DXF, "#661AAD19"));
        hashMap.put("borderNormalColor", kt(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).DXH, "#179E16"));
        hashMap.put("borderPressedColor", kt(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).DXJ, "#158E14"));
        hashMap.put("borderDisableColor", kt(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).DXI, "#00179E16"));
        int parseColor = Color.parseColor((String) hashMap.get("fontNormalColor"));
        int parseColor2 = Color.parseColor((String) hashMap.get("fontDisableColor"));
        int parseColor3 = Color.parseColor((String) hashMap.get("fontPressedColor"));
        int parseColor4 = Color.parseColor((String) hashMap.get("NormalColor"));
        int parseColor5 = Color.parseColor((String) hashMap.get("PressedColor"));
        int parseColor6 = Color.parseColor((String) hashMap.get("DisableColor"));
        int i2 = (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).DYu;
        int parseColor7 = Color.parseColor((String) hashMap.get("borderNormalColor"));
        int parseColor8 = Color.parseColor((String) hashMap.get("borderPressedColor"));
        int parseColor9 = Color.parseColor((String) hashMap.get("borderDisableColor"));
        int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen.a0);
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).tt > 0.0f) {
            dimensionPixelSize = (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).tt;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable.setColor(parseColor6);
        gradientDrawable.setStroke(i2, parseColor9);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable2.setColor(parseColor5);
        gradientDrawable2.setStroke(i2, parseColor8);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable3.setColor(parseColor4);
        gradientDrawable3.setStroke(i2, parseColor7);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, gradientDrawable);
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[]{16842910}, gradientDrawable3);
        this.EdB.setBackground(stateListDrawable);
        int[] iArr = {parseColor2, parseColor3, parseColor};
        this.EdB.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842919}, new int[]{16842910}}, iArr));
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).fontSize > 0.0f) {
            this.EdB.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).fontSize);
        }
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setShape(0);
        gradientDrawable4.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable4.setColor(parseColor5);
        gradientDrawable4.setStroke(i2, parseColor8);
        GradientDrawable gradientDrawable5 = new GradientDrawable();
        gradientDrawable5.setShape(0);
        gradientDrawable5.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable5.setColor(parseColor4);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable5, 3, 1);
        GradientDrawable gradientDrawable6 = new GradientDrawable();
        gradientDrawable6.setShape(0);
        gradientDrawable6.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable6.setColor(parseColor4);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable4, clipDrawable, new ClipDrawable(gradientDrawable6, 3, 1)});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        this.EdC.setProgressDrawable(layerDrawable);
        this.EdC.setPaintColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).DXM);
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).height > 0.0f) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.EdA.getLayoutParams();
            layoutParams.height = (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).height;
            this.EdA.setLayoutParams(layoutParams);
        }
        this.EdB.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX).title);
        f.a(this.context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX, this.EdB);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "fillItem, sendMsg=11");
        this.EdD.sendMessage(11);
        AppMethodBeat.o(96555);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    @TargetApi(17)
    public final void eXe() {
        AppMethodBeat.i(96556);
        this.clickCount = 0;
        View view = this.contentView;
        this.EdA = view.findViewById(R.id.bus);
        this.EdB = (Button) view.findViewById(R.id.bto);
        this.EdB.setOnClickListener(this.EdI);
        this.EdC = (SnsTextProgressBar) view.findViewById(R.id.bud);
        this.EdC.setProgress(0);
        this.EdC.setVisibility(8);
        this.EdC.setOnClickListener(this.EdI);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "createView, BtnStateMachine start");
        this.EdD.start();
        try {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.EcX;
            if (bVar.DXQ > 0) {
                if (com.tencent.mm.plugin.sns.device.appstore.a.aU(bVar.DXR)) {
                    l.a(fds(), 4, AppEventsConstants.EVENT_PARAM_VALUE_NO, "");
                } else {
                    l.a(fds(), 4, "1", "");
                }
                l.a(fds(), 1, "1", "");
            }
            AppMethodBeat.o(96556);
        } catch (Exception e2) {
            Log.w("MicroMsg.AdLandingPageDownloadApkBtnComp", "report19790 has something wrong");
            AppMethodBeat.o(96556);
        }
    }

    static /* synthetic */ com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b b(s sVar) {
        return (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) sVar.EcX;
    }
}
