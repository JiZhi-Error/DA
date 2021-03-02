package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.a.d;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import org.json.JSONObject;

public final class r extends i implements f {
    public TextView CKk;
    public TextView CuI;
    protected com.tencent.mm.plugin.wallet_core.utils.a HCH = new com.tencent.mm.plugin.wallet_core.utils.a();
    public TextView HHd;
    public Button HRF;
    public ImageView Igh;
    public TextView IiV;
    public TextView IiW;
    public FavourLayout IiX;
    public CdnImageView IiY;
    public TextView IiZ;
    private boolean IjA = false;
    public EditHintPasswdView Ija;
    public b Ijb;
    public View Ijc;
    public View Ijd;
    public TextView Ije;
    public ImageView Ijf;
    public TextView Ijg;
    public TextView Ijh;
    public View Iji;
    public TextView Ijj;
    protected a Ijk;
    protected DialogInterface.OnClickListener Ijl;
    protected boolean Ijm = false;
    protected boolean Ijn = true;
    protected Bankcard Ijo = null;
    public TextView Ijp;
    public View Ijq;
    public TextView Ijr;
    protected int Ijs = 0;
    protected boolean Ijt = false;
    private int Iju = 0;
    private Animation Ijv = null;
    private String Ijw = "";
    private long Ijx = -1;
    private int Ijy = 0;
    private int Ijz = 0;
    protected DialogInterface.OnCancelListener XY;
    private String dDL;
    private String dUV = "";
    private boolean isPaused = false;
    public View jBN;
    public ImageView keC;
    protected View mKBLayout;
    protected MyKeyboardWindow mKeyboard;
    protected boolean ox;
    private int wFZ = 0;
    private Animation wGp;
    public ImageView zfh;

    public interface a {
        void ezC();
    }

    public interface b {
        void h(String str, boolean z, String str2);
    }

    static /* synthetic */ void b(r rVar) {
        AppMethodBeat.i(71149);
        rVar.fTd();
        AppMethodBeat.o(71149);
    }

    static /* synthetic */ void d(r rVar) {
        AppMethodBeat.i(71152);
        rVar.fSO();
        AppMethodBeat.o(71152);
    }

    static /* synthetic */ int f(r rVar) {
        int i2 = rVar.Ijz;
        rVar.Ijz = i2 + 1;
        return i2;
    }

    static /* synthetic */ void fTg() {
        AppMethodBeat.i(71150);
        fSP();
        AppMethodBeat.o(71150);
    }

    static /* synthetic */ void fTh() {
        AppMethodBeat.i(71154);
        yp(true);
        AppMethodBeat.o(71154);
    }

    static /* synthetic */ int h(r rVar) {
        int i2 = rVar.Iju;
        rVar.Iju = i2 + 1;
        return i2;
    }

    private r(Context context) {
        super(context, R.style.a6_);
        AppMethodBeat.i(71133);
        Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo WalletPwdDialog initView");
        this.jBN = View.inflate(context, R.layout.c9a, null);
        this.HRF = (Button) this.jBN.findViewById(R.id.ffp);
        this.zfh = (ImageView) this.jBN.findViewById(R.id.jht);
        this.mKeyboard = (MyKeyboardWindow) this.jBN.findViewById(R.id.ijb);
        this.mKBLayout = this.jBN.findViewById(R.id.ija);
        this.CKk = (TextView) this.jBN.findViewById(R.id.be9);
        this.IiV = (TextView) this.jBN.findViewById(R.id.ji0);
        this.CuI = (TextView) this.jBN.findViewById(R.id.ceb);
        this.HHd = (TextView) this.jBN.findViewById(R.id.g6c);
        this.HHd.getPaint().setFlags(16);
        this.IiW = (TextView) this.jBN.findViewById(R.id.a22);
        this.IiX = (FavourLayout) this.jBN.findViewById(R.id.ce9);
        this.IiY = (CdnImageView) this.jBN.findViewById(R.id.a1r);
        this.Ijc = this.jBN.findViewById(R.id.ce1);
        this.IiZ = (TextView) this.jBN.findViewById(R.id.fk9);
        this.keC = (ImageView) this.jBN.findViewById(R.id.ayl);
        this.Ijd = this.jBN.findViewById(R.id.a1p);
        this.Ije = (TextView) this.jBN.findViewById(R.id.hkz);
        a.b.c(this.keC, f.getUsername());
        this.Ija = (EditHintPasswdView) this.jBN.findViewById(R.id.dyp);
        this.Ijf = (ImageView) this.jBN.findViewById(R.id.dn9);
        this.Ijp = (TextView) this.jBN.findViewById(R.id.jho);
        this.Ijq = this.jBN.findViewById(R.id.d4l);
        this.Ijr = (TextView) this.jBN.findViewById(R.id.d4o);
        this.Igh = (ImageView) this.jBN.findViewById(R.id.d4k);
        this.Ijg = (TextView) this.jBN.findViewById(R.id.ar4);
        this.Ijh = (TextView) this.jBN.findViewById(R.id.gr1);
        this.Iji = this.jBN.findViewById(R.id.cdz);
        this.Ijj = (TextView) this.jBN.findViewById(R.id.ce8);
        this.IiX.setVisibility(8);
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        this.HRF.setEnabled(false);
        this.HRF.setTextColor(context.getResources().getColorStateList(R.color.adq));
        com.tencent.mm.wallet_core.ui.formview.a.a(this.Ija);
        this.Ija.setOnInputValidListener(new EditHintPasswdView.a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.r.AnonymousClass1 */

            @Override // com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a
            public final void onInputValidChange(boolean z) {
                AppMethodBeat.i(71122);
                if (z) {
                    r.this.fTe();
                    h.INSTANCE.a(11977, 0, 0, 0, 0, 0, 0);
                }
                AppMethodBeat.o(71122);
            }
        });
        this.Ija.requestFocus();
        TextView textView = (TextView) this.jBN.findViewById(R.id.ji0);
        if (textView != null) {
            textView.setText(ah.kQ(context));
        }
        EditText editText = (EditText) this.jBN.findViewById(R.id.jf4);
        f.setNoSystemInputOnEditText(editText);
        this.mKeyboard.setInputEditText(editText);
        if (Build.VERSION.SDK_INT >= 14) {
            d dVar = new d();
            this.mKeyboard.setSecureAccessibility(dVar);
            editText.setAccessibilityDelegate(dVar);
        }
        editText.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.r.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(71123);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!r.this.mKBLayout.isShown()) {
                    r.this.mKBLayout.setVisibility(0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71123);
            }
        });
        this.jBN.findViewById(R.id.ijc).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.r.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(71124);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (r.this.mKBLayout.isShown()) {
                    r.this.mKBLayout.setVisibility(8);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71124);
            }
        });
        fTc();
        AppMethodBeat.o(71133);
    }

    private void fTc() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(71134);
        Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo updateFingerprintMode");
        this.Iju = 0;
        this.Ijp.setVisibility(8);
        this.Ijq.setVisibility(8);
        this.Ijx = Util.currentTicks();
        an fQI = t.fQI();
        com.tencent.mm.plugin.fingerprint.d.a aVar = (com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        if (fQI == null || !aVar.dJO()) {
            z = true;
        } else {
            z = aVar.dKa();
        }
        Log.i("MicroMsg.WalletPwdCustomDialog", "hy: soter key status: %b", Boolean.valueOf(z));
        this.Ijy = 0;
        this.dUV = "";
        if (aVar == null || !aVar.dJT() || aVar.dJP()) {
            z2 = false;
        } else {
            z2 = true;
        }
        Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo isDeviceSupportFp: %b", Boolean.valueOf(z2));
        boolean z3 = aVar != null && aVar.dJO();
        if (z3 && z2 && this.Ijt && !fTf()) {
            this.Ijp.setVisibility(0);
            this.Ijp.setText(getContext().getString(R.string.ipd));
            this.Ijs = 1;
            this.Ijq.setVisibility(0);
            this.Igh.setVisibility(0);
            this.Ija.setVisibility(8);
            this.mKBLayout.setVisibility(8);
            this.IiV.setText(R.string.ip5);
            this.Ijy = 1;
            fSO();
            h.INSTANCE.a(11977, 1, 1, 0, 0, 0, 0);
        } else if (!z3 || !z2 || !this.Ijt || !fTf()) {
            this.Ijy = 0;
            this.dUV = "";
            this.Ijp.setVisibility(8);
            h.INSTANCE.a(11977, 0, 0, 0, 0, 0, 0);
        } else {
            this.Ijp.setText(getContext().getString(R.string.icq));
            this.Ijp.setVisibility(0);
            this.Ijs = 0;
            this.Ijq.setVisibility(8);
            this.Ija.setVisibility(0);
            if (!this.mKBLayout.isShown()) {
                this.mKBLayout.setVisibility(0);
            }
            this.IiV.setText(R.string.ipa);
            this.Ijy = 0;
            this.dUV = "";
            h.INSTANCE.a(11977, 1, 0, 0, 0, 0, 0);
            f.aqm(8);
        }
        Log.i("MicroMsg.WalletPwdCustomDialog", "isOpenTouch:" + z3 + ",  isDeviceSupport:" + z2 + ", use_pay_touch:" + this.Ijt + ", isForcePwdMode:" + fTf());
        this.Ijp.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.r.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(71125);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (r.this.Ijs == 0) {
                    r.a(r.this);
                } else if (r.this.Ijs == 1) {
                    r.b(r.this);
                }
                if (r.this.Ijs == 1) {
                    r.fTg();
                    if (r.c(r.this)) {
                        r.d(r.this);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71125);
            }
        });
        AppMethodBeat.o(71134);
    }

    private void fTd() {
        AppMethodBeat.i(71135);
        this.Ijp.setText(getContext().getString(R.string.icq));
        this.Ijs = 0;
        this.Ijx = Util.currentTicks();
        this.Ijq.setVisibility(8);
        this.Ija.setVisibility(0);
        if (!this.mKBLayout.isShown()) {
            this.mKBLayout.setVisibility(0);
        }
        this.IiV.setText(R.string.ipa);
        yp(true);
        this.Ijy = 0;
        this.dUV = "";
        h.INSTANCE.a(11977, 1, 0, 0, 0, 0, 1);
        f.aqm(29);
        fSP();
        AppMethodBeat.o(71135);
    }

    private void fSO() {
        AppMethodBeat.i(71136);
        Log.i("MicroMsg.WalletPwdCustomDialog", "reqFingerPrintAuth %s", Util.getStack().toString());
        com.tencent.mm.plugin.soter.d.a.flK();
        final ow owVar = new ow();
        owVar.dUQ.dNQ = this.dDL;
        owVar.dUQ.dUS = 1;
        owVar.dUQ.dUU = new Runnable() {
            /* class com.tencent.mm.plugin.wallet_core.ui.r.AnonymousClass5 */

            public final void run() {
                boolean z;
                AppMethodBeat.i(71130);
                Log.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback");
                ow.b bVar = owVar.dUR;
                if (bVar == null) {
                    r.this.Ijy = 0;
                    Log.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, result == null");
                    AppMethodBeat.o(71130);
                    return;
                }
                int i2 = bVar.errCode;
                Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo errCode: %d, errMsg: %s", Integer.valueOf(i2), bVar.errMsg);
                if (i2 == 0) {
                    Log.i("MicroMsg.WalletPwdCustomDialog", "hy: payInfo soterAuthReq: %s", bVar.dUV);
                    r.this.Ijy = 1;
                    r.this.dUV = bVar.dUV;
                    try {
                        JSONObject jSONObject = new JSONObject(r.this.dUV);
                        jSONObject.put("soter_type", "1");
                        r.this.dUV = jSONObject.toString();
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.WalletPwdCustomDialog", e2, "", new Object[0]);
                    }
                    r.f(r.this);
                    r.this.Ijr.setText("");
                    r.this.fTe();
                    h.INSTANCE.a(11977, 1, 1, 0, 1, 0, 2);
                    com.tencent.mm.plugin.soter.d.a.aau(0);
                    AppMethodBeat.o(71130);
                    return;
                }
                Log.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
                r.this.Ijy = 0;
                r.this.dUV = "";
                r.this.Ijq.setVisibility(0);
                r.this.Ijr.setTextColor(r.this.getContext().getResources().getColor(R.color.a5c));
                r.this.Ijr.setText(R.string.ico);
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                int i3 = currentTimeMillis - r.this.wFZ;
                if (i3 > 1) {
                    r.this.wFZ = currentTimeMillis;
                    r.h(r.this);
                    r.f(r.this);
                }
                h.INSTANCE.a(11977, 1, 1, 0, 1, 0, 2);
                boolean z2 = i2 == 2 || i2 == 10308;
                if (bVar.dUW == 2) {
                    z = true;
                } else {
                    z = false;
                }
                Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", Boolean.valueOf(z2), Integer.valueOf(r.this.Iju), Integer.valueOf(i2), Boolean.valueOf(z));
                if ((z || (r.this.Iju < 3 && i3 > 1)) && !z2) {
                    Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo fingerprint pay");
                    if (r.this.Ijv == null) {
                        r.this.Ijv = com.tencent.mm.ui.c.a.he(r.this.getContext());
                    }
                    r.this.Igh.setVisibility(8);
                    r.this.Ijr.setVisibility(4);
                    r.this.Ijv.reset();
                    r.this.Ijv.setAnimationListener(new Animation.AnimationListener() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.r.AnonymousClass5.AnonymousClass1 */

                        public final void onAnimationStart(Animation animation) {
                            AppMethodBeat.i(71128);
                            Log.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash start");
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.wallet_core.ui.r.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(71126);
                                    r.this.Ijr.setVisibility(0);
                                    AppMethodBeat.o(71126);
                                }
                            });
                            AppMethodBeat.o(71128);
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(71129);
                            Log.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash end");
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.wallet_core.ui.r.AnonymousClass5.AnonymousClass1.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(71127);
                                    r.this.Ijr.setVisibility(8);
                                    r.this.Igh.setVisibility(0);
                                    AppMethodBeat.o(71127);
                                }
                            });
                            AppMethodBeat.o(71129);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    r.this.Ijr.startAnimation(r.this.Ijv);
                    com.tencent.mm.plugin.soter.d.a.aau(1);
                    AppMethodBeat.o(71130);
                    return;
                }
                if (r.this.Iju >= 3 || z2) {
                    Log.v("MicroMsg.WalletPwdCustomDialog", "alvinluo change to pwd pay");
                    r.fTg();
                    r.this.Ijs = 0;
                    r.k(r.this);
                    r.this.Ijp.setVisibility(8);
                    r.this.Ijq.setVisibility(8);
                    r.this.Ijr.setVisibility(0);
                    r.this.Ijr.setText(R.string.icp);
                    r.this.Ijr.setTextColor(r.this.getContext().getResources().getColor(R.color.aeo));
                    r.this.IiV.setText(R.string.ipa);
                    r.this.Ija.setVisibility(0);
                    if (!r.this.mKBLayout.isShown()) {
                        r.this.mKBLayout.setVisibility(0);
                    }
                    com.tencent.mm.plugin.soter.d.a.aau(2);
                    r.fTh();
                }
                AppMethodBeat.o(71130);
            }
        };
        EventCenter.instance.asyncPublish(owVar, Looper.getMainLooper());
        AppMethodBeat.o(71136);
    }

    private static void fSP() {
        AppMethodBeat.i(71137);
        Log.i("MicroMsg.WalletPwdCustomDialog", "hy: send release FPManager");
        EventCenter.instance.publish(new rm());
        AppMethodBeat.o(71137);
    }

    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(71138);
        if (i2 == 4) {
            if (this.XY != null) {
                this.XY.onCancel(this);
            }
            if (this.Ijk != null) {
                this.Ijk.ezC();
            }
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(71138);
        return onKeyUp;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(71139);
        super.onCreate(bundle);
        setContentView(this.jBN);
        com.tencent.soter.a.g.f.hlO().hlP();
        AppMethodBeat.o(71139);
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.i(71140);
        super.setCancelable(z);
        this.ox = z;
        setCanceledOnTouchOutside(this.ox);
        AppMethodBeat.o(71140);
    }

    @Override // com.tencent.mm.ui.base.i
    public final void dismiss() {
        AppMethodBeat.i(71141);
        try {
            super.dismiss();
        } catch (Exception e2) {
            Log.e("MicroMsg.WalletPwdCustomDialog", "dismiss exception, e = " + e2.getMessage());
        }
        fSP();
        this.HCH.destory();
        if (this.wGp != null) {
            this.wGp.cancel();
        }
        AppMethodBeat.o(71141);
    }

    /* access modifiers changed from: protected */
    public final void fTe() {
        boolean z;
        AppMethodBeat.i(71142);
        yp(false);
        if (this.Ijl != null) {
            this.Ijl.onClick(this, 0);
        }
        dismiss();
        if (this.Ijb != null) {
            Log.i("MicroMsg.WalletPwdCustomDialog", "doOk use_touch: %s soterAuthReq: %s ", Integer.valueOf(this.Ijy), this.dUV);
            b bVar = this.Ijb;
            String text = this.Ija.getText();
            if (this.Ijy == 1) {
                z = true;
            } else {
                z = false;
            }
            bVar.h(text, z, this.dUV);
        }
        if (this.Ijx < 0) {
            Log.e("MicroMsg.WalletPwdCustomDialog", "hy: not set update mode time yet. abandon");
            AppMethodBeat.o(71142);
        } else if (this.Ijs == 0) {
            h.INSTANCE.idkeyStat(686, 0, 1, false);
            h.INSTANCE.idkeyStat(686, 1, Util.ticksToNow(this.Ijx), false);
            AppMethodBeat.o(71142);
        } else {
            if (this.Ijs == 1) {
                h.INSTANCE.idkeyStat(686, 2, 1, false);
                h.INSTANCE.idkeyStat(686, 3, Util.ticksToNow(this.Ijx), false);
            }
            AppMethodBeat.o(71142);
        }
    }

    public static r a(Context context, String str, String str2, String str3, boolean z, b bVar, final DialogInterface.OnCancelListener onCancelListener, a aVar) {
        AppMethodBeat.i(71143);
        if (((Activity) context).isFinishing()) {
            AppMethodBeat.o(71143);
            return null;
        }
        r rVar = new r(context);
        if (rVar.HRF != null) {
            rVar.Ijl = null;
            rVar.HRF.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.r.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(71131);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    r.this.fTe();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(71131);
                }
            });
        }
        if (rVar.zfh != null) {
            rVar.XY = onCancelListener;
            rVar.zfh.setVisibility(0);
            rVar.zfh.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.r.AnonymousClass7 */

                public final void onClick(View view) {
                    AppMethodBeat.i(71132);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (onCancelListener != null) {
                        onCancelListener.onCancel(null);
                    }
                    if (r.this.Ijk != null) {
                        r.this.Ijk.ezC();
                    }
                    r.this.cancel();
                    if (r.this.Ijp.isShown()) {
                        h.INSTANCE.a(11977, 1, 0, 1, 0, 0, 0);
                    } else {
                        h.INSTANCE.a(11977, 0, 0, 1, 0, 0, 0);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdCustomDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(71132);
                }
            });
        }
        rVar.setOnCancelListener(onCancelListener);
        rVar.setCancelable(true);
        rVar.CKk.setText(str);
        if (!TextUtils.isEmpty(str2)) {
            rVar.CuI.setVisibility(0);
            rVar.CuI.setText(str2);
        } else {
            rVar.CuI.setVisibility(8);
        }
        rVar.Ijd.setVisibility(8);
        rVar.Ijn = false;
        rVar.Ijk = aVar;
        if (!TextUtils.isEmpty(str3)) {
            rVar.Ijg.setVisibility(0);
            rVar.Ijg.setText(str3);
        } else {
            Log.i("MicroMsg.WalletPwdCustomDialog", "ChargeFee is null");
            rVar.Ijg.setVisibility(8);
        }
        rVar.Ijb = bVar;
        rVar.Ijt = z;
        if (!z.aUo()) {
            rVar.fTc();
        }
        rVar.show();
        com.tencent.mm.ui.base.h.a(context, rVar);
        AppMethodBeat.o(71143);
        return rVar;
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.f
    public final void fSA() {
        AppMethodBeat.i(71144);
        this.isPaused = false;
        if (z.aUo()) {
            AppMethodBeat.o(71144);
        } else {
            AppMethodBeat.o(71144);
        }
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.f
    public final void onActivityPause() {
        AppMethodBeat.i(71145);
        this.isPaused = true;
        if (z.aUo()) {
            AppMethodBeat.o(71145);
            return;
        }
        if (this.Ijs == 1) {
            fTd();
        }
        AppMethodBeat.o(71145);
    }

    private static void yp(boolean z) {
        AppMethodBeat.i(71146);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_IS_FORCE_PWD_MODE_BOOLEAN_SYNC, Boolean.valueOf(z));
        AppMethodBeat.o(71146);
    }

    private static boolean fTf() {
        boolean z;
        AppMethodBeat.i(71147);
        g.aAi();
        Object obj = g.aAh().azQ().get(ar.a.USERINFO_FINGER_PRINT_IS_FORCE_PWD_MODE_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        } else {
            z = false;
        }
        AppMethodBeat.o(71147);
        return z;
    }

    static /* synthetic */ void a(r rVar) {
        AppMethodBeat.i(71148);
        rVar.Ijp.setText(rVar.getContext().getString(R.string.ipd));
        rVar.Ijs = 1;
        rVar.Ijx = Util.currentTicks();
        rVar.Ijq.setVisibility(0);
        rVar.Igh.setVisibility(0);
        rVar.Ijr.setVisibility(8);
        rVar.Ija.setVisibility(8);
        rVar.mKBLayout.setVisibility(8);
        rVar.IiV.setText(R.string.ip5);
        yp(false);
        rVar.Ijy = 1;
        h.INSTANCE.a(11977, 1, 1, 0, 0, 0, 2);
        f.aqm(9);
        AppMethodBeat.o(71148);
    }

    static /* synthetic */ boolean c(r rVar) {
        boolean z;
        AppMethodBeat.i(71151);
        Object[] objArr = new Object[1];
        if (!rVar.isPaused) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i("MicroMsg.WalletPwdCustomDialog", "hy: is screen on: %b", objArr);
        if (!rVar.isPaused) {
            AppMethodBeat.o(71151);
            return true;
        }
        AppMethodBeat.o(71151);
        return false;
    }

    static /* synthetic */ void k(r rVar) {
        AppMethodBeat.i(71153);
        rVar.Ijx = Util.currentTicks();
        AppMethodBeat.o(71153);
    }
}
