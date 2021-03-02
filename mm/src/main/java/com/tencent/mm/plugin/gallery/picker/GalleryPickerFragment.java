package com.tencent.mm.plugin.gallery.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.picker.a.a;
import com.tencent.mm.plugin.gallery.picker.a.b;
import com.tencent.mm.plugin.gallery.picker.manager.SpeedGirdLayoutManager;
import com.tencent.mm.plugin.gallery.picker.view.MMMediaCropLayout;
import com.tencent.mm.plugin.gallery.picker.view.MediaItemView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 P2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0002PQB\u001f\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u001c\u0010(\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020\u0015H\u0002J\b\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0003J\u0010\u00102\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00103\u001a\u00020)2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u00104\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0002J\u0012\u00105\u001a\u00020)2\b\u00106\u001a\u0004\u0018\u000107H\u0016J&\u00108\u001a\u0004\u0018\u0001002\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010=\u001a\u00020)H\u0016J\u0010\u0010>\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0004H\u0016J\u0010\u0010?\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u0004H\u0016J\u0018\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020B2\u0006\u0010*\u001a\u00020\u0004H\u0016J\u0018\u0010C\u001a\u00020)2\u0006\u0010A\u001a\u00020B2\u0006\u0010*\u001a\u00020\u0004H\u0016J\b\u0010D\u001a\u00020)H\u0016J\u0010\u0010E\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0004H\u0002J\b\u0010F\u001a\u00020)H\u0016J\b\u0010G\u001a\u00020)H\u0002J\u0010\u0010H\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0004H\u0002J\u0010\u0010I\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0004H\u0002J\b\u0010J\u001a\u00020)H\u0002J\u0018\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020MH\u0002J\b\u0010O\u001a\u00020)H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "selectedMedias", "Ljava/util/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;)V", "adapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "albumChooserView", "Landroid/support/v7/widget/RecyclerView;", "appBarLayout", "Landroid/support/design/widget/AppBarLayout;", "folderAdapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;", "galleryView", "value", "", "isMultiSelectedMode", "setMultiSelectedMode", "(Z)V", "getListener", "()Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "setListener", "(Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;)V", "multiIconGreen", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "multiIconGrep", "multiSelectedIcon", "Landroid/widget/ImageView;", "previewContainer", "Lcom/tencent/mm/plugin/gallery/picker/view/MMMediaCropLayout;", "previewPosition", "", "targetSelectedType", "checkResetCropWindow", "", "media", "isPreview", "createItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "initAlbumChooserView", "view", "Landroid/view/View;", "initFolderSelectLayout", "initGalleryView", "initPreviewContainer", "initViews", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onItemClick", "onItemLongClick", "onMediaSelected", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "onMediaUnSelected", "onPause", "onPreviewItem", "onResume", "onShowDefaultItem", com.tencent.mm.plugin.appbrand.jsapi.media.l.NAME, "previewVideo", "updateItemSelectedEnable", "updatePreviewSelectedStatus", "last", "", "current", "updateSelectItemNum", "Companion", "ISelectedMediaChange", "plugin-gallery_release"})
@SuppressLint({"ValidFragment"})
public final class GalleryPickerFragment extends Fragment implements a.c, a.d, MediaItemView.b<GalleryItem.MediaItem> {
    public static final a xkp = new a((byte) 0);
    private ArrayList<GalleryItem.MediaItem> vML;
    private final com.tencent.mm.plugin.gallery.picker.a.a xkc = new com.tencent.mm.plugin.gallery.picker.a.a(com.tencent.mm.plugin.gallery.picker.c.f.dRD(), this.vML);
    private final com.tencent.mm.plugin.gallery.picker.a.b xkd;
    private RecyclerView xke;
    private RecyclerView xkf;
    private MMMediaCropLayout xkg;
    private AppBarLayout xkh;
    private ImageView xki;
    private final Drawable xkj;
    private final Drawable xkk;
    private int xkl;
    private boolean xkm;
    private int xkn;
    private b xko;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "", "onChange", "", "size", "", "plugin-gallery_release"})
    public interface b {
    }

    static {
        AppMethodBeat.i(164843);
        AppMethodBeat.o(164843);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "isSuccessfully", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "cost", "", "invoke"})
    static final class i extends q implements kotlin.g.a.q<Boolean, LinkedList<GalleryItem.MediaItem>, Long, x> {
        final /* synthetic */ GalleryPickerFragment xkr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(GalleryPickerFragment galleryPickerFragment) {
            super(3);
            this.xkr = galleryPickerFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(Boolean bool, LinkedList<GalleryItem.MediaItem> linkedList, Long l) {
            AppMethodBeat.i(164822);
            boolean booleanValue = bool.booleanValue();
            LinkedList<GalleryItem.MediaItem> linkedList2 = linkedList;
            final long longValue = l.longValue();
            p.h(linkedList2, "data");
            if (!booleanValue) {
                Log.w("MicroMsg.GalleryPickerFragment", "[onActivityCreated] onLoad failure!");
            } else {
                final List v = kotlin.a.j.v((Collection) linkedList2);
                com.tencent.mm.ac.d.b(com.tencent.mm.ac.d.aBx(), new kotlin.g.a.b<Void, x>(this) {
                    /* class com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment.i.AnonymousClass1 */
                    final /* synthetic */ i xky;

                    {
                        this.xky = r3;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(Void r6) {
                        AppMethodBeat.i(164821);
                        Log.i("MicroMsg.GalleryPickerFragment", "load cost=" + longValue + "ms size=" + v.size());
                        if (this.xky.xkr.xkc.getItemCount() > 0) {
                            this.xky.xkr.xkc.je(v);
                        } else {
                            this.xky.xkr.xkc.setItems(v);
                        }
                        GalleryPickerFragment.b(this.xky.xkr);
                        x xVar = x.SXb;
                        AppMethodBeat.o(164821);
                        return xVar;
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(164822);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "cost", "", "invoke"})
    static final class j extends q implements m<LinkedList<GalleryItem.AlbumItem>, Long, x> {
        final /* synthetic */ GalleryPickerFragment xkr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(GalleryPickerFragment galleryPickerFragment) {
            super(2);
            this.xkr = galleryPickerFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(LinkedList<GalleryItem.AlbumItem> linkedList, Long l) {
            AppMethodBeat.i(164824);
            final LinkedList<GalleryItem.AlbumItem> linkedList2 = linkedList;
            final long longValue = l.longValue();
            p.h(linkedList2, "data");
            com.tencent.mm.ac.d.b(com.tencent.mm.ac.d.aBx(), new kotlin.g.a.b<Void, x>(this) {
                /* class com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment.j.AnonymousClass1 */
                final /* synthetic */ j xkz;

                {
                    this.xkz = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(Void r8) {
                    AppMethodBeat.i(164823);
                    List v = kotlin.a.j.v((Collection) linkedList2);
                    Log.i("MicroMsg.GalleryPickerFragment", "load cost=" + longValue + "ms size=" + v.size());
                    if (this.xkz.xkr.xkd.getItemCount() > 0) {
                        this.xkz.xkr.xkd.je(v);
                    } else {
                        this.xkz.xkr.xkd.setItems(v);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(164823);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(164824);
            return xVar;
        }
    }

    public GalleryPickerFragment(ArrayList<GalleryItem.MediaItem> arrayList, b bVar) {
        p.h(arrayList, "selectedMedias");
        AppMethodBeat.i(164842);
        this.vML = arrayList;
        this.xko = bVar;
        com.tencent.mm.plugin.gallery.picker.c.f fVar = com.tencent.mm.plugin.gallery.picker.c.f.xlA;
        com.tencent.mm.plugin.gallery.picker.c.f fVar2 = com.tencent.mm.plugin.gallery.picker.c.f.xlA;
        this.xkd = new com.tencent.mm.plugin.gallery.picker.a.b(com.tencent.mm.plugin.gallery.picker.c.f.dRD());
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        this.xkj = context.getResources().getDrawable(R.drawable.atd);
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        this.xkk = context2.getResources().getDrawable(R.drawable.atc);
        this.xkl = 1;
        this.xkm = true;
        AppMethodBeat.o(164842);
    }

    public static final /* synthetic */ void a(GalleryPickerFragment galleryPickerFragment, GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(164845);
        galleryPickerFragment.f(mediaItem);
        AppMethodBeat.o(164845);
    }

    public static final /* synthetic */ void a(GalleryPickerFragment galleryPickerFragment, boolean z) {
        AppMethodBeat.i(164846);
        galleryPickerFragment.px(z);
        AppMethodBeat.o(164846);
    }

    public static final /* synthetic */ RecyclerView e(GalleryPickerFragment galleryPickerFragment) {
        AppMethodBeat.i(164847);
        RecyclerView recyclerView = galleryPickerFragment.xkf;
        if (recyclerView == null) {
            p.btv("galleryView");
        }
        AppMethodBeat.o(164847);
        return recyclerView;
    }

    public static final /* synthetic */ RecyclerView f(GalleryPickerFragment galleryPickerFragment) {
        AppMethodBeat.i(164848);
        RecyclerView recyclerView = galleryPickerFragment.xke;
        if (recyclerView == null) {
            p.btv("albumChooserView");
        }
        AppMethodBeat.o(164848);
        return recyclerView;
    }

    public static final /* synthetic */ AppBarLayout h(GalleryPickerFragment galleryPickerFragment) {
        AppMethodBeat.i(164849);
        AppBarLayout appBarLayout = galleryPickerFragment.xkh;
        if (appBarLayout == null) {
            p.btv("appBarLayout");
        }
        AppMethodBeat.o(164849);
        return appBarLayout;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.ui.base.a.b, java.lang.Object] */
    @Override // com.tencent.mm.plugin.gallery.picker.view.MediaItemView.b
    public final /* synthetic */ void a(com.tencent.mm.ui.base.a.b bVar, GalleryItem.MediaItem mediaItem) {
        boolean z;
        GalleryPickerFragment galleryPickerFragment;
        AppMethodBeat.i(164831);
        GalleryItem.MediaItem mediaItem2 = mediaItem;
        p.h(bVar, "holder");
        p.h(mediaItem2, "media");
        Log.i("MicroMsg.GalleryPickerFragment", "[onMediaUnSelected] media=" + mediaItem2.toSimpleString());
        if (this.vML.size() == 0) {
            z = true;
            galleryPickerFragment = this;
        } else {
            if (this.vML.size() == 8) {
                if (((GalleryItem.MediaItem) kotlin.a.j.ks(this.vML)).getType() == 2 || this.vML.size() >= 9) {
                    z = false;
                    galleryPickerFragment = this;
                } else {
                    z = true;
                    galleryPickerFragment = this;
                }
            }
            a(mediaItem2, false);
            dRA();
            AppMethodBeat.o(164831);
        }
        galleryPickerFragment.px(z);
        a(mediaItem2, false);
        dRA();
        AppMethodBeat.o(164831);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.ui.base.a.b, java.lang.Object] */
    @Override // com.tencent.mm.plugin.gallery.picker.view.MediaItemView.b
    public final /* synthetic */ void b(com.tencent.mm.ui.base.a.b bVar, GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(164832);
        GalleryItem.MediaItem mediaItem2 = mediaItem;
        p.h(bVar, "holder");
        p.h(mediaItem2, "media");
        Log.i("MicroMsg.GalleryPickerFragment", "[onMediaSelected] media=" + mediaItem2.toSimpleString());
        if (this.vML.size() == 1 || this.vML.size() == 9) {
            px(((GalleryItem.MediaItem) kotlin.a.j.ks(this.vML)).getType() != 2 && this.vML.size() < 9);
        }
        f(mediaItem2);
        if (!this.xkm && this.vML.size() > 1) {
            GalleryItem.MediaItem mediaItem3 = (GalleryItem.MediaItem) kotlin.a.j.ks(this.vML);
            RecyclerView recyclerView = this.xkf;
            if (recyclerView == null) {
                p.btv("galleryView");
            }
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
                AppMethodBeat.o(164832);
                throw tVar;
            }
            RecyclerView.v vVar = ((com.tencent.mm.view.recyclerview.g) adapter).V(mediaItem3.xiZ, false);
            if (!(vVar instanceof com.tencent.mm.ui.base.a.b)) {
                vVar = null;
            }
            com.tencent.mm.ui.base.a.b bVar2 = (com.tencent.mm.ui.base.a.b) vVar;
            if (bVar2 != null) {
                ((MediaItemView) bVar2.getView()).py(false);
            } else {
                GalleryPickerFragment galleryPickerFragment = this;
                if (galleryPickerFragment.xkc.xkE.remove(mediaItem3)) {
                    galleryPickerFragment.xkc.hXI.remove(mediaItem3);
                }
            }
        }
        dRA();
        AppMethodBeat.o(164832);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$Companion;", "", "()V", "LIMIT_SELECTED_COUNT", "", "MARGIN_GRID", "ROW_ITEM_COUNT", "TAG", "", "plugin-gallery_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final void px(boolean z) {
        AppMethodBeat.i(164826);
        this.xkm = z;
        this.xkc.xkm = z;
        Log.i("MicroMsg.GalleryPickerFragment", "isMultiSelectedMode=".concat(String.valueOf(z)));
        Log.i("MicroMsg.GalleryPickerFragment", "[updateItemSelectedEnable]");
        RecyclerView recyclerView = this.xkf;
        if (recyclerView == null) {
            p.btv("galleryView");
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            p.hyc();
        }
        RecyclerView recyclerView2 = this.xkf;
        if (recyclerView2 == null) {
            p.btv("galleryView");
        }
        RecyclerView.a adapter2 = recyclerView2.getAdapter();
        if (adapter2 == null) {
            p.hyc();
        }
        p.g(adapter2, "galleryView.adapter!!");
        adapter.e(0, adapter2.getItemCount(), 2);
        AppMethodBeat.o(164826);
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        AppMethodBeat.i(164827);
        super.onActivityCreated(bundle);
        com.tencent.mm.plugin.gallery.picker.c.e eVar = com.tencent.mm.plugin.gallery.picker.c.e.xlq;
        com.tencent.mm.plugin.gallery.picker.c.e.MC();
        com.tencent.mm.plugin.gallery.picker.c.e.a(com.tencent.mm.plugin.gallery.picker.c.e.xlq, new i(this));
        com.tencent.mm.plugin.gallery.picker.c.e eVar2 = com.tencent.mm.plugin.gallery.picker.c.e.xlq;
        com.tencent.mm.plugin.gallery.picker.c.e.g(new j(this));
        AppMethodBeat.o(164827);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class k implements Runnable {
        final /* synthetic */ GalleryPickerFragment xkr;

        k(GalleryPickerFragment galleryPickerFragment) {
            this.xkr = galleryPickerFragment;
        }

        public final void run() {
            AppMethodBeat.i(164825);
            if (this.xkr.xkc.getItemCount() > 0) {
                GalleryItem.MediaItem mediaItem = (GalleryItem.MediaItem) this.xkr.xkc.getItemAtPosition(0);
                GalleryPickerFragment galleryPickerFragment = this.xkr;
                p.g(mediaItem, "media");
                GalleryPickerFragment.a(galleryPickerFragment, mediaItem);
                Log.i("MicroMsg.GalleryPickerFragment", "[onShowDefaultItem] media=".concat(String.valueOf(mediaItem)));
            }
            AppMethodBeat.o(164825);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onDestroy() {
        AppMethodBeat.i(164828);
        super.onDestroy();
        com.tencent.mm.plugin.gallery.picker.c.e eVar = com.tencent.mm.plugin.gallery.picker.c.e.xlq;
        com.tencent.mm.plugin.gallery.picker.c.e.onRelease();
        AppMethodBeat.o(164828);
    }

    @Override // android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(164829);
        p.h(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.aoe, viewGroup, false);
        p.g(inflate, "view");
        View findViewById = inflate.findViewById(R.id.dcu);
        p.g(findViewById, "view.findViewById(R.id.gallery_view)");
        this.xkf = (RecyclerView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.ggh);
        p.g(findViewById2, "view.findViewById(R.id.preview_container)");
        this.xkg = (MMMediaCropLayout) findViewById2;
        MMMediaCropLayout mMMediaCropLayout = this.xkg;
        if (mMMediaCropLayout == null) {
            p.btv("previewContainer");
        }
        ViewGroup.LayoutParams layoutParams = mMMediaCropLayout.getLayoutParams();
        Resources resources = getResources();
        p.g(resources, "resources");
        layoutParams.height = (int) ((((float) resources.getDisplayMetrics().widthPixels) * 3.5f) / 3.0f);
        mMMediaCropLayout.requestLayout();
        mMMediaCropLayout.setOnClickListener(new h(this));
        View findViewById3 = inflate.findViewById(R.id.fni);
        p.g(findViewById3, "view.findViewById(R.id.multi_selected_icon)");
        this.xki = (ImageView) findViewById3;
        ImageView imageView = this.xki;
        if (imageView == null) {
            p.btv("multiSelectedIcon");
        }
        imageView.setBackground(this.xkk);
        ImageView imageView2 = this.xki;
        if (imageView2 == null) {
            p.btv("multiSelectedIcon");
        }
        imageView2.setOnClickListener(new f(this));
        ImageView imageView3 = this.xki;
        if (imageView3 == null) {
            p.btv("multiSelectedIcon");
        }
        imageView3.setVisibility(8);
        SpeedGirdLayoutManager speedGirdLayoutManager = new SpeedGirdLayoutManager(getContext());
        RecyclerView recyclerView = this.xkf;
        if (recyclerView == null) {
            p.btv("galleryView");
        }
        recyclerView.setLayoutManager(speedGirdLayoutManager);
        RecyclerView recyclerView2 = this.xkf;
        if (recyclerView2 == null) {
            p.btv("galleryView");
        }
        recyclerView2.setAdapter(this.xkc);
        RecyclerView recyclerView3 = this.xkf;
        if (recyclerView3 == null) {
            p.btv("galleryView");
        }
        recyclerView3.b(new c(this));
        g gVar = new g();
        RecyclerView recyclerView4 = this.xkf;
        if (recyclerView4 == null) {
            p.btv("galleryView");
        }
        recyclerView4.setItemAnimator(gVar);
        RecyclerView recyclerView5 = this.xkf;
        if (recyclerView5 == null) {
            p.btv("galleryView");
        }
        recyclerView5.setHasFixedSize(true);
        RecyclerView.m mVar = new RecyclerView.m();
        mVar.aw(1, 80);
        mVar.aw(2, 60);
        RecyclerView recyclerView6 = this.xkf;
        if (recyclerView6 == null) {
            p.btv("galleryView");
        }
        recyclerView6.setRecycledViewPool(mVar);
        speedGirdLayoutManager.setItemPrefetchEnabled(true);
        speedGirdLayoutManager.ca(30);
        this.xkc.xkB = this;
        this.xkc.xkD = this;
        this.xkc.xkC = this;
        inflate.findViewById(R.id.d7q).setOnClickListener(new e(this, (ImageView) inflate.findViewById(R.id.uq)));
        TextView textView = (TextView) inflate.findViewById(R.id.d7q);
        View findViewById4 = inflate.findViewById(R.id.sn);
        p.g(findViewById4, "view.findViewById(R.id.appbar_layout)");
        this.xkh = (AppBarLayout) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.d7k);
        p.g(findViewById5, "view.findViewById(R.id.folder_chooser_view)");
        this.xke = (RecyclerView) findViewById5;
        RecyclerView recyclerView7 = this.xke;
        if (recyclerView7 == null) {
            p.btv("albumChooserView");
        }
        getContext();
        recyclerView7.setLayoutManager(new LinearLayoutManager());
        RecyclerView recyclerView8 = this.xke;
        if (recyclerView8 == null) {
            p.btv("albumChooserView");
        }
        recyclerView8.setHasFixedSize(true);
        RecyclerView recyclerView9 = this.xke;
        if (recyclerView9 == null) {
            p.btv("albumChooserView");
        }
        recyclerView9.setAdapter(this.xkd);
        this.xkd.xkH = new d(this, textView);
        AppMethodBeat.o(164829);
        return inflate;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ GalleryPickerFragment xkr;

        f(GalleryPickerFragment galleryPickerFragment) {
            this.xkr = galleryPickerFragment;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(164818);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initGalleryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            GalleryPickerFragment.a(this.xkr, !this.xkr.xkm);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initGalleryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(164818);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initGalleryView$animator$1", "Landroid/support/v7/widget/DefaultItemAnimator;", "canReuseUpdatedViewHolder", "", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-gallery_release"})
    public static final class g extends v {
        g() {
        }

        @Override // android.support.v7.widget.RecyclerView.f, android.support.v7.widget.as
        public final boolean p(RecyclerView.v vVar) {
            AppMethodBeat.i(164819);
            p.h(vVar, "viewHolder");
            AppMethodBeat.o(164819);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ GalleryPickerFragment xkr;
        final /* synthetic */ ImageView xkx;

        e(GalleryPickerFragment galleryPickerFragment, ImageView imageView) {
            this.xkr = galleryPickerFragment;
            this.xkx = imageView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(164817);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initFolderSelectLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (GalleryPickerFragment.e(this.xkr).getVisibility() == 0) {
                GalleryPickerFragment.e(this.xkr).setVisibility(8);
                GalleryPickerFragment.f(this.xkr).setVisibility(0);
                ImageView imageView = this.xkx;
                Context context = this.xkr.getContext();
                Context context2 = this.xkr.getContext();
                if (context2 == null) {
                    p.hyc();
                }
                p.g(context2, "context!!");
                imageView.setImageDrawable(ar.m(context, R.raw.arrow_up, context2.getResources().getColor(R.color.fr)));
            } else {
                GalleryPickerFragment.e(this.xkr).setVisibility(0);
                GalleryPickerFragment.f(this.xkr).setVisibility(8);
                ImageView imageView2 = this.xkx;
                Context context3 = this.xkr.getContext();
                Context context4 = this.xkr.getContext();
                if (context4 == null) {
                    p.hyc();
                }
                p.g(context4, "context!!");
                imageView2.setImageDrawable(ar.m(context3, R.raw.arrow_down, context4.getResources().getColor(R.color.fr)));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initFolderSelectLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(164817);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initAlbumChooserView$1", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
    public static final class d implements b.AbstractC1387b {
        final /* synthetic */ GalleryPickerFragment xkr;
        final /* synthetic */ TextView xks;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "isSuccessfully", "", "data", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "cost", "", "invoke"})
        static final class a extends q implements kotlin.g.a.q<Boolean, LinkedList<GalleryItem.MediaItem>, Long, x> {
            final /* synthetic */ d xkt;
            final /* synthetic */ GalleryItem.AlbumItem xku;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, GalleryItem.AlbumItem albumItem) {
                super(3);
                this.xkt = dVar;
                this.xku = albumItem;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.q
            public final /* synthetic */ x d(Boolean bool, LinkedList<GalleryItem.MediaItem> linkedList, Long l) {
                AppMethodBeat.i(164815);
                boolean booleanValue = bool.booleanValue();
                LinkedList<GalleryItem.MediaItem> linkedList2 = linkedList;
                final long longValue = l.longValue();
                p.h(linkedList2, "data");
                if (!booleanValue) {
                    Log.w("MicroMsg.GalleryPickerFragment", "[onItemClick] onLoad failure!");
                    this.xkt.xks.performClick();
                } else {
                    final List v = kotlin.a.j.v((Collection) linkedList2);
                    com.tencent.mm.ac.d.b(com.tencent.mm.ac.d.aBx(), new kotlin.g.a.b<Void, x>(this) {
                        /* class com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment.d.a.AnonymousClass1 */
                        final /* synthetic */ a xkv;

                        {
                            this.xkv = r3;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // kotlin.g.a.b
                        public final /* synthetic */ x invoke(Void r6) {
                            AppMethodBeat.i(164814);
                            Log.i("MicroMsg.GalleryPickerFragment", "load cost=" + longValue + "ms size=" + v.size());
                            this.xkv.xkt.xkr.xkc.clearItems();
                            this.xkv.xkt.xkr.xkc.setItems(v);
                            this.xkv.xkt.xks.performClick();
                            TextView textView = this.xkv.xkt.xks;
                            p.g(textView, "folderNameTv");
                            textView.setText(this.xkv.xku.albumName);
                            x xVar = x.SXb;
                            AppMethodBeat.o(164814);
                            return xVar;
                        }
                    });
                }
                x xVar = x.SXb;
                AppMethodBeat.o(164815);
                return xVar;
            }
        }

        d(GalleryPickerFragment galleryPickerFragment, TextView textView) {
            this.xkr = galleryPickerFragment;
            this.xks = textView;
        }

        @Override // com.tencent.mm.plugin.gallery.picker.a.b.AbstractC1387b
        public final void a(GalleryItem.AlbumItem albumItem) {
            AppMethodBeat.i(164816);
            p.h(albumItem, "media");
            com.tencent.mm.plugin.gallery.picker.c.e eVar = com.tencent.mm.plugin.gallery.picker.c.e.xlq;
            com.tencent.mm.plugin.gallery.picker.c.e.a(System.currentTimeMillis(), albumItem, new a(this, albumItem));
            AppMethodBeat.o(164816);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, hxF = {"com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$createItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "greenColor", "", "getGreenColor", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDrawOver", "c", "Landroid/graphics/Canvas;", "plugin-gallery_release"})
    public static final class c extends RecyclerView.h {
        private final Paint paint = new Paint();
        private final int xkq;
        final /* synthetic */ GalleryPickerFragment xkr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(GalleryPickerFragment galleryPickerFragment) {
            this.xkr = galleryPickerFragment;
            AppMethodBeat.i(164813);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            this.xkq = context.getResources().getColor(R.color.afp);
            this.paint.setColor(this.xkq);
            this.paint.setStrokeWidth(6.4f);
            this.paint.setStyle(Paint.Style.STROKE);
            AppMethodBeat.o(164813);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(164811);
            p.h(rect, "outRect");
            p.h(view, "view");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            super.a(rect, view, recyclerView, sVar);
            int bx = RecyclerView.bx(view);
            if (bx % 4 == 0) {
                rect.left = 4;
            }
            rect.right = 4;
            rect.bottom = 4;
            if (bx < 0) {
                AppMethodBeat.o(164811);
                return;
            }
            if (4 > bx) {
                rect.top = 4;
            }
            AppMethodBeat.o(164811);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(164812);
            p.h(canvas, "c");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            RecyclerView.v ch = recyclerView.ch(this.xkr.xkn);
            View view = ch != null ? ch.aus : null;
            if (view != null) {
                canvas.drawRect(new Rect(view.getLeft() + 2, view.getTop() + 2, view.getRight() - 2, view.getBottom() - 2), this.paint);
            }
            super.a(canvas, recyclerView, sVar);
            AppMethodBeat.o(164812);
        }
    }

    @Override // com.tencent.mm.plugin.gallery.picker.a.a.d
    public final boolean d(GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(164830);
        p.h(mediaItem, "media");
        Log.i("MicroMsg.GalleryPickerFragment", "[onItemLongClick] media=" + mediaItem.toSimpleString());
        AppMethodBeat.o(164830);
        return true;
    }

    @Override // com.tencent.mm.plugin.gallery.picker.a.a.c
    public final void e(GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(164833);
        p.h(mediaItem, "media");
        Log.i("MicroMsg.GalleryPickerFragment", "[onItemClick] media=" + mediaItem.toSimpleString());
        if (this.vML.size() < 9 || this.vML.contains(mediaItem)) {
            f(mediaItem);
            AppBarLayout appBarLayout = this.xkh;
            if (appBarLayout == null) {
                p.btv("appBarLayout");
            }
            appBarLayout.bO();
            RecyclerView recyclerView = this.xkf;
            if (recyclerView == null) {
                p.btv("galleryView");
            }
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
                AppMethodBeat.o(164833);
                throw tVar;
            }
            RecyclerView.v vVar = ((com.tencent.mm.view.recyclerview.g) adapter).V(mediaItem.xiZ, false);
            if (!(vVar instanceof com.tencent.mm.ui.base.a.b)) {
                vVar = null;
            }
            com.tencent.mm.ui.base.a.b bVar = (com.tencent.mm.ui.base.a.b) vVar;
            if (bVar != null && !this.xkc.xkE.contains(mediaItem) && this.vML.size() < 9) {
                ((MediaItemView) bVar.getView()).py(true);
            }
            AppMethodBeat.o(164833);
            return;
        }
        AppMethodBeat.o(164833);
    }

    private final void dRA() {
        AppMethodBeat.i(164834);
        for (T t : this.vML) {
            RecyclerView recyclerView = this.xkf;
            if (recyclerView == null) {
                p.btv("galleryView");
            }
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
                AppMethodBeat.o(164834);
                throw tVar;
            }
            RecyclerView.v vVar = ((com.tencent.mm.view.recyclerview.g) adapter).V(t.xiZ, false);
            if (!(vVar instanceof com.tencent.mm.ui.base.a.b)) {
                vVar = null;
            }
            com.tencent.mm.ui.base.a.b bVar = (com.tencent.mm.ui.base.a.b) vVar;
            if (bVar != null) {
                this.xkc.b(bVar.lR(), 1);
            }
        }
        AppMethodBeat.o(164834);
    }

    private final void a(GalleryItem.MediaItem mediaItem, boolean z) {
        AppMethodBeat.i(164835);
        if (this.vML.isEmpty()) {
            MMMediaCropLayout mMMediaCropLayout = this.xkg;
            if (mMMediaCropLayout == null) {
                p.btv("previewContainer");
            }
            if (mMMediaCropLayout.xmE) {
                MMMediaCropLayout mMMediaCropLayout2 = this.xkg;
                if (mMMediaCropLayout2 == null) {
                    p.btv("previewContainer");
                }
                MMMediaCropLayout.b(mMMediaCropLayout2);
                AppMethodBeat.o(164835);
                return;
            }
        }
        if (this.vML.size() == 1) {
            MMMediaCropLayout mMMediaCropLayout3 = this.xkg;
            if (mMMediaCropLayout3 == null) {
                p.btv("previewContainer");
            }
            if (mMMediaCropLayout3.xmE) {
                GalleryItem.MediaItem mediaItem2 = (GalleryItem.MediaItem) kotlin.a.j.ks(this.vML);
                if (z) {
                    if (mediaItem == null) {
                        AppMethodBeat.o(164835);
                        return;
                    } else if (mediaItem.xiZ == mediaItem2.xiZ) {
                        MMMediaCropLayout mMMediaCropLayout4 = this.xkg;
                        if (mMMediaCropLayout4 == null) {
                            p.btv("previewContainer");
                        }
                        MMMediaCropLayout.b(mMMediaCropLayout4);
                    }
                }
            }
        }
        AppMethodBeat.o(164835);
    }

    private final void f(GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(164836);
        MMMediaCropLayout mMMediaCropLayout = this.xkg;
        if (mMMediaCropLayout == null) {
            p.btv("previewContainer");
        }
        long currentPreviewMediaId = mMMediaCropLayout.getCurrentPreviewMediaId();
        if (this.vML.size() == 2) {
            MMMediaCropLayout mMMediaCropLayout2 = this.xkg;
            if (mMMediaCropLayout2 == null) {
                p.btv("previewContainer");
            }
            if (!mMMediaCropLayout2.xmE) {
                MMMediaCropLayout mMMediaCropLayout3 = this.xkg;
                if (mMMediaCropLayout3 == null) {
                    p.btv("previewContainer");
                }
                MMMediaCropLayout.a(mMMediaCropLayout3);
            }
        }
        a(mediaItem, true);
        if (mediaItem.getType() == 2) {
            h(mediaItem);
        } else {
            g(mediaItem);
        }
        X(currentPreviewMediaId, mediaItem.xiZ);
        AppMethodBeat.o(164836);
    }

    @Override // android.support.v4.app.Fragment
    public final void onResume() {
        AppMethodBeat.i(164837);
        super.onResume();
        MMMediaCropLayout mMMediaCropLayout = this.xkg;
        if (mMMediaCropLayout == null) {
            p.btv("previewContainer");
        }
        mMMediaCropLayout.getVideoView().onUIResume();
        AppMethodBeat.o(164837);
    }

    @Override // android.support.v4.app.Fragment
    public final void onPause() {
        AppMethodBeat.i(164838);
        super.onPause();
        MMMediaCropLayout mMMediaCropLayout = this.xkg;
        if (mMMediaCropLayout == null) {
            p.btv("previewContainer");
        }
        mMMediaCropLayout.getVideoView().onUIPause();
        AppMethodBeat.o(164838);
    }

    private final void g(GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(164839);
        if (!this.xkm || this.xkl == 1) {
            MMMediaCropLayout mMMediaCropLayout = this.xkg;
            if (mMMediaCropLayout == null) {
                p.btv("previewContainer");
            }
            MMMediaCropLayout.a(mMMediaCropLayout, mediaItem);
            AppMethodBeat.o(164839);
            return;
        }
        AppMethodBeat.o(164839);
    }

    private final void h(GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(164840);
        if (!this.xkm || this.xkl == 2) {
            MMMediaCropLayout mMMediaCropLayout = this.xkg;
            if (mMMediaCropLayout == null) {
                p.btv("previewContainer");
            }
            MMMediaCropLayout.b(mMMediaCropLayout, mediaItem);
            AppMethodBeat.o(164840);
            return;
        }
        AppMethodBeat.o(164840);
    }

    private final void X(long j2, long j3) {
        AppMethodBeat.i(164841);
        Log.i("MicroMsg.GalleryPickerFragment", "[updatePreviewSelectedStatus] last=" + j2 + " current=" + j3);
        RecyclerView recyclerView = this.xkf;
        if (recyclerView == null) {
            p.btv("galleryView");
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(164841);
            throw tVar;
        }
        RecyclerView.v vVar = ((com.tencent.mm.view.recyclerview.g) adapter).V(j3, false);
        if (vVar != null) {
            this.xkn = vVar.lR();
            RecyclerView recyclerView2 = this.xkf;
            if (recyclerView2 == null) {
                p.btv("galleryView");
            }
            RecyclerView.a adapter2 = recyclerView2.getAdapter();
            if (adapter2 != null) {
                adapter2.ci(vVar.lR());
            }
        }
        RecyclerView recyclerView3 = this.xkf;
        if (recyclerView3 == null) {
            p.btv("galleryView");
        }
        RecyclerView.a adapter3 = recyclerView3.getAdapter();
        if (adapter3 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(164841);
            throw tVar2;
        }
        RecyclerView.v vVar2 = ((com.tencent.mm.view.recyclerview.g) adapter3).V(j2, false);
        if (vVar2 != null) {
            RecyclerView recyclerView4 = this.xkf;
            if (recyclerView4 == null) {
                p.btv("galleryView");
            }
            RecyclerView.a adapter4 = recyclerView4.getAdapter();
            if (adapter4 != null) {
                adapter4.ci(vVar2.lR());
                AppMethodBeat.o(164841);
                return;
            }
        }
        AppMethodBeat.o(164841);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h implements View.OnClickListener {
        final /* synthetic */ GalleryPickerFragment xkr;

        h(GalleryPickerFragment galleryPickerFragment) {
            this.xkr = galleryPickerFragment;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(164820);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initPreviewContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            GalleryPickerFragment.h(this.xkr).bO();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initPreviewContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(164820);
        }
    }

    public static final /* synthetic */ void b(GalleryPickerFragment galleryPickerFragment) {
        AppMethodBeat.i(164844);
        k kVar = new k(galleryPickerFragment);
        RecyclerView recyclerView = galleryPickerFragment.xkf;
        if (recyclerView == null) {
            p.btv("galleryView");
        }
        recyclerView.postDelayed(kVar, 200);
        AppMethodBeat.o(164844);
    }
}
