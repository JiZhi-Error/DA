package com.tencent.mm.plugin.recordvideo.plugin.doodle;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 K2\u00020\u0001:\u0003IJKB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010=\u001a\u00020<J\b\u0010>\u001a\u00020\u0003H\u0016J\u0010\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020\u000eH\u0004J\u0016\u0010A\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u0005J\u0010\u0010C\u001a\u00020<2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u00020<2\u0006\u0010D\u001a\u00020EH\u0002J\u000e\u0010G\u001a\u00020<2\u0006\u0010H\u001a\u00020\u001dJ\u0010\u00105\u001a\u00020<2\u0006\u00102\u001a\u00020\u000eH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R!\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R,\u00102\u001a\u0004\u0018\u00010\u000e2\b\u00101\u001a\u0004\u0018\u00010\u000e8F@FX\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006L"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "isLand", "", "mRootView", "Landroid/widget/RelativeLayout;", "(ZLandroid/widget/RelativeLayout;)V", "colorList", "Landroid/widget/GridView;", "getColorList", "()Landroid/widget/GridView;", "setColorList", "(Landroid/widget/GridView;)V", "imageSizeDP", "", "getImageSizeDP", "()I", "setImageSizeDP", "(I)V", "()Z", "setLand", "(Z)V", "mContentView", "mFinishLayout", "getMRootView", "()Landroid/widget/RelativeLayout;", "setMRootView", "(Landroid/widget/RelativeLayout;)V", "mStatus", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "getMStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setMStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "getResourceArray", "()Ljava/util/ArrayList;", "selectType", "getSelectType", "setSelectType", "unDoImageView", "Landroid/widget/ImageView;", "getUnDoImageView", "()Landroid/widget/ImageView;", "setUnDoImageView", "(Landroid/widget/ImageView;)V", "value", "visibility", "getVisibility", "()Ljava/lang/Integer;", "setVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getItemMargin", "context", "Landroid/content/Context;", "initResourceArray", "", "initView", "onBackPress", "postFuncType", "type", "refreshDoodleLayout", "rootView", "resetClickBigImageView", "view", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "selectClickBigImageView", "setStatus", "status", "ClickImageViewResource", "ClickImageViewResourceAdapter", "Companion", "plugin-recordvideo_release"})
public final class b implements t {
    private static final int BSV = BSV;
    private static final int BSW = -16777216;
    private static final int BSX = BSX;
    private static final int BSY = BSY;
    private static final int BSZ = BSZ;
    private static final int BTa = BTa;
    private static final int BTb = BTb;
    private static final int BTc = BTc;
    public static final c BTd = new c((byte) 0);
    int BSP = 32;
    final ArrayList<a> BSQ = new ArrayList<>();
    public com.tencent.mm.plugin.recordvideo.plugin.parent.d BSR;
    private ImageView BSS;
    GridView BST;
    private boolean BSU;
    int jVX = 2;
    private RelativeLayout ncd;
    private Integer zTu;
    private RelativeLayout zWt;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$ClickImageViewResource;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "type", "getType", "setType", "plugin-recordvideo_release"})
    public static final class a {
        Bitmap bitmap;
        int color;
        int type;
    }

    public b(boolean z, RelativeLayout relativeLayout) {
        p.h(relativeLayout, "mRootView");
        AppMethodBeat.i(237384);
        this.BSU = z;
        this.ncd = relativeLayout;
        a(this.BSU, this.ncd);
        AppMethodBeat.o(237384);
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
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237386);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237386);
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

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$Companion;", "", "()V", "COLOR_0", "", "COLOR_1", "COLOR_2", "COLOR_3", "COLOR_4", "COLOR_5", "COLOR_6", "COLOR_7", "plugin-recordvideo_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(237385);
        AppMethodBeat.o(237385);
    }

    public final void l(Integer num) {
        View view;
        View view2;
        RelativeLayout relativeLayout;
        AppMethodBeat.i(237377);
        if (!(num == null || (relativeLayout = this.zWt) == null)) {
            relativeLayout.setVisibility(num.intValue());
        }
        if (num != null && num.intValue() == 0) {
            Iterator<T> it = this.BSQ.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                it.next();
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                GridView gridView = this.BST;
                if (gridView != null) {
                    view = gridView.getChildAt(i2);
                } else {
                    view = null;
                }
                if (view != null) {
                    GridView gridView2 = this.BST;
                    if (gridView2 != null) {
                        view2 = gridView2.getChildAt(i2);
                    } else {
                        view2 = null;
                    }
                    if (view2 == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                        AppMethodBeat.o(237377);
                        throw tVar;
                    } else if (((a) view2).getType() != this.jVX) {
                        GridView gridView3 = this.BST;
                        View childAt = gridView3 != null ? gridView3.getChildAt(i2) : null;
                        if (childAt == null) {
                            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                            AppMethodBeat.o(237377);
                            throw tVar2;
                        }
                        ((a) childAt).setHasSelected(false);
                        i2 = i3;
                    } else {
                        GridView gridView4 = this.BST;
                        View childAt2 = gridView4 != null ? gridView4.getChildAt(i2) : null;
                        if (childAt2 == null) {
                            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                            AppMethodBeat.o(237377);
                            throw tVar3;
                        }
                        ((a) childAt2).setHasSelected(true);
                    }
                }
                i2 = i3;
            }
            VE(this.jVX);
        }
        this.zTu = num;
        AppMethodBeat.o(237377);
    }

    private static int gP(Context context) {
        AppMethodBeat.i(237378);
        p.h(context, "context");
        int i2 = au.az(context).x;
        int i3 = au.az(context).y;
        if (i2 <= i3) {
            i3 = i2;
        }
        int fromDPToPix = (i3 - at.fromDPToPix(context, 314)) / 7;
        AppMethodBeat.o(237378);
        return fromDPToPix;
    }

    public final void a(boolean z, RelativeLayout relativeLayout) {
        GridView gridView;
        AppMethodBeat.i(237379);
        p.h(relativeLayout, "rootView");
        View inflate = LayoutInflater.from(relativeLayout.getContext()).inflate(z ? R.layout.bod : R.layout.boc, relativeLayout);
        if (inflate == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
            AppMethodBeat.o(237379);
            throw tVar;
        }
        this.zWt = (RelativeLayout) inflate;
        RelativeLayout relativeLayout2 = this.zWt;
        this.BSS = relativeLayout2 != null ? (ImageView) relativeLayout2.findViewById(R.id.gu0) : null;
        ImageView imageView = this.BSS;
        if (imageView != null) {
            imageView.setImageDrawable(ar.m(relativeLayout.getContext(), R.raw.icons_filled_previous, -1));
        }
        ImageView imageView2 = this.BSS;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new d(this));
        }
        this.BST = (GridView) relativeLayout.findViewById(R.id.b80);
        if (z && (gridView = this.BST) != null) {
            Context context = relativeLayout.getContext();
            p.g(context, "rootView.context");
            gridView.setVerticalSpacing(gP(context));
        }
        th(z);
        GridView gridView2 = this.BST;
        if (gridView2 != null) {
            gridView2.setAdapter((ListAdapter) new C1651b(this, this.BSQ));
        }
        GridView gridView3 = this.BST;
        if (gridView3 != null) {
            gridView3.setOnItemClickListener(new e(this));
            AppMethodBeat.o(237379);
            return;
        }
        AppMethodBeat.o(237379);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ b BTe;

        d(b bVar) {
            this.BTe = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(237375);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$refreshDoodleLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar = this.BTe.BSR;
            if (dVar != null) {
                d.b.a(dVar, d.c.BVM);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$refreshDoodleLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(237375);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "a", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "b", "Landroid/view/View;", "position", "", "d", "", "onItemClick"})
    public static final class e implements AdapterView.OnItemClickListener {
        final /* synthetic */ b BTe;

        e(b bVar) {
            this.BTe = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(237376);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$refreshDoodleLayout$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            if (view == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                AppMethodBeat.o(237376);
                throw tVar;
            } else if (((a) view).getType() == this.BTe.jVX) {
                this.BTe.VE(((a) view).getType());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$refreshDoodleLayout$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(237376);
            } else {
                this.BTe.jVX = ((a) view).getType();
                this.BTe.VE(((a) view).getType());
                int i3 = 0;
                Iterator<T> it = this.BTe.BSQ.iterator();
                while (it.hasNext()) {
                    it.next();
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        j.hxH();
                    }
                    if (i3 == i2) {
                        GridView gridView = this.BTe.BST;
                        View childAt = gridView != null ? gridView.getChildAt(i3) : null;
                        if (childAt == null) {
                            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                            AppMethodBeat.o(237376);
                            throw tVar2;
                        } else if (!((a) childAt).yLb) {
                            GridView gridView2 = this.BTe.BST;
                            View childAt2 = gridView2 != null ? gridView2.getChildAt(i3) : null;
                            if (childAt2 == null) {
                                kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                                AppMethodBeat.o(237376);
                                throw tVar3;
                            }
                            b.a((a) childAt2);
                            i3 = i4;
                        } else {
                            i3 = i4;
                        }
                    } else {
                        GridView gridView3 = this.BTe.BST;
                        View childAt3 = gridView3 != null ? gridView3.getChildAt(i3) : null;
                        if (childAt3 == null) {
                            kotlin.t tVar4 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                            AppMethodBeat.o(237376);
                            throw tVar4;
                        }
                        if (((a) childAt3).yLb) {
                            GridView gridView4 = this.BTe.BST;
                            View childAt4 = gridView4 != null ? gridView4.getChildAt(i3) : null;
                            if (childAt4 == null) {
                                kotlin.t tVar5 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                                AppMethodBeat.o(237376);
                                throw tVar5;
                            }
                            b.b((a) childAt4);
                        }
                        i3 = i4;
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$refreshDoodleLayout$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(237376);
            }
        }
    }

    private final void th(boolean z) {
        AppMethodBeat.i(237380);
        if (z) {
            this.BSQ.clear();
            ArrayList<a> arrayList = this.BSQ;
            a aVar = new a();
            aVar.color = BTb;
            aVar.type = 6;
            arrayList.add(aVar);
            ArrayList<a> arrayList2 = this.BSQ;
            a aVar2 = new a();
            aVar2.color = BTa;
            aVar2.type = 5;
            arrayList2.add(aVar2);
            ArrayList<a> arrayList3 = this.BSQ;
            a aVar3 = new a();
            aVar3.color = BSZ;
            aVar3.type = 4;
            arrayList3.add(aVar3);
            ArrayList<a> arrayList4 = this.BSQ;
            a aVar4 = new a();
            aVar4.color = BSY;
            aVar4.type = 3;
            arrayList4.add(aVar4);
            ArrayList<a> arrayList5 = this.BSQ;
            a aVar5 = new a();
            aVar5.color = BSX;
            aVar5.type = 2;
            arrayList5.add(aVar5);
            ArrayList<a> arrayList6 = this.BSQ;
            a aVar6 = new a();
            aVar6.color = BSW;
            aVar6.type = 1;
            arrayList6.add(aVar6);
            ArrayList<a> arrayList7 = this.BSQ;
            a aVar7 = new a();
            aVar7.color = BSV;
            aVar7.type = 0;
            arrayList7.add(aVar7);
            AppMethodBeat.o(237380);
            return;
        }
        this.BSQ.clear();
        ArrayList<a> arrayList8 = this.BSQ;
        a aVar8 = new a();
        aVar8.color = BSV;
        aVar8.type = 0;
        arrayList8.add(aVar8);
        ArrayList<a> arrayList9 = this.BSQ;
        a aVar9 = new a();
        aVar9.color = BSW;
        aVar9.type = 1;
        arrayList9.add(aVar9);
        ArrayList<a> arrayList10 = this.BSQ;
        a aVar10 = new a();
        aVar10.color = BSX;
        aVar10.type = 2;
        arrayList10.add(aVar10);
        ArrayList<a> arrayList11 = this.BSQ;
        a aVar11 = new a();
        aVar11.color = BSY;
        aVar11.type = 3;
        arrayList11.add(aVar11);
        ArrayList<a> arrayList12 = this.BSQ;
        a aVar12 = new a();
        aVar12.color = BSZ;
        aVar12.type = 4;
        arrayList12.add(aVar12);
        ArrayList<a> arrayList13 = this.BSQ;
        a aVar13 = new a();
        aVar13.color = BTa;
        aVar13.type = 5;
        arrayList13.add(aVar13);
        ArrayList<a> arrayList14 = this.BSQ;
        a aVar14 = new a();
        aVar14.color = BTb;
        aVar14.type = 6;
        arrayList14.add(aVar14);
        AppMethodBeat.o(237380);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\fH\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$ClickImageViewResourceAdapter;", "Landroid/widget/BaseAdapter;", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/MultiTalkScreenDoodlePlugin;Ljava/util/ArrayList;)V", "getResourceArray", "()Ljava/util/ArrayList;", "setResourceArray", "(Ljava/util/ArrayList;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-recordvideo_release"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.plugin.doodle.b$b  reason: collision with other inner class name */
    public final class C1651b extends BaseAdapter {
        private ArrayList<a> BSQ;
        final /* synthetic */ b BTe;

        public C1651b(b bVar, ArrayList<a> arrayList) {
            p.h(arrayList, "resourceArray");
            this.BTe = bVar;
            AppMethodBeat.i(237374);
            this.BSQ = arrayList;
            AppMethodBeat.o(237374);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            Context context;
            AppMethodBeat.i(237371);
            if (viewGroup == null) {
                p.hyc();
            }
            Context context2 = viewGroup.getContext();
            p.g(context2, "parent!!.context");
            a aVar = new a(context2, true);
            Object item = getItem(i2);
            if (item == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.MultiTalkScreenDoodlePlugin.ClickImageViewResource");
                AppMethodBeat.o(237371);
                throw tVar;
            }
            a aVar2 = (a) item;
            if (aVar2.bitmap == null) {
                aVar.setDrawColor(aVar2.color);
            } else {
                Bitmap bitmap = aVar2.bitmap;
                if (bitmap == null) {
                    p.hyc();
                }
                aVar.setBitmap(bitmap);
            }
            aVar.setType(aVar2.type);
            GridView gridView = this.BTe.BST;
            if (gridView != null) {
                context = gridView.getContext();
            } else {
                context = null;
            }
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, this.BTe.BSP);
            aVar.setLayoutParams(new AbsListView.LayoutParams(fromDPToPix, fromDPToPix));
            if (aVar.getType() == this.BTe.jVX) {
                aVar.setHasSelected(true);
            } else {
                aVar.setHasSelected(false);
            }
            a aVar3 = aVar;
            AppMethodBeat.o(237371);
            return aVar3;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(237372);
            a aVar = this.BSQ.get(i2);
            p.g(aVar, "resourceArray[position]");
            AppMethodBeat.o(237372);
            return aVar;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final int getCount() {
            AppMethodBeat.i(237373);
            int size = this.BSQ.size();
            AppMethodBeat.o(237373);
            return size;
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        View view;
        View view2;
        AppMethodBeat.i(237381);
        if (i2 == 0) {
            Iterator<T> it = this.BSQ.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                it.next();
                int i4 = i3 + 1;
                if (i3 < 0) {
                    j.hxH();
                }
                GridView gridView = this.BST;
                if (gridView != null) {
                    view = gridView.getChildAt(i3);
                } else {
                    view = null;
                }
                if (view != null) {
                    GridView gridView2 = this.BST;
                    if (gridView2 != null) {
                        view2 = gridView2.getChildAt(i3);
                    } else {
                        view2 = null;
                    }
                    if (view2 == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                        AppMethodBeat.o(237381);
                        throw tVar;
                    } else if (((a) view2).getType() != this.jVX) {
                        GridView gridView3 = this.BST;
                        View childAt = gridView3 != null ? gridView3.getChildAt(i3) : null;
                        if (childAt == null) {
                            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                            AppMethodBeat.o(237381);
                            throw tVar2;
                        }
                        ((a) childAt).setHasSelected(false);
                        i3 = i4;
                    } else {
                        GridView gridView4 = this.BST;
                        View childAt2 = gridView4 != null ? gridView4.getChildAt(i3) : null;
                        if (childAt2 == null) {
                            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                            AppMethodBeat.o(237381);
                            throw tVar3;
                        }
                        ((a) childAt2).setHasSelected(true);
                    }
                }
                i3 = i4;
            }
            VE(this.jVX);
        }
        GridView gridView5 = this.BST;
        if (gridView5 != null) {
            gridView5.setVisibility(i2);
        }
        ImageView imageView = this.BSS;
        if (imageView != null) {
            imageView.setVisibility(i2);
            AppMethodBeat.o(237381);
            return;
        }
        AppMethodBeat.o(237381);
    }

    /* access modifiers changed from: protected */
    public final void VE(int i2) {
        AppMethodBeat.i(237383);
        switch (i2) {
            case 99:
                com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar = this.BSR;
                if (dVar != null) {
                    d.b.a(dVar, d.c.BVJ);
                    AppMethodBeat.o(237383);
                    return;
                }
                AppMethodBeat.o(237383);
                return;
            case 100:
                com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar2 = this.BSR;
                if (dVar2 != null) {
                    d.b.a(dVar2, d.c.BVK);
                    AppMethodBeat.o(237383);
                    return;
                }
                AppMethodBeat.o(237383);
                return;
            default:
                Bundle bundle = new Bundle();
                bundle.putInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT", i2);
                com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar3 = this.BSR;
                if (dVar3 != null) {
                    dVar3.a(d.c.BVL, bundle);
                    AppMethodBeat.o(237383);
                    return;
                }
                AppMethodBeat.o(237383);
                return;
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        Integer num;
        AppMethodBeat.i(237382);
        RelativeLayout relativeLayout = this.zWt;
        if (relativeLayout != null) {
            num = Integer.valueOf(relativeLayout.getVisibility());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            l(4);
            AppMethodBeat.o(237382);
            return true;
        }
        AppMethodBeat.o(237382);
        return false;
    }

    public static final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(237387);
        aVar.setHasSelected(true);
        AppMethodBeat.o(237387);
    }

    public static final /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(237388);
        aVar.setHasSelected(false);
        AppMethodBeat.o(237388);
    }
}
