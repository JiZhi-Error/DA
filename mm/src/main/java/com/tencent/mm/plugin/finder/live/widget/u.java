package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI19;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\u0010R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLuckyMoneyWidget;", "Landroid/view/View$OnClickListener;", "luckyMoneyRoot", "Landroid/widget/LinearLayout;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "(Landroid/widget/LinearLayout;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "TAG", "", "luckyMoneyArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "luckyMoneyIcon", "luckyMoneyTv", "Landroid/widget/TextView;", "checkLuckyMoneyStatusBySvrConfig", "", "goToSelectLuckyRoom", "onClick", "v", "Landroid/view/View;", "refreshLuckyMoneyChatroom", "plugin-finder_release"})
public final class u implements View.OnClickListener {
    private final String TAG = "Finder.FinderLiveLuckyMoneyWidget";
    private final TextView URj = ((TextView) this.URm.findViewById(R.id.jy1));
    private final WeImageView URk = ((WeImageView) this.URm.findViewById(R.id.jxz));
    private final WeImageView URl = ((WeImageView) this.URm.findViewById(R.id.jxx));
    private final LinearLayout URm;
    private final g liveData;

    /* JADX WARNING: Removed duplicated region for block: B:7:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public u(android.widget.LinearLayout r9, com.tencent.mm.plugin.finder.live.viewmodel.g r10) {
        /*
        // Method dump skipped, instructions count: 462
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.widget.u.<init>(android.widget.LinearLayout, com.tencent.mm.plugin.finder.live.viewmodel.g):void");
    }

    public final void hUm() {
        AppMethodBeat.i(261147);
        int size = this.liveData.UQm.Mpi.size();
        if (!this.liveData.hTX() || size <= 0) {
            TextView textView = this.URj;
            p.g(textView, "luckyMoneyTv");
            textView.setVisibility(8);
            AppMethodBeat.o(261147);
            return;
        }
        TextView textView2 = this.URj;
        p.g(textView2, "luckyMoneyTv");
        Context context = this.URm.getContext();
        p.g(context, "luckyMoneyRoot.context");
        textView2.setText(context.getResources().getString(R.string.jau, Integer.valueOf(size)));
        TextView textView3 = this.URj;
        p.g(textView3, "luckyMoneyTv");
        textView3.setVisibility(0);
        AppMethodBeat.o(261147);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(261148);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveLuckyMoneyWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.jy0) {
            Intent intent = new Intent(this.URm.getContext(), OccupyFinderUI19.class);
            Context context = this.URm.getContext();
            p.g(context, "luckyMoneyRoot.context");
            intent.putExtra("titile", context.getResources().getString(R.string.jby));
            intent.putExtra("KBlockOpenImFav", true);
            intent.putExtra("KEY_LUCKY_MONEY_CHAT_ROOM_MAX_COUNT", this.liveData.UQl.Vit);
            intent.putStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME", new ArrayList<>(this.liveData.UQm.Mpi));
            Context context2 = this.URm.getContext();
            if (context2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(261148);
                throw tVar;
            }
            ((Activity) context2).startActivityForResult(intent, 1004);
        }
        a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveLuckyMoneyWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(261148);
    }
}
