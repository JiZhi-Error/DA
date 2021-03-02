package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.c.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J,\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010\t2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0006\u0010/\u001a\u00020#J\b\u00100\u001a\u00020#H\u0016J\u0018\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\tH\u0002J\u0006\u00104\u001a\u00020#R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "anchorAuthIcon", "Landroid/widget/ImageView;", "anchorExtAuthTv", "Landroid/widget/TextView;", "anchorExtFriendFollowCountTv", "anchorExtInfoLayout", "Landroid/widget/LinearLayout;", "anchorName", "anchorProfile", "avatar", "backBtn", "loadingProgressBar", "Landroid/widget/ProgressBar;", "needAnimation", "", "getNeedAnimation", "()Z", "setNeedAnimation", "(Z)V", "okBtn", "Landroid/widget/Button;", "rootContent", "Landroid/widget/RelativeLayout;", "title", "fillAnchorInfo", "", "authProfession", "friendFollowCount", "", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "show", "unMount", "updateBg", "bgUrl", "contactUsername", "updateFinishInfo", "plugin-finder_release"})
public final class bo extends d implements i {
    public final String TAG = "Finder.LiveVisitorAfterPlugin";
    private final ImageView hNZ;
    public final RelativeLayout hOm;
    final b hOy;
    private final Button hPX;
    private final TextView hbb;
    private final ImageView keC;
    private final TextView uuO;
    private final TextView uuP;
    private final LinearLayout uuQ;
    private final TextView uuR;
    private final TextView uuS;
    private final ImageView uuT;
    public final ProgressBar uuU;
    public boolean uuV;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bo(final ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statueMonitor");
        AppMethodBeat.i(247121);
        this.hOy = bVar;
        View findViewById = viewGroup.findViewById(R.id.ipm);
        p.g(findViewById, "root.findViewById(R.id.title)");
        this.hbb = (TextView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.mj);
        p.g(findViewById2, "root.findViewById(R.id.anchor_avatar)");
        this.keC = (ImageView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.mq);
        p.g(findViewById3, "root.findViewById(R.id.anchor_name)");
        this.uuO = (TextView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.j8n);
        p.g(findViewById4, "root.findViewById(R.id.visit_anchor_profile)");
        this.uuP = (TextView) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.eda);
        p.g(findViewById5, "root.findViewById(R.id.live_after_finish_btn)");
        this.hPX = (Button) findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.eeu);
        p.g(findViewById6, "root.findViewById(R.id.live_after_ui_root_group)");
        this.hOm = (RelativeLayout) findViewById6;
        View findViewById7 = viewGroup.findViewById(R.id.mo);
        p.g(findViewById7, "root.findViewById(R.id.anchor_ext_info_layout)");
        this.uuQ = (LinearLayout) findViewById7;
        View findViewById8 = viewGroup.findViewById(R.id.mm);
        p.g(findViewById8, "root.findViewById(R.id.anchor_ext_info_auth)");
        this.uuR = (TextView) findViewById8;
        View findViewById9 = viewGroup.findViewById(R.id.mn);
        p.g(findViewById9, "root.findViewById(R.id.a…_info_friend_floow_count)");
        this.uuS = (TextView) findViewById9;
        View findViewById10 = viewGroup.findViewById(R.id.mi);
        p.g(findViewById10, "root.findViewById(R.id.anchor_auth_icon)");
        this.uuT = (ImageView) findViewById10;
        View findViewById11 = viewGroup.findViewById(R.id.xx);
        p.g(findViewById11, "root.findViewById(R.id.back_icon)");
        this.hNZ = (ImageView) findViewById11;
        View findViewById12 = viewGroup.findViewById(R.id.ep_);
        p.g(findViewById12, "root.findViewById(R.id.loading_bar)");
        this.uuU = (ProgressBar) findViewById12;
        this.uuV = true;
        this.hPX.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.bo.AnonymousClass1 */
            final /* synthetic */ bo uuW;

            {
                this.uuW = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(247113);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.uuW.hOy.statusChange(b.c.hLD, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(247113);
            }
        });
        this.uuP.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.bo.AnonymousClass2 */
            final /* synthetic */ bo uuW;

            {
                this.uuW = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(247114);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String str = this.uuW.getLiveData().hwd;
                Intent intent = new Intent();
                intent.putExtra("finder_username", str);
                intent.putExtra("key_enter_profile_type", 11);
                ((aj) g.ah(aj.class)).enterFinderProfileUI(viewGroup.getContext(), intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(247114);
            }
        });
        TextView textView = this.hbb;
        ViewGroup.LayoutParams layoutParams = textView != null ? textView.getLayoutParams() : null;
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(247121);
            throw tVar;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin += au.getStatusBarHeight(MMApplicationContext.getContext());
        Button button = this.hPX;
        ViewGroup.LayoutParams layoutParams2 = button != null ? button.getLayoutParams() : null;
        if (layoutParams2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(247121);
            throw tVar2;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin += au.aD(MMApplicationContext.getContext());
        ao.a(this.hbb.getPaint(), 0.8f);
        ao.a(this.uuO.getPaint(), 0.8f);
        ao.a(this.hPX.getPaint(), 0.8f);
        this.hOm.setVisibility(8);
        this.uuU.setVisibility(8);
        this.hNZ.setImageDrawable(ar.m(viewGroup.getContext(), R.raw.icons_filled_back, -1));
        this.hNZ.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.bo.AnonymousClass3 */
            final /* synthetic */ bo uuW;

            {
                this.uuW = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(247115);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.uuW.hOy.statusChange(b.c.hLD, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(247115);
            }
        });
        viewGroup.setTranslationX((float) au.az(viewGroup.getContext()).x);
        AppMethodBeat.o(247121);
    }

    public final void gL(String str, String str2) {
        FinderContact finderContact;
        FinderContact finderContact2;
        String str3;
        AppMethodBeat.i(247117);
        com.tencent.mm.plugin.finder.live.util.g gVar = com.tencent.mm.plugin.finder.live.util.g.uwd;
        com.tencent.mm.plugin.finder.live.util.g.a(str2, getLiveData().uEu, this.hOm);
        m mVar = m.uJa;
        d<o> dka = m.dka();
        com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(str);
        ImageView imageView = this.keC;
        m mVar2 = m.uJa;
        dka.a(aVar, imageView, m.a(m.a.AVATAR));
        y yVar = y.vXH;
        FinderObject finderObject = getLiveData().uDz;
        if (!(finderObject == null || (finderContact2 = finderObject.contact) == null || (str3 = finderContact2.username) == null)) {
            str2 = str3;
        }
        FinderObject finderObject2 = getLiveData().uDz;
        this.uuO.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.hwr.getContext(), y.hf(str2, (finderObject2 == null || (finderContact = finderObject2.contact) == null) ? null : finderContact.nickname)));
        this.hOm.setVisibility(0);
        this.uuU.setVisibility(8);
        AppMethodBeat.o(247117);
    }

    public final void a(String str, int i2, FinderAuthInfo finderAuthInfo) {
        String str2;
        AppMethodBeat.i(247118);
        if (!Util.isNullOrNil(str) || i2 > 0) {
            Log.i(this.TAG, "authProfession:" + str + ", friendFollowCount:" + i2);
            this.uuQ.setVisibility(0);
            if (!Util.isNullOrNil(str)) {
                Context context = this.hwr.getContext();
                p.g(context, "root.context");
                String string = context.getResources().getString(R.string.cjs, str);
                p.g(string, "root.context.resources.g…act_auth, authProfession)");
                this.uuR.setText(string);
                this.uuR.setVisibility(0);
                str2 = string;
            } else {
                this.uuR.setVisibility(8);
                str2 = "";
            }
            String str3 = "";
            if (i2 > 0) {
                Context context2 = this.hwr.getContext();
                p.g(context2, "root.context");
                str3 = context2.getResources().getString(R.string.cov, k.Lv(i2));
                p.g(str3, "root.context.resources.g…umber(friendFollowCount))");
                this.uuS.setText(str3);
                this.uuS.setVisibility(0);
            } else {
                this.uuS.setVisibility(8);
            }
            Context context3 = this.hwr.getContext();
            p.g(context3, "root.context");
            Resources resources = context3.getResources();
            p.g(resources, "root.context.resources");
            int i3 = resources.getDisplayMetrics().widthPixels;
            Context context4 = this.hwr.getContext();
            p.g(context4, "root.context");
            int dimensionPixelOffset = context4.getResources().getDimensionPixelOffset(R.dimen.c5);
            TextPaint paint = this.uuR.getPaint();
            float measureText = paint.measureText(str3) + paint.measureText(str2) + ((float) dimensionPixelOffset);
            Context context5 = this.hwr.getContext();
            p.g(context5, "root.context");
            if (measureText + ((float) (context5.getResources().getDimensionPixelOffset(R.dimen.ce) * 2)) < ((float) i3)) {
                this.uuS.setPadding(dimensionPixelOffset, 0, 0, 0);
                this.uuQ.setOrientation(0);
            } else {
                this.uuS.setPadding(0, 0, 0, 0);
                this.uuQ.setOrientation(1);
            }
        } else {
            this.uuQ.setVisibility(8);
        }
        if (finderAuthInfo != null) {
            y yVar = y.vXH;
            y.a(this.uuT, finderAuthInfo, 0);
        }
        AppMethodBeat.o(247118);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        FinderAuthInfo finderAuthInfo;
        String str3;
        FinderAuthInfo finderAuthInfo2 = null;
        AppMethodBeat.i(247119);
        Log.i(this.TAG, "onSceneEnd errType:" + i2 + ", errCode:" + i3 + ", scene:" + qVar);
        if (qVar instanceof cn) {
            FinderContact cZk = ((cn) qVar).cZk();
            Log.i(this.TAG, "update bg,user page isOnlyFetchUserInfo:" + ((cn) qVar).twC + ", local username:" + getLiveData().hwd + ",contact username:" + (cZk != null ? cZk.username : null));
            if (((cn) qVar).twC && p.j(((cn) qVar).tuH, getLiveData().hwd)) {
                com.tencent.mm.kernel.b aAg = g.aAg();
                p.g(aAg, "MMKernel.network()");
                aAg.azz().b(3736, this);
                if (!(cZk == null || (str3 = cZk.headUrl) == null)) {
                    p.g(str3, LocaleUtil.ITALIAN);
                    String str4 = cZk.username;
                    if (str4 == null) {
                        str4 = getLiveData().hwd;
                    }
                    gL(str3, str4);
                }
                if (cZk == null || (finderAuthInfo = cZk.authInfo) == null) {
                    str2 = null;
                } else {
                    str2 = finderAuthInfo.authProfession;
                }
                int i4 = getLiveData().friendFollowCount;
                if (cZk != null) {
                    finderAuthInfo2 = cZk.authInfo;
                }
                a(str2, i4, finderAuthInfo2);
            }
        }
        AppMethodBeat.o(247119);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(247120);
        super.unMount();
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3736, this);
        AppMethodBeat.o(247120);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ bo uuW;

        public a(bo boVar) {
            this.uuW = boVar;
        }

        public final void run() {
            AppMethodBeat.i(247116);
            this.uuW.rg(0);
            AppMethodBeat.o(247116);
        }
    }
}
