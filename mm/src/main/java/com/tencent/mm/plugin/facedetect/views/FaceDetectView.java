package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.facedetect.d.b;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetect.model.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.c.b.c;

public class FaceDetectView extends RelativeLayout {
    public static long sWf = 100;
    public static int sWg = 1;
    public volatile boolean idt;
    public boolean isPaused;
    public long sQX;
    private TextView sTK;
    public String sTT;
    public FaceDetectCameraView sVP;
    public FaceDetectDecorView sVQ;
    public ViewGroup sVR;
    public ViewGroup sVS;
    private a sVT;
    public b sVU;
    public boolean sVV;
    public boolean sVW;
    public String sVX;
    public boolean sVY;
    public boolean sVZ;
    public long sWa;
    private long sWb;
    private final int sWc;
    private Animation sWd;
    private View sWe;

    static /* synthetic */ void a(FaceDetectView faceDetectView, String str) {
        AppMethodBeat.i(104158);
        faceDetectView.arE(str);
        AppMethodBeat.o(104158);
    }

    static /* synthetic */ void cTS() {
    }

    static /* synthetic */ void h(FaceDetectView faceDetectView) {
        AppMethodBeat.i(104161);
        faceDetectView.cTR();
        AppMethodBeat.o(104161);
    }

    public FaceDetectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    private FaceDetectView(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2);
        Animation loadAnimation;
        AppMethodBeat.i(104145);
        this.sVP = null;
        this.sVQ = null;
        this.sTK = null;
        this.sVR = null;
        this.sVS = null;
        this.sVT = null;
        this.sVV = false;
        this.idt = false;
        this.isPaused = false;
        this.sVW = false;
        this.sVX = MMApplicationContext.getContext().getString(R.string.hct);
        this.sVY = true;
        this.sVZ = false;
        this.sQX = -1;
        this.sWa = -1;
        this.sWb = -1;
        this.sWc = 1500;
        this.sWe = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.byh, (ViewGroup) null, false);
        addView(inflate);
        this.sVP = (FaceDetectCameraView) inflate.findViewById(R.id.ai6);
        this.sVQ = (FaceDetectDecorView) inflate.findViewById(R.id.dp8);
        this.sWe = inflate.findViewById(R.id.djc);
        this.sVP.sVg = new b() {
            /* class com.tencent.mm.plugin.facedetect.views.FaceDetectView.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.facedetect.views.b
            public final void a(int i2, CharSequence charSequence) {
                AppMethodBeat.i(104137);
                Log.e("MicroMsg.FaceDetectView", "hy: onDetectError: %d, %s", Integer.valueOf(i2), charSequence);
                if (FaceDetectView.this.idt || FaceDetectView.this.isPaused) {
                    Log.w("MicroMsg.FaceDetectView", "hy: already end or paused");
                    AppMethodBeat.o(104137);
                } else if (FaceDetectView.this.sVU == null || !FaceDetectView.this.sVU.cTr()) {
                    FaceDetectView.this.mv(false);
                    FaceDetectView.this.sVW = true;
                    FaceDetectView.a(FaceDetectView.this, charSequence != null ? charSequence.toString() : FaceDetectView.this.getContext().getString(R.string.c4i));
                    if (FaceDetectView.this.sVT != null) {
                        FaceDetectView.this.sVT.A(i2, charSequence != null ? charSequence.toString() : FaceDetectView.this.getContext().getString(R.string.c4i));
                    }
                    AppMethodBeat.o(104137);
                } else {
                    Log.e("MicroMsg.FaceDetectView", "hy: motion eat result");
                    FaceDetectView.a(FaceDetectView.this, FaceDetectView.this.sVU.cTu());
                    AppMethodBeat.o(104137);
                }
            }

            @Override // com.tencent.mm.plugin.facedetect.views.b
            public final void d(FaceCharacteristicsResult faceCharacteristicsResult) {
                AppMethodBeat.i(104139);
                Log.d("MicroMsg.FaceDetectView", "hy: onDetectSucceed: %s", faceCharacteristicsResult.toString());
                if (FaceDetectView.this.idt || FaceDetectView.this.isPaused) {
                    Log.w("MicroMsg.FaceDetectView", "hy: already end pr paused");
                    AppMethodBeat.o(104139);
                } else if (FaceDetectView.this.sVU == null || !FaceDetectView.this.sVU.b(faceCharacteristicsResult)) {
                    FaceDetectView.this.sVW = false;
                    if ((FaceDetectView.this.sVU != null && FaceDetectView.this.sVU.cTq()) || FaceDetectView.f(FaceDetectView.this)) {
                        FaceDetectView.h(FaceDetectView.this);
                        FaceDetectView.e(FaceDetectView.this);
                    }
                    AppMethodBeat.o(104139);
                } else {
                    Log.e("MicroMsg.FaceDetectView", "hy: motion eat result");
                    FaceDetectView.a(FaceDetectView.this, FaceDetectView.this.sVU.cTu());
                    AppMethodBeat.o(104139);
                }
            }

            @Override // com.tencent.mm.plugin.facedetect.views.b
            public final void c(FaceCharacteristicsResult faceCharacteristicsResult) {
                AppMethodBeat.i(104138);
                int i2 = faceCharacteristicsResult.errCode;
                String str = faceCharacteristicsResult.errMsg;
                Log.v("MicroMsg.FaceDetectView", "hy: onDetectHelp: %d, %s", Integer.valueOf(i2), str);
                if (FaceDetectView.this.idt || FaceDetectView.this.isPaused) {
                    Log.w("MicroMsg.FaceDetectView", "hy: already end");
                    AppMethodBeat.o(104138);
                } else if (FaceDetectView.this.sVU == null || !FaceDetectView.this.sVU.a(faceCharacteristicsResult)) {
                    FaceDetectView.e(FaceDetectView.this);
                    if (!FaceDetectView.f(FaceDetectView.this)) {
                        AppMethodBeat.o(104138);
                    } else if (FaceDetectView.this.sVY || !(faceCharacteristicsResult.errCode == 10 || faceCharacteristicsResult.errCode == 11)) {
                        FaceDetectView.this.sVW = FaceCharacteristicsResult.HG(i2);
                        FaceDetectView faceDetectView = FaceDetectView.this;
                        if (str == null) {
                            str = "";
                        }
                        FaceDetectView.a(faceDetectView, str);
                        AppMethodBeat.o(104138);
                    } else {
                        AppMethodBeat.o(104138);
                    }
                } else {
                    Log.e("MicroMsg.FaceDetectView", "hy: motion eat result");
                    FaceDetectView.a(FaceDetectView.this, FaceDetectView.this.sVU.cTu());
                    AppMethodBeat.o(104138);
                }
            }
        };
        Context context2 = getContext();
        if (context2 == null) {
            Log.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
            loadAnimation = null;
        } else {
            loadAnimation = AnimationUtils.loadAnimation(context2, R.anim.z);
            loadAnimation.setInterpolator(new c());
        }
        this.sWd = loadAnimation;
        AppMethodBeat.o(104145);
    }

    public final void u(boolean z, final String str) {
        AppMethodBeat.i(104146);
        if (z) {
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.facedetect.views.FaceDetectView.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(104141);
                    final Bitmap arA = p.arA(str);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.facedetect.views.FaceDetectView.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(104140);
                            FaceDetectView.this.sWe.setVisibility(0);
                            FaceDetectView.this.sWe.setBackgroundDrawable(new BitmapDrawable(arA));
                            AppMethodBeat.o(104140);
                        }
                    });
                    AppMethodBeat.o(104141);
                }
            }, "face_detect_set_backgroud");
            AppMethodBeat.o(104146);
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        this.sWe.startAnimation(alphaAnimation);
        AppMethodBeat.o(104146);
    }

    private void cTR() {
        AppMethodBeat.i(104147);
        this.sTK.setText("");
        this.sTK.setVisibility(4);
        AppMethodBeat.o(104147);
    }

    private void arE(String str) {
        AppMethodBeat.i(104148);
        if (Util.nullAsNil(str).equals(this.sTK.getText().toString())) {
            Log.v("MicroMsg.FaceDetectView", "hy: same error. ignore");
            AppMethodBeat.o(104148);
            return;
        }
        this.sTK.setText(str);
        this.sTK.setVisibility(0);
        this.sTK.setAnimation(this.sWd);
        AppMethodBeat.o(104148);
    }

    public int getCameraRotation() {
        AppMethodBeat.i(104149);
        int rotation = this.sVP.sVv.getRotation();
        AppMethodBeat.o(104149);
        return rotation;
    }

    public int getCameraPreivewWidth() {
        AppMethodBeat.i(104150);
        int previewWidth = this.sVP.sVv.getPreviewWidth();
        AppMethodBeat.o(104150);
        return previewWidth;
    }

    public int getCameraPreviewHeight() {
        AppMethodBeat.i(104151);
        int previewHeight = this.sVP.sVv.getPreviewHeight();
        AppMethodBeat.o(104151);
        return previewHeight;
    }

    public int getCameraBestWidth() {
        AppMethodBeat.i(104152);
        int i2 = this.sVP.getEncodeVideoBestSize().x;
        AppMethodBeat.o(104152);
        return i2;
    }

    public int getCameraBestHeight() {
        AppMethodBeat.i(104153);
        int i2 = this.sVP.getEncodeVideoBestSize().y;
        AppMethodBeat.o(104153);
        return i2;
    }

    public b.C1036b getCurrentMotionCancelInfo() {
        AppMethodBeat.i(104154);
        if (this.sVU != null) {
            b.C1036b cTt = this.sVU.cTt();
            AppMethodBeat.o(104154);
            return cTt;
        }
        b.C1036b bVar = new b.C1036b(90004, "user cancelled in processing");
        AppMethodBeat.o(104154);
        return bVar;
    }

    public final void mv(boolean z) {
        AppMethodBeat.i(104155);
        if (this.sVU != null) {
            this.sVU.cTs();
        }
        if (!this.idt) {
            this.idt = true;
            if (z) {
                if (this.sVP != null) {
                    f.ao(new Runnable() {
                        /* class com.tencent.mm.plugin.facedetect.views.FaceDetectView.AnonymousClass5 */
                        final /* synthetic */ q sSU = null;

                        public final void run() {
                            AppMethodBeat.i(104144);
                            FaceDetectView.this.sVP.cTL();
                            if (this.sSU != null) {
                                this.sSU.b(FaceDetectView.this.sVP.cTN());
                            }
                            AppMethodBeat.o(104144);
                        }
                    });
                }
            } else if (this.sVP != null) {
                this.sVP.cTK();
            }
            Log.i("MicroMsg.FaceDetectView", "hy: stopped capture face");
            this.sVW = false;
            cTR();
            AppMethodBeat.o(104155);
            return;
        }
        Log.w("MicroMsg.FaceDetectView", "hy: already end");
        AppMethodBeat.o(104155);
    }

    public void setCallback(a aVar) {
        this.sVT = aVar;
    }

    public void setErrTextView(TextView textView) {
        this.sTK = textView;
    }

    public Bitmap getPreviewBm() {
        AppMethodBeat.i(104156);
        Bitmap bitmap = this.sVP.getBitmap();
        AppMethodBeat.o(104156);
        return bitmap;
    }

    public void setBusinessTip(String str) {
        this.sTT = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.facedetect.views.FaceDetectView r5, com.tencent.mm.plugin.facedetect.d.b.a r6) {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.views.FaceDetectView.a(com.tencent.mm.plugin.facedetect.views.FaceDetectView, com.tencent.mm.plugin.facedetect.d.b$a):void");
    }

    static /* synthetic */ void e(FaceDetectView faceDetectView) {
        AppMethodBeat.i(104159);
        if (faceDetectView.sVU != null && faceDetectView.sVU.cTq()) {
            Log.i("MicroMsg.FaceDetectView", "hy: meet require");
            faceDetectView.sVP.cTL();
            faceDetectView.isPaused = true;
            long ticksToNow = Util.ticksToNow(faceDetectView.sWa);
            Log.i("MicroMsg.FaceDetectView", "hy: current motion used time: %d", Long.valueOf(ticksToNow));
            if (ticksToNow < faceDetectView.sQX - 5) {
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.facedetect.views.FaceDetectView.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(104142);
                        if (FaceDetectView.this.sVT != null && !FaceDetectView.this.idt) {
                            FaceDetectView.this.sVT.A(0, "");
                        }
                        FaceDetectView.cTS();
                        AppMethodBeat.o(104142);
                    }
                }, faceDetectView.sQX - ticksToNow);
                AppMethodBeat.o(104159);
                return;
            } else if (faceDetectView.sVT != null && !faceDetectView.idt) {
                faceDetectView.sVT.A(0, "");
            }
        }
        AppMethodBeat.o(104159);
    }

    static /* synthetic */ boolean f(FaceDetectView faceDetectView) {
        AppMethodBeat.i(104160);
        long currentTicks = Util.currentTicks();
        long j2 = currentTicks - faceDetectView.sWb;
        Log.d("MicroMsg.FaceDetectView", "hy: tick between: %d, threshold: %d", Long.valueOf(j2), 1500);
        if (j2 > 1500) {
            faceDetectView.sWb = currentTicks;
            AppMethodBeat.o(104160);
            return true;
        }
        AppMethodBeat.o(104160);
        return false;
    }
}
