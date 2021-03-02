package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.bm;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.plugin.fingerprint.faceid.auth.FrameAnimatorImageView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.i;
import com.tencent.soter.a.g.f;

public class WalletFaceIdDialog extends i implements LifecycleObserver {
    private View jBN;
    TextView nAB;
    FrameAnimatorImageView wEI;
    TextView wEJ;
    private TextView wEK;
    ViewGroup wEL;
    private ViewGroup wEM;
    private a wEN;

    public WalletFaceIdDialog(Context context, a aVar) {
        this(context, aVar, null);
    }

    public WalletFaceIdDialog(Context context, a aVar, Bundle bundle) {
        this(context);
        AppMethodBeat.i(64278);
        this.wEN = new a(this, aVar, bundle);
        setOnShowListener(this.wEN);
        setOnDismissListener(this.wEN);
        setOnCancelListener(this.wEN);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        AppMethodBeat.o(64278);
    }

    private WalletFaceIdDialog(Context context) {
        super(context, R.style.iw);
        AppMethodBeat.i(64279);
        initView();
        AppMethodBeat.o(64279);
    }

    private WalletFaceIdDialog(Context context, int i2) {
        super(context, R.style.iw);
        AppMethodBeat.i(64280);
        initView();
        AppMethodBeat.o(64280);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64281);
        super.onCreate(bundle);
        setContentView(this.jBN);
        AppMethodBeat.o(64281);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        AppMethodBeat.i(64282);
        super.onStart();
        AppMethodBeat.o(64282);
    }

    private void initView() {
        AppMethodBeat.i(64283);
        this.jBN = View.inflate(getContext(), R.layout.a6q, null);
        this.wEM = (ViewGroup) this.jBN.findViewById(R.id.cfx);
        this.wEI = (FrameAnimatorImageView) this.jBN.findViewById(R.id.cft);
        this.nAB = (TextView) this.jBN.findViewById(R.id.cfw);
        this.wEJ = (TextView) this.jBN.findViewById(R.id.cfv);
        this.wEK = (TextView) this.jBN.findViewById(R.id.cfu);
        this.wEL = (ViewGroup) this.jBN.findViewById(R.id.cfs);
        dJI();
        this.wEK.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(64257);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.WalletFaceIdDialog", "click dismiss btn");
                a aVar = WalletFaceIdDialog.this.wEN;
                Log.i("MicroMsg.WalletFaceIdDialog", "click left btn");
                if (aVar.wET) {
                    aVar.onAuthFail(-1);
                } else {
                    aVar.onAuthCancel();
                }
                WalletFaceIdDialog.this.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64257);
            }
        });
        this.wEJ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(64258);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.WalletFaceIdDialog", "click right btn");
                a aVar = WalletFaceIdDialog.this.wEN;
                Log.i("MicroMsg.WalletFaceIdDialog", "click right btn");
                WalletFaceIdDialog walletFaceIdDialog = aVar.wEP;
                walletFaceIdDialog.wEJ.setEnabled(false);
                walletFaceIdDialog.nAB.setText(R.string.c7t);
                aVar.dJM();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64258);
            }
        });
        AppMethodBeat.o(64283);
    }

    private void dJI() {
        AppMethodBeat.i(64284);
        this.jBN.setBackgroundColor(0);
        this.nAB.setTextColor(getContext().getResources().getColor(R.color.l4));
        AppMethodBeat.o(64284);
    }

    public final void dJJ() {
        AppMethodBeat.i(64285);
        getWindow().setDimAmount(0.5f);
        this.jBN.setBackgroundResource(R.drawable.aok);
        this.wEM.setBackground(null);
        this.nAB.setTextColor(getContext().getResources().getColor(R.color.a2x));
        this.nAB.setTextSize(0, (float) getContext().getResources().getDimensionPixelSize(R.dimen.t));
        AppMethodBeat.o(64285);
    }

    public final void dJK() {
        AppMethodBeat.i(64286);
        Log.d("MicroMsg.WalletFaceIdDialog", "trigger load start");
        this.wEI.a(R.drawable.ur, new FrameAnimatorImageView.a() {
            /* class com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.FrameAnimatorImageView.a
            public final void onStop() {
                AppMethodBeat.i(64259);
                Log.d("MicroMsg.WalletFaceIdDialog", "trigger load finish");
                WalletFaceIdDialog.this.wEI.a(R.drawable.uo, null);
                AppMethodBeat.o(64259);
            }
        });
        AppMethodBeat.o(64286);
    }

    public final void d(Animation.AnimationListener animationListener) {
        AppMethodBeat.i(64287);
        this.wEI.setImageResource(R.drawable.c7f);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.bg);
        this.wEI.startAnimation(loadAnimation);
        if (animationListener != null) {
            loadAnimation.setAnimationListener(animationListener);
        }
        AppMethodBeat.o(64287);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onActivityStop() {
        AppMethodBeat.i(64288);
        Log.i("MicroMsg.WalletFaceIdDialog", "activity pause");
        a.a(this.wEN);
        dismiss();
        AppMethodBeat.o(64288);
    }

    /* access modifiers changed from: package-private */
    public static class a implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
        private Bundle jkf;
        private int retryCount = 0;
        private int scene;
        WalletFaceIdDialog wEP;
        private com.tencent.mm.plugin.fingerprint.d.a wEQ;
        private a wER;
        private int wES;
        boolean wET = false;
        private c wEU = new c() {
            /* class com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.fingerprint.d.c
            public final void gz(int i2, int i3) {
                AppMethodBeat.i(64260);
                Log.i("MicroMsg.WalletFaceIdDialog", "auth result: %s, retry: %s", Integer.valueOf(i2), Integer.valueOf(a.this.retryCount));
                switch (i2) {
                    case 0:
                        Log.i("MicroMsg.WalletFaceIdDialog", "identify success");
                        a.this.wES = i3;
                        a.c(a.this);
                        a.b(a.this, i3);
                        AppMethodBeat.o(64260);
                        return;
                    case 2000:
                    case 2001:
                    case 2002:
                    case 2005:
                    case 2007:
                    case 2009:
                    case 10308:
                        a.c(a.this);
                        if (a.this.retryCount >= 2) {
                            a.c(a.this, i2);
                            break;
                        } else {
                            a.d(a.this);
                            AppMethodBeat.o(64260);
                            return;
                        }
                }
                AppMethodBeat.o(64260);
            }
        };

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(64272);
            aVar.dJL();
            AppMethodBeat.o(64272);
        }

        static /* synthetic */ int c(a aVar) {
            int i2 = aVar.retryCount;
            aVar.retryCount = i2 + 1;
            return i2;
        }

        static /* synthetic */ void e(a aVar) {
            AppMethodBeat.i(64277);
            aVar.onAuthFail(-1);
            AppMethodBeat.o(64277);
        }

        public a(WalletFaceIdDialog walletFaceIdDialog, a aVar, Bundle bundle) {
            AppMethodBeat.i(64264);
            this.wEP = walletFaceIdDialog;
            this.wER = aVar;
            this.jkf = bundle;
            if (this.jkf != null) {
                this.scene = this.jkf.getInt("face_auth_scene");
            }
            AppMethodBeat.o(64264);
        }

        private void dJL() {
            AppMethodBeat.i(64265);
            this.wEQ.userCancel();
            AppMethodBeat.o(64265);
        }

        /* access modifiers changed from: package-private */
        public final void dJM() {
            AppMethodBeat.i(64266);
            Log.i("MicroMsg.WalletFaceIdDialog", "req faceid auth");
            if (this.wEQ == null) {
                Log.w("MicroMsg.WalletFaceIdDialog", "mgr is null");
                AppMethodBeat.o(64266);
                return;
            }
            this.wEQ.userCancel();
            if (!this.wEQ.dKc()) {
                Log.w("MicroMsg.WalletFaceIdDialog", "no faceid enrolled");
                onAuthFail(-2);
                AppMethodBeat.o(64266);
            } else if (Util.isNullOrNil(p.IML.wFE)) {
                Log.i("MicroMsg.WalletFaceIdDialog", "no challenge");
                onAuthFail(-3);
                AppMethodBeat.o(64266);
            } else {
                this.wEQ.a(this.wEU);
                this.wEP.dJK();
                AppMethodBeat.o(64266);
            }
        }

        /* access modifiers changed from: package-private */
        public final void onAuthFail(int i2) {
            AppMethodBeat.i(64267);
            Log.i("MicroMsg.WalletFaceIdDialog", "auth fail");
            if (this.wER != null) {
                this.wER.onAuthFail(i2);
                this.wER = null;
            }
            this.wEP.dismiss();
            AppMethodBeat.o(64267);
        }

        /* access modifiers changed from: package-private */
        public final void onAuthCancel() {
            AppMethodBeat.i(64268);
            Log.i("MicroMsg.WalletFaceIdDialog", "auth cancel");
            if (this.wER != null) {
                this.wER.onAuthCancel();
                this.wER = null;
            }
            AppMethodBeat.o(64268);
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(64269);
            Log.i("MicroMsg.WalletFaceIdDialog", "face id dialog dismiss");
            dJL();
            if (this.scene == 1) {
                onAuthCancel();
            }
            AppMethodBeat.o(64269);
        }

        public final void onShow(DialogInterface dialogInterface) {
            AppMethodBeat.i(64270);
            Log.i("MicroMsg.WalletFaceIdDialog", "face id dialog show");
            this.wEQ = (com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
            f.hlO().hlP();
            dJM();
            AppMethodBeat.o(64270);
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(64271);
            Log.d("MicroMsg.WalletFaceIdDialog", "face id dialog cancel");
            onAuthCancel();
            AppMethodBeat.o(64271);
        }

        static /* synthetic */ void b(a aVar, final int i2) {
            AppMethodBeat.i(64273);
            Log.i("MicroMsg.WalletFaceIdDialog", "auth success");
            if (aVar.retryCount == 0) {
                h.INSTANCE.dN(bm.CTRL_INDEX, 3);
            } else {
                h.INSTANCE.dN(bm.CTRL_INDEX, 4);
            }
            com.tencent.mm.plugin.soter.d.a.aav(0);
            WalletFaceIdDialog walletFaceIdDialog = aVar.wEP;
            walletFaceIdDialog.wEI.a(R.drawable.up, new FrameAnimatorImageView.a() {
                /* class com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog.a.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.FrameAnimatorImageView.a
                public final void onStop() {
                    AppMethodBeat.i(64261);
                    a.d(a.this, i2);
                    AppMethodBeat.o(64261);
                }
            });
            AppMethodBeat.o(64273);
        }

        static /* synthetic */ void d(a aVar) {
            AppMethodBeat.i(64274);
            aVar.wEP.dJJ();
            aVar.wEP.d(null);
            WalletFaceIdDialog walletFaceIdDialog = aVar.wEP;
            walletFaceIdDialog.wEL.setVisibility(0);
            walletFaceIdDialog.wEJ.setVisibility(0);
            walletFaceIdDialog.nAB.setText(R.string.c83);
            walletFaceIdDialog.wEJ.setText(R.string.c82);
            com.tencent.mm.plugin.soter.d.a.aav(2);
            AppMethodBeat.o(64274);
        }

        static /* synthetic */ void c(a aVar, int i2) {
            AppMethodBeat.i(64275);
            Log.w("MicroMsg.WalletFaceIdDialog", "face id failed: %s", Integer.valueOf(aVar.scene));
            aVar.wEP.dJJ();
            com.tencent.mm.plugin.soter.d.a.aav(1);
            h.INSTANCE.dN(bm.CTRL_INDEX, 5);
            aVar.wET = true;
            if (aVar.scene == 0) {
                aVar.wEP.d(null);
                WalletFaceIdDialog walletFaceIdDialog = aVar.wEP;
                walletFaceIdDialog.nAB.setText(R.string.c7v);
                walletFaceIdDialog.wEJ.setVisibility(8);
                if (i2 == 10308) {
                    com.tencent.mm.plugin.soter.d.a.e(6, -1000223, i2, "too many trial");
                    AppMethodBeat.o(64275);
                    return;
                }
                com.tencent.mm.plugin.soter.d.a.e(1000, -1000223, i2, "fingerprint error");
                AppMethodBeat.o(64275);
                return;
            }
            aVar.wEP.d(new Animation.AnimationListener() {
                /* class com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog.a.AnonymousClass3 */

                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(64262);
                    Log.d("MicroMsg.WalletFaceIdDialog", "fail anim start");
                    AppMethodBeat.o(64262);
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(64263);
                    Log.d("MicroMsg.WalletFaceIdDialog", "fail anim end");
                    a.e(a.this);
                    AppMethodBeat.o(64263);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            AppMethodBeat.o(64275);
        }

        static /* synthetic */ void d(a aVar, int i2) {
            AppMethodBeat.i(64276);
            if (aVar.wER != null) {
                aVar.wER.onAuthSuccess(i2, aVar.retryCount);
                aVar.wER = null;
            }
            aVar.wEP.dismiss();
            AppMethodBeat.o(64276);
        }
    }
}
