package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import java.util.Arrays;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0006\u0010\u0015\u001a\u00020\u000eJ\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\bH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u000e\u0012\b\u0012\u00060\u000bR\u00020\u0000\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "item", "Landroid/view/View;", "viewVideos", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "[Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "inflate", "BizTLRecCardVideo", "plugin-brandservice_release"})
public final class v extends w {
    private View puO;
    private a[] pvx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(b bVar, Context context) {
        super(context, bVar);
        p.h(bVar, "adapter");
        p.h(context, "context");
        AppMethodBeat.i(195393);
        AppMethodBeat.o(195393);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad, com.tencent.mm.plugin.brandservice.ui.timeline.item.w
    public final void a(z zVar, int i2, View view, View view2) {
        a aVar;
        String string;
        AppMethodBeat.i(195390);
        p.h(zVar, "info");
        p.h(view, "convertView");
        p.h(view2, "parent");
        super.a(zVar, i2, view, view2);
        efz gAC = zVar.gAC();
        if ((gAC != null ? gAC.NfT : null) == null) {
            AppMethodBeat.o(195390);
            return;
        }
        View view3 = this.puO;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        LinkedList<ega> linkedList = gAC.KWy;
        if (linkedList != null) {
            int i3 = 0;
            for (T t : linkedList) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    j.hxH();
                }
                T t2 = t;
                if (t2 == null || (t2.KHa & 1) != 0) {
                    h.INSTANCE.idkeyStat(1149, 6, 1, false);
                    i3 = i4;
                } else {
                    a[] aVarArr = this.pvx;
                    if (aVarArr == null || (aVar = aVarArr[i3]) == null) {
                        i3 = i4;
                    } else {
                        p.h(zVar, "info");
                        p.h(gAC, "recCard");
                        p.h(t2, "appMsg");
                        String str = t2.Title;
                        String str2 = t2.KSj;
                        int i5 = t2.iAb;
                        String str3 = t2.KSl;
                        long j2 = t2.KWq;
                        String rJ = m.rJ(t2.KSx);
                        String str4 = "";
                        if (j2 > 0) {
                            if (j2 < 10000) {
                                str4 = String.valueOf(j2);
                            } else if (j2 < 100000) {
                                ae aeVar = ae.SYK;
                                str4 = String.format("%.1f万", Arrays.copyOf(new Object[]{Float.valueOf(((float) j2) / 10000.0f)}, 1));
                                p.g(str4, "java.lang.String.format(format, *args)");
                            } else {
                                str4 = "10万+";
                            }
                        }
                        TextView textView = aVar.pvz;
                        if (!p.j(str4, "")) {
                            string = aVar.pvE.context.getString(R.string.aj5, str4);
                        }
                        textView.setText(string);
                        aVar.pvz.setShadowLayer(2.0f, 0.0f, 0.0f, aVar.pvE.context.getResources().getColor(R.color.BW_0_Alpha_0_8));
                        aVar.pvA.setText(rJ);
                        aVar.pvA.setShadowLayer(2.0f, 0.0f, 0.0f, aVar.pvE.context.getResources().getColor(R.color.BW_0_Alpha_0_8));
                        aVar.pvB.setText(str);
                        aVar.hVd.setOnClickListener(new a.View$OnClickListenerC0880a(aVar, zVar, t2, i3));
                        if (((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1) && !Util.isNullOrNil(str2)) {
                            ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(str2, i5, 90, new Object[0]);
                        }
                        float fromDPToPix = ((((float) b.prq) * 2.35f) - ((float) com.tencent.mm.cb.a.fromDPToPix(aVar.pvE.context, 40.0f))) / 2.0f;
                        int i6 = (int) (((double) fromDPToPix) / 1.77d);
                        ViewGroup.LayoutParams layoutParams = aVar.hVd.getLayoutParams();
                        ViewGroup.LayoutParams layoutParams2 = aVar.pvC.getLayoutParams();
                        layoutParams.width = (int) fromDPToPix;
                        layoutParams2.height = i6;
                        aVar.hVd.setLayoutParams(layoutParams);
                        aVar.pvC.setLayoutParams(layoutParams2);
                        aVar.pvy.setVisibility(0);
                        aVar.pvD.iAo = str3;
                        aVar.pvD.url = str3;
                        aVar.pvD.type = 5;
                        aVar.pvE.psQ.prc.a(zVar.field_msgId, i3, aVar.pvD, aVar.pvD.iAo, aVar.pvy, (int) fromDPToPix, i6, false, (m.a) new a.b(), zVar.pxD + i3, (float) com.tencent.mm.cb.a.fromDPToPix(aVar.pvE.context, 4.0f));
                        i3 = i4;
                    }
                }
            }
        }
        c.x(zVar);
        AppMethodBeat.o(195390);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.w
    public final void du(View view) {
        AppMethodBeat.i(195391);
        p.h(view, "parent");
        if (this.puO == null) {
            View inflate = ((ViewStub) view.findViewById(R.id.j7z)).inflate();
            p.g(inflate, "this");
            dv(inflate);
            View findViewById = inflate.findViewById(R.id.a6m);
            p.g(findViewById, "this.findViewById(R.id.biz_rec_card_finder_video1)");
            View findViewById2 = inflate.findViewById(R.id.a6n);
            p.g(findViewById2, "this.findViewById(R.id.biz_rec_card_finder_video2)");
            this.pvx = new a[]{new a(this, findViewById), new a(this, findViewById2)};
            this.puO = inflate;
        }
        AppMethodBeat.o(195391);
    }

    public final void hide() {
        AppMethodBeat.i(195392);
        View view = this.puO;
        if (view != null) {
            view.setVisibility(8);
            AppMethodBeat.o(195392);
            return;
        }
        AppMethodBeat.o(195392);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo;", "", "parent", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;Landroid/view/View;)V", "bizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "coverRl", "Landroid/widget/RelativeLayout;", "getCoverRl", "()Landroid/widget/RelativeLayout;", "imgCover", "Landroid/widget/ImageView;", "getImgCover", "()Landroid/widget/ImageView;", "getParent", "()Landroid/view/View;", "txtDesc", "Landroid/widget/TextView;", "getTxtDesc", "()Landroid/widget/TextView;", "txtDuration", "getTxtDuration", "txtTime", "getTxtTime", "refreshUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "recCard", "Lcom/tencent/mm/protocal/protobuf/TLRecCard;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", FirebaseAnalytics.b.INDEX, "", "plugin-brandservice_release"})
    public final class a {
        final View hVd;
        final TextView pvA;
        final TextView pvB;
        final RelativeLayout pvC;
        final com.tencent.mm.ag.v pvD = new com.tencent.mm.ag.v();
        final /* synthetic */ v pvE;
        final ImageView pvy;
        final TextView pvz;

        public a(v vVar, View view) {
            p.h(view, "parent");
            this.pvE = vVar;
            AppMethodBeat.i(195389);
            this.hVd = view;
            View findViewById = this.hVd.findViewById(R.id.a6o);
            p.g(findViewById, "parent.findViewById(R.id…_card_finder_video_cover)");
            this.pvy = (ImageView) findViewById;
            View findViewById2 = this.hVd.findViewById(R.id.a6r);
            p.g(findViewById2, "parent.findViewById(R.id…rd_finder_video_playtime)");
            this.pvz = (TextView) findViewById2;
            View findViewById3 = this.hVd.findViewById(R.id.a6q);
            p.g(findViewById3, "parent.findViewById(R.id…rd_finder_video_duration)");
            this.pvA = (TextView) findViewById3;
            View findViewById4 = this.hVd.findViewById(R.id.a6p);
            p.g(findViewById4, "parent.findViewById(R.id…c_card_finder_video_desc)");
            this.pvB = (TextView) findViewById4;
            View findViewById5 = this.hVd.findViewById(R.id.a6l);
            p.g(findViewById5, "parent.findViewById(R.id.biz_rec_card_finder_rl)");
            this.pvC = (RelativeLayout) findViewById5;
            AppMethodBeat.o(195389);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.item.v$a$a  reason: collision with other inner class name */
        public static final class View$OnClickListenerC0880a implements View.OnClickListener {
            final /* synthetic */ z prL;
            final /* synthetic */ ega puV;
            final /* synthetic */ int puW;
            final /* synthetic */ a pvF;

            View$OnClickListenerC0880a(a aVar, z zVar, ega ega, int i2) {
                this.pvF = aVar;
                this.prL = zVar;
                this.puV = ega;
                this.puW = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(195388);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.pvF.pvE.a(this.prL, this.puV, view, this.puW);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(195388);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder$BizTLRecCardVideo$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
        public static final class b implements m.a {
            b() {
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onFinish() {
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onStart() {
            }
        }
    }
}
