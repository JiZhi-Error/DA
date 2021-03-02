package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.a.a;
import android.support.v7.widget.v;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.ui.h;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.a.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \"2\u00020\u0001:\u0004\"#$%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0018J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u001e\u0010 \u001a\u00020\u001a2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/support/v7/widget/RecyclerView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$FooterPreviewAdapter;", "previewId", "", "getRecycler", "()Landroid/support/v7/widget/RecyclerView;", "selectPathList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "getSelectPathList", "()Ljava/util/ArrayList;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getCurrentId", "", "initRecyclerView", "", "onDetach", "select", FirebaseAnalytics.b.INDEX, "setVisibility", "visibility", "updateList", "list", "Companion", "FooterPreviewAdapter", "ItemTouchHelperCallback", "PreviewItemView", "plugin-vlog_release"})
public final class c implements t {
    public static final a GGD = new a((byte) 0);
    final ArrayList<GalleryItem.MediaItem> GGB = new ArrayList<>();
    private b GGC;
    private final RecyclerView gTW;
    private long vLr;
    com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;

    static {
        AppMethodBeat.i(191210);
        AppMethodBeat.o(191210);
    }

    public c(RecyclerView recyclerView, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(recyclerView, "recycler");
        p.h(dVar, "status");
        AppMethodBeat.i(191209);
        this.gTW = recyclerView;
        this.wgr = dVar;
        this.gTW.setHasFixedSize(true);
        this.gTW.getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.setOrientation(0);
        linearLayoutManager.setItemPrefetchEnabled(true);
        this.gTW.setLayoutManager(linearLayoutManager);
        this.gTW.setItemAnimator(new v());
        this.gTW.b(new e(this));
        this.GGC = new b();
        b bVar = this.GGC;
        if (bVar == null) {
            p.btv("adapter");
        }
        bVar.setItems(this.GGB);
        b bVar2 = this.GGC;
        if (bVar2 == null) {
            p.btv("adapter");
        }
        new android.support.v7.widget.a.a(new C1861c(this, bVar2)).f(this.gTW);
        RecyclerView recyclerView2 = this.gTW;
        b bVar3 = this.GGC;
        if (bVar3 == null) {
            p.btv("adapter");
        }
        recyclerView2.setAdapter(bVar3);
        b bVar4 = this.GGC;
        if (bVar4 == null) {
            p.btv("adapter");
        }
        bVar4.OXb = new f(this);
        this.gTW.setVisibility(0);
        AppMethodBeat.o(191209);
    }

    public static final /* synthetic */ b b(c cVar) {
        AppMethodBeat.i(191212);
        b bVar = cVar.GGC;
        if (bVar == null) {
            p.btv("adapter");
        }
        AppMethodBeat.o(191212);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(191211);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191211);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void aU(ArrayList<GalleryItem.MediaItem> arrayList) {
        AppMethodBeat.i(191204);
        p.h(arrayList, "list");
        Log.i("MicroMsg.EditFooterRecyclerPlugin", "updateList = " + arrayList.size());
        this.GGB.clear();
        this.GGB.addAll(arrayList);
        b bVar = this.GGC;
        if (bVar == null) {
            p.btv("adapter");
        }
        bVar.setItems(this.GGB);
        b bVar2 = this.GGC;
        if (bVar2 == null) {
            p.btv("adapter");
        }
        bVar2.notifyDataSetChanged();
        AppMethodBeat.o(191204);
    }

    public final void select(int i2) {
        AppMethodBeat.i(191205);
        int size = this.GGB.size();
        if (i2 < 0) {
            AppMethodBeat.o(191205);
        } else if (size <= i2) {
            AppMethodBeat.o(191205);
        } else {
            GalleryItem.MediaItem mediaItem = this.GGB.get(i2);
            this.vLr = mediaItem.xiZ;
            Bundle bundle = new Bundle();
            bundle.putParcelable("PARAM_VLOG_MULTI_IMAGE_SELECT_VALUE", mediaItem);
            this.wgr.a(d.c.BWa, bundle);
            AppMethodBeat.o(191205);
        }
    }

    public final int fCS() {
        AppMethodBeat.i(191206);
        int i2 = 0;
        for (T t : this.GGB) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            if (t.xiZ == this.vLr) {
                AppMethodBeat.o(191206);
                return i2;
            }
            i2 = i3;
        }
        AppMethodBeat.o(191206);
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$initRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "offset", "", "getOffset", "()F", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-vlog_release"})
    public static final class e extends RecyclerView.h {
        final /* synthetic */ c GGE;
        private final float offset;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(c cVar) {
            this.GGE = cVar;
            AppMethodBeat.i(191201);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            this.offset = context.getResources().getDimension(R.dimen.cb);
            AppMethodBeat.o(191201);
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(191200);
            p.h(rect, "outRect");
            p.h(view, "view");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            super.a(rect, view, recyclerView, sVar);
            RecyclerView.v bi = recyclerView.bi(view);
            p.g(bi, "parent.getChildViewHolder(view)");
            int lR = bi.lR();
            rect.left = (int) this.offset;
            if (lR + 1 == this.GGE.GGB.size()) {
                rect.right = (int) this.offset;
            }
            AppMethodBeat.o(191200);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$initRecyclerView$2", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$OnItemClickListeners;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "item", "onItemLongClick", "", "plugin-vlog_release"})
    public static final class f implements a.AbstractC2080a<GalleryItem.MediaItem> {
        final /* synthetic */ c GGE;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(c cVar) {
            this.GGE = cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, java.lang.Object] */
        @Override // com.tencent.mm.ui.base.a.a.AbstractC2080a
        public final /* synthetic */ void a(int i2, View view, GalleryItem.MediaItem mediaItem) {
            AppMethodBeat.i(191202);
            GalleryItem.MediaItem mediaItem2 = mediaItem;
            p.h(view, "view");
            p.h(mediaItem2, "item");
            this.GGE.vLr = mediaItem2.xiZ;
            c.b(this.GGE).notifyDataSetChanged();
            Bundle bundle = new Bundle();
            bundle.putParcelable("PARAM_VLOG_MULTI_IMAGE_SELECT_VALUE", mediaItem2);
            this.GGE.wgr.a(d.c.BWa, bundle);
            AppMethodBeat.o(191202);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
        @Override // com.tencent.mm.ui.base.a.a.AbstractC2080a
        public final /* synthetic */ boolean a(View view, GalleryItem.MediaItem mediaItem) {
            AppMethodBeat.i(191203);
            p.h(view, "view");
            p.h(mediaItem, "item");
            AppMethodBeat.o(191203);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191207);
        this.gTW.setVisibility(i2);
        AppMethodBeat.o(191207);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
        AppMethodBeat.i(191208);
        b bVar = this.GGC;
        if (bVar == null) {
            p.btv("adapter");
        }
        bVar.clearItems();
        AppMethodBeat.o(191208);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u001c\u0010\u0013\u001a\u00060\u0003R\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0014¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$FooterPreviewAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;)V", "getItemId", "", "position", "", "onBindViewHolder", "", "viewWrapper", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "i", "holder", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-vlog_release"})
    public final class b extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, d> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            AppMethodBeat.i(191182);
            au(true);
            AppMethodBeat.o(191182);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // com.tencent.mm.ui.base.a.a, android.support.v7.widget.RecyclerView.a
        public final /* bridge */ /* synthetic */ void a(com.tencent.mm.ui.base.a.b bVar, int i2) {
            AppMethodBeat.i(191178);
            a(bVar, i2);
            AppMethodBeat.o(191178);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
        @Override // com.tencent.mm.ui.base.a.a, android.support.v7.widget.RecyclerView.a
        public final /* bridge */ /* synthetic */ void a(com.tencent.mm.ui.base.a.b bVar, int i2, List list) {
            AppMethodBeat.i(191180);
            a(bVar, i2, (List<Object>) list);
            AppMethodBeat.o(191180);
        }

        /* Return type fixed from 'android.view.View' to match base method */
        @Override // com.tencent.mm.ui.base.a.a
        public final /* synthetic */ d l(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(191176);
            p.h(viewGroup, "parent");
            c cVar = c.this;
            Context context = viewGroup.getContext();
            p.g(context, "parent.context");
            d dVar = new d(cVar, context);
            AppMethodBeat.o(191176);
            return dVar;
        }

        @Override // com.tencent.mm.ui.base.a.a
        public final void a(com.tencent.mm.ui.base.a.b bVar, int i2) {
            AppMethodBeat.i(191177);
            p.h(bVar, "viewWrapper");
            super.a(bVar, i2);
            d dVar = (d) bVar.getView();
            GalleryItem.MediaItem mediaItem = (GalleryItem.MediaItem) getItemAtPosition(i2);
            ImageView imageView = dVar.getImageView();
            p.g(mediaItem, "media");
            h.a(imageView, mediaItem.getType(), mediaItem.aQn(), mediaItem.dRh(), mediaItem.xiZ, a.GGF, mediaItem.xja);
            p.g(dVar, "itemView");
            dVar.setSelected(mediaItem.xiZ == c.this.vLr);
            dVar.setFocusable(mediaItem.xiZ == c.this.vLr);
            AppMethodBeat.o(191177);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "attached"})
        public static final class a implements h.a {
            public static final a GGF = new a();

            static {
                AppMethodBeat.i(191175);
                AppMethodBeat.o(191175);
            }

            a() {
            }

            @Override // com.tencent.mm.plugin.gallery.ui.h.a
            public final void dSs() {
            }
        }

        @Override // com.tencent.mm.ui.base.a.a
        public final void a(com.tencent.mm.ui.base.a.b bVar, int i2, List<Object> list) {
            AppMethodBeat.i(191179);
            p.h(bVar, "holder");
            p.h(list, "payloads");
            if (list.isEmpty()) {
                a(bVar, i2);
            }
            AppMethodBeat.o(191179);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final long getItemId(int i2) {
            AppMethodBeat.i(191181);
            long j2 = ((GalleryItem.MediaItem) getItemAtPosition(i2)).xiZ;
            AppMethodBeat.o(191181);
            return j2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0005R\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J@\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u001bH\u0016J \u0010$\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0016H\u0016J\u001a\u0010&\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\"\u001a\u00020\tH\u0016J\u0018\u0010'\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\tH\u0016R\u001e\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0005R\u00020\u00060\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback;", "Landroid/support/v7/widget/helper/ItemTouchHelper$Callback;", "adapter", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;)V", "lastVisiblePos", "", "getLastVisiblePos", "()I", "setLastVisiblePos", "(I)V", "mBeginDragPos", "mCurPositionInBar", "mEndDragPos", "clearView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getMoveThreshold", "", "getMovementFlags", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSelectedChanged", "onSwiped", TencentLocation.EXTRA_DIRECTION, "plugin-vlog_release"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.c$c  reason: collision with other inner class name */
    public final class C1861c extends a.AbstractC0053a {
        final /* synthetic */ c GGE;
        int eeE = -1;
        private final com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, d> vLA;
        private int vLx = -1;
        private int vLy = -1;
        private int vLz;

        public C1861c(c cVar, com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, d> aVar) {
            p.h(aVar, "adapter");
            this.GGE = cVar;
            AppMethodBeat.i(191196);
            this.vLA = aVar;
            AppMethodBeat.o(191196);
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final boolean a(RecyclerView recyclerView, RecyclerView.v vVar, RecyclerView.v vVar2) {
            AppMethodBeat.i(191189);
            p.h(recyclerView, "recyclerView");
            p.h(vVar, "viewHolder");
            p.h(vVar2, "target");
            int lR = vVar.lR();
            int lR2 = vVar2.lR();
            Log.d("MicroMsg.EditFooterRecyclerPlugin", "[onMove] from=" + lR + " to=" + lR2);
            com.tencent.mm.plugin.gallery.a.d.swap(this.GGE.GGB, lR, lR2);
            this.vLA.ar(lR, lR2);
            this.vLy = lR2;
            AppMethodBeat.o(191189);
            return true;
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final void f(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(191190);
            super.f(vVar, i2);
            if (vVar != null) {
                View view = vVar.aus;
                p.g(view, "viewHolder.itemView");
                Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.d9);
                loadAnimation.setAnimationListener(new b(this, vVar, i2));
                vVar.aus.startAnimation(loadAnimation);
            }
            AppMethodBeat.o(191190);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback$onSelectedChanged$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-vlog_release"})
        /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.c$c$b */
        public static final class b implements Animation.AnimationListener {
            final /* synthetic */ C1861c GGG;
            final /* synthetic */ RecyclerView.v vLD;
            final /* synthetic */ int vLE;

            b(C1861c cVar, RecyclerView.v vVar, int i2) {
                this.GGG = cVar;
                this.vLD = vVar;
                this.vLE = i2;
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(191186);
                p.h(animation, "animation");
                View view = this.vLD.aus;
                p.g(view, "viewHolder.itemView");
                view.setTag(new Object());
                if (this.vLE == 2) {
                    this.GGG.vLy = this.vLD.lR();
                    this.GGG.vLx = this.GGG.vLy;
                    this.GGG.eeE = this.GGG.vLz;
                }
                AppMethodBeat.o(191186);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(191187);
                p.h(animation, "animation");
                View view = this.vLD.aus;
                p.g(view, "viewHolder.itemView");
                view.setTag(null);
                AppMethodBeat.o(191187);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.i(191188);
                p.h(animation, "animation");
                AppMethodBeat.o(191188);
            }
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final void d(RecyclerView recyclerView, RecyclerView.v vVar) {
            AppMethodBeat.i(191191);
            p.h(recyclerView, "recyclerView");
            p.h(vVar, "viewHolder");
            super.d(recyclerView, vVar);
            Animation loadAnimation = AnimationUtils.loadAnimation(recyclerView.getContext(), R.anim.d8);
            loadAnimation.setAnimationListener(new a(this, vVar));
            vVar.aus.startAnimation(loadAnimation);
            AppMethodBeat.o(191191);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback$clearView$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-vlog_release"})
        /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.c$c$a */
        public static final class a implements Animation.AnimationListener {
            final /* synthetic */ C1861c GGG;
            final /* synthetic */ RecyclerView.v vLC;

            a(C1861c cVar, RecyclerView.v vVar) {
                this.GGG = cVar;
                this.vLC = vVar;
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(191183);
                p.h(animation, "animation");
                View view = this.vLC.aus;
                p.g(view, "viewHolder.itemView");
                view.setTag(new Object());
                AppMethodBeat.o(191183);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(191184);
                p.h(animation, "animation");
                View view = this.vLC.aus;
                p.g(view, "viewHolder.itemView");
                view.setTag(null);
                Log.d("MicroMsg.EditFooterRecyclerPlugin", "finally change from=" + this.GGG.vLx + " to=" + this.GGG.vLy);
                AppMethodBeat.o(191184);
            }

            public final void onAnimationRepeat(Animation animation) {
                AppMethodBeat.i(191185);
                p.h(animation, "animation");
                AppMethodBeat.o(191185);
            }
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final void N(RecyclerView.v vVar) {
            AppMethodBeat.i(191192);
            p.h(vVar, "viewHolder");
            AppMethodBeat.o(191192);
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final float M(RecyclerView.v vVar) {
            AppMethodBeat.i(191193);
            p.h(vVar, "viewHolder");
            AppMethodBeat.o(191193);
            return 0.295858f;
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.v vVar, float f2, float f3, int i2, boolean z) {
            AppMethodBeat.i(191194);
            p.h(canvas, "c");
            p.h(recyclerView, "recyclerView");
            p.h(vVar, "viewHolder");
            super.a(canvas, recyclerView, vVar, f2 / 1.3f, f3 / 1.3f, i2, z);
            AppMethodBeat.o(191194);
        }

        @Override // android.support.v7.widget.a.a.AbstractC0053a
        public final int a(RecyclerView recyclerView, RecyclerView.v vVar) {
            AppMethodBeat.i(191195);
            p.h(recyclerView, "recyclerView");
            p.h(vVar, "viewHolder");
            int db = a.AbstractC0053a.db(51);
            AppMethodBeat.o(191195);
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

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001eH\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusedView", "Landroid/view/View;", "getFocusedView", "()Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "maskView", "getMaskView", "orangeColor", "padding", "getPadding", "()I", "size", "getSize", "setFocusable", "", "focusable", "", "setSelected", "selected", "plugin-vlog_release"})
    public final class d extends FrameLayout {
        final /* synthetic */ c GGE;
        private final ImageView dKU = new ImageView(getContext());
        private final View maskView = new View(getContext());
        private final int padding;
        private final int size;
        private final int vLI;
        private final View vLJ = new View(getContext());

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(c cVar, Context context) {
            super(context);
            p.h(context, "context");
            AppMethodBeat.i(191199);
            this.GGE = cVar;
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            this.vLI = context2.getResources().getColor(R.color.a3c);
            Context context3 = getContext();
            p.g(context3, "context");
            this.padding = (int) context3.getResources().getDimension(R.dimen.bt);
            Context context4 = getContext();
            p.g(context4, "context");
            this.size = (int) context4.getResources().getDimension(R.dimen.cp);
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
            p.g(context5, "context");
            view.setBackgroundColor(context5.getResources().getColor(R.color.afz));
            this.maskView.setAlpha(0.5f);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
            layoutParams4.gravity = 17;
            setLayoutParams(layoutParams4);
            AppMethodBeat.o(191199);
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
            AppMethodBeat.i(191197);
            super.setFocusable(z);
            if (z) {
                this.vLJ.setVisibility(0);
                AppMethodBeat.o(191197);
                return;
            }
            this.vLJ.setVisibility(4);
            AppMethodBeat.o(191197);
        }

        public final void setSelected(boolean z) {
            AppMethodBeat.i(191198);
            super.setSelected(z);
            if (z) {
                this.maskView.setVisibility(4);
                AppMethodBeat.o(191198);
                return;
            }
            this.maskView.setVisibility(0);
            AppMethodBeat.o(191198);
        }
    }
}
