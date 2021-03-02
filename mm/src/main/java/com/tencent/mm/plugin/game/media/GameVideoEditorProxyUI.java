package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;
import com.google.android.gms.common.util.GmsVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@a(19)
public class GameVideoEditorProxyUI extends MMBaseActivity {
    private static final String xwF = (b.c(b.a.ONE_MONTH) + "haowan/");
    private String cJp;
    private String mAppId;
    private Context mContext;
    private int mFrom;
    private e nVN;
    private int xAD = 0;
    private boolean xBd = false;
    private CaptureDataManager.b xCA = new CaptureDataManager.c() {
        /* class com.tencent.mm.plugin.game.media.GameVideoEditorProxyUI.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
        public final void a(final Context context, final CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
            AppMethodBeat.i(41152);
            final Bundle bundle2 = new Bundle();
            bundle2.putAll(bundle);
            com.tencent.mm.ch.a.post(new Runnable() {
                /* class com.tencent.mm.plugin.game.media.GameVideoEditorProxyUI.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(41149);
                    GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this, context, captureVideoNormalModel, bundle2);
                    AppMethodBeat.o(41149);
                }
            });
            AppMethodBeat.o(41152);
        }

        @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
        public final boolean a(Context context, final Bundle bundle, final CaptureDataManager.a aVar) {
            AppMethodBeat.i(41153);
            bundle.putInt("key_video_from", GameVideoEditorProxyUI.this.mFrom);
            bundle.putString("key_raw_video_path", GameVideoEditorProxyUI.this.cJp);
            bundle.putInt("key_raw_video_duration", GameVideoEditorProxyUI.this.xCw.getVideoDuration());
            bundle.putInt("key_raw_video_size", (int) s.boW(GameVideoEditorProxyUI.this.cJp));
            bundle.putInt("key_game_haowan_flag", 10);
            bundle.putInt("game_haowan_source_scene_id", GameVideoEditorProxyUI.this.xAD);
            if (GameVideoEditorProxyUI.this.mFrom == 2 && GameVideoEditorProxyUI.this.xCu != null) {
                if (GameVideoEditorProxyUI.this.xCu.size() > 1) {
                    Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: more than 1 share options and need to show actionsheet");
                    if (GameVideoEditorProxyUI.this.nVN != null) {
                        GameVideoEditorProxyUI.this.nVN.bMo();
                    }
                    GameVideoEditorProxyUI.this.nVN = new e(context, 1, false);
                    GameVideoEditorProxyUI.this.nVN.HLX = new o.f() {
                        /* class com.tencent.mm.plugin.game.media.GameVideoEditorProxyUI.AnonymousClass1.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(41150);
                            mVar.clear();
                            for (int i2 = 0; i2 < GameVideoEditorProxyUI.this.xCu.size(); i2++) {
                                GameShareOption gameShareOption = (GameShareOption) GameVideoEditorProxyUI.this.xCu.valueAt(i2);
                                mVar.d(gameShareOption.id, gameShareOption.title);
                            }
                            AppMethodBeat.o(41150);
                        }
                    };
                    GameVideoEditorProxyUI.this.nVN.HLY = new o.g() {
                        /* class com.tencent.mm.plugin.game.media.GameVideoEditorProxyUI.AnonymousClass1.AnonymousClass3 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(41151);
                            Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: user selected: %d", Integer.valueOf(menuItem.getItemId()));
                            GameShareOption gameShareOption = (GameShareOption) GameVideoEditorProxyUI.this.xCu.get(menuItem.getItemId());
                            if (gameShareOption != null) {
                                bundle.putInt("key_selected_item", gameShareOption.id);
                                aVar.eJL();
                                AppMethodBeat.o(41151);
                                return;
                            }
                            Log.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: non option!!");
                            AppMethodBeat.o(41151);
                        }
                    };
                    GameVideoEditorProxyUI.this.nVN.dGm();
                    AppMethodBeat.o(41153);
                    return true;
                } else if (GameVideoEditorProxyUI.this.xCv != null) {
                    Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: only 1 option. use default, dafault id is %d", Integer.valueOf(GameVideoEditorProxyUI.this.xCv.id));
                    if (bundle != null) {
                        bundle.putInt("key_selected_item", GameVideoEditorProxyUI.this.xCv.id);
                    }
                } else {
                    Log.w("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: no default option!");
                }
            }
            AppMethodBeat.o(41153);
            return false;
        }
    };
    private String xCg;
    private SparseArray<GameShareOption> xCu;
    private GameShareOption xCv = null;
    private com.tencent.mm.plugin.sight.base.a xCw;
    private String xCx = "";
    private String xCy = "";
    private boolean xCz = true;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameVideoEditorProxyUI() {
        AppMethodBeat.i(41155);
        AppMethodBeat.o(41155);
    }

    static /* synthetic */ String a(GameVideoEditorProxyUI gameVideoEditorProxyUI, String str, String str2) {
        AppMethodBeat.i(204140);
        String hH = gameVideoEditorProxyUI.hH(str, str2);
        AppMethodBeat.o(204140);
        return hH;
    }

    static {
        AppMethodBeat.i(41166);
        AppMethodBeat.o(41166);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        String c2;
        AppMethodBeat.i(41156);
        super.onCreate(bundle);
        this.mContext = this;
        this.mFrom = getIntent().getIntExtra("from", -1);
        this.xCg = getIntent().getStringExtra("business_type");
        this.mAppId = getIntent().getStringExtra("appid");
        this.cJp = getIntent().getStringExtra("video_path");
        Bundle bundleExtra = getIntent().getBundleExtra("ext_data");
        if (bundleExtra != null) {
            this.xBd = bundleExtra.getBoolean("game_straight_to_publish", false);
        }
        this.xAD = getIntent().getIntExtra("game_haowan_source_scene_id", 0);
        boolean equals = g.aAh().azQ().get(ar.a.USERINFO_GAME_VIDEO_IS_BG_MIX_STRING, "1").equals("1");
        boolean z = ((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_game_video_open_bg_mix, 0) == 1;
        Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video bg mix, debugOpen:%b, xLabOpen:%b", Boolean.valueOf(equals), Boolean.valueOf(z));
        if (!equals || !z) {
            this.xCz = false;
        } else {
            this.xCz = true;
        }
        Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video_path:%s", this.cJp);
        this.xCw = com.tencent.mm.plugin.sight.base.e.aNx(this.cJp);
        if (getIntent().getBooleanExtra("need_edit", false)) {
            if (this.xCw == null) {
                Log.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video is error");
                finish();
            } else {
                dUC();
            }
        } else if (Util.isNullOrNil(this.cJp)) {
            hG(getIntent().getStringExtra("video_url"), null);
        } else if (this.xCw == null) {
            Log.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video is error");
            finish();
        } else {
            VideoTransPara videoPara = getVideoPara();
            if (s.boW(this.cJp) > DownloadHelper.SAVE_LENGTH || (videoPara != null && videoPara.duration < this.xCw.getVideoDuration())) {
                Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "videoLength(%d) > %d or videoDuration(%d) > paramDuration(%d), needEdit is invalid", Long.valueOf(s.boW(this.cJp)), 104857600, Integer.valueOf(this.xCw.getVideoDuration()), Integer.valueOf(videoPara.duration));
                dUC();
            } else {
                String str = xwF + "vsg_output_" + System.currentTimeMillis() + ".mp4";
                String str2 = this.cJp;
                if (!str2.equals(str)) {
                    s.boN(s.boZ(str));
                    s.nw(str2, str);
                }
                this.cJp = str;
                String str3 = this.cJp;
                WebViewJSSDKVideoItem aAc = com.tencent.mm.plugin.game.media.background.a.aAc(str3);
                if (aAc == null) {
                    c2 = null;
                } else {
                    String hJ = com.tencent.mm.plugin.game.media.background.a.hJ(null, str3);
                    WebViewJSSDKFileItem aYO = ao.gcQ().aYO(hJ);
                    if (aYO != null) {
                        aAc.lPx = aYO.laR;
                    }
                    aAc.jkf.putInt("mark_edit_flag", 0);
                    c2 = ay.c(aAc.dJX, hJ, aAc.duration, aAc.height, aAc.width, aAc.size);
                }
                if (c2 == null) {
                    finish();
                } else {
                    hG(null, c2);
                }
            }
        }
        Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "onCreate");
        AppMethodBeat.o(41156);
    }

    private VideoTransPara getVideoPara() {
        AppMethodBeat.i(41157);
        if (this.mFrom == 3 || this.mFrom == 5) {
            VideoTransPara sV = com.tencent.mm.modelcontrol.e.baZ().sV(1);
            AppMethodBeat.o(41157);
            return sV;
        }
        VideoTransPara sV2 = com.tencent.mm.modelcontrol.e.baZ().sV(0);
        AppMethodBeat.o(41157);
        return sV2;
    }

    private void dUC() {
        ArrayList<String> stringArrayList;
        AppMethodBeat.i(41158);
        getWindow().getDecorView().setSystemUiVisibility(-3);
        long currentTimeMillis = System.currentTimeMillis();
        this.xCx = xwF + "vsg_output_" + currentTimeMillis + ".mp4";
        this.xCy = xwF + "vsg_thumb_" + currentTimeMillis + ".jpg";
        RecordConfigProvider aD = RecordConfigProvider.aD(this.cJp, this.xCx, this.xCy);
        aD.BOm = getVideoPara();
        aD.scene = 5;
        UICustomParam.a aVar = new UICustomParam.a();
        aVar.apE();
        aVar.apD();
        aVar.dz(true);
        if (djo()) {
            aVar.apA().apB();
        }
        int fromDPToPix = at.fromDPToPix(this, 32);
        if (this.mFrom != 2) {
            if (this.xCz) {
                aD.BOy = false;
                aD.BOt = Boolean.FALSE;
                aD.BOF = 604800000;
            } else {
                aD.BOy = true;
                aD.BOt = Boolean.TRUE;
            }
            aD.BOv = aD.BOm.duration * 1000;
            aVar.a(R.drawable.a6i, R.color.afz, getString(R.string.dt5), fromDPToPix);
        } else {
            aD.BOy = true;
            aD.BOt = Boolean.TRUE;
            aD.BOv = GmsVersion.VERSION_PARMESAN;
            aD.remuxType = 2;
            Bundle bundleExtra = getIntent().getBundleExtra("ext_data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString("k_ext_wording");
                VideoTransPara videoTransPara = (VideoTransPara) bundleExtra.getParcelable("k_preferred_trans_param");
                if (videoTransPara != null) {
                    Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: has given trasn params: %s", videoTransPara.toString());
                    aD.BOm = videoTransPara;
                }
                if (!Util.isNullOrNil(string)) {
                    aVar.L(string, getResources().getColor(R.color.afz));
                }
                ArrayList parcelableArrayList = bundleExtra.getParcelableArrayList("k_ext_share_options");
                if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
                    aVar.a(0, 0, getString(R.string.yx), fromDPToPix);
                } else {
                    this.xCv = (GameShareOption) parcelableArrayList.get(0);
                    if (parcelableArrayList.size() == 1) {
                        aVar.a(0, 0, this.xCv.title, fromDPToPix);
                    } else {
                        aVar.a(0, 0, getString(R.string.yx), fromDPToPix);
                    }
                    this.xCu = new SparseArray<>();
                    Iterator it = parcelableArrayList.iterator();
                    while (it.hasNext()) {
                        GameShareOption gameShareOption = (GameShareOption) it.next();
                        this.xCu.put(gameShareOption.id, gameShareOption);
                    }
                }
            } else {
                aVar.a(0, 0, getString(R.string.yx), fromDPToPix);
            }
            aVar.dy(true);
            if (!(bundleExtra.getInt("k_ext_editor_from", 0) != 1 || (stringArrayList = bundleExtra.getStringArrayList("k_ext_tool_bars")) == null || stringArrayList.size() == 0)) {
                aVar.dv(true);
                aVar.dx(true);
                aVar.dy(true);
                aVar.dw(true);
                Iterator<String> it2 = stringArrayList.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (next.equals("emoji")) {
                        aVar.dv(false);
                    } else if (next.equals("music")) {
                        aVar.dx(false);
                    } else if (next.equals("text")) {
                        aVar.dw(false);
                    } else if (next.equals("crop")) {
                        aVar.dy(false);
                    }
                }
            }
        }
        aD.BOn = aVar.gLU;
        CaptureDataManager.BOb.BOa = this.xCA;
        com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
        if (com.tencent.mm.plugin.recordvideo.jumper.a.a(this.mContext, aD)) {
            com.tencent.mm.game.report.b.a.a(this, 8763, 0, 1, this.xAD, com.tencent.mm.game.report.b.a.c(this.mFrom, null));
        }
        AppMethodBeat.o(41158);
    }

    private boolean djo() {
        AppMethodBeat.i(41159);
        boolean z = false;
        int mp4RotateVFS = SightVideoJNI.getMp4RotateVFS(this.cJp);
        if (mp4RotateVFS == 0 || mp4RotateVFS == 180) {
            if (this.xCw.width >= this.xCw.height) {
                z = true;
            }
        } else if ((mp4RotateVFS == 270 || mp4RotateVFS == 90) && this.xCw.height >= this.xCw.width) {
            z = true;
        }
        AppMethodBeat.o(41159);
        return z;
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(41160);
        super.onDestroy();
        AppMethodBeat.o(41160);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(41161);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 121) {
            if (i3 == -1) {
                if (intent != null && (this.mFrom == 3 || this.xBd)) {
                    hG(null, intent.getStringExtra("key_video_info"));
                    AppMethodBeat.o(41161);
                    return;
                }
            } else if (i3 == 0 || i3 == 3000 || i3 == 3001) {
                com.tencent.mm.game.report.b.a.a(this, 8763, 1, 2, this.xAD, com.tencent.mm.game.report.b.a.c(this.mFrom, null));
            } else if (i3 == 888) {
                Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "video edit in background");
                String hJ = com.tencent.mm.plugin.game.media.background.a.hJ(intent.getStringExtra("key_thumb_path"), this.cJp);
                String stringExtra = intent.getStringExtra("key_bg_mix_task_id");
                String c2 = ay.c("weixin://bgmixid/".concat(String.valueOf(stringExtra)), hJ, Util.videoMsToSec((long) intent.getIntExtra("key_video_duration", 0)), this.xCw.height, this.xCw.width, 0);
                Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "videoInfo:%s", c2);
                intent.putExtra("key_video_info", c2);
                i3 = -1;
                if (this.mFrom == 3 || this.xBd) {
                    hG(null, intent.getStringExtra("key_video_info"));
                    AppMethodBeat.o(41161);
                    return;
                }
            } else {
                Log.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video check error: [%d]", Integer.valueOf(i3));
                HashMap hashMap = new HashMap();
                hashMap.put("failid", Integer.valueOf(i3));
                com.tencent.mm.game.report.b.a.a(this.mContext, 8763, 2, 56, this.xAD, com.tencent.mm.game.report.b.a.c(this.mFrom, hashMap));
                u.makeText(this.mContext, (int) R.string.dta, 1).show();
                if (this.mFrom == 3) {
                    setResult(i3, intent);
                    finish();
                    n.d(this.xCg, "Invalid video format", this.mAppId, -3, "Invalid video format");
                    AppMethodBeat.o(41161);
                    return;
                }
            }
        }
        setResult(i3, intent);
        finish();
        if (this.mFrom == 3) {
            n.d(this.xCg, "", this.mAppId, 0, "");
        }
        AppMethodBeat.o(41161);
    }

    private void hG(final String str, final String str2) {
        AppMethodBeat.i(41162);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.game.media.GameVideoEditorProxyUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(41154);
                String a2 = GameVideoEditorProxyUI.a(GameVideoEditorProxyUI.this, str, str2);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", a2);
                c.b(GameVideoEditorProxyUI.this.mContext, "webview", ".ui.tools.WebViewUI", intent, (int) TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE);
                AppMethodBeat.o(41154);
            }
        }, 0);
        AppMethodBeat.o(41162);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b7 A[SYNTHETIC, Splitter:B:20:0x00b7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String hH(java.lang.String r10, java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 222
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.media.GameVideoEditorProxyUI.hH(java.lang.String, java.lang.String):java.lang.String");
    }

    static /* synthetic */ void a(GameVideoEditorProxyUI gameVideoEditorProxyUI, Context context, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
        GameShareOption gameShareOption;
        AppMethodBeat.i(41164);
        bundle.putInt("game_haowan_source_scene_id", gameVideoEditorProxyUI.xAD);
        com.tencent.mm.plugin.game.media.background.a.a(captureVideoNormalModel, bundle);
        if (!captureVideoNormalModel.BOc.booleanValue()) {
            u.makeText(gameVideoEditorProxyUI.mContext, (int) R.string.dt6, 1).show();
            Log.e("MicroMsg.Haowan.GameVideoEditorProxyUI", "video remux error");
            AppMethodBeat.o(41164);
            return;
        }
        com.tencent.mm.plugin.game.media.background.a.a(gameVideoEditorProxyUI.xCx, captureVideoNormalModel);
        com.tencent.mm.plugin.game.media.background.a.b(gameVideoEditorProxyUI.xCy, captureVideoNormalModel);
        if (gameVideoEditorProxyUI.mFrom == 2) {
            cly cly = new cly();
            cly.Mrn = false;
            cly.Mrm = false;
            SightCaptureResult sightCaptureResult = new SightCaptureResult(true, captureVideoNormalModel.videoPath, captureVideoNormalModel.thumbPath, s.bpb(captureVideoNormalModel.videoPath), s.bhK(captureVideoNormalModel.videoPath), (int) (captureVideoNormalModel.BOd.longValue() / 1000), cly);
            if (captureVideoNormalModel.BOe.booleanValue()) {
                sightCaptureResult.zsy = true;
                sightCaptureResult.tkD = false;
                sightCaptureResult.zsG = captureVideoNormalModel.thumbPath;
            }
            int i2 = bundle.getInt("key_selected_item", 0);
            Log.i("MicroMsg.Haowan.GameVideoEditorProxyUI", "hy: generated video, selected item is %d", Integer.valueOf(i2));
            if (gameVideoEditorProxyUI.xCu == null) {
                gameShareOption = null;
            } else {
                gameShareOption = gameVideoEditorProxyUI.xCu.get(i2);
            }
            Intent intent = new Intent();
            if (gameShareOption != null && gameShareOption.xtX) {
                intent.putExtra("key_ext_url", gameVideoEditorProxyUI.hH(null, com.tencent.mm.plugin.game.media.background.a.a(captureVideoNormalModel)));
            }
            intent.putExtra("key_req_result", sightCaptureResult);
            intent.putExtra("key_selected_item", i2);
            ((Activity) context).setResult(-1, intent);
            ((Activity) context).finish();
            AppMethodBeat.o(41164);
            return;
        }
        boolean booleanValue = ((Boolean) captureVideoNormalModel.eJJ().y("KEY_VIDEO_IS_EDITED_BOOLEAN", Boolean.TRUE)).booleanValue();
        if (gameVideoEditorProxyUI.xCz && booleanValue) {
            com.tencent.mm.plugin.game.media.background.a.aAb(captureVideoNormalModel.videoPath);
        }
        String a2 = com.tencent.mm.plugin.game.media.background.a.a(captureVideoNormalModel);
        if (a2 == null) {
            gameVideoEditorProxyUI.finish();
            AppMethodBeat.o(41164);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("key_video_info", a2);
        ((Activity) context).setResult(-1, intent2);
        ((Activity) context).finish();
        AppMethodBeat.o(41164);
    }
}
