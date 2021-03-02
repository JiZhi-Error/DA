package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.facedetect.d.b;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import java.util.Timer;
import java.util.TimerTask;

public final class c implements b {
    private static String TAG = "MicroMsg.NormalFaceMotion";
    private static long sRZ = 500;
    private boolean sSa = false;
    private boolean sSb = false;
    private View sSc = null;
    private View sSd = null;
    private String sSe;
    private long sSf;
    private final Object sSg = new Object();
    private Timer sSh = null;
    private volatile boolean sSi = false;
    private Animation sSj;
    private volatile boolean sSk = false;
    private volatile boolean sSl = false;

    public c(String str, long j2) {
        AppMethodBeat.i(103819);
        this.sSe = str;
        this.sSf = j2;
        this.sSj = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.eq);
        AppMethodBeat.o(103819);
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final boolean cTq() {
        return this.sSa && this.sSb;
    }

    public final TextView cTv() {
        AppMethodBeat.i(103820);
        if (!this.sSa && this.sSc != null) {
            TextView textView = (TextView) this.sSc.findViewById(R.id.dph);
            AppMethodBeat.o(103820);
            return textView;
        } else if (!this.sSa || this.sSd == null) {
            AppMethodBeat.o(103820);
            return null;
        } else {
            TextView textView2 = (TextView) this.sSd.findViewById(R.id.dph);
            AppMethodBeat.o(103820);
            return textView2;
        }
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final void setBusinessTip(String str) {
        AppMethodBeat.i(103821);
        Log.d(TAG, "getHintMsgTv() == null : " + (cTv() == null));
        if (cTv() == null) {
            AppMethodBeat.o(103821);
            return;
        }
        cTv().setText(str);
        AppMethodBeat.o(103821);
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        AppMethodBeat.i(103822);
        this.sSc = LayoutInflater.from(context).inflate(R.layout.a60, viewGroup);
        this.sSd = LayoutInflater.from(context).inflate(R.layout.a61, viewGroup2);
        this.sSd.setVisibility(4);
        if (cTv() != null) {
            cTv().setText(this.sSe);
        }
        long j2 = this.sSf;
        Log.i(TAG, "hy: starting tween timer: tween: %d", Long.valueOf(j2));
        if (this.sSh != null) {
            this.sSh.cancel();
        }
        this.sSh = new Timer("FaceDetect_hint", true);
        this.sSi = true;
        this.sSh.scheduleAtFixedRate(new TimerTask() {
            /* class com.tencent.mm.plugin.facedetect.d.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(103818);
                synchronized (c.this.sSg) {
                    try {
                        if (!c.this.sSi) {
                            Log.w(c.TAG, "hy: already stopped");
                            cancel();
                        }
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.facedetect.d.c.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(103817);
                                if (c.this.cTv() != null) {
                                    c.this.cTv().startAnimation(c.this.sSj);
                                }
                                AppMethodBeat.o(103817);
                            }
                        });
                    } finally {
                        AppMethodBeat.o(103818);
                    }
                }
            }
        }, 0, j2);
        AppMethodBeat.o(103822);
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final boolean cTr() {
        return false;
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final boolean a(FaceCharacteristicsResult faceCharacteristicsResult) {
        AppMethodBeat.i(103823);
        if (!this.sSa || faceCharacteristicsResult == null || faceCharacteristicsResult.errCode != 18) {
            AppMethodBeat.o(103823);
            return false;
        }
        Log.d(TAG, "hy: ignore too active");
        AppMethodBeat.o(103823);
        return true;
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final b.C1036b cTt() {
        AppMethodBeat.i(103826);
        if (this.sSa) {
            b.C1036b bVar = new b.C1036b(90025, "user cancelled in intermediate page");
            AppMethodBeat.o(103826);
            return bVar;
        }
        b.C1036b bVar2 = new b.C1036b(90004, "user cancelled in processing");
        AppMethodBeat.o(103826);
        return bVar2;
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final b.a cTu() {
        AppMethodBeat.i(103827);
        if (!this.sSa || this.sSl) {
            AppMethodBeat.o(103827);
            return null;
        }
        this.sSl = true;
        b.a aVar = new b.a();
        AppMethodBeat.o(103827);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final boolean b(FaceCharacteristicsResult faceCharacteristicsResult) {
        AppMethodBeat.i(103824);
        if (faceCharacteristicsResult.errCode == -1) {
            this.sSa = true;
            if (!this.sSk) {
                PlaySound.play(MMApplicationContext.getContext(), R.string.fsd);
                TextView textView = (TextView) this.sSc.findViewById(R.id.dph);
                Animation loadAnimation = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.bi);
                Animation loadAnimation2 = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.br);
                loadAnimation.setDuration(sRZ);
                loadAnimation2.setDuration(sRZ);
                textView.startAnimation(loadAnimation);
                textView.setVisibility(4);
                this.sSd.setVisibility(0);
                this.sSd.startAnimation(loadAnimation2);
                this.sSd.findViewById(R.id.c_1).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.facedetect.d.c.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(103816);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/facedetect/motion/NormalFaceMotion$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        c.this.sSb = true;
                        a.a(this, "com/tencent/mm/plugin/facedetect/motion/NormalFaceMotion$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(103816);
                    }
                });
                this.sSk = true;
                AppMethodBeat.o(103824);
                return true;
            }
        }
        AppMethodBeat.o(103824);
        return false;
    }

    @Override // com.tencent.mm.plugin.facedetect.d.b
    public final void cTs() {
        AppMethodBeat.i(103825);
        this.sSi = false;
        if (this.sSh != null) {
            this.sSh.cancel();
        }
        this.sSa = false;
        this.sSk = false;
        this.sSl = false;
        this.sSb = false;
        AppMethodBeat.o(103825);
    }
}
