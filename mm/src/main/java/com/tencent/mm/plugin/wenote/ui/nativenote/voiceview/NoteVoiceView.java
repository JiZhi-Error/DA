package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import java.util.Iterator;

public class NoteVoiceView extends FrameLayout implements a.AbstractC2008a {
    public a JLo;
    public a JLp;
    public int dLt;
    public int duration;
    public View maskView;
    public String path = "";
    private TextView qPt;
    private ViewGroup qUs;
    TextView qUt;
    private TextView qUv;
    private ImageButton tgc;

    public class a extends MMHandler {
        int hiI;
        boolean isPaused;
        float qUA;
        int qUB;
        float qUz;

        private a() {
        }

        /* synthetic */ a(NoteVoiceView noteVoiceView, byte b2) {
            this();
        }

        @SuppressLint({"ResourceType"})
        public final void FD(int i2) {
            AppMethodBeat.i(30914);
            this.isPaused = false;
            this.qUz = b.DO((long) i2);
            this.qUA = this.qUz;
            this.qUB = com.tencent.mm.cb.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
            NoteVoiceView.this.qPt.setText(m.J(NoteVoiceView.this.getContext(), (int) (this.qUz - this.qUA)));
            NoteVoiceView.this.qUv.setText(m.J(NoteVoiceView.this.getContext(), (int) this.qUz));
            NoteVoiceView.this.tgc.setImageResource(R.raw.voicepost_beginicon);
            NoteVoiceView.this.tgc.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.string.xu));
            NoteVoiceView.this.qUt.setWidth(this.qUB);
            AppMethodBeat.o(30914);
        }

        public final void stop() {
            AppMethodBeat.i(30915);
            this.isPaused = false;
            removeMessages(4096);
            FD(NoteVoiceView.this.duration);
            AppMethodBeat.o(30915);
        }

        public final void aED() {
            AppMethodBeat.i(30916);
            this.hiI = ((int) ((1.0f - (this.qUA / this.qUz)) * ((float) (NoteVoiceView.this.qUs.getWidth() - this.qUB)))) + this.qUB;
            NoteVoiceView.this.qPt.setText(m.J(NoteVoiceView.this.getContext(), (int) (this.qUz - this.qUA)));
            NoteVoiceView.this.qUv.setText(m.J(NoteVoiceView.this.getContext(), (int) this.qUz));
            NoteVoiceView.this.qUt.setWidth(this.hiI);
            AppMethodBeat.o(30916);
        }

        @SuppressLint({"ResourceType"})
        public final void lp(boolean z) {
            AppMethodBeat.i(30917);
            this.qUB = com.tencent.mm.cb.a.fromDPToPix(NoteVoiceView.this.getContext(), 0);
            NoteVoiceView.this.tgc.setImageResource(R.raw.voicepost_beginicon);
            NoteVoiceView.this.tgc.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.string.xu));
            aED();
            if (z) {
                NoteVoiceView.this.tgc.setImageResource(R.raw.voicepost_pauseicon);
                NoteVoiceView.this.tgc.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.string.xc));
                sendEmptyMessage(4096);
            }
            AppMethodBeat.o(30917);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(30918);
            this.qUA = Math.max(0.0f, this.qUA - 0.256f);
            aED();
            if (this.qUA <= 0.1f) {
                AppMethodBeat.o(30918);
                return;
            }
            sendEmptyMessageDelayed(4096, 256);
            AppMethodBeat.o(30918);
        }
    }

    public NoteVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(30919);
        init(context);
        AppMethodBeat.o(30919);
    }

    public NoteVoiceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(30920);
        init(context);
        AppMethodBeat.o(30920);
    }

    private void init(Context context) {
        AppMethodBeat.i(30921);
        LayoutInflater.from(context).inflate(R.layout.bgg, (ViewGroup) this, true);
        AppMethodBeat.o(30921);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.AbstractC2008a
    public final void alV(String str) {
        AppMethodBeat.i(30922);
        if (!this.path.equals(str)) {
            cEG();
        }
        AppMethodBeat.o(30922);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.AbstractC2008a
    public final void cEB() {
        AppMethodBeat.i(30923);
        cEG();
        AppMethodBeat.o(30923);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(30924);
        super.onConfigurationChanged(configuration);
        Log.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", Boolean.valueOf(this.JLp.isPaused));
        if (this.JLp.isPaused) {
            this.JLp.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(30912);
                    NoteVoiceView.this.JLp.aED();
                    AppMethodBeat.o(30912);
                }
            }, 128);
        }
        AppMethodBeat.o(30924);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(30925);
        super.onFinishInflate();
        this.qUs = (ViewGroup) findViewById(R.id.j_c);
        this.qPt = (TextView) findViewById(R.id.j_a);
        this.qUv = (TextView) findViewById(R.id.j_d);
        this.qUt = (TextView) findViewById(R.id.j_b);
        this.tgc = (ImageButton) findViewById(R.id.j__);
        this.maskView = findViewById(R.id.jaf);
        this.JLp = new a(this, (byte) 0);
        this.tgc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView.AnonymousClass2 */

            public final void onClick(View view) {
                boolean resume;
                AppMethodBeat.i(30913);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (com.tencent.mm.q.a.cC(view.getContext()) || com.tencent.mm.q.a.cA(view.getContext()) || com.tencent.mm.q.a.cE(view.getContext())) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(30913);
                } else if (e.apn() || Util.isNullOrNil(NoteVoiceView.this.path)) {
                    if (!Util.nullAs(NoteVoiceView.this.path, "").equals(NoteVoiceView.this.JLo.path)) {
                        NoteVoiceView.j(NoteVoiceView.this);
                    } else if (NoteVoiceView.this.JLo.cEF()) {
                        NoteVoiceView noteVoiceView = NoteVoiceView.this;
                        Log.i("MicroMsg.NoteVoiceView", "pause play");
                        a aVar = noteVoiceView.JLo;
                        Log.i("MicroMsg.RecordVoiceHelper", "pause play");
                        MMEntryLock.unlock("keep_app_silent");
                        if (aVar.qUl == null) {
                            Log.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
                        } else if (aVar.qUl.pause()) {
                            Iterator<a.AbstractC2008a> it = aVar.callbacks.iterator();
                            while (it.hasNext()) {
                                it.next();
                            }
                        }
                        a aVar2 = noteVoiceView.JLp;
                        aVar2.isPaused = true;
                        aVar2.removeMessages(4096);
                        NoteVoiceView.this.tgc.setImageResource(R.raw.voicepost_beginicon);
                        NoteVoiceView.this.tgc.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.string.xu));
                        noteVoiceView.qUt.setKeepScreenOn(false);
                    } else {
                        NoteVoiceView noteVoiceView2 = NoteVoiceView.this;
                        Log.i("MicroMsg.NoteVoiceView", "resume play");
                        a aVar3 = noteVoiceView2.JLo;
                        Log.i("MicroMsg.RecordVoiceHelper", "resume play");
                        MMEntryLock.lock("keep_app_silent");
                        if (aVar3.qUl == null) {
                            Log.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
                            resume = false;
                        } else {
                            resume = aVar3.qUl.resume();
                            if (resume) {
                                Iterator<a.AbstractC2008a> it2 = aVar3.callbacks.iterator();
                                while (it2.hasNext()) {
                                    it2.next();
                                }
                            }
                        }
                        a aVar4 = noteVoiceView2.JLp;
                        aVar4.isPaused = false;
                        aVar4.sendEmptyMessage(4096);
                        NoteVoiceView.this.tgc.setImageResource(R.raw.voicepost_pauseicon);
                        NoteVoiceView.this.tgc.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.string.xc));
                        noteVoiceView2.qUt.setKeepScreenOn(true);
                        if (!resume) {
                            NoteVoiceView.j(NoteVoiceView.this);
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(30913);
                } else {
                    u.g(view.getContext(), null);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteVoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(30913);
                }
            }
        });
        AppMethodBeat.o(30925);
    }

    private void cEG() {
        AppMethodBeat.i(30926);
        this.JLp.stop();
        this.qUt.setKeepScreenOn(false);
        AppMethodBeat.o(30926);
    }

    public void setVoiceHelper(a aVar) {
        AppMethodBeat.i(30927);
        this.JLo = aVar;
        this.JLo.a(this);
        AppMethodBeat.o(30927);
    }

    static /* synthetic */ void j(NoteVoiceView noteVoiceView) {
        AppMethodBeat.i(30928);
        Log.d("MicroMsg.NoteVoiceView", "start play, path[%s] voiceType[%d]", noteVoiceView.path, Integer.valueOf(noteVoiceView.dLt));
        if (noteVoiceView.JLo.cZ(noteVoiceView.path, noteVoiceView.dLt)) {
            noteVoiceView.qUt.setKeepScreenOn(true);
            a aVar = noteVoiceView.JLp;
            aVar.stop();
            aVar.isPaused = false;
            NoteVoiceView.this.tgc.setImageResource(R.raw.voicepost_pauseicon);
            NoteVoiceView.this.tgc.setContentDescription(NoteVoiceView.this.getContext().getResources().getString(R.string.xc));
            aVar.sendEmptyMessage(4096);
            AppMethodBeat.o(30928);
            return;
        }
        Toast.makeText(noteVoiceView.getContext(), (int) R.string.cd4, 1).show();
        AppMethodBeat.o(30928);
    }
}
