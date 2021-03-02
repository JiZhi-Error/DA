package com.tencent.mm.plugin.remittance.ui;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aah;
import com.tencent.mm.g.a.as;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.b.a.au;
import com.tencent.mm.g.b.a.kx;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.g;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.plugin.remittance.model.k;
import com.tencent.mm.plugin.remittance.model.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.eig;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.protocal.protobuf.ri;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.picker.e;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RemittanceBusiUI extends WalletBaseUI implements WcPayKeyboard.a {
    private String AJn;
    private int Cnv = 4;
    private String CqN;
    private IListener<as> Cqt = new IListener<as>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass22 */

        {
            AppMethodBeat.i(163822);
            this.__eventId = as.class.getName().hashCode();
            AppMethodBeat.o(163822);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(as asVar) {
            boolean z = false;
            AppMethodBeat.i(163823);
            as asVar2 = asVar;
            if (!(asVar2 instanceof as) || !asVar2.dDK.isKinda) {
                AppMethodBeat.o(163823);
                return false;
            }
            Log.i("MicroMsg.RemittanceBusiUI", "BusiF2fPaySuccEvent and isKindaScanQRCode");
            RemittanceBusiUI.this.CtP = false;
            MMHandlerThread.postToMainThreadDelayed(RemittanceBusiUI.this.jVx, 300);
            if (RemittanceBusiUI.this.mRequestCode == 3) {
                Log.i("MicroMsg.RemittanceBusiUI", "BusiF2fPaySuccEvent and isKindaScanQRCode and mRequestCode is REQUEST_CODE_PAY_DYNAMIC_CODE");
                RemittanceBusiUI remittanceBusiUI = RemittanceBusiUI.this;
                if (asVar2.dDK.dDN == 1) {
                    z = true;
                }
                RemittanceBusiUI.a(remittanceBusiUI, z, asVar2.dDK.dDM, asVar2.dDK.dDO, asVar2.dDK.dDL);
            } else if (RemittanceBusiUI.this.mRequestCode == 1) {
                Log.i("MicroMsg.RemittanceBusiUI", "BusiF2fPaySuccEvent and isKindaScanQRCode and mRequestCode is REQUEST_CODE_PAY");
                RemittanceBusiUI remittanceBusiUI2 = RemittanceBusiUI.this;
                if (asVar2.dDK.dDN == 1) {
                    z = true;
                }
                RemittanceBusiUI.a(remittanceBusiUI2, z, asVar2.dDK.dDM, asVar2.dDK.dDO, asVar2.dDK.dDL);
            } else if (RemittanceBusiUI.this.mRequestCode == 2) {
                Log.i("MicroMsg.RemittanceBusiUI", "BusiF2fPaySuccEvent and isKindaScanQRCode and mRequestCode is REQUEST_CODE_ZERO_PAY");
            }
            AppMethodBeat.o(163823);
            return true;
        }
    };
    private boolean CrC;
    private boolean CrF;
    private IListener CrH = new IListener<gl>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass28 */

        {
            AppMethodBeat.i(160844);
            this.__eventId = gl.class.getName().hashCode();
            AppMethodBeat.o(160844);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gl glVar) {
            AppMethodBeat.i(68039);
            gl glVar2 = glVar;
            if (glVar2.dKn.dKp == 1) {
                h.INSTANCE.a(15386, 4, 2);
            } else {
                h.INSTANCE.a(15386, 5, 2);
            }
            String str = glVar2.dKn.dKo;
            RemittanceBusiUI.this.CtR = (RemittanceF2fDynamicCodeUI) glVar2.dKn.dKq;
            RemittanceBusiUI.a(RemittanceBusiUI.this, str, glVar2);
            AppMethodBeat.o(68039);
            return false;
        }
    };
    private LinearLayout Crd;
    private String Crs;
    private boolean Crx = false;
    private kx Crz;
    private TextView CsU;
    private TextView CsV;
    private TextView CsW;
    private TextView CsX;
    private TextView CsY;
    private TextView CsZ;
    private String Csq;
    private String Csr;
    private String Csv;
    private BusiRemittanceResp Csz;
    private String CtA;
    private int CtB = 0;
    private int CtC = 0;
    private int CtD = 0;
    private int CtE = 0;
    private String CtF;
    private String CtG;
    private b CtH = new b();
    private String CtI = "";
    private String CtJ = "";
    boolean CtK = false;
    private boolean CtL = false;
    g CtM = null;
    private b CtN;
    private b CtO;
    protected boolean CtP = false;
    private Map<String, du> CtQ = new HashMap();
    private RemittanceF2fDynamicCodeUI CtR = null;
    private boolean CtS = false;
    private int CtT;
    private boolean CtU = false;
    private int CtV;
    private int CtW;
    private i CtX;
    private Runnable CtY = new Runnable() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass15 */

        public final void run() {
            AppMethodBeat.i(68028);
            RemittanceBusiUI.M(RemittanceBusiUI.this);
            AppMethodBeat.o(68028);
        }
    };
    private com.tencent.mm.wallet_core.d.c<l> CtZ = new com.tencent.mm.wallet_core.d.c<l>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass21 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, com.tencent.mm.wallet_core.d.d] */
        @Override // com.tencent.mm.wallet_core.d.c
        public final /* bridge */ /* synthetic */ boolean a(int i2, int i3, l lVar) {
            AppMethodBeat.i(163821);
            boolean a2 = RemittanceBusiUI.a(RemittanceBusiUI.this, i2, i3, lVar);
            AppMethodBeat.o(163821);
            return a2;
        }

        @Override // com.tencent.mm.wallet_core.d.c
        public final void a(d dVar) {
            AppMethodBeat.i(163820);
            if (dVar instanceof l) {
                RemittanceBusiUI.b(RemittanceBusiUI.this, ((l) dVar).dDL);
            }
            AppMethodBeat.o(163820);
        }
    };
    private TextView Cta;
    private View Ctb;
    private CdnImageView Ctc;
    private LinearLayout Ctd;
    private LinearLayout Cte;
    private TextView Ctf;
    private View Ctg;
    private TextView Cth;
    private Button Cti;
    private RelativeLayout Ctj;
    private String Ctk;
    private double Ctl;
    private String Ctm;
    private String Ctn;
    private String Cto;
    private String Ctp;
    private String Ctq;
    private int Ctr;
    private String Cts;
    private float Ctt = 0.0f;
    private boolean Ctu;
    private String Ctv;
    private int Ctw;
    private int Ctx;
    private String Cty;
    private eig Ctz;
    private c Cua = new c();
    private boolean Cub = true;
    private double Cuc = 0.0d;
    private String Cud;
    private String Cue = "";
    private IListener Cuf = new IListener<rn>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass29 */

        {
            AppMethodBeat.i(160845);
            this.__eventId = rn.class.getName().hashCode();
            AppMethodBeat.o(160845);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(rn rnVar) {
            AppMethodBeat.i(68040);
            rn rnVar2 = rnVar;
            if (!(rnVar2 == null || rnVar2.dYd == null)) {
                RemittanceBusiUI.a(RemittanceBusiUI.this, rnVar2.dYd.dGX, rnVar2.dYd.dYe);
            }
            AppMethodBeat.o(68040);
            return false;
        }
    };
    private IListener Cug = new IListener<gk>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass30 */

        {
            AppMethodBeat.i(163826);
            this.__eventId = gk.class.getName().hashCode();
            AppMethodBeat.o(163826);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gk gkVar) {
            AppMethodBeat.i(163827);
            RemittanceBusiUI.U(RemittanceBusiUI.this);
            AppMethodBeat.o(163827);
            return false;
        }
    };
    private IListener Cuh = new IListener<aah>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass31 */

        {
            AppMethodBeat.i(163828);
            this.__eventId = aah.class.getName().hashCode();
            AppMethodBeat.o(163828);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aah aah) {
            AppMethodBeat.i(163829);
            EventCenter.instance.removeListener(RemittanceBusiUI.this.Cuh);
            if (aah.ehe.result == -1) {
                WcPayKeyboard wcPayKeyboard = RemittanceBusiUI.this.mWcKeyboard;
                if (wcPayKeyboard.mInputEditText != null) {
                    wcPayKeyboard.mInputEditText.dispatchKeyEvent(new KeyEvent(1, 66));
                }
            }
            AppMethodBeat.o(163829);
            return false;
        }
    };
    private IListener Cui = new IListener<gm>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass32 */

        {
            AppMethodBeat.i(163830);
            this.__eventId = gm.class.getName().hashCode();
            AppMethodBeat.o(163830);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gm gmVar) {
            AppMethodBeat.i(163831);
            gm gmVar2 = gmVar;
            RemittanceBusiUI.this.a(7, RemittanceBusiUI.this.CtX);
            RemittanceBusiUI.this.CtV = gmVar2.dKr.dKt;
            RemittanceBusiUI.a(RemittanceBusiUI.this, gmVar2);
            AppMethodBeat.o(163831);
            return false;
        }
    };
    private String app_id;
    private double dDO = -1.0d;
    private String dRM;
    private int dYe = 0;
    private int jVe;
    private ScrollView jVf;
    private WcPayKeyboard jVg;
    private WalletFormView jVj;
    private RelativeLayout jVk;
    private TextView jVl;
    private RelativeLayout jVm;
    private Runnable jVx = new Runnable() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass12 */

        public final void run() {
            AppMethodBeat.i(68025);
            if (RemittanceBusiUI.this.state == 2 && RemittanceBusiUI.this.isHandleAutoShowNormalStWcKb()) {
                RemittanceBusiUI.this.showNormalStWcKb();
            }
            AppMethodBeat.o(68025);
        }
    };
    private int mChannel;
    private int mPayScene;
    private int mRequestCode = 0;
    private int state = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RemittanceBusiUI() {
        AppMethodBeat.i(68056);
        AppMethodBeat.o(68056);
    }

    static /* synthetic */ boolean L(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(213775);
        boolean eOa = remittanceBusiUI.eOa();
        AppMethodBeat.o(213775);
        return eOa;
    }

    static /* synthetic */ void U(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(213783);
        remittanceBusiUI.eOc();
        AppMethodBeat.o(213783);
    }

    static /* synthetic */ void a(RemittanceBusiUI remittanceBusiUI, int i2, String str) {
        AppMethodBeat.i(213781);
        remittanceBusiUI.bX(i2, str);
        AppMethodBeat.o(213781);
    }

    static /* synthetic */ void a(RemittanceBusiUI remittanceBusiUI, com.tencent.mm.plugin.remittance.model.c cVar, int i2) {
        AppMethodBeat.i(213769);
        remittanceBusiUI.a(cVar, (com.tencent.mm.plugin.remittance.model.d) null, i2);
        AppMethodBeat.o(213769);
    }

    static /* synthetic */ void a(RemittanceBusiUI remittanceBusiUI, i iVar) {
        AppMethodBeat.i(213777);
        remittanceBusiUI.d(iVar);
        AppMethodBeat.o(213777);
    }

    static /* synthetic */ void a(RemittanceBusiUI remittanceBusiUI, List list) {
        AppMethodBeat.i(213774);
        remittanceBusiUI.gu(list);
        AppMethodBeat.o(213774);
    }

    static /* synthetic */ void b(RemittanceBusiUI remittanceBusiUI, String str) {
        AppMethodBeat.i(213779);
        remittanceBusiUI.C(true, str);
        AppMethodBeat.o(213779);
    }

    static /* synthetic */ boolean b(RemittanceBusiUI remittanceBusiUI, i iVar) {
        AppMethodBeat.i(213782);
        boolean a2 = remittanceBusiUI.a(iVar);
        AppMethodBeat.o(213782);
        return a2;
    }

    static /* synthetic */ boolean h(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(213767);
        boolean needConfirmFinish = remittanceBusiUI.needConfirmFinish();
        AppMethodBeat.o(213767);
        return needConfirmFinish;
    }

    static /* synthetic */ void i(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(213768);
        remittanceBusiUI.dmp();
        AppMethodBeat.o(213768);
    }

    static /* synthetic */ void l(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(213770);
        remittanceBusiUI.eNP();
        AppMethodBeat.o(213770);
    }

    static /* synthetic */ double q(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(213771);
        double eNZ = remittanceBusiUI.eNZ();
        AppMethodBeat.o(213771);
        return eNZ;
    }

    private double eNZ() {
        AppMethodBeat.i(68057);
        if (this.Ctu || this.mPayScene == 33) {
            double d2 = this.Ctl;
            AppMethodBeat.o(68057);
            return d2;
        }
        this.Ctl = Util.getDouble(this.jVj.getText(), 0.0d);
        double d3 = this.Ctl;
        AppMethodBeat.o(68057);
        return d3;
    }

    /* access modifiers changed from: package-private */
    public class b {
        private float Cut;
        private float Cuu;
        private TenpaySecureEditText Cuv;
        private TextView Cuw;
        private RelativeLayout Cux;
        private float marginTop;
        private View sc;

        b(int i2, int i3, float f2) {
            AppMethodBeat.i(68053);
            this.Cut = (float) i2;
            this.Cuu = (float) i3;
            this.marginTop = f2;
            AppMethodBeat.o(68053);
        }

        /* access modifiers changed from: package-private */
        public final void update() {
            AppMethodBeat.i(68054);
            RemittanceBusiUI.this.CsX.setTextSize(1, this.Cuu);
            RemittanceBusiUI.this.Ctf.setTextSize(1, this.Cut);
            if (this.Cuw == null) {
                this.Cuw = (TextView) RemittanceBusiUI.this.jVj.findViewById(R.id.jia);
            }
            if (this.Cuw != null) {
                this.Cuw.setTextSize(this.Cut);
            }
            if (this.Cuv == null) {
                this.Cuv = (TenpaySecureEditText) RemittanceBusiUI.this.jVj.findViewById(R.id.jf4);
            }
            if (this.Cuv != null) {
                this.Cuv.setTextSize(this.Cuu);
            }
            if (this.sc == null) {
                this.sc = this.Cuv.findViewById(R.id.fje);
            }
            if (this.sc != null) {
                this.sc.setMinimumHeight(BackwardSupportUtil.BitmapFactory.fromDPToPix(RemittanceBusiUI.this, RemittanceBusiUI.this.CtN.Cuu));
            }
            if (this.Cux == null) {
                this.Cux = (RelativeLayout) RemittanceBusiUI.this.findViewById(R.id.jg2);
            }
            if (this.Cux != null) {
                ((LinearLayout.LayoutParams) this.Cux.getLayoutParams()).topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(RemittanceBusiUI.this, this.marginTop);
            }
            AppMethodBeat.o(68054);
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean shouldEnsureSoterConnection() {
        return true;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        View findViewById;
        AppMethodBeat.i(68058);
        super.onCreate(bundle);
        if (getIntent().getIntExtra("pay_channel", 0) == 56) {
            overridePendingTransition(R.anim.eq, R.anim.en);
            this.app_id = getIntent().getStringExtra("app_id");
            h.INSTANCE.a(19821, 4, this.app_id, 0);
        }
        h.INSTANCE.a(15235, 1);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.a2r)));
        View customView = getSupportActionBar().getCustomView();
        if (!(customView == null || (findViewById = customView.findViewById(16908308)) == null || !(findViewById instanceof TextView))) {
            ((TextView) findViewById).setTextColor(getResources().getColor(R.color.a2x));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.color.a2r));
        }
        if (com.tencent.mm.compatible.util.d.oD(21) && !com.tencent.mm.compatible.util.d.oD(23)) {
            getWindow().setStatusBarColor(getContext().getResources().getColor(R.color.BW_93));
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass23 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68035);
                if (RemittanceBusiUI.h(RemittanceBusiUI.this)) {
                    RemittanceBusiUI.this.hideVKB();
                    RemittanceBusiUI.this.showDialog(1000);
                } else {
                    RemittanceBusiUI.this.finish();
                }
                AppMethodBeat.o(68035);
                return true;
            }
        }, R.raw.actionbar_icon_dark_back);
        addSceneEndListener(1633);
        addSceneEndListener(1241);
        addSceneEndListener(2677);
        addSceneEndListener(2504);
        addSceneEndListener(2702);
        addSceneEndListener(2682);
        regeistQueryOrder(2682, this.CtZ);
        setMMTitle(R.string.g1y);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68014);
                RemittanceBusiUI.e(RemittanceBusiUI.this);
                if (RemittanceBusiUI.this.getIntent().getIntExtra("pay_channel", 0) == 56) {
                    h.INSTANCE.a(19821, 5, RemittanceBusiUI.this.app_id, 0);
                    RemittanceBusiUI.eOe();
                }
                RemittanceBusiUI.this.finish();
                AppMethodBeat.o(68014);
                return false;
            }
        });
        this.dRM = UUID.randomUUID().toString();
        com.tencent.mm.plugin.wallet.pay.a.b.aUU(this.dRM);
        this.mPayScene = getIntent().getIntExtra("pay_scene", 31);
        this.Ctk = getIntent().getStringExtra("scan_remittance_id");
        this.Ctl = getIntent().getDoubleExtra("fee", 0.0d);
        this.Ctm = getIntent().getStringExtra("receiver_name");
        this.Ctn = getIntent().getStringExtra("receiver_true_name");
        this.Cto = getIntent().getStringExtra("receiver_true_name_busi");
        this.mChannel = getIntent().getIntExtra("pay_channel", 0);
        this.Ctp = getIntent().getStringExtra("desc");
        this.Ctr = getIntent().getIntExtra("busi_type", 0);
        this.CqN = getIntent().getStringExtra("mch_name");
        this.Ctv = getIntent().getStringExtra("mch_type");
        this.Ctx = getIntent().getIntExtra("mch_time", 0);
        this.Cts = getIntent().getStringExtra("mch_info");
        this.Ctw = getIntent().getIntExtra("get_pay_wifi", 0);
        this.Crs = getIntent().getStringExtra("rcvr_open_id");
        this.Ctq = getIntent().getStringExtra("rcvr_ticket");
        this.Cnv = getIntent().getIntExtra("amount_remind_bit", 4);
        this.CtG = getIntent().getStringExtra("receiver_tips");
        this.Csz = (BusiRemittanceResp) getIntent().getParcelableExtra("BusiRemittanceResp");
        if (this.Csz != null) {
            this.CtK = this.mPayScene == 32 && (this.Csz.Con == 1 || (this.Csz != null && this.Csz.Col.size() > 0));
            if (this.Ctl > 0.0d) {
                this.Ctu = true;
            } else {
                this.Ctu = false;
            }
            if (this.Ctr == 0) {
                Log.w("MicroMsg.RemittanceBusiUI", "wrong busi type!");
                finish();
            }
            h.INSTANCE.a(15386, 1, 2);
            this.CtN = new b(32, 32, 6.0f);
            this.CtO = new b(56, 56, 8.0f);
            initView();
            dmp();
            this.Cqt.alive();
            this.Cui.alive();
            if (!this.Ctu) {
                this.state = 1;
            }
            AppMethodBeat.o(68058);
            return;
        }
        Log.w("MicroMsg.RemittanceBusiUI", "busi resp is null, maybe recreate activity!!");
        finish();
        AppMethodBeat.o(68058);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(68059);
        super.onResume();
        Log.i("MicroMsg.RemittanceBusiUI", "onResume()");
        e.eNU().gS(this);
        if (this.state == 3 && isHandleAutoShowNormalStWcKb()) {
            showNormalStWcKb();
        }
        if (!this.Ctu) {
            this.state = 2;
        }
        AppMethodBeat.o(68059);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(68060);
        super.onPause();
        Log.i("MicroMsg.RemittanceBusiUI", "onPause()");
        if (!this.Ctu && !this.jVg.hgQ()) {
            this.state = 3;
        }
        AppMethodBeat.o(68060);
    }

    @Override // com.tencent.mm.ui.widget.a.c, com.tencent.mm.ui.MMActivity
    public void onDialogDismiss(Dialog dialog) {
        AppMethodBeat.i(68061);
        Log.i("MicroMsg.RemittanceBusiUI", "onDialogDismiss()");
        MMHandlerThread.postToMainThreadDelayed(this.jVx, 300);
        AppMethodBeat.o(68061);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isHandleAutoShowNormalStWcKb() {
        AppMethodBeat.i(68062);
        if (this.mKindaEnable) {
            if (this.CtP || this.Ctu || !this.jVg.hgR()) {
                AppMethodBeat.o(68062);
                return false;
            }
            AppMethodBeat.o(68062);
            return true;
        } else if (this.Ctu || !this.jVg.hgR()) {
            AppMethodBeat.o(68062);
            return false;
        } else {
            AppMethodBeat.o(68062);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        AppMethodBeat.i(68063);
        hideActionbarLine();
        this.jVf = (ScrollView) findViewById(R.id.h9a);
        this.CsU = (TextView) findViewById(R.id.h0y);
        this.CsV = (TextView) findViewById(R.id.h0z);
        this.CsW = (TextView) findViewById(R.id.h0v);
        this.CsX = (TextView) findViewById(R.id.h0s);
        this.CsY = (TextView) findViewById(R.id.h0m);
        this.CsZ = (TextView) findViewById(R.id.h0k);
        this.Ctc = (CdnImageView) findViewById(R.id.h0w);
        this.jVj = (WalletFormView) findViewById(R.id.h0x);
        this.Ctd = (LinearLayout) findViewById(R.id.h0t);
        this.Crd = (LinearLayout) findViewById(R.id.h0o);
        this.Ctj = (RelativeLayout) findViewById(R.id.jg2);
        this.Cte = (LinearLayout) findViewById(R.id.h0n);
        this.Cta = (TextView) findViewById(R.id.ce4);
        this.Ctb = findViewById(R.id.h0p);
        this.Ctf = (TextView) findViewById(R.id.h0r);
        this.Ctg = findViewById(R.id.cj2);
        this.Cth = (TextView) findViewById(R.id.cj1);
        this.Cti = (Button) findViewById(R.id.h0u);
        this.jVg = (WcPayKeyboard) findViewById(R.id.joy);
        if (this.Ctu) {
            if (!Util.isNullOrNil(this.Ctp)) {
                this.CsW.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, this.Ctp, this.CsW.getTextSize()));
            }
            this.CsX.setText(f.formatMoney2f(this.Ctl));
            this.Ctd.setVisibility(0);
            this.Crd.setVisibility(8);
            this.Ctj.setVisibility(8);
            this.Cti.setVisibility(0);
        } else {
            if (this.Csz != null) {
                if (this.Csz.Col.size() > 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (this.Csz.Com != null && this.Csz.Com.KXX.size() > 0) {
                    z = false;
                }
            } else {
                z = true;
            }
            this.Cti.setVisibility(8);
            setWPKeyboard(this.jVj.getContentEt(), z, true);
            this.jVj.setmContentAbnormalMoneyCheck(true);
            if (com.tencent.mm.compatible.util.d.oD(28)) {
                this.jVj.getContentEt().post(new Runnable() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass34 */

                    public final void run() {
                        AppMethodBeat.i(68042);
                        RemittanceBusiUI.this.jVj.getContentEt().requestFocus();
                        AppMethodBeat.o(68042);
                    }
                });
            }
            this.jVg.setActionText(getString(R.string.g1y));
            setWcKbHeightListener(this);
            ((RelativeLayout.LayoutParams) this.jVg.getLayoutParams()).addRule(12);
            this.jVj.a(new TextWatcher() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass36 */

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(68043);
                    RemittanceBusiUI.i(RemittanceBusiUI.this);
                    if (RemittanceBusiUI.this.mPayScene == 32) {
                        RemittanceBusiUI.a(RemittanceBusiUI.this, (com.tencent.mm.plugin.remittance.model.c) null, RemittanceBusiUI.this.Csz == null ? 400 : RemittanceBusiUI.this.Csz.Cor);
                    }
                    AppMethodBeat.o(68043);
                }
            });
            this.jVj.hib();
            this.Ctd.setVisibility(8);
            this.Crd.setVisibility(0);
            this.Ctj.setVisibility(0);
        }
        if (com.tencent.mm.kernel.g.aAc()) {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.storage.as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.Ctm);
            if (Kn == null || ((int) Kn.gMZ) == 0) {
                ay.a.iDq.a(this.Ctm, "", new ay.b.a() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass37 */

                    @Override // com.tencent.mm.model.ay.b.a
                    public final void p(String str, boolean z) {
                        AppMethodBeat.i(68044);
                        Log.i("MicroMsg.RemittanceBusiUI", "getContact %s", Boolean.valueOf(z));
                        RemittanceBusiUI.l(RemittanceBusiUI.this);
                        AppMethodBeat.o(68044);
                    }
                });
            }
        }
        eNP();
        this.Cte.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass38 */

            public final void onClick(View view) {
                AppMethodBeat.i(68048);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!RemittanceBusiUI.this.Ctu) {
                    RemittanceBusiUI.this.showCircleStWcKb();
                }
                h.INSTANCE.a(15235, 6);
                if (RemittanceBusiUI.this.mChannel == 56) {
                    h.INSTANCE.a(19821, 6, RemittanceBusiUI.this.app_id, 0);
                }
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBusiUI.this, RemittanceBusiUI.this.getString(R.string.g1l), RemittanceBusiUI.this.Csr, RemittanceBusiUI.this.getString(R.string.g1o), true, 20, new h.b() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass38.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.b
                    public final boolean onFinish(CharSequence charSequence) {
                        AppMethodBeat.i(68045);
                        RemittanceBusiUI.this.Csr = charSequence.toString();
                        RemittanceBusiUI.p(RemittanceBusiUI.this);
                        AppMethodBeat.o(68045);
                        return true;
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass38.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(68047);
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass38.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(68046);
                                RemittanceBusiUI.this.hideVKB();
                                AppMethodBeat.o(68046);
                            }
                        }, 500);
                        AppMethodBeat.o(68047);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68048);
            }
        });
        final AnonymousClass39 r3 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass39 */

            public final void onClick(View view) {
                String sb;
                AppMethodBeat.i(68051);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(15235, 5);
                if (RemittanceBusiUI.this.mChannel == 56) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(19821, 8, RemittanceBusiUI.this.app_id, 0);
                }
                if (!RemittanceBusiUI.this.Ctu) {
                    RemittanceBusiUI.this.Ctl = RemittanceBusiUI.q(RemittanceBusiUI.this);
                }
                if (RemittanceBusiUI.this.Ctl <= 0.0d) {
                    u.makeText(RemittanceBusiUI.this.getContext(), (int) R.string.i7f, 0).show();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(68051);
                    return;
                }
                Object[] objArr = new Object[3];
                objArr[0] = RemittanceBusiUI.this.CtM;
                if (RemittanceBusiUI.this.CtM == null) {
                    sb = "";
                } else {
                    sb = new StringBuilder().append(RemittanceBusiUI.this.CtM.Coy).toString();
                }
                objArr[1] = sb;
                objArr[2] = Boolean.valueOf(RemittanceBusiUI.this.CtK);
                Log.i("MicroMsg.RemittanceBusiUI", "mPayBtn onClick %s  isFinish:%s getFavorFlag: %s", objArr);
                if (RemittanceBusiUI.this.mPayScene == 32) {
                    if (!RemittanceBusiUI.this.CtK) {
                        RemittanceBusiUI.s(RemittanceBusiUI.this);
                    } else if (RemittanceBusiUI.this.CtM == null || RemittanceBusiUI.this.CtM.Cnj != ((int) (RemittanceBusiUI.this.Ctl * 100.0d))) {
                        RemittanceBusiUI.a(RemittanceBusiUI.this, new com.tencent.mm.plugin.remittance.model.c() {
                            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass39.AnonymousClass2 */

                            @Override // com.tencent.mm.plugin.remittance.model.c
                            public final void gt(List<ans> list) {
                                AppMethodBeat.i(68050);
                                RemittanceBusiUI.s(RemittanceBusiUI.this);
                                AppMethodBeat.o(68050);
                            }
                        }, 0);
                    } else if (RemittanceBusiUI.this.CtM == null || !RemittanceBusiUI.this.CtM.Coy) {
                        if (RemittanceBusiUI.this.CtM != null) {
                            RemittanceBusiUI.this.CtM.Cow = new com.tencent.mm.plugin.remittance.model.c() {
                                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass39.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.remittance.model.c
                                public final void gt(List<ans> list) {
                                    AppMethodBeat.i(68049);
                                    RemittanceBusiUI.s(RemittanceBusiUI.this);
                                    AppMethodBeat.o(68049);
                                }
                            };
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(68051);
                }
                RemittanceBusiUI.s(RemittanceBusiUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68051);
            }
        };
        this.jVj.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass40 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(68052);
                if (keyEvent != null && keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 66) {
                    Log.i("MicroMsg.RemittanceBusiUI", "click enter");
                    r3.onClick(null);
                    AppMethodBeat.o(68052);
                } else {
                    AppMethodBeat.o(68052);
                }
                return true;
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.jfy);
        if (ao.isDarkMode()) {
            findViewById(R.id.jg3).setVisibility(8);
            findViewById(R.id.jg0).setVisibility(0);
            imageView.setBackgroundResource(R.drawable.crl);
        } else {
            findViewById(R.id.jg3).setVisibility(0);
            findViewById(R.id.jg0).setVisibility(8);
            imageView.setBackgroundResource(R.drawable.crk);
        }
        this.Cti.setOnClickListener(r3);
        this.jVf.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(68015);
                if (RemittanceBusiUI.this.mWcKeyboard == null || !RemittanceBusiUI.this.mWcKeyboard.isShown() || !RemittanceBusiUI.this.mWcKeyboard.hgP()) {
                    AppMethodBeat.o(68015);
                    return false;
                }
                RemittanceBusiUI.this.mWcKeyboard.hgN();
                AppMethodBeat.o(68015);
                return true;
            }
        });
        setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass3 */

            @Override // com.tencent.mm.wallet_core.ui.a
            public final void onVisibleStateChange(boolean z) {
                AppMethodBeat.i(68016);
                RemittanceBusiUI.this.CtL = z;
                if (!z) {
                    RemittanceBusiUI.this.jVf.scrollTo(0, 0);
                    if (RemittanceBusiUI.this.jVj != null && RemittanceBusiUI.this.jVj.getVisibility() == 0) {
                        RemittanceBusiUI.this.jVj.setFocusable(false);
                        RemittanceBusiUI.this.jVj.setFocusable(true);
                    }
                }
                AppMethodBeat.o(68016);
            }
        });
        this.jVm = (RelativeLayout) findViewById(R.id.jfz);
        if (LocaleUtil.getApplicationLanguage().equals(LocaleUtil.CHINA) || LocaleUtil.getApplicationLanguage().equals(LocaleUtil.TAIWAN) || LocaleUtil.getApplicationLanguage().equals(LocaleUtil.HONGKONG)) {
            this.jVk = (RelativeLayout) findViewById(R.id.jg1);
            this.jVl = (TextView) findViewById(R.id.jg4);
            this.jVk.post(new Runnable() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(68017);
                    RemittanceBusiUI.this.jVe = RemittanceBusiUI.this.jVk.getWidth();
                    RemittanceBusiUI.this.jVm.setVisibility(8);
                    Log.d("MicroMsg.RemittanceBusiUI", "post: mMaxUnitWidth:%s", Integer.valueOf(RemittanceBusiUI.this.jVe));
                    AppMethodBeat.o(68017);
                }
            });
            this.jVj.setmWalletFormViewListener(new WalletFormView.c() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass5 */

                @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.c
                public final void p(CharSequence charSequence) {
                    AppMethodBeat.i(68018);
                    if (Util.isEqual(RemittanceBusiUI.this.Cnv, 0)) {
                        Log.i("MicroMsg.RemittanceBusiUI", "mAmountRemindBit == 0");
                        RemittanceBusiUI.this.jVm.setVisibility(8);
                        AppMethodBeat.o(68018);
                        return;
                    }
                    long longValue = Double.valueOf(Util.getDouble(charSequence.toString(), 0.0d)).longValue();
                    int i2 = 0;
                    int i3 = 0;
                    while (longValue != 0) {
                        i2 = (int) (longValue % 10);
                        longValue /= 10;
                        i3++;
                    }
                    if (i3 >= RemittanceBusiUI.this.Cnv) {
                        int k = RemittanceBusiUI.this.jVj.k(charSequence, RemittanceBusiUI.this.jVe, i2);
                        if (k != 0) {
                            RemittanceBusiUI.this.jVm.setVisibility(0);
                            RemittanceBusiUI.this.jVl.setText(ag.aR(MMApplicationContext.getContext(), i3));
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) RemittanceBusiUI.this.jVk.getLayoutParams();
                            layoutParams.leftMargin = k;
                            RemittanceBusiUI.this.jVk.setLayoutParams(layoutParams);
                            AppMethodBeat.o(68018);
                            return;
                        }
                        RemittanceBusiUI.this.jVm.setVisibility(8);
                        AppMethodBeat.o(68018);
                        return;
                    }
                    RemittanceBusiUI.this.jVm.setVisibility(8);
                    AppMethodBeat.o(68018);
                }
            });
        } else {
            this.jVm.setVisibility(8);
        }
        if (!(this.Csz == null || this.Csz.Com == null)) {
            this.CtH.Cqy = this.Csz.Com;
            this.CtH.aMi(this.Csz.Com.KXZ);
        }
        if (eOa()) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(15235, 2);
        }
        AppMethodBeat.o(68063);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(68064);
        if (this.jVg == null || !this.jVg.onKeyUp(i2, keyEvent)) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(68064);
            return onKeyUp;
        }
        AppMethodBeat.o(68064);
        return true;
    }

    @Override // com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a
    public final void bO(float f2) {
        AppMethodBeat.i(68065);
        if (this.jVf != null) {
            this.Ctt = f2;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jVf.getLayoutParams();
            layoutParams.bottomMargin = (int) f2;
            Log.d("MicroMsg.RemittanceBusiUI", "onUpdateWcPayKeyboardHeight() height: %s rootView.height: %s", Float.valueOf(f2), Integer.valueOf(layoutParams.height));
            this.jVf.setLayoutParams(layoutParams);
            p.a(this, this.jVf, findViewById(R.id.h2a), findViewById(R.id.h2a), findViewById(R.id.h2_), f2);
        }
        AppMethodBeat.o(68065);
    }

    private void eNP() {
        AppMethodBeat.i(68066);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass6 */

            public final void run() {
                String hs;
                AppMethodBeat.i(68019);
                RemittanceBusiUI.this.CsU.setText(RemittanceBusiUI.this.CtG);
                if (RemittanceBusiUI.this.Csz == null || Util.isNullOrNil(RemittanceBusiUI.this.Csz.Cop)) {
                    hs = f.hs(f.getDisplayName(RemittanceBusiUI.this.Ctm), 10);
                    if (!Util.isNullOrNil(RemittanceBusiUI.this.Ctn)) {
                        hs = RemittanceBusiUI.this.getString(R.string.g22, new Object[]{hs, RemittanceBusiUI.this.Ctn});
                    }
                } else {
                    hs = RemittanceBusiUI.this.Csz.Cop;
                }
                RemittanceBusiUI.this.CsV.setText(com.tencent.mm.pluginsdk.ui.span.l.b(RemittanceBusiUI.this, hs, RemittanceBusiUI.this.CsV.getTextSize()));
                if (RemittanceBusiUI.this.Csz != null) {
                    if (RemittanceBusiUI.this.Csz.Cof != 1) {
                        RemittanceBusiUI.this.Ctc.setVisibility(8);
                        AppMethodBeat.o(68019);
                        return;
                    } else if (!Util.isNullOrNil(RemittanceBusiUI.this.Csz.Cog)) {
                        if (RemittanceBusiUI.this.Csz.Coo == 1) {
                            RemittanceBusiUI.this.Ctc.setRoundCorner(true);
                        } else {
                            RemittanceBusiUI.this.Ctc.setRoundCorner(false);
                        }
                        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(RemittanceBusiUI.this, 36.0f);
                        RemittanceBusiUI.this.Ctc.s(RemittanceBusiUI.this.Csz.Cog, fromDPToPix, fromDPToPix, -1);
                        AppMethodBeat.o(68019);
                        return;
                    } else if (!Util.isNullOrNil(RemittanceBusiUI.this.Ctm)) {
                        if (RemittanceBusiUI.this.Csz.Coo == 1) {
                            a.b.d(RemittanceBusiUI.this.Ctc, RemittanceBusiUI.this.Ctm);
                            AppMethodBeat.o(68019);
                            return;
                        }
                        a.b.c(RemittanceBusiUI.this.Ctc, RemittanceBusiUI.this.Ctm);
                        AppMethodBeat.o(68019);
                        return;
                    }
                }
                RemittanceBusiUI.this.Ctc.setVisibility(8);
                AppMethodBeat.o(68019);
            }
        });
        AppMethodBeat.o(68066);
    }

    private boolean eOa() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(68067);
        if (this.Ctb == null) {
            z = false;
        } else if (this.Csz != null) {
            Log.i("MicroMsg.RemittanceBusiUI", "tryShowFavor ");
            if (this.Csz.Com == null || this.Csz.Com.KXY.size() <= 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (this.Csz.Col.size() > 0) {
                z2 = true;
            }
            if (this.CtH.eND().size() > 0) {
                z2 = true;
            }
            if (!z2) {
                this.Ctb.setVisibility(8);
                this.CtO.update();
                this.Ctg.setVisibility(8);
                z = false;
            } else {
                this.Ctg.setVisibility(0);
                this.CtN.update();
                this.Ctb.setVisibility(0);
                this.Cta.setText(this.Csz.Coh);
                this.Cta.setTextColor(getContext().getResources().getColor(R.color.l4));
                this.Cth.setText(f.formatMoney2f(eNZ()));
                anr anr = this.CtH.Cqx;
                if (anr != null) {
                    this.Cta.setTextColor(getContext().getResources().getColor(R.color.Orange));
                    this.Cta.setText(anr.Coh);
                    this.Cth.setText(f.formatMoney2f(((double) anr.LyL) / 100.0d));
                } else {
                    String eNE = this.CtH.eNE();
                    if (!Util.isNullOrNil(eNE)) {
                        this.Cta.setTextColor(getContext().getResources().getColor(R.color.l4));
                        this.Cta.setText(eNE);
                    }
                }
                findViewById(R.id.ce0).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass7 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(68020);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15235, 3);
                        if (RemittanceBusiUI.this.mChannel == 56) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(19821, 7, RemittanceBusiUI.this.app_id, 0);
                        }
                        RemittanceBusiUI.J(RemittanceBusiUI.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(68020);
                    }
                });
                z = true;
            }
        } else {
            z = false;
        }
        p.a(this, this.jVf, findViewById(R.id.h2a), findViewById(R.id.h2a), findViewById(R.id.h2_), this.Ctt);
        AppMethodBeat.o(68067);
        return z;
    }

    private void gu(final List<ans> list) {
        AppMethodBeat.i(68068);
        final e eVar = new e(this);
        ArrayList<Integer> arrayList = new ArrayList<>();
        anr anr = this.CtH.Cqx;
        HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        if (this.CtH.eNG() && anr != null) {
            Iterator<ans> it = anr.KXX.iterator();
            while (it.hasNext()) {
                hashSet.add(Long.valueOf(it.next().LyS));
            }
        }
        int i2 = 0;
        for (ans ans : list) {
            if (hashSet.contains(Long.valueOf(ans.LyS))) {
                arrayList.add(Integer.valueOf(i2));
            }
            i2++;
        }
        String string = getString(R.string.g3c);
        if (string != null && string.length() > 0) {
            eVar.QTp.setVisibility(0);
            eVar.FdD.setText(string);
        }
        eVar.QTq = arrayList;
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass11 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(68024);
                RemittanceBusiUI.this.Ctl = RemittanceBusiUI.q(RemittanceBusiUI.this);
                if (!RemittanceBusiUI.this.CtH.eNG() || RemittanceBusiUI.this.Ctl <= 0.0d) {
                    int i2 = 0;
                    for (ans ans : list) {
                        mVar.a(i2, (CharSequence) ans.LyT, (CharSequence) ans.LyV, (Drawable) null, true);
                        hashSet2.add(Integer.valueOf(i2));
                        i2++;
                    }
                    AppMethodBeat.o(68024);
                    return;
                }
                int i3 = 0;
                for (ans ans2 : list) {
                    if (ans2.Lzb == 1) {
                        mVar.a(i3, (CharSequence) ans2.LyT, (CharSequence) ans2.LyV, (Drawable) null, true);
                        hashSet2.add(Integer.valueOf(i3));
                    } else {
                        mVar.a(i3, ans2.LyT, ans2.LyV, 0);
                    }
                    i3++;
                }
                AppMethodBeat.o(68024);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass13 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                ArrayList<Integer> arrayList;
                boolean z = true;
                int i3 = 0;
                AppMethodBeat.i(68026);
                if (hashSet2.contains(Integer.valueOf(i2))) {
                    AppMethodBeat.o(68026);
                    return;
                }
                if (i2 < list.size()) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(15235, 4);
                    ans ans = (ans) list.get(i2);
                    e eVar = eVar;
                    if (eVar.QTr != null) {
                        arrayList = eVar.QTr.hcl();
                    } else {
                        arrayList = new ArrayList<>();
                    }
                    boolean contains = arrayList.contains(Integer.valueOf(i2));
                    if (contains) {
                        z = false;
                    }
                    LinkedList linkedList = new LinkedList();
                    for (Integer num : arrayList) {
                        int intValue = num.intValue();
                        if (intValue < list.size() && (z || i2 != intValue)) {
                            linkedList.add((ans) list.get(intValue));
                        }
                    }
                    if (z) {
                        linkedList.add(ans);
                    }
                    b bVar = RemittanceBusiUI.this.CtH;
                    if (!z) {
                        ans = null;
                    }
                    bVar.a(linkedList, ans);
                    anr anr = RemittanceBusiUI.this.CtH.Cqx;
                    HashSet hashSet = new HashSet();
                    if (anr != null) {
                        Iterator<ans> it = anr.KXX.iterator();
                        while (it.hasNext()) {
                            hashSet.add(Long.valueOf(it.next().LyS));
                        }
                    }
                    HashMap<Integer, Boolean> hashMap = new HashMap<>();
                    for (ans ans2 : list) {
                        if (hashSet.contains(Long.valueOf(ans2.LyS))) {
                            hashMap.put(Integer.valueOf(i3), Boolean.TRUE);
                        } else {
                            hashMap.put(Integer.valueOf(i3), Boolean.FALSE);
                        }
                        if (i3 == i2) {
                            hashMap.put(Integer.valueOf(i3), Boolean.valueOf(contains));
                        }
                        i3++;
                    }
                    e eVar2 = eVar;
                    if (eVar2.QTr != null) {
                        eVar2.QTr.QTu = hashMap;
                        eVar2.QTr.notifyDataSetChanged();
                    }
                }
                AppMethodBeat.o(68026);
            }
        };
        eVar.QTs = new e.b() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass14 */

            @Override // com.tencent.mm.ui.widget.picker.e.b
            public final void tK(boolean z) {
                AppMethodBeat.i(68027);
                if (z) {
                    anr anr = RemittanceBusiUI.this.CtH.Cqx;
                    Object[] objArr = new Object[1];
                    objArr[0] = anr == null ? "" : com.tencent.mm.plugin.remittance.model.a.a(anr);
                    Log.i("MicroMsg.RemittanceBusiUI", "onFavorSelected %s ", objArr);
                    RemittanceBusiUI.L(RemittanceBusiUI.this);
                }
                AppMethodBeat.o(68027);
            }
        };
        if (eVar.HLX != null) {
            eVar.HLX.onCreateMMMenu(eVar.HMc);
        }
        eVar.QTr = new e.a(eVar.mContext);
        eVar.QTr.hck();
        eVar.QTo.setAdapter((ListAdapter) eVar.QTr);
        eVar.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.picker.e.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(159562);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MultiPicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e eVar = e.this;
                e.this.QTr.hcl();
                e.a(eVar, true);
                e.this.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MultiPicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159562);
            }
        });
        eVar.hSq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.picker.e.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(159563);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MultiPicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e.a(e.this, false);
                e.this.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MultiPicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159563);
            }
        });
        if (eVar.yfL != null) {
            if (eVar.HMc != null && eVar.HMc.size() > 3) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) eVar.lJI.getLayoutParams();
                layoutParams.height = eVar.mLJ;
                eVar.lJI.setLayoutParams(layoutParams);
            }
            eVar.yfL.show();
        }
        AppMethodBeat.o(68068);
    }

    private void a(com.tencent.mm.plugin.remittance.model.c cVar, com.tencent.mm.plugin.remittance.model.d dVar, int i2) {
        AppMethodBeat.i(68069);
        if (this.CtK) {
            this.Cth.setText(f.formatMoney2f(eNZ()));
            MMHandlerThread.removeRunnable(this.CtY);
            this.Ctl = eNZ();
            long round = Math.round(this.Ctl * 100.0d);
            if (round <= 0) {
                this.CtH.eNC();
                this.Cta.setTextColor(getContext().getResources().getColor(R.color.l4));
                this.Cta.setText(this.Csz.Coh);
                if (this.CtM != null) {
                    this.CtM.cancel = true;
                }
                AppMethodBeat.o(68069);
                return;
            }
            this.CtM = new g((int) round, this.mChannel, this.Csz.Coi, this.Ctp, this.CqN, this.Csz.Coj, this.Crs, this.Ctm, this.Csz.Cok, cVar == null ? 0 : 1, cVar, dVar);
            MMHandlerThread.postToMainThreadDelayed(this.CtY, (long) i2);
        }
        AppMethodBeat.o(68069);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(68070);
        super.onDestroy();
        EventCenter.instance.removeListener(this.CrH);
        EventCenter.instance.removeListener(this.Cuh);
        EventCenter.instance.removeListener(this.Cuf);
        this.Cug.dead();
        removeSceneEndListener(1633);
        removeSceneEndListener(1241);
        removeSceneEndListener(2677);
        removeSceneEndListener(2504);
        removeSceneEndListener(2702);
        removeSceneEndListener(2682);
        this.Cqt.dead();
        this.Cui.dead();
        com.tencent.mm.plugin.wallet.pay.a.b.aUV(this.dRM);
        MMHandlerThread.removeRunnable(this.jVx);
        AppMethodBeat.o(68070);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x01d3  */
    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onSceneEnd(int r21, int r22, java.lang.String r23, final com.tencent.mm.ak.q r24) {
        /*
        // Method dump skipped, instructions count: 1703
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):boolean");
    }

    private void eOb() {
        AppMethodBeat.i(163833);
        hideLoading();
        if (this.CtR != null) {
            this.CtR.hideProgress();
        }
        AppMethodBeat.o(163833);
    }

    /* access modifiers changed from: package-private */
    public class c implements Runnable {
        public d Cuy;

        c() {
        }

        public final void run() {
            AppMethodBeat.i(68055);
            RemittanceBusiUI.this.CtZ.b(this.Cuy);
            AppMethodBeat.o(68055);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z = true;
        AppMethodBeat.i(68072);
        Log.i("MicroMsg.RemittanceBusiUI", "onActivityResult requestCode %s resultCode %s %s", Integer.valueOf(i2), Integer.valueOf(i3), intent);
        if (i2 == 3) {
            if (this.CtR != null) {
                this.CtR.hideProgress();
                this.CtR = null;
            }
            if (i3 != -1) {
                z = false;
            }
            a(z, intent);
        } else if (i2 == 1) {
            if (i3 != -1) {
                z = false;
            }
            a(z, intent);
        } else if (i2 == 2) {
            if (i3 == -1) {
                String stringExtra = intent.getStringExtra("INTENT_RESULT_TOKEN");
                this.CtA = stringExtra;
                this.dDO = 0.0d;
                Log.i("MicroMsg.RemittanceBusiUI", "onActivityResult _result_token: %s", stringExtra);
                C(false, intent.getStringExtra("INTENT_REQKEY"));
            } else {
                eOc();
            }
        } else if (i2 == 4) {
            this.CtU = true;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(68072);
    }

    private void a(boolean z, Intent intent) {
        AppMethodBeat.i(68073);
        if (z) {
            String stringExtra = intent.getStringExtra("key_trans_id");
            double doubleExtra = intent.getDoubleExtra("key_total_fee", -1.0d);
            String stringExtra2 = intent.getStringExtra("key_reqKey");
            Log.i("MicroMsg.RemittanceBusiUI", "onActivityResult _transId: %s _totalFee: %s", stringExtra, Double.valueOf(doubleExtra));
            if (Util.isNullOrNil(this.AJn)) {
                this.AJn = stringExtra;
            }
            if (doubleExtra >= 0.0d) {
                this.dDO = doubleExtra;
            }
            if (this.Crx) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(15386, 3, 2);
            }
            eOd();
            aMl(stringExtra2);
        } else if (ag.bH(intent)) {
            finish();
            AppMethodBeat.o(68073);
            return;
        } else if (ag.bI(intent)) {
            AppMethodBeat.o(68073);
            return;
        } else {
            Log.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor");
            eOc();
        }
        c(z, intent);
        AppMethodBeat.o(68073);
    }

    private void c(boolean z, Intent intent) {
        AppMethodBeat.i(68074);
        this.Cub = false;
        if (z) {
            Log.i("MicroMsg.RemittanceBusiUI", "savePayInfo isOk = true");
            this.dYe = 1;
        } else if (intent == null) {
            AppMethodBeat.o(68074);
            return;
        } else {
            this.dYe = intent.getIntExtra("key_pay_reslut_type", 3);
            this.Cuc = this.Ctl;
            this.Cud = this.Csr;
            this.Cue = this.Csq;
        }
        Log.i("MicroMsg.RemittanceBusiUI", "savePayInfo() mLastPayResult:%s mLastTotalAmt:%s mLastPayerDesc:%s mLastF2fId:%s", Double.valueOf(this.Cuc), Double.valueOf(this.Cuc), this.Cud, this.Cue);
        AppMethodBeat.o(68074);
    }

    private void C(boolean z, String str) {
        int i2;
        AppMethodBeat.i(68075);
        Log.i("MicroMsg.RemittanceBusiUI", "doBusiZeroCallback %s", Boolean.valueOf(z));
        du duVar = this.CtQ.get(str);
        if (duVar == null) {
            AppMethodBeat.o(68075);
            return;
        }
        eig eig = this.Ctz;
        String str2 = this.Cty;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        l lVar = new l(eig, duVar, str2, i2, this.CtA, str);
        if (z) {
            lVar.hasRetried = true;
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(lVar, 0);
            AppMethodBeat.o(68075);
            return;
        }
        this.CtE = 0;
        doSceneForceProgress(lVar);
        AppMethodBeat.o(68075);
    }

    private void eOc() {
        AppMethodBeat.i(68076);
        Log.i("MicroMsg.RemittanceBusiUI", "unLockFavorimp");
        anr anr = this.CtH.Cqx;
        if (anr == null) {
            Log.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor FavorComposeInfo is null");
            AppMethodBeat.o(68076);
            return;
        }
        int round = (int) Math.round(this.Ctl * 100.0d);
        du duVar = new du();
        duVar.channel = this.mChannel;
        duVar.KHM = this.Csq;
        duVar.KHN = this.AJn;
        duVar.Coi = this.Csz.Coi;
        duVar.scene = this.mPayScene;
        duVar.KHO = this.Csv;
        duVar.KHP = anr;
        duVar.jTz = this.Ctm;
        duVar.CpJ = this.Crs;
        duVar.KHQ = round;
        doSceneProgress(new k(duVar, this.CtI), false);
        AppMethodBeat.o(68076);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bmo;
    }

    private void a(int i2, rc rcVar, boolean z, gl glVar, String str, String str2) {
        AppMethodBeat.i(68077);
        a(i2, rcVar, z, glVar, str, str2, "");
        AppMethodBeat.o(68077);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r27, com.tencent.mm.protocal.protobuf.rc r28, boolean r29, com.tencent.mm.g.a.gl r30, java.lang.String r31, java.lang.String r32, java.lang.String r33) {
        /*
        // Method dump skipped, instructions count: 325
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.a(int, com.tencent.mm.protocal.protobuf.rc, boolean, com.tencent.mm.g.a.gl, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private void eOd() {
        AppMethodBeat.i(68078);
        Log.i("MicroMsg.RemittanceBusiUI", "goto busi result");
        Intent intent = new Intent(this, RemittanceBusiResultUI.class);
        intent.putExtra("key_pay_desc", this.Csr);
        intent.putExtra("key_rcv_desc", this.Ctp);
        if (this.Csz != null) {
            intent.putExtra("BusiRemittanceResp", this.Csz);
        }
        intent.putExtra("key_mch_name", this.CqN);
        intent.putExtra("key_rcver_name", this.Ctm);
        intent.putExtra("key_rcver_true_name", this.Ctn);
        if (this.dDO >= 0.0d) {
            intent.putExtra("key_money", this.dDO);
        } else {
            intent.putExtra("key_money", this.Ctl);
        }
        intent.putExtra("key_f2f_id", this.Csq);
        intent.putExtra("key_trans_id", this.AJn);
        intent.putExtra("key_check_sign", this.Csv);
        intent.putExtra("key_rcvr_open_id", this.Crs);
        intent.putExtra("key_channel", this.mChannel);
        intent.putExtra("key_succ_fault_config", this.CtF);
        if (this.Csz != null) {
            intent.putExtra("key_succ_show_avatar_type", this.Csz.Coo);
            intent.putExtra("key_succ_show_avatar_show", this.Csz.Cof);
            intent.putExtra("key_succ_show_avatar_url", this.Csz.Cog);
        }
        if (this.Csz != null) {
            intent.putExtra("key_scan_sceen", this.Csz.Coi);
        }
        intent.putExtra("key_succ_page_extend", this.CtJ);
        if (this.mChannel == 56) {
            intent.putExtra("app_id", this.app_id);
        }
        anr anr = this.CtH.Cqx;
        du duVar = new du();
        duVar.channel = this.mChannel;
        duVar.KHM = this.Csq;
        duVar.KHN = this.AJn;
        duVar.Coi = this.Csz.Coi;
        duVar.scene = this.mPayScene;
        duVar.KHO = this.Csv;
        duVar.KHP = anr;
        duVar.jTz = this.Ctm;
        duVar.CpJ = this.Crs;
        duVar.KHQ = (int) Math.round(this.Ctl * 100.0d);
        try {
            intent.putExtra("AfterPlaceOrderCommReq", duVar.toByteArray());
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.RemittanceBusiUI", e2, "", new Object[0]);
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "gotoBusiResultUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "gotoBusiResultUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        if (e.eNU().eNV()) {
            Log.w("MicroMsg.RemittanceBusiUI", "finish finishRemitF2fDCodeAndLMRemindUI");
        }
        AppMethodBeat.o(68078);
    }

    private boolean a(i iVar) {
        AppMethodBeat.i(68079);
        boolean z = false;
        if (!this.CrC) {
            z = b(iVar);
        }
        if (!z) {
            z = c(iVar);
        }
        AppMethodBeat.o(68079);
        return z;
    }

    private boolean b(final i iVar) {
        AppMethodBeat.i(68080);
        if (!Util.isNullOrNil(iVar.CoB.KYt)) {
            this.CrC = true;
            bX(1, iVar.CoB.KHM);
            e.eNU().a(iVar.CoB.KYt, getString(R.string.yd), getString(R.string.g1n), getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass24 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(68036);
                    RemittanceBusiUI.a(RemittanceBusiUI.this, 3, iVar.CoB.KHM);
                    if (!RemittanceBusiUI.b(RemittanceBusiUI.this, iVar)) {
                        if (RemittanceBusiUI.this.mKindaEnable) {
                            if (RemittanceBusiUI.this.CtR != null) {
                                RemittanceBusiUI.this.CtR.showSafeProgress();
                            } else {
                                RemittanceBusiUI.this.showLoading();
                            }
                        }
                        RemittanceBusiUI.a(RemittanceBusiUI.this, iVar);
                        AppMethodBeat.o(68036);
                        return;
                    }
                    RemittanceBusiUI.U(RemittanceBusiUI.this);
                    AppMethodBeat.o(68036);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass25 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(163824);
                    RemittanceBusiUI.U(RemittanceBusiUI.this);
                    RemittanceBusiUI.a(RemittanceBusiUI.this, 2, iVar.CoB.KHM);
                    AppMethodBeat.o(163824);
                }
            });
            AppMethodBeat.o(68080);
            return true;
        }
        AppMethodBeat.o(68080);
        return false;
    }

    private void bX(int i2, String str) {
        AppMethodBeat.i(68081);
        this.Crz = new kx();
        this.Crz.erW = 1;
        this.Crz.ejA = (long) i2;
        this.Crz.yp(str);
        this.Crz.bfK();
        AppMethodBeat.o(68081);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(68082);
        Log.v("MicroMsg.RemittanceBusiUI", "onNewIntent");
        AppMethodBeat.o(68082);
    }

    private boolean c(final i iVar) {
        AppMethodBeat.i(68083);
        if (iVar.CoB.KYu != null) {
            this.CrF = true;
            e.eNU().a(iVar.CoB.pUa, "", iVar.CoB.KYu.lHB, iVar.CoB.KYu.lHA, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass26 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(163825);
                    Log.i("MicroMsg.RemittanceBusiUI", "goto h5: %s", iVar.CoB.KYu.qwt);
                    f.p(RemittanceBusiUI.this.getContext(), iVar.CoB.KYu.qwt, false);
                    AppMethodBeat.o(163825);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass27 */

                {
                    AppMethodBeat.i(160843);
                    AppMethodBeat.o(160843);
                }

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(68083);
            return true;
        }
        AppMethodBeat.o(68083);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0320  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(com.tencent.mm.plugin.remittance.model.i r11) {
        /*
        // Method dump skipped, instructions count: 880
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.d(com.tencent.mm.plugin.remittance.model.i):void");
    }

    private void a(ri riVar) {
        String str;
        AppMethodBeat.i(68085);
        Log.i("MicroMsg.RemittanceBusiUI", "resp.payer_need_auth_flag %s", Integer.valueOf(riVar.KYz));
        if (riVar.KYz == 1) {
            Bundle bundle = new Bundle();
            EventCenter.instance.addListener(this.Cuh);
            bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceBusiUI");
            bundle.putString("realname_verify_process_jump_plugin", "remittance");
            bundle.putInt("real_name_verify_mode", 0);
            bundle.putInt("entry_scene", this.mPayScene);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
            AppMethodBeat.o(68085);
            return;
        }
        Intent intent = new Intent();
        if (!Util.isNullOrNil(this.CtG)) {
            str = this.CtG;
        } else {
            String string = getString(R.string.ip_);
            if (!Util.isNullOrNil(this.Ctm)) {
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.storage.as bjJ = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(this.Ctm);
                if (bjJ != null) {
                    Object[] objArr = new Object[1];
                    objArr[0] = f.bpz(bjJ.arJ()) + (Util.isNullOrNil(this.Ctn) ? "" : "(" + this.Ctn + ")");
                    str = Util.safeFormatString(string, objArr);
                } else {
                    Log.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.Ctm);
                    str = "";
                }
            } else {
                Log.e("MicroMsg.RemittanceBusiUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                str = "";
            }
        }
        intent.putExtra("INTENT_TITLE", str);
        intent.putExtra("INTENT_CAN_TOUCH", this.CtB);
        intent.putExtra("INTENT_PAYFEE", f.formatMoney2f(0.0d));
        intent.putExtra("INTENT_REQKEY", riVar.dNQ);
        try {
            intent.putExtra("INTENT_TOKENMESS", riVar.KYA.toByteArray());
            com.tencent.mm.br.c.b(getContext(), "wallet", "com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI", intent, 2);
            AppMethodBeat.o(68085);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.RemittanceBusiUI", e2, "", new Object[0]);
            AppMethodBeat.o(68085);
        }
    }

    private void aMl(String str) {
        AppMethodBeat.i(68086);
        Log.i("MicroMsg.RemittanceBusiUI", "do pay check: %s", str);
        du duVar = this.CtQ.get(str);
        if (duVar == null) {
            AppMethodBeat.o(68086);
            return;
        }
        if (!Util.isNullOrNil(this.AJn)) {
            duVar.KHN = this.AJn;
        }
        doSceneProgress(new com.tencent.mm.plugin.remittance.model.h(duVar, this.CtI), false);
        AppMethodBeat.o(68086);
    }

    private void dmp() {
        AppMethodBeat.i(68087);
        this.Ctl = eNZ();
        if (this.Ctl <= 0.0d) {
            findViewById(R.id.ce0).setClickable(false);
            findViewById(R.id.ce0).setEnabled(false);
            findViewById(R.id.ce0).setOnClickListener(null);
            gf(false);
            this.Cta.setTextColor(getResources().getColor(R.color.a2t));
            AppMethodBeat.o(68087);
            return;
        }
        this.Cta.setTextColor(getContext().getResources().getColor(R.color.l4));
        findViewById(R.id.ce0).setEnabled(true);
        findViewById(R.id.ce0).setClickable(true);
        gf(true);
        findViewById(R.id.ce0).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass33 */

            public final void onClick(View view) {
                AppMethodBeat.i(163832);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(15235, 3);
                if (RemittanceBusiUI.this.mChannel == 56) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(19821, 7, RemittanceBusiUI.this.app_id, 0);
                }
                RemittanceBusiUI.J(RemittanceBusiUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(163832);
            }
        });
        AppMethodBeat.o(68087);
    }

    private void gf(boolean z) {
        AppMethodBeat.i(68088);
        if (this.jVg != null) {
            this.jVg.DH(z);
        }
        AppMethodBeat.o(68088);
    }

    public final void a(int i2, i iVar) {
        AppMethodBeat.i(163835);
        au auVar = new au();
        auVar.enW = i2;
        if (iVar != null) {
            auVar.iA(iVar.CoB.KHM);
            auVar.iB(this.Ctk);
            auVar.equ = iVar.Bbl;
        }
        auVar.bfK();
        AppMethodBeat.o(163835);
    }

    public abstract class a<InputType> implements l.a<InputType> {
        public a() {
        }

        @Override // com.tencent.mm.wallet_core.c.l.a
        public final void eNw() {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.ui.LauncherUI"));
            intent.addFlags(67108864);
            RemittanceBusiUI remittanceBusiUI = RemittanceBusiUI.this;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(remittanceBusiUI, bl.axQ(), "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$IRemitBusiJumpItemCallback", "onExit", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            remittanceBusiUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(remittanceBusiUI, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI$IRemitBusiJumpItemCallback", "onExit", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }

        @Override // com.tencent.mm.wallet_core.c.l.a
        public final int eNq() {
            return 1072;
        }

        @Override // com.tencent.mm.wallet_core.c.l.a
        public void eNp() {
        }

        @Override // com.tencent.mm.wallet_core.c.l.a
        public void eNs() {
        }
    }

    static /* synthetic */ void e(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(68089);
        Log.i("MicroMsg.RemittanceBusiUI", "do cancel pay");
        remittanceBusiUI.doSceneProgress(new com.tencent.mm.plugin.remittance.model.u(remittanceBusiUI.Ctm, remittanceBusiUI.Ctk, remittanceBusiUI.Ctq, remittanceBusiUI.Crs), false);
        AppMethodBeat.o(68089);
    }

    static /* synthetic */ void eOe() {
        AppMethodBeat.i(213766);
        Log.i("MicroMsg.RemittanceBusiUI", "callBackCancel()");
        as asVar = new as();
        asVar.dDK.dDP = 4;
        EventCenter.instance.publish(asVar);
        AppMethodBeat.o(213766);
    }

    static /* synthetic */ void p(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(68096);
        if (!Util.isNullOrNil(remittanceBusiUI.Csr)) {
            remittanceBusiUI.CsY.setText(remittanceBusiUI.getString(R.string.g20, new Object[]{remittanceBusiUI.Csr}));
            remittanceBusiUI.CsZ.setText(R.string.g3a);
            AppMethodBeat.o(68096);
            return;
        }
        remittanceBusiUI.CsY.setText("");
        remittanceBusiUI.CsZ.setText(R.string.g1l);
        AppMethodBeat.o(68096);
    }

    static /* synthetic */ void s(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(213772);
        Log.i("MicroMsg.RemittanceBusiUI", "do place order");
        if (remittanceBusiUI.Csz == null) {
            Log.e("MicroMsg.RemittanceBusiUI", "doPlaceOrder busi_resp is null");
            AppMethodBeat.o(213772);
            return;
        }
        if (!remittanceBusiUI.Ctu) {
            remittanceBusiUI.hideWcKb();
        }
        remittanceBusiUI.a((int) Math.round(remittanceBusiUI.Ctl * 100.0d), remittanceBusiUI.CtH.Cqy, false, null, "", "");
        AppMethodBeat.o(213772);
    }

    static /* synthetic */ void J(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(213773);
        List<ans> list = null;
        if (remittanceBusiUI.mPayScene == 33) {
            if (remittanceBusiUI.Csz.Com != null) {
                list = remittanceBusiUI.Csz.Com.KXX;
            }
        } else if (remittanceBusiUI.CtH.eNF()) {
            list = remittanceBusiUI.CtH.eND();
            if (list.size() == 0) {
                Log.i("MicroMsg.RemittanceBusiUI", "can not find favor %s", Integer.valueOf(list.size()));
                AppMethodBeat.o(213773);
                return;
            }
        } else {
            list = remittanceBusiUI.Csz.Col;
        }
        remittanceBusiUI.Ctl = remittanceBusiUI.eNZ();
        if (((int) Math.round(remittanceBusiUI.Ctl * 100.0d)) <= 0) {
            remittanceBusiUI.gu(list);
            AppMethodBeat.o(213773);
        } else if (!remittanceBusiUI.CtH.eNF()) {
            remittanceBusiUI.a(new com.tencent.mm.plugin.remittance.model.c() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass9 */

                @Override // com.tencent.mm.plugin.remittance.model.c
                public final void gt(List<ans> list) {
                    AppMethodBeat.i(68022);
                    if (list.size() > 0) {
                        RemittanceBusiUI.a(RemittanceBusiUI.this, list);
                    }
                    AppMethodBeat.o(68022);
                }
            }, new com.tencent.mm.plugin.remittance.model.d() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass10 */

                @Override // com.tencent.mm.plugin.remittance.model.d
                public final void a(int i2, int i3, g gVar) {
                    AppMethodBeat.i(68023);
                    if (i2 != 0 || i3 != 0) {
                        u.makeText(RemittanceBusiUI.this.getContext(), RemittanceBusiUI.this.getString(R.string.ibn), 0).show();
                    } else if (gVar.Cov.pTZ != 0) {
                        u.makeText(RemittanceBusiUI.this.getContext(), gVar.Cov.pUa, 0).show();
                        AppMethodBeat.o(68023);
                        return;
                    }
                    AppMethodBeat.o(68023);
                }
            }, 0);
            AppMethodBeat.o(213773);
        } else if (remittanceBusiUI.CtM == null) {
            remittanceBusiUI.gu(list);
            AppMethodBeat.o(213773);
        } else if (remittanceBusiUI.CtM.Coy) {
            remittanceBusiUI.gu(list);
            AppMethodBeat.o(213773);
        } else {
            remittanceBusiUI.CtM.Cow = new com.tencent.mm.plugin.remittance.model.c() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.AnonymousClass8 */

                @Override // com.tencent.mm.plugin.remittance.model.c
                public final void gt(List<ans> list) {
                    AppMethodBeat.i(68021);
                    RemittanceBusiUI.a(RemittanceBusiUI.this, list);
                    AppMethodBeat.o(68021);
                }
            };
            AppMethodBeat.o(213773);
        }
    }

    static /* synthetic */ void M(RemittanceBusiUI remittanceBusiUI) {
        boolean z = false;
        AppMethodBeat.i(213776);
        if (remittanceBusiUI.Csz == null) {
            Log.e("MicroMsg.RemittanceBusiUI", "busi_resp is null");
            if (remittanceBusiUI.CtM != null) {
                remittanceBusiUI.CtM.cancel = true;
            }
            AppMethodBeat.o(213776);
            return;
        }
        remittanceBusiUI.Ctl = remittanceBusiUI.eNZ();
        int round = (int) Math.round(remittanceBusiUI.Ctl * 100.0d);
        Log.i("MicroMsg.RemittanceBusiUI", "update updateBilling %s", Integer.valueOf(round));
        if (round <= 0) {
            remittanceBusiUI.CtM.cancel = true;
            remittanceBusiUI.CtH.eNC();
            remittanceBusiUI.Cta.setTextColor(remittanceBusiUI.getContext().getResources().getColor(R.color.l4));
            remittanceBusiUI.Cta.setText(remittanceBusiUI.Csz.Coh);
            if (remittanceBusiUI.CtM != null) {
                remittanceBusiUI.CtM.cancel = true;
            }
            AppMethodBeat.o(213776);
            return;
        }
        remittanceBusiUI.Cta.setText(R.string.g1s);
        g gVar = remittanceBusiUI.CtM;
        if (remittanceBusiUI.CtM.Cow != null) {
            z = true;
        }
        remittanceBusiUI.doSceneProgress(gVar, z);
        AppMethodBeat.o(213776);
    }

    static /* synthetic */ boolean a(RemittanceBusiUI remittanceBusiUI, int i2, int i3, com.tencent.mm.plugin.remittance.model.l lVar) {
        long j2 = 0;
        AppMethodBeat.i(213778);
        if (remittanceBusiUI.CtC == 0) {
            AppMethodBeat.o(213778);
            return false;
        } else if (remittanceBusiUI.CtE >= remittanceBusiUI.CtC) {
            Log.i("MicroMsg.RemittanceBusiUI", "mZero_start_time %s >= mZero_try_time %s say bye bye", Integer.valueOf(remittanceBusiUI.CtE), Integer.valueOf(remittanceBusiUI.CtC));
            AppMethodBeat.o(213778);
            return false;
        } else {
            remittanceBusiUI.Cua.Cuy = lVar;
            if (i2 != 0 || i3 != 0) {
                remittanceBusiUI.CtE++;
                Log.i("MicroMsg.RemittanceBusiUI", "mZero_try_interval_ms  mZero_start_time %s mZero_try_interval_ms %s", Integer.valueOf(remittanceBusiUI.CtE), Integer.valueOf(remittanceBusiUI.CtD));
                MMHandlerThread.removeRunnable(remittanceBusiUI.Cua);
                c cVar = remittanceBusiUI.Cua;
                if (remittanceBusiUI.CtD >= 0) {
                    j2 = (long) remittanceBusiUI.CtD;
                }
                MMHandlerThread.postToMainThreadDelayed(cVar, j2);
                AppMethodBeat.o(213778);
                return true;
            } else if (lVar.CoG.pTZ == 0) {
                AppMethodBeat.o(213778);
                return false;
            } else if (lVar.CoG.pTZ == 0 || !lVar.rop) {
                AppMethodBeat.o(213778);
                return false;
            } else {
                remittanceBusiUI.CtE++;
                Log.i("MicroMsg.RemittanceBusiUI", "mZero_try_interval_ms  mZero_start_time %s mZero_try_interval_ms %s", Integer.valueOf(remittanceBusiUI.CtE), Integer.valueOf(remittanceBusiUI.CtD));
                MMHandlerThread.removeRunnable(remittanceBusiUI.Cua);
                c cVar2 = remittanceBusiUI.Cua;
                if (remittanceBusiUI.CtD >= 0) {
                    j2 = (long) remittanceBusiUI.CtD;
                }
                MMHandlerThread.postToMainThreadDelayed(cVar2, j2);
                AppMethodBeat.o(213778);
                return true;
            }
        }
    }

    static /* synthetic */ void a(RemittanceBusiUI remittanceBusiUI, boolean z, String str, double d2, String str2) {
        AppMethodBeat.i(213780);
        if (z) {
            if (Util.isNullOrNil(remittanceBusiUI.AJn)) {
                remittanceBusiUI.AJn = str;
            }
            if (d2 >= 0.0d) {
                remittanceBusiUI.dDO = d2;
            }
            if (remittanceBusiUI.Crx) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(15386, 3, 2);
            }
            remittanceBusiUI.eOd();
            remittanceBusiUI.aMl(str2);
            AppMethodBeat.o(213780);
            return;
        }
        Log.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor");
        remittanceBusiUI.eOc();
        AppMethodBeat.o(213780);
    }

    static /* synthetic */ void a(RemittanceBusiUI remittanceBusiUI, String str, gl glVar) {
        AppMethodBeat.i(213784);
        Log.i("MicroMsg.RemittanceBusiUI", "do place order %s", str);
        if (remittanceBusiUI.Csz == null) {
            Log.e("MicroMsg.RemittanceBusiUI", "doPlaceOrder busi_resp is null");
            AppMethodBeat.o(213784);
            return;
        }
        if (!remittanceBusiUI.Ctu) {
            remittanceBusiUI.hideWcKb();
        }
        String str2 = "";
        if (!Util.isNullOrNil(remittanceBusiUI.Ctm)) {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.storage.as bjJ = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(remittanceBusiUI.Ctm);
            if (bjJ != null) {
                str2 = bjJ.arJ();
            } else {
                Log.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + remittanceBusiUI.Ctm);
            }
        }
        remittanceBusiUI.a((int) Math.round(remittanceBusiUI.Ctl * 100.0d), remittanceBusiUI.CtH.Cqy, true, glVar, str, str2);
        AppMethodBeat.o(213784);
    }

    static /* synthetic */ void a(RemittanceBusiUI remittanceBusiUI, boolean z, int i2) {
        AppMethodBeat.i(213785);
        remittanceBusiUI.Cub = false;
        if (z) {
            Log.i("MicroMsg.RemittanceBusiUI", "savePayInfo isOk = true");
            remittanceBusiUI.dYe = 1;
        } else {
            remittanceBusiUI.dYe = i2;
            remittanceBusiUI.Cuc = remittanceBusiUI.Ctl;
            remittanceBusiUI.Cud = remittanceBusiUI.Csr;
            remittanceBusiUI.Cue = remittanceBusiUI.Csq;
        }
        Log.i("MicroMsg.RemittanceBusiUI", "savePayInfoByDynamic() mLastPayResult:%s mLastTotalAmt:%s mLastPayerDesc:%s mLastF2fId:%s", Double.valueOf(remittanceBusiUI.Cuc), Double.valueOf(remittanceBusiUI.Cuc), remittanceBusiUI.Cud, remittanceBusiUI.Cue);
        AppMethodBeat.o(213785);
    }

    static /* synthetic */ void a(RemittanceBusiUI remittanceBusiUI, gm gmVar) {
        AppMethodBeat.i(213786);
        Log.i("MicroMsg.RemittanceBusiUI", "do place order by large money remind ui");
        if (remittanceBusiUI.Csz == null) {
            Log.e("MicroMsg.RemittanceBusiUI", "doPlaceOrder busi_resp is null");
            AppMethodBeat.o(213786);
            return;
        }
        if (!remittanceBusiUI.Ctu) {
            remittanceBusiUI.hideWcKb();
        }
        remittanceBusiUI.a(gmVar.dKr.dKt, remittanceBusiUI.CtH.Cqy, false, null, "", "", gmVar.dKr.dKs);
        AppMethodBeat.o(213786);
    }

    static /* synthetic */ void Z(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(213787);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.ui.LauncherUI"));
        intent.addFlags(67108864);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(remittanceBusiUI, bl.axQ(), "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "finishRemitProcess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        remittanceBusiUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(remittanceBusiUI, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiUI", "finishRemitProcess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(213787);
    }

    static /* synthetic */ void a(RemittanceBusiUI remittanceBusiUI, String str, String str2) {
        boolean z;
        AppMethodBeat.i(213788);
        Log.i("MicroMsg.RemittanceBusiUI", "doPlaceOrderByNameCheck ");
        if (remittanceBusiUI.Csz == null) {
            Log.e("MicroMsg.RemittanceBusiUI", "doPlaceOrder busi_resp is null");
            AppMethodBeat.o(213788);
            return;
        }
        if (!remittanceBusiUI.Ctu) {
            remittanceBusiUI.hideWcKb();
        }
        int round = (int) Math.round(remittanceBusiUI.Ctl * 100.0d);
        rc rcVar = remittanceBusiUI.CtH.Cqy;
        int i2 = 0;
        if (!remittanceBusiUI.Cub) {
            boolean isEqual = Util.isEqual(Double.valueOf(remittanceBusiUI.Cuc), Double.valueOf(remittanceBusiUI.Ctl));
            boolean isEqual2 = Util.isEqual(remittanceBusiUI.Cud, remittanceBusiUI.Csr);
            if (!isEqual) {
                i2 = 1;
            }
            if (!isEqual2) {
                i2 |= 2;
            }
        }
        i iVar = new i(remittanceBusiUI.Crs, remittanceBusiUI.Ctk, remittanceBusiUI.mPayScene, remittanceBusiUI.Ctp, remittanceBusiUI.Csr, round, remittanceBusiUI.mChannel, remittanceBusiUI.Ctq, remittanceBusiUI.Ctv, remittanceBusiUI.Ctx, remittanceBusiUI.Ctw, remittanceBusiUI.Ctm, remittanceBusiUI.CtH.Cqx, rcVar == null ? "" : rcVar.KYa, remittanceBusiUI.Csz.Coi, "", remittanceBusiUI.CqN, "", remittanceBusiUI.Ctn, remittanceBusiUI.Cue, remittanceBusiUI.dYe, i2, "", str, str2);
        if (remittanceBusiUI.mKindaEnable) {
            if (remittanceBusiUI.CtR != null) {
                remittanceBusiUI.CtR.showSafeProgress();
            } else {
                remittanceBusiUI.showLoading();
            }
        } else if (!e.eNU().eNX()) {
            z = true;
            remittanceBusiUI.doSceneProgress(iVar, z);
            AppMethodBeat.o(213788);
        }
        z = false;
        remittanceBusiUI.doSceneProgress(iVar, z);
        AppMethodBeat.o(213788);
    }
}
