package com.tencent.mm.plugin.facedetect.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.facedetect.c.f;
import com.tencent.mm.plugin.facedetect.d.b;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect;
import com.tencent.mm.plugin.facedetect.views.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectUI extends MMActivity implements f, com.tencent.mm.plugin.facedetect.views.a {
    private String goe = null;
    private ServiceConnection mConnection = null;
    boolean rzT = false;
    private int sPn = -1;
    h sTC = null;
    private b sTD = null;
    private boolean sTE = false;
    private boolean sTF = false;
    private View sTG = null;
    private RelativeLayout sTH;
    FaceDetectView sTI = null;
    FaceScanRect sTJ = null;
    private TextView sTK = null;
    private Button sTL = null;
    private a sTM = null;
    private FaceTutorial sTN = null;
    private com.tencent.mm.plugin.facedetect.c.a sTO = null;
    private FaceDetectProcessService sTP = null;
    private boolean sTQ = false;
    private boolean sTR = false;
    private c sTS = null;
    private String sTT;
    private PowerManager.WakeLock wakeLock = null;

    interface a {
        void onFinish();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(FaceDetectUI faceDetectUI) {
        AppMethodBeat.i(104013);
        faceDetectUI.cTA();
        AppMethodBeat.o(104013);
    }

    static /* synthetic */ void a(FaceDetectUI faceDetectUI, String str, String str2) {
        AppMethodBeat.i(104017);
        faceDetectUI.w(90008, str, str2);
        AppMethodBeat.o(104017);
    }

    static /* synthetic */ void k(FaceDetectUI faceDetectUI) {
        AppMethodBeat.i(104018);
        faceDetectUI.cTB();
        AppMethodBeat.o(104018);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(103992);
        super.onCreate(bundle);
        getWindow().addFlags(2097280);
        this.goe = getIntent().getStringExtra("k_user_name");
        this.sPn = getIntent().getIntExtra("scene", -1);
        this.sTT = getIntent().getStringExtra("business_tips");
        FaceDetectReporter faceDetectReporter = (FaceDetectReporter) getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
        if (faceDetectReporter != null) {
            FaceDetectReporter cTe = FaceDetectReporter.cTe();
            Log.v("MicroMsg.FaceDetectReporter", "alvinluo setReporter, stack: %s", Util.getStack().toString());
            cTe.sRu = faceDetectReporter.sRu;
            cTe.sRt = faceDetectReporter.sRt;
            cTe.sessionId = faceDetectReporter.sessionId;
            cTe.sRw = faceDetectReporter.sRw;
            cTe.sRx = faceDetectReporter.sRx;
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(cTe.sessionId);
            if (cTe.sRu != null) {
                str = cTe.sRu.toString();
            } else {
                str = BuildConfig.COMMAND;
            }
            objArr[1] = str;
            Log.v("MicroMsg.FaceDetectReporter", "alvinluo sessionId: %d, info: %s", objArr);
        }
        com.tencent.mm.plugin.facedetect.c.b bVar = com.tencent.mm.plugin.facedetect.c.b.IML;
        this.sTO = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.sPn, getIntent().getExtras());
        getWindow().setFlags(1024, 1024);
        this.sTL = (Button) findViewById(R.id.ea8);
        this.sTL.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(103977);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.FaceDetectUI", "hy: user cancelled with left button");
                FaceDetectUI.a(FaceDetectUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(103977);
            }
        });
        this.sTG = findViewById(R.id.c91);
        this.sTG.setVisibility(8);
        this.sTH = (RelativeLayout) findViewById(R.id.c9r);
        this.sTJ = (FaceScanRect) findViewById(R.id.c9g);
        this.sTI = (FaceDetectView) findViewById(R.id.c9f);
        this.sTK = (TextView) findViewById(R.id.c4h);
        this.sTI.setCallback(this);
        this.sTI.setBusinessTip(this.sTT);
        FaceDetectView faceDetectView = this.sTI;
        RelativeLayout relativeLayout = this.sTH;
        ViewGroup centerHintHolder = this.sTJ.getCenterHintHolder();
        faceDetectView.sVR = relativeLayout;
        faceDetectView.sVS = centerHintHolder;
        this.sTI.setErrTextView(this.sTK);
        this.sTI.u(true, this.goe);
        this.sTJ.setOnRefreshRectListener(new FaceScanRect.b() {
            /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.facedetect.views.FaceScanRect.b
            public final void onRefresh() {
                AppMethodBeat.i(103979);
                FaceDetectView faceDetectView = FaceDetectUI.this.sTI;
                RectF rectF = new RectF((float) FaceDetectUI.this.sTJ.getLeft(), (float) FaceDetectUI.this.sTJ.getTop(), (float) FaceDetectUI.this.sTJ.getRight(), (float) FaceDetectUI.this.sTJ.getBottom());
                FaceDetectDecorView faceDetectDecorView = faceDetectView.sVQ;
                faceDetectDecorView.sVL = true;
                faceDetectDecorView.sVM = true;
                faceDetectDecorView.sVN = rectF;
                faceDetectDecorView.invalidate();
                AppMethodBeat.o(103979);
            }
        });
        this.sTJ.setVisibility(4);
        this.sTD = new b(this, (byte) 0);
        AppMethodBeat.o(103992);
    }

    private void cKu() {
        AppMethodBeat.i(103993);
        Log.i("MicroMsg.FaceDetectUI", "alvinluo unbindService, mBound: %b", Boolean.valueOf(this.sTQ));
        if (this.sTQ) {
            Log.i("MicroMsg.FaceDetectUI", "alvinluo unbindService");
            com.tencent.mm.br.c.a(this.mConnection, "tools");
            this.sTQ = false;
        }
        AppMethodBeat.o(103993);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(103994);
        super.onStart();
        Log.i("MicroMsg.FaceDetectUI", "alvinluo onStart");
        if (this.wakeLock == null) {
            this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(10, "Scan Lock");
        }
        if (!this.wakeLock.isHeld()) {
            Log.i("MicroMsg.FaceDetectUI", "alvinluo acquire wakeLock");
            this.wakeLock.acquire();
        }
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtra("key_face_service_connection_from", 2);
        this.mConnection = new ServiceConnection() {
            /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.AnonymousClass4 */

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                AppMethodBeat.i(103980);
                Log.i("MicroMsg.FaceDetectUI", "alvinluo service connected %s", componentName);
                FaceDetectUI.this.sTQ = true;
                FaceDetectUI.this.sTP = FaceDetectProcessService.this;
                com.tencent.mm.plugin.facedetect.model.f fVar = com.tencent.mm.plugin.facedetect.model.f.INSTANCE;
                FaceDetectProcessService faceDetectProcessService = FaceDetectUI.this.sTP;
                Log.i("MicroMsg.FaceDetectManager", "alvinluo bindService process name: %s, hashCode: %d", Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid()), Integer.valueOf(fVar.hashCode()));
                fVar.sQN = faceDetectProcessService;
                Log.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI service hashCode: %d", Integer.valueOf(FaceDetectUI.this.sTP.hashCode()));
                FaceDetectUI.e(FaceDetectUI.this);
                AppMethodBeat.o(103980);
            }

            public final void onServiceDisconnected(ComponentName componentName) {
                AppMethodBeat.i(103981);
                Log.i("MicroMsg.FaceDetectUI", "alvinluo service disconnected %s", componentName.toString());
                FaceDetectUI.this.sTQ = false;
                AppMethodBeat.o(103981);
            }
        };
        Log.i("MicroMsg.FaceDetectUI", "alvinluo bindService");
        com.tencent.mm.br.c.a(intent, this.mConnection, "tools");
        AppMethodBeat.o(103994);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(103995);
        super.onStop();
        Log.i("MicroMsg.FaceDetectUI", "hy: onStop, finish");
        cKu();
        if (!this.sTR) {
            a(1, 90006, "cancel with on stop", null);
            AppMethodBeat.o(103995);
            return;
        }
        finish();
        AppMethodBeat.o(103995);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a6e;
    }

    public final void a(int i2, int i3, String str, Bundle bundle) {
        AppMethodBeat.i(103998);
        Log.i("MicroMsg.FaceDetectUI", "finishWithResult errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 != 0 && i3 != 0 && com.tencent.mm.plugin.facedetect.e.a.cTF().isStarted() && com.tencent.mm.plugin.facedetect.e.a.cTF().sUx) {
            com.tencent.mm.plugin.facedetect.e.a.cTF().cTH();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("key_parcelable_reporter", FaceDetectReporter.cTe());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        b(i2, i3, str, bundle2);
        finish();
        AppMethodBeat.o(103998);
    }

    /* access modifiers changed from: package-private */
    public final void cTB() {
        AppMethodBeat.i(103999);
        if (this.rzT) {
            Log.i("MicroMsg.FaceDetectUI", "hy: start capture face");
            FaceDetectView faceDetectView = this.sTI;
            Rect rect = new Rect(this.sTJ.getLeft(), this.sTJ.getTop(), this.sTJ.getRight(), this.sTJ.getBottom());
            h.a cTd = h.cTd();
            if (cTd.type == 100) {
                AppMethodBeat.o(103999);
                return;
            }
            if (faceDetectView.sVU != null) {
                faceDetectView.sVU.cTs();
            }
            faceDetectView.idt = false;
            faceDetectView.isPaused = false;
            faceDetectView.sWa = Util.currentTicks();
            faceDetectView.sVY = cTd.sQW;
            faceDetectView.sVX = cTd.ktN;
            Log.i("MicroMsg.FaceDetectView", "carson logic");
            Log.i("MicroMsg.FaceDetectView", "item.hintStr" + cTd.ktN);
            faceDetectView.sQX = cTd.sQX;
            faceDetectView.sVV = true;
            faceDetectView.sVZ = cTd.sRa;
            faceDetectView.sVU = b.c.a(cTd);
            if (faceDetectView.sVU != null) {
                if (faceDetectView.sVR != null) {
                    faceDetectView.sVR.removeAllViews();
                }
                if (faceDetectView.sVS != null) {
                    faceDetectView.sVS.removeAllViews();
                }
                faceDetectView.sVU.a(faceDetectView.getContext(), faceDetectView.sVR, faceDetectView.sVS);
                Log.d("MicroMsg.FaceDetectView", "mBusinessTip : " + faceDetectView.sTT);
                faceDetectView.sVU.setBusinessTip(faceDetectView.sTT);
            }
            if (faceDetectView.sVP != null) {
                faceDetectView.sVP.a(rect, cTd.sQU);
            }
            faceDetectView.sVW = false;
        }
        AppMethodBeat.o(103999);
    }

    private void w(int i2, String str, String str2) {
        AppMethodBeat.i(104004);
        Log.i("MicroMsg.FaceDetectUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", 4, Integer.valueOf(i2), str);
        Bundle bundle = new Bundle();
        bundle.putString("show_err_msg", str2);
        cTC();
        a(4, i2, str, bundle);
        AppMethodBeat.o(104004);
    }

    @Override // com.tencent.mm.plugin.facedetect.views.a
    public final void A(int i2, String str) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(104005);
        Log.i("MicroMsg.FaceDetectUI", "hy: face detect result: %d", Integer.valueOf(i2));
        if (!FaceCharacteristicsResult.HH(i2)) {
            h hVar = this.sTC;
            if (hVar.rmJ >= hVar.sQS - 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i("MicroMsg.FaceDetectUI", "hy: collect data ok");
                this.sTI.mv(true);
                final Bitmap previewBm = this.sTI.getPreviewBm();
                Object[] objArr = new Object[1];
                if (previewBm != null) {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                Log.i("MicroMsg.FaceDetectUI", "alvinluo bitmap == null: %b", objArr);
                final AnonymousClass8 r0 = new a() {
                    /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.AnonymousClass8 */

                    @Override // com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.a
                    public final void onFinish() {
                        AppMethodBeat.i(103988);
                        Log.i("MicroMsg.FaceDetectUI", "alvinluo set result and return to FaceDetectPrepareUI");
                        FaceDetectUI.this.sTR = true;
                        FaceDetectUI.this.a(0, 0, "collect data ok", null);
                        AppMethodBeat.o(103988);
                    }
                };
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(103987);
                        MMApplicationContext.getContext();
                        p.l(FaceDetectUI.this.goe, previewBm);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.AnonymousClass7.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(103986);
                                if (r0 != null) {
                                    r0.onFinish();
                                }
                                AppMethodBeat.o(103986);
                            }
                        });
                        AppMethodBeat.o(103987);
                    }
                }, "save_face_bitmap");
                AppMethodBeat.o(104005);
                return;
            }
            h hVar2 = this.sTC;
            g gVar = com.tencent.mm.plugin.facedetect.model.f.INSTANCE.sQN.sSO;
            if (gVar.sQQ == null) {
                Log.e("MicroMsg.FaceDetectNativeManager", "hy: move to next motion no instance");
            } else {
                Log.i("MicroMsg.FaceDetectNativeManager", "hy: start move next motion");
                gVar.sQQ.engineNextMotion();
            }
            hVar2.rmJ++;
            int i3 = h.cTd().type;
            Log.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", Integer.valueOf(i3));
            if (h.cTd().sQZ) {
                this.sTJ.b(new Animation.AnimationListener() {
                    /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.AnonymousClass9 */

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(103989);
                        FaceDetectUI.k(FaceDetectUI.this);
                        AppMethodBeat.o(103989);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                AppMethodBeat.o(104005);
                return;
            }
            Log.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", Integer.valueOf(i3));
            cTB();
            AppMethodBeat.o(104005);
        } else if (i2 == 3) {
            w(90017, "face detect time out", str);
            AppMethodBeat.o(104005);
        } else if (i2 == 6 || i2 == 5) {
            w(90023, "face track failed or not stable", str);
            AppMethodBeat.o(104005);
        } else if (i2 == 7) {
            w(90009, "audio permission not granted", MMApplicationContext.getContext().getString(R.string.flb));
            AppMethodBeat.o(104005);
        } else {
            w(90018, "system error", str);
            AppMethodBeat.o(104005);
        }
    }

    @Override // com.tencent.mm.plugin.facedetect.views.a
    public final void HQ(int i2) {
        AppMethodBeat.i(104006);
        if (i2 == 1) {
            this.sTJ.b(null);
        }
        AppMethodBeat.o(104006);
    }

    private void cTA() {
        AppMethodBeat.i(104007);
        Log.i("MicroMsg.FaceDetectUI", "alvinluo onUserCancel");
        b.C1036b currentMotionCancelInfo = this.sTI.getCurrentMotionCancelInfo();
        a(1, currentMotionCancelInfo.errCode, currentMotionCancelInfo.errMsg, null);
        AppMethodBeat.o(104007);
    }

    private void b(int i2, int i3, String str, Bundle bundle) {
        AppMethodBeat.i(104008);
        setResult(-1, c(i2, i3, str, bundle));
        AppMethodBeat.o(104008);
    }

    private static Intent c(int i2, int i3, String str, Bundle bundle) {
        AppMethodBeat.i(104009);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("err_type", i2);
        bundle2.putInt("err_code", i3);
        bundle2.putString("err_msg", str);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Intent intent = new Intent();
        intent.putExtras(bundle2);
        AppMethodBeat.o(104009);
        return intent;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(104010);
        Log.i("MicroMsg.FaceDetectUI", "hy: current %d instance not destroyed", Integer.valueOf(hashCode()));
        super.onDestroy();
        AppMethodBeat.o(104010);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        boolean z;
        AppMethodBeat.i(104011);
        Log.i("MicroMsg.FaceDetectUI", "alvinluo finish");
        if (this.sTM != null) {
            if (this.sTM.sTs.getVisibility() != 8) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                a aVar = this.sTM;
                Log.printInfoStack("MicroMsg.FaceDetectJumper", "dismiss jumper", new Object[0]);
                a.sTu.cancel();
                if (aVar.sTs.getVisibility() == 0) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.facedetect.ui.a.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(103902);
                            a.this.sTt.setAnimationListener(new Animation.AnimationListener() {
                                /* class com.tencent.mm.plugin.facedetect.ui.a.AnonymousClass1.AnonymousClass1 */

                                public final void onAnimationStart(Animation animation) {
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    AppMethodBeat.i(103901);
                                    a.this.sTs.setVisibility(8);
                                    AppMethodBeat.o(103901);
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }
                            });
                            a.this.sTs.startAnimation(a.this.sTt);
                            AppMethodBeat.o(103902);
                        }
                    });
                }
            }
        }
        if (this.sTN != null) {
            this.sTN.dismiss();
        }
        Log.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI release");
        Log.i("MicroMsg.FaceDetectUI", "alvinluo releaseFaceDetect");
        if (!this.sTF) {
            this.sTS = null;
            this.sTF = true;
            if (this.sTD.sTY) {
                cTC();
                this.sTI.sVP.sVv.cTO();
            }
            if (this.wakeLock != null && this.wakeLock.isHeld()) {
                this.wakeLock.release();
                this.wakeLock = null;
            }
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(103978);
                    long currentTicks = Util.currentTicks();
                    Runtime.getRuntime().gc();
                    Log.i("MicroMsg.FaceDetectUI", "hy: gc uses: %d ms", Long.valueOf(Util.ticksToNow(currentTicks)));
                    AppMethodBeat.o(103978);
                }
            }, "Face_active_gc");
        }
        cKu();
        super.finish();
        AppMethodBeat.o(104011);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(104012);
        Log.i("MicroMsg.FaceDetectUI", "alvinluo onBackPressed and cancel");
        cTA();
        AppMethodBeat.o(104012);
    }

    /* access modifiers changed from: package-private */
    public class b {
        private boolean sTX;
        boolean sTY;
        private boolean sTZ;
        private final boolean sUa;

        private b() {
            this.sTX = true;
            this.sTY = false;
            this.sTZ = true;
            this.sUa = true;
        }

        /* synthetic */ b(FaceDetectUI faceDetectUI, byte b2) {
            this();
        }

        public final synchronized void cTD() {
            this.sTY = true;
        }

        /* access modifiers changed from: package-private */
        public final synchronized void reset() {
            this.sTY = false;
        }

        /* access modifiers changed from: package-private */
        public final synchronized void cTE() {
            AppMethodBeat.i(103990);
            Log.i("MicroMsg.FaceDetectUI", "toString: %s", toString());
            if (this.sTX && this.sTY && this.sTZ) {
                FaceDetectUI.this.sTH.setVisibility(0);
            }
            AppMethodBeat.o(103990);
        }

        public final String toString() {
            AppMethodBeat.i(103991);
            String str = "InitHandler{isCgiInitDone=" + this.sTX + ", isCameraInitDone=" + this.sTY + ", isLightInitDone=true, isLibraryInitDone=" + this.sTZ + '}';
            AppMethodBeat.o(103991);
            return str;
        }
    }

    private void cTC() {
        AppMethodBeat.i(104002);
        this.rzT = false;
        this.sTI.mv(false);
        Log.i("MicroMsg.FaceDetectUI", "hy: stopped scan");
        this.sTE = false;
        this.sTI.sVP.sVv.stopPreview();
        Log.i("MicroMsg.FaceDetectUI", "hy: stopped preview");
        AppMethodBeat.o(104002);
    }

    static /* synthetic */ void e(FaceDetectUI faceDetectUI) {
        AppMethodBeat.i(104014);
        Log.i("MicroMsg.FaceDetectUI", "alvinluo start");
        Log.i("MicroMsg.FaceDetectUI", "alvinluo startFaceDetect ");
        WindowManager.LayoutParams attributes = faceDetectUI.getWindow().getAttributes();
        if (attributes.screenBrightness < 0.9f) {
            attributes.screenBrightness = 0.9f;
            faceDetectUI.getWindow().setAttributes(attributes);
        }
        faceDetectUI.sTJ.sXa = FaceScanRect.a.INIT;
        FaceScanRect faceScanRect = faceDetectUI.sTJ;
        if (faceScanRect.sXa == FaceScanRect.a.OPENED) {
            Log.w("MicroMsg.FaceScanRect", "hy: already opened");
        } else {
            faceScanRect.sWZ.setVisibility(0);
            faceScanRect.sWI.setBackgroundResource(R.drawable.c77);
            faceScanRect.sWZ.startAnimation(faceScanRect.sWW);
            ImageView[] imageViewArr = faceScanRect.sWR;
            for (ImageView imageView : imageViewArr) {
                imageView.clearAnimation();
                imageView.setBackgroundColor(faceScanRect.getResources().getColor(R.color.afz));
            }
            faceScanRect.sXa = FaceScanRect.a.OPENED;
        }
        faceDetectUI.sTI.sVQ.sVK = false;
        faceDetectUI.sTJ.setVisibility(0);
        Log.d("MicroMsg.FaceDetectUI", "alvinluo %d, %d, %d, %d", Integer.valueOf(faceDetectUI.sTJ.getTop()), Integer.valueOf(faceDetectUI.sTJ.getRight()), Integer.valueOf(faceDetectUI.sTJ.getLeft()), Integer.valueOf(faceDetectUI.sTJ.getBottom()));
        faceDetectUI.sTE = true;
        faceDetectUI.rzT = false;
        faceDetectUI.sTD.reset();
        if (faceDetectUI.sTE) {
            faceDetectUI.sTS = new c() {
                /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.facedetect.views.c
                public final void HR(int i2) {
                    AppMethodBeat.i(103982);
                    Log.i("MicroMsg.FaceDetectUI", "alvinluo onPreviewInitDone: %d", Integer.valueOf(i2));
                    if (i2 == 0) {
                        FaceDetectUI.f(FaceDetectUI.this);
                        AppMethodBeat.o(103982);
                    } else if (i2 == 1) {
                        FaceDetectUI.g(FaceDetectUI.this);
                        AppMethodBeat.o(103982);
                    } else {
                        if (i2 == 2) {
                            FaceDetectUI.a(FaceDetectUI.this, "camera permission not granted", FaceDetectUI.this.getString(R.string.fl0));
                        }
                        AppMethodBeat.o(103982);
                    }
                }
            };
            Log.i("MicroMsg.FaceDetectUI", "hy: start preview");
            c cVar = faceDetectUI.sTS;
            FaceDetectView faceDetectView = faceDetectUI.sTI;
            faceDetectView.sVP.a(new c(cVar) {
                /* class com.tencent.mm.plugin.facedetect.views.FaceDetectView.AnonymousClass4 */
                final /* synthetic */ c sWk;

                {
                    this.sWk = r2;
                }

                @Override // com.tencent.mm.plugin.facedetect.views.c
                public final void HR(int i2) {
                    AppMethodBeat.i(104143);
                    Log.i("MicroMsg.FaceDetectView", "hy: camera preview init done : %d", Integer.valueOf(i2));
                    if (i2 == 0) {
                        FaceDetectView.this.sVW = false;
                        FaceDetectView.h(FaceDetectView.this);
                    }
                    if (this.sWk != null) {
                        this.sWk.HR(i2);
                    }
                    AppMethodBeat.o(104143);
                }
            });
        }
        AppMethodBeat.o(104014);
    }

    static /* synthetic */ void f(FaceDetectUI faceDetectUI) {
        AppMethodBeat.i(104015);
        Log.v("MicroMsg.FaceDetectUI", "alvinluo onPreviewDone");
        if (com.tencent.mm.plugin.facedetect.e.a.cTF().sUx) {
            com.tencent.mm.plugin.facedetect.e.a.cTF().a(faceDetectUI.sTI.getCameraRotation(), faceDetectUI.sTI.getCameraPreivewWidth(), faceDetectUI.sTI.getCameraPreviewHeight(), faceDetectUI.sTI.getCameraBestWidth(), faceDetectUI.sTI.getCameraPreviewHeight(), true);
        }
        faceDetectUI.sTI.u(false, faceDetectUI.goe);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.AnonymousClass6 */

            public final void run() {
                int length;
                int[] iArr = null;
                AppMethodBeat.i(103983);
                Log.i("MicroMsg.FaceDetectUI", "alvinluo dismiss cover and start capture");
                FaceDetectUI.this.sTD.cTD();
                FaceDetectUI.this.sTD.cTE();
                FaceDetectUI faceDetectUI = FaceDetectUI.this;
                if (h.sQT == null) {
                    h.sQT = new h();
                }
                faceDetectUI.sTC = h.sQT;
                h hVar = faceDetectUI.sTC;
                hVar.rmJ = 0;
                hVar.sQR = null;
                hVar.sQS = -1;
                h hVar2 = faceDetectUI.sTC;
                g gVar = com.tencent.mm.plugin.facedetect.model.f.INSTANCE.sQN.sSO;
                if (gVar.sQQ == null) {
                    Log.e("MicroMsg.FaceDetectNativeManager", "hy: get all motion not init");
                } else {
                    iArr = gVar.sQQ.engineGetAllMotions();
                }
                hVar2.sQR = iArr;
                if (hVar2.sQR == null) {
                    length = 0;
                } else {
                    length = hVar2.sQR.length;
                }
                hVar2.sQS = length;
                faceDetectUI.rzT = true;
                FaceDetectView faceDetectView = faceDetectUI.sTI;
                RectF rectF = new RectF((float) faceDetectUI.sTJ.getLeft(), (float) faceDetectUI.sTJ.getTop(), (float) faceDetectUI.sTJ.getRight(), (float) faceDetectUI.sTJ.getBottom());
                FaceDetectDecorView faceDetectDecorView = faceDetectView.sVQ;
                Object[] objArr = new Object[2];
                objArr[0] = rectF.toString();
                objArr[1] = faceDetectDecorView.sVN == null ? BuildConfig.COMMAND : faceDetectDecorView.sVN.toString();
                Log.i("MicroMsg.FaceDetectDecorView", "hy: trigger showCover cover: %s, old: %s", objArr);
                faceDetectDecorView.sVL = true;
                if (faceDetectDecorView.sVN == null || !faceDetectDecorView.sVN.equals(rectF)) {
                    faceDetectDecorView.sVN = rectF;
                    Log.i("MicroMsg.FaceDetectDecorView", "alvinluo invalidate %s", faceDetectDecorView.sVN.toString());
                    faceDetectDecorView.invalidate();
                }
                faceDetectUI.cTB();
                AppMethodBeat.o(103983);
            }
        }, 500);
        AppMethodBeat.o(104015);
    }

    static /* synthetic */ void g(FaceDetectUI faceDetectUI) {
        AppMethodBeat.i(104016);
        faceDetectUI.w(90016, "preview error", faceDetectUI.getString(R.string.hcu));
        AppMethodBeat.o(104016);
    }
}
