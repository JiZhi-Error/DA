package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import e.a.a.c;

@a(19)
public class RemittanceResultNewUI extends RemittanceResultUI {
    private static int[] Cxc = null;
    private PayInfo BDB;
    private LinearLayout Cre;
    private c CsF;
    private WalletSuccPageAwardWidget CsG;
    private boolean CsL = false;
    private IListener<aaa> CsM = new IListener<aaa>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160852);
            this.__eventId = aaa.class.getName().hashCode();
            AppMethodBeat.o(160852);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aaa aaa) {
            AppMethodBeat.i(68279);
            aaa aaa2 = aaa;
            Log.i("MicroMsg.RemittanceResultNewUI", "receive pay result event, do finish");
            if (aaa2.egJ.egK == 1000 || aaa2.egJ.egK == 1001) {
                Log.i("MicroMsg.RemittanceResultNewUI", "doEndRemittance");
                d process = RemittanceResultNewUI.this.getProcess();
                if (process != null) {
                    process.bz(RemittanceResultNewUI.this);
                }
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(68278);
                        RemittanceResultNewUI.this.finish();
                        AppMethodBeat.o(68278);
                    }
                }, 100);
            }
            AppMethodBeat.o(68279);
            return false;
        }
    };
    private LinearLayout CuN;
    private LinearLayout CuO;
    private LinearLayout CuP;
    private TextView CuQ;
    private TextView CuR;
    private TextView CuS;
    private TextView CuT;
    private TextView CuU;
    private int CvI = 0;
    private Orders CwO;
    private boolean CwP;
    private TextView CwQ;
    private ViewGroup CwR;
    private TextView CwS;
    private WalletTextView CwT;
    private ViewGroup CwU;
    private ViewGroup CwV;
    private ViewGroup CwW;
    private TextView CwX;
    private TextView CwY;
    private WalletTextView CwZ;
    private vt Cxa;
    private Button Cxb;
    private int mPayScene;
    private String mReceiverName;
    private int ppd;
    private int ppe;
    private com.tencent.mm.ui.widget.b.a pqr = null;
    private o.g rJj = new o.g() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI.AnonymousClass3 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(68281);
            String str = "";
            if (Util.isEqual(RemittanceResultNewUI.this.CvI, (int) R.id.h16)) {
                str = RemittanceResultNewUI.this.CuR.getText().toString().trim();
            } else if (Util.isEqual(RemittanceResultNewUI.this.CvI, (int) R.id.h0e)) {
                StringBuilder sb = new StringBuilder();
                sb.append(RemittanceResultNewUI.this.CuS.getText().toString().trim() + " ");
                String trim = RemittanceResultNewUI.this.CuU.getText().toString().trim();
                if (trim.endsWith(RemittanceResultNewUI.this.getString(R.string.g2_))) {
                    sb.append(trim.substring(0, trim.length() - 4));
                } else {
                    sb.append(trim);
                }
                str = sb.toString();
            }
            ClipboardHelper.setText(MMApplicationContext.getContext(), null, str);
            h.cD(RemittanceResultNewUI.this, RemittanceResultNewUI.this.getString(R.string.ta));
            AppMethodBeat.o(68281);
        }
    };
    private View.OnTouchListener tia = new View.OnTouchListener() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI.AnonymousClass4 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(68282);
            switch (motionEvent.getAction()) {
                case 0:
                    RemittanceResultNewUI.this.ppd = (int) motionEvent.getRawX();
                    RemittanceResultNewUI.this.ppe = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.o(68282);
            return false;
        }
    };
    private View.OnLongClickListener tib = new View.OnLongClickListener() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI.AnonymousClass5 */

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(68283);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceResultNewUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            Log.d("MicroMsg.RemittanceResultNewUI", "onLongClick");
            if (RemittanceResultNewUI.this.pqr == null) {
                RemittanceResultNewUI.this.pqr = new com.tencent.mm.ui.widget.b.a(RemittanceResultNewUI.this.getContext());
            }
            RemittanceResultNewUI.this.pqr.a(view, RemittanceResultNewUI.this, RemittanceResultNewUI.this.rJj, RemittanceResultNewUI.this.ppd, RemittanceResultNewUI.this.ppe);
            RemittanceResultNewUI.this.CvI = view.getId();
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/remittance/ui/RemittanceResultNewUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(68283);
            return true;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.remittance.ui.RemittanceResultUI, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RemittanceResultNewUI() {
        AppMethodBeat.i(68287);
        AppMethodBeat.o(68287);
    }

    static /* synthetic */ void a(RemittanceResultNewUI remittanceResultNewUI) {
        AppMethodBeat.i(68302);
        remittanceResultNewUI.eOl();
        AppMethodBeat.o(68302);
    }

    static /* synthetic */ void j(RemittanceResultNewUI remittanceResultNewUI) {
        AppMethodBeat.i(68303);
        remittanceResultNewUI.eOm();
        AppMethodBeat.o(68303);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(68288);
        Log.i("MicroMsg.RemittanceResultNewUI", "finish this %s %s", this, Util.getStack());
        if (this.CsL) {
            AppMethodBeat.o(68288);
            return;
        }
        super.finish();
        this.CsL = true;
        AppMethodBeat.o(68288);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.remittance.ui.RemittanceResultUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68289);
        super.onCreate(bundle);
        if (com.tencent.mm.compatible.util.d.oD(21)) {
            if (com.tencent.mm.compatible.util.d.oD(23)) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.afz));
            } else {
                getWindow().setStatusBarColor(getResources().getColor(R.color.BW_90));
            }
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.CsM.alive();
        this.CwO = (Orders) getInput().getParcelable("key_orders");
        this.BDB = (PayInfo) getInput().getParcelable("key_pay_info");
        if (this.BDB == null) {
            Log.e("MicroMsg.RemittanceResultNewUI", "payInfo is null!!!");
            finish();
            AppMethodBeat.o(68289);
            return;
        }
        String str = "";
        String str2 = "";
        if (this.BDB.iqp != null) {
            this.CwP = this.BDB.iqp.getBoolean("extinfo_key_4");
            str = this.BDB.iqp.getString("extinfo_key_1");
            str2 = this.BDB.iqp.getString("extinfo_key_16");
        }
        int i2 = this.BDB.dVv;
        this.mPayScene = i2;
        this.mReceiverName = str;
        Log.i("MicroMsg.RemittanceResultNewUI", "payScene: %s", Integer.valueOf(i2));
        initView();
        if (this.mPayScene == 31) {
            Log.i("MicroMsg.RemittanceResultNewUI", "transId: %s", str2);
            com.tencent.mm.plugin.remittance.a.c.eMU().eMX().jM(str2, this.mReceiverName);
        }
        AppMethodBeat.o(68289);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.remittance.ui.RemittanceResultUI
    public int getLayoutId() {
        return R.layout.bn0;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(68290);
        if (i2 == 4) {
            eOl();
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(68290);
        return onKeyUp;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        String str;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        boolean z2;
        AppMethodBeat.i(68291);
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        this.CwQ = (TextView) findViewById(R.id.g9l);
        this.CwR = (ViewGroup) findViewById(R.id.c8e);
        this.CwS = (TextView) findViewById(R.id.c89);
        this.CwT = (WalletTextView) findViewById(R.id.c87);
        this.CwU = (ViewGroup) findViewById(R.id.c8c);
        this.CwV = (ViewGroup) findViewById(R.id.c8d);
        this.CwW = (ViewGroup) findViewById(R.id.g0n);
        this.CwX = (TextView) findViewById(R.id.g0m);
        this.CwY = (TextView) findViewById(R.id.g0j);
        this.CwZ = (WalletTextView) findViewById(R.id.g0i);
        this.Cxb = (Button) findViewById(R.id.iuy);
        this.Cxb.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(68280);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceResultNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                RemittanceResultNewUI.a(RemittanceResultNewUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceResultNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68280);
            }
        });
        this.CsG = (WalletSuccPageAwardWidget) findViewById(R.id.xh);
        this.CuN = (LinearLayout) findViewById(R.id.h23);
        this.CuO = (LinearLayout) findViewById(R.id.h14);
        this.Cre = (LinearLayout) findViewById(R.id.h0d);
        this.CuP = (LinearLayout) findViewById(R.id.h0e);
        this.CuQ = (TextView) findViewById(R.id.h19);
        this.CuR = (TextView) findViewById(R.id.h16);
        this.CuS = (TextView) findViewById(R.id.fth);
        this.CuT = (TextView) findViewById(R.id.ha);
        this.CuU = (TextView) findViewById(R.id.h_);
        String displayName = f.getDisplayName(this.mReceiverName);
        if (this.mPayScene == 31 || this.mPayScene == 5) {
            this.CwY.setText(f.bpp(this.CwO.AOl));
            this.CwZ.setText(f.formatMoney2f(this.CwO.dDO));
            if (this.mPayScene == 31) {
                String string = getString(R.string.g4e, new Object[]{displayName});
                if (!Util.isNullOrNil(string)) {
                    this.CwX.setText(l.b(this, string, this.CwX.getTextSize()));
                } else {
                    this.CwX.setVisibility(8);
                }
            } else {
                if (this.BDB.iqp == null || !this.BDB.iqp.getBoolean("extinfo_key_10")) {
                    z = false;
                } else {
                    z = true;
                }
                Log.i("MicroMsg.RemittanceResultNewUI", "isEmojiReward: %s", Boolean.valueOf(z));
                if (z) {
                    this.CwX.setText(getString(R.string.g3b));
                } else if (!(this.CwO.HZd == null || this.CwO.HZd.get(0) == null || TextUtils.isEmpty(this.CwO.HZd.get(0).AOa))) {
                    this.CwX.setText(this.CwO.HZd.get(0).AOa);
                }
            }
            this.CwW.setVisibility(0);
            if (this.CwO.CoZ > 0.0d) {
                eOk();
                ((ViewGroup.MarginLayoutParams) this.CwU.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 20);
                this.CwU.setVisibility(0);
                this.CwV.setVisibility(0);
            }
        } else {
            byte[] byteArray = getInput().getByteArray("key_succpage_resp");
            if (byteArray != null) {
                this.Cxa = new vt();
                try {
                    this.Cxa.parseFrom(byteArray);
                    this.CsF = this.Cxa.Iah;
                } catch (Exception e2) {
                    this.Cxa = null;
                    this.CsF = null;
                    Log.printErrStackTrace("MicroMsg.RemittanceResultNewUI", e2, "parse f2FPaySucPageResp error: %s", e2.getMessage());
                }
            }
            String displayName2 = f.getDisplayName(this.mReceiverName);
            this.CwS.setText(f.bpp(this.CwO.AOl));
            this.CwT.setText(f.formatMoney2f(this.CwO.dDO));
            this.CwV.removeAllViews();
            if (this.mPayScene == 32 || this.mPayScene == 33 || this.mPayScene == 48) {
                if (Util.isNullOrNil(displayName2) && this.BDB.iqp != null) {
                    displayName2 = this.BDB.iqp.getString("extinfo_key_28");
                }
                String str2 = "";
                if (this.BDB.iqp != null) {
                    str2 = this.BDB.iqp.getString("extinfo_key_2");
                }
                if (displayName2 != null && displayName2.length() > 10) {
                    displayName2 = displayName2.substring(0, 10) + "...";
                }
                if (Util.isNullOrNil(str2)) {
                    str = displayName2;
                } else if (!Util.isNullOrNil(displayName2)) {
                    str = displayName2 + "(" + f.bps(str2) + ")";
                } else {
                    str = str2;
                }
                Log.i("MicroMsg.RemittanceResultNewUI", "setF2FReceiverRemarkView");
                String string2 = this.BDB.iqp.getString("extinfo_key_3");
                String string3 = this.BDB.iqp.getString("extinfo_key_8");
                if (!Util.isNullOrNil(string2)) {
                    ViewGroup viewGroup3 = (ViewGroup) getLayoutInflater().inflate(R.layout.a5j, this.CwV, false);
                    TextView textView = (TextView) viewGroup3.findViewById(R.id.ir3);
                    TextView textView2 = (TextView) viewGroup3.findViewById(R.id.bn6);
                    if (!Util.isNullOrNil(string3)) {
                        textView.setText(string3);
                    } else {
                        textView.setText(getString(R.string.b6j));
                    }
                    textView2.setText(string2);
                    viewGroup = viewGroup3;
                } else {
                    viewGroup = null;
                }
                Log.i("MicroMsg.RemittanceResultNewUI", "setF2FPayerRemarkView");
                String string4 = this.BDB.iqp.getString("extinfo_key_6");
                String string5 = this.BDB.iqp.getString("extinfo_key_7");
                if (!Util.isNullOrNil(string5)) {
                    ViewGroup viewGroup4 = (ViewGroup) getLayoutInflater().inflate(R.layout.a5j, this.CwV, false);
                    TextView textView3 = (TextView) viewGroup4.findViewById(R.id.ir3);
                    TextView textView4 = (TextView) viewGroup4.findViewById(R.id.bn6);
                    if (!Util.isNullOrNil(string4)) {
                        textView3.setText(string4);
                    } else {
                        textView3.setText(getString(R.string.b6i));
                    }
                    textView4.setText(string5);
                    viewGroup2 = viewGroup4;
                } else {
                    viewGroup2 = null;
                }
                View eOk = eOk();
                if (viewGroup == null && viewGroup2 == null && eOk == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.CwU.setVisibility(0);
                this.CwV.setVisibility(0);
                if (WalletSuccPageAwardWidget.a(this.CsF)) {
                    String str3 = "";
                    if (this.CwO.HZd.size() > 0) {
                        str3 = this.CwO.HZd.get(0).dDM;
                    }
                    Log.i("MicroMsg.RemittanceResultNewUI", "transId: %s", str3);
                    this.CsG.a(this, this.CsF, str3, true, (ImageView) findViewById(R.id.y1));
                    this.CsG.init();
                    this.CsG.setVisibility(0);
                    ca(str, false);
                } else {
                    this.CsG.setVisibility(8);
                    ca(str, z2);
                }
                if (viewGroup != null) {
                    this.CwV.addView(viewGroup);
                }
                if (viewGroup2 != null) {
                    this.CwV.addView(viewGroup2);
                }
                if (eOk != null) {
                    this.CwV.addView(eOk);
                }
            }
            this.CwR.setVisibility(0);
        }
        ((com.tencent.mm.plugin.fingerprint.b.h) g.af(com.tencent.mm.plugin.fingerprint.b.h.class)).i(this);
        AppMethodBeat.o(68291);
    }

    public static int m(Context context, String str, int i2) {
        boolean z = true;
        AppMethodBeat.i(68292);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, 16);
        if (Cxc == null) {
            Cxc = KeyBoardUtil.getScreenWH(context);
        }
        int fromDPToPix2 = ((Cxc[0] - com.tencent.mm.cb.a.fromDPToPix(context, 88)) - i2) / fromDPToPix;
        int length = str.length();
        int i3 = length / fromDPToPix2;
        if (i3 <= 2 && (i3 != 2 || length % fromDPToPix2 <= 0)) {
            z = false;
        }
        if (z) {
            int i4 = (fromDPToPix2 * 2) - 5;
            AppMethodBeat.o(68292);
            return i4;
        }
        int length2 = str.length();
        AppMethodBeat.o(68292);
        return length2;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(68293);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 0, 0, getString(R.string.t_));
        AppMethodBeat.o(68293);
    }

    private ViewGroup ca(String str, boolean z) {
        ViewGroup viewGroup;
        AppMethodBeat.i(68294);
        Log.i("MicroMsg.RemittanceResultNewUI", "setF2FNameView");
        if (z) {
            viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.a5l, this.CwV, false);
            CdnImageView cdnImageView = (CdnImageView) viewGroup.findViewById(R.id.h0w);
            TextView textView = (TextView) viewGroup.findViewById(R.id.gry);
            if (!Util.isNullOrNil(this.mReceiverName) || this.BDB.iqp == null) {
                a.b.a(cdnImageView, this.mReceiverName, 0.06f, false);
            } else {
                int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 56.0f);
                cdnImageView.setRoundCorner(true);
                cdnImageView.s(this.BDB.iqp.getString("extinfo_key_27"), fromDPToPix, fromDPToPix, R.drawable.bca);
            }
            textView.setText(str);
            this.CwV.addView(viewGroup);
            AppMethodBeat.o(68294);
        } else {
            viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.a5k, this.CwV, false);
            CdnImageView cdnImageView2 = (CdnImageView) viewGroup.findViewById(R.id.h0w);
            TextView textView2 = (TextView) viewGroup.findViewById(R.id.gry);
            if (!Util.isNullOrNil(this.mReceiverName) || this.BDB.iqp == null) {
                a.b.a(cdnImageView2, this.mReceiverName, 0.06f, false);
            } else {
                int fromDPToPix2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 28.0f);
                cdnImageView2.setRoundCorner(true);
                cdnImageView2.s(this.BDB.iqp.getString("extinfo_key_27"), fromDPToPix2, fromDPToPix2, R.drawable.bca);
            }
            textView2.setText(str);
            this.CwV.addView(viewGroup);
            AppMethodBeat.o(68294);
        }
        return viewGroup;
    }

    private View eOk() {
        boolean z = true;
        AppMethodBeat.i(68295);
        if (this.CwO != null) {
            Object[] objArr = new Object[1];
            if (this.CwO.CoZ <= 0.0d) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.i("MicroMsg.RemittanceResultNewUI", "need set charge fee: %s", objArr);
            if (this.CwO.CoZ > 0.0d) {
                String string = getString(R.string.g4b);
                String d2 = f.d(this.CwO.CoZ, this.CwO.AOl);
                ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.a5i, this.CwV, false);
                ((TextView) viewGroup.findViewById(R.id.ir3)).setText(string);
                ((ImageView) viewGroup.findViewById(R.id.x1)).setVisibility(8);
                ((TextView) viewGroup.findViewById(R.id.bn6)).setText(d2);
                this.CwV.addView(viewGroup);
                AppMethodBeat.o(68295);
                return viewGroup;
            }
        }
        AppMethodBeat.o(68295);
        return null;
    }

    private void eOl() {
        AppMethodBeat.i(68296);
        Log.i("MicroMsg.RemittanceResultNewUI", "endRemittance");
        if (getInput().containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) getInput().getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                realnameGuideHelper.b(this, bundle, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(68284);
                        RemittanceResultNewUI.j(RemittanceResultNewUI.this);
                        AppMethodBeat.o(68284);
                    }
                });
                realnameGuideHelper.a(this, bundle, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI.AnonymousClass7 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(68285);
                        RemittanceResultNewUI.j(RemittanceResultNewUI.this);
                        AppMethodBeat.o(68285);
                    }
                });
                getInput().remove("key_realname_guide_helper");
            }
            AppMethodBeat.o(68296);
            return;
        }
        eOm();
        AppMethodBeat.o(68296);
    }

    private void eOm() {
        AppMethodBeat.i(68297);
        Log.i("MicroMsg.RemittanceResultNewUI", "doEndRemittance");
        getProcess().b(this, getInput());
        new MMHandler().postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(68286);
                if (RemittanceResultNewUI.this.mPayScene == 33 || RemittanceResultNewUI.this.mPayScene == 32 || RemittanceResultNewUI.this.mPayScene == 48) {
                    RemittanceResultNewUI.this.finish();
                    AppMethodBeat.o(68286);
                } else if (Util.isNullOrNil(RemittanceResultNewUI.this.mReceiverName) || RemittanceResultNewUI.this.CwP) {
                    RemittanceResultNewUI.this.finish();
                    AppMethodBeat.o(68286);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", RemittanceResultNewUI.this.mReceiverName);
                    intent.putExtra("finish_direct", false);
                    com.tencent.mm.br.c.f(RemittanceResultNewUI.this, ".ui.chatting.ChattingUI", intent);
                    AppMethodBeat.o(68286);
                }
            }
        }, 100);
        AppMethodBeat.o(68297);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceResultUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(68298);
        if (WalletSuccPageAwardWidget.a(this.CsF)) {
            boolean onSceneEnd = this.CsG.onSceneEnd(i2, i3, str, qVar);
            AppMethodBeat.o(68298);
            return onSceneEnd;
        }
        boolean onSceneEnd2 = super.onSceneEnd(i2, i3, str, qVar);
        AppMethodBeat.o(68298);
        return onSceneEnd2;
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void setContentViewVisibility(int i2) {
        AppMethodBeat.i(68299);
        getContentView().setVisibility(i2);
        AppMethodBeat.o(68299);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceResultUI
    public final boolean eOn() {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(68300);
        super.onResume();
        if (WalletSuccPageAwardWidget.a(this.CsF)) {
            this.CsG.onResume();
        }
        AppMethodBeat.o(68300);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.remittance.ui.RemittanceResultUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(68301);
        super.onDestroy();
        this.CsM.dead();
        if (WalletSuccPageAwardWidget.a(this.CsF)) {
            this.CsG.onDestroy();
        }
        AppMethodBeat.o(68301);
    }
}
