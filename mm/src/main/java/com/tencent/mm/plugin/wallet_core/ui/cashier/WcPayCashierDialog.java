package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog;
import com.tencent.mm.plugin.wallet_core.ui.cashier.a;
import com.tencent.mm.plugin.wallet_core.ui.d;
import com.tencent.mm.plugin.wallet_core.ui.e;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.egf;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class WcPayCashierDialog extends i implements LifecycleObserver {
    public static final int Ill = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 30);
    public static final int Ilm = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 32);
    public static final int Iln = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 36);
    public static final int Ilo = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 23);
    public Orders CwO = new Orders();
    private com.tencent.mm.plugin.wallet_core.utils.a HCH;
    public FavorPayInfo HGf;
    private TextView Ijg;
    private ImageView IkS;
    private TextView IlA;
    private Button IlB;
    private ViewGroup IlC;
    private WcPayCashierDetailItemLayout IlD;
    private WcPayCashierDetailItemLayout IlE;
    private WcPayCashierDetailItemLayout IlF;
    private WcPayCashierDetailItemLayout IlG;
    private WcPayCashierFingerprintDialog IlH;
    private a IlI;
    private n IlJ;
    private int IlK = 0;
    private int IlL = 0;
    private int IlM = 0;
    public Bankcard IlN;
    private boolean IlO = false;
    private boolean IlP;
    private boolean IlQ = true;
    private boolean IlR;
    private String IlS;
    private String IlT;
    private String IlU;
    private boolean IlV;
    private boolean IlW;
    public a IlX;
    List<b> IlY = new ArrayList();
    private TextView Ilp;
    private TextView Ilq;
    private TextView Ilr;
    private WalletTextView Ils;
    private ViewGroup Ilt;
    private EditHintPasswdView Ilu;
    private ViewGroup Ilv;
    private Button Ilw;
    private TextView Ilx;
    private ViewGroup Ily;
    private CdnImageView Ilz;
    private Context mContext;
    private MyKeyboardWindow mKeyboard;
    public PayInfo mPayInfo = new PayInfo();
    private ViewGroup nmW;
    private View zlb;

    public interface a {
        void a(String str, FavorPayInfo favorPayInfo, Bankcard bankcard);

        void fNc();

        void onCancel();
    }

    public interface b {
        void fTr();
    }

    static /* synthetic */ void a(WcPayCashierDialog wcPayCashierDialog, TextView textView) {
        AppMethodBeat.i(71408);
        wcPayCashierDialog.A(textView);
        AppMethodBeat.o(71408);
    }

    static /* synthetic */ void a(WcPayCashierDialog wcPayCashierDialog, FavorPayInfo favorPayInfo) {
        AppMethodBeat.i(71404);
        wcPayCashierDialog.a(false, 0, true, favorPayInfo);
        AppMethodBeat.o(71404);
    }

    static /* synthetic */ void f(WcPayCashierDialog wcPayCashierDialog) {
        AppMethodBeat.i(71397);
        wcPayCashierDialog.fTt();
        AppMethodBeat.o(71397);
    }

    static /* synthetic */ void g(WcPayCashierDialog wcPayCashierDialog) {
        AppMethodBeat.i(71398);
        wcPayCashierDialog.fTu();
        AppMethodBeat.o(71398);
    }

    static /* synthetic */ void i(WcPayCashierDialog wcPayCashierDialog) {
        AppMethodBeat.i(71399);
        wcPayCashierDialog.fTH();
        AppMethodBeat.o(71399);
    }

    static /* synthetic */ void l(WcPayCashierDialog wcPayCashierDialog) {
        AppMethodBeat.i(71402);
        wcPayCashierDialog.yv(true);
        AppMethodBeat.o(71402);
    }

    static /* synthetic */ void p(WcPayCashierDialog wcPayCashierDialog) {
        AppMethodBeat.i(71406);
        wcPayCashierDialog.fTF();
        AppMethodBeat.o(71406);
    }

    static /* synthetic */ void q(WcPayCashierDialog wcPayCashierDialog) {
        AppMethodBeat.i(71407);
        wcPayCashierDialog.fTz();
        AppMethodBeat.o(71407);
    }

    static /* synthetic */ void u(WcPayCashierDialog wcPayCashierDialog) {
        AppMethodBeat.i(71410);
        wcPayCashierDialog.fTv();
        AppMethodBeat.o(71410);
    }

    static /* synthetic */ void v(WcPayCashierDialog wcPayCashierDialog) {
        AppMethodBeat.i(71411);
        wcPayCashierDialog.fTx();
        AppMethodBeat.o(71411);
    }

    static /* synthetic */ void w(WcPayCashierDialog wcPayCashierDialog) {
        AppMethodBeat.i(71412);
        wcPayCashierDialog.fTA();
        AppMethodBeat.o(71412);
    }

    static /* synthetic */ void x(WcPayCashierDialog wcPayCashierDialog) {
        AppMethodBeat.i(71413);
        wcPayCashierDialog.aeW(8);
        AppMethodBeat.o(71413);
    }

    static {
        AppMethodBeat.i(71415);
        AppMethodBeat.o(71415);
    }

    public WcPayCashierDialog(Context context) {
        super(context, R.style.a66);
        AppMethodBeat.i(71361);
        this.mContext = context;
        init();
        AppMethodBeat.o(71361);
    }

    public WcPayCashierDialog(Context context, int i2) {
        super(context, R.style.a66);
        AppMethodBeat.i(71362);
        this.mContext = context;
        init();
        AppMethodBeat.o(71362);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71363);
        super.onCreate(bundle);
        setContentView(this.nmW);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        window.addFlags(67108864);
        d.oD(21);
        AppMethodBeat.o(71363);
    }

    private void init() {
        AppMethodBeat.i(71364);
        initView();
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(71335);
                Log.i("MicroMsg.WcPayCashierDialog", "on canceled");
                WcPayCashierDialog.this.IlW = true;
                if (WcPayCashierDialog.this.IlX != null) {
                    WcPayCashierDialog.this.IlX.onCancel();
                }
                AppMethodBeat.o(71335);
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass9 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(71353);
                Log.i("MicroMsg.WcPayCashierDialog", "on dismissed");
                WcPayCashierDialog.this.IlW = true;
                WcPayCashierDialog.d(WcPayCashierDialog.this);
                AppMethodBeat.o(71353);
            }
        });
        ((MMActivity) this.mContext).getLifecycle().addObserver(this);
        this.HCH = new com.tencent.mm.plugin.wallet_core.utils.a();
        AppMethodBeat.o(71364);
    }

    private void initView() {
        AppMethodBeat.i(71365);
        this.nmW = (ViewGroup) View.inflate(getContext(), R.layout.cas, null);
        this.IkS = (ImageView) this.nmW.findViewById(R.id.jp9);
        this.Ilp = (TextView) this.nmW.findViewById(R.id.jpc);
        this.Ilq = (TextView) this.nmW.findViewById(R.id.jpm);
        this.Ilr = (TextView) this.nmW.findViewById(R.id.jph);
        this.Ijg = (TextView) this.nmW.findViewById(R.id.jp8);
        this.Ils = (WalletTextView) this.nmW.findViewById(R.id.jpi);
        this.Ilt = (ViewGroup) this.nmW.findViewById(R.id.jpb);
        this.Ilu = (EditHintPasswdView) this.nmW.findViewById(R.id.jpk);
        this.Ilv = (ViewGroup) this.nmW.findViewById(R.id.jpl);
        this.IlE = (WcPayCashierDetailItemLayout) this.nmW.findViewById(R.id.jpj);
        this.Ilw = (Button) this.nmW.findViewById(R.id.jp_);
        this.Ilx = (TextView) this.nmW.findViewById(R.id.jpd);
        this.Ily = (ViewGroup) this.nmW.findViewById(R.id.jp7);
        this.Ilz = (CdnImageView) this.nmW.findViewById(R.id.jpg);
        this.IlA = (TextView) this.nmW.findViewById(R.id.jpf);
        this.IlB = (Button) this.nmW.findViewById(R.id.jpe);
        this.mKeyboard = (MyKeyboardWindow) this.nmW.findViewById(R.id.ijb);
        this.IlC = (ViewGroup) this.nmW.findViewById(R.id.ija);
        this.zlb = this.nmW.findViewById(R.id.jpa);
        ImageView imageView = this.IkS;
        int i2 = Ill;
        int i3 = Ill;
        Util.expandViewTouchArea(imageView, i2, i2, i3, i3);
        this.IkS.setImageDrawable(ar.m(getContext(), R.raw.actionbar_icon_dark_close, getContext().getResources().getColor(R.color.fp)));
        this.IkS.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(71354);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.WcPayCashierDialog", "click close icon");
                WcPayCashierDialog.this.cancel();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71354);
            }
        });
        com.tencent.mm.wallet_core.ui.formview.a.a(this.Ilu);
        this.Ilu.setOnInputValidListener(new EditHintPasswdView.a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass11 */

            @Override // com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a
            public final void onInputValidChange(boolean z) {
                AppMethodBeat.i(71355);
                if (z) {
                    WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.this.Ilu.getText(), WcPayCashierDialog.this.HGf);
                    h.INSTANCE.a(11977, 0, 0, 0, 0, 0, 0);
                }
                AppMethodBeat.o(71355);
            }
        });
        EditText editText = (EditText) this.nmW.findViewById(R.id.jf4);
        f.setNoSystemInputOnEditText(editText);
        this.mKeyboard.setInputEditText(editText);
        if (Build.VERSION.SDK_INT >= 14) {
            com.tencent.mm.ui.a.d dVar = new com.tencent.mm.ui.a.d();
            this.mKeyboard.setSecureAccessibility(dVar);
            editText.setAccessibilityDelegate(dVar);
        }
        editText.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(71356);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WcPayCashierDialog.f(WcPayCashierDialog.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71356);
            }
        });
        this.nmW.findViewById(R.id.ijc).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(71357);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WcPayCashierDialog.g(WcPayCashierDialog.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71357);
            }
        });
        this.Ilw.setOnClickListener(new x() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass14 */

            @Override // com.tencent.mm.ui.x
            public final void czW() {
                int i2 = 0;
                AppMethodBeat.i(71358);
                Log.i("MicroMsg.WcPayCashierDialog", "click pay btn: %s", Integer.valueOf(WcPayCashierDialog.this.IlL));
                if (WcPayCashierDialog.this.mPayInfo != null) {
                    i2 = WcPayCashierDialog.this.mPayInfo.dVv;
                }
                af.f(i2, WcPayCashierDialog.this.mPayInfo == null ? "" : WcPayCashierDialog.this.mPayInfo.dDL, 20, "");
                WcPayCashierDialog.i(WcPayCashierDialog.this);
                if (WcPayCashierDialog.this.IlL == 1) {
                    WcPayCashierDialog.j(WcPayCashierDialog.this);
                    f.aqm(9);
                    AppMethodBeat.o(71358);
                } else if (WcPayCashierDialog.this.IlL == 2) {
                    WcPayCashierDialog.k(WcPayCashierDialog.this);
                    AppMethodBeat.o(71358);
                } else {
                    Log.i("MicroMsg.WcPayCashierDialog", "wrong mode, switch pwd");
                    WcPayCashierDialog.l(WcPayCashierDialog.this);
                    AppMethodBeat.o(71358);
                }
            }
        });
        this.Ilq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(71359);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.WcPayCashierDialog", "click pay way btn");
                WcPayCashierDialog.m(WcPayCashierDialog.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71359);
            }
        });
        AppMethodBeat.o(71365);
    }

    private void fTt() {
        AppMethodBeat.i(71366);
        if (!this.IlC.isShown()) {
            this.IlC.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.ei);
            loadAnimation.setInterpolator(new DecelerateInterpolator());
            loadAnimation.setDuration(180);
            this.IlC.startAnimation(loadAnimation);
        }
        AppMethodBeat.o(71366);
    }

    private void fTu() {
        AppMethodBeat.i(71367);
        if (this.IlC.isShown()) {
            this.IlC.setVisibility(8);
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.ej);
            loadAnimation.setInterpolator(new DecelerateInterpolator());
            loadAnimation.setDuration(180);
            this.IlC.startAnimation(loadAnimation);
        }
        AppMethodBeat.o(71367);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onActivityPause() {
        AppMethodBeat.i(71368);
        Log.i("MicroMsg.WcPayCashierDialog", "activity paused, release and dismiss");
        this.Ilu.eIj();
        AppMethodBeat.o(71368);
    }

    public final void a(String str, String str2, String str3, List<egf> list) {
        AppMethodBeat.i(71369);
        this.IlT = str;
        this.IlU = str2;
        this.IlS = str3;
        this.IlV = true;
        this.IlP = false;
        fTG();
        fTB();
        fTD();
        id(list);
        fTA();
        fTy();
        AppMethodBeat.o(71369);
    }

    public final void a(PayInfo payInfo, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, boolean z, boolean z2) {
        AppMethodBeat.i(71370);
        a(payInfo, orders, favorPayInfo, "", bankcard, z, z2);
        AppMethodBeat.o(71370);
    }

    private void a(PayInfo payInfo, Orders orders, FavorPayInfo favorPayInfo, String str, Bankcard bankcard, boolean z, boolean z2) {
        AppMethodBeat.i(71371);
        Log.i("MicroMsg.WcPayCashierDialog", "set view data: %s, %s, %s", Boolean.valueOf(z), Boolean.valueOf(z2), bankcard);
        this.mPayInfo = payInfo;
        this.CwO = orders;
        this.HGf = favorPayInfo;
        if (!z2) {
            this.IlN = bankcard;
        }
        this.IlP = z;
        this.IlS = str;
        fTv();
        fTG();
        fTB();
        fTE();
        fTD();
        fTz();
        fTw();
        id(this.CwO.field_infos);
        fTx();
        fTA();
        fTy();
        if (z2) {
            setOnShowListener(new DialogInterface.OnShowListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass16 */

                public final void onShow(DialogInterface dialogInterface) {
                    AppMethodBeat.i(71360);
                    WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.this.HGf);
                    WcPayCashierDialog.this.setOnShowListener(null);
                    AppMethodBeat.o(71360);
                }
            });
        }
        AppMethodBeat.o(71371);
    }

    private void id(List<egf> list) {
        AppMethodBeat.i(71372);
        if (list != null && !list.isEmpty()) {
            for (final egf egf : list) {
                WcPayCashierDetailItemLayout wcPayCashierDetailItemLayout = new WcPayCashierDetailItemLayout(getContext());
                wcPayCashierDetailItemLayout.Ili.setVisibility(8);
                if (egf.Ngf != null && egf.Ngf.size() > 0) {
                    g.a(wcPayCashierDetailItemLayout.Cqw, egf.Ngf.get(0), (g.a) null);
                }
                if (egf.Ngg == null || egf.Ngg.size() <= 0) {
                    wcPayCashierDetailItemLayout.qWU.setVisibility(8);
                    wcPayCashierDetailItemLayout.Cqw.setMaxWidth(Integer.MAX_VALUE);
                } else {
                    g.a(wcPayCashierDetailItemLayout.qWU, egf.Ngg.get(0), (g.a) null);
                }
                if (egf.Ngh != null) {
                    g.a(wcPayCashierDetailItemLayout.Ilj, egf.Ngh, R.raw.arrow_right, com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 16), true);
                    wcPayCashierDetailItemLayout.Ilj.setVisibility(0);
                } else {
                    wcPayCashierDetailItemLayout.Ilj.setVisibility(8);
                }
                wcPayCashierDetailItemLayout.fTs();
                if (egf.KEP != null) {
                    wcPayCashierDetailItemLayout.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(71337);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.WcPayCashierDialog", "click item: %s", egf.KEP.url);
                            if (egf.KEP.type == 13 && egf.KEP.MTl != null && "fetchfavordialog".equals(egf.KEP.url)) {
                                b bVar2 = new b(WcPayCashierDialog.this.mContext);
                                if (egf.KEP.MTl.LpX.size() > 0 && egf.KEP.MTl.LpX.get(0).NoG != null) {
                                    LinkedList<egf> linkedList = egf.KEP.MTl.LpX.get(0).NoG.Mjq;
                                    ehf ehf = egf.KEP.MTl.LpV.KEN;
                                    if (ehf != null) {
                                        g.a(bVar2.mPa, ehf, (g.a) null);
                                    }
                                    if (linkedList != null && !linkedList.isEmpty()) {
                                        for (egf egf : linkedList) {
                                            View inflate = View.inflate(bVar2.getContext(), R.layout.cat, null);
                                            TextView textView = (TextView) inflate.findViewById(R.id.jpz);
                                            TextView textView2 = (TextView) inflate.findViewById(R.id.jpx);
                                            if (egf.Ngf != null && egf.Ngf.size() > 0) {
                                                g.a(textView, egf.Ngf.get(0), (g.a) null);
                                                if (egf.Ngf.size() >= 2) {
                                                    g.a(textView2, egf.Ngf.get(1), (g.a) null);
                                                }
                                            }
                                            bVar2.Imh.addView(inflate);
                                        }
                                    }
                                }
                                bVar2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                    /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass2.AnonymousClass1 */

                                    public final void onDismiss(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(71336);
                                        WcPayCashierDialog.this.show();
                                        AppMethodBeat.o(71336);
                                    }
                                });
                                bVar2.show();
                                WcPayCashierDialog.this.hide();
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(71337);
                        }
                    });
                }
                this.Ilt.addView(wcPayCashierDetailItemLayout);
            }
        }
        AppMethodBeat.o(71372);
    }

    private void fTv() {
        boolean z;
        AppMethodBeat.i(71373);
        com.tencent.mm.plugin.wallet_core.ui.d a2 = e.INSTANCE.a(this.CwO);
        if (a2 == null) {
            Log.d("MicroMsg.WcPayCashierDialog", "getFavorLogicHelper null");
        } else if (this.HGf != null && this.IlN != null) {
            if (this.IlN.field_bankcardType.equalsIgnoreCase("CFT")) {
                z = true;
            } else {
                z = false;
            }
            Log.i("MicroMsg.WcPayCashierDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", this.HGf.HXI, Boolean.valueOf(z));
            String cG = a2.cG(this.HGf.HXI, z);
            Log.i("MicroMsg.WcPayCashierDialog", "nonBankSelectedFaovrCompId %s", cG);
            Map<String, d.a> aVH = a2.aVH(cG);
            Map<String, d.a> cF = a2.cF(cG, true);
            d.a aVar = aVH.get(this.IlN.field_bindSerial);
            d.a aVar2 = cF.get(this.IlN.field_bankcardType);
            j cE = a2.cE(cG, z);
            Object[] objArr = new Object[3];
            objArr[0] = cE == null ? "" : cE.HEJ;
            objArr[1] = aVar == null ? "" : aVar.toString();
            objArr[2] = aVar2 == null ? "" : aVar2.toString();
            Log.i("MicroMsg.WcPayCashierDialog", "defaultComposeInfo %s wrapperSerial %s wrapper %s", objArr);
            if (aVar != null && aVar.IcR != null && !Util.isNullOrNil(aVar.IcR.HEJ)) {
                this.HGf.HXI = aVar.IcR.HEJ;
                AppMethodBeat.o(71373);
                return;
            } else if (aVar2 != null && aVar2.IcR != null && !Util.isNullOrNil(aVar2.IcR.HEJ)) {
                this.HGf.HXI = aVar2.IcR.HEJ;
                AppMethodBeat.o(71373);
                return;
            } else if (cE != null) {
                this.HGf.HXI = cE.HEJ;
                AppMethodBeat.o(71373);
                return;
            } else {
                this.HGf.HXI = cG;
                AppMethodBeat.o(71373);
                return;
            }
        } else if (this.CwO.HZe != null) {
            this.HGf = a2.aVM(a2.aVN(this.CwO.HZe.HEt));
            AppMethodBeat.o(71373);
            return;
        }
        AppMethodBeat.o(71373);
    }

    private void fTw() {
        AppMethodBeat.i(71374);
        if (this.IlR) {
            Log.i("MicroMsg.WcPayCashierDialog", "don't show foreign currency");
            if (this.IlG != null) {
                this.Ilt.removeView(this.IlG);
                this.IlG = null;
            }
            AppMethodBeat.o(71374);
            return;
        }
        if (!Util.isNullOrNil(this.CwO.HZv) && !Util.isNullOrNil(this.CwO.HZw)) {
            this.IlG = new WcPayCashierDetailItemLayout(getContext());
            this.Ilt.addView(this.IlG, 0);
            this.IlG.Ili.setVisibility(8);
            this.IlG.Ilj.setVisibility(8);
            this.IlG.Cqw.setText(R.string.ix5);
            this.IlG.fTs();
            if (!this.CwO.HZv.equals("CNY") || Util.isNullOrNil(this.CwO.HZu)) {
                StringBuilder sb = new StringBuilder(this.CwO.HZw);
                sb.append(this.CwO.HZu);
                this.IlG.qWU.setText(sb);
            } else {
                StringBuilder sb2 = new StringBuilder(this.CwO.HZw);
                sb2.append(this.CwO.HZu);
                if (!Util.isNullOrNil(this.CwO.HZy) && !Util.isNullOrNil(this.CwO.HZz)) {
                    sb2.append(String.format("(%s%s)", this.CwO.HZz, this.CwO.HZx));
                }
                this.IlG.qWU.setText(sb2);
                AppMethodBeat.o(71374);
                return;
            }
        }
        AppMethodBeat.o(71374);
    }

    private void fTx() {
        AppMethodBeat.i(71375);
        com.tencent.mm.plugin.wallet_core.ui.d a2 = e.INSTANCE.a(this.CwO);
        if (this.HGf == null || (a2 != null && !a2.fSw())) {
            this.Ilt.removeView(this.IlF);
            this.IlF = null;
            AppMethodBeat.o(71375);
            return;
        }
        if (this.IlF == null) {
            this.IlF = new WcPayCashierDetailItemLayout(getContext());
            this.Ilt.addView(this.IlF);
            this.IlF.Cqw.setText(R.string.ix3);
            this.IlF.Ili.setVisibility(8);
            this.IlF.Ilj.setVisibility(0);
            this.IlF.qWU.setTextColor(getContext().getResources().getColor(R.color.Orange));
            this.IlF.fTs();
            this.IlF.setOnClickListener(new x() {
                /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass3 */

                @Override // com.tencent.mm.ui.x
                public final void czW() {
                    AppMethodBeat.i(71340);
                    af.f(WcPayCashierDialog.this.mPayInfo == null ? 0 : WcPayCashierDialog.this.mPayInfo.dVv, WcPayCashierDialog.this.mPayInfo == null ? "" : WcPayCashierDialog.this.mPayInfo.dDL, 12, "");
                    WcPayCashierDialog.this.hide();
                    if (WcPayCashierDialog.this.IlJ != null) {
                        WcPayCashierDialog.this.IlJ.dismiss();
                        WcPayCashierDialog.this.IlJ = null;
                        AppMethodBeat.o(71340);
                        return;
                    }
                    WcPayCashierDialog.this.IlJ = n.a(WcPayCashierDialog.this.getContext(), WcPayCashierDialog.this.CwO, WcPayCashierDialog.this.HGf.HXI, new n.b() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass3.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.wallet_core.ui.n.b
                        public final void a(FavorPayInfo favorPayInfo) {
                            int i2 = 0;
                            AppMethodBeat.i(71338);
                            Log.i("MicroMsg.WcPayCashierDialog", "on select favor: %s", favorPayInfo.HXI);
                            WcPayCashierDialog.this.IlJ = null;
                            if (WcPayCashierDialog.this.mPayInfo != null) {
                                i2 = WcPayCashierDialog.this.mPayInfo.dVv;
                            }
                            af.f(i2, WcPayCashierDialog.this.mPayInfo == null ? "" : WcPayCashierDialog.this.mPayInfo.dDL, 15, favorPayInfo.HXI);
                            List<Bankcard> cI = com.tencent.mm.plugin.wallet_core.ui.d.cI(favorPayInfo.HXJ, favorPayInfo.HXK);
                            WcPayCashierDialog.this.HGf.HXM = "";
                            if (com.tencent.mm.plugin.wallet_core.ui.d.a(favorPayInfo, WcPayCashierDialog.this.IlN)) {
                                if (cI.size() == 0) {
                                    favorPayInfo.HXM = WcPayCashierDialog.this.getContext().getString(R.string.ick);
                                } else {
                                    favorPayInfo.HXM = WcPayCashierDialog.this.getContext().getString(R.string.icl);
                                }
                                WcPayCashierDialog.b(WcPayCashierDialog.this, favorPayInfo);
                            } else {
                                WcPayCashierDialog.this.HGf = favorPayInfo;
                                WcPayCashierDialog.this.show();
                            }
                            WcPayCashierDialog.p(WcPayCashierDialog.this);
                            WcPayCashierDialog.q(WcPayCashierDialog.this);
                            WcPayCashierDialog.a(WcPayCashierDialog.this, WcPayCashierDialog.this.IlF.qWU);
                            AppMethodBeat.o(71338);
                        }
                    }, new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass3.AnonymousClass2 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(71339);
                            Log.i("MicroMsg.WcPayCashierDialog", "on cancel");
                            WcPayCashierDialog.this.IlJ = null;
                            WcPayCashierDialog.this.show();
                            AppMethodBeat.o(71339);
                        }
                    });
                    AppMethodBeat.o(71340);
                }
            });
        }
        A(this.IlF.qWU);
        AppMethodBeat.o(71375);
    }

    @Override // com.tencent.mm.ui.base.i
    public void show() {
        AppMethodBeat.i(71376);
        super.show();
        AppMethodBeat.o(71376);
    }

    private void A(TextView textView) {
        boolean z;
        AppMethodBeat.i(71377);
        com.tencent.mm.plugin.wallet_core.ui.d a2 = e.INSTANCE.a(this.CwO);
        j aVJ = a2.aVJ(this.HGf.HXI);
        List<t> fSz = a2.fSz();
        StringBuilder sb = new StringBuilder();
        String str = "";
        if (aVJ != null && aVJ.HEA > 0.0d) {
            sb.append(aVJ.HEC);
            z = true;
        } else if (fSz.size() > 0) {
            j fSy = a2.fSy();
            if (aVJ == null && a2.fSx() == 1 && fSy != null && fSy.HEB == 0 && this.IlQ && this.CwO.HZe.HEG != null && this.CwO.HZe.HEG.HEc == 1) {
                str = getContext().getString(R.string.ipc);
                z = false;
            } else {
                str = getContext().getString(R.string.ip6);
                z = true;
            }
        } else {
            z = true;
        }
        if (!(aVJ == null || aVJ.HEB == 0 || Util.isNullOrNil(sb))) {
            sb.append(",");
            sb.append(aVJ.HED);
        }
        if (!Util.isNullOrNil(sb) && !Util.isNullOrNil(str)) {
            sb.append(",");
            sb.append(str);
        } else if (!Util.isNullOrNil(str)) {
            sb.append(str);
        }
        String sb2 = sb.toString();
        Log.i("MicroMsg.WcPayCashierDialog", "favor text: %s", sb2);
        if (z) {
            textView.setTextColor(getContext().getResources().getColor(R.color.Orange));
        } else {
            textView.setTextColor(getContext().getResources().getColor(R.color.u_));
        }
        textView.setText(sb2);
        AppMethodBeat.o(71377);
    }

    private void fTy() {
        AppMethodBeat.i(71378);
        if (this.Ilt.getChildCount() == 0 && this.IlE.getVisibility() == 8) {
            Log.d("MicroMsg.WcPayCashierDialog", "invisible divider");
            this.zlb.setVisibility(8);
            AppMethodBeat.o(71378);
            return;
        }
        this.zlb.setVisibility(0);
        AppMethodBeat.o(71378);
    }

    private void fTz() {
        String str;
        AppMethodBeat.i(71379);
        if (!this.IlR) {
            if (this.IlD != null) {
                this.Ilt.removeView(this.IlD);
                this.IlD = null;
            }
            AppMethodBeat.o(71379);
            return;
        }
        if (this.IlD == null) {
            this.IlD = new WcPayCashierDetailItemLayout(getContext());
            this.Ilt.addView(this.IlD, 0);
            this.IlD.Cqw.setText(R.string.ix7);
            this.IlD.Ili.setVisibility(8);
            this.IlD.Ilj.setVisibility(8);
            this.IlD.fTs();
            try {
                this.IlD.qWU.setTypeface(Typeface.createFromAsset(getContext().getAssets(), f.aqk(7)));
            } catch (Exception e2) {
                Log.e("MicroMsg.WcPayCashierDialog", "setTypeface() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            }
            this.IlD.qWU.getPaint().setFlags(16);
        }
        String str2 = "";
        if (!Util.isNullOrNil(this.CwO.HZu) && !Util.isNullOrNil(this.CwO.HZw)) {
            str2 = String.format("%s%s", this.CwO.HZw, this.CwO.HZu);
        }
        String d2 = f.d(this.CwO.dDO, this.CwO.AOl);
        if (!Util.isNullOrNil(str2)) {
            str = String.format("%s(%s)", d2, str2);
        } else {
            str = d2;
        }
        this.IlD.qWU.setText(str);
        AppMethodBeat.o(71379);
    }

    private void fTA() {
        AppMethodBeat.i(71380);
        if (!this.IlP) {
            Log.i("MicroMsg.WcPayCashierDialog", "can not change pay way");
            this.IlE.setVisibility(8);
            AppMethodBeat.o(71380);
            return;
        }
        this.IlE.setVisibility(0);
        this.IlE.Cqw.setText(R.string.ix8);
        this.IlE.Ili.setVisibility(0);
        this.IlE.Ilj.setVisibility(0);
        this.IlE.fTs();
        this.IlE.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(71341);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.WcPayCashierDialog", "click bankcard item");
                WcPayCashierDialog.s(WcPayCashierDialog.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71341);
            }
        });
        this.IlE.Ili.setImageBitmap(null);
        a(this.IlN, this.IlE.Ili);
        String str = this.IlN == null ? "" : this.IlN.field_desc;
        if (this.IlN != null && this.IlN.fQf()) {
            str = l.c(this.mContext, str);
        }
        this.IlE.U(str);
        AppMethodBeat.o(71380);
    }

    private void a(Bankcard bankcard, CdnImageView cdnImageView) {
        AppMethodBeat.i(71381);
        if (bankcard == null) {
            Log.e("MicroMsg.WcPayCashierDialog", "setBankcardText bankcard == null");
            AppMethodBeat.o(71381);
        } else if (bankcard.fQb()) {
            cdnImageView.setImageResource(R.drawable.cqo);
            AppMethodBeat.o(71381);
        } else if (bankcard.fQc()) {
            this.HCH.a(bankcard, cdnImageView);
            AppMethodBeat.o(71381);
        } else {
            if (bankcard.fQf()) {
                cdnImageView.setImageDrawable(com.tencent.mm.svg.a.a.h(getContext().getResources(), R.raw.honey_pay_bank_logo));
                if (!Util.isNullOrNil(bankcard.HVU)) {
                    cdnImageView.setUseSdcardCache(true);
                    cdnImageView.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.fSn());
                    cdnImageView.gI(bankcard.HVU, R.raw.honey_pay_bank_logo);
                    AppMethodBeat.o(71381);
                    return;
                }
            } else {
                this.HCH.a(getContext(), bankcard, cdnImageView);
            }
            AppMethodBeat.o(71381);
        }
    }

    private void fTB() {
        AppMethodBeat.i(71382);
        fTC();
        fTF();
        AppMethodBeat.o(71382);
    }

    private void fTC() {
        String str;
        AppMethodBeat.i(71383);
        String str2 = "";
        if (this.IlV) {
            str = this.IlT;
        } else {
            String string = this.mPayInfo.iqp == null ? "" : this.mPayInfo.iqp.getString("extinfo_key_19", "");
            if (!Util.isNullOrNil(string)) {
                str2 = string;
            } else if (this.mPayInfo.dVv == 32 || this.mPayInfo.dVv == 33) {
                String string2 = this.mPayInfo.iqp.getString("extinfo_key_5", "");
                String string3 = this.mPayInfo.iqp.getString("extinfo_key_1", "");
                String string4 = getContext().getString(R.string.ip_);
                if (!Util.isNullOrNil(string2)) {
                    string4 = string2;
                    str2 = string2;
                }
                if (!Util.isNullOrNil(string3)) {
                    as bjJ = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(string3);
                    if (bjJ != null) {
                        Object[] objArr = new Object[1];
                        objArr[0] = f.bpz(bjJ.arJ()) + (Util.isNullOrNil(this.mPayInfo.Cpg) ? "" : "(" + this.mPayInfo.Cpg + ")");
                        str2 = Util.safeFormatString(string4, objArr);
                    } else {
                        Log.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(string3)));
                    }
                } else {
                    Log.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                }
            } else if (this.mPayInfo.dVv == 31) {
                String string5 = this.mPayInfo.iqp.getString("extinfo_key_1", "");
                if (!Util.isNullOrNil(string5)) {
                    as bjJ2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(string5);
                    if (bjJ2 != null) {
                        String arI = bjJ2.arI();
                        Context context = getContext();
                        Object[] objArr2 = new Object[1];
                        objArr2[0] = arI + (Util.isNullOrNil(this.mPayInfo.Cpg) ? "" : "(" + this.mPayInfo.Cpg + ")");
                        str2 = context.getString(R.string.ip_, objArr2);
                    } else {
                        Log.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(string5)));
                    }
                } else {
                    Log.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                }
            } else if (this.mPayInfo.dVv == 42) {
                String string6 = this.mPayInfo.iqp.getString("extinfo_key_1", "");
                if (!Util.isNullOrNil(string6)) {
                    com.tencent.mm.kernel.g.aAi();
                    as bjJ3 = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(string6);
                    if (bjJ3 != null) {
                        String arI2 = bjJ3.arI();
                        Context context2 = getContext();
                        Object[] objArr3 = new Object[1];
                        objArr3[0] = arI2 + (Util.isNullOrNil(this.mPayInfo.Cpg) ? "" : "(" + this.mPayInfo.Cpg + ")");
                        str2 = context2.getString(R.string.ip3, objArr3);
                    } else {
                        Log.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(string6)));
                    }
                } else {
                    Log.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                }
            } else if (this.mPayInfo.dVv == 48) {
                str2 = getContext().getString(R.string.frm);
            } else if (this.mPayInfo.dVv == 49) {
                String string7 = this.mPayInfo.iqp.getString("extinfo_key_1", "");
                if (!Util.isNullOrNil(string7)) {
                    str2 = getContext().getString(R.string.ip_, string7);
                } else {
                    Log.e("MicroMsg.WcPayCashierDialog", "userName is null, scene is %s", Integer.valueOf(this.mPayInfo.dVv));
                }
            } else if (this.mPayInfo.dVv == 56) {
                String string8 = this.mPayInfo.iqp.getString("extinfo_key_12", "");
                if (!Util.isNullOrNil(string8)) {
                    str2 = string8;
                } else {
                    Log.e("MicroMsg.WcPayCashierDialog", "title is null, scene is %s", Integer.valueOf(this.mPayInfo.dVv));
                }
            } else if (this.mPayInfo.dVv == 45 || this.mPayInfo.dVv == 52) {
                str2 = getContext().getString(R.string.iig);
            } else if (this.mPayInfo.dVv == 11) {
                str2 = getContext().getString(R.string.i7i);
            }
            if (!Util.isNullOrNil(str2) || this.CwO == null || this.CwO.HZd == null) {
                Log.w("MicroMsg.WcPayCashierDialog", "orders null?:" + (this.CwO == null));
            } else {
                Orders.Commodity commodity = this.CwO.HZd.get(0);
                if (commodity != null) {
                    str = commodity.AOa;
                    if (a(this.mPayInfo)) {
                        if (!Util.isNullOrNil(str)) {
                            str = str + "\n";
                        }
                        str = str + commodity.desc;
                    }
                    if (Util.isNullOrNil(str)) {
                        str = commodity.desc;
                    }
                }
            }
            str = str2;
        }
        this.Ilr.setText(str);
        AppMethodBeat.o(71383);
    }

    private void fTD() {
        AppMethodBeat.i(71384);
        if (!Util.isNullOrNil(this.IlS)) {
            this.Ijg.setText(this.IlS);
            this.Ijg.setVisibility(0);
            AppMethodBeat.o(71384);
            return;
        }
        this.Ijg.setVisibility(8);
        AppMethodBeat.o(71384);
    }

    private void fTE() {
        AppMethodBeat.i(71385);
        if (!this.IlQ || this.CwO.HZe.HEG == null || this.CwO.HZe.HEG.HEc != 1) {
            aeW(8);
            AppMethodBeat.o(71385);
            return;
        }
        final com.tencent.mm.plugin.wallet.a.b bVar = this.CwO.HZe.HEG;
        this.Ilz.setUrl(bVar.HEj);
        this.IlA.setText(bVar.HEe);
        if (!Util.isNullOrNil(bVar.HEf)) {
            this.IlA.setTextColor(g.cI(bVar.HEf, true));
        }
        this.IlB.setText(bVar.HEg);
        if (!Util.isNullOrNil(bVar.HEh)) {
            this.IlB.setTextColor(g.cI(bVar.HEh, true));
        }
        this.IlB.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(71342);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.WcPayCashierDialog", "click bank favor btn");
                WcPayCashierDialog.this.IlQ = false;
                WcPayCashierDialog.this.IlN = com.tencent.mm.plugin.wallet_core.model.t.fQI().aVm(bVar.HEb.ANo);
                FavorPayInfo aVM = e.INSTANCE.a(WcPayCashierDialog.this.CwO).aVM(bVar.HEd);
                Log.i("MicroMsg.WcPayCashierDialog", "set favor info: %s", aVM.HXI);
                if (aVM.HXI.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    WcPayCashierDialog.u(WcPayCashierDialog.this);
                } else {
                    WcPayCashierDialog.this.HGf = aVM;
                }
                WcPayCashierDialog.p(WcPayCashierDialog.this);
                WcPayCashierDialog.q(WcPayCashierDialog.this);
                WcPayCashierDialog.v(WcPayCashierDialog.this);
                WcPayCashierDialog.w(WcPayCashierDialog.this);
                WcPayCashierDialog.x(WcPayCashierDialog.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71342);
            }
        });
        aeW(0);
        AppMethodBeat.o(71385);
    }

    private void aeW(int i2) {
        AppMethodBeat.i(71386);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ilv.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.Ilw.getLayoutParams();
        if (i2 == 0) {
            layoutParams.topMargin = Ilo;
            layoutParams2.topMargin = Ilo;
        } else {
            layoutParams.topMargin = Ilm;
            layoutParams2.topMargin = Iln;
        }
        this.Ilv.setLayoutParams(layoutParams);
        this.Ilw.setLayoutParams(layoutParams2);
        this.Ily.setVisibility(i2);
        AppMethodBeat.o(71386);
    }

    private void fTF() {
        String d2;
        AppMethodBeat.i(71387);
        if (this.IlV) {
            d2 = this.IlU;
        } else {
            com.tencent.mm.plugin.wallet_core.ui.d a2 = e.INSTANCE.a(this.CwO);
            d2 = f.d(this.CwO.dDO, this.CwO.AOl);
            this.IlR = false;
            if (a2 != null) {
                j aVJ = a2.aVJ(this.HGf.HXI);
                List<t> fSz = a2.fSz();
                if (aVJ != null && aVJ.HEA > 0.0d) {
                    this.IlR = true;
                    d2 = f.d(aVJ.HEz, this.CwO.AOl);
                } else if (aVJ == null || fSz.size() <= 0) {
                    d2 = f.d(this.CwO.dDO, this.CwO.AOl);
                } else {
                    d2 = f.d(aVJ.HEz, this.CwO.AOl);
                }
            }
        }
        this.Ils.setText(d2);
        AppMethodBeat.o(71387);
    }

    private static boolean a(PayInfo payInfo) {
        if (payInfo == null || (payInfo.dVv != 31 && payInfo.dVv != 32 && payInfo.dVv != 33)) {
            return false;
        }
        return true;
    }

    private void fTG() {
        boolean z;
        AppMethodBeat.i(71388);
        fTH();
        Log.i("MicroMsg.WcPayCashierDialog", "use touch pay: %s", Integer.valueOf(this.CwO.HZa));
        if (this.IlK == 0) {
            if (this.IlL > 0) {
                z = false;
            } else if (this.IlM == 1) {
                this.Ilx.setVisibility(8);
                z = true;
            } else if (this.IlM == 3) {
                this.Ilx.setText(R.string.icp);
                this.Ilx.setVisibility(0);
                z = true;
            } else {
                if (this.mPayInfo.Kxu == 100102) {
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_LAST_IS_SEVERE_ERROR_BOOLEAN_SYNC, Boolean.TRUE);
                    com.tencent.mm.plugin.fingerprint.d.a aVar = (com.tencent.mm.plugin.fingerprint.d.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
                    aVar.pj(false);
                    aVar.pk(false);
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.FALSE);
                    this.Ilx.setText(R.string.icw);
                } else {
                    this.Ilx.setText(R.string.icp);
                }
                this.Ilx.setTextColor(getContext().getResources().getColor(R.color.aeo));
                this.Ilx.setVisibility(0);
                z = true;
            }
            yv(z);
            AppMethodBeat.o(71388);
        } else if (this.IlK == 1) {
            fTI();
            AppMethodBeat.o(71388);
        } else {
            if (this.IlK == 2) {
                fTJ();
            }
            AppMethodBeat.o(71388);
        }
    }

    private void fTH() {
        boolean z;
        AppMethodBeat.i(71389);
        Log.i("MicroMsg.WcPayCashierDialog", "update verify way: %s", Integer.valueOf(this.CwO.HZa));
        if (this.CwO.HZa == 1) {
            com.tencent.mm.plugin.fingerprint.d.a aVar = (com.tencent.mm.plugin.fingerprint.d.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
            if (aVar.dJT() && aVar.dJU() && !aVar.dJP() && aVar.dJO() && aVar.dJX()) {
                this.IlL = 1;
            } else if (!aVar.dKb() || !aVar.dKc() || aVar.dJQ() || !aVar.dJR() || !aVar.dJX()) {
                this.IlL = 0;
                this.IlM = 2;
            } else {
                this.IlL = 2;
            }
            boolean z2 = p.IML.wFM;
            if (com.tencent.mm.plugin.wallet_core.model.t.fQI() == null || this.IlL <= 0) {
                z = true;
            } else {
                z = aVar.dKa();
            }
            aT(z, z2);
            boolean z3 = z & (!z2);
            if (!z3) {
                p.IML.wFM = true;
                this.IlL = 0;
                this.IlM = 3;
                this.mPayInfo.HZb = true;
                p.IML.wFM = true;
            } else if (this.mPayInfo.Kxu == 100000 || this.mPayInfo.Kxu == 100102) {
                if (this.mPayInfo.Kxu == 100000) {
                    this.mPayInfo.Ijy = 0;
                }
                this.IlL = 0;
                this.IlM = 4;
            }
            this.IlK = this.IlL;
            Log.i("MicroMsg.WcPayCashierDialog", "keystatus: %s, errcode: %s, payway: %s, supportMode: %s", Boolean.valueOf(z3), Integer.valueOf(this.mPayInfo.Kxu), Integer.valueOf(this.IlK), Integer.valueOf(this.IlL));
            AppMethodBeat.o(71389);
            return;
        }
        this.IlK = 0;
        this.IlL = 0;
        this.IlM = 1;
        com.tencent.mm.plugin.fingerprint.d.a aVar2 = (com.tencent.mm.plugin.fingerprint.d.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        if (aVar2.dJT() && aVar2.dJU() && !aVar2.dJP() && aVar2.dJO()) {
            Log.w("MicroMsg.WcPayCashierDialog", "wired case");
            h.INSTANCE.dN(1104, 2);
        }
        AppMethodBeat.o(71389);
    }

    private static void aT(boolean z, boolean z2) {
        AppMethodBeat.i(71390);
        com.tencent.mm.plugin.fingerprint.d.a aVar = (com.tencent.mm.plugin.fingerprint.d.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        if (aVar.type() == 1 && ((aVar.dJO() || aVar.dJR()) && com.tencent.mm.plugin.soter.e.b.flX() && com.tencent.mm.plugin.soter.e.b.flW() && com.tencent.soter.core.a.hlf() == 0)) {
            Log.i("MicroMsg.WcPayCashierDialog", "may treble init error");
            h.INSTANCE.dN(1104, 23);
        } else if (aVar.type() == 2) {
            if (com.tencent.soter.core.a.hlf() == 1) {
                if (!com.tencent.soter.core.a.hlh()) {
                    Log.i("MicroMsg.WcPayCashierDialog", "soter service disconnected");
                    h.INSTANCE.dN(1104, 24);
                } else if (!z) {
                    Log.i("MicroMsg.WcPayCashierDialog", "soter treble key error");
                    h.INSTANCE.dN(1104, 25);
                }
            } else if (!z) {
                Log.i("MicroMsg.WcPayCashierDialog", "soter1.0 key error");
                h.INSTANCE.dN(1104, 26);
            }
        }
        if (aVar.type() == 2) {
            if (com.tencent.soter.core.a.hlf() == 0) {
                h.INSTANCE.dN(1104, 28);
            } else {
                h.INSTANCE.dN(1104, 31);
            }
        }
        if (!z) {
            h.INSTANCE.dN(1104, 27);
        }
        if (z2) {
            h.INSTANCE.dN(1104, 33);
        }
        AppMethodBeat.o(71390);
    }

    private void yv(boolean z) {
        AppMethodBeat.i(71391);
        Log.i("MicroMsg.WcPayCashierDialog", "switch to pwd: %s", Boolean.valueOf(z));
        this.IlK = 0;
        this.mPayInfo.Ijy = 0;
        this.Ilv.setVisibility(0);
        this.Ilw.setVisibility(8);
        this.Ilu.eIj();
        fTt();
        this.Ilp.setVisibility(0);
        if (z) {
            this.Ilq.setVisibility(8);
            AppMethodBeat.o(71391);
            return;
        }
        this.Ilq.setVisibility(0);
        AppMethodBeat.o(71391);
    }

    private void fTI() {
        AppMethodBeat.i(71392);
        this.IlK = 1;
        this.mPayInfo.Ijy = 1;
        this.Ilv.setVisibility(8);
        this.Ilw.setVisibility(0);
        this.Ilu.eIj();
        fTu();
        this.Ilp.setVisibility(8);
        this.Ilq.setText(R.string.ipd);
        AppMethodBeat.o(71392);
    }

    private void fTJ() {
        AppMethodBeat.i(71393);
        this.IlK = 2;
        this.mPayInfo.Ijy = 1;
        this.Ilv.setVisibility(8);
        this.Ilw.setVisibility(0);
        this.Ilu.eIj();
        fTu();
        this.Ilp.setVisibility(8);
        this.Ilq.setText(R.string.ipd);
        AppMethodBeat.o(71393);
    }

    private void a(boolean z, int i2, final boolean z2, final FavorPayInfo favorPayInfo) {
        int i3;
        String str;
        ArrayList<Bankcard> yh;
        boolean z3;
        AppMethodBeat.i(71394);
        Log.i("MicroMsg.WcPayCashierDialog", "go to bankcard dialog");
        if (this.IlI != null) {
            this.IlI.dismiss();
        }
        hide();
        this.Ilu.eIj();
        if (this.mPayInfo == null) {
            i3 = 0;
        } else {
            i3 = this.mPayInfo.dVv;
        }
        if (this.mPayInfo == null) {
            str = "";
        } else {
            str = this.mPayInfo.dDL;
        }
        af.f(i3, str, 11, "");
        this.IlI = new a(this.mContext);
        a aVar = this.IlI;
        PayInfo payInfo = this.mPayInfo;
        Orders orders = this.CwO;
        Bankcard bankcard = this.IlN;
        Object[] objArr = new Object[3];
        objArr[0] = bankcard == null ? "" : bankcard.field_desc;
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i2);
        Log.i("MicroMsg.WcPayCashierBankcardDialog", "set view data: %s, %s, %s", objArr);
        aVar.mPayInfo = payInfo;
        aVar.CwO = orders;
        aVar.HGf = favorPayInfo;
        aVar.HJA = bankcard;
        aVar.IkW = orders.HQg;
        aVar.IkX = z;
        aVar.IkY = i2;
        if (aVar.IkX) {
            aVar.IkZ = false;
        }
        if (aVar.mPayInfo.dVv == 8) {
            yh = com.tencent.mm.plugin.wallet_core.model.af.yh(true);
        } else {
            yh = com.tencent.mm.plugin.wallet_core.model.af.yh(false);
        }
        if (aVar.HGf != null) {
            if (aVar.HGf.HXJ != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 && aVar.IkX) {
                String str2 = aVar.HGf.HXK;
                ArrayList<Bankcard> arrayList = new ArrayList<>();
                for (int i4 = 0; i4 < yh.size(); i4++) {
                    Bankcard bankcard2 = yh.get(i4);
                    if (Util.isNullOrNil(str2)) {
                        if (!bankcard2.field_bankcardType.equalsIgnoreCase("CFT")) {
                            arrayList.add(bankcard2);
                        }
                    } else if (bankcard2.field_bankcardType.equals(str2)) {
                        arrayList.add(bankcard2);
                    }
                }
                yh = arrayList;
            }
        }
        for (Bankcard bankcard3 : yh) {
            WcPayCashierBankcardItemLayout wcPayCashierBankcardItemLayout = new WcPayCashierBankcardItemLayout(aVar.getContext());
            aVar.IkV.add(wcPayCashierBankcardItemLayout);
            aVar.IkT.addView(wcPayCashierBankcardItemLayout);
            if (bankcard3.fQb()) {
                com.tencent.mm.plugin.wallet_core.utils.a.m(wcPayCashierBankcardItemLayout.qgQ);
            } else if (bankcard3.fQc()) {
                aVar.HCH.a(bankcard3, wcPayCashierBankcardItemLayout.qgQ);
            } else if (bankcard3.fQf()) {
                wcPayCashierBankcardItemLayout.qgQ.setImageDrawable(com.tencent.mm.svg.a.a.h(aVar.getContext().getResources(), R.raw.honey_pay_bank_logo));
                if (!Util.isNullOrNil(bankcard3.HVU)) {
                    wcPayCashierBankcardItemLayout.qgQ.setUseSdcardCache(true);
                    wcPayCashierBankcardItemLayout.qgQ.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.fSn());
                    wcPayCashierBankcardItemLayout.qgQ.gI(bankcard3.HVU, R.raw.honey_pay_bank_logo);
                }
            } else {
                aVar.HCH.a(aVar.getContext(), bankcard3, wcPayCashierBankcardItemLayout.qgQ);
            }
            if (bankcard3.fQb()) {
                Bankcard bankcard4 = com.tencent.mm.plugin.wallet_core.model.t.fQI().Hwc;
                if (!Util.isNullOrNil(bankcard4.HVD)) {
                    wcPayCashierBankcardItemLayout.Ild.setText(bankcard4.HVD);
                } else if (bankcard4.HVC >= 0.0d) {
                    TextView textView = wcPayCashierBankcardItemLayout.Ild;
                    Context context = aVar.getContext();
                    aVar.getContext();
                    textView.setText(context.getString(ah.hhF(), f.D(bankcard4.HVC)));
                } else {
                    wcPayCashierBankcardItemLayout.Ild.setText("");
                }
            } else if (bankcard3.fQc()) {
                Bankcard bankcard5 = com.tencent.mm.plugin.wallet_core.model.t.fQI().IbQ;
                if (!Util.isNullOrNil(bankcard5.HVD)) {
                    wcPayCashierBankcardItemLayout.Ild.setText(bankcard5.HVD);
                } else if (bankcard5.HVC >= 0.0d) {
                    wcPayCashierBankcardItemLayout.Ild.setText(aVar.getContext().getString(R.string.ig2, f.D(bankcard5.HVC)));
                } else {
                    wcPayCashierBankcardItemLayout.Ild.setText("");
                }
            } else if (bankcard3.fQf()) {
                wcPayCashierBankcardItemLayout.Ild.setText(l.b(aVar.getContext(), bankcard3.field_desc, wcPayCashierBankcardItemLayout.Ild.getTextSize()));
            } else {
                wcPayCashierBankcardItemLayout.Ild.setText(bankcard3.field_desc);
            }
            String str3 = "";
            switch (bankcard3.a(aVar.IkW, aVar.CwO)) {
                case 1:
                    str3 = aVar.getContext().getString(R.string.in4);
                    break;
                case 2:
                    str3 = aVar.getContext().getString(R.string.in_);
                    break;
                case 3:
                    str3 = aVar.getContext().getString(R.string.ine);
                    break;
                case 4:
                    str3 = aVar.getContext().getString(R.string.in6);
                    break;
                case 5:
                    str3 = aVar.getContext().getString(R.string.in2);
                    break;
                case 6:
                    str3 = aVar.getContext().getString(R.string.in8);
                    break;
                case 7:
                    str3 = aVar.getContext().getString(R.string.inc);
                    break;
                case 8:
                    str3 = bankcard3.field_forbidWord;
                    break;
                default:
                    if (!Util.isNullOrNil(bankcard3.field_tips)) {
                        str3 = bankcard3.field_tips;
                        break;
                    }
                    break;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
            if (!Util.isNullOrNil(bankcard3.field_forbid_title) && !Util.isNullOrNil(bankcard3.field_forbid_url)) {
                spannableStringBuilder.append((CharSequence) "  ");
                spannableStringBuilder.append((CharSequence) bankcard3.field_forbid_title);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(aVar.getContext().getResources().getColor(R.color.adz)), str3.length() + 2, spannableStringBuilder.length(), 34);
                wcPayCashierBankcardItemLayout.Ile.setOnClickListener(new View.OnClickListener(bankcard3) {
                    /* class com.tencent.mm.plugin.wallet_core.ui.cashier.a.AnonymousClass5 */
                    final /* synthetic */ Bankcard HuJ;

                    {
                        this.HuJ = r2;
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.i(71311);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierBankcardDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Intent intent = new Intent();
                        Log.i("MicroMsg.WcPayCashierBankcardDialog", "go to url %s", this.HuJ.field_forbid_url);
                        intent.putExtra("rawUrl", this.HuJ.field_forbid_url);
                        intent.putExtra("geta8key_username", z.aTY());
                        intent.putExtra("pay_channel", 1);
                        f.b(a.this.mContext, intent, 1);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierBankcardDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(71311);
                    }
                });
            }
            if (!Util.isNullOrNil(spannableStringBuilder)) {
                wcPayCashierBankcardItemLayout.Ile.setVisibility(0);
                wcPayCashierBankcardItemLayout.Ile.setText(spannableStringBuilder);
            }
            if (aVar.IkZ && Util.isNullOrNil(spannableStringBuilder)) {
                LinkedList<String> h2 = aVar.h(bankcard3);
                if (h2.size() > 0) {
                    wcPayCashierBankcardItemLayout.Iga.setVisibility(0);
                    wcPayCashierBankcardItemLayout.Ile.setVisibility(8);
                    wcPayCashierBankcardItemLayout.Iga.setWording(h2);
                }
            }
            if (aVar.HJA != null && bankcard3.field_bindSerial.equals(aVar.HJA.field_bindSerial)) {
                wcPayCashierBankcardItemLayout.Ilf.setChecked(true);
            }
            if (bankcard3.a(aVar.IkW, aVar.CwO) != 0) {
                wcPayCashierBankcardItemLayout.Ilf.setChecked(false);
                wcPayCashierBankcardItemLayout.Ild.setTextColor(aVar.getContext().getResources().getColor(R.color.u_));
                wcPayCashierBankcardItemLayout.setEnabled(false);
            } else {
                wcPayCashierBankcardItemLayout.Ild.setTextColor(aVar.getContext().getResources().getColor(R.color.a2x));
                wcPayCashierBankcardItemLayout.setEnabled(true);
            }
            wcPayCashierBankcardItemLayout.setOnClickListener(new View.OnClickListener(bankcard3) {
                /* class com.tencent.mm.plugin.wallet_core.ui.cashier.a.AnonymousClass6 */
                final /* synthetic */ Bankcard HuJ;

                {
                    this.HuJ = r2;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(71312);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierBankcardDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.d("MicroMsg.WcPayCashierBankcardDialog", "click bankcard: %s", this.HuJ.field_bindSerial);
                    a.a(a.this, view);
                    a.this.dismiss();
                    if (a.this.Ila != null) {
                        a.this.Ila.j(this.HuJ);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierBankcardDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(71312);
                }
            });
        }
        WcPayCashierBankcardItemLayout wcPayCashierBankcardItemLayout2 = new WcPayCashierBankcardItemLayout(aVar.getContext());
        wcPayCashierBankcardItemLayout2.qgQ.setVisibility(4);
        wcPayCashierBankcardItemLayout2.Ild.setText(R.string.imy);
        wcPayCashierBankcardItemLayout2.Ild.setTextColor(aVar.getContext().getResources().getColor(R.color.x0));
        wcPayCashierBankcardItemLayout2.Ilf.setVisibility(8);
        LinkedList<String> fTq = aVar.fTq();
        if (aVar.IkZ && fTq.size() > 0) {
            wcPayCashierBankcardItemLayout2.Iga.setVisibility(0);
            wcPayCashierBankcardItemLayout2.Ile.setVisibility(8);
            wcPayCashierBankcardItemLayout2.Iga.setWording(fTq);
        }
        wcPayCashierBankcardItemLayout2.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.a.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(71313);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierBankcardDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.WcPayCashierBankcardDialog", "click bind new card");
                a.this.dismiss();
                if (a.this.Ila != null) {
                    a.this.Ila.fNc();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierBankcardDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71313);
            }
        });
        aVar.IkT.addView(wcPayCashierBankcardItemLayout2);
        String str4 = "";
        if (!(aVar.CwO == null || aVar.CwO.HZd == null || aVar.CwO.HZd.size() <= 0)) {
            str4 = aVar.getContext().getString(R.string.ian, f.d(aVar.CwO.dDO, aVar.CwO.AOl), aVar.CwO.HZd.get(0).desc);
        }
        if (aVar.HGf != null && !Util.isNullOrNil(aVar.HGf.HXM)) {
            aVar.IkU.setVisibility(0);
            aVar.IkU.setText(aVar.HGf.HXM);
            aVar.HGf.HXM = "";
        } else if (aVar.IkY != 0) {
            aVar.IkU.setVisibility(0);
            aVar.IkU.setText(str4);
        } else {
            aVar.IkU.setVisibility(8);
        }
        this.IlY.add(this.IlI.Ilb);
        this.IlI.Ila = new a.AbstractC1921a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.cashier.a.AbstractC1921a
            public final void j(Bankcard bankcard) {
                int i2 = 0;
                AppMethodBeat.i(71350);
                if (bankcard == null) {
                    AppMethodBeat.o(71350);
                    return;
                }
                Log.i("MicroMsg.WcPayCashierDialog", "on select bankcard: %s, %s", bankcard.field_bankName, bankcard.field_bindSerial);
                if (WcPayCashierDialog.this.IlN == null || !bankcard.field_bindSerial.equals(WcPayCashierDialog.this.IlN.field_bindSerial)) {
                    if (WcPayCashierDialog.this.mPayInfo != null) {
                        i2 = WcPayCashierDialog.this.mPayInfo.dVv;
                    }
                    af.f(i2, WcPayCashierDialog.this.mPayInfo == null ? "" : WcPayCashierDialog.this.mPayInfo.dDL, 13, bankcard.field_bindSerial);
                    WcPayCashierDialog.this.IlN = bankcard;
                    WcPayCashierDialog.this.HGf = favorPayInfo;
                    WcPayCashierDialog.u(WcPayCashierDialog.this);
                    WcPayCashierDialog.p(WcPayCashierDialog.this);
                    WcPayCashierDialog.q(WcPayCashierDialog.this);
                    WcPayCashierDialog.v(WcPayCashierDialog.this);
                    WcPayCashierDialog.w(WcPayCashierDialog.this);
                    WcPayCashierDialog.E(WcPayCashierDialog.this);
                }
                WcPayCashierDialog.this.IlI.a(WcPayCashierDialog.this);
                WcPayCashierDialog.this.IlI = null;
                WcPayCashierDialog.this.show();
                AppMethodBeat.o(71350);
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.cashier.a.AbstractC1921a
            public final void fNc() {
                AppMethodBeat.i(71351);
                Log.i("MicroMsg.WcPayCashierDialog", "on click add new bankcard");
                WcPayCashierDialog.this.IlI.a(WcPayCashierDialog.this);
                WcPayCashierDialog.this.IlI = null;
                if (WcPayCashierDialog.this.IlX != null) {
                    WcPayCashierDialog.this.IlX.fNc();
                }
                WcPayCashierDialog.this.dismiss();
                AppMethodBeat.o(71351);
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.cashier.a.AbstractC1921a
            public final void onCancel() {
                AppMethodBeat.i(71352);
                Log.i("MicroMsg.WcPayCashierDialog", "on bankcard dialog cancel");
                WcPayCashierDialog.this.IlI.a(WcPayCashierDialog.this);
                WcPayCashierDialog.this.IlI = null;
                WcPayCashierDialog.this.show();
                AppMethodBeat.o(71352);
            }
        };
        this.IlI.show();
        AppMethodBeat.o(71394);
    }

    static /* synthetic */ void d(WcPayCashierDialog wcPayCashierDialog) {
        AppMethodBeat.i(71395);
        for (b bVar : wcPayCashierDialog.IlY) {
            bVar.fTr();
        }
        AppMethodBeat.o(71395);
    }

    static /* synthetic */ void a(WcPayCashierDialog wcPayCashierDialog, String str, FavorPayInfo favorPayInfo) {
        AppMethodBeat.i(71396);
        if (wcPayCashierDialog.IlV || !wcPayCashierDialog.IlP || wcPayCashierDialog.IlN != null) {
            if (!wcPayCashierDialog.IlW && wcPayCashierDialog.IlX != null) {
                wcPayCashierDialog.IlX.a(str, favorPayInfo, wcPayCashierDialog.IlN);
            }
            wcPayCashierDialog.dismiss();
            AppMethodBeat.o(71396);
            return;
        }
        Toast.makeText(wcPayCashierDialog.getContext(), (int) R.string.ix6, 1).show();
        AppMethodBeat.o(71396);
    }

    static /* synthetic */ void j(WcPayCashierDialog wcPayCashierDialog) {
        AppMethodBeat.i(71400);
        Log.i("MicroMsg.WcPayCashierDialog", "go to verify fingerprint");
        if (wcPayCashierDialog.IlH != null) {
            wcPayCashierDialog.IlH.dismiss();
        }
        com.tencent.mm.plugin.soter.d.a.flK();
        wcPayCashierDialog.IlO = false;
        wcPayCashierDialog.IlH = new WcPayCashierFingerprintDialog(wcPayCashierDialog.getContext());
        String str = wcPayCashierDialog.mPayInfo.wFE;
        if (Util.isNullOrNil(str)) {
            str = wcPayCashierDialog.CwO.wFE;
        }
        WcPayCashierFingerprintDialog wcPayCashierFingerprintDialog = wcPayCashierDialog.IlH;
        String str2 = wcPayCashierDialog.mPayInfo.dDL;
        Log.i("MicroMsg.WcPayCashierFingerprintDialog", "set view data: %s", str2);
        wcPayCashierFingerprintDialog.Imm.dDL = str2;
        wcPayCashierFingerprintDialog.Imm.wFE = str;
        wcPayCashierDialog.IlH.Imn = new WcPayCashierFingerprintDialog.b() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog.b
            public final void a(com.tencent.mm.plugin.fingerprint.b.a.e eVar) {
                int i2;
                String str;
                AppMethodBeat.i(71343);
                Log.i("MicroMsg.WcPayCashierDialog", "verify succeeded: %s", Boolean.valueOf(WcPayCashierDialog.this.IlO));
                if (WcPayCashierDialog.this.IlO) {
                    AppMethodBeat.o(71343);
                    return;
                }
                if (WcPayCashierDialog.this.mPayInfo == null) {
                    i2 = 0;
                } else {
                    i2 = WcPayCashierDialog.this.mPayInfo.dVv;
                }
                if (WcPayCashierDialog.this.mPayInfo == null) {
                    str = "";
                } else {
                    str = WcPayCashierDialog.this.mPayInfo.dDL;
                }
                af.f(i2, str, 22, "");
                WcPayCashierDialog.this.mPayInfo.Ijy = 1;
                WcPayCashierDialog.this.mPayInfo.dNR = eVar.wFV.dNR;
                WcPayCashierDialog.this.mPayInfo.dNS = eVar.wFV.dNS;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("json", eVar.wFV.wFF);
                    jSONObject.put("signature", eVar.wFV.wFG);
                    jSONObject.put("soter_type", com.tencent.mm.plugin.wallet_core.model.t.fQI().fRq());
                    WcPayCashierDialog.this.mPayInfo.dUV = jSONObject.toString();
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.WcPayCashierDialog", e2, "", new Object[0]);
                }
                WcPayCashierDialog.this.mPayInfo.dNP = eVar.wFV.dNP;
                WcPayCashierDialog.this.mPayInfo.Ijz = eVar.retryCount;
                WcPayCashierDialog.this.nmW.setVisibility(0);
                WcPayCashierDialog.this.IlH = null;
                WcPayCashierDialog.a(WcPayCashierDialog.this, "", WcPayCashierDialog.this.HGf);
                AppMethodBeat.o(71343);
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog.b
            public final void yw(boolean z) {
                int i2;
                int i3 = 0;
                AppMethodBeat.i(71344);
                Log.i("MicroMsg.WcPayCashierDialog", "verify failed");
                WcPayCashierDialog.l(WcPayCashierDialog.this);
                WcPayCashierDialog.this.Ilx.setText(R.string.icp);
                WcPayCashierDialog.this.Ilx.setVisibility(0);
                WcPayCashierDialog.this.mPayInfo.Ijy = 0;
                PayInfo payInfo = WcPayCashierDialog.this.mPayInfo;
                if (WcPayCashierDialog.this.IlH == null) {
                    i2 = 0;
                } else {
                    WcPayCashierFingerprintDialog wcPayCashierFingerprintDialog = WcPayCashierDialog.this.IlH;
                    i2 = wcPayCashierFingerprintDialog.Imm == null ? 0 : wcPayCashierFingerprintDialog.Imm.Iju;
                }
                payInfo.Ijz = i2;
                WcPayCashierDialog.this.mPayInfo.HZb |= z;
                WcPayCashierDialog.this.nmW.setVisibility(0);
                WcPayCashierDialog.this.IlH = null;
                af.f(WcPayCashierDialog.this.mPayInfo == null ? 0 : WcPayCashierDialog.this.mPayInfo.dVv, WcPayCashierDialog.this.mPayInfo == null ? "" : WcPayCashierDialog.this.mPayInfo.dDL, 23, "");
                if (WcPayCashierDialog.this.mPayInfo != null) {
                    i3 = WcPayCashierDialog.this.mPayInfo.dVv;
                }
                af.f(i3, WcPayCashierDialog.this.mPayInfo == null ? "" : WcPayCashierDialog.this.mPayInfo.dDL, 25, "");
                AppMethodBeat.o(71344);
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog.b
            public final void fTK() {
                int i2 = 0;
                AppMethodBeat.i(71345);
                Log.i("MicroMsg.WcPayCashierDialog", "verify canceled");
                WcPayCashierDialog.this.IlO = true;
                WcPayCashierDialog.this.nmW.setVisibility(0);
                WcPayCashierDialog.this.IlH = null;
                if (WcPayCashierDialog.this.mPayInfo != null) {
                    i2 = WcPayCashierDialog.this.mPayInfo.dVv;
                }
                af.f(i2, WcPayCashierDialog.this.mPayInfo == null ? "" : WcPayCashierDialog.this.mPayInfo.dDL, 24, "");
                AppMethodBeat.o(71345);
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog.b
            public final void fTL() {
                AppMethodBeat.i(71346);
                Log.i("MicroMsg.WcPayCashierDialog", "switch pay way");
                WcPayCashierDialog.this.IlO = true;
                WcPayCashierDialog.this.nmW.setVisibility(0);
                WcPayCashierDialog.this.IlH = null;
                WcPayCashierDialog.m(WcPayCashierDialog.this);
                AppMethodBeat.o(71346);
            }
        };
        ((MMActivity) wcPayCashierDialog.mContext).getLifecycle().addObserver(wcPayCashierDialog.IlH);
        wcPayCashierDialog.IlH.show();
        wcPayCashierDialog.nmW.setVisibility(8);
        AppMethodBeat.o(71400);
    }

    static /* synthetic */ void k(WcPayCashierDialog wcPayCashierDialog) {
        AppMethodBeat.i(71401);
        Log.i("MicroMsg.WcPayCashierDialog", "go to verify faceid");
        h.INSTANCE.a(15817, 3);
        wcPayCashierDialog.IlO = false;
        com.tencent.mm.plugin.soter.d.a.flK();
        Bundle bundle = new Bundle();
        bundle.putInt("face_auth_scene", 1);
        ((com.tencent.mm.plugin.fingerprint.b.h) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.b.h.class)).a((MMActivity) wcPayCashierDialog.mContext, new com.tencent.mm.plugin.fingerprint.faceid.auth.a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.a
            public final void onAuthSuccess(int i2, int i3) {
                AppMethodBeat.i(71347);
                Log.i("MicroMsg.WcPayCashierDialog", "face id auth success");
                if (WcPayCashierDialog.this.IlO) {
                    AppMethodBeat.o(71347);
                    return;
                }
                WcPayCashierDialog.this.mPayInfo.Ijy = 1;
                WcPayCashierDialog.this.mPayInfo.dNR = "";
                WcPayCashierDialog.this.mPayInfo.dNS = "";
                try {
                    JSONObject jSONObject = new JSONObject(((com.tencent.mm.plugin.fingerprint.d.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).dJS());
                    jSONObject.put("soter_type", com.tencent.mm.plugin.wallet_core.model.t.fQI().fRq());
                    WcPayCashierDialog.this.mPayInfo.dUV = jSONObject.toString();
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.WcPayCashierDialog", e2, "", new Object[0]);
                }
                WcPayCashierDialog.this.mPayInfo.dNP = i2;
                WcPayCashierDialog.this.mPayInfo.Ijz = i3;
                WcPayCashierDialog.a(WcPayCashierDialog.this, "", WcPayCashierDialog.this.HGf);
                AppMethodBeat.o(71347);
            }

            @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.a
            public final void onAuthFail(int i2) {
                AppMethodBeat.i(71348);
                Log.i("MicroMsg.WcPayCashierDialog", "face id auth fail: %s, %s", Integer.valueOf(i2), Integer.valueOf(WcPayCashierDialog.this.mPayInfo.Ijz));
                WcPayCashierDialog.this.IlO = true;
                WcPayCashierDialog.this.nmW.setVisibility(0);
                WcPayCashierDialog.l(WcPayCashierDialog.this);
                WcPayCashierDialog.this.Ilx.setText(R.string.icp);
                WcPayCashierDialog.this.Ilx.setVisibility(0);
                WcPayCashierDialog.this.mPayInfo.Ijz++;
                AppMethodBeat.o(71348);
            }

            @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.a
            public final void onAuthCancel() {
                AppMethodBeat.i(71349);
                WcPayCashierDialog.this.IlO = true;
                WcPayCashierDialog.this.nmW.setVisibility(0);
                AppMethodBeat.o(71349);
            }
        }, bundle);
        wcPayCashierDialog.nmW.setVisibility(8);
        AppMethodBeat.o(71401);
    }

    static /* synthetic */ void m(WcPayCashierDialog wcPayCashierDialog) {
        int i2 = 0;
        AppMethodBeat.i(71403);
        Log.i("MicroMsg.WcPayCashierDialog", "trigger switch mVerifyWay: %s", Integer.valueOf(wcPayCashierDialog.IlK));
        if (wcPayCashierDialog.IlK == 0) {
            if (wcPayCashierDialog.IlL == 1) {
                if (wcPayCashierDialog.mPayInfo != null) {
                    i2 = wcPayCashierDialog.mPayInfo.dVv;
                }
                af.f(i2, wcPayCashierDialog.mPayInfo == null ? "" : wcPayCashierDialog.mPayInfo.dDL, 21, "");
                wcPayCashierDialog.fTI();
                AppMethodBeat.o(71403);
                return;
            } else if (wcPayCashierDialog.IlL == 2) {
                wcPayCashierDialog.fTJ();
                AppMethodBeat.o(71403);
                return;
            }
        } else if (wcPayCashierDialog.IlK == 1) {
            wcPayCashierDialog.yv(false);
            wcPayCashierDialog.Ilq.setText(R.string.icq);
            f.aqm(29);
            if (wcPayCashierDialog.mPayInfo != null) {
                i2 = wcPayCashierDialog.mPayInfo.dVv;
            }
            af.f(i2, wcPayCashierDialog.mPayInfo == null ? "" : wcPayCashierDialog.mPayInfo.dDL, 19, "");
            AppMethodBeat.o(71403);
            return;
        } else if (wcPayCashierDialog.IlK == 2) {
            wcPayCashierDialog.yv(false);
            wcPayCashierDialog.Ilq.setText(R.string.ici);
            h.INSTANCE.a(15817, 4);
        }
        AppMethodBeat.o(71403);
    }

    static /* synthetic */ void b(WcPayCashierDialog wcPayCashierDialog, FavorPayInfo favorPayInfo) {
        AppMethodBeat.i(71405);
        wcPayCashierDialog.a(true, -100, false, favorPayInfo);
        AppMethodBeat.o(71405);
    }

    static /* synthetic */ void s(WcPayCashierDialog wcPayCashierDialog) {
        AppMethodBeat.i(71409);
        wcPayCashierDialog.a(false, 0, false, wcPayCashierDialog.HGf);
        AppMethodBeat.o(71409);
    }

    static /* synthetic */ void E(WcPayCashierDialog wcPayCashierDialog) {
        AppMethodBeat.i(71414);
        if (wcPayCashierDialog.IlQ && wcPayCashierDialog.CwO.HZe.HEG != null && wcPayCashierDialog.CwO.HZe.HEG.HEc == 1 && wcPayCashierDialog.CwO.HZe.HEG.HEb != null) {
            FavorPayInfo aVM = e.INSTANCE.a(wcPayCashierDialog.CwO).aVM(wcPayCashierDialog.CwO.HZe.HEG.HEd);
            if (wcPayCashierDialog.IlN == null || aVM.HXI.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) || !aVM.HXN.contains(wcPayCashierDialog.IlN.field_bindSerial)) {
                wcPayCashierDialog.aeW(0);
                AppMethodBeat.o(71414);
                return;
            }
        }
        wcPayCashierDialog.aeW(8);
        AppMethodBeat.o(71414);
    }
}
