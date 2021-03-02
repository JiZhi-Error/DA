package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.ar;
import com.tencent.mm.plugin.finder.feed.model.f;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.t;

public final class FinderFeedLiveNoticeView extends LinearLayout {
    private final String TAG = "Finder.FinderFeedLiveNoticeView";
    private View gvQ;

    public FinderFeedLiveNoticeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(254819);
        setOrientation(0);
        View inflate = aa.jQ(getContext()).inflate(R.layout.aaw, this);
        p.g(inflate, "MMLayoutInflater.getInfl…live_notice_layout, this)");
        this.gvQ = inflate;
        AppMethodBeat.o(254819);
    }

    public FinderFeedLiveNoticeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(254820);
        setOrientation(0);
        View inflate = aa.jQ(getContext()).inflate(R.layout.aaw, this);
        p.g(inflate, "MMLayoutInflater.getInfl…live_notice_layout, this)");
        this.gvQ = inflate;
        AppMethodBeat.o(254820);
    }

    public static /* synthetic */ void a(FinderFeedLiveNoticeView finderFeedLiveNoticeView, Context context, awt awt, String str) {
        AppMethodBeat.i(254818);
        finderFeedLiveNoticeView.a(context, awt, str, false);
        AppMethodBeat.o(254818);
    }

    public final void a(Context context, awt awt, String str, boolean z) {
        AppMethodBeat.i(254817);
        p.h(context, "context");
        p.h(awt, "noticeInfo");
        p.h(str, ch.COL_USERNAME);
        TextView textView = (TextView) this.gvQ.findViewById(R.id.cm4);
        View findViewById = this.gvQ.findViewById(R.id.cm1);
        WeImageView weImageView = (WeImageView) this.gvQ.findViewById(R.id.cm2);
        p.g(textView, "noticeTips");
        Resources resources = context.getResources();
        y yVar = y.vXH;
        textView.setText(resources.getString(R.string.cn9, y.Gi(((long) awt.dvv) * 1000)));
        if (z) {
            textView.setTextColor(context.getResources().getColor(R.color.v9));
            textView.setTypeface(null, 0);
            findViewById.setBackgroundColor(context.getResources().getColor(R.color.vb));
            weImageView.setIconColor(context.getResources().getColor(R.color.v9));
            findViewById(R.id.cm3).setBackgroundResource(R.drawable.yo);
        } else {
            weImageView.setIconColor(context.getResources().getColor(R.color.BW_0_Alpha_0_5));
            textView.setTextColor(context.getResources().getColor(R.color.FG_0));
            findViewById.setBackgroundColor(context.getResources().getColor(R.color.BW_0_Alpha_0_1));
            findViewById(R.id.cm3).setBackgroundResource(R.drawable.yq);
        }
        TextView textView2 = (TextView) this.gvQ.findViewById(R.id.cm0);
        if (awt.status == 1) {
            setVisibility(0);
            p.g(textView2, "finderLiveBookBtn");
            textView2.setText(context.getResources().getString(R.string.ckq));
            if (z) {
                textView2.setTextColor(context.getResources().getColor(R.color.vj));
            } else {
                textView2.setTextColor(context.getResources().getColor(R.color.Link_80));
            }
        } else if (awt.status == 0) {
            if (getVisibility() == 0) {
                p.g(textView2, "finderLiveBookBtn");
                textView2.setText(context.getResources().getString(R.string.ckr));
                if (z) {
                    textView2.setTextColor(context.getResources().getColor(R.color.v6));
                } else {
                    textView2.setTextColor(context.getResources().getColor(R.color.FG_1));
                }
            } else {
                setVisibility(8);
            }
        }
        if (getVisibility() == 0) {
            textView2.setOnClickListener(new a(this, awt, textView2, context, z, str));
            AppMethodBeat.o(254817);
            return;
        }
        textView2.setOnClickListener(null);
        AppMethodBeat.o(254817);
    }

    public static final class a implements View.OnClickListener {
        final /* synthetic */ Context $context;
        final /* synthetic */ String hLl;
        final /* synthetic */ FinderFeedLiveNoticeView wmC;
        final /* synthetic */ awt wmD;
        final /* synthetic */ TextView wmE;
        final /* synthetic */ boolean wmF;

        a(FinderFeedLiveNoticeView finderFeedLiveNoticeView, awt awt, TextView textView, Context context, boolean z, String str) {
            this.wmC = finderFeedLiveNoticeView;
            this.wmD = awt;
            this.wmE = textView;
            this.$context = context;
            this.wmF = z;
            this.hLl = str;
        }

        public final void onClick(View view) {
            int i2;
            s.az azVar;
            AppMethodBeat.i(254816);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderFeedLiveNoticeView$upDateFinderLiveNotice$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.wmD.status == 1) {
                this.wmD.status = 0;
                i2 = 1;
                azVar = s.az.Book;
            } else {
                this.wmD.status = 1;
                i2 = 2;
                azVar = s.az.Cancle;
            }
            if (this.wmD.status == 1) {
                this.wmC.setVisibility(0);
                TextView textView = this.wmE;
                p.g(textView, "finderLiveBookBtn");
                textView.setText(this.$context.getResources().getString(R.string.ckq));
                if (this.wmF) {
                    this.wmE.setTextColor(this.$context.getResources().getColor(R.color.vj));
                } else {
                    this.wmE.setTextColor(this.$context.getResources().getColor(R.color.Link_80));
                }
            } else {
                this.wmC.setVisibility(0);
                TextView textView2 = this.wmE;
                p.g(textView2, "finderLiveBookBtn");
                textView2.setText(this.$context.getResources().getString(R.string.ckr));
                if (this.wmF) {
                    this.wmE.setTextColor(this.$context.getResources().getColor(R.color.v6));
                } else {
                    this.wmE.setTextColor(this.$context.getResources().getColor(R.color.FG_1));
                }
            }
            String str = this.hLl;
            String str2 = this.wmD.dDJ;
            if (str2 == null) {
                p.hyc();
            }
            p.g(str2, "noticeInfo.noticeId!!");
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            Context context = this.$context;
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(254816);
                throw tVar;
            }
            ar arVar = new ar(str, str2, i2, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((MMActivity) context).get(FinderReporterUIC.class)).dIx());
            g.azz().b(arVar);
            m mVar = m.vli;
            String str3 = this.hLl;
            bbn bbn = arVar.ttO;
            m.a(azVar, str3, 0, String.valueOf(bbn != null ? Integer.valueOf(bbn.tCE) : null));
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            f fVar = ((FinderLiveNoticePreLoadUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) this.$context).get(FinderLiveNoticePreLoadUIC.class)).wyi;
            String str4 = this.hLl;
            p.h(str4, "userName");
            fVar.bkj().removeMessages(fVar.tWk);
            fVar.bkj().sendMessage(fVar.bkj().obtainMessage(fVar.tWk, str4));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderFeedLiveNoticeView$upDateFinderLiveNotice$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254816);
        }
    }
}
