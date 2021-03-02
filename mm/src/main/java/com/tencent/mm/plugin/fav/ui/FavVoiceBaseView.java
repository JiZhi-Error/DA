package com.tencent.mm.plugin.fav.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;

public class FavVoiceBaseView extends LinearLayout implements n.a {
    private int dLt;
    private int duration;
    private String path = "";
    private TextView qPt;
    private ViewGroup qUs;
    private TextView qUt;
    private n tbL;
    private ImageButton tgc;
    private a tgd;

    public FavVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    public class a extends MMHandler {
        int hiI;
        boolean isPaused;
        float qUA;
        int qUB;
        float qUz;

        private a() {
        }

        /* synthetic */ a(FavVoiceBaseView favVoiceBaseView, byte b2) {
            this();
        }

        @SuppressLint({"ResourceType"})
        private void FD(int i2) {
            AppMethodBeat.i(106942);
            this.isPaused = false;
            this.qUz = b.AO((long) i2);
            this.qUA = this.qUz;
            this.qUB = com.tencent.mm.cb.a.fromDPToPix(FavVoiceBaseView.this.getContext(), 3);
            FavVoiceBaseView.this.qPt.setText(m.J(FavVoiceBaseView.this.getContext(), (int) this.qUz));
            FavVoiceBaseView.this.tgc.setImageResource(R.raw.voicepost_beginicon);
            FavVoiceBaseView.this.tgc.setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(R.string.xu));
            FavVoiceBaseView.this.qUt.setWidth(this.qUB);
            AppMethodBeat.o(106942);
        }

        @SuppressLint({"ResourceType"})
        public final void begin() {
            AppMethodBeat.i(106943);
            stop();
            this.isPaused = false;
            FavVoiceBaseView.this.tgc.setImageResource(R.raw.voicepost_pauseicon);
            FavVoiceBaseView.this.tgc.setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(R.string.xc));
            sendEmptyMessage(4096);
            AppMethodBeat.o(106943);
        }

        public final void stop() {
            AppMethodBeat.i(106944);
            this.isPaused = false;
            removeMessages(4096);
            FD(FavVoiceBaseView.this.duration);
            AppMethodBeat.o(106944);
        }

        public final void aED() {
            AppMethodBeat.i(106945);
            this.hiI = ((int) ((1.0f - (this.qUA / this.qUz)) * ((float) (FavVoiceBaseView.this.qUs.getWidth() - this.qUB)))) + this.qUB;
            FavVoiceBaseView.this.qPt.setText(m.J(FavVoiceBaseView.this.getContext(), Math.min((int) Math.ceil((double) this.qUA), (int) this.qUz)));
            FavVoiceBaseView.this.qUt.setWidth(this.hiI);
            AppMethodBeat.o(106945);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(106946);
            this.qUA = Math.max(0.0f, this.qUA - 0.256f);
            aED();
            if (this.qUA <= 0.1f) {
                AppMethodBeat.o(106946);
                return;
            }
            sendEmptyMessageDelayed(4096, 256);
            AppMethodBeat.o(106946);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(106947);
        super.onConfigurationChanged(configuration);
        Log.i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", Boolean.valueOf(this.tgd.isPaused));
        if (this.tgd.isPaused) {
            this.tgd.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.FavVoiceBaseView.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(106940);
                    FavVoiceBaseView.this.tgd.aED();
                    AppMethodBeat.o(106940);
                }
            }, 128);
        }
        AppMethodBeat.o(106947);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(106948);
        super.onFinishInflate();
        this.qUs = (ViewGroup) findViewById(R.id.j_c);
        this.qPt = (TextView) findViewById(R.id.j_a);
        this.qUt = (TextView) findViewById(R.id.j_b);
        this.tgc = (ImageButton) findViewById(R.id.j__);
        this.tgd = new a(this, (byte) 0);
        this.tgc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavVoiceBaseView.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(106941);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (com.tencent.mm.q.a.cC(view.getContext()) || com.tencent.mm.q.a.cA(view.getContext()) || com.tencent.mm.q.a.cE(view.getContext())) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(106941);
                } else if (e.apn() || Util.isNullOrNil(FavVoiceBaseView.this.path)) {
                    if (!Util.nullAs(FavVoiceBaseView.this.path, "").equals(FavVoiceBaseView.this.tbL.path)) {
                        FavVoiceBaseView.i(FavVoiceBaseView.this);
                    } else if (FavVoiceBaseView.this.tbL.cEF()) {
                        FavVoiceBaseView.this.cUJ();
                    } else if (!FavVoiceBaseView.j(FavVoiceBaseView.this)) {
                        FavVoiceBaseView.i(FavVoiceBaseView.this);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(106941);
                } else {
                    u.g(view.getContext(), null);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavVoiceBaseView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(106941);
                }
            }
        });
        AppMethodBeat.o(106948);
    }

    public void setVoiceHelper(n nVar) {
        AppMethodBeat.i(106949);
        this.tbL = nVar;
        this.tbL.a(this);
        AppMethodBeat.o(106949);
    }

    public final boolean cUJ() {
        AppMethodBeat.i(106950);
        Log.i("MicroMsg.FavVoiceBaseView", "pause play");
        boolean cUJ = this.tbL.cUJ();
        a aVar = this.tgd;
        aVar.isPaused = true;
        aVar.removeMessages(4096);
        FavVoiceBaseView.this.tgc.setImageResource(R.raw.voicepost_beginicon);
        FavVoiceBaseView.this.tgc.setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(R.string.xu));
        this.qUt.setKeepScreenOn(false);
        AppMethodBeat.o(106950);
        return cUJ;
    }

    @Override // com.tencent.mm.plugin.fav.a.n.a
    public final void dt(String str, int i2) {
        AppMethodBeat.i(106951);
        Log.d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", this.path, Integer.valueOf(this.duration), str);
        if (!Util.nullAs(str, "").equals(this.path)) {
            this.tgd.stop();
            this.qUt.setKeepScreenOn(false);
            AppMethodBeat.o(106951);
            return;
        }
        this.qUt.setKeepScreenOn(true);
        this.tgd.begin();
        AppMethodBeat.o(106951);
    }

    @Override // com.tencent.mm.plugin.fav.a.n.a
    public final void onPause() {
        AppMethodBeat.i(106953);
        cUJ();
        AppMethodBeat.o(106953);
    }

    @Override // com.tencent.mm.plugin.fav.a.n.a
    public final void onFinish() {
        AppMethodBeat.i(106952);
        Log.d("MicroMsg.FavVoiceBaseView", "stop play");
        this.tbL.stopPlay();
        this.tgd.stop();
        this.qUt.setKeepScreenOn(false);
        AppMethodBeat.o(106952);
    }

    static /* synthetic */ void i(FavVoiceBaseView favVoiceBaseView) {
        AppMethodBeat.i(106954);
        Log.d("MicroMsg.FavVoiceBaseView", "start play, path[%s] voiceType[%d]", favVoiceBaseView.path, Integer.valueOf(favVoiceBaseView.dLt));
        if (favVoiceBaseView.tbL.cZ(favVoiceBaseView.path, favVoiceBaseView.dLt)) {
            favVoiceBaseView.qUt.setKeepScreenOn(true);
            favVoiceBaseView.tgd.begin();
            AppMethodBeat.o(106954);
            return;
        }
        Toast.makeText(favVoiceBaseView.getContext(), (int) R.string.cd4, 1).show();
        AppMethodBeat.o(106954);
    }

    static /* synthetic */ boolean j(FavVoiceBaseView favVoiceBaseView) {
        AppMethodBeat.i(106955);
        Log.i("MicroMsg.FavVoiceBaseView", "resume play");
        boolean cUI = favVoiceBaseView.tbL.cUI();
        a aVar = favVoiceBaseView.tgd;
        aVar.isPaused = false;
        aVar.sendEmptyMessage(4096);
        FavVoiceBaseView.this.tgc.setImageResource(R.raw.voicepost_pauseicon);
        FavVoiceBaseView.this.tgc.setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(R.string.xc));
        favVoiceBaseView.qUt.setKeepScreenOn(true);
        AppMethodBeat.o(106955);
        return cUI;
    }
}
