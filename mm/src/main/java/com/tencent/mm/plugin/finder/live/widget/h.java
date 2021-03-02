package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 A2\u00020\u0001:\u0001AB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\rH\u0002J\u0006\u0010(\u001a\u00020\rJ\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\rJ\u0006\u0010,\u001a\u00020$J \u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u000101J$\u00102\u001a\u00020&2\u0006\u00103\u001a\u00020$2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J&\u00108\u001a\u00020$2\b\u00103\u001a\u0004\u0018\u0001092\b\u00104\u001a\u0004\u0018\u0001072\b\u00106\u001a\u0004\u0018\u00010:H\u0016J&\u0010;\u001a\u00020&2\b\u0010<\u001a\u0004\u0018\u0001092\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u000107H\u0016J\u0006\u0010@\u001a\u00020&R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014¨\u0006B"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "coverLayout", "Landroid/view/ViewGroup;", "callback", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;)V", "MENU_ID_SET_HEADIMG_ALBUM", "", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "avatarUrl", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "choosePath", "getChoosePath", "setChoosePath", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "getCoverLayout", "()Landroid/view/ViewGroup;", "liveCoverUrl", "getLiveCoverUrl", "setLiveCoverUrl", "chooseNewCover", "", "editImage", "", "inputPath", "getDefaultCover", "getDefaultCoverSize", "Landroid/graphics/Point;", "getThumbCover", "isReady", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onEditFinish", "p0", "p1", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "p2", "Landroid/os/Bundle;", "onFinishBtnClick", "Landroid/content/Context;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "context", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "extData", "setCover", "Companion", "plugin-finder_release"})
public final class h implements CaptureDataManager.b {
    private static final int uGK = 300;
    private static final int uGL = uGL;
    public static final a uGM = new a((byte) 0);
    public final String TAG = "Finder.FinderLivePostCoverWidget";
    public final MMActivity activity;
    public String kog = "";
    public final ImageView puw;
    public String uEu = "";
    public String uGF = "";
    public final int uGG = 10010;
    public final int uGH = CdnLogic.kMediaTypeBeatificFile;
    private final ViewGroup uGI;
    public final FinderLivePostUIC.e uGJ;

    public h(MMActivity mMActivity, ViewGroup viewGroup, FinderLivePostUIC.e eVar) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(viewGroup, "coverLayout");
        p.h(eVar, "callback");
        AppMethodBeat.i(248107);
        this.activity = mMActivity;
        this.uGI = viewGroup;
        this.uGJ = eVar;
        View findViewById = this.uGI.findViewById(R.id.cpv);
        p.g(findViewById, "coverLayout.findViewById….id.finder_live_cover_iv)");
        this.puw = (ImageView) findViewById;
        this.uGI.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.h.AnonymousClass1 */
            final /* synthetic */ h uGN;

            {
                this.uGN = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(248104);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!g.aAh().isSDCardAvailable()) {
                    u.kf(this.uGN.activity);
                } else {
                    s.c(this.uGN.activity, this.uGN.uGG, null);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(248104);
            }
        });
        AppMethodBeat.o(248107);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget$Companion;", "", "()V", "DEFAULT_COVER_HEIGHT", "", "getDEFAULT_COVER_HEIGHT", "()I", "DEFAULT_COVER_WIDTH", "getDEFAULT_COVER_WIDTH", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(248108);
        AppMethodBeat.o(248108);
    }

    public static Point djK() {
        AppMethodBeat.i(248105);
        Point point = new Point(uGK, uGL);
        AppMethodBeat.o(248105);
        return point;
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final void a(Context context, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
        AppMethodBeat.i(248106);
        Intent intent = new Intent();
        intent.putExtra("key_extra_data", bundle);
        if (captureVideoNormalModel == null) {
            t tVar = new t("null cannot be cast to non-null type android.os.Parcelable");
            AppMethodBeat.o(248106);
            throw tVar;
        }
        intent.putExtra("KSEGMENTMEDIAINFO", captureVideoNormalModel);
        if (context == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(248106);
            throw tVar2;
        }
        ((Activity) context).setResult(-1, intent);
        ((Activity) context).finish();
        AppMethodBeat.o(248106);
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final void a(RecordMediaReportInfo recordMediaReportInfo, Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final boolean a(Context context, Bundle bundle, CaptureDataManager.a aVar) {
        return false;
    }
}
