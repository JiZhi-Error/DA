package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.b.a;
import com.tencent.mm.live.b.m;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "micHeadIcon", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "kotlin.jvm.PlatformType", "micHeadTip", "Landroid/widget/TextView;", "loadSelfMicView", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class ak extends a {
    final b hOp;
    final TextView hRZ;
    private final MMAnimateView hSa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ak(final ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208128);
        this.hOp = bVar;
        this.hRZ = (TextView) viewGroup.findViewById(R.id.ejv);
        this.hSa = (MMAnimateView) viewGroup.findViewById(R.id.ejt);
        viewGroup.setVisibility(4);
        x xVar = x.hJf;
        a aHa = x.aHa();
        AnonymousClass1 r0 = new r<Long, String, String, String, kotlin.x>(this) {
            /* class com.tencent.mm.live.c.ak.AnonymousClass1 */
            final /* synthetic */ ak hSb;

            {
                this.hSb = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.r
            public final /* synthetic */ kotlin.x invoke(Long l, String str, String str2, String str3) {
                AppMethodBeat.i(208125);
                l.longValue();
                final String str4 = str;
                final String str5 = str3;
                p.h(str4, "uid");
                p.h(str2, "headImg");
                p.h(str5, "nickName");
                x xVar = x.hJf;
                x.GU(str4);
                com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                p.g(af, "MMKernel.service<IMessen…engerStorage::class.java)");
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str4);
                if (Kn != null) {
                    d.h(new a(this, Kn, str4));
                    x xVar2 = x.hJf;
                    String nickname = Kn.getNickname();
                    p.g(nickname, "contact.nickname");
                    x.GT(nickname);
                    m mVar = m.hGg;
                    String nickname2 = Kn.getNickname();
                    p.g(nickname2, "contact.nickname");
                    m.h(true, nickname2);
                }
                if (Kn == null) {
                    d.h(new kotlin.g.a.a<kotlin.x>(this) {
                        /* class com.tencent.mm.live.c.ak.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 hSc;

                        {
                            this.hSc = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ kotlin.x invoke() {
                            AppMethodBeat.i(208124);
                            if (this.hSc.hSb.hOp.getLiveRole() == 1) {
                                TextView textView = this.hSc.hSb.hRZ;
                                p.g(textView, "micHeadTip");
                                textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(viewGroup.getContext(), viewGroup.getContext().getString(R.string.ej0, str5)));
                            } else if (Util.isEqual(str4, z.aTY())) {
                                TextView textView2 = this.hSc.hSb.hRZ;
                                p.g(textView2, "micHeadTip");
                                textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(viewGroup.getContext(), viewGroup.getContext().getString(R.string.ej2)));
                            } else {
                                TextView textView3 = this.hSc.hSb.hRZ;
                                p.g(textView3, "micHeadTip");
                                textView3.setText(com.tencent.mm.pluginsdk.ui.span.l.c(viewGroup.getContext(), viewGroup.getContext().getString(R.string.ej1, str5)));
                            }
                            kotlin.x xVar = kotlin.x.SXb;
                            AppMethodBeat.o(208124);
                            return xVar;
                        }
                    });
                    x xVar3 = x.hJf;
                    x.GT(str5);
                    m mVar2 = m.hGg;
                    m.h(true, str5);
                }
                kotlin.x xVar4 = kotlin.x.SXb;
                AppMethodBeat.o(208125);
                return xVar4;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/live/plugin/LiveMicHeaderPlugin$1$1$1"})
            /* renamed from: com.tencent.mm.live.c.ak$1$a */
            static final class a extends q implements kotlin.g.a.a<kotlin.x> {
                final /* synthetic */ AnonymousClass1 hSc;
                final /* synthetic */ as hSd;
                final /* synthetic */ String hSe;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(AnonymousClass1 r2, as asVar, String str) {
                    super(0);
                    this.hSc = r2;
                    this.hSd = asVar;
                    this.hSe = str;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.x invoke() {
                    AppMethodBeat.i(208123);
                    if (this.hSc.hSb.hOp.getLiveRole() == 1) {
                        TextView textView = this.hSc.hSb.hRZ;
                        p.g(textView, "micHeadTip");
                        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(viewGroup.getContext(), viewGroup.getContext().getString(R.string.ej0, this.hSd.getNickname())));
                    } else if (Util.isEqual(this.hSe, z.aTY())) {
                        TextView textView2 = this.hSc.hSb.hRZ;
                        p.g(textView2, "micHeadTip");
                        textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(viewGroup.getContext(), viewGroup.getContext().getString(R.string.ej2)));
                    } else {
                        TextView textView3 = this.hSc.hSb.hRZ;
                        p.g(textView3, "micHeadTip");
                        textView3.setText(com.tencent.mm.pluginsdk.ui.span.l.c(viewGroup.getContext(), viewGroup.getContext().getString(R.string.ej1, this.hSd.getNickname())));
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(208123);
                    return xVar;
                }
            }
        };
        p.h(r0, "observer");
        aHa.hKQ = r0;
        this.hRZ.requestLayout();
        this.hSa.setImageResource(R.raw.live_micing_icon);
        AppMethodBeat.o(208128);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        com.tencent.mm.live.core.core.d.b aEf;
        AppMethodBeat.i(208127);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (al.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                if (bundle != null) {
                    String string = bundle.getString("PARAM_LIVE_WXID", "");
                    if (!TextUtils.isEmpty(string)) {
                        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                        p.g(af, "MMKernel.service<IMessen…engerStorage::class.java)");
                        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(string);
                        if (Kn != null) {
                            TextView textView = this.hRZ;
                            p.g(textView, "micHeadTip");
                            textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.hwr.getContext(), this.hwr.getContext().getString(R.string.ej0, Kn.getNickname())));
                            AppMethodBeat.o(208127);
                            return;
                        }
                    }
                    AppMethodBeat.o(208127);
                    return;
                }
                AppMethodBeat.o(208127);
                return;
            case 2:
                rg(0);
                AppMethodBeat.o(208127);
                return;
            case 3:
                rg(0);
                AppMethodBeat.o(208127);
                return;
            case 4:
            case 5:
                rg(8);
                m mVar = m.hGg;
                x xVar = x.hJf;
                m.h(false, x.aGz());
                x xVar2 = x.hJf;
                x.GT("");
                x xVar3 = x.hJf;
                x.GU("");
                AppMethodBeat.o(208127);
                return;
            case 6:
                rg(8);
                AppMethodBeat.o(208127);
                return;
            case 7:
                if (this.hOp.getLiveRole() == 1) {
                    b.a aVar = com.tencent.mm.live.core.core.a.b.hyv;
                    this.hwr.getContext();
                    aEf = b.a.aDo();
                } else {
                    b.a aVar2 = com.tencent.mm.live.core.core.d.b.hCo;
                    this.hwr.getContext();
                    aEf = b.a.aEf();
                }
                if (aEf.hAz.aDt() || aEf.hAz.aDu()) {
                    rg(0);
                    if (this.hOp.getLiveRole() != 1) {
                        x xVar4 = x.hJf;
                        if (!Util.isEqual(x.aGA(), z.aTY())) {
                            TextView textView2 = this.hRZ;
                            p.g(textView2, "micHeadTip");
                            Context context = this.hwr.getContext();
                            Context context2 = this.hwr.getContext();
                            x xVar5 = x.hJf;
                            textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, context2.getString(R.string.ej1, x.aGz())));
                            break;
                        } else {
                            TextView textView3 = this.hRZ;
                            p.g(textView3, "micHeadTip");
                            textView3.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.hwr.getContext(), this.hwr.getContext().getString(R.string.ej2)));
                            AppMethodBeat.o(208127);
                            return;
                        }
                    } else {
                        TextView textView4 = this.hRZ;
                        p.g(textView4, "micHeadTip");
                        Context context3 = this.hwr.getContext();
                        Context context4 = this.hwr.getContext();
                        x xVar6 = x.hJf;
                        textView4.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context3, context4.getString(R.string.ej0, x.aGz())));
                        AppMethodBeat.o(208127);
                        return;
                    }
                }
        }
        AppMethodBeat.o(208127);
    }
}
