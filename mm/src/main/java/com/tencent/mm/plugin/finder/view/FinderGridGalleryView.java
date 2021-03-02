package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.i;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 72\u00020\u00012\u00020\u00022\u00020\u0003:\u000278B\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB#\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010%\u001a\u00020&H\u0002J(\u0010'\u001a\u00020&2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\u0006\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020-H\u0016J(\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000bH\u0016J\u000e\u00103\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u00104\u001a\u00020&2\u0006\u0010$\u001a\u00020\u000bJ\u000e\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\u001fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumAdapter$IOnSelectItemChanged;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MediaType_QueryArray", "", "MediaType_StringArray", "TAG", "", "albumAdapter", "Lcom/tencent/mm/plugin/gallery/ui/AlbumAdapter;", "columnNum", "gridView", "Landroid/widget/GridView;", "mediaTypePopupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "mediaTypeTv", "Landroid/widget/TextView;", "multiSelect", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "multiSelectLimit", "onItemSelectListener", "Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView$OnItemSelectListener;", "queryService", "Lcom/tencent/mm/plugin/gallery/model/MediaQueryService;", "queryTicket", "", "selectLimit", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "onQueryMediaFinished", "mediaItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "ticket", "isFirstNotify", "", "onSelectItemChanged", "selectedCount", "position", "selectPosition", "type", "setColumnNum", "setMaxSelectLimit", "setOnItemSelectListener", "onItemSelectedListener", "Companion", "OnItemSelectListener", "plugin-finder_release"})
public final class FinderGridGalleryView extends LinearLayout implements i.c, a.e {
    private static final String wnf = wnf;
    public static final a wng = new a((byte) 0);
    private final String TAG = "Finder.FinderGridGalleryView";
    private long qVk;
    private final int[] wmT = {R.string.coz, R.string.cp1, R.string.cp0};
    private final int[] wmU = {1, 2, 3};
    private TextView wmV;
    private GridView wmW;
    private MMSwitchBtn wmX;
    private com.tencent.mm.plugin.gallery.ui.a wmY;
    private o wmZ;
    private com.tencent.mm.ui.widget.b.a wna;
    private b wnb;
    private int wnc = 4;
    private int wnd = 1;
    private int wne = 9;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView$OnItemSelectListener;", "", "onItemClick", "", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemSelectedChanged", "selected", "Landroid/os/Bundle;", "plugin-finder_release"})
    public interface b {
    }

    public static final /* synthetic */ com.tencent.mm.plugin.gallery.ui.a c(FinderGridGalleryView finderGridGalleryView) {
        AppMethodBeat.i(168365);
        com.tencent.mm.plugin.gallery.ui.a aVar = finderGridGalleryView.wmY;
        if (aVar == null) {
            p.btv("albumAdapter");
        }
        AppMethodBeat.o(168365);
        return aVar;
    }

    public static final /* synthetic */ TextView e(FinderGridGalleryView finderGridGalleryView) {
        AppMethodBeat.i(168366);
        TextView textView = finderGridGalleryView.wmV;
        if (textView == null) {
            p.btv("mediaTypeTv");
        }
        AppMethodBeat.o(168366);
        return textView;
    }

    public static final /* synthetic */ o f(FinderGridGalleryView finderGridGalleryView) {
        AppMethodBeat.i(168367);
        o oVar = finderGridGalleryView.wmZ;
        if (oVar == null) {
            p.btv("queryService");
        }
        AppMethodBeat.o(168367);
        return oVar;
    }

    public static final /* synthetic */ com.tencent.mm.ui.widget.b.a i(FinderGridGalleryView finderGridGalleryView) {
        AppMethodBeat.i(168368);
        com.tencent.mm.ui.widget.b.a aVar = finderGridGalleryView.wna;
        if (aVar == null) {
            p.btv("mediaTypePopupMenu");
        }
        AppMethodBeat.o(168368);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderGridGalleryView$Companion;", "", "()V", "SELECTED_MEDIA_ITEMS", "", "getSELECTED_MEDIA_ITEMS", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(168364);
        AppMethodBeat.o(168364);
    }

    public FinderGridGalleryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(168362);
        init();
        AppMethodBeat.o(168362);
    }

    public FinderGridGalleryView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(168363);
        init();
        AppMethodBeat.o(168363);
    }

    private final void init() {
        AppMethodBeat.i(168357);
        View inflate = View.inflate(getContext(), R.layout.ac4, this);
        View findViewById = inflate.findViewById(R.id.fc3);
        p.g(findViewById, "contentView.findViewById(R.id.media_type_tv)");
        this.wmV = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.fnh);
        p.g(findViewById2, "contentView.findViewById(R.id.multi_select_switch)");
        this.wmX = (MMSwitchBtn) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.fbl);
        p.g(findViewById3, "contentView.findViewById(R.id.media_grid_view)");
        this.wmW = (GridView) findViewById3;
        GridView gridView = this.wmW;
        if (gridView == null) {
            p.btv("gridView");
        }
        gridView.setNumColumns(this.wnc);
        TextView textView = this.wmV;
        if (textView == null) {
            p.btv("mediaTypeTv");
        }
        textView.setText(this.wmT[0]);
        this.wmZ = new o();
        o oVar = this.wmZ;
        if (oVar == null) {
            p.btv("queryService");
        }
        oVar.setQueryType(this.wmU[0]);
        o oVar2 = this.wmZ;
        if (oVar2 == null) {
            p.btv("queryService");
        }
        oVar2.a(this);
        this.qVk = System.currentTimeMillis();
        o oVar3 = this.wmZ;
        if (oVar3 == null) {
            p.btv("queryService");
        }
        oVar3.ax("", this.qVk);
        this.wmY = new com.tencent.mm.plugin.gallery.ui.a(getContext(), this);
        com.tencent.mm.plugin.gallery.ui.a aVar = this.wmY;
        if (aVar == null) {
            p.btv("albumAdapter");
        }
        o oVar4 = this.wmZ;
        if (oVar4 == null) {
            p.btv("queryService");
        }
        aVar.setQueryType(oVar4.dRq());
        com.tencent.mm.plugin.gallery.ui.a aVar2 = this.wmY;
        if (aVar2 == null) {
            p.btv("albumAdapter");
        }
        aVar2.setSelectLimitCount(this.wnd);
        MMSwitchBtn mMSwitchBtn = this.wmX;
        if (mMSwitchBtn == null) {
            p.btv("multiSelect");
        }
        mMSwitchBtn.setSwitchListener(new c(this));
        Context context = getContext();
        TextView textView2 = this.wmV;
        if (textView2 == null) {
            p.btv("mediaTypeTv");
        }
        this.wna = new com.tencent.mm.ui.widget.b.a(context, textView2);
        com.tencent.mm.ui.widget.b.a aVar3 = this.wna;
        if (aVar3 == null) {
            p.btv("mediaTypePopupMenu");
        }
        aVar3.a(new d(this));
        com.tencent.mm.ui.widget.b.a aVar4 = this.wna;
        if (aVar4 == null) {
            p.btv("mediaTypePopupMenu");
        }
        aVar4.a(new e(this));
        TextView textView3 = this.wmV;
        if (textView3 == null) {
            p.btv("mediaTypeTv");
        }
        textView3.setOnClickListener(new f(this));
        GridView gridView2 = this.wmW;
        if (gridView2 == null) {
            p.btv("gridView");
        }
        gridView2.setOnItemClickListener(new g(this));
        AppMethodBeat.o(168357);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "checked", "", "onStatusChange"})
    public static final class c implements MMSwitchBtn.a {
        final /* synthetic */ FinderGridGalleryView wnh;

        c(FinderGridGalleryView finderGridGalleryView) {
            this.wnh = finderGridGalleryView;
        }

        @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
        public final void onStatusChange(boolean z) {
            int i2;
            AppMethodBeat.i(168351);
            FinderGridGalleryView finderGridGalleryView = this.wnh;
            if (z) {
                i2 = this.wnh.wne;
            } else {
                i2 = 1;
            }
            finderGridGalleryView.wnd = i2;
            if (FinderGridGalleryView.c(this.wnh).dRO() > this.wnh.wnd) {
                FinderGridGalleryView.c(this.wnh).dRM().clear();
                FinderGridGalleryView.c(this.wnh).notifyDataSetChanged();
            }
            FinderGridGalleryView.c(this.wnh).setSelectLimitCount(this.wnh.wnd);
            AppMethodBeat.o(168351);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
    public static final class d implements View.OnCreateContextMenuListener {
        final /* synthetic */ FinderGridGalleryView wnh;

        d(FinderGridGalleryView finderGridGalleryView) {
            this.wnh = finderGridGalleryView;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(168352);
            contextMenu.clear();
            for (int i2 : this.wnh.wmT) {
                contextMenu.add(i2);
            }
            AppMethodBeat.o(168352);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class e implements o.g {
        final /* synthetic */ FinderGridGalleryView wnh;

        e(FinderGridGalleryView finderGridGalleryView) {
            this.wnh = finderGridGalleryView;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(168353);
            FinderGridGalleryView.e(this.wnh).setText(this.wnh.wmT[i2]);
            FinderGridGalleryView.f(this.wnh).setQueryType(this.wnh.wmU[i2]);
            FinderGridGalleryView.c(this.wnh).clear();
            FinderGridGalleryView.c(this.wnh).setQueryType(FinderGridGalleryView.f(this.wnh).dRq());
            this.wnh.qVk = System.currentTimeMillis();
            FinderGridGalleryView.f(this.wnh).ax("", this.wnh.qVk);
            AppMethodBeat.o(168353);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class f implements View.OnClickListener {
        final /* synthetic */ FinderGridGalleryView wnh;

        f(FinderGridGalleryView finderGridGalleryView) {
            this.wnh = finderGridGalleryView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168354);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderGridGalleryView.i(this.wnh).gTx();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168354);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
    public static final class g implements AdapterView.OnItemClickListener {
        final /* synthetic */ FinderGridGalleryView wnh;

        g(FinderGridGalleryView finderGridGalleryView) {
            this.wnh = finderGridGalleryView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(168355);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            if (this.wnh.wnb != null) {
                p.g(FinderGridGalleryView.c(this.wnh).dRN().get(i2), "albumAdapter.allMediaItems[position]");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$init$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(168355);
        }
    }

    public final void setColumnNum(int i2) {
        AppMethodBeat.i(168358);
        this.wnc = i2;
        GridView gridView = this.wmW;
        if (gridView == null) {
            p.btv("gridView");
        }
        gridView.setNumColumns(i2);
        AppMethodBeat.o(168358);
    }

    public final void setMaxSelectLimit(int i2) {
        this.wne = i2;
    }

    public final void setOnItemSelectListener(b bVar) {
        AppMethodBeat.i(168359);
        p.h(bVar, "onItemSelectedListener");
        this.wnb = bVar;
        AppMethodBeat.o(168359);
    }

    @Override // com.tencent.mm.plugin.gallery.ui.a.e
    public final void ah(int i2, int i3, int i4) {
        AppMethodBeat.i(168360);
        Log.i(this.TAG, "selected  " + i2 + " items");
        if (this.wnb != null) {
            Bundle bundle = new Bundle();
            String str = wnf;
            com.tencent.mm.plugin.gallery.ui.a aVar = this.wmY;
            if (aVar == null) {
                p.btv("albumAdapter");
            }
            bundle.putParcelableArrayList(str, aVar.dRM());
        }
        AppMethodBeat.o(168360);
    }

    @Override // com.tencent.mm.plugin.gallery.model.i.c
    public final void b(LinkedList<GalleryItem.MediaItem> linkedList, long j2, boolean z) {
        AppMethodBeat.i(168361);
        Log.i(this.TAG, "ticket " + j2 + " query finished  " + (linkedList != null ? Integer.valueOf(linkedList.size()) : null) + " medias");
        if (this.qVk == j2 && linkedList != null) {
            post(new h(this, linkedList));
        }
        AppMethodBeat.o(168361);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderGridGalleryView$onQueryMediaFinished$1$1"})
    static final class h implements Runnable {
        final /* synthetic */ FinderGridGalleryView wnh;
        final /* synthetic */ LinkedList wni;

        h(FinderGridGalleryView finderGridGalleryView, LinkedList linkedList) {
            this.wnh = finderGridGalleryView;
            this.wni = linkedList;
        }

        public final void run() {
            AppMethodBeat.i(168356);
            FinderGridGalleryView.c(this.wnh).clear();
            FinderGridGalleryView.c(this.wnh).aM(this.wni);
            FinderGridGalleryView.c(this.wnh).notifyDataSetChanged();
            AppMethodBeat.o(168356);
        }
    }
}
