package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.support.transition.Transition;
import android.support.transition.TransitionSet;
import android.support.transition.q;
import android.support.transition.s;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ScaleLayoutManager;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyEnvelopeTouchRecyclerView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.xm;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.snackbar.a;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.wxmm.v2helper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(1)
public class LuckyMoneyPickEnvelopeUI extends MMActivity {
    private View GQ;
    private boolean UYw = false;
    private boolean isLoading = false;
    private String sessionId;
    private long startTime;
    private Dialog tipDialog;
    private int yQF = 0;
    private View yYd;
    private LuckyMoneyEnvelopeTouchRecyclerView zgB;
    private c zgC;
    private ScaleLayoutManager zgD;
    private List<d> zgE = new ArrayList();
    private int zgF = -1;
    private int zgG = -1;
    private boolean zgH = false;
    private String zgI;
    private com.tencent.mm.plugin.luckymoney.scaledLayout.a zgJ;
    private Button zgK;
    private LinkedList<String> zgL;
    private RecyclerView.l zgM;
    private boolean zgN = true;
    private Boolean zgO;
    private String zgP;
    private String zgQ;
    private String zgR;
    private IListener<rg> zgS = new IListener<rg>() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass14 */

        {
            AppMethodBeat.i(163774);
            this.__eventId = rg.class.getName().hashCode();
            AppMethodBeat.o(163774);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(rg rgVar) {
            AppMethodBeat.i(163775);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass14.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(163770);
                    LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, true);
                    AppMethodBeat.o(163770);
                }
            });
            AppMethodBeat.o(163775);
            return false;
        }
    };
    private boolean zgT = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyPickEnvelopeUI() {
        AppMethodBeat.i(65813);
        AppMethodBeat.o(65813);
    }

    static /* synthetic */ void a(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, bvi bvi, boolean z) {
        AppMethodBeat.i(213465);
        luckyMoneyPickEnvelopeUI.a(bvi, z);
        AppMethodBeat.o(213465);
    }

    static /* synthetic */ void a(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, boolean z) {
        AppMethodBeat.i(213464);
        luckyMoneyPickEnvelopeUI.qP(z);
        AppMethodBeat.o(213464);
    }

    static /* synthetic */ boolean e(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, String str) {
        AppMethodBeat.i(213472);
        boolean aDG = luckyMoneyPickEnvelopeUI.aDG(str);
        AppMethodBeat.o(213472);
        return aDG;
    }

    static /* synthetic */ void egA() {
    }

    static /* synthetic */ void egz() {
    }

    static /* synthetic */ void p(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI) {
        AppMethodBeat.i(213466);
        luckyMoneyPickEnvelopeUI.egw();
        AppMethodBeat.o(213466);
    }

    static /* synthetic */ void v(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI) {
        AppMethodBeat.i(213467);
        luckyMoneyPickEnvelopeUI.egx();
        AppMethodBeat.o(213467);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(65814);
        fixStatusbar(true);
        super.onCreate(bundle);
        hideActionbarLine();
        setActionbarColor(getContext().getResources().getColor(R.color.BW_97));
        initView();
        setMMTitle(R.string.era);
        this.startTime = Util.currentTicks();
        byte[] byteArrayExtra = getIntent().getByteArrayExtra(e.i.Oze);
        boolean booleanExtra = getIntent().getBooleanExtra(e.i.Ozf, true);
        this.zgO = Boolean.valueOf(getIntent().getBooleanExtra(e.i.Ozi, false));
        this.sessionId = getIntent().getStringExtra("key_session_id");
        final String stringExtra = getIntent().getStringExtra(e.i.Ozh);
        this.zgQ = getIntent().getStringExtra("packetId");
        Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll packageid: %s", this.zgQ);
        if (!booleanExtra) {
            this.zgH = false;
            this.yQF = 0;
            this.zgF = 0;
            d dVar = new d((byte) 0);
            dVar.pWp = true;
            dVar.yXW = new cbe();
            dVar.yXW.Lot = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            dVar.yXW.MgB = getString(R.string.eoe);
            this.zgE.add(dVar);
            this.zgC.atj.notifyChanged();
        } else if (byteArrayExtra != null) {
            try {
                bvi bvi = (bvi) new bvi().parseFrom(byteArrayExtra);
                if (bvi.dDN == 0) {
                    this.zgI = bvi.Mbt;
                    this.yQF = bvi.Mbu;
                    a(bvi, true);
                    egw();
                } else {
                    qP(true);
                }
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.LuckyMoneyPickEnvelopeUI", e2, "", new Object[0]);
                qP(true);
            }
        } else {
            qP(true);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(65787);
                String str = "";
                if (LuckyMoneyPickEnvelopeUI.this.zgF >= 0) {
                    str = ((d) LuckyMoneyPickEnvelopeUI.this.zgE.get(LuckyMoneyPickEnvelopeUI.this.zgF)).yXW.Lot;
                }
                h.INSTANCE.a(18892, 2, Integer.valueOf(LuckyMoneyPickEnvelopeUI.this.zgG + 1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.this.zgF + 1), LuckyMoneyPickEnvelopeUI.this.zgP, str, LuckyMoneyPickEnvelopeUI.this.sessionId);
                if (!Util.isNullOrNil(LuckyMoneyPickEnvelopeUI.this.zgR)) {
                    h.INSTANCE.a(22104, LuckyMoneyPickEnvelopeUI.this.zgR, 4, Long.valueOf(Util.ticksToNow(LuckyMoneyPickEnvelopeUI.this.startTime) / 1000));
                }
                LuckyMoneyPickEnvelopeUI.this.setResult(0);
                LuckyMoneyPickEnvelopeUI.this.finish();
                AppMethodBeat.o(65787);
                return false;
            }
        });
        if (!Util.isNullOrNil(stringExtra)) {
            addTextOptionMenu(1, getString(R.string.eon), com.tencent.mm.cb.a.n(getContext(), R.color.x3), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass10 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    int i2;
                    AppMethodBeat.i(65791);
                    Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "click exchange tv");
                    Uri.Builder buildUpon = Uri.parse(stringExtra).buildUpon();
                    buildUpon.appendQueryParameter("sessionId", LuckyMoneyPickEnvelopeUI.this.sessionId);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", buildUpon.build().toString());
                    intent.putExtra("showShare", false);
                    intent.putExtra("KRightBtn", true);
                    com.tencent.mm.wallet_core.ui.f.b(LuckyMoneyPickEnvelopeUI.this.getContext(), intent, 1);
                    h hVar = h.INSTANCE;
                    Object[] objArr = new Object[3];
                    objArr[0] = 3;
                    if (LuckyMoneyPickEnvelopeUI.this.zgO.booleanValue()) {
                        i2 = 2;
                    } else {
                        i2 = 1;
                    }
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = LuckyMoneyPickEnvelopeUI.this.sessionId;
                    hVar.a(18890, objArr);
                    AppMethodBeat.o(65791);
                    return false;
                }
            });
        }
        egx();
        this.zgS.alive();
        AppMethodBeat.o(65814);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(65815);
        this.zgB = (LuckyMoneyEnvelopeTouchRecyclerView) findViewById(R.id.eov);
        this.GQ = findViewById(R.id.eos);
        this.zgK = (Button) findViewById(R.id.eot);
        this.zgC = new c(this, (byte) 0);
        this.zgC.au(true);
        this.zgB.setAdapter(this.zgC);
        this.zgB.setItemAnimator(null);
        this.zgD = new ScaleLayoutManager(this) {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass11 */

            @Override // com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager
            public final void efp() {
                AppMethodBeat.i(65792);
                super.efp();
                this.yYw -= 31.0f;
                AppMethodBeat.o(65792);
            }
        };
        ScaleLayoutManager scaleLayoutManager = this.zgD;
        scaleLayoutManager.assertNotInLayoutOrScroll(null);
        if (scaleLayoutManager.aXu != 0.8f) {
            scaleLayoutManager.aXu = 0.8f;
            scaleLayoutManager.removeAllViews();
        }
        this.zgB.setLayoutManager(this.zgD);
        this.zgJ = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
        this.zgJ.context = this;
        this.zgJ.f(this.zgB);
        this.zgB.zer = new LuckyMoneyEnvelopeTouchRecyclerView.a() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass12 */

            @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyEnvelopeTouchRecyclerView.a
            public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                AppMethodBeat.i(65793);
                if (motionEvent.getAction() == 0) {
                    LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI = LuckyMoneyPickEnvelopeUI.this;
                    com.tencent.mm.plugin.luckymoney.scaledLayout.a unused = LuckyMoneyPickEnvelopeUI.this.zgJ;
                    luckyMoneyPickEnvelopeUI.yYd = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.this.zgD);
                    LuckyMoneyPickEnvelopeUI.this.zgJ.yYd = LuckyMoneyPickEnvelopeUI.this.yYd;
                }
                AppMethodBeat.o(65793);
                return false;
            }
        };
        getIntent().getStringExtra(e.i.Ozg);
        getIntent().getStringExtra(e.i.Ozh);
        this.zgK.setOnClickListener(new x() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass13 */

            @Override // com.tencent.mm.ui.x
            public final void czW() {
                AppMethodBeat.i(213437);
                Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "click save: %s", Integer.valueOf(LuckyMoneyPickEnvelopeUI.this.zgF));
                if (LuckyMoneyPickEnvelopeUI.this.zgF >= 0 && LuckyMoneyPickEnvelopeUI.this.zgF < LuckyMoneyPickEnvelopeUI.this.zgE.size()) {
                    d dVar = (d) LuckyMoneyPickEnvelopeUI.this.zgE.get(LuckyMoneyPickEnvelopeUI.this.zgF);
                    if (dVar.pWp && dVar.yXW != null) {
                        String str = dVar.yXW.Lot;
                        if (dVar.yXW.iwy == 3) {
                            LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, str, dVar.yXW.MgS, LuckyMoneyPickEnvelopeUI.this.zgF);
                            h.INSTANCE.a(22104, dVar.yXW.Lot, 3);
                        } else {
                            LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, str);
                        }
                    }
                }
                h.INSTANCE.a(16822, 3);
                String str2 = "";
                if (LuckyMoneyPickEnvelopeUI.this.zgF >= 0) {
                    str2 = ((d) LuckyMoneyPickEnvelopeUI.this.zgE.get(LuckyMoneyPickEnvelopeUI.this.zgF)).yXW.Lot;
                }
                h.INSTANCE.a(18892, 1, Integer.valueOf(LuckyMoneyPickEnvelopeUI.this.zgG + 1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.this.zgF + 1), LuckyMoneyPickEnvelopeUI.this.zgP, str2, LuckyMoneyPickEnvelopeUI.this.sessionId);
                AppMethodBeat.o(213437);
            }
        });
        AppMethodBeat.o(65815);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(163788);
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(163788);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(65816);
        super.onDestroy();
        this.zgS.dead();
        AppMethodBeat.o(65816);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b49;
    }

    private boolean aDG(String str) {
        AppMethodBeat.i(163789);
        if (this.zgL != null && !this.zgL.isEmpty()) {
            Iterator<String> it = this.zgL.iterator();
            while (it.hasNext()) {
                if (it.next().equals(str)) {
                    AppMethodBeat.o(163789);
                    return true;
                }
            }
        }
        AppMethodBeat.o(163789);
        return false;
    }

    private void qP(final boolean z) {
        AppMethodBeat.i(163790);
        Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do get show source: %s, %s", Boolean.valueOf(z), this.zgI);
        if (z) {
            this.zgI = "";
        }
        this.tipDialog = com.tencent.mm.ui.base.h.a((Context) getContext(), 3, (int) R.style.lj, getString(R.string.ekc), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass15 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.isLoading = true;
        k eeZ = k.eeZ();
        eeZ.b(new com.tencent.mm.plugin.luckymoney.model.d(this.zgI, 1));
        eeZ.a(new a.AbstractC2168a<bvi>() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass16 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
            @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
            public final /* synthetic */ void d(bvi bvi, int i2, int i3) {
                AppMethodBeat.i(258712);
                bvi bvi2 = bvi;
                if (LuckyMoneyPickEnvelopeUI.this.tipDialog != null && LuckyMoneyPickEnvelopeUI.this.tipDialog.isShowing()) {
                    LuckyMoneyPickEnvelopeUI.this.tipDialog.dismiss();
                }
                LuckyMoneyPickEnvelopeUI.this.isLoading = false;
                Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do get show source net callback");
                if (bvi2 != null) {
                    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "retcode: %s", Integer.valueOf(bvi2.dDN));
                    if (bvi2.dDN == 0) {
                        LuckyMoneyPickEnvelopeUI.this.yQF = bvi2.Mbu;
                        LuckyMoneyPickEnvelopeUI.this.zgI = bvi2.Mbt;
                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_LAST_RECEIVE_TIMESTAMP_LONG_SYNC, Long.valueOf(bvi2.Mbx));
                        if (z) {
                            LuckyMoneyPickEnvelopeUI.this.zgE.clear();
                        }
                        Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "hasMore: %s, pagedata: %s", Integer.valueOf(LuckyMoneyPickEnvelopeUI.this.yQF), LuckyMoneyPickEnvelopeUI.this.zgI);
                        LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, bvi2, z);
                        if (z) {
                            LuckyMoneyPickEnvelopeUI.p(LuckyMoneyPickEnvelopeUI.this);
                            AppMethodBeat.o(258712);
                            return;
                        }
                    } else {
                        com.tencent.mm.wallet_core.ui.f.bpB(bvi2.qwn);
                        AppMethodBeat.o(258712);
                        return;
                    }
                } else {
                    com.tencent.mm.wallet_core.ui.f.ar(LuckyMoneyPickEnvelopeUI.this.getContext(), "");
                }
                AppMethodBeat.o(258712);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
            public final /* bridge */ /* synthetic */ void dx(bvi bvi) {
            }
        }, 0);
        AppMethodBeat.o(163790);
    }

    private void a(bvi bvi) {
        boolean z;
        AppMethodBeat.i(65818);
        Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "try show illegal msg");
        if (Util.isNullOrNil(bvi.yUF)) {
            AppMethodBeat.o(65818);
            return;
        }
        ArrayList arrayList = new ArrayList(Util.stringToList((String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_ILLEGAL2_STRING_SYNC, ""), ","));
        this.zgL = bvi.Mbv;
        Iterator<String> it = this.zgL.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            String next = it.next();
            if (!arrayList.contains(next)) {
                arrayList.add(next);
                Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "show illegal id: %s", next);
                z = true;
            } else {
                z = z2;
            }
            z2 = z;
        }
        if (z2) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_ILLEGAL2_STRING_SYNC, Util.listToString(arrayList, ","));
            com.tencent.mm.ui.base.h.a((Context) this, bvi.yUF, "", getString(R.string.w1), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass17 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
        }
        AppMethodBeat.o(65818);
    }

    private void a(bvi bvi, boolean z) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(213459);
        Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "update by resp");
        this.zgH = bvi.Mbw == 1;
        a(bvi);
        if (bvi.Mbs != null) {
            if (bvi.Mbs.isEmpty()) {
                this.GQ.setVisibility(0);
                this.zgB.setVisibility(8);
            } else {
                Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "list size: %s", Integer.valueOf(bvi.Mbs.size()));
                boolean z4 = !Util.isNullOrNil(this.zgQ);
                Iterator<cbe> it = bvi.Mbs.iterator();
                int i2 = 0;
                int i3 = -1;
                while (it.hasNext()) {
                    cbe next = it.next();
                    if (next.KTQ == 1 || next.MgE == 1 || aDG(next.Lot)) {
                        Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "filter unused envelope: %s", next.Lot);
                        i2++;
                    } else {
                        d dVar = new d((byte) 0);
                        dVar.yXW = next;
                        if (z) {
                            if (!z4) {
                                if (next.MgE == 1 || next.KTQ == 1 || aDG(next.Lot)) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (next.MgF != 1 || !z2) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                dVar.pWp = z3;
                                if (i3 < 0 && z2) {
                                    i3 = i2;
                                }
                            } else if (next.Lot.equals(this.zgQ)) {
                                dVar.pWp = true;
                            }
                            if (dVar.pWp) {
                                this.zgF = i2;
                            }
                        }
                        if (next.iwy == 3) {
                            this.zgR = next.Lot;
                            h.INSTANCE.a(22104, this.zgR, 1);
                        }
                        this.zgE.add(dVar);
                        i2++;
                    }
                }
                if (this.zgF < 0) {
                    if (i3 >= 0) {
                        this.zgF = i3;
                    } else {
                        this.zgF = 0;
                    }
                    this.zgE.get(this.zgF).pWp = true;
                }
                if (bvi.VjM == 1) {
                    d dVar2 = new d((byte) 0);
                    dVar2.yXW = new cbe();
                    dVar2.UYC = true;
                    this.zgE.add(dVar2);
                }
                if (this.zgN) {
                    this.zgN = false;
                    this.zgG = this.zgF;
                    if (this.zgG >= 0) {
                        this.zgP = this.zgE.get(this.zgG).yXW.Lot;
                    }
                }
            }
        }
        this.zgC.atj.notifyChanged();
        egx();
        AppMethodBeat.o(213459);
    }

    private void egw() {
        AppMethodBeat.i(163791);
        this.zgB.post(new Runnable() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(163767);
                if (LuckyMoneyPickEnvelopeUI.this.zgF >= 0 && LuckyMoneyPickEnvelopeUI.this.zgF < LuckyMoneyPickEnvelopeUI.this.zgC.getItemCount()) {
                    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll to pos: %s", Integer.valueOf(LuckyMoneyPickEnvelopeUI.this.zgF));
                    LuckyMoneyEnvelopeTouchRecyclerView luckyMoneyEnvelopeTouchRecyclerView = LuckyMoneyPickEnvelopeUI.this.zgB;
                    ScaleLayoutManager scaleLayoutManager = LuckyMoneyPickEnvelopeUI.this.zgD;
                    int AE = scaleLayoutManager.AE(LuckyMoneyPickEnvelopeUI.this.zgF);
                    if (((ViewPagerLayoutManager) scaleLayoutManager).mOrientation == 1) {
                        luckyMoneyEnvelopeTouchRecyclerView.scrollBy(0, AE);
                    } else {
                        luckyMoneyEnvelopeTouchRecyclerView.scrollBy(AE, 0);
                    }
                }
                Math.max(LuckyMoneyPickEnvelopeUI.this.zgF, 0);
                LuckyMoneyPickEnvelopeUI.egz();
                if (LuckyMoneyPickEnvelopeUI.this.zgM == null) {
                    LuckyMoneyPickEnvelopeUI.this.zgM = new RecyclerView.l() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass2.AnonymousClass1 */

                        @Override // android.support.v7.widget.RecyclerView.l
                        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                            AppMethodBeat.i(163765);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(recyclerView);
                            bVar.pH(i2);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                            super.onScrollStateChanged(recyclerView, i2);
                            Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "on scroll changed: %s", Integer.valueOf(i2));
                            if (i2 == 0) {
                                if (!LuckyMoneyPickEnvelopeUI.this.zgT && LuckyMoneyPickEnvelopeUI.this.zgF >= 0) {
                                    h.INSTANCE.a(19272, 1, LuckyMoneyPickEnvelopeUI.this.zgP, ((d) LuckyMoneyPickEnvelopeUI.this.zgE.get(LuckyMoneyPickEnvelopeUI.this.zgF)).yXW.Lot);
                                    LuckyMoneyPickEnvelopeUI.this.zgT = true;
                                }
                                if (LuckyMoneyPickEnvelopeUI.this.zgF >= 0) {
                                    d dVar = (d) LuckyMoneyPickEnvelopeUI.this.zgE.get(LuckyMoneyPickEnvelopeUI.this.zgF);
                                    if (dVar.yXW.iwy == 3) {
                                        h.INSTANCE.a(22104, dVar.yXW.Lot, 2);
                                    }
                                }
                                LuckyMoneyPickEnvelopeUI.v(LuckyMoneyPickEnvelopeUI.this);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                            AppMethodBeat.o(163765);
                        }

                        @Override // android.support.v7.widget.RecyclerView.l
                        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                            AppMethodBeat.i(163766);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(recyclerView);
                            bVar.pH(i2);
                            bVar.pH(i3);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                            super.onScrolled(recyclerView, i2, i3);
                            int ku = LuckyMoneyPickEnvelopeUI.this.zgD.ku();
                            Log.v("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll last vispos: %s", Integer.valueOf(ku));
                            if (!LuckyMoneyPickEnvelopeUI.this.isLoading && LuckyMoneyPickEnvelopeUI.this.yQF == 1 && ku == LuckyMoneyPickEnvelopeUI.this.zgC.getItemCount() - 1) {
                                Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "trigger load more: %s", Integer.valueOf(ku));
                                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, false);
                            }
                            com.tencent.mm.plugin.luckymoney.scaledLayout.a unused = LuckyMoneyPickEnvelopeUI.this.zgJ;
                            View h2 = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.this.zgD);
                            LuckyMoneyEnvelopeTouchRecyclerView unused2 = LuckyMoneyPickEnvelopeUI.this.zgB;
                            int bw = LuckyMoneyEnvelopeTouchRecyclerView.bw(h2);
                            LuckyMoneyPickEnvelopeUI.egA();
                            if (bw != LuckyMoneyPickEnvelopeUI.this.zgF && bw >= 0 && bw < LuckyMoneyPickEnvelopeUI.this.zgE.size()) {
                                d dVar = (d) LuckyMoneyPickEnvelopeUI.this.zgE.get(bw);
                                if (dVar.yXW != null && (dVar.yXW.MgE == 1 || dVar.yXW.KTQ == 1)) {
                                    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "expired: %s", Integer.valueOf(bw));
                                    if (LuckyMoneyPickEnvelopeUI.this.zgF >= 0) {
                                        ((d) LuckyMoneyPickEnvelopeUI.this.zgE.get(LuckyMoneyPickEnvelopeUI.this.zgF)).pWp = false;
                                        LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.this.zgF, false);
                                        LuckyMoneyPickEnvelopeUI.this.zgF = -1;
                                    }
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                                    AppMethodBeat.o(163766);
                                    return;
                                } else if (dVar.UYC) {
                                    LuckyMoneyPickEnvelopeUI.this.zgF = -2;
                                } else if (!dVar.pWp) {
                                    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do select pos: %s", Integer.valueOf(bw));
                                    if (LuckyMoneyPickEnvelopeUI.this.zgF >= 0) {
                                        ((d) LuckyMoneyPickEnvelopeUI.this.zgE.get(LuckyMoneyPickEnvelopeUI.this.zgF)).pWp = false;
                                        LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.this.zgF, false);
                                    }
                                    dVar.pWp = true;
                                    LuckyMoneyPickEnvelopeUI.this.zgF = bw;
                                    LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.this.zgF, true);
                                } else {
                                    dVar.pWp = false;
                                    LuckyMoneyPickEnvelopeUI.this.zgF = -1;
                                }
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                            AppMethodBeat.o(163766);
                        }
                    };
                } else {
                    LuckyMoneyPickEnvelopeUI.this.zgB.b(LuckyMoneyPickEnvelopeUI.this.zgM);
                }
                LuckyMoneyPickEnvelopeUI.this.zgB.a(LuckyMoneyPickEnvelopeUI.this.zgM);
                AppMethodBeat.o(163767);
            }
        });
        AppMethodBeat.o(163791);
    }

    private void egx() {
        AppMethodBeat.i(213460);
        if (this.zgF == -1) {
            this.zgK.setEnabled(false);
        } else if (this.zgF == -2) {
            if (!this.UYw) {
                h.INSTANCE.a(22302, 2);
                this.UYw = true;
            }
            this.zgK.setVisibility(4);
            AppMethodBeat.o(213460);
            return;
        } else if (hWl()) {
            this.zgK.setVisibility(4);
            AppMethodBeat.o(213460);
            return;
        } else {
            this.zgK.setEnabled(true);
            if (egy()) {
                this.zgK.setText(R.string.eot);
                this.zgK.setVisibility(0);
                AppMethodBeat.o(213460);
            }
        }
        this.zgK.setText(R.string.ep4);
        this.zgK.setVisibility(0);
        AppMethodBeat.o(213460);
    }

    private boolean hWl() {
        AppMethodBeat.i(258718);
        if (this.zgF < 0 || this.zgF >= this.zgE.size()) {
            AppMethodBeat.o(258718);
            return false;
        }
        d dVar = this.zgE.get(this.zgF);
        if (!dVar.pWp || dVar.yXW == null || dVar.yXW.iwy != 4) {
            AppMethodBeat.o(258718);
            return false;
        }
        AppMethodBeat.o(258718);
        return true;
    }

    private boolean egy() {
        AppMethodBeat.i(213461);
        if (this.zgF < 0 || this.zgF >= this.zgE.size()) {
            AppMethodBeat.o(213461);
            return false;
        }
        d dVar = this.zgE.get(this.zgF);
        if (!dVar.pWp || dVar.yXW == null || dVar.yXW.iwy != 3) {
            AppMethodBeat.o(213461);
            return false;
        }
        AppMethodBeat.o(213461);
        return true;
    }

    /* access modifiers changed from: package-private */
    public class c extends RecyclerView.a<a> {
        private c() {
        }

        /* synthetic */ c(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(a aVar, int i2) {
            AppMethodBeat.i(65805);
            aVar.a((d) LuckyMoneyPickEnvelopeUI.this.zgE.get(i2));
            AppMethodBeat.o(65805);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(65803);
            int size = LuckyMoneyPickEnvelopeUI.this.zgE.size();
            AppMethodBeat.o(65803);
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final long getItemId(int i2) {
            AppMethodBeat.i(65804);
            long hashCode = (long) ((d) LuckyMoneyPickEnvelopeUI.this.zgE.get(i2)).hashCode();
            AppMethodBeat.o(65804);
            return hashCode;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(213445);
            d dVar = (d) LuckyMoneyPickEnvelopeUI.this.zgE.get(i2);
            if (dVar.UYC) {
                AppMethodBeat.o(213445);
                return 3;
            } else if (dVar.yXW.iwy == 3) {
                AppMethodBeat.o(213445);
                return 2;
            } else if (dVar.yXW.iwy == 4) {
                AppMethodBeat.o(213445);
                return 4;
            } else {
                AppMethodBeat.o(213445);
                return 1;
            }
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(65806);
            if (i2 == 1) {
                e eVar = new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.b48, viewGroup, false));
                AppMethodBeat.o(65806);
                return eVar;
            } else if (i2 == 2) {
                b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.b47, viewGroup, false));
                AppMethodBeat.o(65806);
                return bVar;
            } else if (i2 == 3) {
                h.INSTANCE.a(22302, 1);
                g gVar = new g(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cg2, viewGroup, false));
                AppMethodBeat.o(65806);
                return gVar;
            } else if (i2 == 4) {
                f fVar = new f(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cfy, viewGroup, false));
                AppMethodBeat.o(65806);
                return fVar;
            } else {
                Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "wrong type: %s", Integer.valueOf(i2));
                AppMethodBeat.o(65806);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class a extends RecyclerView.v {
        public abstract void a(d dVar);

        public abstract void qQ(boolean z);

        public a(View view) {
            super(view);
        }
    }

    class e extends a {
        TextView gxs;
        ImageView gyr;
        TextView pIN;
        Button thI;
        ImageView zhf;
        View zhg;
        ImageView zhh;
        ProgressBar zhi;
        TextView zhj;
        TextView zhk;
        TextView zhl;
        ViewGroup zhm;
        ProgressBar zhn;

        static /* synthetic */ void a(e eVar, cbe cbe) {
            AppMethodBeat.i(213458);
            eVar.a(cbe, true);
            AppMethodBeat.o(213458);
        }

        public e(View view) {
            super(view);
            AppMethodBeat.i(213452);
            this.zhm = (ViewGroup) view.findViewById(R.id.eo9);
            this.zhf = (ImageView) view.findViewById(R.id.eod);
            this.gxs = (TextView) view.findViewById(R.id.eog);
            this.gyr = (ImageView) view.findViewById(R.id.eo8);
            this.pIN = (TextView) view.findViewById(R.id.eon);
            this.zhg = view.findViewById(R.id.eoq);
            this.zhh = (ImageView) view.findViewById(R.id.eom);
            this.zhi = (ProgressBar) view.findViewById(R.id.eo7);
            this.zhj = (TextView) view.findViewById(R.id.eoo);
            this.zhk = (TextView) view.findViewById(R.id.eoe);
            this.zhl = (TextView) view.findViewById(R.id.eop);
            this.thI = (Button) view.findViewById(R.id.eoh);
            String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
            if (loadApplicationLanguage == null || loadApplicationLanguage.length() <= 0 || (!loadApplicationLanguage.equals(LocaleUtil.CHINA) && !loadApplicationLanguage.equals(LocaleUtil.TAIWAN) && !loadApplicationLanguage.equals(LocaleUtil.HONGKONG))) {
                this.thI.setBackgroundResource(R.drawable.ckc);
                this.thI.setText(R.string.er0);
            }
            this.zhn = (ProgressBar) view.findViewById(R.id.eol);
            if (ao.isDarkMode()) {
                this.zhm.setBackgroundResource(R.drawable.afp);
            } else {
                this.zhm.setBackgroundResource(R.drawable.afn);
            }
            AnonymousClass1 r0 = new View.OnLongClickListener(LuckyMoneyPickEnvelopeUI.this) {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.e.AnonymousClass1 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(213446);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$NormalVH$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    e.a(e.this, view);
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$NormalVH$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(213446);
                    return false;
                }
            };
            view.setOnLongClickListener(r0);
            this.zhg.setOnLongClickListener(r0);
            AppMethodBeat.o(213452);
        }

        @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.a
        public final void qQ(boolean z) {
            AppMethodBeat.i(213453);
            this.aus.setSelected(z);
            AppMethodBeat.o(213453);
        }

        @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.a
        public final void a(final d dVar) {
            AppMethodBeat.i(213454);
            this.aus.setSelected(dVar.pWp);
            a.b.a(this.gyr, z.aTY(), 0.06f, false);
            this.pIN.setText(LuckyMoneyPickEnvelopeUI.this.getString(R.string.eso, new Object[]{l.e((Context) LuckyMoneyPickEnvelopeUI.this.getContext(), (CharSequence) z.aUa(), com.tencent.mm.cb.a.aG(LuckyMoneyPickEnvelopeUI.this.getContext(), R.dimen.ka))}));
            this.zhf.setImageBitmap(null);
            this.zhg.setVisibility(8);
            if (dVar.yXW != null) {
                this.gxs.setText(dVar.yXW.MgB);
                if (dVar.yXW.MgC != null) {
                    a(dVar.yXW, false);
                }
                this.zhg.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.e.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(213447);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$NormalVH$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        e.a(e.this, dVar.yXW);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$NormalVH$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213447);
                    }
                });
                if (!Util.isNullOrNil(dVar.yXW.MgD)) {
                    this.zhk.setText(dVar.yXW.MgD);
                    this.zhk.setVisibility(0);
                } else {
                    this.zhk.setText("");
                }
                this.zhk.setOnTouchListener(null);
                this.zhk.setClickable(false);
                if (dVar.yXW.iwy == 2) {
                    this.zhl.setVisibility(0);
                } else {
                    this.zhl.setVisibility(8);
                }
                if (dVar.yXW.iwy == 1 && !Util.isNullOrNil(dVar.yXW.MgI)) {
                    this.zhk.setVisibility(0);
                    this.zhk.setText(dVar.yXW.MgI);
                    AppMethodBeat.o(213454);
                    return;
                } else if (dVar.yXW.KTQ == 1) {
                    this.aus.setSelected(false);
                    this.zhm.setEnabled(false);
                    this.zhk.setVisibility(0);
                    if (!Util.isNullOrNil(dVar.yXW.MgH)) {
                        this.zhk.setText(dVar.yXW.MgH);
                    }
                    egB();
                    AppMethodBeat.o(213454);
                    return;
                } else if (dVar.yXW.MgE == 1) {
                    this.aus.setSelected(false);
                    this.zhm.setEnabled(false);
                    if (!Util.isNullOrNil(dVar.yXW.MgD)) {
                        this.zhk.setText(dVar.yXW.MgD);
                        this.zhk.setVisibility(0);
                    }
                    this.zhg.setVisibility(8);
                    this.zhh.setVisibility(8);
                    this.zhi.setVisibility(8);
                    this.zhj.setVisibility(8);
                    this.zhg.setOnClickListener(null);
                    AppMethodBeat.o(213454);
                    return;
                } else if (LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this, dVar.yXW.Lot)) {
                    this.aus.setSelected(false);
                    this.zhm.setEnabled(false);
                    this.zhk.setText(R.string.eos);
                    this.zhk.setVisibility(0);
                    egB();
                    AppMethodBeat.o(213454);
                    return;
                } else {
                    this.zhm.setEnabled(true);
                    if (Util.isNullOrNil(this.zhk.getText())) {
                        this.zhk.setVisibility(4);
                    }
                    this.zhg.setVisibility(8);
                }
            }
            AppMethodBeat.o(213454);
        }

        private void egB() {
            AppMethodBeat.i(213455);
            this.zhg.setVisibility(0);
            this.zhh.setVisibility(8);
            this.zhi.setVisibility(8);
            this.zhj.setVisibility(8);
            this.zhg.setOnClickListener(null);
            AppMethodBeat.o(213455);
        }

        private void a(final cbe cbe, boolean z) {
            AppMethodBeat.i(213456);
            if (z) {
                this.zhh.setVisibility(8);
                this.zhi.setVisibility(0);
                this.zhj.setVisibility(8);
            } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(cbe.Lot)) {
                Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "default envelope");
                AppMethodBeat.o(213456);
                return;
            } else {
                this.zhn.setVisibility(0);
            }
            ((com.tencent.mm.plugin.luckymoney.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.zhf, cbe, new a.AbstractC1465a() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.e.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.luckymoney.a.a.AbstractC1465a
                public final void ei(final boolean z) {
                    AppMethodBeat.i(213451);
                    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "load ok: %s", Boolean.valueOf(z));
                    AnonymousClass1 r0 = new Runnable() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.e.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(213450);
                            e.this.zhn.setVisibility(8);
                            if (LuckyMoneyPickEnvelopeUI.this.tipDialog != null && LuckyMoneyPickEnvelopeUI.this.tipDialog.isShowing()) {
                                LuckyMoneyPickEnvelopeUI.this.tipDialog.dismiss();
                            }
                            if (cbe.MgE == 1 || cbe.KTQ == 1) {
                                Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "envelope has expired do nothing");
                                AppMethodBeat.o(213450);
                            } else if (!z) {
                                e.this.zhg.setVisibility(0);
                                e.this.zhh.setVisibility(0);
                                e.this.zhi.setVisibility(8);
                                e.this.zhj.setVisibility(0);
                                AppMethodBeat.o(213450);
                            } else {
                                e.this.zhg.setVisibility(8);
                                AppMethodBeat.o(213450);
                            }
                        }
                    };
                    if (MMHandlerThread.isMainThread()) {
                        r0.run();
                        AppMethodBeat.o(213451);
                        return;
                    }
                    e.this.zhg.post(r0);
                    AppMethodBeat.o(213451);
                }
            });
            AppMethodBeat.o(213456);
        }

        static /* synthetic */ void a(e eVar, View view) {
            AppMethodBeat.i(213457);
            if (LuckyMoneyPickEnvelopeUI.this.zgH) {
                View findContainingItemView = LuckyMoneyPickEnvelopeUI.this.zgB.findContainingItemView(view);
                LuckyMoneyEnvelopeTouchRecyclerView unused = LuckyMoneyPickEnvelopeUI.this.zgB;
                int bw = LuckyMoneyEnvelopeTouchRecyclerView.bw(findContainingItemView);
                com.tencent.mm.plugin.luckymoney.scaledLayout.a unused2 = LuckyMoneyPickEnvelopeUI.this.zgJ;
                View h2 = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.this.zgD);
                if (bw >= 0 && bw < LuckyMoneyPickEnvelopeUI.this.zgE.size() && findContainingItemView == h2) {
                    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "delete pos: %s", Integer.valueOf(bw));
                    final d dVar = (d) LuckyMoneyPickEnvelopeUI.this.zgE.get(bw);
                    if (!(dVar == null || dVar.yXW == null)) {
                        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(dVar.yXW.Lot)) {
                            Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "can not delete default envelope");
                            AppMethodBeat.o(213457);
                            return;
                        }
                        com.tencent.mm.ui.widget.a.e eVar2 = new com.tencent.mm.ui.widget.a.e((Context) LuckyMoneyPickEnvelopeUI.this.getContext(), 1, true);
                        TextView textView = new TextView(LuckyMoneyPickEnvelopeUI.this.getContext());
                        textView.setPadding(0, 0, 0, com.tencent.mm.cb.a.fromDPToPix((Context) LuckyMoneyPickEnvelopeUI.this.getContext(), 9));
                        textView.setMinHeight(com.tencent.mm.cb.a.aG(LuckyMoneyPickEnvelopeUI.this.getContext(), R.dimen.x));
                        textView.setTextSize(14.0f);
                        textView.setTextColor(LuckyMoneyPickEnvelopeUI.this.getResources().getColor(R.color.u_));
                        textView.setText(R.string.er6);
                        textView.setGravity(81);
                        eVar2.V(textView, true);
                        eVar2.HLX = new o.f() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.e.AnonymousClass3 */

                            @Override // com.tencent.mm.ui.base.o.f
                            public final void onCreateMMMenu(m mVar) {
                                AppMethodBeat.i(213448);
                                mVar.a(0, LuckyMoneyPickEnvelopeUI.this.getResources().getColor(R.color.Red), LuckyMoneyPickEnvelopeUI.this.getString(R.string.er5));
                                AppMethodBeat.o(213448);
                            }
                        };
                        eVar2.HLY = new o.g() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.e.AnonymousClass4 */

                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                AppMethodBeat.i(213449);
                                if (menuItem.getItemId() == 0) {
                                    LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this, dVar.yXW.Lot);
                                }
                                AppMethodBeat.o(213449);
                            }
                        };
                        eVar2.dGm();
                    }
                }
            }
            AppMethodBeat.o(213457);
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends a {
        TextView gxs;
        ImageView gyr;
        TextView pIN;
        Button thI;
        ImageView zhf;
        View zhg;
        ImageView zhh;
        ProgressBar zhi;
        TextView zhj;
        TextView zhk;
        TextView zhl;
        ViewGroup zhm;
        ProgressBar zhn;
        ImageView zho;
        ViewGroup zhp;
        TextView zhq;
        TextView zhr;

        static /* synthetic */ void a(b bVar, cbe cbe) {
            AppMethodBeat.i(213444);
            bVar.a(cbe, true);
            AppMethodBeat.o(213444);
        }

        public b(View view) {
            super(view);
            AppMethodBeat.i(213441);
            this.zhm = (ViewGroup) view.findViewById(R.id.eo9);
            this.zhf = (ImageView) view.findViewById(R.id.eod);
            this.gxs = (TextView) view.findViewById(R.id.eog);
            this.gyr = (ImageView) view.findViewById(R.id.eo8);
            this.pIN = (TextView) view.findViewById(R.id.eon);
            this.zhg = view.findViewById(R.id.eoq);
            this.zhh = (ImageView) view.findViewById(R.id.eom);
            this.zhi = (ProgressBar) view.findViewById(R.id.eo7);
            this.zhj = (TextView) view.findViewById(R.id.eoo);
            this.zhk = (TextView) view.findViewById(R.id.eoe);
            this.zhl = (TextView) view.findViewById(R.id.eop);
            this.thI = (Button) view.findViewById(R.id.eoh);
            this.zho = (ImageView) view.findViewById(R.id.eob);
            this.zhp = (ViewGroup) view.findViewById(R.id.eoi);
            this.zhq = (TextView) view.findViewById(R.id.eoc);
            this.zhr = (TextView) view.findViewById(R.id.eoa);
            com.tencent.mm.wallet_core.ui.f.G(this.zhq);
            com.tencent.mm.wallet_core.ui.f.G(this.zhr);
            String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
            if (loadApplicationLanguage == null || loadApplicationLanguage.length() <= 0 || (!loadApplicationLanguage.equals(LocaleUtil.CHINA) && !loadApplicationLanguage.equals(LocaleUtil.TAIWAN) && !loadApplicationLanguage.equals(LocaleUtil.HONGKONG))) {
                this.thI.setBackgroundResource(R.drawable.ckc);
                this.thI.setText(R.string.er0);
            }
            this.zhn = (ProgressBar) view.findViewById(R.id.eol);
            if (ao.isDarkMode()) {
                this.zhm.setBackgroundResource(R.drawable.afp);
            } else {
                this.zhm.setBackgroundResource(R.drawable.afn);
            }
            this.zhm.setEnabled(false);
            AppMethodBeat.o(213441);
        }

        @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.a
        public final void a(final d dVar) {
            AppMethodBeat.i(213442);
            this.aus.setSelected(dVar.pWp);
            a.b.a(this.gyr, z.aTY(), 0.06f, false);
            this.pIN.setText(LuckyMoneyPickEnvelopeUI.this.getString(R.string.eso, new Object[]{l.e((Context) LuckyMoneyPickEnvelopeUI.this.getContext(), (CharSequence) z.aUa(), com.tencent.mm.cb.a.aG(LuckyMoneyPickEnvelopeUI.this.getContext(), R.dimen.ka))}));
            this.zhf.setImageBitmap(null);
            this.zhg.setVisibility(8);
            if (dVar.yXW != null) {
                this.gxs.setText(dVar.yXW.MgB);
                this.zhq.setText(dVar.yXW.MgB);
                if (dVar.yXW.MgC != null) {
                    a(dVar.yXW, false);
                }
                this.zhg.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.b.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(213438);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$BizVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        b.a(b.this, dVar.yXW);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$BizVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213438);
                    }
                });
                if (!Util.isNullOrNil(dVar.yXW.MgD)) {
                    this.zhk.setText(dVar.yXW.MgD);
                    this.zhk.setVisibility(0);
                } else {
                    this.zhk.setText("");
                }
                if (this.zhr != null) {
                    this.zhr.setText(dVar.yXW.MgR);
                }
                this.zhg.setVisibility(8);
            }
            AppMethodBeat.o(213442);
        }

        @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.a
        public final void qQ(boolean z) {
        }

        private void a(final cbe cbe, boolean z) {
            AppMethodBeat.i(213443);
            if (z) {
                this.zhh.setVisibility(8);
                this.zhi.setVisibility(0);
                this.zhj.setVisibility(8);
            } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(cbe.Lot)) {
                Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "default envelope");
                AppMethodBeat.o(213443);
                return;
            } else {
                this.zhn.setVisibility(0);
            }
            ((com.tencent.mm.plugin.luckymoney.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.zhf, cbe, new a.AbstractC1465a() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.b.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.luckymoney.a.a.AbstractC1465a
                public final void ei(final boolean z) {
                    AppMethodBeat.i(213440);
                    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "load ok: %s", Boolean.valueOf(z));
                    AnonymousClass1 r0 = new Runnable() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.b.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(213439);
                            b.this.zhn.setVisibility(8);
                            if (LuckyMoneyPickEnvelopeUI.this.tipDialog != null && LuckyMoneyPickEnvelopeUI.this.tipDialog.isShowing()) {
                                LuckyMoneyPickEnvelopeUI.this.tipDialog.dismiss();
                            }
                            if (cbe.MgE == 1 || cbe.KTQ == 1) {
                                Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "envelope has expired do nothing");
                                AppMethodBeat.o(213439);
                            } else if (!z) {
                                b.this.zhg.setVisibility(0);
                                b.this.zhh.setVisibility(0);
                                b.this.zhi.setVisibility(8);
                                b.this.zhj.setVisibility(0);
                                AppMethodBeat.o(213439);
                            } else {
                                b.this.zhg.setVisibility(8);
                                AppMethodBeat.o(213439);
                            }
                        }
                    };
                    if (MMHandlerThread.isMainThread()) {
                        r0.run();
                        AppMethodBeat.o(213440);
                        return;
                    }
                    b.this.zhg.post(r0);
                    AppMethodBeat.o(213440);
                }
            });
            AppMethodBeat.o(213443);
        }
    }

    class g extends a {
        public g(View view) {
            super(view);
            AppMethodBeat.i(258717);
            view.setOnClickListener(new View.OnClickListener(LuckyMoneyPickEnvelopeUI.this) {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.g.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(258716);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$HistoryEnvelopeEntranceVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    h.INSTANCE.a(22302, 3);
                    Intent intent = new Intent(LuckyMoneyPickEnvelopeUI.this.getContext(), WalletPayUPwdConfirmUI.class);
                    LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI = LuckyMoneyPickEnvelopeUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyPickEnvelopeUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$HistoryEnvelopeEntranceVH$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    luckyMoneyPickEnvelopeUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyPickEnvelopeUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$HistoryEnvelopeEntranceVH$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$HistoryEnvelopeEntranceVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(258716);
                }
            });
            AppMethodBeat.o(258717);
        }

        @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.a
        public final void a(d dVar) {
        }

        @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.a
        public final void qQ(boolean z) {
        }
    }

    class f extends a {
        ViewGroup UYA;
        TextView UYx;
        TextView UYy;
        WeImageView UYz;

        public f(View view) {
            super(view);
            AppMethodBeat.i(258714);
            this.UYx = (TextView) view.findViewById(R.id.k0i);
            this.UYy = (TextView) view.findViewById(R.id.k0h);
            this.UYz = (WeImageView) view.findViewById(R.id.k0j);
            this.UYA = (ViewGroup) view.findViewById(R.id.k0k);
            AppMethodBeat.o(258714);
        }

        @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.a
        public final void a(final d dVar) {
            AppMethodBeat.i(258715);
            this.aus.setSelected(dVar.pWp);
            if (dVar.yXW != null) {
                this.UYx.setText(dVar.yXW.MgM);
                this.UYy.setText(dVar.yXW.MgN);
                ao.a(this.UYx.getPaint(), 0.8f);
                ao.a(this.UYy.getPaint(), 0.8f);
                this.UYA.setClickable(true);
                this.UYA.setOnTouchListener(new View.OnTouchListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.f.AnonymousClass1 */

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(258713);
                        if (motionEvent.getAction() == 0) {
                            f.this.UYz.setIconColor(LuckyMoneyPickEnvelopeUI.this.getContext().getResources().getColor(R.color.aa));
                            f.this.UYx.setTextColor(LuckyMoneyPickEnvelopeUI.this.getContext().getResources().getColor(R.color.aa));
                        } else {
                            f.this.UYz.setIconColor(LuckyMoneyPickEnvelopeUI.this.getContext().getResources().getColor(R.color.yj));
                            f.this.UYx.setTextColor(LuckyMoneyPickEnvelopeUI.this.getContext().getResources().getColor(R.color.yj));
                            Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "on click ");
                            com.tencent.mm.wallet_core.ui.f.u(dVar.yXW.MgK, dVar.yXW.MgL, 0, 1100);
                        }
                        AppMethodBeat.o(258713);
                        return false;
                    }
                });
            }
            AppMethodBeat.o(258715);
        }

        @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.a
        public final void qQ(boolean z) {
        }
    }

    /* access modifiers changed from: package-private */
    public static class d {
        public boolean UYC;
        public boolean pWp;
        public cbe yXW;

        private d() {
            this.pWp = false;
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    static /* synthetic */ void a(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, final String str, String str2, final int i2) {
        AppMethodBeat.i(213462);
        Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do doCheckAndUseTimeLimitPromo: %s", str);
        luckyMoneyPickEnvelopeUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) luckyMoneyPickEnvelopeUI.getContext(), 3, (int) R.style.lj, luckyMoneyPickEnvelopeUI.getString(R.string.eoo), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        new com.tencent.mm.plugin.luckymoney.model.a(str, str2).aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<xm>>() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<xm> aVar) {
                AppMethodBeat.i(163769);
                Object f2 = f(aVar);
                AppMethodBeat.o(163769);
                return f2;
            }

            private Object f(c.a<xm> aVar) {
                AppMethodBeat.i(182475);
                Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do doCheckAndUseTimeLimitPromo errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                if (LuckyMoneyPickEnvelopeUI.this.tipDialog != null) {
                    LuckyMoneyPickEnvelopeUI.this.tipDialog.dismiss();
                }
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "retcode: %s", Integer.valueOf(((xm) aVar.iLC).dDN));
                    if (aVar.iLC != null && ((xm) aVar.iLC).dDN == 0) {
                        Intent intent = new Intent();
                        cbe c2 = LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this, str);
                        if (c2 != null) {
                            try {
                                intent.putExtra(e.i.Ozd, c2.toByteArray());
                            } catch (IOException e2) {
                                Log.printErrStackTrace("MicroMsg.LuckyMoneyPickEnvelopeUI", e2, "", new Object[0]);
                            }
                            LuckyMoneyPickEnvelopeUI.this.setResult(-1, intent);
                            if (c2.iwy == 3) {
                                LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this, i2);
                            }
                        }
                    } else if (aVar.iLC != null && !Util.isNullOrNil(((xm) aVar.iLC).qwn)) {
                        com.tencent.mm.wallet_core.ui.f.cP(LuckyMoneyPickEnvelopeUI.this.getContext(), ((xm) aVar.iLC).qwn);
                    }
                } else {
                    com.tencent.mm.wallet_core.ui.f.ar(LuckyMoneyPickEnvelopeUI.this.getContext(), aVar.errMsg);
                }
                AppMethodBeat.o(182475);
                return null;
            }
        }).a(luckyMoneyPickEnvelopeUI);
        AppMethodBeat.o(213462);
    }

    static /* synthetic */ void a(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, final String str) {
        AppMethodBeat.i(213463);
        Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do confirm source: %s", str);
        luckyMoneyPickEnvelopeUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) luckyMoneyPickEnvelopeUI.getContext(), 3, (int) R.style.lj, luckyMoneyPickEnvelopeUI.getString(R.string.ekc), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass6 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        new com.tencent.mm.plugin.luckymoney.model.b(str).aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<adg>>() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass7 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<adg> aVar) {
                AppMethodBeat.i(213434);
                Object f2 = f(aVar);
                AppMethodBeat.o(213434);
                return f2;
            }

            private Object f(c.a<adg> aVar) {
                AppMethodBeat.i(213433);
                Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do confirm errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                if (LuckyMoneyPickEnvelopeUI.this.tipDialog != null) {
                    LuckyMoneyPickEnvelopeUI.this.tipDialog.dismiss();
                }
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "retcode: %s", Integer.valueOf(((adg) aVar.iLC).dDN));
                    if (aVar.iLC != null && ((adg) aVar.iLC).dDN == 0) {
                        Intent intent = new Intent();
                        cbe c2 = LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this, str);
                        if (c2 != null) {
                            try {
                                intent.putExtra(e.i.Ozd, c2.toByteArray());
                            } catch (IOException e2) {
                                Log.printErrStackTrace("MicroMsg.LuckyMoneyPickEnvelopeUI", e2, "", new Object[0]);
                            }
                        }
                        LuckyMoneyPickEnvelopeUI.this.setResult(-1, intent);
                        if (!Util.isNullOrNil(LuckyMoneyPickEnvelopeUI.this.zgQ)) {
                            com.tencent.mm.ui.widget.snackbar.b.a(LuckyMoneyPickEnvelopeUI.this.getContext(), LuckyMoneyPickEnvelopeUI.this.findViewById(R.id.ffv), LuckyMoneyPickEnvelopeUI.this.getContext().getString(R.string.eor), new a.c() {
                                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass7.AnonymousClass1 */

                                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                                public final void onShow() {
                                }

                                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                                public final void onHide() {
                                    AppMethodBeat.i(213432);
                                    LuckyMoneyPickEnvelopeUI.this.finish();
                                    AppMethodBeat.o(213432);
                                }

                                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                                public final void bDY() {
                                }
                            });
                        } else {
                            LuckyMoneyPickEnvelopeUI.this.finish();
                        }
                    } else if (aVar.iLC != null && !Util.isNullOrNil(((adg) aVar.iLC).qwn)) {
                        com.tencent.mm.wallet_core.ui.f.cP(LuckyMoneyPickEnvelopeUI.this.getContext(), ((adg) aVar.iLC).qwn);
                    }
                } else {
                    com.tencent.mm.wallet_core.ui.f.ar(LuckyMoneyPickEnvelopeUI.this.getContext(), aVar.errMsg);
                }
                AppMethodBeat.o(213433);
                return null;
            }
        });
        AppMethodBeat.o(213463);
    }

    static /* synthetic */ void a(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, int i2, boolean z) {
        AppMethodBeat.i(213468);
        a aVar = (a) luckyMoneyPickEnvelopeUI.zgB.ch(i2);
        if (aVar != null) {
            aVar.qQ(z);
        }
        AppMethodBeat.o(213468);
    }

    static /* synthetic */ cbe c(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, String str) {
        AppMethodBeat.i(213469);
        for (d dVar : luckyMoneyPickEnvelopeUI.zgE) {
            if (dVar.yXW.Lot.equals(str)) {
                cbe cbe = dVar.yXW;
                AppMethodBeat.o(213469);
                return cbe;
            }
        }
        AppMethodBeat.o(213469);
        return null;
    }

    static /* synthetic */ void c(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, int i2) {
        AppMethodBeat.i(213470);
        final b bVar = (b) luckyMoneyPickEnvelopeUI.zgB.ch(i2);
        Bitmap createBitmap = Bitmap.createBitmap(bVar.zho.getWidth(), bVar.zho.getHeight(), Bitmap.Config.ARGB_8888);
        bVar.zhp.draw(new Canvas(createBitmap));
        bVar.zho.setImageBitmap(createBitmap);
        bVar.zho.setVisibility(0);
        bVar.zhp.setVisibility(4);
        TransitionSet transitionSet = (TransitionSet) q.O(luckyMoneyPickEnvelopeUI.getContext()).dQ();
        transitionSet.a(new Transition.d() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass5 */

            @Override // android.support.transition.Transition.d
            public final void dK() {
                AppMethodBeat.i(213430);
                bVar.aus.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(213428);
                        if (ao.isDarkMode()) {
                            bVar.zhm.setBackgroundResource(R.drawable.afp);
                        } else {
                            bVar.zhm.setBackgroundResource(R.drawable.afn);
                        }
                        bVar.zhm.setEnabled(true);
                        bVar.aus.setSelected(true);
                        AppMethodBeat.o(213428);
                    }
                }, 300);
                AppMethodBeat.o(213430);
            }

            @Override // android.support.transition.Transition.d
            public final void a(Transition transition) {
                AppMethodBeat.i(213431);
                Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "transition end");
                t.a(LuckyMoneyPickEnvelopeUI.this.getContext().getResources().getString(R.string.eor), LuckyMoneyPickEnvelopeUI.this.getContext(), 2, new DialogInterface.OnDismissListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass5.AnonymousClass2 */

                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(213429);
                        Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "dialog dismiss");
                        LuckyMoneyPickEnvelopeUI.this.finish();
                        AppMethodBeat.o(213429);
                    }
                });
                AppMethodBeat.o(213431);
            }

            @Override // android.support.transition.Transition.d
            public final void dF() {
            }

            @Override // android.support.transition.Transition.d
            public final void dG() {
            }
        });
        s.a((ViewGroup) luckyMoneyPickEnvelopeUI.zgB.ch(i2).aus, transitionSet);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) bVar.zho.getLayoutParams();
        marginLayoutParams.width = com.tencent.mm.cb.a.fromDPToPix((Context) luckyMoneyPickEnvelopeUI.getContext(), 256);
        marginLayoutParams.height = com.tencent.mm.cb.a.fromDPToPix((Context) luckyMoneyPickEnvelopeUI.getContext(), (int) v2helper.EMethodSetSpkEnhance);
        marginLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) luckyMoneyPickEnvelopeUI.getContext(), 12);
        bVar.zho.setLayoutParams(marginLayoutParams);
        bVar.aus.findViewById(R.id.eo_).setVisibility(4);
        bVar.zhq.setVisibility(8);
        bVar.zhr.setVisibility(8);
        bVar.aus.findViewById(R.id.eof).setVisibility(0);
        AppMethodBeat.o(213470);
    }

    static /* synthetic */ int d(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, String str) {
        int i2;
        AppMethodBeat.i(213471);
        int i3 = 0;
        Iterator<d> it = luckyMoneyPickEnvelopeUI.zgE.iterator();
        while (true) {
            i2 = i3;
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            d next = it.next();
            if (next.yXW.Lot.equals(str)) {
                luckyMoneyPickEnvelopeUI.zgE.remove(next);
                break;
            }
            i3 = i2 + 1;
        }
        AppMethodBeat.o(213471);
        return i2;
    }

    static /* synthetic */ void f(LuckyMoneyPickEnvelopeUI luckyMoneyPickEnvelopeUI, final String str) {
        AppMethodBeat.i(213473);
        Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do delete show source: %s", str);
        luckyMoneyPickEnvelopeUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) luckyMoneyPickEnvelopeUI.getContext(), 3, (int) R.style.lj, luckyMoneyPickEnvelopeUI.getString(R.string.ekc), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass8 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        new com.tencent.mm.plugin.luckymoney.model.c(str).aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<adg>>() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass9 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<adg> aVar) {
                AppMethodBeat.i(213436);
                c.a<adg> aVar2 = aVar;
                Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do confirm errType: %s, errCode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                if (LuckyMoneyPickEnvelopeUI.this.tipDialog != null) {
                    LuckyMoneyPickEnvelopeUI.this.tipDialog.dismiss();
                }
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "retcode: %s", Integer.valueOf(((adg) aVar2.iLC).dDN));
                    if (((adg) aVar2.iLC).dDN == 0) {
                        int d2 = LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this, str);
                        if (LuckyMoneyPickEnvelopeUI.this.zgE.isEmpty()) {
                            LuckyMoneyPickEnvelopeUI.this.GQ.setVisibility(0);
                            LuckyMoneyPickEnvelopeUI.this.zgB.setVisibility(8);
                        }
                        if (d2 > 0) {
                            if (d2 == LuckyMoneyPickEnvelopeUI.this.zgE.size()) {
                                LuckyMoneyPickEnvelopeUI.this.zgC.ck(d2);
                                LuckyMoneyPickEnvelopeUI.this.zgF = -1;
                                if (LuckyMoneyPickEnvelopeUI.this.zgE.size() == 1) {
                                    LuckyMoneyEnvelopeTouchRecyclerView luckyMoneyEnvelopeTouchRecyclerView = LuckyMoneyPickEnvelopeUI.this.zgB;
                                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                                    com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyEnvelopeTouchRecyclerView, a2.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$17", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Ljava/lang/Object;", "Undefined", "scrollToPosition", "(I)V");
                                    luckyMoneyEnvelopeTouchRecyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                                    com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyEnvelopeTouchRecyclerView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$17", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Ljava/lang/Object;", "Undefined", "scrollToPosition", "(I)V");
                                    ((d) LuckyMoneyPickEnvelopeUI.this.zgE.get(0)).pWp = true;
                                    LuckyMoneyPickEnvelopeUI.this.zgF = 0;
                                    LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, 0, true);
                                } else {
                                    LuckyMoneyEnvelopeTouchRecyclerView luckyMoneyEnvelopeTouchRecyclerView2 = LuckyMoneyPickEnvelopeUI.this.zgB;
                                    com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(d2 - 1, new com.tencent.mm.hellhoundlib.b.a());
                                    com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyEnvelopeTouchRecyclerView2, a3.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$17", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Ljava/lang/Object;", "Undefined", "scrollToPosition", "(I)V");
                                    luckyMoneyEnvelopeTouchRecyclerView2.scrollToPosition(((Integer) a3.pG(0)).intValue());
                                    com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyEnvelopeTouchRecyclerView2, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$17", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Ljava/lang/Object;", "Undefined", "scrollToPosition", "(I)V");
                                }
                                LuckyMoneyPickEnvelopeUI.this.zgB.postDelayed(new Runnable() {
                                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.AnonymousClass9.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(213435);
                                        LuckyMoneyPickEnvelopeUI.v(LuckyMoneyPickEnvelopeUI.this);
                                        AppMethodBeat.o(213435);
                                    }
                                }, 100);
                            } else {
                                LuckyMoneyPickEnvelopeUI.this.zgC.ck(d2);
                                d dVar = (d) LuckyMoneyPickEnvelopeUI.this.zgE.get(d2);
                                boolean z = (dVar.yXW.MgE == 1 || dVar.yXW.KTQ == 1 || LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this, dVar.yXW.Lot)) ? false : true;
                                dVar.pWp = z;
                                if (z) {
                                    LuckyMoneyPickEnvelopeUI.this.zgF = d2;
                                } else {
                                    LuckyMoneyPickEnvelopeUI.this.zgF = -1;
                                }
                                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, d2, z);
                                LuckyMoneyPickEnvelopeUI.v(LuckyMoneyPickEnvelopeUI.this);
                            }
                        }
                    } else if (!Util.isNullOrNil(((adg) aVar2.iLC).qwn)) {
                        com.tencent.mm.wallet_core.ui.f.cP(LuckyMoneyPickEnvelopeUI.this.getContext(), ((adg) aVar2.iLC).qwn);
                    }
                } else {
                    com.tencent.mm.wallet_core.ui.f.ar(LuckyMoneyPickEnvelopeUI.this.getContext(), aVar2.errMsg);
                }
                AppMethodBeat.o(213436);
                return null;
            }
        });
        AppMethodBeat.o(213473);
    }
}
