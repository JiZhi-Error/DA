package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.hilive.mediasdk.SdkInfo;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.az;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.da;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.a.lc;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.a.of;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.g.a.zx;
import com.tencent.mm.g.b.a.ag;
import com.tencent.mm.kernel.i;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.jsapi.br;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.offline.a.j;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.a.q;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.g;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.offline.ui.OfflineAlertView;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.cul;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@i
public class WalletOfflineCoinPurseUI extends WalletBaseUI implements u.a, s.a, com.tencent.mm.plugin.offline.b, a, ScreenShotUtil.ScreenShotCallback {
    private static int oEI = 0;
    private String AII = "";
    private m AIK;
    private int AIM = 60000;
    private MTimerHandler AIN = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass36 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(213661);
            if (!WalletOfflineCoinPurseUI.this.ALB) {
                WalletOfflineCoinPurseUI.E(WalletOfflineCoinPurseUI.this);
                WalletOfflineCoinPurseUI.F(WalletOfflineCoinPurseUI.this);
            }
            WalletOfflineCoinPurseUI.this.AIN.startTimer((long) WalletOfflineCoinPurseUI.this.AIM);
            AppMethodBeat.o(213661);
            return false;
        }
    }, false);
    private String AIf = "";
    private IListener<lj> AJa = new IListener<lj>() {
        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass39 */

        {
            AppMethodBeat.i(213664);
            this.__eventId = lj.class.getName().hashCode();
            AppMethodBeat.o(213664);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lj ljVar) {
            AppMethodBeat.i(213665);
            lj ljVar2 = ljVar;
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "KindaBindCardEvent callback");
            if (ljVar2 == null || !(ljVar2 instanceof lj)) {
                AppMethodBeat.o(213665);
                return false;
            }
            z.hhs();
            if (ljVar2.dQz != null) {
                if (ljVar2.dQz.dQA) {
                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "KindaBindCardEvent bindCard Succ");
                    if (t.fQI().fRk()) {
                        WalletOfflineCoinPurseUI.this.doSceneForceProgress(new ad(null, 13));
                    } else {
                        WalletOfflineCoinPurseUI.this.doSceneForceProgress(new ad(null, 22));
                    }
                    WalletOfflineCoinPurseUI.this.ALV = true;
                    WalletOfflineCoinPurseUI.this.ALW = ljVar2.dQz.dQC;
                } else {
                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "KindaBindCardEvent bindCard Cancel");
                }
            }
            EventCenter.instance.removeListener(WalletOfflineCoinPurseUI.this.AJa);
            AppMethodBeat.o(213665);
            return true;
        }
    };
    private HashMap<String, View> AKR = new HashMap<>();
    private HashMap<String, Integer> AKS = new HashMap<>();
    Bitmap AKT = null;
    Bitmap AKU = null;
    private c AKV;
    private boolean AKW = false;
    private boolean AKX = false;
    private ArrayList<String> AKY = new ArrayList<>();
    private ArrayList<String> AKZ = new ArrayList<>();
    private String ALA = "";
    private boolean ALB = false;
    private com.tencent.mm.plugin.offline.g ALC;
    private boolean ALD = false;
    private boolean ALE = false;
    private boolean ALF = false;
    private boolean ALG = true;
    private boolean ALH = false;
    private int ALI = -1;
    private com.tencent.mm.plugin.wallet.ui.a ALJ;
    private int ALK = 1;
    private boolean ALM = false;
    private boolean ALN = false;
    private boolean ALO = false;
    private ArrayList<Bitmap> ALP = new ArrayList<>();
    private ArrayList<Bitmap> ALQ = new ArrayList<>();
    private com.tencent.mm.wallet_core.ui.c ALR;
    private c ALS;
    private OfflineAlertView ALT;
    private boolean ALU = false;
    private boolean ALV = false;
    private String ALW = null;
    private boolean ALX = false;
    private String ALY;
    private boolean ALZ = false;
    private ArrayList<Boolean> ALa = new ArrayList<>();
    private String ALb = "";
    private String ALc = "";
    private View ALd;
    private ImageView ALe;
    private ImageView ALf;
    private TextView ALg;
    private String ALh;
    private View ALi;
    private TextView ALj;
    private WeImageView ALk;
    private RelativeLayout ALl;
    private LinearLayout ALm;
    private CdnImageView ALn;
    private TextView ALo;
    private TextView ALp;
    private e ALq;
    private g ALr;
    private b ALs;
    private f ALt;
    private d ALu;
    private LinearLayout ALv;
    private LinearLayout ALw;
    private LinearLayout ALx;
    private LinearLayout ALy;
    private LinearLayout ALz;
    private int AMa;
    private boolean AMb = true;
    private r AMc;
    private boolean AMd = false;
    private boolean AMe = false;
    private lc AMf;
    IListener<aaa> AMg = new IListener<aaa>() {
        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160819);
            this.__eventId = aaa.class.getName().hashCode();
            AppMethodBeat.o(160819);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aaa aaa) {
            AppMethodBeat.i(66402);
            aaa aaa2 = aaa;
            if (aaa2.egJ.egL) {
                Log.f("MicroMsg.WalletOfflineCoinPurseUI", "WalletPayResultEvent is from kinda, ScanQRCodePay");
            } else {
                EventCenter.instance.removeListener(this);
                if (com.tencent.mm.plugin.offline.c.a.eAL() && aaa2.egJ.result == 0) {
                    WalletOfflineCoinPurseUI.this.ALB = false;
                }
            }
            AppMethodBeat.o(66402);
            return false;
        }
    };
    IListener<lc> AMh = new IListener<lc>() {
        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass12 */

        {
            AppMethodBeat.i(160820);
            this.__eventId = lc.class.getName().hashCode();
            AppMethodBeat.o(160820);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lc lcVar) {
            AppMethodBeat.i(66413);
            final lc lcVar2 = lcVar;
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "FQOpenResultCallBackEvent callback，appid：%s,event.data.nonceStr：%s，event.data.paySign：%s,event.data.signType:%s，event.data.bankType:%s，event.data.bindSerial:%s，event.data.openSuccess:%s", lcVar2.dQg.appId, lcVar2.dQg.nonceStr, lcVar2.dQg.dQk, lcVar2.dQg.signType, lcVar2.dQg.dQl, lcVar2.dQg.dQm, lcVar2.dQg.dQn);
            WalletOfflineCoinPurseUI.this.AMf = lcVar2;
            h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass12.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(213638);
                    WalletOfflineCoinPurseUI.this.doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.d(lcVar2.dQg.appId, lcVar2.dQg.timeStamp, lcVar2.dQg.nonceStr, lcVar2.dQg.dQj, lcVar2.dQg.signType, lcVar2.dQg.dQk, 23, lcVar2.dQg.appName, lcVar2.dQg.dQi, br.NAME, 1137));
                    AppMethodBeat.o(213638);
                }
            });
            AppMethodBeat.o(66413);
            return false;
        }
    };
    IListener<aaa> AMi = new IListener<aaa>() {
        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass23 */

        {
            AppMethodBeat.i(160821);
            this.__eventId = aaa.class.getName().hashCode();
            AppMethodBeat.o(160821);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aaa aaa) {
            Bundle extras;
            Bankcard l;
            AppMethodBeat.i(66424);
            aaa aaa2 = aaa;
            if (!(aaa2.egJ.intent == null || (extras = aaa2.egJ.intent.getExtras()) == null)) {
                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "kinda offline pay cashier callback, with data.");
                if (extras.getInt("payScene") == 8 && aaa2.egJ.result == -1) {
                    String string = extras.getString("pay_bind_serial");
                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "tempBindSerial:%s", string);
                    if (!Util.isNullOrNil(string) && (l = t.fQI().l(string, true, true)) != null) {
                        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mBindSerial:%s serial:%s", WalletOfflineCoinPurseUI.this.AIf, l.field_bindSerial);
                        if (!l.fQg() || WalletOfflineCoinPurseUI.eAd()) {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "set as default bankcard");
                            com.tencent.mm.plugin.offline.c.a.aJk(l.field_bindSerial);
                            k.ezn();
                            k.ezp().AIf = l.field_bindSerial;
                        } else {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do not set as default bankcard");
                        }
                    }
                    ip ipVar = new ip();
                    ipVar.dNj.dNk = "ok";
                    EventCenter.instance.publish(ipVar);
                    WalletOfflineCoinPurseUI.this.finish();
                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "kinda offline pay cashier callback, finish.");
                }
            }
            AppMethodBeat.o(66424);
            return false;
        }
    };
    private IListener<da> AMj = new IListener<da>() {
        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass34 */

        {
            AppMethodBeat.i(184865);
            this.__eventId = da.class.getName().hashCode();
            AppMethodBeat.o(184865);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(da daVar) {
            AppMethodBeat.i(184866);
            Log.d("MicroMsg.WalletOfflineCoinPurseUI", "do offline showcode");
            k.ezn();
            k.ezp();
            o oVar = new o(com.tencent.mm.plugin.offline.e.ezf(), WalletOfflineCoinPurseUI.this.mEntryScene, daVar.dGj.dGk);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(oVar, 0);
            AppMethodBeat.o(184866);
            return false;
        }
    };
    private IListener<ov> AMk = new IListener<ov>() {
        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass40 */

        {
            AppMethodBeat.i(160823);
            this.__eventId = ov.class.getName().hashCode();
            AppMethodBeat.o(160823);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ov ovVar) {
            AppMethodBeat.i(66437);
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", " ecard finish: %s", Integer.valueOf(ovVar.dUP.retCode));
            WalletOfflineCoinPurseUI.this.doSceneProgress(new ad(null, 8), false);
            AppMethodBeat.o(66437);
            return false;
        }
    };
    private IListener<oe> AMl = new IListener<oe>() {
        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass42 */

        {
            AppMethodBeat.i(160825);
            this.__eventId = oe.class.getName().hashCode();
            AppMethodBeat.o(160825);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(oe oeVar) {
            AppMethodBeat.i(66439);
            WalletOfflineCoinPurseUI.this.doSceneProgress(new ad(null, 8), false);
            WalletOfflineCoinPurseUI.e(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.f(WalletOfflineCoinPurseUI.this);
            WalletOfflineCoinPurseUI.g(WalletOfflineCoinPurseUI.this);
            AppMethodBeat.o(66439);
            return false;
        }
    };
    private IListener<of> AMm = new IListener<of>() {
        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass43 */

        {
            AppMethodBeat.i(160826);
            this.__eventId = of.class.getName().hashCode();
            AppMethodBeat.o(160826);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(of ofVar) {
            AppMethodBeat.i(66440);
            if (ofVar.dUu.aHK != hashCode()) {
                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "has create a new ui, finish self");
                WalletOfflineCoinPurseUI.this.finish();
            }
            AppMethodBeat.o(66440);
            return false;
        }
    };
    private IListener AMn = new IListener<uv>() {
        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass44 */

        {
            AppMethodBeat.i(160827);
            this.__eventId = uv.class.getName().hashCode();
            AppMethodBeat.o(160827);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(uv uvVar) {
            AppMethodBeat.i(66441);
            if (!WalletOfflineCoinPurseUI.this.isFinishing()) {
                WalletOfflineCoinPurseUI.this.finish();
            }
            AppMethodBeat.o(66441);
            return false;
        }
    };
    private IListener AMo = new IListener<zx>() {
        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass2 */

        {
            AppMethodBeat.i(184842);
            this.__eventId = zx.class.getName().hashCode();
            AppMethodBeat.o(184842);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zx zxVar) {
            AppMethodBeat.i(184843);
            zx zxVar2 = zxVar;
            if (zxVar2 instanceof zx) {
                WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, zxVar2.egC.egD);
            }
            AppMethodBeat.o(184843);
            return false;
        }
    };
    private IListener AMp = new IListener<az>() {
        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass3 */

        {
            AppMethodBeat.i(213631);
            this.__eventId = az.class.getName().hashCode();
            AppMethodBeat.o(213631);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(az azVar) {
            AppMethodBeat.i(213632);
            az azVar2 = azVar;
            if (com.tencent.mm.plugin.offline.c.a.ANf != 3 || !(azVar2 instanceof az) || !azVar2.dEc.dEd) {
                AppMethodBeat.o(213632);
                return false;
            }
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "finish button event!");
            WalletOfflineCoinPurseUI.this.finish();
            AppMethodBeat.o(213632);
            return true;
        }
    };
    public boolean AMq = false;
    private MTimerHandler AMr = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass37 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(213662);
            WalletOfflineCoinPurseUI.this.ALB = false;
            if (WalletOfflineCoinPurseUI.this.mTipDialog != null && WalletOfflineCoinPurseUI.this.mTipDialog.isShowing()) {
                WalletOfflineCoinPurseUI.this.mTipDialog.dismiss();
            }
            com.tencent.mm.plugin.offline.g.ezi();
            WalletOfflineCoinPurseUI.U(WalletOfflineCoinPurseUI.this);
            if (com.tencent.mm.plugin.offline.c.a.eAL()) {
                WalletOfflineCoinPurseUI.this.ezz();
            }
            AppMethodBeat.o(213662);
            return false;
        }
    }, false);
    private MTimerHandler AMs = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass38 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(213663);
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onTimerExpired, send ConsumedCardByOfflinePay event: %s", Boolean.valueOf(WalletOfflineCoinPurseUI.this.mIsForeground));
            if (WalletOfflineCoinPurseUI.this.mIsForeground) {
                cm cmVar = new cm();
                cmVar.dFH.resultCode = 0;
                EventCenter.instance.publish(cmVar);
            }
            WalletOfflineCoinPurseUI.this.finish();
            AppMethodBeat.o(213663);
            return false;
        }
    }, false);
    private int eventId = 0;
    private int gwE;
    private View.OnClickListener kuO = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass13 */

        public final void onClick(View view) {
            AppMethodBeat.i(213639);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getId() == R.id.ji1 || view.getId() == R.id.jed || view.getId() == R.id.jee) {
                if (view.getId() != R.id.ji1 || WalletOfflineCoinPurseUI.this.ALT == null || !WalletOfflineCoinPurseUI.this.ALT.isShowing()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((WalletOfflineCoinPurseUI.this.ALT == null || !WalletOfflineCoinPurseUI.this.ALT.isShowing()) && currentTimeMillis - WalletOfflineCoinPurseUI.this.mLastTime >= 400 && com.tencent.mm.plugin.offline.c.a.eAj() && !WalletOfflineCoinPurseUI.t(WalletOfflineCoinPurseUI.this)) {
                        if (view.getId() == R.id.ji1) {
                            WalletOfflineCoinPurseUI.this.pZM = false;
                        } else if (view.getId() == R.id.jed || view.getId() == R.id.jee) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13958, 4);
                            WalletOfflineCoinPurseUI.this.pZM = true;
                        }
                        if (WalletOfflineCoinPurseUI.this.ALR != null) {
                            WalletOfflineCoinPurseUI.v(WalletOfflineCoinPurseUI.this);
                            WalletOfflineCoinPurseUI.this.ALR.aa(view, WalletOfflineCoinPurseUI.this.pZM);
                        }
                        WalletOfflineCoinPurseUI.this.mLastTime = currentTimeMillis;
                    }
                } else {
                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "offlineAlertView is showing");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213639);
                    return;
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213639);
        }
    };
    private int mEntryScene = -1;
    private boolean mIsForeground;
    private long mLastTime = 0;
    private int mState = 3;
    private Dialog mTipDialog;
    private boolean pZM = true;
    private int sQn;
    private HashMap<String, Integer> yNN = new HashMap<>();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletOfflineCoinPurseUI() {
        AppMethodBeat.i(66468);
        AppMethodBeat.o(66468);
    }

    static /* synthetic */ void E(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(213685);
        walletOfflineCoinPurseUI.TZ(0);
        AppMethodBeat.o(213685);
    }

    static /* synthetic */ void F(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(213686);
        walletOfflineCoinPurseUI.sy(true);
        AppMethodBeat.o(213686);
    }

    static /* synthetic */ void G(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(213687);
        walletOfflineCoinPurseUI.forceCancel();
        AppMethodBeat.o(213687);
    }

    static /* synthetic */ void L(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(213690);
        walletOfflineCoinPurseUI.ab(true, true);
        AppMethodBeat.o(213690);
    }

    static /* synthetic */ void U(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(213691);
        walletOfflineCoinPurseUI.ezN();
        AppMethodBeat.o(213691);
    }

    static /* synthetic */ void Ub(int i2) {
        AppMethodBeat.i(213683);
        Ua(i2);
        AppMethodBeat.o(213683);
    }

    static /* synthetic */ void Z(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(213692);
        walletOfflineCoinPurseUI.ezE();
        AppMethodBeat.o(213692);
    }

    static /* synthetic */ void a(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, Bankcard bankcard) {
        AppMethodBeat.i(213684);
        walletOfflineCoinPurseUI.a(bankcard);
        AppMethodBeat.o(213684);
    }

    static /* synthetic */ void e(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(213675);
        walletOfflineCoinPurseUI.ezS();
        AppMethodBeat.o(213675);
    }

    static /* synthetic */ boolean eAd() {
        AppMethodBeat.i(213674);
        boolean eAb = eAb();
        AppMethodBeat.o(213674);
        return eAb;
    }

    static /* synthetic */ void f(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(66524);
        walletOfflineCoinPurseUI.ezT();
        AppMethodBeat.o(66524);
    }

    static /* synthetic */ void g(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(213676);
        walletOfflineCoinPurseUI.ezQ();
        AppMethodBeat.o(213676);
    }

    static /* synthetic */ boolean t(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(213681);
        boolean ezI = walletOfflineCoinPurseUI.ezI();
        AppMethodBeat.o(213681);
        return ezI;
    }

    static /* synthetic */ void v(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        AppMethodBeat.i(213682);
        walletOfflineCoinPurseUI.ezK();
        AppMethodBeat.o(213682);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(66469);
        super.onCreate(bundle);
        t.fQC();
        this.ALX = t.fQR();
        k.AIX = true;
        com.tencent.mm.wallet_core.ui.f.aqm(41);
        Intent intent = getIntent();
        this.ALD = intent.getBooleanExtra("is_offline_create", false);
        if (intent != null && intent.hasExtra("key_entry_scene")) {
            this.mEntryScene = intent.getIntExtra("key_entry_scene", this.mEntryScene);
        }
        this.gwE = intent.getIntExtra("key_from_scene", 0);
        this.ALh = Util.nullAs(intent.getStringExtra("key_business_attach"), "");
        this.sQn = 1;
        if (this.mEntryScene == 2) {
            this.sQn = 1;
        } else if (this.mEntryScene == 1) {
            this.sQn = 2;
        } else if (this.mEntryScene == 8) {
            this.sQn = 4;
        } else if (this.mEntryScene == 4) {
            this.sQn = 6;
        } else {
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %d", Integer.valueOf(this.sQn));
        }
        getWindow().addFlags(8192);
        ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
        setContentViewVisibility(0);
        setActionbarColor(getResources().getColor(R.color.ai));
        hideActionbarLine();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass41 */

            {
                AppMethodBeat.i(160824);
                AppMethodBeat.o(160824);
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(213666);
                ip ipVar = new ip();
                ipVar.dNj.dNk = "ok";
                EventCenter.instance.publish(ipVar);
                if (WalletOfflineCoinPurseUI.this.gwE == 8) {
                    com.tencent.mm.plugin.offline.c.a.aJv(WalletOfflineCoinPurseUI.this.getIntent().getStringExtra("key_appid"));
                }
                WalletOfflineCoinPurseUI.this.finish();
                AppMethodBeat.o(213666);
                return false;
            }
        });
        try {
            ScreenShotUtil.setScreenShotCallback(this, this);
            z = true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", e2, "", new Object[0]);
            getWindow().setFlags(8192, 8192);
            z = false;
        }
        if (!z) {
            ScreenShotUtil.setScreenShotCallback(this, null);
        }
        com.tencent.mm.wallet_core.ui.f.hhU();
        if (t.fQI().fRp()) {
            Log.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is invalid");
        } else if (t.fQI().fRm()) {
            Log.e("MicroMsg.WalletOfflineCoinPurseUI", "coin purse onCreate data is isUnreg");
            com.tencent.mm.plugin.offline.c.a.eAw();
            k.ezn();
            k.bN(196648, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else if (t.fQI().fRk() && com.tencent.mm.plugin.offline.c.a.eAj()) {
            ezZ();
        }
        initView();
        String str = (String) ((com.tencent.mm.plugin.wxpay.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.USERINFO_WALLET_OFFLINE_DISABLE_BLOCK_LAYER_STRING_SYNC, "");
        if (!Util.isNullOrNil(str)) {
            try {
                this.AMc = r.bJ(new JSONObject(str));
            } catch (JSONException e3) {
                Log.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", e3, "", new Object[0]);
            }
        }
        u.a(this);
        k.ezn();
        k.ezo().a(this);
        addSceneEndListener(606);
        addSceneEndListener(SdkInfo.ErrCode.kErrCodeFormatUnSupport);
        addSceneEndListener(1501);
        addSceneEndListener(580);
        k.ezn();
        k.ezp().dM(this);
        EventCenter.instance.addListener(this.AMp);
        com.tencent.mm.plugin.offline.c.a.eAx();
        EventCenter.instance.add(this.AMn);
        EventCenter.instance.add(this.AMl);
        EventCenter.instance.add(this.AMg);
        EventCenter.instance.add(this.AMh);
        this.AMi.alive();
        this.AMj.alive();
        this.AMk.alive();
        this.ALC = new com.tencent.mm.plugin.offline.g();
        of ofVar = new of();
        ofVar.dUu.aHK = hashCode();
        EventCenter.instance.publish(ofVar);
        this.AMm.alive();
        AppMethodBeat.o(66469);
    }

    @Override // com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public Resources getResources() {
        AppMethodBeat.i(174404);
        Resources resources = super.getResources();
        AppMethodBeat.o(174404);
        return resources;
    }

    private void ezD() {
        AppMethodBeat.i(66470);
        ezS();
        ezY();
        ezT();
        ezQ();
        ezW();
        AppMethodBeat.o(66470);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        boolean z;
        AppMethodBeat.i(66471);
        super.onResume();
        EventCenter.instance.addListener(this.AMo);
        try {
            ScreenShotUtil.setScreenShotCallback(this, this);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WalletOfflineCoinPurseUI", e2, "", new Object[0]);
        }
        if (!this.ALU) {
            ezD();
            this.ALU = true;
        }
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on resume");
        this.mIsForeground = true;
        com.tencent.mm.plugin.walletlock.a.b bVar = (com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class);
        bVar.a(this, bVar.fUE(), null);
        if (NetStatusUtil.isNetworkConnected(getBaseContext())) {
            if (t.fQI().fRp()) {
                doSceneForceProgress(new ad(null, 8));
            }
            if (com.tencent.mm.plugin.offline.c.a.eAj() && this.AMb) {
                k.ezn();
                k.ezq().sx(false);
                if (!c.ezB()) {
                    if (this.ALM) {
                        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do not doNetSceneUserBindQuery()");
                        this.ALM = false;
                    } else {
                        q qVar = new q(this.mEntryScene, this.eventId, this.ALY, this.ALK);
                        this.ALK = 0;
                        doSceneProgress(qVar, false);
                        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do doNetSceneUserBindQuery()");
                    }
                }
            }
        }
        if (!this.AMb) {
            this.AMb = true;
        }
        ezH();
        Bankcard eAm = com.tencent.mm.plugin.offline.c.a.eAm();
        if (eAm == null || eAm.field_bindSerial == null || eAm.field_bindSerial.equals(this.AIf)) {
            z = false;
        } else {
            this.AIf = eAm.field_bindSerial;
            k.ezn();
            k.ezp().AIf = this.AIf;
            z = true;
        }
        if (z || (this.AKX && this.AKW)) {
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onresume BindSerial isChange");
            this.AKX = false;
            this.AKW = false;
            ezO();
            TZ(0);
            sy(true);
        }
        com.tencent.mm.plugin.offline.g gVar = this.ALC;
        if (com.tencent.mm.plugin.offline.c.a.eAL()) {
            Log.i(com.tencent.mm.plugin.offline.g.TAG, "OFFLINEGETMSGLOGIN START; IS stopped=" + gVar.AIz.stopped());
            if (gVar.AIz == null || gVar.AIz.stopped()) {
                gVar.status = 1;
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(135, 61, 1, true);
                if (gVar.AIy) {
                    com.tencent.mm.plugin.offline.g.ezi();
                    gVar.AIz.startTimer((long) com.tencent.mm.plugin.offline.g.AIi);
                    int i2 = com.tencent.mm.plugin.offline.g.AIi;
                } else {
                    gVar.AIz.startTimer((long) com.tencent.mm.plugin.offline.g.AIw);
                    int i3 = com.tencent.mm.plugin.offline.g.AIw;
                }
            }
        } else {
            Log.i(com.tencent.mm.plugin.offline.g.TAG, "OfflineGetMsg is not in abtest");
        }
        if (this.ALZ) {
            this.ALZ = false;
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(18930, Integer.valueOf(this.AMa), 4);
        }
        this.AMd = false;
        this.AMe = false;
        AppMethodBeat.o(66471);
    }

    private void ezE() {
        AppMethodBeat.i(66472);
        com.tencent.mm.wallet_core.ui.f.aqm(32);
        com.tencent.mm.pluginsdk.wallet.f.aD(this, this.sQn);
        AppMethodBeat.o(66472);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(66473);
        super.onNewIntent(intent);
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "hy: on new intent");
        this.AKW = true;
        AppMethodBeat.o(66473);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(66474);
        k.ezn();
        com.tencent.mm.plugin.offline.i ezq = k.ezq();
        ezq.mHandler.removeCallbacks(ezq.AIL);
        ScreenShotUtil.setScreenShotCallback(this, null);
        this.mIsForeground = false;
        EventCenter.instance.removeListener(this.AMo);
        this.ALC.stop();
        super.onPause();
        AppMethodBeat.o(66474);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(66475);
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onDestory()");
        Bankcard eAm = com.tencent.mm.plugin.offline.c.a.eAm();
        if (eAm != null) {
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mBindSerial:%s serial:%s mLastBindSerial:%s", this.AIf, eAm.field_bindSerial, this.ALc);
            if (eAm.fQg() && !eAb()) {
                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "need checkout FQF");
                String str = this.ALc;
                Util.isNullOrNil(this.ALc);
                com.tencent.mm.plugin.offline.c.a.aJk(str);
                k.ezn();
                k.ezp().AIf = str;
            }
        }
        this.ALT.dismiss();
        k.AIX = false;
        com.tencent.mm.wallet_core.ui.f.Z(this.AKT);
        com.tencent.mm.wallet_core.ui.f.Z(this.AKU);
        com.tencent.mm.wallet_core.ui.f.bu(this.ALP);
        com.tencent.mm.wallet_core.ui.f.bu(this.ALQ);
        this.ALP.clear();
        this.ALQ.clear();
        this.AKY.clear();
        this.AKZ.clear();
        this.ALa.clear();
        u.c(this);
        k.ezn();
        k.ezo().b(this);
        removeSceneEndListener(606);
        removeSceneEndListener(SdkInfo.ErrCode.kErrCodeFormatUnSupport);
        removeSceneEndListener(1501);
        removeSceneEndListener(580);
        k.ezn();
        k.ezp().dN(this);
        EventCenter.instance.removeListener(this.AMp);
        EventCenter.instance.removeListener(this.AMn);
        EventCenter.instance.removeListener(this.AMg);
        EventCenter.instance.removeListener(this.AMh);
        if (!this.AIN.stopped()) {
            this.AIN.stopTimer();
        }
        if (!this.AMs.stopped()) {
            this.AMs.stopTimer();
        }
        if (this.ALR != null) {
            this.ALR.release();
        }
        if (this.ALS != null) {
            c cVar = this.ALS;
            cVar.paT.cancel();
            cVar.mActivity = null;
        }
        EventCenter.instance.removeListener(this.AMl);
        this.AMj.dead();
        this.AMk.dead();
        com.tencent.mm.plugin.offline.g gVar = this.ALC;
        gVar.stop();
        com.tencent.mm.plugin.offline.g.ezi();
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(385, gVar.AIx);
        gVar.AIz = null;
        this.AMm.dead();
        this.AMi.dead();
        com.tencent.mm.plugin.remittance.mobile.a.b.VZ(0);
        super.onDestroy();
        AppMethodBeat.o(66475);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(66476);
        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "errType:" + i2 + "  errCode" + i3 + " errMsg:" + str + " scene: " + qVar);
        if ((qVar instanceof com.tencent.mm.plugin.offline.a.f) && ((i2 == 0 && i3 == 0) || i2 != 0)) {
            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", Integer.valueOf(i2), Integer.valueOf(i3));
            this.AIK.ezs();
            this.AIK = null;
        }
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof ad) {
                if (this.ALV) {
                    this.ALV = false;
                    Bankcard eAn = com.tencent.mm.plugin.offline.c.a.eAn();
                    if (eAn != null) {
                        doSceneForceProgress(new com.tencent.mm.plugin.offline.a.k(eAn, this.ALW, 0));
                    }
                    AppMethodBeat.o(66476);
                    return true;
                }
                if (com.tencent.mm.plugin.offline.c.a.eAj()) {
                    if (com.tencent.mm.plugin.offline.c.a.sA(false) != null) {
                        doSceneProgress(new n(new StringBuilder().append(System.currentTimeMillis()).toString(), this.mEntryScene), false);
                    }
                    ezZ();
                }
                com.tencent.mm.plugin.wallet_core.model.q qVar2 = ((ad) qVar).HQp;
                if (qVar2 == null || qVar2.HYr == 0) {
                    if (this.ALT.AKt == 7) {
                        this.ALT.dismiss();
                    }
                } else if (this.ALT.TY(7)) {
                    if (this.ALT.AKt == 7) {
                        this.ALT.dismiss();
                    }
                    this.AMa = qVar2.HYq;
                    OfflineAlertView offlineAlertView = this.ALT;
                    View view = this.ALd;
                    AnonymousClass29 r3 = new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass29 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(213653);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do click fqf text link");
                            WalletOfflineCoinPurseUI.this.ALZ = true;
                            WalletOfflineCoinPurseUI.this.eventId = 1;
                            WalletOfflineCoinPurseUI.this.ALY = "weixin://wcpay/fqf/opentinyapp";
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(213653);
                        }
                    };
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(18930, Integer.valueOf(qVar2.HYq), 1);
                    offlineAlertView.AKt = 7;
                    offlineAlertView.setVisibility(0);
                    offlineAlertView.AKu = false;
                    offlineAlertView.jLy.removeAllViews();
                    View inflate = LayoutInflater.from(offlineAlertView.getContext()).inflate(R.layout.c_1, offlineAlertView.jLy, false);
                    offlineAlertView.jLy.addView(inflate);
                    TextView textView = (TextView) inflate.findViewById(R.id.f6p);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.id5);
                    Button button = (Button) inflate.findViewById(R.id.dt2);
                    if (!Util.isNullOrNil(qVar2.HYt)) {
                        textView.setText(qVar2.HYt);
                    }
                    if (!Util.isNullOrNil(qVar2.HYu)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("repayment_tiny_app_username", qVar2.HYv);
                        bundle.putString("repayment_tiny_app_path", qVar2.HYw);
                        textView2.setText(qVar2.HYu);
                        l.a(textView2, false, (Object) bundle);
                        if (offlineAlertView.ptq != null) {
                            l.b(offlineAlertView.ptq);
                        }
                        offlineAlertView.ptq = 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01d7: IPUT  
                              (wrap: com.tencent.mm.plugin.offline.ui.OfflineAlertView$3 : 0x01d4: CONSTRUCTOR  (r0v191 com.tencent.mm.plugin.offline.ui.OfflineAlertView$3) = 
                              (r8v0 'offlineAlertView' com.tencent.mm.plugin.offline.ui.OfflineAlertView)
                              (r3v12 'r3' com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$29)
                              (r7v0 'qVar2' com.tencent.mm.plugin.wallet_core.model.q)
                             call: com.tencent.mm.plugin.offline.ui.OfflineAlertView.3.<init>(com.tencent.mm.plugin.offline.ui.OfflineAlertView, android.view.View$OnClickListener, com.tencent.mm.plugin.wallet_core.model.q):void type: CONSTRUCTOR)
                              (r8v0 'offlineAlertView' com.tencent.mm.plugin.offline.ui.OfflineAlertView)
                             com.tencent.mm.plugin.offline.ui.OfflineAlertView.ptq com.tencent.mm.pluginsdk.ui.span.i in method: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):boolean, file: classes6.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01d4: CONSTRUCTOR  (r0v191 com.tencent.mm.plugin.offline.ui.OfflineAlertView$3) = 
                              (r8v0 'offlineAlertView' com.tencent.mm.plugin.offline.ui.OfflineAlertView)
                              (r3v12 'r3' com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI$29)
                              (r7v0 'qVar2' com.tencent.mm.plugin.wallet_core.model.q)
                             call: com.tencent.mm.plugin.offline.ui.OfflineAlertView.3.<init>(com.tencent.mm.plugin.offline.ui.OfflineAlertView, android.view.View$OnClickListener, com.tencent.mm.plugin.wallet_core.model.q):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):boolean, file: classes6.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 40 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.offline.ui.OfflineAlertView, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 44 more
                            */
                        /*
                        // Method dump skipped, instructions count: 1554
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):boolean");
                    }

                    @Override // com.tencent.mm.ui.MMActivity
                    public int getLayoutId() {
                        return R.layout.c9y;
                    }

                    @Override // com.tencent.mm.ui.MMActivity
                    public void initView() {
                        AppMethodBeat.i(66477);
                        this.ALT = (OfflineAlertView) findViewById(R.id.g39);
                        this.ALT.dismiss();
                        this.ALT.setDialogState(new OfflineAlertView.a() {
                            /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass6 */

                            @Override // com.tencent.mm.plugin.offline.ui.OfflineAlertView.a
                            public final void onClose() {
                                AppMethodBeat.i(213634);
                                WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this);
                                AppMethodBeat.o(213634);
                            }

                            @Override // com.tencent.mm.plugin.offline.ui.OfflineAlertView.a
                            public final void onShow() {
                                AppMethodBeat.i(213635);
                                WalletOfflineCoinPurseUI.h(WalletOfflineCoinPurseUI.this);
                                AppMethodBeat.o(213635);
                            }
                        });
                        com.tencent.mm.wallet_core.c.b.hhj().init(getApplicationContext());
                        if (this.mEntryScene == 3 || this.mEntryScene == 10 || this.mEntryScene == 11 || this.mEntryScene == 12) {
                            setMMTitle(R.string.iv0);
                        } else {
                            setMMTitle(R.string.iv1);
                        }
                        this.ALS = new c(this, this);
                        c cVar = this.ALS;
                        cVar.paT = (Vibrator) cVar.mActivity.getSystemService("vibrator");
                        this.ALR = new com.tencent.mm.wallet_core.ui.c(this, true);
                        this.ALR.hhP();
                        this.ALd = findViewById(R.id.ji2);
                        this.ALe = (ImageView) findViewById(R.id.ji1);
                        this.ALf = (ImageView) findViewById(R.id.jed);
                        this.ALg = (TextView) findViewById(R.id.jee);
                        this.ALi = findViewById(R.id.jic);
                        this.ALj = (TextView) findViewById(R.id.jie);
                        this.ALk = (WeImageView) findViewById(R.id.jib);
                        this.ALl = (RelativeLayout) findViewById(R.id.jga);
                        this.ALm = (LinearLayout) findViewById(R.id.jih);
                        this.ALn = (CdnImageView) findViewById(R.id.jii);
                        this.ALo = (TextView) findViewById(R.id.jig);
                        this.ALp = (TextView) findViewById(R.id.jif);
                        this.ALi.post(new Runnable() {
                            /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass9 */

                            public final void run() {
                                AppMethodBeat.i(213637);
                                ViewGroup.LayoutParams layoutParams = WalletOfflineCoinPurseUI.this.ALi.getLayoutParams();
                                if (layoutParams != null) {
                                    WalletOfflineCoinPurseUI.this.ALi.setMinimumHeight(layoutParams.height);
                                }
                                AppMethodBeat.o(213637);
                            }
                        });
                        this.ALl.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass10 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(66411);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                WalletOfflineCoinPurseUI.o(WalletOfflineCoinPurseUI.this);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(66411);
                            }
                        });
                        this.ALe.setOnClickListener(this.kuO);
                        this.ALf.setOnClickListener(this.kuO);
                        this.ALg.setOnClickListener(this.kuO);
                        this.ALi.setClickable(true);
                        this.ALi.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass11 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(184848);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click change_bankcard_layout() card：%s", WalletOfflineCoinPurseUI.this.AIf);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14515, 1);
                                WalletOfflineCoinPurseUI.this.AMd = true;
                                WalletOfflineCoinPurseUI.q(WalletOfflineCoinPurseUI.this);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(184848);
                            }
                        });
                        this.mLastTime = System.currentTimeMillis();
                        this.ALq = new e();
                        this.ALq.ehq();
                        com.tencent.mm.plugin.newtips.a.exl().h(this.ALq);
                        this.ALr = new g();
                        this.ALr.ehq();
                        com.tencent.mm.plugin.newtips.a.exl().h(this.ALr);
                        this.ALs = new b();
                        this.ALs.ehq();
                        com.tencent.mm.plugin.newtips.a.exl().h(this.ALs);
                        this.ALt = new f();
                        this.ALt.ehq();
                        com.tencent.mm.plugin.newtips.a.exl().h(this.ALt);
                        this.ALu = new d();
                        this.ALu.ehq();
                        com.tencent.mm.plugin.newtips.a.exl().h(this.ALu);
                        if (this.mEntryScene == 3 || this.mEntryScene == 10 || this.mEntryScene == 11 || this.mEntryScene == 12) {
                            this.ALv.setVisibility(8);
                            this.ALw.setVisibility(8);
                            this.ALx.setVisibility(8);
                            this.ALy.setVisibility(8);
                        } else {
                            this.ALy.setVisibility(0);
                            this.ALz.setVisibility(0);
                            final boolean b2 = com.tencent.mm.plugin.newtips.a.g.b(this.ALq);
                            final boolean b3 = com.tencent.mm.plugin.newtips.a.g.b(this.ALs);
                            final boolean b4 = com.tencent.mm.plugin.newtips.a.g.b(this.ALt);
                            final boolean b5 = com.tencent.mm.plugin.newtips.a.g.b(this.ALr);
                            final boolean b6 = com.tencent.mm.plugin.newtips.a.g.b(this.ALu);
                            if (((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "no need scroll");
                            } else {
                                getWindow().getDecorView().post(new Runnable() {
                                    /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass8 */

                                    public final void run() {
                                        int i2;
                                        AppMethodBeat.i(213636);
                                        ScrollView scrollView = (ScrollView) WalletOfflineCoinPurseUI.this.findViewById(R.id.g3c);
                                        if (scrollView == null) {
                                            AppMethodBeat.o(213636);
                                            return;
                                        }
                                        int[] iArr = new int[2];
                                        scrollView.getLocationInWindow(iArr);
                                        int i3 = ao.az(WalletOfflineCoinPurseUI.this.getContext()).y;
                                        if (ao.aA(WalletOfflineCoinPurseUI.this.getContext())) {
                                            Log.d("MicroMsg.WalletOfflineCoinPurseUI", "has navi");
                                            i3 -= ao.aD(WalletOfflineCoinPurseUI.this.getContext());
                                        }
                                        if (b2) {
                                            i2 = iArr[1] + WalletOfflineCoinPurseUI.this.ALv.getBottom();
                                        } else {
                                            i2 = 0;
                                        }
                                        if (b5) {
                                            i2 = iArr[1] + WalletOfflineCoinPurseUI.this.ALy.getBottom();
                                        }
                                        if (b3) {
                                            i2 = iArr[1] + WalletOfflineCoinPurseUI.this.ALw.getBottom();
                                        }
                                        if (b4) {
                                            i2 = iArr[1] + WalletOfflineCoinPurseUI.this.ALx.getBottom();
                                        }
                                        if (b6) {
                                            i2 = iArr[1] + WalletOfflineCoinPurseUI.this.ALz.getBottom();
                                        }
                                        Log.d("MicroMsg.WalletOfflineCoinPurseUI", "f2f: %s, screen: %s", Integer.valueOf(i2), Integer.valueOf(i3));
                                        int i4 = i2 - i3;
                                        if (i4 > 0) {
                                            scrollView.scrollBy(0, i4);
                                        }
                                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.TRUE);
                                        AppMethodBeat.o(213636);
                                    }
                                });
                            }
                            TextView textView = (TextView) findViewById(R.id.a0r);
                            ImageView imageView = (ImageView) findViewById(R.id.a0q);
                            if (this.ALX) {
                                textView.setText(R.string.aaz);
                                imageView.setImageResource(R.raw.icons_outlined_transfer);
                                imageView.getDrawable().setColorFilter(getResources().getColor(R.color.BW_100_Alpha_0_9), PorterDuff.Mode.SRC_ATOP);
                            } else {
                                textView.setText(R.string.acb);
                                imageView.setImageResource(R.raw.bank_remit_transfer);
                                imageView.clearColorFilter();
                            }
                        }
                        if (com.tencent.mm.plugin.offline.c.a.eAj() && c.ezB()) {
                            c cVar2 = this.ALS;
                            k.ezn();
                            cVar2.a(k.ezo().AKa);
                        }
                        ezH();
                        ab(true, false);
                        this.AIN.startTimer((long) this.AIM);
                        if (com.tencent.mm.plugin.offline.c.a.ANf == 3 && com.tencent.mm.plugin.offline.c.a.ANi) {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, is marked!");
                            int i2 = com.tencent.mm.plugin.offline.c.a.ANg;
                            long j2 = com.tencent.mm.plugin.offline.c.a.ANh;
                            long currentTimeMillis = System.currentTimeMillis();
                            long j3 = (((long) (i2 * 1000)) + j2) - currentTimeMillis;
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "expire_time:" + i2 + " beginTime:" + j2 + " now:" + currentTimeMillis + " interval:" + j3);
                            if (com.tencent.mm.plugin.offline.c.a.ANg <= 0 || com.tencent.mm.plugin.offline.c.a.ANh <= 0 || j3 <= 0) {
                                Log.e("MicroMsg.WalletOfflineCoinPurseUI", "not to start card expire timer!");
                            } else {
                                if (!this.AMs.stopped()) {
                                    this.AMs.stopTimer();
                                }
                                this.AMs.startTimer(j3);
                                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "start card expire timer!");
                            }
                        } else if (com.tencent.mm.plugin.offline.c.a.ANf == 3) {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from card detail ui, not need to mark!");
                        } else {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "The scene is from %d, not need to start timer!", Integer.valueOf(com.tencent.mm.plugin.offline.c.a.ANf));
                        }
                        ezG();
                        final zt ztVar = new zt();
                        ztVar.efM.scene = "5";
                        ztVar.callback = new Runnable() {
                            /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass7 */

                            public final void run() {
                                AppMethodBeat.i(184847);
                                if (!Util.isNullOrNil(ztVar.efN.efO)) {
                                    com.tencent.mm.wallet_core.ui.f.a((TextView) WalletOfflineCoinPurseUI.this.findViewById(R.id.a2b), ztVar.efN.efO, ztVar.efN.content, ztVar.efN.url);
                                    AppMethodBeat.o(184847);
                                    return;
                                }
                                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "no bulletin data");
                                AppMethodBeat.o(184847);
                            }
                        };
                        EventCenter.instance.publish(ztVar);
                        AppMethodBeat.o(66477);
                    }

                    private void ezF() {
                        AppMethodBeat.i(66478);
                        final cul cul = t.fQI().IbR;
                        if (cul == null) {
                            this.ALm.setVisibility(8);
                            AppMethodBeat.o(66478);
                            return;
                        }
                        if (cul.HFS == ai.a.GuideType_FQF_SWITCH.value) {
                            if (cul.MzF == null) {
                                Log.e("MicroMsg.WalletOfflineCoinPurseUI", "offlineGuideBar.guide_data == null");
                                this.ALm.setVisibility(8);
                                AppMethodBeat.o(66478);
                                return;
                            }
                            String str = cul.MzF.ANo;
                            if (t.fQI().l(str, false, false) == null) {
                                Log.e("MicroMsg.WalletOfflineCoinPurseUI", "updateOfflineGuideBar bindSerial(%s) is null bankcard!", Util.nullAs(str, ""));
                                this.ALm.setVisibility(8);
                                AppMethodBeat.o(66478);
                                return;
                            }
                            Bankcard eAm = com.tencent.mm.plugin.offline.c.a.eAm();
                            if (!(eAm == null || eAm.field_bindSerial == null || !Util.isEqual(cul.MzF.ANo, eAm.field_bindSerial))) {
                                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "updateOfflineGuideBar defaultBankcard(%s) == bindSerial(%s)", eAm.field_bindSerial, cul.MzF.ANo);
                                this.ALm.setVisibility(8);
                                AppMethodBeat.o(66478);
                                return;
                            }
                        }
                        if (this.ALm.isShown() && this.ALm.getTag() != null && (this.ALm.getTag() instanceof cul) && Util.isEqual((cul) this.ALm.getTag(), cul)) {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "");
                            AppMethodBeat.o(66478);
                        } else if (cul.HEc == 0) {
                            this.ALm.setVisibility(8);
                            AppMethodBeat.o(66478);
                        } else if (!this.ALG) {
                            Log.e("MicroMsg.WalletOfflineCoinPurseUI", "isShowGuideBar == false");
                            AppMethodBeat.o(66478);
                        } else {
                            int visibility = this.ALm.getVisibility();
                            this.ALm.setTag(cul);
                            this.ALm.setVisibility(0);
                            int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 20.0f);
                            this.ALn.s(cul.HEj, fromDPToPix, fromDPToPix, -1);
                            this.ALo.setText(cul.HEe);
                            this.ALp.setText(cul.HEg);
                            ao.a(this.ALp.getPaint(), 0.8f);
                            if (cul.HFS == ai.a.GuideType_FQF_SWITCH.value) {
                                if (!Util.isNullOrNil(cul.LFY) && this.ALm.getBackground() != null) {
                                    this.ALm.getBackground().setColorFilter(Color.parseColor(cul.LFY), PorterDuff.Mode.SRC);
                                }
                                this.ALo.setTextColor(Color.parseColor(cul.HEf));
                                this.ALp.setTextColor(Color.parseColor(cul.HEh));
                                this.ALp.setTag(cul.MzF.ANo);
                                this.ALp.setOnClickListener(new View.OnClickListener() {
                                    /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass14 */

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(213640);
                                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                        bVar.bm(view);
                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        WalletOfflineCoinPurseUI.Ub(2);
                                        String str = "";
                                        if (view.getTag() != null && (view.getTag() instanceof String)) {
                                            str = (String) view.getTag();
                                        }
                                        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mOfflineGuideButtonTv click! bindSerial:%s", str);
                                        if (Util.isNullOrNil(str)) {
                                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                            AppMethodBeat.o(213640);
                                            return;
                                        }
                                        WalletOfflineCoinPurseUI.this.ALG = false;
                                        WalletOfflineCoinPurseUI.this.AMe = true;
                                        WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, t.fQI().aVm(str));
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(213640);
                                    }
                                });
                                Ua(1);
                                this.ALO = true;
                            } else if (cul.HFS == ai.a.GuideType_FQF_SWITCH_OPEN.value) {
                                if (!Util.isNullOrNil(cul.LFY) && this.ALm.getBackground() != null) {
                                    this.ALm.getBackground().setColorFilter(argbColor(Long.parseLong(cul.LFY.substring(2), 16)), PorterDuff.Mode.SRC);
                                }
                                this.ALo.setTextColor(argbColor(Long.parseLong(cul.HEf.substring(2), 16)));
                                this.ALp.setTextColor(argbColor(Long.parseLong(cul.HEh.substring(2), 16)));
                                if (!Util.isNullOrNil(cul.HEi)) {
                                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ALp.getLayoutParams();
                                    layoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 8);
                                    this.ALp.setLayoutParams(layoutParams);
                                    this.ALp.setPadding(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 12), com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 4), com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 12), com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 4));
                                    final int argbColor = argbColor(Long.parseLong(cul.HEi.substring(2), 16));
                                    this.ALp.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.b4c));
                                    ((GradientDrawable) this.ALp.getBackground()).setColor(argbColor);
                                    this.ALp.setOnTouchListener(new View.OnTouchListener() {
                                        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass15 */

                                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                                            AppMethodBeat.i(213641);
                                            if (motionEvent.getAction() == 0) {
                                                WalletOfflineCoinPurseUI.this.ALp.setBackgroundDrawable(WalletOfflineCoinPurseUI.this.getContext().getResources().getDrawable(R.drawable.b4b));
                                            } else if (motionEvent.getAction() == 1) {
                                                WalletOfflineCoinPurseUI.this.ALp.setBackgroundDrawable(WalletOfflineCoinPurseUI.this.getContext().getResources().getDrawable(R.drawable.b4c));
                                                ((GradientDrawable) WalletOfflineCoinPurseUI.this.ALp.getBackground()).setColor(argbColor);
                                            }
                                            AppMethodBeat.o(213641);
                                            return false;
                                        }
                                    });
                                }
                                this.ALp.setOnClickListener(new View.OnClickListener() {
                                    /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass16 */

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(213642);
                                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                        bVar.bm(view);
                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        WalletOfflineCoinPurseUI.this.ALM = true;
                                        WalletOfflineCoinPurseUI.Ub(5);
                                        switch (cul.MzI) {
                                            case 1:
                                                break;
                                            case 2:
                                                com.tencent.mm.wallet_core.ui.f.p(WalletOfflineCoinPurseUI.this.getContext(), cul.MzJ, false);
                                                break;
                                            case 3:
                                                com.tencent.mm.wallet_core.ui.f.u(cul.MzK, cul.MzL, 0, 1137);
                                                break;
                                            default:
                                                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "unknown entrance type");
                                                break;
                                        }
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(213642);
                                    }
                                });
                                Ua(4);
                                this.ALO = false;
                            }
                            if (visibility == 8 && this.ALT.isShowing()) {
                                ezQ();
                                if (!this.ALD && this.ALT.TY(4)) {
                                    com.tencent.mm.kernel.g.aAi();
                                    if (!((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                                        ezR();
                                    }
                                }
                            }
                            AppMethodBeat.o(66478);
                        }
                    }

                    private void cvL() {
                        AppMethodBeat.i(66479);
                        if (com.tencent.mm.plugin.offline.c.a.eAj()) {
                            this.ALl.setVisibility(0);
                            AppMethodBeat.o(66479);
                            return;
                        }
                        this.ALl.setVisibility(4);
                        AppMethodBeat.o(66479);
                    }

                    private void ab(boolean z, boolean z2) {
                        AppMethodBeat.i(66480);
                        if (com.tencent.mm.plugin.offline.c.a.sB(true).size() > 0) {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList size > 0");
                            ezP();
                            ezO();
                            this.ALi.setVisibility(0);
                        } else {
                            this.ALi.setVisibility(0);
                            Log.e("MicroMsg.WalletOfflineCoinPurseUI", "refreshUI tempList== null or size is 0");
                        }
                        if (z) {
                            TZ(0);
                        }
                        sy(z2);
                        cvL();
                        ezG();
                        AppMethodBeat.o(66480);
                    }

                    private void ezG() {
                        AppMethodBeat.i(66481);
                        if (!this.AMq && !NetStatusUtil.isNetworkConnected(getBaseContext())) {
                            k.ezn();
                            k.ezp();
                            if (com.tencent.mm.plugin.offline.e.ezf() == 0) {
                                this.AMq = true;
                                b.ax(this);
                                Log.e("MicroMsg.WalletOfflineCoinPurseUI", "network disconnect and code count == 0");
                            }
                        }
                        AppMethodBeat.o(66481);
                    }

                    private void ezH() {
                        AppMethodBeat.i(66482);
                        int eAp = com.tencent.mm.plugin.offline.c.a.eAp();
                        Bankcard sA = com.tencent.mm.plugin.offline.c.a.sA(false);
                        if (c.ezB()) {
                            this.mState = 7;
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FREEZE");
                            AppMethodBeat.o(66482);
                        } else if (!NetStatusUtil.isNetworkConnected(getBaseContext())) {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_DISCONNECT_NETWORK");
                            this.mState = 6;
                            AppMethodBeat.o(66482);
                        } else if (com.tencent.mm.plugin.offline.c.a.eAj()) {
                            if (eAp == 0) {
                                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount == 0");
                                this.mState = 1;
                                AppMethodBeat.o(66482);
                            } else if (eAp == 0 || sA != null) {
                                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
                                this.mState = 5;
                                AppMethodBeat.o(66482);
                            } else {
                                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is create bindCount != 0 && bankcard == null");
                                this.mState = 2;
                                AppMethodBeat.o(66482);
                            }
                        } else if (eAp == 0) {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount == 0");
                            this.mState = 1;
                            AppMethodBeat.o(66482);
                        } else if (eAp == 0 || sA != null) {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState STATE_FEE_CAN_USE");
                            this.mState = 5;
                            AppMethodBeat.o(66482);
                        } else {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "refreshState offline is not create bindCount != 0 && bankcard == null");
                            this.mState = 2;
                            AppMethodBeat.o(66482);
                        }
                    }

                    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
                    public boolean checkProcLife() {
                        return false;
                    }

                    private void sy(boolean z) {
                        int i2 = 0;
                        AppMethodBeat.i(66483);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (!z || (!Util.isNullOrNil(this.ALA) && !Util.isNullOrNil(this.AII))) {
                            ezX();
                        } else {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "empty code!");
                            ezU();
                        }
                        eeP();
                        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh qrcode is " + (System.currentTimeMillis() - currentTimeMillis));
                        ezJ();
                        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "doRefresh cost time for fresh is " + (System.currentTimeMillis() - currentTimeMillis));
                        recycleBmpList();
                        ezK();
                        ezF();
                        ab.mg(10, 0);
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                        Object[] objArr = new Object[4];
                        objArr[0] = 3;
                        objArr[1] = Integer.valueOf(com.tencent.mm.plugin.offline.c.a.isAppOnForeground(MMApplicationContext.getContext()) ? 0 : 1);
                        if (NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
                            i2 = 1;
                        }
                        objArr[2] = Integer.valueOf(i2);
                        k.ezn();
                        k.ezp();
                        objArr[3] = Integer.valueOf(com.tencent.mm.plugin.offline.e.ezf());
                        hVar.a(14163, objArr);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(135, 67, 1, true);
                        if (NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(135, 32, 1, true);
                        } else {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(135, 33, 1, true);
                        }
                        if (com.tencent.mm.plugin.offline.c.a.isAppOnForeground(this)) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(135, 34, 1, true);
                            AppMethodBeat.o(66483);
                            return;
                        }
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(135, 35, 1, true);
                        AppMethodBeat.o(66483);
                    }

                    private boolean ezI() {
                        return this.mState == 2 || this.mState == 1 || this.mState == 7;
                    }

                    private void eeP() {
                        AppMethodBeat.i(66484);
                        Bitmap bitmap = this.AKT;
                        this.AKT = ezM();
                        this.ALe.setImageBitmap(this.AKT);
                        this.ALP.add(0, bitmap);
                        AppMethodBeat.o(66484);
                    }

                    private void ezJ() {
                        AppMethodBeat.i(66485);
                        Bitmap bitmap = this.AKU;
                        this.AKU = ezL();
                        this.ALf.setImageBitmap(this.AKU);
                        if (ezI()) {
                            this.ALf.setAlpha(10);
                        } else {
                            this.ALf.setAlpha(255);
                        }
                        this.ALQ.add(0, bitmap);
                        AppMethodBeat.o(66485);
                    }

                    private void ezK() {
                        AppMethodBeat.i(66486);
                        if (this.ALR != null) {
                            this.ALR.nC(this.ALA, this.AII);
                            this.ALR.AKT = this.AKT;
                            this.ALR.AKU = this.AKU;
                            this.ALR.hhQ();
                        }
                        AppMethodBeat.o(66486);
                    }

                    private void recycleBmpList() {
                        AppMethodBeat.i(66487);
                        if (this.ALP.size() >= 2) {
                            for (int size = this.ALP.size() - 1; size > 1; size--) {
                                com.tencent.mm.wallet_core.ui.f.Z(this.ALP.remove(size));
                            }
                        }
                        if (this.ALQ.size() >= 2) {
                            for (int size2 = this.ALQ.size() - 1; size2 > 1; size2--) {
                                com.tencent.mm.wallet_core.ui.f.Z(this.ALQ.remove(size2));
                            }
                        }
                        AppMethodBeat.o(66487);
                    }

                    private Bitmap ezL() {
                        AppMethodBeat.i(66488);
                        if (TextUtils.isEmpty(this.AII)) {
                            Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBarcodeBitmap mBarcode == null");
                            AppMethodBeat.o(66488);
                            return null;
                        }
                        Bitmap a2 = com.tencent.mm.by.a.a.a(this, this.AII, 5, 0, 0.0d);
                        AppMethodBeat.o(66488);
                        return a2;
                    }

                    private Bitmap ezM() {
                        AppMethodBeat.i(66489);
                        if (TextUtils.isEmpty(this.ALA)) {
                            Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBitmap mQRcode == null");
                            AppMethodBeat.o(66489);
                            return null;
                        }
                        Bitmap a2 = com.tencent.mm.by.a.a.a(this, this.ALA, 12, 3, 0.0d);
                        AppMethodBeat.o(66489);
                        return a2;
                    }

                    private void TZ(int i2) {
                        int i3;
                        int i4 = 0;
                        AppMethodBeat.i(66490);
                        if (!com.tencent.mm.plugin.offline.c.a.eAj()) {
                            Log.w("MicroMsg.WalletOfflineCoinPurseUI", "offline is not create!");
                            AppMethodBeat.o(66490);
                            return;
                        }
                        k.ezn();
                        String A = k.ezp().A(this.mEntryScene, i2, this.ALh);
                        this.AII = A;
                        this.ALA = A;
                        Log.v("MicroMsg.WalletOfflineCoinPurseUI", "updateCode isSnapshot:%s mBarcode:%s mQRcode:%s stack: %s", Integer.valueOf(i2), this.AII, this.ALA, Util.getStack().toString());
                        cAu();
                        if (Util.isNullOrNil(A)) {
                            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                            Object[] objArr = new Object[3];
                            objArr[0] = 1;
                            if (com.tencent.mm.plugin.offline.c.a.isAppOnForeground(MMApplicationContext.getContext())) {
                                i3 = 0;
                            } else {
                                i3 = 1;
                            }
                            objArr[1] = Integer.valueOf(i3);
                            if (NetStatusUtil.isNetworkConnected(getBaseContext())) {
                                i4 = 1;
                            }
                            objArr[2] = Integer.valueOf(i4);
                            hVar.a(14163, objArr);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(135, 26, 1, true);
                            if (NetStatusUtil.isNetworkConnected(getBaseContext())) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(135, 28, 1, true);
                                AppMethodBeat.o(66490);
                                return;
                            }
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(135, 27, 1, true);
                        }
                        AppMethodBeat.o(66490);
                    }

                    @Override // com.tencent.mm.plugin.offline.a.s.a
                    public final boolean a(s.c cVar) {
                        boolean z;
                        boolean z2;
                        AppMethodBeat.i(66491);
                        if (cVar == null) {
                            Log.e("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msg == null");
                            AppMethodBeat.o(66491);
                            return false;
                        }
                        ezN();
                        this.ALR.dismiss();
                        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "onNotify msgtype：%s，mBindSerial：%s", Integer.valueOf(cVar.AKh), this.AIf);
                        if (4 == cVar.AKh) {
                            this.ALB = false;
                            z = false;
                        } else {
                            if (5 == cVar.AKh) {
                                this.ALB = true;
                                this.ALE = true;
                                this.ALF = false;
                                if (!this.AMr.stopped()) {
                                    this.AMr.stopTimer();
                                    z = false;
                                }
                            } else {
                                if (6 == cVar.AKh) {
                                    if (!this.AMr.stopped()) {
                                        this.AMr.stopTimer();
                                    }
                                    if (!this.AIN.stopped()) {
                                        this.AIN.stopTimer();
                                    }
                                    this.ALB = false;
                                    if (com.tencent.mm.plugin.offline.c.a.eAk()) {
                                        z = false;
                                    }
                                } else if (8 == cVar.AKh) {
                                    if (!this.AMr.stopped()) {
                                        this.AMr.stopTimer();
                                        z = true;
                                    }
                                } else if (23 == cVar.AKh) {
                                    if (!this.AMr.stopped()) {
                                        this.AMr.stopTimer();
                                        z = false;
                                    }
                                } else if (20 == cVar.AKh) {
                                    this.ALB = false;
                                    if (!this.AMr.stopped()) {
                                        this.AMr.stopTimer();
                                        z = false;
                                    }
                                } else if (24 == cVar.AKh) {
                                    if (com.tencent.mm.plugin.offline.c.a.eAL()) {
                                        if (eAc()) {
                                            if (this.ALN) {
                                                Ua(10);
                                            } else if (this.ALO) {
                                                Ua(11);
                                            } else {
                                                Ua(12);
                                            }
                                        }
                                        this.ALB = true;
                                        if (com.tencent.mm.plugin.offline.c.a.eAL()) {
                                            if (this.mTipDialog == null) {
                                                this.mTipDialog = com.tencent.mm.wallet_core.ui.h.a((Context) getContext(), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                                    /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass19 */

                                                    public final void onCancel(DialogInterface dialogInterface) {
                                                        AppMethodBeat.i(213645);
                                                        WalletOfflineCoinPurseUI.G(WalletOfflineCoinPurseUI.this);
                                                        AppMethodBeat.o(213645);
                                                    }
                                                });
                                            } else if (!this.mTipDialog.isShowing()) {
                                                this.mTipDialog.show();
                                            }
                                        }
                                        this.AMr.startTimer((long) com.tencent.mm.plugin.offline.g.ezh());
                                    }
                                }
                                z = true;
                            }
                            z = false;
                        }
                        c cVar2 = this.ALS;
                        if (cVar == null) {
                            Log.e("MicroMsg.OfflineLogicMgr", "onNotify msg == null");
                        } else {
                            Log.i("MicroMsg.OfflineLogicMgr", "onNotify OfflineMsg type :" + cVar.AKh);
                            if (cVar.AKh == 24) {
                                cVar2.paT.vibrate(50);
                            }
                            if (4 == cVar.AKh) {
                                cVar2.a((s.b) cVar);
                                com.tencent.mm.plugin.offline.g.ezi();
                            } else if (5 == cVar.AKh) {
                                s.e eVar = (s.e) cVar;
                                if (eVar != null) {
                                    Log.i("MicroMsg.OfflineLogicMgr", "showNotifyMsg msg.wxRetCode:" + eVar.AKk + " msg.wxRetMsg:" + eVar.AKl + " msg.cftRetCode:" + eVar.AKk + " msg.cftRetMsg:" + eVar.AKj);
                                    if (!TextUtils.isEmpty(eVar.AKk) || !TextUtils.isEmpty(eVar.AKl) || !TextUtils.isEmpty(eVar.AKi) || !TextUtils.isEmpty(eVar.AKj)) {
                                        if (TextUtils.isEmpty(eVar.AKk) && TextUtils.isEmpty(eVar.AKl) && !TextUtils.isEmpty(eVar.AKi) && !TextUtils.isEmpty(eVar.AKj)) {
                                            b.i(cVar2.mActivity, eVar.AKj);
                                        } else if (TextUtils.isEmpty(eVar.AKk) || !com.tencent.mm.plugin.offline.c.a.isNumeric(eVar.AKk)) {
                                            b.i(cVar2.mActivity, eVar.AKl);
                                        } else {
                                            cVar2.a(null, Util.getInt(eVar.AKk, 0), eVar.AKl, eVar.AKm);
                                        }
                                    }
                                }
                                com.tencent.mm.plugin.offline.g.ezi();
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(135, 0, 1, true);
                            } else if (6 == cVar.AKh) {
                                s.f fVar = (s.f) cVar;
                                if (fVar != null) {
                                    Log.i("MicroMsg.OfflineLogicMgr", "showOrderSuccessUI transid : " + fVar.AKo);
                                    k.ezn();
                                    com.tencent.mm.plugin.offline.a.r aJe = k.ezr().aJe(fVar.AKp.dDL);
                                    if (aJe != null) {
                                        z2 = aJe.field_status == com.tencent.mm.plugin.offline.g.AIt;
                                    } else {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        com.tencent.mm.plugin.offline.g.eY(fVar.AKp.dDL, com.tencent.mm.plugin.offline.g.AIt);
                                        com.tencent.mm.plugin.offline.c.a.a(cVar2.mActivity, fVar);
                                        cVar2.mActivity.setResult(-1);
                                        cVar2.mActivity.finish();
                                    }
                                }
                                com.tencent.mm.plugin.offline.g.ezi();
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(135, 7, 1, true);
                                if (com.tencent.mm.plugin.offline.c.a.ANf == 4) {
                                    Log.i("MicroMsg.OfflineLogicMgr", "hy: is from ext");
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13412, new Object[0]);
                                }
                            } else if (8 == cVar.AKh) {
                                s.g gVar = (s.g) cVar;
                                Log.i("MicroMsg.OfflineLogicMgr", "showPayConfirmMsg msg id:" + gVar.id);
                                if (gVar.qGa == 0) {
                                    View inflate = cVar2.mActivity.getLayoutInflater().inflate(R.layout.c_4, (ViewGroup) null);
                                    ((TextView) inflate.findViewById(R.id.g9d)).setText(gVar.AKr);
                                    ((TextView) inflate.findViewById(R.id.g9g)).setText(gVar.AKq);
                                    com.tencent.mm.plugin.offline.g.eY(gVar.dNQ, com.tencent.mm.plugin.offline.g.AIv);
                                    com.tencent.mm.ui.base.h.a(cVar2.mActivity, "", inflate, cVar2.getString(R.string.ivc), cVar2.getString(R.string.sz), new DialogInterface.OnClickListener(gVar) {
                                        /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass11 */
                                        final /* synthetic */ s.g AKN;

                                        {
                                            this.AKN = r2;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(66380);
                                            dialogInterface.dismiss();
                                            if (c.this.AKH != null) {
                                                c.this.AKH.f(1, this.AKN.id, "", this.AKN.dNQ);
                                            }
                                            Log.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
                                            AppMethodBeat.o(66380);
                                        }
                                    }, new DialogInterface.OnClickListener(gVar) {
                                        /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass12 */
                                        final /* synthetic */ s.g AKN;

                                        {
                                            this.AKN = r2;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(66381);
                                            dialogInterface.dismiss();
                                            if (c.this.AKH != null) {
                                                c.this.AKH.f(0, this.AKN.id, "", this.AKN.dNQ);
                                            }
                                            g.eY(this.AKN.dNQ, g.AIt);
                                            Log.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
                                            AppMethodBeat.o(66381);
                                        }
                                    });
                                } else if (gVar.qGa == 1) {
                                    if (cVar2.AKI != null) {
                                        cVar2.AKI.show();
                                    }
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13955, 1);
                                    Log.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog msg id:" + gVar.id);
                                    com.tencent.mm.plugin.offline.g.eY(gVar.dNQ, com.tencent.mm.plugin.offline.g.AIv);
                                    cVar2.AKI = com.tencent.mm.plugin.wallet_core.ui.s.a(cVar2.mActivity, gVar.AKq, gVar.AKr, new s.c(gVar) {
                                        /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass13 */
                                        final /* synthetic */ s.g AKN;

                                        {
                                            this.AKN = r2;
                                        }

                                        @Override // com.tencent.mm.plugin.wallet_core.ui.s.c
                                        public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                                            AppMethodBeat.i(66382);
                                            if (c.this.mActivity instanceof MMActivity) {
                                                ((MMActivity) c.this.mActivity).hideVKB();
                                            }
                                            if (c.this.AKH != null) {
                                                c.this.AKH.f(1, this.AKN.id, str, this.AKN.dNQ);
                                            }
                                            Log.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
                                            AppMethodBeat.o(66382);
                                        }
                                    }, new DialogInterface.OnCancelListener() {
                                        /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass14 */

                                        public final void onCancel(DialogInterface dialogInterface) {
                                            AppMethodBeat.i(66383);
                                            c.this.ezA();
                                            AppMethodBeat.o(66383);
                                        }
                                    }, new s.a(gVar) {
                                        /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass15 */
                                        final /* synthetic */ s.g AKN;

                                        {
                                            this.AKN = r2;
                                        }

                                        @Override // com.tencent.mm.plugin.wallet_core.ui.s.a
                                        public final void ezC() {
                                            AppMethodBeat.i(66384);
                                            if (c.this.AKH != null) {
                                                c.this.AKH.f(0, this.AKN.id, "", this.AKN.dNQ);
                                            }
                                            g.eY(this.AKN.dNQ, g.AIt);
                                            Log.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
                                            AppMethodBeat.o(66384);
                                        }
                                    });
                                    cVar2.AKI.CKk.setVisibility(0);
                                    cVar2.AKI.CuI.setVisibility(8);
                                }
                            } else if (23 == cVar.AKh) {
                                PayInfo payInfo = new PayInfo();
                                payInfo.dDL = ((s.d) cVar).dNQ;
                                payInfo.dVv = 8;
                                payInfo.Kxz = 1;
                                payInfo.iqp = new Bundle();
                                payInfo.iqp.putLong("extinfo_key_9", System.currentTimeMillis());
                                com.tencent.mm.wallet_core.b.hgC();
                                boolean b2 = com.tencent.mm.wallet_core.b.b(b.a.clicfg_kinda_open, true);
                                if (b2) {
                                    com.tencent.mm.wallet_core.b.hgC();
                                    b2 = com.tencent.mm.wallet_core.b.b(b.a.clicfg_open_kinda_offline_cashier, false);
                                }
                                if (b2) {
                                    ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startOfflinePay(cVar2.mActivity, payInfo.dDL, cVar2.AKH == null ? "" : cVar2.AKH.ezy(), payInfo.channel);
                                } else {
                                    EventCenter.instance.add(new IListener<aaa>(payInfo) {
                                        /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass1 */
                                        final /* synthetic */ PayInfo AKL;

                                        {
                                            this.AKL = r4;
                                            AppMethodBeat.i(160818);
                                            this.__eventId = aaa.class.getName().hashCode();
                                            AppMethodBeat.o(160818);
                                        }

                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                                        @Override // com.tencent.mm.sdk.event.IListener
                                        public final /* synthetic */ boolean callback(aaa aaa) {
                                            AppMethodBeat.i(66372);
                                            aaa aaa2 = aaa;
                                            if (aaa2.egJ.egL) {
                                                Log.f("MicroMsg.OfflineLogicMgr", "WalletPayResultEvent is from kinda, ScanQRCodePay");
                                            } else {
                                                EventCenter.instance.removeListener(this);
                                                if (aaa2.egJ.result == 0) {
                                                    com.tencent.mm.plugin.offline.a.c cVar = new com.tencent.mm.plugin.offline.a.c(this.AKL.dDL, this.AKL.dVv, this.AKL.channel);
                                                    com.tencent.mm.kernel.g.aAi();
                                                    com.tencent.mm.kernel.g.aAg().hqi.a(cVar, 0);
                                                    g.ezi();
                                                    c.this.AKH.ezz();
                                                } else if (aaa2.egJ.result == -1) {
                                                    g.ezi();
                                                    c.this.AKH.ezz();
                                                }
                                            }
                                            AppMethodBeat.o(66372);
                                            return false;
                                        }
                                    });
                                    com.tencent.mm.pluginsdk.wallet.f.a(cVar2.mActivity, false, "", cVar2.AKH == null ? "" : cVar2.AKH.ezy(), payInfo, "", new Intent(), 1);
                                }
                            } else if (20 == cVar.AKh) {
                                com.tencent.mm.plugin.offline.g.ezi();
                            }
                        }
                        if (this.ALE && !this.ALF) {
                            this.ALE = false;
                            this.ALB = false;
                        }
                        if (z) {
                            TZ(0);
                            sy(true);
                        }
                        AppMethodBeat.o(66491);
                        return true;
                    }

                    @Override // com.tencent.mm.ui.base.h.c, com.tencent.mm.ui.MMActivity
                    public void addDialog(Dialog dialog) {
                        AppMethodBeat.i(66492);
                        if ((dialog instanceof com.tencent.mm.ui.widget.a.d) && this.ALE) {
                            this.ALF = true;
                            final DialogInterface.OnDismissListener onDismissListener = ((com.tencent.mm.ui.widget.a.d) dialog).NIV;
                            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass18 */

                                public final void onDismiss(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(213644);
                                    if (onDismissListener != null) {
                                        onDismissListener.onDismiss(dialogInterface);
                                    }
                                    if (WalletOfflineCoinPurseUI.this.ALE) {
                                        WalletOfflineCoinPurseUI.this.ALB = false;
                                        WalletOfflineCoinPurseUI.this.ALE = false;
                                        WalletOfflineCoinPurseUI.E(WalletOfflineCoinPurseUI.this);
                                        WalletOfflineCoinPurseUI.F(WalletOfflineCoinPurseUI.this);
                                    }
                                    AppMethodBeat.o(213644);
                                }
                            });
                        }
                        super.addDialog(dialog);
                        AppMethodBeat.o(66492);
                    }

                    private void ezN() {
                        AppMethodBeat.i(66493);
                        if (this.mTipDialog != null && this.mTipDialog.isShowing()) {
                            this.mTipDialog.dismiss();
                        }
                        AppMethodBeat.o(66493);
                    }

                    private void e(ImageView imageView, String str, int i2) {
                        AppMethodBeat.i(66495);
                        if (imageView == null || TextUtils.isEmpty(str)) {
                            AppMethodBeat.o(66495);
                            return;
                        }
                        Bitmap a2 = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str));
                        if (a2 != null) {
                            imageView.setImageBitmap(BitmapUtil.extractThumbNail(a2, i2, i2, true, false));
                        }
                        this.AKR.put(str, imageView);
                        this.AKS.put(str, Integer.valueOf(i2));
                        AppMethodBeat.o(66495);
                    }

                    @Override // com.tencent.mm.platformtools.u.a
                    public final void k(String str, final Bitmap bitmap) {
                        AppMethodBeat.i(66496);
                        if (TextUtils.isEmpty(str) || bitmap == null || bitmap.isRecycled()) {
                            AppMethodBeat.o(66496);
                            return;
                        }
                        final ImageView imageView = (ImageView) this.AKR.get(str);
                        final Integer num = this.AKS.get(str);
                        if (imageView == null || num == null) {
                            AppMethodBeat.o(66496);
                            return;
                        }
                        new MMHandler(getMainLooper()).post(new Runnable() {
                            /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass20 */

                            public final void run() {
                                AppMethodBeat.i(213646);
                                int intValue = num.intValue();
                                imageView.setImageBitmap(BitmapUtil.extractThumbNail(bitmap, intValue, intValue, true, false));
                                AppMethodBeat.o(213646);
                            }
                        });
                        AppMethodBeat.o(66496);
                    }

                    @Override // com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback
                    public void onScreenShot(String str, long j2) {
                        AppMethodBeat.i(213667);
                        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "setScreenShotCallback");
                        TZ(1);
                        sy(true);
                        com.tencent.mm.wallet_core.ui.f.aqm(40);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(135, 21, 1, true);
                        if (this.ALR.kuK.isShowing()) {
                            if (this.ALR.pZM) {
                                this.ALR.hhR();
                                AppMethodBeat.o(213667);
                                return;
                            }
                            this.ALR.dismiss();
                        }
                        ezR();
                        AppMethodBeat.o(213667);
                    }

                    class c extends BaseAdapter {
                        ArrayList<Boolean> AMN = new ArrayList<>();
                        ArrayList<String> mDataList = new ArrayList<>();

                        public c() {
                            AppMethodBeat.i(66446);
                            AppMethodBeat.o(66446);
                        }

                        public final int getCount() {
                            AppMethodBeat.i(66447);
                            int size = this.mDataList.size();
                            AppMethodBeat.o(66447);
                            return size;
                        }

                        public final Object getItem(int i2) {
                            AppMethodBeat.i(66448);
                            String str = this.mDataList.get(i2);
                            AppMethodBeat.o(66448);
                            return str;
                        }

                        public final long getItemId(int i2) {
                            return (long) i2;
                        }

                        public final boolean isEnabled(int i2) {
                            AppMethodBeat.i(66449);
                            boolean booleanValue = this.AMN.get(i2).booleanValue();
                            AppMethodBeat.o(66449);
                            return booleanValue;
                        }

                        public final View getView(int i2, View view, ViewGroup viewGroup) {
                            AppMethodBeat.i(66450);
                            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletOfflineCoinPurseUI.this, R.layout.c9i, null);
                            checkedTextView.setText(this.mDataList.get(i2));
                            if (WalletOfflineCoinPurseUI.oEI == i2) {
                                checkedTextView.setChecked(true);
                            } else {
                                checkedTextView.setChecked(false);
                            }
                            if (isEnabled(i2)) {
                                checkedTextView.setTextColor(WalletOfflineCoinPurseUI.this.getResources().getColor(R.color.a2x));
                                checkedTextView.setEnabled(true);
                            } else {
                                checkedTextView.setTextColor(WalletOfflineCoinPurseUI.this.getResources().getColor(R.color.uj));
                                checkedTextView.setEnabled(false);
                            }
                            AppMethodBeat.o(66450);
                            return checkedTextView;
                        }
                    }

                    public final void ezO() {
                        String string;
                        com.tencent.mm.plugin.wallet_core.model.c cVar;
                        boolean z;
                        boolean z2 = false;
                        AppMethodBeat.i(66498);
                        Bankcard eAm = com.tencent.mm.plugin.offline.c.a.eAm();
                        findViewById(R.id.jid).setVisibility(0);
                        this.ALj.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.is));
                        if (this.ALj != null && eAm != null) {
                            if (eAm.fQg()) {
                                string = eAm.HVY;
                            } else {
                                string = getString(R.string.ium, new Object[]{eAm.field_desc});
                            }
                            List<com.tencent.mm.plugin.wallet_core.model.c> fRF = t.fQI().fRF();
                            if (fRF != null && !Util.isNullOrNil(eAm.field_forbidWord)) {
                                Iterator<com.tencent.mm.plugin.wallet_core.model.c> it = fRF.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    cVar = it.next();
                                    if (cVar.ANo.equals(eAm.field_bindSerial)) {
                                        break;
                                    }
                                }
                            }
                            cVar = null;
                            if (cVar == null || Util.isNullOrNil(cVar.HVn)) {
                                z = false;
                            } else {
                                if (!eAm.fQg()) {
                                    string = eAm.field_desc + cVar.HVn;
                                }
                                findViewById(R.id.jid).setVisibility(8);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14515, 2);
                                this.ALj.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.hc));
                                z = true;
                            }
                            this.ALj.setText(l.b(getContext(), string, this.ALj.getTextSize()));
                            z2 = z;
                        } else if (eAm == null) {
                            Log.e("MicroMsg.WalletOfflineCoinPurseUI", "setChangeBankcardText bankcard == null");
                        }
                        if (eAm != null) {
                            b(eAm);
                        }
                        if (z2) {
                            this.ALk.setEnableColorFilter(true);
                            this.ALk.setIconColor(Color.parseColor("#FA9D3B"));
                            this.ALk.setImageResource(R.raw.icons_filled_error);
                        }
                        AppMethodBeat.o(66498);
                    }

                    private void ezP() {
                        AppMethodBeat.i(66499);
                        Bankcard eAm = com.tencent.mm.plugin.offline.c.a.eAm();
                        if (eAm != null) {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() have bankcard：%s", eAm.field_bindSerial);
                            com.tencent.mm.plugin.offline.c.a.aJk(eAm.field_bindSerial);
                            this.AIf = eAm.field_bindSerial;
                            k.ezn();
                            k.ezp().AIf = this.AIf;
                            AppMethodBeat.o(66499);
                            return;
                        }
                        Log.e("MicroMsg.WalletOfflineCoinPurseUI", "initBindSerial() fail,  bankcard == null");
                        AppMethodBeat.o(66499);
                    }

                    private void ezQ() {
                        AppMethodBeat.i(66500);
                        if (this.ALD) {
                            AppMethodBeat.o(66500);
                        } else if (!this.ALT.TY(4)) {
                            AppMethodBeat.o(66500);
                        } else {
                            com.tencent.mm.kernel.g.aAi();
                            if (!((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue() && !this.ALT.isShowing()) {
                                ezR();
                            }
                            AppMethodBeat.o(66500);
                        }
                    }

                    private void ezR() {
                        AppMethodBeat.i(66501);
                        if (!this.ALT.TY(4)) {
                            AppMethodBeat.o(66501);
                            return;
                        }
                        this.ALT.eE(this.ALd);
                        AppMethodBeat.o(66501);
                    }

                    private void ezS() {
                        AppMethodBeat.i(66502);
                        if (!this.ALT.TY(1)) {
                            AppMethodBeat.o(66502);
                            return;
                        }
                        if (this.ALT.AKt == 1) {
                            this.ALT.dismiss();
                        }
                        boolean fRm = t.fQI().fRm();
                        boolean fRl = t.fQI().fRl();
                        if (fRm || fRl) {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "unreg: %B, simplereg: %B", Boolean.valueOf(fRm), Boolean.valueOf(fRl));
                            this.ALT.a(this.ALd, new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass25 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(184855);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    com.tencent.mm.plugin.offline.c.a.eAw();
                                    k.ezn();
                                    k.bN(196648, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                    WalletOfflineCoinPurseUI.K(WalletOfflineCoinPurseUI.this);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(184855);
                                }
                            }, 1);
                        }
                        AppMethodBeat.o(66502);
                    }

                    private void ezT() {
                        AppMethodBeat.i(66503);
                        if (!this.ALT.TY(3)) {
                            AppMethodBeat.o(66503);
                            return;
                        }
                        if (this.ALT.AKt == 3) {
                            this.ALT.dismiss();
                        }
                        k.ezn();
                        String TX = k.TX(196617);
                        com.tencent.mm.wallet_core.c.b.hhj();
                        boolean isCertExist = com.tencent.mm.wallet_core.c.b.isCertExist(TX);
                        boolean eAj = com.tencent.mm.plugin.offline.c.a.eAj();
                        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "show unopened alert, %B, %B", Boolean.valueOf(isCertExist), Boolean.valueOf(eAj));
                        if (!isCertExist || !eAj) {
                            if (!isCertExist) {
                                com.tencent.mm.kernel.g.aAi();
                                String str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_OFFLINE_IEMI_STRING_SYNC, "");
                                if (str == null || !str.equals(com.tencent.mm.compatible.deviceinfo.q.dr(true))) {
                                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is diff between create and getToken");
                                } else {
                                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", " WalletOfflineEntranceUI iemi is same between create and getToken");
                                }
                                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI CertUtil.getInstance().isCertExist(cn) is false ,cn == " + TX + " ,recreate offline");
                                com.tencent.mm.plugin.offline.c.a.eAw();
                            }
                            this.ALl.setVisibility(4);
                            this.ALT.a(this.ALd, new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass26 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(213650);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    com.tencent.mm.plugin.offline.c.a.j(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.this.mEntryScene);
                                    WalletOfflineCoinPurseUI.this.finish();
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(213650);
                                }
                            }, 3);
                        }
                        AppMethodBeat.o(66503);
                    }

                    private void ezU() {
                        AppMethodBeat.i(66504);
                        if (!this.ALT.TY(5)) {
                            AppMethodBeat.o(66504);
                            return;
                        }
                        if (this.ALT.AKt == 5) {
                            this.ALT.dismiss();
                        }
                        this.ALT.b(this.ALd, new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass27 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(213651);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                k.ezn();
                                k.ezq();
                                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "do get token, %s", Integer.valueOf(com.tencent.mm.plugin.offline.i.ezm()));
                                k.ezn();
                                k.ezq();
                                if (com.tencent.mm.plugin.offline.i.ezm() <= 0) {
                                    WalletOfflineCoinPurseUI.this.doSceneForceProgress(new m(new StringBuilder().append((int) (System.currentTimeMillis() / 1000)).toString(), 10));
                                } else {
                                    WalletOfflineCoinPurseUI.L(WalletOfflineCoinPurseUI.this);
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(213651);
                            }
                        });
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(135, 73, 1, true);
                        AppMethodBeat.o(66504);
                    }

                    public final void ezV() {
                        AppMethodBeat.i(66505);
                        this.ALl.setVisibility(4);
                        this.ALT.a(this.ALd, new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass28 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(213652);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                com.tencent.mm.plugin.offline.c.a.eAw();
                                com.tencent.mm.plugin.offline.c.a.k(WalletOfflineCoinPurseUI.this, WalletOfflineCoinPurseUI.this.mEntryScene);
                                WalletOfflineCoinPurseUI.this.finish();
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(213652);
                            }
                        });
                        AppMethodBeat.o(66505);
                    }

                    private void ezW() {
                        AppMethodBeat.i(213668);
                        if (this.AMc == null || !this.AMc.pTt) {
                            if (this.ALT.AKt == 8) {
                                this.ALT.dismiss();
                            }
                            AppMethodBeat.o(213668);
                        } else if (!this.ALT.TY(8)) {
                            AppMethodBeat.o(213668);
                        } else {
                            if (this.ALT.AKt == 8) {
                                this.ALT.dismiss();
                            }
                            this.ALT.a(this.ALd, this.AMc);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(20258, 1);
                            AppMethodBeat.o(213668);
                        }
                    }

                    private void ezX() {
                        AppMethodBeat.i(66506);
                        if (this.ALT.isShowing() && this.ALT.AKt == 5) {
                            this.ALT.dismiss();
                        }
                        AppMethodBeat.o(66506);
                    }

                    private boolean ezY() {
                        AppMethodBeat.i(66507);
                        if (!this.ALT.TY(2)) {
                            AppMethodBeat.o(66507);
                            return false;
                        }
                        if (this.ALT.AKt == 2) {
                            this.ALT.dismiss();
                        }
                        List<Bankcard> eAq = com.tencent.mm.plugin.offline.c.a.eAq();
                        if (eAq.size() <= 0) {
                            Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
                            AppMethodBeat.o(66507);
                            return false;
                        }
                        for (int i2 = 0; i2 < eAq.size(); i2++) {
                            Bankcard bankcard = eAq.get(i2);
                            if (bankcard != null && bankcard.field_support_micropay && Util.isNullOrNil(bankcard.field_forbidWord)) {
                                AppMethodBeat.o(66507);
                                return true;
                            }
                        }
                        this.ALT.dismiss();
                        this.ALT.a(this.ALd, new Runnable() {
                            /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass30 */

                            public final void run() {
                                AppMethodBeat.i(213654);
                                if (WalletOfflineCoinPurseUI.I(WalletOfflineCoinPurseUI.this)) {
                                    com.tencent.mm.plugin.offline.c.a.a(WalletOfflineCoinPurseUI.this, com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT, -1, WalletOfflineCoinPurseUI.this.getInput());
                                } else {
                                    c cVar = WalletOfflineCoinPurseUI.this.ALS;
                                    com.tencent.mm.plugin.offline.c.a.i(cVar.mActivity, cVar.AKK);
                                }
                                WalletOfflineCoinPurseUI.this.AKX = true;
                                AppMethodBeat.o(213654);
                            }
                        }, new Runnable() {
                            /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass31 */

                            {
                                AppMethodBeat.i(160822);
                                AppMethodBeat.o(160822);
                            }

                            public final void run() {
                                AppMethodBeat.i(213655);
                                WalletOfflineCoinPurseUI.q(WalletOfflineCoinPurseUI.this);
                                AppMethodBeat.o(213655);
                            }
                        });
                        AppMethodBeat.o(66507);
                        return false;
                    }

                    private void sz(boolean z) {
                        AppMethodBeat.i(66508);
                        if (!com.tencent.mm.plugin.offline.c.a.eAj()) {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "unOpen %s", Boolean.valueOf(com.tencent.mm.plugin.offline.c.a.eAj()));
                            AppMethodBeat.o(66508);
                        } else if (com.tencent.mm.plugin.offline.c.a.sB(false).size() <= 0) {
                            Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
                            this.ALj.setVisibility(8);
                            AppMethodBeat.o(66508);
                        } else {
                            final ArrayList<Bankcard> yh = af.yh(true);
                            if (!z || this.ALJ != null) {
                                this.ALJ = null;
                                this.ALJ = new com.tencent.mm.plugin.wallet.ui.a(this);
                            } else {
                                this.ALJ = new com.tencent.mm.plugin.wallet.ui.a(this);
                            }
                            this.ALI = -1;
                            this.ALJ.qAx.bMo();
                            int i2 = 0;
                            Bankcard bankcard = null;
                            int i3 = 0;
                            while (i2 < yh.size()) {
                                Bankcard bankcard2 = yh.get(i2);
                                if (Util.isNullOrNil(bankcard2.field_bindSerial) || !this.AIf.equals(bankcard2.field_bindSerial)) {
                                    bankcard2 = bankcard;
                                } else {
                                    i3 = i2;
                                }
                                i2++;
                                bankcard = bankcard2;
                            }
                            if (bankcard != null) {
                                yh.remove(bankcard);
                                yh.add(0, bankcard);
                                i3 = 0;
                            }
                            this.ALJ.HLX = new o.f() {
                                /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass32 */

                                @Override // com.tencent.mm.ui.base.o.f
                                public final void onCreateMMMenu(final com.tencent.mm.ui.base.m mVar) {
                                    SpannableStringBuilder spannableStringBuilder;
                                    String str;
                                    SpannableStringBuilder spannableStringBuilder2;
                                    boolean z;
                                    AppMethodBeat.i(213658);
                                    mVar.clear();
                                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mmBottomSheet list show");
                                    for (int i2 = 0; i2 < yh.size(); i2++) {
                                        final Bankcard bankcard = (Bankcard) yh.get(i2);
                                        final String aJq = com.tencent.mm.plugin.offline.c.a.aJq(bankcard.field_bankcardType);
                                        if (bankcard.fQc() && bankcard.HVM != null) {
                                            aJq = bankcard.HVM.AAU;
                                        }
                                        Bitmap a2 = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(aJq));
                                        u.a(new u.a() {
                                            /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass32.AnonymousClass1 */

                                            @Override // com.tencent.mm.platformtools.u.a
                                            public final void k(final String str, final Bitmap bitmap) {
                                                AppMethodBeat.i(213656);
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass32.AnonymousClass1.AnonymousClass1 */

                                                    public final void run() {
                                                        AppMethodBeat.i(66427);
                                                        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", str, aJq);
                                                        if (WalletOfflineCoinPurseUI.this.yNN.containsKey(str)) {
                                                            int intValue = ((Integer) WalletOfflineCoinPurseUI.this.yNN.get(str)).intValue();
                                                            if (mVar.getItem(intValue) != null) {
                                                                mVar.getItem(intValue).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(bitmap, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(R.dimen.aov), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(R.dimen.aov), true, false)));
                                                                if (WalletOfflineCoinPurseUI.this.isFinishing() || WalletOfflineCoinPurseUI.this.isDestroyed()) {
                                                                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineCoinPurseUI.this.isFinishing() || WalletOfflineCoinPurseUI.this.isDestroyed()：%s，%s", Boolean.valueOf(WalletOfflineCoinPurseUI.this.isFinishing()), Boolean.valueOf(WalletOfflineCoinPurseUI.this.isDestroyed()));
                                                                    AppMethodBeat.o(66427);
                                                                    return;
                                                                }
                                                                WalletOfflineCoinPurseUI.this.ALJ.fPw();
                                                            }
                                                        }
                                                        AppMethodBeat.o(66427);
                                                    }
                                                });
                                                AppMethodBeat.o(213656);
                                            }
                                        });
                                        String str2 = "";
                                        if (!Util.isNullOrNil(bankcard.field_forbidWord)) {
                                            str2 = bankcard.field_forbidWord;
                                        }
                                        if (Util.isNullOrNil(str2) && !bankcard.field_support_micropay) {
                                            str2 = Util.isNullOrNil(bankcard.field_no_micro_word) ? "" : bankcard.field_no_micro_word;
                                        }
                                        if (Util.isNullOrNil(bankcard.field_forbid_title)) {
                                            spannableStringBuilder = new SpannableStringBuilder(str2);
                                            str = str2;
                                        } else {
                                            String str3 = str2 + " ";
                                            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(str3 + bankcard.field_forbid_title);
                                            AnonymousClass2 r4 = new com.tencent.mm.plugin.wallet_core.ui.l(WalletOfflineCoinPurseUI.this) {
                                                /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass32.AnonymousClass2 */

                                                @Override // com.tencent.mm.plugin.wallet_core.ui.l
                                                public final void onClick(View view) {
                                                    AppMethodBeat.i(66429);
                                                    String str = bankcard.field_forbid_url;
                                                    if (!bankcard.fQg() || !Util.isNullOrNil(str)) {
                                                        Intent intent = new Intent();
                                                        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "go to url %s", str);
                                                        intent.putExtra("rawUrl", str);
                                                        intent.putExtra("geta8key_username", com.tencent.mm.model.z.aTY());
                                                        intent.putExtra("pay_channel", 1);
                                                        com.tencent.mm.wallet_core.ui.f.aA(WalletOfflineCoinPurseUI.this.getContext(), intent);
                                                        AppMethodBeat.o(66429);
                                                        return;
                                                    }
                                                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand");
                                                    wq wqVar = new wq();
                                                    wqVar.ecI.userName = bankcard.Hwr;
                                                    wqVar.ecI.ecK = bankcard.Hws;
                                                    wqVar.ecI.scene = 1137;
                                                    wqVar.ecI.ecL = 0;
                                                    EventCenter.instance.publish(wqVar);
                                                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand result:%s", Boolean.valueOf(wqVar.ecJ.edc));
                                                    if (wqVar.ecJ.edc) {
                                                        WalletOfflineCoinPurseUI.this.ALI = 1;
                                                        WalletOfflineCoinPurseUI.this.ALJ.qAx.bMo();
                                                        AppMethodBeat.o(66429);
                                                        return;
                                                    }
                                                    WalletOfflineCoinPurseUI.this.ALI = 0;
                                                    AppMethodBeat.o(66429);
                                                }
                                            };
                                            int length = str3.length();
                                            int length2 = str3.length() + bankcard.field_forbid_title.length();
                                            spannableStringBuilder3.setSpan(new ForegroundColorSpan(WalletOfflineCoinPurseUI.this.getResources().getColor(R.color.ael)), length, length2, 33);
                                            spannableStringBuilder3.setSpan(r4, length, length2, 33);
                                            spannableStringBuilder = spannableStringBuilder3;
                                            str = str3;
                                        }
                                        if (!Util.isNullOrNil(spannableStringBuilder) || Util.isNullOrNil(bankcard.field_prompt_info_prompt_text)) {
                                            spannableStringBuilder2 = spannableStringBuilder;
                                        } else {
                                            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(bankcard.field_prompt_info_prompt_text);
                                            if (!Util.isNullOrNil(bankcard.field_prompt_info_jump_text) && !Util.isNullOrNil(bankcard.field_prompt_info_jump_url)) {
                                                spannableStringBuilder4.append((CharSequence) bankcard.field_prompt_info_jump_text);
                                                spannableStringBuilder4.setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(new q.a() {
                                                    /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass32.AnonymousClass3 */

                                                    @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
                                                    public final void dF(View view) {
                                                        AppMethodBeat.i(213657);
                                                        com.tencent.mm.wallet_core.ui.f.bn(WalletOfflineCoinPurseUI.this.getContext(), bankcard.field_prompt_info_jump_url);
                                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(20216, 3, bankcard.field_prompt_info_jump_url);
                                                        AppMethodBeat.o(213657);
                                                    }
                                                }), bankcard.field_prompt_info_prompt_text.length(), spannableStringBuilder4.length(), 33);
                                            }
                                            spannableStringBuilder2 = spannableStringBuilder4;
                                        }
                                        String str4 = ((bankcard.fQb() || bankcard.fQc()) && bankcard.HVC >= 0.0d) ? bankcard.field_desc + WalletOfflineCoinPurseUI.this.getString(R.string.i6k, new Object[]{com.tencent.mm.wallet_core.ui.f.D(bankcard.HVC)}) : bankcard.field_desc;
                                        Drawable drawable = null;
                                        if (bankcard.fQf()) {
                                            drawable = com.tencent.mm.svg.a.a.h(WalletOfflineCoinPurseUI.this.getResources(), R.raw.honey_pay_bank_logo);
                                        } else if (a2 != null) {
                                            drawable = new BitmapDrawable(BitmapUtil.extractThumbNail(a2, WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(R.dimen.aov), WalletOfflineCoinPurseUI.this.getResources().getDimensionPixelOffset(R.dimen.aov), true, false));
                                        }
                                        if (drawable == null) {
                                            WalletOfflineCoinPurseUI.this.yNN.put(aJq, Integer.valueOf(i2));
                                        }
                                        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "i %d fee %s %s", Integer.valueOf(i2), str4, spannableStringBuilder2);
                                        if (bankcard.fQg()) {
                                            SpannableString c2 = l.c(WalletOfflineCoinPurseUI.this.getContext(), str4);
                                            if (Util.isNullOrNil(str)) {
                                                if (Util.isNullOrNil(bankcard.HWa)) {
                                                    spannableStringBuilder2 = "";
                                                } else {
                                                    spannableStringBuilder2 = bankcard.HWa;
                                                }
                                            }
                                            if (!Util.isNullOrNil(str)) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            mVar.a(i2, c2, spannableStringBuilder2, drawable, 0, z);
                                        } else {
                                            mVar.a(i2, l.c(WalletOfflineCoinPurseUI.this.getContext(), str4), spannableStringBuilder2, drawable, 0, !Util.isNullOrNil(str));
                                        }
                                    }
                                    AppMethodBeat.o(213658);
                                }
                            };
                            this.ALJ.a(new g.a() {
                                /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass33 */

                                @Override // com.tencent.mm.ui.widget.a.g.a
                                public final void onClick() {
                                    AppMethodBeat.i(213659);
                                    if (WalletOfflineCoinPurseUI.this.ALJ != null) {
                                        WalletOfflineCoinPurseUI.this.ALJ.qAx.bMo();
                                        Bankcard bankcard = (Bankcard) yh.get(WalletOfflineCoinPurseUI.this.ALJ.jKz);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14515, 3);
                                        if (!Util.isNullOrNil(bankcard.field_forbid_title) || !Util.isNullOrNil(bankcard.field_forbidWord) || !bankcard.field_support_micropay) {
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14515, 4);
                                        }
                                        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click mmBottomSheet card：%s", bankcard.field_bindSerial);
                                        WalletOfflineCoinPurseUI.a(WalletOfflineCoinPurseUI.this, bankcard);
                                        if (bankcard != null && bankcard.fQg()) {
                                            WalletOfflineCoinPurseUI.this.ALG = false;
                                            WalletOfflineCoinPurseUI.Ub(3);
                                        }
                                    }
                                    AppMethodBeat.o(213659);
                                }
                            });
                            View inflate = View.inflate(this, R.layout.c9w, null);
                            com.tencent.mm.wallet_core.ui.f.G((TextView) inflate.findViewById(R.id.g3f));
                            inflate.findViewById(R.id.g3a).setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass35 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(213660);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    if (WalletOfflineCoinPurseUI.this.ALJ != null) {
                                        WalletOfflineCoinPurseUI.this.ALJ.qAx.bMo();
                                    }
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(213660);
                                }
                            });
                            this.ALJ.HMf = true;
                            this.ALJ.T(getResources().getString(R.string.ic6));
                            this.ALJ.jKz = i3;
                            this.ALJ.HMg = true;
                            this.ALJ.setTitleView(inflate);
                            this.ALJ.dGm();
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13955, 3);
                            AppMethodBeat.o(66508);
                        }
                    }

                    private static void Ua(int i2) {
                        AppMethodBeat.i(66509);
                        ag agVar = new ag();
                        agVar.enW = i2;
                        agVar.bfK();
                        AppMethodBeat.o(66509);
                    }

                    private void a(Bankcard bankcard) {
                        AppMethodBeat.i(213669);
                        if (bankcard == null) {
                            AppMethodBeat.o(213669);
                            return;
                        }
                        String str = bankcard.field_bindSerial;
                        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "doSelectBackcard tempSerial:%s，mBindSerial：%s", str, this.AIf);
                        if (!TextUtils.isEmpty(str) && !str.equals(this.AIf)) {
                            this.ALc = this.AIf;
                            this.AIf = str;
                            com.tencent.mm.plugin.offline.c.a.aJk(this.AIf);
                            k.ezn();
                            k.ezp().AIf = this.AIf;
                            ezO();
                            TZ(0);
                            sy(true);
                        }
                        AppMethodBeat.o(213669);
                    }

                    @Override // com.tencent.mm.ui.MMActivity
                    public int getForceOrientation() {
                        return 1;
                    }

                    private static void ezZ() {
                        AppMethodBeat.i(66510);
                        if (!com.tencent.mm.plugin.offline.c.a.eAD()) {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, token is invalid, do doNetSceneToken");
                            k.ezn();
                            k.ezq().hE(3, 3);
                        }
                        AppMethodBeat.o(66510);
                    }

                    private void b(Bankcard bankcard) {
                        AppMethodBeat.i(66511);
                        if (TextUtils.isEmpty(this.AIf)) {
                            Log.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() mBindSerial is null");
                            AppMethodBeat.o(66511);
                            return;
                        }
                        this.ALk.setEnableColorFilter(false);
                        if (bankcard.fQf()) {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "show local hy logo");
                            this.ALk.setImageDrawable(com.tencent.mm.svg.a.a.h(getContext().getResources(), R.raw.honey_pay_bank_logo));
                            AppMethodBeat.o(66511);
                            return;
                        }
                        String aJr = com.tencent.mm.plugin.offline.c.a.aJr(this.AIf);
                        if (bankcard.fQc() && bankcard.HVM != null) {
                            aJr = bankcard.HVM.AAU;
                        }
                        if (TextUtils.isEmpty(aJr)) {
                            Log.e("MicroMsg.WalletOfflineCoinPurseUI", "updateBankLogo() icon_url == null, can not find this icon_url");
                            AppMethodBeat.o(66511);
                            return;
                        }
                        e(this.ALk, aJr, getResources().getDimensionPixelOffset(R.dimen.aov));
                        AppMethodBeat.o(66511);
                    }

                    @Override // com.tencent.mm.plugin.offline.b
                    public final void ctk() {
                        AppMethodBeat.i(66512);
                        TZ(0);
                        sy(true);
                        AppMethodBeat.o(66512);
                    }

                    @Override // com.tencent.mm.plugin.offline.ui.a
                    public final void ezx() {
                        AppMethodBeat.i(66515);
                        doSceneProgress(new j(""), false);
                        AppMethodBeat.o(66515);
                    }

                    @Override // com.tencent.mm.plugin.offline.ui.a
                    public final String ezy() {
                        return this.AIf;
                    }

                    private void cAu() {
                        AppMethodBeat.i(66516);
                        bf fQy = com.tencent.mm.plugin.wallet_core.model.k.fQy();
                        StringBuilder append = new StringBuilder().append(this.ALA);
                        com.tencent.mm.kernel.g.aAi();
                        com.tencent.mm.kernel.g.aAf();
                        String mD5String = MD5Util.getMD5String(append.append(p.getString(com.tencent.mm.kernel.a.getUin())).toString());
                        if (fQy != null) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13444, fQy.KED, fQy.KEE, Long.valueOf(fQy.KEC), mD5String, fQy.KEF, fQy.KEG, fQy.KEH);
                        }
                        AppMethodBeat.o(66516);
                    }

                    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
                    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
                        AppMethodBeat.i(66517);
                        if (i2 != 4 || this.ALT == null || this.ALT.getVisibility() != 0 || !this.ALT.AKu) {
                            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
                            AppMethodBeat.o(66517);
                            return onKeyUp;
                        }
                        this.ALT.dismiss();
                        AppMethodBeat.o(66517);
                        return true;
                    }

                    @Override // com.tencent.mm.plugin.offline.ui.a
                    public final void ezz() {
                        AppMethodBeat.i(66518);
                        if (!this.AIN.stopped()) {
                            this.AIN.stopTimer();
                        }
                        TZ(0);
                        sy(true);
                        this.ALB = false;
                        this.AIN.startTimer((long) this.AIM);
                        AppMethodBeat.o(66518);
                    }

                    /* access modifiers changed from: package-private */
                    public abstract class a implements com.tencent.mm.plugin.newtips.a.a {
                        protected TextView AMJ;
                        protected TextView AMK;
                        protected ImageView AML;

                        public abstract void eAf();

                        public a() {
                            eAf();
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final boolean ehp() {
                            return false;
                        }

                        public boolean ehq() {
                            return false;
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final void a(com.tencent.mm.plugin.newtips.a.k kVar, boolean z) {
                            com.tencent.mm.plugin.newtips.a.g.a(this, kVar, z);
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final boolean qV(boolean z) {
                            return com.tencent.mm.plugin.newtips.a.g.a(z, this);
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final boolean qW(boolean z) {
                            if (z) {
                                this.AML.setVisibility(0);
                                return true;
                            }
                            this.AML.setVisibility(8);
                            return true;
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final boolean qX(boolean z) {
                            if (z) {
                                this.AMJ.setVisibility(0);
                                return true;
                            }
                            this.AMJ.setVisibility(8);
                            return true;
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final boolean a(boolean z, ehv ehv) {
                            if (z) {
                                this.AML.setVisibility(0);
                                this.AMK.setVisibility(0);
                                this.AMK.setText(ehv.title);
                                return true;
                            }
                            this.AML.setVisibility(8);
                            this.AMK.setVisibility(8);
                            return true;
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final boolean b(boolean z, ehv ehv) {
                            return false;
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final boolean c(boolean z, ehv ehv) {
                            return false;
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final boolean d(boolean z, ehv ehv) {
                            return false;
                        }
                    }

                    /* access modifiers changed from: package-private */
                    public class e extends a {
                        public e() {
                            super();
                        }

                        @Override // com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.a
                        public final void eAf() {
                            AppMethodBeat.i(66456);
                            WalletOfflineCoinPurseUI.this.ALv = (LinearLayout) WalletOfflineCoinPurseUI.this.findViewById(R.id.jg9);
                            this.AMJ = (TextView) WalletOfflineCoinPurseUI.this.ALv.findViewById(R.id.c8_);
                            this.AMK = (TextView) WalletOfflineCoinPurseUI.this.ALv.findViewById(R.id.c8b);
                            this.AML = (ImageView) WalletOfflineCoinPurseUI.this.ALv.findViewById(R.id.c8a);
                            WalletOfflineCoinPurseUI.this.ALv.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.e.AnonymousClass1 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(66455);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineCollectBtnLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    WalletOfflineCoinPurseUI.this.AMb = false;
                                    com.tencent.mm.plugin.newtips.a.exl().TC(17);
                                    if (com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                                        com.tencent.mm.y.c.axV().c(ar.a.NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
                                        e.this.AMJ.setVisibility(8);
                                        e.this.AMK.setVisibility(8);
                                        e.this.AML.setVisibility(8);
                                        com.tencent.mm.kernel.g.aAi();
                                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_FACING_REDDOT_WORDING_STRING_SYNC, "");
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14396, 3);
                                    }
                                    if (t.fQI().fRk()) {
                                        WalletOfflineCoinPurseUI.Z(WalletOfflineCoinPurseUI.this);
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineCollectBtnLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(66455);
                                        return;
                                    }
                                    t.fQC();
                                    WalletOfflineCoinPurseUI walletOfflineCoinPurseUI = WalletOfflineCoinPurseUI.this;
                                    com.tencent.mm.wallet_core.d.i iVar = WalletOfflineCoinPurseUI.this.mNetSceneMgr;
                                    new a.AbstractC1915a() {
                                        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.e.AnonymousClass1.AnonymousClass1 */

                                        @Override // com.tencent.mm.plugin.wallet_core.id_verify.util.a.AbstractC1915a
                                        public final boolean run(int i2, int i3, String str, boolean z) {
                                            AppMethodBeat.i(66454);
                                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + i2 + ";errCode=" + i3 + ";errMsg=" + str + ";hadAgree = " + z);
                                            if (i2 == 2) {
                                                WalletOfflineCoinPurseUI.this.doSceneProgress(new com.tencent.mm.plugin.wallet_core.id_verify.model.i("collect"), false);
                                            } else if (i2 == 0 && z) {
                                                WalletOfflineCoinPurseUI.this.doSceneProgress(new com.tencent.mm.plugin.wallet_core.id_verify.model.i("collect"), false);
                                            } else if (WalletOfflineCoinPurseUI.this.mTipDialog != null) {
                                                WalletOfflineCoinPurseUI.this.mTipDialog.dismiss();
                                            }
                                            AppMethodBeat.o(66454);
                                            return true;
                                        }
                                    };
                                    if (!t.b(walletOfflineCoinPurseUI, iVar, 1006)) {
                                        WalletOfflineCoinPurseUI.this.doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.id_verify.model.i("collect"));
                                    }
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineCollectBtnLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(66455);
                                }
                            });
                            AppMethodBeat.o(66456);
                        }

                        @Override // com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.a
                        public final boolean ehq() {
                            AppMethodBeat.i(66457);
                            super.ehq();
                            com.tencent.mm.plugin.newtips.a.g.a(this);
                            if (com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                                com.tencent.mm.kernel.g.aAi();
                                String str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_FACING_REDDOT_WORDING_STRING_SYNC, "");
                                if (!Util.isNullOrNil(str)) {
                                    this.AMK.setText(str);
                                    this.AMK.setVisibility(0);
                                    this.AML.setVisibility(0);
                                    com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) this, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE, true);
                                } else {
                                    this.AMJ.setVisibility(0);
                                    com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) this, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_NEW, true);
                                }
                            }
                            AppMethodBeat.o(66457);
                            return true;
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final String getPath() {
                            return "facingreceivereddot";
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final View getRoot() {
                            AppMethodBeat.i(66458);
                            LinearLayout linearLayout = WalletOfflineCoinPurseUI.this.ALv;
                            AppMethodBeat.o(66458);
                            return linearLayout;
                        }
                    }

                    /* access modifiers changed from: package-private */
                    public class g extends a {
                        public g() {
                            super();
                        }

                        @Override // com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.a
                        public final void eAf() {
                            AppMethodBeat.i(66465);
                            WalletOfflineCoinPurseUI.this.ALy = (LinearLayout) WalletOfflineCoinPurseUI.this.findViewById(R.id.jgb);
                            this.AMJ = (TextView) WalletOfflineCoinPurseUI.this.ALy.findViewById(R.id.go1);
                            this.AMK = (TextView) WalletOfflineCoinPurseUI.this.ALy.findViewById(R.id.go3);
                            this.AML = (ImageView) WalletOfflineCoinPurseUI.this.ALy.findViewById(R.id.go2);
                            WalletOfflineCoinPurseUI.this.ALy.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.g.AnonymousClass1 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(66464);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineRewardLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click qr reward");
                                    WalletOfflineCoinPurseUI.this.AMb = false;
                                    com.tencent.mm.plugin.newtips.a.exl().TC(19);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14021, 5, Integer.valueOf(WalletOfflineCoinPurseUI.this.sQn));
                                    if (com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                                        com.tencent.mm.y.c.axV().c(ar.a.NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
                                        g.this.AMJ.setVisibility(8);
                                    }
                                    if (t.fQI().fRk()) {
                                        com.tencent.mm.br.c.V(WalletOfflineCoinPurseUI.this.getContext(), "collect", ".reward.ui.QrRewardMainUI");
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineRewardLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(66464);
                                        return;
                                    }
                                    t.fQC();
                                    WalletOfflineCoinPurseUI walletOfflineCoinPurseUI = WalletOfflineCoinPurseUI.this;
                                    com.tencent.mm.wallet_core.d.i iVar = WalletOfflineCoinPurseUI.this.mNetSceneMgr;
                                    new a.AbstractC1915a() {
                                        /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.g.AnonymousClass1.AnonymousClass1 */

                                        @Override // com.tencent.mm.plugin.wallet_core.id_verify.util.a.AbstractC1915a
                                        public final boolean run(int i2, int i3, String str, boolean z) {
                                            AppMethodBeat.i(66463);
                                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + i2 + ";errCode=" + i3 + ";errMsg=" + str + ";hadAgree = " + z);
                                            if (i2 == 2) {
                                                WalletOfflineCoinPurseUI.this.doSceneProgress(new com.tencent.mm.plugin.wallet_core.id_verify.model.i("reward"), false);
                                            } else if (i2 == 0 && z) {
                                                WalletOfflineCoinPurseUI.this.doSceneProgress(new com.tencent.mm.plugin.wallet_core.id_verify.model.i("reward"), false);
                                            } else if (WalletOfflineCoinPurseUI.this.mTipDialog != null) {
                                                WalletOfflineCoinPurseUI.this.mTipDialog.dismiss();
                                            }
                                            AppMethodBeat.o(66463);
                                            return true;
                                        }
                                    };
                                    if (!t.b(walletOfflineCoinPurseUI, iVar, 1006)) {
                                        WalletOfflineCoinPurseUI.this.doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.id_verify.model.i("reward"));
                                    }
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineRewardLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(66464);
                                }
                            });
                            AppMethodBeat.o(66465);
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final String getPath() {
                            return "rewardcodereddot";
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final View getRoot() {
                            AppMethodBeat.i(66466);
                            LinearLayout linearLayout = WalletOfflineCoinPurseUI.this.ALy;
                            AppMethodBeat.o(66466);
                            return linearLayout;
                        }

                        @Override // com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.a
                        public final boolean ehq() {
                            AppMethodBeat.i(66467);
                            super.ehq();
                            com.tencent.mm.plugin.newtips.a.g.a(this);
                            if (com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                                this.AMJ.setVisibility(0);
                                com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) this, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_NEW, true);
                            }
                            AppMethodBeat.o(66467);
                            return true;
                        }
                    }

                    /* access modifiers changed from: package-private */
                    public class b extends a {
                        public b() {
                            super();
                        }

                        @Override // com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.a
                        public final void eAf() {
                            AppMethodBeat.i(66443);
                            WalletOfflineCoinPurseUI.this.ALw = (LinearLayout) WalletOfflineCoinPurseUI.this.findViewById(R.id.jg6);
                            this.AMJ = (TextView) WalletOfflineCoinPurseUI.this.ALw.findViewById(R.id.ab);
                            this.AMK = (TextView) WalletOfflineCoinPurseUI.this.ALw.findViewById(R.id.am);
                            this.AML = (ImageView) WalletOfflineCoinPurseUI.this.ALw.findViewById(R.id.al);
                            WalletOfflineCoinPurseUI.this.ALw.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.b.AnonymousClass1 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(66442);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineAALayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click aa");
                                    com.tencent.mm.plugin.newtips.a.exl().TC(16);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14021, 3, Integer.valueOf(WalletOfflineCoinPurseUI.this.sQn));
                                    Intent intent = new Intent();
                                    if (WalletOfflineCoinPurseUI.this.gwE == 1) {
                                        intent.putExtra("enter_scene", 2);
                                    } else if (WalletOfflineCoinPurseUI.this.gwE == 2) {
                                        intent.putExtra("enter_scene", 4);
                                    } else {
                                        Log.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", Integer.valueOf(WalletOfflineCoinPurseUI.this.gwE));
                                    }
                                    com.tencent.mm.br.c.b(WalletOfflineCoinPurseUI.this.getContext(), "aa", ".ui.AAEntranceUI", intent);
                                    WalletOfflineCoinPurseUI.this.AMb = false;
                                    if (com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                                        com.tencent.mm.y.c.axV().c(ar.a.NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
                                        b.this.AMJ.setVisibility(8);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14396, 4);
                                    }
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineAALayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(66442);
                                }
                            });
                            AppMethodBeat.o(66443);
                        }

                        @Override // com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.a
                        public final boolean ehq() {
                            AppMethodBeat.i(66444);
                            super.ehq();
                            com.tencent.mm.plugin.newtips.a.g.a(this);
                            if (com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                                this.AMJ.setVisibility(0);
                                com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) this, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_NEW, true);
                            }
                            AppMethodBeat.o(66444);
                            return true;
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final String getPath() {
                            return "grouppayreddot";
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final View getRoot() {
                            AppMethodBeat.i(66445);
                            LinearLayout linearLayout = WalletOfflineCoinPurseUI.this.ALw;
                            AppMethodBeat.o(66445);
                            return linearLayout;
                        }
                    }

                    /* access modifiers changed from: package-private */
                    public class f extends a {
                        public f() {
                            super();
                        }

                        @Override // com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.a
                        public final void eAf() {
                            AppMethodBeat.i(66460);
                            WalletOfflineCoinPurseUI.this.ALx = (LinearLayout) WalletOfflineCoinPurseUI.this.findViewById(R.id.jg_);
                            this.AMJ = (TextView) WalletOfflineCoinPurseUI.this.ALx.findViewById(R.id.c80);
                            this.AMK = (TextView) WalletOfflineCoinPurseUI.this.ALx.findViewById(R.id.c82);
                            this.AML = (ImageView) WalletOfflineCoinPurseUI.this.ALx.findViewById(R.id.c81);
                            WalletOfflineCoinPurseUI.this.ALx.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.f.AnonymousClass1 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(66459);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineF2fLuckyLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click f2f lucky");
                                    WalletOfflineCoinPurseUI.this.AMb = false;
                                    com.tencent.mm.plugin.newtips.a.exl().TC(18);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14021, 4, Integer.valueOf(WalletOfflineCoinPurseUI.this.sQn));
                                    com.tencent.mm.br.c.V(WalletOfflineCoinPurseUI.this.getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
                                    if (com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                                        com.tencent.mm.y.c.axV().c(ar.a.NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
                                        f.this.AMJ.setVisibility(8);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14396, 5);
                                    }
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineF2fLuckyLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(66459);
                                }
                            });
                            AppMethodBeat.o(66460);
                        }

                        @Override // com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.a
                        public final boolean ehq() {
                            AppMethodBeat.i(66461);
                            super.ehq();
                            com.tencent.mm.plugin.newtips.a.g.a(this);
                            if (com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC)) {
                                this.AMJ.setVisibility(0);
                                com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) this, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_NEW, true);
                            }
                            AppMethodBeat.o(66461);
                            return true;
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final String getPath() {
                            return "f2fhongbaoreddot";
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final View getRoot() {
                            AppMethodBeat.i(66462);
                            LinearLayout linearLayout = WalletOfflineCoinPurseUI.this.ALx;
                            AppMethodBeat.o(66462);
                            return linearLayout;
                        }
                    }

                    /* access modifiers changed from: package-private */
                    public class d extends a {
                        public d() {
                            super();
                        }

                        @Override // com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.a
                        public final void eAf() {
                            AppMethodBeat.i(66452);
                            WalletOfflineCoinPurseUI.this.ALz = (LinearLayout) WalletOfflineCoinPurseUI.this.findViewById(R.id.jg7);
                            this.AMJ = (TextView) WalletOfflineCoinPurseUI.this.ALz.findViewById(R.id.a0v);
                            this.AMK = (TextView) WalletOfflineCoinPurseUI.this.ALz.findViewById(R.id.a0x);
                            this.AML = (ImageView) WalletOfflineCoinPurseUI.this.ALz.findViewById(R.id.a0w);
                            WalletOfflineCoinPurseUI.this.ALz.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.d.AnonymousClass1 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(66451);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineBankRemitLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    WalletOfflineCoinPurseUI.this.AMb = false;
                                    com.tencent.mm.g.b.a.lc lcVar = new com.tencent.mm.g.b.a.lc();
                                    lcVar.ejA = 3;
                                    lcVar.bfK();
                                    com.tencent.mm.plugin.newtips.a.exl().TC(20);
                                    com.tencent.mm.plugin.remittance.mobile.a.b.VZ(WalletOfflineCoinPurseUI.this.gwE);
                                    if (WalletOfflineCoinPurseUI.this.ALX) {
                                        com.tencent.mm.br.c.V(WalletOfflineCoinPurseUI.this.getContext(), "remittance", ".mobile.ui.BankMobileRemittanceChooseUI");
                                    } else {
                                        com.tencent.mm.br.c.V(WalletOfflineCoinPurseUI.this.getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
                                    }
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$OfflineBankRemitLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(66451);
                                }
                            });
                            AppMethodBeat.o(66452);
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final String getPath() {
                            return "transfertoreddot";
                        }

                        @Override // com.tencent.mm.plugin.newtips.a.a
                        public final View getRoot() {
                            AppMethodBeat.i(66453);
                            LinearLayout linearLayout = WalletOfflineCoinPurseUI.this.ALz;
                            AppMethodBeat.o(66453);
                            return linearLayout;
                        }
                    }

                    private static int argbColor(long j2) {
                        AppMethodBeat.i(213670);
                        int argb = Color.argb((int) ((j2 >> 24) & 255), (int) ((j2 >> 16) & 255), (int) ((j2 >> 8) & 255), (int) (255 & j2));
                        AppMethodBeat.o(213670);
                        return argb;
                    }

                    private void eAa() {
                        AppMethodBeat.i(213671);
                        List<Bankcard> sB = com.tencent.mm.plugin.offline.c.a.sB(false);
                        if (sB.size() <= 0) {
                            Log.e("MicroMsg.WalletOfflineCoinPurseUI", "getBindBankCardList == null or size < 1");
                            AppMethodBeat.o(213671);
                            return;
                        }
                        for (int i2 = 0; i2 < sB.size(); i2++) {
                            Bankcard bankcard = sB.get(i2);
                            if (!Util.isNullOrNil(bankcard.field_bindSerial) && this.ALb.equals(bankcard.field_bindSerial)) {
                                a(bankcard);
                                this.ALb = "";
                                Log.i("MicroMsg.WalletOfflineCoinPurseUI", "find the mBindSerialOperation");
                            }
                        }
                        if (this.AMf == null) {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "mJsApiOfflineUserBindQueryResultCallBackEventEvent == null");
                            AppMethodBeat.o(213671);
                            return;
                        }
                        if (!Util.isNullOrNil(this.ALb)) {
                            this.AMf.dQh.errMsg = "fail:no find operation bindSerial";
                        } else {
                            this.AMf.dQh.errMsg = "ok:open success";
                        }
                        this.AMf.dQg.callback.run();
                        this.AMf = null;
                        this.ALb = "";
                        AppMethodBeat.o(213671);
                    }

                    private static boolean eAb() {
                        AppMethodBeat.i(213672);
                        com.tencent.mm.kernel.g.aAi();
                        int intValue = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_OFFLINE_FQF_SETTING_STATE_INT_SYNC, (Object) 1)).intValue();
                        Log.i("MicroMsg.WalletOfflineCoinPurseUI", "fqfCardSettingState is :%s", Integer.valueOf(intValue));
                        switch (intValue) {
                            case 0:
                            case 1:
                                AppMethodBeat.o(213672);
                                return false;
                            case 2:
                                AppMethodBeat.o(213672);
                                return true;
                            default:
                                AppMethodBeat.o(213672);
                                return false;
                        }
                    }

                    private static boolean eAc() {
                        AppMethodBeat.i(213673);
                        Bankcard eAm = com.tencent.mm.plugin.offline.c.a.eAm();
                        if (eAm == null || !eAm.fQg()) {
                            AppMethodBeat.o(213673);
                            return false;
                        }
                        AppMethodBeat.o(213673);
                        return true;
                    }

                    @Override // com.tencent.mm.plugin.offline.ui.a
                    public final void f(int i2, String str, String str2, String str3) {
                        AppMethodBeat.i(66513);
                        doSceneProgress(new com.tencent.mm.plugin.offline.a.e(i2, str, str2, str3), com.tencent.mm.plugin.offline.c.a.eAk());
                        AppMethodBeat.o(66513);
                    }

                    @Override // com.tencent.mm.plugin.offline.ui.a
                    public final void ezw() {
                        AppMethodBeat.i(66514);
                        sz(false);
                        AppMethodBeat.o(66514);
                    }

                    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
                    public /* synthetic */ Dialog onCreateDialog(final int i2) {
                        AppMethodBeat.i(66519);
                        View inflate = getLayoutInflater().inflate(R.layout.c9h, (ViewGroup) null);
                        ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(R.id.h4);
                        if (this.AKV == null) {
                            this.AKV = new c();
                        }
                        if (i2 == 1) {
                            c cVar = this.AKV;
                            ArrayList<String> arrayList = this.AKY;
                            ArrayList<Boolean> arrayList2 = this.ALa;
                            if (arrayList != null) {
                                cVar.mDataList.clear();
                                cVar.mDataList.addAll(arrayList);
                            }
                            if (arrayList2 != null) {
                                cVar.AMN.clear();
                                cVar.AMN.addAll(arrayList2);
                            }
                        }
                        listViewInScrollView.setAdapter((ListAdapter) this.AKV);
                        this.AKV.notifyDataSetChanged();
                        listViewInScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass21 */

                            @Override // android.widget.AdapterView.OnItemClickListener
                            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                                AppMethodBeat.i(213647);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(adapterView);
                                bVar.bm(view);
                                bVar.pH(i2);
                                bVar.zo(j2);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$28", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                                WalletOfflineCoinPurseUI.this.dismissDialog(i2);
                                int unused = WalletOfflineCoinPurseUI.oEI = i2;
                                if (i2 == 1) {
                                    String str = (String) WalletOfflineCoinPurseUI.this.AKZ.get(i2);
                                    if (!TextUtils.isEmpty(str) && !str.equals(WalletOfflineCoinPurseUI.this.AIf)) {
                                        WalletOfflineCoinPurseUI.this.AIf = str;
                                        com.tencent.mm.plugin.offline.c.a.aJk(WalletOfflineCoinPurseUI.this.AIf);
                                        k.ezn();
                                        k.ezp().AIf = WalletOfflineCoinPurseUI.this.AIf;
                                        WalletOfflineCoinPurseUI.this.ezO();
                                        WalletOfflineCoinPurseUI.E(WalletOfflineCoinPurseUI.this);
                                        WalletOfflineCoinPurseUI.F(WalletOfflineCoinPurseUI.this);
                                    }
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/WalletOfflineCoinPurseUI$28", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                                AppMethodBeat.o(213647);
                            }
                        });
                        d.a aVar = new d.a(this);
                        if (i2 == 1) {
                            aVar.aoO(R.string.iuo);
                        }
                        aVar.hs(inflate);
                        aVar.f(null);
                        com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
                        AppMethodBeat.o(66519);
                        return hbn;
                    }

                    static /* synthetic */ boolean a(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, s.h hVar) {
                        AppMethodBeat.i(213677);
                        if ("1".equals(hVar.egd)) {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "need realname verify");
                            Bundle bundle = new Bundle();
                            bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOfflineCoinPurseUI");
                            bundle.putString("realname_verify_process_jump_plugin", "offline");
                            walletOfflineCoinPurseUI.isTransparent();
                            boolean a2 = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(walletOfflineCoinPurseUI, bundle, null, 0);
                            AppMethodBeat.o(213677);
                            return a2;
                        } else if ("2".equals(hVar.egd)) {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "need upload credit");
                            boolean a3 = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) walletOfflineCoinPurseUI, hVar.ege, hVar.egh, hVar.egf, hVar.egg, false, (DialogInterface.OnClickListener) null);
                            AppMethodBeat.o(213677);
                            return a3;
                        } else {
                            Log.i("MicroMsg.WalletOfflineCoinPurseUI", "realnameGuideFlag =  " + hVar.egd);
                            AppMethodBeat.o(213677);
                            return false;
                        }
                    }

                    static /* synthetic */ void h(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
                        AppMethodBeat.i(213678);
                        walletOfflineCoinPurseUI.ALT.getVisibility();
                        AppMethodBeat.o(213678);
                    }

                    static /* synthetic */ void o(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
                        AppMethodBeat.i(213679);
                        com.tencent.mm.ui.base.h.b(walletOfflineCoinPurseUI.getContext(), null, walletOfflineCoinPurseUI.getResources().getStringArray(R.array.aw), null, new h.d() {
                            /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass17 */

                            @Override // com.tencent.mm.ui.base.h.d
                            public final void oj(int i2) {
                                AppMethodBeat.i(213643);
                                switch (i2) {
                                    case 0:
                                        com.tencent.mm.plugin.offline.c.a.gK(WalletOfflineCoinPurseUI.this);
                                        AppMethodBeat.o(213643);
                                        return;
                                    case 1:
                                        c cVar = WalletOfflineCoinPurseUI.this.ALS;
                                        if (((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).fUF()) {
                                            com.tencent.mm.ui.base.h.c(cVar.mActivity, cVar.getString(R.string.iuw), "", cVar.getString(R.string.iuv), cVar.getString(R.string.sz), new DialogInterface.OnClickListener() {
                                                /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass9 */

                                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                                    AppMethodBeat.i(66378);
                                                    dialogInterface.dismiss();
                                                    com.tencent.mm.plugin.offline.c.a.eAw();
                                                    com.tencent.mm.ui.base.h.cD(c.this.mActivity, c.this.mActivity.getResources().getString(R.string.iuz));
                                                    c.a(c.this);
                                                    AppMethodBeat.o(66378);
                                                }
                                            }, new DialogInterface.OnClickListener() {
                                                /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass10 */

                                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                                    AppMethodBeat.i(66379);
                                                    dialogInterface.dismiss();
                                                    AppMethodBeat.o(66379);
                                                }
                                            });
                                            break;
                                        } else {
                                            com.tencent.mm.ui.base.h.c(cVar.mActivity, cVar.getString(R.string.iuy), "", cVar.getString(R.string.ivw), cVar.getString(R.string.iuv), new DialogInterface.OnClickListener() {
                                                /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass7 */

                                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                                    AppMethodBeat.i(66376);
                                                    ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).j(c.this.mActivity, new Intent());
                                                    AppMethodBeat.o(66376);
                                                }
                                            }, new DialogInterface.OnClickListener() {
                                                /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass8 */

                                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                                    AppMethodBeat.i(66377);
                                                    dialogInterface.dismiss();
                                                    com.tencent.mm.plugin.offline.c.a.eAw();
                                                    com.tencent.mm.ui.base.h.cD(c.this.mActivity, c.this.mActivity.getResources().getString(R.string.iuz));
                                                    c.a(c.this);
                                                    AppMethodBeat.o(66377);
                                                }
                                            });
                                            AppMethodBeat.o(213643);
                                            return;
                                        }
                                }
                                AppMethodBeat.o(213643);
                            }
                        });
                        AppMethodBeat.o(213679);
                    }

                    static /* synthetic */ void q(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
                        AppMethodBeat.i(213680);
                        walletOfflineCoinPurseUI.sz(false);
                        AppMethodBeat.o(213680);
                    }

                    static /* synthetic */ boolean I(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
                        AppMethodBeat.i(213688);
                        com.tencent.mm.wallet_core.b.hgC();
                        if (com.tencent.mm.wallet_core.b.b(b.a.clicfg_open_kinda_bind_card, true)) {
                            Log.d("MicroMsg.WalletOfflineCoinPurseUI", "startKindaBindCard:true");
                            EventCenter.instance.add(walletOfflineCoinPurseUI.AJa);
                            AppMethodBeat.o(213688);
                            return true;
                        }
                        Log.d("MicroMsg.WalletOfflineCoinPurseUI", "startKindaBindCard:false");
                        AppMethodBeat.o(213688);
                        return false;
                    }

                    static /* synthetic */ void K(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
                        AppMethodBeat.i(213689);
                        com.tencent.mm.ui.base.h.a((Context) walletOfflineCoinPurseUI, false, walletOfflineCoinPurseUI.getString(R.string.iue), "", walletOfflineCoinPurseUI.getString(R.string.iut), walletOfflineCoinPurseUI.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass22 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(213648);
                                dialogInterface.dismiss();
                                if (WalletOfflineCoinPurseUI.I(WalletOfflineCoinPurseUI.this)) {
                                    com.tencent.mm.plugin.offline.c.a.a(WalletOfflineCoinPurseUI.this, 0, WalletOfflineCoinPurseUI.this.mEntryScene, WalletOfflineCoinPurseUI.this.getInput());
                                } else {
                                    com.tencent.mm.plugin.offline.c.a.a(WalletOfflineCoinPurseUI.this, 0, WalletOfflineCoinPurseUI.this.mEntryScene);
                                }
                                WalletOfflineCoinPurseUI.this.AKX = true;
                                Log.v("MicroMsg.WalletOfflineCoinPurseUI", "WalletOfflineEntranceUI startBindProcess()");
                                AppMethodBeat.o(213648);
                            }
                        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.AnonymousClass24 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(213649);
                                dialogInterface.dismiss();
                                AppMethodBeat.o(213649);
                            }
                        });
                        AppMethodBeat.o(213689);
                    }
                }
