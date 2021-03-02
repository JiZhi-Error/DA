package com.tencent.mm.plugin.voip_cs.c.a;

import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.ui.VoipBigIconButton;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.cs.MovableVideoView;
import com.tencent.mm.plugin.voip_cs.c.d;
import com.tencent.mm.plugin.voip_cs.c.e;
import com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;
import java.util.TimerTask;

public final class b implements TextureView.SurfaceTextureListener, View.OnClickListener, r.a, com.tencent.mm.plugin.voip.video.camera.a.b {
    protected static final int[] HeB = {-1, R.string.i2a, R.string.i2f, R.string.i2e};
    protected static int mScreenHeight;
    protected static int mScreenWidth;
    private boolean HdG = false;
    private VoipBigIconButton Hdl;
    private View.OnClickListener Hed = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.voip_cs.c.a.b.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(125372);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
            b.this.Hdl.setEnabled(false);
            if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL > 1) {
                b.e(b.this);
            }
            b.this.Hdl.setEnabled(true);
            if (b.this.Hsb != null) {
                b.this.Hsb.fLd();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(125372);
        }
    };
    private OpenGlView Hfn;
    private OpenGlView Hfo;
    public OpenGlRender Hfp;
    public OpenGlRender Hfq;
    public VoipCSMainUI HrT;
    private RelativeLayout HrU;
    private TextView HrV;
    private TextView HrW;
    private TextView HrX;
    private TextView HrY;
    public ImageView HrZ;
    private MMHandler Hsa;
    private com.tencent.mm.plugin.voip_cs.d.a Hsb;
    private ObservableTextureView Hsc;
    private boolean Hsd = false;
    protected long Hse = -1;
    private boolean Hsf = false;
    private boolean Hsg = false;
    private int Hsh = 60000;
    private int Hsi = 5000;
    private com.tencent.mm.plugin.voip_cs.d.b Hsj = new com.tencent.mm.plugin.voip_cs.d.b();
    public String Hsk = "";
    public String Hsl = "";
    private MTimerHandler Hsm = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.voip_cs.c.a.b.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(125370);
            Log.i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
            com.tencent.mm.plugin.voip_cs.c.c.fMt().dataType = 1;
            b.this.aek(6);
            AppMethodBeat.o(125370);
            return true;
        }
    }, false);
    private MTimerHandler Hsn = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.voip_cs.c.a.b.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(125371);
            b.this.HrW.setText(MMApplicationContext.getContext().getString(R.string.i2h));
            b.this.HrX.setVisibility(0);
            com.tencent.mm.plugin.voip_cs.d.b bVar = b.this.Hsj;
            TextView textView = b.this.HrX;
            int[] iArr = b.HeB;
            if (iArr == null || textView == null) {
                Log.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
            } else {
                bVar.fJB();
                bVar.HeP = 0;
                bVar.HeN = iArr;
                bVar.Ws = textView;
                bVar.HeO = 500;
                if (bVar.cve != null) {
                    bVar.cve.startTimer((long) bVar.HeO);
                }
                Log.printDebugStack("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(textView)), new Object[0]);
            }
            AppMethodBeat.o(125371);
            return true;
        }
    }, false);
    a Hso = new a(this, (byte) 0);
    c Hsp;
    C1900b Hsq;
    String Hsr = "";
    Drawable Hss = null;
    public boolean dLD = false;
    private Timer dfh;
    public TextView gvw;
    private MMHandler hAk;
    private TextView timeTV;
    private ImageButton zSP;
    private View zUm;

    static /* synthetic */ Point b(b bVar, boolean z) {
        AppMethodBeat.i(125409);
        Point xl = bVar.xl(z);
        AppMethodBeat.o(125409);
        return xl;
    }

    static /* synthetic */ void e(b bVar) {
        AppMethodBeat.i(125408);
        bVar.fMJ();
        AppMethodBeat.o(125408);
    }

    static /* synthetic */ void n(b bVar) {
        AppMethodBeat.i(125410);
        bVar.aej(8);
        AppMethodBeat.o(125410);
    }

    static /* synthetic */ void o(b bVar) {
        AppMethodBeat.i(125411);
        bVar.xD(false);
        AppMethodBeat.o(125411);
    }

    public b(VoipCSMainUI voipCSMainUI) {
        AppMethodBeat.i(125382);
        this.HrT = voipCSMainUI;
        WindowManager windowManager = (WindowManager) voipCSMainUI.getSystemService("window");
        int height = windowManager.getDefaultDisplay().getHeight() / 5;
        int width = (windowManager.getDefaultDisplay().getWidth() * height) / windowManager.getDefaultDisplay().getHeight();
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) voipCSMainUI.findViewById(R.id.h7y)).setPadding(0, 0, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(voipCSMainUI.getContext(), 40.0f));
        }
        this.Hfo = new MovableVideoView(voipCSMainUI.getApplicationContext());
        ((MovableVideoView) this.Hfo).jF(width, height);
        this.Hfo.setVisibility(8);
        this.Hfp = new OpenGlRender(this.Hfo, OpenGlRender.RenderRemote);
        this.Hfo.setRenderer(this.Hfp);
        this.Hfo.setRenderMode(0);
        this.timeTV = (TextView) voipCSMainUI.findViewById(R.id.in3);
        this.timeTV.setVisibility(0);
        this.dfh = new Timer("voip_cs_talking_time");
        this.HrV = (TextView) voipCSMainUI.findViewById(R.id.jav);
        this.HrV.setVisibility(0);
        this.HrW = (TextView) voipCSMainUI.findViewById(R.id.jb0);
        if (voipCSMainUI.scene.equals("1")) {
            if (voipCSMainUI.type.equals("video")) {
                this.HrW.setText(MMApplicationContext.getContext().getString(R.string.i1u));
            } else {
                this.HrW.setText(MMApplicationContext.getContext().getString(R.string.i1v));
            }
        } else if (voipCSMainUI.type.equals("video")) {
            this.HrW.setText(MMApplicationContext.getContext().getString(R.string.i1w));
        } else {
            this.HrW.setText(MMApplicationContext.getContext().getString(R.string.i1v));
        }
        this.HrW.setVisibility(0);
        this.gvw = (TextView) voipCSMainUI.findViewById(R.id.jb3);
        this.gvw.setVisibility(0);
        this.HrZ = (ImageView) voipCSMainUI.findViewById(R.id.jaw);
        this.HrZ.setVisibility(0);
        this.HrY = (TextView) voipCSMainUI.findViewById(R.id.jaz);
        this.HrX = (TextView) voipCSMainUI.findViewById(R.id.jb1);
        this.Hdl = (VoipBigIconButton) voipCSMainUI.findViewById(R.id.jax);
        if (voipCSMainUI.HsA == null || !voipCSMainUI.HsA.equals("1")) {
            this.Hdl.setVisibility(8);
        } else {
            this.Hdl.setVisibility(0);
            this.Hdl.setOnClickListener(this.Hed);
        }
        this.hAk = new MMHandler();
        this.Hsa = new MMHandler() {
            /* class com.tencent.mm.plugin.voip_cs.c.a.b.AnonymousClass4 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(125373);
                switch (message.what) {
                    case 12:
                        if (b.this.Hss == null) {
                            b.this.HrZ.setImageResource(R.drawable.bca);
                            break;
                        } else {
                            b.this.HrZ.setImageDrawable(b.this.Hss);
                            AppMethodBeat.o(125373);
                            return;
                        }
                }
                AppMethodBeat.o(125373);
            }
        };
        this.zUm = voipCSMainUI.findViewById(R.id.jas);
        this.zSP = (ImageButton) voipCSMainUI.findViewById(R.id.jay);
        this.HrU = (RelativeLayout) voipCSMainUI.findViewById(R.id.jas);
        mScreenWidth = com.tencent.mm.cb.a.jn(voipCSMainUI.getContext());
        mScreenHeight = com.tencent.mm.plugin.voip_cs.d.c.hI(voipCSMainUI.getContext());
        this.Hfn = (OpenGlView) voipCSMainUI.findViewById(R.id.jat);
        this.Hfn.jG(mScreenWidth, mScreenHeight);
        this.Hfq = new OpenGlRender(this.Hfn, OpenGlRender.RenderLocal);
        this.Hfn.setRenderer(this.Hfq);
        this.Hfn.setRenderMode(0);
        this.Hfn.setVisibility(0);
        Log.i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", Integer.valueOf(mScreenHeight));
        this.zSP.setOnClickListener(this);
        this.HrU.addView(this.Hfo);
        this.Hfo.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip_cs.c.a.b.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(125374);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.this.HdG = !b.this.HdG;
                Point b2 = b.b(b.this, b.this.HdG);
                b.this.Hfo.jH(b2.x, b2.y);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(125374);
            }
        });
        this.Hfp.onStarted();
        this.Hfq.onStarted();
        if (!m.hC(MMApplicationContext.getContext())) {
            m.hD(MMApplicationContext.getContext());
        }
        SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
        this.Hsk = defaultPreference.getString(fMF(), "");
        if (this.HrT.kog != null && !this.HrT.kog.equals("")) {
            aUE(this.HrT.kog);
        } else if (!Util.isNullOrNil(this.Hsk)) {
            aUE(this.Hsk);
        }
        this.Hsl = defaultPreference.getString(fMG(), "");
        if (!Util.isNullOrNil(this.Hsl)) {
            setNickName(this.Hsl);
        }
        e fMs = com.tencent.mm.plugin.voip_cs.c.c.fMs();
        String str = this.HrT.HrM;
        Log.d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:".concat(String.valueOf(str)));
        g.azz().a(106, fMs);
        g.azz().a(new f(str), 0);
        AppMethodBeat.o(125382);
    }

    public final void fMD() {
        AppMethodBeat.i(125383);
        if (this.Hsm.stopped()) {
            this.Hsm.startTimer((long) this.Hsh);
        }
        AppMethodBeat.o(125383);
    }

    public final void fME() {
        AppMethodBeat.i(125384);
        if (this.Hsn.stopped()) {
            this.Hsn.startTimer((long) this.Hsi);
        }
        AppMethodBeat.o(125384);
    }

    public final void setNickName(String str) {
        String str2;
        AppMethodBeat.i(125385);
        if (this.HrT.HsD) {
            str2 = str + MMApplicationContext.getContext().getString(R.string.i1l);
        } else {
            str2 = str + MMApplicationContext.getContext().getString(R.string.i1m);
        }
        this.gvw.setText(str2);
        AppMethodBeat.o(125385);
    }

    public final void aUE(String str) {
        AppMethodBeat.i(125386);
        if (!Util.isNullOrNil(str)) {
            this.Hsq = new C1900b();
            if (this.HrT.kog == null || this.HrT.kog.equals("")) {
                this.Hsr = str;
            } else {
                this.Hsr = this.HrT.kog;
            }
            h.RTc.aX(this.Hsq);
        }
        AppMethodBeat.o(125386);
    }

    public final String fMF() {
        AppMethodBeat.i(125387);
        String str = "voip_cs_headImageUrl_" + this.HrT.HrM;
        AppMethodBeat.o(125387);
        return str;
    }

    public final String fMG() {
        AppMethodBeat.i(125388);
        String str = "voip_cs_nickname_" + this.HrT.HrM;
        AppMethodBeat.o(125388);
        return str;
    }

    private Point xl(boolean z) {
        AppMethodBeat.i(125389);
        int height = ((WindowManager) this.HrT.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
        Point point = new Point((int) (xg(!z) * ((float) height)), height);
        AppMethodBeat.o(125389);
        return point;
    }

    private static float xg(boolean z) {
        byte[] bArr;
        AppMethodBeat.i(125390);
        float f2 = 0.74766356f;
        if (z) {
            try {
                bArr = com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.field_capInfo;
            } catch (Exception e2) {
                Log.e("MicroMsg.voipcs.VoipCSViewManager", "update failed: " + e2.getMessage());
            }
        } else {
            bArr = com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.Hay;
        }
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            if (wrap.getInt() > 65535) {
                wrap.order(ByteOrder.LITTLE_ENDIAN);
            }
            wrap.getShort();
            wrap.getShort();
            float f3 = ((float) wrap.getInt()) / 100.0f;
            if (f3 != 0.0f) {
                f2 = f3;
            }
            Log.d("MicroMsg.voipcs.VoipCSViewManager", "use rate: %s, changed: %s", Float.valueOf(f2), Boolean.valueOf(z));
        }
        AppMethodBeat.o(125390);
        return f2;
    }

    public final void onClick(View view) {
        boolean z = false;
        AppMethodBeat.i(125391);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getId() == R.id.jay) {
            if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL < 2) {
                com.tencent.mm.plugin.voip_cs.c.c.fMt().dataType = 2;
            } else {
                com.tencent.mm.plugin.voip_cs.c.c.fMt().dataType = 4;
            }
            d fMt = com.tencent.mm.plugin.voip_cs.c.c.fMt();
            fMt.HqQ = 1;
            fMt.Hrl = 1;
            fMt.HqR = (int) (System.currentTimeMillis() / 1000);
            d fMt2 = com.tencent.mm.plugin.voip_cs.c.c.fMt();
            Log.d("MicroMsg.VoipCSReportHelper", "selfCancel");
            if (fMt2.Hri == 0) {
                fMt2.Hrd = 3;
                if (fMt2.Hrm == 0 && fMt2.Hry != 0) {
                    fMt2.Hrm = (long) (((int) (System.currentTimeMillis() / 1000)) - fMt2.Hry);
                }
            }
            com.tencent.mm.plugin.voip_cs.c.c.fMt().fMu();
            Log.d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
            aek(0);
        } else {
            int i2 = this.zSP.getVisibility() == 0 ? 8 : 0;
            this.zSP.setVisibility(i2);
            this.timeTV.setVisibility(i2);
            this.HrV.setVisibility(i2);
            aej(i2);
            if (i2 == 0) {
                z = true;
            }
            xD(z);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125391);
    }

    private void aej(int i2) {
        AppMethodBeat.i(125392);
        if (this.HrT.HsA == null || !this.HrT.HsA.equals("1")) {
            this.Hdl.setVisibility(8);
            AppMethodBeat.o(125392);
            return;
        }
        this.Hdl.setVisibility(i2);
        AppMethodBeat.o(125392);
    }

    public final void fMH() {
        AppMethodBeat.i(125393);
        Log.i("MicroMsg.voipcs.VoipCSViewManager", "start capture render");
        if (this.Hsc == null) {
            Log.i("MicroMsg.voipcs.VoipCSViewManager", "create capture View");
            this.Hsc = new ObservableTextureView(this.HrT);
            this.Hsc.setLayoutParams(new RelativeLayout.LayoutParams(1, 1));
            this.HrU.addView(this.Hsc, new RelativeLayout.LayoutParams(1, 1));
            this.Hsc.setVisibility(0);
        }
        if (this.Hsb == null) {
            Log.i("MicroMsg.voipcs.VoipCSViewManager", "create capture Render");
            this.Hsb = new com.tencent.mm.plugin.voip_cs.d.a();
            this.Hsb.a((com.tencent.mm.plugin.voip.video.camera.a.b) this, true);
            this.Hsb.a(this.Hsc);
            com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.zNX = this.Hsb.fLa();
            this.Hsb.fLb();
            this.Hsb.fMQ();
            Log.i("MicroMsg.voipcs.VoipCSViewManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", Boolean.valueOf(this.Hsb.fLp()), Boolean.valueOf(this.Hsb.fKZ()));
        }
        AppMethodBeat.o(125393);
    }

    public final void fMI() {
        AppMethodBeat.i(125394);
        Log.i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
        if (this.Hsc != null) {
            this.HrU.removeView(this.Hsc);
            this.Hsc = null;
        }
        if (this.Hsb != null) {
            this.Hsb.eoc();
            this.Hsb = null;
        }
        AppMethodBeat.o(125394);
    }

    private void fMJ() {
        AppMethodBeat.i(125395);
        Log.i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
        this.hAk.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.voip_cs.c.a.b.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(125375);
                Log.i("MicroMsg.voipcs.VoipCSViewManager", "dismiss button");
                if (b.this.HrT.isFinishing()) {
                    AppMethodBeat.o(125375);
                    return;
                }
                b.this.zSP.setVisibility(8);
                b.this.timeTV.setVisibility(8);
                b.this.HrV.setVisibility(8);
                b.n(b.this);
                b.o(b.this);
                AppMethodBeat.o(125375);
            }
        }, 10000);
        AppMethodBeat.o(125395);
    }

    private void xD(boolean z) {
        AppMethodBeat.i(125396);
        if (Build.MANUFACTURER.equalsIgnoreCase("sony")) {
            Log.i("MicroMsg.voipcs.VoipCSViewManager", "sony is not compatible,so we return.");
            AppMethodBeat.o(125396);
        } else if (!z) {
            this.HrT.getWindow().setFlags(1024, 1024);
            AppMethodBeat.o(125396);
        } else {
            this.HrT.getWindow().clearFlags(1024);
            AppMethodBeat.o(125396);
        }
    }

    public final void dZP() {
        AppMethodBeat.i(125397);
        this.Hsm.stopTimer();
        this.Hsn.stopTimer();
        this.Hsj.fJB();
        this.HrX.setVisibility(8);
        this.HrW.setText(R.string.i2d);
        this.HrV.setText(R.string.i22);
        aej(0);
        this.zUm.setOnClickListener(this);
        if (this.HrT.HsB != null && this.HrT.HsB.equals("1")) {
            this.Hfo.setVisibility(0);
            this.HdG = true;
            Point xl = xl(this.HdG);
            ((MovableVideoView) this.Hfo).jF(xl.x, xl.y);
            fMK();
        }
        fMJ();
        this.Hsf = true;
        if (this.dfh == null) {
            this.dfh = new Timer("voip_cs_talking_time");
        }
        if (this.Hsd) {
            AppMethodBeat.o(125397);
            return;
        }
        if (this.Hse == -1) {
            this.Hse = Util.nowSecond();
        }
        this.Hsd = true;
        this.dfh.schedule(new TimerTask() {
            /* class com.tencent.mm.plugin.voip_cs.c.a.b.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(125377);
                b.this.hAk.post(new Runnable() {
                    /* class com.tencent.mm.plugin.voip_cs.c.a.b.AnonymousClass7.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(125376);
                        b.this.timeTV.setText(b.AF(Util.secondsToNow(b.this.Hse)));
                        AppMethodBeat.o(125376);
                    }
                });
                AppMethodBeat.o(125377);
            }
        }, 1000, 1000);
        r.fHo().fHp();
        r.fHo().a(this);
        AppMethodBeat.o(125397);
    }

    public static Drawable aUF(String str) {
        AppMethodBeat.i(125398);
        try {
            Drawable createFromStream = Drawable.createFromStream((InputStream) new URL(str).getContent(), "urlDrawable");
            AppMethodBeat.o(125398);
            return createFromStream;
        } catch (Exception e2) {
            Log.e("MicroMsg.voipcs.VoipCSViewManager", "parse Drawable faill!");
            AppMethodBeat.o(125398);
            return null;
        }
    }

    protected static String AF(long j2) {
        AppMethodBeat.i(125399);
        String format = String.format("%02d:%02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60));
        AppMethodBeat.o(125399);
        return format;
    }

    public final void aek(int i2) {
        AppMethodBeat.i(125400);
        Log.i("MicroMsg.voipcs.VoipCSViewManager", "onRefreshed for action:".concat(String.valueOf(i2)));
        if (this.dfh != null) {
            this.dfh.cancel();
            this.dfh = null;
        }
        if (!this.Hsm.stopped()) {
            this.Hsm.stopTimer();
        }
        if (!this.Hsn.stopped()) {
            this.Hsn.stopTimer();
        }
        this.Hsj.fJB();
        this.Hsd = false;
        this.HrY.setVisibility(0);
        this.HrY.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.HrY.setBackgroundResource(R.drawable.cps);
        this.HrY.setCompoundDrawables(null, null, null, null);
        this.HrY.setCompoundDrawablePadding(0);
        this.HrY.setText(ael(i2));
        if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL == 2) {
            h.RTc.aX(new com.tencent.f.i.h() {
                /* class com.tencent.mm.plugin.voip_cs.c.a.b.AnonymousClass8 */

                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                public final String getKey() {
                    return "VoipCS_play_end_sound";
                }

                public final void run() {
                    AppMethodBeat.i(125378);
                    a fMB = a.fMB();
                    if (fMB.qtg != null) {
                        fMB.qtg.g(R.raw.close_lower_volume, false, 0);
                    }
                    AppMethodBeat.o(125378);
                }
            });
        }
        this.hAk.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.voip_cs.c.a.b.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(125379);
                b.this.HrT.finish();
                AppMethodBeat.o(125379);
            }
        }, 2000);
        AppMethodBeat.o(125400);
    }

    private static int ael(int i2) {
        AppMethodBeat.i(125401);
        if (i2 == 1) {
            AppMethodBeat.o(125401);
            return R.string.i1r;
        } else if (i2 == 0) {
            AppMethodBeat.o(125401);
            return R.string.i1y;
        } else if (i2 == -1 || i2 == 5) {
            AppMethodBeat.o(125401);
            return R.string.i29;
        } else if (i2 == 403 || i2 == 404) {
            AppMethodBeat.o(125401);
            return R.string.i2g;
        } else if (i2 == 6) {
            AppMethodBeat.o(125401);
            return R.string.i2b;
        } else if (i2 == 1001) {
            AppMethodBeat.o(125401);
            return R.string.i28;
        } else if (i2 == 10) {
            AppMethodBeat.o(125401);
            return R.string.i1x;
        } else if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL < 2) {
            AppMethodBeat.o(125401);
            return R.string.i1p;
        } else {
            AppMethodBeat.o(125401);
            return R.string.i1y;
        }
    }

    @Override // com.tencent.mm.plugin.voip.model.r.a
    public final void ql(boolean z) {
        AppMethodBeat.i(125402);
        this.HrY.setVisibility(0);
        this.HrY.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.HrY.setBackgroundResource(R.drawable.cps);
        this.HrY.setCompoundDrawables(null, null, null, null);
        this.HrY.setCompoundDrawablePadding(0);
        this.HrY.setText(ael(1001));
        AppMethodBeat.o(125402);
    }

    @Override // com.tencent.mm.plugin.voip.model.r.a
    public final void dZQ() {
    }

    @Override // com.tencent.mm.plugin.voip.model.r.a
    public final void dZR() {
        AppMethodBeat.i(125403);
        this.HrY.setVisibility(8);
        AppMethodBeat.o(125403);
    }

    class a {

        /* renamed from: h  reason: collision with root package name */
        int f1526h;
        int w;
        int[] zLY;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void fs(int i2, int i3) {
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void a(byte[] bArr, long j2, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(125404);
        Log.d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.dLD);
        if (this.dLD) {
            AppMethodBeat.o(125404);
            return;
        }
        if (this.Hso.zLY == null) {
            this.Hso.w = i2;
            this.Hso.f1526h = i3;
            this.Hso.zLY = new int[(this.Hso.w * this.Hso.f1526h)];
        }
        int i6 = this.Hsb.fLp() ? OpenGlRender.FLAG_Mirror : 0;
        int i7 = this.Hsb.fKZ() ? OpenGlRender.FLAG_Angle270 : OpenGlRender.FLAG_Angle90;
        if (this.Hsf) {
            Log.d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = ".concat(String.valueOf(com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.videoEncodeToSend(bArr, bArr.length, i2, i3, i4 + i5))));
            com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.Hcg++;
        }
        com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.videoEncodeToLocal(bArr, (int) j2, i2, i3, i4 + i5, 0, 75, this.Hso.zLY);
        if (OpenGlRender.His != 1) {
            if (OpenGlRender.His == 2) {
                if (this.HdG) {
                    this.Hfp.a(bArr, i2, i3, OpenGlRender.FLAG_NV21 + i6 + i7, false, 3);
                    AppMethodBeat.o(125404);
                    return;
                }
                this.Hfq.a(bArr, i2, i3, OpenGlRender.FLAG_NV21 + i6 + i7, false, 3);
            }
            AppMethodBeat.o(125404);
        } else if (this.HdG) {
            this.Hfp.a(this.Hso.zLY, i2, i3, OpenGlRender.FLAG_RGBAClip + i6 + i7, false);
            AppMethodBeat.o(125404);
        } else {
            this.Hfq.a(this.Hso.zLY, i2, i3, OpenGlRender.FLAG_RGBAClip + i6 + i7, false);
            AppMethodBeat.o(125404);
        }
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void cza() {
        AppMethodBeat.i(125405);
        Log.e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
        AppMethodBeat.o(125405);
    }

    public final void fMK() {
        AppMethodBeat.i(125406);
        fML();
        this.Hsp = new c();
        h.RTc.aX(this.Hsp);
        Log.d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
        AppMethodBeat.o(125406);
    }

    public final void fML() {
        AppMethodBeat.i(125407);
        if (this.Hsp != null) {
            Log.d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
            this.Hsp.GWY = true;
            this.Hsp.cancel();
            this.Hsp = null;
        }
        AppMethodBeat.o(125407);
    }

    /* access modifiers changed from: package-private */
    public class c extends com.tencent.f.i.b {
        boolean GWY = false;
        byte[] GWZ = null;

        c() {
        }

        public final void run() {
            AppMethodBeat.i(125381);
            while (!this.GWY && !b.this.dLD) {
                if (this.GWZ == null) {
                    this.GWZ = new byte[(((com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.defaultWidth * com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.defaultHeight) * 3) / 2)];
                }
                if (com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.videoDecode(this.GWZ) == 1) {
                    int i2 = com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.field_remoteImgWidth;
                    int i3 = com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.field_remoteImgHeight;
                    if (OpenGlRender.His == 1) {
                        if (b.this.HdG) {
                            b.this.Hfq.a(com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.HbF, i2, i3, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
                        } else {
                            b.this.Hfp.a(com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.HbF, i2, i3, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
                        }
                    } else if (b.this.HdG) {
                        b.this.Hfq.a(this.GWZ, i2, i3, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
                    } else {
                        b.this.Hfp.a(this.GWZ, i2, i3, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e2) {
                    Log.printErrStackTrace("MicroMsg.voipcs.VoipCSViewManager", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(125381);
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "VOIPCS_VideoDecode";
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.voip_cs.c.a.b$b  reason: collision with other inner class name */
    public class C1900b extends com.tencent.f.i.b {
        C1900b() {
        }

        public final void run() {
            AppMethodBeat.i(125380);
            b.this.Hss = b.aUF(b.this.Hsr);
            Message message = new Message();
            message.what = 12;
            b.this.Hsa.sendMessage(message);
            b.this.Hsq.cancel();
            AppMethodBeat.o(125380);
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "VOIPCS_netPic";
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
