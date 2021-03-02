package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.r;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.t;

public final class c extends RecyclerView.v {
    private final String TAG = "Finder.MixSearchContactItemHolder";
    private ImageView gvv;
    private TextView jVO;
    private View jWr;
    private TextView tlQ;
    private TextView tlS;
    private TextView vuk;
    private LinearLayout vul;
    private TextView vum;
    private View vun;
    private ImageView vuo;
    private FinderLiveOnliveWidget vup;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view) {
        super(view);
        p.h(view, "itemView");
        AppMethodBeat.i(166801);
        View findViewById = view.findViewById(R.id.bsp);
        p.g(findViewById, "itemView.findViewById(R.id.divider_view)");
        this.jWr = findViewById;
        View findViewById2 = view.findViewById(R.id.x1);
        p.g(findViewById2, "itemView.findViewById(R.id.avatar_iv)");
        this.gvv = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.ir3);
        p.g(findViewById3, "itemView.findViewById(R.id.title_tv)");
        this.jVO = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.d88);
        p.g(findViewById4, "itemView.findViewById(R.id.follow_tv)");
        this.vuk = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.dy6);
        p.g(findViewById5, "itemView.findViewById(R.id.info_layout)");
        this.vul = (LinearLayout) findViewById5;
        View findViewById6 = view.findViewById(R.id.gia);
        p.g(findViewById6, "itemView.findViewById(R.id.profession_tv)");
        this.vum = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.bmu);
        p.g(findViewById7, "itemView.findViewById(R.id.desc_1_tv)");
        this.tlQ = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.bmv);
        p.g(findViewById8, "itemView.findViewById(R.id.desc_2_tv)");
        this.tlS = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.d81);
        p.g(findViewById9, "itemView.findViewById(R.id.follow_layout)");
        this.vun = findViewById9;
        View findViewById10 = view.findViewById(R.id.w1);
        p.g(findViewById10, "itemView.findViewById(R.id.auth_icon_iv)");
        this.vuo = (ImageView) findViewById10;
        View findViewById11 = view.findViewById(R.id.cw_);
        p.g(findViewById11, "itemView.findViewById(R.…inder_live_onlive_widget)");
        this.vup = (FinderLiveOnliveWidget) findViewById11;
        this.vup.post(new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.search.c.AnonymousClass1 */
            final /* synthetic */ c vuq;

            {
                this.vuq = r1;
            }

            public final void run() {
                AppMethodBeat.i(251303);
                Rect rect = new Rect();
                this.vuq.vup.getHitRect(rect);
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.bt);
                rect.inset(-dimensionPixelOffset, -dimensionPixelOffset);
                ViewParent parent = this.vuq.vup.getParent();
                if (parent == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.View");
                    AppMethodBeat.o(251303);
                    throw tVar;
                }
                ((View) parent).setTouchDelegate(new TouchDelegate(rect, this.vuq.vup));
                AppMethodBeat.o(251303);
            }
        });
        AppMethodBeat.o(166801);
    }

    public static /* synthetic */ void a(c cVar, bbz bbz, View.OnClickListener onClickListener, boolean z, int i2) {
        AppMethodBeat.i(251307);
        if ((i2 & 8) != 0) {
            z = true;
        }
        cVar.a(bbz, onClickListener, null, z);
        AppMethodBeat.o(251307);
    }

    public final void a(bbz bbz, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, boolean z) {
        int i2;
        FinderAuthInfo finderAuthInfo;
        AppMethodBeat.i(251306);
        p.h(bbz, "finderSearchInfo");
        p.h(onClickListener, "itemClickListener");
        if (z) {
            this.jWr.setVisibility(0);
        } else {
            this.jWr.setVisibility(8);
        }
        TextView textView = this.jVO;
        Context context = MMApplicationContext.getContext();
        i iVar = i.vvu;
        String str = bbz.LLd;
        if (str == null) {
            str = "";
        }
        textView.setText(l.d(context, i.auZ(str), this.jVO.getTextSize()));
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        FinderContact finderContact = bbz.contact;
        if (c.a.asJ(finderContact != null ? finderContact.username : null)) {
            this.vuk.setVisibility(0);
        } else {
            this.vuk.setVisibility(8);
        }
        if (bbz.friendFollowCount > 0) {
            this.vun.setVisibility(0);
            String str2 = "";
            String str3 = "";
            if (bbz.friendFollowCount > 0) {
                if (!Util.isNullOrNil(str2)) {
                    View view = this.aus;
                    p.g(view, "itemView");
                    str3 = view.getContext().getString(R.string.cov, k.Lv(bbz.friendFollowCount));
                    p.g(str3, "itemView.context.getStri…hInfo.friendFollowCount))");
                } else {
                    View view2 = this.aus;
                    p.g(view2, "itemView");
                    str2 = view2.getContext().getString(R.string.cov, k.Lv(bbz.friendFollowCount));
                    p.g(str2, "itemView.context.getStri…hInfo.friendFollowCount))");
                }
            }
            if (!Util.isNullOrNil(str2)) {
                this.tlQ.setText(str2);
                this.tlQ.setVisibility(0);
            } else {
                this.tlQ.setVisibility(8);
            }
            if (!Util.isNullOrNil(str3)) {
                this.tlS.setText(str3);
                this.tlS.setVisibility(0);
                i2 = 2;
            } else {
                this.tlS.setVisibility(8);
                i2 = 2;
            }
        } else {
            this.vun.setVisibility(8);
            i2 = 1;
        }
        m mVar = m.uJa;
        d<o> dka = m.dka();
        FinderContact finderContact2 = bbz.contact;
        com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(finderContact2 != null ? finderContact2.headUrl : null);
        ImageView imageView = this.gvv;
        m mVar2 = m.uJa;
        dka.a(aVar2, imageView, m.a(m.a.AVATAR));
        FinderContact finderContact3 = bbz.contact;
        if (finderContact3 != null && (finderAuthInfo = finderContact3.authInfo) != null) {
            y yVar = y.vXH;
            y.a(this.vuo, finderAuthInfo);
            switch (finderAuthInfo.authIconType) {
                case 1:
                    this.vuo.setVisibility(0);
                    this.vum.setVisibility(0);
                    if (Util.isNullOrNil(bbz.LLf)) {
                        this.vum.setText(finderAuthInfo.authProfession);
                    } else {
                        TextView textView2 = this.vum;
                        Context context2 = MMApplicationContext.getContext();
                        i iVar2 = i.vvu;
                        String str4 = bbz.LLf;
                        if (str4 == null) {
                            str4 = "";
                        }
                        textView2.setText(l.d(context2, i.auZ(str4), this.vum.getTextSize()));
                    }
                    i2++;
                    break;
                case 2:
                    this.vuo.setVisibility(0);
                    this.vum.setVisibility(8);
                    break;
                case 100:
                    this.vuo.setVisibility(8);
                    this.vum.setVisibility(8);
                    break;
                default:
                    this.vuo.setVisibility(8);
                    this.vum.setVisibility(8);
                    break;
            }
        } else {
            c cVar = this;
            cVar.vuo.setVisibility(8);
            cVar.vum.setVisibility(8);
        }
        View view3 = this.aus;
        p.g(view3, "itemView");
        view3.setTag(bbz);
        this.aus.setOnClickListener(onClickListener);
        this.aus.setOnLongClickListener(onLongClickListener);
        if (i2 <= 2) {
            this.vul.setGravity(16);
        } else {
            this.vul.setGravity(0);
        }
        FinderContact finderContact4 = bbz.contact;
        if (finderContact4 == null || finderContact4.liveStatus != 1) {
            this.vup.setVisibility(8);
        } else {
            this.vup.setVisibility(0);
            FinderLiveOnliveWidget finderLiveOnliveWidget = this.vup;
            if (finderLiveOnliveWidget != null) {
                finderLiveOnliveWidget.setOnClickListener(new b(this, bbz));
            }
        }
        dpz();
        AppMethodBeat.o(251306);
    }

    public static final class b implements View.OnClickListener {
        final /* synthetic */ c vuq;
        final /* synthetic */ bbz vur;

        b(c cVar, bbz bbz) {
            this.vuq = cVar;
            this.vur = bbz;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(251305);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder$onBindView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Context context = this.vuq.vup.getContext();
            p.g(context, "userOnLive.context");
            FinderContact finderContact = this.vur.contact;
            new r(context, finderContact != null ? finderContact.username : null, this.vuq.lR(), false).dzC();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder$onBindView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(251305);
        }
    }

    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ c vuq;

        a(c cVar) {
            this.vuq = cVar;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.i(251304);
            this.vuq.jVO.getViewTreeObserver().removeOnPreDrawListener(this);
            ViewParent parent = this.vuq.jVO.getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(251304);
                throw tVar;
            }
            int width = ((View) parent).getWidth();
            int i2 = 0;
            if (this.vuq.vup.getVisibility() == 0) {
                i2 = this.vuq.vup.getWidth() + ((int) this.vuq.vup.getResources().getDimension(R.dimen.cc)) + 0;
            }
            if (this.vuq.vuo.getVisibility() == 0) {
                i2 += this.vuq.vuo.getWidth() + ((int) this.vuq.vuo.getResources().getDimension(R.dimen.ct));
            }
            if (this.vuq.jVO.getWidth() + i2 > width) {
                this.vuq.jVO.setWidth(width - i2);
                Log.i(this.vuq.TAG, "adjustTitleTvSize titleW:" + this.vuq.jVO.getWidth() + ", containerW:" + width + ",iconW:" + i2);
            }
            AppMethodBeat.o(251304);
            return true;
        }
    }

    private final void dpz() {
        AppMethodBeat.i(251308);
        this.jVO.getViewTreeObserver().addOnPreDrawListener(new a(this));
        AppMethodBeat.o(251308);
    }
}
