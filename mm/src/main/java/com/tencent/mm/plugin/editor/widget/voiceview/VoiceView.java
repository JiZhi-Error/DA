package com.tencent.mm.plugin.editor.widget.voiceview;

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
import com.tencent.mm.plugin.editor.widget.voiceview.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import java.util.Iterator;

public class VoiceView extends FrameLayout implements a.AbstractC0951a {
    public int dLt;
    public int duration;
    public View maskView;
    public String path = "";
    private TextView qPt;
    private ViewGroup qUs;
    TextView qUt;
    private ImageButton qUu;
    private TextView qUv;
    public a qUw;
    public a qUx;

    public class a extends MMHandler {
        int hiI;
        boolean isPaused;
        float qUA;
        int qUB;
        float qUz;

        private a() {
        }

        /* synthetic */ a(VoiceView voiceView, byte b2) {
            this();
        }

        @SuppressLint({"ResourceType"})
        public final void FD(int i2) {
            AppMethodBeat.i(182017);
            this.isPaused = false;
            this.qUz = b.DO((long) i2);
            this.qUA = this.qUz;
            this.qUB = com.tencent.mm.cb.a.fromDPToPix(VoiceView.this.getContext(), 0);
            VoiceView.this.qPt.setText(m.J(VoiceView.this.getContext(), (int) (this.qUz - this.qUA)));
            VoiceView.this.qUv.setText(m.J(VoiceView.this.getContext(), (int) this.qUz));
            VoiceView.this.qUu.setImageResource(R.raw.voicepost_beginicon);
            VoiceView.this.qUu.setContentDescription(VoiceView.this.getContext().getResources().getString(R.string.xu));
            VoiceView.this.qUt.setWidth(this.qUB);
            AppMethodBeat.o(182017);
        }

        public final void stop() {
            AppMethodBeat.i(182018);
            this.isPaused = false;
            removeMessages(4096);
            FD(VoiceView.this.duration);
            AppMethodBeat.o(182018);
        }

        public final void aED() {
            AppMethodBeat.i(182019);
            this.hiI = ((int) ((1.0f - (this.qUA / this.qUz)) * ((float) (VoiceView.this.qUs.getWidth() - this.qUB)))) + this.qUB;
            VoiceView.this.qPt.setText(m.J(VoiceView.this.getContext(), (int) (this.qUz - this.qUA)));
            VoiceView.this.qUv.setText(m.J(VoiceView.this.getContext(), (int) this.qUz));
            VoiceView.this.qUt.setWidth(this.hiI);
            AppMethodBeat.o(182019);
        }

        @SuppressLint({"ResourceType"})
        public final void lp(boolean z) {
            AppMethodBeat.i(182020);
            this.qUB = com.tencent.mm.cb.a.fromDPToPix(VoiceView.this.getContext(), 0);
            VoiceView.this.qUu.setImageResource(R.raw.voicepost_beginicon);
            VoiceView.this.qUu.setContentDescription(VoiceView.this.getContext().getResources().getString(R.string.xu));
            aED();
            if (z) {
                VoiceView.this.qUu.setImageResource(R.raw.voicepost_pauseicon);
                VoiceView.this.qUu.setContentDescription(VoiceView.this.getContext().getResources().getString(R.string.xc));
                sendEmptyMessage(4096);
            }
            AppMethodBeat.o(182020);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(182021);
            this.qUA = Math.max(0.0f, this.qUA - 0.256f);
            aED();
            if (this.qUA <= 0.1f) {
                AppMethodBeat.o(182021);
                return;
            }
            sendEmptyMessageDelayed(4096, 256);
            AppMethodBeat.o(182021);
        }
    }

    public VoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(182022);
        init(context);
        AppMethodBeat.o(182022);
    }

    public VoiceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(182023);
        init(context);
        AppMethodBeat.o(182023);
    }

    private void init(Context context) {
        AppMethodBeat.i(182024);
        LayoutInflater.from(context).inflate(R.layout.a1_, (ViewGroup) this, true);
        AppMethodBeat.o(182024);
    }

    @Override // com.tencent.mm.plugin.editor.widget.voiceview.a.AbstractC0951a
    public final void alV(String str) {
        AppMethodBeat.i(182025);
        if (!this.path.equals(str)) {
            cEG();
        }
        AppMethodBeat.o(182025);
    }

    @Override // com.tencent.mm.plugin.editor.widget.voiceview.a.AbstractC0951a
    public final void cEB() {
        AppMethodBeat.i(182026);
        cEG();
        AppMethodBeat.o(182026);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(182027);
        super.onConfigurationChanged(configuration);
        Log.i("MicroMsg.NoteVoiceView", "on configuration changed, is paused ? %B", Boolean.valueOf(this.qUx.isPaused));
        if (this.qUx.isPaused) {
            this.qUx.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.editor.widget.voiceview.VoiceView.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(182015);
                    VoiceView.this.qUx.aED();
                    AppMethodBeat.o(182015);
                }
            }, 128);
        }
        AppMethodBeat.o(182027);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(182028);
        super.onFinishInflate();
        this.qUs = (ViewGroup) findViewById(R.id.j_c);
        this.qPt = (TextView) findViewById(R.id.j_a);
        this.qUv = (TextView) findViewById(R.id.j_d);
        this.qUt = (TextView) findViewById(R.id.j_b);
        this.qUu = (ImageButton) findViewById(R.id.j__);
        this.maskView = findViewById(R.id.jaf);
        this.qUx = new a(this, (byte) 0);
        this.qUu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.widget.voiceview.VoiceView.AnonymousClass2 */

            public final void onClick(View view) {
                boolean resume;
                AppMethodBeat.i(182016);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (com.tencent.mm.q.a.cC(view.getContext()) || com.tencent.mm.q.a.cA(view.getContext()) || com.tencent.mm.q.a.cE(view.getContext())) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(182016);
                } else if (e.apn() || Util.isNullOrNil(VoiceView.this.path)) {
                    if (!Util.nullAs(VoiceView.this.path, "").equals(VoiceView.this.qUw.path)) {
                        VoiceView.j(VoiceView.this);
                    } else if (VoiceView.this.qUw.cEF()) {
                        VoiceView voiceView = VoiceView.this;
                        Log.i("MicroMsg.NoteVoiceView", "pause play");
                        a aVar = voiceView.qUw;
                        Log.i("MicroMsg.RecordVoiceHelper", "pause play");
                        MMEntryLock.unlock("keep_app_silent");
                        if (aVar.qUl == null) {
                            Log.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
                        } else if (aVar.qUl.pause()) {
                            Iterator<a.AbstractC0951a> it = aVar.callbacks.iterator();
                            while (it.hasNext()) {
                                it.next();
                            }
                        }
                        a aVar2 = voiceView.qUx;
                        aVar2.isPaused = true;
                        aVar2.removeMessages(4096);
                        VoiceView.this.qUu.setImageResource(R.raw.voicepost_beginicon);
                        VoiceView.this.qUu.setContentDescription(VoiceView.this.getContext().getResources().getString(R.string.xu));
                        voiceView.qUt.setKeepScreenOn(false);
                    } else {
                        VoiceView voiceView2 = VoiceView.this;
                        Log.i("MicroMsg.NoteVoiceView", "resume play");
                        a aVar3 = voiceView2.qUw;
                        Log.i("MicroMsg.RecordVoiceHelper", "resume play");
                        MMEntryLock.lock("keep_app_silent");
                        if (aVar3.qUl == null) {
                            Log.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
                            resume = false;
                        } else {
                            resume = aVar3.qUl.resume();
                            if (resume) {
                                Iterator<a.AbstractC0951a> it2 = aVar3.callbacks.iterator();
                                while (it2.hasNext()) {
                                    it2.next();
                                }
                            }
                        }
                        a aVar4 = voiceView2.qUx;
                        aVar4.isPaused = false;
                        aVar4.sendEmptyMessage(4096);
                        VoiceView.this.qUu.setImageResource(R.raw.voicepost_pauseicon);
                        VoiceView.this.qUu.setContentDescription(VoiceView.this.getContext().getResources().getString(R.string.xc));
                        voiceView2.qUt.setKeepScreenOn(true);
                        if (!resume) {
                            VoiceView.j(VoiceView.this);
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(182016);
                } else {
                    u.g(view.getContext(), null);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/VoiceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(182016);
                }
            }
        });
        AppMethodBeat.o(182028);
    }

    private void cEG() {
        AppMethodBeat.i(182029);
        this.qUx.stop();
        this.qUt.setKeepScreenOn(false);
        AppMethodBeat.o(182029);
    }

    public void setVoiceHelper(a aVar) {
        AppMethodBeat.i(182030);
        this.qUw = aVar;
        a aVar2 = this.qUw;
        Iterator<a.AbstractC0951a> it = aVar2.callbacks.iterator();
        while (true) {
            if (it.hasNext()) {
                if (this == it.next()) {
                    break;
                }
            } else {
                aVar2.callbacks.add(this);
                break;
            }
        }
        AppMethodBeat.o(182030);
    }

    static /* synthetic */ void j(VoiceView voiceView) {
        AppMethodBeat.i(182031);
        Log.d("MicroMsg.NoteVoiceView", "start play, path[%s] voiceType[%d]", voiceView.path, Integer.valueOf(voiceView.dLt));
        if (voiceView.qUw.cZ(voiceView.path, voiceView.dLt)) {
            voiceView.qUt.setKeepScreenOn(true);
            a aVar = voiceView.qUx;
            aVar.stop();
            aVar.isPaused = false;
            VoiceView.this.qUu.setImageResource(R.raw.voicepost_pauseicon);
            VoiceView.this.qUu.setContentDescription(VoiceView.this.getContext().getResources().getString(R.string.xc));
            aVar.sendEmptyMessage(4096);
            AppMethodBeat.o(182031);
            return;
        }
        Toast.makeText(voiceView.getContext(), (int) R.string.cd4, 1).show();
        AppMethodBeat.o(182031);
    }
}
