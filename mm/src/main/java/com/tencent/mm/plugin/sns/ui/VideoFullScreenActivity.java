package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;

@a(32)
public class VideoFullScreenActivity extends MMActivity implements com.tencent.mm.plugin.sns.ui.d.a {
    private String DYR;
    private SightVideoFullScreenView ESg;
    private LongVideoFullScreenView ESh;
    private g ESi;
    public aj ESj;
    private boolean ESk;
    private boolean EeY;
    private int EgO;
    private String Esm;
    private int Esn;
    private int Eso;
    private String Esp;
    private int Esq;
    private FrameLayout ExV;
    private long dUy = 0;
    private boolean gVd;
    private boolean isWaiting;
    private int jqs;
    private int mEX;
    private int mEY;
    private long startTime = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(203847);
        super.onCreate(bundle);
        this.startTime = System.currentTimeMillis();
        ap.aL(this);
        this.mController.hideTitleView();
        try {
            this.jqs = getIntent().getIntExtra("KComponentVideoType", 0);
            this.Esm = getIntent().getStringExtra("KComponentCid");
            this.Esn = getIntent().getIntExtra("KComponentCurrentTime", 0);
            this.Eso = getIntent().getIntExtra("KComponentTotalTime", 0);
            this.EeY = getIntent().getBooleanExtra("KComponentVoiceType", false);
            this.gVd = getIntent().getBooleanExtra("KComponentProgressType", false);
            this.DYR = getIntent().getStringExtra("KComponentVideoSightThumbUrl");
            this.Esp = getIntent().getStringExtra("KComponentStreamVideoUrlPath");
            this.isWaiting = getIntent().getBooleanExtra("KComponentIsWaiting", false);
            this.EgO = getIntent().getIntExtra("KComponentSeekTimeDueWaiting", 0);
            this.Esq = getIntent().getIntExtra("KComponentKComponentCacheTime", 0);
            this.ESk = getIntent().getBooleanExtra("KComponentForceLandMode", false);
            Log.i("VideoFullScreenActivity", "videoType = " + this.jqs + ", cid = " + this.Esm + ", currPosSec = " + this.Esn + " , videoDurationSec = " + this.Eso + ", bNoVoice = " + this.EeY + ", isPlaying = " + this.gVd + ", streamVideoUrlPath = " + this.Esp + ", isWaiting = " + this.isWaiting + ", seekTime = " + this.EgO + ", forceLandscapeMode=" + this.ESk);
        } catch (Throwable th) {
            Log.e("VideoFullScreenActivity", th.toString());
        }
        if (this.jqs == 1 && this.ESk) {
            setRequestedOrientation(0);
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(203846);
                    VideoFullScreenActivity.this.setRequestedOrientation(4);
                    AppMethodBeat.o(203846);
                }
            }, 5000);
        }
        try {
            int[] ha = ap.ha(this);
            this.mEX = ha[0];
            this.mEY = ha[1];
            if (ao.aQ(this) && getResources().getConfiguration().orientation == 1) {
                this.mEY -= ao.aP(this);
            } else if (ao.aQ(this) && getResources().getConfiguration().orientation == 2) {
                this.mEX -= ao.aP(this);
            }
            Log.i("VideoFullScreenActivity", "screenHeight = " + this.mEY + ", screenWidth = " + this.mEX);
        } catch (Throwable th2) {
            Log.e("VideoFullScreenActivity", th2.toString());
        }
        if (this.jqs == 0) {
            try {
                this.ExV = (FrameLayout) findViewById(R.id.h8v);
                this.ESg = new SightVideoFullScreenView(this);
                this.ExV.addView(this.ESg);
                SightVideoFullScreenView sightVideoFullScreenView = this.ESg;
                int i2 = this.mEX;
                int i3 = this.mEY;
                if (i3 >= i2) {
                    try {
                        sightVideoFullScreenView.mEX = i2;
                        sightVideoFullScreenView.mEY = i3;
                    } catch (Throwable th3) {
                        Log.e("SightVideoFullScreenView", th3.toString());
                    }
                } else {
                    sightVideoFullScreenView.mEY = i2;
                    sightVideoFullScreenView.mEX = i3;
                }
                sightVideoFullScreenView.length = com.tencent.mm.cb.a.fromDPToPix(sightVideoFullScreenView.mContext, 32);
                SightVideoFullScreenView sightVideoFullScreenView2 = this.ESg;
                int i4 = this.jqs;
                String str = this.Esm;
                int i5 = this.Esn;
                int i6 = this.Eso;
                boolean z = this.EeY;
                boolean z2 = this.gVd;
                String str2 = this.DYR;
                String str3 = this.Esp;
                try {
                    sightVideoFullScreenView2.isInit = true;
                    sightVideoFullScreenView2.isFirst = true;
                    sightVideoFullScreenView2.jqs = i4;
                    sightVideoFullScreenView2.Esm = str;
                    sightVideoFullScreenView2.Esn = i5;
                    sightVideoFullScreenView2.Eso = i6;
                    sightVideoFullScreenView2.EeY = z;
                    sightVideoFullScreenView2.gVd = z2;
                    sightVideoFullScreenView2.DYR = str2;
                    sightVideoFullScreenView2.Esp = str3;
                } catch (Throwable th4) {
                    Log.e("SightVideoFullScreenView", th4.toString());
                }
                SightVideoFullScreenView sightVideoFullScreenView3 = this.ESg;
                try {
                    sightVideoFullScreenView3.contentView = LayoutInflater.from(sightVideoFullScreenView3.mContext).inflate(R.layout.bt3, (ViewGroup) sightVideoFullScreenView3, true);
                    sightVideoFullScreenView3.Esi = (FrameLayout) sightVideoFullScreenView3.contentView.findViewById(R.id.j3r);
                    sightVideoFullScreenView3.Esj = sightVideoFullScreenView3.contentView.findViewById(R.id.aa4);
                    sightVideoFullScreenView3.Esk = sightVideoFullScreenView3.contentView.findViewById(R.id.dta);
                    sightVideoFullScreenView3.EeP = (VideoPlayerSeekBar) sightVideoFullScreenView3.contentView.findViewById(R.id.gl_);
                    sightVideoFullScreenView3.Ewn = new OfflineVideoView(sightVideoFullScreenView3.mContext);
                    sightVideoFullScreenView3.Ewn.setClickable(true);
                    sightVideoFullScreenView3.Ewn.setOnTouchListener(sightVideoFullScreenView3);
                    sightVideoFullScreenView3.Esi.addView(sightVideoFullScreenView3.Ewn);
                    sightVideoFullScreenView3.EeP.setVisibility(0);
                    sightVideoFullScreenView3.EeP.setOnPlayButtonClickListener(sightVideoFullScreenView3.Efl);
                    sightVideoFullScreenView3.EeP.setIplaySeekCallback(sightVideoFullScreenView3.tni);
                    sightVideoFullScreenView3.Egd = (ImageView) sightVideoFullScreenView3.findViewById(R.id.hw7);
                    sightVideoFullScreenView3.Egd.setVisibility(0);
                    sightVideoFullScreenView3.Egd.setOnClickListener(sightVideoFullScreenView3);
                    sightVideoFullScreenView3.EeQ = (ImageView) sightVideoFullScreenView3.findViewById(R.id.hw8);
                    sightVideoFullScreenView3.EeQ.setVisibility(0);
                    sightVideoFullScreenView3.EeQ.setOnClickListener(sightVideoFullScreenView3);
                    sightVideoFullScreenView3.Ege = sightVideoFullScreenView3.contentView.findViewById(R.id.g9_);
                    sightVideoFullScreenView3.Ege.setVisibility(8);
                    if (sightVideoFullScreenView3.mContext.getResources().getConfiguration().orientation == 2) {
                        Log.i("SightVideoFullScreenView", "ORIENTATION_LANDSCAPE");
                        sightVideoFullScreenView3.fda();
                    } else if (sightVideoFullScreenView3.mContext.getResources().getConfiguration().orientation == 1) {
                        Log.i("SightVideoFullScreenView", "ORIENTATION_PORTRAIT");
                        sightVideoFullScreenView3.fdb();
                    }
                } catch (Throwable th5) {
                    Log.e("SightVideoFullScreenView", th5.toString());
                }
                try {
                    if (sightVideoFullScreenView3.EeP.getVideoTotalTime() != sightVideoFullScreenView3.Eso / 1000) {
                        sightVideoFullScreenView3.EeP.setVideoTotalTime(sightVideoFullScreenView3.Eso / 1000);
                    }
                    sightVideoFullScreenView3.EeP.seek(sightVideoFullScreenView3.Esn / 1000);
                    sightVideoFullScreenView3.vh(sightVideoFullScreenView3.gVd);
                } catch (Throwable th6) {
                    Log.e("SightVideoFullScreenView", th6.toString());
                }
                try {
                    sightVideoFullScreenView3.Ewn.setVideoCallback(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x02fe: INVOKE  
                          (wrap: com.tencent.mm.plugin.sns.ui.OfflineVideoView : 0x02f7: IGET  (r0v126 com.tencent.mm.plugin.sns.ui.OfflineVideoView) = (r1v20 'sightVideoFullScreenView3' com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView) com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView.Ewn com.tencent.mm.plugin.sns.ui.OfflineVideoView)
                          (wrap: com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView$2 : 0x02fb: CONSTRUCTOR  (r2v36 com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView$2) = (r1v20 'sightVideoFullScreenView3' com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView) call: com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView.2.<init>(com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.tencent.mm.plugin.sns.ui.OfflineVideoView.setVideoCallback(com.tencent.mm.plugin.sns.ui.OfflineVideoView$a):void in method: com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity.onCreate(android.os.Bundle):void, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x02fb: CONSTRUCTOR  (r2v36 com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView$2) = (r1v20 'sightVideoFullScreenView3' com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView) call: com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView.2.<init>(com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity.onCreate(android.os.Bundle):void, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 29 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sns.ui.SightVideoFullScreenView, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 35 more
                        */
                    /*
                    // Method dump skipped, instructions count: 1569
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity.onCreate(android.os.Bundle):void");
                }

                public static ah fcZ() {
                    AppMethodBeat.i(203848);
                    if (ae.DJT != null) {
                        ah ahVar = ae.DJT;
                        AppMethodBeat.o(203848);
                        return ahVar;
                    }
                    ah ahVar2 = new ah();
                    AppMethodBeat.o(203848);
                    return ahVar2;
                }

                private void a(aj ajVar) {
                    AppMethodBeat.i(203849);
                    if (!(ajVar == null || this.ExV == null || this.ESi != null)) {
                        if (Util.isNullOrNil(ajVar.desc) || ajVar.DZH == null) {
                            AppMethodBeat.o(203849);
                            return;
                        }
                        this.ESi = new g(this, ajVar, this.ExV);
                        if (getResources().getConfiguration().orientation == 1) {
                            this.ESi.fdb();
                        } else if (getResources().getConfiguration().orientation == 2) {
                            this.ESi.fda();
                        }
                        vA(false);
                    }
                    AppMethodBeat.o(203849);
                }

                private void vA(boolean z) {
                    AppMethodBeat.i(203850);
                    if (this.ESi != null) {
                        Log.d("VideoFullScreenActivity", "hideFloatBarView");
                        this.ESi.vf(z);
                    }
                    AppMethodBeat.o(203850);
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                public void onStart() {
                    AppMethodBeat.i(203851);
                    super.onStart();
                    try {
                        ap.aL(this);
                        if (this.jqs == 0) {
                            SightVideoFullScreenView sightVideoFullScreenView = this.ESg;
                            try {
                                if (!sightVideoFullScreenView.isFirst && !sightVideoFullScreenView.Ewn.isPlaying() && sightVideoFullScreenView.Est) {
                                    sightVideoFullScreenView.fgL();
                                    sightVideoFullScreenView.Est = false;
                                }
                                sightVideoFullScreenView.isFirst = false;
                                AppMethodBeat.o(203851);
                            } catch (Throwable th) {
                                Log.e("SightVideoFullScreenView", th.toString());
                                AppMethodBeat.o(203851);
                            }
                        } else {
                            if (this.jqs == 1) {
                                LongVideoFullScreenView longVideoFullScreenView = this.ESh;
                                try {
                                    if (!longVideoFullScreenView.isFirst && !longVideoFullScreenView.Esl.isPlaying() && longVideoFullScreenView.Est) {
                                        longVideoFullScreenView.czw();
                                        longVideoFullScreenView.Est = false;
                                    }
                                    longVideoFullScreenView.isFirst = false;
                                    AppMethodBeat.o(203851);
                                    return;
                                } catch (Throwable th2) {
                                    Log.e("LongVideoFullScreenView", th2.toString());
                                }
                            }
                            AppMethodBeat.o(203851);
                        }
                    } catch (Throwable th3) {
                        Log.e("VideoFullScreenActivity", th3.toString());
                        AppMethodBeat.o(203851);
                    }
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                public void onResume() {
                    AppMethodBeat.i(203852);
                    super.onResume();
                    try {
                        this.startTime = System.currentTimeMillis();
                        ap.aL(this);
                        if (this.jqs == 0) {
                            this.ESg.DXw = true;
                            AppMethodBeat.o(203852);
                            return;
                        }
                        if (this.jqs == 1) {
                            this.ESh.DXw = true;
                        }
                        AppMethodBeat.o(203852);
                    } catch (Throwable th) {
                        Log.e("VideoFullScreenActivity", th.toString());
                        AppMethodBeat.o(203852);
                    }
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                public void onPause() {
                    AppMethodBeat.i(203853);
                    super.onPause();
                    try {
                        this.dUy += System.currentTimeMillis() - this.startTime;
                        if (this.jqs == 0) {
                            SightVideoFullScreenView sightVideoFullScreenView = this.ESg;
                            try {
                                sightVideoFullScreenView.DXw = false;
                                MMHandlerThread.removeRunnable(sightVideoFullScreenView.EeU);
                                MMHandlerThread.removeRunnable(sightVideoFullScreenView.Egg);
                                AppMethodBeat.o(203853);
                            } catch (Throwable th) {
                                Log.e("SightVideoFullScreenView", th.toString());
                                AppMethodBeat.o(203853);
                            }
                        } else {
                            if (this.jqs == 1) {
                                LongVideoFullScreenView longVideoFullScreenView = this.ESh;
                                try {
                                    longVideoFullScreenView.DXw = false;
                                    MMHandlerThread.removeRunnable(longVideoFullScreenView.EeU);
                                    MMHandlerThread.removeRunnable(longVideoFullScreenView.Egg);
                                    AppMethodBeat.o(203853);
                                    return;
                                } catch (Throwable th2) {
                                    Log.e("LongVideoFullScreenView", th2.toString());
                                }
                            }
                            AppMethodBeat.o(203853);
                        }
                    } catch (Throwable th3) {
                        Log.e("VideoFullScreenActivity", th3.toString());
                        AppMethodBeat.o(203853);
                    }
                }

                @Override // com.tencent.mm.ui.MMActivity
                public int getLayoutId() {
                    return R.layout.c0;
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                public void onStop() {
                    AppMethodBeat.i(203854);
                    super.onStop();
                    try {
                        if (this.jqs == 0) {
                            SightVideoFullScreenView sightVideoFullScreenView = this.ESg;
                            try {
                                sightVideoFullScreenView.isFirst = false;
                                if (sightVideoFullScreenView.Ewn.isPlaying()) {
                                    sightVideoFullScreenView.fgM();
                                    sightVideoFullScreenView.Est = true;
                                }
                                AppMethodBeat.o(203854);
                            } catch (Throwable th) {
                                Log.e("SightVideoFullScreenView", th.toString());
                                AppMethodBeat.o(203854);
                            }
                        } else {
                            if (this.jqs == 1) {
                                LongVideoFullScreenView longVideoFullScreenView = this.ESh;
                                try {
                                    longVideoFullScreenView.isFirst = false;
                                    if (longVideoFullScreenView.Esl.isPlaying()) {
                                        longVideoFullScreenView.cXa();
                                        longVideoFullScreenView.Est = true;
                                    }
                                    AppMethodBeat.o(203854);
                                    return;
                                } catch (Throwable th2) {
                                    Log.e("LongVideoFullScreenView", th2.toString());
                                }
                            }
                            AppMethodBeat.o(203854);
                        }
                    } catch (Throwable th3) {
                        Log.e("VideoFullScreenActivity", th3.toString());
                        AppMethodBeat.o(203854);
                    }
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                public void onDestroy() {
                    AppMethodBeat.i(203855);
                    try {
                        ae.DJT = null;
                        if (this.jqs == 0) {
                            SightVideoFullScreenView sightVideoFullScreenView = this.ESg;
                            try {
                                MMHandlerThread.removeRunnable(sightVideoFullScreenView.EeU);
                                MMHandlerThread.removeRunnable(sightVideoFullScreenView.Egg);
                                sightVideoFullScreenView.Ewn.onDestroy();
                            } catch (Throwable th) {
                                Log.e("SightVideoFullScreenView", th.toString());
                            }
                            ah.b.Egv = null;
                        } else if (this.jqs == 1) {
                            LongVideoFullScreenView longVideoFullScreenView = this.ESh;
                            try {
                                MMHandlerThread.removeRunnable(longVideoFullScreenView.EeU);
                                MMHandlerThread.removeRunnable(longVideoFullScreenView.Egg);
                                longVideoFullScreenView.Esl.onUIDestroy();
                            } catch (Throwable th2) {
                                Log.e("LongVideoFullScreenView", th2.toString());
                            }
                            al.a.EgT = null;
                        }
                    } catch (Throwable th3) {
                        Log.e("VideoFullScreenActivity", th3.toString());
                    }
                    super.onDestroy();
                    AppMethodBeat.o(203855);
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
                public void finish() {
                    AppMethodBeat.i(203856);
                    Intent intent = null;
                    try {
                        if (this.jqs == 0) {
                            intent = this.ESg.fgN();
                        } else if (this.jqs == 1) {
                            intent = this.ESh.ffW();
                        }
                        if (intent != null) {
                            this.dUy += System.currentTimeMillis() - this.startTime;
                            intent.putExtra("KComponentFullScreenStayTime", this.dUy);
                            if (this.ESi != null) {
                                this.ESi.eXd();
                                intent.putExtra("KComponentFullVideoFloatBarReportInfo", this.ESi.fdc());
                            }
                        }
                        setResult(1000, intent);
                    } catch (Throwable th) {
                        Log.e("VideoFullScreenActivity", th.toString());
                    }
                    super.finish();
                    AppMethodBeat.o(203856);
                }

                @Override // com.tencent.mm.plugin.sns.ui.d.a
                public final void vB(boolean z) {
                    AppMethodBeat.i(203857);
                    Log.i("VideoFullScreenActivity", "progressBarStatus visiblity = ".concat(String.valueOf(z)));
                    if (z) {
                        vA(true);
                        AppMethodBeat.o(203857);
                        return;
                    }
                    if (this.ESi != null) {
                        Log.d("VideoFullScreenActivity", "showFloatBarView");
                        this.ESi.fcY();
                    }
                    AppMethodBeat.o(203857);
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                public void onConfigurationChanged(Configuration configuration) {
                    AppMethodBeat.i(203858);
                    super.onConfigurationChanged(configuration);
                    try {
                        if (configuration.orientation == 2) {
                            Log.i("VideoFullScreenActivity", "ORIENTATION_LANDSCAPE");
                            if (this.ESi != null) {
                                this.ESi.fda();
                                AppMethodBeat.o(203858);
                                return;
                            }
                        } else if (configuration.orientation == 1) {
                            Log.i("VideoFullScreenActivity", "ORIENTATION_PORTRAIT");
                            if (this.ESi != null) {
                                this.ESi.fdb();
                            }
                        }
                        AppMethodBeat.o(203858);
                    } catch (Throwable th) {
                        Log.e("VideoFullScreenActivity", th.toString());
                        AppMethodBeat.o(203858);
                    }
                }

                @Override // com.tencent.mm.ui.MMActivity
                public void setMMOrientation() {
                }

                @Override // com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
                public void onCancel() {
                    AppMethodBeat.i(203859);
                    super.onCancel();
                    setRequestedOrientation(4);
                    AppMethodBeat.o(203859);
                }
            }
