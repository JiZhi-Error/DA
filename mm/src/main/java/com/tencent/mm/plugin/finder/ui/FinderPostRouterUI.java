package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderRecordPluginLayout;
import com.tencent.mm.plugin.finder.video.develop.DevFinderRecordPluginLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout;
import com.tencent.mm.plugin.vlog.ui.MultiVideoPluginLayout;
import com.tencent.mm.plugin.vlog.ui.plugin.f;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.r;

@com.tencent.mm.ui.base.a(7)
@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\"\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0014J \u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001eH\u0016J \u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)H\u0016J \u0010*\u001a\u00020\u00152\u0006\u0010&\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\u0006\u0010$\u001a\u00020\u001eH\u0016J-\u0010-\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00122\u000e\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0/2\u0006\u00100\u001a\u000201H\u0016¢\u0006\u0002\u00102J\b\u00103\u001a\u00020\u0015H\u0014J\b\u00104\u001a\u00020\u0015H\u0014J\u0006\u00105\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderPostRouterUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "bgmIfOrigin", "", "fromAddMedia", "fromRecordUI", "hasStopped", "originBgmUrl", "", "originMusicId", "originMusicInfo", "", "originMusicName", "originMusicPath", ShareConstants.RESULT_POST_ID, "router", "", "getLayoutId", "goRouter", "", "gotoMediaEdit", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditFinish", "forward", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "onFinishBtnClick", "context", "Landroid/content/Context;", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStop", "takePhoto", "Companion", "plugin-finder_release"})
public final class FinderPostRouterUI extends MMFinderUI implements CaptureDataManager.b {
    public static final a vNc = new a((byte) 0);
    private HashMap _$_findViewCache;
    private String postId = "";
    private int ubR = -1;
    private boolean vMT;
    private boolean vMU;
    private String vMV;
    private String vMW;
    private String vMX;
    private byte[] vMY;
    private String vMZ;
    private boolean vNa;
    private boolean vNb;

    static {
        AppMethodBeat.i(252597);
        AppMethodBeat.o(252597);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252599);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252599);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252598);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252598);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderPostRouterUI$Companion;", "", "()V", "REQUEST_CODE", "", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        String name;
        AppMethodBeat.i(167499);
        super.onCreate(bundle);
        d.e(getWindow());
        this.ubR = getIntent().getIntExtra("key_finder_post_router", -1);
        String stringExtra = getIntent().getStringExtra("key_finder_post_id");
        if (stringExtra == null) {
            StringBuilder sb = new StringBuilder();
            p.g(g.aAf(), "MMKernel.account()");
            stringExtra = sb.append(com.tencent.mm.kernel.a.ayV()).append('_').append(Util.nowMilliSecond()).toString();
        }
        this.postId = stringExtra;
        this.vMX = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID");
        this.vMV = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH");
        this.vMW = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME");
        this.vMY = getIntent().getByteArrayExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO");
        this.vMZ = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_BGM_URL");
        this.vNa = getIntent().getBooleanExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", false);
        i iVar = i.vfo;
        i.auH(this.postId);
        Log.i("Finder.FinderPostRouterUI", "router " + this.ubR);
        switch (this.ubR) {
            case 1:
                Intent intent = new Intent();
                intent.putExtra("finder_username", z.aUg());
                intent.addFlags(67108864);
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC.a.a(this, intent, 0, 0, false, 124);
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(this, intent);
                finish();
                AppMethodBeat.o(167499);
                return;
            case 2:
                this.vMU = true;
                aML();
                i iVar2 = i.vfo;
                i.Kr(2);
                AppMethodBeat.o(167499);
                return;
            case 3:
                Intent intent2 = new Intent();
                intent2.putExtra("key_finder_post_id", this.postId);
                intent2.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID", this.vMX);
                intent2.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH", this.vMV);
                intent2.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", this.vMW);
                intent2.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO", this.vMY);
                intent2.putExtra("KEY_FINDER_POST_ORIGIN_BGM_URL", this.vMZ);
                intent2.putExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", this.vNa);
                com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Intent intent3 = getIntent();
                p.g(intent3, "getIntent()");
                com.tencent.mm.plugin.finder.utils.a.b(intent2, intent3);
                com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.J(this, intent2);
                i iVar3 = i.vfo;
                i.Kr(1);
                AppMethodBeat.o(167499);
                return;
            case 4:
                com.tencent.mm.plugin.finder.utils.a aVar5 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.E(this, getIntent());
                AppMethodBeat.o(167499);
                return;
            case 5:
                finish();
                AppMethodBeat.o(167499);
                return;
            case 6:
                switch (getIntent().getIntExtra("key_finder_sns_post_type", 0)) {
                    case 1:
                        com.tencent.mm.plugin.finder.utils.a aVar6 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        Intent intent4 = new Intent();
                        intent4.putExtra("key_comment_scene", 41);
                        com.tencent.mm.plugin.finder.utils.a.ad(this, intent4);
                        overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
                        AppMethodBeat.o(167499);
                        return;
                    case 2:
                        UICustomParam.a aVar7 = new UICustomParam.a();
                        aVar7.apE();
                        aVar7.apD();
                        aVar7.dz(false);
                        aVar7.apF();
                        RecordConfigProvider jB = RecordConfigProvider.jB("", "");
                        jB.scene = 11;
                        jB.BOn = aVar7.apG();
                        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                        jB.BOm = com.tencent.mm.plugin.finder.storage.c.dqx();
                        jB.BOp = 3;
                        jB.BOv = jB.BOm.duration * 1000;
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelableArrayList("media_list", j.ac(GalleryItem.MediaItem.a(2, 0, getIntent().getStringExtra("key_finder_post_sns_video_path"), "", "")));
                        Point az = ao.az(this);
                        y yVar = y.vXH;
                        Context baseContext = getBaseContext();
                        p.g(baseContext, "baseContext");
                        r<Integer, Integer, Integer> g2 = y.g(baseContext, az.x, az.y);
                        Point point = new Point(g2.second.intValue(), g2.SWY.intValue());
                        bundle2.putInt("KEY_PREVIEW_WIDTH", point.x);
                        bundle2.putInt("KEY_PREVIEW_HEIGHT", point.y);
                        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        bundle2.putLong("video_max_duration", ((long) com.tencent.mm.plugin.finder.storage.c.drG()) * 1000);
                        al alVar = al.waC;
                        bundle2.putString("output_dir", al.dEG());
                        jB.jkf = bundle2;
                        y yVar2 = y.vXH;
                        if (y.isAnyEnableFullScreenEnjoy()) {
                            name = MultiVideoFullScreenPluginLayout.class.getName();
                        } else {
                            name = MultiVideoPluginLayout.class.getName();
                        }
                        p.g(name, "if (FinderUtil.isAnyEnab…inLayout::class.java.name");
                        jB.F(3, name);
                        jB.F(4, name);
                        com.tencent.mm.plugin.recordvideo.jumper.a aVar8 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
                        com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), com.tencent.mm.plugin.appbrand.jsapi.audio.l.CTRL_INDEX, R.anim.eq, R.anim.er, jB, 4, 0);
                        h.INSTANCE.a(20694, 2);
                        AppMethodBeat.o(167499);
                        return;
                    default:
                        finish();
                        AppMethodBeat.o(167499);
                        return;
                }
            case 7:
                getIntent().addFlags(536870912);
                getIntent().addFlags(67108864);
                com.tencent.mm.plugin.finder.utils.a aVar9 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                com.tencent.mm.plugin.finder.utils.a.O(context, getIntent());
                AppMethodBeat.o(167499);
                return;
            case 8:
            default:
                Log.i("Finder.FinderPostRouterUI", "invalid router " + this.ubR + ", finish");
                finish();
                AppMethodBeat.o(167499);
                return;
            case 9:
                getIntent().addFlags(536870912);
                getIntent().addFlags(67108864);
                com.tencent.mm.plugin.finder.utils.a aVar10 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context2 = MMApplicationContext.getContext();
                p.g(context2, "MMApplicationContext.getContext()");
                com.tencent.mm.plugin.finder.utils.a.aa(context2, getIntent());
                AppMethodBeat.o(167499);
                return;
            case 10:
                Intent intent5 = new Intent();
                intent5.putExtra("key_finder_post_id", this.postId);
                intent5.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID", this.vMX);
                intent5.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH", this.vMV);
                intent5.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", this.vMW);
                intent5.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO", this.vMY);
                intent5.putExtra("KEY_FINDER_POST_ORIGIN_BGM_URL", this.vMZ);
                intent5.putExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", this.vNa);
                intent5.putExtra("KEY_FINDER_POST_FORM_FLUTTER", true);
                com.tencent.mm.plugin.finder.utils.a aVar11 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Intent intent6 = getIntent();
                p.g(intent6, "getIntent()");
                com.tencent.mm.plugin.finder.utils.a.b(intent5, intent6);
                com.tencent.mm.plugin.finder.utils.a aVar12 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.J(this, intent5);
                i iVar4 = i.vfo;
                i.Kr(1);
                AppMethodBeat.o(167499);
                return;
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(167500);
        super.onResume();
        Log.i("Finder.FinderPostRouterUI", "onResume");
        this.vNb = getIntent().getBooleanExtra("KEY_FINDER_POST_FROM_ADD_MEDIA", false);
        if (this.vMT) {
            finish();
            if (this.vMU) {
                overridePendingTransition(0, R.anim.ej);
            }
            if (this.ubR == 6) {
                overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
            }
        }
        AppMethodBeat.o(167500);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStop() {
        AppMethodBeat.i(167501);
        super.onStop();
        Log.i("Finder.FinderPostRouterUI", "onStop");
        this.vMT = true;
        AppMethodBeat.o(167501);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(252594);
        CaptureDataManager.BOb.a(null);
        super.onDestroy();
        AppMethodBeat.o(252594);
    }

    private void aML() {
        String name;
        boolean z;
        AppMethodBeat.i(167502);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        VideoTransPara dqw = com.tencent.mm.plugin.finder.storage.c.dqw();
        f fVar = f.GHk;
        if (f.fDl()) {
            dqw.height = (int) (((float) dqw.width) / 0.75f);
        }
        Log.i("Finder.FinderPostRouterUI", "videoParams ".concat(String.valueOf(dqw)));
        al alVar = al.waC;
        RecordConfigProvider a2 = RecordConfigProvider.a(al.dEC(), "", dqw, dqw.duration * 1000, 11);
        a2.BOu = Boolean.FALSE;
        a2.BOJ.BOM = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_effect_finder_enable_beautify, true);
        a2.BOJ.hDb = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_effect_finder_beautify_skin_smooth, -1);
        a2.BOJ.hDc = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_effect_finder_beautify_eye_morph, -1);
        a2.BOJ.hDd = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_effect_finder_beautify_face_morph, -1);
        a2.BOJ.hDe = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_effect_finder_beautify_skin_bright, -1);
        a2.BOJ.hDf = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_effect_finder_beautify_eye_bright, -1);
        UICustomParam.a aVar = new UICustomParam.a();
        f fVar2 = f.GHk;
        if (f.fDl()) {
            aVar.ai(0.75f);
        } else {
            aVar.ai(0.85714287f);
        }
        aVar.apE();
        aVar.apD();
        aVar.apC();
        aVar.dz(false);
        aVar.apF();
        AppCompatActivity context = getContext();
        p.g(context, "context");
        aVar.oG(context.getResources().getColor(R.color.a3b));
        aVar.a(R.drawable.k_, 0, "", 0);
        a2.BOn = aVar.apG();
        a2.BOo = i.e.CONTAIN;
        a2.jkf = new Bundle();
        a2.jkf.putString(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, this.postId);
        a2.jkf.putString("KEY_ORIGIN_MUSIC_ID", this.vMX);
        a2.jkf.putString("KEY_ORIGIN_MUSIC_PATH", this.vMV);
        a2.jkf.putString("KEY_ORIGIN_MUSIC_NAME", this.vMW);
        a2.jkf.putByteArray("KEY_ORIGIN_MUSIC_INFO", this.vMY);
        a2.jkf.putString("KEY_ORIGIN_BGM_URL", this.vMZ);
        a2.jkf.putBoolean("KEY_BGM_IF_ORIGIN", this.vNa);
        y yVar = y.vXH;
        if (y.isAnyEnableFullScreenEnjoy()) {
            name = MultiVideoFullScreenPluginLayout.class.getName();
        } else {
            name = MultiVideoPluginLayout.class.getName();
        }
        p.g(name, "if (FinderUtil.isAnyEnab…inLayout::class.java.name");
        a2.F(4, name);
        a2.F(1, name);
        a2.F(3, name);
        a2.F(0, FinderRecordPluginLayout.class.getName());
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if (aAh.azQ().getInt(ar.a.USERINFO_FINDER_SELECT_RECORD_LAYOUT_INT_SYNC, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            a2.F(0, DevFinderRecordPluginLayout.class.getName());
        }
        CaptureDataManager.BOb.a(this);
        com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(this, TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, R.anim.ei, R.anim.ej, a2);
        AppMethodBeat.o(167502);
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final void a(Context context, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
        boolean z;
        AppMethodBeat.i(167503);
        p.h(context, "context");
        p.h(captureVideoNormalModel, "model");
        p.h(bundle, "extData");
        Log.i("Finder.FinderPostRouterUI", "onMediaGenerated");
        this.vMU = false;
        cly cly = new cly();
        cly.Mrn = true;
        cly.Mrm = false;
        Intent intent = new Intent();
        ArrayList arrayList = (ArrayList) captureVideoNormalModel.eJJ().y("KEY_IMAGE_QUALITY_INT_ARRAY", new ArrayList());
        byte[] byteArray = bundle.getByteArray("MEDIA_EXTRA_MUSIC");
        if (byteArray != null) {
            intent.putExtra("MEDIA_EXTRA_MUSIC", byteArray);
        }
        byte[] byteArray2 = bundle.getByteArray("ORIGIN_MUSIC_INFO");
        if (byteArray2 != null) {
            intent.putExtra("ORIGIN_MUSIC_INFO", byteArray2);
        }
        com.tencent.mm.ac.d.a(intent, bundle, "ORIGIN_MUSIC_ID");
        com.tencent.mm.ac.d.a(intent, bundle, "ORIGIN_MUSIC_PATH");
        com.tencent.mm.ac.d.a(intent, bundle, "ORIGIN_BGM_URL");
        com.tencent.mm.ac.d.b(intent, bundle, "MEDIA_IS_MUTE");
        com.tencent.mm.ac.d.b(intent, bundle, "MUSIC_IS_MUTE");
        com.tencent.mm.ac.d.c(intent, bundle, "SOUND_TRACK_TYPE");
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("KEY_POST_HALF_RECT_LIST");
        if (parcelableArrayList != null) {
            intent.putExtra("KEY_POST_HALF_RECT_LIST", parcelableArrayList);
        }
        List<String> eJK = captureVideoNormalModel.eJK();
        if (eJK == null || eJK.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            intent.putExtra("postType", 2);
            intent.putExtra("postMediaList", new ArrayList(captureVideoNormalModel.eJK()));
            List<String> eJK2 = captureVideoNormalModel.eJK();
            p.g(eJK2, "model.multiImagePath");
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = eJK2.iterator();
            while (it.hasNext()) {
                it.next();
                arrayList2.add(2);
            }
            intent.putExtra("postTypeList", arrayList2);
            if (arrayList != null && arrayList.size() == captureVideoNormalModel.eJK().size()) {
                intent.putExtra("key_post_media_quality_list", arrayList);
            }
            com.tencent.mm.ac.d.d(intent, bundle, "KEY_POST_HALF_IMAGE_LIST");
        } else {
            Boolean eJI = captureVideoNormalModel.eJI();
            p.g(eJI, "model.photo");
            if (eJI.booleanValue()) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(captureVideoNormalModel.aQn());
                intent.putExtra("postType", 2);
                intent.putExtra("postMediaList", arrayList3);
                if (arrayList != null && arrayList.size() == 1) {
                    intent.putExtra("key_post_media_quality_list", arrayList);
                }
            } else {
                if (bundle.getByteArray("video_composition") != null) {
                    intent.putExtra("video_composition", bundle.getByteArray("video_composition"));
                    intent.putExtra("postThumbList", j.ac(captureVideoNormalModel.aQn()));
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    arrayList4.add(captureVideoNormalModel.getVideoPath());
                    intent.putExtra("postMediaList", arrayList4);
                }
                p.g(intent.putExtra("postType", 4), "postIntent.putExtra(Cons…iaType.FINDER_DATA_VIDEO)");
            }
        }
        intent.putExtra("KEY_POST_FROM_CAMERA", true);
        intent.putExtra(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, this.postId);
        intent.putExtra("edit_id", (String) captureVideoNormalModel.eJJ().y("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        Intent intent2 = getIntent();
        p.g(intent2, "getIntent()");
        com.tencent.mm.plugin.finder.utils.a.b(intent, intent2);
        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(context, intent);
        com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
        RecordMediaReportInfo eJJ = captureVideoNormalModel.eJJ();
        p.g(eJJ, "model.reportInfo");
        com.tencent.mm.plugin.finder.report.i.a(eJJ);
        AppMethodBeat.o(167503);
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final boolean a(Context context, Bundle bundle, CaptureDataManager.a aVar) {
        AppMethodBeat.i(167504);
        p.h(context, "context");
        p.h(bundle, "extData");
        p.h(aVar, "finishController");
        AppMethodBeat.o(167504);
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final void a(RecordMediaReportInfo recordMediaReportInfo, Bundle bundle) {
        AppMethodBeat.i(252595);
        p.h(recordMediaReportInfo, "reportInfo");
        p.h(bundle, "extData");
        com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.b(recordMediaReportInfo);
        AppMethodBeat.o(252595);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(167506);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        if (iArr.length == 0) {
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            Log.i("Finder.FinderPostRouterUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(currentThread.getId()));
            AppMethodBeat.o(167506);
            return;
        }
        Thread currentThread2 = Thread.currentThread();
        p.g(currentThread2, "Thread.currentThread()");
        Log.i("Finder.FinderPostRouterUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(currentThread2.getId()));
        switch (i2) {
            case 16:
                if (iArr.length == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    z3 = false;
                }
                if (!z3 || iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) getContext(), com.tencent.mm.cb.a.aI(getContext(), R.string.fl0), com.tencent.mm.cb.a.aI(getContext(), R.string.flp), com.tencent.mm.cb.a.aI(getContext(), R.string.e_k), com.tencent.mm.cb.a.aI(getContext(), R.string.fl1), false, (DialogInterface.OnClickListener) new b(this), (DialogInterface.OnClickListener) new c(this));
                    AppMethodBeat.o(167506);
                    return;
                }
                aML();
                AppMethodBeat.o(167506);
                return;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                if (iArr.length == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    z3 = false;
                }
                if (z3 && iArr[0] == 0) {
                    aML();
                    break;
                }
        }
        AppMethodBeat.o(167506);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class b implements DialogInterface.OnClickListener {
        final /* synthetic */ FinderPostRouterUI vNd;

        b(FinderPostRouterUI finderPostRouterUI) {
            this.vNd = finderPostRouterUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(252592);
            dialogInterface.dismiss();
            this.vNd.finish();
            AppCompatActivity context = this.vNd.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/ui/FinderPostRouterUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/ui/FinderPostRouterUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(252592);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class c implements DialogInterface.OnClickListener {
        final /* synthetic */ FinderPostRouterUI vNd;

        c(FinderPostRouterUI finderPostRouterUI) {
            this.vNd = finderPostRouterUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(252593);
            dialogInterface.dismiss();
            this.vNd.finish();
            AppMethodBeat.o(252593);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        RecordMediaReportInfo recordMediaReportInfo;
        AppMethodBeat.i(252596);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS /*{ENCODED_INT: 233}*/:
                if (i3 == 0) {
                    Log.i("Finder.FinderPostRouterUI", "record cancel");
                    if (!(intent == null || (recordMediaReportInfo = (RecordMediaReportInfo) intent.getParcelableExtra("report")) == null)) {
                        com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
                        com.tencent.mm.plugin.finder.report.i.a(recordMediaReportInfo);
                    }
                    com.tencent.mm.plugin.finder.report.i iVar2 = com.tencent.mm.plugin.finder.report.i.vfo;
                    com.tencent.mm.plugin.finder.report.i.Ks(1);
                }
                finish();
                AppMethodBeat.o(252596);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.audio.l.CTRL_INDEX:
                if (i3 == -1) {
                    if (intent == null) {
                        p.hyc();
                    }
                    Parcelable parcelableExtra = intent.getParcelableExtra("KSEGMENTMEDIAINFO");
                    p.g(parcelableExtra, "data!!.getParcelableExtr…mageUI.KSEGMENTMEDIAINFO)");
                    CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel = (CaptureDataManager.CaptureVideoNormalModel) parcelableExtra;
                    Intent intent2 = new Intent();
                    byte[] byteArray = intent.getBundleExtra("key_extra_data").getByteArray("video_composition");
                    if (byteArray != null) {
                        intent2.putExtra("video_composition", byteArray);
                    }
                    intent2.putExtra("postType", 4);
                    intent2.putExtra("postMediaList", j.ac(captureVideoNormalModel.getVideoPath()));
                    intent2.putExtra("postTypeList", j.ac(4));
                    intent2.putExtra("postThumbList", j.ac(captureVideoNormalModel.aQn()));
                    intent2.putExtra(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, this.postId);
                    intent2.putExtra("edit_id", (String) captureVideoNormalModel.eJJ().y("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
                    intent2.putExtra("KEY_POST_DIRECTLY_FROM_SNS", true);
                    com.tencent.mm.plugin.finder.report.i iVar3 = com.tencent.mm.plugin.finder.report.i.vfo;
                    com.tencent.mm.plugin.finder.report.i.as(5, false);
                    com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                    Intent intent3 = getIntent();
                    p.g(intent3, "getIntent()");
                    com.tencent.mm.plugin.finder.utils.a.b(intent2, intent3);
                    intent2.putExtra("key_context_id", getIntent().getStringExtra("key_context_id"));
                    com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(this, intent2);
                    break;
                } else {
                    finish();
                    overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
                    AppMethodBeat.o(252596);
                    return;
                }
        }
        AppMethodBeat.o(252596);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }
}
