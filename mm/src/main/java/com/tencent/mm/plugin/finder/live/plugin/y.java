package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.d;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.t;

public final class y extends d {
    private static boolean DEBUG;
    private static int uoU = 10;
    public static final a uoV = new a((byte) 0);
    private final String TAG = "Finder.FinderLiveCommonInfoPlugin";
    public boolean dMz;
    public long duration;
    private final com.tencent.mm.live.c.b hOp;
    private final TextView hPE;
    private final TextView hPF;
    private final TextView hPG;
    private final View hPH;
    private final View hPI;
    private final View hPJ;
    private final ImageView hPK;
    private final ImageView hPL;
    private final Drawable hPM;
    private final Drawable hPN;
    private final Drawable hPO;
    public int hPP;
    public String hPQ;
    private final ImageView rNa;
    boolean uoS = true;
    private final WeImageView uoT;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(final ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246620);
        this.hOp = bVar;
        View findViewById = viewGroup.findViewById(R.id.egq);
        p.g(findViewById, "root.findViewById(R.id.l…e_common_info_members_tv)");
        this.hPE = (TextView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.egk);
        p.g(findViewById2, "root.findViewById(R.id.l…_common_info_duration_tv)");
        this.hPF = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.egn);
        p.g(findViewById3, "root.findViewById(R.id.live_common_info_like_tv)");
        this.hPG = (TextView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.ego);
        p.g(findViewById4, "root.findViewById(R.id.l…ommon_info_members_group)");
        this.hPH = findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.egi);
        p.g(findViewById5, "root.findViewById(R.id.l…mmon_info_duration_group)");
        this.hPI = findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.egl);
        p.g(findViewById6, "root.findViewById(R.id.l…e_common_info_like_group)");
        this.hPJ = findViewById6;
        View findViewById7 = viewGroup.findViewById(R.id.egj);
        p.g(findViewById7, "root.findViewById(R.id.l…ommon_info_duration_icon)");
        this.hPK = (ImageView) findViewById7;
        View findViewById8 = viewGroup.findViewById(R.id.egh);
        p.g(findViewById8, "root.findViewById(R.id.l…e_common_info_arrow_icon)");
        this.hPL = (ImageView) findViewById8;
        View findViewById9 = viewGroup.findViewById(R.id.egm);
        p.g(findViewById9, "root.findViewById(R.id.live_common_info_like_icon)");
        this.rNa = (ImageView) findViewById9;
        View findViewById10 = viewGroup.findViewById(R.id.egp);
        p.g(findViewById10, "root.findViewById(R.id.l…common_info_members_icon)");
        this.uoT = (WeImageView) findViewById10;
        this.hPM = rh(R.raw.live_net_good_icon);
        this.hPN = rh(R.raw.live_net_normal_icon);
        this.hPO = rh(R.raw.live_net_bad_icon);
        e.h hVar = e.h.hya;
        this.hPP = e.h.aCS();
        this.hPQ = "00:00:00";
        c cVar = c.vCb;
        this.uoS = c.dwf().value().intValue() == 0;
        this.rNa.setImageDrawable(ar.m(viewGroup.getContext(), R.raw.icons_outlined_cheer, -1));
        this.hPH.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.y.AnonymousClass1 */
            final /* synthetic */ y uoW;

            {
                this.uoW = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246609);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                m mVar = m.vVH;
                if (m.dBP()) {
                    k kVar = k.vkd;
                    k.a(s.c.SEE_GIFT_LIST, String.valueOf(s.ak.CLICK_BEANSPROUTS_PULLUP_LIST_HALF_PAGE.action));
                } else {
                    if (y.r(this.uoW)) {
                        if (this.uoW.hOp.getLiveRole() == 0) {
                            com.tencent.mm.plugin.finder.report.live.m mVar2 = com.tencent.mm.plugin.finder.report.live.m.vli;
                            com.tencent.mm.plugin.finder.report.live.m.a(s.aw.CLICK_HOT_LIST_SEE_CUR_DOU_YOU, "", 0);
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(246609);
                }
                b.C0376b.a(this.uoW.hOp, b.c.hMU);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246609);
            }
        });
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.dCM()) {
            this.hPH.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.plugin.finder.live.plugin.y.AnonymousClass2 */

                public final boolean onLongClick(View view) {
                    boolean z;
                    AppMethodBeat.i(246612);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    a aVar = y.uoV;
                    a aVar2 = y.uoV;
                    if (!y.DEBUG) {
                        z = true;
                    } else {
                        z = false;
                    }
                    y.DEBUG = z;
                    a aVar3 = y.uoV;
                    if (y.DEBUG) {
                        final EditText editText = new EditText(viewGroup.getContext());
                        editText.setGravity(51);
                        editText.setTextSize(0, (float) d.e(viewGroup.getContext(), 15.0f));
                        editText.setMaxEms(80);
                        editText.setMaxLines(2);
                        editText.setEllipsize(TextUtils.TruncateAt.END);
                        m mVar = m.vVH;
                        m.a(editText, null, 80, 40, AnonymousClass1.uoX);
                        int paddingLeft = editText.getPaddingLeft();
                        Context context = viewGroup.getContext();
                        p.g(context, "root.context");
                        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.bt);
                        int paddingRight = editText.getPaddingRight();
                        Context context2 = viewGroup.getContext();
                        p.g(context2, "root.context");
                        editText.setPadding(paddingLeft, dimensionPixelOffset, paddingRight, context2.getResources().getDimensionPixelOffset(R.dimen.bt));
                        Context context3 = viewGroup.getContext();
                        p.g(context3, "root.context");
                        editText.setBackgroundColor(context3.getResources().getColor(R.color.BW_100_Alpha_0_9));
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        editText.setHeight(d.e(viewGroup.getContext(), 100.0f));
                        editText.setLayoutParams(layoutParams);
                        f.a aVar4 = new f.a(viewGroup.getContext());
                        aVar4.aC("测试").hu(editText);
                        aVar4.c(new f.c(this) {
                            /* class com.tencent.mm.plugin.finder.live.plugin.y.AnonymousClass2.AnonymousClass2 */
                            final /* synthetic */ AnonymousClass2 uoY;

                            {
                                this.uoY = r1;
                            }

                            @Override // com.tencent.mm.ui.widget.a.f.c
                            public final void e(boolean z, String str) {
                                String str2;
                                AppMethodBeat.i(246611);
                                Object systemService = viewGroup.getContext().getSystemService("input_method");
                                if (systemService == null) {
                                    t tVar = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                                    AppMethodBeat.o(246611);
                                    throw tVar;
                                }
                                ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                                a aVar = y.uoV;
                                Editable text = editText.getText();
                                if (text != null) {
                                    str2 = text.toString();
                                } else {
                                    str2 = null;
                                }
                                y.uoU = Util.safeParseInt(str2);
                                AppMethodBeat.o(246611);
                            }
                        }).show();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(246612);
                    return true;
                }
            });
        }
        this.uoT.setVisibility(8);
        Log.i(this.TAG, "frozenCommonInfoWhenMemberListShowing:" + this.uoS);
        AppMethodBeat.o(246620);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(246621);
        AppMethodBeat.o(246621);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public static final class b implements Runnable {
        final /* synthetic */ long ULj;
        final /* synthetic */ int hPS;
        final /* synthetic */ y uoW;
        final /* synthetic */ int upa;

        b(y yVar, int i2, int i3, long j2) {
            this.uoW = yVar;
            this.upa = i2;
            this.hPS = i3;
            this.ULj = j2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x01a2  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0228  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 644
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.plugin.y.b.run():void");
        }
    }

    public final void aHy() {
        AppMethodBeat.i(246617);
        m mVar = m.vVH;
        this.dMz = m.dBP();
        AppMethodBeat.o(246617);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(246618);
        super.unMount();
        AppMethodBeat.o(246618);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(246619);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (z.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                rg(8);
                break;
        }
        AppMethodBeat.o(246619);
    }

    public final void e(int i2, long j2, int i3) {
        AppMethodBeat.i(260602);
        this.hwr.post(new b(this, i3, i2, j2));
        AppMethodBeat.o(260602);
    }

    private final Drawable rh(int i2) {
        AppMethodBeat.i(246616);
        Context context = this.hwr.getContext();
        p.g(context, "root.context");
        Drawable drawable = context.getResources().getDrawable(i2);
        p.g(drawable, "root.context.resources.getDrawable(resId)");
        AppMethodBeat.o(246616);
        return drawable;
    }

    public static final /* synthetic */ boolean f(y yVar) {
        AppMethodBeat.i(246622);
        com.tencent.mm.live.c.b bVar = yVar.hOp;
        if (!(bVar instanceof FinderBaseLivePluginLayout)) {
            bVar = null;
        }
        FinderBaseLivePluginLayout finderBaseLivePluginLayout = (FinderBaseLivePluginLayout) bVar;
        ArrayList<com.tencent.mm.live.c.a> plugins = finderBaseLivePluginLayout != null ? finderBaseLivePluginLayout.getPlugins() : null;
        if (plugins != null) {
            for (T t : plugins) {
                if (t instanceof ap) {
                    if (t.hwr.getVisibility() == 0) {
                        AppMethodBeat.o(246622);
                        return true;
                    }
                    AppMethodBeat.o(246622);
                    return false;
                }
            }
        }
        AppMethodBeat.o(246622);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        if (r0 <= 0) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ boolean r(com.tencent.mm.plugin.finder.live.plugin.y r5) {
        /*
            r2 = 0
            r4 = 246623(0x3c35f, float:3.45592E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.tencent.mm.live.core.core.d.b$a r0 = com.tencent.mm.live.core.core.d.b.hCo
            boolean r0 = com.tencent.mm.live.core.core.d.b.a.aDp()
            if (r0 == 0) goto L_0x0030
            com.tencent.mm.plugin.finder.live.viewmodel.g r0 = r5.getLiveData()
            boolean r0 = r0.dja()
            if (r0 == 0) goto L_0x0030
            com.tencent.mm.plugin.finder.utils.m r0 = com.tencent.mm.plugin.finder.utils.m.vVH
            com.tencent.mm.plugin.finder.live.viewmodel.g r0 = r5.getLiveData()
            com.tencent.mm.protocal.protobuf.awe r0 = r0.liveInfo
            java.lang.Long r0 = com.tencent.mm.plugin.finder.utils.m.a(r0)
            if (r0 == 0) goto L_0x003d
            long r0 = r0.longValue()
        L_0x002c:
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0038
        L_0x0030:
            com.tencent.mm.plugin.finder.live.viewmodel.g r0 = r5.getLiveData()
            boolean r0 = r0.uFb
            if (r0 == 0) goto L_0x003f
        L_0x0038:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x003c:
            return r0
        L_0x003d:
            r0 = r2
            goto L_0x002c
        L_0x003f:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.plugin.y.r(com.tencent.mm.plugin.finder.live.plugin.y):boolean");
    }
}
