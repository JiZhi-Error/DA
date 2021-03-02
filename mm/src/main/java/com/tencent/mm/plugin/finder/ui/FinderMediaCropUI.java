package com.tencent.mm.plugin.finder.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.a.a;
import android.util.AttributeSet;
import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.stats.LoggingConstants;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.MediaSelectedData;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.picker.b.b;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.base.a.a;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.z;

@com.tencent.mm.ui.base.a(3)
@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 \u00012\u00020\u0001:\n\u0001\u0001\u0001\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010P\u001a\u00020\u001aH\u0002JH\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020J2\u0006\u0010Z\u001a\u00020J2\u0006\u0010[\u001a\u00020J2\u0006\u0010\\\u001a\u00020T2\u0006\u0010]\u001a\u00020JH\u0002J\u0006\u0010^\u001a\u00020\u001aJ\u0010\u0010_\u001a\u00020R2\u0006\u0010\\\u001a\u00020TH\u0002J\b\u0010`\u001a\u00020aH\u0002J\b\u0010b\u001a\u00020aH\u0002J\b\u0010c\u001a\u00020TH\u0014J\b\u0010d\u001a\u00020TH\u0014J\b\u0010e\u001a\u00020VH\u0002J\b\u0010f\u001a\u00020RH\u0014J\b\u0010g\u001a\u00020\u001aH\u0002J\b\u0010h\u001a\u00020\u001aH\u0016J\"\u0010i\u001a\u00020R2\u0006\u0010j\u001a\u00020T2\u0006\u0010k\u001a\u00020T2\b\u0010l\u001a\u0004\u0018\u00010mH\u0014J\b\u0010n\u001a\u00020RH\u0016J\u0012\u0010o\u001a\u00020R2\b\u0010p\u001a\u0004\u0018\u00010qH\u0016J\b\u0010r\u001a\u00020RH\u0014J\b\u0010s\u001a\u00020RH\u0002JT\u0010t\u001a\u00020R2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020;0v2<\u0010w\u001a8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020y0v¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(|\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(}\u0012\u0004\u0012\u00020R0xH\u0002J\b\u0010~\u001a\u00020RH\u0014J \u0010\u001a\u00020R2\u0006\u0010\\\u001a\u00020T2\u0007\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020;J\t\u0010\u0001\u001a\u00020RH\u0014J\u0007\u0010\u0001\u001a\u00020RJ\t\u0010\u0001\u001a\u00020RH\u0002J\u0014\u0010\u0001\u001a\u00020R2\t\b\u0002\u0010\u0001\u001a\u00020)H\u0002J\t\u0010\u0001\u001a\u00020RH\u0002R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR#\u0010\u000e\u001a\n \u0005*\u0004\u0018\u00010\u000f0\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0013\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\u0007R#\u0010\u0016\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0017\u0010\u0007R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020\u001a8FX\u0002¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b\u001f\u0010\u001cR\u000e\u0010!\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X.¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020)@BX\u000e¢\u0006\b\n\u0000\"\u0004\b+\u0010,R#\u0010-\u001a\n \u0005*\u0004\u0018\u00010.0.8FX\u0002¢\u0006\f\n\u0004\b1\u0010\t\u001a\u0004\b/\u00100R#\u00102\u001a\n \u0005*\u0004\u0018\u000103038FX\u0002¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b4\u00105R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R?\u00109\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010;0; \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010;0;\u0018\u00010:0:8FX\u0002¢\u0006\f\n\u0004\b>\u0010\t\u001a\u0004\b<\u0010=R#\u0010?\u001a\n \u0005*\u0004\u0018\u00010@0@8FX\u0002¢\u0006\f\n\u0004\bC\u0010\t\u001a\u0004\bA\u0010BR#\u0010D\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048FX\u0002¢\u0006\f\n\u0004\bF\u0010\t\u001a\u0004\bE\u0010\u0007R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010K\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "actionBarLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getActionBarLayout", "()Landroid/view/View;", "actionBarLayout$delegate", "Lkotlin/Lazy;", "calculateCallback", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "getCalculateCallback", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "cropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "getCropLayout", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "cropLayout$delegate", "editBtn", "getEditBtn", "editBtn$delegate", "footer", "getFooter", "footer$delegate", "hasDestroyVideoView", "", "getHasDestroyVideoView", "()Z", "setHasDestroyVideoView", "(Z)V", "isFromAppBrand", "isFromAppBrand$delegate", "isPreviewTvChange", "isSwitchNormalMode", "mediaExtraMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra;", "mediaTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "value", "", "previewId", "setPreviewId", "(J)V", "previewNumTv", "Landroid/widget/TextView;", "getPreviewNumTv", "()Landroid/widget/TextView;", "previewNumTv$delegate", "previewRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getPreviewRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "previewRecyclerView$delegate", "processDialogRunnable", "Ljava/lang/Runnable;", "selectPathList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getSelectPathList", "()Ljava/util/ArrayList;", "selectPathList$delegate", "switchVLogCheckbox", "Landroid/widget/CheckBox;", "getSwitchVLogCheckbox", "()Landroid/widget/CheckBox;", "switchVLogCheckbox$delegate", "switchVLogLayout", "getSwitchVLogLayout", "switchVLogLayout$delegate", "tipDialog", "Landroid/app/Dialog;", "vLogCropRect", "Landroid/graphics/Rect;", "vlogVideoPath", "getVlogVideoPath", "()Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "setVlogVideoPath", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)V", "canEnableMultiImage", "checkCropInfo", "", "type", "", "path", "", "matrix", "Landroid/graphics/Matrix;", "cropRect", "contentRect", "viewRect", "position", "initCropRect", "checkIsAllImage", "defaultPreview", "getDefaultVideoVisibilityRect", "Landroid/graphics/RectF;", "getDefaultVisibilityRect", "getForceOrientation", "getLayoutId", "getMenuText", "initView", "isInVLogMode", "noActionBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinish", "onGenerateMedia", "selectedMedias", "", "callback", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/finder/model/MediaSelectedData;", "Lkotlin/ParameterName;", "name", "generateList", "isSuccessfully", "onPause", "onPreviewItem", "view", "item", "onResume", "reloadVLogFake", "setWindowStyle", "showProcessDialog", "delay", "updateOptionMenu", "Companion", "FooterPreviewAdapter", "ItemTouchHelperCallback", "MediaExtra", "PreviewItemView", "plugin-finder_release"})
public final class FinderMediaCropUI extends MMFinderUI {
    public static final a vLv = new a((byte) 0);
    private HashMap _$_findViewCache;
    private Dialog tipDialog;
    private final Runnable vJC = new ab(this);
    private final LongSparseArray<d> vLd = new LongSparseArray<>();
    private final kotlin.f vLe = kotlin.g.ah(new ac(this));
    GalleryItem.MediaItem vLf;
    private final kotlin.f vLg = kotlin.g.ah(new g(this));
    private final kotlin.f vLh = kotlin.g.ah(new e(this));
    private final kotlin.f vLi = kotlin.g.ah(new aa(this));
    private final kotlin.f vLj = kotlin.g.ah(new k(this));
    private final kotlin.f vLk = kotlin.g.ah(new z(this));
    private final kotlin.f vLl = kotlin.g.ah(new j(this));
    private final kotlin.f vLm = kotlin.g.ah(new ae(this));
    private final kotlin.f vLn = kotlin.g.ah(new ad(this));
    final kotlin.f vLo = kotlin.g.ah(new s(this));
    boolean vLp;
    private final WxMediaCropLayout.c vLq = new f(this);
    private long vLr;
    private boolean vLs;
    private boolean vLt;
    private com.tencent.mm.plugin.gallery.picker.b.b vLu;

    static {
        AppMethodBeat.i(167382);
        AppMethodBeat.o(167382);
    }

    private TextView dzL() {
        AppMethodBeat.i(167388);
        TextView textView = (TextView) this.vLk.getValue();
        AppMethodBeat.o(167388);
        return textView;
    }

    private View dzM() {
        AppMethodBeat.i(252509);
        View view = (View) this.vLm.getValue();
        AppMethodBeat.o(252509);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252515);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252515);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252514);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252514);
        return view;
    }

    public final ArrayList<GalleryItem.MediaItem> dzG() {
        AppMethodBeat.i(167383);
        ArrayList<GalleryItem.MediaItem> arrayList = (ArrayList) this.vLe.getValue();
        AppMethodBeat.o(167383);
        return arrayList;
    }

    public final WxMediaCropLayout dzH() {
        AppMethodBeat.i(167384);
        WxMediaCropLayout wxMediaCropLayout = (WxMediaCropLayout) this.vLg.getValue();
        AppMethodBeat.o(167384);
        return wxMediaCropLayout;
    }

    public final View dzI() {
        AppMethodBeat.i(167385);
        View view = (View) this.vLh.getValue();
        AppMethodBeat.o(167385);
        return view;
    }

    public final RecyclerView dzJ() {
        AppMethodBeat.i(167386);
        RecyclerView recyclerView = (RecyclerView) this.vLi.getValue();
        AppMethodBeat.o(167386);
        return recyclerView;
    }

    public final View dzK() {
        AppMethodBeat.i(167387);
        View view = (View) this.vLj.getValue();
        AppMethodBeat.o(167387);
        return view;
    }

    public final CheckBox dzN() {
        AppMethodBeat.i(252510);
        CheckBox checkBox = (CheckBox) this.vLn.getValue();
        AppMethodBeat.o(252510);
        return checkBox;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        AppMethodBeat.at(this, z2);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "result", "", "Lcom/tencent/mm/plugin/finder/model/MediaSelectedData;", "isSuccessfully", "", "invoke"})
    public static final class x extends kotlin.g.b.q implements kotlin.g.a.m<List<? extends MediaSelectedData>, Boolean, kotlin.x> {
        final /* synthetic */ List vLL;
        final /* synthetic */ FinderMediaCropUI vLw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(FinderMediaCropUI finderMediaCropUI, List list) {
            super(2);
            this.vLw = finderMediaCropUI;
            this.vLL = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(List<? extends MediaSelectedData> list, Boolean bool) {
            LocalVideoCropInfoParcelable localVideoCropInfoParcelable;
            int i2;
            AppMethodBeat.i(167373);
            List<? extends MediaSelectedData> list2 = list;
            boolean booleanValue = bool.booleanValue();
            kotlin.g.b.p.h(list2, "result");
            if (!booleanValue) {
                this.vLw.finish();
                Log.w("Finder.MediaCropUI", "generate Media failure.result=".concat(String.valueOf(list2)));
            } else {
                Intent intent = new Intent();
                Object ks = kotlin.a.j.ks(this.vLL);
                kotlin.g.b.p.g(ks, "handleList.first()");
                int type = ((GalleryItem.MediaItem) ks).getType();
                int i3 = 0;
                for (GalleryItem.MediaItem mediaItem : this.vLL) {
                    kotlin.g.b.p.g(mediaItem, LocaleUtil.ITALIAN);
                    if (2 == mediaItem.getType()) {
                        i3++;
                    }
                    if (type != mediaItem.getType() || i3 > 1) {
                        i2 = 8;
                    } else {
                        i2 = type;
                    }
                    type = i2;
                }
                if (type == 1) {
                    type = 2;
                } else if (type == 2) {
                    type = 4;
                }
                intent.putExtra("postType", type);
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    String str = it.next().path;
                    kotlin.g.b.p.g(str, "it.path");
                    arrayList.add(str);
                }
                intent.putStringArrayListExtra("postMediaList", arrayList);
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(Integer.valueOf(it2.next().type == 2 ? 4 : 2));
                }
                intent.putIntegerArrayListExtra("postTypeList", arrayList2);
                ArrayList arrayList3 = new ArrayList();
                for (T t : list2) {
                    if (t.uOR != null) {
                        LocalVideoCropInfoParcelable localVideoCropInfoParcelable2 = new LocalVideoCropInfoParcelable();
                        localVideoCropInfoParcelable2.uOR = t.uOR;
                        localVideoCropInfoParcelable = localVideoCropInfoParcelable2;
                    } else {
                        localVideoCropInfoParcelable = null;
                    }
                    arrayList3.add(localVideoCropInfoParcelable);
                }
                intent.putParcelableArrayListExtra("postVideoCropList", arrayList3);
                ArrayList arrayList4 = new ArrayList();
                Iterator<T> it3 = list2.iterator();
                while (it3.hasNext()) {
                    String str2 = it3.next().thumbPath;
                    kotlin.g.b.p.g(str2, "it.thumbPath");
                    arrayList4.add(str2);
                }
                intent.putStringArrayListExtra("postThumbList", arrayList4);
                Dialog dialog = this.vLw.tipDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (((Boolean) this.vLw.vLo.getValue()).booleanValue()) {
                    ArrayList arrayList5 = new ArrayList();
                    Iterator<T> it4 = list2.iterator();
                    while (it4.hasNext()) {
                        String str3 = it4.next().thumbPath;
                        kotlin.g.b.p.g(str3, "it.thumbPath");
                        arrayList5.add(str3);
                    }
                    intent.putStringArrayListExtra("postThumbList", arrayList5);
                    this.vLw.setResult(-1, intent);
                    this.vLw.finish();
                } else {
                    com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                    Intent intent2 = this.vLw.getIntent();
                    kotlin.g.b.p.g(intent2, "getIntent()");
                    com.tencent.mm.plugin.finder.utils.a.b(intent, intent2);
                    intent.putExtra("select_video_path", this.vLw.getIntent().getStringExtra("select_video_path"));
                    intent.putExtra("select_video_duration", this.vLw.getIntent().getIntExtra("select_video_duration", 0));
                    com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(this.vLw, intent);
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(167373);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\b"}, hxF = {"<anonymous>", "", "isSuccessfully", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onGenerateMedia$1$1$1", "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$$special$$inlined$apply$lambda$1"})
    public static final class y extends kotlin.g.b.q implements kotlin.g.a.m<Boolean, b.f, kotlin.x> {
        final /* synthetic */ kotlin.g.a.m hVl;
        final /* synthetic */ z.d tQB;
        final /* synthetic */ GalleryItem.MediaItem vLM;
        final /* synthetic */ int vLN;
        final /* synthetic */ ArrayList vLO;
        final /* synthetic */ z.f vLP;
        final /* synthetic */ FinderMediaCropUI vLw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(GalleryItem.MediaItem mediaItem, int i2, FinderMediaCropUI finderMediaCropUI, ArrayList arrayList, z.f fVar, kotlin.g.a.m mVar, z.d dVar) {
            super(2);
            this.vLM = mediaItem;
            this.vLN = i2;
            this.vLw = finderMediaCropUI;
            this.vLO = arrayList;
            this.vLP = fVar;
            this.hVl = mVar;
            this.tQB = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(Boolean bool, b.f fVar) {
            AppMethodBeat.i(167376);
            boolean booleanValue = bool.booleanValue();
            b.f fVar2 = fVar;
            kotlin.g.b.p.h(fVar2, "result");
            Log.i("Finder.MediaCropUI", "[onGenerate] isSuccessfully=" + booleanValue + " result=" + fVar2);
            MediaSelectedData mediaSelectedData = new MediaSelectedData(this.vLM.getType());
            if (fVar2 instanceof com.tencent.mm.plugin.finder.video.e) {
                mediaSelectedData.path = fVar2.xli;
                if (this.vLw.vLf != null) {
                    GalleryItem.MediaItem mediaItem = this.vLw.vLf;
                    if (mediaItem == null) {
                        kotlin.g.b.p.hyc();
                    }
                    if (com.tencent.mm.vfs.s.YS(mediaItem.aQn())) {
                        mediaSelectedData.thumbPath = this.vLM.aQn();
                        Log.d("Finder.MediaCropUI", "onGenerateMedia useOutThumb, size: " + com.tencent.mm.vfs.s.boW(this.vLM.aQn()) + ", path: " + this.vLM.aQn());
                        mediaSelectedData.uOR = ((com.tencent.mm.plugin.finder.video.e) fVar2).wcO;
                    }
                }
                mediaSelectedData.thumbPath = fVar2.thumbPath;
                mediaSelectedData.uOR = ((com.tencent.mm.plugin.finder.video.e) fVar2).wcO;
            } else {
                mediaSelectedData.path = fVar2.xli;
                mediaSelectedData.thumbPath = fVar2.thumbPath;
            }
            this.vLO.set(fVar2.token, mediaSelectedData);
            if (fVar2.ret < 0) {
                final ArrayList arrayList = new ArrayList(1);
                arrayList.add(mediaSelectedData);
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.y.AnonymousClass1 */
                    final /* synthetic */ y vLQ;

                    {
                        this.vLQ = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(167375);
                        AppCompatActivity context = this.vLQ.vLw.getContext();
                        kotlin.g.b.p.g(context, "context");
                        String string = context.getResources().getString(R.string.d49);
                        AppCompatActivity context2 = this.vLQ.vLw.getContext();
                        kotlin.g.b.p.g(context2, "context");
                        com.tencent.mm.ui.base.h.a(this.vLQ.vLw.getContext(), string, context2.getResources().getString(R.string.zb), new DialogInterface.OnDismissListener(this) {
                            /* class com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.y.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 vLS;

                            {
                                this.vLS = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                AppMethodBeat.i(167374);
                                this.vLS.vLQ.hVl.invoke(arrayList, Boolean.FALSE);
                                AppMethodBeat.o(167374);
                            }
                        });
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(167375);
                        return xVar;
                    }
                });
                FinderMediaCropUI.i(this.vLw).destroy();
            } else {
                z.d dVar = this.tQB;
                dVar.SYE--;
                if (this.tQB.SYE == 0) {
                    MMHandlerThread.removeRunnable(this.vLw.vJC);
                    Dialog dialog = this.vLw.tipDialog;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    this.hVl.invoke(this.vLO, Boolean.TRUE);
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(167376);
            return xVar;
        }
    }

    public FinderMediaCropUI() {
        AppMethodBeat.i(167398);
        AppMethodBeat.o(167398);
    }

    public static final /* synthetic */ RectF e(FinderMediaCropUI finderMediaCropUI) {
        AppMethodBeat.i(167401);
        RectF dzt = finderMediaCropUI.dzt();
        AppMethodBeat.o(167401);
        return dzt;
    }

    public static final /* synthetic */ void g(FinderMediaCropUI finderMediaCropUI) {
        AppMethodBeat.i(167402);
        finderMediaCropUI.dzO();
        AppMethodBeat.o(167402);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.gallery.picker.b.b i(FinderMediaCropUI finderMediaCropUI) {
        AppMethodBeat.i(167403);
        com.tencent.mm.plugin.gallery.picker.b.b bVar = finderMediaCropUI.vLu;
        if (bVar == null) {
            kotlin.g.b.p.btv("mediaTailor");
        }
        AppMethodBeat.o(167403);
        return bVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$Companion;", "", "()V", "CLEAR_LIST", "", "FRONT_VLOG_VIDEO", "REQUEST_CODE_EDIT", "", "SELECT_PATH_LIST", "SELECT_VIDEO_DURATION", "SELECT_VIDEO_PATH", "TAG", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.agg;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$calculateCallback$1", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$OnCalculateVisibilityRect;", "calculate", "", "mediaWH", "", "maxCropRect", "Landroid/graphics/RectF;", "isAdaptSrc", "", "plugin-finder_release"})
    public static final class f implements WxMediaCropLayout.c {
        final /* synthetic */ FinderMediaCropUI vLw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(FinderMediaCropUI finderMediaCropUI) {
            this.vLw = finderMediaCropUI;
        }

        @Override // com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.c
        public final void a(int[] iArr, RectF rectF) {
            AppMethodBeat.i(167355);
            kotlin.g.b.p.h(iArr, "mediaWH");
            kotlin.g.b.p.h(rectF, "maxCropRect");
            RectF rectF2 = new RectF(rectF);
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            Context baseContext = this.vLw.getBaseContext();
            kotlin.g.b.p.g(baseContext, "baseContext");
            kotlin.r<Integer, Integer, Integer> g2 = com.tencent.mm.plugin.finder.utils.y.g(baseContext, iArr[0], iArr[1]);
            g2.second.intValue();
            float height = (rectF.height() - ((float) g2.SWY.intValue())) / 2.0f;
            rectF.top += height;
            rectF.bottom -= height;
            Log.i("Finder.MediaCropUI", "[calculate] NEW=" + rectF + " OLD=" + rectF2 + " isAdaptSrc=true");
            AppMethodBeat.o(167355);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final boolean noActionBar() {
        return true;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(167389);
        requestWindowFeature(1);
        super.onCreate(bundle);
        hideTitleView();
        setTheme(R.style.q6);
        setSelfNavigationBarVisible(8);
        getWindow().addFlags(2097280);
        getWindow().setFlags(201327616, 201327616);
        com.tencent.mm.plugin.mmsight.d.rb(true);
        getWindow().setFormat(-3);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("front_vlog_video");
        if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
            this.vLf = (GalleryItem.MediaItem) parcelableArrayListExtra.get(0);
        }
        dzI().post(new t(this));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = av.aD(getBaseContext());
        layoutParams.gravity = 80;
        View dzK = dzK();
        kotlin.g.b.p.g(dzK, "footer");
        dzK.setLayoutParams(layoutParams);
        dzK().post(new u(this));
        setActionbarColor(getResources().getColor(R.color.ac_));
        findViewById(R.id.ei).setOnClickListener(new v(this));
        findViewById(R.id.d8).setOnClickListener(new w(this));
        dzO();
        b.C1388b bVar = new b.C1388b();
        al alVar = al.waC;
        bVar.ayU(al.dEG());
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        bVar.maxHeight = com.tencent.mm.plugin.finder.storage.c.dqO();
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        bVar.maxWidth = com.tencent.mm.plugin.finder.storage.c.dqP();
        com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
        bVar.xkY = com.tencent.mm.plugin.finder.storage.c.dqQ();
        this.vLu = new com.tencent.mm.plugin.gallery.picker.b.b(bVar);
        com.tencent.mm.plugin.gallery.picker.b.b bVar2 = this.vLu;
        if (bVar2 == null) {
            kotlin.g.b.p.btv("mediaTailor");
        }
        bVar2.a(new com.tencent.mm.plugin.finder.video.l(bVar));
        com.tencent.mm.plugin.gallery.picker.b.b bVar3 = this.vLu;
        if (bVar3 == null) {
            kotlin.g.b.p.btv("mediaTailor");
        }
        com.tencent.mm.plugin.finder.video.j jVar = new com.tencent.mm.plugin.finder.video.j(bVar);
        kotlin.g.b.p.h(jVar, "<set-?>");
        bVar3.xkU = jVar;
        initView();
        AppMethodBeat.o(167389);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class t implements Runnable {
        final /* synthetic */ FinderMediaCropUI vLw;

        t(FinderMediaCropUI finderMediaCropUI) {
            this.vLw = finderMediaCropUI;
        }

        public final void run() {
            AppMethodBeat.i(167369);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            AppCompatActivity context = this.vLw.getContext();
            kotlin.g.b.p.g(context, "context");
            layoutParams.topMargin = ((int) context.getResources().getDimension(R.dimen.ct)) + au.D(this.vLw.getBaseContext(), (int) this.vLw.getResources().getDimension(R.dimen.cn));
            View dzI = this.vLw.dzI();
            kotlin.g.b.p.g(dzI, "actionBarLayout");
            dzI.setLayoutParams(layoutParams);
            this.vLw.dzI().requestLayout();
            AppMethodBeat.o(167369);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class u implements Runnable {
        final /* synthetic */ FinderMediaCropUI vLw;

        u(FinderMediaCropUI finderMediaCropUI) {
            this.vLw = finderMediaCropUI;
        }

        public final void run() {
            AppMethodBeat.i(167370);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = av.aD(this.vLw.getBaseContext());
            layoutParams.gravity = 80;
            View dzK = this.vLw.dzK();
            kotlin.g.b.p.g(dzK, "footer");
            dzK.setLayoutParams(layoutParams);
            AppMethodBeat.o(167370);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class v implements View.OnClickListener {
        final /* synthetic */ FinderMediaCropUI vLw;

        v(FinderMediaCropUI finderMediaCropUI) {
            this.vLw = finderMediaCropUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(167371);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.vLw.setResult(0);
            this.vLw.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(167371);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class w implements View.OnClickListener {
        final /* synthetic */ FinderMediaCropUI vLw;

        w(FinderMediaCropUI finderMediaCropUI) {
            this.vLw = finderMediaCropUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(167372);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderMediaCropUI.c(this.vLw);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(167372);
        }
    }

    private final void dzO() {
        String string;
        T t2;
        boolean z2;
        AppMethodBeat.i(167390);
        TextView textView = (TextView) findViewById(R.id.d8);
        ArrayList<GalleryItem.MediaItem> dzG = dzG();
        kotlin.g.b.p.g(dzG, "selectPathList");
        ArrayList arrayList = new ArrayList();
        for (T t3 : dzG) {
            if (this.vLd.get(t3.xiZ).vLG != -1) {
                arrayList.add(t3);
            }
        }
        int size = arrayList.size();
        if (size > 0) {
            StringBuilder sb = new StringBuilder();
            AppCompatActivity context = getContext();
            kotlin.g.b.p.g(context, "context");
            string = sb.append(context.getResources().getString(R.string.vl)).append('(').append(size).append(')').toString();
        } else {
            AppCompatActivity context2 = getContext();
            kotlin.g.b.p.g(context2, "context");
            string = context2.getResources().getString(R.string.vl);
            kotlin.g.b.p.g(string, "context.resources.getString(R.string.app_finish)");
        }
        textView.setText(string);
        ArrayList<GalleryItem.MediaItem> dzG2 = dzG();
        kotlin.g.b.p.g(dzG2, "selectPathList");
        Iterator<T> it = dzG2.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (this.vLd.get(t2.xiZ).vLG != -1) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                break;
            }
        }
        textView.setEnabled(t2 != null);
        AppMethodBeat.o(167390);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        boolean z2;
        AppMethodBeat.i(167391);
        super.initView();
        dzH().setShowBorder(true);
        dzH().post(new l(this));
        dzL().setOnClickListener(new m(this));
        ((View) this.vLl.getValue()).setOnClickListener(new n(this));
        dzJ().setHasFixedSize(true);
        getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.setOrientation(0);
        RecyclerView dzJ = dzJ();
        kotlin.g.b.p.g(dzJ, "previewRecyclerView");
        dzJ.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setItemPrefetchEnabled(true);
        RecyclerView dzJ2 = dzJ();
        kotlin.g.b.p.g(dzJ2, "previewRecyclerView");
        dzJ2.setItemAnimator(new android.support.v7.widget.v());
        dzJ().b(new o(this));
        b bVar = new b();
        new android.support.v7.widget.a.a(new c(this, bVar)).f(dzJ());
        RecyclerView dzJ3 = dzJ();
        kotlin.g.b.p.g(dzJ3, "previewRecyclerView");
        dzJ3.setAdapter(bVar);
        bVar.OXb = new p(this);
        ArrayList<GalleryItem.MediaItem> dzG = dzG();
        kotlin.g.b.p.g(dzG, "selectPathList");
        Iterator<T> it = dzG.iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = true;
                break;
            }
            T next = it.next();
            kotlin.g.b.p.g(next, LocaleUtil.ITALIAN);
            if (next.getType() == 2) {
                z2 = false;
                break;
            }
        }
        if (z2) {
            this.vLs = true;
        }
        CheckBox dzN = dzN();
        kotlin.g.b.p.g(dzN, "switchVLogCheckbox");
        dzN.setChecked(this.vLs);
        if (dzP()) {
            View dzM = dzM();
            kotlin.g.b.p.g(dzM, "switchVLogLayout");
            dzM.setVisibility(0);
            dzN().setOnClickListener(new q(this, bVar));
        } else {
            View dzM2 = dzM();
            kotlin.g.b.p.g(dzM2, "switchVLogLayout");
            dzM2.setVisibility(8);
        }
        StringBuilder sb = new StringBuilder("isInVLogMode: false, final check, IS_VLOG_BACKGROUND_MUX: ");
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        Log.i("Finder.MediaCropUI", sb.append(com.tencent.mm.plugin.finder.storage.c.drJ()).toString());
        bVar.setItems(dzG());
        if (this.vLf == null || !dzP()) {
            dzJ().post(new h(this));
            dzJ().postDelayed(new i(this), 500);
            AppMethodBeat.o(167391);
            return;
        }
        dzJ().postDelayed(new r(this, bVar), 500);
        AppMethodBeat.o(167391);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class l implements Runnable {
        final /* synthetic */ FinderMediaCropUI vLw;

        l(FinderMediaCropUI finderMediaCropUI) {
            this.vLw = finderMediaCropUI;
        }

        public final void run() {
            AppMethodBeat.i(167361);
            RectF e2 = FinderMediaCropUI.e(this.vLw);
            WxMediaCropLayout.a(this.vLw.dzH(), e2.width() * 0.5625f, e2.height(), e2);
            AppMethodBeat.o(167361);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class m implements View.OnClickListener {
        final /* synthetic */ FinderMediaCropUI vLw;

        m(FinderMediaCropUI finderMediaCropUI) {
            this.vLw = finderMediaCropUI;
        }

        public final void onClick(View view) {
            int i2;
            int i3;
            View view2;
            AppMethodBeat.i(167362);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ArrayList<GalleryItem.MediaItem> dzG = this.vLw.dzG();
            kotlin.g.b.p.g(dzG, "selectPathList");
            Iterator<GalleryItem.MediaItem> it = dzG.iterator();
            int i4 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (it.next().xiZ == this.vLw.vLr) {
                    i2 = i4;
                    break;
                }
                i4++;
            }
            if (i2 < 0) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(167362);
                return;
            }
            int size = this.vLw.dzG().size();
            GalleryItem.MediaItem mediaItem = this.vLw.dzG().get(i2);
            this.vLw.vLt = true;
            if (size <= 1) {
                Intent intent = new Intent();
                intent.putExtra("clear_list", true);
                this.vLw.setResult(-1, intent);
                this.vLw.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(167362);
                return;
            }
            if (i2 == 0) {
                i3 = 1;
            } else {
                i3 = i2 - 1;
            }
            RecyclerView.v cg = this.vLw.dzJ().cg(i3);
            this.vLw.dzG().remove(mediaItem);
            RecyclerView dzJ = this.vLw.dzJ();
            kotlin.g.b.p.g(dzJ, "previewRecyclerView");
            RecyclerView.a adapter = dzJ.getAdapter();
            if (adapter != null) {
                adapter.ck(i2);
            }
            if (!(cg == null || (view2 = cg.aus) == null)) {
                view2.callOnClick();
            }
            FinderMediaCropUI.g(this.vLw);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(167362);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class n implements View.OnClickListener {
        final /* synthetic */ FinderMediaCropUI vLw;

        n(FinderMediaCropUI finderMediaCropUI) {
            this.vLw = finderMediaCropUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(167363);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ArrayList<GalleryItem.MediaItem> dzG = this.vLw.dzG();
            kotlin.g.b.p.g(dzG, "selectPathList");
            Iterator<GalleryItem.MediaItem> it = dzG.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (it.next().xiZ == this.vLw.vLr) {
                    break;
                }
                i2++;
            }
            if (i2 < 0) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(167363);
                return;
            }
            RecyclerView dzJ = this.vLw.dzJ();
            kotlin.g.b.p.g(dzJ, "previewRecyclerView");
            RecyclerView.a adapter = dzJ.getAdapter();
            if (!(adapter instanceof b)) {
                adapter = null;
            }
            b bVar2 = (b) adapter;
            if (bVar2 != null) {
                GalleryItem.MediaItem mediaItem = (GalleryItem.MediaItem) bVar2.getItemAtPosition(i2);
                String str = mediaItem.xiX;
                if (str == null || str.length() == 0) {
                    mediaItem.xiX = mediaItem.xiW;
                }
                kotlin.g.b.p.g(mediaItem, "item");
                if (mediaItem.getType() == 2) {
                    this.vLw.vLp = true;
                    WxMediaCropLayout dzH = this.vLw.dzH();
                    Log.i("WxMediaCropLayout", "onUIRelease");
                    if (dzH.ofW != null) {
                        CommonVideoView commonVideoView = dzH.ofW;
                        if (commonVideoView != null) {
                            commonVideoView.onUIDestroy();
                        }
                        dzH.ofW = null;
                    }
                    if (dzH.wgF != null) {
                        com.tencent.mm.plugin.recordvideo.plugin.a.b bVar3 = dzH.wgF;
                        if (bVar3 != null) {
                            bVar3.release();
                        }
                        dzH.wgF = null;
                    }
                    WxMediaCropLayout.b currentCropInfo = this.vLw.dzH().getCurrentCropInfo();
                    Rect rect = currentCropInfo.iiw;
                    float height = ((((float) currentCropInfo.viewRect.height()) * 1.0f) / ((float) currentCropInfo.viewRect.width())) * ((float) currentCropInfo.iiw.width());
                    Rect rect2 = new Rect(currentCropInfo.iiw.left, (int) (((float) currentCropInfo.iiw.centerY()) - (height / 2.0f)), currentCropInfo.iiw.right, (int) ((height / 2.0f) + ((float) currentCropInfo.iiw.centerY())));
                    WxMediaCropLayout dzH2 = this.vLw.dzH();
                    kotlin.g.b.p.g(dzH2, "cropLayout");
                    int height2 = (dzH2.getHeight() / 2) - currentCropInfo.xne.centerY();
                    rect2.top += height2;
                    rect2.bottom += height2;
                    float width = (((float) currentCropInfo.rwL.width()) * 1.0f) / ((float) currentCropInfo.iiw.width());
                    Matrix matrix = new Matrix();
                    matrix.setScale(width, width);
                    matrix.postTranslate(((float) currentCropInfo.rwL.left) - ((float) rect2.left), ((float) currentCropInfo.rwL.top) - ((float) rect2.top));
                    float[] fArr = {((float) currentCropInfo.rwL.centerX()) - ((float) currentCropInfo.iiw.centerX()), (((float) currentCropInfo.rwL.centerY()) - ((float) currentCropInfo.iiw.centerY())) - ((float) height2)};
                    Point az = ao.az(this.vLw.getContext());
                    com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                    Context baseContext = this.vLw.getBaseContext();
                    kotlin.g.b.p.g(baseContext, "baseContext");
                    com.tencent.mm.plugin.finder.utils.y.g(baseContext, az.x, az.y);
                    new Point(az.x, az.y);
                    com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                    AppCompatActivity context = this.vLw.getContext();
                    kotlin.g.b.p.g(context, "context");
                    String str2 = mediaItem.xiX;
                    kotlin.g.b.p.g(str2, "item.mRawEditPath");
                    com.tencent.mm.plugin.finder.utils.a.a(context, str2, mediaItem.getType(), matrix, rect, fArr);
                } else {
                    WxMediaCropLayout.b currentCropInfo2 = this.vLw.dzH().getCurrentCropInfo();
                    Rect rect3 = currentCropInfo2.iiw;
                    Matrix matrix2 = new Matrix();
                    float[] fArr2 = new float[9];
                    currentCropInfo2.gT.getValues(fArr2);
                    float f2 = fArr2[0];
                    float f3 = fArr2[3];
                    float sqrt = (float) Math.sqrt((((double) f3) * ((double) f3)) + ((double) (f2 * f2)));
                    matrix2.setScale(sqrt, sqrt);
                    matrix2.postTranslate((float) currentCropInfo2.rwL.left, (float) currentCropInfo2.rwL.top);
                    com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    AppCompatActivity context2 = this.vLw.getContext();
                    kotlin.g.b.p.g(context2, "context");
                    String str3 = mediaItem.xiX;
                    kotlin.g.b.p.g(str3, "item.mRawEditPath");
                    com.tencent.mm.plugin.finder.utils.a.a(context2, str3, mediaItem.getType(), matrix2, rect3);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(167363);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$4", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "offset", "", "getOffset", "()F", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
    public static final class o extends RecyclerView.h {
        private final float offset;
        final /* synthetic */ FinderMediaCropUI vLw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        o(FinderMediaCropUI finderMediaCropUI) {
            this.vLw = finderMediaCropUI;
            AppMethodBeat.i(167365);
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            this.offset = context.getResources().getDimension(R.dimen.cb);
            AppMethodBeat.o(167365);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(167364);
            kotlin.g.b.p.h(rect, "outRect");
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(recyclerView, "parent");
            kotlin.g.b.p.h(sVar, "state");
            super.a(rect, view, recyclerView, sVar);
            RecyclerView.v bi = recyclerView.bi(view);
            kotlin.g.b.p.g(bi, "parent.getChildViewHolder(view)");
            int lR = bi.lR();
            rect.left = (int) this.offset;
            if (lR + 1 == this.vLw.dzG().size()) {
                rect.right = (int) this.offset;
            }
            AppMethodBeat.o(167364);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$5", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$OnItemClickListeners;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "item", "onItemLongClick", "", "plugin-finder_release"})
    public static final class p implements a.AbstractC2080a<GalleryItem.MediaItem> {
        final /* synthetic */ FinderMediaCropUI vLw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        p(FinderMediaCropUI finderMediaCropUI) {
            this.vLw = finderMediaCropUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, java.lang.Object] */
        @Override // com.tencent.mm.ui.base.a.a.AbstractC2080a
        public final /* synthetic */ void a(int i2, View view, GalleryItem.MediaItem mediaItem) {
            AppMethodBeat.i(167366);
            GalleryItem.MediaItem mediaItem2 = mediaItem;
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(mediaItem2, "item");
            this.vLw.a(i2, view, mediaItem2);
            AppMethodBeat.o(167366);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
        @Override // com.tencent.mm.ui.base.a.a.AbstractC2080a
        public final /* synthetic */ boolean a(View view, GalleryItem.MediaItem mediaItem) {
            AppMethodBeat.i(167367);
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(mediaItem, "item");
            AppMethodBeat.o(167367);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class q implements View.OnClickListener {
        final /* synthetic */ b vLK;
        final /* synthetic */ FinderMediaCropUI vLw;

        q(FinderMediaCropUI finderMediaCropUI, b bVar) {
            this.vLw = finderMediaCropUI;
            this.vLK = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252505);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderMediaCropUI finderMediaCropUI = this.vLw;
            CheckBox dzN = this.vLw.dzN();
            kotlin.g.b.p.g(dzN, "switchVLogCheckbox");
            finderMediaCropUI.vLs = dzN.isChecked();
            if (this.vLw.vLs) {
                this.vLK.setItems(this.vLw.dzG());
                FinderMediaCropUI finderMediaCropUI2 = this.vLw;
                RecyclerView.v cg = this.vLw.dzJ().cg(0);
                View view2 = cg != null ? cg.aus : null;
                if (view2 == null) {
                    kotlin.g.b.p.hyc();
                }
                kotlin.g.b.p.g(view2, "previewRecyclerView.find…utPosition(0)?.itemView!!");
                GalleryItem.MediaItem mediaItem = this.vLw.dzG().get(0);
                kotlin.g.b.p.g(mediaItem, "selectPathList[0]");
                finderMediaCropUI2.a(0, view2, mediaItem);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$initView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252505);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class r implements Runnable {
        final /* synthetic */ b vLK;
        final /* synthetic */ FinderMediaCropUI vLw;

        r(FinderMediaCropUI finderMediaCropUI, b bVar) {
            this.vLw = finderMediaCropUI;
            this.vLK = bVar;
        }

        public final void run() {
            AppMethodBeat.i(252506);
            this.vLK.setItems(this.vLw.dzG().subList(0, 1));
            this.vLw.vLd.put(0, new d());
            FinderMediaCropUI finderMediaCropUI = this.vLw;
            RecyclerView.v cg = this.vLw.dzJ().cg(0);
            View view = cg != null ? cg.aus : null;
            if (view == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(view, "previewRecyclerView.find…utPosition(0)?.itemView!!");
            GalleryItem.MediaItem mediaItem = this.vLw.vLf;
            if (mediaItem == null) {
                kotlin.g.b.p.hyc();
            }
            finderMediaCropUI.a(0, view, mediaItem);
            AppMethodBeat.o(252506);
        }
    }

    public final void a(int i2, View view, GalleryItem.MediaItem mediaItem) {
        int i3;
        WxMediaCropLayout.b bVar;
        AppMethodBeat.i(252511);
        kotlin.g.b.p.h(view, "view");
        kotlin.g.b.p.h(mediaItem, "item");
        if (view.getTag() != null) {
            Log.w("Finder.MediaCropUI", "this view is Animating");
            AppMethodBeat.o(252511);
            return;
        }
        RecyclerView.v m2 = dzJ().m(this.vLr);
        if (m2 != null) {
            View view2 = m2.aus;
            kotlin.g.b.p.g(view2, "preHolder.itemView");
            view2.setFocusable(false);
        }
        this.vLr = mediaItem.xiZ;
        ArrayList<GalleryItem.MediaItem> dzG = dzG();
        kotlin.g.b.p.g(dzG, "selectPathList");
        int i4 = 0;
        Iterator<GalleryItem.MediaItem> it = dzG.iterator();
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            if (it.next().xiZ == this.vLr) {
                break;
            }
            i4++;
        }
        if (i4 >= 0) {
            dzG().get(i4);
            if (this.vLd.get(this.vLr).vLG == -1) {
                TextView dzL = dzL();
                kotlin.g.b.p.g(dzL, "previewNumTv");
                dzL.setText("");
                TextView dzL2 = dzL();
                kotlin.g.b.p.g(dzL2, "previewNumTv");
                AppCompatActivity context = getContext();
                kotlin.g.b.p.g(context, "context");
                dzL2.setBackground(context.getResources().getDrawable(R.drawable.anf));
            } else {
                TextView dzL3 = dzL();
                kotlin.g.b.p.g(dzL3, "previewNumTv");
                dzL3.setText(String.valueOf(i4 + 1));
                TextView dzL4 = dzL();
                kotlin.g.b.p.g(dzL4, "previewNumTv");
                AppCompatActivity context2 = getContext();
                kotlin.g.b.p.g(context2, "context");
                dzL4.setBackground(context2.getResources().getDrawable(R.drawable.ano));
            }
        }
        view.setFocusable(true);
        RecyclerView dzJ = dzJ();
        kotlin.g.b.p.g(dzJ, "previewRecyclerView");
        RecyclerView.a adapter = dzJ.getAdapter();
        if (adapter != null) {
            adapter.b(i2, new Object());
        }
        if (i2 == 0) {
            dzH().setLockCropMediaId(mediaItem.xiZ);
        }
        long j2 = mediaItem.xiZ;
        if (mediaItem.getType() == 2) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        d dVar = this.vLd.get(this.vLr);
        WxMediaCropLayout dzH = dzH();
        String dRh = mediaItem.dRh();
        kotlin.g.b.p.g(dRh, "item.originalPath");
        WxMediaCropLayout.c cVar = this.vLq;
        kotlin.g.b.p.h(dRh, "mediaPath");
        Log.i("WxMediaCropLayout", "onPreview type: ".concat(String.valueOf(i3)));
        boolean z2 = false;
        if (dzH.pXO != i3) {
            z2 = true;
        }
        dzH.pXO = i3;
        if (i3 == 2) {
            bVar = WxMediaCropLayout.a(dzH, j2, dRh, z2, cVar, (kotlin.g.a.q) null, 16);
        } else if (i3 == 1) {
            bVar = WxMediaCropLayout.a(dzH, j2, dRh, z2, cVar);
        } else {
            bVar = new WxMediaCropLayout.b(0, "");
        }
        dVar.a(bVar);
        AppMethodBeat.o(252511);
    }

    private final boolean dzP() {
        AppMethodBeat.i(252512);
        ArrayList<GalleryItem.MediaItem> dzG = dzG();
        Integer valueOf = dzG != null ? Integer.valueOf(dzG.size()) : null;
        if (valueOf == null) {
            kotlin.g.b.p.hyc();
        }
        if (valueOf.intValue() <= 1) {
            AppMethodBeat.o(252512);
            return false;
        }
        ArrayList<GalleryItem.MediaItem> dzG2 = dzG();
        kotlin.g.b.p.g(dzG2, "selectPathList");
        for (T t2 : dzG2) {
            kotlin.g.b.p.g(t2, LocaleUtil.ITALIAN);
            if (t2.getType() == 2) {
                AppMethodBeat.o(252512);
                return false;
            }
        }
        AppMethodBeat.o(252512);
        return true;
    }

    private final RectF dzt() {
        AppMethodBeat.i(167392);
        AppCompatActivity context = getContext();
        kotlin.g.b.p.g(context, "context");
        float dimension = context.getResources().getDimension(R.dimen.b7);
        AppCompatActivity context2 = getContext();
        kotlin.g.b.p.g(context2, "context");
        float dimension2 = context2.getResources().getDimension(R.dimen.cn);
        WxMediaCropLayout dzH = dzH();
        kotlin.g.b.p.g(dzH, "cropLayout");
        float width = (((float) dzH.getWidth()) * 3.5f) / 3.0f;
        WxMediaCropLayout dzH2 = dzH();
        kotlin.g.b.p.g(dzH2, "cropLayout");
        int height = dzH2.getHeight();
        View dzK = dzK();
        kotlin.g.b.p.g(dzK, "footer");
        float height2 = dimension + dimension2 + (((((((float) (height - dzK.getHeight())) - dimension) - dimension2) - ((float) av.aD(getBaseContext()))) - width) / 2.0f);
        WxMediaCropLayout dzH3 = dzH();
        kotlin.g.b.p.g(dzH3, "cropLayout");
        WxMediaCropLayout dzH4 = dzH();
        kotlin.g.b.p.g(dzH4, "cropLayout");
        RectF rectF = new RectF((float) dzH3.getLeft(), height2, (float) dzH4.getRight(), width + height2);
        AppMethodBeat.o(167392);
        return rectF;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        com.tencent.mm.plugin.recordvideo.plugin.a.b bVar;
        CommonVideoView commonVideoView;
        AppMethodBeat.i(167393);
        super.onResume();
        if (this.vLp) {
            RecyclerView dzJ = dzJ();
            kotlin.g.b.p.g(dzJ, "previewRecyclerView");
            RecyclerView.a adapter = dzJ.getAdapter();
            if (!(adapter instanceof b)) {
                adapter = null;
            }
            b bVar2 = (b) adapter;
            ArrayList<GalleryItem.MediaItem> dzG = dzG();
            kotlin.g.b.p.g(dzG, "selectPathList");
            Iterator<GalleryItem.MediaItem> it = dzG.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (it.next().xiZ == this.vLr) {
                    break;
                }
                i2++;
            }
            if (i2 < 0) {
                AppMethodBeat.o(167393);
                return;
            }
            if (bVar2 != null) {
                GalleryItem.MediaItem mediaItem = (GalleryItem.MediaItem) bVar2.getItemAtPosition(i2);
                WxMediaCropLayout dzH = dzH();
                long j2 = mediaItem.xiZ;
                kotlin.g.b.p.g(mediaItem, "item");
                String dRh = mediaItem.dRh();
                kotlin.g.b.p.g(dRh, "item.originalPath");
                dzH.a(j2, dRh, true, this.vLq, true);
            }
            this.vLp = false;
            AppMethodBeat.o(167393);
            return;
        }
        WxMediaCropLayout dzH2 = dzH();
        Log.i("WxMediaCropLayout", "onUIResume");
        if (!(dzH2.ofW == null || (commonVideoView = dzH2.ofW) == null)) {
            commonVideoView.onUIResume();
        }
        if (dzH2.wgF == null || (bVar = dzH2.wgF) == null) {
            AppMethodBeat.o(167393);
            return;
        }
        bVar.eKR();
        AppMethodBeat.o(167393);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(167394);
        super.onPause();
        if (!this.vLp) {
            dzH().onUIPause();
        }
        AppMethodBeat.o(167394);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(252513);
        super.onDestroy();
        AppMethodBeat.o(252513);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ int gUj = 0;
        final /* synthetic */ FinderMediaCropUI vLw;

        h(FinderMediaCropUI finderMediaCropUI) {
            this.vLw = finderMediaCropUI;
        }

        public final void run() {
            AppMethodBeat.i(167357);
            RecyclerView.v ch = this.vLw.dzJ().ch(this.gUj);
            if (ch != null) {
                ch.aus.callOnClick();
                AppMethodBeat.o(167357);
                return;
            }
            AppMethodBeat.o(167357);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class i implements Runnable {
        final /* synthetic */ int gUj = 0;
        final /* synthetic */ FinderMediaCropUI vLw;

        i(FinderMediaCropUI finderMediaCropUI) {
            this.vLw = finderMediaCropUI;
        }

        public final void run() {
            AppMethodBeat.i(167358);
            RecyclerView.v ch = this.vLw.dzJ().ch(this.gUj);
            if (ch != null) {
                ch.aus.callOnClick();
                AppMethodBeat.o(167358);
                return;
            }
            AppMethodBeat.o(167358);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(167395);
        super.onBackPressed();
        setResult(0);
        finish();
        AppMethodBeat.o(167395);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0014¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$FooterPreviewAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "(Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;)V", "getItemId", "", "position", "", "onBindViewHolder", "", "viewWrapper", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "i", "holder", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
    public final class b extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, PreviewItemView> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            AppMethodBeat.i(167331);
            au(true);
            AppMethodBeat.o(167331);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // com.tencent.mm.ui.base.a.a, android.support.v7.widget.RecyclerView.a
        public final /* bridge */ /* synthetic */ void a(com.tencent.mm.ui.base.a.b bVar, int i2) {
            AppMethodBeat.i(167328);
            a(bVar, i2);
            AppMethodBeat.o(167328);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
        @Override // com.tencent.mm.ui.base.a.a, android.support.v7.widget.RecyclerView.a
        public final /* bridge */ /* synthetic */ void a(com.tencent.mm.ui.base.a.b bVar, int i2, List list) {
            AppMethodBeat.i(167329);
            a(bVar, i2, (List<Object>) list);
            AppMethodBeat.o(167329);
        }

        /* Return type fixed from 'android.view.View' to match base method */
        @Override // com.tencent.mm.ui.base.a.a
        public final /* synthetic */ PreviewItemView l(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(167326);
            kotlin.g.b.p.h(viewGroup, "parent");
            Context context = viewGroup.getContext();
            kotlin.g.b.p.g(context, "parent.context");
            PreviewItemView previewItemView = new PreviewItemView(context);
            AppMethodBeat.o(167326);
            return previewItemView;
        }

        @Override // com.tencent.mm.ui.base.a.a
        public final void a(com.tencent.mm.ui.base.a.b bVar, int i2) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(167327);
            kotlin.g.b.p.h(bVar, "viewWrapper");
            super.a(bVar, i2);
            PreviewItemView previewItemView = (PreviewItemView) bVar.getView();
            GalleryItem.MediaItem mediaItem = (GalleryItem.MediaItem) getItemAtPosition(i2);
            com.tencent.mm.plugin.gallery.picker.c.f fVar = com.tencent.mm.plugin.gallery.picker.c.f.xlA;
            com.tencent.mm.loader.d<GalleryItem.MediaItem> dRD = com.tencent.mm.plugin.gallery.picker.c.f.dRD();
            kotlin.g.b.p.g(mediaItem, "media");
            dRD.bP(mediaItem).a(previewItemView.getImageView(), true);
            kotlin.g.b.p.g(previewItemView, "itemView");
            if (((d) FinderMediaCropUI.this.vLd.get(mediaItem.xiZ)).vLG != -1) {
                z = true;
            } else {
                z = false;
            }
            previewItemView.setSelected(z);
            if (mediaItem.xiZ != FinderMediaCropUI.this.vLr) {
                z2 = false;
            }
            previewItemView.setFocusable(z2);
            AppMethodBeat.o(167327);
        }

        @Override // com.tencent.mm.ui.base.a.a
        public final void a(com.tencent.mm.ui.base.a.b bVar, int i2, List<Object> list) {
            AppMethodBeat.i(252504);
            kotlin.g.b.p.h(bVar, "holder");
            kotlin.g.b.p.h(list, "payloads");
            if (list.isEmpty()) {
                a(bVar, i2);
            }
            AppMethodBeat.o(252504);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final long getItemId(int i2) {
            AppMethodBeat.i(167330);
            long j2 = ((GalleryItem.MediaItem) getItemAtPosition(i2)).xiZ;
            AppMethodBeat.o(167330);
            return j2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J@\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u001aH\u0016J \u0010#\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0015H\u0016J\u001a\u0010%\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010!\u001a\u00020\bH\u0016J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\bH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback;", "Landroid/support/v7/widget/helper/ItemTouchHelper$Callback;", "adapter", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "(Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI;Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;)V", "lastVisiblePos", "", "getLastVisiblePos", "()I", "setLastVisiblePos", "(I)V", "mBeginDragPos", "mCurPositionInBar", "mEndDragPos", "clearView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getMoveThreshold", "", "getMovementFlags", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSelectedChanged", "onSwiped", TencentLocation.EXTRA_DIRECTION, "plugin-finder_release"})
    public final class c extends a.AbstractC0053a {
        int eeE = -1;
        private final com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, PreviewItemView> vLA;
        final /* synthetic */ FinderMediaCropUI vLw;
        private int vLx = -1;
        private int vLy = -1;
        private int vLz;

        public c(FinderMediaCropUI finderMediaCropUI, com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, PreviewItemView> aVar) {
            kotlin.g.b.p.h(aVar, "adapter");
            this.vLw = finderMediaCropUI;
            AppMethodBeat.i(167345);
            this.vLA = aVar;
            AppMethodBeat.o(167345);
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final boolean a(RecyclerView recyclerView, RecyclerView.v vVar, RecyclerView.v vVar2) {
            AppMethodBeat.i(167338);
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            kotlin.g.b.p.h(vVar, "viewHolder");
            kotlin.g.b.p.h(vVar2, "target");
            int lR = vVar.lR();
            int lR2 = vVar2.lR();
            Log.d("Finder.MediaCropUI", "[onMove] from=" + lR + " to=" + lR2);
            com.tencent.mm.plugin.gallery.a.d.swap(this.vLw.dzG(), lR, lR2);
            this.vLA.ar(lR, lR2);
            this.vLy = lR2;
            AppMethodBeat.o(167338);
            return true;
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final void f(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(167339);
            super.f(vVar, i2);
            if (vVar != null) {
                View view = vVar.aus;
                kotlin.g.b.p.g(view, "viewHolder.itemView");
                Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.cs);
                loadAnimation.setAnimationListener(new b(this, vVar, i2));
                vVar.aus.startAnimation(loadAnimation);
            }
            AppMethodBeat.o(167339);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback$onSelectedChanged$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
        public static final class b implements Animation.AnimationListener {
            final /* synthetic */ c vLB;
            final /* synthetic */ RecyclerView.v vLD;
            final /* synthetic */ int vLE;

            b(c cVar, RecyclerView.v vVar, int i2) {
                this.vLB = cVar;
                this.vLD = vVar;
                this.vLE = i2;
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(167335);
                kotlin.g.b.p.h(animation, "animation");
                View view = this.vLD.aus;
                kotlin.g.b.p.g(view, "viewHolder.itemView");
                view.setTag(new Object());
                if (this.vLE == 2) {
                    this.vLB.vLy = this.vLD.lR();
                    this.vLB.vLx = this.vLB.vLy;
                    this.vLB.eeE = this.vLB.vLz;
                }
                AppMethodBeat.o(167335);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(167336);
                kotlin.g.b.p.h(animation, "animation");
                View view = this.vLD.aus;
                kotlin.g.b.p.g(view, "viewHolder.itemView");
                view.setTag(null);
                AppMethodBeat.o(167336);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.i(167337);
                kotlin.g.b.p.h(animation, "animation");
                AppMethodBeat.o(167337);
            }
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final void d(RecyclerView recyclerView, RecyclerView.v vVar) {
            AppMethodBeat.i(167340);
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            kotlin.g.b.p.h(vVar, "viewHolder");
            super.d(recyclerView, vVar);
            Animation loadAnimation = AnimationUtils.loadAnimation(recyclerView.getContext(), R.anim.cr);
            loadAnimation.setAnimationListener(new a(this, vVar));
            vVar.aus.startAnimation(loadAnimation);
            AppMethodBeat.o(167340);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$ItemTouchHelperCallback$clearView$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
        public static final class a implements Animation.AnimationListener {
            final /* synthetic */ c vLB;
            final /* synthetic */ RecyclerView.v vLC;

            a(c cVar, RecyclerView.v vVar) {
                this.vLB = cVar;
                this.vLC = vVar;
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(167332);
                kotlin.g.b.p.h(animation, "animation");
                View view = this.vLC.aus;
                kotlin.g.b.p.g(view, "viewHolder.itemView");
                view.setTag(new Object());
                AppMethodBeat.o(167332);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(167333);
                kotlin.g.b.p.h(animation, "animation");
                View view = this.vLC.aus;
                kotlin.g.b.p.g(view, "viewHolder.itemView");
                view.setTag(null);
                Log.d("Finder.MediaCropUI", "finally change from=" + this.vLB.vLx + " to=" + this.vLB.vLy);
                AppMethodBeat.o(167333);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.i(167334);
                kotlin.g.b.p.h(animation, "animation");
                AppMethodBeat.o(167334);
            }
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final void N(RecyclerView.v vVar) {
            AppMethodBeat.i(167341);
            kotlin.g.b.p.h(vVar, "viewHolder");
            AppMethodBeat.o(167341);
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final float M(RecyclerView.v vVar) {
            AppMethodBeat.i(167342);
            kotlin.g.b.p.h(vVar, "viewHolder");
            AppMethodBeat.o(167342);
            return 0.295858f;
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.v vVar, float f2, float f3, int i2, boolean z) {
            AppMethodBeat.i(167343);
            kotlin.g.b.p.h(canvas, "c");
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            kotlin.g.b.p.h(vVar, "viewHolder");
            super.a(canvas, recyclerView, vVar, f2 / 1.3f, f3 / 1.3f, i2, z);
            AppMethodBeat.o(167343);
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final int a(RecyclerView recyclerView, RecyclerView.v vVar) {
            AppMethodBeat.i(167344);
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            kotlin.g.b.p.h(vVar, "viewHolder");
            int db = a.AbstractC0053a.db(51);
            AppMethodBeat.o(167344);
            return db;
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final boolean nq() {
            return true;
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final boolean nr() {
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001eH\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusedView", "Landroid/view/View;", "getFocusedView", "()Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "maskView", "getMaskView", "orangeColor", "padding", "getPadding", "()I", "size", "getSize", "setFocusable", "", "focusable", "", "setSelected", "selected", "plugin-finder_release"})
    public static final class PreviewItemView extends FrameLayout {
        private final ImageView dKU = new ImageView(getContext());
        private final View maskView = new View(getContext());
        private final int padding;
        private final int size;
        private final int vLI;
        private final View vLJ = new View(getContext());

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PreviewItemView(Context context) {
            super(context);
            kotlin.g.b.p.h(context, "context");
            AppMethodBeat.i(167351);
            Context context2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
            this.vLI = context2.getResources().getColor(R.color.a3c);
            Context context3 = getContext();
            kotlin.g.b.p.g(context3, "context");
            this.padding = (int) context3.getResources().getDimension(R.dimen.bt);
            Context context4 = getContext();
            kotlin.g.b.p.g(context4, "context");
            this.size = (int) context4.getResources().getDimension(R.dimen.cq);
            this.dKU.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.size + (this.padding * 2), this.size + (this.padding * 2));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.size, this.size);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.size, this.size);
            layoutParams2.gravity = 17;
            layoutParams.gravity = 17;
            layoutParams3.gravity = 17;
            this.vLJ.setBackgroundColor(this.vLI);
            addView(this.vLJ, layoutParams);
            addView(this.dKU, layoutParams3);
            View view = this.maskView;
            Context context5 = getContext();
            kotlin.g.b.p.g(context5, "context");
            view.setBackgroundColor(context5.getResources().getColor(R.color.afz));
            this.maskView.setAlpha(0.5f);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
            layoutParams4.gravity = 17;
            setLayoutParams(layoutParams4);
            AppMethodBeat.o(167351);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PreviewItemView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            kotlin.g.b.p.h(context, "context");
            AppMethodBeat.i(167352);
            Context context2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
            this.vLI = context2.getResources().getColor(R.color.a3c);
            Context context3 = getContext();
            kotlin.g.b.p.g(context3, "context");
            this.padding = (int) context3.getResources().getDimension(R.dimen.bt);
            Context context4 = getContext();
            kotlin.g.b.p.g(context4, "context");
            this.size = (int) context4.getResources().getDimension(R.dimen.cq);
            this.dKU.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.size + (this.padding * 2), this.size + (this.padding * 2));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.size, this.size);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.size, this.size);
            layoutParams2.gravity = 17;
            layoutParams.gravity = 17;
            layoutParams3.gravity = 17;
            this.vLJ.setBackgroundColor(this.vLI);
            addView(this.vLJ, layoutParams);
            addView(this.dKU, layoutParams3);
            View view = this.maskView;
            Context context5 = getContext();
            kotlin.g.b.p.g(context5, "context");
            view.setBackgroundColor(context5.getResources().getColor(R.color.afz));
            this.maskView.setAlpha(0.5f);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
            layoutParams4.gravity = 17;
            setLayoutParams(layoutParams4);
            AppMethodBeat.o(167352);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PreviewItemView(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            kotlin.g.b.p.h(context, "context");
            AppMethodBeat.i(167353);
            Context context2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
            this.vLI = context2.getResources().getColor(R.color.a3c);
            Context context3 = getContext();
            kotlin.g.b.p.g(context3, "context");
            this.padding = (int) context3.getResources().getDimension(R.dimen.bt);
            Context context4 = getContext();
            kotlin.g.b.p.g(context4, "context");
            this.size = (int) context4.getResources().getDimension(R.dimen.cq);
            this.dKU.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.size + (this.padding * 2), this.size + (this.padding * 2));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.size, this.size);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.size, this.size);
            layoutParams2.gravity = 17;
            layoutParams.gravity = 17;
            layoutParams3.gravity = 17;
            this.vLJ.setBackgroundColor(this.vLI);
            addView(this.vLJ, layoutParams);
            addView(this.dKU, layoutParams3);
            View view = this.maskView;
            Context context5 = getContext();
            kotlin.g.b.p.g(context5, "context");
            view.setBackgroundColor(context5.getResources().getColor(R.color.afz));
            this.maskView.setAlpha(0.5f);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
            layoutParams4.gravity = 17;
            setLayoutParams(layoutParams4);
            AppMethodBeat.o(167353);
        }

        public final ImageView getImageView() {
            return this.dKU;
        }

        public final View getMaskView() {
            return this.maskView;
        }

        public final View getFocusedView() {
            return this.vLJ;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getSize() {
            return this.size;
        }

        @Override // android.view.View
        public final void setFocusable(boolean z) {
            AppMethodBeat.i(167349);
            super.setFocusable(z);
            if (z) {
                this.vLJ.setVisibility(0);
                AppMethodBeat.o(167349);
                return;
            }
            this.vLJ.setVisibility(4);
            AppMethodBeat.o(167349);
        }

        public final void setSelected(boolean z) {
            AppMethodBeat.i(167350);
            super.setSelected(z);
            if (z) {
                this.maskView.setVisibility(4);
                AppMethodBeat.o(167350);
                return;
            }
            this.maskView.setVisibility(0);
            AppMethodBeat.o(167350);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class ab implements Runnable {
        final /* synthetic */ FinderMediaCropUI vLw;

        ab(FinderMediaCropUI finderMediaCropUI) {
            this.vLw = finderMediaCropUI;
        }

        public final void run() {
            AppMethodBeat.i(167380);
            Dialog dialog = this.vLw.tipDialog;
            if (dialog != null) {
                dialog.show();
            } else {
                FinderMediaCropUI finderMediaCropUI = this.vLw;
                finderMediaCropUI.getString(R.string.zb);
                finderMediaCropUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) finderMediaCropUI, finderMediaCropUI.getString(R.string.a06), false, (DialogInterface.OnCancelListener) a.vLT);
            }
            Log.d("Finder.MediaCropUI", "tipDialog is show!");
            AppMethodBeat.o(167380);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
        static final class a implements DialogInterface.OnCancelListener {
            public static final a vLT = new a();

            static {
                AppMethodBeat.i(167379);
                AppMethodBeat.o(167379);
            }

            a() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        int i4;
        AppMethodBeat.i(167397);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            if (i3 == -1) {
                if (intent == null) {
                    kotlin.g.b.p.hyc();
                }
                Parcelable parcelableExtra = intent.getParcelableExtra("KSEGMENTMEDIAINFO");
                if (parcelableExtra == null) {
                    kotlin.g.b.p.hyc();
                }
                CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel = (CaptureDataManager.CaptureVideoNormalModel) parcelableExtra;
                this.vLp = false;
                ArrayList<GalleryItem.MediaItem> dzG = dzG();
                kotlin.g.b.p.g(dzG, "selectPathList");
                int i5 = 0;
                Iterator<GalleryItem.MediaItem> it = dzG.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i4 = -1;
                        break;
                    }
                    if (it.next().xiZ == this.vLr) {
                        i4 = i5;
                        break;
                    }
                    i5++;
                }
                if (i4 < 0) {
                    AppMethodBeat.o(167397);
                    return;
                }
                RecyclerView dzJ = dzJ();
                kotlin.g.b.p.g(dzJ, "previewRecyclerView");
                RecyclerView.a adapter = dzJ.getAdapter();
                if (!(adapter instanceof b)) {
                    adapter = null;
                }
                b bVar = (b) adapter;
                if (bVar != null) {
                    GalleryItem.MediaItem mediaItem = (GalleryItem.MediaItem) bVar.getItemAtPosition(i4);
                    Boolean eJI = captureVideoNormalModel.eJI();
                    kotlin.g.b.p.g(eJI, "model.photo");
                    if (eJI.booleanValue()) {
                        mediaItem.xjd = true;
                        mediaItem.xiW = captureVideoNormalModel.aQn();
                        Log.i("Finder.MediaCropUI", "[onActivityResult] edit photo output=" + captureVideoNormalModel.aQn());
                        WxMediaCropLayout dzH = dzH();
                        long j2 = mediaItem.xiZ;
                        kotlin.g.b.p.g(mediaItem, "item");
                        String dRh = mediaItem.dRh();
                        kotlin.g.b.p.g(dRh, "item.originalPath");
                        this.vLd.get(mediaItem.xiZ).a(WxMediaCropLayout.a(dzH, j2, dRh, true, this.vLq, (kotlin.g.a.q) null, 16));
                    } else {
                        Log.i("Finder.MediaCropUI", "[onActivityResult] edit video output=" + captureVideoNormalModel.getVideoPath());
                        GalleryItem.MediaItem a2 = GalleryItem.MediaItem.a(2, 0, captureVideoNormalModel.getVideoPath(), captureVideoNormalModel.aQn(), "");
                        dzG().clear();
                        dzG().add(a2);
                        bVar.setItems(dzG());
                        bVar.notifyDataSetChanged();
                        d dVar = new d();
                        dVar.vLG = 1;
                        this.vLd.put(0, dVar);
                        RecyclerView.v cg = dzJ().cg(0);
                        View view = cg != null ? cg.aus : null;
                        if (view == null) {
                            kotlin.g.b.p.hyc();
                        }
                        kotlin.g.b.p.g(view, "previewRecyclerView.find…utPosition(0)?.itemView!!");
                        GalleryItem.MediaItem mediaItem2 = dzG().get(0);
                        kotlin.g.b.p.g(mediaItem2, "selectPathList[0]");
                        a(0, view, mediaItem2);
                    }
                    RecyclerView dzJ2 = dzJ();
                    kotlin.g.b.p.g(dzJ2, "previewRecyclerView");
                    RecyclerView.a adapter2 = dzJ2.getAdapter();
                    if (adapter2 != null) {
                        adapter2.ci(i4);
                        AppMethodBeat.o(167397);
                        return;
                    }
                    AppMethodBeat.o(167397);
                    return;
                }
                AppMethodBeat.o(167397);
                return;
            }
            RecyclerView.v cg2 = dzJ().cg(0);
            View view2 = cg2 != null ? cg2.aus : null;
            if (view2 == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(view2, "previewRecyclerView.find…utPosition(0)?.itemView!!");
            GalleryItem.MediaItem mediaItem3 = dzG().get(0);
            kotlin.g.b.p.g(mediaItem3, "selectPathList[0]");
            a(0, view2, mediaItem3);
        }
        AppMethodBeat.o(167397);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra;", "", "()V", "cropInfo", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;", "setCropInfo", "(Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout$CropInfo;)V", LoggingConstants.LOG_FILE_PREFIX, "", "getStats", "()I", "setStats", "(I)V", "Companion", "plugin-finder_release"})
    public static final class d {
        public static final a vLH = new a((byte) 0);
        WxMediaCropLayout.b vLF = new WxMediaCropLayout.b(0, "");
        int vLG = -1;

        static {
            AppMethodBeat.i(167348);
            AppMethodBeat.o(167348);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$MediaExtra$Companion;", "", "()V", "SELECTED", "", "UNSELECTED", "plugin-finder_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        public d() {
            AppMethodBeat.i(167347);
            AppMethodBeat.o(167347);
        }

        public final void a(WxMediaCropLayout.b bVar) {
            AppMethodBeat.i(167346);
            kotlin.g.b.p.h(bVar, "<set-?>");
            this.vLF = bVar;
            AppMethodBeat.o(167346);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "kotlin.jvm.PlatformType", "invoke"})
    static final class ac extends kotlin.g.b.q implements kotlin.g.a.a<ArrayList<GalleryItem.MediaItem>> {
        final /* synthetic */ FinderMediaCropUI vLw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ac(FinderMediaCropUI finderMediaCropUI) {
            super(0);
            this.vLw = finderMediaCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ArrayList<GalleryItem.MediaItem> invoke() {
            AppMethodBeat.i(167381);
            ArrayList<GalleryItem.MediaItem> parcelableArrayListExtra = this.vLw.getIntent().getParcelableArrayListExtra("select_path_list");
            kotlin.g.b.p.g(parcelableArrayListExtra, "list");
            for (GalleryItem.MediaItem mediaItem : parcelableArrayListExtra) {
                d dVar = new d();
                dVar.vLG = 1;
                this.vLw.vLd.put(mediaItem.xiZ, dVar);
            }
            AppMethodBeat.o(167381);
            return parcelableArrayListExtra;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<WxMediaCropLayout> {
        final /* synthetic */ FinderMediaCropUI vLw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderMediaCropUI finderMediaCropUI) {
            super(0);
            this.vLw = finderMediaCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WxMediaCropLayout invoke() {
            AppMethodBeat.i(167356);
            WxMediaCropLayout wxMediaCropLayout = (WxMediaCropLayout) this.vLw.findViewById(R.id.bif);
            AppMethodBeat.o(167356);
            return wxMediaCropLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderMediaCropUI vLw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderMediaCropUI finderMediaCropUI) {
            super(0);
            this.vLw = finderMediaCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(167354);
            View findViewById = this.vLw.findViewById(R.id.ca);
            AppMethodBeat.o(167354);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class aa extends kotlin.g.b.q implements kotlin.g.a.a<RecyclerView> {
        final /* synthetic */ FinderMediaCropUI vLw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aa(FinderMediaCropUI finderMediaCropUI) {
            super(0);
            this.vLw = finderMediaCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView invoke() {
            AppMethodBeat.i(167378);
            RecyclerView recyclerView = (RecyclerView) this.vLw.findViewById(R.id.d8p);
            AppMethodBeat.o(167378);
            return recyclerView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderMediaCropUI vLw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(FinderMediaCropUI finderMediaCropUI) {
            super(0);
            this.vLw = finderMediaCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(167360);
            View findViewById = this.vLw.findViewById(R.id.d8b);
            AppMethodBeat.o(167360);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class z extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderMediaCropUI vLw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(FinderMediaCropUI finderMediaCropUI) {
            super(0);
            this.vLw = finderMediaCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(167377);
            TextView textView = (TextView) this.vLw.findViewById(R.id.ggo);
            AppMethodBeat.o(167377);
            return textView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderMediaCropUI vLw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderMediaCropUI finderMediaCropUI) {
            super(0);
            this.vLw = finderMediaCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(167359);
            View findViewById = this.vLw.findViewById(R.id.bvn);
            AppMethodBeat.o(167359);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class ae extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderMediaCropUI vLw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ae(FinderMediaCropUI finderMediaCropUI) {
            super(0);
            this.vLw = finderMediaCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(252508);
            View findViewById = this.vLw.findViewById(R.id.j8w);
            AppMethodBeat.o(252508);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "invoke"})
    static final class ad extends kotlin.g.b.q implements kotlin.g.a.a<CheckBox> {
        final /* synthetic */ FinderMediaCropUI vLw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ad(FinderMediaCropUI finderMediaCropUI) {
            super(0);
            this.vLw = finderMediaCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ CheckBox invoke() {
            AppMethodBeat.i(252507);
            CheckBox checkBox = (CheckBox) this.vLw.findViewById(R.id.j8v);
            AppMethodBeat.o(252507);
            return checkBox;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class s extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderMediaCropUI vLw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(FinderMediaCropUI finderMediaCropUI) {
            super(0);
            this.vLw = finderMediaCropUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(167368);
            Boolean valueOf = Boolean.valueOf(this.vLw.getIntent().getBooleanExtra("fromAppBrand", false));
            AppMethodBeat.o(167368);
            return valueOf;
        }
    }

    private final void a(List<? extends GalleryItem.MediaItem> list, kotlin.g.a.m<? super List<? extends MediaSelectedData>, ? super Boolean, kotlin.x> mVar) {
        AppMethodBeat.i(167396);
        MMHandlerThread.postToMainThreadDelayed(this.vJC, 300);
        z.d dVar = new z.d();
        dVar.SYE = list.size();
        ArrayList arrayList = new ArrayList(9);
        z.f fVar = new z.f();
        fVar.SYG = (T) new Rect();
        int i2 = 0;
        for (T t2 : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            T t3 = t2;
            arrayList.add(new MediaSelectedData(-1));
            d dVar2 = this.vLd.get(t3.xiZ);
            String str = t3.xiW;
            Matrix matrix = new Matrix(dVar2.vLF.dRK());
            Rect rect = new Rect(dVar2.vLF.iiw);
            Rect rect2 = new Rect(dVar2.vLF.rwL);
            Rect rect3 = new Rect(dVar2.vLF.viewRect);
            if (i2 == 0) {
                fVar.SYG.set(rect);
            }
            int type = t3.getType();
            kotlin.g.b.p.g(str, "path");
            T t4 = fVar.SYG;
            if (rect.isEmpty() || rect2.isEmpty()) {
                AppCompatActivity context = getContext();
                kotlin.g.b.p.g(context, "context");
                CropLayout cropLayout = new CropLayout(context);
                View view = new View(getContext());
                if (type == 2) {
                    com.tencent.mm.plugin.gallery.a.c cVar = com.tencent.mm.plugin.gallery.a.c.xsz;
                    com.tencent.mm.plugin.sight.base.a awl = com.tencent.mm.plugin.gallery.a.c.awl(str);
                    CropLayout.a(cropLayout, view, awl.width, awl.height, null, null, null, 56);
                    rect3.set(0, 0, awl.width, awl.height);
                    view.setRight(awl.width);
                    view.setBottom(awl.height);
                } else {
                    BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
                    CropLayout.a(cropLayout, view, imageOptions.outWidth, imageOptions.outHeight, null, null, null, 56);
                    rect3.set(0, 0, imageOptions.outWidth, imageOptions.outHeight);
                    view.setRight(imageOptions.outWidth);
                    view.setBottom(imageOptions.outHeight);
                }
                Log.i("Finder.MediaCropUI", "[checkCropInfo] need to set default CropInfo. type=" + type + " position=" + i2 + " viewRect=" + rect3 + " contentRect=" + rect2 + " cropRect=" + rect);
                cropLayout.getVisibilityRect().set((Rect) t4);
                WxMediaCropLayout dzH = dzH();
                kotlin.g.b.p.g(dzH, "cropLayout");
                int left = dzH.getLeft();
                WxMediaCropLayout dzH2 = dzH();
                kotlin.g.b.p.g(dzH2, "cropLayout");
                int top = dzH2.getTop();
                WxMediaCropLayout dzH3 = dzH();
                kotlin.g.b.p.g(dzH3, "cropLayout");
                int right = dzH3.getRight();
                WxMediaCropLayout dzH4 = dzH();
                kotlin.g.b.p.g(dzH4, "cropLayout");
                cropLayout.e(true, left, top, right, dzH4.getBottom());
                matrix.set(cropLayout.getMainMatrix());
                if (t4.isEmpty()) {
                    dzt().round(rect);
                } else {
                    rect.set(t4);
                }
                rect2.set(cropLayout.getContentRect());
            }
            Log.i("Finder.MediaCropUI", "onGenerateMedia, cropRect:" + rect + ", contentRect:" + rect + ", viewRect:" + rect3);
            int type2 = t3.getType();
            com.tencent.mm.plugin.gallery.picker.b.b bVar = this.vLu;
            if (bVar == null) {
                kotlin.g.b.p.btv("mediaTailor");
            }
            com.tencent.mm.plugin.gallery.picker.b.b.a(bVar, str, type2, matrix, rect, rect2, rect3, i2, new y(t3, i2, this, arrayList, fVar, mVar, dVar));
            i2 = i3;
        }
        AppMethodBeat.o(167396);
    }

    public static final /* synthetic */ void c(FinderMediaCropUI finderMediaCropUI) {
        AppMethodBeat.i(167400);
        ArrayList<GalleryItem.MediaItem> dzG = finderMediaCropUI.dzG();
        kotlin.g.b.p.g(dzG, "selectPathList");
        ArrayList arrayList = new ArrayList();
        for (T t2 : dzG) {
            if (finderMediaCropUI.vLd.get(t2.xiZ).vLG != -1) {
                arrayList.add(t2);
            }
        }
        ArrayList arrayList2 = arrayList;
        finderMediaCropUI.a(arrayList2, new x(finderMediaCropUI, arrayList2));
        AppMethodBeat.o(167400);
    }
}
