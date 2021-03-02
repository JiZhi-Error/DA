package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.d;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.appbrand.ad.a.h;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.g.o;
import com.tencent.mm.plugin.sns.data.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.pluginsdk.ui.tools.v;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.s;

@a(3)
public class SnsSightPlayerUI extends MMActivity implements d.a, c.b {
    private TextView DnJ = null;
    private boolean DnK = false;
    ViewGroup DnT;
    private int Dne = 0;
    private int Doa = 0;
    private int Dob = 0;
    public int Doi = 0;
    private SnsInfo DsC = null;
    private ADInfo DyO = null;
    private float EAC = 1.0f;
    private int EAD = 0;
    private int EAE = 0;
    private boolean EHl = false;
    private boolean EHq = false;
    private boolean EHr = false;
    private boolean EHs = false;
    private String EJi = "";
    private TextView EJj = null;
    private MMPinProgressBtn EJk = null;
    private String EJl = "";
    private RelativeLayout EJm;
    View.OnCreateContextMenuListener EJn = new View.OnCreateContextMenuListener() {
        /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass5 */

        /* JADX WARNING: Removed duplicated region for block: B:10:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0060  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCreateContextMenu(android.view.ContextMenu r11, android.view.View r12, android.view.ContextMenu.ContextMenuInfo r13) {
            /*
            // Method dump skipped, instructions count: 179
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass5.onCreateContextMenu(android.view.ContextMenu, android.view.View, android.view.ContextMenu$ContextMenuInfo):void");
        }
    };
    private l EzN = new l("SnsSightPlayerUI");
    private float aZg = 0.0f;
    private float aZh = 0.0f;
    public com.tencent.mm.ui.tools.l contextMenuHelper;
    private String dJX = "";
    private int duration = 0;
    private cnb ebR = null;
    private int eeF = 0;
    private String fullPath = "";
    private boolean iGD = false;
    private String imagePath = "";
    private boolean isAd = false;
    private boolean isAnimated = false;
    private boolean isInit = false;
    private ImageView jUG;
    private GestureDetector mDJ;
    private VelocityTracker mVelocityTracker;
    private d pNk;
    o.g pso = new o.g() {
        /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass6 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(99085);
            switch (menuItem.getItemId()) {
                case 1:
                    Intent intent = new Intent();
                    SnsInfo aQm = aj.faO().aQm(SnsSightPlayerUI.this.dJX);
                    if (aQm != null) {
                        Log.i("MicroMsg.SnsSightPlayerUI", "expose id " + aQm.getSnsId());
                    }
                    intent.putExtra("k_expose_msg_id", aQm == null ? 0 : aQm.getSnsId());
                    intent.putExtra("k_username", aQm == null ? "" : aQm.field_userName);
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format(e.C2115e.OyU, 33));
                    com.tencent.mm.br.c.b(SnsSightPlayerUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(99085);
                    return;
                case 2:
                    SnsInfo aQm2 = aj.faO().aQm(SnsSightPlayerUI.this.dJX);
                    if (aQm2 == null) {
                        AppMethodBeat.o(99085);
                        return;
                    }
                    cz czVar = new cz();
                    com.tencent.mm.plugin.sns.l.a.a(czVar, aQm2);
                    czVar.dFZ.activity = SnsSightPlayerUI.this;
                    czVar.dFZ.dGf = 17;
                    EventCenter.instance.publish(czVar);
                    if (SnsSightPlayerUI.this.isAd) {
                        r.a(new SnsAdClick(SnsSightPlayerUI.this.source, 5, aQm2.field_snsId, 11, 0));
                        com.tencent.mm.plugin.sns.ad.g.o.a(o.d.Sight, o.c.Fav, o.e.Full, 0, aQm2, SnsSightPlayerUI.this.source);
                    }
                    if (SnsSightPlayerUI.this.source == 0) {
                        vj vjVar = new vj();
                        vjVar.ebG.dHp = aQm2.getLocalid();
                        vjVar.ebG.dRS = r.v(aQm2);
                        EventCenter.instance.publish(vjVar);
                    }
                    AppMethodBeat.o(99085);
                    return;
                case 3:
                    SnsSightPlayerUI.this.EHl = true;
                    Intent intent2 = new Intent();
                    intent2.putExtra("Select_Conv_Type", 3);
                    intent2.putExtra("select_is_ret", true);
                    intent2.putExtra("mutil_select_is_ret", true);
                    intent2.putExtra("image_path", SnsSightPlayerUI.this.imagePath);
                    intent2.putExtra("Retr_Msg_Type", 11);
                    com.tencent.mm.br.c.c(SnsSightPlayerUI.this, ".ui.transmit.SelectConversationUI", intent2, 4097);
                    AppMethodBeat.o(99085);
                    return;
                case 4:
                    SnsInfo aQm3 = aj.faO().aQm(SnsSightPlayerUI.this.dJX);
                    if (aQm3 == null) {
                        AppMethodBeat.o(99085);
                        return;
                    }
                    Intent intent3 = new Intent();
                    if (aQm3.getTimeLine().ContentObj.LoU != 15 || aQm3.getTimeLine().ContentObj.LoV.get(0) != null) {
                        intent3.putExtra("exdevice_open_scene_type", 2);
                        intent3.putExtra("sns_local_id", SnsSightPlayerUI.this.dJX);
                        intent3.putExtra("sns_send_data_ui_activity", true);
                        com.tencent.mm.br.c.f(SnsSightPlayerUI.this, ".ui.chatting.ChattingSendDataToDeviceUI", intent3);
                        break;
                    } else {
                        Log.w("MicroMsg.SnsSightPlayerUI", "send sight fail, mediaObj is null");
                        AppMethodBeat.o(99085);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(99085);
        }
    };
    Bundle qaD;
    com.tencent.mm.ui.tools.e qaE;
    private int qaF = 0;
    private int qaG = 0;
    private int qaH = 0;
    private int qaI = 0;
    j qbJ = null;
    private int source = 0;
    private int tex = 0;
    private TextView thO = null;
    private boolean thR = false;
    private String thumbPath = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsSightPlayerUI() {
        AppMethodBeat.i(99100);
        AppMethodBeat.o(99100);
    }

    static /* synthetic */ void a(SnsSightPlayerUI snsSightPlayerUI, boolean z) {
        AppMethodBeat.i(99116);
        snsSightPlayerUI.uF(z);
        AppMethodBeat.o(99116);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        ADInfo aDInfo;
        boolean z;
        AppMethodBeat.i(99101);
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        this.source = getIntent().getIntExtra("intent_from_scene", -1);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        hideTitleView();
        aj.faJ().a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.fm));
        }
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(1024, 1024);
        }
        this.qaD = bundle;
        this.pNk = new d();
        this.fullPath = getIntent().getStringExtra("intent_videopath");
        this.imagePath = getIntent().getStringExtra("intent_thumbpath");
        this.dJX = getIntent().getStringExtra("intent_localid");
        this.isAd = getIntent().getBooleanExtra("intent_isad", false);
        this.DsC = aj.faO().aQm(this.dJX);
        if (this.isAd) {
            if (this.DsC == null) {
                z = false;
            } else {
                this.ebR = this.DsC.getTimeLine().ContentObj.LoV.get(0);
                String ki = ar.ki(aj.getAccSnsPath(), this.ebR.Id);
                this.EJl = ki + r.k(this.ebR);
                this.thumbPath = ki + r.e(this.ebR);
                z = true;
            }
            if (!z) {
                finish();
                AppMethodBeat.o(99101);
                return;
            }
        }
        if (com.tencent.mm.q.a.Xi() != null) {
            com.tencent.mm.q.a.Xi().akr();
        }
        if (this.DsC == null) {
            aDInfo = null;
        } else if (this.source == 2) {
            aDInfo = this.DsC.getAtAdInfo();
        } else {
            aDInfo = this.DsC.getAdInfo();
        }
        this.DyO = aDInfo;
        this.EzN.DvQ = Util.currentTicks();
        this.EJm = (RelativeLayout) findViewById(R.id.bf6);
        this.EJm.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(99078);
                SnsSightPlayerUI.this.cvQ();
                AppMethodBeat.o(99078);
                return true;
            }
        });
        Log.d("MicroMsg.SnsSightPlayerUI", f.app() + " initView: fullpath:" + this.fullPath + ", imagepath:" + this.imagePath);
        this.qaE = new com.tencent.mm.ui.tools.e(getContext());
        this.jUG = (ImageView) findViewById(R.id.dcj);
        this.DnJ = (TextView) findViewById(R.id.ipe);
        this.EJk = (MMPinProgressBtn) findViewById(R.id.hrm);
        this.DnT = (ViewGroup) findViewById(R.id.j44);
        this.qbJ = v.iE(getContext());
        if (this.qbJ instanceof VideoSightView) {
            ((VideoSightView) this.qbJ).setIsAdVideo(this.isAd);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.thO = (TextView) findViewById(R.id.hqu);
        this.thO.setTextColor(Color.parseColor("#888888"));
        this.DnT.addView((View) this.qbJ, 0, layoutParams);
        this.EJj = (TextView) findViewById(R.id.imt);
        this.EJj.setText("");
        if (!this.isAd) {
            this.EJj.setVisibility(8);
        }
        if (this.isAd) {
            if (this.ebR == null) {
                this.thO.setVisibility(8);
            } else if (Util.isNullOrNil(this.ebR.MsF)) {
                Log.i("MicroMsg.SnsSightPlayerUI", "onCreate: there is no attachurl, show more info btn");
                final TimeLineObject timeLine = this.DsC.getTimeLine();
                ADXml adXml = this.DsC.getAdXml();
                String str = adXml.attachShareLinkWording;
                final String str2 = adXml.attachShareLinkUrl;
                if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
                    this.thO.setVisibility(8);
                } else {
                    this.thO.setVisibility(0);
                    this.thO.setText(str);
                    this.thO.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass7 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(99087);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (o.b.Sight.value != 0) {
                                com.tencent.mm.plugin.sns.ad.g.o.a(o.a.DetailInVideo, timeLine.Id, SnsSightPlayerUI.this.DyO == null ? "" : SnsSightPlayerUI.this.DyO.uxInfo, 1, o.b.Sight.value, timeLine.UserName, null, timeLine.Id, 0, 0, 0);
                            }
                            final Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putString("key_snsad_statextstr", timeLine.statExtStr);
                            String str = str2;
                            if (SnsSightPlayerUI.this.DyO != null) {
                                str = r.kb(str, SnsSightPlayerUI.this.DyO.uxInfo);
                            }
                            intent.putExtra("jsapiargs", bundle);
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("useJs", true);
                            r.a(new SnsAdClick(SnsSightPlayerUI.this.source, 5, SnsSightPlayerUI.this.DsC.field_snsId, 18, 0));
                            new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass7.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(99086);
                                    com.tencent.mm.plugin.sns.c.a.jRt.i(intent, SnsSightPlayerUI.this);
                                    SnsSightPlayerUI.this.finish();
                                    AppMethodBeat.o(99086);
                                }
                            });
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(99087);
                        }
                    });
                }
            } else {
                String string = getResources().getString(R.string.h4h);
                if (this.ebR.ERX / 60 > 0) {
                    string = string + getResources().getString(R.string.h4j, Integer.valueOf(this.ebR.ERX / 60));
                }
                if (this.ebR.ERX % 60 > 0) {
                    string = string + getResources().getString(R.string.h4k, Integer.valueOf(this.ebR.ERX % 60));
                }
                this.thO.setText(string + getResources().getString(R.string.h4i));
                this.thO.setVisibility(0);
                this.thO.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass8 */

                    public final void onClick(View view) {
                        String str;
                        String str2;
                        k tP;
                        k tP2;
                        AppMethodBeat.i(99088);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (SnsSightPlayerUI.this.DsC.isAd()) {
                            com.tencent.mm.plugin.sns.ad.g.o.a(o.b.Sight, o.a.EnterCompleteVideo, SnsSightPlayerUI.this.DsC, SnsSightPlayerUI.this.source);
                        }
                        Intent intent = new Intent();
                        String ki = ar.ki(aj.getAccSnsPath(), SnsSightPlayerUI.this.ebR.Id);
                        String k = r.k(SnsSightPlayerUI.this.ebR);
                        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ad_landing_page_new_stream_video, 0) > 0) {
                            intent.setClass(SnsSightPlayerUI.this, SnsAdStreamVideoPlayUI.class);
                            Log.i("MicroMsg.SnsSightPlayerUI", "use new stream video play UI");
                        } else {
                            intent.setClass(SnsSightPlayerUI.this, VideoAdPlayerUI.class);
                        }
                        intent.putExtra("KFullVideoPath", ki + k);
                        intent.putExtra("KThumbPath", SnsSightPlayerUI.this.imagePath);
                        intent.putExtra("KFromTimeLine", true);
                        intent.putExtra("KStremVideoUrl", SnsSightPlayerUI.this.ebR.MsF);
                        intent.putExtra("KThumUrl", Util.isNullOrNil(SnsSightPlayerUI.this.ebR.MsI) ? SnsSightPlayerUI.this.ebR.Msz : SnsSightPlayerUI.this.ebR.MsI);
                        intent.putExtra("KMediaId", SnsSightPlayerUI.this.ebR.Id);
                        intent.putExtra("KUrl", SnsSightPlayerUI.this.ebR.Url);
                        intent.putExtra("KViewId", SnsSightPlayerUI.this.DyO.viewId);
                        TimeLineObject timeLine = SnsSightPlayerUI.this.DsC.getTimeLine();
                        if (SnsSightPlayerUI.this.DyO == null) {
                            str = "";
                        } else {
                            str = SnsSightPlayerUI.this.DyO.uxInfo;
                        }
                        intent.putExtra("KSta_StremVideoAduxInfo", str);
                        intent.putExtra("KSta_StremVideoPublishId", timeLine.Id);
                        intent.putExtra("KSta_SourceType", 1);
                        intent.putExtra("KSta_Scene", o.b.Sight.value);
                        intent.putExtra("KSta_FromUserName", timeLine.UserName);
                        intent.putExtra("KSta_SnSId", timeLine.Id);
                        intent.putExtra("KSta_SnsStatExtStr", timeLine.statExtStr);
                        intent.putExtra("KMediaVideoTime", SnsSightPlayerUI.this.ebR.ERX);
                        if (Util.isNullOrNil(SnsSightPlayerUI.this.ebR.MsJ)) {
                            str2 = timeLine.ContentDesc;
                        } else {
                            str2 = SnsSightPlayerUI.this.ebR.MsJ;
                        }
                        intent.putExtra("KMediaTitle", str2);
                        ADXml adXml = SnsSightPlayerUI.this.DsC.getAdXml();
                        if (adXml != null && adXml.attachShareLinkIsHidden == 0) {
                            intent.putExtra("StreamWording", adXml.attachShareLinkWording);
                            intent.putExtra("StremWebUrl", adXml.attachShareLinkUrl);
                        }
                        SnsInfo aQm = aj.faO().aQm(SnsSightPlayerUI.this.dJX);
                        if (SnsSightPlayerUI.this.source == 0) {
                            tP = k.tO(av.CTRL_INDEX);
                        } else {
                            tP = k.tP(av.CTRL_INDEX);
                        }
                        tP.PH(r.v(aQm)).tR(aQm.field_type).fL(true).PH(aQm.getUxinfo()).tR(SnsSightPlayerUI.this.ebR.ERX);
                        tP.bfK();
                        if (SnsSightPlayerUI.this.source == 0) {
                            tP2 = k.tO(h.CTRL_INDEX);
                        } else {
                            tP2 = k.tP(h.CTRL_INDEX);
                        }
                        tP2.PH(r.v(aQm)).tR(aQm.field_type).fL(true).PH(aQm.getUxinfo()).tR(SnsSightPlayerUI.this.ebR.ERX);
                        tP2.b(intent, "intent_key_StatisticsOplog");
                        SnsSightPlayerUI snsSightPlayerUI = SnsSightPlayerUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(snsSightPlayerUI, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        snsSightPlayerUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(snsSightPlayerUI, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        r.a(new SnsAdClick(SnsSightPlayerUI.this.source, 5, aQm.field_snsId, 14, 0));
                        if (SnsSightPlayerUI.this.source == 0) {
                            vb vbVar = new vb();
                            vbVar.ebt.isStart = true;
                            EventCenter.instance.publish(vbVar);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(99088);
                    }
                });
            }
            u.a(this.thO, (VideoSightView) this.qbJ);
        } else {
            this.thO.setVisibility(8);
        }
        this.qbJ.setVideoCallback(new j.a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass9 */

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void tf() {
                AppMethodBeat.i(99091);
                Log.d("MicroMsg.SnsSightPlayerUI", f.app() + " onPrepared");
                SnsSightPlayerUI.a(SnsSightPlayerUI.this, true);
                AppMethodBeat.o(99091);
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void onError(int i2, int i3) {
                AppMethodBeat.i(99092);
                Log.e("MicroMsg.SnsSightPlayerUI", "on play video error, what %d extra %d", Integer.valueOf(i2), Integer.valueOf(i3));
                SnsSightPlayerUI.this.qbJ.stop();
                if (SnsSightPlayerUI.this.thR) {
                    AppMethodBeat.o(99092);
                    return;
                }
                SnsSightPlayerUI.this.thR = true;
                CrashReportFactory.reportRawMessage(Base64.encodeToString((com.tencent.mm.plugin.sight.base.e.eVv() + "[SnsSightPlayerUI] on play video error, what " + i2 + " extra " + i3 + ", path=" + Util.nullAs(SnsSightPlayerUI.this.imagePath, "")).getBytes(), 2), "FullScreenPlaySight");
                final String str = SnsSightPlayerUI.this.imagePath;
                i bcR = q.bcR();
                float density = com.tencent.mm.cb.a.getDensity(SnsSightPlayerUI.this.getContext());
                SnsSightPlayerUI.this.getContext();
                final Bitmap a2 = bcR.a(str, density, -1);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass9.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(99089);
                        ImageView imageView = (ImageView) SnsSightPlayerUI.this.findViewById(R.id.j73);
                        if (imageView != null) {
                            imageView.setImageBitmap(a2);
                            imageView.setVisibility(0);
                        }
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        FileProviderHelper.setIntentDataAndType((Context) SnsSightPlayerUI.this.getContext(), intent, new com.tencent.mm.vfs.o(str), "video/*", false);
                        try {
                            AppCompatActivity context = SnsSightPlayerUI.this.getContext();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(Intent.createChooser(intent, SnsSightPlayerUI.this.getContext().getString(R.string.cd1)));
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$4$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$4$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(99089);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.SnsSightPlayerUI", "startActivity fail, activity not found");
                            com.tencent.mm.ui.base.h.n(SnsSightPlayerUI.this.getContext(), R.string.caa, R.string.cab);
                            AppMethodBeat.o(99089);
                        }
                    }
                });
                AppMethodBeat.o(99092);
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void onCompletion() {
                AppMethodBeat.i(99093);
                Log.d("MicroMsg.SnsSightPlayerUI", "on completion");
                if (!SnsSightPlayerUI.this.isAd) {
                    SnsSightPlayerUI.this.DnJ.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass9.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(99090);
                            if (SnsSightPlayerUI.this.DnJ.getVisibility() != 0) {
                                SnsSightPlayerUI.this.DnJ.setVisibility(0);
                                SnsSightPlayerUI.this.DnJ.startAnimation(AnimationUtils.loadAnimation(SnsSightPlayerUI.this.getContext(), R.anim.br));
                            }
                            AppMethodBeat.o(99090);
                        }
                    });
                }
                SnsSightPlayerUI.this.qbJ.setLoop(true);
                SnsSightPlayerUI.this.EzN.DvW.DwX++;
                SnsSightPlayerUI.a(SnsSightPlayerUI.this, false);
                AppMethodBeat.o(99093);
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final int fh(int i2, int i3) {
                return 0;
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void eo(int i2, int i3) {
            }
        });
        findViewById(R.id.j44).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(99094);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SnsSightPlayerUI.this.cvQ();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99094);
            }
        });
        ((View) this.qbJ).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(99095);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SnsSightPlayerUI.this.cvQ();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99095);
            }
        });
        this.mDJ = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass12 */

            public final boolean onContextClick(MotionEvent motionEvent) {
                AppMethodBeat.i(203656);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onContextClick = super.onContextClick(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(203656);
                return onContextClick;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(203655);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onDoubleTap = super.onDoubleTap(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(203655);
                return onDoubleTap;
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(203654);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(203654);
                return onSingleTapUp;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                AppMethodBeat.i(99096);
                float translationX = (((View) SnsSightPlayerUI.this.qbJ).getTranslationX() + motionEvent2.getX()) - motionEvent.getX();
                float translationY = (((View) SnsSightPlayerUI.this.qbJ).getTranslationY() + motionEvent2.getY()) - motionEvent.getY();
                if (SnsSightPlayerUI.this.EHq) {
                    ((View) SnsSightPlayerUI.this.qbJ).setTranslationX(translationX);
                    ((View) SnsSightPlayerUI.this.qbJ).setTranslationY(translationY);
                }
                AppMethodBeat.o(99096);
                return true;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(99097);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                SnsSightPlayerUI.this.EHs = true;
                super.onLongPress(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$7", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(99097);
            }
        });
        ((View) this.qbJ).setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass13 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(99098);
                GestureDetector gestureDetector = SnsSightPlayerUI.this.mDJ;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/sns/ui/SnsSightPlayerUI$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                if (SnsSightPlayerUI.this.mVelocityTracker == null) {
                    SnsSightPlayerUI.this.mVelocityTracker = VelocityTracker.obtain();
                }
                SnsSightPlayerUI.this.mVelocityTracker.addMovement(motionEvent);
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        SnsSightPlayerUI.this.aZg = motionEvent.getX();
                        SnsSightPlayerUI.this.aZh = motionEvent.getY();
                        break;
                    case 1:
                        if (SnsSightPlayerUI.this.EHr) {
                            ((View) SnsSightPlayerUI.this.qbJ).setPivotX((float) (SnsSightPlayerUI.this.DnT.getWidth() / 2));
                            ((View) SnsSightPlayerUI.this.qbJ).setPivotY((float) (SnsSightPlayerUI.this.DnT.getHeight() / 2));
                            ((View) SnsSightPlayerUI.this.qbJ).setScaleX(1.0f);
                            ((View) SnsSightPlayerUI.this.qbJ).setScaleY(1.0f);
                            ((View) SnsSightPlayerUI.this.qbJ).setTranslationX(0.0f);
                            ((View) SnsSightPlayerUI.this.qbJ).setTranslationY(0.0f);
                            SnsSightPlayerUI snsSightPlayerUI = SnsSightPlayerUI.this;
                            if (snsSightPlayerUI.contextMenuHelper == null) {
                                snsSightPlayerUI.contextMenuHelper = new com.tencent.mm.ui.tools.l(snsSightPlayerUI.getContext());
                            }
                            snsSightPlayerUI.contextMenuHelper.a((View) snsSightPlayerUI.qbJ, snsSightPlayerUI.EJn, snsSightPlayerUI.pso);
                            if (SnsSightPlayerUI.this.thO != null) {
                                SnsSightPlayerUI.this.thO.setVisibility(0);
                            }
                            SnsSightPlayerUI.this.EHq = false;
                            SnsSightPlayerUI.this.EHs = false;
                            break;
                        } else if (!SnsSightPlayerUI.this.EHq || SnsSightPlayerUI.this.EHs) {
                            SnsSightPlayerUI.this.EHs = false;
                            break;
                        } else {
                            SnsSightPlayerUI.this.cvQ();
                            SnsSightPlayerUI.this.EHs = false;
                            AppMethodBeat.o(99098);
                            return true;
                        }
                    case 2:
                        float translationX = ((View) SnsSightPlayerUI.this.qbJ).getTranslationX();
                        float translationY = ((View) SnsSightPlayerUI.this.qbJ).getTranslationY();
                        VelocityTracker velocityTracker = SnsSightPlayerUI.this.mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000);
                        int xVelocity = (int) velocityTracker.getXVelocity();
                        int yVelocity = (int) velocityTracker.getYVelocity();
                        if ((Math.abs(translationX) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || SnsSightPlayerUI.this.EHs) && !SnsSightPlayerUI.this.EHq) {
                            SnsSightPlayerUI.this.EHq = false;
                        } else {
                            float height = 1.0f - (translationY / ((float) SnsSightPlayerUI.this.DnT.getHeight()));
                            float f2 = height > 1.0f ? 1.0f : height;
                            if (((yVelocity > 0 && f2 < SnsSightPlayerUI.this.EAC) || yVelocity < 0) && ((double) f2) >= 0.5d) {
                                SnsSightPlayerUI.this.EAD = (int) translationX;
                                SnsSightPlayerUI.this.EAE = (int) translationY;
                                SnsSightPlayerUI.this.EAC = f2;
                                if (SnsSightPlayerUI.this.thO != null) {
                                    SnsSightPlayerUI.this.thO.setVisibility(8);
                                }
                                ((View) SnsSightPlayerUI.this.qbJ).setPivotX((float) (SnsSightPlayerUI.this.DnT.getWidth() / 2));
                                ((View) SnsSightPlayerUI.this.qbJ).setPivotY((float) (SnsSightPlayerUI.this.DnT.getHeight() / 2));
                                ((View) SnsSightPlayerUI.this.qbJ).setScaleX(f2);
                                ((View) SnsSightPlayerUI.this.qbJ).setScaleY(f2);
                                SnsSightPlayerUI.this.jUG.setAlpha(f2);
                            }
                            SnsSightPlayerUI.this.EHq = true;
                        }
                        if (translationY > 200.0f) {
                            SnsSightPlayerUI.this.EHr = false;
                        } else if (translationY > 10.0f) {
                            SnsSightPlayerUI.this.EHr = true;
                        }
                        if (translationY > 50.0f) {
                            ((View) SnsSightPlayerUI.this.qbJ).setOnLongClickListener(null);
                        }
                        if (SnsSightPlayerUI.this.mVelocityTracker != null) {
                            SnsSightPlayerUI.this.mVelocityTracker.recycle();
                            SnsSightPlayerUI.this.mVelocityTracker = null;
                        }
                        if (SnsSightPlayerUI.this.EHq) {
                            AppMethodBeat.o(99098);
                            return true;
                        }
                        break;
                }
                AppMethodBeat.o(99098);
                return false;
            }
        });
        if (s.YS(this.fullPath)) {
            if (this.fullPath != null) {
                this.qbJ.stop();
                this.qbJ.setVideoPath(this.fullPath);
            }
            this.EJk.setVisibility(8);
            this.EzN.DvO = 1;
        } else {
            aj.faJ().a(this.ebR, 6, (n) null, bp.Oqt);
            this.EJk.setVisibility(0);
            this.EJk.gYN();
            this.EzN.DvO = 0;
        }
        Log.d("MicroMsg.SnsSightPlayerUI", (System.currentTimeMillis() - currentTimeMillis) + " initView end");
        yh yhVar = new yh();
        yhVar.eeC.type = 1;
        EventCenter.instance.publish(yhVar);
        if (this.contextMenuHelper == null) {
            this.contextMenuHelper = new com.tencent.mm.ui.tools.l(getContext());
        }
        this.contextMenuHelper.a((View) this.qbJ, this.EJn, this.pso);
        ((View) this.qbJ).post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(99099);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                SnsSightPlayerUI.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                if (SnsSightPlayerUI.this.qbJ instanceof VideoSightView) {
                    ((VideoSightView) SnsSightPlayerUI.this.qbJ).setDrawableWidth(displayMetrics.widthPixels);
                }
                ((View) SnsSightPlayerUI.this.qbJ).requestLayout();
                ((View) SnsSightPlayerUI.this.qbJ).postInvalidate();
                AppMethodBeat.o(99099);
            }
        });
        AppMethodBeat.o(99101);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(99102);
        if (!this.iGD) {
            super.finish();
            this.iGD = true;
        }
        AppMethodBeat.o(99102);
    }

    private void uF(boolean z) {
        AppMethodBeat.i(99103);
        this.qbJ.start();
        this.duration = this.qbJ.getDuration();
        Log.i("MicroMsg.SnsSightPlayerUI", "startplay get duration " + this.duration);
        this.pNk.a(this);
        if (z) {
            this.EzN.DvW.Dxb = getResources().getConfiguration().orientation == 2 ? 2 : 1;
            this.EzN.DvW.Dxc = Util.currentTicks();
            this.EzN.DvW.Dxa = 2;
        }
        AppMethodBeat.o(99103);
    }

    private void cXa() {
        AppMethodBeat.i(99104);
        Log.i("MicroMsg.SnsSightPlayerUI", "snsSightplayui pauseplay");
        this.qbJ.pause();
        this.qbJ.onDetach();
        this.pNk.fp(false);
        AppMethodBeat.o(99104);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bx6;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        int i2;
        com.tencent.mm.bw.b timelineRemindInfoSelfInfo;
        boolean z = true;
        AppMethodBeat.i(99105);
        super.onDestroy();
        if (this.isAd) {
            String str = this.DsC == null ? "" : this.DyO.viewId;
            if (this.DsC != null) {
                String eXr = this.EzN.eXr();
                int adRecSrc = this.DsC == null ? 0 : this.DsC.getAdRecSrc();
                long j2 = ((long) this.EzN.DvP) - this.EzN.jkZ;
                if (j2 < 0) {
                    Log.e("MicroMsg.SnsSightPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", Integer.valueOf(this.EzN.DvP), Long.valueOf(this.EzN.jkZ));
                    j2 = (long) this.EzN.DvP;
                }
                int i3 = (int) j2;
                String str2 = this.DyO == null ? "" : this.DyO.waidPkg;
                g.aAi();
                t tVar = g.aAg().hqi;
                if (this.source == 0) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                int i4 = this.EzN.DvP;
                com.tencent.mm.bw.b atFriendRemindInfoSourceInfo = this.source == 2 ? this.DsC.getAdSnsInfo().getAtFriendRemindInfoSourceInfo() : this.DsC.getAdSnsInfo().getTimelineRemindInfoSourceInfo();
                if (this.source == 2) {
                    timelineRemindInfoSelfInfo = this.DsC.getAdSnsInfo().getAtFriendRemindInfoSelfInfo();
                } else {
                    timelineRemindInfoSelfInfo = this.DsC.getAdSnsInfo().getTimelineRemindInfoSelfInfo();
                }
                tVar.a(new com.tencent.mm.plugin.sns.ad.g.g(str, i2, i4, eXr, adRecSrc, i3, i3, atFriendRemindInfoSourceInfo, timelineRemindInfoSelfInfo, str2), 0);
            }
        }
        Log.d("MicroMsg.SnsSightPlayerUI", "on dismiss");
        if (this.isAd && this.DsC != null && this.DsC.isAd()) {
            com.tencent.mm.plugin.sns.ad.g.o.a(o.b.Sight, o.a.LeavelFullScreen, this.DsC, this.source);
        }
        aj.faJ().b(this);
        k w = k.w(getIntent());
        if (w != null) {
            if (this.isAd) {
                if (Util.isNullOrNil(this.ebR.MsF)) {
                    z = false;
                }
                w.fL(z);
            } else {
                w.fL(false);
            }
            w.update();
            w.bfK();
        }
        if (com.tencent.mm.q.a.Xi() != null) {
            com.tencent.mm.q.a.Xi().akq();
        }
        if (this.qbJ != null) {
            this.qbJ.setVideoCallback(null);
            this.qbJ.stop();
            this.qbJ.onDetach();
        }
        if (!this.DnK) {
            yh yhVar = new yh();
            yhVar.eeC.type = 0;
            yhVar.eeC.eeD = this.Dne;
            yhVar.eeC.eeE = this.tex;
            yhVar.eeC.eeF = this.eeF;
            EventCenter.instance.publish(yhVar);
        }
        this.pNk.fp(false);
        AppMethodBeat.o(99105);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(99106);
        Bundle bundle = this.qaD;
        if (!this.isAnimated) {
            this.isAnimated = true;
            if (Build.VERSION.SDK_INT >= 12) {
                this.qaF = getIntent().getIntExtra("img_gallery_top", 0);
                this.qaG = getIntent().getIntExtra("img_gallery_left", 0);
                this.qaH = getIntent().getIntExtra("img_gallery_width", 0);
                this.qaI = getIntent().getIntExtra("img_gallery_height", 0);
                this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
                if (bundle == null) {
                    this.DnT.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass3 */

                        public final boolean onPreDraw() {
                            AppMethodBeat.i(99080);
                            SnsSightPlayerUI.this.DnT.getViewTreeObserver().removeOnPreDrawListener(this);
                            SnsSightPlayerUI.this.qaE.a(SnsSightPlayerUI.this.DnT, SnsSightPlayerUI.this.jUG, null);
                            AppMethodBeat.o(99080);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
        AppMethodBeat.o(99106);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(99107);
        super.onResume();
        if (!this.isInit) {
            Log.i("MicroMsg.SnsSightPlayerUI", "initOrientation ".concat(String.valueOf(getResources().getConfiguration().orientation)));
            if (getResources().getConfiguration().orientation == 2) {
                aW(getResources().getConfiguration().orientation, true);
            }
            this.isInit = true;
        }
        if (this.Dob == 0 || this.Doa == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.Dob = displayMetrics.heightPixels;
            this.Doa = displayMetrics.widthPixels;
        }
        if (this.EHl && s.YS(this.fullPath)) {
            uF(false);
            this.EHl = false;
        }
        if (this.EzN != null) {
            this.EzN.onResume();
        }
        AppMethodBeat.o(99107);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(99108);
        super.onPause();
        int i2 = getResources().getConfiguration().orientation;
        Log.i("MicroMsg.SnsSightPlayerUI", "onpause  ".concat(String.valueOf(i2)));
        ZQ(i2);
        if (!this.EHl) {
            cXa();
            Log.v("check", "onclick");
            new MMHandler().post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(99079);
                    SnsSightPlayerUI.this.finish();
                    AppMethodBeat.o(99079);
                }
            });
        } else {
            cXa();
        }
        if (this.EzN != null) {
            this.EzN.jkY = Util.currentTicks();
        }
        AppMethodBeat.o(99108);
    }

    public final void cvQ() {
        AppMethodBeat.i(99109);
        int width = this.DnT.getWidth();
        int height = this.DnT.getHeight();
        if (!(this.qaH == 0 || this.qaI == 0)) {
            height = (int) ((((float) width) / ((float) this.qaH)) * ((float) this.qaI));
        }
        this.qaE.ls(width, height);
        this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
        if (((double) this.EAC) != 1.0d) {
            int aD = ao.aD(getContext());
            this.qaE.QtG = 1.0f / this.EAC;
            if (!(this.EAD == 0 && this.EAE == 0)) {
                this.qaE.lu(((int) (((float) (this.DnT.getWidth() / 2)) * (1.0f - this.EAC))) + this.EAD, (int) ((((float) ((aD + this.DnT.getHeight()) / 2)) - (((float) (height / 2)) * this.EAC)) + ((float) this.EAE)));
            }
        }
        this.qaE.a(this.DnT, this.jUG, new e.c() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.tools.e.c
            public final void onAnimationStart() {
                AppMethodBeat.i(99082);
                if (SnsSightPlayerUI.this.thO != null) {
                    SnsSightPlayerUI.this.thO.setVisibility(8);
                }
                AppMethodBeat.o(99082);
            }

            @Override // com.tencent.mm.ui.tools.e.c
            public final void onAnimationEnd() {
                AppMethodBeat.i(99083);
                new MMHandler().post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(99081);
                        SnsSightPlayerUI.this.finish();
                        SnsSightPlayerUI.this.overridePendingTransition(0, 0);
                        AppMethodBeat.o(99081);
                    }
                });
                AppMethodBeat.o(99083);
            }
        }, null);
        AppMethodBeat.o(99109);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(99110);
        cvQ();
        AppMethodBeat.o(99110);
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTw() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTx() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTy() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTz() {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        o.c cVar;
        int i4;
        String str;
        SnsInfo aQm;
        AppMethodBeat.i(99111);
        if (4097 == i2) {
            if (-1 == i3) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                for (String str2 : Util.stringsToList(stringExtra.split(","))) {
                    if (this.source == 0 && (aQm = aj.faO().aQm(this.dJX)) != null) {
                        if (ab.Eq(str2)) {
                            vn vnVar = new vn();
                            vnVar.ebK.dRS = r.v(aQm);
                            vnVar.ebK.dHp = aQm.getLocalid();
                            EventCenter.instance.publish(vnVar);
                        } else {
                            vo voVar = new vo();
                            voVar.ebL.dRS = r.v(aQm);
                            voVar.ebL.dHp = aQm.getLocalid();
                            EventCenter.instance.publish(voVar);
                        }
                    }
                    TimeLineObject timeLine = this.DsC.getTimeLine();
                    if (this.isAd) {
                        ADXml adXml = this.DsC.getAdXml();
                        eeq eeq = new eeq();
                        eeq.LxJ = this.ebR.ERX;
                        eeq.iyZ = this.ebR.MsF;
                        if (timeLine.ContentObj.LoU == 15) {
                            eeq.izf = this.DyO.uxInfo;
                            eeq.izg = timeLine.Id;
                        } else {
                            eeq.izf = timeLine.streamvideo.izf;
                            eeq.izg = timeLine.streamvideo.izg;
                        }
                        eeq.izb = Util.isNullOrNil(this.ebR.MsJ) ? timeLine.ContentDesc : this.ebR.MsJ;
                        if (Util.isNullOrNil(this.ebR.MsI)) {
                            str = this.ebR.Msz;
                        } else {
                            str = this.ebR.MsI;
                        }
                        eeq.ize = str;
                        if (adXml != null && adXml.attachShareLinkIsHidden == 0) {
                            eeq.izd = adXml.attachShareLinkUrl;
                            eeq.izc = adXml.attachShareLinkWording;
                        }
                        if (adXml != null) {
                            eeq.izd = adXml.adActionLink;
                        }
                        int aOx = r.aOx(this.fullPath);
                        Log.i("MicroMsg.SnsSightPlayerUI", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d streamvideothumburl %s, duration: %s", str2, this.fullPath, this.imagePath, this.ebR.MsF, Integer.valueOf(this.ebR.ERX), eeq.ize, Integer.valueOf(aOx));
                        com.tencent.mm.plugin.messenger.a.g.eir().a(this, str2, this.fullPath, this.imagePath, 43, aOx, eeq, timeLine.statExtStr, null);
                    } else {
                        int aOx2 = r.aOx(this.fullPath);
                        Log.i("MicroMsg.SnsSightPlayerUI", "send sight to %s, videopath %s, thumbpath %s, duration: %s", str2, this.fullPath, this.imagePath, Integer.valueOf(aOx2));
                        com.tencent.mm.plugin.messenger.a.g.eir().a(this, str2, this.fullPath, this.imagePath, 43, aOx2, timeLine.statExtStr, (String) null);
                    }
                    if (stringExtra2 != null) {
                        com.tencent.mm.plugin.messenger.a.g.eir().iF(stringExtra2, str2);
                    }
                    com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.string.dzo));
                    if (this.isAd) {
                        r.a(new SnsAdClick(this.source, 5, this.DsC.field_snsId, 12, 0));
                        boolean Eq = ab.Eq(str2);
                        o.d dVar = o.d.Sight;
                        if (Eq) {
                            cVar = o.c.Chatroom;
                        } else {
                            cVar = o.c.Chat;
                        }
                        o.e eVar = o.e.Full;
                        if (Eq) {
                            i4 = com.tencent.mm.model.v.Ie(str2);
                        } else {
                            i4 = 0;
                        }
                        com.tencent.mm.plugin.sns.ad.g.o.a(dVar, cVar, eVar, i4, this.DsC, this.source);
                    }
                }
            } else if (this.isAd) {
                r.a(new SnsAdClick(this.source, 5, this.DsC.field_snsId, 13, 0));
            }
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(99111);
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void aOG(String str) {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void ci(String str, boolean z) {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void eZJ() {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void cj(String str, boolean z) {
        AppMethodBeat.i(99112);
        Log.i("MicroMsg.SnsSightPlayerUI", "onSightFinish ".concat(String.valueOf(str)));
        if (this.isAd && !Util.isNullOrNil(str) && this.ebR != null && str.equals(this.ebR.Id) && s.YS(this.fullPath)) {
            this.EzN.DvO = 1;
            this.qbJ.setVideoPath(this.fullPath);
            uF(true);
            if (this.EJk != null) {
                this.EJk.setVisibility(8);
            }
        }
        AppMethodBeat.o(99112);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 7;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(99113);
        super.onConfigurationChanged(configuration);
        Log.i("MicroMsg.SnsSightPlayerUI", "onConfigurationChanged " + configuration.orientation + " " + this.Doi);
        if (this.Doi == configuration.orientation) {
            AppMethodBeat.o(99113);
            return;
        }
        int i2 = configuration.orientation;
        aW(configuration.orientation, false);
        this.Doi = configuration.orientation;
        AppMethodBeat.o(99113);
    }

    private void aW(int i2, boolean z) {
        AppMethodBeat.i(99114);
        if (this.Dob == 0 || this.Doa == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.Dob = displayMetrics.heightPixels;
            this.Doa = displayMetrics.widthPixels;
        }
        ViewGroup.LayoutParams layoutParams = this.DnT.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.EJj.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        if (i2 == 1) {
            layoutParams3.width = this.Doa;
            layoutParams3.height = (int) (((((double) this.Doa) * 1.0d) * 240.0d) / 320.0d);
            layoutParams2.addRule(12, 0);
            layoutParams2.addRule(1, 0);
            layoutParams2.addRule(11, -1);
            layoutParams2.addRule(3, this.DnT.getId());
            findViewById(R.id.ipe).setVisibility(0);
        } else {
            layoutParams3.height = this.Doa;
            layoutParams3.width = (int) (((((double) this.Doa) * 1.0d) * 320.0d) / 240.0d);
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(3, 0);
            layoutParams2.addRule(12, -1);
            layoutParams2.addRule(1, this.DnT.getId());
            findViewById(R.id.ipe).setVisibility(8);
        }
        Log.i("MicroMsg.SnsSightPlayerUI", "orientation " + i2 + " " + layoutParams3.width + " " + layoutParams3.height);
        ((View) this.qbJ).setLayoutParams(layoutParams3);
        if (this.qbJ instanceof com.tencent.mm.plugin.sight.decode.a.a) {
            ((com.tencent.mm.plugin.sight.decode.a.a) this.qbJ).im(layoutParams3.width, layoutParams3.height);
        }
        layoutParams.height = layoutParams3.height;
        layoutParams.width = layoutParams3.width;
        this.DnJ.setLayoutParams(layoutParams2);
        this.DnT.setLayoutParams(layoutParams);
        ((View) this.qbJ).requestLayout();
        if (!z) {
            ZQ(i2);
        }
        AppMethodBeat.o(99114);
    }

    private void ZQ(int i2) {
        AppMethodBeat.i(99115);
        if (!this.isAd) {
            AppMethodBeat.o(99115);
            return;
        }
        if (this.qbJ.isPlaying()) {
            if (this.duration == 0) {
                this.duration = this.qbJ.getDuration();
            }
            this.EzN.XK(this.duration);
            this.EzN.DvW.Dxc = Util.currentTicks();
            this.EzN.DvW.Dxb = i2 == 2 ? 2 : 1;
            this.EzN.DvW.Dxa = 2;
            Log.i("MicroMsg.SnsSightPlayerUI", "duration " + this.duration + " orient " + this.EzN.DvW.Dxb);
        }
        AppMethodBeat.o(99115);
    }
}
