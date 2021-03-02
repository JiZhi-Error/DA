package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
final class FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1$onMMMenuItemSelected$4 implements u.b {
    final /* synthetic */ FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1 uXj;

    FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1$onMMMenuItemSelected$4(FinderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1 finderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1) {
        this.uXj = finderLikedFeedContract$LikedTimelinePresenter$getMoreMenuItemSelectedListener$1;
    }

    @Override // com.tencent.mm.ui.base.u.b
    public final void dU(View view) {
        WeImageView weImageView;
        TextView textView;
        AppMethodBeat.i(249785);
        if (!(view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null)) {
            textView.setTextSize(1, 14.0f);
        }
        if (!(view == null || (weImageView = (WeImageView) view.findViewById(R.id.irc)) == null)) {
            weImageView.setImageResource(R.raw.icons_filled_done);
            Context context = weImageView.getContext();
            p.g(context, "context");
            weImageView.setIconColor(context.getResources().getColor(R.color.ag1));
        }
        this.uXj.uXi.a(this.uXj.tEM.feedObject, true, null);
        AppMethodBeat.o(249785);
    }
}
