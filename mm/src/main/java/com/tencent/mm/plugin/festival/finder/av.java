package com.tencent.mm.plugin.festival.finder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u001a\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\b\b\u0002\u0010\u001f\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveTitlePlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "authIv", "Landroid/widget/ImageView;", "avatarIcon", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "nameTv", "Landroid/widget/TextView;", "canClearScreen", "", "goToFinderProfile", "", "goToFinderProfileImpl", "resume", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "updateLiveTitle", "anchorUsername", "plugin-festival_release"})
public final class av extends p {
    final String TAG;
    Context context;
    private final TextView gxs;
    final b hOp;
    private final ImageView hXu;
    private final ImageView uuc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private av(final ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262575);
        this.hOp = bVar;
        this.TAG = "Finder.FestivalFinderLiveTitlePlugin";
        this.context = viewGroup.getContext();
        View findViewById = viewGroup.findViewById(R.id.emh);
        p.g(findViewById, "root.findViewById(R.id.l…e_title_info_avatar_icon)");
        this.hXu = (ImageView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.emj);
        p.g(findViewById2, "root.findViewById(R.id.live_title_info_name_tv)");
        this.gxs = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.emk);
        p.g(findViewById3, "root.findViewById(R.id.live_title_info_tag_iv)");
        this.uuc = (ImageView) findViewById3;
        a aVar = new a(this);
        this.hXu.setOnClickListener(aVar);
        this.gxs.setOnClickListener(aVar);
        p.h(getLiveData().hwd, "anchorUsername");
        View findViewById4 = this.hwr.findViewById(R.id.k08);
        p.g(findViewById4, "root.findViewById<View>(R.id.live_follow_btn)");
        findViewById4.setVisibility(8);
        this.gxs.setPadding(this.gxs.getPaddingLeft(), this.gxs.getPaddingTop(), at.fromDPToPix(this.hwr.getContext(), 20), this.gxs.getPaddingBottom());
        this.uuc.setVisibility(0);
        this.uuc.setImageResource(R.raw.icons_filled_star_identify_enterprise_sold);
        this.hXu.setImageResource(R.drawable.cvu);
        this.hXu.setVisibility(0);
        this.gxs.setText(this.context.getString(R.string.j9o));
        this.gxs.setVisibility(0);
        this.gxs.requestLayout();
        viewGroup.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.av.AnonymousClass1 */
            final /* synthetic */ av UuA;

            {
                this.UuA = r1;
            }

            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                AppMethodBeat.i(262570);
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams != null) {
                    p.g(windowInsets, "insets");
                    int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
                    Context context = this.UuA.context;
                    p.g(context, "context");
                    int dimensionPixelSize = systemWindowInsetTop + context.getResources().getDimensionPixelSize(R.dimen.ct);
                    if (marginLayoutParams.topMargin != dimensionPixelSize) {
                        marginLayoutParams.topMargin = dimensionPixelSize;
                        viewGroup.requestLayout();
                    }
                }
                AppMethodBeat.o(262570);
                return windowInsets;
            }
        });
        AppMethodBeat.o(262575);
    }

    public /* synthetic */ av(ViewGroup viewGroup, b bVar, byte b2) {
        this(viewGroup, bVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ av UuA;

        a(av avVar) {
            this.UuA = avVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(262572);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveTitlePlugin$avatarClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
            if (b.a.aDp()) {
                av avVar = this.UuA;
                Log.i(avVar.TAG, "goToFinderProfile");
                Intent intent = new Intent();
                intent.putExtra("key_from_profile_share_scene", 0);
                if (Util.isNullOrNil(avVar.getLiveData().hwd)) {
                    intent.putExtra("finder_username", "");
                    intent.putExtra("key_finder_object_Id", avVar.getLiveData().hFK);
                    intent.putExtra("key_finder_object_nonce_id_key", avVar.getLiveData().hwg);
                } else {
                    intent.putExtra("finder_username", avVar.getLiveData().hwd);
                }
                intent.putExtra("key_enter_profile_type", 11);
                bbn bbn = avVar.reportObj;
                if (bbn != null) {
                    String str = bbn.sGQ;
                    String str2 = bbn.sGE;
                    if (!TextUtils.isEmpty(str)) {
                        intent.putExtra("key_context_id", str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        intent.putExtra("key_click_tab_context_id", str2);
                    }
                }
                ((aj) g.ah(aj.class)).enterFinderProfileUI(avVar.hwr.getContext(), intent);
                if (this.UuA.hOp.getLiveRole() == 0) {
                    m.vli.hUI();
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveTitlePlugin$avatarClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262572);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
        AppMethodBeat.i(262573);
        super.resume();
        AppMethodBeat.o(262573);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(262574);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (aw.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                rg(4);
                AppMethodBeat.o(262574);
                return;
            case 4:
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                com.tencent.mm.plugin.finder.utils.m.a((d) this, true);
                com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
                com.tencent.mm.plugin.finder.utils.m.a(this);
                break;
        }
        AppMethodBeat.o(262574);
    }
}
