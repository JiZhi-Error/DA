package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderBottomDialogHelper;", "", "()V", "Companion", "plugin-finder_release"})
public final class c {
    private static final String TAG = TAG;
    public static final a wjK = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004J6\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fJ@\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJJ\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fJT\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion;", "", "()V", "TAG", "", "showConfirmDialog", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "Landroid/content/Context;", "title", "msg", "lok", "Landroid/content/DialogInterface$OnClickListener;", "lcancel", "ldismiss", "Landroid/content/DialogInterface$OnDismissListener;", "ok", "cancel", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static e a(Context context, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
            AppMethodBeat.i(254667);
            p.h(context, "context");
            e eVar = new e(context, 1, false);
            View inflate = View.inflate(context, R.layout.a9n, null);
            if (inflate == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
                AppMethodBeat.o(254667);
                throw tVar;
            }
            RoundedCornerFrameLayout roundedCornerFrameLayout = (RoundedCornerFrameLayout) inflate;
            TextView textView = (TextView) roundedCornerFrameLayout.findViewById(R.id.d0a);
            p.g(textView, "msgTv");
            textView.setText(Util.nullAsNil(str2));
            TextView textView2 = (TextView) roundedCornerFrameLayout.findViewById(R.id.d3x);
            if (!Util.isNullOrNil(str)) {
                p.g(textView2, "titleTv");
                textView2.setText(str);
            }
            Button button = (Button) roundedCornerFrameLayout.findViewById(R.id.g3k);
            if (!Util.isNullOrNil(str3)) {
                p.g(button, "okBtn");
                button.setText(str3);
            }
            Button button2 = (Button) roundedCornerFrameLayout.findViewById(R.id.aib);
            if (!Util.isNullOrNil(str4)) {
                p.g(button2, "cancelBtn");
                button2.setText(str4);
            }
            roundedCornerFrameLayout.s((float) at.fromDPToPix(context, 12), (float) at.fromDPToPix(context, 12), 0.0f, 0.0f);
            button.setOnClickListener(new View$OnClickListenerC1336a(eVar, onClickListener));
            button2.setOnClickListener(new b(eVar, onClickListener2));
            eVar.b(new C1337c(onDismissListener));
            eVar.a(new d(eVar, roundedCornerFrameLayout));
            eVar.Dm(true);
            eVar.dGm();
            AppMethodBeat.o(254667);
            return eVar;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.finder.view.c$a$a  reason: collision with other inner class name */
        public static final class View$OnClickListenerC1336a implements View.OnClickListener {
            final /* synthetic */ e $dialog;
            final /* synthetic */ DialogInterface.OnClickListener $lok;

            View$OnClickListenerC1336a(e eVar, DialogInterface.OnClickListener onClickListener) {
                this.$dialog = eVar;
                this.$lok = onClickListener;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(254663);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion$showConfirmDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.$dialog.bMo();
                DialogInterface.OnClickListener onClickListener = this.$lok;
                if (onClickListener != null) {
                    onClickListener.onClick(null, -1);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion$showConfirmDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(254663);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class b implements View.OnClickListener {
            final /* synthetic */ e $dialog;
            final /* synthetic */ DialogInterface.OnClickListener $lcancel;

            b(e eVar, DialogInterface.OnClickListener onClickListener) {
                this.$dialog = eVar;
                this.$lcancel = onClickListener;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(254664);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion$showConfirmDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.$dialog.bMo();
                DialogInterface.OnClickListener onClickListener = this.$lcancel;
                if (onClickListener != null) {
                    onClickListener.onClick(null, -2);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion$showConfirmDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(254664);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
        /* renamed from: com.tencent.mm.plugin.finder.view.c$a$c  reason: collision with other inner class name */
        public static final class C1337c implements e.b {
            final /* synthetic */ DialogInterface.OnDismissListener $ldismiss;

            C1337c(DialogInterface.OnDismissListener onDismissListener) {
                this.$ldismiss = onDismissListener;
            }

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
                AppMethodBeat.i(254665);
                DialogInterface.OnDismissListener onDismissListener = this.$ldismiss;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(null);
                    AppMethodBeat.o(254665);
                    return;
                }
                AppMethodBeat.o(254665);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
        public static final class d implements o.f {
            final /* synthetic */ e $dialog;
            final /* synthetic */ RoundedCornerFrameLayout wjL;

            d(e eVar, RoundedCornerFrameLayout roundedCornerFrameLayout) {
                this.$dialog = eVar;
                this.wjL = roundedCornerFrameLayout;
            }

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(254666);
                mVar.clear();
                this.$dialog.setFooterView(null);
                this.$dialog.setFooterView(this.wjL);
                AppMethodBeat.o(254666);
            }
        }
    }

    static {
        AppMethodBeat.i(168222);
        AppMethodBeat.o(168222);
    }
}
