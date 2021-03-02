package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl;
import com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public final class b {
    MMActivity gte;
    public ProgressBar hbv;
    public a xfn;
    public boolean xfo = false;
    public FTSVoiceInputLayoutImpl xfp;
    public TextView xfq;
    long xfr;
    long xfs;
    long xft;
    private FTSVoiceInputLayoutImpl.a xfu = new FTSVoiceInputLayoutImpl.a() {
        /* class com.tencent.mm.plugin.fts.ui.widget.b.AnonymousClass1 */
        String xfx = "";
        String xfy = "";

        @Override // com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.b
        public final void dPN() {
            AppMethodBeat.i(112290);
            this.xfx = "";
            this.xfy = "";
            Log.d("MicroMsg.FTSVoiceInputHelper", "onDetectStart");
            h.INSTANCE.a(15490, 3, Long.valueOf(e.wVm), 1);
            Log.d("MicroMsg.FTSVoiceInputHelper", "15490 type:3, sessionId:%s, voicever:%s", Long.valueOf(e.wVm), 1);
            b.this.xfo = true;
            b.this.xfn.dPy();
            AppMethodBeat.o(112290);
        }

        @Override // com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.a
        public final void dPO() {
            AppMethodBeat.i(112291);
            b.this.xfs = System.currentTimeMillis();
            if (b.this.xfo && !Util.isNullOrNil(this.xfx)) {
                b.this.dPM();
            }
            AppMethodBeat.o(112291);
        }

        @Override // com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.a
        public final void dPP() {
            AppMethodBeat.i(112292);
            b.this.xfr = System.currentTimeMillis();
            AppMethodBeat.o(112292);
        }

        @Override // com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.b
        public final void dPQ() {
            AppMethodBeat.i(112293);
            Log.d("MicroMsg.FTSVoiceInputHelper", "onDetectStop");
            AppMethodBeat.o(112293);
        }

        @Override // com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.b
        public final void dPR() {
            AppMethodBeat.i(112294);
            Log.d("MicroMsg.FTSVoiceInputHelper", "onDetectCancel");
            AppMethodBeat.o(112294);
        }

        @Override // com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.b
        public final void dPS() {
            AppMethodBeat.i(112295);
            Log.d("MicroMsg.FTSVoiceInputHelper", "onStateReset");
            AppMethodBeat.o(112295);
        }

        @Override // com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.b
        public final void dPT() {
            AppMethodBeat.i(112296);
            Log.d("MicroMsg.FTSVoiceInputHelper", "onDetectFinish");
            report();
            b.this.xfo = false;
            dPU();
            b.this.xfn.ayP(this.xfx);
            this.xfx = "";
            this.xfy = "";
            AppMethodBeat.o(112296);
        }

        @Override // com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.b
        public final void c(String[] strArr, List<String> list) {
            AppMethodBeat.i(112297);
            if (strArr != null && strArr.length > 0 && strArr[0].length() > 0) {
                this.xfx = strArr[0];
                Log.d("MicroMsg.FTSVoiceInputHelper", "onDetected text content: " + this.xfx);
                dPU();
            }
            if (list != null && !list.isEmpty() && list.iterator().hasNext()) {
                this.xfy = list.iterator().next();
                Log.d("MicroMsg.FTSVoiceInputHelper", "set voiceId:%s", this.xfy);
            }
            AppMethodBeat.o(112297);
        }

        @Override // com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.b
        public final void Nx(int i2) {
            AppMethodBeat.i(112298);
            b.this.xfo = false;
            report();
            if (i2 == 12) {
                b.this.xfn.c(false, true, this.xfx);
                AppMethodBeat.o(112298);
                return;
            }
            b.this.xfn.c(false, false, this.xfx);
            AppMethodBeat.o(112298);
        }

        private void dPU() {
            AppMethodBeat.i(112299);
            dPV();
            b.this.xfq.setText(this.xfx);
            b.this.hbv.setVisibility(0);
            b.this.xfn.ayO(this.xfx);
            AppMethodBeat.o(112299);
        }

        private void dPV() {
            AppMethodBeat.i(112300);
            if (this.xfx.length() > 0) {
                this.xfx = this.xfx.replaceAll("。", " ").replaceAll("\\.", " ").replaceAll("，", " ").replaceAll(",", " ").trim();
            }
            AppMethodBeat.o(112300);
        }

        private void report() {
            long j2;
            AppMethodBeat.i(112301);
            b.this.xft = System.currentTimeMillis();
            b bVar = b.this;
            if (b.this.xfs > 0) {
                j2 = b.this.xfs;
            } else {
                j2 = b.this.xft;
            }
            bVar.xfs = j2;
            int i2 = Util.isNullOrNil(this.xfx) ? 2 : 1;
            long j3 = b.this.xfs - b.this.xfr;
            long j4 = b.this.xft - b.this.xfr;
            h.INSTANCE.a(16346, Integer.valueOf(i2), Long.valueOf(e.wVm), Long.valueOf(j3), Long.valueOf(j4));
            Log.i("MicroMsg.FTSVoiceInputHelper", "16346 actionType:%s, searchId:%s, voiceTime:%s, tranTime:%s", Integer.valueOf(i2), Long.valueOf(e.wVm), Long.valueOf(j3), Long.valueOf(j4));
            b.this.xfr = 0;
            b.this.xfs = 0;
            b.this.xft = 0;
            AppMethodBeat.o(112301);
        }
    };
    Toast xfv;
    private VoiceInputLayout.a xfw = new VoiceInputLayout.a() {
        /* class com.tencent.mm.plugin.fts.ui.widget.b.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.a
        public final void dPW() {
            AppMethodBeat.i(112302);
            b bVar = b.this;
            if (bVar.xfv != null) {
                bVar.xfv.cancel();
            }
            bVar.xfv = Toast.makeText(bVar.gte, bVar.gte.getResources().getString(R.string.dkn), 0);
            bVar.xfv.setGravity(17, 0, 0);
            bVar.xfv.show();
            b.this.xfn.c(true, false, "");
            AppMethodBeat.o(112302);
        }
    };

    public interface a {
        void ayO(String str);

        void ayP(String str);

        void c(boolean z, boolean z2, String str);

        void dPy();
    }

    public b(Context context, FTSVoiceInputLayoutImpl fTSVoiceInputLayoutImpl, TextView textView, ProgressBar progressBar) {
        AppMethodBeat.i(112303);
        this.gte = (MMActivity) context;
        this.xfp = fTSVoiceInputLayoutImpl;
        this.xfq = textView;
        this.hbv = progressBar;
        this.xfp.setFTSVoiceDetectListener(this.xfu);
        this.xfp.setLongClickLisnter(this.xfw);
        AppMethodBeat.o(112303);
    }

    public final void dPM() {
        AppMethodBeat.i(112304);
        this.xfp.setVisibility(8);
        AppMethodBeat.o(112304);
    }

    public final void show() {
        AppMethodBeat.i(112305);
        if (!LocaleUtil.getApplicationLanguage().equals(LocaleUtil.CHINA)) {
            AppMethodBeat.o(112305);
            return;
        }
        this.xfp.setAlpha(0.0f);
        this.xfp.animate().alpha(1.0f).setDuration(500).start();
        this.xfp.setVisibility(0);
        this.hbv.setVisibility(8);
        this.xfq.setText("");
        AppMethodBeat.o(112305);
    }
}
