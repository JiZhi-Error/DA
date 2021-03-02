package com.tencent.mm.plugin.talkroom.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.bh.d;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomUI extends MMBaseActivity implements i, d {
    private TextView FRg;
    private ImageButton FRh;
    private Button FRi;
    private ImageView FRj;
    private TalkRoomVolumeMeter FRk;
    private TalkRoomAvatarsFrame FRl;
    private a FRm;
    private boolean FRn = true;
    private int FRo = 0;
    private AlphaAnimation FRp;
    private AlphaAnimation FRq;
    private AlphaAnimation FRr;
    private AlphaAnimation FRs;
    private float FRt = -1.0f;
    private float FRu = -1.0f;
    private List<String> dSU = new LinkedList();
    private q gut;
    private TextView hXK;
    private float radius = -1.0f;
    private TextView titleTv;
    private PowerManager.WakeLock wakeLock;
    private boolean yJA = true;
    private String yJB;
    private String yJC;
    private boolean yJE = false;
    private int yJF = 0;
    private long yJG = 500;
    private long yJH = 0;
    private MTimerHandler yJI = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass5 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(29593);
            Log.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess expired to execute");
            TalkRoomUI.q(TalkRoomUI.this);
            AppMethodBeat.o(29593);
            return false;
        }
    }, false);
    private MTimerHandler yJJ = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(29590);
            Log.i("MicroMsg.TalkRoomUI", "seizeMicTimer reach");
            TalkRoomUI.a(TalkRoomUI.this);
            AppMethodBeat.o(29590);
            return false;
        }
    }, false);
    private MTimerHandler yJK = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass9 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(29596);
            TalkRoomUI.m(TalkRoomUI.this);
            AppMethodBeat.o(29596);
            return false;
        }
    }, false);
    private final MTimerHandler yJN = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass10 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            short bgv;
            short s = 15;
            boolean z = false;
            AppMethodBeat.i(29597);
            if (TalkRoomUI.this.yJF == 3) {
                bgv = b.ftN().bgu();
            } else if (Util.isNullOrNil(TalkRoomUI.this.yJC)) {
                TalkRoomUI.d(TalkRoomUI.this);
                AppMethodBeat.o(29597);
                return false;
            } else {
                bgv = b.ftN().bgv();
            }
            if (bgv <= 15) {
                if (!TalkRoomUI.this.FRn) {
                    s = 0;
                }
                TalkRoomUI.f(TalkRoomUI.this);
                if (TalkRoomUI.this.FRo >= 5) {
                    TalkRoomUI talkRoomUI = TalkRoomUI.this;
                    if (!TalkRoomUI.this.FRn) {
                        z = true;
                    }
                    talkRoomUI.FRn = z;
                    TalkRoomUI.this.FRo = 0;
                }
            } else {
                s = bgv;
            }
            TalkRoomUI.d(TalkRoomUI.this);
            TalkRoomUI.this.FRk.setValue(s);
            AppMethodBeat.o(29597);
            return true;
        }
    }, true);
    private boolean yJO = true;
    private Chronometer yJT;
    private int yJU = 0;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public TalkRoomUI() {
        AppMethodBeat.i(29608);
        AppMethodBeat.o(29608);
    }

    static /* synthetic */ void d(TalkRoomUI talkRoomUI) {
        AppMethodBeat.i(29638);
        talkRoomUI.ful();
        AppMethodBeat.o(29638);
    }

    static /* synthetic */ int f(TalkRoomUI talkRoomUI) {
        int i2 = talkRoomUI.FRo;
        talkRoomUI.FRo = i2 + 1;
        return i2;
    }

    static /* synthetic */ void m(TalkRoomUI talkRoomUI) {
        AppMethodBeat.i(29640);
        talkRoomUI.display();
        AppMethodBeat.o(29640);
    }

    static /* synthetic */ void q(TalkRoomUI talkRoomUI) {
        AppMethodBeat.i(29641);
        talkRoomUI.edu();
        AppMethodBeat.o(29641);
    }

    private void ful() {
        AppMethodBeat.i(29609);
        if (this.yJF == 3 || this.yJF == 5) {
            this.FRk.setShowFlame(true);
            AppMethodBeat.o(29609);
        } else if (!Util.isNullOrNil(this.yJC)) {
            this.FRk.setShowFlame(true);
            AppMethodBeat.o(29609);
        } else {
            this.FRk.setShowFlame(false);
            AppMethodBeat.o(29609);
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29610);
        Log.d("MicroMsg.TalkRoomUI", "onCreate");
        super.onCreate(bundle);
        final String stringExtra = getIntent().getStringExtra("enter_room_username");
        Log.i("MicroMsg.TalkRoomUI", "onCreate talkRoomName : %s", stringExtra);
        Log.d("MicroMsg.TalkRoomUI", "talkRoomName %s ", stringExtra);
        this.yJB = stringExtra;
        if (Util.isNullOrNil(this.yJB)) {
            aSW("");
        } else {
            if (ab.Eq(stringExtra)) {
                List<String> Ic = v.Ic(stringExtra);
                if (Ic == null) {
                    ay.a.iDq.aL(stringExtra, "");
                } else {
                    this.dSU = Ic;
                }
            } else {
                this.dSU.clear();
                this.dSU.add(stringExtra);
                this.dSU.add(z.aTY());
            }
            new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(29592);
                    b.ftN().aw(stringExtra, 0);
                    AppMethodBeat.o(29592);
                }
            });
        }
        Log.d("MicroMsg.TalkRoomUI", "onCreate before initView");
        setContentView(aa.jQ(MMApplicationContext.getContext()).inflate(R.layout.c1g, (ViewGroup) null));
        this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(26, "TalkRoomUI Lock");
        this.titleTv = (TextView) findViewById(R.id.ir3);
        this.FRg = (TextView) findViewById(R.id.feb);
        this.hXK = (TextView) findViewById(R.id.bgc);
        this.FRi = (Button) findViewById(R.id.dy1);
        this.yJT = (Chronometer) findViewById(R.id.b2u);
        this.FRj = (ImageView) findViewById(R.id.ea2);
        this.FRm = new a(this);
        this.FRi.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(29599);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.a(TalkRoomUI.this, TalkRoomUI.this.getString(R.string.hkj), TalkRoomUI.this.getString(R.string.hki), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass11.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(29598);
                        TalkRoomUI.this.yJO = false;
                        b.ftN().fub();
                        TalkRoomUI.this.finish();
                        AppMethodBeat.o(29598);
                    }
                }, (DialogInterface.OnClickListener) null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29599);
            }
        });
        findViewById(R.id.j0c).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass12 */

            public final void onClick(View view) {
                boolean z;
                AppMethodBeat.i(29600);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                TalkRoomUI talkRoomUI = TalkRoomUI.this;
                bg.aVF();
                if (Util.nullAs((Integer) c.azQ().get(144641, (Object) null), 0) > 0) {
                    z = false;
                } else {
                    com.tencent.mm.ui.base.i iVar = new com.tencent.mm.ui.base.i(talkRoomUI, R.style.a69);
                    LinearLayout linearLayout = (LinearLayout) aa.jQ(MMApplicationContext.getContext()).inflate(R.layout.c1l, (ViewGroup) null);
                    linearLayout.setMinimumWidth(10000);
                    iVar.setCanceledOnTouchOutside(true);
                    iVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass17 */

                        public final void onDismiss(DialogInterface dialogInterface) {
                            AppMethodBeat.i(29607);
                            bg.aVF();
                            bg.aVF();
                            c.azQ().set(144641, Integer.valueOf(Util.nullAs((Integer) c.azQ().get(144641, (Object) null), 0) + 1));
                            TalkRoomUI.this.onBackPressed();
                            AppMethodBeat.o(29607);
                        }
                    });
                    iVar.setCancelable(false);
                    ((Button) linearLayout.findViewById(R.id.dt2)).setOnClickListener(new View.OnClickListener(iVar) {
                        /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass2 */
                        final /* synthetic */ com.tencent.mm.ui.base.i FRw;

                        {
                            this.FRw = r2;
                        }

                        public final void onClick(View view) {
                            AppMethodBeat.i(29591);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            this.FRw.dismiss();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(29591);
                        }
                    });
                    iVar.setContentView(linearLayout);
                    iVar.show();
                    z = true;
                }
                if (!z) {
                    TalkRoomUI.this.onBackPressed();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29600);
            }
        });
        this.FRh = (ImageButton) findViewById(R.id.fea);
        this.FRh.setEnabled(false);
        this.FRh.setImageResource(R.drawable.bou);
        this.FRh.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass13 */

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x0077, code lost:
                if (com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.a(r6.FRv, r8) == false) goto L_0x0079;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
                /*
                // Method dump skipped, instructions count: 242
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass13.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
        this.FRk = (TalkRoomVolumeMeter) findViewById(R.id.jcr);
        final AnonymousClass14 r0 = new a() {
            /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass14 */

            @Override // com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.a
            public final void fup() {
                AppMethodBeat.i(29604);
                TalkRoomUI.this.onBackPressed();
                AppMethodBeat.o(29604);
            }
        };
        findViewById(R.id.iud).setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass15 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(29605);
                a aVar = r0;
                int action = motionEvent.getAction();
                if (action == 0) {
                    aVar.deo = motionEvent.getX();
                    aVar.dep = motionEvent.getY();
                    aVar.FRA = Util.currentTicks();
                    AppMethodBeat.o(29605);
                    return true;
                }
                if (action == 1 || action == 3) {
                    float abs = Math.abs(motionEvent.getX() - aVar.deo);
                    float y = aVar.dep - motionEvent.getY();
                    if (y >= 100.0f && y / abs > 2.0f && y / ((float) Util.ticksToNow(aVar.FRA)) > 0.6f) {
                        aVar.fup();
                        AppMethodBeat.o(29605);
                        return true;
                    }
                }
                AppMethodBeat.o(29605);
                return false;
            }
        });
        this.FRl = (TalkRoomAvatarsFrame) findViewById(R.id.wx);
        this.titleTv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(29606);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                TalkRoomUI.this.onBackPressed();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29606);
            }
        });
        this.FRp = new AlphaAnimation(0.0f, 1.0f);
        this.FRp.setDuration(300);
        this.FRp.setFillAfter(true);
        this.FRq = new AlphaAnimation(1.0f, 0.0f);
        this.FRq.setDuration(300);
        this.FRq.setFillAfter(true);
        this.FRr = new AlphaAnimation(0.0f, 1.0f);
        this.FRr.setDuration(300);
        this.FRr.setFillAfter(true);
        this.FRs = new AlphaAnimation(1.0f, 0.0f);
        this.FRs.setDuration(300);
        this.FRs.setFillAfter(true);
        bg.azz().a(364, this);
        Log.d("MicroMsg.TalkRoomUI", "onCreate before getServer");
        b.ftN().a(this);
        Log.d("MicroMsg.TalkRoomUI", "onCreate end");
        AppMethodBeat.o(29610);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(29611);
        super.onResume();
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("isTalkroom", true).putExtra("classname", getClass().getName()), WeChatPermissions.PERMISSION_MM_MESSAGE());
        this.wakeLock.acquire();
        this.titleTv.setText(l.b(this, com.tencent.mm.plugin.talkroom.model.h.bC(this, this.yJB), this.titleTv.getTextSize()));
        b.ftM().FPB.FPH = true;
        b.ftM();
        Log.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        b.ftM();
        com.tencent.mm.plugin.talkroom.model.c.ftU();
        pg pgVar = new pg();
        pgVar.dVo.pause = true;
        EventCenter.instance.asyncPublish(pgVar, getMainLooper());
        Log.d("MicroMsg.TalkRoomUI", "TalkRoom req pause auto download logic");
        AppMethodBeat.o(29611);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(29612);
        super.onPause();
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), WeChatPermissions.PERMISSION_MM_MESSAGE());
        this.wakeLock.release();
        this.yJN.stopTimer();
        b.ftM().FPB.FPH = false;
        b.ftM();
        com.tencent.mm.plugin.talkroom.model.c cVar = b.ftM().FPB;
        if (cVar.yJA) {
            cVar.aST(MMApplicationContext.getContext().getString(R.string.hkp));
        } else if (!Util.isNullOrNil(cVar.yIY)) {
            String string = MMApplicationContext.getContext().getString(R.string.hkv, com.tencent.mm.model.aa.getDisplayName(cVar.yIY));
            com.tencent.mm.plugin.talkroom.model.c.ftU();
            cVar.aST(string);
        } else {
            cVar.aST(com.tencent.mm.plugin.talkroom.model.h.bC(MMApplicationContext.getContext(), b.ftN().FQv));
        }
        pg pgVar = new pg();
        pgVar.dVo.pause = false;
        EventCenter.instance.asyncPublish(pgVar, getMainLooper());
        Log.d("MicroMsg.TalkRoomUI", "TalkRoom cancel pause auto download logic");
        AppMethodBeat.o(29612);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(29613);
        b.ftN().b(this);
        bg.azz().b(364, this);
        if (this.gut != null && this.gut.isShowing()) {
            this.gut.cancel();
        }
        super.onDestroy();
        AppMethodBeat.o(29613);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void finish() {
        AppMethodBeat.i(29614);
        super.finish();
        AppMethodBeat.o(29614);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(29615);
        if (i2 == 25) {
            com.tencent.mm.plugin.audio.c.a.AX(3);
            AppMethodBeat.o(29615);
            return true;
        } else if (i2 == 24) {
            com.tencent.mm.plugin.audio.c.a.AW(3);
            AppMethodBeat.o(29615);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(29615);
            return onKeyDown;
        }
    }

    @Override // com.tencent.mm.bh.d
    public final void bgz() {
        AppMethodBeat.i(29616);
        this.yJA = false;
        this.FRh.setEnabled(true);
        this.FRh.setImageResource(R.drawable.bos);
        this.FRi.setVisibility(0);
        display();
        fun();
        fum();
        AppMethodBeat.o(29616);
    }

    @Override // com.tencent.mm.bh.d
    public final void s(String str, int i2, int i3) {
        AppMethodBeat.i(29617);
        Log.f("MicroMsg.TalkRoomUI", "onInitFailed %s", str);
        String str2 = "";
        if (i2 == 4) {
            if (i3 != -1) {
                this.yJO = false;
                finish();
                AppMethodBeat.o(29617);
                return;
            }
            str2 = getString(R.string.hkm);
        }
        aSW(str2);
        AppMethodBeat.o(29617);
    }

    @Override // com.tencent.mm.bh.d
    public final void ua(int i2) {
        AppMethodBeat.i(29618);
        Log.i("MicroMsg.TalkRoomUI", "onSeizeMicFailed");
        if (i2 == 340) {
            if (this.yJF != 3) {
                AppMethodBeat.o(29618);
                return;
            }
            this.yJF = 4;
        } else if (this.yJF != 1) {
            AppMethodBeat.o(29618);
            return;
        } else {
            this.yJF = 2;
        }
        ful();
        display();
        PlaySound.play(MMApplicationContext.getContext(), R.string.hl7, true, new PlaySound.OnPlayCompletionListener() {
            /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass4 */

            @Override // com.tencent.mm.sdk.platformtools.PlaySound.OnPlayCompletionListener
            public final void onCompletion() {
            }
        });
        AppMethodBeat.o(29618);
    }

    @Override // com.tencent.mm.bh.d
    public final void bgA() {
        AppMethodBeat.i(29619);
        Log.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess");
        if (this.yJF != 1) {
            AppMethodBeat.o(29619);
            return;
        }
        this.yJF = 5;
        if (Util.ticksToNow(this.yJH) < this.yJG) {
            Log.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess waiting to execute");
            this.yJI.startTimer(this.yJG - Util.ticksToNow(this.yJH));
            AppMethodBeat.o(29619);
            return;
        }
        edu();
        AppMethodBeat.o(29619);
    }

    private void edu() {
        AppMethodBeat.i(29620);
        if (this.yJF != 5) {
            AppMethodBeat.o(29620);
            return;
        }
        this.yJI.stopTimer();
        display();
        ful();
        PlaySound.play(MMApplicationContext.getContext(), (int) R.string.hl1, new PlaySound.OnPlayCompletionListener() {
            /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass6 */

            @Override // com.tencent.mm.sdk.platformtools.PlaySound.OnPlayCompletionListener
            public final void onCompletion() {
                AppMethodBeat.i(29594);
                TalkRoomUI.this.yJJ.stopTimer();
                TalkRoomUI.a(TalkRoomUI.this);
                AppMethodBeat.o(29594);
            }
        });
        this.yJJ.startTimer(1000);
        AppMethodBeat.o(29620);
    }

    @Override // com.tencent.mm.bh.d
    public final void j(int i2, int i3, String str) {
        AppMethodBeat.i(29621);
        Log.f("MicroMsg.TalkRoomUI", "errType %d, errCode %d, errInfo %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        aSW("");
        AppMethodBeat.o(29621);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(29622);
        if (qVar.getType() == 364 && this.gut != null && this.gut.isShowing()) {
            this.gut.cancel();
        }
        AppMethodBeat.o(29622);
    }

    private void aSW(String str) {
        AppMethodBeat.i(29623);
        if (!this.yJO) {
            Log.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
            AppMethodBeat.o(29623);
            return;
        }
        this.yJO = false;
        b.ftN().fub();
        if (Util.isNullOrNil(str)) {
            if (!NetStatusUtil.isConnected(getApplication())) {
                str = getString(R.string.hkn);
            } else {
                str = getString(R.string.hkm);
            }
        }
        if (isFinishing()) {
            AppMethodBeat.o(29623);
            return;
        }
        h.d(this, str, "", new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(29595);
                TalkRoomUI.this.finish();
                AppMethodBeat.o(29595);
            }
        });
        AppMethodBeat.o(29623);
    }

    @Override // com.tencent.mm.bh.d
    public final void PX(String str) {
        AppMethodBeat.i(29624);
        Log.d("MicroMsg.TalkRoomUI", "onCurMember %s", str);
        this.yJC = str;
        ful();
        display();
        if (!Util.isNullOrNil(str)) {
            PlaySound.play(MMApplicationContext.getContext(), (int) R.string.hl4, new PlaySound.OnPlayCompletionListener() {
                /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.AnonymousClass8 */

                @Override // com.tencent.mm.sdk.platformtools.PlaySound.OnPlayCompletionListener
                public final void onCompletion() {
                }
            });
            this.yJN.startTimer(100);
            AppMethodBeat.o(29624);
            return;
        }
        this.yJN.stopTimer();
        AppMethodBeat.o(29624);
    }

    @Override // com.tencent.mm.bh.d
    public final void bgB() {
        AppMethodBeat.i(29625);
        if (!this.yJO) {
            Log.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
            AppMethodBeat.o(29625);
            return;
        }
        this.yJO = false;
        finish();
        AppMethodBeat.o(29625);
    }

    @Override // com.tencent.mm.bh.d
    public final void bgC() {
        AppMethodBeat.i(29626);
        display();
        AppMethodBeat.o(29626);
    }

    @Override // com.tencent.mm.bh.d
    public final void bgD() {
        AppMethodBeat.i(29627);
        display();
        AppMethodBeat.o(29627);
    }

    @Override // com.tencent.mm.bh.d
    public final void bgE() {
        AppMethodBeat.i(29628);
        l(getString(R.string.hkq), R.color.ab2);
        AppMethodBeat.o(29628);
    }

    private void fum() {
        AppMethodBeat.i(29629);
        List<egs> ecY = b.ftN().ecY();
        LinkedList linkedList = new LinkedList();
        for (egs egs : ecY) {
            linkedList.add(egs.UserName);
        }
        this.FRl.setMembersList(linkedList);
        AppMethodBeat.o(29629);
    }

    @Override // com.tencent.mm.bh.d
    public final void bA(String str, String str2) {
        AppMethodBeat.i(29630);
        Log.i("MicroMsg.TalkRoomUI", "add %s,  del %s", str, str2);
        fum();
        if (this.yJA) {
            AppMethodBeat.o(29630);
            return;
        }
        fun();
        if (!Util.isNullOrNil(str)) {
            aSX(getString(R.string.hkc, new Object[]{com.tencent.mm.model.aa.getDisplayName(str)}));
            this.yJK.startTimer(3000);
        }
        if (!Util.isNullOrNil(str2)) {
            aSX(getString(R.string.hkh, new Object[]{com.tencent.mm.model.aa.getDisplayName(str2)}));
            this.yJK.startTimer(3000);
        }
        AppMethodBeat.o(29630);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void display() {
        String str;
        AppMethodBeat.i(29631);
        if (this.yJA) {
            AppMethodBeat.o(29631);
        } else if (b.ftN().FQJ) {
            l(getString(R.string.hko), R.color.ab2);
            this.FRl.setCurMemeber(null);
            this.FRj.setImageResource(R.drawable.boo);
            fuo();
            AppMethodBeat.o(29631);
        } else {
            switch (this.yJF) {
                case 0:
                    if (!Util.isNullOrNil(this.yJC)) {
                        aSX(com.tencent.mm.model.aa.getDisplayName(this.yJC));
                        this.FRl.setCurMemeber(this.yJC);
                        this.FRj.setImageResource(R.drawable.boo);
                        abt(1);
                        AppMethodBeat.o(29631);
                        return;
                    }
                    if (b.ftN().ecY().size() == 1) {
                        str = getString(R.string.hkx);
                    } else {
                        str = "";
                    }
                    l(str, R.color.ab1);
                    this.FRl.setCurMemeber(null);
                    this.FRj.setImageResource(R.drawable.boo);
                    fuo();
                    AppMethodBeat.o(29631);
                    return;
                case 1:
                    l(getString(R.string.hkb), R.color.ab1);
                    this.FRj.setImageResource(R.drawable.bor);
                    AppMethodBeat.o(29631);
                    return;
                case 2:
                    l(getString(R.string.hkr), R.color.ab2);
                    this.FRj.setImageResource(R.drawable.boq);
                    AppMethodBeat.o(29631);
                    return;
                case 3:
                case 5:
                    l(getString(R.string.hks), R.color.ab1);
                    this.FRl.setCurMemeber(z.aTY());
                    this.FRj.setImageResource(R.drawable.bop);
                    abt(2);
                    AppMethodBeat.o(29631);
                    return;
                case 4:
                    l(getString(R.string.hku), R.color.ab2);
                    this.FRj.setImageResource(R.drawable.boq);
                    fuo();
                    break;
            }
            AppMethodBeat.o(29631);
        }
    }

    private void fun() {
        AppMethodBeat.i(29632);
        int size = b.ftN().ecY().size();
        Log.i("MicroMsg.TalkRoomUI", "displayCount %d", Integer.valueOf(size));
        this.hXK.setText(String.valueOf(size));
        AppMethodBeat.o(29632);
    }

    private void aSX(String str) {
        AppMethodBeat.i(29633);
        l(l.b(this, str, this.FRg.getTextSize()), R.color.ab1);
        AppMethodBeat.o(29633);
    }

    private void l(CharSequence charSequence, int i2) {
        AppMethodBeat.i(29634);
        if (Util.isNullOrNil(charSequence.toString())) {
            this.FRg.startAnimation(this.FRs);
            AppMethodBeat.o(29634);
            return;
        }
        this.FRg.setTextColor(getResources().getColor(i2));
        this.FRg.setText(charSequence);
        this.FRg.startAnimation(this.FRr);
        AppMethodBeat.o(29634);
    }

    private void abt(int i2) {
        AppMethodBeat.i(29635);
        if (i2 == 0 || this.yJU != i2) {
            this.yJT.setVisibility(0);
            this.yJT.startAnimation(this.FRp);
            this.yJT.setBase(Util.currentTicks());
            this.yJT.start();
            this.yJU = i2;
            AppMethodBeat.o(29635);
            return;
        }
        AppMethodBeat.o(29635);
    }

    private void fuo() {
        AppMethodBeat.i(29636);
        if (this.yJU == 0) {
            AppMethodBeat.o(29636);
            return;
        }
        this.yJT.stop();
        this.yJU = 0;
        this.yJT.startAnimation(this.FRq);
        AppMethodBeat.o(29636);
    }

    abstract class a {
        long FRA;
        float deo;
        float dep;

        public abstract void fup();

        private a() {
        }

        /* synthetic */ a(TalkRoomUI talkRoomUI, byte b2) {
            this();
        }
    }

    static /* synthetic */ void a(TalkRoomUI talkRoomUI) {
        AppMethodBeat.i(29637);
        if (talkRoomUI.yJF == 5) {
            talkRoomUI.yJF = 3;
            b.ftN().bgt();
            talkRoomUI.yJN.startTimer(100);
        }
        AppMethodBeat.o(29637);
    }

    static /* synthetic */ boolean a(TalkRoomUI talkRoomUI, MotionEvent motionEvent) {
        AppMethodBeat.i(29639);
        if (talkRoomUI.radius < 0.0f) {
            talkRoomUI.radius = (((float) talkRoomUI.FRh.getWidth()) - (((float) talkRoomUI.FRh.getPaddingLeft()) * 2.0f)) / 2.0f;
            talkRoomUI.FRt = (((float) talkRoomUI.FRh.getWidth()) * 1.0f) / 2.0f;
            talkRoomUI.FRu = (((float) talkRoomUI.FRh.getHeight()) * 1.0f) / 2.0f;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (Math.sqrt((double) (((x - talkRoomUI.FRt) * (x - talkRoomUI.FRt)) + ((y - talkRoomUI.FRu) * (y - talkRoomUI.FRu)))) < ((double) talkRoomUI.radius)) {
            AppMethodBeat.o(29639);
            return true;
        }
        AppMethodBeat.o(29639);
        return false;
    }
}
