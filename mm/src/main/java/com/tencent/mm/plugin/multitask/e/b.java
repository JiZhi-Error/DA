package com.tencent.mm.plugin.multitask.e;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitask.e.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper;", "", "()V", "MULTITASK_TIPS_CONFIG", "", "MULTITASK_TIPS_SHOW", "TAG", "showBottomSheet", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "callback", "Lcom/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$MultiTaskTipCallback;", "showTips", "MultiTaskTipCallback", "plugin-multitask_release"})
public final class b {
    public static final b Acc = new b();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$MultiTaskTipCallback;", "", "onTipCancel", "", "onTipHide", "onTipShow", "plugin-multitask_release"})
    public interface a {
        void erg();
    }

    static {
        AppMethodBeat.i(200642);
        AppMethodBeat.o(200642);
    }

    private b() {
    }

    public static void a(Activity activity, a aVar) {
        AppMethodBeat.i(200641);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("multitask_tips_config");
        boolean z = mmkv.getBoolean("multitask_tips_show", false);
        Log.i("MicroMsg.MultiTaskTipsHelper", "showTips, flag: ".concat(String.valueOf(z)));
        if (!z) {
            mmkv.putBoolean("multitask_tips_show", true);
            com.tencent.mm.ac.d.a(0, new d(activity, aVar));
            AppMethodBeat.o(200641);
            return;
        }
        aVar.erg();
        AppMethodBeat.o(200641);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ a Acf;
        final /* synthetic */ Activity msB;

        d(Activity activity, a aVar) {
            this.msB = activity;
            this.Acf = aVar;
        }

        public final void run() {
            AppMethodBeat.i(200640);
            b bVar = b.Acc;
            b.b(this.msB, this.Acf);
            AppMethodBeat.o(200640);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$showBottomSheet$1$1"})
    /* renamed from: com.tencent.mm.plugin.multitask.e.b$b  reason: collision with other inner class name */
    public static final class View$OnClickListenerC1518b implements View.OnClickListener {
        final /* synthetic */ a Acd;
        final /* synthetic */ a Ace;

        View$OnClickListenerC1518b(a aVar, a aVar2) {
            this.Acd = aVar;
            this.Ace = aVar2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(200638);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Acd.bMo();
            a aVar = this.Ace;
            if (aVar != null) {
                aVar.erg();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(200638);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$showBottomSheet$1$2"})
    public static final class c implements a.AbstractC1517a {
        final /* synthetic */ a Acd;
        final /* synthetic */ a Ace;

        c(a aVar, a aVar2) {
            this.Acd = aVar;
            this.Ace = aVar2;
        }

        @Override // com.tencent.mm.plugin.multitask.e.a.AbstractC1517a
        public final void onDismiss() {
            AppMethodBeat.i(200639);
            a aVar = this.Ace;
            if (aVar != null) {
                aVar.erg();
                AppMethodBeat.o(200639);
                return;
            }
            AppMethodBeat.o(200639);
        }
    }

    public static final /* synthetic */ void b(Activity activity, a aVar) {
        AppMethodBeat.i(200643);
        Log.i("MicroMsg.MultiTaskTipsHelper", "showBottomSheet");
        a aVar2 = new a(activity);
        aVar2.erk();
        aVar2.lJI.findViewById(R.id.fpm).setOnClickListener(new View$OnClickListenerC1518b(aVar2, aVar));
        ((ImageView) aVar2.lJI.findViewById(R.id.fpl)).setImageResource(R.drawable.ct5);
        aVar2.a(new c(aVar2, aVar));
        aVar2.dGm();
        AppMethodBeat.o(200643);
    }
}
