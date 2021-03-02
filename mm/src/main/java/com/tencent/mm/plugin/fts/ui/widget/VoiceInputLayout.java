package com.tencent.mm.plugin.fts.ui.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.SceneVoiceInputAddrProxy;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.List;

public abstract class VoiceInputLayout extends LinearLayout {
    protected int currentState = 1;
    public final MTimerHandler jxC = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(112379);
            if (VoiceInputLayout.this.xhj == null) {
                AppMethodBeat.o(112379);
            } else {
                int maxAmplitudeRate = VoiceInputLayout.this.xhj.getMaxAmplitudeRate();
                if (VoiceInputLayout.this.currentState == 2) {
                    VoiceInputLayout.this.Ny(maxAmplitudeRate);
                }
                AppMethodBeat.o(112379);
            }
            return true;
        }
    }, true);
    public MMHandler ndA = new MMHandler() {
        /* class com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(112373);
            if (message.what != 0) {
                if (message.what == 1) {
                    Log.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", Integer.valueOf(VoiceInputLayout.this.currentState));
                } else {
                    AppMethodBeat.o(112373);
                    return;
                }
            }
            Log.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", Integer.valueOf(VoiceInputLayout.this.currentState));
            if (VoiceInputLayout.this.currentState != 3) {
                AppMethodBeat.o(112373);
                return;
            }
            VoiceInputLayout.this.ndA.removeMessages(0);
            VoiceInputLayout.this.ndA.removeMessages(1);
            if (VoiceInputLayout.this.xhj != null) {
                VoiceInputLayout.this.xhj.cancel(true);
            }
            VoiceInputLayout.this.reset(true);
            AppMethodBeat.o(112373);
        }
    };
    protected a xfw;
    protected b xhi = null;
    private com.tencent.mm.modelvoiceaddr.b xhj;
    protected boolean xhk = false;
    private int xhl = 3000;
    private int xhm = 10000;
    public MMHandler xhn = new MMHandler() {
        /* class com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(112378);
            switch (message.what) {
                case 0:
                    VoiceInputLayout.this.dQo();
                    AppMethodBeat.o(112378);
                    return;
                case 1:
                    Bundle data = message.getData();
                    VoiceInputLayout.this.ai(data.getInt("localCode"), data.getInt("errType"), data.getInt("errCode"));
                    break;
            }
            AppMethodBeat.o(112378);
        }
    };

    public interface a {
        void dPW();
    }

    public interface b {
        void Nx(int i2);

        void c(String[] strArr, List<String> list);

        void dPN();

        void dPQ();

        void dPR();

        void dPS();

        void dPT();
    }

    /* access modifiers changed from: protected */
    public abstract void Ny(int i2);

    /* access modifiers changed from: protected */
    public abstract void dPZ();

    /* access modifiers changed from: protected */
    public abstract void dQa();

    /* access modifiers changed from: protected */
    public abstract void onReset();

    public void setLongClickLisnter(a aVar) {
        this.xfw = aVar;
    }

    public void setVoiceDetectListener(b bVar) {
        this.xhi = bVar;
    }

    public void setFromFullScreen(boolean z) {
        this.xhk = z;
    }

    @TargetApi(11)
    public VoiceInputLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public VoiceInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void dQm() {
        if (com.tencent.mm.q.a.cC(getContext()) || com.tencent.mm.q.a.cA(getContext()) || com.tencent.mm.q.a.cE(getContext())) {
            Log.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
            onReset();
            return;
        }
        boolean n = com.tencent.mm.pluginsdk.permission.b.n(getContext(), "android.permission.RECORD_AUDIO");
        Log.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", Boolean.valueOf(n));
        if (n) {
            Log.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", Integer.valueOf(this.currentState));
            if (this.currentState == 1) {
                this.currentState = 2;
                if (this.xhi != null) {
                    this.xhi.dPN();
                }
                this.jxC.startTimer(50);
                dPZ();
                if (MMApplicationContext.isMMProcess()) {
                    this.xhj = new g();
                } else {
                    this.xhj = SceneVoiceInputAddrProxy.getInstance();
                }
                this.xhj.init(g.jwq, 8, new g.b() {
                    /* class com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.AnonymousClass2 */

                    @Override // com.tencent.mm.modelvoiceaddr.g.b
                    public final void biv() {
                        AppMethodBeat.i(112374);
                        Log.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", Integer.valueOf(VoiceInputLayout.this.currentState));
                        if (VoiceInputLayout.this.jxC != null) {
                            VoiceInputLayout.this.jxC.stopTimer();
                        }
                        VoiceInputLayout.this.xhn.sendEmptyMessage(0);
                        AppMethodBeat.o(112374);
                    }

                    @Override // com.tencent.mm.modelvoiceaddr.g.b
                    public final void biz() {
                        AppMethodBeat.i(112375);
                        Log.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
                        VoiceInputLayout.this.ndA.removeMessages(0);
                        VoiceInputLayout.this.ndA.removeMessages(1);
                        VoiceInputLayout.this.xhi.dPT();
                        VoiceInputLayout.this.reset(false);
                        AppMethodBeat.o(112375);
                    }

                    @Override // com.tencent.mm.modelvoiceaddr.g.b
                    public final void b(String[] strArr, List<String> list) {
                        AppMethodBeat.i(112376);
                        VoiceInputLayout.this.xhi.c(strArr, list);
                        VoiceInputLayout.this.ndA.removeMessages(0);
                        VoiceInputLayout.this.ndA.sendEmptyMessageDelayed(0, (long) VoiceInputLayout.this.xhl);
                        AppMethodBeat.o(112376);
                    }

                    @Override // com.tencent.mm.modelvoiceaddr.g.b
                    public final void c(int i2, int i3, int i4, long j2) {
                        AppMethodBeat.i(112377);
                        VoiceInputLayout.this.ndA.removeMessages(0);
                        VoiceInputLayout.this.ndA.removeMessages(1);
                        Message message = new Message();
                        Bundle bundle = new Bundle();
                        bundle.putInt("localCode", i2);
                        bundle.putInt("errType", i3);
                        bundle.putInt("errCode", i4);
                        message.setData(bundle);
                        message.what = 1;
                        VoiceInputLayout.this.xhn.sendMessage(message);
                        AppMethodBeat.o(112377);
                    }
                });
                this.xhj.start();
            }
        } else if (getContext() instanceof Activity) {
            com.tencent.mm.pluginsdk.permission.b.b((Activity) getContext(), "android.permission.RECORD_AUDIO", 80);
        }
    }

    public final void biE() {
        Log.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", Integer.valueOf(this.currentState));
        if (this.currentState != 1) {
            this.currentState = 1;
            if (this.xhi != null) {
                this.xhi.dPR();
            }
            if (this.xhj != null) {
                this.xhj.cancel(true);
            }
            onReset();
        }
    }

    public final void dQn() {
        Log.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", Integer.valueOf(this.currentState));
        if (this.currentState != 1 && this.currentState == 2) {
            this.currentState = 3;
            if (this.xhi != null) {
                this.xhi.dPQ();
            }
            if (this.jxC != null) {
                this.jxC.stopTimer();
            }
            this.ndA.removeMessages(0);
            this.ndA.sendEmptyMessageDelayed(0, (long) this.xhl);
            this.ndA.sendEmptyMessageDelayed(1, (long) this.xhm);
            dQa();
            if (this.xhj != null) {
                this.xhj.stop(true);
            }
        }
    }

    public final void dQo() {
        Log.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", Integer.valueOf(this.currentState));
        if (this.currentState == 2) {
            this.currentState = 3;
            this.ndA.removeMessages(0);
            this.ndA.sendEmptyMessageDelayed(0, (long) this.xhl);
            this.ndA.sendEmptyMessageDelayed(1, (long) this.xhm);
            dQa();
        }
    }

    public final void dQp() {
        ai(12, -1, -1);
    }

    public final void ai(int i2, int i3, int i4) {
        Log.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        this.currentState = 1;
        onReset();
        if (this.xhi != null) {
            this.xhi.Nx(i2);
        }
    }

    /* access modifiers changed from: protected */
    public final void reset(boolean z) {
        Log.d("MicroMsg.VoiceInputLayout", "reset currentState %s", Integer.valueOf(this.currentState));
        if (this.currentState != 1) {
            this.currentState = 1;
            onReset();
            if (z && this.xhi != null) {
                this.xhi.dPS();
            }
        }
    }

    public int getCurrentState() {
        return this.currentState;
    }
}
