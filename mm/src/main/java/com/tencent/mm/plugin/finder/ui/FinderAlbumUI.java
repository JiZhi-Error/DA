package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.m;
import com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout;
import com.tencent.mm.plugin.vlog.ui.MultiVideoPluginLayout;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001MB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0017H\u0014J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0002J \u0010\u001c\u001a\u00020\u001a2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u001ej\b\u0012\u0004\u0012\u00020\u0017`\u001fH\u0002J\b\u0010 \u001a\u00020\u0007H\u0002JN\u0010!\u001a\u00020\u001a2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u001ej\b\u0012\u0004\u0012\u00020\u0017`\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u001c\b\u0002\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u001fH\u0002J\u001c\u0010#\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J\b\u0010)\u001a\u00020\u000bH\u0002J\b\u0010*\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020\u001aH\u0014J\u001e\u0010,\u001a\u00020\u00072\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u001ej\b\u0012\u0004\u0012\u00020\u0017`\u001fJ\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u000bH\u0002J\"\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000b2\b\u00102\u001a\u0004\u0018\u00010'H\u0014J\b\u00103\u001a\u00020\u001aH\u0014J\u0012\u00104\u001a\u00020\u001a2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020\u001aH\u0014J$\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u000106H\u0016J&\u0010=\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010<\u001a\u0004\u0018\u0001062\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J \u0010@\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u000bH\u0014J&\u0010E\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010<\u001a\u0004\u0018\u000106H\u0016J\b\u0010H\u001a\u00020\u0007H\u0014J\b\u0010I\u001a\u00020\u001aH\u0016J\u001a\u0010J\u001a\u00020\u001a2\u0006\u0010K\u001a\u00020\u000b2\b\u0010L\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderAlbumUI;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumPreviewUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "clickTimestamp", "", "isFolloPat", "", "isFromFinderAddMedia", "isHideAfterClick", "originalVideoDuration", "", "originalVideoPath", "", ShareConstants.RESULT_POST_ID, "startActivityFromFlutter", "checkFinderVideoItemFormatValid", "item", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "checkMediaRatio", "width", "height", "checkSelectedImage", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "checkSelectedVideo", "checkVideoPixelFormat", "", "path", "doEnterMMRecordVLogUI", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "doubleClickCheck", "enterFinderMediaCropUI", "vlogVideo", "enterFinderPostUI", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "getMaxDurationSec", "getMaxDurationSecTip", "getMenuText", "initView", "isAllPathIsImage", "jumpImagePreviewUI", "mediaPosition", "onActivityResult", "requestCode", "resultCode", "data", "onBackBtnClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditFinish", "forward", "info", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "onFinishBtnClick", "controller", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaClick", "position", "itemView", "Landroid/view/View;", "itemViewType", "onMediaGenerated", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onSendItemClick", "onStart", "updateOptionMenuText", "menuID", "text", "Companion", "plugin-finder_release"})
public final class FinderAlbumUI extends AlbumPreviewUI implements CaptureDataManager.b {
    public static final a vHi = new a((byte) 0);
    private HashMap _$_findViewCache;
    private long mRS;
    private String postId = "";
    private boolean vHc;
    private boolean vHd;
    private boolean vHe;
    private boolean vHf;
    private int vHg;
    private String vHh = "";

    static {
        AppMethodBeat.i(167139);
        AppMethodBeat.o(167139);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252133);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252133);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252132);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252132);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static final /* synthetic */ void a(FinderAlbumUI finderAlbumUI, Intent intent) {
        AppMethodBeat.i(252130);
        finderAlbumUI.am(intent);
        AppMethodBeat.o(252130);
    }

    public static final /* synthetic */ void a(FinderAlbumUI finderAlbumUI, ArrayList arrayList) {
        AppMethodBeat.i(252131);
        finderAlbumUI.ak(arrayList);
        AppMethodBeat.o(252131);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderAlbumUI$Companion;", "", "()V", "DOUBLE_CLICK_CHECK_INTERVAL", "", "FLUTTER_TAG", "", "REQUEST_CODE_EDIT_VIDEO", "", "REQUEST_CODE_EDIT_VLOG", "REQUEST_CODE_EDIT_VLOG_FLUTTER", "TAG", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
    public final boolean dyR() {
        String str;
        String str2;
        AppMethodBeat.i(167131);
        if (this.het == 25) {
            com.tencent.mm.plugin.gallery.ui.a aVar = this.xnQ;
            p.g(aVar, "adapter");
            ArrayList<GalleryItem.MediaItem> arrayList = new ArrayList<>(aVar.dRM());
            if (arrayList.isEmpty()) {
                Log.e("Finder.AlbumUI", "[onSendItemClick] list isEmpty");
                AppMethodBeat.o(167131);
                return false;
            }
            GalleryItem.MediaItem mediaItem = arrayList.get(0);
            if (!(mediaItem instanceof GalleryItem.VideoMediaItem)) {
                mediaItem = null;
            }
            GalleryItem.VideoMediaItem videoMediaItem = (GalleryItem.VideoMediaItem) mediaItem;
            int i2 = videoMediaItem != null ? videoMediaItem.jkS : 0;
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dvD().value().intValue() == 1 && arrayList.size() == 1) {
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (((long) i2) >= ((long) (com.tencent.mm.plugin.finder.storage.c.drG() + 1)) * 1000) {
                    com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(aj.class);
                    p.g(ah, "plugin(IPluginFinder::class.java)");
                    af finderUtilApi = ((aj) ah).getFinderUtilApi();
                    p.g(finderUtilApi, "plugin(IPluginFinder::class.java).finderUtilApi");
                    if (((long) i2) < ((long) finderUtilApi.dDc()) * 1000 && !this.vHc) {
                        com.tencent.mm.plugin.finder.view.d dVar = new com.tencent.mm.plugin.finder.view.d(getContext());
                        GalleryItem.MediaItem mediaItem2 = arrayList.get(0);
                        if (mediaItem2 == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem");
                            AppMethodBeat.o(167131);
                            throw tVar;
                        }
                        GalleryItem.VideoMediaItem videoMediaItem2 = (GalleryItem.VideoMediaItem) mediaItem2;
                        dVar.Ml(R.layout.ai_);
                        TextView textView = (TextView) dVar.lJI.findViewById(R.id.br5);
                        if (textView != null) {
                            ao.a(textView.getPaint(), 0.8f);
                        }
                        View findViewById = dVar.lJI.findViewById(R.id.bqo);
                        if (findViewById != null) {
                            findViewById.setOnClickListener(new g(dVar));
                        }
                        View findViewById2 = dVar.lJI.findViewById(R.id.esu);
                        if (findViewById2 != null) {
                            findViewById2.setOnClickListener(new d(dVar, videoMediaItem2, this, arrayList));
                        }
                        View findViewById3 = dVar.lJI.findViewById(R.id.hqn);
                        if (findViewById3 != null) {
                            findViewById3.setOnClickListener(new e(dVar, this, arrayList));
                        }
                        dVar.a(new f(this, arrayList));
                        dVar.dGm();
                        com.tencent.mm.plugin.finder.report.af afVar = com.tencent.mm.plugin.finder.report.af.viA;
                        i iVar = i.vfo;
                        FinderFeedReportObject dnX = i.dnX();
                        if (dnX == null || (str = dnX.clickId) == null) {
                            str = "";
                        }
                        i iVar2 = i.vfo;
                        FinderFeedReportObject dnX2 = i.dnX();
                        if (dnX2 == null || (str2 = dnX2.postId) == null) {
                            str2 = "";
                        }
                        com.tencent.mm.plugin.finder.report.af.j(str, str2, cl.aWA() / 1000);
                        AppMethodBeat.o(167131);
                        return true;
                    }
                }
            }
            m mVar = m.Gyi;
            m.fAZ();
            ak(arrayList);
            AppMethodBeat.o(167131);
            return true;
        }
        AppMethodBeat.o(167131);
        return false;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class g implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.finder.view.d tru;

        g(com.tencent.mm.plugin.finder.view.d dVar) {
            this.tru = dVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252116);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tru.bMo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252116);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$1$3"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.finder.view.d tru;
        final /* synthetic */ GalleryItem.VideoMediaItem vHk;
        final /* synthetic */ FinderAlbumUI vHl;
        final /* synthetic */ ArrayList vHm;

        d(com.tencent.mm.plugin.finder.view.d dVar, GalleryItem.VideoMediaItem videoMediaItem, FinderAlbumUI finderAlbumUI, ArrayList arrayList) {
            this.tru = dVar;
            this.vHk = videoMediaItem;
            this.vHl = finderAlbumUI;
            this.vHm = arrayList;
        }

        public final void onClick(View view) {
            String str;
            String str2;
            AppMethodBeat.i(252113);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (FinderAlbumUI.a(this.vHl)) {
                Log.i("Finder.AlbumUI", "onSendItemClick: long video btn hit double click check");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(252113);
                return;
            }
            float f2 = ((float) this.vHk.videoHeight) / ((float) this.vHk.videoWidth);
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(aj.class);
            p.g(ah, "plugin(IPluginFinder::class.java)");
            af finderUtilApi = ((aj) ah).getFinderUtilApi();
            p.g(finderUtilApi, "plugin(IPluginFinder::class.java).finderUtilApi");
            if (f2 <= finderUtilApi.dDd()) {
                com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(aj.class);
                p.g(ah2, "plugin(IPluginFinder::class.java)");
                af finderUtilApi2 = ((aj) ah2).getFinderUtilApi();
                p.g(finderUtilApi2, "plugin(IPluginFinder::class.java).finderUtilApi");
                if (f2 >= finderUtilApi2.dDe()) {
                    this.vHl.vHd = true;
                    this.tru.bMo();
                    Intent intent = new Intent();
                    intent.putExtra(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, this.vHl.postId);
                    intent.putExtra("postType", 4);
                    intent.putExtra("postMediaList", j.ac(this.vHk.dRh()));
                    intent.putExtra("postTypeList", j.ac(4));
                    intent.putExtra("isLongVideoPost", true);
                    com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                    Intent intent2 = this.vHl.getIntent();
                    p.g(intent2, "getIntent()");
                    com.tencent.mm.plugin.finder.utils.a.b(intent, intent2);
                    FinderAlbumUI.a(this.vHl, intent);
                    com.tencent.mm.plugin.finder.report.af afVar = com.tencent.mm.plugin.finder.report.af.viA;
                    i iVar = i.vfo;
                    FinderFeedReportObject dnX = i.dnX();
                    if (dnX == null || (str = dnX.clickId) == null) {
                        str = "";
                    }
                    i iVar2 = i.vfo;
                    FinderFeedReportObject dnX2 = i.dnX();
                    if (dnX2 == null || (str2 = dnX2.postId) == null) {
                        str2 = "";
                    }
                    com.tencent.mm.plugin.finder.report.af.a(str, str2, 2, cl.aWA() / 1000, 2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(252113);
                    return;
                }
            }
            u.makeText(this.vHl.getContext(), (int) R.string.dmg, 0).show();
            this.vHl.vHd = true;
            this.tru.bMo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252113);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$1$4"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.finder.view.d tru;
        final /* synthetic */ FinderAlbumUI vHl;
        final /* synthetic */ ArrayList vHm;

        e(com.tencent.mm.plugin.finder.view.d dVar, FinderAlbumUI finderAlbumUI, ArrayList arrayList) {
            this.tru = dVar;
            this.vHl = finderAlbumUI;
            this.vHm = arrayList;
        }

        public final void onClick(View view) {
            String str;
            String str2;
            AppMethodBeat.i(252114);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (FinderAlbumUI.a(this.vHl)) {
                Log.i("Finder.AlbumUI", "onSendItemClick: short video btn hit double click check");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(252114);
                return;
            }
            this.vHl.vHd = true;
            this.tru.bMo();
            FinderAlbumUI.a(this.vHl, this.vHm);
            com.tencent.mm.plugin.finder.report.af afVar = com.tencent.mm.plugin.finder.report.af.viA;
            i iVar = i.vfo;
            FinderFeedReportObject dnX = i.dnX();
            if (dnX == null || (str = dnX.clickId) == null) {
                str = "";
            }
            i iVar2 = i.vfo;
            FinderFeedReportObject dnX2 = i.dnX();
            if (dnX2 == null || (str2 = dnX2.postId) == null) {
                str2 = "";
            }
            com.tencent.mm.plugin.finder.report.af.a(str, str2, 2, cl.aWA() / 1000, 1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252114);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$1$5"})
    public static final class f implements d.a {
        final /* synthetic */ FinderAlbumUI vHl;
        final /* synthetic */ ArrayList vHm;

        f(FinderAlbumUI finderAlbumUI, ArrayList arrayList) {
            this.vHl = finderAlbumUI;
            this.vHm = arrayList;
        }

        @Override // com.tencent.mm.plugin.finder.view.d.a
        public final void onDismiss() {
            String str;
            String str2;
            AppMethodBeat.i(252115);
            if (this.vHl.vHd) {
                this.vHl.vHd = false;
                AppMethodBeat.o(252115);
                return;
            }
            com.tencent.mm.plugin.finder.report.af afVar = com.tencent.mm.plugin.finder.report.af.viA;
            i iVar = i.vfo;
            FinderFeedReportObject dnX = i.dnX();
            if (dnX == null || (str = dnX.clickId) == null) {
                str = "";
            }
            i iVar2 = i.vfo;
            FinderFeedReportObject dnX2 = i.dnX();
            if (dnX2 == null || (str2 = dnX2.postId) == null) {
                str2 = "";
            }
            com.tencent.mm.plugin.finder.report.af.a(str, str2, 2, cl.aWA() / 1000, 3);
            AppMethodBeat.o(252115);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void updateOptionMenuText(int i2, String str) {
        AppMethodBeat.i(167132);
        super.updateOptionMenuText(i2, dyS());
        AppMethodBeat.o(167132);
    }

    @Override // com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
    public final void onBackBtnClick() {
        AppMethodBeat.i(167133);
        i iVar = i.vfo;
        i.Ks(3);
        AppMethodBeat.o(167133);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0068  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r8) {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.ui.FinderAlbumUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
    public final void onStart() {
        AppMethodBeat.i(252118);
        super.onStart();
        if (this.vHe) {
            ((com.tencent.mm.plugin.flutter.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.flutter.a.a.class)).dLp();
        }
        AppMethodBeat.o(252118);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
    public final void initView() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(167134);
        super.initView();
        removeOptionMenu(0);
        getController().Bi(true);
        addTextOptionMenu(0, dyS(), this.xow, null, t.b.ORANGE);
        RecyclerView recyclerView = this.xnM;
        p.g(recyclerView, "gallery");
        recyclerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        NM(0);
        String stringExtra = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID");
        if (stringExtra == null || stringExtra.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            z2 = true;
        }
        this.vHc = z2;
        AppMethodBeat.o(167134);
    }

    private final String dyS() {
        AppMethodBeat.i(167135);
        com.tencent.mm.plugin.gallery.ui.a aVar = this.xnQ;
        p.g(aVar, "adapter");
        int size = aVar.dRM().size();
        if (size > 0) {
            StringBuilder sb = new StringBuilder();
            AppCompatActivity context = getContext();
            p.g(context, "context");
            String sb2 = sb.append(context.getResources().getString(R.string.x5)).append('(').append(size).append('/').append(this.wnd).append(')').toString();
            AppMethodBeat.o(167135);
            return sb2;
        }
        AppCompatActivity context2 = getContext();
        p.g(context2, "context");
        String string = context2.getResources().getString(R.string.x5);
        p.g(string, "context.resources.getString(R.string.app_nextstep)");
        AppMethodBeat.o(167135);
        return string;
    }

    private static boolean gl(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return false;
        }
        float f2 = ((float) i2) / ((float) i3);
        if (f2 > 3.0f || f2 < 0.33333334f) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
    public final boolean a(GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(252119);
        if (mediaItem instanceof GalleryItem.ImageMediaItem) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeFile(((GalleryItem.ImageMediaItem) mediaItem).dRh(), options);
            if (!gl(options.outWidth, options.outHeight)) {
                h.cA(this, getString(R.string.dmw));
                AppMethodBeat.o(252119);
                return false;
            }
            AppMethodBeat.o(252119);
            return true;
        }
        AppMethodBeat.o(252119);
        return false;
    }

    @Override // com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
    public final boolean b(GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(252120);
        if (!(mediaItem instanceof GalleryItem.VideoMediaItem)) {
            AppMethodBeat.o(252120);
            return false;
        } else if (!gl(((GalleryItem.VideoMediaItem) mediaItem).videoWidth, ((GalleryItem.VideoMediaItem) mediaItem).videoHeight)) {
            h.cA(this, getString(R.string.dmz));
            AppMethodBeat.o(252120);
            return false;
        } else {
            boolean a2 = a((GalleryItem.VideoMediaItem) mediaItem);
            if (!a2) {
                r.f fVar = r.f.vhE;
                r.f.ai(((GalleryItem.VideoMediaItem) mediaItem).jkQ, ((GalleryItem.VideoMediaItem) mediaItem).jkR, mediaItem.xiW);
                h.cC(this, getString(R.string.dme));
            }
            AppMethodBeat.o(252120);
            return a2;
        }
    }

    @Override // com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
    public final void g(int i2, View view) {
        AppMethodBeat.i(167136);
        p.h(view, "itemView");
        GalleryItem.MediaItem NK = this.xnQ.NK(i2);
        if (NK == null || Util.isNullOrNil(NK.dRh())) {
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(NK == null);
            Log.w("Finder.AlbumUI", "item is null %s, item original path is null", objArr);
            AppMethodBeat.o(167136);
            return;
        }
        if (this.het == 25) {
            if (NK instanceof GalleryItem.VideoMediaItem) {
                int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_album_video_max_select_duration_android, 300);
                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(aj.class);
                p.g(ah, "plugin(IPluginFinder::class.java)");
                af finderUtilApi = ((aj) ah).getFinderUtilApi();
                p.g(finderUtilApi, "plugin(IPluginFinder::class.java).finderUtilApi");
                int max = Math.max(a2, finderUtilApi.dDc());
                int dyT = dyT();
                this.vHg = ((GalleryItem.VideoMediaItem) NK).jkS;
                String dRh = ((GalleryItem.VideoMediaItem) NK).dRh();
                p.g(dRh, "item.originalPath");
                this.vHh = dRh;
                int i3 = ((GalleryItem.VideoMediaItem) NK).jkS;
                com.tencent.mm.modelcontrol.e baZ = com.tencent.mm.modelcontrol.e.baZ();
                p.g(baZ, "SubCoreVideoControl.getCore()");
                if (i3 < baZ.bbf().minDuration * 1000) {
                    Resources resources = getResources();
                    com.tencent.mm.modelcontrol.e baZ2 = com.tencent.mm.modelcontrol.e.baZ();
                    p.g(baZ2, "SubCoreVideoControl.getCore()");
                    h.c(getContext(), resources.getString(R.string.dnb, Integer.valueOf(baZ2.bbf().minDuration)), "", false);
                    AppMethodBeat.o(167136);
                    return;
                } else if (((GalleryItem.VideoMediaItem) NK).jkS > max * 1000) {
                    h.c(getContext(), getResources().getString(R.string.dnc, Integer.valueOf(dyT)), "", false);
                    AppMethodBeat.o(167136);
                    return;
                } else {
                    Log.i("Finder.AlbumUI", "onMediaClick, video mime:" + ((GalleryItem.VideoMediaItem) NK).jkQ + ", audio mime:" + ((GalleryItem.VideoMediaItem) NK).jkR + ", path:" + NK.xiW);
                    if (!a((GalleryItem.VideoMediaItem) NK)) {
                        r.f fVar = r.f.vhE;
                        r.f.ai(((GalleryItem.VideoMediaItem) NK).jkQ, ((GalleryItem.VideoMediaItem) NK).jkR, NK.xiW);
                        f.a aVar = new f.a(getContext());
                        aVar.aC(com.tencent.mm.cb.a.aI(getContext(), R.string.dme));
                        aVar.boA(com.tencent.mm.cb.a.aI(getContext(), R.string.dlu));
                        aVar.b(c.vHj);
                        aVar.show();
                        AppMethodBeat.o(167136);
                        return;
                    }
                    new ArrayList(1).add(NK);
                    ArrayList<GalleryItem.MediaItem> NJ = this.xnQ.NJ(((GalleryItem.VideoMediaItem) NK).getType());
                    com.tencent.mm.plugin.gallery.model.e.ao(NJ);
                    Lk(NJ.indexOf(NK));
                    AppMethodBeat.o(167136);
                    return;
                }
            } else {
                ArrayList<GalleryItem.MediaItem> NJ2 = this.xnQ.NJ(NK.getType());
                com.tencent.mm.plugin.gallery.model.e.ao(NJ2);
                Lk(NJ2.indexOf(NK));
            }
        }
        AppMethodBeat.o(167136);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class c implements f.c {
        public static final c vHj = new c();

        static {
            AppMethodBeat.i(167130);
            AppMethodBeat.o(167130);
        }

        c() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
        }
    }

    private static int dyT() {
        AppMethodBeat.i(252121);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_album_video_max_select_duration_android, 300);
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(aj.class);
        p.g(ah, "plugin(IPluginFinder::class.java)");
        af finderUtilApi = ((aj) ah).getFinderUtilApi();
        p.g(finderUtilApi, "plugin(IPluginFinder::class.java).finderUtilApi");
        int max = Math.max(a2, finderUtilApi.dDc() - 1);
        AppMethodBeat.o(252121);
        return max;
    }

    private final boolean a(GalleryItem.VideoMediaItem videoMediaItem) {
        boolean z;
        AppMethodBeat.i(252122);
        if (n.I(TPDecoderType.TP_CODEC_MIMETYPE_HEVC, videoMediaItem.jkQ, true) && com.tencent.mm.plugin.n.f.ejb()) {
            z = true;
        } else if (n.I("video/avc", videoMediaItem.jkQ, true)) {
            z = true;
        } else {
            z = false;
        }
        if (!Util.isNullOrNil(videoMediaItem.jkR) && !n.I(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE, videoMediaItem.jkR, true)) {
            z = false;
        }
        if (com.tencent.mm.modelvideo.r.Ql(videoMediaItem.xiW)) {
            if (Util.isNullOrNil(videoMediaItem.jkQ) || !com.tencent.mm.plugin.n.f.aFg(videoMediaItem.jkQ) || Util.isNullOrNil(videoMediaItem.jkR) || !com.tencent.mm.plugin.n.f.aFg(videoMediaItem.jkR)) {
                Log.i("Finder.AlbumUI", "qt video cannot decode");
                z = false;
            } else {
                Log.i("Finder.AlbumUI", "qt video can decode");
                z = true;
            }
        }
        String dRh = videoMediaItem.dRh();
        p.g(dRh, "item.originalPath");
        avJ(dRh);
        if (!z || bG(videoMediaItem.xiW, false)) {
            AppMethodBeat.o(252122);
            return false;
        }
        AppMethodBeat.o(252122);
        return true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ String lCM;

        b(String str) {
            this.lCM = str;
        }

        public final void run() {
            int i2;
            AppMethodBeat.i(252112);
            MultiMediaVideoChecker.a cA = MultiMediaVideoChecker.GyY.cA(this.lCM, true);
            if (cA == null || cA.pixelFormat != -1) {
                MultiMediaVideoChecker multiMediaVideoChecker = MultiMediaVideoChecker.GyY;
                if (cA != null) {
                    i2 = cA.pixelFormat;
                } else {
                    i2 = 0;
                }
                if (!MultiMediaVideoChecker.acy(i2)) {
                    Log.i("Finder.AlbumUI", "select invalid pixelFormat video:" + (cA != null ? Integer.valueOf(cA.pixelFormat) : null));
                    com.tencent.mm.plugin.vlog.model.report.a aVar = com.tencent.mm.plugin.vlog.model.report.a.GBa;
                    com.tencent.mm.plugin.vlog.model.report.a.fCk();
                }
            }
            AppMethodBeat.o(252112);
        }
    }

    private static void avJ(String str) {
        AppMethodBeat.i(252123);
        com.tencent.f.h.RTc.aX(new b(str));
        AppMethodBeat.o(252123);
    }

    private final void Lk(int i2) {
        AppMethodBeat.i(252124);
        Intent intent = new Intent(this, ImagePreviewUI.class);
        com.tencent.mm.plugin.gallery.ui.a aVar = this.xnQ;
        p.g(aVar, "adapter");
        intent.putStringArrayListExtra("preview_image_list", aVar.dRL());
        com.tencent.mm.plugin.gallery.ui.a aVar2 = this.xnQ;
        p.g(aVar2, "adapter");
        intent.putParcelableArrayListExtra("preview_media_item_list", aVar2.dRM());
        intent.putExtra("preview_all", true);
        intent.putExtra("preview_position", i2);
        az(i2, true);
        intent.putExtra("send_raw_img", this.qoL);
        intent.putExtra("key_force_hide_edit_image_button", true);
        intent.putExtra("max_select_count", this.wnd);
        intent.putExtra("GalleryUI_FromUser", this.dRL);
        intent.putExtra("GalleryUI_ToUser", this.toUser);
        intent.putExtra("album_business_tag", this.xnr);
        intent.putExtra("album_video_max_duration", Math.max(this.kyt, dyT()));
        intent.putExtra("album_video_min_duration", this.xoo);
        intent.putExtra(MessengerShareContentUtility.MEDIA_TYPE, 2);
        intent.putExtra("key_support_max_ratio", 3.0f);
        o dQK = com.tencent.mm.plugin.gallery.model.e.dQK();
        p.g(dQK, "GalleryCore.getMediaQueryService()");
        if (dQK.dRp() == 14) {
            intent.putExtra("key_edit_video_max_time_length", 300500);
        }
        startActivityForResult(intent, 0);
        AppMethodBeat.o(252124);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
    public final void onActivityResult(int i2, int i3, Intent intent) {
        CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel = null;
        ArrayList<String> arrayList = null;
        AppMethodBeat.i(167137);
        Log.i("Finder.AlbumUI", "onActivityResult requestCode " + i2 + " resultCod " + i3);
        if (i2 == 1001 && i3 == -1) {
            if (intent == null || !intent.getBooleanExtra("clear_list", false)) {
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(167137);
                return;
            }
            com.tencent.mm.plugin.gallery.ui.a aVar = this.xnQ;
            p.g(aVar, "adapter");
            aVar.dRM().clear();
            this.xnQ.notifyDataSetChanged();
            NM(0);
            AppMethodBeat.o(167137);
        } else if (i3 == 25) {
            if (intent != null) {
                arrayList = intent.getStringArrayListExtra("preview_image_list");
            }
            if (!(arrayList == null || this.xnQ == null)) {
                this.xnQ.aq(arrayList);
                this.xnQ.notifyDataSetChanged();
                NM(arrayList.size());
            }
            dyR();
            AppMethodBeat.o(167137);
        } else if (291 == i2 && i3 == -1) {
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(1);
            if (intent == null) {
                p.hyc();
            }
            Parcelable parcelableExtra = intent.getParcelableExtra("KSEGMENTMEDIAINFO");
            p.g(parcelableExtra, "data!!.getParcelableExtr…mageUI.KSEGMENTMEDIAINFO)");
            CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel2 = (CaptureDataManager.CaptureVideoNormalModel) parcelableExtra;
            GalleryItem.VideoMediaItem videoMediaItem = new GalleryItem.VideoMediaItem();
            videoMediaItem.xiW = captureVideoNormalModel2.getVideoPath();
            videoMediaItem.sUB = captureVideoNormalModel2.aQn();
            videoMediaItem.jkS = (int) captureVideoNormalModel2.eJH().longValue();
            arrayList2.add(videoMediaItem);
            int i4 = this.vHg;
            String str = this.vHh;
            Intent intent2 = new Intent();
            intent2.putExtra("fromAppBrand", getIntent().getBooleanExtra("fromAppBrand", false));
            intent2.putParcelableArrayListExtra("select_path_list", arrayList2);
            intent2.putParcelableArrayListExtra("front_vlog_video", null);
            intent2.putExtra("select_video_path", str);
            intent2.putExtra("select_video_duration", i4);
            intent2.setClass(getContext(), FinderMediaCropUI.class);
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            Intent intent3 = getIntent();
            p.g(intent3, "getIntent()");
            com.tencent.mm.plugin.finder.utils.a.b(intent2, intent3);
            startActivityForResult(intent2, 1001);
            AppMethodBeat.o(167137);
        } else if (292 == i2) {
            FinderAlbumUI finderAlbumUI = this;
            if (intent != null) {
                captureVideoNormalModel = (CaptureDataManager.CaptureVideoNormalModel) intent.getParcelableExtra("KSEGMENTMEDIAINFO");
            }
            CaptureDataManager captureDataManager = CaptureDataManager.BOb;
            p.g(captureDataManager, "CaptureDataManager.INSTANCE");
            a(finderAlbumUI, captureVideoNormalModel, captureDataManager.getExtData());
            AppMethodBeat.o(167137);
        } else {
            if (293 == i2 && i3 == -1) {
                finish();
            }
            AppMethodBeat.o(167137);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
    public final void onDestroy() {
        AppMethodBeat.i(252125);
        CaptureDataManager.BOb.a(null);
        super.onDestroy();
        AppMethodBeat.o(252125);
    }

    private final void ak(ArrayList<GalleryItem.MediaItem> arrayList) {
        String name;
        boolean z;
        boolean z2;
        int i2 = 3;
        AppMethodBeat.i(252126);
        UICustomParam.a aVar = new UICustomParam.a();
        aVar.apE();
        aVar.apD();
        aVar.dz(false);
        aVar.apF();
        aVar.a(R.drawable.k_, 0, "", 0);
        RecordConfigProvider jB = RecordConfigProvider.jB("", "");
        jB.scene = 11;
        jB.BOn = aVar.apG();
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        jB.BOm = com.tencent.mm.plugin.finder.storage.c.dqx();
        jB.BOp = 3;
        jB.BOv = jB.BOm.duration * 1000;
        aVar.dy(false);
        Iterator<T> it = arrayList.iterator();
        boolean z3 = true;
        while (it.hasNext()) {
            if (it.next().getType() == 2) {
                z2 = false;
            } else {
                z2 = z3;
            }
            z3 = z2;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("media_list", arrayList);
        bundle.putString(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, this.postId);
        bundle.putString("KEY_ORIGIN_MUSIC_ID", getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID"));
        bundle.putString("KEY_ORIGIN_BGM_URL", getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_BGM_URL"));
        bundle.putString("KEY_ORIGIN_MUSIC_PATH", getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH"));
        bundle.putString("KEY_ORIGIN_MUSIC_NAME", getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME"));
        bundle.putByteArray("KEY_ORIGIN_MUSIC_INFO", getIntent().getByteArrayExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO"));
        bundle.putBoolean("KEY_BGM_IF_ORIGIN", getIntent().getBooleanExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", false));
        y yVar = y.vXH;
        bundle.putBoolean("KEY_FULLSCREEN", y.isAnyEnableFullScreenEnjoy());
        bundle.putInt("KEY_MEDIA_SOURCE_FROM", 1);
        Point az = ao.az(this);
        y yVar2 = y.vXH;
        Context baseContext = getBaseContext();
        p.g(baseContext, "baseContext");
        kotlin.r<Integer, Integer, Integer> g2 = y.g(baseContext, az.x, az.y);
        Point point = new Point(g2.second.intValue(), g2.SWY.intValue());
        bundle.putInt("KEY_PREVIEW_WIDTH", point.x);
        bundle.putInt("KEY_PREVIEW_HEIGHT", point.y);
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        bundle.putLong("video_max_duration", ((long) com.tencent.mm.plugin.finder.storage.c.drG()) * 1000);
        com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
        bundle.putInt("image_max_height", com.tencent.mm.plugin.finder.storage.c.dqP());
        com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
        bundle.putInt("image_max_width", com.tencent.mm.plugin.finder.storage.c.dqO());
        com.tencent.mm.plugin.finder.storage.c cVar5 = com.tencent.mm.plugin.finder.storage.c.vCb;
        bundle.putInt("image_compress_quality", com.tencent.mm.plugin.finder.storage.c.dqQ());
        al alVar = al.waC;
        bundle.putString("output_dir", al.dEG());
        jB.jkf = bundle;
        y yVar3 = y.vXH;
        if (y.isAnyEnableFullScreenEnjoy()) {
            name = MultiVideoFullScreenPluginLayout.class.getName();
        } else {
            name = MultiVideoPluginLayout.class.getName();
        }
        p.g(name, "if (FinderUtil.isAnyEnab…inLayout::class.java.name");
        jB.F(3, name);
        jB.F(4, name);
        if (!z3) {
            i2 = 4;
        }
        CaptureDataManager.BOb.a(this);
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("media_list");
        if (parcelableArrayList != null) {
            Iterator it2 = parcelableArrayList.iterator();
            z = true;
            while (it2.hasNext()) {
                GalleryItem.MediaItem mediaItem = (GalleryItem.MediaItem) it2.next();
                String str = mediaItem.mMimeType;
                p.g(str, "item.mMimeType");
                if (str == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(252126);
                    throw tVar;
                }
                String substring = str.substring(0, 5);
                p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (n.I(substring, "video", true)) {
                    arrayList3.add("video");
                    z = false;
                } else if (n.I(substring, "image", true)) {
                    arrayList3.add("image");
                }
                p.g(mediaItem, "item");
                arrayList2.add(mediaItem.dRh());
            }
        } else {
            z = true;
        }
        if (!this.vHe || z) {
            com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
            com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), com.tencent.mm.plugin.appbrand.jsapi.audio.l.CTRL_INDEX, 0, 0, jB, i2, 0);
            AppMethodBeat.o(252126);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1565, 0);
        Log.i("Finder.AlbumUI.FlutterVideoEditor_DataReport", "click next step in album activity");
        bundle.putStringArrayList("pathList", arrayList2);
        bundle.putStringArrayList("typeList", arrayList3);
        bundle.putString(ShareConstants.RESULT_POST_ID, this.postId);
        ((com.tencent.mm.plugin.flutter.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.flutter.a.a.class)).a(getContext(), com.tencent.mm.plugin.appbrand.jsapi.audio.h.CTRL_INDEX, bundle);
        AppMethodBeat.o(252126);
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final void a(Context context, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
        byte[] byteArray;
        ArrayList parcelableArrayList;
        byte[] byteArray2;
        byte[] byteArray3;
        AppMethodBeat.i(252127);
        i iVar = i.vfo;
        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        i.b(com.tencent.mm.plugin.recordvideo.d.c.eKW());
        if (captureVideoNormalModel != null) {
            Intent intent = new Intent();
            if (this.vHf) {
                intent.putExtras(getIntent());
            }
            if (!(bundle == null || (byteArray3 = bundle.getByteArray("MEDIA_EXTRA_MUSIC")) == null)) {
                intent.putExtra("MEDIA_EXTRA_MUSIC", byteArray3);
            }
            if (!(bundle == null || (byteArray2 = bundle.getByteArray("ORIGIN_MUSIC_INFO")) == null)) {
                intent.putExtra("ORIGIN_MUSIC_INFO", byteArray2);
            }
            com.tencent.mm.ac.d.a(intent, bundle, "ORIGIN_MUSIC_ID");
            com.tencent.mm.ac.d.a(intent, bundle, "ORIGIN_MUSIC_PATH");
            com.tencent.mm.ac.d.a(intent, bundle, "ORIGIN_BGM_URL");
            com.tencent.mm.ac.d.b(intent, bundle, "MEDIA_IS_MUTE");
            com.tencent.mm.ac.d.b(intent, bundle, "MUSIC_IS_MUTE");
            com.tencent.mm.ac.d.c(intent, bundle, "SOUND_TRACK_TYPE");
            if (!(bundle == null || (parcelableArrayList = bundle.getParcelableArrayList("KEY_POST_HALF_RECT_LIST")) == null)) {
                intent.putExtra("KEY_POST_HALF_RECT_LIST", parcelableArrayList);
            }
            ArrayList arrayList = (ArrayList) captureVideoNormalModel.eJJ().y("KEY_IMAGE_QUALITY_INT_ARRAY", new ArrayList());
            if (captureVideoNormalModel.eJK() == null || captureVideoNormalModel.eJK().size() <= 0) {
                if (!(bundle == null || (byteArray = bundle.getByteArray("video_composition")) == null)) {
                    intent.putExtra("video_composition", byteArray);
                }
                intent.putExtra("postType", 4);
                intent.putExtra("postMediaList", j.ac(captureVideoNormalModel.getVideoPath()));
                intent.putExtra("postTypeList", j.ac(4));
                intent.putExtra("postThumbList", j.ac(captureVideoNormalModel.aQn()));
                if (arrayList != null && arrayList.size() == 1) {
                    intent.putExtra("key_post_media_quality_list", arrayList);
                }
            } else {
                intent.putExtra("postType", 2);
                List<String> eJK = captureVideoNormalModel.eJK();
                p.g(eJK, "model.multiImagePath");
                ArrayList arrayList2 = new ArrayList();
                for (T t : eJK) {
                    p.g(t, LocaleUtil.ITALIAN);
                    arrayList2.add(t);
                }
                intent.putExtra("postMediaList", arrayList2);
                List<String> eJK2 = captureVideoNormalModel.eJK();
                p.g(eJK2, "model.multiImagePath");
                ArrayList arrayList3 = new ArrayList();
                Iterator<T> it = eJK2.iterator();
                while (it.hasNext()) {
                    it.next();
                    arrayList3.add(2);
                }
                intent.putExtra("postTypeList", arrayList3);
                intent.putExtra("postThumbList", j.ac(captureVideoNormalModel.aQn()));
                if (arrayList != null && arrayList.size() == captureVideoNormalModel.eJK().size()) {
                    intent.putExtra("key_post_media_quality_list", arrayList);
                }
                com.tencent.mm.ac.d.d(intent, bundle, "KEY_POST_HALF_IMAGE_LIST");
            }
            intent.putExtra(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, this.postId);
            intent.putExtra("edit_id", (String) captureVideoNormalModel.eJJ().y("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Intent intent2 = getIntent();
            p.g(intent2, "getIntent()");
            com.tencent.mm.plugin.finder.utils.a.b(intent, intent2);
            am(intent);
        }
        AppMethodBeat.o(252127);
    }

    private final void am(Intent intent) {
        AppMethodBeat.i(252128);
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(this, intent);
        AppMethodBeat.o(252128);
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final void a(RecordMediaReportInfo recordMediaReportInfo, Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
    public final boolean a(Context context, Bundle bundle, CaptureDataManager.a aVar) {
        return false;
    }

    public static final /* synthetic */ boolean a(FinderAlbumUI finderAlbumUI) {
        AppMethodBeat.i(252129);
        boolean z = false;
        if (System.currentTimeMillis() - finderAlbumUI.mRS < 1000) {
            z = true;
        }
        finderAlbumUI.mRS = System.currentTimeMillis();
        AppMethodBeat.o(252129);
        return z;
    }
}
