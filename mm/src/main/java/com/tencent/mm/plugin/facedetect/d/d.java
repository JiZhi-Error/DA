package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.facedetect.d.a;
import com.tencent.mm.plugin.facedetect.d.b;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.views.FaceNumberView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class d implements b {
    boolean idt;
    private View qXq;
    private a.b sRQ;
    boolean sSA;
    private Animation sSB;
    private Animation sSC;
    private AnimationSet sSD;
    private Animation sSE;
    final Object sSF;
    boolean sSG;
    b.a sSH;
    MMHandler sSI;
    private CountDownTimer sSJ;
    Runnable sSK;
    boolean sSa;
    private View sSc;
    private String sSo;
    private int sSp;
    a sSq;
    String[] sSr;
    int sSs;
    int sSt;
    private FaceNumberView sSu;
    private long sSv;
    private long sSw;
    boolean sSx;
    boolean sSy;
    boolean sSz;

    public d(String str) {
        AppMethodBeat.i(103840);
        this.sSo = null;
        this.sSp = 0;
        this.sSq = null;
        this.sSr = null;
        this.sSs = 0;
        this.sSt = 0;
        this.qXq = null;
        this.sSu = null;
        this.sSa = false;
        this.sSv = -1;
        this.sSw = -1;
        this.sSx = false;
        this.sSy = false;
        this.sSz = false;
        this.sSA = false;
        this.sSF = new Object();
        this.idt = false;
        this.sSG = false;
        this.sSH = null;
        this.sSI = new MMHandler(Looper.getMainLooper()) {
            /* class com.tencent.mm.plugin.facedetect.d.d.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(103828);
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        Log.i("MicroMsg.NumberFaceMotion", "hy: refresh number");
                        d.this.cTy();
                        break;
                }
                AppMethodBeat.o(103828);
            }
        };
        this.sSJ = new CountDownTimer() {
            /* class com.tencent.mm.plugin.facedetect.d.d.AnonymousClass2 */

            public final void onTick(long j2) {
                AppMethodBeat.i(103829);
                Log.i("MicroMsg.NumberFaceMotion", "hy: on ticked");
                if (d.this.idt) {
                    Log.w("MicroMsg.NumberFaceMotion", "hy: isEnd. trigger cancel");
                    cancel();
                    AppMethodBeat.o(103829);
                } else if (d.this.sSy) {
                    Log.i("MicroMsg.NumberFaceMotion", "hy: suspend.");
                    AppMethodBeat.o(103829);
                } else {
                    Log.i("MicroMsg.NumberFaceMotion", "hy: mCurrentShowedIndexInItem: %d, mItemDatas[mCurrentGroupDataIndex].length() - 1: %d, mCurrentGroupDataIndex: %d, mItemDatas.length - 1 : %d", Integer.valueOf(d.this.sSt), Integer.valueOf(d.this.sSr[d.this.sSs].length() - 1), Integer.valueOf(d.this.sSs), Integer.valueOf(d.this.sSr.length - 1));
                    if (d.this.sSt < d.this.sSr[d.this.sSs].length() - 1) {
                        d.this.sSt++;
                        d.this.sSI.sendEmptyMessage(0);
                        AppMethodBeat.o(103829);
                        return;
                    }
                    Log.i("MicroMsg.NumberFaceMotion", "hy: last number in group");
                    MMHandlerThread.postToMainThreadDelayed(d.this.sSK, 1500);
                    d.this.idt = true;
                    cancel();
                    d.this.idt = true;
                    AppMethodBeat.o(103829);
                }
            }

            public final void onFinish() {
                AppMethodBeat.i(103830);
                Log.i("MicroMsg.NumberFaceMotion", "hy: on count number finished");
                AppMethodBeat.o(103830);
            }
        };
        this.sSK = new Runnable() {
            /* class com.tencent.mm.plugin.facedetect.d.d.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(103831);
                synchronized (d.this.sSF) {
                    try {
                        if (d.this.sSs >= d.this.sSr.length - 1) {
                            Log.i("MicroMsg.NumberFaceMotion", "hy: already last. handle upper judge.");
                            d.this.sSa = true;
                            f fVar = f.INSTANCE;
                            byte[] cTo = d.this.sSq.cTo();
                            g gVar = fVar.sQN.sSO;
                            if (gVar.sQQ == null) {
                                Log.e("MicroMsg.FaceDetectNativeManager", "hy: set face data instance null!");
                            } else {
                                gVar.sQQ.engineSetVoiceData(cTo);
                            }
                        } else {
                            Log.i("MicroMsg.NumberFaceMotion", "hy: startShowNext");
                            d.this.sSs++;
                            d.this.sSt = -1;
                            d.this.mu(true);
                            d.this.cTy();
                        }
                    } finally {
                        AppMethodBeat.o(103831);
                    }
                }
            }
        };
        this.sRQ = new a.b() {
            /* class com.tencent.mm.plugin.facedetect.d.d.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.facedetect.d.a.b
            public final void cTp() {
                AppMethodBeat.i(103838);
                synchronized (d.this.sSF) {
                    try {
                        Log.i("MicroMsg.NumberFaceMotion", "hy: triggered read symbol");
                        if (!d.this.sSz && d.this.sSA) {
                            d.this.sSz = true;
                            d.b(d.this);
                        }
                    } finally {
                        AppMethodBeat.o(103838);
                    }
                }
            }

            @Override // com.tencent.mm.plugin.facedetect.d.a.b
            public final void onError(int i2) {
                AppMethodBeat.i(103839);
                synchronized (d.this.sSF) {
                    try {
                        Log.w("MicroMsg.NumberFaceMotion", "hy: on voice prepare error: %d", Integer.valueOf(i2));
                        switch (i2) {
                            case 11:
                                d.this.sSx = true;
                                break;
                            default:
                                d.this.sSG = true;
                                d.this.sSH = new b.a(MMApplicationContext.getResources().getString(R.string.flb));
                                break;
                        }
                    } finally {
                        AppMethodBeat.o(103839);
                    }
                }
            }
        };
        this.sSq = new a();
        this.sSq.sRQ = this.sRQ;
        this.sSB = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.eq);
        this.sSC = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.bc);
        this.sSE = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.br);
        this.sSE.setDuration(250);
        this.sSE.setFillAfter(true);
        this.sSo = str;
        this.sSp = this.sSo == null ? 0 : this.sSo.length();
        cTx();
        if (cTw()) {
            this.sSD = (AnimationSet) AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.bd);
        } else {
            this.sSD = (AnimationSet) AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.be);
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) MMApplicationContext.getResources().getDimensionPixelSize(R.dimen.a3v));
        translateAnimation.setDuration((long) MMApplicationContext.getContext().getResources().getInteger(R.integer.s));
        this.sSD.addAnimation(translateAnimation);
        Log.i("MicroMsg.NumberFaceMotion", "hy: starting read number: %s", this.sSo);
        AppMethodBeat.o(103840);
    }

    private boolean cTw() {
        return this.sSp >= 6;
    }

    private void cTx() {
        AppMethodBeat.i(103841);
        if (Util.isNullOrNil(this.sSo) || !cTw()) {
            this.sSr = new String[1];
            this.sSr[0] = this.sSo;
            AppMethodBeat.o(103841);
            return;
        }
        Log.i("MicroMsg.NumberFaceMotion", "hy: data too long. need to split into %d rounds", 2);
        this.sSr = new String[2];
        int i2 = this.sSp / 2;
        for (int i3 = 0; i3 < 2; i3++) {
            this.sSr[i3] = this.sSo.substring(i2 * i3, (i3 + 1) * i2);
        }
        AppMethodBeat.o(103841);
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final boolean cTq() {
        return this.sSa;
    }

    private TextView cTv() {
        AppMethodBeat.i(103842);
        if (this.qXq != null) {
            TextView textView = (TextView) this.qXq.findViewById(R.id.dph);
            AppMethodBeat.o(103842);
            return textView;
        }
        AppMethodBeat.o(103842);
        return null;
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final void setBusinessTip(String str) {
        AppMethodBeat.i(103843);
        ((TextView) this.sSc.findViewById(R.id.dph)).setText(str);
        AppMethodBeat.o(103843);
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        AppMethodBeat.i(103844);
        Log.d("MicroMsg.NumberFaceMotion", "hy: on number init motion");
        this.qXq = LayoutInflater.from(context).inflate(R.layout.a62, viewGroup2);
        this.sSu = (FaceNumberView) this.qXq.findViewById(R.id.c_r);
        this.sSc = LayoutInflater.from(context).inflate(R.layout.a60, viewGroup);
        fQ(this.sSr.length, -1);
        cTv().startAnimation(this.sSB);
        if (this.sSu != null) {
            this.sSu.setVisibility(0);
            this.sSu.startAnimation(this.sSB);
            this.sSs = 0;
            mu(false);
            this.sSt = -1;
            cTy();
            this.sSv = Util.currentTicks();
            this.sSw = Util.currentTicks();
            this.idt = false;
        }
        AppMethodBeat.o(103844);
    }

    private static String HO(int i2) {
        AppMethodBeat.i(103845);
        switch (i2) {
            case 1:
                String string = MMApplicationContext.getContext().getString(R.string.c63);
                AppMethodBeat.o(103845);
                return string;
            case 2:
                String string2 = MMApplicationContext.getContext().getString(R.string.c64);
                AppMethodBeat.o(103845);
                return string2;
            case 3:
                String string3 = MMApplicationContext.getContext().getString(R.string.c66);
                AppMethodBeat.o(103845);
                return string3;
            case 4:
                String string4 = MMApplicationContext.getContext().getString(R.string.c67);
                AppMethodBeat.o(103845);
                return string4;
            default:
                Log.e("MicroMsg.NumberFaceMotion", "hy: unknown length!!");
                AppMethodBeat.o(103845);
                return "";
        }
    }

    private void fQ(int i2, int i3) {
        String string;
        AppMethodBeat.i(103846);
        Log.i("MicroMsg.NumberFaceMotion", "alvinluo groupIndex: %d, itemDataLength: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        if (cTv() != null) {
            if (i2 == 1) {
                cTv().setText(MMApplicationContext.getContext().getString(R.string.c6_));
                AppMethodBeat.o(103846);
                return;
            }
            TextView cTv = cTv();
            if (i3 == -1) {
                string = MMApplicationContext.getContext().getString(R.string.c69, HP(i2));
            } else {
                string = MMApplicationContext.getContext().getString(R.string.c68, HO(this.sSs + 1));
            }
            cTv.setText(string);
            if (i3 > 0) {
                Log.i("MicroMsg.NumberFaceMotion", "alvinluo start %d group number", Integer.valueOf(i3 + 1));
                f.INSTANCE.cTa();
            }
        }
        AppMethodBeat.o(103846);
    }

    /* access modifiers changed from: package-private */
    public final void mu(boolean z) {
        AppMethodBeat.i(103847);
        if (this.sSu != null) {
            fQ(this.sSr.length, this.sSs);
            this.sSu.setNumberLengthAndInflate(this.sSr[this.sSs].length());
            this.sSA = false;
            if (z) {
                this.sSB.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.plugin.facedetect.d.d.AnonymousClass4 */

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(103833);
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.facedetect.d.d.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(103832);
                                d.a(d.this);
                                AppMethodBeat.o(103832);
                            }
                        }, 500);
                        AppMethodBeat.o(103833);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                if (this.qXq != null) {
                    this.qXq.startAnimation(this.sSB);
                    AppMethodBeat.o(103847);
                    return;
                }
            } else {
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.facedetect.d.d.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(103834);
                        d.a(d.this);
                        AppMethodBeat.o(103834);
                    }
                }, 500);
            }
        }
        AppMethodBeat.o(103847);
    }

    /* access modifiers changed from: package-private */
    public final void cTy() {
        AppMethodBeat.i(103848);
        if (this.sSu != null) {
            if (this.sSs >= 0) {
                this.sSu.arF(this.sSr[this.sSs].substring(0, this.sSt + 1));
                AppMethodBeat.o(103848);
                return;
            }
            this.sSu.arF(null);
        }
        AppMethodBeat.o(103848);
    }

    private static String HP(int i2) {
        AppMethodBeat.i(103849);
        switch (i2) {
            case 2:
                String string = MMApplicationContext.getContext().getString(R.string.c65);
                AppMethodBeat.o(103849);
                return string;
            default:
                String HO = HO(i2);
                AppMethodBeat.o(103849);
                return HO;
        }
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final boolean cTr() {
        this.sSy = true;
        return this.sSG;
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final boolean a(FaceCharacteristicsResult faceCharacteristicsResult) {
        this.sSy = true;
        return this.sSG;
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final boolean b(FaceCharacteristicsResult faceCharacteristicsResult) {
        this.sSy = false;
        return this.sSG;
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final void cTs() {
        AppMethodBeat.i(103850);
        this.idt = true;
        this.sSG = false;
        this.sSq.stopRecord();
        this.sSq.recycle();
        this.sSq.clearDiskCache();
        if (com.tencent.mm.plugin.facedetect.e.a.cTF().sUx && com.tencent.mm.plugin.facedetect.e.a.cTF().isStarted()) {
            this.sSq.c(com.tencent.mm.plugin.facedetect.e.a.cTF().cTG());
            if (this.sSa) {
                com.tencent.mm.plugin.facedetect.e.a.cTF().a((a.b) null);
            } else {
                com.tencent.mm.plugin.facedetect.e.a.cTF().cTH();
            }
        }
        this.sSJ.cancel();
        this.sSI.removeCallbacksAndMessages(null);
        if (this.sSu != null) {
            FaceNumberView faceNumberView = this.sSu;
            if (faceNumberView.sWz != null && faceNumberView.sWz.length > 0) {
                for (int i2 = 0; i2 < faceNumberView.sWz.length; i2++) {
                    faceNumberView.sWz[i2].cTT();
                }
            }
        }
        if (this.qXq != null) {
            this.sSa = false;
            this.sSv = -1;
            this.qXq = null;
            this.sSu = null;
        }
        AppMethodBeat.o(103850);
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final b.C1036b cTt() {
        AppMethodBeat.i(103851);
        b.C1036b bVar = new b.C1036b(90004, "user cancelled in processing");
        AppMethodBeat.o(103851);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final b.a cTu() {
        return this.sSH;
    }

    /* access modifiers changed from: package-private */
    public final void cTz() {
        AppMethodBeat.i(103852);
        this.sSJ.start();
        AppMethodBeat.o(103852);
    }

    static /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(103853);
        dVar.sSt = 0;
        synchronized (dVar.sSF) {
            try {
                dVar.sSz = false;
            } catch (Throwable th) {
                AppMethodBeat.o(103853);
                throw th;
            }
        }
        dVar.cTy();
        dVar.sSA = true;
        if (dVar.sSs == 0) {
            Log.i("MicroMsg.NumberFaceMotion", "hy: triggered start record");
            dVar.sSq.ap(new Runnable() {
                /* class com.tencent.mm.plugin.facedetect.d.d.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(103835);
                    if (com.tencent.mm.plugin.facedetect.e.a.cTF().sUx) {
                        d.this.sSq.b(com.tencent.mm.plugin.facedetect.e.a.cTF().cTG());
                        com.tencent.mm.plugin.facedetect.e.a.cTF().aai();
                    }
                    AppMethodBeat.o(103835);
                }
            });
            g gVar = f.INSTANCE.sQN.sSO;
            if (gVar.sQQ == null) {
                Log.e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
            } else {
                gVar.sQQ.engineStartRecord();
            }
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.facedetect.d.d.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(103836);
                synchronized (d.this.sSF) {
                    try {
                        if (!d.this.sSz) {
                            Log.w("MicroMsg.NumberFaceMotion", "hy: not triggered symbol. auto start");
                            d.this.sSz = true;
                            d.b(d.this);
                        } else {
                            Log.i("MicroMsg.NumberFaceMotion", "hy: user already start. do nothing");
                        }
                    } finally {
                        AppMethodBeat.o(103836);
                    }
                }
            }
        }, 2000);
        AppMethodBeat.o(103853);
    }

    static /* synthetic */ void b(d dVar) {
        AppMethodBeat.i(103854);
        long ticksToNow = Util.ticksToNow(dVar.sSw);
        Log.i("MicroMsg.NumberFaceMotion", "hy: delta after request");
        if (ticksToNow < 0) {
            Log.w("MicroMsg.NumberFaceMotion", "hy: too fast. regard as fake");
            AppMethodBeat.o(103854);
        } else if (ticksToNow < 1000) {
            Log.w("MicroMsg.NumberFaceMotion", "hy: too fast. wait until normal");
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.facedetect.d.d.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(103837);
                    d.this.cTz();
                    AppMethodBeat.o(103837);
                }
            }, 1000 - ticksToNow);
            AppMethodBeat.o(103854);
        } else {
            dVar.cTz();
            AppMethodBeat.o(103854);
        }
    }
}
