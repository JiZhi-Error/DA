package com.tencent.mm.plugin.taskbar.ui.section.other;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.f;
import com.tencent.mm.plugin.taskbar.ui.section.g;
import com.tencent.mm.plugin.taskbar.ui.section.other.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "getCallback", "()Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "getDefaultImageRes", "", "data", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSubtitle", "", "loadFallbackImage", "", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "onBindViewHolder", "pos", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "shouldLoadSnapshot", "", "Callback", "Companion", "plugin-taskbar_release"})
public abstract class b {
    public static final C1805b Vcd = new C1805b((byte) 0);
    final a Vcc;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "", "removeItem", "", "pos", "", "plugin-taskbar_release"})
    public interface a {
        void removeItem(int i2);
    }

    public abstract String o(MultiTaskInfo multiTaskInfo);

    public abstract int u(MultiTaskInfo multiTaskInfo);

    public b(a aVar) {
        p.h(aVar, "callback");
        this.Vcc = aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Companion;", "", "()V", "TAG", "", "plugin-taskbar_release"})
    /* renamed from: com.tencent.mm.plugin.taskbar.ui.section.other.b$b  reason: collision with other inner class name */
    public static final class C1805b {
        private C1805b() {
        }

        public /* synthetic */ C1805b(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\tH\n¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, hxF = {"<anonymous>", "", "url", "", "view", "Landroid/view/View;", "bitmap", "Landroid/graphics/Bitmap;", "extraObj", "", "", "onImageLoadComplete", "(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;[Ljava/lang/Object;)V", "com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$onBindViewHolder$1$1"})
    public static final class c implements k {
        final /* synthetic */ a.b VbQ;
        final /* synthetic */ MultiTaskInfo Vce;
        final /* synthetic */ a.b Vcf;
        final /* synthetic */ b Vcg;
        final /* synthetic */ g Vch;
        final /* synthetic */ int uBS;

        c(MultiTaskInfo multiTaskInfo, a.b bVar, b bVar2, g gVar, int i2, a.b bVar3) {
            this.Vce = multiTaskInfo;
            this.Vcf = bVar;
            this.Vcg = bVar2;
            this.Vch = gVar;
            this.uBS = i2;
            this.VbQ = bVar3;
        }

        @Override // com.tencent.mm.av.a.c.k
        public final void a(String str, View view, final Bitmap bitmap, Object[] objArr) {
            AppMethodBeat.i(263636);
            Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "load snapshots done " + this.uBS + ' ' + this.Vce.field_id + ' ' + bitmap);
            this.Vcf.image.post(new Runnable(this) {
                /* class com.tencent.mm.plugin.taskbar.ui.section.other.b.c.AnonymousClass1 */
                final /* synthetic */ c Vci;

                {
                    this.Vci = r1;
                }

                public final void run() {
                    AppMethodBeat.i(263635);
                    if (bitmap != null) {
                        this.Vci.Vcf.image.setImageBitmap(bitmap);
                        AppMethodBeat.o(263635);
                        return;
                    }
                    Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "loadFallbackImage[bitmap is null] " + this.Vci.Vce.field_id);
                    this.Vci.Vcg.a(this.Vci.Vcf);
                    AppMethodBeat.o(263635);
                }
            });
            AppMethodBeat.o(263636);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$onBindViewHolder$1$2"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ a.b VbQ;
        final /* synthetic */ b Vcg;
        final /* synthetic */ g Vch;
        final /* synthetic */ int uBS;

        d(b bVar, g gVar, int i2, a.b bVar2) {
            this.Vcg = bVar;
            this.Vch = gVar;
            this.uBS = i2;
            this.VbQ = bVar2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(263637);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Vcg.Vcc.removeItem(this.VbQ.lR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(263637);
        }
    }

    public void a(a.b bVar) {
        p.h(bVar, "viewHolder");
    }

    public void a(int i2, a.b bVar, g gVar) {
        p.h(bVar, "viewHolder");
        p.h(gVar, "viewModel");
        MultiTaskInfo multiTaskInfo = gVar.FVI.get(i2);
        Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "onBind " + i2 + ' ' + multiTaskInfo.erh().title + ' ' + multiTaskInfo.field_type + ' ' + multiTaskInfo.field_id);
        TextView textView = bVar.orb;
        p.g(textView, "it.subTitle");
        textView.setText(o(multiTaskInfo));
        View view = bVar.Vca;
        p.g(view, "it.liveWidget");
        view.setVisibility(8);
        View view2 = bVar.Vcb;
        p.g(view2, "it.liveEndWidget");
        view2.setVisibility(8);
        ImageView imageView = bVar.EsM;
        p.g(imageView, "it.playBtn");
        imageView.setVisibility(8);
        ImageView imageView2 = bVar.VbZ;
        p.g(imageView2, "it.defaultImage");
        imageView2.setVisibility(0);
        bVar.VbZ.setImageResource(u(multiTaskInfo));
        bVar.image.setImageDrawable(null);
        ImageView imageView3 = bVar.image;
        p.g(imageView3, "it.image");
        imageView3.setBackground(null);
        p.h(multiTaskInfo, "data");
        g.a aVar = g.FVL;
        p.h(multiTaskInfo, "$this$shouldLoadSnapshot");
        if (g.a.axi(multiTaskInfo.field_type)) {
            f fVar = f.FSa;
            p.h(multiTaskInfo, "multiTaskInfo");
            String str = multiTaskInfo.field_id;
            p.g(str, "multiTaskInfo.field_id");
            String aGJ = f.aGJ(str);
            if (s.YS(aGJ)) {
                Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "load snapshots " + multiTaskInfo.field_id + ' ' + aGJ);
                q.bcV().a(aGJ, bVar.image, e.Vbn, new c(multiTaskInfo, bVar, this, gVar, i2, bVar));
            } else {
                Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "loadFallbackImage[file not exist] " + multiTaskInfo.field_id);
                a(bVar);
            }
        } else {
            Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "loadFallbackImage[disabled] " + multiTaskInfo.field_id);
            a(bVar);
        }
        bVar.hTd.setOnClickListener(new d(this, gVar, i2, bVar));
    }
}
