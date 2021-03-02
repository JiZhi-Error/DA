package com.tencent.mm.plugin.recordvideo.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ab;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.recordvideo.a.b;
import com.tencent.mm.plugin.recordvideo.activity.a.b;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.d.g;
import com.tencent.mm.plugin.recordvideo.e.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0017\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0006\u0010\u0012\u001a\u00020\u0010J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u0016\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00140\u0017H\u0002J\"\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0010H\u0014J\b\u0010%\u001a\u00020\u0010H\u0014J-\u0010&\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00142\u000e\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0(2\u0006\u0010*\u001a\u00020+H\u0016¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u0010H\u0014J\b\u0010.\u001a\u00020\u0010H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/activity/MMRecordUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "controller", "Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIController;", "isLargeScreen", "", "mediaGenerateCallback", "Lcom/tencent/mm/plugin/recordvideo/biz/MediaGenerateShareCallback;", "root", "Landroid/view/ViewGroup;", "uiRouter", "Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter;", "checkScreenSize", "", "finish", "finishWithCancel", "getForceOrientation", "", "getLayoutId", "initIntentData", "Lkotlin/Pair;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "setWindowStyle", "Companion", "plugin-recordvideo_release"})
public class MMRecordUI extends MMActivity {
    public static final a BJu = new a((byte) 0);
    private b BJq;
    private com.tencent.mm.plugin.recordvideo.activity.a.a BJr = new com.tencent.mm.plugin.recordvideo.activity.a.a();
    private com.tencent.mm.plugin.recordvideo.activity.a.b BJs;
    private boolean BJt;
    private ViewGroup hwr;
    private RecordConfigProvider wdm;

    static {
        AppMethodBeat.i(75063);
        AppMethodBeat.o(75063);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MMRecordUI() {
        AppMethodBeat.i(75062);
        AppMethodBeat.o(75062);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/activity/MMRecordUI$Companion;", "", "()V", "REQUEST_CODE_LABEL_SELECT", "", "REQUEST_CODE_LOCATION", "REQUEST_CODE_START", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bly;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x012e, code lost:
        if (r1 == 999) goto L_0x0130;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0333  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0338  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r14) {
        /*
        // Method dump skipped, instructions count: 836
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.activity.MMRecordUI.onCreate(android.os.Bundle):void");
    }

    private final void eIE() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        RecordConfigProvider recordConfigProvider;
        ViewGroup.LayoutParams layoutParams3;
        AppMethodBeat.i(75054);
        if (!ao.gJI() || (recordConfigProvider = this.wdm) == null || !recordConfigProvider.BOI) {
            ViewGroup viewGroup = this.hwr;
            if (!(viewGroup == null || (layoutParams2 = viewGroup.getLayoutParams()) == null)) {
                layoutParams2.width = -1;
            }
            ViewGroup viewGroup2 = this.hwr;
            if (!(viewGroup2 == null || (layoutParams = viewGroup2.getLayoutParams()) == null)) {
                layoutParams.height = -1;
            }
            com.tencent.mm.plugin.recordvideo.model.a aVar = com.tencent.mm.plugin.recordvideo.model.a.BOO;
            com.tencent.mm.plugin.recordvideo.model.a.VA(au.az(getContext()).x);
            com.tencent.mm.plugin.recordvideo.model.a aVar2 = com.tencent.mm.plugin.recordvideo.model.a.BOO;
            com.tencent.mm.plugin.recordvideo.model.a.BC(au.az(getContext()).y);
            AppMethodBeat.o(75054);
            return;
        }
        AppCompatActivity context = getContext();
        p.g(context, "context");
        Window window = context.getWindow();
        p.g(window, "context.window");
        window.getDecorView().setBackgroundColor(com.tencent.mm.cb.a.n(getContext(), R.color.fm));
        int i2 = au.az(getContext()).y;
        int i3 = (int) (((float) i2) * 0.5625f);
        ViewGroup viewGroup3 = this.hwr;
        if (!(viewGroup3 == null || (layoutParams3 = viewGroup3.getLayoutParams()) == null)) {
            layoutParams3.width = i3;
            layoutParams3.height = i2;
            if (layoutParams3 instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams3).gravity = 17;
            } else if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams3).gravity = 17;
            } else if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams3).addRule(13);
            }
        }
        com.tencent.mm.plugin.recordvideo.model.a aVar3 = com.tencent.mm.plugin.recordvideo.model.a.BOO;
        com.tencent.mm.plugin.recordvideo.model.a.VA(i3);
        com.tencent.mm.plugin.recordvideo.model.a aVar4 = com.tencent.mm.plugin.recordvideo.model.a.BOO;
        com.tencent.mm.plugin.recordvideo.model.a.BC(i2);
        AppMethodBeat.o(75054);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(75055);
        p.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        boolean z = ((configuration.screenLayout & 3) == 0 || (configuration.screenLayout & 16) == 0) ? false : true;
        if (z != this.BJt) {
            this.BJt = z;
            eIE();
        }
        AppMethodBeat.o(75055);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(75056);
        try {
            super.onResume();
            f.cjj();
            com.tencent.mm.plugin.recordvideo.activity.a.b bVar = this.BJs;
            if (bVar != null) {
                Log.i("MicroMsg.RecordUIRouter", "onResume " + bVar.BJw);
                BasePluginLayout basePluginLayout = bVar.BJw;
                if (basePluginLayout != null) {
                    basePluginLayout.onResume();
                }
            }
            Log.i("MicroMsg.MMRecordUI", "MMRecordUI onResume " + hashCode() + "  ");
            AppMethodBeat.o(75056);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMRecordUI", "MMRecordUI onResume " + hashCode());
            Log.printErrStackTrace("MicroMsg.MMRecordUI", e2, "", new Object[0]);
            finish();
            AppMethodBeat.o(75056);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(75057);
        Log.i("MicroMsg.MMRecordUI", "MMRecordUI onPause  isFinishing  : " + isFinishing() + "  " + hashCode() + "  ");
        super.onPause();
        f.cji();
        if (isFinishing()) {
            AppMethodBeat.o(75057);
            return;
        }
        com.tencent.mm.plugin.recordvideo.activity.a.b bVar = this.BJs;
        if (bVar != null) {
            Log.i("MicroMsg.RecordUIRouter", "onPause " + bVar.BJw);
            BasePluginLayout basePluginLayout = bVar.BJw;
            if (basePluginLayout != null) {
                basePluginLayout.onPause();
                AppMethodBeat.o(75057);
                return;
            }
            AppMethodBeat.o(75057);
            return;
        }
        AppMethodBeat.o(75057);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(75058);
        Log.i("MicroMsg.MMRecordUI", "MMRecordUI onDestroy " + hashCode());
        super.onDestroy();
        com.tencent.mm.plugin.recordvideo.activity.a.b bVar = this.BJs;
        if (bVar != null) {
            Log.i("MicroMsg.RecordUIRouter", "onDestroy " + bVar.BJw);
            MMHandlerThread.postToMainThread(new b.c(bVar));
            if (bVar.BJw instanceof RecordPluginLayout) {
                c cVar = c.BXI;
                c.x("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
            }
            c cVar2 = c.BXI;
            com.tencent.mm.g.b.a.ao aoVar = new com.tencent.mm.g.b.a.ao();
            RecordMediaReportInfo eKW = c.eKW();
            Object y = eKW.y("KEY_NET_TYPE_INT", -1L);
            p.g(y, "info.getReportValue(KEY_NET_TYPE_INT,-1)");
            aoVar.cf(((Number) y).longValue());
            Object y2 = eKW.y("KEY_FROM_SCENE_INT", -1L);
            p.g(y2, "info.getReportValue(KEY_FROM_SCENE_INT,-1)");
            aoVar.cg(((Number) y2).longValue());
            Object y3 = eKW.y("KEY_ENTER_TIME_MS_LONG", -1L);
            p.g(y3, "info.getReportValue(KEY_ENTER_TIME_MS_LONG,-1)");
            aoVar.ch(((Number) y3).longValue());
            Object y4 = eKW.y("KEY_EXIT_TIME_MS_LONG", -1L);
            p.g(y4, "info.getReportValue(KEY_EXIT_TIME_MS_LONG,-1)");
            aoVar.ci(((Number) y4).longValue());
            Object y5 = eKW.y("KEY_MEDIA_SOURCE_INT", -1L);
            p.g(y5, "info.getReportValue(KEY_MEDIA_SOURCE_INT,-1)");
            aoVar.cj(((Number) y5).longValue());
            Object y6 = eKW.y("KEY_MEDIA_TYPE_INT", -1L);
            p.g(y6, "info.getReportValue(KEY_MEDIA_TYPE_INT,-1)");
            aoVar.ck(((Number) y6).longValue());
            Object y7 = eKW.y("KEY_START_RECORD_MS_LONG", -1L);
            p.g(y7, "info.getReportValue(KEY_START_RECORD_MS_LONG,-1)");
            aoVar.cl(((Number) y7).longValue());
            Object y8 = eKW.y("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", -1L);
            p.g(y8, "info.getReportValue(KEY_…EDIA_DURATION_MS_LONG,-1)");
            aoVar.cm(((Number) y8).longValue());
            Object y9 = eKW.y("KEY_ORIGIN_MEDIA_WIDTH_INT", -1L);
            p.g(y9, "info.getReportValue(KEY_ORIGIN_MEDIA_WIDTH_INT,-1)");
            aoVar.cn(((Number) y9).longValue());
            Object y10 = eKW.y("KEY_ORIGIN_MEDIA_HEIGHT_INT", -1L);
            p.g(y10, "info.getReportValue(KEY_…IGIN_MEDIA_HEIGHT_INT,-1)");
            aoVar.co(((Number) y10).longValue());
            Object y11 = eKW.y("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", -1L);
            p.g(y11, "info.getReportValue(KEY_…ROP_PAGE_TIME_MS_LONG,-1)");
            aoVar.cp(((Number) y11).longValue());
            Object y12 = eKW.y("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", -1L);
            p.g(y12, "info.getReportValue(KEY_…ROP_PAGE_TIME_MS_LONG,-1)");
            aoVar.cq(((Number) y12).longValue());
            Object y13 = eKW.y("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", -1L);
            p.g(y13, "info.getReportValue(KEY_…DIT_PAGE_TIME_MS_LONG,-1)");
            aoVar.cr(((Number) y13).longValue());
            Object y14 = eKW.y("KEY_CLICK_EMOJI_COUNT_INT", 0L);
            p.g(y14, "info.getReportValue(KEY_CLICK_EMOJI_COUNT_INT,0)");
            aoVar.cs(((Number) y14).longValue());
            Object y15 = eKW.y("KEY_ADD_EMOJI_COUNT_INT", 0L);
            p.g(y15, "info.getReportValue(KEY_ADD_EMOJI_COUNT_INT,0)");
            aoVar.ct(((Number) y15).longValue());
            Object y16 = eKW.y("KEY_CLICK_TEXT_COUNT_INT", 0L);
            p.g(y16, "info.getReportValue(KEY_CLICK_TEXT_COUNT_INT,0)");
            aoVar.cu(((Number) y16).longValue());
            Object y17 = eKW.y("KEY_ADD_TEXT_COUNT_INT", 0L);
            p.g(y17, "info.getReportValue(KEY_ADD_TEXT_COUNT_INT,0)");
            aoVar.cv(((Number) y17).longValue());
            Object y18 = eKW.y("KEY_CLICK_DOODLE_COUNT_INT", 0L);
            p.g(y18, "info.getReportValue(KEY_CLICK_DOODLE_COUNT_INT,0)");
            aoVar.cw(((Number) y18).longValue());
            Object y19 = eKW.y("KEY_ADD_DOODLE_COUNT_INT", 0L);
            p.g(y19, "info.getReportValue(KEY_ADD_DOODLE_COUNT_INT,0)");
            aoVar.cx(((Number) y19).longValue());
            Object y20 = eKW.y("KEY_ADD_DOODLE_COLOR_COUNT_INT", 0L);
            p.g(y20, "info.getReportValue(KEY_…DOODLE_COLOR_COUNT_INT,0)");
            aoVar.cy(((Number) y20).longValue());
            Object y21 = eKW.y("KEY_CLICK_MOSAIC_COUNT_INT", 0L);
            p.g(y21, "info.getReportValue(KEY_CLICK_MOSAIC_COUNT_INT,0)");
            aoVar.cz(((Number) y21).longValue());
            Object y22 = eKW.y("KEY_CLICK_BRUSH_COUNT_INT", 0L);
            p.g(y22, "info.getReportValue(KEY_CLICK_BRUSH_COUNT_INT,0)");
            aoVar.cA(((Number) y22).longValue());
            Object y23 = eKW.y("KEY_ADD_MOSAIC_COUNT_INT", 0L);
            p.g(y23, "info.getReportValue(KEY_ADD_MOSAIC_COUNT_INT,0)");
            aoVar.cB(((Number) y23).longValue());
            Object y24 = eKW.y("KEY_CLICK_CROP_COUNT_INT", 0L);
            p.g(y24, "info.getReportValue(KEY_CLICK_CROP_COUNT_INT,0)");
            aoVar.cC(((Number) y24).longValue());
            Object y25 = eKW.y("KEY_CROP_MEDIA_HEIGHT_INT", -1L);
            p.g(y25, "info.getReportValue(KEY_CROP_MEDIA_HEIGHT_INT,-1)");
            aoVar.cE(((Number) y25).longValue());
            Object y26 = eKW.y("KEY_CROP_MEDIA_WIDTH_INT", -1L);
            p.g(y26, "info.getReportValue(KEY_CROP_MEDIA_WIDTH_INT,-1)");
            aoVar.cD(((Number) y26).longValue());
            Object y27 = eKW.y("KEY_ROTATE_INT", -1L);
            p.g(y27, "info.getReportValue(KEY_ROTATE_INT,-1)");
            aoVar.cF(((Number) y27).longValue());
            Object y28 = eKW.y("KEY_CLICK_MUSIC_COUNT_INT", 0L);
            p.g(y28, "info.getReportValue(KEY_CLICK_MUSIC_COUNT_INT,0)");
            aoVar.cG(((Number) y28).longValue());
            Object y29 = eKW.y("KEY_MUSIC_ID_INT", -1L);
            p.g(y29, "info.getReportValue(KEY_MUSIC_ID_INT,-1)");
            aoVar.cH(((Number) y29).longValue());
            Object y30 = eKW.y("KEY_MUSIC_INDEX_INT", -1L);
            p.g(y30, "info.getReportValue(KEY_MUSIC_INDEX_INT,-1)");
            aoVar.cI(((Number) y30).longValue());
            Object y31 = eKW.y("KEY_SELECT_MUSIC_INT", -1L);
            p.g(y31, "info.getReportValue(KEY_SELECT_MUSIC_INT,-1)");
            aoVar.cJ(((Number) y31).longValue());
            Object y32 = eKW.y("KEY_SELECT_ORIGIN_INT", -1L);
            p.g(y32, "info.getReportValue(KEY_SELECT_ORIGIN_INT,-1)");
            aoVar.cK(((Number) y32).longValue());
            Object y33 = eKW.y("KEY_MUSIC_REQ_ID_INT", -1L);
            p.g(y33, "info.getReportValue(KEY_MUSIC_REQ_ID_INT,-1)");
            aoVar.cL(((Number) y33).longValue());
            Object y34 = eKW.y("KEY_SEARCH_MUSIC_INT", -1L);
            p.g(y34, "info.getReportValue(KEY_SEARCH_MUSIC_INT,-1)");
            aoVar.cM(((Number) y34).longValue());
            Object y35 = eKW.y("KEY_CLICK_VIDEO_CROP_COUNT_INT", 0L);
            p.g(y35, "info.getReportValue(KEY_…K_VIDEO_CROP_COUNT_INT,0)");
            aoVar.cN(((Number) y35).longValue());
            Object y36 = eKW.y("KEY_VIDEO_CROP_DURATION_MS_INT", -1L);
            p.g(y36, "info.getReportValue(KEY_…_CROP_DURATION_MS_INT,-1)");
            aoVar.cO(((Number) y36).longValue());
            Object y37 = eKW.y("KEY_AFTER_EDIT_INT", -1L);
            p.g(y37, "info.getReportValue(KEY_AFTER_EDIT_INT,-1)");
            aoVar.cP(((Number) y37).longValue());
            Object y38 = eKW.y("KEY_EDIT_PUBLISHID_INT", -1L);
            p.g(y38, "info.getReportValue(KEY_EDIT_PUBLISHID_INT,-1)");
            aoVar.cQ(((Number) y38).longValue());
            Object y39 = eKW.y("KEY_IS_SHOW_WESEE_BTN", 0L);
            p.g(y39, "info.getReportValue(KEY_IS_SHOW_WESEE_BTN, 0)");
            aoVar.cR(((Number) y39).longValue());
            Object y40 = eKW.y("KEY_IS_CLICK_WESEE_BTN", 0L);
            p.g(y40, "info.getReportValue(KEY_IS_CLICK_WESEE_BTN, 0)");
            aoVar.cS(((Number) y40).longValue());
            Object y41 = eKW.y("KEY_IS_INSTALL_WESEE", 0L);
            p.g(y41, "info.getReportValue(KEY_IS_INSTALL_WESEE, 0)");
            aoVar.cT(((Number) y41).longValue());
            Object y42 = eKW.y("KEY_WESEE_DIALOG_OPERATION", 0L);
            p.g(y42, "info.getReportValue(KEY_WESEE_DIALOG_OPERATION, 0)");
            aoVar.cU(((Number) y42).longValue());
            aoVar.is(c.BXA.eKV());
            aoVar.bfK();
        }
        e eVar = e.Cit;
        e.eMN();
        if (getIntent().getIntExtra("KEY_PARAMS_SELECTED_BIZ_INT", -1) == 2) {
            ab.diQ.Uo().Un();
        }
        g gVar = g.BXY;
        Log.i("MicroMsg.VideoWidgetReporter", "videoWidgetReporter doReport");
        g.BXV.vQ(g.eLg());
        if (!(g.BXV.ahc() == 0 || g.BXW == 0)) {
            g.BXV.bfK();
        }
        g.BXW = 0;
        com.tencent.mm.media.g.c.igu.aMA();
        AppMethodBeat.o(75058);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0053, code lost:
        if (r1 != true) goto L_0x0055;
     */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBackPressed() {
        /*
            r7 = this;
            r6 = 75059(0x12533, float:1.0518E-40)
            r1 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            java.lang.String r0 = "MicroMsg.MMRecordUI"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "onBackPressed  "
            r2.<init>(r3)
            int r3 = r7.hashCode()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.tencent.mm.sdk.platformtools.Log.i(r0, r2)
            com.tencent.mm.plugin.recordvideo.activity.a.b r2 = r7.BJs
            if (r2 == 0) goto L_0x0055
            com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider r0 = r7.wdm
            if (r0 == 0) goto L_0x005c
            int r0 = r0.scene
        L_0x002b:
            java.lang.String r3 = "MicroMsg.RecordUIRouter"
            java.lang.String r4 = "onBackPressed "
            java.lang.String r5 = java.lang.String.valueOf(r0)
            java.lang.String r4 = r4.concat(r5)
            com.tencent.mm.sdk.platformtools.Log.i(r3, r4)
            com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout r2 = r2.BJw
            if (r2 == 0) goto L_0x0044
            boolean r1 = r2.onBackPress()
        L_0x0044:
            if (r1 != 0) goto L_0x0052
            com.tencent.mm.plugin.recordvideo.d.c r2 = com.tencent.mm.plugin.recordvideo.d.c.BXI
            r2 = 14
            com.tencent.mm.plugin.recordvideo.d.c.VI(r2)
            com.tencent.mm.plugin.recordvideo.d.c r2 = com.tencent.mm.plugin.recordvideo.d.c.BXI
            com.tencent.mm.plugin.recordvideo.d.c.VK(r0)
        L_0x0052:
            r0 = 1
            if (r1 == r0) goto L_0x0058
        L_0x0055:
            r7.eIF()
        L_0x0058:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x005c:
            r0 = r1
            goto L_0x002b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.activity.MMRecordUI.onBackPressed():void");
    }

    public final void eIF() {
        AppMethodBeat.i(237236);
        Intent intent = new Intent();
        c cVar = c.BXI;
        intent.putExtra("report", c.eKW());
        setResult(0, intent);
        g gVar = g.BXY;
        g.ax(2, 3);
        finish();
        AppMethodBeat.o(237236);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(75060);
        Log.i("MicroMsg.MMRecordUI", "requestCode : " + i2 + " resultCode:" + i3 + "  " + hashCode());
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 1 && intent != null) {
            com.tencent.mm.plugin.recordvideo.a.b bVar = this.BJq;
            if (bVar != null) {
                bVar.an(this, intent);
                AppMethodBeat.o(75060);
                return;
            }
            AppMethodBeat.o(75060);
            return;
        }
        com.tencent.mm.plugin.recordvideo.activity.a.b bVar2 = this.BJs;
        if (bVar2 != null) {
            Log.i("MicroMsg.RecordUIRouter", "onActivityResult " + i2 + ' ' + i3 + ' ' + intent);
            BasePluginLayout basePluginLayout = bVar2.BJw;
            if (basePluginLayout != null) {
                basePluginLayout.onActivityResult(i2, i3, intent);
                AppMethodBeat.o(75060);
                return;
            }
            AppMethodBeat.o(75060);
            return;
        }
        AppMethodBeat.o(75060);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237237);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        Log.i("MicroMsg.MMRecordUI", "onRequestPermissionsResult, requestCode:".concat(String.valueOf(i2)));
        super.onRequestPermissionsResult(i2, strArr, iArr);
        com.tencent.mm.plugin.recordvideo.activity.a.b bVar = this.BJs;
        if (bVar != null) {
            p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
            p.h(iArr, "grantResults");
            Log.i("MicroMsg.RecordUIRouter", "onRequestPermissionsResult ".concat(String.valueOf(i2)));
            BasePluginLayout basePluginLayout = bVar.BJw;
            if (basePluginLayout != null) {
                basePluginLayout.onRequestPermissionsResult(i2, strArr, iArr);
                AppMethodBeat.o(237237);
                return;
            }
            AppMethodBeat.o(237237);
            return;
        }
        AppMethodBeat.o(237237);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(75061);
        Log.i("MicroMsg.MMRecordUI", "finish  " + hashCode());
        super.finish();
        e eVar = e.Cit;
        e.eMN();
        CaptureDataManager.BOb.a(null);
        com.tencent.mm.plugin.recordvideo.b.g gVar = com.tencent.mm.plugin.recordvideo.b.g.BNx;
        com.tencent.mm.plugin.recordvideo.b.g.unInit();
        com.tencent.mm.plugin.recordvideo.background.f fVar = com.tencent.mm.plugin.recordvideo.background.f.BKw;
        com.tencent.mm.plugin.recordvideo.background.f.eIY();
        com.tencent.mm.plugin.recordvideo.activity.a.b bVar = this.BJs;
        if (bVar != null) {
            Log.i("MicroMsg.RecordUIRouter", "finish " + bVar.BJw);
            bVar.isFinishing = true;
            MMHandlerThread.postToMainThread(new b.RunnableC1635b(bVar));
        }
        if (!(getIntent() == null || getIntent().getIntExtra("KEY_PARAMS_EXIT_ANIM", -1) == -1)) {
            overridePendingTransition(-1, getIntent().getIntExtra("KEY_PARAMS_EXIT_ANIM", -1));
        }
        AppMethodBeat.o(75061);
    }
}
