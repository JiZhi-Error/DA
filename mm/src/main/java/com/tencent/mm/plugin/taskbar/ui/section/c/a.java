package com.tencent.mm.plugin.taskbar.ui.section.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.ui.section.other.a;
import com.tencent.mm.plugin.taskbar.ui.section.other.b;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/music/TaskBarSectionOtherViewMusicHelper;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "getDefaultImageRes", "", "data", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSubtitle", "", "loadFromUrl", "", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "musicMultiTaskData", "Lcom/tencent/mm/protocal/protobuf/MusicMultiTaskData;", "onBindViewHolder", "pos", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "plugin-taskbar_release"})
public final class a extends b {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b.a aVar) {
        super(aVar);
        p.h(aVar, "callback");
        AppMethodBeat.i(263614);
        AppMethodBeat.o(263614);
    }

    public static final /* synthetic */ void b(a.b bVar, cso cso) {
        AppMethodBeat.i(263615);
        a(bVar, cso);
        AppMethodBeat.o(263615);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
        if (r0 == null) goto L_0x0069;
     */
    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r7, com.tencent.mm.plugin.taskbar.ui.section.other.a.b r8, com.tencent.mm.plugin.taskbar.ui.section.g r9) {
        /*
        // Method dump skipped, instructions count: 165
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.taskbar.ui.section.c.a.a(int, com.tencent.mm.plugin.taskbar.ui.section.other.a$b, com.tencent.mm.plugin.taskbar.ui.section.g):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/taskbar/ui/section/music/TaskBarSectionOtherViewMusicHelper$onBindViewHolder$1$1"})
    /* renamed from: com.tencent.mm.plugin.taskbar.ui.section.c.a$a  reason: collision with other inner class name */
    static final class RunnableC1802a implements Runnable {
        final /* synthetic */ String CWb;
        final /* synthetic */ a VbO;
        final /* synthetic */ cso VbP;
        final /* synthetic */ a.b VbQ;

        RunnableC1802a(String str, a aVar, cso cso, a.b bVar) {
            this.CWb = str;
            this.VbO = aVar;
            this.VbP = cso;
            this.VbQ = bVar;
        }

        public final void run() {
            AppMethodBeat.i(263609);
            final Bitmap decodeFileWithSample = BitmapUtil.decodeFileWithSample(this.CWb, 512, 512);
            if (decodeFileWithSample != null) {
                Log.i("TaskBarSectionMusicView", "use cover path: " + this.CWb);
                this.VbQ.image.post(new Runnable() {
                    /* class com.tencent.mm.plugin.taskbar.ui.section.c.a.RunnableC1802a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(263607);
                        this.VbQ.image.setImageBitmap(decodeFileWithSample);
                        AppMethodBeat.o(263607);
                    }
                });
                AppMethodBeat.o(263609);
                return;
            }
            this.VbQ.image.post(new Runnable(this) {
                /* class com.tencent.mm.plugin.taskbar.ui.section.c.a.RunnableC1802a.AnonymousClass2 */
                final /* synthetic */ RunnableC1802a VbR;

                {
                    this.VbR = r1;
                }

                public final void run() {
                    AppMethodBeat.i(263608);
                    a.b(this.VbR.VbQ, this.VbR.VbP);
                    AppMethodBeat.o(263608);
                }
            });
            AppMethodBeat.o(263609);
        }
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    public final int u(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(263612);
        p.h(multiTaskInfo, "data");
        AppMethodBeat.o(263612);
        return R.drawable.cw2;
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.other.b
    public final String o(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(263613);
        String aI = com.tencent.mm.cb.a.aI(MMApplicationContext.getContext(), R.string.j7v);
        p.g(aI, "ResourceHelper.getString…r_section_subtitle_music)");
        AppMethodBeat.o(263613);
        return aI;
    }

    private static void a(a.b bVar, cso cso) {
        String str;
        AppMethodBeat.i(263611);
        bVar.image.setImageDrawable(null);
        css css = cso.jfy;
        if (css == null || (str = css.Ktp) == null) {
            str = cso.MxD;
        }
        if (str != null) {
            Log.i("TaskBarSectionMusicView", "use url: ".concat(String.valueOf(str)));
            q.bcV().a(str, bVar.image, e.Vbm);
            AppMethodBeat.o(263611);
            return;
        }
        AppMethodBeat.o(263611);
    }
}
