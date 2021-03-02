package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.p;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.g.a.wn;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;

@a(3)
public class SnsOnlineVideoActivity extends MMActivity {
    private SnsInfo DsC;
    private float EAC = 1.0f;
    private int EAD = 0;
    private int EAE = 0;
    private boolean EAg = true;
    private Button EAj;
    private OnlineVideoView EHk;
    private boolean EHl = false;
    private boolean EHm;
    private boolean EHn = false;
    private boolean EHo = false;
    private boolean EHp = false;
    private boolean EHq = false;
    private boolean EHr = false;
    private boolean EHs = false;
    o.f EHt = new o.f() {
        /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass6 */

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0054, code lost:
            if (r3 != false) goto L_0x0056;
         */
        @Override // com.tencent.mm.ui.base.o.f
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m r11) {
            /*
            // Method dump skipped, instructions count: 167
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass6.onCreateMMMenu(com.tencent.mm.ui.base.m):void");
        }
    };
    private long EtT = 0;
    private boolean Etd = false;
    private int Ewx = 2;
    private float aZg = 0.0f;
    private float aZh = 0.0f;
    private String dJX;
    private String dYy = "";
    private cnb ebR;
    private String fullPath;
    private boolean guh;
    private boolean isAnimated = false;
    private boolean isPreview;
    private ImageView jUG;
    private GestureDetector mDJ;
    private VelocityTracker mVelocityTracker;
    private e oXS;
    private FrameLayout pJg;
    o.g pso = new o.g() {
        /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass7 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            boolean z = false;
            AppMethodBeat.i(203625);
            switch (menuItem.getItemId()) {
                case 1:
                    Intent intent = new Intent();
                    SnsInfo aQm = aj.faO().aQm(SnsOnlineVideoActivity.this.dJX);
                    if (aQm != null) {
                        Log.i("MicroMsg.SnsOnlineVideoActivity", "expose id " + aQm.getSnsId());
                    }
                    intent.putExtra("k_expose_msg_id", aQm == null ? 0 : aQm.getSnsId());
                    intent.putExtra("k_username", aQm == null ? "" : aQm.field_userName);
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format(e.C2115e.OyU, 33));
                    c.b(SnsOnlineVideoActivity.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(203625);
                    return;
                case 2:
                    wn wnVar = new wn();
                    wnVar.ecy.dKy = 2;
                    wnVar.ecy.ecz = 17;
                    wn.a aVar = wnVar.ecy;
                    if (SnsOnlineVideoActivity.this.scene == 0) {
                        z = true;
                    }
                    aVar.ecA = z;
                    wnVar.ecy.dJX = SnsOnlineVideoActivity.this.dJX;
                    EventCenter.instance.publish(wnVar);
                    AppMethodBeat.o(203625);
                    return;
                case 3:
                    SnsOnlineVideoActivity.this.EHl = true;
                    wn wnVar2 = new wn();
                    wnVar2.ecy.dKy = 1;
                    wnVar2.ecy.ecB = 4097;
                    wnVar2.ecy.dJX = SnsOnlineVideoActivity.this.dJX;
                    EventCenter.instance.publish(wnVar2);
                    AppMethodBeat.o(203625);
                    return;
                case 4:
                    SnsInfo aQm2 = aj.faO().aQm(SnsOnlineVideoActivity.this.dJX);
                    if (aQm2 == null) {
                        AppMethodBeat.o(203625);
                        return;
                    }
                    Intent intent2 = new Intent();
                    if (aQm2.getTimeLine().ContentObj.LoU == 15 && aQm2.getTimeLine().ContentObj.LoV.get(0) == null) {
                        Log.w("MicroMsg.SnsOnlineVideoActivity", "send sight fail, mediaObj is null");
                        AppMethodBeat.o(203625);
                        return;
                    }
                    intent2.putExtra("exdevice_open_scene_type", 2);
                    intent2.putExtra("sns_local_id", SnsOnlineVideoActivity.this.dJX);
                    intent2.putExtra("sns_send_data_ui_activity", true);
                    c.f(SnsOnlineVideoActivity.this, ".ui.chatting.ChattingSendDataToDeviceUI", intent2);
                    AppMethodBeat.o(203625);
                    return;
                case 5:
                    wn wnVar3 = new wn();
                    wnVar3.ecy.dKy = 3;
                    wnVar3.ecy.dJX = SnsOnlineVideoActivity.this.dJX;
                    EventCenter.instance.publish(wnVar3);
                    break;
            }
            AppMethodBeat.o(203625);
        }
    };
    private Bundle qaD;
    private com.tencent.mm.ui.tools.e qaE;
    private int qaF = 0;
    private int qaG = 0;
    private int qaH = 0;
    private int qaI = 0;
    private int scene = 0;
    private String sessionId = "";
    private String thumbPath;
    private boolean tiS = true;
    private RelativeLayout tjk;
    private boolean zss;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsOnlineVideoActivity() {
        AppMethodBeat.i(98958);
        AppMethodBeat.o(98958);
    }

    static /* synthetic */ void i(SnsOnlineVideoActivity snsOnlineVideoActivity) {
        AppMethodBeat.i(98971);
        snsOnlineVideoActivity.cvW();
        AppMethodBeat.o(98971);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(98959);
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        super.onCreate(bundle);
        this.qaD = bundle;
        this.thumbPath = getIntent().getStringExtra("intent_thumbpath");
        this.dJX = getIntent().getStringExtra("intent_localid");
        this.scene = getIntent().getIntExtra("intent_from_scene", -1);
        this.isPreview = getIntent().getBooleanExtra("intent_ispreview", false);
        this.guh = getIntent().getBooleanExtra("intent_ismute", false);
        this.EHo = getIntent().getBooleanExtra("intent_fromplayingvideo", false);
        this.dYy = getIntent().getStringExtra("intent_fromplayingvideo_tlobjid");
        this.sessionId = getIntent().getStringExtra("intent_session_id");
        this.EtT = getIntent().getLongExtra("intent_session_timestamp", Util.nowMilliSecond());
        this.Ewx = getIntent().getIntExtra("sns_video_scene", 2);
        this.Etd = getIntent().getBooleanExtra("KBlockAdd", false);
        String stringExtra = getIntent().getStringExtra("intent_videopath");
        Log.i("MicroMsg.SnsOnlineVideoActivity", "init data get intent info finish. thumbPath %s localId %s scene %d isPreView %b isMute %b videoPath %s", this.thumbPath, this.dJX, Integer.valueOf(this.scene), Boolean.valueOf(this.isPreview), Boolean.valueOf(this.guh), stringExtra);
        if (com.tencent.mm.q.a.aty()) {
            this.guh = true;
        }
        if (!this.isPreview) {
            try {
                this.DsC = aj.faO().aQm(this.dJX);
                this.ebR = this.DsC.getTimeLine().ContentObj.LoV.get(0);
                this.fullPath = ar.ki(aj.getAccSnsPath(), this.ebR.Id) + r.j(this.ebR);
                Log.i("MicroMsg.SnsOnlineVideoActivity", "init data finish, sns info local id %s ", this.DsC.getLocalid());
            } catch (Exception e2) {
                Log.e("MicroMsg.SnsOnlineVideoActivity", "init data exception " + e2.toString());
            }
        } else {
            this.fullPath = stringExtra;
        }
        try {
            if (d.oD(19)) {
                if (!this.isPreview) {
                    getWindow().setFlags(201327616, 201327616);
                }
                this.zss = true;
            } else {
                if (!this.isPreview) {
                    getWindow().setFlags(1024, 1024);
                }
                this.zss = false;
            }
            getWindow().addFlags(128);
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.SnsOnlineVideoActivity", e3, "", new Object[0]);
        }
        this.qaE = new com.tencent.mm.ui.tools.e(getContext());
        this.tjk = (RelativeLayout) findViewById(R.id.j6x);
        this.pJg = (FrameLayout) findViewById(R.id.j6z);
        this.EHk = com.tencent.mm.plugin.sns.ui.video.d.fkS().aRw(this.dYy);
        if (this.EHk == null) {
            this.EHo = false;
            Log.i("MicroMsg.SnsOnlineVideoActivity", "fromplayingvideo but videoview is null, reset it");
        }
        if (this.EHo) {
            com.tencent.mm.plugin.sns.ui.video.d.fkS().fkT();
            OnlineVideoView onlineVideoView = (OnlineVideoView) findViewById(R.id.j6y);
            if (this.EHk.getParent() != null) {
                ((ViewGroup) this.EHk.getParent()).removeView(this.EHk);
            }
            this.pJg.addView(this.EHk, (FrameLayout.LayoutParams) onlineVideoView.getLayoutParams());
            if (ao.gJK()) {
                this.EHk.setVideoScaleType(i.e.CONTAIN);
            } else {
                this.EHk.setVideoScaleType(i.e.DEFAULT);
            }
            OnlineVideoView onlineVideoView2 = this.EHk;
            if (onlineVideoView2.pNk == null) {
                onlineVideoView2.pNk = new com.tencent.mm.model.d();
            }
            onlineVideoView2.pNk.a(onlineVideoView2);
            Log.i("MicroMsg.SnsOnlineVideoActivity", "videoView position %s %s", Integer.valueOf(this.EHk.getCurrentPosition()), Integer.valueOf(this.EHk.getDuration()));
            if (this.EHk.getCurrentPosition() + 500 >= this.EHk.getDuration()) {
                this.EHk.aT(0, true);
            }
            onlineVideoView.setVisibility(8);
        } else {
            this.EHk = (OnlineVideoView) findViewById(R.id.j6y);
            StringBuilder sb = new StringBuilder();
            g.aAf();
            this.sessionId = sb.append(new p(com.tencent.mm.kernel.a.getUin()).toString()).append("_").append(Util.nowMilliSecond()).toString();
            this.EtT = Util.nowMilliSecond();
            this.EHk.setSessionId(this.sessionId);
            this.EHk.setSessionTimestamp(this.EtT);
            if (this.DsC != null) {
                this.EHk.setSnsId(r.Jb(this.DsC.field_snsId));
                if (!(this.DsC.getTimeLine().ContentObj == null || this.DsC.getTimeLine().ContentObj.LoV == null || this.DsC.getTimeLine().ContentObj.LoV.isEmpty())) {
                    this.EHk.setFilePath(ay.E(this.DsC.getTimeLine().ContentObj.LoV.get(0)));
                }
            }
            if (ao.gJK()) {
                this.EHk.setVideoScaleType(i.e.CONTAIN);
            } else {
                this.EHk.setVideoScaleType(i.e.DEFAULT);
            }
        }
        this.EHk.aM(this);
        this.EHk.setScene(this.Ewx);
        if (this.isPreview) {
            OnlineVideoView onlineVideoView3 = this.EHk;
            String str = this.fullPath;
            String str2 = this.thumbPath;
            onlineVideoView3.EtI = str;
            onlineVideoView3.isPreview = true;
            onlineVideoView3.tiQ.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(str2, 1.0f));
            Log.i(onlineVideoView3.TAG, "%d set preview video %s isPreview %b ", Integer.valueOf(onlineVideoView3.hashCode()), str, Boolean.valueOf(onlineVideoView3.isPreview));
        } else if (!this.EHo && this.DsC != null) {
            this.EHk.a(this.ebR, this.DsC.getLocalid(), this.DsC.getCreateTime());
        }
        this.EHk.setMute(this.guh);
        this.jUG = (ImageView) findViewById(R.id.dcj);
        if (this.isPreview) {
            this.EHk.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    int i2;
                    boolean z = false;
                    AppMethodBeat.i(98938);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    SnsOnlineVideoActivity snsOnlineVideoActivity = SnsOnlineVideoActivity.this;
                    if (SnsOnlineVideoActivity.this.EAg) {
                        i2 = 8;
                    } else {
                        i2 = 0;
                    }
                    snsOnlineVideoActivity.setTitleVisibility(i2);
                    SnsOnlineVideoActivity snsOnlineVideoActivity2 = SnsOnlineVideoActivity.this;
                    if (!SnsOnlineVideoActivity.this.EAg) {
                        z = true;
                    }
                    snsOnlineVideoActivity2.EAg = z;
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(98938);
                }
            });
        } else {
            hideTitleView();
            this.tjk.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass8 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(98946);
                    SnsOnlineVideoActivity.this.cvQ();
                    AppMethodBeat.o(98946);
                    return true;
                }
            });
        }
        this.mDJ = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass9 */

            public final boolean onContextClick(MotionEvent motionEvent) {
                AppMethodBeat.i(203627);
                b bVar = new b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onContextClick = super.onContextClick(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(203627);
                return onContextClick;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(203626);
                b bVar = new b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onDoubleTap = super.onDoubleTap(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(203626);
                return onDoubleTap;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                AppMethodBeat.i(98947);
                float rawX = motionEvent2.getRawX() - motionEvent.getRawX();
                float rawY = motionEvent2.getRawY() - motionEvent.getRawY();
                if (Math.abs(rawX) <= ((float) SnsOnlineVideoActivity.this.tjk.getWidth()) && Math.abs(rawY) <= ((float) SnsOnlineVideoActivity.this.tjk.getHeight()) && SnsOnlineVideoActivity.this.EHq) {
                    SnsOnlineVideoActivity.this.pJg.setTranslationX(rawX);
                    SnsOnlineVideoActivity.this.pJg.setTranslationY(rawY);
                }
                AppMethodBeat.o(98947);
                return true;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(98948);
                b bVar = new b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                SnsOnlineVideoActivity.this.EHs = true;
                super.onLongPress(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(98948);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(98949);
                b bVar = new b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                if (!SnsOnlineVideoActivity.this.isPreview) {
                    SnsOnlineVideoActivity.this.cvQ();
                }
                boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(98949);
                return onSingleTapUp;
            }
        });
        this.pJg.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass10 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(98950);
                GestureDetector gestureDetector = SnsOnlineVideoActivity.this.mDJ;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                if (SnsOnlineVideoActivity.this.mVelocityTracker == null) {
                    SnsOnlineVideoActivity.this.mVelocityTracker = VelocityTracker.obtain();
                }
                if (SnsOnlineVideoActivity.this.mVelocityTracker != null) {
                    SnsOnlineVideoActivity.this.mVelocityTracker.addMovement(motionEvent);
                }
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        SnsOnlineVideoActivity.this.aZg = motionEvent.getX();
                        SnsOnlineVideoActivity.this.aZh = motionEvent.getY();
                        if (SnsOnlineVideoActivity.this.EHr) {
                            SnsOnlineVideoActivity.i(SnsOnlineVideoActivity.this);
                            SnsOnlineVideoActivity.this.EHr = false;
                            break;
                        }
                        break;
                    case 1:
                        if (SnsOnlineVideoActivity.this.EHr) {
                            SnsOnlineVideoActivity.this.pJg.setPivotX((float) (SnsOnlineVideoActivity.this.tjk.getWidth() / 2));
                            SnsOnlineVideoActivity.this.pJg.setPivotY((float) (SnsOnlineVideoActivity.this.tjk.getHeight() / 2));
                            SnsOnlineVideoActivity.this.pJg.setScaleX(1.0f);
                            SnsOnlineVideoActivity.this.pJg.setScaleY(1.0f);
                            SnsOnlineVideoActivity.this.pJg.setTranslationX(0.0f);
                            SnsOnlineVideoActivity.this.pJg.setTranslationY(0.0f);
                            SnsOnlineVideoActivity.this.jUG.setAlpha(1.0f);
                            SnsOnlineVideoActivity.this.EAC = 1.0f;
                            SnsOnlineVideoActivity.this.EHq = false;
                            SnsOnlineVideoActivity.this.EHs = false;
                            AppMethodBeat.o(98950);
                            return true;
                        } else if (!SnsOnlineVideoActivity.this.EHq || SnsOnlineVideoActivity.this.EHs) {
                            SnsOnlineVideoActivity.this.EHs = false;
                            break;
                        } else {
                            SnsOnlineVideoActivity.this.cvQ();
                            SnsOnlineVideoActivity.this.EHs = false;
                            AppMethodBeat.o(98950);
                            return true;
                        }
                    case 2:
                        VelocityTracker velocityTracker = SnsOnlineVideoActivity.this.mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000);
                        int xVelocity = (int) velocityTracker.getXVelocity();
                        int yVelocity = (int) velocityTracker.getYVelocity();
                        float translationX = SnsOnlineVideoActivity.this.pJg.getTranslationX();
                        float translationY = SnsOnlineVideoActivity.this.pJg.getTranslationY();
                        SnsOnlineVideoActivity.this.EAD = (int) translationX;
                        SnsOnlineVideoActivity.this.EAE = (int) translationY;
                        Log.d("MicroMsg.SnsOnlineVideoActivity", "dancy scaled:%s, tx:%s, ty:%s, vx:%s, vy:%s", Boolean.valueOf(SnsOnlineVideoActivity.this.EHq), Float.valueOf(translationX), Float.valueOf(translationY), Integer.valueOf(xVelocity), Integer.valueOf(yVelocity));
                        if ((Math.abs(translationX) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || SnsOnlineVideoActivity.this.EHs) && !SnsOnlineVideoActivity.this.EHq) {
                            SnsOnlineVideoActivity.this.EHq = false;
                        } else {
                            float height = 1.0f - (translationY / ((float) SnsOnlineVideoActivity.this.tjk.getHeight()));
                            if (height > 1.0f) {
                                height = 1.0f;
                            }
                            if (((yVelocity > 0 && height < SnsOnlineVideoActivity.this.EAC) || yVelocity < 0) && ((double) height) >= 0.5d) {
                                Log.d("MicroMsg.SnsOnlineVideoActivity", "dancy scale:%s", Float.valueOf(height));
                                SnsOnlineVideoActivity.this.EAC = height;
                                SnsOnlineVideoActivity.this.pJg.setPivotX((float) (SnsOnlineVideoActivity.this.tjk.getWidth() / 2));
                                SnsOnlineVideoActivity.this.pJg.setPivotY((float) (SnsOnlineVideoActivity.this.tjk.getHeight() / 2));
                                SnsOnlineVideoActivity.this.pJg.setScaleX(height);
                                SnsOnlineVideoActivity.this.pJg.setScaleY(height);
                                SnsOnlineVideoActivity.this.pJg.setTranslationY(translationY);
                                SnsOnlineVideoActivity.this.jUG.setAlpha(height);
                            }
                            SnsOnlineVideoActivity.this.EHq = true;
                        }
                        if (translationY > 200.0f) {
                            SnsOnlineVideoActivity.this.EHr = false;
                        } else if (translationY > 10.0f) {
                            SnsOnlineVideoActivity.this.EHr = true;
                        }
                        if (translationY > 50.0f) {
                            SnsOnlineVideoActivity.this.pJg.setOnLongClickListener(null);
                        }
                        if (SnsOnlineVideoActivity.this.mVelocityTracker != null) {
                            SnsOnlineVideoActivity.this.mVelocityTracker.recycle();
                            SnsOnlineVideoActivity.this.mVelocityTracker = null;
                        }
                        if (SnsOnlineVideoActivity.this.EHq) {
                            AppMethodBeat.o(98950);
                            return true;
                        }
                        break;
                }
                AppMethodBeat.o(98950);
                return false;
            }
        });
        SnsInfo snsInfo = this.DsC;
        if (snsInfo == null) {
            Log.i("MicroMsg.SnsOnlineVideoActivity", "snsInfo is null, return");
        } else {
            this.EAj = (Button) findViewById(R.id.dhi);
            final TimeLineObject timeLine = snsInfo.getTimeLine();
            final be beVar = timeLine != null ? timeLine.actionInfo : null;
            bl blVar = new bl();
            ao.a(this, blVar, timeLine.actionInfo);
            if (blVar.EOf) {
                this.EAj.setVisibility(0);
                this.EAj.setText(blVar.EOg);
                this.EAj.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass13 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(98954);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (beVar.KEw == null) {
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(98954);
                            return;
                        }
                        SnsOnlineVideoActivity.this.EHm = true;
                        String go = com.tencent.mm.plugin.sns.c.a.jRu.go(beVar.KEw.jfi);
                        int i2 = 0;
                        if (timeLine.ContentObj.LoU == 1) {
                            i2 = 2;
                        } else if (timeLine.ContentObj.LoU == 3) {
                            i2 = 5;
                        } else if (timeLine.ContentObj.LoU == 15) {
                            i2 = 38;
                        }
                        if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(timeLine, SnsOnlineVideoActivity.this)) {
                            com.tencent.mm.plugin.sns.c.a.jRu.a(SnsOnlineVideoActivity.this, beVar.KEw.jfi, go, timeLine.UserName, i2, 19, 9, beVar.KEw.KEq, timeLine.Id);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(98954);
                            return;
                        }
                        switch (beVar.oUv) {
                            case 4:
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", beVar.Url);
                                com.tencent.mm.plugin.sns.c.a.jRt.i(intent, SnsOnlineVideoActivity.this);
                                com.tencent.mm.plugin.sns.c.a.jRu.a(SnsOnlineVideoActivity.this, beVar.KEw.jfi, go, timeLine.UserName, i2, 19, 1, beVar.KEw.KEq, timeLine.Id);
                                break;
                            case 5:
                                if (beVar.Scene == 1) {
                                    is isVar = new is();
                                    isVar.dNr.actionCode = 2;
                                    isVar.dNr.scene = 3;
                                    isVar.dNr.appId = beVar.KEw.jfi;
                                    isVar.dNr.context = SnsOnlineVideoActivity.this;
                                    EventCenter.instance.publish(isVar);
                                    com.tencent.mm.plugin.sns.c.a.jRu.a(SnsOnlineVideoActivity.this, beVar.KEw.jfi, go, timeLine.UserName, i2, 19, 6, beVar.KEw.KEq, timeLine.Id);
                                    break;
                                }
                                break;
                            case 6:
                                int b2 = ao.b(SnsOnlineVideoActivity.this, beVar);
                                if (b2 != 1) {
                                    if (b2 == 2) {
                                        is isVar2 = new is();
                                        isVar2.dNr.context = SnsOnlineVideoActivity.this;
                                        isVar2.dNr.actionCode = 1;
                                        isVar2.dNr.appId = beVar.KEw.jfi;
                                        isVar2.dNr.messageAction = beVar.KEw.KEs;
                                        isVar2.dNr.messageExt = beVar.KEw.KEr;
                                        isVar2.dNr.scene = 3;
                                        EventCenter.instance.publish(isVar2);
                                        com.tencent.mm.plugin.sns.c.a.jRu.a(SnsOnlineVideoActivity.this, beVar.KEw.jfi, go, timeLine.UserName, i2, 19, 3, beVar.KEw.KEq, timeLine.Id);
                                        break;
                                    }
                                } else {
                                    is isVar3 = new is();
                                    isVar3.dNr.context = SnsOnlineVideoActivity.this;
                                    isVar3.dNr.actionCode = 2;
                                    isVar3.dNr.appId = beVar.KEw.jfi;
                                    isVar3.dNr.messageAction = beVar.KEw.KEs;
                                    isVar3.dNr.messageExt = beVar.KEw.KEr;
                                    isVar3.dNr.scene = 3;
                                    EventCenter.instance.publish(isVar3);
                                    com.tencent.mm.plugin.sns.c.a.jRu.a(SnsOnlineVideoActivity.this, beVar.KEw.jfi, go, timeLine.UserName, i2, 19, 6, beVar.KEw.KEq, timeLine.Id);
                                    break;
                                }
                                break;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(98954);
                    }
                });
                if (getRequestedOrientation() != 0) {
                    fiz();
                }
            } else {
                this.EAj.setVisibility(8);
            }
        }
        if (this.isPreview) {
            if (!this.Etd) {
                addIconOptionMenu(0, R.string.tf, R.raw.icons_outlined_delete, new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass11 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(98952);
                        h.a(SnsOnlineVideoActivity.this, (int) R.string.hbv, (int) R.string.zb, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass11.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(98951);
                                SnsOnlineVideoActivity.this.EHn = true;
                                SnsOnlineVideoActivity.this.cvQ();
                                AppMethodBeat.o(98951);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass11.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        AppMethodBeat.o(98952);
                        return true;
                    }
                });
            }
            setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass12 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(98953);
                    SnsOnlineVideoActivity.this.cvQ();
                    AppMethodBeat.o(98953);
                    return true;
                }
            });
        }
        cvW();
        yh yhVar = new yh();
        yhVar.eeC.type = 1;
        EventCenter.instance.publish(yhVar);
        AppMethodBeat.o(98959);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.by5;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(98960);
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            Log.d("MicroMsg.SnsOnlineVideoActivity", "vertical orientation");
            fiz();
            AppMethodBeat.o(98960);
        } else if (configuration.orientation == 2) {
            Log.d("MicroMsg.SnsOnlineVideoActivity", "horizontal orientation");
            if (this.EAj != null && this.EAj.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.EAj.getLayoutParams();
                if (marginLayoutParams.bottomMargin != getResources().getDimensionPixelSize(R.dimen.ajy)) {
                    marginLayoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.ajy);
                    this.EAj.setLayoutParams(marginLayoutParams);
                }
            }
            AppMethodBeat.o(98960);
        } else {
            AppMethodBeat.o(98960);
        }
    }

    private void fiz() {
        AppMethodBeat.i(98961);
        boolean aA = ao.aA(this);
        int aD = ao.aD(this);
        if (this.zss && aA && this.EAj != null && this.EAj.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.EAj.getLayoutParams();
            marginLayoutParams.bottomMargin = aD + marginLayoutParams.bottomMargin;
            this.EAj.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(98961);
    }

    private void cvW() {
        AppMethodBeat.i(98962);
        if (this.isPreview) {
            Log.i("MicroMsg.SnsOnlineVideoActivity", "it is preview mode, don't register menu.");
            AppMethodBeat.o(98962);
            return;
        }
        this.pJg.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass14 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(98956);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                SnsOnlineVideoActivity.this.oXS = new com.tencent.mm.ui.widget.a.e((Context) SnsOnlineVideoActivity.this.getContext(), 1, false);
                SnsOnlineVideoActivity.this.oXS.HLX = SnsOnlineVideoActivity.this.EHt;
                SnsOnlineVideoActivity.this.oXS.HLY = SnsOnlineVideoActivity.this.pso;
                SnsOnlineVideoActivity.this.oXS.PGl = new e.b() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass14.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.a.e.b
                    public final void onDismiss() {
                        AppMethodBeat.i(98955);
                        SnsOnlineVideoActivity.this.oXS = null;
                        AppMethodBeat.o(98955);
                    }
                };
                SnsOnlineVideoActivity.this.oXS.dGm();
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(98956);
                return true;
            }
        });
        AppMethodBeat.o(98962);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(98963);
        Bundle bundle = this.qaD;
        if (!this.isAnimated) {
            this.isAnimated = true;
            if (Build.VERSION.SDK_INT >= 12) {
                this.qaF = getIntent().getIntExtra("img_gallery_top", 0);
                this.qaG = getIntent().getIntExtra("img_gallery_left", 0);
                this.qaH = getIntent().getIntExtra("img_gallery_width", 0);
                this.qaI = getIntent().getIntExtra("img_gallery_height", 0);
                if (this.qaE != null) {
                    this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
                }
                if (bundle == null) {
                    this.pJg.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass4 */

                        public final boolean onPreDraw() {
                            AppMethodBeat.i(203621);
                            SnsOnlineVideoActivity.this.pJg.getViewTreeObserver().removeOnPreDrawListener(this);
                            if (SnsOnlineVideoActivity.this.qaE != null) {
                                SnsOnlineVideoActivity.this.qaE.a(SnsOnlineVideoActivity.this.pJg, SnsOnlineVideoActivity.this.jUG, new e.c() {
                                    /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass4.AnonymousClass1 */

                                    @Override // com.tencent.mm.ui.tools.e.c
                                    public final void onAnimationStart() {
                                    }

                                    @Override // com.tencent.mm.ui.tools.e.c
                                    public final void onAnimationEnd() {
                                        AppMethodBeat.i(203620);
                                        if (SnsOnlineVideoActivity.this.EHk != null) {
                                            if (SnsOnlineVideoActivity.this.EHo) {
                                                SnsOnlineVideoActivity.this.EHk.eYd();
                                                AppMethodBeat.o(203620);
                                                return;
                                            }
                                            SnsOnlineVideoActivity.this.EHk.onResume();
                                        }
                                        AppMethodBeat.o(203620);
                                    }
                                });
                            }
                            AppMethodBeat.o(203621);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
        AppMethodBeat.o(98963);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(98964);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        if (this.EHo) {
            this.EHk.eYd();
        } else if (!this.tiS) {
            this.EHk.onResume();
        }
        this.tiS = false;
        if (this.EHl) {
            this.EHl = false;
        }
        super.onResume();
        f.e(true, true, true);
        AppMethodBeat.o(98964);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(98965);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        if (this.EHo) {
            ((SnsTimelineVideoView) this.EHk).fkO();
        } else {
            this.EHk.onPause();
        }
        if (!this.EHl) {
            Log.d("MicroMsg.SnsOnlineVideoActivity", "close Popup");
            if (this.EHm) {
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(98939);
                        SnsOnlineVideoActivity.this.finish();
                        AppMethodBeat.o(98939);
                    }
                }, 500);
            } else {
                new MMHandler().post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(203619);
                        SnsOnlineVideoActivity.this.finish();
                        AppMethodBeat.o(203619);
                    }
                });
            }
        }
        super.onPause();
        f.e(false, true, true);
        AppMethodBeat.o(98965);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(98966);
        Log.i("MicroMsg.SnsOnlineVideoActivity", "onDestroy fromPlayingVideo %s", Boolean.valueOf(this.EHo));
        if (this.EHo) {
            com.tencent.mm.plugin.sns.ui.video.d.fkS().aN(this);
            this.EHk.onDestroy();
            this.EHk.fgl();
            if (!this.EHp) {
                com.tencent.mm.plugin.sns.ui.video.d.fkS().onUIPause();
            }
        } else {
            this.EHk.onDestroy();
        }
        try {
            getWindow().clearFlags(128);
        } catch (Exception e2) {
        }
        super.onDestroy();
        if (this.DsC != null && this.DsC.getTimeLine().ContentObj.LoV.size() > 0) {
            final int playVideoDuration = this.EHk.getPlayVideoDuration();
            final String str = this.DsC.getTimeLine().ContentObj.LoV.get(0).Url;
            final int i2 = this.DsC.getTimeLine().sightFolded;
            com.tencent.f.h.RTc.aY(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass15 */

                public final void run() {
                    AppMethodBeat.i(98957);
                    PInt pInt = new PInt();
                    u.a(ay.E(SnsOnlineVideoActivity.this.DsC.getTimeLine().ContentObj.LoV.get(0)), pInt, new PInt());
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(15534, str, SnsOnlineVideoActivity.this.DsC.getTimeLine().Id, Integer.valueOf(i2), Integer.valueOf(pInt.value * 1000), Integer.valueOf(playVideoDuration * 1000));
                    AppMethodBeat.o(98957);
                }
            });
        }
        AppMethodBeat.o(98966);
    }

    public final void cvQ() {
        AppMethodBeat.i(98967);
        if (this.EAj != null && this.EAj.getVisibility() == 0) {
            this.EAj.setVisibility(8);
        }
        int width = this.tjk.getWidth();
        int height = this.tjk.getHeight();
        if (!(this.qaH == 0 || this.qaI == 0)) {
            height = (int) ((((float) width) / ((float) this.qaH)) * ((float) this.qaI));
        }
        if (this.qaE != null) {
            this.qaE.ls(width, height);
            this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
            if (((double) this.EAC) != 1.0d) {
                this.qaE.QtG = 1.0f / this.EAC;
                if (!(this.EAD == 0 && this.EAE == 0)) {
                    this.qaE.lu(((int) (((float) (this.tjk.getWidth() / 2)) * (1.0f - this.EAC))) + this.EAD, (int) (((float) ((this.tjk.getHeight() / 2) + this.EAE)) - (((float) (height / 2)) * this.EAC)));
                }
            }
            this.qaE.a(this.pJg, this.jUG, new e.c() {
                /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass5 */

                @Override // com.tencent.mm.ui.tools.e.c
                public final void onAnimationStart() {
                }

                @Override // com.tencent.mm.ui.tools.e.c
                public final void onAnimationEnd() {
                    AppMethodBeat.i(203623);
                    new MMHandler().post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(203622);
                            Intent intent = new Intent();
                            intent.putExtra("sns_update_preview_video_del", SnsOnlineVideoActivity.this.EHn);
                            SnsOnlineVideoActivity.this.setResult(-1, intent);
                            SnsOnlineVideoActivity.this.EHp = true;
                            SnsOnlineVideoActivity.this.finish();
                            SnsOnlineVideoActivity.this.overridePendingTransition(0, 0);
                            AppMethodBeat.o(203622);
                        }
                    });
                    AppMethodBeat.o(203623);
                }
            }, null);
        }
        AppMethodBeat.o(98967);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(98968);
        this.EHp = true;
        super.onBackPressed();
        AppMethodBeat.o(98968);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(98969);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Log.d("MicroMsg.SnsOnlineVideoActivity", "dispatchKeyEvent");
            cvQ();
            AppMethodBeat.o(98969);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(98969);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        SnsInfo aQm;
        AppMethodBeat.i(98970);
        Log.i("MicroMsg.SnsOnlineVideoActivity", "on activity result reqCode %d resultCode %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (4097 == i2 && -1 == i3) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            for (String str2 : Util.stringsToList(stringExtra.split(","))) {
                if (this.scene == 0 && (aQm = aj.faO().aQm(this.dJX)) != null) {
                    if (ab.Eq(str2)) {
                        vn vnVar = new vn();
                        vnVar.ebK.dRS = r.v(aQm);
                        vnVar.ebK.dHp = aQm.getLocalid();
                        EventCenter.instance.publish(vnVar);
                    } else {
                        vo voVar = new vo();
                        voVar.ebL.dRS = r.v(aQm);
                        voVar.ebL.dHp = aQm.getLocalid();
                        EventCenter.instance.publish(voVar);
                    }
                }
                TimeLineObject timeLine = this.DsC.getTimeLine();
                int aOx = r.aOx(this.fullPath);
                if (Util.isNullOrNil(this.thumbPath)) {
                    cnb cnb = this.ebR;
                    if (cnb == null) {
                        str = "";
                    } else {
                        String ki = ar.ki(aj.getAccSnsPath(), cnb.Id);
                        str = ki + r.e(cnb);
                        boolean YS = s.YS(str);
                        Log.d("MicroMsg.SnsVideoLogic", "get sns video thumb path %s [%b]", str, Boolean.valueOf(YS));
                        if (!YS) {
                            str = ki + r.n(cnb);
                            Log.i("MicroMsg.SnsVideoLogic", "get sns video thumb path %s", str);
                        }
                    }
                } else {
                    str = this.thumbPath;
                }
                this.thumbPath = str;
                Log.i("MicroMsg.SnsOnlineVideoActivity", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", str2, this.fullPath, this.thumbPath, this.ebR.MsF, Integer.valueOf(this.ebR.ERX), Integer.valueOf(aOx));
                com.tencent.mm.plugin.messenger.a.g.eir().a(this, str2, this.fullPath, this.thumbPath, 43, aOx, timeLine.statExtStr, (String) null);
                if (stringExtra2 != null) {
                    com.tencent.mm.plugin.messenger.a.g.eir().iF(stringExtra2, str2);
                }
                com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.string.dzo));
            }
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(98970);
    }
}
