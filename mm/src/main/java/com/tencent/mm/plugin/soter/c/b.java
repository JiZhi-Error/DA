package com.tencent.mm.plugin.soter.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.soter.d.i;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.soter.a.d.a;
import com.tencent.soter.a.g.b;
import java.lang.ref.WeakReference;

public final class b extends c {
    d FhA = null;
    ImageView FhB = null;
    private final int FhC = 3;
    private int FhD = 0;
    private final long FhE = 500;
    Animation FhF = null;
    Animation FhG = null;
    Runnable FhH = new Runnable() {
        /* class com.tencent.mm.plugin.soter.c.b.AnonymousClass9 */

        public final void run() {
            AppMethodBeat.i(145957);
            b.this.nnA.setTextColor(b.this.nnA.getResources().getColor(R.color.uh));
            b.this.nnA.setText(b.this.nnA.getResources().getString(R.string.hd2));
            b.this.FhB.setImageResource(R.drawable.c9l);
            AppMethodBeat.o(145957);
        }
    };
    boolean Fhz = false;
    Handler mMainHandler = new Handler(Looper.getMainLooper());
    TextView nnA = null;
    a wFx = null;

    static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(145967);
        bVar.flC();
        AppMethodBeat.o(145967);
    }

    public b(WeakReference<Activity> weakReference, j jVar, k kVar, Handler handler) {
        super(weakReference, jVar, kVar, handler);
        AppMethodBeat.i(145958);
        AppMethodBeat.o(145958);
    }

    @Override // com.tencent.mm.plugin.soter.c.c
    @TargetApi(23)
    public final void gA() {
        AppMethodBeat.i(145959);
        if (!com.tencent.soter.core.a.ld(MMApplicationContext.getContext())) {
            this.FhO.errCode = 90011;
            this.FhO.errMsg = "no fingerprint enrolled";
            flH();
        }
        try {
            if (MMApplicationContext.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0) {
                com.tencent.mm.hellhoundlib.b.a bl = c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(new String[]{"android.permission.USE_FINGERPRINT"});
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/soter/controller/SoterControllerFingerprint", "onPostCreate", "(Landroid/os/Bundle;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
                requestPermissions((String[]) bl.pG(0), ((Integer) bl.pG(1)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/controller/SoterControllerFingerprint", "onPostCreate", "(Landroid/os/Bundle;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
                AppMethodBeat.o(145959);
                return;
            }
            this.Fhz = true;
            AppMethodBeat.o(145959);
        } catch (NoSuchMethodError e2) {
            Log.i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
            this.Fhz = true;
            AppMethodBeat.o(145959);
        }
    }

    private boolean flB() {
        AppMethodBeat.i(145960);
        flD();
        Log.i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
        AnonymousClass1 r0 = new com.tencent.soter.a.b.b<com.tencent.soter.a.b.c>() {
            /* class com.tencent.mm.plugin.soter.c.b.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.soter.a.b.e] */
            @Override // com.tencent.soter.a.b.b
            public final /* synthetic */ void a(com.tencent.soter.a.b.c cVar) {
                AppMethodBeat.i(145941);
                com.tencent.soter.a.b.c cVar2 = cVar;
                Log.i("MicroMsg.SoterControllerFingerprint", "hy: update mp auth key result: errcode: %d, errmsg: %s", Integer.valueOf(cVar2.errCode), cVar2.errMsg);
                b.this.flE();
                if (cVar2.isSuccess()) {
                    b.a(b.this, false);
                    if (b.this.FhR != null) {
                        b.this.FhR.a(cVar2.RQu);
                    }
                } else {
                    i.jb(2, cVar2.errCode);
                }
                if (cVar2.errCode == 1006) {
                    Log.e("MicroMsg.SoterControllerFingerprint", "hy: model is null");
                    b.this.FhO.errCode = 90007;
                    b.this.FhO.errMsg = "auth key can not be retrieved";
                    b.this.flH();
                    AppMethodBeat.o(145941);
                } else if (cVar2.errCode == 6) {
                    Log.v("MicroMsg.SoterControllerFingerprint", "alvinluo: gen auth key failed, remove auth key");
                    com.tencent.soter.a.a.aqK(b.this.mScene);
                    b.this.FhO.errCode = 90007;
                    b.this.FhO.errMsg = "auth key generate failed";
                    b.this.flH();
                    AppMethodBeat.o(145941);
                } else {
                    if (cVar2.errCode == 1004) {
                        Log.i("MicroMsg.SoterControllerFingerprint", "hy: update auth key failed. remove auth key");
                        com.tencent.soter.a.a.aqK(b.this.mScene);
                        b.this.FhO.errCode = 90007;
                        b.this.FhO.errMsg = "auth key update error";
                        b.this.flH();
                    }
                    AppMethodBeat.o(145941);
                }
            }
        };
        Log.i("MicroMsg.SoterControllerFingerprint", "hy:mscene:" + this.mScene);
        com.tencent.soter.a.a.a(r0, false, this.mScene, this.FhP, this.FhQ);
        AppMethodBeat.o(145960);
        return false;
    }

    @Override // com.tencent.mm.plugin.soter.c.c
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(145961);
        if (i2 == 0) {
            if (strArr.length <= 0 || iArr.length <= 0 || !"android.permission.USE_FINGERPRINT".equals(strArr[0]) || iArr[0] != 0) {
                Log.w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
                this.FhO.errCode = 90002;
                this.FhO.errMsg = "user not grant to use fingerprint";
                flH();
            } else {
                Log.i("MicroMsg.SoterControllerFingerprint", "hy: permission granted");
                flB();
                this.Fhz = true;
                AppMethodBeat.o(145961);
                return;
            }
        }
        AppMethodBeat.o(145961);
    }

    private void flC() {
        AppMethodBeat.i(145962);
        this.wFx = new a();
        AnonymousClass3 r0 = new com.tencent.soter.a.b.b<com.tencent.soter.a.b.a>() {
            /* class com.tencent.mm.plugin.soter.c.b.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.soter.a.b.e] */
            @Override // com.tencent.soter.a.b.b
            public final /* synthetic */ void a(com.tencent.soter.a.b.a aVar) {
                AppMethodBeat.i(145944);
                final com.tencent.soter.a.b.a aVar2 = aVar;
                Log.i("MicroMsg.SoterControllerFingerprint", "alvinluo request authentication result errCode: %d, errMsg: %s", Integer.valueOf(aVar2.errCode), aVar2.errMsg);
                b.this.Fhz = false;
                if (aVar2.isSuccess()) {
                    b.this.mMainHandler.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.soter.c.b.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(145943);
                            T t = aVar2.RQu;
                            b.this.FhO.errCode = 0;
                            b.this.FhO.errMsg = "OK";
                            b.this.FhO.FhW = 1;
                            b.this.FhO.dZL = t.RPZ;
                            b.this.FhO.FhX = t.signature;
                            b.this.flF();
                            AppMethodBeat.o(145943);
                        }
                    }, 500);
                    AppMethodBeat.o(145944);
                    return;
                }
                i.jb(3, aVar2.errCode);
                if (aVar2.errCode == 1007 || aVar2.errCode == 1015) {
                    Log.i("MicroMsg.SoterControllerFingerprint", "hy: start authen error, maybe key invalid. remove former key and give suggestion");
                    com.tencent.soter.a.a.aqK(b.this.mScene);
                    b.this.FhO.errCode = 90007;
                    b.this.FhO.errMsg = "start fingerprint authen failed";
                } else if (aVar2.errCode == 1021) {
                    b.this.FhO.errCode = 90010;
                    b.this.FhO.errMsg = "authenticate freeze. please try again later";
                } else {
                    b.this.FhO.errCode = 90007;
                    b.this.FhO.errMsg = "authenticate error: " + aVar2.errMsg;
                }
                b.this.flH();
                AppMethodBeat.o(145944);
            }
        };
        AnonymousClass4 r1 = new com.tencent.soter.a.d.b() {
            /* class com.tencent.mm.plugin.soter.c.b.AnonymousClass4 */

            @Override // com.tencent.soter.a.d.b
            public final void fly() {
                AppMethodBeat.i(145946);
                Log.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
                b.this.Fhz = true;
                AppMethodBeat.o(145946);
            }

            @Override // com.tencent.soter.a.d.b
            public final void onAuthenticationHelp(int i2, CharSequence charSequence) {
                AppMethodBeat.i(145947);
                Log.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen help errCode: %d, errMsg:%s", Integer.valueOf(i2), charSequence);
                AppMethodBeat.o(145947);
            }

            @Override // com.tencent.soter.a.d.b
            public final void flz() {
                AppMethodBeat.i(145948);
                Log.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
                b.this.Fhz = false;
                b.this.wFx = null;
                b bVar = b.this;
                bVar.nnA.removeCallbacks(bVar.FhH);
                bVar.FhB.setImageResource(R.drawable.c9n);
                bVar.nnA.setTextColor(bVar.nnA.getResources().getColor(R.color.aaq));
                bVar.nnA.setText(bVar.nnA.getResources().getString(R.string.hd3));
                AppMethodBeat.o(145948);
            }

            @Override // com.tencent.soter.a.d.b
            public final void onAuthenticationFailed() {
                AppMethodBeat.i(145949);
                Log.w("MicroMsg.SoterControllerFingerprint", "hy: mp user trying failed");
                b bVar = b.this;
                String string = MMApplicationContext.getContext().getString(R.string.hcz);
                if (bVar.FhF == null) {
                    bVar.FhF = b.he(bVar.FhB.getContext());
                }
                if (bVar.FhG == null) {
                    bVar.FhG = b.he(bVar.FhB.getContext());
                }
                bVar.FhF.setAnimationListener(new Animation.AnimationListener(string) {
                    /* class com.tencent.mm.plugin.soter.c.b.AnonymousClass8 */
                    final /* synthetic */ CharSequence FhM;

                    {
                        this.FhM = r2;
                    }

                    public final void onAnimationStart(Animation animation) {
                        AppMethodBeat.i(145955);
                        b.this.FhB.setImageResource(R.drawable.c9m);
                        b.this.nnA.setText(this.FhM);
                        b.this.nnA.setTextColor(b.this.nnA.getResources().getColor(R.color.aes));
                        b.this.nnA.removeCallbacks(b.this.FhH);
                        AppMethodBeat.o(145955);
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(145956);
                        b.this.nnA.post(b.this.FhH);
                        AppMethodBeat.o(145956);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                bVar.nnA.startAnimation(bVar.FhF);
                bVar.FhB.startAnimation(bVar.FhG);
                b.this.mMainHandler.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.soter.c.b.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(145945);
                        b.this.Fhz = false;
                        b.a(b.this, true);
                        AppMethodBeat.o(145945);
                    }
                }, 500);
                AppMethodBeat.o(145949);
            }

            @Override // com.tencent.soter.a.d.b
            public final void onAuthenticationCancelled() {
                AppMethodBeat.i(145950);
                Log.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
                b.this.wFx = null;
                AppMethodBeat.o(145950);
            }

            @Override // com.tencent.soter.a.d.b
            public final void onAuthenticationError(int i2, CharSequence charSequence) {
                AppMethodBeat.i(145951);
                Log.e("MicroMsg.SoterControllerFingerprint", "hy: on mp authen error errCode: %d, errMsg: %s", Integer.valueOf(i2), charSequence);
                AppMethodBeat.o(145951);
            }
        };
        b.a lh = new b.a().aqL(this.mScene).lh(MMApplicationContext.getContext());
        lh.RQV.wFx = this.wFx;
        b.a bqn = lh.bqn(this.FhN.wFE);
        bqn.RQV.RQQ = null;
        bqn.RQV.RQS = r1;
        com.tencent.soter.a.a.a(r0, bqn.RQV);
        AppMethodBeat.o(145962);
    }

    @Override // com.tencent.mm.plugin.soter.c.c
    public final void onResume() {
        AppMethodBeat.i(145963);
        if (this.Fhz) {
            flB();
        }
        AppMethodBeat.o(145963);
    }

    @Override // com.tencent.mm.plugin.soter.c.c
    @TargetApi(16)
    public final void onPause() {
        AppMethodBeat.i(145964);
        if (this.Fhz && this.wFx != null) {
            this.wFx.DR(true);
        }
        if (this.FhA != null && this.FhA.isShowing()) {
            this.FhA.dismiss();
        }
        AppMethodBeat.o(145964);
    }

    public static Animation he(Context context) {
        AppMethodBeat.i(145965);
        if (context == null) {
            Log.e("MicroMsg.SoterControllerFingerprint", "hy: context is null.");
            AppMethodBeat.o(145965);
            return null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.r);
        if (-1 > 0) {
            loadAnimation.setDuration(-1);
        }
        loadAnimation.setInterpolator(new DecelerateInterpolator());
        AppMethodBeat.o(145965);
        return loadAnimation;
    }

    static /* synthetic */ void a(b bVar, boolean z) {
        boolean z2;
        AppMethodBeat.i(145966);
        if (bVar.FhA == null || !bVar.FhA.isShowing()) {
            if (bVar.nhy == null || bVar.nhy.get() == null) {
                Log.e("MicroMsg.SoterControllerFingerprint", "hy: ui released.");
                bVar.FhO.errCode = 90007;
                bVar.FhO.errMsg = "internal error occurred: ui released";
                bVar.flH();
            } else {
                if (bVar.FhA == null) {
                    Activity activity = (Activity) bVar.nhy.get();
                    d.a aVar = new d.a(activity);
                    View inflate = activity.getLayoutInflater().inflate(R.layout.all, (ViewGroup) null, false);
                    bVar.FhB = (ImageView) inflate.findViewById(R.id.d4r);
                    bVar.nnA = (TextView) inflate.findViewById(R.id.d4v);
                    ((TextView) inflate.findViewById(R.id.d4q)).setText(bVar.FhN.content);
                    aVar.hs(inflate);
                    aVar.Dk(true);
                    aVar.aoW(R.string.hcg).d(new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.soter.c.b.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(145953);
                            Log.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth by click button");
                            if (b.this.wFx != null) {
                                b.this.wFx.DR(true);
                            }
                            b.this.flG();
                            AppMethodBeat.o(145953);
                        }
                    });
                    aVar.f(new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.soter.c.b.AnonymousClass7 */

                        @TargetApi(16)
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(145954);
                            Log.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth");
                            b.this.flG();
                            AppMethodBeat.o(145954);
                        }
                    });
                    bVar.FhA = aVar.hbn();
                    bVar.FhA.setOnShowListener(new DialogInterface.OnShowListener() {
                        /* class com.tencent.mm.plugin.soter.c.b.AnonymousClass5 */

                        public final void onShow(DialogInterface dialogInterface) {
                            AppMethodBeat.i(145952);
                            b.this.FhA.getButton(-2).setTextColor(MMApplicationContext.getContext().getResources().getColor(R.color.hh));
                            AppMethodBeat.o(145952);
                        }
                    });
                    bVar.b(bVar.FhA);
                    bVar.FhA.setCanceledOnTouchOutside(false);
                }
                if (!bVar.FhA.isShowing() && bVar.nhy.get() != null && !((Activity) bVar.nhy.get()).isFinishing() && !((Activity) bVar.nhy.get()).isDestroyed()) {
                    bVar.FhA.show();
                }
            }
        }
        if (z) {
            if (Build.VERSION.SDK_INT < 23) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                Log.i("MicroMsg.SoterControllerFingerprint", "hy: req restart after fail, but no need");
                AppMethodBeat.o(145966);
                return;
            }
        }
        if (bVar.wFx != null) {
            Log.e("MicroMsg.SoterControllerFingerprint", "alvinluo mFingerprintCanceller not null, cancel and start auth by delaying 500ms.");
            bVar.wFx.DR(true);
            bVar.mMainHandler.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.soter.c.b.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(145942);
                    b.this.wFx = new a();
                    b.a(b.this);
                    AppMethodBeat.o(145942);
                }
            }, 500);
            AppMethodBeat.o(145966);
            return;
        }
        bVar.flC();
        AppMethodBeat.o(145966);
    }
}
