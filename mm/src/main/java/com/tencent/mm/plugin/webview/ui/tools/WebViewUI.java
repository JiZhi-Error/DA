package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.Scopes;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.y;
import com.tencent.mm.bo.a;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.n.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.g;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.l;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.k.j;
import com.tencent.mm.plugin.webview.k.k;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper;
import com.tencent.mm.plugin.webview.modeltools.n;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView;
import com.tencent.mm.plugin.webview.ui.tools.o;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView;
import com.tencent.mm.plugin.webview.ui.tools.widget.MPSmileyFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.p;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.AccessibilityUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.statusbar.c;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.snackbar.a;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.ab;
import com.tencent.xweb.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebViewUI extends MMSecDataActivity implements View.OnCreateContextMenuListener, com.tencent.mm.plugin.webview.core.b, com.tencent.mm.plugin.webview.h.a.b, com.tencent.mm.plugin.webview.ui.tools.video.samelayer.e, ScreenShotUtil.ScreenShotCallback, MMWebView.e {
    private static final Pattern ITJ = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Pattern ITK = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final ArrayList<e> JiD = new ArrayList<>();
    private static WebSettings.RenderPriority JiI = WebSettings.RenderPriority.NORMAL;
    private static Boolean JjD = null;
    protected static int Jjc = 0;
    private View BdQ;
    private c.a BdS;
    protected boolean CSQ = true;
    public h IBw = null;
    public o ILE;
    public com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h ILF = new com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h(this);
    protected i IMH = null;
    public az IMs = new az();
    public f ISw;
    private View JfG;
    final com.tencent.mm.plugin.webview.modeltools.a JfY = new com.tencent.mm.plugin.webview.modeltools.a();
    protected boolean JhT = false;
    private boolean JhU = false;
    protected MMFalseProgressBar JhV;
    public ProgressBar JhW;
    public q JhX;
    private h JhY;
    private ImageButton JhZ;
    private boolean JiA = false;
    private View JiB;
    private MTimerHandler JiC;
    private boolean JiE = false;
    private WebChromeClient.CustomViewCallback JiF;
    protected x JiG;
    private ProgressBar JiH;
    private final IListener<SendDataToH5FromMiniProgramEvent> JiJ = new IListener<SendDataToH5FromMiniProgramEvent>() {
        /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160443);
            this.__eventId = SendDataToH5FromMiniProgramEvent.class.getName().hashCode();
            AppMethodBeat.o(160443);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent) {
            AppMethodBeat.i(80042);
            SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent2 = sendDataToH5FromMiniProgramEvent;
            if (WebViewUI.this.fZu() == sendDataToH5FromMiniProgramEvent2.lWd && WebViewUI.this.IBw != null) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("miniprogramAppID", sendDataToH5FromMiniProgramEvent2.lWc);
                hashMap.put("data", sendDataToH5FromMiniProgramEvent2.data);
                h hVar = WebViewUI.this.IBw;
                if (!hVar.GBl) {
                    Log.e("MicroMsg.JsApiHandler", "not ready");
                } else {
                    MMHandlerThread.postToMainThread(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0054: INVOKE  
                          (wrap: com.tencent.mm.plugin.webview.d.h$77 : 0x0051: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$77) = 
                          (r1v5 'hVar' com.tencent.mm.plugin.webview.d.h)
                          (wrap: java.lang.String : 0x004b: INVOKE  (r0v6 java.lang.String) = 
                          ("onMiniProgramData")
                          (r0v5 'hashMap' java.util.HashMap)
                          (wrap: boolean : 0x0047: IGET  (r3v1 boolean) = (r1v5 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                          (wrap: java.lang.String : 0x0049: IGET  (r4v0 java.lang.String) = (r1v5 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                         type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                         call: com.tencent.mm.plugin.webview.d.h.77.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                         type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.1.callback(com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent):boolean, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0051: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$77) = 
                          (r1v5 'hVar' com.tencent.mm.plugin.webview.d.h)
                          (wrap: java.lang.String : 0x004b: INVOKE  (r0v6 java.lang.String) = 
                          ("onMiniProgramData")
                          (r0v5 'hashMap' java.util.HashMap)
                          (wrap: boolean : 0x0047: IGET  (r3v1 boolean) = (r1v5 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                          (wrap: java.lang.String : 0x0049: IGET  (r4v0 java.lang.String) = (r1v5 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                         type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                         call: com.tencent.mm.plugin.webview.d.h.77.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.1.callback(com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent):boolean, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 24 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 30 more
                        */
                    /*
                        this = this;
                        r5 = 80042(0x138aa, float:1.12163E-40)
                        com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                        com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent r7 = (com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent) r7
                        com.tencent.mm.plugin.webview.ui.tools.WebViewUI r0 = com.tencent.mm.plugin.webview.ui.tools.WebViewUI.this
                        int r0 = r0.fZu()
                        int r1 = r7.lWd
                        if (r0 != r1) goto L_0x0042
                        com.tencent.mm.plugin.webview.ui.tools.WebViewUI r0 = com.tencent.mm.plugin.webview.ui.tools.WebViewUI.this
                        com.tencent.mm.plugin.webview.d.h r0 = r0.IBw
                        if (r0 == 0) goto L_0x0042
                        java.util.HashMap r0 = new java.util.HashMap
                        r1 = 2
                        r0.<init>(r1)
                        java.lang.String r1 = "miniprogramAppID"
                        java.lang.String r2 = r7.lWc
                        r0.put(r1, r2)
                        java.lang.String r1 = "data"
                        java.lang.String r2 = r7.data
                        r0.put(r1, r2)
                        com.tencent.mm.plugin.webview.ui.tools.WebViewUI r1 = com.tencent.mm.plugin.webview.ui.tools.WebViewUI.this
                        com.tencent.mm.plugin.webview.d.h r1 = r1.IBw
                        java.lang.String r2 = "onMiniProgramData"
                        boolean r3 = r1.GBl
                        if (r3 != 0) goto L_0x0047
                        java.lang.String r0 = "MicroMsg.JsApiHandler"
                        java.lang.String r1 = "not ready"
                        com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
                    L_0x0042:
                        r0 = 0
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                        return r0
                    L_0x0047:
                        boolean r3 = r1.IRj
                        java.lang.String r4 = r1.zpY
                        java.lang.String r0 = com.tencent.mm.plugin.webview.d.n.a.b(r2, r0, r3, r4)
                        com.tencent.mm.plugin.webview.d.h$77 r2 = new com.tencent.mm.plugin.webview.d.h$77
                        r2.<init>(r0)
                        com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)
                        goto L_0x0042
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass1.callback(com.tencent.mm.sdk.event.IEvent):boolean");
                }
            };
            private boolean JiK = false;
            protected boolean JiL = false;
            protected HashMap<String, Boolean> JiM = new HashMap<>();
            protected HashMap<String, String> JiN = new HashMap<>();
            protected HashMap<String, ArrayList<e.b>> JiO = new HashMap<>();
            protected HashMap<String, Boolean> JiP = new HashMap<>();
            protected a JiQ;
            protected com.tencent.mm.ui.widget.a.d JiR = null;
            protected View JiS = null;
            protected String JiT = null;
            private boolean JiU = false;
            private boolean JiW = false;
            protected volatile boolean JiX = false;
            protected boolean JiY = false;
            private Map JiZ;
            private ImageButton Jia;
            protected View Jib;
            protected WebViewKeyboardLinearLayout Jic;
            protected FrameLayout Jid;
            public FrameLayout Jie;
            protected MovingImageButton Jif;
            protected boolean Jig = false;
            private boolean Jih = false;
            protected com.tencent.mm.bo.a Jii;
            private WebViewRedesignInputFooter Jij;
            protected WebViewSearchContentInputFooter Jik;
            private boolean Jil;
            private boolean Jim;
            public String Jin = null;
            protected boolean Jio = true;
            protected boolean Jip = false;
            protected long Jiq = 0;
            private boolean Jir = false;
            private int Jis;
            private int Jit = -1;
            private boolean Jiu = false;
            protected boolean Jiv = true;
            private boolean Jiw = false;
            protected boolean Jix = false;
            protected int Jiy;
            protected byte[] Jiz = new byte[0];
            private MPVideoPlayFullScreenView JjA;
            int JjB = 0;
            private boolean JjC = true;
            protected View JjE;
            private a.b JjG = new a.b() {
                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass20 */

                @Override // com.tencent.mm.bo.a.b
                public final void a(a.EnumC0280a aVar, a.EnumC0280a aVar2) {
                    AppMethodBeat.i(259620);
                    Log.i("MicroMsg.WebViewUI", "OrientationListener lastOrientation:" + aVar.name() + "; newOrientation:" + aVar2.name());
                    WebViewUI.this.screenOrientation = 4;
                    WebViewUI.this.setMMOrientation();
                    if (WebViewUI.this.Jii != null) {
                        WebViewUI.this.Jii.disable();
                    }
                    AppMethodBeat.o(259620);
                }
            };
            private boolean JjH = false;
            public final k JjI = new k();
            public final com.tencent.mm.plugin.webview.ui.tools.media.e JjJ = new com.tencent.mm.plugin.webview.ui.tools.media.e();
            private boolean JjK;
            private View.OnLongClickListener JjL = new View.OnLongClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass22 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(211113);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$30", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    if (WebViewUI.this.getIntent().getBooleanExtra("show_long_click_popup_menu", true)) {
                        boolean hXQ = hXQ();
                        com.tencent.mm.hellhoundlib.a.a.a(hXQ, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$30", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(211113);
                        return hXQ;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$30", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(211113);
                    return true;
                }

                /* JADX WARNING: Removed duplicated region for block: B:17:0x005b  */
                /* JADX WARNING: Removed duplicated region for block: B:23:0x0086  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                private boolean hXQ() {
                    /*
                    // Method dump skipped, instructions count: 136
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass22.hXQ():boolean");
                }
            };
            protected boolean JjM = false;
            private View.OnLongClickListener JjN;
            protected View.OnLongClickListener JjO = new View.OnLongClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass26 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(259651);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$34", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    if (WebViewUI.this.JjN == null || (!BuildInfo.DEBUG && !BuildInfo.IS_FLAVOR_RED && !WeChatEnvironment.hasDebugger())) {
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$34", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(259651);
                        return false;
                    }
                    boolean onLongClick = WebViewUI.this.JjN.onLongClick(view);
                    com.tencent.mm.hellhoundlib.a.a.a(onLongClick, this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$34", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(259651);
                    return onLongClick;
                }
            };
            private String JjP;
            protected volatile String JjQ = "";
            private WebChromeClient.CustomViewCallback JjR;
            protected c JjS = new c();
            public int JjT = -1;
            private int Jja = 0;
            public int Jjb = ((int) (System.currentTimeMillis() / 1000));
            public boolean Jjd = false;
            private boolean Jje = false;
            private boolean Jjf = false;
            protected boolean Jjg = false;
            protected volatile boolean Jjh = false;
            private j Jji = new j();
            private com.tencent.mm.plugin.webview.model.b Jjj;
            protected n Jjk = new n();
            protected i Jjl;
            public j Jjm;
            protected IUtils Jjn = null;
            private WebViewClipBoardHelper Jjo;
            protected com.tencent.mm.plugin.webview.c Jjp;
            protected volatile String Jjq;
            protected volatile long Jjr;
            protected HandOffURL Jjs;
            com.tencent.mm.plugin.webview.ui.tools.floatball.b Jjt;
            com.tencent.mm.plugin.webview.ui.tools.multitask.a Jju;
            private boolean Jjv = false;
            protected ab Jjw = new ab() {
                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass11 */

                @Override // com.tencent.xweb.ab
                public final boolean B(MotionEvent motionEvent) {
                    AppMethodBeat.i(80052);
                    if (WebViewUI.this.pGj == null) {
                        AppMethodBeat.o(80052);
                        return false;
                    }
                    boolean am = WebViewUI.this.pGj.am(motionEvent);
                    AppMethodBeat.o(80052);
                    return am;
                }

                @Override // com.tencent.xweb.ab
                public final boolean b(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
                    AppMethodBeat.i(80053);
                    if (WebViewUI.this.pGj == null) {
                        AppMethodBeat.o(80053);
                        return false;
                    }
                    ak gdd = WebViewUI.this.IMs.gdd();
                    if (i5 > gdd.IZc) {
                        gdd.IZc = i5;
                    }
                    gdd.EOU = i7;
                    boolean c2 = WebViewUI.this.pGj.c(i2, i3, i4, i5, i6, i7, i8, i9, z);
                    AppMethodBeat.o(80053);
                    return c2;
                }

                @Override // com.tencent.xweb.ab
                public final void bLv() {
                    AppMethodBeat.i(80054);
                    if (WebViewUI.this.pGj == null) {
                        AppMethodBeat.o(80054);
                        return;
                    }
                    WebViewUI.this.pGj.gYY();
                    AppMethodBeat.o(80054);
                }

                @Override // com.tencent.xweb.ab
                public final void d(int i2, int i3, boolean z, boolean z2) {
                    AppMethodBeat.i(80055);
                    if (WebViewUI.this.pGj == null) {
                        AppMethodBeat.o(80055);
                        return;
                    }
                    WebViewUI.this.pGj.h(i2, i3, z, z2);
                    if (z2 && WebViewUI.this.IMs != null) {
                        WebViewUI.this.IMs.D("mm_scroll_bottom", Boolean.TRUE);
                    }
                    AppMethodBeat.o(80055);
                }

                @Override // com.tencent.xweb.ab
                public final void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
                    AppMethodBeat.i(80056);
                    if (WebViewUI.this.pGj == null) {
                        AppMethodBeat.o(80056);
                        return;
                    }
                    WebViewUI.this.pGj.R(i2, i3, i4, i5);
                    WebViewUI.this.onWebViewScrollChanged(i2, i3, i4, i5);
                    AppMethodBeat.o(80056);
                }

                @Override // com.tencent.xweb.ab
                public final boolean C(MotionEvent motionEvent) {
                    AppMethodBeat.i(80057);
                    if (WebViewUI.this.pGj == null) {
                        AppMethodBeat.o(80057);
                        return false;
                    }
                    boolean an = WebViewUI.this.pGj.an(motionEvent);
                    AppMethodBeat.o(80057);
                    return an;
                }

                @Override // com.tencent.xweb.ab
                public final boolean D(MotionEvent motionEvent) {
                    AppMethodBeat.i(80058);
                    if (WebViewUI.this.pGj == null) {
                        AppMethodBeat.o(80058);
                        return false;
                    }
                    boolean ao = WebViewUI.this.pGj.ao(motionEvent);
                    AppMethodBeat.o(80058);
                    return ao;
                }
            };
            private IListener<ub> Jjx = new IListener<ub>() {
                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass21 */

                {
                    AppMethodBeat.i(160444);
                    this.__eventId = ub.class.getName().hashCode();
                    AppMethodBeat.o(160444);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(ub ubVar) {
                    AppMethodBeat.i(80076);
                    boolean gga = gga();
                    AppMethodBeat.o(80076);
                    return gga;
                }

                private boolean gga() {
                    AppMethodBeat.i(80075);
                    if (WebViewUI.this.mHh == null) {
                        Log.e("MicroMsg.WebViewUI", "Cli Event, invoker is null");
                        AppMethodBeat.o(80075);
                    } else if (WebViewUI.this.Jjq == null || WebViewUI.this.Jjq.length() == 0) {
                        Log.e("MicroMsg.WebViewUI", "Cli Event, tid is null");
                        AppMethodBeat.o(80075);
                    } else {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            Log.i("MicroMsg.WebViewUI", "Cli Event, tid = %s, stime = %d, etime = %d", WebViewUI.this.Jjq, Long.valueOf(WebViewUI.this.Jjr), Long.valueOf(currentTimeMillis));
                            Bundle bundle = new Bundle();
                            bundle.putString("service_click_tid", new String(WebViewUI.this.Jjq));
                            bundle.putLong("service_click_stime", WebViewUI.this.Jjr);
                            bundle.putLong("service_click_etime", currentTimeMillis);
                            WebViewUI.this.mHh.x(2836, bundle);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.WebViewUI", "Cli Event Exception, msg = %s", e2.getMessage());
                        }
                        WebViewUI.this.Jjq = null;
                        AppMethodBeat.o(80075);
                    }
                    return false;
                }
            };
            private com.tencent.mm.plugin.webview.ui.tools.widget.n Jjy;
            private boolean Jjz = false;
            private View VgS;
            public q VgT;
            public String eam;
            private q gut;
            public MMHandler handler;
            private ActionBar mActionBar;
            public com.tencent.mm.plugin.webview.stub.e mHh = null;
            protected g mHi = null;
            private final com.tencent.mm.plugin.webview.modeltools.d mHr = new com.tencent.mm.plugin.webview.modeltools.d();
            public String pFJ;
            public MMWebView pGj;
            protected int ppd;
            protected int ppe;
            private int pzw = 0;
            protected int screenOrientation = -1;
            protected String sessionId = "";
            private View vk;
            public int xPp = 0;
            public String xPq = null;
            protected a.b xxK = new a.b() {
                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass42 */

                @Override // com.tencent.mm.ui.widget.snackbar.a.b
                public final void bDZ() {
                    AppMethodBeat.i(259660);
                    try {
                        WebViewUI.this.mHh.favEditTag();
                        AppMethodBeat.o(259660);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + e2.getMessage());
                        AppMethodBeat.o(259660);
                    }
                }
            };
            private long zdW = 0;

            public WebViewUI() {
                AppMethodBeat.i(80217);
                AppMethodBeat.o(80217);
            }

            static /* synthetic */ void a(WebViewUI webViewUI, JsapiPermissionWrapper jsapiPermissionWrapper) {
                AppMethodBeat.i(259670);
                webViewUI.a(jsapiPermissionWrapper);
                AppMethodBeat.o(259670);
            }

            static /* synthetic */ String bat(String str) {
                AppMethodBeat.i(80378);
                String bar = bar(str);
                AppMethodBeat.o(80378);
                return bar;
            }

            static /* synthetic */ boolean d(WebViewUI webViewUI) {
                AppMethodBeat.i(80377);
                boolean gek = webViewUI.gek();
                AppMethodBeat.o(80377);
                return gek;
            }

            static /* synthetic */ void e(WebViewUI webViewUI, String str) {
                AppMethodBeat.i(259668);
                webViewUI.baq(str);
                AppMethodBeat.o(259668);
            }

            static /* synthetic */ void gf(View view) {
                AppMethodBeat.i(80373);
                aC(view, 5894);
                AppMethodBeat.o(80373);
            }

            static /* synthetic */ void j(WebViewUI webViewUI) {
                AppMethodBeat.i(211194);
                webViewUI.gfM();
                AppMethodBeat.o(211194);
            }

            static /* synthetic */ int n(WebViewUI webViewUI) {
                AppMethodBeat.i(211195);
                int gfp = webViewUI.gfp();
                AppMethodBeat.o(211195);
                return gfp;
            }

            static /* synthetic */ int r(WebViewUI webViewUI) {
                int i2 = webViewUI.Jja;
                webViewUI.Jja = i2 + 1;
                return i2;
            }

            static /* synthetic */ boolean y(WebViewUI webViewUI) {
                AppMethodBeat.i(175810);
                boolean z = webViewUI.JiU;
                AppMethodBeat.o(175810);
                return z;
            }

            public final int bLC() {
                AppMethodBeat.i(80335);
                int bLC = this.IMH.bLC();
                AppMethodBeat.o(80335);
                return bLC;
            }

            static {
                AppMethodBeat.i(80400);
                AppMethodBeat.o(80400);
            }

            /* access modifiers changed from: protected */
            public final boolean gfa() {
                return this.IMH.IKF;
            }

            /* access modifiers changed from: protected */
            public final Map<String, String> gfb() {
                return this.IMH.IJX;
            }

            public final j gfc() {
                return this.Jji;
            }

            private com.tencent.mm.plugin.webview.model.b gfd() {
                AppMethodBeat.i(211153);
                if (this.Jjj == null) {
                    this.Jjj = new com.tencent.mm.plugin.webview.model.b(this.IMs);
                }
                com.tencent.mm.plugin.webview.model.b bVar = this.Jjj;
                AppMethodBeat.o(211153);
                return bVar;
            }

            public final HandOffURL gfe() {
                return this.Jjs;
            }

            public final com.tencent.mm.plugin.webview.ui.tools.multitask.a gff() {
                return this.Jju;
            }

            /* access modifiers changed from: protected */
            public final ar gfg() {
                return this.IMH.ILL;
            }

            /* access modifiers changed from: protected */
            public void ba(Bundle bundle) {
            }

            /* access modifiers changed from: protected */
            public boolean bXi() {
                return false;
            }

            public void bb(Bundle bundle) {
                int i2;
                int i3;
                boolean z = false;
                AppMethodBeat.i(80220);
                if (bundle.getBoolean("set_navigation_bar_color_reset", false)) {
                    i3 = 255;
                    i2 = this.ILE == null ? getResources().getColor(R.color.aff) : this.ILE.ggj();
                } else {
                    i2 = bundle.getInt("set_navigation_bar_color_color");
                    int i4 = bundle.getInt("set_navigation_bar_color_alpha");
                    z = bundle.getBoolean("set_navigation_bar_color_titleAlphaAdjustment");
                    i3 = i4;
                }
                setActionbarColor((16777215 & i2) | (i3 << 24));
                if (z) {
                    setTitleAlpha(((float) i3) / 255.0f);
                }
                AppMethodBeat.o(80220);
            }

            @Override // com.tencent.mm.ui.MMActivity
            public void setActionbarColor(int i2) {
                AppMethodBeat.i(80221);
                super.setActionbarColor(i2);
                if (Build.VERSION.SDK_INT >= 21 && this.BdQ != null) {
                    this.BdQ.setBackgroundColor(getWindow().getStatusBarColor());
                    com.tencent.mm.ui.statusbar.d.e(getWindow());
                }
                AppMethodBeat.o(80221);
            }

            @TargetApi(21)
            public final void setStatusBarColor(int i2) {
                AppMethodBeat.i(80258);
                com.tencent.mm.ui.statusbar.a.e(getContentView(), i2, !com.tencent.mm.ui.ar.aln(i2));
                AppMethodBeat.o(80258);
            }

            @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity
            public void initSwipeBack() {
                AppMethodBeat.i(80222);
                super.initSwipeBack();
                if (getSwipeBackLayout() == null) {
                    AppMethodBeat.o(80222);
                    return;
                }
                this.JiW = true;
                AppMethodBeat.o(80222);
            }

            /* access modifiers changed from: protected */
            public final void bC(Bundle bundle) {
                AppMethodBeat.i(259662);
                if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(coX())) {
                    bundle.putInt("_DATA_CENTER_ITEM_SHOW_TYPE", this.Jit);
                }
                AppMethodBeat.o(259662);
            }

            /* access modifiers changed from: protected */
            public final g hXO() {
                AppMethodBeat.i(259663);
                g gVar = new g(this);
                AppMethodBeat.o(259663);
                return gVar;
            }

            /* access modifiers changed from: protected */
            public final com.tencent.mm.plugin.webview.ui.tools.widget.n gfh() {
                AppMethodBeat.i(80223);
                if (this.Jjy == null) {
                    this.Jjy = new com.tencent.mm.plugin.webview.ui.tools.widget.n(this, new u(getContext(), R.style.hc));
                    this.Jjy.setVisibility(8);
                    ViewParent viewParent = (ViewParent) getWindow().getDecorView();
                    if (viewParent instanceof ViewGroup) {
                        ((ViewGroup) viewParent).addView(this.Jjy, new FrameLayout.LayoutParams(-1, -1));
                        cqk();
                    }
                }
                com.tencent.mm.plugin.webview.ui.tools.widget.n nVar = this.Jjy;
                AppMethodBeat.o(80223);
                return nVar;
            }

            public final MPVideoPlayFullScreenView gfi() {
                AppMethodBeat.i(80224);
                if (this.JjA == null) {
                    this.JjA = new MPVideoPlayFullScreenView(this, null);
                    this.JjA.setVisibility(8);
                    ViewParent viewParent = (ViewParent) getWindow().getDecorView();
                    if (viewParent instanceof ViewGroup) {
                        ((ViewGroup) viewParent).addView(this.JjA, new FrameLayout.LayoutParams(-1, -1));
                    }
                }
                MPVideoPlayFullScreenView mPVideoPlayFullScreenView = this.JjA;
                AppMethodBeat.o(80224);
                return mPVideoPlayFullScreenView;
            }

            /* access modifiers changed from: protected */
            public final void gfj() {
                AppMethodBeat.i(80225);
                if (this.Jjy != null) {
                    com.tencent.mm.plugin.webview.ui.tools.widget.n nVar = this.Jjy;
                    if (nVar.getSayFooter() != null) {
                        MPSmileyFooter sayFooter = nVar.getSayFooter();
                        if (sayFooter.rum != null) {
                            sayFooter.rum.goC();
                            sayFooter.rum.destroy();
                        }
                    }
                    p pVar = p.JAu;
                    p.b(nVar.JzA.gut);
                }
                AppMethodBeat.o(80225);
            }

            public final q gfk() {
                return this.gut;
            }

            public final void a(q qVar) {
                this.gut = qVar;
            }

            public void cqk() {
                AppMethodBeat.i(80226);
                this.Jjy.giy();
                int intExtra = getIntent().getIntExtra(e.p.OzA, -1);
                getIntent().getIntExtra(e.p.Ozv, 0);
                this.Jjy.a(getIntent().getIntExtra(e.p.Ozw, -1), getIntent().getIntExtra(e.p.Ozx, -1), intExtra, 0, coX(), getTitle().toString());
                AppMethodBeat.o(80226);
            }

            @Override // com.tencent.mm.plugin.webview.h.a.b
            public final void aT(Bundle bundle) {
                AppMethodBeat.i(80227);
                if (bundle != null) {
                    this.Jjz = "black".equals(bundle.getString(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
                    gfh().setCommentTopicId(bundle.getLong("commentTopicId"));
                }
                gfh().bbn(this.IMH.getCurrentUrl());
                gfh().zw(false);
                AppMethodBeat.o(80227);
            }

            @Override // com.tencent.mm.plugin.webview.h.a.b
            public final void aW(Bundle bundle) {
                AppMethodBeat.i(175797);
                if (bundle != null) {
                    gfh().setCommentTopicId(bundle.getLong("commentTopicId"));
                }
                gfh().bbn(this.IMH.getCurrentUrl());
                com.tencent.mm.plugin.webview.ui.tools.widget.n gfh = gfh();
                String string = bundle.getString("reply_content");
                int i2 = bundle.getInt("personal_comment_id");
                kotlin.g.b.p.h(string, "replyContent");
                gfh.xV(2);
                gfh.zy(false);
                if (Util.isNullOrNil(string) || i2 == 0 || !gfh.giC()) {
                    gfh.zw(false);
                    AppMethodBeat.o(175797);
                    return;
                }
                com.tencent.mm.plugin.webview.ui.tools.widget.n.a(gfh, string, i2);
                gfh.zx(false);
                AppMethodBeat.o(175797);
            }

            @Override // com.tencent.mm.plugin.webview.h.a.b
            public final void gdM() {
                AppMethodBeat.i(80228);
                if (this.Jjy != null) {
                    com.tencent.mm.plugin.webview.ui.tools.widget.n nVar = this.Jjy;
                    nVar.hide();
                    nVar.Jzk.setText("");
                }
                AppMethodBeat.o(80228);
            }

            @Override // com.tencent.mm.plugin.webview.h.a.b
            public final void aU(Bundle bundle) {
                AppMethodBeat.i(80229);
                if (bundle != null) {
                    this.Jjz = "black".equals(bundle.getString(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
                    gfh().zw(true);
                }
                AppMethodBeat.o(80229);
            }

            @Override // com.tencent.mm.plugin.webview.h.a.b
            public final void aV(Bundle bundle) {
                AppMethodBeat.i(80230);
                this.gut = p.a(bundle, getContext(), this.gut);
                AppMethodBeat.o(80230);
            }

            @Override // com.tencent.mm.plugin.webview.h.a.b
            public final void aS(Bundle bundle) {
                AppMethodBeat.i(80231);
                this.JjB = bundle.getInt("state", 0);
                AppMethodBeat.o(80231);
            }

            @Override // com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback
            public void onScreenShot(String str, long j2) {
                AppMethodBeat.i(211154);
                if (!(this.IBw == null || this.pGj == null)) {
                    h hVar = this.IBw;
                    this.pGj.getUrl();
                    Intent intent = getIntent();
                    boolean z = (this.mHi.gdI().Kzi & 1048576) > 0;
                    Log.d("MicroMsg.GeneralControlWrapper", "allowOnScreenShot, ret = ".concat(String.valueOf(z)));
                    if (hVar.GBl) {
                        Log.i("MicroMsg.JsApiHandler", "onScreenShot hasPermission: %b", Boolean.valueOf(z));
                        if (z) {
                            hVar.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("onScreenShot", new HashMap(), hVar.IRj, hVar.zpY) + ")", null);
                        }
                        String aXZ = hVar.aXZ(hVar.getCurrentUrl());
                        if (intent != null) {
                            try {
                                String currentUrl = hVar.getCurrentUrl();
                                Bundle bundleExtra = intent.getBundleExtra("ad_report_bundle");
                                if (!Util.isNullOrNil(currentUrl) && bundleExtra != null) {
                                    String string = bundleExtra.getString("ad_report_ux_info");
                                    if (!Util.isNullOrNil(string)) {
                                        Uri parse = Uri.parse(currentUrl);
                                        String queryParameter = parse.getQueryParameter("mid");
                                        String queryParameter2 = parse.getQueryParameter("idx");
                                        Log.i("MicroMsg.JsApiHandler", "alvinluo reportAdOnScreenShot appId: %s, mid: %s, idx: %s, adUxInfo: %s, url: %s", aXZ, queryParameter, queryParameter2, string, currentUrl);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(19213, Integer.valueOf((int) (System.currentTimeMillis() / 1000)), 6, string, aXZ, queryParameter, queryParameter2, currentUrl);
                                    }
                                }
                                AppMethodBeat.o(211154);
                                return;
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.JsApiHandler", e2, "alvinluo reportAdOnScreenShot exception", new Object[0]);
                            }
                        }
                    }
                }
                AppMethodBeat.o(211154);
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.video.samelayer.a
            public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy() {
                AppMethodBeat.i(211155);
                if (this.IMH != null) {
                    com.tencent.luggage.xweb_ext.extendplugin.b.c webViewPluginClientProxy = this.IMH.getWebViewPluginClientProxy();
                    AppMethodBeat.o(211155);
                    return webViewPluginClientProxy;
                }
                AppMethodBeat.o(211155);
                return null;
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.video.samelayer.b
            public final boolean gfl() {
                AppMethodBeat.i(211156);
                boolean gfl = this.ILF.gfl();
                AppMethodBeat.o(211156);
                return gfl;
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.video.samelayer.b
            public final void aB(View view, int i2) {
                AppMethodBeat.i(211157);
                com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h hVar = this.ILF;
                if (view == null) {
                    view = this.pGj;
                }
                hVar.aB(view, i2);
                AppMethodBeat.o(211157);
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.video.samelayer.c
            public final void a(com.tencent.mm.plugin.webview.ui.tools.video.c cVar) {
                AppMethodBeat.i(211158);
                this.ILF.a(cVar);
                AppMethodBeat.o(211158);
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.video.samelayer.c
            public final void b(com.tencent.mm.plugin.webview.ui.tools.video.c cVar) {
                AppMethodBeat.i(211159);
                this.ILF.b(cVar);
                AppMethodBeat.o(211159);
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.video.samelayer.d
            public final void c(a.AbstractC0188a aVar) {
                AppMethodBeat.i(211160);
                this.ILF.c(aVar);
                AppMethodBeat.o(211160);
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.video.samelayer.d
            public final void d(a.AbstractC0188a aVar) {
                AppMethodBeat.i(211161);
                this.ILF.d(aVar);
                AppMethodBeat.o(211161);
            }

            /* access modifiers changed from: package-private */
            public static final class e {
                final int id;
                final WeakReference<WebViewUI> nhy;

                public e(WebViewUI webViewUI) {
                    AppMethodBeat.i(80216);
                    this.nhy = new WeakReference<>(webViewUI);
                    this.id = webViewUI.fZu();
                    AppMethodBeat.o(80216);
                }
            }

            private void yY(boolean z) {
                if (!z) {
                    this.JiE = true;
                }
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onResume() {
                Bundle j2;
                AppMethodBeat.i(80233);
                super.onResume();
                if (this.Jjt != null) {
                    this.Jjt.bCA();
                }
                if (this.Jju != null) {
                    this.Jju.bCA();
                }
                if (this.IMH.getCurrentUrl() != null) {
                    k.j(this.IMH.getCurrentUrl(), this);
                } else {
                    k.j(coX(), this);
                }
                this.IMs.gdc().lastResumeTime = Util.currentTicks();
                this.IMs.gdd().lastResumeTime = Util.currentTicks();
                l lVar = l.Jhd;
                Log.v("MicroMsg.WebViewReportUtil", "onResume traceid %s", lVar.traceid);
                if (!Util.isNullOrNil(lVar.traceid)) {
                    lVar.pl(7);
                }
                if (!this.JjC) {
                    int fZu = this.IMH.fZu();
                    int size = JiD.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        } else if (JiD.get(size).id == fZu) {
                            JiD.remove(size);
                            break;
                        } else {
                            size--;
                        }
                    }
                    JiD.add(new e(this));
                }
                this.JjC = false;
                if (this.JiE) {
                    yY(true);
                    this.JiE = false;
                }
                gfA();
                updateOrientation();
                if (getIntent().getBooleanExtra("disable_swipe_back", false) && getSwipeBackLayout() != null) {
                    getSwipeBackLayout().setEnableGesture(false);
                }
                try {
                    ScreenShotUtil.setScreenShotCallback(this, this);
                } catch (Exception e2) {
                    Log.w("MicroMsg.WebViewUI", "setScreenShotCallback fail e:%s", e2.getMessage());
                }
                aYq("onResume");
                try {
                    if (!(this.mHh == null || (j2 = this.mHh.j(19, null)) == null)) {
                        boolean z = j2.getBoolean("webview_video_proxy_init");
                        Log.i("MicroMsg.WebViewUI", "onResume, has init = %b", Boolean.valueOf(z));
                        if (z) {
                            FactoryProxyManager.getPlayManager().appToFront();
                        }
                    }
                } catch (Exception e3) {
                    Log.e("MicroMsg.WebViewUI", "notify app tofront failed : %s", e3.getMessage());
                }
                this.zdW = Util.nowSecond();
                com.tencent.mm.plugin.webview.a.a.aj(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass43 */

                    public final void run() {
                        AppMethodBeat.i(211126);
                        com.tencent.mm.modelstat.d.d(3, "WebViewUI_" + WebViewUI.this.aXI(Util.nullAsNil(WebViewUI.this.JiT)), WebViewUI.this.fZu());
                        AppMethodBeat.o(211126);
                    }
                });
                if (this.Jjh) {
                    finish();
                }
                if (this.Jic != null && this.Jic.Jgc) {
                    hideVKB();
                    this.Jic.Ns(-2);
                }
                this.ILF.onResume();
                if (this.pGj != null) {
                    this.pGj.onResume();
                }
                AppMethodBeat.o(80233);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onPause() {
                Bundle j2;
                AppMethodBeat.i(80234);
                super.onPause();
                if (this.Jjt != null) {
                    this.Jjt.aGj();
                }
                if (this.Jju != null) {
                    this.Jju.aGj();
                }
                com.tencent.mm.modelstat.d.d(4, "WebViewUI_" + aXI(Util.nullAsNil(this.JiT)), this.IMH.fZu());
                com.tencent.mm.modelstat.d.m("WebViewUI_" + aXI(Util.nullAsNil(this.JiT)), this.zdW, Util.nowSecond());
                ax gdc = this.IMs.gdc();
                if (gdc.lastResumeTime != -1) {
                    gdc.dUy += Util.ticksToNow(gdc.lastResumeTime) / 1000;
                }
                ak gdd = this.IMs.gdd();
                if (gdd.lastResumeTime != -1) {
                    gdd.dUy += Util.ticksToNow(gdd.lastResumeTime);
                }
                l lVar = l.Jhd;
                Log.v("MicroMsg.WebViewReportUtil", "onPause traceid %s", lVar.traceid);
                if (lVar.iGD) {
                    Log.i("MicroMsg.WebViewReportUtil", "isFinish is true");
                } else if (!Util.isNullOrNil(lVar.traceid)) {
                    lVar.pl(6);
                }
                try {
                    if (!(this.mHh == null || (j2 = this.mHh.j(19, null)) == null)) {
                        boolean z = j2.getBoolean("webview_video_proxy_init");
                        Log.i("MicroMsg.WebViewUI", "onPause, has init = %b", Boolean.valueOf(z));
                        if (z) {
                            FactoryProxyManager.getPlayManager().appToBack();
                        }
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.WebViewUI", "notify app toback failed : %s", e2.getMessage());
                }
                gfM();
                ScreenShotUtil.setScreenShotCallback(this, null);
                aYq("onPause");
                if (this.JiG != null) {
                    Log.i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
                    try {
                        this.JiG.onHideCustomView();
                    } catch (Exception e3) {
                        Log.printErrStackTrace("MicroMsg.WebViewUI", e3, "onPause", new Object[0]);
                    }
                }
                this.ILF.onPause();
                if (this.pGj != null) {
                    this.pGj.onPause();
                }
                AppMethodBeat.o(80234);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
            public void finish() {
                boolean z;
                boolean z2 = true;
                AppMethodBeat.i(80235);
                if (this.Jiu) {
                    setResult(-1);
                }
                if (this.handler != null) {
                    this.handler.removeCallbacksAndMessages(null);
                }
                this.Jje = true;
                if (!com.tencent.mm.plugin.webview.ui.tools.floatball.d.ggy() || this.mHh == null || this.Jju == null || !this.Jju.eqW()) {
                    z = false;
                } else {
                    z = true;
                }
                if (this.IMH != null) {
                    i iVar = this.IMH;
                    iVar.yR(z);
                    iVar.IJT = true;
                }
                if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.d.c.class) != null) {
                    ((com.tencent.mm.plugin.appbrand.d.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.d.c.class)).bzB();
                }
                super.finish();
                if (this.Jju == null || !this.Jju.eqZ()) {
                    z2 = false;
                }
                if (ao.gJN() && !z2) {
                    overridePendingTransition(0, MMFragmentActivity.a.OHE);
                }
                AppMethodBeat.o(80235);
            }

            @Override // com.tencent.mm.ui.MMFragmentActivity
            public void initActivityCloseAnimation() {
                AppMethodBeat.i(211162);
                boolean z = this.Jju != null && this.Jju.eqZ();
                if (!ao.gJN() || z) {
                    super.initActivityCloseAnimation();
                    AppMethodBeat.o(211162);
                    return;
                }
                overridePendingTransition(0, MMFragmentActivity.a.OHE);
                AppMethodBeat.o(211162);
            }

            /* access modifiers changed from: protected */
            public void goBack() {
                AppMethodBeat.i(211163);
                if (this.pGj == null) {
                    AppMethodBeat.o(211163);
                } else if (this.JiU) {
                    AppMethodBeat.o(211163);
                } else if (this.pGj.canGoBack()) {
                    gfy();
                    AppMethodBeat.o(211163);
                } else {
                    l.Jhd.close();
                    finish();
                    AppMethodBeat.o(211163);
                }
            }

            @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
            public boolean moveTaskToBack(boolean z) {
                AppMethodBeat.i(211164);
                boolean moveTaskToBack = super.moveTaskToBack(z);
                initActivityCloseAnimation();
                AppMethodBeat.o(211164);
                return moveTaskToBack;
            }

            @Override // com.tencent.mm.ui.MMActivity
            public int getLayoutId() {
                return R.layout.cbj;
            }

            @Override // com.tencent.mm.ui.MMFragmentActivity
            public boolean convertActivityFromTranslucent() {
                AppMethodBeat.i(80236);
                Intent intent = getIntent();
                g.a aVar = com.tencent.mm.plugin.webview.core.g.ILB;
                kotlin.f hXI = com.tencent.mm.plugin.webview.core.g.hXI();
                g.a aVar2 = com.tencent.mm.plugin.webview.core.g.ILB;
                boolean booleanExtra = intent.getBooleanExtra("convertActivityFromTranslucent", !((Boolean) hXI.getValue()).booleanValue());
                AppMethodBeat.o(80236);
                return booleanExtra;
            }

            @Override // com.tencent.mm.ui.MMActivity
            public void setMMTitle(String str) {
                AppMethodBeat.i(80237);
                super.setMMTitle(str);
                bao(str);
                bap(str);
                AppMethodBeat.o(80237);
            }

            @Override // com.tencent.mm.ui.MMActivity
            public void setMMTitle(CharSequence charSequence) {
                AppMethodBeat.i(80238);
                super.setMMTitle(charSequence);
                bao(charSequence.toString());
                bap(charSequence.toString());
                AppMethodBeat.o(80238);
            }

            private void bao(String str) {
                AppMethodBeat.i(80239);
                if (this.Jjt != null && !Util.isNullOrNil(str) && !com.tencent.mm.plugin.webview.ui.tools.floatball.b.isMpUrl(coX())) {
                    this.Jjt.agT(str);
                }
                if (this.Jju != null && !Util.isNullOrNil(str) && !com.tencent.mm.plugin.webview.ui.tools.multitask.a.isMpUrl(coX())) {
                    this.Jju.aCM(str);
                }
                AppMethodBeat.o(80239);
            }

            private void bap(String str) {
                AppMethodBeat.i(80240);
                if (this.Jjs != null && !Util.isNullOrNil(str) && (!(this.Jjt == null && this.Jju == null) && !((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(coX()) && !this.Jjs.getTitle().equals(str))) {
                    this.Jjs.setTitle(str);
                    if (gbH()) {
                        ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Jjs);
                    }
                }
                AppMethodBeat.o(80240);
            }

            private void baq(String str) {
                AppMethodBeat.i(211165);
                if (Util.isNullOrNil(str) || str.startsWith("data:text/html;charset=utf-8")) {
                    AppMethodBeat.o(211165);
                    return;
                }
                String nullAsNil = Util.nullAsNil(this.IMH != null ? this.IMH.beU() : "");
                if (this.Jjt != null) {
                    this.Jjt.eU(HandOffURL.KShareUrl, nullAsNil);
                }
                if (this.Jju != null) {
                    this.Jju.IVb.Nwh = nullAsNil;
                }
                if (!nullAsNil.isEmpty()) {
                    str = nullAsNil;
                }
                if (this.Jjs != null && !Util.isNullOrNil(str) && !this.Jjs.getUrl().equals(str)) {
                    this.Jjs.setUrl(str);
                    if (gbH()) {
                        ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Jjs);
                    }
                }
                AppMethodBeat.o(211165);
            }

            private void aYq(String str) {
                AppMethodBeat.i(80241);
                if (this.IBw != null) {
                    this.IBw.aYe(str);
                    try {
                        if (str.equals("onPause")) {
                            this.mHh.agA(this.IMH.fZu());
                            AppMethodBeat.o(80241);
                            return;
                        }
                        if (str.equals("onResume")) {
                            this.mHh.agz(this.IMH.fZu());
                        }
                        AppMethodBeat.o(80241);
                        return;
                    } catch (Exception e2) {
                        Log.w("MicroMsg.WebViewUI", "onResume, ex = " + e2.getMessage());
                    }
                }
                AppMethodBeat.o(80241);
            }

            public final int fZu() {
                AppMethodBeat.i(259664);
                int fZu = this.IMH.fZu();
                AppMethodBeat.o(259664);
                return fZu;
            }

            /* access modifiers changed from: protected */
            public i cpO() {
                AppMethodBeat.i(211167);
                if (com.tencent.mm.plugin.webview.ui.tools.floatball.d.ggy()) {
                    String stringExtra = getIntent().getStringExtra("float_ball_key");
                    if (!Util.isNullOrNil(stringExtra)) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1553, 1, 1, false);
                        com.tencent.mm.plugin.webview.ui.tools.floatball.d dVar = com.tencent.mm.plugin.webview.ui.tools.floatball.d.JmQ;
                        i baD = com.tencent.mm.plugin.webview.ui.tools.floatball.d.baD(stringExtra);
                        if (baD == null || baD.pGj == null || baD.pGj.mDestroyed) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1553, 3, 1, false);
                        } else {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1553, 2, 1, false);
                            this.JiL = true;
                            Log.i("MicroMsg.WebViewUI", "createWebViewController from cache floatBallKey=%s", stringExtra);
                            AppMethodBeat.o(211167);
                            return baD;
                        }
                    }
                }
                i iVar = new i(this.pGj, this.IMs, new BaseWebViewController.c(new BaseWebViewController.f(getIntent()), getIntent().getBooleanExtra("key_trust_url", false), gfT(), !gfO() && !gfP(), getIntent().getBooleanExtra("neverGetA8Key", false)), (byte) 0);
                iVar.a(this.JjS);
                iVar.init();
                AppMethodBeat.o(211167);
                return iVar;
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
            public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                boolean z = false;
                AppMethodBeat.i(80242);
                super.onRequestPermissionsResult(i2, strArr, iArr);
                com.tencent.mm.plugin.webview.modeltools.d dVar = this.mHr;
                if (dVar.Jay == null) {
                    dVar.gdn();
                } else {
                    if (119 == i2) {
                        if (iArr[0] == 0) {
                            int intValue = ((Integer) dVar.Jay.second).intValue();
                            dVar.Jay = null;
                            startActivityForResult((Intent) dVar.Jay.first, intValue);
                        } else {
                            dVar.Jay = null;
                            dVar.b(this, 0, null);
                        }
                    }
                    z = true;
                }
                if (z) {
                    AppMethodBeat.o(80242);
                } else {
                    AppMethodBeat.o(80242);
                }
            }

            @Override // com.tencent.mm.ui.MMActivity
            public void onCreateBeforeSetContentView() {
                AppMethodBeat.i(80243);
                supportRequestWindowFeature(5);
                supportRequestWindowFeature(9);
                setProgressBarIndeterminateVisibility(false);
                AppMethodBeat.o(80243);
            }

            /* access modifiers changed from: protected */
            public void onReset() {
                LinearLayout linearLayout;
                AppMethodBeat.i(80245);
                this.IBw.detach();
                this.IBw = null;
                ((ViewGroup) this.pGj.getParent()).removeView(this.pGj);
                this.pGj.stopLoading();
                this.pGj.removeAllViews();
                this.pGj.clearView();
                this.pGj.destroy();
                this.pGj = null;
                this.JiG = null;
                ((ViewGroup) this.Jib.getParent()).removeView(this.Jib);
                if (this.ILE != null) {
                    o oVar = this.ILE;
                    if (!(oVar.Jkh == null || (linearLayout = (LinearLayout) oVar.Jkg.getController().mActionBar.getCustomView()) == null)) {
                        linearLayout.removeView(oVar.Jkh);
                    }
                }
                if (this.IMH != null) {
                    this.IMH.onDestroy();
                }
                this.ILF.onDestroy();
                this.Jjg = false;
                cqh();
                cpA();
                AppMethodBeat.o(80245);
            }

            /* access modifiers changed from: protected */
            public void cqh() {
                AppMethodBeat.i(80246);
                customfixStatusbar(true);
                AppMethodBeat.o(80246);
            }

            /* access modifiers changed from: protected */
            /* JADX WARNING: Code restructure failed: missing block: B:116:0x052a, code lost:
                if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0) == false) goto L_0x04cc;
             */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x0374 A[Catch:{ Exception -> 0x0617 }] */
            /* JADX WARNING: Removed duplicated region for block: B:76:0x03cf  */
            /* JADX WARNING: Removed duplicated region for block: B:90:0x044c  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void cpA() {
                /*
                // Method dump skipped, instructions count: 1622
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.cpA():void");
            }

            private static boolean gfm() {
                AppMethodBeat.i(80248);
                if (JjD == null) {
                    try {
                        if (Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_webview_force_dark_disable", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, true), 1) > 0) {
                            Log.i("MicroMsg.WebViewUI", "disableForceDark on!!");
                            JjD = Boolean.TRUE;
                        } else {
                            Log.i("MicroMsg.WebViewUI", "disableForceDark close!!");
                            JjD = Boolean.FALSE;
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.WebViewUI", e2, "disableForceDark", new Object[0]);
                        JjD = Boolean.FALSE;
                    }
                }
                boolean booleanValue = JjD.booleanValue();
                AppMethodBeat.o(80248);
                return booleanValue;
            }

            /* access modifiers changed from: protected */
            public final int getActionBarHeight() {
                AppMethodBeat.i(80250);
                if (getResources().getDimensionPixelSize(R.dimen.apf) > com.tencent.mm.cb.a.fromDPToPix((Context) this, 48)) {
                    int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.apf);
                    AppMethodBeat.o(80250);
                    return dimensionPixelSize;
                } else if (com.tencent.mm.compatible.util.i.isPortOrientation(this)) {
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.b9);
                    AppMethodBeat.o(80250);
                    return dimensionPixelSize2;
                } else {
                    int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.b8);
                    AppMethodBeat.o(80250);
                    return dimensionPixelSize3;
                }
            }

            /* access modifiers changed from: protected */
            public final void gfn() {
                AppMethodBeat.i(80251);
                if (this.JjE == null || gfo()) {
                    AppMethodBeat.o(80251);
                    return;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.JjE.getLayoutParams();
                int gfp = gfp();
                if (gfp != marginLayoutParams.topMargin) {
                    marginLayoutParams.topMargin = gfp;
                    this.JjE.setLayoutParams(marginLayoutParams);
                }
                AppMethodBeat.o(80251);
            }

            private int gfp() {
                AppMethodBeat.i(80252);
                int bF = com.tencent.mm.ui.statusbar.a.bF(this);
                if (this.mActionBar == null || !this.mActionBar.isShowing()) {
                    AppMethodBeat.o(80252);
                    return bF;
                } else if (this.VgT.VgK.ITX) {
                    AppMethodBeat.o(80252);
                    return 0;
                } else {
                    int actionBarHeight = bF + getActionBarHeight();
                    AppMethodBeat.o(80252);
                    return actionBarHeight;
                }
            }

            /* access modifiers changed from: protected */
            public boolean gfq() {
                return true;
            }

            /* access modifiers changed from: protected */
            public int bXh() {
                AppMethodBeat.i(80254);
                int actionbarColor = getActionbarColor();
                AppMethodBeat.o(80254);
                return actionbarColor;
            }

            private boolean gfr() {
                AppMethodBeat.i(80255);
                if (Util.isNullOrNil(this.xPq) || !this.xPq.equals("black")) {
                    AppMethodBeat.o(80255);
                    return false;
                }
                AppMethodBeat.o(80255);
                return true;
            }

            public final void bt(int i2, boolean z) {
                int i3;
                AppMethodBeat.i(80257);
                if (Build.VERSION.SDK_INT < 23 || MIUI.isMIUIV8()) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (z) {
                            i2 = e.agC(i2);
                        }
                        setStatusBarColor(i2);
                    }
                    AppMethodBeat.o(80257);
                    return;
                }
                setStatusBarColor(i2);
                Window window = getWindow();
                int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
                if (z) {
                    i3 = systemUiVisibility | 8192;
                } else {
                    i3 = systemUiVisibility & -8193;
                }
                window.getDecorView().setSystemUiVisibility(i3);
                AppMethodBeat.o(80257);
            }

            @Override // com.tencent.mm.plugin.webview.core.b
            public final String fZM() {
                AppMethodBeat.i(259666);
                String currentUrl = this.IMH.getCurrentUrl();
                AppMethodBeat.o(259666);
                return currentUrl;
            }

            public final o.a gft() {
                AppMethodBeat.i(211169);
                if (this.ILE == null) {
                    AppMethodBeat.o(211169);
                    return null;
                }
                o.a baw = o.baw(this.IMH.getCurrentUrl());
                AppMethodBeat.o(211169);
                return baw;
            }

            public final String ePp() {
                return this.IMH.IJP;
            }

            public final String gfu() {
                return this.IMH.IJM;
            }

            public final String gfv() {
                return this.IMH.ILO;
            }

            public final String getUserAgent() {
                AppMethodBeat.i(211170);
                String userAgentString = this.IMH.pGj.getSettings().getUserAgentString();
                AppMethodBeat.o(211170);
                return userAgentString;
            }

            /* access modifiers changed from: protected */
            public MMWebView cpy() {
                MMWebView mMWebView;
                AppMethodBeat.i(80260);
                if (com.tencent.mm.plugin.webview.ui.tools.floatball.d.ggy()) {
                    String stringExtra = getIntent().getStringExtra("float_ball_key");
                    if (!Util.isNullOrNil(stringExtra)) {
                        com.tencent.mm.plugin.webview.ui.tools.floatball.d dVar = com.tencent.mm.plugin.webview.ui.tools.floatball.d.JmQ;
                        i baD = com.tencent.mm.plugin.webview.ui.tools.floatball.d.baD(stringExtra);
                        if (!(baD == null || (mMWebView = baD.pGj) == null || mMWebView.mDestroyed)) {
                            Log.i("MicroMsg.WebViewUI", "createWebView from cache floatBallKey=%s", stringExtra);
                            if (mMWebView.getParent() != null) {
                                ((ViewGroup) mMWebView.getParent()).removeView(mMWebView);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1553, 21, 1, false);
                                Log.w("MicroMsg.WebViewUI", "createWebView wv has parent");
                            }
                            mMWebView.aG(this);
                            mMWebView.onShow();
                            AppMethodBeat.o(80260);
                            return mMWebView;
                        }
                    }
                    MMWebView kL = MMWebView.a.kL(new MutableContextWrapper(this));
                    AppMethodBeat.o(80260);
                    return kL;
                }
                MMWebView kL2 = MMWebView.a.kL(this);
                AppMethodBeat.o(80260);
                return kL2;
            }

            @Override // com.tencent.mm.ui.widget.MMWebView.e
            public void onWebViewScrollChanged(int i2, int i3, int i4, int i5) {
                AppMethodBeat.i(80261);
                if (this.ILE != null && !this.ILE.Jkf) {
                    o oVar = this.ILE;
                    if (Util.isNullOrNil(oVar.nKc)) {
                        oVar.nKc = Util.nullAsNil(oVar.Jkg.IMH.getCurrentUrl());
                    }
                    oVar.ggh();
                }
                if (this.JhY != null) {
                    h hVar = this.JhY;
                    if (hVar.JfC) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (hVar.Jfz == 0) {
                            hVar.Jfz = currentTimeMillis;
                            hVar.JfA = i3;
                        }
                        if (Math.abs(currentTimeMillis - hVar.Jfz) > 200 && Math.abs(i3 - hVar.JfA) > hVar.JfB) {
                            if (i3 - hVar.JfA > 0 && hVar.JfG.getVisibility() == 0) {
                                hVar.geC();
                            } else if (i3 - hVar.JfA < 0 && hVar.JfG.getVisibility() != 0) {
                                hVar.geB();
                            }
                            hVar.Jfz = currentTimeMillis;
                            hVar.JfA = i3;
                        }
                    }
                }
                AppMethodBeat.o(80261);
            }

            @Override // com.tencent.mm.ui.MMActivity
            public void setMMOrientation() {
                AppMethodBeat.i(80263);
                if (getForceOrientation() == -1) {
                    this.landscapeMode = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 4).getBoolean("settings_landscape_mode", false);
                    if (this.landscapeMode) {
                        setRequestedOrientation(-1);
                        AppMethodBeat.o(80263);
                        return;
                    }
                    setRequestedOrientation(1);
                    AppMethodBeat.o(80263);
                    return;
                }
                setRequestedOrientation(getForceOrientation());
                AppMethodBeat.o(80263);
            }

            @Override // com.tencent.mm.ui.MMActivity
            public int getForceOrientation() {
                AppMethodBeat.i(211171);
                if (this.ILF.bJb()) {
                    int requestedOrientation = getRequestedOrientation();
                    AppMethodBeat.o(211171);
                    return requestedOrientation;
                }
                int i2 = this.screenOrientation;
                AppMethodBeat.o(211171);
                return i2;
            }

            @Override // com.tencent.mm.ui.MMFragmentActivity
            public void setRequestedOrientation(int i2) {
                AppMethodBeat.i(211172);
                this.screenOrientation = i2;
                updateOrientation();
                super.setRequestedOrientation(i2);
                AppMethodBeat.o(211172);
            }

            private void updateOrientation() {
                AppMethodBeat.i(211173);
                if (this.mHh != null) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putInt("screen_orientation", this.screenOrientation);
                        this.mHh.j(83, bundle);
                        AppMethodBeat.o(211173);
                        return;
                    } catch (Exception e2) {
                        Log.e("MicroMsg.WebViewUI", "ac_set_screen_orientation : " + e2.getMessage());
                    }
                }
                AppMethodBeat.o(211173);
            }

            private View gfw() {
                int i2;
                AppMethodBeat.i(80264);
                View view = null;
                try {
                    i2 = Resources.getSystem().getIdentifier("action_bar_container", "id", "android");
                } catch (Exception e2) {
                    Log.e("MicroMsg.WebViewUI", "get resId action_bar_container, exp = %s", e2);
                    i2 = -1;
                }
                if (i2 > 0) {
                    view = findViewById(i2);
                }
                Log.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", Integer.valueOf(i2), view);
                AppMethodBeat.o(80264);
                return view;
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onConfigurationChanged(Configuration configuration) {
                View view;
                AppMethodBeat.i(80265);
                super.onConfigurationChanged(configuration);
                if (this.pzw != configuration.orientation) {
                    View gfw = gfw();
                    if (gfw == null) {
                        view = null;
                    } else {
                        view = (View) gfw.getParent();
                    }
                    if (view == null) {
                        AppMethodBeat.o(80265);
                        return;
                    }
                    view.dispatchConfigurationChanged(configuration);
                    view.requestLayout();
                    this.pzw = configuration.orientation;
                }
                AppMethodBeat.o(80265);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onStart() {
                AppMethodBeat.i(80266);
                super.onStart();
                if (this.Jjs != null && gbH()) {
                    Log.i("MicroMsg.WebViewUI", "[Handoff] onStart, call onWebViewCreate " + this.Jjs.toString());
                    ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).a(this.Jjs);
                }
                Log.i("MicroMsg.WebViewUI", "edw onStart");
                AppMethodBeat.o(80266);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onStop() {
                AppMethodBeat.i(80267);
                Log.i("MicroMsg.WebViewUI", "edw onStop");
                if (this.Jjs != null && gbH()) {
                    Log.i("MicroMsg.WebViewUI", "[Handoff] onStop, call onWebViewDestroy " + this.Jjs.toString());
                    ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).b(this.Jjs);
                }
                this.JhV.finish();
                zk(true);
                super.onStop();
                AppMethodBeat.o(80267);
            }

            private static void c(Dialog dialog) {
                AppMethodBeat.i(80270);
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                    dialog.setCancelMessage(null);
                    dialog.setDismissMessage(null);
                }
                AppMethodBeat.o(80270);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onDestroy() {
                boolean z;
                Bundle j2;
                View view;
                String replace;
                int i2;
                AppMethodBeat.i(80271);
                Log.i("MicroMsg.WebViewUI", "WebViewUI onDestroy now: %s", Integer.valueOf(this.IMH.fZu()));
                if (!com.tencent.mm.plugin.webview.ui.tools.floatball.d.ggy() || this.Jju == null || !this.Jju.eqW()) {
                    z = false;
                } else {
                    MultiTaskInfo multiTaskInfo = this.Jju.Abp;
                    if (multiTaskInfo == null || Util.isNullOrNil(multiTaskInfo.field_id)) {
                        Log.w("MicroMsg.WebViewUI", "saveMultiTaskInfo taskInfo invalid");
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1553, 26, 1, false);
                    } else {
                        String str = multiTaskInfo.field_id;
                        Log.i("MicroMsg.WebViewUI", "saveMultiTaskInfo to cache multiTaskId=%s", str);
                        if (this.pGj == null || this.pGj.getParent() == null || this.pGj.getActivityContextIfHas() != this) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1553, 20, 1, false);
                            Object[] objArr = new Object[1];
                            objArr[0] = Boolean.valueOf(this.pGj == null);
                            Log.w("MicroMsg.WebViewUI", "saveMultiTaskInfo wv has no parent, %b", objArr);
                        } else {
                            if (this.ILF.bJb()) {
                                this.ILF.zs(true);
                            }
                            this.pGj.onHide();
                            ((ViewGroup) this.pGj.getParent()).removeView(this.pGj);
                        }
                        this.IMH.b(this.JjS);
                        this.IMH.b(this.JjS.Jkd);
                        if (this.IBw != null) {
                            this.IBw.yW(true);
                        }
                        com.tencent.mm.plugin.webview.ui.tools.floatball.c cVar = this.IMH.ILG;
                        if (getMMTitle() != null) {
                            t controller = getController();
                            if (controller.OGj != null) {
                                i2 = controller.OGj.getVisibility();
                            } else {
                                i2 = 0;
                            }
                            if (i2 == 0) {
                                cVar.title = getMMTitle().toString();
                            }
                        }
                        com.tencent.mm.plugin.webview.ui.tools.floatball.d dVar = com.tencent.mm.plugin.webview.ui.tools.floatball.d.JmQ;
                        com.tencent.mm.plugin.webview.ui.tools.floatball.d.a(str, this.IMH);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1553, 0, 1, false);
                    }
                    z = true;
                }
                super.onDestroy();
                com.tencent.mm.plugin.webview.modeltools.c.gdm();
                String currentUrl = this.IMH.getCurrentUrl();
                if (currentUrl != null) {
                    String ie = k.ie(this);
                    if (ie != null && currentUrl.equals(ie)) {
                        k.m33if(this);
                    }
                } else {
                    Log.w("MicroMsg.WebViewUI", "currentURL == null, qbrowser.url may be not accurate");
                }
                if (this.Jjt != null) {
                    this.Jjt.onDestroy();
                }
                if (this.Jij != null) {
                    WebViewRedesignInputFooter webViewRedesignInputFooter = this.Jij;
                    webViewRedesignInputFooter.giE();
                    if (!(webViewRedesignInputFooter.JAO == null || webViewRedesignInputFooter.gte == null)) {
                        webViewRedesignInputFooter.gte.hideVKB(webViewRedesignInputFooter.JAO);
                    }
                    webViewRedesignInputFooter.JAO = null;
                    webViewRedesignInputFooter.JAK.onDestroy();
                    webViewRedesignInputFooter.removeAllViews();
                    webViewRedesignInputFooter.gte = null;
                    webViewRedesignInputFooter.JAU = null;
                }
                if (this.Jjs != null) {
                    Log.i("MicroMsg.WebViewUI", "onDestroy, invalidate mHandOffURL");
                    this.Jjs = null;
                }
                if (this.Jii != null) {
                    this.Jii.disable();
                }
                this.Jjd = true;
                Jjc--;
                int fZu = this.IMH.fZu();
                int size = JiD.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    } else if (JiD.get(size).id == fZu) {
                        JiD.remove(size);
                        break;
                    } else {
                        size--;
                    }
                }
                this.IMs.gdg().D(coX(), 2).report();
                az azVar = this.IMs;
                az.k gda = azVar.gda();
                int bHy = az.bHy();
                for (Map.Entry<String, Long> entry : gda.Jan.entrySet()) {
                    String key = entry.getKey();
                    long longValue = entry.getValue().longValue();
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(32, 0, 1, true);
                    if (longValue >= 0 && longValue <= 180000) {
                        String str2 = gda.Jak;
                        Object[] objArr2 = new Object[11];
                        objArr2[0] = 3;
                        objArr2[1] = Long.valueOf(longValue);
                        objArr2[2] = Integer.valueOf(bHy);
                        if (key == null) {
                            replace = key;
                        } else {
                            replace = key.replace(",", "!");
                        }
                        objArr2[3] = replace;
                        objArr2[4] = 0;
                        objArr2[5] = 0;
                        objArr2[6] = 0;
                        objArr2[7] = Integer.valueOf(az.access$000());
                        objArr2[8] = Integer.valueOf(az.access$100());
                        objArr2[9] = Integer.valueOf(gda.ehX);
                        objArr2[10] = gda.Jak;
                        az.r(str2, objArr2);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(160, 0, 1, false);
                        if (-1 != com.tencent.mm.plugin.webview.i.a.Me(longValue)) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(160, (long) com.tencent.mm.plugin.webview.i.a.Me(longValue), 1, false);
                        }
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(32, 3, 1, true);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(32, 7, longValue, true);
                        if (az.access$100() == 1) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(32, 16, 1, true);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(32, 17, longValue, true);
                        }
                        Log.i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", key, Long.valueOf(longValue), Integer.valueOf(bHy), Integer.valueOf(az.access$000()), Integer.valueOf(az.access$100()), Integer.valueOf(gda.ehX), gda.Jak);
                    }
                }
                ax gdc = azVar.gdc();
                if (!Util.isNullOrNil(gdc.IZB)) {
                    Log.d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", gdc.IZB);
                }
                try {
                    com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, IPCVoid.hnE, ax.a.IZJ.getClass(), new ax.b(gdc));
                } catch (RemoteException e2) {
                    Log.w("MicroMsg.WebviewReporter", "invokeAsResult error, %s", e2);
                }
                ak gdd = azVar.gdd();
                if (!Util.isNullOrNil(gdd.iAh)) {
                    String str3 = gdd.iAh;
                    if (str3 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    if (kotlin.n.n.J(str3, "wrd", false)) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("iswebviewreadtime=1");
                        stringBuffer.append("&publishid=");
                        stringBuffer.append(gdd.iAh);
                        stringBuffer.append("&staytime=");
                        stringBuffer.append(gdd.dUy);
                        stringBuffer.append("&allstaytime=");
                        stringBuffer.append(System.currentTimeMillis() - gdd.enterTime);
                        stringBuffer.append("&maxscrolly=");
                        stringBuffer.append(gdd.IZc);
                        stringBuffer.append("&totalscrolly=");
                        stringBuffer.append(gdd.EOU);
                        stringBuffer.append("&scene=");
                        stringBuffer.append(gdd.scene);
                        stringBuffer.append("&entertime=");
                        stringBuffer.append(gdd.enterTime);
                        stringBuffer.append("&screenheight=");
                        stringBuffer.append(com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()));
                        Bundle bundle = new Bundle();
                        bundle.putString("reportString", stringBuffer.toString());
                        try {
                            com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, ak.a.IZd.getClass(), null);
                        } catch (Exception e3) {
                            Log.printErrStackTrace("MicroMsg.WebviewReporter", e3, "TopStory report", new Object[0]);
                        }
                    }
                }
                azVar.gcZ().report();
                azVar.gdb().report();
                az.b gdf = azVar.gdf();
                int bHy2 = az.bHy();
                if (!gdf.Jae) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11575, gdf.edo, 3, 1, Integer.valueOf(bHy2));
                } else if (gdf.loadFinished) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11575, gdf.edo, 1, 1, Integer.valueOf(bHy2));
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11575, gdf.edo, 2, 1, Integer.valueOf(bHy2));
                }
                az azVar2 = this.IMs;
                azVar2.IZO = null;
                azVar2.IZM = null;
                azVar2.IZN = null;
                azVar2.IZL = null;
                azVar2.IZQ = null;
                azVar2.IZR = null;
                azVar2.IZS = null;
                azVar2.IZT = null;
                if (azVar2.IZY != null) {
                    azVar2.IZY.dQL = null;
                    azVar2.IZY = null;
                }
                aYq("onDestroy");
                if (this.JiM != null) {
                    this.JiM.clear();
                }
                gfd();
                c(this.JiR);
                if (this.JiG != null && (this.JiG instanceof b)) {
                    c(((b) this.JiG).kvo);
                }
                if (this.Jij != null) {
                    this.Jij.setOnTextSendListener(null);
                }
                if (!(this.JhY == null || (view = this.JhY.JfG) == null)) {
                    Animation animation = view.getAnimation();
                    if (animation != null) {
                        animation.setAnimationListener(null);
                    }
                    view.clearAnimation();
                }
                if (this.JiN != null) {
                    this.JiN.clear();
                }
                this.Jjx.dead();
                this.JiJ.dead();
                if (com.tencent.xweb.d.lA(MMApplicationContext.getContext()) != null) {
                    Log.i("MicroMsg.WebViewUI", "now force sync the cookie between ram and db");
                    try {
                        com.tencent.xweb.d.sync();
                    } catch (Exception e4) {
                        Log.e("MicroMsg.WebViewUI", "sync cookies failed : %s", e4.getMessage());
                    }
                }
                Log.v("MicroMsg.WebViewUI", "on destroy isNeedCallbackMMRpt[%b]", Boolean.valueOf(this.Jir));
                if (this.Jir) {
                    try {
                        Bundle bundleExtra = getIntent().getBundleExtra("mm_report_bundle");
                        if (Util.isNullOrNil(bundleExtra.getString("mm_event_class"))) {
                            Log.w("MicroMsg.WebViewUI", "webview on destroy callback mm but eventclass is null");
                        } else if (this.mHh != null) {
                            bundleExtra.putLong("key_activity_browse_time", getActivityBrowseTimeMs());
                            this.mHh.j(250, bundleExtra);
                        }
                    } catch (Exception e5) {
                        Log.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", e5.toString());
                    }
                }
                try {
                    if (this.mHh != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putLong("key_activity_browse_time", getActivityBrowseTimeMs());
                        this.mHh.j(251, bundle2);
                    }
                } catch (Exception e6) {
                    Log.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", e6.toString());
                }
                try {
                    if (!(this.mHh == null || (j2 = this.mHh.j(19, null)) == null)) {
                        boolean z2 = j2.getBoolean("webview_video_proxy_init");
                        Log.i("MicroMsg.WebViewUI", "onDestroy, has init = %b, webviewHoldingCounter = %d", Boolean.valueOf(z2), Integer.valueOf(Jjc));
                        if (z2 && Jjc <= 0) {
                            FactoryProxyManager.getPlayManager().deinit();
                            this.mHh.j(75, null);
                        }
                    }
                } catch (Exception e7) {
                    Log.e("MicroMsg.WebViewUI", "deinit video player failed : %s", e7.getMessage());
                }
                if (this.pGj != null) {
                    this.pGj.QDX = null;
                }
                if (!z) {
                    this.IMH.fZZ();
                    if (this.mHi != null) {
                        com.tencent.mm.plugin.webview.f.g gVar = this.mHi;
                        Log.i("MicroMsg.WebViewPermission", "detach");
                        gVar.Jce.clear();
                        gVar.Jce = null;
                        this.mHi = null;
                    }
                    this.pGj = null;
                }
                this.Jjk.gdG();
                try {
                    this.JjI.release();
                    if (getContentView() instanceof ViewGroup) {
                        ((ViewGroup) getContentView()).removeAllViews();
                    }
                } catch (Throwable th) {
                    Log.w("MicroMsg.WebViewUI", "onDestroy contentView removeAllViews %s", th);
                }
                try {
                    ((ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard")).removePrimaryClipChangedListener(this.Jjo);
                } catch (Exception e8) {
                }
                com.tencent.mm.plugin.webview.c cVar2 = this.Jjp;
                if (cVar2.tipDialog != null && cVar2.tipDialog.isShowing()) {
                    cVar2.tipDialog.dismiss();
                    cVar2.tipDialog = null;
                }
                EventCenter.instance.removeListener(cVar2.IJD);
                if (this.Jjn != null) {
                    this.Jjn = null;
                    FactoryProxyManager.getPlayManager().setUtilsObject(null);
                }
                System.gc();
                AppMethodBeat.o(80271);
            }

            public final void gfx() {
                AppMethodBeat.i(80272);
                Log.i("MicroMsg.WebViewUI", "forceQuit");
                try {
                    this.JjI.release();
                    this.pGj.stopLoading();
                    this.pGj.removeAllViews();
                    this.pGj.clearView();
                } catch (Exception e2) {
                    Log.e("MicroMsg.WebViewUI", "forceQuit, ex = " + e2.getMessage());
                }
                if (this.IBw != null) {
                    this.IBw.detach();
                }
                try {
                    this.pGj.destroy();
                } catch (Exception e3) {
                    Log.w("MicroMsg.WebViewUI", "forceQuit, viewWV destroy, ex = %s", e3.getMessage());
                }
                finish();
                Log.appenderFlush();
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI", "forceQuit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                Process.killProcess(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI", "forceQuit", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                AppMethodBeat.o(80272);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
            public boolean onKeyUp(int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(80273);
                if (i2 != 82 || this.JjH) {
                    boolean onKeyUp = super.onKeyUp(i2, keyEvent);
                    AppMethodBeat.o(80273);
                    return onKeyUp;
                }
                AppMethodBeat.o(80273);
                return true;
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
            public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                boolean z;
                AppMethodBeat.i(80274);
                Log.i("MicroMsg.WebViewUI", "onKeyDown keyCode %d", Integer.valueOf(i2));
                if (i2 == 4) {
                    if (this.pGj != null && this.pGj.hasEnteredFullscreen()) {
                        this.pGj.leaveFullscreen();
                        AppMethodBeat.o(80274);
                        return true;
                    } else if (this.ILF.zs(false)) {
                        AppMethodBeat.o(80274);
                        return true;
                    }
                }
                if (i2 != 4 || this.vk == null || this.JiF == null || this.JiG == null) {
                    if (i2 == 4) {
                        if (this.Jij == null || !this.Jij.isShown()) {
                            z = false;
                        } else {
                            this.Jij.hide();
                            gfM();
                            z = true;
                        }
                        if (z) {
                            AppMethodBeat.o(80274);
                            return true;
                        }
                    }
                    if (i2 == 4) {
                        if (this.pGj == null || !this.pGj.canGoBack() || !this.Jio) {
                            l.Jhd.close();
                        } else {
                            gfy();
                            this.IMs.gdg().D(coX(), 1).report();
                            AppMethodBeat.o(80274);
                            return true;
                        }
                    }
                    if (i2 == 4 && gfQ() && gbB()) {
                        AppMethodBeat.o(80274);
                        return true;
                    } else if (i2 == 4 && this.Jjt != null && this.Jjt.wu(2)) {
                        AppMethodBeat.o(80274);
                        return true;
                    } else if (i2 == 4 && this.Jju != null && this.Jju.wu(2)) {
                        AppMethodBeat.o(80274);
                        return true;
                    } else if (i2 != 4 || this.Jjy == null || !this.Jjy.bJw()) {
                        if (i2 == 4) {
                            gfS();
                        }
                        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
                        AppMethodBeat.o(80274);
                        return onKeyDown;
                    } else {
                        this.Jjy.hide();
                        AppMethodBeat.o(80274);
                        return true;
                    }
                } else {
                    try {
                        this.JiG.onHideCustomView();
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.WebViewUI", e2, "onkeydown", new Object[0]);
                    }
                    this.IMs.gdg().D(coX(), 1).report();
                    AppMethodBeat.o(80274);
                    return true;
                }
            }

            /* access modifiers changed from: protected */
            public void gfy() {
                AppMethodBeat.i(80275);
                this.Jiq = System.currentTimeMillis();
                this.pGj.goBack();
                l lVar = l.Jhd;
                Log.v("MicroMsg.WebViewReportUtil", "goBack traceid %s", lVar.traceid);
                if (!Util.isNullOrNil(lVar.traceid)) {
                    lVar.pl(5);
                }
                AppMethodBeat.o(80275);
            }

            /* access modifiers changed from: protected */
            public void aG(String str, int i2, int i3) {
                AppMethodBeat.i(211174);
                if (this.Jij == null) {
                    AppMethodBeat.o(211174);
                    return;
                }
                WebViewRedesignInputFooter webViewRedesignInputFooter = this.Jij;
                webViewRedesignInputFooter.setVisibility(0);
                if (webViewRedesignInputFooter.VhR != null) {
                    webViewRedesignInputFooter.VhR.setVisibility(0);
                }
                if (webViewRedesignInputFooter.JAP != null) {
                    webViewRedesignInputFooter.JAP.setVisibility(0);
                }
                if (webViewRedesignInputFooter.JAO != null) {
                    webViewRedesignInputFooter.JAO.setEnabled(true);
                    webViewRedesignInputFooter.JAO.setBackgroundResource(R.drawable.b4w);
                }
                if (webViewRedesignInputFooter.JAL != null) {
                    webViewRedesignInputFooter.JAL.setVisibility(0);
                }
                webViewRedesignInputFooter.JAQ = false;
                if (webViewRedesignInputFooter.JAO != null) {
                    webViewRedesignInputFooter.JAO.setFocusable(true);
                    webViewRedesignInputFooter.JAO.setFocusableInTouchMode(true);
                    webViewRedesignInputFooter.JAO.requestFocus();
                }
                if (webViewRedesignInputFooter.gte != null) {
                    webViewRedesignInputFooter.gte.showVKB();
                }
                webViewRedesignInputFooter.state = 0;
                if (!Util.isNullOrNil(str)) {
                    this.Jij.setText(str);
                }
                if (i2 >= 0) {
                    this.Jij.setMaxCount(i2);
                    this.Jij.setShowRemindWordCount(i3);
                }
                AppMethodBeat.o(211174);
            }

            /* access modifiers changed from: protected */
            public int gfz() {
                AppMethodBeat.i(80277);
                if (this.Jij == null) {
                    AppMethodBeat.o(80277);
                    return 0;
                }
                WebViewRedesignInputFooter webViewRedesignInputFooter = this.Jij;
                webViewRedesignInputFooter.setVisibility(0);
                if (webViewRedesignInputFooter.JAP != null) {
                    webViewRedesignInputFooter.JAP.setVisibility(8);
                }
                webViewRedesignInputFooter.JAQ = true;
                webViewRedesignInputFooter.state = 1;
                int gfz = webViewRedesignInputFooter.gfz();
                AppMethodBeat.o(80277);
                return gfz;
            }

            /* access modifiers changed from: protected */
            public void geA() {
                AppMethodBeat.i(80278);
                int intExtra = getIntent().getIntExtra("webview_bg_color_rsID", -1);
                if (intExtra != -1 && getContentView() != null) {
                    setBackGroundColorResource(intExtra);
                    getContentView().setBackgroundResource(intExtra);
                    this.pGj.setBackgroundResource(17170445);
                    this.Jic.setBackgroundResource(17170445);
                    this.Jid.setBackgroundResource(17170445);
                    AppMethodBeat.o(80278);
                } else if (getIntent().getBooleanExtra(e.p.OzJ, false)) {
                    this.pGj.setBackgroundColor(getResources().getColor(R.color.am));
                    AppMethodBeat.o(80278);
                } else {
                    this.pGj.setBackgroundColor(getResources().getColor(R.color.afz));
                    AppMethodBeat.o(80278);
                }
            }

            /* access modifiers changed from: protected */
            public void gfA() {
                AppMethodBeat.i(80279);
                if (getIntent() == null) {
                    AppMethodBeat.o(80279);
                    return;
                }
                if (getIntent().hasExtra("show_full_screen")) {
                    aV(getIntent().getBooleanExtra("show_full_screen", false), true);
                }
                AppMethodBeat.o(80279);
            }

            /* access modifiers changed from: protected */
            public final void aV(boolean z, boolean z2) {
                AppMethodBeat.i(80280);
                this.Jig = z;
                if (z) {
                    if (this.mActionBar != null) {
                        this.mActionBar.hide();
                    }
                    if (this.JjE != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.JjE.getLayoutParams();
                        marginLayoutParams.topMargin = 0;
                        this.JjE.setLayoutParams(marginLayoutParams);
                    }
                    com.tencent.mm.ui.statusbar.a.T(this.JjE, true);
                    getWindow().addFlags(1024);
                    final View decorView = getWindow().getDecorView();
                    decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass5 */

                        public final void onSystemUiVisibilityChange(int i2) {
                            AppMethodBeat.i(259624);
                            if ((i2 & 4) == 0 && WebViewUI.this.Jig) {
                                WebViewUI.gf(decorView);
                            }
                            AppMethodBeat.o(259624);
                        }
                    });
                    aC(decorView, 5894);
                    if (z2) {
                        this.Jif.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass6 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(259625);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                WebViewUI.this.cpD();
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(259625);
                            }
                        });
                        this.Jif.setVisibility(0);
                        AppMethodBeat.o(80280);
                        return;
                    }
                    this.Jif.setVisibility(8);
                    AppMethodBeat.o(80280);
                    return;
                }
                this.Jif.setVisibility(8);
                getWindow().clearFlags(1024);
                ge(getWindow().getDecorView());
                if (this.mActionBar != null) {
                    this.mActionBar.show();
                    if (this.JjE != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.JjE.getLayoutParams();
                        marginLayoutParams2.topMargin = gfp();
                        this.JjE.setLayoutParams(marginLayoutParams2);
                    }
                }
                com.tencent.mm.ui.statusbar.a.T(this.JjE, false);
                AppMethodBeat.o(80280);
            }

            /* access modifiers changed from: protected */
            public final boolean bTK() {
                return this.Jig;
            }

            public final boolean gfB() {
                AppMethodBeat.i(211175);
                if (this.Jig || this.ILF.bJb() || (this.JjA != null && this.JjA.bJb())) {
                    AppMethodBeat.o(211175);
                    return true;
                }
                AppMethodBeat.o(211175);
                return false;
            }

            private static void aC(View view, int i2) {
                AppMethodBeat.i(80281);
                if (view == null) {
                    AppMethodBeat.o(80281);
                    return;
                }
                view.setSystemUiVisibility(view.getSystemUiVisibility() | i2);
                AppMethodBeat.o(80281);
            }

            private static void ge(View view) {
                AppMethodBeat.i(80282);
                if (view == null) {
                    AppMethodBeat.o(80282);
                    return;
                }
                view.setSystemUiVisibility(view.getSystemUiVisibility() & -5895);
                AppMethodBeat.o(80282);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
            public void onWindowFocusChanged(boolean z) {
                AppMethodBeat.i(80283);
                AppMethodBeat.at(this, z);
                super.onWindowFocusChanged(z);
                if (this.IBw != null) {
                    this.IBw.onWindowFocusChanged(z);
                }
                if (z && gfB()) {
                    aC(getWindow().getDecorView(), 5894);
                }
                AppMethodBeat.o(80283);
            }

            @Override // com.tencent.mm.ui.MMActivity
            public void initView() {
                String valueOf;
                String valueOf2;
                AppMethodBeat.i(80284);
                this.Jic = (WebViewKeyboardLinearLayout) findViewById(R.id.jkw);
                this.Jid = (FrameLayout) findViewById(R.id.h8y);
                this.Jiw = getIntent().getBooleanExtra("finishviewifloadfailed", false);
                this.Jiv = getIntent().getBooleanExtra("is_favorite_item", false);
                this.CSQ = getIntent().getBooleanExtra("isWebwx", true);
                boolean booleanExtra = getIntent().getBooleanExtra("show_feedback", false);
                this.JiT = Util.nullAsNil(getIntent().getStringExtra("sentUsername"));
                if (booleanExtra) {
                    addTextOptionMenu(1, getString(R.string.gox), new MenuItem.OnMenuItemClickListener() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass7 */

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            AppMethodBeat.i(259626);
                            try {
                                WebViewUI.this.loadUrl(WebViewUI.this.mHh.baa(null));
                            } catch (RemoteException e2) {
                                Log.printErrStackTrace("MicroMsg.WebViewUI", e2, "[oneliang]feedback exception:%s", e2.getMessage());
                            }
                            AppMethodBeat.o(259626);
                            return false;
                        }
                    });
                }
                this.JhW = (ProgressBar) findViewById(R.id.bi5);
                if (!(this.VgT == null || this.JhW == null || !this.VgT.VgK.ITX)) {
                    this.JhW.setVisibility(0);
                    this.JiX = true;
                }
                this.JiS = findViewById(R.id.gym);
                this.JiS.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass8 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(259627);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        WebViewUI.this.gfV();
                        if (!(WebViewUI.this.VgT == null || WebViewUI.this.JhW == null || !WebViewUI.this.VgT.VgK.ITX)) {
                            WebViewUI.this.JhW.setVisibility(0);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(259627);
                    }
                });
                if (this.CSQ) {
                    String nullAsNil = Util.nullAsNil(getIntent().getStringExtra("title"));
                    if (nullAsNil.length() > 0) {
                        this.JhT = true;
                    }
                    this.JhU = getIntent().getBooleanExtra("key_show_web_page_title", false);
                    setMMTitle((CharSequence) nullAsNil);
                } else {
                    setMMTitle("");
                }
                this.JfG = findViewById(R.id.jka);
                if (this.JfG != null) {
                    this.JhY = new h(this.JfG, this.Jic, this.pGj);
                    this.JfG.setVisibility(8);
                    this.JhZ = (ImageButton) findViewById(R.id.jk7);
                    this.JhZ.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass35 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(211121);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (WebViewUI.this.pGj != null && WebViewUI.this.pGj.canGoBack()) {
                                WebViewUI.this.gfy();
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(211121);
                        }
                    });
                    this.Jia = (ImageButton) findViewById(R.id.jk_);
                    this.Jia.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass36 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(80091);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (WebViewUI.this.pGj != null && WebViewUI.this.pGj.canGoForward()) {
                                WebViewUI.this.pGj.goForward();
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(80091);
                        }
                    });
                }
                if (this.pGj == null) {
                    Log.i("MicroMsg.WebViewUI", "initView viewWV is null");
                    finish();
                    AppMethodBeat.o(80284);
                    return;
                }
                if (JiI == WebSettings.RenderPriority.NORMAL) {
                    Log.i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
                    this.pGj.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
                    JiI = WebSettings.RenderPriority.HIGH;
                }
                k kVar = this.JjI;
                View contentView = getContentView();
                kVar.JgO = (LogoWebViewWrapper) contentView.findViewById(R.id.esn);
                kVar.JgN = (ImageView) contentView.findViewById(R.id.jky);
                kVar.JgW = contentView.findViewById(R.id.jkx);
                if (kVar.JgW != null) {
                    kVar.JgX = kVar.JgW.findViewById(R.id.js0);
                    kVar.JgY = (TextView) kVar.JgX.findViewById(R.id.js2);
                }
                kVar.JgP = BackwardSupportUtil.BitmapFactory.fromDPToPix(kVar.JgO.getContext(), 72.0f);
                Object[] objArr = new Object[2];
                if (kVar.JgN == null) {
                    valueOf = BuildConfig.COMMAND;
                } else {
                    valueOf = String.valueOf(kVar.JgN.getId());
                }
                objArr[0] = valueOf;
                if (kVar.JgO == null) {
                    valueOf2 = BuildConfig.COMMAND;
                } else {
                    valueOf2 = String.valueOf(kVar.JgO.getId());
                }
                objArr[1] = valueOf2;
                Log.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage.id = %s, logoWrapper.id = %s", objArr);
                Log.d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", Integer.valueOf(kVar.JgP));
                k kVar2 = this.JjI;
                MMWebView mMWebView = this.pGj;
                mMWebView.setCompetitorView(kVar2.JgO);
                mMWebView.gYX();
                if (Build.VERSION.SDK_INT <= 10) {
                    kVar2.JgO.getWebViewContainer().setBackgroundColor(kVar2.JgO.getResources().getColor(R.color.afj));
                }
                LogoWebViewWrapper logoWebViewWrapper = kVar2.JgO;
                logoWebViewWrapper.getWebViewContainer();
                if (logoWebViewWrapper.Jea != null) {
                    logoWebViewWrapper.gxL = mMWebView;
                    logoWebViewWrapper.Jea.addView(logoWebViewWrapper.gxL);
                }
                if (mMWebView.isXWalkKernel() || mMWebView.getIsX5Kernel()) {
                    kVar2.JgZ = true;
                } else {
                    kVar2.JgZ = false;
                }
                if (kVar2.JgX != null && !mMWebView.getIsX5Kernel()) {
                    ((ImageView) kVar2.JgX.findViewById(R.id.js1)).setVisibility(8);
                    ((TextView) kVar2.JgX.findViewById(R.id.dy_)).setText("");
                }
                if (!kVar2.JgZ || kVar2.Jha) {
                    kVar2.zh(true);
                } else {
                    kVar2.zh(false);
                    kVar2.geX();
                }
                geA();
                this.Jie = (FrameLayout) findViewById(R.id.be3);
                Log.i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.pGj.getIsX5Kernel());
                this.pGj.setWebViewClientExtension(new b(this));
                if (this.pGj.getIsX5Kernel()) {
                    this.pGj.setWebViewCallbackClient(this.Jjw);
                    k kVar3 = this.JjI;
                    AnonymousClass9 r1 = new LogoWebViewWrapper.a() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass9 */

                        @Override // com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.a
                        public final void geq() {
                            AppMethodBeat.i(259628);
                            if (WebViewUI.this.pGj.getIsX5Kernel()) {
                                WebViewUI.this.IMs.gdg().D(WebViewUI.this.coX(), 10).report();
                            }
                            AppMethodBeat.o(259628);
                        }
                    };
                    if (kVar3.JgO != null) {
                        kVar3.JgO.setMMOverScrollListener(r1);
                    }
                }
                this.VgS = findViewById(R.id.k3h);
                this.Jij = (WebViewRedesignInputFooter) findViewById(R.id.jkr);
                if (this.Jij != null) {
                    this.Jij.setInputShadowView(this.VgS);
                    this.Jij.hide();
                    this.Jij.setOnTextSendListener(new WebViewRedesignInputFooter.b() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass10 */

                        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.b
                        public final void bau(String str) {
                            AppMethodBeat.i(259629);
                            WebViewUI.a(WebViewUI.this, str);
                            AppMethodBeat.o(259629);
                        }

                        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.b
                        public final void bav(String str) {
                            AppMethodBeat.i(259630);
                            WebViewUI.b(WebViewUI.this, str);
                            AppMethodBeat.o(259630);
                        }
                    });
                    this.Jij.setOnSmileyChosenListener(new WebViewRedesignInputFooter.a() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass12 */

                        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.a
                        public final boolean afZ(String str) {
                            AppMethodBeat.i(259631);
                            if (WebViewUI.this.IBw != null) {
                                h hVar = WebViewUI.this.IBw;
                                if (!hVar.GBl) {
                                    Log.e("MicroMsg.JsApiHandler", "not ready");
                                } else {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("smiley", str);
                                    MMHandlerThread.postToMainThread(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003d: INVOKE  
                                          (wrap: com.tencent.mm.plugin.webview.d.h$27 : 0x003a: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.webview.d.h$27) = 
                                          (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                          (wrap: java.lang.String : 0x0034: INVOKE  (r1v2 java.lang.String) = 
                                          ("onGetSmiley")
                                          (r1v1 'hashMap' java.util.HashMap)
                                          (wrap: boolean : 0x0030: IGET  (r3v0 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                          (wrap: java.lang.String : 0x0032: IGET  (r4v0 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                         type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                         call: com.tencent.mm.plugin.webview.d.h.27.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                         type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12.afZ(java.lang.String):boolean, file: classes.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003a: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.webview.d.h$27) = 
                                          (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h)
                                          (wrap: java.lang.String : 0x0034: INVOKE  (r1v2 java.lang.String) = 
                                          ("onGetSmiley")
                                          (r1v1 'hashMap' java.util.HashMap)
                                          (wrap: boolean : 0x0030: IGET  (r3v0 boolean) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                          (wrap: java.lang.String : 0x0032: IGET  (r4v0 java.lang.String) = (r0v4 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                         type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                         call: com.tencent.mm.plugin.webview.d.h.27.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12.afZ(java.lang.String):boolean, file: classes.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 24 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 30 more
                                        */
                                    /*
                                        this = this;
                                        r5 = 259631(0x3f62f, float:3.6382E-40)
                                        com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                                        com.tencent.mm.plugin.webview.ui.tools.WebViewUI r0 = com.tencent.mm.plugin.webview.ui.tools.WebViewUI.this
                                        com.tencent.mm.plugin.webview.d.h r0 = r0.IBw
                                        if (r0 == 0) goto L_0x001d
                                        com.tencent.mm.plugin.webview.ui.tools.WebViewUI r0 = com.tencent.mm.plugin.webview.ui.tools.WebViewUI.this
                                        com.tencent.mm.plugin.webview.d.h r0 = r0.IBw
                                        boolean r1 = r0.GBl
                                        if (r1 != 0) goto L_0x0022
                                        java.lang.String r0 = "MicroMsg.JsApiHandler"
                                        java.lang.String r1 = "not ready"
                                        com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
                                    L_0x001d:
                                        r0 = 1
                                        com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                                        return r0
                                    L_0x0022:
                                        java.util.HashMap r1 = new java.util.HashMap
                                        r1.<init>()
                                        java.lang.String r2 = "smiley"
                                        r1.put(r2, r7)
                                        java.lang.String r2 = "onGetSmiley"
                                        boolean r3 = r0.IRj
                                        java.lang.String r4 = r0.zpY
                                        java.lang.String r1 = com.tencent.mm.plugin.webview.d.n.a.b(r2, r1, r3, r4)
                                        com.tencent.mm.plugin.webview.d.h$27 r2 = new com.tencent.mm.plugin.webview.d.h$27
                                        r2.<init>(r1)
                                        com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)
                                        goto L_0x001d
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass12.afZ(java.lang.String):boolean");
                                }
                            });
                            this.Jij.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b() {
                                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass13 */

                                @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b
                                public final void gbP() {
                                    AppMethodBeat.i(259632);
                                    WebViewUI.a(WebViewUI.this, 0);
                                    AppMethodBeat.o(259632);
                                }

                                @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b
                                public final void gbQ() {
                                    AppMethodBeat.i(259633);
                                    WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = WebViewUI.this.Jic;
                                    if (webViewKeyboardLinearLayout != null && webViewKeyboardLinearLayout.getKeyBoardHeight() > 0) {
                                        WebViewUI.a(WebViewUI.this, webViewKeyboardLinearLayout.getKeyBoardHeight());
                                    }
                                    AppMethodBeat.o(259633);
                                }
                            });
                        }
                        this.Jik = (WebViewSearchContentInputFooter) findViewById(R.id.hdp);
                        if (this.Jik != null) {
                            this.Jik.setActionDelegate(new WebViewSearchContentInputFooter.a() {
                                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass14 */

                                @Override // com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a
                                public final void gbR() {
                                    AppMethodBeat.i(259634);
                                    WebViewUI.b(WebViewUI.this, 0);
                                    WebViewUI.this.pGj.clearMatches();
                                    WebViewUI.this.Jik.giD();
                                    AppMethodBeat.o(259634);
                                }

                                @Override // com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a
                                public final void a(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                                    AppMethodBeat.i(259635);
                                    if (webViewSearchContentInputFooter.getVisibility() == 0) {
                                        b(webViewSearchContentInputFooter);
                                    }
                                    AppMethodBeat.o(259635);
                                }

                                @Override // com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a
                                public final void gbS() {
                                    AppMethodBeat.i(259636);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(480, 5, 1, false);
                                    WebViewUI.this.pGj.findNext(false);
                                    AppMethodBeat.o(259636);
                                }

                                @Override // com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a
                                public final void gbT() {
                                    AppMethodBeat.i(259637);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(480, 4, 1, false);
                                    WebViewUI.this.pGj.findNext(true);
                                    AppMethodBeat.o(259637);
                                }

                                @Override // com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a
                                public final void b(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                                    AppMethodBeat.i(259638);
                                    WebViewUI.this.pGj.clearMatches();
                                    webViewSearchContentInputFooter.reset();
                                    WebViewUI.this.Jik.H(0, 0, true);
                                    WebViewUI.this.Jil = false;
                                    WebViewUI.this.pGj.findAllAsync(webViewSearchContentInputFooter.getSearchContent());
                                    AppMethodBeat.o(259638);
                                }

                                @Override // com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a
                                public final boolean c(int i2, KeyEvent keyEvent) {
                                    AppMethodBeat.i(259639);
                                    if (i2 == 67 && keyEvent.getAction() == 0) {
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(480, 6, 1, false);
                                    }
                                    AppMethodBeat.o(259639);
                                    return false;
                                }
                            });
                            this.pGj.setFindListener(new WebView.FindListener() {
                                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass15 */

                                public final void onFindResultReceived(int i2, int i3, boolean z) {
                                    AppMethodBeat.i(259640);
                                    if (z && !WebViewUI.this.Jil && !Util.isNullOrNil(WebViewUI.this.Jik.getSearchContent())) {
                                        if (i3 == 0) {
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(480, 3, 1, false);
                                        } else {
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(480, 2, 1, false);
                                        }
                                        WebViewUI.this.Jil = true;
                                    }
                                    WebViewUI.this.Jik.H(i2, i3, z);
                                    AppMethodBeat.o(259640);
                                }
                            });
                        }
                        this.Jif = (MovingImageButton) findViewById(R.id.dc0);
                        this.JiB = findViewById(R.id.jko);
                        if (this.JiB != null) {
                            this.JiB.setVisibility(8);
                        }
                        this.pGj.setWebChromeClient(gfC());
                        this.pGj.setDownloadListener(new DownloadListener() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass16 */

                            public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                                AppMethodBeat.i(259641);
                                Log.i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + str + ", mimetype = " + str4 + ", userAgent = " + str2 + ", contentDisposition = " + str3);
                                int intExtra = WebViewUI.this.getIntent().getIntExtra("key_download_restrict", 0);
                                String stringExtra = WebViewUI.this.getIntent().getStringExtra("key_function_id");
                                if (!Util.isNullOrNil(stringExtra)) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14596, stringExtra, Integer.valueOf(intExtra), 0);
                                }
                                if (intExtra == 1) {
                                    Log.e("MicroMsg.WebViewUI", "not allow download file : %s", str);
                                    AppMethodBeat.o(259641);
                                    return;
                                }
                                if (str4 != null && str4.equalsIgnoreCase("application/vnd.android.package-archive")) {
                                    Log.v("MicroMsg.WebViewUI", "edw onDownloadStart, report download url: %s", str);
                                    e.a(WebViewUI.this.mHh, 11154, str);
                                }
                                if (WebViewUI.this.mHi == null) {
                                    Log.e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
                                    AppMethodBeat.o(259641);
                                    return;
                                }
                                boolean z = false;
                                if (str4 != null) {
                                    boolean d2 = WebViewUI.d(WebViewUI.this);
                                    Log.i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", Boolean.valueOf(d2));
                                    String bat = WebViewUI.bat(str3);
                                    z = d2 && ((bat != null && Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", bat)) || com.tencent.mm.plugin.webview.core.a.ILq.contains(str4.toLowerCase()));
                                    if (z) {
                                        if (bat != null && bat.endsWith(".apk")) {
                                            z = false;
                                            Log.i("MicroMsg.WebViewUI", "onDownloadStart is apk");
                                        }
                                        e.a(WebViewUI.this.mHh, 18111, WebViewUI.this.fZM(), str, str4, str3, str2, Long.valueOf(j2));
                                    }
                                }
                                if (z || WebViewUI.this.mHi.gdH().pP(24) || WebViewUI.this.JiK) {
                                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                                    intent.addFlags(268435456);
                                    try {
                                        WebViewUI webViewUI = WebViewUI.this;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                        com.tencent.mm.hellhoundlib.a.a.a(webViewUI, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$24", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        webViewUI.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(webViewUI, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$24", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        AppMethodBeat.o(259641);
                                    } catch (Exception e2) {
                                        Log.e("MicroMsg.WebViewUI", "startActivity fail, e = " + e2.getMessage());
                                        AppMethodBeat.o(259641);
                                    }
                                } else {
                                    Log.e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
                                    AppMethodBeat.o(259641);
                                }
                            }
                        });
                        this.pGj.requestFocus(130);
                        this.pGj.setOnTouchListener(new View.OnTouchListener() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass17 */

                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                AppMethodBeat.i(259643);
                                if (WebViewUI.this.Jib != null && WebViewUI.this.Jib.getVisibility() == 0) {
                                    Animation loadAnimation = AnimationUtils.loadAnimation(WebViewUI.this, R.anim.c4);
                                    loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                                        /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass17.AnonymousClass1 */

                                        public final void onAnimationStart(Animation animation) {
                                        }

                                        public final void onAnimationRepeat(Animation animation) {
                                        }

                                        public final void onAnimationEnd(Animation animation) {
                                            AppMethodBeat.i(259642);
                                            WebViewUI.this.Jib.setVisibility(8);
                                            AppMethodBeat.o(259642);
                                        }
                                    });
                                    WebViewUI.this.Jib.startAnimation(loadAnimation);
                                    WebViewUI.this.Jib.setVisibility(8);
                                }
                                switch (motionEvent.getAction()) {
                                    case 0:
                                    case 1:
                                        if (!view.hasFocus()) {
                                            view.requestFocus();
                                        }
                                        if (motionEvent.getAction() == 0) {
                                            WebViewUI.this.ppd = (int) motionEvent.getRawX();
                                            WebViewUI.this.ppe = (int) motionEvent.getRawY();
                                            break;
                                        }
                                        break;
                                }
                                if (WebViewUI.this.pGj == null) {
                                    AppMethodBeat.o(259643);
                                } else {
                                    if (motionEvent.getAction() == 0 || motionEvent.getAction() == 5 || motionEvent.getAction() == 5 || motionEvent.getAction() == 261 || motionEvent.getAction() == 517) {
                                        if (motionEvent.getPointerCount() > 1) {
                                            WebViewUI.this.pGj.getSettings().setBuiltInZoomControls(true);
                                            WebViewUI.this.pGj.getSettings().setSupportZoom(true);
                                        } else {
                                            WebViewUI.this.pGj.getSettings().setBuiltInZoomControls(false);
                                            WebViewUI.this.pGj.getSettings().setSupportZoom(false);
                                        }
                                    }
                                    AppMethodBeat.o(259643);
                                }
                                return false;
                            }
                        });
                        this.pGj.gYW();
                        this.Jjl = new i(this);
                        setBackBtn(new MenuItem.OnMenuItemClickListener() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass18 */

                            public final boolean onMenuItemClick(MenuItem menuItem) {
                                AppMethodBeat.i(259644);
                                WebViewUI.this.hideVKB();
                                WebViewUI.this.gfR();
                                Log.i("MicroMsg.WebViewUI", "on back btn press");
                                AppMethodBeat.o(259644);
                                return true;
                            }
                        }, gfD());
                        if (gfE()) {
                            this.Jic.setOnkbdStateListener(new KeyboardLinearLayout.a() {
                                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass29 */

                                @Override // com.tencent.mm.ui.KeyboardLinearLayout.a
                                public final void Ns(int i2) {
                                    AppMethodBeat.i(259652);
                                    Log.i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = ".concat(String.valueOf(i2)));
                                    WebViewUI.a(WebViewUI.this, WebViewUI.this.Jic, i2);
                                    if (i2 == -3) {
                                        WebViewUI.this.IMs.gdc().IZI = 1;
                                        int keyBoardHeight = WebViewUI.this.Jic.getKeyBoardHeight();
                                        if (keyBoardHeight > 0) {
                                            WebViewUI.b(WebViewUI.this, keyBoardHeight);
                                            WebViewUI.a(WebViewUI.this, keyBoardHeight);
                                        }
                                        if (WebViewUI.g(WebViewUI.this)) {
                                            WebViewRedesignInputFooter webViewRedesignInputFooter = WebViewUI.this.Jij;
                                            if (webViewRedesignInputFooter.JAQ) {
                                                webViewRedesignInputFooter.setVisibility(8);
                                            }
                                            webViewRedesignInputFooter.state = 0;
                                            webViewRedesignInputFooter.cbM();
                                        }
                                        com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h hVar = WebViewUI.this.ILF;
                                        WebViewUI webViewUI = WebViewUI.this;
                                        kotlin.g.b.p.h(webViewUI, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                                        com.tencent.mm.plugin.webview.ui.tools.video.b bVar = hVar.JxV;
                                        if (bVar != null) {
                                            if (bVar.bJb()) {
                                                com.tencent.f.h.RTc.aV(new Runnable(webViewUI) {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.video.b.AnonymousClass1 */
                                                    final /* synthetic */ Activity val$activity;

                                                    {
                                                        this.val$activity = r2;
                                                    }

                                                    public final void run() {
                                                        AppMethodBeat.i(212050);
                                                        ViewGroup viewGroup = (ViewGroup) this.val$activity.getWindow().getDecorView();
                                                        viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() & -5895);
                                                        b.this.JxQ = true;
                                                        AppMethodBeat.o(212050);
                                                    }
                                                });
                                            }
                                            kotlin.x xVar = kotlin.x.SXb;
                                        }
                                    } else {
                                        WebViewUI.b(WebViewUI.this, 0);
                                        WebViewUI.a(WebViewUI.this, 0);
                                        com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h hVar2 = WebViewUI.this.ILF;
                                        WebViewUI webViewUI2 = WebViewUI.this;
                                        com.tencent.mm.plugin.webview.ui.tools.video.b bVar2 = hVar2.JxV;
                                        if (bVar2 != null) {
                                            if (bVar2.bJb() && bVar2.JxQ) {
                                                com.tencent.f.h.RTc.aV(new Runnable(webViewUI2) {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.video.b.AnonymousClass2 */
                                                    final /* synthetic */ Activity val$activity;

                                                    {
                                                        this.val$activity = r2;
                                                    }

                                                    public final void run() {
                                                        AppMethodBeat.i(212051);
                                                        b.this.JxQ = false;
                                                        ((ViewGroup) this.val$activity.getWindow().getDecorView()).setSystemUiVisibility(5894);
                                                        AppMethodBeat.o(212051);
                                                    }
                                                });
                                            }
                                            kotlin.x xVar2 = kotlin.x.SXb;
                                        }
                                    }
                                    WebViewUI.this.agN(i2);
                                    WebViewUI.this.JjT = i2;
                                    AppMethodBeat.o(259652);
                                }
                            });
                        }
                        this.JhV = (MMFalseProgressBar) findViewById(R.id.jk9);
                        super.setTitleBarDoubleClickListener(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass19 */

                            public final void run() {
                                AppMethodBeat.i(259645);
                                WebViewUI.this.gfF();
                                AppMethodBeat.o(259645);
                            }
                        });
                        AppMethodBeat.o(80284);
                    }

                    /* access modifiers changed from: protected */
                    public synchronized x gfC() {
                        x xVar;
                        AppMethodBeat.i(80286);
                        if (this.JiG == null) {
                            this.JiG = new MMWebView.b(new b());
                        }
                        xVar = this.JiG;
                        AppMethodBeat.o(80286);
                        return xVar;
                    }

                    /* access modifiers changed from: protected */
                    public final void agM(int i2) {
                        AppMethodBeat.i(80288);
                        Drawable mutate = getResources().getDrawable(gfD()).mutate();
                        mutate.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
                        updateBackBtn(mutate);
                        AppMethodBeat.o(80288);
                    }

                    /* access modifiers changed from: protected */
                    public boolean gfE() {
                        return true;
                    }

                    public final void gfF() {
                        AppMethodBeat.i(175800);
                        View view = this.pGj.getView();
                        view.scrollTo(view.getScrollX(), 0);
                        this.IMs.gdg().D(coX(), 7).report();
                        AppMethodBeat.o(175800);
                    }

                    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                    public void onActivityResult(int i2, int i3, Intent intent) {
                        AppMethodBeat.i(80289);
                        super.onActivityResult(i2, i3, intent);
                        if (this.mHr.d(this, i2, i3, intent)) {
                            AppMethodBeat.o(80289);
                        } else if (this.JfY.d(this, i2, i3, intent)) {
                            AppMethodBeat.o(80289);
                        } else if (this.JjJ.d(this, i2, i3, intent)) {
                            AppMethodBeat.o(80289);
                        } else {
                            if (i2 == 777) {
                                Bundle bundle = null;
                                if (intent != null) {
                                    bundle = intent.getBundleExtra("result_data");
                                }
                                if (bundle == null || !bundle.getString("go_next", "").equals("gdpr_confirm_continue")) {
                                    Log.i("MicroMsg.WebViewUI", "gdpr continue:false");
                                    Intent intent2 = new Intent();
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString("go_next", "gdpr_confirm_logout");
                                    intent2.putExtra("result_data", bundle2);
                                    this.Jjd = true;
                                    l.Jhd.close();
                                    setResult(-1, intent2);
                                    finish();
                                } else {
                                    Log.i("MicroMsg.WebViewUI", "gdpr continue:true");
                                    AppMethodBeat.o(80289);
                                    return;
                                }
                            }
                            AppMethodBeat.o(80289);
                        }
                    }

                    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
                    public void onSwipeBack() {
                        AppMethodBeat.i(80290);
                        if (this.pGj != null) {
                            if (this.JjK) {
                                this.pGj.setOnLongClickListener(this.JjL);
                            } else {
                                this.pGj.setOnLongClickListener(null);
                            }
                        }
                        hideVKB();
                        super.onSwipeBack();
                        AppMethodBeat.o(80290);
                    }

                    @Override // com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
                    public void onCancel() {
                        AppMethodBeat.i(80291);
                        if (this.pGj != null) {
                            if (this.JjK) {
                                this.pGj.setOnLongClickListener(this.JjL);
                            } else {
                                this.pGj.setOnLongClickListener(null);
                            }
                        }
                        super.onCancel();
                        AppMethodBeat.o(80291);
                    }

                    @Override // com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
                    public void onDrag() {
                        AppMethodBeat.i(80292);
                        if (this.pGj != null) {
                            this.pGj.setOnLongClickListener(new View.OnLongClickListener() {
                                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass44 */

                                public final boolean onLongClick(View view) {
                                    AppMethodBeat.i(259646);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$29", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$29", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                                    AppMethodBeat.o(259646);
                                    return true;
                                }
                            });
                        }
                        super.onDrag();
                        AppMethodBeat.o(80292);
                    }

                    @Override // com.tencent.mm.ui.MMActivity
                    public boolean onSwipeBackFinish() {
                        AppMethodBeat.i(80293);
                        this.Jjf = true;
                        az.g gdg = this.IMs.gdg();
                        Object[] objArr = new Object[2];
                        objArr[0] = this.pGj != null ? this.pGj.getUrl() : coX();
                        objArr[1] = 15;
                        gdg.D(objArr).report();
                        boolean onSwipeBackFinish = super.onSwipeBackFinish();
                        AppMethodBeat.o(80293);
                        return onSwipeBackFinish;
                    }

                    public void bXg() {
                        boolean z;
                        BallInfo cim;
                        int i2;
                        int i3;
                        int i4;
                        int i5;
                        boolean equalsIgnoreCase;
                        int i6 = 2;
                        boolean z2 = true;
                        AppMethodBeat.i(80295);
                        if (this.Jje || this.Jjd || isFinishing()) {
                            Log.e("MicroMsg.WebViewUI", "edw postBinded finished");
                            AppMethodBeat.o(80295);
                            return;
                        }
                        com.tencent.mm.plugin.webview.d.i gfG = gfG();
                        if (gfG != null) {
                            gfG.IRQ = this.IMH.getJsapi();
                        }
                        this.mHh = this.IMH.fZs();
                        try {
                            this.mHh.a(this.ISw, this.IMH.fZu());
                        } catch (RemoteException e2) {
                            Log.printErrStackTrace("MicroMsg.WebViewUI", e2, "addCallbacker", new Object[0]);
                        }
                        Log.i("MicroMsg.WebViewUI", "edw postBinded");
                        this.Jjt = new com.tencent.mm.plugin.webview.ui.tools.floatball.b(new com.tencent.mm.plugin.ball.a.e(this), this);
                        String stringExtra = getIntent().getStringExtra("float_ball_key");
                        if (!Util.isNullOrNil(stringExtra)) {
                            this.Jjt.G(2, stringExtra);
                        } else {
                            this.Jjt.G(2, com.tencent.mm.plugin.ball.f.b.bxq(coX()));
                        }
                        this.Jjt.agT(coX());
                        this.Jjt.eU("rawUrl", coX());
                        this.Jjt.aYt(coX());
                        this.Jju = new com.tencent.mm.plugin.webview.ui.tools.multitask.a(new com.tencent.mm.plugin.multitask.a.b(this), this);
                        String stringExtra2 = getIntent().getStringExtra("float_ball_key");
                        if (!Util.isNullOrNil(stringExtra2)) {
                            this.Jju.G(2, stringExtra2);
                        } else {
                            this.Jju.G(2, com.tencent.mm.plugin.multitask.g.aGG(((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahz(coX())));
                        }
                        this.Jju.setRawUrl(coX());
                        if (this.Jjt != null) {
                            this.Jjt.bCA();
                        }
                        if (this.Jju != null) {
                            this.Jju.bCA();
                        }
                        if (this.Jjs != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (this.Jjs == null) {
                            this.Jjs = new HandOffURL(coX(), coX(), "");
                        }
                        if (ao.isMultiTaskMode() && this.Jju != null) {
                            MultiTaskInfo multiTaskInfo = this.Jju.Abp;
                            if (multiTaskInfo != null) {
                                String str = multiTaskInfo.erh().title;
                                if (!Util.isNullOrNil(str)) {
                                    this.Jjs.setTitle(str);
                                }
                                this.Jjs.setIcon(Util.nullAsNil(multiTaskInfo.erh().MwR));
                            }
                        } else if (!(this.Jjt == null || (cim = this.Jjt.cim()) == null)) {
                            String str2 = cim.name;
                            if (!Util.isNullOrNil(str2)) {
                                this.Jjs.setTitle(str2);
                            }
                            this.Jjs.setIcon(Util.nullAsNil(cim.icon));
                        }
                        if (gbH()) {
                            if (z) {
                                ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Jjs);
                                Log.i("MicroMsg.WebViewUI", "[Handoff] onPostBinded, exist:true, call upsert " + this.Jjs.toString());
                            } else {
                                ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).a(this.Jjs);
                                Log.i("MicroMsg.WebViewUI", "[Handoff] onPostBinded, exist:false, call onWebViewCreate " + this.Jjs.toString());
                            }
                        }
                        baq(coX());
                        com.tencent.mm.plugin.webview.model.b gfd = gfd();
                        com.tencent.mm.plugin.webview.stub.e eVar = this.mHh;
                        try {
                            String aZV = eVar.aZV("DNSAdvanceOpen");
                            Log.i("MicroMsg.DNSPreGetOptimize", "switch open value : %s", aZV);
                            if (Util.isNullOrNil(aZV)) {
                                Log.e("MicroMsg.DNSPreGetOptimize", "get switch value is null or nil");
                                equalsIgnoreCase = false;
                            } else {
                                equalsIgnoreCase = aZV.equalsIgnoreCase("1");
                            }
                            if (!equalsIgnoreCase) {
                                Log.i("MicroMsg.DNSPreGetOptimize", "server closed the switch");
                            } else {
                                try {
                                    String aZV2 = eVar.aZV("DNSAdvanceRelateDomain");
                                    if (Util.isNullOrNil(aZV2)) {
                                        Log.e("MicroMsg.DNSPreGetOptimize", "domain list is null, just return");
                                    } else {
                                        com.tencent.mm.plugin.webview.a.a.aj(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x043b: INVOKE  
                                              (wrap: com.tencent.mm.plugin.webview.model.b$1 : 0x0438: CONSTRUCTOR  (r5v41 com.tencent.mm.plugin.webview.model.b$1) = (r3v23 'gfd' com.tencent.mm.plugin.webview.model.b), (r0v102 'aZV2' java.lang.String) call: com.tencent.mm.plugin.webview.model.b.1.<init>(com.tencent.mm.plugin.webview.model.b, java.lang.String):void type: CONSTRUCTOR)
                                             type: STATIC call: com.tencent.mm.plugin.webview.a.a.aj(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.bXg():void, file: classes.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0438: CONSTRUCTOR  (r5v41 com.tencent.mm.plugin.webview.model.b$1) = (r3v23 'gfd' com.tencent.mm.plugin.webview.model.b), (r0v102 'aZV2' java.lang.String) call: com.tencent.mm.plugin.webview.model.b.1.<init>(com.tencent.mm.plugin.webview.model.b, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.bXg():void, file: classes.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                            	... 38 more
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.model.b, state: GENERATED_AND_UNLOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                            	... 44 more
                                            */
                                        /*
                                        // Method dump skipped, instructions count: 1374
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.bXg():void");
                                    }

                                    public final void loadUrl(String str) {
                                        AppMethodBeat.i(185934);
                                        loadUrl(str, null, false);
                                        AppMethodBeat.o(185934);
                                    }

                                    /* access modifiers changed from: protected */
                                    public void loadUrl(String str, Map<String, String> map, boolean z) {
                                        AppMethodBeat.i(80297);
                                        if (this.IMH != null) {
                                            this.IMH.loadUrl(str, map, z);
                                        }
                                        AppMethodBeat.o(80297);
                                    }

                                    @Override // com.tencent.mm.ui.MMActivity
                                    public boolean needShowIdcError() {
                                        return false;
                                    }

                                    private boolean gek() {
                                        boolean z = false;
                                        AppMethodBeat.i(80298);
                                        try {
                                            if (this.mHh == null) {
                                                Log.w("MicroMsg.WebViewUI", "invoker is null");
                                                AppMethodBeat.o(80298);
                                                return z;
                                            }
                                            z = this.mHh.gek();
                                            AppMethodBeat.o(80298);
                                            return z;
                                        } catch (RemoteException e2) {
                                            Log.e("MicroMsg.WebViewUI", "unable get config for WebViewDownLoadFile" + e2.getMessage());
                                        }
                                    }

                                    private static String bar(String str) {
                                        String str2 = null;
                                        AppMethodBeat.i(80299);
                                        try {
                                            Matcher matcher = Pattern.compile("(?i)^.*filename=\"?([^\"]+)\"?.*$").matcher(str);
                                            if (!matcher.find() || matcher.groupCount() != 1) {
                                                AppMethodBeat.o(80299);
                                                return str2;
                                            }
                                            str2 = matcher.group(1);
                                            AppMethodBeat.o(80299);
                                            return str2;
                                        } catch (Exception e2) {
                                            Log.e("MicroMsg.WebViewUI", "getFileNameFromContentDisposition error " + e2.getMessage());
                                            AppMethodBeat.o(80299);
                                        }
                                    }

                                    @Override // com.tencent.mm.plugin.webview.core.b
                                    public final String coX() {
                                        AppMethodBeat.i(80300);
                                        try {
                                            String bj = BaseWebViewController.bj(getIntent());
                                            AppMethodBeat.o(80300);
                                            return bj;
                                        } catch (Exception e2) {
                                            finish();
                                            AppMethodBeat.o(80300);
                                            return null;
                                        }
                                    }

                                    /* access modifiers changed from: protected */
                                    public com.tencent.mm.plugin.webview.d.i gfG() {
                                        return null;
                                    }

                                    /* access modifiers changed from: protected */
                                    public boolean gfH() {
                                        return false;
                                    }

                                    public final void cjP() {
                                        AppMethodBeat.i(80302);
                                        this.Jjm.cjP();
                                        AppMethodBeat.o(80302);
                                    }

                                    public void cpD() {
                                        AppMethodBeat.i(80303);
                                        this.Jjm.cpD();
                                        AppMethodBeat.o(80303);
                                    }

                                    public final void Mf(long j2) {
                                        AppMethodBeat.i(211176);
                                        this.Jjm.Mf(j2);
                                        AppMethodBeat.o(211176);
                                    }

                                    /* access modifiers changed from: protected */
                                    public final void gfI() {
                                        AppMethodBeat.i(80304);
                                        if (this.ILF.bJb()) {
                                            this.ILF.zs(false);
                                        }
                                        if (this.IMH != null) {
                                            this.IMH.reload();
                                        }
                                        AppMethodBeat.o(80304);
                                    }

                                    /* access modifiers changed from: protected */
                                    public final void gfJ() {
                                        AppMethodBeat.i(211177);
                                        if (this.IMH != null) {
                                            l.za(!l.gbo());
                                            this.IMH.reload();
                                        }
                                        AppMethodBeat.o(211177);
                                    }

                                    public final void geP() {
                                        AppMethodBeat.i(80305);
                                        this.Jjm.geP();
                                        AppMethodBeat.o(80305);
                                    }

                                    public final void ban(String str) {
                                        AppMethodBeat.i(80306);
                                        this.Jjm.ban(str);
                                        AppMethodBeat.o(80306);
                                    }

                                    /* access modifiers changed from: protected */
                                    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002c, code lost:
                                        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r1) == false) goto L_0x002e;
                                     */
                                    /* Code decompiled incorrectly, please refer to instructions dump. */
                                    public final java.util.LinkedList<com.tencent.mm.n.e.a> gfK() {
                                        /*
                                        // Method dump skipped, instructions count: 227
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.gfK():java.util.LinkedList");
                                    }

                                    /* access modifiers changed from: protected */
                                    public final boolean fZV() {
                                        AppMethodBeat.i(80308);
                                        boolean fZV = this.IMH.fZV();
                                        AppMethodBeat.o(80308);
                                        return fZV;
                                    }

                                    /* access modifiers changed from: protected */
                                    public void zj(boolean z) {
                                        boolean z2;
                                        AppMethodBeat.i(80310);
                                        this.JjH = z;
                                        if (this.pGj == null) {
                                            Log.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
                                            AppMethodBeat.o(80310);
                                            return;
                                        }
                                        enableOptionMenu(z);
                                        showOptionMenu(z);
                                        boolean booleanExtra = getIntent().getBooleanExtra("show_feedback", false);
                                        if (booleanExtra) {
                                            showOptionMenu(booleanExtra);
                                        }
                                        int gfL = gfL();
                                        if (gfK() != null) {
                                            gfL = R.raw.mm_title_btn_jd;
                                        }
                                        boolean booleanExtra2 = getIntent().getBooleanExtra("KRightBtn", false);
                                        boolean booleanExtra3 = getIntent().getBooleanExtra("KShowFixToolsBtn", false);
                                        Log.i("MicroMsg.WebViewUI", "banRightBtn:%b, showFixToolsBtn:%b", Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3));
                                        if (!booleanExtra2) {
                                            if (booleanExtra3) {
                                                addIconOptionMenu(1, R.raw.fix_tools_entry, new MenuItem.OnMenuItemClickListener() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass27 */

                                                    public final boolean onMenuItemClick(MenuItem menuItem) {
                                                        AppMethodBeat.i(80082);
                                                        Intent intent = new Intent();
                                                        intent.setClassName(WebViewUI.this, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
                                                        intent.putExtra("entry_fix_tools", 1);
                                                        WebViewUI webViewUI = WebViewUI.this;
                                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                                        com.tencent.mm.hellhoundlib.a.a.a(webViewUI, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$35", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                                        webViewUI.startActivity((Intent) bl.pG(0));
                                                        com.tencent.mm.hellhoundlib.a.a.a(webViewUI, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$35", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                                        AppMethodBeat.o(80082);
                                                        return true;
                                                    }
                                                });
                                            }
                                            addIconOptionMenu(0, gfL, new MenuItem.OnMenuItemClickListener() {
                                                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass28 */

                                                public final boolean onMenuItemClick(MenuItem menuItem) {
                                                    AppMethodBeat.i(211117);
                                                    if (WebViewUI.this.mHi.aZK(WebViewUI.this.fZM())) {
                                                        WebViewUI.this.IMs.gdg().D(WebViewUI.this.coX(), 6).report();
                                                    } else {
                                                        WebViewUI.this.IMs.gdg().D(WebViewUI.this.coX(), 5).report();
                                                    }
                                                    WebViewUI.this.cpD();
                                                    AppMethodBeat.o(211117);
                                                    return true;
                                                }
                                            }, this.JjO);
                                        }
                                        if (!z) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        zl(z2);
                                        AppMethodBeat.o(80310);
                                    }

                                    @Override // com.tencent.mm.ui.MMActivity
                                    public void showOptionMenu(boolean z) {
                                        AppMethodBeat.i(80311);
                                        if (getIntent().getBooleanExtra("hide_option_menu", false)) {
                                            super.showOptionMenu(false);
                                            AppMethodBeat.o(80311);
                                            return;
                                        }
                                        super.showOptionMenu(z);
                                        AppMethodBeat.o(80311);
                                    }

                                    @Override // com.tencent.mm.ui.MMActivity
                                    public void showOptionMenu(int i2, boolean z) {
                                        AppMethodBeat.i(80312);
                                        if (getIntent().getBooleanExtra("hide_option_menu", false)) {
                                            super.showOptionMenu(i2, false);
                                            AppMethodBeat.o(80312);
                                            return;
                                        }
                                        super.showOptionMenu(i2, z);
                                        AppMethodBeat.o(80312);
                                    }

                                    /* access modifiers changed from: protected */
                                    public final int gfL() {
                                        AppMethodBeat.i(80314);
                                        int i2 = R.raw.icons_outlined_more;
                                        if (gfK() != null) {
                                            i2 = R.raw.mm_title_btn_jd;
                                        }
                                        AppMethodBeat.o(80314);
                                        return i2;
                                    }

                                    public final void fTu() {
                                        AppMethodBeat.i(211178);
                                        if (this.Jic != null) {
                                            hideVKB();
                                            this.Jic.Ns(-2);
                                        }
                                        AppMethodBeat.o(211178);
                                    }

                                    /* access modifiers changed from: protected */
                                    public final void agN(int i2) {
                                        AppMethodBeat.i(80315);
                                        if (i2 != -3) {
                                            AppMethodBeat.o(80315);
                                        } else if (this.JiB == null) {
                                            AppMethodBeat.o(80315);
                                        } else {
                                            boolean z = (this.mHi.gdI().Kzi & 1) > 0;
                                            Log.d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = ".concat(String.valueOf(z)));
                                            if (z) {
                                                if (this.JiB.getVisibility() == 0 || this.Jik.isShown()) {
                                                    AppMethodBeat.o(80315);
                                                    return;
                                                }
                                                if (this.JiC == null) {
                                                    this.JiC = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                                                        /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass33 */

                                                        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                                                        public final boolean onTimerExpired() {
                                                            AppMethodBeat.i(259655);
                                                            WebViewUI.j(WebViewUI.this);
                                                            AppMethodBeat.o(259655);
                                                            return false;
                                                        }
                                                    }, false);
                                                }
                                                this.JiC.startTimer(4000);
                                                View view = this.JiB;
                                                ((ImageView) view.findViewById(R.id.ecz)).setImageResource(R.raw.net_warn_icon);
                                                TextView textView = (TextView) view.findViewById(R.id.ed0);
                                                textView.setTextSize(14.0f);
                                                textView.setText(R.string.j48);
                                                ((ImageButton) view.findViewById(R.id.ecy)).setOnClickListener(new View.OnClickListener() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass34 */

                                                    public final void onClick(View view) {
                                                        AppMethodBeat.i(259656);
                                                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                                        bVar.bm(view);
                                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                                        WebViewUI.j(WebViewUI.this);
                                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                                        AppMethodBeat.o(259656);
                                                    }
                                                });
                                                this.JiB.setVisibility(0);
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(13125, coX());
                                            }
                                            AppMethodBeat.o(80315);
                                        }
                                    }

                                    private void gfM() {
                                        AppMethodBeat.i(80316);
                                        if (this.JiB != null) {
                                            this.JiB.setVisibility(8);
                                        }
                                        if (this.JiC != null) {
                                            this.JiC.stopTimer();
                                        }
                                        AppMethodBeat.o(80316);
                                    }

                                    public final void bas(String str) {
                                        AppMethodBeat.i(80317);
                                        this.IBw.cL(Scopes.PROFILE, true);
                                        this.IBw.aYf(str);
                                        AppMethodBeat.o(80317);
                                    }

                                    public final void agO(int i2) {
                                        AppMethodBeat.i(211179);
                                        this.IBw.cL("sendAppMessage", true);
                                        this.IBw.c(this.Jjm.geQ(), i2);
                                        this.IMs.aZc("mm_send_friend_count");
                                        AppMethodBeat.o(211179);
                                    }

                                    public final void zi(boolean z) {
                                        boolean z2;
                                        boolean z3 = true;
                                        AppMethodBeat.i(80319);
                                        if (this.JhY != null) {
                                            this.JhY.zi(z);
                                        }
                                        if (!(this.pGj == null || this.JfG == null)) {
                                            ImageButton imageButton = this.JhZ;
                                            if (this.pGj == null || !this.pGj.canGoBack()) {
                                                z2 = false;
                                            } else {
                                                z2 = true;
                                            }
                                            imageButton.setEnabled(z2);
                                            ImageButton imageButton2 = this.Jia;
                                            if (this.pGj == null || !this.pGj.canGoForward()) {
                                                z3 = false;
                                            }
                                            imageButton2.setEnabled(z3);
                                        }
                                        AppMethodBeat.o(80319);
                                    }

                                    /* access modifiers changed from: protected */
                                    /* JADX WARNING: Removed duplicated region for block: B:64:0x0135  */
                                    /* JADX WARNING: Removed duplicated region for block: B:67:0x013e  */
                                    /* JADX WARNING: Removed duplicated region for block: B:70:0x0160  */
                                    /* JADX WARNING: Removed duplicated region for block: B:93:0x0254  */
                                    /* Code decompiled incorrectly, please refer to instructions dump. */
                                    public boolean cpC() {
                                        /*
                                        // Method dump skipped, instructions count: 619
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.cpC():boolean");
                                    }

                                    /* access modifiers changed from: protected */
                                    public final void zk(boolean z) {
                                        AppMethodBeat.i(211180);
                                        enableOptionMenu(true);
                                        Log.d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", Boolean.TRUE);
                                        setProgressBarIndeterminateVisibility(false);
                                        if (z) {
                                            this.Jjm.geM();
                                            AppMethodBeat.o(211180);
                                            return;
                                        }
                                        if (!this.JiX && !this.JiY) {
                                            this.IMH.cph();
                                        }
                                        AppMethodBeat.o(211180);
                                    }

                                    @Override // com.tencent.mm.plugin.webview.core.b
                                    public final String aXD(String str) {
                                        AppMethodBeat.i(211181);
                                        String aXD = this.IMH.aXD(str);
                                        AppMethodBeat.o(211181);
                                        return aXD;
                                    }

                                    public final com.tencent.mm.plugin.webview.d.b.a gaW() {
                                        AppMethodBeat.i(211182);
                                        if (this.IBw != null) {
                                            com.tencent.mm.plugin.webview.d.b.a gaW = this.IBw.gaW();
                                            AppMethodBeat.o(211182);
                                            return gaW;
                                        }
                                        com.tencent.mm.plugin.webview.d.b.a aVar = new com.tencent.mm.plugin.webview.d.b.a();
                                        AppMethodBeat.o(211182);
                                        return aVar;
                                    }

                                    public class b extends x {
                                        public volatile boolean hho = false;
                                        com.tencent.mm.ui.widget.a.d kvo = null;

                                        protected b() {
                                            AppMethodBeat.i(80144);
                                            AppMethodBeat.o(80144);
                                        }

                                        @Override // com.tencent.xweb.x
                                        public final void onExitFullscreenVideo(Bitmap bitmap) {
                                            AppMethodBeat.i(80147);
                                            if (WebViewUI.this.IBw != null && WebViewUI.this.gaW().ISC && WebViewUI.this.gfi().getVisibility() == 0) {
                                                if (WebViewUI.this.JjR != null) {
                                                    WebViewUI.this.JjR.onCustomViewHidden();
                                                }
                                                WebViewUI.this.gaW().zb(false);
                                                MPVideoPlayFullScreenView gfi = WebViewUI.this.gfi();
                                                if (gfi.FLK) {
                                                    Log.i(gfi.TAG, "isRunningExitAnimation");
                                                    AppMethodBeat.o(80147);
                                                    return;
                                                }
                                                gfi.ghL();
                                                if (bitmap != null && !bitmap.isRecycled()) {
                                                    ImageView imageView = new ImageView(gfi.getContext());
                                                    ViewGroup viewGroup = gfi.JvK;
                                                    if (viewGroup != null) {
                                                        viewGroup.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
                                                    }
                                                    imageView.setImageBitmap(bitmap);
                                                }
                                                Log.i(gfi.TAG, "runExitAnimation");
                                                gfi.ghM();
                                                int width = gfi.JvH.getWidth();
                                                int height = gfi.JvH.getHeight();
                                                com.tencent.mm.ui.tools.e eVar = gfi.qaE;
                                                if (eVar != null) {
                                                    eVar.ls(width, height);
                                                }
                                                com.tencent.mm.ui.tools.e eVar2 = gfi.qaE;
                                                if (eVar2 != null) {
                                                    y yVar = gfi.iwi;
                                                    if (yVar == null) {
                                                        kotlin.g.b.p.hyc();
                                                    }
                                                    int i2 = yVar.iAL;
                                                    y yVar2 = gfi.iwi;
                                                    if (yVar2 == null) {
                                                        kotlin.g.b.p.hyc();
                                                    }
                                                    int i3 = yVar2.iAM;
                                                    y yVar3 = gfi.iwi;
                                                    if (yVar3 == null) {
                                                        kotlin.g.b.p.hyc();
                                                    }
                                                    int i4 = yVar3.iAN;
                                                    y yVar4 = gfi.iwi;
                                                    if (yVar4 == null) {
                                                        kotlin.g.b.p.hyc();
                                                    }
                                                    eVar2.Q(i2, i3, i4, yVar4.iAO);
                                                }
                                                if (((double) gfi.EAC) != 1.0d) {
                                                    com.tencent.mm.ui.tools.e eVar3 = gfi.qaE;
                                                    if (eVar3 != null) {
                                                        eVar3.QtG = 1.0f / gfi.EAC;
                                                    }
                                                    if (!(gfi.EAD == 0 && gfi.EAE == 0)) {
                                                        int width2 = ((int) (((float) (gfi.JvH.getWidth() / 2)) * (1.0f - gfi.EAC))) + gfi.EAD;
                                                        int height2 = (int) (((float) ((gfi.JvH.getHeight() / 2) + gfi.EAE)) - (((float) (height / 2)) * gfi.EAC));
                                                        com.tencent.mm.ui.tools.e eVar4 = gfi.qaE;
                                                        if (eVar4 != null) {
                                                            eVar4.lu(width2, height2);
                                                        }
                                                    }
                                                }
                                                ViewGroup.LayoutParams layoutParams = gfi.JvH.getLayoutParams();
                                                com.tencent.mm.ui.tools.e eVar5 = gfi.qaE;
                                                if (eVar5 != null) {
                                                    eVar5.a(gfi.JvK, gfi.JvH, new MPVideoPlayFullScreenView.q(gfi, layoutParams), null);
                                                    AppMethodBeat.o(80147);
                                                    return;
                                                }
                                            }
                                            AppMethodBeat.o(80147);
                                        }

                                        @Override // com.tencent.xweb.x
                                        public final void a(com.tencent.xweb.WebView webView, int i2) {
                                            AppMethodBeat.i(80148);
                                            Log.d("MicroMsg.WebViewUI", "onProgressChanged %d", Integer.valueOf(i2));
                                            AppMethodBeat.o(80148);
                                        }

                                        @Override // com.tencent.xweb.x
                                        public final void d(com.tencent.xweb.WebView webView, String str) {
                                            AppMethodBeat.i(80149);
                                            Log.i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", str, WebViewUI.this.gfu());
                                            super.d(webView, str);
                                            if (WebViewUI.this.JhT && !WebViewUI.this.JhU) {
                                                Log.i("MicroMsg.WebViewUI", "fixed title, ignore received title: ".concat(String.valueOf(str)));
                                                AppMethodBeat.o(80149);
                                            } else if (str == null) {
                                                Log.e("MicroMsg.WebViewUI", "null title");
                                                AppMethodBeat.o(80149);
                                            } else if (!WebViewUI.this.CSQ) {
                                                AppMethodBeat.o(80149);
                                            } else {
                                                if (!Util.nullAsNil(WebViewUI.this.gfu()).equals(str) && !com.tencent.mm.plugin.webview.luggage.c.b.afC(str) && !str.startsWith("about:blank")) {
                                                    WebViewUI.this.setMMTitle(str);
                                                }
                                                AppMethodBeat.o(80149);
                                            }
                                        }

                                        @Override // com.tencent.xweb.x
                                        public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                                            AppMethodBeat.i(80150);
                                            Log.i("MicroMsg.WebViewUI", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
                                            try {
                                                WebViewUI.this.getContext().getWindow().addFlags(128);
                                                if (WebViewUI.this.vk != null) {
                                                    customViewCallback.onCustomViewHidden();
                                                    AppMethodBeat.o(80150);
                                                    return;
                                                }
                                                WebViewUI.this.zi(false);
                                                WebViewUI.this.vk = view;
                                                WebViewUI.this.JiF = customViewCallback;
                                                if (!WebViewUI.this.pGj.isXWalkKernel()) {
                                                    WebViewUI.this.pGj.setVisibility(8);
                                                    WebViewUI.this.Jie.addView(view);
                                                    WebViewUI.this.setTitleVisibility(4);
                                                    AppMethodBeat.o(80150);
                                                    return;
                                                }
                                                WebViewUI.this.Jie.addView(view, 0);
                                                WebViewUI.this.fullScreenNoTitleBar(true);
                                                WebViewUI.this.setStatusBarColor(0);
                                                if (WebViewUI.this.JjE != null) {
                                                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) WebViewUI.this.JjE.getLayoutParams();
                                                    marginLayoutParams.topMargin = 0;
                                                    WebViewUI.this.JjE.setLayoutParams(marginLayoutParams);
                                                }
                                                AppMethodBeat.o(80150);
                                            } catch (Exception e2) {
                                                Log.e("MicroMsg.WebViewUI", "onShowCustomView error " + e2.getMessage());
                                                AppMethodBeat.o(80150);
                                            }
                                        }

                                        @Override // com.tencent.xweb.x
                                        public final void onHideCustomView() {
                                            AppMethodBeat.i(80151);
                                            Log.i("MicroMsg.WebViewUI", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
                                            WebViewUI.this.getContext().getWindow().clearFlags(128);
                                            if (WebViewUI.this.vk == null) {
                                                AppMethodBeat.o(80151);
                                                return;
                                            }
                                            try {
                                                WebViewUI.this.zi(WebViewUI.this.cpC());
                                                if (!WebViewUI.this.pGj.isXWalkKernel()) {
                                                    WebViewUI.this.pGj.setVisibility(0);
                                                    WebViewUI.this.setTitleVisibility(0);
                                                } else {
                                                    WebViewUI.this.fullScreenNoTitleBar(false);
                                                    WebViewUI.this.setStatusBarColor(WebViewUI.this.getResources().getColor(R.color.a_5));
                                                    if (WebViewUI.this.JjE != null) {
                                                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) WebViewUI.this.JjE.getLayoutParams();
                                                        int n = WebViewUI.n(WebViewUI.this);
                                                        if (n != marginLayoutParams.topMargin) {
                                                            marginLayoutParams.topMargin = n;
                                                            WebViewUI.this.JjE.setLayoutParams(marginLayoutParams);
                                                        }
                                                    }
                                                }
                                                if (WebViewUI.this.Jie != null) {
                                                    WebViewUI.this.Jie.removeView(WebViewUI.this.vk);
                                                }
                                                WebViewUI.this.vk = null;
                                                if (WebViewUI.this.JiF != null) {
                                                    WebViewUI.this.JiF.onCustomViewHidden();
                                                }
                                                AppMethodBeat.o(80151);
                                            } catch (Exception e2) {
                                                Log.e("MicroMsg.WebViewUI", "onHideCustomView error " + e2.getMessage());
                                                AppMethodBeat.o(80151);
                                            }
                                        }

                                        @Override // com.tencent.xweb.x
                                        public final View getVideoLoadingProgressView() {
                                            AppMethodBeat.i(80152);
                                            if (WebViewUI.this.JiH == null) {
                                                WebViewUI.this.JiH = new ProgressBar(WebViewUI.this);
                                                WebViewUI.this.JiH.setIndeterminate(true);
                                            }
                                            ProgressBar progressBar = WebViewUI.this.JiH;
                                            AppMethodBeat.o(80152);
                                            return progressBar;
                                        }

                                        @Override // com.tencent.xweb.x
                                        public final void onGeolocationPermissionsShowPrompt(final String str, final GeolocationPermissions.Callback callback) {
                                            AppMethodBeat.i(80153);
                                            Log.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt, origin = %s", str);
                                            if (!com.tencent.mm.pluginsdk.permission.b.n(WebViewUI.this, "android.permission.ACCESS_FINE_LOCATION")) {
                                                com.tencent.mm.pluginsdk.permission.b.b(WebViewUI.this, "android.permission.ACCESS_FINE_LOCATION", 64);
                                            }
                                            com.tencent.mm.ui.base.h.a((Context) WebViewUI.this, false, WebViewUI.this.getString(R.string.j4o, new Object[]{str}), WebViewUI.this.getString(R.string.j4p), WebViewUI.this.getString(R.string.x_), WebViewUI.this.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b.AnonymousClass1 */

                                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                                    AppMethodBeat.i(80133);
                                                    Log.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt ok");
                                                    callback.invoke(str, true, true);
                                                    e.a(WebViewUI.this.mHh, 14340, WebViewUI.this.coX(), WebViewUI.this.fZM(), Integer.valueOf(WebViewUI.this.bLC()), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(az.bHy()), 1, 0, 0, 0);
                                                    AppMethodBeat.o(80133);
                                                }
                                            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b.AnonymousClass4 */

                                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                                    AppMethodBeat.i(80136);
                                                    Log.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt cancel");
                                                    callback.invoke(str, false, false);
                                                    e.a(WebViewUI.this.mHh, 14340, WebViewUI.this.coX(), WebViewUI.this.fZM(), Integer.valueOf(WebViewUI.this.bLC()), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(az.bHy()), 2, 0, 0, 0);
                                                    AppMethodBeat.o(80136);
                                                }
                                            });
                                            AppMethodBeat.o(80153);
                                        }

                                        @Override // com.tencent.xweb.x
                                        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                                            AppMethodBeat.i(80154);
                                            WebViewUI.this.mHr.a(WebViewUI.this, WebViewUI.this.mHi, valueCallback, null, str, str2);
                                            AppMethodBeat.o(80154);
                                        }

                                        @Override // com.tencent.xweb.x
                                        public final boolean a(com.tencent.xweb.WebView webView, ValueCallback<Uri[]> valueCallback, x.a aVar) {
                                            AppMethodBeat.i(80155);
                                            if (aVar.getMode() != 0 && aVar.getMode() != 1) {
                                                AppMethodBeat.o(80155);
                                                return false;
                                            } else if (aVar.getAcceptTypes() == null || aVar.getAcceptTypes().length <= 0) {
                                                Log.i("MicroMsg.WebViewUI", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
                                                AppMethodBeat.o(80155);
                                                return true;
                                            } else {
                                                String str = aVar.getAcceptTypes()[0];
                                                String str2 = "*";
                                                if (aVar.isCaptureEnabled()) {
                                                    if ("image/*".equalsIgnoreCase(str)) {
                                                        str2 = "camera";
                                                    } else if ("video/*".equalsIgnoreCase(str)) {
                                                        str2 = "camcorder";
                                                    }
                                                }
                                                WebViewUI.this.mHr.a(WebViewUI.this, WebViewUI.this.mHi, null, valueCallback, str, str2);
                                                AppMethodBeat.o(80155);
                                                return true;
                                            }
                                        }

                                        @Override // com.tencent.xweb.x
                                        public final boolean b(com.tencent.xweb.WebView webView, final String str, String str2, final JsResult jsResult) {
                                            AppMethodBeat.i(80156);
                                            Log.d("MicroMsg.WebViewUI", "onJsConfirm");
                                            final PBool pBool = new PBool();
                                            pBool.value = false;
                                            if (WebViewUI.this.isFinishing() || WebViewUI.this.activityHasDestroyed()) {
                                                Log.d("MicroMsg.WebViewUI", "onJsConfirm finish");
                                                jsResult.cancel();
                                                AppMethodBeat.o(80156);
                                                return true;
                                            }
                                            WebViewUI.r(WebViewUI.this);
                                            if (WebViewUI.this.Jja > 2) {
                                                this.kvo = com.tencent.mm.ui.base.h.a(WebViewUI.this, str2, "", WebViewUI.this.getString(R.string.j4i), WebViewUI.this.getString(R.string.x_), new DialogInterface.OnClickListener() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b.AnonymousClass5 */

                                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                                        AppMethodBeat.i(80137);
                                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11683, str, 1, Integer.valueOf(WebViewUI.this.Jja));
                                                        jsResult.cancel();
                                                        if (dialogInterface != null) {
                                                            dialogInterface.dismiss();
                                                        }
                                                        WebViewUI.this.finish();
                                                        AppMethodBeat.o(80137);
                                                    }
                                                }, new DialogInterface.OnClickListener() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b.AnonymousClass6 */

                                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                                        AppMethodBeat.i(80138);
                                                        pBool.value = true;
                                                        jsResult.confirm();
                                                        AppMethodBeat.o(80138);
                                                    }
                                                }, (int) R.color.go);
                                            } else {
                                                this.kvo = com.tencent.mm.ui.base.h.a((Context) WebViewUI.this.getContext(), false, str2, "", WebViewUI.this.getString(R.string.x_), WebViewUI.this.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b.AnonymousClass7 */

                                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                                        AppMethodBeat.i(80139);
                                                        pBool.value = true;
                                                        jsResult.confirm();
                                                        AppMethodBeat.o(80139);
                                                    }
                                                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b.AnonymousClass8 */

                                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                                        AppMethodBeat.i(80140);
                                                        jsResult.cancel();
                                                        AppMethodBeat.o(80140);
                                                    }
                                                });
                                            }
                                            if (this.kvo != null) {
                                                this.kvo.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b.AnonymousClass9 */

                                                    public final void onDismiss(DialogInterface dialogInterface) {
                                                        AppMethodBeat.i(80141);
                                                        Log.d("MicroMsg.WebViewUI", "onJsConfirm, onDismiss");
                                                        if (!pBool.value) {
                                                            jsResult.cancel();
                                                        }
                                                        AppMethodBeat.o(80141);
                                                    }
                                                });
                                                this.kvo.setCancelable(false);
                                                this.kvo.setCanceledOnTouchOutside(false);
                                                AppMethodBeat.o(80156);
                                                return true;
                                            }
                                            boolean b2 = super.b(webView, str, str2, jsResult);
                                            AppMethodBeat.o(80156);
                                            return b2;
                                        }

                                        @Override // com.tencent.xweb.x
                                        public final boolean a(com.tencent.xweb.WebView webView, String str, String str2, String str3, com.tencent.xweb.o oVar) {
                                            AppMethodBeat.i(80157);
                                            boolean a2 = super.a(webView, str, str2, str3, oVar);
                                            AppMethodBeat.o(80157);
                                            return a2;
                                        }

                                        @Override // com.tencent.xweb.x
                                        public final boolean a(com.tencent.xweb.WebView webView, final String str, String str2, final JsResult jsResult) {
                                            AppMethodBeat.i(80158);
                                            Log.d("MicroMsg.WebViewUI", "onJsAlert");
                                            final PBool pBool = new PBool();
                                            pBool.value = false;
                                            if (WebViewUI.this.isFinishing() || WebViewUI.this.activityHasDestroyed()) {
                                                Log.d("MicroMsg.WebViewUI", "onJsAlert finish");
                                                jsResult.cancel();
                                                AppMethodBeat.o(80158);
                                                return true;
                                            }
                                            WebViewUI.r(WebViewUI.this);
                                            if (WebViewUI.this.Jja > 2) {
                                                this.kvo = com.tencent.mm.ui.base.h.a(WebViewUI.this, str2, "", WebViewUI.this.getString(R.string.j4i), WebViewUI.this.getString(R.string.x_), new DialogInterface.OnClickListener() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b.AnonymousClass10 */

                                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                                        AppMethodBeat.i(80142);
                                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11683, str, 1, Integer.valueOf(WebViewUI.this.Jja));
                                                        jsResult.cancel();
                                                        if (dialogInterface != null) {
                                                            dialogInterface.dismiss();
                                                        }
                                                        WebViewUI.this.finish();
                                                        AppMethodBeat.o(80142);
                                                    }
                                                }, new DialogInterface.OnClickListener() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b.AnonymousClass11 */

                                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                                        AppMethodBeat.i(80143);
                                                        pBool.value = true;
                                                        jsResult.confirm();
                                                        AppMethodBeat.o(80143);
                                                    }
                                                }, (int) R.color.x0);
                                            } else {
                                                this.kvo = com.tencent.mm.ui.base.h.a(WebViewUI.this, str2, "", WebViewUI.this.getString(R.string.x_), new DialogInterface.OnClickListener() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b.AnonymousClass2 */

                                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                                        AppMethodBeat.i(80134);
                                                        pBool.value = true;
                                                        jsResult.confirm();
                                                        AppMethodBeat.o(80134);
                                                    }
                                                });
                                            }
                                            if (this.kvo != null) {
                                                this.kvo.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b.AnonymousClass3 */

                                                    public final void onDismiss(DialogInterface dialogInterface) {
                                                        AppMethodBeat.i(80135);
                                                        Log.d("MicroMsg.WebViewUI", "onJsAlert, onDismiss");
                                                        if (!pBool.value) {
                                                            jsResult.cancel();
                                                        }
                                                        AppMethodBeat.o(80135);
                                                    }
                                                });
                                                this.kvo.setCanceledOnTouchOutside(false);
                                                this.kvo.Dh(false);
                                                AppMethodBeat.o(80158);
                                                return true;
                                            }
                                            boolean a2 = super.a(webView, str, str2, jsResult);
                                            AppMethodBeat.o(80158);
                                            return a2;
                                        }

                                        @Override // com.tencent.xweb.x
                                        public final boolean a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                                            boolean z;
                                            AppMethodBeat.i(80145);
                                            com.tencent.mm.plugin.ball.f.f.e(true, true, false);
                                            if (WebViewUI.this.gaW().ISC) {
                                                MPVideoPlayFullScreenView gfi = WebViewUI.this.gfi();
                                                Context context = gfi.getContext();
                                                if ((context instanceof WebViewUI) && ((WebViewUI) context).pGj != null) {
                                                    gfi.JvR = ((WebViewUI) context).pGj.setVideoJsCallback(new MPVideoPlayFullScreenView.i(gfi));
                                                }
                                                if (gfi.JvR != null) {
                                                    z = true;
                                                } else {
                                                    z = false;
                                                }
                                                if (z) {
                                                    WebViewUI.this.JjR = customViewCallback;
                                                    Log.i("MicroMsg.WebViewUI", "onEnterFullscreen view");
                                                    if (view.getParent() == null) {
                                                        WebViewUI.this.gfi().gg(view);
                                                    }
                                                    AppMethodBeat.o(80145);
                                                    return true;
                                                }
                                            }
                                            if (WebViewUI.this.gaW().ISC) {
                                                WebViewUI.this.gaW().zb(false);
                                            }
                                            boolean a2 = super.a(view, customViewCallback);
                                            AppMethodBeat.o(80145);
                                            return a2;
                                        }

                                        @Override // com.tencent.xweb.x
                                        public final boolean bLA() {
                                            AppMethodBeat.i(80146);
                                            com.tencent.mm.plugin.ball.f.f.e(false, true, false);
                                            boolean bLA = super.bLA();
                                            AppMethodBeat.o(80146);
                                            return bLA;
                                        }
                                    }

                                    /* access modifiers changed from: protected */
                                    public final class c extends com.tencent.mm.plugin.webview.core.k {
                                        a Jkd = new a(this, (byte) 0);

                                        public c() {
                                            AppMethodBeat.i(211149);
                                            AppMethodBeat.o(211149);
                                        }

                                        @Override // com.tencent.mm.plugin.webview.core.k
                                        public final boolean c(com.tencent.xweb.WebView webView, int i2, String str, String str2) {
                                            AppMethodBeat.i(211150);
                                            Log.e("MicroMsg.WebViewUI", "edw interceptLoadError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", str2, Integer.valueOf(i2), str, Boolean.valueOf(NetStatusUtil.isConnected(WebViewUI.this)));
                                            AppMethodBeat.o(211150);
                                            return false;
                                        }

                                        @Override // com.tencent.mm.plugin.webview.core.k
                                        public final int getScreenOrientation() {
                                            return WebViewUI.this.screenOrientation;
                                        }

                                        @Override // com.tencent.mm.plugin.webview.core.k
                                        public final boolean gah() {
                                            AppMethodBeat.i(211151);
                                            if (WebViewUI.this.Jjd || WebViewUI.this.Jje || WebViewUI.this.isFinishing()) {
                                                AppMethodBeat.o(211151);
                                                return true;
                                            }
                                            AppMethodBeat.o(211151);
                                            return false;
                                        }

                                        @Override // com.tencent.mm.plugin.webview.core.k
                                        public final com.tencent.mm.plugin.webview.core.f gai() {
                                            return this.Jkd;
                                        }

                                        @Override // com.tencent.mm.plugin.webview.core.k
                                        public final com.tencent.mm.plugin.webview.core.j gaj() {
                                            AppMethodBeat.i(211152);
                                            b bVar = new b(this, (byte) 0);
                                            AppMethodBeat.o(211152);
                                            return bVar;
                                        }

                                        final class a extends com.tencent.mm.plugin.webview.core.f {
                                            private a() {
                                            }

                                            /* synthetic */ a(c cVar, byte b2) {
                                                this();
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.f
                                            public final void i(com.tencent.xweb.WebView webView, String str) {
                                                AppMethodBeat.i(211129);
                                                if (!WebViewUI.this.JjM) {
                                                    WebViewUI.this.Jjm.geN();
                                                }
                                                WebViewUI.this.JjI.geU();
                                                WebViewUI.this.JjI.setCurrentURL(str);
                                                WebViewUI.this.setProgressBarIndeterminateVisibility(false);
                                                WebViewUI.this.Jjm.g(str, WebViewUI.this.getIntent());
                                                WebViewUI.this.zk(false);
                                                if (WebViewUI.this.ILE != null && !WebViewUI.this.ILE.Jkf) {
                                                    o oVar = WebViewUI.this.ILE;
                                                    Log.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageStart, url:%s", str);
                                                    oVar.nKc = str;
                                                    oVar.gge();
                                                    oVar.ggk();
                                                }
                                                WebViewUI.this.Jja = 0;
                                                AppMethodBeat.o(211129);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.f
                                            public final void b(com.tencent.xweb.WebView webView, String str) {
                                                AppMethodBeat.i(211130);
                                                WebViewUI.this.JiA = true;
                                                if (WebViewUI.this.Jjt != null && NetStatusUtil.isNetworkConnected(WebViewUI.this.getContext()) && str != null && !str.startsWith("data:text/html;charset=utf-8")) {
                                                    WebViewUI.this.Jjt.eU("rawUrl", str);
                                                    WebViewUI.this.Jjt.aYt(str);
                                                }
                                                if (WebViewUI.this.Jju != null && NetStatusUtil.isNetworkConnected(WebViewUI.this.getContext()) && str != null && !str.startsWith("data:text/html;charset=utf-8")) {
                                                    WebViewUI.this.Jju.setRawUrl(str);
                                                }
                                                WebViewUI.e(WebViewUI.this, str);
                                                if (!WebViewUI.y(WebViewUI.this)) {
                                                    WebViewUI.this.JiU = true;
                                                    WebViewUI.this.IMs.gdf().loadFinished = true;
                                                }
                                                String title = WebViewUI.this.pGj.getTitle();
                                                Log.i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", WebViewUI.this.getMMTitle(), title, Boolean.valueOf(WebViewUI.this.JhT), Boolean.valueOf(WebViewUI.this.CSQ), WebViewUI.this.gfu());
                                                if (c.this.controller.pGj.getIsX5Kernel() && !Util.isNullOrNil(title) && title.length() > 0 && !title.equals(WebViewUI.this.getMMTitle()) && !title.startsWith("http") && ((WebViewUI.this.gfu() == null || !WebViewUI.this.gfu().equals(title)) && !WebViewUI.this.JhT && WebViewUI.this.CSQ)) {
                                                    Log.d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
                                                    WebViewUI.this.setMMTitle(title);
                                                }
                                                WebViewUI.this.JjI.setCurrentURL(WebViewUI.this.fZM());
                                                WebViewUI.this.setProgressBarIndeterminateVisibility(false);
                                                WebViewUI.this.JhV.finish();
                                                if (WebViewUI.this.ILE != null && !WebViewUI.this.ILE.Jkf) {
                                                    o oVar = WebViewUI.this.ILE;
                                                    Log.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", str);
                                                    oVar.nKc = str;
                                                }
                                                WebViewUI.f(WebViewUI.this, str);
                                                WebViewUI.this.b(webView, str);
                                                AppMethodBeat.o(211130);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.f
                                            public final void aXF(String str) {
                                                AppMethodBeat.i(211131);
                                                WebViewUI.this.JjI.geU();
                                                if (WebViewUI.this.Jjt != null && NetStatusUtil.isNetworkConnected(WebViewUI.this.getContext()) && str != null && !str.startsWith("data:text/html;charset=utf-8")) {
                                                    WebViewUI.this.Jjt.eU("rawUrl", str);
                                                    WebViewUI.this.Jjt.aYt(str);
                                                }
                                                if (WebViewUI.this.Jju != null && NetStatusUtil.isNetworkConnected(WebViewUI.this.getContext()) && str != null && !str.startsWith("data:text/html;charset=utf-8")) {
                                                    WebViewUI.this.Jju.setRawUrl(str);
                                                }
                                                WebViewUI.e(WebViewUI.this, str);
                                                WebViewUI.this.zi(WebViewUI.this.cpC());
                                                AppMethodBeat.o(211131);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.f
                                            public final void a(com.tencent.xweb.WebView webView, int i2, String str, String str2) {
                                                WebViewUI.this.Jjm.Jgs = false;
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.f
                                            public final void e(com.tencent.xweb.WebView webView, String str) {
                                                AppMethodBeat.i(211132);
                                                super.e(webView, str);
                                                o oVar = WebViewUI.this.ILE;
                                                Log.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", str);
                                                oVar.nKc = str;
                                                AppMethodBeat.o(211132);
                                            }
                                        }

                                        final class b extends com.tencent.mm.plugin.webview.core.j {
                                            private b() {
                                            }

                                            /* synthetic */ b(c cVar, byte b2) {
                                                this();
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void by(int i2, String str) {
                                                AppMethodBeat.i(211133);
                                                super.by(i2, str);
                                                if (i2 != 5) {
                                                    WebViewUI.this.zk(false);
                                                }
                                                AppMethodBeat.o(211133);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void gab() {
                                                AppMethodBeat.i(211134);
                                                Log.i("MicroMsg.WebViewUI", "WebView-Trace onAuthSucc: url %s", WebViewUI.this.pFJ);
                                                WebViewUI.a(WebViewUI.this, this.controller.mHi.gdH());
                                                if (!WebViewUI.this.JjM) {
                                                    WebViewUI.this.Jjm.Jgs = true;
                                                }
                                                j jVar = WebViewUI.this.Jjm;
                                                jVar.Jgt.add(6);
                                                jVar.Jgt.add(1);
                                                jVar.Jgt.add(3);
                                                jVar.Jgt.add(2);
                                                WebViewUI.this.Jjm.Jgs = true;
                                                if (WebViewUI.this.Jjm.geL()) {
                                                    WebViewUI.this.cpD();
                                                }
                                                AppMethodBeat.o(211134);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void aXN(String str) {
                                                AppMethodBeat.i(211135);
                                                WebViewUI.this.cpE();
                                                AppMethodBeat.o(211135);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void a(String str, bhj bhj) {
                                                AppMethodBeat.i(211136);
                                                if (!Util.isNullOrNil(bhj.Title)) {
                                                    WebViewUI.this.setMMTitle(bhj.Title);
                                                }
                                                if (bhj.KCD == 6) {
                                                    WebViewUI.this.zj(false);
                                                }
                                                AppMethodBeat.o(211136);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void b(String str, bhj bhj) {
                                                WebViewUI.this.Jjm.Jgp = bhj.LRl;
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void c(String str, bhj bhj) {
                                                AppMethodBeat.i(211137);
                                                WebViewUI.this.pFJ = bhj.LRH;
                                                WebViewUI.this.JiK = WebViewUI.this.mHi.gdH().pP(24);
                                                WebViewUI.this.IMs.gdf().Jae = true;
                                                WebViewUI.this.Jiz = z.a(bhj.LRE);
                                                Log.d("MicroMsg.WebViewUI", "onPermissionUpdate, getA8Key = %s", Util.encodeHexString(WebViewUI.this.Jiz));
                                                AppMethodBeat.o(211137);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void cpR() {
                                                AppMethodBeat.i(211138);
                                                WebViewUI.this.zk(true);
                                                AppMethodBeat.o(211138);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void ePr() {
                                                AppMethodBeat.i(211139);
                                                if (WebViewUI.this.Jjg) {
                                                    Log.e("MicroMsg.WebViewUI", "edw postBinded hasDoPostBind");
                                                    AppMethodBeat.o(211139);
                                                    return;
                                                }
                                                WebViewUI.this.Jjg = true;
                                                WebViewUI.this.bXg();
                                                AppMethodBeat.o(211139);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void gac() {
                                                AppMethodBeat.i(211140);
                                                WebViewUI.this.goBack();
                                                AppMethodBeat.o(211140);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void onFinish() {
                                                AppMethodBeat.i(211141);
                                                WebViewUI.this.finish();
                                                AppMethodBeat.o(211141);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void gad() {
                                                AppMethodBeat.i(211142);
                                                WebViewUI.this.gfx();
                                                AppMethodBeat.o(211142);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void aXO(String str) {
                                                AppMethodBeat.i(211143);
                                                WebViewUI.this.ban(str);
                                                AppMethodBeat.o(211143);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void yS(boolean z) {
                                                AppMethodBeat.i(211144);
                                                if (z && WebViewUI.this.pGj != null) {
                                                    WebViewUI.this.pGj.setOnLongClickListener(WebViewUI.this.JjL);
                                                    WebViewUI.this.JjK = true;
                                                }
                                                AppMethodBeat.o(211144);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void afL(int i2) {
                                                FontChooserView fontChooserView;
                                                AppMethodBeat.i(211145);
                                                if (!(WebViewUI.this.Jib == null || (fontChooserView = (FontChooserView) WebViewUI.this.Jib.findViewById(R.id.d8_)) == null)) {
                                                    fontChooserView.setSliderIndex(i2 - 1);
                                                }
                                                AppMethodBeat.o(211145);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void d(int i2, String str, int i3, String str2) {
                                                AppMethodBeat.i(211146);
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(154, 12, 1, false);
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(154, (long) com.tencent.mm.plugin.webview.i.a.agm(i2), 1, false);
                                                WebViewUI.this.zk(true);
                                                WebViewUI.this.Jjm.Jgs = false;
                                                switch (i2) {
                                                    case 0:
                                                    case 2:
                                                    case 8:
                                                    case 9:
                                                    case 10:
                                                        l.Jhd.agL(i3);
                                                        if (WebViewUI.this.JiS != null && this.controller.fZI()) {
                                                            WebViewUI.this.gfN();
                                                        }
                                                        WebViewUI.this.IMs.gdf().Jae = false;
                                                        WebViewUI.this.IMs.gcZ().cM(str, false);
                                                        if (WebViewUI.this.Jiw) {
                                                            WebViewUI.this.finish();
                                                            break;
                                                        }
                                                        break;
                                                }
                                                AppMethodBeat.o(211146);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void gae() {
                                                AppMethodBeat.i(211147);
                                                super.gae();
                                                if (!WebViewUI.this.JiX && !WebViewUI.this.JiY) {
                                                    WebViewUI.this.JhV.start();
                                                }
                                                AppMethodBeat.o(211147);
                                            }

                                            @Override // com.tencent.mm.plugin.webview.core.j
                                            public final void gaf() {
                                                AppMethodBeat.i(211148);
                                                super.gaf();
                                                WebViewUI.this.JhV.finish();
                                                AppMethodBeat.o(211148);
                                            }
                                        }
                                    }

                                    /* access modifiers changed from: protected */
                                    public final int aXI(String str) {
                                        AppMethodBeat.i(80336);
                                        int aXI = this.IMH.aXI(str);
                                        AppMethodBeat.o(80336);
                                        return aXI;
                                    }

                                    /* access modifiers changed from: protected */
                                    public void cpE() {
                                        AppMethodBeat.i(80341);
                                        this.Jjm.cpE();
                                        AppMethodBeat.o(80341);
                                    }

                                    /* access modifiers changed from: protected */
                                    public void ani() {
                                        AppMethodBeat.i(80342);
                                        this.Jjm.ani();
                                        AppMethodBeat.o(80342);
                                    }

                                    /* access modifiers changed from: protected */
                                    public final void gfN() {
                                        AppMethodBeat.i(80344);
                                        this.JiS.setVisibility(0);
                                        if (this.JhW != null && this.JhW.getVisibility() == 0) {
                                            this.JhW.setVisibility(8);
                                        }
                                        AppMethodBeat.o(80344);
                                    }

                                    private void a(JsapiPermissionWrapper jsapiPermissionWrapper) {
                                        AppMethodBeat.i(211183);
                                        if (jsapiPermissionWrapper != null) {
                                            if (jsapiPermissionWrapper.pP(34)) {
                                                setMMSubTitle(R.string.j1m);
                                                AppMethodBeat.o(211183);
                                                return;
                                            } else if (jsapiPermissionWrapper.pP(75)) {
                                                setMMSubTitle(R.string.j1z);
                                                AppMethodBeat.o(211183);
                                                return;
                                            } else {
                                                setMMSubTitle((String) null);
                                            }
                                        }
                                        AppMethodBeat.o(211183);
                                    }

                                    /* access modifiers changed from: protected */
                                    public boolean gfO() {
                                        return false;
                                    }

                                    /* access modifiers changed from: protected */
                                    public boolean gfP() {
                                        return false;
                                    }

                                    /* access modifiers changed from: package-private */
                                    public class d implements FontChooserView.a {
                                        private d() {
                                        }

                                        /* synthetic */ d(WebViewUI webViewUI, byte b2) {
                                            this();
                                        }

                                        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView.a
                                        public final void ig(int i2) {
                                            int i3 = 1;
                                            AppMethodBeat.i(80184);
                                            switch (i2) {
                                                case 0:
                                                    break;
                                                case 1:
                                                    i3 = 2;
                                                    break;
                                                case 2:
                                                    i3 = 3;
                                                    break;
                                                case 3:
                                                    i3 = 4;
                                                    break;
                                                case 4:
                                                    i3 = 5;
                                                    break;
                                                case 5:
                                                    i3 = 6;
                                                    break;
                                                case 6:
                                                    i3 = 7;
                                                    break;
                                                case 7:
                                                    i3 = 8;
                                                    break;
                                                default:
                                                    i3 = 2;
                                                    break;
                                            }
                                            WebViewUI.this.IMH.afK(i3);
                                            try {
                                                if (WebViewUI.this.mHh.gdW()) {
                                                    MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("WebViewFontUtil", 2);
                                                    mmkv.putBoolean("webview_key_font_has_set", true);
                                                    mmkv.putBoolean("webview_key_has_transfer_mp", true);
                                                    mmkv.apply();
                                                    com.tencent.mm.plugin.webview.k.f.zz(false);
                                                    WebViewUI.this.mHh.km(16384, i3);
                                                    WebViewUI.this.mHh.km(16388, i3);
                                                }
                                                AppMethodBeat.o(80184);
                                            } catch (Exception e2) {
                                                Log.w("MicroMsg.WebViewUI", "onCheckedChanged, ex = " + e2.getMessage());
                                                AppMethodBeat.o(80184);
                                            }
                                        }
                                    }

                                    /* access modifiers changed from: protected */
                                    public void agP(int i2) {
                                        AppMethodBeat.i(80351);
                                        if (this.pGj == null || this.pGj.getSettings() == null) {
                                            AppMethodBeat.o(80351);
                                            return;
                                        }
                                        Log.i("MicroMsg.WebViewUI", "localSetFontSize, fontSize = ".concat(String.valueOf(i2)));
                                        switch (i2) {
                                            case 1:
                                                this.pGj.getSettings().setTextZoom(80);
                                                AppMethodBeat.o(80351);
                                                return;
                                            case 2:
                                                this.pGj.getSettings().setTextZoom(100);
                                                AppMethodBeat.o(80351);
                                                return;
                                            case 3:
                                                this.pGj.getSettings().setTextZoom(110);
                                                AppMethodBeat.o(80351);
                                                return;
                                            case 4:
                                                this.pGj.getSettings().setTextZoom(112);
                                                AppMethodBeat.o(80351);
                                                return;
                                            case 5:
                                                this.pGj.getSettings().setTextZoom(112);
                                                AppMethodBeat.o(80351);
                                                return;
                                            case 6:
                                                this.pGj.getSettings().setTextZoom(140);
                                                AppMethodBeat.o(80351);
                                                return;
                                            case 7:
                                                this.pGj.getSettings().setTextZoom(155);
                                                AppMethodBeat.o(80351);
                                                return;
                                            case 8:
                                                this.pGj.getSettings().setTextZoom(TbsListener.ErrorCode.STARTDOWNLOAD_6);
                                                AppMethodBeat.o(80351);
                                                return;
                                            default:
                                                this.pGj.getSettings().setTextZoom(100);
                                                AppMethodBeat.o(80351);
                                                return;
                                        }
                                    }

                                    public final boolean gbB() {
                                        AppMethodBeat.i(80354);
                                        if (this.JiQ == null || !this.JiQ.gci() || Util.isNullOrNil(this.JiQ.ggc()) || Util.isNullOrNil(this.JiQ.gck()) || Util.isNullOrNil(this.JiQ.gcl())) {
                                            AppMethodBeat.o(80354);
                                            return false;
                                        }
                                        String ggc = this.JiQ.ggc();
                                        String gck = this.JiQ.gck();
                                        String gcl = this.JiQ.gcl();
                                        Log.i("MicroMsg.WebViewUI", "use js api close window confirm info : %s, %s, %s", ggc, gck, gcl);
                                        View inflate = View.inflate(getContext(), R.layout.b7f, null);
                                        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.ffe);
                                        checkBox.setChecked(false);
                                        checkBox.setVisibility(8);
                                        TextView textView = (TextView) inflate.findViewById(R.id.ffg);
                                        textView.setText(ggc);
                                        textView.setTextColor(getResources().getColor(R.color.a2x));
                                        TextView textView2 = (TextView) inflate.findViewById(R.id.fff);
                                        textView2.setTextColor(getResources().getColor(R.color.a2x));
                                        textView2.setVisibility(8);
                                        this.JiR = com.tencent.mm.ui.base.h.a((Context) getContext(), true, "", inflate, gck, gcl, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass38 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(259658);
                                                if (checkBox != null && checkBox.isChecked()) {
                                                    try {
                                                        if (WebViewUI.this.mHh.gdW()) {
                                                            WebViewUI.this.mHh.km(327792, 1);
                                                        }
                                                    } catch (Exception e2) {
                                                        Log.e("MicroMsg.WebViewUI", "tryShowCloseWindowConfirmInfo, ex = " + e2.getMessage());
                                                    }
                                                }
                                                WebViewUI.this.Jjd = true;
                                                WebViewUI.this.JiR = null;
                                                l.Jhd.close();
                                                if (WebViewUI.this.Jju != null && WebViewUI.this.Jju.wu(1)) {
                                                    AppMethodBeat.o(259658);
                                                } else if (WebViewUI.this.Jjt == null || !WebViewUI.this.Jjt.wu(1)) {
                                                    WebViewUI.this.finish();
                                                    AppMethodBeat.o(259658);
                                                } else {
                                                    AppMethodBeat.o(259658);
                                                }
                                            }
                                        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass39 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(211123);
                                                WebViewUI.this.JiR = null;
                                                AppMethodBeat.o(211123);
                                            }
                                        });
                                        AppMethodBeat.o(80354);
                                        return true;
                                    }

                                    private boolean gfQ() {
                                        AppMethodBeat.i(80355);
                                        int intExtra = getIntent().getIntExtra("key_close_action", 0);
                                        Bundle bundleExtra = getIntent().getBundleExtra("key_close_data");
                                        Log.i("MicroMsg.WebViewUI", "close action %s", Integer.valueOf(intExtra));
                                        switch (intExtra) {
                                            case 1:
                                                if (bundleExtra != null) {
                                                    String string = bundleExtra.getString("close_dialog_title");
                                                    String string2 = bundleExtra.getString("close_dialog_msg");
                                                    String string3 = bundleExtra.getString("close_dialog_ok");
                                                    String string4 = bundleExtra.getString("close_dialog_cancel");
                                                    boolean z = bundleExtra.getBoolean("close_dialog_ok_close", true);
                                                    if (!Util.isNullOrNil(string2, string3, string4)) {
                                                        if (z) {
                                                            com.tencent.mm.ui.base.h.a((Context) this, string, string2, string3, string4, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                                                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass40 */

                                                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                                                    AppMethodBeat.i(259659);
                                                                    WebViewUI.this.Jjd = true;
                                                                    l.Jhd.close();
                                                                    WebViewUI.this.finish();
                                                                    AppMethodBeat.o(259659);
                                                                }
                                                            }, (DialogInterface.OnClickListener) null);
                                                        } else {
                                                            com.tencent.mm.ui.base.h.a((Context) this, string, string2, string3, string4, false, (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                                                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass41 */

                                                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                                                    AppMethodBeat.i(211124);
                                                                    WebViewUI.this.Jjd = true;
                                                                    l.Jhd.close();
                                                                    WebViewUI.this.finish();
                                                                    AppMethodBeat.o(211124);
                                                                }
                                                            });
                                                        }
                                                        AppMethodBeat.o(80355);
                                                        return true;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                if (bundleExtra != null) {
                                                    String string5 = bundleExtra.getString("close_jump_url");
                                                    int i2 = bundleExtra.getInt("close_jump_url_request_code", 0);
                                                    if (!Util.isNullOrNil(string5)) {
                                                        Intent intent = new Intent(this, WebViewUI.class);
                                                        intent.putExtra("rawUrl", string5);
                                                        intent.putExtra("showShare", false);
                                                        intent.putExtra("show_bottom", false);
                                                        intent.putExtra("needRedirect", false);
                                                        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                                                        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                                                        startActivityForResult(intent, i2);
                                                        com.tencent.mm.ui.base.b.ke(this);
                                                        AppMethodBeat.o(80355);
                                                        return true;
                                                    }
                                                }
                                                break;
                                        }
                                        AppMethodBeat.o(80355);
                                        return false;
                                    }

                                    public void gfR() {
                                        AppMethodBeat.i(80356);
                                        if (gfQ()) {
                                            AppMethodBeat.o(80356);
                                            return;
                                        }
                                        gfS();
                                        if (!gbB()) {
                                            this.Jjd = true;
                                            l.Jhd.close();
                                            if (this.Jju != null && this.Jju.wu(1)) {
                                                AppMethodBeat.o(80356);
                                                return;
                                            } else if (this.Jjt == null || !this.Jjt.wu(1)) {
                                                finish();
                                            } else {
                                                AppMethodBeat.o(80356);
                                                return;
                                            }
                                        }
                                        AppMethodBeat.o(80356);
                                    }

                                    private void gfS() {
                                        AppMethodBeat.i(80357);
                                        if (this.Jjf) {
                                            Log.d("MicroMsg.WebViewUI", "SwipeBackFinish, do not LaunchOuterApp");
                                            AppMethodBeat.o(80357);
                                            return;
                                        }
                                        Intent intent = getIntent();
                                        boolean booleanExtra = intent.getBooleanExtra("webview_invoke_launch_app_when_back", false);
                                        String stringExtra = intent.getStringExtra("KAppId");
                                        String stringExtra2 = intent.getStringExtra("webview_invoke_launch_app_ext_info_when_back");
                                        if (booleanExtra && stringExtra != null && stringExtra.length() > 0 && stringExtra2 != null && stringExtra2.length() > 0) {
                                            Bundle bundle = new Bundle();
                                            bundle.putString("appId", stringExtra);
                                            bundle.putString(IssueStorage.COLUMN_EXT_INFO, stringExtra2);
                                            com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, v.class, null);
                                        }
                                        AppMethodBeat.o(80357);
                                    }

                                    /* access modifiers changed from: protected */
                                    public static final class a {
                                        private String IVn;
                                        private String IVo;
                                        private String IVp;
                                        private String IVq;
                                        private String IVr;
                                        private String IVs;
                                        private String JjZ;
                                        private String lang;

                                        private a(Bundle bundle) {
                                            AppMethodBeat.i(80123);
                                            this.JjZ = bundle.getString("close_window_confirm_dialog_switch");
                                            this.IVn = bundle.getString("close_window_confirm_dialog_title_cn");
                                            this.IVo = bundle.getString("close_window_confirm_dialog_title_eng");
                                            this.IVp = bundle.getString("close_window_confirm_dialog_ok_cn");
                                            this.IVq = bundle.getString("close_window_confirm_dialog_ok_eng");
                                            this.IVr = bundle.getString("close_window_confirm_dialog_cancel_cn");
                                            this.IVs = bundle.getString("close_window_confirm_dialog_cancel_eng");
                                            this.lang = bundle.getString("application_language");
                                            AppMethodBeat.o(80123);
                                        }

                                        public static a bc(Bundle bundle) {
                                            AppMethodBeat.i(80124);
                                            a aVar = new a(bundle);
                                            AppMethodBeat.o(80124);
                                            return aVar;
                                        }

                                        public final boolean gci() {
                                            AppMethodBeat.i(80125);
                                            if (Util.isNullOrNil(this.JjZ)) {
                                                AppMethodBeat.o(80125);
                                                return false;
                                            }
                                            boolean equals = this.JjZ.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                                            AppMethodBeat.o(80125);
                                            return equals;
                                        }

                                        public final String ggc() {
                                            AppMethodBeat.i(80126);
                                            if (LocaleUtil.CHINA.equals(this.lang)) {
                                                String str = this.IVn;
                                                AppMethodBeat.o(80126);
                                                return str;
                                            }
                                            String str2 = this.IVo;
                                            AppMethodBeat.o(80126);
                                            return str2;
                                        }

                                        public final String gck() {
                                            AppMethodBeat.i(80127);
                                            if (LocaleUtil.CHINA.equals(this.lang)) {
                                                String str = this.IVp;
                                                AppMethodBeat.o(80127);
                                                return str;
                                            }
                                            String str2 = this.IVq;
                                            AppMethodBeat.o(80127);
                                            return str2;
                                        }

                                        public final String gcl() {
                                            AppMethodBeat.i(80128);
                                            if (LocaleUtil.CHINA.equals(this.lang)) {
                                                String str = this.IVr;
                                                AppMethodBeat.o(80128);
                                                return str;
                                            }
                                            String str2 = this.IVs;
                                            AppMethodBeat.o(80128);
                                            return str2;
                                        }
                                    }

                                    /* access modifiers changed from: protected */
                                    public void su(boolean z) {
                                    }

                                    /* access modifiers changed from: protected */
                                    public void m(int i2, Bundle bundle) {
                                    }

                                    /* access modifiers changed from: protected */
                                    public boolean gfT() {
                                        return true;
                                    }

                                    /* access modifiers changed from: protected */
                                    public void z(int i2, Bundle bundle) {
                                        AppMethodBeat.i(80358);
                                        Log.i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
                                        AppMethodBeat.o(80358);
                                    }

                                    public final void zl(boolean z) {
                                        AppMethodBeat.i(80359);
                                        if (this.pGj == null) {
                                            AppMethodBeat.o(80359);
                                            return;
                                        }
                                        String url = this.pGj.getUrl();
                                        if (z) {
                                            showOptionMenu(0, false);
                                            this.JiP.put(url, Boolean.TRUE);
                                            AppMethodBeat.o(80359);
                                            return;
                                        }
                                        showOptionMenu(0, true);
                                        if (this.JiP.containsKey(url)) {
                                            this.JiP.remove(url);
                                        }
                                        AppMethodBeat.o(80359);
                                    }

                                    /* access modifiers changed from: protected */
                                    public final boolean gfU() {
                                        AppMethodBeat.i(80360);
                                        if (this.JjT != -3) {
                                            showVKB();
                                            AppMethodBeat.o(80360);
                                            return true;
                                        }
                                        AppMethodBeat.o(80360);
                                        return false;
                                    }

                                    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.appbrand.widget.input.ad, com.tencent.mm.ui.MMFragmentActivity
                                    public void hideVKB() {
                                        AppMethodBeat.i(80361);
                                        super.hideVKB();
                                        this.JjT = -2;
                                        AppMethodBeat.o(80361);
                                    }

                                    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.appbrand.widget.input.ad, com.tencent.mm.ui.MMFragmentActivity
                                    public void showVKB() {
                                        AppMethodBeat.i(80362);
                                        super.showVKB();
                                        if (this.JjT == -3) {
                                            this.JjT = -2;
                                            AppMethodBeat.o(80362);
                                            return;
                                        }
                                        this.JjT = -3;
                                        AppMethodBeat.o(80362);
                                    }

                                    @Override // com.tencent.mm.ui.MMActivity
                                    public void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener, int i2) {
                                        AppMethodBeat.i(80363);
                                        super.setBackBtn(onMenuItemClickListener, i2);
                                        if (com.tencent.mm.compatible.util.d.oD(21) && gfr()) {
                                            setBackBtnColorFilter(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR);
                                        }
                                        AppMethodBeat.o(80363);
                                    }

                                    public final boolean gbH() {
                                        AppMethodBeat.i(80364);
                                        boolean booleanExtra = getIntent().getBooleanExtra("forceHideShare", false);
                                        boolean booleanExtra2 = getIntent().getBooleanExtra("showShare", true);
                                        boolean booleanExtra3 = getIntent().getBooleanExtra("KRightBtn", false);
                                        Log.i("MicroMsg.WebViewUI", "forceHideShare:%b showShareBtn:%b enableMinimize:%b, banRightBtn %b", Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(cpz()), Boolean.valueOf(booleanExtra3));
                                        if (booleanExtra3 || booleanExtra || !booleanExtra2 || !cpz()) {
                                            AppMethodBeat.o(80364);
                                            return false;
                                        }
                                        AppMethodBeat.o(80364);
                                        return true;
                                    }

                                    /* access modifiers changed from: protected */
                                    public boolean cpz() {
                                        boolean z;
                                        AppMethodBeat.i(80365);
                                        if (!getClass().equals(WebViewUI.class) || getIntent().getBooleanExtra("disable_minimize", false)) {
                                            z = false;
                                        } else {
                                            z = true;
                                        }
                                        Log.i("MicroMsg.WebViewUI", "enableMinimize class:%s enable:%b", getClass(), Boolean.valueOf(z));
                                        AppMethodBeat.o(80365);
                                        return z;
                                    }

                                    public boolean cpI() {
                                        return false;
                                    }

                                    /* access modifiers changed from: protected */
                                    public final void gfV() {
                                        AppMethodBeat.i(211184);
                                        if (this.Jjd || this.Jje || isFinishing()) {
                                            AppMethodBeat.o(211184);
                                            return;
                                        }
                                        if (this.IMH != null) {
                                            i iVar = this.IMH;
                                            iVar.k(iVar.coX(), true, 8);
                                        }
                                        if (this.JiS != null) {
                                            this.JiS.setVisibility(8);
                                        }
                                        this.IMs.gdg().D(coX(), 4).report();
                                        AppMethodBeat.o(211184);
                                    }

                                    public final MMWebView gfW() {
                                        return this.pGj;
                                    }

                                    /* access modifiers changed from: protected */
                                    public void b(com.tencent.xweb.WebView webView, String str) {
                                        AppMethodBeat.i(80367);
                                        az azVar = this.IMs;
                                        Intent intent = getIntent();
                                        String coX = coX();
                                        int intExtra = intent.getIntExtra("geta8key_scene", 0);
                                        int intExtra2 = intent.getIntExtra("bizEnterId", azVar.Jac);
                                        int intExtra3 = intent.getIntExtra("webview_scene_type", 1);
                                        String stringExtra = intent.getStringExtra("webview_scene_note");
                                        String stringExtra2 = intent.getStringExtra("srcUsername");
                                        if (Util.isNullOrNil(stringExtra2)) {
                                            stringExtra2 = intent.getStringExtra("geta8key_username");
                                        }
                                        String stringExtra3 = intent.getStringExtra("KAppId");
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(18452, Integer.valueOf(intExtra2), Integer.valueOf(intExtra), com.tencent.mm.pluginsdk.ui.tools.z.bfG(coX), com.tencent.mm.pluginsdk.ui.tools.z.bfG(str), Integer.valueOf(intExtra3), stringExtra, stringExtra3, stringExtra2);
                                        if (this.JhW != null && this.JhW.getVisibility() == 0) {
                                            this.JhW.setVisibility(8);
                                            this.JiX = false;
                                        }
                                        AppMethodBeat.o(80367);
                                    }

                                    public final int geT() {
                                        AppMethodBeat.i(211185);
                                        int geT = this.Jjm.geT();
                                        AppMethodBeat.o(211185);
                                        return geT;
                                    }

                                    /* access modifiers changed from: protected */
                                    public void X(Bundle bundle) {
                                        AppMethodBeat.i(211186);
                                        this.Jjm.geS();
                                        AppMethodBeat.o(211186);
                                    }

                                    @Override // com.tencent.mm.ui.MMFragmentActivity
                                    public void startActivity(Intent intent) {
                                        AppMethodBeat.i(80369);
                                        if (Util.isEqual(intent.getType(), "application/vnd.android.package-archive")) {
                                            r.l(MMApplicationContext.getContext(), intent.getData());
                                            AppMethodBeat.o(80369);
                                            return;
                                        }
                                        super.startActivity(intent);
                                        AppMethodBeat.o(80369);
                                    }

                                    public boolean cpP() {
                                        return false;
                                    }

                                    public final void gfX() {
                                        AppMethodBeat.i(211187);
                                        if (this.IMH != null) {
                                            Iterator<T> it = this.IMH.ICu.iterator();
                                            while (it.hasNext()) {
                                                it.next().gag();
                                            }
                                        }
                                        AppMethodBeat.o(211187);
                                    }

                                    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                                    public void onCreate(Bundle bundle) {
                                        AppMethodBeat.i(80244);
                                        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_webviewui_disable_accessibility, true)) {
                                            AccessibilityUtil.smartDisableAccessibility();
                                        }
                                        j jVar = this.Jji;
                                        jVar.createTime = System.currentTimeMillis();
                                        jVar.bN("onCreate", jVar.createTime);
                                        this.Jji.JBP = getIntent().getLongExtra("startTime", 0);
                                        cqh();
                                        super.onCreate(bundle);
                                        this.Jji.bN("onUIInitStart", System.currentTimeMillis());
                                        cpA();
                                        this.Jji.bN("onUIInitEnd", System.currentTimeMillis());
                                        Intent intent = getIntent();
                                        if (ao.gJN()) {
                                            overridePendingTransition(MMFragmentActivity.a.OHB, 0);
                                        }
                                        if (intent.hasExtra("nextAnimIn") || intent.hasExtra("currentAnimOut")) {
                                            overridePendingTransition(intent.getIntExtra("nextAnimIn", R.anim.eq), intent.getIntExtra("currentAnimOut", R.anim.en));
                                        }
                                        AppMethodBeat.o(80244);
                                    }

                                    private boolean gfo() {
                                        return this.Jig || this.Jih;
                                    }

                                    /* access modifiers changed from: protected */
                                    public final int hXP() {
                                        AppMethodBeat.i(259665);
                                        if (!com.tencent.mm.compatible.util.d.oD(21) || !gfr()) {
                                            int color = getResources().getColor(R.color.bk);
                                            AppMethodBeat.o(259665);
                                            return color;
                                        }
                                        AppMethodBeat.o(259665);
                                        return com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR;
                                    }

                                    /* access modifiers changed from: protected */
                                    public final void gfs() {
                                        AppMethodBeat.i(80256);
                                        if (!com.tencent.mm.compatible.util.d.oD(21) || this.xPp == 0) {
                                            setStatusBarColor(bXh());
                                            AppMethodBeat.o(80256);
                                            return;
                                        }
                                        setActionbarColor(this.xPp);
                                        AppMethodBeat.o(80256);
                                    }

                                    /* access modifiers changed from: protected */
                                    public int gfD() {
                                        AppMethodBeat.i(80287);
                                        if (this.JiY) {
                                            AppMethodBeat.o(80287);
                                            return R.raw.actionbar_icon_dark_back;
                                        }
                                        AppMethodBeat.o(80287);
                                        return R.raw.actionbar_icon_dark_close;
                                    }

                                    /* access modifiers changed from: protected */
                                    public final void b(String str, Drawable drawable) {
                                        AppMethodBeat.i(80309);
                                        final boolean fZV = this.IMH.fZV();
                                        final String stringExtra = getIntent().getStringExtra("srcUsername");
                                        addIconOptionMenu(0, str, drawable, new MenuItem.OnMenuItemClickListener() {
                                            /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass25 */

                                            public final boolean onMenuItemClick(MenuItem menuItem) {
                                                AppMethodBeat.i(259650);
                                                if (!fZV) {
                                                    WebViewUI.this.cpD();
                                                } else {
                                                    WebViewUI.this.bas(stringExtra);
                                                }
                                                AppMethodBeat.o(259650);
                                                return true;
                                            }
                                        });
                                        AppMethodBeat.o(80309);
                                    }

                                    @Override // com.tencent.mm.ui.MMActivity
                                    public void addIconOptionMenu(int i2, int i3, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
                                        AppMethodBeat.i(80313);
                                        if (!com.tencent.mm.compatible.util.d.oD(21)) {
                                            super.addIconOptionMenu(i2, i3, onMenuItemClickListener);
                                            AppMethodBeat.o(80313);
                                            return;
                                        }
                                        Drawable l = android.support.v4.content.b.l(this, i3);
                                        if (l == null) {
                                            AppMethodBeat.o(80313);
                                            return;
                                        }
                                        if (gfr()) {
                                            l.setColorFilter(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR, PorterDuff.Mode.SRC_ATOP);
                                        } else if (this.ILE == null || this.ILE.Jkf) {
                                            l.clearColorFilter();
                                        } else {
                                            l.setColorFilter(getResources().getColor(R.color.FG_0), PorterDuff.Mode.SRC_ATOP);
                                        }
                                        addIconOptionMenu(i2, getString(R.string.wp), l, onMenuItemClickListener);
                                        AppMethodBeat.o(80313);
                                    }

                                    static /* synthetic */ void b(WebViewUI webViewUI) {
                                        AppMethodBeat.i(259667);
                                        Log.i("MicroMsg.WebViewUI", "resetFloatBallInfo");
                                        if (webViewUI.IBw != null && webViewUI.IBw.GBl) {
                                            webViewUI.zk(true);
                                        }
                                        webViewUI.JjI.setCurrentURL(webViewUI.IMH.getCurrentUrl());
                                        com.tencent.mm.plugin.webview.ui.tools.floatball.c cVar = webViewUI.IMH.ILG;
                                        if (!Util.isNullOrNil(cVar.title)) {
                                            webViewUI.setMMTitle(cVar.title);
                                        }
                                        if (webViewUI.ILE != null) {
                                            webViewUI.ILE.ggk();
                                        }
                                        try {
                                            cVar.JmM = false;
                                            Iterator<com.tencent.mm.plugin.webview.ui.tools.floatball.a> it = cVar.xwA.iterator();
                                            while (it.hasNext()) {
                                                com.tencent.mm.plugin.webview.ui.tools.floatball.a next = it.next();
                                                webViewUI.ISw.j(next.id, next.bundle);
                                            }
                                            cVar.JmM = true;
                                            AppMethodBeat.o(259667);
                                        } catch (Exception e2) {
                                            Log.i("MicroMsg.WebViewUI", "resetFloatBallInfo ex = %s ", e2.getMessage());
                                            AppMethodBeat.o(259667);
                                        }
                                    }

                                    static /* synthetic */ void a(WebViewUI webViewUI, String str) {
                                        AppMethodBeat.i(211189);
                                        if (webViewUI.mHh != null) {
                                            Bundle bundle = new Bundle(1);
                                            bundle.putString("show_kb_input_callback_text", Util.nullAsNil(str));
                                            try {
                                                webViewUI.mHh.a(41, bundle, webViewUI.IMH.fZu());
                                            } catch (Exception e2) {
                                                Log.i("MicroMsg.WebViewUI", "showKbInputCallback, exception = %s, text = %s", e2, str);
                                            }
                                        }
                                        if (webViewUI.Jij != null) {
                                            webViewUI.Jij.hide();
                                        }
                                        AppMethodBeat.o(211189);
                                    }

                                    static /* synthetic */ void b(WebViewUI webViewUI, String str) {
                                        AppMethodBeat.i(80374);
                                        if (webViewUI.mHh != null) {
                                            Bundle bundle = new Bundle(1);
                                            bundle.putString("show_kb_input_callback_text", Util.nullAsNil(str));
                                            try {
                                                webViewUI.mHh.a(2210, bundle, webViewUI.IMH.fZu());
                                                AppMethodBeat.o(80374);
                                                return;
                                            } catch (Exception e2) {
                                                Log.i("MicroMsg.WebViewUI", "showKbInputCallback, exception = %s, text = %s", e2, str);
                                            }
                                        }
                                        AppMethodBeat.o(80374);
                                    }

                                    static /* synthetic */ void a(WebViewUI webViewUI, int i2) {
                                        AppMethodBeat.i(80375);
                                        if (webViewUI.Jij != null && webViewUI.JiW) {
                                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) webViewUI.Jij.getLayoutParams();
                                            if (marginLayoutParams.bottomMargin != i2) {
                                                marginLayoutParams.bottomMargin = i2;
                                                webViewUI.Jij.setLayoutParams(marginLayoutParams);
                                            }
                                        }
                                        AppMethodBeat.o(80375);
                                    }

                                    static /* synthetic */ void b(WebViewUI webViewUI, int i2) {
                                        AppMethodBeat.i(211190);
                                        if (webViewUI.Jik != null && webViewUI.JiW) {
                                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) webViewUI.Jik.getLayoutParams();
                                            if (marginLayoutParams.bottomMargin != i2) {
                                                marginLayoutParams.bottomMargin = i2;
                                                webViewUI.Jik.setLayoutParams(marginLayoutParams);
                                            }
                                            if (webViewUI.pGj.getIsX5Kernel()) {
                                                i2 = webViewUI.Jik.getVisibility() == 0 ? webViewUI.Jik.getHeight() + i2 : 0;
                                            } else if (webViewUI.Jik.getVisibility() == 0) {
                                                i2 += webViewUI.Jik.getHeight();
                                            }
                                            webViewUI.pGj.setPadding(webViewUI.pGj.getPaddingLeft(), webViewUI.pGj.getPaddingTop(), webViewUI.pGj.getPaddingRight(), i2);
                                            webViewUI.pGj.post(new Runnable() {
                                                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass2 */

                                                public final void run() {
                                                    AppMethodBeat.i(259621);
                                                    if (WebViewUI.this.pGj != null) {
                                                        WebViewUI.this.pGj.requestLayout();
                                                    }
                                                    AppMethodBeat.o(259621);
                                                }
                                            });
                                        }
                                        AppMethodBeat.o(211190);
                                    }

                                    static /* synthetic */ void c(WebViewUI webViewUI, final String str) {
                                        AppMethodBeat.i(175805);
                                        com.tencent.mm.ui.base.h.a(webViewUI, str, new String[]{com.tencent.mm.cb.a.aI(webViewUI, R.string.fsj), com.tencent.mm.cb.a.aI(webViewUI, R.string.fsf)}, "", new h.d() {
                                            /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass24 */

                                            @Override // com.tencent.mm.ui.base.h.d
                                            public final void oj(int i2) {
                                                AppMethodBeat.i(259649);
                                                switch (i2) {
                                                    case 0:
                                                        if (!WebViewUI.d(WebViewUI.this, str)) {
                                                            Log.f("MicroMsg.WebViewUI", "showLoadUrlMenu, canLoadUrl fail, url = " + str);
                                                            WebViewUI.this.gfx();
                                                            AppMethodBeat.o(259649);
                                                            return;
                                                        }
                                                        WebViewUI.this.loadUrl(str);
                                                        AppMethodBeat.o(259649);
                                                        return;
                                                    case 1:
                                                        ClipboardHelper.setText(WebViewUI.this.getApplicationContext(), str, str);
                                                        break;
                                                }
                                                AppMethodBeat.o(259649);
                                            }
                                        });
                                        AppMethodBeat.o(175805);
                                    }

                                    static /* synthetic */ boolean d(WebViewUI webViewUI, String str) {
                                        AppMethodBeat.i(211191);
                                        boolean aXB = webViewUI.IMH.aXB(str);
                                        AppMethodBeat.o(211191);
                                        return aXB;
                                    }

                                    static /* synthetic */ void a(WebViewUI webViewUI, WebViewKeyboardLinearLayout webViewKeyboardLinearLayout, int i2) {
                                        AppMethodBeat.i(211192);
                                        if (webViewUI.JiA) {
                                            if (i2 == -3) {
                                                final int keyBoardHeight = webViewKeyboardLinearLayout.getKeyBoardHeight();
                                                webViewUI.handler.post(new Runnable() {
                                                    /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass30 */

                                                    public final void run() {
                                                        AppMethodBeat.i(259653);
                                                        if (WebViewUI.this.IBw != null) {
                                                            WebViewUI.this.IBw.afV(keyBoardHeight);
                                                        }
                                                        if (WebViewUI.this.JhY != null) {
                                                            WebViewUI.this.JhY.zi(false);
                                                        }
                                                        AppMethodBeat.o(259653);
                                                    }
                                                });
                                                AppMethodBeat.o(211192);
                                                return;
                                            }
                                            webViewUI.handler.post(new Runnable() {
                                                /* class com.tencent.mm.plugin.webview.ui.tools.WebViewUI.AnonymousClass31 */

                                                public final void run() {
                                                    AppMethodBeat.i(211119);
                                                    if (WebViewUI.this.IBw != null) {
                                                        WebViewUI.this.IBw.afV(0);
                                                    }
                                                    if (WebViewUI.this.JhY != null && WebViewUI.this.cpC()) {
                                                        WebViewUI.this.JhY.zi(true);
                                                    }
                                                    AppMethodBeat.o(211119);
                                                }
                                            });
                                        }
                                        AppMethodBeat.o(211192);
                                    }

                                    static /* synthetic */ boolean g(WebViewUI webViewUI) {
                                        AppMethodBeat.i(211193);
                                        if (webViewUI.Jij == null || !webViewUI.Jij.isShown()) {
                                            AppMethodBeat.o(211193);
                                            return false;
                                        }
                                        AppMethodBeat.o(211193);
                                        return true;
                                    }

                                    static /* synthetic */ void f(WebViewUI webViewUI, String str) {
                                        AppMethodBeat.i(259669);
                                        webViewUI.JjP = str;
                                        Log.i("MicroMsg.WebViewUI", "onWeixinReady when page commit");
                                        Log.i("MicroMsg.WebViewUI", "onWeixinReady, inject url=%s", str);
                                        if (webViewUI.mHi != null) {
                                            webViewUI.a(webViewUI.mHi.gdH());
                                        }
                                        webViewUI.zi(webViewUI.cpC());
                                        if (!webViewUI.JiM.containsKey(str)) {
                                            webViewUI.JiM.put(str, Boolean.valueOf(webViewUI.isOptionMenuShow(0)));
                                        }
                                        webViewUI.zj(webViewUI.JiM.get(str).booleanValue());
                                        Boolean bool = webViewUI.JiP.get(str);
                                        if (bool == null || !bool.booleanValue()) {
                                            webViewUI.showOptionMenu(0, true);
                                        } else {
                                            webViewUI.showOptionMenu(0, false);
                                        }
                                        if (webViewUI.Jiv && Util.isNullOrNil(webViewUI.JjQ)) {
                                            webViewUI.JjQ = webViewUI.IMH.IJM;
                                        }
                                        AppMethodBeat.o(259669);
                                    }
                                }
