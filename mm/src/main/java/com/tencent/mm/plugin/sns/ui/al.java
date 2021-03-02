package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.g.b.a.ii;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.recordvideo.e.d;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.f.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class al implements ad, a.AbstractC1737a {
    private int DEA;
    private int DPi = 1;
    private boolean DSg;
    private List<String> Eoz;
    private int EpG;
    private k EpM = null;
    private String EpN = "";
    private boolean Ero = false;
    private boolean Erp = false;
    private WXMediaMessage Erq = null;
    SightPlayImageView EsO;
    private ImageView EsP = null;
    boolean EsQ = false;
    private Bitmap EsR = null;
    private cly EsS = new cly();
    private String EsT;
    private boolean EsU = false;
    boolean EsV = false;
    private int EsW = 0;
    private MediaMetadataRetriever EsX = new d();
    private int EsY = 0;
    private int EsZ = 0;
    private int Eta = 90;
    private Pair<Integer, Integer> Etb = null;
    private Bitmap Etc = null;
    boolean Etd = false;
    private boolean Ete = false;
    a Etf;
    private i Etg;
    bf Eth = null;
    private int Eti = 0;
    private int Etj;
    private org.b.d.i Etk;
    private String Etl;
    private cjy Etm;
    private int Etn;
    private List<String> Eto;
    private PInt Etp;
    private int Etq;
    private int Etr;
    Runnable Ets = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.al.AnonymousClass5 */

        public final void run() {
            AppMethodBeat.i(97993);
            al.a(al.this);
            AppMethodBeat.o(97993);
        }
    };
    Runnable Ett = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.al.AnonymousClass6 */

        public final void run() {
            AppMethodBeat.i(97995);
            Log.i("MicroMsg.SightWidget", "showProgress");
            al alVar = al.this;
            MMActivity mMActivity = al.this.gte;
            al.this.gte.getString(R.string.zb);
            alVar.gtM = h.a((Context) mMActivity, al.this.gte.getString(R.string.h_t), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.sns.ui.al.AnonymousClass6.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(97994);
                    al.this.Eth = null;
                    al.this.EsQ = false;
                    MMHandlerThread.removeRunnable(al.this.Ets);
                    AppMethodBeat.o(97994);
                }
            });
            AppMethodBeat.o(97995);
        }
    };
    private String appId;
    private String appName;
    private String canvasInfo;
    private boolean dGX = false;
    String desc = "";
    private LinkedList<Long> gYE;
    ProgressDialog gtM = null;
    MMActivity gte;
    String iwX;
    private String mSessionId;
    String md5 = "";
    private q nUq;
    String pkK;
    private View sc = null;
    private IListener tOh = new IListener<uw>() {
        /* class com.tencent.mm.plugin.sns.ui.al.AnonymousClass1 */

        {
            AppMethodBeat.i(160699);
            this.__eventId = uw.class.getName().hashCode();
            AppMethodBeat.o(160699);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(uw uwVar) {
            AppMethodBeat.i(97987);
            uw uwVar2 = uwVar;
            Log.i("MicroMsg.SightWidget", "on sight send result callback, type %d", Integer.valueOf(uwVar2.ebg.type));
            switch (uwVar2.ebg.type) {
                case 1:
                    Log.i("MicroMsg.SightWidget", "come event done");
                    al.this.videoPath = uwVar2.ebg.videoPath;
                    al.this.md5 = uwVar2.ebg.ebj;
                    if (al.this.gtM != null) {
                        al.this.gtM.dismiss();
                    }
                    if (uwVar2.ebg.ebi && al.this.Eth != null) {
                        al.a(al.this);
                    }
                    Log.i("MicroMsg.SightWidget", "mux finish %B videoPath %s %d md5 %s", Boolean.valueOf(uwVar2.ebg.ebi), uwVar2.ebg.videoPath, Long.valueOf(s.boW(uwVar2.ebg.videoPath)), al.this.md5);
                    break;
            }
            AppMethodBeat.o(97987);
            return false;
        }
    };
    String thumbPath = "";
    String videoPath = "";

    public al(MMActivity mMActivity) {
        AppMethodBeat.i(97999);
        this.gte = mMActivity;
        this.Etf = new a(mMActivity, this);
        AppMethodBeat.o(97999);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aC(Bundle bundle) {
        AppMethodBeat.i(98000);
        this.EpM = k.w(this.gte.getIntent());
        this.pkK = Util.nullAs(this.gte.getIntent().getStringExtra("KSightCdnUrl"), "");
        this.iwX = Util.nullAs(this.gte.getIntent().getStringExtra("KSightCdnThumbUrl"), "");
        this.appId = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.Ero = this.gte.getIntent().getBooleanExtra("KThrid_app", false);
        this.Erp = this.gte.getIntent().getBooleanExtra("KSnsAction", false);
        this.EsU = this.gte.getIntent().getBooleanExtra("Kis_take_photo", false);
        this.Etd = this.gte.getIntent().getBooleanExtra("KBlockAdd", false);
        this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.mSessionId = Util.nullAs(this.gte.getIntent().getStringExtra("reportSessionId"), "");
        this.EsT = this.gte.getIntent().getStringExtra("KSessionID");
        this.Ete = this.gte.getIntent().getBooleanExtra("KSnsUploadFromSkipCompress", false);
        Log.i("MicroMsg.SightWidget", "mIsFromSkipCompress:%s, appId:%s", Boolean.valueOf(this.Ete), this.appId);
        a aVar = this.Etf;
        MMActivity mMActivity = this.gte;
        Log.i("MicroMsg.SnsFakeVLogHelper", "resetFakeData");
        Bundle bundleExtra = mMActivity.getIntent().getBundleExtra("key_extra_data");
        if (!(bundleExtra == null || bundleExtra.getByteArray("key_bg_generate_pb") == null || bundleExtra.getByteArray("key_bg_generate_extra_config") == null)) {
            String stringExtra = mMActivity.getIntent().getStringExtra("KSightThumbPath");
            String stringExtra2 = mMActivity.getIntent().getStringExtra("KSightPath");
            if (!s.YS(stringExtra) || !s.YS(stringExtra2)) {
                Log.i("MicroMsg.SnsFakeVLogHelper", "SnsFakeVLogHelper go bg generate");
                aVar.CsL = false;
                com.tencent.mm.plugin.recordvideo.background.a aVar2 = com.tencent.mm.plugin.recordvideo.background.a.BKb;
                com.tencent.mm.plugin.recordvideo.background.a.a(7, aVar);
                byte[] byteArray = bundleExtra.getByteArray("key_bg_generate_pb");
                byte[] byteArray2 = bundleExtra.getByteArray("key_bg_generate_extra_config");
                try {
                    aVar.FdN = (aio) new aio().parseFrom(byteArray);
                    aVar.FdO = (VideoMixer.MixConfig) bundleExtra.getParcelable("key_bg_generate_mix_config");
                    aVar.FdP = (ald) new ald().parseFrom(byteArray2);
                } catch (IOException e2) {
                }
                mMActivity.getIntent().putExtra("KSightThumbPath", aVar.FdN.thumbPath);
                VideoMixer.MixConfig mixConfig = aVar.FdO;
                e eVar = e.BKp;
                e.a(byteArray, mixConfig, byteArray2, 7);
            } else {
                Log.i("MicroMsg.SnsFakeVLogHelper", "jump generate");
            }
        }
        Bundle bundleExtra2 = this.gte.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra2 != null) {
            this.Erq = new SendMessageToWX.Req(bundleExtra2).message;
        }
        this.thumbPath = this.gte.getIntent().getStringExtra("KSightThumbPath");
        this.videoPath = this.gte.getIntent().getStringExtra("KSightPath");
        this.EsV = this.gte.getIntent().getBooleanExtra("KSightDeleted", false);
        this.md5 = this.gte.getIntent().getStringExtra("sight_md5");
        byte[] byteArrayExtra = this.gte.getIntent().getByteArrayExtra("KMMSightExtInfo");
        if (byteArrayExtra != null) {
            try {
                this.EsS.parseFrom(byteArrayExtra);
            } catch (Exception e3) {
                Log.i("MicroMsg.SightWidget", "error %s", e3.getMessage());
            }
        }
        if (this.EsS == null) {
            this.EsS = new cly();
            this.EsS.Mrn = this.EsU;
        }
        this.EsS.dNI = this.mSessionId;
        this.EsS.Mrr = this.Ete;
        this.EsS.Mrs = this.appId;
        uw uwVar = new uw();
        uwVar.ebg.type = 2;
        EventCenter.instance.publish(uwVar);
        if (Util.isNullOrNil(this.videoPath)) {
            this.videoPath = Util.nullAs(uwVar.ebh.ebl, "");
            Log.e("MicroMsg.SightWidget", "videoPath is null %s", this.videoPath);
        }
        this.md5 = Util.isNullOrNil(this.md5) ? Util.nullAs(uwVar.ebh.ebj, "") : this.md5;
        Log.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", this.thumbPath, this.videoPath, this.md5);
        EventCenter.instance.addListener(this.tOh);
        if (this.EsW == 0) {
            aj.faD();
            int screenWidth = r.getScreenWidth();
            if (screenWidth == 0) {
                AppMethodBeat.o(98000);
                return;
            }
            this.EsW = ((screenWidth - (this.gte.getResources().getDimensionPixelSize(R.dimen.akd) * 4)) - (this.gte.getResources().getDimensionPixelSize(R.dimen.hv) * 2)) / 3;
        }
        if (this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
            this.DPi = 1;
        } else {
            this.DPi = 0;
        }
        this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
        if (this.Ero && this.appId.equals("wxa5e0de08d96cc09d") && this.Erq != null) {
            try {
                this.Etg = new i(this.Erq.messageExt);
            } catch (g e4) {
                Log.e("MicroMsg.SightWidget", "get SecondCut JSON Error");
            }
            Log.i("MicroMsg.SightWidget", "SecondCut thumbPath: " + this.thumbPath + ">>cdnThumbPath:" + this.iwX + ">>videoPath:" + this.videoPath + ">>cdnPath:" + this.pkK);
        }
        AppMethodBeat.o(98000);
    }

    private void B(String str, Object obj) {
        AppMethodBeat.i(203315);
        if (this.Etg != null) {
            try {
                this.Etg.i(str, obj);
                AppMethodBeat.o(203315);
                return;
            } catch (g e2) {
                Log.e("MicroMsg.SightWidget", "put SecondCut JSON Error");
            }
        }
        AppMethodBeat.o(203315);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aD(Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffA() {
        return !this.EsV;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final View ffB() {
        boolean z;
        AppMethodBeat.i(98001);
        this.sc = View.inflate(this.gte, R.layout.c4z, null);
        this.EsO = (SightPlayImageView) this.sc.findViewById(R.id.imb);
        this.EsP = (ImageView) this.sc.findViewById(R.id.i59);
        this.gte.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.EsZ = com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 100);
        this.EsY = com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 100);
        if (!TextUtils.isEmpty(this.thumbPath) && s.YS(this.thumbPath)) {
            Log.i("MicroMsg.SightWidget", "getBitmapNative thumbPath:%s", this.thumbPath);
            this.Etc = BitmapUtil.getBitmapNative(this.thumbPath);
            B("isPreviewExit", 1);
        }
        if (this.Etc == null) {
            B("isPreviewExit", 0);
            Log.i("MicroMsg.SightWidget", "getVideoThumb videoPath:%s", this.videoPath);
            this.Etc = com.tencent.mm.plugin.mmsight.d.PF(this.videoPath);
        }
        if (this.Etc != null) {
            this.EsZ = this.Etc.getHeight();
            this.EsY = this.Etc.getWidth();
            Bitmap bitmap = this.Etc;
            int i2 = this.EsY;
            int i3 = this.EsZ;
            int pixel = bitmap.getPixel(i2 / 4, i3 / 4);
            int pixel2 = bitmap.getPixel(i2 / 4, i3 / 3);
            int pixel3 = bitmap.getPixel(i2 / 3, i3 / 3);
            int pixel4 = bitmap.getPixel(i2 / 3, i3 / 4);
            int pixel5 = bitmap.getPixel(i2 / 2, i3 / 2);
            if (pixel == -16777216 && pixel2 == -16777216 && pixel3 == -16777216 && pixel4 == -16777216 && pixel5 == -16777216) {
                z = true;
            } else {
                z = false;
            }
            B("isPreviewBlack", Integer.valueOf(z ? 1 : 0));
            Log.i("MicroMsg.SightWidget", "isPreviewBitmapBlack:%b", Boolean.valueOf(z));
            Log.i("MicroMsg.SightWidget", "mSightHeight:%s", Integer.valueOf(this.EsZ));
            Log.i("MicroMsg.SightWidget", "mSightWidth:%s", Integer.valueOf(this.EsY));
        }
        this.Etb = n.a(this.EsY, this.EsZ, this.gte, false);
        Log.d("MicroMsg.SightWidget", "rawWidth=%s rawHeight=%s fixWidth=%s fixHeight=%s rotation=%s", Integer.valueOf(this.EsY), Integer.valueOf(this.EsZ), this.Etb.first, this.Etb.second, Integer.valueOf(this.Eta));
        ffZ();
        this.EsO.setScaleType(QImageView.a.CENTER_CROP);
        this.EsO.Dnz = true;
        this.EsO.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.al.AnonymousClass2 */

            public final void onClick(View view) {
                int i2;
                int i3;
                AppMethodBeat.i(97990);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (al.this.EsV) {
                    com.tencent.mm.kernel.g.aAi();
                    if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
                        u.g(al.this.gte, null);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(97990);
                        return;
                    }
                    try {
                        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) al.this.gte, 1, false);
                        eVar.HLX = new o.f() {
                            /* class com.tencent.mm.plugin.sns.ui.al.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.o.f
                            public final void onCreateMMMenu(m mVar) {
                                AppMethodBeat.i(97988);
                                if (!ac.jPB) {
                                    mVar.d(0, al.this.gte.getString(R.string.um));
                                }
                                mVar.d(1, al.this.gte.getString(R.string.uv));
                                AppMethodBeat.o(97988);
                            }
                        };
                        eVar.HLY = new o.g() {
                            /* class com.tencent.mm.plugin.sns.ui.al.AnonymousClass2.AnonymousClass2 */

                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                boolean z;
                                boolean z2 = true;
                                AppMethodBeat.i(97989);
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        al alVar = al.this;
                                        alVar.Zy(1);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13822, 1, 2, com.tencent.mm.plugin.sns.data.r.eZx(), Long.valueOf(cl.aWz()));
                                        SightParams sightParams = new SightParams(2, 0);
                                        com.tencent.mm.modelvideo.o.bhi();
                                        String aFj = com.tencent.mm.plugin.mmsight.d.aFj(com.tencent.mm.modelvideo.o.getAccVideoPath());
                                        RecordConfigProvider a2 = RecordConfigProvider.a(aFj, com.tencent.mm.plugin.mmsight.d.aFl(aFj), sightParams.irT, sightParams.irT.duration * 1000, 2);
                                        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_ignore_remux_without_edit, false)) {
                                            a2.remuxType = 2;
                                        }
                                        VideoCaptureReportInfo videoCaptureReportInfo = new VideoCaptureReportInfo();
                                        videoCaptureReportInfo.sQn = 7;
                                        a2.BOE = videoCaptureReportInfo;
                                        CaptureDataManager.BOb.BOa = new CaptureDataManager.c() {
                                            /* class com.tencent.mm.plugin.sns.ui.al.AnonymousClass9 */

                                            @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
                                            public final void a(Context context, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
                                                AppMethodBeat.i(97998);
                                                cly cly = new cly();
                                                cly.Mrn = true;
                                                cly.Mrm = false;
                                                SightCaptureResult sightCaptureResult = new SightCaptureResult(true, captureVideoNormalModel.videoPath, captureVideoNormalModel.thumbPath, s.bpb(captureVideoNormalModel.videoPath), com.tencent.xweb.util.d.getMD5(captureVideoNormalModel.videoPath), (int) (captureVideoNormalModel.BOd.longValue() / 1000), cly);
                                                if (captureVideoNormalModel.BOe.booleanValue()) {
                                                    sightCaptureResult.zsy = true;
                                                    sightCaptureResult.tkD = false;
                                                    sightCaptureResult.zsG = captureVideoNormalModel.thumbPath;
                                                }
                                                Intent intent = new Intent();
                                                intent.putExtra("key_req_result", sightCaptureResult);
                                                ((Activity) context).setResult(-1, intent);
                                                ((Activity) context).finish();
                                                AppMethodBeat.o(97998);
                                            }

                                            @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
                                            public final boolean a(Context context, Bundle bundle, CaptureDataManager.a aVar) {
                                                return false;
                                            }
                                        };
                                        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_jump_to_record_media, true)) {
                                            com.tencent.mm.plugin.recordvideo.jumper.a aVar = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
                                            com.tencent.mm.plugin.recordvideo.jumper.a.a(alVar.gte, 11, R.anim.ei, R.anim.ej, a2);
                                            AppMethodBeat.o(97989);
                                            return;
                                        }
                                        com.tencent.mm.pluginsdk.ui.tools.s.a(alVar.gte, 11, new Intent(), 2, 0);
                                        AppMethodBeat.o(97989);
                                        return;
                                    case 1:
                                        String string = al.this.gte.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("gallery", "1");
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13822, 2, 2, com.tencent.mm.plugin.sns.data.r.eZx(), Long.valueOf(cl.aWz()));
                                        if (string.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                            com.tencent.mm.pluginsdk.ui.tools.s.aY(al.this.gte);
                                        } else {
                                            Intent intent = new Intent();
                                            intent.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.e.baZ().bbc().duration);
                                            boolean a3 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_enable_vlog, false);
                                            if (com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.USERINFO_TOP_STORY_VLOG_ENABLE_INT, 0) == 1 || a3) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            if (z) {
                                                z2 = false;
                                            }
                                            intent.putExtra("key_can_select_video_and_pic", z2);
                                            com.tencent.mm.pluginsdk.ui.tools.s.a(al.this.gte, 9, 9, 4, 3, intent);
                                        }
                                        al.this.Zy(2);
                                        break;
                                }
                                AppMethodBeat.o(97989);
                            }
                        };
                        eVar.dGm();
                    } catch (Exception e2) {
                    }
                } else {
                    int[] iArr = new int[2];
                    if (view != null) {
                        view.getLocationInWindow(iArr);
                        i3 = view.getWidth();
                        i2 = view.getHeight();
                    } else {
                        i2 = 0;
                        i3 = 0;
                    }
                    if (al.this.Etf.M(iArr[0], iArr[1], i3, i2)) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(97990);
                        return;
                    } else if (!s.YS(al.this.videoPath)) {
                        Log.i("MicroMsg.SightWidget", "click videopath is not exist " + al.this.videoPath);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(97990);
                        return;
                    } else {
                        Intent intent = new Intent(al.this.gte, SnsOnlineVideoActivity.class);
                        intent.putExtra("intent_videopath", al.this.videoPath);
                        intent.putExtra("intent_thumbpath", al.this.thumbPath);
                        intent.putExtra("intent_isad", false);
                        intent.putExtra("intent_ispreview", true);
                        intent.putExtra("KBlockAdd", al.this.Etd);
                        intent.putExtra("sns_video_scene", 6);
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", i3);
                        intent.putExtra("img_gallery_height", i2);
                        al.this.gte.startActivityForResult(intent, 12);
                        al.this.gte.overridePendingTransition(0, 0);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/NewSightWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97990);
            }
        });
        Log.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.thumbPath + " " + s.boW(this.videoPath) + " " + s.boW(this.thumbPath));
        if (s.YS(this.videoPath)) {
            Log.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", this.videoPath, this.md5);
        }
        if (this.Etg != null) {
            com.tencent.mm.plugin.sns.k.e eVar = com.tencent.mm.plugin.sns.k.e.DUQ;
            i iVar = this.Etg;
            int optInt = iVar.optInt("page");
            try {
                eVar.DVG.erY = Long.parseLong(iVar.optString("from"));
            } catch (NumberFormatException e2) {
                Log.e("MicroMsg.SnsReportHelper", "SecondCut set report shareType error");
            }
            eVar.DVG.eMr = (long) optInt;
            eVar.DVG.eMs = (long) iVar.optInt("isPreviewExit");
            eVar.DVG.eMt = (long) iVar.optInt("isPreviewBlack");
            this.Etg = null;
        }
        View view = this.sc;
        AppMethodBeat.o(98001);
        return view;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffC() {
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffD() {
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean a(int i2, int i3, org.b.d.i iVar, String str, List<String> list, cjy cjy, LinkedList<Long> linkedList, int i4, boolean z, List<String> list2, PInt pInt, String str2, int i5, int i6) {
        AppMethodBeat.i(98003);
        if (this.Etf.fkY()) {
            this.nUq = h.a((Context) this.gte, this.gte.getString(R.string.g4v), true, (DialogInterface.OnCancelListener) null);
            this.Etj = i2;
            this.DEA = i3;
            this.Etk = iVar;
            this.Etl = str;
            this.Eoz = list;
            this.Etm = cjy;
            this.gYE = linkedList;
            this.Etn = i4;
            this.DSg = z;
            this.Eto = list2;
            this.Etp = pInt;
            this.canvasInfo = str2;
            this.Etq = i5;
            this.Etr = i6;
            ((SnsUploadUI) this.gte).EPM = false;
            AppMethodBeat.o(98003);
            return false;
        } else if (!s.YS(this.videoPath)) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.al.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(97991);
                    u.makeText(al.this.gte, (int) R.string.gkm, 0).show();
                    AppMethodBeat.o(97991);
                }
            });
            ((SnsUploadUI) this.gte).EPM = false;
            AppMethodBeat.o(98003);
            return false;
        } else if (this.Eth != null) {
            ((SnsUploadUI) this.gte).EPM = false;
            AppMethodBeat.o(98003);
            return false;
        } else if (this.EsQ) {
            AppMethodBeat.o(98003);
            return true;
        } else {
            this.EsQ = true;
            this.desc = str;
            LinkedList<ebm> linkedList2 = new LinkedList<>();
            if (list != null) {
                new LinkedList();
                List<String> gnq = com.tencent.mm.pluginsdk.i.a.gnq();
                for (String str3 : list) {
                    if (!gnq.contains(str3)) {
                        ebm ebm = new ebm();
                        ebm.UserName = str3;
                        linkedList2.add(ebm);
                    }
                }
            }
            this.Eth = new bf(15, this.gte);
            pInt.value = this.Eth.beK;
            if (i4 > com.tencent.mm.plugin.sns.c.a.DCT) {
                this.Eth.YF(3);
            }
            bf aPw = this.Eth.aPw(str);
            new LinkedList();
            aPw.a(cjy).bq(linkedList2).YI(i2).YJ(i3).gR(list2);
            if (z) {
                this.Eth.YL(1);
            } else {
                this.Eth.YL(0);
            }
            this.Eth.ct(this.DPi, this.EpN);
            this.Eth.gR(list2);
            this.Eth.YK(this.EpG);
            this.Eth.eck = this.EsS;
            this.Eth.g(null, null, null, i5, i6);
            this.Eth.setSessionId(this.mSessionId);
            if (!Util.isNullOrNil(this.appId)) {
                this.Eth.aPC(this.appId);
            }
            if (!Util.isNullOrNil(this.appName)) {
                this.Eth.aPD(Util.nullAs(this.appName, ""));
            }
            if (this.Ero) {
                this.Eth.YK(5);
            }
            if (this.Erp && this.Erq != null) {
                this.Eth.aPx(this.Erq.mediaTagName);
                this.Eth.aO(this.appId, this.Erq.messageExt, this.Erq.messageAction);
            }
            MMHandlerThread.postToMainThreadDelayed(this.Ett, 700);
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.al.AnonymousClass4 */

                public final void run() {
                    float f2;
                    boolean z;
                    AppMethodBeat.i(97992);
                    al alVar = al.this;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TextUtils.isEmpty(alVar.pkK) || TextUtils.isEmpty(alVar.iwX)) {
                        if (!alVar.Eth.D(alVar.videoPath, alVar.thumbPath, alVar.desc, alVar.md5)) {
                            Log.i("MicroMsg.SightWidget", "commitInThread videopath " + s.boW(alVar.videoPath) + " thumb: " + s.boW(alVar.thumbPath));
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.ui.al.AnonymousClass8 */

                                public final void run() {
                                    AppMethodBeat.i(97997);
                                    u.makeText(al.this.gte, (int) R.string.gkm, 0).show();
                                    AppMethodBeat.o(97997);
                                }
                            });
                        }
                        Log.i("MicroMsg.SightWidget", "commitInThread cost time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    } else {
                        bf bfVar = alVar.Eth;
                        String str = alVar.videoPath;
                        String str2 = alVar.thumbPath;
                        String str3 = alVar.desc;
                        String str4 = alVar.md5;
                        String str5 = alVar.pkK;
                        String str6 = alVar.iwX;
                        com.tencent.mm.plugin.recordvideo.e.d dVar = com.tencent.mm.plugin.recordvideo.e.d.Cin;
                        d.a aLQ = com.tencent.mm.plugin.recordvideo.e.d.aLQ(str);
                        if (aLQ != null) {
                            Log.i("MicroMsg.UploadPackHelper", "addSightObjectByUrl commit video_info:".concat(String.valueOf(aLQ)));
                            f2 = ((float) aLQ.duration) / 1000.0f;
                        } else {
                            f2 = 0.0f;
                        }
                        String str7 = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(str.getBytes());
                        bf.aPG(str7);
                        s.nw(str, str7);
                        String str8 = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(str2.getBytes());
                        s.nw(str2, str8);
                        cnb b2 = bf.b("", str7, str8, str4, str5, str6);
                        if (b2 == null) {
                            Log.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
                            z = false;
                        } else {
                            b2.Desc = str3;
                            if (Util.isNullOrNil(b2.Title)) {
                                b2.Title = str3;
                            }
                            b2.MsT = f2;
                            bfVar.DPd.ContentObj.LoV.add(b2);
                            cjs cjs = new cjs();
                            cjs.Mpj = b2.ecf;
                            bfVar.DPe.MsW.add(cjs);
                            z = true;
                        }
                        if (!z) {
                            Log.i("MicroMsg.SightWidget", "commitInThread videopath " + s.boW(alVar.videoPath) + " thumb: " + s.boW(alVar.thumbPath) + ",cdnUrl " + alVar.pkK + "cdnThubmUrl " + alVar.iwX);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.ui.al.AnonymousClass7 */

                                public final void run() {
                                    AppMethodBeat.i(97996);
                                    u.makeText(al.this.gte, (int) R.string.gkm, 0).show();
                                    AppMethodBeat.o(97996);
                                }
                            });
                        }
                        Log.i("MicroMsg.SightWidget", "commitInThread cost time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                    Log.i("MicroMsg.SightWidget", "removeRunnable showProgress");
                    MMHandlerThread.removeRunnable(al.this.Ett);
                    if (al.this.Eth == null) {
                        AppMethodBeat.o(97992);
                        return;
                    }
                    MMHandlerThread.postToMainThread(al.this.Ets);
                    AppMethodBeat.o(97992);
                }
            }, "sight_send_ready");
            AppMethodBeat.o(98003);
            return true;
        }
    }

    private void vl(boolean z) {
        AppMethodBeat.i(98004);
        this.videoPath = "";
        this.thumbPath = "";
        this.EsV = z;
        if (z) {
            this.gte.getIntent().putExtra("KSightThumbPath", this.thumbPath);
            this.gte.getIntent().putExtra("KSightPath", this.videoPath);
        }
        this.gte.getIntent().putExtra("KSightDeleted", this.EsV);
        this.Eta = 90;
        if (com.tencent.mm.plugin.sns.data.r.M(this.Etc)) {
            this.Etc.recycle();
            this.Etc = null;
        }
        AppMethodBeat.o(98004);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean k(int i2, Intent intent) {
        String stringExtra;
        AppMethodBeat.i(98005);
        switch (i2) {
            case 9:
                Bundle bundleExtra = intent.getBundleExtra("key_extra_data");
                if (bundleExtra == null || bundleExtra.getByteArray("key_bg_generate_pb") == null || bundleExtra.getByteArray("key_bg_generate_extra_config") == null) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                    if ((stringArrayListExtra == null || stringArrayListExtra.size() <= 0) && Util.isNullOrNil(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
                        this.EsV = true;
                        this.gte.getIntent().putExtra("KSightDeleted", this.EsV);
                        ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                        if (stringArrayListExtra2 != null && stringArrayListExtra2.size() != 0) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            Iterator<String> it = stringArrayListExtra2.iterator();
                            while (it.hasNext()) {
                                String next = it.next();
                                Exif.a location = Exif.fromFile(next).getLocation();
                                if (location != null) {
                                    arrayList.add(String.format("%s\n%f\n%f", next, Double.valueOf(location.latitude), Double.valueOf(location.longitude)));
                                }
                            }
                            boolean booleanExtra = intent.getBooleanExtra("isTakePhoto", false);
                            int intExtra = intent.getIntExtra("CropImage_filterId", 0);
                            if (this.gte instanceof SnsUploadUI) {
                                ((SnsUploadUI) this.gte).a(null, booleanExtra, intExtra, stringArrayListExtra2, arrayList, this.EpG);
                                ((SnsUploadUI) this.gte).fjO();
                                break;
                            }
                        } else {
                            Log.i("MicroMsg.SightWidget", "no image selected");
                            AppMethodBeat.o(98005);
                            return false;
                        }
                    } else {
                        this.EsV = false;
                        this.gte.getIntent().putExtra("KSightDeleted", this.EsV);
                        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                            stringExtra = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                        } else {
                            stringExtra = stringArrayListExtra.get(0);
                        }
                        String stringExtra2 = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
                        if (Util.isNullOrNil(stringExtra2) || !s.YS(stringExtra2)) {
                            stringExtra2 = aj.getAccSnsTmpPath() + s.bhK(stringExtra);
                            com.tencent.mm.compatible.i.d dVar = new com.tencent.mm.compatible.i.d();
                            try {
                                dVar.setDataSource(stringExtra);
                                Bitmap frameAtTime = dVar.getFrameAtTime(0);
                                if (frameAtTime == null) {
                                    Log.e("MicroMsg.SightWidget", "get bitmap error");
                                    try {
                                        dVar.release();
                                        break;
                                    } catch (Exception e2) {
                                        break;
                                    }
                                } else {
                                    Log.i("MicroMsg.SightWidget", "getBitmap1 %d %d", Integer.valueOf(frameAtTime.getWidth()), Integer.valueOf(frameAtTime.getHeight()));
                                    BitmapUtil.saveBitmapToImage(frameAtTime, 80, Bitmap.CompressFormat.JPEG, stringExtra2, true);
                                    BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(stringExtra2);
                                    Log.i("MicroMsg.SightWidget", "getBitmap2 %d %d", Integer.valueOf(imageOptions.outWidth), Integer.valueOf(imageOptions.outHeight));
                                    try {
                                        dVar.release();
                                    } catch (Exception e3) {
                                    }
                                }
                            } catch (Exception e4) {
                                Log.e("MicroMsg.SightWidget", "savebitmap error %s", e4.getMessage());
                                try {
                                    dVar.release();
                                } catch (Exception e5) {
                                }
                            } catch (Throwable th) {
                                try {
                                    dVar.release();
                                } catch (Exception e6) {
                                }
                                AppMethodBeat.o(98005);
                                throw th;
                            }
                        }
                        this.md5 = s.bhK(stringExtra);
                        Log.i("MicroMsg.SightWidget", "video path %s thumb path %s and %s %s ", stringExtra, stringExtra2, Long.valueOf(s.boW(stringExtra)), Long.valueOf(s.boW(stringExtra2)));
                        if (this.gte instanceof SnsUploadUI) {
                            ((SnsUploadUI) this.gte).a(stringExtra, stringExtra2, this.md5, (byte[]) null, false);
                            ((SnsUploadUI) this.gte).fjO();
                        }
                        AppMethodBeat.o(98005);
                        return true;
                    }
                } else {
                    Log.i("MicroMsg.SightWidget", "goto vlog mode");
                    this.gte.getIntent().getExtras().clear();
                    this.gte.getIntent().putExtra("Kis_take_photo", false);
                    this.gte.getIntent().putExtra("KSnsPostManu", true);
                    this.gte.getIntent().putExtra("Ksnsupload_type", 14);
                    this.gte.getIntent().putExtra("key_extra_data", intent.getBundleExtra("key_extra_data"));
                    ((SnsUploadUI) this.gte).fjO();
                    AppMethodBeat.o(98005);
                    return true;
                }
                break;
            case 11:
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult != null) {
                    if (!sightCaptureResult.zsy) {
                        this.EsV = false;
                        this.gte.getIntent().putExtra("KSightDeleted", this.EsV);
                        this.videoPath = sightCaptureResult.zsA;
                        this.thumbPath = sightCaptureResult.zsB;
                        if (!Util.isNullOrNil(sightCaptureResult.zsD)) {
                            this.md5 = sightCaptureResult.zsD;
                        } else {
                            this.md5 = s.bhK(sightCaptureResult.zsA);
                        }
                        if (this.gte instanceof SnsUploadUI) {
                            ((SnsUploadUI) this.gte).a(this.videoPath, this.thumbPath, this.md5, (byte[]) null, true);
                            ((SnsUploadUI) this.gte).fjO();
                        }
                        AppMethodBeat.o(98005);
                        return true;
                    }
                    this.EsV = true;
                    this.gte.getIntent().putExtra("KSightDeleted", this.EsV);
                    int intExtra2 = intent.getIntExtra("CropImage_filterId", 0);
                    String str = sightCaptureResult.zsG;
                    if (this.gte instanceof SnsUploadUI) {
                        ((SnsUploadUI) this.gte).a(str, true, intExtra2, null, null, this.EpG);
                        ((SnsUploadUI) this.gte).fjO();
                    }
                    AppMethodBeat.o(98005);
                    return true;
                }
                break;
            case 12:
                if (intent != null) {
                    this.EsV = intent.getBooleanExtra("sns_update_preview_video_del", false);
                    this.gte.getIntent().putExtra("KSightDeleted", this.EsV);
                    if (this.EsV) {
                        a aVar = this.Etf;
                        Log.i("MicroMsg.SnsFakeVLogHelper", "cancelAndDelete");
                        com.tencent.mm.plugin.recordvideo.background.a aVar2 = com.tencent.mm.plugin.recordvideo.background.a.BKb;
                        com.tencent.mm.plugin.recordvideo.background.a.b(7, aVar);
                        if (!TextUtils.isEmpty(aVar.taskId)) {
                            e eVar = e.BKp;
                            e.aLh(aVar.taskId);
                        }
                        fga();
                        vl(true);
                    }
                    AppMethodBeat.o(98005);
                    return true;
                }
                break;
        }
        AppMethodBeat.o(98005);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffE() {
        AppMethodBeat.i(98006);
        if (this.gtM != null) {
            this.gtM.dismiss();
        }
        EventCenter.instance.removeListener(this.tOh);
        if (com.tencent.mm.plugin.sns.data.r.M(this.EsR)) {
            this.EsR.recycle();
        }
        a aVar = this.Etf;
        Log.i("MicroMsg.SnsFakeVLogHelper", "release");
        com.tencent.mm.plugin.recordvideo.background.a aVar2 = com.tencent.mm.plugin.recordvideo.background.a.BKb;
        com.tencent.mm.plugin.recordvideo.background.a.b(7, aVar);
        vl(false);
        AppMethodBeat.o(98006);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void Zy(int i2) {
        AppMethodBeat.i(98007);
        ii ahh = new ii().ahh();
        ahh.eOC = (long) i2;
        ahh.wg(this.EsT).bfK();
        AppMethodBeat.o(98007);
    }

    /* access modifiers changed from: package-private */
    public final void ffZ() {
        AppMethodBeat.i(98008);
        if (this.Etc != null && !this.Etc.isRecycled()) {
            this.EsO.setImageBitmap(this.Etc);
            this.EsO.im(((Integer) this.Etb.first).intValue(), ((Integer) this.Etb.second).intValue());
        }
        AppMethodBeat.o(98008);
    }

    /* access modifiers changed from: package-private */
    public final void fga() {
        AppMethodBeat.i(98009);
        this.EsP.setVisibility(8);
        this.EsO.Dnr.clear();
        this.EsO.im(com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 100), com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 100));
        this.EsO.setBackgroundResource(R.color.a9q);
        this.EsO.setImageResource(R.raw.album_post_add_picture_btn);
        this.EsO.setContentDescription(this.EsO.getContext().getString(R.string.h4x));
        int fromDPToPix = (com.tencent.mm.cb.a.fromDPToPix((Context) this.gte, 100) * 35) / 100;
        this.EsO.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_clear_sns_tmp_file, true)) {
            c cVar = c.Cic;
            c.aLG(this.videoPath);
            c cVar2 = c.Cic;
            c.aLG(this.thumbPath);
        }
        AppMethodBeat.o(98009);
    }

    public final boolean fgb() {
        if (this.EsS != null) {
            return this.EsS.Mrn;
        }
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.f.a.AbstractC1737a
    public final void d(CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
        AppMethodBeat.i(98002);
        this.videoPath = captureVideoNormalModel.videoPath;
        this.thumbPath = captureVideoNormalModel.thumbPath;
        this.gte.getIntent().putExtra("KSightThumbPath", this.thumbPath);
        this.gte.getIntent().putExtra("KSightPath", this.videoPath);
        this.md5 = s.bhK(captureVideoNormalModel.videoPath);
        if (this.nUq != null && this.nUq.isShowing()) {
            this.nUq.dismiss();
            a(this.Etj, this.DEA, this.Etk, this.Etl, this.Eoz, this.Etm, this.gYE, this.Etn, this.DSg, this.Eto, this.Etp, this.canvasInfo, this.Etq, this.Etr);
        }
        AppMethodBeat.o(98002);
    }

    static /* synthetic */ void a(al alVar) {
        AppMethodBeat.i(98010);
        if (alVar.Eth != null) {
            if (alVar.gtM != null) {
                alVar.gtM.dismiss();
            }
            Log.i("MicroMsg.SightWidget", "commitDone");
            uw uwVar = new uw();
            uwVar.ebg.type = 0;
            uwVar.ebg.ebi = true;
            EventCenter.instance.publish(uwVar);
            alVar.EsQ = true;
            int commit = alVar.Eth.commit();
            if (alVar.Ero && alVar.appId.equals("wxa5e0de08d96cc09d")) {
                com.tencent.mm.plugin.sns.k.e.DUQ.DVF = commit;
            }
            if (alVar.EpM != null) {
                alVar.EpM.tQ(commit);
                com.tencent.mm.plugin.sns.k.g.DVR.c(alVar.EpM);
            }
            aj.faY().EvE = 0;
            if (alVar.gte.getIntent() != null && alVar.gte.getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false)) {
                Intent intent = new Intent();
                intent.putExtra("sns_resume_state", false);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.setClass(alVar.gte, SnsTimeLineUI.class);
                intent.addFlags(67108864);
                MMActivity mMActivity = alVar.gte;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/sns/ui/NewSightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                mMActivity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/sns/ui/NewSightWidget", "commitDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            alVar.gte.setResult(-1);
            alVar.gte.finish();
            aj.faK().eZn();
        }
        AppMethodBeat.o(98010);
    }
}
