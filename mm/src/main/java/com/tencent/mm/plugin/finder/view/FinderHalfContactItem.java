package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.eoz;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000fJ\b\u0010\u0018\u001a\u00020\u0013H\u0002J\u0006\u0010\u0019\u001a\u00020\u0013R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderHalfContactItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imgIV", "", "Landroid/widget/ImageView;", "mTitle", "", "mUserRecentLikeInfo", "Lcom/tencent/mm/protocal/protobuf/UserRecentLikeInfo;", "initView", "", "refresh", "userRecentLikeInfo", "setTitle", "title", "updateAlbum", "updateView", "plugin-finder_release"})
public final class FinderHalfContactItem extends FrameLayout {
    private final List<ImageView> Kpq = new LinkedList();
    private eoz Kps;
    private String mTitle = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderHalfContactItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(261538);
        initView();
        AppMethodBeat.o(261538);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderHalfContactItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(261539);
        initView();
        AppMethodBeat.o(261539);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.List<android.widget.ImageView> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: java.util.List<android.widget.ImageView> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.util.List<android.widget.ImageView> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: java.util.List<android.widget.ImageView> */
    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        AppMethodBeat.i(261534);
        Object systemService = getContext().getSystemService("layout_inflater");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.LayoutInflater");
            AppMethodBeat.o(261534);
            throw tVar;
        }
        ((LayoutInflater) systemService).inflate(R.layout.cfs, (ViewGroup) this, true);
        this.Kpq.clear();
        this.Kpq.add(findViewById(R.id.dw0));
        this.Kpq.add(findViewById(R.id.dw1));
        this.Kpq.add(findViewById(R.id.dw2));
        this.Kpq.add(findViewById(R.id.dw3));
        AppMethodBeat.o(261534);
    }

    public final void setTitle(String str) {
        AppMethodBeat.i(261535);
        p.h(str, "title");
        this.mTitle = str;
        View findViewById = findViewById(R.id.ld);
        if (findViewById == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(261535);
            throw tVar;
        }
        TextView textView = (TextView) findViewById;
        if (!Util.isNullOrNil(this.mTitle)) {
            textView.setText(this.mTitle);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = a.aG(getContext(), R.dimen.em);
            textView.setLayoutParams(layoutParams);
        } else {
            textView.setText("");
        }
        grH();
        AppMethodBeat.o(261535);
    }

    private final void grH() {
        AppMethodBeat.i(261536);
        for (ImageView imageView : this.Kpq) {
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        eoz eoz = this.Kps;
        if (eoz != null) {
            int size = eoz.LCW.size();
            int i2 = 0;
            while (i2 < size && i2 < this.Kpq.size()) {
                ImageView imageView2 = this.Kpq.get(i2);
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                com.tencent.mm.kernel.b.a ah = g.ah(aj.class);
                p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
                ((aj) ah).getFinderUIApi().a(eoz.LCW.get(i2), imageView2);
                i2++;
            }
        }
        AppMethodBeat.o(261536);
    }

    public final void a(eoz eoz) {
        AppMethodBeat.i(261537);
        this.Kps = eoz;
        grH();
        AppMethodBeat.o(261537);
    }
}
