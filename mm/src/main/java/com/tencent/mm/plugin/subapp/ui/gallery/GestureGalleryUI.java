package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import com.danikula.videocache.HttpProxyCacheServer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.media.model.AppBrandMediaSource;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.g;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a;
import com.tencent.mm.plugin.subapp.ui.gallery.a;
import com.tencent.mm.plugin.webview.k.i;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.PressAlphaImageView;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.mm.vfs.s;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class GestureGalleryUI extends MMActivity implements ag.b, a.AbstractC1683a<String, com.tencent.mm.plugin.scanner.word.b>, a.AbstractC1792a {
    private float EAC = 1.0f;
    private int EAD = 0;
    private int EAE = 0;
    private int EqZ = 0;
    private volatile String Eqk;
    private String Eqn;
    private String Eqo;
    private String Eqp;
    private String Eqq;
    private String Eqr;
    private IListener Eqy = new IListener<np>() {
        /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass11 */

        {
            AppMethodBeat.i(232085);
            this.__eventId = np.class.getName().hashCode();
            AppMethodBeat.o(232085);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(np npVar) {
            AppMethodBeat.i(232086);
            np npVar2 = npVar;
            if (npVar2 != null) {
                Log.i("MicroMsg.GestureGalleryUI", "notify Event: %d", Integer.valueOf(npVar2.dTL.dTJ));
                if (npVar2.dTL.activity == GestureGalleryUI.this && npVar2.dTL.dDX.equals(GestureGalleryUI.this.Eqn)) {
                    switch (npVar2.dTL.dTJ) {
                        case 3:
                            GestureGalleryUI.this.finish();
                            break;
                    }
                } else {
                    Log.e("MicroMsg.GestureGalleryUI", "not the same");
                }
            } else {
                Log.e("MicroMsg.GestureGalleryUI", "NotifyDealQBarStrResultEvent is null.");
            }
            AppMethodBeat.o(232086);
            return false;
        }
    };
    private a FKY;
    MMGestureGallery FKZ;
    private long FLA = 0;
    private c FLB = c.Idle;
    boolean FLC = false;
    private boolean FLD = false;
    private IListener<cf> FLE = new IListener<cf>() {
        /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass10 */

        {
            AppMethodBeat.i(161449);
            this.__eventId = cf.class.getName().hashCode();
            AppMethodBeat.o(161449);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(cf cfVar) {
            AppMethodBeat.i(29073);
            GestureGalleryUI.this.finish();
            AppMethodBeat.o(29073);
            return false;
        }
    };
    private List<String> FLF = new ArrayList();
    private List<AppBrandMediaSource> FLG = new ArrayList();
    private int FLH = -1;
    private int FLI = -1;
    private String FLJ = null;
    private boolean FLK = false;
    private AdapterView.OnItemSelectedListener FLL = new AdapterView.OnItemSelectedListener() {
        /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass8 */
        VideoView FLR;

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(232082);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$16", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            GestureGalleryUI.this.FLH = i2;
            GestureGalleryUI.this.FLq.setText((GestureGalleryUI.this.FLH + 1) + FilePathGenerator.ANDROID_DIR_SEP + GestureGalleryUI.this.FKY.getCount());
            GestureGalleryUI.this.setMMTitle((GestureGalleryUI.this.FLH + 1) + " / " + GestureGalleryUI.this.FLF.size());
            Log.d("MicroMsg.GestureGalleryUI", "pos:".concat(String.valueOf(i2)));
            GestureGalleryUI.this.FLt = (String) GestureGalleryUI.this.FLF.get(i2);
            GestureGalleryUI.this.FLb = "";
            GestureGalleryUI.this.FLv = false;
            if (this.FLR != null) {
                this.FLR.stopPlayback();
                this.FLR = null;
            }
            GestureGalleryUI.this.FLz.setIsPlay(false);
            GestureGalleryUI.this.FLB = c.Idle;
            if (!(view == null || view.getTag() == null)) {
                a.C1791a aVar = (a.C1791a) view.getTag();
                if (aVar != null && GestureGalleryUI.a(GestureGalleryUI.this, i2)) {
                    this.FLR = aVar.FLY;
                    GestureGalleryUI.this.FLu = aVar;
                    aVar.xgq.setVisibility(0);
                    aVar.EsM.setVisibility(0);
                    aVar.FLW.setVisibility(8);
                    aVar.FLZ.setVisibility(8);
                } else if (!(aVar == null || aVar.xgq == null)) {
                    aVar.xgq.setVisibility(8);
                }
            }
            if (GestureGalleryUI.a(GestureGalleryUI.this, i2)) {
                GestureGalleryUI.this.FLb = GestureGalleryUI.E(GestureGalleryUI.this);
                GestureGalleryUI.this.FLa = i2;
            } else {
                GestureGalleryUI.this.FLb = GestureGalleryUI.this.FLc.c((String) GestureGalleryUI.this.FLF.get(i2), GestureGalleryUI.this.type, i2, GestureGalleryUI.this.iDk);
                if (Util.isNullOrNil(GestureGalleryUI.this.FLb)) {
                    GestureGalleryUI.this.FLb = (String) GestureGalleryUI.this.FLF.get(i2);
                }
                GestureGalleryUI.this.FLa = i2;
                if (!(GestureGalleryUI.this.FLM == null || GestureGalleryUI.this.FLh == null || GestureGalleryUI.this.FLh.length() <= GestureGalleryUI.this.FLa)) {
                    if (GestureGalleryUI.this.FLh.optJSONObject(GestureGalleryUI.this.FLa).has("jumpType")) {
                        GestureGalleryUI.this.FLM.setVisibility(0);
                    } else {
                        GestureGalleryUI.this.FLM.setVisibility(8);
                    }
                }
            }
            Log.i("MicroMsg.GestureGalleryUI", "curFilename:%s", GestureGalleryUI.this.FLb);
            GestureGalleryUI.l(GestureGalleryUI.this);
            GestureGalleryUI.a(GestureGalleryUI.this, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$16", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(232082);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    };
    private View FLM;
    private b FLN;
    private int FLa;
    private String FLb;
    private ag FLc;
    private boolean FLd = false;
    private boolean FLe = false;
    private boolean FLf = false;
    private boolean FLg = true;
    private JSONArray FLh = null;
    private e FLi;
    private volatile boolean FLj;
    private int FLk;
    private int FLl;
    private int FLm;
    private final Set<Integer> FLn = new HashSet();
    private final Set<Integer> FLo = new HashSet();
    private boolean FLp = false;
    private TextView FLq;
    private a FLr;
    private i FLs;
    private String FLt = "";
    a.C1791a FLu;
    private boolean FLv = false;
    private RelativeLayout FLw;
    private RelativeLayout FLx;
    private PressAlphaImageView FLy;
    RedesignVideoPlayerSeekBar FLz;
    private boolean iAS = false;
    private String iCZ = "";
    private String iDk = null;
    private boolean isAnimated = false;
    private MMHandler mHandler = new MMHandler();
    private ScanCodeSheetItemLogic mHu;
    private String msl = null;
    private long pLQ = 0;
    private Bundle qaD;
    private com.tencent.mm.ui.tools.e qaE;
    private int qaF = 0;
    private int qaG = 0;
    private int qaH = 0;
    private int qaI = 0;
    private ImageView qaz;
    private boolean teC;
    private IListener teF = new IListener<qz>() {
        /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass9 */

        {
            AppMethodBeat.i(232083);
            this.__eventId = qz.class.getName().hashCode();
            AppMethodBeat.o(232083);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qz qzVar) {
            AppMethodBeat.i(232084);
            qz qzVar2 = qzVar;
            if (qzVar2 == null) {
                Log.e("MicroMsg.GestureGalleryUI", "RecogQBarOfImageFileResultEvent is null.");
            } else if (qzVar2 == null || qzVar2.dXz.filePath.equals(GestureGalleryUI.this.Eqk)) {
                Log.i("MicroMsg.GestureGalleryUI", "recog result: %s", qzVar2.dXz.result);
                if (!GestureGalleryUI.this.FLo.isEmpty() && !GestureGalleryUI.this.FLo.contains(Integer.valueOf(qzVar2.dXz.dFL))) {
                    Log.i("MicroMsg.GestureGalleryUI", "Result codeType(%s) error.", Integer.valueOf(qzVar2.dXz.dFL));
                } else if (!GestureGalleryUI.this.FLD || g.ck(qzVar2.dXz.dFL, qzVar2.dXz.result)) {
                    GestureGalleryUI.this.FLk = qzVar2.dXz.dFL;
                    GestureGalleryUI.this.Eqn = qzVar2.dXz.result;
                    GestureGalleryUI.this.FLl = qzVar2.dXz.dFM;
                    GestureGalleryUI.this.Eqk = null;
                    if (!Util.isNullOrNil(GestureGalleryUI.this.Eqn)) {
                        if ((GestureGalleryUI.this.FLi != null && GestureGalleryUI.this.FLi.isShowing()) || GestureGalleryUI.p(GestureGalleryUI.this)) {
                            GestureGalleryUI.b(GestureGalleryUI.this);
                        }
                        GestureGalleryUI.this.mHu.cm(GestureGalleryUI.this.FLk, GestureGalleryUI.this.Eqn);
                    }
                }
            } else {
                Log.e("MicroMsg.GestureGalleryUI", "not same filepath");
            }
            AppMethodBeat.o(232084);
            return false;
        }
    };
    private int type = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.tencent.mm.plugin.scanner.word.a.AbstractC1683a
    public final /* synthetic */ void M(String str, com.tencent.mm.plugin.scanner.word.b bVar) {
        boolean z;
        AppMethodBeat.i(29104);
        com.tencent.mm.plugin.scanner.word.b bVar2 = bVar;
        String str2 = this.FLb;
        int gw = com.tencent.mm.plugin.scanner.i.gw(bVar2.CVF);
        Log.i("MicroMsg.GestureGalleryUI", "local translate, img %s, result %s, ratio %d", str2, bVar2.CVF, Integer.valueOf(gw));
        if (str.equals(str2)) {
            if (gw > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && this.FLi != null && this.FLi.isShowing()) {
                this.teC = true;
                wd(false);
            }
        }
        AppMethodBeat.o(29104);
    }

    public GestureGalleryUI() {
        AppMethodBeat.i(29091);
        AppMethodBeat.o(29091);
    }

    static /* synthetic */ String E(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.i(232112);
        String ftm = gestureGalleryUI.ftm();
        AppMethodBeat.o(232112);
        return ftm;
    }

    static /* synthetic */ boolean a(GestureGalleryUI gestureGalleryUI, int i2) {
        AppMethodBeat.i(179727);
        boolean abl = gestureGalleryUI.abl(i2);
        AppMethodBeat.o(179727);
        return abl;
    }

    static /* synthetic */ void aa(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.i(232114);
        gestureGalleryUI.cWX();
        AppMethodBeat.o(232114);
    }

    static /* synthetic */ void ag(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.i(232116);
        gestureGalleryUI.fto();
        AppMethodBeat.o(232116);
    }

    static /* synthetic */ void c(GestureGalleryUI gestureGalleryUI, boolean z) {
        AppMethodBeat.i(232103);
        gestureGalleryUI.wd(z);
        AppMethodBeat.o(232103);
    }

    static /* synthetic */ void d(GestureGalleryUI gestureGalleryUI, int i2) {
        AppMethodBeat.i(232111);
        gestureGalleryUI.xV(i2);
        AppMethodBeat.o(232111);
    }

    static /* synthetic */ boolean p(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.i(179731);
        boolean z = gestureGalleryUI.iAS;
        AppMethodBeat.o(179731);
        return z;
    }

    static /* synthetic */ boolean r(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.i(232106);
        boolean ftl = gestureGalleryUI.ftl();
        AppMethodBeat.o(232106);
        return ftl;
    }

    @Override // com.tencent.mm.model.ag.b
    public final void i(String str, String str2, int i2) {
        AppMethodBeat.i(29092);
        if (this.FKY != null) {
            if (i2 == this.FKZ.getSelectedItemPosition()) {
                this.FLb = str2;
                this.FLa = i2;
                Log.d("MicroMsg.GestureGalleryUI", "onDownSucc, curFilename:%s, url:%s", this.FLb, str);
            }
            this.FKY.notifyDataSetChanged();
        }
        AppMethodBeat.o(29092);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29093);
        super.onCreate(bundle);
        this.qaD = bundle;
        this.FLE.alive();
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(67108864);
        }
        fullScreenNoTitleBar(true);
        this.FLf = getIntent().getBooleanExtra("isFromAppBrand", false);
        this.FLD = getIntent().getBooleanExtra("isFromAppBrandMpWebView", false);
        this.iAS = getIntent().getBooleanExtra("forBidForward", false);
        this.FLd = getIntent().getBooleanExtra("isFromWebView", false);
        this.FLg = getIntent().getBooleanExtra("showmenu", true);
        this.FLe = getIntent().getBooleanExtra("isOuntLink", false);
        this.iCZ = getIntent().getStringExtra("IsFromWebViewReffer");
        this.FLj = getIntent().getBooleanExtra("shouldShowScanQrCodeMenu", false);
        this.FLp = getIntent().getBooleanExtra("shouldRunDragAnimation", false);
        this.FLm = getIntent().getIntExtra("scanQrCodeGetA8KeyScene", 0);
        int[] intArrayExtra = getIntent().getIntArrayExtra("scanCodeTypes");
        if (intArrayExtra != null && intArrayExtra.length > 0) {
            for (int i2 : intArrayExtra) {
                this.FLn.add(Integer.valueOf(i2));
            }
        }
        int[] intArrayExtra2 = getIntent().getIntArrayExtra("scanResultCodeTypes");
        if (intArrayExtra2 != null && intArrayExtra2.length > 0) {
            for (int i3 : intArrayExtra2) {
                this.FLo.add(Integer.valueOf(i3));
            }
        }
        this.FLr = new a(this, this, this, this.FLe);
        this.iDk = getIntent().getStringExtra("cookie");
        Log.d("MicroMsg.GestureGalleryUI", "isFromWebView: %b, isFromWebViewReffer:%s, cookie = %s, forbidForward=%b", Boolean.valueOf(this.FLd), this.iCZ, this.iDk, Boolean.valueOf(this.iAS));
        this.FLc = new ag(this.FLd, this.iCZ);
        ag agVar = this.FLc;
        Log.d("MicroMsg.GetPicService", "addListener :" + hashCode());
        agVar.iDb = this;
        EventCenter.instance.addListener(this.teF);
        EventCenter.instance.addListener(this.Eqy);
        initView();
        this.FLK = false;
        if (this.FLf) {
            getWindow().setBackgroundDrawableResource(R.drawable.ban);
        }
        this.mHu = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a
            public final void bLz() {
                AppMethodBeat.i(29065);
                if (GestureGalleryUI.this.FLi != null && GestureGalleryUI.this.FLi.isShowing()) {
                    GestureGalleryUI.b(GestureGalleryUI.this);
                }
                AppMethodBeat.o(29065);
            }
        });
        this.FLw = (RelativeLayout) findViewById(R.id.dv1);
        if (this.FLh != null) {
            this.FLM = findViewById(R.id.i33);
            this.FLw.setVisibility(0);
            ((TextView) findViewById(R.id.gsz)).setTextSize(1, 12.0f);
            this.FLM.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass12 */

                public final void onClick(View view) {
                    AppMethodBeat.i(232087);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    try {
                        JSONObject optJSONObject = GestureGalleryUI.this.FLh.optJSONObject(GestureGalleryUI.this.FLa);
                        if (optJSONObject.optInt("jumpType", 0) == 9) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("feedId", optJSONObject.optString("feedId", ""));
                            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, optJSONObject.optJSONObject(IssueStorage.COLUMN_EXT_INFO));
                            jSONObject.put("extraInfo", optJSONObject.optString("extraInfo", ""));
                            ((aj) com.tencent.mm.kernel.g.ah(aj.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), jSONObject.toString(), null);
                        } else if (optJSONObject.optInt("jumpType", 0) == 2) {
                            String optString = optJSONObject.optString("userName");
                            String optString2 = optJSONObject.optString("weappUrl");
                            wq wqVar = new wq();
                            wqVar.ecI.userName = optString;
                            wqVar.ecI.ecK = optString2;
                            EventCenter.instance.publish(wqVar);
                        } else if (optJSONObject.optInt("jumpType", 0) == 3) {
                            String optString3 = optJSONObject.optString("jumpUrl");
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", optString3);
                            com.tencent.mm.br.c.b(GestureGalleryUI.this, "webview", ".ui.tools.WebviewMpUI", intent);
                        }
                    } catch (Exception e2) {
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(232087);
                }
            });
            findViewById(R.id.dwc).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass13 */

                public final void onClick(View view) {
                    AppMethodBeat.i(179710);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    GestureGalleryUI.b(GestureGalleryUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(179710);
                }
            });
            findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass14 */

                public final void onClick(View view) {
                    AppMethodBeat.i(232088);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    GestureGalleryUI.u(GestureGalleryUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(232088);
                }
            });
            AppMethodBeat.o(29093);
            return;
        }
        this.FLw.setVisibility(8);
        AppMethodBeat.o(29093);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(29094);
        super.onDestroy();
        ag agVar = this.FLc;
        Log.d("MicroMsg.GetPicService", "removeListener :" + hashCode());
        agVar.iDb = null;
        ag agVar2 = this.FLc;
        if (agVar2.iCX != null) {
            agVar2.iCX.iDf = true;
        }
        agVar2.iCX = null;
        EventCenter.instance.removeListener(this.teF);
        EventCenter.instance.removeListener(this.Eqy);
        this.FLE.dead();
        fixInputMethodManagerLeak(this);
        if (this.FLr != null) {
            a aVar = this.FLr;
            aVar.cWj();
            aVar.tgS.removeAllUpdateListeners();
            aVar.tgT.dead();
            com.tencent.mm.kernel.g.aAg().b(aVar.tgU);
            aVar.tgK = null;
            aVar.activity = null;
            aVar.FKT = null;
        }
        rl rlVar = new rl();
        rlVar.dYc.activity = this;
        EventCenter.instance.publish(rlVar);
        Log.i("MicroMsg.GestureGalleryUI", "stopVideo");
        if (this.FLu != null) {
            this.FLu.FLY.stopPlayback();
            this.FLB = c.Stop;
            this.FLz.setIsPlay(false);
            this.FLz.setIplaySeekCallback(null);
            this.FLu.EsM.setVisibility(0);
            this.FLu.wCz.setVisibility(0);
            this.FLu.FLY.setVisibility(8);
        }
        fto();
        AppMethodBeat.o(29094);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(29095);
        super.onPause();
        cWX();
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        f.e(false, true, true);
        AppMethodBeat.o(29095);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(29096);
        super.onResume();
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        f.e(true, true, true);
        AppMethodBeat.o(29096);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(29097);
        super.onStop();
        if (this.Eqn != null) {
            aw awVar = new aw();
            awVar.dDW.activity = this;
            awVar.dDW.dDX = this.Eqn;
            EventCenter.instance.publish(awVar);
            this.Eqn = null;
            this.FLl = 0;
            this.FLk = 0;
        }
        AppMethodBeat.o(29097);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bkx;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(29098);
        String nullAsNil = Util.nullAsNil(getIntent().getStringExtra("nowUrl"));
        this.msl = Util.nullAsNil(getIntent().getStringExtra("nowUrlPath"));
        this.FLJ = Util.nullAsNil(getIntent().getStringExtra("nowWebUrl"));
        this.type = getIntent().getIntExtra("type", 0);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("mediaSource");
        if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
            this.FLG.clear();
            this.FLG.addAll(parcelableArrayListExtra);
        }
        String[] stringArrayExtra = getIntent().getStringArrayExtra("urlList");
        if (stringArrayExtra == null || stringArrayExtra.length == 0) {
            String nullAsNil2 = Util.nullAsNil(getIntent().getStringExtra("htmlData"));
            int i2 = 0;
            while (i2 >= 0) {
                int indexOf = nullAsNil2.indexOf("weixin://viewimage/", i2);
                if (indexOf < 0 || (i2 = nullAsNil2.indexOf("\"", indexOf)) < 0) {
                    break;
                }
                String substring = nullAsNil2.substring(indexOf + 19, i2);
                Log.d("MicroMsg.GestureGalleryUI", "start:" + indexOf + " end:" + i2 + " url:" + substring);
                this.FLF.add(substring);
            }
        } else {
            this.FLF = Arrays.asList(stringArrayExtra);
        }
        String stringExtra = getIntent().getStringExtra("pageInfos");
        if (!Util.isNullOrNil(stringExtra)) {
            try {
                this.FLh = new JSONArray(stringExtra);
            } catch (Exception e2) {
            }
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.FLF.size()) {
                break;
            } else if (nullAsNil.equals(this.FLF.get(i3))) {
                this.FLH = i3;
                break;
            } else {
                i3++;
            }
        }
        this.FLI = this.FLH;
        if (getIntent().getIntExtra("currentPos", -1) >= 0) {
            this.FLI = getIntent().getIntExtra("currentPos", -1);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass21 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29074);
                GestureGalleryUI.this.cvQ();
                AppMethodBeat.o(29074);
                return true;
            }
        });
        this.FLq = (TextView) findViewById(R.id.g8d);
        this.qaz = (ImageView) findViewById(R.id.dcj);
        this.FLx = (RelativeLayout) findViewById(R.id.j6v);
        this.FLz = (RedesignVideoPlayerSeekBar) findViewById(R.id.j5y);
        this.FLy = (PressAlphaImageView) findViewById(R.id.j43);
        this.FLy.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(232089);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                GestureGalleryUI.this.cvQ();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232089);
            }
        });
        this.FLz.setPlayBtnOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(232090);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (GestureGalleryUI.this.FLz.cEF()) {
                    GestureGalleryUI.aa(GestureGalleryUI.this);
                } else {
                    GestureGalleryUI.ab(GestureGalleryUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232090);
            }
        });
        this.FLz.setVideoTotalTime(0);
        this.FLz.seek(0);
        this.FLz.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass17 */

            {
                AppMethodBeat.i(161447);
                AppMethodBeat.o(161447);
            }

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void aJq() {
            }

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void rk(int i2) {
                AppMethodBeat.i(232091);
                if (GestureGalleryUI.this.FLu != null) {
                    GestureGalleryUI.this.FLu.FLY.seekTo(i2 * 1000);
                }
                AppMethodBeat.o(232091);
            }
        });
        this.FKY = new a();
        this.FKZ = (MMGestureGallery) findViewById(R.id.dci);
        this.FKZ.setVisibility(0);
        this.FKZ.setVerticalFadingEdgeEnabled(false);
        this.FKZ.setHorizontalFadingEdgeEnabled(false);
        this.FKZ.setAdapter((SpinnerAdapter) this.FKY);
        this.FKZ.setSelection(this.FLH);
        this.FKZ.setOnItemSelectedListener(this.FLL);
        this.FKZ.setSingleClickOverListener(new MMGestureGallery.f() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass27 */

            @Override // com.tencent.mm.ui.tools.MMGestureGallery.f
            public final void bmt() {
                boolean z;
                boolean z2 = true;
                AppMethodBeat.i(29075);
                if (GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.this.FLH)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    GestureGalleryUI.a(GestureGalleryUI.this, !GestureGalleryUI.this.FLv);
                    GestureGalleryUI gestureGalleryUI = GestureGalleryUI.this;
                    if (GestureGalleryUI.this.FLv) {
                        z2 = false;
                    }
                    gestureGalleryUI.FLv = z2;
                    AppMethodBeat.o(29075);
                    return;
                }
                if (GestureGalleryUI.this.FLr.tgN != 1) {
                    GestureGalleryUI.this.cvQ();
                }
                AppMethodBeat.o(29075);
            }
        });
        final int intExtra = getIntent().getIntExtra("nevNext", 1);
        this.FKZ.setLongClickOverListener(new MMGestureGallery.c() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass28 */

            /* JADX WARNING: Code restructure failed: missing block: B:37:0x013c, code lost:
                if (java.util.Arrays.asList(r0).contains(com.tencent.mm.sdk.platformtools.LocaleUtil.getApplicationLanguage()) != false) goto L_0x00ce;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:0x0140, code lost:
                if (com.tencent.mm.protocal.d.KyS != false) goto L_0x00ce;
             */
            @Override // com.tencent.mm.ui.tools.MMGestureGallery.c
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void bmu() {
                /*
                // Method dump skipped, instructions count: 375
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass28.bmu():void");
            }
        });
        this.qaE = new com.tencent.mm.ui.tools.e(this);
        AppMethodBeat.o(29098);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(29099);
        Bundle bundle = this.qaD;
        if (!this.isAnimated && this.FLp) {
            this.isAnimated = true;
            this.qaF = getIntent().getIntExtra("img_gallery_top", 0);
            this.qaG = getIntent().getIntExtra("img_gallery_left", 0);
            this.qaH = getIntent().getIntExtra("img_gallery_width", 0);
            this.qaI = getIntent().getIntExtra("img_gallery_height", 0);
            this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
            if (bundle == null) {
                this.FKZ.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass29 */

                    public final boolean onPreDraw() {
                        AppMethodBeat.i(29078);
                        GestureGalleryUI.this.FKZ.getViewTreeObserver().removeOnPreDrawListener(this);
                        GestureGalleryUI.this.qaE.a(GestureGalleryUI.this.FKZ, null, null);
                        GestureGalleryUI.l(GestureGalleryUI.this);
                        AppMethodBeat.o(29078);
                        return true;
                    }
                });
            }
        }
        super.onStart();
        AppMethodBeat.o(29099);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(29101);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Log.d("MicroMsg.GestureGalleryUI", "dispatchKeyEvent");
            cvQ();
            AppMethodBeat.o(29101);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(29101);
        return dispatchKeyEvent;
    }

    private void wd(boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(29102);
        if (this.FLi == null) {
            this.FLi = new e((Context) getContext(), 1, false);
        }
        this.FLi.HLX = new o.f() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass32 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                long j2;
                long j3;
                AppMethodBeat.i(29085);
                GestureGalleryUI.this.FLi.setFooterView(null);
                mVar.clear();
                if (!GestureGalleryUI.p(GestureGalleryUI.this)) {
                    mVar.kV(1, R.string.ftk);
                    if (GestureGalleryUI.a(GestureGalleryUI.this, GestureGalleryUI.this.FLH)) {
                        mVar.kV(2, R.string.gav);
                    } else {
                        mVar.kV(2, R.string.gaq);
                    }
                    mVar.kV(3, R.string.fn9);
                }
                if (GestureGalleryUI.this.teC && !Util.isNullOrNil(GestureGalleryUI.this.FLb)) {
                    mVar.kV(4, R.string.az0);
                    a aVar = GestureGalleryUI.this.FLr;
                    ep epVar = new ep();
                    if (aVar.tgN == 2) {
                        j2 = 1;
                    } else {
                        j2 = 0;
                    }
                    epVar.erW = j2;
                    epVar.ejA = 2;
                    if (aVar.FKU) {
                        j3 = 6;
                    } else {
                        j3 = 5;
                    }
                    epVar.eDV = j3;
                    epVar.bfK();
                }
                if (GestureGalleryUI.r(GestureGalleryUI.this)) {
                    View s = GestureGalleryUI.s(GestureGalleryUI.this);
                    GestureGalleryUI.this.FLi.setFooterView(s);
                    if (s instanceof ViewTitleWithAnimation) {
                        if (mVar.size() > 1) {
                            ((ViewTitleWithAnimation) s).setTopPaddingVisibility(0);
                            AppMethodBeat.o(29085);
                            return;
                        }
                        ((ViewTitleWithAnimation) s).setTopPaddingVisibility(8);
                    }
                }
                AppMethodBeat.o(29085);
            }
        };
        this.FLi.HLY = new o.g() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass2 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                long j2;
                long j3;
                int i3 = 6;
                AppMethodBeat.i(29066);
                switch (menuItem.getItemId()) {
                    case 1:
                        GestureGalleryUI.t(GestureGalleryUI.this);
                        AppMethodBeat.o(29066);
                        return;
                    case 2:
                        GestureGalleryUI.u(GestureGalleryUI.this);
                        AppMethodBeat.o(29066);
                        return;
                    case 3:
                        GestureGalleryUI.v(GestureGalleryUI.this);
                        AppMethodBeat.o(29066);
                        return;
                    case 4:
                        if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(GestureGalleryUI.this.getContext())) {
                            GestureGalleryUI.d(GestureGalleryUI.this, 6);
                            a aVar = GestureGalleryUI.this.FLr;
                            String cVV = aVar.FKT.cVV();
                            if ((aVar.tgN == 0 || aVar.tgN == 2) && !Util.isNullOrNil(cVV)) {
                                ep epVar = new ep();
                                if (aVar.tgN == 2) {
                                    j2 = 1;
                                } else {
                                    j2 = 0;
                                }
                                epVar.erW = j2;
                                epVar.ejA = 3;
                                if (aVar.FKU) {
                                    j3 = 6;
                                } else {
                                    j3 = 5;
                                }
                                epVar.eDV = j3;
                                epVar.bfK();
                                aVar.tgM = (int) (((long) z.aTY().hashCode()) + System.currentTimeMillis());
                                fx translationResult = ((com.tencent.mm.plugin.scanner.e) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.scanner.e.class)).getTranslationResult(cVV);
                                if (translationResult == null || !s.YS(translationResult.field_resultFile)) {
                                    if (com.tencent.mm.kernel.g.azz().aYS() == 6 || com.tencent.mm.kernel.g.azz().aYS() == 4) {
                                        aVar.tgN = 1;
                                        aVar.tgP.setVisibility(0);
                                        aVar.tgQ.setVisibility(0);
                                        aVar.tgR.setVisibility(0);
                                        aVar.tgS.setRepeatMode(1);
                                        aVar.tgS.setRepeatCount(-1);
                                        aVar.tgS.start();
                                    } else {
                                        h.c(aVar.activity, aVar.activity.getString(R.string.x3), "", true);
                                        aVar.cWh();
                                    }
                                    Log.i("MicroMsg.GestureGalleryTransLogic", "try to translate img %s, sessionId %d", cVV, Integer.valueOf(aVar.tgM));
                                    to toVar = new to();
                                    to.a aVar2 = toVar.dZY;
                                    if (!aVar.FKU) {
                                        i3 = 5;
                                    }
                                    aVar2.scene = i3;
                                    toVar.dZY.filePath = cVV;
                                    toVar.dZY.dEb = aVar.tgM;
                                    EventCenter.instance.publish(toVar);
                                    break;
                                } else {
                                    Intent intent = new Intent();
                                    intent.putExtra("original_file_path", cVV);
                                    intent.putExtra("translate_source", aVar.FKU ? 6 : 5);
                                    intent.setClass(aVar.activity, TranslationResultUI.class);
                                    MMActivity mMActivity = aVar.activity;
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    mMActivity.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    aVar.activity.finish();
                                    aVar.activity.overridePendingTransition(R.anim.s, R.anim.s);
                                    AppMethodBeat.o(29066);
                                    return;
                                }
                            }
                        }
                        break;
                }
                AppMethodBeat.o(29066);
            }
        };
        this.FLi.PGl = new e.b() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
                AppMethodBeat.i(29067);
                GestureGalleryUI.d(GestureGalleryUI.this, 5);
                GestureGalleryUI.this.Eqp = null;
                GestureGalleryUI.this.Eqo = null;
                GestureGalleryUI.this.Eqq = null;
                GestureGalleryUI.this.Eqr = null;
                GestureGalleryUI.this.Eqn = null;
                GestureGalleryUI.this.FLk = 0;
                GestureGalleryUI.this.EqZ = 0;
                GestureGalleryUI.this.FLi = null;
                GestureGalleryUI.this.mHu.onDismiss();
                GestureGalleryUI.this.teC = false;
                AppMethodBeat.o(29067);
            }
        };
        if (!getContext().isFinishing()) {
            if (!this.iAS || ftl() || this.teC) {
                z2 = true;
            }
            if (z2) {
                this.FLi.dGm();
            }
        }
        if (this.FLj && Util.isNullOrNil(this.Eqn) && bg.azz().aYS() != 0) {
            qx qxVar = new qx();
            qxVar.dXu.dDZ = System.currentTimeMillis();
            qxVar.dXu.filePath = this.FLb;
            qxVar.dXu.dXv = new HashSet(this.FLn);
            this.Eqk = this.FLb;
            EventCenter.instance.publish(qxVar);
        }
        if (!Util.isNullOrNil(this.FLb)) {
            com.tencent.mm.kernel.g.aAi();
            if (com.tencent.mm.kernel.g.aAg().hqi.aYS() != 0 && z) {
                a aVar = this.FLr;
                String str = this.FLb;
                if (aVar.activity == null || aVar.activity.isFinishing()) {
                    AppMethodBeat.o(29102);
                    return;
                }
                if (aVar.tgL == null) {
                    aVar.tgL = new ImageWordScanDetailEngine(aVar.activity);
                }
                aVar.tgL.a(str, aVar.tgK);
            }
        }
        AppMethodBeat.o(29102);
    }

    private void xV(int i2) {
        AppMethodBeat.i(232101);
        if (this.FLs == null || Util.isNullOrNil(this.FLJ)) {
            AppMethodBeat.o(232101);
            return;
        }
        this.FLs.url = this.FLJ;
        this.FLs.ehX = this.FLm;
        if (!Util.isNullOrNil(this.Eqn)) {
            this.FLs.JBD = true;
            this.FLs.ahn(this.FLk);
            this.FLs.scanResult = this.Eqn;
        }
        this.FLs.zfq = com.tencent.mm.pluginsdk.ui.tools.z.bfG(this.FLt);
        this.FLs.pl(i2);
        AppMethodBeat.o(232101);
    }

    @Override // com.tencent.mm.plugin.subapp.ui.gallery.a.AbstractC1792a
    public final String cVV() {
        return this.FLb;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        public a() {
        }

        public final int getCount() {
            AppMethodBeat.i(29086);
            Log.d("MicroMsg.GestureGalleryUI", "lstpicurl:" + GestureGalleryUI.this.FLF.size());
            int size = GestureGalleryUI.this.FLF.size();
            AppMethodBeat.o(29086);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(29087);
            Integer valueOf = Integer.valueOf(i2);
            AppMethodBeat.o(29087);
            return valueOf;
        }

        public final View ftp() {
            AppMethodBeat.i(29088);
            View abm = abm(GestureGalleryUI.this.FKZ.getSelectedItemPosition());
            AppMethodBeat.o(29088);
            return abm;
        }

        private View abm(int i2) {
            AppMethodBeat.i(29089);
            int firstVisiblePosition = GestureGalleryUI.this.FKZ.getFirstVisiblePosition();
            int childCount = (GestureGalleryUI.this.FKZ.getChildCount() + firstVisiblePosition) - 1;
            if (i2 < firstVisiblePosition || i2 > childCount) {
                View view = GestureGalleryUI.this.FKZ.getAdapter().getView(i2, null, GestureGalleryUI.this.FKZ);
                AppMethodBeat.o(29089);
                return view;
            }
            View childAt = GestureGalleryUI.this.FKZ.getChildAt(i2 - firstVisiblePosition);
            AppMethodBeat.o(29089);
            return childAt;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:95:0x02a6, code lost:
            if (r5 == false) goto L_0x0309;
         */
        /* JADX WARNING: Removed duplicated region for block: B:129:0x03ba  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0134  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0145  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x018f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.view.View getView(int r11, android.view.View r12, android.view.ViewGroup r13) {
            /*
            // Method dump skipped, instructions count: 992
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }

        /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI$a$a  reason: collision with other inner class name */
        public class C1791a {
            ImageView EsM;
            ProgressBar FLW;
            MMAnimateView FLX;
            VideoView FLY;
            View FLZ;
            TextView FMa;
            ImageView wCz;
            View xgq;

            public C1791a() {
            }
        }
    }

    private boolean ftl() {
        AppMethodBeat.i(169766);
        if (!this.FLj || Util.isNullOrNil(this.Eqn)) {
            AppMethodBeat.o(169766);
            return false;
        }
        AppMethodBeat.o(169766);
        return true;
    }

    private static void fixInputMethodManagerLeak(Context context) {
        AppMethodBeat.i(29103);
        if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT > 22) {
            AppMethodBeat.o(29103);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(29103);
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i2]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if (obj != null && (obj instanceof View)) {
                    if (((View) obj).getContext() == context) {
                        declaredField.set(inputMethodManager, null);
                    } else {
                        AppMethodBeat.o(29103);
                        return;
                    }
                }
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(29103);
    }

    /* access modifiers changed from: package-private */
    public enum c {
        Idle,
        Prepared,
        Start,
        Resume,
        Paused,
        Complete,
        Stop,
        Error;

        public static c valueOf(String str) {
            AppMethodBeat.i(179721);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(179721);
            return cVar;
        }

        static {
            AppMethodBeat.i(179722);
            AppMethodBeat.o(179722);
        }
    }

    private boolean abl(int i2) {
        AppMethodBeat.i(232102);
        if (this.FLG == null || this.FLG.size() <= i2 || this.FLG.get(i2) == null || !"video".endsWith(this.FLG.get(i2).igV)) {
            AppMethodBeat.o(232102);
            return false;
        }
        AppMethodBeat.o(232102);
        return true;
    }

    private String ftm() {
        HttpProxyCacheServer httpProxyCacheServer;
        AppMethodBeat.i(179723);
        if (this.FLH < 0 || this.FLG == null || this.FLG.size() == 0) {
            AppMethodBeat.o(179723);
            return "";
        }
        String str = this.FLG.get(this.FLH).url;
        Log.i("MicroMsg.GestureGalleryUI", "playVideo  url :%s", str);
        if (str == null || !str.startsWith("http")) {
            AppMethodBeat.o(179723);
            return str;
        }
        if (com.tencent.mm.plugin.z.a.GwW == null) {
            File file = new File(com.tencent.mm.loader.j.b.aLA());
            if (!file.exists() || !file.isDirectory()) {
                file.mkdir();
            }
            httpProxyCacheServer = new HttpProxyCacheServer.Builder(this).maxCacheSize(134217728).cacheDirectory(file).build();
            com.tencent.mm.plugin.z.a.GwW = httpProxyCacheServer;
        } else {
            httpProxyCacheServer = com.tencent.mm.plugin.z.a.GwW;
        }
        String proxyUrl = httpProxyCacheServer.getProxyUrl(str);
        AppMethodBeat.o(179723);
        return proxyUrl;
    }

    private void cWX() {
        AppMethodBeat.i(179724);
        Log.i("MicroMsg.GestureGalleryUI", "pauseVideo");
        if (this.FLu != null) {
            this.FLA = (long) (this.FLz.getmPosition() * 1000);
            Log.i("MicroMsg.GestureGalleryUI", "pauseVideo currentVideoPos：%d", Long.valueOf(this.FLA));
            this.FLu.FLY.pause();
            this.FLu.EsM.setVisibility(0);
            if (this.FLB == c.Start || this.FLB == c.Resume) {
                this.FLB = c.Paused;
                this.FLC = true;
            } else {
                c cVar = c.Paused;
            }
            this.FLz.setIsPlay(false);
        }
        fto();
        AppMethodBeat.o(179724);
    }

    private void ftn() {
        AppMethodBeat.i(179725);
        fto();
        this.FLN = new b(this, (byte) 0);
        b bVar = this.FLN;
        bVar.isStop = false;
        ThreadPool.post(bVar, "gesture_gallery_ui_video_update_progress");
        AppMethodBeat.o(179725);
    }

    private void fto() {
        if (this.FLN != null) {
            this.FLN.isStop = true;
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        boolean isStop;

        private b() {
            this.isStop = true;
        }

        /* synthetic */ b(GestureGalleryUI gestureGalleryUI, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(179719);
            Log.i("MicroMsg.GestureGalleryUI", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (GestureGalleryUI.this.FLB == c.Start || GestureGalleryUI.this.FLB == c.Prepared || GestureGalleryUI.this.FLB == c.Resume) {
                        GestureGalleryUI gestureGalleryUI = GestureGalleryUI.this;
                        if (gestureGalleryUI.FLu != null) {
                            gestureGalleryUI.FLz.post(new Runnable() {
                                /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass24 */

                                public final void run() {
                                    AppMethodBeat.i(232097);
                                    GestureGalleryUI.this.FLz.seek(GestureGalleryUI.this.FLu.FLY.getCurrentPosition() / 1000);
                                    AppMethodBeat.o(232097);
                                }
                            });
                        }
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.GestureGalleryUI", "PlayProgressTask run exception:" + e2.getMessage());
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e3) {
                }
            }
            AppMethodBeat.o(179719);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(179726);
        if (i2 == 1 && -1 == i3) {
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            final q a2 = h.a((Context) getContext(), getString(R.string.ys), false, (DialogInterface.OnCancelListener) null);
            final AnonymousClass25 r4 = new Runnable() {
                /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass25 */

                public final void run() {
                    AppMethodBeat.i(232098);
                    a2.dismiss();
                    AppMethodBeat.o(232098);
                }
            };
            if (Util.isNullOrNil(stringExtra)) {
                AppMethodBeat.o(179726);
                return;
            }
            for (final String str : Util.stringsToList(stringExtra.split(","))) {
                final String str2 = this.FLG.get(this.FLH).igW;
                if (!s.YS(str2)) {
                    str2 = this.FLc.c(str2, this.type, this.FLH, this.iDk);
                }
                Log.i("MicroMsg.GestureGalleryUI", "onActivityResult,  sendVideo video:%s,  thumbFilename:%s", ftm(), str2);
                com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass26 */

                    public final void run() {
                        AppMethodBeat.i(232099);
                        com.tencent.mm.plugin.messenger.a.g.eir().a(GestureGalleryUI.this.getContext(), str, GestureGalleryUI.E(GestureGalleryUI.this), str2, 1, (int) GestureGalleryUI.this.pLQ, "", "");
                        MMHandlerThread.postToMainThread(r4);
                        AppMethodBeat.o(232099);
                    }

                    public final String toString() {
                        AppMethodBeat.i(232100);
                        String str = super.toString() + "send video";
                        AppMethodBeat.o(232100);
                        return str;
                    }
                });
                if (!Util.isNullOrNil(stringExtra2)) {
                    com.tencent.mm.plugin.messenger.a.g.eir().ad(str, stringExtra2, ab.JG(str));
                }
            }
            com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.string.dc_));
            AppMethodBeat.o(179726);
            return;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(179726);
    }

    public final void cvQ() {
        int i2;
        AppMethodBeat.i(29100);
        if (this.FKZ.getSelectedItemPosition() != this.FLI || !this.FLp) {
            finish();
            overridePendingTransition(0, 0);
            AppMethodBeat.o(29100);
        } else if (this.FLK || this.FKY == null) {
            Log.i("MicroMsg.GestureGalleryUI", "isRunningExitAnimation");
            AppMethodBeat.o(29100);
        } else {
            Log.i("MicroMsg.GestureGalleryUI", "runExitAnimation");
            int width = this.FKZ.getWidth();
            int height = this.FKZ.getHeight();
            int selectedItemPosition = this.FKZ.getSelectedItemPosition();
            String str = this.FLF.get(selectedItemPosition);
            if (!s.YS(str)) {
                str = this.FLc.c(str, this.type, selectedItemPosition, this.iDk);
            }
            if (!Util.isNullOrNil(str)) {
                BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
                i2 = (int) (((float) imageOptions.outHeight) * (((float) width) / ((float) imageOptions.outWidth)));
                if (i2 > this.FKZ.getHeight()) {
                    if (((double) i2) < ((double) this.FKZ.getHeight()) * 2.5d) {
                        this.qaI = (this.FKZ.getHeight() * this.qaI) / i2;
                    }
                    i2 = this.FKZ.getHeight();
                }
            } else {
                i2 = height;
            }
            this.qaE.ls(width, i2);
            this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
            if (((double) this.EAC) != 1.0d) {
                this.qaE.QtG = 1.0f / this.EAC;
                if (!(this.EAD == 0 && this.EAE == 0)) {
                    this.qaE.lu(((int) (((float) (this.FKZ.getWidth() / 2)) * (1.0f - this.EAC))) + this.EAD, (int) (((float) ((this.FKZ.getHeight() / 2) + this.EAE)) - (((float) (i2 / 2)) * this.EAC)));
                }
            }
            this.qaE.a(this.FKZ, this.qaz, new e.c() {
                /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass30 */

                @Override // com.tencent.mm.ui.tools.e.c
                public final void onAnimationStart() {
                    AppMethodBeat.i(29081);
                    GestureGalleryUI.this.FLK = true;
                    GestureGalleryUI.this.mHandler.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass30.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(29079);
                            View ftp = GestureGalleryUI.this.FKY.ftp();
                            if (ftp instanceof MultiTouchImageView) {
                                ((MultiTouchImageView) ftp).gKy();
                            }
                            AppMethodBeat.o(29079);
                        }
                    }, 20);
                    AppMethodBeat.o(29081);
                }

                @Override // com.tencent.mm.ui.tools.e.c
                public final void onAnimationEnd() {
                    AppMethodBeat.i(29082);
                    GestureGalleryUI.this.mHandler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass30.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(29080);
                            GestureGalleryUI.this.finish();
                            GestureGalleryUI.this.overridePendingTransition(0, 0);
                            AppMethodBeat.o(29080);
                        }
                    });
                    GestureGalleryUI.this.FLK = false;
                    AppMethodBeat.o(29082);
                }
            }, null);
            AppMethodBeat.o(29100);
        }
    }

    static /* synthetic */ void b(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.i(29105);
        gestureGalleryUI.wd(false);
        AppMethodBeat.o(29105);
    }

    static /* synthetic */ void a(GestureGalleryUI gestureGalleryUI, boolean z) {
        AppMethodBeat.i(169767);
        if (z) {
            gestureGalleryUI.FLx.setVisibility(0);
            AppMethodBeat.o(169767);
            return;
        }
        gestureGalleryUI.FLx.setVisibility(8);
        AppMethodBeat.o(169767);
    }

    static /* synthetic */ void a(GestureGalleryUI gestureGalleryUI, final String str) {
        AppMethodBeat.i(232104);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(232104);
            return;
        }
        if (com.tencent.mm.pluginsdk.ui.applet.o.b(gestureGalleryUI.mController, str, true, new y.a() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass7 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                AppMethodBeat.i(232081);
                if (z) {
                    if (com.tencent.mm.plugin.sns.b.o.DCL != null) {
                        com.tencent.mm.plugin.sns.b.o.DCL.jW(str, str);
                        com.tencent.mm.plugin.sns.b.o.DCL.eZn();
                    }
                    h.cD(GestureGalleryUI.this, GestureGalleryUI.this.getResources().getString(R.string.z0));
                }
                AppMethodBeat.o(232081);
            }
        }) == null) {
            Log.e("MicroMsg.GestureGalleryUI", "doTimeline fail, cannot show dialog");
        }
        AppMethodBeat.o(232104);
    }

    static /* synthetic */ void l(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.i(232105);
        if (gestureGalleryUI.FLp) {
            gestureGalleryUI.FKZ.setGalleryScaleListener(new MMGestureGallery.b() {
                /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass31 */

                @Override // com.tencent.mm.ui.tools.MMGestureGallery.b
                public final void S(float f2, float f3) {
                    float f4 = 1.0f;
                    AppMethodBeat.i(29083);
                    if (GestureGalleryUI.this.FKZ.getHeight() <= 0) {
                        AppMethodBeat.o(29083);
                        return;
                    }
                    float height = 1.0f - (f3 / ((float) GestureGalleryUI.this.FKZ.getHeight()));
                    if (height <= 1.0f) {
                        f4 = height;
                    }
                    Log.d("MicroMsg.GestureGalleryUI", "onGalleryScale tx: %f, ty: %f, scale: %f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
                    GestureGalleryUI.this.EAC = f4;
                    View ftp = GestureGalleryUI.this.FKY.ftp();
                    if (ftp != null) {
                        ftp.setPivotX((float) (GestureGalleryUI.this.FKZ.getWidth() / 2));
                        ftp.setPivotY((float) (GestureGalleryUI.this.FKZ.getHeight() / 2));
                        ftp.setScaleX(f4);
                        ftp.setScaleY(f4);
                        ftp.setTranslationX(f2);
                        ftp.setTranslationY(f3);
                        GestureGalleryUI.this.qaz.setAlpha(f4);
                        AppMethodBeat.o(29083);
                        return;
                    }
                    Log.d("MicroMsg.GestureGalleryUI", "runDragAnimation contentView is null !!");
                    AppMethodBeat.o(29083);
                }

                @Override // com.tencent.mm.ui.tools.MMGestureGallery.b
                public final void T(float f2, float f3) {
                    AppMethodBeat.i(29084);
                    GestureGalleryUI.this.EAD = (int) f2;
                    GestureGalleryUI.this.EAE = (int) f3;
                    AppMethodBeat.o(29084);
                }
            });
        }
        AppMethodBeat.o(232105);
    }

    static /* synthetic */ View s(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.i(232107);
        View a2 = gestureGalleryUI.mHu.a(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(232080);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.GestureGalleryUI", "request deal QBAR string");
                if (GestureGalleryUI.this.FLi != null && GestureGalleryUI.this.FLi.isShowing()) {
                    GestureGalleryUI.this.FLi.bMo();
                }
                GestureGalleryUI.d(GestureGalleryUI.this, 4);
                cr crVar = new cr();
                crVar.dFK.activity = GestureGalleryUI.this;
                crVar.dFK.dDX = GestureGalleryUI.this.Eqn;
                crVar.dFK.dFL = GestureGalleryUI.this.FLk;
                crVar.dFK.dFM = GestureGalleryUI.this.FLl;
                crVar.dFK.scene = 40;
                crVar.dFK.dFP = GestureGalleryUI.this.getIntent().getBundleExtra("_stat_obj");
                EventCenter.instance.publish(crVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232080);
            }
        }, gestureGalleryUI.FLk, gestureGalleryUI.Eqn, 8);
        AppMethodBeat.o(232107);
        return a2;
    }

    static /* synthetic */ void t(GestureGalleryUI gestureGalleryUI) {
        EmojiInfo emojiInfo;
        boolean z;
        AppMethodBeat.i(232108);
        if (Util.isNullOrNil(gestureGalleryUI.FLb)) {
            Log.w("MicroMsg.GestureGalleryUI", "share image to friend fail, imgPath is null");
            AppMethodBeat.o(232108);
            return;
        }
        gestureGalleryUI.xV(1);
        if (ImgUtil.isGif(gestureGalleryUI.FLb)) {
            EmojiInfo aml = ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().aml(s.bhK(gestureGalleryUI.FLb));
            if (aml == null) {
                com.tencent.mm.pluginsdk.a.d emojiMgr = ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr();
                MMApplicationContext.getContext();
                emojiInfo = ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().aml(emojiMgr.amn(gestureGalleryUI.FLb));
            } else {
                emojiInfo = aml;
            }
            long boW = emojiInfo == null ? 0 : s.boW(emojiInfo.hYx());
            String hYx = emojiInfo == null ? gestureGalleryUI.FLb : emojiInfo.hYx();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            if ((BitmapUtil.decodeFile(hYx, options) == null || options.outHeight <= com.tencent.mm.n.c.aqo()) && options.outWidth <= com.tencent.mm.n.c.aqo()) {
                z = false;
            } else {
                z = true;
            }
            if (boW > ((long) com.tencent.mm.n.c.aqp()) || z) {
                h.a(gestureGalleryUI.getContext(), gestureGalleryUI.getString(R.string.bs3), "", gestureGalleryUI.getString(R.string.e2u), (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(232108);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("Retr_File_Name", emojiInfo == null ? "" : emojiInfo.getMd5());
            intent.putExtra("Retr_Msg_Type", 5);
            intent.putExtra("Retr_MsgImgScene", 1);
            com.tencent.mm.plugin.subapp.b.jRt.k(intent, gestureGalleryUI.getContext());
            AppMethodBeat.o(232108);
        } else if (gestureGalleryUI.abl(gestureGalleryUI.FLH)) {
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(232077);
                    Log.i("MicroMsg.GestureGalleryUI", "send video to friend");
                    final String str = AndroidMediaUtil.getSysCameraDirPath() + s.bhK(GestureGalleryUI.E(GestureGalleryUI.this)) + ".mp4";
                    if (!new com.tencent.mm.vfs.o(str).exists()) {
                        if (s.nw(GestureGalleryUI.E(GestureGalleryUI.this), str) < 0) {
                            Log.e("MicroMsg.GestureGalleryUI", "copy file fail origin path:%s", GestureGalleryUI.E(GestureGalleryUI.this));
                            AppMethodBeat.o(232077);
                            return;
                        }
                        com.tencent.mm.pluginsdk.ui.tools.s.refreshMediaScanner(str, GestureGalleryUI.this);
                    }
                    GestureGalleryUI.this.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(232076);
                            long j2 = -1;
                            com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(str);
                            if (oVar.exists()) {
                                j2 = oVar.length();
                            }
                            Log.i("MicroMsg.GestureGalleryUI", "send video to file size :%d, MaxSendVideoSize:%d", Long.valueOf(j2), Integer.valueOf(com.tencent.mm.n.c.aqq()));
                            if (j2 <= 0) {
                                h.a(GestureGalleryUI.this.getContext(), GestureGalleryUI.this.getString(R.string.dmn), "", GestureGalleryUI.this.getString(R.string.e2u), (DialogInterface.OnClickListener) null);
                                AppMethodBeat.o(232076);
                            } else if (j2 > ((long) com.tencent.mm.n.c.aqq())) {
                                h.a(GestureGalleryUI.this.getContext(), GestureGalleryUI.this.getString(R.string.dn7), "", GestureGalleryUI.this.getString(R.string.e2u), (DialogInterface.OnClickListener) null);
                                AppMethodBeat.o(232076);
                            } else {
                                Log.i("MicroMsg.GestureGalleryUI", "select contact in SelectConversationUI");
                                Intent intent = new Intent();
                                intent.putExtra("image_path", GestureGalleryUI.E(GestureGalleryUI.this));
                                intent.putExtra("Retr_Msg_Type", 1);
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("select_is_ret", true);
                                intent.putExtra("mutil_select_is_ret", true);
                                com.tencent.mm.br.c.c(GestureGalleryUI.this.getContext(), ".ui.transmit.SelectConversationUI", intent, 1);
                                AppMethodBeat.o(232076);
                            }
                        }
                    });
                    AppMethodBeat.o(232077);
                }
            }, "");
            AppMethodBeat.o(232108);
        } else {
            Intent intent2 = new Intent();
            intent2.putExtra("Retr_File_Name", gestureGalleryUI.FLb);
            intent2.putExtra("Retr_Compress_Type", 0);
            intent2.putExtra("Retr_Msg_Type", 0);
            com.tencent.mm.plugin.subapp.b.jRt.k(intent2, gestureGalleryUI.getContext());
            AppMethodBeat.o(232108);
        }
    }

    static /* synthetic */ void u(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.i(232109);
        if (gestureGalleryUI.FLb == null || gestureGalleryUI.FLb.equals("")) {
            AppMethodBeat.o(232109);
            return;
        }
        gestureGalleryUI.xV(2);
        bg.aVF();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            u.g(gestureGalleryUI, null);
            AppMethodBeat.o(232109);
        } else if (gestureGalleryUI.abl(gestureGalleryUI.FLH)) {
            p.b(gestureGalleryUI, gestureGalleryUI.ftm(), new p.a() {
                /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass5 */

                @Override // com.tencent.mm.platformtools.p.a
                public final void bP(String str, String str2) {
                    AppMethodBeat.i(232078);
                    Toast.makeText(GestureGalleryUI.this, GestureGalleryUI.this.getString(R.string.hwu, new Object[]{AndroidMediaUtil.getFriendlySdcardPath(str2)}), 1).show();
                    com.tencent.mm.pluginsdk.ui.tools.s.refreshMediaScanner(str2, GestureGalleryUI.this);
                    AppMethodBeat.o(232078);
                }

                @Override // com.tencent.mm.platformtools.p.a
                public final void bQ(String str, String str2) {
                    AppMethodBeat.i(232079);
                    Toast.makeText(GestureGalleryUI.this, GestureGalleryUI.this.getString(R.string.hwt), 1).show();
                    AppMethodBeat.o(232079);
                }
            });
            AppMethodBeat.o(232109);
        } else {
            com.tencent.mm.pluginsdk.ui.tools.s.l(gestureGalleryUI.FLb, gestureGalleryUI);
            AppMethodBeat.o(232109);
        }
    }

    static /* synthetic */ void v(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.i(232110);
        gestureGalleryUI.xV(3);
        if (gestureGalleryUI.abl(gestureGalleryUI.FLH)) {
            cz czVar = new cz();
            String str = gestureGalleryUI.FLG.get(gestureGalleryUI.FLH).igW;
            if (!s.YS(str)) {
                str = gestureGalleryUI.FLc.c(str, gestureGalleryUI.type, gestureGalleryUI.FLH, gestureGalleryUI.iDk);
            }
            com.tencent.mm.pluginsdk.model.h.a(czVar, 1, gestureGalleryUI.FLb, str, 0, "", "", true);
            czVar.dFZ.activity = gestureGalleryUI;
            czVar.dFZ.dGf = 32;
            EventCenter.instance.publish(czVar);
            AppMethodBeat.o(232110);
            return;
        }
        cz czVar2 = new cz();
        com.tencent.mm.pluginsdk.model.h.a(czVar2, 1, gestureGalleryUI.FLb);
        czVar2.dFZ.activity = gestureGalleryUI;
        czVar2.dFZ.dGf = 32;
        EventCenter.instance.publish(czVar2);
        AppMethodBeat.o(232110);
    }

    static /* synthetic */ void b(GestureGalleryUI gestureGalleryUI, a.C1791a aVar) {
        AppMethodBeat.i(232113);
        Log.i("MicroMsg.GestureGalleryUI", "fillVideoView");
        aVar.EsM.setVisibility(0);
        aVar.FLW.setVisibility(8);
        aVar.FLZ.setVisibility(8);
        aVar.EsM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass18 */

            {
                AppMethodBeat.i(161448);
                AppMethodBeat.o(161448);
            }

            public final void onClick(View view) {
                AppMethodBeat.i(232092);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                GestureGalleryUI.ab(GestureGalleryUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232092);
            }
        });
        aVar.FLY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass19 */

            public final void onPrepared(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(232093);
                Log.i("MicroMsg.GestureGalleryUI", "mediaPlayer onPrepared");
                if (GestureGalleryUI.this.FLu != null) {
                    GestureGalleryUI.this.FLu.FLW.setVisibility(8);
                    GestureGalleryUI.this.FLu.wCz.setVisibility(8);
                    GestureGalleryUI.this.FLu.FLY.setVisibility(0);
                }
                if (mediaPlayer != null) {
                    GestureGalleryUI.this.pLQ = (long) Util.videoMsToSec((long) mediaPlayer.getDuration());
                    GestureGalleryUI.this.FLz.setVideoTotalTime((int) GestureGalleryUI.this.pLQ);
                    if (GestureGalleryUI.this.FLC) {
                        if (GestureGalleryUI.this.FLB == c.Start || GestureGalleryUI.this.FLB == c.Resume) {
                            GestureGalleryUI.this.FLC = false;
                        }
                        if (GestureGalleryUI.this.FLA >= 0) {
                            GestureGalleryUI.this.FLu.FLY.seekTo((int) GestureGalleryUI.this.FLA);
                            GestureGalleryUI.this.FLz.seek(((int) GestureGalleryUI.this.FLA) / 1000);
                        }
                        GestureGalleryUI.this.FLB = c.Paused;
                        AppMethodBeat.o(232093);
                        return;
                    }
                    GestureGalleryUI.this.FLB = c.Prepared;
                }
                AppMethodBeat.o(232093);
            }
        });
        aVar.FLY.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass20 */

            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(232094);
                Log.i("MicroMsg.GestureGalleryUI", "mediaPlayer onError i:%d, i!:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (GestureGalleryUI.this.FLu != null) {
                    GestureGalleryUI.this.FLu.FLW.setVisibility(8);
                    GestureGalleryUI.this.FLu.FLZ.setVisibility(0);
                    GestureGalleryUI.this.FLu.wCz.setVisibility(0);
                    GestureGalleryUI.this.FLu.FLY.setVisibility(8);
                    GestureGalleryUI.this.FLu.FMa.setText(GestureGalleryUI.this.getString(R.string.hxg));
                }
                GestureGalleryUI.this.FLz.setIsPlay(false);
                GestureGalleryUI.this.FLB = c.Error;
                GestureGalleryUI.ag(GestureGalleryUI.this);
                AppMethodBeat.o(232094);
                return false;
            }
        });
        aVar.FLY.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass22 */

            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(232095);
                Log.i("MicroMsg.GestureGalleryUI", "mediaPlayer onCompletion");
                if (mediaPlayer != null && !mediaPlayer.isLooping()) {
                    if (GestureGalleryUI.this.FLu != null) {
                        GestureGalleryUI.this.FLu.EsM.setVisibility(0);
                        GestureGalleryUI.this.FLu.wCz.setVisibility(0);
                        GestureGalleryUI.this.FLu.FLY.setVisibility(8);
                    }
                    GestureGalleryUI.this.FLz.setIsPlay(false);
                    GestureGalleryUI.this.FLB = c.Complete;
                    GestureGalleryUI.ag(GestureGalleryUI.this);
                }
                AppMethodBeat.o(232095);
            }
        });
        aVar.FLY.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.AnonymousClass23 */

            public final boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(232096);
                Log.i("MicroMsg.GestureGalleryUI", "mediaPlayer onInfo what:%d, extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (i2 == 3) {
                    GestureGalleryUI.this.FLB = c.Start;
                }
                AppMethodBeat.o(232096);
                return false;
            }
        });
        AppMethodBeat.o(232113);
    }

    static /* synthetic */ void ab(GestureGalleryUI gestureGalleryUI) {
        AppMethodBeat.i(232115);
        Log.i("MicroMsg.GestureGalleryUI", "resumeVideo");
        if (gestureGalleryUI.FLu == null || gestureGalleryUI.FLu.FLY.isPlaying() || gestureGalleryUI.FLB != c.Paused) {
            Log.i("MicroMsg.GestureGalleryUI", "call playVideo");
            if (gestureGalleryUI.FLu == null || gestureGalleryUI.FLH < 0 || gestureGalleryUI.FLG == null || gestureGalleryUI.FLG.size() == 0) {
                Log.e("MicroMsg.GestureGalleryUI", "playVideo fail");
                AppMethodBeat.o(232115);
                return;
            }
            Log.i("MicroMsg.GestureGalleryUI", "playVideo");
            gestureGalleryUI.ftn();
            gestureGalleryUI.FLz.setIsPlay(true);
            String ftm = gestureGalleryUI.ftm();
            gestureGalleryUI.FLu.EsM.setVisibility(8);
            gestureGalleryUI.FLu.FLW.setVisibility(0);
            gestureGalleryUI.FLu.FLZ.setVisibility(8);
            gestureGalleryUI.FLu.FLY.setVisibility(0);
            gestureGalleryUI.FLu.FLY.setVideoURI(Uri.parse(ftm));
            gestureGalleryUI.FLu.FLY.start();
            gestureGalleryUI.FLB = c.Start;
            AppMethodBeat.o(232115);
            return;
        }
        if (gestureGalleryUI.FLA >= 0) {
            gestureGalleryUI.FLu.FLY.seekTo((int) gestureGalleryUI.FLA);
            gestureGalleryUI.FLz.seek(((int) gestureGalleryUI.FLA) / 1000);
        }
        gestureGalleryUI.FLu.FLY.start();
        gestureGalleryUI.FLu.EsM.setVisibility(8);
        if (gestureGalleryUI.FLu.wCz.getVisibility() == 0) {
            gestureGalleryUI.FLu.wCz.setVisibility(8);
        }
        gestureGalleryUI.FLB = c.Resume;
        gestureGalleryUI.FLz.setIsPlay(true);
        gestureGalleryUI.ftn();
        Log.i("MicroMsg.GestureGalleryUI", "start");
        AppMethodBeat.o(232115);
    }
}
