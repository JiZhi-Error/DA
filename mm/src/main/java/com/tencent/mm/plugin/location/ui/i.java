package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.bh.c;
import com.tencent.mm.bh.d;
import com.tencent.mm.bh.g;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class i implements com.tencent.mm.ak.i, d {
    private Activity activity;
    private List<String> dSU = new LinkedList();
    private boolean yJA = true;
    private String yJB;
    String yJC;
    private String yJD;
    boolean yJE = false;
    int yJF = 0;
    private long yJG = 500;
    long yJH = 0;
    MTimerHandler yJI = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.location.ui.i.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(55932);
            Log.i("MicroMsg.TalkMgr", "onSeizeMicSuccess expired to execute");
            i.this.edu();
            AppMethodBeat.o(55932);
            return false;
        }
    }, false);
    MTimerHandler yJJ = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.location.ui.i.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(55933);
            Log.i("MicroMsg.TalkMgr", "seizeMicTimer reach");
            i.a(i.this);
            AppMethodBeat.o(55933);
            return false;
        }
    }, false);
    private MTimerHandler yJK = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.location.ui.i.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(55934);
            i.this.display();
            AppMethodBeat.o(55934);
            return false;
        }
    }, false);
    public c yJL;
    public a yJM;
    final MTimerHandler yJN = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.location.ui.i.AnonymousClass5 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            short bgv;
            AppMethodBeat.i(55936);
            if (i.this.yJF == 3) {
                bgv = i.this.yJL.bgu();
            } else if (Util.isNullOrNil(i.this.yJC)) {
                AppMethodBeat.o(55936);
                return false;
            } else {
                bgv = i.this.yJL.bgv();
            }
            i iVar = i.this;
            float f2 = (float) bgv;
            if (f2 < 10.0f) {
                f2 = 10.0f;
            }
            if (f2 > 100.0f) {
                f2 = 100.0f;
            }
            iVar.yJy.setVolume(f2 / 100.0f);
            iVar.yJy.invalidate();
            AppMethodBeat.o(55936);
            return true;
        }
    }, true);
    private boolean yJO = true;
    Button yJx;
    public VolumeMeter yJy;
    RelativeLayout yJz;

    public interface a {
        void aDh(String str);

        void aDi(String str);

        void edq();

        void edr();

        void eds();
    }

    public i(Activity activity2, Button button) {
        AppMethodBeat.i(55940);
        this.activity = activity2;
        this.yJx = button;
        this.yJz = (RelativeLayout) this.activity.findViewById(R.id.jcq);
        this.yJz.setVisibility(8);
        this.yJy = (VolumeMeter) this.yJz.findViewById(R.id.jcr);
        this.yJy.setArchView(this.yJx);
        VolumeMeter volumeMeter = this.yJy;
        if (volumeMeter.yKv == null) {
            volumeMeter.yKv = new MMHandler("VolumeMeter_handler");
        }
        this.yJL = g.jpz;
        if (this.yJL == null) {
            Log.e("MicroMsg.TalkMgr", "cannot get talkroom server");
        }
        AppMethodBeat.o(55940);
    }

    public final void edt() {
        AppMethodBeat.i(55941);
        this.yJD = this.activity.getIntent().getStringExtra("map_talker_name");
        this.yJL.a(this);
        Log.d("MicroMsg.TalkMgr", "talkRoomName %s ", this.yJD);
        final String str = this.yJD;
        this.yJB = str;
        if (!Util.isNullOrNil(this.yJB)) {
            if (ab.Eq(str)) {
                List<String> Ic = v.Ic(str);
                if (Ic == null) {
                    ay.a.iDq.aL(str, "");
                } else {
                    this.dSU = Ic;
                }
            } else {
                this.dSU.clear();
                this.dSU.add(str);
                this.dSU.add(z.aTY());
            }
            new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.mm.plugin.location.ui.i.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(55937);
                    i.this.yJL.aw(str, 1);
                    AppMethodBeat.o(55937);
                }
            });
            this.yJx.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.location.ui.i.AnonymousClass7 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(55939);
                    switch (motionEvent.getAction()) {
                        case 0:
                            i.this.yJE = true;
                            i.this.yJz.setVisibility(0);
                            i.this.yJy.reset();
                            VolumeMeter volumeMeter = i.this.yJy;
                            if (!volumeMeter.yKr) {
                                volumeMeter.iTN = true;
                                volumeMeter.edB();
                            }
                            i.this.yJx.setPressed(true);
                            if (i.this.yJE) {
                                PlaySound.play(MMApplicationContext.getContext(), (int) R.string.hl5, new PlaySound.OnPlayCompletionListener() {
                                    /* class com.tencent.mm.plugin.location.ui.i.AnonymousClass7.AnonymousClass1 */

                                    @Override // com.tencent.mm.sdk.platformtools.PlaySound.OnPlayCompletionListener
                                    public final void onCompletion() {
                                        AppMethodBeat.i(55938);
                                        Log.i("MicroMsg.TalkMgr", "play press sound end");
                                        AppMethodBeat.o(55938);
                                    }
                                });
                                i.this.yJF = 1;
                                Log.i("MicroMsg.TalkMgr", "micBtn pressed down");
                                i.this.yJH = Util.currentTicks();
                                i.this.yJL.bgw();
                                i.this.display();
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            i.this.yJx.setPressed(false);
                            i.this.yJz.setVisibility(8);
                            i.this.yJy.reset();
                            i.this.yJy.iTN = false;
                            if (i.this.yJE) {
                                i.this.yJE = false;
                                if (i.this.yJF == 5) {
                                    Log.i("MicroMsg.TalkMgr", "cancel during seize-success prepare time");
                                    i.this.yJI.stopTimer();
                                    i.this.yJJ.stopTimer();
                                }
                                i.this.yJF = 0;
                                i.this.yJN.stopTimer();
                                i.this.yJL.bgx();
                                PlaySound.play(MMApplicationContext.getContext(), R.string.hl8);
                                i.this.display();
                                if (i.this.yJM != null) {
                                    i.this.yJM.edr();
                                    break;
                                }
                            }
                            break;
                        case 2:
                            if (i.this.yJE) {
                            }
                            break;
                    }
                    AppMethodBeat.o(55939);
                    return false;
                }
            });
        }
        AppMethodBeat.o(55941);
    }

    /* access modifiers changed from: package-private */
    public final void edu() {
        AppMethodBeat.i(55942);
        if (this.yJF != 5) {
            AppMethodBeat.o(55942);
            return;
        }
        this.yJI.stopTimer();
        display();
        PlaySound.play(MMApplicationContext.getContext(), (int) R.string.hl1, new PlaySound.OnPlayCompletionListener() {
            /* class com.tencent.mm.plugin.location.ui.i.AnonymousClass4 */

            @Override // com.tencent.mm.sdk.platformtools.PlaySound.OnPlayCompletionListener
            public final void onCompletion() {
                AppMethodBeat.i(55935);
                i.this.yJJ.stopTimer();
                i.a(i.this);
                AppMethodBeat.o(55935);
            }
        });
        this.yJJ.startTimer(1000);
        AppMethodBeat.o(55942);
    }

    /* access modifiers changed from: package-private */
    public final void display() {
        AppMethodBeat.i(55943);
        if (this.yJA) {
            AppMethodBeat.o(55943);
            return;
        }
        if (g.jpz.bgy()) {
            Log.d("MicroMsg.TalkMgr", "talkRoomServer pausing");
            if (this.yJM != null) {
                this.yJM.aDh(null);
                this.yJM.edr();
            }
        }
        switch (this.yJF) {
            case 0:
                Log.d("MicroMsg.TalkMgr", "seize, state_idle, curUsername = %s", this.yJC);
                if (this.yJM != null) {
                    if (!Util.isNullOrNil(this.yJC)) {
                        this.yJM.aDh(this.yJC);
                        AppMethodBeat.o(55943);
                        return;
                    }
                    this.yJM.aDh(null);
                    AppMethodBeat.o(55943);
                    return;
                }
                break;
            case 1:
                Log.d("MicroMsg.TalkMgr", "seize, state seizing");
                if (this.yJM != null) {
                    this.yJM.eds();
                    AppMethodBeat.o(55943);
                    return;
                }
                break;
            case 2:
                Log.d("MicroMsg.TalkMgr", "seize error, curUsername = %s", this.yJC);
                if (this.yJM != null && !Util.isNullOrNil(this.yJC)) {
                    this.yJM.aDi(this.yJC);
                    AppMethodBeat.o(55943);
                    return;
                }
            case 3:
            case 5:
                Log.d("MicroMsg.TalkMgr", "seize, state success or prepare");
                if (this.yJM != null) {
                    this.yJM.edq();
                    AppMethodBeat.o(55943);
                    return;
                }
                break;
            case 4:
                Log.d("MicroMsg.TalkMgr", "seize time out");
                break;
        }
        AppMethodBeat.o(55943);
    }

    public static void edv() {
        AppMethodBeat.i(55944);
        xq xqVar = new xq();
        xqVar.edR.edU = true;
        EventCenter.instance.publish(xqVar);
        com.tencent.mm.plugin.audio.c.a.cdV();
        AppMethodBeat.o(55944);
    }

    @Override // com.tencent.mm.bh.d
    public final void bgz() {
        AppMethodBeat.i(55945);
        this.yJA = false;
        this.yJx.setEnabled(true);
        display();
        AppMethodBeat.o(55945);
    }

    @Override // com.tencent.mm.bh.d
    public final void s(String str, int i2, int i3) {
        AppMethodBeat.i(55946);
        Log.f("MicroMsg.TalkMgr", "onInitFailed %s", str);
        n.ecR().Px(3);
        this.activity.finish();
        AppMethodBeat.o(55946);
    }

    @Override // com.tencent.mm.bh.d
    public final void bgA() {
        AppMethodBeat.i(55947);
        if (this.yJF != 1) {
            AppMethodBeat.o(55947);
            return;
        }
        this.yJF = 5;
        if (Util.ticksToNow(this.yJH) < this.yJG) {
            Log.i("MicroMsg.TalkMgr", "onSeizeMicSuccess waiting to execute");
            this.yJI.startTimer(this.yJG - Util.ticksToNow(this.yJH));
            AppMethodBeat.o(55947);
            return;
        }
        edu();
        AppMethodBeat.o(55947);
    }

    @Override // com.tencent.mm.bh.d
    public final void ua(int i2) {
        AppMethodBeat.i(55948);
        Log.i("MicroMsg.TalkMgr", "onSeizeMicFailed");
        if (i2 == 340) {
            if (this.yJF != 3) {
                AppMethodBeat.o(55948);
                return;
            }
            this.yJF = 4;
        } else if (this.yJF != 1) {
            AppMethodBeat.o(55948);
            return;
        } else {
            this.yJF = 2;
        }
        display();
        PlaySound.play(MMApplicationContext.getContext(), R.string.hl7, true, null);
        AppMethodBeat.o(55948);
    }

    @Override // com.tencent.mm.bh.d
    public final void PX(String str) {
        AppMethodBeat.i(55949);
        Log.d("MicroMsg.TalkMgr", "onCurMember change %s", str);
        this.yJC = str;
        display();
        if (!Util.isNullOrNil(str)) {
            PlaySound.play(MMApplicationContext.getContext(), R.string.hl4);
            this.yJN.startTimer(100);
            AppMethodBeat.o(55949);
            return;
        }
        this.yJN.stopTimer();
        AppMethodBeat.o(55949);
    }

    @Override // com.tencent.mm.bh.d
    public final void bA(String str, String str2) {
        AppMethodBeat.i(55950);
        Log.i("MicroMsg.TalkMgr", "add %s,  del %s", str, str2);
        if (this.yJA) {
            AppMethodBeat.o(55950);
        } else {
            AppMethodBeat.o(55950);
        }
    }

    @Override // com.tencent.mm.bh.d
    public final void j(int i2, int i3, String str) {
    }

    @Override // com.tencent.mm.bh.d
    public final void bgB() {
    }

    @Override // com.tencent.mm.bh.d
    public final void bgC() {
        AppMethodBeat.i(55951);
        display();
        AppMethodBeat.o(55951);
    }

    @Override // com.tencent.mm.bh.d
    public final void bgD() {
        AppMethodBeat.i(55952);
        display();
        AppMethodBeat.o(55952);
    }

    @Override // com.tencent.mm.bh.d
    public final void bgE() {
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
    }

    static /* synthetic */ void a(i iVar) {
        AppMethodBeat.i(55953);
        if (iVar.yJF == 5) {
            iVar.yJF = 3;
            iVar.yJL.bgt();
            iVar.yJN.startTimer(100);
        }
        AppMethodBeat.o(55953);
    }
}
