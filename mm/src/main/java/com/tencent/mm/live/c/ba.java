package com.tencent.mm.live.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.a.v;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.d.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010 \u001a\u00020\u000bJ\b\u0010!\u001a\u00020\u000bH\u0016J,\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010\u001b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00060"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveVerifyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVerify", "", "()Z", "setVerify", "(Z)V", "okBtn", "Landroid/widget/Button;", "selectIcon", "Landroid/widget/ImageView;", "verifyAgreementGruop", "Landroid/widget/LinearLayout;", "verifyAgreementLink", "Landroid/widget/TextView;", "verifyContentTip", "verifyIIcon", "verifyTitle", "verifyUrl", "", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "isMarkVerify", "onBackPress", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class ba extends a implements i {
    public static final a hSM = new a((byte) 0);
    private String hJl = "";
    private final b hOp;
    private final WeImageView hPV;
    private final Button hPX;
    private final TextView hQd;
    private final TextView hQe;
    private final ImageView hSH;
    private final WeImageView hSI;
    private final LinearLayout hSJ;
    private final TextView hSK;
    private boolean hSL;

    static {
        AppMethodBeat.i(208195);
        AppMethodBeat.o(208195);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveVerifyPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ba(final RelativeLayout relativeLayout, b bVar) {
        super(relativeLayout, bVar);
        p.h(relativeLayout, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208194);
        this.hOp = bVar;
        View findViewById = relativeLayout.findViewById(R.id.emy);
        p.g(findViewById, "root.findViewById(R.id.live_verify_ok_btn)");
        this.hPX = (Button) findViewById;
        View findViewById2 = relativeLayout.findViewById(R.id.en1);
        p.g(findViewById2, "root.findViewById(R.id.live_verify_top_back)");
        this.hPV = (WeImageView) findViewById2;
        View findViewById3 = relativeLayout.findViewById(R.id.emx);
        p.g(findViewById3, "root.findViewById(R.id.live_verify_item_selector)");
        this.hSH = (ImageView) findViewById3;
        View findViewById4 = relativeLayout.findViewById(R.id.emw);
        p.g(findViewById4, "root.findViewById(R.id.live_verify_icon)");
        this.hSI = (WeImageView) findViewById4;
        View findViewById5 = relativeLayout.findViewById(R.id.emz);
        p.g(findViewById5, "root.findViewById(R.id.live_verify_title)");
        this.hQd = (TextView) findViewById5;
        View findViewById6 = relativeLayout.findViewById(R.id.emv);
        p.g(findViewById6, "root.findViewById(R.id.live_verify_content_tip)");
        this.hQe = (TextView) findViewById6;
        View findViewById7 = relativeLayout.findViewById(R.id.emt);
        p.g(findViewById7, "root.findViewById(R.id.l…e_verify_agreement_group)");
        this.hSJ = (LinearLayout) findViewById7;
        View findViewById8 = relativeLayout.findViewById(R.id.ems);
        p.g(findViewById8, "root.findViewById(R.id.live_verify_agreement)");
        this.hSK = (TextView) findViewById8;
        this.hPV.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.ba.AnonymousClass1 */
            final /* synthetic */ ba hSN;

            {
                this.hSN = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208184);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.C0376b.a(this.hSN.hOp, b.c.hLD);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208184);
            }
        });
        this.hSH.setEnabled(true);
        this.hSH.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.ba.AnonymousClass2 */
            final /* synthetic */ ba hSN;

            {
                this.hSN = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208185);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.hSN.hSH.isActivated()) {
                    x xVar = x.hJf;
                    x.eJ(false);
                    this.hSN.hSH.setActivated(false);
                    this.hSN.hPX.setEnabled(false);
                } else {
                    x xVar2 = x.hJf;
                    x.eJ(true);
                    this.hSN.hSH.setActivated(true);
                    this.hSN.hPX.setEnabled(true);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208185);
            }
        });
        this.hPX.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.ba.AnonymousClass3 */
            final /* synthetic */ ba hSN;

            {
                this.hSN = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208186);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.hSN.hSH.isActivated()) {
                    o.f fVar = o.f.hGW;
                    MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV(o.f.aFC());
                    o.f fVar2 = o.f.hGW;
                    singleMMKV.putBoolean(o.f.aFD(), true);
                    com.tencent.mm.kernel.b aAg = g.aAg();
                    p.g(aAg, "MMKernel.network()");
                    aAg.azz().a(3895, this.hSN);
                    com.tencent.mm.kernel.b aAg2 = g.aAg();
                    p.g(aAg2, "MMKernel.network()");
                    aAg2.azz().b(new v());
                    Log.i("MicroMsg.LiveVerifyPlugin", "doscene NetSceneLiveVerify");
                } else {
                    Context context = relativeLayout.getContext();
                    Context context2 = relativeLayout.getContext();
                    p.g(context2, "root.context");
                    u.makeText(context, context2.getResources().getString(R.string.ehl), 0).show();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208186);
            }
        });
        this.hSK.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.live.c.ba.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(208187);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.LiveVerifyPlugin", "jumpToVerifyAgreementLink.");
                Intent intent = new Intent();
                intent.putExtra("title", relativeLayout.getContext().getString(R.string.ejx));
                intent.putExtra("rawUrl", relativeLayout.getContext().getString(R.string.ejv, LocaleUtil.getApplicationLanguage()));
                intent.putExtra("showShare", false);
                intent.putExtra("neverGetA8Key", true);
                c.b(relativeLayout.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208187);
            }
        });
        this.hSJ.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.ba.AnonymousClass5 */
            final /* synthetic */ ba hSN;

            {
                this.hSN = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208188);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.hSN.hSH.performClick();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208188);
            }
        });
        AppMethodBeat.o(208194);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(208190);
        p.h(cVar, "status");
        switch (bb.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                rg(0);
                x xVar = x.hJf;
                x.eI(true);
                break;
            case 2:
                if (this.hwr.getVisibility() == 0) {
                    x xVar2 = x.hJf;
                    String aGm = x.aGm();
                    x xVar3 = x.hJf;
                    boolean aGI = x.aGI();
                    x xVar4 = x.hJf;
                    boolean aGJ = x.aGJ();
                    x xVar5 = x.hJf;
                    String str = x.aGr().LpF;
                    x xVar6 = x.hJf;
                    boolean aGH = x.aGH();
                    Resources resources = this.hwr.getResources();
                    p.g(resources, "root.resources");
                    e.a(aGm, aGI, aGJ, str, aGH, resources.getConfiguration().orientation, 1);
                    com.tencent.mm.live.d.a.aHV();
                }
                rg(8);
                break;
            default:
                rg(8);
                break;
        }
        super.statusChange(cVar, bundle);
        AppMethodBeat.o(208190);
    }

    public static boolean aHK() {
        AppMethodBeat.i(208191);
        o.f fVar = o.f.hGW;
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV(o.f.aFC());
        o.f fVar2 = o.f.hGW;
        boolean z = singleMMKV.getBoolean(o.f.aFD(), false);
        AppMethodBeat.o(208191);
        return z;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(208192);
        if (qVar instanceof v) {
            com.tencent.mm.kernel.b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            aAg.azz().b(3895, this);
            if (i2 == 0 && i3 == 0) {
                if (p.j(((v) qVar).hKK, Boolean.TRUE)) {
                    z = true;
                } else {
                    z = false;
                }
                this.hSL = z;
                String str2 = ((v) qVar).hJl;
                if (str2 == null) {
                    str2 = "";
                }
                this.hJl = str2;
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(this.hSL);
                if (p.j(this.hJl, "")) {
                    z2 = true;
                }
                objArr[1] = Boolean.valueOf(z2);
                Log.i("MicroMsg.LiveVerifyPlugin", "NetSceneLiveVerify, isVerify:%b, verifyUrl null?:%b", objArr);
                if (this.hSL) {
                    this.hOp.statusChange(b.c.hLv, new Bundle());
                    AppMethodBeat.o(208192);
                    return;
                }
                x xVar = x.hJf;
                x.aGE().GW(this.hJl);
                x xVar2 = x.hJf;
                x.aGE().hJm = true;
                this.hOp.statusChange(b.c.hLw, new Bundle());
            } else {
                Log.e("MicroMsg.LiveVerifyPlugin", "NetSceneLiveVerify error, errType:" + i2 + " errCode:" + i3);
                AppMethodBeat.o(208192);
                return;
            }
        }
        AppMethodBeat.o(208192);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(208193);
        if (this.hwr.getVisibility() == 0) {
            this.hOp.statusChange(b.c.hLD, new Bundle());
            AppMethodBeat.o(208193);
            return true;
        }
        AppMethodBeat.o(208193);
        return false;
    }
}
