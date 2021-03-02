package com.tencent.mm.plugin.finder.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.MediaSelectedData;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment;
import com.tencent.mm.plugin.gallery.picker.b.b;
import com.tencent.mm.plugin.gallery.picker.view.MMMediaCropLayout;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0014J?\u0010\u001a\u001a\u00020\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b2'\u0010\u001c\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001e0\u001b¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00140\u001dH\u0002J\u0012\u0010\"\u001a\u00020\u00142\b\b\u0002\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderPostPickerUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "fromAppBrand", "", "mediaTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "processDialogRunnable", "Ljava/lang/Runnable;", "selectedMedias", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "tipDialog", "Landroid/app/Dialog;", "viewPager", "Landroid/support/v4/view/ViewPager;", "getLayoutId", "", "initView", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onGenerateMedia", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/model/MediaSelectedData;", "Lkotlin/ParameterName;", "name", "generateList", "showProcessDialog", "delay", "", "Companion", "plugin-finder_release"})
public final class FinderPostPickerUI extends MMFinderUI {
    public static final a vMN = new a((byte) 0);
    private HashMap _$_findViewCache;
    private Dialog tipDialog;
    private ViewPager uO;
    private final Runnable vJC = new g(this);
    private com.tencent.mm.plugin.gallery.picker.b.b vLu;
    private ArrayList<GalleryItem.MediaItem> vML = new ArrayList<>();
    private boolean vMM;

    static {
        AppMethodBeat.i(167496);
        AppMethodBeat.o(167496);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252591);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252591);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252590);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252590);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "isSuccessfully", "", "result", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderPostPickerUI$onGenerateMedia$1$1"})
    public static final class f extends q implements m<Boolean, b.f, x> {
        final /* synthetic */ kotlin.g.a.b ipQ;
        final /* synthetic */ z.d tQB;
        final /* synthetic */ ArrayList vLO;
        final /* synthetic */ FinderPostPickerUI vMO;
        final /* synthetic */ GalleryItem.MediaItem vMR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(GalleryItem.MediaItem mediaItem, FinderPostPickerUI finderPostPickerUI, ArrayList arrayList, z.d dVar, kotlin.g.a.b bVar) {
            super(2);
            this.vMR = mediaItem;
            this.vMO = finderPostPickerUI;
            this.vLO = arrayList;
            this.tQB = dVar;
            this.ipQ = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, b.f fVar) {
            AppMethodBeat.i(167488);
            boolean booleanValue = bool.booleanValue();
            b.f fVar2 = fVar;
            p.h(fVar2, "result");
            Log.i("Finder.PostPickerUI", "[onGenerate] isSuccessfully=" + booleanValue + " result=" + fVar2);
            z.d dVar = this.tQB;
            dVar.SYE--;
            MediaSelectedData mediaSelectedData = new MediaSelectedData(this.vMR.getType());
            if (fVar2 instanceof com.tencent.mm.plugin.finder.video.e) {
                mediaSelectedData.path = fVar2.xli;
                mediaSelectedData.thumbPath = fVar2.thumbPath;
                mediaSelectedData.uOR = ((com.tencent.mm.plugin.finder.video.e) fVar2).wcO;
            } else {
                mediaSelectedData.path = fVar2.xli;
                mediaSelectedData.thumbPath = fVar2.thumbPath;
            }
            this.vLO.set(fVar2.token, mediaSelectedData);
            if (this.tQB.SYE == 0) {
                FinderPostPickerUI.c(this.vMO).removeCallbacks(this.vMO.vJC);
                Dialog dialog = this.vMO.tipDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                this.ipQ.invoke(this.vLO);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(167488);
            return xVar;
        }
    }

    public FinderPostPickerUI() {
        AppMethodBeat.i(167495);
        AppMethodBeat.o(167495);
    }

    public static final /* synthetic */ ViewPager c(FinderPostPickerUI finderPostPickerUI) {
        AppMethodBeat.i(167498);
        ViewPager viewPager = finderPostPickerUI.uO;
        if (viewPager == null) {
            p.btv("viewPager");
        }
        AppMethodBeat.o(167498);
        return viewPager;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderPostPickerUI$Companion;", "", "()V", "MENU_ID_NEXT", "", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(167491);
        super.onCreate(bundle);
        initView();
        com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.iub).aSq();
        this.vMM = getIntent().getBooleanExtra("fromAppBrand", false);
        b.C1388b bVar = new b.C1388b();
        al alVar = al.waC;
        bVar.ayU(al.dEG());
        this.vLu = new com.tencent.mm.plugin.gallery.picker.b.b(bVar);
        com.tencent.mm.plugin.gallery.picker.b.b bVar2 = this.vLu;
        if (bVar2 == null) {
            p.btv("mediaTailor");
        }
        bVar2.a(new com.tencent.mm.plugin.finder.video.l(bVar));
        AppMethodBeat.o(167491);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(167492);
        super.onDestroy();
        com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.iub).axJ();
        AppMethodBeat.o(167492);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(167493);
        super.initView();
        setMMTitle(R.string.d5o);
        setBackBtn(new b(this));
        addTextOptionMenu(101, getString(R.string.x5), new c(this), d.vMQ, t.b.GREEN);
        View findViewById = findViewById(R.id.j7k);
        p.g(findViewById, "findViewById(R.id.view_pager)");
        this.uO = (ViewPager) findViewById;
        GalleryPickerFragment galleryPickerFragment = new GalleryPickerFragment(this.vML, new e(this));
        ArrayList arrayList = new ArrayList();
        arrayList.add(galleryPickerFragment);
        com.tencent.mm.plugin.gallery.picker.a.c cVar = new com.tencent.mm.plugin.gallery.picker.a.c(getSupportFragmentManager(), arrayList);
        ViewPager viewPager = this.uO;
        if (viewPager == null) {
            p.btv("viewPager");
        }
        viewPager.setAdapter(cVar);
        ViewPager viewPager2 = this.uO;
        if (viewPager2 == null) {
            p.btv("viewPager");
        }
        viewPager2.setCurrentItem(0, false);
        AppMethodBeat.o(167493);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderPostPickerUI vMO;

        b(FinderPostPickerUI finderPostPickerUI) {
            this.vMO = finderPostPickerUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167484);
            this.vMO.setResult(0);
            this.vMO.finish();
            AppMethodBeat.o(167484);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderPostPickerUI vMO;

        c(FinderPostPickerUI finderPostPickerUI) {
            this.vMO = finderPostPickerUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167486);
            FinderPostPickerUI.a(this.vMO, this.vMO.vML, new kotlin.g.a.b<List<? extends MediaSelectedData>, x>(this) {
                /* class com.tencent.mm.plugin.finder.ui.FinderPostPickerUI.c.AnonymousClass1 */
                final /* synthetic */ c vMP;

                {
                    this.vMP = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(List<? extends MediaSelectedData> list) {
                    LocalVideoCropInfoParcelable localVideoCropInfoParcelable;
                    AppMethodBeat.i(167485);
                    List<? extends MediaSelectedData> list2 = list;
                    p.h(list2, "result");
                    Intent intent = new Intent();
                    int type = ((GalleryItem.MediaItem) j.ks(this.vMP.vMO.vML)).getType();
                    intent.putExtra("postType", type);
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        String str = it.next().path;
                        p.g(str, "it.path");
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
                    if (type == 2) {
                        ArrayList arrayList4 = new ArrayList();
                        Iterator<T> it3 = list2.iterator();
                        while (it3.hasNext()) {
                            String str2 = it3.next().thumbPath;
                            p.g(str2, "it.thumbPath");
                            arrayList4.add(str2);
                        }
                        intent.putStringArrayListExtra("postThumbList", arrayList4);
                    }
                    if (this.vMP.vMO.vMM) {
                        ArrayList arrayList5 = new ArrayList();
                        Iterator<T> it4 = list2.iterator();
                        while (it4.hasNext()) {
                            String str3 = it4.next().thumbPath;
                            p.g(str3, "it.thumbPath");
                            arrayList5.add(str3);
                        }
                        intent.putStringArrayListExtra("postThumbList", arrayList5);
                        this.vMP.vMO.setResult(-1, intent);
                        this.vMP.vMO.finish();
                    } else {
                        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                        com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(this.vMP.vMO, intent);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(167485);
                    return xVar;
                }
            });
            AppMethodBeat.o(167486);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    public static final class d implements View.OnLongClickListener {
        public static final d vMQ = new d();

        static {
            AppMethodBeat.i(167487);
            AppMethodBeat.o(167487);
        }

        d() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(252589);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostPickerUI$initView$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/ui/FinderPostPickerUI$initView$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(252589);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderPostPickerUI$initView$fragment$1", "Lcom/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$ISelectedMediaChange;", "onChange", "", "size", "", "plugin-finder_release"})
    public static final class e implements GalleryPickerFragment.b {
        final /* synthetic */ FinderPostPickerUI vMO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderPostPickerUI finderPostPickerUI) {
            this.vMO = finderPostPickerUI;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(167494);
        super.onBackPressed();
        setResult(0);
        finish();
        AppMethodBeat.o(167494);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.aih;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ FinderPostPickerUI vMO;

        g(FinderPostPickerUI finderPostPickerUI) {
            this.vMO = finderPostPickerUI;
        }

        public final void run() {
            AppMethodBeat.i(167490);
            Dialog dialog = this.vMO.tipDialog;
            if (dialog != null) {
                dialog.show();
                AppMethodBeat.o(167490);
                return;
            }
            FinderPostPickerUI finderPostPickerUI = this.vMO;
            finderPostPickerUI.getString(R.string.zb);
            finderPostPickerUI.tipDialog = h.a((Context) finderPostPickerUI, finderPostPickerUI.getString(R.string.a06), false, (DialogInterface.OnCancelListener) a.vMS);
            AppMethodBeat.o(167490);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
        static final class a implements DialogInterface.OnCancelListener {
            public static final a vMS = new a();

            static {
                AppMethodBeat.i(167489);
                AppMethodBeat.o(167489);
            }

            a() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }
    }

    public static final /* synthetic */ void a(FinderPostPickerUI finderPostPickerUI, List list, kotlin.g.a.b bVar) {
        AppMethodBeat.i(167497);
        ViewPager viewPager = finderPostPickerUI.uO;
        if (viewPager == null) {
            p.btv("viewPager");
        }
        viewPager.postDelayed(finderPostPickerUI.vJC, 300);
        z.d dVar = new z.d();
        dVar.SYE = list.size();
        ArrayList arrayList = new ArrayList(9);
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            GalleryItem.MediaItem mediaItem = (GalleryItem.MediaItem) obj;
            arrayList.add(new MediaSelectedData(-1));
            Object obj2 = mediaItem.iMa;
            if (!(obj2 instanceof MMMediaCropLayout.b)) {
                obj2 = null;
            }
            MMMediaCropLayout.b bVar2 = (MMMediaCropLayout.b) obj2;
            if (bVar2 == null) {
                bVar2 = new MMMediaCropLayout.b(0);
            }
            Matrix matrix = new Matrix(bVar2.gT);
            String str = mediaItem.xiW;
            Rect rect = new Rect(bVar2.iiw);
            Rect rect2 = new Rect(bVar2.rwL);
            Rect rect3 = new Rect(bVar2.viewRect);
            com.tencent.mm.plugin.gallery.picker.b.b bVar3 = finderPostPickerUI.vLu;
            if (bVar3 == null) {
                p.btv("mediaTailor");
            }
            p.g(str, "path");
            com.tencent.mm.plugin.gallery.picker.b.b.a(bVar3, str, mediaItem.getType(), matrix, rect, rect2, rect3, i2, new f(mediaItem, finderPostPickerUI, arrayList, dVar, bVar));
            i2 = i3;
        }
        AppMethodBeat.o(167497);
    }
}
