package com.tencent.mm.plugin.taskbar.ui.section.a;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.ui.section.g;
import com.tencent.mm.plugin.taskbar.ui.section.other.a;
import com.tencent.mm.plugin.taskbar.ui.section.other.b;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0017R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/file/TaskBarSectionOtherViewFileHelper;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "imageRes", "", "Ljava/lang/Integer;", "getDefaultImageRes", "data", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSubtitle", "", "loadFallbackImage", "", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "onBindViewHolder", "pos", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "plugin-taskbar_release"})
public final class a extends b {
    private Integer VbN;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b.a aVar) {
        super(aVar);
        p.h(aVar, "callback");
        AppMethodBeat.i(263602);
        AppMethodBeat.o(263602);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    @SuppressLint({"ResourceType"})
    public final void a(int i2, a.b bVar, g gVar) {
        Integer valueOf;
        AppMethodBeat.i(263598);
        p.h(bVar, "viewHolder");
        p.h(gVar, "viewModel");
        super.a(i2, bVar, gVar);
        if (!(gVar.FVI.get(i2).field_type == 4)) {
            valueOf = Integer.valueOf((int) R.raw.float_ball_icon_fav_default);
        } else {
            valueOf = Integer.valueOf(r.bdt(gVar.FVI.get(i2).erh().gCr));
        }
        this.VbN = valueOf;
        TextView textView = bVar.hbb;
        p.g(textView, "viewHolder.title");
        com.tencent.mm.ce.g gxZ = com.tencent.mm.ce.g.gxZ();
        View view = bVar.aus;
        p.g(view, "viewHolder.itemView");
        TextView textView2 = bVar.hbb;
        p.g(textView2, "viewHolder.title");
        textView.setText(gxZ.a(view.getContext(), gVar.FVI.get(i2).erh().title, textView2.getTextSize()));
        AppMethodBeat.o(263598);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    public final String o(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(263599);
        if (multiTaskInfo == null) {
            AppMethodBeat.o(263599);
            return "";
        } else if (multiTaskInfo.field_type == 4) {
            String aI = com.tencent.mm.cb.a.aI(MMApplicationContext.getContext(), R.string.j7s);
            p.g(aI, "ResourceHelper.getString…ar_section_subtitle_file)");
            AppMethodBeat.o(263599);
            return aI;
        } else {
            String aI2 = com.tencent.mm.cb.a.aI(MMApplicationContext.getContext(), R.string.j7w);
            p.g(aI2, "ResourceHelper.getString…ar_section_subtitle_note)");
            AppMethodBeat.o(263599);
            return aI2;
        }
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    public final int u(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(263600);
        p.h(multiTaskInfo, "data");
        if (multiTaskInfo.field_type == 4) {
            AppMethodBeat.o(263600);
            return R.drawable.cw0;
        }
        AppMethodBeat.o(263600);
        return R.drawable.cw3;
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    public final void a(a.b bVar) {
        AppMethodBeat.i(263601);
        p.h(bVar, "viewHolder");
        bVar.image.setImageBitmap(null);
        AppMethodBeat.o(263601);
    }
}
