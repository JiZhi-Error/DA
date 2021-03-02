package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0012H\u0002J\u0014\u0010\u0018\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderTopicSuggestView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "listLayout", "listScrollView", "Landroid/widget/ScrollView;", "onItemSelected", "Lkotlin/Function1;", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function1;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function1;)V", "initView", "refresh", ShareConstants.WEB_DIALOG_PARAM_SUGGESTIONS, "", "Lcom/tencent/mm/protocal/protobuf/FinderSuggestion;", "plugin-finder_release"})
public final class FinderTopicSuggestView extends LinearLayout {
    private final String TAG = "Finder.FinderTopicSuggestView";
    private ScrollView wpG;
    private LinearLayout wpH;
    private b<? super String, x> wpI;

    public FinderTopicSuggestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(168423);
        initView();
        AppMethodBeat.o(168423);
    }

    public FinderTopicSuggestView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(168424);
        initView();
        AppMethodBeat.o(168424);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.String, kotlin.x>, kotlin.g.a.b<java.lang.String, kotlin.x> */
    public final b<String, x> getOnItemSelected() {
        return this.wpI;
    }

    public final void setOnItemSelected(b<? super String, x> bVar) {
        this.wpI = bVar;
    }

    private final void initView() {
        AppMethodBeat.i(168422);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.akt, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.itx);
        p.g(findViewById, "findViewById(R.id.topic_suggest_item_scrollview)");
        this.wpG = (ScrollView) findViewById;
        View findViewById2 = findViewById(R.id.ity);
        p.g(findViewById2, "findViewById(R.id.topic_suggest_list)");
        this.wpH = (LinearLayout) findViewById2;
        AppMethodBeat.o(168422);
    }
}
