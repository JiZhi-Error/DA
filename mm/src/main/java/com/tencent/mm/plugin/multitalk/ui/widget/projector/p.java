package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.a.d;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010 \u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u001cJ\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "mCancelBtn", "Landroid/widget/TextView;", "mStopProjectAction", "Landroid/view/View;", "mStopProjectIconIv", "Landroid/widget/ImageView;", "mStopProjectTv", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "topUiLayout", "getTopUiLayout", "()Landroid/view/View;", "setTopUiLayout", "(Landroid/view/View;)V", "applyClickEvent", "", "getLandScapeLayout", "viewGroup", "Landroid/widget/FrameLayout;", "getPortraitLayout", "refreshLayout", "showReaderContent", "show", "", "plugin-multitalk_release"})
public final class p {
    Context context;
    TextView qCm;
    a zQD;
    View zXU;
    View zXV;
    TextView zXW;
    ImageView zXX;

    public p(Context context2, a aVar) {
        kotlin.g.b.p.h(context2, "context");
        kotlin.g.b.p.h(aVar, "statusManager");
        AppMethodBeat.i(240056);
        this.context = context2;
        this.zQD = aVar;
        AppMethodBeat.o(240056);
    }

    public final void eoD() {
        AppMethodBeat.i(240054);
        if (this.zXX != null) {
            ImageView imageView = this.zXX;
            if (imageView != null) {
                imageView.setBackground(ar.m(this.context, R.raw.icons_filled_stop, Color.parseColor("#FA5151")));
            }
        } else {
            View view = this.zXV;
            if (view != null) {
                view.setBackground(ar.m(this.context, R.drawable.a73, Color.parseColor("#FA5151")));
            }
            k.a aVar = k.zTz;
            if (k.a.gE(this.context) != 90) {
                k.a aVar2 = k.zTz;
                if (k.a.gE(this.context) != 270) {
                    TextView textView = this.zXW;
                    if (textView != null) {
                        textView.setText(R.string.geq);
                    }
                }
            }
            TextView textView2 = this.zXW;
            if (textView2 != null) {
                textView2.setText(R.string.gez);
            }
        }
        TextView textView3 = this.qCm;
        if (textView3 != null) {
            textView3.setVisibility(8);
            AppMethodBeat.o(240054);
            return;
        }
        AppMethodBeat.o(240054);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void epA() {
        /*
        // Method dump skipped, instructions count: 187
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.ui.widget.projector.p.epA():void");
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ p zXY;

        a(p pVar) {
            this.zXY = pVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(240049);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a.b.a(this.zXY.zQD, a.c.STOP_PROJECTOR);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240049);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ p zXY;

        b(p pVar) {
            this.zXY = pVar;
        }

        public final void onClick(View view) {
            Resources resources;
            Integer num = null;
            AppMethodBeat.i(240053);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI$applyClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.zXY.zQD.getCurrentStatus()) {
                d.a aVar = new d.a(this.zXY.context);
                Resources resources2 = this.zXY.context.getResources();
                aVar.boo(resources2 != null ? resources2.getString(R.string.gf0) : null);
                d.a c2 = aVar.aoV(R.string.gez).c(new DialogInterface.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.multitalk.ui.widget.projector.p.b.AnonymousClass1 */
                    final /* synthetic */ b zXZ;

                    {
                        this.zXZ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(240050);
                        a.b.a(this.zXZ.zXY.zQD, a.c.STOP_PROJECTOR);
                        ImageView imageView = this.zXZ.zXY.zXX;
                        if (imageView != null) {
                            imageView.setBackground(ar.m(this.zXZ.zXY.context, R.raw.icons_filled_start, Color.parseColor("#07C160")));
                        }
                        dialogInterface.dismiss();
                        AppMethodBeat.o(240050);
                    }
                });
                Context context = this.zXY.context;
                if (!(context == null || (resources = context.getResources()) == null)) {
                    num = Integer.valueOf(resources.getColor(R.color.Red));
                }
                if (num == null) {
                    kotlin.g.b.p.hyc();
                }
                c2.aoX(num.intValue());
                aVar.aoW(R.string.sz).d(AnonymousClass2.zYa);
                aVar.hbn().show();
            } else {
                if (this.zXY.zXX != null) {
                    ImageView imageView = this.zXY.zXX;
                    if (imageView != null) {
                        imageView.setBackground(ar.m(this.zXY.context, R.raw.icons_filled_stop, Color.parseColor("#FA5151")));
                    }
                } else {
                    View view2 = this.zXY.zXV;
                    if (view2 != null) {
                        view2.setBackground(ar.m(this.zXY.context, R.drawable.a73, Color.parseColor("#FA5151")));
                    }
                    TextView textView = this.zXY.zXW;
                    if (textView != null) {
                        textView.setText(R.string.geq);
                    }
                }
                a.b.a(this.zXY.zQD, a.c.START_PROJECTOR);
                TextView textView2 = this.zXY.qCm;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI$applyClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240053);
        }
    }
}
