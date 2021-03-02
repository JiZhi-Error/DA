package com.tencent.mm.modelvoiceaddr.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public class VoiceSearchLayout extends LinearLayout {
    private static final int[] jxw = {R.drawable.bqu, R.drawable.bqv, R.drawable.bqw, R.drawable.bqx, R.drawable.bqa, R.drawable.bqb, R.drawable.bqc, R.drawable.bqd, R.drawable.bqe, R.drawable.bqf, R.drawable.bqg, R.drawable.bqh, R.drawable.bqi, R.drawable.bqj};
    private static final int[] jxx = {R.drawable.bqu, R.drawable.bqu, R.drawable.bqu, R.drawable.bqv, R.drawable.bqw, R.drawable.bqv, R.drawable.bqu, R.drawable.bqx, R.drawable.bqu, R.drawable.bqu};
    private static final int[] jxy = {R.drawable.bqk, R.drawable.bqt, R.drawable.bqt, R.drawable.bqt, R.drawable.bqk};
    private int from = 0;
    boolean isStart = false;
    private int jxA = 0;
    int jxB = 0;
    final MTimerHandler jxC = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(148610);
            if (VoiceSearchLayout.this.jxu == null) {
                AppMethodBeat.o(148610);
            } else if (VoiceSearchLayout.this.jxB < VoiceSearchLayout.jxy.length) {
                VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.jxy[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
                AppMethodBeat.o(148610);
            } else {
                f fVar = VoiceSearchLayout.this.jxu;
                Log.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + fVar.jwf);
                int i2 = fVar.jwf;
                fVar.jwf = 0;
                if (i2 > f.dAR) {
                    f.dAR = i2;
                }
                Log.d("getMaxAmplitude", " map: " + i2 + " max:" + f.dAR + " per:" + ((i2 * 100) / f.dAR));
                int i3 = (i2 * 100) / f.dAR;
                Log.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i3)));
                int i4 = VoiceSearchLayout.this.from;
                if (VoiceSearchLayout.this.from == VoiceSearchLayout.this.jxz) {
                    if (i3 <= 10) {
                        VoiceSearchLayout.f(VoiceSearchLayout.this);
                        if (VoiceSearchLayout.this.jxA >= VoiceSearchLayout.jxx.length) {
                            VoiceSearchLayout.this.jxA = 0;
                        }
                        VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.jxx[VoiceSearchLayout.this.jxA]);
                        AppMethodBeat.o(148610);
                    } else {
                        int i5 = i3 / 5;
                        if (i5 >= VoiceSearchLayout.jxw.length) {
                            i5 = VoiceSearchLayout.jxw.length - 1;
                        }
                        Log.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i5)));
                        VoiceSearchLayout.this.jxz = i5;
                    }
                } else if (VoiceSearchLayout.this.from > VoiceSearchLayout.this.jxz) {
                    VoiceSearchLayout.i(VoiceSearchLayout.this);
                } else {
                    VoiceSearchLayout.j(VoiceSearchLayout.this);
                }
                VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.jxw[i4]);
                AppMethodBeat.o(148610);
            }
            return true;
        }
    }, true);
    private View jxm = null;
    a jxn = null;
    private WeImageButton jxo;
    boolean jxp = false;
    int jxq = 0;
    private b jxr;
    private View jxs;
    private AnimationDrawable jxt;
    f jxu;
    private boolean jxv = false;
    private int jxz = 0;

    public interface a {
        void a(boolean z, String[] strArr, long j2);

        void biI();

        void biJ();
    }

    public interface b {
        void fX(boolean z);
    }

    static /* synthetic */ void a(VoiceSearchLayout voiceSearchLayout, int i2) {
        AppMethodBeat.i(148628);
        voiceSearchLayout.setAmpImage(i2);
        AppMethodBeat.o(148628);
    }

    static /* synthetic */ int c(VoiceSearchLayout voiceSearchLayout) {
        int i2 = voiceSearchLayout.jxB;
        voiceSearchLayout.jxB = i2 + 1;
        return i2;
    }

    static /* synthetic */ int f(VoiceSearchLayout voiceSearchLayout) {
        int i2 = voiceSearchLayout.jxA + 1;
        voiceSearchLayout.jxA = i2;
        return i2;
    }

    static /* synthetic */ int i(VoiceSearchLayout voiceSearchLayout) {
        int i2 = voiceSearchLayout.from - 1;
        voiceSearchLayout.from = i2;
        return i2;
    }

    static /* synthetic */ int j(VoiceSearchLayout voiceSearchLayout) {
        int i2 = voiceSearchLayout.from + 1;
        voiceSearchLayout.from = i2;
        return i2;
    }

    static /* synthetic */ void l(VoiceSearchLayout voiceSearchLayout) {
        AppMethodBeat.i(148630);
        voiceSearchLayout.fW(false);
        AppMethodBeat.o(148630);
    }

    public void setOnVisibleChangeListener(b bVar) {
        this.jxr = bVar;
    }

    public void setOnSearchListener(a aVar) {
        this.jxn = aVar;
    }

    @TargetApi(11)
    public VoiceSearchLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(148615);
        init(context);
        AppMethodBeat.o(148615);
    }

    public VoiceSearchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(148616);
        init(context);
        AppMethodBeat.o(148616);
    }

    public VoiceSearchLayout(Context context) {
        super(context);
        AppMethodBeat.i(148617);
        init(context);
        AppMethodBeat.o(148617);
    }

    private void init(Context context) {
        AppMethodBeat.i(148618);
        this.jxm = inflate(context, R.layout.c6t, this);
        this.jxo = (WeImageButton) this.jxm.findViewById(R.id.ja2);
        this.jxs = this.jxm.findViewById(R.id.ja0);
        setSearchStartBtnView(false);
        reset();
        AppMethodBeat.o(148618);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(148619);
        if (!this.jxp) {
            Log.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.isStart);
            if (this.isStart) {
                biE();
                this.isStart = false;
            }
        }
        AppMethodBeat.o(148619);
        return true;
    }

    public final void biE() {
        AppMethodBeat.i(148620);
        Log.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.isStart);
        if (this.isStart) {
            this.isStart = false;
            if (this.jxn != null) {
                this.jxn.biJ();
            }
        }
        reset();
        if (getVisibility() == 0) {
            setVisibility(8);
            if (this.jxr != null) {
                this.jxr.fX(false);
            }
        }
        bdZ();
        if (this.jxu != null) {
            this.jxu.cancel();
        }
        if (this.jxC != null) {
            this.jxC.stopTimer();
        }
        AppMethodBeat.o(148620);
    }

    public final void reset() {
        AppMethodBeat.i(148621);
        setSearchStartBtnView(false);
        this.isStart = false;
        this.jxp = false;
        this.jxo.setBackgroundResource(R.drawable.bq_);
        AppMethodBeat.o(148621);
    }

    private void setSearchStartBtnView(boolean z) {
        AppMethodBeat.i(148622);
        if (z) {
            this.jxo.setBackgroundResource(R.drawable.b2f);
            this.jxt = (AnimationDrawable) this.jxo.getBackground();
            if (this.jxt != null) {
                this.jxt.start();
                AppMethodBeat.o(148622);
                return;
            }
        } else {
            this.jxo.setBackgroundResource(R.drawable.bq_);
        }
        AppMethodBeat.o(148622);
    }

    public void setVisibility(int i2) {
        Animation loadAnimation;
        AppMethodBeat.i(148623);
        if (super.getVisibility() != i2 && !this.jxv) {
            if (i2 == 8) {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.bs);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.br);
            }
            startAnimation(loadAnimation);
            super.setVisibility(i2);
            if (this.jxr != null) {
                this.jxr.fX(i2 == 0);
            }
        }
        AppMethodBeat.o(148623);
    }

    public void setTopMargin(int i2) {
        AppMethodBeat.i(148624);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jxs.getLayoutParams();
        layoutParams.topMargin = i2;
        this.jxs.setLayoutParams(layoutParams);
        AppMethodBeat.o(148624);
    }

    private void setAmpImage(int i2) {
        AppMethodBeat.i(148625);
        if (this.jxo != null) {
            this.jxo.setBackgroundResource(i2);
        }
        AppMethodBeat.o(148625);
    }

    /* access modifiers changed from: package-private */
    public final void fW(boolean z) {
        AppMethodBeat.i(148626);
        if (z) {
            Log.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
            com.tencent.mm.plugin.audio.c.a.bdY();
        } else {
            bdZ();
        }
        k kVar = new k();
        if (z) {
            try {
                kVar.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131691297"));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VoiceSearchLayout", e2, "", new Object[0]);
                kVar.release();
                AppMethodBeat.o(148626);
                return;
            }
        } else {
            kVar.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131691255"));
        }
        kVar.setAudioStreamType(5);
        kVar.setOnCompletionListener(new MediaPlayer.OnCompletionListener(null) {
            /* class com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.AnonymousClass2 */
            final /* synthetic */ a jxE = null;

            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(148611);
                mediaPlayer.release();
                AppMethodBeat.o(148611);
            }
        });
        kVar.setOnErrorListener(new MediaPlayer.OnErrorListener(null) {
            /* class com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.AnonymousClass3 */
            final /* synthetic */ a jxE = null;

            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                return false;
            }
        });
        kVar.prepare();
        kVar.setLooping(false);
        kVar.start();
        AppMethodBeat.o(148626);
    }

    private static void bdZ() {
        AppMethodBeat.i(148627);
        Log.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
        com.tencent.mm.plugin.audio.c.a.bdZ();
        AppMethodBeat.o(148627);
    }

    static /* synthetic */ void k(VoiceSearchLayout voiceSearchLayout) {
        AppMethodBeat.i(148629);
        voiceSearchLayout.jxp = true;
        voiceSearchLayout.setSearchStartBtnView(true);
        AppMethodBeat.o(148629);
    }
}
