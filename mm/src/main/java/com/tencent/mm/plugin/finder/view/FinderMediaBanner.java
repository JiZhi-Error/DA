package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import com.tencent.mm.plugin.finder.video.FinderVideoSeekBar;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.MediaBanner;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ(\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;H\u0016J\u0010\u0010=\u001a\u00020>2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020@J\b\u0010B\u001a\u00020@H\u0016J\b\u0010C\u001a\u00020@H\u0016R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R(\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0011\u001a\u0004\u0018\u00010#@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010-\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u000e\u00100\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "Lcom/tencent/mm/view/MediaBanner;", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "hideTextTimer", "Ljava/util/Timer;", "value", "", "isFrozenRecyclerView", "()Z", "setFrozenRecyclerView", "(Z)V", "isNeedSpaceView", "setNeedSpaceView", "longVideoSeekBar", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "getLongVideoSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "setLongVideoSeekBar", "(Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;)V", "refDeleteTip", "Landroid/widget/TextView;", "refDeleteTipLayout", "Landroid/view/View;", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "refFeedInfo", "getRefFeedInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeedInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFromTv", "refLayout", "seekBarLayout", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar;", "spaceView", "getSpaceView", "()Landroid/view/View;", "topLayer", "typeIconIv", "Landroid/widget/ImageView;", "getTypeIconIv", "()Landroid/widget/ImageView;", "warnContainer", "canScrollHorizontally", TencentLocation.EXTRA_DIRECTION, "parent", "Landroid/view/ViewGroup;", "x", "", "y", "getLinearLayoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "refreshRefUI", "", "removeSeekBar", "startLoopPlay", "stopLoopPlay", "plugin-finder_release"})
public class FinderMediaBanner extends MediaBanner<com.tencent.mm.ui.base.a.b> implements FinderViewPager.a {
    private final String TAG = "Finder.FinderMediaBanner";
    private azy vMc;
    private FinderLongVideoPlayerSeekBar wfr;
    private final View wnX;
    private final View wnY;
    private final View wnZ;
    private final TextView woa;
    private final View wob;
    private final TextView woc;
    private Timer wod;
    private final ImageView woe;
    private final View wof;
    public final FinderVideoSeekBar wog;
    private boolean woh;
    private boolean woi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderMediaBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(168377);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.a_t, (ViewGroup) null);
        p.g(inflate, "LayoutInflater.from(cont…d_banner_top_layer, null)");
        this.wnX = inflate;
        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.ab_, (ViewGroup) null);
        p.g(inflate2, "LayoutInflater.from(cont…eed_warn_container, null)");
        this.wnY = inflate2;
        this.woe = new ImageView(getContext());
        this.wof = new View(getContext());
        Context context2 = getContext();
        p.g(context2, "context");
        this.wog = new FinderVideoSeekBar(context2);
        this.woh = true;
        addView(this.wnX, new FrameLayout.LayoutParams(-1, -1));
        View findViewById = this.wnX.findViewById(R.id.h3i);
        p.g(findViewById, "topLayer.findViewById(R.id.reprint_layout)");
        this.wnZ = findViewById;
        setId(R.id.fbd);
        View findViewById2 = this.wnX.findViewById(R.id.h3g);
        p.g(findViewById2, "topLayer.findViewById(R.id.reprint_from_tv)");
        this.woa = (TextView) findViewById2;
        View findViewById3 = this.wnX.findViewById(R.id.bmo);
        p.g(findViewById3, "topLayer.findViewById(R.id.deleted_tips_layout)");
        this.wob = findViewById3;
        View findViewById4 = this.wnX.findViewById(R.id.bmp);
        p.g(findViewById4, "topLayer.findViewById(R.id.deleted_tips_tv)");
        this.woc = (TextView) findViewById4;
        dGX();
        getPagerView().setOverScrollMode(0);
        getPagerView().setNestedScrollingEnabled(false);
        Context context3 = getContext();
        p.g(context3, "context");
        Context context4 = getContext();
        p.g(context4, "context");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) context3.getResources().getDimension(R.dimen.ce), (int) context4.getResources().getDimension(R.dimen.ce));
        Context context5 = getContext();
        p.g(context5, "context");
        float dimension = context5.getResources().getDimension(R.dimen.cb);
        Context context6 = getContext();
        p.g(context6, "context");
        int dimension2 = (int) (dimension + context6.getResources().getDimension(R.dimen.bt));
        layoutParams.rightMargin = dimension2;
        layoutParams.topMargin = dimension2;
        layoutParams.gravity = 53;
        this.woe.setVisibility(8);
        addView(this.woe, layoutParams);
        this.wog.setVisibility(8);
        addView(this.wog);
        View inflate3 = aa.jQ(getContext()).inflate(R.layout.a_z, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        getPagerViewContainer().addView(inflate3, layoutParams2);
        if (this.woh) {
            this.wof.setLayoutParams(new FrameLayout.LayoutParams(0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 10)));
            LinearLayout container = getContainer();
            if (container != null) {
                container.addView(this.wof);
            }
            LinearLayout container2 = getContainer();
            if (container2 != null) {
                container2.addView(this.wnY, 1);
                AppMethodBeat.o(168377);
                return;
            }
            AppMethodBeat.o(168377);
            return;
        }
        LinearLayout container3 = getContainer();
        if (container3 != null) {
            container3.addView(this.wnY);
            AppMethodBeat.o(168377);
            return;
        }
        AppMethodBeat.o(168377);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderMediaBanner(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(168378);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.a_t, (ViewGroup) null);
        p.g(inflate, "LayoutInflater.from(cont…d_banner_top_layer, null)");
        this.wnX = inflate;
        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.ab_, (ViewGroup) null);
        p.g(inflate2, "LayoutInflater.from(cont…eed_warn_container, null)");
        this.wnY = inflate2;
        this.woe = new ImageView(getContext());
        this.wof = new View(getContext());
        Context context2 = getContext();
        p.g(context2, "context");
        this.wog = new FinderVideoSeekBar(context2);
        this.woh = true;
        addView(this.wnX, new FrameLayout.LayoutParams(-1, -1));
        View findViewById = this.wnX.findViewById(R.id.h3i);
        p.g(findViewById, "topLayer.findViewById(R.id.reprint_layout)");
        this.wnZ = findViewById;
        setId(R.id.fbd);
        View findViewById2 = this.wnX.findViewById(R.id.h3g);
        p.g(findViewById2, "topLayer.findViewById(R.id.reprint_from_tv)");
        this.woa = (TextView) findViewById2;
        View findViewById3 = this.wnX.findViewById(R.id.bmo);
        p.g(findViewById3, "topLayer.findViewById(R.id.deleted_tips_layout)");
        this.wob = findViewById3;
        View findViewById4 = this.wnX.findViewById(R.id.bmp);
        p.g(findViewById4, "topLayer.findViewById(R.id.deleted_tips_tv)");
        this.woc = (TextView) findViewById4;
        dGX();
        getPagerView().setOverScrollMode(0);
        getPagerView().setNestedScrollingEnabled(false);
        Context context3 = getContext();
        p.g(context3, "context");
        Context context4 = getContext();
        p.g(context4, "context");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) context3.getResources().getDimension(R.dimen.ce), (int) context4.getResources().getDimension(R.dimen.ce));
        Context context5 = getContext();
        p.g(context5, "context");
        float dimension = context5.getResources().getDimension(R.dimen.cb);
        Context context6 = getContext();
        p.g(context6, "context");
        int dimension2 = (int) (dimension + context6.getResources().getDimension(R.dimen.bt));
        layoutParams.rightMargin = dimension2;
        layoutParams.topMargin = dimension2;
        layoutParams.gravity = 53;
        this.woe.setVisibility(8);
        addView(this.woe, layoutParams);
        this.wog.setVisibility(8);
        addView(this.wog);
        View inflate3 = aa.jQ(getContext()).inflate(R.layout.a_z, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        getPagerViewContainer().addView(inflate3, layoutParams2);
        if (this.woh) {
            this.wof.setLayoutParams(new FrameLayout.LayoutParams(0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 10)));
            LinearLayout container = getContainer();
            if (container != null) {
                container.addView(this.wof);
            }
            LinearLayout container2 = getContainer();
            if (container2 != null) {
                container2.addView(this.wnY, 1);
                AppMethodBeat.o(168378);
                return;
            }
            AppMethodBeat.o(168378);
            return;
        }
        LinearLayout container3 = getContainer();
        if (container3 != null) {
            container3.addView(this.wnY);
            AppMethodBeat.o(168378);
            return;
        }
        AppMethodBeat.o(168378);
    }

    public final ImageView getTypeIconIv() {
        return this.woe;
    }

    public final View getSpaceView() {
        return this.wof;
    }

    public final FinderLongVideoPlayerSeekBar getLongVideoSeekBar() {
        return this.wfr;
    }

    public final void setLongVideoSeekBar(FinderLongVideoPlayerSeekBar finderLongVideoPlayerSeekBar) {
        this.wfr = finderLongVideoPlayerSeekBar;
    }

    public final void setNeedSpaceView(boolean z) {
        LinearLayout container;
        AppMethodBeat.i(254885);
        this.woh = z;
        if (z || (container = getContainer()) == null) {
            AppMethodBeat.o(254885);
            return;
        }
        container.removeView(this.wof);
        AppMethodBeat.o(254885);
    }

    public final azy getRefFeedInfo() {
        return this.vMc;
    }

    public final void setRefFeedInfo(azy azy) {
        AppMethodBeat.i(168373);
        this.vMc = azy;
        dGX();
        AppMethodBeat.o(168373);
    }

    private void dGX() {
        azy azy;
        String str;
        AppMethodBeat.i(168374);
        Timer timer = this.wod;
        if (timer != null) {
            timer.cancel();
        }
        String str2 = this.TAG;
        StringBuilder append = new StringBuilder("refreshRefUI ").append(this.vMc == null).append(' ');
        azy azy2 = this.vMc;
        StringBuilder append2 = append.append(azy2 != null ? azy2.refObjectContact : null).append(' ');
        azy azy3 = this.vMc;
        Log.i(str2, append2.append(azy3 != null && azy3.refObjectFlag == 0).toString());
        if (this.vMc != null) {
            azy azy4 = this.vMc;
            if ((azy4 != null ? azy4.refObjectContact : null) != null && ((azy = this.vMc) == null || azy.refObjectFlag != 0)) {
                this.wnZ.setVisibility(0);
                Context context = getContext();
                azy azy5 = this.vMc;
                if (azy5 == null) {
                    p.hyc();
                }
                FinderContact finderContact = azy5.refObjectContact;
                SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(context, (finderContact == null || (str = finderContact.nickname) == null) ? "" : str);
                String string = getContext().getString(R.string.d87, c2);
                p.g(string, "context.getString(R.stri…r_reprint_from, fromName)");
                this.woa.setText(string);
                this.woa.setVisibility(0);
                Timer timer2 = new Timer();
                timer2.schedule(new b(this), 3000);
                this.wod = timer2;
                azy azy6 = this.vMc;
                if (azy6 == null) {
                    p.hyc();
                }
                if (azy6.refObjectFlag == 2) {
                    this.wob.setVisibility(0);
                    this.wnZ.setVisibility(8);
                    this.woc.setText(c2);
                    this.wob.setOnClickListener(new c(this));
                    AppMethodBeat.o(168374);
                    return;
                }
                this.wob.setVisibility(8);
                this.wnZ.setOnClickListener(new d(this));
                AppMethodBeat.o(168374);
                return;
            }
        }
        this.wnZ.setVisibility(8);
        this.wob.setVisibility(8);
        AppMethodBeat.o(168374);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$1$1", "Ljava/util/TimerTask;", "run", "", "plugin-finder_release"})
    public static final class b extends TimerTask {
        final /* synthetic */ FinderMediaBanner woj;

        b(FinderMediaBanner finderMediaBanner) {
            this.woj = finderMediaBanner;
        }

        public final void run() {
            AppMethodBeat.i(168370);
            this.woj.post(new Runnable(this) {
                /* class com.tencent.mm.plugin.finder.view.FinderMediaBanner.b.AnonymousClass1 */
                final /* synthetic */ b wol;

                {
                    this.wol = r1;
                }

                public final void run() {
                    AppMethodBeat.i(168369);
                    this.wol.woj.woa.setVisibility(8);
                    AppMethodBeat.o(168369);
                }
            });
            AppMethodBeat.o(168370);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ FinderMediaBanner woj;

        c(FinderMediaBanner finderMediaBanner) {
            this.woj = finderMediaBanner;
        }

        public final void onClick(View view) {
            String str;
            AppMethodBeat.i(168371);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            azy refFeedInfo = this.woj.getRefFeedInfo();
            if (refFeedInfo == null) {
                p.hyc();
            }
            FinderContact finderContact = refFeedInfo.refObjectContact;
            if (finderContact == null || (str = finderContact.username) == null) {
                str = "";
            }
            if (str == null) {
                str = "";
            }
            intent.putExtra("finder_username", str);
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.woj.getContext();
            p.g(context, "context");
            FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context2 = this.woj.getContext();
            p.g(context2, "context");
            com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context2, intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168371);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ FinderMediaBanner woj;

        d(FinderMediaBanner finderMediaBanner) {
            this.woj = finderMediaBanner;
        }

        public final void onClick(View view) {
            String str;
            String str2;
            AppMethodBeat.i(168372);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            azy refFeedInfo = this.woj.getRefFeedInfo();
            if (refFeedInfo == null) {
                p.hyc();
            }
            intent.putExtra("KEY_REF_OBJ_ID", refFeedInfo.refObjectId);
            azy refFeedInfo2 = this.woj.getRefFeedInfo();
            if (refFeedInfo2 == null) {
                p.hyc();
            }
            intent.putExtra("KEY_REF_OBJ_NONCE_ID", refFeedInfo2.refObjectNonceId);
            azy refFeedInfo3 = this.woj.getRefFeedInfo();
            if (refFeedInfo3 == null) {
                p.hyc();
            }
            FinderContact finderContact = refFeedInfo3.refObjectContact;
            if (finderContact == null || (str = finderContact.username) == null) {
                str = "";
            }
            if (str == null) {
                str = "";
            }
            intent.putExtra("KEY_TARGET_USERNAME", str);
            azy refFeedInfo4 = this.woj.getRefFeedInfo();
            if (refFeedInfo4 == null) {
                p.hyc();
            }
            FinderContact finderContact2 = refFeedInfo4.refObjectContact;
            if (finderContact2 == null || (str2 = finderContact2.nickname) == null) {
                str2 = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            intent.putExtra("KEY_TARGET_NICKNAME", str2);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context = this.woj.getContext();
            p.g(context, "context");
            com.tencent.mm.plugin.finder.utils.a.H(context, intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168372);
        }
    }

    public final void setFrozenRecyclerView(boolean z) {
        AppMethodBeat.i(254886);
        this.woi = z;
        String str = this.TAG;
        StringBuilder append = new StringBuilder("[SET] isPassTouchEvent=").append(z).append(" isInLayout=");
        RecyclerView parentRecyclerView = getParentRecyclerView();
        Log.i(str, append.append(parentRecyclerView != null ? Boolean.valueOf(parentRecyclerView.isInLayout()) : null).toString());
        RecyclerView parentRecyclerView2 = getParentRecyclerView();
        if (parentRecyclerView2 == null || !parentRecyclerView2.isInLayout()) {
            RecyclerView parentRecyclerView3 = getParentRecyclerView();
            if (parentRecyclerView3 != null) {
                parentRecyclerView3.setLayoutFrozen(z);
                AppMethodBeat.o(254886);
                return;
            }
            AppMethodBeat.o(254886);
            return;
        }
        RecyclerView parentRecyclerView4 = getParentRecyclerView();
        if (parentRecyclerView4 != null) {
            parentRecyclerView4.post(new a(this, z));
            AppMethodBeat.o(254886);
            return;
        }
        AppMethodBeat.o(254886);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ FinderMediaBanner woj;
        final /* synthetic */ boolean wok;

        a(FinderMediaBanner finderMediaBanner, boolean z) {
            this.woj = finderMediaBanner;
            this.wok = z;
        }

        public final void run() {
            AppMethodBeat.i(254884);
            RecyclerView parentRecyclerView = this.woj.getParentRecyclerView();
            if (parentRecyclerView != null) {
                parentRecyclerView.setLayoutFrozen(this.wok);
                AppMethodBeat.o(254884);
                return;
            }
            AppMethodBeat.o(254884);
        }
    }

    @Override // com.tencent.mm.view.MediaBanner
    public final LinearLayoutManager fF(Context context) {
        AppMethodBeat.i(254887);
        p.h(context, "context");
        FinderLinearLayoutManager finderLinearLayoutManager = new FinderLinearLayoutManager(context);
        finderLinearLayoutManager.wsx = 50.0f;
        FinderLinearLayoutManager finderLinearLayoutManager2 = finderLinearLayoutManager;
        AppMethodBeat.o(254887);
        return finderLinearLayoutManager2;
    }

    @Override // com.tencent.mm.plugin.finder.view.FinderViewPager.a
    public final boolean a(int i2, ViewGroup viewGroup) {
        AppMethodBeat.i(254888);
        p.h(viewGroup, "parent");
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.hUP().value().intValue() == 1) {
            AppMethodBeat.o(254888);
            return false;
        } else if (!getManager().canScrollHorizontally()) {
            AppMethodBeat.o(254888);
            return false;
        } else if (getManager().getItemCount() <= 1) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.hUP().value().intValue() != 1) {
                AppMethodBeat.o(254888);
                return true;
            }
            AppMethodBeat.o(254888);
            return false;
        } else if (i2 > 0 && getManager().kv() == getManager().getItemCount() - 1) {
            com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.hUP().value().intValue() != 1) {
                AppMethodBeat.o(254888);
                return true;
            }
            AppMethodBeat.o(254888);
            return false;
        } else if (i2 < 0 && getManager().ks() == 0 && getManager().kt() == 0) {
            com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.hUP().value().intValue() != 1) {
                AppMethodBeat.o(254888);
                return true;
            }
            AppMethodBeat.o(254888);
            return false;
        } else {
            AppMethodBeat.o(254888);
            return true;
        }
    }

    @Override // com.tencent.mm.view.MediaBanner
    public final void dGY() {
        AppMethodBeat.i(254889);
        super.dGY();
        setKeepScreenOn(true);
        AppMethodBeat.o(254889);
    }

    @Override // com.tencent.mm.view.MediaBanner
    public final void dGZ() {
        AppMethodBeat.i(254890);
        super.dGZ();
        setKeepScreenOn(false);
        AppMethodBeat.o(254890);
    }
}
