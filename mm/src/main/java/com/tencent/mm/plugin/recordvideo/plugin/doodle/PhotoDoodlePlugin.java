package com.tencent.mm.plugin.recordvideo.plugin.doodle;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.AttributeSet;
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
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.ar;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0003=>?B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u001c\u0010-\u001a\u00020*2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010/H\u0002J\u0006\u00101\u001a\u00020*J\b\u00102\u001a\u00020,H\u0016J\u0010\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\u000fH\u0004J\u0010\u00105\u001a\u00020*2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020*2\u0006\u00106\u001a\u000207H\u0002J\u000e\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020\u0013J\u0010\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020\u000fH\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "colorList", "Landroid/widget/GridView;", "getColorList", "()Landroid/widget/GridView;", "setColorList", "(Landroid/widget/GridView;)V", "imageSizeDP", "", "getImageSizeDP", "()I", "mStatus", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "getMStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setMStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "getResourceArray", "()Ljava/util/ArrayList;", "selectType", "getSelectType", "setSelectType", "(I)V", "unDoImageView", "Landroid/widget/ImageView;", "getUnDoImageView", "()Landroid/widget/ImageView;", "setUnDoImageView", "(Landroid/widget/ImageView;)V", "getLayout", "hideMosaic", "", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", "initResourceArray", "msc", "Landroid/graphics/Bitmap;", "brush", "initView", "onBackPress", "postFuncType", "type", "resetClickBigImageView", "view", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "selectClickBigImageView", "setStatus", "status", "setVisibility", "visibility", "ClickImageViewResource", "ClickImageViewResourceAdapter", "Companion", "plugin-recordvideo_release"})
public class PhotoDoodlePlugin extends RelativeLayout implements t {
    public static final c BTf = new c((byte) 0);
    private final int BSP = 22;
    private final ArrayList<a> BSQ = new ArrayList<>();
    private com.tencent.mm.plugin.recordvideo.plugin.parent.d BSR;
    private ImageView BSS;
    public GridView BST;
    private int jVX = 2;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "type", "getType", "setType", "plugin-recordvideo_release"})
    public static final class a {
        Bitmap bitmap;
        int color;
        int type;
    }

    static {
        AppMethodBeat.i(75733);
        AppMethodBeat.o(75733);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoDoodlePlugin(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(75732);
        LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) this, true);
        this.BSS = (ImageView) findViewById(R.id.gu0);
        ImageView imageView = this.BSS;
        if (imageView != null) {
            imageView.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_previous, -1));
        }
        ImageView imageView2 = this.BSS;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new d(this));
        }
        this.BST = (GridView) findViewById(R.id.b80);
        Context context2 = getContext();
        p.g(context2, "context");
        Bitmap decodeResource = BitmapFactory.decodeResource(context2.getResources(), R.drawable.c_r);
        Context context3 = getContext();
        p.g(context3, "context");
        b(BitmapFactory.decodeResource(context3.getResources(), R.drawable.c_s), decodeResource);
        GridView gridView = this.BST;
        if (gridView != null) {
            gridView.setAdapter((ListAdapter) new b(this, this.BSQ));
        }
        GridView gridView2 = this.BST;
        if (gridView2 != null) {
            gridView2.setOnItemClickListener(new e(this));
            AppMethodBeat.o(75732);
            return;
        }
        AppMethodBeat.o(75732);
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
        AppMethodBeat.i(237391);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237391);
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

    /* access modifiers changed from: protected */
    public final ArrayList<a> getResourceArray() {
        return this.BSQ;
    }

    public final com.tencent.mm.plugin.recordvideo.plugin.parent.d getMStatus() {
        return this.BSR;
    }

    public final void setMStatus(com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        this.BSR = dVar;
    }

    /* access modifiers changed from: protected */
    public final ImageView getUnDoImageView() {
        return this.BSS;
    }

    /* access modifiers changed from: protected */
    public final void setUnDoImageView(ImageView imageView) {
        this.BSS = imageView;
    }

    /* access modifiers changed from: protected */
    public final GridView getColorList() {
        return this.BST;
    }

    /* access modifiers changed from: protected */
    public final void setColorList(GridView gridView) {
        this.BST = gridView;
    }

    /* access modifiers changed from: protected */
    public final int getSelectType() {
        return this.jVX;
    }

    /* access modifiers changed from: protected */
    public final void setSelectType(int i2) {
        this.jVX = i2;
    }

    /* access modifiers changed from: protected */
    public final int getImageSizeDP() {
        return this.BSP;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$Companion;", "", "()V", "BRUSH", "", "COLOR_0", "COLOR_1", "COLOR_2", "COLOR_3", "COLOR_4", "COLOR_5", "COLOR_6", "MSC", "RECALL", "plugin-recordvideo_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    public final int getLayout() {
        return R.layout.bhy;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ PhotoDoodlePlugin BTg;

        d(PhotoDoodlePlugin photoDoodlePlugin) {
            this.BTg = photoDoodlePlugin;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(237389);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.recordvideo.plugin.parent.d mStatus = this.BTg.getMStatus();
            if (mStatus != null) {
                d.b.a(mStatus, d.c.BVM);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(237389);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "a", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "b", "Landroid/view/View;", "position", "", "d", "", "onItemClick"})
    static final class e implements AdapterView.OnItemClickListener {
        final /* synthetic */ PhotoDoodlePlugin BTg;

        e(PhotoDoodlePlugin photoDoodlePlugin) {
            this.BTg = photoDoodlePlugin;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(237390);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$initView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            if (view == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                AppMethodBeat.o(237390);
                throw tVar;
            } else if (((a) view).getType() == this.BTg.getSelectType()) {
                this.BTg.VE(((a) view).getType());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$initView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(237390);
            } else {
                this.BTg.setSelectType(((a) view).getType());
                this.BTg.VE(((a) view).getType());
                int i3 = 0;
                Iterator<T> it = this.BTg.getResourceArray().iterator();
                while (it.hasNext()) {
                    it.next();
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        j.hxH();
                    }
                    if (i3 == i2) {
                        GridView colorList = this.BTg.getColorList();
                        View childAt = colorList != null ? colorList.getChildAt(i3) : null;
                        if (childAt == null) {
                            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                            AppMethodBeat.o(237390);
                            throw tVar2;
                        } else if (!((a) childAt).yLb) {
                            GridView colorList2 = this.BTg.getColorList();
                            View childAt2 = colorList2 != null ? colorList2.getChildAt(i3) : null;
                            if (childAt2 == null) {
                                kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                                AppMethodBeat.o(237390);
                                throw tVar3;
                            }
                            PhotoDoodlePlugin.c((a) childAt2);
                            i3 = i4;
                        } else {
                            i3 = i4;
                        }
                    } else {
                        GridView colorList3 = this.BTg.getColorList();
                        View childAt3 = colorList3 != null ? colorList3.getChildAt(i3) : null;
                        if (childAt3 == null) {
                            kotlin.t tVar4 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                            AppMethodBeat.o(237390);
                            throw tVar4;
                        }
                        if (((a) childAt3).yLb) {
                            GridView colorList4 = this.BTg.getColorList();
                            View childAt4 = colorList4 != null ? colorList4.getChildAt(i3) : null;
                            if (childAt4 == null) {
                                kotlin.t tVar5 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                                AppMethodBeat.o(237390);
                                throw tVar5;
                            }
                            PhotoDoodlePlugin.d((a) childAt4);
                        }
                        i3 = i4;
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$initView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(237390);
            }
        }
    }

    public final void b(Bitmap bitmap, Bitmap bitmap2) {
        AppMethodBeat.i(163442);
        this.BSQ.clear();
        if (bitmap != null) {
            ArrayList<a> arrayList = this.BSQ;
            a aVar = new a();
            aVar.bitmap = bitmap;
            aVar.type = 99;
            arrayList.add(aVar);
        }
        if (bitmap2 != null) {
            ArrayList<a> arrayList2 = this.BSQ;
            a aVar2 = new a();
            aVar2.bitmap = bitmap2;
            aVar2.type = 100;
            arrayList2.add(aVar2);
        }
        ArrayList<a> arrayList3 = this.BSQ;
        a aVar3 = new a();
        aVar3.color = -1;
        aVar3.type = 0;
        arrayList3.add(aVar3);
        ArrayList<a> arrayList4 = this.BSQ;
        a aVar4 = new a();
        aVar4.color = WebView.NIGHT_MODE_COLOR;
        aVar4.type = 1;
        arrayList4.add(aVar4);
        ArrayList<a> arrayList5 = this.BSQ;
        a aVar5 = new a();
        aVar5.color = -707825;
        aVar5.type = 2;
        arrayList5.add(aVar5);
        ArrayList<a> arrayList6 = this.BSQ;
        a aVar6 = new a();
        aVar6.color = -17592;
        aVar6.type = 3;
        arrayList6.add(aVar6);
        ArrayList<a> arrayList7 = this.BSQ;
        a aVar7 = new a();
        aVar7.color = -16535286;
        aVar7.type = 4;
        arrayList7.add(aVar7);
        ArrayList<a> arrayList8 = this.BSQ;
        a aVar8 = new a();
        aVar8.color = -15172610;
        aVar8.type = 5;
        arrayList8.add(aVar8);
        ArrayList<a> arrayList9 = this.BSQ;
        a aVar9 = new a();
        aVar9.color = -7054596;
        aVar9.type = 6;
        arrayList9.add(aVar9);
        AppMethodBeat.o(163442);
    }

    public final void setStatus(com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        AppMethodBeat.i(75728);
        p.h(dVar, "status");
        this.BSR = dVar;
        AppMethodBeat.o(75728);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\fH\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResourceAdapter;", "Landroid/widget/BaseAdapter;", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;Ljava/util/ArrayList;)V", "getResourceArray", "()Ljava/util/ArrayList;", "setResourceArray", "(Ljava/util/ArrayList;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-recordvideo_release"})
    final class b extends BaseAdapter {
        private ArrayList<a> BSQ;
        final /* synthetic */ PhotoDoodlePlugin BTg;

        public b(PhotoDoodlePlugin photoDoodlePlugin, ArrayList<a> arrayList) {
            p.h(arrayList, "resourceArray");
            this.BTg = photoDoodlePlugin;
            AppMethodBeat.i(75727);
            this.BSQ = arrayList;
            AppMethodBeat.o(75727);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(75724);
            if (viewGroup == null) {
                p.hyc();
            }
            Context context = viewGroup.getContext();
            p.g(context, "parent!!.context");
            a aVar = new a(context);
            Object item = getItem(i2);
            if (item == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin.ClickImageViewResource");
                AppMethodBeat.o(75724);
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
            GridView colorList = this.BTg.getColorList();
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(colorList != null ? colorList.getContext() : null, this.BTg.getImageSizeDP());
            aVar.setLayoutParams(new AbsListView.LayoutParams(fromDPToPix, fromDPToPix));
            if (aVar.getType() == this.BTg.getSelectType()) {
                aVar.setHasSelected(true);
            } else {
                aVar.setHasSelected(false);
            }
            a aVar3 = aVar;
            AppMethodBeat.o(75724);
            return aVar3;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(75725);
            a aVar = this.BSQ.get(i2);
            p.g(aVar, "resourceArray[position]");
            AppMethodBeat.o(75725);
            return aVar;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final int getCount() {
            AppMethodBeat.i(75726);
            int size = this.BSQ.size();
            AppMethodBeat.o(75726);
            return size;
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public void setVisibility(int i2) {
        View view;
        View view2;
        AppMethodBeat.i(75729);
        super.setVisibility(i2);
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
                        AppMethodBeat.o(75729);
                        throw tVar;
                    } else if (((a) view2).getType() != this.jVX) {
                        GridView gridView3 = this.BST;
                        View childAt = gridView3 != null ? gridView3.getChildAt(i3) : null;
                        if (childAt == null) {
                            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                            AppMethodBeat.o(75729);
                            throw tVar2;
                        }
                        ((a) childAt).setHasSelected(false);
                        i3 = i4;
                    } else {
                        GridView gridView4 = this.BST;
                        View childAt2 = gridView4 != null ? gridView4.getChildAt(i3) : null;
                        if (childAt2 == null) {
                            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                            AppMethodBeat.o(75729);
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
            AppMethodBeat.o(75729);
            return;
        }
        AppMethodBeat.o(75729);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(75730);
        if (getVisibility() == 0) {
            setVisibility(4);
            AppMethodBeat.o(75730);
            return true;
        }
        AppMethodBeat.o(75730);
        return false;
    }

    /* access modifiers changed from: protected */
    public final void VE(int i2) {
        AppMethodBeat.i(75731);
        switch (i2) {
            case 99:
                com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar = this.BSR;
                if (dVar != null) {
                    d.b.a(dVar, d.c.BVJ);
                    AppMethodBeat.o(75731);
                    return;
                }
                AppMethodBeat.o(75731);
                return;
            case 100:
                com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar2 = this.BSR;
                if (dVar2 != null) {
                    d.b.a(dVar2, d.c.BVK);
                    AppMethodBeat.o(75731);
                    return;
                }
                AppMethodBeat.o(75731);
                return;
            default:
                Bundle bundle = new Bundle();
                bundle.putInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT", i2);
                com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar3 = this.BSR;
                if (dVar3 != null) {
                    dVar3.a(d.c.BVL, bundle);
                    AppMethodBeat.o(75731);
                    return;
                }
                AppMethodBeat.o(75731);
                return;
        }
    }

    public static final /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(75735);
        aVar.setHasSelected(true);
        AppMethodBeat.o(75735);
    }

    public static final /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(75736);
        aVar.setHasSelected(false);
        AppMethodBeat.o(75736);
    }
}
