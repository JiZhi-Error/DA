package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.w;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.g.o;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdStreamVideoView;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.utils.TbsLog;

@com.tencent.mm.ui.base.a(35)
public class SnsAdStreamVideoPlayUI extends MMActivity implements i.a, i.b, i.c {
    private String DZi = "";
    private SnsInfo DsC;
    private int Dzs;
    private FrameLayout EzH;
    private SnsAdStreamVideoView EzI;
    private String EzJ;
    private boolean EzK;
    private boolean EzL;
    private String EzM;
    private l EzN = new l("SnsAdStreamVideoPlayUI");
    private String EzO;
    private String EzP;
    private int EzQ;
    private int EzR;
    private String EzS;
    private String EzT;
    private String EzU;
    private long EzV;
    private int EzW;
    private int EzX;
    private boolean EzY;
    private String ean;
    private String izc;
    private String izd;
    private String mediaId;
    private TextView thO;
    private String thumbPath;
    private String thumbUrl;
    private String url;
    private String viewId;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsAdStreamVideoPlayUI() {
        AppMethodBeat.i(98458);
        AppMethodBeat.o(98458);
    }

    /* access modifiers changed from: package-private */
    public class a implements c.b {
        private String mediaId;

        public a(String str) {
            this.mediaId = str;
        }

        @Override // com.tencent.mm.plugin.sns.model.c.b
        public final void aOG(String str) {
        }

        @Override // com.tencent.mm.plugin.sns.model.c.b
        public final void ci(String str, boolean z) {
            AppMethodBeat.i(98457);
            if (!Util.isNullOrNil(str, this.mediaId) && str.equals(this.mediaId)) {
                Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "download image finish %s", str);
                Bitmap decodeFile = BitmapUtil.decodeFile(SnsAdStreamVideoPlayUI.this.thumbPath, null);
                if (decodeFile != null) {
                    SnsAdStreamVideoPlayUI.this.EzI.setCover(decodeFile);
                }
            }
            AppMethodBeat.o(98457);
        }

        @Override // com.tencent.mm.plugin.sns.model.c.b
        public final void eZJ() {
        }

        @Override // com.tencent.mm.plugin.sns.model.c.b
        public final void cj(String str, boolean z) {
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(98459);
        super.onCreate(bundle);
        this.url = getIntent().getStringExtra("KUrl");
        this.EzJ = getIntent().getStringExtra("KStremVideoUrl");
        this.thumbUrl = getIntent().getStringExtra("KThumUrl");
        this.thumbPath = getIntent().getStringExtra("KThumbPath");
        this.mediaId = getIntent().getStringExtra("KMediaId");
        this.EzK = getIntent().getBooleanExtra("ForceLandscape", false);
        this.EzL = getIntent().getBooleanExtra("KBlockFav", false);
        this.EzM = Util.nullAs(getIntent().getStringExtra("KMediaTitle"), "");
        this.Dzs = getIntent().getIntExtra("KMediaVideoTime", 0);
        this.DsC = aj.faO().aQl(new StringBuilder().append(r.aOw(getIntent().getStringExtra("KSta_SnSId"))).toString());
        this.EzY = getIntent().getBooleanExtra("KFromTimeLine", false);
        this.EzN.DvQ = Util.currentTicks();
        this.DZi = getIntent().getStringExtra("KComponentCid");
        this.EzO = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
        this.EzP = getIntent().getStringExtra("KSta_StremVideoPublishId");
        this.EzQ = getIntent().getIntExtra("KSta_SourceType", 0);
        this.EzR = getIntent().getIntExtra("KSta_Scene", 0);
        this.EzS = getIntent().getStringExtra("KSta_FromUserName");
        this.EzT = getIntent().getStringExtra("KSta_ChatName");
        this.EzU = getIntent().getStringExtra("KSta_SnSId");
        this.EzV = getIntent().getLongExtra("KSta_MsgId", 0);
        this.EzW = getIntent().getIntExtra("KSta_FavID", 0);
        this.EzX = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
        this.ean = getIntent().getStringExtra("KSta_SnsStatExtStr");
        this.viewId = Util.nullAs(getIntent().getStringExtra("KViewId"), "");
        this.izc = getIntent().getStringExtra("StreamWording");
        this.izd = getIntent().getStringExtra("StremWebUrl");
        setMMTitle("");
        final e eVar = new e((Context) this, 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(98451);
                if (mVar.gKQ()) {
                    mVar.kV(1002, R.string.h4t);
                    mVar.kV(1003, R.string.h4u);
                    if (!SnsAdStreamVideoPlayUI.this.EzL) {
                        mVar.kV(1004, R.string.h4r);
                    }
                }
                AppMethodBeat.o(98451);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI.AnonymousClass2 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(98452);
                switch (menuItem.getItemId()) {
                    case 1002:
                        SnsAdStreamVideoPlayUI.d(SnsAdStreamVideoPlayUI.this);
                        AppMethodBeat.o(98452);
                        return;
                    case 1003:
                        SnsAdStreamVideoPlayUI.e(SnsAdStreamVideoPlayUI.this);
                        AppMethodBeat.o(98452);
                        return;
                    case 1004:
                        SnsAdStreamVideoPlayUI.f(SnsAdStreamVideoPlayUI.this);
                        break;
                }
                AppMethodBeat.o(98452);
            }
        };
        eVar.PGl = new e.b() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
            }
        };
        addIconOptionMenu(1001, R.drawable.bwf, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(98453);
                eVar.dGm();
                AppMethodBeat.o(98453);
                return true;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(98454);
                SnsAdStreamVideoPlayUI.this.finish();
                AppMethodBeat.o(98454);
                return true;
            }
        }, R.drawable.bwd);
        getWindow().getDecorView().setSystemUiVisibility(1792);
        setActionbarColor(getResources().getColor(R.color.ac_));
        setNavigationbarColor(getResources().getColor(R.color.ac_));
        initView();
        AppMethodBeat.o(98459);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        Bitmap decodeFile;
        AppMethodBeat.i(98460);
        this.EzH = (FrameLayout) findViewById(R.id.h8y);
        this.EzI = (SnsAdStreamVideoView) findViewById(R.id.j6y);
        this.EzH.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(98455);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SnsAdStreamVideoPlayUI.this.EzI.setIsShowBasicControls(true);
                if (SnsAdStreamVideoPlayUI.this.EzI.isPlaying()) {
                    SnsAdStreamVideoPlayUI.this.EzI.FeB.stopTimer();
                    SnsAdStreamVideoPlayUI.this.EzI.flg();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98455);
            }
        });
        this.EzH.setPadding(0, 0, 0, ao.aD(this));
        this.thO = (TextView) findViewById(R.id.hqu);
        if (!Util.isNullOrNil(this.izc, this.izd)) {
            this.thO.setVisibility(0);
            this.thO.setText(this.izc);
            this.thO.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI.AnonymousClass7 */

                public final void onClick(View view) {
                    AppMethodBeat.i(98456);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (SnsAdStreamVideoPlayUI.this.EzR != 0) {
                        com.tencent.mm.plugin.sns.ad.g.o.a(o.a.DetailInVideo, SnsAdStreamVideoPlayUI.this.EzP, SnsAdStreamVideoPlayUI.this.EzO, SnsAdStreamVideoPlayUI.this.EzQ, SnsAdStreamVideoPlayUI.this.EzR, SnsAdStreamVideoPlayUI.this.EzS, SnsAdStreamVideoPlayUI.this.EzT, SnsAdStreamVideoPlayUI.this.EzU, SnsAdStreamVideoPlayUI.this.EzV, SnsAdStreamVideoPlayUI.this.EzW, SnsAdStreamVideoPlayUI.this.EzX);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putString("key_snsad_statextstr", SnsAdStreamVideoPlayUI.this.ean);
                    String str = SnsAdStreamVideoPlayUI.this.izd;
                    if (SnsAdStreamVideoPlayUI.this.EzY && !TextUtils.isEmpty(SnsAdStreamVideoPlayUI.this.EzO)) {
                        str = r.kb(str, SnsAdStreamVideoPlayUI.this.EzO);
                    }
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("useJs", true);
                    if (SnsAdStreamVideoPlayUI.this.EzY) {
                        r.a(new SnsAdClick(0, 6, SnsAdStreamVideoPlayUI.this.DsC.field_snsId, 18, 0));
                    }
                    com.tencent.mm.plugin.sns.c.a.jRt.i(intent, SnsAdStreamVideoPlayUI.this);
                    SnsAdStreamVideoPlayUI.this.finish();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdStreamVideoPlayUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(98456);
                }
            });
        } else {
            this.thO.setVisibility(8);
        }
        this.EzI.setReporter(this);
        this.EzI.setIMMVideoViewCallback(this);
        this.EzI.setIMMDownloadFinish(this);
        this.EzI.setRootPath(aj.getSnsAdPath());
        this.EzI.c(false, this.EzJ, 0);
        this.EzI.setScaleType(i.e.CONTAIN);
        this.EzI.setIOnlineVideoProxy(new af());
        if (Util.isNullOrNil(this.thumbPath) || !s.YS(this.thumbPath) || (decodeFile = BitmapUtil.decodeFile(this.thumbPath, null)) == null) {
            String str = "attach" + this.mediaId;
            String ki = ar.ki(aj.getSnsAdPath(), str);
            String aOf = r.aOf(str);
            this.thumbPath = ki + aOf;
            Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "try download thumb img %s, save to %s", this.mediaId, this.thumbPath);
            cnb a2 = n.a(this.thumbPath, 2, this.thumbUrl, this.thumbUrl, 1, 1, "");
            com.tencent.mm.plugin.sns.data.n nVar = new com.tencent.mm.plugin.sns.data.n(a2);
            nVar.DEs = 3;
            nVar.dPI = a2.Id;
            aj.faJ().a(new a(a2.Id));
            c faJ = aj.faJ();
            bp gCU = bp.gCU();
            gCU.hXs = (int) (System.currentTimeMillis() / 1000);
            faJ.a(a2, 8, nVar, gCU, ki, aOf);
        } else {
            this.EzI.setCover(decodeFile);
        }
        Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "start play");
        if (!this.EzI.isPlaying()) {
            if (this.EzI.getCurrPosSec() == this.EzI.getVideoDurationSec()) {
                YX(0);
            } else {
                YX(this.EzI.getCurrPosSec());
            }
            this.EzI.start();
        }
        AppMethodBeat.o(98460);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(98461);
        if (i2 == 4) {
            finish();
            AppMethodBeat.o(98461);
            return true;
        }
        AppMethodBeat.o(98461);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(98463);
        super.onResume();
        if (this.EzN != null) {
            this.EzN.onResume();
        }
        AppMethodBeat.o(98463);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(98464);
        super.onStop();
        Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "pause play");
        this.EzI.pause();
        if (this.EzY) {
            int i2 = getResources().getConfiguration().orientation;
            this.EzN.XK(this.EzI.getCurrPosSec());
            this.EzN.DvW.Dxc = Util.currentTicks();
            this.EzN.DvW.Dxb = i2 == 2 ? 2 : 1;
            this.EzN.DvW.Dxa = 2;
        }
        if (this.EzN != null) {
            this.EzN.jkY = Util.currentTicks();
        }
        AppMethodBeat.o(98464);
    }

    private void YX(int i2) {
        AppMethodBeat.i(98465);
        if (this.EzI != null) {
            this.EzI.c((double) i2, true);
        }
        AppMethodBeat.o(98465);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.buy;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        if (this.EzK) {
            return 0;
        }
        return 4;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void c(String str, String str2, String str3, int i2, int i3) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dH(String str, String str2) {
        int i2 = 1;
        AppMethodBeat.i(98466);
        Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s prepared, video total time %d", str2, Integer.valueOf(this.EzI.getVideoDurationSec()));
        this.EzI.flg();
        if (this.Dzs == 0) {
            this.Dzs = this.EzI.getVideoDurationSec();
        }
        com.tencent.mm.plugin.sns.ad.g.a.a aVar = this.EzN.DvW;
        if (getResources().getConfiguration().orientation == 2) {
            i2 = 2;
        }
        aVar.Dxb = i2;
        this.EzN.DvW.Dxc = Util.currentTicks();
        this.EzN.DvW.Dxa = 2;
        this.EzN.DvW.DwY = 0;
        this.EzN.DvW.DwW++;
        this.EzN.DvW.Dxc = Util.currentTicks();
        AppMethodBeat.o(98466);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dI(String str, String str2) {
        AppMethodBeat.i(98467);
        Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s video ended", str2);
        this.EzN.DvW.DwX++;
        this.EzI.stop();
        this.EzI.fld();
        this.EzI.FeB.stopTimer();
        this.EzI.setIsShowBasicControls(true);
        AppMethodBeat.o(98467);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void d(String str, String str2, int i2, int i3) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dJ(String str, String str2) {
        AppMethodBeat.i(98468);
        Log.d("MicroMsg.SnsAdStreamVideoPlayUI", "%s video paused", str2);
        this.EzN.DvW.DwY += (int) Util.ticksToNow(this.EzN.DvW.Dxc);
        AppMethodBeat.o(98468);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dK(String str, String str2) {
        AppMethodBeat.i(98469);
        this.EzI.fle();
        AppMethodBeat.o(98469);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dL(String str, String str2) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dM(String str, String str2) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void fo(String str, String str2) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.a
    public final void aO(String str, boolean z) {
        AppMethodBeat.i(98470);
        Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "%s download finish", str);
        this.EzN.DvO = 1;
        AppMethodBeat.o(98470);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.c
    public final void yU(long j2) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.c
    public final void DX(String str) {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        o.c cVar;
        int i4;
        AppMethodBeat.i(98471);
        if (999 == i2) {
            if (-1 == i3) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                for (String str : Util.stringsToList(stringExtra.split(","))) {
                    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "send sight to %s", str);
                    k.b bVar = new k.b();
                    bVar.title = this.EzM;
                    bVar.type = 4;
                    if (!Util.isNullOrNil(this.url)) {
                        bVar.url = this.url;
                    } else {
                        bVar.url = this.EzJ;
                    }
                    bVar.thumburl = this.thumbUrl;
                    bVar.iyZ = this.EzJ;
                    bVar.iza = this.Dzs;
                    bVar.izb = this.EzM;
                    bVar.izd = this.izd;
                    bVar.izc = this.izc;
                    bVar.ize = this.thumbUrl;
                    bVar.izf = this.EzO;
                    bVar.izg = this.EzP;
                    bVar.ean = this.ean;
                    byte[] aW = s.aW(this.thumbPath, 0, -1);
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(aW == null ? 0 : aW.length);
                    Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "read buf size %d", objArr);
                    if (w.a.aSz() != null) {
                        w.a.aSz().a(bVar, "", "", str, "", aW);
                    }
                    g.eir().iF(stringExtra2, str);
                    if (this.EzY) {
                        r.a(new SnsAdClick(0, 6, this.DsC.field_snsId, 12, 0));
                    }
                    if (this.EzR != 0) {
                        boolean Eq = ab.Eq(str);
                        if (Eq) {
                            cVar = o.c.Chatroom;
                        } else {
                            cVar = o.c.Chat;
                        }
                        String str2 = this.EzP;
                        String str3 = this.EzO;
                        int i5 = this.EzQ;
                        int i6 = this.EzR;
                        String str4 = this.EzS;
                        String str5 = this.EzT;
                        String str6 = this.EzU;
                        long j2 = this.EzV;
                        int i7 = this.EzW;
                        int i8 = this.EzX;
                        if (Eq) {
                            i4 = v.Ie(str);
                        } else {
                            i4 = 0;
                        }
                        com.tencent.mm.plugin.sns.ad.g.o.a(cVar, str2, str3, i5, i6, str4, str5, str6, j2, i7, i8, i4);
                    }
                }
                com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.string.dzo));
            } else if (this.EzY) {
                r.a(new SnsAdClick(0, 6, this.DsC.field_snsId, 13, 0));
            }
        }
        if (998 == i2) {
            if (this.EzR != 0) {
                com.tencent.mm.plugin.sns.ad.g.o.a(o.c.Sns, this.EzP, this.EzO, this.EzQ, this.EzR, this.EzS, this.EzT, this.EzU, this.EzV, this.EzW, this.EzX, 0);
            }
            if (-1 == i3) {
                if (this.EzY) {
                    r.a(new SnsAdClick(0, 6, this.DsC.field_snsId, 15, 0));
                }
            } else if (this.EzY) {
                r.a(new SnsAdClick(0, 6, this.DsC.field_snsId, 16, 0));
            }
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(98471);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        int adRecSrc;
        AppMethodBeat.i(98462);
        Log.i("MicroMsg.SnsAdStreamVideoPlayUI", "stop play");
        this.EzI.onUIDestroy();
        this.EzI.flg();
        aj.faJ().aOM(this.mediaId);
        if (!(this.EzN == null || this.DZi == null || this.DZi.length() <= 0)) {
            this.EzN.eXs();
            Intent intent = new Intent();
            intent.putExtra("KComponentCid", this.DZi);
            intent.putExtra("KStreamVideoPlayCount", this.EzN.DvS);
            intent.putExtra("KStreamVideoPlayCompleteCount", this.EzN.DvT);
            intent.putExtra("KStreamVideoTotalPlayTimeInMs", this.EzN.DvU);
            setResult(-1, intent);
        }
        if (this.EzR != 0) {
            com.tencent.mm.plugin.sns.ad.g.o.a(o.a.LeaveCompleteVideo, this.EzP, this.EzO, this.EzQ, this.EzR, this.EzS, this.EzT, this.EzU, this.EzV, this.EzW, this.EzX);
        }
        if (this.EzY) {
            if (this.DsC == null) {
                adRecSrc = 0;
            } else {
                adRecSrc = this.DsC.getAdRecSrc();
            }
            if (this.DsC != null) {
                String eXr = this.EzN.eXr();
                long j2 = ((long) this.EzN.DvP) - this.EzN.jkZ;
                if (j2 < 0) {
                    Log.e("MicroMsg.SnsAdStreamVideoPlayUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", Integer.valueOf(this.EzN.DvP), Long.valueOf(this.EzN.jkZ));
                    j2 = (long) this.EzN.DvP;
                }
                int i2 = (int) j2;
                ADInfo adInfo = this.DsC.getAdInfo();
                String str = adInfo == null ? "" : adInfo.waidPkg;
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.sns.ad.g.g(this.viewId, 6, this.EzN.DvP, eXr, adRecSrc, i2, i2, this.DsC.getAdSnsInfo().getTimelineRemindInfoSourceInfo(), this.DsC.getAdSnsInfo().getTimelineRemindInfoSelfInfo(), str), 0);
            }
        }
        super.finish();
        AppMethodBeat.o(98462);
    }

    static /* synthetic */ void d(SnsAdStreamVideoPlayUI snsAdStreamVideoPlayUI) {
        AppMethodBeat.i(98472);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("ad_video_title", snsAdStreamVideoPlayUI.EzM);
        intent.putExtra("Retr_Msg_Type", 2);
        com.tencent.mm.br.c.c(snsAdStreamVideoPlayUI, ".ui.transmit.SelectConversationUI", intent, 999);
        AppMethodBeat.o(98472);
    }

    static /* synthetic */ void e(SnsAdStreamVideoPlayUI snsAdStreamVideoPlayUI) {
        AppMethodBeat.i(98473);
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_link", snsAdStreamVideoPlayUI.EzJ);
        intent.putExtra("Ksnsupload_type", 11);
        intent.putExtra("Ksnsupload_title", snsAdStreamVideoPlayUI.EzM);
        intent.putExtra("Ksnsupload_imgurl", snsAdStreamVideoPlayUI.thumbUrl);
        intent.putExtra("KSnsStreamVideoTotalTime", snsAdStreamVideoPlayUI.Dzs);
        intent.putExtra("KSnsStreamVideoWroding", snsAdStreamVideoPlayUI.izc);
        intent.putExtra("KSnsStreamVideoWebUrl", snsAdStreamVideoPlayUI.izd);
        intent.putExtra("KSnsStreamVideoAduxInfo", snsAdStreamVideoPlayUI.EzO);
        intent.putExtra("KSnsStreamVideoPublishId", snsAdStreamVideoPlayUI.EzP);
        intent.putExtra("need_result", true);
        intent.putExtra("key_snsad_statextstr", snsAdStreamVideoPlayUI.ean);
        String str = "sns_";
        if (snsAdStreamVideoPlayUI.EzR == o.b.Sight.value || snsAdStreamVideoPlayUI.EzR == o.b.AdUrl.value) {
            str = "sns_" + snsAdStreamVideoPlayUI.EzU;
        } else if (snsAdStreamVideoPlayUI.EzR == o.b.Chat.value || snsAdStreamVideoPlayUI.EzR == o.b.TalkChat.value) {
            str = "msg_" + snsAdStreamVideoPlayUI.EzV;
        } else if (snsAdStreamVideoPlayUI.EzR == o.b.Fav.value) {
            str = "fav_" + z.aTY() + "_" + snsAdStreamVideoPlayUI.EzW;
        }
        String JX = ad.JX(str);
        ad.aVe().G(JX, true).l("prePublishId", str);
        intent.putExtra("reportSessionId", JX);
        intent.setClass(snsAdStreamVideoPlayUI, SnsUploadUI.class);
        snsAdStreamVideoPlayUI.startActivityForResult(intent, TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR);
        AppMethodBeat.o(98473);
    }

    static /* synthetic */ void f(SnsAdStreamVideoPlayUI snsAdStreamVideoPlayUI) {
        AppMethodBeat.i(98474);
        cz czVar = new cz();
        ((com.tencent.mm.plugin.fav.a.ad) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ad.class)).a(czVar, snsAdStreamVideoPlayUI.Dzs, snsAdStreamVideoPlayUI.EzM, "", snsAdStreamVideoPlayUI.EzJ, snsAdStreamVideoPlayUI.izc, snsAdStreamVideoPlayUI.izd, snsAdStreamVideoPlayUI.thumbUrl, snsAdStreamVideoPlayUI.thumbPath, snsAdStreamVideoPlayUI.EzS, snsAdStreamVideoPlayUI.EzO, snsAdStreamVideoPlayUI.EzP, snsAdStreamVideoPlayUI.ean);
        czVar.dFZ.activity = snsAdStreamVideoPlayUI;
        czVar.dFZ.dGf = 24;
        EventCenter.instance.publish(czVar);
        if (czVar.dGa.ret == 0 && snsAdStreamVideoPlayUI.EzR != 0) {
            com.tencent.mm.plugin.sns.ad.g.o.a(o.c.Fav, snsAdStreamVideoPlayUI.EzP, snsAdStreamVideoPlayUI.EzO, snsAdStreamVideoPlayUI.EzQ, snsAdStreamVideoPlayUI.EzR, snsAdStreamVideoPlayUI.EzS, snsAdStreamVideoPlayUI.EzT, snsAdStreamVideoPlayUI.EzU, snsAdStreamVideoPlayUI.EzV, snsAdStreamVideoPlayUI.EzW, snsAdStreamVideoPlayUI.EzX, 0);
        }
        if (snsAdStreamVideoPlayUI.EzY) {
            r.a(new SnsAdClick(0, 6, snsAdStreamVideoPlayUI.DsC.field_snsId, 11, 0));
        }
        AppMethodBeat.o(98474);
    }
}
