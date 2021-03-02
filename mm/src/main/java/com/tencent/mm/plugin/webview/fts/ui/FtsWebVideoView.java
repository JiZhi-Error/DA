package com.tencent.mm.plugin.webview.fts.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.ui.WebSearchDotPercentIndicator;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.fts.c.b;
import com.tencent.mm.plugin.webview.fts.c.d;
import com.tencent.mm.plugin.webview.fts.ui.a;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public class FtsWebVideoView extends RelativeLayout {
    private ImageView GlX;
    private ImageView IGW;
    private b IPW = b.AUTO;
    public FtsVideoWrapper IPX;
    public WebSearchWebVideoViewControlBar IPY;
    private View IPZ;
    private View IQa;
    private WebSearchDotPercentIndicator IQb;
    private View IQc;
    private Button IQd;
    private TextView IQe;
    private TextView IQf;
    private boolean IQg;
    private a IQh;
    private a IQi;
    private d IQj;
    private b.a IQk;
    private int IQl;
    private boolean IQm;
    private long IQn;
    private View IQo;
    private View IQp;
    private c IQq = c.UNKNOWN;
    public BroadcastReceiver IQr = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.AnonymousClass10 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(78048);
            if (FtsWebVideoView.this.IPX.isPlaying()) {
                FtsWebVideoView.a(FtsWebVideoView.this, context);
            }
            AppMethodBeat.o(78048);
        }
    };
    private boolean cEZ;
    public boolean guh;
    private boolean isLoading;
    private String mAppId;
    private boolean mLoop;
    private TextView mvK;
    private LinearLayout mvQ;
    private TextView mvS;
    private ImageView mvT;
    private ImageView mvU;
    private String mvY;
    private int mvZ;
    private boolean mwb;
    private boolean mwd;
    private boolean mwh;
    private String mwj;
    private int pOi;
    private String url;

    public interface a {
        void bGL();

        boolean isFullScreen();

        void yU(boolean z);
    }

    static /* synthetic */ void a(FtsWebVideoView ftsWebVideoView, String str, String str2) {
        AppMethodBeat.i(78121);
        ftsWebVideoView.lS(str, str2);
        AppMethodBeat.o(78121);
    }

    static /* synthetic */ boolean a(FtsWebVideoView ftsWebVideoView, Context context) {
        AppMethodBeat.i(78117);
        boolean hS = ftsWebVideoView.hS(context);
        AppMethodBeat.o(78117);
        return hS;
    }

    static /* synthetic */ void b(FtsWebVideoView ftsWebVideoView, Context context) {
        AppMethodBeat.i(78118);
        ftsWebVideoView.hT(context);
        AppMethodBeat.o(78118);
    }

    static /* synthetic */ boolean e(FtsWebVideoView ftsWebVideoView) {
        AppMethodBeat.i(78119);
        boolean gaJ = ftsWebVideoView.gaJ();
        AppMethodBeat.o(78119);
        return gaJ;
    }

    static /* synthetic */ boolean i(FtsWebVideoView ftsWebVideoView) {
        AppMethodBeat.i(78120);
        boolean gaK = ftsWebVideoView.gaK();
        AppMethodBeat.o(78120);
        return gaK;
    }

    static /* synthetic */ boolean t(FtsWebVideoView ftsWebVideoView) {
        AppMethodBeat.i(78123);
        boolean isLive = ftsWebVideoView.isLive();
        AppMethodBeat.o(78123);
        return isLive;
    }

    /* access modifiers changed from: package-private */
    public enum b {
        AUTO,
        LANDSCAPE,
        PORTRAIT;

        public static b valueOf(String str) {
            AppMethodBeat.i(78071);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(78071);
            return bVar;
        }

        static {
            AppMethodBeat.i(78072);
            AppMethodBeat.o(78072);
        }
    }

    /* access modifiers changed from: package-private */
    public enum c {
        UNKNOWN,
        MOBILE_NET,
        NO_NET;

        public static c valueOf(String str) {
            AppMethodBeat.i(78074);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(78074);
            return cVar;
        }

        static {
            AppMethodBeat.i(78075);
            AppMethodBeat.o(78075);
        }
    }

    public FtsWebVideoView(Context context, boolean z) {
        super(context);
        AppMethodBeat.i(78076);
        setAutoPlay(z);
        init(context);
        AppMethodBeat.o(78076);
    }

    public FtsWebVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(78077);
        init(context);
        AppMethodBeat.o(78077);
    }

    public FtsWebVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(78078);
        init(context);
        AppMethodBeat.o(78078);
    }

    private void init(Context context) {
        AppMethodBeat.i(78079);
        LayoutInflater.from(context).inflate(R.layout.ao3, this);
        this.IPX = (FtsVideoWrapper) findViewById(R.id.j6y);
        this.mvK = (TextView) findViewById(R.id.gl7);
        this.IPZ = findViewById(R.id.ioc);
        this.IQa = findViewById(R.id.ip3);
        this.mvQ = (LinearLayout) findViewById(R.id.i1);
        this.IQb = (WebSearchDotPercentIndicator) findViewById(R.id.i2);
        this.mvS = (TextView) findViewById(R.id.hy);
        this.mvT = (ImageView) findViewById(R.id.i0);
        this.mvU = (ImageView) findViewById(R.id.bgv);
        this.IQo = findViewById(R.id.j59);
        this.IQp = findViewById(R.id.ip4);
        this.IQb.setDotsNum(8);
        this.GlX = (ImageView) findViewById(R.id.bgy);
        this.IQc = findViewById(R.id.bhb);
        this.IQe = (TextView) findViewById(R.id.iod);
        this.IQd = (Button) findViewById(R.id.ioe);
        this.IQf = (TextView) findViewById(R.id.iog);
        this.IGW = (ImageView) findViewById(R.id.c6j);
        this.IQe.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(78036);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FtsWebVideoView.this.pause();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(78036);
            }
        });
        this.IGW.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(78045);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FtsWebVideoView.this.yT(!FtsWebVideoView.this.bJb());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(78045);
            }
        });
        this.IQd.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(78046);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (FtsWebVideoView.this.IQq == c.MOBILE_NET) {
                    FtsWebVideoView.this.IQm = true;
                }
                FtsWebVideoView.this.start(true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(78046);
            }
        });
        this.IQc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(78047);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FtsWebVideoView.this.start(true);
                FtsWebVideoView.this.IPY.bJB();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(78047);
            }
        });
        bIY();
        bJa();
        gaL();
        context.registerReceiver(this.IQr, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        gaI();
        AppMethodBeat.o(78079);
    }

    private boolean hS(final Context context) {
        AppMethodBeat.i(78080);
        c cVar = this.IQq;
        if (!NetStatusUtil.isConnected(context)) {
            if (cVar == c.NO_NET) {
                this.IQo.setVisibility(0);
                this.IQp.setVisibility(8);
                this.IPZ.setVisibility(0);
                postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.AnonymousClass11 */

                    public final void run() {
                        AppMethodBeat.i(78049);
                        FtsWebVideoView.b(FtsWebVideoView.this, context);
                        AppMethodBeat.o(78049);
                    }
                }, 200);
            } else {
                hT(context);
            }
            AppMethodBeat.o(78080);
            return false;
        } else if (this.IQm || NetStatusUtil.isWifi(context)) {
            AppMethodBeat.o(78080);
            return true;
        } else {
            pause();
            this.IQq = c.MOBILE_NET;
            this.IPY.setVisibility(8);
            String netUnavailableTip = getNetUnavailableTip();
            String string = context.getString(R.string.hw6);
            context.getString(R.string.hvu);
            lS(netUnavailableTip, string);
            AppMethodBeat.o(78080);
            return false;
        }
    }

    private void hT(Context context) {
        AppMethodBeat.i(78081);
        this.IQq = c.NO_NET;
        pause();
        lS(context.getString(R.string.hx_), context.getString(R.string.hxp));
        AppMethodBeat.o(78081);
    }

    private String getNetUnavailableTip() {
        String str;
        AppMethodBeat.i(78082);
        if (this.IQl == 0) {
            String string = getContext().getString(R.string.hxb);
            AppMethodBeat.o(78082);
            return string;
        }
        Context context = getContext();
        Object[] objArr = new Object[1];
        long j2 = (long) this.IQl;
        if (j2 < 0) {
            str = "";
        } else {
            BigDecimal bigDecimal = new BigDecimal(j2);
            float floatValue = bigDecimal.divide(new BigDecimal(1048576), 2, 0).floatValue();
            if (floatValue > 1.0f) {
                str = ((int) floatValue) + "M";
            } else {
                str = ((int) bigDecimal.divide(new BigDecimal(1024), 2, 0).floatValue()) + "K";
            }
        }
        objArr[0] = str;
        String string2 = context.getString(R.string.hxa, objArr);
        AppMethodBeat.o(78082);
        return string2;
    }

    private void lS(String str, String str2) {
        AppMethodBeat.i(78083);
        gaI();
        this.IQo.setVisibility(8);
        this.IQp.setVisibility(0);
        this.IPY.setVisibility(8);
        this.IPZ.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.IQf.setText(str);
            this.IQf.setVisibility(0);
        } else {
            this.IQf.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.IQd.setText(str2);
            this.IQd.setVisibility(0);
        } else {
            this.IQd.setVisibility(8);
        }
        this.IQa.setVisibility(0);
        this.IQc.setVisibility(8);
        this.IQe.setVisibility(8);
        gaH();
        AppMethodBeat.o(78083);
    }

    private void gaH() {
        AppMethodBeat.i(78084);
        if (bJb()) {
            this.IGW.setVisibility(0);
            AppMethodBeat.o(78084);
            return;
        }
        this.IGW.setVisibility(8);
        AppMethodBeat.o(78084);
    }

    public void setAppId(String str) {
        AppMethodBeat.i(78085);
        Log.i("MicroMsg.FtsWebVideoView", "setAppId appid=%s", str);
        this.mAppId = str;
        AppMethodBeat.o(78085);
    }

    public void setVideoPlayerId(int i2) {
        this.mvZ = i2;
    }

    public int getmVideoPlayerId() {
        return this.mvZ;
    }

    public void setAutoPlay(boolean z) {
        AppMethodBeat.i(78086);
        Log.i("MicroMsg.FtsWebVideoView", "setAutoPlay =%b", Boolean.valueOf(z));
        this.cEZ = z;
        AppMethodBeat.o(78086);
    }

    public void setDuration(int i2) {
        AppMethodBeat.i(78087);
        if (i2 <= 0) {
            Log.i("MicroMsg.FtsWebVideoView", "setDuration error duration=%d", Integer.valueOf(i2));
            AppMethodBeat.o(78087);
            return;
        }
        AppMethodBeat.o(78087);
    }

    public void setLoop(boolean z) {
        AppMethodBeat.i(78088);
        Log.i("MicroMsg.FtsWebVideoView", "setLoop loop=%b", Boolean.valueOf(z));
        this.mLoop = z;
        AppMethodBeat.o(78088);
    }

    public final void start(boolean z) {
        AppMethodBeat.i(78089);
        Log.i("MicroMsg.FtsWebVideoView", "start");
        gaI();
        if (!z || hS(getContext())) {
            this.IQq = c.UNKNOWN;
            if (this.IPX.isPlaying()) {
                AppMethodBeat.o(78089);
                return;
            }
            if (this.mwb) {
                WebSearchWebVideoViewControlBar webSearchWebVideoViewControlBar = this.IPY;
                if (webSearchWebVideoViewControlBar.mww == null) {
                    webSearchWebVideoViewControlBar.mww = new MTimerHandler(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0050: IPUT  
                          (wrap: com.tencent.mm.sdk.platformtools.MTimerHandler : 0x004d: CONSTRUCTOR  (r1v3 com.tencent.mm.sdk.platformtools.MTimerHandler) = 
                          (wrap: com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar$2 : 0x0049: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar$2) = (r0v10 'webSearchWebVideoViewControlBar' com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar) call: com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar.2.<init>(com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar):void type: CONSTRUCTOR)
                          true
                         call: com.tencent.mm.sdk.platformtools.MTimerHandler.<init>(com.tencent.mm.sdk.platformtools.MTimerHandler$CallBack, boolean):void type: CONSTRUCTOR)
                          (r0v10 'webSearchWebVideoViewControlBar' com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar)
                         com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar.mww com.tencent.mm.sdk.platformtools.MTimerHandler in method: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.start(boolean):void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004d: CONSTRUCTOR  (r1v3 com.tencent.mm.sdk.platformtools.MTimerHandler) = 
                          (wrap: com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar$2 : 0x0049: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar$2) = (r0v10 'webSearchWebVideoViewControlBar' com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar) call: com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar.2.<init>(com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar):void type: CONSTRUCTOR)
                          true
                         call: com.tencent.mm.sdk.platformtools.MTimerHandler.<init>(com.tencent.mm.sdk.platformtools.MTimerHandler$CallBack, boolean):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.start(boolean):void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 35 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0049: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar$2) = (r0v10 'webSearchWebVideoViewControlBar' com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar) call: com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar.2.<init>(com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.start(boolean):void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:663)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 39 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 45 more
                        */
                    /*
                    // Method dump skipped, instructions count: 131
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.start(boolean):void");
                }

                private void gaI() {
                    AppMethodBeat.i(78090);
                    this.IPZ.setVisibility(8);
                    AppMethodBeat.o(78090);
                }

                public final void pause() {
                    AppMethodBeat.i(78091);
                    Log.i("MicroMsg.FtsWebVideoView", "pause");
                    gaI();
                    if (!this.IPX.isPlaying()) {
                        AppMethodBeat.o(78091);
                        return;
                    }
                    this.IPX.pause();
                    AppMethodBeat.o(78091);
                }

                public final void stop() {
                    AppMethodBeat.i(78092);
                    Log.i("MicroMsg.FtsWebVideoView", "stop");
                    if (!this.IPX.isPlaying()) {
                        AppMethodBeat.o(78092);
                        return;
                    }
                    this.IPX.stop();
                    WebSearchWebVideoViewControlBar webSearchWebVideoViewControlBar = this.IPY;
                    if (webSearchWebVideoViewControlBar.mww != null) {
                        webSearchWebVideoViewControlBar.mww.stopTimer();
                    }
                    AppMethodBeat.o(78092);
                }

                public final void cN(String str, int i2) {
                    AppMethodBeat.i(78093);
                    Log.i("MicroMsg.FtsWebVideoView", "setVideoPath path=%s isLive=%s", str, Boolean.FALSE);
                    this.url = str;
                    if (Util.isNullOrNil(str)) {
                        Log.v("MicroMsg.FtsWebVideoView", "setVideoPath videoPath empty");
                        AppMethodBeat.o(78093);
                        return;
                    }
                    stop();
                    this.mwh = false;
                    this.IPX.c(false, str, i2);
                    if (this.IPY != null) {
                        this.IPY.setVideoTotalTime(i2);
                    }
                    if (this.pOi > 0) {
                        this.IPX.p((double) this.pOi);
                    }
                    if (this.cEZ) {
                        Log.i("MicroMsg.FtsWebVideoView", "setVideoPath autoPlay");
                        start(false);
                    }
                    if (str.startsWith("wxfile://")) {
                        setCover(str);
                    }
                    AppMethodBeat.o(78093);
                }

                public final void ac(int i2, boolean z) {
                    AppMethodBeat.i(78094);
                    Log.i("MicroMsg.FtsWebVideoView", "seek to position=%d current=%d isLive=%b", Integer.valueOf(i2), Integer.valueOf(this.IPX.getCurrPosSec()), Boolean.valueOf(this.mwh));
                    if (isLive()) {
                        AppMethodBeat.o(78094);
                    } else if (z) {
                        this.IPX.c((double) i2, z);
                        AppMethodBeat.o(78094);
                    } else {
                        this.IPX.p((double) i2);
                        AppMethodBeat.o(78094);
                    }
                }

                public void setIsShowBasicControls(boolean z) {
                    AppMethodBeat.i(78095);
                    Log.i("MicroMsg.FtsWebVideoView", "setIsShowBasicControls isShowBasicControls=%b", Boolean.valueOf(z));
                    this.mwb = z;
                    AppMethodBeat.o(78095);
                }

                public final void setCover$16da05f7(String str) {
                    AppMethodBeat.i(78096);
                    Log.i("MicroMsg.FtsWebVideoView", "setCover coverUrl=%s", str);
                    if (Util.isNullOrNil(str)) {
                        AppMethodBeat.o(78096);
                        return;
                    }
                    this.mwj = str;
                    com.tencent.mm.modelappbrand.a.b.aXY().a(this.mvU, str, (Drawable) null, (b.h) null);
                    AppMethodBeat.o(78096);
                }

                private void setCover(String str) {
                    AppMethodBeat.i(78097);
                    if (Util.isNullOrNil(str)) {
                        AppMethodBeat.o(78097);
                    } else if (!Util.isNullOrNil(this.mwj)) {
                        Log.i("MicroMsg.FtsWebVideoView", "setCover mCoverUrl not null");
                        AppMethodBeat.o(78097);
                    } else {
                        AppMethodBeat.o(78097);
                    }
                }

                public void setObjectFit(String str) {
                    AppMethodBeat.i(78098);
                    Log.i("MicroMsg.FtsWebVideoView", "setObjectFit objectFit=%s", str);
                    if ("fill".equalsIgnoreCase(str)) {
                        this.IPX.setScaleType(i.e.FILL);
                        this.mvU.setScaleType(ImageView.ScaleType.FIT_XY);
                        AppMethodBeat.o(78098);
                    } else if ("cover".equalsIgnoreCase(str)) {
                        this.IPX.setScaleType(i.e.COVER);
                        this.mvU.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        AppMethodBeat.o(78098);
                    } else {
                        this.IPX.setScaleType(i.e.CONTAIN);
                        this.mvU.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        AppMethodBeat.o(78098);
                    }
                }

                public void setMute(boolean z) {
                    AppMethodBeat.i(78099);
                    Log.i("MicroMsg.FtsWebVideoView", "setMute isMute=%b", Boolean.valueOf(z));
                    this.guh = z;
                    this.IPX.setMute(z);
                    if (z) {
                        this.IPY.ard();
                        AppMethodBeat.o(78099);
                        return;
                    }
                    this.IPY.fYN();
                    AppMethodBeat.o(78099);
                }

                public void setCookieData(String str) {
                    this.mvY = str;
                }

                public String getCookieData() {
                    return this.mvY;
                }

                public int getCurrPosSec() {
                    AppMethodBeat.i(78100);
                    int currPosSec = this.IPX.getCurrPosSec();
                    AppMethodBeat.o(78100);
                    return currPosSec;
                }

                public int getCurrPosMs() {
                    AppMethodBeat.i(78101);
                    int currPosMs = this.IPX.getCurrPosMs();
                    AppMethodBeat.o(78101);
                    return currPosMs;
                }

                public void setFullScreenDirection(String str) {
                    AppMethodBeat.i(78102);
                    Log.i("MicroMsg.FtsWebVideoView", "setFullScreenDirection %s", str);
                    if (MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL.equalsIgnoreCase(str)) {
                        this.IPW = b.LANDSCAPE;
                        AppMethodBeat.o(78102);
                    } else if ("vertical".equalsIgnoreCase(str)) {
                        this.IPW = b.PORTRAIT;
                        AppMethodBeat.o(78102);
                    } else {
                        this.IPW = b.AUTO;
                        AppMethodBeat.o(78102);
                    }
                }

                public void setDisableScroll(boolean z) {
                    AppMethodBeat.i(78103);
                    Log.i("MicroMsg.FtsWebVideoView", "setDisableScroll isDisableScroll=%b", Boolean.valueOf(z));
                    this.IQg = z;
                    AppMethodBeat.o(78103);
                }

                public void setPageGesture(boolean z) {
                    AppMethodBeat.i(78104);
                    Log.i("MicroMsg.FtsWebVideoView", "setPageGesture pageGesture=%b", Boolean.valueOf(z));
                    this.mwd = z;
                    AppMethodBeat.o(78104);
                }

                public void setInitialTime(int i2) {
                    AppMethodBeat.i(78105);
                    Log.i("MicroMsg.FtsWebVideoView", "setInitialTime initialTime=%d", Integer.valueOf(i2));
                    this.pOi = i2;
                    AppMethodBeat.o(78105);
                }

                public void setCallback(d dVar) {
                    this.IQj = dVar;
                }

                public void setFullScreenDelegate(a aVar) {
                    this.IQi = aVar;
                }

                public d getCallback() {
                    return this.IQj;
                }

                private void bIY() {
                    AppMethodBeat.i(78106);
                    this.IQh = new a(getContext(), this, new a.b() {
                        /* class com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.AnonymousClass12 */

                        @Override // com.tencent.mm.plugin.webview.fts.ui.a.b
                        public final void bJj() {
                            AppMethodBeat.i(78050);
                            Log.d("MicroMsg.FtsWebVideoView", "onSingleTap");
                            if (FtsWebVideoView.e(FtsWebVideoView.this)) {
                                FtsWebVideoView.this.IPY.yQ(FtsWebVideoView.this.isLoading);
                            }
                            AppMethodBeat.o(78050);
                        }

                        @Override // com.tencent.mm.plugin.webview.fts.ui.a.b
                        public final void bJk() {
                            AppMethodBeat.i(78051);
                            Log.d("MicroMsg.FtsWebVideoView", "onDoubleTap");
                            AppMethodBeat.o(78051);
                        }

                        @Override // com.tencent.mm.plugin.webview.fts.ui.a.b
                        public final void bJl() {
                            AppMethodBeat.i(78052);
                            if (FtsWebVideoView.this.IPX.isLive()) {
                                Log.i("MicroMsg.FtsWebVideoView", "onStartDragProgress isLive: no seek");
                                AppMethodBeat.o(78052);
                                return;
                            }
                            FtsWebVideoView.this.mvK.setVisibility(0);
                            FtsWebVideoView.this.IPY.fzM();
                            AppMethodBeat.o(78052);
                        }

                        @Override // com.tencent.mm.plugin.webview.fts.ui.a.b
                        public final int k(int i2, float f2) {
                            int i3 = 0;
                            AppMethodBeat.i(78053);
                            if (FtsWebVideoView.this.IPX.isLive()) {
                                Log.i("MicroMsg.FtsWebVideoView", "onDragProgress isLive: no seek");
                                AppMethodBeat.o(78053);
                            } else {
                                Log.i("MicroMsg.FtsWebVideoView", "onDragProgress:" + i2 + FilePathGenerator.ANDROID_DIR_SEP + f2);
                                float measuredWidth = f2 / ((float) FtsWebVideoView.this.getMeasuredWidth());
                                int videoDurationSec = FtsWebVideoView.this.IPX.getVideoDurationSec();
                                int currentPosition = ((int) (measuredWidth * ((float) videoDurationSec))) + getCurrentPosition();
                                if (currentPosition >= 0) {
                                    if (currentPosition > videoDurationSec) {
                                        i3 = videoDurationSec;
                                    } else {
                                        i3 = currentPosition;
                                    }
                                }
                                FtsWebVideoView.this.mvK.setText(com.tencent.mm.plugin.webview.fts.c.c.AF(((long) i3) * 1000) + FilePathGenerator.ANDROID_DIR_SEP + com.tencent.mm.plugin.webview.fts.c.c.AF(((long) videoDurationSec) * 1000));
                                AppMethodBeat.o(78053);
                            }
                            return i3;
                        }

                        @Override // com.tencent.mm.plugin.webview.fts.ui.a.b
                        public final void l(int i2, float f2) {
                            AppMethodBeat.i(78054);
                            FtsWebVideoView.this.IPY.fzN();
                            FtsWebVideoView.this.mvK.setVisibility(8);
                            Log.i("MicroMsg.FtsWebVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", Integer.valueOf(i2), Integer.valueOf(FtsWebVideoView.this.IPX.getCurrPosSec()), Float.valueOf(f2));
                            if (FtsWebVideoView.this.IPX.isLive()) {
                                Log.i("MicroMsg.FtsWebVideoView", "onEndDragProgress isLive: no seek");
                                AppMethodBeat.o(78054);
                                return;
                            }
                            FtsWebVideoView.this.ac(i2, false);
                            FtsWebVideoView.this.IPY.fzN();
                            if (FtsWebVideoView.this.IQj != null) {
                                FtsWebVideoView.this.IQj.gaP();
                            }
                            AppMethodBeat.o(78054);
                        }

                        @Override // com.tencent.mm.plugin.webview.fts.ui.a.b
                        public final boolean fyT() {
                            AppMethodBeat.i(78055);
                            if (FtsWebVideoView.i(FtsWebVideoView.this)) {
                                AppMethodBeat.o(78055);
                                return false;
                            }
                            AppMethodBeat.o(78055);
                            return true;
                        }

                        @Override // com.tencent.mm.plugin.webview.fts.ui.a.b
                        public final int getCurrentPosition() {
                            AppMethodBeat.i(78056);
                            int currPosSec = FtsWebVideoView.this.IPX.getCurrPosSec();
                            AppMethodBeat.o(78056);
                            return currPosSec;
                        }

                        @Override // com.tencent.mm.plugin.webview.fts.ui.a.b
                        public final void aM(float f2) {
                            AppMethodBeat.i(78057);
                            Log.d("MicroMsg.FtsWebVideoView", "onAdjustVolume:".concat(String.valueOf(f2)));
                            FtsWebVideoView.this.IQb.setPercent(f2);
                            FtsWebVideoView.this.mvS.setText(R.string.dl4);
                            FtsWebVideoView.this.mvT.setImageResource(R.raw.fts_web_video_volume_icon);
                            FtsWebVideoView.this.mvQ.setVisibility(0);
                            AppMethodBeat.o(78057);
                        }

                        @Override // com.tencent.mm.plugin.webview.fts.ui.a.b
                        public final void aN(float f2) {
                            AppMethodBeat.i(78058);
                            Log.d("MicroMsg.FtsWebVideoView", "onAdjustBrightness:".concat(String.valueOf(f2)));
                            FtsWebVideoView.this.IQb.setPercent(f2);
                            FtsWebVideoView.this.mvS.setText(R.string.dl1);
                            FtsWebVideoView.this.mvT.setImageResource(R.raw.fts_web_video_brightness_icon);
                            FtsWebVideoView.this.mvQ.setVisibility(0);
                            AppMethodBeat.o(78058);
                        }

                        @Override // com.tencent.mm.plugin.webview.fts.ui.a.b
                        public final void bJm() {
                            AppMethodBeat.i(78059);
                            FtsWebVideoView.this.mvQ.setVisibility(8);
                            AppMethodBeat.o(78059);
                        }

                        @Override // com.tencent.mm.plugin.webview.fts.ui.a.b
                        public final void bJn() {
                            AppMethodBeat.i(78060);
                            FtsWebVideoView.this.mvQ.setVisibility(8);
                            AppMethodBeat.o(78060);
                        }
                    });
                    AppMethodBeat.o(78106);
                }

                private void bJa() {
                    AppMethodBeat.i(78107);
                    this.IPX.setIMMVideoViewCallback(new i.b() {
                        /* class com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.AnonymousClass13 */

                        @Override // com.tencent.mm.pluginsdk.ui.i.b
                        public final void c(String str, String str2, String str3, int i2, int i3) {
                            AppMethodBeat.i(78061);
                            Log.i("MicroMsg.FtsWebVideoView", "onError errorMsg=%s what=%d extra=%d", str3, Integer.valueOf(i2), Integer.valueOf(i3));
                            h.INSTANCE.a(14911, Integer.valueOf(i2), Integer.valueOf(i3), FtsWebVideoView.this.url, NetStatusUtil.getFormatedNetType(FtsWebVideoView.this.getContext()));
                            if (FtsWebVideoView.this.IQj != null) {
                                d dVar = FtsWebVideoView.this.IQj;
                                Log.e("MicroMsg.JsApiVideoCallback", "onError what %d, extra %d", Integer.valueOf(i2), Integer.valueOf(i3));
                                dVar.clean();
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("errCode", i2);
                                    jSONObject.put("errMsg", String.valueOf(i3));
                                    dVar.bY(dVar.b(7, jSONObject));
                                } catch (JSONException e2) {
                                    Log.printErrStackTrace("MicroMsg.JsApiVideoCallback", e2, null, new Object[0]);
                                }
                            }
                            FtsWebVideoView.this.pause();
                            FtsWebVideoView.a(FtsWebVideoView.this, FtsWebVideoView.this.getContext().getString(R.string.hwj, i2 + ":" + i3), FtsWebVideoView.this.getContext().getString(R.string.hxp));
                            AppMethodBeat.o(78061);
                        }

                        @Override // com.tencent.mm.pluginsdk.ui.i.b
                        public final void dH(String str, String str2) {
                            AppMethodBeat.i(78062);
                            Log.i("MicroMsg.FtsWebVideoView", "onPrepared");
                            a aVar = FtsWebVideoView.this.IQh;
                            aVar.mDM = -1;
                            aVar.mDN = 0;
                            aVar.mDL = 0.0f;
                            FtsWebVideoView.this.IPY.yQ(FtsWebVideoView.this.isLoading);
                            AppMethodBeat.o(78062);
                        }

                        @Override // com.tencent.mm.pluginsdk.ui.i.b
                        public final void dI(String str, String str2) {
                            AppMethodBeat.i(78063);
                            Log.i("MicroMsg.FtsWebVideoView", "onVideoEnded");
                            if (FtsWebVideoView.this.IQj != null) {
                                d dVar = FtsWebVideoView.this.IQj;
                                Log.d("MicroMsg.JsApiVideoCallback", "onVideoEnded %s", dVar.toString());
                                dVar.bKw();
                                try {
                                    dVar.bY(dVar.b(3, null));
                                } catch (JSONException e2) {
                                    Log.printErrStackTrace("MicroMsg.JsApiVideoCallback", e2, null, new Object[0]);
                                }
                            }
                            if (FtsWebVideoView.this.mLoop) {
                                FtsWebVideoView.this.ac(0, true);
                                AppMethodBeat.o(78063);
                                return;
                            }
                            FtsWebVideoView.this.ac(0, false);
                            FtsWebVideoView.this.pause();
                            FtsWebVideoView.q(FtsWebVideoView.this);
                            FtsWebVideoView.this.GlX.setImageResource(R.drawable.c_8);
                            FtsWebVideoView.this.IPY.setVisibility(8);
                            AppMethodBeat.o(78063);
                        }

                        @Override // com.tencent.mm.pluginsdk.ui.i.b
                        public final void d(String str, String str2, int i2, int i3) {
                            AppMethodBeat.i(78064);
                            Log.i("MicroMsg.FtsWebVideoView", "onGetVideoSize width=%d height=%d", Integer.valueOf(i2), Integer.valueOf(i3));
                            if (FtsWebVideoView.this.IPW == b.AUTO) {
                                FtsWebVideoView.this.IPW = i2 < i3 ? b.PORTRAIT : b.LANDSCAPE;
                                Log.i("MicroMsg.FtsWebVideoView", "onGetVideoSize adjust direction from AUTO to %s", FtsWebVideoView.this.IPW);
                            }
                            AppMethodBeat.o(78064);
                        }

                        @Override // com.tencent.mm.pluginsdk.ui.i.b
                        public final void dJ(String str, String str2) {
                            AppMethodBeat.i(78065);
                            Log.i("MicroMsg.FtsWebVideoView", "onVideoPause");
                            if (!(FtsWebVideoView.this.IQj == null || FtsWebVideoView.this.IQj == null)) {
                                d dVar = FtsWebVideoView.this.IQj;
                                Log.d("MicroMsg.JsApiVideoCallback", "onVideoPause %s", dVar.toString());
                                dVar.bKw();
                                try {
                                    dVar.bY(dVar.b(2, null));
                                    AppMethodBeat.o(78065);
                                    return;
                                } catch (JSONException e2) {
                                    Log.printErrStackTrace("MicroMsg.JsApiVideoCallback", e2, null, new Object[0]);
                                }
                            }
                            AppMethodBeat.o(78065);
                        }

                        @Override // com.tencent.mm.pluginsdk.ui.i.b
                        public final void dK(String str, String str2) {
                            AppMethodBeat.i(78066);
                            Log.i("MicroMsg.FtsWebVideoView", "onVideoPlay, isLive:%b", Boolean.valueOf(FtsWebVideoView.t(FtsWebVideoView.this)));
                            if (FtsWebVideoView.this.IQj != null) {
                                d dVar = FtsWebVideoView.this.IQj;
                                Log.d("MicroMsg.JsApiVideoCallback", "onVideoPlay %s", dVar.toString());
                                dVar.mAN = 0;
                                if (dVar.mAM == null) {
                                    dVar.mAM = new MTimerHandler(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004f: IPUT  
                                          (wrap: com.tencent.mm.sdk.platformtools.MTimerHandler : 0x004c: CONSTRUCTOR  (r1v12 com.tencent.mm.sdk.platformtools.MTimerHandler) = 
                                          (wrap: com.tencent.mm.plugin.webview.fts.c.d$1 : 0x0049: CONSTRUCTOR  (r2v10 com.tencent.mm.plugin.webview.fts.c.d$1) = (r0v15 'dVar' com.tencent.mm.plugin.webview.fts.c.d) call: com.tencent.mm.plugin.webview.fts.c.d.1.<init>(com.tencent.mm.plugin.webview.fts.c.d):void type: CONSTRUCTOR)
                                          true
                                         call: com.tencent.mm.sdk.platformtools.MTimerHandler.<init>(com.tencent.mm.sdk.platformtools.MTimerHandler$CallBack, boolean):void type: CONSTRUCTOR)
                                          (r0v15 'dVar' com.tencent.mm.plugin.webview.fts.c.d)
                                         com.tencent.mm.plugin.webview.fts.c.d.mAM com.tencent.mm.sdk.platformtools.MTimerHandler in method: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.13.dK(java.lang.String, java.lang.String):void, file: classes8.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
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
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004c: CONSTRUCTOR  (r1v12 com.tencent.mm.sdk.platformtools.MTimerHandler) = 
                                          (wrap: com.tencent.mm.plugin.webview.fts.c.d$1 : 0x0049: CONSTRUCTOR  (r2v10 com.tencent.mm.plugin.webview.fts.c.d$1) = (r0v15 'dVar' com.tencent.mm.plugin.webview.fts.c.d) call: com.tencent.mm.plugin.webview.fts.c.d.1.<init>(com.tencent.mm.plugin.webview.fts.c.d):void type: CONSTRUCTOR)
                                          true
                                         call: com.tencent.mm.sdk.platformtools.MTimerHandler.<init>(com.tencent.mm.sdk.platformtools.MTimerHandler$CallBack, boolean):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.13.dK(java.lang.String, java.lang.String):void, file: classes8.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 24 more
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0049: CONSTRUCTOR  (r2v10 com.tencent.mm.plugin.webview.fts.c.d$1) = (r0v15 'dVar' com.tencent.mm.plugin.webview.fts.c.d) call: com.tencent.mm.plugin.webview.fts.c.d.1.<init>(com.tencent.mm.plugin.webview.fts.c.d):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.13.dK(java.lang.String, java.lang.String):void, file: classes8.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:663)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 28 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.fts.c.d, state: GENERATED_AND_UNLOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 34 more
                                        */
                                    /*
                                    // Method dump skipped, instructions count: 204
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.AnonymousClass13.dK(java.lang.String, java.lang.String):void");
                                }

                                @Override // com.tencent.mm.pluginsdk.ui.i.b
                                public final void dL(String str, String str2) {
                                    AppMethodBeat.i(78067);
                                    Log.i("MicroMsg.FtsWebVideoView", "onVideoWaiting");
                                    FtsWebVideoView.this.IPY.fzM();
                                    FtsWebVideoView.this.isLoading = true;
                                    AppMethodBeat.o(78067);
                                }

                                @Override // com.tencent.mm.pluginsdk.ui.i.b
                                public final void dM(String str, String str2) {
                                    AppMethodBeat.i(78068);
                                    Log.i("MicroMsg.FtsWebVideoView", "onVideoWaitingEnd");
                                    FtsWebVideoView.this.isLoading = false;
                                    FtsWebVideoView.this.IPY.fzN();
                                    FtsWebVideoView.this.IPY.bJB();
                                    AppMethodBeat.o(78068);
                                }

                                @Override // com.tencent.mm.pluginsdk.ui.i.b
                                public final void fo(String str, String str2) {
                                }
                            });
                            AppMethodBeat.o(78107);
                        }

                        public boolean onTouchEvent(MotionEvent motionEvent) {
                            AppMethodBeat.i(78108);
                            if (this.mwd || bJb()) {
                                if (this.IQh != null) {
                                    a aVar = this.IQh;
                                    if (aVar.IPP.fyT()) {
                                        int actionMasked = motionEvent.getActionMasked();
                                        if (actionMasked == 0) {
                                            aVar.mDL = motionEvent.getRawX();
                                            aVar.MQ = ((AudioManager) aVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
                                            aVar.mue = com.tencent.mm.plugin.webview.fts.c.c.dV(aVar.mContext);
                                        }
                                        GestureDetector gestureDetector = aVar.mDJ;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                                        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                                        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                                        if (actionMasked == 1 || actionMasked == 3) {
                                            if (aVar.IPO == a.EnumC1956a.FastBackwardOrForward) {
                                                aVar.IPP.l(aVar.mDN, motionEvent.getRawX() - aVar.mDL);
                                                aVar.mDM = -1;
                                                aVar.mDN = 0;
                                                aVar.mDL = 0.0f;
                                            } else if (aVar.IPO == a.EnumC1956a.Volume) {
                                                ((AudioManager) aVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamMaxVolume(3);
                                                aVar.IPP.bJm();
                                            } else if (aVar.IPO == a.EnumC1956a.Brightness) {
                                                aVar.IPP.bJn();
                                            }
                                        }
                                    }
                                    aVar.IPO = a.EnumC1956a.None;
                                }
                                AppMethodBeat.o(78108);
                                return true;
                            }
                            if (motionEvent.getAction() == 0 && gaJ()) {
                                this.IPY.yQ(this.isLoading);
                            }
                            boolean onTouchEvent = super.onTouchEvent(motionEvent);
                            AppMethodBeat.o(78108);
                            return onTouchEvent;
                        }

                        public int getSystemVolume() {
                            AppMethodBeat.i(78109);
                            int streamVolume = ((AudioManager) getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
                            AppMethodBeat.o(78109);
                            return streamVolume;
                        }

                        private boolean gaJ() {
                            AppMethodBeat.i(78110);
                            if (!this.mwb || gaK()) {
                                AppMethodBeat.o(78110);
                                return false;
                            }
                            AppMethodBeat.o(78110);
                            return true;
                        }

                        private boolean gaK() {
                            AppMethodBeat.i(78111);
                            if (this.IPZ.getVisibility() == 0) {
                                AppMethodBeat.o(78111);
                                return true;
                            }
                            AppMethodBeat.o(78111);
                            return false;
                        }

                        public final void yT(boolean z) {
                            boolean z2 = false;
                            AppMethodBeat.i(78112);
                            Log.i("MicroMsg.FtsWebVideoView", "operateFullScreen toFullScreen=%b", Boolean.valueOf(z));
                            if (this.IQi == null) {
                                Log.w("MicroMsg.FtsWebVideoView", "operateFullScreen mFullScreenDelegate null");
                                AppMethodBeat.o(78112);
                            } else if (z == bJb()) {
                                Log.i("MicroMsg.FtsWebVideoView", "operateFullScreen current same");
                                AppMethodBeat.o(78112);
                            } else if (z) {
                                a aVar = this.IQi;
                                if (this.IPW != b.PORTRAIT) {
                                    z2 = true;
                                }
                                aVar.yU(z2);
                                WebSearchWebVideoViewControlBar webSearchWebVideoViewControlBar = this.IPY;
                                webSearchWebVideoViewControlBar.mDo = true;
                                webSearchWebVideoViewControlBar.bKT();
                                hN(true);
                                AppMethodBeat.o(78112);
                            } else {
                                this.IQi.bGL();
                                this.IPY.bGL();
                                AppMethodBeat.o(78112);
                            }
                        }

                        public void setAllowMobileNetPlay(boolean z) {
                            this.IQm = z;
                        }

                        public final boolean bJb() {
                            AppMethodBeat.i(78113);
                            if (this.IQi == null) {
                                Log.w("MicroMsg.FtsWebVideoView", "isInFullScreen mFullScreenDelegate null");
                                AppMethodBeat.o(78113);
                                return false;
                            }
                            boolean isFullScreen = this.IQi.isFullScreen();
                            AppMethodBeat.o(78113);
                            return isFullScreen;
                        }

                        private void gaL() {
                            AppMethodBeat.i(78114);
                            this.IPY = new WebSearchWebVideoViewControlBar(getContext());
                            this.IPY.setVisibility(8);
                            this.IPY.setEnterFullScreenBtnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.AnonymousClass14 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(78069);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    FtsWebVideoView.this.yT(!FtsWebVideoView.this.bJb());
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(78069);
                                }
                            });
                            this.IPY.setExitFullScreenBtnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.AnonymousClass2 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(78037);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    FtsWebVideoView.this.yT(!FtsWebVideoView.this.bJb());
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(78037);
                                }
                            });
                            this.IPY.setMuteBtnOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.AnonymousClass3 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(78038);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    FtsWebVideoView.v(FtsWebVideoView.this);
                                    FtsWebVideoView.this.IPY.bJB();
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(78038);
                                }
                            });
                            this.IPY.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b() {
                                /* class com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.AnonymousClass4 */

                                @Override // com.tencent.mm.plugin.sight.decode.ui.b
                                public final void aJq() {
                                    AppMethodBeat.i(78039);
                                    Log.i("MicroMsg.FtsWebVideoView", "onSeekPre");
                                    FtsWebVideoView.this.IPY.crH();
                                    AppMethodBeat.o(78039);
                                }

                                @Override // com.tencent.mm.plugin.sight.decode.ui.b
                                public final void rk(int i2) {
                                    AppMethodBeat.i(78040);
                                    Log.i("MicroMsg.FtsWebVideoView", "onSeekTo %d", Integer.valueOf(i2));
                                    FtsWebVideoView.this.ac(i2, false);
                                    FtsWebVideoView.this.IPY.bJB();
                                    if (FtsWebVideoView.this.IQj != null) {
                                        FtsWebVideoView.this.IQj.gaP();
                                    }
                                    AppMethodBeat.o(78040);
                                }
                            });
                            this.IPY.setOnPlayButtonClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.AnonymousClass5 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(78041);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    if (FtsWebVideoView.this.IPX.isPlaying()) {
                                        FtsWebVideoView.this.IPY.crH();
                                        FtsWebVideoView.this.pause();
                                    } else {
                                        FtsWebVideoView.this.IPY.bJB();
                                        FtsWebVideoView.this.start(true);
                                    }
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/fts/ui/FtsWebVideoView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(78041);
                                }
                            });
                            this.IPY.setStatePorter(new WebSearchWebVideoViewControlBar.a() {
                                /* class com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.AnonymousClass6 */

                                @Override // com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar.a
                                public final int bJh() {
                                    AppMethodBeat.i(78042);
                                    int cacheTimeSec = FtsWebVideoView.this.IPX.getCacheTimeSec();
                                    AppMethodBeat.o(78042);
                                    return cacheTimeSec;
                                }

                                @Override // com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar.a
                                public final int bJi() {
                                    AppMethodBeat.i(78043);
                                    int videoDurationSec = FtsWebVideoView.this.IPX.getVideoDurationSec();
                                    AppMethodBeat.o(78043);
                                    return videoDurationSec;
                                }

                                @Override // com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar.a
                                public final int fYO() {
                                    AppMethodBeat.i(78044);
                                    int currPosMs = FtsWebVideoView.this.IPX.getCurrPosMs();
                                    AppMethodBeat.o(78044);
                                    return currPosMs;
                                }
                            });
                            this.IPX.setVideoFooterView(this.IPY);
                            AppMethodBeat.o(78114);
                        }

                        public final void hN(boolean z) {
                            AppMethodBeat.i(78115);
                            if (this.IQj == null) {
                                AppMethodBeat.o(78115);
                                return;
                            }
                            this.IQj.d(this.mvZ, z, this.IPW == b.PORTRAIT ? "vertical" : MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL);
                            gaH();
                            AppMethodBeat.o(78115);
                        }

                        private boolean isLive() {
                            AppMethodBeat.i(78116);
                            Log.i("MicroMsg.FtsWebVideoView", "isLive %b %b", Boolean.valueOf(this.mwh), Boolean.valueOf(this.IPX.isLive()));
                            if (this.mwh || this.IPX.isLive()) {
                                AppMethodBeat.o(78116);
                                return true;
                            }
                            AppMethodBeat.o(78116);
                            return false;
                        }

                        public b.a getUiLifecycleListener() {
                            return this.IQk;
                        }

                        public void setUiLifecycleListener(b.a aVar) {
                            this.IQk = aVar;
                        }

                        public int getVideoSizeByte() {
                            return this.IQl;
                        }

                        public void setVideoSizeByte(int i2) {
                            this.IQl = i2;
                        }

                        static /* synthetic */ void q(FtsWebVideoView ftsWebVideoView) {
                            AppMethodBeat.i(78122);
                            ftsWebVideoView.IPZ.setVisibility(0);
                            ftsWebVideoView.IQa.setVisibility(8);
                            ftsWebVideoView.IQc.setVisibility(0);
                            ftsWebVideoView.gaH();
                            AppMethodBeat.o(78122);
                        }

                        static /* synthetic */ void v(FtsWebVideoView ftsWebVideoView) {
                            AppMethodBeat.i(78124);
                            ftsWebVideoView.guh = !ftsWebVideoView.guh;
                            ftsWebVideoView.IPX.setMute(ftsWebVideoView.guh);
                            if (ftsWebVideoView.guh) {
                                ftsWebVideoView.IPY.ard();
                                AppMethodBeat.o(78124);
                                return;
                            }
                            ftsWebVideoView.IPY.fYN();
                            AppMethodBeat.o(78124);
                        }
                    }
