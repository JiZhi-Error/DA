package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isLiving", "", "minimizeBtn", "Landroid/widget/ImageView;", "minimizeBtnClickArea", "Landroid/widget/RelativeLayout;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class am extends a {
    Context context;
    final b hOp;
    boolean hSh;
    private final ImageView hSi;
    private final RelativeLayout hSj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public am(final ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208135);
        this.hOp = bVar;
        this.context = viewGroup.getContext();
        View findViewById = viewGroup.findViewById(R.id.ek0);
        p.g(findViewById, "root.findViewById(R.id.live_minimiza_icon_btn)");
        this.hSi = (ImageView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.ek1);
        p.g(findViewById2, "root.findViewById(R.id.l…miza_icon_btn_click_area)");
        this.hSj = (RelativeLayout) findViewById2;
        rg(4);
        ImageView imageView = this.hSi;
        Context context2 = viewGroup.getContext();
        p.g(context2, "root.context");
        imageView.setImageDrawable(ar.e(context2.getResources().getDrawable(R.raw.icons_outlined_mini_window), -1));
        this.hSj.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.am.AnonymousClass1 */
            final /* synthetic */ am hSk;

            {
                this.hSk = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208132);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/live/plugin/LiveMinimizePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())) {
                    Log.e("MicroMsg.LiveCoreMini", "showVideoTalking, permission denied");
                    b.C0376b.a(this.hSk.hOp, b.c.hLS);
                    RequestFloatWindowPermissionDialog.a(this.hSk.context, this.hSk.context.getString(R.string.ej9), new RequestFloatWindowPermissionDialog.a(this) {
                        /* class com.tencent.mm.live.c.am.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 hSl;

                        /* JADX WARN: Incorrect args count in method signature: ()V */
                        {
                            this.hSl = r1;
                        }

                        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
                        public final void onResultAllow(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                            AppMethodBeat.i(208129);
                            p.h(requestFloatWindowPermissionDialog, "dialog");
                            requestFloatWindowPermissionDialog.finish();
                            if (this.hSl.hSk.hSh) {
                                if (this.hSl.hSk.hOp.getLiveRole() == 1) {
                                    b.a aVar = com.tencent.mm.live.core.core.a.b.hyv;
                                    viewGroup.getContext();
                                    b.a.aDo().hAz.hzz = true;
                                } else {
                                    b.a aVar2 = com.tencent.mm.live.core.core.d.b.hCo;
                                    viewGroup.getContext();
                                    b.a.aEf().hAz.hzz = true;
                                }
                                Bundle bundle = new Bundle();
                                bundle.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 2);
                                bundle.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 12);
                                this.hSl.hSk.hOp.statusChange(b.c.hLQ, bundle);
                            }
                            AppMethodBeat.o(208129);
                        }

                        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
                        public final void onResultRefuse(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                            AppMethodBeat.i(208130);
                            p.h(requestFloatWindowPermissionDialog, "dialog");
                            requestFloatWindowPermissionDialog.finish();
                            b.C0376b.a(this.hSl.hSk.hOp, b.c.hLT);
                            AppMethodBeat.o(208130);
                        }

                        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
                        public final void onResultCancel(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                            AppMethodBeat.i(208131);
                            p.h(requestFloatWindowPermissionDialog, "dialog");
                            b.C0376b.a(this.hSl.hSk.hOp, b.c.hLU);
                            AppMethodBeat.o(208131);
                        }
                    }, false, com.tencent.mm.bq.a.apJ());
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 2);
                    bundle.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 12);
                    this.hSk.hOp.statusChange(b.c.hLQ, bundle);
                }
                a.a(this, "com/tencent/mm/live/plugin/LiveMinimizePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208132);
            }
        });
        AppMethodBeat.o(208135);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(208134);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (an.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
                rg(4);
                this.hSh = false;
                AppMethodBeat.o(208134);
                return;
            case 3:
            case 4:
                rg(0);
                this.hSh = true;
                AppMethodBeat.o(208134);
                return;
            case 5:
                if (this.hOp.getLiveRole() == 0) {
                    if (bundle == null || !bundle.getBoolean("PARAM_IS_ENTERING_COMMENT")) {
                        rg(0);
                        break;
                    } else {
                        rg(4);
                        AppMethodBeat.o(208134);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(208134);
    }
}
