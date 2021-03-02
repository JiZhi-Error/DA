package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ar;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001a\u001a\u00020\u001bJ\"\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tR#\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\u00130\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018XD¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderChooseNewsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "checkBox$delegate", "Lkotlin/Lazy;", "descText", "Landroid/widget/TextView;", "getDescText", "()Landroid/widget/TextView;", "descText$delegate", "fireChar", "", "likeChar", "isChecked", "", "scaleImage", "Landroid/graphics/drawable/Drawable;", "image", "width", "height", "plugin-finder_release"})
public final class FinderChooseNewsView extends RelativeLayout {
    private HashMap _$_findViewCache;
    private final f vaQ = g.ah(new a(this));
    private final f wjR = g.ah(new b(this));
    private final char wjS = 8197;
    private final char wjT = 8198;

    private final CheckBox getCheckBox() {
        AppMethodBeat.i(254674);
        CheckBox checkBox = (CheckBox) this.vaQ.getValue();
        AppMethodBeat.o(254674);
        return checkBox;
    }

    private final TextView getDescText() {
        AppMethodBeat.i(254675);
        TextView textView = (TextView) this.wjR.getValue();
        AppMethodBeat.o(254675);
        return textView;
    }

    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(254679);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(254679);
        return view;
    }

    public FinderChooseNewsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(254677);
        aa.jQ(getContext()).inflate(R.layout.ai9, (ViewGroup) this, true);
        Context context2 = getContext();
        p.g(context2, "context");
        int dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.cb);
        Context context3 = getContext();
        p.g(context3, "context");
        SpannableString spannableString = new SpannableString(context3.getResources().getString(R.string.d92));
        Drawable m = ar.m(getContext(), R.raw.icons_outlined_like, com.tencent.mm.cb.a.n(getContext(), R.color.FG_2));
        Drawable m2 = ar.m(getContext(), R.raw.icons_outlined_fire, com.tencent.mm.cb.a.n(getContext(), R.color.FG_2));
        m.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        m2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(m, 1);
        com.tencent.mm.ui.widget.a aVar2 = new com.tencent.mm.ui.widget.a(m2, 1);
        int a2 = n.a((CharSequence) spannableString, this.wjS, 0, false, 6);
        int a3 = n.a((CharSequence) spannableString, this.wjT, 0, false, 6);
        spannableString.setSpan(aVar, a2, a2 + 1, 34);
        spannableString.setSpan(aVar2, a3, a3 + 1, 34);
        TextView descText = getDescText();
        p.g(descText, "descText");
        descText.setText(spannableString);
        AppMethodBeat.o(254677);
    }

    public FinderChooseNewsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(254678);
        aa.jQ(getContext()).inflate(R.layout.ai9, (ViewGroup) this, true);
        Context context2 = getContext();
        p.g(context2, "context");
        int dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.cb);
        Context context3 = getContext();
        p.g(context3, "context");
        SpannableString spannableString = new SpannableString(context3.getResources().getString(R.string.d92));
        Drawable m = ar.m(getContext(), R.raw.icons_outlined_like, com.tencent.mm.cb.a.n(getContext(), R.color.FG_2));
        Drawable m2 = ar.m(getContext(), R.raw.icons_outlined_fire, com.tencent.mm.cb.a.n(getContext(), R.color.FG_2));
        m.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        m2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(m, 1);
        com.tencent.mm.ui.widget.a aVar2 = new com.tencent.mm.ui.widget.a(m2, 1);
        int a2 = n.a((CharSequence) spannableString, this.wjS, 0, false, 6);
        int a3 = n.a((CharSequence) spannableString, this.wjT, 0, false, 6);
        spannableString.setSpan(aVar, a2, a2 + 1, 34);
        spannableString.setSpan(aVar2, a3, a3 + 1, 34);
        TextView descText = getDescText();
        p.g(descText, "descText");
        descText.setText(spannableString);
        AppMethodBeat.o(254678);
    }

    public final boolean isChecked() {
        AppMethodBeat.i(254676);
        CheckBox checkBox = getCheckBox();
        p.g(checkBox, "checkBox");
        boolean isChecked = checkBox.isChecked();
        AppMethodBeat.o(254676);
        return isChecked;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends q implements kotlin.g.a.a<CheckBox> {
        final /* synthetic */ FinderChooseNewsView wjU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderChooseNewsView finderChooseNewsView) {
            super(0);
            this.wjU = finderChooseNewsView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ CheckBox invoke() {
            AppMethodBeat.i(254672);
            CheckBox checkBox = (CheckBox) this.wjU._$_findCachedViewById(R.id.d12);
            AppMethodBeat.o(254672);
            return checkBox;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderChooseNewsView wjU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderChooseNewsView finderChooseNewsView) {
            super(0);
            this.wjU = finderChooseNewsView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(254673);
            TextView textView = (TextView) this.wjU._$_findCachedViewById(R.id.d15);
            AppMethodBeat.o(254673);
            return textView;
        }
    }
}
