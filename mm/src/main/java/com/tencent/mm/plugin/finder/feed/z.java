package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.uu;
import com.tencent.mm.plugin.finder.feed.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderPoiFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dcd;
import com.tencent.mm.protocal.protobuf.dce;
import com.tencent.mm.protocal.protobuf.dck;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.eak;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.f;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract;", "", "()V", "PoiFeedPresenter", "PoiFeedViewCallback", "plugin-finder_release"})
public final class z {

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\rH\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "Companion", "plugin-finder_release"})
    public static final class a extends c.a {
        public static final C1172a tOX = new C1172a((byte) 0);

        static {
            AppMethodBeat.i(244016);
            AppMethodBeat.o(244016);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.z$a$a  reason: collision with other inner class name */
        public static final class C1172a {
            private C1172a() {
            }

            public /* synthetic */ C1172a(byte b2) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MMActivity mMActivity, BaseFinderFeedLoader baseFinderFeedLoader) {
            super(mMActivity, baseFinderFeedLoader);
            p.h(mMActivity, "context");
            p.h(baseFinderFeedLoader, "loader");
            AppMethodBeat.i(244015);
            BaseFinderFeedLoader baseFinderFeedLoader2 = this.tFM;
            FinderPoiFeedLoader finderPoiFeedLoader = (FinderPoiFeedLoader) (!(baseFinderFeedLoader2 instanceof FinderPoiFeedLoader) ? null : baseFinderFeedLoader2);
            if (finderPoiFeedLoader != null) {
                finderPoiFeedLoader.fetchEndCallback = new kotlin.g.a.b<IResponse<bo>, x>(this) {
                    /* class com.tencent.mm.plugin.finder.feed.z.a.AnonymousClass1 */
                    final /* synthetic */ a tOY;

                    {
                        this.tOY = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
                        eak eak;
                        dck dck;
                        String str;
                        String str2;
                        String str3;
                        String str4;
                        String str5;
                        String str6;
                        int i2;
                        String str7;
                        String str8;
                        String str9;
                        String str10;
                        String str11;
                        dcm dcm;
                        LinearLayout linearLayout;
                        AppMethodBeat.i(244009);
                        IResponse<bo> iResponse2 = iResponse;
                        p.h(iResponse2, LocaleUtil.ITALIAN);
                        c.b bVar = this.tOY.tMd;
                        if (!(bVar instanceof b)) {
                            bVar = null;
                        }
                        b bVar2 = (b) bVar;
                        if (bVar2 != null) {
                            p.h(iResponse2, "response");
                            if (!(!(iResponse2 instanceof FinderPoiFeedLoader.b) || (eak = ((FinderPoiFeedLoader.b) iResponse2).tWB) == null || (dck = eak.MZM) == null)) {
                                View view = bVar2.tOZ;
                                if (!(view == null || (linearLayout = (LinearLayout) view.findViewById(R.id.eny)) == null)) {
                                    linearLayout.setVisibility(0);
                                }
                                View view2 = bVar2.tOZ;
                                TextView textView = view2 != null ? (TextView) view2.findViewById(R.id.ge7) : null;
                                View view3 = bVar2.tOZ;
                                TextView textView2 = view3 != null ? (TextView) view3.findViewById(R.id.ge8) : null;
                                View view4 = bVar2.tOZ;
                                TextView textView3 = view4 != null ? (TextView) view4.findViewById(R.id.gdn) : null;
                                View view5 = bVar2.tOZ;
                                WeImageView weImageView = view5 != null ? (WeImageView) view5.findViewById(R.id.gdz) : null;
                                View view6 = bVar2.tOZ;
                                TextView textView4 = view6 != null ? (TextView) view6.findViewById(R.id.ge0) : null;
                                View view7 = bVar2.tOZ;
                                TextView textView5 = view7 != null ? (TextView) view7.findViewById(R.id.ge4) : null;
                                View view8 = bVar2.tOZ;
                                LinearLayout linearLayout2 = view8 != null ? (LinearLayout) view8.findViewById(R.id.eo4) : null;
                                View view9 = bVar2.tOZ;
                                TextView textView6 = view9 != null ? (TextView) view9.findViewById(R.id.gdo) : null;
                                View view10 = bVar2.tOZ;
                                TextView textView7 = view10 != null ? (TextView) view10.findViewById(R.id.ge3) : null;
                                View view11 = bVar2.tOZ;
                                TextView textView8 = view11 != null ? (TextView) view11.findViewById(R.id.ge9) : null;
                                StringBuilder sb = new StringBuilder();
                                eak eak2 = ((FinderPoiFeedLoader.b) iResponse2).tWB;
                                if (eak2 != null) {
                                    int i3 = eak2.MZN;
                                    bVar2.tPb = i3;
                                    Log.i("Finder.FinderPoiFeedUIContract.PoiFeedViewCallback", "refreshHeader poiSourceFlag:".concat(String.valueOf(i3)));
                                }
                                dcd dcd = dck.MHl;
                                if (!(dcd == null || (dcm = dcd.MGO) == null)) {
                                    bVar2.UIp = dcm.LbD;
                                    bVar2.UIq = dcm.LbC;
                                }
                                dcd dcd2 = dck.MHl;
                                b.a(bVar2, textView, dcd2 != null ? dcd2.Name : null, null, 12);
                                StringBuilder append = sb.append("Name=");
                                dcd dcd3 = dck.MHl;
                                if (dcd3 == null || (str = dcd3.Name) == null) {
                                    str = "";
                                }
                                append.append(str);
                                dcd dcd4 = dck.MHl;
                                b.a(bVar2, textView2, dcd4 != null ? dcd4.MGQ : null, null, 12);
                                dcd dcd5 = dck.MHl;
                                if (dcd5 == null || (str2 = dcd5.MGQ) == null) {
                                    str2 = "";
                                }
                                bVar2.tPa = str2;
                                StringBuilder sb2 = new StringBuilder();
                                if (bVar2.tPb != 4) {
                                    dcd dcd6 = dck.MHl;
                                    if (dcd6 == null || (str9 = dcd6.kdZ) == null) {
                                        str9 = "";
                                    }
                                    StringBuilder append2 = sb2.append(str9);
                                    dcd dcd7 = dck.MHl;
                                    if (dcd7 == null || (str10 = dcd7.kea) == null) {
                                        str10 = "";
                                    }
                                    StringBuilder append3 = append2.append(str10);
                                    dcd dcd8 = dck.MHl;
                                    if (dcd8 == null || (str11 = dcd8.MGT) == null) {
                                        str11 = "";
                                    }
                                    append3.append(str11);
                                }
                                dcd dcd9 = dck.MHl;
                                if (dcd9 == null || (str3 = dcd9.MGU) == null) {
                                    str3 = "";
                                }
                                sb2.append(str3);
                                String sb3 = sb2.toString();
                                p.g(sb3, "sb.toString()");
                                b.C1173b bVar3 = new b.C1173b(bVar2, iResponse2);
                                bVar2.a(textView3, sb3, Integer.valueOf((int) R.string.d4z), bVar3);
                                if (weImageView != null) {
                                    weImageView.setVisibility(textView3 != null ? textView3.getVisibility() : 8);
                                }
                                if (weImageView != null) {
                                    weImageView.setOnClickListener(new b.e(bVar3));
                                }
                                StringBuilder append4 = sb.append('|').append("Nation=");
                                dcd dcd10 = dck.MHl;
                                if (dcd10 == null || (str4 = dcd10.keh) == null) {
                                    str4 = "";
                                }
                                append4.append(str4);
                                StringBuilder append5 = sb.append('|').append("Province=");
                                dcd dcd11 = dck.MHl;
                                if (dcd11 == null || (str5 = dcd11.kdZ) == null) {
                                    str5 = "";
                                }
                                append5.append(str5);
                                String sb4 = sb.toString();
                                p.g(sb4, "sbReport.toString()");
                                bVar2.tPd = sb4;
                                dce dce = dck.MHs;
                                b.a(bVar2, textView4, (dce == null || (str8 = dce.MGW) == null) ? null : n.j(str8, "\n", " ", false), Integer.valueOf((int) R.string.d50), 8);
                                dcn dcn = dck.MHm;
                                List<String> b2 = (dcn == null || (str7 = dcn.MHL) == null) ? null : n.b(str7, new char[]{';'});
                                b.c cVar = new b.c(bVar2, iResponse2);
                                if ((b2 != null ? b2.size() : 0) > 1) {
                                    if (textView5 != null) {
                                        textView5.setText(bVar2.gte.getString(R.string.d53, new Object[]{""}));
                                    }
                                    if (textView5 != null) {
                                        textView5.setVisibility(0);
                                    }
                                    if (linearLayout2 != null) {
                                        linearLayout2.setVisibility(0);
                                    }
                                    if (linearLayout2 != null) {
                                        linearLayout2.removeAllViews();
                                    }
                                    if (b2 != null) {
                                        for (String str12 : b2) {
                                            TextView textView9 = new TextView(bVar2.gte);
                                            textView9.setText(str12);
                                            if (textView5 != null) {
                                                textView9.setLayoutParams(textView5.getLayoutParams());
                                            }
                                            if (linearLayout2 != null) {
                                                linearLayout2.addView(textView9);
                                            }
                                            b.a(textView9, str12, str12, new b.d(str12, textView5, linearLayout2, cVar, bVar2, iResponse2));
                                        }
                                    }
                                } else {
                                    if (linearLayout2 != null) {
                                        linearLayout2.setVisibility(8);
                                    }
                                    dcn dcn2 = dck.MHm;
                                    bVar2.a(textView5, dcn2 != null ? dcn2.MHL : null, Integer.valueOf((int) R.string.d53), new b.f(cVar, dck));
                                }
                                dcn dcn3 = dck.MHm;
                                if ((dcn3 != null ? dcn3.AAH : 0.0f) > 0.0f) {
                                    dcn dcn4 = dck.MHm;
                                    str6 = dcn4 != null ? dcn4.MHT : null;
                                } else {
                                    str6 = "";
                                }
                                b.a(bVar2, textView6, str6, Integer.valueOf((int) R.string.d52), 8);
                                if (!Util.isNullOrNil(((FinderPoiFeedLoader.b) iResponse2).tWD)) {
                                    if (textView7 != null) {
                                        textView7.setText(((FinderPoiFeedLoader.b) iResponse2).tWD);
                                    }
                                    if (textView7 != null) {
                                        textView7.setVisibility(0);
                                    }
                                } else if (textView7 != null) {
                                    textView7.setVisibility(8);
                                }
                                if (bVar2.tPb != 8) {
                                    MMActivity mMActivity = bVar2.gte;
                                    if (!(mMActivity instanceof FinderPoiFeedUI)) {
                                        mMActivity = null;
                                    }
                                    FinderPoiFeedUI finderPoiFeedUI = (FinderPoiFeedUI) mMActivity;
                                    if (finderPoiFeedUI != null) {
                                        e eVar = new e((Context) finderPoiFeedUI, 1, false);
                                        eVar.a(new FinderPoiFeedUI.f(finderPoiFeedUI));
                                        eVar.a(new FinderPoiFeedUI.g(finderPoiFeedUI));
                                        eVar.b(FinderPoiFeedUI.h.ucq);
                                        finderPoiFeedUI.addIconOptionMenu(FinderPoiFeedUI.tqu, R.drawable.bw_, new FinderPoiFeedUI.i(eVar));
                                    }
                                }
                                if (textView8 != null) {
                                    if (((FinderPoiFeedLoader.b) iResponse2).tWC) {
                                        bVar2.tPc = 1;
                                        i2 = 0;
                                    } else {
                                        bVar2.tPc = 0;
                                        i2 = 8;
                                    }
                                    textView8.setVisibility(i2);
                                }
                            }
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(244009);
                        return xVar;
                    }
                };
                AppMethodBeat.o(244015);
                return;
            }
            AppMethodBeat.o(244015);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void requestRefresh() {
            AppMethodBeat.i(244010);
            this.tFM.requestRefresh();
            AppMethodBeat.o(244010);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void boE() {
            AppMethodBeat.i(244011);
            this.tFM.requestLoadMore();
            AppMethodBeat.o(244011);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void dcp() {
            AppMethodBeat.i(244012);
            BaseFeedLoader.requestInit$default(this.tFM, false, 1, null);
            AppMethodBeat.o(244012);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final f dce() {
            AppMethodBeat.i(244013);
            c.b bVar = this.tMd;
            al dcs = bVar != null ? bVar.dcs() : null;
            if (dcs == null) {
                p.hyc();
            }
            f dcK = dcs.dcK();
            AppMethodBeat.o(244013);
            return dcK;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void dcb() {
            AppMethodBeat.i(244014);
            c.b bVar = this.tMd;
            if (bVar != null) {
                bVar.ab(this.tFM.getDataListJustForAdapter());
                AppMethodBeat.o(244014);
                return;
            }
            AppMethodBeat.o(244014);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ?\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010*H\u0002¢\u0006\u0002\u0010+J\u001a\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010&H\u0002J\b\u0010/\u001a\u000200H\u0016J\u0018\u00101\u001a\u0004\u0018\u00010\u00112\f\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0016J\n\u00105\u001a\u0004\u0018\u00010\u001aH\u0016J\n\u00106\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020:2\u0006\u0010\u0002\u001a\u00020;H\u0016J\u0018\u0010<\u001a\u0004\u0018\u00010\u00112\f\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0016J$\u0010=\u001a\u00020$2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030?2\u0006\u0010@\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020\u0005H\u0016J\b\u0010B\u001a\u00020$H\u0016J\u0014\u0010C\u001a\u00020$2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020F0EJ.\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020&2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u00112\f\u0010)\u001a\b\u0012\u0004\u0012\u00020$0*H\u0002J\b\u0010K\u001a\u00020\bH\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006M"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI;IIZ)V", "dynamicState", "", "getDynamicState", "()J", "setDynamicState", "(J)V", "poiCategories", "", "getPoiCategories", "()Ljava/lang/String;", "setPoiCategories", "(Ljava/lang/String;)V", "poiDetailReportStr", "getPoiDetailReportStr", "setPoiDetailReportStr", "poiHeader", "Landroid/view/View;", "poiLatitude", "", "poiLongitude", "poiSourceFlag", "getPoiSourceFlag", "()I", "setPoiSourceFlag", "(I)V", "configureTextView", "", "textView", "Landroid/widget/TextView;", "info", "resId", "onClick", "Lkotlin/Function0;", "(Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "generatePhoneTextView", "phone", "tvTel", "getActivity", "Lcom/tencent/mm/ui/MMActivity;", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshHeader", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "setClickSpan", "tv", "strAll", "strHighLight", "showHeaderOnDataEmpty", "Companion", "plugin-finder_release"})
    public static final class b extends c.b {
        public static final a tPe = new a((byte) 0);
        float UIp;
        float UIq;
        View tOZ;
        public String tPa;
        int tPb;
        public long tPc;
        public String tPd;

        static {
            AppMethodBeat.i(244035);
            AppMethodBeat.o(244035);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "phone", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$refreshHeader$1$phoneOnClickListener$1"})
        static final class c extends q implements kotlin.g.a.b<String, x> {
            final /* synthetic */ b tPf;
            final /* synthetic */ IResponse tPg;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(b bVar, IResponse iResponse) {
                super(1);
                this.tPf = bVar;
                this.tPg = iResponse;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(String str) {
                String str2 = null;
                AppMethodBeat.i(244018);
                String str3 = str;
                p.h(str3, "phone");
                Bundle bundle = new Bundle();
                uu uuVar = new uu();
                uuVar.ebc.context = this.tPf.gte;
                uuVar.ebc.ebd = str3;
                uuVar.ebc.ebf = bundle;
                EventCenter.instance.publish(uuVar);
                MMActivity mMActivity = this.tPf.gte;
                if (!(mMActivity instanceof FinderPoiFeedUI)) {
                    mMActivity = null;
                }
                FinderPoiFeedUI finderPoiFeedUI = (FinderPoiFeedUI) mMActivity;
                if (finderPoiFeedUI != null) {
                    k kVar = k.vfA;
                    FinderPoiFeedUI.a aVar = FinderPoiFeedUI.a.ACTION_CLICK_PHONE;
                    long j2 = finderPoiFeedUI.dem().tPc;
                    FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(finderPoiFeedUI);
                    bbn dIx = fH != null ? fH.dIx() : null;
                    eaa eaa = finderPoiFeedUI.den().tWy;
                    if (eaa != null) {
                        str2 = eaa.LIb;
                    }
                    k.a(aVar, j2, dIx, str2, finderPoiFeedUI.dem().tPd, finderPoiFeedUI.deo());
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244018);
                return xVar;
            }
        }

        public /* synthetic */ b(FinderPoiFeedUI finderPoiFeedUI) {
            this(finderPoiFeedUI, 81);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private b(FinderPoiFeedUI finderPoiFeedUI, int i2) {
            super(finderPoiFeedUI, 2, 81, false);
            p.h(finderPoiFeedUI, "context");
            AppMethodBeat.i(244034);
            this.tPa = "";
            this.tPd = "";
            AppMethodBeat.o(244034);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void dcv() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void a(RecyclerView.a<?> aVar, View view, int i2) {
            bbn dIx;
            AppMethodBeat.i(244024);
            p.h(aVar, "adapter");
            p.h(view, "view");
            int size = i2 - ((com.tencent.mm.view.recyclerview.g) aVar).RqM.size();
            if (size >= 0 && size < dcq().tFM.getSize()) {
                bo boVar = (bo) dcq().tFM.getDataListJustForAdapter().get(size);
                if (!(boVar instanceof BaseFinderFeed)) {
                    AppMethodBeat.o(244024);
                    return;
                }
                Log.i("Finder.FinderPoiFeedUIContract.PoiFeedViewCallback", "onClick " + size + " id:" + ((BaseFinderFeed) boVar).feedObject.getId() + ", pos:" + size + ", nonceId:" + ((BaseFinderFeed) boVar).feedObject.getObjectNonceId());
                Intent intent = new Intent();
                intent.putExtra("FEED_ID", ((BaseFinderFeed) boVar).feedObject.getId());
                intent.putExtra("FEED_NONCE_ID", ((BaseFinderFeed) boVar).feedObject.getObjectNonceId());
                intent.putExtra("TITLE_WORDING", "");
                intent.putExtra("GET_REL_SCENE", 17);
                intent.putExtra("POI_LATITUDE", this.UIp);
                intent.putExtra("POI_LONGITUDE", this.UIq);
                BaseFeedLoader.saveCacheToIntent$default(dcq().tFM, intent, j.listOf(boVar), dcq().tFM.getLastBuffer(), 0, null, 16, null);
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.W(this.gte, intent);
                FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
                if (!(fH == null || (dIx = fH.dIx()) == null)) {
                    k kVar = k.vfA;
                    k.a(dIx, ((BaseFinderFeed) boVar).feedObject.getId(), this.tLS.getRecyclerView());
                    AppMethodBeat.o(244024);
                    return;
                }
            }
            AppMethodBeat.o(244024);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final RecyclerView.LayoutManager eS(Context context) {
            AppMethodBeat.i(244025);
            p.h(context, "context");
            RecyclerView.LayoutManager eS = dcs().eS(context);
            AppMethodBeat.o(244025);
            return eS;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final RecyclerView.h getItemDecoration() {
            AppMethodBeat.i(244026);
            RecyclerView.h itemDecoration = dcs().getItemDecoration();
            AppMethodBeat.o(244026);
            return itemDecoration;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final String b(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244029);
            p.h(cVar, "reason");
            AppMethodBeat.o(244029);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final String c(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244030);
            p.h(cVar, "reason");
            AppMethodBeat.o(244030);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final boolean dcu() {
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class e implements View.OnClickListener {
            final /* synthetic */ kotlin.g.a.a UIr;

            e(kotlin.g.a.a aVar) {
                this.UIr = aVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(260231);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$refreshHeader$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.UIr.invoke();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$refreshHeader$1$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(260231);
            }
        }

        static /* synthetic */ void a(b bVar, TextView textView, String str, Integer num, int i2) {
            AppMethodBeat.i(244032);
            if ((i2 & 4) != 0) {
                num = null;
            }
            bVar.a(textView, str, num, (kotlin.g.a.a<x>) null);
            AppMethodBeat.o(244032);
        }

        /* access modifiers changed from: package-private */
        public final void a(TextView textView, String str, Integer num, kotlin.g.a.a<x> aVar) {
            TextView textView2;
            String str2;
            String string;
            AppMethodBeat.i(244031);
            if (!Util.isNullOrNil(str)) {
                if (textView != null) {
                    textView.setVisibility(0);
                }
                if (textView != null) {
                    if (num == null || (string = this.gte.getString(num.intValue(), new Object[]{str})) == null) {
                        textView2 = textView;
                        str2 = str;
                    } else {
                        str2 = string;
                        textView2 = textView;
                    }
                    textView2.setText(str2);
                }
                if (aVar != null) {
                    if (!(textView == null || str == null)) {
                        a(textView, textView.getText().toString(), str, aVar);
                    }
                    AppMethodBeat.o(244031);
                    return;
                }
                AppMethodBeat.o(244031);
            } else if (textView != null) {
                textView.setVisibility(8);
                AppMethodBeat.o(244031);
            } else {
                AppMethodBeat.o(244031);
            }
        }

        static void a(TextView textView, String str, String str2, kotlin.g.a.a<x> aVar) {
            int i2 = 0;
            AppMethodBeat.i(244033);
            int a2 = n.a((CharSequence) str, str2, 0, false, 6);
            int length = str2.length() + a2;
            if (a2 <= 0 || length > str.length()) {
                length = str.length();
            } else {
                i2 = a2;
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new g(aVar, textView), i2, length, 33);
            Context context = textView.getContext();
            p.g(context, "tv.context");
            textView.setHighlightColor(context.getResources().getColor(17170445));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(spannableString);
            AppMethodBeat.o(244033);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$setClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
        public static final class g extends ClickableSpan {
            final /* synthetic */ kotlin.g.a.a tPo;
            final /* synthetic */ TextView tPp;

            g(kotlin.g.a.a aVar, TextView textView) {
                this.tPo = aVar;
                this.tPp = textView;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(244022);
                p.h(view, "widget");
                this.tPo.invoke();
                AppMethodBeat.o(244022);
            }

            public final void updateDrawState(TextPaint textPaint) {
                AppMethodBeat.i(244023);
                p.h(textPaint, "ds");
                Context context = this.tPp.getContext();
                p.g(context, "tv.context");
                textPaint.setColor(context.getResources().getColor(R.color.Link_100));
                textPaint.setUnderlineText(false);
                textPaint.clearShadowLayer();
                AppMethodBeat.o(244023);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$refreshHeader$1$addressOnClickListener$1"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.z$b$b  reason: collision with other inner class name */
        static final class C1173b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ b tPf;
            final /* synthetic */ IResponse tPg;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1173b(b bVar, IResponse iResponse) {
                super(0);
                this.tPf = bVar;
                this.tPg = iResponse;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                eaa eaa;
                String str = null;
                AppMethodBeat.i(244017);
                BaseFinderFeedLoader baseFinderFeedLoader = this.tPf.dcr().tFM;
                if (!(baseFinderFeedLoader instanceof FinderPoiFeedLoader)) {
                    baseFinderFeedLoader = null;
                }
                FinderPoiFeedLoader finderPoiFeedLoader = (FinderPoiFeedLoader) baseFinderFeedLoader;
                if (!(finderPoiFeedLoader == null || (eaa = finderPoiFeedLoader.tWy) == null)) {
                    eaa.LbD = this.tPf.UIp;
                    eaa.LbC = this.tPf.UIq;
                    MMActivity mMActivity = this.tPf.gte;
                    if (!(mMActivity instanceof FinderPoiFeedUI)) {
                        mMActivity = null;
                    }
                    FinderPoiFeedUI finderPoiFeedUI = (FinderPoiFeedUI) mMActivity;
                    if (finderPoiFeedUI != null) {
                        k kVar = k.vfA;
                        FinderPoiFeedUI.a aVar = FinderPoiFeedUI.a.ACTION_GO_TO_MAP;
                        long j2 = finderPoiFeedUI.dem().tPc;
                        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                        FinderReporterUIC fH = FinderReporterUIC.a.fH(finderPoiFeedUI);
                        bbn dIx = fH != null ? fH.dIx() : null;
                        eaa eaa2 = finderPoiFeedUI.den().tWy;
                        if (eaa2 != null) {
                            str = eaa2.LIb;
                        }
                        k.a(aVar, j2, dIx, str, finderPoiFeedUI.dem().tPd, finderPoiFeedUI.deo());
                    }
                    y yVar = y.vXH;
                    MMActivity mMActivity2 = this.tPf.gte;
                    p.h(mMActivity2, "context");
                    p.h(eaa, FirebaseAnalytics.b.LOCATION);
                    axt axt = new axt();
                    axt.dTj = eaa.LbC;
                    axt.latitude = eaa.LbD;
                    axt.fuK = eaa.kea;
                    axt.kHV = eaa.kHV;
                    axt.ErZ = eaa.ErZ;
                    axt.LIb = "";
                    axt.Esb = eaa.Esb;
                    axt.country = eaa.country;
                    y.a((Context) mMActivity2, axt, false);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244017);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$refreshHeader$1$4$1", "com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$$special$$inlined$forEach$lambda$1"})
        static final class d extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ b tPf;
            final /* synthetic */ IResponse tPg;
            final /* synthetic */ String tPh;
            final /* synthetic */ TextView tPi;
            final /* synthetic */ LinearLayout tPj;
            final /* synthetic */ kotlin.g.a.b tPk;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(String str, TextView textView, LinearLayout linearLayout, kotlin.g.a.b bVar, b bVar2, IResponse iResponse) {
                super(0);
                this.tPh = str;
                this.tPi = textView;
                this.tPj = linearLayout;
                this.tPk = bVar;
                this.tPf = bVar2;
                this.tPg = iResponse;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* bridge */ /* synthetic */ x invoke() {
                AppMethodBeat.i(244019);
                this.tPk.invoke(this.tPh);
                x xVar = x.SXb;
                AppMethodBeat.o(244019);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class f extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b UIs;
            final /* synthetic */ dck UIt;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(kotlin.g.a.b bVar, dck dck) {
                super(0);
                this.UIs = bVar;
                this.UIt = dck;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* bridge */ /* synthetic */ x invoke() {
                String str;
                AppMethodBeat.i(260232);
                kotlin.g.a.b bVar = this.UIs;
                dcn dcn = this.UIt.MHm;
                if (dcn == null || (str = dcn.MHL) == null) {
                    str = "";
                }
                bVar.invoke(str);
                x xVar = x.SXb;
                AppMethodBeat.o(260232);
                return xVar;
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final View getEmptyView() {
            AppMethodBeat.i(244027);
            View findViewById = this.gte.findViewById(R.id.c3e);
            AppMethodBeat.o(244027);
            return findViewById;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final View getHeaderView() {
            AppMethodBeat.i(244028);
            this.tOZ = View.inflate(this.gte, R.layout.ai1, null);
            View view = this.tOZ;
            AppMethodBeat.o(244028);
            return view;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.gte;
        }
    }
}
