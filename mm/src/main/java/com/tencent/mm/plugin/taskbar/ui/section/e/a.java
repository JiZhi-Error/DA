package com.tencent.mm.plugin.taskbar.ui.section.e;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.ui.section.g;
import com.tencent.mm.plugin.taskbar.ui.section.other.a;
import com.tencent.mm.plugin.taskbar.ui.section.other.b;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/webview/TaskBarSectionOtherViewWebViewHelper;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getDefaultImageRes", "", "data", "getSubtitle", "", "loadFallbackImage", "", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "onBindViewHolder", "pos", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "plugin-taskbar_release"})
public final class a extends b {
    private MultiTaskInfo Agu;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b.a aVar) {
        super(aVar);
        p.h(aVar, "callback");
        AppMethodBeat.i(263661);
        AppMethodBeat.o(263661);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    public final void a(int i2, a.b bVar, g gVar) {
        AppMethodBeat.i(263657);
        p.h(bVar, "viewHolder");
        p.h(gVar, "viewModel");
        super.a(i2, bVar, gVar);
        MultiTaskInfo multiTaskInfo = gVar.FVI.get(i2);
        if (multiTaskInfo == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.model.MultiTaskInfo");
            AppMethodBeat.o(263657);
            throw tVar;
        }
        this.Agu = multiTaskInfo;
        TextView textView = bVar.hbb;
        p.g(textView, "viewHolder.title");
        textView.setText(gVar.FVI.get(i2).erh().title);
        AppMethodBeat.o(263657);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    public final String o(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(263658);
        String aI = com.tencent.mm.cb.a.aI(MMApplicationContext.getContext(), R.string.j7z);
        p.g(aI, "ResourceHelper.getString…section_subtitle_webview)");
        AppMethodBeat.o(263658);
        return aI;
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    public final void a(a.b bVar) {
        cru erh;
        String str = null;
        AppMethodBeat.i(263659);
        p.h(bVar, "viewHolder");
        if (this.Agu == null) {
            AppMethodBeat.o(263659);
            return;
        }
        fah fah = new fah();
        try {
            MultiTaskInfo multiTaskInfo = this.Agu;
            fah.parseFrom(multiTaskInfo != null ? multiTaskInfo.field_data : null);
        } catch (Throwable th) {
            Log.e("AppBrandDesktopSectionWebViewView", "WebMultiTaskData parse failed");
        }
        String str2 = fah.coverUrl;
        if (str2 == null) {
            MultiTaskInfo multiTaskInfo2 = this.Agu;
            if (!(multiTaskInfo2 == null || (erh = multiTaskInfo2.erh()) == null)) {
                str = erh.MwR;
            }
        } else {
            str = str2;
        }
        if (str != null) {
            q.bcV().a(str, bVar.image, e.Vbm);
            AppMethodBeat.o(263659);
            return;
        }
        AppMethodBeat.o(263659);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    public final int u(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(263660);
        p.h(multiTaskInfo, "data");
        AppMethodBeat.o(263660);
        return R.drawable.cw5;
    }
}
