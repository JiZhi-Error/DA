package com.tencent.mm.plugin.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.d;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.d;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

public class s extends i implements f {
    private static HashMap<String, Boolean> IjK = new HashMap<>();
    protected PayInfo BDB;
    public TextView CKk;
    public TextView CuI;
    protected com.tencent.mm.plugin.wallet_core.utils.a HCH = new com.tencent.mm.plugin.wallet_core.utils.a();
    protected d HGS = null;
    protected FavorPayInfo HGf = new FavorPayInfo();
    public TextView HHd;
    public ImageView Igh;
    public TextView IiV;
    public TextView IiW;
    public FavourLayout IiX;
    public CdnImageView IiY;
    public TextView IiZ;
    boolean IjA = false;
    public c IjF;
    public Button IjG;
    protected a IjH;
    protected int IjI = -1;
    private byte[] IjJ = new byte[0];
    public EditHintPasswdView Ija;
    public View Ijc;
    public View Ijd;
    public TextView Ije;
    public ImageView Ijf;
    public TextView Ijg;
    public TextView Ijh;
    public View Iji;
    public TextView Ijj;
    protected DialogInterface.OnClickListener Ijl;
    protected boolean Ijm = false;
    protected boolean Ijn = true;
    public Bankcard Ijo = null;
    public TextView Ijp;
    public View Ijq;
    public TextView Ijr;
    protected int Ijs = 0;
    protected boolean Ijt = false;
    private int Iju = 0;
    private Animation Ijv = null;
    private String Ijw = "";
    private long Ijx = -1;
    protected DialogInterface.OnCancelListener XY;
    private boolean isPaused = false;
    public View jBN;
    public ImageView keC;
    private Context mContext;
    protected View mKBLayout;
    protected MyKeyboardWindow mKeyboard;
    protected boolean ox;
    private int wFZ = 0;
    private Animation wGp;
    public ImageView zfh;

    public interface a {
        void ezC();
    }

    public interface c {
        void a(String str, FavorPayInfo favorPayInfo, boolean z);
    }

    static /* synthetic */ void d(s sVar) {
        AppMethodBeat.i(71213);
        sVar.fTd();
        AppMethodBeat.o(71213);
    }

    static /* synthetic */ void f(s sVar) {
        AppMethodBeat.i(71216);
        sVar.fSO();
        AppMethodBeat.o(71216);
    }

    static /* synthetic */ void fTj() {
        AppMethodBeat.i(71214);
        fSP();
        AppMethodBeat.o(71214);
    }

    static /* synthetic */ int h(s sVar) {
        int i2 = sVar.Iju;
        sVar.Iju = i2 + 1;
        return i2;
    }

    static /* synthetic */ void yt(boolean z) {
        AppMethodBeat.i(71218);
        yp(z);
        AppMethodBeat.o(71218);
    }

    public s(Context context) {
        super(context, R.style.a6_);
        AppMethodBeat.i(71173);
        bh(context);
        AppMethodBeat.o(71173);
    }

    /* access modifiers changed from: protected */
    public void bh(Context context) {
        AppMethodBeat.i(71174);
        Log.v("MicroMsg.WalletPwdDialog", "alvinluo WalletPwdDialog initView");
        this.mContext = context;
        hO(context);
        hP(context);
        AppMethodBeat.o(71174);
    }

    /* access modifiers changed from: protected */
    public final void hO(Context context) {
        AppMethodBeat.i(71175);
        this.jBN = View.inflate(context, fTi(), null);
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
        this.IjG = (Button) this.jBN.findViewById(R.id.c9s);
        this.IiX.setVisibility(8);
        AppMethodBeat.o(71175);
    }

    /* access modifiers changed from: protected */
    @TargetApi(14)
    public void hP(Context context) {
        AppMethodBeat.i(71176);
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.Ija);
        this.Ija.setOnInputValidListener(new EditHintPasswdView.a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.s.AnonymousClass1 */

            @Override // com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a
            public final void onInputValidChange(boolean z) {
                AppMethodBeat.i(71155);
                if (z) {
                    s.this.fTe();
                    h.INSTANCE.a(11977, 0, 0, 0, 0, 0, 0);
                }
                AppMethodBeat.o(71155);
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
            /* class com.tencent.mm.plugin.wallet_core.ui.s.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(71157);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!s.this.mKBLayout.isShown()) {
                    s.this.mKBLayout.setVisibility(0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71157);
            }
        });
        this.jBN.findViewById(R.id.ijc).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.s.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(71158);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (s.this.mKBLayout.isShown()) {
                    s.this.mKBLayout.setVisibility(8);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71158);
            }
        });
        this.IjG.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.s.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(71159);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                s.a(s.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71159);
            }
        });
        AppMethodBeat.o(71176);
    }

    private void fTd() {
        AppMethodBeat.i(71177);
        if (this.Ijs == 1) {
            this.Ijp.setText(R.string.icq);
        } else {
            this.Ijp.setText(R.string.ici);
        }
        this.Ijs = 0;
        this.Ijx = Util.currentTicks();
        this.Ijq.setVisibility(8);
        this.IjG.setVisibility(8);
        this.Ija.setVisibility(0);
        if (!this.mKBLayout.isShown()) {
            this.mKBLayout.setVisibility(0);
        }
        this.IiV.setText(R.string.ipa);
        yp(true);
        this.BDB.Ijy = 0;
        h.INSTANCE.a(11977, 1, 0, 0, 0, 0, 1);
        f.aqm(29);
        fSP();
        AppMethodBeat.o(71177);
    }

    private void fSO() {
        AppMethodBeat.i(71178);
        com.tencent.mm.plugin.soter.d.a.flK();
        final ow owVar = new ow();
        owVar.dUQ.dNQ = this.BDB.dDL;
        owVar.dUQ.dUS = 1;
        owVar.dUQ.dUU = new Runnable() {
            /* class com.tencent.mm.plugin.wallet_core.ui.s.AnonymousClass8 */

            public final void run() {
                int i2;
                String str;
                boolean z;
                AppMethodBeat.i(71168);
                Log.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback");
                ow.b bVar = owVar.dUR;
                if (bVar == null) {
                    s.this.BDB.Ijy = 0;
                    Log.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, result == null");
                    AppMethodBeat.o(71168);
                    return;
                }
                int i3 = bVar.errCode;
                Log.v("MicroMsg.WalletPwdDialog", "alvinluo errCode: %d, errMsg: %s", Integer.valueOf(i3), bVar.errMsg);
                if (i3 == 0) {
                    Log.i("MicroMsg.WalletPwdDialog", "hy: payInfo soterAuthReq: %s", bVar.dUV);
                    af.f(s.this.BDB == null ? 0 : s.this.BDB.dVv, s.this.BDB == null ? "" : s.this.BDB.dDL, 22, "");
                    s.this.BDB.Ijy = 1;
                    s.this.BDB.dNR = bVar.dNR;
                    s.this.BDB.dNS = bVar.dNS;
                    try {
                        JSONObject jSONObject = new JSONObject(((com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).dJS());
                        jSONObject.put("soter_type", t.fQI().fRq());
                        s.this.BDB.dUV = jSONObject.toString();
                    } catch (JSONException e2) {
                        Log.printErrStackTrace("MicroMsg.WalletPwdDialog", e2, "", new Object[0]);
                    }
                    s.this.BDB.dNP = bVar.dNP;
                    s.this.BDB.Ijz++;
                    s.this.Ijr.setText("");
                    s.this.fTe();
                    h.INSTANCE.a(11977, 1, 1, 0, 1, 0, 2);
                    com.tencent.mm.plugin.soter.d.a.aau(0);
                    AppMethodBeat.o(71168);
                    return;
                }
                Log.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
                if (s.this.BDB == null) {
                    i2 = 0;
                } else {
                    i2 = s.this.BDB.dVv;
                }
                if (s.this.BDB == null) {
                    str = "";
                } else {
                    str = s.this.BDB.dDL;
                }
                af.f(i2, str, 23, "");
                s.this.BDB.Ijy = 0;
                s.this.Ijq.setVisibility(0);
                s.this.Ijr.setTextColor(s.this.getContext().getResources().getColor(R.color.a5c));
                s.this.Ijr.setText(R.string.ico);
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                int i4 = currentTimeMillis - s.this.wFZ;
                if (i4 > 1) {
                    s.this.wFZ = currentTimeMillis;
                    s.h(s.this);
                    s.this.BDB.Ijz++;
                }
                h.INSTANCE.a(11977, 1, 1, 0, 1, 0, 2);
                boolean z2 = i3 == 2 || i3 == 10308;
                if (bVar.dUW == 2) {
                    z = true;
                } else {
                    z = false;
                }
                Log.v("MicroMsg.WalletPwdDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", Boolean.valueOf(z2), Integer.valueOf(s.this.Iju), Integer.valueOf(i3), Boolean.valueOf(z));
                if ((z || (s.this.Iju < 3 && i4 > 1)) && !z2) {
                    Log.v("MicroMsg.WalletPwdDialog", "alvinluo fingerprint pay");
                    if (s.this.Ijv == null) {
                        s.this.Ijv = com.tencent.mm.ui.c.a.he(s.this.getContext());
                    }
                    s.this.Igh.setVisibility(8);
                    s.this.Ijr.setVisibility(4);
                    s.this.Ijv.reset();
                    s.this.Ijv.setAnimationListener(new Animation.AnimationListener() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.s.AnonymousClass8.AnonymousClass1 */

                        public final void onAnimationStart(Animation animation) {
                            AppMethodBeat.i(71166);
                            Log.i("MicroMsg.WalletPwdDialog", "hy: on flash start");
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.wallet_core.ui.s.AnonymousClass8.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(71164);
                                    s.this.Ijr.setVisibility(0);
                                    AppMethodBeat.o(71164);
                                }
                            });
                            AppMethodBeat.o(71166);
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(71167);
                            Log.i("MicroMsg.WalletPwdDialog", "hy: on flash end");
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.wallet_core.ui.s.AnonymousClass8.AnonymousClass1.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(71165);
                                    s.this.Ijr.setVisibility(8);
                                    s.this.Igh.setVisibility(0);
                                    AppMethodBeat.o(71165);
                                }
                            });
                            AppMethodBeat.o(71167);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    s.this.Ijr.startAnimation(s.this.Ijv);
                    com.tencent.mm.plugin.soter.d.a.aau(1);
                    AppMethodBeat.o(71168);
                    return;
                }
                if (s.this.Iju >= 3 || z2) {
                    Log.v("MicroMsg.WalletPwdDialog", "alvinluo change to pwd pay");
                    s.fTj();
                    s.this.Ijs = 0;
                    s.k(s.this);
                    s.this.Ijp.setVisibility(8);
                    s.this.Ijq.setVisibility(8);
                    s.this.Ijr.setVisibility(0);
                    s.this.Ijr.setText(R.string.icp);
                    s.this.Ijr.setTextColor(s.this.getContext().getResources().getColor(R.color.aeo));
                    s.this.IiV.setText(R.string.ipa);
                    s.this.Ija.setVisibility(0);
                    if (!s.this.mKBLayout.isShown()) {
                        s.this.mKBLayout.setVisibility(0);
                    }
                    com.tencent.mm.plugin.soter.d.a.aau(2);
                    s.yt(true);
                }
                AppMethodBeat.o(71168);
            }
        };
        EventCenter.instance.publish(owVar);
        AppMethodBeat.o(71178);
    }

    private static void fSP() {
        AppMethodBeat.i(71179);
        Log.i("MicroMsg.WalletPwdDialog", "hy: send release FPManager");
        ((com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
        AppMethodBeat.o(71179);
    }

    public int fTi() {
        return R.layout.c9a;
    }

    private void yq(boolean z) {
        AppMethodBeat.i(71180);
        View findViewById = this.jBN.findViewById(R.id.a0g);
        if (findViewById != null) {
            if (z) {
                findViewById.setVisibility(0);
                this.IjA = true;
                AppMethodBeat.o(71180);
                return;
            }
            findViewById.setVisibility(8);
            this.IjA = false;
        }
        AppMethodBeat.o(71180);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(71181);
        if (i2 == 4) {
            if (this.XY != null) {
                this.XY.onCancel(this);
            }
            if (this.IjH != null) {
                this.IjH.ezC();
            }
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(71181);
        return onKeyUp;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71182);
        super.onCreate(bundle);
        setContentView(this.jBN);
        com.tencent.soter.a.g.f.hlO().hlP();
        AppMethodBeat.o(71182);
    }

    public void setCancelable(boolean z) {
        AppMethodBeat.i(71183);
        super.setCancelable(z);
        this.ox = z;
        setCanceledOnTouchOutside(this.ox);
        AppMethodBeat.o(71183);
    }

    @Override // com.tencent.mm.ui.base.i
    public void dismiss() {
        AppMethodBeat.i(71184);
        try {
            super.dismiss();
        } catch (Exception e2) {
            Log.e("MicroMsg.WalletPwdDialog", "dismiss exception, e = " + e2.getMessage());
        }
        fSP();
        this.HCH.destory();
        if (this.wGp != null) {
            this.wGp.cancel();
        }
        AppMethodBeat.o(71184);
    }

    public final void aVR(String str) {
        AppMethodBeat.i(71185);
        this.CKk.setText(str);
        AppMethodBeat.o(71185);
    }

    public final void d(String str, double d2) {
        AppMethodBeat.i(71186);
        if (!TextUtils.isEmpty(str)) {
            this.CuI.setVisibility(0);
            this.CuI.setText(str);
            if (d2 == 0.0d) {
                this.Ijn = false;
                yr(this.Ijn);
                AppMethodBeat.o(71186);
                return;
            }
            yr(this.Ijn);
            AppMethodBeat.o(71186);
            return;
        }
        this.CuI.setVisibility(8);
        this.Ijn = true;
        yr(this.Ijn);
        AppMethodBeat.o(71186);
    }

    private void aVS(String str) {
        AppMethodBeat.i(71187);
        if (!TextUtils.isEmpty(str)) {
            this.Ijg.setVisibility(0);
            this.Ijg.setText(str);
            AppMethodBeat.o(71187);
            return;
        }
        Log.i("MicroMsg.WalletPwdDialog", "ChargeFee is null");
        this.Ijg.setVisibility(8);
        AppMethodBeat.o(71187);
    }

    public final void lv(String str, String str2) {
        AppMethodBeat.i(71188);
        if (!TextUtils.isEmpty(str2)) {
            this.IiZ.setVisibility(0);
            this.IiZ.setText(str2);
        } else {
            this.IiZ.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str)) {
            this.Ijj.setText(str);
            this.Ijj.setVisibility(0);
            AppMethodBeat.o(71188);
            return;
        }
        this.Ijj.setVisibility(8);
        AppMethodBeat.o(71188);
    }

    public final void aVT(String str) {
        AppMethodBeat.i(71189);
        if (!TextUtils.isEmpty(str)) {
            this.HHd.setVisibility(0);
            this.HHd.setText(str);
            AppMethodBeat.o(71189);
            return;
        }
        this.HHd.setVisibility(8);
        AppMethodBeat.o(71189);
    }

    private void a(PayInfo payInfo, boolean z) {
        boolean z2;
        AppMethodBeat.i(71190);
        this.BDB = payInfo;
        this.Ijt = z;
        if (z.aUo()) {
            AppMethodBeat.o(71190);
            return;
        }
        Log.v("MicroMsg.WalletPwdDialog", "alvinluo updateFingerprintMode");
        synchronized (this.IjJ) {
            try {
            } catch (Throwable th) {
                AppMethodBeat.o(71190);
                throw th;
            }
        }
        com.tencent.mm.plugin.fingerprint.d.a aVar = (com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        if (aVar.dJT() && aVar.dJU() && !aVar.dJP() && aVar.dJO()) {
            this.IjI = 0;
        } else if (aVar.dKb() && aVar.dKc() && !aVar.dJQ() && aVar.dJR()) {
            this.IjI = 1;
        }
        Log.i("MicroMsg.WalletPwdDialog", "bio mode: %s", Integer.valueOf(this.IjI));
        this.Iju = 0;
        this.Ijp.setVisibility(8);
        this.Ijq.setVisibility(8);
        this.Ijx = Util.currentTicks();
        boolean z3 = p.IML.wFM;
        if (t.fQI() == null || this.IjI < 0) {
            z2 = true;
        } else {
            z2 = aVar.dKa();
        }
        if (this.Ijt) {
            com.tencent.mm.plugin.fingerprint.d.a aVar2 = (com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
            if (aVar2.type() == 1 && ((aVar2.dJO() || aVar2.dJR()) && com.tencent.mm.plugin.soter.e.b.flX() && com.tencent.mm.plugin.soter.e.b.flW() && com.tencent.soter.core.a.hlf() == 0)) {
                Log.i("MicroMsg.WalletPwdDialog", "may treble init error");
                h.INSTANCE.dN(1104, 23);
            } else if (aVar2.type() == 2) {
                if (com.tencent.soter.core.a.hlf() == 1) {
                    if (!com.tencent.soter.core.a.hlh()) {
                        Log.i("MicroMsg.WalletPwdDialog", "soter service disconnected");
                        h.INSTANCE.dN(1104, 24);
                    } else if (!z2) {
                        Log.i("MicroMsg.WalletPwdDialog", "soter treble key error");
                        h.INSTANCE.dN(1104, 25);
                    }
                } else if (!z2) {
                    Log.i("MicroMsg.WalletPwdDialog", "soter1.0 key error");
                    h.INSTANCE.dN(1104, 26);
                }
            }
            if (aVar2.type() == 2) {
                if (com.tencent.soter.core.a.hlf() == 0) {
                    h.INSTANCE.dN(1104, 28);
                } else {
                    h.INSTANCE.dN(1104, 31);
                }
            }
            if (!z2) {
                h.INSTANCE.dN(1104, 27);
            }
            if (z3) {
                h.INSTANCE.dN(1104, 33);
            }
        }
        boolean z4 = z2 & (!z3);
        if (!z4) {
            p.IML.wFM = true;
        }
        Log.i("MicroMsg.WalletPwdDialog", "hy: soter key status: %b", Boolean.valueOf(z4));
        if ((this.BDB == null || !(this.BDB.Kxu == 100000 || this.BDB.Kxu == 100102)) && z4) {
            if (this.BDB != null && this.BDB.Kxu == 100001) {
                this.BDB.Ijy = 1;
            }
            if (this.IjI >= 0 && this.Ijt && !fTf()) {
                this.Ijp.setVisibility(0);
                this.Ijp.setText(getContext().getString(R.string.ipd));
                this.Ija.setVisibility(8);
                this.mKBLayout.setVisibility(8);
                if (this.BDB != null) {
                    this.BDB.Ijy = 1;
                }
                if (this.IjI == 0) {
                    this.Ijs = 1;
                    this.Ijq.setVisibility(0);
                    this.Igh.setVisibility(0);
                    this.IiV.setText(R.string.ip5);
                    fSO();
                    h.INSTANCE.a(11977, 1, 1, 0, 0, 0, 0);
                } else if (this.IjI == 1) {
                    this.Ijs = 2;
                    this.IjG.setVisibility(0);
                    this.IiV.setText(R.string.ip4);
                }
            } else if (this.IjI < 0 || !this.Ijt || !fTf()) {
                if (this.BDB != null) {
                    this.BDB.Ijy = 0;
                }
                this.Ijp.setVisibility(8);
                h.INSTANCE.a(11977, 0, 0, 0, 0, 0, 0);
            } else {
                if (this.IjI == 0) {
                    this.Ijp.setText(getContext().getString(R.string.icq));
                } else {
                    this.Ijp.setText(getContext().getString(R.string.ici));
                }
                this.Ijp.setVisibility(0);
                this.Ijs = 0;
                this.Ijq.setVisibility(8);
                this.IjG.setVisibility(8);
                this.Ija.setVisibility(0);
                if (!this.mKBLayout.isShown()) {
                    this.mKBLayout.setVisibility(0);
                }
                this.IiV.setText(R.string.ipa);
                if (this.BDB != null) {
                    this.BDB.Ijy = 0;
                }
                h.INSTANCE.a(11977, 1, 0, 0, 0, 0, 0);
                f.aqm(8);
            }
            Log.i("MicroMsg.WalletPwdDialog", "canUseBioMode: %s, use_pay_touch: %s, forcePwdMode：%s", Integer.valueOf(this.IjI), Boolean.valueOf(this.Ijt), Boolean.valueOf(fTf()));
            this.Ijp.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.s.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(71160);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (s.this.Ijs == 0) {
                        if (s.this.IjI == 0) {
                            s.b(s.this);
                        } else {
                            s.c(s.this);
                        }
                    } else if (s.this.Ijs == 1) {
                        af.f(s.this.BDB == null ? 0 : s.this.BDB.dVv, s.this.BDB == null ? "" : s.this.BDB.dDL, 19, "");
                        s.d(s.this);
                    } else if (s.this.Ijs == 2) {
                        s.d(s.this);
                        h.INSTANCE.a(15817, 4);
                    }
                    if (s.this.Ijs == 1) {
                        s.fTj();
                        if (s.e(s.this)) {
                            s.f(s.this);
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(71160);
                }
            });
            AppMethodBeat.o(71190);
            return;
        }
        Log.i("MicroMsg.WalletPwdDialog", "errCode: %s", Integer.valueOf(this.BDB.Kxu));
        if (!this.mKBLayout.isShown()) {
            this.mKBLayout.setVisibility(0);
        }
        if (this.BDB != null) {
            this.BDB.Ijy = 0;
            this.BDB.dNR = "";
            this.BDB.dNS = "";
        }
        this.Ijq.setVisibility(0);
        this.Ijr.setVisibility(0);
        this.Ijr.setText((this.BDB == null || this.BDB.Kxu != 100102) ? R.string.icp : R.string.icw);
        this.Ijr.setTextColor(getContext().getResources().getColor(R.color.aeo));
        if (!z4) {
            this.Ijd.setVisibility(0);
            this.Ije.setVisibility(0);
        } else {
            this.Ijd.setVisibility(8);
            this.Ije.setVisibility(8);
        }
        if (this.BDB != null && this.BDB.Kxu == 100102) {
            g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_LAST_IS_SEVERE_ERROR_BOOLEAN_SYNC, Boolean.TRUE);
            aVar.pj(false);
            aVar.pk(false);
            g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.FALSE);
        }
        h.INSTANCE.a(11977, 0, 0, 0, 0, 0, 0);
        AppMethodBeat.o(71190);
    }

    private void i(Bankcard bankcard) {
        AppMethodBeat.i(71191);
        if (bankcard == null) {
            Log.e("MicroMsg.WalletPwdDialog", "setBankcardText bankcard == null");
            AppMethodBeat.o(71191);
        } else if (bankcard.fQb()) {
            this.IiY.setImageResource(R.drawable.cqo);
            AppMethodBeat.o(71191);
        } else if (bankcard.fQc()) {
            this.HCH.a(bankcard, this.IiY);
            AppMethodBeat.o(71191);
        } else {
            if (bankcard.fQf()) {
                this.IiY.setImageDrawable(com.tencent.mm.svg.a.a.h(getContext().getResources(), R.raw.honey_pay_bank_logo));
                if (!Util.isNullOrNil(bankcard.HVU)) {
                    this.IiY.setUseSdcardCache(true);
                    this.IiY.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.fSn());
                    this.IiY.gI(bankcard.HVU, R.raw.honey_pay_bank_logo);
                    AppMethodBeat.o(71191);
                    return;
                }
            } else {
                this.HCH.a(getContext(), bankcard, this.IiY);
            }
            AppMethodBeat.o(71191);
        }
    }

    public final void a(CharSequence charSequence, View.OnClickListener onClickListener, boolean z) {
        AppMethodBeat.i(71192);
        if (!TextUtils.isEmpty(charSequence)) {
            this.Ijd.setOnClickListener(onClickListener);
            this.IiW.setText(charSequence);
            yr(this.Ijn);
            if (!z) {
                this.Ijc.setVisibility(8);
                AppMethodBeat.o(71192);
                return;
            }
            this.Ijc.setVisibility(0);
            AppMethodBeat.o(71192);
            return;
        }
        this.Ijd.setVisibility(8);
        this.Ije.setVisibility(8);
        AppMethodBeat.o(71192);
    }

    private void yr(boolean z) {
        AppMethodBeat.i(71193);
        if (!z) {
            this.Ijd.setVisibility(8);
            this.Ije.setVisibility(8);
            AppMethodBeat.o(71193);
            return;
        }
        this.Ijd.setVisibility(0);
        this.Ije.setVisibility(0);
        AppMethodBeat.o(71193);
    }

    public final void a(final Context context, final Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard) {
        AppMethodBeat.i(71194);
        this.HGS = e.INSTANCE.a(orders);
        if (orders == null || orders.HZe == null || orders.HZe.HEu == null || orders.HZe.HEu.size() <= 0 || this.HGS == null) {
            this.IiZ.setVisibility(8);
            AppMethodBeat.o(71194);
            return;
        }
        if (favorPayInfo == null) {
            this.HGf = this.HGS.aVM(orders.HZe.HEt);
        } else {
            this.HGf = favorPayInfo;
        }
        this.IiZ.setVisibility(0);
        if (this.Ijd != null) {
            this.Ijd.setTag(this.HGf);
        }
        this.Ijo = bankcard;
        this.Iji.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.s.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(71170);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                s.this.Ijf.setVisibility(8);
                af.f(s.this.BDB == null ? 0 : s.this.BDB.dVv, s.this.BDB == null ? "" : s.this.BDB.dDL, 12, "");
                n.a(context, orders, s.this.HGf.HXI, new n.b() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.s.AnonymousClass9.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.wallet_core.ui.n.b
                    public final void a(FavorPayInfo favorPayInfo) {
                        int i2;
                        String str;
                        double d2;
                        String string;
                        String str2;
                        String str3;
                        String str4;
                        String str5;
                        String str6 = null;
                        AppMethodBeat.i(71169);
                        s.this.HGf = favorPayInfo;
                        if (s.this.BDB == null) {
                            i2 = 0;
                        } else {
                            i2 = s.this.BDB.dVv;
                        }
                        if (s.this.BDB == null) {
                            str = "";
                        } else {
                            str = s.this.BDB.dDL;
                        }
                        af.f(i2, str, 15, s.this.HGf.HXI);
                        s.this.Ijm = false;
                        List<Bankcard> cI = d.cI(s.this.HGf.HXJ, s.this.HGf.HXK);
                        s.this.HGf.HXM = "";
                        if (d.a(s.this.HGf, s.this.Ijo)) {
                            s.this.Ijm = true;
                            if (cI.size() == 0) {
                                s.this.HGf.HXM = context.getString(R.string.ick);
                            } else {
                                s.this.HGf.HXM = context.getString(R.string.icl);
                            }
                            s.this.dismiss();
                            if (s.this.IjF != null) {
                                s.this.IjF.a(s.this.Ija.getText(), s.this.HGf, s.this.Ijm);
                                AppMethodBeat.o(71169);
                                return;
                            }
                        }
                        if (s.this.Ijd != null) {
                            s.this.Ijd.setTag(s.this.HGf);
                        }
                        j aVJ = s.this.HGS.aVJ(s.this.HGf.HXI);
                        if (aVJ == null || aVJ.HEA <= 0.0d) {
                            d2 = orders.HZe.HEq;
                            String D = f.D(orders.HZe.HEq);
                            string = context.getString(R.string.ip6);
                            str2 = D;
                            str3 = null;
                            str4 = null;
                        } else {
                            d2 = aVJ.HEs;
                            String D2 = f.D(aVJ.HEz);
                            str4 = f.D(orders.HZe.HEq);
                            str3 = aVJ.HEC;
                            str2 = D2;
                            string = null;
                        }
                        if (aVJ == null || aVJ.HEB == 0) {
                            str5 = null;
                        } else {
                            str5 = aVJ.HED;
                            if (!Util.isNullOrNil(str3)) {
                                str5 = ",".concat(String.valueOf(str5));
                            }
                        }
                        if (Util.isNullOrNil(str3) && Util.isNullOrNil(str5)) {
                            str6 = string;
                        } else if (!Util.isNullOrNil(string)) {
                            str6 = ",".concat(String.valueOf(string));
                        }
                        s.this.d(str2, d2);
                        s.this.aVT(str4);
                        s.this.lv(str3, str6);
                        s.this.aVU(str5);
                        AppMethodBeat.o(71169);
                    }
                }, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71170);
            }
        });
        Assert.assertNotNull(this.HGS);
        this.Ijf.setVisibility(8);
        AppMethodBeat.o(71194);
    }

    /* access modifiers changed from: protected */
    public void fTe() {
        AppMethodBeat.i(71195);
        yp(false);
        if (this.Ijl != null) {
            this.Ijl.onClick(this, 0);
        }
        dismiss();
        if (this.IjF != null) {
            this.IjF.a(this.Ija.getText(), this.HGf, this.Ijm);
        }
        if (this.Ijx < 0) {
            Log.e("MicroMsg.WalletPwdDialog", "hy: not set update mode time yet. abandon");
            AppMethodBeat.o(71195);
        } else if (this.Ijs == 0) {
            h.INSTANCE.idkeyStat(686, 0, 1, false);
            h.INSTANCE.idkeyStat(686, 1, Util.ticksToNow(this.Ijx), false);
            AppMethodBeat.o(71195);
        } else {
            if (this.Ijs == 1) {
                h.INSTANCE.idkeyStat(686, 2, 1, false);
                h.INSTANCE.idkeyStat(686, 3, Util.ticksToNow(this.Ijx), false);
            }
            AppMethodBeat.o(71195);
        }
    }

    public final void c(final DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(71196);
        if (this.zfh == null) {
            AppMethodBeat.o(71196);
            return;
        }
        this.XY = onCancelListener;
        this.zfh.setVisibility(0);
        this.zfh.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.s.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(71171);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (onCancelListener != null) {
                    onCancelListener.onCancel(null);
                }
                if (s.this.IjH != null) {
                    s.this.IjH.ezC();
                }
                s.this.cancel();
                if (s.this.Ijp.isShown()) {
                    h.INSTANCE.a(11977, 1, 0, 1, 0, 0, 0);
                } else {
                    h.INSTANCE.a(11977, 0, 0, 1, 0, 0, 0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71171);
            }
        });
        AppMethodBeat.o(71196);
    }

    public final void ys(boolean z) {
        AppMethodBeat.i(71197);
        if (z) {
            this.Ijd.setVisibility(0);
            AppMethodBeat.o(71197);
            return;
        }
        this.Ijd.setVisibility(8);
        AppMethodBeat.o(71197);
    }

    private void bx(LinkedList<String> linkedList) {
        AppMethodBeat.i(71198);
        if (this.IiX != null) {
            if (linkedList == null || linkedList.size() <= 0) {
                this.IiX.setVisibility(8);
            } else {
                this.IiX.setWording(linkedList);
                this.IiX.setVisibility(0);
                AppMethodBeat.o(71198);
                return;
            }
        }
        AppMethodBeat.o(71198);
    }

    public final void aVU(String str) {
        AppMethodBeat.i(71199);
        if (!Util.isNullOrNil(str)) {
            this.Ijh.setText(str);
            this.Ijh.setVisibility(0);
            AppMethodBeat.o(71199);
            return;
        }
        this.Ijh.setVisibility(8);
        AppMethodBeat.o(71199);
    }

    public final void a(a aVar) {
        this.IjH = aVar;
    }

    private static boolean a(PayInfo payInfo) {
        if (payInfo == null || (payInfo.dVv != 31 && payInfo.dVv != 32 && payInfo.dVv != 33)) {
            return false;
        }
        return true;
    }

    public static s a(Context context, boolean z, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, final PayInfo payInfo, String str, c cVar, final View.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        String str2;
        String str3;
        List<com.tencent.mm.plugin.wallet.a.t> list;
        String str4;
        String str5;
        String str6;
        CharSequence charSequence;
        boolean z2;
        AppMethodBeat.i(71201);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(71201);
            return null;
        } else if (orders == null || orders.HZd == null || orders.HZd.size() <= 0) {
            AppMethodBeat.o(71201);
            return null;
        } else {
            d a2 = e.INSTANCE.a(orders);
            Object[] objArr = new Object[3];
            objArr[0] = favorPayInfo == null ? "" : favorPayInfo.toString();
            if (bankcard == null) {
                str2 = "";
            } else {
                str2 = bankcard.field_bindSerial;
            }
            objArr[1] = str2;
            if (bankcard == null) {
                str3 = "";
            } else {
                str3 = bankcard.field_bankcardType;
            }
            objArr[2] = str3;
            Log.i("MicroMsg.WalletPwdDialog", "showAlert with favInfo %s bindSerial %s  bankcardType %s", objArr);
            if (a2 != null) {
                if (favorPayInfo != null && bankcard != null) {
                    if (bankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Log.i("MicroMsg.WalletPwdDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", favorPayInfo.HXI, Boolean.valueOf(z2));
                    String cG = a2.cG(favorPayInfo.HXI, z2);
                    Log.i("MicroMsg.WalletPwdDialog", "nonBankSelectedFaovrCompId %s", cG);
                    Map<String, d.a> aVH = a2.aVH(cG);
                    Map<String, d.a> cF = a2.cF(cG, true);
                    d.a aVar = aVH.get(bankcard.field_bindSerial);
                    d.a aVar2 = cF.get(bankcard.field_bankcardType);
                    j cE = a2.cE(cG, z2);
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = cE == null ? "" : cE.HEJ;
                    objArr2[1] = aVar == null ? "" : aVar.toString();
                    objArr2[2] = aVar2 == null ? "" : aVar2.toString();
                    Log.i("MicroMsg.WalletPwdDialog", "defaultComposeInfo %s wrapperSerial %s wrapper %s", objArr2);
                    if (aVar != null && aVar.IcR != null && !Util.isNullOrNil(aVar.IcR.HEJ)) {
                        favorPayInfo.HXI = aVar.IcR.HEJ;
                    } else if (aVar2 != null && aVar2.IcR != null && !Util.isNullOrNil(aVar2.IcR.HEJ)) {
                        favorPayInfo.HXI = aVar2.IcR.HEJ;
                    } else if (cE != null) {
                        favorPayInfo.HXI = cE.HEJ;
                    } else {
                        favorPayInfo.HXI = cG;
                    }
                } else if (orders.HZe != null) {
                    favorPayInfo = a2.aVM(a2.aVN(orders.HZe.HEt));
                }
                list = a2.fSz();
            } else {
                Log.d("MicroMsg.WalletPwdDialog", "getFavorLogicHelper null");
                list = null;
            }
            String str7 = "";
            String string = payInfo.iqp == null ? "" : payInfo.iqp.getString("extinfo_key_19", "");
            if (!Util.isNullOrNil(string)) {
                str7 = string;
            } else if (payInfo.dVv == 32 || payInfo.dVv == 33) {
                String string2 = payInfo.iqp.getString("extinfo_key_5", "");
                String string3 = payInfo.iqp.getString("extinfo_key_1", "");
                String string4 = context.getString(R.string.ip_);
                if (!Util.isNullOrNil(string2)) {
                    string4 = string2;
                    str7 = string2;
                }
                if (!Util.isNullOrNil(string3)) {
                    g.aAi();
                    as bjJ = ((l) g.af(l.class)).aSN().bjJ(string3);
                    if (bjJ != null) {
                        Object[] objArr3 = new Object[1];
                        objArr3[0] = f.bpz(bjJ.arJ()) + (Util.isNullOrNil(str) ? "" : "(" + str + ")");
                        str7 = Util.safeFormatString(string4, objArr3);
                    } else {
                        Log.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(string3)));
                    }
                } else {
                    Log.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                }
            } else if (payInfo.dVv == 31) {
                String string5 = payInfo.iqp.getString("extinfo_key_1", "");
                if (!Util.isNullOrNil(string5)) {
                    g.aAi();
                    as bjJ2 = ((l) g.af(l.class)).aSN().bjJ(string5);
                    if (bjJ2 != null) {
                        Object[] objArr4 = new Object[1];
                        objArr4[0] = bjJ2.arI() + (Util.isNullOrNil(str) ? "" : "(" + str + ")");
                        str7 = context.getString(R.string.ip_, objArr4);
                    } else {
                        Log.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(string5)));
                    }
                } else {
                    Log.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                }
            } else if (payInfo.dVv == 42) {
                String string6 = payInfo.iqp.getString("extinfo_key_1", "");
                if (!Util.isNullOrNil(string6)) {
                    g.aAi();
                    as bjJ3 = ((l) g.af(l.class)).aSN().bjJ(string6);
                    if (bjJ3 != null) {
                        Object[] objArr5 = new Object[1];
                        objArr5[0] = bjJ3.arI() + (Util.isNullOrNil(str) ? "" : "(" + str + ")");
                        str7 = context.getString(R.string.ip3, objArr5);
                    } else {
                        Log.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(string6)));
                    }
                } else {
                    Log.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                }
            } else if (payInfo.dVv == 48) {
                str7 = context.getString(R.string.frm);
            } else if (payInfo.dVv == 49) {
                String string7 = payInfo.iqp.getString("extinfo_key_1", "");
                if (!Util.isNullOrNil(string7)) {
                    str7 = context.getString(R.string.ip_, string7);
                } else {
                    Log.e("MicroMsg.WalletPwdDialog", "userName is null, scene is %s", Integer.valueOf(payInfo.dVv));
                }
            }
            if (!Util.isNullOrNil(str7) || orders == null || orders.HZd == null) {
                Log.w("MicroMsg.WalletPwdDialog", "orders null?:" + (orders == null));
                str4 = str7;
            } else {
                Orders.Commodity commodity = orders.HZd.get(0);
                if (commodity != null) {
                    str4 = commodity.AOa;
                    if (a(payInfo)) {
                        if (!Util.isNullOrNil(str4)) {
                            str4 = str4 + "\n";
                        }
                        str4 = str4 + commodity.desc;
                    }
                    if (Util.isNullOrNil(str4)) {
                        str4 = commodity.desc;
                    }
                }
                str4 = str7;
            }
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            double d2 = orders.dDO;
            boolean z3 = false;
            if (a2 == null || favorPayInfo == null) {
                str5 = null;
            } else {
                j aVJ = a2.aVJ(favorPayInfo.HXI);
                if (aVJ != null && aVJ.HEA > 0.0d) {
                    z3 = true;
                    str9 = f.d(orders.dDO, orders.AOl);
                    str8 = f.d(aVJ.HEz, orders.AOl);
                    d2 = aVJ.HEs;
                    str10 = aVJ.HEC;
                    if (!IjK.containsKey(payInfo.dDL)) {
                        h.INSTANCE.a(14530, 3);
                        str5 = null;
                    } else {
                        str5 = null;
                    }
                } else if (list == null || list.size() <= 0) {
                    str8 = f.d(orders.dDO, orders.AOl);
                    str5 = null;
                } else {
                    str8 = f.d(aVJ.HEz, orders.AOl);
                    z3 = true;
                    str5 = context.getString(R.string.ip6);
                }
                if (!(aVJ == null || aVJ.HEB == 0)) {
                    str11 = aVJ.HED;
                    if (!Util.isNullOrNil(str10)) {
                        str11 = ",".concat(String.valueOf(str11));
                    }
                }
                if (!Util.isNullOrNil(str10) || !Util.isNullOrNil(str11)) {
                    if (Util.isNullOrNil(str5)) {
                        str5 = null;
                    } else {
                        str5 = ",".concat(String.valueOf(str5));
                    }
                }
            }
            if (orders.CoZ > 0.0d) {
                str6 = context.getResources().getString(R.string.iao, f.d(orders.CoZ, orders.AOl));
            } else {
                str6 = null;
            }
            if (bankcard == null) {
                charSequence = "";
            } else {
                charSequence = bankcard.field_desc;
            }
            if (bankcard != null && bankcard.fQf()) {
                charSequence = com.tencent.mm.pluginsdk.ui.span.l.c(context, charSequence);
            }
            final s sVar = new s(context);
            sVar.a(context, orders, favorPayInfo, bankcard);
            sVar.ys(z);
            sVar.Ijn = z;
            sVar.c(new b(onCancelListener, (byte) 0));
            sVar.setOnCancelListener(new b(onCancelListener, (byte) 0));
            sVar.setCancelable(true);
            sVar.aVR(str4);
            sVar.d(str8, d2);
            sVar.aVT(str9);
            sVar.a(charSequence, new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.s.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(71156);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    s.IjK.put(payInfo.dDL, Boolean.TRUE);
                    onClickListener.onClick(view);
                    if (sVar.IjA) {
                        h.INSTANCE.a(14530, 2);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(71156);
                }
            }, z3);
            sVar.i(bankcard);
            sVar.a(payInfo, orders.HZa == 1);
            sVar.lv(str10, str5);
            sVar.aVU(str11);
            sVar.aVS(str6);
            sVar.IjF = cVar;
            sVar.bx(a(bankcard, orders));
            if (a(bankcard, orders, payInfo.dDL)) {
                sVar.yq(true);
                h.INSTANCE.a(14530, 1);
            } else {
                sVar.yq(false);
            }
            sVar.show();
            ao.e(sVar.getWindow());
            com.tencent.mm.ui.base.h.a(context, sVar);
            AppMethodBeat.o(71201);
            return sVar;
        }
    }

    private static LinkedList<String> a(Bankcard bankcard, Orders orders) {
        AppMethodBeat.i(71202);
        LinkedList<String> linkedList = new LinkedList<>();
        if (!(orders == null || orders.HZe == null || orders.HZe.HEE == null)) {
            Iterator<com.tencent.mm.plugin.wallet.a.c> it = orders.HZe.HEE.HDZ.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.wallet.a.c next = it.next();
                if (next.ANo.equals(bankcard.field_bindSerial)) {
                    Iterator<com.tencent.mm.plugin.wallet.a.d> it2 = next.HEk.iterator();
                    while (it2.hasNext()) {
                        com.tencent.mm.plugin.wallet.a.d next2 = it2.next();
                        if (next2.HEl != 0) {
                            linkedList.add(next2.Coh);
                        }
                    }
                    AppMethodBeat.o(71202);
                    return linkedList;
                }
            }
        }
        AppMethodBeat.o(71202);
        return linkedList;
    }

    static {
        AppMethodBeat.i(71219);
        AppMethodBeat.o(71219);
    }

    private static boolean a(Bankcard bankcard, Orders orders, String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(71203);
        if (bankcard == null) {
            AppMethodBeat.o(71203);
            return false;
        } else if (IjK.containsKey(str)) {
            AppMethodBeat.o(71203);
            return false;
        } else {
            if (!(orders.HZe == null || orders.HZe.HEE == null)) {
                if (orders.HZe.HEE.HDZ.size() > 0) {
                    Iterator<com.tencent.mm.plugin.wallet.a.c> it = orders.HZe.HEE.HDZ.iterator();
                    z = false;
                    while (it.hasNext()) {
                        com.tencent.mm.plugin.wallet.a.c next = it.next();
                        if (next.ANo == null || !next.ANo.equals(bankcard.field_bindSerial)) {
                            z2 = z;
                        } else {
                            z2 = true;
                        }
                        z = z2;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    AppMethodBeat.o(71203);
                    return false;
                } else if (orders.HZe.HEE.HDZ.size() > 0) {
                    AppMethodBeat.o(71203);
                    return true;
                } else if (orders.HZe.HEE.HEa != null && orders.HZe.HEE.HEa.HEQ.size() > 0) {
                    AppMethodBeat.o(71203);
                    return true;
                }
            }
            AppMethodBeat.o(71203);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b implements DialogInterface.OnCancelListener {
        private DialogInterface.OnCancelListener IjS;

        /* synthetic */ b(DialogInterface.OnCancelListener onCancelListener, byte b2) {
            this(onCancelListener);
        }

        private b(DialogInterface.OnCancelListener onCancelListener) {
            this.IjS = null;
            this.IjS = onCancelListener;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(71172);
            s.yt(false);
            if (this.IjS != null) {
                this.IjS.onCancel(dialogInterface);
            }
            AppMethodBeat.o(71172);
        }
    }

    public static s a(Context context, String str, String str2, c cVar, DialogInterface.OnCancelListener onCancelListener, a aVar) {
        AppMethodBeat.i(71204);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(71204);
            return null;
        } else if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            s sVar = new s(context);
            sVar.c(onCancelListener);
            sVar.setOnCancelListener(onCancelListener);
            sVar.setCancelable(true);
            sVar.aVR(str);
            if (!TextUtils.isEmpty(str2)) {
                sVar.CuI.setVisibility(0);
                sVar.CuI.setText(str2);
            } else {
                sVar.CuI.setVisibility(8);
            }
            sVar.Ijn = true;
            sVar.yr(sVar.Ijn);
            sVar.ys(false);
            sVar.Ijn = false;
            sVar.IjH = aVar;
            sVar.aVS("");
            sVar.IjF = cVar;
            sVar.show();
            com.tencent.mm.ui.base.h.a(context, sVar);
            AppMethodBeat.o(71204);
            return sVar;
        } else {
            AppMethodBeat.o(71204);
            return null;
        }
    }

    public static s a(Context context, String str, double d2, String str2, Bankcard bankcard, c cVar, View.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        boolean z = true;
        AppMethodBeat.i(71205);
        if (((Activity) context).isFinishing()) {
            AppMethodBeat.o(71205);
            return null;
        }
        s sVar = new s(context);
        sVar.c(onCancelListener);
        sVar.setOnCancelListener(onCancelListener);
        sVar.setCancelable(true);
        sVar.aVR(str);
        sVar.d(f.d(d2, str2), d2);
        sVar.Ijn = true;
        String str3 = bankcard == null ? "" : bankcard.field_desc;
        sVar.i(bankcard);
        if (TextUtils.isEmpty(str3)) {
            z = false;
        }
        sVar.ys(z);
        if (bankcard != null) {
            sVar.a((CharSequence) str3, onClickListener, false);
        }
        sVar.IjF = cVar;
        sVar.show();
        com.tencent.mm.ui.base.h.a(context, sVar);
        AppMethodBeat.o(71205);
        return sVar;
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.f
    public final void fSA() {
        AppMethodBeat.i(71206);
        this.isPaused = false;
        if (z.aUo()) {
            AppMethodBeat.o(71206);
        } else {
            AppMethodBeat.o(71206);
        }
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.f
    public final void onActivityPause() {
        AppMethodBeat.i(71207);
        this.isPaused = true;
        if (z.aUo()) {
            AppMethodBeat.o(71207);
            return;
        }
        if (this.Ijs == 1) {
            fTd();
        }
        AppMethodBeat.o(71207);
    }

    private static void yp(boolean z) {
        AppMethodBeat.i(71208);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_IS_FORCE_PWD_MODE_BOOLEAN_SYNC, Boolean.valueOf(z));
        AppMethodBeat.o(71208);
    }

    private static boolean fTf() {
        boolean z;
        AppMethodBeat.i(71209);
        g.aAi();
        Object obj = g.aAh().azQ().get(ar.a.USERINFO_FINGER_PRINT_IS_FORCE_PWD_MODE_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        } else {
            z = false;
        }
        AppMethodBeat.o(71209);
        return z;
    }

    public static s a(Context context, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, PayInfo payInfo, c cVar, View.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(71200);
        s a2 = a(context, true, orders, favorPayInfo, bankcard, payInfo, null, cVar, onClickListener, onCancelListener);
        AppMethodBeat.o(71200);
        return a2;
    }

    static /* synthetic */ void a(s sVar) {
        AppMethodBeat.i(71210);
        Log.i("MicroMsg.WalletPwdDialog", "do req face id");
        h.INSTANCE.a(15817, 3);
        Bundle bundle = new Bundle();
        bundle.putInt("face_auth_scene", 1);
        sVar.jBN.setVisibility(8);
        ((com.tencent.mm.plugin.fingerprint.b.h) g.af(com.tencent.mm.plugin.fingerprint.b.h.class)).a((MMActivity) sVar.mContext, new com.tencent.mm.plugin.fingerprint.faceid.auth.a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.s.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.a
            public final void onAuthSuccess(int i2, int i3) {
                AppMethodBeat.i(71161);
                Log.i("MicroMsg.WalletPwdDialog", "face id auth success");
                s.this.BDB.Ijy = 1;
                s.this.BDB.dNR = "";
                s.this.BDB.dNS = "";
                try {
                    JSONObject jSONObject = new JSONObject(((com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).dJS());
                    jSONObject.put("soter_type", t.fQI().fRq());
                    s.this.BDB.dUV = jSONObject.toString();
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.WalletPwdDialog", e2, "", new Object[0]);
                }
                s.this.BDB.dNP = i2;
                s.this.BDB.Ijz = i3;
                s.this.fTe();
                AppMethodBeat.o(71161);
            }

            @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.a
            public final void onAuthFail(int i2) {
                AppMethodBeat.i(71162);
                Log.i("MicroMsg.WalletPwdDialog", "face id auth fail: %s, %s", Integer.valueOf(i2), Integer.valueOf(s.this.BDB.Ijz));
                s.this.jBN.setVisibility(0);
                s.this.Ijp.setVisibility(8);
                s.d(s.this);
                s.this.BDB.Ijz++;
                AppMethodBeat.o(71162);
            }

            @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.a
            public final void onAuthCancel() {
                AppMethodBeat.i(71163);
                s.this.jBN.setVisibility(0);
                AppMethodBeat.o(71163);
            }
        }, bundle);
        AppMethodBeat.o(71210);
    }

    static /* synthetic */ void b(s sVar) {
        AppMethodBeat.i(71211);
        sVar.Ijp.setText(sVar.getContext().getString(R.string.ipd));
        sVar.Ijs = 1;
        sVar.Ijx = Util.currentTicks();
        sVar.Ijq.setVisibility(0);
        sVar.Igh.setVisibility(0);
        sVar.Ijr.setVisibility(8);
        sVar.Ija.setVisibility(8);
        sVar.mKBLayout.setVisibility(8);
        sVar.IiV.setText(R.string.ip5);
        yp(false);
        sVar.BDB.Ijy = 1;
        h.INSTANCE.a(11977, 1, 1, 0, 0, 0, 2);
        f.aqm(9);
        AppMethodBeat.o(71211);
    }

    static /* synthetic */ void c(s sVar) {
        AppMethodBeat.i(71212);
        sVar.Ijp.setText(sVar.getContext().getString(R.string.ipd));
        sVar.Ijs = 2;
        sVar.Ijx = Util.currentTicks();
        sVar.IjG.setVisibility(0);
        sVar.Ija.setVisibility(8);
        sVar.mKBLayout.setVisibility(8);
        sVar.IiV.setText(R.string.ip4);
        yp(false);
        sVar.BDB.Ijy = 1;
        AppMethodBeat.o(71212);
    }

    static /* synthetic */ boolean e(s sVar) {
        boolean z;
        AppMethodBeat.i(71215);
        Object[] objArr = new Object[1];
        if (!sVar.isPaused) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i("MicroMsg.WalletPwdDialog", "hy: is screen on: %b", objArr);
        if (!sVar.isPaused) {
            AppMethodBeat.o(71215);
            return true;
        }
        AppMethodBeat.o(71215);
        return false;
    }

    static /* synthetic */ void k(s sVar) {
        AppMethodBeat.i(71217);
        sVar.Ijx = Util.currentTicks();
        AppMethodBeat.o(71217);
    }
}
